# Pergunta 27 — Lambdas e Functional Interfaces

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você tem uma lista de produtos e precisa filtrar os que custam mais de `R$ 100`. Sem usar Streams, um colega escreveu um método que recebe a lista e um objeto `Predicate<Product>` anônimo. Outro colega sugere usar uma expressão lambda. Explique como os lambdas funcionam, qual é a relação com interfaces funcionais e reescreva o código usando lambda.

**O que essa pergunta avalia:**  
Compreensão do que são expressões lambda em Java, conhecimento de interfaces funcionais, e capacidade de substituir classes anônimas por lambdas.

**Resposta esperada:**  
Uma **interface funcional** é uma interface com exatamente um método abstrato (SAM — Single Abstract Method). Pode ser anotada com `@FunctionalInterface` (opcional, mas recomendada). Exemplos: `Predicate<T>` (`test`), `Consumer<T>` (`accept`), `Function<T,R>` (`apply`), `Supplier<T>` (`get`).

Uma **expressão lambda** é uma forma concisa de implementar uma interface funcional sem criar uma classe anônima. A lambda é basicamente o corpo do método abstrado da interface, com os parâmetros inferidos pelo compilador.

**Sintaxe:** `(parâmetros) -> { corpo }`  
- Sem parâmetros: `() -> System.out.println("hello")`
- Um parâmetro: `p -> p.getPreco() > 100`
- Múltiplos parâmetros: `(a, b) -> a + b`
- Com tipo explícito: `(Product p) -> p.getPreco() > 100`

**Explicação didática:**  
Imagine que uma interface funcional é como uma tomada na parede — tem um formato específico (um único método). A classe anônima é como construir uma caixa inteira para plugar na tomada, com moldura e parafusos. O lambda é como plugar diretamente o fio — sem a caixa, sem parafusos, apenas a conexão necessária. O compilador entende que o lambda deve se encaixar na "tomada" (interface funcional) pelo formato do método.

**Exemplo prático:**  
Em um sistema de catálogo de produtos, o usuário pode aplicar diferentes filtros dinamicamente (por preço, por categoria, por nome). Cada filtro é um `Predicate<Produto>` que pode ser expresso como lambda.

**Exemplo de código:**  
```java
import java.util.*;
import java.util.function.Predicate;

class Product {
    private String nome;
    private double preco;
    
    public Product(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}

public class FiltroProdutos {
    
    // Método que aceita um Predicate — interface funcional
    public List<Product> filtrar(List<Product> produtos, Predicate<Product> criterio) {
        List<Product> resultado = new ArrayList<>();
        for (Product p : produtos) {
            if (criterio.test(p)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    public void demonstrar() {
        List<Product> produtos = Arrays.asList(
            new Product("Mouse", 50.0),
            new Product("Teclado", 150.0),
            new Product("Monitor", 800.0),
            new Product("Cabo", 25.0)
        );
        
        // ❌ Classe anônima — verboso
        List<Product> caros1 = filtrar(produtos, new Predicate<Product>() {
            @Override
            public boolean test(Product p) {
                return p.getPreco() > 100.0;
            }
        });
        
        // ✅ Lambda — conciso e legível
        List<Product> caros2 = filtrar(produtos, 
            p -> p.getPreco() > 100.0);
        
        // ✅ Method reference — ainda mais conciso
        // (quando o lambda apenas chama um método existente)
        
        // Diferentes critérios com lambdas
        List<Product> baratos = filtrar(produtos, 
            p -> p.getPreco() < 100.0);
        
        List<Product> comecaComM = filtrar(produtos, 
            p -> p.getNome().startsWith("M"));
        
        // Compondo predicates
        Predicate<Product> caro = p -> p.getPreco() > 100.0;
        Predicate<Product> comecaM = p -> p.getNome().startsWith("M");
        List<Product> carosEcomecamM = filtrar(produtos, 
            caro.and(comecaM)); // Composição de predicates
    }
}

// Interface funcional customizada
@FunctionalInterface
interface Validador<T> {
    boolean validar(T valor);
    // Pode ter métodos default e static, mas só UM abstrato
    default Validador<T> e(Validador<T> outro) {
        return valor -> this.validar(valor) && outro.validar(valor);
    }
}

// Uso da interface customizada com lambda
Validador<String> naoVazio = s -> s != null && !s.isEmpty();
Validador<String> temArroba = s -> s.contains("@");
Validador<String> emailValido = naoVazio.e(temArroba);
// emailValido.validar("teste@email.com") → true
```

**Como o candidato deve responder:**  
- Explicar que lambda é uma forma concisa de implementar uma interface funcional.
- Definir interface funcional: exatamente um método abstrato.
- Mostrar a evolução: classe anônima → lambda → method reference.
- Demonstrar composição de predicates (`and`, `or`, `negate`).
- Trazer o exemplo do catálogo com filtros.
- Evitar confundir lambda com método anônimo genérico (precisa de uma interface funcional como alvo).

**Resposta fraca ou incompleta:**  
"Usar `p -> p.getPreco() > 100` em vez de classe anônima." — Correto mas não explica o que é uma interface funcional, nem como o compilador sabe qual método implementar. Não mostra composição nem outros tipos de interfaces funcionais.

**Critérios de avaliação:**

| Nota | Descrição |
|---|---|
| 0 | Não sabe responder ou apresenta informações incorretas |
| 1 | Demonstra conhecimento muito superficial |
| 2 | Conhece parte do conceito, mas apresenta lacunas importantes |
| 3 | Responde corretamente aos fundamentos |
| 4 | Demonstra bom domínio prático e apresenta exemplos |
| 5 | Responde com profundidade, apresenta trade-offs, boas práticas e experiência real |

**Perguntas de aprofundamento:**
1. O que é a anotação `@FunctionalInterface` e o que acontece se a interface tiver dois métodos abstratos?
2. Qual a diferença entre `Predicate`, `Consumer`, `Function` e `Supplier`?
3. O que são "variable capture" e "effectively final" no contexto de lambdas?

