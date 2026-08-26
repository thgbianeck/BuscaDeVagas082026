# Pergunta 24 — Enums com Atributos e Métodos

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você está modelando os status de um pedido em um e-commerce: `AGUARDANDO_PAGAMENTO`, `PAGAMENTO_CONFIRMADO`, `ENVIADO`, `ENTREGUE`, `CANCELADO`. Cada status precisa ter uma descrição amigável para o usuário (ex: "Aguardando Pagamento") e um método que indica se o pedido pode ser cancelado a partir daquele status. Como você implementaria isso com `enum`?

**O que essa pergunta avalia:**  
Conhecimento de enums em Java, capacidade de adicionar atributos, construtores e métodos em enums, e compreensão de como enums podem encapsular lógica de negócio.

**Resposta esperada:**  
Enums em Java são mais poderosos que em outras linguagens — podem ter atributos, construtores, métodos e até implementar interfaces. Cada constante do enum pode ter seu próprio comportamento sobrescrevendo métodos.

Para o cenário:
1. Criar um `enum StatusPedido` com as constantes.
2. Adicionar um atributo `descricao` (String) e um construtor.
3. Adicionar um método `podeCancelar()` que retorna `true` apenas para os status onde o cancelamento é permitido.
4. Opcionalmente, sobrescrever o método por constante (constant-specific class body) para lógica mais complexa.

**Explicação didática:**  
Pense no enum como um grupo de botões em um painel. Cada botão tem um rótulo (descrição) e um comportamento específico quando pressionado. O botão "Aguardando Pagamento" permite cancelar, mas o botão "Entregue" não. O enum organiza esses botões em um único lugar, garantindo que não existam status inválidos — é como ter um controle remoto com botões fixos, onde ninguém pode inventar um botão novo.

**Exemplo prático:**  
Em um sistema de e-commerce, quando o usuário clica em "Cancelar Pedido", o sistema verifica `pedido.getStatus().podeCancelar()`. Se o pedido já foi entregue, o botão de cancelar pode ser desabilitado na interface com base nesse método.

**Exemplo de código:**  
```java
public enum StatusPedido {
    // Constantes com atributos
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    PAGAMENTO_CONFIRMADO("Pagamento Confirmado"),
    ENVIADO("Enviado"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");
    
    private final String descricao;
    
    // Construtor do enum — sempre private (implícito)
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    // Lógica de negócio encapsulada no enum
    public boolean podeCancelar() {
        // Só pode cancelar antes do envio
        return this == AGUARDANDO_PAGAMENTO || this == PAGAMENTO_CONFIRMADO;
    }
    
    // Lógica: o pedido já foi finalizado?
    public boolean isFinalizado() {
        return this == ENTREGUE || this == CANCELADO;
    }
}

// Uso prático
public class Pedido {
    private StatusPedido status = StatusPedido.AGUARDANDO_PAGAMENTO;
    
    public void cancelar() {
        if (!status.podeCancelar()) {
            throw new IllegalStateException(
                "Não é possível cancelar um pedido com status: " + status.getDescricao()
            );
        }
        this.status = StatusPedido.CANCELADO;
    }
    
    public void confirmarPagamento() {
        if (status != StatusPedido.AGUARDANDO_PAGAMENTO) {
            throw new IllegalStateException(
                "Pagamento só pode ser confirmado se estiver aguardando pagamento"
            );
        }
        this.status = StatusPedido.PAGAMENTO_CONFIRMADO;
    }
    
    public StatusPedido getStatus() { return status; }
}

// Teste
Pedido pedido = new Pedido();
System.out.println(pedido.getStatus().getDescricao()); // "Aguardando Pagamento"
System.out.println(pedido.getStatus().podeCancelar()); // true
pedido.confirmarPagamento();
System.out.println(pedido.getStatus().podeCancelar()); // true (ainda pode)
// Simular envio... status = ENVIADO
// pedido.getStatus().podeCancelar() → false
```

**Abordagem avançada — sobrescrita por constante:**
```java
public enum StatusPedido {
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento") {
        @Override
        public boolean podeCancelar() { return true; }
    },
    ENVIADO("Enviado") {
        @Override
        public boolean podeCancelar() { return false; }
    },
    // ... outras constantes
    ;
    
    private final String descricao;
    
    StatusPedido(String descricao) { this.descricao = descricao; }
    public String getDescricao() { return descricao; }
    
    // Método padrão — pode ser sobrescrito por constante
    public boolean podeCancelar() { return false; }
}
```

**Como o candidato deve responder:**  
- Explicar que enums em Java podem ter atributos, construtores e métodos.
- Implementar `descricao` como atributo com construtor.
- Implementar `podeCancelar()` com lógica baseada no status.
- Mencionar a opção de sobrescrita por constante para lógica mais complexa.
- Trazer o exemplo do botão "Cancelar Pedido" na interface.
- Evitar usar constantes `int` ou `String` mágicas em vez de enum.

**Resposta fraca ou incompleta:**  
"Criar um enum com os status e um `if` para verificar se pode cancelar." — Não menciona atributos, construtores, nem encapsula a lógica dentro do enum. A lógica fica espalhada no código em vez de centralizada.

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
1. Por que o construtor de um enum é sempre private? Pode ser protected?
2. Como iterar sobre todos os valores de um enum?
3. É possível fazer `switch` com enums? Que vantagens isso traz?

