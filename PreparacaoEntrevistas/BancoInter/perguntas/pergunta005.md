# Pergunta 5 — Imutabilidade e `final`

**Nível:** Júnior  
**Categoria:** Boas práticas de Java

**Pergunta do entrevistador:**  
O que significa dizer que um objeto é imutável em Java e quais benefícios isso traz?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende como reduzir efeitos colaterais e facilitar o uso seguro de objetos.

**Resposta esperada:**  
Um objeto imutável não pode ter seu estado alterado depois de criado.

Características comuns:

- Campos privados e `final`;
- Inicialização completa no construtor;
- Ausência de métodos que alterem o estado;
- Não exposição direta de estruturas mutáveis;
- Cópias defensivas quando necessário.

Benefícios:

- Maior previsibilidade;
- Segurança em cenários concorrentes;
- Facilidade para utilizar como chave;
- Menor quantidade de efeitos colaterais;
- Testes mais simples;
- Melhor legibilidade do código.

O modificador `final` em uma referência impede que a referência seja reatribuída, mas não torna automaticamente o objeto referenciado imutável.

**Explicação didática:**  
Neste exemplo, a referência não pode mudar, mas a lista ainda pode ser alterada:

~~~java
final List<String> nomes = new ArrayList<>();
nomes.add("Ana");
~~~

Portanto, `final` não é sinônimo de imutabilidade.

**Exemplo prático:**

~~~java
public record Endereco(String cidade, String estado) {
}
~~~

Um `record` é adequado para representar dados, desde que os componentes utilizados também sejam tratados corretamente. Se um componente for uma coleção mutável, ainda pode ser necessário protegê-lo.

**Como o candidato deve responder:**

- Defina imutabilidade;
- Diferencie `final` de objeto imutável;
- Cite benefícios em concorrência e manutenção;
- Mencione coleções mutáveis e cópias defensivas;
- Apresente um exemplo simples.

**Resposta fraca ou incompleta:**  
“Um objeto é imutável quando todos os seus campos são `final`.”

Isso não considera referências para objetos mutáveis nem exposição do estado interno.

**Critérios de avaliação:**

- **0** — Não entende imutabilidade.
- **1** — Confunde `final` com imutabilidade completa.
- **2** — Conhece parte do conceito, mas ignora coleções mutáveis.
- **3** — Explica corretamente o conceito básico.
- **4** — Relaciona imutabilidade à concorrência e à manutenibilidade.
- **5** — Discute cópias defensivas, objetos compostos, records e impacto em arquiteturas distribuídas.

**Perguntas de aprofundamento:**

1. Como tornaria uma classe que contém uma lista realmente imutável?
2. Por que objetos imutáveis ajudam em aplicações concorrentes?
3. Um `record` sempre garante imutabilidade profunda?

