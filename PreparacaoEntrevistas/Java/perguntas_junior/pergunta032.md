# Pergunta 32 — For-each vs For Tradicional com Índice

**Nível:** Júnior  
**Categoria:** Controle de Fluxo e Lógica

**Pergunta do entrevistador:**  
Em uma code review, você encontra um colega usando `for (int i = 0; i < lista.size(); i++)` para percorrer uma `List<String>`. Ele precisa apenas imprimir cada elemento, sem usar o índice para nada. Você sugere usar `for-each`. Ele pergunta: "Qual a diferença? O for tradicional não funciona?" Como você explicaria as vantagens do for-each e em quais situações o for tradicional ainda é necessário?

**O que essa pergunta avalia:**  
Capacidade de distinguir entre estruturas de iteração apropriadas, conhecimento de quando o for-each é superior e quando o for com índice é necessário, e compreensão de legibilidade de código.

**Resposta esperada:**  
O for tradicional **funciona**, mas o for-each é **preferível** quando não se precisa do índice, porque:

1. **Mais legível:** `for (String s : lista)` é mais claro que `for (int i = 0; i < lista.size(); i++) { String s = lista.get(i); }`.
2. **Menos propenso a erros:** não há risco de erro de off-by-one (`<=` vs `<`), nem de acessar índice errado.
3. **Funciona com qualquer `Iterable`:** o for-each funciona com `List`, `Set`, `Queue` e qualquer coleção que implemente `Iterable`. O for com índice só funciona com coleções que suportam acesso por índice (não funciona com `Set`).
4. **Não chama `size()` a cada iteração:** embora o JIT normalmente otimize isso, o for-each usa o iterator internamente, que é mais eficiente para algumas implementações de `List` (ex: `LinkedList`, onde `get(i)` é O(n)).

**Quando o for tradicional é necessário:**

- Precisa do índice (ex: para modificar o elemento na posição).
- Precisa iterar de trás para frente.
- Precisa pular elementos com base no índice.
- Precisa modificar a lista durante iteração (usando índices com cuidado).

**Explicação didática:**  
Imagine que você está lendo um livro. O for-each é como simplesmente virar as páginas uma a uma — você lê cada página sem se preocupar com o número. O for tradicional é como ler consultando o número de cada página: útil se você precisa saber em que página está ou pular páginas, mas desnecessário se só quer ler o conteúdo.

**Exemplo prático:**  
Em um sistema de listagem de produtos, o for-each é ideal para iterar e exibir cada produto. Mas se você precisa alterar o elemento na posição `i` da lista (ex: `lista.set(i, novoValor)`), o for com índice é necessário.

**Exemplo de código:**  

```java
import java.util.*;

public class IteracaoListas {
    
    // ✅ For-each — ideal quando não precisa do índice
    public void imprimirNomes(List<String> nomes) {
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
    
    // ✅ For-each também funciona com Set (for com índice NÃO funciona)
    public void imprimirSet(Set<String> nomes) {
        for (String nome : nomes) {
            System.out.println(nome);
        }
        // Set não tem get(i) — for tradicional não funciona!
    }
    
    // ⚠️ For tradicional — funciona mas é desnecessário aqui
    public void imprimirComIndiceDesnecessario(List<String> nomes) {
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i)); // get(i) em LinkedList é O(n)!
        }
    }
    
    // ✅ For tradicional — necessário quando se precisa do índice
    public void substituirElementos(List<String> nomes, String novoValor) {
        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i) == null) {
                nomes.set(i, novoValor); // Precisa do índice para set()
            }
        }
    }
    
    // ✅ For tradicional — iterar de trás para frente
    public void imprimirReverso(List<String> nomes) {
        for (int i = nomes.size() - 1; i >= 0; i--) {
            System.out.println(nomes.get(i));
        }
    }
    
    // ⚠️ Armadilha de performance com LinkedList
    public void demonstrarProblemaLinkedList() {
        // LinkedList: get(i) é O(n) — percorre do início a cada chamada
        LinkedList<String> lista = new LinkedList<>();
        lista.add("A"); lista.add("B"); lista.add("C");
        
        // ❌ O(n²) — cada get(i) percorre a lista desde o início
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i)); // O(n) por chamada!
        }
        
        // ✅ O(n) — for-each usa iterator, que caminha elemento a elemento
        for (String s : lista) {
            System.out.println(s); // O(1) por elemento
        }
    }
}
```

**Como o candidato deve responder:**  

- Explicar que o for-each é mais legível e menos propenso a erros.
- Mencionar que funciona com qualquer `Iterable` (incluindo `Set`).
- Explicar o problema de performance com `LinkedList` e `get(i)`.
- Identificar quando o for tradicional é necessário (índice, reverso, modificação).
- Trazer exemplo de quando cada um é adequado.
- Evitar dizer que o for tradicional é "errado" — é desnecessário quando não se precisa do índice.

**Resposta fraca ou incompleta:**  
"O for-each é mais fácil de ler." — Correto, mas não menciona que funciona com `Set`, não explica o problema de performance com `LinkedList`, nem quando o for tradicional é necessário.

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

1. Como o for-each funciona internamente? Qual interface ele usa?
2. Por que `LinkedList.get(i)` é O(n) e `ArrayList.get(i)` é O(1)?
3. É possível usar for-each com um array tradicional `int[]`?
