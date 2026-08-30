# Pergunta 34 — toString() e Boas Práticas de Debug

**Nível:** Júnior  
**Categoria:** Boas Práticas

**Pergunta do entrevistador:**  
Você está debugando uma aplicação e imprime um objeto `Pedido` com `System.out.println(pedido)`, mas a saída é `Pedido@1b6d3586`. Por que isso acontece? Como você tornaria a saída mais útil para debug? O que aconteceria se essa classe fosse usada em logs de produção?

**O que essa pergunta avalia:**  
Compreensão do método `toString()` padrão de `Object`, conhecimento de como sobrescrevê-lo para debug, e entendimento do impacto em logging.

**Resposta esperada:**  
A saída `Pedido@1b6d3586` é o `toString()` padrão da classe `Object`, que retorna `NomeDaClasse@hashCodeHexadecimal`. Isso é inútil para debug, pois não mostra nenhum atributo do objeto.

A solução é sobrescrever `toString()` para retornar uma representação legível dos atributos principais. Em logs de produção, um `toString()` bem implementado permite identificar o objeto e seu estado sem precisar adicionar logs adicionais.

**Boas práticas:**
1. Incluir os atributos mais relevantes para identificação (ex: `id`, `status`, `valor`).
2. Não incluir dados sensíveis (senhas, tokens, dados pessoais como CPF).
3. Usar um formato consistente e legível.
4. Considerar usar ferramentas como Lombok (`@ToString`) ou o método `Objects.toString()`.

**Explicação didática:**  
Imagine que o `toString()` padrão é como um crachá que só tem o nome da empresa e um número de série — você sabe que é um "Funcionário #1234", mas não sabe o nome, cargo ou departamento. Sobrescrever `toString()` é como imprimir um crachá completo: nome, cargo, departamento e sala. Em uma emergência (debug), você consegue identificar a pessoa imediatamente sem precisar consultar outro sistema.

**Exemplo prático:**  
Em produção, um erro ocorre ao processar um pedido. O log contém `Processando pedido: Pedido@1b6d3586`. O desenvolvedor não sabe qual pedido causou o erro. Se o `toString()` fosse `Pedido{id=1234, status=ENVIADO, valor=250.0}`, o problema seria identificável imediatamente.

**Exemplo de código:**  
```java
import java.util.Objects;

// ❌ Sem toString() — saída inútil para debug
class PedidoSemToString {
    private Long id;
    private String status;
    private double valor;
    
    public PedidoSemToString(Long id, String status, double valor) {
        this.id = id;
        this.status = status;
        this.valor = valor;
    }
    // Saída: PedidoSemToString@1b6d3586 — inútil!
}

// ✅ Com toString() sobrescrito — saída útil
class Pedido {
    private Long id;
    private String cliente;
    private String status;
    private double valor;
    private String senha; // ⚠️ Dado sensível — NÃO incluir no toString
    
    public Pedido(Long id, String cliente, String status, 
                  double valor, String senha) {
        this.id = id;
        this.cliente = cliente;
        this.status = status;
        this.valor = valor;
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        return "Pedido{" +
            "id=" + id +
            ", cliente='" + cliente + '\'' +
            ", status='" + status + '\'' +
            ", valor=" + valor +
            // senha INTENCIONALMENTE omitida — não expor dados sensíveis
            '}';
    }
    // Saída: Pedido{id=1234, cliente='João', status='ENVIADO', valor=250.0}
}

// Uso
Pedido pedido = new Pedido(1234L, "João", "ENVIADO", 250.0, "minhaSenha123");
System.out.println(pedido);
// Saída: Pedido{id=1234, cliente='João', status='ENVIADO', valor=250.0}
// Senha não aparece! ✅

// Alternativa com String.format (mais limpo)
@Override
public String toString() {
    return String.format("Pedido[id=%d, cliente=%s, status=%s, valor=R$ %.2f]",
        id, cliente, status, valor);
}

// Alternativa com Objects.toString() (Java 7+)
@Override
public String toString() {
    return "Pedido{" +
        "id=" + Objects.toString(id, "null") +
        ", status=" + Objects.toString(status, "null") +
        ", valor=" + valor +
        "}";
}
```

**Como o candidato deve responder:**  
- Explicar que o `toString()` padrão retorna `Classe@hashCode`.
- Propor sobrescrita com atributos relevantes.
- Mencionar a importância de **não** incluir dados sensíveis.
- Explicar o impacto em logs de produção — facilita debug.
- Trazer o exemplo do pedido com senha omitida.
- Evitar apenas dizer "sobrescreva toString()" sem explicar o que incluir e o que omitir.

**Resposta fraca ou incompleta:**  
"Sobrescrever o `toString()`." — Não explica o que incluir, não menciona dados sensíveis, nem o impacto em logs.

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
1. Como o Lombok (`@ToString`) gera o `toString()` automaticamente? Que cuidado ele exige?
2. Por que incluir dados sensíveis no `toString()` é um risco de segurança?
3. Como o `toString()` interage com frameworks de logging como SLF4J?

