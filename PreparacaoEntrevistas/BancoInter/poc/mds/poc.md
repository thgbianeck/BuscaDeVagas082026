# POC Java 21 para uma Plataforma Bancária Production-like Local

## 1. Objetivo da POC

Vamos construir, passo a passo, uma plataforma bancária fictícia chamada **InterBank Lab**.

A aplicação simulará o fluxo de uma transferência entre contas e abordará:

- Java 21 LTS;
- Spring Boot;
- arquitetura de microsserviços;
- APIs REST;
- Apache Kafka;
- comunicação assíncrona;
- PostgreSQL;
- MongoDB;
- idempotência;
- consistência eventual;
- padrão Outbox;
- Saga;
- resiliência;
- observabilidade;
- autenticação e autorização;
- containers Docker;
- simulação local de serviços AWS;
- testes de integração com Testcontainers;
- CI/CD;
- arquitetura preparada para nuvem;
- padrões arquiteturais e Design Patterns;
- boas práticas de desenvolvimento;
- explicação didática para preparação para entrevistas de nível sênior/especialista.

A aplicação será executada localmente, sem necessidade de manter recursos pagos na AWS.

A ideia não será simplesmente “rodar tudo em Docker”. O objetivo será criar uma estrutura local que se aproxime de um ambiente real:

- cada serviço executará isoladamente;
- cada serviço terá seu próprio banco;
- a comunicação entre serviços ocorrerá por HTTP e eventos;
- haverá autenticação;
- haverá observabilidade;
- haverá health checks;
- haverá métricas;
- haverá traces distribuídos;
- haverá filas, tópicos e dead-letter;
- haverá testes com infraestrutura real em containers;
- haverá configuração por ambiente;
- haverá controle de dependências;
- haverá simulação de falhas.

> Esta é uma POC educacional. Ela não deve ser utilizada diretamente para movimentações financeiras reais. Um sistema bancário real exigiria requisitos adicionais de segurança, compliance, auditoria, antifraude, criptografia, alta disponibilidade, recuperação de desastre, certificações e controles regulatórios.

---

# 2. Decisões técnicas principais

## 2.1 Java

Será utilizado:

- Java 21 LTS;
- Maven;
- imagens Docker baseadas em Eclipse Temurin 21;
- records, sealed classes, pattern matching, virtual threads e APIs modernas quando fizer sentido.

Java 21 foi escolhido porque é uma versão LTS e possui documentação oficial consolidada.

## 2.2 Spring Boot

A recomendação inicial será:

- Spring Boot 3.5.x;
- Spring Framework 6.2.x;
- Spring Cloud 2025.0.x, somente quando necessário;
- Java 21.

A documentação consultada informa que o Spring Boot 3.5.16 requer no mínimo Java 17 e é compatível até Java 25.

Embora o Spring Boot 4.1.0 seja a linha estável mais recente encontrada na documentação, a primeira implementação utilizará Spring Boot 3.5.x pelos seguintes motivos:

- maior maturidade do ecossistema em projetos Java 21;
- menor quantidade de migrações durante o aprendizado;
- compatibilidade consolidada com bibliotecas de persistência, mensageria e observabilidade;
- maior quantidade de exemplos e materiais disponíveis;
- possibilidade de estudar posteriormente a migração para Spring Boot 4.

A arquitetura será construída de modo que a migração para Spring Boot 4 possa ser feita posteriormente como exercício avançado.

## 2.3 Banco relacional

Será utilizado:

- PostgreSQL 18, fixando a versão principal no ambiente local;
- Flyway para versionamento do schema;
- Spring Data JPA;
- Testcontainers para testes de integração.

O PostgreSQL será usado nos contextos que exigem:

- transações;
- integridade referencial;
- concorrência;
- constraints;
- consultas relacionais;
- histórico financeiro.

## 2.4 Banco não relacional

Será utilizado:

- MongoDB 8.x, com a versão exata fixada no arquivo de configuração;
- Spring Data MongoDB.

O MongoDB será usado no `notification-service`, que terá documentos flexíveis contendo:

- dados da notificação;
- canais;
- tentativas;
- payload do evento;
- status;
- histórico de processamento.

## 2.5 Mensageria

Serão utilizados dois estilos de mensageria:

### Apache Kafka

Será utilizado para:

- eventos de negócio;
- retenção;
- replay;
- múltiplos consumidores;
- particionamento;
- processamento de alto volume;
- rastreamento de offsets;
- demonstração de consumer groups.

### LocalStack com SQS e SNS

Será utilizado para demonstrar:

- filas de trabalho;
- fan-out;
- notificações;
- integração com serviços AWS;
- diferenças entre streaming de eventos e filas tradicionais.

Kafka não será substituído pelo LocalStack, porque representam modelos arquiteturais diferentes.

## 2.6 Observabilidade

A stack local será composta por:

- Spring Boot Actuator;
- Micrometer;
- OpenTelemetry;
- OpenTelemetry Collector;
- Prometheus;
- Grafana;
- Jaeger;
- logs estruturados em JSON.

O OpenTelemetry Collector funcionará como camada intermediária para receber, processar e encaminhar telemetria.

## 2.7 Simulação de nuvem

O LocalStack será utilizado para simular localmente alguns serviços AWS, principalmente:

- SQS;
- SNS;
- S3;
- DynamoDB;
- EventBridge, quando aplicável;
- Secrets Manager, em cenários específicos.

Para autenticação, utilizaremos o Keycloak localmente como provedor OIDC. Ele não é uma cópia do Amazon Cognito, mas fornece um ambiente local realista para estudar:

- OAuth 2.0;
- OpenID Connect;
- JWT;
- escopos;
- roles;
- resource server.

---

# 3. Visão geral da arquitetura

A arquitetura será dividida nos seguintes microsserviços:

| Serviço | Responsabilidade | Banco |
|---|---|---|
| `api-gateway` | Entrada externa, roteamento e políticas comuns | Nenhum |
| `transfer-service` | Solicitação e orquestração de transferências | PostgreSQL |
| `account-service` | Contas, saldos, débitos e créditos | PostgreSQL |
| `ledger-service` | Registro imutável dos lançamentos | PostgreSQL |
| `notification-service` | Notificações e histórico de tentativas | MongoDB |
| `fraud-service` | Análise fictícia de risco | PostgreSQL ou MongoDB |
| `identity-server` | Autenticação e emissão de tokens | Keycloak |
| `event-relay` | Publicação de eventos da Outbox | PostgreSQL e Kafka |

Infraestrutura local:

| Componente | Finalidade |
|---|---|
| PostgreSQL | Persistência transacional |
| MongoDB | Persistência documental |
| Kafka | Eventos e streaming |
| Kafka UI | Inspeção de tópicos e mensagens |
| LocalStack | Simulação de serviços AWS |
| Keycloak | OIDC, OAuth2 e JWT |
| Prometheus | Armazenamento de métricas |
| Grafana | Dashboards |
| Jaeger | Visualização de traces |
| OpenTelemetry Collector | Coleta e roteamento de telemetria |
| Mailpit | Simulação de envio de e-mails |
| Redis, opcional | Cache e rate limiting |

---

## 3.1 Diagrama de arquitetura

~~~mermaid
flowchart TB
    Client[Cliente HTTP ou Frontend] --> Gateway[API Gateway]

    Gateway --> Auth[Keycloak]
    Gateway --> Transfer[Transfer Service]

    Transfer --> TransferDB[(PostgreSQL<br/>transfer-db)]
    Transfer --> Outbox[(Outbox<br/>transfer-service)]
    Outbox --> Relay[Event Relay]
    Relay --> Kafka[(Apache Kafka)]

    Kafka --> Account[Account Service]
    Kafka --> Ledger[Ledger Service]
    Kafka --> Notification[Notification Service]
    Kafka --> Fraud[Fraud Service]

    Account --> AccountDB[(PostgreSQL<br/>account-db)]
    Ledger --> LedgerDB[(PostgreSQL<br/>ledger-db)]
    Notification --> Mongo[(MongoDB<br/>notification-db)]
    Fraud --> FraudDB[(PostgreSQL<br/>fraud-db)]

    Notification --> Mailpit[Mailpit]
    Notification --> LocalStack[LocalStack]
    LocalStack --> SQS[SQS]
    LocalStack --> SNS[SNS]
    LocalStack --> S3[S3]

    Transfer -. Telemetria .-> OTel[OpenTelemetry Collector]
    Account -. Telemetria .-> OTel
    Ledger -. Telemetria .-> OTel
    Notification -. Telemetria .-> OTel
    Fraud -. Telemetria .-> OTel
    Gateway -. Telemetria .-> OTel

    OTel --> Prometheus[Prometheus]
    OTel --> Jaeger[Jaeger]
    OTel --> Grafana[Grafana]
~~~

---

# 4. Fluxo principal de negócio

O fluxo principal será uma transferência entre duas contas.

## 4.1 Fluxo funcional

1. O cliente autentica no Keycloak.
2. O cliente envia uma solicitação para o `api-gateway`.
3. O gateway valida o token.
4. O gateway encaminha a solicitação ao `transfer-service`.
5. O `transfer-service` valida os dados básicos.
6. O serviço verifica a chave de idempotência.
7. A transferência é salva como `PENDING`.
8. Um evento é salvo na tabela Outbox.
9. A transação local é confirmada.
10. O `event-relay` publica o evento no Kafka.
11. O `fraud-service` realiza uma análise fictícia.
12. O `account-service` valida e atualiza os saldos.
13. O `ledger-service` registra os lançamentos.
14. O `notification-service` registra e envia uma notificação.
15. O `transfer-service` atualiza o estado da transferência.
16. O cliente consulta o resultado.

## 4.2 Diagrama de sequência

~~~mermaid
sequenceDiagram
    autonumber

    participant C as Cliente
    participant G as API Gateway
    participant T as Transfer Service
    participant DB as Transfer DB
    participant O as Outbox
    participant R as Event Relay
    participant K as Kafka
    participant F as Fraud Service
    participant A as Account Service
    participant L as Ledger Service
    participant N as Notification Service

    C->>G: POST /transfers
    G->>G: Validar JWT
    G->>T: Encaminhar requisição

    T->>T: Validar idempotência
    T->>DB: Salvar transferência PENDING
    T->>O: Salvar TransferRequested
    T-->>C: 202 Accepted

    R->>O: Buscar eventos pendentes
    R->>K: Publicar TransferRequested
    K-->>F: Consumir evento
    K-->>A: Consumir evento
    K-->>L: Consumir evento
    K-->>N: Consumir evento

    F->>K: Publicar FraudAnalysisCompleted
    A->>K: Publicar AccountBalanceUpdated
    L->>K: Publicar LedgerEntryCreated
    N->>K: Publicar NotificationProcessed

    K-->>T: Consumir eventos do processo
    T->>DB: Atualizar status
~~~

---

# 5. Domínio e Bounded Contexts

A separação dos serviços será orientada pelo domínio, e não apenas por critérios técnicos.

## 5.1 Contexto de contas

Responsável por:

- contas;
- saldos;
- disponibilidade;
- status da conta;
- débito;
- crédito;
- bloqueios;
- limites operacionais.

Esse contexto não deve conhecer detalhes internos do ledger ou das notificações.

## 5.2 Contexto de transferências

Responsável por:

- receber a intenção do cliente;
- validar a solicitação;
- controlar o ciclo de vida;
- orquestrar a Saga;
- garantir idempotência da solicitação;
- expor o status da transferência.

## 5.3 Contexto contábil

Responsável por:

- lançamentos de débito;
- lançamentos de crédito;
- auditoria;
- reconciliação;
- histórico imutável;
- consultas financeiras.

O ledger não deve simplesmente sobrescrever lançamentos antigos. Correções devem gerar novos lançamentos compensatórios.

## 5.4 Contexto de notificações

Responsável por:

- notificação por e-mail;
- notificação por SMS simulado;
- notificação por webhook;
- tentativas;
- backoff;
- falhas;
- histórico.

## 5.5 Contexto antifraude

Responsável por:

- analisar risco;
- simular regras;
- aprovar;
- rejeitar;
- solicitar análise manual.

---

# 6. Modelo de estados da transferência

A transferência será modelada como uma máquina de estados.

~~~mermaid
stateDiagram-v2
    [*] --> PENDING

    PENDING --> FRAUD_ANALYSIS
    FRAUD_ANALYSIS --> FRAUD_APPROVED
    FRAUD_ANALYSIS --> REJECTED

    FRAUD_APPROVED --> DEBITING
    DEBITING --> DEBITED
    DEBITING --> FAILED

    DEBITED --> CREDITING
    CREDITING --> CREDITED
    CREDITING --> COMPENSATING
    COMPENSATING --> COMPENSATED
    COMPENSATED --> FAILED

    CREDITED --> LEDGER_REGISTERING
    LEDGER_REGISTERING --> COMPLETED
    LEDGER_REGISTERING --> FAILED

    COMPLETED --> [*]
    REJECTED --> [*]
    FAILED --> [*]
~~~

Cada transição deverá:

- ser válida;
- ser persistida;
- possuir evento correspondente;
- ser observável;
- poder ser auditada;
- não permitir regressões indevidas.

Exemplo de transição inválida:

- `COMPLETED` voltar para `PENDING`.

---

# 7. Comunicação síncrona e assíncrona

## 7.1 REST e HTTP

Será usado REST para:

- criação de transferências;
- consulta de transferências;
- consulta de contas;
- consulta de extratos;
- health checks;
- APIs administrativas.

Exemplo:

~~~http
POST /api/v1/transfers
Authorization: Bearer <token>
Idempotency-Key: 57f1d1e2-02e6-4e25-a11c-2d8e7cbce1e1
Content-Type: application/json

{
  "sourceAccountId": "acc-001",
  "destinationAccountId": "acc-002",
  "amount": 100.00,
  "currency": "BRL"
}
~~~

Resposta:

~~~json
{
  "transferId": "trf-001",
  "status": "PENDING",
  "createdAt": "2026-09-04T10:15:00Z"
}
~~~

O status `202 Accepted` será utilizado porque a operação será processada de forma assíncrona.

## 7.2 Kafka

Kafka será usado quando:

- vários serviços precisam reagir ao mesmo evento;
- existe necessidade de retenção;
- existe necessidade de replay;
- o fluxo é orientado a eventos;
- o volume pode crescer;
- consumidores possuem ritmos diferentes.

## 7.3 SQS

SQS será usado para:

- filas de trabalho;
- processamento assíncrono isolado;
- absorção de picos;
- integração com componentes AWS;
- tarefas que precisam ser consumidas por um trabalhador.

## 7.4 SNS

SNS será usado para:

- fan-out;
- publicação para vários assinantes;
- envio para múltiplas filas;
- simulação de notificações.

---

# 8. Kafka: conceitos que serão praticados

## 8.1 Tópicos

Os tópicos seguirão uma convenção versionada:

~~~text
banking.transfer.requested.v1
banking.transfer.fraud-approved.v1
banking.transfer.fraud-rejected.v1
banking.account.debited.v1
banking.account.credited.v1
banking.ledger.entry-created.v1
banking.transfer.completed.v1
banking.transfer.failed.v1
banking.notification.requested.v1
~~~

## 8.2 Partições

O identificador da transferência será utilizado como chave dos eventos relacionados àquela transferência.

Isso ajuda a manter os eventos da mesma transferência na mesma partição.

~~~mermaid
flowchart LR
    EventA[TransferRequested<br/>key=trf-001] --> Hash[Particionador]
    EventB[AccountDebited<br/>key=trf-001] --> Hash
    EventC[TransferCompleted<br/>key=trf-001] --> Hash

    Hash --> P0[Partition 0]

    EventD[TransferRequested<br/>key=trf-002] --> Hash
    Hash --> P1[Partition 1]
~~~

A ordem é garantida dentro da partição, não necessariamente entre todas as partições.

## 8.3 Consumer groups

Cada capacidade de negócio terá seu próprio grupo:

~~~text
account-service-group
ledger-service-group
notification-service-group
fraud-service-group
transfer-orchestrator-group
~~~

O mesmo evento poderá ser consumido independentemente por vários grupos.

## 8.4 Entrega at-least-once

A POC utilizará principalmente o modelo `at-least-once`.

Isso significa:

- o evento não deve ser perdido;
- o evento pode ser entregue novamente;
- o consumidor deve ser idempotente.

## 8.5 Retry e Dead Letter Topic

Mensagens com falhas temporárias serão reprocessadas.

Mensagens inválidas ou que excederem as tentativas serão encaminhadas para um tópico de erro:

~~~text
banking.transfer.requested.dlt.v1
banking.account.events.dlt.v1
banking.notification.events.dlt.v1
~~~

Fluxo:

~~~mermaid
flowchart TD
    Message[Mensagem recebida] --> Process[Processar]
    Process --> Success{Sucesso?}
    Success -->|Sim| Commit[Commit do offset]
    Success -->|Não| Retry{Tentativas restantes?}
    Retry -->|Sim| Backoff[Esperar backoff]
    Backoff --> Process
    Retry -->|Não| DLT[Publicar na Dead Letter Topic]
    DLT --> Alert[Gerar alerta]
~~~

---

# 9. Contrato de eventos

Os eventos terão envelope padronizado.

~~~json
{
  "eventId": "evt-001",
  "eventType": "TransferRequested",
  "eventVersion": 1,
  "occurredAt": "2026-09-04T10:15:00Z",
  "producer": "transfer-service",
  "correlationId": "corr-001",
  "causationId": "cmd-001",
  "aggregateType": "TRANSFER",
  "aggregateId": "trf-001",
  "traceId": "trace-001",
  "payload": {
    "sourceAccountId": "acc-001",
    "destinationAccountId": "acc-002",
    "amount": 100.00,
    "currency": "BRL"
  }
}
~~~

## 9.1 Regras para eventos

Um evento deve:

- representar algo que ocorreu;
- ser imutável;
- possuir identificador único;
- possuir versão;
- possuir data de ocorrência;
- possuir correlação;
- possuir o identificador do agregado;
- evitar dados sensíveis;
- ser compatível com evolução futura.

Comando:

~~~text
ProcessTransfer
~~~

Evento:

~~~text
TransferRequested
~~~

---

# 10. Idempotência

Idempotência é obrigatória em um sistema assíncrono.

Considere o fluxo:

1. O consumidor recebe `TransferRequested`.
2. Debita a conta.
3. O débito é confirmado.
4. O processo falha antes do commit do offset.
5. Kafka entrega o evento novamente.
6. O consumidor recebe o mesmo evento.

Sem idempotência, o saldo poderia ser debitado duas vezes.

## 10.1 Tabela de mensagens processadas

Cada serviço poderá possuir uma tabela como:

~~~sql
CREATE TABLE processed_messages (
    message_id UUID PRIMARY KEY,
    event_type VARCHAR(200) NOT NULL,
    aggregate_id UUID NOT NULL,
    processed_at TIMESTAMPTZ NOT NULL
);
~~~

O processamento ocorrerá dentro da mesma transação da regra de negócio.

~~~mermaid
flowchart TD
    Receive[Receber evento] --> Exists{message_id já existe?}
    Exists -->|Sim| Ignore[Ignorar com segurança]
    Exists -->|Não| Begin[Iniciar transação]
    Begin --> Business[Executar regra de negócio]
    Business --> Register[Registrar mensagem processada]
    Register --> Commit[Confirmar transação]
    Commit --> Ack[Confirmar offset]
    Business --> Failure{Falha?}
    Failure -->|Sim| Rollback[Rollback]
    Rollback --> Retry[Retry]
~~~

## 10.2 Idempotência da API

A API também deve ser idempotente.

O cliente enviará:

~~~http
Idempotency-Key: 57f1d1e2-02e6-4e25-a11c-2d8e7cbce1e1
~~~

A chave deverá ser única por cliente e operação.

Tabela:

~~~sql
CREATE TABLE idempotency_records (
    id UUID PRIMARY KEY,
    client_id VARCHAR(100) NOT NULL,
    idempotency_key VARCHAR(200) NOT NULL,
    request_hash VARCHAR(128) NOT NULL,
    response_status INTEGER,
    response_body JSONB,
    created_at TIMESTAMPTZ NOT NULL,
    UNIQUE (client_id, idempotency_key)
);
~~~

Se a mesma requisição for repetida:

- a transferência original será retornada;
- nenhuma nova transferência será criada;
- se o payload for diferente, a API retornará erro de conflito.

---

# 11. Outbox Pattern

O Outbox Pattern resolverá o problema de inconsistência entre banco e Kafka.

## 11.1 Problema sem Outbox

~~~mermaid
flowchart TD
    Request[Solicitação] --> Save[Salvar transferência]
    Request --> Publish[Publicar evento no Kafka]

    Save --> Failure{Falha entre operações?}
    Publish --> Failure

    Failure --> Inconsistent[Transferência salva sem evento<br/>ou evento publicado sem estado persistido]
~~~

Uma transação local não consegue garantir atomicidade entre:

- PostgreSQL;
- Kafka;
- outro banco;
- APIs externas.

## 11.2 Solução com Outbox

A alteração de negócio e o evento são salvos na mesma transação local.

~~~mermaid
flowchart TD
    Request[Solicitação] --> Transaction[Transação PostgreSQL]
    Transaction --> Transfer[Salvar transferência]
    Transaction --> Outbox[Salvar evento Outbox]
    Transfer --> Commit[Commit]
    Outbox --> Commit

    Commit --> Relay[Event Relay]
    Relay --> Kafka[Kafka]
    Kafka --> Published[Marcar evento como publicado]
~~~

Tabela:

~~~sql
CREATE TABLE outbox_events (
    id UUID PRIMARY KEY,
    aggregate_type VARCHAR(100) NOT NULL,
    aggregate_id UUID NOT NULL,
    event_type VARCHAR(200) NOT NULL,
    event_version INTEGER NOT NULL,
    payload JSONB NOT NULL,
    status VARCHAR(30) NOT NULL,
    occurred_at TIMESTAMPTZ NOT NULL,
    published_at TIMESTAMPTZ,
    attempts INTEGER NOT NULL DEFAULT 0,
    last_error TEXT
);
~~~

Estados:

~~~text
PENDING
PUBLISHING
PUBLISHED
FAILED
~~~

O Relay deverá:

- buscar eventos pendentes;
- bloquear ou reservar os eventos;
- publicar no Kafka;
- aplicar retry;
- registrar erro;
- marcar como publicados;
- evitar processamento concorrente indevido.

---

# 12. Saga

Uma transferência distribuída não será implementada como uma única transação global.

Cada serviço terá sua própria transação local.

A coordenação será feita por uma Saga.

## 12.1 Saga orquestrada

O `transfer-service` será o orquestrador inicial.

Ele acompanhará:

- análise antifraude;
- débito;
- crédito;
- lançamento;
- notificação;
- compensação.

Vantagens:

- fluxo explícito;
- fácil de explicar em entrevistas;
- rastreabilidade central;
- melhor controle de estados.

Desvantagens:

- o orquestrador pode ficar complexo;
- é necessário evitar que ele se torne um “deus” do domínio;
- cada serviço ainda precisa manter suas próprias regras.

## 12.2 Saga coreografada

Em uma etapa posterior, implementaremos uma comparação com coreografia.

Nesse modelo:

- cada serviço reage a eventos;
- cada serviço publica novos eventos;
- não existe um controlador central explícito.

A coreografia é mais descentralizada, mas pode tornar o fluxo difícil de visualizar.

---

# 13. Bancos de dados por serviço

A regra será:

> Cada microsserviço é dono dos seus dados.

Mesmo localmente, evitaremos que todos os serviços compartilhem as mesmas tabelas.

## 13.1 PostgreSQL

Podemos utilizar um único container PostgreSQL local com bancos separados:

~~~text
transfer_db
account_db
ledger_db
fraud_db
~~~

Isso economiza recursos do computador, mas mantém separação lógica.

Em um ambiente mais próximo de produção, poderemos executar um container PostgreSQL por serviço.

## 13.2 Migrações

Cada serviço terá suas próprias migrações Flyway:

~~~text
transfer-service
└── db/migration
    ├── V1__create_transfers.sql
    ├── V2__create_outbox_events.sql
    └── V3__create_idempotency_records.sql

account-service
└── db/migration
    ├── V1__create_accounts.sql
    └── V2__create_processed_messages.sql
~~~

## 13.3 Concorrência no saldo

O saldo é um dos pontos mais importantes da POC.

Precisamos evitar:

1. duas operações lerem o mesmo saldo;
2. ambas validarem o saldo;
3. ambas debitarem;
4. o saldo ficar incorreto.

Estudaremos:

- `SELECT FOR UPDATE`;
- optimistic locking;
- pessimistic locking;
- versionamento;
- transações;
- isolamento;
- retry de conflito;
- limites por conta.

Exemplo conceitual:

~~~sql
UPDATE accounts
SET balance = balance - :amount,
    version = version + 1,
    updated_at = CURRENT_TIMESTAMP
WHERE id = :accountId
  AND balance >= :amount
  AND version = :expectedVersion;
~~~

O código deverá verificar a quantidade de linhas afetadas.

Se for zero:

- a conta pode não existir;
- o saldo pode ser insuficiente;
- a versão pode estar desatualizada;
- a operação deve ser reavaliada.

---

# 14. Arquitetura Hexagonal

Cada serviço será organizado utilizando uma variação de arquitetura hexagonal.

~~~mermaid
flowchart LR
    HTTP[REST Controller] --> InboundPort[Porta de entrada]
    KafkaConsumer[Kafka Consumer] --> InboundPort

    InboundPort --> UseCase[Caso de uso]
    UseCase --> Domain[Domínio]
    UseCase --> OutboundPort[Porta de saída]

    OutboundPort --> PostgreSQLAdapter[Adaptador PostgreSQL]
    OutboundPort --> KafkaAdapter[Adaptador Kafka]
    OutboundPort --> MongoAdapter[Adaptador MongoDB]
    OutboundPort --> ExternalAdapter[Adaptador externo]
~~~

Estrutura sugerida:

~~~text
src/main/java/com/interbank/transfer
├── domain
│   ├── model
│   ├── event
│   ├── exception
│   └── service
├── application
│   ├── port
│   │   ├── in
│   │   └── out
│   └── usecase
├── adapter
│   ├── in
│   │   ├── web
│   │   └── messaging
│   └── out
│       ├── persistence
│       ├── messaging
│       └── client
└── configuration
~~~

## 14.1 Regra de dependência

O domínio não deverá depender de:

- Spring;
- Kafka;
- JPA;
- PostgreSQL;
- MongoDB;
- HTTP;
- Docker.

A infraestrutura dependerá da aplicação, e os adaptadores implementarão as portas.

---

# 15. Design Patterns aplicados

| Padrão | Aplicação |
|---|---|
| Strategy | Estratégias de análise antifraude |
| Factory | Criação de eventos |
| Adapter | Kafka, REST, PostgreSQL e MongoDB |
| Repository | Abstração de persistência |
| Observer | Reação a eventos |
| Builder | Construção de mensagens |
| Specification | Regras compostas de validação |
| State | Estados da transferência |
| Outbox | Publicação confiável |
| Saga | Transação distribuída |
| Retry | Falhas temporárias |
| Circuit Breaker | Proteção contra dependências |
| Bulkhead | Isolamento de recursos |
| Idempotent Consumer | Processamento duplicado |
| Anti-Corruption Layer | Integração com sistemas externos |

O foco não será colocar padrões artificialmente.

Para cada padrão, responderemos:

1. Qual problema existia?
2. Qual solução foi escolhida?
3. Que alternativa foi descartada?
4. Qual complexidade foi adicionada?
5. Como testar?
6. Como observar?
7. Quando não usar?

---

# 16. Docker e ambiente local

## 16.1 Objetivos do ambiente Docker

O ambiente deverá permitir:

- iniciar a infraestrutura com um único comando;
- aguardar dependências saudáveis;
- manter dados em volumes;
- separar ambientes;
- expor somente as portas necessárias;
- simular falhas;
- reproduzir o ambiente em outra máquina;
- executar em CI;
- evitar instalação manual de Kafka, PostgreSQL e MongoDB.

## 16.2 Perfis do Docker Compose

Usaremos perfis para controlar o custo local de recursos:

~~~text
core
observability
cloud
testing
tools
~~~

Exemplos:

- `core`: PostgreSQL, MongoDB, Kafka e Keycloak;
- `observability`: Prometheus, Grafana, Jaeger e Collector;
- `cloud`: LocalStack;
- `tools`: Kafka UI e Mailpit;
- `testing`: serviços auxiliares de teste.

A ideia será permitir:

- iniciar somente o núcleo;
- iniciar observabilidade quando necessário;
- ligar LocalStack apenas nas etapas AWS;
- desligar componentes pesados quando não estiverem sendo estudados.

## 16.3 Health checks

Cada container deverá possuir health check quando possível.

Exemplos de dependências:

~~~mermaid
flowchart TD
    PostgreSQL[PostgreSQL saudável] --> Account[Account Service]
    PostgreSQL --> Transfer[Transfer Service]
    MongoDB[MongoDB saudável] --> Notification[Notification Service]
    Kafka[Kafka saudável] --> Consumers[Consumidores]
    Keycloak[Keycloak saudável] --> Gateway[API Gateway]
    LocalStack[LocalStack saudável] --> AWSAdapters[Adaptadores AWS]
~~~

Health check não substitui:

- retry na aplicação;
- timeout;
- circuit breaker;
- readiness;
- tratamento de reconexão.

Ele apenas ajuda o ambiente a saber se o processo está apto a receber tráfego.

---

# 17. Simulação de serviços AWS

## 17.1 Mapeamento local

| AWS | Simulação local |
|---|---|
| Amazon SQS | LocalStack SQS |
| Amazon SNS | LocalStack SNS |
| Amazon S3 | LocalStack S3 ou MinIO |
| Amazon DynamoDB | LocalStack DynamoDB |
| Amazon EventBridge | LocalStack EventBridge, quando aplicável |
| Amazon Secrets Manager | LocalStack ou variáveis locais controladas |
| Amazon Cognito | Keycloak como provedor OIDC local |
| Amazon CloudWatch | Grafana, Prometheus e OpenTelemetry |
| Amazon MSK | Kafka local |
| Amazon RDS PostgreSQL | PostgreSQL Docker |
| Amazon DocumentDB | MongoDB Docker como aproximação |

## 17.2 Limite importante

LocalStack é um emulador de APIs e comportamentos de serviços AWS.

Ele é útil para:

- desenvolvimento;
- testes de integração;
- validação de infraestrutura;
- experimentos;
- treinamento;
- execução local;
- redução de custos.

Ele não garante equivalência completa com a AWS real.

Não devemos considerar validado localmente:

- latência real da AWS;
- limites de throughput;
- comportamento de rede;
- IAM real;
- políticas reais;
- disponibilidade;
- failover;
- custos;
- limites de conta;
- comportamento regional;
- integração com todos os serviços gerenciados;
- condições reais de produção.

A estratégia será:

1. desenvolver e testar localmente;
2. executar testes de contrato;
3. validar infraestrutura com IaC;
4. executar uma validação controlada em uma conta AWS somente quando necessário;
5. desligar os recursos após o teste.

## 17.3 Exemplo de abstração

A aplicação não deverá depender diretamente de `LocalStack`.

A aplicação dependerá de uma porta:

~~~java
public interface NotificationPublisher {

    void publish(NotificationMessage message);
}
~~~

Implementações:

~~~text
LocalSqsNotificationPublisher
AwsSqsNotificationPublisher
KafkaNotificationPublisher
~~~

A configuração selecionará o adaptador por ambiente.

---

# 18. Autenticação e autorização

## 18.1 Fluxo local

~~~mermaid
sequenceDiagram
    participant User as Usuário
    participant Keycloak as Keycloak
    participant Gateway as API Gateway
    participant Service as Microsserviço

    User->>Keycloak: Solicitar token
    Keycloak-->>User: Access Token JWT
    User->>Gateway: Requisição com Bearer Token
    Gateway->>Gateway: Validar assinatura e claims
    Gateway->>Service: Encaminhar contexto
    Service->>Service: Validar escopos e roles
    Service-->>User: Resposta
~~~

## 18.2 Perfis

Serão criados perfis fictícios:

- `CUSTOMER`;
- `OPERATIONS`;
- `AUDITOR`;
- `ADMIN`.

Exemplos de permissões:

~~~text
transfer:write
transfer:read
account:read
ledger:read
notification:read
audit:read
~~~

## 18.3 Regras

- o gateway valida autenticação;
- cada microsserviço valida autorização;
- não confiaremos apenas no gateway;
- tokens não serão registrados nos logs;
- dados sensíveis serão mascarados;
- chaves e segredos não serão versionados;
- endpoints administrativos serão separados;
- actuator será protegido.

---

# 19. Observabilidade

## 19.1 Logs

Os logs serão estruturados.

Exemplo:

~~~json
{
  "timestamp": "2026-09-04T10:15:00Z",
  "level": "INFO",
  "service": "transfer-service",
  "traceId": "abc123",
  "spanId": "def456",
  "correlationId": "corr-001",
  "transferId": "trf-001",
  "event": "TRANSFER_REQUESTED",
  "message": "Transferência recebida para processamento"
}
~~~

Não serão registrados:

- senhas;
- tokens;
- chaves privadas;
- números completos de cartão;
- dados bancários desnecessários;
- credenciais;
- payloads sensíveis sem mascaramento.

## 19.2 Métricas técnicas

Exemplos:

~~~text
http_server_requests_seconds
jvm_memory_used_bytes
jvm_threads_live
hikaricp_connections_active
kafka_consumer_records_consumed_total
kafka_consumer_lag
process_cpu_usage
~~~

## 19.3 Métricas de negócio

Exemplos:

~~~text
transfers_requested_total
transfers_completed_total
transfers_failed_total
transfers_rejected_total
transfer_processing_duration_seconds
fraud_analysis_rejected_total
notifications_sent_total
outbox_events_pending
~~~

## 19.4 Traces distribuídos

Um trace deverá acompanhar:

- requisição HTTP;
- gravação da transferência;
- publicação na Outbox;
- publicação no Kafka;
- consumo no `account-service`;
- operação no PostgreSQL;
- publicação do evento de débito;
- registro no ledger;
- envio de notificação.

~~~mermaid
flowchart LR
    Root[HTTP Request<br/>traceId=abc] --> TransferSpan[Transfer Service]
    TransferSpan --> DBSpan[PostgreSQL]
    TransferSpan --> OutboxSpan[Outbox]
    OutboxSpan --> KafkaSpan[Kafka Producer]
    KafkaSpan --> AccountSpan[Account Consumer]
    AccountSpan --> AccountDBSpan[Account PostgreSQL]
    AccountSpan --> LedgerEvent[Ledger Event]
    LedgerEvent --> LedgerSpan[Ledger Consumer]
    LedgerSpan --> LedgerDBSpan[Ledger PostgreSQL]
~~~

## 19.5 Dashboards

O Grafana terá dashboards para:

- saúde dos serviços;
- latência HTTP;
- erros por endpoint;
- transferências por status;
- atraso dos consumidores Kafka;
- quantidade de eventos na Outbox;
- falhas de processamento;
- uso de CPU e memória;
- conexões de banco;
- taxa de retries;
- mensagens em dead-letter.

---

# 20. Resiliência

A aplicação será projetada para lidar com falhas.

## 20.1 Timeout

Toda chamada externa deverá possuir timeout.

Sem timeout, uma thread pode ficar bloqueada indefinidamente.

## 20.2 Retry

Retry será usado apenas para falhas transitórias:

- timeout;
- conexão recusada;
- indisponibilidade temporária;
- erro 5xx;
- rebalanceamento de consumidor.

Não haverá retry automático para:

- payload inválido;
- saldo insuficiente;
- autorização negada;
- recurso inexistente;
- erro de regra de negócio.

## 20.3 Backoff

Será utilizado backoff exponencial:

~~~text
tentativa 1: 1 segundo
tentativa 2: 2 segundos
tentativa 3: 4 segundos
tentativa 4: 8 segundos
~~~

Com jitter para evitar que várias instâncias tentem novamente exatamente ao mesmo tempo.

## 20.4 Circuit Breaker

O circuit breaker protegerá chamadas síncronas.

Estados:

~~~mermaid
stateDiagram-v2
    [*] --> Closed
    Closed --> Open: Falhas acima do limite
    Open --> HalfOpen: Tempo de espera concluído
    HalfOpen --> Closed: Chamadas voltam a funcionar
    HalfOpen --> Open: Falha novamente
~~~

## 20.5 Bulkhead

O isolamento de recursos impedirá que uma dependência consuma todos os recursos da aplicação.

Exemplos:

- pool separado para integrações;
- limites de concorrência;
- filas internas;
- limites de conexões;
- circuit breakers independentes.

## 20.6 Rate limiting

Será aplicado no gateway para evitar:

- abuso;
- sobrecarga;
- explosão de retries;
- chamadas acidentais em loop.

---

# 21. Estratégia de testes

## 21.1 Testes unitários

Serão testados:

- regras de domínio;
- transições de estado;
- validações;
- cálculo de saldo;
- idempotência;
- estratégias antifraude.

## 21.2 Testes de integração

Serão usados containers reais para:

- PostgreSQL;
- MongoDB;
- Kafka;
- LocalStack;
- Keycloak, quando necessário.

O objetivo do Testcontainers é testar contra serviços reais encapsulados em containers, evitando depender exclusivamente de mocks ou bancos em memória.

## 21.3 Testes de contrato

Serão testados:

- contratos REST;
- schemas de eventos;
- compatibilidade entre produtor e consumidor;
- evolução de versões;
- campos obrigatórios;
- comportamento de eventos desconhecidos.

## 21.4 Testes de idempotência

Cenários:

1. publicar o mesmo evento duas vezes;
2. reenviar a mesma requisição HTTP;
3. interromper o consumidor após atualizar o banco;
4. reiniciar o serviço;
5. confirmar que o efeito ocorreu somente uma vez.

## 21.5 Testes de concorrência

Cenários:

- duas transferências simultâneas;
- saldo insuficiente;
- mesma conta de origem;
- múltiplos consumidores;
- atualização concorrente;
- reprocessamento duplicado.

## 21.6 Testes de falha

Simularemos:

- PostgreSQL indisponível;
- Kafka indisponível;
- consumidor desligado;
- mensagem inválida;
- timeout;
- falha de notificação;
- LocalStack indisponível;
- falha no Relay;
- erro durante compensação.

---

# 22. Estrutura do projeto

Será utilizado um repositório multi-módulo:

~~~text
interbank-lab/
├── README.md
├── pom.xml
├── docker-compose.yml
├── docker-compose.observability.yml
├── docker-compose.cloud.yml
├── .env.example
├── .gitignore
├── docs/
│   ├── architecture/
│   ├── adr/
│   ├── events/
│   └── runbooks/
├── infrastructure/
│   ├── kafka/
│   ├── postgres/
│   ├── mongodb/
│   ├── localstack/
│   ├── keycloak/
│   └── observability/
├── services/
│   ├── api-gateway/
│   ├── transfer-service/
│   ├── account-service/
│   ├── ledger-service/
│   ├── notification-service/
│   └── fraud-service/
├── libraries/
│   ├── event-contracts/
│   ├── observability-starter/
│   └── test-support/
└── scripts/
    ├── bootstrap.sh
    ├── create-topics.sh
    ├── create-queues.sh
    └── smoke-test.sh
~~~

## 22.1 Monorepo ou multirepo?

A POC utilizará monorepo por motivos didáticos:

- facilita subir tudo junto;
- simplifica o Docker Compose;
- facilita o compartilhamento de contratos;
- permite executar todos os testes;
- facilita o estudo da arquitetura completa.

Em uma organização real, a escolha dependeria de:

- autonomia dos times;
- governança;
- ciclo de deploy;
- versionamento;
- ownership;
- políticas de segurança;
- necessidade de reutilização.

---

# 23. Roadmap de construção

## Parte 1 — Fundamentos e ambiente

Conteúdo:

- instalação do Java 21;
- Maven;
- Docker;
- Docker Compose;
- estrutura do repositório;
- primeiros containers;
- health checks;
- profiles;
- configuração por ambiente.

Resultado:

- ambiente local reproduzível;
- PostgreSQL funcionando;
- MongoDB funcionando;
- Kafka funcionando;
- Keycloak funcionando.

## Parte 2 — Primeiro microsserviço

Será criado o `account-service`.

Conteúdo:

- Spring Boot;
- arquitetura hexagonal;
- entidade;
- objeto de valor;
- repository;
- migração;
- REST;
- validação;
- tratamento de erros;
- testes unitários;
- testes de integração.

## Parte 3 — Operações de saldo

Conteúdo:

- crédito;
- débito;
- saldo insuficiente;
- locking;
- concorrência;
- optimistic locking;
- pessimistic locking;
- auditoria.

## Parte 4 — Transfer Service

Conteúdo:

- criação da transferência;
- idempotency key;
- estados;
- API assíncrona;
- persistência;
- validação;
- erros de domínio.

## Parte 5 — Kafka

Conteúdo:

- producer;
- consumer;
- tópico;
- partição;
- chave;
- offset;
- consumer group;
- retry;
- DLT;
- serialização;
- versionamento.

## Parte 6 — Outbox

Conteúdo:

- problema de dual write;
- tabela Outbox;
- Relay;
- polling;
- publicação;
- retry;
- marcação de status;
- concorrência do Relay.

## Parte 7 — Ledger

Conteúdo:

- lançamentos imutáveis;
- débito;
- crédito;
- auditoria;
- reconciliação;
- consistência eventual.

## Parte 8 — Saga

Conteúdo:

- orquestração;
- compensação;
- falhas intermediárias;
- estados;
- reprocessamento;
- comparação com coreografia.

## Parte 9 — MongoDB e notificações

Conteúdo:

- documentos;
- agregados;
- tentativas;
- histórico;
- canais;
- notificações assíncronas;
- Mailpit;
- SQS.

## Parte 10 — Segurança

Conteúdo:

- Keycloak;
- OAuth2;
- OpenID Connect;
- JWT;
- scopes;
- roles;
- Resource Server;
- autorização por endpoint;
- mascaramento de dados.

## Parte 11 — Observabilidade

Conteúdo:

- Actuator;
- métricas;
- logs estruturados;
- correlation ID;
- trace ID;
- OpenTelemetry;
- Collector;
- Prometheus;
- Grafana;
- Jaeger.

## Parte 12 — Resiliência

Conteúdo:

- timeout;
- retry;
- backoff;
- circuit breaker;
- bulkhead;
- rate limit;
- falhas controladas;
- runbooks.

## Parte 13 — AWS local

Conteúdo:

- LocalStack;
- SQS;
- SNS;
- S3;
- DynamoDB;
- EventBridge;
- diferenças entre LocalStack e AWS real;
- portas de abstração;
- configuração por perfil.

## Parte 14 — Qualidade

Conteúdo:

- testes unitários;
- integração;
- contrato;
- concorrência;
- testes de falha;
- análise estática;
- cobertura;
- revisão arquitetural.

## Parte 15 — CI/CD

Conteúdo:

- build;
- testes;
- criação de imagens;
- verificação de vulnerabilidades;
- publicação local;
- pipeline;
- versionamento;
- estratégia de deploy.

## Parte 16 — Mapeamento para AWS real

Conteúdo:

- ECS ou EKS;
- RDS;
- MSK;
- DocumentDB ou MongoDB gerenciado;
- SQS;
- SNS;
- ECR;
- Secrets Manager;
- IAM;
- VPC;
- CloudWatch;
- X-Ray ou OpenTelemetry;
- custos;
- limites;
- segurança.

---

# 24. O que significa “production-like” neste projeto?

A POC será production-like em práticas, não em escala.

Ela terá:

- isolamento de serviços;
- persistência real;
- mensageria real;
- autenticação;
- observabilidade;
- tolerância a falhas;
- testes de integração;
- contratos;
- configuração externa;
- logs estruturados;
- health checks;
- retries;
- idempotência;
- Outbox;
- Saga;
- Docker;
- documentação;
- pipeline.

Porém, localmente não será possível reproduzir integralmente:

- múltiplas zonas de disponibilidade;
- balanceadores distribuídos;
- discos distribuídos;
- latência real entre regiões;
- failover de serviços gerenciados;
- escalabilidade de centenas de instâncias;
- limites reais dos provedores;
- políticas IAM reais;
- custos e métricas reais de nuvem;
- incidentes de infraestrutura em larga escala.

A POC deve ensinar os princípios e permitir validar a maior parte do comportamento da aplicação.

---

# 25. Convenções de configuração

A aplicação será configurada por ambiente.

Ambientes:

~~~text
local
test
staging
production
~~~

Exemplo conceitual:

~~~yaml
spring:
  application:
    name: transfer-service

  datasource:
    url: ${DB_URL}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}

  kafka:
    bootstrap-servers: ${KAFKA_BOOTSTRAP_SERVERS}

management:
  endpoints:
    web:
      exposure:
        include: health,info,prometheus

app:
  idempotency:
    ttl: ${IDEMPOTENCY_TTL:24h}
~~~

Regras:

- nenhum segredo hardcoded;
- valores locais no `.env`;
- `.env` não será versionado;
- `.env.example` será versionado;
- produção usará secret manager;
- configurações terão defaults seguros;
- endpoints administrativos não serão públicos.

---

# 26. Decisões arquiteturais documentadas

Cada decisão importante será registrada como ADR.

Exemplo:

~~~text
docs/adr/0001-use-kafka-for-business-events.md
docs/adr/0002-use-outbox-pattern.md
docs/adr/0003-use-postgres-per-service-boundary.md
docs/adr/0004-use-keycloak-for-local-oidc.md
docs/adr/0005-use-localstack-for-aws-integration.md
~~~

Modelo:

~~~markdown
# ADR-0001: Utilizar Apache Kafka para eventos de negócio

## Status

Aceita

## Contexto

Vários serviços precisam reagir às mudanças de estado de uma transferência.

## Decisão

Utilizar Apache Kafka com tópicos versionados e consumer groups independentes.

## Alternativas consideradas

- RabbitMQ;
- SQS;
- comunicação HTTP direta;
- banco compartilhado.

## Consequências positivas

- retenção;
- replay;
- vários consumidores;
- particionamento;
- desacoplamento temporal.

## Consequências negativas

- maior complexidade operacional;
- necessidade de idempotência;
- diagnóstico distribuído;
- gerenciamento de partições e offsets.
~~~

---

# 27. Exercícios de entrevista

Durante cada parte, serão incluídas perguntas como:

## Arquitetura

- Por que dividir esse domínio em microsserviços?
- Quais são os limites dos contextos?
- Quando um monólito modular seria melhor?
- Como evitar um distributed monolith?
- Como definir ownership dos dados?

## Kafka

- Qual a diferença entre tópico e partição?
- O que é consumer group?
- Como garantir ordenação?
- O que ocorre durante um rebalanceamento?
- Como lidar com mensagens duplicadas?
- Quando Kafka é inadequado?

## Bancos

- Como evitar lost update?
- Qual o impacto de `SELECT FOR UPDATE`?
- Quando utilizar optimistic locking?
- Como lidar com consistência eventual?
- Por que cada serviço deve controlar seu schema?

## Outbox

- Qual problema o Outbox resolve?
- Por que não publicar diretamente depois do commit?
- O que ocorre se o Relay publicar e falhar antes de marcar como enviado?
- Como evitar duplicidade no consumidor?
- CDC seria uma alternativa?

## Saga

- O que é uma transação distribuída?
- Por que não usar uma transação global?
- Qual a diferença entre orquestração e coreografia?
- Como fazer compensação?
- Toda compensação é um rollback?

## Observabilidade

- Qual a diferença entre monitoramento e observabilidade?
- O que é um trace distribuído?
- Como correlacionar logs entre serviços?
- Qual métrica indica atraso de consumidor Kafka?
- Como diagnosticar aumento de latência?

## Nuvem

- O que LocalStack simula?
- O que só pode ser validado em uma nuvem real?
- Kafka e SQS são equivalentes?
- Quando usar SNS?
- Qual o mapeamento para ECS, RDS, MSK e Secrets Manager?

---

# 28. Critérios de conclusão

A POC estará concluída quando for possível:

1. subir a infraestrutura local com Docker;
2. autenticar um usuário pelo Keycloak;
3. criar contas;
4. consultar saldos;
5. solicitar uma transferência;
6. proteger a API com JWT;
7. aplicar idempotency key;
8. persistir a transferência;
9. persistir o evento na Outbox;
10. publicar o evento no Kafka;
11. consumir o evento em grupos distintos;
12. validar antifraude;
13. debitar a conta de origem;
14. creditar a conta de destino;
15. registrar lançamentos no ledger;
16. gravar a notificação no MongoDB;
17. enviar uma notificação simulada;
18. reprocessar uma mensagem sem duplicar efeitos;
19. enviar falhas permanentes para uma DLT;
20. consultar métricas;
21. visualizar traces;
22. pesquisar logs correlacionados;
23. interromper um serviço e observar o comportamento;
24. executar testes de integração com containers;
25. simular serviços AWS pelo LocalStack;
26. documentar decisões arquiteturais;
27. executar um smoke test;
28. explicar os trade-offs em uma entrevista técnica.

---

# 29. Primeira etapa prática

A primeira etapa de implementação será criar o ambiente base contendo:

- Java 21;
- Maven;
- estrutura multi-módulo;
- Docker Compose;
- PostgreSQL;
- MongoDB;
- Kafka em modo KRaft;
- Kafka UI;
- Keycloak;
- LocalStack;
- Mailpit;
- arquivos de configuração;
- health checks;
- volumes;
- profiles;
- script de inicialização;
- script de criação de tópicos;
- script de criação de filas;
- documentação de execução.

Depois disso, criaremos o primeiro serviço:
text account-service


A ordem será:

1. criar a aplicação Spring Boot;
2. configurar o profile local;
3. conectar ao PostgreSQL;
4. criar a migração inicial;
5. modelar a entidade `Account`;
6. criar o caso de uso de criação;
7. criar o endpoint REST;
8. escrever testes unitários;
9. escrever testes de integração;
10. adicionar Actuator;
11. criar a imagem Docker;
12. executar pelo Compose;
13. validar com uma chamada HTTP;
14. discutir cada decisão.

---

# 30. Prompt de continuidade — Parte 1

Use o prompt abaixo para iniciar a construção prática da primeira parte:

~~~text
Continue a construção da POC InterBank Lab a partir do contexto abaixo.

Contexto já definido:

- A aplicação é uma POC educacional de uma plataforma bancária.
- O objetivo é preparar uma pessoa para uma posição Java Sênior/Especialista.
- A aplicação deve abordar:
  - Java 21 LTS;
  - Spring Boot 3.5.x;
  - microsserviços;
  - Kafka;
  - PostgreSQL;
  - MongoDB;
  - Docker;
  - Docker Compose;
  - LocalStack;
  - SQS;
  - SNS;
  - Keycloak;
  - OAuth2;
  - JWT;
  - OpenTelemetry;
  - Prometheus;
  - Grafana;
  - Jaeger;
  - Testcontainers;
  - Outbox;
  - Saga;
  - idempotência;
  - resiliência;
  - testes;
  - padrões arquiteturais;
  - Design Patterns;
  - preparação para entrevistas.

A execução deverá ser local, sem depender de uma conta paga na AWS.

A arquitetura deve ser production-like, mas sempre deixando claro o que é simulado localmente e o que só pode ser validado em uma nuvem real.

Nesta parte, implemente somente o ambiente base:

1. criar a estrutura inicial do monorepo;
2. criar o Maven multi-módulo;
3. configurar Java 21;
4. criar um Docker Compose modular;
5. adicionar PostgreSQL;
6. adicionar MongoDB;
7. adicionar Kafka em modo KRaft;
8. adicionar Kafka UI;
9. adicionar Keycloak;
10. adicionar LocalStack;
11. adicionar Mailpit;
12. adicionar volumes persistentes;
13. adicionar health checks;
14. adicionar redes Docker;
15. adicionar profiles para core, observability, cloud e tools;
16. adicionar .env.example;
17. documentar todos os comandos necessários;
18. validar que a infraestrutura sobe;
19. criar scripts para criar tópicos Kafka;
20. criar scripts para criar filas e tópicos SNS no LocalStack;
21. explicar detalhadamente cada arquivo;
22. explicar cada decisão arquitetural;
23. incluir perguntas de entrevista;
24. incluir exercícios práticos;
25. incluir um checklist de validação.

Não avance ainda para a implementação dos microsserviços.

Forneça todos os arquivos completos necessários, explique cada seção e mantenha o conteúdo didático.

Quando houver código, utilize blocos internos escapados com:

\~\~\~java
código
\~\~\~

Como o conteúdo ficará dentro de um bloco Markdown externo, não utilize três crases nos blocos internos.
~~~

---

# Fontes oficiais consultadas

- [Oracle — Java SE 21 Documentation](https://docs.oracle.com/en/java/javase/21/docs/index.html)
- [Oracle — Java SE 21 API Specification](https://docs.oracle.com/en/java/javase/21/docs/api/index.html)
- [Spring Boot — System Requirements](https://docs.spring.io/spring-boot/system-requirements.html)
- [Spring Boot 3.5 — System Requirements](https://docs.spring.io/spring-boot/3.5/system-requirements.html)
- [Spring Cloud — Compatibilidade entre versões](https://spring.io/spring-cloud)
- [Docker — Compose File Reference](https://docs.docker.com/reference/compose-file/)
- [Docker — Services e Health Checks](https://docs.docker.com/reference/compose-file/services/)
- [Docker — Compose Profiles](https://docs.docker.com/reference/compose-file/profiles/)
- [Apache Kafka — KRaft](https://kafka.apache.org/43/operations/kraft)
- [Apache Kafka — Docker](https://kafka.apache.org/42/getting-started/docker)
- [PostgreSQL — Documentação atual](https://www.postgresql.org/docs/current/)
- [OpenTelemetry — Collector](https://opentelemetry.io/docs/collector/)
- [OpenTelemetry — Spring Boot Starter](https://opentelemetry.io/docs/zero-code/java/spring-boot-starter/)
- [OpenTelemetry — Quick Start do Collector](https://opentelemetry.io/docs/collector/quick-start)
- [LocalStack — Quickstart](https://docs.localstack.cloud/aws/getting-started/quickstart)
- [LocalStack — Instalação](https://docs.localstack.cloud/aws/getting-started/installation/)
- [AWS — Testes locais com emuladores](https://docs.aws.amazon.com/lambda/latest/dg/testing-guide.html)
- [AWS — LocalStack em aplicações event-driven](https://aws.amazon.com/blogs/compute/enhance-the-local-testing-experience-with-localstack/)
- [Testcontainers — Java](https://testcontainers.com/guides/getting-started-with-testcontainers-for-java)
- [Testcontainers — LocalStack Module](https://java.testcontainers.org/modules/localstack/)