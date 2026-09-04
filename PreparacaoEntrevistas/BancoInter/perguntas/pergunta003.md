# Pergunta 3 — Exceções verificadas e não verificadas

**Nível:** Júnior  
**Categoria:** Tratamento de erros

**Pergunta do entrevistador:**  
Qual é a diferença entre exceções verificadas e não verificadas em Java? Como você decidiria qual utilizar?

**O que essa pergunta avalia:**  
Avalia se o candidato sabe representar falhas de forma coerente e evitar tratamento inadequado de erros.

**Resposta esperada:**  
Exceções verificadas são aquelas que o compilador exige que sejam capturadas ou declaradas. Normalmente herdam de `Exception`, mas não de `RuntimeException`.

Exceções não verificadas herdam de `RuntimeException` e não precisam ser declaradas explicitamente.

A escolha deve considerar a natureza do erro:

- Uma falha recuperável e esperada pelo consumidor da API pode ser representada por uma exceção específica;
- Erros de programação, argumentos inválidos ou estados impossíveis normalmente são não verificados;
- Não se deve capturar uma exceção apenas para ignorá-la;
- A camada responsável deve adicionar contexto ou convertê-la para um erro adequado.

**Explicação didática:**  
O problema não é apenas escolher entre checked e unchecked. Também é importante:

- Preservar a causa original;
- Não esconder a falha;
- Retornar uma mensagem segura;
- Registrar informações úteis;
- Evitar capturar `Exception` indiscriminadamente.

Em uma API REST, uma exceção interna pode ser convertida em uma resposta HTTP apropriada sem expor detalhes internos.

**Exemplo prático:**

~~~java
public Pedido buscarPedido(Long id) {
    try {
        return repositorio.buscar(id);
    } catch (RepositorioException erro) {
        throw new PedidoConsultaException(
                "Não foi possível consultar o pedido " + id,
                erro
        );
    }
}
~~~

A causa original é preservada, mas a camada de negócio recebe uma exceção mais relacionada ao seu contexto.

**Como o candidato deve responder:**

- Diferencie checked e unchecked;
- Explique que não existe uma regra universal;
- Mencione preservação da causa;
- Relacione o tema a APIs e logs;
- Explique por que não se deve ignorar exceções.

**Resposta fraca ou incompleta:**  
“Eu capturaria todas as exceções e retornaria a mensagem para o usuário.”

Isso pode expor informações internas e impedir um tratamento adequado.

**Critérios de avaliação:**

- **0** — Não conhece exceções.
- **1** — Confunde checked e unchecked.
- **2** — Conhece a diferença, mas não sabe aplicá-la.
- **3** — Explica o conceito e o tratamento básico.
- **4** — Considera contexto, causa original e resposta segura.
- **5** — Discute estratégia de erro por camadas, observabilidade, contratos de API e recuperação controlada.

**Perguntas de aprofundamento:**

1. Por que capturar e ignorar uma exceção é perigoso?
2. Em que situação você criaria uma exceção de negócio?
3. Como evitaria expor um stack trace em uma API pública?

