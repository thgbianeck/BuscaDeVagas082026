# Pergunta 2 — Igualdade entre objetos em Java

**Nível:** Júnior  
**Categoria:** Java e coleções

**Pergunta do entrevistador:**  
Qual é a diferença entre `==` e `equals()` em Java e por que o método `hashCode()` também é importante?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre comparação de referências, igualdade lógica e funcionamento de coleções baseadas em hash.

**Resposta esperada:**  
Para objetos, o operador `==` normalmente verifica se duas variáveis apontam para a mesma referência na memória.

O método `equals()` deve representar a igualdade lógica definida pela classe. Por exemplo, dois objetos `Cliente` podem ser considerados iguais quando possuem o mesmo identificador.

Quando `equals()` é sobrescrito, `hashCode()` também deve ser sobrescrito. O contrato determina que objetos considerados iguais devem possuir o mesmo hash code.

Isso é importante para estruturas como:

- `HashMap`;
- `HashSet`;
- `ConcurrentHashMap`.

Se o contrato for violado, o objeto pode não ser encontrado corretamente na coleção.

**Explicação didática:**  
Duas instâncias diferentes podem representar o mesmo valor lógico:

~~~java
Cliente primeiro = new Cliente(10L);
Cliente segundo = new Cliente(10L);
~~~

Nesse caso, `primeiro == segundo` será falso, pois são objetos diferentes. Porém, `equals()` pode retornar verdadeiro caso o identificador seja o critério de igualdade.

Classes imutáveis, como alguns tipos de valor, são mais fáceis de utilizar corretamente em coleções.

**Exemplo prático:**

~~~java
public final class Cliente {

    private final Long id;

    public Cliente(Long id) {
        this.id = Objects.requireNonNull(id);
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Cliente outro)) {
            return false;
        }

        return id.equals(outro.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
~~~

**Como o candidato deve responder:**

- Explique a diferença entre referência e igualdade lógica;
- Relacione `equals()` e `hashCode()`;
- Cite coleções que dependem desses métodos;
- Mencione cuidado com objetos mutáveis usados como chave;
- Evite afirmar que `==` sempre compara valores.

**Resposta fraca ou incompleta:**  
“`==` e `equals()` fazem a mesma coisa, mas `equals()` é mais moderno.”

A resposta não demonstra compreensão sobre referências, igualdade lógica e coleções.

**Critérios de avaliação:**

- **0** — Não conhece a diferença.
- **1** — Confunde referências e valores.
- **2** — Conhece `equals()`, mas ignora `hashCode()`.
- **3** — Explica corretamente os três conceitos.
- **4** — Relaciona o tema às coleções e apresenta exemplos.
- **5** — Discute imutabilidade, contrato de igualdade, herança e riscos de alterar chaves após inserção.

**Perguntas de aprofundamento:**

1. O que pode acontecer se `equals()` for sobrescrito sem `hashCode()`?
2. Por que não é recomendado alterar uma chave enquanto ela está em um `HashMap`?
3. Como definiria igualdade para uma entidade de banco de dados?

