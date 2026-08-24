# Pergunta 17 — Iteração e Remoção em Coleções

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Você tem uma `List<Pedido>` e precisa remover todos os pedidos com status "CANCELADO" enquanto itera sobre a lista. Um colega escreveu o código com um `for-each` e chamou `lista.remove(pedido)` dentro do loop, mas recebeu um `ConcurrentModificationException`. Por que isso acontece e quais são as formas corretas de resolver?

**O que essa pergunta avalia:**  
Compreensão do `ConcurrentModificationException`, conhecimento do mecanismo fail-fast das coleções Java, e capacidade de propor soluções corretas para remoção durante iteração.

**Resposta esperada:**  
O `ConcurrentModificationException` ocorre porque o `for-each` usa um iterator interno que mantém um contador de modificações (modCount). Quando o loop detecta que a lista foi modificada (remoção) por fora do iterator, ele lança a exceção — é um mecanismo fail-fast para evitar comportamento indefinido.

Soluções corretas:

**1. Usar `Iterator.remove()`:**  
O `Iterator` tem um método `remove()` que remove o elemento atual de forma segura, sincronizando o modCount.

**2. Usar `removeIf()` (Java 8+):**  
Método da interface `Collection` que aceita um `Predicate` e remove todos os elementos que satisfazem a condição.

**3. Criar uma nova lista filtrada:**  
Em vez de remover, criar uma nova lista apenas com os elementos que devem permanecer — abordagem imutável e mais segura.

**Explicação didática:**  
Imagine que você é um inspetor caminhando por uma esteira de produtos, verificando cada um. O sistema (iterator) conta quantos produtos existem na esteira. Se você tenta tirar um produto da esteira com a mão (sem avisar o sistema), o sistema percebe que a contagem mudou e dispara um alarme (`ConcurrentModificationException`). Para remover com segurança, você precisa usar o botão de remoção do próprio sistema (`iterator.remove()`), que atualiza a contagem junto.

**Exemplo prático:**  
Um sistema de processamento de pedidos que precisa limpar pedidos cancelados antes de gerar um relatório. Se tentar remover durante a iteração com `for-each`, o sistema quebra. Usando `removeIf()` ou `Iterator.remove()`, a limpeza é feita com segurança.

**Exemplo de código:**  
```java
import java.util.*;

class Pedido {
    private String status;
    public String getStatus() { return status; }
    public Pedido(String status) { this.status = status; }
}

List<Pedido> pedidos = new ArrayList<>();
pedidos.add(new Pedido("CONFIRMADO"));
pedidos.add(new Pedido("CANCELADO"));
pedidos.add(new Pedido("ENVIADO"));
pedidos.add(new Pedido("CANCELADO"));

// ❌ Causa ConcurrentModificationException
for (Pedido p : pedidos) {
    if ("CANCELADO".equals(p.getStatus())) {
        pedidos.remove(p); // Modificação direta — iterator detecta
    }
}

// ✅ Solução 1: Iterator.remove()
Iterator<Pedido> iterator = pedidos.iterator();
while (iterator.hasNext()) {
    Pedido p = iterator.next();
    if ("CANCELADO".equals(p.getStatus())) {
        iterator.remove(); // Remoção segura via iterator
    }
}

// ✅ Solução 2: removeIf() — mais conciso (Java 8+)
pedidos.removeIf(p -> "CANCELADO".equals(p.getStatus()));

// ✅ Solução 3: Criar nova lista filtrada — abordagem imutável
List<Pedido> pedidosAtivos = pedidos.stream()
    .filter(p -> !"CANCELADO".equals(p.getStatus()))
    .collect(Collectors.toList());
// Lista original permanece intacta, nova lista só com ativos
```

**Como o candidato deve responder:**  
- Explicar que o `for-each` usa um iterator interno que detecta modificações externas.
- Mencionar o mecanismo fail-fast e o `modCount`.
- Propor `Iterator.remove()` como solução clássica.
- Propor `removeIf()` como solução moderna e concisa.
- Mencionar a alternativa de criar nova lista filtrada (abordagem funcional).
- Trazer exemplo prático.
- Evitar sugerir `for` com índice e `remove(i)` sem mencionar o ajuste do índice.

**Resposta fraca ou incompleta:**  
"Usar um `for` com índice e remover pelo índice." — Funciona, mas é propenso a erro de índice (`IndexOutOfBoundsException` se não ajustar `i--` após remover). Não explica por que o `for-each` falha nem menciona `Iterator.remove()` ou `removeIf()`.

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
1. O que é o mecanismo fail-fast e por que ele existe?
2. `CopyOnWriteArrayList` lança `ConcurrentModificationException`? Por quê?
3. Qual a diferença entre `removeIf()` e `stream().filter().collect()` em termos de mutação da lista original?

