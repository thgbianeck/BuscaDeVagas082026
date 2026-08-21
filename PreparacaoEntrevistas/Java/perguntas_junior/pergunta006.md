# Pergunta 6 — Loops e Estruturas de Controle

**Nível:** Júnior  
**Categoria:** Controle de Fluxo e Lógica

**Pergunta do entrevistador:**  
Você precisa processar uma lista de pedidos e aplicar um desconto de 10% apenas nos pedidos com valor acima de `R$ 100,00`. Além disso, precisa parar o processamento se encontrar um pedido marcado como "cancelado". Como você implementaria essa lógica e qual estrutura de repetição escolheria?

**O que essa pergunta avalia:**  
Conhecimento de estruturas de controle (`for`, `for-each`, `while`), capacidade de combinar condicionais com loops, uso de `break` e `continue`, e raciocínio lógico aplicado a um cenário de negócio.

**Resposta esperada:**  
A estrutura mais adequada é o `for-each` (enhanced for), pois a iteração é sobre uma coleção de pedidos sem necessidade de índice. Dentro do loop:
1. Verificar se o pedido está cancelado — se sim, usar `break` para interromper o loop.
2. Verificar se o valor do pedido é maior que `R$ 100,00` — se sim, aplicar o desconto.
3. Pedidos com valor menor que `R$ 100,00` devem ser pulados com `continue` (se não houver outra ação) ou simplesmente não receber o desconto (se outras ações forem necessárias).

**Explicação didática:**  
Imagine que você é um inspetor de qualidade em uma linha de montagem. Você olha cada produto (pedido) que passa pela esteira (loop for-each). Se encontrar um produto com etiqueta "cancelado", você desliga a esteira (`break`). Se o produto custa menos de `R$ 100`, você não aplica o selo de desconto, mas deixa o produto seguir (`continue` ou apenas não aplica). Se custa mais de `R$ 100`, você coloca o selo de desconto.

**Exemplo prático:**  
Um sistema de e-commerce processa pedidos em lote antes do envio. O desconto promocional deve ser aplicado automaticamente, mas se houver um pedido cancelado no lote, o processamento deve parar para investigação manual.

**Exemplo de código:**  
```java
import java.util.List;

public class ProcessadorDePedidos {
    
    public void processarPedidos(List<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            // Se encontrar um pedido cancelado, interrompe o processamento
            if (pedido.isCancelado()) {
                System.out.println("Pedido cancelado encontrado: " + pedido.getId());
                break;
            }
            
            // Aplica desconto apenas para pedidos acima de R$ 100
            if (pedido.getValor() > 100.0) {
                double valorComDesconto = pedido.getValor() * 0.90;
                pedido.setValor(valorComDesconto);
                System.out.println("Desconto aplicado ao pedido " + pedido.getId());
            }
            // Pedidos abaixo de R$ 100 continuam sem desconto
        }
    }
}

class Pedido {
    private Long id;
    private double valor;
    private boolean cancelado;
    
    // Getters e setters omitidos para brevidade
    public Long getId() { return id; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public boolean isCancelado() { return cancelado; }
}
```

**Como o candidato deve responder:**  
- Escolher `for-each` e justificar (iteração sobre coleção sem necessidade de índice).
- Explicar o uso de `break` para parar ao encontrar pedido cancelado.
- Explicar a condicional para aplicar o desconto.
- Mencionar que `continue` seria útil se houvesse outras operações no loop que devessem ser puladas.
- Trazer o exemplo prático do processamento de pedidos.
- Evitar usar `while` sem justificar, ou usar índices desnecessários com `for` tradicional.

**Resposta fraca ou incompleta:**  
"Usaria um `for` para percorrer a lista e um `if` para aplicar o desconto." — Não menciona o `break` para o pedido cancelado, não justifica a escolha do tipo de loop, nem considera o cenário de interrupção.

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
1. Qual a diferença entre `break` e `continue`? Dê um exemplo de uso de cada um.
2. Como você faria se precisasse pular os pedidos cancelados em vez de parar o processamento?
3. Em quais situações o `while` seria mais adequado que o `for`?