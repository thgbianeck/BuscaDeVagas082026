# Pergunta 38 — Switch Statement: Boas Práticas e Fall-through

**Nível:** Júnior  
**Categoria:** Controle de Fluxo e Lógica

**Pergunta do entrevistador:**  
Um colega escreveu um método que processa o status de um pedido usando `switch`, mas esqueceu alguns `break` e o código executou casos errados (fall-through). Ele também não incluiu um `default`. Como você explicaria o comportamento de fall-through em `switch`? Como reescreveria o código para ser seguro? O que mudou com o switch expression (Java 14+)?

**O que essa pergunta avalia:**  
Compreensão do comportamento fall-through do `switch` tradicional, conhecimento de boas práticas (sempre usar `break` ou `default`), e familiaridade com switch expression (Java 14+).

**Resposta esperada:**  
**Fall-through:** No `switch` tradicional, se um `case` não tem `break`, a execução "cai" para o próximo `case`, executando seu código mesmo que o valor não corresponda. Isso é um comportamento herdado do C/C++ que é frequente fonte de bugs.

**Boas práticas:**
1. Sempre usar `break` no final de cada `case` (a menos que o fall-through seja intencional e documentado).
2. Sempre incluir `default` para tratar valores inesperados.
3. Considerar usar `if-else` ou polimorfismo (enums com métodos) quando há muitos casos.

**Switch Expression (Java 14+):**
- Sem fall-through — cada `case` é uma expressão que retorna valor.
- Sintaxe mais concisa com `->` em vez de `:`.
- Não precisa de `break`.
- O compilador verifica se todos os casos são cobertos (ex: todos os valores de um enum).

**Explicação didática:**  
O `switch` tradicional é como um edifício com vários andares e escadas abertas entre eles. Se você entra no andar 2 e não fecha a porta (`break`), você desce a escada e acaba entrando no andar 3, 4, etc. O switch expression é como um edifício com portas automáticas: você entra no andar certo, faz o que precisa, e a porta se fecha sozinha — sem risco de cair para outro andar.

**Exemplo prático:**  
Um sistema que aplica descontos baseados no status do cliente: VIP recebe 20%, OURO 15%, PRATA 10%. Com fall-through acidental, um cliente PRATA poderia receber 20% de desconto (executando todos os casos acumulados).

**Exemplo de código:**  
```java
// ❌ Switch tradicional com fall-through acidental
public double calcularDescontoFallThrough(String status, double valor) {
    double desconto = 0;
    switch (status) {
        case "VIP":
            desconto = 0.20;
            // ESQUECEU O break! — cai para o próximo caso
        case "OURO":
            desconto = 0.15;
            // ESQUECEU O break! — cai para o próximo caso
        case "PRATA":
            desconto = 0.10;
            // ESQUECEU O break!
        default:
            desconto = 0.0;
    }
    // Um cliente VIP recebe 0% de desconto! (fall-through até default)
    return valor * desconto;
}

// ✅ Switch tradicional corrigido — com break e default
public double calcularDescontoCorreto(String status, double valor) {
    double desconto;
    switch (status) {
        case "VIP":
            desconto = 0.20;
            break;  // ✅ break evita fall-through
        case "OURO":
            desconto = 0.15;
            break;
        case "PRATA":
            desconto = 0.10;
            break;
        default:
            desconto = 0.0;
            // break opcional no default, mas recomendado por consistência
    }
    return valor * desconto;
}

// ✅ Switch expression (Java 14+) — sem fall-through, retorna valor
public double calcularDescontoExpression(String status, double valor) {
    double desconto = switch (status) {
        case "VIP" -> 0.20;
        case "OURO" -> 0.15;
        case "PRATA" -> 0.10;
        default -> 0.0;
    };
    return valor * desconto;
}

// ✅ Switch expression com enum — compilador verifica exaustividade
public enum StatusCliente {
    VIP, OURO, PRATA
}

public double calcularDescontoEnum(StatusCliente status, double valor) {
    double desconto = switch (status) {
        case VIP -> 0.20;
        case OURO -> 0.15;
        case PRATA -> 0.10;
        // Sem default! Compilador verifica que todos os casos são cobertos
    };
    return valor * desconto;
}

// ✅ Switch expression com bloco (quando precisa de lógica)
public String processarPedido(StatusPedido status) {
    return switch (status) {
        case AGUARDANDO_PAGAMENTO -> "Aguardando confirmação de pagamento";
        case PAGAMENTO_CONFIRMADO -> {
            System.out.println("Notificando cliente...");
            yield "Pedido confirmado e em preparação";
        }
        case ENVIADO -> "Pedido a caminho";
        case ENTREGUE -> "Pedido entregue com sucesso";
        case CANCELADO -> "Pedido cancelado";
    };
}
```

**Como o candidato deve responder:**  
- Explicar o fall-through: sem `break`, a execução continua nos próximos cases.
- Mostrar que esquecer `break` causa bugs difíceis de detectar.
- Sempre incluir `default` para tratar valores inesperados.
- Mencionar switch expression (Java 14+) como alternativa sem fall-through.
- Mostrar que switch expression com enum verifica exaustividade.
- Trazer o exemplo de descontos por status de cliente.
- Evitar dizer que `switch` é sempre ruim — com as práticas corretas é útil.

**Resposta fraca ou incompleta:**  
"Adicionar `break` em cada `case`." — Correto, mas não explica o porquê do fall-through, não menciona `default`, nem o switch expression.

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
1. Em quais situações o fall-through é intencional e útil?
2. Qual a diferença entre `yield` e `return` dentro de um switch expression?
3. Por que usar enums no switch é mais seguro que usar Strings?

