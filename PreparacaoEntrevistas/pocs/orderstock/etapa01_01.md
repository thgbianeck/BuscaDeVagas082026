# OrderStock — Etapa 1: Fundamentos, Arquitetura e inventory-service (Health Check)

## 1. O que é uma arquitetura de microsserviços

Microsserviços são um estilo arquitetural em que uma aplicação é dividida em **serviços pequenos, independentes e implantáveis separadamente**, cada um responsável por uma capacidade de negócio específica (ex.: pedidos, estoque, pagamentos). Cada serviço:

- possui seu próprio código-fonte e ciclo de deploy;
- se comunica com os demais via rede (HTTP/REST, mensageria, gRPC etc.);
- pode ser desenvolvido, escalado e reiniciado de forma independente;
- geralmente possui seu próprio armazenamento de dados.

Isso contrasta com uma abordagem em que tudo roda dentro de um único processo/deploy.

## 2. Monólito vs Microsserviços

| Aspecto | Monólito | Microsserviços |
|---|---|---|
| Deploy | Único artefato, todo o sistema junto | Cada serviço tem deploy independente |
| Escalabilidade | Escala a aplicação inteira | Escala apenas o serviço necessário |
| Complexidade inicial | Baixa | Maior (rede, consistência, observabilidade) |
| Times | Um time cuida de tudo | Times podem ser donos de serviços específicos |
| Falhas | Uma falha pode afetar tudo | Falha pode ficar isolada em um serviço |
| Comunicação | Chamadas de método (in-process) | Chamadas de rede (HTTP, mensageria) |
| Banco de dados | Geralmente compartilhado | Idealmente um banco por serviço |

**Trade-off central:** microsserviços trocam simplicidade operacional por flexibilidade organizacional e de escala. Por isso, começamos pequeno (health check) antes de introduzir comunicação real entre serviços.

## 3. Responsabilidades de order-service e inventory-service

- **order-service**
  - Criar pedidos;
  - Consultar pedidos existentes;
  - Alterar status de um pedido (ex.: CRIADO → CONFIRMADO → CANCELADO);
  - Verificar, junto ao inventory-service, se há estoque disponível antes de confirmar um pedido;
  - Não conhece detalhes internos de como o estoque é armazenado — apenas consome uma API.

- **inventory-service**
  - Cadastrar produtos;
  - Consultar produtos e saldo em estoque;
  - Reservar estoque (quando um pedido é criado);
  - Repor estoque (entrada de mercadoria);
  - Liberar estoque reservado (quando um pedido é cancelado).
  - Não sabe nada sobre pedidos — apenas expõe operações de estoque.

Essa separação segue o princípio de **responsabilidade única no nível de serviço**: cada serviço tem um motivo de mudança bem definido.

## 4. Por que cada serviço deve ter seu próprio banco de dados

- **Desacoplamento real**: se dois serviços compartilham o mesmo banco, eles continuam fortemente acoplados mesmo estando em processos separados — qualquer mudança de schema pode quebrar o outro serviço.
- **Independência de deploy**: um serviço só pode evoluir seu modelo de dados livremente se ninguém mais depender diretamente dele.
- **Falha isolada**: problemas de banco em um serviço não devem impedir o funcionamento do outro.
- **Escalabilidade independente**: você pode escolher tecnologias de persistência diferentes por serviço (ex.: PostgreSQL para pedidos, outro banco para estoque) conforme a necessidade.

Nesta etapa ainda **não usaremos banco de dados** — isso será introduzido em etapas futuras, mas o princípio já precisa estar claro na cabeça.

## 5. Arquitetura inicial da POC

~~~mermaid
graph TD
    Client[Cliente / Postman / Frontend] --> Gateway[api-gateway]
    Gateway --> OrderService[order-service]
    Gateway --> InventoryService[inventory-service]
    OrderService -->|HTTP| InventoryService
    OrderService --> OrderDB[("order-service DB (futuro)")]
    InventoryService --> InventoryDB[("inventory-service DB (futuro)")]
~~~

Nesta Etapa 1, construiremos **apenas** o `inventory-service`, com um único endpoint de health check, sem o gateway e sem o order-service ainda.

## 6. Estrutura de diretórios proposta para o repositório Git

~~~mermaid
graph TD
    Root["orderstock/"] --> Readme["README.md"]
    Root --> Gitignore[".gitignore"]
    Root --> Inventory["inventory-service/"]
    Root --> Order["order-service/ (etapa futura)"]
    Root --> ApiGw["api-gateway/ (etapa futura)"]

    Inventory --> InvPom["pom.xml"]
    Inventory --> InvReadme["README.md"]
    Inventory --> InvSrc["src/"]

    InvSrc --> InvMain["main/"]
    InvSrc --> InvTest["test/"]

    InvMain --> InvJava["java/com/orderstock/inventoryservice/"]
    InvMain --> InvRes["resources/application.properties"]

    InvJava --> InvApp["InventoryServiceApplication.java"]
    InvJava --> InvController["controller/"]

    InvController --> HealthController["HealthController.java"]
    InvController --> HealthResponse["HealthResponse.java"]

    InvTest --> InvTestJava["java/com/orderstock/inventoryservice/controller/"]
    InvTestJava --> HealthControllerTest["HealthControllerTest.java"]
~~~

## 7. Monorepo ou múltiplos repositórios?

- **Monorepo**: um único repositório Git contendo todos os microsserviços em pastas separadas.
- **Multirepo**: cada microsserviço em seu próprio repositório Git.

**Recomendação para esta POC didática: monorepo.**

Motivos:
- Facilita acompanhar a evolução de todos os serviços em um único histórico de commits, ideal para fins de aprendizado;
- Reduz a fricção de gerenciar múltiplos repositórios enquanto você ainda está validando a arquitetura;
- Em produção, muitas empresas migram para multirepo quando os times crescem e precisam de pipelines de CI/CD e permissões independentes — mas isso não é necessário agora.

## 8. Função do Maven

O Maven é uma **ferramenta de build e gerenciamento de dependências** para projetos Java. Ele:

- Define a estrutura padrão de diretórios (`src/main/java`, `src/test/java` etc.);
- Baixa e gerencia as bibliotecas (dependências) do projeto a partir de repositórios remotos (ex.: Maven Central);
- Compila, testa, empacota (JAR/WAR) e pode até publicar o artefato;
- Usa um arquivo de configuração declarativo chamado `pom.xml` (Project Object Model).

## 9. Principais seções de um `pom.xml`

- `<modelVersion>`: versão do modelo do POM (sempre `4.0.0` atualmente);
- `<parent>`: define um POM "pai" do qual o projeto herda configurações — no nosso caso, o `spring-boot-starter-parent`;
- `<groupId>`, `<artifactId>`, `<version>`: identificam unicamente o projeto (coordenadas Maven);
- `<name>`: nome legível do projeto;
- `<properties>`: valores de configuração reutilizáveis, como a versão do Java;
- `<dependencies>`: lista de bibliotecas que o projeto usa;
- `<build>`: configurações de como o projeto é compilado/empacotado (ex.: plugins).

## 10. Finalidade do Spring Boot Starter Parent

O `spring-boot-starter-parent` é um POM pai fornecido pelo Spring Boot que:

- **Gerencia versões** de todas as dependências e plugins compatíveis entre si (por isso não declaramos versão individual de cada dependência do Spring — é isso que a restrição do curso pede);
- Define configurações padrão de compilação (encoding UTF-8, plugins de build);
- Simplifica o `pom.xml`, evitando conflitos de versão entre bibliotecas.

## 11. Diferença entre Spring Boot 2 e Spring Boot 3

- **Spring Boot 3.x** exige **Java 17 como versão mínima** (Spring Boot 2.x funcionava a partir do Java 8);
- Spring Boot 3.x migrou de **Java EE (`javax.*`)** para **Jakarta EE (`jakarta.*`)** como especificação base, acompanhando a mudança do próprio Spring Framework 6;
- Spring Boot 3.x tem suporte nativo mais maduro para **observabilidade** (Micrometer, tracing) e para **GraalVM native images**;
- Por isso, este projeto usa Spring Boot 3.x com Java 17 — é a combinação mínima suportada e recomendada atualmente.

## 12. A mudança de `javax.*` para `jakarta.*`

Historicamente, as especificações Java EE (Servlets, Persistence, Validation etc.) usavam o namespace `javax.*`. Quando a governança dessas especificações migrou da Oracle para a Eclipse Foundation (projeto **Jakarta EE**), foi necessário renomear os pacotes para `jakarta.*` por razões de marca registrada.

- Exemplo: `javax.persistence.Entity` → `jakarta.persistence.Entity`;
- Exemplo: `javax.servlet.http.HttpServletRequest` → `jakarta.servlet.http.HttpServletRequest`.

**Regra prática para este curso:** em Spring Boot 3.x, **sempre** que precisar de uma API Jakarta (validação, persistência, servlets), o import correto é `jakarta.*`. Usar `javax.*` aqui geralmente resulta em erro de compilação, pois as bibliotecas Spring Boot 3 não trazem mais as classes `javax.*` antigas no classpath.

## 13. Configuração para Java 17

Vamos garantir três coisas:

1. O JDK instalado na máquina é a versão 17;
2. O Maven está configurado para usar esse JDK 17;
3. O `pom.xml` declara explicitamente que o bytecode alvo é Java 17 (via `release`).

## 14. A propriedade `maven.compiler.release`

No `pom.xml`, usamos:

~~~xml
<properties>
    <java.version>17</java.version>
</properties>
~~~

O `spring-boot-starter-parent` já lê a propriedade `java.version` e configura automaticamente o **maven-compiler-plugin** para usar `--release 17`. A flag `release` (em vez de `source`/`target` separados) garante que:

- o compilador gere bytecode compatível com Java 17;
- o compilador **também** valide que você não está usando APIs de uma versão de Java mais nova do que 17 na sua própria plataforma de execução — algo que `source`/`target` isoladamente não garantem.

## 15. Estrutura de arquivos que vamos criar agora

~~~mermaid
graph TD
    Inv["inventory-service/"] --> Pom["pom.xml"]
    Inv --> Readme["README.md"]
    Inv --> Src["src/"]
    Src --> Main["main/"]
    Src --> Test["test/"]
    Main --> Java["java/com/orderstock/inventoryservice/"]
    Main --> Resources["resources/application.properties"]
    Java --> App["InventoryServiceApplication.java"]
    Java --> Controller["controller/"]
    Controller --> HC["HealthController.java"]
    Controller --> HR["HealthResponse.java"]
    Test --> TestJava["java/com/orderstock/inventoryservice/controller/"]
    TestJava --> HCT["HealthControllerTest.java"]
~~~

## 16. Arquivos completos

### 16.1 `pom.xml`

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
    <artifactId>inventory-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>inventory-service</name>
    <description>Serviço de estoque da POC OrderStock</description>

    <properties>
        <java.version>17</java.version>
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

**Observação sobre a versão:** usei `3.5.4` como referência de uma versão estável da linha 3.5.x compatível com Java 17. Antes de gerar o projeto de fato, confirme a última patch disponível em [start.spring.io](https://start.spring.io) — o Maven não vai baixar uma versão incorreta, mas é boa prática sempre partir da mais recente estável da linha.

**Por que nenhuma versão individual de dependência foi declarada?** Porque o `spring-boot-starter-parent` já gerencia essas versões via seu próprio BOM (Bill of Materials) — declarar versão manualmente aqui poderia gerar conflitos e é desnecessário.

**Por que não incluí o Actuator?** O Actuator adiciona endpoints prontos como `/actuator/health`, mas o exercício pede um endpoint **customizado** (`/api/inventory/health`) com um formato de resposta específico. Adicionar Actuator agora seria complexidade desnecessária para o que precisamos — reforça o princípio "priorizar simplicidade antes de adicionar complexidade".

### 16.2 `InventoryServiceApplication.java`

~~~java
package com.orderstock.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
}
~~~

**Explicação:** `@SpringBootApplication` é uma anotação composta que combina `@Configuration`, `@EnableAutoConfiguration` e `@ComponentScan`. Ela diz ao Spring Boot para escanear este pacote (e subpacotes) em busca de componentes gerenciados (controllers, services etc.) e configurar automaticamente a aplicação com base nas dependências presentes no classpath (neste caso, um servidor web embutido, graças ao `spring-boot-starter-web`).

### 16.3 `HealthResponse.java`

~~~java
package com.orderstock.inventoryservice.controller;

public record HealthResponse(String service, String status) {
}
~~~

**Por que um `record`?** Records (Java 16+) são ideais para objetos imutáveis de transporte de dados (DTOs), pois geram automaticamente construtor, getters, `equals`, `hashCode` e `toString`, sem precisar de Lombok — o que respeita a restrição de não usar Lombok nesta etapa.

### 16.4 `HealthController.java`

~~~java
package com.orderstock.inventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/api/inventory/health")
    public HealthResponse health() {
        return new HealthResponse("inventory-service", "UP");
    }
}
~~~

**Explicação das anotações:**
- `@RestController`: combina `@Controller` + `@ResponseBody`, indicando que os métodos retornam diretamente dados (serializados para JSON), não nomes de views HTML;
- `@GetMapping("/api/inventory/health")`: mapeia requisições HTTP GET nesse caminho para este método.

Quando o método retorna um objeto Java (o `record HealthResponse`), o Spring usa a biblioteca Jackson (já incluída no `spring-boot-starter-web`) para serializá-lo automaticamente em JSON.

### 16.5 `application.properties`

~~~properties
spring.application.name=inventory-service
server.port=8081
~~~

**Explicação:** `server.port=8081` evita conflito de porta com outros serviços que criaremos depois (o padrão é 8080). `spring.application.name` identifica o serviço em logs e, futuramente, em ferramentas de observabilidade.

### 16.6 `HealthControllerTest.java`

~~~java
package com.orderstock.inventoryservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthController.class)
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHealthStatusUp() throws Exception {
        mockMvc.perform(get("/api/inventory/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.service").value("inventory-service"))
                .andExpect(jsonPath("$.status").value("UP"));
    }
}
~~~

## 17. Controller, Service e Repository — por que separar responsabilidades

- **Controller**: camada responsável por receber requisições HTTP, extrair dados (path, query, body) e retornar respostas. Não deve conter regra de negócio.
- **Service**: camada onde vive a **regra de negócio** (validações, cálculos, orquestração entre repositórios). Ainda não a utilizamos, porque não há regra de negócio nesta etapa.
- **Repository**: camada responsável por acessar dados persistidos (banco de dados). Ainda não a utilizamos, porque não há persistência nesta etapa.

**Por que separar?** Cada camada tem um motivo de mudança diferente (princípio de responsabilidade única): mudanças na forma como os dados são expostos via HTTP não deveriam obrigar você a alterar a lógica de negócio, e vice-versa. Isso facilita testes isolados, manutenção e reuso.

## 18. O que significa uma API RESTful

REST (Representational State Transfer) é um estilo arquitetural para APIs baseado em:

- Recursos identificados por **URLs** (ex.: `/api/inventory/health`);
- Uso correto dos **métodos HTTP** (GET para leitura, POST para criação, PUT/PATCH para atualização, DELETE para remoção);
- Respostas com **códigos de status HTTP** significativos;
- Comunicação **stateless** (sem estado de sessão guardado no servidor entre requisições).

## 19. Significado do status HTTP utilizado

Usamos **HTTP 200 OK**, que significa: "a requisição foi processada com sucesso e o corpo da resposta contém o resultado esperado". É o status padrão para operações GET bem-sucedidas.

## 20. Fluxo da requisição ao endpoint

~~~mermaid
sequenceDiagram
    participant C as Cliente (curl/Postman/Teste)
    participant S as Servidor Web embutido (Tomcat)
    participant HC as HealthController

    C->>S: GET /api/inventory/health
    S->>HC: invoca health()
    HC-->>S: HealthResponse(service="inventory-service", status="UP")
    S-->>C: HTTP 200 + JSON
~~~

Esse diagrama mostra exatamente o que o teste com `MockMvc` está simulando: uma requisição HTTP chegando, sendo roteada até o controller, e a resposta sendo serializada de volta como JSON.

## 21. O que o teste realmente valida

O teste `HealthControllerTest`:

- Confirma que o endpoint `/api/inventory/health` existe e responde a requisições GET;
- Confirma que o status HTTP retornado é 200;
- Confirma que o tipo de conteúdo da resposta é JSON;
- Confirma que os campos `service` e `status` estão presentes com os valores esperados.

**Diferença entre teste unitário e teste de camada web com MockMvc:**

- **Teste unitário puro**: testaria a classe `HealthController` isoladamente, chamando o método `health()` diretamente em Java, sem envolver o Spring, servidor HTTP ou serialização JSON. Você usaria apenas JUnit (e talvez Mockito, se houvesse dependências a mockar).
- **Teste de camada web (`@WebMvcTest` + `MockMvc`)**: carrega apenas o contexto Spring MVC necessário (sem subir o servidor HTTP real nem outras camadas como banco de dados), simula uma requisição HTTP real contra o controller e valida a resposta serializada — incluindo roteamento, status HTTP e formato JSON. É mais realista que um teste unitário puro, mas mais rápido/leve que um `@SpringBootTest` completo.

## 22. Como executar a aplicação

~~~bash
cd inventory-service
mvn spring-boot:run
~~~

A aplicação iniciará na porta `8081` (conforme `application.properties`).

## 23. Como executar os testes

~~~bash
cd inventory-service
mvn test
~~~

O Maven compilará o projeto e executará os testes localizados em `src/test/java`.

## 24. Como testar o endpoint

**Com curl:**

~~~bash
curl -i http://localhost:8081/api/inventory/health
~~~

Resposta esperada:

~~~json
HTTP/1.1 200
Content-Type: application/json

{"service":"inventory-service","status":"UP"}
~~~

**Com Postman:** crie uma requisição `GET` para `http://localhost:8081/api/inventory/health` e verifique o status 200 e o corpo JSON na aba "Body".

## 25. Primeiro commit Git

~~~bash
mkdir orderstock && cd orderstock
git init
mkdir inventory-service
# copie os arquivos criados para dentro de inventory-service/
git add .
git commit -m "feat(inventory-service): health check endpoint with Spring Boot 3 and Java 17"
~~~

**Sugestão de `.gitignore`** (raiz do repositório):

~~~
target/
*.class
.idea/
*.iml
.DS_Store
~~~

## 26. README inicial (`inventory-service/README.md`)

~~~markdown
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
~~~

## 27. Erros mais comuns

- **Usar `javax.*` em vez de `jakarta.*`**: em Spring Boot 3, classes `javax.persistence.*`, `javax.servlet.*` etc. não existem mais no classpath — o compilador emitirá "package does not exist".
- **JDK instalado é diferente do configurado no Maven**: rodar `mvn -version` mostra qual JDK o Maven está usando de fato; se divergir de `java -version`, verifique a variável de ambiente `JAVA_HOME`.
- **Tentar rodar Spring Boot 3 com Java 8 ou 11**: resulta em erro de "Unsupported class file major version" ou falha ao iniciar o contexto Spring, pois o Spring Framework 6 (base do Boot 3) exige no mínimo Java 17.
- **Esquecer o `@RestController`** (usar apenas `@Controller`): o método passaria a esperar retornar o nome de uma view HTML em vez do corpo JSON, e o teste falharia com erro de "view not found" ou status incorreto.
- **Porta ocupada**: se a porta `8081` já estiver em uso por outro processo, o Spring Boot falhará ao iniciar — pode ser resolvido mudando `server.port` ou finalizando o processo conflitante.

## 28. Exercícios práticos

1. Altere a resposta do endpoint para incluir um terceiro campo `timestamp` com a data/hora atual, ajustando o `record` e o teste correspondente.
2. Escreva um segundo teste que valide o comportamento de um caminho **inexistente** (ex.: `/api/inventory/naoexiste`), esperando status 404.
3. Explique, em suas próprias palavras (por escrito), por que este endpoint não deveria conter lógica de negócio.

## 29. Perguntas de entrevista

1. Qual é a diferença entre `javax.*` e `jakarta.*`, e por que essa mudança aconteceu?
2. Por que, em uma arquitetura de microsserviços, cada serviço deveria ter seu próprio banco de dados?
3. Qual a diferença entre um teste unitário e um teste com `@WebMvcTest`/`MockMvc`, e quando você usaria cada um?

## 30. Resumo dos conceitos aprendidos

- Diferença entre arquitetura monolítica e de microsserviços;
- Responsabilidades bem definidas de `order-service` e `inventory-service`;
- Motivo pelo qual cada serviço deve ter seu próprio banco de dados;
- Papel do Maven e estrutura de um `pom.xml`;
- Função do `spring-boot-starter-parent` no gerenciamento de versões;
- Diferenças entre Spring Boot 2 e 3, incluindo a migração `javax.*` → `jakarta.*`;
- Configuração de compilação com `release 17`;
- Separação de responsabilidades entre Controller, Service e Repository;
- Fundamentos de uma API RESTful e o significado do status HTTP 200;
- Diferença entre teste unitário puro e teste de camada web com `MockMvc`.

## 31. Tabela de versões utilizadas

| Componente        | Versão            |
|--------------------|--------------------|
| Java                | 17 (LTS)            |
| Maven               | 3.9+                 |
| Spring Boot         | 3.5.x (confirmar última patch em start.spring.io) |
| Spring Web (starter)| gerenciado pelo Spring Boot |
| JUnit / Spring Test | gerenciado pelo Spring Boot |

## 32. Lista de comandos executados

~~~bash
java -version
mvn -version
mvn spring-boot:run
mvn test
curl -i http://localhost:8081/api/inventory/health
git init
git add .
git commit -m "feat(inventory-service): health check endpoint with Spring Boot 3 and Java 17"
~~~

## 33. Checklist de validação

- [ ] `java -version` indica Java 17;
- [ ] `mvn -version` indica que o Maven usa Java 17;
- [ ] `mvn test` executa sem erros;
- [ ] `mvn spring-boot:run` inicia a aplicação sem erros;
- [ ] `GET /api/inventory/health` responde HTTP 200;
- [ ] A resposta é um JSON válido com os campos `service` e `status`;
- [ ] Nenhum import `javax.*` presente no código;
- [ ] Existe pelo menos um commit Git no repositório;
- [ ] Você consegue explicar a finalidade de cada arquivo criado;
- [ ] Você consegue explicar por que escolhemos Spring Boot 3.x para Java 17.

## CONTEXTO-PARA-PRÓXIMA-ETAPA

- **O que foi implementado:** projeto `inventory-service` com endpoint de health check em `GET /api/inventory/health`, retornando JSON `{"service":"inventory-service","status":"UP"}`, com teste automatizado via `@WebMvcTest` + `MockMvc`.
- **Arquivos criados:** `pom.xml`, `InventoryServiceApplication.java`, `HealthController.java`, `HealthResponse.java`, `application.properties`, `HealthControllerTest.java`, `README.md`, `.gitignore`.
- **Versões utilizadas:** Java 17, Maven 3.9+, Spring Boot 3.5.x (confirmar última patch).
- **Decisões arquiteturais:** monorepo para a POC; nenhum banco de dados, mensageria ou Spring Cloud nesta etapa; sem Lombok; sem Actuator (endpoint customizado em vez de endpoint padrão do Actuator); uso de `record` para DTO de resposta.
- **Comandos que funcionaram:** `mvn spring-boot:run`, `mvn test`, `curl -i http://localhost:8081/api/inventory/health`.
- **Problemas encontrados:** (a ser preenchido por você após executar o projeto — registre aqui erros de versão de Java, conflitos de porta etc., se ocorrerem).
- **Diferenças entre o ambiente utilizado e o exemplo:** (a ser preenchido por você — ex.: versão exata do JDK instalada, versão exata do Spring Boot usada, sistema operacional).
- **Próximos objetivos:** avançar para a criação do `order-service` com um endpoint de health check equivalente, seguido pela introdução de comunicação HTTP simples entre `order-service` e `inventory-service` (ainda sem banco de dados).