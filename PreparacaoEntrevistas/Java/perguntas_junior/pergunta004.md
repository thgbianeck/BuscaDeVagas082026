# Pergunta 4 — Uso de ArrayList vs Array

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Você precisa armazenar uma lista de nomes de funcionários de um departamento. O departamento pode contratar e demitir pessoas ao longo do tempo. Um colega sugere usar um array simples (`String[]`), outro sugere `ArrayList<String>`. Qual você escolheria e por quê? Que impactos práticos essa decisão traz?

**O que essa pergunta avalia:**  
Compreensão da diferença entre arrays e coleções dinâmicas, conhecimento das limitações dos arrays (tamanho fixo), e capacidade de escolher a estrutura de dados adequada para um cenário real.

**Resposta esperada:**  
A escolha correta é `ArrayList<String>`, pois o cenário exige uma estrutura dinâmica — o número de funcionários muda ao longo do tempo. Arrays em Java têm tamanho fixo após a criação: não é possível adicionar ou remover elementos dinamicamente sem criar um novo array e copiar os elementos. O `ArrayList` encapsula essa complexidade, crescendo e diminuindo automaticamente conforme elementos são adicionados ou removidos.

**Explicação didática:**  
Pense em um array como uma fileira de cadeiras numeradas em um teatro: você reserva 10 cadeiras, e se chegar a 11ª pessoa, não há cadeira — você precisaria realocar todo o teatro para uma sala maior. O `ArrayList` é como um auditório flexível: sempre que precisa, traz mais cadeiras automaticamente, e quando alguém sai, remove a cadeira sem deixar buracos.

**Exemplo prático:**  
Em um sistema de RH, o usuário cadastra um novo funcionário no departamento. Com `String[]`, seria necessário criar um novo array com tamanho `n+1`, copiar todos os elementos do array anterior e adicionar o novo. Com `ArrayList`, basta chamar `lista.add(nome)`.

**Exemplo de código:**  
```java
import java.util.ArrayList;
import java.util.List;

// ❌ Com array — gerenciamento manual de tamanho
String[] funcionarios = new String[3];
funcionarios[0] = "Ana";
funcionarios[1] = "Bruno";
funcionarios[2] = "Carla";
// Para adicionar "Daniel", é necessário criar um novo array
String[] novoArray = new String[4];
for (int i = 0; i < funcionarios.length; i++) {
    novoArray[i] = funcionarios[i];
}
novoArray[3] = "Daniel";
funcionarios = novoArray;

// ✅ Com ArrayList — adição e remoção são simples
List<String> listaFuncionarios = new ArrayList<>();
listaFuncionarios.add("Ana");
listaFuncionarios.add("Bruno");
listaFuncionarios.add("Carla");
listaFuncionarios.add("Daniel"); // Cresce automaticamente
listaFuncionarios.remove("Bruno"); // Remove facilmente
```

**Como o candidato deve responder:**  
- Identificar que o requisito chave é o tamanho dinâmico.
- Explicar que arrays têm tamanho fixo e `ArrayList` é dinâmico.
- Mencionar que `ArrayList` abstrai a complexidade de redimensionamento.
- Trazer o exemplo prático de adicionar/remover funcionários.
- Mencionar que arrays ainda são úteis quando o tamanho é conhecido e fixo.
- Evitar dizer que "ArrayList é sempre melhor" sem considerar o contexto.

**Resposta fraca ou incompleta:**  
"Usaria `ArrayList` porque é mais fácil." — Não explica por que é mais fácil, nem menciona a limitação de tamanho fixo dos arrays, nem o cenário de adicionar/remover funcionários.

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
1. Como o `ArrayList` aumenta de tamanho internamente quando atinge a capacidade máxima?
2. Quando faria sentido usar um array simples em vez de `ArrayList`?
3. Qual a diferença entre `ArrayList` e `LinkedList`? Em que cenário cada um seria mais adequado?
