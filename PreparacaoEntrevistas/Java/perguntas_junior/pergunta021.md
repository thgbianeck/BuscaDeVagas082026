# Pergunta 21 — Generics: Type Safety em Coleções

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Em um projeto legado, você encontrou uma coleção declarada como `List` (raw type, sem generics). O código adiciona objetos de tipos diferentes na mesma lista: `String`, `Integer` e `Double`. Em um determinado ponto, o código faz um cast para `String` em todos os elementos e um `ClassCastException` é lançado em produção. Como os Generics poderiam ter evitado esse problema? Como você refatoraria esse código?

**O que essa pergunta avalia:**  
Compreensão do propósito dos Generics em Java, conhecimento de type safety em compile-time vs runtime, e capacidade de refatorar código legado para usar Generics corretamente.

**Resposta esperada:**  
Os Generics fornecem **type safety em compile-time**. Ao declarar `List<String>`, o compilador garante que apenas `String` possa ser adicionada à lista. Se alguém tentar adicionar um `Integer`, o código nem compila. Sem Generics (raw type `List`), o compilador aceita qualquer objeto, e os erros só aparecem em runtime como `ClassCastException`.

A refatoração envolve:

1. Identificar qual tipo de objeto a lista deveria conter (no caso, `String`).
2. Declarar a lista como `List<String>`.
3. Remover casts explícitos — o compilador já garante o tipo.
4. Corrigir os pontos onde tipos incompatíveis estavam sendo adicionados.

Se a lista realmente precisa conter tipos mistos (cenário raro), isso geralmente indica um problema de design — provavelmente deveria haver listas separadas ou uma classe wrapper que unifica os tipos.

**Explicação didática:**  
Imagine uma caixa de correio sem etiqueta (raw type). Qualquer um pode colocar qualquer coisa dentro: cartas, revistas, pacotes. Quando você vai pegar algo, não sabe o que é, e pode quebrar algo tentando usar como carta um pacote. Com Generics (`List<String>`), é como colocar uma etiqueta "Apenas Cartas" na caixa. O carteiro (compilador) recusa qualquer coisa que não seja carta antes mesmo de colocar na caixa.

**Exemplo prático:**  
Um sistema de notificações que armazena mensagens em uma lista. Sem Generics, um desenvolvedor acidentalmente adiciona um objeto `Usuario` na lista de mensagens. Quando o sistema tenta formatar cada item como `String`, o `ClassCastException` quebra o envio de notificações em produção.

**Exemplo de código:**  
```java
import java.util.*;

// ❌ Raw type — sem Generics, sem type safety
public class ProcessadorLegado {
    public void processarMensagens() {
        List mensagens = new ArrayList(); // Raw type
        mensagens.add("Bem-vindo!");
        mensagens.add("Pagamento confirmado");
        mensagens.add(42); // Integer adicionado sem erro de compilação!
        
        for (Object msg : mensagens) {
            String texto = (String) msg; // ClassCastException ao processar 42
            System.out.println(texto.toUpperCase());
        }
    }
}

// ✅ Com Generics — type safety em compile-time
public class ProcessadorGenerico {
    public void processarMensagens() {
        List<String> mensagens = new ArrayList<>();
        mensagens.add("Bem-vindo!");
        mensagens.add("Pagamento confirmado");
        // mensagens.add(42); // Erro de compilação! Não compila.
        
        for (String texto : mensagens) {
            // Sem cast — o compilador já sabe que é String
            System.out.println(texto.toUpperCase());
        }
    }
}

// ✅ Se realmente precisar de tipos mistos (revisar design!)
public class ProcessadorMisto {
    // Usar interface comum ou sealed type
    public void processar(List<Object> itens) {
        for (Object item : itens) {
            if (item instanceof String s) {
                System.out.println("Texto: " + s.toUpperCase());
            } else if (item instanceof Integer i) {
                System.out.println("Número: " + i);
            }
        }
    }
}
```

**Como o candidato deve responder:**  
- Explicar que Generics garantem type safety em compile-time.
- Mostrar que raw types aceitam qualquer objeto e erros só aparecem em runtime.
- Propor refatoração: tipar a lista como `List<String>` e remover casts.
- Mencionar que tipos mistos em uma lista geralmente indicam problema de design.
- Trazer o exemplo prático de notificações.
- Evitar dizer apenas "use Generics" sem explicar o porquê.

**Resposta fraca ou incompleta:**  
"Adicionar `<String>` na lista." — Correto mas superficial. Não explica como isso previne o `ClassCastException`, não menciona a diferença entre compile-time e runtime, nem propõe refatoração completa.

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
1. O que é "type erasure" em Java e como ele afeta os Generics em runtime?
2. Por que não é possível criar um array genérico como `new List<String>[10]`?
3. Qual a diferença entre `List`, `List<Object>` e `List<?>`?
