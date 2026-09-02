# Pergunta 37 — Map: getOrDefault e putIfAbsent

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Você está implementando um contador de palavras: recebe uma lista de palavras e precisa contar quantas vezes cada palavra aparece. Um colega escreveu o seguinte código:

```java
Map<String, Integer> contagem = new HashMap<>();
for (String palavra : palavras) {
    if (contagem.containsKey(palavra)) {
        contagem.put(palavra, contagem.get(palavra) + 1);
    } else {
        contagem.put(palavra, 1);
    }
}
```

Funciona, mas faz três acessos ao mapa (containsKey, get, put) por iteração. Como você simplificaria esse código usando métodos da API de `Map`?

**O que essa pergunta avalia:**  
Conhecimento dos métodos utilitários do `Map` (`getOrDefault`, `putIfAbsent`, `merge`, `compute`), e capacidade de refatorar código para ser mais conciso e eficiente.

**Resposta esperada:**  
Existem várias formas de simplificar:

**1. Usando `getOrDefault`:**
```java
contagem.put(palavra, contagem.getOrDefault(palavra, 0) + 1);
```
Um acesso ao mapa em vez de três. `getOrDefault` retorna o valor se a chave existe, ou o valor padrão (0) se não existe.

**2. Usando `merge` (mais elegante):**
```java
contagem.merge(palavra, 1, Integer::sum);
```
`merge` verifica se a chave existe: se não, insere com valor 1; se existe, aplica a função (`Integer::sum`) ao valor atual e ao novo valor (1).

**3. Usando `compute`:**
```java
contagem.compute(palavra, (k, v) -> v == null ? 1 : v + 1);
```
`compute` recebe a chave e uma função que recebe a chave e o valor atual (ou `null`), retornando o novo valor.

**Explicação didática:**  
O código original é como ir a um armário, verificar se há uma pasta, voltar para pegar a pasta, contar o que tem dentro, voltar para guardar de novo — três viagens. `getOrDefault` é como ir ao armário uma vez: se a pasta está lá, pega; se não, pega uma folha em branco. `merge` é ainda melhor: você diz "adicione 1 à pasta, ou crie uma nova com 1" — o armário faz tudo sozinho.

**Exemplo prático:**  
Um sistema de análise de logs que conta quantas vezes cada nível de log (INFO, WARN, ERROR) aparece em um arquivo. Cada linha é processada e o contador é incrementado. Com `merge`, o código fica de uma linha e é eficiente.

**Exemplo de código:**  
```java
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class ContadorPalavras {
    
    // ❌ Original — três acessos por iteração
    public Map<String, Integer> contarV1(List<String> palavras) {
        Map<String, Integer> contagem = new HashMap<>();
        for (String palavra : palavras) {
            if (contagem.containsKey(palavra)) {
                contagem.put(palavra, contagem.get(palavra) + 1);
            } else {
                contagem.put(palavra, 1);
            }
        }
        return contagem;
    }
    
    // ✅ getOrDefault — um acesso por iteração
    public Map<String, Integer> contarV2(List<String> palavras) {
        Map<String, Integer> contagem = new HashMap<>();
        for (String palavra : palavras) {
            contagem.put(palavra, contagem.getOrDefault(palavra, 0) + 1);
        }
        return contagem;
    }
    
    // ✅ merge — mais elegante e conciso
    public Map<String, Integer> contarV3(List<String> palavras) {
        Map<String, Integer> contagem = new HashMap<>();
        for (String palavra : palavras) {
            // Se chave não existe: insere (palavra, 1)
            // Se chave existe: aplica Integer::sum(valorAtual, 1)
            contagem.merge(palavra, 1, Integer::sum);
        }
        return contagem;
    }
    
    // ✅ Streams API — funcional e declarativo
    public Map<String, Integer> contarV4(List<String> palavras) {
        return palavras.stream()
            .collect(Collectors.groupingBy(
                Function.identity(),  // chave = a própria palavra
                Collectors.counting() // valor = contagem
            ));
    }
    
    // Demonstração
    public void demonstrar() {
        List<String> palavras = Arrays.asList(
            "java", "python", "java", "rust", "java", "python"
        );
        
        System.out.println(contarV3(palavras));
        // {python=2, java=3, rust=1}
    }
}
```

**Como o candidato deve responder:**  
- Identificar que o código original faz três acessos ao mapa por iteração.
- Propor `getOrDefault` como simplificação (um acesso).
- Propor `merge` como a solução mais elegante.
- Mencionar a alternativa com Streams (`groupingBy` + `counting`).
- Explicar o comportamento de `merge`: se chave não existe, insere; se existe, aplica a função.
- Trazer o exemplo de análise de logs.
- Evitar apenas dizer "use Streams" sem mostrar a alternativa com `Map.merge`.

**Resposta fraca ou incompleta:**  
"Usar Streams para contar." — Funciona, mas não responde à pergunta sobre simplificar o código com métodos de `Map`. Não mostra `getOrDefault` nem `merge`.

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
1. Qual a diferença entre `putIfAbsent` e `computeIfAbsent`?
2. O que `merge` faz quando a função retorna `null`?
3. Como `Collectors.groupingBy` funciona internamente?

