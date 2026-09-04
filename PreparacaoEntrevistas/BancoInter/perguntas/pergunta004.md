# Pergunta 4 — Collections e escolha da estrutura adequada

**Nível:** Júnior  
**Categoria:** Fundamentos e desempenho

**Pergunta do entrevistador:**  
Como você escolheria entre `List`, `Set` e `Map` em uma aplicação Java?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende as características básicas das principais estruturas de dados da linguagem.

**Resposta esperada:**  

- **`List`:** representa uma sequência de elementos e permite duplicidades. É adequada quando a ordem importa ou quando os itens são acessados como uma coleção ordenada;
- **`Set`:** representa um conjunto sem duplicidades, conforme os critérios de igualdade definidos pelos objetos;
- **`Map`:** associa chaves a valores e é adequada quando é necessário localizar um valor a partir de uma chave.

A implementação também importa:

- `ArrayList` é adequada para a maioria dos casos de lista;
- `HashSet` oferece busca baseada em hash, sem garantir ordem;
- `LinkedHashSet` preserva a ordem de inserção;
- `TreeSet` mantém ordenação conforme um comparador;
- `HashMap` oferece busca eficiente média por chave, sem ordem garantida;
- `ConcurrentHashMap` deve ser considerado em cenários concorrentes.

**Explicação didática:**  
A escolha não deve ser feita apenas pelo nome da interface. Deve considerar:

- Necessidade de ordenação;
- Duplicidade;
- Complexidade das operações;
- Concorrência;
- Volume de dados;
- Custo de memória.

Não é correto afirmar que uma coleção é sempre melhor que outra.

**Exemplo prático:**

~~~java
Map<Long, Pedido> pedidosPorId = pedidos.stream()
        .collect(Collectors.toMap(
                Pedido::id,
                Function.identity()
        ));
~~~

Esse mapa é útil quando o acesso mais frequente ocorre pelo identificador do pedido.

**Como o candidato deve responder:**

- Explique o propósito de cada abstração;
- Cite critérios de escolha;
- Relacione as implementações ao comportamento esperado;
- Considere ordenação e concorrência;
- Evite focar apenas em complexidade teórica.

**Resposta fraca ou incompleta:**  
“Eu sempre usaria `ArrayList`, porque é a coleção mais comum.”

Essa escolha ignora duplicidade, associação por chave, ordenação e concorrência.

**Critérios de avaliação:**

- **0** — Não diferencia as coleções.
- **1** — Apresenta conceitos incorretos.
- **2** — Conhece parcialmente `List`, `Set` e `Map`.
- **3** — Escolhe estruturas adequadas em casos simples.
- **4** — Considera ordem, duplicidade, busca e implementação.
- **5** — Discute complexidade, concorrência, memória e trade-offs de forma aplicada.

**Perguntas de aprofundamento:**

1. Quando utilizaria `LinkedHashMap`?
2. Por que um objeto mutável pode ser perigoso em um `HashSet`?
3. Qual seria o risco de usar `HashMap` em uma região acessada por várias threads?

