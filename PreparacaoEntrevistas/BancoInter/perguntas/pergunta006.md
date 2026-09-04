# Pergunta 6 — Injeção de dependências

**Nível:** Júnior  
**Categoria:** Spring e design de código

**Pergunta do entrevistador:**  
O que é injeção de dependências e por que a injeção por construtor costuma ser recomendada em aplicações Spring?

**O que essa pergunta avalia:**  
Avalia o entendimento de desacoplamento, testabilidade e configuração de componentes.

**Resposta esperada:**  
Injeção de dependências ocorre quando uma classe recebe os objetos de que precisa, em vez de criá-los diretamente.

A injeção por construtor é frequentemente recomendada porque:

- Explicita as dependências obrigatórias;
- Permite tornar os campos imutáveis;
- Facilita testes unitários;
- Evita objetos parcialmente inicializados;
- Reduz dependência do container em testes simples.

**Exemplo prático:**

~~~java
@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final PagamentoClient pagamentoClient;

    public PedidoService(
            PedidoRepository repository,
            PagamentoClient pagamentoClient
    ) {
        this.repository = repository;
        this.pagamentoClient = pagamentoClient;
    }
}
~~~

A classe declara claramente tudo aquilo de que necessita para funcionar.

**Explicação didática:**  
Quando uma classe instancia diretamente suas dependências, ela fica fortemente acoplada às implementações concretas:

~~~java
private final PagamentoClient client = new PagamentoClient();
~~~

Isso dificulta substituir o cliente por um mock, trocar sua configuração ou utilizar outra implementação.

A injeção não elimina a necessidade de definir corretamente as responsabilidades da classe.

**Como o candidato deve responder:**

- Explique dependência e inversão de controle;
- Relacione o tema a testes;
- Diferencie injeção por construtor, campo e setter;
- Mencione dependências obrigatórias e opcionais;
- Evite afirmar que o Spring deve ser utilizado em todas as classes.

**Resposta fraca ou incompleta:**  
“É colocar `@Autowired` na classe para o Spring criar tudo.”

Essa resposta descreve apenas um mecanismo e não explica o benefício arquitetural.

**Critérios de avaliação:**

- **0** — Não entende injeção de dependências.
- **1** — Conhece apenas anotações superficialmente.
- **2** — Entende o funcionamento, mas não os benefícios.
- **3** — Explica corretamente a injeção por construtor.
- **4** — Relaciona o conceito a testes, acoplamento e imutabilidade.
- **5** — Discute composição, limites do container, ciclos de dependência e desenho de componentes.

**Perguntas de aprofundamento:**

1. Como testaria essa classe sem iniciar o Spring?
2. O que pode indicar um construtor com muitas dependências?
3. Como resolveria uma dependência circular?

