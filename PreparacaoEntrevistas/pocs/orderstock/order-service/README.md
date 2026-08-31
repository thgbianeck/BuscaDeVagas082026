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

```properties
server.port=8082
inventory-service.base-url=http://localhost:8081
inventory-service.timeout.connect=2s
inventory-service.timeout.read=3s
```

## Como executar

```bash
mvn spring-boot:run
```

## Como executar os testes

```bash
mvn clean test
```

## Health check local

```http
GET /api/orders/health
```

Exemplo:

```bash
curl -i http://localhost:8082/api/orders/health
```

Resposta:

```json
{
  "service": "order-service",
  "status": "UP"
}
```

## Health check do inventory-service

```http
GET /api/orders/dependencies/inventory/health
```

Exemplo:

```bash
curl -i http://localhost:8082/api/orders/dependencies/inventory/health
```

Quando o inventory-service estiver disponível:

```json
{
  "dependency": "inventory-service",
  "status": "UP",
  "message": null
}
```

Quando o inventory-service estiver indisponível:

```json
{
  "dependency": "inventory-service",
  "status": "DOWN",
  "message": "Inventory service is unavailable"
}
```

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