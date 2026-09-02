# Pergunta 40 — Variáveis Final e Efectivamente Final

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você tem o seguinte código:

```java
public void processar(List<String> nomes) {
    String prefixo = "Sr. ";
    nomes.forEach(nome -> System.out.println(prefixo + nome));
}
```

O código funciona, mas `prefixo` não está declarado como `final`. Um colega perguntou se deveria adicionar `final`. Outro colega disse que lambdas não podem acessar variáveis não-final. Esclareça: o que é uma variável "efetivamente final"? Por que lambdas exigem essa restrição? O que acontece se você tentar modificar `prefixo` dentro do lambda?

**O que essa pergunta avalia:**  
Compreensão do conceito de "efetivamente final" (effectively final), conhecimento das restrições de captura de variáveis em lambdas, e entendimento de por que essas restrições existem.

**Resposta esperada:**  
Uma variável é **efetivamente final** se seu valor nunca é alterado após a inicialização, mesmo sem a palavra-chave `final`. O compilador trata variáveis efetivamente finais como se fossem `final`, permitindo que sejam usadas em lambdas e classes anônimas.

**Por que lambdas exigem essa restrição?**
- Lambdas capturam o **valor** da variável no momento da criação, não a referência.
- Se a variável pudesse ser modificada depois, o lambda poderia usar um valor desatualizado, causando bugs difíceis de detectar.
- Em ambiente multi-thread, a variável capturada pode ser usada após o método ter terminado — se fosse mutável, não haveria garantia de visibilidade entre threads.

**O que acontece se tentar modificar `prefixo` dentro do lambda?**
- O código não compila. O compilador reporta: "Local variables referenced from a lambda expression must be final or effectively final."

**Por que adicionar `final` explicitamente?**
- Funciona sem `final` se a variável for efetivamente final.
- Mas adicionar `final` explicitamente é uma **boa prática** — documenta a intenção de que a variável não deve mudar, e o compilador detecta imediatamente se alguém tentar modificá-la.

**Explicação didática:**  
Imagine que um lambda é como uma fotografia tirada no momento em que é criado. A variável capturada é como o objeto na foto — o lambda "vê" o valor como era naquele instante. Se você pudesse modificar a variável depois, seria como tentar mudar o objeto depois que a foto foi tirada — a foto não mudaria, mas você teria duas versões diferentes da "verdade", causando confusão. A restrição garante que a foto e a realidade sempre correspondem.

**Exemplo prático:**  
Em um sistema de processamento de pedidos, um loop cria lambdas para processar cada pedido com um ID de lote. Se o ID do lote fosse mutável e modificado dentro do loop, todos os lambdas capturariam o mesmo ID (o último valor), processando todos os pedidos no lote errado.

**Exemplo de código:**  
```java
import java.util.*;

public class ExemploEffectivelyFinal {
    
    // ✅ Variável efetivamente final — funciona em lambda
    public void processarOk(List<String> nomes) {
        String prefixo = "Sr. ";  // Nunca modificada → efetivamente final
        nomes.forEach(nome -> System.out.println(prefixo + nome));
    }
    
    // ✅ Com final explícito — documenta a intenção
    public void processarComFinal(List<String> nomes) {
        final String prefixo = "Sr. ";
        nomes.forEach(nome -> System.out.println(prefixo + nome));
    }
    
    // ❌ NÃO é efetivamente final — não compila!
    public void processarErro(List<String> nomes) {
        String prefixo = "Sr. ";
        prefixo = "Sra. ";  // Modificada → não é efetivamente final
        // Erro de compilação: Local variables referenced from a lambda 
        // expression must be final or effectively final
        nomes.forEach(nome -> System.out.println(prefixo + nome));
    }
    
    // ❌ Tentar modificar dentro do lambda — não compila!
    public void processarModificandoNoLambda(List<String> nomes) {
        String prefixo = "Sr. ";
        nomes.forEach(nome -> {
            // prefixo = "Sra. "; // Erro de compilação!
            System.out.println(prefixo + nome);
        });
    }
    
    // ✅ Alternativa: usar variável effectively final nova
    public void processarComCondicao(List<String> nomes, boolean feminino) {
        // Cria nova variável que é efetivamente final
        String prefixo = feminino ? "Sra. " : "Sr. ";
        // prefixo nunca é modificado depois → efetivamente final
        nomes.forEach(nome -> System.out.println(prefixo + nome));
    }
    
    // ⚠️ Armadilha com loop — variável de iteração NÃO é efetivamente final
    public void armadilhaLoop() {
        for (int i = 0; i < 3; i++) {
            // i é modificada pelo for (i++) — não é efetivamente final!
            // Runnable r = () -> System.out.println(i); // Erro de compilação!
        }
        
        // ✅ Solução: criar cópia efetivamente final
        for (int i = 0; i < 3; i++) {
            final int copia = i;  // Nova variável, nunca modificada
            Runnable r = () -> System.out.println(copia); // Funciona!
            r.run();
        }
    }
    
    // ✅ Campos de instância NÃO precisam ser efetivamente final
    private String saudacao = "Olá";
    
    public void usarCampoInstancia(List<String> nomes) {
        // Campos de instância podem ser acessados e modificados
        // pois o lambda captura a referência ao objeto (this), não o valor
        nomes.forEach(nome -> System.out.println(saudacao + " " + nome));
        saudacao = "Oi"; // Pode modificar depois — campo não é local
    }
}
```

**Como o candidato deve responder:** 

- Definir "efetivamente final": valor nunca alterado após inicialização.
- Explicar que lambdas exigem variáveis final ou efetivamente finais.
- Justificar a restrição: captura por valor, consistência, thread-safety.
- Mostrar que tentar modificar dentro do lambda gera erro de compilação.
- Mencionar que adicionar `final` explicitamente é boa prática.
- Explicar a armadilha do loop com variável de iteração.
- Trazer o exemplo do processamento de pedidos com ID de lote.
- Evitar dizer que "lambdas não podem acessar variáveis externas" — podem, desde que sejam final/efetivamente final.

**Resposta fraca ou incompleta:**  
"Lambdas só acessam variáveis `final`." — Incorreto. Lambdas também acessam variáveis efetivamente finais (sem `final` explícito). Não explica o conceito nem a justificativa.

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

1. Por que campos de instância não precisam ser efetivamente finais?
2. O que acontece com a variável capturada após o método terminar?
3. Como o `var` (Java 10+) interage com o conceito de efetivamente final?

