# Pergunta 18 — Como funciona o servidor embutido (embedded server) no Spring Boot?

**Nível:** Júnior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
"Uma das características mais marcantes do Spring Boot é que você pode rodar a aplicação com `java -jar` sem precisar de um servidor de aplicação externo. Como isso funciona? Qual servidor é usado por padrão e como você poderia trocá-lo?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o conceito de servidor embutido, sabe que o Tomcat é o padrão, conhece alternativas (Jetty, Undertow) e compreende as vantagens dessa abordagem em relação a servidores externos.

**Resposta esperada:**  
O Spring Boot embute um servidor web dentro do próprio JAR da aplicação, eliminando a necessidade de instalar e configurar um servidor de aplicação externo (como Tomcat, JBoss/WildFly, WebLogic).

**Como funciona:**

- O servidor embutido é inicializado pela classe `SpringApplication` durante o startup.
- O servidor roda dentro da mesma JVM da aplicação, como um componente gerenciado pelo Spring.
- A aplicação é empacotada como um **JAR executável** (fat JAR), que contém todas as dependências, incluindo o servidor.

**Servidor padrão:**

- **Tomcat** é o servidor embutido padrão, trazido automaticamente pelo `spring-boot-starter-web`.

**Como trocar de servidor:**
Para usar **Jetty**:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

Para usar **Undertow**:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-undertow</artifactId>
</dependency>
```

**Configuração do servidor:**

```properties
server.port=8080
server.servlet.context-path=/api
server.tomcat.max-threads=200
server.tomcat.connection-timeout=20000
server.compression.enabled=true
```

**Vantagens do servidor embutido:**

- **Deploy simplificado** — basta `java -jar app.jar`, sem instalar servidor.
- **Versionamento consistente** — a versão do servidor é parte do projeto, garantindo paridade entre ambientes.
- **Inicialização rápida** — ideal para microsserviços e containers.
- **Configuração via código/propriedades** — sem arquivos XML externos do servidor.

**Desvantagens/trade-offs:**

- Não é possível fazer deploy de múltiplas aplicações no mesmo servidor (como em um Tomcat externo com múltiplos WARs).
- Para ambientes legados que exigem servidor de aplicação compartilhado, pode não ser adequado.

**Explicação didática:**  
No modelo tradicional, o servidor (Tomcat, JBoss) é como um "prédio" e a aplicação é um "inquilino" que se muda para dentro dele (deploy de WAR). No Spring Boot, a aplicação é como uma "casa prefabricada" que já vem com toda a infraestrutura embutida — você só coloca no terreno e ela funciona. Não precisa alugar um prédio separado.

**Como o candidato deve responder:**  

- Explicar que o servidor (Tomcat) roda dentro da JVM da aplicação.
- Mencionar que o JAR executável inclui o servidor.
- Citar que é possível trocar por Jetty ou Undertow (excluir Tomcat, adicionar o outro).
- Mencionar vantagens: deploy simplificado, paridade de ambiente.
- Citar pelo menos uma desvantagem ou trade-off.

**Resposta fraca ou incompleta:**  
"O Spring Boot tem um servidor embutido."  
Falta: não explica como funciona, não cita Tomcat, não mostra como trocar.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é servidor embutido |
| 1 | Sabe que "roda sem servidor externo" mas não explica |
| 2 | Cita Tomcat mas não sabe trocar |
| 3 | Explica funcionamento, Tomcat padrão e como trocar |
| 4 | Demonstra conhecimento de configuração, vantagens e trade-offs |
| 5 | Responde com profundidade, compara Tomcat/Jetty/Undertow, menciona WAR vs JAR e containers |

**Perguntas de aprofundamento:**

1. "Em quais cenários você escolheria Undertow em vez de Tomcat?"
2. "É possível empacotar uma aplicação Spring Boot como WAR para deploy em servidor externo? Como?"
3. "Como o servidor embutido afeta a estratégia de deploy em containers (Docker)?"
