# Pergunta 31 — Autoboxing e Unboxing

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Em um sistema de pontuação de clientes, você tem o seguinte código:

```java
Integer pontos = 100;
pontos += 50;
```

Um colega perguntou se esse código funciona corretamente, já que `pontos` é um objeto `Integer` e não um `int`. Outro colega disse ter ouvido falar de um bug estranho ao comparar dois `Integer` com `==`. Explique o que é autoboxing/unboxing, como o código acima funciona internamente e qual é a "armadilha" da comparação com `==` em wrappers.

**O que essa pergunta avalia:**  
Compreensão de autoboxing e unboxing, conhecimento do cache de wrappers Integer (-128 a 127), e capacidade de identificar bugs sutis relacionados à comparação de objetos wrapper.

**Resposta esperada:**  
**Autoboxing** é a conversão automática de um tipo primitivo para seu wrapper correspondente (`int` → `Integer`). **Unboxing** é o inverso (`Integer` → `int`). O compilador insere essas conversões automaticamente.

No código `Integer pontos = 100; pontos += 50;`:
1. `Integer pontos = 100;` → autoboxing: `Integer.valueOf(100)` cria um objeto `Integer`.
2. `pontos += 50;` → unboxing: `pontos.intValue()` extrai o valor `int`, soma 50, e depois autoboxing novamente: `Integer.valueOf(150)`.

**A armadilha do `==`:**
Java mantém um **cache** de objetos `Integer` para valores entre **-128 e 127** (especificado na JLS). Quando você cria um `Integer` dentro desse range usando `Integer.valueOf()`, o Java retorna a **mesma referência** do cache. Isso significa que `==` funciona para valores nesse range, mas **falha** para valores fora dele.

```java
Integer a = 100; // No cache → mesma referência
Integer b = 100;
a == b; // true — funciona por acaso (cache)

Integer c = 200; // Fora do cache → referências diferentes
Integer d = 200;
c == d; // false — armadilha!
```

**Explicação didática:**  
Pense no cache de `Integer` como uma gaveta com números pré-impressos de -128 a 127. Quando você pede o número 100, o atendente pega a cartolina já pronta na gaveta. Se você pedir duas vezes, recebe a **mesma cartolina**. Mas se pedir o número 200, não tem na gaveta — o atendente imprime uma nova cada vez, então duas cópias do 200 são cartões **diferentes**, mesmo com o mesmo número. Comparar com `==` compara o cartão físico (referência), não o número escrito nele.

**Exemplo prático:**  
Em um sistema de fidelidade, dois clientes têm 150 pontos cada um. Se o sistema comparar os pontos com `==` em vez de `.equals()`, o sistema pode dizer que os pontos são diferentes mesmo sendo iguais, causando bugs onde bônus não são aplicados corretamente.

**Exemplo de código:**  
```java
public class AutoboxingDemo {
    public void demonstrar() {
        // Autoboxing: int → Integer automaticamente
        Integer a = 100;      // Equivale a Integer.valueOf(100)
        Integer b = 100;      // Mesmo valor no cache
        
        // Unboxing: Integer → int automaticamente
        int primitivo = a;    // Equivale a a.intValue()
        
        // Operação mista — unboxing + soma + autoboxing
        a += 50;              // a.intValue() + 50 → Integer.valueOf(150)
        
        // ⚠️ Armadilha do ==
        System.out.println(a == b);           // true (ambos 100 no cache)
        
        Integer c = 200;     // Fora do cache (-128 a 127)
        Integer d = 200;
        System.out.println(c == d);           // false! Referências diferentes
        System.out.println(c.equals(d));      // true ✅ — compara conteúdo
        
        // Em coleções — autoboxing implícito
        List<Integer> lista = new ArrayList<>();
        lista.add(10);       // autoboxing: int 10 → Integer.valueOf(10)
        int valor = lista.get(0);  // unboxing: Integer → int
        
        // ⚠️ Armadilha em loop — muitos objetos criados
        Integer soma = 0;
        for (int i = 0; i < 1000; i++) {
            soma += i;       // A cada iteração: unboxing + soma + autoboxing
        }
        // Cria ~1000 objetos Integer desnecessariamente!
        // Melhor: usar int primitivo
        int somaPrimitiva = 0;
        for (int i = 0; i < 1000; i++) {
            somaPrimitiva += i;  // Sem autoboxing — mais eficiente
        }
    }
    
    // ✅ Boa prática: comparar wrappers com .equals()
    public boolean mesmosPontos(Integer p1, Integer p2) {
        if (p1 == null || p2 == null) return false;
        return p1.equals(p2);  // Sempre correto, independente do cache
    }
}
```

**Como o candidato deve responder:**  
- Explicar autoboxing (primitivo → wrapper) e unboxing (wrapper → primitivo) como conversões automáticas.
- Mostrar que `+=` faz unboxing, soma e re-autoboxing.
- Explicar o cache de Integer (-128 a 127) e por que `==` funciona nesse range.
- Mostrar que `==` falha para valores fora do range — sempre usar `.equals()`.
- Mencionar o impacto de performance de autoboxing em loops.
- Trazer o exemplo do sistema de fidelidade.
- Evitar dizer que "Integer é a mesma coisa que int".

**Resposta fraca ou incompleta:**  
"`Integer` é um objeto e `int` é primitivo, o Java converte automaticamente." — Não explica o cache, não menciona a armadilha do `==`, nem o impacto de performance em loops.

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
1. Por que o Java mantém esse cache de Integer — qual é a justificativa de design?
2. Outros wrappers (`Double`, `Float`) têm cache? Por que não?
3. Como o autoboxing pode causar `NullPointerException`?

