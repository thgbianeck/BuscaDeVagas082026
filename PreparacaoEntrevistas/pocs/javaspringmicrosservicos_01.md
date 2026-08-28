# Trilha prática: Java Backend, Spring Boot e Microsserviços

Vamos construir uma POC chamada **OrderStock**, simulando um sistema de pedidos e estoque com arquitetura de microsserviços.

A trilha será guiada e incremental. Você implementará cada etapa, executará os testes e me enviará os resultados. Cada prompt terá o contexto acumulado do projeto para evitar perda de continuidade.

## Projeto que será construído

### Microsserviços

#### `order-service`

- Criar pedidos;
- Consultar pedidos;
- Alterar o status dos pedidos;
- Comunicar-se com o `inventory-service`;
- Validar a disponibilidade dos produtos antes de confirmar um pedido.

#### `inventory-service`

- Cadastrar produtos;
- Consultar produtos;
- Consultar saldo em estoque;
- Reservar estoque;
- Repor estoque;
- Liberar reservas quando necessário.

#### `api-gateway`

- Servir como ponto único de entrada;
- Encaminhar requisições para os microsserviços;
- Centralizar futuramente conceitos de segurança, observabilidade e controle de acesso.

### Configuração e infraestrutura

Durante a evolução da POC, também serão abordados:

- Banco de dados independente por serviço;
- H2 para desenvolvimento inicial;
- PostgreSQL posteriormente;
- Docker;
- Testes unitários e de integração;
- OpenAPI/Swagger;
- Tratamento global de erros;
- Timeout;
- Retry;
- Circuit breaker;
- Comunicação síncrona entre APIs;
- Comunicação assíncrona;
- Mensageria;
- Observabilidade;
- Logs estruturados;
- Métricas;
- Rastreamento distribuído;
- Autenticação e autorização;
- Pipeline de CI/CD;
- Versionamento com Git;
- Métodos ágeis;
- Histórias de usuário;
- Critérios de aceite;
- Pull requests e revisão de código.

## Tecnologias e versões

Utilizaremos uma stack moderna compatível com Java 17:

- Java 17 LTS;
- Maven 3.9 ou superior;
- Spring Boot 3.5.x ou a versão estável mais recente da linha 3.x compatível com Java 17;
- Spring Web;
- Spring Data JPA;
- Spring Validation;
- Spring Boot Actuator;
- H2 2.x para desenvolvimento inicial;
- PostgreSQL posteriormente;
- JUnit 5;
- Mockito;
- Spring Boot Test;
- Spring Cloud Gateway posteriormente;
- Spring Cloud compatível com a versão escolhida do Spring Boot;
- OpenAPI/Swagger;
- Git;
- Docker.

> Nesta trilha, utilizaremos Java 17 e Spring Boot 3.x. A partir do Spring Boot 3, as APIs Java EE foram substituídas pelas APIs Jakarta EE. Por isso, os imports utilizarão principalmente pacotes `jakarta.*` em vez de `javax.*`.

### Política de compatibilidade de versões

Para evitar incompatibilidades:

- O projeto deverá utilizar Java 17;
- O Maven Compiler Plugin deverá compilar com `release` igual a `17`;
- O Spring Boot deverá ser da linha 3.x;
- Dependências do ecossistema Spring Cloud deverão ser escolhidas de acordo com a matriz de compatibilidade do Spring Boot;
- As versões de patch deverão preferencialmente ser gerenciadas pelo Spring Boot Starter Parent;
- Não deverão ser adicionadas versões individuais desnecessárias para dependências já gerenciadas pelo Spring Boot.

## Como utilizar os prompts

Cada prompt deverá conter:

1. Contexto acumulado do projeto;
2. Objetivo da etapa;
3. Conceitos que devem ser aprendidos;
4. Atividades práticas;
5. Critérios de aceite;
6. Exercícios;
7. Perguntas de entrevista;
8. Informações preservadas para a próxima etapa.

Ao concluir cada etapa, você poderá enviar:

- Código;
- Erros encontrados;
- Saída dos testes;
- Resultado da execução;
- Bloco `CONTEXTO-PARA-PRÓXIMA-ETAPA`.

A etapa seguinte só deverá ser iniciada após a validação da etapa atual.

---

# Prompt 01 — Fundamentos, arquitetura e criação do projeto

Copie o prompt abaixo para iniciar a primeira etapa:

~~~text
Você será meu instrutor técnico de Java Backend, Spring Boot e arquitetura de microsserviços.

Quero construir, passo a passo, uma POC profissional chamada OrderStock, usando Java 17 e Maven.

Meu nível atual é intermediário em Java e Spring Boot. Já tenho familiaridade com APIs REST, mas quero consolidar boas práticas de arquitetura, microsserviços, integração entre serviços, versionamento Git, testes, métodos ágeis e comunicação técnica.

## Objetivo geral da POC

A aplicação deverá simular um sistema de pedidos e estoque, dividido inicialmente nos seguintes componentes:

1. order-service:
   - criação de pedidos;
   - consulta de pedidos;
   - alteração de status;
   - comunicação com o inventory-service;
   - validação da disponibilidade dos produtos.

2. inventory-service:
   - cadastro de produtos;
   - consulta de produtos;
   - consulta de saldo em estoque;
   - reserva de estoque;
   - reposição de estoque;
   - liberação de estoque reservado.

3. api-gateway:
   - ponto único de entrada;
   - roteamento das requisições para os microsserviços;
   - preparação para segurança e observabilidade.

A evolução futura poderá incluir:

- PostgreSQL;
- Docker;
- testes unitários e de integração;
- OpenAPI/Swagger;
- tratamento global de erros;
- timeout;
- retry;
- circuit breaker;
- comunicação assíncrona;
- mensageria;
- observabilidade;
- logs estruturados;
- métricas;
- rastreamento distribuído;
- autenticação;
- autorização;
- pipeline de CI/CD;
- revisão de código;
- práticas ágeis.

## Restrições técnicas

- Java 17 LTS;
- Maven 3.9 ou superior;
- Spring Boot 3.x;
- preferencialmente Spring Boot 3.5.x ou a versão estável mais recente da linha 3.x compatível com Java 17;
- código organizado e executável;
- utilizar o recurso `release` com valor `17` na compilação;
- utilizar APIs Jakarta quando aplicável;
- não utilizar imports antigos de `javax.*` em componentes compatíveis com Spring Boot 3;
- explicar qualquer dependência adicionada;
- priorizar simplicidade antes de adicionar complexidade;
- utilizar nomes em inglês no código;
- explicar os conceitos em português;
- não adicionar versões individuais para dependências já gerenciadas pelo Spring Boot;
- não utilizar Lombok nesta primeira etapa.

## Forma de ensino

Não quero receber apenas uma solução pronta.

Quero que você:

1. explique o conceito antes de apresentar o código;
2. explique por que cada decisão foi tomada;
3. apresente uma etapa pequena por vez;
4. mostre os comandos necessários;
5. explique a estrutura de diretórios;
6. explique os erros mais comuns;
7. proponha exercícios práticos;
8. faça perguntas de entrevista relacionadas ao conteúdo;
9. forneça critérios objetivos para eu saber se concluí a etapa;
10. não avance para a próxima etapa até eu confirmar que concluí a atual.

## Primeira etapa

Nesta primeira etapa, não implemente ainda regras complexas de negócio.

Faça o seguinte:

1. explique o que é uma arquitetura de microsserviços;
2. compare monólito e microsserviços;
3. explique as responsabilidades do order-service e do inventory-service;
4. explique por que cada serviço deverá possuir seu próprio banco de dados;
5. apresente a arquitetura inicial da POC em formato textual;
6. proponha uma estrutura de diretórios para um repositório Git;
7. explique se devemos utilizar um único repositório ou múltiplos repositórios;
8. recomende uma abordagem adequada para uma POC didática;
9. explique a função do Maven;
10. explique as principais seções de um pom.xml;
11. explique a finalidade do Spring Boot Starter Parent;
12. explique a diferença entre Spring Boot 2 e Spring Boot 3;
13. explique a mudança de javax.* para jakarta.*;
14. configure o projeto para Java 17;
15. explique a propriedade ou configuração de compilação com release 17;
16. crie o primeiro projeto Spring Boot mínimo para o inventory-service;
17. utilize somente uma API simples de health check;
18. crie um endpoint GET /api/inventory/health;
19. retorne uma resposta JSON simples;
20. inclua um teste automatizado para esse endpoint;
21. utilize as anotações e imports compatíveis com Spring Boot 3;
22. explique como executar a aplicação;
23. explique como executar os testes;
24. explique como testar o endpoint com curl ou Postman;
25. proponha o primeiro commit Git;
26. forneça um README inicial.

## Configuração esperada

Utilize uma configuração equivalente à seguinte:

- groupId: com.orderstock;
- artifactId: inventory-service;
- name: inventory-service;
- Java: 17;
- Spring Boot: versão 3.x compatível com Java 17;
- dependência Spring Web;
- dependência Spring Boot Test;
- Actuator somente se fizer sentido para o health check;
- nenhuma dependência de banco de dados nesta primeira etapa;
- nenhuma dependência de mensageria nesta primeira etapa;
- nenhuma dependência de Spring Cloud nesta primeira etapa.

Caso apresente um pom.xml, explique cada seção e utilize uma versão de Spring Boot compatível com Java 17.

## Regras de implementação

- Apresente primeiro a estrutura esperada dos arquivos.
- Depois apresente cada arquivo completo.
- Não omita imports.
- Não use Lombok nesta primeira etapa.
- Não use banco de dados nesta primeira etapa.
- Não implemente regras complexas de negócio.
- Não crie código desnecessário.
- Use nomes claros e consistentes.
- Utilize `jakarta.*` quando algum import Jakarta for necessário.
- Explique a diferença entre Controller, Service e Repository, mesmo que o Service e o Repository ainda não sejam utilizados.
- Explique o motivo de separar responsabilidades.
- Explique o que significa uma API RESTful.
- Explique o significado do status HTTP utilizado.
- Explique o que o teste realmente valida.
- Explique como confirmar que o projeto está realmente utilizando Java 17.
- Explique os erros mais comuns relacionados à versão do Java.
- Explique os erros mais comuns ao executar Spring Boot 3 com Java antigo.
- Explique a diferença entre `javax` e `jakarta` de forma didática.

## Endpoint esperado

O endpoint deverá:

- utilizar o método HTTP GET;
- possuir o caminho `/api/inventory/health`;
- retornar HTTP 200;
- retornar conteúdo no formato JSON;
- possuir uma resposta simples, por exemplo:

{
  "service": "inventory-service",
  "status": "UP"
}

Você poderá escolher uma estrutura equivalente, desde que explique a decisão.

## Teste automatizado

O teste deverá validar no mínimo:

- que o endpoint existe;
- que o método HTTP GET é aceito;
- que o status HTTP retornado é 200;
- que a resposta possui conteúdo JSON;
- que os campos principais esperados estão presentes.

Explique a diferença entre um teste unitário e um teste de camada web utilizando MockMvc.

## Critérios de aceite

A etapa somente será considerada concluída quando:

- o comando `java -version` indicar Java 17;
- o comando `mvn -version` indicar que o Maven está utilizando Java 17;
- o projeto compilar com Java 17;
- os testes forem executados com sucesso;
- a aplicação iniciar corretamente;
- o endpoint GET /api/inventory/health responder HTTP 200;
- a resposta for JSON;
- o teste automatizado validar o endpoint;
- não existirem imports incompatíveis com Spring Boot 3;
- existir pelo menos um commit Git;
- eu conseguir explicar a finalidade de cada arquivo criado;
- eu conseguir explicar por que escolhemos Spring Boot 3.x para Java 17.

## Ao final da resposta

Apresente:

1. um resumo dos conceitos aprendidos;
2. uma tabela com as principais versões utilizadas;
3. uma lista de comandos executados;
4. um checklist de validação;
5. três perguntas de entrevista;
6. um exercício adicional;
7. uma seção de erros comuns;
8. um bloco chamado CONTEXTO-PARA-PRÓXIMA-ETAPA contendo:
   - o que foi implementado;
   - arquivos criados;
   - versões utilizadas;
   - decisões arquiteturais;
   - comandos que funcionaram;
   - problemas encontrados;
   - eventuais diferenças entre o ambiente utilizado e o exemplo;
   - próximos objetivos.

Não avance para a implementação do order-service ainda. Aguarde minha confirmação.
~~~

---

# O que fazer depois de executar o Prompt 01

Após implementar a etapa, envie:

~~~text
A etapa 01 foi concluída.

## Versões utilizadas

Informe:

- versão do Java;
- versão do Maven;
- versão do Spring Boot;
- sistema operacional.

## Resultado da compilação

Cole aqui o resultado do Maven.

## Resultado dos testes

Cole aqui a saída dos testes.

## Resultado do endpoint

Cole aqui a resposta do endpoint GET /api/inventory/health.

## Validação do Java

Cole aqui a saída dos comandos:

java -version

mvn -version

## Commit realizado

Informe a mensagem do commit.

## Problemas encontrados

Descreva os erros ou dificuldades encontrados.

## CONTEXTO-PARA-PRÓXIMA-ETAPA

Cole aqui o bloco gerado pelo instrutor.
~~~

A próxima etapa será o **Prompt 02 — Modelagem do produto e implementação do `inventory-service` com Spring Boot 3 e Java 17**.