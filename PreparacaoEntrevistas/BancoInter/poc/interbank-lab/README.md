# InterBank Lab — Parte 1: ambiente local

POC educacional Java 21/Spring Boot para estudar microsserviços bancários com uma infraestrutura local e production-like, sem custo de AWS.

## Pré-requisitos

- Java 21 LTS
- Maven 3.9+
- Docker Engine ou Docker Desktop com Compose v2
- pelo menos 8 GB de RAM disponíveis para a stack completa

## Configuração

Copie `.env.example` para `.env` e ajuste apenas se necessário. Os valores padrão são exclusivos para desenvolvimento local.

## Subir a infraestrutura

Núcleo:

    docker compose --profile core up -d

Ferramentas locais:

    docker compose --profile core --profile tools up -d

Observabilidade:

    docker compose --profile core --profile observability up -d

Simulação AWS:

    docker compose --profile core --profile cloud up -d

Stack completa:

    docker compose --profile core --profile tools --profile observability --profile cloud up -d

Ver status e logs:

    docker compose ps
    docker compose logs -f kafka

Criar tópicos Kafka:

    ./scripts/create-kafka-topics.sh

Criar/verificar recursos AWS locais:

    ./scripts/create-cloud-resources.sh

Parar sem apagar dados:

    docker compose down

Apagar volumes locais (destrutivo):

    docker compose down -v

## Portas

| Componente | Endereço |
|---|---|
| PostgreSQL | localhost:5432 |
| MongoDB | localhost:27017 |
| Kafka | localhost:9092 |
| Keycloak | http://localhost:8080 |
| Kafka UI | http://localhost:8085 |
| LocalStack | http://localhost:4566 |
| Mailpit | http://localhost:8025 |
| Prometheus | http://localhost:9090 |
| Grafana | http://localhost:3000 |
| Jaeger | http://localhost:16686 |

## Decisões didáticas

- Kafka usa KRaft com um único nó: simplifica o laboratório, mas não representa alta disponibilidade.
- PostgreSQL compartilha um container, porém mantém bancos separados por contexto; em produção, o isolamento pode usar instâncias/serviços dedicados.
- LocalStack simula APIs AWS, não latência, limites, IAM, disponibilidade ou comportamento operacional de uma conta real.
- Keycloak fornece OIDC local para estudar OAuth2/JWT; não é uma cópia do Cognito.
- Os perfis Compose permitem controlar memória e iniciar apenas o que a etapa exige.
- O arquivo raiz já reserva módulos para serviços e bibliotecas; nenhum microsserviço foi implementado nesta parte.

## Checklist

- [ ] `docker compose --profile core config` não apresenta erro
- [ ] PostgreSQL aparece como healthy
- [ ] MongoDB aparece como healthy
- [ ] Kafka aparece como healthy
- [ ] Keycloak abre no navegador
- [ ] tópicos Kafka foram criados
- [ ] LocalStack lista a fila e o tópico SNS
- [ ] Mailpit abre no navegador
- [ ] Prometheus e Jaeger abrem quando o perfil de observabilidade está ativo
- [ ] `mvn -q validate` termina com sucesso

## Próxima parte

A Parte 2 implementará apenas o `account-service`, começando pelo domínio, persistência, migração, API REST, testes e Actuator.
