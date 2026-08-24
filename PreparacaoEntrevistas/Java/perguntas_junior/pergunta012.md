# Pergunta 12 — HashMap e Chaves Customizadas

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Você está desenvolvendo um sistema de cache de produtos onde a chave é um objeto `Produto` (com `id` e `nome`). Você usa um `HashMap<Produto, String>` para armazenar a descrição em cache. Ao buscar um produto que foi inserido anteriormente, o `get()` retorna `null` mesmo sabendo que o produto está no cache. Você confirma que o objeto buscado tem o mesmo `id` e `nome`. O que pode estar errado?

**O que essa pergunta avalia:**  
Compreensão do funcionamento interno de `HashMap`, a relação entre `hashCode()` e `equals()`, e a importância de implementar esses métodos em classes usadas como chaves.

**Resposta esperada:**  
O problema é que a classe `Produto` provavelmente não sobrescreve `hashCode()` e `equals()`. Por padrão, a classe `Object` implementa `hashCode()` baseado no endereço de memória e `equals()` comparando referências. Quando você cria dois objetos `Produto` diferentes (mesmo com os mesmos dados), eles têm `hashCode` diferentes e não são considerados iguais.

O `HashMap` funciona assim:
1. Calcula o `hashCode()` da chave para encontrar o "bucket" (posição no array interno).
2. Dentro do bucket, usa `equals()` para encontrar a chave exata.

Se `hashCode()` não for sobrescrito, o mesmo produto em objetos diferentes vai para buckets diferentes, e o `get()` nunca encontra o anterior.

A solução é sobrescrever `hashCode()` e `equals()` na classe `Produto`, usando os mesmos campos relevantes (provavelmente `id`).

**Explicação didática:**  
Imagine que o `HashMap` é um arquivo com gavetas numeradas. Quando você insere um produto, o sistema calcula um número de gaveta usando `hashCode()`. Quando você busca o mesmo produto, precisa calcular o mesmo número de gaveta para encontrá-lo. Se você não sobrescreve `hashCode()`, cada objeto gera um número de gaveta aleatório (baseado no endereço de memória), então a busca olha em uma gaveta diferente daquela onde o produto foi guardado — e não encontra nada.

**Exemplo prático:**  
Um sistema de catálogo de produtos onde o cache armazena a descrição detalhada de cada produto para evitar consultas repetidas ao banco. Se a classe `Produto` não implementa `hashCode()`/`equals()`, o cache nunca funciona — toda busca retorna `null`, e o sistema consulta o banco repetidamente, causando lentidão.

**Exemplo de código:**  
```java
import java.util.HashMap;
import java.util.Objects;

// ❌ Sem hashCode/equals — HashMap não funciona corretamente
class ProdutoSemHash {
    private Long id;
    private String nome;
    
    public ProdutoSemHash(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    // Sem hashCode() e equals() sobrescritos
}

// Teste do problema
HashMap<ProdutoSemHash, String> cache = new HashMap<>();
ProdutoSemHash p1 = new ProdutoSemHash(1L, "Notebook");
cache.put(p1, "Notebook Dell 16GB RAM");

ProdutoSemHash p2 = new ProdutoSemHash(1L, "Notebook"); // Mesmos dados
cache.get(p2); // Retorna null! — objetos diferentes em memória

// ✅ Com hashCode/equals — HashMap funciona
class Produto {
    private Long id;
    private String nome;
    
    public Produto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// Teste da solução
HashMap<Produto, String> cacheCorreto = new HashMap<>();
Produto prod1 = new Produto(1L, "Notebook");
cacheCorreto.put(prod1, "Notebook Dell 16GB RAM");

Produto prod2 = new Produto(1L, "Notebook"); // Mesmo id
cacheCorreto.get(prod2); // Retorna "Notebook Dell 16GB RAM" ✅
```

**Como o candidato deve responder:**  
- Identificar que o problema está em `hashCode()` e `equals()` não sobrescritos.
- Explicar o funcionamento interno do `HashMap` (buckets + equals).
- Mostrar que dois objetos com mesmos dados não são considerados iguais sem os métodos.
- Propor a solução com `Objects.equals()` e `Objects.hash()`.
- Mencionar que objetos mutáveis usados como chave do HashMap podem causar problemas se seus campos usados no hashCode forem alterados após a inserção.
- Evitar dizer "o HashMap está com bug" ou "use `TreeMap`".

**Resposta fraca ou incompleta:**  
"O problema é que os objetos são diferentes." — Não explica por que são diferentes (referência de memória vs conteúdo), nem propõe a solução de sobrescrever `hashCode()` e `equals()`.

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
1. O que acontece se você usar um objeto mutável como chave do `HashMap` e alterar um campo após a inserção?
2. Por que é importante que `hashCode()` e `equals()` usem os mesmos campos?
3. Qual a diferença entre `HashMap`, `TreeMap` e `LinkedHashMap`?