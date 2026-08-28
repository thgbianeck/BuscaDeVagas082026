# Pergunta 7 — Como o Spring Boot trata exceções em uma API REST?

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
"Imagine que você tem uma API REST em Spring Boot e um dos endpoints lança uma exceção (por exemplo, um recurso não encontrado). Como o Spring Boot trata essa exceção por padrão e como você pode customizar o tratamento de erros?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o comportamento padrão de erro do Spring Boot, sabe usar `@ExceptionHandler` e `@ControllerAdvice`, e entende a importância de retornar respostas de erro padronizadas em APIs REST.

**Resposta esperada:**  

**Comportamento padrão:**  
O Spring Boot tem um mecanismo padrão de tratamento de erros que, quando uma exceção não tratada ocorre, retorna uma resposta HTTP com status **500 (Internal Server Error)** e um corpo JSON no formato:

```json
{
    "timestamp": "2024-01-15T10:30:00.000+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/api/usuarios/999"
}
```

**Customização com `@ExceptionHandler`:**  
Para tratar exceções específicas em um controller, usa-se `@ExceptionHandler`:

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

    // Trata exceção específica deste controller
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> handleNaoEncontrado(UsuarioNaoEncontradoException ex) {
        ErroDTO erro = new ErroDTO("NOT_FOUND", ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
```

**Customização global com `@ControllerAdvice`:**  
Para tratar exceções em **todos** os controllers da aplicação, usa-se `@ControllerAdvice`:

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> handleNaoEncontrado(UsuarioNaoEncontradoException ex) {
        ErroDTO erro = new ErroDTO("NOT_FOUND", "Usuário não encontrado", System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDTO> handleValidacao(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(e -> e.getField() + ": " + e.getDefaultMessage())
            .toList();
        ErroDTO erro = new ErroDTO("VALIDATION_ERROR", "Dados inválidos", erros);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroDTO> handleGenerico(Exception ex) {
        ErroDTO erro = new ErroDTO("INTERNAL_ERROR", "Erro interno do servidor", System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}
```

A classe `ErroDTO` seria um record ou classe simples:

```java
public record ErroDTO(String codigo, String mensagem, Object detalhes) {}
```

**Explicação didática:**  
Sem tratamento customizado, o Spring Boot retorna um erro genérico 500, que não é útil para o cliente da API. O `@ControllerAdvice` funciona como um "interceptador global": sempre que qualquer controller lançar uma exceção, o Spring Boot procura um método `@ExceptionHandler` correspondente no `@ControllerAdvice` e executa-o. É como ter um "segurança" na porta que sabe exatamente o que fazer com cada tipo de problema que aparece.

**Como o candidato deve responder:**  
- Mencionar o comportamento padrão (erro 500 com JSON padrão).
- Explicar `@ExceptionHandler` para tratamento por controller.
- Explicar `@ControllerAdvice` para tratamento global.
- Mostrar um exemplo prático com pelo menos uma exceção.
- Mencionar a importância de padronizar o formato de erro.

**Resposta fraca ou incompleta:**  
"Você usa try-catch no controller."  
Falta: não menciona `@ExceptionHandler` ou `@ControllerAdvice`, não entende o tratamento declarativo do Spring.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe como tratar exceções |
| 1 | Menciona try-catch mas não conhece as anotações do Spring |
| 2 | Conhece `@ExceptionHandler` mas não `@ControllerAdvice` |
| 3 | Explica ambos com exemplos e menciona o padrão de erro |
| 4 | Demonstra prática com múltiplos tipos de exceção e DTO de erro |
| 5 | Responde com profundidade, menciona ResponseEntityExceptionHandler, ordem de precedência e boas práticas |

**Perguntas de aprofundamento:**
1. "Como você padronizaria o formato de erro para todos os endpoints da API?"
2. "O que é o `ResponseEntityExceptionHandler` e como ele pode ajudar?"
3. "Como você garantiria que erros de validação do `@Valid` retornem mensagens úteis para o cliente?"

