# inventory-service

Microsserviço responsável pelo gerenciamento de estoque na POC OrderStock.

## Stack

- Java 17
- Spring Boot 3.5.x
- Maven

## Endpoints disponíveis

| Método | Caminho                     | Descrição               |
|--------|------------------------------|--------------------------|
| GET    | /api/inventory/health         | Verifica se o serviço está ativo |

## Como executar

~~~bash
mvn spring-boot:run
~~~

## Como testar

~~~bash
mvn test
~~~

## Como chamar o endpoint

~~~bash
curl -i http://localhost:8081/api/inventory/health
~~~