# Pergunta 3 — O que são Spring Boot Starters?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, você geralmente adiciona dependências como `spring-boot-starter-web`, `spring-boot-starter-data-jpa`, etc. O que são esses starters e qual a vantagem de usá-los?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o conceito de starters como agregadores de dependências, se sabe que eles resolvem conflitos de versão e se compreende a diferença entre adicionar dependências individuais vs. usar starters.

**Resposta esperada:**  
Starters são descritores de dependência (POMs) que agrupam um conjunto de bibliotecas relacionadas, com versões compatíveis entre si, para uma funcionalidade específica. Em vez de adicionar manualmente Spring MVC, Jackson, Tomcat embeddado e Bean Validation separadamente (correndo o risco de versões incompatíveis), você adiciona apenas `spring-boot-starter-web`, que traz tudo isso já testado e compatível.

As principais características são:

1. **Agregação** — cada starter traz todas as dependências necessárias para uma funcionalidade.
2. **Versionamento coordenado** — as versões são gerenciadas pelo Spring Boot BOM (Bill of Materials), garantindo compatibilidade.
3. **Nomenclatura padronizada** — seguem o padrão `spring-boot-starter-*`, facilitando a identificação.
4. **Configuração zero** — além das dependências, a autoconfiguração do Spring Boot detecta a presença do starter e configura os beans necessários.

**Explicação didática:**  
Pense nos starters como "kits prontos". Se você fosse montar uma bicicleta peça por peça, teria que escolher cada componente (aro, pneu, corrente, pedal) garantindo compatibilidade. Um starter é como comprar uma bicicleta com todos os componentes já selecionados e compatíveis — você só precisa escolher o modelo (starter) certo para o seu objetivo.

Exemplos comuns de starters:
- `spring-boot-starter-web` — Spring MVC, Jackson, Tomcat embutido, Bean Validation.
- `spring-boot-starter-data-jpa` — Spring Data JPA, Hibernate, JDBC.
- `spring-boot-starter-test` — JUnit 5, Mockito, AssertJ, Spring Test.
- `spring-boot-starter-security` — Spring Security, configuração básica de segurança.

**Exemplo prático:**  
Sem starters, para um endpoint REST com JPA, você precisaria adicionar no `pom.xml`:

```xml
<!-- Sem starters — muitas dependências manuais -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>6.1.x</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.16.x</version>
</dependency>
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-core</artifactId>
    <version>10.1.x</version>
</dependency>
<!-- ... e mais várias dependências ...
```

Com starters:

```xml
<!-- Com starters — uma única dependência -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Note que nem a versão precisa ser especificada — o Spring Boot BOM já gerencia isso.

**Como o candidato deve responder:**  
- Explicar que starters são pacotes de dependências pré-configuradas.
- Mencionar que resolvem conflitos de versionamento.
- Citar pelo menos dois exemplos de starters conhecidos.
- Explicar que a nomenclatura segue o padrão `spring-boot-starter-*`.

**Resposta fraca ou incompleta:**  
"Starters são bibliotecas do Spring Boot."  
Falta: não explica que são agregadores de dependências, não menciona versionamento coordenado, não dá exemplos.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe responder |
| 1 | Sabe que "adiciona funcionalidades" mas não explica como |
| 2 | Menciona que agrupam dependências, mas sem detalhar versionamento |
| 3 | Explica agregação, versionamento e dá exemplos |
| 4 | Demonstra conhecimento prático, menciona BOM e autoconfiguração |
| 5 | Responde com profundidade, diferencia starters oficiais de terceiros, explica o POM interno |

**Perguntas de aprofundamento:**
1. "Se você não quisesse usar o Tomcat embutido que vem no `spring-boot-starter-web`, como faria para usar o Jetty?"
2. "Existe algum starter que você não deve usar em produção? Qual e por quê?"
3. "Como você criaria um starter customizado?"

---
