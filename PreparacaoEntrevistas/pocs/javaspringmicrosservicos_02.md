# Prompt 02 — Criação do `order-service` e primeira integração HTTP

Copie o prompt abaixo para dar continuidade ao projeto **OrderStock**.

```text
Você continuará atuando como meu instrutor técnico de Java Backend, Spring Boot e arquitetura de microsserviços.

Estamos construindo, passo a passo, uma POC profissional chamada OrderStock, utilizando Java 17, Maven e Spring Boot 3.x.

Meu nível atual é intermediário em Java e Spring Boot. Já tenho familiaridade com APIs REST, mas quero consolidar boas práticas de arquitetura, microsserviços, integração entre serviços, testes automatizados, versionamento Git, métodos ágeis e comunicação técnica.

# CONTEXTO ACUMULADO DO PROJETO

## Projeto

O projeto se chama OrderStock e simula um sistema de pedidos e estoque utilizando arquitetura de microsserviços.

## Tecnologias e versões

- Java 17;
- Maven 3.9 ou superior;
- Spring Boot 3.5.x, utilizando a versão de patch definida no projeto;
- Spring Web;
- JUnit 5;
- Mockito quando necessário;
- Spring Boot Test;
- APIs Jakarta quando aplicável;
- Git;
- Monorepo para fins didáticos;
- Sem banco de dados nesta fase;
- Sem mensageria nesta fase;
- Sem Spring Cloud nesta fase;
- Sem Lombok nesta fase.

## Serviço implementado

Foi criado o `inventory-service`.

### Responsabilidade atual

O `inventory-service` será responsável futuramente por:

- cadastro de produtos;
- consulta de produtos;
- consulta de saldo em estoque;
- reserva de estoque;
- reposição de estoque;
- liberação de estoque reservado.

### Endpoint existente

```http
GET /api/inventory/health
```

Resposta esperada:

```json
{
  "service": "inventory-service",
  "status": "UP"
}
```

### Implementação existente

O endpoint foi implementado com:

- Controller;
- DTO de resposta;
- teste automatizado utilizando `@WebMvcTest` e `MockMvc`;
- `record` para representar o DTO de resposta;
- sem camada de serviço, pois a funcionalidade ainda é simples;
- sem banco de dados;
- sem Actuator.

### Arquivos existentes no `inventory-service`

```text
inventory-service/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/orderstock/inventory/
    │   │       ├── InventoryServiceApplication.java
    │   │       ├── controller/
    │   │       │   └── HealthController.java
    │   │       └── dto/
    │   │           └── HealthResponse.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/
            └── com/orderstock/inventory/
                └── controller/
                    └── HealthControllerTest.java
```

## Decisões arquiteturais já tomadas

- Será utilizado um monorepo para facilitar o aprendizado;
- Cada microsserviço deverá possuir seu próprio banco de dados quando a persistência for introduzida;
- Nenhum serviço deverá acessar diretamente o banco de dados de outro serviço;
- A comunicação entre serviços deverá ocorrer por APIs ou eventos;
- O `inventory-service` utilizará inicialmente a porta `8081`;
- O `order-service` deverá utilizar inicialmente a porta `8082`;
- A primeira integração entre os serviços será síncrona e realizada por HTTP;
- A comunicação assíncrona e a mensageria serão abordadas posteriormente;
- A complexidade deverá ser adicionada gradualmente;
- O código deverá utilizar nomes em inglês;
- As explicações deverão ser feitas em português;
- Não utilizar Spring Cloud nesta etapa;
- Não utilizar banco de dados nesta etapa;
- Não utilizar Lombok nesta etapa.

## Comandos que funcionaram no `inventory-service`

```bash
mvn spring-boot:run
mvn test
curl -i http://localhost:8081/api/inventory/health
```

## Problemas encontrados

Até o momento, nenhum problema foi registrado.

Se eu informar algum problema durante esta etapa, registre-o no bloco `CONTEXTO-PARA-PRÓXIMA-ETAPA`.

## Próximos objetivos já definidos

- Criar o `order-service`;
- Criar um endpoint de health check equivalente;
- Introduzir uma comunicação HTTP simples entre `order-service` e `inventory-service`;
- Preparar o terreno para a criação do primeiro pedido em etapas futuras.

# OBJETIVO DESTA ETAPA

Nesta etapa, quero criar o `order-service` e fazer uma primeira integração HTTP síncrona com o `inventory-service`.

A implementação deverá ser didática, incremental e sem introduzir regras complexas de negócio.

O objetivo é que o `order-service` consiga consultar o health check do `inventory-service` por meio de uma chamada HTTP.

# REGRAS IMPORTANTES DE ENSINO

Não apresente apenas uma solução pronta.

Quero que você:

1. explique cada conceito antes de apresentar o código;
2. explique por que cada decisão foi tomada;
3. divida a implementação em pequenos passos;
4. apresente primeiro a estrutura esperada dos arquivos;
5. depois apresente cada arquivo completo;
6. não omita imports;
7. explique os comandos necessários;
8. explique os erros mais comuns;
9. explique o papel de cada camada;
10. explique como validar o comportamento;
11. proponha exercícios práticos;
12. faça perguntas de entrevista;
13. não avance para a implementação de pedidos persistidos;
14. não adicione banco de dados;
15. não adicione Spring Cloud;
16. não adicione mensageria;
17. não adicione segurança nesta etapa;
18. aguarde minha confirmação antes de avançar para a próxima etapa.

# PARTE 1 — EXPLICAR A EVOLUÇÃO DA ARQUITETURA

Antes de apresentar qualquer código, explique:

1. qual é a responsabilidade do `order-service`;
2. qual é a responsabilidade do `inventory-service`;
3. por que o `order-service` não deve acessar diretamente o banco do `inventory-service`;
4. o que é comunicação síncrona entre microsserviços;
5. quais são as vantagens da comunicação HTTP síncrona;
6. quais são os riscos da comunicação síncrona;
7. o que acontece quando o `inventory-service` está indisponível;
8. o que significa acoplamento entre serviços;
9. a diferença entre acoplamento temporal e acoplamento estrutural;
10. por que a integração será simples nesta etapa;
11. por que ainda não devemos introduzir Feign, Service Discovery ou Circuit Breaker;
12. como essa decisão poderá mudar em uma aplicação real.

Explique também que uma integração HTTP simples é adequada para compreender:

- URL;
- método HTTP;
- status HTTP;
- headers;
- corpo da resposta;
- serialização;
- desserialização;
- timeout;
- tratamento de erros;
- testes de integração.

# PARTE 2 — CRIAR O `order-service`

Crie um novo microsserviço chamado `order-service`.

Utilize a seguinte configuração:

- groupId: `com.orderstock`;
- artifactId: `order-service`;
- name: `order-service`;
- Java 17;
- Maven;
- Spring Boot 3.5.x ou a mesma versão de patch utilizada pelo `inventory-service`;
- Spring Web;
- Spring Boot Test;
- nenhuma dependência de banco de dados;
- nenhuma dependência de mensageria;
- nenhuma dependência de Spring Cloud;
- nenhuma dependência de Actuator, salvo se justificar claramente seu uso;
- sem Lombok.

Explique:

1. por que os dois serviços devem utilizar versões compatíveis;
2. por que a versão do Spring Boot deve ser mantida consistente na POC;
3. como verificar se o projeto está compilando com Java 17;
4. como configurar a porta `8082`;
5. como evitar conflito com a porta `8081` utilizada pelo `inventory-service`.

O `order-service` deverá possuir uma estrutura semelhante a:

```text
order-service/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/orderstock/order/
    │   │       ├── OrderServiceApplication.java
    │   │       ├── controller/
    │   │       │   └── HealthController.java
    │   │       └── dto/
    │   │           └── HealthResponse.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/
            └── com/orderstock/order/
                └── controller/
                    └── HealthControllerTest.java
```

# PARTE 3 — HEALTH CHECK DO `order-service`

Crie o endpoint:

```http
GET /api/orders/health
```

A resposta deverá possuir formato JSON semelhante a:

```json
{
  "service": "order-service",
  "status": "UP"
}
```

Explique:

1. por que o caminho contém `/api/orders`;
2. por que o endpoint utiliza GET;
3. por que a resposta deve ser HTTP 200;
4. por que um health check não deve executar regras complexas;
5. a diferença entre um health check da própria aplicação e um health check das dependências;
6. por que o endpoint criado nesta etapa ainda não representa uma verificação completa da saúde do sistema.

Crie um teste automatizado utilizando `@WebMvcTest` e `MockMvc`.

O teste deverá validar:

- que o endpoint existe;
- que o método GET é aceito;
- que o status retornado é HTTP 200;
- que o conteúdo retornado é JSON;
- que o campo `service` possui o valor `order-service`;
- que o campo `status` possui o valor `UP`.

Explique exatamente o que esse teste valida e também o que ele não valida.

# PARTE 4 — CONFIGURAR A COMUNICAÇÃO HTTP

Depois de criar e testar o health check local do `order-service`, implemente uma chamada HTTP para o endpoint do `inventory-service`.

A chamada deverá ser realizada pelo `order-service` para:

```http
GET http://localhost:8081/api/inventory/health
```

Utilize uma solução compatível com Spring Boot 3 e Java 17.

Para esta etapa, escolha uma das seguintes alternativas:

- `RestClient`, se a versão utilizada do Spring Boot oferecer suporte adequado;
- `RestTemplate`, caso seja necessário priorizar simplicidade e compatibilidade didática.

Antes de escolher, explique:

1. por que a alternativa escolhida é adequada;
2. quais são as diferenças entre `RestClient`, `RestTemplate` e `WebClient`;
3. por que `WebClient` não será utilizado nesta etapa, caso essa seja a decisão;
4. quais são as implicações de uma chamada bloqueante;
5. em que cenário uma aplicação deveria utilizar comunicação não bloqueante.

Não utilize Feign nesta etapa.

# PARTE 5 — CRIAR O CLIENTE DO `inventory-service`

Crie uma classe responsável pela comunicação com o `inventory-service`.

A classe deverá:

1. encapsular a chamada HTTP;
2. evitar que o Controller construa URLs diretamente;
3. possuir uma responsabilidade única;
4. receber a URL base por configuração;
5. permitir alteração da URL sem recompilar o código;
6. retornar um DTO representando a resposta do `inventory-service`.

Utilize uma configuração semelhante a:

```properties
server.port=8082
inventory-service.base-url=http://localhost:8081
```

Não fixe a URL diretamente no Controller.

Explique:

1. por que configurações externas são importantes;
2. a diferença entre configuração e código;
3. por que URLs não devem ficar espalhadas pelas classes;
4. como essa configuração será alterada futuramente em ambientes diferentes;
5. como evitar problemas quando o serviço estiver em Docker;
6. por que `localhost` possui significado diferente dentro e fora de containers.

# PARTE 6 — CRIAR UM ENDPOINT DE VERIFICAÇÃO DA DEPENDÊNCIA

Crie no `order-service` um endpoint para verificar a comunicação com o `inventory-service`:

```http
GET /api/orders/dependencies/inventory/health
```

Quando o `inventory-service` estiver disponível, o `order-service` deverá retornar uma resposta JSON semelhante a:

```json
{
  "dependency": "inventory-service",
  "status": "UP"
}
```

O status HTTP esperado, quando a dependência estiver funcionando, será:

```http
200 OK
```

Explique:

1. o fluxo completo da requisição;
2. qual serviço recebe a chamada inicial;
3. qual serviço realiza a chamada subsequente;
4. como a resposta é transformada;
5. por que o `order-service` não deve simplesmente repassar qualquer resposta sem analisá-la;
6. a diferença entre disponibilidade do `order-service` e disponibilidade do `inventory-service`.

# PARTE 7 — TRATAMENTO BÁSICO DE ERROS

Implemente um tratamento básico para os seguintes cenários:

## Cenário 1 — `inventory-service` indisponível

Quando o `inventory-service` não estiver em execução, o `order-service` deverá retornar uma resposta controlada, sem expor stack trace ao cliente.

Utilize um status HTTP adequado e explique a decisão.

Uma resposta possível seria:

```json
{
  "dependency": "inventory-service",
  "status": "DOWN",
  "message": "Inventory service is unavailable"
}
```

## Cenário 2 — Resposta inesperada

Explique como o `order-service` deve reagir caso o `inventory-service` retorne:

- HTTP 4xx;
- HTTP 5xx;
- resposta vazia;
- JSON inválido;
- timeout.

Nesta etapa, implemente somente o tratamento básico necessário para o cenário de indisponibilidade e explique como os demais cenários serão aprimorados posteriormente.

Não implemente ainda:

- retry;
- circuit breaker;
- fallback complexo;
- fila;
- mensageria;
- cache;
- autenticação;
- observabilidade avançada.

Explique por que esses recursos serão abordados em etapas posteriores.

# PARTE 8 — TIMEOUT

Configure um timeout básico para evitar que o `order-service` fique aguardando indefinidamente uma resposta do `inventory-service`.

Explique:

1. o que é timeout;
2. por que uma chamada sem timeout é perigosa;
3. a diferença entre connection timeout e read timeout;
4. o que deve acontecer quando o timeout for atingido;
5. como a configuração varia de acordo com o cliente HTTP escolhido;
6. quais valores foram escolhidos para a POC;
7. por que os valores definidos para uma POC não devem ser copiados automaticamente para produção.

Se a configuração de timeout tornar o exemplo excessivamente complexo, implemente o mínimo necessário e explique as limitações.

# PARTE 9 — TESTES

Crie os testes necessários para validar o comportamento.

## Testes do Controller

Mantenha o teste de camada web para:

```http
GET /api/orders/health
```

## Testes do cliente HTTP

Crie testes unitários para validar:

1. resposta de sucesso do `inventory-service`;
2. indisponibilidade do `inventory-service`;
3. resposta HTTP de erro;
4. comportamento controlado diante da falha;
5. transformação da resposta externa em DTO interno.

Não faça chamadas reais para `localhost` nos testes unitários.

Utilize mocks quando apropriado.

Explique:

1. a diferença entre teste unitário, teste de camada web e teste de integração;
2. por que testes unitários não devem depender de outro serviço em execução;
3. como um servidor HTTP simulado poderia ser utilizado posteriormente;
4. quais testes seriam necessários para validar a integração real entre os dois microsserviços.

Se criar testes de integração, explique claramente por que eles são diferentes dos testes unitários.

# PARTE 10 — DOCUMENTAÇÃO

Crie ou atualize o README do `order-service`.

O README deverá conter:

1. objetivo do serviço;
2. tecnologias utilizadas;
3. versão do Java;
4. versão do Spring Boot;
5. porta utilizada;
6. pré-requisito de que o `inventory-service` esteja em execução;
7. comandos para executar;
8. comandos para executar os testes;
9. exemplos de chamadas com `curl`;
10. exemplos de respostas;
11. comportamento quando o `inventory-service` estiver indisponível;
12. limitações conhecidas;
13. próximos passos.

Atualize também o README raiz do monorepo, caso ele exista.

# PARTE 11 — GIT E MÉTODOS ÁGEIS

Proponha uma estratégia de commits para esta etapa.

Sugira commits pequenos e objetivos, por exemplo:

```text
feat(order-service): create initial Spring Boot service
feat(order-service): add health check endpoint
feat(order-service): add inventory HTTP client
feat(order-service): handle inventory service unavailable
test(order-service): add web and client tests
docs(order-service): add setup and usage instructions
```

Explique:

1. por que commits pequenos facilitam a revisão;
2. o significado dos prefixos `feat`, `test` e `docs`;
3. como essa etapa poderia ser descrita como uma história de usuário;
4. quais seriam as tarefas técnicas;
5. quais seriam os critérios de aceite;
6. como apresentar essa implementação em uma daily meeting;
7. como explicar uma dificuldade técnica de forma clara e objetiva.

Proponha a seguinte história de usuário ou uma equivalente:

```text
Como sistema de pedidos,
quero verificar a disponibilidade do serviço de estoque,
para identificar se posso continuar o processamento de uma operação.
```

Crie critérios de aceite objetivos para essa história.

# CRITÉRIOS DE ACEITE DA ETAPA

A etapa somente será considerada concluída quando:

- o `inventory-service` continuar funcionando;
- o `order-service` compilar com Java 17;
- o `order-service` utilizar uma porta diferente do `inventory-service`;
- os testes do `order-service` forem executados com sucesso;
- o endpoint local de health check responder HTTP 200;
- o `order-service` conseguir consultar o health check do `inventory-service`;
- o cliente HTTP estiver separado do Controller;
- a URL do `inventory-service` estiver configurada externamente;
- o cenário de indisponibilidade for tratado de forma controlada;
- existir timeout ou uma explicação clara sobre sua configuração;
- não forem realizadas chamadas HTTP reais nos testes unitários;
- existir documentação mínima no README;
- existir pelo menos um commit relacionado ao `order-service`;
- eu conseguir explicar o fluxo completo entre os serviços;
- eu conseguir explicar as limitações da comunicação síncrona;
- eu conseguir diferenciar teste unitário, teste web e teste de integração.

# COMANDOS QUE DEVERÃO SER EXPLICADOS

Explique como executar os serviços em terminais separados.

Exemplo:

```bash
# Terminal 1
cd inventory-service
mvn spring-boot:run

# Terminal 2
cd order-service
mvn spring-boot:run
```

Explique também como executar:

```bash
mvn clean test
```

Teste o health check do `inventory-service`:

```bash
curl -i http://localhost:8081/api/inventory/health
```

Teste o health check do `order-service`:

```bash
curl -i http://localhost:8082/api/orders/health
```

Teste a verificação da dependência:

```bash
curl -i http://localhost:8082/api/orders/dependencies/inventory/health
```

Explique o resultado esperado para:

1. os dois serviços em execução;
2. somente o `order-service` em execução;
3. somente o `inventory-service` em execução;
4. nenhum serviço em execução;
5. porta ocupada;
6. URL configurada incorretamente.

# FORMATO DA RESPOSTA

Organize a resposta nesta ordem:

1. objetivo da etapa;
2. contexto recuperado;
3. conceitos fundamentais;
4. arquitetura atualizada;
5. estrutura esperada dos arquivos;
6. criação do `order-service`;
7. implementação do health check;
8. implementação do cliente HTTP;
9. implementação do endpoint de dependência;
10. tratamento básico de erros;
11. configuração de timeout;
12. testes;
13. documentação;
14. Git e métodos ágeis;
15. comandos de execução;
16. checklist de validação;
17. perguntas de entrevista;
18. exercício adicional;
19. erros comuns;
20. limitações conhecidas;
21. bloco `CONTEXTO-PARA-PRÓXIMA-ETAPA`.

# PERGUNTAS DE ENTREVISTA

Ao final, faça pelo menos cinco perguntas de entrevista sobre:

1. arquitetura de microsserviços;
2. comunicação síncrona;
3. isolamento de dados;
4. timeout;
5. tratamento de indisponibilidade;
6. testes de clientes HTTP;
7. separação de responsabilidades;
8. configuração externa;
9. acoplamento entre serviços;
10. diferença entre health check local e health check de dependência.

Forneça as perguntas primeiro sem as respostas. Depois, apresente respostas esperadas de forma resumida para que eu possa estudar.

# EXERCÍCIO ADICIONAL

Proponha um exercício prático sem fornecer imediatamente a solução completa.

O exercício deverá pedir que eu:

1. crie um segundo endpoint no `inventory-service`;
2. faça o `order-service` consumi-lo;
3. modele um DTO de resposta;
4. trate uma resposta HTTP 404;
5. crie testes unitários para o novo comportamento.

Forneça apenas as instruções, os critérios de aceite e as dicas iniciais. Aguarde minha tentativa antes de mostrar a solução.

# BLOCO OBRIGATÓRIO PARA CONTINUIDADE

Ao final, crie exatamente uma seção chamada:

CONTEXTO-PARA-PRÓXIMA-ETAPA

Essa seção deverá conter:

- o que foi implementado;
- arquivos criados ou alterados;
- versões utilizadas;
- portas utilizadas;
- endpoints disponíveis;
- fluxo de comunicação entre os serviços;
- cliente HTTP escolhido e justificativa;
- configuração externa criada;
- tratamento de erros implementado;
- timeout implementado;
- testes criados;
- comandos que funcionaram;
- problemas encontrados;
- diferenças entre o ambiente utilizado e o exemplo;
- commits realizados;
- conceitos que eu devo revisar;
- exercício adicional proposto;
- próximos objetivos.

Não avance para a criação de produtos, pedidos ou banco de dados. Aguarde minha confirmação da conclusão desta etapa.
```

---

## Modelo para enviar o resultado da etapa

Após executar o Prompt 02, envie:

```text
A etapa 02 foi concluída.

## Versões utilizadas

- Java:
- Maven:
- Spring Boot:
- Sistema operacional:

## Portas utilizadas

- inventory-service:
- order-service:

## Resultado dos testes do inventory-service

Cole aqui a saída dos testes.

## Resultado dos testes do order-service

Cole aqui a saída dos testes.

## Resultado do health check do inventory-service

Cole aqui a saída do comando:

curl -i http://localhost:8081/api/inventory/health

## Resultado do health check do order-service

Cole aqui a saída do comando:

curl -i http://localhost:8082/api/orders/health

## Resultado da integração entre os serviços

Cole aqui a saída do comando:

curl -i http://localhost:8082/api/orders/dependencies/inventory/health

## Teste com o inventory-service desligado

Descreva o resultado obtido.

## Cliente HTTP escolhido

Informe se foi utilizado:

- RestClient;
- RestTemplate;
- outra alternativa.

Explique brevemente a decisão.

## Timeout

Informe como foi configurado.

## Commits realizados

Liste os commits relacionados à etapa.

## Problemas encontrados

Descreva os erros ou dificuldades encontrados.

## Exercício adicional

Descreva sua solução ou cole os principais trechos implementados.

## CONTEXTO-PARA-PRÓXIMA-ETAPA

Cole aqui o bloco gerado pelo instrutor.
```

A próxima etapa será a modelagem do produto e a criação dos primeiros endpoints reais do `inventory-service`, ainda sem banco de dados.