

## Pergunta 9 — API REST bem projetada

**Nível:** Júnior  
**Categoria:** APIs e integração

**Pergunta do entrevistador:**  
Quais características você consideraria ao criar uma API REST para um serviço Java?

**O que essa pergunta avalia:**  
Avalia a capacidade de estruturar endpoints claros, utilizar HTTP corretamente e tratar erros de maneira consistente.

**Resposta esperada:**  
Uma API REST deve considerar:

- Recursos e URLs coerentes;
- Uso adequado dos métodos HTTP;
- Status codes apropriados;
- Validação de entrada;
- Contratos de request e response;
- Paginação em listas;
- Tratamento padronizado de erros;
- Autenticação e autorização;
- Versionamento quando necessário;
- Idempotência em operações apropriadas;
- Observabilidade e rastreabilidade.

Exemplos de métodos:

- `GET` para consulta;
- `POST` para criação ou processamento;
- `PUT` para substituição;
- `PATCH` para alteração parcial;
- `DELETE` para remoção.

**Explicação didática:**  
Uma API não deve retornar sempre HTTP 200 com uma mensagem de erro no corpo. O status precisa ajudar o consumidor a compreender o resultado.

Exemplos:

- `201 Created` para criação bem-sucedida;
- `400 Bad Request` para entrada inválida;
- `401 Unauthorized` quando falta autenticação;
- `403 Forbidden` quando o usuário não tem permissão;
- `404 Not Found` quando o recurso não existe;
- `409 Conflict` em conflitos de estado;
- `500 Internal Server Error` para falhas inesperadas.

**Como o candidato deve responder:**

- Explique recursos e verbos HTTP;
- Mencione validação e contratos;
- Relacione erros a status codes;
- Considere segurança e observabilidade;
- Apresente um exemplo de endpoint realista.

**Resposta fraca ou incompleta:**  
“Eu criaria um controller com endpoints e retornaria sempre o status 200.”

Essa abordagem dificulta o tratamento de erros e a integração por outros sistemas.

**Critérios de avaliação:**

- **0** — Não conhece os fundamentos de REST.
- **1** — Confunde verbos e respostas HTTP.
- **2** — Conhece endpoints básicos, mas ignora contratos e erros.
- **3** — Estrutura uma API simples corretamente.
- **4** — Considera validação, segurança, paginação e erros.
- **5** — Discute idempotência, versionamento, compatibilidade, observabilidade e evolução de contratos.

**Perguntas de aprofundamento:**

1. Quando utilizaria `409 Conflict`?
2. Como manteria compatibilidade ao alterar o contrato de uma API?
3. Como evitaria que mensagens de erro expusessem detalhes internos?

---

## Pergunta 10 — Testes unitários e testes de integração

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Qual é a diferença entre um teste unitário e um teste de integração em uma aplicação Spring Boot?

**O que essa pergunta avalia:**  
Avalia se o candidato sabe escolher o nível adequado de teste e equilibrar velocidade, isolamento e realismo.

**Resposta esperada:**  
Um teste unitário verifica uma unidade pequena de comportamento, geralmente uma classe ou método, isolando dependências por meio de mocks ou fakes.

Um teste de integração verifica a interação entre componentes reais, como:

- Aplicação e banco de dados;
- Controller e camada de serviço;
- Serviço e broker;
- Aplicação e cliente HTTP;
- Configuração do Spring e seus beans.

Testes unitários costumam ser rápidos e numerosos. Testes de integração são mais realistas, mas geralmente mais lentos e dependentes de infraestrutura.

Uma boa estratégia combina os dois tipos.

**Explicação didática:**  
Um teste unitário de um serviço pode simular o repositório e verificar uma regra de negócio.

Já um teste de integração pode iniciar parte do contexto da aplicação e utilizar um banco temporário para confirmar se a consulta e o mapeamento funcionam juntos.

Não é suficiente verificar apenas se o código compila. Também é necessário testar:

- Cenários de sucesso;
- Entradas inválidas;
- Falhas de dependências;
- Regras de autorização;
- Comportamentos importantes para o negócio.

**Exemplo prático:**

~~~java
@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private PedidoService service;

    @Test
    void deveRetornarPedidoExistente() {
        Pedido pedido = new Pedido(1L);

        when(repository.findById(1L))
                .thenReturn(Optional.of(pedido));

        Pedido resultado = service.buscar(1L);

        assertEquals(pedido, resultado);
        verify(repository).findById(1L);
    }
}
~~~

O teste isola o serviço e simula o comportamento do repositório.

**Como o candidato deve responder:**

- Diferencie isolamento de integração real;
- Explique quando usar mocks;
- Mencione cenários de erro;
- Relacione testes ao risco do sistema;
- Evite afirmar que uma aplicação precisa ter apenas testes unitários.

**Resposta fraca ou incompleta:**  
“Teste unitário testa o método e teste de integração testa a aplicação inteira.”

Essa definição é simplificada demais e não explica o objetivo nem o nível de isolamento de cada teste.

**Critérios de avaliação:**

- **0** — Não diferencia os tipos de teste.
- **1** — Confunde mock com integração real.
- **2** — Conhece a diferença, mas não sabe quando aplicar cada tipo.
- **3** — Explica corretamente testes unitários e de integração.
- **4** — Considera cenários de erro, dependências e custo de execução.
- **5** — Propõe uma estratégia equilibrada com contratos, testes de componentes, ambientes efêmeros e foco baseado em risco.

**Perguntas de aprofundamento:**

1. O que não deveria ser mockado em um teste de integração?
2. Como testaria o comportamento quando o banco estivesse indisponível?
3. Como evitaria que uma suíte de testes ficasse lenta e instável?

---

## Resumo desta parte

- **Perguntas apresentadas:** 1 a 10
- **Perguntas restantes:** 11 a 100
- **Níveis abordados nesta parte:** Júnior
- **Categorias:** Java, orientação a objetos, coleções, exceções, Spring, persistência, APIs e testes
- **Competências avaliadas:** fundamentos da linguagem, organização de código, tratamento de erros, uso de dependências, transações, desenho de APIs e estratégia inicial de testes

A próxima parte continuará com as perguntas **11 a 20**, avançando para Java intermediário, Spring Boot, bancos de dados, mensageria e integração entre serviços.

---

`markdown
# Roteiro de Entrevista Técnica — Java e Engenharia de Software

> **Parte 2 de 10 — Perguntas 11 a 20 de 100**

**Objetivo:** preparação para uma posição de Desenvolvedor(a) Java Sênior/Especialista, com foco em microsserviços, mensageria, bancos de dados, observabilidade, nuvem, arquitetura, boas práticas e didática técnica.

**Níveis abordados nesta parte:** Júnior e Pleno  
**Estilo:** perguntas conceituais, práticas e baseadas em cenários reais

---

## Pergunta 11 — Streams e operações funcionais

**Nível:** Júnior  
**Categoria:** Java e programação funcional

**Pergunta do entrevistador:**  
Como você utilizaria a Stream API para filtrar, transformar e agrupar dados em Java? Quais cuidados teria ao utilizá-la?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre operações funcionais, legibilidade, processamento de coleções e efeitos colaterais.

**Resposta esperada:**  
A Stream API permite processar coleções de forma declarativa. As operações mais comuns são:

- `filter`, para selecionar elementos;
- `map`, para transformar elementos;
- `sorted`, para ordenar;
- `distinct`, para remover duplicidades;
- `collect`, para materializar o resultado;
- `groupingBy`, para agrupar dados;
- `reduce`, para combinar valores.

As operações intermediárias são normalmente avaliadas de forma lazy, ou seja, só são executadas quando uma operação terminal é chamada.

É importante evitar efeitos colaterais dentro da stream, principalmente alterações em variáveis externas.

**Exemplo prático:**

~~~java
Map<String, Long> quantidadePorStatus = pedidos.stream()
        .filter(Pedido::ativo)
        .collect(Collectors.groupingBy(
                Pedido::status,
                Collectors.counting()
        ));
~~~

Nesse exemplo, pedidos inativos são ignorados e os demais são agrupados por status.

**Como o candidato deve responder:**

- Explique a diferença entre operações intermediárias e terminais;
- Apresente um exemplo de `filter`, `map` ou `groupingBy`;
- Mencione legibilidade e efeitos colaterais;
- Evite usar streams apenas para substituir qualquer `for`;
- Comente que uma solução simples pode ser melhor em alguns casos.

**Resposta fraca ou incompleta:**  
“Stream serve para deixar qualquer código mais rápido.”

Streams podem melhorar a expressividade, mas não garantem ganho de desempenho e podem até dificultar a leitura quando usadas em excesso.

**Critérios de avaliação:**

- **0** — Não conhece a Stream API.
- **1** — Conhece apenas a sintaxe superficial.
- **2** — Utiliza operações simples, mas apresenta confusões.
- **3** — Filtra e transforma coleções corretamente.
- **4** — Considera legibilidade, lazy evaluation e efeitos colaterais.
- **5** — Escolhe conscientemente entre streams, loops e processamento paralelo, justificando os trade-offs.

**Perguntas de aprofundamento:**

1. Quando um loop tradicional seria mais adequado que uma stream?
2. Quais riscos existem ao utilizar `parallelStream()`?
3. Como trataria valores nulos no pipeline?

---

## Pergunta 12 — Optional

**Nível:** Júnior  
**Categoria:** Java e tratamento de ausência

**Pergunta do entrevistador:**  
Qual é a finalidade de `Optional` em Java e como você evitaria seu uso inadequado?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre representação explícita de valores ausentes e prevenção de `NullPointerException`.

**Resposta esperada:**  
`Optional` representa a possibilidade de um valor existir ou não.

Ele é especialmente útil em retornos de métodos, por exemplo:

~~~java
public Optional<Pedido> buscarPorId(Long id) {
    return repository.findById(id);
}
~~~

O consumidor pode utilizar operações como:

- `map`;
- `flatMap`;
- `filter`;
- `orElse`;
- `orElseGet`;
- `orElseThrow`.

Deve-se evitar:

- Usar `get()` sem verificar a presença;
- Utilizar `Optional` em todo campo de entidade;
- Passar `Optional` indiscriminadamente como parâmetro;
- Criar `Optional` para valores que nunca são ausentes;
- Confundir ausência com erro inesperado.

**Explicação didática:**  
O método abaixo fornece uma falha explícita quando o pedido não existe:

~~~java
Pedido pedido = repository.findById(id)
        .orElseThrow(() -> new PedidoNaoEncontradoException(id));
~~~

Isso é mais claro do que retornar `null` e esperar que outra camada descubra o problema.

**Como o candidato deve responder:**

- Explique `Optional` como retorno;
- Diferencie `orElse` de `orElseGet`;
- Mencione o risco de `get()`;
- Explique que ele não substitui toda estratégia de tratamento de nulos;
- Relacione o uso ao contrato do método.

**Resposta fraca ou incompleta:**  
“Eu usaria `Optional` em todos os atributos para nunca ter valores nulos.”

Isso pode complicar persistência, serialização e o modelo de domínio.

**Critérios de avaliação:**

- **0** — Não conhece `Optional`.
- **1** — Usa apenas `get()`.
- **2** — Entende a ideia, mas desconhece boas práticas.
- **3** — Utiliza `Optional` corretamente em retornos.
- **4** — Considera contratos, exceções e alternativas de valor.
- **5** — Discute limites de uso, custo de avaliação e integração com APIs e persistência.

**Perguntas de aprofundamento:**

1. Qual é a diferença prática entre `orElse` e `orElseGet`?
2. Você retornaria `Optional` em um controller REST?
3. Como diferenciaria ausência de dados de uma falha de infraestrutura?

---

## Pergunta 13 — Concorrência e segurança de threads

**Nível:** Júnior  
**Categoria:** Java e concorrência

**Pergunta do entrevistador:**  
Quais cuidados você teria ao compartilhar objetos entre várias threads em uma aplicação Java?

**O que essa pergunta avalia:**  
Avalia conhecimentos básicos sobre estado compartilhado, condições de corrida e sincronização.

**Resposta esperada:**  
Quando várias threads acessam o mesmo estado mutável, podem ocorrer:

- Condições de corrida;
- Perda de atualizações;
- Leitura de dados inconsistentes;
- Deadlocks;
- Problemas de visibilidade entre threads.

Algumas estratégias são:

- Preferir objetos imutáveis;
- Evitar estado compartilhado;
- Utilizar variáveis locais;
- Escolher coleções concorrentes;
- Usar sincronização quando necessário;
- Controlar cuidadosamente o ciclo de vida das threads.

`ConcurrentHashMap`, `AtomicInteger` e mecanismos de bloqueio podem ser úteis, mas não devem ser aplicados sem compreender o problema.

**Exemplo de risco:**

~~~java
// Não é seguro em concorrência sem proteção adequada.
private int contador;

public void incrementar() {
    contador++;
}
~~~

A operação `contador++` envolve leitura, incremento e escrita. Outra thread pode alterar o valor entre essas etapas.

**Como o candidato deve responder:**

- Defina condição de corrida;
- Explique por que `contador++` não é necessariamente atômico;
- Mencione imutabilidade e coleções concorrentes;
- Evite afirmar que `volatile` resolve qualquer problema;
- Relacione a escolha ao cenário de acesso.

**Resposta fraca ou incompleta:**  
“Eu colocaria `synchronized` em todos os métodos.”

Isso pode reduzir desempenho e não resolve problemas de desenho ou de escopo.

**Critérios de avaliação:**

- **0** — Não entende concorrência.
- **1** — Afirma que variáveis compartilhadas são sempre seguras.
- **2** — Conhece `synchronized`, mas não entende seus limites.
- **3** — Identifica riscos básicos e propõe proteção.
- **4** — Considera imutabilidade, atomicidade e coleções concorrentes.
- **5** — Analisa visibilidade, contenção, deadlocks, lock-free e desenho sem estado compartilhado.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre atomicidade e visibilidade?
2. Quando `AtomicInteger` seria suficiente?
3. Como investigaria uma condição de corrida em produção?

---

## Pergunta 14 — Garbage Collector e memória

**Nível:** Júnior  
**Categoria:** Java e troubleshooting

**Pergunta do entrevistador:**  
Como funciona, em termos gerais, o gerenciamento de memória em Java e que sinais podem indicar um problema de memória?

**O que essa pergunta avalia:**  
Avalia o entendimento básico sobre heap, garbage collector e diagnóstico de problemas.

**Resposta esperada:**  
A JVM administra a memória dos objetos alocados no heap. O garbage collector identifica objetos que não são mais alcançáveis e libera o espaço correspondente.

Um problema de memória pode ser indicado por:

- `OutOfMemoryError`;
- Pausas longas de garbage collection;
- Crescimento contínuo do heap;
- Aumento de latência;
- Reinicializações da aplicação;
- Grande quantidade de objetos temporários.

As causas podem incluir:

- Vazamentos causados por referências mantidas indevidamente;
- Caches sem limite;
- Carregamento excessivo de dados;
- Filas crescendo sem controle;
- Configuração inadequada da JVM.

O diagnóstico deve utilizar métricas, logs da JVM, heap dumps e análise do comportamento da aplicação.

**Como o candidato deve responder:**

- Explique heap e garbage collection;
- Diferencie objeto sem referência de objeto ainda alcançável;
- Mencione métricas e heap dump;
- Evite afirmar que o garbage collector elimina qualquer problema de memória;
- Relacione a investigação ao comportamento observado.

**Resposta fraca ou incompleta:**  
“O garbage collector apaga todos os objetos antigos automaticamente.”

Um objeto só pode ser coletado quando não está mais alcançável, independentemente de sua idade.

**Critérios de avaliação:**

- **0** — Não conhece o gerenciamento de memória.
- **1** — Apresenta explicações incorretas.
- **2** — Conhece garbage collection superficialmente.
- **3** — Explica heap e coleta básica.
- **4** — Relaciona o tema a vazamentos, métricas e diagnóstico.
- **5** — Discute pressão de memória, alocação, pausas, heap dumps e análise orientada por evidências.

**Perguntas de aprofundamento:**

1. Como um cache pode causar vazamento de memória?
2. Que métricas acompanharia para investigar o problema?
3. Qual seria sua primeira ação diante de um `OutOfMemoryError`?

---

## Pergunta 15 — Configuração externa no Spring Boot

**Nível:** Júnior  
**Categoria:** Spring Boot e configuração

**Pergunta do entrevistador:**  
Por que configurações como URLs, timeouts e credenciais não deveriam ficar diretamente no código da aplicação?

**O que essa pergunta avalia:**  
Avalia conhecimentos sobre externalização de configuração, segurança e operação em diferentes ambientes.

**Resposta esperada:**  
A configuração deve ser externalizada porque varia entre ambientes e não deve exigir alteração do código para cada implantação.

Exemplos:

- URL de banco de dados;
- Timeout de clientes HTTP;
- Nome de tópicos;
- Endereço de brokers;
- Chaves de serviços externos;
- Limites de processamento.

Em Spring Boot, propriedades podem ser definidas em arquivos de configuração, variáveis de ambiente ou mecanismos externos de gerenciamento de segredos.

Credenciais não devem ser versionadas em texto puro no repositório.

**Exemplo:**

~~~java
@ConfigurationProperties(prefix = "pagamento")
public record PagamentoProperties(
        URI baseUrl,
        Duration timeout
) {
}
~~~

A aplicação pode receber valores diferentes em cada ambiente sem alterar a lógica de negócio.

**Como o candidato deve responder:**

- Explique configuração por ambiente;
- Mencione variáveis de ambiente e secret managers;
- Diferencie configuração comum de segredo;
- Fale sobre validação das propriedades;
- Evite sugerir armazenamento de senhas no código.

**Resposta fraca ou incompleta:**  
“Eu colocaria tudo em `application.properties` e faria commit.”

O arquivo pode conter configurações não sensíveis, mas segredos não devem ser expostos no controle de versão.

**Critérios de avaliação:**

- **0** — Não entende externalização.
- **1** — Armazena credenciais no código.
- **2** — Conhece arquivos de configuração, mas ignora segurança.
- **3** — Externaliza configurações básicas.
- **4** — Considera ambientes, validação e gerenciamento de segredos.
- **5** — Discute precedência, rotação, auditoria, configuração dinâmica e falha segura.

**Perguntas de aprofundamento:**

1. Onde armazenaria uma chave de API em produção?
2. Como validaria uma configuração obrigatória na inicialização?
3. Qual risco existe em alterar configurações dinamicamente?

---

## Pergunta 16 — Bean Validation

**Nível:** Júnior  
**Categoria:** APIs e validação

**Pergunta do entrevistador:**  
Como você validaria os dados recebidos por uma API REST em uma aplicação Spring Boot?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre validação declarativa, contratos de entrada e tratamento consistente de erros.

**Resposta esperada:**  
A aplicação pode utilizar Bean Validation para declarar regras no DTO de entrada e executar a validação no controller.

**Exemplo:**

~~~java
public record CriarClienteRequest(
        @NotBlank String nome,
        @Email @NotBlank String email
) {
}

@PostMapping
public ResponseEntity<Void> criar(
        @Valid @RequestBody CriarClienteRequest request
) {
    service.criar(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
}
~~~

A validação deve ocorrer também na camada de negócio quando necessário, pois nem todas as regras podem ser verificadas apenas pelos campos de entrada.

Erros de validação devem retornar uma resposta padronizada, sem expor detalhes internos.

**Como o candidato deve responder:**

- Diferencie validação sintática de regra de negócio;
- Mencione DTOs;
- Explique o uso de `@Valid`;
- Fale sobre resposta de erro padronizada;
- Evite confiar apenas na validação do frontend.

**Resposta fraca ou incompleta:**  
“Eu validaria os campos somente no JavaScript da tela.”

Clientes podem ser contornados, e a API precisa proteger seu próprio contrato.

**Critérios de avaliação:**

- **0** — Não sabe validar entradas.
- **1** — Confia somente no cliente.
- **2** — Conhece anotações, mas não trata erros adequadamente.
- **3** — Implementa validação básica no endpoint.
- **4** — Diferencia validação estrutural e regra de negócio.
- **5** — Define contratos consistentes, mensagens seguras, validação por camadas e testes abrangentes.

**Perguntas de aprofundamento:**

1. Como retornaria vários erros de validação em uma única resposta?
2. Que regras não deveriam ficar apenas nas anotações?
3. Como testaria esse endpoint?

---

## Pergunta 17 — Paginação e ordenação

**Nível:** Júnior  
**Categoria:** APIs e bancos de dados

**Pergunta do entrevistador:**  
Por que uma API que retorna muitos registros deve utilizar paginação e ordenação controladas?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre uso de memória, desempenho e previsibilidade de respostas.

**Resposta esperada:**  
Retornar todos os registros de uma vez pode causar:

- Alto consumo de memória;
- Respostas lentas;
- Timeouts;
- Sobrecarga no banco;
- Grande tráfego de rede;
- Experiência ruim para o consumidor.

A API deve receber parâmetros de página, tamanho máximo e ordenação permitida. O backend precisa aplicar limites para evitar consultas excessivamente caras.

Também é importante definir uma ordenação estável. Sem ela, registros podem aparecer repetidos ou desaparecer entre páginas quando os dados são alterados.

**Exemplo de contrato:**

~~~text
GET /pedidos?page=0&size=20&sort=createdAt,desc
~~~

O tamanho solicitado pelo cliente deve ser limitado pelo servidor.

**Como o candidato deve responder:**

- Relacione paginação a desempenho;
- Mencione limite máximo de página;
- Explique ordenação estável;
- Considere filtros e índices;
- Evite permitir qualquer campo ou tamanho sem validação.

**Resposta fraca ou incompleta:**  
“Eu retornaria todos os registros e deixaria o frontend decidir.”

Isso transfere um problema de desempenho para o cliente e pode comprometer a aplicação.

**Critérios de avaliação:**

- **0** — Não reconhece a necessidade de paginação.
- **1** — Retorna todos os dados sem controle.
- **2** — Conhece paginação, mas ignora limites e ordenação.
- **3** — Implementa paginação básica.
- **4** — Considera índices, filtros e tamanho máximo.
- **5** — Discute paginação por cursor, consistência, ordenação estável e impacto em grandes volumes.

**Perguntas de aprofundamento:**

1. Quando a paginação por cursor seria melhor que offset?
2. Como evitaria que o cliente ordenasse por uma coluna inadequada?
3. Que índices avaliaria para essa consulta?

---

## Pergunta 18 — Índices e diagnóstico de consultas SQL

**Nível:** Júnior  
**Categoria:** Bancos de dados e desempenho

**Pergunta do entrevistador:**  
Como um índice pode melhorar uma consulta SQL e quais são os custos de adicionar índices indiscriminadamente?

**O que essa pergunta avalia:**  
Avalia a compreensão básica sobre índices, leitura de planos e impacto em escrita.

**Resposta esperada:**  
Um índice é uma estrutura auxiliar que permite localizar registros com mais eficiência, reduzindo a necessidade de percorrer toda a tabela.

Ele pode melhorar consultas que filtram, ordenam ou fazem junções por determinadas colunas.

Por outro lado, índices:

- Ocupam espaço;
- Aumentam o custo de `INSERT`, `UPDATE` e `DELETE`;
- Podem não ser utilizados pelo otimizador;
- Podem ser prejudiciais quando mal escolhidos;
- Precisam acompanhar os padrões reais de consulta.

A decisão deve ser apoiada por métricas e pelo plano de execução, não apenas por intuição.

**Como o candidato deve responder:**

- Explique o objetivo do índice;
- Relacione o índice às consultas reais;
- Mencione plano de execução;
- Considere custo de escrita e armazenamento;
- Evite afirmar que toda coluna deve ter índice.

**Resposta fraca ou incompleta:**  
“Eu criaria um índice em todas as colunas para acelerar o banco.”

Isso pode aumentar custos e não garante melhora nas consultas.

**Critérios de avaliação:**

- **0** — Não entende índices.
- **1** — Apresenta afirmações incorretas.
- **2** — Conhece o benefício, mas ignora custos.
- **3** — Explica o uso básico de índices.
- **4** — Considera planos, filtros, ordenação e escrita.
- **5** — Analisa seletividade, índices compostos, cobertura, estatísticas e comportamento em produção.

**Perguntas de aprofundamento:**

1. Em que ordem colocaria colunas em um índice composto?
2. Como confirmaria se o banco está usando o índice?
3. Por que um índice pode não melhorar uma consulta?

---

## Pergunta 19 — Normalização e modelagem de dados

**Nível:** Júnior  
**Categoria:** Bancos de dados e modelagem

**Pergunta do entrevistador:**  
O que é normalização de dados e em que situação uma desnormalização poderia ser considerada?

**O que essa pergunta avalia:**  
Avalia a capacidade de compreender consistência, duplicidade e trade-offs de leitura e escrita.

**Resposta esperada:**  
Normalização organiza os dados para reduzir duplicidade e anomalias de inserção, atualização e remoção.

Uma modelagem normalizada tende a facilitar a consistência dos dados, mas pode exigir mais joins para montar uma resposta.

A desnormalização pode ser considerada quando:

- Há necessidade comprovada de reduzir leituras;
- O padrão de consulta é conhecido;
- A duplicidade é controlada;
- Existe estratégia para atualização dos dados;
- O ganho de desempenho compensa a complexidade adicional.

Não se deve desnormalizar prematuramente.

**Como o candidato deve responder:**

- Explique o objetivo da normalização;
- Cite anomalias de dados;
- Relacione desnormalização a desempenho;
- Mencione custo de consistência;
- Baseie a decisão em métricas e padrões de acesso.

**Resposta fraca ou incompleta:**  
“Desnormalizar sempre deixa o banco mais rápido.”

O resultado depende das consultas, do volume, dos índices e do custo de manter dados duplicados.

**Critérios de avaliação:**

- **0** — Não conhece normalização.
- **1** — Confunde duplicidade com desempenho.
- **2** — Entende parcialmente o conceito.
- **3** — Explica normalização e desnormalização básica.
- **4** — Considera consistência e padrões de acesso.
- **5** — Analisa modelos de leitura, replicação, caches, projeções e custos operacionais.

**Perguntas de aprofundamento:**

1. Que problema pode surgir ao duplicar dados?
2. Como manteria uma visão desnormalizada atualizada?
3. Em que situação aceitaria consistência eventual?

---

## Pergunta 20 — Banco relacional versus banco não relacional

**Nível:** Pleno  
**Categoria:** Arquitetura de dados

**Pergunta do entrevistador:**  
Como você decidiria entre utilizar um banco de dados relacional ou não relacional em um novo serviço?

**O que essa pergunta avalia:**  
Avalia a capacidade de escolher tecnologia com base em requisitos de negócio, consistência, volume e padrão de acesso.

**Resposta esperada:**  
A escolha deve considerar:

- Estrutura e relacionamento dos dados;
- Necessidade de transações;
- Requisitos de consistência;
- Padrões de consulta;
- Volume e velocidade de crescimento;
- Escalabilidade;
- Latência esperada;
- Experiência operacional da equipe;
- Custos;
- Recursos de backup, replicação e observabilidade.

Bancos relacionais são adequados quando há relacionamentos fortes, consultas complexas e necessidade de transações maduras.

Bancos não relacionais podem ser adequados para documentos flexíveis, grandes volumes, alta escala horizontal ou padrões de acesso específicos. Porém, “NoSQL” não significa ausência de modelagem ou consistência.

A decisão pode ser poliglota, utilizando tecnologias diferentes para necessidades distintas, mas isso aumenta a complexidade operacional.

**Exemplo de decisão:**

~~~mermaid
flowchart TD
    A[Requisitos do serviço] --> B{Há relações e transações complexas?}
    B -- Sim --> C[Avaliar banco relacional]
    B -- Não --> D{O padrão de acesso é especializado?}
    D -- Sim --> E[Avaliar banco não relacional]
    D -- Não --> C
    C --> F[Validar desempenho e operação]
    E --> F
~~~

**Como o candidato deve responder:**

- Comece pelos requisitos, não pela preferência tecnológica;
- Explique consistência, transações e consultas;
- Considere escalabilidade e operação;
- Mencione custo de manter mais de um tipo de banco;
- Apresente uma decisão contextualizada.

**Resposta fraca ou incompleta:**  
“Eu usaria NoSQL porque é mais moderno e escala melhor.”

Essa resposta é genérica e não considera o modelo de dados, as consultas nem os requisitos transacionais.

**Critérios de avaliação:**

- **0** — Não diferencia os modelos.
- **1** — Escolhe apenas por popularidade.
- **2** — Conhece algumas diferenças, mas não as relaciona ao problema.
- **3** — Escolhe uma alternativa coerente para um cenário simples.
- **4** — Considera consistência, desempenho, escala e operação.
- **5** — Justifica a decisão com trade-offs, requisitos de negócio, custos, governança e estratégia de evolução.

**Perguntas de aprofundamento:**

1. Como modelaria dados em um banco orientado a documentos?
2. Quando a consistência eventual seria aceitável?
3. Quais custos surgem ao utilizar dois bancos diferentes no mesmo serviço?

---

## Resumo desta parte

- **Perguntas apresentadas:** 11 a 20
- **Perguntas restantes:** 21 a 100
- **Níveis abordados:** Júnior e Pleno
- **Categorias:** Java, concorrência, memória, Spring Boot, APIs, validação, bancos de dados e desempenho
- **Competências avaliadas:** uso aplicado da linguagem Java, tratamento de ausência, segurança de threads, diagnóstico de memória, externalização de configuração, validação de APIs, paginação, índices e escolha de tecnologias de persistência

A próxima parte continuará com as perguntas **21 a 30**, avançando para Spring Boot, microsserviços, comunicação síncrona e fundamentos de mensageria.

---

`markdown
# Roteiro de Entrevista Técnica — Java e Engenharia de Software

> **Parte 3 de 10 — Perguntas 21 a 30 de 100**

**Objetivo:** preparação para uma posição de Desenvolvedor(a) Java Sênior/Especialista, com foco em microsserviços, mensageria, bancos de dados, observabilidade, nuvem, arquitetura, boas práticas e didática técnica.

**Níveis abordados nesta parte:** Pleno e Sênior  
**Estilo:** perguntas conceituais, práticas e baseadas em cenários reais

---

## Pergunta 21 — Arquitetura de microsserviços

**Nível:** Pleno  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
Quais critérios você utilizaria para decidir se uma funcionalidade deve ser implementada como um novo microsserviço ou permanecer em um serviço existente?

**O que essa pergunta avalia:**  
Avalia a capacidade de decompor sistemas considerando coesão, acoplamento, autonomia, escalabilidade e custo operacional.

**Resposta esperada:**  
A decisão deve considerar:

- Limites de negócio;
- Coesão das responsabilidades;
- Frequência e motivo de alterações;
- Necessidade de escala independente;
- Requisitos de disponibilidade;
- Isolamento de falhas;
- Propriedade dos dados;
- Necessidade de deploy independente;
- Capacidade operacional da equipe;
- Custo de comunicação entre serviços.

Um novo microsserviço pode ser adequado quando existe um limite de negócio claro e quando a autonomia traz benefícios reais.

Não se deve criar um serviço apenas porque uma classe ou módulo ficou grande. Microsserviços aumentam a complexidade distribuída, pois introduzem rede, observabilidade, versionamento, falhas parciais e consistência eventual.

**Explicação didática:**  
Um microsserviço deve representar uma capacidade de negócio relativamente independente. Por exemplo, pagamentos, notificações e catálogo podem ter ritmos de alteração, requisitos de disponibilidade e modelos de dados diferentes.

Por outro lado, dividir uma funcionalidade que sempre precisa ser alterada e executada junto pode criar chamadas desnecessárias e aumentar a fragilidade do sistema.

A decomposição deve priorizar limites de negócio, não apenas critérios técnicos.

**Exemplo prático:**

Considere uma plataforma de vendas:

- O serviço de catálogo gerencia produtos e preços;
- O serviço de pedidos gerencia o ciclo de compra;
- O serviço de pagamentos integra adquirentes;
- O serviço de notificações envia mensagens ao cliente.

O pedido pode publicar um evento `PedidoCriado`, e o serviço de pagamentos pode reagir a esse evento sem que o serviço de pedidos conheça sua implementação interna.

**Como o candidato deve responder:**

- Comece pelos limites de negócio;
- Explique os benefícios e custos dos microsserviços;
- Mencione autonomia de deploy e escala;
- Considere propriedade dos dados;
- Fale sobre falhas distribuídas e observabilidade;
- Evite defender microsserviços como solução universal.

**Resposta fraca ou incompleta:**  
“Eu criaria um microsserviço para cada módulo do sistema, porque isso facilita escalar.”

A resposta ignora acoplamento, custo operacional e limites de negócio.

**Critérios de avaliação:**

- **0** — Não compreende microsserviços.
- **1** — Defende fragmentação indiscriminada.
- **2** — Conhece o conceito, mas ignora custos distribuídos.
- **3** — Explica critérios básicos de decomposição.
- **4** — Considera autonomia, dados, escala e falhas.
- **5** — Analisa limites de negócio, evolução, governança, operação e trade-offs de forma madura.

**Perguntas de aprofundamento:**

1. Em quais situações um monólito modular seria melhor?
2. Como identificaria que dois serviços estão excessivamente acoplados?
3. Como lidaria com uma transação que atravessa vários microsserviços?

---

## Pergunta 22 — Comunicação síncrona e assíncrona

**Nível:** Pleno  
**Categoria:** Integração entre serviços

**Pergunta do entrevistador:**  
Como você escolheria entre uma comunicação síncrona, como HTTP, e uma comunicação assíncrona, como Kafka ou RabbitMQ?

**O que essa pergunta avalia:**  
Avalia a capacidade de escolher mecanismos de comunicação considerando latência, dependência, consistência e resiliência.

**Resposta esperada:**  
A comunicação síncrona é adequada quando o consumidor precisa da resposta imediatamente para continuar o fluxo. É simples de entender, mas cria dependência temporal entre os serviços.

A comunicação assíncrona é adequada quando o processamento pode ocorrer posteriormente, quando se deseja desacoplar produtores e consumidores ou quando é necessário absorver picos de carga.

A escolha deve considerar:

- Necessidade de resposta imediata;
- Tolerância à latência;
- Volume de mensagens;
- Necessidade de reprocessamento;
- Ordem dos eventos;
- Garantia de entrega;
- Tratamento de duplicidades;
- Consistência eventual;
- Complexidade operacional;
- Capacidade de observabilidade.

Nenhuma das abordagens é sempre superior.

**Explicação didática:**  
Em uma consulta de saldo, o cliente normalmente precisa de uma resposta imediata, portanto uma comunicação síncrona pode ser apropriada.

Já o envio de uma notificação após a criação de um pedido pode ocorrer de forma assíncrona. O pedido não precisa permanecer bloqueado enquanto o e-mail é enviado.

O modelo assíncrono exige cuidados adicionais, como retentativas, dead-letter queues, idempotência e rastreamento de mensagens.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Pedido criado] --> B{Resposta imediata é necessária?}
    B -- Sim --> C[Comunicação síncrona]
    B -- Não --> D[Publicar evento]
    D --> E[Processamento assíncrono]
    E --> F[Retentativa ou fila de erro]
~~~

**Como o candidato deve responder:**

- Compare dependência temporal e desacoplamento;
- Explique consistência eventual;
- Mencione retentativas e duplicidade;
- Relacione a decisão ao processo de negócio;
- Evite afirmar que toda integração deve ser assíncrona.

**Resposta fraca ou incompleta:**  
“Eu sempre usaria Kafka porque é mais escalável.”

A escolha depende do padrão de comunicação, do volume, da necessidade de resposta e da capacidade operacional.

**Critérios de avaliação:**

- **0** — Não diferencia os modelos.
- **1** — Escolhe uma abordagem por preferência.
- **2** — Conhece a diferença, mas ignora falhas.
- **3** — Escolhe adequadamente em cenários simples.
- **4** — Considera latência, consistência e resiliência.
- **5** — Analisa contratos, ordenação, reprocessamento, operação e impacto no negócio.

**Perguntas de aprofundamento:**

1. Como informaria o usuário sobre o resultado de uma operação assíncrona?
2. Quais riscos surgem quando uma API síncrona depende de muitos serviços?
3. Em que situação uma fila seria mais adequada que um tópico?

---

## Pergunta 23 — Kafka: tópicos, partições e consumidores

**Nível:** Pleno  
**Categoria:** Mensageria

**Pergunta do entrevistador:**  
Explique a relação entre tópicos, partições e grupos de consumidores no Kafka e como esses elementos influenciam a escalabilidade.

**O que essa pergunta avalia:**  
Avalia o entendimento dos conceitos essenciais de distribuição e consumo de mensagens no Kafka.

**Resposta esperada:**  
Um tópico representa uma categoria lógica de eventos. Ele pode ser dividido em partições, que permitem distribuir as mensagens entre diferentes consumidores.

Dentro de um mesmo grupo de consumidores, cada partição é consumida por no máximo um consumidor por vez. Dessa forma, adicionar consumidores pode aumentar o paralelismo até o limite da quantidade de partições.

As mensagens são ordenadas dentro de uma partição, mas não existe ordenação global garantida entre todas as partições.

A chave da mensagem influencia a partição e pode ser utilizada para manter eventos de uma mesma entidade na mesma partição.

**Explicação didática:**  
Se um tópico possui quatro partições e um grupo possui dois consumidores, cada consumidor pode processar duas partições.

Se o grupo tiver seis consumidores, pelo menos dois ficarão sem partição atribuída, pois há apenas quatro partições disponíveis.

A escolha da chave é importante. Eventos do mesmo pedido podem utilizar `pedidoId` como chave para preservar a ordem relativa daquele pedido.

**Exemplo prático:**

~~~text
Tópico: pedidos

Partição 0: pedido-10, pedido-14
Partição 1: pedido-11, pedido-15
Partição 2: pedido-12
Partição 3: pedido-13

Grupo de consumidores: faturamento
- consumidor A: partições 0 e 1
- consumidor B: partições 2 e 3
~~~

**Como o candidato deve responder:**

- Defina tópico, partição e grupo;
- Explique paralelismo;
- Mencione ordenação por partição;
- Explique a importância da chave;
- Relacione o número de consumidores ao número de partições;
- Evite afirmar que Kafka garante ordem global automaticamente.

**Resposta fraca ou incompleta:**  
“Cada consumidor recebe todas as mensagens do tópico.”

Isso desconsidera a divisão por grupos e partições.

**Critérios de avaliação:**

- **0** — Não conhece os conceitos básicos.
- **1** — Confunde tópico, partição e consumidor.
- **2** — Conhece os termos, mas não explica o paralelismo.
- **3** — Explica corretamente o consumo por grupos.
- **4** — Relaciona partições, chaves, ordenação e escala.
- **5** — Discute rebalanceamento, throughput, retenção, particionamento e impactos operacionais.

**Perguntas de aprofundamento:**

1. O que acontece quando há mais consumidores que partições?
2. Como escolheria a chave de uma mensagem?
3. Que problemas podem ocorrer durante um rebalanceamento?

---

## Pergunta 24 — RabbitMQ: filas, exchanges e roteamento

**Nível:** Pleno  
**Categoria:** Mensageria

**Pergunta do entrevistador:**  
Como funcionam exchanges, filas e bindings no RabbitMQ, e como você escolheria uma estratégia de roteamento?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre os principais componentes de roteamento e entrega de mensagens no RabbitMQ.

**Resposta esperada:**  
No RabbitMQ:

- O produtor publica a mensagem em uma `exchange`;
- A `exchange` decide para quais filas a mensagem será encaminhada;
- O `binding` define a relação entre uma exchange e uma fila;
- O consumidor lê mensagens de uma fila.

Tipos comuns de exchange incluem:

- **Direct:** roteia por uma chave exata;
- **Topic:** roteia por padrões de chaves;
- **Fanout:** envia para todas as filas vinculadas;
- **Headers:** utiliza cabeçalhos para decidir o roteamento.

A escolha depende do fluxo. Uma exchange `fanout` pode ser adequada para notificar diversos consumidores. Uma exchange `direct` pode ser suficiente para uma rota específica.

Também é necessário definir confirmação de publicação, acknowledgements, retentativas e destino para mensagens que não possam ser processadas.

**Explicação didática:**  
A exchange desacopla o produtor das filas. O produtor não precisa conhecer diretamente todos os consumidores.

Por exemplo, um evento de pedido pode ser publicado em uma exchange. Filas diferentes podem receber esse evento para faturamento, estoque e notificações.

O consumidor deve confirmar a mensagem somente depois de concluir o processamento necessário.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[Produtor] --> B[Exchange]
    B --> C[Fila de faturamento]
    B --> D[Fila de estoque]
    B --> E[Fila de notificações]
    C --> F[Consumidor de faturamento]
    D --> G[Consumidor de estoque]
    E --> H[Consumidor de notificações]
~~~

**Como o candidato deve responder:**

- Diferencie exchange e fila;
- Explique bindings e roteamento;
- Cite tipos de exchange;
- Mencione confirmação de processamento;
- Fale sobre dead-letter e retentativas;
- Evite tratar RabbitMQ apenas como uma lista simples de mensagens.

**Resposta fraca ou incompleta:**  
“O produtor envia a mensagem diretamente para o consumidor.”

Isso ignora filas, exchanges e o desacoplamento promovido pelo broker.

**Critérios de avaliação:**

- **0** — Não conhece o funcionamento básico.
- **1** — Confunde exchange com fila.
- **2** — Conhece parte dos componentes, mas não explica o roteamento.
- **3** — Explica o fluxo básico de publicação e consumo.
- **4** — Considera acknowledgements, retentativas e dead-letter.
- **5** — Discute roteamento, durabilidade, confirmação de publicação, ordenação e operação em produção.

**Perguntas de aprofundamento:**

1. O que deveria acontecer com uma mensagem que falha repetidamente?
2. Como evitaria confirmar uma mensagem antes do processamento?
3. Quando utilizaria `fanout` em vez de `topic`?

---

## Pergunta 25 — Entrega de mensagens e duplicidade

**Nível:** Pleno  
**Categoria:** Mensageria e confiabilidade

**Pergunta do entrevistador:**  
Como você projetaria um consumidor para lidar com mensagens duplicadas ou entregues mais de uma vez?

**O que essa pergunta avalia:**  
Avalia a compreensão de entrega de mensagens, idempotência e consistência no processamento assíncrono.

**Resposta esperada:**  
O consumidor deve ser idempotente, pois muitos sistemas de mensageria podem entregar uma mensagem novamente após timeout, falha ou ausência de confirmação.

Estratégias possíveis:

- Identificador único da mensagem;
- Registro de mensagens já processadas;
- Chave de idempotência no banco;
- Operação condicional;
- Verificação do estado atual;
- Transação local envolvendo o registro e a alteração;
- Controle de versão da entidade.

O consumidor não deve depender apenas de memória local para detectar duplicidades, pois várias instâncias podem processar mensagens.

**Explicação didática:**  
Imagine que um consumidor atualize o status de um pedido e, logo depois, falhe antes de confirmar a mensagem. O broker pode entregar a mesma mensagem novamente.

Se o processamento não for idempotente, o sistema pode duplicar cobranças, gerar dois registros ou disparar notificações repetidas.

Uma abordagem comum é armazenar o identificador da mensagem em uma tabela com restrição única. Se o mesmo identificador aparecer novamente, o consumidor reconhece que o processamento já ocorreu.

**Exemplo prático:**

~~~java
@Transactional
public void processar(EventoPagamento evento) {
    if (eventoRepository.jaProcessado(evento.id())) {
        return;
    }

    pagamentoService.atualizarStatus(
            evento.pagamentoId(),
            evento.novoStatus()
    );

    eventoRepository.registrarProcessamento(evento.id());
}
~~~

Em produção, a verificação e o registro precisam ser protegidos contra condições de corrida, normalmente por uma restrição única e tratamento adequado de conflito.

**Como o candidato deve responder:**

- Explique por que duplicidades acontecem;
- Diferencie at-least-once de exactly-once;
- Proponha idempotência persistente;
- Considere concorrência entre consumidores;
- Mencione ações com efeitos colaterais;
- Evite prometer exatamente uma entrega sem explicar as limitações.

**Resposta fraca ou incompleta:**  
“Eu ignoraria mensagens repetidas comparando o conteúdo em memória.”

Isso não funciona de forma confiável em múltiplas instâncias ou após reinicializações.

**Critérios de avaliação:**

- **0** — Não reconhece o risco de duplicidade.
- **1** — Processa cada mensagem sem controle.
- **2** — Menciona um identificador, mas sem persistência ou concorrência.
- **3** — Propõe consumidor idempotente de forma básica.
- **4** — Considera banco, transação e múltiplas instâncias.
- **5** — Discute garantias de entrega, efeitos externos, chaves únicas, reprocessamento e limites de exactly-once.

**Perguntas de aprofundamento:**

1. Como trataria uma mensagem duplicada que chama uma API externa?
2. Onde armazenaria os identificadores processados?
3. O que faria se o registro do processamento fosse salvo, mas a atualização de negócio falhasse?

---

## Pergunta 26 — Outbox Pattern

**Nível:** Sênior  
**Categoria:** Arquitetura distribuída

**Pergunta do entrevistador:**  
Como você garantiria que uma alteração no banco de dados e a publicação de um evento não ficassem inconsistentes?

**O que essa pergunta avalia:**  
Avalia a compreensão de consistência entre banco de dados e broker em arquiteturas distribuídas.

**Resposta esperada:**  
Uma alternativa é utilizar o padrão Outbox.

Nesse padrão:

1. A aplicação altera os dados de negócio;
2. Na mesma transação local, grava um evento em uma tabela de outbox;
3. Um processo separado lê os eventos pendentes;
4. Esse processo publica os eventos no broker;
5. Após a confirmação, marca o evento como publicado.

Assim, a alteração de negócio e o registro da intenção de publicar são confirmados juntos no banco.

O consumidor ainda deve ser idempotente, porque a publicação pode ser repetida após falhas.

**Explicação didática:**  
Publicar diretamente no broker depois do `commit` pode falhar. Salvar no banco e publicar antes do `commit` também pode gerar inconsistência, pois o banco pode realizar rollback depois que o evento já foi enviado.

O Outbox não elimina todos os problemas. Ele exige:

- Processo de publicação;
- Controle de tentativas;
- Monitoramento de eventos pendentes;
- Tratamento de falhas;
- Idempotência no consumidor;
- Limpeza ou retenção dos eventos.

**Exemplo de fluxo:**

~~~mermaid
sequenceDiagram
    participant A as Aplicação
    participant B as Banco
    participant O as Publicador Outbox
    participant K as Broker

    A->>B: Atualiza dados de negócio
    A->>B: Grava evento na outbox
    B-->>A: Commit confirmado
    O->>B: Busca eventos pendentes
    O->>K: Publica evento
    K-->>O: Confirma publicação
    O->>B: Marca evento como publicado
~~~

**Como o candidato deve responder:**

- Explique o problema da dupla escrita;
- Descreva o funcionamento do Outbox;
- Mencione transação local;
- Explique que o consumidor ainda deve ser idempotente;
- Considere retentativas e monitoramento;
- Diferencie Outbox de uma garantia absoluta de exactly-once.

**Resposta fraca ou incompleta:**  
“Eu salvaria no banco e depois publicaria no Kafka; se falhar, tentaria novamente.”

A resposta não explica como identificar eventos pendentes nem como evitar perda ou duplicidade.

**Critérios de avaliação:**

- **0** — Não identifica o problema da dupla escrita.
- **1** — Confia em uma sequência simples sem recuperação.
- **2** — Conhece eventos, mas não propõe consistência.
- **3** — Explica o Outbox de forma básica.
- **4** — Considera publicação assíncrona, retentativas e idempotência.
- **5** — Discute ordenação, particionamento, retenção, observabilidade, throughput e alternativas como CDC.

**Perguntas de aprofundamento:**

1. Como monitoraria eventos presos na outbox?
2. Como evitaria que dois publicadores processassem o mesmo evento?
3. Quando uma solução baseada em CDC seria mais adequada?

---

## Pergunta 27 — Saga e transações distribuídas

**Nível:** Sênior  
**Categoria:** Arquitetura distribuída

**Pergunta do entrevistador:**  
Como você implementaria uma operação de negócio que envolve vários microsserviços, como pedido, pagamento e estoque?

**O que essa pergunta avalia:**  
Avalia conhecimentos sobre consistência eventual, coordenação de serviços e compensação de operações distribuídas.

**Resposta esperada:**  
Uma transação ACID tradicional normalmente não deve atravessar vários microsserviços. Uma alternativa é o padrão Saga, no qual a operação é dividida em transações locais.

Se uma etapa falhar, ações compensatórias podem desfazer ou neutralizar etapas anteriores.

A Saga pode ser:

- **Orquestrada:** um componente central coordena as etapas;
- **Coreografada:** os serviços reagem a eventos uns dos outros.

A escolha depende da complexidade do fluxo, da necessidade de visibilidade central e do grau de acoplamento aceitável.

É necessário definir:

- Estados intermediários;
- Eventos;
- Retentativas;
- Compensações;
- Timeouts;
- Idempotência;
- Tratamento de falhas permanentes;
- Observabilidade do processo.

**Explicação didática:**  
Um fluxo possível seria:

1. Criar o pedido;
2. Reservar o estoque;
3. Autorizar o pagamento;
4. Confirmar o pedido.

Se o pagamento falhar depois da reserva, o sistema pode executar uma compensação para liberar o estoque.

A compensação não é necessariamente um rollback técnico. Ela é uma nova operação de negócio que tenta levar o sistema a um estado aceitável.

**Exemplo de fluxo:**

~~~mermaid
stateDiagram-v2
    [*] --> PedidoCriado
    PedidoCriado --> EstoqueReservado
    EstoqueReservado --> PagamentoAutorizado
    PagamentoAutorizado --> PedidoConfirmado
    EstoqueReservado --> PagamentoFalhou
    PagamentoFalhou --> EstoqueLiberado
    EstoqueLiberado --> PedidoCancelado
~~~

**Como o candidato deve responder:**

- Explique por que uma transação única pode ser inadequada;
- Diferencie orquestração e coreografia;
- Mencione consistência eventual;
- Defina ações compensatórias;
- Considere estados intermediários e observabilidade;
- Evite afirmar que compensação é igual a rollback.

**Resposta fraca ou incompleta:**  
“Eu abriria uma transação única em todos os serviços.”

Isso desconsidera autonomia dos serviços, limites transacionais e falhas parciais.

**Critérios de avaliação:**

- **0** — Não compreende transações distribuídas.
- **1** — Propõe apenas uma transação global sem análise.
- **2** — Conhece Saga superficialmente.
- **3** — Explica o conceito de transações locais e compensação.
- **4** — Compara orquestração e coreografia.
- **5** — Analisa estados, idempotência, observabilidade, falhas permanentes e impacto no negócio.

**Perguntas de aprofundamento:**

1. Como trataria uma compensação que também falhou?
2. Quando a coreografia pode se tornar difícil de manter?
3. Como o usuário acompanharia o estado da operação?

---

## Pergunta 28 — Resiliência entre microsserviços

**Nível:** Pleno  
**Categoria:** Resiliência e troubleshooting

**Pergunta do entrevistador:**  
Quais mecanismos você utilizaria para evitar que a indisponibilidade de um serviço derrubasse toda a aplicação?

**O que essa pergunta avalia:**  
Avalia a compreensão de resiliência, isolamento de falhas e degradação controlada.

**Resposta esperada:**  
Alguns mecanismos são:

- Timeouts;
- Circuit breaker;
- Bulkheads;
- Retentativas limitadas;
- Backoff;
- Fallbacks seguros;
- Filas;
- Rate limiting;
- Limites de concorrência;
- Cache quando apropriado;
- Health checks;
- Monitoramento e alertas.

Timeouts impedem que requisições fiquem bloqueadas indefinidamente. O circuit breaker interrompe chamadas para um serviço que está falhando repetidamente, permitindo sua recuperação e evitando saturação dos consumidores.

Retentativas devem ser aplicadas com cautela, pois podem aumentar a carga sobre um serviço já degradado.

**Explicação didática:**  
Se o serviço de consulta de recomendações estiver indisponível, o serviço principal pode retornar a compra sem recomendações.

Entretanto, se o serviço de autorização de pagamento estiver indisponível, talvez não exista fallback seguro. Nesse caso, a operação deve ser interrompida ou encaminhada para processamento posterior.

A degradação deve respeitar a importância da funcionalidade.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Chamada ao serviço externo] --> B{Timeout?}
    B -- Não --> C[Retornar resposta]
    B -- Sim --> D[Registrar falha]
    D --> E{Circuit breaker aberto?}
    E -- Não --> F[Retentar com limite]
    E -- Sim --> G[Usar fallback seguro]
    G --> H[Monitorar recuperação]
~~~

**Como o candidato deve responder:**

- Explique timeout e circuit breaker;
- Mencione retentativas com backoff;
- Diferencie falhas críticas e não críticas;
- Considere saturação e cascata de falhas;
- Fale sobre métricas e alertas;
- Evite adicionar retentativas ilimitadas.

**Resposta fraca ou incompleta:**  
“Eu faria várias tentativas até o serviço responder.”

Isso pode transformar uma falha isolada em uma indisponibilidade generalizada.

**Critérios de avaliação:**

- **0** — Não identifica riscos de dependências.
- **1** — Propõe chamadas sem limite.
- **2** — Conhece timeout, mas ignora degradação.
- **3** — Apresenta mecanismos básicos de resiliência.
- **4** — Considera circuit breaker, fallback e backoff.
- **5** — Analisa dependências críticas, bulkheads, saturação, observabilidade e impacto no negócio.

**Perguntas de aprofundamento:**

1. Quando uma retentativa pode piorar o incidente?
2. Como escolheria o timeout de uma chamada?
3. Qual fallback seria inadequado para uma operação financeira?

---

## Pergunta 29 — Contratos e compatibilidade entre serviços

**Nível:** Pleno  
**Categoria:** APIs e evolução de sistemas

**Pergunta do entrevistador:**  
Como você alteraria o contrato de uma API ou evento sem quebrar consumidores existentes?

**O que essa pergunta avalia:**  
Avalia a capacidade de evoluir integrações distribuídas com compatibilidade e controle de mudanças.

**Resposta esperada:**  
A evolução deve preferir mudanças compatíveis com versões anteriores.

Boas práticas incluem:

- Adicionar campos opcionais;
- Evitar remover ou renomear campos abruptamente;
- Manter consumidores tolerantes a campos desconhecidos;
- Versionar contratos quando necessário;
- Comunicar mudanças;
- Utilizar testes de contrato;
- Monitorar consumidores;
- Definir período de descontinuação;
- Fazer migração gradual.

Para eventos, o produtor deve evitar alterar o significado de um campo existente. Quando a mudança for incompatível, pode ser necessário criar uma nova versão do evento.

**Explicação didática:**  
Adicionar um campo opcional geralmente é menos arriscado do que alterar o tipo de um campo existente.

Por exemplo, transformar `valor` de número para texto pode quebrar consumidores que esperam realizar cálculos.

A compatibilidade precisa ser avaliada tanto no sentido produtor-consumidor quanto consumidor-produtor.

**Exemplo prático:**

~~~text
Versão original:
{
  "pedidoId": 100,
  "status": "CRIADO"
}

Evolução compatível:
{
  "pedidoId": 100,
  "status": "CRIADO",
  "origem": "APP"
}
~~~

O novo campo deve ser opcional ou possuir um valor padrão para consumidores antigos.

**Como o candidato deve responder:**

- Explique compatibilidade retroativa;
- Mencione campos opcionais e migração gradual;
- Considere APIs e eventos;
- Fale sobre testes de contrato;
- Explique quando uma nova versão seria necessária;
- Evite afirmar que basta alterar o DTO.

**Resposta fraca ou incompleta:**  
“Eu alteraria o contrato e avisaria os outros times.”

Comunicação é importante, mas não substitui compatibilidade técnica, testes e estratégia de migração.

**Critérios de avaliação:**

- **0** — Não reconhece o risco de quebrar consumidores.
- **1** — Faz alterações incompatíveis sem controle.
- **2** — Conhece versionamento, mas não planeja migração.
- **3** — Propõe evolução compatível básica.
- **4** — Considera testes de contrato, comunicação e descontinuação.
- **5** — Define estratégia gradual com observabilidade, compatibilidade semântica e governança de contratos.

**Perguntas de aprofundamento:**

1. Quando você criaria uma nova versão da API?
2. Como descobriria quais consumidores ainda usam um campo?
3. Como testaria a compatibilidade de um evento Kafka?

---

## Pergunta 30 — Diagnóstico de lentidão em um microsserviço

**Nível:** Sênior  
**Categoria:** Troubleshooting e observabilidade

**Pergunta do entrevistador:**  
Um microsserviço Java começou a apresentar aumento de latência em produção. Como você investigaria o problema?

**O que essa pergunta avalia:**  
Avalia a capacidade de conduzir troubleshooting baseado em evidências, evitando conclusões prematuras.

**Resposta esperada:**  
A investigação deve começar pela confirmação do problema e pela delimitação do impacto.

Eu analisaria:

- Latência por endpoint;
- Percentis, especialmente p95, p99 e p50;
- Taxa de erros;
- Volume de requisições;
- Logs correlacionados;
- Traces distribuídos;
- Uso de CPU e memória;
- Pausas de garbage collection;
- Pools de threads;
- Pools de conexão;
- Tempo de consultas ao banco;
- Latência de dependências externas;
- Filas e consumidores;
- Alterações recentes no código ou na infraestrutura.

Também compararia o comportamento com uma janela anterior e verificaria se o problema ocorre para todos os usuários ou apenas para uma operação específica.

A correção deve ser baseada na causa identificada. Aumentar recursos pode aliviar o sintoma, mas não necessariamente resolve o problema.

**Explicação didática:**  
Média de latência pode esconder problemas graves. Um endpoint pode ter média aceitável, mas p99 muito alto para uma parcela dos usuários.

Traces distribuídos ajudam a identificar em qual etapa o tempo está sendo gasto: aplicação, banco, chamada HTTP, broker ou serialização.

Depois de aplicar uma correção, é necessário acompanhar as métricas para confirmar o resultado e verificar efeitos colaterais.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Alerta de latência] --> B[Confirmar escopo e impacto]
    B --> C[Analisar métricas]
    C --> D[Correlacionar logs e traces]
    D --> E[Identificar dependência lenta]
    E --> F[Verificar mudanças recentes]
    F --> G[Aplicar correção controlada]
    G --> H[Monitorar resultado]
~~~

**Como o candidato deve responder:**

- Comece por métricas e impacto;
- Diferencie sintoma de causa;
- Mencione logs, métricas e traces;
- Considere banco, JVM, rede e dependências;
- Explique como reduziria o risco da correção;
- Evite escolher uma solução antes de coletar evidências.

**Resposta fraca ou incompleta:**  
“Eu aumentaria a memória e o número de instâncias.”

Essa ação pode ser útil em alguns casos, mas não identifica se o problema está no banco, em um lock, em uma dependência externa ou em uma alteração recente.

**Critérios de avaliação:**

- **0** — Não apresenta método de investigação.
- **1** — Tenta corrigir sem coletar evidências.
- **2** — Cita logs, mas não estrutura o diagnóstico.
- **3** — Analisa métricas e dependências principais.
- **4** — Utiliza correlação, percentis e traces.
- **5** — Conduz investigação sistemática, prioriza impacto, propõe mitigação segura e valida a causa raiz.

**Perguntas de aprofundamento:**

1. Por que p99 pode ser mais útil que a média?
2. Como diferenciaria problema de CPU de problema de I/O?
3. Que métricas indicariam saturação do pool de conexões?

---

## Resumo desta parte

- **Perguntas apresentadas:** 21 a 30
- **Perguntas restantes:** 31 a 100
- **Níveis abordados:** Pleno e Sênior
- **Categorias:** microsserviços, integração, Kafka, RabbitMQ, mensageria, resiliência, contratos, troubleshooting e observabilidade
- **Competências avaliadas:** decomposição de serviços, comunicação síncrona e assíncrona, particionamento, roteamento de mensagens, idempotência, Outbox, Saga, evolução de contratos e diagnóstico de problemas distribuídos

A próxima parte continuará com as perguntas **31 a 40**, abordando bancos relacionais e não relacionais, persistência, consistência, cache e desempenho.

---

`markdown
# Roteiro de Entrevista Técnica — Java e Engenharia de Software

> **Parte 4 de 10 — Perguntas 31 a 40 de 100**

**Objetivo:** preparação para uma posição de Desenvolvedor(a) Java Sênior/Especialista, com foco em microsserviços, mensageria, bancos de dados, observabilidade, nuvem, boas práticas, arquitetura e didática técnica.

**Níveis abordados nesta parte:** Pleno e Sênior  
**Estilo:** perguntas conceituais, práticas e baseadas em cenários reais

---

## Pergunta 31 — Transações e propagação no Spring

**Nível:** Pleno  
**Categoria:** Persistência e transações

**Pergunta do entrevistador:**  
Como você definiria o limite transacional de um caso de uso em uma aplicação Spring e quais cuidados teria ao utilizar `@Transactional`?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre delimitação de transações, consistência de dados, propagação e limitações do mecanismo de proxy do Spring.

**Resposta esperada:**  
O limite transacional normalmente deve envolver uma operação de negócio coerente, garantindo que as alterações relacionadas sejam confirmadas ou desfeitas juntas.

O método transacional deve estar preferencialmente em uma camada de serviço, e não diretamente no controller ou em cada método de repositório.

Cuidados importantes:

- Evitar transações muito longas;
- Não realizar chamadas externas demoradas dentro da transação;
- Entender o comportamento de rollback;
- Conhecer os níveis de isolamento;
- Considerar a propagação entre métodos;
- Saber que chamadas internas na mesma classe podem não passar pelo proxy do Spring;
- Avaliar o impacto sobre locks e conexões do banco.

Por padrão, o rollback costuma ocorrer para exceções não verificadas, mas esse comportamento pode ser configurado.

**Explicação didática:**  
Uma transação muito abrangente pode manter conexões e locks por tempo excessivo. Isso pode reduzir a capacidade do banco e aumentar a chance de contenção.

Também é importante entender que uma chamada para outro serviço não participa automaticamente da mesma transação do banco local.

O uso de `@Transactional` depende da infraestrutura do Spring. Em muitos cenários, a anotação é aplicada por meio de proxies. Por isso, uma chamada de um método para outro dentro da mesma instância pode não acionar o comportamento esperado.

**Exemplo prático:**

~~~java
@Service
public class TransferenciaService {

    private final ContaRepository contaRepository;

    public TransferenciaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Transactional
    public void transferir(Long origemId, Long destinoId, BigDecimal valor) {
        Conta origem = contaRepository.buscarPorId(origemId);
        Conta destino = contaRepository.buscarPorId(destinoId);

        origem.debitar(valor);
        destino.creditar(valor);

        // As duas alterações são confirmadas ou revertidas juntas.
    }
}
~~~

**Como o candidato deve responder:**

- Explique que a transação deve representar uma unidade de negócio;
- Mencione commit, rollback e isolamento;
- Explique o risco de chamadas externas;
- Cite transações longas e contenção;
- Demonstre conhecimento sobre proxies;
- Evite afirmar que `@Transactional` coordena automaticamente vários serviços.

**Resposta fraca ou incompleta:**  
“Eu colocaria `@Transactional` em todos os métodos para garantir consistência.”

Isso pode gerar transações excessivas, aumentar contenção e não resolve inconsistências entre sistemas externos.

**Critérios de avaliação:**

- **0** — Não conhece o objetivo de uma transação.
- **1** — Usa a anotação sem compreender seus efeitos.
- **2** — Conhece commit e rollback, mas ignora escopo e limitações.
- **3** — Define corretamente uma transação simples.
- **4** — Considera propagação, isolamento, chamadas externas e duração.
- **5** — Analisa limites transacionais, concorrência, proxies, outbox e consistência distribuída.

**Perguntas de aprofundamento:**

1. Por que uma chamada HTTP dentro de uma transação pode ser problemática?
2. Quando você configuraria rollback para uma exceção verificada?
3. Como investigaria uma transação que está mantendo locks por muito tempo?

---

## Pergunta 32 — Lock otimista e lock pessimista

**Nível:** Pleno  
**Categoria:** Concorrência e bancos de dados

**Pergunta do entrevistador:**  
Como você lidaria com duas requisições concorrentes tentando alterar o mesmo registro?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre concorrência no banco de dados e prevenção de atualizações perdidas.

**Resposta esperada:**  
Duas estratégias comuns são o lock otimista e o lock pessimista.

No **lock otimista**, a entidade possui uma versão ou timestamp. Ao atualizar, a aplicação verifica se a versão continua igual àquela lida anteriormente. Se outra transação alterou o registro, a atualização falha e a aplicação decide se deve informar o conflito, recarregar os dados ou tentar novamente.

No **lock pessimista**, o banco bloqueia o registro durante a transação, impedindo ou restringindo alterações concorrentes.

O lock otimista costuma ser adequado quando conflitos são raros. O lock pessimista pode ser apropriado quando conflitos são frequentes ou quando é necessário reservar o registro temporariamente, mas pode aumentar contenção.

**Explicação didática:**  
Imagine duas requisições lendo o saldo de uma conta ao mesmo tempo. Sem controle, ambas podem calcular novos valores com base no mesmo saldo e uma alteração pode sobrescrever a outra.

O lock otimista detecta que o registro mudou antes de confirmar a atualização. O lock pessimista impede que outra transação altere o registro enquanto ele está bloqueado.

A escolha depende da frequência de conflitos, duração da transação e impacto de aguardar ou rejeitar a operação.

**Exemplo prático:**

~~~java
@Entity
public class Produto {

    @Id
    private Long id;

    private Integer estoque;

    @Version
    private Long versao;

    public void reservar(Integer quantidade) {
        if (estoque < quantidade) {
            throw new IllegalStateException("Estoque insuficiente");
        }

        estoque -= quantidade;
    }
}
~~~

A versão permite detectar que outra transação alterou o mesmo produto antes da confirmação.

**Como o candidato deve responder:**

- Explique o problema de atualização perdida;
- Diferencie lock otimista e pessimista;
- Relacione a escolha à frequência de conflitos;
- Mencione tratamento do conflito;
- Considere duração da transação;
- Evite afirmar que um lock é sempre superior ao outro.

**Resposta fraca ou incompleta:**  
“Eu bloquearia todos os registros até o fim do processamento.”

Essa abordagem pode gerar baixa concorrência, filas e deadlocks.

**Critérios de avaliação:**

- **0** — Não reconhece o problema de concorrência.
- **1** — Permite sobrescrita sem controle.
- **2** — Conhece locks, mas não entende suas diferenças.
- **3** — Explica lock otimista e pessimista.
- **4** — Escolhe uma estratégia com base no cenário.
- **5** — Discute versionamento, contenção, deadlocks, retentativas e métricas de conflito.

**Perguntas de aprofundamento:**

1. Como trataria uma falha de lock otimista para o usuário?
2. Em que situação um lock pessimista seria justificável?
3. Como identificaria deadlocks no banco?

---

## Pergunta 33 — Pool de conexões

**Nível:** Pleno  
**Categoria:** Desempenho e infraestrutura

**Pergunta do entrevistador:**  
Qual é a finalidade de um pool de conexões com o banco de dados e como você investigaria uma aplicação que está esgotando esse pool?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre reutilização de conexões, limites de recursos e diagnóstico de saturação.

**Resposta esperada:**  
Um pool mantém um conjunto de conexões abertas e reutilizáveis, evitando o custo de criar uma nova conexão para cada operação.

O tamanho do pool deve ser compatível com:

- Capacidade do banco;
- Número de instâncias;
- Tempo médio das consultas;
- Volume de requisições;
- Limites de conexão do banco;
- Número de threads da aplicação.

Um pool esgotado pode causar filas e timeouts. A investigação deve observar:

- Conexões ativas;
- Conexões ociosas;
- Tempo de espera por conexão;
- Consultas lentas;
- Transações longas;
- Threads bloqueadas;
- Número de instâncias;
- Erros de timeout.

Aumentar o pool sem identificar a causa pode apenas transferir a saturação para o banco.

**Explicação didática:**  
Se cada instância possui um pool de 50 conexões e existem 10 instâncias, o sistema pode tentar utilizar até 500 conexões. O banco precisa suportar esse volume.

Uma conexão também pode ficar ocupada porque uma consulta está lenta ou porque uma transação realizou uma operação demorada.

**Como o candidato deve responder:**

- Explique reutilização de conexões;
- Relacione o tamanho do pool à capacidade do banco;
- Mencione transações e consultas lentas;
- Considere o número total de instâncias;
- Use métricas para diagnosticar;
- Evite apenas aumentar o limite.

**Resposta fraca ou incompleta:**  
“Eu aumentaria o pool para evitar que as requisições esperassem.”

Isso pode sobrecarregar o banco e piorar o incidente.

**Critérios de avaliação:**

- **0** — Não entende o conceito de pool.
- **1** — Aumenta conexões sem considerar limites.
- **2** — Conhece o pool, mas ignora diagnóstico.
- **3** — Explica seu funcionamento básico.
- **4** — Analisa consultas, transações e capacidade.
- **5** — Correlaciona pool, threads, banco, escalabilidade horizontal e limites operacionais.

**Perguntas de aprofundamento:**

1. Como diferenciaria esgotamento do pool de conexões de lentidão no banco?
2. Que risco existe em configurar o mesmo pool para todos os ambientes?
3. Por que uma transação longa pode consumir recursos do pool?

---

## Pergunta 34 — N+1 queries

**Nível:** Pleno  
**Categoria:** Persistência e desempenho

**Pergunta do entrevistador:**  
O que é o problema de N+1 consultas e como você o identificaria e corrigiria?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre acesso eficiente a dados relacionados e diagnóstico de consultas excessivas.

**Resposta esperada:**  
O problema de N+1 ocorre quando a aplicação executa uma consulta para obter uma lista e depois executa uma nova consulta para cada item relacionado.

Por exemplo:

1. Uma consulta busca 100 pedidos;
2. Para cada pedido, outra consulta busca o cliente;
3. O resultado são 101 consultas, em vez de uma estratégia otimizada.

A identificação pode ser feita por:

- Logs SQL;
- Métricas de consultas;
- Traces;
- Ferramentas de profiling;
- Testes de integração que verificam o número de consultas.

As correções podem incluir:

- `JOIN FETCH`;
- Projeções;
- Consultas específicas;
- Entity graphs;
- Carregamento em lote;
- Ajuste da modelagem;
- Separação entre modelo de persistência e DTO.

A solução deve evitar tanto o N+1 quanto o carregamento excessivo de dados.

**Explicação didática:**  
Carregar tudo com `EAGER` não é uma correção universal. Isso pode trazer dados desnecessários e gerar consultas grandes em outros fluxos.

É melhor definir explicitamente quais dados a operação precisa e buscar somente esse conjunto.

**Exemplo prático:**

~~~java
@Query("""
       select p
       from Pedido p
       join fetch p.cliente
       where p.status = :status
       """)
List<Pedido> buscarComCliente(StatusPedido status);
~~~

A consulta busca os pedidos e os clientes relacionados em uma operação planejada, reduzindo consultas repetidas.

**Como o candidato deve responder:**

- Defina N+1 com um exemplo;
- Explique como identificar o problema;
- Cite mais de uma estratégia de correção;
- Mencione o risco de usar `EAGER` indiscriminadamente;
- Considere o tamanho do resultado;
- Evite tratar apenas o sintoma.

**Resposta fraca ou incompleta:**  
“Eu marcaria todos os relacionamentos como `EAGER`.”

Isso pode aumentar o volume de dados e criar problemas em outras consultas.

**Critérios de avaliação:**

- **0** — Não conhece o problema.
- **1** — Confunde N+1 com erro de conexão.
- **2** — Identifica consultas excessivas, mas não propõe boa solução.
- **3** — Explica e corrige um caso simples.
- **4** — Considera joins, projeções, logs e volume.
- **5** — Analisa o problema por caso de uso, evitando tanto N+1 quanto overfetching.

**Perguntas de aprofundamento:**

1. Por que `EAGER` pode gerar novos problemas?
2. Como testaria que o N+1 não voltou?
3. Quando uma projeção seria melhor que retornar entidades completas?

---

## Pergunta 35 — Cache distribuído

**Nível:** Pleno  
**Categoria:** Desempenho e arquitetura

**Pergunta do entrevistador:**  
Em que situação você utilizaria um cache distribuído em um sistema de microsserviços e quais cuidados teria?

**O que essa pergunta avalia:**  
Avalia a capacidade de utilizar cache sem comprometer consistência, segurança e previsibilidade.

**Resposta esperada:**  
Um cache distribuído pode ser útil quando várias instâncias precisam compartilhar dados temporários e quando a leitura é muito mais frequente que a escrita.

Exemplos:

- Configurações com baixa frequência de alteração;
- Catálogos;
- Tokens temporários;
- Resultados de consultas custosas;
- Controle de sessão, quando apropriado;
- Rate limiting.

Cuidados importantes:

- Definir TTL;
- Planejar invalidação;
- Evitar armazenar dados sensíveis sem proteção;
- Considerar isolamento por usuário e autorização;
- Prevenir cache stampede;
- Definir comportamento quando o cache estiver indisponível;
- Controlar tamanho e memória;
- Avaliar consistência dos dados.

O cache deve ser tratado como uma otimização, e não como a única fonte de verdade, salvo quando o desenho explicitamente o definir dessa forma.

**Explicação didática:**  
O cache stampede ocorre quando muitos itens expiram ao mesmo tempo e várias requisições tentam reconstruí-los simultaneamente.

Algumas estratégias são:

- TTL com variação aleatória;
- Lock por chave;
- Aquecimento controlado;
- Limite de concorrência;
- Retorno temporário de dados antigos, quando seguro.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Solicitação] --> B[Consultar cache]
    B --> C{Encontrou dado válido?}
    C -- Sim --> D[Retornar dado]
    C -- Não --> E[Consultar fonte principal]
    E --> F[Validar resultado]
    F --> G[Armazenar com TTL]
    G --> D
    B --> H{Cache indisponível?}
    H -- Sim --> E
~~~

**Como o candidato deve responder:**

- Explique o objetivo do cache;
- Mencione TTL e invalidação;
- Considere múltiplas instâncias;
- Fale sobre cache stampede;
- Explique o comportamento de fallback;
- Evite armazenar dados sem considerar autorização.

**Resposta fraca ou incompleta:**  
“Eu colocaria tudo no Redis para acelerar a aplicação.”

A resposta não considera validade, invalidação, segurança nem comportamento de falha.

**Critérios de avaliação:**

- **0** — Não entende o uso de cache.
- **1** — Trata o cache como fonte permanente de verdade.
- **2** — Conhece cache, mas ignora invalidação e segurança.
- **3** — Utiliza cache com TTL em caso simples.
- **4** — Considera consistência, falhas e múltiplas instâncias.
- **5** — Discute stampede, aquecimento, isolamento, observabilidade e trade-offs de consistência.

**Perguntas de aprofundamento:**

1. Quando você não utilizaria cache?
2. Como invalidaria o cache após uma alteração no banco?
3. O que faria se o cache distribuído estivesse indisponível?

---

## Pergunta 36 — Modelagem em bancos orientados a documentos

**Nível:** Pleno  
**Categoria:** Banco não relacional

**Pergunta do entrevistador:**  
Como você modelaria dados em um banco orientado a documentos e como decidiria entre embutir ou referenciar informações?

**O que essa pergunta avalia:**  
Avalia a capacidade de modelar dados conforme os padrões de leitura e escrita de um banco não relacional.

**Resposta esperada:**  
Em um banco orientado a documentos, a modelagem deve começar pelos padrões de acesso, e não apenas pela normalização tradicional.

Dados podem ser:

- **Embutidos**, quando são consultados junto com o documento principal, possuem tamanho controlado e ciclo de vida relacionado;
- **Referenciados**, quando são grandes, compartilhados, atualizados independentemente ou acessados por diferentes fluxos.

A decisão deve considerar:

- Frequência de leitura;
- Frequência de atualização;
- Tamanho do documento;
- Necessidade de consistência;
- Duplicidade aceitável;
- Limites da tecnologia;
- Complexidade de manter dados duplicados.

A desnormalização pode melhorar leituras, mas exige estratégia para atualizar cópias.

**Explicação didática:**  
Um endereço de entrega específico de um pedido pode ser embutido no documento do pedido, porque deve representar o endereço utilizado naquela compra, mesmo que o cliente altere seu endereço posteriormente.

Já um catálogo de produtos compartilhado por muitos pedidos pode ser referenciado ou projetado de outra forma, dependendo do caso de uso.

O modelo deve refletir como o sistema realmente consulta e modifica os dados.

**Exemplo de documento:**

~~~json
{
  "pedidoId": 1001,
  "clienteId": 72,
  "status": "CRIADO",
  "enderecoEntrega": {
    "rua": "Rua A",
    "numero": "100",
    "cidade": "São Paulo"
  },
  "itens": [
    {
      "produtoId": 10,
      "descricao": "Produto X",
      "quantidade": 2
    }
  ]
}
~~~

O endereço e a descrição do item podem representar um retrato histórico do pedido.

**Como o candidato deve responder:**

- Comece pelos padrões de acesso;
- Diferencie embutir e referenciar;
- Considere tamanho e ciclo de vida;
- Explique o custo da duplicidade;
- Mencione consistência e atualizações;
- Evite aplicar normalização relacional automaticamente.

**Resposta fraca ou incompleta:**  
“Eu colocaria cada informação em uma coleção separada para evitar duplicidade.”

Isso pode exigir muitas consultas e não aproveitar as características do modelo documental.

**Critérios de avaliação:**

- **0** — Não conhece modelagem documental.
- **1** — Aplica somente regras relacionais.
- **2** — Diferencia documentos e tabelas, mas não decide adequadamente.
- **3** — Modela casos simples por padrão de acesso.
- **4** — Considera duplicidade, consistência e tamanho.
- **5** — Analisa projeções, evolução de schema, consultas reais e custos operacionais.

**Perguntas de aprofundamento:**

1. Quando a duplicação de dados seria aceitável?
2. Como atualizaria documentos que possuem uma informação duplicada?
3. Como lidaria com a evolução do formato dos documentos?

---

## Pergunta 37 — CQRS

**Nível:** Sênior  
**Categoria:** Padrões arquiteturais

**Pergunta do entrevistador:**  
O que é CQRS e em que situação separar os modelos de leitura e escrita seria justificável?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre separação de responsabilidades, modelos especializados e complexidade arquitetural.

**Resposta esperada:**  
CQRS, ou Command Query Responsibility Segregation, separa operações de alteração de estado das operações de consulta.

No modelo:

- **Commands** representam intenções de alteração;
- **Queries** consultam dados sem modificar o estado;
- O modelo de escrita pode priorizar regras e consistência;
- O modelo de leitura pode ser otimizado para consultas específicas.

A separação pode ser justificável quando os modelos de leitura e escrita possuem necessidades muito diferentes, como:

- Alto volume de consultas;
- Consultas complexas;
- Necessidade de projeções específicas;
- Escala independente;
- Uso de diferentes armazenamentos;
- Processamento assíncrono de projeções.

CQRS aumenta a complexidade e não deve ser aplicado automaticamente. Pode introduzir consistência eventual, duplicação de modelos, processos de sincronização e maior dificuldade de operação.

**Explicação didática:**  
Em uma plataforma financeira, o modelo de escrita pode manter regras rigorosas para movimentações. Um modelo de leitura pode organizar os dados em uma projeção otimizada para extratos e dashboards.

A projeção pode ser atualizada por eventos. Nesse caso, pode existir um intervalo entre a alteração realizada e sua disponibilidade na consulta.

**Exemplo de fluxo:**

~~~mermaid
flowchart LR
    A[Comando de negócio] --> B[Modelo de escrita]
    B --> C[Evento de domínio]
    C --> D[Atualização da projeção]
    D --> E[Modelo de leitura]
    F[Consulta] --> E
~~~

**Como o candidato deve responder:**

- Defina commands e queries;
- Explique a motivação para separar modelos;
- Mencione consistência eventual;
- Considere custos operacionais;
- Diferencie CQRS de simplesmente separar classes;
- Apresente um cenário em que o padrão não seria necessário.

**Resposta fraca ou incompleta:**  
“CQRS significa usar dois bancos para qualquer aplicação.”

O padrão não exige necessariamente dois bancos e pode ser desnecessário em sistemas simples.

**Critérios de avaliação:**

- **0** — Não conhece o conceito.
- **1** — Confunde CQRS com microsserviços.
- **2** — Conhece a separação, mas ignora complexidade.
- **3** — Explica o padrão de forma correta.
- **4** — Relaciona o uso a consultas, escala e projeções.
- **5** — Analisa consistência, eventos, operação, custos e critérios para não adotar o padrão.

**Perguntas de aprofundamento:**

1. Como trataria uma projeção atrasada?
2. CQRS exige Event Sourcing?
3. Em que situação CQRS seria complexidade desnecessária?

---

## Pergunta 38 — Event Sourcing

**Nível:** Sênior  
**Categoria:** Arquitetura e persistência

**Pergunta do entrevistador:**  
O que é Event Sourcing e quais seriam os benefícios e riscos de utilizá-lo em um sistema de negócio?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre persistência de eventos, reconstrução de estado e implicações operacionais.

**Resposta esperada:**  
No Event Sourcing, o sistema persiste uma sequência de eventos imutáveis que representam as mudanças ocorridas no domínio. O estado atual pode ser reconstruído aplicando os eventos em ordem.

Benefícios:

- Histórico completo de alterações;
- Auditoria natural;
- Possibilidade de reconstruir projeções;
- Reprocessamento de eventos;
- Rastreabilidade das decisões de negócio.

Riscos e custos:

- Maior complexidade;
- Evolução dos schemas de eventos;
- Necessidade de garantir ordenação;
- Reprocessamento potencialmente caro;
- Correção de eventos já persistidos;
- Consistência eventual das projeções;
- Necessidade de snapshots;
- Dificuldade para equipes sem experiência.

Event Sourcing não é apenas registrar logs. Os eventos persistidos são a fonte de verdade do estado do domínio.

**Explicação didática:**  
Em vez de armazenar somente o saldo atual, o sistema poderia armazenar eventos como:

- `ContaCriada`;
- `DepositoRealizado`;
- `SaqueRealizado`;
- `TarifaCobrada`.

O saldo seria obtido aplicando os eventos na sequência correta.

Se um evento for interpretado de maneira diferente após uma mudança de regra, a reconstrução histórica exige cuidado, pois o comportamento atual pode não ser igual ao comportamento vigente no momento original.

**Exemplo:**

~~~text
ContaCriada(saldoInicial = 100)
DepositoRealizado(valor = 50)
SaqueRealizado(valor = 20)

Saldo reconstruído = 130
~~~

**Como o candidato deve responder:**

- Explique eventos como fonte de verdade;
- Diferencie Event Sourcing de logs;
- Mencione auditoria e reconstrução;
- Considere snapshots e evolução de eventos;
- Explique consistência eventual das projeções;
- Evite recomendar o padrão sem necessidade de negócio.

**Resposta fraca ou incompleta:**  
“Event Sourcing é salvar logs para poder consultar depois.”

Isso não representa o papel dos eventos como fonte principal do estado.

**Critérios de avaliação:**

- **0** — Não conhece o padrão.
- **1** — Confunde eventos com logs comuns.
- **2** — Conhece benefícios, mas ignora custos.
- **3** — Explica o funcionamento básico.
- **4** — Considera projeções, snapshots e evolução.
- **5** — Analisa modelagem, auditoria, reprocessamento, versionamento e critérios de adoção.

**Perguntas de aprofundamento:**

1. Como corrigiria um evento com dados incorretos?
2. Quando utilizaria snapshots?
3. Como garantiria compatibilidade ao evoluir o schema de eventos?

---

## Pergunta 39 — Consistência eventual

**Nível:** Pleno  
**Categoria:** Sistemas distribuídos

**Pergunta do entrevistador:**  
Como você explicaria consistência eventual para uma pessoa de negócio e como decidiria se ela é aceitável?

**O que essa pergunta avalia:**  
Avalia a capacidade de conectar conceitos técnicos a requisitos de negócio e tomar decisões conscientes.

**Resposta esperada:**  
Consistência eventual significa que, após uma alteração, diferentes partes do sistema podem apresentar valores diferentes por um período limitado, até que a atualização seja propagada.

A abordagem pode ser aceitável quando:

- Pequeno atraso é tolerado;
- O dado não é utilizado imediatamente para uma decisão crítica;
- O processo possui status intermediário;
- Existe possibilidade de atualizar ou corrigir a informação;
- O negócio conhece e aceita o comportamento.

Pode ser inadequada para operações em que uma decisão incorreta causa prejuízo relevante, como autorização financeira, controle de limite ou prevenção de fraude.

A decisão deve considerar impacto, janela de divergência, experiência do usuário, mecanismos de reconciliação e requisitos regulatórios.

**Explicação didática:**  
Uma alteração de endereço pode levar alguns segundos para aparecer em todos os sistemas sem grande impacto.

Já uma compra aprovada não deve liberar um produto com base em um estoque desatualizado se isso puder gerar venda indevida.

Quando a consistência eventual for utilizada, a interface pode mostrar estados como “processando”, “aguardando confirmação” ou “atualização pendente”.

**Exemplo prático:**

~~~mermaid
sequenceDiagram
    participant U as Usuário
    participant P as Serviço de pedidos
    participant E as Barramento
    participant E as Serviço de estoque

    U->>P: Cria pedido
    P-->>U: Pedido recebido
    P->>E: Publica evento
    E->>E: Atualiza estoque
    E-->>P: Confirma processamento
~~~

**Como o candidato deve responder:**

- Explique o conceito sem jargão excessivo;
- Relacione a decisão ao impacto do negócio;
- Mencione estados intermediários;
- Considere reconciliação e monitoramento;
- Diferencie atraso tolerável de inconsistência perigosa;
- Evite afirmar que consistência eventual significa ausência de controle.

**Resposta fraca ou incompleta:**  
“Consistência eventual significa que os dados podem ficar errados.”

O objetivo não é aceitar dados permanentemente incorretos, mas permitir divergência temporária com mecanismos de convergência.

**Critérios de avaliação:**

- **0** — Não compreende o conceito.
- **1** — Trata divergência como erro aceitável em qualquer contexto.
- **2** — Reconhece atraso, mas não avalia impacto.
- **3** — Explica consistência eventual corretamente.
- **4** — Relaciona a decisão ao negócio e à experiência do usuário.
- **5** — Discute reconciliação, idempotência, observabilidade, requisitos críticos e governança.

**Perguntas de aprofundamento:**

1. Como exibiria uma operação ainda não confirmada?
2. Como detectaria divergências entre sistemas?
3. Que operações financeiras exigiriam consistência mais forte?

---

## Pergunta 40 — Data Lake, Data Warehouse e sistemas transacionais

**Nível:** Sênior  
**Categoria:** Arquitetura de dados

**Pergunta do entrevistador:**  
Como você diferenciaria um banco transacional, um Data Warehouse e um Data Lake, e como evitaria usar a mesma solução para todos os objetivos?

**O que essa pergunta avalia:**  
Avalia visão arquitetural sobre diferentes necessidades de armazenamento, processamento e análise de dados.

**Resposta esperada:**  
Um sistema transacional, geralmente chamado de OLTP, é otimizado para operações frequentes de negócio, como criar pedidos, atualizar pagamentos e consultar saldos com consistência operacional.

Um Data Warehouse é voltado à análise estruturada, relatórios e indicadores. Normalmente organiza dados preparados para consultas analíticas.

Um Data Lake armazena grandes volumes de dados em diferentes formatos, estruturados ou não estruturados, podendo servir a análises, ciência de dados e processamento posterior.

A arquitetura deve considerar:

- Tipo de carga;
- Latência esperada;
- Volume;
- Consistência;
- Governança;
- Segurança;
- Custo;
- Retenção;
- Qualidade dos dados;
- Necessidade de processamento em lote ou streaming.

Usar o banco transacional diretamente para relatórios pesados pode prejudicar as operações de negócio.

**Explicação didática:**  
O banco transacional deve priorizar o funcionamento da aplicação. Relatórios complexos podem consumir CPU, memória, conexões e I/O, afetando usuários.

Uma alternativa é extrair dados por eventos ou processos de carga e disponibilizá-los em uma estrutura própria para análise.

Isso também exige cuidado com:

- Dados pessoais;
- Controle de acesso;
- Linhagem;
- Qualidade;
- Atraso de atualização;
- Custos de armazenamento.

**Exemplo de arquitetura:**

~~~mermaid
flowchart LR
    A[Sistemas transacionais] --> B[Eventos ou extração]
    B --> C[Processamento de dados]
    C --> D[Data Lake]
    C --> E[Data Warehouse]
    E --> F[Relatórios e indicadores]
    D --> G[Análises avançadas]
~~~

**Como o candidato deve responder:**

- Diferencie OLTP, Data Warehouse e Data Lake;
- Relacione cada solução ao padrão de uso;
- Mencione impacto de relatórios no banco transacional;
- Considere segurança, governança e custo;
- Explique lote e streaming quando relevante;
- Evite tratar qualquer repositório como solução universal.

**Resposta fraca ou incompleta:**  
“Eu colocaria todos os dados no Data Lake porque ele aceita qualquer formato.”

Isso ignora requisitos transacionais, qualidade, governança, latência e experiência operacional.

**Critérios de avaliação:**

- **0** — Não diferencia os conceitos.
- **1** — Escolhe a tecnologia sem considerar o objetivo.
- **2** — Conhece os nomes, mas não explica os usos.
- **3** — Diferencia os papéis básicos.
- **4** — Relaciona volume, latência, análise e impacto operacional.
- **5** — Propõe uma arquitetura coerente com governança, segurança, qualidade, custos e evolução.

**Perguntas de aprofundamento:**

1. Por que relatórios pesados podem prejudicar o banco transacional?
2. Como garantiria a qualidade dos dados analíticos?
3. Como trataria dados pessoais em um Data Lake?

---

## Resumo desta parte

- **Perguntas apresentadas:** 31 a 40
- **Perguntas restantes:** 41 a 100
- **Níveis abordados:** Pleno e Sênior
- **Categorias:** transações, concorrência, bancos de dados, desempenho, cache, CQRS, Event Sourcing e arquitetura de dados
- **Competências avaliadas:** definição de limites transacionais, tratamento de concorrência, diagnóstico de saturação, otimização de consultas, modelagem de dados, consistência eventual e escolha de padrões arquiteturais

A próxima parte continuará com as perguntas **41 a 50**, abordando segurança, autenticação, autorização, proteção de APIs, mensageria segura e gestão de segredos.

---

`markdown
# Roteiro de Entrevista Técnica — Java e Engenharia de Software

> **Parte 5 de 10 — Perguntas 41 a 50 de 100**

**Objetivo:** preparação para uma posição de Desenvolvedor(a) Java Sênior/Especialista, com foco em microsserviços, mensageria, bancos de dados, observabilidade, nuvem, boas práticas, arquitetura e didática técnica.

**Níveis abordados nesta parte:** Júnior, Pleno e Sênior  
**Estilo:** perguntas conceituais, práticas e baseadas em cenários reais

---

## Pergunta 41 — Autenticação e autorização

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Qual é a diferença entre autenticação e autorização em uma aplicação Java e como esses conceitos seriam aplicados em uma API?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende os fundamentos de controle de acesso e sabe diferenciar a identificação do usuário da permissão para executar uma ação.

**Resposta esperada:**  
Autenticação é o processo de confirmar a identidade de quem está acessando o sistema. Por exemplo, validar usuário e senha ou um token de acesso.

Autorização é o processo de verificar se a identidade autenticada pode executar determinada ação ou acessar determinado recurso.

Exemplo:

- A autenticação identifica que o usuário é `cliente-123`;
- A autorização verifica se esse usuário pode consultar o pedido `456`;
- Um administrador pode ter permissão para cancelar o pedido;
- Um cliente comum pode apenas consultar os próprios pedidos.

A autorização deve ser validada no backend. Não é suficiente esconder botões na interface, pois um consumidor pode chamar a API diretamente.

**Explicação didática:**  
Uma pessoa pode estar autenticada e ainda assim não possuir autorização para executar uma ação.

Por exemplo, um funcionário autenticado no sistema bancário pode consultar seus próprios dados, mas não necessariamente acessar os dados de todos os clientes.

A aplicação deve verificar:

- Quem é o usuário;
- Quais são seus papéis ou permissões;
- Qual recurso está sendo acessado;
- Qual operação está sendo executada;
- Se existe relação entre o usuário e o recurso.

**Exemplo prático:**

~~~java
@GetMapping("/pedidos/{id}")
public PedidoResponse buscarPedido(
        @PathVariable Long id,
        Authentication authentication
) {
    String usuarioId = authentication.getName();

    // A camada de serviço também deve verificar
    // se o pedido pertence ao usuário autenticado.
    return pedidoService.buscarPermitido(id, usuarioId);
}
~~~

A autenticação fornece a identidade, mas a regra de autorização deve confirmar se o acesso ao pedido é permitido.

**Como o candidato deve responder:**

- Diferencie autenticação e autorização;
- Explique que ambas devem ser aplicadas no backend;
- Mencione papéis, permissões e acesso ao recurso;
- Apresente um exemplo de autorização por propriedade;
- Evite considerar apenas o controle visual da interface;
- Explique que estar autenticado não significa ter acesso irrestrito.

**Resposta fraca ou incompleta:**  
“Autenticação e autorização são a mesma coisa: verificar se o usuário pode entrar no sistema.”

Essa resposta não diferencia identidade de permissão e ignora o controle de acesso aos recursos.

**Critérios de avaliação:**

- **0** — Não conhece os conceitos.
- **1** — Confunde autenticação e autorização.
- **2** — Diferencia parcialmente, mas ignora o backend.
- **3** — Explica corretamente os conceitos básicos.
- **4** — Relaciona papéis, permissões e recursos.
- **5** — Discute autorização por recurso, menor privilégio, segregação de funções e riscos de acesso indevido.

**Perguntas de aprofundamento:**

1. Como impediria que um usuário consultasse o pedido de outra pessoa?
2. Qual é a diferença entre autorização baseada em papéis e baseada em atributos?
3. Por que esconder uma funcionalidade no frontend não é uma medida de segurança suficiente?

---

## Pergunta 42 — JWT e sessões

**Nível:** Pleno  
**Categoria:** Segurança e APIs

**Pergunta do entrevistador:**  
Quais diferenças você considera ao escolher entre autenticação baseada em sessão e autenticação baseada em JWT?

**O que essa pergunta avalia:**  
Avalia a capacidade de analisar mecanismos de autenticação em arquiteturas distribuídas e compreender os trade-offs de segurança e operação.

**Resposta esperada:**  
Na autenticação baseada em sessão, o servidor mantém informações associadas à sessão do usuário. O cliente envia um identificador de sessão a cada requisição.

No modelo baseado em JWT, o token contém informações assinadas que podem ser validadas pelos serviços sem necessariamente consultar uma sessão central a cada requisição.

Sessões podem facilitar:

- Revogação imediata;
- Controle centralizado;
- Armazenamento de estado no servidor.

JWT pode facilitar:

- Comunicação entre microsserviços;
- Validação local;
- Escalabilidade horizontal sem compartilhar sessões.

Por outro lado, JWT exige cuidados:

- Expiração curta;
- Rotação e renovação segura;
- Proteção contra roubo;
- Não armazenar dados sensíveis no payload;
- Estratégia de revogação;
- Validação de assinatura, emissor e audiência;
- Controle do algoritmo permitido.

JWT não é automaticamente mais seguro ou mais adequado.

**Explicação didática:**  
Um JWT normalmente é apenas codificado e assinado. O conteúdo pode ser lido por quem possuir o token. Portanto, não se deve colocar senhas, segredos ou informações sensíveis no payload.

Se um JWT for roubado, ele poderá ser utilizado até expirar ou ser invalidado por algum mecanismo adicional.

Em aplicações críticas, pode ser necessário combinar tokens de curta duração, refresh tokens protegidos, rotação e mecanismos de revogação.

**Como o candidato deve responder:**

- Compare estado no servidor e validação local;
- Explique os riscos de tokens roubados;
- Mencione expiração e revogação;
- Diferencie assinatura de criptografia;
- Considere microsserviços e escalabilidade;
- Evite afirmar que JWT elimina a necessidade de controle de acesso.

**Resposta fraca ou incompleta:**  
“JWT é sempre melhor porque não precisa consultar o banco.”

Essa resposta ignora revogação, roubo de token, tamanho do token e validações necessárias.

**Critérios de avaliação:**

- **0** — Não diferencia sessão e JWT.
- **1** — Trata JWT como mecanismo automaticamente seguro.
- **2** — Conhece o formato, mas ignora revogação e exposição.
- **3** — Compara os modelos de forma básica.
- **4** — Considera expiração, escalabilidade e riscos.
- **5** — Analisa ciclo de vida, rotação, revogação, confiança entre serviços e requisitos de segurança.

**Perguntas de aprofundamento:**

1. Como revogaria um JWT antes do vencimento?
2. Que informações não colocaria no payload do token?
3. Como protegeria um refresh token?

---

## Pergunta 43 — Princípio do menor privilégio

**Nível:** Pleno  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como você aplicaria o princípio do menor privilégio em uma arquitetura composta por microsserviços e recursos de nuvem?

**O que essa pergunta avalia:**  
Avalia a capacidade de limitar permissões de usuários, aplicações e componentes de infraestrutura.

**Resposta esperada:**  
O princípio do menor privilégio determina que cada identidade deve possuir apenas as permissões necessárias para executar sua função.

Em uma arquitetura de microsserviços, isso significa:

- Cada serviço deve possuir uma identidade própria;
- O serviço de pedidos não deve ter acesso irrestrito ao banco de pagamentos;
- Acesso de leitura e escrita deve ser separado;
- Permissões devem ser específicas por recurso;
- Credenciais não devem ser compartilhadas entre aplicações;
- Acesso administrativo deve ser restrito e auditado;
- Permissões temporárias devem ser preferidas quando possível.

Na nuvem, isso pode ser aplicado por meio de políticas de identidade, roles, service accounts, security groups e permissões específicas para filas, buckets e bancos.

**Explicação didática:**  
Se todos os serviços utilizam a mesma credencial administrativa, o comprometimento de um único serviço pode permitir acesso a todo o ambiente.

Com identidades separadas, o impacto de uma invasão pode ser limitado.

A segurança deve ser avaliada também entre ambientes. Uma aplicação de desenvolvimento não deveria possuir as mesmas permissões de produção.

**Exemplo de política conceitual:**

~~~text
Serviço de pedidos:
- Pode ler produtos;
- Pode criar e atualizar pedidos;
- Pode publicar eventos de pedido;
- Não pode consultar diretamente dados de pagamento;
- Não pode excluir dados de produção;
- Não pode administrar usuários.
~~~

**Como o candidato deve responder:**

- Defina menor privilégio;
- Relacione o princípio a identidades separadas;
- Considere usuários, serviços e infraestrutura;
- Mencione permissões por recurso;
- Fale sobre auditoria e ambientes;
- Evite utilizar credenciais administrativas em aplicações.

**Resposta fraca ou incompleta:**  
“Eu criaria um usuário com acesso total para evitar problemas de permissão.”

Isso aumenta significativamente o impacto de erros, vazamentos ou comprometimento da aplicação.

**Critérios de avaliação:**

- **0** — Não conhece o princípio.
- **1** — Defende permissões amplas.
- **2** — Entende parcialmente, mas não aplica a serviços.
- **3** — Define permissões específicas em casos simples.
- **4** — Considera identidades, ambientes e auditoria.
- **5** — Estrutura uma estratégia completa com segregação, acesso temporário, revisão e resposta a incidentes.

**Perguntas de aprofundamento:**

1. Como descobriria quais permissões um serviço realmente utiliza?
2. Qual é o risco de compartilhar uma mesma credencial entre microsserviços?
3. Como trataria permissões diferentes para desenvolvimento, homologação e produção?

---

## Pergunta 44 — Gestão de segredos

**Nível:** Pleno  
**Categoria:** Segurança e operação

**Pergunta do entrevistador:**  
Como você armazenaria e utilizaria senhas, chaves de API e certificados em uma aplicação Java executada na nuvem?

**O que essa pergunta avalia:**  
Avalia conhecimentos sobre proteção, distribuição e rotação de credenciais.

**Resposta esperada:**  
Segredos não devem ser armazenados diretamente no código-fonte nem versionados em repositórios.

Uma solução adequada pode utilizar um serviço de gerenciamento de segredos da nuvem ou uma ferramenta especializada. A aplicação deve receber acesso por meio de uma identidade controlada, sem embutir uma credencial administrativa no código.

Boas práticas incluem:

- Criptografar segredos em repouso e em trânsito;
- Restringir acesso por serviço;
- Rotacionar credenciais;
- Evitar registrar segredos em logs;
- Controlar acesso de operadores;
- Auditar leituras e alterações;
- Utilizar diferentes segredos por ambiente;
- Invalidar credenciais expostas rapidamente.

A configuração da aplicação deve distinguir propriedades comuns de informações sensíveis.

**Explicação didática:**  
Colocar uma senha em uma variável de ambiente é melhor do que deixá-la no código, mas isso não resolve todos os riscos. A variável ainda pode aparecer em processos, diagnósticos ou configurações de implantação.

Por isso, deve existir uma estratégia completa de armazenamento, acesso, rotação e auditoria.

Também é importante que mensagens de erro não exibam tokens, URLs com credenciais ou respostas completas de serviços externos.

**Como o candidato deve responder:**

- Recomende um gerenciador de segredos;
- Explique permissões por identidade;
- Mencione rotação e auditoria;
- Fale sobre logs e vazamento acidental;
- Considere certificados e chaves;
- Evite sugerir credenciais no repositório.

**Resposta fraca ou incompleta:**  
“Eu colocaria as senhas no `application.properties` e protegeria o repositório.”

Isso ainda pode expor os segredos a pessoas ou processos que não deveriam acessá-los.

**Critérios de avaliação:**

- **0** — Armazena segredos de forma insegura.
- **1** — Versiona credenciais diretamente.
- **2** — Usa variáveis de ambiente, mas ignora rotação e auditoria.
- **3** — Recomenda armazenamento externo básico.
- **4** — Considera identidade, rotação, logs e ambientes.
- **5** — Define ciclo de vida completo de segredos, acesso temporário, auditoria e resposta a exposição.

**Perguntas de aprofundamento:**

1. Como faria a rotação de uma senha sem indisponibilizar a aplicação?
2. O que faria se uma chave de produção fosse publicada acidentalmente?
3. Como impediria que um segredo aparecesse em um log de erro?

---

## Pergunta 45 — Segurança em mensageria

**Nível:** Pleno  
**Categoria:** Mensageria e segurança

**Pergunta do entrevistador:**  
Quais medidas você adotaria para proteger a comunicação entre uma aplicação Java e um broker de mensagens?

**O que essa pergunta avalia:**  
Avalia a capacidade de proteger transporte, autenticação, autorização e conteúdo das mensagens.

**Resposta esperada:**  
As medidas dependem do broker, mas normalmente incluem:

- Criptografia em trânsito com TLS;
- Autenticação dos produtores e consumidores;
- Autorização por tópico, fila ou exchange;
- Identidades separadas para cada aplicação;
- Rotação de certificados e credenciais;
- Validação de certificados;
- Controle de acesso administrativo;
- Auditoria de operações;
- Limitação de exposição de dados sensíveis;
- Proteção contra mensagens malformadas;
- Monitoramento de falhas de autenticação.

A mensagem também deve possuir um contrato controlado e não deve carregar dados sensíveis desnecessários.

Quando necessário, dados sensíveis podem ser criptografados no nível da aplicação, além da proteção do transporte.

**Explicação didática:**  
TLS protege a comunicação durante o trânsito, mas não necessariamente protege uma mensagem depois que ela foi armazenada no broker ou consumida por uma aplicação autorizada.

Por isso, é necessário combinar:

- Segurança do canal;
- Autenticação;
- Autorização;
- Proteção do conteúdo;
- Controle do ciclo de vida das mensagens.

O consumidor também deve validar tamanho, formato, versão e origem dos dados recebidos.

**Como o candidato deve responder:**

- Mencione TLS e autenticação;
- Explique autorização por recurso;
- Considere dados sensíveis;
- Fale sobre identidades separadas;
- Aborde validação de mensagens;
- Evite considerar que estar dentro da rede interna elimina riscos.

**Resposta fraca ou incompleta:**  
“Basta deixar o broker em uma rede privada.”

Uma rede privada reduz exposição, mas não substitui autenticação, autorização, criptografia e auditoria.

**Critérios de avaliação:**

- **0** — Não identifica riscos de segurança.
- **1** — Confia apenas na rede interna.
- **2** — Menciona TLS, mas ignora autorização.
- **3** — Explica proteção básica do broker.
- **4** — Considera identidades, permissões e conteúdo.
- **5** — Discute defesa em profundidade, rotação, auditoria, contratos e proteção de dados sensíveis.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre criptografar o canal e criptografar a mensagem?
2. Como impediria que um consumidor lesse tópicos não relacionados à sua função?
3. Que informações você evitaria colocar em um evento?

---

## Pergunta 46 — OWASP e vulnerabilidades em APIs

**Nível:** Pleno  
**Categoria:** Segurança de aplicações

**Pergunta do entrevistador:**  
Quais vulnerabilidades comuns você procuraria ao revisar uma API REST Java?

**O que essa pergunta avalia:**  
Avalia a capacidade de identificar riscos práticos de segurança em APIs e aplicar controles preventivos.

**Resposta esperada:**  
Eu verificaria, entre outros pontos:

- Falhas de autenticação;
- Falhas de autorização;
- Acesso indevido a objetos;
- Injeção de SQL ou comandos;
- Validação insuficiente de entradas;
- Exposição excessiva de dados;
- Falta de limitação de requisições;
- Configurações inseguras;
- Falta de proteção contra replay quando necessário;
- Logs contendo dados sensíveis;
- Uploads sem validação;
- Ausência de controle de tamanho;
- Mensagens de erro muito detalhadas;
- Dependências vulneráveis.

Um ponto importante é validar autorização para cada recurso, e não apenas verificar se o usuário está autenticado.

**Explicação didática:**  
Uma API pode estar corretamente protegida contra usuários anônimos e ainda possuir uma falha grave de autorização.

Exemplo: o usuário faz uma requisição autenticada para:

~~~text
GET /clientes/999/documentos
~~~

Se o backend apenas verifica o token e não valida se o cliente `999` pertence ao usuário autenticado, existe risco de acesso indevido a dados.

A revisão deve considerar o fluxo completo, desde a entrada até o acesso ao banco e a resposta enviada.

**Como o candidato deve responder:**

- Mencione autenticação e autorização;
- Cite validação de entrada;
- Considere exposição excessiva;
- Fale sobre rate limiting e logs;
- Relacione vulnerabilidades ao fluxo real;
- Evite apenas decorar nomes de categorias.

**Resposta fraca ou incompleta:**  
“Eu verificaria se existe senha forte e se a API usa HTTPS.”

Esses controles são importantes, mas não cobrem autorização por recurso, injeção, exposição de dados e abuso da API.

**Critérios de avaliação:**

- **0** — Não reconhece vulnerabilidades comuns.
- **1** — Cita apenas senha ou firewall.
- **2** — Conhece alguns riscos, mas não sabe analisá-los.
- **3** — Identifica vulnerabilidades básicas em APIs.
- **4** — Relaciona riscos a controles práticos.
- **5** — Conduz uma revisão sistemática baseada em ameaça, impacto, exploração e defesa em profundidade.

**Perguntas de aprofundamento:**

1. Como testaria uma possível falha de acesso indevido a objetos?
2. Por que validar apenas no frontend é insuficiente?
3. Como reduziria o impacto de uma API abusada por muitas requisições?

---

## Pergunta 47 — Criptografia, hash e dados sensíveis

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Qual é a diferença entre criptografia, hash e codificação, e quando cada conceito seria utilizado?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende conceitos fundamentais utilizados para proteger ou representar informações.

**Resposta esperada:**  
**Codificação** transforma dados para facilitar transporte ou representação. Ela não tem como objetivo proteger o conteúdo. Base64 é um exemplo de codificação, não de criptografia.

**Hash** transforma um dado em um resumo de tamanho fixo. Em geral, o processo não foi projetado para ser revertido. É utilizado, por exemplo, para armazenar senhas com algoritmos próprios para senha, como Argon2, bcrypt ou scrypt, sempre com salt e parâmetros adequados.

**Criptografia** transforma dados utilizando uma chave e pode permitir a recuperação do conteúdo original por quem possui a chave apropriada.

Existem:

- Criptografia simétrica, com a mesma chave para cifrar e decifrar;
- Criptografia assimétrica, com chaves relacionadas, normalmente pública e privada.

A escolha depende do objetivo: confidencialidade, integridade, autenticação ou representação.

**Explicação didática:**  
Uma senha não deve ser armazenada com Base64, porque qualquer pessoa pode decodificá-la.

Também não é adequado utilizar um hash rápido e genérico sem salt, pois isso facilita ataques de força bruta e uso de tabelas pré-calculadas.

Para dados que precisam ser recuperados, como determinados documentos protegidos, pode ser necessário utilizar criptografia reversível e gerenciar as chaves com segurança.

**Como o candidato deve responder:**

- Diferencie codificação, hash e criptografia;
- Explique o uso de salt para senhas;
- Mencione criptografia simétrica e assimétrica;
- Relacione o mecanismo ao objetivo;
- Evite chamar Base64 de criptografia;
- Não recomende armazenar senhas de forma reversível.

**Resposta fraca ou incompleta:**  
“Eu usaria Base64 para criptografar senhas.”

Base64 apenas representa os dados em outro formato e não impede que sejam recuperados.

**Critérios de avaliação:**

- **0** — Confunde os conceitos completamente.
- **1** — Usa codificação como proteção.
- **2** — Conhece hash ou criptografia parcialmente.
- **3** — Diferencia os conceitos fundamentais.
- **4** — Relaciona o uso a senhas, chaves e confidencialidade.
- **5** — Discute salt, gestão de chaves, integridade, rotação e escolha baseada na ameaça.

**Perguntas de aprofundamento:**

1. Por que não se deve criptografar senhas para armazená-las?
2. Em que situação você usaria criptografia simétrica?
3. Como protegeria a chave utilizada para criptografar dados?

---

## Pergunta 48 — Threat modeling

**Nível:** Sênior  
**Categoria:** Segurança e arquitetura

**Pergunta do entrevistador:**  
Como você realizaria uma análise de ameaças para um novo microsserviço que processa dados financeiros?

**O que essa pergunta avalia:**  
Avalia a capacidade de incorporar segurança desde o desenho da solução, considerando ameaças, impacto e controles.

**Resposta esperada:**  
Eu começaria entendendo:

- Quais dados são processados;
- Quem são os usuários e sistemas envolvidos;
- Quais são os limites de confiança;
- Quais entradas são externas;
- Onde os dados são armazenados;
- Quais integrações existem;
- Quais operações possuem efeitos financeiros;
- Quais requisitos regulatórios se aplicam.

Depois, identificaria ameaças como:

- Acesso indevido;
- Roubo de credenciais;
- Alteração de mensagens;
- Replay de operações;
- Duplicidade de transações;
- Vazamento de dados;
- Indisponibilidade;
- Escalonamento de privilégio;
- Fraude por manipulação de parâmetros;
- Comprometimento de dependências.

Para cada ameaça, avaliaria probabilidade e impacto, definindo controles preventivos, detectivos e corretivos.

**Explicação didática:**  
Threat modeling é uma análise estruturada de como um sistema pode ser atacado ou utilizado de forma indevida.

Em uma operação financeira, não basta proteger o endpoint. É necessário pensar em:

- Idempotência;
- Autorização;
- Assinatura ou integridade das mensagens;
- Auditoria;
- Limites de valor;
- Detecção de comportamento anômalo;
- Reconciliação;
- Recuperação de incidentes.

A análise deve ser revisada quando houver mudança significativa na arquitetura ou no fluxo de negócio.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Identificar ativos] --> B[Mapear fluxos de dados]
    B --> C[Definir limites de confiança]
    C --> D[Identificar ameaças]
    D --> E[Avaliar impacto e probabilidade]
    E --> F[Definir controles]
    F --> G[Testar e monitorar]
    G --> H[Revisar com a evolução do sistema]
~~~

**Como o candidato deve responder:**

- Comece pelos ativos e fluxos de dados;
- Identifique atores e limites de confiança;
- Considere ataques técnicos e fraude de negócio;
- Relacione ameaças a controles;
- Mencione auditoria e monitoramento;
- Explique que segurança deve ser contínua;
- Evite restringir a análise a firewall e autenticação.

**Resposta fraca ou incompleta:**  
“Eu colocaria autenticação forte e criptografia, porque o serviço é financeiro.”

Esses controles são importantes, mas não constituem uma análise completa de ameaças.

**Critérios de avaliação:**

- **0** — Não apresenta abordagem de segurança.
- **1** — Sugere apenas autenticação e firewall.
- **2** — Cita ameaças isoladas, sem priorização.
- **3** — Identifica riscos e controles básicos.
- **4** — Analisa fluxos, impacto, autorização e auditoria.
- **5** — Conduz threat modeling sistemático, incluindo abuso de negócio, fraude, detecção, resposta e evolução.

**Perguntas de aprofundamento:**

1. Como identificaria um ataque de replay em uma operação financeira?
2. Que evidências registraria para investigar uma fraude?
3. Como decidiria quais ameaças devem ser tratadas primeiro?

---

## Pergunta 49 — Privacidade e proteção de dados

**Nível:** Sênior  
**Categoria:** Segurança, privacidade e governança

**Pergunta do entrevistador:**  
Como você projetaria um microsserviço para reduzir riscos relacionados ao tratamento de dados pessoais?

**O que essa pergunta avalia:**  
Avalia a capacidade de aplicar privacidade, minimização de dados e controles de ciclo de vida em uma arquitetura distribuída.

**Resposta esperada:**  
O serviço deve coletar e processar apenas os dados necessários para uma finalidade definida.

Boas práticas incluem:

- Classificar os dados;
- Minimizar coleta e armazenamento;
- Restringir acesso;
- Criptografar dados sensíveis;
- Aplicar retenção e descarte;
- Mascarar dados em ambientes não produtivos;
- Evitar dados pessoais em logs;
- Controlar cópias em filas, caches e backups;
- Registrar acessos relevantes;
- Definir fluxos para correção, anonimização ou exclusão quando aplicável;
- Avaliar fornecedores e serviços terceirizados.

Privacidade não é apenas uma preocupação jurídica. Ela também deve influenciar modelagem, observabilidade, contratos e operação.

**Explicação didática:**  
Um dado pode deixar de ser necessário para a aplicação principal, mas continuar existindo em:

- Logs;
- Filas;
- Dead-letter queues;
- Caches;
- Réplicas;
- Backups;
- Data Lakes;
- Ambientes de teste.

Por isso, o ciclo de vida deve ser analisado de ponta a ponta.

Também é importante que equipes de desenvolvimento não utilizem cópias irrestritas de dados reais em ambientes de teste.

**Como o candidato deve responder:**

- Fale sobre minimização e finalidade;
- Considere o ciclo de vida completo;
- Mencione logs, backups e mensageria;
- Explique mascaramento em ambientes inferiores;
- Relacione acesso à necessidade da função;
- Evite armazenar dados “por precaução” sem justificativa.

**Resposta fraca ou incompleta:**  
“Eu criptografaria o banco e deixaria o restante como está.”

A criptografia do banco não impede vazamentos em logs, mensagens, caches, backups ou acessos indevidos.

**Critérios de avaliação:**

- **0** — Ignora privacidade.
- **1** — Armazena e compartilha todos os dados sem controle.
- **2** — Menciona criptografia, mas ignora ciclo de vida.
- **3** — Aplica controles básicos de proteção.
- **4** — Considera minimização, logs, ambientes e retenção.
- **5** — Integra privacidade à arquitetura, governança, observabilidade, mensageria, fornecedores e resposta a incidentes.

**Perguntas de aprofundamento:**

1. Como evitaria dados pessoais em logs de erro?
2. O que faria com mensagens antigas que contêm dados pessoais?
3. Como disponibilizaria dados reais para testes sem expor informações identificáveis?

---

## Pergunta 50 — Resposta a um incidente de segurança

**Nível:** Sênior  
**Categoria:** Segurança, incidentes e liderança técnica

**Pergunta do entrevistador:**  
Foi identificado que uma credencial de produção pode ter sido exposta em um repositório. Como você conduziria a resposta ao incidente?

**O que essa pergunta avalia:**  
Avalia a capacidade de agir sob pressão, reduzir impacto, preservar evidências e coordenar uma resposta técnica e organizacional.

**Resposta esperada:**  
A prioridade inicial é conter o risco sem destruir evidências importantes.

As ações podem incluir:

1. Confirmar o que foi exposto e qual era o escopo da credencial;
2. Revogar ou rotacionar a credencial;
3. Identificar sistemas e recursos que poderiam ter sido acessados;
4. Verificar logs de uso e tentativas suspeitas;
5. Restringir permissões temporariamente;
6. Avaliar necessidade de bloquear acessos;
7. Preservar evidências;
8. Acionar os responsáveis por segurança, operações e gestão do incidente;
9. Corrigir o repositório e impedir novas exposições;
10. Comunicar o incidente conforme os procedimentos aplicáveis;
11. Realizar análise de causa raiz;
12. Implementar ações preventivas.

Remover o segredo do commit atual não é suficiente se ele permanece no histórico ou se já foi copiado.

**Explicação didática:**  
Uma credencial exposta deve ser considerada comprometida até que exista evidência confiável de que não foi acessada.

A resposta precisa equilibrar:

- Contenção rápida;
- Continuidade do serviço;
- Preservação de evidências;
- Comunicação adequada;
- Redução do impacto;
- Aprendizado posterior.

Não se deve simplesmente apagar arquivos, alterar logs ou ocultar o problema. Isso pode dificultar a investigação e aumentar o risco.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Detectar possível exposição] --> B[Confirmar escopo]
    B --> C[Revogar ou rotacionar credencial]
    C --> D[Preservar evidências]
    D --> E[Analisar logs e acessos]
    E --> F[Conter impactos adicionais]
    F --> G[Comunicar responsáveis]
    G --> H[Corrigir causa raiz]
    H --> I[Revisar controles e monitoramento]
~~~

**Como o candidato deve responder:**

- Priorize revogação ou rotação;
- Explique análise de escopo e logs;
- Mencione preservação de evidências;
- Considere comunicação e escalonamento;
- Diferencie contenção de correção definitiva;
- Fale sobre prevenção de recorrência;
- Evite apenas apagar o segredo do repositório.

**Resposta fraca ou incompleta:**  
“Eu apagaria o commit e avisaria o time.”

Isso pode não invalidar a credencial nem revelar se ela foi utilizada.

**Critérios de avaliação:**

- **0** — Não sabe agir diante do incidente.
- **1** — Apenas remove o arquivo exposto.
- **2** — Sugere trocar a senha, mas ignora investigação.
- **3** — Propõe revogação e correção básica.
- **4** — Considera contenção, logs, comunicação e causa raiz.
- **5** — Conduz resposta estruturada, preserva evidências, avalia impacto, coordena equipes e implementa melhorias sustentáveis.

**Perguntas de aprofundamento:**

1. Como verificaria se a credencial foi utilizada?
2. O que faria se a rotação imediata pudesse interromper uma operação crítica?
3. Quais controles implementaria para evitar que o problema se repetisse?

---

## Resumo desta parte

- **Perguntas apresentadas:** 41 a 50
- **Perguntas restantes:** 51 a 100
- **Níveis abordados:** Júnior, Pleno e Sênior
- **Categorias:** segurança, autenticação, autorização, APIs, mensageria, privacidade, governança e resposta a incidentes
- **Competências avaliadas:** controle de acesso, uso seguro de tokens, menor privilégio, gestão de segredos, proteção de brokers, análise de vulnerabilidades, criptografia, threat modeling, privacidade e resposta a incidentes

A próxima parte continuará com as perguntas **51 a 60**, abordando observabilidade, logs, métricas, tracing distribuído, monitoramento e troubleshooting em produção.

---

`markdown
# Roteiro de Entrevista Técnica — Java e Engenharia de Software

> **Parte 6 de 10 — Perguntas 51 a 60 de 100**

**Objetivo:** preparação para uma posição de Desenvolvedor(a) Java Sênior/Especialista, com foco em microsserviços, mensageria, bancos de dados, observabilidade, nuvem, boas práticas, arquitetura e didática técnica.

**Níveis abordados nesta parte:** Júnior, Pleno e Sênior  
**Estilo:** perguntas conceituais, práticas e baseadas em cenários reais

---

## Pergunta 51 — Os três pilares da observabilidade

**Nível:** Júnior  
**Categoria:** Observabilidade

**Pergunta do entrevistador:**  
Quais são os principais sinais utilizados para observar uma aplicação em produção?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende os fundamentos de observabilidade e sabe diferenciar logs, métricas e traces.

**Resposta esperada:**  
Os principais sinais são:

- **Logs:** registros de eventos ocorridos na aplicação;
- **Métricas:** valores numéricos agregados ao longo do tempo;
- **Traces:** acompanhamento do caminho de uma requisição através de diferentes componentes.

Esses sinais se complementam.

Um log pode explicar o detalhe de uma falha. Uma métrica pode mostrar que a taxa de erro aumentou. Um trace pode revelar que a lentidão ocorreu em uma chamada ao banco ou em outro microsserviço.

Observabilidade não é apenas coletar dados. É conseguir compreender o estado interno do sistema a partir dos sinais disponíveis.

**Explicação didática:**  
Considere uma requisição de criação de pedido:

- Uma métrica mostra que o endpoint passou de 200 ms para 2 segundos;
- Um trace mostra que 1,8 segundo foi gasto no serviço de estoque;
- Um log registra que o serviço de estoque sofreu timeout ao consultar o banco.

A análise conjunta é mais eficiente do que consultar cada fonte isoladamente.

**Exemplo prático:**

~~~text
Métrica:
http_server_request_duration_p95 = 2.0s

Trace:
pedido-service -> estoque-service -> banco

Log:
Timeout ao obter conexão com o banco de estoque
~~~

**Como o candidato deve responder:**

- Defina logs, métricas e traces;
- Explique que os sinais são complementares;
- Dê um exemplo de investigação;
- Diferencie observabilidade de simples monitoramento;
- Relacione os sinais a diagnóstico e operação.

**Resposta fraca ou incompleta:**  
“Observabilidade é colocar logs na aplicação.”

Logs são importantes, mas sozinhos não fornecem uma visão adequada de latência, tendências e dependências distribuídas.

**Critérios de avaliação:**

- **0** — Não conhece os conceitos básicos.
- **1** — Confunde logs, métricas e traces.
- **2** — Cita alguns sinais, mas não explica suas diferenças.
- **3** — Explica corretamente os três pilares.
- **4** — Relaciona os sinais a troubleshooting.
- **5** — Demonstra visão integrada, considerando contexto, custo, segurança e ação operacional.

**Perguntas de aprofundamento:**

1. Que tipo de informação é melhor representada por uma métrica?
2. Quando um trace seria mais útil que um log?
3. Quais riscos existem ao coletar todos os logs sem controle?

---

## Pergunta 52 — Logs estruturados

**Nível:** Júnior  
**Categoria:** Logs e diagnóstico

**Pergunta do entrevistador:**  
Como você estruturaria os logs de um microsserviço Java para facilitar a investigação de problemas?

**O que essa pergunta avalia:**  
Avalia a capacidade de produzir registros úteis, pesquisáveis e seguros em ambientes distribuídos.

**Resposta esperada:**  
Os logs devem ser estruturados, preferencialmente em um formato que possa ser processado automaticamente, como JSON.

Informações úteis incluem:

- Timestamp;
- Nível do log;
- Nome da aplicação;
- Ambiente;
- Operação executada;
- Identificador da requisição;
- Identificador de correlação;
- Identificador do usuário, quando permitido;
- Código do erro;
- Duração da operação;
- Nome da dependência;
- Mensagem segura;
- Stack trace para falhas inesperadas.

Também é importante evitar:

- Senhas;
- Tokens;
- Dados pessoais desnecessários;
- Conteúdo completo de requisições sensíveis;
- Logs duplicados em várias camadas;
- Mensagens vagas como “deu erro”.

**Explicação didática:**  
Um log como este é difícil de pesquisar:

~~~text
Deu erro ao chamar o serviço.
~~~

Um registro estruturado oferece contexto:

~~~json
{
  "level": "ERROR",
  "event": "payment_authorization_failed",
  "orderId": "12345",
  "correlationId": "abc-789",
  "dependency": "payment-service",
  "durationMs": 2300,
  "errorCode": "PAYMENT_TIMEOUT"
}
~~~

O segundo formato permite filtrar falhas de pagamento, correlacionar uma requisição e gerar métricas derivadas.

**Como o candidato deve responder:**

- Recomende logs estruturados;
- Mencione contexto e correlação;
- Considere níveis de log;
- Fale sobre dados sensíveis;
- Explique a importância de mensagens acionáveis;
- Diferencie informação útil de excesso de dados.

**Resposta fraca ou incompleta:**  
“Eu colocaria vários `System.out.println()` para descobrir o que aconteceu.”

Essa abordagem não oferece padronização, correlação, níveis adequados nem controle operacional.

**Critérios de avaliação:**

- **0** — Não sabe produzir logs úteis.
- **1** — Utiliza apenas mensagens genéricas.
- **2** — Conhece níveis de log, mas ignora contexto e segurança.
- **3** — Estrutura logs básicos com informações relevantes.
- **4** — Considera correlação, formato estruturado e proteção de dados.
- **5** — Define uma estratégia consistente de logging, com cardinalidade, amostragem, retenção, auditoria e custo operacional.

**Perguntas de aprofundamento:**

1. Em que situação utilizaria `INFO`, `WARN` e `ERROR`?
2. Quais dados jamais deveriam aparecer nos logs?
3. Como reduziria o volume de logs durante um incidente?

---

## Pergunta 53 — Métricas técnicas e de negócio

**Nível:** Pleno  
**Categoria:** Métricas e monitoramento

**Pergunta do entrevistador:**  
Quais métricas você acompanharia para avaliar a saúde de um microsserviço?

**O que essa pergunta avalia:**  
Avalia se o candidato consegue selecionar métricas relevantes para operação, desempenho e resultado de negócio.

**Resposta esperada:**  
Eu acompanharia métricas técnicas e de negócio.

Métricas técnicas:

- Taxa de requisições;
- Latência média e percentis;
- Taxa de erros;
- Disponibilidade;
- Uso de CPU;
- Uso de memória;
- Garbage collection;
- Threads ativas;
- Pool de conexões;
- Tempo de consultas;
- Tamanho de filas;
- Lag de consumidores;
- Taxa de retentativas;
- Estado de circuit breakers.

Métricas de negócio:

- Pedidos criados;
- Pagamentos aprovados;
- Pagamentos recusados;
- Tempo de processamento;
- Taxa de conversão;
- Quantidade de operações pendentes;
- Volume financeiro processado;
- Falhas por etapa do processo.

As métricas devem possuir nomes, unidades e dimensões bem definidos.

**Explicação didática:**  
Uma aplicação pode estar utilizando pouca CPU e ainda assim apresentar um problema grave de negócio. Por exemplo, o serviço pode responder rapidamente, mas rejeitar todos os pagamentos.

Por outro lado, CPU alta nem sempre significa falha para o usuário. O impacto deve ser analisado junto com latência, erros e indicadores de negócio.

Também é necessário controlar a cardinalidade das métricas. Não é recomendável criar uma série temporal diferente para cada identificador de usuário ou pedido.

**Como o candidato deve responder:**

- Diferencie métricas técnicas e de negócio;
- Mencione latência, erros e tráfego;
- Considere filas e dependências;
- Explique percentis;
- Fale sobre cardinalidade;
- Relacione métricas a decisões operacionais.

**Resposta fraca ou incompleta:**  
“Eu monitoraria apenas CPU e memória.”

Essas métricas são importantes, mas não mostram necessariamente a experiência do usuário nem o resultado do negócio.

**Critérios de avaliação:**

- **0** — Não conhece métricas relevantes.
- **1** — Monitora apenas recursos da máquina.
- **2** — Cita métricas técnicas, mas ignora o negócio.
- **3** — Define métricas básicas de saúde.
- **4** — Considera latência, erros, dependências e indicadores de negócio.
- **5** — Estrutura uma estratégia com percentis, cardinalidade, SLIs, custos e relação com objetivos do produto.

**Perguntas de aprofundamento:**

1. Por que p95 e p99 podem ser mais úteis que a média?
2. O que é cardinalidade em uma métrica?
3. Qual métrica de negócio você usaria para um serviço de pagamentos?

---

## Pergunta 54 — Rastreamento distribuído

**Nível:** Pleno  
**Categoria:** Tracing distribuído

**Pergunta do entrevistador:**  
Como o tracing distribuído ajuda a investigar uma requisição que percorre vários microsserviços?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre propagação de contexto e análise de latência em arquiteturas distribuídas.

**Resposta esperada:**  
O tracing distribuído acompanha uma operação desde sua entrada até as chamadas realizadas por outros serviços, bancos, brokers ou APIs externas.

Um trace normalmente é composto por:

- Um identificador da operação completa;
- Spans que representam etapas individuais;
- Relação entre serviço chamador e serviço chamado;
- Duração de cada etapa;
- Status da operação;
- Atributos relevantes;
- Eventos ou erros associados.

Com isso, é possível identificar onde o tempo foi consumido ou em qual serviço ocorreu a falha.

O contexto deve ser propagado corretamente em chamadas HTTP e, quando aplicável, em mensagens assíncronas.

**Explicação didática:**  
Uma requisição pode ter o seguinte caminho:

~~~text
API Gateway: 20 ms
pedido-service: 100 ms
estoque-service: 800 ms
banco de dados: 750 ms
~~~

Sem tracing, pode parecer que o `pedido-service` está lento. Com tracing, fica evidente que o tempo está concentrado no estoque ou no banco.

Em fluxos assíncronos, a correlação pode atravessar produtores e consumidores, embora o modelo de visualização seja diferente de uma chamada síncrona.

**Como o candidato deve responder:**

- Defina trace e span;
- Explique propagação de contexto;
- Relacione tracing à latência;
- Considere chamadas síncronas e assíncronas;
- Mencione amostragem;
- Evite afirmar que tracing substitui logs e métricas.

**Resposta fraca ou incompleta:**  
“Tracing é colocar um identificador no log.”

Um identificador ajuda na correlação, mas tracing também representa a estrutura e a duração das operações.

**Critérios de avaliação:**

- **0** — Não conhece tracing distribuído.
- **1** — Confunde trace com log.
- **2** — Conhece identificadores, mas não entende spans.
- **3** — Explica a finalidade do tracing.
- **4** — Relaciona tracing a dependências, latência e contexto.
- **5** — Discute propagação, mensagens assíncronas, amostragem, custo e privacidade dos atributos coletados.

**Perguntas de aprofundamento:**

1. Como propagaria o contexto em uma mensagem Kafka?
2. Qual é a diferença entre um trace e um span?
3. Por que não seria adequado coletar todos os traces em sistemas de altíssimo volume?

---

## Pergunta 55 — Correlation ID e Request ID

**Nível:** Pleno  
**Categoria:** Observabilidade e integração

**Pergunta do entrevistador:**  
Qual é a finalidade de um correlation ID e como você o utilizaria em uma arquitetura de microsserviços?

**O que essa pergunta avalia:**  
Avalia a capacidade de correlacionar eventos pertencentes ao mesmo fluxo distribuído.

**Resposta esperada:**  
Um correlation ID identifica uma operação ou fluxo de negócio que atravessa diferentes componentes.

Ele pode ser:

- Recebido de um sistema chamador;
- Gerado na entrada da requisição;
- Propagado em chamadas downstream;
- Incluído em logs;
- Associado a métricas ou traces;
- Transportado em mensagens assíncronas.

É importante diferenciar:

- **Request ID:** identifica uma requisição específica;
- **Correlation ID:** pode agrupar várias requisições e etapas de um mesmo fluxo;
- **Business ID:** identifica a entidade ou operação de negócio, como pedido ou pagamento.

O identificador não deve ser utilizado como mecanismo de autenticação. Também deve ser validado para evitar entradas excessivamente grandes ou malformadas.

**Explicação didática:**  
Uma operação de compra pode iniciar em uma API, gerar uma mensagem, ser processada por estoque e pagamento e terminar com uma notificação.

O mesmo identificador de correlação permite pesquisar os registros relacionados ao fluxo inteiro, mesmo que cada serviço tenha seu próprio request ID.

**Exemplo prático:**

~~~text
correlationId: flow-8f20

API Gateway       -> requestId: req-001
pedido-service    -> requestId: req-002
estoque-service   -> requestId: req-003
pagamento-service -> requestId: req-004
~~~

Todos os registros podem conter o mesmo `correlationId`, permitindo reconstruir a jornada completa da operação.

**Como o candidato deve responder:**

- Diferencie correlation ID, request ID e identificador de negócio;
- Explique como propagaria o valor;
- Considere chamadas HTTP e mensagens;
- Mencione logs e tracing;
- Fale sobre validação e segurança;
- Evite utilizar o identificador como segredo ou credencial.

**Resposta fraca ou incompleta:**  
“Eu geraria um ID em cada serviço e usaria qualquer um deles para pesquisar os logs.”

Isso dificulta a correlação do fluxo completo e pode fazer com que etapas da mesma operação não sejam encontradas.

**Critérios de avaliação:**

- **0** — Não entende a finalidade da correlação.
- **1** — Gera identificadores sem propagá-los.
- **2** — Conhece request ID, mas ignora fluxos distribuídos.
- **3** — Explica o uso básico de correlation ID.
- **4** — Relaciona o conceito a logs, traces e mensageria.
- **5** — Estrutura uma estratégia completa de correlação, distinguindo contexto técnico, negócio, privacidade e confiabilidade.

**Perguntas de aprofundamento:**

1. Como propagaria o correlation ID em uma mensagem assíncrona?
2. Qual é a diferença entre correlation ID e trace ID?
3. O que faria se um cliente enviasse um correlation ID inválido?

---

## Pergunta 56 — SLIs, SLOs e SLAs

**Nível:** Sênior  
**Categoria:** Confiabilidade e operação

**Pergunta do entrevistador:**  
Qual é a diferença entre SLI, SLO e SLA, e como você os utilizaria para definir a confiabilidade de um serviço?

**O que essa pergunta avalia:**  
Avalia a capacidade de transformar expectativas de confiabilidade em indicadores mensuráveis e objetivos operacionais.

**Resposta esperada:**  
- **SLI — Service Level Indicator:** é o indicador medido, como taxa de sucesso, latência ou disponibilidade;
- **SLO — Service Level Objective:** é o objetivo interno definido para esse indicador;
- **SLA — Service Level Agreement:** é um acordo formal com consumidores ou clientes, normalmente com consequências em caso de descumprimento.

Exemplo:

- SLI: percentual de requisições bem-sucedidas;
- SLO: pelo menos 99,9% de sucesso em um período mensal;
- SLA: compromisso contratual de 99,5% de disponibilidade.

Os objetivos devem refletir o impacto para o usuário e para o negócio. Não é necessário buscar 100% de disponibilidade em todos os serviços, pois isso pode elevar muito o custo e reduzir a velocidade de evolução.

**Explicação didática:**  
Se um serviço possui um SLO de 99,9% de sucesso, existe uma margem de erro conhecida. Essa margem pode ser chamada de orçamento de erro.

Quando o serviço consome rapidamente esse orçamento, a equipe pode priorizar estabilidade, correções e redução de riscos antes de lançar novas funcionalidades.

O SLO deve ser baseado em uma métrica que represente a experiência real do usuário. CPU, por exemplo, pode ser útil operacionalmente, mas não necessariamente representa a qualidade percebida.

**Como o candidato deve responder:**

- Diferencie SLI, SLO e SLA;
- Apresente um exemplo numérico;
- Relacione os indicadores à experiência do usuário;
- Explique o conceito de orçamento de erro;
- Considere custo e criticidade;
- Evite tratar disponibilidade de infraestrutura como único indicador.

**Resposta fraca ou incompleta:**  
“SLA é a mesma coisa que monitoramento da aplicação.”

SLA é um acordo, enquanto SLI e SLO são conceitos usados para medir e definir objetivos de nível de serviço.

**Critérios de avaliação:**

- **0** — Não conhece os conceitos.
- **1** — Confunde todos os termos.
- **2** — Conhece disponibilidade, mas não diferencia os níveis.
- **3** — Explica corretamente SLI, SLO e SLA.
- **4** — Relaciona os conceitos a metas e experiência do usuário.
- **5** — Utiliza orçamento de erro, impacto de negócio, priorização e trade-offs de confiabilidade.

**Perguntas de aprofundamento:**

1. Como escolheria um SLI para um serviço de pagamentos?
2. O que faria quando o orçamento de erro fosse consumido?
3. Por que um SLO de 100% pode ser inadequado?

---

## Pergunta 57 — Alertas eficazes

**Nível:** Pleno  
**Categoria:** Monitoramento e resposta a incidentes

**Pergunta do entrevistador:**  
Como você definiria alertas úteis para um microsserviço sem gerar excesso de notificações?

**O que essa pergunta avalia:**  
Avalia a capacidade de criar alertas acionáveis, relacionados ao impacto real e adequados à operação.

**Resposta esperada:**  
Um alerta deve indicar uma situação que exige investigação ou ação. Não basta alertar para qualquer alteração de métrica.

Eu consideraria:

- Impacto para o usuário;
- Severidade;
- Duração do problema;
- Limites baseados em comportamento histórico;
- SLOs;
- Taxa de erro;
- Latência;
- Saturação;
- Falhas em dependências;
- Tamanho de filas;
- Lag de consumidores;
- Existência de runbook;
- Responsável pelo atendimento.

Alertas muito sensíveis geram fadiga e podem fazer com que incidentes importantes sejam ignorados.

É útil separar alertas críticos, que exigem ação imediata, de avisos informativos ou tarefas de acompanhamento.

**Explicação didática:**  
Um alerta de CPU acima de 70% pode não representar um problema. A aplicação pode estar saudável e operar normalmente nesse nível.

Já uma taxa de erro acima do limite definido por vários minutos pode exigir atendimento imediato.

Um bom alerta deve responder:

- O que está acontecendo?
- Qual é o impacto?
- Qual serviço está afetado?
- Quem deve agir?
- Quais ações iniciais são recomendadas?

**Como o candidato deve responder:**

- Relacione alertas ao impacto;
- Mencione severidade e duração;
- Considere SLOs;
- Fale sobre alertas acionáveis;
- Explique a importância de runbooks;
- Evite alertar para toda variação de métrica.

**Resposta fraca ou incompleta:**  
“Eu criaria alertas para qualquer métrica acima de um valor definido.”

Isso pode gerar muitos falsos positivos e não diferencia situações críticas de comportamentos normais.

**Critérios de avaliação:**

- **0** — Não sabe definir alertas.
- **1** — Cria alertas indiscriminadamente.
- **2** — Conhece limites, mas ignora impacto e ruído.
- **3** — Define alertas básicos para erros e indisponibilidade.
- **4** — Considera severidade, duração, SLOs e ação operacional.
- **5** — Estrutura uma estratégia baseada em sintomas, burn rate, criticidade, runbooks e redução de fadiga.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre alerta e dashboard?
2. Como reduziria falsos positivos?
3. Que alerta definiria para uma fila de pagamentos acumulando mensagens?

---

## Pergunta 58 — Investigação de aumento de latência

**Nível:** Pleno  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Um endpoint que normalmente responde em 200 milissegundos passou a apresentar p95 de 3 segundos. Como você investigaria o problema?

**O que essa pergunta avalia:**  
Avalia a capacidade de conduzir uma investigação técnica organizada e baseada em evidências.

**Resposta esperada:**  
Eu começaria confirmando:

- Quando o problema começou;
- Quais endpoints foram afetados;
- Qual percentual de usuários foi impactado;
- Se houve aumento de tráfego;
- Se a taxa de erro também aumentou;
- Se o problema ocorre em todas as regiões ou instâncias;
- Quais alterações foram feitas recentemente.

Em seguida, analisaria:

- Traces distribuídos;
- Tempo gasto em banco;
- Chamadas externas;
- Pool de conexões;
- Pool de threads;
- CPU e memória;
- Pausas de garbage collection;
- Locks;
- Filas internas;
- Latência de rede;
- Consultas lentas;
- Estado de circuit breakers.

A correção deve começar por uma mitigação segura, quando necessária, e depois avançar para a causa raiz.

**Explicação didática:**  
A média de 200 milissegundos pode continuar baixa enquanto uma parcela das requisições apresenta lentidão extrema. Por isso, o p95 ajuda a observar a experiência de uma parcela relevante dos usuários.

Se o trace mostrar que a maior parte do tempo está em uma consulta ao banco, a investigação deve seguir para o plano de execução, índices, volume de dados e concorrência.

Se a lentidão estiver em uma dependência externa, podem ser necessários timeout, circuit breaker ou degradação controlada.

**Como o candidato deve responder:**

- Comece delimitando o impacto;
- Use percentis em vez de apenas médias;
- Analise traces, métricas e logs;
- Considere banco, JVM, rede e dependências;
- Diferencie mitigação de causa raiz;
- Valide o resultado após a correção.

**Resposta fraca ou incompleta:**  
“Eu aumentaria o número de instâncias e a memória.”

Essa ação pode aliviar o problema temporariamente, mas não identifica a causa e pode aumentar custos sem resolver a latência.

**Critérios de avaliação:**

- **0** — Não apresenta uma abordagem de investigação.
- **1** — Tenta corrigir sem coletar evidências.
- **2** — Cita logs, mas não estrutura o diagnóstico.
- **3** — Analisa métricas e dependências principais.
- **4** — Usa percentis, traces e comparação com alterações recentes.
- **5** — Conduz investigação sistemática, propõe mitigação segura, identifica a causa raiz e valida a solução.

**Perguntas de aprofundamento:**

1. Por que o p95 pode ser mais útil que a média?
2. Como diferenciaria lentidão de CPU de lentidão causada por I/O?
3. Que evidências indicariam saturação do pool de conexões?

---

## Pergunta 59 — Monitoramento de consumidores Kafka

**Nível:** Pleno  
**Categoria:** Mensageria e observabilidade

**Pergunta do entrevistador:**  
Quais métricas e sinais você acompanharia para monitorar consumidores Kafka em produção?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre operação, capacidade de processamento e detecção de atrasos em consumidores Kafka.

**Resposta esperada:**  
Eu acompanharia:

- Consumer lag;
- Taxa de consumo;
- Taxa de produção;
- Throughput por partição;
- Tempo de processamento;
- Taxa de erros;
- Quantidade de retentativas;
- Mensagens enviadas para dead-letter;
- Rebalances;
- Estado dos consumidores;
- Número de partições atribuídas;
- Uso de CPU e memória;
- Tempo de espera por recursos externos;
- Offset processado;
- Idade da mensagem mais antiga não processada.

O lag precisa ser analisado em conjunto com a taxa de produção e a capacidade de consumo. Um lag alto pode ser aceitável durante um pico curto, mas é preocupante quando cresce continuamente ou quando viola o tempo máximo de processamento esperado pelo negócio.

**Explicação didática:**  
Se os produtores publicam 1.000 mensagens por segundo e os consumidores processam apenas 800, o atraso tende a crescer.

Adicionar consumidores pode ajudar apenas se existirem partições disponíveis e se o gargalo estiver no processamento paralelo. Se o problema estiver no banco de dados ou em uma API externa, simplesmente adicionar consumidores pode aumentar a pressão sobre a dependência.

Também é necessário observar rebalances frequentes, pois eles podem interromper o consumo e reduzir o throughput.

**Como o candidato deve responder:**

- Explique consumer lag;
- Relacione produção, consumo e capacidade;
- Mencione partições e paralelismo;
- Considere tempo de processamento e erros;
- Fale sobre rebalances e dead-letter;
- Evite tratar qualquer lag como incidente imediato.

**Resposta fraca ou incompleta:**  
“Eu monitoraria apenas se o consumidor está ligado.”

Um consumidor ativo pode estar processando lentamente, falhando continuamente ou acumulando mensagens.

**Critérios de avaliação:**

- **0** — Não conhece sinais de saúde de consumidores.
- **1** — Verifica apenas se o processo está ativo.
- **2** — Conhece lag, mas ignora causas e contexto.
- **3** — Monitora lag, erros e taxa de consumo.
- **4** — Relaciona métricas a partições, rebalances e dependências.
- **5** — Estrutura uma estratégia completa com capacidade, idade das mensagens, SLOs, backpressure e impacto de reprocessamento.

**Perguntas de aprofundamento:**

1. O que faria se o consumer lag crescesse continuamente?
2. Por que aumentar consumidores pode não resolver o problema?
3. Como detectaria um consumidor que está falhando e tentando processar a mesma mensagem repetidamente?

---

## Pergunta 60 — Observabilidade de uma operação assíncrona

**Nível:** Sênior  
**Categoria:** Observabilidade e arquitetura distribuída

**Pergunta do entrevistador:**  
Como você projetaria a observabilidade de uma operação assíncrona que começa em uma API, passa por Kafka e termina em um serviço de pagamentos?

**O que essa pergunta avalia:**  
Avalia a capacidade de observar fluxos distribuídos, assíncronos e de longa duração, relacionando sinais técnicos ao estado de negócio.

**Resposta esperada:**  
Eu utilizaria uma combinação de:

- Identificador da operação de negócio;
- Correlation ID;
- Trace ID e contexto distribuído;
- Logs estruturados;
- Métricas técnicas;
- Métricas de negócio;
- Rastreamento de offsets;
- Estado persistido da operação;
- Eventos de sucesso e falha;
- Monitoramento de retentativas;
- Dead-letter queue;
- Alertas relacionados a SLOs;
- Dashboards por etapa do fluxo.

A API deve retornar ao consumidor um identificador ou estado que permita acompanhar a operação posteriormente, em vez de manter a requisição aberta até o fim do processamento.

O serviço de pagamentos deve atualizar o estado de forma idempotente e registrar informações suficientes para investigar falhas sem expor dados sensíveis.

**Explicação didática:**  
Um fluxo possível seria:

1. O cliente solicita a criação de um pagamento;
2. A API registra a operação como `PENDENTE`;
3. A aplicação publica um evento no Kafka;
4. O consumidor processa o pagamento;
5. O serviço atualiza o estado para `APROVADO`, `RECUSADO` ou `ERRO`;
6. O cliente consulta o estado usando o identificador da operação.

A observabilidade precisa permitir responder:

- A requisição inicial foi aceita?
- O evento foi publicado?
- O consumidor recebeu a mensagem?
- Qual foi o tempo de espera?
- O pagamento foi processado?
- Houve retentativas?
- A operação terminou ou está presa?
- Qual foi o motivo da falha?

**Exemplo de fluxo:**

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant A as API
    participant B as Banco
    participant K as Kafka
    participant P as Serviço de pagamentos

    C->>A: Solicita pagamento
    A->>B: Registra operação PENDENTE
    A->>K: Publica evento com correlationId
    A-->>C: Retorna operationId

    K->>P: Entrega evento
    P->>B: Atualiza processamento
    P->>P: Autoriza pagamento
    P->>B: Registra APROVADO ou RECUSADO

    C->>A: Consulta operationId
    A->>B: Busca estado atual
    A-->>C: Retorna estado da operação
~~~

O fluxo deve possuir métricas como:

- Tempo entre recebimento da API e publicação;
- Tempo de permanência do evento no Kafka;
- Tempo de processamento do consumidor;
- Taxa de aprovação e recusa;
- Quantidade de mensagens em retentativa;
- Quantidade de operações pendentes;
- Idade da operação mais antiga pendente;
- Taxa de falhas por dependência.

**Como o candidato deve responder:**

- Explique a diferença entre requisição síncrona e operação assíncrona;
- Mencione estado persistido e identificador da operação;
- Relacione correlation ID, trace e business ID;
- Considere idempotência e reprocessamento;
- Inclua métricas de negócio e técnicas;
- Fale sobre retentativas, dead-letter e operações presas;
- Considere proteção de dados sensíveis;
- Explique como o usuário saberia o resultado da operação.

**Resposta fraca ou incompleta:**  
“Eu colocaria logs no produtor e no consumidor e verificaria manualmente se o pagamento foi concluído.”

Essa abordagem não permite acompanhar sistematicamente o fluxo, medir atrasos, detectar operações presas nem oferecer visibilidade adequada ao usuário.

**Critérios de avaliação:**

- **0** — Não apresenta estratégia de observabilidade.
- **1** — Utiliza apenas logs isolados.
- **2** — Usa correlation ID, mas ignora estado e métricas.
- **3** — Define logs, métricas e acompanhamento básico.
- **4** — Considera Kafka, idempotência, retentativas e estado da operação.
- **5** — Estrutura uma solução completa com tracing distribuído, métricas técnicas e de negócio, SLOs, dead-letter, reconciliação, segurança e experiência do usuário.

**Perguntas de aprofundamento:**

1. Como identificaria uma operação presa entre a publicação e o consumo?
2. Como evitaria que uma mensagem repetida gerasse uma cobrança duplicada?
3. Como exibiria ao cliente uma falha temporária do serviço de pagamentos?
4. Que informações não deveriam aparecer nos logs desse fluxo?
5. Como criaria um alerta para pagamentos pendentes há tempo excessivo?

---

## Resumo desta parte

- **Perguntas apresentadas:** 51 a 60
- **Perguntas restantes:** 61 a 100
- **Níveis abordados:** Júnior, Pleno e Sênior
- **Categorias:** observabilidade, logs, métricas, tracing, correlação, confiabilidade, troubleshooting e mensageria
- **Competências avaliadas:** estruturação de logs, definição de métricas, rastreamento distribuído, criação de alertas, uso de SLIs e SLOs, investigação de latência, monitoramento de consumidores Kafka e observabilidade de fluxos assíncronos

A próxima parte continuará com as perguntas **61 a 70**, abordando computação em nuvem, AWS, containers, Kubernetes, escalabilidade e práticas de implantação.

---

`markdown
# Roteiro de Entrevista Técnica — Java e Engenharia de Software

> **Parte 7 de 10 — Perguntas 61 a 70 de 100**

**Objetivo:** preparação para uma posição de Desenvolvedor(a) Java Sênior/Especialista, com foco em microsserviços, mensageria, bancos de dados, observabilidade, nuvem, boas práticas, arquitetura e didática técnica.

**Níveis abordados nesta parte:** Júnior, Pleno e Sênior  
**Estilo:** perguntas conceituais, práticas e baseadas em cenários reais

---

## Pergunta 61 — Conceitos fundamentais de computação em nuvem

**Nível:** Júnior  
**Categoria:** Computação em nuvem

**Pergunta do entrevistador:**  
Quais são os principais benefícios e desafios de executar uma aplicação Java em um provedor de nuvem?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende os conceitos básicos de nuvem e consegue relacioná-los à execução, escalabilidade e operação de aplicações.

**Resposta esperada:**  
Entre os principais benefícios estão:

- Provisionamento rápido de recursos;
- Escalabilidade conforme a demanda;
- Alta disponibilidade;
- Distribuição geográfica;
- Serviços gerenciados;
- Automação de infraestrutura;
- Modelo de pagamento conforme o uso;
- Facilidade para criar ambientes separados.

Também existem desafios:

- Controle de custos;
- Segurança e configuração de permissões;
- Dependência do provedor;
- Complexidade operacional;
- Latência de rede;
- Gestão de dados e backups;
- Monitoramento;
- Conformidade regulatória;
- Riscos de configurações incorretas.

A nuvem não elimina a necessidade de arquitetura, operação e governança. Ela fornece recursos e serviços, mas a aplicação ainda precisa ser projetada corretamente.

**Explicação didática:**  
Uma aplicação pode ganhar novas instâncias quando o volume de requisições aumenta. Porém, para isso funcionar, ela precisa ser capaz de operar corretamente em várias instâncias.

Isso normalmente exige:

- Estado compartilhado fora da memória local;
- Configuração externalizada;
- Balanceamento de carga;
- Observabilidade;
- Controle de concorrência;
- Estratégia de deploy;
- Gestão adequada de dados.

Utilizar a nuvem simplesmente como substituição de um servidor físico não aproveita todos os benefícios e pode manter os mesmos problemas operacionais.

**Exemplo prático:**

~~~text
Aplicação Java:
- Executada em múltiplas instâncias;
- Recebe tráfego por um balanceador;
- Utiliza banco gerenciado;
- Armazena arquivos em object storage;
- Publica eventos em um serviço de mensageria;
- Envia métricas e logs para uma plataforma centralizada.
~~~

**Como o candidato deve responder:**

- Explique elasticidade e escalabilidade;
- Mencione serviços gerenciados;
- Considere segurança e custos;
- Relacione nuvem à alta disponibilidade;
- Explique que a aplicação precisa ser adequada ao ambiente distribuído;
- Evite tratar nuvem apenas como hospedagem de máquinas virtuais.

**Resposta fraca ou incompleta:**  
“Nuvem é um servidor remoto que pode ser acessado pela internet.”

Essa resposta é limitada e não aborda elasticidade, automação, serviços gerenciados, segurança ou governança.

**Critérios de avaliação:**

- **0** — Não conhece os conceitos básicos de nuvem.
- **1** — Confunde nuvem com um servidor comum.
- **2** — Cita escalabilidade, mas ignora desafios.
- **3** — Explica benefícios básicos da nuvem.
- **4** — Considera segurança, custos, operação e disponibilidade.
- **5** — Relaciona nuvem à arquitetura distribuída, governança, automação, resiliência e otimização financeira.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre escalabilidade vertical e horizontal?
2. Que cuidados teria ao executar a aplicação em várias instâncias?
3. Quais custos poderiam crescer inesperadamente em um ambiente de nuvem?

---

## Pergunta 62 — IaaS, PaaS, contêineres e serviços gerenciados

**Nível:** Pleno  
**Categoria:** Computação em nuvem

**Pergunta do entrevistador:**  
Como você diferenciaria IaaS, PaaS, contêineres e serviços gerenciados ao escolher uma solução para executar um microsserviço Java?

**O que essa pergunta avalia:**  
Avalia a capacidade de escolher o nível adequado de abstração operacional para uma aplicação.

**Resposta esperada:**  
**IaaS**, ou Infrastructure as a Service, oferece recursos básicos, como máquinas virtuais, discos e redes. A equipe continua responsável por grande parte do sistema operacional e da infraestrutura.

**PaaS**, ou Platform as a Service, fornece uma plataforma mais abstraída para executar aplicações. O provedor gerencia parte relevante da infraestrutura, enquanto a equipe concentra-se mais na aplicação.

**Contêineres** empacotam a aplicação com suas dependências e facilitam a padronização entre ambientes. Eles podem ser executados diretamente em máquinas virtuais ou em plataformas de orquestração.

**Serviços gerenciados** são componentes operacionais oferecidos pelo provedor, como bancos de dados, brokers, filas, caches e plataformas de observabilidade.

A escolha deve considerar:

- Controle necessário;
- Complexidade operacional;
- Requisitos de segurança;
- Portabilidade;
- Custo;
- Capacidade da equipe;
- Necessidade de customização;
- Requisitos de disponibilidade e escala.

**Explicação didática:**  
Uma máquina virtual oferece maior controle, mas exige mais responsabilidades, como atualização do sistema operacional, configuração de rede e manutenção da infraestrutura.

Um serviço gerenciado reduz esse trabalho, mas pode limitar configurações e aumentar a dependência do provedor.

Contêineres ajudam a empacotar e transportar aplicações, mas não resolvem sozinhos problemas de escalabilidade, observabilidade ou alta disponibilidade.

**Exemplo de decisão:**

~~~text
Microsserviço Java com necessidade de:
- Escala automática;
- Deploy frequente;
- Baixa administração de servidores;
- Integração com monitoramento;
- Execução em múltiplas zonas.

Alternativas:
- Plataforma gerenciada de contêineres;
- Serviço de execução serverless;
- PaaS para aplicações Java.
~~~

A escolha final deve considerar o perfil da equipe e os requisitos operacionais.

**Como o candidato deve responder:**

- Diferencie os níveis de abstração;
- Explique responsabilidades da equipe e do provedor;
- Considere portabilidade e lock-in;
- Relacione a escolha ao perfil da aplicação;
- Mencione segurança, custos e operação;
- Evite afirmar que contêineres são sempre a melhor opção.

**Resposta fraca ou incompleta:**  
“PaaS é melhor que IaaS em qualquer situação porque é mais simples.”

A simplicidade pode ser vantajosa, mas alguns sistemas exigem maior controle, customização ou portabilidade.

**Critérios de avaliação:**

- **0** — Não diferencia os modelos.
- **1** — Confunde contêiner, máquina virtual e PaaS.
- **2** — Conhece os termos, mas não explica responsabilidades.
- **3** — Compara as alternativas de forma básica.
- **4** — Considera controle, operação, custo e portabilidade.
- **5** — Escolhe o nível adequado com base em requisitos, riscos, maturidade da equipe e estratégia de longo prazo.

**Perguntas de aprofundamento:**

1. Quando uma máquina virtual poderia ser preferível a contêineres?
2. Quais responsabilidades permanecem mesmo usando um serviço gerenciado?
3. Como avaliaria o risco de dependência de um provedor?

---

## Pergunta 63 — Docker e construção de imagens

**Nível:** Júnior  
**Categoria:** Contêineres e implantação

**Pergunta do entrevistador:**  
Quais cuidados você teria ao criar uma imagem Docker para uma aplicação Java?

**O que essa pergunta avalia:**  
Avalia conhecimentos básicos sobre empacotamento, segurança e eficiência de imagens de contêiner.

**Resposta esperada:**  
Eu consideraria:

- Utilizar uma imagem base confiável e atualizada;
- Preferir imagens menores quando isso não comprometer a segurança;
- Executar a aplicação com usuário não privilegiado;
- Não incluir segredos na imagem;
- Definir corretamente o processo principal;
- Configurar limites e variáveis externamente;
- Aproveitar o cache das camadas;
- Remover arquivos temporários e dependências desnecessárias;
- Fixar versões de forma controlada;
- Gerar logs para saída padrão;
- Garantir que a aplicação receba sinais de encerramento corretamente.

A imagem deve conter a aplicação e suas dependências necessárias, mas não credenciais específicas de um ambiente.

**Explicação didática:**  
Uma imagem construída com usuário root aumenta o impacto de uma eventual exploração da aplicação.

Também é inadequado copiar um arquivo de configuração contendo senha para dentro da imagem, pois a credencial pode permanecer em camadas ou ser acessada por quem possui a imagem.

Outro cuidado é configurar a JVM de acordo com os limites de memória do contêiner. A aplicação não deve assumir que possui toda a memória da máquina hospedeira.

**Exemplo de configuração conceitual:**

~~~dockerfile
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/pedido-service.jar app.jar

USER 10001

ENTRYPOINT ["java", "-jar", "app.jar"]
~~~

A imagem utiliza um runtime, executa com usuário não privilegiado e recebe configurações por meios externos.

**Como o candidato deve responder:**

- Mencione imagem base atualizada;
- Fale sobre usuário não privilegiado;
- Explique que segredos não devem ficar na imagem;
- Considere tamanho e camadas;
- Relacione a JVM aos limites do contêiner;
- Evite executar tudo como root.

**Resposta fraca ou incompleta:**  
“Eu colocaria o código e todas as configurações dentro da imagem para facilitar a execução.”

Isso pode expor segredos, dificultar mudanças de configuração e aumentar o tamanho da imagem.

**Critérios de avaliação:**

- **0** — Não conhece os cuidados básicos.
- **1** — Inclui segredos ou executa como root sem preocupação.
- **2** — Conhece Docker superficialmente.
- **3** — Cria uma imagem funcional e configurável.
- **4** — Considera segurança, tamanho, usuário e configuração externa.
- **5** — Discute cadeia de fornecimento, scan de vulnerabilidades, reprodutibilidade, sinais de encerramento e ajuste da JVM.

**Perguntas de aprofundamento:**

1. Por que não deveria colocar credenciais na imagem?
2. Qual é a vantagem de utilizar uma imagem com apenas o runtime?
3. Como investigaria uma aplicação Java que está sendo finalizada por falta de memória no contêiner?

---

## Pergunta 64 — Orquestração e Kubernetes

**Nível:** Pleno  
**Categoria:** Kubernetes e operação

**Pergunta do entrevistador:**  
Qual é o papel de uma plataforma de orquestração, como Kubernetes, na execução de microsserviços?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre implantação, descoberta, escalabilidade e recuperação de aplicações conteinerizadas.

**Resposta esperada:**  
Uma plataforma de orquestração automatiza atividades como:

- Agendamento de contêineres;
- Recuperação de instâncias com falha;
- Descoberta de serviços;
- Balanceamento de tráfego;
- Escalabilidade;
- Atualizações graduais;
- Configuração;
- Verificação de saúde;
- Isolamento de recursos;
- Gerenciamento de réplicas.

No Kubernetes, conceitos comuns incluem:

- Pod;
- Deployment;
- Service;
- ConfigMap;
- Secret;
- Namespace;
- Readiness probe;
- Liveness probe;
- HPA.

A plataforma não corrige automaticamente problemas de arquitetura. Uma aplicação com estado mal gerenciado, sem timeouts ou sem observabilidade continuará apresentando problemas mesmo dentro do Kubernetes.

**Explicação didática:**  
A `readiness probe` indica se a instância está pronta para receber tráfego.

A `liveness probe` indica se o processo ainda está funcionando adequadamente e pode precisar ser reiniciado.

Se uma aplicação ainda estiver inicializando, mas for considerada pronta prematuramente, requisições poderão falhar. Se a verificação de vida for configurada de maneira agressiva, o orquestrador poderá reiniciar instâncias saudáveis durante uma lentidão temporária.

**Exemplo conceitual:**

~~~yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: pedido-service
spec:
  replicas: 3
  template:
    spec:
      containers:
        - name: pedido-service
          image: pedido-service:1.0.0
          readinessProbe:
            httpGet:
              path: /actuator/health/readiness
              port: 8080
          livenessProbe:
            httpGet:
              path: /actuator/health/liveness
              port: 8080
~~~

As verificações devem refletir corretamente a capacidade da aplicação de receber tráfego e continuar executando.

**Como o candidato deve responder:**

- Explique o objetivo da orquestração;
- Diferencie readiness e liveness;
- Mencione escalabilidade e recuperação;
- Considere configuração e segredos;
- Fale sobre limites de recursos;
- Evite afirmar que o Kubernetes substitui práticas de desenvolvimento e operação.

**Resposta fraca ou incompleta:**  
“Kubernetes serve apenas para iniciar contêineres.”

Isso ignora descoberta de serviços, escalabilidade, rollout, recuperação e verificações de saúde.

**Critérios de avaliação:**

- **0** — Não conhece orquestração.
- **1** — Confunde contêiner com plataforma de orquestração.
- **2** — Conhece Kubernetes superficialmente.
- **3** — Explica implantação e réplicas.
- **4** — Considera probes, configuração, escala e recuperação.
- **5** — Discute recursos, rollout, autoscaling, segurança, observabilidade e riscos de configurações inadequadas.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre readiness e liveness?
2. O que pode acontecer se o limite de memória estiver mal configurado?
3. Como faria uma atualização gradual de uma aplicação?

---

## Pergunta 65 — Health checks e graceful shutdown

**Nível:** Pleno  
**Categoria:** Resiliência e operação

**Pergunta do entrevistador:**  
Como você implementaria verificações de saúde e encerramento gracioso em um microsserviço Java?

**O que essa pergunta avalia:**  
Avalia a capacidade de preparar uma aplicação para operação em ambientes dinâmicos e distribuídos.

**Resposta esperada:**  
As verificações de saúde devem responder se a aplicação está viva e se está pronta para receber tráfego.

É importante diferenciar:

- Saúde do processo;
- Disponibilidade da aplicação;
- Disponibilidade de dependências;
- Capacidade de aceitar novas requisições.

Uma verificação de prontidão pode considerar condições necessárias para atendimento, como conexão com configurações essenciais. Porém, não é recomendável fazer verificações pesadas ou dependentes de muitos sistemas em cada chamada.

No encerramento gracioso, a aplicação deve:

1. Parar de receber novas requisições;
2. Permitir a conclusão de operações em andamento por um período limitado;
3. Interromper ou finalizar consumidores de mensagens de forma segura;
4. Fechar conexões e recursos;
5. Encerrar dentro do prazo definido pela plataforma.

**Explicação didática:**  
Durante uma atualização, uma instância deve ser retirada do balanceamento antes de ser encerrada. Caso contrário, novas requisições podem chegar enquanto o processo está terminando.

Em consumidores Kafka ou RabbitMQ, o encerramento também deve evitar confirmar mensagens que ainda não foram processadas.

Um desligamento gracioso não significa esperar indefinidamente. Deve existir um limite para evitar que uma instância fique presa.

**Exemplo de fluxo:**

~~~mermaid
sequenceDiagram
    participant O as Orquestrador
    participant A as Aplicação
    participant C as Cliente

    O->>A: Sinaliza encerramento
    A->>A: Fica indisponível para novas requisições
    A->>C: Conclui requisições em andamento
    A->>A: Para consumidores e libera recursos
    A-->>O: Processo encerrado
~~~

**Como o candidato deve responder:**

- Diferencie liveness e readiness;
- Explique o encerramento gracioso;
- Considere requisições e mensagens em processamento;
- Mencione timeout de desligamento;
- Fale sobre dependências críticas;
- Evite health checks que sempre retornem saudável sem verificar condições relevantes.

**Resposta fraca ou incompleta:**  
“Eu mataria o processo imediatamente porque o orquestrador reiniciará outra instância.”

Isso pode interromper operações, perder mensagens e causar erros para os consumidores.

**Critérios de avaliação:**

- **0** — Não conhece health checks.
- **1** — Encerra processos sem considerar operações em andamento.
- **2** — Conhece probes, mas ignora o ciclo de desligamento.
- **3** — Implementa verificações e encerramento básicos.
- **4** — Considera tráfego, mensagens, recursos e limites de tempo.
- **5** — Define uma estratégia completa de prontidão, dependências, shutdown, deploy e prevenção de perda de trabalho.

**Perguntas de aprofundamento:**

1. O que deve acontecer com uma mensagem que está sendo processada durante o desligamento?
2. Uma dependência externa indisponível deve sempre deixar o serviço como não pronto?
3. Como evitar que uma operação longa ultrapasse o tempo de encerramento?

---

## Pergunta 66 — Escalabilidade horizontal e stateless

**Nível:** Pleno  
**Categoria:** Arquitetura e escalabilidade

**Pergunta do entrevistador:**  
Quais características uma aplicação Java deve possuir para escalar horizontalmente com segurança?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre execução em múltiplas instâncias e remoção de dependências inadequadas do estado local.

**Resposta esperada:**  
Para escalar horizontalmente, a aplicação deve:

- Evitar estado de usuário apenas na memória local;
- Externalizar sessões quando sessões forem necessárias;
- Utilizar armazenamento compartilhado;
- Ser stateless sempre que possível;
- Possuir configuração externalizada;
- Suportar múltiplas instâncias acessando dados de forma concorrente;
- Utilizar identificadores e operações idempotentes;
- Ter balanceamento de carga;
- Possuir observabilidade por instância;
- Controlar pools e limites de recursos.

Também é necessário garantir que os serviços dependentes suportem o aumento de carga. Escalar apenas a aplicação pode sobrecarregar banco, cache, broker ou APIs externas.

**Explicação didática:**  
Se uma requisição for enviada para a instância A e a próxima para a instância B, a aplicação deve continuar funcionando corretamente.

Guardar o carrinho de compras ou o estado da autenticação apenas na memória da instância A pode causar perda de contexto quando o tráfego for direcionado à instância B.

Mesmo utilizando sessões compartilhadas, é necessário analisar concorrência, expiração, consistência e custo.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[Cliente] --> B[Balanceador]
    B --> C[Instância A]
    B --> D[Instância B]
    B --> E[Instância C]
    C --> F[Armazenamento compartilhado]
    D --> F
    E --> F
~~~

As instâncias compartilham dados persistentes quando necessário, mas não devem depender do estado local de uma única máquina.

**Como o candidato deve responder:**

- Explique stateless;
- Mencione estado compartilhado;
- Considere sessões e caches;
- Relacione escala da aplicação às dependências;
- Fale sobre idempotência;
- Evite afirmar que aumentar instâncias resolve qualquer gargalo.

**Resposta fraca ou incompleta:**  
“Basta aumentar o número de pods para escalar horizontalmente.”

Isso pode sobrecarregar recursos compartilhados e não resolve estado local, concorrência ou limites das dependências.

**Critérios de avaliação:**

- **0** — Não entende escala horizontal.
- **1** — Mantém estado apenas na memória local.
- **2** — Conhece múltiplas instâncias, mas ignora dependências.
- **3** — Explica o modelo stateless.
- **4** — Considera armazenamento compartilhado, sessões, cache e idempotência.
- **5** — Analisa gargalos sistêmicos, limites, autoscaling, backpressure e impacto operacional.

**Perguntas de aprofundamento:**

1. Como armazenaria uma sessão compartilhada entre instâncias?
2. Quais problemas podem ocorrer ao utilizar sticky sessions?
3. Como verificaria se o banco suporta a escala horizontal da aplicação?

---

## Pergunta 67 — Autoscaling

**Nível:** Sênior  
**Categoria:** Escalabilidade e operação

**Pergunta do entrevistador:**  
Como você definiria uma estratégia de autoscaling para um serviço Java que recebe picos de requisições?

**O que essa pergunta avalia:**  
Avalia a capacidade de projetar escalabilidade automática baseada em sinais relevantes e limites operacionais.

**Resposta esperada:**  
A estratégia deve começar com a definição do objetivo: manter latência, taxa de erro e disponibilidade dentro dos níveis esperados.

Possíveis sinais para escalar incluem:

- CPU;
- Memória;
- Taxa de requisições;
- Latência;
- Número de requisições em processamento;
- Tamanho de filas;
- Consumer lag;
- Tempo de espera por recursos;
- Métricas de negócio.

CPU pode ser útil, mas nem sempre representa o gargalo. Um serviço que aguarda banco ou API externa pode apresentar CPU baixa e ainda estar saturado.

Também é necessário definir:

- Mínimo e máximo de instâncias;
- Tempo de estabilização;
- Capacidade de inicialização;
- Limites do banco e das dependências;
- Estratégia de scale out e scale in;
- Proteção contra oscilações;
- Custo máximo aceitável;
- Capacidade de absorver picos durante a inicialização.

**Explicação didática:**  
Se o autoscaling aumentar rapidamente as instâncias, mas todas abrirem muitas conexões ao banco, o banco poderá ficar saturado.

Em um consumidor Kafka, aumentar instâncias acima do número de partições pode não aumentar o processamento. Em uma fila, por outro lado, o tamanho e a idade das mensagens podem ser sinais mais adequados que CPU.

**Exemplo de política conceitual:**

~~~text
Escalar para cima quando:
- p95 de latência ultrapassar o objetivo por cinco minutos; ou
- quantidade de requisições por instância exceder o limite definido.

Escalar para baixo quando:
- a carga permanecer baixa por quinze minutos;
- não houver fila de trabalho pendente;
- as dependências suportarem a redução.
~~~

Os limites devem ser validados com testes de carga e observação em produção.

**Como o candidato deve responder:**

- Comece pelos objetivos de confiabilidade;
- Escolha métricas relacionadas ao gargalo;
- Considere dependências;
- Mencione limites mínimo e máximo;
- Fale sobre estabilização e custo;
- Evite utilizar somente CPU em qualquer cenário.

**Resposta fraca ou incompleta:**  
“Eu escalaria quando a CPU passasse de 70%.”

Esse pode ser um sinal útil, mas não necessariamente representa a saturação real do serviço.

**Critérios de avaliação:**

- **0** — Não entende autoscaling.
- **1** — Escala sem limites ou sem observar dependências.
- **2** — Utiliza apenas CPU sem avaliar o fluxo.
- **3** — Define uma política básica de escala.
- **4** — Considera latência, filas, limites e estabilidade.
- **5** — Estrutura autoscaling orientado por capacidade, SLOs, gargalos, custo, inicialização e efeitos em cascata.

**Perguntas de aprofundamento:**

1. Por que escalar consumidores Kafka acima do número de partições pode não ajudar?
2. Como evitar oscilações constantes entre scale out e scale in?
3. Que testes faria antes de habilitar autoscaling em produção?

---

## Pergunta 68 — Alta disponibilidade e zonas de falha

**Nível:** Sênior  
**Categoria:** Confiabilidade e nuvem

**Pergunta do entrevistador:**  
Como você projetaria a alta disponibilidade de uma aplicação Java crítica executada na nuvem?

**O que essa pergunta avalia:**  
Avalia a capacidade de projetar redundância, recuperação e operação diante de falhas de infraestrutura.

**Resposta esperada:**  
Eu começaria identificando:

- Criticidade do serviço;
- RTO, tempo máximo aceitável para recuperação;
- RPO, perda de dados aceitável;
- Dependências críticas;
- Domínios ou zonas de falha;
- Estratégias de backup e restauração;
- Requisitos de consistência;
- Capacidade de operação degradada.

A solução poderia incluir:

- Múltiplas instâncias;
- Distribuição em diferentes zonas de disponibilidade;
- Balanceamento de tráfego;
- Banco com replicação e failover;
- Filas duráveis;
- Backups testados;
- Monitoramento;
- Automação de recuperação;
- Testes de falha;
- Runbooks;
- Estratégia de disaster recovery.

Alta disponibilidade da aplicação não será suficiente se o banco, o broker ou o provedor de identidade permanecerem em um único ponto de falha.

**Explicação didática:**  
Ter três réplicas da aplicação na mesma zona não protege contra a falha daquela zona.

Também não basta possuir backups. É necessário testar se eles podem ser restaurados dentro do RTO e se a perda de dados permanece dentro do RPO.

Uma arquitetura resiliente deve considerar tanto falhas comuns quanto falhas de maior alcance, como indisponibilidade regional, dependendo da criticidade e do custo aceitável.

**Exemplo de arquitetura:**

~~~mermaid
flowchart TD
    A[Usuários] --> B[Balanceador]
    B --> C[Zona A]
    B --> D[Zona B]
    C --> E[Aplicação]
    D --> F[Aplicação]
    E --> G[Banco replicado]
    F --> G
    E --> H[Broker durável]
    F --> H
    G --> I[Backups testados]
~~~

A distribuição reduz pontos únicos de falha, mas aumenta custos e complexidade.

**Como o candidato deve responder:**

- Explique redundância e zonas de falha;
- Defina RTO e RPO;
- Considere banco, broker e dependências;
- Mencione backups e testes de restauração;
- Fale sobre disaster recovery;
- Relacione disponibilidade a custo e criticidade.

**Resposta fraca ou incompleta:**  
“Eu colocaria muitas réplicas da aplicação.”

Réplicas ajudam, mas não resolvem pontos únicos de falha em banco, rede, broker, identidade ou infraestrutura.

**Critérios de avaliação:**

- **0** — Não apresenta estratégia de disponibilidade.
- **1** — Depende de uma única instância ou zona.
- **2** — Cita réplicas, mas ignora dados e recuperação.
- **3** — Define redundância básica.
- **4** — Considera RTO, RPO, dependências e backups.
- **5** — Projeta alta disponibilidade de ponta a ponta, incluindo testes de falha, custos, operação e recuperação regional.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre RTO e RPO?
2. Como testaria um plano de disaster recovery?
3. Qual é o risco de uma dependência externa ser um ponto único de falha?

---

## Pergunta 69 — Infrastructure as Code e ambientes reproduzíveis

**Nível:** Pleno  
**Categoria:** Automação e infraestrutura

**Pergunta do entrevistador:**  
Por que utilizar Infrastructure as Code e como isso contribui para a confiabilidade dos ambientes?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre automação, rastreabilidade e reprodutibilidade da infraestrutura.

**Resposta esperada:**  
Infrastructure as Code representa a infraestrutura em arquivos versionados e permite criá-la ou alterá-la de forma automatizada.

Benefícios:

- Reprodutibilidade;
- Padronização;
- Revisão de mudanças;
- Histórico;
- Menor dependência de operações manuais;
- Facilidade de criar ambientes;
- Detecção de divergências;
- Automação de testes;
- Recuperação mais rápida.

A infraestrutura deve ser tratada com práticas semelhantes às utilizadas no desenvolvimento:

- Revisão por pares;
- Validação;
- Separação de ambientes;
- Controle de permissões;
- Planejamento de mudanças;
- Gestão de estado;
- Proteção contra destruição acidental.

A automação não elimina riscos. Um código de infraestrutura incorreto pode reproduzir rapidamente uma configuração inadequada.

**Explicação didática:**  
Quando um ambiente é configurado manualmente, duas equipes podem criar ambientes aparentemente iguais, mas com diferenças invisíveis.

Com Infrastructure as Code, a configuração pode ser revisada e aplicada de maneira consistente. Também é possível identificar quando uma alteração foi realizada fora do processo esperado.

O código deve evitar segredos diretamente armazenados e deve definir recursos com nomes, tags, limites e políticas de acesso adequados.

**Exemplo conceitual:**

~~~text
Definição versionada:
- Rede privada;
- Sub-redes;
- Serviço Java;
- Banco de dados;
- Fila;
- Permissões da aplicação;
- Alarmes;
- Políticas de backup.
~~~

A partir dessa definição, ambientes semelhantes podem ser criados com parâmetros específicos.

**Como o candidato deve responder:**

- Explique reprodutibilidade;
- Mencione versionamento e revisão;
- Considere divergência entre ambientes;
- Fale sobre segurança e estado;
- Relacione automação à recuperação;
- Evite afirmar que Infrastructure as Code elimina a necessidade de revisão.

**Resposta fraca ou incompleta:**  
“Serve apenas para não precisar configurar servidores manualmente.”

Essa é uma vantagem, mas não aborda rastreabilidade, padronização, auditoria e reprodutibilidade.

**Critérios de avaliação:**

- **0** — Não conhece Infrastructure as Code.
- **1** — Defende alterações manuais sem controle.
- **2** — Conhece automação, mas ignora versionamento.
- **3** — Explica os benefícios básicos.
- **4** — Considera revisão, ambientes, segurança e estado.
- **5** — Estrutura uma prática madura com testes, políticas, detecção de divergência, governança e recuperação.

**Perguntas de aprofundamento:**

1. Como evitaria que segredos fossem armazenados no código de infraestrutura?
2. O que é drift de infraestrutura?
3. Como revisaria uma alteração que pode remover recursos de produção?

---

## Pergunta 70 — Estratégia de deploy sem indisponibilidade

**Nível:** Sênior  
**Categoria:** Entrega contínua e confiabilidade

**Pergunta do entrevistador:**  
Como você faria o deploy de uma nova versão de um microsserviço Java sem interromper o atendimento dos usuários?

**O que essa pergunta avalia:**  
Avalia a capacidade de planejar entregas seguras, compatibilidade entre versões e recuperação rápida.

**Resposta esperada:**  
Eu utilizaria uma estratégia de entrega gradual, como:

- Rolling update;
- Blue-green deployment;
- Canary release;
- Feature flags;
- Deploy progressivo;
- Shadow traffic, quando adequado.

Antes do deploy, verificaria:

- Compatibilidade da nova versão com a anterior;
- Compatibilidade de banco e eventos;
- Migrações graduais;
- Health checks;
- Observabilidade;
- Capacidade de rollback;
- Testes automatizados;
- Plano de comunicação;
- Critérios de interrupção.

Em uma atualização gradual, versões diferentes podem executar simultaneamente. Por isso, contratos de API, schema do banco e eventos precisam ser compatíveis durante o período de transição.

O rollback também deve ser planejado. Se uma migração de banco for irreversível, voltar apenas o código pode não ser suficiente.

**Explicação didática:**  
Uma estratégia comum é expandir e contrair o schema:

1. Adicionar a nova coluna ou campo sem remover o antigo;
2. Publicar uma versão do código que escreve nos dois formatos;
3. Migrar os consumidores;
4. Passar a ler o novo formato;
5. Remover o formato antigo somente depois da migração completa.

Esse processo reduz o risco de uma versão antiga encontrar um banco ou evento incompatível.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Versão atual em produção] --> B[Implantar nova versão em pequena parcela]
    B --> C[Verificar métricas e erros]
    C --> D{Comportamento saudável?}
    D -- Não --> E[Interromper e reverter]
    D -- Sim --> F[Aumentar gradualmente o tráfego]
    F --> G[Concluir rollout]
    G --> H[Monitorar pós-deploy]
~~~

A decisão de avançar deve ser baseada em métricas técnicas e de negócio.

**Como o candidato deve responder:**

- Explique deploy gradual;
- Mencione compatibilidade entre versões;
- Considere banco e eventos;
- Fale sobre rollback;
- Relacione a decisão a métricas e SLOs;
- Mencione feature flags quando apropriado;
- Evite depender apenas de “subir a nova versão e observar”.

**Resposta fraca ou incompleta:**  
“Eu pararia todas as instâncias, atualizaria o código e iniciaria novamente.”

Essa estratégia causa indisponibilidade e aumenta o risco de uma falha durante a implantação.

**Critérios de avaliação:**

- **0** — Não conhece estratégias de deploy seguro.
- **1** — Propõe parada total sem plano de recuperação.
- **2** — Conhece rolling update, mas ignora compatibilidade.
- **3** — Define uma estratégia gradual básica.
- **4** — Considera métricas, rollback, banco e contratos.
- **5** — Estrutura entrega progressiva com migração compatível, feature flags, critérios de decisão, observabilidade e recuperação testada.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre blue-green e canary deployment?
2. Como faria uma migração de banco compatível com duas versões da aplicação?
3. Em que situação um rollback de código não seria suficiente?
4. Como decidiria se o rollout deve continuar?
5. Como reduziria o risco de uma alteração incompatível em um evento Kafka?

---

## Resumo desta parte

- **Perguntas apresentadas:** 61 a 70
- **Perguntas restantes:** 71 a 100
- **Níveis abordados:** Júnior, Pleno e Sênior
- **Categorias:** computação em nuvem, contêineres, Kubernetes, escalabilidade, alta disponibilidade, Infrastructure as Code e entrega contínua
- **Competências avaliadas:** fundamentos de nuvem, escolha de modelos de execução, construção segura de imagens, orquestração, health checks, graceful shutdown, escalabilidade horizontal, autoscaling, alta disponibilidade, automação de infraestrutura e estratégias de deploy seguro

A próxima parte continuará com as perguntas **71 a 80**, abordando arquitetura de software, padrões de projeto, princípios SOLID, DDD, modularidade e qualidade de código.

---

`markdown
# Roteiro de Entrevista Técnica — Java e Engenharia de Software

> **Parte 8 de 10 — Perguntas 71 a 80 de 100**

**Objetivo:** preparação para uma posição de Desenvolvedor(a) Java Sênior/Especialista, com foco em microsserviços, mensageria, bancos de dados, observabilidade, nuvem, boas práticas, arquitetura e didática técnica.

**Níveis abordados nesta parte:** Júnior, Pleno e Sênior  
**Estilo:** perguntas conceituais, práticas e baseadas em cenários reais

---

## Pergunta 71 — Princípios SOLID

**Nível:** Júnior  
**Categoria:** Orientação a objetos e qualidade de código

**Pergunta do entrevistador:**  
O que são os princípios SOLID e como eles ajudam na construção de aplicações Java?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre princípios de design orientado a objetos e a capacidade de produzir código mais coeso, flexível e testável.

**Resposta esperada:**  
SOLID é um conjunto de cinco princípios:

- **S — Single Responsibility Principle:** uma classe deve ter uma única responsabilidade ou um único motivo para mudar;
- **O — Open/Closed Principle:** entidades devem estar abertas para extensão e fechadas para modificação;
- **L — Liskov Substitution Principle:** subclasses devem poder substituir suas classes-base sem quebrar o comportamento esperado;
- **I — Interface Segregation Principle:** clientes não devem ser obrigados a depender de métodos que não utilizam;
- **D — Dependency Inversion Principle:** módulos de alto nível devem depender de abstrações, não de implementações concretas.

Esses princípios ajudam a reduzir acoplamento, melhorar testabilidade e facilitar a evolução do código.

Eles não devem ser aplicados de forma mecânica. Uma abstração desnecessária também pode aumentar a complexidade.

**Explicação didática:**  
Uma classe que valida pedidos, calcula frete, grava no banco, envia e-mail e gera relatório possui responsabilidades demais.

Alterar uma dessas funções pode afetar as outras. Separar as responsabilidades torna o sistema mais fácil de entender e testar.

O princípio da inversão de dependência também permite substituir uma implementação real por uma implementação de teste ou por uma nova integração.

**Exemplo prático:**

~~~java
public interface Notificador {
    void enviar(String destinatario, String mensagem);
}

public class PedidoService {

    private final Notificador notificador;

    public PedidoService(Notificador notificador) {
        this.notificador = notificador;
    }

    public void confirmarPedido(Pedido pedido) {
        // Regras de negócio do pedido.
        notificador.enviar(
            pedido.getEmailCliente(),
            "Pedido confirmado"
        );
    }
}
~~~

O serviço depende da abstração `Notificador`, e não diretamente de uma implementação específica de e-mail.

**Como o candidato deve responder:**

- Cite os cinco princípios;
- Explique-os com exemplos simples;
- Relacione SOLID a coesão, acoplamento e testabilidade;
- Mostre que princípios são diretrizes, não regras absolutas;
- Evite apenas decorar as siglas sem explicar os impactos.

**Resposta fraca ou incompleta:**  
“SOLID é um padrão de arquitetura utilizado em qualquer projeto Java.”

SOLID é um conjunto de princípios de design, não uma arquitetura pronta nem uma obrigação de criar abstrações para todas as classes.

**Critérios de avaliação:**

- **0** — Não conhece SOLID.
- **1** — Apenas repete a sigla sem significado.
- **2** — Conhece alguns princípios, mas não sabe aplicá-los.
- **3** — Explica os cinco princípios de forma básica.
- **4** — Relaciona os princípios a acoplamento, coesão e testes.
- **5** — Aplica os princípios com equilíbrio, reconhecendo trade-offs e evitando abstrações desnecessárias.

**Perguntas de aprofundamento:**

1. Como identificaria que uma classe possui responsabilidades demais?
2. Por que abstrações excessivas também podem ser prejudiciais?
3. Como o princípio da inversão de dependência facilita os testes?

---

## Pergunta 72 — Coesão e acoplamento

**Nível:** Júnior  
**Categoria:** Design de software

**Pergunta do entrevistador:**  
Qual é a diferença entre coesão e acoplamento, e por que esses conceitos são importantes em uma aplicação Java?

**O que essa pergunta avalia:**  
Avalia a compreensão de características fundamentais de um bom design de software.

**Resposta esperada:**  
**Coesão** representa o quanto as responsabilidades de um módulo estão relacionadas entre si. Um módulo coeso concentra atividades que fazem sentido juntas.

**Acoplamento** representa o quanto um módulo depende de outros módulos. Um sistema com alto acoplamento torna mudanças mais arriscadas, porque uma alteração pode afetar diversas partes.

Em geral, busca-se:

- Alta coesão;
- Baixo acoplamento;
- Dependências explícitas;
- Interfaces pequenas;
- Responsabilidades bem delimitadas;
- Comunicação entre módulos por contratos claros.

A coesão não significa que cada classe deve possuir apenas um método. Significa que os comportamentos da classe devem pertencer ao mesmo contexto de responsabilidade.

**Explicação didática:**  
Uma classe `PedidoService` que contém somente regras relacionadas a pedidos tende a ser mais coesa do que uma classe que também envia e-mails, processa pagamentos e gera arquivos.

Uma classe que conhece diretamente muitos detalhes de banco, mensageria e APIs externas possui alto acoplamento. Uma mudança em qualquer dependência pode exigir alterações em vários pontos.

**Exemplo prático:**

~~~java
public class CalculadoraFrete {

    public BigDecimal calcular(Endereco origem,
                               Endereco destino,
                               BigDecimal peso) {
        // Regra relacionada exclusivamente ao cálculo de frete.
        return BigDecimal.ZERO;
    }
}
~~~

A classe possui uma responsabilidade relacionada e pode ser testada sem depender de banco ou de serviços externos.

**Como o candidato deve responder:**

- Defina coesão e acoplamento;
- Explique a relação com manutenção;
- Dê um exemplo de módulo coeso;
- Mostre como reduzir dependências desnecessárias;
- Evite tratar baixo acoplamento como ausência total de dependências.

**Resposta fraca ou incompleta:**  
“Coesão é quando as classes estão conectadas e acoplamento é quando estão separadas.”

Essa explicação não distingue claramente a unidade interna de responsabilidade das dependências entre módulos.

**Critérios de avaliação:**

- **0** — Não conhece os conceitos.
- **1** — Confunde coesão e acoplamento.
- **2** — Conhece os termos, mas não explica seus efeitos.
- **3** — Define corretamente os dois conceitos.
- **4** — Relaciona-os à manutenção, testes e evolução.
- **5** — Analisa limites de contexto, dependências, contratos e trade-offs de design.

**Perguntas de aprofundamento:**

1. Uma classe pequena é necessariamente coesa?
2. Como identificaria alto acoplamento em um projeto?
3. Qual é a relação entre coesão e o princípio da responsabilidade única?

---

## Pergunta 73 — Padrões de projeto

**Nível:** Pleno  
**Categoria:** Padrões de projeto

**Pergunta do entrevistador:**  
Quais padrões de projeto você já utilizou em Java e como decidiria se a aplicação de um padrão é realmente necessária?

**O que essa pergunta avalia:**  
Avalia o conhecimento prático sobre padrões de projeto e a capacidade de utilizá-los para resolver problemas reais sem criar complexidade artificial.

**Resposta esperada:**  
Padrões de projeto são soluções recorrentes para problemas de design conhecidos. Alguns exemplos são:

- **Strategy:** encapsula algoritmos ou comportamentos intercambiáveis;
- **Factory:** centraliza a criação de objetos;
- **Adapter:** adapta uma interface para outra esperada pelo cliente;
- **Decorator:** adiciona comportamento sem alterar diretamente a classe original;
- **Observer:** permite notificar interessados sobre mudanças;
- **Template Method:** define um fluxo comum com etapas variáveis;
- **Builder:** facilita a criação de objetos complexos;
- **Facade:** oferece uma interface simplificada para um subsistema.

A escolha deve considerar:

- Problema que precisa ser resolvido;
- Complexidade introduzida;
- Frequência de variação;
- Testabilidade;
- Legibilidade;
- Necessidade de extensão;
- Conhecimento da equipe;
- Custo de manutenção.

Um padrão não deve ser utilizado apenas para demonstrar conhecimento técnico.

**Explicação didática:**  
Se um sistema precisa calcular frete de acordo com diferentes transportadoras, o padrão Strategy pode separar cada algoritmo.

Se existe apenas uma regra simples e sem previsão de variação, criar várias interfaces e fábricas pode ser exagero.

O padrão deve tornar o código mais claro ou mais flexível em relação a uma necessidade concreta.

**Exemplo prático:**

~~~java
public interface CalculadoraFrete {
    BigDecimal calcular(Pedido pedido);
}

public class FreteExpresso implements CalculadoraFrete {

    @Override
    public BigDecimal calcular(Pedido pedido) {
        return BigDecimal.valueOf(30);
    }
}

public class FreteEconomico implements CalculadoraFrete {

    @Override
    public BigDecimal calcular(Pedido pedido) {
        return BigDecimal.valueOf(15);
    }
}
~~~

As estratégias podem ser selecionadas de acordo com a modalidade escolhida pelo cliente.

**Como o candidato deve responder:**

- Cite padrões que conhece;
- Explique o problema resolvido por cada um;
- Dê exemplos de uso em Java;
- Discuta legibilidade e complexidade;
- Mostre que padrões devem responder a necessidades reais;
- Evite usar nomes de padrões sem explicar sua finalidade.

**Resposta fraca ou incompleta:**  
“Eu aplicaria Singleton, Factory e Observer em todas as classes para organizar o sistema.”

O uso indiscriminado de padrões pode gerar acoplamento, estado global e complexidade desnecessária.

**Critérios de avaliação:**

- **0** — Não conhece padrões de projeto.
- **1** — Apenas lista nomes sem explicação.
- **2** — Conhece padrões, mas os aplica mecanicamente.
- **3** — Explica padrões comuns e seus objetivos.
- **4** — Escolhe padrões de acordo com problemas reais.
- **5** — Avalia benefícios, custos, alternativas simples e impacto na manutenção.

**Perguntas de aprofundamento:**

1. Quando o padrão Strategy seria melhor que vários `if`?
2. Quais problemas podem surgir com Singleton?
3. Como evitar que uma Factory se torne uma classe excessivamente complexa?

---

## Pergunta 74 — Injeção de dependência

**Nível:** Pleno  
**Categoria:** Spring e design de software

**Pergunta do entrevistador:**  
O que é injeção de dependência e por que você prefere a injeção pelo construtor em aplicações Spring?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre inversão de controle, dependências explícitas e testabilidade.

**Resposta esperada:**  
Injeção de dependência é uma técnica na qual um objeto recebe suas dependências de uma fonte externa, em vez de criá-las diretamente.

No Spring, o container gerencia a criação e a composição dos objetos.

A injeção pelo construtor é geralmente preferida porque:

- Torna as dependências obrigatórias explícitas;
- Permite criar objetos sempre em um estado válido;
- Facilita testes unitários;
- Permite declarar campos como `final`;
- Evita dependências ocultas;
- Reduz a possibilidade de `NullPointerException`;
- Ajuda a identificar classes com responsabilidades demais.

A injeção por campo pode parecer mais simples, mas dificulta a criação manual da classe e esconde suas dependências.

**Explicação didática:**  
Compare uma classe que cria diretamente seu repositório com uma classe que recebe o repositório:

~~~java
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }
}
~~~

No teste, pode-se fornecer uma implementação falsa ou um mock sem iniciar todo o contexto da aplicação.

A injeção de dependência não significa que toda classe deve depender de uma interface. A abstração deve fazer sentido para o problema.

**Como o candidato deve responder:**

- Defina injeção de dependência;
- Relacione ao princípio da inversão de dependência;
- Explique as vantagens do construtor;
- Mencione testabilidade e dependências explícitas;
- Evite afirmar que o Spring é obrigatório para utilizar a técnica.

**Resposta fraca ou incompleta:**  
“Injeção de dependência é quando o Spring cria todas as classes automaticamente.”

Essa resposta descreve apenas parte do funcionamento do framework e não explica o benefício de inverter a criação das dependências.

**Critérios de avaliação:**

- **0** — Não entende o conceito.
- **1** — Confunde injeção com instanciação direta.
- **2** — Conhece o recurso do Spring, mas ignora seus benefícios.
- **3** — Explica a injeção de dependência corretamente.
- **4** — Justifica a injeção pelo construtor.
- **5** — Relaciona o conceito a composição, testabilidade, ciclo de vida, escopo e limites de abstração.

**Perguntas de aprofundamento:**

1. Por que dependências obrigatórias devem estar no construtor?
2. Quando uma dependência opcional poderia ser representada de outra forma?
3. Como a injeção de dependência ajuda no teste unitário?

---

## Pergunta 75 — Arquitetura em camadas e arquitetura hexagonal

**Nível:** Pleno  
**Categoria:** Arquitetura de software

**Pergunta do entrevistador:**  
Quais são as diferenças entre uma arquitetura tradicional em camadas e uma arquitetura hexagonal?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre organização de responsabilidades e isolamento das regras de negócio.

**Resposta esperada:**  
Uma arquitetura em camadas normalmente organiza o sistema em componentes como:

- Controller;
- Service;
- Repository;
- Banco de dados.

Esse modelo é simples e funciona bem em muitos sistemas, mas pode permitir que regras de negócio dependam diretamente de frameworks ou detalhes de infraestrutura.

A arquitetura hexagonal, também chamada de Ports and Adapters, coloca o domínio e os casos de uso no centro. As integrações externas são acessadas por portas, e suas implementações são fornecidas por adaptadores.

Exemplos:

- Porta de entrada: caso de uso chamado por um controller;
- Porta de saída: interface para persistir um pedido;
- Adaptador de saída: implementação usando JPA;
- Adaptador de entrada: controller REST ou consumidor de mensagens.

O objetivo é proteger as regras de negócio contra detalhes externos e facilitar substituições e testes.

**Explicação didática:**  
Em uma arquitetura hexagonal, o caso de uso não precisa conhecer diretamente Spring MVC, JPA ou Kafka.

Ele depende de interfaces que representam necessidades do negócio. A infraestrutura implementa essas interfaces.

Isso não significa que o domínio nunca possa utilizar bibliotecas. O grau de isolamento deve ser proporcional ao valor e à complexidade do sistema.

**Exemplo prático:**

~~~java
public interface PedidoRepository {
    void salvar(Pedido pedido);
}

public class CriarPedidoUseCase {

    private final PedidoRepository repository;

    public CriarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    public void executar(Pedido pedido) {
        pedido.validar();
        repository.salvar(pedido);
    }
}

public class PedidoRepositoryJpaAdapter implements PedidoRepository {

    @Override
    public void salvar(Pedido pedido) {
        // Conversão e persistência usando JPA.
    }
}
~~~

O caso de uso conhece a porta `PedidoRepository`, mas não precisa conhecer o adaptador JPA.

**Como o candidato deve responder:**

- Explique camadas e responsabilidades;
- Defina portas e adaptadores;
- Mostre como o domínio fica isolado;
- Considere custo e complexidade;
- Evite afirmar que arquitetura hexagonal é obrigatória em qualquer aplicação.

**Resposta fraca ou incompleta:**  
“Arquitetura hexagonal significa usar seis camadas.”

O nome não representa seis camadas fixas, mas a ideia de múltiplas entradas e saídas conectadas ao núcleo por portas e adaptadores.

**Critérios de avaliação:**

- **0** — Não diferencia os modelos.
- **1** — Interpreta hexagonal literalmente como seis camadas.
- **2** — Conhece a separação, mas não explica dependências.
- **3** — Explica o conceito básico de Ports and Adapters.
- **4** — Relaciona a testabilidade, isolamento e substituição de infraestrutura.
- **5** — Avalia adequadamente fronteiras, custo de abstração, organização de módulos e evolução arquitetural.

**Perguntas de aprofundamento:**

1. Qual é o benefício de manter o caso de uso independente do controller?
2. Como testaria um caso de uso sem banco de dados?
3. Em que situação a arquitetura hexagonal poderia ser complexidade excessiva?

---

## Pergunta 76 — Domain-Driven Design

**Nível:** Sênior  
**Categoria:** DDD e modelagem de domínio

**Pergunta do entrevistador:**  
Como você aplicaria conceitos de Domain-Driven Design em um sistema de negócio complexo?

**O que essa pergunta avalia:**  
Avalia a capacidade de modelar software a partir do domínio e alinhar linguagem, regras e limites organizacionais.

**Resposta esperada:**  
Domain-Driven Design utiliza o conhecimento do domínio como base para decisões de modelagem e arquitetura.

Conceitos importantes incluem:

- Linguagem ubíqua;
- Entidades;
- Objetos-valor;
- Agregados;
- Serviços de domínio;
- Eventos de domínio;
- Repositórios;
- Contextos delimitados;
- Subdomínios;
- Integração entre contextos.

O trabalho deve envolver pessoas técnicas e especialistas do negócio. O objetivo não é transformar toda aplicação em um modelo complexo, mas representar corretamente as regras importantes.

Um contexto delimitado define um limite no qual termos e regras possuem significado consistente. A mesma palavra pode ter significados diferentes em contextos distintos.

**Explicação didática:**  
O conceito de “cliente” pode significar:

- Pessoa que compra no contexto de vendas;
- Titular de uma conta no contexto financeiro;
- Destinatário de uma entrega no contexto logístico.

Forçar uma única classe `Cliente` para todos esses contextos pode gerar um modelo enorme e cheio de dependências.

DDD ajuda a decidir quais conceitos pertencem a cada contexto e como eles se comunicam.

**Exemplo de modelagem:**

~~~text
Contexto de vendas:
- Pedido
- ItemPedido
- Cliente comprador

Contexto de pagamentos:
- Transação
- Meio de pagamento
- Autorização

Contexto de logística:
- Remessa
- Endereço de entrega
- Transportadora
~~~

Os contextos podem trocar eventos ou contratos específicos, sem compartilhar internamente todos os detalhes de seus modelos.

**Como o candidato deve responder:**

- Explique linguagem ubíqua;
- Diferencie entidades e objetos-valor;
- Mencione agregados e contextos delimitados;
- Relacione DDD à colaboração com o negócio;
- Mostre que o modelo deve refletir regras reais;
- Evite reduzir DDD a simplesmente utilizar microsserviços.

**Resposta fraca ou incompleta:**  
“DDD é criar uma classe para cada tabela do banco.”

Essa abordagem não considera comportamento, linguagem do negócio, limites de contexto ou regras de domínio.

**Critérios de avaliação:**

- **0** — Não conhece DDD.
- **1** — Confunde DDD com modelagem de tabelas.
- **2** — Cita entidades, mas ignora contexto e comportamento.
- **3** — Explica os conceitos centrais.
- **4** — Relaciona DDD à linguagem, regras e limites.
- **5** — Aplica DDD com pragmatismo, considerando subdomínios, integração, consistência e evolução organizacional.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre entidade e objeto-valor?
2. Como identificaria um contexto delimitado?
3. Um contexto delimitado precisa ser um microsserviço?
4. Como decidiria o tamanho de um agregado?
5. Quando DDD estratégico seria mais importante que DDD tático?

---

## Pergunta 77 — Agregados e invariantes

**Nível:** Sênior  
**Categoria:** DDD e consistência de domínio

**Pergunta do entrevistador:**  
O que é um agregado em DDD e como você decidiria quais objetos devem pertencer ao mesmo agregado?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre limites de consistência e proteção de regras de negócio.

**Resposta esperada:**  
Um agregado é um conjunto de objetos do domínio tratado como uma unidade para alterações e consistência. Ele possui uma raiz, chamada aggregate root, que controla o acesso aos demais objetos internos.

A decisão deve considerar:

- Quais invariantes precisam ser garantidas juntas;
- Quais objetos mudam em conjunto;
- Frequência e forma de acesso;
- Tamanho do agregado;
- Concorrência;
- Limites transacionais;
- Necessidade de consistência imediata.

Agregados muito grandes podem causar contenção, transações longas e dificuldade de escala. Agregados muito pequenos podem dificultar a garantia de regras que deveriam ser verificadas conjuntamente.

Objetos externos normalmente devem referenciar a raiz do agregado, e não acessar diretamente entidades internas.

**Explicação didática:**  
Em um pedido, uma regra pode determinar que a quantidade de um item não pode ser negativa. A raiz `Pedido` pode ser responsável por adicionar, remover ou alterar itens, protegendo essa regra.

Não seria adequado permitir que qualquer parte do sistema alterasse diretamente a lista interna de itens sem passar pelas regras do pedido.

**Exemplo prático:**

~~~java
public class Pedido {

    private final List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(ProdutoId produtoId,
                              int quantidade,
                              BigDecimal valor) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                "A quantidade deve ser positiva"
            );
        }

        itens.add(new ItemPedido(produtoId, quantidade, valor));
    }

    public List<ItemPedido> itens() {
        return List.copyOf(itens);
    }
}
~~~

A raiz controla as alterações e não expõe diretamente uma coleção mutável.

**Como o candidato deve responder:**

- Defina agregado e aggregate root;
- Relacione o conceito a invariantes;
- Explique o impacto sobre transações;
- Considere concorrência e tamanho;
- Mostre que nem todos os objetos precisam estar no mesmo agregado;
- Evite criar agregados apenas com base nas tabelas do banco.

**Resposta fraca ou incompleta:**  
“Um agregado é qualquer conjunto de tabelas relacionadas.”

Essa definição ignora comportamento, invariantes e limites de consistência do domínio.

**Critérios de avaliação:**

- **0** — Não conhece agregados.
- **1** — Confunde agregado com tabela ou pacote.
- **2** — Entende a raiz, mas ignora invariantes.
- **3** — Explica o conceito corretamente.
- **4** — Considera consistência, concorrência e tamanho.
- **5** — Define limites de agregados com base em regras, transações, desempenho e integração distribuída.

**Perguntas de aprofundamento:**

1. Por que agregados grandes podem prejudicar a concorrência?
2. Como alteraria uma entidade interna de um agregado?
3. Quando uma regra deveria ser eventual em vez de fazer parte do mesmo agregado?

---

## Pergunta 78 — Modularidade e limites de contexto

**Nível:** Sênior  
**Categoria:** Arquitetura modular

**Pergunta do entrevistador:**  
Como você organizaria um sistema Java modular para evitar que todos os componentes dependessem uns dos outros?

**O que essa pergunta avalia:**  
Avalia a capacidade de definir fronteiras arquiteturais e controlar dependências entre módulos.

**Resposta esperada:**  
Eu começaria identificando capacidades de negócio e responsabilidades distintas. Depois, definiria módulos com:

- Responsabilidade clara;
- APIs públicas pequenas;
- Dependências direcionadas;
- Regras de acesso;
- Modelos internos encapsulados;
- Contratos explícitos;
- Testes de arquitetura;
- Baixa dependência de detalhes internos de outros módulos.

Os módulos podem ser organizados por domínio ou capacidade, em vez de somente por tipo técnico.

Uma organização exclusivamente baseada em pastas como `controller`, `service` e `repository` pode dificultar a compreensão dos limites de negócio quando o sistema cresce.

Também é importante evitar que módulos compartilhem entidades internas ou acessem diretamente o banco uns dos outros.

**Explicação didática:**  
Uma estrutura por funcionalidade pode ser mais clara:

~~~text
pedido/
  api/
  application/
  domain/
  infrastructure/

pagamento/
  api/
  application/
  domain/
  infrastructure/
~~~

Nesse modelo, os detalhes de pedidos ficam próximos uns dos outros, e o módulo de pagamento não precisa conhecer as classes internas de pedidos.

A modularidade pode existir dentro de um monólito. Não é necessário criar microsserviços para obter limites melhores.

**Exemplo conceitual:**

~~~mermaid
flowchart LR
    A[Pedidos] --> B[Contrato de pagamento]
    B --> C[Pagamentos]
    A --> D[Contrato de estoque]
    D --> E[Estoque]

    C -. Não acessa detalhes internos .-> A
    E -. Não acessa detalhes internos .-> A
~~~

A comunicação ocorre por contratos, e não pelo compartilhamento indiscriminado de classes internas.

**Como o candidato deve responder:**

- Comece pelas capacidades do negócio;
- Explique limites e APIs públicas;
- Considere modularidade em monólitos;
- Mencione dependências direcionadas;
- Evite compartilhar entidades internas;
- Relacione arquitetura modular a evolução e testes.

**Resposta fraca ou incompleta:**  
“Eu separaria tudo em microsserviços para que os módulos não dependessem uns dos outros.”

A separação física não elimina dependências e pode aumentar a complexidade de rede, operação e consistência.

**Critérios de avaliação:**

- **0** — Não entende modularidade.
- **1** — Compartilha todos os objetos entre componentes.
- **2** — Cria módulos por tipo técnico, mas não define fronteiras.
- **3** — Organiza módulos com responsabilidades distintas.
- **4** — Controla dependências e encapsula detalhes internos.
- **5** — Define limites orientados ao domínio, contratos, regras de dependência, testes arquiteturais e evolução gradual.

**Perguntas de aprofundamento:**

1. Um monólito pode ser modular?
2. Qual é o risco de compartilhar entidades entre módulos?
3. Como detectaria dependências indevidas entre módulos?
4. Quando um módulo deveria se tornar um microsserviço?
5. Como evitaria ciclos de dependência?

---

## Pergunta 79 — Refatoração de código legado

**Nível:** Pleno  
**Categoria:** Manutenção e evolução de sistemas

**Pergunta do entrevistador:**  
Como você refatoraria uma parte crítica de um sistema legado sem aumentar o risco de indisponibilidade ou regressão?

**O que essa pergunta avalia:**  
Avalia a capacidade de evoluir sistemas existentes com segurança e abordagem incremental.

**Resposta esperada:**  
Eu começaria entendendo o comportamento atual antes de alterar a implementação.

As etapas poderiam incluir:

1. Identificar o fluxo e seus consumidores;
2. Levantar dependências e riscos;
3. Criar testes de caracterização;
4. Medir comportamento atual;
5. Definir uma mudança pequena;
6. Refatorar mantendo o contrato externo;
7. Executar testes automatizados;
8. Comparar métricas e resultados;
9. Fazer rollout gradual;
10. Remover a implementação antiga somente após validação.

Quando os testes são insuficientes, pode ser necessário criar testes de integração, testes de contrato ou testes de caracterização que registrem o comportamento existente, inclusive suas particularidades.

A refatoração deve ser separada de grandes mudanças funcionais sempre que possível.

**Explicação didática:**  
Um código legado pode possuir comportamentos não documentados, mas utilizados por outros sistemas.

Alterar a implementação sem conhecer esses comportamentos pode quebrar clientes mesmo que o novo código pareça mais correto.

Uma abordagem segura é criar uma nova implementação atrás de uma interface ou feature flag e comparar os resultados antes de substituir completamente a versão antiga.

**Exemplo de estratégia:**

~~~text
Implementação antiga
        |
        v
  Interface comum
     /       \
    v         v
Código      Código
legado      novo

Inicialmente, o código legado continua sendo a fonte oficial.
O código novo é executado de forma controlada para comparação.
~~~

A estratégia precisa considerar efeitos colaterais. Não se deve executar duas vezes uma cobrança ou uma atualização irreversível apenas para comparar resultados.

**Como o candidato deve responder:**

- Preserve o comportamento antes de mudar a implementação;
- Mencione testes de caracterização;
- Trabalhe em passos pequenos;
- Considere métricas e rollout gradual;
- Fale sobre feature flags quando apropriado;
- Evite reescrever todo o sistema sem evidências.

**Resposta fraca ou incompleta:**  
“Eu reescreveria o módulo do zero utilizando uma tecnologia mais moderna.”

Uma reescrita completa pode perder comportamentos importantes e ampliar o risco de regressão.

**Critérios de avaliação:**

- **0** — Não apresenta estratégia segura.
- **1** — Propõe substituir tudo imediatamente.
- **2** — Cria testes, mas ignora dependências e rollout.
- **3** — Refatora incrementalmente com testes básicos.
- **4** — Considera contratos, métricas, feature flags e riscos.
- **5** — Estrutura uma migração progressiva, observável, reversível e baseada em comportamento real e impacto operacional.

**Perguntas de aprofundamento:**

1. O que são testes de caracterização?
2. Como descobriria consumidores desconhecidos de uma API?
3. Como refatoraria um módulo que não possui testes?
4. Em que situação uma reescrita completa poderia ser justificável?

---

## Pergunta 80 — Decisão arquitetural e trade-offs

**Nível:** Sênior  
**Categoria:** Liderança técnica e arquitetura

**Pergunta do entrevistador:**  
Como você tomaria e comunicaria uma decisão arquitetural importante quando existissem várias alternativas tecnicamente viáveis?

**O que essa pergunta avalia:**  
Avalia a capacidade de analisar opções, explicitar trade-offs e alinhar decisões técnicas a objetivos de negócio.

**Resposta esperada:**  
Eu começaria esclarecendo:

- Qual problema precisa ser resolvido;
- Quais são os requisitos funcionais e não funcionais;
- Quais restrições existem;
- Qual é o horizonte de evolução;
- Qual é o impacto para usuários e operação;
- Quais riscos são aceitáveis;
- Qual é a capacidade da equipe.

Depois, compararia as alternativas considerando:

- Complexidade;
- Custo;
- Desempenho;
- Confiabilidade;
- Segurança;
- Escalabilidade;
- Manutenibilidade;
- Portabilidade;
- Tempo de entrega;
- Conhecimento existente;
- Risco de dependência externa.

A decisão deve ser registrada com contexto, alternativas consideradas, motivos da escolha, consequências e condições para reavaliá-la.

Uma decisão arquitetural não precisa ser perfeita. Ela precisa ser adequada ao problema e revisável quando as premissas mudarem.

**Explicação didática:**  
Escolher entre um monólito modular e microsserviços não depende apenas de preferência técnica.

É necessário avaliar:

- Necessidade de escala independente;
- Limites organizacionais;
- Maturidade operacional;
- Frequência de deploy;
- Isolamento de falhas;
- Consistência de dados;
- Capacidade de monitoramento;
- Custos de infraestrutura.

Microsserviços podem oferecer independência de implantação, mas também introduzem comunicação de rede, observabilidade distribuída, consistência eventual e maior esforço operacional.

**Exemplo de registro de decisão:**

~~~text
Decisão:
Manter o módulo de pagamentos dentro de um monólito modular inicialmente.

Contexto:
- Volume ainda moderado;
- Equipe pequena;
- Necessidade de consistência forte;
- Poucas alterações independentes;
- Operação distribuída ainda imatura.

Alternativas:
- Criar um microsserviço imediatamente;
- Manter módulo fortemente acoplado;
- Adotar monólito modular com contrato explícito.

Escolha:
Adotar o monólito modular.

Consequências:
- Menor complexidade operacional no curto prazo;
- Deploy conjunto;
- Necessidade de preservar limites internos;
- Possibilidade de extração futura se as premissas mudarem.
~~~

O registro torna a decisão compreensível para pessoas que não participaram da discussão.

**Como o candidato deve responder:**

- Comece pelo problema e pelos requisitos;
- Compare alternativas com critérios explícitos;
- Considere negócio, operação e equipe;
- Registre premissas e consequências;
- Explique que decisões podem ser revistas;
- Evite escolher tecnologias por moda ou preferência pessoal.

**Resposta fraca ou incompleta:**  
“Eu escolheria a solução mais moderna e escalável para evitar mudanças futuras.”

Uma solução mais sofisticada pode aumentar custos, riscos e complexidade sem trazer benefício proporcional.

**Critérios de avaliação:**

- **0** — Decide sem critérios claros.
- **1** — Escolhe por preferência ou moda.
- **2** — Compara tecnologias, mas ignora negócio e operação.
- **3** — Analisa alternativas básicas.
- **4** — Considera trade-offs, riscos, custos e capacidade da equipe.
- **5** — Conduz decisões estruturadas, registra premissas, comunica consequências e define condições para reavaliação.

**Perguntas de aprofundamento:**

1. Como convenceria a equipe sobre uma decisão controversa?
2. O que deve constar em um registro de decisão arquitetural?
3. Quando uma solução mais simples seria preferível?
4. Como saberia que uma decisão arquitetural precisa ser revisada?
5. Como equilibraria velocidade de entrega e qualidade técnica?

---

## Resumo desta parte

- **Perguntas apresentadas:** 71 a 80
- **Perguntas restantes:** 81 a 100
- **Níveis abordados:** Júnior, Pleno e Sênior
- **Categorias:** SOLID, coesão, acoplamento, padrões de projeto, injeção de dependência, arquitetura hexagonal, DDD, agregados, modularidade, refatoração e decisões arquiteturais
- **Competências avaliadas:** qualidade de design, orientação a objetos, organização modular, modelagem de domínio, proteção de invariantes, evolução de sistemas legados, análise de trade-offs e liderança técnica

A próxima parte continuará com as perguntas **81 a 90**, abordando testes automatizados, qualidade, integração contínua, contratos, desempenho e estratégias de validação.

---

`markdown
# Roteiro de Entrevista Técnica — Java e Engenharia de Software

> **Parte 9 de 10 — Perguntas 81 a 90 de 100**

**Objetivo:** preparação para uma posição de Desenvolvedor(a) Java Sênior/Especialista, com foco em microsserviços, mensageria, bancos de dados, observabilidade, nuvem, boas práticas, arquitetura e didática técnica.

**Níveis abordados nesta parte:** Júnior, Pleno e Sênior  
**Estilo:** perguntas conceituais, práticas e baseadas em cenários reais

---

## Pergunta 81 — Testes unitários

**Nível:** Júnior  
**Categoria:** Testes automatizados

**Pergunta do entrevistador:**  
O que caracteriza um teste unitário e como você escreveria bons testes para uma classe Java?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre testes isolados, comportamento esperado e qualidade da cobertura automatizada.

**Resposta esperada:**  
Um teste unitário verifica uma pequena unidade de comportamento, normalmente um método ou uma classe, de forma rápida e isolada de dependências externas.

Um bom teste unitário deve:

- Ter um objetivo claro;
- Ser determinístico;
- Ser rápido;
- Ser independente de outros testes;
- Verificar comportamento observável;
- Possuir dados de entrada relevantes;
- Cobrir casos de sucesso, erro e limites;
- Ser fácil de entender e manter.

Dependências externas, como banco de dados, APIs e brokers, normalmente devem ser substituídas por dublês de teste quando o objetivo é testar apenas a lógica da unidade.

A quantidade de cobertura é importante, mas não é suficiente. Um teste pode executar muitas linhas e ainda não verificar comportamentos relevantes.

**Explicação didática:**  
Uma classe que calcula descontos pode ser testada sem iniciar toda a aplicação ou acessar um banco.

O teste deve verificar regras como:

- Desconto para cliente elegível;
- Ausência de desconto para cliente não elegível;
- Valor mínimo de compra;
- Valores nulos ou inválidos;
- Limites definidos pelo negócio.

**Exemplo prático:**

~~~java
class CalculadoraDescontoTest {

    private final CalculadoraDesconto calculadora =
            new CalculadoraDesconto();

    @Test
    void deveAplicarDezPorCentoParaClienteElegivel() {
        BigDecimal valor = BigDecimal.valueOf(100);

        BigDecimal resultado =
                calculadora.calcular(valor, true);

        assertEquals(
                BigDecimal.valueOf(90),
                resultado
        );
    }
}
~~~

O teste verifica um comportamento específico e não depende de banco ou rede.

**Como o candidato deve responder:**

- Defina isolamento e determinismo;
- Explique o foco em comportamento;
- Mencione casos positivos, negativos e de limite;
- Diferencie cobertura de linhas de qualidade dos testes;
- Evite testar detalhes internos sem necessidade.

**Resposta fraca ou incompleta:**  
“Um teste unitário é aquele que executa uma classe inteira dentro do Spring.”

Isso pode transformar o teste em uma verificação de integração, mais lenta e dependente de infraestrutura.

**Critérios de avaliação:**

- **0** — Não conhece testes unitários.
- **1** — Confunde teste unitário com execução manual.
- **2** — Escreve testes básicos, mas depende de recursos externos.
- **3** — Explica isolamento e verifica comportamentos simples.
- **4** — Considera casos de erro, limites e testabilidade.
- **5** — Estrutura testes claros, determinísticos e orientados ao comportamento, avaliando também o custo e o valor da cobertura.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre testar comportamento e testar implementação?
2. Quando você utilizaria um mock?
3. Um teste com alta cobertura de linhas é necessariamente bom?

---

## Pergunta 82 — Testes de integração

**Nível:** Pleno  
**Categoria:** Testes automatizados

**Pergunta do entrevistador:**  
Quando um teste de integração é mais apropriado que um teste unitário?

**O que essa pergunta avalia:**  
Avalia se o candidato sabe escolher o nível de teste adequado para validar a interação entre componentes reais.

**Resposta esperada:**  
Um teste de integração é apropriado quando precisamos verificar se dois ou mais componentes funcionam corretamente juntos.

Exemplos:

- Aplicação e banco de dados;
- Aplicação e broker;
- Controller e camada de serviço;
- Serialização e desserialização;
- Integração com uma API externa simulada;
- Mapeamento JPA;
- Transações;
- Configurações de infraestrutura.

O teste deve utilizar dependências reais ou representações próximas do ambiente real, conforme o objetivo. Ele normalmente é mais lento e mais sujeito a problemas de configuração que um teste unitário.

A estratégia deve combinar diferentes níveis de teste, evitando tanto testar tudo de forma isolada quanto depender exclusivamente de testes de ponta a ponta.

**Explicação didática:**  
Um teste unitário pode confirmar que um repositório foi chamado, mas não garante que:

- A consulta SQL está correta;
- O mapeamento da entidade funciona;
- A transação é aplicada;
- A restrição do banco está configurada;
- A serialização possui o formato esperado.

Esses comportamentos exigem testes de integração.

**Exemplo prático:**

~~~java
@SpringBootTest
class PedidoRepositoryIntegrationTest {

    @Autowired
    private PedidoRepository repository;

    @Test
    void devePersistirEPermitirBuscarPedido() {
        Pedido pedido = new Pedido("PED-100");

        repository.save(pedido);

        Optional<Pedido> encontrado =
                repository.findByCodigo("PED-100");

        assertTrue(encontrado.isPresent());
    }
}
~~~

O objetivo é validar a integração entre a aplicação e a persistência.

**Como o candidato deve responder:**

- Defina o objetivo de um teste de integração;
- Dê exemplos de componentes integrados;
- Explique o custo maior;
- Relacione o teste a banco, mensageria ou serialização;
- Evite substituir todos os testes unitários por testes de integração.

**Resposta fraca ou incompleta:**  
“Eu usaria testes de integração para testar todos os métodos, porque são mais completos.”

Testes de integração são importantes, mas podem ser lentos, frágeis e mais difíceis de diagnosticar.

**Critérios de avaliação:**

- **0** — Não diferencia os níveis de teste.
- **1** — Usa apenas testes manuais.
- **2** — Conhece integração, mas não sabe quando aplicá-la.
- **3** — Explica testes entre componentes.
- **4** — Considera banco, configuração, transação e custo.
- **5** — Define uma pirâmide de testes equilibrada, selecionando o nível conforme o risco e o comportamento a validar.

**Perguntas de aprofundamento:**

1. Como testaria uma consulta JPA sem depender de um banco compartilhado?
2. Quais problemas podem ocorrer quando testes compartilham estado?
3. Como reduziria a duração de uma suíte de integração?

---

## Pergunta 83 — Testes de contrato

**Nível:** Pleno  
**Categoria:** Microsserviços e integração

**Pergunta do entrevistador:**  
O que são testes de contrato e por que eles são úteis em uma arquitetura de microsserviços?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre compatibilidade entre consumidores e provedores de APIs ou eventos.

**Resposta esperada:**  
Testes de contrato verificam se a comunicação entre um consumidor e um provedor continua obedecendo ao acordo esperado.

Esse acordo pode definir:

- Campos obrigatórios;
- Tipos de dados;
- Formato da resposta;
- Códigos HTTP;
- Regras de serialização;
- Campos de eventos;
- Comportamento para erros;
- Compatibilidade entre versões.

Eles ajudam a detectar alterações incompatíveis antes que sejam implantadas em produção.

Em microsserviços, testes de contrato podem reduzir a dependência de testes de ponta a ponta, que tendem a ser mais caros e frágeis.

É importante definir quem é responsável pelo contrato e como ele será versionado e validado.

**Explicação didática:**  
Um consumidor pode depender do campo `customerId`. Se o provedor remover esse campo ou alterar seu tipo, a integração poderá falhar mesmo que o provedor continue funcionando isoladamente.

Um teste de contrato torna essa expectativa explícita.

O contrato também deve considerar eventos assíncronos, nos quais o consumidor pode esperar determinada estrutura de mensagem.

**Exemplo de contrato:**

~~~json
{
  "pedidoId": "PED-100",
  "status": "APROVADO",
  "valor": 150.00
}
~~~

Um consumidor pode exigir que `pedidoId` e `status` existam e que `status` possua valores conhecidos.

**Como o candidato deve responder:**

- Explique consumidor e provedor;
- Mencione compatibilidade de APIs e eventos;
- Considere campos obrigatórios e evolução;
- Diferencie contrato de teste unitário;
- Relacione a prevenção de quebras entre serviços.

**Resposta fraca ou incompleta:**  
“Teste de contrato é verificar se o código compila.”

Compilação não garante compatibilidade do formato, comportamento ou semântica da integração.

**Critérios de avaliação:**

- **0** — Não conhece testes de contrato.
- **1** — Confunde contrato com compilação.
- **2** — Conhece APIs, mas ignora compatibilidade.
- **3** — Explica o objetivo básico.
- **4** — Considera APIs, eventos, versões e consumidores.
- **5** — Estrutura contratos evolutivos, compatíveis e automatizados, incluindo mudanças de schema e comunicação assíncrona.

**Perguntas de aprofundamento:**

1. Como evoluiria uma API sem quebrar consumidores antigos?
2. Como testaria o contrato de um evento Kafka?
3. Quem deveria definir e manter o contrato?

---

## Pergunta 84 — Testes de ponta a ponta

**Nível:** Pleno  
**Categoria:** Qualidade de software

**Pergunta do entrevistador:**  
Qual é o papel dos testes de ponta a ponta e quais cuidados você teria ao utilizá-los?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre validação de fluxos completos e os custos associados a esse tipo de teste.

**Resposta esperada:**  
Testes de ponta a ponta verificam um fluxo completo, desde a entrada do sistema até o resultado final, passando por diversos componentes.

Exemplos:

- Criar um pedido;
- Autorizar pagamento;
- Reservar estoque;
- Enviar uma notificação;
- Consultar o status final.

Eles ajudam a validar se os componentes funcionam juntos conforme a perspectiva do usuário ou do processo de negócio.

Porém, tendem a ser:

- Mais lentos;
- Mais caros;
- Mais difíceis de diagnosticar;
- Mais dependentes de ambiente;
- Mais sujeitos a falhas transitórias;
- Mais complexos quando envolvem processamento assíncrono.

Por isso, devem cobrir fluxos críticos, enquanto a maior parte das regras deve ser validada por testes unitários e de integração.

**Explicação didática:**  
Se um teste de ponta a ponta falhar, pode ser difícil saber se o problema está:

- Na API;
- No banco;
- No broker;
- No consumidor;
- Em uma API externa;
- Na configuração do ambiente;
- Em uma condição de corrida.

Uma boa suíte combina testes menores e poucos testes completos para os cenários mais importantes.

**Exemplo de fluxo:**

~~~text
Cliente
  -> API de pedidos
  -> Persistência do pedido
  -> Evento de pedido criado
  -> Serviço de estoque
  -> Serviço de pagamento
  -> Atualização do status
  -> Consulta pelo cliente
~~~

**Como o candidato deve responder:**

- Defina o objetivo do teste;
- Relacione-o a fluxos críticos;
- Mencione custo e diagnóstico;
- Considere processamento assíncrono;
- Explique por que ele não deve substituir testes menores.

**Resposta fraca ou incompleta:**  
“Eu faria todos os testes como ponta a ponta, porque assim o sistema seria testado de verdade.”

Essa estratégia pode tornar a suíte lenta, frágil e difícil de manter.

**Critérios de avaliação:**

- **0** — Não conhece testes de ponta a ponta.
- **1** — Confunde-os com testes unitários.
- **2** — Usa fluxos completos sem considerar custo.
- **3** — Explica sua finalidade básica.
- **4** — Considera dependências, diagnóstico e processamento assíncrono.
- **5** — Define uma estratégia equilibrada, selecionando fluxos críticos e combinando diferentes níveis de teste.

**Perguntas de aprofundamento:**

1. Como testaria um fluxo assíncrono sem criar testes instáveis?
2. Como investigaria uma falha de ponta a ponta?
3. Que fluxos de um sistema de pagamentos deveriam ser cobertos?

---

## Pergunta 85 — Testes de concorrência

**Nível:** Sênior  
**Categoria:** Concorrência e qualidade

**Pergunta do entrevistador:**  
Como você testaria uma funcionalidade Java que precisa funcionar corretamente sob acesso concorrente?

**O que essa pergunta avalia:**  
Avalia a capacidade de validar condições de corrida, consistência e comportamento sob múltiplas execuções simultâneas.

**Resposta esperada:**  
Eu começaria identificando o recurso compartilhado e a invariante que precisa ser preservada.

Depois, criaria testes que:

- Executem operações simultaneamente;
- Utilizem barreiras para sincronizar o início;
- Repitam o cenário várias vezes;
- Verifiquem o estado final;
- Detectem atualizações perdidas;
- Validem ausência de duplicidade;
- Observem deadlocks e timeouts;
- Sejam executados em diferentes níveis, incluindo aplicação e banco.

Também avaliaria se o teste é determinístico o suficiente para produzir evidências úteis. Um teste que falha apenas ocasionalmente precisa de investigação adicional e não deve ser simplesmente repetido até passar.

A validação pode envolver locks, versionamento, transações, filas ou mecanismos de coordenação.

**Explicação didática:**  
Suponha que o estoque disponível seja 1 e duas requisições tentem reservar o produto ao mesmo tempo.

O resultado correto deve impedir que as duas reservas sejam confirmadas.

O teste precisa verificar a regra de negócio e a persistência, pois um bloqueio apenas em memória pode não funcionar com múltiplas instâncias.

**Exemplo prático:**

~~~java
ExecutorService executor = Executors.newFixedThreadPool(2);
CountDownLatch inicio = new CountDownLatch(1);

Future<?> primeira = executor.submit(() -> {
    aguardar(inicio);
    service.reservar(produtoId, 1);
});

Future<?> segunda = executor.submit(() -> {
    aguardar(inicio);
    service.reservar(produtoId, 1);
});

inicio.countDown();

// O teste deve verificar que apenas uma reserva foi confirmada.
~~~

O cenário deve ser complementado por verificações do estado final e tratamento das exceções esperadas.

**Como o candidato deve responder:**

- Identifique o recurso compartilhado;
- Defina a invariante;
- Use execução simultânea controlada;
- Considere banco e múltiplas instâncias;
- Mencione repetição, deadlock e timeout;
- Evite confiar apenas em sincronização local.

**Resposta fraca ou incompleta:**  
“Eu executaria duas requisições manualmente e observaria o resultado.”

Isso é pouco confiável e pode não reproduzir a condição de corrida.

**Critérios de avaliação:**

- **0** — Não sabe testar concorrência.
- **1** — Faz apenas testes sequenciais.
- **2** — Usa múltiplas threads sem definir o resultado esperado.
- **3** — Cria um teste concorrente básico.
- **4** — Considera invariantes, banco, repetição e falhas.
- **5** — Estrutura testes reprodutíveis, analisa condições de corrida, locks, isolamento, múltiplas instâncias e limitações do próprio teste.

**Perguntas de aprofundamento:**

1. Como testaria uma atualização perdida?
2. Por que um `synchronized` local pode não resolver o problema?
3. Como investigaria um deadlock intermitente?

---

## Pergunta 86 — Integração contínua

**Nível:** Júnior  
**Categoria:** DevOps e qualidade

**Pergunta do entrevistador:**  
O que deveria acontecer em um pipeline de integração contínua para uma aplicação Java?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre validação automática e feedback rápido durante o desenvolvimento.

**Resposta esperada:**  
Um pipeline de integração contínua pode executar:

- Compilação;
- Testes unitários;
- Testes de integração;
- Análise estática;
- Verificação de estilo;
- Análise de vulnerabilidades;
- Validação de dependências;
- Empacotamento;
- Geração de artefatos;
- Testes de contrato;
- Verificação de cobertura;
- Publicação de relatórios.

O pipeline deve fornecer feedback rápido e falhar quando houver problemas que impeçam a entrega segura.

Também é importante que os testes sejam reproduzíveis e que o ambiente de validação seja suficientemente próximo do necessário para o objetivo.

A integração contínua não significa apenas executar um build manualmente antes da publicação.

**Explicação didática:**  
Quando cada alteração passa por validações automáticas, problemas podem ser encontrados pouco tempo depois de introduzidos.

Isso reduz o custo de correção e evita que uma alteração incompatível avance para os ambientes seguintes.

O pipeline deve ser confiável. Testes instáveis ou lentos demais podem levar a equipe a ignorar os resultados.

**Exemplo de pipeline:**

~~~text
Alteração submetida
        |
        v
Compilar
        |
        v
Executar testes unitários
        |
        v
Executar análise estática e segurança
        |
        v
Executar testes de integração
        |
        v
Publicar artefato versionado
~~~

Cada etapa deve registrar resultados compreensíveis para a equipe.

**Como o candidato deve responder:**

- Mencione compilação e testes;
- Inclua análise de qualidade e segurança;
- Explique feedback rápido;
- Considere artefatos versionados;
- Evite tratar o pipeline como apenas um processo de deploy.

**Resposta fraca ou incompleta:**  
“O pipeline deve somente gerar o arquivo JAR.”

Gerar o artefato não garante qualidade, segurança, compatibilidade ou comportamento correto.

**Critérios de avaliação:**

- **0** — Não conhece integração contínua.
- **1** — Executa apenas compilação manual.
- **2** — Conhece build, mas ignora testes e segurança.
- **3** — Define um pipeline básico com build e testes.
- **4** — Inclui análise estática, integração e artefatos.
- **5** — Estrutura um pipeline confiável, rápido, seguro, observável e alinhado aos riscos da aplicação.

**Perguntas de aprofundamento:**

1. O que faria se um teste do pipeline fosse instável?
2. Qual é a diferença entre integração contínua e entrega contínua?
3. Como impediria que uma dependência vulnerável fosse publicada?

---

## Pergunta 87 — Qualidade de código e análise estática

**Nível:** Pleno  
**Categoria:** Qualidade e manutenção

**Pergunta do entrevistador:**  
Como você utilizaria análise estática e revisão de código para melhorar a qualidade de uma aplicação Java?

**O que essa pergunta avalia:**  
Avalia a capacidade de combinar automação e revisão humana para detectar problemas antes da produção.

**Resposta esperada:**  
A análise estática pode identificar:

- Problemas de estilo;
- Código inalcançável;
- Possíveis bugs;
- Uso inseguro de APIs;
- Complexidade elevada;
- Duplicação;
- Dependências vulneráveis;
- Problemas de nullabilidade;
- Más práticas conhecidas.

A revisão humana deve avaliar aspectos que as ferramentas não compreendem completamente:

- Clareza;
- Regra de negócio;
- Modelagem;
- Impacto arquitetural;
- Tratamento de erros;
- Segurança contextual;
- Desempenho;
- Testabilidade;
- Manutenibilidade.

As regras devem ser calibradas para evitar excesso de falsos positivos. O objetivo não é gerar o maior número de alertas, mas encontrar problemas relevantes e orientar melhorias.

**Explicação didática:**  
Uma ferramenta pode indicar que um método está muito complexo. Porém, somente a equipe consegue avaliar se a complexidade representa uma regra inevitável do negócio ou se o código pode ser reorganizado.

Da mesma forma, um código que segue o estilo pode conter uma falha de autorização que exige entendimento do fluxo completo.

**Exemplo conceitual:**

~~~text
Validações automáticas:
- Compilação;
- Bugs prováveis;
- Vulnerabilidades;
- Duplicação;
- Complexidade;
- Cobertura mínima.

Revisão humana:
- Regra de negócio;
- Limites de contexto;
- Segurança;
- Impacto operacional;
- Clareza da solução.
~~~

**Como o candidato deve responder:**

- Diferencie automação de revisão humana;
- Mencione bugs, segurança e complexidade;
- Explique a necessidade de regras úteis;
- Relacione revisão a arquitetura e negócio;
- Evite confiar exclusivamente em ferramentas.

**Resposta fraca ou incompleta:**  
“Se a ferramenta não apontar problemas, o código está correto.”

Ferramentas não compreendem todos os requisitos, riscos de negócio ou efeitos operacionais.

**Critérios de avaliação:**

- **0** — Não conhece análise estática ou revisão.
- **1** — Confia apenas na compilação.
- **2** — Usa ferramentas sem interpretar resultados.
- **3** — Explica os benefícios básicos.
- **4** — Combina análise automática e revisão humana.
- **5** — Define uma prática pragmática, com regras calibradas, métricas, segurança, arquitetura e aprendizado contínuo.

**Perguntas de aprofundamento:**

1. Como evitar que a análise estática gere muitos falsos positivos?
2. Que problemas uma ferramenta dificilmente identificaria?
3. Como conduziria uma revisão sem transformá-la em discussão de estilo pessoal?

---

## Pergunta 88 — Qualidade de testes e cobertura

**Nível:** Pleno  
**Categoria:** Estratégia de testes

**Pergunta do entrevistador:**  
Como você avaliaria se uma suíte de testes realmente oferece proteção suficiente para uma aplicação?

**O que essa pergunta avalia:**  
Avalia a capacidade de analisar a efetividade dos testes além de observar apenas o percentual de cobertura.

**Resposta esperada:**  
Eu analisaria:

- Regras críticas cobertas;
- Cenários de sucesso e falha;
- Casos de limite;
- Testes de integração;
- Contratos entre serviços;
- Fluxos de negócio;
- Testes de concorrência quando necessários;
- Detecção de regressões;
- Tempo de execução;
- Estabilidade;
- Facilidade de diagnóstico;
- Taxa de falsos positivos e negativos.

A cobertura de linhas ou branches é um indicador útil, mas não garante que os testes validem os resultados corretos.

Também poderia utilizar análise de mutação para verificar se os testes detectam alterações artificiais no código. Se muitos mutantes passarem, a suíte pode estar executando o código sem verificar adequadamente seu comportamento.

**Explicação didática:**  
Um teste que apenas chama um método sem verificar o resultado aumenta a cobertura, mas oferece pouca proteção.

Uma suíte de qualidade deve falhar quando uma regra importante for quebrada.

Por exemplo, se a regra é impedir estoque negativo, deve existir um teste que falhe quando a validação for removida.

**Exemplo conceitual:**

~~~text
Cobertura de linhas: 90%

Perguntas adicionais:
- Os casos de erro são testados?
- As regras de autorização estão cobertas?
- Há testes de integração?
- Os testes detectam mudanças incorretas?
- Existem testes instáveis?
- Os fluxos críticos possuem validação?
~~~

**Como o candidato deve responder:**

- Explique que cobertura não é suficiente;
- Considere comportamento e risco;
- Mencione casos de erro e limites;
- Fale sobre testes instáveis;
- Cite análise de mutação como possibilidade;
- Relacione a cobertura às regras críticas.

**Resposta fraca ou incompleta:**  
“Se a cobertura for superior a 80%, a aplicação está bem testada.”

Um percentual isolado não informa se os cenários importantes foram realmente protegidos.

**Critérios de avaliação:**

- **0** — Usa apenas cobertura como critério.
- **1** — Considera qualquer execução como teste válido.
- **2** — Conhece cobertura, mas ignora comportamento.
- **3** — Avalia cenários positivos e negativos.
- **4** — Considera risco, estabilidade e diferentes níveis.
- **5** — Analisa efetividade, mutação, fluxos críticos, regressões, custo e confiabilidade da suíte.

**Perguntas de aprofundamento:**

1. O que é análise de mutação?
2. Como identificaria testes que não verificam nada relevante?
3. Como reduziria uma suíte de testes lenta sem perder proteção?

---

## Pergunta 89 — Testes de desempenho

**Nível:** Sênior  
**Categoria:** Desempenho e confiabilidade

**Pergunta do entrevistador:**  
Como você plane jaria testes de desempenho para um serviço Java que processa milhares de requisições por minuto?

**O que essa pergunta avalia:**  
Avalia a capacidade de definir cenários de carga, métricas e critérios de aceitação para desempenho.

**Resposta esperada:**  
Eu começaria definindo:

- Perfil esperado de tráfego;
- Volume normal;
- Picos;
- Crescimento projetado;
- Latência aceitável;
- Taxa máxima de erro;
- Throughput esperado;
- Dependências envolvidas;
- Dados representativos;
- Critérios de sucesso.

Depois, escolheria o tipo de teste adequado:

- **Carga:** comportamento sob volume esperado;
- **Estresse:** comportamento além da capacidade planejada;
- **Pico:** reação a aumento repentino;
- **Resistência:** comportamento durante período prolongado;
- **Escalabilidade:** efeito do aumento de recursos ou instâncias.

As métricas devem incluir:

- Latência média e percentis;
- Throughput;
- Erros;
- CPU;
- Memória;
- Garbage collection;
- Threads;
- Pool de conexões;
- Banco;
- Rede;
- Filas;
- Dependências externas.

O ambiente, a massa de dados e a configuração devem ser suficientemente representativos para que os resultados sejam úteis.

**Explicação didática:**  
Um teste com poucos dados pode não revelar problemas de índice ou crescimento de tabelas.

Um teste de curta duração pode não identificar vazamento de memória.

Também é importante analisar o comportamento depois do limite. Um serviço que fica lento, perde mensagens ou não se recupera após o pico possui problemas diferentes de um serviço que rejeita requisições de forma controlada.

**Exemplo de plano:**

~~~text
Cenário normal:
- 500 requisições por minuto;
- p95 menor que 300 ms;
- erro menor que 1%.

Cenário de pico:
- 2.000 requisições por minuto;
- p95 menor que 1 segundo;
- sem perda de dados;
- recuperação após o pico em até cinco minutos.

Cenário prolongado:
- Carga constante por quatro horas;
- Sem crescimento anormal de memória;
- Sem aumento progressivo de latência.
~~~

**Como o candidato deve responder:**

- Comece pelos requisitos de desempenho;
- Diferencie tipos de teste;
- Mencione percentis, throughput e erros;
- Considere JVM, banco e dependências;
- Use dados representativos;
- Explique a necessidade de critérios objetivos.

**Resposta fraca ou incompleta:**  
“Eu enviaria o maior número possível de requisições e verificaria se o servidor aguenta.”

Isso não define comportamento esperado, métricas, dados, duração nem critérios de sucesso.

**Critérios de avaliação:**

- **0** — Não sabe planejar testes de desempenho.
- **1** — Faz apenas testes informais.
- **2** — Gera carga, mas não define métricas.
- **3** — Planeja carga básica e observa latência.
- **4** — Considera picos, resistência, dependências e recursos.
- **5** — Estrutura testes representativos, critérios de aceitação, análise de gargalos, escalabilidade, recuperação e impacto no negócio.

**Perguntas de aprofundamento:**

1. Por que o p99 pode ser importante em um serviço crítico?
2. Como diferenciaria um gargalo da JVM de um gargalo do banco?
3. Qual é a diferença entre teste de carga e teste de estresse?
4. Como evitaria que o próprio gerador de carga se tornasse o gargalo?

---

## Pergunta 90 — Estratégia de qualidade para uma nova funcionalidade

**Nível:** Sênior  
**Categoria:** Engenharia de qualidade

**Pergunta do entrevistador:**  
Como você definiria a estratégia de testes para uma nova funcionalidade crítica de pagamentos?

**O que essa pergunta avalia:**  
Avalia a capacidade de combinar diferentes técnicas de validação conforme o risco técnico e de negócio.

**Resposta esperada:**  
Eu começaria entendendo o fluxo e os riscos:

- Autorização indevida;
- Cobrança duplicada;
- Valores incorretos;
- Perda de eventos;
- Timeout de provedor;
- Retentativas;
- Concorrência;
- Consistência;
- Auditoria;
- Privacidade;
- Indisponibilidade.

A estratégia poderia incluir:

- Testes unitários para regras de negócio;
- Testes de integração para banco e transações;
- Testes de contrato para APIs e eventos;
- Testes de idempotência;
- Testes de concorrência;
- Testes de segurança;
- Testes de ponta a ponta para os fluxos principais;
- Testes de desempenho;
- Testes de falha e recuperação;
- Validação de observabilidade;
- Rollout gradual com métricas.

Também definiria critérios de aceitação e comportamento esperado em situações de erro.

Para uma cobrança, não basta confirmar que a requisição retornou sucesso. É necessário garantir que não haverá duplicidade, que o estado será consistente e que a operação poderá ser investigada posteriormente.

**Explicação didática:**  
Uma mesma funcionalidade pode parecer correta em um cenário simples, mas falhar quando:

- O cliente repete a requisição;
- A resposta do provedor demora;
- A aplicação recebe a mesma mensagem duas vezes;
- O serviço cai após autorizar o pagamento;
- O banco confirma a transação, mas a resposta não chega;
- Duas instâncias processam o mesmo pedido.

A estratégia de qualidade precisa representar essas condições.

**Exemplo de matriz de testes:**

~~~text
Regra de negócio:
- Valor válido;
- Valor inválido;
- Limite de valor;
- Status permitidos.

Integração:
- Persistência;
- Transação;
- Provedor de pagamento;
- Publicação de eventos.

Resiliência:
- Timeout;
- Retentativa;
- Circuit breaker;
- Mensagem duplicada;
- Falha após autorização.

Segurança:
- Autorização;
- Proteção de dados;
- Logs sem informações sensíveis.

Operação:
- Métricas;
- Traces;
- Alertas;
- Reconciliação.
~~~

**Como o candidato deve responder:**

- Comece pelos riscos do negócio;
- Combine níveis de teste;
- Mencione idempotência e duplicidade;
- Considere falhas externas e concorrência;
- Inclua segurança, observabilidade e desempenho;
- Relacione testes a critérios de aceitação;
- Explique a importância de rollout controlado.

**Resposta fraca ou incompleta:**  
“Eu criaria testes unitários para o serviço e faria um teste manual no ambiente de homologação.”

Essa abordagem não cobre duplicidade, concorrência, falhas externas, contratos, segurança ou comportamento operacional.

**Critérios de avaliação:**

- **0** — Não apresenta estratégia de qualidade.
- **1** — Depende apenas de teste manual.
- **2** — Cria testes unitários, mas ignora riscos distribuídos.
- **3** — Combina testes unitários e de integração.
- **4** — Considera contratos, idempotência, segurança, falhas e fluxos completos.
- **5** — Estrutura uma estratégia baseada em risco, cobrindo negócio, concorrência, resiliência, observabilidade, desempenho, operação e evolução segura.

**Perguntas de aprofundamento:**

1. Como testaria a prevenção de cobrança duplicada?
2. O que deveria acontecer se o provedor autorizasse o pagamento, mas a aplicação caísse antes de salvar o resultado?
3. Como validaria a compatibilidade de um novo evento de pagamento?
4. Que métricas acompanharia durante o rollout?
5. Como faria a reconciliação de pagamentos em estado desconhecido?

---

## Resumo desta parte

- **Perguntas apresentadas:** 81 a 90
- **Perguntas restantes:** 91 a 100
- **Níveis abordados:** Júnior, Pleno e Sênior
- **Categorias:** testes unitários, testes de integração, testes de contrato, testes de ponta a ponta, concorrência, integração contínua, análise estática, cobertura, desempenho e estratégia de qualidade
- **Competências avaliadas:** seleção adequada dos níveis de teste, automação, qualidade de código, validação de integrações, análise de desempenho, testes de concorrência, confiabilidade e cobertura de riscos de negócio

A próxima parte concluirá o roteiro com as perguntas **91 a 100**, abordando liderança técnica, comunicação, gestão de incidentes, priorização, ética profissional e evolução de carreira.

---

`markdown
# Roteiro de Entrevista Técnica — Java e Engenharia de Software

> **Parte 10 de 10 — Perguntas 91 a 100 de 100**

**Objetivo:** preparação para uma posição de Desenvolvedor(a) Java Sênior/Especialista, com foco em microsserviços, mensageria, bancos de dados, observabilidade, nuvem, boas práticas, arquitetura e didática técnica.

**Níveis abordados nesta parte:** Júnior, Pleno e Sênior  
**Estilo:** perguntas conceituais, práticas e baseadas em cenários reais

---

## Pergunta 91 — Comunicação técnica

**Nível:** Júnior  
**Categoria:** Comunicação e colaboração

**Pergunta do entrevistador:**  
Como você explicaria um problema técnico complexo para uma pessoa não especialista?

**O que essa pergunta avalia:**  
Avalia a capacidade de adaptar a comunicação ao público, transmitir riscos com clareza e evitar jargões desnecessários.

**Resposta esperada:**  
Eu começaria entendendo quem é o público e qual decisão precisa ser tomada. Depois, explicaria:

- O problema observado;
- O impacto para o negócio ou para o usuário;
- As possíveis causas;
- As alternativas disponíveis;
- Os riscos;
- A recomendação;
- Os próximos passos.

Usaria exemplos, comparações simples e dados objetivos. Evitaria começar por detalhes de implementação que não sejam relevantes para a decisão.

Também confirmaria se a explicação foi compreendida e deixaria claro o que já é conhecido e o que ainda está sendo investigado.

**Explicação didática:**  
Em vez de dizer que “o pool de conexões atingiu o limite e as threads estão bloqueadas aguardando recursos”, uma explicação para o negócio poderia ser:

> “A aplicação está recebendo mais solicitações simultâneas do que o banco consegue atender. Isso faz algumas operações aguardarem e aumenta o tempo de resposta para os usuários.”

Depois, os detalhes técnicos podem ser apresentados conforme a necessidade.

**Exemplo prático:**

~~~text
Explicação técnica:
O consumer lag está crescendo porque o throughput de processamento
é inferior à taxa de publicação das partições.

Explicação para o negócio:
As solicitações estão chegando mais rápido do que conseguimos processar,
por isso algumas operações estão demorando mais para serem concluídas.
~~~

**Como o candidato deve responder:**

- Adapte a linguagem ao público;
- Explique impacto e consequência;
- Use dados e exemplos;
- Separe fatos de hipóteses;
- Evite jargões sem explicação;
- Confirme se a mensagem foi compreendida.

**Resposta fraca ou incompleta:**  
“Eu explicaria usando todos os termos técnicos para mostrar exatamente o que aconteceu.”

Isso pode dificultar a tomada de decisão e não garante que o público entenda o impacto real.

**Critérios de avaliação:**

- **0** — Não consegue explicar problemas técnicos.
- **1** — Utiliza somente jargões.
- **2** — Explica o problema, mas não adapta a linguagem.
- **3** — Comunica problemas simples com clareza.
- **4** — Relaciona causa, impacto, risco e decisão.
- **5** — Adapta a comunicação a diferentes públicos, separa fatos de hipóteses e facilita decisões sob incerteza.

**Perguntas de aprofundamento:**

1. Como explicaria uma inconsistência eventual para uma pessoa de negócio?
2. Como comunicaria um risco técnico sem causar alarme desnecessário?
3. O que faria se a pessoa não compreendesse sua primeira explicação?

---

## Pergunta 92 — Code review

**Nível:** Pleno  
**Categoria:** Qualidade e colaboração

**Pergunta do entrevistador:**  
Como você conduz uma revisão de código eficaz e como reage quando discorda de uma sugestão recebida?

**O que essa pergunta avalia:**  
Avalia a capacidade de revisar código com foco em qualidade, segurança e colaboração, sem transformar a revisão em disputa pessoal.

**Resposta esperada:**  
Eu analisaria o código considerando:

- Atendimento ao requisito;
- Clareza;
- Correção;
- Tratamento de erros;
- Segurança;
- Desempenho;
- Testes;
- Manutenibilidade;
- Impacto arquitetural;
- Observabilidade.

Os comentários devem ser específicos, respeitosos e relacionados ao código ou ao requisito, não à pessoa.

Quando discordo de uma sugestão, explico meu ponto com base em critérios objetivos, como comportamento, risco, custo de manutenção ou evidências. Se houver dúvida, proponho um experimento, uma discussão com o time ou uma decisão registrada.

Também evitaria bloquear uma alteração por preferências puramente pessoais quando o código atende aos padrões acordados.

**Explicação didática:**  
Um comentário como:

> “Esse método está ruim.”

não orienta a melhoria.

Um comentário mais útil seria:

> “Esta chamada externa ocorre dentro da transação. Podemos avaliar movê-la para fora do limite transacional para evitar manter a conexão e os locks durante o tempo de espera?”

A segunda abordagem aponta o risco e sugere uma linha de investigação.

**Exemplo prático:**

~~~text
Comentário pouco útil:
"Não gosto dessa implementação."

Comentário construtivo:
"Esta operação pode ser executada duas vezes quando houver retentativa.
Podemos torná-la idempotente ou registrar uma chave de processamento
antes de confirmar o resultado?"
~~~

**Como o candidato deve responder:**

- Revise correção, segurança e manutenção;
- Relacione comentários a requisitos e riscos;
- Seja específico e respeitoso;
- Diferencie defeito de preferência pessoal;
- Utilize evidências para resolver divergências;
- Considere o custo de atrasar a entrega.

**Resposta fraca ou incompleta:**  
“Eu aprovaria tudo para não criar conflito com a equipe.”

Isso permite que problemas importantes avancem e reduz o valor da revisão.

**Critérios de avaliação:**

- **0** — Não entende o objetivo de uma revisão.
- **1** — Faz críticas pessoais ou ignora problemas.
- **2** — Revisa apenas estilo e formatação.
- **3** — Verifica correção e testes básicos.
- **4** — Considera segurança, desempenho, manutenção e colaboração.
- **5** — Conduz revisões objetivas, prioriza riscos, utiliza evidências e promove aprendizado coletivo.

**Perguntas de aprofundamento:**

1. O que faria se uma alteração estivesse correta, mas muito difícil de manter?
2. Como diferenciaria um problema crítico de uma sugestão opcional?
3. Como evitaria que a revisão de código se tornasse um gargalo?

---

## Pergunta 93 — Gestão de incidentes

**Nível:** Sênior  
**Categoria:** Operação e liderança técnica

**Pergunta do entrevistador:**  
Como você atuaria durante um incidente de produção que está afetando muitos usuários?

**O que essa pergunta avalia:**  
Avalia a capacidade de priorizar, organizar a investigação, comunicar o impacto e restaurar o serviço com segurança.

**Resposta esperada:**  
Eu começaria confirmando o incidente e avaliando:

- Quais funcionalidades estão afetadas;
- Quantos usuários foram impactados;
- Quando o problema começou;
- Se houve alteração recente;
- Se existe risco de perda ou corrupção de dados;
- Qual é a severidade;
- Quais equipes precisam ser envolvidas.

Durante a resposta, eu priorizaria a restauração segura do serviço. Possíveis ações incluem:

- Reverter uma alteração recente;
- Desabilitar uma funcionalidade por feature flag;
- Reduzir tráfego;
- Ativar uma degradação controlada;
- Isolar uma dependência;
- Aumentar temporariamente a capacidade;
- Interromper uma operação perigosa.

A investigação deve ser baseada em evidências. Também manteria uma comunicação objetiva e frequente para as partes interessadas.

Após a estabilização, faria análise de causa raiz, documentaria o incidente e acompanharia ações preventivas.

**Explicação didática:**  
Durante um incidente, tentar descobrir toda a causa antes de qualquer mitigação pode prolongar o impacto.

É importante separar:

- **Mitigação:** reduzir ou interromper o impacto;
- **Investigação:** entender a causa;
- **Correção definitiva:** eliminar o problema;
- **Prevenção:** reduzir a chance de recorrência.

Uma reversão segura pode ser a melhor decisão mesmo antes de conhecer todos os detalhes.

**Exemplo de comunicação:**

~~~text
Incidente: aumento de erros na criação de pedidos
Impacto: aproximadamente 30% das tentativas desde 14h10
Hipótese atual: alteração recente na integração com estoque
Ação em andamento: desabilitação temporária da nova validação
Próxima atualização: em 15 minutos
~~~

**Como o candidato deve responder:**

- Priorize impacto e restauração;
- Defina severidade;
- Envolva as pessoas certas;
- Use dados para investigar;
- Comunique status e próximos passos;
- Diferencie mitigação de causa raiz;
- Evite procurar culpados durante o incidente.

**Resposta fraca ou incompleta:**  
“Eu analisaria os logs até encontrar o erro e depois corrigiria o código.”

Essa abordagem pode deixar os usuários impactados por muito tempo e não define comunicação ou mitigação.

**Critérios de avaliação:**

- **0** — Não sabe atuar em incidentes.
- **1** — Investiga sem comunicar ou priorizar impacto.
- **2** — Tenta corrigir diretamente, mas sem plano de contenção.
- **3** — Identifica impacto e executa mitigação básica.
- **4** — Organiza investigação, comunicação e restauração.
- **5** — Conduz o incidente com priorização clara, mitigação segura, comunicação estruturada, análise posterior e ações preventivas.

**Perguntas de aprofundamento:**

1. Quando faria rollback?
2. O que faria se a causa ainda fosse desconhecida após a mitigação?
3. Como definiria a severidade de um incidente?
4. Como conduziria a reunião posterior ao incidente?
5. Como evitaria uma cultura de culpabilização?

---

## Pergunta 94 — Post-mortem sem culpabilização

**Nível:** Sênior  
**Categoria:** Aprendizado organizacional

**Pergunta do entrevistador:**  
Como você conduziria um post-mortem após uma falha grave em produção?

**O que essa pergunta avalia:**  
Avalia a capacidade de transformar incidentes em melhorias sistêmicas e promover uma cultura de aprendizado.

**Resposta esperada:**  
O post-mortem deve ser baseado em fatos e não em culpabilização individual.

Eu registraria:

- Linha do tempo dos acontecimentos;
- Sintomas observados;
- Impacto para usuários e negócio;
- Ações de mitigação;
- Causa técnica;
- Fatores contribuintes;
- Como o problema foi detectado;
- Por que os controles existentes não impediram ou limitaram o impacto;
- O que funcionou bem;
- O que precisa melhorar;
- Ações corretivas com responsáveis e prazos.

A análise deve considerar não apenas quem executou uma ação, mas também processos, ferramentas, revisão, testes, permissões, monitoramento e condições organizacionais.

As ações devem ser acompanhadas até a conclusão. Um documento sem mudanças efetivas não produz aprendizado real.

**Explicação didática:**  
Se uma credencial foi publicada acidentalmente, culpar uma pessoa não resolve o risco.

É mais útil perguntar:

- Por que o segredo pôde ser versionado?
- Havia validação automática?
- A credencial possuía permissões excessivas?
- A rotação era simples?
- O monitoramento detectaria o uso indevido?
- O processo de revisão identificava esse tipo de exposição?

Assim, a organização reduz a dependência de atenção individual.

**Exemplo de ação corretiva:**

~~~text
Problema:
Segredo de produção enviado ao repositório.

Ações:
- Revogar a credencial;
- Adicionar verificação automática no pipeline;
- Migrar o segredo para um gerenciador apropriado;
- Reduzir permissões da identidade;
- Criar procedimento de resposta;
- Testar a detecção periodicamente.
~~~

**Como o candidato deve responder:**

- Explique a abordagem sem culpabilização;
- Registre linha do tempo e impacto;
- Identifique fatores sistêmicos;
- Defina ações concretas;
- Atribua responsáveis e prazos;
- Acompanhe a execução das melhorias.

**Resposta fraca ou incompleta:**  
“Eu identificaria quem causou o problema para evitar que isso acontecesse novamente.”

A responsabilização individual não substitui controles técnicos, processos e melhorias sistêmicas.

**Critérios de avaliação:**

- **0** — Não conhece post-mortem.
- **1** — Foca apenas em encontrar culpados.
- **2** — Documenta o incidente, mas não cria ações efetivas.
- **3** — Registra causa, impacto e correções.
- **4** — Considera fatores técnicos e organizacionais.
- **5** — Conduz aprendizado sistêmico, define ações mensuráveis e acompanha a redução de risco.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre causa raiz e fator contribuinte?
2. Como evitaria que as ações do post-mortem fossem esquecidas?
3. O que caracteriza uma cultura sem culpabilização?
4. Como decidiria se uma ação corretiva é suficientemente eficaz?

---

## Pergunta 95 — Priorização de dívida técnica

**Nível:** Pleno  
**Categoria:** Manutenção e estratégia técnica

**Pergunta do entrevistador:**  
Como você priorizaria a correção de dívidas técnicas em uma aplicação Java?

**O que essa pergunta avalia:**  
Avalia a capacidade de relacionar dívida técnica a risco, impacto e objetivos do produto.

**Resposta esperada:**  
Eu não priorizaria a dívida apenas pela idade ou pelo desconforto técnico. Avaliaria:

- Impacto em usuários;
- Frequência de falhas;
- Risco de segurança;
- Risco de indisponibilidade;
- Custo de manutenção;
- Impacto na velocidade de entrega;
- Dificuldade de evolução;
- Probabilidade de incidentes;
- Dependência de tecnologia obsoleta;
- Esforço estimado;
- Benefício esperado.

Dívidas que podem causar perda de dados, falhas de segurança ou indisponibilidade devem receber prioridade elevada.

Também relacionaria a dívida aos próximos objetivos do produto. Se uma área será modificada em breve, pode ser vantajoso corrigir parte da dívida antes ou durante essa mudança.

A dívida técnica deve ser registrada de forma clara, com contexto, impacto e proposta de tratamento.

**Explicação didática:**  
Uma classe difícil de ler, mas estável e pouco modificada, pode ser menos urgente que uma integração frágil responsável por incidentes frequentes.

O conceito de dívida técnica não deve ser usado para justificar qualquer preferência por reescrita. É necessário demonstrar o custo ou o risco que a dívida produz.

**Exemplo de priorização:**

~~~text
Alta prioridade:
- Dependência vulnerável explorável;
- Falhas recorrentes em pagamentos;
- Ausência de backup testado.

Média prioridade:
- Consulta lenta em uma funcionalidade importante;
- Código duplicado em área frequentemente alterada.

Baixa prioridade:
- Organização interna pouco elegante em código estável;
- Refatoração estética sem impacto operacional.
~~~

**Como o candidato deve responder:**

- Priorize por risco e impacto;
- Considere custo e benefício;
- Relacione a dívida ao roadmap;
- Diferencie risco real de preferência pessoal;
- Evite propor reescritas sem evidências;
- Registre ações e critérios.

**Resposta fraca ou incompleta:**  
“Eu corrigiria primeiro o código mais antigo ou o que não segue meu padrão preferido.”

A idade ou a preferência pessoal não representam necessariamente o maior risco para o sistema.

**Critérios de avaliação:**

- **0** — Não sabe priorizar dívida técnica.
- **1** — Prioriza apenas por gosto pessoal.
- **2** — Considera esforço, mas ignora impacto.
- **3** — Avalia risco e benefício básicos.
- **4** — Relaciona dívida a segurança, incidentes e evolução.
- **5** — Estrutura priorização baseada em risco, evidências, custo de oportunidade e objetivos de negócio.

**Perguntas de aprofundamento:**

1. Como convenceria o negócio a investir em dívida técnica?
2. Quando uma reescrita seria justificável?
3. Como mediria se uma dívida técnica foi reduzida?
4. Como evitaria criar nova dívida durante uma entrega urgente?

---

## Pergunta 96 — Mentoria e desenvolvimento de pessoas

**Nível:** Pleno  
**Categoria:** Liderança e colaboração

**Pergunta do entrevistador:**  
Como você ajudaria uma pessoa menos experiente a evoluir tecnicamente sem fazer o trabalho por ela?

**O que essa pergunta avalia:**  
Avalia a capacidade de ensinar, fornecer feedback e desenvolver autonomia na equipe.

**Resposta esperada:**  
Eu começaria entendendo o nível atual da pessoa, seu objetivo e as dificuldades específicas.

Durante o acompanhamento, eu poderia:

- Explicar o contexto do problema;
- Fazer perguntas orientadoras;
- Dividir a tarefa em partes menores;
- Sugerir materiais e exemplos;
- Fazer programação em conjunto;
- Revisar o código com comentários didáticos;
- Dar feedback específico;
- Incentivar a pessoa a explicar sua própria solução;
- Acompanhar a evolução;
- Aumentar gradualmente a responsabilidade.

Eu evitaria assumir a tarefa imediatamente. O objetivo é ajudar a pessoa a desenvolver raciocínio e autonomia, sem deixar de intervir quando houver risco relevante para o projeto.

O feedback deve abordar comportamentos observáveis e oportunidades de melhoria, não características pessoais.

**Explicação didática:**  
Em vez de corrigir todo o código, pode-se perguntar:

- Qual é a regra que precisa ser preservada?
- O que acontece se a mensagem for recebida duas vezes?
- Como você testaria esse cenário?
- Qual dependência externa pode falhar?
- Que métrica indicaria que a solução está funcionando?

Essas perguntas estimulam a análise e ajudam a pessoa a construir a solução.

**Exemplo prático:**

~~~text
Abordagem pouco efetiva:
"Deixe que eu faço."

Abordagem de mentoria:
"Vamos identificar primeiro a regra de negócio.
Depois, você pode propor dois caminhos e avaliamos os riscos de cada um."
~~~

**Como o candidato deve responder:**

- Ensine o raciocínio, não apenas a resposta;
- Adapte a abordagem à pessoa;
- Dê feedback específico;
- Estimule autonomia;
- Acompanhe a evolução;
- Considere segurança e riscos do projeto.

**Resposta fraca ou incompleta:**  
“Eu faria a tarefa rapidamente para garantir que fosse entregue corretamente.”

Isso pode resolver o problema imediato, mas não desenvolve a pessoa nem aumenta a autonomia da equipe.

**Critérios de avaliação:**

- **0** — Não demonstra capacidade de colaborar ou ensinar.
- **1** — Assume todas as tarefas da pessoa.
- **2** — Explica a solução, mas não promove autonomia.
- **3** — Orienta e revisa atividades básicas.
- **4** — Adapta feedback e acompanha a evolução.
- **5** — Desenvolve autonomia, raciocínio crítico, segurança psicológica e capacidade de decisão.

**Perguntas de aprofundamento:**

1. Como daria feedback sobre um erro recorrente?
2. O que faria se a pessoa discordasse da sua orientação?
3. Como equilibraria mentoria e prazo de entrega?
4. Como saberia que a mentoria está funcionando?

---

## Pergunta 97 — Ética profissional e qualidade

**Nível:** Sênior  
**Categoria:** Ética e responsabilidade técnica

**Pergunta do entrevistador:**  
O que você faria se fosse pressionado a liberar uma funcionalidade que sabe possuir um risco grave?

**O que essa pergunta avalia:**  
Avalia a capacidade de agir com responsabilidade diante de pressão por prazo e possíveis impactos para usuários ou negócio.

**Resposta esperada:**  
Eu comunicaria o risco de forma clara, objetiva e documentada, incluindo:

- O problema identificado;
- A probabilidade;
- O impacto potencial;
- Os usuários afetados;
- As opções de mitigação;
- O custo de adiar;
- O risco residual caso a entrega ocorra.

Eu buscaria alternativas, como:

- Reduzir o escopo;
- Desabilitar a parte arriscada;
- Utilizar feature flag;
- Fazer rollout limitado;
- Adicionar validações;
- Liberar apenas para um grupo controlado;
- Criar um plano de rollback;
- Adiar a publicação.

Se o risco envolvesse segurança, privacidade, perda de dados ou fraude, eu escalaria para as pessoas responsáveis e seguiria os procedimentos da organização.

Não esconderia o problema nem afirmaria que a funcionalidade está pronta quando isso não fosse verdade.

**Explicação didática:**  
Qualidade técnica não significa impedir toda entrega. Significa tornar riscos explícitos e permitir uma decisão consciente.

A decisão pode ser liberar com mitigação, desde que:

- O risco seja compreendido;
- O impacto seja limitado;
- Exista monitoramento;
- Haja capacidade de reversão;
- A decisão esteja registrada.

**Exemplo de comunicação:**

~~~text
A funcionalidade pode ser liberada, mas existe risco de duplicidade
quando o provedor demora a responder.

Mitigações disponíveis:
- Ativar idempotência;
- Liberar para 5% dos usuários;
- Monitorar cobranças duplicadas;
- Manter rollback preparado.

Sem essas medidas, não recomendo a liberação em escala total.
~~~

**Como o candidato deve responder:**

- Torne o risco explícito;
- Apresente alternativas;
- Diferencie risco aceitável de risco grave;
- Proponha mitigação;
- Escale questões de segurança e privacidade;
- Evite ocultar problemas para cumprir prazo.

**Resposta fraca ou incompleta:**  
“Eu liberaria porque a decisão final é do gestor.”

Mesmo que a decisão não seja exclusivamente técnica, o profissional deve comunicar claramente os riscos e não ocultar informações relevantes.

**Critérios de avaliação:**

- **0** — Ignora riscos graves.
- **1** — Libera sem comunicar o problema.
- **2** — Comunica, mas não propõe mitigação.
- **3** — Explica riscos e alternativas básicas.
- **4** — Estrutura mitigação, rollout e reversão.
- **5** — Age com transparência, responsabilidade, escalonamento adequado e foco na proteção de usuários e negócio.

**Perguntas de aprofundamento:**

1. Como diferenciaria um risco aceitável de um risco bloqueador?
2. O que faria se o gestor insistisse na liberação?
3. Como documentaria a decisão?
4. Quais tipos de risco exigem escalonamento imediato?

---

## Pergunta 98 — Priorização sob pressão

**Nível:** Sênior  
**Categoria:** Planejamento e tomada de decisão

**Pergunta do entrevistador:**  
Você tem várias solicitações urgentes, uma equipe limitada e um incidente em andamento. Como definiria as prioridades?

**O que essa pergunta avalia:**  
Avalia a capacidade de tomar decisões com recursos limitados, considerando impacto, risco e dependências.

**Resposta esperada:**  
Eu começaria classificando as demandas por:

- Impacto para usuários;
- Risco de segurança;
- Risco de perda ou corrupção de dados;
- Severidade do incidente;
- Urgência real;
- Dependências;
- Prazo externo;
- Esforço;
- Reversibilidade;
- Custo de esperar.

Um incidente grave que afeta muitos usuários normalmente terá prioridade sobre uma melhoria de baixo impacto.

Também verificaria se algumas ações podem ser paralelizadas e se existe uma forma segura de reduzir o impacto enquanto a equipe investiga.

As prioridades devem ser comunicadas, incluindo o que será adiado e por quê. Se houver conflito entre áreas, eu buscaria uma decisão com os responsáveis pelo produto e pelo negócio, apresentando os riscos.

**Explicação didática:**  
Nem tudo que é chamado de urgente possui a mesma prioridade.

Uma falha que impede pagamentos, uma vulnerabilidade explorável e um relatório que pode esperar alguns dias possuem impactos diferentes.

A priorização deve ser revisada conforme novas informações surgem. Uma tarefa inicialmente urgente pode perder prioridade se o risco for mitigado.

**Exemplo de classificação:**

~~~text
Prioridade 1:
- Incidente ativo com impacto financeiro;
- Vulnerabilidade explorável em produção;
- Risco de perda de dados.

Prioridade 2:
- Degradação relevante sem perda de dados;
- Correção necessária para uma entrega próxima.

Prioridade 3:
- Melhoria de desempenho sem impacto atual;
- Refatoração planejada;
- Ajuste estético ou conveniência.
~~~

**Como o candidato deve responder:**

- Priorize impacto e risco;
- Diferencie urgência percebida de urgência real;
- Considere paralelização;
- Comunique decisões e adiamentos;
- Reavalie prioridades com novas evidências;
- Envolva o negócio quando houver trade-offs.

**Resposta fraca ou incompleta:**  
“Eu atenderia as solicitações na ordem em que chegaram.”

A ordem de chegada não considera severidade, impacto, risco ou dependências.

**Critérios de avaliação:**

- **0** — Não consegue priorizar.
- **1** — Segue apenas a ordem de chegada.
- **2** — Considera prazo, mas ignora impacto.
- **3** — Prioriza incidentes e riscos principais.
- **4** — Compara impacto, esforço, dependências e comunicação.
- **5** — Toma decisões transparentes, reavalia prioridades e equilibra estabilidade, segurança, negócio e capacidade da equipe.

**Perguntas de aprofundamento:**

1. Como decidiria entre corrigir uma vulnerabilidade e atender uma entrega comercial?
2. Como comunicaria que uma demanda será adiada?
3. O que faria se duas demandas tivessem o mesmo impacto?
4. Como protegeria a equipe contra excesso de trabalho durante uma crise?

---

## Pergunta 99 — Evolução profissional

**Nível:** Pleno  
**Categoria:** Desenvolvimento de carreira

**Pergunta do entrevistador:**  
Como você se mantém atualizado e decide quais conhecimentos técnicos realmente valem a pena aprender?

**O que essa pergunta avalia:**  
Avalia a capacidade de aprender de forma direcionada e relacionar evolução profissional a problemas reais.

**Resposta esperada:**  
Eu procuro combinar:

- Documentação oficial;
- Livros e materiais técnicos confiáveis;
- Cursos ou treinamentos;
- Discussões com pessoas experientes;
- Participação em revisões;
- Experimentação prática;
- Análise de incidentes;
- Projetos pessoais;
- Comunidades técnicas;
- Acompanhamento de mudanças relevantes no ecossistema.

Eu priorizo conhecimentos relacionados aos problemas que enfrento, aos objetivos da equipe e aos fundamentos que permanecem úteis por mais tempo.

Antes de adotar uma tecnologia, avaliaria:

- Problema que ela resolve;
- Maturidade;
- Segurança;
- Comunidade;
- Custo;
- Compatibilidade;
- Operação;
- Curva de aprendizado;
- Risco de dependência.

Estar atualizado não significa adotar toda novidade.

**Explicação didática:**  
Aprender uma nova ferramenta pode ser útil, mas fundamentos como concorrência, redes, bancos de dados, segurança, testes e modelagem continuam sendo importantes em diferentes tecnologias.

Uma pessoa pode avaliar uma novidade por meio de um pequeno experimento, sem introduzi-la imediatamente em produção.

**Exemplo de plano de aprendizado:**

~~~text
Objetivo:
Melhorar o diagnóstico de lentidão em microsserviços.

Plano:
- Revisar conceitos de latência e concorrência;
- Estudar tracing distribuído;
- Instrumentar um fluxo de teste;
- Analisar métricas reais;
- Compartilhar aprendizados com a equipe;
- Aplicar melhorias em um serviço controlado.
~~~

**Como o candidato deve responder:**

- Combine teoria e prática;
- Priorize problemas reais;
- Utilize fontes confiáveis;
- Avalie tecnologias antes de adotá-las;
- Compartilhe conhecimento;
- Diferencie atualização de adoção imediata.

**Resposta fraca ou incompleta:**  
“Eu acompanho todas as novidades e uso sempre a tecnologia mais recente.”

Novidade não é sinônimo de adequação, maturidade ou benefício para o projeto.

**Critérios de avaliação:**

- **0** — Não demonstra interesse em evolução.
- **1** — Escolhe tecnologias apenas por moda.
- **2** — Estuda, mas não relaciona o aprendizado à prática.
- **3** — Combina estudo e experimentação básica.
- **4** — Avalia problemas, fontes, custos e aplicabilidade.
- **5** — Mantém evolução contínua, compartilha conhecimento e toma decisões tecnológicas baseadas em evidências.

**Perguntas de aprofundamento:**

1. Como avaliaria uma tecnologia ainda pouco madura?
2. Como escolheria entre aprofundar fundamentos e aprender uma ferramenta nova?
3. Como compartilharia um aprendizado com a equipe?
4. Como saberia se um treinamento trouxe resultado prático?

---

## Pergunta 100 — Visão completa de uma solução Java

**Nível:** Sênior  
**Categoria:** Arquitetura, liderança e visão sistêmica

**Pergunta do entrevistador:**  
Você precisa projetar uma nova solução Java para processar pedidos, pagamentos e notificações em escala. Como conduziria a definição da arquitetura?

**O que essa pergunta avalia:**  
Avalia a capacidade de integrar conhecimentos de negócio, arquitetura, segurança, confiabilidade, operação, qualidade e liderança técnica.

**Resposta esperada:**  
Eu começaria entendendo os requisitos:

- Volume esperado;
- Picos;
- Latência;
- Disponibilidade;
- Consistência;
- Requisitos de segurança;
- Privacidade;
- Necessidades de auditoria;
- RTO e RPO;
- Experiência esperada pelo usuário;
- Restrições de custo;
- Capacidade da equipe.

Depois, dividiria o problema em capacidades e definiria limites claros. A solução poderia conter:

- API para recebimento de pedidos;
- Serviço ou módulo de pedidos;
- Persistência transacional;
- Mensageria para processamento assíncrono;
- Serviço de pagamentos;
- Serviço de estoque;
- Serviço de notificações;
- Armazenamento de estados;
- Observabilidade;
- Gestão de segredos;
- Controle de acesso;
- Estratégia de deploy;
- Monitoramento e alertas.

Eu decidiria cuidadosamente quais partes precisam ser síncronas e quais podem ser assíncronas.

Também definiria:

- Contratos de APIs e eventos;
- Idempotência;
- Estratégia de retentativa;
- Dead-letter;
- Timeout;
- Circuit breaker;
- Controle de concorrência;
- Reconciliação;
- Versionamento;
- Testes;
- Rollback;
- Plano de disaster recovery.

A arquitetura deveria ser registrada com seus trade-offs, premissas e critérios para evolução.

**Explicação didática:**  
Uma solução possível seria:

1. O cliente envia o pedido;
2. A API valida a solicitação e registra o pedido como `PENDENTE`;
3. O sistema publica um evento;
4. O processamento de estoque e pagamento ocorre conforme as regras;
5. Cada etapa atualiza o estado de forma idempotente;
6. O usuário consulta o andamento pelo identificador da operação;
7. Notificações são enviadas após os estados relevantes;
8. Processos de reconciliação verificam operações incompletas ou divergentes.

O desenho não deve assumir que mensagens serão entregues apenas uma vez ou que serviços externos sempre responderão rapidamente.

**Exemplo de arquitetura:**

~~~mermaid
flowchart TD
    A[Cliente] --> B[API Gateway]
    B --> C[Serviço de pedidos]
    C --> D[(Banco de pedidos)]
    C --> E[Broker de eventos]

    E --> F[Serviço de estoque]
    E --> G[Serviço de pagamentos]
    E --> H[Serviço de notificações]

    F --> I[(Banco ou sistema de estoque)]
    G --> J[Provedor de pagamentos]
    H --> K[Provedor de mensagens]

    C --> L[Observabilidade]
    F --> L
    G --> L
    H --> L

    G --> M[Reconciliação]
    F --> M
~~~

A arquitetura deve ser adaptada aos requisitos reais. Não seria obrigatório transformar cada capacidade em um microsserviço independente desde o início.

**Como o candidato deve responder:**

- Comece pelos requisitos do negócio;
- Defina limites e contratos;
- Diferencie operações síncronas e assíncronas;
- Considere idempotência e consistência;
- Inclua segurança e privacidade;
- Planeje observabilidade e operação;
- Considere testes, deploy e recuperação;
- Explique trade-offs;
- Evite escolher tecnologias antes de compreender o problema.

**Resposta fraca ou incompleta:**  
“Eu criaria três microsserviços, usaria Kafka e Kubernetes e escalaria tudo automaticamente.”

Essa resposta escolhe tecnologias sem explicar requisitos, limites, consistência, segurança, operação ou riscos.

**Critérios de avaliação:**

- **0** — Não consegue estruturar uma solução.
- **1** — Escolhe tecnologias sem justificar decisões.
- **2** — Define componentes, mas ignora confiabilidade e segurança.
- **3** — Propõe uma arquitetura funcional básica.
- **4** — Considera mensageria, idempotência, observabilidade, testes e operação.
- **5** — Conduz uma definição arquitetural completa, alinhando negócio, domínio, segurança, consistência, resiliência, qualidade, custos, equipe e evolução.

**Perguntas de aprofundamento:**

1. Como evitaria cobrança duplicada?
2. O que aconteceria se o provedor de pagamentos ficasse indisponível?
3. Como trataria um pedido que ficou entre pagamento autorizado e estoque reservado?
4. Quais partes deveriam ser síncronas?
5. Como projetaria a reconciliação?
6. Como faria a evolução dos eventos sem quebrar consumidores?
7. Quais métricas e alertas seriam essenciais?
8. Como garantiria privacidade dos dados?
9. Como faria o deploy sem indisponibilidade?
10. Em que circunstância escolheria um monólito modular em vez de microsserviços?

---

# Encerramento do roteiro

- **Perguntas apresentadas nesta parte:** 91 a 100
- **Total do roteiro:** 100 perguntas
- **Níveis abordados:** Júnior, Pleno e Sênior
- **Temas finais:** comunicação técnica, revisão de código, incidentes, post-mortem, dívida técnica, mentoria, ética, priorização, evolução profissional e arquitetura completa

## Competências avaliadas ao longo das 100 perguntas

- Fundamentos de Java;
- Orientação a objetos;
- Spring e transações;
- Persistência e bancos de dados;
- Concorrência;
- Microsserviços;
- Mensageria;
- Segurança;
- Observabilidade;
- Nuvem e contêineres;
- Kubernetes;
- Arquitetura de software;
- DDD;
- Testes automatizados;
- Desempenho;
- Confiabilidade;
- Liderança técnica;
- Comunicação;
- Tomada de decisão;
- Responsabilidade profissional.

O roteiro completo pode ser utilizado em entrevistas técnicas, simulados, avaliações internas, preparação para processos seletivos e desenvolvimento de competências de engenharia de software.