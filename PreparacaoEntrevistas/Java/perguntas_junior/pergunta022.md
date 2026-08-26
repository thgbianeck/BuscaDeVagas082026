# Pergunta 22 — Optional como Alternativa a null

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você está desenvolvendo um método `buscarUsuarioPorId(Long id)` que consulta um banco de dados. O usuário pode existir ou não. Historicamente, o método retorna `null` quando não encontra o usuário, e vários pontos do sistema já quebraram com `NullPointerException` por esquecer de verificar o retorno. Como você redesenharia o contrato desse método usando `Optional`? Quais cuidados devem ser tomados ao usar `Optional`?

**O que essa pergunta avalia:**  
Conhecimento prático de `Optional` (Java 8+), compreensão de como ele força o tratamento de ausência, e capacidade de identificar boas práticas e armadilhas do seu uso.

**Resposta esperada:**  
Redesenhar o método para retornar `Optional<Usuario>` em vez de `Usuario`:

```java
public Optional<Usuario> buscarUsuarioPorId(Long id)
```

Isso faz com que o chamador seja **obrigado** a lidar com a possibilidade de ausência — não é possível chamar `.getNome()` diretamente em um `Optional`, é preciso "desembrulhar" o valor com `map()`, `orElse()`, `orElseThrow()`, etc.

**Boas práticas com `Optional`:**
1. **Usar como retorno de método**, nunca como campo de instância (atributo).
2. **Nunca usar `Optional.get()` sem verificar `isPresent()`** — prefira `map`, `orElse`, `orElseThrow`.
3. **Não usar para parâmetros de método** — use sobrecarga ou `@Nullable`.
4. **Usar `Optional.empty()` para ausência** e `Optional.of()` para valor garantido (não-null) ou `Optional.ofNullable()` se o valor pode ser null.

**Explicação didática:**  
Pense no `Optional` como uma caixa de presente. Quando você recebe uma caixa (Optional), precisa abri-la para ver o que tem dentro. Se a caixa estiver vazia, você precisa decidir o que fazer (usar um valor padrão, lançar erro, etc.). O ponto chave é que a caixa **lembra você** de verificar — diferente de um valor solto que pode ser `null` silenciosamente. É como receber um pacote com etiqueta "frágil" — você naturalmente tem mais cuidado.

**Exemplo prático:**  
Em uma API REST, o endpoint `GET /usuarios/{id}` precisa retornar 404 se o usuário não existir. Com `Optional`, o controller pode fazer:

```java
Usuario usuario = service.buscarUsuarioPorId(id)
    .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
```

**Exemplo de código:**  
```java
import java.util.Optional;

public class UsuarioService {
    
    // ✅ Retorna Optional — força o chamador a tratar ausência
    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        if (id == null || id <= 0) {
            return Optional.empty();
        }
        Usuario usuario = repository.findById(id);
        return Optional.ofNullable(usuario); // encapsula null de forma segura
    }
}

// Diferentes formas de consumir o Optional:

// 1. Valor padrão
String nome = service.buscarUsuarioPorId(id)
    .map(Usuario::getNome)
    .orElse("Usuário não encontrado");

// 2. Lançar exceção se ausente
Usuario usuario = service.buscarUsuarioPorId(id)
    .orElseThrow(() -> new NotFoundException("Usuário " + id + " não existe"));

// 3. Ação apenas se presente
service.buscarUsuarioPorId(id)
    .ifPresent(u -> System.out.println("Encontrado: " + u.getNome()));

// 4. Transformação encadeada
String email = service.buscarUsuarioPorId(id)
    .map(Usuario::getEmail)
    .filter(e -> e.endsWith("@empresa.com"))
    .orElse("e-mail corporativo não encontrado");

// ❌ ANTI-PADRÕES:
Optional<Usuario> opt = service.buscarUsuarioPorId(id);
if (opt.isPresent()) {
    Usuario u = opt.get(); // Funciona mas perde o propósito do Optional
}
// Melhor: usar map/orElse/ifPresent como acima

// ❌ Nunca usar como atributo
public class Cliente {
    private Optional<String> nome; // ERRADO! Usar String e tratar null
}
```

**Como o candidato deve responder:**  
- Propor retorno `Optional<Usuario>` para forçar o tratamento de ausência.
- Explicar que `Optional` é um "container" que pode ou não conter um valor.
- Demonstrar uso correto: `map`, `orElse`, `orElseThrow`, `ifPresent`.
- Mencionar as armadilhas: não usar como atributo, não usar `get()` sem `isPresent()`.
- Trazer o exemplo de API REST.
- Evitar sugerir `Optional` para parâmetros de método.

**Resposta fraca ou incompleta:**  
"Retornar `Optional` e usar `isPresent()` antes de `get()`." — Funciona mas não aproveita o estilo funcional do `Optional`. Não menciona `map`, `orElse`, nem as armadilhas de uso.

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
1. Por que `Optional` não deveria ser usado como campo de instância?
2. Qual a diferença entre `Optional.of()` e `Optional.ofNullable()`?
3. Como `Optional` interage com Streams API?

