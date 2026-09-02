# Pergunta 19 — Como o Maven se integra com o Spring Boot?

**Nível:** Júnior  
**Categoria:** Ferramentas

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, geralmente usamos Maven como gerenciador de dependências e build. Como o Maven se integra com o Spring Boot? O que é o `spring-boot-maven-plugin` e quais goals ele oferece?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o papel do Maven no projeto Spring Boot, conhece o `spring-boot-maven-plugin` e sabe quais são seus goals principais (run, package, repackage).

**Resposta esperada:**  
O Maven é o gerenciador de build e dependências mais comum em projetos Spring Boot (embora Gradle também seja suportado). A integração entre Maven e Spring Boot acontece principalmente através do `spring-boot-maven-plugin`.

**O `pom.xml` típico de um projeto Spring Boot:**

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.0</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
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
```

**O que o `spring-boot-starter-parent` faz:**

- Fornece o **BOM (Bill of Materials)** — gerencia versões de todas as dependências do Spring Boot, garantindo compatibilidade.
- Configura **encoding UTF-8** e **Java version** por padrão.
- Define configurações padrão de plugins (compilador, surefire para testes, etc.).

**O que o `spring-boot-maven-plugin` faz:**

1. **`repackage`** (executado automaticamente na fase `package`):  
   Transforma o JAR normal (que só tem as classes da aplicação) em um **JAR executável** (fat JAR), que inclui todas as dependências e o servidor embutido. É por isso que você pode rodar `java -jar app.jar`.

2. **`run`**:  

   Inicia a aplicação diretamente do Maven, sem precisar compilar e empacotar primeiro:

   ```bash
   mvn spring-boot:run
   ```

   Útil durante o desenvolvimento.

3. **`start`** e **`stop`**:

   Inicia e para a aplicação em segundo plano, útil para testes de integração.

4. **`build-info`**:

   Gera um arquivo `build-info.properties` com informações de build (versão, data, artefato) que pode ser exposto via Actuator.

**Comandos Maven comuns no dia a dia:**

```bash
mvn clean package          # Compila, testa e empacota em JAR executável
mvn spring-boot:run        # Roda a aplicação
mvn clean install          # Compila, testa, empacota e instala no repo local
mvn test                   # Roda apenas os testes
mvn clean package -DskipTests  # Empacota sem rodar testes (não recomendado em CI)
```

**Explicação didática:**  
O Maven é como um "gerente de obra" do seu projeto. Ele sabe quais materiais (dependências) são necessários, em quais versões, e coordena todo o processo de construção: compila o código, roda os testes e, no final, entrega o produto pronto (JAR executável). O `spring-boot-maven-plugin` é a ferramenta especializada que o Maven usa para empacotar tudo (código + dependências + servidor) em um único JAR que "sabe se rodar sozinho".

**Como o candidato deve responder:**

- Explicar que o `spring-boot-starter-parent` gerencia versões (BOM).
- Mencionar o `spring-boot-maven-plugin` e o goal `repackage` (cria o JAR executável).
- Citar o goal `run` para iniciar a aplicação via Maven.
- Mencionar comandos básicos: `mvn clean package`, `mvn spring-boot:run`.

**Resposta fraca ou incompleta:**  
"O Maven compila o projeto."  
Falta: não menciona o plugin do Spring Boot, não explica repackage ou JAR executável, não cita o parent POM.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe a relação Maven-Spring Boot |
| 1 | Sabe que "gerencia dependências" mas não detalha |
| 2 | Menciona spring-boot-maven-plugin mas não explica goals |
| 3 | Explica parent POM (BOM), plugin e goals principais |
| 4 | Demonstra prática com comandos e configuração |
| 5 | Responde com profundidade, menciona fat JAR, profiles Maven e integração com CI/CD |

**Perguntas de aprofundamento:**

1. "O que é o BOM (Bill of Materials) e como ele garante compatibilidade de versões?"
2. "Como você sobrescreveria a versão de uma dependência gerenciada pelo parent POM?"
3. "Qual a diferença entre `mvn package` e `mvn install`?"
