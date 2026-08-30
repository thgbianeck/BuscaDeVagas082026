# Pergunta 13 — Como você lê propriedades customizadas no código com @Value?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Suponha que você defina uma propriedade customizada no `application.properties`, como `app.api.timeout=5000`. Como você acessa esse valor dentro de uma classe Java no Spring Boot?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe usar `@Value` para injetar propriedades do arquivo de configuração em campos, construtores ou métodos, e se conhece as limitações dessa abordagem.

**Resposta esperada:**  
A anotação `@Value` permite injetar valores de propriedades do `application.properties`/`application.yml` diretamente em campos, construtores ou métodos de beans gerenciados pelo Spring.

**Exemplo de uso:**

Arquivo de configuração:
```properties
app.api.timeout=5000
app.api.url=https://api.exemplo.com
app.api.retry=3
app.nome=Minha API
```

Injeção por campo:
```java
@Service
public class ApiService {

    @Value("${app.api.timeout}")
    private int timeout;

    @Value("${app.api.url}")
    private String apiUrl;

    @Value("${app.api.retry:1}")  // valor padrão = 1 se a propriedade não existir
    private int retryCount;

    @Value("${app.nome:App Default}")  // valor padrão = "App Default"
    private String nomeApp;
}
```

Injeção por construtor (recomendada):
```java
@Service
public class ApiService {

    private final int timeout;
    private final String apiUrl;

    public ApiService(
            @Value("${app.api.timeout}") int timeout,
            @Value("${app.api.url}") String apiUrl) {
        this.timeout = timeout;
        this.apiUrl = apiUrl;
    }
}
```

**Sintaxe do `@Value`:**
- `"${propriedade}"` — lê o valor da propriedade.
- `"${propriedade:valorPadrao}"` — lê o valor; se não existir, usa o padrão.
- `"#{expressao}"` — usa SpEL (Spring Expression Language) para expressões mais complexas.

**Limitações do `@Value`:**
- Não é type-safe — se você errar o nome da propriedade, descobre só em runtime.
- Difícil de testar isoladamente sem subir o contexto do Spring.
- Não suporta validação automática.
- Para múltiplas propriedades relacionadas, o código fica verboso.

Por essas limitações, quando há várias propriedades relacionadas, recomenda-se usar `@ConfigurationProperties` (ver Pergunta 14).

**Explicação didática:**  
O `@Value` é como uma "etiqueta" que você coloca em uma variável dizendo: "Spring, quando você criar este objeto, vá até o arquivo de configuração, procure a propriedade X e coloque o valor aqui". O `:valorPadrao` é como dizer "se não encontrar, use este valor".

**Como o candidato deve responder:**  
- Mostrar a sintaxe `${propriedade}`.
- Mencionar o uso de valor padrão com `:`.
- Preferir injeção por construtor.
- Citar pelo menos uma limitação do `@Value` (não é type-safe, difícil de testar).
- Mencionar que `@ConfigurationProperties` é melhor para grupos de propriedades.

**Resposta fraca ou incompleta:**  
"Você usa `@Value` com o nome da propriedade."  
Falta: não mostra a sintaxe `${}`, não menciona valor padrão, não cita limitações.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @Value |
| 1 | Menciona @Value mas erra a sintaxe |
| 2 | Usa sintaxe correta mas sem valor padrão |
| 3 | Explica sintaxe, valor padrão e mostra exemplos |
| 4 | Demonstra prática, menciona limitações e construtor |
| 5 | Responde com profundidade, compara com @ConfigurationProperties e menciona SpEL |

**Perguntas de aprofundamento:**
1. "O que acontece se a propriedade não existir e você não definir um valor padrão?"
2. "Como você usaria `@Value` para ler uma lista de valores?"
3. "Por que `@Value` não é recomendado para ler muitas propriedades relacionadas?"

