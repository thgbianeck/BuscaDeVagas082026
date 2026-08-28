# Pergunta 6 — O que são e como funcionam os Profiles no Spring Boot?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, frequentemente precisamos de configurações diferentes para desenvolvimento, teste e produção. Como os Profiles ajudam com isso e como você os utiliza?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o mecanismo de profiles do Spring, sabe criar e ativar profiles, e entende como eles permitem isolar configurações por ambiente.

**Resposta esperada:**  
Profiles são um mecanismo do Spring que permite definir configurações específicas por ambiente (dev, test, prod, staging, etc.). Com profiles, você pode ter conjuntos diferentes de beans, propriedades e configurações, ativando apenas o conjunto apropriado para cada ambiente.

**Como utilizar profiles:**

1. **Arquivos de configuração por profile:**  
Você pode criar arquivos `application-{profile}.properties` (ou `.yml`):
- `application.properties` — configurações comuns a todos os ambientes.
- `application-dev.properties` — configurações específicas de desenvolvimento.
- `application-prod.properties` — configurações específicas de produção.

2. **Ativação de profile:**  
Via `application.properties`:
```properties
spring.profiles.active=dev
```
Via linha de comando:
```bash
java -jar app.jar --spring.profiles.active=prod
```
Via variável de ambiente:
```
SPRING_PROFILES_ACTIVE=prod
```

3. **Beans condicionais por profile:**  
A anotação `@Profile` permite que beans sejam registrados apenas quando um profile específico está ativo:

```java
@Configuration
@Profile("dev")
public class DevConfig {
    @Bean
    public DataSource dataSource() {
        // DataSource em memória para desenvolvimento
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .build();
    }
}

@Configuration
@Profile("prod")
public class ProdConfig {
    @Bean
    public DataSource dataSource() {
        // DataSource de produção (PostgreSQL, MySQL, etc.)
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:postgresql://prod-db:5432/minhadb");
        return ds;
    }
}
```

4. **Multi-document YAML:**  
Com YAML, é possível definir múltiplos profiles em um único arquivo:

```yaml
spring:
  profiles:
    active: dev
---
spring:
  config:
    activate:
      on-profile: dev
server:
  port: 8080
---
spring:
  config:
    activate:
      on-profile: prod
server:
  port: 80
```

**Explicação didática:**  
Profiles funcionam como "personalidades" da sua aplicação. A mesma aplicação pode se comportar de formas diferentes dependendo do profile ativo. É como uma pessoa que em casa (dev) usa roupa casual, no escritório (prod) usa traje formal, e na academia (test) usa roupa de treino — é a mesma pessoa, mas com configurações diferentes para cada contexto.

**Como o candidato deve responder:**  
- Explicar que profiles permitem configurações por ambiente.
- Mostrar como criar arquivos `application-{profile}.properties`.
- Explicar como ativar profiles (propriedades, CLI, variável de ambiente).
- Mencionar `@Profile` para beans condicionais.
- Se possível, mencionar multi-document YAML.

**Resposta fraca ou incompleta:**  
"Profiles servem para separar dev e prod."  
Falta: não explica como criar, ativar ou usar, não menciona `@Profile` ou arquivos específicos.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que são profiles |
| 1 | Sabe que "separa ambientes" mas não explica como |
| 2 | Menciona arquivos `application-dev.properties` mas não sabe ativar |
| 3 | Explica criação, ativação e uso de `@Profile` |
| 4 | Demonstra conhecimento prático com múltiplas formas de ativação |
| 5 | Responde com profundidade, menciona YAML multi-document, prioridade de profiles e boas práticas |

**Perguntas de aprofundamento:**
1. "É possível ativar múltiplos profiles ao mesmo tempo? Como?"
2. "O que acontece se uma propriedade estiver definida em `application.properties` e também em `application-dev.properties`?"
3. "Como você garantiria que o profile de produção nunca use o banco H2 em memória?"

