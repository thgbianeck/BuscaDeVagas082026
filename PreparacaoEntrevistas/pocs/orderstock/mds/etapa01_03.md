# OrderStock — Próxima etapa: consulta de disponibilidade de produto

Considerando que a etapa anterior foi concluída, agora implementaremos uma operação simples de consulta de disponibilidade de produto.

Nesta etapa:

- o `inventory-service` terá uma consulta de disponibilidade;
- os dados serão mantidos temporariamente em memória;
- o `order-service` consumirá essa consulta via `RestClient`;
- produtos inexistentes retornarão `404 Not Found`;
- quantidades inválidas retornarão `400 Bad Request`;
- estoque insuficiente retornará `200 OK` com `available: false`;
- ainda não haverá reserva ou alteração de estoque;
- serão criados testes unitários e testes de camada web.

Não implementaremos ainda:

- cadastro de produtos;
- banco de dados;
- reserva de estoque;
- criação de pedidos;
- mensageria;
- retry;
- circuit breaker;
- tratamento global definitivo de erros.

---

## 1. Objetivo da etapa

O objetivo é permitir que o cliente consulte a disponibilidade de um produto por meio do `order-service`.

O fluxo será:

~~~mermaid
sequenceDiagram
    participant Client as Cliente
    participant Order as order-service
    participant Inventory as inventory-service
    participant Repository as Repository em memória

    Client->>Order: GET /api/orders/products/1001/availability?quantity=3
    Order->>Inventory: GET /api/inventory/products/1001/availability?quantity=3
    Inventory->>Repository: Busca produto
    Repository-->>Inventory: Produto e quantidade
    Inventory-->>Order: 200 + disponibilidade
    Order-->>Client: 200 + disponibilidade
~~~

Quando o produto não existir:

~~~mermaid
sequenceDiagram
    participant Client as Cliente
    participant Order as order-service
    participant Inventory as inventory-service

    Client->>Order: Consulta disponibilidade
    Order->>Inventory: Consulta disponibilidade
    Inventory-->>Order: 404 Not Found
    Order-->>Client: 404 Not Found
~~~

---

## 2. Disponibilidade versus reserva

A consulta de disponibilidade apenas verifica se existe quantidade suficiente.

Ela não altera o estoque.

### Exemplo

~~~text
Produto: 1001
Estoque disponível: 10
Quantidade solicitada: 3
Resultado: disponível
~~~

Resposta:

~~~json
{
  "productId": 1001,
  "requestedQuantity": 3,
  "availableQuantity": 10,
  "available": true
}
~~~

Após a consulta, o estoque continua com `10`.

### Reserva de estoque

Uma reserva alteraria o estado:

~~~text
Estoque antes: 10
Quantidade reservada: 3
Estoque depois: 7
~~~

A reserva será implementada em uma etapa posterior.

---

## 3. Contrato do `inventory-service`

### Endpoint

~~~http
GET /api/inventory/products/{productId}/availability?quantity={quantity}
~~~

Exemplo:

~~~http
GET http://localhost:8081/api/inventory/products/1001/availability?quantity=3
~~~

### Produto disponível

~~~http
HTTP/1.1 200 OK
Content-Type: application/json
~~~

~~~json
{
  "productId": 1001,
  "requestedQuantity": 3,
  "availableQuantity": 10,
  "available": true
}
~~~

### Produto existente com estoque insuficiente

~~~http
GET /api/inventory/products/1001/availability?quantity=20
~~~

Resposta:

~~~http
HTTP/1.1 200 OK
~~~

~~~json
{
  "productId": 1001,
  "requestedQuantity": 20,
  "availableQuantity": 10,
  "available": false
}
~~~

O produto existe e a consulta foi processada com sucesso. Portanto, usamos `200 OK`. O campo `available` informa que a quantidade solicitada não está disponível.

### Produto inexistente

~~~http
HTTP/1.1 404 Not Found
~~~

O status `404` representa que o produto não foi encontrado.

### Quantidade inválida

Para quantidade igual a zero ou negativa:

~~~http
HTTP/1.1 400 Bad Request
~~~

Exemplo:

~~~http
GET /api/inventory/products/1001/availability?quantity=0
~~~

---

## 4. Decisão sobre os códigos HTTP

| Situação | Status | Motivo |
|---|---:|---|
| Produto existe e possui estoque | `200` | Consulta processada com sucesso |
| Produto existe, mas estoque insuficiente | `200` | Produto foi encontrado; disponibilidade é `false` |
| Produto não existe | `404` | Recurso não encontrado |
| Quantidade inválida | `400` | Requisição inválida |
| `inventory-service` indisponível | `503` | Serviço dependente indisponível |

Essa diferenciação evita confundir regras de negócio com falhas técnicas.

---

## 5. Estrutura esperada dos arquivos

### `inventory-service`

~~~text
inventory-service/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/orderstock/inventoryservice/
    │   │   ├── InventoryServiceApplication.java
    │   │   ├── controller/
    │   │   │   ├── HealthController.java
    │   │   │   └── ProductAvailabilityController.java
    │   │   ├── dto/
    │   │   │   ├── HealthResponse.java
    │   │   │   └── ProductAvailabilityResponse.java
    │   │   ├── exception/
    │   │   │   ├── InvalidQuantityException.java
    │   │   │   └── ProductNotFoundException.java
    │   │   ├── model/
    │   │   │   └── ProductStock.java
    │   │   ├── repository/
    │   │   │   └── ProductStockRepository.java
    │   │   └── service/
    │   │       └── ProductAvailabilityService.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/com/orderstock/inventoryservice/
            ├── controller/
            │   └── ProductAvailabilityControllerTest.java
            └── service/
                └── ProductAvailabilityServiceTest.java
~~~

### `order-service`

~~~text
order-service/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/com/orderstock/order/
    │       ├── client/
    │       │   └── InventoryClient.java
    │       ├── controller/
    │       │   └── ProductAvailabilityController.java
    │       ├── dto/
    │       │   └── ProductAvailabilityResponse.java
    │       ├── exception/
    │       │   └── ProductNotFoundException.java
    │       └── service/
    │           └── ProductAvailabilityService.java
    └── test/
        └── java/com/orderstock/order/
            ├── client/
            │   └── InventoryClientTest.java
            ├── controller/
            │   └── ProductAvailabilityControllerTest.java
            └── service/
                └── ProductAvailabilityServiceTest.java
~~~

---

## 6. Arquitetura das camadas

~~~mermaid
flowchart LR
    Client[Cliente] --> OrderController[order-service Controller]
    OrderController --> OrderService[order-service Service]
    OrderService --> InventoryClient[InventoryClient]
    InventoryClient -->|HTTP GET| InventoryController[inventory-service Controller]
    InventoryController --> InventoryService[inventory-service Service]
    InventoryService --> Repository[ProductStockRepository]
    Repository --> Memory[(Dados em memória)]
~~~

Responsabilidades:

- **Controller**: recebe e responde requisições HTTP;
- **Service**: executa regras de negócio;
- **Repository**: fornece dados;
- **Client**: realiza chamadas HTTP para outros serviços;
- **DTO**: representa contratos de entrada e saída;
- **Model**: representa estruturas internas do domínio.

---

# 7. Implementação do `inventory-service`

## 7.1 `ProductStock`

Arquivo:

~~~text
inventory-service/src/main/java/com/orderstock/inventoryservice/model/ProductStock.java
~~~

~~~java
package com.orderstock.inventoryservice.model;

public record ProductStock(
        Long productId,
        int availableQuantity
) {
}
~~~

Esse modelo representa o estoque mínimo necessário nesta etapa.

Ainda não serão incluídos:

- nome;
- preço;
- descrição;
- quantidade reservada;
- categoria;
- data de atualização.

A simplicidade é intencional.

---

## 7.2 `ProductAvailabilityResponse`

Arquivo:

~~~text
inventory-service/src/main/java/com/orderstock/inventoryservice/dto/ProductAvailabilityResponse.java
~~~

~~~java
package com.orderstock.inventoryservice.dto;

public record ProductAvailabilityResponse(
        Long productId,
        int requestedQuantity,
        int availableQuantity,
        boolean available
) {
}
~~~

Esse DTO representa o contrato público da API.

Não retornaremos diretamente `ProductStock`, porque o modelo interno não precisa ser igual ao contrato HTTP.

Essa separação permite:

- evolução independente;
- proteção do modelo interno;
- inclusão de campos calculados;
- estabilidade do contrato público.

---

## 7.3 `ProductNotFoundException`

Arquivo:

~~~text
inventory-service/src/main/java/com/orderstock/inventoryservice/exception/ProductNotFoundException.java
~~~

~~~java
package com.orderstock.inventoryservice.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long productId) {
        super("Product not found: " + productId);
    }
}
~~~

Essa exceção indica que o produto consultado não existe.

---

## 7.4 `InvalidQuantityException`

Arquivo:

~~~text
inventory-service/src/main/java/com/orderstock/inventoryservice/exception/InvalidQuantityException.java
~~~

~~~java
package com.orderstock.inventoryservice.exception;

public class InvalidQuantityException extends RuntimeException {

    public InvalidQuantityException(int quantity) {
        super("Quantity must be greater than zero. Received: " + quantity);
    }
}
~~~

Essa exceção indica que a quantidade solicitada é inválida.

---

## 7.5 `ProductStockRepository`

Arquivo:

~~~text
inventory-service/src/main/java/com/orderstock/inventoryservice/repository/ProductStockRepository.java
~~~

~~~java
package com.orderstock.inventoryservice.repository;

import com.orderstock.inventoryservice.model.ProductStock;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class ProductStockRepository {

    private final Map<Long, ProductStock> products = Map.of(
            1001L, new ProductStock(1001L, 10),
            1002L, new ProductStock(1002L, 0),
            1003L, new ProductStock(1003L, 25)
    );

    public Optional<ProductStock> findByProductId(Long productId) {
        return Optional.ofNullable(products.get(productId));
    }
}
~~~

### Dados iniciais

| Product ID | Available quantity |
|---:|---:|
| `1001` | `10` |
| `1002` | `0` |
| `1003` | `25` |

O `Map.of` cria um mapa imutável.

Isso é suficiente porque:

- a operação é somente de leitura;
- não haverá alteração de estoque;
- não precisamos de banco;
- o resultado será determinístico.

---

## 7.6 `ProductAvailabilityService`

Arquivo:

~~~text
inventory-service/src/main/java/com/orderstock/inventoryservice/service/ProductAvailabilityService.java
~~~

~~~java
package com.orderstock.inventoryservice.service;

import com.orderstock.inventoryservice.dto.ProductAvailabilityResponse;
import com.orderstock.inventoryservice.exception.InvalidQuantityException;
import com.orderstock.inventoryservice.exception.ProductNotFoundException;
import com.orderstock.inventoryservice.model.ProductStock;
import com.orderstock.inventoryservice.repository.ProductStockRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductAvailabilityService {

    private final ProductStockRepository productStockRepository;

    public ProductAvailabilityService(
            ProductStockRepository productStockRepository
    ) {
        this.productStockRepository = productStockRepository;
    }

    public ProductAvailabilityResponse checkAvailability(
            Long productId,
            int requestedQuantity
    ) {
        validateQuantity(requestedQuantity);

        ProductStock productStock = productStockRepository
                .findByProductId(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        boolean available =
                productStock.availableQuantity() >= requestedQuantity;

        return new ProductAvailabilityResponse(
                productStock.productId(),
                requestedQuantity,
                productStock.availableQuantity(),
                available
        );
    }

    private void validateQuantity(int requestedQuantity) {
        if (requestedQuantity <= 0) {
            throw new InvalidQuantityException(requestedQuantity);
        }
    }
}
~~~

### Regra implementada

A regra é:

|$$
available = availableQuantity \geq requestedQuantity
$$|

Exemplo:

~~~text
availableQuantity = 10
requestedQuantity = 3

10 >= 3
Resultado: true
~~~

Outro exemplo:

~~~text
availableQuantity = 10
requestedQuantity = 20

10 >= 20
Resultado: false
~~~

O Service é responsável por essa regra porque ela pertence ao domínio de estoque.

---

## 7.7 `ProductAvailabilityController`

Arquivo:

~~~text
inventory-service/src/main/java/com/orderstock/inventoryservice/controller/ProductAvailabilityController.java
~~~

~~~java
package com.orderstock.inventoryservice.controller;

import com.orderstock.inventoryservice.dto.ProductAvailabilityResponse;
import com.orderstock.inventoryservice.exception.InvalidQuantityException;
import com.orderstock.inventoryservice.exception.ProductNotFoundException;
import com.orderstock.inventoryservice.service.ProductAvailabilityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/inventory/products")
public class ProductAvailabilityController {

    private final ProductAvailabilityService productAvailabilityService;

    public ProductAvailabilityController(
            ProductAvailabilityService productAvailabilityService
    ) {
        this.productAvailabilityService = productAvailabilityService;
    }

    @GetMapping("/{productId}/availability")
    public ProductAvailabilityResponse checkAvailability(
            @PathVariable Long productId,
            @RequestParam int quantity
    ) {
        try {
            return productAvailabilityService.checkAvailability(
                    productId,
                    quantity
            );
        } catch (ProductNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    exception.getMessage(),
                    exception
            );
        } catch (InvalidQuantityException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    exception.getMessage(),
                    exception
            );
        }
    }
}
~~~

### Observação

O uso de `try/catch` no Controller é aceitável nesta etapa para manter o fluxo explícito.

Entretanto, isso pode gerar repetição em vários Controllers.

Em uma etapa futura, substituiremos essa abordagem por um tratamento global utilizando:

~~~java
@RestControllerAdvice
~~~

---

# 8. Testes do `inventory-service`

## 8.1 Teste unitário do Service

Arquivo:

~~~text
inventory-service/src/test/java/com/orderstock/inventoryservice/service/ProductAvailabilityServiceTest.java
~~~

~~~java
package com.orderstock.inventoryservice.service;

import com.orderstock.inventoryservice.dto.ProductAvailabilityResponse;
import com.orderstock.inventoryservice.exception.InvalidQuantityException;
import com.orderstock.inventoryservice.exception.ProductNotFoundException;
import com.orderstock.inventoryservice.model.ProductStock;
import com.orderstock.inventoryservice.repository.ProductStockRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductAvailabilityServiceTest {

    private final ProductStockRepository repository =
            mock(ProductStockRepository.class);

    private final ProductAvailabilityService service =
            new ProductAvailabilityService(repository);

    @Test
    void shouldReturnAvailableWhenStockIsEnough() {
        ProductStock productStock = new ProductStock(1001L, 10);

        when(repository.findByProductId(1001L))
                .thenReturn(Optional.of(productStock));

        ProductAvailabilityResponse response =
                service.checkAvailability(1001L, 3);

        assertThat(response.productId()).isEqualTo(1001L);
        assertThat(response.requestedQuantity()).isEqualTo(3);
        assertThat(response.availableQuantity()).isEqualTo(10);
        assertThat(response.available()).isTrue();
    }

    @Test
    void shouldReturnUnavailableWhenStockIsInsufficient() {
        ProductStock productStock = new ProductStock(1001L, 10);

        when(repository.findByProductId(1001L))
                .thenReturn(Optional.of(productStock));

        ProductAvailabilityResponse response =
                service.checkAvailability(1001L, 20);

        assertThat(response.available()).isFalse();
        assertThat(response.availableQuantity()).isEqualTo(10);
    }

    @Test
    void shouldThrowExceptionWhenProductDoesNotExist() {
        when(repository.findByProductId(9999L))
                .thenReturn(Optional.empty());

        assertThatThrownBy(
                () -> service.checkAvailability(9999L, 1)
        )
                .isInstanceOf(ProductNotFoundException.class);
    }

    @Test
    void shouldThrowExceptionWhenQuantityIsInvalid() {
        assertThatThrownBy(
                () -> service.checkAvailability(1001L, 0)
        )
                .isInstanceOf(InvalidQuantityException.class);
    }
}
~~~

### O que esse teste valida

- estoque suficiente;
- estoque insuficiente;
- produto inexistente;
- quantidade inválida;
- regra de cálculo da disponibilidade.

Esse é um teste unitário porque o Service é instanciado diretamente e o Repository é simulado.

---

## 8.2 Teste web do Controller

Arquivo:

~~~text
inventory-service/src/test/java/com/orderstock/inventoryservice/controller/ProductAvailabilityControllerTest.java
~~~

~~~java
package com.orderstock.inventoryservice.controller;

import com.orderstock.inventoryservice.dto.ProductAvailabilityResponse;
import com.orderstock.inventoryservice.exception.InvalidQuantityException;
import com.orderstock.inventoryservice.exception.ProductNotFoundException;
import com.orderstock.inventoryservice.service.ProductAvailabilityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductAvailabilityController.class)
class ProductAvailabilityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductAvailabilityService productAvailabilityService;

    @Test
    void shouldReturnProductAvailability() throws Exception {
        ProductAvailabilityResponse response =
                new ProductAvailabilityResponse(
                        1001L,
                        3,
                        10,
                        true
                );

        when(productAvailabilityService.checkAvailability(1001L, 3))
                .thenReturn(response);

        mockMvc.perform(
                        get("/api/inventory/products/1001/availability")
                                .param("quantity", "3")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(
                        MediaType.APPLICATION_JSON
                ))
                .andExpect(jsonPath("$.productId").value(1001))
                .andExpect(jsonPath("$.requestedQuantity").value(3))
                .andExpect(jsonPath("$.availableQuantity").value(10))
                .andExpect(jsonPath("$.available").value(true));
    }

    @Test
    void shouldReturnUnavailableWhenStockIsInsufficient()
            throws Exception {
        ProductAvailabilityResponse response =
                new ProductAvailabilityResponse(
                        1001L,
                        20,
                        10,
                        false
                );

        when(productAvailabilityService.checkAvailability(1001L, 20))
                .thenReturn(response);

        mockMvc.perform(
                        get("/api/inventory/products/1001/availability")
                                .param("quantity", "20")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.available").value(false));
    }

    @Test
    void shouldReturnNotFoundWhenProductDoesNotExist()
            throws Exception {
        when(productAvailabilityService.checkAvailability(9999L, 1))
                .thenThrow(new ProductNotFoundException(9999L));

        mockMvc.perform(
                        get("/api/inventory/products/9999/availability")
                                .param("quantity", "1")
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnBadRequestWhenQuantityIsInvalid()
            throws Exception {
        when(productAvailabilityService.checkAvailability(1001L, 0))
                .thenThrow(new InvalidQuantityException(0));

        mockMvc.perform(
                        get("/api/inventory/products/1001/availability")
                                .param("quantity", "0")
                )
                .andExpect(status().isBadRequest());
    }
}
~~~

---

# 9. Implementação no `order-service`

O `order-service` exporá um endpoint próprio e internamente chamará o `inventory-service`.

## Endpoint público

~~~http
GET /api/orders/products/{productId}/availability?quantity={quantity}
~~~

## Endpoint interno

~~~http
GET /api/inventory/products/{productId}/availability?quantity={quantity}
~~~

## Fluxo

~~~mermaid
flowchart LR
    Client[Cliente] --> OrderController[Order Controller]
    OrderController --> OrderService[Order Service]
    OrderService --> InventoryClient[InventoryClient]
    InventoryClient -->|HTTP GET| InventoryController[Inventory Controller]
    InventoryController --> InventoryService[Inventory Service]
    InventoryService --> Repository[Repository em memória]
~~~

---

## 9.1 DTO do `order-service`

Arquivo:

~~~text
order-service/src/main/java/com/orderstock/order/dto/ProductAvailabilityResponse.java
~~~

~~~java
package com.orderstock.order.dto;

public record ProductAvailabilityResponse(
        Long productId,
        int requestedQuantity,
        int availableQuantity,
        boolean available
) {
}
~~~

Mesmo que esse DTO tenha os mesmos campos do DTO do `inventory-service`, ele pertence ao `order-service`.

### Por que não compartilhar o DTO?

Compartilhar classes entre microsserviços pode criar acoplamento estrutural.

Se o `inventory-service` alterar sua classe, o `order-service` poderia ser afetado diretamente.

Cada serviço deve controlar:

- seus modelos;
- seus DTOs;
- seus contratos;
- sua evolução interna.

---

## 9.2 Exceção de produto inexistente

Arquivo:

~~~text
order-service/src/main/java/com/orderstock/order/exception/ProductNotFoundException.java
~~~

~~~java
package com.orderstock.order.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long productId) {
        super("Product not found: " + productId);
    }
}
~~~

Essa é uma exceção do contexto do `order-service`.

---

## 9.3 Alteração no `InventoryClient`

Arquivo existente:

~~~text
order-service/src/main/java/com/orderstock/order/client/InventoryClient.java
~~~

Adicione os imports:

~~~java
import com.orderstock.order.dto.ProductAvailabilityResponse;
import com.orderstock.order.exception.ProductNotFoundException;
import org.springframework.web.client.RestClientException;
~~~

Adicione o método:

~~~java
public ProductAvailabilityResponse checkAvailability(
        Long productId,
        int quantity
) {
    try {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(
                                "/api/inventory/products/{productId}/availability"
                        )
                        .queryParam("quantity", quantity)
                        .build(productId))
                .retrieve()
                .onStatus(
                        status -> status.value() == 404,
                        (request, response) -> {
                            throw new ProductNotFoundException(productId);
                        }
                )
                .body(ProductAvailabilityResponse.class);
    } catch (ProductNotFoundException exception) {
        throw exception;
    } catch (RestClientException exception) {
        throw new InventoryServiceUnavailableException(
                "Could not check product availability",
                exception
        );
    }
}
~~~

### Comportamentos esperados

| Resposta do inventory | Resultado no order |
|---|---|
| `200 OK` | Retorna disponibilidade |
| `404 Not Found` | Lança `ProductNotFoundException` |
| `400 Bad Request` | Deve ser tratado conforme a política definida |
| `500` ou `503` | `InventoryServiceUnavailableException` |
| Timeout | `InventoryServiceUnavailableException` |
| Conexão recusada | `InventoryServiceUnavailableException` |

O `404` não deve ser convertido em indisponibilidade.

---

## 9.4 Service do `order-service`

Arquivo:

~~~text
order-service/src/main/java/com/orderstock/order/service/ProductAvailabilityService.java
~~~

~~~java
package com.orderstock.order.service;

import com.orderstock.order.client.InventoryClient;
import com.orderstock.order.dto.ProductAvailabilityResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductAvailabilityService {

    private final InventoryClient inventoryClient;

    public ProductAvailabilityService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    public ProductAvailabilityResponse checkAvailability(
            Long productId,
            int quantity
    ) {
        return inventoryClient.checkAvailability(productId, quantity);
    }
}
~~~

Neste momento, o Service apenas delega a operação ao Client.

A separação é útil porque o Controller não precisa conhecer:

- a URL interna do inventory;
- o `RestClient`;
- os timeouts;
- a conversão de erros;
- detalhes da comunicação HTTP.

---

## 9.5 Controller do `order-service`

Arquivo:

~~~text
order-service/src/main/java/com/orderstock/order/controller/ProductAvailabilityController.java
~~~

~~~java
package com.orderstock.order.controller;

import com.orderstock.order.dto.ProductAvailabilityResponse;
import com.orderstock.order.exception.ProductNotFoundException;
import com.orderstock.order.service.ProductAvailabilityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/orders/products")
public class ProductAvailabilityController {

    private final ProductAvailabilityService productAvailabilityService;

    public ProductAvailabilityController(
            ProductAvailabilityService productAvailabilityService
    ) {
        this.productAvailabilityService = productAvailabilityService;
    }

    @GetMapping("/{productId}/availability")
    public ProductAvailabilityResponse checkAvailability(
            @PathVariable Long productId,
            @RequestParam int quantity
    ) {
        try {
            return productAvailabilityService.checkAvailability(
                    productId,
                    quantity
            );
        } catch (ProductNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    exception.getMessage(),
                    exception
            );
        }
    }
}
~~~

O Controller público do `order-service` não conhece detalhes internos do `inventory-service`.

---

# 10. Testes do `order-service`

## 10.1 Teste unitário do Service

Arquivo:

~~~text
order-service/src/test/java/com/orderstock/order/service/ProductAvailabilityServiceTest.java
~~~

~~~java
package com.orderstock.order.service;

import com.orderstock.order.client.InventoryClient;
import com.orderstock.order.dto.ProductAvailabilityResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductAvailabilityServiceTest {

    private final InventoryClient inventoryClient =
            mock(InventoryClient.class);

    private final ProductAvailabilityService service =
            new ProductAvailabilityService(inventoryClient);

    @Test
    void shouldReturnInventoryAvailability() {
        ProductAvailabilityResponse response =
                new ProductAvailabilityResponse(
                        1001L,
                        3,
                        10,
                        true
                );

        when(inventoryClient.checkAvailability(1001L, 3))
                .thenReturn(response);

        ProductAvailabilityResponse result =
                service.checkAvailability(1001L, 3);

        assertThat(result).isEqualTo(response);
    }
}
~~~

Esse teste valida que o Service delega corretamente a operação para o `InventoryClient`.

---

## 10.2 Teste web do Controller

Arquivo:

~~~text
order-service/src/test/java/com/orderstock/order/controller/ProductAvailabilityControllerTest.java
~~~

~~~java
package com.orderstock.order.controller;

import com.orderstock.order.dto.ProductAvailabilityResponse;
import com.orderstock.order.exception.ProductNotFoundException;
import com.orderstock.order.service.ProductAvailabilityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductAvailabilityController.class)
class ProductAvailabilityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductAvailabilityService productAvailabilityService;

    @Test
    void shouldReturnProductAvailability() throws Exception {
        ProductAvailabilityResponse response =
                new ProductAvailabilityResponse(
                        1001L,
                        3,
                        10,
                        true
                );

        when(productAvailabilityService.checkAvailability(1001L, 3))
                .thenReturn(response);

        mockMvc.perform(
                        get("/api/orders/products/1001/availability")
                                .param("quantity", "3")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(
                        MediaType.APPLICATION_JSON
                ))
                .andExpect(jsonPath("$.productId").value(1001))
                .andExpect(jsonPath("$.requestedQuantity").value(3))
                .andExpect(jsonPath("$.availableQuantity").value(10))
                .andExpect(jsonPath("$.available").value(true));
    }

    @Test
    void shouldReturnNotFoundWhenProductDoesNotExist()
            throws Exception {
        when(productAvailabilityService.checkAvailability(9999L, 1))
                .thenThrow(new ProductNotFoundException(9999L));

        mockMvc.perform(
                        get("/api/orders/products/9999/availability")
                                .param("quantity", "1")
                )
                .andExpect(status().isNotFound());
    }
}
~~~

---

# 11. Testes do `InventoryClient`

O `InventoryClient` deve ser testado separadamente porque sua responsabilidade é realizar comunicação HTTP.

Os principais cenários são:

| Cenário | Resultado esperado |
|---|---|
| Resposta `200` | DTO de disponibilidade |
| Resposta `404` | `ProductNotFoundException` |
| Resposta `5xx` | `InventoryServiceUnavailableException` |
| Timeout | `InventoryServiceUnavailableException` |
| Conexão recusada | `InventoryServiceUnavailableException` |
| Resposta inválida | Tratamento de erro existente |

Adicione um teste com nome semelhante a:

~~~text
shouldThrowProductNotFoundWhenInventoryReturns404
~~~

Esse teste deve garantir que uma resposta `404` não seja convertida em indisponibilidade genérica.

O teste deve validar:

- método HTTP `GET`;
- caminho correto;
- query parameter `quantity`;
- status HTTP `404`;
- exceção `ProductNotFoundException`.

---

# 12. Atualização do README do `inventory-service`

Adicione ao arquivo `inventory-service/README.md`:

~~~markdown
## Consulta de disponibilidade

Endpoint:

~~~http
GET /api/inventory/products/{productId}/availability?quantity={quantity}
~~~

Exemplo:

~~~bash
curl -i "http://localhost:8081/api/inventory/products/1001/availability?quantity=3"
~~~

Resposta:

~~~json
{
  "productId": 1001,
  "requestedQuantity": 3,
  "availableQuantity": 10,
  "available": true
}
~~~

Produtos disponíveis em memória:

| Produto | Quantidade |
|---:|---:|
| 1001 | 10 |
| 1002 | 0 |
| 1003 | 25 |

Produto inexistente retorna `404 Not Found`.

Quantidade igual a zero ou negativa retorna `400 Bad Request`.
~~~

---

# 13. Atualização do README do `order-service`

Adicione ao arquivo `order-service/README.md`:

~~~markdown
## Consulta de disponibilidade

O `order-service` fornece um endpoint que consulta o `inventory-service`.

Endpoint público:

~~~http
GET /api/orders/products/{productId}/availability?quantity={quantity}
~~~

Exemplo:

~~~bash
curl -i "http://localhost:8082/api/orders/products/1001/availability?quantity=3"
~~~

Fluxo:

1. o cliente chama o `order-service`;
2. o `order-service` chama o `inventory-service`;
3. o `inventory-service` consulta sua fonte de dados;
4. o resultado é devolvido ao cliente.

Se o produto não existir no `inventory-service`, o `order-service` retorna `404 Not Found`.

Se o `inventory-service` estiver indisponível, o `order-service` retorna o tratamento de indisponibilidade configurado na etapa anterior.
~~~

---

# 14. Como executar

## Terminal 1 — `inventory-service`

~~~bash
cd inventory-service
mvn clean test
mvn spring-boot:run
~~~

O serviço ficará disponível na porta `8081`.

## Terminal 2 — `order-service`

~~~bash
cd order-service
mvn clean test
mvn spring-boot:run
~~~

O serviço ficará disponível na porta `8082`.

---

# 15. Testes manuais

## Produto disponível diretamente no inventory

~~~bash
curl -i "http://localhost:8081/api/inventory/products/1001/availability?quantity=3"
~~~

Resposta esperada:

~~~json
{
  "productId": 1001,
  "requestedQuantity": 3,
  "availableQuantity": 10,
  "available": true
}
~~~

## Quantidade insuficiente

~~~bash
curl -i "http://localhost:8081/api/inventory/products/1001/availability?quantity=20"
~~~

Resposta esperada:

~~~json
{
  "productId": 1001,
  "requestedQuantity": 20,
  "availableQuantity": 10,
  "available": false
}
~~~

## Produto sem estoque

~~~bash
curl -i "http://localhost:8081/api/inventory/products/1002/availability?quantity=1"
~~~

Resposta esperada:

~~~json
{
  "productId": 1002,
  "requestedQuantity": 1,
  "availableQuantity": 0,
  "available": false
}
~~~

## Produto inexistente

~~~bash
curl -i "http://localhost:8081/api/inventory/products/9999/availability?quantity=1"
~~~

Resposta esperada:

~~~text
HTTP/1.1 404
~~~

## Consulta pelo order-service

~~~bash
curl -i "http://localhost:8082/api/orders/products/1001/availability?quantity=3"
~~~

O `order-service` deverá chamar internamente o `inventory-service`.

## Quantidade inválida

~~~bash
curl -i "http://localhost:8081/api/inventory/products/1001/availability?quantity=0"
~~~

Resposta esperada:

~~~text
HTTP/1.1 400
~~~

## Inventory indisponível

1. Pare o `inventory-service`.
2. Mantenha o `order-service` em execução.
3. Execute:

~~~bash
curl -i "http://localhost:8082/api/orders/products/1001/availability?quantity=3"
~~~

O resultado deverá seguir o tratamento de indisponibilidade da etapa anterior, normalmente HTTP `503`.

---

# 16. Comandos de build e testes

## `inventory-service`

~~~bash
cd inventory-service
mvn clean test
~~~

## `order-service`

~~~bash
cd order-service
mvn clean test
~~~

## Verificar imports incompatíveis

Linux ou macOS:

~~~bash
grep -R "import javax\." .
~~~

Windows PowerShell:

~~~powershell
Get-ChildItem -Recurse -Filter *.java | Select-String "import javax\."
~~~

O comando não deverá encontrar imports `javax.*`.

---

# 17. Commits sugeridos

~~~bash
git add inventory-service
git commit -m "feat(inventory-service): add in-memory product availability"
~~~

~~~bash
git add inventory-service/src/test
git commit -m "test(inventory-service): add product availability tests"
~~~

~~~bash
git add order-service/src/main
git commit -m "feat(order-service): expose product availability endpoint"
~~~

~~~bash
git add order-service/src/test
git commit -m "test(order-service): add product availability tests"
~~~

~~~bash
git add inventory-service/README.md order-service/README.md
git commit -m "docs: document product availability flow"
~~~

Caso prefira um único commit:

~~~bash
git add .
git commit -m "feat: add product availability integration"
~~~

---

# 18. Critérios de aceite

A etapa será considerada concluída quando:

- [ ] O `inventory-service` expõe `GET /api/inventory/products/{id}/availability`.
- [ ] O endpoint recebe `quantity` como query parameter.
- [ ] Produto existente retorna HTTP `200`.
- [ ] Produto existente com estoque insuficiente retorna `available: false`.
- [ ] Produto inexistente retorna HTTP `404`.
- [ ] Quantidade zero retorna HTTP `400`.
- [ ] Quantidade negativa retorna HTTP `400`.
- [ ] O `order-service` expõe a capacidade em sua própria URL.
- [ ] O `order-service` chama o `inventory-service` via `RestClient`.
- [ ] O `order-service` traduz o `404` do inventory para `404`.
- [ ] O `order-service` mantém o tratamento de indisponibilidade anterior.
- [ ] Existe teste unitário do Service do inventory.
- [ ] Existe teste web do Controller do inventory.
- [ ] Existe teste unitário do Service do order.
- [ ] Existe teste web do Controller do order.
- [ ] Existe teste do `InventoryClient` para resposta `404`.
- [ ] `mvn clean test` funciona no `inventory-service`.
- [ ] `mvn clean test` funciona no `order-service`.
- [ ] Os dois serviços iniciam nas portas corretas.
- [ ] A consulta pelo `order-service` funciona com o inventory disponível.
- [ ] A indisponibilidade do inventory é tratada adequadamente.
- [ ] Os READMEs foram atualizados.
- [ ] Existe pelo menos um commit referente à etapa.

---

# 19. Perguntas de entrevista

## Pergunta 1

Qual é a diferença entre um produto sem estoque suficiente e um produto inexistente?

Resposta esperada:

Um produto existente com quantidade insuficiente é uma resposta válida da consulta, normalmente representada por `200 OK` com `available: false`. Um produto inexistente representa um recurso não encontrado e deve retornar `404 Not Found`.

## Pergunta 2

Por que o `order-service` não deve reutilizar diretamente o DTO Java do `inventory-service`?

Resposta esperada:

Porque isso criaria acoplamento estrutural entre os serviços. Cada serviço deve controlar seus próprios contratos e modelos internos.

## Pergunta 3

Por que a indisponibilidade do inventory não deve ser tratada como `404`?

Resposta esperada:

`404` significa que o recurso não foi encontrado. Indisponibilidade significa que não foi possível obter uma resposta do serviço. São situações diferentes para diagnóstico, observabilidade e resiliência.

---

# 20. Exercícios adicionais

## Exercício 1

Adicione um produto de teste com identificador `1004` e quantidade `50`.

Depois:

- consulte diretamente no inventory;
- consulte pelo order;
- crie ou atualize os testes correspondentes.

## Exercício 2

Adicione uma validação para impedir `productId` menor ou igual a zero.

Exemplo:

~~~text
GET /api/inventory/products/0/availability?quantity=1
~~~

O resultado esperado poderá ser `400 Bad Request`.

## Exercício 3

Adicione um campo `checkedAt` na resposta usando `Instant`.

Exemplo:

~~~json
{
  "productId": 1001,
  "requestedQuantity": 3,
  "availableQuantity": 10,
  "available": true,
  "checkedAt": "2026-08-31T18:00:00Z"
}
~~~

Antes de realizar esse exercício, avalie se o novo campo realmente pertence ao contrato e atualize os testes.

---

# 21. Erros comuns

## Não iniciar o `inventory-service`

O `order-service` depende do `inventory-service`.

Se o inventory não estiver executando, a chamada deverá falhar conforme o tratamento de indisponibilidade.

## Usar a porta errada

~~~text
inventory-service: 8081
order-service: 8082
~~~

## Esquecer o query parameter

URL incorreta:

~~~text
/api/inventory/products/1001/availability
~~~

URL correta:

~~~text
/api/inventory/products/1001/availability?quantity=3
~~~

## Mapear a URL incorretamente

URL esperada:

~~~text
/api/inventory/products/{productId}/availability
~~~

Não utilizar:

~~~text
/api/products/{productId}/availability
/api/inventory/product/{productId}/availability
/api/inventory/products/availability/{productId}
~~~

## Converter qualquer erro em indisponibilidade

As categorias devem ser diferenciadas:

- `404`: produto não encontrado;
- `400`: requisição inválida;
- `5xx`: erro no serviço;
- timeout: indisponibilidade;
- conexão recusada: indisponibilidade.

## Colocar regra no Controller

O Controller não deve comparar estoque.

A regra:

~~~text
availableQuantity >= requestedQuantity
~~~

deve permanecer no Service.

## Alterar o estoque durante a consulta

A operação de disponibilidade é somente de leitura.

Ela não deve:

- diminuir estoque;
- criar reserva;
- liberar reserva;
- alterar dados.

## Adicionar banco prematuramente

O armazenamento em memória é proposital nesta etapa.

Adicionar PostgreSQL agora introduziria complexidade desnecessária para o objetivo atual.

---

# 22. Resumo da etapa

Nesta etapa, serão implementados:

- `ProductStock`;
- `ProductAvailabilityResponse`;
- Repository em memória;
- Service de disponibilidade;
- Controller do `inventory-service`;
- tratamento de produto inexistente;
- endpoint correspondente no `order-service`;
- consumo via `RestClient`;
- propagação de `404`;
- testes unitários;
- testes web;
- teste do `InventoryClient`;
- documentação;
- commits.

O fluxo final será:

~~~mermaid
flowchart LR
    Client[Cliente] --> OrderController[order-service Controller]
    OrderController --> OrderService[order-service Service]
    OrderService --> InventoryClient[InventoryClient]
    InventoryClient -->|HTTP GET| InventoryController[inventory-service Controller]
    InventoryController --> InventoryService[inventory-service Service]
    InventoryService --> Repository[Repository em memória]
~~~

---

# CONTEXTO-PARA-NEXT-ETAPA

## O que será implementado

- consulta de disponibilidade de produto no `inventory-service`;
- armazenamento temporário em memória;
- validação de quantidade;
- tratamento de produto inexistente;
- endpoint equivalente no `order-service`;
- consumo síncrono usando `RestClient`;
- propagação de `404`;
- testes unitários;
- testes de camada web;
- atualização da documentação.

## Arquivos principais adicionados

### `inventory-service`

~~~text
src/main/java/com/orderstock/inventoryservice/
├── controller/ProductAvailabilityController.java
├── dto/ProductAvailabilityResponse.java
├── exception/InvalidQuantityException.java
├── exception/ProductNotFoundException.java
├── model/ProductStock.java
├── repository/ProductStockRepository.java
└── service/ProductAvailabilityService.java
~~~

### `order-service`

~~~text
src/main/java/com/orderstock/order/
├── controller/ProductAvailabilityController.java
├── dto/ProductAvailabilityResponse.java
├── exception/ProductNotFoundException.java
└── service/ProductAvailabilityService.java
~~~

Também deverá ser alterado:

~~~text
order-service/src/main/java/com/orderstock/order/client/InventoryClient.java
~~~

## Versões utilizadas

- Java 17;
- Maven 3.9 ou superior;
- Spring Boot 3.5.4;
- Spring Web;
- Spring Boot Test;
- JUnit 5;
- Mockito;
- RestClient.

## Portas

- `inventory-service`: `8081`;
- `order-service`: `8082`.

## Endpoints adicionados

~~~http
GET http://localhost:8081/api/inventory/products/{productId}/availability?quantity={quantity}
~~~

~~~http
GET http://localhost:8082/api/orders/products/{productId}/availability?quantity={quantity}
~~~

## Decisões arquiteturais

- consulta de disponibilidade não altera estoque;
- dados temporários são armazenados em memória;
- cada serviço possui seu próprio DTO;
- `404` representa produto inexistente;
- `200` com `available: false` representa estoque insuficiente;
- `400` representa quantidade inválida;
- `RestClient` continua sendo usado para comunicação síncrona;
- não será adicionado banco nesta etapa;
- não será implementada reserva nesta etapa;
- o tratamento global de erros será aprimorado futuramente.

## Comandos esperados

~~~bash
cd inventory-service
mvn clean test
mvn spring-boot:run
~~~

Em outro terminal:

~~~bash
cd order-service
mvn clean test
mvn spring-boot:run
~~~

Testes manuais:

~~~bash
curl -i "http://localhost:8081/api/inventory/products/1001/availability?quantity=3"
curl -i "http://localhost:8082/api/orders/products/1001/availability?quantity=3"
curl -i "http://localhost:8081/api/inventory/products/9999/availability?quantity=1"
curl -i "http://localhost:8081/api/inventory/products/1001/availability?quantity=0"
~~~

## Problemas encontrados

Preencher durante a execução:

~~~text
Nenhum problema registrado até o momento.
~~~

Caso ocorra algum problema, registrar:

- sistema operacional;
- distribuição do JDK;
- versão do Java;
- versão do Maven;
- IDE;
- comando executado;
- mensagem completa do erro;
- arquivo relacionado;
- solução aplicada.

## Diferenças entre o ambiente e o exemplo

Preencher após executar:

~~~text
Sistema operacional:
Distribuição do JDK:
Versão exata do Java:
Versão exata do Maven:
Versão exata do Spring Boot:
IDE:
Ferramenta HTTP utilizada:
Alterações necessárias:
~~~

## Próximos objetivos

Depois da confirmação desta etapa:

1. revisar o tratamento global de erros;
2. padronizar respostas de erro;
3. avaliar testes HTTP com servidor simulado;
4. implementar cadastro de produtos;
5. introduzir persistência;
6. implementar reserva de estoque;
7. iniciar a modelagem de pedidos após consolidar o `inventory-service`.

Não avançaremos ainda para a criação de pedidos.