# OrderStock — Etapa 2: criação do `order-service` e integração HTTP

## 1. Objetivo da etapa

Nesta etapa vamos:

- criar o `order-service`;
- implementar seu health check local;
- configurar a porta `8082`;
- criar um cliente HTTP para o `inventory-service`;
- utilizar comunicação síncrona via HTTP;
- consultar `GET /api/inventory/health`;
- criar um endpoint para verificar a dependência;
- configurar timeout;
- tratar a indisponibilidade do `inventory-service`;
- criar testes web e testes unitários;
- documentar a implementação;
- propor commits Git pequenos e objetivos.

Ainda não serão implementados:

- produtos;
- pedidos;
- banco de dados;
- Spring Cloud;
- Feign;
- mensageria;
- retry;
- circuit breaker;
- segurança;
- observabilidade avançada.

---

# 2. Contexto recuperado

O `inventory-service` já possui:

- Java 17;
- Spring Boot 3.5.x;
- Maven;
- porta `8081`;
- endpoint `GET /api/inventory/health`;
- resposta JSON:

~~~json
{
  "service": "inventory-service",
  "status": "UP"
}
~~~

A POC utiliza um monorepo:

~~~text
orderstock/
├── inventory-service/
├── order-service/
└── api-gateway/
~~~

Nesta etapa, o novo serviço será criado em:

~~~text
order-service/
~~~

Ele utilizará a porta `8082`, evitando conflito com o `inventory-service`.

---

# 3. Conceitos fundamentais

## 3.1 Responsabilidade do `order-service`

O `order-service` será responsável pelo contexto de pedidos, incluindo futuramente:

- criação de pedidos;
- consulta de pedidos;
- alteração de status;
- validação de disponibilidade de estoque;
- solicitação de reserva de estoque;
- liberação de estoque em caso de cancelamento.

O `order-service` não deve conhecer detalhes internos do estoque. Ele deve consumir somente uma API pública disponibilizada pelo `inventory-service`.

## 3.2 Responsabilidade do `inventory-service`

O `inventory-service` será responsável por:

- cadastro de produtos;
- consulta de produtos;
- consulta de saldo;
- reserva de estoque;
- reposição;
- liberação de estoque reservado.

O `inventory-service` não deve conhecer detalhes internos dos pedidos.

## 3.3 Por que o `order-service` não deve acessar o banco do estoque

Mesmo que os serviços estejam no mesmo computador, o `order-service` não deve consultar diretamente as tabelas do `inventory-service`.

Isso evita:

- acoplamento ao schema do outro serviço;
- dependência de tabelas internas;
- quebra de encapsulamento;
- dificuldade para alterar o banco;
- dependência de deploy coordenado;
- compartilhamento indevido de regras de negócio.

A comunicação deve ocorrer por uma API ou por eventos.

## 3.4 O que é comunicação síncrona

A comunicação é síncrona quando o serviço solicitante:

1. envia uma requisição;
2. aguarda uma resposta;
3. continua o processamento depois de receber a resposta.

Fluxo desta etapa:

~~~mermaid
sequenceDiagram
    participant Client as Cliente
    participant Order as order-service
    participant Inventory as inventory-service

    Client->>Order: GET /api/orders/dependencies/inventory/health
    Order->>Inventory: GET /api/inventory/health
    Inventory-->>Order: HTTP 200 + JSON
    Order-->>Client: HTTP 200 + JSON simplificado
~~~

## 3.5 Vantagens da comunicação HTTP síncrona

- É simples de compreender;
- Utiliza padrões conhecidos de HTTP;
- É fácil de testar com `curl` e Postman;
- Possui contrato explícito;
- Permite resposta imediata;
- É adequada para a primeira integração entre serviços.

## 3.6 Riscos da comunicação síncrona

O `order-service` dependerá da resposta do `inventory-service`.

Se o `inventory-service` estiver lento ou indisponível:

- a requisição poderá falhar;
- o cliente poderá receber erro;
- uma thread poderá permanecer ocupada aguardando;
- falhas poderão ser propagadas;
- poderá ocorrer efeito cascata.

Por esse motivo, timeout, retry, circuit breaker e observabilidade são importantes em sistemas reais.

## 3.7 O que acontece quando o `inventory-service` está indisponível

Nesta etapa, o `order-service` deverá:

- capturar a falha;
- evitar expor stack trace;
- retornar uma resposta JSON controlada;
- utilizar o status HTTP `503 Service Unavailable`.

Exemplo:

~~~json
{
  "dependency": "inventory-service",
  "status": "DOWN",
  "message": "Inventory service is unavailable"
}
~~~

## 3.8 O que é acoplamento entre serviços

Acoplamento é o grau de dependência entre componentes.

Um serviço pode depender de outro em relação a:

- URL;
- método HTTP;
- formato do JSON;
- status HTTP;
- disponibilidade;
- tempo de resposta;
- regras de negócio;
- tecnologia utilizada.

O objetivo não é eliminar completamente o acoplamento, mas controlá-lo.

## 3.9 Acoplamento temporal

Existe acoplamento temporal quando dois serviços precisam estar disponíveis ao mesmo tempo.

Nesta etapa:

- o `order-service` faz uma requisição;
- o `inventory-service` precisa estar disponível;
- se o `inventory-service` estiver desligado, a operação não será concluída.

Esse é um risco típico da comunicação síncrona.

## 3.10 Acoplamento estrutural

Existe acoplamento estrutural quando um serviço depende de detalhes internos de outro.

Exemplos inadequados:

- acessar diretamente o banco do outro serviço;
- depender de tabelas internas;
- importar classes internas do outro projeto;
- depender de detalhes que não fazem parte da API pública.

A utilização de uma API HTTP reduz esse tipo de acoplamento.

## 3.11 Por que a integração será simples

A integração terá somente:

- uma chamada HTTP GET;
- uma URL configurável;
- DTOs;
- timeout básico;
- tratamento simples de exceção;
- testes unitários com mocks;
- testes de camada web com `MockMvc`.

O objetivo é compreender:

- URL;
- método HTTP;
- headers;
- status;
- corpo;
- serialização;
- desserialização;
- timeout;
- erros;
- testes de clientes HTTP.

## 3.12 Por que não utilizar Feign, Service Discovery ou Circuit Breaker agora

### Feign

O Feign reduz o código necessário para clientes HTTP, mas adiciona abstrações e dependências. Primeiro vamos compreender o fluxo manualmente utilizando `RestClient`.

### Service Discovery

Service Discovery é útil quando existem múltiplas instâncias e endereços dinâmicos. Nesta POC inicial, uma URL externa simples é suficiente.

### Circuit Breaker

Circuit Breaker será importante para impedir chamadas repetidas a uma dependência indisponível. Porém, antes é necessário compreender timeout e tratamento básico de erro.

Em uma aplicação real, essas decisões poderiam mudar conforme:

- número de serviços;
- quantidade de instâncias;
- ambiente de execução;
- requisitos de disponibilidade;
- latência;
- volume de tráfego;
- maturidade operacional.

---

# 4. Arquitetura atualizada

~~~mermaid
flowchart LR
    Client[Cliente / curl / Postman] --> OrderLocal[order-service]
    Client --> InventoryLocal[inventory-service]

    OrderLocal --> OrderController[HealthController]
    OrderController --> OrderLocalResponse[Resposta local]

    Client --> DependencyEndpoint[Endpoint de dependência]
    DependencyEndpoint --> InventoryClient[InventoryClient]
    InventoryClient -->|HTTP GET| InventoryLocal

    InventoryLocal --> InventoryController[HealthController]
    InventoryController --> InventoryResponse[Resposta JSON]
~~~

## 4.1 Fluxo de sucesso

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant OC as Order HealthController
    participant S as InventoryDependencyService
    participant IC as InventoryClient
    participant IS as inventory-service

    C->>OC: GET /api/orders/dependencies/inventory/health
    OC->>S: checkHealth()
    S->>IC: getHealth()
    IC->>IS: GET /api/inventory/health
    IS-->>IC: 200 + JSON
    IC-->>S: InventoryHealthResponse
    S-->>OC: DependencyHealthResponse
    OC-->>C: 200 + JSON
~~~

## 4.2 Fluxo de indisponibilidade

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant OC as Order HealthController
    participant S as InventoryDependencyService
    participant IC as InventoryClient
    participant IS as inventory-service

    C->>OC: GET /api/orders/dependencies/inventory/health
    OC->>S: checkHealth()
    S->>IC: getHealth()
    IC->>IS: GET /api/inventory/health
    IS--xIC: Timeout ou conexão recusada
    IC-->>S: InventoryServiceUnavailableException
    S-->>OC: InventoryServiceUnavailableException
    OC-->>C: 503 + JSON status DOWN
~~~

---

# 5. Cliente HTTP escolhido

## 5.1 Escolha

Utilizaremos o `RestClient`.

O `RestClient` é:

- síncrono;
- moderno;
- fluente;
- compatível com Spring Framework 6;
- apropriado para Spring Boot 3.x;
- suficiente para esta integração didática.

## 5.2 Comparação

| Cliente | Característica |
|---|---|
| `RestClient` | Síncrono, moderno e fluente |
| `RestTemplate` | Síncrono, tradicional e consolidado |
| `WebClient` | Reativo e não bloqueante |

## 5.3 Por que não utilizar `WebClient`

O `WebClient` é adequado para aplicações reativas e fluxos não bloqueantes. Entretanto, ele introduziria conceitos como:

- `Mono`;
- `Flux`;
- composição reativa;
- backpressure;
- programação reativa.

Nesta etapa, uma chamada síncrona é mais simples e suficiente.

Uma aplicação poderia utilizar comunicação não bloqueante quando:

- trabalha com grande quantidade de chamadas concorrentes;
- utiliza Spring WebFlux;
- precisa otimizar uso de threads;
- possui um fluxo predominantemente reativo;
- a equipe possui domínio de programação reativa.

## 5.4 Implicações da chamada bloqueante

Enquanto o `order-service` aguarda o `inventory-service`, a thread da requisição permanece ocupada.

Isso é aceitável para esta POC, mas em produção devem ser analisados:

- volume de requisições;
- tempo médio de resposta;
- quantidade de threads;
- limites de timeout;
- capacidade de escala;
- comportamento durante falhas.

---

# 6. Estrutura esperada dos arquivos

~~~mermaid
graph TD
    Root["orderstock/"] --> Order["order-service/"]

    Order --> Pom["pom.xml"]
    Order --> Readme["README.md"]
    Order --> Src["src/"]

    Src --> Main["main/"]
    Src --> Test["test/"]

    Main --> MainJava["java/com/orderstock/order/"]
    Main --> Resources["resources/"]

    MainJava --> Application["OrderServiceApplication.java"]
    MainJava --> Config["config/RestClientConfig.java"]
    MainJava --> Controller["controller/HealthController.java"]
    MainJava --> DTO["dto/"]
    MainJava --> Client["client/InventoryClient.java"]
    MainJava --> Service["service/InventoryDependencyService.java"]
    MainJava --> Exception["exception/InventoryServiceUnavailableException.java"]

    DTO --> HealthResponse["HealthResponse.java"]
    DTO --> InventoryHealthResponse["InventoryHealthResponse.java"]
    DTO --> DependencyHealthResponse["DependencyHealthResponse.java"]

    Resources --> Properties["application.properties"]

    Test --> TestJava["java/com/orderstock/order/"]
    TestJava --> ControllerTest["controller/HealthControllerTest.java"]
    TestJava --> ClientTest["client/InventoryClientTest.java"]
~~~

Estrutura textual:

~~~text
order-service/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/orderstock/order/
    │   │       ├── OrderServiceApplication.java
    │   │       ├── client/
    │   │       │   └── InventoryClient.java
    │   │       ├── config/
    │   │       │   └── RestClientConfig.java
    │   │       ├── controller/
    │   │       │   └── HealthController.java
    │   │       ├── dto/
    │   │       │   ├── DependencyHealthResponse.java
    │   │       │   ├── HealthResponse.java
    │   │       │   └── InventoryHealthResponse.java
    │   │       ├── exception/
    │   │       │   └── InventoryServiceUnavailableException.java
    │   │       └── service/
    │   │           └── InventoryDependencyService.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/
            └── com/orderstock/order/
                ├── client/
                │   └── InventoryClientTest.java
                └── controller/
                    └── HealthControllerTest.java
~~~

---

# 7. Criação do `order-service`

A partir da raiz do monorepo:

~~~bash
mkdir order-service
cd order-service

mkdir -p src/main/java/com/orderstock/order/client
mkdir -p src/main/java/com/orderstock/order/config
mkdir -p src/main/java/com/orderstock/order/controller
mkdir -p src/main/java/com/orderstock/order/dto
mkdir -p src/main/java/com/orderstock/order/exception
mkdir -p src/main/java/com/orderstock/order/service
mkdir -p src/main/resources
mkdir -p src/test/java/com/orderstock/order/client
mkdir -p src/test/java/com/orderstock/order/controller
~~~

No Windows PowerShell:

~~~powershell
New-Item -ItemType Directory -Force -Path `
src/main/java/com/orderstock/order/client, `
src/main/java/com/orderstock/order/config, `
src/main/java/com/orderstock/order/controller, `
src/main/java/com/orderstock/order/dto, `
src/main/java/com/orderstock/order/exception, `
src/main/java/com/orderstock/order/service, `
src/main/resources, `
src/test/java/com/orderstock/order/client, `
src/test/java/com/orderstock/order/controller
~~~

---

# 8. Arquivos completos

## 8.1 `order-service/pom.xml`

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.4</version>
        <relativePath/>
    </parent>

    <groupId>com.orderstock</groupId>
    <artifactId>order-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <name>order-service</name>
    <description>Serviço de pedidos da POC OrderStock</description>

    <properties>
        <java.version>17</java.version>
        <maven.compiler.release>17</maven.compiler.release>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
~~~

### Explicação

- `<parent>`: herda configurações e versões gerenciadas pelo Spring Boot;
- `<groupId>`: identifica o grupo do projeto;
- `<artifactId>`: identifica o artefato Maven;
- `<version>`: versão atual do projeto;
- `<java.version>`: informa que o projeto utiliza Java 17;
- `<maven.compiler.release>`: configura explicitamente o compilador para `--release 17`;
- `spring-boot-starter-web`: fornece Spring MVC, servidor embutido e Jackson;
- `spring-boot-starter-test`: fornece JUnit, Mockito, Spring Test e MockMvc;
- `spring-boot-maven-plugin`: permite executar e empacotar a aplicação.

A versão do Spring Boot deve ser igual à utilizada no `inventory-service`.

## 8.2 `OrderServiceApplication.java`

~~~java
package com.orderstock.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
~~~

Essa classe inicializa o Spring Boot e ativa o component scan nos subpacotes de `com.orderstock.order`.

## 8.3 `application.properties`

~~~properties
spring.application.name=order-service
server.port=8082

inventory-service.base-url=http://localhost:8081
inventory-service.timeout.connect=2s
inventory-service.timeout.read=3s
~~~

A porta `8082` evita conflito com o `inventory-service`, que utiliza a porta `8081`.

A URL do `inventory-service` foi externalizada para permitir alteração sem recompilar o código.

## 8.4 `HealthResponse.java`

~~~java
package com.orderstock.order.dto;

public record HealthResponse(String service, String status) {
}
~~~

Esse DTO representa o health check local do `order-service`.

## 8.5 `InventoryHealthResponse.java`

~~~java
package com.orderstock.order.dto;

public record InventoryHealthResponse(String service, String status) {
}
~~~

Esse DTO representa a resposta recebida do `inventory-service`.

Mesmo possuindo os mesmos campos neste momento, o DTO pertence ao `order-service` para evitar dependência direta de classes internas do outro serviço.

## 8.6 `DependencyHealthResponse.java`

~~~java
package com.orderstock.order.dto;

public record DependencyHealthResponse(
        String dependency,
        String status,
        String message
) {
}
~~~

Resposta quando a dependência está disponível:

~~~json
{
  "dependency": "inventory-service",
  "status": "UP",
  "message": null
}
~~~

Resposta quando a dependência está indisponível:

~~~json
{
  "dependency": "inventory-service",
  "status": "DOWN",
  "message": "Inventory service is unavailable"
}
~~~

## 8.7 `InventoryServiceUnavailableException.java`

~~~java
package com.orderstock.order.exception;

public class InventoryServiceUnavailableException extends RuntimeException {

    public InventoryServiceUnavailableException(String message) {
        super(message);
    }

    public InventoryServiceUnavailableException(
            String message,
            Throwable cause
    ) {
        super(message, cause);
    }
}
~~~

Essa exceção representa uma falha controlada na comunicação com o `inventory-service`.

## 8.8 `RestClientConfig.java`

~~~java
package com.orderstock.order.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient inventoryRestClient(
            @Value("${inventory-service.base-url}") String baseUrl,
            @Value("${inventory-service.timeout.connect}")
            Duration connectTimeout,
            @Value("${inventory-service.timeout.read}")
            Duration readTimeout
    ) {
        SimpleClientHttpRequestFactory requestFactory =
                new SimpleClientHttpRequestFactory();

        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);

        return RestClient.builder()
                .baseUrl(baseUrl)
                .requestFactory(requestFactory)
                .build();
    }
}
~~~

Essa classe:

- lê a URL externa;
- lê os timeouts;
- cria a infraestrutura do cliente HTTP;
- centraliza a configuração do `RestClient`.

O Controller não precisa saber como o cliente foi configurado.

## 8.9 `InventoryClient.java`

~~~java
package com.orderstock.order.client;

import com.orderstock.order.dto.InventoryHealthResponse;
import com.orderstock.order.exception.InventoryServiceUnavailableException;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Component
public class InventoryClient {

    private static final String INVENTORY_HEALTH_PATH =
            "/api/inventory/health";

    private final RestClient restClient;

    public InventoryClient(RestClient inventoryRestClient) {
        this.restClient = inventoryRestClient;
    }

    public InventoryHealthResponse getHealth() {
        try {
            InventoryHealthResponse response = restClient.get()
                    .uri(INVENTORY_HEALTH_PATH)
                    .retrieve()
                    .body(InventoryHealthResponse.class);

            if (response == null) {
                throw new InventoryServiceUnavailableException(
                        "Inventory service returned an empty response"
                );
            }

            return response;
        } catch (InventoryServiceUnavailableException exception) {
            throw exception;
        } catch (RestClientException exception) {
            throw new InventoryServiceUnavailableException(
                    "Inventory service is unavailable",
                    exception
            );
        }
    }
}
~~~

O `InventoryClient`:

- encapsula a chamada HTTP;
- conhece o caminho da API externa;
- desserializa o JSON;
- converte erros HTTP e de comunicação;
- evita que o Controller construa URLs diretamente.

## 8.10 `InventoryDependencyService.java`

~~~java
package com.orderstock.order.service;

import com.orderstock.order.client.InventoryClient;
import com.orderstock.order.dto.DependencyHealthResponse;
import com.orderstock.order.dto.InventoryHealthResponse;

import org.springframework.stereotype.Service;

@Service
public class InventoryDependencyService {

    private final InventoryClient inventoryClient;

    public InventoryDependencyService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    public DependencyHealthResponse checkHealth() {
        InventoryHealthResponse inventoryHealth =
                inventoryClient.getHealth();

        return new DependencyHealthResponse(
                inventoryHealth.service(),
                inventoryHealth.status(),
                null
        );
    }
}
~~~

A camada Service:

- coordena a chamada ao cliente;
- transforma a resposta externa em resposta interna;
- mantém o Controller focado em HTTP;
- prepara o código para regras futuras.

## 8.11 `HealthController.java`

~~~java
package com.orderstock.order.controller;

import com.orderstock.order.dto.DependencyHealthResponse;
import com.orderstock.order.dto.HealthResponse;
import com.orderstock.order.exception.InventoryServiceUnavailableException;
import com.orderstock.order.service.InventoryDependencyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final InventoryDependencyService inventoryDependencyService;

    public HealthController(
            InventoryDependencyService inventoryDependencyService
    ) {
        this.inventoryDependencyService = inventoryDependencyService;
    }

    @GetMapping("/api/orders/health")
    public HealthResponse health() {
        return new HealthResponse("order-service", "UP");
    }

    @GetMapping("/api/orders/dependencies/inventory/health")
    public ResponseEntity<DependencyHealthResponse> inventoryHealth() {
        try {
            DependencyHealthResponse response =
                    inventoryDependencyService.checkHealth();

            return ResponseEntity.ok(response);
        } catch (InventoryServiceUnavailableException exception) {
            DependencyHealthResponse response =
                    new DependencyHealthResponse(
                            "inventory-service",
                            "DOWN",
                            "Inventory service is unavailable"
                    );

            return ResponseEntity
                    .status(503)
                    .body(response);
        }
    }
}
~~~

## 8.12 Responsabilidade do Controller

O Controller:

- recebe requisições HTTP;
- escolhe o endpoint;
- chama a camada de serviço;
- define o status HTTP;
- devolve a resposta JSON.

Ele não deve:

- construir URLs de outros serviços;
- conter regras complexas;
- acessar banco diretamente;
- implementar detalhes de comunicação HTTP.

---

# 9. Endpoints criados

## 9.1 Health check local

~~~http
GET /api/orders/health
~~~

Resposta:

~~~json
{
  "service": "order-service",
  "status": "UP"
}
~~~

## 9.2 Health check da dependência

~~~http
GET /api/orders/dependencies/inventory/health
~~~

Resposta com sucesso:

~~~json
{
  "dependency": "inventory-service",
  "status": "UP",
  "message": null
}
~~~

Resposta quando o serviço está indisponível:

~~~json
{
  "dependency": "inventory-service",
  "status": "DOWN",
  "message": "Inventory service is unavailable"
}
~~~

## 9.3 Por que utilizar GET

GET é apropriado porque a operação:

- apenas consulta informações;
- não altera estado;
- pode ser repetida;
- representa uma leitura.

## 9.4 Por que utilizar HTTP 200

`200 OK` indica que:

- a requisição foi processada;
- o endpoint está disponível;
- a resposta contém dados válidos.

## 9.5 Por que utilizar HTTP 503

`503 Service Unavailable` indica que:

- o serviço recebeu a requisição;
- uma dependência necessária não estava disponível;
- a falha pode ser temporária.

## 9.6 Health check local versus health check de dependência

O health check local verifica apenas se o `order-service` está ativo.

O health check de dependência verifica se o `order-service` consegue se comunicar com o `inventory-service`.

Portanto:

- `order-service` local ativo não significa que o estoque está disponível;
- `inventory-service` disponível não significa que o `order-service` está ativo;
- o endpoint de dependência representa uma verificação parcial da saúde do sistema.

---

# 10. Configuração externa

## 10.1 Por que externalizar a URL

A URL pode variar entre ambientes:

~~~properties
inventory-service.base-url=http://localhost:8081
~~~

Em Docker Compose, por exemplo, poderia ser:

~~~properties
inventory-service.base-url=http://inventory-service:8081
~~~

Em outro ambiente, poderia apontar para um domínio ou Service Discovery.

## 10.2 Configuração versus código

Configuração representa valores que podem mudar conforme o ambiente.

Código representa o comportamento da aplicação.

A URL deve ser configuração, não código, porque pode mudar entre:

- desenvolvimento;
- testes;
- homologação;
- produção;
- execução local;
- containers.

## 10.3 Diferença do `localhost` em containers

Fora de containers:

~~~text
localhost = a própria máquina
~~~

Dentro de um container:

~~~text
localhost = o próprio container
~~~

Portanto, se o `order-service` estiver em um container, `localhost:8081` não apontará automaticamente para outro container.

---

# 11. Timeout

## 11.1 O que é timeout

Timeout é o tempo máximo permitido para uma operação.

Sem timeout, o `order-service` poderia ficar aguardando indefinidamente uma resposta.

## 11.2 Connection timeout

É o tempo máximo para estabelecer a conexão:

~~~properties
inventory-service.timeout.connect=2s
~~~

## 11.3 Read timeout

É o tempo máximo para aguardar dados depois que a conexão foi estabelecida:

~~~properties
inventory-service.timeout.read=3s
~~~

## 11.4 Valores escolhidos

Para a POC:

- connection timeout: `2s`;
- read timeout: `3s`.

Esses valores são didáticos e não devem ser copiados automaticamente para produção.

Valores reais dependem de:

- SLA;
- latência;
- infraestrutura;
- volume;
- comportamento dos consumidores;
- necessidade de retry;
- tempo total aceitável da operação.

---

# 12. Testes

## 12.1 Teste de camada web

Arquivo:

~~~text
src/test/java/com/orderstock/order/controller/HealthControllerTest.java
~~~

~~~java
package com.orderstock.order.controller;

import com.orderstock.order.dto.DependencyHealthResponse;
import com.orderstock.order.exception.InventoryServiceUnavailableException;
import com.orderstock.order.service.InventoryDependencyService;

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

@WebMvcTest(HealthController.class)
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryDependencyService inventoryDependencyService;

    @Test
    void shouldReturnOrderServiceHealth() throws Exception {
        mockMvc.perform(get("/api/orders/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.service")
                        .value("order-service"))
                .andExpect(jsonPath("$.status")
                        .value("UP"));
    }

    @Test
    void shouldReturnInventoryDependencyHealth() throws Exception {
        when(inventoryDependencyService.checkHealth())
                .thenReturn(
                        new DependencyHealthResponse(
                                "inventory-service",
                                "UP",
                                null
                        )
                );

        mockMvc.perform(
                        get("/api/orders/dependencies/inventory/health")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dependency")
                        .value("inventory-service"))
                .andExpect(jsonPath("$.status")
                        .value("UP"));
    }

    @Test
    void shouldReturnServiceUnavailableWhenInventoryIsDown()
            throws Exception {

        when(inventoryDependencyService.checkHealth())
                .thenThrow(
                        new InventoryServiceUnavailableException(
                                "Inventory service is unavailable"
                        )
                );

        mockMvc.perform(
                        get("/api/orders/dependencies/inventory/health")
                )
                .andExpect(status().isServiceUnavailable())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dependency")
                        .value("inventory-service"))
                .andExpect(jsonPath("$.status")
                        .value("DOWN"))
                .andExpect(jsonPath("$.message")
                        .value("Inventory service is unavailable"));
    }
}
~~~

## 12.2 O que esse teste valida

O teste valida:

- existência do endpoint;
- aceitação do método GET;
- roteamento do Controller;
- status HTTP;
- serialização JSON;
- valores dos campos;
- comportamento do Controller quando o Service retorna sucesso ou exceção.

O teste não valida:

- conexão real com o `inventory-service`;
- URL configurada;
- timeout real;
- desserialização real do cliente;
- disponibilidade da porta `8081`;
- comunicação de rede.

## 12.3 Teste unitário do cliente HTTP

Arquivo:

~~~text
src/test/java/com/orderstock/order/client/InventoryClientTest.java
~~~

~~~java
package com.orderstock.order.client;

import com.orderstock.order.dto.InventoryHealthResponse;
import com.orderstock.order.exception.InventoryServiceUnavailableException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventoryClientTest {

    @Mock
    private RestClient restClient;

    @Mock
    private RestClient.RequestHeadersUriSpec<?> requestHeadersUriSpec;

    @Mock
    private RestClient.RequestHeadersSpec<?> requestHeadersSpec;

    @Mock
    private RestClient.ResponseSpec responseSpec;

    private InventoryClient inventoryClient;

    @BeforeEach
    void setUp() {
        inventoryClient = new InventoryClient(restClient);

        when(restClient.get())
                .thenReturn(requestHeadersUriSpec);

        when(requestHeadersUriSpec.uri("/api/inventory/health"))
                .thenReturn(requestHeadersSpec);

        when(requestHeadersSpec.retrieve())
                .thenReturn(responseSpec);
    }

    @Test
    void shouldReturnInventoryHealthWhenRequestSucceeds() {
        InventoryHealthResponse expectedResponse =
                new InventoryHealthResponse(
                        "inventory-service",
                        "UP"
                );

        when(responseSpec.body(InventoryHealthResponse.class))
                .thenReturn(expectedResponse);

        InventoryHealthResponse actualResponse =
                inventoryClient.getHealth();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void shouldThrowControlledExceptionWhenInventoryIsUnavailable() {
        when(responseSpec.body(InventoryHealthResponse.class))
                .thenThrow(
                        new RestClientException(
                                "Connection refused"
                        )
                );

        assertThrows(
                InventoryServiceUnavailableException.class,
                () -> inventoryClient.getHealth()
        );
    }

    @Test
    void shouldThrowControlledExceptionWhenInventoryReturnsServerError() {
        HttpServerErrorException serverError =
                HttpServerErrorException.create(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Internal Server Error",
                        HttpHeaders.EMPTY,
                        new byte[0],
                        StandardCharsets.UTF_8
                );

        when(responseSpec.body(InventoryHealthResponse.class))
                .thenThrow(serverError);

        assertThrows(
                InventoryServiceUnavailableException.class,
                () -> inventoryClient.getHealth()
        );
    }

    @Test
    void shouldThrowControlledExceptionWhenResponseIsEmpty() {
        when(responseSpec.body(InventoryHealthResponse.class))
                .thenReturn(null);

        assertThrows(
                InventoryServiceUnavailableException.class,
                () -> inventoryClient.getHealth()
        );
    }
}
~~~

## 12.4 O que o teste unitário valida

O teste valida:

- resposta de sucesso;
- transformação para `InventoryHealthResponse`;
- conversão de erro de comunicação;
- conversão de erro HTTP 5xx;
- tratamento de corpo vazio;
- comportamento do cliente sem acesso à rede.

## 12.5 Tipos de teste

| Tipo | Escopo | Depende da rede? |
|---|---|---|
| Unitário | Uma classe isolada | Não |
| Camada web | Controller e Spring MVC | Não |
| Integração | Vários componentes reais | Pode depender |
| End-to-end | Sistema completo | Normalmente sim |

Testes unitários não devem depender de outro serviço em execução porque precisam ser:

- rápidos;
- determinísticos;
- isolados;
- executáveis em qualquer máquina;
- independentes da rede.

Posteriormente, poderemos utilizar:

- MockRestServiceServer;
- WireMock;
- MockWebServer;
- Testcontainers;
- execução real dos dois serviços;
- testes de contrato.

---

# 13. README do `order-service`

Arquivo:

~~~text
order-service/README.md
~~~

~~~markdown
# order-service

Microsserviço responsável pelo contexto de pedidos da POC OrderStock.

## Objetivo

Nesta etapa, o serviço disponibiliza:

- health check local;
- verificação da disponibilidade do inventory-service;
- comunicação HTTP síncrona com o inventory-service.

Ainda não existem pedidos persistidos ou banco de dados.

## Tecnologias

- Java 17;
- Maven 3.9 ou superior;
- Spring Boot 3.5.4;
- Spring Web;
- Spring Boot Test;
- JUnit 5;
- Mockito;
- RestClient.

## Porta

O order-service utiliza a porta `8082`.

O inventory-service utiliza a porta `8081`.

## Pré-requisitos

- Java 17 instalado;
- Maven 3.9 ou superior;
- inventory-service configurado;
- inventory-service executando na porta `8081` para testar a integração.

## Configuração

~~~properties
server.port=8082
inventory-service.base-url=http://localhost:8081
inventory-service.timeout.connect=2s
inventory-service.timeout.read=3s
~~~

## Como executar

~~~bash
mvn spring-boot:run
~~~

## Como executar os testes

~~~bash
mvn clean test
~~~

## Health check local

~~~http
GET /api/orders/health
~~~

Exemplo:

~~~bash
curl -i http://localhost:8082/api/orders/health
~~~

Resposta:

~~~json
{
  "service": "order-service",
  "status": "UP"
}
~~~

## Health check do inventory-service

~~~http
GET /api/orders/dependencies/inventory/health
~~~

Exemplo:

~~~bash
curl -i http://localhost:8082/api/orders/dependencies/inventory/health
~~~

Quando o inventory-service estiver disponível:

~~~json
{
  "dependency": "inventory-service",
  "status": "UP",
  "message": null
}
~~~

Quando o inventory-service estiver indisponível:

~~~json
{
  "dependency": "inventory-service",
  "status": "DOWN",
  "message": "Inventory service is unavailable"
}
~~~

Nesse caso, o order-service retorna HTTP 503.

## Limitações conhecidas

- Não existe banco de dados;
- Não existem pedidos;
- Não existe autenticação;
- Não existe retry;
- Não existe circuit breaker;
- Não existe Service Discovery;
- A comunicação é síncrona e bloqueante;
- A URL padrão utiliza localhost;
- O tratamento de erros ainda é básico;
- Não há observabilidade distribuída.

## Próximos passos

- criar endpoints de produtos;
- criar cliente para consultar produtos;
- criar modelo inicial de pedido;
- adicionar persistência;
- adicionar testes de integração;
- avaliar resiliência e observabilidade.
~~~

---

# 14. README raiz do monorepo

Arquivo:

~~~text
orderstock/README.md
~~~

~~~markdown
# OrderStock

POC didática de um sistema de pedidos e estoque utilizando Java, Spring Boot e arquitetura de microsserviços.

## Serviços

| Serviço | Responsabilidade inicial | Porta |
|---|---|---:|
| inventory-service | Operações futuras de estoque | 8081 |
| order-service | Operações futuras de pedidos | 8082 |
| api-gateway | Futuro ponto único de entrada | A definir |

## Tecnologias

- Java 17;
- Maven;
- Spring Boot 3.5.x;
- Spring Web;
- JUnit 5;
- Mockito;
- Git.

## Execução

Terminal 1:

~~~bash
cd inventory-service
mvn spring-boot:run
~~~

Terminal 2:

~~~bash
cd order-service
mvn spring-boot:run
~~~

## Testes

~~~bash
cd inventory-service
mvn clean test

cd ../order-service
mvn clean test
~~~

## Integração atual

O order-service consulta:

~~~http
GET http://localhost:8081/api/inventory/health
~~~

Por meio de:

~~~http
GET http://localhost:8082/api/orders/dependencies/inventory/health
~~~

## Decisões atuais

- Monorepo;
- Um banco por serviço no futuro;
- Sem banco nesta etapa;
- Sem Spring Cloud;
- Sem mensageria;
- Sem Lombok;
- Comunicação HTTP síncrona;
- URLs configuradas externamente.
~~~

---

# 15. Git e métodos ágeis

## 15.1 Commits sugeridos

A partir da raiz:

~~~bash
git status
git add order-service/pom.xml
git commit -m "feat(order-service): create initial Spring Boot service"
~~~

Health check:

~~~bash
git add order-service/src/main
git commit -m "feat(order-service): add local health check endpoint"
~~~

Teste web:

~~~bash
git add order-service/src/test/java/com/orderstock/order/controller
git commit -m "test(order-service): add health check web tests"
~~~

Cliente HTTP:

~~~bash
git add order-service/src/main/java/com/orderstock/order
git commit -m "feat(order-service): add inventory HTTP client"
~~~

Testes do cliente:

~~~bash
git add order-service/src/test/java/com/orderstock/order/client
git commit -m "test(order-service): add inventory client unit tests"
~~~

Documentação:

~~~bash
git add order-service/README.md README.md
git commit -m "docs(order-service): document integration and execution"
~~~

## 15.2 Significado dos prefixos

- `feat`: nova funcionalidade;
- `test`: criação ou alteração de testes;
- `docs`: documentação;
- `fix`: correção;
- `refactor`: alteração estrutural sem mudança funcional;
- `chore`: tarefa técnica.

## 15.3 História de usuário

~~~text
Como sistema de pedidos,
quero verificar a disponibilidade do serviço de estoque,
para identificar se posso continuar o processamento de uma operação.
~~~

## 15.4 Critérios de aceite

- O `order-service` possui health check local;
- O serviço utiliza a porta `8082`;
- O serviço consegue consultar o `inventory-service`;
- A URL do estoque é configurável;
- A integração utiliza HTTP GET;
- Uma resposta bem-sucedida retorna HTTP 200;
- Uma indisponibilidade retorna HTTP 503;
- Existe timeout configurado;
- O cliente HTTP está separado do Controller;
- Existem testes automatizados;
- Testes unitários não dependem de outro serviço;
- Existe documentação;
- Existe commit Git relacionado.

## 15.5 Exemplo para uma daily meeting

~~~text
Ontem criei a estrutura inicial do order-service e implementei o health check local.

Hoje implementei o cliente HTTP utilizando RestClient, configurei timeout e adicionei o endpoint que verifica o health check do inventory-service.

A principal decisão foi manter a integração síncrona e simples, sem introduzir Spring Cloud ou circuit breaker nesta etapa.

Como risco, o order-service possui dependência temporal do inventory-service, mas a indisponibilidade já é tratada com HTTP 503.
~~~

## 15.6 Como explicar uma dificuldade técnica

Utilize:

1. contexto;
2. problema;
3. investigação;
4. decisão;
5. resultado.

Exemplo:

~~~text
Durante a configuração do cliente HTTP, precisei definir timeout de conexão e leitura.

O problema era evitar que o order-service aguardasse indefinidamente o inventory-service.

Analisei a configuração do RestClient e utilizei SimpleClientHttpRequestFactory.

Como resultado, a chamada passou a possuir limites explícitos e os testes de falha foram adicionados.
~~~

---

# 16. Comandos de execução

## 16.1 Verificar Java

~~~bash
java -version
~~~

Resultado esperado:

~~~text
java version "17.x.x"
~~~

## 16.2 Verificar Maven

~~~bash
mvn -version
~~~

Procure uma saída semelhante a:

~~~text
Java version: 17.x.x
~~~

É importante verificar o Java utilizado pelo Maven, pois ele pode ser diferente do Java utilizado pelo comando `java`.

## 16.3 Iniciar o `inventory-service`

Terminal 1:

~~~bash
cd inventory-service
mvn spring-boot:run
~~~

## 16.4 Iniciar o `order-service`

Terminal 2:

~~~bash
cd order-service
mvn spring-boot:run
~~~

## 16.5 Executar os testes

~~~bash
cd order-service
mvn clean test
~~~

## 16.6 Testar o `inventory-service`

~~~bash
curl -i http://localhost:8081/api/inventory/health
~~~

## 16.7 Testar o health check local do `order-service`

~~~bash
curl -i http://localhost:8082/api/orders/health
~~~

## 16.8 Testar a dependência

~~~bash
curl -i http://localhost:8082/api/orders/dependencies/inventory/health
~~~

## 16.9 Confirmar o `release 17`

Execute:

~~~bash
mvn clean compile
~~~

Também é possível verificar o POM efetivo:

~~~bash
mvn help:effective-pom
~~~

Procure por:

~~~xml
<release>17</release>
~~~

No Linux ou macOS:

~~~bash
grep -R "release" target/maven-status
~~~

No Windows PowerShell:

~~~powershell
mvn help:effective-pom | Select-String "release"
~~~

A confirmação mais importante é que:

- `java -version` indica Java 17;
- `mvn -version` indica Java 17;
- o POM possui `<maven.compiler.release>17</maven.compiler.release>`;
- `mvn clean test` executa com sucesso.

---

# 17. Resultado esperado dos cenários

## 17.1 Os dois serviços em execução

~~~bash
curl -i http://localhost:8081/api/inventory/health
~~~

Resultado:

~~~http
HTTP/1.1 200 OK
~~~

~~~bash
curl -i http://localhost:8082/api/orders/health
~~~

Resultado:

~~~http
HTTP/1.1 200 OK
~~~

~~~bash
curl -i http://localhost:8082/api/orders/dependencies/inventory/health
~~~

Resultado:

~~~http
HTTP/1.1 200 OK
~~~

Resposta:

~~~json
{
  "dependency": "inventory-service",
  "status": "UP",
  "message": null
}
~~~

## 17.2 Somente o `order-service` em execução

~~~bash
curl -i http://localhost:8082/api/orders/dependencies/inventory/health
~~~

Resultado:

~~~http
HTTP/1.1 503 Service Unavailable
~~~

Resposta:

~~~json
{
  "dependency": "inventory-service",
  "status": "DOWN",
  "message": "Inventory service is unavailable"
}
~~~

O health check local do `order-service` ainda poderá retornar `200`, porque o próprio processo está ativo.

## 17.3 Somente o `inventory-service` em execução

~~~bash
curl -i http://localhost:8081/api/inventory/health
~~~

Resultado:

~~~http
HTTP/1.1 200 OK
~~~

O endpoint do `order-service` não responderá, pois ele não está em execução.

## 17.4 Nenhum serviço em execução

As chamadas resultarão em erro de conexão, normalmente:

~~~text
Connection refused
~~~

## 17.5 Porta ocupada

Erro típico:

~~~text
Web server failed to start. Port 8082 was already in use.
~~~

Soluções:

- parar o processo que utiliza a porta;
- alterar `server.port`;
- utilizar outra porta temporariamente.

## 17.6 URL configurada incorretamente

Se a configuração estiver assim:

~~~properties
inventory-service.base-url=http://localhost:9999
~~~

A chamada deverá falhar controladamente e o endpoint deverá retornar `503`.

---

# 18. Checklist de validação

- [ ] O `inventory-service` continua funcionando;
- [ ] O `order-service` foi criado;
- [ ] O `order-service` utiliza a porta `8082`;
- [ ] O `inventory-service` utiliza a porta `8081`;
- [ ] `java -version` indica Java 17;
- [ ] `mvn -version` indica Java 17;
- [ ] O `pom.xml` utiliza Spring Boot 3.5.x;
- [ ] O POM possui `maven.compiler.release` com valor `17`;
- [ ] `mvn clean test` executa com sucesso;
- [ ] `GET /api/orders/health` retorna HTTP 200;
- [ ] O health check local retorna JSON;
- [ ] O `order-service` consulta o `inventory-service`;
- [ ] A dependência disponível retorna HTTP 200;
- [ ] A dependência indisponível retorna HTTP 503;
- [ ] O cliente HTTP está separado do Controller;
- [ ] A URL está configurada externamente;
- [ ] Existe timeout configurado;
- [ ] Testes unitários não realizam chamadas HTTP reais;
- [ ] Existe README do `order-service`;
- [ ] Existe pelo menos um commit Git;
- [ ] Não existem imports `javax.*`;
- [ ] Você consegue explicar o fluxo entre os serviços;
- [ ] Você consegue diferenciar health check local e health check de dependência;
- [ ] Você consegue diferenciar teste unitário, teste web e teste de integração.

---

# 19. Perguntas de entrevista

## 19.1 Perguntas

1. Qual é a responsabilidade do `order-service`?
2. Qual é a diferença entre comunicação síncrona e assíncrona?
3. O que acontece quando o `inventory-service` fica indisponível?
4. Qual é a diferença entre acoplamento temporal e acoplamento estrutural?
5. Por que o `order-service` não deve acessar diretamente o banco do `inventory-service`?
6. Por que um timeout é necessário?
7. Qual é a diferença entre connection timeout e read timeout?
8. Por que o cliente HTTP foi separado do Controller?
9. Qual é a diferença entre `RestClient`, `RestTemplate` e `WebClient`?
10. Por que testes unitários não devem depender de outro serviço em execução?
11. Qual é a diferença entre health check local e health check de dependência?
12. Por que a URL do `inventory-service` deve ser configurada externamente?

## 19.2 Respostas esperadas

1. O `order-service` será responsável pelo contexto de pedidos e pela orquestração das operações relacionadas a pedidos.
2. A comunicação síncrona aguarda uma resposta; a assíncrona permite que o produtor e o consumidor prossigam de forma desacoplada.
3. O cliente HTTP falha, a exceção é tratada e o `order-service` retorna HTTP 503.
4. Acoplamento temporal depende da disponibilidade simultânea; acoplamento estrutural depende de detalhes internos ou contratos rígidos.
5. Para preservar isolamento, independência de deploy e encapsulamento dos dados.
6. Para impedir espera indefinida e proteger recursos da aplicação.
7. Connection timeout limita o tempo para conectar; read timeout limita o tempo para receber dados.
8. Para manter o Controller focado em HTTP e centralizar a comunicação externa.
9. `RestClient` é síncrono e moderno; `RestTemplate` é síncrono e tradicional; `WebClient` é reativo e não bloqueante.
10. Para que sejam rápidos, determinísticos e independentes da rede.
11. O health check local verifica o próprio processo; o de dependência verifica também outro serviço.
12. Para alterar ambientes e endereços sem recompilar o código.

---

# 20. Exercício adicional

## Objetivo

Criar uma segunda operação no `inventory-service` e fazer o `order-service` consumi-la.

## Instruções

1. Criar no `inventory-service` o endpoint:

~~~http
GET /api/inventory/products/availability
~~~

2. Retornar um DTO semelhante a:

~~~json
{
  "productId": "product-1",
  "available": true
}
~~~

3. Criar no `order-service`:

- um DTO para a resposta externa;
- um método adicional no `InventoryClient`;
- um endpoint que consuma a nova operação.

4. Tratar o cenário em que o `inventory-service` retorna `404 Not Found`.

5. Criar testes unitários para:

- resposta de disponibilidade;
- resposta HTTP 404;
- transformação para DTO interno;
- comportamento controlado em caso de produto inexistente.

## Critérios de aceite

- O novo endpoint existe no `inventory-service`;
- O `order-service` consegue consumi-lo;
- A URL continua configurável;
- O Controller não constrói a URL diretamente;
- O status 404 é tratado;
- Não existem chamadas reais nos testes unitários;
- Os testes passam;
- Existe documentação mínima;
- Existe commit Git específico.

## Dicas iniciais

- Crie um DTO próprio para disponibilidade;
- Diferencie `404 Not Found` de indisponibilidade de rede;
- Considere se o Controller deve retornar `404`, `503` ou outro status;
- Comece escrevendo os testes esperados;
- Não reutilize classes internas do `inventory-service`.

A solução completa do exercício não será apresentada agora.

---

# 21. Erros comuns

## 21.1 Java incompatível

Spring Boot 3 exige Java 17 ou superior.

Erros possíveis:

~~~text
Unsupported class file major version
~~~

ou:

~~~text
Spring Boot requires Java 17
~~~

Verifique:

~~~bash
java -version
mvn -version
~~~

## 21.2 Maven utilizando outro JDK

Pode acontecer de `java -version` indicar Java 17, mas `mvn -version` indicar Java 11.

Nesse caso, verifique e ajuste `JAVA_HOME`.

Linux ou macOS:

~~~bash
echo $JAVA_HOME
~~~

Windows PowerShell:

~~~powershell
$env:JAVA_HOME
~~~

## 21.3 Porta ocupada

Erro típico:

~~~text
Port 8082 was already in use
~~~

Verifique os processos ativos ou altere temporariamente a porta.

## 21.4 `inventory-service` desligado

O health check local do `order-service` pode continuar respondendo `200`.

Já o endpoint de dependência deverá responder `503`.

## 21.5 URL incorreta

Verifique:

~~~properties
inventory-service.base-url=http://localhost:8081
~~~

## 21.6 `localhost` em Docker

Dentro de um container, `localhost` representa o próprio container, não necessariamente a máquina host ou outro serviço.

## 21.7 Uso de `javax.*`

Em Spring Boot 3, utilize APIs Jakarta quando necessário:

~~~java
import jakarta.servlet.*;
~~~

Não utilize:

~~~java
import javax.servlet.*;
~~~

Nesta etapa específica, nenhum import Jakarta é necessário diretamente.

## 21.8 Testes acessando o serviço real

Os testes unitários do `InventoryClient` utilizam mocks. O `inventory-service` não precisa estar em execução para esses testes.

## 21.9 Uso excessivo de `@SpringBootTest`

`@SpringBootTest` carrega o contexto completo e pode tornar testes simples mais lentos.

Para testar somente um Controller, `@WebMvcTest` é mais apropriado.

## 21.10 Ignorar resposta vazia

Uma resposta HTTP sem corpo não deve ser aceita silenciosamente. O cliente transforma esse cenário em uma falha controlada.

---

# 22. Limitações conhecidas

- O `order-service` ainda não possui pedidos;
- Não há banco de dados;
- O cliente HTTP é síncrono e bloqueante;
- O tratamento de erros é básico;
- Não há retry;
- Não há circuit breaker;
- Não há fallback avançado;
- Não há autenticação;
- Não há autorização;
- Não há logs estruturados;
- Não há métricas;
- Não há tracing;
- Não há Service Discovery;
- A URL padrão utiliza `localhost`;
- Não há teste de integração com dois processos reais;
- Não há versionamento formal do contrato;
- O health check não substitui uma solução completa de observabilidade.

---

# CONTEXTO-PARA-NEXT-ETAPA

## O que foi implementado

- Criado o `order-service`;
- Configurada a porta `8082`;
- Criado o health check local;
- Criado o endpoint de verificação da dependência;
- Implementada comunicação HTTP síncrona;
- Utilizado o `RestClient`;
- Configurados timeout de conexão e leitura;
- Implementado tratamento básico de indisponibilidade;
- Criados testes de camada web;
- Criados testes unitários do cliente HTTP;
- Criada documentação inicial.

## Arquivos criados ou alterados

~~~text
order-service/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/orderstock/order/
    │   │   ├── OrderServiceApplication.java
    │   │   ├── client/InventoryClient.java
    │   │   ├── config/RestClientConfig.java
    │   │   ├── controller/HealthController.java
    │   │   ├── dto/DependencyHealthResponse.java
    │   │   ├── dto/HealthResponse.java
    │   │   ├── dto/InventoryHealthResponse.java
    │   │   ├── exception/InventoryServiceUnavailableException.java
    │   │   └── service/InventoryDependencyService.java
    │   └── resources/application.properties
    └── test/
        └── java/com/orderstock/order/
            ├── client/InventoryClientTest.java
            └── controller/HealthControllerTest.java
~~~

Também poderá ser criado ou alterado:

~~~text
README.md
~~~

na raiz do monorepo.

## Versões utilizadas

- Java: 17;
- Maven: 3.9 ou superior;
- Spring Boot: 3.5.4 no exemplo;
- Spring Web: versão gerenciada pelo Spring Boot;
- Spring Boot Test: versão gerenciada pelo Spring Boot;
- JUnit: versão gerenciada pelo Spring Boot;
- Mockito: versão gerenciada pelo Spring Boot.

## Portas utilizadas

- `inventory-service`: `8081`;
- `order-service`: `8082`.

## Endpoints disponíveis

### `inventory-service`

~~~http
GET http://localhost:8081/api/inventory/health
~~~

### `order-service`

~~~http
GET http://localhost:8082/api/orders/health
~~~

~~~http
GET http://localhost:8082/api/orders/dependencies/inventory/health
~~~

## Fluxo de comunicação

~~~mermaid
sequenceDiagram
    participant Client as Cliente
    participant Order as order-service
    participant Inventory as inventory-service

    Client->>Order: GET /api/orders/dependencies/inventory/health
    Order->>Inventory: GET /api/inventory/health

    alt inventory-service disponível
        Inventory-->>Order: 200 + JSON
        Order-->>Client: 200 + status UP
    else inventory-service indisponível
        Inventory--xOrder: Timeout ou conexão recusada
        Order-->>Client: 503 + status DOWN
    end
~~~

## Cliente HTTP escolhido e justificativa

Foi escolhido o `RestClient` porque:

- é síncrono;
- possui API moderna;
- é compatível com Spring Boot 3.x;
- evita introduzir programação reativa;
- é suficiente para a integração inicial.

## Configuração externa criada

~~~properties
inventory-service.base-url=http://localhost:8081
inventory-service.timeout.connect=2s
inventory-service.timeout.read=3s
~~~

## Tratamento de erros implementado

Foram tratados:

- falha de conexão;
- timeout;
- erro HTTP 5xx;
- resposta vazia;
- conversão para `InventoryServiceUnavailableException`;
- retorno HTTP 503;
- resposta JSON com status `DOWN`.

## Timeout implementado

- Connection timeout: `2s`;
- Read timeout: `3s`.

## Testes criados

- Teste web do health check local;
- teste web da dependência disponível;
- teste web da dependência indisponível;
- teste unitário de sucesso do cliente;
- teste unitário de falha de comunicação;
- teste unitário de erro HTTP 5xx;
- teste unitário de resposta vazia.

## Comandos que devem funcionar

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

Validação:

~~~bash
curl -i http://localhost:8081/api/inventory/health
curl -i http://localhost:8082/api/orders/health
curl -i http://localhost:8082/api/orders/dependencies/inventory/health
~~~

## Problemas encontrados

Nenhum problema foi registrado até o momento.

Caso ocorra algum erro, registrar:

- mensagem completa;
- comando executado;
- sistema operacional;
- resultado de `java -version`;
- resultado de `mvn -version`;
- arquivo relacionado;
- solução aplicada.

## Diferenças entre o ambiente utilizado e o exemplo

Preencher após a execução:

- sistema operacional;
- versão exata do JDK;
- versão exata do Maven;
- versão exata do Spring Boot;
- ferramenta utilizada para chamadas HTTP;
- diferenças de comandos;
- alterações necessárias no código.

## Commits realizados

Sugestões:

~~~text
feat(order-service): create initial Spring Boot service
feat(order-service): add local health check endpoint
test(order-service): add health check web tests
feat(order-service): add inventory HTTP client
test(order-service): add inventory client unit tests
docs(order-service): document integration and execution
~~~

## Conceitos para revisar

- Comunicação síncrona;
- Acoplamento temporal;
- Acoplamento estrutural;
- RestClient;
- Timeout;
- HTTP 503;
- DTO externo e DTO interno;
- Controller;
- Service;
- Client;
- Teste unitário;
- `@WebMvcTest`;
- `MockMvc`;
- Configuração externa;
- Diferença entre `localhost` local e em containers.

## Exercício adicional proposto

Criar um endpoint de disponibilidade de produto no `inventory-service`, consumi-lo no `order-service`, tratar HTTP 404 e criar testes correspondentes.

## Próximos objetivos

Depois da confirmação desta etapa:

1. revisar a implementação;
2. verificar eventuais ajustes no tratamento global de erros;
3. avaliar testes de integração com servidor HTTP simulado;
4. criar uma operação simples de produto;
5. somente depois iniciar a modelagem de pedidos.

Não avançar ainda para produtos, pedidos ou banco de dados antes da validação desta etapa.