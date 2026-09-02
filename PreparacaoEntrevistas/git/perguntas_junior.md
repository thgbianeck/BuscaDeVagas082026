# Roteiro de Entrevista Técnica — Git

## Configuração da entrevista

- **Tecnologia avaliada:** Git
- **Nível:** Júnior
- **Quantidade:** 100 perguntas
- **Perfil:** Misturado — conceitual, prático e baseado em cenários reais
- **Objetivo:** Avaliar se o candidato compreende os fundamentos do Git e consegue utilizá-lo com segurança em tarefas comuns de desenvolvimento.

---

## Fluxo geral do Git

~~~mermaid
flowchart LR
    A[Arquivos de trabalho] -->|git add| B[Staging Area]
    B -->|git commit| C[Repositório local]
    C -->|git push| D[Repositório remoto]
    D -->|git pull ou fetch| C
    C -->|git checkout ou switch| A
~~~

---

# Perguntas

## Pergunta 1 — Finalidade do Git

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é o Git e qual problema ele resolve no desenvolvimento de software?

**O que essa pergunta avalia:**  
Avalia a compreensão de controle de versão, histórico de alterações, colaboração e recuperação de versões anteriores.

**Resposta esperada:**  
Git é um sistema distribuído de controle de versão. Ele registra alterações feitas em arquivos, permite consultar o histórico, comparar versões, criar branches, desfazer mudanças e colaborar com outras pessoas.

**Explicação didática:**  
Sem controle de versão, as pessoas costumam criar cópias como `projeto-final`, `projeto-final-2` e `projeto-final-corrigido`. O Git organiza essas mudanças por meio de commits, branches e histórico rastreável.

**Exemplo prático:**  
Um desenvolvedor pode criar uma branch para uma nova funcionalidade sem alterar diretamente a versão principal do projeto.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Defina Git, explique controle de versão e mencione histórico, colaboração e branches. Evite dizer apenas que Git é uma ferramenta para “salvar arquivos”.

**Resposta fraca ou incompleta:**  
“Git serve para guardar códigos.” Essa resposta não explica versionamento, histórico ou colaboração.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre Git e GitHub?
2. Por que o histórico é importante durante a investigação de um problema?
3. Quais vantagens existem em relação a cópias manuais dos arquivos?

---

## Pergunta 2 — Git distribuído

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que significa dizer que o Git é um sistema de controle de versão distribuído?

**O que essa pergunta avalia:**  
Avalia a compreensão do repositório local e da independência de algumas operações em relação ao servidor remoto.

**Resposta esperada:**  
Cada clone de um repositório Git normalmente possui o histórico completo do projeto. Por isso, commits, consultas ao histórico e muitas comparações podem ser feitas localmente. O repositório remoto é usado principalmente para colaboração e compartilhamento.

**Explicação didática:**  
Em sistemas centralizados, várias operações dependem de um servidor único. No Git, o desenvolvedor possui uma cópia local do repositório e pode trabalhar offline, sincronizando depois.

**Exemplo prático:**  
É possível criar commits durante uma viagem sem conexão e enviá-los ao servidor posteriormente.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Explique que o histórico está no clone local e diferencie trabalhar localmente de sincronizar com o remoto.

**Resposta fraca ou incompleta:**  
“Distribuído significa que várias pessoas podem usar o Git.” Isso não explica a existência do repositório local completo.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quais operações podem ser realizadas sem internet?
2. Que operações dependem normalmente do remoto?
3. Existe algum risco em trabalhar muito tempo sem sincronizar?

---

## Pergunta 3 — Repositório Git

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é um repositório Git e como você cria um em uma pasta existente?

**O que essa pergunta avalia:**  
Avalia a compreensão da estrutura básica de um repositório e da inicialização de um projeto.

**Resposta esperada:**  
Um repositório Git é uma pasta cujo histórico é controlado pelo Git. Em uma pasta existente, pode-se executar:

~~~bash
git init
git status
~~~

O comando `git init` cria a estrutura interna necessária para o controle de versão.

**Explicação didática:**  
A pasta `.git` contém metadados, referências, objetos e informações do histórico. Ela não deve ser editada manualmente em tarefas comuns.

**Exemplo prático:**  
Um projeto criado localmente pode ser inicializado com `git init` antes do primeiro commit.

**Exemplo de código:**  
~~~bash
mkdir meu-projeto
cd meu-projeto
git init
~~~

**Como o candidato deve responder:**  
Mencione `git init`, explique que o histórico fica associado à pasta e recomende verificar o estado com `git status`.

**Resposta fraca ou incompleta:**  
“É só executar `git start`.” Esse comando não é o procedimento padrão para inicializar um repositório.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que é a pasta `.git`?
2. O que acontece se ela for removida?
3. Qual a diferença entre inicializar um repositório e cloná-lo?

---

## Pergunta 4 — Área de trabalho, staging e repositório

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Explique a diferença entre área de trabalho, staging area e repositório Git.

**O que essa pergunta avalia:**  
Avalia o modelo mental do fluxo básico de alterações no Git.

**Resposta esperada:**  
A área de trabalho contém os arquivos que estão sendo editados. A staging area contém as alterações selecionadas para o próximo commit. O repositório contém os commits já registrados.

**Explicação didática:**  
O Git permite escolher quais alterações farão parte de um commit. O fluxo comum é:

~~~mermaid
flowchart LR
    A[Working Tree] -->|git add| B[Staging Area]
    B -->|git commit| C[Repository]
~~~

**Exemplo prático:**  
Se dois arquivos foram modificados, é possível adicionar apenas um ao staging e criar um commit parcial.

**Exemplo de código:**  
~~~bash
git status
git add src/login.js
git commit -m "Corrige validação do login"
~~~

**Como o candidato deve responder:**  
Explique as três áreas na ordem e associe cada transição a `git add` e `git commit`.

**Resposta fraca ou incompleta:**  
“Staging e commit são a mesma coisa.” O staging ainda não faz parte do histórico.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como remover um arquivo do staging sem perder sua alteração?
2. Por que o staging é útil?
3. Qual comando mostra a diferença entre trabalho e staging?

---

## Pergunta 5 — Comando git status

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Para que serve o comando `git status` e em quais momentos você o utilizaria?

**O que essa pergunta avalia:**  
Avalia a capacidade de inspecionar o estado do repositório antes de executar operações.

**Resposta esperada:**  
`git status` mostra a branch atual, arquivos modificados, arquivos adicionados ao staging, arquivos não rastreados e, em alguns casos, informações sobre divergência em relação ao remoto.

~~~bash
git status
~~~

É recomendável utilizá-lo antes e depois de adicionar arquivos, antes de realizar commits e durante a resolução de conflitos.

**Explicação didática:**  
O comando funciona como um diagnóstico rápido do repositório. Ele ajuda a evitar commits acidentais e permite entender o que ainda precisa ser feito.

**Exemplo prático:**  
Antes de um commit, o desenvolvedor verifica se não adicionou arquivos de configuração local ou credenciais.

**Exemplo de código:**  
Não se aplica além do comando apresentado.

**Como o candidato deve responder:**  
Explique as categorias exibidas e mostre que o comando é usado para orientar o próximo passo.

**Resposta fraca ou incompleta:**  
“Mostra os arquivos do projeto.” O comando não é apenas uma listagem de arquivos.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que significa “untracked”?
2. Como identificar arquivos staged?
3. O que você verifica antes de criar um commit?

---

## Pergunta 6 — Commit

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
O que é um commit e como você criaria um commit corretamente?

**O que essa pergunta avalia:**  
Avalia a capacidade de registrar uma alteração coerente no histórico.

**Resposta esperada:**  
Commit é um registro imutável, identificado por um hash, que representa alterações selecionadas no projeto. Um fluxo básico é:

~~~bash
git status
git add arquivo.js
git commit -m "Adiciona validação de e-mail"
~~~

A mensagem deve ser clara e descrever o propósito da mudança.

**Explicação didática:**  
O commit não registra automaticamente todas as alterações da pasta. Apenas o conteúdo que está no staging é incluído, salvo usos específicos como `git commit -a`, que também tem limitações.

**Exemplo prático:**  
Um commit deve preferencialmente conter uma única correção ou funcionalidade coerente.

**Exemplo de código:**  
~~~bash
git add src/validacao.js
git commit -m "Valida formato do e-mail"
~~~

**Como o candidato deve responder:**  
Mencione staging, mensagem objetiva e unidade lógica da alteração. Evite defender commits gigantes e sem propósito.

**Resposta fraca ou incompleta:**  
“Commit é enviar código para o GitHub.” Commit é um registro local; envio ao remoto normalmente é feito com `git push`.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que torna uma mensagem de commit boa?
2. Por que commits pequenos podem facilitar a revisão?
3. Um commit pode ser alterado depois? Quais riscos existem?

---

## Pergunta 7 — Mensagens de commit

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Como você escreveria uma boa mensagem de commit?

**O que essa pergunta avalia:**  
Avalia comunicação técnica, organização do histórico e capacidade de descrever intenção.

**Resposta esperada:**  
A mensagem deve ser curta, específica e orientada à ação ou ao resultado. Exemplos:

~~~text
Adiciona validação de CPF
Corrige cálculo do frete
Atualiza documentação da API
~~~

Deve evitar mensagens vagas como “ajustes”, “mudanças” ou “correções diversas”.

**Explicação didática:**  
O código mostra como algo foi implementado; a mensagem ajuda a entender por que a mudança foi feita.

**Exemplo prático:**  
Ao investigar um erro, uma mensagem como “Corrige arredondamento no cálculo de juros” é muito mais útil que “fix”.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Explique clareza, contexto e unidade lógica. Pode mencionar que a equipe deve seguir uma convenção comum.

**Resposta fraca ou incompleta:**  
“Qualquer mensagem serve porque o código mostra tudo.” Isso ignora a importância do histórico.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando uma mensagem deve conter mais contexto?
2. Você já utilizou Conventional Commits?
3. Uma convenção de mensagens deve ser imposta ou acordada pela equipe?

---

## Pergunta 8 — Arquivos não rastreados

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
O que significa um arquivo aparecer como “untracked” no `git status`?

**O que essa pergunta avalia:**  
Avalia a compreensão da diferença entre arquivos existentes na pasta e arquivos acompanhados pelo Git.

**Resposta esperada:**  
Significa que o arquivo existe na área de trabalho, mas ainda não foi incluído no controle de versão. Para rastreá-lo, utiliza-se `git add arquivo`. Antes disso, deve-se verificar se ele não é temporário, gerado automaticamente ou sensível.

**Explicação didática:**  
O Git não adiciona todos os arquivos automaticamente. Isso evita incluir acidentalmente arquivos de sistema, dependências, logs ou segredos.

**Exemplo prático:**  
Um arquivo `.env` pode aparecer como não rastreado, mas normalmente deve ser ignorado e nunca versionado se contiver credenciais.

**Exemplo de código:**  
~~~bash
git status
git add src/config.example.js
~~~

**Como o candidato deve responder:**  
Defina “não rastreado”, explique `git add` e mencione a verificação de conteúdo sensível.

**Resposta fraca ou incompleta:**  
“Untracked significa que o arquivo está com erro.” O status não indica necessariamente erro.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como ignorar esse arquivo?
2. O que você faria se uma senha tivesse sido adicionada?
3. Por que `git add .` pode ser perigoso?

---

## Pergunta 9 — Arquivo .gitignore

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Para que serve o arquivo `.gitignore`? Dê exemplos de arquivos que normalmente devem ser ignorados.

**O que essa pergunta avalia:**  
Avalia higiene do repositório, prevenção de arquivos desnecessários e noções básicas de segurança.

**Resposta esperada:**  
`.gitignore` define padrões de arquivos e pastas que o Git deve ignorar quando ainda não estão sendo rastreados. Exemplos comuns incluem dependências instaladas, logs, arquivos temporários, artefatos de build, configurações pessoais e arquivos com segredos.

~~~text
node_modules/
.env
*.log
dist/
.vscode/
~~~

Um arquivo já rastreado não deixa de ser rastreado apenas por ser adicionado ao `.gitignore`.

**Explicação didática:**  
O `.gitignore` evita poluir o histórico e reduz o risco de expor informações locais. Ele não é um mecanismo de segurança para remover segredos que já foram publicados.

**Exemplo prático:**  
O projeto pode versionar `.env.example`, contendo apenas nomes de variáveis sem valores secretos.

**Exemplo de código:**  
~~~gitignore
# Dependências
node_modules/

# Segredos locais
.env

# Logs e artefatos
*.log
dist/
~~~

**Como o candidato deve responder:**  
Explique finalidade, exemplos e a limitação para arquivos já rastreados.

**Resposta fraca ou incompleta:**  
“Serve para esconder arquivos do GitHub.” O arquivo apenas orienta o rastreamento local e não protege dados já enviados.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como deixar de rastrear um arquivo que já está no repositório?
2. `.gitignore` remove arquivos do histórico?
3. Como tratar um segredo já publicado?

---

## Pergunta 10 — Git add

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Qual é a finalidade do `git add` e qual a diferença entre `git add arquivo`, `git add .` e `git add -p`?

**O que essa pergunta avalia:**  
Avalia controle seletivo das alterações que entrarão no próximo commit.

**Resposta esperada:**  
`git add arquivo` adiciona um arquivo específico. `git add .` adiciona alterações dentro do diretório atual, podendo incluir arquivos indesejados. `git add -p` permite selecionar partes específicas das mudanças.

**Explicação didática:**  
O staging funciona como uma área de preparação. A seleção cuidadosa ajuda a criar commits menores e mais fáceis de revisar.

**Exemplo prático:**  
Se uma correção e uma alteração experimental estão no mesmo arquivo, `git add -p` pode separar os trechos.

**Exemplo de código:**  
~~~bash
git add src/api.js
git add -p
~~~

**Como o candidato deve responder:**  
Compare os três usos e destaque o cuidado necessário com o comando amplo.

**Resposta fraca ou incompleta:**  
“`git add` faz commit.” Ele apenas prepara alterações para o commit.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como retirar algo do staging?
2. Em que situação você usaria `git add -p`?
3. O que deve ser conferido antes de usar `git add .`?

---

## Pergunta 11 — git diff

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como você visualiza as alterações ainda não adicionadas ao staging?

**O que essa pergunta avalia:**  
Avalia a capacidade de revisar mudanças antes do commit.

**Resposta esperada:**  
Utiliza-se:

~~~bash
git diff
~~~

Esse comando compara a área de trabalho com o staging. Para visualizar alterações já adicionadas ao staging, usa-se:

~~~bash
git diff --staged
~~~

**Explicação didática:**  
As duas comparações respondem a perguntas diferentes: “o que ainda não preparei?” e “o que será commitado?”.

**Exemplo prático:**  
Antes do commit, o desenvolvedor pode executar ambos os comandos para garantir que não há mudanças esquecidas ou indevidas.

**Exemplo de código:**  
~~~bash
git diff
git diff --staged
~~~

**Como o candidato deve responder:**  
Diferencie claramente working tree e staging.

**Resposta fraca ou incompleta:**  
“`git diff` mostra todos os commits.” O comando mostra diferenças, não o histórico completo.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como revisar o último commit?
2. Como comparar duas branches?
3. Por que revisar o diff antes de enviar código?

---

## Pergunta 12 — Histórico com git log

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Como você consulta o histórico de commits de um repositório Git?

**O que essa pergunta avalia:**  
Avalia a capacidade de investigar mudanças passadas.

**Resposta esperada:**  
O comando básico é:

~~~bash
git log
~~~

Para uma visualização resumida:

~~~bash
git log --oneline --graph --decorate --all
~~~

O histórico pode mostrar hash, autor, data, mensagem e relações entre branches.

**Explicação didática:**  
O histórico é essencial para entender a evolução do projeto, localizar uma alteração e investigar regressões.

**Exemplo prático:**  
Um desenvolvedor pode procurar quando uma validação foi introduzida antes de alterá-la.

**Exemplo de código:**  
~~~bash
git log --oneline --decorate --graph --all
~~~

**Como o candidato deve responder:**  
Apresente `git log` e pelo menos uma forma de tornar sua saída mais legível.

**Resposta fraca ou incompleta:**  
“Uso `git history`.” Esse não é o comando padrão.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como visualizar o conteúdo de um commit específico?
2. Como limitar o número de commits exibidos?
3. Como encontrar quem alterou uma linha?

---

## Pergunta 13 — HEAD

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que significa `HEAD` no Git?

**O que essa pergunta avalia:**  
Avalia a compreensão da referência para o ponto atual do histórico.

**Resposta esperada:**  
`HEAD` representa a referência para o commit atualmente selecionado, normalmente o último commit da branch atual. `HEAD~1` representa o commit anterior, e `HEAD^` normalmente representa o primeiro pai do commit.

**Explicação didática:**  
O Git usa referências simbólicas para indicar posições no histórico. Isso permite comandos como:

~~~bash
git show HEAD
git diff HEAD~1 HEAD
~~~

**Exemplo prático:**  
Pode-se comparar o estado atual com o commit anterior usando `git diff HEAD~1 HEAD`.

**Exemplo de código:**  
~~~bash
git show HEAD
git log HEAD~3..HEAD
~~~

**Como o candidato deve responder:**  
Explique que `HEAD` aponta para a posição atual, não para uma branch remota.

**Resposta fraca ou incompleta:**  
“HEAD é o nome da branch principal.” Ele é uma referência ao commit atual.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que é detached HEAD?
2. Qual a diferença entre `HEAD~1` e `HEAD^` em merges?
3. Como recuperar trabalho feito em detached HEAD?

---

## Pergunta 14 — Branch

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é uma branch no Git e por que ela é útil?

**O que essa pergunta avalia:**  
Avalia o uso de linhas de desenvolvimento independentes.

**Resposta esperada:**  
Uma branch é uma referência que aponta para uma sequência de commits. Ela permite desenvolver uma funcionalidade, correção ou experimento isoladamente, sem modificar diretamente outra linha de desenvolvimento.

**Explicação didática:**  
Branches no Git são leves. Criar uma branch não duplica necessariamente todos os arquivos; cria uma nova referência para o histórico.

**Exemplo prático:**  
Uma branch `feature/login` pode conter uma funcionalidade enquanto `main` permanece estável.

**Exemplo de código:**  
~~~bash
git switch -c feature/login
~~~

**Como o candidato deve responder:**  
Explique isolamento, colaboração e integração posterior.

**Resposta fraca ou incompleta:**  
“Branch é uma cópia completa do projeto.” Essa explicação é simplificada e pode induzir a uma compreensão incorreta.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como criar uma branch sem trocar para ela?
2. Quando uma branch deve ser removida?
3. O que deve ser considerado ao definir uma estratégia de branches?

---

## Pergunta 15 — Criar e trocar de branch

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Como você cria uma nova branch e passa a trabalhar nela?

**O que essa pergunta avalia:**  
Avalia o uso prático de branches.

**Resposta esperada:**  
Uma forma moderna é:

~~~bash
git switch -c feature/cadastro
~~~

Também existe a forma tradicional:

~~~bash
git checkout -b feature/cadastro
~~~

O primeiro comando cria e troca para a nova branch.

**Explicação didática:**  
`git switch` foi criado para deixar mais clara a operação relacionada a branches. `git checkout` continua sendo comum e também pode manipular arquivos.

**Exemplo prático:**  
Antes de começar uma tarefa, o desenvolvedor atualiza a branch base e cria uma branch de trabalho.

**Exemplo de código:**  
~~~bash
git switch main
git pull --ff-only
git switch -c feature/cadastro
~~~

**Como o candidato deve responder:**  
Mencione uma alternativa válida e explique que criar branch e trocar de branch são operações distintas, embora possam ser combinadas.

**Resposta fraca ou incompleta:**  
“Uso `git branch feature/cadastro` e já estou nela.” Esse comando cria a branch, mas não troca automaticamente para ela.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como verificar a branch atual?
2. Como criar a branch a partir de outro commit?
3. O que fazer se houver alterações não commitadas?

---

## Pergunta 16 — Listar branches

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Como você lista as branches locais e remotas de um repositório?

**O que essa pergunta avalia:**  
Avalia a navegação pelo repositório e a distinção entre referências locais e remotas.

**Resposta esperada:**  

~~~bash
git branch
git branch -r
git branch -a
~~~

`git branch` mostra branches locais, `-r` mostra referências remotas conhecidas e `-a` mostra ambas.

**Explicação didática:**  
Uma branch remota exibida localmente é uma referência ao estado conhecido do servidor; ela não é necessariamente uma branch local editável diretamente.

**Exemplo prático:**  
Depois de um `git fetch`, o desenvolvedor pode consultar `origin/main` antes de comparar sua branch.

**Exemplo de código:**  
~~~bash
git branch -vv
~~~

**Como o candidato deve responder:**  
Explique as diferenças entre local, remota e branch de acompanhamento.

**Resposta fraca ou incompleta:**  
“`git branch -r` troca para a branch remota.” Ele apenas lista referências remotas.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que significa `origin/main`?
2. Como saber se sua branch está à frente ou atrás do remoto?
3. Como excluir uma branch local?

---

## Pergunta 17 — Trocar de branch com alterações locais

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O que pode acontecer quando você tenta trocar de branch com alterações não commitadas?

**O que essa pergunta avalia:**  
Avalia a compreensão de conflitos entre alterações locais e o conteúdo da branch de destino.

**Resposta esperada:**  
Se as alterações não conflitarem com a branch de destino, o Git pode permitir a troca e carregá-las. Se houver risco de sobrescrever mudanças, o Git impedirá a operação. O desenvolvedor pode fazer commit, usar `git stash` ou descartar as alterações conscientemente.

**Explicação didática:**  
O Git evita perda acidental de trabalho. A decisão depende de preservar, registrar ou abandonar as alterações.

**Exemplo prático:**  
Para interromper uma tarefa sem criar commit incompleto:

~~~bash
git stash push -m "Trabalho temporário"
git switch outra-branch
git stash pop
~~~

**Exemplo de código:**  
O fluxo acima deve ser usado somente quando o trabalho puder ser armazenado temporariamente.

**Como o candidato deve responder:**  
Mencione as três opções: commit, stash ou descarte. Explique que descartar é irreversível em muitos casos.

**Resposta fraca ou incompleta:**  
“Pode trocar normalmente; o Git resolve tudo.” Isso ignora o risco de sobrescrever alterações.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando preferir `stash` em vez de commit?
2. Como recuperar um stash?
3. O que você faria antes de descartar alterações?

---

## Pergunta 18 — git stash

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Para que serve o `git stash` e quais cuidados você teria ao utilizá-lo?

**O que essa pergunta avalia:**  
Avalia a capacidade de armazenar temporariamente alterações não commitadas.

**Resposta esperada:**  
`git stash` guarda temporariamente alterações da área de trabalho e do staging, permitindo trocar de branch ou realizar outra tarefa sem criar um commit. Exemplos:

~~~bash
git stash push -m "Validação em andamento"
git stash list
git stash apply
git stash pop
~~~

`apply` aplica mantendo o stash; `pop` aplica e remove o stash se a operação for concluída.

**Explicação didática:**  
Stash não substitui commits nem deve ser usado como armazenamento permanente. A aplicação pode gerar conflitos.

**Exemplo prático:**  
Um desenvolvedor precisa corrigir urgentemente um bug em outra branch, mas ainda não terminou sua tarefa atual.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique propósito temporário, diferença entre `apply` e `pop` e risco de esquecer trabalho armazenado.

**Resposta fraca ou incompleta:**  
“Stash envia as alterações para o remoto.” Ele armazena alterações localmente.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como incluir arquivos não rastreados no stash?
2. Como remover um stash específico?
3. Como lidar com conflito ao aplicar um stash?

---

## Pergunta 19 — Repositório remoto

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é um repositório remoto e qual é a função do nome `origin`?

**O que essa pergunta avalia:**  
Avalia a compreensão de sincronização e nomenclatura de remotos.

**Resposta esperada:**  
Um repositório remoto é outro repositório Git usado para compartilhar commits. `origin` é apenas o nome padrão atribuído ao remoto principal quando um repositório é clonado. Ele pode ser alterado ou podem existir vários remotos.

**Explicação didática:**  
O remoto não precisa necessariamente estar em uma plataforma específica. Pode estar em um servidor interno, outro computador ou serviço de hospedagem.

**Exemplo prático:**  

~~~bash
git remote -v
git remote add origin https://exemplo.com/projeto.git
~~~

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique que `origin` é um apelido, não um comando nem um servidor fixo.

**Resposta fraca ou incompleta:**  
“Origin é o GitHub.” GitHub é uma possível hospedagem; `origin` é o nome do remoto.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. É possível ter dois remotos?
2. Qual a diferença entre URL de leitura e de escrita?
3. Como alterar a URL de um remoto?

---

## Pergunta 20 — git clone

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Como você obtém uma cópia local de um repositório remoto?

**O que essa pergunta avalia:**  
Avalia o uso básico de clonagem e preparação de um ambiente de trabalho.

**Resposta esperada:**  
Utiliza-se:

~~~bash
git clone https://exemplo.com/projeto.git
cd projeto
git status
~~~

O clone normalmente cria uma pasta, configura o remoto `origin`, baixa os objetos disponíveis e verifica a branch padrão.

**Explicação didática:**  
Clonar é diferente de executar `git init`: o clone parte de um repositório existente e traz seu histórico conhecido.

**Exemplo prático:**  
Um novo integrante da equipe clona o projeto antes de instalar dependências e executar os testes.

**Exemplo de código:**  
~~~bash
git clone https://exemplo.com/projeto.git projeto-local
~~~

**Como o candidato deve responder:**  
Mencione URL, pasta local, remoto configurado e verificação inicial.

**Resposta fraca ou incompleta:**  
“Faço download de um ZIP.” O ZIP não traz o histórico completo nem configura um repositório Git local.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como clonar apenas uma branch?
2. O que é um clone superficial?
3. Como verificar qual remoto foi configurado?

---

## Pergunta 21 — git fetch

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Qual é a diferença entre `git fetch` e `git pull`?

**O que essa pergunta avalia:**  
Avalia a compreensão de atualização das referências remotas e integração de mudanças.

**Resposta esperada:**  
`git fetch` baixa informações e commits do remoto, atualizando referências como `origin/main`, mas não altera automaticamente a branch atual. `git pull` normalmente executa um fetch e depois integra as mudanças, usando merge ou rebase conforme a configuração ou opção utilizada.

**Explicação didática:**  

~~~mermaid
flowchart LR
    A[Remoto] -->|fetch| B[Referências remotas]
    B -->|merge ou rebase| C[Branch local]
    A -->|pull| D[fetch + integração]
~~~

**Exemplo prático:**  
Use `fetch` para inspecionar mudanças antes de decidir como integrá-las.

**Exemplo de código:**  
~~~bash
git fetch origin
git log --oneline HEAD..origin/main
~~~

**Como o candidato deve responder:**  
Destaque que `fetch` é mais seguro para inspeção e que `pull` altera a branch de trabalho.

**Resposta fraca ou incompleta:**  
“São exatamente iguais.” `pull` inclui uma etapa de integração.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando você prefere `fetch`?
2. Que riscos existem em executar `pull` sem revisar mudanças?
3. Como comparar sua branch com `origin/main`?

---

## Pergunta 22 — git pull

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
O que acontece quando você executa `git pull`?

**O que essa pergunta avalia:**  
Avalia a compreensão do fluxo de atualização da branch local.

**Resposta esperada:**  
O comando normalmente busca alterações do remoto e integra a branch correspondente à branch atual. Essa integração pode ocorrer por merge ou rebase, conforme configuração e opções.

~~~bash
git pull origin main
git pull --rebase origin main
~~~

O candidato deve verificar o estado local e entender possíveis conflitos antes de executar.

**Explicação didática:**  
`pull` é conveniente, mas pode criar um merge automático ou iniciar um conflito. Em equipes, é importante conhecer a política adotada.

**Exemplo prático:**  
Antes de iniciar uma tarefa, o desenvolvedor pode atualizar a branch base para trabalhar sobre uma versão recente.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique fetch + integração e mencione merge, rebase e conflitos.

**Resposta fraca ou incompleta:**  
“Pull baixa arquivos novos.” Ele também pode alterar o histórico local.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre pull com merge e pull com rebase?
2. O que fazer se houver conflito?
3. Quando usar `git pull --ff-only`?

---

## Pergunta 23 — git push

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Como você envia commits locais para um repositório remoto?

**O que essa pergunta avalia:**  
Avalia sincronização, branches de acompanhamento e segurança ao publicar alterações.

**Resposta esperada:**  
Usa-se:

~~~bash
git push origin minha-branch
~~~

Na primeira publicação, pode ser necessário configurar o upstream:

~~~bash
git push -u origin minha-branch
~~~

Depois disso, `git push` pode ser suficiente.

**Explicação didática:**  
O push envia commits que o remoto ainda não possui. Ele pode ser rejeitado se o remoto tiver alterações que não estão localmente.

**Exemplo prático:**  
Após criar commits em `feature/pagamento`, o desenvolvedor faz push para abrir uma revisão.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Mencione remoto, branch, upstream e a possibilidade de rejeição por divergência.

**Resposta fraca ou incompleta:**  
“Push salva o commit.” O commit já foi salvo localmente; push o publica no remoto.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que um push pode ser rejeitado?
2. Qual o risco de `git push --force`?
3. O que significa configurar upstream?

---

## Pergunta 24 — Fast-forward

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é um fast-forward no Git?

**O que essa pergunta avalia:**  
Avalia a compreensão de uma integração linear sem criação de commit de merge.

**Resposta esperada:**  
Fast-forward ocorre quando a branch de destino pode simplesmente avançar seu ponteiro até um commit mais novo, porque não houve commits independentes na branch de destino.

~~~mermaid
gitGraph
   commit id: "A"
   commit id: "B"
   branch feature
   checkout feature
   commit id: "C"
   checkout main
   merge feature
~~~

Nesse caso, se `main` permaneceu em `B`, ela pode avançar até `C`.

**Explicação didática:**  
Nenhuma divergência precisa ser combinada. O histórico continua linear.

**Exemplo prático:**  
Uma branch local atualiza-se com `git pull --ff-only` quando não há commits locais conflitantes.

**Exemplo de código:**  
~~~bash
git merge --ff-only feature
~~~

**Como o candidato deve responder:**  
Explique avanço de referência e ausência de merge commit.

**Resposta fraca ou incompleta:**  
“Fast-forward é um merge mais rápido.” O ponto principal é a inexistência de divergência.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando fast-forward não é possível?
2. Qual a diferença entre `--ff-only` e `--no-ff`?
3. Por que uma equipe poderia exigir histórico linear?

---

## Pergunta 25 — Merge

**Nível:** Júnior  
**Categoria:** Integração

**Pergunta do entrevistador:**  
Como você integra uma branch de funcionalidade à branch principal usando merge?

**O que essa pergunta avalia:**  
Avalia a integração básica de branches.

**Resposta esperada:**  
Primeiro, deve-se trocar para a branch de destino e então executar o merge:

~~~bash
git switch main
git pull --ff-only
git merge feature/cadastro
~~~

Se as linhas divergirem, o Git poderá criar um commit de merge ou solicitar resolução de conflitos.

**Explicação didática:**  
O merge combina os históricos de duas linhas de desenvolvimento. A branch atual é a branch de destino.

**Exemplo prático:**  
Uma funcionalidade revisada pode ser integrada à `main` após testes e aprovação.

**Exemplo de código:**  
Não se aplica além do fluxo apresentado.

**Como o candidato deve responder:**  
Explique a importância de estar na branch correta e de validar a integração.

**Resposta fraca ou incompleta:**  
“Executaria `git merge main` estando na feature.” Isso faria a operação inversa da pretendida.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como você resolveria um conflito de merge?
2. Quando preferiria rebase?
3. O que deve ser testado depois da integração?

---

## Pergunta 26 — Conflito de merge

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O que é um conflito de merge e como você o resolveria?

**O que essa pergunta avalia:**  
Avalia a resolução segura de alterações incompatíveis.

**Resposta esperada:**  
O conflito ocorre quando o Git não consegue combinar automaticamente alterações concorrentes, normalmente nas mesmas linhas ou em arquivos relacionados. O fluxo é:

~~~bash
git status
# editar os arquivos conflitantes
git add arquivo-resolvido.js
git commit
~~~

Durante a resolução, é necessário analisar as alternativas, preservar o comportamento correto e executar testes.

**Explicação didática:**  
O Git marca os trechos com:

~~~text
<<<<<<< HEAD
conteúdo atual
=======
conteúdo da outra branch
>>>>>>> feature
~~~

O desenvolvedor deve remover os marcadores e manter a solução correta.

**Exemplo prático:**  
Duas pessoas alteraram a mesma validação de formulário de maneiras diferentes.

**Exemplo de código:**  
Não se deve escolher automaticamente um lado sem compreender a regra de negócio.

**Como o candidato deve responder:**  
Explique identificar, editar, adicionar, concluir e testar. Destaque que resolver conflito não é apenas fazer o código compilar.

**Resposta fraca ou incompleta:**  
“Escolho sempre a versão da minha branch.” Isso pode descartar uma correção importante.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como saber quais arquivos estão conflitantes?
2. Como abortar um merge em andamento?
3. Como validar que a resolução preservou os dois comportamentos?

---

## Pergunta 27 — Abortando um merge

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como você desfaz um merge que está em andamento, antes de concluí-lo?

**O que essa pergunta avalia:**  
Avalia a capacidade de retornar ao estado anterior sem concluir uma integração incorreta.

**Resposta esperada:**  
Se o merge ainda está em andamento, pode-se usar:

~~~bash
git merge --abort
~~~

Isso tenta restaurar o estado anterior ao início do merge. Antes de usar o comando, é importante verificar se havia alterações locais e se elas foram preservadas.

**Explicação didática:**  
Abortar é diferente de criar um commit que desfaz um merge já concluído. O comando só se aplica ao processo ainda aberto.

**Exemplo prático:**  
O conflito envolve regras que precisam ser discutidas com outro desenvolvedor, então a integração é interrompida.

**Exemplo de código:**  
Não se aplica além do comando apresentado.

**Como o candidato deve responder:**  
Diferencie merge em andamento de merge já finalizado e mencione `git status`.

**Resposta fraca ou incompleta:**  
“Uso `git reset --hard` sempre.” Isso pode apagar alterações locais sem necessidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como abortar um rebase?
2. O que fazer se `merge --abort` falhar?
3. Por que verificar alterações locais antes da operação?

---

## Pergunta 28 — Rebase

**Nível:** Júnior  
**Categoria:** Histórico

**Pergunta do entrevistador:**  
O que é rebase e em que situação simples ele pode ser utilizado?

**O que essa pergunta avalia:**  
Avalia a compreensão básica de reaplicação de commits sobre uma nova base.

**Resposta esperada:**  
Rebase move ou reaplica commits de uma branch sobre outro ponto do histórico. Um uso comum é atualizar uma branch de funcionalidade com a versão mais recente de `main`:

~~~bash
git switch feature/cadastro
git fetch origin
git rebase origin/main
~~~

Isso pode produzir um histórico linear, mas reescreve os commits reaplicados.

**Explicação didática:**  

~~~mermaid
gitGraph
   commit id: "A"
   commit id: "B"
   branch feature
   checkout feature
   commit id: "C"
   checkout main
   commit id: "D"
   checkout feature
   commit id: "C'"
~~~

O commit `C` é reaplicado sobre `D`, originando um novo commit, representado como `C'`.

**Exemplo prático:**  
Atualizar uma branch local antes de abrir uma revisão, quando a política da equipe permite rebase.

**Exemplo de código:**  
Não se aplica além do fluxo apresentado.

**Como o candidato deve responder:**  
Explique histórico linear e reescrita de commits. Deve mencionar que não se deve rebasear trabalho compartilhado sem coordenação.

**Resposta fraca ou incompleta:**  
“Rebase é igual a pull.” Rebase é uma estratégia de integração e pode alterar os hashes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que não rebasear uma branch pública?
2. Como continuar um rebase após resolver conflitos?
3. Qual a diferença entre merge e rebase?

---

## Pergunta 29 — Merge versus rebase

**Nível:** Júnior  
**Categoria:** Decisão técnica

**Pergunta do entrevistador:**  
Compare merge e rebase. Quais fatores você consideraria para escolher entre eles?

**O que essa pergunta avalia:**  
Avalia análise de trade-offs e entendimento de histórico.

**Resposta esperada:**  
Merge preserva a topologia do histórico e pode criar um commit de merge. Rebase reaplica commits sobre outra base e produz histórico mais linear, mas altera hashes. A escolha depende da política da equipe, do fato de a branch ser compartilhada e da necessidade de preservar o contexto da integração.

**Explicação didática:**  

~~~mermaid
flowchart TD
    A[Branches divergentes] --> B{Branch já compartilhada?}
    B -->|Sim| C[Preferir merge ou política explícita]
    B -->|Não| D[Rebase pode organizar histórico]
    C --> E[Testar e revisar]
    D --> E
~~~

**Exemplo prático:**  
Pode-se usar rebase em uma branch pessoal antes da revisão e merge na integração oficial.

**Exemplo de código:**  
Não existe uma escolha universal; o fluxo deve seguir o acordo do projeto.

**Como o candidato deve responder:**  
Compare preservação do histórico, linearidade, conflitos e risco de reescrita.

**Resposta fraca ou incompleta:**  
“Rebase é sempre melhor porque deixa tudo limpo.” Isso ignora colaboração e rastreabilidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Em que situação merge é preferível?
2. O que significa reescrever histórico?
3. Como a equipe deve documentar essa política?

---

## Pergunta 30 — Abortando um rebase

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como você interrompe um rebase que encontrou conflitos ou deixou de ser desejado?

**O que essa pergunta avalia:**  
Avalia a capacidade de controlar operações de histórico em andamento.

**Resposta esperada:**  
Durante um rebase, pode-se usar:

~~~bash
git rebase --abort
~~~

Isso tenta restaurar a branch ao estado anterior ao início do rebase. Se a intenção for prosseguir, resolve-se o conflito, executa-se `git add` e usa-se `git rebase --continue`.

**Explicação didática:**  
O Git mantém estado temporário da operação para permitir continuar ou abortar.

**Exemplo prático:**  
O rebase revelou muitos conflitos e a equipe decidiu integrar a branch usando merge.

**Exemplo de código:**  
~~~bash
git status
git rebase --abort
~~~

**Como o candidato deve responder:**  
Mencione `--abort`, `--continue` e a necessidade de examinar o estado atual.

**Resposta fraca ou incompleta:**  
“Fecho o terminal para cancelar.” A operação pode continuar registrada no repositório.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como pular um commit durante o rebase?
2. O que fazer depois de resolver um conflito?
3. Como identificar que há um rebase em andamento?

---

## Pergunta 31 — Reset

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Explique, em termos práticos, a diferença entre `git reset --soft`, `git reset` e `git reset --hard`.

**O que essa pergunta avalia:**  
Avalia segurança no uso de comandos que movem referências e alteram áreas do Git.

**Resposta esperada:**  
`--soft` move `HEAD`, mantendo alterações no staging. O reset padrão, normalmente `--mixed`, move `HEAD` e deixa as alterações na área de trabalho, removendo-as do staging. `--hard` também altera a área de trabalho, descartando alterações rastreadas até o commit indicado.

~~~bash
git reset --soft HEAD~1
git reset HEAD~1
git reset --hard HEAD~1
~~~

**Explicação didática:**  
O risco aumenta conforme mais áreas são alteradas. `--hard` deve ser usado apenas quando a perda das alterações for intencional.

**Exemplo prático:**  
Para corrigir a mensagem do último commit local, pode-se usar `git commit --amend`, sem recorrer imediatamente a `reset --hard`.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique impacto em HEAD, staging e working tree. Deve destacar risco de perda.

**Resposta fraca ou incompleta:**  
“Reset serve para apagar commits.” Isso é incompleto e perigoso.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando usar `git restore --staged` em vez de reset?
2. Por que `reset --hard` é perigoso?
3. O que muda se o commit já foi enviado ao remoto?

---

## Pergunta 32 — Restore

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Como você retira um arquivo do staging sem descartar sua alteração?

**O que essa pergunta avalia:**  
Avalia o uso de comandos modernos e seguros para manipular staging.

**Resposta esperada:**  
Pode-se usar:

~~~bash
git restore --staged arquivo.js
~~~

O arquivo deixa o staging, mas sua alteração permanece na área de trabalho.

**Explicação didática:**  
O comando separa claramente “tirar do próximo commit” de “descartar o conteúdo”. Para descartar alterações da área de trabalho, seria necessário outro uso, como `git restore arquivo.js`, que deve ser executado com cuidado.

**Exemplo prático:**  
Um arquivo foi adicionado por engano ao staging, mas a alteração ainda é necessária.

**Exemplo de código:**  
~~~bash
git restore --staged src/config.js
~~~

**Como o candidato deve responder:**  
Diferencie retirar do staging e apagar alterações.

**Resposta fraca ou incompleta:**  
“Uso `git restore arquivo.js`.” Sem `--staged`, isso pode descartar as alterações.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como descartar uma alteração local?
2. Como restaurar um arquivo de um commit específico?
3. Que cuidados devem ser tomados antes de restaurar?

---

## Pergunta 33 — Amend

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Quando você usaria `git commit --amend`?

**O que essa pergunta avalia:**  
Avalia correção de um commit local ainda não compartilhado.

**Resposta esperada:**  
`git commit --amend` substitui o último commit por outro, incluindo alterações adicionais ou uma nova mensagem:

~~~bash
git add arquivo-corrigido.js
git commit --amend
~~~

É adequado para corrigir um commit local. Como altera o hash, deve-se ter cuidado se ele já foi publicado.

**Explicação didática:**  
O Git cria um novo commit baseado no anterior, em vez de editar o objeto imutável original.

**Exemplo prático:**  
Adicionar ao último commit um teste esquecido ou corrigir uma mensagem pouco clara.

**Exemplo de código:**  
~~~bash
git commit --amend -m "Adiciona validação e testes do cadastro"
~~~

**Como o candidato deve responder:**  
Explique que é para o último commit e mencione o risco após push.

**Resposta fraca ou incompleta:**  
“Amend edita qualquer commit antigo.” O uso comum é modificar o commit mais recente.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que acontece se o commit já estiver no remoto?
2. Como alterar uma mensagem sem adicionar arquivos?
3. Qual a alternativa para reorganizar vários commits?

---

## Pergunta 34 — Revert

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Qual é a diferença entre `git revert` e `git reset`?

**O que essa pergunta avalia:**  
Avalia escolha segura entre desfazer uma alteração publicamente e reescrever histórico local.

**Resposta esperada:**  
`git revert` cria um novo commit que desfaz os efeitos de outro commit, preservando o histórico existente. `git reset` move uma referência para outro ponto e pode reescrever o histórico local. Para commits já compartilhados, revert costuma ser mais seguro.

~~~bash
git revert <hash-do-commit>
~~~

**Explicação didática:**  
Revert registra explicitamente que uma mudança anterior foi desfeita. Reset pode fazer um commit parecer ausente da linha atual.

**Exemplo prático:**  
Uma funcionalidade enviada para `main` causou problema e precisa ser desativada sem remover o histórico da publicação.

**Exemplo de código:**  
Não se aplica além do comando apresentado.

**Como o candidato deve responder:**  
Compare preservação do histórico, colaboração e momento de uso.

**Resposta fraca ou incompleta:**  
“Revert apaga o commit.” Ele cria outro commit com efeito inverso.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Em que situação reset pode ser adequado?
2. Como reverter um merge?
3. O que você validaria depois de um revert?

---

## Pergunta 35 — Revertendo um merge

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como você lidaria com a necessidade de desfazer um merge já concluído?

**O que essa pergunta avalia:**  
Avalia segurança ao desfazer integrações que podem ter mais de um pai.

**Resposta esperada:**  
Para desfazer um merge publicado, normalmente usa-se `git revert` informando o pai principal com `-m`, depois de identificar corretamente a situação:

~~~bash
git log --graph --oneline
git revert -m 1 <hash-do-merge>
~~~

O significado de `-m 1` depende de qual pai representa a linha principal. Depois, deve-se testar a reversão.

**Explicação didática:**  
Um merge possui dois ou mais pais. O Git precisa saber qual linha deve ser considerada como principal para calcular o efeito inverso.

**Exemplo prático:**  
Uma integração em `main` introduziu regressões e deve ser revertida enquanto a correção é preparada.

**Exemplo de código:**  
O hash e o pai devem ser confirmados antes da execução.

**Como o candidato deve responder:**  
Explique que merge revert não é igual a reverter um commit comum e que testes são obrigatórios.

**Resposta fraca ou incompleta:**  
“Uso `git revert` sem opções.” Pode não ser suficiente para um merge.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como identificar o pai principal?
2. Quais testes devem ser executados?
3. O que muda ao tentar integrar novamente a mesma branch?

---

## Pergunta 36 — Detached HEAD

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O que significa estar em estado de detached HEAD?

**O que essa pergunta avalia:**  
Avalia compreensão de referências e prevenção de perda de commits.

**Resposta esperada:**  
Detached HEAD ocorre quando `HEAD` aponta diretamente para um commit, tag ou referência que não é uma branch local. É possível inspecionar ou testar o estado, mas commits feitos ali podem ficar sem uma branch apontando para eles.

~~~bash
git switch --detach <commit>
~~~

Para preservar trabalho criado nesse estado, deve-se criar uma branch:

~~~bash
git switch -c recupera-trabalho
~~~

**Explicação didática:**  
O commit não desaparece imediatamente, mas pode se tornar difícil de encontrar depois se não houver uma referência.

**Exemplo prático:**  
Verificar como o sistema funcionava em uma versão marcada por tag.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique HEAD direto no commit e como criar uma branch para preservar alterações.

**Resposta fraca ou incompleta:**  
“Detached HEAD significa que o repositório está quebrado.”

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como sair desse estado?
2. Como recuperar um commit feito em detached HEAD?
3. Em que situação ele pode ser útil?

---

## Pergunta 37 — Tag

**Nível:** Júnior  
**Categoria:** Releases

**Pergunta do entrevistador:**  
O que é uma tag no Git e para que ela pode ser usada?

**O que essa pergunta avalia:**  
Avalia versionamento de releases e referências imutáveis por convenção.

**Resposta esperada:**  
Tag é uma referência nomeada para um commit específico. Pode marcar versões, releases ou pontos importantes do histórico.

~~~bash
git tag v1.0.0
git push origin v1.0.0
~~~

Tags anotadas podem conter autor, data e mensagem:

~~~bash
git tag -a v1.0.0 -m "Release 1.0.0"
~~~

**Explicação didática:**  
Uma tag ajuda a localizar exatamente o código correspondente a uma versão publicada.

**Exemplo prático:**  
A equipe marca `v2.3.1` no commit implantado em produção.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique referência nomeada, releases e diferença entre tag simples e anotada.

**Resposta fraca ou incompleta:**  
“Tag é uma branch que muda automaticamente.” Tag normalmente marca um ponto específico.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre tag e branch?
2. Como listar tags?
3. Por que tags devem ser protegidas em um ambiente de release?

---

## Pergunta 38 — Git log e investigação

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Um comportamento funcionava há duas semanas e agora apresenta erro. Como você usaria o histórico do Git para investigar?

**O que essa pergunta avalia:**  
Avalia investigação baseada em evidências.

**Resposta esperada:**  
Eu identificaria a última versão conhecida como correta e compararia com a atual. Usaria `git log`, `git diff`, `git show` e, se necessário, `git blame` para localizar alterações relevantes. Também reproduziria o problema e validaria hipóteses com testes.

~~~bash
git log --oneline -- src/
git diff <commit-bom>..<commit-atual> -- src/
git show <hash>
~~~

**Explicação didática:**  
O histórico ajuda a reduzir o espaço de investigação, mas não substitui testes ou entendimento do comportamento.

**Exemplo prático:**  
Uma alteração recente em um parser pode ser comparada com o estado anterior.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Descreva uma investigação progressiva e evite afirmar que o primeiro commit recente é necessariamente a causa.

**Resposta fraca ou incompleta:**  
“Eu apagaria os commits recentes.” Isso destrói evidências e não identifica a causa.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como pesquisar commits por mensagem?
2. Como comparar apenas um arquivo?
3. Quando `git bisect` seria útil?

---

## Pergunta 39 — git show

**Nível:** Júnior  
**Categoria:** Investigação

**Pergunta do entrevistador:**  
Como você examina o conteúdo de um commit específico?

**O que essa pergunta avalia:**  
Avalia leitura de alterações e metadados históricos.

**Resposta esperada:**  
Usa-se:

~~~bash
git show <hash>
~~~

O comando exibe metadados e o diff do commit. É possível limitar a um arquivo:

~~~bash
git show <hash> -- src/arquivo.js
~~~

**Explicação didática:**  
O hash identifica o commit. O diff mostra o que foi adicionado e removido.

**Exemplo prático:**  
Antes de reverter uma alteração, o desenvolvedor examina exatamente o que ela modificou.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Mencione hash, mensagem e diff.

**Resposta fraca ou incompleta:**  
“Uso `git log` e vejo apenas a mensagem.” Isso não mostra necessariamente o conteúdo detalhado.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como visualizar apenas o nome dos arquivos modificados?
2. Como comparar dois commits?
3. Como encontrar o hash de um commit?

---

## Pergunta 40 — git blame

**Nível:** Júnior  
**Categoria:** Investigação

**Pergunta do entrevistador:**  
Para que serve o `git blame` e como você o usaria corretamente?

**O que essa pergunta avalia:**  
Avalia investigação da origem de linhas e postura colaborativa.

**Resposta esperada:**  
`git blame` mostra, para cada linha, o commit e o autor que a modificou por último:

~~~bash
git blame src/servico.js
git blame -L 20,40 src/servico.js
~~~

Ele deve ser usado para encontrar contexto histórico, não para culpar pessoas.

**Explicação didática:**  
A pessoa exibida pode ter apenas copiado o código ou aplicado uma alteração solicitada. O commit associado é o principal ponto de investigação.

**Exemplo prático:**  
Depois de localizar a linha, uso `git show <hash>` para entender por que ela foi introduzida.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique origem da linha, contexto do commit e uso colaborativo.

**Resposta fraca ou incompleta:**  
“Serve para descobrir quem fez algo errado.” Isso transforma uma ferramenta técnica em instrumento de culpabilização.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O `blame` identifica necessariamente a pessoa que criou a lógica?
2. Como investigar a intenção da alteração?
3. Que alternativa existe para código gerado?

---

## Pergunta 41 — git bisect

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como o `git bisect` pode ajudar a localizar o commit que introduziu um problema?

**O que essa pergunta avalia:**  
Avalia depuração histórica orientada por busca binária.

**Resposta esperada:**  
`git bisect` divide o histórico sucessivamente entre versões boas e ruins até encontrar o primeiro commit problemático:

~~~bash
git bisect start
git bisect bad
git bisect good <commit-conhecidamente-bom>
# executar o teste
git bisect good
# ou
git bisect bad
git bisect reset
~~~

**Explicação didática:**  
Em vez de testar todos os commits, o Git reduz o conjunto pela metade a cada etapa.

**Exemplo prático:**  
Um bug surgiu em algum momento entre duas releases, mas não se sabe qual alteração o causou.

**Exemplo de código:**  
O processo pode ser automatizado se existir um teste confiável.

**Como o candidato deve responder:**  
Explique versão boa, versão ruim, teste repetido e encerramento com `bisect reset`.

**Resposta fraca ou incompleta:**  
“Bisect compara duas branches.” Ele procura um commit problemático no histórico.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que torna um teste adequado para bisect?
2. Como automatizar a classificação?
3. O que fazer se o commit encontrado apenas revelar o problema parcialmente?

---

## Pergunta 42 — Alias

**Nível:** Júnior  
**Categoria:** Produtividade

**Pergunta do entrevistador:**  
O que é um alias do Git e quando ele pode ser útil?

**O que essa pergunta avalia:**  
Avalia produtividade e padronização de comandos recorrentes.

**Resposta esperada:**  
Alias é um atalho configurado para um comando ou sequência de comandos. Por exemplo:

~~~bash
git config --global alias.lg "log --oneline --graph --decorate --all"
git lg
~~~

Ele é útil para comandos longos e repetitivos, desde que os atalhos sejam compreensíveis para a equipe.

**Explicação didática:**  
Aliases não criam novos recursos do Git; apenas reduzem digitação.

**Exemplo prático:**  
Um alias para visualizar o histórico gráfico pode facilitar diagnósticos.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique finalidade, escopo local/global e cuidado para não criar atalhos obscuros.

**Resposta fraca ou incompleta:**  
“Alias é uma branch curta.” São conceitos diferentes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre configuração local e global?
2. Por que aliases complexos podem dificultar suporte?
3. Como listar configurações existentes?

---

## Pergunta 43 — Configuração do Git

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Como você configura seu nome e e-mail no Git?

**O que essa pergunta avalia:**  
Avalia configuração de identidade para autoria dos commits.

**Resposta esperada:**  
Para configurar globalmente:

~~~bash
git config --global user.name "Nome da Pessoa"
git config --global user.email "pessoa@exemplo.com"
~~~

Para configurar apenas no repositório atual, omite-se `--global`.

~~~bash
git config user.name "Nome do Projeto"
~~~

**Explicação didática:**  
A identidade é gravada nos commits. Ela não é necessariamente o mesmo mecanismo usado para autenticar no servidor remoto.

**Exemplo prático:**  
Um desenvolvedor pode usar uma identidade profissional em repositórios de trabalho e outra em projetos pessoais, conforme a política aplicável.

**Exemplo de código:**  
~~~bash
git config --list
~~~

**Como o candidato deve responder:**  
Mencione configuração global, local e diferença entre autoria e autenticação.

**Resposta fraca ou incompleta:**  
“Configuro a senha do Git pelo `user.email`.” Esses campos não armazenam senha.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre identidade e autenticação?
2. Como verificar a configuração efetiva?
3. Por que o e-mail do commit pode ser relevante?

---

## Pergunta 44 — Autenticação no remoto

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Quais são formas comuns de autenticar ao acessar um repositório remoto e quais cuidados de segurança você adotaria?

**O que essa pergunta avalia:**  
Avalia noções de autenticação e proteção de credenciais.

**Resposta esperada:**  
Podem ser usados HTTPS com token, SSH com chave ou mecanismos definidos pela plataforma. Nunca se deve colocar senha ou token diretamente em scripts, commits ou URLs compartilhadas. Chaves e tokens devem ter escopo mínimo, proteção adequada e rotação quando necessário.

**Explicação didática:**  
Autenticação prova quem está acessando; autorização define o que essa identidade pode fazer.

**Exemplo prático:**  
Para automação, usar um token limitado ou identidade de serviço em vez de uma credencial pessoal ampla.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Diferencie HTTPS/SSH, mencione segredo fora do código e princípio do menor privilégio.

**Resposta fraca ou incompleta:**  
“Salvo o token no repositório privado.” Repositório privado não elimina todos os riscos.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que fazer se uma chave for exposta?
2. Por que usar escopo mínimo?
3. Como evitar segredos no histórico?

---

## Pergunta 45 — Segredo commitado

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Você percebe que uma chave de API foi commitada e enviada ao remoto. O que faria?

**O que essa pergunta avalia:**  
Avalia resposta a incidente de segurança e compreensão de que apagar o arquivo não basta.

**Resposta esperada:**  
Primeiro, revogaria ou rotacionaria imediatamente a chave, pois ela deve ser considerada comprometida. Depois, removeria o segredo do código, adicionaria proteção como `.gitignore` e corrigiria o histórico conforme a política da equipe. Também verificaria acessos e notificaria as pessoas responsáveis.

**Explicação didática:**  
Mesmo que o arquivo seja apagado em um novo commit, o segredo continua nos commits anteriores. A limpeza do histórico pode exigir ferramentas específicas e coordenação.

**Exemplo prático:**  
Substituir o valor por uma variável de ambiente e disponibilizar apenas um exemplo sem segredo.

**Exemplo de código:**  
~~~text
API_KEY=<configurada-fora-do-repositório>
~~~

**Como o candidato deve responder:**  
Priorize revogação, contenção, remoção e investigação. Não diga apenas “apago o arquivo”.

**Resposta fraca ou incompleta:**  
“Faço outro commit removendo a chave.” Isso não invalida a credencial nem remove seu histórico.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que rotacionar antes de limpar o histórico?
2. Quem deve ser informado?
3. Como evitar que o problema se repita?

---

## Pergunta 46 — Arquivos já rastreados no .gitignore

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Você adicionou um arquivo ao `.gitignore`, mas o Git continua mostrando alterações nele. Por quê?

**O que essa pergunta avalia:**  
Avalia a distinção entre ignorar arquivos novos e deixar de rastrear arquivos existentes.

**Resposta esperada:**  
`.gitignore` afeta arquivos não rastreados. Se o arquivo já foi commitado, ele continua sendo rastreado. Para removê-lo do índice sem apagar a cópia local:

~~~bash
git rm --cached arquivo.env
git commit -m "Deixa arquivo local fora do versionamento"
~~~

**Explicação didática:**  
O índice contém a lista de arquivos rastreados. O `.gitignore` não remove automaticamente entradas que já estão no histórico.

**Exemplo prático:**  
Remover um arquivo de configuração local do índice e manter um arquivo de exemplo versionado.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique rastreamento existente, `git rm --cached` e necessidade de avaliar segredos.

**Resposta fraca ou incompleta:**  
“Reinicio o Git.” O problema é conceitual, não de reinicialização.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. A cópia local será apagada?
2. Como remover uma pasta inteira do índice?
3. O comando remove o arquivo dos commits antigos?

---

## Pergunta 47 — git clean

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Para que serve `git clean` e por que ele exige cuidado?

**O que essa pergunta avalia:**  
Avalia gerenciamento de arquivos não rastreados e prevenção de perda.

**Resposta esperada:**  
`git clean` remove arquivos não rastreados da área de trabalho. Deve-se primeiro simular a operação:

~~~bash
git clean -n
~~~

Depois, se estiver seguro:

~~~bash
git clean -f
~~~

Pastas podem exigir `-d`. O comando não deve ser usado sem revisar a lista.

**Explicação didática:**  
Arquivos não rastreados não estão protegidos pelo histórico do Git. A remoção pode ser difícil ou impossível de recuperar.

**Exemplo prático:**  
Limpar artefatos gerados localmente antes de reproduzir um build limpo.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Mencione prévia com `-n`, risco e distinção entre arquivos rastreados e não rastreados.

**Resposta fraca ou incompleta:**  
“Uso `git clean -fd` sempre que há arquivos extras.” Isso pode apagar trabalho válido.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre `-n` e `-f`?
2. Como remover apenas determinados padrões?
3. Por que confirmar o status antes?

---

## Pergunta 48 — Commit parcial

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Você alterou duas funcionalidades no mesmo arquivo. Como criaria commits separados?

**O que essa pergunta avalia:**  
Avalia organização de histórico e uso seletivo do staging.

**Resposta esperada:**  
Usaria `git add -p` para selecionar os trechos relacionados à primeira funcionalidade, criaria o commit e depois repetiria para os demais trechos:

~~~bash
git add -p src/servico.js
git commit -m "Corrige cálculo do frete"
git add -p src/servico.js
git commit -m "Adiciona validação de endereço"
~~~

Também poderia separar as alterações manualmente, se isso fosse mais seguro.

**Explicação didática:**  
Commits coesos facilitam revisão, reversão e investigação.

**Exemplo prático:**  
Uma correção urgente pode ser publicada sem incluir uma refatoração experimental.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique seleção de hunks e a necessidade de revisar o diff de cada commit.

**Resposta fraca ou incompleta:**  
“Faço um commit com tudo e explico na mensagem.” Isso dificulta manutenção.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como verificar o conteúdo de cada commit?
2. Quando não vale a pena separar?
3. O que fazer se os trechos estiverem muito interdependentes?

---

## Pergunta 49 — Commit vazio

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Um commit pode ser vazio? Em que situação isso poderia ser útil?

**O que essa pergunta avalia:**  
Avalia conhecimento de casos especiais e uso consciente de histórico.

**Resposta esperada:**  
Sim. Pode-se criar um commit vazio com:

~~~bash
git commit --allow-empty -m "Dispara validação do pipeline"
~~~

Pode ser útil para acionar uma automação que depende de um novo commit, embora a equipe deva preferir mecanismos explícitos quando disponíveis.

**Explicação didática:**  
O commit não precisa necessariamente conter alteração de arquivo. Ele registra uma intenção ou evento no histórico.

**Exemplo prático:**  
Reexecutar um pipeline que é disparado por commits.

**Exemplo de código:**  
Não se aplica além do comando apresentado.

**Como o candidato deve responder:**  
Dê um caso justificável e mencione que commits vazios em excesso poluem o histórico.

**Resposta fraca ou incompleta:**  
“Commit vazio é um erro.” Ele pode ser intencional.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que alternativa existe para disparar um pipeline?
2. Como identificar commits vazios?
3. Quando um commit vazio prejudica a rastreabilidade?

---

## Pergunta 50 — Branch principal

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Qual é a finalidade de uma branch como `main` e por que ela não deve ser tratada automaticamente como “a única branch importante”?

**O que essa pergunta avalia:**  
Avalia compreensão de convenções e fluxo de colaboração.

**Resposta esperada:**  
`main` normalmente representa uma linha principal, estável ou pronta para integração, mas seu significado depende da política do projeto. Branches de funcionalidade, correção e release podem existir para isolar mudanças e facilitar revisão.

**Explicação didática:**  
O nome `main` é uma convenção, não uma regra técnica do Git. Projetos podem adotar fluxos diferentes.

**Exemplo prático:**  
A equipe pode exigir pull requests e testes antes de aceitar alterações em `main`.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Evite afirmar que todo projeto usa o mesmo modelo. Explique estabilidade, revisão e políticas.

**Resposta fraca ou incompleta:**  
“Main é onde qualquer pessoa envia diretamente.” Isso ignora controles de qualidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que proteger a branch principal?
2. O que é uma branch de release?
3. Como evitar trabalho direto em `main`?

---

## Pergunta 51 — Fluxo de feature branch

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Descreva um fluxo simples para implementar uma funcionalidade usando uma feature branch.

**O que essa pergunta avalia:**  
Avalia organização do trabalho do início à integração.

**Resposta esperada:**  

~~~mermaid
flowchart TD
    A[Atualizar main] --> B[Criar feature branch]
    B --> C[Implementar e testar]
    C --> D[Criar commits]
    D --> E[Enviar branch]
    E --> F[Revisão]
    F --> G[Integrar em main]
~~~

Um fluxo possível é atualizar a base, criar branch, implementar, testar, criar commits coesos, enviar a branch e solicitar revisão.

**Explicação didática:**  
O fluxo reduz o risco de misturar trabalhos e permite revisão antes da integração.

**Exemplo prático:**  
`feature/cadastro-usuario` contém somente a funcionalidade de cadastro.

**Exemplo de código:**  
~~~bash
git switch main
git pull --ff-only
git switch -c feature/cadastro-usuario
~~~

**Como o candidato deve responder:**  
Organize a resposta em sequência e mencione testes e revisão.

**Resposta fraca ou incompleta:**  
“Faço tudo em main e aviso depois.” Isso reduz rastreabilidade e controle.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando atualizar a branch base?
2. Como manter a feature branch atualizada?
3. O que você faria se a revisão solicitasse mudanças?

---

## Pergunta 52 — Branch de correção urgente

**Nível:** Júnior  
**Categoria:** Cenário real

**Pergunta do entrevistador:**  
Um erro crítico foi identificado em produção enquanto você trabalha em uma funcionalidade incompleta. Como organizaria o trabalho com Git?

**O que essa pergunta avalia:**  
Avalia isolamento de trabalho e priorização operacional.

**Resposta esperada:**  
Eu preservaria o trabalho atual com commit ou stash, partiria de uma base adequada para a correção, criaria uma branch específica, corrigiria e testaria o problema, enviaria a alteração para revisão e depois integraria conforme o fluxo da equipe.

**Explicação didática:**  
Misturar a correção urgente com uma funcionalidade incompleta aumenta o risco de publicar código não relacionado.

**Exemplo prático:**  
`hotfix/calculo-imposto` deve conter apenas a correção do incidente.

**Exemplo de código:**  
~~~bash
git stash push -m "Feature incompleta"
git switch main
git pull --ff-only
git switch -c hotfix/calculo-imposto
~~~

**Como o candidato deve responder:**  
Demonstre isolamento, preservação do trabalho, testes e comunicação.

**Resposta fraca ou incompleta:**  
“Continuo na mesma branch e faço push de tudo.” Isso aumenta o risco de regressão.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. De qual commit a branch de correção deveria partir?
2. Como garantir que a correção também chegue à linha de desenvolvimento?
3. Quais verificações faria antes da publicação?

---

## Pergunta 53 — Repositório limpo

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
O que significa dizer que o repositório está “limpo”?

**O que essa pergunta avalia:**  
Avalia leitura do estado do Git e preparação para operações.

**Resposta esperada:**  
Normalmente significa que não há alterações pendentes na área de trabalho ou no staging e que o estado relevante está conhecido. `git status` ajuda a verificar isso.

~~~bash
git status
~~~

Um repositório limpo não garante que o código esteja correto ou que esteja atualizado em relação ao remoto.

**Explicação didática:**  
“Limpo” é uma condição do estado de versionamento, não uma garantia de qualidade funcional.

**Exemplo prático:**  
Antes de trocar de branch ou iniciar um rebase, confirmar que alterações locais foram preservadas.

**Exemplo de código:**  
Não se aplica além do comando apresentado.

**Como o candidato deve responder:**  
Diferencie ausência de alterações locais de testes aprovados ou sincronização.

**Resposta fraca ou incompleta:**  
“Limpo significa que não existem bugs.” O status do Git não avalia bugs.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como verificar se há commits não enviados?
2. Um repositório limpo pode estar desatualizado?
3. Por que a condição é útil antes de operações arriscadas?

---

## Pergunta 54 — Branch à frente e atrás

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O que significa uma branch estar “ahead” ou “behind” em relação ao remoto?

**O que essa pergunta avalia:**  
Avalia compreensão de divergência entre histórico local e remoto.

**Resposta esperada:**  
“Ahead” significa que a branch local possui commits que o remoto ainda não tem, normalmente resolvido com push. “Behind” significa que o remoto possui commits ausentes localmente, normalmente exigindo fetch e integração. Ela pode estar simultaneamente ahead e behind, indicando divergência.

**Explicação didática:**  

~~~mermaid
flowchart LR
    A[Local] -->|commits exclusivos| B[Ahead]
    C[Remoto] -->|commits exclusivos| D[Behind]
    A -.-> E[Divergência]
    C -.-> E
~~~

**Exemplo prático:**  
Antes de fazer push, verificar se outra pessoa publicou alterações.

**Exemplo de código:**  
~~~bash
git fetch origin
git status
git log --oneline HEAD..origin/main
git log --oneline origin/main..HEAD
~~~

**Como o candidato deve responder:**  
Explique direção dos commits e que fetch atualiza as referências conhecidas.

**Resposta fraca ou incompleta:**  
“Ahead significa código melhor.” É apenas uma relação de histórico.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que fazer quando a branch está ahead e behind?
2. Como evitar sobrescrever commits de outra pessoa?
3. Qual a utilidade de `--ff-only`?

---

## Pergunta 55 — Push rejeitado

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Seu `git push` foi rejeitado porque o remoto contém trabalho que você não possui. Como investigaria e resolveria?

**O que essa pergunta avalia:**  
Avalia sincronização e prevenção de sobrescrita de trabalho.

**Resposta esperada:**  
Eu faria fetch, examinaria a divergência e integraria as mudanças conforme a política da equipe:

~~~bash
git fetch origin
git log --oneline --graph HEAD..origin/minha-branch
git log --oneline --graph origin/minha-branch..HEAD
~~~

Depois poderia usar merge ou rebase, resolver conflitos, testar e tentar o push novamente.

**Explicação didática:**  
O remoto rejeita o push para evitar que commits existentes sejam ignorados ou sobrescritos.

**Exemplo prático:**  
Outra pessoa publicou uma alteração na mesma branch desde o último pull.

**Exemplo de código:**  
Não se deve começar usando force push sem entender a divergência.

**Como o candidato deve responder:**  
Mencione fetch, inspeção, integração e testes.

**Resposta fraca ou incompleta:**  
“Uso `git push --force`.” Isso pode apagar ou substituir trabalho remoto.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando force push poderia ser aceitável?
2. Qual a diferença entre `--force` e `--force-with-lease`?
3. Como resolveria um conflito após a integração?

---

## Pergunta 56 — Force push

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Por que `git push --force` é perigoso?

**O que essa pergunta avalia:**  
Avalia riscos de reescrita do histórico remoto.

**Resposta esperada:**  
Force push pode substituir a referência remota por uma versão local e fazer commits de outras pessoas deixarem de estar acessíveis pela branch. Deve ser evitado em branches compartilhadas. Quando realmente necessário, `--force-with-lease` oferece uma proteção adicional ao verificar se o remoto está no estado esperado.

**Explicação didática:**  
Reescrever histórico compartilhado obriga outras pessoas a reconciliar seus clones e pode causar perda operacional.

**Exemplo prático:**  
Depois de um rebase em uma branch pessoal publicada, a equipe pode permitir `--force-with-lease` se ninguém mais trabalha nela.

**Exemplo de código:**  
~~~bash
git push --force-with-lease origin minha-branch
~~~

**Como o candidato deve responder:**  
Explique sobrescrita, colaboração e alternativa mais segura.

**Resposta fraca ou incompleta:**  
“É perigoso porque pode dar erro.” O risco principal é substituir histórico remoto.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como confirmar se uma branch é pessoal?
2. O que `--force-with-lease` verifica?
3. Como recuperar uma branch sobrescrita?

---

## Pergunta 57 — Recuperação com reflog

**Nível:** Júnior  
**Categoria:** Recuperação

**Pergunta do entrevistador:**  
Você executou um reset e aparentemente perdeu commits locais. Como tentaria recuperá-los?

**O que essa pergunta avalia:**  
Avalia conhecimento de referências locais e recuperação de operações recentes.

**Resposta esperada:**  
Usaria o reflog para localizar estados anteriores de `HEAD`:

~~~bash
git reflog
git show <hash-encontrado>
git switch -c recuperacao <hash-encontrado>
~~~

O reflog registra movimentos recentes de referências locais. A recuperação depende de o objeto ainda estar disponível e de não ter passado tempo suficiente para limpeza.

**Explicação didática:**  
Um commit pode não aparecer mais na branch, mas ainda existir no repositório local.

**Exemplo prático:**  
Após `reset --hard`, identificar o `HEAD` anterior e criar uma branch de recuperação.

**Exemplo de código:**  
Não se aplica além do fluxo apresentado.

**Como o candidato deve responder:**  
Explique reflog, identificação do estado correto e criação de uma referência para preservá-lo.

**Resposta fraca ou incompleta:**  
“Restauro da lixeira do sistema.” Commits são objetos do repositório, não arquivos comuns.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O reflog é normalmente compartilhado com o remoto?
2. Como confirmar que o commit recuperado é o correto?
3. Por que criar uma branch após encontrá-lo?

---

## Pergunta 58 — Recuperação de arquivo

**Nível:** Júnior  
**Categoria:** Recuperação

**Pergunta do entrevistador:**  
Como restaurar um arquivo para a versão presente em um commit específico?

**O que essa pergunta avalia:**  
Avalia recuperação seletiva sem alterar todo o projeto.

**Resposta esperada:**  
Pode-se usar:

~~~bash
git restore --source=<commit> -- caminho/arquivo.js
~~~

Depois, deve-se revisar o diff e decidir se a restauração será commitada.

**Explicação didática:**  
A operação copia o conteúdo daquele commit para a área de trabalho. Ela não cria automaticamente um commit nem deve ser confundida com apagar o arquivo.

**Exemplo prático:**  
Recuperar uma implementação anterior de um arquivo para comparar ou corrigir uma regressão.

**Exemplo de código:**  
Não se aplica além do comando apresentado.

**Como o candidato deve responder:**  
Mencione fonte, arquivo específico, revisão e commit posterior.

**Resposta fraca ou incompleta:**  
“Faço checkout do commit inteiro.” Isso pode trocar o estado de todo o repositório.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como restaurar apenas um arquivo do staging?
2. Como comparar antes de substituir?
3. Que risco existe em sobrescrever alterações locais?

---

## Pergunta 59 — Git e arquivos binários

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Quais cuidados devem ser considerados ao versionar arquivos binários no Git?

**O que essa pergunta avalia:**  
Avalia limitações de diff, tamanho de repositório e adequação do conteúdo.

**Resposta esperada:**  
Arquivos binários não oferecem diffs textuais úteis e podem aumentar muito o tamanho do repositório. Deve-se avaliar se precisam ser versionados, usar armazenamento apropriado ou Git LFS quando adotado pela equipe, e evitar inserir artefatos gerados sem necessidade.

**Explicação didática:**  
O Git funciona muito bem com texto. Binários grandes podem tornar clones e operações mais lentos.

**Exemplo prático:**  
Imagens pequenas necessárias ao produto podem ser versionadas, enquanto vídeos grandes e builds podem ir para armazenamento de artefatos.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Demonstre análise de tamanho, necessidade, histórico e estratégia de armazenamento.

**Resposta fraca ou incompleta:**  
“Git não aceita binários.” Ele aceita, mas o gerenciamento pode ser inadequado.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que um binário grande pode afetar o histórico?
2. O que é Git LFS?
3. Como remover um artefato grande que já foi publicado?

---

## Pergunta 60 — Submódulos

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é um submódulo Git e em que situação simples ele pode ser usado?

**O que essa pergunta avalia:**  
Avalia conhecimento básico de repositórios aninhados e dependências versionadas.

**Resposta esperada:**  
Submódulo permite incluir outro repositório dentro de um repositório principal, fixando-o em um commit específico. Pode ser usado quando uma dependência precisa permanecer em outro ciclo de versionamento, embora traga complexidade operacional.

**Explicação didática:**  
O repositório principal registra a URL e o commit do submódulo, não todo o conteúdo como commits próprios.

**Exemplo prático:**  
Compartilhar uma biblioteca interna que possui ciclo de release independente.

**Exemplo de código:**  
~~~bash
git submodule add https://exemplo.com/biblioteca.git libs/biblioteca
git submodule update --init --recursive
~~~

**Como o candidato deve responder:**  
Explique commit fixado, atualização explícita e custos de uso.

**Resposta fraca ou incompleta:**  
“Submódulo é apenas uma pasta normal.” Ele possui outro repositório e estado independente.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como clonar um projeto com submódulos?
2. Quais dificuldades submódulos podem causar?
3. Quando uma dependência de pacote seria melhor?

---

## Pergunta 61 — Repositório monorepo

**Nível:** Júnior  
**Categoria:** Organização

**Pergunta do entrevistador:**  
O que é um monorepo e que relação ele pode ter com o uso do Git?

**O que essa pergunta avalia:**  
Avalia compreensão de organização de múltiplos projetos em um repositório.

**Resposta esperada:**  
Monorepo é uma estratégia em que vários projetos ou componentes são mantidos em um único repositório. O Git pode gerenciar o histórico conjunto, mas a equipe precisa definir organização, permissões, automações e estratégias para evitar builds desnecessários.

**Explicação didática:**  
Monorepo não é um recurso específico do Git; é uma decisão de organização.

**Exemplo prático:**  
Aplicação web, serviço de autenticação e bibliotecas compartilhadas no mesmo repositório.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Explique benefícios e desafios sem afirmar que monorepo é sempre superior.

**Resposta fraca ou incompleta:**  
“Monorepo é um repositório com uma única branch.” São conceitos diferentes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual impacto no tempo de clone?
2. Como limitar o escopo dos testes?
3. Quando múltiplos repositórios seriam preferíveis?

---

## Pergunta 62 — Git hooks

**Nível:** Júnior  
**Categoria:** Automação

**Pergunta do entrevistador:**  
O que são Git hooks e como eles podem ser usados em um projeto?

**O que essa pergunta avalia:**  
Avalia automação de verificações locais.

**Resposta esperada:**  
Hooks são scripts executados em determinados eventos do Git, como antes de um commit ou após um checkout. Podem executar validações, formatação ou testes rápidos, mas não devem substituir verificações obrigatórias no servidor.

**Explicação didática:**  
Hooks locais podem não ser compartilhados automaticamente entre todos os clones. Para garantir qualidade, a equipe também deve configurar validações no CI ou no servidor.

**Exemplo prático:**  
Executar lint antes de criar um commit.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Mencione automatização, limites locais e necessidade de validação centralizada.

**Resposta fraca ou incompleta:**  
“Hook é uma branch automática.” São mecanismos diferentes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que hooks locais não bastam?
2. Qual a diferença entre hook de commit e pipeline?
3. Que validações não deveriam tornar o commit excessivamente lento?

---

## Pergunta 63 — Git e testes

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Qual deve ser a relação entre commits Git e testes automatizados?

**O que essa pergunta avalia:**  
Avalia qualidade incremental e rastreabilidade.

**Resposta esperada:**  
Cada alteração relevante deve ser validada por testes adequados antes de ser compartilhada. Commits devem representar estados compreensíveis e, idealmente, não deixar o projeto quebrado sem uma justificativa clara. O pipeline deve executar testes antes da integração.

**Explicação didática:**  
Git registra mudanças, mas não garante que elas estejam corretas. Os testes fornecem evidência sobre o comportamento.

**Exemplo prático:**  
Um commit que corrige uma regra deve incluir ou atualizar o teste correspondente.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Relacione commit, testes, revisão e pipeline.

**Resposta fraca ou incompleta:**  
“Só testo antes da release.” Isso aumenta o custo de encontrar erros.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que fazer com um commit intermediário que não compila?
2. Como testar uma resolução de conflito?
3. Como relacionar commit e requisito?

---

## Pergunta 64 — Código que não compila em um commit

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
É aceitável ter commits intermediários que não compilam ou não passam nos testes?

**O que essa pergunta avalia:**  
Avalia julgamento sobre qualidade de histórico e contexto da equipe.

**Resposta esperada:**  
Depende do fluxo. Em uma branch pessoal, commits intermediários podem existir enquanto o trabalho está em andamento, mas antes da integração é recomendável organizar ou squashar o histórico para entregar commits compreensíveis e verificáveis. Em branches compartilhadas, deve-se evitar quebrar consumidores sem necessidade.

**Explicação didática:**  
O histórico pode servir tanto para registrar o processo quanto para representar unidades revisáveis. A política deve ser explícita.

**Exemplo prático:**  
Antes de abrir uma revisão, combinar commits experimentais em unidades coerentes.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Apresente contexto, risco e estratégia de organização.

**Resposta fraca ou incompleta:**  
“Nunca pode haver commit que falha.” Isso pode ser rígido demais para trabalho local, mas perigoso como regra de integração.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como organizar commits antes da revisão?
2. Quando preservar commits intermediários?
3. Quem deve definir essa política?

---

## Pergunta 65 — Squash

**Nível:** Júnior  
**Categoria:** Histórico

**Pergunta do entrevistador:**  
O que significa fazer squash de commits?

**O que essa pergunta avalia:**  
Avalia organização do histórico antes da integração.

**Resposta esperada:**  
Squash combina vários commits em um único commit ou em menos commits. Pode ser feito em uma revisão interativa:

~~~bash
git rebase -i HEAD~3
~~~

Na lista exibida, mantém-se um commit como `pick` e os demais podem ser marcados como `squash` ou `fixup`.

**Explicação didática:**  
Isso pode remover ruído como “corrige typo” e “agora passa teste”, deixando uma unidade lógica.

**Exemplo prático:**  
Transformar cinco commits de uma feature em dois: implementação e testes.

**Exemplo de código:**  
O procedimento reescreve histórico e deve ser aplicado com cuidado em commits compartilhados.

**Como o candidato deve responder:**  
Explique propósito, reescrita e momento apropriado.

**Resposta fraca ou incompleta:**  
“Squash apaga alterações.” Ele combina commits preservando o resultado final, quando feito corretamente.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre `squash` e `fixup`?
2. Quando não fazer squash?
3. Como recuperar um histórico após um rebase mal executado?

---

## Pergunta 66 — Rebase interativo

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Para que serve o rebase interativo?

**O que essa pergunta avalia:**  
Avalia organização, revisão e correção de commits locais.

**Resposta esperada:**  
O rebase interativo permite reorganizar commits recentes: reordenar, editar mensagens, combinar commits, dividir alterações ou remover commits. Exemplo:

~~~bash
git rebase -i HEAD~4
~~~

Deve ser usado preferencialmente em histórico local ou não compartilhado.

**Explicação didática:**  
A operação não altera apenas arquivos; ela cria novos commits com novos hashes.

**Exemplo prático:**  
Corrigir mensagens e combinar commits antes de abrir um pull request.

**Exemplo de código:**  
Não se aplica além do comando apresentado.

**Como o candidato deve responder:**  
Mencione finalidade, opções comuns e risco de reescrita.

**Resposta fraca ou incompleta:**  
“Serve para baixar alterações do remoto.” Isso confunde rebase com sincronização.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como editar a mensagem de um commit?
2. Como dividir um commit?
3. O que fazer se surgir conflito?

---

## Pergunta 67 — Diferença entre arquivo e commit

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Qual é a diferença entre comparar arquivos e comparar commits no Git?

**O que essa pergunta avalia:**  
Avalia compreensão de escopos de comparação.

**Resposta esperada:**  
Comparar arquivos mostra diferenças de conteúdo entre dois estados. Comparar commits pode mostrar o conjunto de mudanças entre pontos do histórico, além de permitir examinar metadados e relações entre commits.

~~~bash
git diff commit-a commit-b
git show commit-b
~~~

**Explicação didática:**  
O Git compara árvores de arquivos associadas aos commits.

**Exemplo prático:**  
Comparar uma release com a anterior para entender tudo que mudou.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique estado, intervalo e finalidade da comparação.

**Resposta fraca ou incompleta:**  
“É tudo igual porque commit é um arquivo.” Commit é um objeto que referencia uma árvore e metadados.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como comparar apenas uma pasta?
2. O que significa um intervalo `A..B`?
3. Como contar arquivos alterados?

---

## Pergunta 68 — Dois pontos e três pontos

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em termos práticos, qual é a diferença entre `A..B` e `A...B` em comandos de comparação do Git?

**O que essa pergunta avalia:**  
Avalia compreensão inicial de intervalos e divergência.

**Resposta esperada:**  
`A..B` costuma representar commits alcançáveis a partir de `B` que não estão em `A`, dependendo do comando. `A...B` é frequentemente usado para comparar mudanças desde o ancestral comum até os lados divergentes, especialmente em `git diff`.

**Explicação didática:**  
A interpretação exata depende do comando. O candidato deve evitar decorar sem considerar a operação executada.

**Exemplo prático:**  

~~~bash
git log main..feature
git diff main...feature
~~~

O primeiro ajuda a ver commits exclusivos; o segundo costuma mostrar o efeito da feature desde a base comum.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique ancestral comum e ressalve que o comando influencia a interpretação.

**Resposta fraca ou incompleta:**  
“Os dois significam exatamente a mesma coisa.”

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que é ancestral comum?
2. Qual comando usaria para revisar uma pull request?
3. Como confirmar a base efetiva da comparação?

---

## Pergunta 69 — Pull request

**Nível:** Júnior  
**Categoria:** Colaboração

**Pergunta do entrevistador:**  
O que é uma pull request e qual é sua relação com o Git?

**O que essa pergunta avalia:**  
Avalia colaboração, revisão e integração em plataformas de hospedagem.

**Resposta esperada:**  
Pull request é um mecanismo da plataforma de hospedagem para propor a integração de uma branch em outra, permitindo revisão, discussões, verificações automatizadas e aprovação. Não é um comando nativo do Git.

**Explicação didática:**  
O Git fornece commits, branches e histórico. A plataforma acrescenta o processo de colaboração.

**Exemplo prático:**  
Enviar `feature/cadastro` ao remoto e abrir uma solicitação para `main`.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Diferencie Git da plataforma e mencione revisão e CI.

**Resposta fraca ou incompleta:**  
“Pull request é o mesmo que git pull.” São conceitos diferentes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que deve conter uma boa pull request?
2. Como lidar com comentários de revisão?
3. Por que executar CI antes do merge?

---

## Pergunta 70 — Revisão de código

**Nível:** Júnior  
**Categoria:** Colaboração

**Pergunta do entrevistador:**  
Como você se prepararia para abrir uma revisão de código baseada em Git?

**O que essa pergunta avalia:**  
Avalia qualidade da entrega e comunicação técnica.

**Resposta esperada:**  
Eu revisaria o próprio diff, removeria arquivos indevidos, executaria testes, organizaria commits, atualizaria a branch conforme a política e escreveria uma descrição com objetivo, contexto, testes executados e riscos conhecidos.

**Explicação didática:**  
A revisão não deve obrigar outra pessoa a descobrir informações básicas que o autor poderia fornecer.

**Exemplo prático:**  
Descrever cenários testados e destacar uma decisão técnica que merece atenção.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Mencione diff, testes, escopo, contexto e transparência sobre limitações.

**Resposta fraca ou incompleta:**  
“Abro a PR assim que o código funciona localmente.” Isso pode deixar ruído e ausência de contexto.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como reduzir o tamanho de uma revisão?
2. O que fazer quando a branch divergiu?
3. Como responder a uma crítica técnica?

---

## Pergunta 71 — Branch grande

**Nível:** Júnior  
**Categoria:** Manutenibilidade

**Pergunta do entrevistador:**  
Quais problemas podem surgir quando uma branch permanece aberta por muito tempo?

**O que essa pergunta avalia:**  
Avalia riscos de divergência e integração tardia.

**Resposta esperada:**  
A branch pode acumular divergências, gerar conflitos difíceis, aumentar o tamanho da revisão e esconder regressões. É preferível trabalhar em incrementos menores, sincronizar periodicamente e integrar mudanças de forma controlada.

**Explicação didática:**  
Quanto mais tempo duas linhas evoluem separadamente, maior a chance de alterações incompatíveis.

**Exemplo prático:**  
Uma feature de três meses pode ser dividida em entregas menores atrás de flags de configuração, quando apropriado.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Explique conflito, feedback tardio, risco e possíveis técnicas de redução.

**Resposta fraca ou incompleta:**  
“Não há problema; Git resolve qualquer conflito.” Git não compreende automaticamente todas as regras de negócio.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como reduzir o risco de uma branch longa?
2. Quando uma branch longa pode ser justificável?
3. Como detectar divergência cedo?

---

## Pergunta 72 — Branches obsoletas

**Nível:** Júnior  
**Categoria:** Manutenção

**Pergunta do entrevistador:**  
Quando e como você removeria uma branch que já foi integrada?

**O que essa pergunta avalia:**  
Avalia manutenção do repositório e cuidado com referências.

**Resposta esperada:**  
Após confirmar que a branch foi integrada e não contém trabalho exclusivo, ela pode ser removida localmente:

~~~bash
git branch -d feature/cadastro
~~~

Para remover a referência remota:

~~~bash
git push origin --delete feature/cadastro
~~~

A equipe deve manter tags ou referências necessárias para auditoria.

**Explicação didática:**  
Remover a branch não necessariamente remove os commits integrados, pois eles continuam alcançáveis por outra referência.

**Exemplo prático:**  
Excluir branches de features finalizadas para reduzir ruído na lista.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Explique confirmação de merge e diferença local/remota.

**Resposta fraca ou incompleta:**  
“Apago a pasta da branch.” Branch não é uma pasta separada.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre `-d` e `-D`?
2. O que fazer se a branch tiver commits não integrados?
3. A remoção da branch apaga o histórico?

---

## Pergunta 73 — Branch protegida

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Por que uma equipe pode proteger a branch principal?

**O que essa pergunta avalia:**  
Avalia controles básicos de qualidade e segurança no fluxo de integração.

**Resposta esperada:**  
Para exigir revisão, testes automatizados, aprovação, assinaturas ou outras condições antes de aceitar alterações. Isso reduz commits acidentais, código não testado e alterações não autorizadas.

**Explicação didática:**  
Proteção é uma política da plataforma ou do servidor, não uma propriedade intrínseca da branch Git local.

**Exemplo prático:**  
Impedir push direto em `main` e exigir pull request aprovado.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Relacione proteção a qualidade, autorização e rastreabilidade.

**Resposta fraca ou incompleta:**  
“Proteção impede qualquer alteração.” Ela controla como alterações são aceitas.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que verificações você exigiria?
2. Como lidar com uma emergência?
3. Por que proteção local não é suficiente?

---

## Pergunta 74 — Git e CI

**Nível:** Júnior  
**Categoria:** Integração

**Pergunta do entrevistador:**  
Como o Git normalmente se integra a uma ferramenta de CI?

**O que essa pergunta avalia:**  
Avalia relação entre commits, branches e automação.

**Resposta esperada:**  
Um serviço de CI pode ser acionado por push, pull request ou tag. Ele clona ou acessa o repositório, executa build, testes, lint e outras verificações, publicando o resultado para orientar a integração.

~~~mermaid
flowchart LR
    A[Push ou Pull Request] --> B[CI obtém o commit]
    B --> C[Build]
    C --> D[Testes]
    D --> E{Passou?}
    E -->|Sim| F[Revisão ou merge]
    E -->|Não| G[Corrigir branch]
~~~

**Explicação didática:**  
O Git fornece o estado versionado; o CI executa processos automatizados sobre esse estado.

**Exemplo prático:**  
Bloquear merge quando os testes da branch falham.

**Exemplo de código:**  
Não se aplica.

**Como o candidato deve responder:**  
Explique gatilho, commit testado, verificações e resultado.

**Resposta fraca ou incompleta:**  
“Git executa os testes sozinho.” O Git não é, por si só, uma plataforma de CI.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que testar o commit exato da revisão?
2. Como tratar falhas intermitentes?
3. O que fazer se o CI usa segredos?

---

## Pergunta 75 — Release com tag

**Nível:** Júnior  
**Categoria:** Releases

**Pergunta do entrevistador:**  
Como você marcaria uma versão liberada para produção no Git?

**O que essa pergunta avalia:**  
Avalia rastreabilidade de releases.

**Resposta esperada:**  
Depois de confirmar o commit que foi validado e implantado, criaria uma tag, preferencialmente anotada, e a publicaria:

~~~bash
git tag -a v1.4.0 -m "Release 1.4.0"
git push origin v1.4.0
~~~

A equipe deve adotar uma convenção de versionamento.

**Explicação didática:**  
A tag permite identificar exatamente o código da release, mesmo quando a branch continua avançando.

**Exemplo prático:**  
Investigar um incidente comparando o estado atual com `v1.4.0`.

**Exemplo de código:**  
Não se aplica além dos comandos apresentados.

**Como o candidato deve responder:**  
Mencione commit validado, tag, publicação e rastreabilidade.

**Resposta fraca ou incompleta:**  
“Marco a versão no nome da pasta.” Isso não cria referência no histórico.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como garantir que a tag aponta para o commit correto?
2. Tags devem poder ser alteradas?
3. Como associar notas de release?

---

## Pergunta 76 — Repositório grande

**Nível:** Júnior  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
O clone do repositório está muito lento e o histórico é grande. Que hipóteses e alternativas você investigaria?

**O que essa pergunta avalia:**  
Avalia diagnóstico inicial de tamanho e desempenho.

**Resposta esperada:**  
Investigaria arquivos grandes, histórico de binários, artefatos commitados, quantidade de objetos e necessidade de todo o histórico. Poderia considerar clone superficial, sparse checkout, Git LFS ou limpeza planejada do histórico, sempre avaliando impacto na equipe.

**Explicação didática:**  
Remover um arquivo em um commit atual não elimina seu conteúdo dos commits antigos.

**Exemplo prático:**  
Um projeto pode usar clone superficial para CI quando o histórico completo não é necessário.

**Exemplo de código:**  
~~~bash
git clone --depth 1 https://exemplo.com/projeto.git
~~~

**Como o candidato deve responder:**  
Apresente diagnóstico antes da solução e mencione trade-offs do clone superficial.

**Resposta fraca ou incompleta:**  
“Apago a pasta `.git`.” Isso remove o histórico local e não resolve o servidor.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que limitações existem no clone superficial?
2. Quando usar sparse checkout?
3. Como medir a origem do tamanho?

---

## Pergunta 77 — Clone superficial

**Nível:** Júnior  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
O que é um clone superficial e quais são suas limitações?

**O que essa pergunta avalia:**  
Avalia compreensão de redução de histórico.

**Resposta esperada:**  
É um clone que baixa apenas uma parte recente do histórico, por exemplo:

~~~bash
git clone --depth 1 <url>
~~~

Reduz tempo e espaço, mas pode impedir operações que dependam de commits antigos, comparações históricas completas, bisect ou alguns merges.

**Explicação didática:**  
A cópia possui apenas uma visão limitada do histórico.

**Exemplo prático:**  
Um pipeline pode usar depth reduzido para compilar o commit atual, se não precisar de histórico.

**Exemplo de código:**  
Não se aplica além do comando apresentado.

**Como o candidato deve responder:**  
Mencione benefício e limitações, sem tratar como substituto universal de clone completo.

**Resposta fraca ou incompleta:**  
“É um clone menor sem nenhuma diferença funcional.” Há diferenças importantes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como buscar histórico adicional?
2. Por que bisect pode não funcionar?
3. Em que ambiente você usaria depth 1?

---

## Pergunta 78 — Sparse checkout

**Nível:** Júnior  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
Para que serve o sparse checkout?

**O que essa pergunta avalia:**  
Avalia formas de trabalhar com apenas parte da árvore de arquivos.

**Resposta esperada:**  
Sparse checkout permite manter no diretório de trabalho somente determinados caminhos de um repositório, útil em repositórios grandes quando o desenvolvedor não precisa de tudo localmente.

**Explicação didática:**  
O histórico e a estrutura do repositório podem continuar existindo, mas a área de trabalho é reduzida conforme a configuração.

**Exemplo prático:**  
Trabalhar apenas em `services/pagamentos` dentro de um monorepo.

**Exemplo de código:**  
~~~bash
git sparse-checkout init --cone
git sparse-checkout set services/pagamentos
~~~

**Como o candidato deve responder:**  
Diferencie de clone superficial: sparse checkout reduz arquivos presentes na área de trabalho, não necessariamente o histórico.

**Resposta fraca ou incompleta:**  
“Sparse checkout baixa apenas os últimos commits.” Isso descreve clone superficial.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença para submódulos?
2. Que problemas podem surgir com ferramentas que esperam todos os arquivos?
3. Em que repositório isso seria útil?

---

## Pergunta 79 — Quebras de linha

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Por que diferenças de quebra de linha entre sistemas operacionais podem gerar alterações inesperadas no Git?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre diferenças entre LF e CRLF, normalização de arquivos e diagnóstico de diffs aparentemente indevidos.

**Resposta esperada:**  
Sistemas operacionais podem utilizar formatos diferentes de quebra de linha. Sistemas Unix-like geralmente utilizam LF, enquanto o Windows tradicionalmente utiliza CRLF. Quando o arquivo é alterado entre ambientes sem uma política de normalização, o Git pode identificar várias linhas como modificadas, mesmo que o conteúdo lógico não tenha mudado.

A equipe pode definir regras no arquivo `.gitattributes` e configurar o comportamento local do Git, considerando as necessidades do projeto.

~~~gitattributes
* text=auto
*.sh text eol=lf
*.bat text eol=crlf
~~~

**Explicação didática:**  
LF representa uma quebra de linha usando `Line Feed`. CRLF combina `Carriage Return` e `Line Feed`.

O problema ocorre quando um arquivo inteiro muda apenas por causa do formato de quebra de linha. Nesse caso, o diff pode ficar grande e dificultar a revisão de uma alteração real.

O arquivo `.gitattributes` permite estabelecer uma regra compartilhada pelo repositório, reduzindo a dependência das configurações individuais de cada máquina.

**Exemplo prático:**  
Um desenvolvedor altera uma linha em um script no Windows e o Git mostra centenas de linhas modificadas. Antes de revisar o código, é necessário verificar se houve conversão de LF para CRLF.

**Exemplo de código:**  
~~~bash
git diff --ignore-space-at-eol
git config --get core.autocrlf
~~~

O primeiro comando ajuda a analisar o diff ignorando diferenças de fim de linha. O segundo mostra a configuração local relacionada ao comportamento de conversão.

**Como o candidato deve responder:**  
Explique:

- A diferença entre LF e CRLF;
- Que o problema pode ser de formatação, não de lógica;
- A utilidade do `.gitattributes`;
- Que a normalização deve ser combinada com a equipe;
- Que uma alteração de normalização pode gerar um diff grande e deve ser planejada.

Evite dizer que o Git está corrompido ou que todo diff grande representa uma mudança funcional.

**Resposta fraca ou incompleta:**  
“Isso acontece porque o Windows é incompatível com o Git.” A resposta não explica o formato das quebras de linha nem apresenta uma forma de controlar o comportamento.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre LF e CRLF?
2. Como evitar que diferentes sistemas operacionais gerem diffs artificiais?
3. Que cuidados você tomaria antes de normalizar todos os arquivos do projeto?

---

## Pergunta 80 — Detecção de renomeações

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Como o Git identifica que um arquivo foi renomeado?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre detecção de similaridade, renomeações e limitações da representação interna do Git.

**Resposta esperada:**  
O Git não precisa registrar uma operação de renomeação como um tipo especial de objeto. Ele compara arquivos removidos e adicionados e utiliza heurísticas de similaridade para determinar se um arquivo provavelmente foi renomeado.

Se o conteúdo entre o arquivo antigo e o novo for suficientemente semelhante, o Git pode exibir a operação como renomeação. Se houver muitas alterações, pode mostrar a operação como exclusão de um arquivo e criação de outro.

~~~bash
git status
git diff --summary
git diff --find-renames
~~~

**Explicação didática:**  
A identificação de uma renomeação é baseada na comparação do conteúdo e do caminho dos arquivos. Ela é uma interpretação do diff, não necessariamente um registro explícito de “renomear arquivo”.

Por isso, a forma como o Git exibe a mudança pode variar conforme a quantidade de conteúdo alterado e os parâmetros usados na comparação.

**Exemplo prático:**  
Um arquivo `usuario.js` é movido para `domain/usuario.js` e sofre pequenas alterações. O Git provavelmente exibirá a operação como renomeação.

Se o arquivo for completamente reescrito durante a movimentação, o Git poderá exibir uma exclusão e uma criação.

**Exemplo de código:**  
Não é necessário código adicional. Os comandos apresentados são suficientes para analisar a detecção.

**Como o candidato deve responder:**  
Explique que:

- O Git usa similaridade de conteúdo;
- A detecção pode variar;
- Uma grande alteração pode impedir o reconhecimento do renome;
- A detecção não muda o resultado final dos arquivos;
- O histórico deve ser revisado com atenção após grandes reorganizações.

**Resposta fraca ou incompleta:**  
“O Git sempre registra renomeações explicitamente.” Essa resposta ignora que o Git pode inferir a renomeação durante a comparação.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que pode fazer uma renomeação deixar de ser detectada?
2. Uma renomeação altera o histórico do arquivo?
3. Como você revisaria uma grande reorganização de pastas?

---

## Pergunta 81 — Remoção de arquivos

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Qual é a diferença entre remover um arquivo usando `rm` e removê-lo usando `git rm`?

**O que essa pergunta avalia:**  
Avalia a relação entre sistema de arquivos, staging e histórico do Git.

**Resposta esperada:**  
O comando `rm arquivo.txt` remove o arquivo da área de trabalho, mas a remoção ainda precisa ser registrada no staging.

~~~bash
rm arquivo.txt
git status
git add -u
~~~

Já o comando `git rm arquivo.txt` remove o arquivo da área de trabalho e adiciona a remoção ao staging:

~~~bash
git rm arquivo.txt
~~~

Em ambos os casos, a remoção somente fará parte do histórico depois que um commit for criado.

**Explicação didática:**  
Existem três estados importantes:

1. O arquivo existe na área de trabalho;
2. A remoção está preparada no staging;
3. A remoção foi registrada em um commit.

Remover o arquivo do computador não altera automaticamente os commits anteriores. O histórico continua contendo o arquivo até aquele ponto.

**Exemplo prático:**  
Um arquivo de configuração obsoleto precisa ser removido do projeto. O desenvolvedor usa `git rm`, revisa o diff e cria um commit específico para essa remoção.

**Exemplo de código:**  
~~~bash
git rm docs/arquivo-obsoleto.md
git diff --staged
git commit -m "Remove documentação obsoleta"
~~~

**Como o candidato deve responder:**  
Diferencie claramente:

- Remoção física do arquivo;
- Preparação da remoção no staging;
- Registro da remoção no histórico;
- Possibilidade de recuperar o arquivo antes do commit.

Evite dizer que `rm` apaga o arquivo do histórico inteiro.

**Resposta fraca ou incompleta:**  
“`rm` apaga o arquivo do Git e `git rm` apaga apenas do computador.” A resposta inverte os efeitos principais dos comandos.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como recuperar um arquivo removido antes do commit?
2. Como remover um arquivo apenas do staging?
3. O que acontece com o arquivo nos commits antigos?

---

## Pergunta 82 — Arquivos alterados em um commit

**Nível:** Júnior  
**Categoria:** Investigação

**Pergunta do entrevistador:**  
Como você descobriria quais arquivos foram alterados em um commit específico?

**O que essa pergunta avalia:**  
Avalia a capacidade de investigar o escopo de uma alteração histórica.

**Resposta esperada:**  
Podem ser utilizados comandos como:

~~~bash
git show --stat <hash>
git show --name-only <hash>
git show --name-status <hash>
~~~

`git show --stat` apresenta um resumo das alterações. `--name-only` lista os arquivos envolvidos e `--name-status` também informa se eles foram adicionados, modificados, removidos ou renomeados.

**Explicação didática:**  
Conhecer o escopo de um commit é importante para revisar uma mudança, investigar uma regressão ou decidir se ela pode ser revertida com segurança.

O comando `git status` não é suficiente para investigar um commit antigo, pois ele mostra o estado atual da área de trabalho.

**Exemplo prático:**  
Antes de reverter um commit, o desenvolvedor verifica se ele alterou apenas o módulo esperado ou se também modificou arquivos de configuração, testes e documentação.

**Exemplo de código:**  
~~~bash
git show --name-status 2f4a8c1
~~~

**Como o candidato deve responder:**  
Apresente pelo menos um comando adequado e explique a diferença entre:

- Resumo estatístico;
- Lista de nomes;
- Status das mudanças;
- Diff completo.

**Resposta fraca ou incompleta:**  
“Uso `git status` para ver os arquivos do commit.” Esse comando mostra alterações atuais, não necessariamente o conteúdo de um commit histórico.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como visualizar somente os arquivos adicionados?
2. Como analisar apenas um arquivo do commit?
3. Como descobrir se o commit também modificou testes?

---

## Pergunta 83 — Commit de merge

**Nível:** Júnior  
**Categoria:** Histórico

**Pergunta do entrevistador:**  
O que diferencia um commit de merge de um commit comum?

**O que essa pergunta avalia:**  
Avalia a compreensão da estrutura do histórico e da integração entre branches.

**Resposta esperada:**  
Um commit comum normalmente possui um único commit pai. Um commit de merge possui dois ou mais pais, pois representa a combinação de históricos diferentes.

~~~bash
git log --graph --oneline
git show --summary <hash-do-merge>
~~~

Um merge commit pode surgir quando duas branches divergiram e suas alterações precisam ser integradas.

**Explicação didática:**  
Considere um histórico com duas linhas:

~~~mermaid
gitGraph
   commit id: "A"
   commit id: "B"
   branch feature
   checkout feature
   commit id: "C"
   checkout main
   commit id: "D"
   merge feature id: "M"
~~~

O commit `M` possui como pais os commits `D` e `C`. Ele registra que as duas linhas de desenvolvimento foram combinadas.

Em um fast-forward, não há divergência e normalmente não é criado um merge commit.

**Exemplo prático:**  
A branch `main` recebeu uma correção enquanto uma branch de funcionalidade também avançava. Ao integrar as duas linhas, pode ser criado um commit de merge.

**Exemplo de código:**  
~~~bash
git show --no-patch --pretty=raw <hash-do-merge>
~~~

**Como o candidato deve responder:**  
Mencione:

- A existência de múltiplos pais;
- A integração de históricos divergentes;
- A diferença em relação a um fast-forward;
- O uso de `git log --graph` para visualizar a estrutura.

**Resposta fraca ou incompleta:**  
“Todo commit criado depois de um merge é um commit de merge.” O que define o commit de merge é possuir múltiplos pais.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como identificar os pais de um commit de merge?
2. Como reverter um merge commit?
3. Qual é a diferença entre merge commit e fast-forward?

---

## Pergunta 84 — Operação Git em andamento

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O Git informa que existe uma operação de merge, rebase ou cherry-pick em andamento. Como você investigaria e decidiria o próximo passo?

**O que essa pergunta avalia:**  
Avalia a capacidade de interpretar o estado do repositório antes de executar novos comandos.

**Resposta esperada:**  
Primeiro, eu executaria:

~~~bash
git status
~~~

Esse comando normalmente informa qual operação está em andamento, quais arquivos possuem conflitos e quais comandos podem ser usados para continuar ou abortar.

Depois, eu escolheria entre:

- Resolver os conflitos e continuar;
- Abortar a operação;
- Pular um commit, quando essa opção fizer sentido;
- Consultar a equipe antes de tomar uma decisão destrutiva.

**Explicação didática:**  
Durante operações como merge e rebase, o Git mantém informações temporárias para permitir que o processo seja interrompido ou retomado.

Executar comandos aleatórios pode modificar ainda mais o estado do repositório. Por isso, o primeiro passo deve ser entender a situação atual.

**Exemplo prático:**  
Durante um rebase, o Git informa que um arquivo possui conflito. O desenvolvedor revisa o conteúdo, resolve a situação, adiciona o arquivo e continua:

~~~bash
git add src/servico.js
git rebase --continue
~~~

Se concluir que o rebase não é adequado:

~~~bash
git rebase --abort
~~~

**Como o candidato deve responder:**  
Organize a resposta em:

1. Inspecionar com `git status`;
2. Identificar a operação;
3. Avaliar os conflitos;
4. Resolver ou abortar;
5. Executar testes;
6. Confirmar o estado final.

**Resposta fraca ou incompleta:**  
“Eu apagaria a pasta `.git` e clonaria novamente.” Essa abordagem pode destruir alterações locais e não investiga a causa.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como saber se a operação é um merge ou um rebase?
2. Em que situação você abortaria a operação?
3. Como validaria que o repositório voltou a um estado consistente?

---

## Pergunta 85 — Cherry-pick

**Nível:** Júnior  
**Categoria:** Integração

**Pergunta do entrevistador:**  
O que é `git cherry-pick` e em que situação ele pode ser útil?

**O que essa pergunta avalia:**  
Avalia a capacidade de aplicar seletivamente uma alteração de outra linha de desenvolvimento.

**Resposta esperada:**  
`git cherry-pick` aplica as alterações de um commit específico na branch atual, criando um novo commit.

~~~bash
git switch hotfix
git cherry-pick <hash-do-commit>
~~~

Ele pode ser útil para levar uma correção isolada de uma branch para outra, por exemplo, aplicar uma correção de segurança em uma branch de manutenção.

O novo commit possui outro hash, mesmo que contenha alterações semelhantes às do commit original.

**Explicação didática:**  
O cherry-pick não move fisicamente o commit. Ele reaplica a alteração representada pelo commit sobre a branch atual.

Isso pode causar conflitos e, se usado sem planejamento, pode resultar em mudanças duplicadas ou em históricos difíceis de entender.

**Exemplo prático:**  
Uma correção foi desenvolvida em `main`, mas também precisa ser aplicada à branch `release/1.2`.

~~~mermaid
flowchart LR
    A[Commit de correção em main] --> B[Cherry-pick]
    B --> C[Novo commit em release/1.2]
    C --> D[Testes e validação]
~~~

**Exemplo de código:**  
~~~bash
git switch release/1.2
git cherry-pick 2f4a8c1
git push origin release/1.2
~~~

**Como o candidato deve responder:**  
Explique:

- Aplicação seletiva de um commit;
- Criação de um novo commit;
- Possibilidade de conflitos;
- Uso em hotfixes e branches de manutenção;
- Necessidade de testar a alteração na nova base.

**Resposta fraca ou incompleta:**  
“Cherry-pick move o commit para outra branch.” Ele reaplica a alteração e cria outro commit.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como resolver um conflito durante um cherry-pick?
2. Como abortar um cherry-pick?
3. Quando um merge seria melhor que um cherry-pick?

---

## Pergunta 86 — Abortar um cherry-pick

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como você abortaria um `cherry-pick` que gerou conflitos e não deve ser concluído?

**O que essa pergunta avalia:**  
Avalia o controle de uma operação de integração parcial.

**Resposta esperada:**  
Primeiro, eu verificaria o estado do repositório:

~~~bash
git status
~~~

Se o cherry-pick ainda estiver em andamento e eu decidir cancelá-lo, usaria:

~~~bash
git cherry-pick --abort
~~~

Se a intenção fosse prosseguir, resolveria os conflitos, adicionaria os arquivos resolvidos e executaria:

~~~bash
git add arquivo-resolvido.js
git cherry-pick --continue
~~~

**Explicação didática:**  
`--abort` tenta retornar o repositório ao estado anterior ao início do cherry-pick. Já `--continue` informa ao Git que os conflitos foram resolvidos e que a operação pode prosseguir.

É importante distinguir o estado anterior à operação das alterações que já existiam antes dela.

**Exemplo prático:**  
Uma correção foi aplicada em uma branch incompatível e provocou conflitos em vários arquivos. Em vez de escolher versões automaticamente, o desenvolvedor aborta a operação e procura uma solução mais apropriada.

**Exemplo de código:**  
~~~bash
git status
git cherry-pick --abort
git status
~~~

**Como o candidato deve responder:**  
Mencione:

- A inspeção com `git status`;
- A diferença entre `--abort` e `--continue`;
- A necessidade de preservar alterações anteriores;
- A importância de não usar `reset --hard` automaticamente.

**Resposta fraca ou incompleta:**  
“Eu faria `git reset --hard`.” Isso pode descartar trabalho que existia antes do cherry-pick.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como saber quais arquivos estão conflitantes?
2. Quando o uso de `--skip` poderia ser adequado?
3. Como verificar que o abort não removeu alterações anteriores?

---

## Pergunta 87 — Referências remotas

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é `origin/main` e como ele se diferencia da branch local `main`?

**O que essa pergunta avalia:**  
Avalia a compreensão de branches locais, referências remotas e atualização por fetch.

**Resposta esperada:**  
`main` é uma branch local. `origin/main` é uma referência remota local que representa o estado conhecido da branch `main` no remoto chamado `origin`.

Essa referência é atualizada quando o Git busca informações do remoto, normalmente por meio de:

~~~bash
git fetch origin
~~~

Antes do `fetch`, `origin/main` pode não refletir os commits mais recentes publicados no servidor.

**Explicação didática:**  
O nome `origin` é apenas o nome dado ao remoto. `main` depois da barra representa a branch no remoto.

`origin/main` não é uma branch local comum na qual o desenvolvedor deve fazer commits diretamente. Ela funciona como uma referência de acompanhamento do estado remoto conhecido.

**Exemplo prático:**  
Para descobrir se a branch local está atrasada:

~~~bash
git fetch origin
git log --oneline main..origin/main
~~~

Esse comando mostra commits existentes em `origin/main` que ainda não estão na branch local `main`.

**Como o candidato deve responder:**  
Explique:

- Branch local;
- Referência remota;
- Nome do remoto;
- Atualização por `git fetch`;
- Diferença entre consultar `origin/main` e fazer commit na branch local.

**Resposta fraca ou incompleta:**  
“`origin/main` existe somente no servidor.” A referência também é armazenada localmente, embora represente o estado conhecido do remoto.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como atualizar a referência `origin/main`?
2. É possível fazer commit diretamente em `origin/main`?
3. Como comparar a branch local com a referência remota?

---

## Pergunta 88 — Branch upstream

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que significa uma branch local ter uma branch upstream configurada?

**O que essa pergunta avalia:**  
Avalia a compreensão sobre associação entre branches locais e remotas.

**Resposta esperada:**  
Uma branch upstream é uma referência remota associada à branch local. Essa associação permite que comandos como `git pull` e `git push` saibam, por padrão, qual remoto e qual branch devem utilizar.

A associação pode ser criada no primeiro push:

~~~bash
git push -u origin feature/login
~~~

Depois disso, a branch local `feature/login` normalmente acompanha `origin/feature/login`.

**Explicação didática:**  
Upstream é uma configuração de acompanhamento. Ela não significa que as branches estejam sempre sincronizadas nem impede conflitos.

O estado da relação pode ser consultado com:

~~~bash
git branch -vv
~~~

**Exemplo prático:**  
Depois de criar uma branch local e publicá-la, o desenvolvedor configura o upstream para evitar informar o remoto e a branch em todos os pushes seguintes.

**Como o candidato deve responder:**  
Mencione:

- Associação entre branch local e referência remota;
- Uso da opção `-u`;
- Conveniência para `push` e `pull`;
- Que upstream não elimina a necessidade de verificar divergências.

**Resposta fraca ou incompleta:**  
“Upstream é o servidor Git.” Upstream representa uma relação entre referências, não o servidor em si.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como verificar qual é o upstream de uma branch?
2. Como alterar ou remover essa associação?
3. O upstream impede conflitos entre branches?

---

## Pergunta 89 — Pesquisa no histórico

**Nível:** Júnior  
**Categoria:** Investigação

**Pergunta do entrevistador:**  
Como você procuraria no histórico do Git o commit que adicionou ou removeu um determinado texto?

**O que essa pergunta avalia:**  
Avalia a capacidade de localizar mudanças históricas por conteúdo e mensagem.

**Resposta esperada:**  
Para pesquisar termos nas mensagens dos commits, pode-se usar:

~~~bash
git log --grep="termo"
~~~

Para localizar mudanças no conteúdo de arquivos, podem ser usados:

~~~bash
git log -S"texto" -- caminho/arquivo.js
git log -G"expressão" -- caminho/arquivo.js
~~~

`-S` procura alterações na quantidade de ocorrências do texto. `-G` pesquisa uma expressão regular dentro das linhas modificadas.

**Explicação didática:**  
Esses comandos são úteis quando o desenvolvedor sabe qual lógica ou texto está procurando, mas não sabe em qual commit ele foi introduzido.

A diferença é importante:

- `--grep` pesquisa mensagens de commit;
- `-S` pesquisa alterações na ocorrência exata de um texto;
- `-G` pesquisa padrões nas linhas modificadas.

**Exemplo prático:**  
Para descobrir quando uma chamada a `calcularFrete` foi introduzida:

~~~bash
git log -S"calcularFrete" -- src/pedido.js
~~~

Depois, o commit encontrado pode ser analisado com `git show`.

**Como o candidato deve responder:**  
Diferencie pesquisa por:

- Mensagem;
- Texto exato;
- Expressão regular;
- Arquivo específico.

Também deve explicar que a pesquisa serve para formular hipóteses, não para substituir a validação do comportamento.

**Resposta fraca ou incompleta:**  
“Uso somente `git log` e procuro visualmente.” Embora possa funcionar em um histórico pequeno, não demonstra conhecimento dos recursos de pesquisa.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando você usaria `-S` em vez de `-G`?
2. Como restringir a busca a uma branch?
3. O que faria depois de encontrar o commit?

---

## Pergunta 90 — Arquivos gerados

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Um arquivo gerado automaticamente aparece como modificado em vários commits. Como você decidiria se ele deve ser versionado?

**O que essa pergunta avalia:**  
Avalia julgamento sobre artefatos gerados, fonte de verdade e manutenção do repositório.

**Resposta esperada:**  
Eu verificaria:

- Se o arquivo pode ser recriado automaticamente;
- Se ele é necessário para executar ou publicar o sistema;
- Se existe uma etapa confiável de geração;
- Se a equipe possui uma política para artefatos;
- Se o arquivo contém informações que precisam ser distribuídas junto com o código;
- Qual é o impacto no tamanho e na revisão do repositório.

Se o arquivo puder ser reproduzido de maneira confiável a partir do código-fonte, normalmente ele pode ser ignorado e gerado no processo de build. Porém, não existe uma regra universal.

**Explicação didática:**  
A fonte de verdade é o material que deve ser alterado manualmente para produzir o resultado correto.

Por exemplo, em muitos projetos, o código-fonte é a fonte de verdade e a pasta de build é um artefato. Em outros casos, arquivos gerados podem ser necessários para distribuição ou compatibilidade.

Arquivos de lock também podem ter tratamento diferente, pois registram versões exatas de dependências.

**Exemplo prático:**  
Uma equipe pode ignorar `dist/` e `build/`, mas versionar um arquivo de lock usado para reproduzir as dependências do projeto.

**Exemplo de código:**  
~~~gitignore
dist/
build/
*.log
.cache/
~~~

**Como o candidato deve responder:**  
Apresente critérios de decisão, não uma regra absoluta. Mencione:

- Reprodutibilidade;
- Tamanho;
- Consistência;
- Processo de build;
- Fonte de verdade;
- Necessidade de distribuição.

**Resposta fraca ou incompleta:**  
“Todo arquivo gerado deve ser ignorado.” Existem situações em que versionar um arquivo gerado pode ser justificável.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que significa fonte de verdade?
2. Por que arquivos de lock podem ser tratados de maneira diferente?
3. Como evitar divergências entre o arquivo gerado e o código-fonte?

---

## Pergunta 91 — Configuração local do Git

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Como você configuraria um comportamento do Git apenas para um repositório específico?

**O que essa pergunta avalia:**  
Avalia o conhecimento sobre escopos de configuração e impacto das configurações locais e globais.

**Resposta esperada:**  
Dentro do repositório, eu executaria o comando sem a opção `--global`:

~~~bash
git config user.name "Nome do Projeto"
git config pull.rebase true
~~~

Essa configuração será aplicada apenas ao repositório atual. A configuração local normalmente tem precedência sobre a configuração global correspondente.

**Explicação didática:**  
O Git possui diferentes níveis de configuração. Os mais comuns são:

- Sistema;
- Usuário ou global;
- Repositório local.

Uma configuração global pode afetar vários projetos. A configuração local permite adaptar o comportamento de um projeto sem alterar os demais.

**Exemplo prático:**  
Um projeto pode exigir `pull.rebase=true`, enquanto outro projeto adota merge automático.

Para consultar as configurações e suas origens:

~~~bash
git config --list --show-origin
~~~

**Como o candidato deve responder:**  
Explique:

- A diferença entre configuração global e local;
- A remoção de `--global`;
- A precedência da configuração local;
- O risco de alterar configurações globais sem necessidade.

**Resposta fraca ou incompleta:**  
“Uso sempre `--global` para garantir que funcione.” Isso pode alterar o comportamento de projetos não relacionados.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como consultar a origem de cada configuração?
2. Que configurações deveriam ser compartilhadas com a equipe?
3. Qual é o risco de alterar uma configuração global?

---

## Pergunta 92 — Assinatura de commits

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
O que significa assinar commits e por que uma equipe poderia exigir esse procedimento?

**O que essa pergunta avalia:**  
Avalia noções de autenticidade, integridade, confiança e limitações das assinaturas.

**Resposta esperada:**  
Assinar um commit permite associá-lo criptograficamente a uma chave controlada por uma identidade. A assinatura ajuda a verificar que o commit foi produzido por uma chave reconhecida e que seu conteúdo não foi alterado depois da assinatura.

Uma equipe pode exigir assinaturas em mudanças sensíveis, releases ou branches protegidas para reforçar auditoria e confiança.

A assinatura não substitui revisão de código, testes ou autorização de acesso.

**Explicação didática:**  
A assinatura oferece uma evidência adicional sobre:

- Autenticidade: a chave corresponde a uma identidade reconhecida;
- Integridade: o conteúdo assinado não foi alterado;
- Rastreabilidade: existe uma relação verificável entre o commit e a chave.

Ela não garante que o código seja seguro ou correto. Uma pessoa autorizada também pode produzir uma alteração com defeito.

**Exemplo prático:**  
Uma organização pode exigir commits assinados em uma branch de release para aumentar a confiança na origem do código liberado.

**Exemplo de código:**  
A configuração depende da ferramenta de chaves e da política do projeto. Um exemplo conceitual é:

~~~bash
git log --show-signature
git verify-commit <hash>
~~~

**Como o candidato deve responder:**  
Explique autenticidade, integridade e limitações. Também deve mencionar:

- Proteção da chave privada;
- Revogação ou troca de chaves comprometidas;
- Diferença entre assinatura e aprovação de revisão;
- Dependência da configuração da equipe.

**Resposta fraca ou incompleta:**  
“Commit assinado significa que o código foi aprovado.” Assinatura e aprovação são mecanismos diferentes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Uma assinatura prova que o código é seguro?
2. Como proteger uma chave privada?
3. Em quais tipos de branch a assinatura seria mais importante?

---

## Pergunta 93 — Erro de permissão no push

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O Git retorna um erro de permissão ao executar `push`. Como você investigaria o problema sem expor credenciais?

**O que essa pergunta avalia:**  
Avalia diagnóstico de autenticação, autorização, configuração remota e proteção de branches.

**Resposta esperada:**  
Eu investigaria de forma progressiva:

1. Verificaria a URL e o protocolo do remoto;
2. Confirmaria qual branch estou tentando publicar;
3. Verificaria se minha conta possui permissão;
4. Conferiria se a branch está protegida;
5. Validaria se a credencial, token ou chave ainda é válida;
6. Consultaria as mensagens do servidor sem imprimir segredos;
7. Confirmaria se o push está sendo feito para o repositório correto.

~~~bash
git remote -v
git branch --show-current
git branch -vv
git status
~~~

**Explicação didática:**  
Autenticação e autorização são conceitos diferentes:

- Autenticação verifica quem está tentando acessar;
- Autorização verifica o que essa identidade pode fazer.

Uma branch protegida pode rejeitar um push direto mesmo que a autenticação tenha funcionado corretamente.

**Exemplo prático:**  
O usuário consegue clonar o repositório, mas não consegue fazer push em `main`. Isso pode significar que possui permissão de leitura, mas não de escrita, ou que a branch exige uma pull request.

**Exemplo de código:**  
Não se deve colocar tokens ou senhas diretamente em comandos, scripts ou mensagens de erro.

**Como o candidato deve responder:**  
Mencione:

- Verificação do remoto;
- Branch atual;
- Permissões;
- Branch protegida;
- Diferença entre autenticação e autorização;
- Proteção de credenciais.

**Resposta fraca ou incompleta:**  
“Coloco a senha diretamente no comando para testar.” Isso pode expor a credencial no histórico do terminal ou em logs.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como diferenciar falha de autenticação de falha de autorização?
2. O que verificar quando a branch está protegida?
3. Como evitar que credenciais apareçam em logs?

---

## Pergunta 94 — Conflito entre modificação e exclusão

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Durante um merge, um arquivo foi modificado em uma branch e excluído em outra. Como você decidiria qual deve ser o resultado?

**O que essa pergunta avalia:**  
Avalia a capacidade de resolver conflitos considerando o contexto funcional, e não apenas escolhendo um lado automaticamente.

**Resposta esperada:**  
Eu investigaria:

- Por que o arquivo foi excluído;
- Qual funcionalidade substituiu esse arquivo;
- Se a modificação ainda é necessária;
- Quais componentes dependem dele;
- Se o conteúdo deve ser migrado para outro local;
- Qual é a intenção da regra de negócio.

O resultado poderia ser:

- Manter o arquivo modificado;
- Confirmar sua exclusão;
- Recuperar parte do conteúdo em outro arquivo;
- Reestruturar a solução antes de concluir o merge.

Depois, eu revisaria o diff e executaria os testes relacionados.

**Explicação didática:**  
O Git consegue detectar que existe uma incompatibilidade, mas não conhece a intenção funcional da alteração.

Escolher “a versão atual” ou “a versão da outra branch” sem investigação pode remover uma correção importante ou reintroduzir código obsoleto.

**Exemplo prático:**  
Uma branch removeu um serviço antigo porque ele foi substituído por uma nova implementação. Outra branch ainda alterava o serviço antigo. A solução correta pode ser migrar a alteração para o novo serviço, não simplesmente manter ou apagar o arquivo.

**Exemplo de código:**  
Não se aplica. O ponto principal é o raciocínio de investigação e validação.

**Como o candidato deve responder:**  
Explique uma sequência semelhante a:

1. Identificar o conflito;
2. Entender a intenção de cada branch;
3. Consultar histórico e responsáveis;
4. Decidir o estado funcional correto;
5. Resolver o arquivo;
6. Executar testes;
7. Revisar o diff final.

**Resposta fraca ou incompleta:**  
“Escolho a versão que tiver mais linhas.” O tamanho do arquivo não determina qual solução está correta.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como descobrir quem depende do arquivo?
2. Que testes devem ser executados?
3. Como documentar a decisão de manter ou remover o arquivo?

---

## Pergunta 95 — Arquivos indevidos no último commit

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Você percebe, antes do push, que incluiu arquivos indevidos no último commit. Como corrigiria a situação sem perder o trabalho correto?

**O que essa pergunta avalia:**  
Avalia a capacidade de corrigir um commit local e evitar perda acidental de alterações.

**Resposta esperada:**  
Se o commit ainda não foi compartilhado, eu poderia desfazê-lo mantendo as alterações na área de trabalho:

~~~bash
git reset HEAD~1
git status
~~~

Depois, revisaria os arquivos, adicionaria somente o conteúdo correto e criaria um novo commit.

Se o problema fosse apenas a ausência de uma pequena alteração relacionada, poderia usar `git commit --amend`.

Também verificaria se o arquivo indevido deve ser adicionado ao `.gitignore`.

**Explicação didática:**  
O objetivo é separar o conteúdo correto do incorreto sem usar uma opção destrutiva.

O reset padrão, geralmente equivalente a `--mixed`, move a referência do commit e deixa os arquivos modificados na área de trabalho, permitindo reorganizar o staging.

**Exemplo prático:**  
Um arquivo `.env` com configurações locais foi adicionado por engano. O desenvolvedor desfaz o commit, remove o arquivo do staging, adiciona `.env` ao `.gitignore` e cria um novo commit sem a credencial.

**Exemplo de código:**  
~~~bash
git reset HEAD~1
git restore --staged .env
printf "\n.env\n" >> .gitignore
git add .gitignore src/
git commit -m "Remove configuração local do commit"
~~~

A alteração em `.gitignore` deve ser feita de acordo com a política do projeto.

**Como o candidato deve responder:**  
Mencione:

- Que o commit ainda não foi publicado;
- A diferença entre resetar e descartar;
- A revisão do staging;
- A possibilidade de usar amend;
- A necessidade de proteger arquivos sensíveis;
- A conferência do diff antes do novo commit.

**Resposta fraca ou incompleta:**  
“Uso `git reset --hard`.” Isso pode apagar alterações corretas e desnecessariamente aumenta o risco de perda.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que mudaria se o commit já tivesse sido enviado?
2. Como revisar o conteúdo antes de criar o novo commit?
3. Como evitar que o arquivo indevido seja adicionado novamente?

---

## Pergunta 96 — Commit publicado com erro

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Você publicou um commit com uma alteração incorreta. Como decidiria entre criar uma correção e usar `git revert`?

**O que essa pergunta avalia:**  
Avalia a capacidade de lidar com erros em histórico compartilhado.

**Resposta esperada:**  
Eu consideraria o impacto, a urgência e o estado da alteração.

Se uma nova alteração puder corrigir o problema de forma segura, eu criaria um novo commit com a correção. Se fosse necessário remover imediatamente o comportamento introduzido pelo commit, poderia usar `git revert`, que cria um novo commit desfazendo os efeitos do anterior.

~~~bash
git revert <hash-do-commit>
git push origin main
~~~

Em uma branch compartilhada, normalmente evitaria reescrever o histórico com reset ou force push.

**Explicação didática:**  
`git revert` preserva o histórico original e registra explicitamente a reversão. Isso é importante para auditoria e colaboração.

Uma correção nova pode ser melhor quando:

- O erro é pequeno;
- A solução definitiva já está clara;
- Não é necessário remover completamente o comportamento;
- O sistema pode ser corrigido sem interromper o fluxo.

Um revert pode ser melhor quando:

- A alteração causa falha grave;
- É necessário retirar rapidamente uma funcionalidade;
- A branch é compartilhada;
- A investigação da correção definitiva ainda está em andamento.

**Exemplo prático:**  
Uma mudança publicada em produção provoca erros no pagamento. A equipe faz o revert para reduzir o impacto e depois prepara uma correção testada em uma branch separada.

**Como o candidato deve responder:**  
Mencione:

- Impacto e urgência;
- Preservação do histórico;
- Diferença entre revert e reset;
- Testes;
- Comunicação com a equipe;
- Possibilidade de uma correção posterior.

**Resposta fraca ou incompleta:**  
“Apago o commit remoto.” Essa ação pode não ser possível, pode destruir histórico compartilhado e não representa uma resposta operacional segura.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando uma nova correção seria melhor do que um revert?
2. Como validar que o revert funcionou?
3. Como comunicar a reversão durante um incidente?

---

## Pergunta 97 — Histórico compreensível

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Que características tornam um histórico Git fácil de entender, revisar e manter?

**O que essa pergunta avalia:**  
Avalia maturidade no uso de commits e capacidade de produzir histórico útil para a equipe.

**Resposta esperada:**  
Um histórico compreensível normalmente possui:

- Commits coesos;
- Mensagens claras;
- Alterações relacionadas agrupadas;
- Separação entre refatoração e mudança funcional quando possível;
- Testes correspondentes;
- Pouca inclusão de arquivos temporários;
- Baixa mistura de mudanças não relacionadas;
- Histórico organizado antes da integração, quando essa for a política da equipe.

Um bom histórico facilita revisão, investigação, reversão e manutenção.

**Explicação didática:**  
O histórico não serve apenas para registrar que algo mudou. Ele também ajuda a explicar:

- O que foi alterado;
- Por que foi alterado;
- Qual problema foi resolvido;
- Como a mudança pode ser revertida;
- Qual commit introduziu determinado comportamento.

**Exemplo prático:**  
Em vez de criar um único commit com uma nova funcionalidade, correções de formatação, atualização de dependências e mudanças na documentação, a equipe pode separar as alterações em commits relacionados.

~~~mermaid
flowchart LR
    A[Alteração coesa] --> B[Testes]
    B --> C[Commit claro]
    C --> D[Revisão]
    D --> E[Integração]
    E --> F[Histórico rastreável]
~~~

**Como o candidato deve responder:**  
Fale sobre coesão, clareza, testes, facilidade de revisão e reversão. Não confunda qualidade com quantidade de commits.

Também é importante mencionar que a política pode variar: algumas equipes preservam commits de desenvolvimento, enquanto outras preferem squash antes da integração.

**Resposta fraca ou incompleta:**  
“Um bom histórico é aquele que tem muitos commits.” A quantidade não garante clareza ou qualidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando separar uma refatoração de uma alteração funcional?
2. Por que commits coesos facilitam o revert?
3. Como lidar com um histórico antigo que está desorganizado?

---

## Pergunta 98 — Trabalho em equipe

**Nível:** Júnior  
**Categoria:** Colaboração

**Pergunta do entrevistador:**  
Quais práticas você adotaria para reduzir conflitos e problemas de integração ao trabalhar com outras pessoas no Git?

**O que essa pergunta avalia:**  
Avalia colaboração, organização do desenvolvimento e prevenção de conflitos.

**Resposta esperada:**  
Eu adotaria práticas como:

- Trabalhar em branches pequenas;
- Atualizar a branch regularmente;
- Evitar alterações desnecessárias em arquivos compartilhados;
- Dividir tarefas muito grandes;
- Fazer commits coesos;
- Comunicar mudanças estruturais;
- Abrir revisões menores;
- Executar testes antes do push;
- Integrar mudanças com frequência razoável;
- Evitar force push em branches compartilhadas.

Conflitos não são apenas um problema de comandos. Eles também resultam de falta de comunicação e de branches excessivamente longas.

**Explicação didática:**  
Quanto mais tempo duas branches evoluem separadamente, maior a possibilidade de divergência.

A prevenção costuma ser mais barata do que a resolução de um conflito grande. Uma equipe pode reduzir o risco trabalhando em incrementos menores e compartilhando decisões relevantes antes de alterar arquivos centrais.

**Exemplo prático:**  
Antes de reorganizar um arquivo usado por várias pessoas, o desenvolvedor comunica a mudança e combina uma janela ou estratégia de integração.

**Exemplo de código:**  
Não se aplica. A competência avaliada envolve práticas técnicas e colaboração.

**Como o candidato deve responder:**  
Combine aspectos técnicos e comportamentais:

- Branches curtas;
- Sincronização;
- Comunicação;
- Revisões pequenas;
- Testes;
- Cuidado com histórico compartilhado;
- Organização das tarefas.

Evite apresentar force push como solução para conflitos.

**Resposta fraca ou incompleta:**  
“Uso `git push --force` quando houver conflito.” Force push pode substituir alterações de outras pessoas e agravar o problema.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como lidar com arquivos muito disputados por várias pessoas?
2. Quando uma tarefa deveria ser dividida?
3. Como comunicar uma alteração que pode afetar várias branches?

---

## Pergunta 99 — Validação após conflito

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Depois de resolver um conflito de merge, quais verificações você faria antes de concluir a operação?

**O que essa pergunta avalia:**  
Avalia a capacidade de validar uma resolução tanto do ponto de vista sintático quanto funcional.

**Resposta esperada:**  
Eu verificaria:

1. Quais arquivos estavam em conflito;
2. Se todos os marcadores foram removidos;
3. Se o diff representa a decisão correta;
4. Se não foram introduzidas alterações não relacionadas;
5. Se arquivos importantes não foram removidos;
6. Se os testes relevantes passam;
7. Se a operação foi concluída corretamente;
8. Se a branch ficou em um estado consistente.

Comandos úteis:

~~~bash
git status
git diff
git diff --staged
git grep -nE '<<<<<<<|=======|>>>>>>>'
~~~

Depois da resolução, eu executaria os testes unitários, de integração ou outros testes relacionados à alteração.

**Explicação didática:**  
Resolver um conflito de forma sintática significa apenas remover os marcadores e produzir um arquivo válido. Isso não garante que o comportamento funcional esteja correto.

Por exemplo, duas branches podem conter regras de negócio válidas, mas a escolha de apenas uma delas pode causar regressão.

**Exemplo prático:**  
Duas pessoas modificaram uma validação de endereço. O candidato não deve apenas remover os marcadores; deve verificar se os dois requisitos foram preservados e executar os testes correspondentes.

~~~mermaid
flowchart TD
    A[Identificar conflitos] --> B[Entender as duas alterações]
    B --> C[Resolver o código]
    C --> D[Revisar diff]
    D --> E[Executar testes]
    E --> F{Tudo correto?}
    F -->|Sim| G[Concluir merge]
    F -->|Não| C
~~~

**Como o candidato deve responder:**  
Apresente uma sequência de inspeção, resolução, testes e revisão. Destaque que escolher automaticamente “ours” ou “theirs” pode descartar comportamento necessário.

**Resposta fraca ou incompleta:**  
“Removo os marcadores e faço commit.” Faltam entendimento funcional, revisão do diff e testes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como encontrar marcadores de conflito esquecidos?
2. Quais testes seriam prioritários?
3. Como confirmar que a branch ficou em estado consistente?

---

## Pergunta 100 — Experiência prática com Git

**Nível:** Júnior  
**Categoria:** Experiência prática

**Pergunta do entrevistador:**  
Descreva uma situação real em que você utilizou Git para resolver um problema, colaborar em uma entrega ou recuperar um trabalho.

**O que essa pergunta avalia:**  
Avalia experiência aplicada, comunicação técnica, tomada de decisão e capacidade de explicar consequências.

**Resposta esperada:**  
O candidato deve apresentar:

1. Contexto;
2. Problema;
3. Alternativas consideradas;
4. Decisão tomada;
5. Comandos ou fluxo utilizado;
6. Testes e validações;
7. Resultado;
8. Aprendizado.

Uma resposta forte pode descrever, por exemplo, uma correção urgente em produção:

“Eu estava trabalhando em uma funcionalidade incompleta quando surgiu um erro em produção. Preservei o trabalho local com um commit ou stash, atualizei a branch estável, criei uma branch de correção, implementei a mudança, executei os testes, enviei a branch para revisão e depois integrei a correção. Também verifiquei se a correção precisava ser aplicada à branch de desenvolvimento.”

**Explicação didática:**  
Essa pergunta diferencia o conhecimento decorado da experiência prática.

O entrevistador não deve avaliar apenas a quantidade de comandos citados. Deve observar se o candidato compreende:

- Por que escolheu determinada operação;
- Quais riscos existiam;
- Como preservou o trabalho;
- Como validou o resultado;
- Como comunicou a alteração;
- O que faria de maneira diferente hoje.

**Exemplo prático:**  
Uma resposta pode seguir esta estrutura:

~~~text
Situação: Eu trabalhava em uma feature quando surgiu um bug em produção.

Problema: Minha branch continha alterações incompletas que não poderiam ser publicadas.

Decisão: Preservei o trabalho e criei uma branch de hotfix a partir da versão estável.

Execução: Corrigi o problema, criei um commit pequeno e enviei a branch para revisão.

Validação: Executei testes unitários, testes de integração e validei o cenário que falhava.

Resultado: A correção foi integrada e posteriormente reaplicada na branch de desenvolvimento.

Aprendizado: Passei a manter branches menores e a atualizar a base com mais frequência.
~~~

**Como o candidato deve responder:**  
Use uma estrutura semelhante a:

- Situação;
- Problema;
- Ação;
- Decisão;
- Validação;
- Resultado;
- Aprendizado.

Mencione sua participação real e não atribua a si mesmo decisões tomadas pela equipe inteira. Se não lembrar o comando exato, explique o objetivo da operação e como consultaria a documentação com segurança.

Também é positivo mencionar limitações, riscos e alternativas.

**Resposta fraca ou incompleta:**  
“Eu uso Git todos os dias e nunca tive problemas.” Essa resposta não apresenta evidências de experiência, decisões ou capacidade de resolver situações reais.

Outra resposta fraca seria listar vários comandos sem explicar quando ou por que foram utilizados.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual era o maior risco da situação?
2. Como você validou que a solução funcionou?
3. O que faria diferente atualmente?