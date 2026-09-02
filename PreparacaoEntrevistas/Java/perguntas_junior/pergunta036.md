# Pergunta 36 — Validação de Parâmetros e Fail-Fast

**Nível:** Júnior  
**Categoria:** Boas Práticas

**Pergunta do entrevistador:**  
Você está revisando um método de cadastro de produto que recebe `nome`, `preco` e `categoria` como parâmetros. O método não valida nenhum dos parâmetros — simplesmente os atribui aos campos. Em produção, já houve bugs com produtos cadastrados com preço negativo e nome vazio. Como você implementaria validação no método? O que é o princípio "fail-fast" e por que ele é importante?

**O que essa pergunta avalia:**  
Conhecimento do princípio fail-fast, capacidade de implementar validação de parâmetros, e compreensão de por que validar na entrada evita bugs em cascata.

**Resposta esperada:**  
O princípio **fail-fast** significa detectar e reportar erros o mais cedo possível — idealmente no momento em que os dados entram no sistema, em vez de deixar o erro propagar e se manifestar em outro lugar (às vezes muito tempo depois).

Para o método de cadastro:
1. Validar **todos** os parâmetros no início do método.
2. Se qualquer parâmetro for inválido, lançar `IllegalArgumentException` imediatamente.
3. Só prosseguir com a lógica do método se **todos** os parâmetros forem válidos.

**Benefícios do fail-fast:**
- O erro é detectado na origem, não em um ponto distante.
- A stack trace aponta exatamente onde o dado inválido entrou.
- Evita estado inconsistente (ex: produto com preço negativo persistido no banco).
- Facilita debugging — o desenvolvedor sabe exatamente qual parâmetro estava errado.

**Explicação didática:**  
Imagine uma fábrica de automóveis. Se um parafuso defeituoso entra na linha de montagem e ninguém verifica, ele vai parar no carro finalizado — e o problema só é descoberto quando o cliente dirige e ouve um barulho estranho. O fail-fast é como ter um inspetor na entrada da fábrica que verifica cada parafuso antes de ele entrar na linha. Se o parafuso está com defeito, a linha para imediatamente, o problema é corrigido na hora, e não chega ao cliente.

**Exemplo prático:**  
Em um sistema de e-commerce, um produto é cadastrado com preço `-50.0`. Sem validação, o produto vai para o banco de dados. Quando o cliente adiciona ao carrinho, o sistema calcula o total como negativo (credito ao cliente). Quando o pagamento é processado, o gateway rejeita o valor negativo. O erro só é descoberto dias depois, com um cliente irritado. Com fail-fast, o cadastro é rejeitado na hora.

**Exemplo de código:**  
```java
import java.util.Objects;

public class CadastroProduto {
    
    // ❌ Sem validação — aceita qualquer coisa
    public Produto cadastrarSemValidacao(String nome, double preco, 
                                         String categoria) {
        Produto p = new Produto();
        p.setNome(nome);       // Pode ser null ou vazio
        p.setPreco(preco);     // Pode ser negativo!
        p.setCategoria(categoria); // Pode ser null
        repository.save(p);
        return p;
    }
    
    // ✅ Com validação fail-fast
    public Produto cadastrar(String nome, double preco, String categoria) {
        // Validação imediata — fail fast na entrada
        Objects.requireNonNull(nome, "Nome não pode ser null");
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        
        if (preco <= 0) {
            throw new IllegalArgumentException(
                "Preço deve ser positivo. Recebido: " + preco);
        }
        
        Objects.requireNonNull(categoria, "Categoria não pode ser null");
        if (categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria não pode ser vazia");
        }
        
        // Só chega aqui se todos os parâmetros são válidos
        Produto produto = new Produto();
        produto.setNome(nome.trim());
        produto.setPreco(preco);
        produto.setCategoria(categoria.trim());
        repository.save(produto);
        return produto;
    }
    
    // ✅ Alternativa: validar no construtor do próprio objeto
    public Produto cadastrarComConstrutor(String nome, double preco, 
                                          String categoria) {
        // O construtor do Produto já valida — fail fast na criação
        return repository.save(new Produto(nome, preco, categoria));
    }
}

// Produto com validação no construtor
class Produto {
    private final String nome;
    private final double preco;
    private final String categoria;
    
    public Produto(String nome, double preco, String categoria) {
        // Todas as validações no construtor — não permite objeto inválido
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser positivo");
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria é obrigatória");
        }
        
        this.nome = nome.trim();
        this.preco = preco;
        this.categoria = categoria.trim();
    }
}
```

**Como o candidato deve responder:**  
- Explicar o princípio fail-fast: detectar erros o mais cedo possível.
- Mostrar validação de cada parâmetro no início do método.
- Usar `IllegalArgumentException` ou `NullPointerException` (via `Objects.requireNonNull`).
- Justificar: evita bugs em cascata, facilita debugging, previne dados inconsistentes.
- Mencionar a alternativa de validar no construtor do próprio objeto.
- Trazer o exemplo do produto com preço negativo.
- Evitar apenas sugerir `if (nome != null)` sem tratar os outros casos.

**Resposta fraca ou incompleta:**  
"Adicionar `if (preco < 0) return null;` no início do método." — Retornar `null` em vez de lançar exceção mascara o erro. O chamador pode ignorar o `null` e o problema se propaga silenciosamente.

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
1. Por que lançar exceção é melhor que retornar `null` ou um código de erro?
2. Qual a diferença entre `Objects.requireNonNull()` e verificar `if (x == null)` manualmente?
3. Como frameworks como Spring Boot validam parâmetros (ex: `@Valid`, Bean Validation)?

