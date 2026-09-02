# Pergunta 2 — Arquivo `pom.xml`

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Qual é a finalidade do arquivo `pom.xml` e quais informações normalmente são declaradas nele?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre o Project Object Model e a estrutura básica de configuração de um projeto Maven.

**Resposta esperada:**  
O arquivo `pom.xml` é o arquivo central de configuração de um projeto Maven. POM significa **Project Object Model**.

Ele pode conter:

- `groupId`;
- `artifactId`;
- `version`;
- `packaging`;
- Dependências;
- Plugins;
- Propriedades;
- Configurações de build;
- Profiles;
- POM pai;
- Repositórios;
- Informações de distribuição.

**Explicação didática:**  
O Maven lê o `pom.xml` para descobrir o que o projeto é, quais bibliotecas utiliza, como deve ser compilado, quais testes executar e como gerar o artefato final.

O POM funciona como uma descrição declarativa do projeto. Em vez de informar todos os comandos necessários, o desenvolvedor declara as necessidades e o Maven utiliza seus ciclos de vida e plugins.

**Exemplo prático:**

~~~xml
<project>
    <modelVersion>4.0.0</modelVersion>

    <groupId>br.com.exemplo</groupId>
    <artifactId>pedido-api</artifactId>
    <version>1.0.0</version>
</project>
~~~

Esse POM identifica o projeto, embora ainda não contenha configurações de dependências ou plugins.

**Exemplo de código:**  
O exemplo acima é suficiente para demonstrar a estrutura mínima.

**Como o candidato deve responder:**  

- Explique o significado de POM;
- Cite as coordenadas principais;
- Mencione dependências e plugins;
- Explique que o POM é declarativo;
- Não reduza o arquivo ao armazenamento do nome do projeto.

**Resposta fraca ou incompleta:**  
“O `pom.xml` informa o nome da aplicação.”

A resposta ignora as configurações de build, dependências, plugins e empacotamento.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que significam `groupId`, `artifactId` e `version`?
2. Onde as dependências são declaradas?
3. Que problemas podem surgir em um POM excessivamente complexo?

