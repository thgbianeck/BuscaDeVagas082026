# Pergunta 3 — Coordenadas Maven

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Explique o significado de `groupId`, `artifactId` e `version`.

**O que essa pergunta avalia:**  
Avalia a compreensão das coordenadas usadas para identificar um artefato Maven.

**Resposta esperada:**  

- `groupId`: identifica o grupo, organização ou domínio responsável pelo projeto;
- `artifactId`: identifica o nome do artefato;
- `version`: identifica a versão específica do artefato.

Juntos, esses campos formam as principais coordenadas de um projeto ou dependência.

**Explicação didática:**  
As coordenadas permitem diferenciar artefatos com nomes parecidos. Uma biblioteca pode ser identificada, por exemplo, por:

`br.com.exemplo:cliente-api:2.1.0`

Nesse caso:

- `br.com.exemplo` é o `groupId`;
- `cliente-api` é o `artifactId`;
- `2.1.0` é a `version`.

**Exemplo prático:**  
Para utilizar uma biblioteca publicada por uma empresa, o projeto declara suas coordenadas no `pom.xml`.

**Exemplo de código:**

~~~xml
<dependency>
    <groupId>br.com.exemplo</groupId>
    <artifactId>cliente-api</artifactId>
    <version>2.1.0</version>
</dependency>
~~~

**Como o candidato deve responder:**  

- Explique individualmente os três elementos;
- Dê uma coordenada completa;
- Diferencie a versão do projeto da versão de uma dependência;
- Explique que as coordenadas precisam ser consistentes.

**Resposta fraca ou incompleta:**  
“São o nome e a versão do projeto.”

A resposta não explica o papel do grupo e a identificação do artefato.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que o `groupId` costuma seguir o formato de domínio reverso?
2. O que acontece se dois artefatos tiverem as mesmas coordenadas?
3. O que representa uma versão terminada em `-SNAPSHOT`?

