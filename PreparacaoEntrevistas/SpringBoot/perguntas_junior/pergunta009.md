# Pergunta 9 — Como você valida dados de entrada em uma API Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em uma API REST, é importante validar os dados recebidos do cliente antes de processá-los. Como você faz validação de dados de entrada no Spring Boot?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o Bean Validation (Jakarta Validation), sabe usar `@Valid` nos controllers e as anotações de validação nas classes de modelo/DTO.

**Resposta esperada:**  
O Spring Boot suporta validação de dados através da **Bean Validation API** (Jakarta Validation, anteriormente javax.validation), integrada ao Spring MVC. O processo funciona em três partes:

1. **Anotações de validação no DTO/Modelo:**

```java
public class UsuarioRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @NotNull(message = "Idade é obrigatória")
    @Min(value = 18, message = "Idade deve ser no mínimo 18")
    @Max(value = 120, message = "Idade deve ser no máximo 120")
    private Integer idade;

    @Pattern(regexp = "^\\d{11}$", message = "CPF deve ter 11 dígitos")
    private String cpf;

    // getters e setters (ou Lombok)
}
```

2. **`@Valid` no controller:**

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody UsuarioRequestDTO dto) {
        // Se a validação falhar, o Spring lança MethodArgumentNotValidException
        // ANTES de chegar aqui
        Usuario usuario = usuarioService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}
```

3. **Tratamento dos erros de validação:**  

Quando a validação falha, o Spring lança `MethodArgumentNotValidException`. É preciso tratar essa exceção (geralmente em um `@ControllerAdvice`):

```java
@ControllerAdvice
public class ValidacaoExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidacao(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            erros.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }
}
```

**Principais anotações de validação:**

| Anotação | Descrição |
|----------|-----------|
| `@NotNull` | O valor não pode ser null |
| `@NotBlank` | A string não pode ser null, vazia ou apenas espaços |
| `@NotEmpty` | A string/collection não pode ser null ou vazia |
| `@Size` | Define tamanho mínimo e máximo |
| `@Min` / `@Max` | Define valor mínimo e máximo numérico |
| `@Email` | Valida formato de e-mail |
| `@Pattern` | Valida contra uma expressão regular |
| `@Past` / `@Future` | Valida se a data está no passado/futuro |

**Explicação didática:**  
As anotações de validação funcionam como "regras de segurança" em um aeroporto. O `@Valid` no controller é o detector de metais: ele verifica todos os "passageiros" (campos do DTO) antes de deixá-los entrar no método. Se algum passageiro não passar pela regra, ele é barrado e uma exceção é lançada antes do método ser executado.

**Como o candidato deve responder:**  

- Mencionar Bean Validation / Jakarta Validation.
- Explicar o uso de `@Valid` no parâmetro do controller.
- Citar pelo menos 3 anotações de validação (ex: `@NotBlank`, `@Email`, `@Size`).
- Explicar que a validação ocorre antes do método do controller ser executado.
- Mencionar a necessidade de tratar `MethodArgumentNotValidException`.

**Resposta fraca ou incompleta:**  
"Você valida com if-else no controller."  
Falta: não conhece Bean Validation, não usa `@Valid`, não menciona anotações de validação.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe como validar |
| 1 | Menciona validação manual com if |
| 2 | Conhece `@Valid` mas não cita anotações |
| 3 | Explica @Valid e anotações com exemplos |
| 4 | Demonstra prática com tratamento de MethodArgumentNotValidException |
| 5 | Responde com profundidade, menciona validation groups, validação customizada e DTO pattern |

**Perguntas de aprofundamento:**

1. "Como você criaria uma validação customizada (uma anotação de validação própria)?"
2. "O que são validation groups e quando usá-los?"
3. "Como validar objetos aninhados (um DTO dentro de outro)?"

