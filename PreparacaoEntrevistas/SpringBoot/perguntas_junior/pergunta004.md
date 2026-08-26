# Pergunta 4 — Qual a diferença entre @Controller e @RestController?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, quando você cria endpoints, pode usar `@Controller` ou `@RestController`. Qual é a diferença entre eles e quando você usaria cada um?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende a diferença entre controllers tradicionais (que retornam views/nomes de templates) e REST controllers (que retornam dados serializados), e se sabe que `@RestController` é uma anotação composta.

**Resposta esperada:**  
A diferença principal está no comportamento do retorno dos métodos:

**`@Controller`** — é uma especialização de `@Component` usada tradicionalmente em aplicações web que retornam **views** (páginas HTML, templates Thymeleaf, JSP). O valor retornado pelo método é interpretado como o **nome de uma view** que será resolvida por um `ViewResolver`. Para retornar dados (JSON/XML) com `@Controller`, é necessário adicionar `@ResponseBody` em cada método.

**`@RestController`** — é uma anotação composta que combina `@Controller` + `@ResponseBody`. Com ela, **todos os métodos** da classe têm `@ResponseBody` implícito, ou seja, o valor retornado é serializado diretamente para o corpo da resposta HTTP (geralmente JSON), sem passar por um `ViewResolver`.

**Quando usar cada um:**
- `@Controller` — aplicações web tradicionais com server-side rendering (Thymeleaf, FreeMarker, JSP).
- `@RestController` — APIs REST que retornam JSON, XML ou outros formatos de dados.

**Explicação didática:**  
Imagine que `@Controller` é como um garçom que leva seu pedido para a cozinha (view) e traz o prato pronto (HTML renderizado). Já `@RestController` é como um garçom que entrega direto o ingrediente cru (JSON) sem passar pela cozinha. O `@ResponseBody` é o que diz "não vá para a cozinha, entregue direto".

**Exemplo de código:**

```java
// @Controller — retorna nome de view (ex: página Thymeleaf)
@Controller
@RequestMapping("/pagina")
public class PaginaController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("mensagem", "Bem-vindo!");
        return "home"; // nome do template (home.html)
    }

    // Para retornar JSON com @Controller, precisa de @ResponseBody
    @GetMapping("/api/dados")
    @ResponseBody
    public DadosDTO getDados() {
        return new DadosDTO("valor");
    }
}

// @RestController — todos os métodos retornam dados (JSON) diretamente
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/dados")
    public DadosDTO getDados() {
        return new DadosDTO("valor"); // serializado para JSON automaticamente
    }
}
```

**Como o candidato deve responder:**  
- Explicar que `@RestController` = `@Controller` + `@ResponseBody`.
- Mencionar que `@Controller` retorna views (HTML/templates) e `@RestController` retorna dados (JSON).
- Citar casos de uso: `@Controller` para SSR, `@RestController` para APIs REST.
- Mencionar que com `@Controller` é possível retornar JSON, mas exige `@ResponseBody` por método.

**Resposta fraca ou incompleta:**  
"`@RestController` é para REST e `@Controller` não é."  
Falta: não explica a relação com `@ResponseBody`, não menciona views, não mostra que `@RestController` é composta.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe a diferença |
| 1 | Sabe que um é "para REST" mas não explica por quê |
| 2 | Menciona JSON vs HTML mas não fala sobre @ResponseBody |
| 3 | Explica @RestController = @Controller + @ResponseBody com exemplos |
| 4 | Demonstra conhecimento prático com exemplos de código |
| 5 | Responde com profundidade, menciona ViewResolver, content negotiation e casos de uso reais |

**Perguntas de aprofundamento:**
1. "Se você quisesse um único controller que retornasse tanto HTML quanto JSON, como faria?"
2. "O que é content negotiation e como ele se relaciona com `@RestController`?"
3. "O que acontece se você usar `@Controller` sem `@ResponseBody` e retornar um objeto?"

