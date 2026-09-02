# Pergunta 2 — Alucinação em ferramentas de IA

**Nível:** Júnior  
**Categoria:** Conceitos e qualidade

**Pergunta do entrevistador:**  
O que significa dizer que uma ferramenta de IA “alucinou” uma resposta? Dê um exemplo relacionado a uma aplicação Java ou Spring Boot e explique como você identificaria o problema.

**O que essa pergunta avalia:**  
Avalia o entendimento de respostas plausíveis, mas incorretas, inventadas ou não verificadas pela IA.

**Resposta esperada:**  
Alucinação ocorre quando a IA apresenta uma informação incorreta como se fosse verdadeira. Ela pode inventar uma classe, método, configuração, biblioteca, anotação ou comportamento que não existe.

Em um projeto Spring Boot, a IA poderia sugerir uma propriedade de configuração inexistente ou uma anotação disponível apenas em outra versão. O problema seria identificado consultando a documentação oficial, verificando as dependências, compilando o projeto e executando testes.

**Explicação didática:**  
A resposta da IA pode parecer profissional e coerente, mas aparência não é evidência de correção. O desenvolvedor deve confirmar informações importantes em fontes confiáveis.

A compilação ajuda, mas não é suficiente. Um código pode compilar e ainda apresentar erro lógico, problema de segurança ou comportamento inadequado em produção.

**Exemplo prático:**  
A IA sugere um método para configurar um timeout. O projeto compila, mas o método não altera o componente correto. O erro somente aparece quando uma chamada externa demora mais que o esperado.

**Exemplo de código:**  
Não é necessário código para esta pergunta.

**Como o candidato deve responder:**  
Deve explicar o conceito com clareza e citar documentação oficial, compilação, testes e validação manual. Uma resposta melhor diferencia erro de sintaxe, erro lógico e informação inventada.

**Resposta fraca ou incompleta:**  
“Alucinação é quando a IA demora para responder ou fica confusa.”

A resposta não identifica o problema de factualidade.

**Critérios de avaliação:**

- **0** — Não sabe responder ou apresenta informações incorretas;
- **1** — Demonstra conhecimento muito superficial;
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes;
- **3** — Responde corretamente aos fundamentos;
- **4** — Demonstra bom domínio prático e apresenta exemplos;
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que uma resposta bem escrita pode estar errada?
2. Que tipos de informação você sempre confirmaria na documentação?
3. Como reduziria a chance de aceitar uma sugestão inventada?

