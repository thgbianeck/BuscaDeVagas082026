# Pergunta 2 — equals() e hashCode() em uma Classe de Domínio

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Imagine que você criou uma classe `Produto` com os atributos `id`, `nome` e `preco`. O sistema precisa verificar se dois objetos `Produto` representam o mesmo item. Quando você coloca esses objetos em um `HashSet`, percebe que produtos duplicados estão sendo inseridos. O que pode estar acontecendo e como você resolve esse problema?

**O que essa pergunta avalia:**  
Compreensão de como o método `equals()` define igualdade entre objetos, como o `hashCode()` é usado por coleções baseadas em hash, e a relação contratoual entre os dois métodos.

**Resposta esperada:**  
Por padrão, a classe `Object` implementa `equals()` comparando referências de memória (endereço), não o conteúdo dos atributos. Assim, dois objetos `Produto` com os mesmos dados são considerados diferentes. O `HashSet` usa `hashCode()` para agrupar elementos em "buckets" e depois `equals()` para confirmar igualdade. Se ambos não forem sobrescritos, cada objeto terá um `hashCode` único baseado no endereço de memória, e `equals()` também comparará referências, permitindo duplicatas.

A solução é sobrescrever `equals()` e `hashCode()` na classe `Produto`, definindo igualdade com base no `id` (ou nos campos que representam a identidade do produto). É obrigatório que dois objetos considerados iguais por `equals()` tenham o mesmo `hashCode`.

**Explicação didática:**  
Imagine o `HashSet` como um armário com várias gavetas numeradas. Quando você insere um objeto, o Java calcula o `hashCode()` para decidir em qual gaveta guardá-lo. Depois, usa `equals()` para verificar se já existe um objeto igual naquela gaveta. Se você não sobrescrever `hashCode()`, cada objeto vai para uma gaveta diferente (baseada no endereço de memória), então o Java nunca chega a comparar com `equals()`, e duplicatas passam despercebidas.

**Exemplo prático:**  
Em um e-commerce, ao adicionar produtos a um carrinho, você precisa garantir que o mesmo produto (mesmo `id`) não seja inserido duas vezes. Sem `equals()` e `hashCode()` corretos, o `HashSet` permitirá duplicatas silenciosamente.

**Exemplo de código:**  
```java
import java.util.Objects;

public class Produto {
    private Long id;
    private String nome;
    private Double preco;
    
    public Produto(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    
    // Dois produtos são iguais se têm o mesmo id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;           // Mesma referência
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }
    
    // hashCode baseado no mesmo campo usado em equals()
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
```

**Como o candidato deve responder:**  
- Identificar o problema: `equals()` e `hashCode()` padrão usam referência de memória.
- Explicar como o `HashSet` funciona internamente (hashCode + equals).
- Apresentar a solução: sobrescrever ambos os métodos.
- Mencionar a regra do contrato: objetos iguais devem ter o mesmo hashCode.
- Recomendar o uso de `Objects.equals()` e `Objects.hash()` para evitar NullPointerException.
- Evitar sobrescrever apenas `equals()` sem `hashCode()`.

**Resposta fraca ou incompleta:**  
"Sobrescrever o `equals()` para comparar os atributos." — Falta mencionar o `hashCode()` e a relação entre os dois. Sem sobrescrever `hashCode()`, o `HashSet` ainda não funcionará corretamente.

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
1. O que pode acontecer se você sobrescrever `equals()` mas não `hashCode()`?
2. Por que é importante que dois objetos iguais tenham o mesmo `hashCode`, mas objetos diferentes podem ter o mesmo `hashCode`?
3. Quais campos você usaria para definir igualdade de um `Produto` — apenas `id` ou também `nome` e `preco`? Por quê?