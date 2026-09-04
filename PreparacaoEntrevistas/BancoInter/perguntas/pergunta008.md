# Pergunta 8 — Transações

**Nível:** Júnior  
**Categoria:** Persistência

**Pergunta do entrevistador:**  
O que é uma transação e qual é a finalidade de utilizar `@Transactional` em uma aplicação Spring?

**O que essa pergunta avalia:**  
Avalia o conhecimento básico sobre consistência de operações que alteram dados.

**Resposta esperada:**  
Uma transação agrupa operações que devem ser tratadas como uma unidade lógica.

As propriedades tradicionalmente associadas a transações são conhecidas como ACID:

- **Atomicidade:** todas as operações são confirmadas ou desfeitas;
- **Consistência:** as regras de integridade são preservadas;
- **Isolamento:** transações concorrentes não devem produzir estados inválidos;
- **Durabilidade:** alterações confirmadas permanecem armazenadas.

Em aplicações Spring, `@Transactional` pode delimitar a transação de um método, dependendo da configuração e da infraestrutura utilizada.

A anotação não torna automaticamente toda integração externa transacional. Uma chamada HTTP ou publicação em outro sistema pode não ser desfeita junto com a transação do banco.

**Explicação didática:**  
Considere uma transferência:

1. Debitar uma conta;
2. Creditar outra conta.

Se o débito ocorrer e o crédito falhar, a transação deve permitir o rollback para evitar um estado inconsistente.

Por outro lado, se o método salvar no banco e depois enviar uma mensagem para Kafka, o rollback do banco não desfaz necessariamente a mensagem publicada.

**Como o candidato deve responder:**

- Defina transação;
- Explique atomicidade e rollback;
- Mencione o limite entre banco e sistemas externos;
- Fale sobre escopo transacional;
- Evite afirmar que `@Transactional` resolve inconsistência distribuída automaticamente.

**Resposta fraca ou incompleta:**  
“`@Transactional` faz todas as operações do sistema voltarem atrás se alguma falhar.”

Isso ignora os limites da transação e as integrações externas.

**Critérios de avaliação:**

- **0** — Não conhece transações.
- **1** — Apresenta definição incorreta.
- **2** — Entende commit e rollback, mas ignora integrações externas.
- **3** — Explica o uso básico de transações.
- **4** — Considera ACID, isolamento e limites práticos.
- **5** — Discute propagação, concorrência, outbox, consistência eventual e trade-offs de isolamento.

**Perguntas de aprofundamento:**

1. O que pode acontecer se uma chamada externa ocorrer dentro de uma transação longa?
2. Como garantiria a publicação de um evento após uma alteração no banco?
3. Qual é o risco de utilizar transações muito abrangentes?

