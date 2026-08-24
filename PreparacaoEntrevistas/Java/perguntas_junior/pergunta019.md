# Pergunta 19 — Java Streams API — Filtro e Mapeamento

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Você tem uma `List<Produto>` onde cada produto tem `categoria` (String), `preco` (double) e `ativo` (boolean). Precisa gerar uma lista com os nomes de todos os produtos ativos da categoria "Eletrônicos" com preço menor que `R$ 500,00`, ordenados pelo preço. Como você implementaria isso usando a Streams API e quais são as vantagens em relação ao loop tradicional?

**O que essa pergunta avalia:**  
Conhecimento prático da Streams API (filter, map, sorted, collect), compreensão de operações intermediárias vs terminais, e capacidade de comparar abordagem funcional com imperativa.

**Resposta esperada:**  
Usando a Streams API:
1. `stream()` — cria o stream a partir da lista.
2. `filter(p -> p.isAtivo())` — mantém apenas produtos ativos.
3. `filter(p -> "Eletrônicos".equals(p.getCategoria()))` — filtra por categoria.
4. `filter(p -> p.getPreco() < 500.0)` — filtra por preço.
5. `sorted(Comparator.comparing(Produto::getPreco))` — ordena por preço.
6. `map(Produto::getNome)` — extrai apenas o nome.
7. `collect(Collectors.toList())` — coleta em uma nova lista.

Vantagens sobre loop tradicional:
- **Declarativo:** descreve o "o quê" (filtrar, ordenar, mapear) em vez do "como" (índices, variáveis temporárias).
- **Legível:** a intenção do código é clara em uma cadeia de operações.
- **Componível:** operações podem ser combinadas e reutilizadas.
- **Paralelizável:** pode usar `parallelStream()` para processamento paralelo (embora deva ser usado com cuidado).

**Explicação didática:**  
Pense na Streams API como uma linha de montagem em uma fábrica. Cada produto passa por várias estações: a primeira remove os inativos, a segunda seleciona apenas eletrônicos, a terceira remove os caros, a quarta ordena, e a quinta pega apenas o nome. Você descreve o que cada estação faz, e a fábrica cuida do fluxo. Com loop tradicional, você seria um operador pegando cada produto, verificando tudo manualmente, colocando em uma pilha, depois ordenando a pilha — funciona, mas é mais trabalho e mais código.

**Exemplo prático:**  
Um e-commerce que precisa exibir uma vitrine filtrada: apenas eletrônicos ativos abaixo de `R$ 500`, ordenados do mais barato para o mais caro. A Streams API permite construir essa consulta de forma declarativa e legível.

**Exemplo de código:**  
```java
import java.util.*;
import java.util.stream.*;

class Produto {
    private String nome;
    private String categoria;
    private double preco;
    private boolean ativo;
    
    public Produto(String nome, String categoria, double preco, boolean ativo) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.ativo = ativo;
    }
    
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPreco() { return preco; }
    public boolean isAtivo() { return ativo; }
}

public class ExemploStream {
    public List<String> filtrarEletronicos(List<Produto> produtos) {
        return produtos.stream()
            // Operações intermediárias — lazy (só executam quando há terminal)
            .filter(Produto::isAtivo)                                    // ativos
            .filter(p -> "Eletrônicos".equals(p.getCategoria()))         // eletrônicos
            .filter(p -> p.getPreco() < 500.0)                           // abaixo de R$ 500
            .sorted(Comparator.comparing(Produto::getPreco))             // ordenar por preço
            .map(Produto::getNome)                                        // extrair nome
            // Operação terminal — dispara a execução
            .collect(Collectors.toList());                                // coletar em lista
    }
}

// ❌ Equivalente com loop tradicional — mais verboso
public List<String> filtrarEletronicosLoop(List<Produto> produtos) {
    List<Produto> filtrados = new ArrayList<>();
    for (Produto p : produtos) {
        if (p.isAtivo() 
            && "Eletrônicos".equals(p.getCategoria()) 
            && p.getPreco() < 500.0) {
            filtrados.add(p);
        }
    }
    
    filtrados.sort(Comparator.comparing(Produto::getPreco));
    
    List<String> nomes = new ArrayList<>();
    for (Produto p : filtrados) {
        nomes.add(p.getNome());
    }
    return nomes;
}

// Teste
List<Produto> produtos = Arrays.asList(
    new Produto("Mouse", "Eletrônicos", 50.0, true),
    new Produto("Teclado", "Eletrônicos", 150.0, true),
    new Produto("Monitor", "Eletrônicos", 800.0, true),   // > 500 — excluído
    new Produto("Cadeira", "Móveis", 300.0, true),         // categoria errada
    new Produto("Webcam", "Eletrônicos", 200.0, false),    // inativo
    new Produto("Fone", "Eletrônicos", 250.0, true)
);
// Resultado: ["Mouse", "Teclado", "Fone"] (ordenados por preço)
```

**Como o candidato deve responder:**  
- Escrever a cadeia de streams corretamente: filter → sorted → map → collect.
- Explicar a diferença entre operações intermediárias (lazy) e terminais (eager).
- Mencionar que `filter` recebe um `Predicate` e `map` recebe um `Function`.
- Comparar com o loop tradicional, destacando legibilidade e declaratividade.
- Evitar confundir `map` com `forEach` ou usar `collect` sem `Collectors`.

**Resposta fraca ou incompleta:**  
"Usaria um `for` e uns `if`s para filtrar." — Funciona, mas não usa a Streams API como solicitado, não aproveita o estilo declarativo, e não menciona as vantagens da abordagem funcional.

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
1. O que significa dizer que as operações intermediárias são "lazy"? Por que isso é importante?
2. Qual a diferença entre `map` e `flatMap` em streams?
3. Quando `parallelStream()` seria adequado e quando seria problemático?

