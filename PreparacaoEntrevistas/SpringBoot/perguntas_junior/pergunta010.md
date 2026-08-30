# Pergunta 10 — O que é e como funciona a autoconfiguração do Spring Boot?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Uma das principais features do Spring Boot é a autoconfiguração. Como ela funciona internamente? Se eu adicionar o `spring-boot-starter-data-jpa` no meu projeto, o que acontece para que tudo 'funcione magicamente'?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o mecanismo de autoconfiguração para além da superfície, conhece as classes `@Configuration` com `@ConditionalOnClass`, e compreende como o Spring Boot detecta dependências no classpath para configurar beans automaticamente.

**Resposta esperada:**  
A autoconfiguração (*auto-configuration*) é o mecanismo pelo qual o Spring Boot tenta configurar automaticamente a aplicação com base nas dependências presentes no classpath. Quando você adiciona `spring-boot-starter-data-jpa`, por exemplo, o Spring Boot detecta que o JPA e o Hibernate estão no classpath e automaticamente configura:

- Um `EntityManagerFactory` baseado no `DataSource` encontrado.
- Um `TransactionManager` JPA.
- Um `DataSource` baseado nas propriedades definidas (URL, username, password).
- A habilitação do Spring Data JPA (repositories, etc.).

**Como funciona internamente:**

1. A anotação `@EnableAutoConfiguration` (presente em `@SpringBootApplication`) importa a classe `AutoConfigurationImportSelector`.

2. Essa classe lê o arquivo `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` (em versões anteriores, `spring.factories`), que lista todas as classes de autoconfiguração.

3. Cada classe de autoconfiguração é uma classe `@Configuration` que usa anotações condicionais para decidir se deve ou não ser aplicada:

```java
// Exemplo simplificado de como uma autoconfiguração funciona
@Configuration
@ConditionalOnClass(DataSource.class)      // Só aplica se DataSource estiver no classpath
@ConditionalOnMissingBean(DataSource.class) // Só aplica se não houver um DataSource já definido
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceAutoConfiguration {

    @Bean
    public DataSource dataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }
}
```

4. As anotações condicionais mais comuns são:
   - `@ConditionalOnClass` — aplica a configuração se uma classe específica estiver no classpath.
   - `@ConditionalOnMissingBean` — aplica apenas se nenhum bean do tipo já foi definido pelo usuário (permite override).
   - `@ConditionalOnProperty` — aplica com base em uma propriedade.
   - `@ConditionalOnWebApplication` — aplica apenas em aplicações web.

**O princípio do "replaceable" (substituível):**  
A autoconfiguração é projetada para ser **substituível**. Se você define seu próprio `DataSource` bean, o Spring Boot não configura o dele — o seu tem prioridade. É por isso que a anotação `@ConditionalOnMissingBean` é crucial: ela garante que a configuração automática é um "fallback", não uma imposição.

**Explicação didática:**  
Imagine a autoconfiguração como um assistente que entra na sua cozinha e diz: "Vejo que você tem farinha, ovos e açúcar (dependências no classpath). Vou preparar a massa do bolo para você (configurar os beans). Mas se você já tem uma massa pronta (bean definido por você), eu não interfiro — uso a sua."

**Como o candidato deve responder:**  
- Explicar que a autoconfiguração detecta dependências no classpath.
- Mencionar as classes de autoconfiguração (`@Configuration` com condicionais).
- Citar pelo menos `@ConditionalOnClass` e `@ConditionalOnMissingBean`.
- Explicar que a configuração automática é substituível pelo usuário.
- Mencionar o arquivo de imports (ou `spring.factories` em versões antigas).

**Resposta fraca ou incompleta:**  
"O Spring Boot configura tudo automaticamente."  
Falta: não explica como, não menciona condicionais, não fala sobre classpath detection ou substituibilidade.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é autoconfiguração |
| 1 | Sabe que "configura sozinho" mas não explica como |
| 2 | Menciona classpath mas não conhece condicionais |
| 3 | Explica condicionais (@ConditionalOnClass, @ConditionalOnMissingBean) |
| 4 | Demonstra conhecimento do mecanismo de imports e substituibilidade |
| 5 | Responde com profundidade, menciona AutoConfigurationImportSelector, ordem e exclusões |

**Perguntas de aprofundamento:**
1. "Como você desativaria uma autoconfiguração específica que não quer usar?"
2. "O que acontece se duas autoconfigurações tentarem criar o mesmo tipo de bean?"
3. "Como você debugaria para ver quais autoconfigurações foram aplicadas e quais não foram?"

