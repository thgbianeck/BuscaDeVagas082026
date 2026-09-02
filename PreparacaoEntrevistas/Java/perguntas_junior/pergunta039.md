# Pergunta 39 — List vs Set: Escolhendo a Estrutura Correta

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Você está desenvolvendo um sistema de gerenciamento de tarefas. Em uma parte do sistema, você precisa armazenar as tags de uma tarefa (ex: "urgente", "frontend", "bug"). Em outra parte, precisa armazenar o histórico de alterações de uma tarefa, onde cada alteração deve ser preservada na ordem em que ocorreu, incluindo repetições (a tarefa pode ser alterada para "urgente" várias vezes ao longo do dia). Qual estrutura de dados você usaria em cada caso e por que?

**O que essa pergunta avalia:**  
Capacidade de escolher entre `List` e `Set` baseando-se nos requisitos do problema, compreensão das características de cada estrutura (ordem, duplicatas, performance), e raciocínio sobre trade-offs.

**Resposta esperada:**  
**Tags da tarefa:** Usar `Set<String>` (preferencialmente `LinkedHashSet` ou `HashSet`).
- Tags não devem ter duplicatas — não faz sentido ter "urgente" duas vezes.
- `Set` garante automaticamente que não há duplicatas.
- Se a ordem de exibição importar, usar `LinkedHashSet`.

**Histórico de alterações:** Usar `List<Alteracao>` (preferencialmente `ArrayList`).
- O histórico deve preservar a ordem cronológica.
- Duplicatas são válidas — a tarefa pode ser marcada como "urgente" várias vezes.
- `List` mantém ordem de inserção e permite elementos repetidos.

**Explicação didática:**  
Pense nas tags como categorias em um sistema de organização de documentos. Não faz sentido colar a etiqueta "urgente" duas vezes no mesmo documento — uma já é suficiente. O `Set` é como um carimbo que só marca uma vez cada categoria. Já o histórico é como um diário de bordo: você registra cada evento na ordem em que acontece, e o mesmo evento pode se repetir (a pessoa entrou, saiu, entrou de novo). O `List` é como um caderno onde cada página é uma entrada, em ordem, com repetições permitidas.

**Exemplo prático:**  
Em um sistema de tickets de suporte (ex: Jira), cada ticket tem tags (`Set`) para categorização, e um histórico de mudanças (`List`) que registra quem alterou, o quê, e quando. Se o ticket é marcado como "urgente", desmarcado, e marcado novamente, o histórico mostra todas as três ações em ordem.

**Exemplo de código:**  
```java
import java.util.*;

// Classe para representar uma alteração no histórico
class Alteracao {
    private String campo;
    private String valorAntigo;
    private String valorNovo;
    private Date timestamp;
    
    public Alteracao(String campo, String valorAntigo, 
                     String valorNovo) {
        this.campo = campo;
        this.valorAntigo = valorAntigo;
        this.valorNovo = valorNovo;
        this.timestamp = new Date();
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s: %s → %s", 
            timestamp, campo, valorAntigo, valorNovo);
    }
}

class Tarefa {
    private String titulo;
    
    // Tags — Set: sem duplicatas, não importa ordem
    private Set<String> tags = new HashSet<>();
    
    // Histórico — List: com ordem, permite repetições
    private List<Alteracao> historico = new ArrayList<>();
    
    public void adicionarTag(String tag) {
        // Set.add retorna false se a tag já existe — não duplica
        if (tags.add(tag)) {
            historico.add(new Alteracao("tag", null, tag));
        }
    }
    
    public void removerTag(String tag) {
        if (tags.remove(tag)) {
            historico.add(new Alteracao("tag", tag, null));
        }
    }
    
    public void alterarTitulo(String novoTitulo) {
        String tituloAntigo = this.titulo;
        this.titulo = novoTitulo;
        // Histórico sempre registra, mesmo se repetido
        historico.add(new Alteracao("titulo", tituloAntigo, novoTitulo));
    }
    
    public void imprimirResumo() {
        System.out.println("Tarefa: " + titulo);
        System.out.println("Tags: " + tags);
        System.out.println("Histórico:");
        for (Alteracao alt : historico) {
            System.out.println("  " + alt);
        }
    }
}

// Uso
Tarefa tarefa = new Tarefa();
tarefa.alterarTitulo("Corrigir bug de login");
tarefa.adicionarTag("urgente");
tarefa.adicionarTag("frontend");
tarefa.adicionarTag("urgente");  // Não duplica — Set ignora
tarefa.removerTag("urgente");
tarefa.adicionarTag("urgente");  // Re-adicionada — novo evento no histórico

tarefa.imprimirResumo();
// Tags: [frontend, urgente] — sem duplicatas
// Histórico: 5 entradas em ordem cronológica, incluindo repetições de "urgente"
```

**Como o candidato deve responder:**  
- Identificar que tags não devem ter duplicatas → `Set`.
- Identificar que histórico precisa de ordem e permite repetições → `List`.
- Justificar cada escolha com base nos requisitos.
- Mencionar que `Set.add()` retorna `boolean` indicando se adicionou.
- Trazer o exemplo de tickets de suporte (Jira).
- Evitar usar `List` para tags (requer verificação manual de duplicatas) ou `Set` para histórico (perde repetições).

**Resposta fraca ou incompleta:**  
"Usar `List` para os dois." — Funciona, mas para tags seria necessário verificar duplicatas manualmente (`if (!tags.contains(tag)) tags.add(tag)`), o que é O(n) por verificação. `Set` faz isso automaticamente em O(1).

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
1. Qual a diferença de performance entre `List.contains()` (O(n)) e `Set.contains()` (O(1))?
2. Quando faria sentido usar `LinkedHashSet` em vez de `HashSet` para as tags?
3. Qual a diferença entre `ArrayList` e `LinkedList` para armazenar o histórico?

