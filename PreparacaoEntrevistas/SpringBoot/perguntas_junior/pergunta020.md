# Pergunta 20 — Como você cria um endpoint REST que aceita e retorna JSON no Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Imagine que você precisa criar um endpoint REST `POST /api/usuarios` que recebe os dados de um usuário em JSON, salva no banco e retorna o usuário criado também em JSON. Como você implementaria isso?"

**O que essa pergunta avalia:**  
Avalia se o candidato consegue juntar os conceitos de `@RestController`, `@PostMapping`, `@RequestBody`, `@Valid`, `ResponseEntity` e `@ResponseStatus` em uma implementação prática e funcional.

**Resposta esperada:**  
A implementação envolve quatro componentes principais: o DTO de entrada, a entidade, o repository e o controller.

**1. DTO de entrada:**
```java
public class UsuarioRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100)
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    // getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

**2. DTO de saída (para não expor a entidade diretamente):**
```java
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;

    // Construtor que converte da entidade
    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    // getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
}
```

**3. Entidade JPA:**
```java
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

**4. Repository:**
```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
```

**5. Controller:**
```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Injeção por construtor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(
            @Valid @RequestBody UsuarioRequestDTO request) {

        UsuarioResponseDTO response = usuarioService.criar(request);
        // Retorna 201 Created com o recurso criado
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }
}
```

**6. Service:**
```java
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UsuarioResponseDTO criar(UsuarioRequestDTO request) {
        // Verifica se e-mail já existe
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailJaExistenteException(request.getEmail());
        }

        // Cria a entidade
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());

        // Salva no banco
        usuario = repository.save(usuario);

        // Retorna DTO de resposta
        return new UsuarioResponseDTO(usuario);
    }
}
```

**O fluxo completo:**
1. Cliente envia `POST /api/usuarios` com JSON: `{"nome": "João", "email": "joao@email.com"}`
2. Spring desserializa o JSON para `UsuarioRequestDTO` (`@RequestBody`)
3. Spring valida os dados (`@Valid`)
4. Controller chama o service
5. Service verifica duplicidade, cria a entidade e salva
6. Controller retorna `ResponseEntity` com status 201 e o DTO de resposta em JSON

**Explicação didática:**  
O Spring Boot usa o Jackson (incluído no starter-web) para converter automaticamente entre JSON e objetos Java. Quando o cliente envia JSON, o `@RequestBody` diz ao Spring: "pegue esse JSON e transforme em um objeto Java". Quando o método retorna um objeto, o Spring faz o inverso: transforma o objeto em JSON. Você não escreve nenhum código de parsing JSON — é tudo automático.

**Como o candidato deve responder:**  
- Criar um `@RestController` com `@PostMapping`.
- Usar `@RequestBody` para receber o JSON e `@Valid` para validar.
- Usar `ResponseEntity` para controlar o status HTTP (201 Created).
- Separar DTO de entrada, DTO de saída e entidade (não expor a entidade diretamente).
- Delegar a lógica de negócio para um `@Service`.
- Usar injeção por construtor.

**Resposta fraca ou incompleta:**  
```java
@PostMapping
public void criar(@RequestBody String json) {
    // parseia JSON manualmente e salva
}
```
Falta: não usa DTO, não usa `@Valid`, retorna void, não separa camadas, faz parse manual.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe criar um endpoint REST |
| 1 | Cria o endpoint mas sem DTO, validação ou status correto |
| 2 | Usa @RestController e @RequestBody mas sem separação de camadas |
| 3 | Implementa completo com DTO, validação, service e ResponseEntity |
| 4 | Demonstra boas práticas: DTO separado, tratamento de erro, @Transactional |
| 5 | Responde com profundidade, menciona idempotência, HATEOAS, versionamento e boas práticas REST |

**Perguntas de aprofundamento:**
1. "Por que você separou o DTO de entrada do DTO de saída? Não seria mais simples usar a entidade diretamente?"
2. "Como você garantiria que o endpoint retorne o header `Location` com a URI do recurso criado?"
3. "Como você lidaria com o cenário de dois requests simultâneos criando usuários com o mesmo e-mail?"
