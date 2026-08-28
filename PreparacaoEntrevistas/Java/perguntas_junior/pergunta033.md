# Pergunta 33 — Set: Eliminando Duplicatas

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Em um sistema de importação de contatos, você recebe uma lista com milhares de e-mails, mas há muitos duplicados. Você precisa gerar uma lista sem duplicatas mantendo a ordem de chegada. Um colega sugere usar `Set`, mas ele usou `HashSet` e os e-mails saíram em ordem aleatória. Qual `Set` você usaria para manter a ordem de inserção? E se a ordem precisasse ser alfabética?

**O que essa pergunta avalia:**  

Conhecimento das diferentes implementações de `Set` (`HashSet`, `LinkedHashSet`, `TreeSet`), compreensão de quando cada uma é adequada, e capacidade de resolver um problema real de eliminação de duplicatas.

**Resposta esperada:**  

- **`HashSet`**: não mantém ordem — mais rápido (O(1) para add/contains), mas iteração em ordem imprevisível.
- **`LinkedHashSet`**: mantém a ordem de inserção — praticamente tão rápido quanto `HashSet`, mas usa uma lista encadeada interna para preservar a ordem.
- **`TreeSet`**: mantém ordem natural (alfabética para `String`) ou ordem definida por `Comparator` — um pouco mais lento (O(log n)) pois usa uma árvore rubro-negra internamente.

Para o cenário:

1. **Manter ordem de chegada:** `LinkedHashSet`.
2. **Ordem alfabética:** `TreeSet` (ou converter para lista e ordenar com `Collections.sort()`).

**Explicação didática:**  

Imagine três formas de organizar cartas de baralho:
- `HashSet`: você joga as cartas em uma mesa sem nenhuma ordem — pega rápido, mas quando olha, estão espalhadas aleatoriamente.
- `LinkedHashSet`: você coloca as cartas em uma fila, na ordem em que chegam — pega rápido e mantém a ordem de chegada.
- `TreeSet`: você coloca as cartas em um fichário alfabético — demora um pouco mais para colocar cada uma, mas sempre estão ordenadas quando você olha.

**Exemplo prático:**  
Um sistema de newsletter importa contatos de múltiplas fontes (CRM, planilha, API). Os e-mails chegam em uma ordem específica por prioridade da fonte. É necessário eliminar duplicatas preservando a prioridade de chegada — o primeiro e-mail duplicado a chegar é o que fica.

**Exemplo de código:**  

```java
import java.util.*;

public class DeduplicadorEmails {
    
    // ✅ Manter ordem de inserção — LinkedHashSet
    public List<String> removerDuplicatasOrdemInsercao(List<String> emails) {
        // LinkedHashSet: remove duplicatas e preserva ordem de chegada
        Set<String> set = new LinkedHashSet<>(emails);
        return new ArrayList<>(set);
    }
    
    // ✅ Ordem alfabética — TreeSet
    public List<String> removerDuplicatasOrdemAlfabetica(List<String> emails) {
        // TreeSet: remove duplicatas e mantém ordem natural (alfabética)
        Set<String> set = new TreeSet<>(emails);
        return new ArrayList<>(set);
    }
    
    // ✅ Ordem alfabética case-insensitive
    public List<String> removerDuplicatasCaseInsensitive(List<String> emails) {
        // TreeSet com comparator customizado
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(emails);
        return new ArrayList<>(set);
    }
    
    // Comparação visual
    public void demonstrar() {
        List<String> emails = Arrays.asList(
            "carlos@email.com",
            "ana@email.com",
            "carlos@email.com",  // duplicata
            "bruno@email.com",
            "ana@email.com"      // duplicata
        );
        
        System.out.println("Original: " + emails);
        // [carlos, ana, carlos, bruno, ana]
        
        System.out.println("HashSet: " + new HashSet<>(emails));
        // Ordem imprevisível, ex: [bruno, ana, carlos]
        
        System.out.println("LinkedHashSet: " + new LinkedHashSet<>(emails));
        // Mantém ordem: [carlos, ana, bruno]
        
        System.out.println("TreeSet: " + new TreeSet<>(emails));
        // Ordem alfabética: [ana, bruno, carlos]
    }
}

// Uso prático
List<String> importados = Arrays.asList(
    "joao@empresa.com",
    "maria@empresa.com",
    "joao@empresa.com",   // duplicata
    "pedro@empresa.com",
    "maria@empresa.com"   // duplicata
);

DeduplicadorEmails deduplicador = new DeduplicadorEmails();
List<String> unicos = deduplicador.removerDuplicatasOrdemInsercao(importados);
// Resultado: [joao, maria, pedro] — ordem de chegada preservada
```

**Como o candidato deve responder:**  

- Identificar que `HashSet` não mantém ordem.
- Propor `LinkedHashSet` para manter ordem de inserção.
- Propor `TreeSet` para ordem alfabética.
- Explicar as diferenças de performance: HashSet/LinkedHashSet O(1), TreeSet O(log n).
- Trazer o exemplo de importação de contatos.
- Mencionar o cuidado com case-insensitive (joao@ e JOAO@ seriam duplicatas?).
- Evitar sugerir verificar duplicatas manualmente com `lista.contains()` — é O(n) por verificação.

**Resposta fraca ou incompleta:**  

"Usar `Set` para remover duplicatas." — Não especifica qual `Set`, não diferencia as implementações, não menciona ordem.

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

1. Qual a estrutura interna do `HashSet`? Como ele usa o `hashCode`?
2. Qual a estrutura interna do `TreeSet`? Por que é O(log n)?
3. Como o `LinkedHashSet` mantém a ordem de inserção sem perder performance?

