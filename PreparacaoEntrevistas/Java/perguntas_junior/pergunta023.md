# Pergunta 23 — Comparable e Comparator

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Você tem uma lista de objetos `Pedido` que precisam ser ordenados. Às vezes o usuário quer ordenar por data, outras vezes por valor total, e outras por nome do cliente. Como você implementaria essa ordenação flexível? Qual a diferença entre `Comparable` e `Comparator` e quando usar cada um?

**O que essa pergunta avalia:**  
Conhecimento das interfaces `Comparable` e `Comparator`, compreensão de ordenação natural vs ordenação customizada, e capacidade de implementar múltiplos critérios de ordenação.

**Resposta esperada:**  
- **`Comparable`** define a ordenação **natural** da classe — implementa o método `compareTo(T)` dentro da própria classe. Útil quando há uma ordenação padrão óbvia (ex: `Pedido` por data). Só pode haver uma implementação.
- **`Comparator`** define ordenação **externa** e **alternativa** — implementa o método `compare(T, T)` em uma classe separada ou via lambda. Permite múltiplos critérios de ordenação sem alterar a classe original.

Para o cenário descrito, a melhor abordagem é:
1. Implementar `Comparable<Pedido>` com a ordenação natural (ex: por data).
2. Criar `Comparator<Pedido>` separados para ordenação por valor e por nome do cliente.
3. Usar `Comparator.comparing()` (Java 8+) para criar comparators de forma concisa.

**Explicação didática:**  
`Comparable` é como o RG da pessoa — define uma identidade única de comparação que não muda. Uma pessoa sempre é comparada pelo CPF, por exemplo. `Comparator` é como os diferentes critérios de ordem em uma fila: às vezes você ordena por altura, às vezes por idade, às vezes por ordem alfabética. A pessoa não muda, mas o critério de comparação sim.

**Exemplo prático:**  
Em um painel de pedidos de e-commerce, o usuário pode clicar nas colunas da tabela para ordenar por data, valor ou cliente. Cada clique troca o `Comparator` aplicado à lista.

**Exemplo de código:**  
```java
import java.util.*;
import java.util.Comparator;

class Pedido implements Comparable<Pedido> {
    private Long id;
    private String nomeCliente;
    private double valor;
    private Date data;
    
    // Construtor e getters omitidos para brevidade
    public Long getId() { return id; }
    public String getNomeCliente() { return nomeCliente; }
    public double getValor() { return valor; }
    public Date getData() { return data; }
    
    // Ordenação natural — por data (Comparable)
    @Override
    public int compareTo(Pedido outro) {
        return this.data.compareTo(outro.data);
    }
}

public class ExemploOrdenacao {
    
    public void ordenarPedidos(List<Pedido> pedidos, String criterio) {
        switch (criterio) {
            case "data":
                // Usa ordenação natural (Comparable)
                Collections.sort(pedidos);
                break;
                
            case "valor":
                // Comparator por valor — lambda (Java 8+)
                pedidos.sort(Comparator.comparingDouble(Pedido::getValor));
                break;
                
            case "cliente":
                // Comparator por nome — method reference
                pedidos.sort(Comparator.comparing(Pedido::getNomeCliente));
                break;
                
            case "valorDecrescente":
                // Comparator reverso
                pedidos.sort(Comparator.comparingDouble(Pedido::getValor).reversed());
                break;
                
            case "clienteEValor":
                // Composição — primeiro por cliente, depois por valor
                pedidos.sort(
                    Comparator.comparing(Pedido::getNomeCliente)
                              .thenComparingDouble(Pedido::getValor)
                );
                break;
        }
    }
}

// Comparator como classe separada (útil quando a lógica é complexa)
class PedidoPorValorComparator implements Comparator<Pedido> {
    @Override
    public int compare(Pedido p1, Pedido p2) {
        return Double.compare(p1.getValor(), p2.getValor());
        // Double.compare lida corretamente com NaN e valores especiais
    }
}

// Uso:
List<Pedido> pedidos = new ArrayList<>();
// ... adicionar pedidos ...
pedidos.sort(new PedidoPorValorComparator());
// ou
pedidos.sort(Comparator.comparingDouble(Pedido::getValor));
```

**Como o candidato deve responder:**  
- Explicar que `Comparable` define ordenação natural (uma só, dentro da classe).
- Explicar que `Comparator` permite múltiplos critérios (externos à classe).
- Usar `Comparator.comparing()` para criar comparators de forma concisa.
- Mencionar `reversed()` para ordem decrescente e `thenComparing()` para critérios compostos.
- Trazer o exemplo do painel de pedidos.
- Evitar implementar `Comparable` para cada critério diferente (não é possível).

**Resposta fraca ou incompleta:**  
"Implementar `Comparable` para ordenar." — Só permite uma ordenação. Não diferencia `Comparable` de `Comparator`, nem mostra como ter múltiplos critérios.

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
1. O que acontece se você usar `p1.getValor() - p2.getValor()` em vez de `Double.compare()`?
2. Como criar um `Comparator` que ordena por nulls primeiro ou por nulls último?
3. Qual a diferença entre `Collections.sort()` e `List.sort()`?

