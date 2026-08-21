# Pergunta 9 — Manipulação de Strings e StringBuilder

**Nível:** Júnior  
**Categoria:** Manipulação de Strings e Datas

**Pergunta do entrevistador:**  
Em um relatório, você precisa concatenar milhares de linhas de texto geradas a partir de dados de clientes. Um colega escreveu o código usando `String resultado = ""; resultado += linha;` dentro de um loop. O sistema ficou lento ao processar relatórios grandes. O que está acontecendo e como você resolveria?

**O que essa pergunta avalia:**  
Compreensão da imutabilidade de `String` em Java, conhecimento do impacto de performance da concatenação em loops, e uso de `StringBuilder` como alternativa eficiente.

**Resposta esperada:**  
Em Java, objetos `String` são **imutáveis** — cada operação de concatenação (`+=`) cria um novo objeto `String` e copia todo o conteúdo anterior para o novo objeto. Em um loop de milhares de iterações, isso significa que cada concatenação copia uma string cada vez maior, resultando em complexidade O(n²) — o número de cópias cresce quadraticamente.

A solução é usar `StringBuilder`, que é uma sequência mutável de caracteres. Internamente, ela mantém um buffer que cresce conforme necessário, e as concatenações são feitas modificando esse buffer em vez de criar novos objetos. A complexidade cai para O(n).

**Explicação didática:**  
Imagine que você está escrevendo um livro à mão. Com `String`, cada vez que você quer adicionar uma palavra, você reescreve o livro inteiro do zero, do início, com a nova palavra no final. Com `StringBuilder`, você simplesmente continua escrevendo na mesma página, que cresce conforme necessário. Para uma frase, a diferença é imperceptível. Para um livro de mil páginas, uma abordagem leva segundos e a outra levaria horas.

**Exemplo prático:**  
Um sistema de geração de relatório em PDF que concatena linhas de texto de 10.000 clientes. Com `+=`, o sistema cria 10.000 novos objetos String, copiando em média 5.000 caracteres a cada iteração — mais de 50 milhões de caracteres copiados. Com `StringBuilder`, o buffer cresce dinamicamente e as concatenações são apenas acréscimos.

**Exemplo de código:**  
```java
// ❌ Lento — String é imutável, cada += cria novo objeto
public String gerarRelatorioLento(List<Cliente> clientes) {
    String resultado = "";
    for (Cliente cliente : clientes) {
        resultado += cliente.getNome() + " - " + cliente.getEmail() + "\n";
        // Cada += cria uma nova String copiando todo o conteúdo anterior
    }
    return resultado;
}

// ✅ Rápido — StringBuilder é mutável, concatena no mesmo buffer
public String gerarRelatorioRapido(List<Cliente> clientes) {
    StringBuilder sb = new StringBuilder();
    for (Cliente cliente : clientes) {
        sb.append(cliente.getNome())
          .append(" - ")
          .append(cliente.getEmail())
          .append("\n");
        // append() apenas adiciona ao buffer existente
    }
    return sb.toString();
}

// Dica: se souber o tamanho aproximado, pré-alocar o buffer
public String gerarRelatorioOtimizado(List<Cliente> clientes) {
    // Estimativa: ~50 caracteres por cliente
    StringBuilder sb = new StringBuilder(clientes.size() * 50);
    for (Cliente cliente : clientes) {
        sb.append(cliente.getNome())
          .append(" - ")
          .append(cliente.getEmail())
          .append("\n");
    }
    return sb.toString();
}
```

**Como o candidato deve responder:**  
- Identificar que `String` é imutável e `+=` cria novos objetos.
- Explicar o impacto de performance: complexidade O(n²) vs O(n).
- Propor `StringBuilder` como solução.
- Mencionar a possibilidade de pré-alocar o buffer com tamanho estimado.
- Trazer o exemplo do relatório com milhares de linhas.
- Evitar dizer apenas "use StringBuilder" sem explicar por que String é lenta.

**Resposta fraca ou incompleta:**  
"Usaria `StringBuilder` porque é mais rápido." — Não explica o porquê (imutabilidade de String), não menciona o problema de criar novos objetos a cada concatenação, nem a diferença de complexidade.

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
1. Em quais situações a concatenação com `+` é aceitável?
2. Qual a diferença entre `StringBuffer` e `StringBuilder`?
3. O que é o String Pool e como ele afeta a criação de Strings?