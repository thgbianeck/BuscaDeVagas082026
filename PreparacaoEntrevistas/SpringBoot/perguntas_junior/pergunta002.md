# Pergunta 2 — O que faz a anotação `@SpringBootApplication`?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Quando você cria uma classe principal em um projeto Spring Boot, ela geralmente tem a anotação `@SpringBootApplication`. O que essa anotação faz exatamente?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe que `@SpringBootApplication` é uma anotação composta (meta-anotação) e se conhece as três anotações que ela combina. Isso revela entendimento de como o Spring Boot inicializa o contexto da aplicação, faz escaneamento de componentes e habilita a autoconfiguração.

**Resposta esperada:**  
A anotação `@SpringBootApplication` é uma anotação composta que combina três anotações do Spring:

1. **`@SpringBootConfiguration`** — marca a classe como uma classe de configuração, equivalente a `@Configuration`. Permite que a classe registre beans via métodos `@Bean`.

2. **`@EnableAutoConfiguration`** — ativa o mecanismo de autoconfiguração do Spring Boot, que analisa as dependências no classpath e registra automaticamente os beans necessários (DataSource, MVC, Jackson, etc.).

3. **`@ComponentScan`** — escaneia o pacote da classe anotada e seus subpacotes em busca de componentes (`@Component`, `@Service`, `@Repository`, `@Controller`, etc.), registrando-os como beans no contexto do Spring.

**Explicação didática:**  
Imagine que `@SpringBootApplication` é um "pacote promocional" que compra três coisas de uma vez: (1) uma licença para configurar beans, (2) um assistente que configura tudo automaticamente com base no que ele encontra no classpath, e (3) um scanner que procura todos os componentes do seu projeto. Sem ela, você teria que anotar a classe com essas três anotações separadamente.

Um detalhe importante: o `@ComponentScan` escaneia a partir do pacote onde a classe anotada está. Por isso, a classe principal geralmente fica no pacote raiz do projeto (ex: `com.empresa.projeto`), para que todos os subpacotes sejam escaneados.

**Exemplo prático:**  
Se a classe principal estiver em `com.empresa.projeto.config.MinhaAplicacao`, apenas os componentes em `com.empresa.projeto.config` e seus subpacotes serão escaneados. Um controller em `com.empresa.projeto.controllers` **não** seria encontrado, causando um erro de "bean não encontrado" ou endpoint não registrado.

**Exemplo de código:**

```java
// Forma equivalente usando as três anotações separadamente:
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.empresa.projeto")
public class MinhaAplicacao {
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }
}

// Forma simplificada com @SpringBootApplication (recomendada):
@SpringBootApplication
public class MinhaAplicacao {
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }
}
```

**Como o candidato deve responder:**  
- Mencionar que é uma anotação composta (combina outras três).
- Nomear as três anotações: `@SpringBootConfiguration`, `@EnableAutoConfiguration` e `@ComponentScan`.
- Explicar brevemente o que cada uma faz.
- Mencionar a importância da localização da classe principal (pacote raiz) por causa do `@ComponentScan`.

**Resposta fraca ou incompleta:**  
"`@SpringBootApplication` é a anotação que faz a aplicação rodar."  
Falta: não explica que é composta, não menciona as três anotações internas, não fala sobre component scanning.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe responder |
| 1 | Sabe que "inicia a aplicação" mas não explica o que faz internamente |
| 2 | Menciona uma ou duas das três anotações internas |
| 3 | Nomeia as três anotações e explica o que cada uma faz |
| 4 | Explica a importância do pacote raiz e o impacto do ComponentScan |
| 5 | Responde com profundidade, menciona basePackages, exclusão de autoconfiguração e dá exemplos |

**Perguntas de aprofundamento:**
1. "Se você precisasse excluir uma autoconfiguração específica, como faria isso com `@SpringBootApplication`?"
2. "O que aconteceria se você colocasse a classe principal em um subpacote específico, como `com.empresa.projeto.config`?"
3. "É possível usar `@SpringBootApplication` sem `@EnableAutoConfiguration`? Como?"

---
