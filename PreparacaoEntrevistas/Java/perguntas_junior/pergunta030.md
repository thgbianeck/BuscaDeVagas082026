# Pergunta 30 — Convenções de Naming e Clean Code

**Nível:** Júnior  
**Categoria:** Boas Práticas

**Pergunta do entrevistador:**  
Em uma code review, você encontra o seguinte método em uma classe de serviço:

```java
public List<Object> proc(List<Object> d, boolean f) {
    List<Object> r = new ArrayList<>();
    for (Object o : d) {
        if (f) {
            if (o != null) {
                r.add(o);
            }
        } else {
            r.add(o);
        }
    }
    return r;
}
```

Quais problemas de legibilidade e design você identifica? Como você refatoraria esse código seguindo boas práticas de naming, clean code e uso de Generics?

**O que essa pergunta avalia:**  
Capacidade de identificar code smells (nomes ruins, uso de `Object`, lógica confusa), conhecimento de convenções de naming do Java, e habilidade de refatorar código para maior legibilidade e type safety.

**Resposta esperada:**  
**Problemas identificados:**
1. **Nomes não descritivos:** `proc`, `d`, `f`, `r`, `o` — não comunicam intenção.
2. **Uso de `Object`:** sem Generics, perde-se type safety e o chamador precisa fazer cast.
3. **Parâmetro booleano `f`:** não fica claro o que `true` ou `false` significa.
4. **Lógica confusa:** o `if (f)` no loop mistura comportamentos diferentes no mesmo método.
5. **Retorno `List<Object>`:** não diz nada sobre o conteúdo.
6. **Nomes não seguem convenções Java:** variáveis locais devem ser descritivas, não abreviações de uma letra.

**Refatoração:**
1. Renomear o método para comunicar a intenção: `filtrarNaoNulos` ou `removerNulos`.
2. Usar Generics: `List<T>` em vez de `List<Object>`.
3. Renomear parâmetros: `dados`, `ignorarNulos`.
4. Simplificar a lógica: se `ignorarNulos` é true, filtrar nulos; se false, retornar a lista como está.
5. Usar Streams API para maior legibilidade.

**Explicação didática:**  
Imagine que o código é uma receita culinária. A versão original é como uma receita escrita assim: "Pegue D, se F adicione O se O não for nada, senão adicione O. Retorne R." Você não sabe o que é D, F ou R. A versão refatorada é: "Pegue a lista de ingredientes. Se precisar remover os vazios, filtre-os. Caso contrário, retorne a lista completa." A receita se explica sozinha — você não precisa adivinhar nada.

**Exemplo prático:**  
Em um sistema de processamento de dados, um método recebe uma lista de registros e pode opcionalmente filtrar registros nulos (ex: em relatórios, nulos devem aparecer como "sem dado"; em importações, nulos devem ser removidos).

**Exemplo de código:**  
```java
import java.util.*;
import java.util.stream.Collectors;

// ❌ Código original — ilegível e sem type safety
public List<Object> proc(List<Object> d, boolean f) {
    List<Object> r = new ArrayList<>();
    for (Object o : d) {
        if (f) {
            if (o != null) {
                r.add(o);
            }
        } else {
            r.add(o);
        }
    }
    return r;
}

// ✅ Refatoração 1 — nomes descritivos e Generics
public <T> List<T> filtrarRemovendoNulos(List<T> elementos, 
                                           boolean removerNulos) {
    List<T> resultado = new ArrayList<>();
    for (T elemento : elementos) {
        if (!removerNulos || elemento != null) {
            resultado.add(elemento);
        }
    }
    return resultado;
}

// ✅ Refatoração 2 — separar em dois métodos (mais limpo)
public <T> List<T> removerNulos(List<T> elementos) {
    return elementos.stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
}

public <T> List<T> copiarLista(List<T> elementos) {
    return new ArrayList<>(elementos);
}

// ✅ Refatoração 3 — método único, Streams, com Optional no parâmetro
public <T> List<T> processarElementos(List<T> elementos, 
                                       boolean removerNulos) {
    if (elementos == null) {
        return Collections.emptyList();
    }
    
    if (!removerNulos) {
        return new ArrayList<>(elementos);
    }
    
    return elementos.stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
}

// Uso comparativo:
List<String> nomes = Arrays.asList("Ana", null, "Bruno", null, "Carla");

// ❌ Original — precisa de cast, nomes confusos
// List<Object> r = proc(nomes, true); // Quebra type safety

// ✅ Refatorado — type safe e legível
List<String> semNulos = filtrarRemovendoNulos(nomes, true);
// Resultado: ["Ana", "Bruno", "Carla"]

List<String> comNulos = filtrarRemovendoNulos(nomes, false);
// Resultado: ["Ana", null, "Bruno", null, "Carla"]
```

**Como o candidato deve responder:**  
- Listar os problemas: nomes não descritivos, uso de `Object`, parâmetro booleano ambíguo, lógica confusa.
- Propor renomeação: `proc` → `filtrarRemovendoNulos`, `d` → `elementos`, `f` → `removerNulos`.
- Introduzir Generics: `List<T>` em vez de `List<Object>`.
- Simplificar a lógica condicional.
- Mencionar a possibilidade de separar em dois métodos.
- Trazer o exemplo de processamento de registros.
- Evitar apenas dizer "renomear as variáveis" sem explicar por que e como.

**Resposta fraca ou incompleta:**  
"Renomear as variáveis para nomes mais claros." — Não menciona Generics, não identifica o problema do `Object`, não propõe refatoração da lógica, nem usa Streams.

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
1. Por que usar um parâmetro `boolean` é considerado um code smell (flag argument)?
2. O que é o princípio "Tell, Don't Ask" e como ele se aplica aqui?
3. Como o uso de Streams melhora ou piora a legibilidade neste caso?

