# Pergunta 14 — O que é e como funciona @ConfigurationProperties?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Em vez de usar várias anotações `@Value` espalhadas pela classe, o Spring Boot oferece o `@ConfigurationProperties`. O que é essa anotação, como ela funciona e quais vantagens oferece sobre `@Value`?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece a abordagem type-safe de leitura de propriedades, sabe criar uma classe de configuração com `@ConfigurationProperties` e entende as vantagens sobre `@Value`.

**Resposta esperada:**  
`@ConfigurationProperties` é uma anotação que permite agrupar propriedades relacionadas em uma classe Java tipada, oferecendo uma alternativa type-safe ao `@Value`. O Spring Boot faz o binding automático entre as propriedades do arquivo de configuração e os campos da classe.

**Exemplo completo:**

Arquivo de configuração:
```properties
app.api.url=https://api.exemplo.com
app.api.timeout=5000
app.api.retry=3
app.api.endpoints[0]=/usuarios
app.api.endpoints[1]=/produtos
```

Classe de configuração:
```java
@Component
@ConfigurationProperties(prefix = "app.api")
public class ApiConfig {

    private String url;
    private int timeout;
    private int retry;
    private List<String> endpoints;

    // Getters e setters são OBRIGATÓRIOS para o binding funcionar
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public int getTimeout() { return timeout; }
    public void setTimeout(int timeout) { this.timeout = timeout; }

    public int getRetry() { return retry; }
    public void setRetry(int retry) { this.retry = retry; }

    public List<String> getEndpoints() { return endpoints; }
    public void setEndpoints(List<String> endpoints) { this.endpoints = endpoints; }
}
```

Usando a configuração:
```java
@Service
public class ApiService {

    private final ApiConfig apiConfig;

    // Injeção por construtor — a classe ApiConfig é um bean
    public ApiService(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    public void chamarApi() {
        String url = apiConfig.getUrl();           // type-safe
        int timeout = apiConfig.getTimeout();      // já é int, não String
        System.out.println("Chamando " + url + " com timeout " + timeout);
    }
}
```

**Usando records (Spring Boot 3.x / Java 17+):**

```java
@ConfigurationProperties(prefix = "app.api")
public record ApiConfig(
    String url,
    int timeout,
    int retry,
    List<String> endpoints
) {}
```

Com records, o binding funciona via construtor canônico, sem necessidade de getters/setters.

**Vantagens sobre `@Value`:**

| Aspecto | @Value | @ConfigurationProperties |
|---------|--------|--------------------------|
| Type-safety | Não — erro de nome só em runtime | Sim — compilador valida tipos |
| Agrupamento | Um por campo | Agrupa propriedades relacionadas |
| Validação | Não suporta nativamente | Suporta `@Valid` + Bean Validation |
| Testabilidade | Difícil sem contexto Spring | Fácil — instanciar com construtor |
| Listas/Maps | Suporte limitado | Suporte nativo |
| IDE support | Limitado | Autocomplete de propriedades |

**Explicação didática:**  
Se `@Value` é como anotar cada item da sua lista de compras em um post-it separado, `@ConfigurationProperties` é como organizar todos os itens em uma planilha categorizada. A planilha é mais fácil de ler, validar e manter. Você cria uma classe que "espelha" a estrutura das suas propriedades, e o Spring preenche os valores automaticamente.

**Como o candidato deve responder:**  
- Explicar que agrupa propriedades relacionadas em uma classe tipada.
- Mostrar a anotação `@ConfigurationProperties(prefix = "...")`.
- Mencionar que a classe precisa ser um `@Component` (ou registrada via `@EnableConfigurationProperties`).
- Citar as vantagens sobre `@Value`: type-safe, validação, testabilidade.
- Mencionar a necessidade de getters/setters (ou records no Java 17+).

**Resposta fraca ou incompleta:**  
"É outra forma de ler propriedades."  
Falta: não explica como funciona, não mostra prefix, não cita vantagens sobre @Value.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @ConfigurationProperties |
| 1 | Já ouviu falar mas não sabe usar |
| 2 | Mostra o uso básico mas não compara com @Value |
| 3 | Explica uso, prefix e vantagens sobre @Value |
| 4 | Demonstra prática com listas, records e validação |
| 5 | Responde com profundidade, menciona @EnableConfigurationProperties, relaxed binding e meta-anotações |

**Perguntas de aprofundamento:**
1. "O que é 'relaxed binding' no contexto do `@ConfigurationProperties`?"
2. "Como você adicionaria validação às propriedades lidas via `@ConfigurationProperties`?"
3. "Qual a diferença entre usar `@Component` e `@EnableConfigurationProperties` para registrar a classe?"

