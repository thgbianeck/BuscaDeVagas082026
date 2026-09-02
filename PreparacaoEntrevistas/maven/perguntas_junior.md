

## Pergunta 3 — Coordenadas Maven

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

---

## Pergunta 4 — Ciclo de vida padrão

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Quais são as principais fases do ciclo de vida padrão do Maven?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende a sequência de etapas de um build Maven.

**Resposta esperada:**  
Entre as principais fases estão:

- `validate`;
- `compile`;
- `test`;
- `package`;
- `verify`;
- `install`;
- `deploy`.

Quando uma fase é executada, as fases anteriores do mesmo ciclo de vida também são executadas.

**Explicação didática:**  
O ciclo de vida organiza o processo de construção do projeto. Por exemplo, ao executar `package`, o Maven normalmente valida o projeto, compila o código, executa os testes e gera o artefato.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[validate] --> B[compile]
    B --> C[test]
    C --> D[package]
    D --> E[verify]
    E --> F[install]
    F --> G[deploy]
~~~

**Exemplo de código:**

~~~bash
mvn package
~~~

Esse comando executa as etapas anteriores necessárias e gera o pacote configurado.

**Como o candidato deve responder:**  

- Liste as principais fases;
- Explique a ordem;
- Informe que fases anteriores são executadas automaticamente;
- Diferencie gerar, instalar e publicar um artefato.

**Resposta fraca ou incompleta:**  
“`package` apenas cria o JAR.”

A resposta não explica as fases anteriores nem o restante do ciclo de vida.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que acontece ao executar `mvn test`?
2. Qual a diferença entre `package` e `install`?
3. Quando você usaria `verify`?

---

## Pergunta 5 — Fase e goal

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Qual é a diferença entre uma fase do ciclo de vida e uma meta de plugin?

**O que essa pergunta avalia:**  
Avalia a compreensão da relação entre lifecycle, plugins e goals.

**Resposta esperada:**  
Uma fase, como `compile` ou `package`, pertence a um ciclo de vida do Maven. Uma meta, ou goal, é uma operação específica de um plugin.

Por exemplo:

- `package` é uma fase;
- `compiler:compile` é uma meta;
- `dependency:tree` é uma meta executada diretamente.

**Explicação didática:**  
O ciclo de vida define uma sequência padronizada. Os plugins implementam as operações concretas executadas durante essas fases.

**Exemplo prático:**  
O comando abaixo executa uma fase:

~~~bash
mvn package
~~~

Já o comando seguinte executa diretamente uma meta de plugin:

~~~bash
mvn dependency:tree
~~~

**Como o candidato deve responder:**  

- Defina fase;
- Defina goal;
- Explique que goals são fornecidos por plugins;
- Dê pelo menos um exemplo de cada;
- Não trate os dois conceitos como sinônimos.

**Resposta fraca ou incompleta:**  
“Fase e goal são a mesma coisa.”

A resposta não reconhece a separação entre ciclo de vida e operação de plugin.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Dê um exemplo de goal executado diretamente.
2. Como um goal pode ser associado a uma fase?
3. Por que essa separação é útil?

---

## Pergunta 6 — Plugins Maven

**Nível:** Júnior  
**Categoria:** Plugins

**Pergunta do entrevistador:**  
O que são plugins Maven e qual é a função deles?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre a extensibilidade do Maven.

**Resposta esperada:**  
Plugins Maven executam tarefas específicas do processo de build, como:

- Compilar código;
- Executar testes;
- Processar recursos;
- Empacotar aplicações;
- Gerar documentação;
- Analisar qualidade;
- Publicar artefatos.

**Explicação didática:**  
O Maven fornece ciclos de vida e convenções, mas os plugins realizam as operações concretas.

Alguns plugins comuns são:

- `maven-compiler-plugin`;
- `maven-surefire-plugin`;
- `maven-failsafe-plugin`;
- `maven-resources-plugin`;
- `maven-jar-plugin`.

**Exemplo prático:**  
O `maven-compiler-plugin` compila o código Java, enquanto o Surefire executa testes unitários.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique que plugins executam tarefas;
- Diferencie plugin de dependência da aplicação;
- Cite exemplos;
- Explique que plugins podem ser configurados no POM.

**Resposta fraca ou incompleta:**  
“Plugins são bibliotecas usadas pela aplicação.”

Plugins são componentes usados pelo Maven para executar tarefas de build. Eles não são necessariamente dependências de runtime.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual plugin normalmente executa testes unitários?
2. Onde um plugin pode ser configurado?
3. Por que é recomendável fixar a versão de um plugin?

---

## Pergunta 7 — Declaração de dependências

**Nível:** Júnior  
**Categoria:** Dependências

**Pergunta do entrevistador:**  
Como uma dependência é declarada no Maven?

**O que essa pergunta avalia:**  
Avalia a capacidade de configurar bibliotecas externas em um projeto.

**Resposta esperada:**  
A dependência é declarada dentro de `<dependencies>`, normalmente com:

- `groupId`;
- `artifactId`;
- `version`;
- `scope`, quando necessário.

**Explicação didática:**  
O Maven utiliza essas coordenadas para localizar a biblioteca em um repositório. Ele também resolve as dependências transitivas necessárias.

**Exemplo de código:**

~~~xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
~~~

A dependência acima é usada durante os testes e não deve ser necessária para executar a aplicação em produção.

**Como o candidato deve responder:**  

- Mostre a estrutura XML;
- Explique cada campo;
- Explique o uso de `scope`;
- Diferencie dependência direta de transitiva.

**Resposta fraca ou incompleta:**  
“Basta colocar o nome do JAR no POM.”

O Maven utiliza coordenadas e repositórios, não apenas o nome de um arquivo JAR.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que são dependências transitivas?
2. Quando utilizar `scope` `test`?
3. Por que evitar copiar JARs manualmente para o projeto?

---

## Pergunta 8 — Dependência transitiva

**Nível:** Júnior  
**Categoria:** Dependências

**Pergunta do entrevistador:**  
O que é uma dependência transitiva?

**O que essa pergunta avalia:**  
Avalia o entendimento do grafo de dependências do Maven.

**Resposta esperada:**  
Uma dependência transitiva é uma biblioteca exigida por outra dependência declarada diretamente pelo projeto.

Se o projeto depende de A e A depende de B, então B é uma dependência transitiva do projeto.

**Explicação didática:**  
Esse mecanismo evita que o desenvolvedor precise declarar manualmente todas as bibliotecas utilizadas internamente por uma dependência.

Porém, dependências transitivas também podem trazer conflitos de versão ou bibliotecas que não são desejadas.

**Exemplo prático:**

~~~mermaid
flowchart LR
    P[Projeto] --> A[Dependência A]
    A --> B[Dependência B]
    B --> C[Dependência C]
~~~

Nesse fluxo, A é direta, enquanto B e C podem ser transitivas.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique a cadeia entre dependências;
- Dê um exemplo com A, B e C;
- Mencione possíveis conflitos;
- Cite `dependency:tree` como ferramenta de investigação.

**Resposta fraca ou incompleta:**  
“Dependência transitiva é uma dependência opcional.”

Transitividade indica a forma como a dependência foi incluída, não se ela é opcional.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como visualizar o grafo de dependências?
2. Como excluir uma dependência transitiva?
3. Que problemas podem surgir com versões conflitantes?

---

## Pergunta 9 — Escopos de dependência

**Nível:** Júnior  
**Categoria:** Dependências

**Pergunta do entrevistador:**  
Explique os escopos `compile`, `provided`, `runtime` e `test`.

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre disponibilidade de dependências em diferentes etapas.

**Resposta esperada:**  

- `compile`: é o escopo padrão; a dependência fica disponível para compilação, testes e execução;
- `provided`: é necessária para compilar e testar, mas deve ser fornecida pelo ambiente de execução;
- `runtime`: não é necessária para compilar, mas é necessária durante a execução;
- `test`: fica disponível somente durante compilação e execução dos testes.

**Explicação didática:**  
O escopo influencia o classpath e a forma como a dependência será disponibilizada no artefato final.

**Exemplo prático:**  
Uma API fornecida por um servidor de aplicações pode usar `provided`, enquanto uma biblioteca de testes usa `test`.

**Exemplo de código:**

~~~xml
<dependency>
    <groupId>org.exemplo</groupId>
    <artifactId>api-web</artifactId>
    <version>1.0.0</version>
    <scope>provided</scope>
</dependency>
~~~

**Como o candidato deve responder:**  

- Compare os quatro escopos;
- Dê um exemplo prático;
- Explique o impacto no runtime;
- Não diga que todos funcionam da mesma forma.

**Resposta fraca ou incompleta:**  
“Os escopos servem apenas para organizar o POM.”

Eles controlam a disponibilidade da dependência em diferentes classpaths.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando utilizar `provided`?
2. Qual a diferença entre `runtime` e `compile`?
3. Uma dependência `test` entra no pacote final?

---

## Pergunta 10 — Repositórios Maven

**Nível:** Júnior  
**Categoria:** Dependências

**Pergunta do entrevistador:**  
O que é um repositório Maven e quais tipos são mais comuns?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre armazenamento e distribuição de artefatos.

**Resposta esperada:**  
Um repositório Maven é um local onde artefatos, como JARs, POMs, fontes e metadados, são armazenados e disponibilizados.

Os tipos mais comuns são:

- Repositório local;
- Repositório remoto;
- Repositório central;
- Repositório privado ou corporativo.

**Explicação didática:**  
O repositório local normalmente fica no diretório `.m2/repository`. O Maven consulta esse local e, quando necessário, busca artefatos em repositórios remotos.

Empresas podem usar ferramentas como Nexus ou Artifactory para armazenar bibliotecas internas e controlar o acesso a dependências.

**Exemplo prático:**  
Uma organização pode configurar um repositório privado para hospedar seus próprios artefatos e criar um cache de dependências públicas.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Diferencie repositório local e remoto;
- Explique o uso de repositórios privados;
- Mencione artefatos;
- Evite dizer que o repositório contém apenas código-fonte.

**Resposta fraca ou incompleta:**  
“É uma pasta que contém o código do projeto.”

Repositórios normalmente armazenam artefatos publicados e seus metadados.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual é a função do repositório local?
2. Por que utilizar um repositório privado?
3. O que acontece quando o Maven não consegue acessar um repositório remoto?

---

## Pergunta 11 — Comandos básicos

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Quais comandos Maven você utilizaria com mais frequência no dia a dia?

**O que essa pergunta avalia:**  
Avalia a familiaridade prática com o fluxo de desenvolvimento.

**Resposta esperada:**  
Alguns comandos comuns são:

- `mvn clean`;
- `mvn compile`;
- `mvn test`;
- `mvn package`;
- `mvn verify`;
- `mvn install`;
- `mvn deploy`.

Também é comum combinar fases, como:

~~~bash
mvn clean package
~~~

**Explicação didática:**  
Cada fase tem uma finalidade. `clean` remove resultados anteriores, `test` executa testes, `package` gera o artefato, `install` instala localmente e `deploy` publica em um repositório remoto.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[mvn clean] --> B[mvn test]
    B --> C{Testes passaram?}
    C -->|Sim| D[mvn package]
    C -->|Não| E[Corrigir falhas]
    E --> B
~~~

**Como o candidato deve responder:**  

- Associe cada comando à sua finalidade;
- Explique a diferença entre gerar, instalar e publicar;
- Cite um comando usado em CI;
- Não diga que todos os comandos fazem a mesma coisa.

**Resposta fraca ou incompleta:**  
“Uso sempre `mvn install`, independentemente do caso.”

Isso demonstra pouca compreensão do fluxo de build.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual comando você usaria antes de gerar uma versão limpa?
2. Qual a diferença entre `package` e `install`?
3. Qual comando costuma ser adequado para validação em uma pipeline?

---

## Pergunta 12 — Comando `clean`

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O que o comando `mvn clean` faz e quando você o utilizaria?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre remoção de resultados de builds anteriores.

**Resposta esperada:**  
O comando `mvn clean` executa o ciclo de vida `clean`, normalmente removendo o diretório `target` e outros resultados gerados pelo build anterior.

**Explicação didática:**  
Arquivos antigos podem permanecer após alterações no POM, plugins ou código. A limpeza permite construir novamente a partir de uma situação mais previsível.

O comando não corrige erros de código, não atualiza automaticamente todas as dependências e não apaga o repositório local inteiro.

**Exemplo prático:**

~~~bash
mvn clean package
~~~

Esse comando remove resultados antigos e depois executa o build até a fase de empacotamento.

**Como o candidato deve responder:**  

- Explique que o diretório `target` costuma ser removido;
- Diga quando uma compilação limpa é útil;
- Explique o que o comando não faz;
- Não trate `clean` como solução universal.

**Resposta fraca ou incompleta:**  
“`mvn clean` corrige qualquer problema do projeto.”

Ele apenas remove artefatos gerados anteriormente.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual diretório normalmente é removido?
2. Quando `clean` não resolveria o problema?
3. Qual é o custo de executar sempre um build limpo?

---

## Pergunta 13 — Comando `compile`

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
O que acontece quando executamos `mvn compile`?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre a fase de compilação.

**Resposta esperada:**  
O Maven executa as fases anteriores necessárias e compila o código principal, geralmente localizado em `src/main/java`.

As classes compiladas normalmente são gravadas em:

`target/classes`

**Explicação didática:**  
A fase `compile` verifica se o código principal pode ser transformado em bytecode. Ela não tem como objetivo executar todos os testes nem necessariamente criar o pacote final.

**Exemplo prático:**  
Erros de sintaxe, imports inválidos e incompatibilidades de versão do Java podem aparecer durante essa fase.

**Exemplo de código:**

~~~bash
mvn compile
~~~

**Como o candidato deve responder:**  

- Informe a origem do código;
- Informe o diretório de saída;
- Explique que testes não são o objetivo principal dessa fase;
- Diferencie compilação de empacotamento.

**Resposta fraca ou incompleta:**  
“`compile` executa e publica a aplicação.”

A fase de compilação não publica nem necessariamente empacota o projeto.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde ficam as classes compiladas?
2. Os testes são executados com `mvn compile`?
3. O que você investigaria diante de um erro de compilação?

---

## Pergunta 14 — Comando `test`

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
O que normalmente acontece quando executamos `mvn test`?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre a execução de testes automatizados.

**Resposta esperada:**  
O Maven executa as fases anteriores, compila o código principal, compila os testes e executa os testes configurados, normalmente por meio do Maven Surefire Plugin.

Os testes geralmente ficam em:

`src/test/java`

**Explicação didática:**  
A fase `test` fornece feedback sobre o comportamento do código. Se um teste falhar, o build normalmente termina com erro.

O resultado dos testes costuma ser gerado em diretórios dentro de `target`.

**Exemplo prático:**

~~~bash
mvn test
~~~

Esse comando é usado localmente e em pipelines de integração contínua.

**Como o candidato deve responder:**  

- Mencione compilação do código e dos testes;
- Cite `src/test/java`;
- Explique a função do Surefire;
- Informe que testes falhos normalmente fazem o build falhar.

**Resposta fraca ou incompleta:**  
“Ele verifica se o programa funciona.”

Essa resposta é genérica e não explica o processo de execução de testes.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual plugin normalmente executa testes unitários?
2. O que acontece quando um teste falha?
3. Como executar somente uma classe de teste?

---

## Pergunta 15 — Fase `package`

**Nível:** Júnior  
**Categoria:** Empacotamento

**Pergunta do entrevistador:**  
Qual é a finalidade da fase `package`?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre geração de artefatos.

**Resposta esperada:**  
A fase `package` executa as fases anteriores e gera o artefato do projeto, como um JAR, WAR ou outro formato configurado.

O tipo de empacotamento é definido por `<packaging>`. Quando ele é omitido, o padrão geralmente é `jar`.

**Explicação didática:**  
O empacotamento transforma o resultado compilado em um arquivo que pode ser distribuído ou utilizado por outros projetos.

A fase `package` não instala automaticamente o artefato no repositório local nem o publica em um repositório remoto.

**Exemplo de código:**

~~~xml
<packaging>jar</packaging>
~~~

~~~bash
mvn package
~~~

**Como o candidato deve responder:**  

- Explique que um artefato é gerado;
- Cite JAR ou WAR;
- Diferencie `package`, `install` e `deploy`;
- Informe que o resultado normalmente aparece em `target`.

**Resposta fraca ou incompleta:**  
“`package` envia o JAR para o Nexus.”

A publicação remota está relacionada à fase `deploy`, não apenas a `package`.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde o artefato é gerado?
2. Qual é o empacotamento padrão?
3. Como gerar um WAR?

---

## Pergunta 16 — Diferença entre `package` e `install`

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Qual é a diferença entre `mvn package` e `mvn install`?

**O que essa pergunta avalia:**  
Avalia a compreensão da geração e da instalação local de artefatos.

**Resposta esperada:**  
`mvn package` executa o build até gerar o artefato no diretório `target`.

`mvn install` executa as fases anteriores, gera o artefato e também o instala no repositório Maven local, geralmente em `.m2/repository`.

**Explicação didática:**  
A instalação local permite que outro projeto, na mesma máquina, utilize a versão construída como dependência.

Isso é útil durante o desenvolvimento de bibliotecas locais, mas não significa publicação em um servidor remoto.

**Exemplo prático:**

~~~bash
mvn clean install
~~~

Depois desse comando, outro projeto pode encontrar a biblioteca instalada localmente pelas suas coordenadas.

**Como o candidato deve responder:**  

- Explique a diferença entre gerar e instalar;
- Cite o repositório local;
- Diga que `install` não significa deploy em produção;
- Dê um exemplo de uso.

**Resposta fraca ou incompleta:**  
“`install` envia o projeto para produção.”

O comando instala o artefato localmente; não implanta necessariamente uma aplicação em um servidor.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde o artefato é instalado?
2. Quando você usaria `install`?
3. Qual a diferença entre `install` e `deploy`?

---

## Pergunta 17 — Fase `deploy`

**Nível:** Júnior  
**Categoria:** Publicação

**Pergunta do entrevistador:**  
O que a fase `deploy` realiza no Maven?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre publicação de artefatos em repositórios remotos.

**Resposta esperada:**  
A fase `deploy` executa as fases anteriores, gera o artefato e o publica em um repositório remoto configurado.

Esse repositório pode ser corporativo, como Nexus ou Artifactory.

**Explicação didática:**  
A publicação remota permite que outros projetos, desenvolvedores ou pipelines consumam o artefato.

Para funcionar corretamente, geralmente são necessárias configurações de distribuição, autenticação e permissões.

**Exemplo prático:**

~~~bash
mvn deploy
~~~

Uma biblioteca aprovada pode ser publicada dessa forma no repositório interno da organização.

**Como o candidato deve responder:**  

- Diferencie `deploy` de `install`;
- Explique que o destino é remoto;
- Mencione credenciais e permissões;
- Não confunda a fase Maven com implantação da aplicação em produção.

**Resposta fraca ou incompleta:**  
“`deploy` inicia a aplicação no servidor.”

No Maven, a fase normalmente se refere à publicação de artefatos em um repositório remoto.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre `install` e `deploy`?
2. Onde as credenciais de publicação devem ser configuradas?
3. Quais riscos existem ao publicar uma versão incorreta?

---

## Pergunta 18 — Estrutura convencional de diretórios

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Quais são os diretórios convencionais de um projeto Maven?

**O que essa pergunta avalia:**  
Avalia a familiaridade com a estrutura padrão de projetos Maven.

**Resposta esperada:**  

- `src/main/java`: código principal;
- `src/main/resources`: recursos da aplicação;
- `src/test/java`: código de testes;
- `src/test/resources`: recursos usados pelos testes;
- `target`: resultados gerados pelo build.

**Explicação didática:**  
As convenções permitem que o Maven funcione com pouca configuração explícita.

Quando o projeto utiliza os diretórios esperados, os plugins conseguem encontrar código, recursos e testes automaticamente.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[src] --> B[main]
    A --> C[test]
    B --> D[java]
    B --> E[resources]
    C --> F[java]
    C --> G[resources]
    D --> H[Código de produção]
    F --> I[Testes]
~~~

**Como o candidato deve responder:**  

- Liste os principais diretórios;
- Explique a separação entre produção e testes;
- Mencione `target`;
- Explique que estruturas diferentes exigem configuração adicional.

**Resposta fraca ou incompleta:**  
“Todo o código fica dentro de `src`.”

A resposta não diferencia código principal, testes e recursos.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde ficam os recursos de produção?
2. Onde ficam os testes?
3. Por que o diretório `target` normalmente não deve ser versionado?

---

## Pergunta 19 — Convenção sobre configuração

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
O que significa o princípio “convenção sobre configuração” no Maven?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre padrões que reduzem a necessidade de configurações explícitas.

**Resposta esperada:**  
Significa que o Maven adota convenções para nomes de diretórios, fases, localização de fontes, testes e recursos.

Quando um projeto segue essas convenções, é necessário escrever menos configuração no POM.

**Explicação didática:**  
Por exemplo, o Maven já sabe que o código principal normalmente está em `src/main/java`. Não é necessário informar essa localização em todos os projetos.

A vantagem é a simplicidade. A limitação é que projetos com estruturas muito diferentes precisam de configurações adicionais.

**Exemplo prático:**  
Um projeto organizado de acordo com as convenções pode ser compilado com:

~~~bash
mvn compile
~~~

sem exigir configuração manual de cada diretório.

**Como o candidato deve responder:**  

- Explique o significado do princípio;
- Dê um exemplo de diretório padrão;
- Mencione simplicidade e previsibilidade;
- Cite a necessidade de configuração quando o projeto foge do padrão.

**Resposta fraca ou incompleta:**  
“Significa que o Maven não pode ser configurado.”

O Maven permite configurações personalizadas, embora incentive o uso de convenções.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a vantagem de seguir convenções?
2. Quando uma configuração personalizada seria necessária?
3. Que risco existe ao personalizar excessivamente o build?

---

## Pergunta 20 — Tipos de `packaging`

**Nível:** Júnior  
**Categoria:** Empacotamento

**Pergunta do entrevistador:**  
Quais são alguns valores possíveis para o elemento `<packaging>`?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre tipos de artefato gerados pelo Maven.

**Resposta esperada:**  
Alguns valores comuns são:

- `jar`;
- `war`;
- `pom`.

Outros tipos podem ser suportados por plugins específicos.

**Explicação didática:**  
O valor de `packaging` influencia as metas associadas às fases do ciclo de vida e o tipo principal de artefato gerado.

Um projeto de biblioteca geralmente usa `jar`. Uma aplicação web tradicional pode usar `war`. Um projeto agregador pode usar `pom`.

**Exemplo prático:**

~~~xml
<packaging>war</packaging>
~~~

Essa configuração indica que o projeto produzirá um arquivo WAR, desde que as configurações necessárias estejam presentes.

**Como o candidato deve responder:**  

- Cite pelo menos `jar`, `war` e `pom`;
- Explique o uso de cada um;
- Diga que `jar` normalmente é o padrão;
- Não confunda packaging com sistema operacional.

**Resposta fraca ou incompleta:**  
“Packaging define onde a aplicação será executada.”

Ele define principalmente o tipo de artefato e o comportamento associado ao empacotamento.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual é o valor padrão quando `packaging` é omitido?
2. Quando utilizar `war`?
3. Qual a finalidade de um projeto com `packaging` `pom`?

---

## Pergunta 21 — Propriedades do Maven

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
Como as propriedades são utilizadas no `pom.xml`?

**O que essa pergunta avalia:**  
Avalia a capacidade de centralizar valores de configuração.

**Resposta esperada:**  
As propriedades armazenam valores reutilizáveis, como versão do Java, encoding, versões de dependências e configurações de plugins.

Elas são referenciadas com a sintaxe:

`${nome.da.propriedade}`

**Explicação didática:**  
Centralizar valores evita duplicação. Quando uma versão precisa ser atualizada, normalmente basta alterar um único local.

**Exemplo de código:**

~~~xml
<properties>
    <java.version>17</java.version>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
~~~

Uma propriedade pode ser utilizada em outro ponto do POM:

~~~xml
<version>${java.version}</version>
~~~

O uso concreto deve respeitar o significado esperado de cada elemento.

**Como o candidato deve responder:**  

- Explique o conceito de propriedade;
- Mostre a sintaxe;
- Dê um exemplo de versão ou encoding;
- Explique a vantagem de evitar duplicidade;
- Evite esconder configurações difíceis de compreender.

**Resposta fraca ou incompleta:**  
“Propriedades são variáveis usadas pela aplicação em runtime.”

No Maven, elas normalmente configuram o build e o POM.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como definir a versão do Java em uma propriedade?
2. Por que centralizar versões?
3. Que problemas podem surgir com nomes de propriedades pouco claros?

---

## Pergunta 22 — Configuração da versão do Java

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
Como configurar no Maven a versão do Java utilizada pelo projeto?

**O que essa pergunta avalia:**  
Avalia a capacidade de tornar o build previsível entre diferentes ambientes.

**Resposta esperada:**  
A versão do Java deve ser definida no POM, normalmente por propriedades e pela configuração do compilador. Em versões atuais do Maven Compiler Plugin, pode-se utilizar a propriedade `maven.compiler.release`.

**Exemplo de código:**

~~~xml
<properties>
    <maven.compiler.release>17</maven.compiler.release>
</properties>
~~~

Também é importante alinhar o JDK local, o JDK do CI e o ambiente de execução.

**Explicação didática:**  
Se cada máquina utilizar uma versão diferente do Java, o projeto pode compilar em um ambiente e falhar em outro.

A configuração `release` ajuda a indicar a versão da plataforma Java para a qual o código deve ser compilado, mas o JDK instalado ainda precisa ser compatível com essa configuração.

**Como o candidato deve responder:**  

- Explique que a versão deve ser declarada no projeto;
- Mencione o Maven Compiler Plugin ou propriedades equivalentes;
- Fale sobre alinhamento entre máquina local e CI;
- Não diga que o Maven sempre escolhe a versão correta automaticamente.

**Resposta fraca ou incompleta:**  
“O Maven usa sempre a versão mais recente do Java instalada.”

Isso pode gerar builds diferentes em ambientes distintos.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre `source`, `target` e `release`?
2. O que pode acontecer se o CI usar outro JDK?
3. Como documentar o JDK exigido pelo projeto?

---

## Pergunta 23 — Maven Compiler Plugin

**Nível:** Júnior  
**Categoria:** Plugins

**Pergunta do entrevistador:**  
Qual é a função do `maven-compiler-plugin`?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre compilação configurável no Maven.

**Resposta esperada:**  
O `maven-compiler-plugin` compila o código Java. Ele permite configurar aspectos como:

- Versão da linguagem;
- Versão de destino;
- `release`;
- Encoding;
- Argumentos do compilador;
- Parâmetros de compilação.

**Explicação didática:**  
O plugin é associado principalmente às fases de compilação. Ele transforma o código-fonte Java em bytecode.

Mesmo que alguns comportamentos possuam padrões, é recomendável configurar explicitamente as versões relevantes para tornar o build mais previsível.

**Exemplo de código:**

~~~xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.13.0</version>
    <configuration>
        <release>17</release>
    </configuration>
</plugin>
~~~

**Como o candidato deve responder:**  

- Explique que o plugin compila código;
- Relacione-o à fase `compile`;
- Cite configuração de versão;
- Diferencie compilação de execução de testes.

**Resposta fraca ou incompleta:**  
“Esse plugin executa os testes.”

A execução de testes normalmente é responsabilidade de plugins como Surefire ou Failsafe.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual fase utiliza esse plugin?
2. Como configurar o encoding?
3. Por que fixar a versão do plugin?

---

## Pergunta 24 — Surefire e Failsafe

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Qual é a diferença geral entre o Maven Surefire Plugin e o Maven Failsafe Plugin?

**O que essa pergunta avalia:**  
Avalia o conhecimento inicial sobre a separação entre testes unitários e testes de integração.

**Resposta esperada:**  
O Surefire é normalmente utilizado para executar testes unitários durante a fase `test`.

O Failsafe é normalmente utilizado para testes de integração, associados às fases `integration-test` e `verify`.

**Explicação didática:**  
Testes unitários costumam ser rápidos e isolados. Testes de integração podem depender de banco de dados, serviços externos, containers ou outros componentes.

A separação permite obter feedback rápido com testes unitários e executar testes de integração em momentos apropriados.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[compile] --> B[test]
    B --> C[Surefire: testes unitários]
    C --> D[integration-test]
    D --> E[Failsafe: testes de integração]
    E --> F[verify]
~~~

**Como o candidato deve responder:**  

- Relacione Surefire à fase `test`;
- Relacione Failsafe a `integration-test` e `verify`;
- Explique a diferença de finalidade;
- Não diga que são plugins completamente iguais.

**Resposta fraca ou incompleta:**  
“Os dois plugins executam exatamente os mesmos testes.”

Embora ambos estejam relacionados a testes, participam de fluxos diferentes.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que usar `verify` para testes de integração?
2. Como evitar que testes de integração rodem em todo commit?
3. Qual o risco de misturar testes unitários e de integração?

---

## Pergunta 25 — Testes ignorados

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Como você lidaria com um teste que precisa ser temporariamente ignorado no Maven?

**O que essa pergunta avalia:**  
Avalia responsabilidade na manutenção da suíte de testes e conhecimento de opções do Maven.

**Resposta esperada:**  
O ideal é identificar e corrigir a causa da falha. Em uma situação excepcional, pode-se ignorar temporariamente a execução, desde que:

- O motivo seja documentado;
- O impacto seja conhecido;
- A alteração seja acompanhada de uma tarefa;
- O teste volte a ser executado o mais rápido possível.

**Explicação didática:**  
Ignorar testes pode permitir que o build continue, mas também pode esconder regressões.

Por isso, opções como `-DskipTests` devem ser usadas com cuidado e não como solução permanente para falhas.

**Exemplo de código:**

~~~bash
mvn package -DskipTests
~~~

Esse comando pula a execução dos testes, mas o comportamento exato de compilação dos testes pode depender da configuração utilizada.

**Como o candidato deve responder:**  

- Priorize corrigir a causa;
- Explique que ignorar deve ser temporário;
- Diferencie comportamento local de pipeline;
- Mencione documentação e acompanhamento;
- Não recomende sempre ignorar testes.

**Resposta fraca ou incompleta:**  
“Sempre uso `-DskipTests` quando existe uma falha.”

Essa prática mascara problemas e reduz a segurança do processo de build.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre `skipTests` e `maven.test.skip`?
2. Em que situação ignorar testes poderia ser aceitável?
3. Como garantir que o teste volte a ser executado?

---

## Pergunta 26 — `dependency:tree`

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como descobrir quais dependências estão sendo utilizadas por um projeto Maven?

**O que essa pergunta avalia:**  
Avalia a capacidade de investigar dependências diretas, transitivas e conflitos de versão.

**Resposta esperada:**  
Pode-se utilizar o goal `dependency:tree`:

~~~bash
mvn dependency:tree
~~~

Ele exibe a árvore de dependências do projeto, incluindo dependências diretas, transitivas e versões selecionadas.

**Explicação didática:**  
A saída ajuda a entender de onde uma biblioteca foi incluída e a identificar versões concorrentes.

Por exemplo, duas bibliotecas podem exigir versões diferentes de uma mesma dependência. A árvore ajuda a investigar qual versão foi escolhida e por qual caminho.

**Exemplo prático:**  
Investigar a origem de uma biblioteca de logging inesperada ou de uma versão antiga de uma API.

**Como o candidato deve responder:**  

- Cite o comando;
- Explique dependências diretas e transitivas;
- Mencione conflitos de versão;
- Não recomende procurar manualmente apenas na pasta `.m2`.

**Resposta fraca ou incompleta:**  
“Eu abriria a pasta `.m2` e procuraria os arquivos JAR.”

Essa abordagem não mostra o relacionamento entre as dependências.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como identificar qual dependência introduziu um artefato?
2. Como limitar a saída da árvore?
3. Como resolver duas versões concorrentes?

---

## Pergunta 27 — Conflito de versões

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O que pode acontecer quando duas dependências trazem versões diferentes da mesma biblioteca?

**O que essa pergunta avalia:**  
Avalia o entendimento inicial sobre resolução de conflitos e incompatibilidades.

**Resposta esperada:**  
O Maven aplica regras de mediação para escolher uma versão. Uma regra comum é a preferência pela dependência mais próxima no grafo. Quando há empate, a ordem de declaração pode influenciar.

A versão escolhida pode não ser compatível com todas as bibliotecas que a utilizam.

**Explicação didática:**  
A aplicação pode compilar e falhar em runtime com erros como:

- `NoSuchMethodError`;
- `ClassNotFoundException`;
- `NoClassDefFoundError`;
- Comportamentos inesperados.

**Exemplo prático:**  
Uma biblioteca A exige a versão 1 de uma API, enquanto uma biblioteca B exige a versão 2. O projeto precisa verificar se a versão selecionada é compatível com ambas.

**Como o candidato deve responder:**  

- Explique que o Maven precisa escolher uma versão;
- Mencione `dependency:tree`;
- Cite a possibilidade de declarar uma versão explícita;
- Explique que forçar uma versão também pode trazer riscos.

**Resposta fraca ou incompleta:**  
“O Maven sempre escolhe a versão mais nova.”

Essa não é uma regra geral confiável.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como verificar qual versão foi selecionada?
2. Quando utilizar uma exclusão transitiva?
3. Qual o risco de forçar uma versão manualmente?

---

## Pergunta 28 — Exclusão de dependência transitiva

**Nível:** Júnior  
**Categoria:** Dependências

**Pergunta do entrevistador:**  
Como excluir uma dependência transitiva indesejada?

**O que essa pergunta avalia:**  
Avalia a capacidade de controlar o grafo de dependências.

**Resposta esperada:**  
A dependência pode ser excluída dentro da dependência que a introduziu, usando o elemento `<exclusions>`.

**Exemplo de código:**

~~~xml
<dependency>
    <groupId>com.exemplo</groupId>
    <artifactId>cliente-api</artifactId>
    <version>1.0.0</version>

    <exclusions>
        <exclusion>
            <groupId>org.exemplo</groupId>
            <artifactId>biblioteca-antiga</artifactId>
        </exclusion>
    </exclusions>
</dependency>
~~~

**Explicação didática:**  
A exclusão deve ser feita somente quando o desenvolvedor entende:

- Por que a dependência entrou;
- Se outra dependência fornecerá a alternativa;
- Se o projeto continuará funcionando;
- Se haverá impacto em runtime.

**Exemplo prático:**  
Excluir uma implementação antiga de logging trazida por uma biblioteca e declarar explicitamente a implementação aprovada pela organização.

**Como o candidato deve responder:**  

- Mostre a estrutura de `<exclusions>`;
- Identifique a dependência que introduziu o artefato;
- Explique os riscos;
- Recomende validar com testes.

**Resposta fraca ou incompleta:**  
“Basta apagar o JAR da pasta `.m2`.”

Isso não corrige o POM e pode afetar outros projetos da máquina.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como descobrir qual dependência introduziu o artefato?
2. Quando uma exclusão pode ser perigosa?
3. Como validar que a aplicação continua funcionando?

---

## Pergunta 29 — Versões `SNAPSHOT`

**Nível:** Júnior  
**Categoria:** Versionamento

**Pergunta do entrevistador:**  
O que significa uma versão terminada em `-SNAPSHOT`?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre versões em desenvolvimento e artefatos mutáveis.

**Resposta esperada:**  
Uma versão `SNAPSHOT` representa uma versão em desenvolvimento, que ainda não deve ser considerada uma release final imutável.

Por exemplo:

`1.2.0-SNAPSHOT`

pode ser atualizada enquanto o desenvolvimento continua.

**Explicação didática:**  
Uma versão final como `1.2.0` normalmente representa um artefato estável. Já uma versão `SNAPSHOT` pode mudar sem alterar suas coordenadas.

Por isso, o Maven pode verificar atualizações conforme as políticas configuradas.

**Exemplo prático:**  
Uma equipe pode utilizar `2.0.0-SNAPSHOT` durante o desenvolvimento e publicar `2.0.0` quando a versão estiver pronta.

**Como o candidato deve responder:**  

- Diferencie snapshot de release;
- Explique que snapshots podem ser atualizados;
- Mencione riscos em produção;
- Não diga que `SNAPSHOT` significa apenas “versão mais rápida”.

**Resposta fraca ou incompleta:**  
“SNAPSHOT é uma versão menor ou mais rápida.”

O conceito está relacionado a desenvolvimento e mutabilidade do artefato.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que evitar snapshots em produção?
2. Como controlar atualizações de snapshots?
3. Quando uma versão deve se tornar uma release?

---

## Pergunta 30 — Repositório local

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Qual é a função do repositório local do Maven?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre cache, dependências locais e instalação de artefatos.

**Resposta esperada:**  
O repositório local armazena dependências baixadas, metadados e artefatos instalados localmente.

Ele permite:

- Reutilizar dependências sem baixá-las novamente;
- Trabalhar offline quando todos os artefatos necessários estiverem disponíveis;
- Consumir bibliotecas construídas localmente com `mvn install`.

**Explicação didática:**  
O local mais comum é:

`~/.m2/repository`

A localização pode ser alterada por configuração.

**Exemplo prático:**  
Depois de executar `mvn install` em uma biblioteca local, outro projeto na mesma máquina pode utilizá-la como dependência.

**Como o candidato deve responder:**  

- Explique o papel de cache;
- Mencione o diretório padrão;
- Explique a relação com `install`;
- Não diga que o repositório local armazena apenas código-fonte.

**Resposta fraca ou incompleta:**  
“É onde o Maven guarda os arquivos Java do projeto.”

O repositório local armazena principalmente artefatos, dependências e metadados.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que o comando `install` grava localmente?
2. Quando seria razoável limpar parte do repositório local?
3. Qual o risco de apagar todo o repositório indiscriminadamente?

---

## Pergunta 31 — Fluxo de construção

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Descreva o fluxo típico de construção de um projeto Maven.

**O que essa pergunta avalia:**  
Avalia a capacidade de conectar ciclo de vida, dependências, plugins e artefatos.

**Resposta esperada:**  
Um fluxo típico inclui:

1. Leitura e validação do POM;
2. Resolução das dependências;
3. Processamento dos recursos;
4. Compilação do código;
5. Compilação e execução dos testes;
6. Empacotamento;
7. Verificações adicionais;
8. Instalação ou publicação do artefato, conforme o comando.

**Explicação didática:**

~~~mermaid
flowchart LR
    A[POM] --> B[Resolver dependências]
    B --> C[Processar recursos]
    C --> D[Compilar]
    D --> E[Executar testes]
    E --> F[Empacotar]
    F --> G{Destino}
    G --> H[Repositório local]
    G --> I[Repositório remoto]
~~~

Cada fase possui responsabilidades específicas e pode ser implementada por plugins diferentes.

**Exemplo prático:**

~~~bash
mvn clean verify
~~~

Esse comando é comum para validar um projeto sem necessariamente publicar o artefato em um repositório remoto.

**Como o candidato deve responder:**  

- Explique as etapas em ordem;
- Relacione plugins às atividades;
- Diferencie artefato local e remoto;
- Mencione que falhas podem interromper o fluxo.

**Resposta fraca ou incompleta:**  
“O Maven baixa dependências e executa o programa.”

A resposta omite compilação, testes, empacotamento e publicação.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Em que momento o Maven consulta repositórios?
2. Qual fase pode ser usada para validação em CI?
3. O que pode interromper o fluxo?

---

## Pergunta 32 — Maven Wrapper

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
O que é o Maven Wrapper e por que ele pode ser útil?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre padronização da versão do Maven usada pelo projeto.

**Resposta esperada:**  
O Maven Wrapper permite que o projeto utilize uma versão específica do Maven, mesmo que ela não esteja instalada globalmente ou seja diferente da versão padrão da máquina.

Arquivos comuns incluem:

- `mvnw`;
- `mvnw.cmd`;
- Arquivos de configuração da versão do Maven Wrapper.

**Explicação didática:**  
O Wrapper reduz diferenças entre computadores de desenvolvedores e ambientes de CI.

Ele controla a versão do Maven, mas não substitui nem fixa automaticamente a versão do JDK.

**Exemplo prático:**

~~~bash
./mvnw clean verify
~~~

A equipe pode usar esse comando para executar o Maven na versão definida pelo projeto.

**Como o candidato deve responder:**  

- Explique reprodutibilidade;
- Diferencie Maven Wrapper de JDK;
- Mencione seu uso em CI;
- Explique que os arquivos relevantes devem ser versionados.

**Resposta fraca ou incompleta:**  
“O Wrapper garante que todos usem a mesma versão do Java.”

Ele controla a versão do Maven, não a versão do JDK.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O Wrapper garante a mesma versão do Java?
2. Por que ele é útil em pipelines?
3. Quais arquivos devem ser versionados?

---

## Pergunta 33 — Maven e Gradle

**Nível:** Júnior  
**Categoria:** Comparação

**Pergunta do entrevistador:**  
Quais são as principais diferenças gerais entre Maven e Gradle?

**O que essa pergunta avalia:**  
Avalia a capacidade de comparar ferramentas sem respostas dogmáticas.

**Resposta esperada:**  
Maven utiliza principalmente XML e convenções fortes para declarar o build. Gradle utiliza DSLs, como Groovy ou Kotlin, oferecendo maior flexibilidade para customizações.

Ambos podem:

- Gerenciar dependências;
- Compilar código;
- Executar testes;
- Empacotar aplicações;
- Integrar-se a pipelines.

**Explicação didática:**  
Maven tende a oferecer maior padronização e previsibilidade para projetos convencionais. Gradle pode facilitar builds complexos e customizados, mas pode exigir mais conhecimento da DSL e resultar em configurações mais programáticas.

A escolha depende do contexto da equipe, do ecossistema, da complexidade do build e dos requisitos de manutenção.

**Exemplo prático:**  
Uma organização com muitos projetos padronizados pode preferir Maven. Um build com muitas regras customizadas pode se beneficiar do Gradle.

**Como o candidato deve responder:**  

- Compare formato de configuração;
- Mencione padronização e flexibilidade;
- Fale de curva de aprendizado;
- Evite afirmar que uma ferramenta é sempre superior.

**Resposta fraca ou incompleta:**  
“Gradle é sempre melhor porque é mais moderno.”

A escolha deve considerar contexto, equipe e requisitos.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que uma equipe manteria Maven?
2. Em que situação a flexibilidade pode virar complexidade?
3. Quais critérios você usaria para decidir uma migração?

---

## Pergunta 34 — POM mínimo

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Quais elementos mínimos você espera encontrar em um POM básico?

**O que essa pergunta avalia:**  
Avalia a capacidade de reconhecer a estrutura mínima de um POM.

**Resposta esperada:**  
Um POM básico normalmente contém:

- Elemento raiz `<project>`;
- `modelVersion`;
- `groupId`;
- `artifactId`;
- `version`.

Também pode conter `packaging`, dependências, propriedades e plugins conforme a necessidade.

**Exemplo de código:**

~~~xml
<project>
    <modelVersion>4.0.0</modelVersion>

    <groupId>br.com.exemplo</groupId>
    <artifactId>minha-aplicacao</artifactId>
    <version>1.0.0</version>
</project>
~~~

**Explicação didática:**  
Esses elementos identificam o projeto e permitem que o Maven compreenda sua estrutura básica.

Um POM mínimo pode não ser suficiente para um projeto de produção, pois talvez ainda faltem configuração do Java, testes, dependências e plugins.

**Como o candidato deve responder:**  

- Liste os elementos;
- Explique a finalidade de cada um;
- Diferencie estrutura mínima de configuração completa;
- Não diga que somente dependências são necessárias.

**Resposta fraca ou incompleta:**  
“Um POM precisa apenas das dependências.”

A identidade do projeto também precisa ser declarada.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que é `modelVersion`?
2. Qual campo identifica a organização?
3. O que pode ser omitido por ter um valor padrão?

---

## Pergunta 35 — XML no POM

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Por que o Maven utiliza XML no arquivo `pom.xml`?

**O que essa pergunta avalia:**  
Avalia a compreensão da natureza declarativa e hierárquica do POM.

**Resposta esperada:**  
O XML permite representar configurações hierárquicas de maneira estruturada e declarativa. Isso facilita a definição de dependências, plugins, propriedades e outras configurações.

Como desvantagem, POMs muito grandes podem se tornar verbosos e difíceis de manter.

**Explicação didática:**  
No XML, o desenvolvedor descreve o projeto e suas necessidades. A execução das tarefas é realizada pelo Maven e pelos plugins.

A configuração declarativa pode ser mais previsível, enquanto abordagens programáticas podem oferecer maior flexibilidade.

**Exemplo prático:**  
As dependências são representadas em uma estrutura hierárquica com grupo, nome, versão e escopo.

**Como o candidato deve responder:**  

- Explique a natureza declarativa;
- Mencione a estrutura hierárquica;
- Apresente vantagens e limitações;
- Não diga que XML é a linguagem de programação Java.

**Resposta fraca ou incompleta:**  
“XML é usado porque é a linguagem do Java.”

XML não é a linguagem de programação Java; ele é utilizado como formato de configuração do Maven.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que vantagem uma configuração declarativa oferece?
2. Que problemas um POM muito extenso pode causar?
3. Como melhorar a organização de um POM?

---

## Pergunta 36 — Dependência direta e transitiva

**Nível:** Júnior  
**Categoria:** Dependências

**Pergunta do entrevistador:**  
Qual é a diferença entre uma dependência direta e uma dependência transitiva?

**O que essa pergunta avalia:**  
Avalia a capacidade de distinguir dependências declaradas explicitamente das incluídas indiretamente.

**Resposta esperada:**  
Uma dependência direta é declarada explicitamente pelo projeto no seu `pom.xml`.

Uma dependência transitiva é trazida por outra dependência direta.

**Explicação didática:**  
Se o projeto declara A e A depende de B, então A é direta e B é transitiva.

Quando o código usa diretamente uma biblioteca, é recomendável declará-la explicitamente, mesmo que ela também seja trazida transitivamente.

**Exemplo prático:**  
Se o código importa diretamente uma biblioteca JSON, essa biblioteca deve estar declarada no POM, em vez de depender apenas de um framework que a traz indiretamente.

**Como o candidato deve responder:**  

- Defina os dois conceitos;
- Dê um exemplo de cadeia;
- Explique por que dependências usadas diretamente devem ser explícitas;
- Mencione riscos de depender de transitivas.

**Resposta fraca ou incompleta:**  
“Dependência direta é obrigatória e transitiva é opcional.”

A diferença está na origem da inclusão, não necessariamente na obrigatoriedade.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que declarar diretamente uma biblioteca usada pelo código?
2. Como identificar dependências não utilizadas?
3. O que pode acontecer se uma dependência transitiva deixar de existir?

---

## Pergunta 37 — Dependência opcional

**Nível:** Júnior  
**Categoria:** Dependências

**Pergunta do entrevistador:**  
O que significa marcar uma dependência Maven como opcional?

**O que essa pergunta avalia:**  
Avalia o conhecimento básico sobre a propagação de dependências para consumidores.

**Resposta esperada:**  
Uma dependência opcional é utilizada pelo próprio projeto, mas não é propagada automaticamente para projetos consumidores.

Se outro projeto precisar dela, deverá declará-la explicitamente.

**Explicação didática:**  
Imagine uma biblioteca que oferece integração opcional com um banco de dados específico. A biblioteca pode usar essa dependência, mas não quer obrigar todos os seus consumidores a recebê-la.

**Exemplo prático:**  
Uma biblioteca pode oferecer suporte opcional a uma tecnologia de mensageria. Apenas os consumidores que utilizarem essa integração declaram a dependência correspondente.

**Como o candidato deve responder:**  

- Explique quem utiliza a dependência;
- Explique que ela não é propagada automaticamente;
- Diferencie `optional` de `provided`;
- Dê um caso de uso.

**Resposta fraca ou incompleta:**  
“Optional significa que o projeto não usa a dependência.”

Ela pode ser usada pelo projeto que a declara, mas não ser propagada aos consumidores.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quem deve declarar a dependência opcional?
2. Em que situação esse recurso é útil?
3. Que documentação deve acompanhar essa escolha?

---

## Pergunta 38 — Escopo `provided`

**Nível:** Júnior  
**Categoria:** Dependências

**Pergunta do entrevistador:**  
Apresente um exemplo em que o escopo `provided` seja adequado.

**O que essa pergunta avalia:**  
Avalia a aplicação prática dos escopos de dependência.

**Resposta esperada:**  
O escopo `provided` é adequado quando a dependência é necessária para compilar e testar o projeto, mas será fornecida pelo ambiente de execução.

Um exemplo tradicional é uma API fornecida por um servidor de aplicações.

**Explicação didática:**  
Se o servidor fornece a biblioteca, empacotá-la novamente pode causar duplicidade ou conflitos de versões.

Por outro lado, se o ambiente não fornecer a dependência, a aplicação poderá falhar em runtime.

**Exemplo prático:**  
Uma aplicação web tradicional pode declarar uma API do servidor como `provided`.

**Como o candidato deve responder:**  

- Explique compilação;
- Explique a responsabilidade do ambiente;
- Mencione o risco caso o ambiente não forneça a biblioteca;
- Diferencie de `test`.

**Resposta fraca ou incompleta:**  
“Uso `provided` para dependências que não quero instalar.”

O objetivo não é evitar instalação, mas indicar que o ambiente fornecerá a dependência.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que acontece se o servidor não fornecer a biblioteca?
2. Por que evitar duplicidade de dependências?
3. Como testar localmente uma aplicação com dependências `provided`?

---

## Pergunta 39 — Profiles

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
O que é um profile Maven e quando ele pode ser utilizado?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre configurações condicionais de build.

**Resposta esperada:**  
Um profile é um conjunto de configurações que pode ser ativado conforme condições específicas, como:

- Propriedade;
- Ambiente;
- JDK;
- Sistema operacional;
- Ativação manual.

Ele permite adaptar o build a diferentes cenários.

**Exemplo de código:**

~~~xml
<profiles>
    <profile>
        <id>ci</id>

        <properties>
            <executar.verificacoes>true</executar.verificacoes>
        </properties>
    </profile>
</profiles>
~~~

**Explicação didática:**  
Um profile pode ativar verificações adicionais no CI ou habilitar configurações específicas para testes de integração.

Porém, muitos profiles podem tornar o comportamento do projeto difícil de prever.

**Como o candidato deve responder:**  

- Defina profile;
- Cite formas de ativação;
- Dê um exemplo;
- Mencione os riscos de diferenças ocultas entre ambientes.

**Resposta fraca ou incompleta:**  
“Profile é uma versão diferente do projeto.”

Profile é um conjunto condicional de configurações de build.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como ativar um profile manualmente?
2. Por que evitar diferenças ocultas entre ambientes?
3. Que configurações deveriam permanecer comuns?

---

## Pergunta 40 — Segredos em profiles

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Você utilizaria um profile Maven para armazenar senhas de produção? Por quê?

**O que essa pergunta avalia:**  
Avalia noções básicas de segurança e proteção de credenciais.

**Resposta esperada:**  
Não. O `pom.xml` pode ser versionado e lido por várias pessoas. Além disso, credenciais podem aparecer no histórico do controle de versão ou em logs.

As credenciais devem ser fornecidas por mecanismos apropriados, como:

- Variáveis protegidas da pipeline;
- Cofres de segredos;
- Configuração segura do ambiente;
- `settings.xml` protegido, quando adequado.

**Explicação didática:**  
Profiles servem para selecionar comportamentos de build, não para proteger segredos.

**Exemplo prático:**  
Um profile pode ativar uma publicação no CI, enquanto usuário e senha são fornecidos por variáveis protegidas.

**Como o candidato deve responder:**  

- Responda claramente que não;
- Explique o risco de versionar segredos;
- Mencione cofres ou variáveis protegidas;
- Fale sobre rotação e menor privilégio.

**Resposta fraca ou incompleta:**  
“Sim, desde que o nome do profile seja difícil de adivinhar.”

O nome do profile não oferece proteção para a senha.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde você armazenaria uma credencial de CI?
2. Como evitar que o segredo apareça nos logs?
3. O que faria se uma senha fosse publicada no Git?

---

## Pergunta 41 — POM pai

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
O que é um POM pai e por que ele pode ser utilizado?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre herança de configurações no Maven.

**Resposta esperada:**  
Um POM pai é um POM do qual outro projeto pode herdar configurações, como:

- Propriedades;
- Versões de plugins;
- Dependências gerenciadas;
- Configurações comuns;
- Informações de projeto.

**Explicação didática:**  
A herança reduz duplicação entre projetos relacionados. Uma organização pode criar um POM corporativo com a versão do Java, padrões de plugins e regras comuns.

**Exemplo prático:**  
Vários serviços de uma empresa podem herdar a configuração de compilação e de testes de um POM pai comum.

**Como o candidato deve responder:**  

- Explique herança;
- Cite configurações que podem ser compartilhadas;
- Diferencie herança de agregação;
- Mencione o risco de um POM pai muito complexo.

**Resposta fraca ou incompleta:**  
“POM pai é o POM executado primeiro.”

O conceito principal é o compartilhamento e a herança de configurações.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que configurações podem ser herdadas?
2. Qual a diferença entre parent e aggregator?
3. Como evitar um POM pai excessivamente complexo?

---

## Pergunta 42 — `dependencyManagement`

**Nível:** Júnior  
**Categoria:** Dependências

**Pergunta do entrevistador:**  
Qual é a finalidade do elemento `dependencyManagement`?

**O que essa pergunta avalia:**  
Avalia a capacidade de distinguir gerenciamento de versões da inclusão de dependências.

**Resposta esperada:**  
`dependencyManagement` define versões e configurações padrão para dependências que poderão ser utilizadas pelos módulos do projeto.

Ele não adiciona automaticamente todas as dependências ao classpath. O módulo ainda precisa declarar a dependência em `<dependencies>`.

**Explicação didática:**  
Essa separação permite centralizar versões sem obrigar todos os módulos a utilizarem todas as bibliotecas listadas.

**Exemplo prático:**

~~~xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.0</version>
        </dependency>
    </dependencies>
</dependencyManagement>
~~~

Um módulo consumidor ainda precisa declarar a dependência:

~~~xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
</dependency>
~~~

**Como o candidato deve responder:**  

- Explique centralização de versões;
- Diferencie de `<dependencies>`;
- Diga que não há inclusão automática;
- Relacione ao uso em projetos multimódulo.

**Resposta fraca ou incompleta:**  
“`dependencyManagement` adiciona todas as dependências do projeto.”

Esse comportamento está incorreto.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença para `<dependencies>`?
2. Por que centralizar versões?
3. Como isso ajuda em um projeto multimódulo?

---

## Pergunta 43 — BOM

**Nível:** Júnior  
**Categoria:** Dependências

**Pergunta do entrevistador:**  
O que é um BOM e para que ele serve no Maven?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre alinhamento de versões compatíveis.

**Resposta esperada:**  
BOM significa **Bill of Materials**. É um POM que centraliza versões de um conjunto de dependências que foram testadas ou planejadas para funcionar em conjunto.

Ele normalmente é importado dentro de `dependencyManagement`.

**Explicação didática:**  
Em vez de escolher manualmente uma versão para cada biblioteca, o projeto importa um conjunto de versões gerenciadas.

O BOM não significa necessariamente que todas as dependências serão adicionadas ao projeto automaticamente. Ele geralmente fornece versões para dependências que o projeto declarar.

**Exemplo prático:**  
Um framework pode publicar um BOM contendo versões compatíveis de módulos, bibliotecas de logging e componentes auxiliares.

**Como o candidato deve responder:**  

- Explique o significado de BOM;
- Mencione alinhamento de versões;
- Relacione a `dependencyManagement`;
- Explique que ele não adiciona automaticamente todas as bibliotecas.

**Resposta fraca ou incompleta:**  
“BOM é um arquivo que executa o build.”

BOM é principalmente uma forma de gerenciar versões compatíveis.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde um BOM costuma ser importado?
2. Ele adiciona automaticamente todas as dependências?
3. Quais riscos existem ao misturar BOMs incompatíveis?

---

## Pergunta 44 — Projeto multimódulo

**Nível:** Júnior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
O que é um projeto multimódulo Maven e quando ele pode ser útil?

**O que essa pergunta avalia:**  
Avalia o entendimento básico sobre organização de projetos com vários módulos.

**Resposta esperada:**  
Um projeto multimódulo é composto por vários projetos Maven relacionados, normalmente coordenados por um POM agregador.

Cada módulo pode ter:

- Seu próprio POM;
- Seu próprio código;
- Suas próprias dependências;
- Seu próprio artefato.

**Explicação didática:**  
O projeto multimódulo permite separar responsabilidades e construir componentes relacionados em conjunto.

**Exemplo prático:**  
Um sistema pode conter os módulos:

- `api`;
- `domain`;
- `infra`;
- `application`.

**Exemplo de código:**

~~~mermaid
flowchart TD
    A[POM agregador] --> B[Módulo API]
    A --> C[Módulo Domain]
    A --> D[Módulo Infra]
    A --> E[Módulo Application]
    E --> B
    E --> C
    E --> D
~~~

**Como o candidato deve responder:**  

- Explique o conceito de módulos;
- Mencione POM agregador;
- Explique dependências entre módulos;
- Cite vantagens e possíveis desvantagens.

**Resposta fraca ou incompleta:**  
“É um projeto com muitos pacotes.”

Módulos são projetos Maven com POMs e, normalmente, artefatos próprios.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual é a função do POM pai?
2. Como um módulo declara dependência de outro?
3. Quais são as vantagens e desvantagens de dividir o projeto em módulos?

---

## Pergunta 45 — Reator Maven

**Nível:** Júnior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
O que é o reator Maven em um projeto multimódulo?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre construção coordenada de vários módulos.

**Resposta esperada:**  
O reator é o mecanismo usado pelo Maven para construir vários projetos relacionados em uma mesma execução, respeitando as dependências e a ordem necessária.

Se o módulo B depende do módulo A, o Maven deve construir A antes de B.

**Explicação didática:**  
O reator analisa os módulos envolvidos e determina uma ordem de construção baseada em suas relações.

Isso permite executar um comando na raiz do projeto e construir vários artefatos relacionados.

**Exemplo prático:**

~~~bash
mvn clean install
~~~

Executado na raiz de um projeto multimódulo, esse comando pode construir e instalar os módulos na ordem apropriada.

**Como o candidato deve responder:**  

- Explique construção coordenada;
- Mencione ordem de dependência;
- Explique que o reator não é um servidor;
- Relacione à execução a partir da raiz.

**Resposta fraca ou incompleta:**  
“Reator é o servidor que executa o Maven.”

O reator é um mecanismo de construção multimódulo, não um servidor.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como o Maven define a ordem dos módulos?
2. Como construir apenas um módulo específico?
3. O que pode ocorrer se houver uma dependência circular?

---

## Pergunta 46 — Elemento `modules`

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
Como os módulos são declarados em um POM agregador?

**O que essa pergunta avalia:**  
Avalia a capacidade de configurar a agregação de módulos.

**Resposta esperada:**  
Os módulos são declarados no elemento `<modules>`, normalmente em um POM com `packaging` `pom`.

**Exemplo de código:**

~~~xml
<project>
    <modelVersion>4.0.0</modelVersion>

    <groupId>br.com.exemplo</groupId>
    <artifactId>sistema</artifactId>
    <version>1.0.0</version>
    <packaging>pom</packaging>

    <modules>
        <module>api</module>
        <module>core</module>
        <module>application</module>
    </modules>
</project>
~~~

**Explicação didática:**  
Cada entrada aponta para um diretório que contém outro `pom.xml`.

Declarar um módulo no elemento `<modules>` não significa automaticamente que ele será dependência dos demais. A relação de dependência também precisa ser declarada quando existir.

**Como o candidato deve responder:**  

- Mostre o elemento `<modules>`;
- Explique o `packaging` `pom`;
- Explique que os módulos são diretórios com POMs;
- Diferencie agregação de dependência.

**Resposta fraca ou incompleta:**  
“Basta listar os nomes das classes.”

Módulos são projetos Maven, não classes Java.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual packaging é comum no POM agregador?
2. Como um módulo declara dependência de outro?
3. O que acontece se o caminho de um módulo estiver errado?

---

## Pergunta 47 — Ordem de construção dos módulos

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Um projeto multimódulo Maven parece estar construindo os módulos na ordem errada. O que você investigaria?

**O que essa pergunta avalia:**  
Avalia a capacidade de diagnosticar configurações de dependências entre módulos.

**Resposta esperada:**  
Eu verificaria:

- Se os módulos estão declarados corretamente;
- Se a dependência entre eles está no POM;
- Se as coordenadas coincidem;
- Se as versões são compatíveis;
- Se existe dependência circular;
- Se a execução está sendo feita a partir do POM correto.

**Explicação didática:**  
A ordem deve ser determinada pelas relações de dependência. A simples ordem visual no elemento `<modules>` não substitui a declaração de dependência.

**Exemplo prático:**  
Se `application` utiliza classes de `core`, deve declarar `core` como dependência. O Maven então construirá `core` antes de `application`.

**Como o candidato deve responder:**  

- Comece verificando o erro completo;
- Analise os POMs;
- Confirme as coordenadas;
- Procure dependências circulares;
- Não recomende apenas mover linhas de lugar sem investigar.

**Resposta fraca ou incompleta:**  
“Eu moveria o módulo para cima na lista.”

Isso pode não resolver a causa real.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como identificar uma dependência circular?
2. Como o `dependency:tree` pode ajudar?
3. Como reproduzir o problema de forma controlada?

---

## Pergunta 48 — Artefato Maven

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é um artefato Maven?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre produtos gerados ou consumidos pelo Maven.

**Resposta esperada:**  
Um artefato Maven é um arquivo ou conjunto de arquivos publicado com coordenadas Maven.

Exemplos incluem:

- JAR;
- WAR;
- POM;
- Arquivo de fontes;
- Documentação;
- Artefatos adicionais com classifier.

**Explicação didática:**  
Um artefato é identificado principalmente por suas coordenadas, como:

`groupId`, `artifactId`, `version`, packaging e, quando aplicável, classifier.

**Exemplo prático:**  
O arquivo:

`cliente-api-1.0.0.jar`

pode ser o artefato principal de uma biblioteca Java.

**Como o candidato deve responder:**  

- Defina artefato;
- Dê exemplos;
- Relacione o artefato ao POM e ao repositório;
- Diferencie artefato de código-fonte puro.

**Resposta fraca ou incompleta:**  
“Artefato é somente o código-fonte.”

Artefatos podem ser pacotes compilados, POMs, fontes, documentação e outras variantes publicadas.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde o artefato é gerado?
2. Onde ele pode ser publicado?
3. O que é um classifier?

---

## Pergunta 49 — Classifier

**Nível:** Júnior  
**Categoria:** Empacotamento

**Pergunta do entrevistador:**  
Para que serve um classifier em um artefato Maven?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre artefatos adicionais associados à mesma versão.

**Resposta esperada:**  
O classifier diferencia artefatos adicionais que compartilham as mesmas coordenadas básicas.

Exemplos:

- `sources`;
- `javadoc`;
- Uma variante específica de plataforma;
- Um pacote adicional gerado pelo build.

**Explicação didática:**  
O classifier permite publicar mais de um arquivo relacionado ao mesmo `groupId`, `artifactId` e `version`.

Ele não substitui a versão nem altera o `artifactId`.

**Exemplo prático:**  
Uma biblioteca pode publicar:

- `biblioteca-1.0.0.jar`;
- `biblioteca-1.0.0-sources.jar`;
- `biblioteca-1.0.0-javadoc.jar`.

**Como o candidato deve responder:**  

- Explique que ele diferencia artefatos associados;
- Dê o exemplo `sources`;
- Diferencie classifier de versão;
- Explique que nem todo projeto precisa usá-lo diretamente.

**Resposta fraca ou incompleta:**  
“Classifier é outra versão da biblioteca.”

Ele identifica um artefato complementar ou variante, não uma nova versão principal.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Para que serve um artefato de fontes?
2. O classifier altera o `artifactId`?
3. Como consumir um artefato com classifier?

---

## Pergunta 50 — Falha ao resolver uma dependência

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O Maven informa que não consegue resolver uma dependência. Como você investigaria o problema?

**O que essa pergunta avalia:**  
Avalia o raciocínio sistemático para diagnosticar falhas de dependências e repositórios.

**Resposta esperada:**  
Eu seguiria uma investigação organizada:

1. Ler a mensagem completa do erro;
2. Conferir `groupId`, `artifactId` e `version`;
3. Verificar se o artefato realmente existe;
4. Conferir os repositórios configurados;
5. Avaliar conectividade, proxy e autenticação;
6. Verificar mirrors;
7. Conferir o repositório local;
8. Reproduzir com o mesmo comando;
9. Usar logs mais detalhados se necessário.

**Explicação didática:**  
A falha pode ter várias causas:

- Coordenada incorreta;
- Versão inexistente;
- Repositório indisponível;
- Credenciais inválidas;
- Proxy mal configurado;
- Artefato privado sem permissão;
- Metadados desatualizados;
- Problema de rede.

O diagnóstico deve começar pelas evidências, e não por tentativas aleatórias.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Erro ao resolver dependência] --> B[Conferir coordenadas]
    B --> C{Artefato existe?}
    C -->|Não| D[Corrigir versão ou coordenadas]
    C -->|Sim| E[Verificar repositório e rede]
    E --> F{Acesso autorizado?}
    F -->|Não| G[Corrigir credenciais ou permissões]
    F -->|Sim| H[Verificar cache e metadados]
    H --> I[Executar novamente e validar]
~~~

**Exemplo de código:**

~~~bash
mvn clean verify -U
~~~

A opção `-U` pode ser útil para solicitar nova verificação de atualizações, mas não resolve automaticamente todos os tipos de erro.

**Como o candidato deve responder:**  

- Organize a investigação em etapas;
- Comece pela mensagem de erro;
- Verifique configuração, rede, repositórios e cache;
- Mencione credenciais para dependências privadas;
- Não recomende apagar todo o repositório local sem diagnóstico;
- Explique que `-U` tem custo e finalidade específica.

**Resposta fraca ou incompleta:**  
“Eu executaria o comando várias vezes até funcionar.”

Repetir o comando não identifica a causa da falha.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como diferenciar um erro de rede de uma coordenada inválida?
2. Onde as credenciais de um repositório normalmente são configuradas?
3. Em que situação a opção `-U` pode ajudar?

---

## Pergunta 51 — Opção `-U`

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Para que serve a opção `-U` do Maven e em que situação você a utilizaria?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre atualização de dependências e snapshots.

**Resposta esperada:**  
A opção `-U` solicita que o Maven verifique novamente atualizações de releases e snapshots, respeitando as políticas configuradas nos repositórios.

**Explicação didática:**  
O Maven utiliza cache e metadados para evitar downloads desnecessários. Em alguns casos, uma nova versão de um snapshot pode não ser consultada imediatamente. A opção `-U` força uma nova verificação.

Ela não apaga todo o repositório local nem resolve problemas de coordenadas incorretas, autenticação ou indisponibilidade do servidor.

**Exemplo prático:**

~~~bash
mvn clean verify -U
~~~

Esse comando pode ser útil quando uma versão `SNAPSHOT` foi atualizada no repositório remoto.

**Exemplo de código:**  
O comando acima é suficiente para demonstrar o uso.

**Como o candidato deve responder:**  

- Explique que `-U` força a verificação de atualizações;
- Relacione a snapshots e metadados;
- Explique que a opção pode aumentar o tempo do build;
- Não diga que ela apaga o cache local.

**Resposta fraca ou incompleta:**  
“`-U` baixa novamente todas as dependências.”

A opção solicita nova verificação, mas não significa necessariamente que tudo será baixado novamente.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Em que situação `-U` é útil?
2. Qual impacto essa opção pode causar no tempo do build?
3. Por que ela não corrige uma coordenada inválida?

---

## Pergunta 52 — Arquivo `settings.xml`

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
Qual é a finalidade do arquivo `settings.xml`?

**O que essa pergunta avalia:**  
Avalia a distinção entre configurações do projeto e configurações do ambiente.

**Resposta esperada:**  
O `settings.xml` contém configurações específicas do usuário ou do ambiente Maven, como:

- Mirrors;
- Proxies;
- Credenciais de repositórios;
- Profiles externos;
- Configurações locais;
- Políticas de interação.

**Explicação didática:**  
O `pom.xml` descreve o projeto. Já o `settings.xml` é usado para configurações que podem variar entre máquinas ou que não devem ser colocadas no código do projeto.

Existem configurações globais e configurações específicas do usuário.

**Exemplo prático:**  
Uma empresa pode configurar um mirror corporativo e credenciais para um repositório privado no `settings.xml`.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Diferencie `settings.xml` e `pom.xml`;
- Cite repositórios, proxies e credenciais;
- Explique o cuidado com informações sensíveis;
- Não diga que o `settings.xml` substitui o POM.

**Resposta fraca ou incompleta:**  
“O `settings.xml` é uma cópia do `pom.xml`.”

Os arquivos possuem finalidades diferentes.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde normalmente ficam as configurações do usuário?
2. Por que credenciais não devem ficar no POM?
3. Em que situação um `settings.xml` corporativo é útil?

---

## Pergunta 53 — Mirror Maven

**Nível:** Júnior  
**Categoria:** Repositórios

**Pergunta do entrevistador:**  
O que é um mirror Maven e por que uma empresa pode utilizá-lo?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre intermediação e governança de repositórios.

**Resposta esperada:**  
Um mirror é um repositório configurado para substituir ou intermediar o acesso a outro repositório.

Uma empresa pode utilizá-lo para:

- Fazer cache de dependências;
- Controlar quais artefatos são permitidos;
- Reduzir dependência direta da internet;
- Auditar downloads;
- Melhorar desempenho;
- Aplicar políticas de segurança.

**Explicação didática:**  
Em vez de cada máquina acessar diretamente vários repositórios externos, os builds podem utilizar um repositório interno controlado pela organização.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[Projeto Maven] --> B[Mirror corporativo]
    B --> C[Repositório público]
    B --> D[Artefatos internos]
~~~

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique que o mirror intermedeia o acesso;
- Cite cache e segurança;
- Mencione o risco de indisponibilidade;
- Não confunda mirror com cópia do código-fonte.

**Resposta fraca ou incompleta:**  
“Mirror é uma cópia do projeto.”

No Maven, o termo está relacionado à configuração de repositórios.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que vantagens um mirror oferece?
2. O que acontece se o mirror ficar indisponível?
3. Como controlar artefatos não aprovados?

---

## Pergunta 54 — Execução offline

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Para que serve a opção `-o` ou `--offline`?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre execução sem acesso a repositórios remotos.

**Resposta esperada:**  
A opção instrui o Maven a não acessar repositórios remotos e utilizar somente os artefatos disponíveis no repositório local.

**Explicação didática:**  
O modo offline pode ser útil quando a máquina não possui acesso à internet ou quando se deseja verificar se o cache local é suficiente.

Se faltar uma dependência, um plugin ou um metadado necessário, o build falhará.

**Exemplo prático:**

~~~bash
mvn -o clean verify
~~~

**Exemplo de código:**  
O comando acima é suficiente para demonstrar a opção.

**Como o candidato deve responder:**  

- Explique que nenhum acesso remoto será feito;
- Mencione a dependência do cache local;
- Explique que a opção não corrige dependências ausentes;
- Não diga que o modo offline sempre acelera o build.

**Resposta fraca ou incompleta:**  
“`-o` permite executar o Maven sem instalar Java.”

A opção trata do acesso a repositórios, não da instalação do JDK.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que acontece se faltar uma dependência no cache?
2. Quando usar o modo offline?
3. Como preparar uma máquina para executar builds offline?

---

## Pergunta 55 — Logs detalhados

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Quais opções do Maven podem ajudar na análise de um erro de build?

**O que essa pergunta avalia:**  
Avalia a capacidade de utilizar informações de diagnóstico.

**Resposta esperada:**  
Algumas opções úteis são:

- `-e`: exibe exceções;
- `-X`: ativa logs de debug;
- `-q`: reduz a quantidade de saída;
- `-B` ou `--batch-mode`: executa sem interação.

**Explicação didática:**  
Logs detalhados podem ajudar a identificar o plugin, a fase e a causa da falha. Porém, logs de debug podem conter caminhos locais, parâmetros e informações que não devem ser publicados sem revisão.

**Exemplo prático:**

~~~bash
mvn -e test
~~~

**Exemplo de código:**  
O comando acima solicita informações adicionais sobre exceções.

**Como o candidato deve responder:**  

- Explique pelo menos duas opções;
- Diferencie diagnóstico de execução normal;
- Mencione o cuidado com dados sensíveis;
- Não recomende usar debug detalhado indiscriminadamente em todos os ambientes.

**Resposta fraca ou incompleta:**  
“Uso sempre `-X` para corrigir o erro.”

A opção apenas aumenta as informações disponíveis; ela não corrige automaticamente o problema.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando você usaria `-X`?
2. Qual o risco de compartilhar logs completos?
3. Qual opção exibe as exceções?

---

## Pergunta 56 — Primeira causa do erro

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Ao analisar um log Maven com várias mensagens de erro, como você identificaria a causa principal?

**O que essa pergunta avalia:**  
Avalia o método de leitura e investigação de logs.

**Resposta esperada:**  
Eu começaria pela primeira falha relevante, identificaria a fase e o plugin envolvidos e verificaria o contexto do erro. Mensagens posteriores podem ser apenas consequências da primeira falha.

**Explicação didática:**  
Um erro durante a compilação pode impedir o empacotamento e gerar várias mensagens secundárias. Corrigir a última mensagem nem sempre resolve o problema original.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Log completo] --> B[Localizar primeira falha]
    B --> C[Identificar fase]
    C --> D[Identificar plugin]
    D --> E[Reproduzir]
    E --> F[Corrigir causa]
    F --> G[Executar novamente]
~~~

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique a diferença entre causa e consequência;
- Mencione fase e plugin;
- Mostre que analisaria o log completo;
- Não se limite à última linha exibida.

**Resposta fraca ou incompleta:**  
“Eu corrigiria o último erro mostrado.”

A última mensagem pode ser apenas consequência de outra falha anterior.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como identificar o plugin envolvido?
2. Por que erros posteriores podem ser secundários?
3. Que informações você registraria para reproduzir o problema?

---

## Pergunta 57 — Build reprodutível

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
O que torna um build Maven reprodutível?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre consistência entre ambientes.

**Resposta esperada:**  
Um build reprodutível depende de configurações controladas, como:

- Versões fixas de dependências;
- Versões fixas de plugins;
- JDK definido;
- Maven conhecido;
- Configurações versionadas;
- Repositórios confiáveis;
- Testes automatizados;
- Ambiente de CI padronizado.

**Explicação didática:**  
Se o build depender da versão instalada na máquina, de uma configuração manual ou de uma dependência dinâmica, resultados diferentes podem ser obtidos em momentos distintos.

**Exemplo prático:**  
Usar Maven Wrapper, configurar a versão do Java no POM e executar o mesmo comando no CI.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Mencione versões e ambientes;
- Explique a importância do Wrapper;
- Cite dependências e plugins;
- Relacione o tema ao CI.

**Resposta fraca ou incompleta:**  
“Basta executar o mesmo comando em qualquer máquina.”

O ambiente e as versões também influenciam o resultado.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que fixar versões de plugins?
2. Como o Maven Wrapper ajuda?
3. Que diferenças de ambiente podem causar falhas?

---

## Pergunta 58 — Versões dinâmicas

**Nível:** Júnior  
**Categoria:** Manutenção

**Pergunta do entrevistador:**  
Por que utilizar versões dinâmicas de dependências pode ser problemático?

**O que essa pergunta avalia:**  
Avalia conhecimento sobre estabilidade e rastreabilidade.

**Resposta esperada:**  
Versões dinâmicas podem mudar entre execuções, dificultar a reprodução de falhas e introduzir incompatibilidades inesperadas.

**Explicação didática:**  
O build deve ser capaz de indicar exatamente quais versões foram utilizadas. Caso uma dependência seja atualizada automaticamente, o mesmo commit pode produzir resultados diferentes.

**Exemplo prático:**  
Uma configuração que aceita qualquer versão futura pode funcionar hoje e falhar depois de uma nova publicação.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique previsibilidade;
- Mencione rastreabilidade;
- Diferencie release fixa de snapshot;
- Cite situações excepcionais em que snapshots podem ser aceitáveis.

**Resposta fraca ou incompleta:**  
“Versões dinâmicas são sempre melhores porque permanecem atualizadas.”

Atualização automática pode aumentar o risco de incompatibilidades.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando um snapshot pode ser usado?
2. Como controlar atualizações?
3. Como investigar uma mudança inesperada no build?

---

## Pergunta 59 — Diretório `target`

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que normalmente fica no diretório `target`?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre resultados gerados pelo build.

**Resposta esperada:**  
O diretório `target` pode conter:

- Classes compiladas;
- Recursos processados;
- Classes de teste;
- Relatórios;
- Artefatos empacotados;
- Arquivos temporários do build.

**Explicação didática:**  
Esse diretório é produzido pelo Maven e pode ser recriado. Por isso, normalmente não deve ser versionado no controle de código.

**Exemplo prático:**  
Depois de executar `mvn package`, o JAR gerado geralmente estará em `target`.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Cite classes, relatórios e artefatos;
- Explique a relação com `clean`;
- Diga por que normalmente não deve ser versionado.

**Resposta fraca ou incompleta:**  
“É onde ficam as dependências do projeto.”

As dependências normalmente ficam no repositório local ou são incluídas no pacote conforme a configuração.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual comando remove normalmente o `target`?
2. Por que o diretório não deve ser versionado?
3. Que tipo de arquivo você espera encontrar após `package`?

---

## Pergunta 60 — Arquivos no controle de versão

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Quais arquivos de um projeto Maven normalmente devem ou não devem ser versionados?

**O que essa pergunta avalia:**  
Avalia práticas básicas de organização do projeto.

**Resposta esperada:**  
Normalmente devem ser versionados:

- Código-fonte;
- Testes;
- `pom.xml`;
- Maven Wrapper;
- Arquivos de configuração necessários;
- Arquivos de documentação.

Normalmente não devem ser versionados:

- `target/`;
- Arquivos temporários da IDE;
- Classes compiladas;
- Segredos;
- O repositório local `.m2`.

**Explicação didática:**  
Arquivos gerados podem ser recriados durante o build. Já o POM e o código são necessários para reproduzir o projeto.

**Exemplo prático:**

~~~text
target/
.idea/
*.iml
.classpath
.project
~~~

**Como o candidato deve responder:**  

- Explique a diferença entre fonte e artefato gerado;
- Mencione o POM;
- Cite o cuidado com segredos;
- Não recomende versionar o diretório `target`.

**Resposta fraca ou incompleta:**  
“Eu não versionaria o `pom.xml` porque ele é gerado.”

O POM é um dos principais arquivos do projeto e deve ser versionado.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O Maven Wrapper deve ser versionado?
2. Por que não versionar arquivos da IDE?
3. Como tratar um segredo que foi commitado?

---

## Pergunta 61 — Código de saída

**Nível:** Júnior  
**Categoria:** CI/CD

**Pergunta do entrevistador:**  
Por que o código de saída do Maven é importante em uma pipeline?

**O que essa pergunta avalia:**  
Avalia a integração entre Maven e ferramentas de automação.

**Resposta esperada:**  
O código de saída informa se o comando terminou com sucesso ou falha. Um valor diferente de zero normalmente indica falha e deve impedir etapas posteriores, como publicação de artefatos.

**Explicação didática:**  
A pipeline precisa interpretar corretamente o resultado do Maven. Não basta o comando produzir logs; é necessário respeitar o status de execução.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Executar Maven] --> B{Código de saída 0?}
    B -->|Não| C[Interromper pipeline]
    B -->|Sim| D[Continuar validações]
    D --> E[Publicar artefato]
~~~

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique sucesso e falha;
- Relacione a testes e publicação;
- Mencione o risco de ignorar o status;
- Não se limite a analisar visualmente os logs.

**Resposta fraca ou incompleta:**  
“O CI verifica apenas se apareceu a palavra `BUILD SUCCESS`.”

O código de saída é um sinal mais apropriado para automação.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que deve ocorrer quando um teste falha?
2. Como impedir a publicação de um artefato inválido?
3. Que risco existe ao ignorar erros do Maven?

---

## Pergunta 62 — Pipeline Maven simples

**Nível:** Júnior  
**Categoria:** CI/CD

**Pergunta do entrevistador:**  
Como você estruturaria uma pipeline simples para um projeto Maven?

**O que essa pergunta avalia:**  
Avalia a capacidade de aplicar Maven em automação.

**Resposta esperada:**  
Uma pipeline simples poderia:

1. Preparar o JDK;
2. Usar a versão esperada do Maven;
3. Restaurar ou utilizar cache de dependências;
4. Executar `clean verify`;
5. Publicar relatórios;
6. Publicar artefatos somente se o build for aprovado.

**Explicação didática:**  
A pipeline deve validar o projeto automaticamente e evitar que código não testado seja publicado.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[Preparar JDK e Maven] --> B[Restaurar cache]
    B --> C[Executar clean verify]
    C --> D{Build aprovado?}
    D -->|Não| E[Gerar diagnóstico]
    D -->|Sim| F[Publicar artefato]
~~~

**Exemplo de código:**

~~~bash
mvn --batch-mode clean verify
~~~

**Como o candidato deve responder:**  

- Fale sobre versões;
- Mencione testes e verificações;
- Explique o uso de cache;
- Relacione sucesso do build à publicação.

**Resposta fraca ou incompleta:**  
“Eu executaria somente `mvn package` e publicaria sempre.”

Essa abordagem pode permitir a publicação mesmo com falhas em testes ou verificações.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como acelerar a pipeline sem ignorar testes?
2. Que artefatos devem ser armazenados?
3. Como proteger credenciais durante a publicação?

---

## Pergunta 63 — Modo batch

**Nível:** Júnior  
**Categoria:** CI/CD

**Pergunta do entrevistador:**  
Para que serve a opção `--batch-mode`?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre execução do Maven em ambientes automatizados.

**Resposta esperada:**  
A opção `--batch-mode` executa o Maven sem depender de interação manual, sendo adequada para pipelines.

**Explicação didática:**  
Um servidor de CI não deve esperar que alguém responda a prompts durante o build. O modo batch torna a execução mais apropriada para automação.

**Exemplo prático:**

~~~bash
mvn --batch-mode test
~~~

**Exemplo de código:**  
O comando acima é suficiente para demonstrar o recurso.

**Como o candidato deve responder:**  

- Explique a ausência de interação;
- Relacione o recurso a CI/CD;
- Diferencie batch mode de paralelismo;
- Não diga que a opção acelera necessariamente o build.

**Resposta fraca ou incompleta:**  
“`--batch-mode` executa o Maven com várias threads.”

Essa opção trata de interação, não de paralelismo.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que prompts são inadequados em CI?
2. Batch mode altera o resultado funcional do build?
3. Que outras práticas ajudam na automação?

---

## Pergunta 64 — Cache de dependências

**Nível:** Júnior  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
Como o cache de dependências pode acelerar uma pipeline Maven?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre desempenho e reutilização do repositório local.

**Resposta esperada:**  
O cache permite reutilizar dependências e plugins já baixados, reduzindo downloads, tempo de rede e duração do build.

**Explicação didática:**  
A pipeline pode preservar o repositório local entre execuções. Porém, o cache precisa ser invalidado ou atualizado quando estiver corrompido ou incompatível.

**Exemplo prático:**  
Uma chave de cache pode considerar o sistema operacional, a versão do JDK e os arquivos que definem as dependências.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique a economia de rede;
- Mencione invalidação;
- Fale sobre cache obsoleto ou corrompido;
- Não trate cache como garantia de correção.

**Resposta fraca ou incompleta:**  
“Basta compartilhar o mesmo cache para todos os projetos.”

Caches compartilhados sem controle podem causar conflitos ou dificultar o diagnóstico.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando invalidar o cache?
2. Como investigar um cache corrompido?
3. Que informações devem compor a chave do cache?

---

## Pergunta 65 — Build lento

**Nível:** Júnior  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
Um build Maven ficou muito lento. Quais pontos você investigaria primeiro?

**O que essa pergunta avalia:**  
Avalia a capacidade de identificar gargalos antes de propor otimizações.

**Resposta esperada:**  
Eu verificaria:

- Tempo gasto em cada fase;
- Downloads repetidos;
- Testes lentos;
- Testes de integração;
- Plugins demorados;
- Análises de qualidade;
- Falta de cache;
- Recursos limitados da máquina;
- Execuções redundantes.

**Explicação didática:**  
A otimização deve começar por medição. Remover testes ou ativar paralelismo sem conhecer o gargalo pode piorar o problema ou reduzir a segurança.

**Exemplo prático:**  
Separar testes unitários rápidos de testes de integração demorados pode melhorar o feedback local.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Comece pela medição;
- Analise fases, plugins e testes;
- Considere cache e ambiente;
- Explique os trade-offs de cada otimização.

**Resposta fraca ou incompleta:**  
“Eu removeria os testes para acelerar.”

Isso reduz a confiança no build e não necessariamente resolve o gargalo.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como medir o tempo gasto por plugin?
2. Que tipos de teste costumam ser mais lentos?
3. Quando paralelismo pode piorar a situação?

---

## Pergunta 66 — Paralelismo com `-T`

**Nível:** Júnior  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
Quando a execução paralela de módulos Maven pode ajudar e quando pode atrapalhar?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre paralelismo e limitações de recursos.

**Resposta esperada:**  
O paralelismo pode ajudar quando existem módulos independentes e recursos suficientes de CPU, memória, disco e rede.

Pode atrapalhar quando:

- Há contenção de recursos;
- Testes compartilham estado;
- Serviços externos são limitados;
- O computador possui pouca memória;
- A execução paralela gera instabilidade.

**Explicação didática:**  
Mais threads não significam necessariamente um build mais rápido. A melhoria deve ser medida e validada.

**Exemplo de código:**

~~~bash
mvn -T 1C verify
~~~

A opção `-T` permite solicitar execução paralela, mas a quantidade adequada depende do ambiente.

**Como o candidato deve responder:**  

- Explique benefícios;
- Mencione contenção;
- Fale sobre testes que compartilham recursos;
- Recomende medir antes e depois.

**Resposta fraca ou incompleta:**  
“Quanto mais threads, melhor.”

Paralelismo excessivo pode saturar recursos e aumentar o tempo total.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que recursos podem virar gargalo?
2. Como verificar se os testes são seguros para execução paralela?
3. Como comparar o tempo antes e depois da mudança?

---

## Pergunta 67 — Versões de plugins

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Por que é recomendável definir explicitamente as versões dos plugins Maven?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre previsibilidade e manutenção do build.

**Resposta esperada:**  
Porque plugins também possuem versões, mudanças de comportamento, correções e incompatibilidades. Fixar suas versões reduz variações inesperadas entre builds.

**Explicação didática:**  
Mesmo que o projeto não altere seu código, uma mudança implícita no plugin pode alterar compilação, testes, empacotamento ou relatórios.

**Exemplo prático:**  
Fixar a versão do Compiler Plugin ajuda a manter o mesmo comportamento de compilação no computador do desenvolvedor e no CI.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Relacione plugins à reprodutibilidade;
- Mencione bugs e compatibilidade;
- Explique que atualizações devem ser deliberadas;
- Não diga que o Maven sempre exige a versão explicitamente.

**Resposta fraca ou incompleta:**  
“Porque o Maven não funciona sem isso.”

O principal motivo é previsibilidade, não uma exigência universal.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como centralizar versões de plugins?
2. Como atualizar um plugin com segurança?
3. Que testes devem ser executados após a atualização?

---

## Pergunta 68 — Maven Clean Plugin

**Nível:** Júnior  
**Categoria:** Plugins

**Pergunta do entrevistador:**  
Qual é a função do Maven Clean Plugin?

**O que essa pergunta avalia:**  
Avalia a relação entre plugins e fases do ciclo de vida.

**Resposta esperada:**  
O Maven Clean Plugin implementa tarefas relacionadas ao ciclo de vida `clean`, normalmente removendo resultados gerados pelo build, como o diretório `target`.

**Explicação didática:**  
A fase `clean` representa uma etapa do ciclo de vida. O plugin contém a lógica necessária para executar essa etapa.

**Exemplo prático:**

~~~bash
mvn clean
~~~

Esse comando normalmente remove os resultados gerados anteriormente.

**Exemplo de código:**  
O comando acima é suficiente.

**Como o candidato deve responder:**  

- Relacione plugin e fase;
- Cite o diretório `target`;
- Explique que o repositório local não é apagado;
- Não diga que o plugin corrige erros do código.

**Resposta fraca ou incompleta:**  
“Ele limpa o repositório remoto.”

A função principal está relacionada aos resultados locais do build.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual fase esse plugin implementa?
2. O repositório local é removido?
3. Quando executar `clean` antes de outra fase?

---

## Pergunta 69 — Maven Resources Plugin

**Nível:** Júnior  
**Categoria:** Plugins

**Pergunta do entrevistador:**  
Qual é a função geral do Maven Resources Plugin?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre processamento e cópia de recursos.

**Resposta esperada:**  
O plugin processa e copia recursos de produção e de testes para os diretórios de saída apropriados.

**Explicação didática:**  
Arquivos como configurações, templates e arquivos de propriedades precisam acompanhar a aplicação compilada.

Recursos principais geralmente vêm de `src/main/resources`, enquanto recursos de teste vêm de `src/test/resources`.

**Exemplo prático:**  
Um arquivo de configuração pode ser copiado para `target/classes`.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique origem e destino;
- Diferencie recursos de produção e teste;
- Mencione o risco de filtering incorreto;
- Não confunda processamento de recursos com compilação Java.

**Resposta fraca ou incompleta:**  
“Ele compila as classes Java.”

Essa é a responsabilidade principal do Compiler Plugin.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde ficam os recursos principais?
2. Qual a diferença entre recursos de produção e de teste?
3. Que risco o filtering pode causar?

---

## Pergunta 70 — Assembly Plugin

**Nível:** Júnior  
**Categoria:** Empacotamento

**Pergunta do entrevistador:**  
Para que pode ser utilizado o Maven Assembly Plugin?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre criação de distribuições personalizadas.

**Resposta esperada:**  
O Assembly Plugin pode criar pacotes customizados reunindo:

- Artefatos;
- Dependências;
- Scripts;
- Arquivos de configuração;
- Documentação;
- Outros arquivos necessários à distribuição.

**Explicação didática:**  
Ele é útil quando o JAR ou WAR padrão não representa sozinho o formato de distribuição necessário.

**Exemplo prático:**  
Gerar um arquivo ZIP contendo um JAR, scripts de inicialização e arquivos de configuração.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique a finalidade de uma distribuição;
- Dê um exemplo de ZIP;
- Diferencie Assembly de um JAR comum;
- Mencione que a configuração deve ser validada.

**Resposta fraca ou incompleta:**  
“Ele executa os testes de integração.”

Essa não é a finalidade principal do Assembly Plugin.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando usar Assembly em vez de Shade?
2. Que arquivos incluíria em uma distribuição?
3. Como testaria o pacote gerado?

---

## Pergunta 71 — JAR executável

**Nível:** Júnior  
**Categoria:** Empacotamento

**Pergunta do entrevistador:**  
Como um projeto Maven pode gerar um JAR executável?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre classe principal, manifesto e dependências.

**Resposta esperada:**  
É necessário configurar a classe principal no manifesto ou utilizar um plugin apropriado. Dependendo da aplicação, também será necessário incluir ou disponibilizar suas dependências no runtime.

**Explicação didática:**  
Um JAR comum pode conter classes compiladas, mas não necessariamente informa qual classe deve ser iniciada.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[Código Java] --> B[Compilação]
    B --> C[Empacotamento]
    C --> D[JAR com Main-Class]
    D --> E[Execução]
~~~

**Exemplo de código:**

~~~bash
java -jar aplicacao.jar
~~~

**Como o candidato deve responder:**  

- Mencione a classe principal;
- Explique o manifesto;
- Fale sobre dependências;
- Não diga que todo JAR é executável automaticamente.

**Resposta fraca ou incompleta:**  
“Todo arquivo JAR pode ser executado com `java -jar`.”

Isso depende de sua configuração.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que é `Main-Class`?
2. Como disponibilizar dependências no runtime?
3. Que riscos existem em empacotar todas as dependências no mesmo JAR?

---

## Pergunta 72 — Shade Plugin

**Nível:** Júnior  
**Categoria:** Empacotamento

**Pergunta do entrevistador:**  
Para que serve o Maven Shade Plugin?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre criação de JARs com dependências.

**Resposta esperada:**  
O Shade Plugin pode criar um JAR contendo o projeto e suas dependências. Também pode realizar transformações, como relocação de pacotes.

**Explicação didática:**  
A relocação altera os nomes de determinados pacotes para reduzir colisões entre bibliotecas. Porém, pode causar problemas em recursos que dependem de nomes de classes, reflexão ou configuração externa.

**Exemplo prático:**  
Gerar uma aplicação distribuível em um único JAR.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique o JAR com dependências;
- Defina relocação de forma simples;
- Mencione riscos;
- Não diga que Shade é obrigatório em qualquer projeto.

**Resposta fraca ou incompleta:**  
“Shade apenas renomeia o arquivo JAR.”

O plugin atua no empacotamento e nas dependências.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que é relocação de pacotes?
2. Como reflexão pode ser afetada?
3. Quando preferir manter dependências externas?

---

## Pergunta 73 — Funciona na IDE, mas não no JAR

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
A aplicação funciona na IDE, mas falha quando executada pelo JAR gerado. O que você investigaria?

**O que essa pergunta avalia:**  
Avalia a capacidade de comparar classpaths e ambientes.

**Resposta esperada:**  
Eu verificaria:

- Dependências incluídas no pacote;
- Escopos;
- Manifesto;
- Classe principal;
- Recursos;
- Versão do Java;
- Comando de execução;
- Diferenças entre classpath da IDE e do JAR.

**Explicação didática:**  
A IDE pode incluir dependências automaticamente, enquanto o artefato final pode não incluí-las. Também pode haver recursos disponíveis localmente, mas ausentes no pacote.

**Exemplo prático:**  
Um erro `ClassNotFoundException` pode indicar que uma dependência foi declarada com escopo inadequado ou não foi empacotada.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Compare os ambientes;
- Examine o artefato real;
- Verifique escopos e recursos;
- Não recomende apenas recompilar sem investigar.

**Resposta fraca ou incompleta:**  
“Eu executaria novamente até funcionar.”

Essa resposta não identifica a diferença entre os ambientes.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como inspecionar o conteúdo do JAR?
2. Que escopo de dependência você verificaria?
3. Como reproduzir o ambiente de produção?

---

## Pergunta 74 — Recurso ausente no pacote

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Um arquivo colocado em `src/main/resources` não aparece no pacote final. Como você investigaria?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre localização e processamento de recursos.

**Resposta esperada:**  
Eu verificaria:

- Se o arquivo está no diretório correto;
- Se a configuração de resources foi alterada;
- Se existem exclusões;
- Se o profile correto está ativo;
- Se o filtering está interferindo;
- Se o arquivo foi copiado para `target/classes`;
- Se está presente no artefato final.

**Explicação didática:**  
O arquivo pode estar em uma pasta incorreta, ser excluído por configuração ou ser alterado durante o processamento.

**Exemplo prático:**  
Um arquivo em `src/test/resources` não deve ser esperado no pacote de produção.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Investigue da origem até o pacote;
- Diferencie recursos de teste e produção;
- Considere exclusões e profiles;
- Não copie manualmente o arquivo para `target` como solução definitiva.

**Resposta fraca ou incompleta:**  
“Eu colocaria o arquivo diretamente dentro do JAR.”

Isso não corrige o processo de build.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual é o diretório padrão para recursos de produção?
2. Como verificar se o arquivo chegou a `target/classes`?
3. Que risco existe no filtering de recursos?

---

## Pergunta 75 — Encoding UTF-8

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
Por que definir explicitamente o encoding do projeto Maven é importante?

**O que essa pergunta avalia:**  
Avalia a prevenção de problemas com caracteres e diferenças entre ambientes.

**Resposta esperada:**  
Definir o encoding, geralmente UTF-8, evita que o código e os recursos sejam interpretados de forma diferente em diferentes sistemas operacionais ou ambientes de CI.

**Explicação didática:**  
Sem uma configuração explícita, o build pode depender do encoding padrão da máquina. Isso pode corromper acentos, símbolos e textos internacionalizados.

**Exemplo de código:**

~~~xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
~~~

**Como o candidato deve responder:**  

- Explique a dependência do ambiente;
- Cite caracteres acentuados;
- Mencione código e recursos;
- Não limite o problema ao banco de dados.

**Resposta fraca ou incompleta:**  
“Encoding só importa para arquivos de banco.”

Ele também influencia código-fonte, arquivos de propriedades, templates e outros recursos.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde configurar o encoding?
2. Como reproduzir um problema de caracteres?
3. Que arquivos devem ser analisados além do código Java?

---

## Pergunta 76 — Incompatibilidade de versão do Java

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O build informa que uma classe foi compilada para uma versão mais recente do Java. O que isso significa?

**O que essa pergunta avalia:**  
Avalia o diagnóstico de incompatibilidade de bytecode.

**Resposta esperada:**  
Significa que o runtime ou compilador utilizado é mais antigo que a versão usada para gerar a classe.

Eu verificaria:

- Versão do JDK;
- Configuração do Compiler Plugin;
- Propriedade `release`;
- Versão das dependências;
- JDK usado no CI;
- JDK usado em produção.

**Explicação didática:**  
O código compilado gera bytecode compatível com determinadas versões do Java. Uma versão mais antiga pode não conseguir executar bytecode produzido por uma versão mais nova.

**Exemplo prático:**  
Uma biblioteca compilada para Java 17 pode não funcionar em um ambiente que utilize Java 11.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Diferencie código-fonte de bytecode;
- Mencione alinhamento de JDK;
- Explique que a dependência também pode exigir uma versão mais nova;
- Não trate o problema como erro de sintaxe.

**Resposta fraca ou incompleta:**  
“É um erro causado por uma classe com nome errado.”

A mensagem indica incompatibilidade de versão do Java.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como verificar a versão do Java usada pelo Maven?
2. Qual a diferença entre `source`, `target` e `release`?
3. Como evitar diferenças entre desenvolvimento e CI?

---

## Pergunta 77 — Comando `mvn -version`

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como verificar qual versão do Maven e qual Java estão sendo utilizados?

**O que essa pergunta avalia:**  
Avalia a capacidade de diagnosticar diferenças no ambiente.

**Resposta esperada:**  
Pode-se utilizar:

~~~bash
mvn -version
~~~

O comando normalmente exibe:

- Versão do Maven;
- Versão do Java;
- Diretório do Java;
- Sistema operacional;
- Outras informações do ambiente.

**Explicação didática:**  
A versão usada pela IDE pode ser diferente da utilizada no terminal ou no CI. Por isso, a verificação deve ser feita no ambiente em que ocorre a falha.

**Como o candidato deve responder:**  

- Cite o comando;
- Explique que Maven e Java são informações diferentes;
- Relacione o resultado ao diagnóstico;
- Não verifique somente a versão exibida pela IDE.

**Resposta fraca ou incompleta:**  
“Eu consultaria apenas a versão da IDE.”

O build pode estar usando outro JDK ou outra instalação do Maven.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que a IDE pode mostrar um JDK diferente?
2. Como definir o JDK correto no ambiente?
3. Qual informação do resultado é mais importante para uma investigação?

---

## Pergunta 78 — POM XML inválido

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O Maven acusa um erro de XML no `pom.xml`. Como você investigaria?

**O que essa pergunta avalia:**  
Avalia a capacidade de corrigir erros estruturais no POM.

**Resposta esperada:**  
Eu verificaria:

- Tags não fechadas;
- Tags mal aninhadas;
- Caracteres especiais;
- Duplicidade de elementos;
- Namespaces;
- Linha indicada na mensagem;
- Alterações recentes no arquivo.

**Explicação didática:**  
O Maven precisa interpretar o XML antes de executar as fases do build. Um erro estrutural impede a leitura do projeto.

A linha indicada pode ser próxima da causa, mas nem sempre contém o erro original.

**Exemplo prático:**  
Uma tag `<dependency>` sem fechamento pode fazer o Maven acusar erro em uma linha posterior.

**Como o candidato deve responder:**  

- Comece pela linha indicada;
- Verifique também linhas anteriores;
- Use validação do editor;
- Revise alterações recentes;
- Não apague o POM inteiro sem necessidade.

**Resposta fraca ou incompleta:**  
“Eu excluiria o POM e criaria outro.”

Isso pode eliminar configurações importantes e não é uma investigação adequada.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que a linha indicada pode não conter a causa?
2. Como validar a estrutura XML?
3. Como comparar o POM atual com a última versão funcional?

---

## Pergunta 79 — Falha de teste

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Um teste falha durante `mvn test`. Qual deve ser sua abordagem?

**O que essa pergunta avalia:**  
Avalia troubleshooting, leitura de testes e responsabilidade com a qualidade.

**Resposta esperada:**  
Eu analisaria:

1. A asserção que falhou;
2. O stack trace;
3. Os dados utilizados;
4. O ambiente;
5. As alterações recentes;
6. A possibilidade de erro no código;
7. A possibilidade de erro no próprio teste.

Depois, executaria o teste isoladamente e, após a correção, a suíte completa.

**Explicação didática:**  
Uma falha pode indicar regressão no código, teste desatualizado, problema de ambiente ou teste instável. Não é correto ignorá-la automaticamente.

**Exemplo de código:**

~~~bash
mvn -Dtest=PedidoServiceTest test
~~~

**Como o candidato deve responder:**  

- Leia a mensagem e o stack trace;
- Reproduza o teste;
- Diferencie bug de produção e bug no teste;
- Execute novamente a suíte completa;
- Não use `-DskipTests` como primeira solução.

**Resposta fraca ou incompleta:**  
“Eu ignoraria o teste para liberar o build.”

Isso esconde uma possível regressão.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como executar somente o teste que falhou?
2. Como diferenciar falha do teste e falha do código?
3. Como validar a correção?

---

## Pergunta 80 — Teste instável

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Como você investigaria um teste Maven que passa e falha sem alteração no código?

**O que essa pergunta avalia:**  
Avalia a identificação e investigação de testes flakey.

**Resposta esperada:**  
Eu investigaria dependência de:

- Hora atual;
- Fuso horário;
- Ordem de execução;
- Estado compartilhado;
- Arquivos temporários;
- Rede;
- Portas;
- Concorrência;
- Dados externos;
- Ambiente.

Também executaria o teste repetidamente e tentaria isolá-lo.

**Explicação didática:**  
Um teste instável reduz a confiança no pipeline. Ele deve ser corrigido, não simplesmente ignorado.

**Exemplo prático:**  
Um teste que utiliza uma porta fixa pode falhar quando outro processo já está usando essa porta.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Liste hipóteses;
- Explique como reproduzir;
- Separe problema de ambiente de problema de código;
- Fale sobre isolamento e determinismo.

**Resposta fraca ou incompleta:**  
“Testes instáveis são normais e não precisam ser corrigidos.”

Instabilidade deve ser investigada e reduzida.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como reproduzir a falha?
2. Como evitar estado compartilhado?
3. Como diferenciar flakiness de falha causada por ambiente?

---

## Pergunta 81 — Testes unitários e de integração

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Por que separar testes unitários de testes de integração no Maven?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre organização, velocidade e finalidade dos testes.

**Resposta esperada:**  
Testes unitários geralmente são rápidos e isolados. Testes de integração verificam a interação entre componentes e podem depender de banco, rede, containers ou outros serviços.

Separá-los permite:

- Feedback mais rápido;
- Execução controlada;
- Diagnóstico mais simples;
- Uso adequado do CI;
- Menor dependência de infraestrutura nos testes unitários.

**Explicação didática:**  
Cada tipo de teste responde a uma pergunta diferente. Um teste unitário verifica uma unidade isolada; um teste de integração verifica componentes trabalhando juntos.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[Alteração no código] --> B[Testes unitários]
    B --> C[Testes de integração]
    C --> D[Validações finais]
~~~

**Como o candidato deve responder:**  

- Explique diferença de finalidade;
- Mencione velocidade e infraestrutura;
- Relacione Surefire e Failsafe;
- Não baseie a distinção apenas no nome da classe.

**Resposta fraca ou incompleta:**  
“Eles são separados porque usam nomes diferentes.”

A separação existe por finalidade, custo e ciclo de execução.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual plugin costuma executar testes unitários?
2. Quando executar testes de integração?
3. Como lidar com dependências externas?

---

## Pergunta 82 — Análise de qualidade

**Nível:** Júnior  
**Categoria:** Qualidade

**Pergunta do entrevistador:**  
Como integrar verificações de qualidade ao build Maven?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre automação de qualidade.

**Resposta esperada:**  
Podem ser integrados plugins ou ferramentas para verificar:

- Estilo;
- Bugs potenciais;
- Complexidade;
- Cobertura;
- Vulnerabilidades;
- Formatação;
- Regras arquiteturais.

Essas verificações podem ser associadas a fases do Maven ou executadas na pipeline.

**Explicação didática:**  
A automação ajuda a detectar problemas cedo. Entretanto, as regras devem ser relevantes e bem configuradas para evitar excesso de falsos positivos.

**Exemplo prático:**  
A pipeline pode executar verificações antes de permitir a publicação do artefato.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Cite tipos de verificação;
- Explique a integração com fases ou CI;
- Mencione falsos positivos;
- Não diga que qualquer plugin deve bloquear o build automaticamente.

**Resposta fraca ou incompleta:**  
“Basta adicionar qualquer plugin de qualidade.”

É necessário avaliar configuração, compatibilidade, regras e impacto no fluxo.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Em qual fase você colocaria uma verificação?
2. Como reduzir falsos positivos?
3. Que tipo de problema deveria bloquear a publicação?

---

## Pergunta 83 — Cobertura de testes

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Como a cobertura de testes pode ser integrada a um build Maven?

**O que essa pergunta avalia:**  
Avalia conhecimento sobre métricas e automação de testes.

**Resposta esperada:**  
Um plugin de cobertura pode instrumentar a execução dos testes, gerar relatórios e, se configurado, falhar o build quando um limite mínimo não for alcançado.

**Explicação didática:**  
Cobertura indica quais linhas ou branches foram executados. Porém, uma cobertura alta não garante que os testes sejam bons nem que todos os comportamentos estejam corretos.

**Exemplo prático:**  
Uma equipe pode exigir cobertura mínima para componentes críticos, combinando a métrica com revisão de qualidade.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Explique o que a cobertura mede;
- Mencione linhas e branches;
- Explique limitações;
- Não afirme que 100% de cobertura elimina bugs.

**Resposta fraca ou incompleta:**  
“Se a cobertura for 100%, o código não possui problemas.”

Cobertura não mede completamente a qualidade dos testes.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre cobertura de linhas e branches?
2. Quando uma regra de cobertura deve falhar o build?
3. Como evitar perseguir uma métrica sem valor?

---

## Pergunta 84 — Vulnerabilidades em dependências

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como identificar vulnerabilidades em dependências Maven?

**O que essa pergunta avalia:**  
Avalia a consciência sobre segurança da cadeia de dependências.

**Resposta esperada:**  
Podem ser utilizadas ferramentas ou plugins de análise de dependências para identificar versões vulneráveis, incluindo vulnerabilidades em dependências transitivas.

O resultado deve ser analisado considerando severidade, exploração, impacto e disponibilidade de correção.

**Explicação didática:**  
O fato de uma dependência compilar não significa que ela seja segura. Uma biblioteca indireta também pode introduzir risco.

**Exemplo prático:**  
Uma pipeline pode executar a verificação em pull requests e bloquear a publicação de vulnerabilidades críticas.

**Exemplo de código:**  
Não é necessário código adicional.

**Como o candidato deve responder:**  

- Mencione dependências transitivas;
- Fale sobre severidade;
- Explique atualização ou exclusão;
- Reconheça a possibilidade de falsos positivos.

**Resposta fraca ou incompleta:**  
“Se o build passou, as dependências estão seguras.”

Build e segurança são verificações diferentes.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como tratar uma vulnerabilidade transitiva?
2. Quando aceitar temporariamente um risco?
3. Como comprovar que a correção foi aplicada?

---

## Pergunta 85 — Credenciais de repositório

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Que cuidados devem ser tomados ao configurar credenciais para um repositório Maven?

**O que essa pergunta avalia:**  
Avalia práticas básicas de proteção de segredos.

**Resposta esperada:**  
Credenciais não devem ser colocadas no POM versionado nem diretamente na linha de comando de forma que apareçam em logs.

Elas devem ser fornecidas por:

- `settings.xml` protegido;
- Variáveis secretas da pipeline;
- Cofres de segredos;
- Tokens com permissões mínimas;
- Mecanismos de mascaramento.

Também é importante realizar rotação e revogação quando necessário.

**Explicação didática:**  
Um segredo publicado no Git pode permanecer no histórico mesmo depois de removido do arquivo atual.

**Exemplo prático:**  
A pipeline injeta um token temporário durante a publicação sem gravá-lo no código.

**Como o candidato deve responder:**  

- Proíba credenciais no POM;
- Mencione menor privilégio;
- Fale sobre logs e histórico;
- Explique rotação de credenciais.

**Resposta fraca ou incompleta:**  
“Eu colocaria a senha no POM e removeria depois.”

O histórico do controle de versão pode continuar contendo a senha.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que fazer se um token for publicado?
2. Como evitar exposição nos logs?
3. Por que utilizar permissões mínimas?

---

## Pergunta 86 — Atualização de dependência

**Nível:** Júnior  
**Categoria:** Manutenção

**Pergunta do entrevistador:**  
Como você decidiria se uma dependência Maven deve ser atualizada?

**O que essa pergunta avalia:**  
Avalia a capacidade de tomar decisões de manutenção com base em risco.

**Resposta esperada:**  
Eu avaliaria:

- Motivo da atualização;
- Vulnerabilidades;
- Compatibilidade;
- Changelog;
- Breaking changes;
- Impacto no código;
- Testes disponíveis;
- Possibilidade de rollback.

**Explicação didática:**  
Uma atualização pode corrigir problemas de segurança, mas também alterar APIs ou comportamentos. Por isso, deve ser feita com testes e revisão.

**Exemplo prático:**  
Uma atualização necessária para corrigir uma vulnerabilidade crítica deve ser priorizada, mas validada em ambiente de teste.

**Como o candidato deve responder:**  

- Explique o motivo da atualização;
- Diferencie patch, minor e major;
- Mencione testes;
- Fale sobre rollback e impacto.

**Resposta fraca ou incompleta:**  
“Eu atualizaria sempre para a versão mais nova sem testar.”

Atualizações precisam de avaliação e validação.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como reduzir o risco de breaking changes?
2. Qual a diferença geral entre patch e major?
3. Como preparar um rollback?

---

## Pergunta 87 — Dependência não utilizada

**Nível:** Júnior  
**Categoria:** Manutenção

**Pergunta do entrevistador:**  
Por que dependências não utilizadas devem ser removidas do POM?

**O que essa pergunta avalia:**  
Avalia conhecimentos de manutenção, segurança e simplicidade.

**Resposta esperada:**  
Dependências não utilizadas podem:

- Aumentar o tamanho do artefato;
- Aumentar o tempo de build;
- Introduzir vulnerabilidades transitivas;
- Gerar conflitos;
- Tornar o POM mais complexo;
- Dificultar atualizações.

**Explicação didática:**  
Uma dependência aparentemente não utilizada pode ainda ser necessária para plugins, configuração ou execução indireta. Por isso, a remoção deve ser validada.

**Exemplo prático:**  
Após remover uma biblioteca antiga, a equipe executa testes e verifica o pacote final antes de concluir a alteração.

**Como o candidato deve responder:**  

- Explique os benefícios da remoção;
- Mencione o risco de remover algo necessário;
- Fale sobre testes;
- Não remova dependências apenas pela aparência.

**Resposta fraca ou incompleta:**  
“Devem ser removidas porque deixam o POM feio.”

Existem impactos técnicos e de segurança mais importantes.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como verificar se uma dependência está realmente sem uso?
2. Que risco existe em removê-la?
3. Como validar o projeto após a remoção?

---

## Pergunta 88 — Dependência transitiva usada diretamente

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Seu código utiliza diretamente uma biblioteca que chegou ao projeto apenas como dependência transitiva. O que você faria?

**O que essa pergunta avalia:**  
Avalia clareza e estabilidade na declaração de dependências.

**Resposta esperada:**  
Eu declararia explicitamente a biblioteca utilizada diretamente pelo código.

**Explicação didática:**  
Depender apenas de uma inclusão transitiva cria um acoplamento implícito. Se a dependência que a traz for atualizada ou removida, o código pode deixar de compilar.

**Exemplo prático:**  
Se o código usa diretamente uma biblioteca JSON trazida por um framework, essa biblioteca deve aparecer explicitamente no POM.

**Como o candidato deve responder:**  

- Explique dependência direta;
- Mencione estabilidade e documentação;
- Fale sobre o risco de mudanças transitivas;
- Não mantenha a situação somente porque “está compilando”.

**Resposta fraca ou incompleta:**  
“Eu manteria como está, porque o Maven já resolveu.”

A resolução atual não garante estabilidade futura.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que problema ocorre se a dependência transitiva desaparecer?
2. Como localizar a origem da biblioteca?
3. Como validar a alteração no POM?

---

## Pergunta 89 — `ClassNotFoundException`

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Uma aplicação Maven compila, mas falha em execução com `ClassNotFoundException`. O que você investigaria?

**O que essa pergunta avalia:**  
Avalia a relação entre escopos, classpath e runtime.

**Resposta esperada:**  
Eu verificaria:

- Se a dependência foi declarada;
- Se o escopo é adequado;
- Se a biblioteca está no pacote;
- Se o ambiente fornece a dependência;
- Se há diferença entre IDE e produção;
- Se a classe pertence à versão correta da biblioteca.

**Explicação didática:**  
Uma dependência pode estar disponível durante a compilação, mas não durante a execução. Isso pode acontecer com escopos inadequados, como `test` ou `provided` em um ambiente que não fornece a biblioteca.

**Exemplo prático:**  
Uma biblioteca declarada como `test` pode permitir a compilação dos testes, mas não estará disponível para a aplicação em produção.

**Como o candidato deve responder:**  

- Relacione erro ao classpath;
- Verifique escopo e pacote;
- Compare ambientes;
- Não altere versões aleatoriamente sem investigar.

**Resposta fraca ou incompleta:**  
“Eu adicionaria qualquer versão da biblioteca.”

O problema pode ser escopo, empacotamento ou ambiente.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual escopo costuma estar disponível em runtime?
2. Como verificar o conteúdo do pacote?
3. Quando `provided` seria apropriado?

---

## Pergunta 90 — `NoSuchMethodError`

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O que pode causar um erro `NoSuchMethodError` em uma aplicação Maven?

**O que essa pergunta avalia:**  
Avalia o conhecimento inicial sobre incompatibilidade binária.

**Resposta esperada:**  
Uma causa comum é a aplicação ter sido compilada com uma versão da biblioteca e executada com outra versão que não contém o método esperado.

Eu verificaria:

- Árvore de dependências;
- Versões selecionadas;
- Classpath de runtime;
- Dependências transitivas;
- Versões presentes no pacote final.

**Explicação didática:**  
O código compilado espera encontrar determinado método. Porém, durante a execução, outra versão da classe é carregada e esse método não existe nela.

**Exemplo prático:**

~~~bash
mvn dependency:tree
~~~

O comando pode ajudar a encontrar versões concorrentes.

**Como o candidato deve responder:**  

- Diferencie erro de compilação e erro de runtime;
- Mencione conflito de versões;
- Explique como investigar;
- Não atribua automaticamente o problema ao código-fonte.

**Resposta fraca ou incompleta:**  
“É sempre um erro de sintaxe.”

O problema geralmente está relacionado a incompatibilidade de versões ou classpath.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como verificar a versão escolhida pelo Maven?
2. Como corrigir um conflito de dependências?
3. Por que o classpath de compilação pode ser diferente do runtime?

---

## Pergunta 91 — Executar teste específico

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Como executar apenas uma classe de teste específica com Maven?

**O que essa pergunta avalia:**  
Avalia produtividade na investigação de falhas.

**Resposta esperada:**  
Pode-se utilizar a propriedade `-Dtest`:

~~~bash
mvn -Dtest=PedidoServiceTest test
~~~

Isso solicita a execução da classe de teste informada.

**Explicação didática:**  
Executar somente um teste reduz o tempo de feedback durante a investigação. Depois da correção, ainda é necessário executar a suíte completa.

**Exemplo prático:**  
Investigar rapidamente uma falha em `PedidoServiceTest` antes de executar todos os testes do projeto.

**Como o candidato deve responder:**  

- Mostre a propriedade;
- Explique que ela ajuda no diagnóstico;
- Mencione a execução posterior da suíte completa;
- Não remova ou altere outros testes para acelerar a execução.

**Resposta fraca ou incompleta:**  
“Eu apagaria os outros testes temporariamente.”

Isso pode esconder problemas e modificar o comportamento do projeto.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como executar um método específico?
2. Por que executar a suíte completa depois?
3. Qual plugin normalmente interpreta essa propriedade?

---

## Pergunta 92 — Teste não encontrado

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O Maven informa que não encontrou o teste solicitado. Quais hipóteses você verificaria?

**O que essa pergunta avalia:**  
Avalia o diagnóstico de convenções e configuração de descoberta de testes.

**Resposta esperada:**  
Eu verificaria:

- Nome completo da classe;
- Diretório do teste;
- Pacote;
- Padrão de nomenclatura;
- Compilação do teste;
- Configuração do Surefire;
- Possíveis filtros de execução.

**Explicação didática:**  
O Maven utiliza convenções para localizar testes. Uma classe fora do diretório ou do padrão esperado pode não ser descoberta automaticamente.

**Exemplo prático:**  
Uma classe chamada `PedidoSpec` pode não ser executada se o plugin estiver configurado para procurar nomes terminados em `Test`.

**Como o candidato deve responder:**  

- Verifique nome e localização;
- Analise a configuração do plugin;
- Confirme se o teste foi compilado;
- Não execute o build repetidamente sem alterar ou investigar nada.

**Resposta fraca ou incompleta:**  
“Eu rodaria novamente até o teste aparecer.”

Repetir o comando não corrige um problema de descoberta.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quais padrões de nome são comuns para testes?
2. Onde os testes devem ficar?
3. Como confirmar que foram compilados?

---

## Pergunta 93 — Instalar biblioteca localmente

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Você desenvolve uma biblioteca local e precisa utilizá-la em outro projeto. Como faria isso com Maven?

**O que essa pergunta avalia:**  
Avalia o uso prático de `install` e de coordenadas Maven.

**Resposta esperada:**  
Eu executaria `mvn install` no projeto da biblioteca e depois declararia suas coordenadas como dependência no segundo projeto.

**Exemplo de código:**

~~~bash
cd biblioteca
mvn clean install
~~~

~~~xml
<dependency>
    <groupId>br.com.exemplo</groupId>
    <artifactId>biblioteca</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
~~~

**Explicação didática:**  
O comando instala o artefato no repositório local. O segundo projeto consegue resolvê-lo utilizando `groupId`, `artifactId` e `version`.

**Como o candidato deve responder:**  

- Explique a ordem das ações;
- Mencione o repositório local;
- Garanta que as coordenadas coincidam;
- Diferencie instalação local de publicação remota.

**Resposta fraca ou incompleta:**  
“Eu copiaria o JAR manualmente para o outro projeto.”

Isso dificulta rastreabilidade e manutenção.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre `install` e `deploy`?
2. Como trabalhar com alterações frequentes na biblioteca?
3. Quando usar um repositório corporativo?

---

## Pergunta 94 — Publicação mesmo com teste falhando

**Nível:** Júnior  
**Categoria:** CI/CD

**Pergunta do entrevistador:**  
Uma pipeline publicou um artefato mesmo com testes falhando. O que você investigaria?

**O que essa pergunta avalia:**  
Avalia a capacidade de investigar falhas no fluxo de publicação.

**Resposta esperada:**  
Eu verificaria:

- Se os testes foram executados;
- Se o comando usou `-DskipTests` ou configuração semelhante;
- Se o código de saída foi respeitado;
- Se o pipeline continuou após a falha;
- Se a publicação depende do sucesso do build;
- Se o artefato publicado corresponde à execução atual.

**Explicação didática:**  
A publicação deve ocorrer apenas depois que as validações obrigatórias forem concluídas com sucesso.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Executar testes] --> B{Testes aprovados?}
    B -->|Não| C[Interromper pipeline]
    B -->|Sim| D[Empacotar]
    D --> E[Publicar artefato]
~~~

**Como o candidato deve responder:**  

- Analise logs e configuração;
- Verifique o comando real;
- Confirme o tratamento do status de saída;
- Não se limite a executar os testes novamente localmente.

**Resposta fraca ou incompleta:**  
“Eu rodaria os testes novamente na minha máquina.”

Isso não explica por que a pipeline permitiu a publicação.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como impedir a publicação quando os testes falharem?
2. Qual o efeito de `-DskipTests`?
3. Como comprovar a causa pelo log da pipeline?

---

## Pergunta 95 — Repositório corporativo indisponível

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O repositório corporativo está indisponível, mas você precisa executar o build. O que faria?

**O que essa pergunta avalia:**  
Avalia o entendimento sobre cache, modo offline e limites operacionais.

**Resposta esperada:**  
Eu verificaria se todas as dependências e plugins necessários estão disponíveis no cache local. Se estiverem, poderia tentar:

~~~bash
mvn -o clean verify
~~~

Também comunicaria a indisponibilidade e evitaria baixar artefatos de fontes não aprovadas.

**Explicação didática:**  
O modo offline só funciona se os artefatos necessários já estiverem disponíveis localmente. Dependências privadas ou novas podem impedir a execução.

**Como o candidato deve responder:**  

- Explique a dependência do cache;
- Mencione o modo offline;
- Fale sobre comunicação e segurança;
- Não recomende baixar JARs aleatórios da internet.

**Resposta fraca ou incompleta:**  
“Eu baixaria os JARs de qualquer site.”

Isso pode introduzir vulnerabilidades e incompatibilidades.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como verificar se o cache local é suficiente?
2. O modo offline sempre funcionará?
3. Como agir quando falta uma dependência privada?

---

## Pergunta 96 — Atualização do Maven Wrapper

**Nível:** Júnior  
**Categoria:** Manutenção

**Pergunta do entrevistador:**  
Por que uma equipe pode decidir atualizar a versão do Maven Wrapper?

**O que essa pergunta avalia:**  
Avalia a maturidade na manutenção das ferramentas de build.

**Resposta esperada:**  
A atualização pode trazer:

- Correções de bugs;
- Melhor compatibilidade com novos JDKs;
- Melhorias de segurança;
- Compatibilidade com plugins;
- Melhorias de desempenho;
- Correções de comportamento.

A alteração deve ser validada com o build completo.

**Explicação didática:**  
O Wrapper controla a versão do Maven usada pelo projeto. Atualizá-lo pode revelar configurações antigas ou incompatibilidades, por isso a mudança deve ser revisada.

**Exemplo prático:**  
Atualizar o Wrapper para permitir que o projeto funcione corretamente com uma nova versão do JDK no CI.

**Como o candidato deve responder:**  

- Explique motivos técnicos;
- Diferencie Maven de JDK;
- Mencione testes e rollback;
- Não atualize somente porque existe uma versão mais nova.

**Resposta fraca ou incompleta:**  
“Eu atualizaria porque a nova versão é mais moderna.”

Falta explicar o benefício e avaliar o impacto.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que riscos uma atualização pode trazer?
2. Como testar a compatibilidade?
3. O Wrapper controla a versão do JDK?

---

## Pergunta 97 — Repositório público e privado

**Nível:** Júnior  
**Categoria:** Repositórios

**Pergunta do entrevistador:**  
Quando uma dependência deve ser obtida de um repositório privado em vez de um repositório público?

**O que essa pergunta avalia:**  
Avalia noções de segurança, governança e distribuição de artefatos.

**Resposta esperada:**  
Dependências internas, proprietárias ou restritas devem ser armazenadas em repositórios privados.

Repositórios privados também podem ser usados para:

- Controle de acesso;
- Auditoria;
- Cache;
- Políticas de aprovação;
- Armazenamento de artefatos corporativos.

**Explicação didática:**  
Uma biblioteca interna não deve ser publicada em um repositório público se contiver código proprietário ou informações restritas.

**Exemplo prático:**  
Uma empresa pode publicar seus módulos compartilhados em um Nexus ou Artifactory interno.

**Como o candidato deve responder:**  

- Diferencie artefatos públicos e privados;
- Mencione controle de acesso;
- Fale sobre segurança e governança;
- Não escolha repositório apenas pela velocidade.

**Resposta fraca ou incompleta:**  
“Usaria um repositório privado somente porque é mais rápido.”

Velocidade pode ser um benefício, mas não é o único fator.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como proteger artefatos internos?
2. Como controlar versões publicadas?
3. O que fazer se o repositório privado ficar indisponível?

---

## Pergunta 98 — Revisão de um `pom.xml`

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Ao revisar um `pom.xml`, quais pontos você verificaria antes de aprová-lo?

**O que essa pergunta avalia:**  
Avalia a visão prática sobre qualidade, segurança e manutenção do build.

**Resposta esperada:**  
Eu verificaria:

- Coordenadas do projeto;
- Versão do Java;
- Dependências diretas;
- Dependências transitivas;
- Escopos;
- Duplicidades;
- Versões;
- Plugins;
- Repositórios adicionais;
- Profiles;
- Segredos;
- Compatibilidade com a pipeline;
- Possíveis vulnerabilidades.

**Explicação didática:**  
Um POM pode ser XML válido e ainda assim conter problemas técnicos, como versões conflitantes, dependências desnecessárias ou repositórios não autorizados.

**Exemplo prático:**  
Questionar uma dependência sem escopo definido, uma versão duplicada ou um repositório externo não aprovado.

**Como o candidato deve responder:**  

- Organize a revisão por dependências, build, segurança e CI;
- Verifique se as versões estão controladas;
- Avalie necessidade e escopo;
- Não se limite à validação sintática do XML.

**Resposta fraca ou incompleta:**  
“Eu verificaria apenas se o XML está bem formado.”

Isso não garante que o POM esteja correto ou seguro.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como identificar uma dependência desnecessária?
2. Que riscos repositórios desconhecidos podem trazer?
3. Como verificar vulnerabilidades nas dependências?

---

## Pergunta 99 — Comunicação de falha ambiental

**Nível:** Júnior  
**Categoria:** Comunicação técnica

**Pergunta do entrevistador:**  
Como você comunicaria à equipe que uma falha do Maven foi causada por uma diferença de ambiente?

**O que essa pergunta avalia:**  
Avalia clareza, colaboração e capacidade de registrar evidências.

**Resposta esperada:**  
Eu comunicaria:

- Mensagem do erro;
- Comando executado;
- Versão do Maven;
- Versão do Java;
- Diferença entre ambientes;
- Evidências coletadas;
- Impacto;
- Correção;
- Ação preventiva.

Também evitaria culpar pessoas ou ambientes sem apresentar fatos.

**Explicação didática:**  
Uma boa comunicação permite que outras pessoas reproduzam o problema e evita que a mesma falha volte a ocorrer.

**Exemplo prático:**  
Registrar que o CI utilizava Java 11, enquanto o projeto exigia Java 17, incluindo o resultado de `mvn -version`.

**Como o candidato deve responder:**  

- Organize a resposta em fato, evidência, impacto, solução e prevenção;
- Seja objetivo;
- Registre versões e comandos;
- Não diga apenas que “o CI estava errado”.

**Resposta fraca ou incompleta:**  
“O problema era da máquina do CI.”

A resposta não apresenta evidências nem uma ação preventiva.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que evidências você registraria?
2. Como evitar que a diferença volte a ocorrer?
3. Como diferenciar causa e sintoma?

---

## Pergunta 100 — Diagnóstico completo de build

**Nível:** Júnior  
**Categoria:** Cenário prático

**Pergunta do entrevistador:**  
Um projeto Maven funciona na sua máquina, mas falha no CI. Como você conduziria o diagnóstico completo?

**O que essa pergunta avalia:**  
Avalia a integração dos conhecimentos sobre ambiente, ciclo de vida, dependências, testes e pipeline.

**Resposta esperada:**  
Eu seguiria uma investigação organizada:

1. Coletaria o log completo;
2. Identificaria a primeira falha relevante;
3. Compararia Maven e JDK;
4. Confirmaria o comando executado;
5. Compararia profiles e variáveis;
6. Verificaria dependências e repositórios;
7. Conferiria o cache;
8. Reproduziria localmente em ambiente semelhante;
9. Aplicaria a correção;
10. Executaria `clean verify`;
11. Documentaria a causa e a prevenção.

**Explicação didática:**

~~~mermaid
flowchart TD
    A[Coletar log completo] --> B[Identificar primeira falha]
    B --> C[Comparar Maven e JDK]
    C --> D[Comparar comandos e profiles]
    D --> E[Verificar dependências e repositórios]
    E --> F[Comparar variáveis e cache]
    F --> G[Reproduzir em ambiente equivalente]
    G --> H[Aplicar correção]
    H --> I[Executar clean verify]
    I --> J{Build aprovado?}
    J -->|Não| B
    J -->|Sim| K[Documentar causa e prevenção]
~~~

**Exemplo prático:**  
O CI pode utilizar Java 11 enquanto o projeto exige Java 17. Outra possibilidade é uma dependência estar disponível no cache local do desenvolvedor, mas ausente no CI.

**Exemplo de código:**

~~~bash
mvn --batch-mode clean verify
~~~

**Como o candidato deve responder:**  

- Apresente uma sequência lógica;
- Explique o motivo de cada verificação;
- Considere ambiente, dependências, testes e pipeline;
- Mencione prevenção por meio de Wrapper e versões controladas;
- Não atribua o problema imediatamente ao CI ou ao código.

**Resposta fraca ou incompleta:**  
“Eu executaria novamente ou pediria para outra pessoa verificar.”

Essa resposta não apresenta investigação sistemática nem coleta de evidências.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como provaria que o problema é ambiental?
2. Que informações deveriam ser coletadas no CI?
3. Como evitar que a diferença entre ambientes volte a ocorrer?

---

