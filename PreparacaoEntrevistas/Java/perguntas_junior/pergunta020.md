# Pergunta 20 — Debugging: Stack Trace e Análise de Erros

**Nível:** Júnior  
**Categoria:** Boas Práticas e Debugging

**Pergunta do entrevistador:**  
Um usuário reporta que o sistema "parou de funcionar" ao tentar gerar um relatório. Você abre os logs e encontra a seguinte stack trace (simplificada):

```text {.line-numbers}
Exception in thread "main" java.lang.NullPointerException
    at com.empresa.relatorio.GeradorRelatorio.gerarLinha(GeradorRelatorio.java:45)
    at com.empresa.relatorio.GeradorRelatorio.gerar(GeradorRelatorio.java:28)
    at com.empresa.app.Main.processar(Main.java:15)
```

Como você lê essa stack trace? Por onde começaria a investigação e quais passos seguiria para encontrar e corrigir o problema?

**O que essa pergunta avalia:**  
Capacidade de ler e interpretar uma stack trace, identificar o ponto exato do erro, diferenciar causa raiz de efeito em cascata, e metodologia de debugging sistemática.

**Resposta esperada:**  
A leitura da stack trace é feita de cima para baixo, mas a investigação geralmente começa na **primeira linha** (onde a exceção ocorreu):

1. **Tipo da exceção:** `NullPointerException` — algo é `null` quando não deveria.
2. **Primeira linha (causa):** `GeradorRelatorio.gerarLinha()` na linha 45 — é onde o NPE foi disparado. Este é o ponto exato do problema.
3. **Segunda linha:** `GeradorRelatorio.gerar()` na linha 28 — chamou `gerarLinha()`, provavelmente em um loop.
4. **Terceira linha:** `Main.processar()` na linha 15 — ponto de entrada que chamou `gerar()`.

**Metodologia de investigação:**
1. Abrir `GeradorRelatorio.java` na linha 45 e ver qual variável/método está sendo acessado.
2. Identificar o que pode ser `null`: um parâmetro, um atributo, ou o retorno de um método.
3. Subir a stack trace para entender o contexto: quem chamou `gerarLinha()` e com quais argumentos.
4. Verificar se o dado que chega como parâmetro está correto ou se o problema está na origem (ex: consulta ao banco que retornou `null`).
5. Corrigir com tratamento defensivo (verificação de null, `Optional`, ou validação na origem).
6. Adicionar um teste que reproduza o cenário para garantir que não volte a ocorrer.

**Explicação didática:**  
Uma stack trace é como uma trilha de pegadas. A primeira linha (topo) é onde o crime aconteceu — onde a exceção foi lançada. As linhas seguintes mostram o caminho que levou até ali: quem chamou quem, em que ordem. Você começa investigando a cena do crime (linha 45) e, se precisar, segue a trilha para trás para entender como chegou até lá.

**Exemplo prático:**  
Na linha 45 de `GeradorRelatorio`, o código é `String cliente = pedido.getCliente().getNome();`. O `pedido.getCliente()` retorna `null` porque o pedido foi criado sem cliente vinculado (ex: pedido importado de um sistema legado). A correção envolve verificar se `getCliente()` é `null` antes de acessar `getNome()` e, idealmente, investigar por que o pedido foi criado sem cliente.

**Exemplo de código:**  
```java {.line-numbers}
// Arquivo: GeradorRelatorio.java
public class GeradorRelatorio {
    
    // Linha ~28: método gerar() chama gerarLinha() para cada pedido
    public String gerar(List<Pedido> pedidos) {
        StringBuilder sb = new StringBuilder();
        for (Pedido pedido : pedidos) {
            sb.append(gerarLinha(pedido));  // Linha 28 — chama gerarLinha
        }
        return sb.toString();
    }
    
    // Linha ~45: NPE ocorre aqui
    private String gerarLinha(Pedido pedido) {
        // Linha 45: getCliente() pode retornar null!
        String nomeCliente = pedido.getCliente().getNome(); // ← NPE AQUI
        
        return String.format("Pedido %d - Cliente: %s - Valor: R$ %.2f",
            pedido.getId(), nomeCliente, pedido.getValor());
    }
}

// ✅ Correção com tratamento defensivo
private String gerarLinha(Pedido pedido) {
    String nomeCliente = "Cliente não vinculado";
    if (pedido.getCliente() != null) {
        nomeCliente = pedido.getCliente().getNome();
    }
    
    return String.format("Pedido %d - Cliente: %s - Valor: R$ %.2f",
        pedido.getId(), nomeCliente, pedido.getValor());
}

// ✅ Correção com Optional (mais elegante)
private String gerarLinha(Pedido pedido) {
    String nomeCliente = Optional.ofNullable(pedido.getCliente())
        .map(Cliente::getNome)
        .orElse("Cliente não vinculado");
    
    return String.format("Pedido %d - Cliente: %s - Valor: R$ %.2f",
        pedido.getId(), nomeCliente, pedido.getValor());
}
```

**Como o candidato deve responder:**  
- Explicar que a primeira linha da stack trace é o ponto exato do erro.
- Identificar o tipo de exceção (`NullPointerException`).
- Descrever a metodologia: abrir o arquivo na linha indicada, inspecionar variáveis, subir a stack trace para contexto.
- Propor correção defensiva (verificação de null ou `Optional`).
- Mencionar a importância de reproduzir o bug com um teste.
- Evitar dizer "eu olharia o log" sem explicar como interpretar a stack trace.

**Resposta fraca ou incompleta:**  
"Olharia o erro e consertaria o bug." — Vago demais. Não explica como ler a stack trace, não identifica a primeira linha como ponto de início, nem descreve uma metodologia de investigação.

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
1. O que é uma "causa raiz" (root cause) e como diferenciar do sintoma?
2. Como você usaria breakpoints e debug step-by-step para investigar esse problema em uma IDE?
3. Que informações adicionais você gostaria de ter no log além da stack trace?

