Vamos começar! Preciso de algumas informações para montar o roteiro de entrevista técnica sob medida.Excelente! Tenho todas as informações necessárias. Vou gerar o roteiro completo agora.

**Parâmetros confirmados:**
- **Tecnologias:** Spring WebFlux, Spring Cloud, Resilience4j, OAuth2/JWT/OpenID Connect, JUnit 5/Mockito/Testcontainers, Grafana/Prometheus/OpenTelemetry, Kafka prático
- **Nível:** Júnior
- **Tipo:** Misturadas (conceituais, práticas e cenários reais)
- **Quantidade:** 100 perguntas (padrão para nível único)

Devido ao volume, divido em partes. Iniciando com a **Parte 1 — Perguntas 1 a 10 (Spring WebFlux)**.

---

# 🎯 Roteiro de Entrevista Técnica — Júnior

## Parte 1: Spring WebFlux (Perguntas 1–10)

---

### Pergunta 1 — Programação Reativa vs Imperativa

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é programação reativa e como ela se diferencia da programação imperativa tradicional? Por que o Spring WebFlux foi criado em vez de continuarmos usando o Spring MVC tradicional?

**O que essa pergunta avalia:**
Compreensão do paradigma reativo, conhecimento sobre o modelo non-blocking, diferença entre abordagens imperativas e reativas, e entendimento da motivação por trás do Spring WebFlux.

**Resposta esperada:**
Programação reativa é um paradigma orientado a fluxos de dados assíncronos e propagação de mudanças. Diferente da programação imperativa — onde o código é executado sequencialmente, bloqueando a thread até obter um resultado —, a programação reativa opera de forma non-blocking: quando uma operação demorada é iniciada (como uma chamada de banco de dados ou HTTP), a thread não fica aguardando. Em vez disso, um "callback" ou assinante é notificado quando o resultado está disponível.

O Spring WebFlux foi criado para permitir construir aplicações reativas non-blocking sobre o Spring Framework, usando Project Reactor como sua biblioteca reativa. Enquanto o Spring MVC usa um modelo thread-per-request (uma thread fica bloqueada aguardando a resposta), o WebFlux usa um modelo baseado em event loop, onde poucas threads podem atender milhares de conexões simultâneas.

**Explicação didática:**
Imagine um restaurante. Na abordagem imperativa (Spring MVC), cada garçom atende apenas uma mesa por vez — fica parado esperando a cozinha terminar o pedido antes de atender a próxima mesa. Na abordagem reativa (WebFlux), o garçom anota o pedido, envia para a cozinha e imediatamente vai atender outra mesa. Quando o prato fica pronto, a cozinha notifica o garçom, que então leva a comida. O garçom nunca fica parado esperando.

No Spring WebFlux, os publishers principais são `Mono` (zero ou um elemento) e `Flux` (zero a N elementos), que representam fluxos assíncronos de dados.

**Exemplo prático:**
Em um sistema de e-commerce com milhares de usuários simultâneos consultando catálogo, o Spring MVC precisaria de uma thread pool grande para atender todas as requisições, consumindo muita memória. Com WebFlux, poucas threads conseguem gerenciar todas as conexões, pois nenhuma fica bloqueada esperando I/O.

**Exemplo de código:**
```java
// Spring MVC (imperativo - bloqueia a thread)
@GetMapping("/produto/{id}")
public Produto buscarProduto(@PathVariable Long id) {
    return produtoRepository.findById(id); // thread bloqueia até retornar
}

// Spring WebFlux (reativo - non-blocking)
@GetMapping("/produto/{id}")
public Mono<Produto> buscarProduto(@PathVariable Long id) {
    return produtoRepository.findById(id); // retorna imediatamente, não bloqueia
}
```

**Como o candidato deve responder:**
- Começar definindo programação reativa como paradigma assíncrono e non-blocking
- Mencionar a diferença fundamental: bloqueio de thread vs não-bloqueio
- Citar `Mono` e `Flux` como tipos fundamentais do Project Reactor
- Explicar que WebFlux usa event loop ao invés de thread-per-request
- Mencionar que a motivação é eficiência com muitas conexões simultâneas
- Evitar dizer que WebFlux é "sempre mais rápido" — o ganho é em escalabilidade com I/O pesado

**Resposta fraca ou incompleta:**
"WebFlux é mais rápido que Spring MVC porque usa programação reativa." — Faltam explicações sobre o que é programação reativa, como o modelo non-blocking funciona, e quando WebFlux é ou não vantajoso.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Em quais cenários o Spring MVC seria uma escolha melhor que o WebFlux?
2. O que significa "backpressure" no contexto de programação reativa?
3. Como a mudança de paradigma afeta a forma de escrever testes?

---

### Pergunta 2 — Mono e Flux

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
No Project Reactor, utilizamos os tipos `Mono` e `Flux`. O que cada um representa? Quando você escolheria um em vez do outro?

**O que essa pergunta avalia:**
Conhecimento dos tipos fundamentais do Reactor, entendimento de publishers reativos e capacidade de distinguir casos de uso apropriados para cada tipo.

**Resposta esperada:**
`Mono<T>` representa um publisher que emite zero ou um elemento. É ideal para operações que retornam um único resultado, como buscar um registro por ID, fazer uma chamada HTTP que retorna uma resposta, ou executar um comando de banco de dados que retorna um valor.

`Flux<T>` representa um publisher que emite zero a N elementos, possivelmente de forma infinita. É adequado para operações que retornam múltiplos resultados, como listar todos os produtos, processar eventos de um stream, ou ler dados de um banco que retorna múltiplas linhas.

Ambos implementam a interface `Publisher<T>` da especificação Reactive Streams. A escolha entre eles depende da cardinalidade esperada: se é um valor único, use `Mono`; se são múltiplos valores, use `Flux`.

**Explicação didática:**
Pense em `Mono` como uma caixa que contém no máximo um item — ou tem algo dentro, ou está vazia. Pense em `Flux` como uma esteira transportadora que pode entregar zero, um ou vários itens ao longo do tempo.

**Exemplo prático:**
Buscar um usuário por e-mail retorna `Mono<Usuario>` (existe ou não existe). Buscar todos os usuários ativos retorna `Flux<Usuario>` (pode ser zero, um ou milhares).

**Exemplo de código:**
```java
// Mono: retorna 0 ou 1 elemento
public Mono<Usuario> buscarPorEmail(String email) {
    return usuarioRepository.findByEmail(email);
}

// Flux: retorna 0 a N elementos
public Flux<Usuario> listarUsuariosAtivos() {
    return usuarioRepository.findAllByAtivoTrue();
}

// É possível converter entre eles
Mono<Usuario> mono = Mono.just(new Usuario("João"));
Flux<Usuario> flux = mono.flux(); // Mono -> Flux
Mono<Usuario> monoDeVolta = flux.next(); // Flux -> Mono (pega o primeiro)
```

**Como o candidato deve responder:**
- Definir claramente Mono (0..1) e Flux (0..N)
- Mencionar que ambos são Publishers da especificação Reactive Streams
- Dar exemplos práticos de quando usar cada um
- Mencionar que é possível converter entre os tipos
- Evitar confundir Mono com "Optional" — Mono é assíncrono, Optional é síncrono

**Resposta fraca ou incompleta:**
"Mono é para um item e Flux é para vários." — Correto, mas superficial. Falta explicar que são publishers assíncronos, que representam fluxos de dados ao longo do tempo, e não estruturas de dados estáticas.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. O que acontece se você assinar (subscribe) em um Mono que emite vazio?
2. Como você transformaria um `Flux<Usuario>` em um `Mono<List<Usuario>>`?
3. Qual é a diferença entre `Mono.empty()` e `Mono.just(null)`?

---

### Pergunta 3 — Anotações do WebFlux

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
Ao criar um controller no Spring WebFlux, quais anotações você utiliza e como elas se comparam às anotações do Spring MVC tradicional?

**O que essa pergunta avalia:**
Conhecimento prático de como estruturar controllers no WebFlux, familiaridade com as anotações e capacidade de comparar com o Spring MVC.

**Resposta esperada:**
As anotações de mapeamento de rotas no WebFlux são as mesmas do Spring MVC: `@Controller`, `@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@PathVariable`, `@RequestParam`, `@RequestBody`. A principal diferença está nos tipos de retorno: em vez de retornar objetos síncronos, os métodos retornam `Mono<T>` ou `Flux<T>`.

Para criar uma aplicação WebFlux, usa-se `@SpringBootApplication` (igual ao MVC), mas a dependência no pom.xml é diferente: `spring-boot-starter-webflux` em vez de `spring-boot-starter-web`.

Também é possível usar a programação funcional com `RouterFunction` como alternativa às anotações, mas as anotações são mais comuns para iniciantes.

**Explicação didática:**
As anotações são as mesmas porque o Spring quer facilitar a migração — a curva de aprendizado é menor quando a sintaxe é familiar. A mudança está no que os métodos retornam: em vez de devolver o objeto diretamente, você o "embrulha" em um `Mono` ou `Flux`.

**Exemplo prático:**
Um controller de produtos que expõe endpoints REST para CRUD usa exatamente as mesmas anotações `@RestController` e `@GetMapping`, mas cada método retorna `Mono` ou `Flux`.

**Exemplo de código:**
```java
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    // Retorna um único produto (0 ou 1)
    @GetMapping("/{id}")
    public Mono<Produto> buscar(@PathVariable String id) {
        return service.findById(id);
    }

    // Retorna múltiplos produtos
    @GetMapping
    public Flux<Produto> listar() {
        return service.findAll();
    }

    // Salva e retorna o produto criado
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Produto> criar(@RequestBody Produto produto) {
        return service.save(produto);
    }
}
```

**Como o candidato deve responder:**
- Listar as anotações principais que são compartilhadas com Spring MVC
- Destacar que a diferença está no tipo de retorno (Mono/Flux)
- Mencionar a dependência `spring-boot-starter-webflux`
- Opcionalmente, mencionar `RouterFunction` como alternativa funcional
- Evitar afirmar que todas as anotações são diferentes — a maioria é idêntica

**Resposta fraca ou incompleta:**
"No WebFlux usa anotações diferentes do Spring MVC." — Incorreto. A maioria das anotações é a mesma. O candidato demonstra desconhecer a API real do framework.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Como você lidaria com tratamento de erros em um controller WebFlux?
2. Qual é a diferença entre `@Controller` e `@RestController` no contexto do WebFlux?
3. Como você validaria o body da requisição antes de processá-lo?

---

### Pergunta 4 — Operadores do Reactor

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O Project Reactor oferece vários operadores para manipular fluxos de dados, como `map`, `flatMap`, `filter` e `flatMapMany`. Explique o que cada um faz e quando utilizá-los.

**O que essa pergunta avalia:**
Conhecimento dos operadores fundamentais do Reactor, capacidade de transformar e manipular fluxos reativos, e entendimento da diferença entre operadores síncronos e assíncronos.

**Resposta esperada:**
- **`map`**: Transforma cada elemento emitido de forma síncrona. Recebe um valor e retorna outro valor. Não muda a cardinalidade. Se você tem um `Mono<Usuario>`, pode usar `map` para transformar em `Mono<UsuarioDTO>`.

- **`flatMap`**: Transforma cada elemento de forma assíncrona, retornando um novo `Mono` ou `Flux`. É usado quando a transformação em si envolve uma operação assíncrona (como uma chamada de banco de dados). Achata os publishers resultantes em um único fluxo.

- **`filter`**: Filtra elementos com base em um predicado. Apenas elementos que satisfazem a condição passam adiada.

- **`flatMapMany`**: Usado quando você tem um `Mono` e precisa transformá-lo em um `Flux`. Por exemplo, buscar um usuário (`Mono`) e então buscar todos os pedidos desse usuário (`Flux`).

**Explicação didática:**
- `map` é como trocar a embalagem de cada item individualmente — é imediato e síncrono.
- `flatMap` é como pedir para cada item que vá buscar algo em outro lugar e traga o resultado — é assíncrono, porque cada item gera uma nova operação que pode demorar.
- `filter` é como uma peneira: só deixa passar o que atende ao critério.
- `flatMapMany` é como abrir uma caixa (Mono) e derramar vários itens (Flux) no chão.

**Exemplo prático:**
Buscar um usuário por ID, converter para DTO, e se o usuário for ativo, buscar seus pedidos.

**Exemplo de código:**
```java
// map: transformação síncrona (Mono<Usuario> -> Mono<UsuarioDTO>)
 Mono<UsuarioDTO> dto = usuarioMono
     .map(usuario -> new UsuarioDTO(usuario.getNome(), usuario.getEmail()));

// flatMap: transformação assíncrona (encadeia operações reativas)
Mono<Pedido> pedido = usuarioMono
    .flatMap(usuario -> pedidoRepository.findByUsuario(usuario.getId()));

// filter: filtra elementos
Flux<Usuario> ativos = usuariosFlux
    .filter(usuario -> usuario.isAtivo());

// flatMapMany: Mono -> Flux (um usuário, múltiplos pedidos)
Flux<Pedido> pedidosDoUsuario = usuarioMono
    .flatMapMany(usuario -> pedidoRepository.findAllByUsuarioId(usuario.getId()));
```

**Como o candidato deve responder:**
- Explicar cada operador com suas características principais
- Destacar que `map` é síncrono e `flatMap` é assíncrono
- Explicar que `flatMap` "achata" (flattens) publishers aninhados
- Mencionar que `flatMapMany` converte Mono em Flux
- Dar exemplos práticos de uso de cada um
- Evitar confundir `map` com `flatMap` — a diferença síncrono vs assíncrono é crucial

**Resposta fraca ou incompleta:**
"map transforma e filter filtra." — Genérico demais. Não explica a diferença crucial entre map (síncrono) e flatMap (assíncrono), nem menciona a questão do achatamento de publishers.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Qual é a diferença entre `flatMap` e `concatMap`? Quando usar cada um?
2. O que acontece se a operação dentro de um `map` lançar uma exceção?
3. Como você ordenaria os elementos de um `Flux` antes de aplicá-los?

---

### Pergunta 5 — subscribe() e a execução lazy

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
No Project Reactor, diz-se que os publishers são "lazy" (preguiçosos). O que isso significa? Qual é o papel do método `subscribe()` e por que é importante entender esse comportamento?

**O que essa pergunta avalia:**
Compreensão do modelo de execução lazy do Reactor, papel do `subscribe()` como gatilho de execução, e entendimento de que a declaração de um pipeline não executa nada.

**Resposta esperada:**
No Project Reactor, `Mono` e `Flux` são lazy (preguiçosos). Isso significa que apenas declarar a cadeia de operadores não executa nenhuma operação. Nada acontece até que alguém chame `subscribe()` no publisher. Quando você escreve `mono.map(...).filter(...)`, você está apenas descrevendo o que deve acontecer, não executando.

O método `subscribe()` é o gatilho que inicia a execução da cadeia. É ele que efetivamente diz ao publisher: "comece a emitir elementos e execute os operadores configurados".

No contexto do Spring WebFlux, o framework chama `subscribe()` automaticamente quando a resposta é serializada para o cliente. Por isso, nos controllers, você não precisa chamar `subscribe()` manualmente.

**Explicação didática:**
Imagine uma receita de bolo. Escrever a receita (declarar o pipeline) não faz o bolo. Você precisa colocar a receita em prática (chamar `subscribe()`) para que os ingredientes sejam misturados e o bolo seja assado.

**Exemplo prático:**
Em um teste unitário, se você esquecer de chamar `subscribe()` (ou usar `StepVerifier`), o código dentro do `map` nunca será executado, e o teste pode passar falsamente.

**Exemplo de código:**
```java
// Nada disso é executado até subscribe():
Mono<String> mono = Mono.just("Olá")
    .map(s -> {
        System.out.println("Processando: " + s); // não imprime ainda
        return s.toUpperCase();
    })
    .filter(s -> s.length() > 2);

// Agora a execução começa:
mono.subscribe(resultado -> System.out.println("Resultado: " + resultado));
// Saída:
// Processando: Olá
// Resultado: OLÁ

// No Spring WebFlux, o framework chama subscribe() para você:
@GetMapping("/ola")
public Mono<String> ola() {
    return Mono.just("Olá"); // framework chama subscribe() ao serializar
}
```

**Como o candidato deve responder:**
- Explicar que publishers são lazy: nada executa até subscribe()
- Mencionar que o pipeline apenas descreve a transformação
- Explicar que o Spring WebFlux chama subscribe() automaticamente
- Mencionar a implicação para testes (precisa de StepVerifier ou subscribe manual)
- Evitar chamar subscribe() em controllers — isso quebra o fluxo reativo

**Resposta fraca ou incompleta:**
"subscribe() faz a inscrição no fluxo." — Vago. Não explica o comportamento lazy, nem por que isso importa na prática.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. O que acontece se você chamar `subscribe()` duas vezes no mesmo `Mono`?
2. Qual é a diferença entre `subscribe()` e `block()`? Quando usar cada um?
3. Como você testaria um pipeline reativo sem chamar `subscribe()` diretamente?

---

### Pergunta 6 — block() e quando NÃO usar

**Nível:** Júnior
**Categoria:** Boas práticas

**Pergunta do entrevistador:**
O método `block()` está disponível em `Mono` e `Flux`. O que ele faz e por que é geralmente desaconselhado no Spring WebFlux? Em quais situações o uso pode ser justificável?

**O que essa pergunta avalia:**
Entendimento do impacto de `block()` no modelo reativo, conhecimento das anti-patterns do WebFlux, e discernimento sobre exceções onde `block()` é aceitável.

**Resposta esperada:**
`block()` converte uma operação assíncrona em síncrona — ele bloqueia a thread atual até que o publisher emita um elemento ou termine. Em essência, ele "desfaz" o propósito da programação reativa ao introduzir bloqueio.

No Spring WebFlux, `block()` é desaconselhado porque:
1. Bloqueia a thread do event loop, que deveria estar sempre livre para processar outras requisições
2. Pode causar degradação de performance e até travamento da aplicação em alta carga
3. Quebra o contrato non-blocking do pipeline reativo
4. Pode lançar `IllegalStateException` se chamado na thread do event loop (em versões recentes do Reactor)

O uso pode ser justificável em:
- **Testes**: onde o código síncrono é mais simples de verificar
- **Integração com bibliotecas imperativas**: ao migrar gradualmente de Spring MVC para WebFlux, pode ser necessário chamar `block()` em pontos de fronteira
- **CLI tools e batch jobs**: onde a natureza assíncrona não traz benefício

**Explicação didática:**
Voltando à analogia do garçom: usar `block()` é como o garçom decidir ficar parado na frente da cozinha esperando o prato ficar pronto, ignorando todas as outras mesas. Derrota todo o propósito de ter um garçom eficiente.

**Exemplo prático:**
Em um controller WebFlux, nunca chame `block()`. Em vez disso, compose os publishers com `flatMap` para encadear operações assíncronas. Em um teste, `block()` pode ser usado para obter o resultado e verificá-lo.

**Exemplo de código:**
```java
// ❌ ERRADO em controller WebFlux - bloqueia o event loop
@GetMapping("/produto/{id}")
public Produto buscar(@PathVariable String id) {
    return produtoRepository.findById(id).block(); // NUNCA faça isso
}

// ✅ CORRETO - mantém o fluxo reativo
@GetMapping("/produto/{id}")
public Mono<Produto> buscar(@PathVariable String id) {
    return produtoRepository.findById(id);
}

// ✅ Aceitável em testes
@Test
void deveBuscarProduto() {
    Produto produto = produtoRepository.findById("123").block();
    assertNotNull(produto);
    assertEquals("Notebook", produto.getNome());
}
```

**Como o candidato deve responder:**
- Explicar que `block()` bloqueia a thread atual
- Mencionar que quebra o modelo non-blocking do WebFlux
- Listar as consequências: degradação de performance, possível travamento
- Citar situações onde é aceitável (testes, migração, CLI)
- Evitar dizer que `block()` é "sempre proibido" — há contextos onde é aceitável

**Resposta fraca ou incompleta:**
"block() não deve ser usado porque é ruim." — Não explica o porquê, nem reconhece contextos onde é aceitável.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. O que acontece se você chamar `block()` na thread do event loop do Netty?
2. Existe alguma alternativa ao `block()` para integrar com código imperativo?
3. Como você converteria uma biblioteca síncrona em reativa sem usar `block()`?

---

### Pergunta 7 — Tratamento de Erros com onErrorResume

**Nível:** Júnior
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**
Em uma aplicação Spring WebFlux, como você lida com erros em um pipeline reativo? Explique pelo menos dois operadores de tratamento de erro e quando utilizá-los.

**O que essa pergunta avalia:**
Conhecimento dos mecanismos de tratamento de erro no Reactor, capacidade de construir pipelines resilientes e entendimento de como o tratamento de erro reativo difere do try-catch tradicional.

**Resposta esperada:**
No Reactor, o tratamento de erro é feito via operadores, pois o try-catch tradicional não funciona com fluxos assíncronos. Os principais operadores são:

1. **`onErrorResume`**: Quando ocorre um erro, permite fornecer um publisher alternativo (fallback). É como um "catch" que retorna um valor ou fluxo alternativo. Ideal para fornecer respostas de fallback, como retornar um cache quando o banco de dados está indisponível.

2. **`onErrorReturn`**: Quando ocorre um erro, retorna um valor padrão. Mais simples que `onErrorResume`, usado quando você só quer devolver um valor fixo em caso de falha.

3. **`onErrorMap`**: Transforma a exceção em outra exceção diferente. Útil para converter exceções técnicas em exceções de domínio ou para enriquecer o erro com contexto.

4. **`retry`**: Tenta novamente a operação quando ocorre um erro. Pode ser configurado com número de tentativas e delay. Útil para falhas transitórias.

Também é possível usar `@ExceptionHandler` no controller para tratar erros globalmente, similar ao Spring MVC.

**Explicação didática:**
No código imperativo, você envolve o código em try-catch. No reativo, o erro viaja pelo pipeline como um sinal de erro. Os operadores de tratamento interceptam esse sinal e decidem o que fazer: substituir por um valor, tentar de novo, ou transformar o erro.

**Exemplo prático:**
Buscar um usuário no banco de dados. Se o banco estiver indisponível, retornar um usuário "cache" pré-definido. Se ocorrer um erro de validação, converter em uma exceção de domínio com mensagem amigável.

**Exemplo de código:**
```java
// onErrorResume: fornece fallback em caso de erro
public Mono<Usuario> buscarUsuario(String id) {
    return usuarioRepository.findById(id)
        .onErrorResume(e -> {
            log.error("Erro ao buscar usuário", e);
            // Retorna um usuário cache em caso de falha
            return Mono.just(usuarioCache.getOrDefault(id, new Usuario("guest")));
        });
}

// onErrorReturn: retorna valor padrão
public Mono<String> buscarNome(String id) {
    return usuarioRepository.findNomeById(id)
        .onErrorReturn("Desconhecido");
}

// retry: tenta novamente em caso de falha transitória
public Mono<Resposta> chamarApi() {
    return webClient.get()
        .uri("/api/dados")
        .retrieve()
        .bodyToMono(Resposta.class)
        .retry(3); // tenta até 3 vezes
}
```

**Como o candidato deve responder:**
- Explicar que try-catch não funciona com pipelines reativos
- Apresentar pelo menos dois operadores de erro (onErrorResume, onErrorReturn, retry, onErrorMap)
- Dar exemplo de uso prático para cada um
- Mencionar `@ExceptionHandler` como complemento no nível do controller
- Evitar confundir `onErrorResume` com `onErrorReturn` — o primeiro aceita um publisher, o segundo um valor fixo

**Resposta fraca ou incompleta:**
"Usa-se try-catch para tratar erros." — Incorreto no contexto reativo. O try-catch não captura erros assíncronos no pipeline.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Como você diferenciaria um erro transitório (que merece retry) de um erro permanente (que não deve ser retentado)?
2. O que acontece se um erro não for tratado em nenhum ponto do pipeline?
3. Como você usaria `retryBackoff` e por que ele é preferível ao `retry` simples?

---

### Pergunta 8 — WebClient vs RestTemplate

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
No contexto do Spring WebFlux, o que é o `WebClient` e como ele se compara ao `RestTemplate`? Escreva um exemplo básico de como fazer uma chamada HTTP GET reativa.

**O que essa pergunta avalia:**
Conhecimento do cliente HTTP reativo do Spring, capacidade de fazer chamadas HTTP non-blocking, e entendimento da transição do modelo imperativo para reativo em integrações HTTP.

**Resposta esperada:**
`WebClient` é o cliente HTTP reativo introduzido no Spring 5, projetado para substituir o `RestTemplate` em aplicações reativas. Enquanto `RestTemplate` é síncrono e bloqueia a thread durante a chamada HTTP, `WebClient` é non-blocking e retorna `Mono` ou `Flux`, integrando-se naturalmente ao pipeline reativo.

Principais características do WebClient:
- Non-blocking: não bloqueia a thread enquanto aguarda a resposta
- Fluente: usa builder pattern para configuração
- Suporta tanto reativo quanto síncrono (com `block()`)
- Suporta streaming de respostas grandes
- Integra-se naturalmente com Reactor

O `RestTemplate` embora não tenha sido oficialmente descontinuado, o Spring recomenda o uso de `WebClient` para novos projetos, inclusive em aplicações Spring MVC.

**Explicação didática:**
`RestTemplate` é como fazer uma ligação telefônica e ficar esperando a resposta sem fazer mais nada. `WebClient` é como enviar um e-mail e continuar trabalhando — quando a resposta chega, você é notificado.

**Exemplo prático:**
Em um microserviço de pedidos que precisa consultar o serviço de produtos para verificar disponibilidade, o `WebClient` permite fazer a chamada sem bloquear a thread, mantendo o throughput alto mesmo com muitas requisições simultâneas.

**Exemplo de código:**
```java
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
            .baseUrl("http://produto-service:8080")
            .build();
    }
}

@Service
public class ProdutoClient {

    private final WebClient webClient;

    public ProdutoClient(WebClient webClient) {
        this.webClient = webClient;
    }

    // GET reativo - retorna Mono sem bloquear
    public Mono<Produto> buscarProduto(String id) {
        return webClient.get()
            .uri("/produtos/{id}", id)
            .retrieve() // obtém a resposta
            .bodyToMono(Produto.class); // converte o body para Mono<Produto>
    }

    // GET de lista - retorna Flux
    public Flux<Produto> listarProdutos() {
        return webClient.get()
            .uri("/produtos")
            .retrieve()
            .bodyToFlux(Produto.class);
    }
}
```

**Como o candidato deve responder:**
- Explicar que WebClient é o cliente HTTP reativo do Spring
- Comparar com RestTemplate: non-blocking vs blocking
- Mencionar a API fluente (builder pattern)
- Demonstrar uso de `retrieve()`, `bodyToMono()` e `bodyToFlux()`
- Mencionar que WebClient também pode ser usado em projetos Spring MVC
- Evitar dizer que RestTemplate foi removido — ele ainda existe, mas WebClient é o recomendado

**Resposta fraca ou incompleta:**
"WebClient é o substituto do RestTemplate." — Correto, mas faltam explicações sobre como funciona, por que é reativo, e como utilizá-lo na prática.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Como você configuraria timeout e autenticação no WebClient?
2. Como você trataria erros HTTP 4xx/5xx no WebClient?
3. Como você faria múltiplas chamadas HTTP em paralelo e combinaria os resultados?

---

### Pergunta 9 — Backpressure

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é "backpressure" no contexto de programação reativa e como o Project Reactor lida com isso? Dê um exemplo de uma situação onde backpressure seria um problema real.

**O que essa pergunta avalia:**
Compreensão do conceito de backpressure, conhecimento dos mecanismos de controle de fluxo do Reactor, e capacidade de identificar cenários práticos onde o desequilíbrio entre produtor e consumidor causa problemas.

**Resposta esperada:**
Backpressure ocorre quando um producer (fonte de dados) emite elementos mais rapidamente do que o consumer consegue processá-los. Sem controle, isso pode levar a acúmulo de elementos na memória, estouro de buffer e eventualmente `OutOfMemoryError`.

No Project Reactor, o backpressure é gerenciado através da especificação Reactive Streams, onde o consumer notifica o producer sobre quantos elementos ele consegue processar via o método `request(n)` do `Subscription`. O producer então envia apenas a quantidade solicitada.

O Reactor oferece estratégias para lidar com backpressure:
- **`onBackpressureBuffer`**: Armazena elementos em um buffer até que o consumer esteja pronto. Cuidado: o buffer pode crescer indefinidamente.
- **`onBackpressureDrop`**: Descarta elementos que o consumer não consegue processar.
- **`onBackpressureLatest`**: Mantém apenas o elemento mais recente, descartando os intermediários.
- **`limitRate`**: Limita a taxa de elementos emitidos pelo producer.

**Explicação didática:**
Imagine uma torneira (producer) enchendo um copo (consumer). Se a torneira jorrar água mais rápido do que você consegue beber, a água transborda. Backpressure é o mecanismo que permite ao copo dizer à torneira: "envie água mais devagar" ou "só me dê um gole por vez".

**Exemplo prático:**
Um sistema que lê logs de um servidor de alta frequência (producer muito rápido) e os envia para um banco de dados (consumer mais lento devido a I/O). Sem backpressure, os logs se acumulariam na memória da aplicação até causar um crash.

**Exemplo de código:**
```java
// Producer emitindo muito rápido, consumer processando devagar
Flux<Long> fastProducer = Flux.interval(Duration.ofMillis(1)); // 1 elemento por ms

fastProducer
    .onBackpressureBuffer(1000) // buffer de até 1000 elementos
    .doOnNext(i -> {
        try {
            Thread.sleep(10); // simula processamento lento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    })
    .subscribe();

// Alternativa: descartar elementos excedentes
Flux<Long> producer = Flux.interval(Duration.ofMillis(1));
producer
    .onBackpressureDrop(dropped -> log.warn("Elemento descartado: {}", dropped))
    .subscribe(i -> processarLentamente(i));
```

**Como o candidato deve responder:**
- Definir backpressure como desequilíbrio entre producer e consumer
- Mencionar que o Reactor usa o mecanismo de `request(n)` da Reactive Streams
- Citar pelo menos duas estratégias (buffer, drop, latest, limitRate)
- Dar um exemplo prático de quando backpressure seria problemático
- Evitar confundir backpressure com rate limiting — backpressure é sobre controle de fluxo interno

**Resposta fraca ou incompleta:**
"Backpressure é quando o sistema fica lento." — Incorreto. Backpressure não é sobre lentidão, mas sobre desequilíbrio de velocidade entre producer e consumer.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Qual é a estratégia de backpressure padrão do Reactor quando não especificamos nenhuma?
2. Em que situação `onBackpressureBuffer` seria perigoso?
3. Como o backpressure funciona com `Flux.interval()` em específico?

---

### Pergunta 10 — schedulers e Threads

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
No Project Reactor, o que são `Schedulers` e como eles afetam a execução do pipeline reativo? Explique a diferença entre `publishOn` e `subscribeOn` com um exemplo prático.

**O que essa pergunta avalia:**
Entendimento do modelo de threading do Reactor, conhecimento dos schedulers disponíveis, e capacidade de controlar em qual thread cada parte do pipeline é executada.

**Resposta esperada:**
`Schedulers` no Project Reactor são abstrações sobre thread pools que controlam em qual thread cada parte do pipeline reativo é executada. Por padrão, o Reactor executa o pipeline na mesma thread onde `subscribe()` foi chamado.

Os principais schedulers são:
- **`Schedulers.immediate()`**: Executa na thread atual (padrão).
- **`Schedulers.single()`**: Uma única thread reutilizável.
- **`Schedulers.boundedElastic()`**: Pool de threads adequado para tarefas bloqueantes (I/O). Ideal para integrar com código síncrono.
- **`Schedulers.parallel()`**: Pool de threads otimizado para tarefas CPU-intensivas. Usa um número de threads igual aos núcleos do processador.

**`publishOn`** muda a thread de execução a partir do ponto onde é chamado. Tudo que vem depois no pipeline executa no scheduler especificado.

**`subscribeOn`** afeta a thread onde a assinatura (subscribe) acontece, influenciando onde o producer emite os elementos. Diferente do `publishOn`, afeta todo o pipeline "para cima" (em direção à fonte).

**Explicação didática:**
- `publishOn` é como uma placa na estrada que diz: "a partir daqui, troque de pista". Tudo que vem depois muda de thread.
- `subscribeOn` é como decidir de qual cidade a viagem começa — afeta a origem de tudo.

**Exemplo prático:**
Buscar dados de uma API externa (operação de I/O) deve usar `boundedElastic()` para não bloquear o event loop. Processamento pesado de transformação de dados deve usar `parallel()` para aproveitar múltiplos núcleos.

**Exemplo de código:**
```java
Flux.range(1, 10)
    .map(i -> {
        log.info("Map 1 na thread: {}", Thread.currentThread().getName());
        return i * 2;
    })
    // A partir daqui, muda para boundedElastic
    .publishOn(Schedulers.boundedElastic())
    .map(i -> {
        log.info("Map 2 na thread: {}", Thread.currentThread().getName());
        return i + 1;
    })
    // subscribeOn afeta a origem (onde o Flux.range emite)
    .subscribeOn(Schedulers.parallel())
    .subscribe();

// Resultado:
// Map 1 na thread: parallel-1  (por causa do subscribeOn)
// Map 2 na thread: boundedElastic-1  (por causa do publishOn)
```

**Como o candidato deve responder:**
- Explicar que Schedulers controlam em qual thread o pipeline executa
- Listar os principais schedulers (immediate, single, boundedElastic, parallel)
- Explicar a diferença fundamental: publishOn afeta "para baixo", subscribeOn afeta "para cima"
- Mencionar quando usar cada scheduler (boundedElastic para I/O, parallel para CPU)
- Evitar usar `Schedulers.elastic()` — foi descontinuado em favor de `boundedElastic()`

**Resposta fraca ou incompleta:**
"publishOn e subscribeOn mudam a thread." — Qual thread? Por quê? Falta explicar a direção da influência de cada operador.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. O que acontece se você chamar `publishOn` duas vezes no mesmo pipeline?
2. Qual scheduler você usaria para uma operação de JDBC (banco de dados relacional) em uma aplicação WebFlux?
3. Por que `boundedElastic` é preferível ao antigo `elastic()`?

---

## Parte 2: Spring WebFlux (Perguntas 11–20)

---

### Pergunta 11 — RouterFunction vs @Controller

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
O Spring WebFlux oferece dois modelos para criar endpoints: o modelo baseado em anotações (`@Controller`, `@GetMapping`) e o modelo funcional (`RouterFunction`). Quais são as diferenças entre eles e em quais situações você escolheria cada um?

**O que essa pergunta avalia:**
Conhecimento dos dois estilos de programação suportados pelo WebFlux, capacidade de comparar abordagens declarativa vs funcional, e entendimento dos trade-offs entre conveniência e controle.

**Resposta esperada:**
O Spring WebFlux suporta dois modelos para definir rotas:

**Modelo baseado em anotações (`@Controller`):**
- Usa anotações como `@RestController`, `@GetMapping`, `@PostMapping` para declarar rotas
- É mais familiar para quem já usa Spring MVC
- Menos código boilerplate
- A configuração é declarativa e o Spring faz o roteamento automaticamente
- Mais adequado para a maioria das aplicações CRUD convencionais

**Modelo funcional (`RouterFunction`):**
- Define rotas programaticamente usando uma API fluente
- Oferece maior controle sobre o roteamento e a composição de handlers
- É mais explícito — tudo está visível no código, sem "mágica" de anotações
- Facilita testes unitários isolados das rotas
- Mais adequado para aplicações com lógica de roteamento complexa ou dinâmica

Ambos os modelos são igualmente suportados e podem até coexistir na mesma aplicação. A escolha depende do gosto da equipe e da complexidade do roteamento.

**Explicação didática:**
O modelo anotado é como pedir comida em um restaurante com menu fixo — é rápido, conveniente e você sabe o que esperar. O modelo funcional é como cozinhar em casa com todos os ingredientes disponíveis — você tem controle total, mas precisa escrever mais código.

**Exemplo prático:**
Para uma API REST simples com CRUD de produtos, o modelo anotado é suficiente e mais produtivo. Para uma aplicação que precisa compor rotas dinamicamente com base em configuração externa, o modelo funcional oferece a flexibilidade necessária.

**Exemplo de código:**
```java
// Modelo com anotações (declarativo)
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping("/{id}")
    public Mono<Produto> buscar(@PathVariable String id) {
        return produtoService.findById(id);
    }
}

// Modelo funcional (RouterFunction)
@Configuration
public class ProdutoRouter {

    @Bean
    public RouterFunction<ServerResponse> rota(ProdutoHandler handler) {
        return RouterFunctions.route()
            .GET("/produtos/{id}", handler::buscar)
            .GET("/produtos", handler::listar)
            .POST("/produtos", handler::criar)
            .build();
    }
}

// Handler correspondente
@Component
public class ProdutoHandler {

    private final ProdutoService service;

    public ProdutoHandler(ProdutoService service) {
        this.service = service;
    }

    public Mono<ServerResponse> buscar(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.findById(id)
            .flatMap(produto -> ServerResponse.ok().bodyValue(produto))
            .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> listar(ServerRequest request) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.findAll(), Produto.class);
    }
}
```

**Como o candidato deve responder:**
- Explicar que existem dois modelos suportados pelo WebFlux
- Destacar que o modelo anotado é mais produtivo e familiar
- Explicar que o modelo funcional oferece maior controle e é mais testável
- Mencionar que ambos podem coexistir
- Evitar dizer que um modelo é "melhor" que o outro — são ferramentas diferentes para contextos diferentes

**Resposta fraca ou incompleta:**
"RouterFunction é a forma funcional de criar rotas." — Correto, mas não explica as diferenças práticas, nem quando escolher cada modelo.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Como você testaria um `RouterFunction` isoladamente?
2. É possível usar validação (`@Valid`) com o modelo funcional?
3. Como você organizaria múltiplos `RouterFunction` em uma aplicação grande?

---

### Pergunta 12 — Cold Publisher vs Hot Publisher

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
No Project Reactor, fala-se em "Cold Publishers" e "Hot Publishers". O que são e qual é a diferença prática entre eles? Dê um exemplo de cada um.

**O que essa pergunta avalia:**
Compreensão da diferença entre publishers cold e hot, entendimento do impacto no comportamento do pipeline, e capacidade de identificar quando cada tipo é usado.

**Resposta esperada:**
**Cold Publishers** são aqueles em que cada novo `subscribe()` dispara a execução do pipeline do zero. Cada assinante recebe sua própria sequência independente de dados. A maior parte dos publishers do dia a dia é cold: `Mono.just()`, `Flux.fromIterable()`, resultados de consultas a banco de dados.

**Hot Publishers** são aqueles em que a emissão de dados acontece independentemente de assinantes. Se um assinante se inscreve tarde, ele perde os elementos já emitidos. Representam fontes de dados ao vivo, como eventos de teclado, mensagens de um broker, ou ticks de um relógio.

O Reactor oferece operadores para transformar cold em hot:
- **`share()`**: Compartilha uma única assinatura entre todos os assinantes. O primeiro `subscribe()` inicia a emissão; demais assinantes compartilham o mesmo fluxo.
- **`publish()`**: Similar ao `share()`, mas com mais controle (permite configurar um `ConnectableFlux` que só inicia quando `connect()` é chamado).
- **`cache()`**: Armazena os elementos emitidos para que novos assinantes recebam os valores já computados.

**Explicação didática:**
- **Cold Publisher** é como um filme em streaming: cada pessoa que aperta "play" assiste o filme do começo, independentemente dos outros.
- **Hot Publisher** é como uma transmissão ao vivo: se você sintonizar tarde, perde o que já aconteceu. Não tem replay.

**Exemplo prático:**
Uma consulta ao banco de dados é cold — cada assinante dispara uma nova consulta. Um stream de eventos de um sensor de temperatura é hot — os sensores emitem dados continuamente, independentemente de quem está ouvindo.

**Exemplo de código:**
```java
// Cold Publisher: cada subscribe() executa o pipeline de novo
Flux<Integer> cold = Flux.range(1, 3)
    .doOnSubscribe(s -> System.out.println("Novo subscribe!"));

cold.subscribe(i -> System.out.println("A: " + i));
cold.subscribe(i -> System.out.println("B: " + i));
// Saída: A: 1, A: 2, A: 3, depois "Novo subscribe!" novamente, B: 1, B: 2, B: 3

// Hot Publisher com share(): ambos compartilham o mesmo fluxo
Flux<Long> hot = Flux.interval(Duration.ofMillis(500))
    .share();

hot.subscribe(i -> System.out.println("A: " + i));
Thread.sleep(1200); // espera um pouco
hot.subscribe(i -> System.out.println("B: " + i));
// B perde os primeiros elementos que A já recebeu
// Saída: A: 0, A: 1, A: 2, B: 2, A: 3, B: 3, ...
```

**Como o candidato deve responder:**
- Definir cold: cada subscribe reinicia o pipeline
- Definir hot: a emissão é independente de assinantes
- Mencionar operadores `share()`, `publish()`, `cache()` como conversores
- Dar exemplo prático de cada tipo
- Evitar confundir hot publisher com `Flux.interval()` — `interval()` é cold por padrão, só vira hot com `share()`

**Resposta fraca ou incompleta:**
"Hot publishers emitem dados sem ninguém assinando." — Parcialmente correto, mas incompleto. Não explica o comportamento cold nem como converter entre os tipos.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. O que acontece com o `cache()` se o publisher original for infinito?
2. Qual é a diferença entre `share()` e `publish().refConnect()`?
3. Em que situação converter cold para hot poderia causar bugs sutis?

---

### Pergunta 13 — zip, merge e combineLatest

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
Ao trabalhar com múltiplos publishers no Reactor, como você combinaria os resultados de duas ou mais fontes de dados? Explique os operadores `zip`, `merge` e `combineLatest` e quando usar cada um.

**O que essa pergunta avalia:**
Conhecimento dos operadores de combinação do Reactor, capacidade de orquestrar múltiplas fontes de dados, e entendimento das diferenças de comportamento entre operadores de combinação.

**Resposta esperada:**
Existem vários operadores para combinar publishers no Reactor:

**`zip`**: Combina elementos de múltiplos publishers posição a posição. Espera que ambos emitam o elemento N antes de combinar e emitir o resultado. Se um publisher tiver menos elementos que o outro, o excedente é descartado. É ideal quando você precisa de resultados de múltiplas fontes que devem ser processados juntos.

**`merge`**: Intercala os elementos de múltiplos publishers conforme chegam. Não espera sincronismo — emite elementos na ordem em que cada publisher os produz. É adequado quando a ordem não importa ou quando se quer processar todos os elementos independentemente da fonte.

**`combineLatest`**: Combina os elementos mais recentes de cada publisher. Sempre que qualquer um dos publishers emite um novo valor, combina com o último valor conhecido dos outros. É útil para reagir a mudanças de múltiplas fontes.

**Explicação didática:**
- `zip` é como duas esteiras sincronizadas: você pega um item de cada esteira ao mesmo tempo e junta.
- `merge` é como duas esteiras despejando itens em uma única esteira: os itens se misturam na ordem em que chegam.
- `combineLatest` é como um painel de controle: sempre que um sensor atualiza, o painel combina o valor atual de todos os sensores.

**Exemplo prático:**
Buscar perfil do usuário e suas preferências em paralelo e combinar em um DTO: use `zip`. Receber eventos de múltiplos sensores IoT e processar todos: use `merge`. Monitorar temperatura e umidade e atualizar o display quando qualquer um muda: use `combineLatest`.

**Exemplo de código:**
```java
// zip: combina resultados de duas chamadas paralelas
Mono<Usuario> usuarioMono = usuarioService.findById(1L);
Mono<Preferencias> prefMono = preferenciaService.findByUsuarioId(1L);

Mono<PerfilDTO> perfil = Mono.zip(usuarioMono, prefMono)
    .map(tuple -> new PerfilDTO(tuple.getT1(), tuple.getT2()));
// tuple.getT1() = Usuario, tuple.getT2() = Preferencias

// merge: intercala múltiplos Flux
Flux<String> fluxA = Flux.just("A1", "A2", "A3");
Flux<String> fluxB = Flux.just("B1", "B2", "B3");
Flux<String> combinado = Flux.merge(fluxA, fluxB);
// Saída: A1, A2, A3, B1, B2, B3 (ordem pode variar se assíncrono)

// combineLatest: reage à mudança de qualquer fonte
Flux<Integer> temperatura = Flux.just(20, 22, 25);
Flux<Integer> umidade = Flux.just(60, 55, 50);
Flux<String> display = Flux.combineLatest(
        temperatura, umidade,
        (temp, umid) -> "Temp: " + temp + "°, Umid: " + umid + "%"
);
```

**Como o candidato deve responder:**
- Explicar cada operador com clareza
- Destacar que `zip` aguarda todos os publishers (síncrono na combinação)
- Explicar que `merge` não garante ordem entre publishers
- Mencionar que `combineLatest` reage a qualquer mudança
- Dar exemplos práticos diferenciados para cada operador
- Evitar confundir `merge` com `concat` (que preserva a ordem dos publishers)

**Resposta fraca ou incompleta:**
"zip junta dois fluxos." — Vago. Não explica como junta (posição a posição), nem menciona os outros operadores.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Qual é a diferença entre `merge` e `concat`? Quando a ordem importa?
2. O que acontece se um dos publishers no `zip` emitir um erro?
3. Como você faria três chamadas HTTP em paralelo e combinar os resultados?

---

### Pergunta 14 — doOnNext, doOnError e operadores de side-effect

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
No Project Reactor, os operadores `doOnNext`, `doOnError`, `doOnSuccess`, `doOnSubscribe` e `doFinally` são chamados de "operadores de side-effect". O que são side-effects em um pipeline reativo e como esses operadores devem ser usados?

**O que essa pergunta avalia:**
Conhecimento dos operadores de side-effect do Reactor, entendimento de quando usar logging/monitoramento dentro do pipeline, e capacidade de diferenciar side-effects legítimos de práticas que quebram a pureza do pipeline.

**Resposta esperada:**
Side-effects (efeitos colaterais) em um pipeline reativo são ações que ocorrem "ao longo do caminho" sem modificar o fluxo de dados. Eles não transformam nem filtram elementos — apenas executam uma ação quando um evento específico acontece no pipeline.

Os principais operadores de side-effect são:

- **`doOnNext`**: Executa uma ação para cada elemento emitido. Usado para logging, métricas ou auditoria de cada item processado.
- **`doOnError`**: Executa uma ação quando um erro ocorre. Ideal para logar exceções ou registrar métricas de falha.
- **`doOnSuccess`**: Executa uma ação quando um `Mono` completa com sucesso (com valor ou vazio). É o equivalente do `doOnNext` para `Mono` que emite um único valor.
- **`doOnSubscribe`**: Executa uma ação quando alguém assina o publisher. Útil para registrar o início de uma operação.
- **`doFinally`**: Executa uma ação quando o pipeline termina, seja por sucesso, erro ou cancelamento. Ideal para limpeza de recursos.

**Explicação didática:**
Os operadores `doOn*` são como câmeras de segurança em uma fábrica: elas observem o processo, registram o que acontece, mas não interferem na produção.

**Exemplo prático:**
Em um pipeline que processa pedidos, você usa `doOnNext` para logar cada pedido processado, `doOnError` para registrar falhas em um sistema de monitoramento, e `doFinally` para liberar recursos (como fechar uma conexão) independentemente do resultado.

**Exemplo de código:**
```java
public Mono<Pedido> processarPedido(String id) {
    return pedidoService.findById(id)
        .doOnSubscribe(s -> log.info("Iniciando processamento do pedido {}", id))
        .doOnNext(pedido -> {
            log.info("Pedido encontrado: {}", pedido.getId());
            metricas.registrarPedidoProcessado();
        })
        .map(this::calcularTotal)
        .doOnNext(pedido -> log.info("Total calculado: {}", pedido.getTotal()))
        .doOnError(e -> {
            log.error("Erro ao processar pedido {}", id, e);
            metricas.registrarFalha();
        })
        .doFinally(signal -> log.info("Processamento finalizado: {}", signal));
        // signal pode ser: ON_COMPLETE, ON_ERROR, CANCEL
}
```

**Como o candidato deve responder:**
- Explicar que side-effects não alteram o fluxo de dados, apenas observam
- Citar pelo menos três operadores `doOn*` e seus gatilhos
- Mencionar que `doFinally` é ideal para limpeza de recursos
- Explicar que esses operadores não devem conter lógica de negócio complexa
- Evitar usar `doOnNext` para fazer chamadas reativas — para isso, use `flatMap`

**Resposta fraca ou incompleta:**
"doOnNext serve para logar." — Correto, mas muito limitado. Não menciona os outros operadores, nem explica que side-effects não alteram o fluxo.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Por que não devemos fazer chamadas reativas dentro de `doOnNext`?
2. Qual é a diferença entre `doFinally` e `doOnComplete`?
3. Como você garantiria que um `doOnError` não mascara o erro original?

---

### Pergunta 15 — Timeout em pipelines reativos

**Nível:** Júnior
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**
Em uma aplicação WebFlux que faz chamadas a serviços externos, como você implementaria controle de timeout? Qual operador você usaria e o que acontece quando o timeout é atingido?

**O que essa pergunta avalia:**
Conhecimento do operador `timeout`, capacidade de proteger a aplicação contra chamadas que demoram demais, e entendimento das consequências do timeout no pipeline reativo.

**Resposta esperada:**
O Reactor oferece o operador `timeout()` que encerra o publisher se um elemento não for emitido dentro de um período especificado. Quando o timeout é atingido, o publisher emite um sinal de erro do tipo `TimeoutException`.

Formas de usar o timeout:

1. **`timeout(Duration)`**: Se nenhum elemento for emitido no período especificado, lança `TimeoutException`.
2. **`timeout(Duration, Mono<T> fallback)`**: Igual ao anterior, mas em vez de lançar erro, emite o publisher de fallback.

É importante combinar timeout com tratamento de erro (`onErrorResume`) para fornecer uma resposta adequada ao cliente quando o timeout ocorre.

Também é possível configurar timeout no nível do `WebClient` usando `HttpClient` com timeout de resposta, conexão e leitura.

**Explicação didática:**
`timeout` é como um cronômetro que dispara se a resposta demorar demais. Sem ele, sua aplicação pode ficar esperando indefinidamente por um serviço que travou, consumindo recursos desnecessariamente.

**Exemplo prático:**
Um serviço de pagamentos chama uma API externa de cartão de crédito. Se a API não responder em 5 segundos, o sistema deve cancelar a operação e retornar uma mensagem de "timeout, tente novamente" para o usuário.

**Exemplo de código:**
```java
// Operador timeout simples
public Mono<Resposta> chamarApi() {
    return webClient.get()
        .uri("/api/servico")
        .retrieve()
        .bodyToMono(Resposta.class)
        .timeout(Duration.ofSeconds(5)) // lança TimeoutException
        .onErrorResume(TimeoutException.class, e -> {
            log.warn("Timeout ao chamar serviço externo");
            return Mono.just(new Resposta("timeout"));
        });
}

// Timeout com fallback direto
public Mono<Produto> buscarProduto(String id) {
    return produtoService.findById(id)
        .timeout(Duration.ofSeconds(3), Mono.just(produtoPadrao()));
        // Se passar de 3s, retorna produtoPadrao() em vez de erro
}

// Configuração de timeout no WebClient
@Bean
public WebClient webClient() {
    HttpClient httpClient = HttpClient.create()
        .responseTimeout(Duration.ofSeconds(5));

    return WebClient.builder()
        .clientConnector(new ReactorClientHttpConnector(httpClient))
        .baseUrl("http://api.exemplo.com")
        .build();
}
```

**Como o candidato deve responder:**
- Explicar o operador `timeout()` e seu comportamento
- Mencionar que o timeout emite `TimeoutException`
- Explicar a versão com fallback como alternativa ao erro
- Citar a configuração de timeout no nível do WebClient/HttpClient
- Combinar timeout com `onErrorResume` para tratamento adequado
- Evitar confundir `timeout` com `delay` (que propositalmente espera)

**Resposta fraca ou incompleta:**
"Usa-se timeout para limitar o tempo." — Não explica como funciona, qual operador usar, nem o que acontece quando o timeout é atingido.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Qual é a diferença entre timeout no operador `timeout()` e timeout no `HttpClient`?
2. Como você diferenciaria um timeout de conexão de um timeout de leitura?
3. Se você tem três chamadas em sequência com `flatMap`, o timeout se aplica ao total ou a cada chamada individualmente?

---

### Pergunta 16 — Debugging de pipelines reativos

**Nível:** Júnior
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**
Depurar pipelines reativos pode ser mais difícil que depurar código imperativo, pois o fluxo de execução não é linear. Quais ferramentas e técnicas o Project Reactor oferece para facilitar o debugging?

**O que essa pergunta avalia:**
Conhecimento das ferramentas de diagnóstico do Reactor, capacidade de identificar problemas em pipelines reativos, e entendimento das diferenças entre debugging reativo e imperativo.

**Resposta esperada:**
O debugging de pipelines reativos é desafiador porque os stack traces tradicionais não mostram a origem do problema — eles mostram a thread do event loop, não onde o operador foi declarado. O Reactor oferece várias ferramentas:

1. **`Hooks.onOperatorDebug()`**: Ativa o "assembly tracking", que enriquece os stack traces com informações sobre onde cada operador foi declarado. Útil em desenvolvimento, mas tem custo de performance — não deve ser usado em produção.

2. **`checkpoint()`**: Adiciona um ponto de rastreamento no pipeline. Quando um erro ocorre, o stack trace inclui a descrição do checkpoint. É mais leve que `onOperatorDebug()` e pode ser usado em produção.

3. **`log()`**: Operador que loga todos os sinais do pipeline (onNext, onComplete, onError, subscribe). É extremamente útil para ver o que está acontecendo em cada etapa. O log inclui o nome da thread e o sinal.

4. **`Flux.deferContextual` / `Context`**: Permite propagar metadados (como correlation IDs) através do pipeline, facilitando o rastreamento de requisições.

**Explicação didática:**
Em código imperativo, o stack trace é como um rastro de pegadas mostrando exatamente o caminho percorrido. Em código reativo, as pegadas somem porque a execução salta entre threads. As ferramentas do Reactor adicionam "marcadores" nessas pegadas para você conseguir segui-las.

**Exemplo prático:**
Um pipeline está falhando silenciosamente sem stack trace útil. Adicionar `log()` em pontos estratégicos revela em qual operador o erro ocorre. `checkpoint()` adiciona contexto ao erro.

**Exemplo de código:**
```java
// Usando log() para diagnosticar
public Mono<Produto> diagnosticar(String id) {
    return produtoRepository.findById(id)
        .log("antes-map")          // loga todos os sinais neste ponto
        .map(this::transformar)
        .log("depois-map")          // loga sinais após transformação
        .filter(Produto::isAtivo)
        .log("apos-filter");
}

// Usando checkpoint() para rastrear origem de erros
public Mono<Produto> buscar(String id) {
    return produtoRepository.findById(id)
        .checkpoint("busca-produto-por-id")
        .map(this::transformar)
        .checkpoint("transformacao-produto");
    // Se erro ocorrer, o stack trace incluirá os nomes dos checkpoints
}

// Hooks em ambiente de desenvolvimento
// Na inicialização da aplicação (somente dev):
Hooks.onOperatorDebug();
```

**Como o candidato deve responder:**
- Explicar que debugging reativo é diferente por causa da assincronicidade
- Citar pelo menos três ferramentas: `log()`, `checkpoint()`, `Hooks.onOperatorDebug()`
- Explicar que `onOperatorDebug()` é pesado e só deve ser usado em dev
- Mencionar que `log()` é a ferramenta mais prática para diagnóstico rápido
- Evitar sugerir `System.out.println` dentro de `doOnNext` como estratégia principal

**Resposta fraca ou incompleta:**
"Para debugar, pode usar log ou println." — Muito superficial. Não menciona as ferramentas específicas do Reactor nem suas diferenças.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Por que `Hooks.onOperatorDebug()` não deve ser usado em produção?
2. Como você correlacionaria logs de diferentes partes de um pipeline assíncrono?
3. O que acontece se você adicionar `log()` em um `Flux` que emite milhares de elementos?

---

### Pergunta 17 — R2DBC vs JDBC em aplicações WebFlux

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
Em uma aplicação Spring WebFlux, qual driver de banco de dados você usaria: R2DBC ou JDBC? Qual é a diferença fundamental entre os dois e por que isso importa no contexto reativo?

**O que essa pergunta avalia:**
Conhecimento das opções de acesso a banco de dados em aplicações reativas, compreensão da diferença entre drivers bloqueantes e não-bloqueantes, e entendimento do impacto da escolha na arquitetura.

**Resposta esperada:**
**JDBC** é o padrão tradicional de acesso a bancos de dados relacionais em Java. É síncrono e bloqueante: cada chamada ao banco bloqueia a thread atual até a resposta voltar. Em uma aplicação WebFlux, usar JDBC diretamente bloqueia o event loop, o que derrota o propósito do modelo reativo.

**R2DBC** (Reactive Relational Database Connectivity) é a especificação reativa para acesso a bancos de dados relacionais. É non-blocking: retorna `Mono` e `Flux`, integrando-se naturalmente ao pipeline reativo sem bloquear threads.

Diferenças fundamentais:

| Aspecto | JDBC | R2DBC |
|---------|------|-------|
| Modelo | Síncrono/bloqueante | Assíncrono/non-blocking |
| Retorno | Objetos diretos | `Mono`/`Flux` |
| Threads | Bloqueia a thread | Não bloqueia |
| Integração WebFlux | Precisa de `boundedElastic` | Natural |
| Maturidade | Muito maduro | Em evolução |

Se for necessário usar JDBC em uma aplicação WebFlux (por exemplo, por restrições de biblioteca), deve-se usar `Schedulers.boundedElastic()` para mover a operação bloqueante para uma thread separada, evitando bloquear o event loop.

**Explicação didática:**
JDBC é como um telefone fixo: você atende, conversa e fica preso até a ligação terminar. R2DBC é como um messenger: você envia a mensagem e continua fazendo outras coisas, a resposta chega como notificação.

**Exemplo prático:**
Em uma aplicação WebFlux com PostgreSQL, usar R2DBC (`spring-boot-starter-data-r2dbc`) permite que as consultas ao banco sejam non-blocking. Se a aplicação precisar usar JDBC por compatibilidade, as operações devem ser encapsuladas em `subscribeOn(Schedulers.boundedElastic())`.

**Exemplo de código:**
```java
// R2DBC: naturalmente reativo, retorna Mono/Flux
public interface ProdutoRepository extends ReactiveCrudRepository<Produto, String> {
    Flux<Produto> findByCategoria(String categoria);
}

// Uso no service (totalmente reativo)
public Flux<Produto> listarPorCategoria(String categoria) {
    return produtoRepository.findByCategoria(categoria);
}

// JDBC em aplicação WebFlux: precisa de schedulers
public Mono<Produto> buscarJdbc(String id) {
    return Mono.fromCallable(() -> {
            // JDBC bloqueante dentro de callable
            return jdbcTemplate.queryForObject(
                "SELECT * FROM produtos WHERE id = ?",
                produtoRowMapper, id
            );
        })
        .subscribeOn(Schedulers.boundedElastic()); // move para thread dedicada
}
```

**Como o candidato deve responder:**
- Explicar que JDBC é bloqueante e R2DBC é não-bloqueante
- Mencionar que usar JDBC em WebFlux sem `boundedElastic` bloqueia o event loop
- Citar que R2DBC retorna `Mono`/`Flux` naturalmente
- Explicar a alternativa de usar JDBC com `subscribeOn(boundedElastic)` quando necessário
- Mencionar que R2DBC é menos maduro que JDBC, mas é a escolha correta para WebFlux

**Resposta fraca ou incompleta:**
"R2DBC é o JDBC reativo." — Simplório. Não explica a diferença fundamental de bloqueio nem o impacto no event loop.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. R2DBC suporta transações? Como elas funcionam de forma reativa?
2. O que é `DatabaseClient` no Spring Data R2DBC?
3. Como você migraria gradualmente uma aplicação de JDBC para R2DBC?

---

### Pergunta 18 — Tratamento de erros com @ExceptionHandler

**Nível:** Júnior
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**
Além dos operadores de erro do Reactor, como você implementa tratamento de erros global em uma aplicação Spring WebFlux? Como o `@ExceptionHandler` funciona no contexto reativo?

**O que essa pergunta avalia:**
Conhecimento das estratégias de tratamento de erro no nível do controller/spring, capacidade de implementar respostas de erro padronizadas, e entendimento da integração entre Spring e Reactor no tratamento de exceções.

**Resposta esperada:**
O Spring WebFlux suporta `@ExceptionHandler` e `@ControllerAdvice` de forma similar ao Spring MVC, mas com uma diferença importante: os métodos de tratamento devem retornar `Mono<ResponseEntity>` ou `Mono<ErrorResponseDTO>` para manter a natureza reativa.

Estratégias de tratamento global:

1. **`@ExceptionHandler` no controller**: Trata exceções específicas dentro de um controller individual.
2. **`@ControllerAdvice` global**: Trata exceções em todos os controllers da aplicação. É a abordagem mais recomendada para padronizar respostas de erro.
3. **`WebExceptionHandler`**: Interface de baixo nível para tratamento de erros no nível do web server, útil para customização avançada.

Quando uma exceção é lançada dentro de um pipeline reativo (e não tratada por `onErrorResume`), ela se propaga para o framework, que a captura e direciona para o `@ExceptionHandler` correspondente.

**Explicação didática:**
Os operadores `onErrorResume` e `onErrorReturn` tratam erros "dentro" do pipeline — como um primeiros socorros local. O `@ExceptionHandler` e `@ControllerAdvice` são o "hospital" — onde erros não tratados localmente chegam para receber tratamento padronizado.

**Exemplo prático:**
Uma API que lança `ProdutoNotFoundException` quando um produto não existe. O `@ControllerAdvice` captura essa exceção e retorna um `404 NOT FOUND` com um corpo JSON padronizado contendo código de erro e mensagem.

**Exemplo de código:**
```java
// DTO de erro padronizado
public record ErrorResponse(String code, String message, LocalDateTime timestamp) {}

// ControllerAdvice global
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNotFoundException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleNotFound(ProdutoNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
            "PRODUTO_NAO_ENCONTRADO",
            ex.getMessage(),
            LocalDateTime.now()
        );
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(error));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleBadRequest(IllegalArgumentException ex) {
        ErrorResponse error = new ErrorResponse(
            "ARGUMENTO_INVALIDO",
            ex.getMessage(),
            LocalDateTime.now()
        );
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error));
    }

    // Fallback para exceções não mapeadas
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorResponse>> handleGeneric(Exception ex) {
        ErrorResponse error = new ErrorResponse(
            "ERRO_INTERNO",
            "Ocorreu um erro inesperado",
            LocalDateTime.now()
        );
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error));
    }
}

// Exceção de domínio
public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(String id) {
        super("Produto não encontrado: " + id);
    }
}

// Uso no service: a exceção se propaga para o ControllerAdvice
public Mono<Produto> buscar(String id) {
    return produtoRepository.findById(id)
        .switchIfEmpty(Mono.error(new ProdutoNotFoundException(id)));
}
```

**Como o candidato deve responder:**
- Explicar que `@ControllerAdvice` funciona no WebFlux de forma similar ao MVC
- Destacar que os métodos devem retornar `Mono<ResponseEntity<...>>`
- Mencionar o uso de `switchIfEmpty(Mono.error(...))` para lançar exceções quando não há resultado
- Explicar a diferença entre tratar erro no pipeline (`onErrorResume`) vs no controller (`@ExceptionHandler`)
- Apresentar uma estrutura de resposta de erro padronizada
- Evitar retornar `ResponseEntity` diretamente sem `Mono`

**Resposta fraca ou incompleta:**
"Usa-se @ControllerAdvice para tratar erros." — Não explica como isso funciona no contexto reativo, nem menciona que os métodos devem retornar `Mono`.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Como você trataria erros de validação (`@Valid`) no WebFlux?
2. Qual é a diferença entre `WebExceptionHandler` e `@ControllerAdvice`?
3. Como você garantiria que erros não tratados nunca chegassem ao cliente como stack trace?

---

### Pergunta 19 — Thread Safety e estado compartilhado

**Nível:** Júnior
**Categoria:** Boas práticas

**Pergunta do entrevistador:**
Em uma aplicação Spring WebFlux, precisamos nos preocupar com thread safety? O que pode acontecer se compartilharmos estado mutável entre diferentes partes de um pipeline reativo? Como lidar com isso?

**O que essa pergunta avalia:**
Compreensão do modelo de concorrência do WebFlux, conhecimento dos riscos de estado mutável compartilhado, e capacidade de identificar e evitar problemas de concorrência em pipelines reativos.

**Resposta esperada:**
Sim, thread safety é uma preocupação em aplicações WebFlux, mas o contexto é diferente do Spring MVC. No WebFlux, o pipeline pode ser executado em múltiplas threads ao longo do seu ciclo de vida (especialmente com `publishOn` e `subscribeOn`), então o estado mutável compartilhado entre operadores pode causar race conditions.

Principais riscos:
1. **Variáveis mutáveis compartilhadas**: Se um `map` ou `doOnNext` modifica uma variável externa, e o pipeline muda de thread entre operadores, a modificação pode não ser visível para a próxima thread.
2. **Coleções não thread-safe**: Usar `ArrayList` ou `HashMap` compartilhado entre operadores pode causar corrupção de dados.
3. **Side-effects que modificam estado externo**: Como `doOnNext` executa em diferentes threads, modificar estado externo é arriscado.

Soluções:
- **Preferir imutabilidade**: Passar dados imutáveis pelo pipeline evita a maioria dos problemas.
- **Usar `Context` do Reactor**: Para propagar dados seguros entre operadores sem variáveis externas.
- **Usar estruturas thread-safe**: `AtomicInteger`, `ConcurrentHashMap`, `CopyOnWriteArrayList` quando compartilhamento for inevitável.
- **Evitar estado mutável em operadores**: Não modificar variáveis externas dentro de `map`, `filter`, etc.

**Explicação didática:**
No Spring MVC, cada requisição tem sua própria thread, e geralmente você não compartilha estado entre requisições. No WebFlux, um único pipeline pode passar por várias threads, como uma carta que passa por vários carteiros. Se um carteiro anota algo na carta, o próximo carteiro precisa ver a mesma versão — se não houver sincronização, pode haver desalinhamento.

**Exemplo prático:**
Um contador de requisições que usa `doOnNext` para incrementar uma variável `int` comum é perigoso porque múltiplas threads podem incrementar simultaneamente, perdendo atualizações. Usar `AtomicInteger` resolve o problema.

**Exemplo de código:**
```java
// ❌ ERRADO: estado mutável não thread-safe
private int contador = 0; // NÃO FAÇA ISSO

public Mono<Produto> processar(Produto p) {
    return Mono.just(p)
        .doOnNext(produto -> {
            contador++; // race condition: múltiplas threads podem modificar
        })
        .map(Produto::processar);
}

// ✅ CORRETO: estrutura thread-safe
private AtomicInteger contador = new AtomicInteger(0);

public Mono<Produto> processar(Produto p) {
    return Mono.just(p)
        .doOnNext(produto -> {
            contador.incrementAndGet(); // operação atômica
        })
        .map(Produto::processar);
}

// ✅ MELHOR: evitar estado mutável usando Context
public Mono<Produto> processar(Produto p) {
    return Mono.just(p)
        .flatMap(produto -> {
            return Mono.deferContextual(ctx -> {
                String correlationId = ctx.get("correlationId");
                log.info("Processando produto com correlation: {}", correlationId);
                return Mono.just(produto.processar());
            });
        });
}
```

**Como o candidato deve responder:**
- Explicar que pipelines reativos podem executar em múltiplas threads
- Mencionar que estado mutável compartilhado causa race conditions
- Citar soluções: imutabilidade, estruturas thread-safe, Context do Reactor
- Explicar que `publishOn` e `subscribeOn` mudam a thread, aumentando o risco
- Evitar dizer que "não há problemas de concorrência no WebFlux" — eles existem, só em contextos diferentes

**Resposta fraca ou incompleta:**
"WebFlux é single-thread, então não há problemas de concorrência." — Incorreto. O WebFlux usa múltiplas threads (event loop + schedulers), e o pipeline pode trocar de thread durante a execução.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. O que é o `Context` do Reactor e como ele difere de `ThreadLocal`?
2. Por que `ThreadLocal` não funciona bem em pipelines reativos?
3. Como você testaria race conditions em um pipeline reativo?

---

### Pergunta 20 — StepVerifier: testes de pipelines reativos

**Nível:** Júnior
**Categoria:** Testes

**Pergunta do entrevistador:**
Como você escreve testes unitários para pipelines reativos no Spring WebFlux? O que é o `StepVerifier` e por que ele é necessário em vez de simplesmente chamar `subscribe()` e verificar o resultado?

**O que essa pergunta avalia:**
Conhecimento da ferramenta padrão para testes reativos, capacidade de escrever testes válidos para pipelines assíncronos, e entendimento de por que técnicas de teste imperativas não funcionam com publishers.

**Resposta esperada:**
`StepVerifier` é a ferramenta do Project Reactor para testar pipelines reativos de forma declarativa. Ele permite verificar passo a passo os sinais emitidos por um publisher (onNext, onComplete, onError) e assertar sobre cada um.

Por que não usar `subscribe()` diretamente:
1. `subscribe()` é assíncrono — o teste pode terminar antes do pipeline completar
2. Não há controle sobre a ordem e o momento das emissões
3. Não é possível assertar sobre sinais específicos (complete, error)
4. Exceções dentro do pipeline não falham o teste automaticamente

O `StepVerifier` resolve esses problemas fornecendo uma API fluente que:
- **Verifica cada elemento emitido** com `expectNext()`
- **Verifica a conclusão** com `verifyComplete()`
- **Verifica erros** com `verifyError()` ou `expectError()`
- **Verifica ausência de emissão** com `expectNoEvent()`
- **Simula passagem de tempo** com `VirtualTimeScheduler` para testar timeouts e delays

**Explicação didática:**
Testar com `subscribe()` é como tentar fotografar um raio: você não sabe quando vai acontecer, e quando percebe, já passou. O `StepVerifier` é como uma câmera de alta velocidade que captura cada momento do pipeline, permitindo que você analise cada frame.

**Exemplo prático:**
Testar um serviço que busca um usuário por ID. O teste verifica que o `Mono` emite exatamente um usuário com os dados esperados e então completa. Também testa o cenário de erro: quando o ID não existe, o `Mono` emite um erro de `ProdutoNotFoundException`.

**Exemplo de código:**
```java
class ProdutoServiceTest {

    @Test
    void deveBuscarProdutoPorId() {
        Produto produto = new Produto("1", "Notebook", 2500.0);
        when(repository.findById("1")).thenReturn(Mono.just(produto));

        StepVerifier.create(service.findById("1"))
            .expectNextMatches(p -> {
                assertEquals("Notebook", p.getNome());
                assertEquals(2500.0, p.getPreco());
                return true;
            })
            .verifyComplete(); // verifica que o Mono completa após emitir
    }

    @Test
    void deveRetornarVazioQuandoProdutoNaoExiste() {
        when(repository.findById("999")).thenReturn(Mono.empty());

        StepVerifier.create(service.findById("999"))
            .verifyComplete(); // Mono completa sem emitir nenhum elemento
    }

    @Test
    void deveLancarErroQuandoBancoFalha() {
        when(repository.findById("1"))
            .thenReturn(Mono.error(new RuntimeException("Falha de conexão")));

        StepVerifier.create(service.findById("1"))
            .expectError(RuntimeException.class)
            .verify();
    }

    // Teste com manipulação de tempo (timeout)
    @Test
    void deveAplicarTimeout() {
        StepVerifier.withVirtualTime(() ->
                service.buscarComTimeout("1")
                    .timeout(Duration.ofSeconds(5))
        )
        .expectSubscription()
        .thenAwait(Duration.ofSeconds(6)) // avança o tempo virtual
        .expectError(TimeoutException.class)
        .verify();
    }
}
```

**Como o candidato deve responder:**
- Explicar que `StepVerifier` é a ferramenta padrão para testes reativos
- Mencionar que `subscribe()` não é adequado porque é assíncrono
- Demonstrar o uso de `expectNext`, `verifyComplete`, `expectError`
- Mencionar `VirtualTimeScheduler` para testes que envolvem tempo
- Explicar a diferença entre `expectNext` (verifica igualdade) e `expectNextMatches` (verifica com predicado)
- Evitar chamar `block()` nos testes — o `StepVerifier` já gerencia a assinatura

**Resposta fraca ou incompleta:**
"Usa-se StepVerifier para testar." — Não explica por que é necessário, nem demonstra como utilizá-lo.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Demonstra conhecimento muito superficial
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes
- 3 — Responde corretamente aos fundamentos
- 4 — Demonstra bom domínio prático e apresenta exemplos
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real

**Perguntas de aprofundamento:**
1. Como você testaria um `Flux` que emite 1000 elementos?
2. Qual é a diferença entre `verifyComplete()` e `verify()`?
3. Como você testaria um pipeline que usa `retry` com backoff?

---

