# Pergunta 1 — Finalidade do Maven

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é o Apache Maven e quais problemas ele resolve em projetos Java?

**O que essa pergunta avalia:**  
Avalia se o candidato entende o papel do Maven na automação de builds, no gerenciamento de dependências, na execução de testes e na padronização de projetos.

**Resposta esperada:**  
O Apache Maven é uma ferramenta de automação e gerenciamento de projetos, amplamente utilizada no ecossistema Java. Ele permite:

- Compilar o código-fonte;
- Executar testes;
- Gerenciar dependências;
- Empacotar aplicações;
- Executar plugins;
- Gerar relatórios;
- Publicar artefatos;
- Padronizar a estrutura do projeto.

A configuração principal fica no arquivo `pom.xml`, que descreve a identidade do projeto, suas dependências, plugins e configurações de build.

**Explicação didática:**  
Sem uma ferramenta de build, o desenvolvedor precisaria baixar JARs manualmente, configurar o classpath, compilar os arquivos, executar testes e criar os pacotes finais.

O Maven automatiza essas tarefas usando uma configuração declarativa e convenções de projeto. Assim, projetos diferentes podem seguir uma estrutura semelhante, facilitando sua manutenção.

**Exemplo prático:**  
Um serviço Java pode utilizar Maven para baixar suas bibliotecas, compilar o código, executar os testes e gerar um arquivo JAR.

**Exemplo de código:**  
Não é necessário código para esta pergunta.

**Como o candidato deve responder:**  

- Defina o Maven como ferramenta de build e gerenciamento de dependências;
- Mencione o arquivo `pom.xml`;
- Explique que ele executa compilação, testes e empacotamento;
- Cite a padronização da estrutura;
- Dê um exemplo prático;
- Evite dizer que Maven é apenas um baixador de bibliotecas.

**Resposta fraca ou incompleta:**  
“Maven é uma ferramenta para instalar bibliotecas Java.”

Essa resposta menciona uma função real, mas ignora automação de build, testes, plugins, empacotamento e publicação de artefatos.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Demonstra conhecimento muito superficial.
- **2** — Conhece parte do conceito, mas apresenta lacunas importantes.
- **3** — Responde corretamente aos fundamentos.
- **4** — Demonstra bom domínio prático e apresenta exemplos.
- **5** — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual é a função do arquivo `pom.xml`?
2. Que tarefas normalmente fazem parte de um build?
3. Quais vantagens a padronização traz para uma equipe?

