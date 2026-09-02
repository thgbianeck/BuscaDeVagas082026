
### Pergunta 18 — Como funciona o servidor embutido (embedded server) no Spring Boot?

**Nível:** Júnior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
"Uma das características mais marcantes do Spring Boot é que você pode rodar a aplicação com `java -jar` sem precisar de um servidor de aplicação externo. Como isso funciona? Qual servidor é usado por padrão e como você poderia trocá-lo?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o conceito de servidor embutido, sabe que o Tomcat é o padrão, conhece alternativas (Jetty, Undertow) e compreende as vantagens dessa abordagem em relação a servidores externos.

**Resposta esperada:**  
O Spring Boot embute um servidor web dentro do próprio JAR da aplicação, eliminando a necessidade de instalar e configurar um servidor de aplicação externo (como Tomcat, JBoss/WildFly, WebLogic).

**Como funciona:**
- O servidor embutido é inicializado pela classe `SpringApplication` durante o startup.
- O servidor roda dentro da mesma JVM da aplicação, como um componente gerenciado pelo Spring.
- A aplicação é empacotada como um **JAR executável** (fat JAR), que contém todas as dependências, incluindo o servidor.

**Servidor padrão:**
- **Tomcat** é o servidor embutido padrão, trazido automaticamente pelo `spring-boot-starter-web`.

**Como trocar de servidor:**
Para usar **Jetty**:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

Para usar **Undertow**:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-undertow</artifactId>
</dependency>
```

**Configuração do servidor:**
```properties
server.port=8080
server.servlet.context-path=/api
server.tomcat.max-threads=200
server.tomcat.connection-timeout=20000
server.compression.enabled=true
```

**Vantagens do servidor embutido:**
- **Deploy simplificado** — basta `java -jar app.jar`, sem instalar servidor.
- **Versionamento consistente** — a versão do servidor é parte do projeto, garantindo paridade entre ambientes.
- **Inicialização rápida** — ideal para microsserviços e containers.
- **Configuração via código/propriedades** — sem arquivos XML externos do servidor.

**Desvantagens/trade-offs:**
- Não é possível fazer deploy de múltiplas aplicações no mesmo servidor (como em um Tomcat externo com múltiplos WARs).
- Para ambientes legados que exigem servidor de aplicação compartilhado, pode não ser adequado.

**Explicação didática:**  
No modelo tradicional, o servidor (Tomcat, JBoss) é como um "prédio" e a aplicação é um "inquilino" que se muda para dentro dele (deploy de WAR). No Spring Boot, a aplicação é como uma "casa prefabricada" que já vem com toda a infraestrutura embutida — você só coloca no terreno e ela funciona. Não precisa alugar um prédio separado.

**Como o candidato deve responder:**  
- Explicar que o servidor (Tomcat) roda dentro da JVM da aplicação.
- Mencionar que o JAR executável inclui o servidor.
- Citar que é possível trocar por Jetty ou Undertow (excluir Tomcat, adicionar o outro).
- Mencionar vantagens: deploy simplificado, paridade de ambiente.
- Citar pelo menos uma desvantagem ou trade-off.

**Resposta fraca ou incompleta:**  
"O Spring Boot tem um servidor embutido."  
Falta: não explica como funciona, não cita Tomcat, não mostra como trocar.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é servidor embutido |
| 1 | Sabe que "roda sem servidor externo" mas não explica |
| 2 | Cita Tomcat mas não sabe trocar |
| 3 | Explica funcionamento, Tomcat padrão e como trocar |
| 4 | Demonstra conhecimento de configuração, vantagens e trade-offs |
| 5 | Responde com profundidade, compara Tomcat/Jetty/Undertow, menciona WAR vs JAR e containers |

**Perguntas de aprofundamento:**
1. "Em quais cenários você escolheria Undertow em vez de Tomcat?"
2. "É possível empacotar uma aplicação Spring Boot como WAR para deploy em servidor externo? Como?"
3. "Como o servidor embutido afeta a estratégia de deploy em containers (Docker)?"

---

### Pergunta 19 — Como o Maven se integra com o Spring Boot?

**Nível:** Júnior  
**Categoria:** Ferramentas

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, geralmente usamos Maven como gerenciador de dependências e build. Como o Maven se integra com o Spring Boot? O que é o `spring-boot-maven-plugin` e quais goals ele oferece?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o papel do Maven no projeto Spring Boot, conhece o `spring-boot-maven-plugin` e sabe quais são seus goals principais (run, package, repackage).

**Resposta esperada:**  
O Maven é o gerenciador de build e dependências mais comum em projetos Spring Boot (embora Gradle também seja suportado). A integração entre Maven e Spring Boot acontece principalmente através do `spring-boot-maven-plugin`.

**O `pom.xml` típico de um projeto Spring Boot:**
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.0</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

**O que o `spring-boot-starter-parent` faz:**
- Fornece o **BOM (Bill of Materials)** — gerencia versões de todas as dependências do Spring Boot, garantindo compatibilidade.
- Configura **encoding UTF-8** e **Java version** por padrão.
- Define configurações padrão de plugins (compilador, surefire para testes, etc.).

**O que o `spring-boot-maven-plugin` faz:**

1. **`repackage`** (executado automaticamente na fase `package`):  
   Transforma o JAR normal (que só tem as classes da aplicação) em um **JAR executável** (fat JAR), que inclui todas as dependências e o servidor embutido. É por isso que você pode rodar `java -jar app.jar`.

2. **`run`**:  
   Inicia a aplicação diretamente do Maven, sem precisar compilar e empacotar primeiro:
   ```bash
   mvn spring-boot:run
   ```
   Útil durante o desenvolvimento.

3. **`start`** e **`stop`**:  
   Inicia e para a aplicação em segundo plano, útil para testes de integração.

4. **`build-info`**:  
   Gera um arquivo `build-info.properties` com informações de build (versão, data, artefato) que pode ser exposto via Actuator.

**Comandos Maven comuns no dia a dia:**
```bash
mvn clean package          # Compila, testa e empacota em JAR executável
mvn spring-boot:run        # Roda a aplicação
mvn clean install          # Compila, testa, empacota e instala no repo local
mvn test                   # Roda apenas os testes
mvn clean package -DskipTests  # Empacota sem rodar testes (não recomendado em CI)
```

**Explicação didática:**  
O Maven é como um "gerente de obra" do seu projeto. Ele sabe quais materiais (dependências) são necessários, em quais versões, e coordena todo o processo de construção: compila o código, roda os testes e, no final, entrega o produto pronto (JAR executável). O `spring-boot-maven-plugin` é a ferramenta especializada que o Maven usa para empacotar tudo (código + dependências + servidor) em um único JAR que "sabe se rodar sozinho".

**Como o candidato deve responder:**  
- Explicar que o `spring-boot-starter-parent` gerencia versões (BOM).
- Mencionar o `spring-boot-maven-plugin` e o goal `repackage` (cria o JAR executável).
- Citar o goal `run` para iniciar a aplicação via Maven.
- Mencionar comandos básicos: `mvn clean package`, `mvn spring-boot:run`.

**Resposta fraca ou incompleta:**  
"O Maven compila o projeto."  
Falta: não menciona o plugin do Spring Boot, não explica repackage ou JAR executável, não cita o parent POM.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe a relação Maven-Spring Boot |
| 1 | Sabe que "gerencia dependências" mas não detalha |
| 2 | Menciona spring-boot-maven-plugin mas não explica goals |
| 3 | Explica parent POM (BOM), plugin e goals principais |
| 4 | Demonstra prática com comandos e configuração |
| 5 | Responde com profundidade, menciona fat JAR, profiles Maven e integração com CI/CD |

**Perguntas de aprofundamento:**
1. "O que é o BOM (Bill of Materials) e como ele garante compatibilidade de versões?"
2. "Como você sobrescreveria a versão de uma dependência gerenciada pelo parent POM?"
3. "Qual a diferença entre `mvn package` e `mvn install`?"

---

### Pergunta 20 — Como você cria um endpoint REST que aceita e retorna JSON no Spring Boot?

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

---


### Pergunta 21 — Qual a diferença entre @Component, @Service, @Repository e @Controller?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"No Spring Boot, nós usamos várias anotações para marcar classes como beans gerenciados: `@Component`, `@Service`, `@Repository` e `@Controller`. Qual é a diferença entre elas e por que não usar apenas `@Component` em tudo?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende que essas anotações são especializações de `@Component`, conhece o propósito semântico de cada uma e sabe que `@Repository` traz funcionalidade extra (conversão de exceções). É uma pergunta fundamental para verificar se o júnior compreende a arquitetura em camadas do Spring.

**Resposta esperada:**  
Todas essas anotações são especializações de `@Component`, ou seja, todas fazem com que a classe seja detectada pelo component scan e registrada como um bean no contexto do Spring. A diferença é **semântica e funcional**:

1. **`@Component`** — anotação genérica para qualquer componente gerenciado pelo Spring. É a base de todas as outras.

2. **`@Service`** — especialização de `@Component` para a camada de serviço. Indica que a classe contém **lógica de negócio**. Funcionalmente é idêntica a `@Component`, mas serve como marcador semântico, comunicando a intenção da classe.

3. **`@Repository`** — especialização para a camada de persistência (DAOs, repositories). Além do aspecto semântico, tem uma funcionalidade prática: **converte exceções técnicas** (como `SQLException` ou `JPAException`) em `DataAccessException`, que é uma hierarquia de exceções unchecked e mais genérica do Spring. Isso permite que a camada de serviço trate erros de persistência sem depender de exceções específicas do banco.

4. **`@Controller`** — especialização para a camada de apresentação (web). Indica que a classe recebe requisições HTTP. Quando combinada com `@ResponseBody` (ou usando `@RestController`), retorna dados serializados.

**Por que não usar apenas `@Component`?**  
Por dois motivos principais:
- **Semântica e legibilidade:** ao ver `@Service`, qualquer desenvolvedor entende imediatamente o papel daquela classe na arquitetura. Com `@Component` em tudo, perde-se essa clareza.
- **Funcionalidade extra:** `@Repository` faz tradução de exceções, o que `@Component` não faz.

**Explicação didática:**  
Imagine um hospital. Todos os funcionários são "funcionários" (`@Component`), mas você precisa identificar quem é médico (`@Service`), quem cuida do arquivo de prontuários (`@Repository`) e quem atende na recepção (`@Controller`). Todos têm o mesmo crachá base, mas as especializações comunicam o papel de cada um. E o arquivista (`@Repository`) tem uma habilidade extra: ele traduz jargões médicos técnicos em uma linguagem que qualquer funcionário entende (tradução de exceções).

**Exemplo de código:**

```java
// Camada de controle — recebe requisições HTTP
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}

// Camada de serviço — contém lógica de negócio
@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    
    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }
}

// Camada de persistência — acessa o banco
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // SQLException ou PersistenceException são convertidas
    // automaticamente para DataAccessException
    Optional<Usuario> findByEmail(String email);
}
```

**Como o candidato deve responder:**  
- Explicar que todas são especializações de `@Component`.
- Citar o propósito semântico de cada uma (serviço = lógica de negócio, repositório = persistência, controller = web).
- Mencionar que `@Repository` faz tradução de exceções.
- Justificar por que usar as especializações em vez de `@Component` genérico.

**Resposta fraca ou incompleta:**  
"São todas a mesma coisa, só mudam o nome."  
Falta: não explica a semântica, não menciona a tradução de exceções do `@Repository`, não justifica o uso das especializações.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe a diferença |
| 1 | Sabe que "são para camadas diferentes" mas não explica |
| 2 | Explica a semântica mas não menciona tradução de exceções |
| 3 | Explica semântica e tradução de exceções do @Repository |
| 4 | Demonstra conhecimento prático com exemplos de arquitetura em camadas |
| 5 | Responde com profundidade, menciona PersistentExceptionTranslator, hierarquia de exceções e boas práticas |

**Perguntas de aprofundamento:**
1. "Se você usar `@Component` em vez de `@Repository` em um DAO, o que deixaria de funcionar?"
2. "Existe alguma situação em que faria sentido usar `@Component` em vez de uma especialização?"
3. "Como o Spring sabe que `@Service` é uma especialização de `@Component`?"

---

### Pergunta 22 — O que é e como funciona o ciclo de vida de um bean no Spring?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Quando o Spring cria e gerencia um bean, existe um ciclo de vida por trás disso. Pode me explicar quais são as principais fases do ciclo de vida de um bean no Spring?"

**O que essa pergunta avalia:**  
Avalia se o candidato compreende que o bean passa por etapas bem definidas (instantiação, injeção de dependências, inicialização, uso e destruição), e se conhece as anotações `@PostConstruct` e `@PreDestroy` ou as interfaces `InitializingBean` e `DisposableBean`.

**Resposta esperada:**  
O ciclo de vida de um bean no Spring tem as seguintes fases principais:

1. **Instantiação** — o Spring cria a instância do bean (chama o construtor).

2. **Injeção de dependências** — o Spring injeta as dependências declaradas (via construtor, setter ou campo).

3. **Awareness callbacks** — o Spring chama métodos de callback que injetam objetos internos do Spring, como `BeanNameAware` (passa o nome do bean), `ApplicationContextAware` (passa o contexto), `BeanFactoryAware` (passa a factory). Estas são interfaces que o bean pode implementar para receber informações do container.

4. **Pré-inicialização (BeanPostProcessor - antes)** — métodos `postProcessBeforeInitialization` de `BeanPostProcessor` são chamados. É aqui que anotações como `@Autowired` em métodos são processadas (em alguns casos).

5. **Inicialização** — o bean executa sua lógica de inicialização. Isso pode acontecer de três formas:
   - Anotação `@PostConstruct` (recomendada).
   - Interface `InitializingBean` com método `afterPropertiesSet()`.
   - Método customizado definido via `@Bean(initMethod = "...")`.

6. **Pós-inicialização (BeanPostProcessor - depois)** — métodos `postProcessAfterInitialization` são chamados. É aqui que, por exemplo, o Spring cria proxies AOP (como transações com `@Transactional`).

7. **Uso (Ready)** — o bean está pronto e disponível para uso durante toda a vida da aplicação.

8. **Destruição** — quando o contexto é fechado, o bean é destruído. Isso pode acontecer de três formas:
   - Anotação `@PreDestroy` (recomendada).
   - Interface `DisposableBean` com método `destroy()`.
   - Método customizado via `@Bean(destroyMethod = "...")`.

**Explicação didática:**  
Pense no ciclo de vida de um bean como o ciclo de vida de um funcionário em uma empresa: ele é contratado (instantiação), recebe suas ferramentas de trabalho (injeção de dependências), faz um treinamento de integração (`@PostConstruct`), trabalha (uso) e, quando a empresa fecha ou ele é demitido, devolve os equipamentos e faz um handover (`@PreDestroy`).

**Exemplo de código:**

```java
@Component
public class CacheService {

    private Map<String, String> cache;

    // Fase 1: Instantiação (construtor)
    public CacheService() {
        System.out.println("1. Construtor chamado");
    }

    // Fase 5: Inicialização
    @PostConstruct
    public void init() {
        System.out.println("2. @PostConstruct — inicializando cache");
        this.cache = new ConcurrentHashMap<>();
        // Carregar dados iniciais, abrir conexões, etc.
    }

    // Fase 8: Destruição
    @PreDestroy
    public void cleanup() {
        System.out.println("3. @PreDestroy — limpando recursos");
        cache.clear();
        // Fechar conexões, liberar recursos, etc.
    }

    public String get(String key) {
        return cache.get(key);
    }
}
```

**Como o candidato deve responder:**  
- Mencionar as fases principais: instantiação, injeção, inicialização, uso e destruição.
- Citar `@PostConstruct` e `@PreDestroy` como as formas recomendadas.
- Explicar que `@PostConstruct` é chamado após a injeção de dependências, o que é importante.
- Se possível, mencionar que existem alternativas via interfaces (`InitializingBean`, `DisposableBean`).

**Resposta fraca ou incompleta:**  
"O Spring cria o bean, usa e depois destrói."  
Falta: não menciona as fases intermediárias, não cita `@PostConstruct` ou `@PreDestroy`, não explica a ordem.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é ciclo de vida |
| 1 | Sabe que "o Spring cria e destrói" mas sem detalhes |
| 2 | Menciona @PostConstruct mas não @PreDestroy ou a ordem |
| 3 | Explica as fases principais com @PostConstruct e @PreDestroy |
| 4 | Demonstra conhecimento de alternativas (interfaces) e ordem correta |
| 5 | Responde com profundidade, menciona BeanPostProcessor, proxies AOP e awareness callbacks |

**Perguntas de aprofundamento:**
1. "Por que usar `@PostConstruct` em vez de fazer a inicialização no construtor?"
2. "Qual a diferença entre `@PostConstruct` e `InitializingBean`? Qual você usaria?"
3. "Em qual momento do ciclo de vida o Spring cria o proxy de `@Transactional`?"

---

### Pergunta 23 — Como funcionam as anotações @Primary e @Qualifier?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Imagine que você tem duas implementações de uma mesma interface e ambas são beans do Spring. Quando você tenta injetar essa interface, o Spring não sabe qual escolher. Como você resolve esse conflito usando `@Primary` e `@Qualifier`?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o problema de ambiguidade de beans, sabe usar `@Primary` para definir uma prioridade padrão e `@Qualifier` para escolher explicitamente qual bean injetar.

**Resposta esperada:**  
Quando existem múltiplos beans do mesmo tipo no contexto do Spring, ocorre a exceção `NoUniqueBeanDefinitionException`. Para resolver isso, o Spring oferece duas abordagens:

1. **`@Primary`** — define um bean como a **escolha padrão** quando há ambiguidade. Se o Spring encontrar múltiplos candidatos e um deles for `@Primary`, ele escolhe esse automaticamente, sem que o código cliente precise especificar nada.

```java
public interface NotificacaoService {
    void enviar(String mensagem);
}

@Service
@Primary  // Este é o bean padrão quando há ambiguidade
public class EmailNotificacaoService implements NotificacaoService {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}

@Service
public class SmsNotificacaoService implements NotificacaoService {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}

// O Spring injeta EmailNotificacaoService automaticamente (por ser @Primary)
@Service
public class PedidoService {
    private final NotificacaoService notificacao;
    
    public PedidoService(NotificacaoService notificacao) {
        this.notificacao = notificacao;
    }
}
```

2. **`@Qualifier`** — permite **escolher explicitamente** qual bean injetar, pelo nome. É mais preciso que `@Primary`, pois dá controle no ponto de injeção.

```java
@Service
public class PedidoService {
    private final NotificacaoService notificacao;
    
    // Escolhe explicitamente o bean "smsNotificacaoService"
    public PedidoService(@Qualifier("smsNotificacaoService") NotificacaoService notificacao) {
        this.notificacao = notificacao;
    }
}
```

**Diferenças e trade-offs:**

| Aspecto | `@Primary` | `@Qualifier` |
|--------|-----------|--------------|
| Onde se aplica | Na classe do bean | No ponto de injeção |
| Granularidade | Global (afeta todas as injeções) | Local (afeta apenas um ponto) |
| Controle | Implícito (o Spring decide) | Explícito (o desenvolvedor escolhe) |
| Quando usar | Quando uma implementação é a "padrão" | Quando cada ponto de uso precisa de uma implementação diferente |

**Explicação didática:**  
Imagine um restaurante com dois chefs. Se um deles é o "chef principal" (`@Primary`), o garçom leva o pedido para ele por padrão. Mas se você, como cliente, quiser especificamente que o outro chef prepare seu prato, você diz o nome dele (`@Qualifier`). O `@Primary` é a escolha automática; o `@Qualifier` é a escolha explícita.

**Como o candidato deve responder:**  
- Explicar o problema: múltiplos beans do mesmo tipo geram ambiguidade.
- Explicar `@Primary`: define um bean como padrão.
- Explicar `@Qualifier`: escolhe explicitamente no ponto de injeção.
- Comparar: `@Primary` é global e implícito, `@Qualifier` é local e explícito.
- Mencionar que `@Qualifier` tem prioridade sobre `@Primary` quando ambos são usados.

**Resposta fraca ou incompleta:**  
"Serve para escolher qual bean usar."  
Falta: não explica a diferença entre os dois, não mostra exemplos, não menciona o cenário de ambiguidade.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece as anotações |
| 1 | Sabe que "resolve conflito" mas não explica como |
| 2 | Explica um dos dois mas não a diferença |
| 3 | Explica ambos com exemplos e a diferença de abordagem |
| 4 | Demonstra conhecimento prático com trade-offs e prioridade |
| 5 | Responde com profundidade, menciona NoUniqueBeanDefinitionException, resolução por nome de parâmetro e boas práticas |

**Perguntas de aprofundamento:**
1. "Se você usar `@Primary` e `@Qualifier` ao mesmo tempo, qual prevalece?"
2. "Existe alguma outra forma de resolver ambiguidade sem essas anotações?"
3. "Como o Spring resolve a injeção se você não usar nem `@Primary` nem `@Qualifier` e os beans tiverem nomes diferentes?"

---

### Pergunta 24 — O que faz a anotação @Bean e qual a diferença em relação ao @Component?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Você pode registrar beans no Spring de duas formas principais: anotando uma classe com `@Component` (ou suas especializações) ou usando métodos anotados com `@Bean` dentro de uma classe `@Configuration`. Qual é a diferença entre essas duas abordagens e quando você usaria cada uma?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende a diferença entre component scanning (autodetecção) e registro manual de beans, e sabe quando cada abordagem é mais apropriada.

**Resposta esperada:**  

**`@Component` (e especializações):**
- Aplicado **diretamente na classe** que você escreve.
- O Spring detecta a classe via **component scan** (escaneamento do classpath).
- Você tem controle total do código-fonte da classe.
- É a abordagem preferida para **suas próprias classes**.

**`@Bean`:**
- Aplicado em **métodos** dentro de uma classe `@Configuration` (ou `@Component`).
- O Spring executa o método e registra o retorno como um bean.
- É usado quando você **não controla o código-fonte** da classe (bibliotecas externas) ou quando a criação do bean exige **lógica customizada**.
- É a abordagem preferida para **classes de terceiros** ou configuração complexa.

**Diferença técnica fundamental — CGLIB Proxy:**

Quando `@Bean` está dentro de uma classe `@Configuration`, o Spring cria um **proxy CGLIB** da classe de configuração. Isso garante que se você chamar um método `@Bean` de dentro de outro método `@Bean`, o Spring retorna o **bean singleton já existente**, em vez de criar uma nova instância. Isso é chamado de "interceptação de métodos de bean".

```java
@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(...);
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        // Se você chamasse dataSource() aqui, sem o proxy CGLIB,
        // criaria uma NOVA instância de DataSource.
        // Com @Configuration, o Spring intercepta a chamada
        // e retorna o bean já existente (singleton).
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource()); // retorna o bean singleton
        return em.getObject();
    }
}
```

Se a mesma classe fosse anotada com `@Component` em vez de `@Configuration`, a chamada `dataSource()` criaria uma **nova instância** a cada chamada, quebrando o padrão singleton.

**Exemplo prático de quando usar `@Bean`:**

```java
@Configuration
public class AwsConfig {

    @Value("${aws.access-key}")
    private String accessKey;

    @Value("${aws.secret-key}")
    private String secretKey;

    // Classe AmazonS3 não é sua — vem de uma biblioteca externa.
    // Você não pode anotá-la com @Component.
    @Bean
    public AmazonS3 amazonS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(Regions.SA_EAST_1)
            .build();
    }
}
```

**Explicação didática:**  
Use `@Component` quando você está "educando" uma classe que você mesmo criou — você pode colocar a anotação diretamente nela. Use `@Bean` quando você está "adotando" uma classe que veio de fora (biblioteca) — você não pode modificá-la, então a registra indiretamente, através de um método que a cria e configura.

**Como o candidato deve responder:**  
- Explicar que `@Component` é para classes próprias (component scanning).
- Explicar que `@Bean` é para classes de terceiros ou criação com lógica customizada.
- Mencionar que `@Bean` vai dentro de `@Configuration`.
- Se possível, mencionar a diferença do proxy CGLIB entre `@Configuration` e `@Component` para métodos `@Bean`.

**Resposta fraca ou incompleta:**  
"São a mesma coisa, só que `@Bean` é em método."  
Falta: não explica quando usar cada um, não menciona bibliotecas externas, não fala sobre component scanning vs. registro manual.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe a diferença |
| 1 | Sabe que "um é classe e outro é método" mas não explica contexto |
| 2 | Explica classes próprias vs. terceiros mas sem detalhes técnicos |
| 3 | Explica os dois casos de uso com exemplos |
| 4 | Menciona a diferença do proxy CGLIB e o comportamento singleton |
| 5 | Responde com profundidade, explica intercepção de métodos, @Configuration vs @Component para @Bean e boas práticas |

**Perguntas de aprofundamento:**
1. "O que acontece se você anotar uma classe com `@Component` e tiver métodos `@Bean` nela? O comportamento é o mesmo de `@Configuration`?"
2. "Como você controla a ordem de inicialização entre beans que dependem um do outro?"
3. "É possível ter dois métodos `@Bean` retornando o mesmo tipo? Como o Spring resolve?"

---

### Pergunta 25 — O que é e como funciona a anotação @Lazy?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Em algumas situações, podemos usar a anotação `@Lazy` no Spring Boot. O que ela faz, por que existe e em quais cenários você a utilizaria?"

**O que essa pergunta avalia:**  
Avalia se o candidato compreende que, por padrão, o Spring cria todos os beans singleton na inicialização do contexto (eager loading), e que `@Lazy` adia essa criação para o momento em que o bean é realmente necessário (lazy loading). Também avalia se sabe identificar cenários de uso prático.

**Resposta esperada:**  

**Comportamento padrão (eager):**  
Por padrão, o Spring cria e inicializa todos os beans singleton **na inicialização da aplicação**. Isso significa que, quando `SpringApplication.run()` termina, todos os beans singleton já foram instanciados, injetados e inicializados.

**O que `@Lazy` faz:**  
A anotação `@Lazy` altera esse comportamento: o bean só é criado **quando é realmente solicitado** (injetado em outro bean ou obtido do contexto). Isso adia a instanciação e inicialização para o primeiro uso.

**Onde pode ser aplicada:**

1. **Na declaração do bean** (afeta a criação do bean):

```java
@Service
@Lazy  // O bean só será criado quando alguém precisar dele
public class RelatorioService {
    public RelatorioService() {
        System.out.println("RelatorioService criado!");
    }
}
```

2. **No ponto de injeção** (afeta apenas aquela injeção específica):

```java
@Service
public class PedidoService {
    private final RelatorioService relatorioService;
    
    // O relatorioService só será criado quando o PedidoService
    // realmente o utilizar pela primeira vez
    public PedidoService(@Lazy RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }
}
```

**Cenários de uso prático:**

- **Redução de tempo de inicialização:** quando há beans pesados (ex: conexão com serviço externo, carga de cache) que nem sempre são usados em toda execução.
- **Resolução de dependências circulares:** quando dois beans dependem um do outro, `@Lazy` em um dos lados quebra o ciclo, pois cria um proxy que adia a resolução.
- **Beans opcionais:** quando um bean pode ou não ser usado dependendo do fluxo de execução.

**Explicação didática:**  
Por padrão, o Spring é como uma pessoa que prepara TODOS os ingredientes da receita antes de começar a cozinhar — mesmo os que talvez não sejam usados. Com `@Lazy`, ele só prepara o ingrediente na hora em que precisa dele. Isso pode economizar tempo de inicialização, mas adiciona uma pequena latência no primeiro uso.

**Como o candidato deve responder:**  
- Explicar que por padrão o Spring cria beans singleton na inicialização (eager).
- Explicar que `@Lazy` adia a criação para o primeiro uso.
- Mencionar pelo menos um cenário prático (tempo de inicialização, dependência circular).
- Apontar o trade-off: menor tempo de inicialização vs. latência no primeiro acesso.

**Resposta fraca ou incompleta:**  
"`@Lazy` faz o bean ser carregado depois."  
Falta: não explica o comportamento padrão (eager), não menciona cenários de uso, não aponta trade-offs.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que @Lazy faz |
| 1 | Sabe que "atrasa" mas não explica o padrão eager |
| 2 | Explica lazy vs. eager mas sem cenários práticos |
| 3 | Explica o conceito, cenários e trade-offs |
| 4 | Demonstra conhecimento de aplicação no ponto de injeção e na declaração |
| 5 | Responde com profundidade, menciona proxies, dependências circulares e impacto em testes |

**Perguntas de aprofundamento:**
1. "Se você usar `@Lazy` em todos os beans da aplicação, quais seriam os problemas?"
2. "Como o `@Lazy` ajuda a resolver dependências circulares? Como o proxy funciona?"
3. "Se um bean `@Lazy` nunca for usado durante a execução, ele é criado?"

---

### Pergunta 26 — Como o component scan decide quais classes se tornam beans?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Quando o Spring Boot sobe, ele encontra e registra automaticamente as classes anotadas com `@Component`, `@Service`, `@Repository`, etc. Como funciona esse processo de component scanning? E se eu tiver um pacote fora do escopo, como faço para incluí-lo?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o mecanismo de component scanning, sabe que o escaneamento parte do pacote da classe principal e conhece formas de customizar o escopo (basePackages, basePackageClasses, @ComponentScan).

**Resposta esperada:**  

**Como funciona o component scanning:**

1. A anotação `@SpringBootApplication` (que inclui `@ComponentScan`) inicia o escaneamento a partir do **pacote da classe anotada** e de todos os seus **subpacotes**.

2. O Spring percorre o classpath procurando por classes anotadas com estereótipos do Spring:
   - `@Component` e todas as suas especializações (`@Service`, `@Repository`, `@Controller`, `@RestController`, `@Configuration`).
   - Anotações customizadas que são meta-anotadas com `@Component`.
   - Classes com métodos `@Bean` (se estiverem em classes `@Configuration`).

3. Cada classe encontrada é registrada como uma **bean definition** e posteriormente instanciada como um bean singleton (por padrão).

**Estrutura de pacotes típica:**

```
com.empresa.projeto                  ← classe @SpringBootApplication aqui
├── controller                       ← escaneado ✓
│   └── UsuarioController.java
├── service                          ← escaneado ✓
│   └── UsuarioService.java
├── repository                       ← escaneado ✓
│   └── UsuarioRepository.java
└── config                           ← escaneado ✓
    └── AppConfig.java

com.outra.biblioteca                 ← NÃO escaneado ✗ (pacote diferente)
└── Utilitario.java
```

**Como customizar o escaneamento:**

1. **`basePackages`** — especifica explicitamente os pacotes a escanear:

```java
@SpringBootApplication
@ComponentScan(basePackages = {"com.empresa.projeto", "com.outra.biblioteca"})
public class MinhaAplicacao { ... }
```

2. **`basePackageClasses`** — usa classes como referência para determinar o pacote (mais seguro que strings, pois o IDE detecta refatorações):

```java
@SpringBootApplication
@ComponentScan(basePackageClasses = {MinhaAplicacao.class, Utilitario.class})
public class MinhaAplicacao { ... }
```

3. **Exclusão de filtros** — exclui certas classes do escaneamento:

```java
@SpringBootApplication
@ComponentScan(
    basePackages = "com.empresa.projeto",
    excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Test.*")
)
public class MinhaAplicacao { ... }
```

**Explicação didática:**  
O component scan é como um detetive que começa a procurar suspeitos a partir de um endereço (pacote da classe principal) e vasculha todos os andares acima (subpacotes). Se ele precisa procurar em outro prédio (outro pacote), você precisa dar o endereço explicitamente. Ele só encontra as "pessoas" que usam crachás específicos (anotações como `@Component`, `@Service`, etc.).

**Como o candidato deve responder:**  
- Explicar que o scan parte do pacote da classe `@SpringBootApplication`.
- Mencionar que escaneia subpacotes automaticamente.
- Citar as anotações detectadas: `@Component` e especializações.
- Explicar como incluir pacotes fora do escopo (`basePackages` ou `basePackageClasses`).
- Mencionar a importância de colocar a classe principal no pacote raiz.

**Resposta fraca ou incompleta:**  
"O Spring encontra as classes com anotação automaticamente."  
Falta: não explica de onde parte o escaneamento, não menciona subpacotes, não explica como customizar.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é component scan |
| 1 | Sabe que "encontra anotações" mas não explica o escopo |
| 2 | Explica o pacote raiz mas não sabe customizar |
| 3 | Explica escopo, subpacotes e customização com basePackages |
| 4 | Demonstra conhecimento de basePackageClasses, excludeFilters e boas práticas |
| 5 | Responde com profundidade, menciona FilterType, BeanDefinition, classpath scanning e performance |

**Perguntas de aprofundamento:**
1. "Se você mover a classe `@SpringBootApplication` para um subpacote, o que acontece com os beans nos pacotes acima?"
2. "Qual a diferença entre `basePackages` e `basePackageClasses`? Qual é mais seguro e por quê?"
3. "O component scan escaneia arquivos `.class` no classpath ou o código-fonte? Como ele encontra as anotações?"

---

### Pergunta 27 — O que é o ApplicationContext e qual a diferença para o BeanFactory?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"No Spring, nós falamos muito sobre o container e o contexto da aplicação. O que é o `ApplicationContext`? E qual a relação dele com o `BeanFactory`?"

**O que essa pergunta avalia:**  
Avalia se o candidato compreende o que é o container do Spring, sabe que `ApplicationContext` é o objeto central que gerencia os beans, e conhece a relação de herança com `BeanFactory` (que é mais básica).

**Resposta esperada:**  

**O que é o ApplicationContext:**

O `ApplicationContext` é o **container central** do Spring. Ele é responsável por:
- Instanciar, configurar e gerenciar o ciclo de vida dos beans.
- Injetar dependências entre os beans.
- Disparar eventos da aplicação.
- Carregar recursos (arquivos, URLs).
- Internacionalização (resolução de mensagens).
- Suporte a profiles e environment.

Em uma aplicação Spring Boot, quando você chama `SpringApplication.run()`, o Spring cria uma instância de `ApplicationContext` (especificamente um `AnnotationConfigServletWebServerApplicationContext` para aplicações web) e o popula com todos os beans.

**Relação com BeanFactory:**

`BeanFactory` é a interface mais básica do container do Spring. Ela fornece apenas a funcionalidade fundamental: **injeção de dependências** e **gerenciamento do ciclo de vida dos beans**.

`ApplicationContext` **estende** `BeanFactory` e adiciona várias funcionalidades:

| Funcionalidade | BeanFactory | ApplicationContext |
|----------------|:-----------:|:-------------------:|
| Injeção de dependências | ✅ | ✅ |
| Ciclo de vida dos beans | ✅ | ✅ |
| Carregamento eager (por padrão) | ❌ (lazy por padrão) | ✅ |
| Eventos da aplicação | ❌ | ✅ |
| Internacionalização | ❌ | ✅ |
| Carregamento de recursos | ❌ | ✅ |
| Suporte a AOP | ❌ | ✅ |
| Profiles e Environment | ❌ | ✅ |

**Explicação didática:**  
Pense no `BeanFactory` como um armário simples onde você guarda e recupera ferramentas (beans). O `ApplicationContext` é como uma oficina completa: tem o armário, mas também tem painel de avisos (eventos), biblioteca de manuais em vários idiomas (internacionalização), sistema de energia (AOP) e ferramentas especiais (resources). Em aplicações modernas, você sempre usa o `ApplicationContext` — o `BeanFactory` raramente é usado diretamente.

**Exemplo de uso:**

```java
@SpringBootApplication
public class MinhaAplicacao implements CommandLineRunner {
    
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }
    
    @Override
    public void run(String... args) {
        // ApplicationContext está disponível via injeção
    }
}

// Acessando o contexto explicitamente (geralmente não necessário)
@Component
public class BeanInspector {
    private final ApplicationContext context;
    
    public BeanInspector(ApplicationContext context) {
        this.context = context;
    }
    
    public void listarBeansDoTipoService() {
        Map<String, Object> services = context.getBeansWithAnnotation(Service.class);
        services.keySet().forEach(System.out::println);
    }
    
    public void buscarBeanPorNome() {
        Object bean = context.getBean("usuarioService");
        System.out.println(bean.getClass().getSimpleName());
    }
}
```

**Como o candidato deve responder:**  
- Explicar que o `ApplicationContext` é o container central do Spring.
- Mencionar que ele gerencia beans, injeção de dependências e ciclo de vida.
- Explicar que `ApplicationContext` estende `BeanFactory` (é mais completo).
- Citar pelo menos uma funcionalidade extra do `ApplicationContext` (eventos, AOP, internacionalização).
- Mencionar que em Spring Boot, o contexto é criado automaticamente por `SpringApplication.run()`.

**Resposta fraca ou incompleta:**  
"É onde o Spring guarda os beans."  
Falta: não explica a relação com `BeanFactory`, não menciona as funcionalidades extras, não explica como é criado.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é ApplicationContext |
| 1 | Sabe que "gerencia beans" mas não explica a relação com BeanFactory |
| 2 | Menciona que ApplicationContext é mais completo mas sem detalhar |
| 3 | Explica a relação de herança e lista funcionalidades extras |
| 4 | Demonstra conhecimento prático de como acessar o contexto e usá-lo |
| 5 | Responde com profundidade, menciona tipos de contexto (web, non-web), hierarquia de contextos e lifecycle |

**Perguntas de aprofundamento:**
1. "Em uma aplicação Spring Boot web, qual é a implementação concreta de ApplicationContext usada?"
2. "É possível ter múltiplos ApplicationContexts na mesma aplicação? Quando isso faria sentido?"
3. "Como você acessaria um bean programaticamente sem usar injeção de dependências? Isso é recomendado?"

---

### Pergunta 28 — O que são os scopes (escopos) de beans no Spring?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"No Spring, nem todos os beans têm o mesmo comportamento de ciclo de vida. O que são os scopes de beans? Quais são os disponíveis e como eles diferem?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o conceito de escopo de bean, sabe que o padrão é singleton, conhece os outros escopos (prototype, request, session, application) e entende a diferença prática entre eles.

**Resposta esperada:**  

O escopo (scope) de um bean define **quantas instâncias** do bean são criadas e **por quanto tempo** elas vivem. O Spring oferece os seguintes escopos:

**1. Singleton (padrão):**
- Uma única instância por ApplicationContext.
- Criado na inicialização do contexto (ou no primeiro uso, se `@Lazy`).
- Todos que injetam esse bean recebem a mesma referência.

```java
@Service
// @Scope("singleton") — implícito
public class UsuarioService { ... }
```

**2. Prototype:**
- Uma nova instância é criada **a cada vez** que o bean é solicitado.
- O Spring não gerencia o ciclo de vida completo — não chama `@PreDestroy`.

```java
@Service
@Scope("prototype")
public class GeradorRelatorio { ... }
```

**3. Request (apenas em aplicações web):**
- Uma instância por requisição HTTP.
- Criado no início da requisição e destruído ao final.

```java
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras { ... }
```

**4. Session (apenas em aplicações web):**
- Uma instância por sessão HTTP.
- Criado quando a sessão inicia e destruído quando expira ou é invalidada.

```java
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PreferenciasUsuario { ... }
```

**5. Application (apenas em aplicações web):**
- Uma instância por ServletContext (similar a singleton, mas com escopo de contexto web).

```java
@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class AppConfigCache { ... }
```

**Comparação:**

| Escopo | Instâncias | Duração | Gerencia @PreDestroy? |
|--------|-----------|---------|:---------------------:|
| Singleton | 1 por contexto | Vida da aplicação | ✅ |
| Prototype | N (1 por solicitação) | Até coleta de lixo | ❌ |
| Request | 1 por requisição | Duração da requisição HTTP | ✅ |
| Session | 1 por sessão | Duração da sessão HTTP | ✅ |
| Application | 1 por ServletContext | Vida da aplicação web | ✅ |

**Explicação didática:**  
Pense nos escopos como tipos de moradia:
- **Singleton** é um hotel: todos os hóspedes compartilham a mesma recepção (uma instância para todos).
- **Prototype** é um aluguel de carro: cada pessoa que pede, recebe um carro diferente.
- **Request** é um quarto de hotel: cada hóspede tem seu quarto durante a estadia (requisição).
- **Session** é um apartamento: é seu enquanto o contrato (sessão) estiver ativo.

**Como o candidato deve responder:**  
- Explicar que o escopo define quantas instâncias são criadas.
- Citar singleton como padrão (uma instância por aplicação).
- Citar prototype (nova instância a cada solicitação).
- Mencionar request e session para contexto web.
- Apontar que prototype não tem `@PreDestroy` gerenciado pelo Spring.

**Resposta fraca ou incompleta:**  
"Singleton cria um só e prototype cria vários."  
Falta: não menciona request/session, não explica a diferença de gerenciamento de ciclo de vida, não cita o padrão.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que são scopes |
| 1 | Conhece singleton e prototype mas não explica |
| 2 | Explica singleton e prototype mas não menciona web scopes |
| 3 | Explica os cinco scopes principais com diferenças |
| 4 | Demonstra conhecimento de proxyMode e implicações práticas |
| 5 | Responde com profundidade, menciona ScopedProxyMode, problemas de injetar prototype em singleton e custom scopes |

**Perguntas de aprofundamento:**
1. "Se você injetar um bean prototype dentro de um bean singleton, o que acontece? O prototype é criado a cada uso?"
2. "Como você resolveria o problema de injetar um prototype em um singleton e precisar de uma nova instância a cada chamada?"
3. "Por que o Spring não chama `@PreDestroy` em beans prototype?"

---

### Pergunta 29 — Como você injeta um bean prototype dentro de um singleton?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Imagine que você tem um bean singleton que precisa usar um bean prototype. Se você simplesmente injetar o prototype via construtor, ele será criado apenas uma vez — na construção do singleton. Como você faria para obter uma nova instância do prototype a cada uso?"

**O que essa pergunta avalia:**  
Avalia se o candidato reconhece o problema de injetar um escopo mais curto (prototype) em um escopo mais longo (singleton), e se conhece as soluções: `ObjectFactory`, `Provider`, `@Lookup` ou `ApplicationContext`.

**Resposta esperada:**  

**O problema:**  
Quando um bean singleton injeta um bean prototype via construtor, o prototype é criado **uma única vez** no momento em que o singleton é instanciado. A partir daí, o singleton sempre referencia a mesma instância, anulando o efeito do escopo prototype.

**Soluções:**

**1. Usar `ObjectFactory<T>` (recomendado):**

```java
@Service
public class RelatorioService {
    private final ObjectFactory<GeradorRelatorio> factory;
    
    public RelatorioService(ObjectFactory<GeradorRelatorio> factory) {
        this.factory = factory;
    }
    
    public void gerarRelatorio() {
        // A cada chamada, getObject() retorna uma NOVA instância
        GeradorRelatorio gerador = factory.getObject();
        gerador.gerar();
    }
}
```

**2. Usar `javax.inject.Provider<T>` (alternativa):**

```java
import javax.inject.Provider;

@Service
public class RelatorioService {
    private final Provider<GeradorRelatorio> provider;
    
    public RelatorioService(Provider<GeradorRelatorio> provider) {
        this.provider = provider;
    }
    
    public void gerarRelatorio() {
        GeradorRelatorio gerador = provider.get(); // nova instância
        gerador.gerar();
    }
}
```

**3. Usar `@Lookup` (Spring-specific):**

```java
@Service
public abstract class RelatorioService {
    
    @Lookup  // O Spring sobrescreve este método para retornar uma nova instância
    public abstract GeradorRelatorio criarGerador();
    
    public void gerarRelatorio() {
        GeradorRelatorio gerador = criarGerador();
        gerador.gerar();
    }
}
```

O Spring cria uma subclasse (via CGLIB) que sobrescreve o método anotado, retornando uma nova instância do bean prototype a cada chamada. A classe precisa ser abstrata (ou o método, pelo menos) para que o Spring possa criar o proxy.

**4. Usar `ApplicationContext` diretamente (não recomendado, mas funciona):**

```java
@Service
public class RelatorioService {
    private final ApplicationContext context;
    
    public RelatorioService(ApplicationContext context) {
        this.context = context;
    }
    
    public void gerarRelatorio() {
        GeradorRelatorio gerador = context.getBean(GeradorRelatorio.class);
        gerador.gerar();
    }
}
```

**Trade-offs:**

| Abordagem | Vantagem | Desvantagem |
|-----------|----------|-------------|
| `ObjectFactory` | Simples, type-safe, baixo acoplamento | Exige Spring 5+ |
| `Provider` | Padrão JSR-330, não é específico do Spring | Exige dependência javax.inject |
| `@Lookup` | Declarativo, não acopla ao contexto | Exige classe/proxy, menos intuitivo |
| `ApplicationContext` | Funciona sempre | Alto acoplamento com o Spring |

**Explicação didática:**  
Imagine que o singleton é uma cozinha fixa (uma só na empresa) e o prototype é um copo descartável (novo a cada uso). Se você colocar um copo fixo na cozinha na hora de construí-la, ele nunca será trocado. A solução é ter uma "máquina de copos" (ObjectFactory/Provider) na cozinha — toda vez que você precisa de um copo novo, pede à máquina, e ela te dá uma instância nova.

**Como o candidato deve responder:**  
- Explicar o problema: prototype injetado em singleton é criado uma vez só.
- Apresentar pelo menos uma solução (ObjectFactory, Provider ou @Lookup).
- Justificar a escolha e mencionar trade-offs.
- Evitar a abordagem de `ApplicationContext.getBean()` como primeira opção.

**Resposta fraca ou incompleta:**  
"Basta usar `@Autowired` e ele cria novo."  
Falta: não reconhece o problema de instância única, não conhece as soluções.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não reconhece o problema |
| 1 | Reconhece o problema mas não sabe resolver |
| 2 | Menciona ApplicationContext.getBean() mas não conhece alternativas |
| 3 | Apresenta ObjectFactory ou Provider como solução |
| 4 | Demonstra conhecimento de múltiplas soluções com trade-offs |
| 5 | Responde com profundidade, menciona @Lookup, proxy CGLIB, escopo de proxy e boas práticas |

**Perguntas de aprofundamento:**
1. "Como o `@Lookup` funciona internamente? O que o Spring faz para interceptar a chamada?"
2. "Existe alguma diferença de comportamento entre `ObjectFactory` e `Provider`?"
3. "Se você usasse `@Scope(proxyMode = TARGET_CLASS)` no prototype, resolveria o problema? Como?"

---

### Pergunta 30 — O que é e como usar a anotação @Value no Spring Boot?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, frequentemente precisamos ler valores de configuração (como URLs de banco de dados, chaves de API, etc.). Como você usa a anotação `@Value` para isso? Quais são suas limitações?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe usar `@Value` para injetar valores de propriedades, conhece a sintaxe com `${}` e SpEL com `#{}`, e se reconhece as limitações em comparação com `@ConfigurationProperties`.

**Resposta esperada:**  

A anotação `@Value` permite injetar valores de propriedades (do `application.properties`/`.yml`, variáveis de ambiente, argumentos de linha de comando) diretamente em campos, construtores ou métodos.

**Formas de uso:**

1. **Injeção de valor simples:**

```properties
# application.properties
app.nome=Minha Aplicação
app.versao=1.0.0
app.timeout=5000
```

```java
@Service
public class ConfigService {
    
    @Value("${app.nome}")
    private String nome;
    
    @Value("${app.versao}")
    private String versao;
    
    @Value("${app.timeout:3000}")  // valor padrão se não encontrar
    private int timeout;
    
    // Construtor com @Value (alternativa ao campo)
    public ConfigService(@Value("${app.nome}") String nome) {
        this.nome = nome;
    }
}
```

2. **Valor padrão com `:` (dois pontos):**

```java
@Value("${app.porta:8080}")  // se app.porta não existir, usa 8080
private int porta;

@Value("${app.url:http://localhost:8080}")
private String url;
```

3. **Tipos suportados:**  
O Spring converte automaticamente o valor string para o tipo do campo:

```java
@Value("${app.enabled:true}")
private boolean enabled;      // conversão para boolean

@Value("${app.max-connections:10}")
private int maxConnections;   // conversão para int

@Value("${app.duracao:30s}")
private Duration duracao;     // conversão para Duration (Spring Boot 3+)
```

4. **Listas e mapas:**

```properties
app.servers=server1,server2,server3
```

```java
@Value("${app.servers}")
private List<String> servers;
```

5. **SpEL (Spring Expression Language) com `#{}`:**

```java
@Value("#{systemProperties['user.home']}")
private String userHome;

@Value("#{T(java.lang.Math).random() * 100}")
private double numeroAleatorio;

@Value("#{environment['HOME']}")
private String homeDir;
```

**Limitações do `@Value`:**

1. **Não é type-safe** — é uma string; se o nome da propriedade mudar, o erro só aparece em runtime.
2. **Não suporta propriedades agrupadas** — se você tem 20 propriedades relacionadas, precisa de 20 `@Value`.
3. **Não gera metadados** — não aparece no autocomplete do IDE nem na documentação de configuração.
4. **Difícil de testar** — não há uma classe tipada para instanciar nos testes.

**Alternativa recomendada: `@ConfigurationProperties`:**

```java
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String nome;
    private String versao;
    private int timeout = 3000;
    private boolean enabled = true;
    private List<String> servers = new ArrayList<>();
    
    // getters e setters obrigatórios
}
```

**Explicação didática:**  
`@Value` é como anotar ingredientes em uma lista de compras com o preço diretamente ao lado: funciona, é rápido, mas se o preço muda, você precisa procurar cada anotação individualmente. O `@ConfigurationProperties` é como ter uma planilha organizada com todos os ingredientes e preços agrupados — mais estruturado, type-safe e fácil de manter quando a complexidade cresce.

**Como o candidato deve responder:**  
- Mostrar a sintaxe `${propriedade}` para leitura de propriedades.
- Explicar o uso de `:` para valor padrão.
- Mencionar conversão automática de tipos.
- Apontar as limitações do `@Value` e citar `@ConfigurationProperties` como alternativa melhor.
- Se possível, mencionar SpEL com `#{}`.

**Resposta fraca ou incompleta:**  
"`@Value` pega valores do properties."  
Falta: não mostra a sintaxe, não menciona valor padrão, não aponta limitações.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @Value |
| 1 | Sabe que "lê propriedades" mas não mostra sintaxe |
| 2 | Mostra sintaxe e valor padrão mas não conhece limitações |
| 3 | Explica sintaxe, tipos, valor padrão e limitações |
| 4 | Demonstra conhecimento de @ConfigurationProperties como alternativa |
| 5 | Responde com profundidade, menciona SpEL, validação com @Validated, metadados e boas práticas |

**Perguntas de aprofundamento:**
1. "Qual a diferença entre `${}` e `#{}` no `@Value`?"
2. "Quando você escolheria `@ConfigurationProperties` em vez de `@Value`?"
3. "Como você faria validação das propriedades carregadas com `@ConfigurationProperties`?"

---

### Pergunta 31 — Como você mapeia uma entidade JPA no Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot com Spring Data JPA, como você mapeia uma tabela do banco de dados para uma classe Java? Quais anotações são essenciais?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece as anotações básicas de mapeamento de entidades JPA (`@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`), entende a relação entre classe Java e tabela do banco, e sabe configurar o mapeamento de forma correta.

**Resposta esperada:**  
Para mapear uma tabela de banco de dados para uma classe Java, utilizamos as anotações do JPA (Jakarta Persistence API). As anotações essenciais são:

1. **`@Entity`** — marca a classe como uma entidade JPA, ou seja, diz ao Hibernate que essa classe representa uma tabela no banco de dados.

2. **`@Table`** — especifica o nome da tabela no banco. Se omitida, o JPA usa o nome da classe como nome da tabela.

3. **`@Id`** — marca o campo que é a chave primária da entidade.

4. **`@GeneratedValue`** — define a estratégia de geração do valor da chave primária (auto-incremento, sequence, etc.).

5. **`@Column`** — configura propriedades da coluna no banco (nome, nullable, length, unique, etc.). Se omitida, o JPA usa o nome do campo como nome da coluna.

**Explicação didática:**  
Pense na classe Java como um "molde" e na tabela do banco como a "forma física". As anotações JPA funcionam como etiquetas que dizem como cada atributo do molde se encaixa na forma física. `@Entity` diz "esta classe vira uma tabela", `@Id` diz "este campo é a chave primária", e `@Column` diz "este campo vira uma coluna com estas características".

**Exemplo de código:**

```java
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    // Construtor padrão (obrigatório pelo JPA)
    public Usuario() {}

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
```

**Estratégias de `@GeneratedValue`:**

| Estratégia | Descrição |
|------------|-----------|
| `IDENTITY` | Usa auto-incremento do banco (MySQL, PostgreSQL) |
| `SEQUENCE` | Usa uma sequence do banco (Oracle, PostgreSQL) |
| `TABLE` | Usa uma tabela auxiliar para simular sequence |
| `AUTO` | O provedor JPA escolhe a estratégia (padrão) |

**Como o candidato deve responder:**  
- Mencionar `@Entity` e `@Table` para marcar a classe e a tabela.
- Citar `@Id` e `@GeneratedValue` para a chave primária.
- Explicar `@Column` para configurar colunas.
- Mencionar a necessidade de construtor padrão (sem argumentos).
- Se possível, citar pelo menos duas estratégias de `@GeneratedValue`.

**Resposta fraca ou incompleta:**  
"Você usa `@Entity` em cima da classe."  
Falta: não menciona `@Id`, `@GeneratedValue`, `@Column`, não explica as estratégias, não cita construtor padrão.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe mapear entidade |
| 1 | Menciona apenas `@Entity` |
| 2 | Cita `@Entity` e `@Id` mas sem detalhar |
| 3 | Explica as anotações essenciais com exemplo |
| 4 | Demonstra prática com estratégias, `@Column` e construtor padrão |
| 5 | Responde com profundidade, menciona diferentes estratégias, boas práticas e variações por banco |

**Perguntas de aprofundamento:**
1. "Qual a diferença entre `GenerationType.IDENTITY` e `GenerationType.SEQUENCE`?"
2. "O que acontece se você esquecer o construtor padrão na entidade?"
3. "Como você mapearia um campo que não deve ser persistido no banco?"

---

### Pergunta 32 — Como funcionam os relacionamentos entre entidades no JPA?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em um sistema, um pedido pertence a um cliente, e um cliente pode ter vários pedidos. Como você mapeia esse relacionamento `@OneToMany` / `@ManyToOne` no JPA? E o que significam `mappedBy` e `cascade`?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe mapear relacionamentos entre entidades, entende a diferença entre o lado proprietário (*owning side*) e o lado inverso, conhece o atributo `mappedBy` e sabe usar o cascade.

**Resposta esperada:**  
O JPA mapeia relacionamentos entre tabelas através de anotações que indicam a cardinalidade e a direção do relacionamento.

**Principais anotações de relacionamento:**

| Anotação | Cardinalidade | Exemplo |
|----------|---------------|---------|
| `@OneToOne` | 1:1 | Usuário ↔ Perfil |
| `@OneToMany` | 1:N | Cliente → Pedidos |
| `@ManyToOne` | N:1 | Pedido → Cliente |
| `@ManyToMany` | N:N | Aluno ↔ Disciplinas |

**Lado proprietário vs. lado inverso:**  
Em um relacionamento bidirecional (1:N), existe o **lado proprietário** (que tem a chave estrangeira) e o **lado inverso** (que referencia o proprietário via `mappedBy`).

- `@ManyToOne` é geralmente o **lado proprietário** (tem a FK no banco).
- `@OneToMany` é o **lado inverso** (usa `mappedBy` para apontar para o proprietário).

**`mappedBy`** — diz ao JPA: "o relacionamento já é gerenciado pelo atributo X na outra entidade, não crie uma coluna extra aqui".

**`cascade`** — define quais operações se propagam do pai para os filhos:
- `CascadeType.PERSIST` — salva os filhos ao salvar o pai.
- `CascadeType.MERGE` — atualiza os filhos ao atualizar o pai.
- `CascadeType.REMOVE` — remove os filhos ao remover o pai.
- `CascadeType.ALL` — propaga todas as operações.

**Exemplo de código:**

```java
// Lado proprietário — Pedido tem a FK de Cliente
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    // @ManyToOne = muitos pedidos para um cliente
    // Lado proprietário do relacionamento (tem a FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id") // nome da FK no banco
    private Cliente cliente;

    // getters e setters...
    public Long getId() { return id; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}
```

```java
// Lado inverso — Cliente referencia os pedidos
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    // @OneToMany = um cliente para muitos pedidos
    // mappedBy = "cliente" → o atributo "cliente" em Pedido é o proprietário
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();

    // Helper methods para manter o relacionamento consistente
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.setCliente(this); // mantém a consistência bidirecional
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
        pedido.setCliente(null);
    }

    // getters e setters...
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Pedido> getPedidos() { return pedidos; }
}
```

**Explicação didática:**  
Imagine um cliente e seus pedidos. O **Pedido** é quem tem o "telefone" do cliente (a chave estrangeira `cliente_id`), então ele é o lado proprietário. O **Cliente** sabe que tem pedidos, mas não é ele quem guarda a FK — ele apenas "aponta" para o atributo `cliente` em Pedido através de `mappedBy`. Se você esquecer o `mappedBy`, o JPA criará uma tabela intermediária desnecessária.

**Como o candidato deve responder:**  
- Explicar `@ManyToOne` e `@OneToMany` para o cenário pedido-cliente.
- Mencionar que o lado com `@ManyToOne` é o proprietário (tem a FK).
- Explicar `mappedBy` como referência ao atributo do lado proprietário.
- Citar `@JoinColumn` para nomear a FK.
- Mencionar `cascade` e pelo menos um tipo (PERSIST, ALL, REMOVE).
- Se possível, mencionar os *helper methods* para consistência bidirecional.

**Resposta fraca ou incompleta:**  
"Você usa `@OneToMany` para relacionar."  
Falta: não explica `mappedBy`, não diferencia lado proprietário de inverso, não menciona `@JoinColumn` ou cascade.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe mapear relacionamentos |
| 1 | Menciona apenas uma anotação sem explicar |
| 2 | Cita `@OneToMany` e `@ManyToOne` mas não explica `mappedBy` |
| 3 | Explica lado proprietário, `mappedBy` e `@JoinColumn` |
| 4 | Demonstra prática com cascade, helper methods e bidirecionalidade |
| 5 | Responde com profundidade, menciona `orphanRemoval`, `FetchType` e trade-offs |

**Perguntas de aprofundamento:**
1. "Qual a diferença entre `FetchType.LAZY` e `FetchType.EAGER`? Quando usar cada um?"
2. "O que é o problema do N+1 em relacionamentos e como evitá-lo?"
3. "O que acontece se você esquecer o `mappedBy` no `@OneToMany`?"

---

### Pergunta 33 — Como você escreve consultas customizadas com @Query?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Os métodos derivados (`findByNome`, `findByEmailContaining`) são úteis, mas às vezes ficam verbosos demais ou não atendem casos complexos. Como você usa a anotação `@Query` para escrever consultas customizadas no Spring Data JPA?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe usar `@Query` com JPQL e SQL nativo, entende a diferença entre os dois, conhece o uso de parâmetros nomeados (`:nome`) e posicionais (`?1`), e sabe quando preferir `@Query` em vez de métodos derivados.

**Resposta esperada:**  
A anotação `@Query` permite escrever consultas personalizadas diretamente no repository, contornando as limitações dos métodos derivados. Existem duas abordagens:

**1. JPQL (Java Persistence Query Language):**  
JPQL é uma linguagem de consulta orientada a objetos — você consulta entidades (ex: `Usuario`) e atributos Java (ex: `u.nome`), não tabelas e colunas. É o padrão do `@Query`.

```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // JPQL — consulta a entidade Usuario, não a tabela usuarios
    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.ativo = true")
    Optional<Usuario> buscarEmailAtivo(@Param("email") String email);

    // JPQL com JOIN (relacionamento)
    @Query("SELECT p FROM Pedido p JOIN p.cliente c WHERE c.nome LIKE %:nomeCliente%")
    List<Pedido> buscarPedidosPorNomeCliente(@Param("nomeCliente") String nomeCliente);

    // JPQL com agregação
    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.ativo = true")
    long contarUsuariosAtivos();

    // JPQL com ORDER BY
    @Query("SELECT u FROM Usuario u WHERE u.ativo = :ativo ORDER BY u.nome ASC")
    List<Usuario> buscarPorStatusOrdenado(@Param("ativo") boolean ativo);
}
```

**2. SQL Nativo:**  
Usa SQL puro do banco de dados. Útil quando você precisa de funções específicas do SGBD ou de consultas que o JPQL não suporta. Ativa-se com `nativeQuery = true`.

```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // SQL nativo — consulta a tabela usuarios diretamente
    @Query(value = "SELECT * FROM usuarios WHERE DATE(data_criacao) = CURRENT_DATE",
           nativeQuery = true)
    List<Usuario> buscarCriadosHoje();

    // SQL nativo com parâmetro
    @Query(value = "SELECT * FROM usuarios WHERE email LIKE %:dominio%",
           nativeQuery = true)
    List<Usuario> buscarPorDominioEmail(@Param("dominio") String dominio);
}
```

**Diferenças entre JPQL e SQL nativo:**

| Aspecto | JPQL | SQL Nativo |
|---------|------|------------|
| Consulta | Entidades e atributos Java | Tabelas e colunas do banco |
| Portabilidade | Independente de SGBD | Depende do SGBD |
| Conversão | Automática para entidades | Mapeamento manual se necessário |
| Funções do banco | Limitadas | Todas disponíveis |
| Quando usar | Maioria dos casos | Funções específicas do banco |

**Parâmetros:**  
- `@Param("nome")` — associa o parâmetro Java ao parâmetro `:nome` na query.
- Em Spring Data JPA 3.x+ (Spring Boot 3+), se o parâmetro for anotado com `@Param`, o nome corresponde. Sem `@Param` (se `-parameters` estiver habilitado na compilação), o nome do parâmetro do método é usado diretamente.

**Explicação didática:**  
JPQL é como perguntar "quais usuários estão ativos?" — você pensa em objetos, não em tabelas. SQL nativo é como perguntar diretamente ao banco "me traga as linhas da tabela usuarios onde a coluna ativo = true". JPQL é portável entre bancos; SQL nativo é atrelado ao banco específico.

**Quando usar `@Query` vs. métodos derivados:**
- **Método derivado:** consultas simples, 1–3 condições.
- **`@Query`:** consultas com JOIN, agregações, subqueries, ou quando o nome do método ficaria ilegível.

**Como o candidato deve responder:**  
- Explicar que `@Query` permite consultas customizadas no repository.
- Diferenciar JPQL (orientado a entidades) de SQL nativo (`nativeQuery = true`).
- Mostrar uso de `@Param` para parâmetros nomeados.
- Citar pelo menos um exemplo de JPQL e um de SQL nativo.
- Mencionar quando preferir `@Query` vs. métodos derivados.

**Resposta fraca ou incompleta:**  
"Você coloca `@Query` em cima do método com um SQL."  
Falta: não diferencia JPQL de SQL nativo, não menciona `@Param`, não explica quando usar.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece `@Query` |
| 1 | Sabe que existe mas não sabe usar |
| 2 | Usa `@Query` mas não diferencia JPQL de nativo |
| 3 | Explica JPQL vs. nativo com exemplos e `@Param` |
| 4 | Demonstra prática com JOIN, agregações e critérios de escolha |
| 5 | Responde com profundidade, menciona `@Modifying`, projeções, DTOs via projection |

**Perguntas de aprofundamento:**
1. "Como você faria uma consulta que atualiza ou deleta registros com `@Query`?"
2. "O que é uma Projection no Spring Data JPA e quando usá-la?"
3. "Se você precisar de uma query muito complexa, vale a pena usar `@Query` ou outra abordagem?"

---

### Pergunta 34 — Como funciona a paginação e ordenação no Spring Data JPA?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Se você tem uma tabela com milhares de registros e precisa exibi-los em uma API REST, não pode retornar tudo de uma vez. Como você implementa paginação e ordenação no Spring Data JPA?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece `Pageable`, `PageRequest`, `Sort`, `Page` e `Slice`, sabe implementar endpoints paginados e entende como retornar metadados de paginação.

**Resposta esperada:**  
O Spring Data JPA oferece suporte nativo a paginação e ordenação através da interface `Pageable`. O processo funciona em três partes:

**1. Repository — aceitar `Pageable` como parâmetro:**

```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Métodos herdados do JpaRepository já suportam Pageable:
    // Page<Usuario> findAll(Pageable pageable);

    // Métodos customizados também suportam:
    Page<Usuario> findByAtivoTrue(Pageable pageable);
}
```

**2. Camada de serviço — criar o `Pageable`:**

```java
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Page<Usuario> listarUsuarios(int pagina, int tamanho, String ordenacao) {
        // PageRequest.of(página, tamanho, Sort)
        // Página começa em 0 (zero-based)
        Pageable pageable = PageRequest.of(
            pagina,
            tamanho,
            Sort.by(ordenacao).ascending()
        );
        return repository.findAll(pageable);
    }

    // Com múltiplas ordenações
    public Page<Usuario> listarComMultiplaOrdenacao(int pagina, int tamanho) {
        Pageable pageable = PageRequest.of(
            pagina,
            tamanho,
            Sort.by("nome").ascending()
                .and(Sort.by("email").descending())
        );
        return repository.findAll(pageable);
    }
}
```

**3. Controller — expor como endpoint REST:**

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Exemplo: GET /api/usuarios?pagina=0&tamanho=10&ordenacao=nome
    @GetMapping
    public Page<UsuarioDTO> listar(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho,
            @RequestParam(defaultValue = "nome") String ordenacao) {
        return service.listarUsuarios(pagina, tamanho, ordenacao)
                      .map(this::toDTO);
    }

    // Spring também aceita Pageable diretamente como parâmetro:
    // GET /api/usuarios?page=0&size=10&sort=nome,asc
    @GetMapping("/auto")
    public Page<UsuarioDTO> listarAuto(Pageable pageable) {
        return repository.findAll(pageable).map(this::toDTO);
    }

    private UsuarioDTO toDTO(Usuario u) {
        return new UsuarioDTO(u.getId(), u.getNome(), u.getEmail());
    }
}
```

**Estrutura do objeto `Page` retornado:**

```json
{
    "content": [
        { "id": 1, "nome": "Ana", "email": "ana@email.com" },
        { "id": 2, "nome": "Bruno", "email": "bruno@email.com" }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10
    },
    "totalElements": 25,
    "totalPages": 3,
    "number": 0,
    "size": 10,
    "first": true,
    "last": false,
    "numberOfElements": 10
}
```

**`Page` vs. `Slice`:**

| Tipo | Descrição | Quando usar |
|------|-----------|-------------|
| `Page<T>` | Retorna metadados completos (total de elementos, total de páginas) | Quando o cliente precisa saber o total |
| `Slice<T>` | Retorna apenas se há próxima página (sem contar o total) | Para scroll infinito, quando o total é custoso de calcular |

**Explicação didática:**  
`Pageable` é como um "controle remoto" que diz ao Spring Data: "me traga a página X, com Y itens, ordenados por Z". O Spring Data traduz isso para `LIMIT` e `OFFSET` no SQL automaticamente. O objeto `Page` retornado inclui não apenas os dados (`content`), mas também metadados como total de registros e total de páginas — tudo pronto para a UI.

**Como o candidato deve responder:**  
- Mencionar `Pageable` e `PageRequest.of()`.
- Explicar que páginas começam em 0 (zero-based).
- Mostrar o uso de `Sort` para ordenação.
- Explicar que o repositório aceita `Pageable` como parâmetro.
- Mencionar que o Spring pode receber `Pageable` diretamente no controller.
- Se possível, citar a diferença entre `Page` e `Slice`.

**Resposta fraca ou incompleta:**  
"Você usa `LIMIT` e `OFFSET` na query."  
Falta: não conhece a abstração `Pageable` do Spring Data, não menciona `PageRequest` ou `Sort`.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe paginar |
| 1 | Menciona LIMIT/OFFSET manualmente |
| 2 | Conhece `Pageable` mas não explica como usar |
| 3 | Explica `PageRequest`, `Sort` e retorno `Page` com exemplo |
| 4 | Demonstra prática com controller, parâmetros via URL e DTO |
| 5 | Responde com profundidade, menciona `Slice` vs `Page`, defaults e personalização |

**Perguntas de aprofundamento:**
1. "Qual a diferença entre `Page` e `Slice`? Quando você usaria cada um?"
2. "Como você limitaria o tamanho máximo de página que um cliente pode solicitar?"
3. "Como o Spring Data JPA gera o SQL de paginação para PostgreSQL vs. MySQL?"

---

### Pergunta 35 — O que é e como funciona o @Transactional?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Em um serviço que cadastra um usuário e cria um registro de auditoria, é importante que ambas as operações ocorram com sucesso — ou nenhuma. Como o `@Transactional` garante isso? Como ele funciona?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o conceito de transação, sabe usar `@Transactional`, conhece os tipos de propagação e isolation, e compreende o comportamento de rollback.

**Resposta esperada:**  
`@Transactional` é uma anotação do Spring que define um **limite de transação** — tudo o que executa dentro do método anotado ocorre em uma única transação do banco de dados. Se algo der errado, todas as operações são desfeitas (rollback); se tudo der certo, todas são confirmadas (commit).

**Como funciona:**

1. O Spring cria um **proxy** em torno da classe ou método anotado.
2. Quando o método é chamado, o proxy **inicia uma transação** no banco.
3. Todas as operações JPA/Hibernate dentro do método usam essa transação.
4. Se o método termina sem exceção → **commit** (confirma).
5. Se uma exceção *unchecked* (`RuntimeException`) é lançada → **rollback** (desfaz).
6. Exceções *checked* não causam rollback por padrão.

**Exemplo de código:**

```java
@Service
public class CadastroService {

    private final UsuarioRepository usuarioRepository;
    private final AuditoriaRepository auditoriaRepository;

    public CadastroService(UsuarioRepository usuarioRepository,
                           AuditoriaRepository auditoriaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.auditoriaRepository = auditoriaRepository;
    }

    // Se salvarUsuario OU salvarAuditoria falhar, ambas são desfeitas
    @Transactional
    public Usuario cadastrar(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail());
        usuarioRepository.save(usuario); // operação 1

        Auditoria audit = new Auditoria("CADASTRO_USUARIO", usuario.getId());
        auditoriaRepository.save(audit); // operação 2

        return usuario;
    }
}
```

**Propriedades importantes:**

| Propriedade | Descrição | Valor padrão |
|-------------|-----------|--------------|
| `rollbackFor` | Exceções que causam rollback | `RuntimeException` e `Error` |
| `noRollbackFor` | Exceções que NÃO causam rollback | — |
| `propagation` | Como a transação se propaga | `REQUIRED` |
| `isolation` | Nível de isolamento | `DEFAULT` (do banco) |
| `readOnly` | Otimiza a transação para leitura | `false` |
| `timeout` | Tempo máximo em segundos | `-1` (sem timeout) |

**Propagação (`propagation`) mais comum:**

- `REQUIRED` (padrão) — usa a transação existente; se não há, cria uma nova.
- `REQUIRES_NEW` — sempre cria uma nova transação, suspendendo a existente.
- `SUPPORTS` — usa a transação existente; se não há, executa sem transação.
- `MANDATORY` — exige uma transação existente; se não há, lança exceção.

**Exemplo com propriedades customizadas:**

```java
@Transactional(
    rollbackFor = {SQLException.class, IOException.class}, // rollback também para checked
    readOnly = true,          // otimização para consultas
    timeout = 30,             // timeout de 30 segundos
    isolation = Isolation.READ_COMMITTED
)
public List<Usuario> listarUsuarios() {
    return usuarioRepository.findAll();
}
```

**Explicação didática:**  
`@Transactional` é como um "contrato": ou tudo acontece, ou nada acontece. Imagine uma transferência bancária — se o débito funciona mas o crédito falha, o dinheiro some. A transação garante que, se qualquer passo falhar, tudo volta ao estado anterior, como se nada tivesse acontecido.

**Como o candidato deve responder:**  
- Explicar que `@Transactional` define um limite de transação.
- Mencionar que se uma operação falha, todas são desfeitas (rollback).
- Explicar o comportamento padrão: rollback para `RuntimeException`, commit caso contrário.
- Citar `readOnly = true` para consultas.
- Mencionar que deve ser aplicado na camada de serviço, não no controller.
- Se possível, citar `rollbackFor` para incluir exceções checked.

**Resposta fraca ou incompleta:**  
"`@Transactional` faz o método rodar como transação."  
Falta: não explica rollback, não menciona o comportamento com exceções, não cita propriedades.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é `@Transactional` |
| 1 | Sabe que "faz transação" mas não explica rollback |
| 2 | Explica rollback mas não menciona exceções checked vs. unchecked |
| 3 | Explica rollback, commit, readOnly e onde aplicar (service layer) |
| 4 | Demonstra prática com `rollbackFor` e propagação |
| 5 | Responde com profundidade, menciona proxy, isolation levels e armadilhas comuns |

**Perguntas de aprofundamento:**
1. "O que acontece se você chamar um método `@Transactional` de dentro da mesma classe?"
2. "Por que exceções checked não causam rollback por padrão? Como mudar isso?"
3. "Qual a diferença entre `REQUIRED` e `REQUIRES_NEW`? Quando usar cada um?"

---

### Pergunta 36 — O que são e como usar migrations de banco de dados?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em um projeto com múltiplos desenvolvedores trabalhando no mesmo banco de dados, como você garante que a estrutura do banco esteja sincronizada? O que são migrations e como elas funcionam?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o conceito de migrations de banco de dados, sabe usar ferramentas como Flyway ou Liquibase, e entende a importância do versionamento de schema.

**Resposta esperada:**  
Migrations (migrações) são scripts versionados que controlam a evolução da estrutura do banco de dados de forma controlada e reproduzível. Em vez de criar tabelas manualmente ou usar `hibernate.hbm2ddl.auto=update` (que é perigoso em produção), as migrations garantem que:

- A estrutura do banco seja a mesma em todos os ambientes (dev, test, prod).
- Mudanças sejam aplicadas na ordem correta.
- Exista um histórico auditar de alterações.
- Múltiplos desenvolvedores possam colaborar sem conflitos.

**Ferramentas mais comuns no Spring Boot:**

| Ferramenta | Descrição |
|------------|-----------|
| **Flyway** | Abordagem baseada em scripts SQL versionados |
| **Liquibase** | Abordagem baseada em XML/YAML/JSON, independente de SGBD |

**Flyway no Spring Boot:**

1. **Adicionar a dependência:**

```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```

2. **Configurar:**

```properties
# application.properties
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.baseline-on-migrate=true
```

3. **Criar scripts de migration:**  
Os scripts seguem a convenção `V{versão}__{descrição}.sql` (para Flyway):

```
src/main/resources/db/migration/
├── V1__criar_tabela_usuarios.sql
├── V2__adicionar_coluna_telefone.sql
├── V3__criar_tabela_pedidos.sql
└── V4__adicionar_indice_email.sql
```

**Exemplo de migration:**

```sql
-- V1__criar_tabela_usuarios.sql
CREATE TABLE usuarios (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

```sql
-- V2__adicionar_coluna_telefone.sql
ALTER TABLE usuarios ADD COLUMN telefone VARCHAR(20);
```

**Como funciona:**
- Na inicialização da aplicação, o Flyway verifica a tabela `flyway_schema_history` (que ele cria automaticamente) para saber quais migrations já foram aplicadas.
- Aplica apenas as migrations que ainda não foram executadas, na ordem das versões.
- Cada migration é executada dentro de uma transação — se falhar, é desfeita.

**Por que NÃO usar `hibernate.hbm2ddl.auto=update` em produção:**
- Pode dropar colunas e dados se a entidade mudar.
- Não há histórico de mudanças.
- Não é reproduzível entre ambientes.
- Não há controle sobre a ordem das alterações.

**Explicação didática:**  
Migrations são como um "diário de bordo" do banco de dados. Cada alteração (criar tabela, adicionar coluna, criar índice) é registrada como uma entrada com data e versão. Quando um novo desenvolvedor entra no projeto, ele roda as migrations e o banco fica idêntico ao de todos os outros — sem precisar de scripts manuais.

**Como o candidato deve responder:**  
- Explicar que migrations são scripts versionados de evolução do schema.
- Citar Flyway ou Liquibase como ferramentas.
- Mencionar a convenção de nomes (`V1__descricao.sql`).
- Explicar que as migrations rodam automaticamente na inicialização.
- Mencionar que `hbm2ddl.auto=update` não deve ser usado em produção.

**Resposta fraca ou incompleta:**  
"Você cria as tabelas com `hibernate.hbm2ddl.auto=update`."  
Falta: não conhece migrations, não menciona Flyway/Liquibase, não entende os riscos do `update` automático.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que são migrations |
| 1 | Menciona `hbm2ddl.auto` mas não conhece Flyway/Liquibase |
| 2 | Conhece o conceito mas não sabe configurar |
| 3 | Explica Flyway/Liquibase com convenção de nomes e exemplo |
| 4 | Demonstra prática com configuração, múltiplas migrations e riscos do hbm2ddl |
| 5 | Responde com profundidade, menciona baseline, rollback, ambientes e boas práticas |

**Perguntas de aprofundamento:**
1. "O que acontece se duas migrations tiverem a mesma versão?"
2. "Como você faria um rollback de uma migration que já foi aplicada em produção?"
3. "Qual a diferença entre Flyway e Liquibase? Quando preferir um ou outro?"

---

### Pergunta 37 — Como e quando usar o banco H2 em projetos Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Você provavelmente já usou o banco H2 em projetos Spring Boot. O que é o H2, quando usá-lo e quais os cuidados ao trabalhar com ele?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o H2 como banco em memória, sabe configurá-lo, entende quando é apropriado usá-lo (testes, desenvolvimento) e quais são seus limites.

**Resposta esperada:**  
O **H2** é um banco de dados relacional escrito em Java, que pode rodar **em memória** (*in-memory*) ou em arquivo. É muito leve e rápido, sendo amplamente usado em Spring Boot para:

1. **Desenvolvimento local** — subir a aplicação sem precisar instalar um banco de dados externo.
2. **Testes automatizados** — cada teste roda com um banco limpo e isolado.

**Configuração:**

```properties
# application.properties (dev/test)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Habilita o console web do H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Opcional: como o H2 cria os schemas
spring.jpa.hibernate.ddl-auto=create-drop
```

**Dependência Maven:**

```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

**Console H2:**  
O H2 oferece um console web acessível em `http://localhost:8080/h2-console` (quando habilitado), onde você pode executar queries, ver tabelas e dados.

**Modos de operação:**

| Modo | URL | Descrição |
|------|-----|-----------|
| Em memória | `jdbc:h2:mem:nomedb` | Dados perdidos ao desligar |
| Arquivo | `jdbc:h2:file:./data/nomedb` | Dados persistidos em arquivo |
| Servidor | `jdbc:h2:tcp://localhost/~/nomedb` | Acessível por múltiplas conexões |

**Cuidados importantes:**

1. **NÃO usar em produção** — o H2 não é projetado para carga de produção. Use PostgreSQL, MySQL, Oracle, etc.
2. **Compatibilidade de SQL** — o H2 tem algumas diferenças de sintaxe em relação a PostgreSQL/MySQL. Uma query que funciona no H2 pode falhar no banco de produção.
3. **`ddl-auto=create-drop`** — destroi e recria o schema a cada inicialização. Útil em testes, perigoso em produção.
4. **Isolamento de testes** — cada teste deve ter seu próprio banco em memória para evitar interferência.

**Exemplo de uso em testes:**

```java
@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void deveBuscarPorEmail() {
        // Arrange — o H2 em memória está disponível automaticamente
        Usuario usuario = new Usuario("Ana", "ana@email.com");
        entityManager.persist(usuario);
        entityManager.flush();

        // Act
        Optional<Usuario> encontrado = repository.findByEmail("ana@email.com");

        // Assert
        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getNome()).isEqualTo("Ana");
    }
}
```

**Explicação didática:**  
O H2 em memória é como uma "lousa branca" — você escreve (persiste dados), usa para testar, e quando apaga (desliga a aplicação), tudo some. É perfeito para testes porque é rápido, isolado e não deixa rastros. Mas não é uma "prancheta arquivada" (banco de produção) — não guarde dados importantes nele.

**Como o candidato deve responder:**  
- Explicar que o H2 é um banco em memória (ou arquivo), escrito em Java.
- Mencionar que é usado para desenvolvimento e testes.
- Mostrar a configuração básica (URL, driver, console).
- Deixar claro que não deve ser usado em produção.
- Mencionar que o `@DataJpaTest` usa H2 automaticamente.

**Resposta fraca ou incompleta:**  
"H2 é um banco de dados que vem no Spring Boot."  
Falta: não explica que é em memória, não menciona casos de uso, não avisa sobre não usar em produção.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é H2 |
| 1 | Sabe que "é um banco" mas não explica |
| 2 | Menciona em memória mas não sabe configurar |
| 3 | Explica configuração, casos de uso e limitações |
| 4 | Demonstra prática com testes, console e `@DataJpaTest` |
| 5 | Responde com profundidade, menciona compatibilidade de SQL, modos e boas práticas |

**Perguntas de aprofundamento:**
1. "Como você garantiria que os testes com H2 sejam compatíveis com PostgreSQL em produção?"
2. "É possível usar H2 em modo arquivo para persistir dados entre reinicializações? Vale a pena?"
3. "Como você configuraria profiles para usar H2 em dev e PostgreSQL em produção?"

---

### Pergunta 38 — O que é o HikariCP e qual seu papel no Spring Boot?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"O Spring Boot usa o HikariCP como pool de conexões por padrão. O que é um pool de conexões e por que ele é importante? Quais configurações básicas você conhece do HikariCP?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o conceito de pool de conexões, sabe que o HikariCP é o pool padrão do Spring Boot, e conhece as principais propriedades de configuração.

**Resposta esperada:**  
Um **pool de conexões** é um conjunto de conexões de banco de dados pré-criadas e reutilizadas. Em vez de criar uma nova conexão a cada request (o que é lento e custoso), o pool mantém conexões abertas e as empresta para a aplicação quando necessário.

**Por que é importante:**
- Criar uma conexão TCP com o banco envolve handshake, autenticação e alocação de recursos — operações caras (dezenas a centenas de milissegundos).
- Reutilizar conexões reduz drasticamente o tempo de resposta.
- Limita o número máximo de conexões, evitando sobrecarregar o banco.

**HikariCP** é o pool de conexões padrão do Spring Boot desde a versão 2.0. É conhecido por ser extremamente rápido e leve, com código otimizado e configurações sensatas por padrão.

**Configuração básica:**

```properties
# application.properties

# Tamanho máximo do pool (padrão: 10)
spring.datasource.hikari.maximum-pool-size=10

# Tempo mínimo que uma conexão pode ficar idle antes de ser removida (padrão: 600000ms = 10min)
spring.datasource.hikari.minimum-idle=5

# Tempo máximo de espera para obter uma conexão do pool (padrão: 30000ms = 30s)
spring.datasource.hikari.connection-timeout=30000

# Tempo máximo que uma conexão pode ficar aberta (padrão: 1800000ms = 30min)
spring.datasource.hikari.max-lifetime=1800000

# Tempo máximo que uma conexão pode ficar sem uso antes de ser fechada (padrão: 600000ms = 10min)
spring.datasource.hikari.idle-timeout=600000

# Query para testar se a conexão está ativa (ex: PostgreSQL)
spring.datasource.hikari.connection-test-query=SELECT 1

# Nome do pool (para identificação em logs e JMX)
spring.datasource.hikari.pool-name=MeuPoolHikari
```

**Como funciona na prática:**

```
[Aplicação] → [HikariCP Pool] → [Banco de Dados]
                  ↓
            ┌─────────────┐
            │ Conexão 1   │ → emprestada para request A
            │ Conexão 2   │ → emprestada para request B
            │ Conexão 3   │ → disponível
            │ ...         │
            │ Conexão 10  │ → disponível
            └─────────────┘
```

Quando um request precisa acessar o banco:
1. Pede uma conexão ao pool.
2. Se há conexão disponível → recebe imediatamente.
3. Se todas estão em uso → espera até `connection-timeout`.
4. Se o timeout expira → lança `SQLTransientConnectionException`.
5. Ao terminar de usar, a conexão é **devolvida** ao pool (não fechada).

**Explicação didática:**  
Imagine que as conexões de banco são como bicicletas de um aplicativo de aluguel. Sem pool, cada usuário compra uma bicicleta nova (cria conexão), usa e joga fora (fecha conexão) — caro e lento. Com pool, há um estande com 10 bicicletas prontas: cada usuário pega uma, usa e devolve. Se todas estão em uso, o próximo usuário espera até uma ficar disponível.

**Como o candidato deve responder:**  
- Explicar que um pool de conexões mantém conexões reutilizáveis.
- Mencionar que o HikariCP é o pool padrão do Spring Boot.
- Explicar a vantagem: evitar o custo de criar/destruir conexões.
- Citar pelo menos 2–3 propriedades de configuração (maximum-pool-size, connection-timeout).
- Mencionar o comportamento quando o pool está esgotado (timeout/exception).

**Resposta fraca ou incompleta:**  
"HikariCP é o gerenciador de conexões do Spring Boot."  
Falta: não explica o conceito de pool, não menciona propriedades, não explica o benefício de reutilização.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é pool de conexões |
| 1 | Sabe que "gerencia conexões" mas não explica como |
| 2 | Explica o conceito de pool mas não cita propriedades |
| 3 | Explica pool, HikariCP como padrão e cita propriedades |
| 4 | Demonstra prática com configurações e comportamento do pool |
| 5 | Responde com profundidade, menciona sizing, monitoring e trade-offs |

**Perguntas de aprofundamento:**
1. "Como você decidiria o tamanho ideal do `maximum-pool-size` para sua aplicação?"
2. "O que acontece quando todas as conexões do pool estão em uso e uma nova request chega?"
3. "Como você monitoraria se o pool de conexões está saudável em produção?"

---

### Pergunta 39 — Cenário: aplicação lenta ao carregar lista de entidades com relacionamento

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
"Você tem uma entidade `Pedido` com um relacionamento `@ManyToOne` para `Cliente`, e o `FetchType` está como `EAGER`. Ao listar 100 pedidos, você percebe que a aplicação está muito lenta. O que pode estar acontecendo e como você resolveria?"

**O que essa pergunta avalia:**  
Avalia se o candidato identifica o problema do **N+1 selects** — quando o JPA/Hibernate executa 1 query para buscar a lista principal e N queries adicionais para buscar cada entidade relacionada. É um dos problemas mais comuns em aplicações Spring Boot com JPA.

**Resposta esperada:**  
Este é o clássico problema do **N+1 selects**. Com `FetchType.EAGER` em um `@ManyToOne`, o Hibernate busca cada `Cliente` individualmente para cada `Pedido`, resultando em:

- 1 query: `SELECT * FROM pedidos` (retorna 100 pedidos)
- 100 queries: `SELECT * FROM clientes WHERE id = ?` (uma para cada pedido)

Total: **101 queries** em vez de 1.

**Diagnóstico:**
- Ativar o log de SQL para ver as queries executadas:

```properties
# Mostra o SQL gerado pelo Hibernate
spring.jpa.show-sql=true

# Formata o SQL para leitura
spring.jpa.properties.hibernate.format_sql=true

# Mostra parâmetros das queries (logging de nível TRACE)
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.orm.jdbc.bind=TRACE
```

No log, você verá a query inicial seguida de dezenas de queries repetidas para a tabela `clientes`.

**Soluções:**

**1. Mudar para `FetchType.LAZY` (recomendado):**

```java
@Entity
@Table(name = "pedidos")
public class Pedido {

    // LAZY: só carrega o Cliente quando for efetivamente acessado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
```

Com `LAZY`, o Hibernate usa um proxy e só busca o `Cliente` quando `pedido.getCliente()` é chamado. Mas atenção: se você iterar sobre os pedidos e acessar o cliente de cada um, ainda terá N+1.

**2. Usar `JOIN FETCH` na query:**

```java
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // JOIN FETCH: carrega pedidos e clientes em uma única query
    @Query("SELECT p FROM Pedido p JOIN FETCH p.cliente")
    List<Pedido> findAllComCliente();

    // Com paginação:
    @Query("SELECT p FROM Pedido p JOIN FETCH p.cliente",
           countQuery = "SELECT count(p) FROM Pedido p")
    Page<Pedido> findAllComCliente(Pageable pageable);
}
```

Isso gera um único SQL com `JOIN`:

```sql
SELECT p.*, c.*
FROM pedidos p
INNER JOIN clientes c ON p.cliente_id = c.id
```

**3. Usar `@EntityGraph`:**

```java
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Define explicitamente quais relacionamentos carregar no JOIN
    @EntityGraph(attributePaths = "cliente")
    @Query("SELECT p FROM Pedido p")
    List<Pedido> findAllComCliente();
}
```

O `@EntityGraph` é uma alternativa declarativa ao `JOIN FETCH`, útil quando você tem múltiplos relacionamentos.

**Comparação das soluções:**

| Solução | Queries executadas | Quando usar |
|---------|---------------------|------------|
| `EAGER` (problema) | 1 + N | Nunca para coleções |
| `LAZY` (sem acesso) | 1 | Quando não acessa o relacionamento |
| `LAZY` + `JOIN FETCH` | 1 | Quando precisa do relacionamento |
| `LAZY` + `@EntityGraph` | 1 | Alternativa ao JOIN FETCH |

**Explicação didática:**  
O problema N+1 é como pedir pizza para 10 amigos: em vez de fazer um único pedido com 10 pizzas, você faz 10 pedidos separados — cada um com o custo de uma entrega. O `JOIN FETCH` é como fazer um único pedido com todas as pizzas — uma viagem só.

**Como o candidato deve responder:**  
- Identificar o problema como N+1 selects.
- Explicar o mecanismo: 1 query para a lista + N queries para o relacionamento.
- Sugerir `FetchType.LAZY` como padrão.
- Propor `JOIN FETCH` ou `@EntityGraph` como solução.
- Mencionar como diagnosticar (ativar log de SQL).

**Resposta fraca ou incompleta:**  
"A query está lenta, talvez precise de um índice."  
Falta: não identifica o problema N+1, não menciona `FetchType` ou `JOIN FETCH`.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe identificar o problema |
| 1 | Menciona "query lenta" mas não sabe a causa |
| 2 | Identifica N+1 mas não sabe resolver |
| 3 | Explica N+1 e propõe LAZY + JOIN FETCH |
| 4 | Demonstra prática com `@EntityGraph`, paginação e diagnóstico |
| 5 | Responde com profundidade, menciona `@BatchSize`, `Hibernate.default_batch_fetch_size` e trade-offs |

**Perguntas de aprofundamento:**
1. "Qual a diferença entre `JOIN FETCH` e `@EntityGraph`? Quando preferir um ou outro?"
2. "Se você usar `FetchType.LAZY` e acessar o relacionamento fora de uma transação, o que acontece?"
3. "O que é o `@BatchSize` do Hibernate e como ele ajuda com o problema N+1?"

---

### Pergunta 40 — Cenário: transação não funciona ao chamar método interno

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
"Você tem uma classe de serviço com dois métodos: `processar()` e `salvar()`. O método `processar()` não tem `@Transactional`, mas chama `salvar()`, que tem `@Transactional`. No entanto, a transação não funciona — os dados não são salvos. Você consegue explicar o que está acontecendo?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o problema do **self-invocation** (chamada interna) no Spring, que impede que o proxy intercepte a chamada e aplique o comportamento transacional. É um dos erros mais comuns com `@Transactional`.

**Resposta esperada:**  
O problema é o **self-invocation** (chamada interna). O Spring implementa `@Transactional` através de um **proxy** que envolve a classe. Quando um método é chamado **de fora** da classe, o proxy intercepta a chamada e inicia a transação. Mas quando um método chama **outro método da mesma classe**, a chamada é interna e **não passa pelo proxy** — portanto, o `@Transactional` é ignorado.

**Código com o problema:**

```java
@Service
public class PedidoService {

    // Método SEM @Transactional — chamado de fora (pelo controller)
    public void processar(PedidoDTO dto) {
        // Validações, lógica de negócio...
        Pedido pedido = new Pedido(dto.getValor());
        this.salvar(pedido); // ← CHAMADA INTERNA — não passa pelo proxy!
        // @Transactional do salvar() é IGNORADO
    }

    @Transactional
    public void salvar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}
```

**Por que acontece:**
- O Spring cria um proxy em torno de `PedidoService`.
- Quando o controller chama `pedidoService.processar()`, o proxy intercepta.
- Mas `processar()` não tem `@Transactional`, então nenhuma transação é iniciada.
- Dentro de `processar()`, `this.salvar()` é uma chamada direta (sem proxy), então `@Transactional` em `salvar()` não tem efeito.

**Soluções:**

**1. Mover `@Transactional` para o método chamador (recomendado):**

```java
@Service
public class PedidoService {

    @Transactional // ← Transação no método de entrada
    public void processar(PedidoDTO dto) {
        // Validações, lógica de negócio...
        Pedido pedido = new Pedido(dto.getValor());
        salvar(pedido); // agora está dentro da transação de processar()
    }

    // @Transactional removido — não é mais necessário
    private void salvar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}
```

**2. Usar autoinjeção (self-injection):**

```java
@Service
public class PedidoService {

    @Autowired
    @Lazy // evita dependência circular
    private PedidoService self;

    public void processar(PedidoDTO dto) {
        Pedido pedido = new Pedido(dto.getValor());
        self.salvar(pedido); // ← passa pelo proxy!
    }

    @Transactional
    public void salvar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}
```

**3. Usar `AopContext.currentProxy()`:**

```java
@Service
public class PedidoService {

    public void processar(PedidoDTO dto) {
        Pedido pedido = new Pedido(dto.getValor());
        // Chama via proxy atual — precisa de @EnableAspectJAutoProxy(exposeProxy = true)
        ((PedidoService) AopContext.currentProxy()).salvar(pedido);
    }

    @Transactional
    public void salvar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}
```

**4. Extrair para outra classe (boa prática de design):**

```java
@Service
public class PedidoService {

    private final SalvarPedidoService salvarService;

    public PedidoService(SalvarPedidoService salvarService) {
        this.salvarService = salvarService;
    }

    public void processar(PedidoDTO dto) {
        Pedido pedido = new Pedido(dto.getValor());
        salvarService.salvar(pedido); // ← chamada entre beans — passa pelo proxy
    }
}

@Service
public class SalvarPedidoService {

    @Transactional
    public void salvar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}
```

**Explicação didática:**  
Imagine que o proxy é um porteiro que verifica a entrada de cada apartamento. Quando alguém de fora toca a campainha, o porteiro atende. Mas quando alguém que já está dentro do apartamento vai para outro cômodo, o porteiro não é acionado — a movimentação é interna. O `@Transactional` só funciona quando o "porteiro" (proxy) é acionado.

**Como o candidato deve responder:**  
- Identificar o problema como self-invocation (chamada interna).
- Explicar que o Spring usa proxies e que chamadas internas não passam pelo proxy.
- Propor pelo menos uma solução (mover `@Transactional`, self-injection ou extrair classe).
- Mencionar que `@Transactional` deve estar no método de entrada (camada de serviço).

**Resposta fraca ou incompleta:**  
"O `@Transactional` não funcionou, talvez o banco esteja com problema."  
Falta: não identifica self-invocation, não explica o proxy, não propõe solução.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe identificar o problema |
| 1 | Menciona que "algo está errado" mas não sabe o quê |
| 2 | Identifica que é chamada interna mas não sabe explicar o proxy |
| 3 | Explica self-invocation e proxy, propõe solução |
| 4 | Demonstra múltiplas soluções com trade-offs |
| 5 | Responde com profundidade, menciona AopContext, @Lazy, CGLIB vs JDK proxy |

**Perguntas de aprofundamento:**
1. "O Spring usa proxy CGLIB ou JDK dinâmico por padrão? Qual a diferença?"
2. "Se a classe `PedidoService` for `final`, o `@Transactional` ainda funciona? Por quê?"
3. "Como você debugaria para confirmar que o proxy não está sendo acionado?"

---

### Pergunta 41 — O que é o ResponseEntity e quando usá-lo?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em controllers Spring Boot REST, às vezes você retorna um objeto diretamente e às vezes retorna um `ResponseEntity`. O que é o `ResponseEntity` e quando você deve usá-lo?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende que `ResponseEntity` permite controlar status HTTP, headers e corpo da resposta de forma explícita, e sabe diferenciar quando o retorno direto é suficiente e quando é necessário controle fino da resposta.

**Resposta esperada:**  
`ResponseEntity<T>` é uma classe do Spring MVC que representa **a resposta HTTP completa** — incluindo status code, headers e corpo. Quando você retorna apenas um objeto (ex: `return usuario`), o Spring decide automaticamente o status **200 OK** e os headers padrão. Com `ResponseEntity`, você tem controle total:

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    // Retorno direto — Spring assume 200 OK implicitamente
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    // ResponseEntity — controle explícito de status, headers e corpo
    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody UsuarioDTO dto) {
        Usuario usuario = usuarioService.criar(dto);
        // Status 201 Created + header Location apontando para o novo recurso
        return ResponseEntity
            .created(URI.create("/api/usuarios/" + usuario.getId()))
            .body(usuario);
    }

    // ResponseEntity com Optional — diferentes status para encontrado/não encontrado
    @GetMapping("/{id}/detalhe")
    public ResponseEntity<Usuario> buscarDetalhe(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
            .map(ResponseEntity::ok)                          // 200 + corpo
            .orElseGet(() -> ResponseEntity.notFound().build()); // 404 sem corpo
    }
}
```

**Quando usar cada abordagem:**

- **Retorno direto:** quando o status é sempre 200 OK e não há necessidade de headers customizados. Mais simples e legível.
- **ResponseEntity:** quando você precisa de status diferentes de 200 (201 Created, 204 No Content, 404 Not Found), precisa adicionar headers (Location, Cache-Control, etc.) ou quer retornar resposta sem corpo.

**Explicação didática:**  
Retornar um objeto diretamente é como enviar uma carta em um envelope padrão — o carteiro (Spring) entrega no formato usual. `ResponseEntity` é como montar você mesmo o envelope: escolhe o tipo de selo (status HTTP), pode escrever observações no envelope (headers) e decide o que vai dentro (corpo). Use o envelope customizado quando precisar de algo além do padrão.

**Como o candidato deve responder:**  
- Explicar que `ResponseEntity` representa a resposta HTTP completa (status + headers + corpo).
- Citar pelo menos dois casos de uso: 201 Created e 404 Not Found.
- Mostrar que sabe usar com `Optional` (map/orElse pattern).
- Mencionar que o retorno direto é válido quando 200 OK é suficiente.

**Resposta fraca ou incompleta:**  
"ResponseEntity é para retornar status HTTP."  
Falta: não menciona headers, não mostra exemplos, não explica quando usar retorno direto vs. ResponseEntity.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é ResponseEntity |
| 1 | Sabe que "controla status" mas não explica mais |
| 2 | Menciona status e corpo, mas não headers |
| 3 | Explica status, headers e corpo com exemplos |
| 4 | Demonstra uso com Optional, 201 Created e header Location |
| 5 | Responde com profundidade, menciona ResponseEntity.noContent, cache headers e boas práticas REST |

**Perguntas de aprofundamento:**
1. "Como você adicionaria um header customizado, como `X-Total-Count`, em uma resposta de listagem?"
2. "Qual a diferença entre `ResponseEntity.ok()` e `ResponseEntity.status(HttpStatus.OK)`?"
3. "Como você retornaria 204 No Content em um endpoint de exclusão?"

---

### Pergunta 42 — Qual a diferença entre @PathVariable e @RequestParam?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em endpoints Spring Boot REST, você usa `@PathVariable` e `@RequestParam` para receber dados do cliente. Qual é a diferença entre eles e quando usar cada um?"

**O que essa pergunta avalia:**  
Avalia se o candidato distingue parâmetros de caminho (parte da URL) de parâmetros de query string, e se sabe aplicar a convenção REST correta para cada caso.

**Resposta esperada:**  

**`@PathVariable`** extrai valores da **URL path** (parte do caminho da rota). É usado para identificar um recurso específico:

```java
// URL: /api/usuarios/42
@GetMapping("/api/usuarios/{id}")
public Usuario buscar(@PathVariable Long id) {
    // id = 42
    return usuarioService.buscarPorId(id);
}

// Múltiplos path variables
// URL: /api/usuarios/42/enderecos/7
@GetMapping("/api/usuarios/{usuarioId}/enderecos/{enderecoId}")
public Endereco buscarEndereco(
        @PathVariable Long usuarioId,
        @PathVariable Long enderecoId) {
    return enderecoService.buscar(usuarioId, enderecoId);
}
```

**`@RequestParam`** extrai valores da **query string** (após o `?` na URL). É usado para filtros, paginação, ordenação e parâmetros opcionais:

```java
// URL: /api/usuarios?nome=João&idade=25&pagina=0&tamanho=10
@GetMapping("/api/usuarios")
public List<Usuario> listar(
        @RequestParam(required = false) String nome,
        @RequestParam(required = false, defaultValue = "0") int pagina,
        @RequestParam(required = false, defaultValue = "10") int tamanho) {
    return usuarioService.listar(nome, pagina, tamanho);
}
```

**Resumo da diferença:**

| Aspecto | @PathVariable | @RequestParam |
|---------|---------------|---------------|
| Origem | URL path (ex: `/usuarios/42`) | Query string (ex: `?nome=João`) |
| Obrigatório | Sim por padrão (a URL não existe sem ele) | Não por padrão (`required = false`) |
| Uso típico | Identificar recurso específico | Filtrar, paginar, ordenar |
| Exemplo | `/usuarios/{id}` | `/usuarios?ativo=true&pagina=1` |

**Explicação didática:**  
`@PathVariable` é o "nome do apartamento" — faz parte do endereço e identifica exatamente onde você está indo (`/predio/3/apartamento/101`). `@RequestParam` é como um "bilhete na portaria" — você já está no prédio, mas quer especificar detalhes adicionais: "quero ver apenas os apartamentos do 3º andar que estão desocupados" (`?andar=3&desocupado=true`).

**Como o candidato deve responder:**  
- Explicar que `@PathVariable` extrai da URL path e `@RequestParam` da query string.
- Citar o padrão REST: path variable para identificar recurso, query param para filtrar.
- Mencionar que `@RequestParam` suporta `required = false` e `defaultValue`.
- Dar exemplos de ambos.

**Resposta fraca ou incompleta:**  
"Os dois recebem parâmetros da requisição."  
Falta: não diferencia path vs. query string, não mostra exemplos, não menciona uso REST.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe a diferença |
| 1 | Sabe que são "diferentes" mas não explica |
| 2 | Menciona URL vs. query mas sem exemplos de código |
| 3 | Explica com exemplos e convenção REST |
| 4 | Demonstra required, defaultValue e múltiplos parâmetros |
| 5 | Responde com profundidade, menciona @MatrixVariable, Map de params e boas práticas |

**Perguntas de aprofundamento:**
1. "É possível ter `@RequestParam` obrigatório? O que acontece se ele não for enviado?"
2. "Como você receberia todos os parâmetros de query como um `Map<String, String>`?"
3. "Qual a convenção REST correta: `/usuarios?status=ativo` ou `/usuarios/ativos`?"

---

### Pergunta 43 — O que é o DTO Pattern e por que usá-lo em APIs REST?

**Nível:** Júnior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
"Em muitos projetos Spring Boot, os controllers não recebem nem retornam entidades JPA diretamente. Em vez disso, usam DTOs. O que é o DTO Pattern e por que é uma boa prática?"

**O que essa pergunta avalia:**  
Avalia se o candidato compreende a separação entre entidades de persistência e objetos de transferência de dados, e se entende os riscos de expor entidades diretamente na API.

**Resposta esperada:**  
DTO (Data Transfer Object) é um padrão de projeto que consiste em usar classes específicas para transferir dados entre camadas — no caso de APIs REST, entre o controller e o cliente. Em vez de expor a entidade JPA (`Usuario`) diretamente, você cria um `UsuarioRequestDTO` para entrada e um `UsuarioResponseDTO` para saída.

**Motivos para usar DTOs:**

1. **Segurança — evitar mass assignment:**  
Se a entidade `Usuario` tem um campo `role` ou `isAdmin`, e você recebe `@RequestBody Usuario` diretamente, um cliente malicioso pode enviar `"isAdmin": true` no JSON e escalar privilégios.

```java
// PERIGOSO — cliente pode sobrescrever campos sensíveis
@PostMapping
public Usuario criar(@RequestBody Usuario usuario) {
    return usuarioService.criar(usuario);
}

// SEGURO — apenas campos explícitos no DTO são aceitos
@PostMapping
public UsuarioResponseDTO criar(@Valid @RequestBody UsuarioRequestDTO dto) {
    Usuario usuario = usuarioService.criar(dto);
    return new UsuarioResponseDTO(usuario);
}
```

2. **Desacoplamento da API do banco de dados:**  
A entidade pode mudar (novas colunas, relacionamentos) sem quebrar o contrato da API. O DTO isola o cliente dessas mudanças.

3. **Controle do que é exposto:**  
A entidade pode ter campos sensíveis (senha, token, dados internos) que não devem ser retornados ao cliente.

4. **Validação específica por contexto:**  
Diferentes operações podem ter regras diferentes. Criar usuário exige senha; atualizar usuário não. Com DTOs separados (`UsuarioCreateDTO`, `UsuarioUpdateDTO`), cada um tem suas próprias validações.

**Exemplo de código:**

```java
// Entidade JPA — representa a tabela no banco
@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha; // NUNCA deve ser exposto
    private boolean isAdmin;
    private boolean ativo;
    // getters, setters...
}

// DTO de entrada — apenas os campos que o cliente pode enviar
public record UsuarioCreateDTO(
    @NotBlank String nome,
    @NotBlank @Email String email,
    @NotBlank @Size(min = 8) String senha
) {}

// DTO de saída — apenas os campos seguros para retornar
public record UsuarioResponseDTO(
    Long id,
    String nome,
    String email,
    boolean ativo
) {}

// Controller usando DTOs
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(
            @Valid @RequestBody UsuarioCreateDTO dto) {
        Usuario usuario = usuarioService.criar(dto);
        UsuarioResponseDTO response = new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.isAtivo()
        );
        return ResponseEntity.created(URI.create("/api/usuarios/" + usuario.getId()))
            .body(response);
    }
}
```

**Explicação didática:**  
Pense na entidade como o "caderno completo" do usuário, com todas as informações (inclusive senha e dados internos). O DTO é como um "resumo" que você entrega para outra pessoa — você só coloca no resumo o que a pessoa precisa ver. Assim, mesmo que o caderno tenha informações sensíveis, quem recebe o resumo não tem acesso a elas.

**Como o candidato deve responder:**  
- Explicar que DTO separa a representação de dados da API da entidade de persistência.
- Mencionar pelo menos dois motivos: segurança (mass assignment) e controle de exposição.
- Mostrar exemplo com entidade vs. DTO de entrada vs. DTO de saída.
- Mencionar validação específica por contexto como vantagem.

**Resposta fraca ou incompleta:**  
"DTO é uma classe para transferir dados."  
Falta: não explica por que usar, não menciona segurança, não mostra diferença entre entidade e DTO.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é DTO |
| 1 | Sabe que "transfere dados" mas não explica por quê |
| 2 | Menciona separação mas não fala de segurança |
| 3 | Explica segurança, desacoplamento e controle de exposição |
| 4 | Demonstra prática com DTO de entrada, DTO de saída e validação |
| 5 | Responde com profundidade, menciona mapping (MapStruct/ModelMapper), records e imutabilidade |

**Perguntas de aprofundamento:**
1. "Como você faria a conversão entre entidade e DTO? Manual ou com alguma biblioteca?"
2. "É possível usar records do Java como DTOs no Spring Boot? Tem alguma limitação?"
3. "Em uma API com muitos endpoints, o número de DTOs pode crescer muito. Como você organizaria isso?"

---

### Pergunta 44 — Como funcionam os principais status codes HTTP em APIs Spring Boot?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Quando você desenvolve uma API REST com Spring Boot, quais são os status codes HTTP mais comuns que você deve retornar e em quais situações? Dê exemplos práticos."

**O que essa pergunta avalia:**  
Avalia se o candidato conhece os principais códigos de status HTTP, sabe quando aplicar cada um em endpoints REST e entende a diferença entre as famílias 2xx, 3xx, 4xx e 5xx.

**Resposta esperada:**  

**Família 2xx — Sucesso:**

| Código | Nome | Quando usar |
|--------|------|-------------|
| 200 | OK | GET, PUT, PATCH bem-sucedidos com corpo de resposta |
| 201 | Created | POST bem-sucedido que cria um novo recurso |
| 204 | No Content | DELETE bem-sucedido, ou PUT/PATCH sem corpo de resposta |

**Família 4xx — Erro do cliente:**

| Código | Nome | Quando usar |
|--------|------|-------------|
| 400 | Bad Request | Dados inválidos, JSON malformado, validação falhou |
| 401 | Unauthorized | Não autenticado — falta token ou credenciais |
| 403 | Forbidden | Autenticado, mas sem permissão para o recurso |
| 404 | Not Found | Recurso não existe |
| 405 | Method Not Allowed | Método HTTP não suportado para a rota |
| 409 | Conflict | Conflito (ex: e-mail duplicado, versão desatualizada) |
| 422 | Unprocessable Entity | Entidade válida sintaticamente, mas semanticamente incorreta |

**Família 5xx — Erro do servidor:**

| Código | Nome | Quando usar |
|--------|------|-------------|
| 500 | Internal Server Error | Erro inesperado no servidor (exceção não tratada) |
| 502 | Bad Gateway | Servidor upstream retornou resposta inválida |
| 503 | Service Unavailable | Servidor em manutenção ou sobrecarregado |

**Exemplo prático em Spring Boot:**

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    // 200 OK — GET com recurso encontrado
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscar(id));
    }

    // 201 Created — POST criando recurso
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@Valid @RequestBody UsuarioCreateDTO dto) {
        UsuarioResponseDTO criado = usuarioService.criar(dto);
        return ResponseEntity.created(URI.create("/api/usuarios/" + criado.id())).body(criado);
    }

    // 204 No Content — DELETE bem-sucedido
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
    }

    // 404 Not Found — recurso não encontrado
    @GetMapping("/{id}/detalhe")
    public ResponseEntity<Usuario> buscarDetalhe(@PathVariable Long id) {
        return usuarioService.buscarOptional(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
```

**Explicação didática:**  
Os status codes HTTP são como "códigos de resposta" que o servidor envia ao cliente. Imagine que você pede uma pizza: 200 significa "aqui está sua pizza", 201 significa "seu pedido foi criado e está sendo preparado", 204 significa "seu pedido foi cancelado, não há nada para mostrar", 400 significa "você pediu algo que não faz sentido", 404 significa "essa pizza não existe no cardápio", e 500 significa "a cozinha pegou fogo".

**Como o candidato deve responder:**  
- Citar pelo menos um código de cada família (2xx, 4xx, 5xx).
- Explicar quando usar 200 vs 201 vs 204.
- Explicar a diferença entre 401 (não autenticado) e 403 (sem permissão).
- Mostrar como aplicar status codes no Spring Boot (ResponseEntity ou @ResponseStatus).

**Resposta fraca ou incompleta:**  
"Tem o 200 para sucesso e o 404 para não encontrado."  
Falta: não menciona 201, 204, 400, 401, 403, 500; não explica como aplicar no Spring Boot.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece status codes |
| 1 | Conhece 200 e 404 apenas |
| 2 | Cita alguns códigos mas não sabe diferenciar 401/403 ou 200/201 |
| 3 | Explica as três famílias com códigos corretos e exemplos |
| 4 | Demonstra aplicação prática no Spring Boot (ResponseEntity, @ResponseStatus) |
| 5 | Responde com profundidade, menciona 422, 409, idempotência e semântica REST |

**Perguntas de aprofundamento:**
1. "Qual status code você retornaria para um POST que tenta criar um recurso com e-mail duplicado?"
2. "Qual a diferença entre 401 e 403? Dê um exemplo prático de cada um."
3. "Por que o DELETE geralmente retorna 204 e não 200?"

---

### Pergunta 45 — O que é e como funciona o @RequestBody?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Quando você cria um endpoint POST ou PUT no Spring Boot, geralmente usa `@RequestBody` no parâmetro. O que essa anotação faz e o que acontece se você não a usar?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende que `@RequestBody` aciona o `HttpMessageConverter` (geralmente Jackson) para desserializar o JSON do corpo da requisição em um objeto Java, e sabe o que acontece sem ela.

**Resposta esperada:**  
`@RequestBody` indica ao Spring que o parâmetro do método do controller deve ser populado a partir do **corpo da requisição HTTP** (request body). O Spring usa um `HttpMessageConverter` — por padrão o Jackson — para converter o JSON recebido em um objeto Java.

**O que acontece passo a passo:**

1. O cliente envia uma requisição POST com JSON no corpo:
```json
{
    "nome": "João Silva",
    "email": "joao@email.com",
    "senha": "12345678"
}
```

2. O Spring detecta `@RequestBody` e aciona o Jackson.
3. O Jackson mapeia cada campo do JSON para o campo correspondente no objeto Java (usando getters/setters ou construtor).
4. Se houver `@Valid`, o Spring executa a validação após a desserialização.
5. O objeto pronto é passado como argumento para o método do controller.

**Sem `@RequestBody`:**  
Se você não usar a anotação, o Spring tenta resolver o parâmetro como se fosse um parâmetro de formulário ou query param (via `@ModelAttribute` implícito). Isso não funciona corretamente para JSON:

```java
// COM @RequestBody — funciona com JSON
@PostMapping("/usuarios")
public ResponseEntity<Usuario> criar(@Valid @RequestBody UsuarioCreateDTO dto) {
    // dto vem do JSON do corpo da requisição
    return ResponseEntity.ok(usuarioService.criar(dto));
}

// SEM @RequestBody — NÃO funciona para JSON
@PostMapping("/usuarios-errado")
public ResponseEntity<Usuario> criarErrado(UsuarioCreateDTO dto) {
    // Spring tenta popular via form params (application/x-www-form-urlencoded)
    // dto terá todos os campos null se o cliente enviar JSON
    return ResponseEntity.ok(dto);
}
```

**Detalhe sobre `Content-Type`:**  
O Spring decide qual converter usar com base no header `Content-Type` da requisição. Se o cliente envia `Content-Type: application/json`, o Jackson é usado. Se envia `application/xml`, um converter XML é usado (se disponível).

**Explicação didática:**  
Imagine que `@RequestBody` é um "tradutor" que recebe uma carta escrita em outro idioma (JSON) e a traduz para o seu idioma nativo (objeto Java). Sem o tradutor, você recebe a carta mas não consegue lê-la corretamente — os campos ficam "em branco" porque o Spring não sabe que precisa traduzir.

**Como o candidato deve responder:**  
- Explicar que `@RequestBody` indica que o parâmetro vem do corpo da requisição.
- Mencionar que o Jackson (HttpMessageConverter) faz a desserialização JSON → objeto.
- Explicar que sem `@RequestBody`, o Spring tenta resolver como form params.
- Mencionar a relação com `Content-Type`.

**Resposta fraca ou incompleta:**  
"Recebe os dados do JSON."  
Falta: não menciona Jackson/desserialização, não explica o que acontece sem a anotação.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que faz |
| 1 | Sabe que "recebe o JSON" mas não explica como |
| 2 | Menciona Jackson mas não sabe o que acontece sem @RequestBody |
| 3 | Explica desserialização, Jackson e o comportamento sem a anotação |
| 4 | Demonstra conhecimento de Content-Type, @Valid e HttpMessageConverter |
| 5 | Responde com profundidade, menciona custom serializers, @JsonIgnore e edge cases |

**Perguntas de aprofundamento:**
1. "O que acontece se o JSON enviado tiver um campo que não existe no DTO?"
2. "Como você lidaria com um campo de data no JSON? O formato padrão funciona?"
3. "É possível receber o corpo como String diretamente, sem desserializar para um objeto?"

---

### Pergunta 46 — O que é content negotiation e como aplicá-lo no Spring Boot?

**Nível:** Júnior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
"Imagine que um cliente da sua API precisa receber respostas em JSON e outro precisa em XML. Como o Spring Boot suporta servir diferentes formatos para o mesmo endpoint?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o conceito de content negotiation (negociação de conteúdo), sabe como o Spring Boot usa o header `Accept` para determinar o formato de resposta, e conhece a anotação `@Produces`.

**Resposta esperada:**  
Content negotiation é o mecanismo pelo qual o servidor e o cliente **negociam o formato** dos dados trocados. O cliente indica o formato que aceita através do header HTTP `Accept`, e o servidor responde no formato apropriado, se suportado.

**Como funciona no Spring Boot:**

1. **Baseado no header `Accept`:**  
O cliente envia `Accept: application/json` ou `Accept: application/xml`, e o Spring escolhe o `HttpMessageConverter` apropriado para serializar a resposta.

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    // Suporta tanto JSON quanto XML
    @GetMapping(value = "/{id}", produces = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
    })
    public Usuario buscar(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }
}
```

2. **Dependência necessária para XML:**  
O suporte a JSON vem por padrão (Jackson). Para XML, é necessário adicionar o Jackson XML:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```

3. **Baseado em extensão de URL (legado):**  
O Spring também suportava negociação por extensão (`/api/usuarios.json`, `/api/usuarios.xml`), mas essa abordagem é **desencorajada** e desativada por padrão no Spring Boot 3.x.

4. **Consumes vs. Produces:**
- `produces` — define os formatos que o endpoint pode **retornar** (response).
- `consumes` — define os formatos que o endpoint **aceita** receber (request body).

```java
// Aceita apenas JSON no corpo da requisição
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Usuario> criar(@RequestBody UsuarioCreateDTO dto) {
    return ResponseEntity.ok(usuarioService.criar(dto));
}
```

**Explicação didática:**  
Content negotiation é como pedir comida em um restaurante internacional. Você diz ao garçom em que idioma quer o cardápio (header `Accept`), e a cozinha prepara o prato com as instruções no formato que você pediu. Se você pede em francês e a cozinha não fala francês, recebe um erro 406 Not Acceptable.

**Como o candidato deve responder:**  
- Explicar que content negotiation permite servir diferentes formatos para o mesmo endpoint.
- Mencionar o header `Accept` como mecanismo principal.
- Citar `produces` e `consumes` no mapeamento.
- Explicar que JSON é padrão e XML requer dependência adicional.

**Resposta fraca ou incompleta:**  
"É quando a API retorna JSON ou XML."  
Falta: não menciona o header Accept, não cita produces/consumes, não explica como configurar.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é |
| 1 | Sabe que "tem diferentes formatos" mas não explica |
| 2 | Menciona JSON e XML mas não cita o header Accept |
| 3 | Explica Accept, produces e consumes com exemplos |
| 4 | Demonstra conhecimento prático de configuração e dependências |
| 5 | Responde com profundidade, menciona 406 Not Acceptable, 415 Unsupported Media Type e Jackson XML |

**Perguntas de aprofundamento:**
1. "O que acontece se o cliente pedir um formato que o servidor não suporta? Qual status code é retornado?"
2. "Como você configuraria um formatador customizado, por exemplo para YAML?"
3. "É possível definir um formato padrão quando o cliente não envia o header Accept?"

---

### Pergunta 47 — Como você usa Lombok em projetos Spring Boot e quais anotações mais utiliza?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em muitos projetos Spring Boot, você vê a biblioteca Lombok sendo usada. O que é o Lombok, quais anotações você mais utiliza e quais cuidados deve ter?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o Lombok como ferramenta de redução de boilerplate, sabe usar as anotações principais e está ciente dos cuidados (compatibilidade, delombok, problemas com herança).

**Resposta esperada:**  
Lombok é uma biblioteca Java que gera automaticamente código boilerplate (getters, setters, construtores, equals, hashCode, toString) em tempo de compilação, através de anotações. Isso reduz a verbosidade do código, especialmente em classes de modelo, DTOs e entidades.

**Anotações mais comuns:**

```java
// @Data — combina @Getter, @Setter, @ToString, @EqualsAndHashCode e @RequiredArgsConstructor
@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
}

// @Getter e @Setter — individuais, mais controlados
@Getter
@Setter
public class Produto {
    private String nome;
    private double preco;
}

// @Builder — padrão Builder para construção de objetos
@Builder
public class Pedido {
    private Long id;
    private String cliente;
    private List<Item> itens;
    private BigDecimal total;
}

// Uso do builder:
Pedido pedido = Pedido.builder()
    .id(1L)
    .cliente("João")
    .itens(List.of(item1, item2))
    .total(BigDecimal.valueOf(150.00))
    .build();

// @Slf4j — injeta um logger automaticamente
@Slf4j
@Service
public class UsuarioService {
    public void processar(Long id) {
        log.info("Processando usuário {}", id);
    }
}

// @RequiredArgsConstructor — construtor com campos final (ideal para DI)
@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository repository;  // final → entra no construtor
    private final EmailService emailService;      // final → entra no construtor
    // Lombok gera o construtor com os dois parâmetros
}
```

**Uso em entidades JPA — cuidado especial:**

```java
// ENTIDADE JPA — usar apenas @Getter/@Setter, NÃO usar @Data ou @EqualsAndHashCode
@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();
}
```

**Por que não usar `@Data` em entidades JPA:**
- `@EqualsAndHashCode` baseado em todos os campos pode causar **recursão infinita** em relacionamentos bidirecionais (Usuario → Pedidos → Usuario → Pedidos...).
- `@ToString` também pode causar recursão e carregar lazy collections inadvertidamente.
- Antes de a entidade ter ID (antes do `persist`), o `equals` baseado em ID pode gerar falsos positivos.

**Explicação didática:**  
Lombok é como um assistente invisível que, enquanto você escreve a receita (classe), já prepara todos os utensílios (getters, setters, construtores) para você. Você só escreve os campos, e ele gera o resto. Mas cuidado: em algumas cozinhas (entidades JPA com relacionamentos), o assistente pode se confundir e criar um loop — por isso é melhor dar instruções mais específicas (`@Getter`/`@Setter` ao invés de `@Data`).

**Como o candidato deve responder:**  
- Explicar que Lombok gera boilerplate em tempo de compilação.
- Citar pelo menos três anotações: `@Data`, `@Builder`, `@RequiredArgsConstructor` ou `@Slf4j`.
- Mencionar o cuidado com entidades JPA (não usar `@Data`).
- Explicar que `@RequiredArgsConstructor` é ideal para injeção por construtor.

**Resposta fraca ou incompleta:**  
"Lombok gera getters e setters."  
Falta: não menciona outras anotações, não fala dos cuidados com entidades JPA, não cita `@RequiredArgsConstructor`.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece Lombok |
| 1 | Sabe que "gera getters/setters" mas não conhece outras anotações |
| 2 | Cita @Data e @Builder mas não sabe dos cuidados |
| 3 | Explica múltiplas anotações e o cuidado com entidades JPA |
| 4 | Demonstra prática com @RequiredArgsConstructor para DI e @Slf4j |
| 5 | Responde com profundidade, menciona delombok, compatibilidade com JDK e alternativas (records) |

**Perguntas de aprofundamento:**
1. "Por que `@Data` é problemático em entidades JPA com relacionamentos bidirecionais?"
2. "Como o Lombok funciona internamente? Ele modifica o código-fonte ou o bytecode?"
3. "Com Java Records disponível, você ainda usaria Lombok para DTOs? Por quê?"

---

### Pergunta 48 — Como lidar com operações idempotentes em uma API REST Spring Boot?

**Nível:** Júnior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
"Imagine que sua API tem um endpoint POST que cria um pedido. O cliente enviou a requisição, mas houve um timeout de rede e ele reenviou. Como você evita que dois pedidos sejam criados?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o conceito de idempotência em APIs REST, sabe quais métodos HTTP são naturalmente idempotentes e conhece estratégias para tornar POST idempotente.

**Resposta esperada:**  
**Idempotência** significa que executar a mesma operação múltiplas vezes produz o **mesmo resultado** que executá-la uma vez. Na API REST:

**Métodos naturalmente idempotentes:**
- **GET** — ler não altera estado.
- **PUT** — substitui o recurso inteiro; executar várias vezes resulta no mesmo estado final.
- **DELETE** — deletar um recurso que já foi deletado tem o mesmo efeito.
- **HEAD, OPTIONS** — apenas leitura.

**Método NÃO idempotente:**
- **POST** — cada execução pode criar um novo recurso. Chamar duas vezes cria dois recursos.

**Estratégias para tornar POST idempotente:**

1. **Idempotency Key (chave de idempotência):**  
O cliente gera um UUID único e envia no header da requisição. O servidor verifica se já processou aquela chave:

```java
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criar(
            @RequestHeader("Idempotency-Key") String key,
            @Valid @RequestBody PedidoCreateDTO dto) {

        // Verifica se já existe um pedido com essa chave
        Optional<Pedido> existente = pedidoService.buscarPorIdempotencyKey(key);
        if (existente.isPresent()) {
            // Retorna o pedido já criado (idempotente)
            return ResponseEntity.ok(new PedidoResponseDTO(existente.get()));
        }

        // Cria novo pedido e armazena a chave
        Pedido pedido = pedidoService.criar(dto, key);
        return ResponseEntity.created(URI.create("/api/pedidos/" + pedido.getId()))
            .body(new PedidoResponseDTO(pedido));
    }
}
```

2. **Idempotency Key com cache/Redis:**  
Para não poluir o banco, a chave pode ser armazenada em cache com TTL:

```java
@Service
@RequiredArgsConstructor
public class PedidoService {

    private final RedisTemplate<String, String> redisTemplate;

    public Pedido criar(PedidoCreateDTO dto, String idempotencyKey) {
        // Tenta reservar a chave atomicamente
        Boolean isNew = redisTemplate.opsForValue()
            .setIfAbsent("idempotency:" + idempotencyKey, "processing", Duration.ofMinutes(30));

        if (Boolean.FALSE.equals(isNew)) {
            // Já está sendo processado ou já foi processado
            throw new IdempotencyConflictException("Requisição duplicada");
        }

        Pedido pedido = new Pedido(dto.getCliente(), dto.getItens());
        pedidoRepository.save(pedido);

        // Atualiza a chave com o ID do pedido criado
        redisTemplate.opsForValue()
            .set("idempotency:" + idempotencyKey, pedido.getId().toString(), Duration.ofMinutes(30));

        return pedido;
    }
}
```

3. **PUT em vez de POST (quando aplicável):**  
Se o cliente conhece o ID do recurso, pode usar PUT que é naturalmente idempotente:
```
PUT /api/pedidos/{id} → cria se não existe, substitui se existe
```

**Explicação didática:**  
Imagine que você pede um café no aplicativo. O sinal cai e você não sabe se o pedido foi feito. Você clica em "pedir" novamente. Sem idempotência, você recebe dois cafés (e paga dois). Com idempotência, o aplicativo diz: "já recebi esse pedido exato antes, não vou criar outro — vou te mostrar o status do primeiro".

**Como o candidato deve responder:**  
- Explicar o conceito de idempotência.
- Citar quais métodos HTTP são naturalmente idempotentes.
- Propor pelo menos uma estratégia: idempotency key.
- Mencionar que POST não é idempotente por padrão e por isso precisa de estratégia.

**Resposta fraca ou incompleta:**  
"Você pode usar PUT em vez de POST."  
Falta: não explica idempotência, não menciona idempotency key, não diferencia métodos.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é idempotência |
| 1 | Sabe que "não repete" mas não explica como |
| 2 | Menciona que PUT/DELETE são idempotentes mas não propõe solução para POST |
| 3 | Explica idempotency key com exemplo prático |
| 4 | Demonstra solução com banco ou cache e tratamento de concorrência |
| 5 | Responde com profundidade, menciona race conditions, TTL e padrões de mercado (Stripe) |

**Perguntas de aprofundamento:**
1. "O que acontece se duas requisições com a mesma idempotency key chegarem exatamente ao mesmo tempo?"
2. "Por quanto tempo você guardaria a idempotency key?"
3. "Qual a diferença entre idempotência e segurança em métodos HTTP?"

---

### Pergunta 49 — Como você versiona uma API REST no Spring Boot?

**Nível:** Júnior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
"Sua API está em produção e você precisa fazer uma mudança que quebra compatibilidade (breaking change). Como você versiona a API para não afetar os clientes existentes?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece estratégias de versionamento de API, sabe implementar no Spring Boot e entende quando é necessário versionar.

**Resposta esperada:**  
Existem três estratégias principais de versionamento de API REST:

**1. Versionamento por URL path (mais comum):**

```java
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioControllerV1 {

    @GetMapping("/{id}")
    public UsuarioResponseV1DTO buscar(@PathVariable Long id) {
        return usuarioService.buscar(id);
    }
}

@RestController
@RequestMapping("/api/v2/usuarios")
public class UsuarioControllerV2 {

    @GetMapping("/{id}")
    public UsuarioResponseV2DTO buscar(@PathVariable Long id) {
        // V2 retorna campos adicionais
        return usuarioService.buscarV2(id);
    }
}
```

**2. Versionamento por query parameter:**

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @GetMapping(params = "version=1")
    public UsuarioResponseV1DTO buscarV1(@PathVariable Long id) {
        return usuarioService.buscar(id);
    }

    @GetMapping(params = "version=2")
    public UsuarioResponseV2DTO buscarV2(@PathVariable Long id) {
        return usuarioService.buscarV2(id);
    }
}
// URL: /api/usuarios/42?version=2
```

**3. Versionamento por header (content negotiation):**

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @GetMapping(value = "/{id}", headers = "X-API-Version=1")
    public UsuarioResponseV1DTO buscarV1(@PathVariable Long id) {
        return usuarioService.buscar(id);
    }

    @GetMapping(value = "/{id}", headers = "X-API-Version=2")
    public UsuarioResponseV2DTO buscarV2(@PathVariable Long id) {
        return usuarioService.buscarV2(id);
    }
}
// Header: X-API-Version: 2
```

**Comparação das estratégias:**

| Estratégia | Vantagem | Desvantagem |
|------------|----------|-------------|
| URL path | Simples, visível, fácil de testar | URLs diferentes para o mesmo recurso |
| Query param | Não polui a URL | Menos explícito, pode ser esquecido |
| Header | URL limpa, content negotiation | Menos visível, mais difícil de testar |

**Quando versionar:**
- Mudança no formato de resposta (campo removido ou renomeado).
- Mudança nas regras de validação que rejeitam requisições antes aceitas.
- Mudança no comportamento do endpoint (ex: novo algoritmo de cálculo).

**Quando NÃO versionar:**
- Adicionar campos opcionais na resposta (backward compatible).
- Adicionar novos endpoints.
- Mudanças internas que não afetam o contrato da API.

**Explicação didática:**  
Versionamento de API é como editar um livro publicado. Se você apenas adiciona um apêndice (campo novo), não precisa de nova edição — os leitores antigos não são afetados. Mas se você muda o capítulo 3 (breaking change), precisa lançar uma "segunda edição" (v2) para que quem comprou a primeira edição (v1) continue com o livro funcionando.

**Como o candidato deve responder:**  
- Citar pelo menos duas estratégias de versionamento.
- Explicar quando é necessário versionar (breaking changes).
- Explicar quando não é necessário (changes backward compatible).
- Mostrar exemplo prático de implementação no Spring Boot.

**Resposta fraca ou incompleta:**  
"Você coloca v1 ou v2 na URL."  
Falta: não explica quando versionar, não menciona outras estratégias, não fala de backward compatibility.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é versionamento |
| 1 | Sabe que "tem v1 e v2" mas não explica |
| 2 | Menciona URL path mas não outras estratégias |
| 3 | Explica múltiplas estratégias com exemplos e critérios |
| 4 | Demonstra conhecimento de quando versionar vs. quando não |
| 5 | Responde com profundidade, menciona deprecation, sunset headers e estratégia de migração |

**Perguntas de aprofundamento:**
1. "Como você comunicaria aos clientes que a v1 será descontinuada?"
2. "É possível manter v1 e v2 compartilhando a mesma lógica de serviço? Como?"
3. "Qual estratégia de versionamento você usaria para uma API pública com milhares de clientes?"

---

### Pergunta 50 — Como você documenta uma API REST Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Você construiu uma API REST com vários endpoints no Spring Boot. Como você documenta essa API para que outros desenvolvedores (ou times externos) possam consumi-la?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece ferramentas de documentação de API (Swagger/OpenAPI), sabe integrá-las com Spring Boot e entende a importância de documentar contratos.

**Resposta esperada:**  
A ferramenta mais utilizada para documentar APIs Spring Boot é o **SpringDoc OpenAPI** (sucessor do SpringFox Swagger), que gera documentação interativa baseada na especificação OpenAPI 3.

**1. Configuração da dependência:**

```xml
<!-- SpringDoc OpenAPI — gera documentação Swagger UI automaticamente -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
```

Após adicionar a dependência, a documentação fica disponível em:
- **Swagger UI (interativo):** `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON:** `http://localhost:8080/v3/api-docs`
- **OpenAPI YAML:** `http://localhost:8080/v3/api-docs.yaml`

**2. Configuração global com `@OpenAPIDefinition`:**

```java
@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API de Usuários",
        version = "1.0.0",
        description = "API REST para gestão de usuários",
        contact = @Contact(name = "Time Backend", email = "backend@empresa.com"),
        license = @License(name = "MIT")
    )
)
public class OpenApiConfig {
}
```

**3. Documentação nos controllers com anotações:**

```java
@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuários", description = "Endpoints para gestão de usuários")
public class UsuarioController {

    @Operation(
        summary = "Buscar usuário por ID",
        description = "Retorna os dados de um usuário específico",
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado",
                content = @Content(schema = @Schema(implementation = UsuarioResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscar(
            @Parameter(description = "ID do usuário", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscar(id));
    }

    @Operation(
        summary = "Criar novo usuário",
        responses = {
            @ApiResponse(responseCode = "201", description = "Usuário criado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
        }
    )
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(
            @Valid @RequestBody UsuarioCreateDTO dto) {
        UsuarioResponseDTO criado = usuarioService.criar(dto);
        return ResponseEntity.created(URI.create("/api/usuarios/" + criado.id()))
            .body(criado);
    }
}
```

**4. Documentação dos DTOs:**

```java
@Schema(description = "Dados para criação de um novo usuário")
public record UsuarioCreateDTO(
    @Schema(description = "Nome completo", example = "João Silva", required = true)
    @NotBlank String nome,

    @Schema(description = "E-mail válido", example = "joao@email.com", required = true)
    @NotBlank @Email String email,

    @Schema(description = "Senha (mínimo 8 caracteres)", required = true)
    @NotBlank @Size(min = 8) String senha
) {}
```

**Vantagens do SpringDoc:**
- Geração automática a partir do código (single source of truth).
- Interface interativa para testar endpoints.
- Suporte a validações Bean Validation (gera schema com min, max, pattern, etc.).
- Exportação para JSON/YAML (importável em Postman, Insomnia, etc.).

**Explicação didática:**  
Documentar a API manualmente em um documento separado é como escrever um manual de instruções à mão — sempre fica desatualizado quando o produto muda. O SpringDoc é como um "manual que se escreve sozinho": ele lê o código, as anotações e as validações, e gera a documentação automaticamente toda vez que a aplicação sobe. Se você muda o código, a documentação muda junto.

**Como o candidato deve responder:**  
- Mencionar SpringDoc OpenAPI (ou Swagger).
- Explicar que gera documentação interativa (Swagger UI).
- Citar as anotações principais: `@Operation`, `@ApiResponse`, `@Schema`.
- Mencionar os endpoints gerados (`/swagger-ui.html`, `/v3/api-docs`).
- Explicar a vantagem de geração automática a partir do código.

**Resposta fraca ou incompleta:**  
"Eu uso o Swagger."  
Falta: não explica como configurar, não cita anotações, não menciona SpringDoc, não explica as vantagens.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece ferramentas de documentação |
| 1 | Sabe que "existe Swagger" mas não sabe usar |
| 2 | Menciona Swagger UI mas não cita anotações |
| 3 | Explica SpringDoc, anotações e configuração |
| 4 | Demonstra prática com @Schema, @Operation e exemplos |
| 5 | Responde com profundidade, menciona OpenAPI 3 vs Swagger 2, exportação e integração com Postman |

**Perguntas de aprofundamento:**
1. "Como você protegeria a documentação do Swagger em produção para que não seja pública?"
2. "É possível gerar clientes (SDKs) a partir da documentação OpenAPI? Como?"
3. "Qual a diferença entre Swagger 2 e OpenAPI 3? Por que o SpringFox foi substituído pelo SpringDoc?"

---

## Roteiro de Entrevista Técnica — Spring Boot

### Parte 6 de 10 — Perguntas 51 a 60

**Foco:** Testes — `@SpringBootTest`, `@MockBean`, `@WebMvcTest`, `@DataJpaTest`, Mockito, AssertJ, testes de integração e H2 em testes

---

### Pergunta 51 — Quais são os principais tipos de teste no Spring Boot e como eles se organizam?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, existem diferentes tipos de teste. Como você classifica esses testes e quais anotações usa para cada tipo?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende a pirâmide de testes no contexto Spring Boot, conhece a diferença entre testes unitários, de slice e de integração, e sabe qual anotação usar em cada cenário.

**Resposta esperada:**  
O Spring Boot oferece três níveis principais de teste, cada um com um escopo e custo diferentes:

**1. Testes unitários (sem contexto Spring):**  
Testam uma classe isoladamente, sem subir o contexto do Spring. As dependências são substituídas por mocks (Mockito). São os mais rápidos.

```java
// Teste unitário puro — sem Spring, sem banco, sem servidor
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void deveBuscarUsuarioPorId() {
        // Arrange
        Usuario usuario = new Usuario(1L, "João", "joao@email.com");
        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        // Act
        Usuario resultado = service.buscar(1L);

        // Assert
        assertEquals("João", resultado.getNome());
        verify(repository).findById(1L);
    }
}
```

**2. Testes de slice (foco em uma camada):**  
Subem apenas uma parte do contexto Spring, sem carregar a aplicação inteira. São rápidos e focados.

| Anotação | O que carrega | O que mocka |
|----------|---------------|-------------|
| `@WebMvcTest` | Camada web (controllers, MVC, Jackson) | Services, repositories |
| `@DataJpaTest` | Camada JPA (repositories, EntityManager, H2) | Services, controllers |
| `@JsonTest` | Serialização/desserialização JSON | Tudo exceto Jackson |

**3. Testes de integração (contexto completo):**  
Subem o contexto inteiro do Spring Boot com `@SpringBootTest`. São os mais lentos, mas testam a aplicação de ponta a ponta.

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsuarioIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void deveCriarEBuscarUsuario() {
        // Teste de ponta a ponta — sobe a aplicação completa
    }
}
```

**Explicação didática:**  
Pense na pirâmide de testes como os andares de um prédio. O térreo (base larga) tem muitos testes unitários — rápidos e baratos. O segundo andar tem testes de slice — testam uma camada inteira, ainda razoavelmente rápidos. O último andar (topo estreito) tem poucos testes de integração — lentos e caros, mas validam que tudo funciona junto.

**Como o candidato deve responder:**  
- Diferenciar testes unitários (sem Spring), de slice (uma camada) e de integração (contexto completo).
- Citar as anotações: `@ExtendWith(MockitoExtension)`, `@WebMvcTest`, `@DataJpaTest`, `@SpringBootTest`.
- Mencionar a pirâmide de testes e que a maioria deve ser unitária.
- Explicar o trade-off: mais contexto = mais realista, porém mais lento.

**Resposta fraca ou incompleta:**  
"Tem o `@SpringBootTest` que sobe a aplicação."  
Falta: não diferencia tipos, não menciona slices, não cita a pirâmide de testes.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece tipos de teste |
| 1 | Sabe que "@SpringBootTest testa tudo" mas não diferencia |
| 2 | Menciona unitário e integração mas não conhece slices |
| 3 | Explica os três níveis com anotações corretas |
| 4 | Demonstra conhecimento prático com exemplos de cada tipo |
| 5 | Responde com profundidade, menciona pirâmide, trade-offs de velocidade e WebEnvironment |

**Perguntas de aprofundamento:**
1. "Por que evitar `@SpringBootTest` para testar a lógica de um service?"
2. "Qual a diferença entre `@Mock` e `@MockBean`?"
3. "Como você decidiria entre `@WebMvcTest` e `@SpringBootTest` para testar um controller?"

---

### Pergunta 52 — O que faz a anotação @SpringBootTest e quais configurações de webEnvironment existem?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"Quando você usa `@SpringBootTest` em um teste, o que acontece exatamente? E qual a diferença entre as opções de `webEnvironment`?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende que `@SpringBootTest` carrega o contexto completo da aplicação e conhece as quatro modalidades de `webEnvironment`, que determinam se o servidor web é iniciado ou não.

**Resposta esperada:**  
`@SpringBootTest` carrega o **ApplicationContext completo** da aplicação, incluindo todos os beans, autoconfigurações, datasource, etc. É a anotação mais "pesada" de teste, pois sobe praticamente a aplicação inteira.

**Configurações de `webEnvironment`:**

| Valor | Servidor web | Porta | Quando usar |
|-------|-------------|-------|-------------|
| `MOCK` (padrão) | Não inicia servidor real | Mock MVC | Para testes de controller com `MockMvc` |
| `RANDOM_PORT` | Inicia servidor real | Aleatória | Para testes de integração com `TestRestTemplate` |
| `DEFINED_PORT` | Inicia servidor real | Definida em `application.properties` | Quando precisa de porta fixa |
| `NONE` | Não inicia servidor | N/A | Quando só testa beans não-web |

**Exemplo com MOCK (padrão):**

```java
@SpringBootTest
@AutoConfigureMockMvc
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarUsuarioPorId() throws Exception {
        mockMvc.perform(get("/api/usuarios/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nome").value("João"));
    }
}
```

**Exemplo com RANDOM_PORT:**

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsuarioIntegrationTest {

    @LocalServerPort
    private int porta;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void deveCriarUsuario() {
        UsuarioCreateDTO dto = new UsuarioCreateDTO("João", "joao@email.com", "12345678");

        ResponseEntity<UsuarioResponseDTO> resposta = restTemplate.postForEntity(
            "/api/usuarios", dto, UsuarioResponseDTO.class
        );

        assertThat(resposta.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(resposta.getBody().nome()).isEqualTo("João");
    }
}
```

**Explicação didática:**  
`MOCK` é como testar a aplicação "simulando" o servidor — o Spring cria um ambiente que se comporta como um servidor web, mas sem realmente abrir uma porta de rede. `RANDOM_PORT` é como ligar o servidor de verdade em uma porta qualquer e fazer requisições reais via HTTP. O primeiro é mais rápido; o segundo é mais realista.

**Como o candidato deve responder:**  
- Explicar que `@SpringBootTest` carrega o contexto completo.
- Citar pelo menos `MOCK` e `RANDOM_PORT`.
- Explicar que `MOCK` usa `MockMvc` e `RANDOM_PORT` usa `TestRestTemplate`.
- Mencionar que `MOCK` é o padrão e não inicia servidor real.

**Resposta fraca ou incompleta:**  
"@SpringBootTest sobe a aplicação para testar."  
Falta: não menciona `webEnvironment`, não diferencia `MOCK` de `RANDOM_PORT`, não cita `MockMvc`.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que @SpringBootTest faz |
| 1 | Sabe que "sobe a aplicação" mas não conhece webEnvironment |
| 2 | Menciona MOCK e RANDOM_PORT mas sem explicar a diferença |
| 3 | Explica as modalidades com exemplos de MockMvc e TestRestTemplate |
| 4 | Demonstra conhecimento de @LocalServerPort e quando usar cada modo |
| 5 | Responde com profundidade, menciona performance, NONE e trade-offs |

**Perguntas de aprofundamento:**
1. "Qual a vantagem de usar `RANDOM_PORT` em vez de `DEFINED_PORT`?"
2. "É possível usar `@SpringBootTest` sem que ele carregue o banco de dados? Como?"
3. "Como você reduziria o tempo de execução de testes com `@SpringBootTest`?"

---

### Pergunta 53 — O que é @MockBean e como ele difere de @Mock?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"Em testes Spring Boot, você pode usar `@Mock` e `@MockBean`. Qual é a diferença entre eles e quando usar cada um?"

**O que essa pergunta avalia:**  
Avalia se o candidato distingue mocks puros (Mockito, sem contexto Spring) de mocks que substituem beans no contexto do Spring, e sabe quando aplicar cada um.

**Resposta esperada:**  

| Aspecto | `@Mock` | `@MockBean` |
|---------|---------|-------------|
| Origem | Mockito puro | Spring Boot Test |
| Requer contexto Spring? | Não | Sim |
| O que faz | Cria um mock da classe | Substitui um bean real no ApplicationContext por um mock |
| Uso típico | Testes unitários (`@ExtendWith(MockitoExtension)`) | Testes de slice/integração (`@WebMvcTest`, `@SpringBootTest`) |
| Velocidade | Muito rápido | Depende do contexto carregado |

**Exemplo com `@Mock` (teste unitário puro):**

```java
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;  // Mock puro — não entra no Spring

    @InjectMocks
    private UsuarioService service;

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoExiste() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.buscar(99L))
            .isInstanceOf(UsuarioNaoEncontradoException.class);
    }
}
```

**Exemplo com `@MockBean` (teste de slice com Spring):**

```java
@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean  // Substitui o bean UsuarioService real no contexto do Spring
    private UsuarioService usuarioService;

    @Test
    void deveRetornar200QuandoUsuarioExiste() throws Exception {
        // Configura o comportamento do mock dentro do contexto Spring
        when(usuarioService.buscar(1L))
            .thenReturn(new Usuario(1L, "João", "joao@email.com"));

        mockMvc.perform(get("/api/usuarios/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nome").value("João"));
    }
}
```

**Por que `@MockBean` é necessário em testes Spring?**  
Quando você usa `@WebMvcTest`, o Spring carrega o controller e suas dependências, mas **não** carrega os services e repositories. O Spring precisa de um bean `UsuarioService` para injetar no controller, mas como ele não carregou o service real, o teste falha com "bean não encontrado". O `@MockBean` resolve isso: ele cria um mock e o registra como bean no contexto, permitindo que o controller o receba via injeção de dependência.

**Explicação didática:**  
`@Mock` é como criar um ator que interpreta um personagem num palco vazio — não há cenário, apenas o ator. `@MockBean` é como colocar um dublê no meio de uma filmagem real — o cenário (contexto Spring) existe, mas um dos atores foi substituído por um dublê que você controla.

**Como o candidato deve responder:**  
- Explicar que `@Mock` é do Mockito (sem Spring) e `@MockBean` é do Spring Boot Test.
- Mencionar que `@MockBean` substitui um bean no contexto do Spring.
- Explicar que `@Mock` é para testes unitários e `@MockBean` para testes com contexto Spring.
- Mostrar exemplo de uso de cada um.

**Resposta fraca ou incompleta:**  
"Os dois criam mocks, mas o @MockBean é do Spring."  
Falta: não explica quando usar cada um, não mostra o impacto no contexto, não dá exemplos.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece as anotações |
| 1 | Sabe que "criam mocks" mas não diferencia |
| 2 | Menciona que um é Spring e o outro Mockito mas sem contexto |
| 3 | Explica a diferença com exemplos e quando usar cada um |
| 4 | Demonstra que @MockBean substitui bean no ApplicationContext |
| 5 | Responde com profundidade, menciona reset de mocks, impacto em testes paralelos e contexto cacheado |

**Perguntas de aprofundamento:**
1. "O que acontece se você usar `@MockBean` em um teste que não carrega o contexto Spring?"
2. "Os mocks criados com `@MockBean` são resetados entre os testes? Por quê?"
3. "Existe alguma alternativa ao `@MockBean` no Spring Boot 3.x? Qual?"

---

### Pergunta 54 — Como funciona o @WebMvcTest e como testar um controller REST?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"Se você precisa testar apenas a camada web (controller) de uma API Spring Boot, qual anotação usa e como configura o teste? Mostre um exemplo prático."

**O que essa pergunta avalia:**  
Avalia se o candidato sabe que `@WebMvcTest` carrega apenas a camada MVC (controllers, filters, Jackson), sem subir services e repositories, e sabe usar `MockMvc` para simular requisições HTTP.

**Resposta esperada:**  
`@WebMvcTest` é uma anotação de slice que carrega apenas a infraestrutura web do Spring MVC — controllers, `HttpMessageConverters`, filters, exception handlers — sem carregar services, repositories ou banco de dados. As dependências do controller devem ser mockadas com `@MockBean`.

**Exemplo completo:**

```java
@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private GlobalExceptionHandler exceptionHandler;

    @Test
    void deveRetornar200EUsuario_QuandoIdExiste() throws Exception {
        // Arrange
        UsuarioResponseDTO usuario = new UsuarioResponseDTO(1L, "João", "joao@email.com", true);
        when(usuarioService.buscar(1L)).thenReturn(usuario);

        // Act & Assert
        mockMvc.perform(get("/api/usuarios/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.nome").value("João"))
            .andExpect(jsonPath("$.email").value("joao@email.com"));
    }

    @Test
    void deveRetornar404_QuandoUsuarioNaoExiste() throws Exception {
        // Arrange
        when(usuarioService.buscar(99L))
            .thenThrow(new UsuarioNaoEncontradoException(99L));

        // Act & Assert
        mockMvc.perform(get("/api/usuarios/99"))
            .andExpect(status().isNotFound());
    }

    @Test
    void deveRetornar400_QuandoDadosInvalidos() throws Exception {
        // Arrange — DTO com nome vazio (invalida @NotBlank)
        String jsonInvalido = """
            {"nome": "", "email": "joao@email.com", "senha": "12345678"}
            """;

        // Act & Assert
        mockMvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInvalido))
            .andExpect(status().isBadRequest());
    }

    @Test
    void deveRetornar201_ComLocationHeader_QuandoCriaUsuario() throws Exception {
        // Arrange
        String jsonValido = """
            {"nome": "João", "email": "joao@email.com", "senha": "12345678"}
            """;
        UsuarioResponseDTO criado = new UsuarioResponseDTO(1L, "João", "joao@email.com", true);
        when(usuarioService.criar(any(UsuarioCreateDTO.class))).thenReturn(criado);

        // Act & Assert
        mockMvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonValido))
            .andExpect(status().isCreated())
            .andExpect(header().exists("Location"))
            .andExpect(jsonPath("$.nome").value("João"));
    }
}
```

**Pontos importantes:**

1. **`@WebMvcTest(UsuarioController.class)`** — carrega apenas o `UsuarioController`, não todos os controllers. Isso isola o teste.
2. **`MockMvc`** — simula requisições HTTP sem abrir servidor real. É rápido e não precisa de porta.
3. **`@MockBean`** — substitui o service real por um mock. O controller funciona normalmente, mas recebe o mock.
4. **`jsonPath`** — verifica campos específicos do JSON de resposta.
5. **`@ControllerAdvice`** — se houver um `GlobalExceptionHandler`, ele **é** carregado automaticamente por `@WebMvcTest`.

**Explicação didática:**  
`@WebMvcTest` é como testar a recepção de um hotel sem os outros andares. Você simula um hóspede chegando (requisição), verifica se a recepção responde corretamente (status + JSON), mas não precisa que a cozinha, piscina e academia (services, repositories, banco) funcionem — elas são substituídas por simuladores.

**Como o candidato deve responder:**  
- Explicar que `@WebMvcTest` carrega apenas a camada web.
- Mostrar o uso de `MockMvc` para simular requisições.
- Mencionar `@MockBean` para isolar o controller.
- Demonstrar verificação de status, jsonPath e header.
- Citar que `@ControllerAdvice` é carregado automaticamente.

**Resposta fraca ou incompleta:**  
"Você usa @WebMvcTest para testar controllers."  
Falta: não mostra MockMvc, não menciona @MockBean, não demonstra como verificar resposta.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @WebMvcTest |
| 1 | Sabe que "testa controllers" mas não sabe como |
| 2 | Menciona MockMvc mas não usa @MockBean corretamente |
| 3 | Demonstra teste completo com MockMvc, @MockBean e assertions |
| 4 | Inclui testes de erro (404, 400) e verificação de Location header |
| 5 | Responde com profundidade, menciona filtros, @Import para advice e testes de validação |

**Perguntas de aprofundamento:**
1. "Como você testaria um endpoint que recebe `@Valid @RequestBody` e falha na validação?"
2. "O que acontece se o controller depender de um `@ControllerAdvice`? Ele é carregado?"
3. "Como você testaria um endpoint paginado com `Pageable`?"

---

### Pergunta 55 — O que é @DataJpaTest e como testar repositories?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"Para testar a camada de persistência (repositories JPA), o Spring Boot oferece o `@DataJpaTest`. O que essa anotação faz e como você usa para testar um repository?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe que `@DataJpaTest` configura um banco em memória (H2), cria as tabelas automaticamente e oferece rollback por transação, e se consegue escrever testes de repository válidos.

**Resposta esperada:**  
`@DataJpaTest` é uma anotação de slice que configura apenas a camada JPA: `EntityManager`, repositories, datasource em memória (H2 por padrão) e ferramentas de migração (Flyway/Liquibase podem ser desativadas). Cada teste roda em uma transação que faz **rollback automático** ao final, garantindo isolamento.

**Exemplo completo:**

```java
@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void deveBuscarUsuarioPorEmail() {
        // Arrange
        Usuario usuario = new Usuario("João", "joao@email.com", "senha123");
        entityManager.persistAndFlush(usuario);

        // Act
        Optional<Usuario> encontrado = repository.findByEmail("joao@email.com");

        // Assert
        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getNome()).isEqualTo("João");
    }

    @Test
    void deveRetornarVazio_QuandoEmailNaoExiste() {
        Optional<Usuario> encontrado = repository.findByEmail("inexistente@email.com");
        assertThat(encontrado).isEmpty();
    }

    @Test
    void deveBuscarUsuariosAtivosOrdenadosPorNome() {
        // Arrange
        entityManager.persist(new Usuario("Carlos", "carlos@email.com", "senha"));
        entityManager.persist(new Usuario("Ana", "ana@email.com", "senha"));
        entityManager.persist(new Usuario("Bruno", "bruno@email.com", "senha"));
        entityManager.flush();

        // Act
        List<Usuario> ativos = repository.findByAtivoTrueOrderByNome();

        // Assert
        assertThat(ativos).hasSize(3);
        assertThat(ativos).extracting(Usuario::getNome)
            .containsExactly("Ana", "Bruno", "Carlos");
    }

    @Test
    void deveContarUsuariosPorStatus() {
        entityManager.persist(new Usuario("João", "joao@email.com", "senha"));
        entityManager.persist(new Usuario("Maria", "maria@email.com", "senha"));

        long total = repository.count();

        assertThat(total).isEqualTo(2);
    }
}
```

**Características importantes:**

1. **Banco H2 em memória** — por padrão, o Spring Boot substitui o banco real por H2. Não precisa de Docker ou banco externo.
2. **`TestEntityManager`** — alternativa ao repository para configurar dados de teste. Útil para persistir entidades que ainda não têm repository ou para forçar flush.
3. **Rollback automático** — cada `@Test` roda dentro de uma transação que é revertida ao final. O banco "zera" entre testes.
4. **Flyway/Liquibase** — por padrão, `@DataJpaTest` **desativa** migrações e usa `hibernate.hbm2ddl.auto=create-drop` para criar tabelas via entidades. Para ativar Flyway, use `@DataJpaTest` com `@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)`.

**Explicação didática:**  
`@DataJpaTest` é como ter uma maquete do seu banco de dados. Em vez de usar o banco real (que pode ser lento e ter dados de produção), ele cria um banco "de brinquedo" (H2 em memória) que se comporta como o real para testes. Entre cada teste, a maquete é "limpa" para que um teste não interfira no outro.

**Como o candidato deve responder:**  
- Explicar que `@DataJpaTest` carrega apenas a camada JPA com banco em memória.
- Mencionar o uso do H2 por padrão.
- Explicar o rollback automático entre testes.
- Mostrar exemplo com `TestEntityManager` ou `repository` direto.
- Citar que Flyway/Liquibase são desativados por padrão.

**Resposta fraca ou incompleta:**  
"Testa os repositories com um banco em memória."  
Falta: não explica rollback, não menciona TestEntityManager, não mostra exemplo prático.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @DataJpaTest |
| 1 | Sabe que "testa repositories" mas não explica como |
| 2 | Menciona H2 mas não sabe do rollback automático |
| 3 | Explica H2, rollback e mostra exemplo com TestEntityManager |
| 4 | Demonstra testes de query methods, @Query e assertions |
| 5 | Responde com profundidade, menciona configuração de Flyway, @AutoConfigureTestDatabase e isolamento |

**Perguntas de aprofundamento:**
1. "Como você ativaria o Flyway em vez do create-drop do Hibernate nos testes?"
2. "Por que usar `TestEntityManager` em vez do próprio repository no arrange?"
3. "Como você testaria uma query nativa (`nativeQuery = true`)?"

---

### Pergunta 56 — O que é o Mockito e como usar when/verify nos testes?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"O Mockito é a biblioteca de mocking mais usada no ecossistema Spring Boot. Como você configura o comportamento de um mock e como verifica se um método foi chamado?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe usar os dois pilares do Mockito: `when().thenReturn()` para configurar comportamento e `verify()` para confirmar interações.

**Resposta esperada:**  
O Mockito é um framework de mocking que permite criar objetos simulados (mocks) que imitam o comportamento de objetos reais. Em testes Spring Boot, é usado principalmente em testes unitários e de slice para isolar a classe testada de suas dependências.

**1. Configurando comportamento com `when().thenReturn()`:**

```java
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private UsuarioService service;

    @Test
    void deveRetornarUsuario_QuandoExiste() {
        // Arrange — configura o comportamento do mock
        Usuario usuario = new Usuario(1L, "João", "joao@email.com");
        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        // Act
        Usuario resultado = service.buscar(1L);

        // Assert
        assertThat(resultado.getNome()).isEqualTo("João");
    }

    @Test
    void deveLancarExcecao_QuandoUsuarioNaoExiste() {
        // Arrange — configura o mock para lançar exceção
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> service.buscar(99L))
            .isInstanceOf(UsuarioNaoEncontradoException.class)
            .hasMessageContaining("99");
    }
}
```

**2. Verificando interações com `verify()`:**

```java
@Test
void deveEnviarEmail_QuandoUsuarioCriado() {
    // Arrange
    UsuarioCreateDTO dto = new UsuarioCreateDTO("João", "joao@email.com", "senha123");
    Usuario usuarioSalvo = new Usuario(1L, "João", "joao@email.com");
    when(repository.save(any(Usuario.class))).thenReturn(usuarioSalvo);

    // Act
    service.criar(dto);

    // Verify — confirma que o método foi chamado
    verify(repository).save(any(Usuario.class));       // save foi chamado 1x
    verify(emailService).enviarEmailBoasVindas("joao@email.com"); // email foi enviado
    verify(emailService, never()).enviarErro(anyString();        // erro nunca foi enviado
}


@Test
void deveSalvarUsuario_ExatamenteUmaVez() {
    UsuarioCreateDTO dto = new UsuarioCreateDTO("João", "joao@email.com", "senha123");
    when(repository.save(any(Usuario.class)))
        .thenReturn(new Usuario(1L, "João", "joao@email.com"));

    service.criar(dto);

    // Verifica que save foi chamado exatamente 1 vez
    verify(repository, times(1)).save(any(Usuario.class));
}

@Test
void naoDeveBuscarUsuario_QuandoOperacaoNaoRequerBusca() {
    // Act — chama um método que não deveria acessar o repository
    service.processarCacheLocal();

    // Verify — confirma que findById nunca foi chamado
    verify(repository, never()).findById(anyLong());
}
}
```

**Principais modos de `verify()`:**

| Modo | Significado |
|------|-------------|
| `verify(mock).metodo()` | Foi chamado exatamente 1 vez |
| `verify(mock, times(2)).metodo()` | Foi chamado exatamente 2 vezes |
| `verify(mock, never()).metodo()` | Nunca foi chamado |
| `verify(mock, atLeastOnce()).metodo()` | Foi chamado pelo menos 1 vez |
| `verify(mock, atMost(3)).metodo()` | Foi chamado no máximo 3 vezes |
| `verifyNoMoreInteractions(mock)` | Nenhuma outra chamada além das já verificadas |

**Argument matchers mais usados:**

| Matcher | Significado |
|---------|-------------|
| `any()` | Qualquer valor (incluindo null) |
| `any(Class.class)` | Qualquer valor do tipo especificado |
| `anyLong()`, `anyString()` | Qualquer valor primitivo/objeto do tipo |
| `eq("valor")` | Igual ao valor especificado (para combinar argumentos específicos) |
| `argThat(predicate)` | Valor que satisfaz uma condição lambda |

**Explicação didática:**  
`when().thenReturn()` é como programar um GPS: você diz "quando eu perguntar o caminho para a rua X, me responda Y". `verify()` é como checar o histórico de chamadas: você confirma que a pessoa certa foi contactada o número correto de vezes. Juntos, eles permitem testar tanto o **resultado** quanto o **comportamento** — não apenas "o que saiu", mas "quem foi chamado e com quais argumentos".

**Como o candidato deve responder:**  
- Explicar que `when().thenReturn()` configura o comportamento do mock.
- Explicar que `verify()` confirma que um método foi chamado (e quantas vezes).
- Citar pelo menos `times(1)`, `never()` e `any()`.
- Mencionar que argument matchers permitem flexibilidade nas verificações.

**Resposta fraca ou incompleta:**  
"Você usa `when` para retornar valores e `verify` para checar chamadas."  
Falta: não mostra exemplos, não cita matchers, não menciona `times`/`never`.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece Mockito |
| 1 | Sabe que "cria mocks" mas não usa when/verify |
| 2 | Usa when().thenReturn() mas não usa verify() |
| 3 | Explica when, verify e matchers com exemplos |
| 4 | Demonstra times, never, any e argThat |
| 5 | Responde com profundidade, menciona verifyNoMoreInteractions, spies e limitações |

**Perguntas de aprofundamento:**
1. "Qual a diferença entre `any()` e `eq()`? Quando você precisa usar `eq`?"
2. "O que é um Spy no Mockito e como difere de um Mock?"
3. "O que acontece se você misturar matchers com valores literais na mesma chamada de `verify`?"

---

### Pergunta 57 — O que é o AssertJ e por que usá-lo em vez do JUnit Assertions?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"O Spring Boot Starter Test traz tanto o JUnit Assertions quanto o AssertJ. O que é o AssertJ e por que muitas equipes preferem usá-lo?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o AssertJ como biblioteca de assertions fluente, sabe escrever assertions encadeadas e entende as vantagens sobre o `assertEquals` tradicional.

**Resposta esperada:**  
AssertJ é uma biblioteca de assertions que usa uma **API fluente** (encadeamento de métodos) para tornar os testes mais legíveis e expressivos. Em vez de:

```java
// JUnit Assertions — tradicional
assertEquals("João", usuario.getNome());
assertTrue(usuario.isAtivo());
assertNotNull(usuario.getEmail());
assertEquals(3, lista.size());
```

Com AssertJ:

```java
// AssertJ — fluente e legível
assertThat(usuario.getNome()).isEqualTo("João");
assertThat(usuario.isAtivo()).isTrue();
assertThat(usuario.getEmail()).isNotNull();
assertThat(lista).hasSize(3);
```

**Vantagens do AssertJ:**

**1. Mensagens de erro mais descritivas:**
```java
// JUnit — mensagem genérica
// expected: <João> but was: <Maria>

// AssertJ — mensagem detalhada
// Expecting actual: "Maria" to be equal to: "João" but was not.
```

**2. Assertions encadeadas:**
```java
assertThat(usuario)
    .isNotNull()
    .extracting(Usuario::getNome, Usuario::getEmail, Usuario::isAtivo)
    .containsExactly("João", "joao@email.com", true);
```

**3. Assertions específicas para coleções:**
```java
List<Usuario> usuarios = usuarioService.listarTodos();

assertThat(usuarios)
    .hasSize(3)
    .extracting(Usuario::getNome)
    .containsExactly("Ana", "Bruno", "Carlos")  // ordem importa
    .doesNotContain("Zoe");
```

**4. Assertions para exceções:**
```java
assertThatThrownBy(() -> service.buscar(99L))
    .isInstanceOf(UsuarioNaoEncontradoException.class)
    .hasMessageContaining("99")
    .hasMessageEndingWith("não encontrado");
```

**5. Assertions para Optional:**
```java
Optional<Usuario> resultado = repository.findByEmail("joao@email.com");

assertThat(resultado)
    .isPresent()
    .get()
    .extracting(Usuario::getNome)
    .isEqualTo("João");

// ou
assertThat(resultado).isEmpty(); // para Optional vazio
```

**6. Soft assertions (não para no primeiro erro):**
```java
SoftAssertions softly = new SoftAssertions();

softly.assertThat(usuario.getNome()).isEqualTo("João");
softly.assertThat(usuario.getEmail()).isEqualTo("joao@email.com");
softly.assertThat(usuario.isAtivo()).isTrue();
softly.assertThat(usuario.getIdade()).isEqualTo(30);

// Reporta TODOS os erros de uma vez
softly.assertAll();
```

**Explicação didática:**  
JUnit Assertions é como preencher um formulário com campos separados — cada assertion é uma linha isolada. AssertJ é como escrever uma frase fluida: "verifique que o usuário não é nulo, extraia o nome e confirme que é João". A leitura flui naturalmente, como linguagem humana, e as mensagens de erro são mais úteis quando algo falha.

**Como o candidato deve responder:**  
- Explicar que AssertJ é uma biblioteca de assertions com API fluente.
- Mostrar comparação com `assertEquals` tradicional.
- Citar pelo menos duas vantagens: legibilidade e mensagens de erro.
- Demonstrar uso com coleções (`extracting`, `containsExactly`) e exceções.
- Mencionar que vem incluído no `spring-boot-starter-test`.

**Resposta fraca ou incompleta:**  
"AssertJ é mais fácil de ler."  
Falta: não mostra exemplos, não cita encadeamento, não menciona mensagens de erro.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece AssertJ |
| 1 | Sabe que "é uma alternativa ao JUnit" mas não usa |
| 2 | Usa assertThat básico mas não conhece encadeamento |
| 3 | Demonstra fluência com extracting, hasSize e exceções |
| 4 | Inclui soft assertions e Optional assertions |
| 5 | Responde com profundidade, menciona custom assertions, Condition e integração com Spring Boot Test |

**Perguntas de aprofundamento:**
1. "Como você criaria uma assertion customizada no AssertJ?"
2. "Qual a diferença entre `containsExactly` e `containsOnly`?"
3. "Quando você usaria SoftAssertions em vez de assertions normais?"

---

### Pergunta 58 — Como testar a camada de serviço isoladamente sem subir o contexto Spring?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"Você tem uma classe `PedidoService` que depende de `PedidoRepository`, `ProdutoService` e `EmailService`. Como você testaria essa classe de forma totalmente isolada, sem subir o contexto do Spring?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe escrever testes unitários puros com Mockito (sem `@SpringBootTest`), usando `@ExtendWith(MockitoExtension)`, `@Mock` e `@InjectMocks`, e se entende que essa abordagem é a mais rápida para testar lógica de negócio.

**Resposta esperada:**  
Para testar a camada de serviço isoladamente, usa-se **Mockito puro** sem carregar o contexto do Spring. As dependências são substituídas por mocks, e a classe testada é instanciada com `@InjectMocks`.

**Exemplo completo:**

```java
// Classe a ser testada
@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final EmailService emailService;

    public PedidoResponseDTO criarPedido(PedidoCreateDTO dto) {
        // 1. Busca produtos e valida
        List<Produto> produtos = dto.getItens().stream()
            .map(item -> produtoService.buscarPorId(item.getProdutoId())
                .orElseThrow(() -> new ProdutoNaoEncontradoException(item.getProdutoId())))
            .toList();

        // 2. Calcula total
        BigDecimal total = produtos.stream()
            .map(Produto::getPreco)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 3. Cria e salva pedido
        Pedido pedido = new Pedido(dto.getClienteId(), produtos, total);
        Pedido salvo = pedidoRepository.save(pedido);

        // 4. Envia e-mail de confirmação
        emailService.enviarConfirmacao(dto.getClienteId(), salvo.getId());

        return new PedidoResponseDTO(salvo.getId(), dto.getClienteId(), total);
    }

    public void cancelarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(() -> new PedidoNaoEncontradoException(id));

        if (pedido.getStatus() == StatusPedido.ENTREGUE) {
            throw new PedidoNaoCancelavelException(
                "Pedido entregue não pode ser cancelado");
        }

        pedido.setStatus(StatusPedido.CANCELADO);
        pedidoRepository.save(pedido);
        emailService.enviarCancelamento(pedido.getClienteId(), id);
    }
}
```

**Teste unitário isolado:**

```java
@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ProdutoService produtoService;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private PedidoService service;

    @Test
    void deveCriarPedido_QuandoProdutosExistem() {
        // Arrange
        PedidoCreateDTO dto = new PedidoCreateDTO(
            1L,
            List.of(new ItemDTO(10L), new ItemDTO(20L))
        );

        Produto p1 = new Produto(10L, "Notebook", new BigDecimal("3000"));
        Produto p2 = new Produto(20L, "Mouse", new BigDecimal("50"));

        when(produtoService.buscarPorId(10L)).thenReturn(Optional.of(p1));
        when(produtoService.buscarPorId(20L)).thenReturn(Optional.of(p2));
        when(pedidoRepository.save(any(Pedido.class)))
            .thenAnswer(invocation -> {
                Pedido p = invocation.getArgument(0);
                p.setId(100L); // simula o ID gerado pelo banco
                return p;
            });

        // Act
        PedidoResponseDTO resultado = service.criarPedido(dto);

        // Assert — resultado
        assertThat(resultado.id()).isEqualTo(100L);
        assertThat(resultado.clienteId()).isEqualTo(1L);
        assertThat(resultado.total()).isEqualByComparingTo("3050");

        // Verify — comportamento
        verify(pedidoRepository).save(any(Pedido.class));
        verify(emailService).enviarConfirmacao(1L, 100L);
    }

    @Test
    void deveLancarExcecao_QuandoProdutoNaoExiste() {
        // Arrange
        PedidoCreateDTO dto = new PedidoCreateDTO(
            1L,
            List.of(new ItemDTO(999L))
        );

        when(produtoService.buscarPorId(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> service.criarPedido(dto))
            .isInstanceOf(ProdutoNaoEncontradoException.class);

        // Verify — pedido NÃO foi salvo, e-mail NÃO foi enviado
        verify(pedidoRepository, never()).save(any());
        verify(emailService, never()).enviarConfirmacao(anyLong(), anyLong());
    }

    @Test
    void deveCancelarPedido_QuandoStatusPermite() {
        // Arrange
        Pedido pedido = new Pedido(1L, 50L, StatusPedido.PENDENTE);
        when(pedidoRepository.findById(50L)).thenReturn(Optional.of(pedido));

        // Act
        service.cancelarPedido(50L);

        // Assert
        assertThat(pedido.getStatus()).isEqualTo(StatusPedido.CANCELADO);
        verify(pedidoRepository).save(pedido);
        verify(emailService).enviarCancelamento(1L, 50L);
    }

    @Test
    void naoDeveCancelarPedido_QuandoJaEntregue() {
        // Arrange
        Pedido pedido = new Pedido(1L, 50L, StatusPedido.ENTREGUE);
        when(pedidoRepository.findById(50L)).thenReturn(Optional.of(pedido));

        // Act & Assert
        assertThatThrownBy(() -> service.cancelarPedido(50L))
            .isInstanceOf(PedidoNaoCancelavelException.class)
            .hasMessageContaining("entregue");

        // Verify — nada foi salvo nem e-mail enviado
        verify(pedidoRepository, never()).save(any());
        verify(emailService, never()).enviarCancelamento(anyLong(), anyLong());
    }
}
```

**Por que não usar `@SpringBootTest` aqui?**

| Aspecto | Teste unitário (Mockito) | @SpringBootTest |
|---------|--------------------------|-----------------|
| Tempo de execução | ~10ms | ~2-5s |
| Dependências | Mockadas (controladas) | Reais (banco, services) |
| Foco | Lógica de negócio isolada | Integração entre camadas |
| Manutenção | Baixa | Alta (quebra com mudanças de config) |
| Debug | Fácil (stack trace curto) | Difícil (muitas camadas) |

**Explicação didática:**  
Testar o service com `@SpringBootTest` é como testar se um motor funciona ligando o carro inteiro e dando uma volta no quarteirão — funciona, mas é lento e você não sabe se o problema é o motor, o combustível ou a transmissão. O teste unitário com mocks é como testar o motor em um banco de testes: você controla exatamente o que entra (combustível, temperatura) e mede só o que o motor faz.

**Como o candidato deve responder:**  
- Explicar que usa `@ExtendWith(MockitoExtension.class)` sem contexto Spring.
- Mostrar `@Mock` para dependências e `@InjectMocks` para a classe testada.
- Demonstrar `when().thenReturn()` para configurar comportamento.
- Usar `verify()` para confirmar interações (especialmente `never()` em cenários de erro).
- Mencionar que é a forma mais rápida de testar lógica de negócio.

**Resposta fraca ou incompleta:**  
"Você usa `@MockBean` e `@SpringBootTest`."  
Falta: usa contexto Spring desnecessariamente, não explica como isolar, não mostra verify.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe testar services isoladamente |
| 1 | Usa @SpringBootTest para teste unitário |
| 2 | Usa @ExtendWith(MockitoExtension) mas não diferencia @Mock de @MockBean |
| 3 | Demonstra teste isolado com @Mock, @InjectMocks, when e verify |
| 4 | Inclui cenários de erro com never(), thenAnswer e assertions de exceção |
| 5 | Responde com profundidade, menciona limitações do @InjectMocks, testabilidade de design e cobertura |

**Perguntas de aprofundamento:**
1. "O que acontece se a classe testada tiver dependências que não estão no construtor? O `@InjectMocks` funciona?"
2. "Como você testaria um método `void` que não retorna nada?"
3. "Se o service usar `@Value` para ler uma propriedade, como você testaria isso sem contexto Spring?"

---

### Pergunta 59 — Como usar o H2 em testes de integração e qual a relação com o banco de produção?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"Em testes de integração com `@SpringBootTest`, o Spring Boot pode usar um banco H2 em memória. Como você configura isso e quais cuidados deve ter ao usar H2 se o banco de produção é PostgreSQL ou MySQL?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe configurar H2 em testes, entende as diferenças entre H2 e bancos de produção (dialect, funções, tipos), e conhece os riscos de falsos positivos/negativos.

**Resposta esperada:**  
O H2 é um banco de dados em memória (ou arquivo) muito usado em testes por ser rápido e não requerer infraestrutura externa. O Spring Boot o detecta automaticamente quando está no classpath e configura o `DataSource` sem precisar de URLs ou credenciais.

**1. Configuração básica — `application-test.properties`:**

```properties
# DataSource de teste — H2 em memória
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA — cria tabelas automaticamente e mostra SQL
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# H2 Console (acessível em /h2-console durante testes)
spring.h2.console.enabled=true
```

**2. Ativação do profile de teste:**

```java
@SpringBootTest
@ActiveProfiles("test")
class PedidoIntegrationTest {

    @Autowired
    private PedidoRepository repository;

    @Test
    void deveSalvarEBuscarPedido() {
        Pedido pedido = new Pedido("Cliente X", BigDecimal.valueOf(100));
        Pedido salvo = repository.save(pedido);

        Optional<Pedido> encontrado = repository.findById(salvo.getId());

        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getCliente()).isEqualTo("Cliente X");
    }
}
```

**3. Dependência no `pom.xml`:**

```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>test</scope>
</dependency>
```

**Cuidados ao usar H2 com banco de produção diferente:**

| Problema | H2 | PostgreSQL/MySQL | Impacto |
|----------|-----|-------------------|---------|
| SQL dialect | H2 SQL | PostgreSQL SQL | Query que funciona no H2 pode falhar em prod |
| Tipos de dados | Suporta maioria | Tipos específicos (JSONB, ARRAY) | Entidade com tipo específico não testa corretamente |
| Funções nativas | Funções limitadas | `COALESCE`, `STRING_AGG`, window functions | `@Query` nativa pode passar no teste e falhar em prod |
| Constraints | Suporta básico | Suporte completo (deferred, partial) | Validação de constraint pode diferir |
| Modo de compatibilidade | `MODE=PostgreSQL` | N/A | Aproxima mas não garante 100% |

**4. Usando modo de compatibilidade:**

```properties
# H2 em modo de compatibilidade com PostgreSQL
spring.datasource.url=jdbc:h2:mem:testdb;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE
```

Isso faz o H2 aceitar a maioria da sintaxe PostgreSQL, mas **não garante compatibilidade total**.

**5. Alternativa — Testcontainers (para testes realistas):**

Quando os testes precisam ser fiéis ao banco de produção, usa-se Testcontainers, que sobe um banco real em Docker:

```java
@SpringBootTest
@Testcontainers
class PedidoIntegrationTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
        .withDatabaseName("testdb")
        .withUsername("test")
        .withPassword("test");

    @DynamicPropertySource
    static void configurarDataSource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private PedidoRepository repository;

    @Test
    void deveSalvarPedido_ComBancoRealPostgreSQL() {
        // Teste rodando contra um PostgreSQL real em container
    }
}
```

**Explicação didática:**  
Usar H2 em testes é como treinar em um simulador de voo — é rápido, barato e ótimo para a maioria dos cenários. Mas se você está testando uma manobra que depende de características específicas de um modelo de avião (PostgreSQL), o simulador genérico pode não reproduzir todos os detalhes. Para esses casos, é melhor usar o avião real (Testcontainers com PostgreSQL).

**Como o candidato deve responder:**  
- Explicar que H2 é um banco em memória usado em testes.
- Mostrar a configuração em `application-test.properties`.
- Mencionar pelo menos um cuidado: diferenças de SQL dialect.
- Citar o modo de compatibilidade (`MODE=PostgreSQL`).
- Mencionar Testcontainers como alternativa para fidelidade total.

**Resposta fraca ou incompleta:**  
"H2 é um banco em memória para testes."  
Falta: não mostra configuração, não menciona diferenças de dialect, não fala de riscos.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece H2 |
| 1 | Sabe que "é um banco em memória" mas não configura |
| 2 | Configura H2 mas não sabe das diferenças com produção |
| 3 | Explica configuração, diferenças de dialect e modo de compatibilidade |
| 4 | Demonstra conhecimento de riscos e menciona Testcontainers |
| 5 | Responde com profundidade, compara H2 vs Testcontainers, menciona migrações e scope test |

**Perguntas de aprofundamento:**
1. "Se o seu projeto usa Flyway, o que acontece com as migrações quando você usa H2 em testes?"
2. "Como você garantirá que uma `@Query` nativa com função PostgreSQL funciona corretamente nos testes?"
3. "Qual a desvantagem de usar `ddl-auto=create-drop` em testes em relação a usar Flyway?"

---

### Pergunta 60 — Como estruturar um teste de integração ponta a ponta no Spring Boot?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"Você precisa testar o fluxo completo de criação de um usuário: receber POST via API, salvar no banco, enviar e-mail de confirmação e retornar 201. Como você estrutura esse teste de integração ponta a ponta?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe montar um teste de integração completo com `@SpringBootTest`, `TestRestTemplate` ou `MockMvc`, isolar efeitos colaterais (como e-mail) e verificar o resultado de ponta a ponta.

**Resposta esperada:**  
Um teste de integração ponta a ponta (E2E) valida o fluxo completo da requisição HTTP até a persistência e efeitos colaterais. No Spring Boot, isso é feito com `@SpringBootTest(webEnvironment = RANDOM_PORT)` e `TestRestTemplate`.

**Exemplo completo:**

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UsuarioE2ETest {

    @LocalServerPort
    private int porta;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsuarioRepository repository;

    @MockBean  // Mocka o e-mail para não enviar e-mail real durante o teste
    private EmailService emailService;

    @BeforeEach
    void limparBase() {
        repository.deleteAll();
    }

    @Test
    void deveCriarUsuario_Retornar201_SalvarNoBanco_EnviarEmail() {
        // Arrange
        String json = """
            {
                "nome": "João Silva",
                "email": "joao@email.com",
                "senha": "senha12345"
            }
            """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        // Act — faz a requisição HTTP real
        ResponseEntity<UsuarioResponseDTO> resposta = restTemplate.postForEntity(
            "/api/usuarios",
            request,
            UsuarioResponseDTO.class
        );

        // Assert — status HTTP
        assertThat(resposta.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        // Assert — header Location
        assertThat(resposta.getHeaders().getLocation()).isNotNull();
        assertThat(resposta.getHeaders().getLocation().getPath())
            .startsWith("/api/usuarios/");

        // Assert — corpo da resposta
        assertThat(resposta.getBody()).isNotNull();
        assertThat(resposta.getBody().nome()).isEqualTo("João Silva");
        assertThat(resposta.getBody().email()).isEqualTo("joao@email.com");
        assertThat(resposta.getBody().ativo()).isTrue();

        // Assert — persistência no banco
        List<Usuario> usuarios = repository.findAll();
        assertThat(usuarios).hasSize(1);
        assertThat(usuarios.get(0).getNome()).isEqualTo("João Silva");
        assertThat(usuarios.get(0).getSenha()).isNotEqualTo("senha12345"); // deve estar hasheada

        // Assert — e-mail foi enviado
        verify(emailService).enviarBoasVindas("joao@email.com");
    }

    @Test
    void deveRetornar400_QuandoEmailJaExiste() {
        // Arrange — cria usuário prévio
        repository.save(new Usuario("Maria", "maria@email.com", "hash123"));

        String jsonDuplicado = """
            {
                "nome": "Maria Santos",
                "email": "maria@email.com",
                "senha": "novasenha"
            }
            """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonDuplicado, headers);

        // Act
        ResponseEntity<Map> resposta = restTemplate.postForEntity(
            "/api/usuarios",
            request,
            Map.class
        );

        // Assert
        assertThat(resposta.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
        assertThat(resposta.getBody()).containsKey("mensagem");
    }

    @Test
    void deveBuscarUsuarioCriado_AposCriacao() {
        // Arrange — cria via API
        String json = """
            {
                "nome": "Carlos",
                "email": "carlos@email.com",
                "senha": "senha12345"
            }
            """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<UsuarioResponseDTO> criado = restTemplate.postForEntity(
            "/api/usuarios", request, UsuarioResponseDTO.class
        );

        Long id = criado.getBody().id();

        // Act — busca via API
        ResponseEntity<UsuarioResponseDTO> buscado = restTemplate.getForEntity(
            "/api/usuarios/" + id,
            UsuarioResponseDTO.class
        );

        // Assert
        assertThat(buscado.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(buscado.getBody().nome()).isEqualTo("Carlos");
    }

    @AfterEach
    void limpar() {
        repository.deleteAll();
    }
}
```

**Pontos-chave da estrutura:**

1. **`@SpringBootTest(RANDOM_PORT)`** — sobe a aplicação real em porta aleatória.
2. **`TestRestTemplate`** — faz requisições HTTP reais para a aplicação.
3. **`@MockBean` para efeitos colaterais** — o `EmailService` é mockado para não enviar e-mail real.
4. **`@BeforeEach` / `@AfterEach`** — limpa o banco entre testes para garantir isolamento.
5. **Múltiplas assertions em diferentes níveis** — status HTTP, corpo, persistência e comportamento (e-mail).
6. **`@ActiveProfiles("test")`** — usa configurações de teste (H2 em memória).

**Explicação didática:**  
Um teste E2E é como um teste de entrega em um restaurante. Você faz o pedido (POST), verifica se a cozinha registrou (banco), confirma que o garçom trouxe o prato correto (resposta HTTP), e checa se enviaram a nota fiscal por e-mail (efeito colateral). Cada etapa é verificada independentemente, mas o teste valida o fluxo inteiro de ponta a ponta.

**Como o candidato deve responder:**  
- Explicar que usa `@SpringBootTest(RANDOM_PORT)` com `TestRestTemplate`.
- Mencionar que efeitos colaterais (e-mail) devem ser mockados com `@MockBean`.
- Mostrar que verifica múltiplos níveis: status HTTP, corpo, banco e comportamento.
- Explicar a importância de limpar o banco entre testes (`@BeforeEach`/`@AfterEach`).
- Citar `@ActiveProfiles("test")` para isolar configuração.

**Resposta fraca ou incompleta:**  
"Você usa `@SpringBootTest` e testa se retorna 201."  
Falta: não verifica persistência, não mocka e-mail, não limpa banco, não verifica corpo da resposta.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe estruturar teste E2E |
| 1 | Usa @SpringBootTest mas só verifica status |
| 2 | Verifica status e corpo mas não persistência nem efeitos colaterais |
| 3 | Demonstra teste completo com banco, e-mail mockado e múltiplas assertions |
| 4 | Inclui isolamento (@BeforeEach), cenários de erro e fluxo completo |
| 5 | Responde com profundidade, menciona @Transactional em testes, limitações e trade-offs de E2E |

**Perguntas de aprofundamento:**
1. "Como você lidaria com a limpeza do banco se não pudesse usar `@BeforeEach` com `deleteAll()`?"
2. "É possível usar `@Transactional` em testes E2E? Qual o efeito?"
3. "Como você testaria um endpoint autenticado (com Spring Security) nesse fluxo E2E?"

---

## Roteiro de Entrevista Técnica — Spring Boot

### Parte 7 de 10 — Perguntas 61 a 70

**Foco:** @Scheduled, @Async, caching (@Cacheable), eventos, ApplicationEvent, Spring Security básico, CORS, file upload

---

### Pergunta 61 — O que é e como funciona o @Scheduled no Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em alguns projetos, precisamos executar tarefas automaticamente em intervalos regulares — como enviar um relatório diário ou limpar dados temporários. Como o Spring Boot permite agendar tarefas e quais opções de configuração existem?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe ativar o agendamento com `@EnableScheduling`, conhece as três formas de configurar `@Scheduled` (fixedRate, fixedDelay, cron) e entende a diferença entre elas.

**Resposta esperada:**  
O Spring Boot oferece suporte nativo a agendamento de tarefas através do módulo Spring Context Scheduling. Para usar, são necessários dois passos:

**1. Ativar o agendamento na aplicação:**

```java
@SpringBootApplication
@EnableScheduling  // Habilita o suporte a tarefas agendadas
public class MinhaAplicacao {
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }
}
```

**2. Anotar métodos com `@Scheduled`:**

```java
@Component
@RequiredArgsConstructor
public class RelatorioScheduler {

    private final RelatorioService relatorioService;

    // fixedRate — executa a cada 5 segundos, independente do tempo de execução
    // A próxima execução começa 5s após o INÍCIO da execução anterior
    @Scheduled(fixedRate = 5000)
    public void gerarRelatorioRapido() {
        relatorioService.gerar();
    }

    // fixedDelay — executa 5 segundos após o TÉRMINO da execução anterior
    // Garante intervalo mínimo entre execuções
    @Scheduled(fixedDelay = 5000)
    public void limparDadosTemporarios() {
        relatorioService.limpar();
    }

    // cron — expressão cron para agendamento preciso
    // "0 0 8 * * MON-FRI" = todo dia útil às 08:00
    @Scheduled(cron = "0 0 8 * * MON-FRI")
    public void relatorioDiario() {
        relatorioService.enviarRelatorioDiario();
    }

    // initialDelay — espera 30 segundos antes da primeira execução
    @Scheduled(fixedRate = 60000, initialDelay = 30000)
    public void verificarSistema() {
        relatorioService.verificar();
    }
}
```

**Diferença entre fixedRate e fixedDelay:**

| Atributo | Comportamento | Exemplo |
|----------|---------------|---------|
| `fixedRate` | Próxima execução começa N ms após o **início** da anterior | Se a tarefa leva 3s e fixedRate=5s: executa em 0s, 5s, 10s, 15s... |
| `fixedDelay` | Próxima execução começa N ms após o **término** da anterior | Se a tarefa leva 3s e fixedDelay=5s: executa em 0s, 8s, 16s, 24s... |
| `cron` | Agenda baseada em expressão cron (segundo, minuto, hora, dia, mês, dia da semana) | `0 0 8 * * MON-FRI` = segundas a sextas às 8h |

**Expressão cron — campos:**

```
0  0  8  *  *  MON-FRI
│  │  │  │  │  │
│  │  │  │  │  └── dia da semana (0-7 ou SUN-SAT)
│  │  │  │  └───── mês (1-12 ou JAN-DEC)
│  │  │  └──────── dia do mês (1-31)
│  │  └─────────── hora (0-23)
│  └────────────── minuto (0-59)
└───────────────── segundo (0-59)
```

**Explicação didática:**  
`fixedRate` é como um ônibus que sai do ponto exatamente a cada 5 minutos, não importa quanto tempo demorou a viagem anterior. `fixedDelay` é como um ônibus que sai 5 minutos **depois** de voltar da viagem anterior — se a viagem atrasou, o próximo sai mais tarde. `cron` é como um despertador que você programa para tocar em horários específicos: "toda segunda às 8h da manhã".

**Como o candidato deve responder:**  
- Mencionar `@EnableScheduling` para ativar o recurso.
- Explicar as três formas: `fixedRate`, `fixedDelay` e `cron`.
- Diferenciar `fixedRate` (início) de `fixedDelay` (término).
- Mostrar exemplo prático com pelo menos duas formas.
- Mencionar `initialDelay` como opcional.

**Resposta fraca ou incompleta:**  
"Você usa @Scheduled com um tempo em milissegundos."  
Falta: não menciona @EnableScheduling, não diferencia fixedRate de fixedDelay, não cita cron.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @Scheduled |
| 1 | Sabe que "agenda tarefas" mas não explica como |
| 2 | Usa fixedRate mas não conhece fixedDelay nem cron |
| 3 | Explica as três formas com exemplos e @EnableScheduling |
| 4 | Demonstra conhecimento da expressão cron e initialDelay |
| 5 | Responde com profundidade, menciona thread pool, @Async com @Scheduled e limitações |

**Perguntas de aprofundamento:**
1. "O que acontece se um método @Scheduled demorar mais que o fixedRate? Ele executa em paralelo?"
2. "Como você faria para que a expressão cron venha do application.properties em vez de estar fixa no código?"
3. "As tarefas @Scheduled rodam em qual thread? É possível configurar um pool de threads?"

---

### Pergunta 62 — O que é e como funciona o @Async no Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Algumas operações em uma aplicação Spring Boot podem demorar — como enviar um e-mail ou gerar um relatório. Como você faz para que essas operações não bloqueiem a thread principal e sejam executadas em background?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe ativar suporte assíncrono com `@EnableAsync`, usar `@Async` em métodos, e entende que o Spring usa um pool de threads por trás.

**Resposta esperada:**  
O Spring Boot permite execução assíncrona de métodos através da anotação `@Async`. Quando um método anotado é chamado, o Spring intercepta a chamada e executa o método em uma **thread separada**, permitindo que a thread chamadora continue sem esperar.

**Configuração:**

```java
@SpringBootApplication
@EnableAsync  // Habilita o suporte a métodos assíncronos
public class MinhaAplicacao {
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }
}
```

**Uso prático:**

```java
@Service
@RequiredArgsConstructor
public class PedidoService {

    private final EmailService emailService;
    private final PedidoRepository repository;

    // Método síncrono — o cliente espera até terminar
    public Pedido criarPedido(PedidoDTO dto) {
        Pedido pedido = repository.save(new Pedido(dto));
        // Chama método assíncrono — não bloqueia
        emailService.enviarEmailConfirmacao(pedido.getEmail(), pedido.getId());
        return pedido;  // Retorna imediatamente, o e-mail continua sendo enviado em background
    }
}

@Service
public class EmailService {

    // @Async — executa em thread separada
    @Async
    public void enviarEmailConfirmacao(String email, Long pedidoId) {
        // Simula operação lenta (2 segundos)
        Thread.sleep(2000);
        System.out.println("E-mail enviado para " + email + " sobre pedido " + pedidoId);
    }
}
```

**Configuração de pool de threads customizado:**

```java
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);          // Threads sempre ativas
        executor.setMaxPoolSize(10);          // Máximo de threads
        executor.setQueueCapacity(100);       // Fila de tarefas pendentes
        executor.setThreadNamePrefix("async-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            System.err.println("Exceção no método assíncrono " + method.getName() + ": " + ex.getMessage());
        };
    }
}
```

**Retornando resultados com `CompletableFuture`:**

```java
@Async
public CompletableFuture<String> gerarRelatorio(Long id) {
    // Operação demorada
    String relatorio = relatorioService.gerar(id);
    return CompletableFuture.completedFuture(relatorio);
}

// Uso:
CompletableFuture<String> futuro = pedidoService.gerarRelatorio(1L);
// Faz outras coisas enquanto o relatório é gerado...
String resultado = futuro.get();  // Bloqueia apenas aqui para pegar o resultado
```

**Limitações importantes:**

1. **`@Async` não funciona em chamadas internas** — se a classe `EmailService` chamar seu próprio método `enviarEmailConfirmacao` internamente (não via proxy), o `@Async` é ignorado. O método deve ser chamado por outra classe.
2. **O método deve ser `public`** — o proxy do Spring não intercepta métodos `private` ou `protected`.
3. **Não usar com `@Transactional` no mesmo método** — pode haver conflito de proxies.

**Explicação didática:**  
Imagine que você está em um restaurante e faz um pedido. Sem `@Async`, você fica parado no balcão esperando o pedido ficar pronto — não pode fazer mais nada. Com `@Async`, o garçom anota seu pedido e diz "aviso quando estiver pronto" — você pode voltar à mesa, conversar e fazer outras coisas. O pedido está sendo preparado em "background".

**Como o candidato deve responder:**  
- Explicar que `@Async` executa o método em thread separada.
- Mencionar `@EnableAsync` para ativar o recurso.
- Citar o uso de `CompletableFuture` para resultados.
- Mencionar a limitação de chamadas internas (self-invocation).
- Explicar que é útil para operações lentas (e-mail, relatórios, notificações).

**Resposta fraca ou incompleta:**  
"@Async faz o método rodar em outra thread."  
Falta: não menciona @EnableAsync, não cita CompletableFuture, não sabe da limitação de self-invocation.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @Async |
| 1 | Sabe que "roda em background" mas não explica como |
| 2 | Usa @Async mas não conhece @EnableAsync ou limitações |
| 3 | Explica @Async, @EnableAsync e CompletableFuture |
| 4 | Demonstra configuração de pool de threads e tratamento de exceções |
| 5 | Responde com profundidade, menciona proxy, self-invocation e trade-offs |

**Perguntas de aprofundamento:**
1. "Por que @Async não funciona quando um método da mesma classe chama outro método @Async?"
2. "O que acontece se um método @Async lançar uma exceção? Como você captura?"
3. "Qual a diferença entre usar @Async e usar CompletableFuture.supplyAsync() diretamente?"

---

### Pergunta 63 — O que é caching no Spring Boot e como usar @Cacheable?

**Nível:** Júnior  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
"Em uma aplicação que faz muitas consultas repetidas ao banco de dados, como você pode usar caching para melhorar o desempenho? Como o Spring Boot suporta isso?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o suporte abstrato de caching do Spring, sabe usar as anotações `@Cacheable`, `@CacheEvict` e `@CachePut`, e entende o conceito de cache hit e cache miss.

**Resposta esperada:**  
O Spring Boot oferece uma camada de abstração de caching que permite armazenar resultados de métodos em memória (ou em provedores externos como Redis), evitando recalcular ou reconsultar dados que não mudaram.

**1. Ativar o suporte a caching:**

```java
@SpringBootApplication
@EnableCaching  // Habilita o suporte a caching
public class MinhaAplicacao {
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }
}
```

Por padrão, o Spring Boot usa um `ConcurrentMapCacheManager` — um cache em memória baseado em `ConcurrentHashMap`. Para produção, é comum usar Redis, Caffeine ou EhCache.

**2. Anotações principais:**

```java
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    // @Cacheable — se já existe no cache, retorna do cache (cache hit)
    // Se não existe, executa o método, guarda o resultado no cache (cache miss) e retorna
    @Cacheable(value = "usuarios", key = "#id")
    public Usuario buscarPorId(Long id) {
        // Este método só é executado se o id não estiver no cache
        return repository.findById(id)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

    // @CacheEvict — remove uma entrada do cache
    // Usado quando o dado é alterado ou deletado
    @CacheEvict(value = "usuarios", key = "#id")
    public void excluir(Long id) {
        repository.deleteById(id);
        // Após deletar, o cache para este id é removido
    }

    // @CacheEvict com allEntries — limpa todo o cache "usuarios"
    @CacheEvict(value = "usuarios", allEntries = true)
    public void recarregarCache() {
        // Força recarga completa do cache na próxima consulta
    }

    // @CachePut — sempre executa o método e atualiza o cache com o resultado
    // Diferente de @Cacheable, o método SEMPRE executa
    @CachePut(value = "usuarios", key = "#result.id")
    public Usuario atualizar(UsuarioUpdateDTO dto) {
        Usuario usuario = repository.findById(dto.id())
            .orElseThrow(() -> new UsuarioNaoEncontradoException(dto.id()));
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        return repository.save(usuario);
        // O resultado é colocado no cache, substituindo o valor antigo
    }
}
```

**Como funciona o fluxo:**

1. **Primeira chamada** a `buscarPorId(1)` — cache miss: o método executa, consulta o banco, e o resultado é guardado no cache com a chave `1`.
2. **Segunda chamada** a `buscarPorId(1)` — cache hit: o método **não executa**, o Spring retorna direto do cache.
3. **Chamada** a `atualizar(dto)` com id=1 — o método executa, atualiza o banco, e o cache é atualizado com o novo valor.
4. **Chamada** a `excluir(1)` — o método executa, deleta do banco, e a entrada de cache é removida.

**Explicação didática:**  
Cache é como ter uma "cola" em uma prova. A primeira vez que você precisa de uma informação, vai até o livro (banco de dados), anota na cola (cache), e usa. Da próxima vez que precisa da mesma informação, em vez de ir até o livro de novo, você olha a cola — muito mais rápido. `@CacheEvict` é quando você rasga a cola porque a informação mudou. `@CachePut` é quando você vai ao livro de qualquer forma e atualiza a cola com a nova informação.

**Como o candidato deve responder:**  
- Mencionar `@EnableCaching` para ativar o recurso.
- Explicar `@Cacheable` (cache hit/miss), `@CacheEvict` (remoção) e `@CachePut` (atualização).
- Explicar o conceito de chave (key) no cache.
- Citar que o cache padrão é em memória (ConcurrentMap) e que Redis é comum em produção.
- Mostrar o fluxo: primeira chamada executa, segunda retorna do cache.

**Resposta fraca ou incompleta:**  
"@Cacheable guarda o resultado em memória."  
Falta: não menciona @EnableCaching, não cita @CacheEvict/@CachePut, não explica cache hit/miss.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece caching no Spring |
| 1 | Sabe que "guarda em memória" mas não explica como |
| 2 | Usa @Cacheable mas não conhece @CacheEvict |
| 3 | Explica as três anotações com exemplos |
| 4 | Demonstra uso de key, condition e provedores (Redis, Caffeine) |
| 5 | Responde com profundidade, menciona TTL, cache invalidation strategies e armadilhas |

**Perguntas de aprofundamento:**
1. "O que acontece se o dado no banco mudar e o cache não for invalidado? Como você evita isso?"
2. "Como você configuraria Redis como provedor de cache em vez do cache em memória?"
3. "É possível usar @Cacheable com condition? Dê um exemplo."

---

### Pergunta 64 — O que são eventos de aplicação (ApplicationEvent) no Spring Boot?

**Nível:** Júnior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
"Em algumas situações, precisamos desacoplar ações — por exemplo, quando um usuário se cadastra, queremos enviar um e-mail de boas-vindas e registrar um log, sem que o cadastro precise esperar essas operações. Como o Spring Boot permite isso com eventos?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o sistema de eventos do Spring, sabe publicar eventos com `ApplicationEventPublisher` e ouvir eventos com `@EventListener`, e entende o padrão observer.

**Resposta esperada:**  
O Spring Boot tem um sistema de eventos interno baseado no padrão **Observer**. Um componente pode **publicar** um evento, e outros componentes podem **ouvir** esse evento e reagir, sem que o publicador conheça os listeners.

**1. Criar o evento:**

```java
// A partir do Spring 4.2, eventos podem ser qualquer objeto — não precisa estender ApplicationEvent
public record UsuarioCriadoEvent(
    Long id,
    String nome,
    String email,
    LocalDateTime criadoEm
) {}
```

**2. Publicar o evento:**

```java
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final ApplicationEventPublisher eventPublisher;  // Injetado pelo Spring

    public Usuario criar(UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario(dto.nome(), dto.email(), dto.senha());
        repository.save(usuario);

        // Publica o evento — não sabe quem vai ouvir
        eventPublisher.publishEvent(new UsuarioCriadoEvent(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            LocalDateTime.now()
        ));

        return usuario;
    }
}
```

**3. Ouvir o evento:**

```java
@Component
@RequiredArgsConstructor
public class UsuarioCriadoListener {

    private final EmailService emailService;

    @EventListener
    public void onUsuarioCriado(UsuarioCriadoEvent event) {
        // Reage ao evento — envia e-mail de boas-vindas
        emailService.enviarBoasVindas(event.email(), event.nome());
    }
}

@Component
@Slf4j
public class LogListener {

    @EventListener
    public void onUsuarioCriado(UsuarioCriadoEvent event) {
        log.info("Novo usuário criado: id={}, nome={}", event.id(), event.nome());
    }
}
```

**4. Eventos assíncronos:**

```java
@Component
public class UsuarioCriadoListener {

    @Async  // Executa em thread separada
    @EventListener
    public void onUsuarioCriado(UsuarioCriadoEvent event) {
        // Operação lenta não bloqueia o cadastro
        emailService.enviarBoasVindas(event.email(), event.nome());
    }
}
```

**Fluxo completo:**

1. `UsuarioService.criar()` salva o usuário no banco.
2. Publica `UsuarioCriadoEvent` via `ApplicationEventPublisher`.
3. O Spring notifica todos os listeners registrados.
4. `UsuarioCriadoListener` envia o e-mail.
5. `LogListener` registra no log.
6. O `UsuarioService` não conhece nem o `EmailService` nem o `LogListener` — está desacoplado.

**Explicação didática:**  
Eventos são como um sistema de alto-falantes em um prédio. Quando alguém na portaria (publicador) anuncia "Chegou um pacote para o apartamento 42" (evento), todos que estão ouvindo (listeners) reagem: o morador do 42 vai buscar, o porteiro anota no caderno, a câmera registra. A portaria não precisa saber quem vai reagir — apenas anuncia. Cada listener decide por conta própria o que fazer com a informação.

**Como o candidato deve responder:**  
- Explicar que o Spring tem um sistema de eventos baseado no padrão Observer.
- Mostrar `ApplicationEventPublisher` para publicar e `@EventListener` para ouvir.
- Mencionar o desacoplamento entre publicador e listeners.
- Citar que eventos podem ser objetos simples (records, por exemplo).
- Mencionar `@Async` + `@EventListener` para processamento assíncrono.

**Resposta fraca ou incompleta:**  
"Você usa @EventListener para ouvir eventos."  
Falta: não explica como publicar, não menciona ApplicationEventPublisher, não fala de desacoplamento.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece eventos no Spring |
| 1 | Sabe que "existe @EventListener" mas não explica o fluxo |
| 2 | Menciona publisher e listener mas sem exemplo prático |
| 3 | Explica o fluxo completo com exemplo de código |
| 4 | Demonstra uso com @Async e desacoplamento |
| 5 | Responde com profundidade, menciona @TransactionalEventListener, ordem de listeners e condições |

**Perguntas de aprofundamento:**
1. "O que é `@TransactionalEventListener` e quando usá-lo em vez de `@EventListener`?"
2. "É possível ter múltiplos listeners para o mesmo evento? Qual a ordem de execução?"
3. "Os eventos são síncronos ou assíncronos por padrão? Como mudar isso?"

---

### Pergunta 65 — Como configurar CORS em uma API Spring Boot?

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
"Sua API Spring Boot está rodando em `localhost:8080` e seu frontend (React, Vue, Angular) está em `localhost:3000`. Quando o frontend tenta chamar a API, recebe um erro de CORS. O que é CORS e como você resolve isso no Spring Boot?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o que é CORS (Cross-Origin Resource Sharing), por que ele existe e sabe configurar no Spring Boot a nível de controller e global.

**Resposta esperada:**  
**CORS** é uma política de segurança dos navegadores que impede que uma página web faça requisições para um domínio diferente daquele de onde a página foi carregada. Se o frontend está em `localhost:3000` e a API em `localhost:8080`, o navegador considera que são **origens diferentes** (portas diferentes) e bloqueia a requisição por padrão.

**Como resolver no Spring Boot:**

**1. Configuração por controller (anotação):**

```java
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:3000")  // Permite este origin
public class UsuarioController {

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }
}
```

**2. Configuração por método:**

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    // Outros métodos não permitem CORS
    @PostMapping
    public Usuario criar(@RequestBody UsuarioDTO dto) {
        return usuarioService.criar(dto);
    }
}
```

**3. Configuração global (recomendada):**

```java
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")              // Aplica a todos os endpoints /api/
            .allowedOrigins("http://localhost:3000") // Origin permitido
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos
            .allowedHeaders("*")                     // Headers permitidos
            .allowCredentials(true)                  // Permite cookies/Authorization
            .maxAge(3600);                           // Cache de preflight por 1h
    }
}
```

**4. CORS com Spring Security:**  
Se o projeto usa Spring Security, a configuração de CORS acima pode ser sobrescrita. É necessário configurar CORS dentro do SecurityFilterChain:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // Habilita CORS no Security
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            );
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:3000"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
```

**Explicação didática:**  
CORS é como uma política de "portaria" do navegador. Quando a página do frontend (em `localhost:3000`) tenta acessar a API (em `localhost:8080`), o navegador pergunta à API: "Você permite ser acessado por este domínio?". Se a API não responder explicitamente "sim, permito `localhost:3000`", o navegador bloqueia a resposta. Configurar CORS é como colocar uma placa na portaria dizendo quais domínios são bem-vindos.

**Como o candidato deve responder:**  
- Explicar o que é CORS (política de segurança do navegador).
- Mencionar que origens diferentes = protocolo + domínio + porta diferentes.
- Mostrar pelo menos duas formas de configurar: `@CrossOrigin` e configuração global.
- Citar que com Spring Security é preciso configurar CORS separadamente.
- Explicar `allowedOrigins`, `allowedMethods` e `allowCredentials`.

**Resposta fraca ou incompleta:**  
"Você usa @CrossOrigin no controller."  
Falta: não explica o que é CORS, não mostra configuração global, não menciona Spring Security.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é CORS |
| 1 | Sabe que "resolve erro de frontend" mas não explica |
| 2 | Usa @CrossOrigin mas não conhece configuração global |
| 3 | Explica CORS e mostra configuração global e por controller |
| 4 | Demonstra configuração com Spring Security e allowCredentials |
| 5 | Responde com profundidade, menciona preflight requests, OPTIONS e maxAge |

**Perguntas de aprofundamento:**
1. "O que é uma requisição preflight (OPTIONS)? Quando o navegador a envia?"
2. "Por que `allowCredentials(true)` exige origens específicas em vez de `*`?"
3. "Como você configuraria CORS para múltiplos ambientes (dev, staging, prod)?"

---

### Pergunta 66 — Como fazer upload de arquivos em uma API Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Você precisa criar um endpoint que recebe upload de arquivos (por exemplo, uma foto de perfil). Como você implementa isso no Spring Boot e quais cuidados deve ter?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe usar `MultipartFile` para receber arquivos, configurar o limite de tamanho e entende os cuidados com validação e armazenamento.

**Resposta esperada:**  
O Spring Boot oferece suporte nativo a upload de arquivos through da interface `MultipartFile`, que representa um arquivo enviado em uma requisição multipart/form-data.

**1. Endpoint de upload:**

```java
@RestController
@RequestMapping("/api/arquivos")
public class ArquivoController {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> upload(
            @RequestParam("arquivo") MultipartFile arquivo) {

        // Validações
        if (arquivo.isEmpty()) {
            return ResponseEntity.badRequest().body("Arquivo vazio");
        }

        // Valida tipo de arquivo
        String contentType = arquivo.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            return ResponseEntity.badRequest().body("Apenas imagens são permitidas");
        }

        // Valida tamanho (máximo 5MB)
        if (arquivo.getSize() > 5 * 1024 * 1024) {
            return ResponseEntity.badRequest().body("Arquivo muito grande (máx 5MB)");
        }

        try {
            // Salvar o arquivo
            String nomeArquivo = System.currentTimeMillis() + "_" + arquivo.getOriginalFilename();
            Path destino = Paths.get("uploads/" + nomeArquivo);
            Files.createDirectories(destino.getParent());
            Files.copy(arquivo.getInputStream(), destino);

            return ResponseEntity.ok("Arquivo enviado: " + nomeArquivo);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Erro ao salvar arquivo");
        }
    }

    // Upload de múltiplos arquivos
    @PostMapping(value = "/upload-multiplo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<String>> uploadMultiplo(
            @RequestParam("arquivos") MultipartFile[] arquivos) {

        List<String> nomes = new ArrayList<>();
        for (MultipartFile arquivo : arquivos) {
            if (!arquivo.isEmpty()) {
                nomes.add(arquivo.getOriginalFilename());
            }
        }
        return ResponseEntity.ok(nomes);
    }
}
```

**2. Configuração de limite de tamanho:**

```properties
# application.properties
spring.servlet.multipart.max-file-size=10MB       # Tamanho máximo por arquivo
spring.servlet.multipart.max-request-size=50MB     # Tamanho máximo total da requisição
spring.servlet.multipart.enabled=true              # Habilita suporte a multipart (padrão: true)
```

Se o limite for excedido, o Spring lança `MaxUploadSizeExceededException`, que pode ser tratada:

```java
@ControllerAdvice
public class UploadExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> handleMaxSize(MaxUploadSizeExceededException ex) {
        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
            .body("Arquivo excede o tamanho máximo permitido");
    }
}
```

**Cuidados importantes:**

1. **Validar tipo de arquivo** — não confiar apenas na extensão; verificar o `contentType`.
2. **Limitar tamanho** — configurar `max-file-size` para evitar DoS.
3. **Nome seguro** — não usar o nome original do arquivo diretamente; gerar um nome único (UUID, timestamp) para evitar colisões e path traversal.
4. **Não salvar na aplicação** — em produção, usar armazenamento externo (S3, Azure Blob, GCS) em vez de disco local.
5. **Validar conteúdo** — verificar magic bytes do arquivo, não apenas a extensão.

**Explicação didática:**  
`MultipartFile` é como um "envelope especial" que chega pelo correio. Um envelope normal (`@RequestBody`) contém uma carta (JSON). Um envelope multipart contém a carta **e** um pacote anexo (o arquivo). O Spring separa o pacote do envelope e entrega para você como `MultipartFile`, com métodos para acessar o conteúdo (`getInputStream()`), o nome (`getOriginalFilename()`), o tamanho (`getSize()`) e o tipo (`getContentType()`).

**Como o candidato deve responder:**  
- Explicar que `MultipartFile` representa o arquivo enviado.
- Mostrar endpoint com `@RequestParam("arquivo") MultipartFile`.
- Mencionar configuração de limite de tamanho (`max-file-size`).
- Citar pelo menos dois cuidados: validação de tipo e nome seguro.
- Mencionar que em produção se usa armazenamento externo (S3).

**Resposta fraca ou incompleta:**  
"Você usa MultipartFile para receber o arquivo."  
Falta: não mostra validações, não menciona configuração de tamanho, não cita cuidados de segurança.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe fazer upload |
| 1 | Menciona MultipartFile mas sem exemplo |
| 2 | Mostra endpoint básico mas sem validações |
| 3 | Explica upload com validações e configuração de tamanho |
| 4 | Demonstra tratamento de exceções e nome seguro de arquivo |
| 5 | Responde com profundidade, menciona S3, path traversal e validação de magic bytes |

**Perguntas de aprofundamento:**
1. "Como você armazenaria o arquivo na Amazon S3 em vez do disco local?"
2. "O que é path traversal e como evitá-lo no upload de arquivos?"
3. "Como você faria o download de um arquivo previamente enviado?"

---

### Pergunta 67 — O que é o Spring Security e como fazer uma configuração básica?

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
"Quando você adiciona o `spring-boot-starter-security` no projeto, a aplicação passa a exigir autenticação para todos os endpoints. O que é o Spring Security e como você faz uma configuração básica para liberar alguns endpoints?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o que o Spring Security faz por padrão, conhece a configuração via `SecurityFilterChain` (Spring Security 6.x / Spring Boot 3.x) e sabe liberar endpoints públicos.

**Resposta esperada:**  
O **Spring Security** é o framework de segurança oficial do ecossistema Spring, responsável por **autenticação** (quem é o usuário) e **autorização** (o que o usuário pode fazer). Quando adicionado ao projeto, por padrão:

1. **Protege todos os endpoints** — qualquer requisição exige autenticação.
2. **Cria um usuário padrão** — username `user`, senha gerada aleatoriamente (mostrada no console).
3. **Habilita CSRF** — proteção contra Cross-Site Request Forgery.

**Configuração básica para liberar endpoints:**

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Desabilita CSRF (comum em APIs REST)
            .authorizeHttpRequests(auth -> auth
                // Endpoints públicos — não exigem autenticação
                .requestMatchers("/api/public/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/v3/api-docs/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()  // Cadastro público
                // Todos os outros endpoints exigem autenticação
                .anyRequest().authenticated()
            )
            // Autenticação HTTP Basic (padrão)
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // Configura usuários em memória (para teste/desenvolvimento)
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.builder()
            .username("admin")
            .password(encoder.encode("admin123"))
            .roles("ADMIN")
            .build();

        UserDetails user = User.builder()
            .username("user")
            .password(encoder.encode("user123"))
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

**Pontos importantes sobre Spring Boot 3.x / Spring Security 6.x:**

1. **`SecurityFilterChain` substitui `WebSecurityConfigurerAdapter`** — a antiga abordagem de estender uma classe foi removida. Tudo é feito via beans e lambdas.
2. **Sintaxe com lambdas** — `csrf(csrf -> csrf.disable())` em vez de `.csrf().disable()`.
3. **`requestMatchers` substitui `antMatchers`** — nova nomenclatura.
4. **`PasswordEncoder`** — sempre usar `BCryptPasswordEncoder` para senhas, nunca texto plano.

**Explicação didática:**  
Spring Security é como o sistema de catracas de um prédio. Quando você instala o Spring Security, ele fecha todas as portas e coloca uma catraca em cada uma — ninguém entra sem crachá (autenticação). A configuração `permitAll()` é como dizer "esta porta específica (endpoint público) não tem catraca, qualquer um pode entrar". O `authenticated()` é "todas as outras portas exigem crachá". O `hasRole("ADMIN")` seria "esta porta só abre para crachás com acesso de administrador".

**Como o candidato deve responder:**  
- Explicar que Spring Security protege todos os endpoints por padrão.
- Mostrar a configuração com `SecurityFilterChain`.
- Mencionar `permitAll()` para endpoints públicos e `authenticated()` para o resto.
- Citar que o Spring Boot 3.x usa a nova sintaxe (sem `WebSecurityConfigurerAdapter`).
- Mencionar `BCryptPasswordEncoder` para senhas.

**Resposta fraca ou incompleta:**  
"O Spring Security protege a aplicação."  
Falta: não mostra configuração, não menciona SecurityFilterChain, não cita permitAll/authenticated.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece Spring Security |
| 1 | Sabe que "protege endpoints" mas não configura |
| 2 | Menciona SecurityFilterChain mas com sintaxe antiga |
| 3 | Mostra configuração correta com permitAll e authenticated |
| 4 | Demonstra UserDetailsService, PasswordEncoder e roles |
| 5 | Responde com profundidade, menciona JWT, filter chain order e CSRF em APIs REST |

**Perguntas de aprofundamento:**
1. "Por que desabilitar CSRF em APIs REST é uma prática comum? Quando você NÃO deveria desabilitar?"
2. "Como você implementaria autenticação com JWT em vez de HTTP Basic?"
3. "Qual a diferença entre `hasRole()` e `hasAuthority()`?"

---

### Pergunta 68 — Como o Spring Boot lida com transações (@Transactional)?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Em uma operação que envolve múltiplas escritas no banco — como transferir dinheiro entre contas — você precisa garantir que ou todas as operações succeed, ou nenhuma é aplicada. Como o Spring Boot gerencia transações com @Transactional?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o conceito de transação ACID, sabe usar `@Transactional`, conhece os atributos de rollback e propagation, e entende as armadilhas mais comuns.

**Resposta esperada:**  
`@Transactional` é uma anotação do Spring que gerencia transações de banco de dados de forma declarativa. Quando aplicada a um método, o Spring:

1. **Abre uma transação** antes de executar o método.
2. **Executa o método**.
3. Se o método termina sem erro → **commit** (confirma as mudanças).
4. Se o método lança uma exceção → **rollback** (desfaz as mudanças).

**Exemplo prático:**

```java
@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final ContaRepository contaRepository;

    @Transactional
    public void transferir(Long origemId, Long destinoId, BigDecimal valor) {
        Conta origem = contaRepository.findById(origemId)
            .orElseThrow(() -> new ContaNaoEncontradaException(origemId));
        Conta destino = contaRepository.findById(destinoId)
            .orElseThrow(() -> new ContaNaoEncontradaException(destinoId));

        // Validação
        if (origem.getSaldo().compareTo(valor) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        // Debita e credita
        origem.debitar(valor);
        destino.creditar(valor);

        contaRepository.save(origem);
        contaRepository.save(destino);
        // Se qualquer coisa der errado até aqui, ambos os saves são desfeitos
    }
}
```

**Regras de rollback:**

Por padrão, `@Transactional` faz rollback apenas para **exceções não verificadas** (`RuntimeException` e suas subclasses) e `Error`. Exceções verificadas (que herdam de `Exception` mas não de `RuntimeException`) **não** causam rollback por padrão.

```java
// Rollback apenas para RuntimeException (padrão)
@Transactional
public void metodoPadrao() { ... }

// Rollback para exceções específicas
@Transactional(rollbackFor = {SaldoInsuficienteException.class, ContaNaoEncontradaException.class})
public void transferirComRollbackCustom() { ... }

// Rollback para todas as exceções (incluindo verificadas)
@Transactional(rollbackFor = Exception.class)
public void metodoRollbackTudo() { ... }

// NÃO faz rollback para uma exceção específica
@Transactional(noRollbackFor = {LogException.class})
public void metodoSemRollbackLog() { ... }
```

**Propagation (propagação de transação):**

Define como o método se comporta se já existe uma transação ativa:

| Propagation | Comportamento |
|-------------|---------------|
| `REQUIRED` (padrão) | Se existe transação, usa; se não, cria nova |
| `REQUIRES_NEW` | Sempre cria nova transação, suspendendo a existente |
| `SUPPORTS` | Se existe transação, usa; se não, executa sem transação |
| `MANDATORY` | Exige transação ativa; lança exceção se não houver |
| `NEVER` | Não pode haver transação; lança exceção se houver |
| `NOT_SUPPORTED` | Executa sem transação, suspendendo qualquer uma ativa |

**Armadilhas comuns:**

1. **Self-invocation não funciona:**
```java
@Service
public class UsuarioService {

    @Transactional
    public void metodoA() {
        // Chamada interna — @Transactional é IGNORADO
        metodoB();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void metodoB() {
        // Não cria nova transação porque é chamada interna
        // O proxy do Spring não intercepta chamadas dentro da mesma classe
    }
}
```

2. **Método deve ser `public`** — `@Transactional` não funciona em métodos `private` ou `protected`.

3. **Exceção verificada não faz rollback** — se o método lança `IOException`, o commit acontece por padrão.

**Explicação didática:**  
`@Transactional` é como um "contrato garantido" em uma transação comercial. Você diz "vou transferir `R$ 100` da conta A para a conta B". O Spring anota tudo, debita de A e credita em B. Se tudo dá certo, ele confirma (commit). Se algo dá errado no meio — a conta B não existe, o saldo é insuficiente — ele "desfaz" tudo, como se nada tivesse acontecido (rollback). É como o botão "desfazer" (Ctrl+Z) do banco de dados.

**Como o candidato deve responder:**  
- Explicar que `@Transactional` abre, commita ou faz rollback de transações automaticamente.
- Mencionar que rollback acontece por padrão para `RuntimeException`.
- Citar a armadilha de self-invocation (chamada interna não funciona).
- Mencionar que o método deve ser `public`.
- Explicar o conceito de propagation (pelo menos `REQUIRED` e `REQUIRES_NEW`).

**Resposta fraca ou incompleta:**  
"@Transactional gerencia transações no banco."  
Falta: não explica rollback, não menciona regras de exceção, não cita armadilhas.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @Transactional |
| 1 | Sabe que "gerencia transação" mas não explica como |
| 2 | Explica commit/rollback mas não menciona exceções verificadas |
| 3 | Explica rollback, exceções e mostra exemplo prático |
| 4 | Demonstra conhecimento de propagation e armadilha de self-invocation |
| 5 | Responde com profundidade, menciona isolation levels, timeout e proxy CGLIB |

**Perguntas de aprofundamento:**
1. "Por que uma exceção verificada (checked) não causa rollback por padrão? Como mudar isso?"
2. "O que acontece se dois métodos `@Transactional` se chamam dentro da mesma classe?"
3. "Qual a diferença entre `REQUIRED` e `REQUIRES_NEW`? Dê um cenário para cada um."

---

### Pergunta 69 — Como você lida com logs em uma aplicação Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em uma aplicação Spring Boot em produção, você precisa registrar logs para debugar problemas e monitorar o comportamento. Como o Spring Boot lida com logging por padrão e como você configura logs nos seus serviços?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe que o Spring Boot usa Logback por padrão, conhece os níveis de log (TRACE, DEBUG, INFO, WARN, ERROR) e sabe configurar logging via `application.properties` ou `logback-spring.xml`.

**Resposta esperada:**  
O Spring Boot inclui **Logback** como framework de logging padrão, pré-configurado para exibir logs no console com formatação legível. Não é necessário adicionar nenhuma dependência — já funciona out of the box.

**1. Níveis de log (do mais detalhado ao menos):**

| Nível | Quando usar | Exemplo |
|-------|-------------|---------|
| `TRACE` | Detalhes muito finos, raramente em produção | Rastreio de cada passo de um algoritmo |
| `DEBUG` | Informação de debug para desenvolvimento | Valores de variáveis, fluxo de execução |
| `INFO` | Eventos significativos de negócio | "Usuário X criado", "Pedido Y processado" |
| `WARN` | Situações potencialmente problemáticas | "Cache miss alto", "Conexão lenta" |
| `ERROR` | Erros que impedem funcionalidade | "Falha ao salvar usuário", "Banco indisponível" |

**2. Usando logs no código:**

```java
// Opção 1: SLF4J diretamente (recomendado sem Lombok)
@Service
public class UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    public Usuario criar(UsuarioCreateDTO dto) {
        log.info("Criando usuário: {}", dto.email());
        try {
            Usuario usuario = repository.save(new Usuario(dto));
            log.info("Usuário criado com id: {}", usuario.getId());
            return usuario;
        } catch (DataAccessException e) {
            log.error("Erro ao salvar usuário {}: {}", dto.email(), e.getMessage(), e);
            throw new RuntimeException("Erro interno", e);
        }
    }
}

// Opção 2: Lombok @Slf4j (mais conciso)
@Slf4j
@Service
public class UsuarioService {

    public Usuario criar(UsuarioCreateDTO dto) {
        log.info("Criando usuário: {}", dto.email());
        // ...
    }
}
```

**3. Configuração via application.properties:**

```properties
# Nível global (root)
logging.level.root=INFO

# Nível por pacote
logging.level.com.empresa.projeto=DEBUG
logging.level.org.springframework.web=INFO
logging.level.org.hibernate.SQL=DEBUG          # Loga as queries SQL
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE  # Loga parâmetros das queries

# Arquivo de log
logging.file.name=logs/aplicacao.log
logging.file.max-size=10MB
logging.file.max-history=7

# Padrão do log no console
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
```

**4. Configuração via logback-spring.xml (mais controle):**

```xml
<!-- src/main/resources/logback-spring.xml -->
<configuration>
    <springProfile name="dev">
        <root level="DEBUG">
            <appender-ref ref="CONSOLE"/>
        </root>
    </springProfile>

    <springProfile name="prod">
        <root level="INFO">
            <appender-ref ref="FILE"/>
        </root>
    </springProfile>

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>logs/aplicacao.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>logs/aplicacao-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <maxFileSize>10MB</maxFileSize>
            <maxHistory>30</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>
</configuration>
```

**Boas práticas:**

1. **Usar placeholders `{}`** — não concatenar strings: `log.info("User: {}", id)` em vez de `log.info("User: " + id)`.
2. **Logar exceções com stack trace** — passar a exceção como último parâmetro: `log.error("Erro: {}", msg, exception)`.
3. **Não logar dados sensíveis** — senhas, tokens, CPFs não devem aparecer em logs.
4. **Nível apropriado** — não usar `ERROR` para situações esperadas; não usar `DEBUG` em produção para tudo.

**Explicação didática:**  
Logs são como o "diário de bordo" da sua aplicação. `TRACE` e `DEBUG` são anotações detalhadas que você faz durante o desenvolvimento ("entrei no método X com o valor Y"). `INFO` são marcos importantes ("usuário cadastrado com sucesso"). `WARN` é um "sinal de alerta" ("a operação demorou mais que o normal"). `ERROR` é um "pedido de socorro" ("falha ao conectar ao banco"). Em produção, você não quer o diário detalhado (muito barulho), só os marcos importantes e os alertas.

**Como o candidato deve responder:**  
- Mencionar que o Spring Boot usa Logback por padrão.
- Citar os níveis de log (TRACE, DEBUG, INFO, WARN, ERROR).
- Mostrar como usar Logger (SLF4J ou Lombok `@Slf4j`).
- Explicar configuração via `application.properties`.
- Mencionar boas práticas: placeholders, não logar dados sensíveis.

**Resposta fraca ou incompleta:**  
"Eu uso System.out.println ou Logger."  
Falta: não conhece os níveis, não menciona Logback, não mostra configuração.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece logging no Spring Boot |
| 1 | Usa System.out.println |
| 2 | Menciona Logger mas não conhece níveis |
| 3 | Explica níveis, Logback e configuração com exemplos |
| 4 | Demonstra logback-spring.xml, profiles e boas práticas |
| 5 | Responde com profundidade, menciona MDC, structured logging e integração com ELK |

**Perguntas de aprofundamento:**
1. "Como você ativaria o log de queries SQL geradas pelo Hibernate?"
2. "O que é MDC (Mapped Diagnostic Context) e para que serve?"
3. "Como você configuraria logs diferentes para dev e produção?"

---

### Pergunta 70 — Como você consome uma API externa (REST) a partir do Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Sua aplicação Spring Boot precisa consultar uma API externa — por exemplo, um serviço de CEP ou um gateway de pagamento. Quais opções o Spring Boot oferece para consumir APIs REST externas?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece as principais formas de consumir APIs REST no Spring Boot (RestTemplate, WebClient, RestClient, Feign) e sabe quando usar cada uma.

**Resposta esperada:**  
O Spring Boot oferece várias opções para consumir APIs REST externas:

**1. RestClient (Spring Boot 3.2+ — recomendado para APIs síncronas):**

```java
@Component
public class CepClient {

    private final RestClient restClient;

    public CepClient() {
        this.restClient = RestClient.builder()
            .baseUrl("https://viacep.com.br/ws")
            .build();
    }

    public EnderecoDTO buscarCep(String cep) {
        return restClient.get()
            .uri("/{cep}/json", cep)
            .retrieve()
            .body(EnderecoDTO.class);
    }

    // Com tratamento de erro
    public EnderecoDTO buscarCepSeguro(String cep) {
        try {
            return restClient.get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(),
                    (req, res) -> {
                        throw new CepInvalidoException("CEP inválido: " + cep);
                    })
                .body(EnderecoDTO.class);
        } catch (CepInvalidoException e) {
            throw e;
        } catch (Exception e) {
            throw new ApiExternaException("Erro ao consultar CEP", e);
        }
    }
}
```

**2. RestTemplate (legado, mas muito comum):**

```java
@Component
public class PagamentoClient {

    private final RestTemplate restTemplate;

    public PagamentoClient() {
        this.restTemplate = new RestTemplate();
    }

    public PagamentoResponse processar(PagamentoRequest request) {
        String url = "https://api.pagamento.com/v1/pagamentos";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(tokenService.obterToken());

        HttpEntity<PagamentoRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<PagamentoResponse> response = restTemplate.exchange(
            url,
            HttpMethod.POST,
            entity,
            PagamentoResponse.class
        );

        return response.getBody();
    }
}
```

**3. WebClient (reativo — assíncrono):**

```java
@Component
@RequiredArgsConstructor
public class NotificacaoClient {

    private final WebClient webClient;

    public Mono<NotificacaoResponse> enviar(NotificacaoRequest request) {
        return webClient.post()
            .uri("https://api.notificacao.com/enviar")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(NotificacaoResponse.class)
            .onErrorResume(e -> Mono.error(new ApiExternaException("Falha na notificação", e)));
    }
}

// Configuração do WebClient
@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
            .build();
    }
}
```

**4. OpenFeign (declarativo):**

```java
// 1. Adicionar dependência: spring-cloud-starter-openfeign
// 2. Ativar: @EnableFeignClients na classe principal

@FeignClient(name = "cep-service", url = "https://viacep.com.br/ws")
public interface CepFeignClient {

    @GetMapping("/{cep}/json")
    EnderecoDTO buscarCep(@PathVariable("cep") String cep);
}

// Uso — injeta e chama como uma interface normal
@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final CepFeignClient cepClient;

    public EnderecoDTO buscar(String cep) {
        return cepClient.buscarCep(cep);
    }
}
```

**Comparação:**

| Ferramenta | Paradigma | Quando usar |
|------------|-----------|------------|
| `RestClient` | Síncrono, fluente | Spring Boot 3.2+ — APIs REST síncronas |
| `RestTemplate` | Síncrono | Projetos legados — em manutenção, não depreciado mas sem novos recursos |
| `WebClient` | Reativo (assíncrono) | Quando precisa de não-bloqueante, alto throughput, ou usa Spring WebFlux |
| `Feign` | Declarativo | Microserviços com múltiplas APIs externas — reduz boilerplate |

**Cuidados importantes:**

1. **Configurar timeouts** — nunca deixar o default infinito.
2. **Tratar erros** — 4xx, 5xx, timeout, conexão recusada.
3. **Retry** — considerar retry com backoff para falhas transitórias.
4. **Circuit breaker** — em microserviços, usar Resilience4j para evitar cascateamento de falhas.

**Explicação didática:**  
`RestTemplate` é como ligar para alguém e ficar esperando na linha até atender (síncrono, bloqueante). `WebClient` é como enviar uma mensagem de texto e continuar fazendo outras coisas até receber a resposta (assíncrono, não-bloqueante). `Feign` é como ter um assistente que você só dá as instruções (interface) e ele faz a ligação para você (declarativo). `RestClient` é o novo assistente síncrono, mais moderno e fluente que o `RestTemplate`.

**Como o candidato deve responder:**  
- Citar pelo menos duas opções: RestTemplate e RestClient (ou WebClient).
- Explicar a diferença entre síncrono e assíncrono.
- Mostrar exemplo prático de consumo de API.
- Mencionar tratamento de erros e timeouts.
- Citar Feign como alternativa declarativa (se conhecer).

**Resposta fraca ou incompleta:**  
"Eu uso RestTemplate para chamar APIs."  
Falta: não menciona outras opções, não trata erros, não configura timeout.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe consumir APIs externas |
| 1 | Menciona RestTemplate mas sem exemplo |
| 2 | Mostra RestTemplate básico mas sem tratamento de erro |
| 3 | Explica múltiplas opções com exemplos e comparação |
| 4 | Demonstra tratamento de erro, timeout e configuração |
| 5 | Responde com profundidade, menciona Feign, circuit breaker e retry |

**Perguntas de aprofundamento:**
1. "Como você configuraria timeout para uma chamada com RestTemplate?"
2. "Qual a vantagem do Feign sobre RestTemplate em um projeto com muitas APIs externas?"
3. "O que é um circuit breaker e quando usá-lo ao consumir APIs externas?"

---

## Roteiro de Entrevista Técnica — Spring Boot

### Parte 8 de 10 — Perguntas 71 a 80

**Foco:** Lifecycle e configuração avançada — CommandLineRunner, ApplicationRunner, external config, Environment, MessageSource, multi-document YAML, @Conditional

---

### Pergunta 71 — O que é CommandLineRunner e quando usá-lo?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Em alguns projetos Spring Boot, você vê classes que implementam `CommandLineRunner`. O que essa interface faz, quando é executada e em quais cenários você a utilizaria?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece os pontos de extensão do ciclo de vida da aplicação Spring Boot, sabe que `CommandLineRunner` executa após o contexto ser inicializado e recebe os argumentos de linha de comando.

**Resposta esperada:**  
`CommandLineRunner` é uma interface funcional do Spring Boot que permite executar lógica **logo após o contexto da aplicação ser totalmente inicializado**. O método `run(String... args)` é chamado automaticamente pelo Spring quando a aplicação sobe, recebendo os argumentos passados na linha de comando.

**Características principais:**
- Executa **depois** que todos os beans foram criados e o ApplicationContext está pronto.
- Recebe os argumentos da linha de comando (`String... args`).
- Se lançar uma exceção, a aplicação **não sobe**.

**Exemplo prático:**

```java
@Component
@RequiredArgsConstructor
@Order(1)  // Define ordem de execução quando há múltiplos runners
public class InicializadorDados implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existem dados (evita duplicar em restart)
        if (usuarioRepository.count() == 0) {
            Role admin = roleRepository.findByNome("ADMIN")
                .orElseGet(() -> roleRepository.save(new Role("ADMIN")));
            Role user = roleRepository.findByNome("USER")
                .orElseGet(() -> roleRepository.save(new Role("USER")));

            Usuario usuarioAdmin = new Usuario("admin", "admin@empresa.com", "senha123");
            usuarioAdmin.setRoles(Set.of(admin));
            usuarioRepository.save(usuarioAdmin);

            System.out.println("Dados iniciais criados!");
        }
    }
}

// Outro runner com ordem diferente
@Component
@Order(2)
public class VerificacaoSistema implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Verificando sistema...");
        // Verifica conexões, serviços externos, etc.
    }
}
```

**Lendo argumentos da linha de comando:**

```java
@Component
public class ArgumentosRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // args são os argumentos passados: java -jar app.jar --modo=debug --porta=9090
        for (String arg : args) {
            System.out.println("Argumento recebido: " + arg);
        }

        // Usando ApplicationArguments (mais estruturado)
        // Injetar ApplicationArguments no construtor para acesso parsed
    }
}
```

**Cenários de uso:**
- **Seed de dados iniciais** — criar usuários admin, roles, configurações padrão.
- **Verificação de saúde** — checar conexões com banco, APIs externas, filas.
- **Migração de dados** — executar scripts de migração manuais na inicialização.
- **Aquecimento de cache** — pré-carregar dados em cache antes de receber tráfego.
- **Log de inicialização** — registrar versão, ambiente, configurações ativas.

**Explicação didática:**  
`CommandLineRunner` é como um "checklist de abertura" de uma loja. Depois que todos os funcionários chegaram e as portas estão abertas (contexto inicializado), alguém percorre o checklist: ligar as luzes, verificar o caixa, conferir o estoque. Se algo essencial falhar (exceção), a loja não abre. O `@Order` define a sequência do checklist — primeiro verifica o caixa, depois o estoque.

**Como o candidato deve responder:**  
- Explicar que executa após o contexto do Spring ser inicializado.
- Mencionar que recebe argumentos da linha de comando.
- Citar pelo menos dois cenários de uso (seed de dados, verificação).
- Mencionar que `@Order` controla a sequência entre múltiplos runners.
- Explicar que uma exceção impede a aplicação de subir.

**Resposta fraca ou incompleta:**  
"É para rodar código quando a aplicação começa."  
Falta: não explica quando exatamente, não menciona argumentos, não cita cenários.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece CommandLineRunner |
| 1 | Sabe que "roda na inicialização" mas sem detalhes |
| 2 | Menciona seed de dados mas não conhece @Order |
| 3 | Explica execução, argumentos, @Order e cenários |
| 4 | Demonstra uso com múltiplos runners e tratamento de exceção |
| 5 | Responde com profundidade, menciona ApplicationRunner, diferenças e boas práticas |

**Perguntas de aprofundamento:**
1. "Qual a diferença entre `CommandLineRunner` e `ApplicationRunner`?"
2. "O que acontece se um `CommandLineRunner` lançar uma exceção? A aplicação sobe?"
3. "Como você controlaria a ordem de execução de três runners diferentes?"

---

### Pergunta 72 — Qual a diferença entre CommandLineRunner e ApplicationRunner?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"O Spring Boot oferece duas interfaces parecidas: `CommandLineRunner` e `ApplicationRunner`. Ambas parecem fazer a mesma coisa. Qual é a diferença entre elas e quando você escolheria uma sobre a outra?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece as duas interfaces, entende que ambas executam após a inicialização do contexto, mas diferem no tipo de parâmetro recebido (array de Strings vs. ApplicationArguments).

**Resposta esperada:**  
Ambas as interfaces executam logo após o ApplicationContext ser inicializado. A diferença está em **como recebem os argumentos**:

| Aspecto | CommandLineRunner | ApplicationRunner |
|---------|-------------------|-------------------|
| Parâmetro do método | `String... args` (array bruto) | `ApplicationArguments args` (estruturado) |
| Tipo de acesso | Strings cruas, sem parsing | Métodos para acessar args option vs non-option |
| Parsing manual | Sim — você precisa parsear `--chave=valor` | Não — o Spring já faz o parsing |
| Quando usar | Simples, poucos argumentos | Quando precisa distinguir options de arguments |

**Exemplo comparativo:**

```java
// CommandLineRunner — recebe String[] bruto
@Component
@Order(1)
public class RunnerSimples implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // args: ["--modo=debug", "--porta=9090", "arquivo.txt"]
        // Você precisa parsear manualmente
        for (String arg : args) {
            System.out.println("Arg bruto: " + arg);
        }
    }
}

// ApplicationRunner — recebe ApplicationArguments estruturado
@Component
@Order(2)
public class RunnerEstruturado implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Argumentos que não são options (sem --)
        List<String> nonOption = args.getNonOptionArgs();
        // ["arquivo.txt"]

        // Argumentos que são options (com --)
        List<String> optionNames = args.getOptionNames();
        // ["modo", "porta"]

        // Valor de uma option específica
        List<String> modo = args.getOptionValues("modo");
        // ["debug"]

        List<String> porta = args.getOptionValues("porta");
        // ["9090"]

        System.out.println("Modo: " + modo.get(0));
        System.out.println("Porta: " + porta.get(0));
        System.out.println("Arquivos: " + nonOption);
    }
}
```

**Quando escolher cada um:**
- **CommandLineRunner:** quando os argumentos são simples ou quando você não precisa distinguir entre options (`--chave=valor`) e non-options (`valor`).
- **ApplicationRunner:** quando você precisa acessar argumentos de forma estruturada, distinguindo options de non-options e obtendo valores por nome.

**Explicação didática:**  
Imagine que você pede um café. O `CommandLineRunner` recebe o pedido como uma frase única ("café com leite sem açúcar") e você mesmo precisa separar as partes. O `ApplicationRunner` recebe o pedido já estruturado: bebida=café, complemento=leite, açúcar=nenhum. Ambos chegam ao mesmo resultado, mas o segundo já fez o "parsing" para você.

**Como o candidato deve responder:**  
- Explicar que ambos executam após a inicialização do contexto.
- Mencionar a diferença no tipo de parâmetro: `String[]` vs `ApplicationArguments`.
- Citar que `ApplicationArguments` oferece métodos como `getOptionValues()` e `getNonOptionArgs()`.
- Explicar quando preferir cada um.

**Resposta fraca ou incompleta:**  
"Os dois fazem a mesma coisa."  
Falta: não explica a diferença no parâmetro, não menciona ApplicationArguments.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece a diferença |
| 1 | Sabe que "são parecidos" mas não explica |
| 2 | Menciona que o parâmetro é diferente mas sem detalhar |
| 3 | Explica String[] vs ApplicationArguments com exemplos |
| 4 | Demonstra getOptionValues, getNonOptionArgs e quando usar cada um |
| 5 | Responde com profundidade, menciona @Order, execução sequencial e boas práticas |

**Perguntas de aprofundamento:**
1. "Se você tiver um `CommandLineRunner` com `@Order(1)` e um `ApplicationRunner` com `@Order(1)`, qual executa primeiro?"
2. "É possível usar `@Order` com runners? Como o Spring determina a ordem?"
3. "Como você faria para que um runner só execute em um profile específico?"

---

### Pergunta 73 — Como funciona a externalização de configurações no Spring Boot?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"O Spring Boot permite que a mesma aplicação rode em diferentes ambientes com configurações diferentes, sem mudar o código. Como funciona a externalização de configurações e qual a ordem de precedência das fontes?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece as múltiplas fontes de configuração do Spring Boot, entende a ordem de precedência (qual sobrescreve qual) e sabe como usar variáveis de ambiente e argumentos de linha de comando.

**Resposta esperada:**  
O Spring Boot permite externalizar configurações para que o mesmo artefato (JAR) rode em qualquer ambiente. Existem **múltiplas fontes de configuração**, e o Spring Boot as aplica em uma **ordem de precedência** — fontes mais altas sobrescrevem as mais baixas.

**Ordem de precedência (da maior para a menor):**

1. **Argumentos de linha de comando** — `java -jar app.jar --server.port=9090`
2. **Variáveis de ambiente** — `SERVER_PORT=9090`
3. **Propriedades do sistema Java** — `java -Dserver.port=9090 -jar app.jar`
4. **Arquivo `application.properties`/`.yml` fora do JAR** — no mesmo diretório do JAR
5. **Arquivo `application-{profile}.properties` dentro do JAR** — `application-prod.properties`
6. **Arquivo `application.properties` dentro do JAR** — `src/main/resources/application.properties`
7. **Valores padrão** — embutidos no código via `@DefaultValue`

**Exemplo prático:**

```properties
# application.properties (dentro do JAR — base)
server.port=8080
spring.datasource.url=jdbc:h2:mem:db
app.nome=Minha API
```

```properties
# application-prod.properties (dentro do JAR — sobrescreve para prod)
server.port=80
spring.datasource.url=jdbc:postgresql://prod-db:5432/minhadb
```

```bash
# Variável de ambiente (sobrescreve tudo acima)
export SERVER_PORT=443
export SPRING_DATASOURCE_URL=jdbc:postgresql://real-db:5432/minhadb

# Ou via linha de comando (precedência máxima)
java -jar app.jar --server.port=443 --spring.profiles.active=prod
```

**Usando @Value para ler propriedades:**

```java
@RestController
public class ConfigController {

    @Value("${app.nome:Nome Padrão}")  // :Nome Padrão é o fallback
    private String nomeAplicacao;

    @Value("${server.port}")
    private int porta;

    @GetMapping("/config")
    public Map<String, Object> config() {
        return Map.of(
            "nome", nomeAplicacao,
            "porta", porta
        );
    }
}
```

**Relaxed Binding (binding flexível):**  
O Spring Boot aceita variações de nomenclatura. As seguintes formas são equivalentes:

| Forma | Contexto |
|-------|----------|
| `app.nome-empresa` | Em `.properties` (kebab-case) |
| `app.nomeEmpresa` | Em código Java via @Value |
| `APP_NOME_EMPRESA` | Em variável de ambiente |
| `app.nome_empresa` | Em `.yml` (snake_case) |

**Explicação didática:**  
A externalização é como as camadas de roupa em um dia frio. A camada mais íntima (properties dentro do JAR) é a base — você sempre usa. A segunda camada (properties do profile) ajusta para o ambiente. A terceira (variável de ambiente) ajusta para o servidor específico. O casaco (argumento de linha de comando) é a última palavra — se você o usa, ele sobrescreve tudo. A regra é: a camada mais externa vence.

**Como o candidato deve responder:**  
- Explicar que o Spring Boot permite múltiplas fontes de configuração.
- Citar a ordem de precedência: linha de comando > variáveis de ambiente > properties por profile > properties base.
- Mencionar `@Value` para ler propriedades no código.
- Citar o relaxed binding (flexibilidade de nomenclatura).
- Explicar que o mesmo JAR funciona em qualquer ambiente.

**Resposta fraca ou incompleta:**  
"Você usa o `application.properties` para configurar."  
Falta: não menciona ordem de precedência, variáveis de ambiente, linha de comando ou relaxed binding.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece externalização |
| 1 | Sabe que "tem application.properties" mas sem precedência |
| 2 | Menciona variáveis de ambiente mas não a ordem completa |
| 3 | Explica a ordem de precedência, @Value e relaxed binding |
| 4 | Demonstra múltiplas fontes com exemplos práticos |
| 5 | Responde com profundidade, menciona SPRING_APPLICATION_JSON, random values e @ConfigurationProperties |

**Perguntas de aprofundamento:**
1. "O que é relaxed binding e por que é útil?"
2. "Como você passaria uma configuração complexa (como um JSON) via variável de ambiente?"
3. "É possível sobrescrever uma propriedade do `application.properties` via linha de comando? Como?"

---

### Pergunta 74 — O que é a interface Environment no Spring Boot?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, você pode injetar a interface `Environment` em seus beans. O que é o `Environment`, o que ele oferece e em que situações você o usaria em vez de `@Value`?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o `Environment` como fonte centralizada de propriedades, sabe usar seus métodos e entende quando é mais apropriado que `@Value`.

**Resposta esperada:**  
`Environment` é uma interface do Spring que representa o **ambiente de execução** da aplicação. Ela centraliza o acesso a todas as propriedades configuradas — sejam de `application.properties`, variáveis de ambiente, argumentos de linha de comando ou perfis ativos.

**Métodos principais:**

```java
@Component
@RequiredArgsConstructor
public class ConfigService {

    private final Environment environment;

    public void exibirConfiguracoes() {
        // Ler uma propriedade específica
        String porta = environment.getProperty("server.port");
        String nomeApp = environment.getProperty("app.nome", "Nome Padrão");

        // Ler propriedade tipada
        Integer portaInt = environment.getProperty("server.port", Integer.class);
        Boolean debug = environment.getProperty("app.debug", Boolean.class, false);

        // Verificar perfis ativos
        String[] perfis = environment.getActiveProfiles();
        boolean isProd = environment.acceptsProfiles(Profiles.of("prod"));

        // Verificar se uma propriedade existe
        boolean temProp = environment.containsProperty("spring.datasource.url");

        // Obter valor obrigatório (lança exceção se não existir)
        String urlBanco = environment.getRequiredProperty("spring.datasource.url");
    }
}
```

**Environment vs. @Value — quando usar cada um:**

| Aspecto | @Value | Environment |
|---------|--------|-------------|
| Injeção | Por campo ou construtor | Por injeção de interface |
| Acesso dinâmico | Estático (nome fixo em anotação) | Dinâmico (nome como String em runtime) |
| Leitura condicional | Não — lança se não encontra (sem default) | Sim — `getProperty()` retorna null se não existir |
| Verificar perfis | Não | Sim — `getActiveProfiles()`, `acceptsProfiles()` |
| Múltiplas propriedades | Precisa uma anotação por propriedade | Pode iterar e ler quantas precisar |
| Tipagem | Sim, com SpEL | Sim, com class parameter |

**Quando usar Environment em vez de @Value:**
- Quando precisa ler propriedades **dinamicamente** (nome da propriedade vem de variável).
- Quando precisa verificar **perfis ativos** em runtime.
- Quando precisa ler **muitas propriedades** relacionadas (evita muitos `@Value`).
- Quando precisa lógica condicional (se existe propriedade X, faça Y).

**Exemplo prático — seleção de configuração por perfil:**

```java
@Service
@RequiredArgsConstructor
public class DataSourceDinamicoService {

    private final Environment env;

    public String obterUrlBanco() {
        // Se profile prod ativo, usa URL de produção
        if (env.acceptsProfiles(Profiles.of("prod"))) {
            return env.getRequiredProperty("app.database.prod.url");
        }
        // Senão, usa URL de desenvolvimento
        return env.getProperty("app.database.dev.url", "jdbc:h2:mem:dev");
    }
}
```

**Explicação didática:**  
`@Value` é como pedir um ingrediente específico por nome ("quero o sal") — você precisa saber o nome de antemão. `Environment` é como ter acesso à despensa inteira — você pode procurar qualquer ingrediente, checar se existe, comparar com o que já tem, e decidir com base no "clima" (perfil ativo). Use `@Value` para leituras simples e fixas; use `Environment` para lógica dinâmica e condicional.

**Como o candidato deve responder:**  
- Explicar que `Environment` centraliza o acesso a propriedades.
- Citar os métodos principais: `getProperty()`, `getActiveProfiles()`, `containsProperty()`.
- Explicar quando usar em vez de `@Value`: acesso dinâmico, perfis, múltiplas propriedades.
- Mostrar exemplo prático de leitura dinâmica.

**Resposta fraca ou incompleta:**  
"Environment é para ler propriedades do application.properties."  
Falta: não cita métodos, não diferencia de @Value, não menciona perfis.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece Environment |
| 1 | Sabe que "lê propriedades" mas sem detalhar |
| 2 | Menciona getProperty() mas não conhece perfis |
| 3 | Explica métodos, perfis e diferença de @Value |
| 4 | Demonstra uso dinâmico com exemplo prático |
| 5 | Responde com profundidade, menciona PropertySource, getRequiredProperty e MutablePropertySources |

**Perguntas de aprofundamento:**
1. "Como o `Environment` decide de onde ler uma propriedade quando ela existe em múltiplas fontes?"
2. "É possível adicionar uma nova fonte de propriedades em runtime? Como?"
3. "Qual a relação entre `Environment` e `@ConfigurationProperties`?"

---

### Pergunta 75 — O que é @ConfigurationProperties e como difere de @Value?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Para ler propriedades complexas (listas, maps, objetos aninhados) do `application.properties`, usar `@Value` em cada campo é impraticável. Como o `@ConfigurationProperties` resolve isso e qual a vantagem sobre `@Value`?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece `@ConfigurationProperties` como alternativa robusta a `@Value`, sabe que ele agrupa propriedades relacionadas em uma classe tipada e entende a validação integrada.

**Resposta esperada:**  
`@ConfigurationProperties` permite mapear um grupo de propriedades relacionadas para uma **classe Java tipada**, com suporte a propriedades aninhadas, listas, maps e validação Bean Validation. É a abordagem recomendada para configurações estruturadas.

**1. Definindo a classe de propriedades:**

```properties
# application.properties
app.nome=Minha API
app.versao=1.0.0
app.servidores[0]=srv1.empresa.com
app.servidores[1]=srv2.empresa.com
app.database.url=jdbc:postgresql://localhost:5432/db
app.database.driver=org.postgresql.Driver
app.database.pool.max-conexoes=20
app.database.pool.timeout=30000
app.feature-flags.novo-relatorio=true
app.feature-flags.novo-login=false
```

```java
@ConfigurationProperties(prefix = "app")
@Validated  // Habilita validação das propriedades
public class AppProperties {

    @NotBlank
    private String nome;

    @NotBlank
    private String versao;

    private List<String> servidores = new ArrayList<>();

    private Database database = new Database();

    private FeatureFlags featureFlags = new FeatureFlags();

    // Classe aninhada — Database
    public static class Database {
        @NotBlank
        private String url;
        @NotBlank
        private String driver;
        private Pool pool = new Pool();

        public static class Pool {
            @Min(1) @Max(100)
            private int maxConexoes = 10;
            @Min(1000)
            private int timeout = 5000;
        }
    }

    // Classe aninhada — FeatureFlags
    public static class FeatureFlags {
        private boolean novoRelatorio = false;
        private boolean novoLogin = false;
    }

    // Getters e setters (necessários para binding)
    // Ou usar Lombok: @Data @ConfigurationProperties(prefix = "app")
}
```

**2. Ativando @ConfigurationProperties:**

```java
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)  // Registra a classe
public class MinhaAplicacao {
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }
}

// Ou anotar a própria classe:
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties { ... }
```

**3. Usando a classe injetada:**

```java
@Service
@RequiredArgsConstructor
public class AppService {

    private final AppProperties properties;  // Injetada como um bean

    public void exibirConfig() {
        System.out.println("Nome: " + properties.getNome());
        System.out.println("Servidores: " + properties.getServidores());
        System.out.println("URL Banco: " + properties.getDatabase().getUrl());
        System.out.println("Max conexões: " + properties.getDatabase().getPool().getMaxConexoes());
        System.out.println("Novo relatório: " + properties.getFeatureFlags().isNovoRelatorio());
    }
}
```

**Comparação: @ConfigurationProperties vs. @Value:**

| Aspecto | @Value | @ConfigurationProperties |
|---------|--------|------------------------|
| Estrutura | Um campo por anotação | Agrupa em classe tipada |
| Propriedades aninhadas | Não suporta bem | Suporta nativamente |
| Listas e Maps | Limitado | Suporte nativo |
| Validação | Não | Sim, com @Validated |
| Relaxed binding | Sim | Sim |
| SpEL | Sim | Não |
| Type safety | Fraca (String) | Forte (tipos Java) |
| Reutilização | Cada classe injeta separadamente | Um bean compartilhado |

**Explicação didática:**  
`@Value` é como anotar cada campo de um formulário individualmente com um post-it dizendo onde buscar a informação. Funciona, mas para 20 campos você tem 20 post-its. `@ConfigurationProperties` é como criar uma "pasta de configuração" que o Spring preenche automaticamente — você define a estrutura (classe com campos), aponta o prefixo, e o Spring preenche tudo de uma vez, inclusive subpastas (propriedades aninhadas) e listas.

**Como o candidato deve responder:**  
- Explicar que `@ConfigurationProperties` mapeia propriedades para uma classe tipada.
- Mencionar que suporta propriedades aninhadas, listas e maps.
- Citar a validação com `@Validated`.
- Comparar com `@Value`: type safety, agrupamento, estruturas complexas.
- Mostrar exemplo prático com propriedades aninhadas.

**Resposta fraca ou incompleta:**  
"É outra forma de ler propriedades."  
Falta: não explica a vantagem, não mostra estruturas aninhadas, não compara com @Value.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @ConfigurationProperties |
| 1 | Sabe que "lê propriedades" mas não diferencia de @Value |
| 2 | Menciona classes tipadas mas sem exemplo de aninhamento |
| 3 | Explica classe tipada, aninhamento, listas e validação |
| 4 | Demonstra comparação completa com @Value e boas práticas |
| 5 | Responde com profundidade, menciona @ConstructorBinding, records e imutabilidade |

**Perguntas de aprofundamento:**
1. "É possível usar `@ConfigurationProperties` com Java records? Como?"
2. "O que é `@ConstructorBinding` e quando é necessário?"
3. "Como você validaria que uma propriedade obrigatória foi definida na inicialização?"

---

### Pergunta 76 — Como funciona o multi-document YAML no Spring Boot?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Em vez de ter múltiplos arquivos `application-dev.yml`, `application-prod.yml`, etc., é possível definir configurações de múltiplos perfis em um único arquivo YAML. Como isso funciona e qual a sintaxe?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o recurso de multi-document YAML (separado por `---`), sabe como definir perfis no mesmo arquivo e entende a precedência entre documentos.

**Resposta esperada:**  
O Spring Boot suporta múltiplos "documentos" em um único arquivo YAML, separados por `---`. Cada documento pode ser associado a um profile específico, permitindo consolidar todas as configurações em um arquivo.

**Exemplo de multi-document YAML:**

```yaml
# Documento 1 — configurações comuns a todos os perfis
spring:
  application:
    name: minha-api
  profiles:
    active: dev

server:
  port: 8080

---
# Documento 2 — configurações do profile dev
spring:
  config:
    activate:
      on-profile: dev
  datasource:
    url: jdbc:h2:mem:devdb
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true

logging:
  level:
    com.empresa: DEBUG

---
# Documento 3 — configurações do profile prod
spring:
  config:
    activate:
      on-profile: prod
  datasource:
    url: jdbc:postgresql://prod-db:5432/minhadb
    username: ${DB_USER}
    password: ${DB_PASSWORD}
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false

server:
  port: 80

logging:
  level:
    com.empresa: INFO
    org.hibernate.SQL: WARN
```

**Como funciona:**
1. O Spring Boot lê o arquivo YAML e divide em documentos a cada `---`.
2. O documento sem `on-profile` é sempre aplicado (base comum).
3. Documentos com `on-profile: dev` só são aplicados quando o profile `dev` está ativo.
4. Documentos com `on-profile: prod` só são aplicados quando o profile `prod` está ativo.

**Precedência:**
- Documentos específicos de profile **sobrescrevem** o documento base.
- Se a mesma propriedade aparece no documento base e no documento de profile, o valor do profile vence.

**Sintaxe antiga (Spring Boot < 2.4):**

```yaml
# Forma antiga (deprecated no Spring Boot 3.x)
spring:
  profiles: dev

# Forma nova (Spring Boot 2.4+)
spring:
  config:
    activate:
      on-profile: dev
```

**Arquivo .properties NÃO suporta multi-document:**  
O recurso de multi-document é exclusivo do YAML. Em `.properties`, é necessário ter arquivos separados (`application-dev.properties`, `application-prod.properties`).

**Explicação didática:**  
Multi-document YAML é como um arquivo de texto com seções separadas por linhas pontilhadas. Cada seção tem um cabeçalho que diz "esta seção só vale para o profile X". O Spring Boot lê o arquivo, identifica as seções, e aplica apenas a que corresponde ao profile ativo — mais um arquivo para manter, em vez de cinco.

**Como o candidato deve responder:**  
- Explicar que `---` separa documentos YAML no mesmo arquivo.
- Mencionar `spring.config.activate.on-profile` para associar a um profile.
- Explicar que o documento sem profile é a base comum.
- Citar que documentos de profile sobrescrevem a base.
- Mencionar que `.properties` não suporta multi-document.

**Resposta fraca ou incompleta:**  
"Você pode separar com três traços no YAML."  
Falta: não explica `on-profile`, não menciona precedência, não mostra exemplo.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece multi-document YAML |
| 1 | Sabe que "---" separa mas não explica como |
| 2 | Usa a sintaxe mas não conhece on-profile |
| 3 | Explica on-profile, base comum e precedência |
| 4 | Demonstra sintaxe nova (2.4+) e diferença da antiga |
| 5 | Responde com profundidade, menciona import, spring.config.import e limitações |

**Perguntas de aprofundamento:**
1. "Qual a diferença entre a sintaxe antiga (`spring.profiles: dev`) e a nova (`spring.config.activate.on-profile: dev`)?"
2. "É possível importar configurações de outro arquivo YAML? Como?"
3. "O que acontece se dois documentos YAML definirem a mesma propriedade para o mesmo profile?"

---

### Pergunta 77 — O que são e como funcionam as anotações @Conditional no Spring Boot?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"A autoconfiguração do Spring Boot usa várias anotações `@Conditional*` para decidir se um bean deve ou não ser criado. Quais são as principais e como você usaria condicionais nos seus próprios beans?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece as anotações condicionais do Spring Boot, entende que elas controlam a criação de beans e sabe aplicá-las em configurações próprias.

**Resposta esperada:**  
As anotações `@Conditional*` permitem que o Spring decida **dinamicamente** se um bean deve ser registrado no contexto, com base em condições do ambiente. Elas são a base da autoconfiguração do Spring Boot.

**Principais anotações condicionais:**

| Anotação | Condição para criar o bean |
|----------|---------------------------|
| `@ConditionalOnClass(DataSource.class)` | A classe especificada está no classpath |
| `@ConditionalOnMissingBean(DataSource.class)` | Nenhum bean do tipo já existe |
| `@ConditionalOnProperty(name = "app.cache.enabled", havingValue = "true")` | A propriedade tem o valor especificado |
| `@ConditionalOnWebApplication` | É uma aplicação web (servlet) |
| `@ConditionalOnNotWebApplication` | NÃO é uma aplicação web |
| `@ConditionalOnExpression("#{${app.feature.enabled} and ${app.debug}}")` | Expressão SpEL é verdadeira |
| `@ConditionalOnBean(DataSource.class)` | Um bean do tipo já existe |
| `@ConditionalOnResource(resources = "classpath:db.properties")` | O recurso existe |
| `@ConditionalOnJava(JavaVersion.SEVENTEEN)` | Versão do Java atende |

**Exemplos práticos:**

```java
@Configuration
public class CondicionaisConfig {

    // Só cria este bean se a propriedade app.cache.enabled=true
    @Bean
    @ConditionalOnProperty(name = "app.cache.enabled", havingValue = "true", matchIfMissing = false)
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("usuarios", "produtos");
    }

    // Só cria se a classe RedisTemplate está no classpath
    @Bean
    @ConditionalOnClass(name = "org.springframework.data.redis.core.RedisTemplate")
    public CacheManager redisCacheManager() {
        return new RedisCacheManager();
    }

    // Só cria se NÃO existe nenhum DataSource já definido
    @Bean
    @ConditionalOnMissingBean(DataSource.class)
    public DataSource dataSourcePadrao() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .build();
    }

    // Só cria em aplicação web
    @Bean
    @ConditionalOnWebApplication
    public FiltroWeb filtroWeb() {
        return new FiltroWeb();
    }

    // Combinação de condições com @ConditionalOnExpression
    @Bean
    @ConditionalOnExpression("#{${app.feature.novo-relatorio} and '${spring.profiles.active}' == 'prod'}")
    public NovoRelatorioService novoRelatorioService() {
        return new NovoRelatorioService();
    }
}
```

**Criando uma condição customizada:**

```java
// 1. Criar a classe de condição
public class OnProductionCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.acceptsProfiles(Profiles.of("prod"));
    }
}

// 2. Criar a anotação
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnProductionCondition.class)
public @interface ConditionalOnProduction {
}

// 3. Usar a anotação customizada
@Bean
@ConditionalOnProduction
public AuditoriaService auditoriaService() {
    return new AuditoriaService();  // Só é criado em produção
}
```

**Explicação didática:**  
As anotações `@Conditional*` são como "portões seletivos" na linha de montagem de uma fábrica. Cada bean passa por um portão que verifica: "Este componente (classe) existe no estoque (classpath)?", "Já foi montado um igual?", "A configuração diz para montar este modelo?". Se o portão abre, o bean é montado (criado). Se não, ele é pulado. A autoconfiguração do Spring Boot usa dezenas desses portões para decidir o que montar.

**Como o candidato deve responder:**  
- Citar pelo menos quatro anotações condicionais principais.
- Explicar que elas controlam a criação de beans dinamicamente.
- Mostrar exemplo prático de uso (pelo menos `@ConditionalOnProperty` e `@ConditionalOnMissingBean`).
- Mencionar que é possível criar condições customizadas com `Condition`.

**Resposta fraca ou incompleta:**  
"Servem para a autoconfiguração do Spring Boot."  
Falta: não cita as anotações, não mostra exemplo, não explica como criar condições próprias.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @Conditional |
| 1 | Sabe que "controla beans" mas não cita anotações |
| 2 | Menciona 1-2 anotações mas sem exemplo |
| 3 | Explica múltiplas anotações com exemplos |
| 4 | Demonstra condição customizada e combinação de condições |
| 5 | Responde com profundidade, menciona ConditionContext, AnnotatedTypeMetadata e ordem de avaliação |

**Perguntas de aprofundamento:**
1. "O que é `matchIfMissing` em `@ConditionalOnProperty` e quando usar?"
2. "Como você criaria uma anotação condicional própria?"
3. "O que acontece se duas condições conflitantes forem verdadeiras ao mesmo tempo?"

---

### Pergunta 78 — O que é o MessageSource e como usá-lo para internacionalização?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Sua API precisa retornar mensagens de erro em diferentes idiomas (português, inglês, espanhol) dependendo do header `Accept-Language` do cliente. Como o Spring Boot suporta internacionalização (i18n)?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o `MessageSource` do Spring, sabe criar arquivos de mensagens por locale e entende como resolver mensagens internacionalizadas.

**Resposta esperada:**  
O Spring Boot fornece suporte a internacionalização (i18n) através do `MessageSource`, que carrega mensagens de arquivos de propriedades separados por idioma (locale).

**1. Criar arquivos de mensagens:**

```properties
# src/main/resources/messages.properties (padrão — fallback)
usuario.nao.encontrado=Usuário não encontrado
usuario.criado.sucesso=Usuário criado com sucesso
validacao.campo.obrigatorio=O campo {0} é obrigatório
```

```properties
# src/main/resources/messages_en.properties (inglês)
usuario.nao.encontrado=User not found
usuario.criado.sucesso=User created successfully
validacao.campo.obrigatorio=The field {0} is required
```

```properties
# src/main/resources/messages_es.properties (espanhol)
usuario.nao.encontrado=Usuario no encontrado
usuario.criado.sucesso=Usuario creado con éxito
validacao.campo.obrigatorio=El campo {0} es obligatorio
```

**2. Configurar o MessageSource:**

```java
@Configuration
public class InternacionalizacaoConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadResourceBundleMessageSource source = new ReloadResourceBundleMessageSource();
        source.setBasename("classpath:messages");
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(true);  // Usa a chave se não encontrar tradução
        return source;
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag("pt-BR"));
        resolver.setSupportedLocales(
            List.of(Locale.forLanguageTag("pt-BR"), Locale.ENGLISH, Locale.forLanguageTag("es"))
        );
        return resolver;
    }
}
```

**3. Usando o MessageSource no serviço:**

```java
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final MessageSource messageSource;

    public Usuario buscar(Long id, Locale locale) {
        return repository.findById(id)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(
                messageSource.getMessage("usuario.nao.encontrado", null, locale)
            ));
    }

    // Com parâmetros interpolados
    public String mensagemValidacao(String campo, Locale locale) {
        return messageSource.getMessage(
            "validacao.campo.obrigatorio",
            new Object[]{campo},  // Parâmetros para {0}, {1}, etc.
            locale
        );
    }
}
```

**4. Resolvendo o Locale no controller:**

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(
            @PathVariable Long id,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {

        // Locale vem do header Accept-Language
        // Ex: Accept-Language: en-US → locale = Locale.ENGLISH
        Usuario usuario = usuarioService.buscar(id, locale);
        return ResponseEntity.ok(usuario);
    }
}
```

**Fluxo:**
1. Cliente envia `Accept-Language: en-US`.
2. O `AcceptHeaderLocaleResolver` converte para `Locale.ENGLISH`.
3. O `MessageSource` procura `messages_en.properties`.
4. Se não encontra uma chave, cai para `messages.properties` (fallback).

**Explicação didática:**  
`MessageSource` é como ter um "tradutor simultâneo" na sua aplicação. Em vez de escrever "Usuário não encontrado" direto no código, você escreve uma "chave" (`usuario.nao.encontrado`) e o tradutor procura a mensagem correta no dicionário do idioma solicitado. Se o dicionário não tem a tradução, ele usa o dicionário padrão (português). Assim, a mesma aplicação serve clientes em qualquer idioma sem mudar o código.

**Como o candidato deve responder:**  
- Explicar que `MessageSource` gerencia mensagens internacionalizadas.
- Mencionar arquivos `messages.properties`, `messages_en.properties`, etc.
- Citar `LocaleResolver` para determinar o idioma do cliente.
- Mostrar como usar `getMessage()` com chaves e parâmetros.
- Mencionar o header `Accept-Language`.

**Resposta fraca ou incompleta:**  
"Você cria arquivos de mensagens em diferentes idiomas."  
Falta: não explica MessageSource, não menciona LocaleResolver, não mostra uso no código.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece i18n no Spring |
| 1 | Sabe que "tem arquivos de mensagens" mas não explica |
| 2 | Menciona MessageSource mas não configura LocaleResolver |
| 3 | Explica MessageSource, arquivos e LocaleResolver com exemplo |
| 4 | Demonstra getMessage com parâmetros e Accept-Language |
| 5 | Responde com profundidade, menciona SessionLocaleResolver, interpolation e fallback |

**Perguntas de aprofundamento:**
1. "O que acontece se uma chave não existir em nenhum arquivo de mensagens?"
2. "É possível carregar mensagens de um banco de dados em vez de arquivos? Como?"
3. "Como você internacionalizaria as mensagens de erro do Bean Validation (@NotBlank, etc.)?"

---

### Pergunta 79 — Como você lida com propriedades sensíveis (senhas, tokens) no Spring Boot?

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, você tem propriedades sensíveis como senha de banco de dados, tokens de API e chaves de criptografia. Onde você as guarda e como evita que elas fiquem visíveis no código ou no controle de versão?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe que propriedades sensíveis não devem estar no `application.properties` versionado, conhece o uso de variáveis de ambiente e entende o conceito de placeholders.

**Resposta esperada:**  
Propriedades sensíveis **nunca** devem ser commitadas no controle de versão. O Spring Boot oferece várias estratégias para externalizá-las:

**1. Variáveis de ambiente (abordagem mais comum):**

```properties
# application.properties — usa placeholder ${VARIAVEL}
spring.datasource.url=jdbc:postgresql://localhost:5432/db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
app.api-key=${API_KEY:default-not-secret}  # :default é fallback
```

```bash
# Em produção — variáveis de ambiente
export DB_USERNAME=admin
export DB_PASSWORD=minhaSenhaSegura123
export API_KEY=abc-123-xyz
java -jar app.jar
```

**2. Argumentos de linha de comando:**

```bash
java -jar app.jar \
  --spring.datasource.password=minhaSenha \
  --app.api-key=abc-123-xyz
```

**3. Spring Cloud Config Server (centralizado):**

Para microserviços, um servidor central de configuração gerencia segredos:

```yaml
# bootstrap.yml
spring:
  cloud:
    config:
      uri: http://config-server:8888
      name: minha-api
      profile: prod
```

**4. HashiCorp Vault (secrets management):**

```java
// Spring Cloud Vault
@Configuration
public class VaultConfig {
    // O Spring Cloud Vault injeta segredos do Vault
    // como propriedades do Environment
}
```

**5. application.properties com profiles separados:**

```properties
# application.properties — versionado, sem segredos
spring.datasource.url=jdbc:postgresql://localhost:5432/db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

```properties
# application-local.properties — NÃO versionado (.gitignore)
# Usado apenas em desenvolvimento local
spring.datasource.username=dev_user
spring.datasource.password=dev_password
```

```gitignore
# .gitignore
application-local.properties
application-local.yml
```

**6. Placeholders com valor padrão:**

```properties
# Se a variável não existir, usa o valor após os dois pontos
app.timeout=${APP_TIMEOUT:5000}
spring.datasource.password=${DB_PASSWORD:}
# Se DB_PASSWORD não estiver definida, password será vazio (fail fast)
```

**Boas práticas:**
1. **Nunca commit senhas** — sempre usar `${VARIAVEL}`.
2. **Usar `.gitignore`** para arquivos com segredos locais.
3. **Em produção**, usar variáveis de ambiente, Vault ou Config Server.
4. **Auditar** o repositório em busca de segredos (ferramentas como git-secrets, truffleHog).
5. **Se um segredo foi commitado**, rotacioná-lo imediatamente (não basta remover do histórico).

**Explicação didática:**  
Placeholders `${VARIAVEL}` são como "caixas vazias" no seu arquivo de configuração. Você entrega o arquivo versionado com a caixa vazia (`${DB_PASSWORD}`), e no ambiente onde a aplicação roda, alguém (o sistema operacional, o Docker, o Kubernetes) coloca o valor real na caixa antes de iniciar a aplicação. Assim, quem tem acesso ao código não tem acesso ao segredo.

**Como o candidato deve responder:**  
- Explicar que senhas não devem ser versionadas.
- Mencionar o uso de placeholders `${VARIAVEL}` no `application.properties`.
- Citar variáveis de ambiente como fonte principal de segredos.
- Mencionar o uso de `.gitignore` para arquivos locais.
- Citar Vault ou Spring Cloud Config como alternativas avançadas.

**Resposta fraca ou incompleta:**  
"Eu coloco as senhas no application.properties."  
Falta: não usa placeholders, não externaliza, não menciona variáveis de ambiente.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Versiona senhas no properties |
| 1 | Sabe que "não deve" mas não sabe como evitar |
| 2 | Menciona variáveis de ambiente mas sem placeholder |
| 3 | Explica placeholders, variáveis de ambiente e .gitignore |
| 4 | Demonstra Vault, Config Server e boas práticas de rotação |
| 5 | Responde com profundidade, menciona Docker secrets, K8s secrets e auditoria |

**Perguntas de aprofundamento:**
1. "O que acontece se uma variável de ambiente referenciada por `${VARIAVEL}` não estiver definida?"
2. "Como você gerenciaria segredos em um ambiente Kubernetes?"
3. "Se uma senha foi acidentalmente commitada, o que você faria?"

---

### Pergunta 80 — O que é o Actuator no Spring Boot e como usá-lo para monitoramento?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em uma aplicação Spring Boot em produção, você precisa monitorar a saúde, métricas e status da aplicação. O que é o Spring Boot Actuator e quais endpoints ele oferece?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o Actuator como módulo de monitoramento, sabe configurá-lo e conhece os principais endpoints.

**Resposta esperada:**  
O **Spring Boot Actuator** é um módulo que adiciona endpoints de monitoramento e gestão à aplicação, permitindo verificar saúde, métricas, configurações, threads, log levels e mais.

**1. Adicionando a dependência:**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

**2. Principais endpoints:**

| Endpoint | Descrição | Sensível |
|----------|-----------|----------|
| `/actuator/health` | Status de saúde da aplicação (UP/DOWN) | Não |
| `/actuator/info` | Informações gerais da aplicação | Não |
| `/actuator/metrics` | Métricas (memória, threads, requisições) | Sim |
| `/actuator/env` | Variáveis de ambiente e propriedades | Sim |
| `/actuator/loggers` | Visualizar e alterar log levels em runtime | Sim |
| `/actuator/beans` | Lista todos os beans do contexto | Sim |
| `/actuator/mappings` | Lista todos os endpoints MVC | Sim |
| `/actuator/threaddump` | Dump de threads (útil para debugging) | Sim |
| `/actuator/heapdump` | Dump de memória heap | Sim |
| `/actuator/scheduledtasks` | Lista tarefas @Scheduled | Sim |

**3. Configuração:**

```properties
# application.properties

# Exposição de endpoints
# none — não expõe nada via HTTP (padrão)
# all — expõe todos
# health,info,metrics — expõe apenas os listados
management.endpoints.web.exposure.include=health,info,metrics

# Endpoint de health — mostra detalhes
management.endpoint.health.show-details=when-authorized

# Endpoint de info — habilita informações do build
management.info.env.enabled=true
management.info.java.enabled=true

# Customizar caminho base (padrão: /actuator)
# management.endpoints.web.base-path=/management

# Segurança — proteger endpoints sensíveis
management.endpoints.web.exposure.exclude=env,beans,threaddump
```

**4. Endpoint de health customizado:**

```java
@Component
@RequiredArgsConstructor
public class CustomHealthIndicator implements HealthIndicator {

    private final PagamentoClient pagamentoClient;

    @Override
    public Health health() {
        try {
            // Verifica se o serviço de pagamentos está acessível
            String status = pagamentoClient.verificarStatus();
            return Health.up()
                .withDetail("pagamentoService", "Operacional")
                .withDetail("status", status)
                .build();
        } catch (Exception e) {
            return Health.down()
                .withDetail("pagamentoService", "Indisponível")
                .withDetail("erro", e.getMessage())
                .build();
        }
    }
}
```

**5. Informações customizadas no endpoint /info:**

```java
@Component
public class AppInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("app", Map.of(
            "nome", "Minha API",
            "versao", "1.0.0",
            "descricao", "API de gestão de usuários"
        ));
    }
}
```

**Exemplo de resposta do /actuator/health:**

```json
{
    "status": "UP",
    "components": {
        "db": {
            "status": "UP",
            "details": {
                "database": "PostgreSQL",
                "result": 1
            }
        },
        "diskSpace": {
            "status": "UP",
            "details": {
                "total": 500107862016,
                "free": 311372800000
            }
        },
        "ping": {
            "status": "UP"
        },
        "pagamentoService": {
            "status": "UP",
            "details": {
                "status": "Operacional"
            }
        }
    }
}
```

**Explicação didática:**  
O Actuator é como o "painel de instrumentos" de um carro. O endpoint `/health` é a luz verde no painel (tudo funcionando). `/metrics` é o velocímetro e o medidor de combustível (dados numéricos em tempo real). `/loggers` é como ajustar o volume do rádio em movimento (mudar log level sem reiniciar). Sem o Actuator, você precisaria de ferramentas externas ou código manual para obter essas informações.

**Como o candidato deve responder:**  
- Explicar que o Actuator é um módulo de monitoramento.
- Citar pelo menos três endpoints: health, metrics, info.
- Mencionar a configuração de exposição (`management.endpoints.web.exposure.include`).
- Explicar que alguns endpoints são sensíveis e precisam de proteção.
- Mostrar exemplo de `HealthIndicator` customizado.

**Resposta fraca ou incompleta:**  
"O Actutor mostra a saúde da aplicação."  
Falta: não cita endpoints, não explica configuração, não menciona exposição seletiva.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece Actuator |
| 1 | Sabe que "monitora" mas não cita endpoints |
| 2 | Menciona /health mas não conhece configuração |
| 3 | Explica múltiplos endpoints, configuração e HealthIndicator |
| 4 | Demonstra HealthIndicator customizado e proteção de endpoints |
| 5 | Responde com profundidade, menciona integração com Prometheus, Grafana e micrometer |

**Perguntas de aprofundamento:**
1. "Como você protegeria os endpoints sensíveis do Actuator em produção?"
2. "Como você integraria as métricas do Actuator com o Prometheus?"
3. "O que é o Micrometer e qual a relação com o Actuator?"

---

## Roteiro de Entrevista Técnica — Spring Boot

### Parte 9 de 10 — Perguntas 81 a 90

**Foco:** Boas práticas — estrutura de pacotes, convenções REST, DTO pattern, exception handling global, logging, propriedades

---

### Pergunta 81 — Como você organiza a estrutura de pacotes em um projeto Spring Boot?

**Nível:** Júnior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
"Quando você inicia um projeto Spring Boot do zero, como você organiza a estrutura de pacotes? Quais convenções você segue e por quê?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe organizar pacotes de forma lógica, conhece os dois principais estilos (por camada e por feature) e entende o impacto da estrutura de pacotes na manutenibilidade do projeto.

**Resposta esperada:**  
Existem duas abordagens principais para organizar pacotes em um projeto Spring Boot:

**1. Organização por camada (layered package structure):**

```
com.empresa.projeto
├── controller        # Controllers REST
│   ├── UsuarioController.java
│   └── PedidoController.java
├── service           # Lógica de negócio
│   ├── UsuarioService.java
│   └── PedidoService.java
├── repository        # Acesso a dados
│   ├── UsuarioRepository.java
│   └── PedidoRepository.java
├── model             # Entidades JPA
│   ├── Usuario.java
│   └── Pedido.java
├── dto               # Objetos de transferência
│   ├── usuario
│   │   ├── UsuarioCreateDTO.java
│   │   └── UsuarioResponseDTO.java
│   └── pedido
│       └── PedidoResponseDTO.java
├── config           # Configurações
│   ├── OpenApiConfig.java
│   └── SecurityConfig.java
├── exception        # Tratamento de exceções
│   ├── GlobalExceptionHandler.java
│   └── UsuarioNaoEncontradoException.java
└── util             # Utilitários
```

**2. Organização por feature (feature package structure — recomendada para projetos maiores):**

```
com.empresa.projeto
├── usuario               # Tudo relacionado a usuários
│   ├── controller
│   │   └── UsuarioController.java
│   ├── service
│   │   └── UsuarioService.java
│   ├── repository
│   │   └── UsuarioRepository.java
│   ├── model
│   │   └── Usuario.java
│   ├── dto
│   │   ├── UsuarioCreateDTO.java
│   │   └── UsuarioResponseDTO.java
│   └── exception
│       └── UsuarioNaoEncontradoException.java
├── pedido                # Tudo relacionado a pedidos
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   └── dto
├── config               # Configurações globais
│   ├── OpenApiConfig.java
│   └── SecurityConfig.java
├── common               # Código compartilhado
│   ├── exception
│   │   └── GlobalExceptionHandler.java
│   └── dto
│       └── ErroDTO.java
└── MinhaAplicacao.java   # Classe principal (raiz)
```

**Comparação:**

| Critério | Por camada | Por feature |
|----------|-----------|------------|
| Projeto pequeno | ✅ Simples e suficiente | ❌ Overengineering |
| Projeto grande | ❌ Muitos arquivos por pacote | ✅ Navegação facilitada |
| Coesão | Baixa (service separado do controller) | Alta (tudo do domínio junto) |
| Acoplamento | Tende a cruzar camadas | Isolado por feature |
| Microserviços | Pouco usado | Melhor adaptação |

**Importante:** A classe principal (`@SpringBootApplication`) deve sempre ficar no **pacote raiz** (`com.empresa.projeto`), nunca em um subpacote, para que o `@ComponentScan` encontre todos os componentes.

**Explicação didática:**  
Organizar por camada é como organizar uma casa por tipo de objeto: todos os livros na estante, todas as roupas no armário, toda a comida na cozinha. Funciona em casas pequenas. Organizar por feature é como organizar por cômodo: no escritório tem livro, caneta e computador; na cozinha tem livro de receitas, comida e panela. Cada cômodo tem tudo que precisa para sua função — você não precisa andar pela casa inteira para cozinhar.

**Como o candidato deve responder:**  
- Mostrar as duas abordagens (por camada e por feature).
- Explicar quando usar cada uma (tamanho do projeto).
- Mencionar que a classe principal deve ficar no pacote raiz.
- Citar que `config`, `common` e `exception` são pacotes transversais.
- Justificar sua preferência com um critério objetivo.

**Resposta fraca ou incompleta:**  
"Eu coloco controller, service e repository em pacotes separados."  
Falta: não menciona organização por feature, não justifica a escolha, não cita a classe principal.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe organizar pacotes |
| 1 | Menciona controller/service mas sem justificativa |
| 2 | Mostra organização por camada mas não conhece por feature |
| 3 | Explica as duas abordagens com prós e contras |
| 4 | Justifica escolha com base no tamanho do projeto e coesão |
| 5 | Responde com profundidade, menciona módulos, hexagonal architecture e impacto no ComponentScan |

**Perguntas de aprofundamento:**
1. "Em um projeto com 20 domínios de negócio, qual estrutura você usaria? Por quê?"
2. "Como você lidaria com classes compartilhadas entre features?"
3. "O que muda na estrutura de pacotes se você usar arquitetura hexagonal?"

---

### Pergunta 82 — Quais convenções REST você segue ao nomear endpoints?

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
"Quando você projeta uma API REST no Spring Boot, como você nomeia os endpoints? Quais convenções você segue para URLs, métodos HTTP e pluralização?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece as convenções REST (recursos em plural, substantivos não verbos, métodos HTTP corretos) e sabe aplicá-las de forma consistente.

**Resposta esperada:**  
As principais convenções REST para nomeação de endpoints:

**1. Usar substantivos no plural, não verbos:**

```
✅ Correto                        ❌ Incorreto
GET  /api/usuarios                GET  /api/getUsuarios
POST /api/usuarios                POST /api/criarUsuario
GET  /api/usuarios/{id}           GET  /api/buscarUsuarioPorId?id=1
DELETE /api/usuarios/{id}         DELETE /api/deleteUsuario/{id}
```

A URL identifica o **recurso**, não a **ação**. A ação é definida pelo método HTTP.

**2. Métodos HTTP corretos por operação:**

| Método | Operação | Status de sucesso | Idempotente |
|--------|----------|-------------------|-------------|
| GET | Listar/Buscar | 200 | Sim |
| POST | Criar | 201 | Não |
| PUT | Atualizar (substituir) | 200/204 | Sim |
| PATCH | Atualizar parcial | 200/204 | Sim |
| DELETE | Excluir | 204 | Sim |

**3. Hierarquia de recursos:**

```
# Relacionamento: um usuário tem vários pedidos
GET  /api/usuarios/{id}/pedidos          # Lista pedidos de um usuário
GET  /api/usuarios/{id}/pedidos/{pid}    # Pedido específico de um usuário
POST /api/usuarios/{id}/pedidos          # Cria pedido para um usuário

# Recurso independente (pedido existe sem precisar do usuário na URL)
GET  /api/pedidos/{id}                   # Busca pedido diretamente
```

**4. Filtros, ordenação e paginação via query params:**

```
GET /api/usuarios?nome=João&idade=25           # Filtros
GET /api/usuarios?sort=nome,asc                # Ordenação
GET /api/usuarios?page=0&size=10&sort=nome    # Paginação
GET /api/usuarios?ativo=true&sort=nome,desc   # Filtro + ordenação
```

**5. Código de status correto por situação:**

```
POST   /api/usuarios          → 201 Created (recurso criado)
GET    /api/usuarios/{id}     → 200 OK (encontrado)
GET    /api/usuarios/{id}     → 404 Not Found (não existe)
DELETE /api/usuarios/{id}     → 204 No Content (excluído)
POST   /api/usuarios          → 400 Bad Request (validação falhou)
POST   /api/usuarios          → 409 Conflict (e-mail duplicado)
```

**Exemplo de controller seguindo as convenções:**

```java
@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuários", description = "Gestão de usuários")
public class UsuarioController {

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nome,asc") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(parseSort(sort)));
        return ResponseEntity.ok(usuarioService.listar(nome, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@Valid @RequestBody UsuarioCreateDTO dto) {
        UsuarioResponseDTO criado = usuarioService.criar(dto);
        return ResponseEntity.created(URI.create("/api/usuarios/" + criado.id())).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioUpdateDTO dto) {
        return ResponseEntity.ok(usuarioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
    }
}
```

**Explicação didática:**  
URLs REST são como endereços postais. O CEP identifica a rua (recurso: `/usuarios`), o número identifica o imóvel (`/42`), e a ação que você realiza é definida pelo tipo de visita: GET é "olhar a casa", POST é "construir uma casa nova", PUT é "reconstruir", DELETE é "demolir". Você não coloca "demolir" no endereço — o que está no endereço é o **o quê** (recurso), o **como** (ação) vem pelo método HTTP.

**Como o candidato deve responder:**  
- Explicar que URLs usam substantivos no plural.
- Mencionar que a ação é definida pelo método HTTP, não pela URL.
- Citar os cinco métodos HTTP e seus usos.
- Mostrar paginação e filtros via query params.
- Mencionar os status codes corretos para cada operação.

**Resposta fraca ou incompleta:**  
"Eu coloco /api/ antes das URLs e uso GET, POST, PUT e DELETE."  
Falta: não menciona pluralização, não explica substantivos vs. verbos, não cita status codes.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece convenções REST |
| 1 | Usa GET e POST mas não diferencia PUT/PATCH/DELETE |
| 2 | Menciona plural e métodos mas sem status codes |
| 3 | Explica convenções completas com exemplos |
| 4 | Demonstra paginação, filtros e hierarquia de recursos |
| 5 | Responde com profundidade, menciona HATEOAS, PATCH vs. PUT e idempotência |

**Perguntas de aprofundamento:**
1. "Qual a diferença entre PUT e PATCH? Quando usar cada um?"
2. "O que é HATEOAS e por que é considerado o nível mais alto de maturidade REST?"
3. "Como você lidaria com operações que não se encaixam em CRUD? Por exemplo, 'ativar usuário'?"

---

### Pergunta 83 — Como você padroniza respostas de erro em uma API Spring Boot?

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
"Em uma API com dezenas de endpoints, cada erro pode ter um formato diferente. Como você garante que todos os erros retornem o mesmo formato padronizado para o cliente?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe criar um formato de erro consistente, implementar um `@ControllerAdvice` centralizado e tratar os principais tipos de exceção de forma uniforme.

**Resposta esperada:**  
A padronização de erros envolve três passos: criar um DTO de erro, implementar um `@ControllerAdvice` global e tratar os principais tipos de exceção.

**1. DTO de erro padronizado:**

```java
public record ErroResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    String path,
    List<String> details
) {
    // Builder estático para facilitar construção
    public static ErroResponse of(HttpStatus status, String message, String path, List<String> details) {
        return new ErroResponse(
            LocalDateTime.now(),
            status.value(),
            status.getReasonPhrase(),
            message,
            path,
            details != null ? details : List.of()
        );
    }
}
```

**2. ControllerAdvice global:**

```java
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final HttpServletRequest request;

    // Recurso não encontrado
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> handleNaoEncontrado(RecursoNaoEncontradoException ex) {
        ErroResponse erro = ErroResponse.of(
            HttpStatus.NOT_FOUND,
            ex.getMessage(),
            request.getRequestURI(),
            List.of()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    // Validação de dados (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> handleValidacao(MethodArgumentNotValidException ex) {
        List<String> details = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(e -> e.getField() + ": " + e.getDefaultMessage())
            .toList();

        ErroResponse erro = ErroResponse.of(
            HttpStatus.BAD_REQUEST,
            "Dados inválidos",
            request.getRequestURI(),
            details
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    // Parâmetro inválido (tipo errado em @PathVariable)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErroResponse> handleTipoInvalido(MethodArgumentTypeMismatchException ex) {
        ErroResponse erro = ErroResponse.of(
            HttpStatus.BAD_REQUEST,
            "Parâmetro inválido: " + ex.getName() + " deve ser " + ex.getRequiredType().getSimpleName(),
            request.getRequestURI(),
            List.of()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    // Conflito (violação de constraint única)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroResponse> handleConflito(DataIntegrityViolationException ex) {
        ErroResponse erro = ErroResponse.of(
            HttpStatus.CONFLICT,
            "Violação de restrição de dados",
            request.getRequestURI(),
            List.of()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    // Erro genérico (fallback — sempre por último)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> handleGenerico(Exception ex) {
        ErroResponse erro = ErroResponse.of(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Erro interno do servidor",
            request.getRequestURI(),
            List.of()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}
```

**3. Exemplo de resposta padronizada:**

```json
// Erro de validação (400)
{
    "timestamp": "2024-01-15T10:30:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Dados inválidos",
    "path": "/api/usuarios",
    "details": [
        "nome: nome é obrigatório",
        "email: e-mail inválido"
    ]
}

// Recurso não encontrado (404)
{
    "timestamp": "2024-01-15T10:31:00",
    "status": 404,
    "error": "Not Found",
    "message": "Usuário não encontrado com id 99",
    "path": "/api/usuarios/99",
    "details": []
}
```

**Por que o fallback genérico não loga a mensagem da exceção no corpo da resposta:**  
Em produção, nunca retorne `ex.getMessage()` no erro genérico — pode expor detalhes internos da aplicação (nomes de tabelas, queries, stack traces). Logue internamente e retorne uma mensagem genérica ao cliente.

**Explicação didática:**  
Padronizar erros é como ter um "formulário padrão de ocorrência" em um hospital. Não importa o problema — fratura, febre, alergia — o formulário tem sempre os mesmos campos: data, gravidade (status), tipo, descrição, local e detalhes. O paciente (cliente da API) sempre sabe onde olhar para entender o que aconteceu, sem precisar "adivinhar" o formato de cada médico (endpoint).

**Como o candidato deve responder:**  
- Criar um DTO de erro padronizado com campos consistentes.
- Implementar `@ControllerAdvice` com tratamento para os principais tipos de exceção.
- Tratar: recurso não encontrado, validação, tipo inválido, conflito e erro genérico.
- Explicar que o fallback genérico não deve expor detalhes internos.
- Mostrar exemplo de resposta JSON padronizada.

**Resposta fraca ou incompleta:**  
"Eu uso @ControllerAdvice para tratar exceções."  
Falta: não mostra o DTO de erro, não padroniza o formato, não trata múltiplos tipos de exceção.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe padronizar erros |
| 1 | Menciona @ControllerAdvice mas sem DTO |
| 2 | Tem DTO mas trata apenas um tipo de exceção |
| 3 | Mostra DTO padronizado e múltiplos handlers |
| 4 | Demonstra tratamento de validação, 404, conflito e fallback |
| 5 | Responde com profundidade, menciona não exposição de detalhes internos, log e RFC 7807 |

**Perguntas de aprofundamento:**
1. "O que é o Problem Details for HTTP APIs (RFC 7807)? Você já usou?"
2. "Como você evitaria que o erro genérico exponha detalhes internos da aplicação?"
3. "Como você logaria a exceção no handler antes de retornar a resposta?"

---

### Pergunta 84 — Como você gerencia configurações sensíveis (senhas, tokens) em um projeto Spring Boot?

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
"Em seu `application.properties`, você tem a URL do banco, usuário e senha. Se você commitar isso no Git, a senha fica exposta. Como você lida com configurações sensíveis em um projeto Spring Boot?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece as estratégias para proteger configurações sensíveis, sabe usar variáveis de ambiente, entende a ordem de precedência das propriedades e conhece ferramentas externas de gerenciamento de secrets.

**Resposta esperada:**  
Nunca coloque configurações sensíveis (senhas, tokens, chaves de API) diretamente no `application.properties` que vai para o controle de versão. As principais estratégias são:

**1. Variáveis de ambiente (abordagem mais comum):**

```properties
# application.properties
spring.datasource.url=${DB_URL:jdbc:postgresql://localhost:5432/meudb}
spring.datasource.username=${DB_USERNAME:postgres}
spring.datasource.password=${DB_PASSWORD}  # Sem default — obriga a definir
```

No sistema operacional ou container:
```bash
export DB_PASSWORD=minhaSenhaSecreta
java -jar app.jar
```

Em Docker:
```yaml
# docker-compose.yml
services:
  app:
    environment:
      - DB_URL=jdbc:postgresql://db:5432/meudb
      - DB_USERNAME=postgres
      - DB_PASSWORD=senha_secreta
```

**2. Arquivo de configuração externo (não versionado):**

```properties
# application-local.properties (adicionado ao .gitignore)
spring.datasource.password=minhaSenhaReal
```

```properties
# application.properties (versionado)
spring.datasource.password=${DB_PASSWORD:default}
```

Ativar com:
```bash
java -jar app.jar --spring.config.additional-location=file:/etc/app/config/
```

**3. Spring Boot externalized configuration (ordem de precedência):**

O Spring Boot lê propriedades em uma ordem específica — as últimas sobrescrevem as primeiras:

1. Default values (codificados no código)
2. `application.properties` dentro do JAR
3. `application-{profile}.properties` dentro do JAR
4. `application.properties` fora do JAR (mesmo diretório)
5. `application-{profile}.properties` fora do JAR
6. **Variáveis de ambiente**
7. **Argumentos de linha de comando** (`--prop=valor`)
8. **Properties programáticas** (`SpringApplication.setDefaultProperties`)

**4. Ferramentas externas (para projetos mais maduros):**

| Ferramenta | Como funciona |
|------------|---------------|
| **Vault (HashiCorp)** | Serviço centralizado de secrets — a aplicação busca em runtime |
| **AWS Secrets Manager** | Serviço da AWS para armazenar e rotacionar secrets |
| **Kubernetes Secrets** | Secrets do K8s montados como variáveis ou volumes |
| **Spring Cloud Config** | Servidor centralizado de configuração com criptografia |

**5. Jasypt (criptografia de propriedades):**

```properties
# application.properties — senha criptografada
spring.datasource.password=ENC(G6N7Rg2v2vJ45m8x9pXq==)
```

```java
// Configuração para descriptografar
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
```

```bash
# A chave de criptografia vem de variável de ambiente
java -jar app.jar --jasypt.encryptor.password=minhaChaveSecreta
```

**Boas práticas:**

1. **`application.properties` versionado** tem apenas placeholders (`${VAR_NAME}`) e defaults não sensíveis.
2. **Senhas reais** sempre via variável de ambiente ou ferramenta externa.
3. **`.gitignore`** deve incluir `application-local.properties` e arquivos `.env`.
4. **Diferentes secrets por ambiente** — dev, staging e prod usam senhas diferentes.
5. **Rotação de secrets** — em produção, trocar periodicamente.

**Explicação didática:**  
Colocar a senha do banco no `application.properties` e commitá-la no Git é como escrever a senha do seu cofre em um cartaz e colar na parede do escritório — qualquer pessoa que passa vê. A abordagem correta é como um cofre dentro do cofre: o `application.properties` tem um "espaço reservado" (placeholder) onde a senha vai, mas a senha real é entregue por um mensageiro confiável (variável de ambiente) que só o cofre conhece.

**Como o candidato deve responder:**  
- Explicar que senhas não devem ir para o controle de versão.
- Citar variáveis de ambiente como abordagem principal.
- Mostrar sintaxe de placeholder: `${DB_PASSWORD}`.
- Mencionar a ordem de precedência das propriedades.
- Citar pelo menos uma ferramenta externa (Vault, AWS Secrets Manager).

**Resposta fraca ou incompleta:**  
"Eu coloco as senhas no application-prod.properties."  
Falta: não explica como proteger o arquivo, não menciona variáveis de ambiente, não cita a ordem de precedência.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe como proteger secrets |
| 1 | Sabe que "não commita" mas não sabe como resolver |
| 2 | Menciona variáveis de ambiente mas sem placeholder |
| 3 | Explica placeholders, variáveis de ambiente e ordem de precedência |
| 4 | Demonstra conhecimento de ferramentas externas e boas práticas |
| 5 | Responde com profundidade, menciona Vault, Jasypt, rotação e K8s Secrets |

**Perguntas de aprofundamento:**
1. "Como o Spring Boot resolve conflitos quando a mesma propriedade está definida em múltiplas fontes?"
2. "Em Kubernetes, como você injetaria secrets como variáveis de ambiente?"
3. "O que é o Spring Cloud Config Server e como ele se diferencia do Vault?"

---

### Pergunta 85 — O que é e como usar o Environment no Spring Boot?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Além do `@Value` para ler propriedades, o Spring Boot oferece a interface `Environment`. O que ela é, como você usa e qual a vantagem sobre `@Value`?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece a interface `Environment` como alternativa dinâmica ao `@Value`, sabe injetá-la e entende quando é preferível usar uma ou outra.

**Resposta esperada:**  
A interface `Environment` do Spring representa o **ambiente de execução** da aplicação, fornecendo acesso a todas as propriedades configuradas — sejam elas de `application.properties`, variáveis de ambiente, argumentos de linha de comando ou system properties.

**Como usar:**

```java
@Service
@RequiredArgsConstructor
public class ConfiguracaoService {

    private final Environment environment;

    public void imprimirConfiguracoes() {
        // Lê uma propriedade — retorna null se não existir
        String urlBanco = environment.getProperty("spring.datasource.url");

        // Lê com valor default
        String porta = environment.getProperty("server.port", "8080");

        // Lê convertido para um tipo específico
        Integer timeout = environment.getProperty(
            "app.timeout.segundos",
            Integer.class,
            30
        );

        // Verifica se um profile está ativo
        boolean isProd = environment.acceptsProfiles(Profiles.of("prod"));

        // Lista todos os profiles ativos
        String[] profilesAtivos = environment.getActiveProfiles();

        // Verifica se uma propriedade existe
        boolean temSenha = environment.containsProperty("spring.datasource.password");

        log.info("Banco: {}, Porta: {}, Timeout: {}s", urlBanco, porta, timeout);
        log.info("Profiles ativos: {}", Arrays.toString(profilesAtivos));
    }
}
```

**`@Value` vs `Environment`:**

| Aspecto | `@Value` | `Environment` |
|---------|---------|---------------|
| Quando resolve | Em tempo de compilação (injeção) | Em runtime (chamada dinâmica) |
| Dinâmico | Não — fixo na injeção | Sim — pode ler qualquer propriedade a qualquer momento |
| Valor default | `@Value("${prop:default}")` | `getProperty("prop", "default")` |
| Conversão de tipo | Não — retorna String | Sim — `getProperty("prop", Integer.class)` |
| Lista propriedades | Não | Sim — `containsProperty`, `getActiveProfiles` |
| Use case | Propriedades fixas e conhecidas | Propriedades dinâmicas ou condicionais |

**Quando usar `Environment` em vez de `@Value`:**

1. **Quando o nome da propriedade é dinâmico** — você não sabe qual propriedade ler até runtime.
2. **Quando precisa verificar profiles ativos** — `acceptsProfiles` e `getActiveProfiles`.
3. **Quando precisa verificar se uma propriedade existe** — `containsProperty`.
4. **Quando precisa converter tipos** — `getProperty("prop", Integer.class)`.
5. **Quando a propriedade pode mudar durante a execução** (ex: config refresh).

**Explicação didática:**  
`@Value` é como uma etiqueta fixa colada no objeto na fábrica — o valor é definido quando o objeto é criado e não muda. `Environment` é como um terminal de consulta que você carrega no bolso — a qualquer momento, você pode digitar o nome de qualquer propriedade e receber o valor atual. Se você só precisa de uma propriedade fixa e conhecida, a etiqueta (`@Value`) é mais simples. Se precisa consultar dinamicamente, o terminal (`Environment`) é a ferramenta certa.

**Como o candidato deve responder:**  
- Explicar que `Environment` dá acesso a todas as propriedades do contexto.
- Mostrar `getProperty`, `getProperty` com default e com tipo.
- Mencionar `getActiveProfiles` e `acceptsProfiles`.
- Comparar com `@Value` e explicar quando usar cada um.
- Citar que é injetado via construtor.

**Resposta fraca ou incompleta:**  
"Environment é outra forma de ler propriedades."  
Falta: não mostra métodos, não compara com @Value, não explica quando usar.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece Environment |
| 1 | Sabe que "lê propriedades" mas não usa |
| 2 | Usa getProperty mas não conhece profiles |
| 3 | Explica getProperty, defaults, tipos e comparison com @Value |
| 4 | Demonstra getActiveProfiles, containsProperty e casos de uso |
| 5 | Responde com profundidade, menciona PropertySource, ConfigurableEnvironment e runtime changes |

**Perguntas de aprofundamento:**
1. "É possível adicionar propriedades ao Environment em runtime? Como?"
2. "Qual a relação entre Environment e PropertySource?"
3. "Como o Spring Boot decide a ordem de resolução quando a mesma propriedade existe em múltiplas fontes?"

---

### Pergunta 86 — Como você escreve testes de integração que sobem a aplicação completa com banco de dados?

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
"Para garantir que a aplicação funciona de ponta a ponta — do controller ao banco de dados — você precisa de testes de integração. Como você configura um teste que sobe o contexto completo do Spring Boot com um banco de dados real ou em memória?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe usar `@SpringBootTest` com `TestRestTemplate`, configurar H2 ou Testcontainers para testes de integração e garantir isolamento entre testes.

**Resposta esperada:**  
Testes de integração sobem o contexto completo do Spring Boot e testam o fluxo de ponta a ponta: HTTP → Controller → Service → Repository → Banco.

**1. Teste de integração com H2 em memória:**

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase  // Substitui o banco real por H2 em memória
class UsuarioIntegrationTest {

    @LocalServerPort
    private int porta;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsuarioRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();  // Limpa o banco entre testes
    }

    @Test
    void deveCriarListarEBuscarUsuario() {
        // 1. Criar usuário
        UsuarioCreateDTO createDto = new UsuarioCreateDTO(
            "João Silva", "joao@email.com", "senha123"
        );

        ResponseEntity<UsuarioResponseDTO> respostaCriacao = restTemplate.postForEntity(
            "/api/usuarios", createDto, UsuarioResponseDTO.class
        );

        assertThat(respostaCriacao.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(respostaCriacao.getHeaders().getLocation()).isNotNull();
        Long idCriado = respostaCriacao.getBody().id();
        assertThat(idCriado).isNotNull();

        // 2. Buscar por ID
        ResponseEntity<UsuarioResponseDTO> respostaBusca = restTemplate.getForEntity(
            "/api/usuarios/" + idCriado, UsuarioResponseDTO.class
        );

        assertThat(respostaBusca.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(respostaBusca.getBody().nome()).isEqualTo("João Silva");
        assertThat(respostaBusca.getBody().email()).isEqualTo("joao@email.com");

        // 3. Listar todos
        ResponseEntity<UsuarioResponseDTO[]> respostaLista = restTemplate.getForEntity(
            "/api/usuarios", UsuarioResponseDTO[].class
        );

        assertThat(respostaLista.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(respostaLista.getBody()).hasSize(1);
        assertThat(respostaLista.getBody()[0].nome()).isEqualTo("João Silva");

        // 4. Verificar no banco diretamente
        assertThat(repository.findAll()).hasSize(1);
    }

    @Test
    void deveRetornar404_QuandoUsuarioNaoExiste() {
        ResponseEntity<ErroResponse> resposta = restTemplate.getForEntity(
            "/api/usuarios/999", ErroResponse.class
        );

        assertThat(resposta.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(resposta.getBody().status()).isEqualTo(404);
        assertThat(resposta.getBody().message()).contains("999");
    }

    @Test
    void deveRetornar400_QuandoDadosInvalidos() {
        // DTO com nome vazio
        String jsonInvalido = """
            {"nome": "", "email": "joao@email.com", "senha": "12345678"}
            """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(jsonInvalido, headers);

        ResponseEntity<ErroResponse> resposta = restTemplate.postForEntity(
            "/api/usuarios", request, ErroResponse.class
        );

        assertThat(resposta.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(resposta.getBody().details()).isNotEmpty();
    }

    @Test
    void deveExcluirUsuario() {
        // Arrange — cria usuário diretamente no banco
        Usuario usuario = repository.save(new Usuario("Maria", "maria@email.com", "senha"));

        // Act
        restTemplate.delete("/api/usuarios/" + usuario.getId());

        // Assert
        assertThat(repository.findById(usuario.getId())).isEmpty();
    }
}
```

**2. Teste de integração com Testcontainers (banco real em Docker):**

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class UsuarioIntegrationWithContainerTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
        .withDatabaseName("testdb")
        .withUsername("test")
        .withPassword("test");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @LocalServerPort
    private int porta;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void deveCriarUsuarioNoPostgreSQLReal() {
        UsuarioCreateDTO dto = new UsuarioCreateDTO("João", "joao@email.com", "senha123");

        ResponseEntity<UsuarioResponseDTO> resposta = restTemplate.postForEntity(
            "/api/usuarios", dto, UsuarioResponseDTO.class
        );

        assertThat(resposta.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        // Testa contra PostgreSQL real, não H2 — garante compatibilidade
    }
}
```

**Diferenças entre H2 e Testcontainers:**

| Aspecto | H2 em memória | Testcontainers |
|---------|---------------|----------------|
| Velocidade | Muito rápido | Mais lento (sobe Docker) |
| Compatibilidade | Pode ter diferenças de SQL | Usa o banco real |
| Setup | Zero — já vem no Spring | Requer Docker na máquina |
| Confiabilidade | Bom para testes simples | Ideal para queries complexas |
| Custo | Grátis | Requer Docker |

**Explicação didática:**  
Testes com H2 são como testar um carro em um simulador — rápido e seguro, mas não captura todas as nuances da estrada real. Testes com Testcontainers são como testar o carro na pista de verdade — mais lento para preparar, mas você sabe exatamente como ele se comporta no mundo real.

**Como o candidato deve responder:**  
- Explicar `@SpringBootTest(webEnvironment = RANDOM_PORT)` com `TestRestTemplate`.
- Mencionar `@LocalServerPort` para descobrir a porta.
- Citar `@AutoConfigureTestDatabase` para H2.
- Explicar a necessidade de limpar o banco entre testes (`@BeforeEach`).
- Mencionar Testcontainers como alternativa com banco real.

**Resposta fraca ou incompleta:**  
"Eu uso @SpringBootTest e TestRestTemplate."  
Falta: não mostra limpeza entre testes, não menciona H2 nem Testcontainers, não demonstra assertions.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe fazer testes de integração |
| 1 | Menciona @SpringBootTest mas sem TestRestTemplate |
| 2 | Usa TestRestTemplate mas não limpa o banco entre testes |
| 3 | Mostra teste completo com H2, assertions e isolamento |
| 4 | Demonstra Testcontainers e @DynamicPropertySource |
| 5 | Responde com profundidade, menciona @Sql, @Transactional para rollback e trade-offs |

**Perguntas de aprofundamento:**
1. "Como você garante que um teste de integração não afeta o outro?"
2. "Quando você escolheria Testcontainers em vez de H2?"
3. "É possível usar `@Transactional` em testes de integração para fazer rollback automático? Funciona?"

---

### Pergunta 87 — O que é o CommandLineRunner e quando usá-lo?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Às vezes você precisa executar código logo após a aplicação Spring Boot iniciar — como popular o banco com dados iniciais ou verificar conectividade. Como você faz isso?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece `CommandLineRunner` e `ApplicationRunner`, sabe a diferença entre eles e entende quando usar um ou outro.

**Resposta esperada:**  
O Spring Boot oferece duas interfaces para executar código **logo após a inicialização** da aplicação: `CommandLineRunner` e `ApplicationRunner`. Ambas são chamadas após o ApplicationContext estar totalmente carregado.

**1. CommandLineRunner:**

```java
@Component
@RequiredArgsConstructor
public class InicializadorDados implements CommandLineRunner {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        // Popula o banco com dados iniciais se estiver vazio
        if (repository.count() == 0) {
            Usuario admin = new Usuario(
                "Admin",
                "admin@empresa.com",
                encoder.encode("admin123")
            );
            repository.save(admin);
            System.out.println("Usuário admin criado!");
        }
    }
}
```

Recebe os argumentos de linha de comando como `String[]`:

```java
@Component
public class ArgumentosRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Argumentos recebidos:");
        for (String arg : args) {
            System.out.println("  " + arg);
        }
    }
}
// java -jar app.jar --porta=9090 --debug
// Saída: Argumentos recebidos: --porta=9090, --debug
```

**2. ApplicationRunner:**

```java
@Component
@RequiredArgsConstructor
public class InicializadorAppRunner implements ApplicationRunner {

    private final UsuarioRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // ApplicationArguments oferece métodos estruturados
        List<String> nonOptionArgs = args.getNonOptionArgs();     // Argumentos sem --
        Set<String> optionNames = args.getOptionNames();          // Nomes das opções
        List<String> portas = args.getOptionValues("porta");      // Valores de --porta

        System.out.println("Opções: " + optionNames);
        System.out.println("Porta: " + portas);

        if (repository.count() == 0) {
            repository.save(new Usuario("Admin", "admin@empresa.com", "senha"));
        }
    }
}
```

**Diferença entre os dois:**

| Aspecto | CommandLineRunner | ApplicationRunner |
|---------|-------------------|-------------------|
| Parâmetro | `String... args` (array cru) | `ApplicationArguments` (estruturado) |
| Acesso a args | Bruto — você parseia | Estruturado — `getOptionValues`, `getNonOptionArgs` |
| Quando usar | Simples, sem necessidade de parse | Quando precisa distinguir opções de argumentos |

**3. Ordenação com `@Order`:**

```java
@Component
@Order(1)  // Executa primeiro
public class VerificarBancoRunner implements CommandLineRunner { ... }

@Component
@Order(2)  // Executa após o primeiro
public class CarregarDadosRunner implements CommandLineRunner { ... }

@Component
@Order(3)  // Executa por último
public class VerificarConexoesRunner implements CommandLineRunner { ... }
```

**4. Lambda (para runners simples):**

```java
@SpringBootApplication
public class MinhaAplicacao {
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }

    @Bean
    CommandLineRunner init(UsuarioRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Usuario("Admin", "admin@email.com", "senha"));
            }
        };
    }
}
```

**Explicação didática:**  
`CommandLineRunner` e `ApplicationRunner` são como os "funcionários de abertura" de uma loja. Eles entram **depois** que a loja está totalmente montada (ApplicationContext carregado) e fazem as tarefas de preparação: ligar as luzes, verificar o caixa, colocar produtos na prateleira. Só depois que eles terminam é que a loja abre para os clientes (a aplicação começa a receber requisições).

**Como o candidato deve responder:**  
- Explicar que executam código após a inicialização do Spring Boot.
- Mostrar `CommandLineRunner` com exemplo prático (popular banco).
- Mencionar `ApplicationRunner` como alternativa com args estruturados.
- Citar `@Order` para controle de ordem.
- Explicar que recebem argumentos de linha de comando.

**Resposta fraca ou incompleta:**  
"É uma interface que roda código no início."  
Falta: não mostra exemplo, não diferencia de ApplicationRunner, não menciona @Order.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece CommandLineRunner |
| 1 | Sabe que "roda no início" mas não implementa |
| 2 | Implementa CommandLineRunner mas não conhece ApplicationRunner |
| 3 | Explica ambos com exemplos e @Order |
| 4 | Demonstra uso com ApplicationArguments e lambda |
| 5 | Responde com profundidade, menciona ApplicationRunner vs CommandLineRunner, uso com profiles e exceções |

**Perguntas de aprofundamento:**
1. "O que acontece se o código do Runner lançar uma exceção? A aplicação continua?"
2. "Como você faria para que o Runner só execute em um profile específico?"
3. "Qual a diferença entre CommandLineRunner e @PostConstruct?"

---

### Pergunta 88 — O que é e como usar o @Conditional no Spring Boot?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Em alguns casos, você precisa que um bean seja registrado apenas se uma condição específica for atendida — uma propriedade definida, uma classe no classpath, um profile ativo. Como o Spring Boot permite esse registro condicional?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece as anotações `@Conditional*` do Spring Boot, sabe quando aplicar cada uma e entende como elas habilitam a autoconfiguração.

**Resposta esperada:**  
O Spring Boot oferece um conjunto de anotações condicionais que permitem registrar beans apenas quando condições específicas são atendidas. Isso é a base da autoconfiguração do Spring Boot.

**Principais anotações condicionais:**

| Anotação | Condição para registrar o bean |
|----------|-------------------------------|
| `@ConditionalOnClass` | A classe especificada está no classpath |
| `@ConditionalOnMissingClass` | A classe especificada NÃO está no classpath |
| `@ConditionalOnBean` | Um bean do tipo especificado já existe no contexto |
| `@ConditionalOnMissingBean` | Nenhum bean do tipo especificado existe |
| `@ConditionalOnProperty` | Uma propriedade específica tem um valor específico |
| `@ConditionalOnWebApplication` | A aplicação é do tipo web |
| `@ConditionalOnNotWebApplication` | A aplicação NÃO é do tipo web |
| `@ConditionalOnExpression` | Uma expressão SpEL é verdadeira |

**Exemplos práticos:**

```java
@Configuration
public class MinhaConfiguracao {

    // Registra apenas se a classe DataSource estiver no classpath
    @Bean
    @ConditionalOnClass(DataSource.class)
    public MeuDataSourceConfig dataSourceConfig() {
        return new MeuDataSourceConfig();
    }

    // Registra apenas se ninguém definiu um MeuService
    @Bean
    @ConditionalOnMissingBean(MeuService.class)
    public MeuService meuServiceDefault() {
        return new MeuServicePadrao();
    }

    // Registra apenas se a propriedade app.feature.avancada=true
    @Bean
    @ConditionalOnProperty(name = "app.feature.avancada", havingValue = "true")
    public FeatureAvancada featureAvancada() {
        return new FeatureAvancada();
    }

    // Registra apenas se a propriedade existe (não importa o valor)
    @Bean
    @ConditionalOnProperty("app.cache.habilitado")
    public CacheService cacheService() {
        return new CacheService();
    }

    // Registra apenas com matchIfMissing=true (default se propriedade não existir)
    @Bean
    @ConditionalOnProperty(
        name = "app.notificacao.email",
        havingValue = "true",
        matchIfMissing = true  // Se a propriedade não existir, considera true
    )
    public EmailNotificacaoService emailNotificacao() {
        return new EmailNotificacaoService();
    }

    // Registra apenas se a aplicação for web
    @Bean
    @ConditionalOnWebApplication
    public WebFilter meuFilter() {
        return new MeuFilter();
    }

    // Combina condições com @Conditional e Expression
    @Bean
    @ConditionalOnExpression(
        "${app.feature.relatorio:true} and ${app.database.tipo:postgresql} == 'postgresql'"
    )
    public RelatorioPostgresService relatorioService() {
        return new RelatorioPostgresService();
    }
}
```

**Como isso conecta com a autoconfiguração:**

```java
// Exemplo simplificado de como o Spring Boot usa @Conditional internamente
@Configuration
@ConditionalOnClass({DataSource.class, EmbeddedDatabaseType.class})
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean  // Só cria se você não definiu seu próprio DataSource
    public DataSource dataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }
}
```

O `@ConditionalOnMissingBean` é o que permite que você **sobrescreva** a autoconfiguração do Spring Boot — se você define seu próprio `DataSource`, o Spring Boot não cria o default.

**Explicação didática:**  
As anotações `@Conditional*` são como regras de admissão em um clube. O clube (ApplicationContext) só deixa entrar um novo membro (bean) se ele passa em todos os critérios: tem o uniforme certo (`@ConditionalOnClass`), ninguém com a mesma função já está no clube (`@ConditionalOnMissingBean`), o clube votou a favor (`@ConditionalOnProperty`), e o clube é do tipo certo (`@ConditionalOnWebApplication`). Se qualquer critério falhar, o candidato não entra.

**Como o candidato deve responder:**  
- Citar pelo menos três anotações: `@ConditionalOnClass`, `@ConditionalOnMissingBean`, `@ConditionalOnProperty`.
- Explicar que o bean só é registrado se a condição for atendida.
- Mencionar `matchIfMissing` em `@ConditionalOnProperty`.
- Explicar a conexão com autoconfiguração (`@ConditionalOnMissingBean` permite override).
- Mostrar exemplo prático.

**Resposta fraca ou incompleta:**  
"@Conditional registra beans condicionalmente."  
Falta: não cita anotações específicas, não mostra exemplo, não explica a relação com autoconfiguração.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece @Conditional |
| 1 | Sabe que "condiciona beans" mas não cita anotações |
| 2 | Cita @ConditionalOnProperty mas não outras |
| 3 | Explica múltiplas anotações com exemplos |
| 4 | Demonstra matchIfMissing e conexão com autoconfiguração |
| 5 | Responde com profundidade, menciona Condition customizada, @Order e @AutoConfigureBefore/After |

**Perguntas de aprofundamento:**
1. "Como você criaria uma condição customizada (sua própria anotação @Conditional)?"
2. "O que é `@ConditionalOnMissingBean` e por que é crucial para a autoconfiguração?"
3. "É possível combinar múltiplas condições? Como?"

---

### Pergunta 89 — Como você configura e usa MessageSource para internacionalização (i18n)?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Sua API precisa retornar mensagens de erro em português e inglês, dependendo do header `Accept-Language` do cliente. Como o Spring Boot suporta internacionalização de mensagens?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece `MessageSource` para i18n, sabe configurar arquivos de mensagens e entende como resolver mensagens com base no locale.

**Resposta esperada:**  
O Spring Boot oferece suporte a internacionalização (i18n) através de `MessageSource`, que carrega mensagens de arquivos `.properties` separados por idioma.

**1. Criar arquivos de mensagens:**

```
src/main/resources/
├── messages.properties          # Default (fallback)
├── messages_pt_BR.properties    # Português
└── messages_en_US.properties    # Inglês
```

```properties
# messages.properties (default)
usuario.nao_encontrado=Usuário não encontrado com id {0}
usuario.criado=Usuário criado com sucesso
validacao.obrigatorio=O campo {0} é obrigatório
validacao.tamanho=O campo {0} deve ter entre {1} e {2} caracteres
```

```properties
# messages_en_US.properties
usuario.nao_encontrado=User not found with id {0}
usuario.criado=User created successfully
validacao.obrigatorio=The field {0} is required
validacao.tamanho=The field {0} must have between {1} and {2} characters
```

**2. Configurar MessageSource:**

```java
@Configuration
public class MessageSourceConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:messages");
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(true);  // Usa a chave se não encontrar a mensagem
        return source;
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag("pt-BR"));
        resolver.setSupportedLocales(List.of(
            Locale.forLanguageTag("pt-BR"),
            Locale.forLanguageTag("en-US")
        ));
        return resolver;
    }
}
```

**3. Usar MessageSource no serviço:**

```java
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final MessageSource messageSource;

    public Usuario buscar(Long id, Locale locale) {
        return repository.findById(id).orElseThrow(() -> {
            // Busca a mensagem no idioma correto
            String mensagem = messageSource.getMessage(
                "usuario.nao_encontrado",
                new Object[]{id},  // Parâmetros para {0}
                locale
            );
            return new UsuarioNaoEncontradoException(mensagem);
        });
    }
}
```

**4. Usar no ControllerAdvice com LocaleResolver:**

```java
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> handleNaoEncontrado(
            UsuarioNaoEncontradoException ex,
            Locale locale) {  // Spring injeta o locale baseado no Accept-Language

        String mensagem = messageSource.getMessage(
            "usuario.nao_encontrado",
            new Object[]{ex.getId()},
            locale
        );

        ErroResponse erro = new ErroResponse(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Not Found",
            mensagem,
            null,
            List.of()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
```

**5. Validações com mensagens i18n:**

```java
public record UsuarioCreateDTO(
    @NotBlank(message = "{validacao.obrigatorio}")
    @Size(min = 2, max = 100, message = "{validacao.tamanho}")
    String nome,

    @NotBlank(message = "{validacao.obrigatorio}")
    @Email(message = "{usuario.email.invalido}")
    String email
) {}
```

O Spring Boot automaticamente resolve as chaves `{validacao.obrigatorio}` para o idioma correto quando o `MessageSource` está configurado.

**Explicação didática:**  
`MessageSource` é como ter um "tradutor" na aplicação. Cada idioma tem seu "dicionário" (arquivo `.properties`). Quando o cliente envia `Accept-Language: en-US`, o tradutor consulta o dicionário em inglês. Se a palavra não existe no dicionário inglês, consulta o dicionário default (fallback). Os placeholders `{0}`, `{1}` são espaços reservados que o tradutor preenche com os valores específicos (id do usuário, nome do campo, etc.).

**Como o candidato deve responder:**  
- Explicar que `MessageSource` carrega mensagens de arquivos `.properties` por idioma.
- Mostrar a configuração do bean `MessageSource` e `LocaleResolver`.
- Explicar que o locale é determinado pelo header `Accept-Language`.
- Demonstrar uso com `getMessage(chave, args, locale)`.
- Mencionar que mensagens de validação também suportam i18n.

**Resposta fraca ou incompleta:**  
"Você cria arquivos de mensagens em diferentes idiomas."  
Falta: não mostra configuração, não menciona LocaleResolver, não explica como o idioma é determinado.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece i18n no Spring |
| 1 | Sabe que "existe mensagens em outros idiomas" |
| 2 | Cria arquivos .properties mas não configura MessageSource |
| 3 | Explica configuração completa com MessageSource e LocaleResolver |
| 4 | Demonstra uso em ControllerAdvice e validações |
| 5 | Responde com profundidade, menciona fallback, UTF-8 e interceptação de locale |

**Perguntas de aprofundamento:**
1. "O que acontece se uma chave de mensagem não existe no idioma solicitado nem no default?"
2. "Como você validaria dados com mensagens i18n no `@Valid`?"
3. "É possível definir o locale por sessão em vez de por requisição? Como?"

---

### Pergunta 90 — Como você lida com migrações de banco de dados (Flyway ou Liquibase)?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot em evolução, o esquema do banco de dados muda com o tempo — novas tabelas, colunas, índices. Como você gerencia essas mudanças de forma versionada e controlada?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece ferramentas de migração de banco (Flyway ou Liquibase), sabe integrá-las com Spring Boot e entende a importância de versionar o schema.

**Resposta esperada:**  
Ferramentas de migração de banco de dados permitem **versionar e aplicar mudanças** no esquema do banco de forma controlada e reproduzível. As duas ferramentas mais populares no ecossistema Spring Boot são **Flyway** e **Liquibase**.

**1. Flyway (mais simples e direto):**

**Dependência:**
```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
<!-- Para PostgreSQL, pode ser necessário: -->
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-database-postgresql</artifactId>
</dependency>
```

**Configuração:**
```properties
# application.properties
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.baseline-on-migrate=true
```

**Estrutura de arquivos:**
```
src/main/resources/db/migration/
├── V1__criar_tabela_usuarios.sql
├── V2__adicionar_coluna_telefone.sql
├── V3__criar_tabela_pedidos.sql
├── V4__adicionar_indice_email.sql
└── V5__inserir_dados_iniciais.sql
```

**Exemplo de migration:**

```sql
-- V1__criar_tabela_usuarios.sql
CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_usuarios_email ON usuarios(email);
```

```sql
-- V2__adicionar_coluna_telefone.sql
ALTER TABLE usuarios ADD COLUMN telefone VARCHAR(20);
```

**Como funciona:**
1. Na inicialização, o Flyway verifica a tabela `flyway_schema_history` no banco.
2. Compara as migrations aplicadas com os arquivos na pasta `db/migration`.
3. Executa apenas as migrations **novas**, na ordem numérica.
4. Registra cada migration aplicada na tabela de histórico.

**2. Liquibase (mais flexível, formato independente de banco):**

**Dependência:**
```xml
<dependency>
    <groupId>org.liquibase</groupId>
    <artifactId>liquibase-core</artifactId>
</dependency>
```

**Configuração:**
```properties
spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.xml
```

**Master changelog:**
```xml
<!-- db/changelog/db.changelog-master.xml -->
<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
                   http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-latest.xsd">

    <include file="db/changelog/changes/001-criar-usuarios.xml"/>
    <include file="db/changelog/changes/002-adicionar-telefone.xml"/>
</databaseChangeLog>
```

**Exemplo de changeset:**
```xml
<!-- db/changelog/changes/001-criar-usuarios.xml -->
<databaseChangeLog>
    <changeSet id="001-criar-usuarios" author="joao">
        <createTable tableName="usuarios">
            <column name="id" type="bigint" autoIncrement="true">
                <constraints primaryKey="true" nullable="false"/>
            </column>
            <column name="nome" type="varchar(100)">
                <constraints nullable="false"/>
            </column>
            <column name="email" type="varchar(200)">
                <constraints nullable="false" unique="true"/>
            </column>
            <column name="senha" type="varchar(255)">
                <constraints nullable="false"/>
            </column>
        </createTable>
    </changeSet>
</databaseChangeLog>
```

**Comparação:**

| Aspecto | Flyway | Liquibase |
|---------|--------|-----------|
| Formato | SQL puro | XML, YAML, JSON ou SQL |
| Independência de banco | Não — SQL é específico | Sim — XML é agnóstico |
| Simplicidade | Muito simples | Mais complexo |
| Rollback | Manual (undo migrations) | Automatizado (rollback tags) |
| Versionamento | Por nome de arquivo (V1, V2...) | Por changeset ID |
| Diff de schema | Não | Sim (pode gerar changelog de diff) |
| Ideal para | Projetos com um único banco | Projetos multi-banco |

**Boas práticas:**

1. **Nunca alterar uma migration já aplicada** — crie uma nova migration para qualquer mudança.
2. **Migrations são imutáveis após aplicadas em produção** — se errou, crie uma nova que corrige.
3. **Testar migrations em staging antes de produção** — uma migration que demora pode travar a aplicação.
4. **Cuidado com migrations destrutivas** — `DROP TABLE`, `DELETE FROM` devem ser revisados.
5. **Não desativar o Flyway/Liquibase em produção** — se desativar, as migrations não são aplicadas.

**Explicação didática:**  
Migrações de banco são como o "diário de mudanças" de uma casa. Cada reforma (migration) é documentada e numerada: V1 construiu a fundação, V2 adicionou um quarto, V3 trocou o telhado. Quando você muda de casa (novo ambiente), o construtor (Flyway/Liquibase) lê o diário e aplica apenas as reformas que ainda não foram feitas naquela casa. Ninguém precisa lembrar o que já foi feito — o diário registra tudo.

**Como o candidato deve responder:**  
- Explicar que Flyway e Liquibase versionam mudanças de schema.
- Mostrar a estrutura de arquivos (V1__, V2__ para Flyway).
- Explicar o fluxo: na inicialização, aplica apenas migrations novas.
- Citar a diferença principal: Flyway usa SQL, Liquibase usa XML independente de banco.
- Mencionar boas práticas: não alterar migrations aplicadas.

**Resposta fraca ou incompleta:**  
"Eu uso Flyway para criar as tabelas."  
Falta: não explica versionamento, não mostra estrutura de arquivos, não cita boas práticas.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece migrações de banco |
| 1 | Sabe que "existe Flyway" mas não usa |
| 2 | Menciona Flyway mas sem estrutura de arquivos |
| 3 | Explica Flyway com estrutura, configuração e fluxo |
| 4 | Compara Flyway e Liquibase com prós e contras |
| 5 | Responde com profundidade, menciona baseline, rollback, repeatable migrations e CI/CD |

**Perguntas de aprofundamento:**
1. "O que acontece se uma migration falhar no meio da execução? O banco fica inconsistente?"
2. "Como você faria para que o Flyway rode apenas após o Hibernate validar o schema?"
3. "Em um pipeline de CI/CD, em qual etapa as migrations deveriam ser aplicadas?"

---

## Roteiro de Entrevista Técnica — Spring Boot

### Parte 10 de 10 — Perguntas 91 a 100 (Final)

**Foco:** Spring Boot 3.x, Jakarta EE, records, migration, performance básica, troubleshooting, cenários reais, boas práticas finais

---

### Pergunta 91 — O que mudou no Spring Boot 3.x em relação ao Spring Boot 2.x?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Se você estivesse migrando um projeto do Spring Boot 2.x para o 3.x, quais seriam as principais mudanças que você precisaria lidar?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece as principais mudanças do Spring Boot 3.x — especialmente a migração de `javax.*` para `jakarta.*`, o requisito mínimo do Java 17 e mudanças no Spring Security.

**Resposta esperada:**  
As principais mudanças do Spring Boot 3.x são:

**1. Migração de `javax.*` para `jakarta.*`:**  
A mudança mais impactante. Todo o Spring Boot 3 usa a API Jakarta EE 9+ em vez da Java EE 8. Na prática, todos os imports mudaram:

```java
// Spring Boot 2.x
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.servlet.http.HttpServletRequest;

// Spring Boot 3.x
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.servlet.http.HttpServletRequest;
```

Isso afeta **todas** as camadas: entidades JPA, validação, servlets, persistence, transaction, etc.

**2. Java 17 como versão mínima:**  
O Spring Boot 3.x exige Java 17 ou superior. Recursos do Java 17 como records, sealed classes, pattern matching e text blocks passam a ser amplamente usados.

**3. Spring Security 6:**  
A classe `WebSecurityConfigurerAdapter` foi removida. Toda a configuração é feita via `SecurityFilterChain` bean:

```java
// Spring Boot 2.x — estendendo WebSecurityConfigurerAdapter (REMOVIDO no 3.x)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests().anyRequest().authenticated();
    }
}

// Spring Boot 3.x — SecurityFilterChain com lambdas
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        return http.build();
    }
}
```

**4. `antMatchers` → `requestMatchers`:**

```java
// 2.x
http.authorizeRequests()
    .antMatchers("/api/public/**").permitAll();

// 3.x
http.authorizeHttpRequests(auth -> auth
    .requestMatchers("/api/public/**").permitAll());
```

**5. SpringDoc substitui SpringFox:**  
O SpringFox (Swagger 2) não é mais compatível. Usa-se o SpringDoc OpenAPI para documentação OpenAPI 3.

**6. Observabilidade nativa:**  
O Spring Boot 3.x introduz suporte nativo a micrometers, OpenTelemetry e observabilidade melhorada.

**Explicação didática:**  
A mudança de `javax` para `jakarta` é como uma rua que mudou de nome — todos os endereços (imports) que apontavam para a rua antiga precisam ser atualizados. O Java 17 é como uma nova versão do código de obras — a construção (aplicação) precisa seguir as novas normas. O Spring Security 6 é como uma reforma na portaria — os mesmos controles de acesso existem, mas a forma de configurar mudou completamente.

**Como o candidato deve responder:**  
- Mencionar a mudança de `javax` para `jakarta` como a principal alteração.
- Citar que Java 17 é o requisito mínimo.
- Mencionar a mudança do Spring Security (remoção do `WebSecurityConfigurerAdapter`).
- Citar `antMatchers` → `requestMatchers`.
- Se possível, mencionar a troca de SpringFox para SpringDoc.

**Resposta fraca ou incompleta:**  
"O Spring Boot 3 tem novas features."  
Falta: não menciona javax → jakarta, não cita Java 17, não fala das mudanças do Spring Security.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece as mudanças |
| 1 | Sabe que "tem mudanças" mas não especifica |
| 2 | Menciona Java 17 mas não sabe de javax → jakarta |
| 3 | Explica javax → jakarta, Java 17 e Spring Security |
| 4 | Demonstra conhecimento de requestMatchers e SpringDoc |
| 5 | Responde com profundidade, menciona observabilidade, migration guide e impactos em bibliotecas terceiras |

**Perguntas de aprofundamento:**
1. "Como você faria a migração de imports javax para jakarta de forma automatizada?"
2. "O que acontece com bibliotecas de terceiros que ainda usam javax?"
3. "Qual a diferença entre OpenAPI 3 e Swagger 2?"

---

### Pergunta 92 — Como usar Java Records como DTOs no Spring Boot?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Com o Java 17+ e o Spring Boot 3.x, os Java records se tornaram uma opção para criar DTOs. Como você usa records como DTOs em controllers e quais as vantagens?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe criar e usar records, entende que são imutáveis por design, e conhece como o Jackson os serializa/desserializa no contexto do Spring Boot.

**Resposta esperada:**  
Records são uma feature do Java (introduzida no Java 14 como preview e estabilizada no Java 16) que cria classes imutáveis com sintaxe concisa. São ideais para DTOs porque eliminam o boilerplate de getters, setters, construtores, equals, hashCode e toString.

**1. Definição de DTOs como records:**

```java
// DTO de entrada — record com validação
public record UsuarioCreateDTO(
    @NotBlank(message = "Nome é obrigatório") String nome,
    @NotBlank @Email(message = "E-mail inválido") String email,
    @NotBlank @Size(min = 8, message = "Senha mínima de 8 caracteres") String senha
) {}

// DTO de saída — record sem validação (não recebe input)
public record UsuarioResponseDTO(
    Long id,
    String nome,
    String email,
    boolean ativo,
    LocalDateTime criadoEm
) {}

// DTO de atualização — record com campos opcionais (null = não alterar)
public record UsuarioUpdateDTO(
    String nome,
    String email
) {}
```

**2. Uso em controllers:**

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(
            @Valid @RequestBody UsuarioCreateDTO dto) {
        Usuario usuario = usuarioService.criar(dto);
        UsuarioResponseDTO response = new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.isAtivo(),
            usuario.getCriadoEm()
        );
        return ResponseEntity.created(URI.create("/api/usuarios/" + usuario.getId()))
            .body(response);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscar(@PathVariable Long id) {
        Usuario u = usuarioService.buscar(id);
        return new UsuarioResponseDTO(u.getId(), u.getNome(), u.getEmail(), u.isAtivo(), u.getCriadoEm());
    }
}
```

**3. Jackson e records:**  
O Jackson (desde a versão 2.12) suporta records nativamente. Para desserialização (JSON → objeto), o Jackson usa o **construtor canônico** do record. Para serialização (objeto → JSON), ele usa os **accessors** (métodos gerados automaticamente — `nome()`, `email()`, etc., sem o prefixo `get`).

```java
// JSON recebido: {"nome": "João", "email": "joao@email.com", "senha": "12345678"}
// Jackson chama: new UsuarioCreateDTO("João", "joao@email.com", "12345678")

// JSON retornado: {"id": 1, "nome": "João", "email": "joao@email.com", "ativo": true, "criadoEm": "2024-01-15T10:30:00"}
// Jackson chama: dto.id(), dto.nome(), dto.email(), dto.ativo(), dto.criadoEm()
```

**Vantagens de records como DTOs:**
- **Imutabilidade** — não há setters, o objeto não pode ser alterado após criação.
- **Menos boilerplate** — não precisa de Lombok para DTOs simples.
- **Thread-safe** — imutáveis são naturalmente thread-safe.
- **Semântica clara** — um record comunica "sou apenas um portador de dados, não tenho lógica".

**Limitações:**
- **Não é adequado para entidades JPA** — JPA requer construtor vazio, setters e proxyabilidade; records não funcionam bem como entidades.
- **Sem herança** — records não podem estender outras classes (embora possam implementar interfaces).
- **Desserialização com múltiplos construtores** — se o record tem construtores customizados, o Jackson precisa de `@JsonCreator` para saber qual usar.

**Explicação didática:**  
Um record é como um "envelope lacrado" — você coloca os dados dentro (no construtor), lê os dados pelos acessores (`dto.nome()`), mas não pode abrir o envelope e alterar o conteúdo. Uma classe tradicional com setters é como um "envelope aberto" — qualquer um pode modificar o conteúdo a qualquer momento. Para DTOs, o envelope lacrado é mais seguro: o dado que entrou é o dado que sai, sem alterações surpresa no meio do caminho.

**Como o candidato deve responder:**  
- Explicar que records são classes imutáveis e concisas.
- Mostrar exemplo de DTO como record com validação.
- Mencionar que Jackson suporta records nativamente (Spring Boot 3.x).
- Citar vantagens: imutabilidade, menos boilerplate, thread-safe.
- Mencionar a limitação: não usar records como entidades JPA.

**Resposta fraca ou incompleta:**  
"Records são classes mais curtas."  
Falta: não explica imutabilidade, não mostra exemplo, não menciona Jackson ou limitações.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece records |
| 1 | Sabe que "são mais curtos" mas não explica |
| 2 | Mostra exemplo mas não explica imutabilidade nem Jackson |
| 3 | Explica records, imutabilidade, validação e Jackson |
| 4 | Demonstra conhecimento de limitações (JPA) e vantagens práticas |
| 5 | Responde com profundidade, menciona @JsonCreator, construtores compactos e serialização customizada |

**Perguntas de aprofundamento:**
1. "Por que records não funcionam bem como entidades JPA?"
2. "Como o Jackson sabe qual construtor usar ao desserializar um record?"
3. "É possível ter validação em records? Quais anotações funcionam?"

---

### Pergunta 93 — Cenário real: API que Cadastra usuário e Envia E-mail em Background

**Nível:** Júnior  
**Categoria:** Cenários reais

**Pergunta do entrevistador:**  
"Descreva como você implementaria o seguinte fluxo: o usuário se cadastra na API, a resposta deve retornar imediatamente com os dados do usuário, e um e-mail de boas-vindas deve ser enviado em background. Quais componentes, anotações e padrões você usaria?"

**O que essa pergunta avalia:**  
Avalia a capacidade do candidato de articular um fluxo completo combinando múltiplos recursos do Spring Boot — controller, service, DTO, validação, @Async, events e tratamento de erros — em um cenário real.

**Resposta esperada:**  

**Arquitetura do fluxo:**

1. Controller recebe requisição POST com `@Valid @RequestBody`
2. Service cria o usuário no banco (com `@Transactional`)
3. Service publica um evento `UsuarioCriadoEvent`
4. Listener recebe o evento e envia e-mail de forma assíncrona (`@Async`)
5. Controller retorna 201 Created imediatamente, sem esperar o e-mail

**1. DTO de entrada e saída:**

```java
public record UsuarioCreateDTO(
    @NotBlank String nome,
    @NotBlank @Email String email,
    @NotBlank @Size(min = 8) String senha
) {}

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String email,
    boolean ativo,
    LocalDateTime criadoEm
) {}
```

**2. Evento:**

```java
public record UsuarioCriadoEvent(
    Long id,
    String nome,
    String email,
    LocalDateTime criadoEm
) {}
```

**3. Service:**

```java
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public UsuarioResponseDTO criar(UsuarioCreateDTO dto) {
        // Verifica e-mail duplicado
        if (repository.existsByEmail(dto.email())) {
            throw new EmailDuplicadoException(dto.email());
        }

        // Cria e salva
        Usuario usuario = new Usuario(dto.nome(), dto.email(), dto.senha());
        repository.save(usuario);

        // Publica evento — não bloqueia
        eventPublisher.publishEvent(new UsuarioCriadoEvent(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getCriadoEm()
        ));

        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.isAtivo(),
            usuario.getCriadoEm()
        );
    }
}
```

**4. Listener assíncrono:**

```java
@Component
@RequiredArgsConstructor
@Slf4j
public class UsuarioCriadoListener {

    private final EmailService emailService;

    @Async
    @EventListener
    public void onUsuarioCriado(UsuarioCriadoEvent event) {
        try {
            emailService.enviarBoasVindas(event.email(), event.nome());
            log.info("E-mail de boas-vindas enviado para {}", event.email());
        } catch (Exception e) {
            log.error("Erro ao enviar e-mail para {}: {}", event.email(), e.getMessage(), e);
            // Não propaga o erro — o cadastro já foi feito com sucesso
        }
    }
}
```

**5. Controller:**

```java
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(
            @Valid @RequestBody UsuarioCreateDTO dto) {
        UsuarioResponseDTO response = service.criar(dto);
        return ResponseEntity
            .created(URI.create("/api/usuarios/" + response.id()))
            .body(response);
    }
}
```

**6. Tratamento de erros:**

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<ErroDTO> handleEmailDuplicado(EmailDuplicadoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(new ErroDTO("EMAIL_DUPLICADO", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidacao(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
            .forEach(e -> erros.put(e.getField(), e.getDefaultMessage()));
        return ResponseEntity.badRequest().body(erros);
    }
}
```

**Decisões técnicas explicadas:**

| Decisão | Justificativa |
|---------|---------------|
| Event em vez de chamada direta | Desacopla o service do e-mail — se o e-mail falha, o cadastro não falha |
| @Async no listener | O e-mail é enviado em background, não bloqueia a resposta |
| @Transactional no service | Garante que o save seja atômico — ou salva tudo ou nada |
| try-catch no listener | Se o e-mail falha, loga o erro mas não quebra o cadastro |
| 201 Created + Location | Segue a convenção REST para criação de recurso |

**Explicação didática:**  
Esse fluxo é como uma recepção de hotel. O hóspede chega (requisição), a recepção faz o check-in rapidamente (salva no banco) e entrega a chave (retorna 201). Separadamente, o hotel envia um e-mail de boas-vindas (evento assíncrono) — o hóspede não precisa ficar esperando na recepção até o e-mail ser enviado para receber a chave.

**Como o candidato deve responder:**  
- Descrever o fluxo passo a passo: controller → service → evento → listener → e-mail.
- Mencionar `@Transactional` no service para garantir atomicidade.
- Mencionar `ApplicationEventPublisher` + `@EventListener` para desacoplamento.
- Mencionar `@Async` no listener para execução em background.
- Explicar o tratamento de erro: se o e-mail falha, o cadastro não é desfeito.
- Citar os status HTTP: 201 para sucesso, 409 para e-mail duplicado, 400 para validação.

**Resposta fraca ou incompleta:**  
"Eu criaria um método que salva e depois chama o emailService."  
Falta: não menciona evento, não usa @Async, não desacopla, não trata erro do e-mail.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não consegue descrever o fluxo |
| 1 | Descreve o básico mas sem desacoplamento ou assincronicidade |
| 2 | Usa @Async mas chama emailService diretamente (sem evento) |
| 3 | Descreve o fluxo completo com evento, @Async e tratamento de erro |
| 4 | Justifica cada decisão técnica e menciona status HTTP corretos |
| 5 | Responde com profundidade, menciona @TransactionalEventListener, idempotência do e-mail e retry |

**Perguntas de aprofundamento:**
1. "O que aconteceria se o servidor caísse entre o save e o envio do e-mail? Como você garantiria que o e-mail fosse enviado?"
2. "Por que usar @TransactionalEventListener em vez de @EventListener neste caso?"
3. "Como você evitaría enviar e-mails duplicados se o usuário clicar em 'cadastrar' duas vezes rápido?"

---

### Pergunta 94 — Cenário real: API com Paginação, Filtro e Ordenação

**Nível:** Júnior  
**Categoria:** Cenários reais

**Pergunta do entrevistador:**  
"Você precisa criar um endpoint de listagem de usuários que suporte paginação, filtro por nome e ordenação por qualquer campo. Como você implementaria isso no Spring Boot?"

**O que essa pergunta avalia:**  
Avalia se o candidato consegue combinar `Pageable`, `@RequestParam` e Spring Data JPA para criar um endpoint de listação flexível e bem estruturado.

**Resposta esperada:**  

**1. Controller:**

```java
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho,
            @RequestParam(defaultValue = "nome") String ordenacao,
            @RequestParam(defaultValue = "asc") String direcao) {

        Pageable pageable = PageRequest.of(
            pagina,
            tamanho,
            Sort.by(Sort.Direction.fromString(direcao), ordenacao)
        );

        Page<UsuarioResponseDTO> resultado = service.listar(nome, pageable);
        return ResponseEntity.ok(resultado);
    }
}
```

**2. Service:**

```java
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Page<UsuarioResponseDTO> listar(String nome, Pageable pageable) {
        if (nome != null && !nome.isBlank()) {
            // Com filtro
            Page<Usuario> usuarios = repository.findByNomeContainingIgnoreCase(nome, pageable);
            return usuarios.map(this::toResponse);
        }
        // Sem filtro
        return repository.findAll(pageable).map(this::toResponse);
    }

    private UsuarioResponseDTO toResponse(Usuario u) {
        return new UsuarioResponseDTO(u.getId(), u.getNome(), u.getEmail(), u.isAtivo(), u.getCriadoEm());
    }
}
```

**3. Repository:**

```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Query method com paginação e filtro
    Page<Usuario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    // Alternativa com @Query para filtro mais complexo
    @Query("SELECT u FROM Usuario u WHERE LOWER(u.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    Page<Usuario> buscarPorNome(@Param("nome") String nome, Pageable pageable);
}
```

**4. Resposta JSON gerada:**  
O Spring Data retorna um objeto `Page<T>` que é serializado como:

```json
{
    "content": [
        {"id": 1, "nome": "João", "email": "joao@email.com", "ativo": true},
        {"id": 2, "nome": "Maria", "email": "maria@email.com", "ativo": true}
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {"sorted": true, "direction": "ASC", "property": "nome"}
    },
    "totalElements": 42,
    "totalPages": 5,
    "number": 0,
    "size": 10,
    "first": true,
    "last": false,
    "empty": false
}
```

**5. Simplificação com `Pageable` direto no controller:**

```java
@GetMapping
public Page<UsuarioResponseDTO> listar(
        @RequestParam(required = false) String nome,
        // Spring resolve automaticamente os parâmetros page, size e sort
        Pageable pageable) {

    return service.listar(nome, pageable);
}
```

Com isso, o cliente chama:

```
GET /api/usuarios?nome=João&page=0&size=10&sort=nome,asc
```

E o Spring constrói o `Pageable` automaticamente.

**Explicação didática:**  
A paginação é como folhear um livro de catálogo. O cliente diz "quero ver a página 2, com 10 itens por página, ordenados por nome" (`?page=1&size=10&sort=nome,asc`). O Spring Data busca exatamente isso no banco (com `LIMIT` e `OFFSET` no SQL) e devolve a página com metadados: total de páginas, total de elementos, se é a primeira/última página, etc.

**Como o candidato deve responder:**  
- Explicar o uso de `Pageable` e `PageRequest`.
- Mostrar query method com filtro e paginação.
- Mencionar que `Page<T>` retorna metadados (totalElements, totalPages, etc.).
- Citar `Sort` para ordenação.
- Se possível, mencionar que o Spring pode resolver `Pageable` diretamente no parâmetro do controller.

**Resposta fraca ou incompleta:**  
"Eu usaria `findAll()` e filtrava no código."  
Falta: não usa paginação no banco, não conhece Pageable, carrega todos os registros na memória.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece paginação no Spring Data |
| 1 | Sabe que "existe paginação" mas não implementa |
| 2 | Usa Pageable mas sem filtro ou ordenação |
| 3 | Implementa paginação, filtro e ordenação com exemplo |
| 4 | Demonstra Page<T> com metadados e Pageable direto no controller |
| 5 | Responde com profundidade, menciona @Param sort múltiplo, DTO mapping e performance |

**Perguntas de aprofundamento:**
1. "Como você permitiria ordenação por múltiplos campos ao mesmo tempo?"
2. "Qual a diferença entre `Page<T>` e `Slice<T>` no Spring Data?"
3. "Como você personalizaria o JSON de resposta para não incluir todos os metadados do Page?"

---

### Pergunta 95 — Como diagnosticar e resolver um erro de "Bean não encontrado" no Spring Boot?

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
"Você sobe sua aplicação Spring Boot e vê o erro: `NoSuchBeanDefinitionException: No qualifying bean of type 'UsuarioService'`. Quais são as causas mais comuns e como você investiga?"

**O que essa pergunta avalia:**  
Avalia a capacidade do candidato de diagnosticar um dos erros mais comuns do Spring Boot — um bean que não foi encontrado pelo container — e conhecer as causas típicas.

**Resposta esperada:**  

**Causa 1 — Classe sem estereótipo:**

```java
// ERRO — classe sem anotação, Spring não a registra como bean
public class UsuarioService {
    // ...
}

// CORRETO — anotação @Service (ou @Component) registra a classe como bean
@Service
public class UsuarioService {
    // ...
}
```

**Causa 2 — Classe fora do pacote de component scan:**

```
com.empresa.projeto
├── MinhaAplicacao.java          ← @SpringBootApplication está aqui
├── controller/
│   └── UsuarioController.java   ← Escaneado ✓
├── service/
│   └── UsuarioService.java       ← Escaneado ✓
└── config/                       ← Escaneado ✓
```

Mas se a classe principal estiver em `com.empresa.projeto.config`:

```
com.empresa.projeto
├── controller/
│   └── UsuarioController.java   ← NÃO escaneado ✗ (pacote acima da classe principal)
└── config/
    ├── MinhaAplicacao.java      ← @SpringBootApplication está aqui
    └── service/
        └── UsuarioService.java   ← Escaneado ✓ (subpacote de config)
```

**Solução:** mover a classe principal para o pacote raiz ou configurar explicitamente:

```java
@SpringBootApplication(scanBasePackages = "com.empresa.projeto")
public class MinhaAplicacao { ... }
```

**Causa 3 — Interface sem implementação:**

```java
// Spring precisa de uma implementação concreta para instanciar
public interface UsuarioService {
    Usuario buscar(Long id);
}

// Se nenhuma classe @Service implementa UsuarioService, o Spring não encontra
@Service
public class UsuarioServiceImpl implements UsuarioService {
    public Usuario buscar(Long id) { ... }
}
```

**Causa 4 — Conflito de configuração:**

```java
// Se você excluiu a autoconfiguração do JPA mas espera o repository como bean
@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class  // Remove o DataSource
})
public class MinhaAplicacao { ... }

// UsuarioRepository precisa de JPA configurado — sem DataSource, não funciona
```

**Como investigar:**

1. **Verificar a anotação** — a classe tem `@Service`, `@Component`, `@Repository`, `@Controller` ou `@Configuration` + `@Bean`?
2. **Verificar o pacote** — a classe está em um subpacote da classe `@SpringBootApplication`?
3. **Ativar debug de autoconfiguração:**

```properties
logging.level.org.springframework=DEBUG
```

4. **Usar Actuator para ver beans registrados:**

```properties
management.endpoints.web.exposure.include=beans
```

Acessar `http://localhost:8080/actuator/beans` para ver todos os beans.

5. **Verificar se há implementação** — se é uma interface, existe uma classe concreta anotada?

**Explicação didática:**  
O erro "bean não encontrado" é como chegar num restaurante e pedir um prato que não está no cardápio. As causas mais comuns: (1) o prato existe mas o garçom não anotou (classe sem anotação), (2) o cozinheiro está numa cozinha que o garçom não atende (pacote fora do scan), ou (3) o prato é apenas uma ideia na cabeça do chef sem receita concreta (interface sem implementação).

**Como o candidato deve responder:**  
- Mencionar as causas mais comuns: classe sem anotação, pacote fora do scan, interface sem implementação.
- Explicar a importância do pacote raiz da classe `@SpringBootApplication`.
- Citar como investigar: debug de logging e Actuator `/actuator/beans`.
- Mencionar `scanBasePackages` como solução para pacotes customizados.

**Resposta fraca ou incompleta:**  
"Falta colocar @Autowired."  
Falta: não identifica as causas reais, não explica component scan, não mostra como investigar.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe diagnosticar |
| 1 | Suggests "adicionar @Autowired" (incorreto) |
| 2 | Menciona anotação mas não fala de pacote |
| 3 | Cita anotação, pacote e implementação |
| 4 | Demonstra uso de debug e Actuator para investigar |
| 5 | Responde com profundidade, menciona @ComponentScan, exclusões e conditional beans |

**Perguntas de aprofundamento:**
1. "Como você listaria todos os beans registrados no contexto sem usar Actuator?"
2. "O que acontece se duas classes implementam a mesma interface e ambas têm @Service?"
3. "Como o `@ConditionalOnMissingBean` pode causar esse erro?"

---

### Pergunta 96 — Cenário real: Consumo de API Externa com Retry e Tratamento de Erro

**Nível:** Júnior  
**Categoria:** Cenários reais

**Pergunta do entrevistador:**  
"Sua aplicação precisa consultar uma API externa de pagamentos. Essa API às vezes falha ou demora. Como você implementa o consumo de forma resiliente, com retry e tratamento adequado de erros?"

**O que essa pergunta avalia:**  
Avalia se o candidato consegue arquitetar um cliente de API externa que lida com falhas transitórias, timeouts e retentativas, usando boas práticas do Spring Boot.

**Resposta esperada:**  

**1. Cliente com RestClient e tratamento de erro:**

```java
@Component
@Slf4j
public class PagamentoClient {

    private final RestClient restClient;

    public PagamentoClient() {
        this.restClient = RestClient.builder()
            .baseUrl("https://api.pagamento.com/v1")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .requestFactory(clientHttpRequestFactory())  // Timeout configurado
            .build();
    }

    // Configuração de timeout
    private ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(Duration.ofSeconds(5));   // Tempo de conexão
        factory.setReadTimeout(Duration.ofSeconds(10));     // Tempo de resposta
        return factory;
    }

    public PagamentoResponse processar(PagamentoRequest request) {
        try {
            return restClient.post()
                .uri("/pagamentos")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + obterToken())
                .body(request)
                .retrieve()
                .onStatus(s -> s.is4xxClientError(), (req, res) -> {
                    throw new PagamentoInvalidoException("Requisição inválida para API de pagamento");
                })
                .onStatus(s -> s.is5xxServerError(), (req, res) -> {
                    throw new PagamentoIndisponivelException("API de pagamento indisponível");
                })
                .body(PagamentoResponse.class);

        } catch (PagamentoInvalidoException e) {
            // Erro 4xx — não retentar, é erro do cliente
            log.error("Erro de validação no pagamento: {}", e.getMessage());
            throw e;

        } catch (PagamentoIndisponivelException e) {
            // Erro 5xx — retentar (transitório)
            log.warn("API de pagamento indisponível, tentando novamente...");
            return retryProcessar(request, 3);

        } catch (ResourceAccessException e) {
            // Timeout ou conexão recusada — retentar
            log.warn("Timeout na API de pagamento: {}", e.getMessage());
            return retryProcessar(request, 3);
        }
    }

    // Retry manual com backoff exponencial
    private PagamentoResponse retryProcessar(PagamentoRequest request, int tentativas) {
        for (int i = 1; i <= tentativas; i++) {
            try {
                Thread.sleep(1000L * i);  // Backoff: 1s, 2s, 3s
                return restClient.post()
                    .uri("/pagamentos")
                    .body(request)
                    .retrieve()
                    .body(PagamentoResponse.class);
            } catch (PagamentoIndisponivelException | ResourceAccessException e) {
                if (i == tentativas) {
                    log.error("Falha definitiva após {} tentativas", tentativas);
                    throw new PagamentoIndisponivelException("API indisponível após retentativas");
                }
                log.warn("Tentativa {}/{} falhou", i, tentativas);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrompida durante retry", e);
            }
        }
        throw new PagamentoIndisponivelException("Não foi possível processar o pagamento");
    }
}
```

**2. Alternativa com Spring Retry (mais elegante):**

```xml
<!-- Adicionar dependência -->
<dependency>
    <groupId>org.springframework.retry</groupId>
    <artifactId>spring-retry</artifactId>
</dependency>
```

```java
@SpringBootApplication
@EnableRetry  // Habilita Spring Retry
public class MinhaAplicacao { ... }

@Component
@Slf4j
public class PagamentoClient {

    @Retryable(
        value = {PagamentoIndisponivelException.class, ResourceAccessException.class},
        maxAttempts = 3,
        backoff = @Backoff(delay = 1000, multiplier = 2.0)
    )
    public PagamentoResponse processar(PagamentoRequest request) {
        // Chamada à API — se falhar com as exceções acima, retenta automaticamente
        return restClient.post()
            .uri("/pagamentos")
            .body(request)
            .retrieve()
            .body(PagamentoResponse.class);
    }

    // Executado quando todas as retentativas falham
    @Recover
    public PagamentoResponse recover(PagamentoIndisponivelException e, PagamentoRequest request) {
        log.error("Todas as tentativas falharam para o pagamento. Acionando fila.");
        // Enviar para uma fila de pagamento assíncrono (DLQ)
        pagamentoQueueService.enviarParaFila(request);
        throw new PagamentoIndisponivelException("Pagamento enviado para fila de retentativa manual");
    }
}
```

**Decisões importantes:**

| Situação | Ação | Motivo |
|----------|------|--------|
| Erro 4xx (400, 401, 403) | Não retentar | Erro do cliente, não vai mudar |
| Erro 5xx (500, 502, 503) | Retentar | Falha transitória do servidor |
| Timeout | Retentar | Pode ser temporário |
| Após todas retentativas | Fallback (fila, log, alerta) | Não deixa o usuário sem resposta |

**Explicação didática:**  
Consumir uma API externa é como ligar para um restaurante. Se o número está errado (4xx), adicionar mais tentativas não ajuda — o problema é seu. Se o telefone está ocupado (5xx) ou ninguém atende (timeout), tentar de novo mais tarde pode funcionar. Mas se você tenta 3 vezes e nada, em vez de ficar ligando eternamente, você anota o pedido e resolve depois (fallback para fila).

**Como o candidato deve responder:**  
- Explicar que erros 4xx não devem ser retentados (erro do cliente).
- Explicar que erros 5xx e timeout são falhas transitórias que justificam retry.
- Mencionar backoff exponencial (esperar mais a cada tentativa).
- Propor um fallback após falha definitiva (fila, log, alerta).
- Se possível, citar Spring Retry como alternativa ao retry manual.

**Resposta fraca ou incompleta:**  
"Eu colocaria um try-catch e tentava de novo."  
Falta: não diferencia tipos de erro, não usa backoff, não tem fallback, não menciona timeout.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe tratar erros de API externa |
| 1 | Usa try-catch genérico sem diferenciar erros |
| 2 | Diferencia 4xx de 5xx mas sem retry ou backoff |
| 3 | Implementa retry com backoff e tratamento diferenciado |
| 4 | Demonstra Spring Retry e fallback após falha definitiva |
| 5 | Responde com profundidade, menciona circuit breaker (Resilience4j), idempotência e DLQ |

**Perguntas de aprofundamento:**
1. "O que é backoff exponencial e por que usá-lo em vez de intervalos fixos?"
2. "O que é um circuit breaker e como ele se diferencia de retry?"
3. "Como você garantiria idempotência no pagamento para que o retry não crie pagamentos duplicados?"

---

### Pergunta 97 — Quais são as boas práticas de estrutura de pacotes em um projeto Spring Boot?

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
"Quando você começa um novo projeto Spring Boot, como você organiza a estrutura de pacotes? Quais critérios você usa para separar as classes?"

**O que essa pergunta avalia:**  
Avalia se o candidato segue uma organização de pacotes lógica e sustentável, e conhece os padrões mais usados (por camada vs. por feature).

**Resposta esperada:**  
Existem duas abordagens principais para organizar pacotes:

**1. Por camada (layer-based) — mais comum em projetos pequenos/médios:**

```
com.empresa.projeto
├── MinhaAplicacao.java
├── controller/
│   ├── UsuarioController.java
│   └── PedidoController.java
├── service/
│   ├── UsuarioService.java
│   └── PedidoService.java
├── repository/
│   ├── UsuarioRepository.java
│   └── PedidoRepository.java
├── model/
│   ├── entity/
│   │   ├── Usuario.java
│   │   └── Pedido.java
│   └── dto/
│       ├── UsuarioCreateDTO.java
│       ├── UsuarioResponseDTO.java
│       └── PedidoDTO.java
├── exception/
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
├── config/
│   ├── SecurityConfig.java
│   └── OpenApiConfig.java
└── util/
    └── CpfValidator.java
```

**2. Por feature (feature-based) — mais comum em projetos médios/grandes:**

```
com.empresa.projeto
├── MinhaAplicacao.java
├── usuario/
│   ├── UsuarioController.java
│   ├── UsuarioService.java
│   ├── UsuarioRepository.java
│   ├── Usuario.java              (entidade)
│   ├── UsuarioCreateDTO.java
│   ├── UsuarioResponseDTO.java
│   └── UsuarioNaoEncontradoException.java
├── pedido/
│   ├── PedidoController.java
│   ├── PedidoService.java
│   ├── PedidoRepository.java
│   ├── Pedido.java
│   ├── PedidoDTO.java
│   └── PedidoServiceException.java
├── config/
│   ├── SecurityConfig.java
│   └── OpenApiConfig.java
└── exception/
    └── GlobalExceptionHandler.java
```

**Comparação:**

| Critério | Por camada | Por feature |
|----------|-----------|------------|
| Organização | Por tipo de classe | Por domínio de negócio |
| Vantagem | Fácil de entender no início | Melhor coesão, menos acoplamento |
| Desvantagem | Mudar uma feature afeta muitos pacotes | Pacote maior, mais classes no mesmo lugar |
| Ideal para | Projetos pequenos, CRUDs | Projetos médios/grandes, microsserviços |

**Boas práticas independentes da abordagem:**

1. **Classe principal no pacote raiz** — para que `@ComponentScan` encontre todos os subpacotes.
2. **Nomenclatura consistente** — `UsuarioController`, `UsuarioService`, `UsuarioRepository` deixa claro qual é a responsabilidade.
3. **Separar DTOs de entidades** — nunca usar a entidade JPA como resposta de API.
4. **Configurações isoladas** — todas as classes `@Configuration` em um pacote `config`.
5. **Exceptions em pacote próprio** — centraliza o tratamento e as classes de exceção.
6. **Não usar pacote `util` como depósito** — se a classe tem um domínio, coloque-a no pacote do domínio.

**Explicação didática:**  
Organizar por camada é como organizar uma biblioteca por tipo de material (livros aqui, revistas ali, CDs acolá). Organizar por feature é como organizar por assunto (tudo sobre "usuários" junto, tudo sobre "pedidos" junto). A primeira é mais intuitiva para começar; a segunda é mais sustentável quando o projeto cresce, porque tudo relacionado a uma feature está em um só lugar — você não precisa "navegar" entre pacotes para mudar uma regra de negócio.

**Como o candidato deve responder:**  
- Apresentar pelo menos uma das abordagens com exemplo de árvore de pacotes.
- Explicar o critério de organização (por tipo vs. por domínio).
- Mencionar que a classe `@SpringBootApplication` deve estar no pacote raiz.
- Citar boas práticas: separar DTOs de entidades, isolar configurações.
- Se possível, comparar as duas abordagens e quando usar cada uma.

**Resposta fraca ou incompleta:**  
"Eu coloco tudo em um pacote só."  
Falta: não separa por camada ou feature, não justifica, não segue boas práticas.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não tem organização |
| 1 | Sabe que "separa por camada" mas não justifica |
| 2 | Mostra estrutura por camada mas sem separar DTOs |
| 3 | Apresenta estrutura organizada com boas práticas |
| 4 | Compara as duas abordagens e sabe quando usar cada uma |
| 5 | Responde com profundidade, menciona coesão/acoplamento, DDD e modularização |

**Perguntas de aprofundamento:**
1. "Em um microsserviço com 5 domínios, qual abordagem você usaria?"
2. "Como você organizaria os testes em relação à estrutura de pacotes?"
3. "O que é modularização no Spring Boot e como se relaciona com a estrutura de pacotes?"

---

### Pergunta 98 — Como você garante que uma aplicação Spring Boot está pronta para produção?

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
"Liste as principais ações que você tomaria para garantir que uma aplicação Spring Boot está pronta para ir para produção."

**O que essa pergunta avalia:**  
Avalia a visão geral do candidato sobre os aspectos de produção: configuração externalizada, health checks, logging, segurança, monitoramento e boas práticas de deployment.

**Resposta esperada:**  

**1. Configuração externalizada:**

```properties
# NÃO usar valores hardcoded — usar variáveis de ambiente
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=validate  # NUNCA usar create-drop em produção
```

**2. Actuator para health checks:**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

```properties
management.endpoints.web.exposure.include=health,info,metrics,prometheus
management.endpoint.health.show-details=when-authorized
```

**3. Logging adequado:**

```properties
logging.level.root=WARN
logging.level.com.empresa.projeto=INFO
logging.file.name=logs/aplicacao.log
# NÃO logar dados sensíveis (senhas, tokens, CPFs)
```

**4. Segurança:**

- Remover o usuário padrão do Spring Security (`user`/senha aleatória).
- Configurar autenticação adequada (JWT, OAuth2, LDAP).
- Desabilitar Swagger em produção (ou proteger com credenciais).
- Habilitar HTTPS.
- Validar todos os inputs.

```java
@Profile("!prod")
public class OpenApiConfig {
    // Swagger só disponível fora de produção
}
```

**5. Connection pool:**

```properties
spring.datasource.hikari.maximum-pool-size=20
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.idle-timeout=600000
```

**6. Variáveis de ambiente e profiles:**

- Usar `SPRING_PROFILES_ACTIVE=prod` em produção.
- Nunca commitar senhas ou secrets no `application.properties`.

**7. Graceful shutdown:**

```properties
server.shutdown=graceful
spring.lifecycle.timeout-per-shutdown-phase=30s
```

**8. JVM tuning:**

```bash
java -Xms512m -Xmx1024m \
     -XX:+UseG1GC \
     -XX:MaxGCPauseMillis=200 \
     -jar aplicacao.jar
```

**9. Migrations de banco:**

- Usar Flyway ou Liquibase para versionar mudanças de schema.
- Nunca depender de `hibernate.hbm2ddl.auto=create/update` em produção.

**10. Testes:**

- Garantir que testes de integração passam.
- Ter cobertura mínima de testes unitários.

**Checklist resumido:**

| Item | Status |
|------|--------|
| Configuração externalizada | ✅ |
| Actuator habilitado | ✅ |
| Logs em arquivo com nível apropriado | ✅ |
| Spring Security configurado (não padrão) | ✅ |
| HTTPS habilitado | ✅ |
| Swagger protegido ou desabilitado | ✅ |
| Connection pool configurado | ✅ |
| Profile de produção ativo | ✅ |
| Graceful shutdown | ✅ |
| Flyway/Liquibase em vez de ddl-auto | ✅ |

**Explicação didática:**  
Preparar para produção é como preparar um carro para uma viagem longa. Você não verifica só o motor (código) — também verifica os pneus (banco), o combustível (configuração), o GPS (monitoramento), o cinto de segurança (segurança) e o estepe (fallback). Cada item separado parece pequeno, mas juntos garantem que a viagem não termine no meio do caminho.

**Como o candidato deve responder:**  
- Citar pelo menos 5 dos 10 itens acima.
- Mencionar externalização de configuração (variáveis de ambiente).
- Citar Actuator para health checks.
- Mencionar segurança (remover padrão, HTTPS, proteger Swagger).
- Mencionar Flyway/Liquibase em vez de `ddl-auto=create`.

**Resposta fraca ou incompleta:**  
"Eu testaria a aplicação e faria deploy."  
Falta: não menciona configuração externalizada, Actuator, segurança, logging ou migrations.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é readiness |
| 1 | Menciona apenas "testar" |
| 2 | Cita 2-3 itens (ex: Actuator, Flyway) |
| 3 | Cita 5+ itens com justificativa |
| 4 | Demonstra checklist completo com exemplos de configuração |
| 5 | Responde com profundidade, menciona graceful shutdown, JVM tuning, métricas e Prometheus |

**Perguntas de aprofundamento:**
1. "O que é graceful shutdown e por que é importante?"
2. "Como você monitoraria a aplicação em produção? Quais métricas seriam importantes?"
3. "Por que `ddl-auto=create` é perigoso em produção? O que pode acontecer?"

---

### Pergunta 99 — Como você debuga uma aplicação Spring Boot que está lenta?

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
"Usuários reclamam que sua API Spring Boot está demorando 10 segundos para responder. Quais passos você seguiria para identificar e resolver o problema?"

**O que essa pergunta avalia:**  
Avalia a capacidade do candidato de articular um processo de diagnóstico metodico para problemas de performance, começando pelo sintoma e afunilando até a causa raiz.

**Resposta esperada:**  

**Passo 1 — Identificar qual endpoint está lento:**

```properties
# Logar tempo de cada requisição
logging.level.org.springframework.web.servlet.DispatcherServlet=DEBUG
management.endpoints.web.exposure.include=metrics,http-server-requests
```

Ou usar um filter para medir tempo:

```java
@Component
@Slf4j
public class TimingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        long inicio = System.currentTimeMillis();
        chain.doFilter(req, res);
        long duracao = System.currentTimeMillis() - inicio;

        HttpServletRequest httpReq = (HttpServletRequest) req;
        log.info("{} {} levou {}ms", httpReq.getMethod(), httpReq.getRequestURI(), duracao);
    }
}
```

**Passo 2 — Verificar queries SQL:**

```properties
# Ativar log de queries com tempo de execução
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.orm.jdbc.bind=TRACE
# Logar query lenta (> 1000ms)
logging.level.org.hibernate.stat=DEBUG
spring.jpa.properties.hibernate.session.events.log.LOG_QUERIES_SLOWER_THAN_MS=1000
```

Problemas comuns:
- **N+1 queries** — um `SELECT` por item de uma lista.
- **Falta de índice** — `SELECT * FROM usuario WHERE email = ?` sem índice na coluna email.
- **Carregamento eager de relacionamentos** — `@OneToMany(fetch = FetchType.EAGER)` carregando milhares de registros.

**Passo 3 — Verificar connection pool:**

```properties
logging.level.com.zaxxer.hikari=DEBUG
```

Se o pool está esgotado, requisições ficam esperando por conexões.

**Passo 4 — Verificar uso de memória:**

- Usar Actuator para ver métricas de JVM:

```properties
management.endpoints.web.exposure.include=metrics
```

Acessar `http://localhost:8080/actuator/metrics/jvm.memory.used`.

- Se houver `OutOfMemoryError`, pode haver memory leak ou carregamento de grandes volumes na memória.

**Passo 5 — Verificar chamadas externas:**

- Uma API externa lenta pode ser o gargalo.
- Logar o tempo de cada chamada externa:

```java
@Slf4j
public class PagamentoClient {

    public PagamentoResponse processar(PagamentoRequest req) {
        long inicio = System.currentTimeMillis();
        PagamentoResponse response = restClient.post()
            .uri("/pagamentos")
            .body(req)
            .retrieve()
            .body(PagamentoResponse.class);
        log.info("Chamada à API de pagamento levou {}ms", System.currentTimeMillis() - inicio);
        return response;
    }
}
```

**Passo 6 — Verificar threads bloqueadas:**

```properties
management.endpoints.web.exposure.include=threaddump
```

Acessar `http://localhost:8080/actuator/threaddump` para ver threads em BLOCKED ou WAITING.

**Resumo do processo de diagnóstico:**

| Passo | O que verificar | Como |
|-------|-----------------|------|
| 1 | Qual endpoint está lento | TimingFilter ou métricas |
| 2 | Queries SQL | Log de Hibernate, N+1 |
| 3 | Connection pool | Log do HikariCP |
| 4 | Memória | Actuator metrics JVM |
| 5 | APIs externas | Log de tempo por chamada |
| 6 | Threads bloqueadas | Actuator threaddump |

**Explicação didática:**  
Diagnosticar lentidão é como encontrar um gargalo no trânsito. Primeiro você identifica qual rua está lenta (endpoint). Depois verifica se é um semáforo quebrado (query sem índice), um congestionamento na entrada (pool esgotado), um acidente mais à frente (API externa lenta), ou um carro parado (thread bloqueada). Cada ferramenta (logs, Actuator, metrics) é uma câmera de monitoramento que ajuda a ver onde está o problema.

**Como o candidato deve responder:**  
- Começar identificando qual endpoint está lento (não adivinhar).
- Verificar queries SQL (N+1, falta de índice, eager loading).
- Verificar connection pool.
- Verificar chamadas a APIs externas.
- Mencionar Actuator para métricas e threaddump.
- Seguir um processo metodico, não aleatório.

**Resposta fraca ou incompleta:**  
"Eu aumentaria a memória do servidor."  
Falta: não investiga a causa, não segue processo, tenta "chutar" a solução.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe diagnosticar |
| 1 | Suggests "aumentar memória" sem investigar |
| 2 | Menciona queries mas sem processo |
| 3 | Segue processo metodico com 3+ passos |
| 4 | Demonstra uso de Actuator, logs e ferramentas |
| 5 | Responde com profundidade, menciona N+1, profiling, heap dump e APM |

**Perguntas de aprofundamento:**
1. "O que é o problema N+1 e como você identifica e resolve?"
2. "Como você identificaría um memory leak em produção?"
3. "Qual a diferença entre tempo de CPU e tempo de espera (wait)? Como isso afeta a análise?"

---

### Pergunta 100 — Cenário real: Implementação completa de um CRUD de Produtos

**Nível:** Júnior  
**Categoria:** Cenários reais

**Pergunta do entrevistador:**  
"Como desafio final: descreva como você implementaria um CRUD completo de Produtos em uma API Spring Boot, desde a entidade até o controller, com tratamento de erros, validação e paginação. Quais classes você criaria e como elas se relacionam?"

**O que essa pergunta avalia:**  
Avalia a capacidade do candidato de integrar todo o conhecimento demonstrado nas perguntas anteriores em uma implementação coesa e completa, seguindo boas práticas.

**Resposta esperada:**  

**1. Entidade JPA:**

```java
@Entity
@Table(name = "produtos")
@Getter @Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private int quantidadeEstoque;

    @Column(nullable = false)
    private boolean ativo = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    @Column(nullable = false)
    private LocalDateTime atualizadoEm;

    @PrePersist
    protected void onCreate() {
        criadoEm = LocalDateTime.now();
        atualizadoEm = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        atualizadoEm = LocalDateTime.now();
    }
}
```

**2. DTOs:**

```java
public record ProdutoCreateDTO(
    @NotBlank(message = "Nome é obrigatório") String nome,
    @NotBlank(message = "Descrição é obrigatória") String descricao,
    @NotNull(message = "Preço é obrigatório")
    @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero") BigDecimal preco,
    @NotNull(message = "Quantidade é obrigatória")
    @Min(value = 0, message = "Quantidade não pode ser negativa") Integer quantidadeEstoque
) {}

public record ProdutoUpdateDTO(
    String nome,
    String descricao,
    BigDecimal preco,
    Integer quantidadeEstoque
) {}

public record ProdutoResponseDTO(
    Long id, String nome, String descricao, BigDecimal preco,
    int quantidadeEstoque, boolean ativo, LocalDateTime criadoEm, LocalDateTime atualizadoEm
) {}
```

**3. Repository:**

```java
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    boolean existsByNome(String nome);

    Page<Produto> findByAtivoTrueAndNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<Produto> findByAtivoTrue(Pageable pageable);
}
```

**4. Service:**

```java
@Service
@RequiredArgsConstructor
@Transactional
public class ProdutoService {

    private final ProdutoRepository repository;

    @Transactional(readOnly = true)
    public Page<ProdutoResponseDTO> listar(String nome, Pageable pageable) {
        Page<Produto> produtos = (nome != null && !nome.isBlank())
            ? repository.findByAtivoTrueAndNomeContainingIgnoreCase(nome, pageable)
            : repository.findByAtivoTrue(pageable);
        return produtos.map(this::toResponse);
    }

    @Transactional(readOnly = true)
    public ProdutoResponseDTO buscar(Long id) {
        Produto produto = repository.findById(id)
            .filter(Produto::isAtivo)
            .orElseThrow(() -> new ProdutoNaoEncontradoException(id));
        return toResponse(produto);
    }

    public ProdutoResponseDTO criar(ProdutoCreateDTO dto) {
        if (repository.existsByNome(dto.nome())) {
            throw new ProdutoDuplicadoException(dto.nome());
        }
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setQuantidadeEstoque(dto.quantidadeEstoque());
        repository.save(produto);
        return toResponse(produto);
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoUpdateDTO dto) {
        Produto produto = repository.findById(id)
            .orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        if (dto.nome() != null) produto.setNome(dto.nome());
        if (dto.descricao() != null) produto.setDescricao(dto.descricao());
        if (dto.preco() != null) produto.setPreco(dto.preco());
        if (dto.quantidadeEstoque() != null) produto.setQuantidadeEstoque(dto.quantidadeEstoque());

        repository.save(produto);
        return toResponse(produto);
    }

    public void excluir(Long id) {
        Produto produto = repository.findById(id)
            .orElseThrow(() -> new ProdutoNaoEncontradoException(id));
        produto.setAtivo(false);  // Soft delete
        repository.save(produto);
    }

    private ProdutoResponseDTO toResponse(Produto p) {
        return new ProdutoResponseDTO(
            p.getId(), p.getNome(), p.getDescricao(), p.getPreco(),
            p.getQuantidadeEstoque(), p.isAtivo(), p.getCriadoEm(), p.getAtualizadoEm()
        );
    }
}
```

**5. Controller:**

```java
@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public Page<ProdutoResponseDTO> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nome") String sort,
            @RequestParam(defaultValue = "asc") String direction) {

        Pageable pageable = PageRequest.of(page, size,
            Sort.by(Sort.Direction.fromString(direction), sort));
        return service.listar(nome, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(@Valid @RequestBody ProdutoCreateDTO dto) {
        ProdutoResponseDTO criado = service.criar(dto);
        return ResponseEntity.created(URI.create("/api/produtos/" + criado.id())).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id, @Valid @RequestBody ProdutoUpdateDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
```

**6. Exception Handler:**

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> handleNaoEncontrado(ProdutoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ErroDTO("PRODUTO_NAO_ENCONTRADO", ex.getMessage()));
    }

    @ExceptionHandler(ProdutoDuplicadoException.class)
    public ResponseEntity<ErroDTO> handleDuplicado(ProdutoDuplicadoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(new ErroDTO("PRODUTO_DUPLICADO", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidacao(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
            .forEach(e -> erros.put(e.getField(), e.getDefaultMessage()));
        return ResponseEntity.badRequest().body(erros);
    }
}

public record ErroDTO(String codigo, String mensagem) {}
```

**Decisões de design:**

| Decisão | Justificativa |
|---------|---------------|
| DTOs com records | Imutáveis, concisos, Spring Boot 3.x |
| Soft delete (ativo=false) | Preserva histórico, permite restaurar |
| @Transactional no service | Transação no nível de regra de negócio |
| readOnly=true em consultas | Otimização — não cria transação de escrita |
| Paginação com Pageable | Escalabilidade — não carrega tudo na memória |
| Filtro opcional por nome | Flexibilidade — lista todos ou filtra |
| Exception handler global | Padronização de erros em toda a API |
| 201 Created + Location | Convenção REST |
| 204 No Content no delete | Sem corpo na exclusão |
| Validação com Bean Validation | Declarativa, não procedural |

**Explicação didática:**  
Um CRUD completo é como montar uma loja: a entidade é o produto na prateleira, o repository é o estoque, o service é o vendedor que aplica as regras, o controller é o balcão de atendimento, o exception handler é a reclamação de clientes, e os DTOs são as etiquetas de produto. Cada peça tem um papel específico, e juntas formam um sistema funcional e organizado.

**Como o candidato deve responder:**  
- Descrever as 6 camadas: entidade, DTOs, repository, service, controller, exception handler.
- Explicar o fluxo de cada operação (GET, POST, PUT, DELETE).
- Mencionar validação, paginação e tratamento de erros.
- Justificar decisões de design (soft delete, DTO, readOnly).
- Demonstrar conhecimento dos status HTTP apropriados.

**Resposta fraca ou incompleta:**  
"Eu criaria um controller com os métodos GET, POST, PUT e DELETE."  
Falta: não menciona service, repository, DTOs, validação, tratamento de erros ou paginação.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não consegue descrever o CRUD |
| 1 | Menciona apenas controller |
| 2 | Descreve controller + repository mas sem service nem DTO |
| 3 | Descreve todas as camadas com exemplo básico |
| 4 | Demonstra validação, paginação, tratamento de erro e boas práticas |
| 5 | Responde com profundidade, justifica decisões, soft delete, readOnly e status HTTP |

**Perguntas de aprofundamento:**
1. "Como você lidaria com concorrência se dois usuários tentarem atualizar o mesmo produto ao mesmo tempo?"
2. "Como você testaria esse CRUD? Quais testes escreveria?"
3. "Como você adicionaria autenticação para que apenas administradores possam criar/atualizar/excluir produtos?"

---

## Resumo Final da Entrevista

### Informações gerais

| Item | Detalhe |
|------|---------|
| **Tecnologia avaliada** | Spring Boot |
| **Nível abordado** | Júnior |
| **Quantidade total de perguntas** | 100 |
| **Tipo de perguntas** | Misturadas (conceituais + práticas + cenários reais) |

### Distribuição por categoria

| Categoria | Quantidade aproximada | Perguntas relacionadas |
|-----------|------------------------|-----------------------|
| Fundamentos | 18 | 1, 2, 3, 5, 10, 41, 44, 68, 71, 72, 73, 74, 91, 98 |
| Prática | 32 | 4, 8, 9, 31, 32, 33, 34, 36, 37, 38, 41, 42, 45, 47, 50, 55, 56, 61, 62, 66, 69, 70, 76, 92, 97 |
| Arquitetura | 14 | 43, 46, 48, 49, 64, 75, 77, 78, 81, 82, 83, 84, 85, 94 |
| Testes | 10 | 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 |
| Configuração | 8 | 6, 7, 11, 12, 13, 14, 15, 16 |
| Troubleshooting | 8 | 7, 35, 79, 86, 87, 88, 95, 99 |
| Segurança | 5 | 65, 67, 80, 89, 90 |
| Desempenho | 3 | 63, 96, 99 |
| Cenários reais | 6 | 93, 94, 96, 100 |
| Boas práticas | 6 | 97, 98, 99, 100 |

### Principais competências avaliadas

1. **Fundamentos do Spring Boot** — autoconfiguração, starters, DI, profiles, anotações
2. **Construção de APIs REST** — controllers, DTOs, status codes, validação, content negotiation
3. **Persistência de dados** — Spring Data JPA, entities, relacionamentos, queries, paginação
4. **Tratamento de exceções** — @ControllerAdvice, @ExceptionHandler, padronização de erros
5. **Testes** — unitários, slice, integração, Mockito, MockMvc, DataJpaTest
6. **Segurança básica** — Spring Security, CORS, autenticação, autorização
7. **Recursos avançados** — @Async, @Scheduled, caching, eventos, upload de arquivos
8. **Spring Boot 3.x** — Jakarta EE, records, migration, novas anotações
9. **Boas práticas** — estrutura de pacotes, readiness, logging, externalização de configuração
10. **Troubleshooting** — diagnóstico de erros, performance, debugging

---

## Matriz de Competências

| Competência | Nível esperado (Júnior) | Perguntas relacionadas | Indicadores de domínio |
|-------------|--------------------------|-----------------------|------------------------|
| Fundamentos do Spring Boot | Sólido | 1, 2, 3, 5, 10, 91 | Explica autoconfiguração, starters, @SpringBootApplication, relação com Spring Framework |
| Injeção de Dependências | Bom | 5, 31, 32, 33 | Conhece as 3 formas, recomenda construtor, entende @Autowired implícito |
| Construção de APIs REST | Bom | 4, 41, 42, 44, 45, 46 | Usa @RestController, ResponseEntity, @PathVariable, @RequestParam, DTOs, status codes |
| Spring Data JPA | Bom | 8, 55, 94 | Define repositories, query methods, @Query, paginação, @Transactional |
| Validação de dados | Bom | 9, 45, 92 | Usa @Valid, Bean Validation, trata MethodArgumentNotValidException |
| Tratamento de exceções | Bom | 7, 50, 98 | Usa @ControllerAdvice, @ExceptionHandler, padroniza erros |
| Testes | Bom | 51-60 | Diferencia unitário/slice/integração, usa @MockBean, @WebMvcTest, @DataJpaTest |
| Spring Security básico | Conceitual | 65, 67, 80 | Configura SecurityFilterChain, permitAll, BCrypt, CORS |
| @Transactional | Bom | 68, 93 | Entende commit/rollback, propagation, armadilhas de self-invocation |
| Configuração | Bom | 6, 11, 12, 13, 14 | Usa application.properties, profiles, @Value, @ConfigurationProperties |
| Async e Scheduling | Conceitual | 61, 62, 63 | Usa @Scheduled, @Async, @EnableAsync, CompletableFuture |
| Spring Boot 3.x | Bom | 91, 92 | Sabe javax→jakarta, Java 17, records, Spring Security 6 |
| Boas práticas | Bom | 97, 98, 99, 100 | Estrutura pacotes, readiness, externalização, logging |
| Troubleshooting | Bom | 35, 86, 95, 99 | Diagnostica bean não encontrado, lentidão, erros de validação |
| Cenários reais | Bom | 93, 94, 96, 100 | Integra múltiplos recursos em soluções completas |

---

## Recomendações para o Entrevistador

### Como conduzir a entrevista

- **Comece pelas perguntas de fundamentos** (1-10) para estabelecer um baseline. Se o candidato não responde bem às perguntas 1-5, dificilmente terá base para as perguntas avançadas.
- **Use as perguntas de cenário real** (93, 94, 96, 100) no final, pois elas exigem a integração de múltiplos conceitos. São excelentes para diferenciar candidatos que decoraram de candidatos que aplicam.
- **Adapte o ritmo:** se o candidato responde rapidamente e bem, use as perguntas de aprofundamento para explorar profundidade. Se demonstra dificuldade, volte para fundamentos.
- **Não faça todas as 100 perguntas** — selecione 15-20 distribuídas entre as categorias, com peso maior em fundamentos e prática.

### Como fazer perguntas de aprofundamento

- Comece com "Por quê?" após uma resposta correta para verificar se o candidato entende o motivo, não apenas o fato.
- Use "Em quais situações isso não funcionaria?" para avaliar pensamento crítico.
- Pergunte "Como você testaria isso?" para verificar se o candidato pensa em qualidade, não apenas em funcionalidade.
- Faça "Qual a alternativa?" para verificar se conhece múltiplas abordagens.

### Como diferenciar insegurança de falta de conhecimento

- **Insegurança:** o candidato hesita, mas quando questionado "você pode pensar em voz alta?", consegue articular o raciocínio. Geralmente responde corretamente com um empurrão.
- **Falta de conhecimento:** o candidato tenta adivinhar ou fica em branco mesmo com dicas. Não consegue construir o raciocínio mesmo com orientação.
- **Dica:** diga "não há problema se você não sabe — me conte como você investigaria isso" para avaliar capacidade de aprendizado.

### Como avaliar respostas parcialmente corretas

- Uma resposta parcialmente correta deve receber nota 2 ou 3, nunca 0.
- Avalie se o candidato **sabe o conceito mas erra a implementação** (nota 3) ou se **tenta implementar mas erra o conceito** (nota 2).
- Se o candidato menciona a ferramenta certa mas não sabe explicar como funciona (ex: "uso @Transactional mas não sei o que é propagation"), dê nota 2.

### Como evitar vieses na avaliação

- **Não confunda eloquência com conhecimento** — um candidato que fala bem mas erra conceitos não é melhor que um que hesita mas acerta.
- **Não penalize o candidato por não conhecer um detalhe específico** se ele demonstra raciocínio correto e base sólida.
- **Use o mesmo conjunto de perguntas para todos os candidatos** do mesmo nível.
- **Avalie com base na rubrica (0-5), não com base em impressões.**

### Como registrar evidências objetivas

- Anote a pergunta, a resposta resumida do candidato e a nota (0-5).
- Registre frases específicas que demonstram conhecimento ou lacunas (ex: "explicou autoconfiguração corretamente" ou "não soube diferenciar @Controller de @RestController").
- Marque as perguntas de aprofundamento usadas e como o candidato respondeu.
- Ao final, some as notas e calcule a média para uma visão geral.

---

## Recomendações para o Candidato

### Como estruturar o raciocínio

- **Pense em voz alta:** o entrevistador avalia seu processo de pensamento, não apenas a resposta final. Mesmo que não saiba a resposta exata, demonstrar raciocínio lógico é melhor que ficar em silêncio.
- **Comece pelo conceito e depois mostre a prática:** "O @Transactional funciona abrindo uma transação antes do método e fazendo commit ou rollback. Por exemplo..."
- **Use a estrutura:** Conceito → Explicação → Exemplo → Trade-off. Essa progressão demonstra domínio em múltiplos níveis.

### Como explicar decisões técnicas

- Sempre justifique o "por quê", não apenas o "o quê". "Usei injeção por construtor porque permite imutabilidade e facilita testes" é melhor que "Usei injeção por construtor".
- Quando houver alternativas, compare-as: "Poderia usar @Async ou CompletableFuture. Escolho @Async quando quero que o Spring gerencie o pool de threads."

### Como utilizar exemplos reais

- Cite projetos em que você aplicou o conceito: "No meu projeto anterior, usamos @ControllerAdvice para padronizar os erros da API em um formato único."
- Se não tem experiência real, use exemplos hipotéticos mas realistas: "Se eu fosse implementar, criaria um service que..."

### Como admitir que não sabe algo

- Seja honesto e direto: "Não conheço esse recurso em detalhe, mas pelo nome imagino que..."
- Nunca tente inventar uma resposta. O entrevistador percebe e isso é pior que admitir desconhecimento.
- Mostre como investigaria: "Não sei a resposta exata, mas procuraria na documentação do Spring ou no código-fonte."

### Como discutir trade-offs

- Toda decisão técnica tem prós e contrás. Demonstrar que você os conhece é um sinal de maturidade.
- "Usar cache (@Cacheable) melhora performance, mas traz o risco de dados desatualizados. Por isso é importante definir uma estratégia de invalidação com @CacheEvict."
- "O @Async melhora throughput, mas adiciona complexidade na tratativa de erros e debugging."

### Como responder perguntas práticas e de arquitetura

- Em perguntas de código, escreva ou descreva a estrutura completa: imports, classe, anotações, método, retorno.
- Em perguntas de arquitetura, desenhe o fluxo mentalmente e descreva passo a passo: "A requisição chega no controller, que valida o DTO, chama o service que abre transação, consulta o repository..."
- Em cenários reais, sempre considere tratamento de erros: "E se a API externa falhar? E se o banco estiver indisponível? E se o dado for inválido?"

---

**Fim do roteiro — 100 perguntas concluídas.**