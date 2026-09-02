# Pergunta 1 — Papel da IA no desenvolvimento

**Nível:** Júnior  
**Categoria:** Fundamentos de IA

**Pergunta do entrevistador:**  
Qual deve ser o papel de uma ferramenta de IA no desenvolvimento de uma aplicação Java e Spring Boot? Explique o que a IA pode fazer, o que não deve ser delegado integralmente a ela e qual deve ser a responsabilidade do desenvolvedor.

**O que essa pergunta avalia:**  
Avalia se o candidato entende a IA como ferramenta de apoio, e não como substituta da análise técnica, da revisão humana e da responsabilidade profissional.

**Resposta esperada:**  
A IA pode auxiliar na geração de código, explicação de trechos, criação de testes, documentação, investigação de erros e sugestão de alternativas. Entretanto, o desenvolvedor continua responsável por entender, revisar, testar, proteger e manter o código produzido.

A saída da IA deve ser tratada como uma sugestão que pode conter erros, omissões, vulnerabilidades ou incompatibilidades com a versão utilizada no projeto.

**Explicação didática:**  
Modelos de IA geram respostas com base em padrões aprendidos. Eles não possuem, necessariamente, conhecimento completo do repositório, das regras de negócio, da infraestrutura ou dos requisitos não funcionais da aplicação.

Por isso, gerar código rapidamente não significa que o código esteja correto. A produtividade só aumenta quando o desenvolvedor consegue validar criticamente o resultado.

**Exemplo prático:**  
A IA pode sugerir um teste para um endpoint, mas o desenvolvedor precisa verificar:

- Se o teste cobre o comportamento esperado;
- Se os dados representam casos reais;
- Se o teste falha quando o código está incorreto;
- Se não existem informações sensíveis nos dados utilizados.

**Exemplo de código:**  
Não é necessário código para esta pergunta.

**Como o candidato deve responder:**  
Deve mencionar apoio à produtividade, revisão humana, testes, segurança, contexto do projeto e responsabilidade técnica. Deve evitar afirmar que a IA “sabe tudo” ou que basta copiar e colar o resultado.

**Resposta fraca ou incompleta:**  
“A IA serve para escrever código mais rápido. Se o código compilar, provavelmente está correto.”

Essa resposta ignora qualidade, segurança, regras de negócio e validação comportamental.

**Critérios de avaliação:**

- **0** — Não sabe responder ou apresenta informações incorretas;
- **1** — Demonstra conhecimento muito superficial;
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes;
- **3** — Responde corretamente aos fundamentos;
- **4** — Demonstra bom domínio prático e apresenta exemplos;
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como você validaria um código gerado por IA?
2. Em que tipos de tarefa você evitaria usar a IA sem revisão?
3. Quem é responsável por um erro introduzido por código gerado por IA?

