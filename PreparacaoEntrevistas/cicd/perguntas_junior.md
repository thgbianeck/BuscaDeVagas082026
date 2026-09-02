# Roteiro completo de entrevista técnica — CI/CD

## Configuração da entrevista

- **Tecnologia avaliada:** CI/CD — Integração Contínua e Entrega/Implantação Contínua
- **Níveis abordados:** Júnior, Pleno e Sênior
- **Quantidade total:** 100 perguntas
- **Perfil:** Misturado — conceitual, prático e baseado em cenários reais
- **Distribuição:**
  - Júnior: 34 perguntas
  - Pleno: 33 perguntas
  - Sênior: 33 perguntas

> As respostas podem variar conforme as ferramentas utilizadas, como GitHub Actions, GitLab CI/CD, Jenkins, Azure DevOps, CircleCI, Argo CD, Tekton, AWS CodePipeline, Google Cloud Build ou outras. O candidato deve demonstrar domínio dos princípios, não apenas de uma ferramenta específica.

---

# Parte 1 — Nível Júnior

## Pergunta 1 — Conceito de CI/CD

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que significa CI/CD e qual problema esse conjunto de práticas procura resolver?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende os conceitos fundamentais de integração contínua, entrega contínua e implantação contínua.

**Resposta esperada:**  
CI significa Integração Contínua e consiste em integrar alterações de código frequentemente, executando automaticamente validações como compilação, análise estática e testes. CD pode significar Entrega Contínua, quando o software fica sempre pronto para ser liberado, ou Implantação Contínua, quando a publicação em um ambiente ocorre automaticamente após as validações. O objetivo é reduzir riscos, detectar problemas cedo e tornar as entregas menores, frequentes e previsíveis.

**Explicação didática:**  
Em vez de juntar muitas alterações durante semanas e descobrir problemas apenas no final, a equipe integra pequenas mudanças continuamente. Cada alteração passa por uma sequência automatizada de verificações. Isso reduz o tamanho dos problemas e facilita sua investigação.

**Exemplo prático:**  
Um desenvolvedor abre um pull request. O pipeline executa testes, verifica o estilo do código e cria um artefato. Se tudo passar, a alteração pode ser revisada e enviada para homologação.

**Exemplo de código:**  
Não é necessário código para esta pergunta.

**Como o candidato deve responder:**  
Deve diferenciar CI de CD, explicar o benefício da automação e mencionar testes e feedback rápido. É positivo citar que implantação contínua é diferente de entrega contínua.

**Resposta fraca ou incompleta:**  
“CI/CD é uma ferramenta que publica o código automaticamente.”  
Essa resposta confunde prática com ferramenta e não explica integração, validação nem redução de riscos.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre entrega contínua e implantação contínua?
2. Por que integrar alterações pequenas reduz riscos?
3. Que tipos de validação você colocaria em um pipeline inicial?

---

## Pergunta 2 — Pipeline

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é um pipeline de CI/CD e quais etapas normalmente fazem parte dele?

**O que essa pergunta avalia:**  
Avalia a compreensão da estrutura básica de um fluxo automatizado de entrega.

**Resposta esperada:**  
Um pipeline é uma sequência automatizada de etapas que transforma uma alteração de código em um artefato validado e, eventualmente, em uma implantação. Etapas comuns incluem checkout do código, instalação de dependências, lint, testes, build, empacotamento, publicação do artefato, implantação e verificações posteriores.

**Explicação didática:**  
Cada etapa possui uma responsabilidade. Os testes verificam comportamento; o build gera uma versão executável; o empacotamento cria um artefato; a implantação disponibiliza esse artefato em um ambiente.

**Exemplo prático:**  
`checkout → instalar dependências → testar → construir imagem → publicar imagem → implantar em homologação`.

**Exemplo de código:**  
Um pipeline pode ser visualizado assim:

~~~mermaid
flowchart LR
    A[Commit] --> B[Testes]
    B --> C[Build]
    C --> D[Artefato]
    D --> E[Homologação]
    E --> F[Produção]
~~~

**Como o candidato deve responder:**  
Deve descrever uma sequência coerente e explicar o propósito das principais etapas. Não precisa conhecer a sintaxe de uma ferramenta específica.

**Resposta fraca ou incompleta:**  
“Pipeline é o arquivo YAML que roda no servidor.”  
A resposta cita uma implementação, mas não explica o fluxo nem as responsabilidades.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que os testes devem ocorrer antes da implantação?
2. O que acontece se uma etapa falhar?
3. Você executaria todas as etapas em sequência ou algumas em paralelo? Por quê?

---

## Pergunta 3 — Integração contínua

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Por que integrar código frequentemente é melhor do que acumular muitas alterações para integrar de uma só vez?

**O que essa pergunta avalia:**  
Avalia a compreensão de integração frequente, conflitos e feedback rápido.

**Resposta esperada:**  
Integrações frequentes reduzem o tamanho das mudanças, diminuem conflitos de merge e tornam a causa de uma falha mais fácil de identificar. Também permitem que a equipe obtenha feedback rapidamente por meio de testes e validações automatizadas.

**Explicação didática:**  
Quando dez funcionalidades são integradas ao mesmo tempo, um teste quebrado pode ter várias causas. Quando uma pequena alteração é integrada por vez, a investigação é mais simples.

**Exemplo prático:**  
Uma equipe integra diversas vezes por dia usando branches curtas e pull requests pequenos.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve relacionar frequência de integração com redução de conflitos, menor tempo de diagnóstico e feedback antecipado.

**Resposta fraca ou incompleta:**  
“Porque o Git funciona melhor com commits pequenos.”  
Isso não aborda o principal benefício: validar continuamente o comportamento integrado.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como você reduziria conflitos em uma equipe grande?
2. O que faria se a branch principal estivesse quebrada?
3. Qual relação existe entre pull requests pequenos e CI?

---

## Pergunta 4 — Build

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que significa fazer o build de uma aplicação dentro de um pipeline?

**O que essa pergunta avalia:**  
Avalia se o candidato entende a transformação do código-fonte em um artefato executável ou distribuível.

**Resposta esperada:**  
Build é o processo de compilar, empacotar ou preparar a aplicação para execução. Dependendo da tecnologia, pode envolver compilação, transpilação, minificação, resolução de dependências, geração de binários, criação de imagem de contêiner ou empacotamento de arquivos.

**Explicação didática:**  
O código escrito pelo time nem sempre é diretamente o que será executado. O build produz uma versão pronta para ser testada ou implantada.

**Exemplo prático:**  
Uma aplicação Java pode gerar um arquivo JAR; uma aplicação frontend pode gerar arquivos estáticos; uma aplicação pode ser empacotada como imagem Docker.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar o propósito do build e distinguir código-fonte de artefato final.

**Resposta fraca ou incompleta:**  
“Build é rodar os testes.”  
Testes podem fazer parte do pipeline, mas não são necessariamente o build.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que o artefato deve ser versionado?
2. Qual a diferença entre gerar o artefato uma vez e reconstruí-lo em cada ambiente?
3. Como você investigaria uma falha de build?

---

## Pergunta 5 — Testes no pipeline

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Que tipos de testes você colocaria em um pipeline básico e em que ordem?

**O que essa pergunta avalia:**  
Avalia conhecimento inicial sobre testes automatizados e feedback rápido.

**Resposta esperada:**  
Um pipeline básico pode executar lint e verificações estáticas, testes unitários, testes de integração e, quando necessário, testes de aceitação ou ponta a ponta. Normalmente os testes rápidos vêm primeiro, seguidos pelos mais lentos, para obter feedback rapidamente.

**Explicação didática:**  
Testes unitários costumam ser rápidos e isolados. Testes de integração verificam componentes conectados. Testes ponta a ponta simulam o comportamento completo, mas geralmente são mais lentos e frágeis.

**Exemplo prático:**  
Se o lint falhar, não faz sentido iniciar testes demorados de navegador.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve apresentar uma ordem coerente e explicar que a ordem pode variar conforme custo e risco.

**Resposta fraca ou incompleta:**  
“Eu colocaria apenas testes de interface, porque são os mais próximos do usuário.”  
Isso tende a produzir feedback lento e não substitui testes unitários.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que testes unitários normalmente devem rodar antes dos testes de ponta a ponta?
2. O que você faria com testes instáveis?
3. Todos os testes precisam bloquear a implantação?

---

## Pergunta 6 — Falha de pipeline

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O que você faria ao receber uma notificação de que o pipeline falhou?

**O que essa pergunta avalia:**  
Avalia capacidade inicial de investigação e disciplina para não ignorar falhas.

**Resposta esperada:**  
O candidato deve abrir os logs, identificar a etapa que falhou, verificar a mensagem de erro, comparar com alterações recentes, reproduzir localmente quando possível e corrigir ou comunicar o problema. Não deve simplesmente executar novamente várias vezes sem entender a causa.

**Explicação didática:**  
O pipeline fornece evidências. A primeira etapa é localizar a falha; depois é necessário distinguir erro no código, no ambiente, na dependência, na configuração ou na própria infraestrutura da automação.

**Exemplo prático:**  
Se o teste falhou após uma alteração recente, o candidato verifica o teste, o diff e os dados usados. Se a falha for de download de dependência, verifica disponibilidade e cache.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar uma sequência de investigação baseada em evidências.

**Resposta fraca ou incompleta:**  
“Eu rodaria novamente até passar.”  
Isso pode esconder instabilidade e não resolve a causa.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como diferenciar uma falha intermitente de uma falha determinística?
2. Que informações você registraria no incidente?
3. Quando pediria ajuda a outra pessoa?

---

## Pergunta 7 — Branches e pull requests

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Como branches e pull requests podem ser utilizados em um processo de CI/CD?

**O que essa pergunta avalia:**  
Avalia entendimento de colaboração, revisão e validação automatizada.

**Resposta esperada:**  
Uma branch pode isolar uma alteração. Ao abrir um pull request, o pipeline executa validações automáticas e os colegas revisam o código. Após aprovação e sucesso das verificações, a alteração pode ser integrada à branch principal.

**Explicação didática:**  
O pull request funciona como ponto de controle de qualidade e colaboração. O pipeline evita que alterações obviamente inválidas avancem.

**Exemplo prático:**  
Uma regra do repositório pode impedir merge quando os testes falharem ou quando houver cobertura mínima não atingida.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar o fluxo completo e destacar que automação não substitui revisão humana em todos os casos.

**Resposta fraca ou incompleta:**  
“Branch é para cada pessoa trabalhar e pull request é só para aprovação.”  
A resposta não menciona validação automatizada nem integração.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que deve bloquear um merge?
2. Por que pull requests muito grandes são problemáticos?
3. Como lidar com uma branch que ficou muito tempo sem ser atualizada?

---

## Pergunta 8 — Artefatos

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é um artefato de build e por que ele é importante?

**O que essa pergunta avalia:**  
Avalia a compreensão de empacotamento, rastreabilidade e promoção entre ambientes.

**Resposta esperada:**  
Artefato é o resultado produzido pelo build, como um pacote, binário, imagem de contêiner ou conjunto de arquivos. Ele é importante porque pode ser armazenado, versionado, auditado e promovido entre ambientes sem reconstrução.

**Explicação didática:**  
Se cada ambiente gerar seu próprio build, pequenas diferenças podem introduzir comportamentos inesperados. Promover o mesmo artefato aumenta a consistência.

**Exemplo prático:**  
A imagem `app:1.8.2` é construída uma vez, testada em homologação e depois usada em produção.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve citar rastreabilidade e reprodução, além de dar exemplos.

**Resposta fraca ou incompleta:**  
“Artefato é qualquer arquivo temporário gerado pelo pipeline.”  
Nem todo arquivo temporário é um artefato relevante para entrega.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como você identificaria unicamente um artefato?
2. Por quanto tempo manteria artefatos?
3. Por que reconstruir o artefato em produção pode ser arriscado?

---

## Pergunta 9 — Variáveis de ambiente

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
Qual é a finalidade das variáveis de ambiente em um pipeline?

**O que essa pergunta avalia:**  
Avalia a separação entre código e configuração.

**Resposta esperada:**  
Variáveis de ambiente permitem fornecer configurações diferentes para cada contexto sem alterar o código, como URLs de serviços, nomes de ambiente, flags e parâmetros operacionais. Dados sensíveis não devem ser tratados como variáveis comuns expostas nos logs; devem usar um mecanismo de secrets.

**Explicação didática:**  
O mesmo artefato pode ser executado em desenvolvimento, homologação e produção com configurações diferentes. O código permanece igual, enquanto a configuração é injetada no ambiente.

**Exemplo prático:**  
`DATABASE_URL` pode apontar para bancos diferentes, mas sua senha deve ser armazenada com proteção adequada.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve diferenciar configuração de segredo e mencionar que não se deve gravar credenciais no repositório.

**Resposta fraca ou incompleta:**  
“Eu colocaria a senha em uma variável de ambiente no arquivo do projeto.”  
Se o arquivo for versionado, o segredo continua exposto.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde armazenaria credenciais usadas no pipeline?
2. Como evitaria que um segredo aparecesse nos logs?
3. O que significa promover o mesmo artefato usando configurações diferentes?

---

## Pergunta 10 — Secrets

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como você protegeria uma chave de acesso utilizada por um pipeline?

**O que essa pergunta avalia:**  
Avalia práticas básicas de segurança em automação.

**Resposta esperada:**  
A chave deve ser armazenada no mecanismo seguro de secrets da plataforma, nunca no código ou em arquivos versionados. O acesso deve seguir o princípio do menor privilégio, com escopo limitado, rotação periódica, mascaramento em logs e, quando possível, credenciais temporárias.

**Explicação didática:**  
O princípio do menor privilégio significa conceder apenas as permissões necessárias. Se uma chave usada para publicar artefatos também puder excluir bancos de dados, o impacto de um vazamento será maior.

**Exemplo prático:**  
Uma credencial usada para publicar uma imagem deve ter apenas permissão no repositório de imagens correspondente.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar armazenamento seguro, permissões mínimas e prevenção de exposição.

**Resposta fraca ou incompleta:**  
“Eu colocaria a chave em um arquivo `.env` e adicionaria ao `.gitignore`.”  
Isso reduz o risco de commit acidental, mas não substitui um cofre de secrets.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que fazer se a chave for publicada acidentalmente?
2. Como limitar a permissão dessa credencial?
3. Como automatizar a rotação?

---

## Pergunta 11 — Ambientes

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Qual é a diferença entre desenvolvimento, homologação e produção em um fluxo de CI/CD?

**O que essa pergunta avalia:**  
Avalia a compreensão do ciclo de promoção de software.

**Resposta esperada:**  
Desenvolvimento é usado para criação e experimentação; homologação ou staging aproxima-se da produção e serve para validação integrada; produção é o ambiente real dos usuários. Cada ambiente deve ter configurações, dados, permissões e controles apropriados.

**Explicação didática:**  
Ambientes permitem validar progressivamente uma mudança antes de expô-la a todos os usuários. Quanto mais próximo da produção for o ambiente de homologação, maior a qualidade da validação.

**Exemplo prático:**  
Uma alteração pode ser implantada automaticamente em staging, mas exigir aprovação antes de produção.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar o propósito de cada ambiente e evitar tratar produção como local de testes.

**Resposta fraca ou incompleta:**  
“São três servidores iguais, apenas com nomes diferentes.”  
Os controles, dados e permissões podem ser diferentes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que deve ser igual entre staging e produção?
2. Por que dados reais podem ser inadequados em homologação?
3. Quando uma aprovação manual faz sentido?

---

## Pergunta 12 — Rollback

**Nível:** Júnior  
**Categoria:** Operação

**Pergunta do entrevistador:**  
O que é rollback e em que situação ele pode ser necessário?

**O que essa pergunta avalia:**  
Avalia compreensão básica de reversão de uma implantação.

**Resposta esperada:**  
Rollback é retornar a uma versão anterior conhecida como estável quando a versão atual apresenta falhas. Pode ser necessário diante de erros críticos, aumento de falhas, degradação de desempenho ou comportamento incorreto.

**Explicação didática:**  
Rollback reduz o tempo de exposição ao problema, mas não elimina a necessidade de investigar e corrigir a causa. Nem todo rollback é simples, especialmente quando há alterações incompatíveis de banco de dados.

**Exemplo prático:**  
Após uma implantação, a taxa de erros aumenta. A equipe retorna à imagem anterior enquanto investiga o defeito.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar objetivo, gatilhos e limitações, especialmente relacionadas a banco de dados.

**Resposta fraca ou incompleta:**  
“Rollback é apagar o último commit.”  
Isso não necessariamente reverte uma versão já implantada nem trata migrações.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como fazer rollback de uma alteração de banco?
2. Qual a diferença entre rollback e roll-forward?
3. Como você testaria o procedimento de rollback?

---

## Pergunta 13 — Aprovação manual

**Nível:** Júnior  
**Categoria:** Governança

**Pergunta do entrevistador:**  
Por que alguns pipelines possuem uma aprovação manual antes da produção?

**O que essa pergunta avalia:**  
Avalia a compreensão de controles, risco e responsabilidade operacional.

**Resposta esperada:**  
A aprovação manual permite revisar evidências, confirmar janela de mudança, verificar comunicação e avaliar riscos antes de uma ação de alto impacto. Ela pode ser necessária por requisitos regulatórios ou pelo risco do sistema.

**Explicação didática:**  
Automação reduz erros repetitivos, mas uma etapa manual pode ser importante quando a decisão depende de contexto, impacto de negócio ou autorização formal.

**Exemplo prático:**  
Uma mudança em um sistema financeiro pode exigir aprovação após os testes de homologação e antes da implantação.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve evitar dizer que aprovação manual é sempre boa ou sempre ruim. O ideal é discutir risco e controles.

**Resposta fraca ou incompleta:**  
“É necessário porque nenhuma automação é confiável.”  
Isso demonstra desconfiança generalizada e não considera o risco específico.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que evidências você exigiria antes da aprovação?
2. Como evitar que uma aprovação vire um gargalo?
3. Em que cenário você removeria essa etapa?

---

## Pergunta 14 — Lint e análise estática

**Nível:** Júnior  
**Categoria:** Qualidade

**Pergunta do entrevistador:**  
Qual é o papel do lint e da análise estática em um pipeline?

**O que essa pergunta avalia:**  
Avalia conhecimento sobre verificações automáticas antes da execução da aplicação.

**Resposta esperada:**  
Lint verifica padrões de estilo, possíveis erros e regras de qualidade. Análise estática examina o código sem executá-lo e pode identificar problemas de complexidade, bugs prováveis, vulnerabilidades ou violações de padrões.

**Explicação didática:**  
Essas ferramentas automatizam verificações que seriam cansativas para humanos. Elas ajudam a manter consistência, mas não substituem testes nem revisão.

**Exemplo prático:**  
O pipeline pode falhar se houver erro de sintaxe, variável não utilizada ou vulnerabilidade de alta severidade.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar limites: uma análise estática pode gerar falsos positivos e não comprova que o sistema funciona corretamente.

**Resposta fraca ou incompleta:**  
“Lint testa a aplicação.”  
Lint geralmente analisa o código, não o comportamento completo da aplicação.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que você faria com falsos positivos?
2. Toda violação deve bloquear o pipeline?
3. Como definiria regras progressivamente mais rigorosas?

---

## Pergunta 15 — Dependências

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como o pipeline pode ajudar a identificar problemas em dependências externas?

**O que essa pergunta avalia:**  
Avalia noções de segurança de software e gerenciamento de dependências.

**Resposta esperada:**  
O pipeline pode executar verificações de vulnerabilidades conhecidas, manter dependências atualizadas, validar lockfiles, detectar licenças incompatíveis e gerar relatórios. Atualizações devem ser testadas e priorizadas conforme a severidade e o contexto de exploração.

**Explicação didática:**  
Uma dependência pode conter vulnerabilidades mesmo que o código da equipe esteja correto. Ferramentas automatizadas ajudam a identificar riscos, mas o resultado precisa ser analisado.

**Exemplo prático:**  
Uma atualização automática de dependência abre um pull request com testes e relatório de segurança.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar atualização controlada, testes e análise de severidade, sem sugerir atualizar tudo diretamente em produção.

**Resposta fraca ou incompleta:**  
“Basta instalar sempre a versão mais recente.”  
Versões novas podem introduzir incompatibilidades ou não resolver o risco real.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como priorizar uma vulnerabilidade encontrada?
2. O que fazer quando não há atualização compatível?
3. Como evitar dependências diferentes entre máquina local e pipeline?

---

## Pergunta 16 — Cache

**Nível:** Júnior  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
Por que um pipeline utiliza cache e quais cuidados devem ser tomados?

**O que essa pergunta avalia:**  
Avalia compreensão inicial de otimização de tempo e consistência.

**Resposta esperada:**  
Cache armazena dados que podem ser reutilizados, como dependências baixadas, reduzindo o tempo do pipeline. O cache deve possuir uma chave adequada, ser invalidado quando necessário e nunca armazenar segredos de forma insegura.

**Explicação didática:**  
O cache acelera tarefas repetitivas, mas pode causar resultados incorretos se dados antigos forem reutilizados depois de uma mudança.

**Exemplo prático:**  
O cache pode ser baseado no hash do arquivo de dependências. Quando esse arquivo muda, o cache é renovado.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve citar velocidade, invalidação e risco de resultados obsoletos.

**Resposta fraca ou incompleta:**  
“Cache deve durar para sempre para deixar o pipeline mais rápido.”  
Caches permanentes podem preservar dependências incorretas ou vulneráveis.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como saber quando invalidar o cache?
2. Que dados nunca deveriam ser armazenados em cache?
3. Como investigar uma falha que desaparece quando o cache é limpo?

---

## Pergunta 17 — Triggers

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Quais eventos podem iniciar um pipeline de CI/CD?

**O que essa pergunta avalia:**  
Avalia compreensão de automação orientada a eventos.

**Resposta esperada:**  
Um pipeline pode ser iniciado por push, pull request, criação de tag, merge na branch principal, agendamento, acionamento manual ou evento externo, como publicação de uma imagem ou conclusão de outro pipeline.

**Explicação didática:**  
O evento deve estar alinhado ao objetivo. Pull requests normalmente executam validações; tags podem iniciar publicação de versões; merges podem promover código para um ambiente.

**Exemplo prático:**  
Todo pull request roda testes, mas somente uma tag semântica gera uma versão oficial.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve relacionar cada trigger a uma finalidade e mencionar cuidado para não implantar produção em eventos inadequados.

**Resposta fraca ou incompleta:**  
“Todo commit deve ir automaticamente para produção.”  
Isso ignora controles, risco e diferenças entre validação e implantação.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que evento você usaria para publicar uma versão?
2. Como evitar execuções duplicadas?
3. Quando um acionamento manual é útil?

---

## Pergunta 18 — Branch principal

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Por que a branch principal deve permanecer sempre em estado implantável?

**O que essa pergunta avalia:**  
Avalia disciplina de integração e estabilidade.

**Resposta esperada:**  
Uma branch principal estável representa uma versão integrada e validada do sistema. Isso permite corrigir problemas rapidamente, gerar releases previsíveis e reduzir o risco de integrações acumuladas.

**Explicação didática:**  
Se a branch principal fica quebrada por dias, outras alterações continuam sendo baseadas em uma referência inválida. A equipe perde confiança no pipeline.

**Exemplo prático:**  
Regras de proteção impedem merge sem revisão e sem sucesso nos testes obrigatórios.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve relacionar estabilidade com capacidade de entrega e recuperação.

**Resposta fraca ou incompleta:**  
“Porque é uma convenção do Git.”  
A prática é operacional e de qualidade, não apenas uma convenção de nomenclatura.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que fazer quando a branch principal quebra?
2. Como reduzir o tempo até a correção?
3. É obrigatório usar uma estratégia específica de branches?

---

## Pergunta 19 — Reprodutibilidade

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que significa dizer que um pipeline é reprodutível?

**O que essa pergunta avalia:**  
Avalia compreensão de consistência entre execuções.

**Resposta esperada:**  
Um pipeline reprodutível tende a produzir o mesmo resultado quando executado com o mesmo código, configuração e dependências. Isso exige controlar versões, ambientes, ferramentas, imagens-base e fontes de dependência.

**Explicação didática:**  
Se o pipeline instala “a versão mais recente” de algo, duas execuções do mesmo commit podem apresentar resultados diferentes. Fixar versões reduz esse risco.

**Exemplo prático:**  
Usar lockfile e imagem de execução versionada.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar versões fixadas, dependências controladas e separação entre resultado do código e mudanças externas.

**Resposta fraca ou incompleta:**  
“É executar duas vezes e obter exatamente o mesmo tempo.”  
Reprodutibilidade trata principalmente do resultado, não do tempo exato.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quais fontes de não reprodutibilidade você conhece?
2. Como contêineres ajudam nesse problema?
3. Fixar todas as versões tem algum custo?

---

## Pergunta 20 — Idempotência

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que significa que uma etapa de implantação é idempotente?

**O que essa pergunta avalia:**  
Avalia compreensão de execução repetível sem efeitos acumulativos indesejados.

**Resposta esperada:**  
Uma operação idempotente pode ser executada várias vezes e produzir o mesmo estado final esperado. Em CI/CD, isso significa que repetir uma implantação não deve criar recursos duplicados ou corromper o ambiente.

**Explicação didática:**  
Se executar novamente uma configuração cria mais uma regra, mais um usuário ou mais um serviço a cada vez, ela não é idempotente.

**Exemplo prático:**  
Uma ferramenta declarativa verifica se um recurso já existe e ajusta seu estado em vez de criá-lo novamente.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve diferenciar “executar duas vezes” de “ter o mesmo estado final” e dar um exemplo.

**Resposta fraca ou incompleta:**  
“Idempotente significa que nunca falha.”  
Uma operação idempotente ainda pode falhar; a propriedade trata do efeito de repetições.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que idempotência é importante após uma falha parcial?
2. Como você testaria essa propriedade?
3. Que operações são naturalmente difíceis de tornar idempotentes?

---

## Pergunta 21 — Logs

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Que informações você procuraria nos logs de uma execução que falhou?

**O que essa pergunta avalia:**  
Avalia capacidade de leitura de logs e diagnóstico inicial.

**Resposta esperada:**  
O candidato deve procurar a etapa da falha, mensagem de erro, código de saída, comando executado, contexto da execução, versão do commit, ambiente e eventos imediatamente anteriores. Também deve verificar se os logs podem conter segredos expostos.

**Explicação didática:**  
A primeira mensagem de erro nem sempre é a causa raiz. É importante observar a sequência e identificar o primeiro evento anormal.

**Exemplo prático:**  
Um erro de implantação pode ser consequência de uma imagem que não foi publicada anteriormente.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar que investigaria contexto e correlação, não apenas a última linha do log.

**Resposta fraca ou incompleta:**  
“Eu leria a última linha.”  
A última linha pode apenas informar que o processo terminou, sem explicar a causa.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como identificaria a primeira causa relevante?
2. Como evitaria exposição de segredos?
3. Qual informação deveria acompanhar um log de pipeline?

---

## Pergunta 22 — Notificações

**Nível:** Júnior  
**Categoria:** Operação

**Pergunta do entrevistador:**  
Como as notificações de CI/CD devem ser utilizadas pela equipe?

**O que essa pergunta avalia:**  
Avalia compreensão de comunicação operacional e prevenção de fadiga de alertas.

**Resposta esperada:**  
Notificações devem ser direcionadas às pessoas responsáveis, conter contexto suficiente e indicar ação esperada. Falhas importantes devem gerar alertas, enquanto eventos rotineiros podem ser consultados em painéis para evitar excesso de mensagens.

**Explicação didática:**  
Se toda execução enviar alerta para todos, a equipe pode ignorar mensagens importantes. A qualidade do alerta é mais relevante que a quantidade.

**Exemplo prático:**  
Uma falha na branch principal pode notificar a equipe responsável; uma falha em uma branch experimental pode ficar visível no pull request.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar contexto, responsabilidade e redução de ruído.

**Resposta fraca ou incompleta:**  
“Enviar todas as notificações para o grupo inteiro.”  
Isso pode gerar fadiga e falta de responsabilidade clara.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual falha merece escalonamento imediato?
2. Como medir se os alertas são úteis?
3. Como tratar notificações repetitivas?

---

## Pergunta 23 — Contêineres

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Por que contêineres são frequentemente usados em pipelines de CI/CD?

**O que essa pergunta avalia:**  
Avalia compreensão básica de padronização do ambiente.

**Resposta esperada:**  
Contêineres empacotam a aplicação e parte de suas dependências em uma unidade reproduzível. Isso reduz diferenças entre ambientes e facilita o transporte do artefato entre CI, homologação e produção.

**Explicação didática:**  
O contêiner não elimina todos os problemas de ambiente, mas ajuda a padronizar sistema operacional, bibliotecas e processo de execução.

**Exemplo prático:**  
O pipeline constrói uma imagem, executa testes usando essa imagem e promove a mesma imagem para outros ambientes.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve citar consistência e empacotamento, sem afirmar que contêiner é igual a máquina virtual.

**Resposta fraca ou incompleta:**  
“Contêiner garante segurança total e funciona exatamente como uma máquina virtual.”  
Ambas as afirmações são exageradas ou incorretas.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quais riscos existem em imagens de contêiner?
2. Como reduzir o tamanho de uma imagem?
3. Por que a imagem deve ser identificada por versão ou digest?

---

## Pergunta 24 — Imagens de contêiner

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Quais cuidados você tomaria ao construir uma imagem de contêiner no pipeline?

**O que essa pergunta avalia:**  
Avalia práticas básicas de segurança e qualidade de imagens.

**Resposta esperada:**  
Usaria imagem-base confiável e atualizada, reduziria componentes desnecessários, evitaria executar como root, verificaria vulnerabilidades, fixaria versões quando adequado e não incluiria segredos na imagem. Também definiria tags rastreáveis.

**Explicação didática:**  
Tudo que é incluído na imagem pode aumentar superfície de ataque e tamanho. Segredos incorporados podem permanecer no histórico de camadas mesmo após serem removidos em uma etapa posterior.

**Exemplo prático:**  
A imagem é escaneada antes de ser publicada no registro.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar segurança, rastreabilidade e menor privilégio.

**Resposta fraca ou incompleta:**  
“Basta usar a imagem oficial mais recente.”  
Isso não elimina vulnerabilidades nem garante configuração segura.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que executar como root é arriscado?
2. Como tratar uma vulnerabilidade na imagem-base?
3. Como impedir que um segredo seja incorporado?

---

## Pergunta 25 — Versionamento

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Como você versionaria artefatos e releases em um processo de CI/CD?

**O que essa pergunta avalia:**  
Avalia rastreabilidade e organização de versões.

**Resposta esperada:**  
Usaria identificadores únicos e rastreáveis, como versão semântica, número de build, hash do commit ou combinação desses elementos. A versão deve permitir relacionar o artefato ao código-fonte, às configurações e aos resultados dos testes.

**Explicação didática:**  
Uma tag genérica como `latest` não é suficiente para auditoria, pois seu conteúdo pode mudar. É preferível ter uma versão imutável e, se necessário, uma tag móvel apenas como conveniência.

**Exemplo prático:**  
`app:2.4.1` e `app:git-a1b2c3d`.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar imutabilidade e rastreabilidade.

**Resposta fraca ou incompleta:**  
“Usaria sempre `latest` porque é mais simples.”  
Isso dificulta identificar exatamente o que foi implantado.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que o hash do commit é útil?
2. Quando usar versão semântica?
3. Como evitar que um artefato seja sobrescrito?

---

## Pergunta 26 — Testes de fumaça

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
O que são testes de fumaça e quando eles devem ser executados?

**O que essa pergunta avalia:**  
Avalia compreensão de validações rápidas após implantação.

**Resposta esperada:**  
Testes de fumaça são verificações simples que confirmam se a aplicação está minimamente funcional, como responder a uma requisição básica, iniciar corretamente e acessar uma dependência essencial. Podem rodar logo após a implantação em um ambiente.

**Explicação didática:**  
Eles não validam todos os comportamentos, mas detectam falhas graves rapidamente.

**Exemplo prático:**  
Após implantar um serviço, o pipeline verifica se o endpoint de saúde retorna sucesso e se uma operação básica funciona.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve destacar que são rápidos e complementares a testes mais completos.

**Resposta fraca ou incompleta:**  
“Teste de fumaça substitui todos os testes.”  
Ele cobre apenas uma parte pequena do comportamento.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que você verificaria em um teste de fumaça?
2. O que fazer se ele falhar após a implantação?
3. Qual a diferença entre teste de fumaça e health check?

---

## Pergunta 27 — Health check

**Nível:** Júnior  
**Categoria:** Operação

**Pergunta do entrevistador:**  
Qual é a finalidade de um health check em uma aplicação implantada?

**O que essa pergunta avalia:**  
Avalia compreensão básica de disponibilidade e validação operacional.

**Resposta esperada:**  
Health checks fornecem informações sobre o estado de um serviço. Um check de disponibilidade verifica se o processo responde; um check de prontidão pode confirmar se o serviço está apto a receber tráfego, incluindo dependências essenciais.

**Explicação didática:**  
Um processo pode estar ativo, mas incapaz de atender requisições corretamente. Por isso, o tipo de verificação deve refletir o objetivo.

**Exemplo prático:**  
Um serviço pode estar vivo, mas ainda não estar pronto enquanto não conecta ao banco necessário.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve diferenciar disponibilidade de prontidão e evitar checks excessivamente complexos.

**Resposta fraca ou incompleta:**  
“Health check apenas verifica se a porta está aberta.”  
Isso pode não indicar que o serviço está funcional.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O health check deve acessar o banco?
2. Como evitar que o check cause sobrecarga?
3. O que deve acontecer quando o check falha?

---

## Pergunta 28 — Branch protection

**Nível:** Júnior  
**Categoria:** Governança

**Pergunta do entrevistador:**  
Que regras você configuraria para proteger a branch principal?

**O que essa pergunta avalia:**  
Avalia maturidade inicial em controles de qualidade.

**Resposta esperada:**  
Exigiria pull request, revisão por pares, sucesso dos checks obrigatórios, resolução de conversas, histórico adequado e permissões restritas. Dependendo do contexto, exigiria assinaturas, aprovação de responsáveis e atualização da branch.

**Explicação didática:**  
A proteção reduz a chance de inserir código não validado ou não revisado. As regras devem ser proporcionais ao risco e não tão rígidas que incentivem contornos informais.

**Exemplo prático:**  
Nenhum merge ocorre se os testes obrigatórios falharem.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve citar qualidade e governança, mas reconhecer que regras precisam ser mantidas e revisadas.

**Resposta fraca ou incompleta:**  
“Eu bloquearia tudo e somente uma pessoa poderia fazer merge.”  
Isso cria dependência e gargalo desnecessário.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quais checks devem ser obrigatórios?
2. Quando uma exceção emergencial poderia existir?
3. Como evitar que a proteção impeça correções urgentes?

---

## Pergunta 29 — Testes locais e CI

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Por que é útil executar localmente as mesmas validações que rodam no CI?

**O que essa pergunta avalia:**  
Avalia capacidade de reduzir feedback lento e inconsistências.

**Resposta esperada:**  
Executar localmente as mesmas validações permite detectar problemas antes de enviar o código, reduz o tempo de feedback e evita falhas previsíveis no pipeline. Ainda assim, o CI continua necessário como fonte confiável e ambiente controlado.

**Explicação didática:**  
A execução local ajuda o desenvolvedor, enquanto o CI garante que a validação ocorra de forma independente e padronizada.

**Exemplo prático:**  
Um comando único executa lint, testes e verificações que também são executados no pipeline.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve falar sobre paridade, velocidade e limites do ambiente local.

**Resposta fraca ou incompleta:**  
“Se passou localmente, não precisa rodar no CI.”  
O ambiente local pode estar diferente ou a validação pode ser omitida.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como reduzir diferenças entre ambiente local e CI?
2. O que fazer quando funciona localmente e falha no CI?
3. Como tornar os comandos fáceis de executar?

---

## Pergunta 30 — Dependência entre jobs

**Nível:** Júnior  
**Categoria:** Pipeline

**Pergunta do entrevistador:**  
Quando uma etapa do pipeline deve depender de outra e quando elas podem rodar em paralelo?

**O que essa pergunta avalia:**  
Avalia noções de fluxo, dependências e otimização.

**Resposta esperada:**  
Uma etapa deve depender de outra quando precisa de seu resultado, como implantação dependendo do artefato construído. Etapas independentes, como lint e testes unitários, podem rodar em paralelo para reduzir tempo.

**Explicação didática:**  
Paralelismo aumenta velocidade, mas só é seguro quando não há dependência de dados ou estado.

**Exemplo prático:**  
Testes unitários e análise estática executam simultaneamente; a publicação aguarda ambos.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve considerar dependências reais e o custo de aumentar complexidade.

**Resposta fraca ou incompleta:**  
“Tudo deve rodar em paralelo para ser mais rápido.”  
Isso pode gerar condições de corrida e resultados inválidos.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que precisa estar pronto antes da implantação?
2. Como lidar com etapas que usam o mesmo recurso?
3. Qual custo o paralelismo pode introduzir?

---

## Pergunta 31 — Tempo de feedback

**Nível:** Júnior  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
Por que o tempo de feedback do pipeline é importante para a equipe?

**O que essa pergunta avalia:**  
Avalia compreensão de produtividade e qualidade do processo.

**Resposta esperada:**  
Feedback rápido permite corrigir problemas enquanto o contexto ainda está presente, reduz espera e incentiva integrações frequentes. Porém, reduzir tempo não deve significar remover validações essenciais.

**Explicação didática:**  
Um pipeline que demora horas pode fazer a equipe acumular alterações. Um pipeline rápido e confiável favorece ciclos menores.

**Exemplo prático:**  
Testes rápidos rodam em todo pull request, enquanto testes extensos rodam em paralelo ou em etapas específicas.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve discutir velocidade junto com confiabilidade.

**Resposta fraca ou incompleta:**  
“Quanto mais rápido, melhor, mesmo que os testes sejam removidos.”  
Isso otimiza uma métrica sacrificando o objetivo do processo.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como reduzir o tempo sem perder qualidade?
2. Qual etapa costuma ser o gargalo?
3. Como medir a confiabilidade do pipeline?

---

## Pergunta 32 — Pipeline como código

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que significa manter o pipeline como código?

**O que essa pergunta avalia:**  
Avalia compreensão de versionamento e revisão da automação.

**Resposta esperada:**  
Pipeline como código significa definir sua configuração em arquivos versionados junto ao projeto ou em um repositório controlado. Isso permite revisão, histórico, auditoria, reutilização e reprodução.

**Explicação didática:**  
Em vez de configurar tudo manualmente pela interface, a definição pode ser revisada como qualquer alteração de software.

**Exemplo prático:**  
Uma mudança na etapa de testes é enviada em um pull request e passa pelas mesmas revisões.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar versionamento e revisão, além de reconhecer que alguns segredos ou configurações externas não devem estar no arquivo.

**Resposta fraca ou incompleta:**  
“Pipeline como código é escrever qualquer script.”  
O conceito inclui versionamento, governança e execução automatizada.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como testar uma alteração no próprio pipeline?
2. Onde os segredos devem ficar?
3. Que riscos existem em duplicar arquivos de pipeline?

---

## Pergunta 33 — Permissões

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Por que as permissões do agente de CI/CD devem ser limitadas?

**O que essa pergunta avalia:**  
Avalia compreensão do princípio do menor privilégio.

**Resposta esperada:**  
Se o agente ou uma credencial for comprometido, permissões limitadas reduzem o impacto. Cada job deve acessar apenas os recursos necessários para sua função.

**Explicação didática:**  
Um job de testes não precisa necessariamente publicar em produção. Separar responsabilidades limita danos.

**Exemplo prático:**  
Um job de build pode escrever no registro de artefatos, enquanto o job de produção usa uma identidade diferente com aprovação adicional.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar escopo, separação e impacto de comprometimento.

**Resposta fraca ou incompleta:**  
“Usaria uma conta administrativa para evitar problemas de permissão.”  
Isso aumenta muito o risco de segurança.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como separar permissões de build e deploy?
2. O que fazer com permissões herdadas?
3. Como revisar permissões regularmente?

---

## Pergunta 34 — Entrega manual versus automática

**Nível:** Júnior  
**Categoria:** Governança

**Pergunta do entrevistador:**  
Quais são as vantagens e desvantagens de uma implantação manual em comparação com uma implantação automatizada?

**O que essa pergunta avalia:**  
Avalia capacidade de comparar abordagens.

**Resposta esperada:**  
A implantação manual pode ser útil em situações excepcionais ou com alto grau de julgamento, mas é mais sujeita a erro humano, difícil de reproduzir e menos auditável. A automatizada é consistente, rápida e rastreável, mas exige investimento, controles e manutenção.

**Explicação didática:**  
A automação não elimina decisões; ela transforma procedimentos repetitivos em processos previsíveis.

**Exemplo prático:**  
Uma organização pode automatizar a implantação até staging e exigir aprovação antes da execução automatizada em produção.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve discutir contexto, risco, frequência e auditabilidade.

**Resposta fraca ou incompleta:**  
“Manual é sempre melhor porque dá mais controle.”  
Controle manual pode significar maior variabilidade e menor rastreabilidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que etapa você manteria manual em um sistema crítico?
2. Como auditar uma implantação manual?
3. Como migrar gradualmente de manual para automatizado?

---

# Parte 2 — Nível Pleno

## Pergunta 35 — Estratégia de branches

**Nível:** Pleno  
**Categoria:** Arquitetura de processo

**Pergunta do entrevistador:**  
Compare trunk-based development, GitFlow e desenvolvimento baseado em branches de feature. Em que contexto cada abordagem pode fazer sentido?

**O que essa pergunta avalia:**  
Avalia tomada de decisão sobre fluxo de desenvolvimento e integração.

**Resposta esperada:**  
Trunk-based favorece branches curtas e integração frequente, sendo adequado para equipes com bons testes e automação. GitFlow separa branches de desenvolvimento, release e hotfix, podendo fazer sentido em produtos com releases planejados, mas adiciona complexidade. Branches de feature oferecem isolamento, porém branches longas aumentam conflitos e divergência.

**Explicação didática:**  
Não existe uma estratégia universalmente correta. A escolha depende da frequência de entrega, maturidade de testes, necessidade de manutenção de versões e modelo de negócio.

**Exemplo prático:**  
Uma equipe que implanta várias vezes ao dia pode preferir trunk-based com feature flags.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve comparar benefícios, custos e pré-requisitos, sem defender uma estratégia por dogma.

**Resposta fraca ou incompleta:**  
“GitFlow é sempre o padrão profissional.”  
A resposta ignora contexto e custo de branches permanentes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como você entregaria uma funcionalidade incompleta sem quebrar produção?
2. Quando branches longas são justificáveis?
3. Como medir se o fluxo escolhido está funcionando?

---

## Pergunta 36 — Feature flags

**Nível:** Pleno  
**Categoria:** Entrega

**Pergunta do entrevistador:**  
Como feature flags podem reduzir riscos em uma estratégia de CI/CD?

**O que essa pergunta avalia:**  
Avalia uso de desacoplamento entre implantação e ativação de funcionalidades.

**Resposta esperada:**  
Feature flags permitem implantar código desativado e ativá-lo gradualmente, por grupo de usuários, ambiente ou condição. Elas reduzem risco de lançamento, possibilitam testes controlados e facilitam rollback funcional, mas introduzem complexidade e dívida de configuração.

**Explicação didática:**  
Implantação coloca o código no ambiente; ativação decide quem pode utilizá-lo. Separar essas ações dá mais controle.

**Exemplo prático:**  
Uma funcionalidade é ativada para 1% dos usuários, monitorada e depois expandida.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar expiração das flags, governança, segurança e consistência entre usuários.

**Resposta fraca ou incompleta:**  
“Feature flag é uma variável booleana que pode ficar para sempre.”  
Flags permanentes aumentam complexidade e podem causar comportamento inesperado.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como remover uma flag antiga?
2. Como evitar que uma flag seja alterada sem auditoria?
3. Como testar todas as combinações relevantes?

---

## Pergunta 37 — Estratégias de implantação

**Nível:** Pleno  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
Compare rolling deployment, blue-green e canary deployment.

**O que essa pergunta avalia:**  
Avalia conhecimento de estratégias de redução de risco durante implantação.

**Resposta esperada:**  
Rolling substitui instâncias gradualmente; é eficiente, mas pode manter versões diferentes simultaneamente. Blue-green mantém dois ambientes e alterna o tráfego, facilitando rollback, mas pode exigir o dobro de recursos. Canary direciona uma pequena parcela do tráfego para a nova versão, permitindo observar métricas antes da expansão, mas exige roteamento e observabilidade adequados.

**Explicação didática:**  
A escolha depende de custo, capacidade de controlar tráfego, tempo de rollback e compatibilidade entre versões.

**Exemplo prático:**  
Uma API de alto risco pode usar canary com aumento gradual de 1%, 10%, 25% e 100%.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve comparar custo, risco, complexidade, rollback e observabilidade.

**Resposta fraca ou incompleta:**  
“Canary é apenas implantar em um servidor qualquer.”  
Canary depende de controle deliberado de tráfego e critérios de promoção.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quais métricas usaria para promover um canary?
2. Como tratar migrações de banco nesse contexto?
3. Em que cenário blue-green seria inviável?

---

## Pergunta 38 — Contratos de API

**Nível:** Pleno  
**Categoria:** Integração

**Pergunta do entrevistador:**  
Como incorporar testes de contrato em um pipeline com vários serviços?

**O que essa pergunta avalia:**  
Avalia integração entre equipes e prevenção de incompatibilidades.

**Resposta esperada:**  
Testes de contrato verificam se produtor e consumidor concordam sobre formato, campos, códigos e comportamentos de uma interface. Podem ser executados no CI de cada serviço e contra contratos versionados, permitindo detectar incompatibilidades antes da implantação integrada.

**Explicação didática:**  
Testes unitários validam componentes isolados; testes de contrato validam o acordo entre sistemas sem necessariamente subir toda a plataforma.

**Exemplo prático:**  
Uma alteração que remove um campo obrigatório falha no pipeline do produtor porque quebra consumidores conhecidos.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve diferenciar contrato de teste ponta a ponta e discutir compatibilidade retroativa.

**Resposta fraca ou incompleta:**  
“Basta rodar testes ponta a ponta de todos os serviços em cada commit.”  
Pode ser caro, lento e difícil de manter.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como lidar com mudanças compatíveis e incompatíveis?
2. Quem deve ser responsável pelo contrato?
3. Quando um teste ponta a ponta ainda é necessário?

---

## Pergunta 39 — Migrações de banco

**Nível:** Pleno  
**Categoria:** Dados

**Pergunta do entrevistador:**  
Como você projetaria uma migração de banco de dados compatível com implantação gradual?

**O que essa pergunta avalia:**  
Avalia compatibilidade entre versões e segurança operacional.

**Resposta esperada:**  
Usaria o padrão expand-and-contract: primeiro adicionaria estruturas compatíveis sem remover o que a versão antiga usa; depois implantaria código que escreve ou lê de forma compatível; migraria dados; e somente após confirmação removeria estruturas antigas.

**Explicação didática:**  
Em uma implantação gradual, versões antigas e novas podem coexistir. Uma alteração destrutiva imediata pode quebrar instâncias que ainda não foram atualizadas.

**Exemplo prático:**  
Adicionar uma nova coluna nullable, escrever nela, backfill dos dados, mudar leitores e só então remover a coluna antiga.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar compatibilidade, rollback, backfill, tempo de execução e observabilidade.

**Resposta fraca ou incompleta:**  
“Executaria o script de alteração antes de publicar a nova versão.”  
Isso pode funcionar em casos simples, mas é insuficiente para mudanças incompatíveis ou ambientes distribuídos.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como reverter uma migração destrutiva?
2. Como monitorar o backfill?
3. O que fazer quando a migração leva mais tempo que a janela disponível?

---

## Pergunta 40 — Pipeline seguro

**Nível:** Pleno  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Quais controles de segurança você colocaria em um pipeline de CI/CD?

**O que essa pergunta avalia:**  
Avalia capacidade de estruturar DevSecOps.

**Resposta esperada:**  
Incluiria análise estática, verificação de dependências, secret scanning, análise de imagens, testes dinâmicos quando aplicável, controle de permissões, proteção de branches, revisão de mudanças, assinatura ou atestação de artefatos e auditoria de implantações.

**Explicação didática:**  
Segurança deve estar distribuída ao longo do ciclo, não concentrada apenas em uma revisão final.

**Exemplo prático:**  
Um pipeline bloqueia uma imagem com vulnerabilidade crítica explorável e registra exceções aprovadas.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve organizar controles por etapa e falar sobre equilíbrio entre segurança e fluxo de entrega.

**Resposta fraca ou incompleta:**  
“Adicionar um antivírus no servidor de CI.”  
Isso não cobre código, dependências, credenciais, artefatos e permissões.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quais verificações devem bloquear o pipeline?
2. Como tratar vulnerabilidades sem correção disponível?
3. Como proteger o próprio servidor de CI?

---

## Pergunta 41 — OIDC e credenciais temporárias

**Nível:** Pleno  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Por que credenciais temporárias ou federação de identidade podem ser preferíveis a chaves estáticas em CI/CD?

**O que essa pergunta avalia:**  
Avalia maturidade em gestão de identidade e redução de segredos persistentes.

**Resposta esperada:**  
Credenciais temporárias reduzem o período de exposição e podem ser emitidas com base na identidade do job, repositório, branch e ambiente. Isso evita armazenar chaves de longa duração e permite políticas mais específicas.

**Explicação didática:**  
Uma chave estática pode permanecer válida por meses após vazada. Uma credencial temporária expira e pode ser restringida a uma execução ou contexto.

**Exemplo prático:**  
Um job assume uma identidade de implantação somente quando executado a partir da branch protegida e após aprovação.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar expiração, condições de confiança, escopo e auditoria.

**Resposta fraca ou incompleta:**  
“Chaves estáticas são melhores porque são mais fáceis de configurar.”  
Facilidade inicial não compensa o risco de permanência e reutilização.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que atributos você usaria para restringir a confiança?
2. Como investigar um uso indevido?
3. Há algum caso em que uma chave estática ainda seja necessária?

---

## Pergunta 42 — Testes flaky

**Nível:** Pleno  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Como você trataria testes intermitentes que falham e passam sem alteração de código?

**O que essa pergunta avalia:**  
Avalia capacidade de lidar com instabilidade sem mascarar defeitos.

**Resposta esperada:**  
Identificaria frequência, padrão e ambiente da falha; coletaria logs, traces e artefatos; tentaria reproduzir; investigaria concorrência, dependência externa, tempo, dados compartilhados e ordem de execução. O teste pode ser isolado temporariamente, mas com responsável e prazo para correção. Reexecutar automaticamente deve ser usado com cuidado.

**Explicação didática:**  
Um retry pode reduzir falsos bloqueios, mas também esconder problemas reais e distorcer a confiança no pipeline.

**Exemplo prático:**  
Um teste que depende de horário local pode falhar em determinados agentes. A correção é controlar o relógio, não apenas repetir a execução.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar diagnóstico, contenção e eliminação da causa.

**Resposta fraca ou incompleta:**  
“Configuraria três tentativas e ignoraria se uma passasse.”  
Isso transforma instabilidade em comportamento normalizado.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como medir a taxa de flakiness?
2. Quando bloquear ou desbloquear um teste?
3. Que causas comuns você investigaria primeiro?

---

## Pergunta 43 — Cobertura de testes

**Nível:** Pleno  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Como você usaria cobertura de testes em um pipeline sem transformar o percentual em objetivo isolado?

**O que essa pergunta avalia:**  
Avalia visão crítica sobre métricas de qualidade.

**Resposta esperada:**  
Usaria cobertura como indicador, combinada com qualidade dos casos, risco de negócio, mutação, falhas reais e revisão. Um limiar pode impedir regressões, mas não garante que os testes validem cenários importantes.

**Explicação didática:**  
É possível alcançar alta cobertura executando linhas sem verificar resultados relevantes. A cobertura mostra o que foi executado, não necessariamente o que foi validado.

**Exemplo prático:**  
Um serviço crítico pode exigir cobertura mínima em código novo, mas também testes específicos de autorização e falhas.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve discutir métrica, contexto e risco de otimização artificial.

**Resposta fraca ou incompleta:**  
“Basta exigir 100% de cobertura.”  
Isso pode gerar testes artificiais e custo desproporcional.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Qual a diferença entre cobertura de linha e cobertura de decisão?
2. Como definir um limiar?
3. Que sinais indicam testes de baixa qualidade?

---

## Pergunta 44 — Artefato imutável

**Nível:** Pleno  
**Categoria:** Entrega

**Pergunta do entrevistador:**  
O que é um artefato imutável e por que ele favorece a confiabilidade das entregas?

**O que essa pergunta avalia:**  
Avalia rastreabilidade e consistência da promoção entre ambientes.

**Resposta esperada:**  
É um artefato cujo conteúdo não muda depois de publicado. Cada versão possui identificador próprio. Isso permite saber exatamente o que foi testado e garante que o mesmo conteúdo seja promovido para produção.

**Explicação didática:**  
Se uma tag puder apontar para conteúdos diferentes, o histórico da implantação fica ambíguo. Imutabilidade facilita auditoria e rollback.

**Exemplo prático:**  
Usar digest de imagem ou pacote com checksum.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar promoção, checksum, tags e riscos de sobrescrita.

**Resposta fraca ou incompleta:**  
“É um artefato que nunca pode ser excluído.”  
Imutabilidade do conteúdo não significa retenção infinita.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como lidar com artefatos vulneráveis já publicados?
2. Tags móveis podem coexistir com identificadores imutáveis?
3. Como verificar integridade do artefato?

---

## Pergunta 45 — Promoção entre ambientes

**Nível:** Pleno  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
Por que é preferível promover o mesmo artefato entre ambientes em vez de reconstruir a aplicação em cada etapa?

**O que essa pergunta avalia:**  
Avalia consistência, rastreabilidade e controle de configuração.

**Resposta esperada:**  
Promover o mesmo artefato elimina diferenças causadas por compiladores, dependências, horários ou ambientes de build. O que muda entre ambientes deve ser configuração externa, permissões e infraestrutura, não o conteúdo do artefato.

**Explicação didática:**  
A aplicação testada em homologação deve ser a mesma que chegará à produção. Reconstruir cria uma nova oportunidade para divergência.

**Exemplo prático:**  
Uma imagem é gerada no CI, escaneada, testada em staging e referenciada pelo digest em produção.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar separação entre artefato e configuração.

**Resposta fraca ou incompleta:**  
“Reconstruir é melhor porque compila no ambiente final.”  
Isso sacrifica rastreabilidade e consistência.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que diferenças entre ambientes ainda podem existir?
2. Como versionar configuração?
3. Como verificar que o artefato promovido é exatamente o testado?

---

## Pergunta 46 — Infraestrutura como código

**Nível:** Pleno  
**Categoria:** Infraestrutura

**Pergunta do entrevistador:**  
Como infraestrutura como código se relaciona com CI/CD?

**O que essa pergunta avalia:**  
Avalia integração entre entrega de software e provisionamento controlado.

**Resposta esperada:**  
Infraestrutura como código define recursos por meio de arquivos versionados, revisáveis e aplicáveis de forma automatizada. O pipeline pode validar, planejar e aplicar mudanças com controles apropriados. Isso melhora reprodutibilidade, auditoria e consistência.

**Explicação didática:**  
A mesma disciplina aplicada ao código da aplicação pode ser aplicada à infraestrutura. Ainda assim, mudanças destrutivas exigem análise de impacto e proteção adicional.

**Exemplo prático:**  
Um pull request exibe o plano de mudanças e exige aprovação antes de alterar a infraestrutura de produção.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar plan, revisão, drift, estado e aprovações.

**Resposta fraca ou incompleta:**  
“É um script que cria servidores.”  
A definição é estreita e não aborda versionamento nem controle do estado.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como tratar alterações destrutivas?
2. O que é drift de infraestrutura?
3. Como proteger o estado da infraestrutura?

---

## Pergunta 47 — Ambientes efêmeros

**Nível:** Pleno  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Em que situações ambientes efêmeros associados a pull requests são úteis?

**O que essa pergunta avalia:**  
Avalia capacidade de melhorar validação e colaboração.

**Resposta esperada:**  
Ambientes efêmeros permitem que cada alteração seja implantada em um ambiente temporário para testes, revisão visual ou validação integrada. Devem ter ciclo de vida controlado, isolamento, dados adequados e limpeza automática para evitar custos e acúmulo de recursos.

**Explicação didática:**  
Eles aproximam o teste do comportamento real, mas aumentam complexidade de infraestrutura e gestão de dados.

**Exemplo prático:**  
Um link temporário permite ao revisor testar uma funcionalidade antes do merge.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve discutir benefício, custo, segurança e limpeza.

**Resposta fraca ou incompleta:**  
“Criaria um ambiente permanente para cada branch.”  
Isso gera custo e problemas de manutenção.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como controlar custos?
2. Como gerar dados de teste seguros?
3. Como garantir que o ambiente seja destruído?

---

## Pergunta 48 — Paralelismo

**Nível:** Pleno  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
Como você aceleraria um pipeline usando paralelismo sem criar resultados inconsistentes?

**O que essa pergunta avalia:**  
Avalia otimização com compreensão de dependências e concorrência.

**Resposta esperada:**  
Mapearia dependências entre etapas, executaria em paralelo tarefas independentes, dividiria suítes de testes, usaria agentes adequados e preservaria sincronização para publicação e implantação. Também verificaria condições de corrida, recursos compartilhados e ordem de execução.

**Explicação didática:**  
Paralelismo reduz tempo de parede, mas pode expor testes que dependem de estado compartilhado ou gerar competição por recursos.

**Exemplo prático:**  
Dividir testes por grupos independentes, cada um com banco isolado, e aguardar todos antes de publicar o artefato.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve tratar velocidade e correção como objetivos simultâneos.

**Resposta fraca ou incompleta:**  
“Duplicaria agentes até o pipeline ficar rápido.”  
A infraestrutura pode virar gargalo e os testes podem interferir entre si.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como dividir uma suíte de testes?
2. Como descobrir o limite de paralelismo?
3. Que problemas aparecem ao compartilhar um banco de teste?

---

## Pergunta 49 — Testes de integração

**Nível:** Pleno  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Como decidir quais testes de integração devem bloquear uma entrega?

**O que essa pergunta avalia:**  
Avalia priorização baseada em risco e confiabilidade.

**Resposta esperada:**  
Devem bloquear testes que cobrem contratos e fluxos críticos, são determinísticos, relevantes para o risco do sistema e possuem tempo aceitável. Testes experimentais, lentos ou instáveis podem ter execução separada, mas não devem ser ignorados; precisam de plano de tratamento.

**Explicação didática:**  
Não é necessário colocar todos os testes no mesmo estágio. A política deve diferenciar feedback rápido de validações extensas.

**Exemplo prático:**  
Testes de autenticação e pagamento bloqueiam a release; testes de carga completos rodam em uma etapa agendada ou antes de mudanças específicas.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve falar sobre criticidade, confiabilidade, custo e política de exceção.

**Resposta fraca ou incompleta:**  
“Todos os testes devem bloquear tudo.”  
Isso pode tornar o processo lento e frágil sem análise de valor.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como tratar um teste crítico mas lento?
2. Como medir a confiabilidade dos testes?
3. Quem decide as exceções?

---

## Pergunta 50 — Testes de segurança no pipeline

**Nível:** Pleno  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como você integraria testes de segurança sem tornar o pipeline impraticável?

**O que essa pergunta avalia:**  
Avalia capacidade de aplicar segurança de forma progressiva e proporcional.

**Resposta esperada:**  
Executaria verificações rápidas em todo pull request, como secret scanning, SAST e dependências; usaria análise de imagem no build; executaria DAST, testes de penetração e análises profundas em estágios ou frequências adequadas. Definiria limiares baseados em severidade, explorabilidade e contexto.

**Explicação didática:**  
A segurança pode ser distribuída em camadas. Nem toda ferramenta precisa rodar com a mesma frequência ou bloquear toda alteração.

**Exemplo prático:**  
Uma vulnerabilidade crítica conhecida e explorável bloqueia a release; uma vulnerabilidade baixa pode gerar backlog controlado.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve equilibrar cobertura, velocidade, falsos positivos e capacidade de remediação.

**Resposta fraca ou incompleta:**  
“Executaria um scanner completo em todas as branches e bloquearia qualquer alerta.”  
Isso pode gerar lentidão e excesso de falsos positivos.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como lidar com falsos positivos?
2. Qual diferença entre SAST, DAST e SCA?
3. Como acompanhar exceções de segurança?

---

## Pergunta 51 — Supply chain

**Nível:** Pleno  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Quais riscos de supply chain existem em CI/CD e como reduzi-los?

**O que essa pergunta avalia:**  
Avalia compreensão da cadeia de dependências, ferramentas e artefatos.

**Resposta esperada:**  
Riscos incluem dependências comprometidas, imagens maliciosas, plugins vulneráveis, runners alterados, scripts de terceiros, artefatos adulterados e credenciais expostas. Mitigações incluem dependências fixadas, repositórios confiáveis, SBOM, assinatura, verificação de proveniência, isolamento de agentes e atualizações controladas.

**Explicação didática:**  
A aplicação depende de mais elementos do que seu próprio código. Cada elemento da cadeia pode ser um ponto de ataque.

**Exemplo prático:**  
O pipeline gera uma SBOM e assina o artefato; a implantação verifica a assinatura antes de aceitar a versão.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve ir além de “usar scanner” e considerar integridade, origem e execução.

**Resposta fraca ou incompleta:**  
“Usaria apenas dependências atualizadas.”  
Atualização não garante origem, integridade nem ausência de vulnerabilidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que uma SBOM deve representar?
2. Como verificar a origem de uma imagem?
3. Que isolamento você aplicaria aos runners?

---

## Pergunta 52 — Runners

**Nível:** Pleno  
**Categoria:** Infraestrutura

**Pergunta do entrevistador:**  
Compare runners hospedados pelo provedor e runners autogerenciados.

**O que essa pergunta avalia:**  
Avalia decisões de infraestrutura, segurança e custo.

**Resposta esperada:**  
Runners hospedados pelo provedor reduzem manutenção e oferecem ambientes padronizados, mas podem ter limitações de rede, custo ou customização. Runners autogerenciados permitem controle de rede, ferramentas e desempenho, mas exigem atualização, hardening, isolamento, monitoramento e resposta a incidentes.

**Explicação didática:**  
A decisão deve considerar requisitos de acesso, dados sensíveis, velocidade, custo e capacidade operacional.

**Exemplo prático:**  
Um build público pode usar runner hospedado; uma implantação em rede privada pode exigir runner controlado pela organização.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve comparar o ciclo de vida completo, não apenas preço por minuto.

**Resposta fraca ou incompleta:**  
“Runner próprio é sempre mais seguro.”  
O nível de segurança depende da configuração e manutenção.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como limpar o ambiente entre jobs?
2. Como atualizar runners sem interromper entregas?
3. Que informações monitoraria?

---

## Pergunta 53 — Runners efêmeros

**Nível:** Pleno  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Por que runners efêmeros podem ser mais seguros do que máquinas reutilizadas?

**O que essa pergunta avalia:**  
Avalia isolamento e redução de persistência de dados.

**Resposta esperada:**  
Um runner efêmero é criado para um job ou pequeno conjunto de jobs e destruído depois. Isso reduz persistência de credenciais, arquivos, processos e alterações deixadas por uma execução comprometida. O custo pode ser maior e o provisionamento deve ser eficiente.

**Explicação didática:**  
Em um runner reutilizado, um job pode acessar resíduos de outro ou deixar malware persistente. A destruição reduz esse risco, embora não substitua permissões mínimas.

**Exemplo prático:**  
Cada job inicia uma máquina ou contêiner limpo a partir de uma imagem controlada.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar isolamento, limpeza e custo operacional.

**Resposta fraca ou incompleta:**  
“Efêmero significa que não precisa de atualizações.”  
A imagem usada ainda precisa ser atualizada e protegida.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como impedir acesso a recursos de jobs anteriores?
2. Como reduzir o tempo de criação?
3. Quando runners persistentes ainda são aceitáveis?

---

## Pergunta 54 — DORA metrics

**Nível:** Pleno  
**Categoria:** Métricas

**Pergunta do entrevistador:**  
Quais métricas você usaria para avaliar a efetividade de um processo CI/CD?

**O que essa pergunta avalia:**  
Avalia capacidade de medir fluxo sem criar incentivos ruins.

**Resposta esperada:**  
Métricas úteis incluem frequência de implantação, tempo de lead para mudanças, taxa de falha de mudanças e tempo médio de recuperação. Também podem ser observados tempo de pipeline, taxa de retrabalho, falhas de testes, flakiness e disponibilidade.

**Explicação didática:**  
Métricas de entrega devem ser analisadas em conjunto. Aumentar frequência de deploy à custa de incidentes não representa melhoria real.

**Exemplo prático:**  
A equipe reduz o tempo de pipeline, mas verifica se a taxa de falha e o tempo de recuperação não pioraram.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar o significado das métricas e evitar usar números como metas isoladas.

**Resposta fraca ou incompleta:**  
“Mediria apenas quantos deploys foram feitos.”  
Volume não representa qualidade ou segurança.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como evitar que uma métrica seja manipulada?
2. Qual métrica indicaria dificuldade de recuperação?
3. Como separar problema de pipeline de problema de produto?

---

## Pergunta 55 — Observabilidade do pipeline

**Nível:** Pleno  
**Categoria:** Observabilidade

**Pergunta do entrevistador:**  
Como você tornaria um pipeline observável?

**O que essa pergunta avalia:**  
Avalia capacidade de monitorar a própria plataforma de entrega.

**Resposta esperada:**  
Mediria duração por etapa, taxa de sucesso, fila, uso de agentes, falhas por categoria, retries, tempo até recuperação, idade dos artefatos e frequência de deploy. Centralizaria logs, manteria correlação com commit e versão e criaria alertas para degradação.

**Explicação didática:**  
Um pipeline também é um sistema de produção. Sem observabilidade, a equipe percebe apenas que “está lento” ou “falhou”, sem saber por quê.

**Exemplo prático:**  
Um painel mostra que o tempo aumentou porque a etapa de dependências deixou de usar cache.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve falar em métricas, logs, rastreabilidade e alertas acionáveis.

**Resposta fraca ou incompleta:**  
“Eu armazenaria todos os logs por tempo indefinido.”  
Logs sem métricas, retenção e consulta adequada não são observabilidade suficiente.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que alerta indicaria uma degradação do CI?
2. Como correlacionar uma falha ao commit?
3. Qual retenção de logs adotaria?

---

## Pergunta 56 — Pipeline monolítico

**Nível:** Pleno  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
Quais problemas podem surgir em um pipeline monolítico de uma aplicação grande?

**O que essa pergunta avalia:**  
Avalia capacidade de identificar gargalos e propor decomposição.

**Resposta esperada:**  
Um pipeline monolítico pode ficar lento, difícil de manter, com falhas difíceis de localizar, permissões amplas e pouca independência entre componentes. Pode ser decomposto por serviço ou responsabilidade, mantendo validações compartilhadas e coordenação de artefatos.

**Explicação didática:**  
Decompor não significa criar dezenas de pipelines sem governança. É necessário equilibrar autonomia, consistência e custo operacional.

**Exemplo prático:**  
Serviços independentes possuem pipelines próprios, enquanto contratos e testes de integração executam em pontos de coordenação.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar custo da decomposição, dependências e padrões reutilizáveis.

**Resposta fraca ou incompleta:**  
“Criaria um pipeline para cada arquivo.”  
A unidade deve refletir componentes e responsabilidades, não granularidade arbitrária.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como compartilhar lógica entre pipelines?
2. Como coordenar uma release de vários serviços?
3. Quando manter um pipeline único?

---

## Pergunta 57 — Monorepo

**Nível:** Pleno  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
Como desenhar CI/CD para um monorepo com várias aplicações e bibliotecas?

**O que essa pergunta avalia:**  
Avalia seleção de escopo, dependências e eficiência.

**Resposta esperada:**  
Usaria detecção de arquivos alterados, grafo de dependências, pipelines parciais, cache, execução paralela e validações globais quando necessárias. Mudanças em bibliotecas compartilhadas devem acionar consumidores relevantes, enquanto alterações isoladas não precisam reconstruir tudo.

**Explicação didática:**  
O desafio é equilibrar velocidade com segurança. Ignorar dependências pode permitir que uma alteração quebre outro componente.

**Exemplo prático:**  
Uma mudança em uma biblioteca comum executa testes dessa biblioteca e dos serviços que a utilizam.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar grafo de dependências, escopo e risco de otimização incorreta.

**Resposta fraca ou incompleta:**  
“Executaria tudo em todos os commits.”  
É seguro, mas pode ser caro e lento sem necessidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como garantir que a detecção de impacto não perca dependências?
2. Que validações devem sempre ser globais?
3. Como controlar cache entre projetos?

---

## Pergunta 58 — Rollback versus roll-forward

**Nível:** Pleno  
**Categoria:** Operação

**Pergunta do entrevistador:**  
Quando você escolheria rollback e quando preferiria roll-forward?

**O que essa pergunta avalia:**  
Avalia decisão operacional durante incidentes.

**Resposta esperada:**  
Rollback é adequado quando a versão anterior é segura, compatível e pode restaurar rapidamente o serviço. Roll-forward pode ser preferível quando a reversão é arriscada, quando há migração irreversível, quando a correção é pequena ou quando a versão anterior também possui problema.

**Explicação didática:**  
A decisão depende do impacto, tempo de recuperação, compatibilidade de dados e confiança na correção.

**Exemplo prático:**  
Após adicionar uma coluna compatível, um defeito de aplicação pode ser revertido. Após remover dados de forma irreversível, pode ser necessário corrigir a versão atual.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve demonstrar decisão baseada em risco, não em preferência automática.

**Resposta fraca ou incompleta:**  
“Rollback sempre é mais seguro.”  
Nem sempre é possível ou seguro retornar a uma versão anterior.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que sinais determinam a escolha?
2. Como praticar rollback?
3. Como comunicar a decisão durante um incidente?

---

## Pergunta 59 — Rollback de banco

**Nível:** Pleno  
**Categoria:** Dados

**Pergunta do entrevistador:**  
Por que rollback de aplicação e rollback de banco de dados não são necessariamente equivalentes?

**O que essa pergunta avalia:**  
Avalia compreensão de persistência e compatibilidade.

**Resposta esperada:**  
A aplicação pode ser substituída, mas dados já transformados ou estruturas removidas podem não ser reversíveis. Por isso, migrações devem ser planejadas para compatibilidade, com backups, scripts de correção, expansão gradual e estratégia de recuperação.

**Explicação didática:**  
Código é geralmente substituível; dados possuem histórico e podem ter sido consumidos por usuários ou outros sistemas.

**Exemplo prático:**  
Uma migração que divide uma coluna pode exigir reconstrução dos dados antes de retornar à versão anterior.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve falar de compatibilidade, reversibilidade, backup e restauração testada.

**Resposta fraca ou incompleta:**  
“Basta executar o down migration.”  
Nem toda alteração é reversível de forma segura após uso em produção.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como testar restauração de backup?
2. Que migrações são perigosas?
3. Como lidar com dados escritos por duas versões?

---

## Pergunta 60 — Gates de qualidade

**Nível:** Pleno  
**Categoria:** Governança

**Pergunta do entrevistador:**  
Como definir gates de qualidade para permitir ou bloquear uma release?

**O que essa pergunta avalia:**  
Avalia criação de critérios objetivos e proporcionais ao risco.

**Resposta esperada:**  
Definiria critérios como compilação, testes críticos, ausência de segredos, vulnerabilidades acima de limiar, integridade do artefato, smoke tests e aprovação necessária. Os critérios devem ser mensuráveis, documentados, revisados e adequados ao tipo de mudança.

**Explicação didática:**  
Um gate transforma expectativas de qualidade em uma decisão automatizável ou auditável. Gates excessivos podem incentivar contornos; gates fracos permitem riscos.

**Exemplo prático:**  
Uma alteração de documentação pode ter validações menores que uma mudança em autenticação.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar critérios e exceções com rastreabilidade.

**Resposta fraca ou incompleta:**  
“Bloquearia se qualquer ferramenta retornar qualquer alerta.”  
Isso não considera severidade, contexto ou falsos positivos.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como tratar exceções aprovadas?
2. Quem deve definir os critérios?
3. Como impedir que os gates fiquem obsoletos?

---

## Pergunta 61 — Configuração por ambiente

**Nível:** Pleno  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
Como evitar que configurações específicas de produção sejam incorporadas ao artefato?

**O que essa pergunta avalia:**  
Avalia separação entre build e configuração.

**Resposta esperada:**  
O artefato deve ser construído de forma neutra e receber configuração no momento de execução ou implantação. Valores públicos podem ser parametrizados; segredos devem vir de um mecanismo seguro. A configuração deve ser versionada ou auditada conforme sua sensibilidade.

**Explicação didática:**  
Incluir configuração de produção no artefato dificulta promoção e aumenta risco de exposição.

**Exemplo prático:**  
A mesma imagem recebe endpoints e credenciais por injeção de configuração no ambiente.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve distinguir configuração pública, sensível e específica de ambiente.

**Resposta fraca ou incompleta:**  
“Geraria uma imagem diferente para cada ambiente.”  
Isso prejudica a promoção do mesmo artefato.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde armazenar configurações auditáveis?
2. Como validar que todas as variáveis necessárias existem?
3. Como impedir configuração inválida em produção?

---

## Pergunta 62 — Gestão de segredos

**Nível:** Pleno  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como você desenharia o ciclo de vida de um segredo usado no processo de entrega?

**O que essa pergunta avalia:**  
Avalia gestão completa de credenciais.

**Resposta esperada:**  
O segredo deve ser criado com escopo mínimo, armazenado em cofre, consumido somente pelo job necessário, mascarado, auditado, rotacionado e revogado quando não for mais necessário. A rotação deve ser testada para evitar interrupções.

**Explicação didática:**  
Proteger o armazenamento é apenas uma parte. É necessário controlar criação, uso, exposição, rotação e revogação.

**Exemplo prático:**  
Uma credencial de implantação é trocada automaticamente e a versão antiga permanece válida por curto período de transição.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve cobrir todo o ciclo de vida e o impacto operacional da rotação.

**Resposta fraca ou incompleta:**  
“Salvaria a senha no sistema de CI e nunca mais alteraria.”  
Isso aumenta risco e dificulta resposta a incidentes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como fazer rotação sem downtime?
2. Como detectar uso de credencial fora do esperado?
3. O que fazer após suspeita de vazamento?

---

## Pergunta 63 — Ambientes de produção

**Nível:** Pleno  
**Categoria:** Operação

**Pergunta do entrevistador:**  
Como você impediria que uma alteração de pull request fosse implantada acidentalmente em produção?

**O que essa pergunta avalia:**  
Avalia controles de autorização e separação de ambientes.

**Resposta esperada:**  
Separaria triggers de validação e deploy, protegeria branches, restringiria ambientes, exigiria identidade e aprovação adequadas, impediria que código não integrado acesse credenciais de produção e usaria políticas baseadas em origem e artefato.

**Explicação didática:**  
Executar código de uma branch não confiável com acesso a produção é um risco grave, especialmente em pipelines que processam contribuições externas.

**Exemplo prático:**  
Pull requests executam somente testes com permissões limitadas; o deploy de produção exige merge, artefato assinado e aprovação.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar trust boundary, permissões e condições de promoção.

**Resposta fraca ou incompleta:**  
“Basta confiar que os desenvolvedores não clicarão no botão errado.”  
Segurança deve depender de controles, não apenas de comportamento humano.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que risco existe em executar código de fork?
2. Como restringir secrets a ambientes?
3. Como auditar quem autorizou uma implantação?

---

## Pergunta 64 — Releases de bibliotecas

**Nível:** Pleno  
**Categoria:** Release management

**Pergunta do entrevistador:**  
Como automatizar a publicação de uma biblioteca sem liberar versões quebradas?

**O que essa pergunta avalia:**  
Avalia versionamento, compatibilidade e publicação segura.

**Resposta esperada:**  
Executaria testes, análise de compatibilidade, validação de pacote, geração de changelog, verificação de versão, publicação em registro controlado e, se possível, promoção de uma versão candidata. A versão deve seguir política clara e o pacote publicado deve ser imutável.

**Explicação didática:**  
Bibliotecas afetam consumidores externos. Uma alteração incompatível deve ser identificada e comunicada antes da publicação.

**Exemplo prático:**  
Uma mudança de API pública exige incremento de versão major e atualização da documentação.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar API pública, testes de consumidor e prevenção de sobrescrita.

**Resposta fraca ou incompleta:**  
“Publicaria toda vez que o build passasse.”  
Build verde não garante compatibilidade de API nem qualidade de distribuição.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como detectar breaking changes?
2. Como testar consumidores?
3. É correto sobrescrever uma versão publicada?

---

## Pergunta 65 — Mudanças urgentes

**Nível:** Pleno  
**Categoria:** Incidentes

**Pergunta do entrevistador:**  
Como tratar uma correção urgente sem abandonar os controles do CI/CD?

**O que essa pergunta avalia:**  
Avalia equilíbrio entre velocidade, segurança e governança.

**Resposta esperada:**  
Usaria um fluxo emergencial documentado, com escopo limitado, revisão rápida por outra pessoa, testes essenciais, implantação controlada, monitoramento e revisão posterior. Contornar controles permanentemente é inadequado.

**Explicação didática:**  
Incidentes exigem velocidade, mas remover toda a segurança pode ampliar o impacto. O processo de exceção deve ser preparado antes da emergência.

**Exemplo prático:**  
Uma correção de vulnerabilidade é implantada com testes direcionados, aprovação de plantão e canary.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mostrar capacidade de priorizar controles indispensáveis e registrar a exceção.

**Resposta fraca ou incompleta:**  
“Faria push direto na produção para ganhar tempo.”  
Isso elimina revisão, evidência e rastreabilidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quais controles nunca deveriam ser ignorados?
2. Como validar uma correção em pouco tempo?
3. O que deve ser analisado após o incidente?

---

## Pergunta 66 — Dependências externas indisponíveis

**Nível:** Pleno  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O que você faria se o pipeline falhasse porque um registro de dependências externo ficou indisponível?

**O que essa pergunta avalia:**  
Avalia resiliência e isolamento do processo de build.

**Resposta esperada:**  
Verificaria se a falha é externa, usaria cache ou proxy interno confiável, repetiria com política limitada, evitaria alterar versões sem análise e avaliaria se builds críticos podem operar com dependências previamente armazenadas. Também registraria o incidente e comunicaria o impacto.

**Explicação didática:**  
Dependência externa durante cada execução cria uma fonte de variabilidade e indisponibilidade. Um proxy ou repositório espelhado pode aumentar controle e resiliência.

**Exemplo prático:**  
A organização mantém um repositório interno de pacotes aprovados.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve separar mitigação imediata de solução estrutural.

**Resposta fraca ou incompleta:**  
“Trocaría a versão da dependência até funcionar.”  
Isso pode introduzir mudanças não relacionadas e dificultar rastreamento.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como distinguir indisponibilidade externa de problema de autenticação?
2. Que política de retry adotaria?
3. Como manter segurança em um proxy interno?

---

## Pergunta 67 — Falha de agente

**Nível:** Pleno  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como investigar falhas que ocorrem somente em um agente específico do CI?

**O que essa pergunta avalia:**  
Avalia diagnóstico de diferenças de ambiente.

**Resposta esperada:**  
Compararia imagem, sistema operacional, ferramentas, permissões, espaço em disco, rede, carga, cache e histórico do agente. Reexecutaria em um ambiente limpo e verificaria se o problema acompanha o job ou o agente. Se for autogerenciado, avaliaria substituição ou reconstrução.

**Explicação didática:**  
Uma falha localizada pode indicar estado residual, hardware, configuração divergente ou defeito específico do agente.

**Exemplo prático:**  
Um agente com cache corrompido falha em builds que passam em agentes novos.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve propor comparação controlada e não apenas excluir o agente sem evidência.

**Resposta fraca ou incompleta:**  
“Removeria o agente imediatamente.”  
Pode resolver o sintoma, mas não explica nem evita recorrência.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que evidências coletaria antes de reconstruir?
2. Como detectar drift em agentes?
3. Como impedir que um agente ruim receba novos jobs?

---

## Pergunta 68 — Lockfiles

**Nível:** Pleno  
**Categoria:** Reprodutibilidade

**Pergunta do entrevistador:**  
Qual é o papel de lockfiles na reprodutibilidade de builds?

**O que essa pergunta avalia:**  
Avalia gestão determinística de dependências.

**Resposta esperada:**  
Lockfiles registram versões exatas e, em algumas ferramentas, hashes das dependências resolvidas. Isso reduz variações entre máquinas e execuções. Devem ser atualizados deliberadamente e revisados, pois também podem incorporar vulnerabilidades ou mudanças transitivas.

**Explicação didática:**  
Declarar “versão 1.x” permite que diferentes builds recebam versões distintas. O lockfile registra a resolução concreta.

**Exemplo prático:**  
O pipeline falha se o lockfile não estiver consistente com o manifesto de dependências.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve explicar benefício e limitações, incluindo atualizações transitivas.

**Resposta fraca ou incompleta:**  
“Lockfile serve apenas para acelerar a instalação.”  
Seu principal valor é consistência, não velocidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando atualizar o lockfile?
2. Como verificar integridade das dependências?
3. O lockfile deve ser revisado em pull request?

---

## Pergunta 69 — Testes ponta a ponta

**Nível:** Pleno  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Como equilibrar testes ponta a ponta com testes unitários e de integração em CI/CD?

**O que essa pergunta avalia:**  
Avalia estratégia de testes e custo de feedback.

**Resposta esperada:**  
Testes unitários cobrem lógica isolada rapidamente; integração valida componentes reais; ponta a ponta cobre fluxos críticos do usuário. A pirâmide de testes recomenda mais testes rápidos e menos testes ponta a ponta, escolhidos pelo risco e valor.

**Explicação didática:**  
Testes ponta a ponta são valiosos, mas podem ser lentos, frágeis e difíceis de diagnosticar. Não devem ser a única forma de confiança.

**Exemplo prático:**  
Um checkout crítico tem alguns testes ponta a ponta, enquanto regras de cálculo possuem muitos testes unitários.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve discutir cobertura, custo, estabilidade e diagnóstico.

**Resposta fraca ou incompleta:**  
“Faria somente testes ponta a ponta porque simulam o usuário.”  
Isso gera feedback lento e difícil manutenção.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como diagnosticar uma falha ponta a ponta?
2. Que fluxos merecem esse tipo de teste?
3. Como reduzir sua flakiness?

---

## Pergunta 70 — Testes de performance

**Nível:** Pleno  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
Como incorporar testes de desempenho ao processo de entrega?

**O que essa pergunta avalia:**  
Avalia planejamento de performance e critérios de aceitação.

**Resposta esperada:**  
Definiria cenários representativos, carga, duração, métricas e limiares. Testes rápidos podem rodar em mudanças críticas; testes de carga e estresse podem rodar em ambiente controlado, periodicamente ou antes de releases relevantes. Resultados devem ser comparados com baseline.

**Explicação didática:**  
Performance depende de dados, infraestrutura e padrão de uso. Um teste sem cenário ou critério não produz decisão útil.

**Exemplo prático:**  
Uma API deve manter p95 abaixo de determinado valor sob carga definida.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar ambiente controlado, métricas percentis e comparação histórica.

**Resposta fraca ou incompleta:**  
“Mediria apenas o tempo médio de resposta.”  
A média pode esconder caudas de latência e experiências ruins.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Por que p95 ou p99 podem ser mais úteis que média?
2. Como evitar que o ambiente de teste invalide o resultado?
3. Que mudança deve bloquear uma release?

---

## Pergunta 71 — Testes de resiliência

**Nível:** Pleno  
**Categoria:** Confiabilidade

**Pergunta do entrevistador:**  
Em que momento testes de resiliência ou fault injection devem fazer parte do processo de entrega?

**O que essa pergunta avalia:**  
Avalia maturidade em confiabilidade e experimentação controlada.

**Resposta esperada:**  
Devem ser aplicados em ambientes seguros, com escopo controlado, hipóteses claras, observabilidade e critérios de interrupção. Podem verificar comportamento diante de indisponibilidade de dependências, latência, perda de rede ou reinício de instâncias.

**Explicação didática:**  
O objetivo é descobrir se o sistema se comporta conforme esperado em falhas, não causar indisponibilidade sem controle.

**Exemplo prático:**  
Em staging, interromper uma instância e verificar se o tráfego é redistribuído e se os alertas funcionam.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve falar sobre segurança do experimento e validação de hipóteses.

**Resposta fraca ou incompleta:**  
“Derrubaria serviços em produção para ver se continuam funcionando.”  
Sem controle, isso é imprudente.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quais critérios autorizam o experimento?
2. Como saber se a recuperação funcionou?
3. Como começar com baixo risco?

---

## Pergunta 72 — Releases progressivas

**Nível:** Pleno  
**Categoria:** Entrega

**Pergunta do entrevistador:**  
Como você definiria critérios para expandir gradualmente um canary?

**O que essa pergunta avalia:**  
Avalia decisão baseada em métricas e risco.

**Resposta esperada:**  
Definiria janelas de observação, métricas de erro, latência, saturação, conversão e impacto de negócio, além de limiares e ações automáticas de pausa ou rollback. O tráfego só aumenta se os critérios forem satisfeitos.

**Explicação didática:**  
O canary não é apenas “mandar pouco tráfego”; é um experimento com hipótese e critérios objetivos.

**Exemplo prático:**  
Expandir de 1% para 10% se a taxa de erro e p99 permanecerem dentro dos limites por determinado período.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve relacionar métricas técnicas e de negócio, além de falar em janela suficiente.

**Resposta fraca ou incompleta:**  
“Expandiria quando alguém verificasse rapidamente que está funcionando.”  
Inspeção superficial pode não detectar problemas raros ou progressivos.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como escolher o grupo inicial de usuários?
2. Que métrica pode indicar impacto funcional?
3. Como pausar automaticamente?

---

## Pergunta 73 — Aprovações e segregação

**Nível:** Pleno  
**Categoria:** Governança

**Pergunta do entrevistador:**  
Como aplicar segregação de funções sem tornar o processo burocrático demais?

**O que essa pergunta avalia:**  
Avalia governança proporcional e desenho de controles.

**Resposta esperada:**  
Separaria responsabilidades de desenvolvimento, aprovação e execução em ambientes de alto risco, usando políticas automatizadas, grupos responsáveis e aprovações baseadas em risco. Para mudanças de baixo risco, o fluxo pode ser mais automático.

**Explicação didática:**  
Segregação reduz o risco de uma única pessoa introduzir e liberar uma alteração sensível sem revisão. O controle deve ser proporcional e apoiado por automação.

**Exemplo prático:**  
Uma alteração em autenticação exige revisão de segurança; uma mudança de texto pode seguir fluxo simplificado.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve evitar extremos: nenhuma governança ou burocracia indiscriminada.

**Resposta fraca ou incompleta:**  
“Todas as mudanças devem exigir três aprovações.”  
Isso não considera risco nem impacto na velocidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como classificar risco de mudança?
2. Que aprovações podem ser automatizadas?
3. Como auditar exceções?

---

## Pergunta 74 — Reuso de pipelines

**Nível:** Pleno  
**Categoria:** Manutenibilidade

**Pergunta do entrevistador:**  
Como reutilizar etapas comuns entre vários pipelines sem criar uma abstração difícil de entender?

**O que essa pergunta avalia:**  
Avalia equilíbrio entre padronização e simplicidade.

**Resposta esperada:**  
Criaria templates ou componentes reutilizáveis para responsabilidades estáveis, com interfaces claras, versionamento, documentação e testes. Evitaria abstrair diferenças reais e manteria possibilidade de extensão. Mudanças incompatíveis deveriam ter nova versão.

**Explicação didática:**  
Reuso reduz duplicação, mas abstrações excessivamente genéricas escondem comportamento e dificultam diagnóstico.

**Exemplo prático:**  
Um template padrão executa análise, testes e publicação, permitindo parâmetros explícitos por aplicação.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve falar sobre contratos, versionamento e observabilidade.

**Resposta fraca ou incompleta:**  
“Colocaria tudo em um template universal com dezenas de parâmetros.”  
Isso pode criar uma interface complexa e difícil de manter.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como atualizar o template sem quebrar consumidores?
2. O que merece ser abstraído?
3. Como depurar uma falha dentro de um template compartilhado?

---

## Pergunta 75 — Versionamento de pipeline

**Nível:** Pleno  
**Categoria:** Governança

**Pergunta do entrevistador:**  
Como versionar templates e componentes reutilizáveis de CI/CD?

**O que essa pergunta avalia:**  
Avalia compatibilidade e evolução controlada da plataforma.

**Resposta esperada:**  
Usaria versões imutáveis, changelog e política de compatibilidade. Consumidores poderiam adotar versões de forma controlada, com testes e prazo de atualização. Alterações críticas não deveriam mudar silenciosamente o comportamento de todos.

**Explicação didática:**  
Uma mudança central pode afetar dezenas de equipes. Versionamento reduz impacto surpresa.

**Exemplo prático:**  
Publicar `template/v2` enquanto `v1` recebe apenas correções até a migração.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar compatibilidade, migração e comunicação.

**Resposta fraca ou incompleta:**  
“Todos sempre usam a branch principal do template.”  
Isso permite mudanças inesperadas e dificulta reproduzir execuções antigas.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como retirar uma versão antiga?
2. Como testar compatibilidade?
3. Como comunicar uma mudança incompatível?

---

## Pergunta 76 — Depuração de pipeline

**Nível:** Pleno  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como você estruturaria a investigação de um pipeline que ficou duas vezes mais lento?

**O que essa pergunta avalia:**  
Avalia análise baseada em dados e identificação de regressões.

**Resposta esperada:**  
Compararia histórico por etapa, commits de configuração, uso de cache, fila, tamanho de artefatos, disponibilidade de agentes, dependências externas e paralelismo. Mediria antes de alterar, identificaria o maior aumento e validaria a correção com uma execução controlada.

**Explicação didática:**  
O tempo total pode aumentar por espera, execução ou recursos. Cada causa exige tratamento diferente.

**Exemplo prático:**  
A etapa de instalação passou de 2 para 20 minutos após a invalidação involuntária do cache.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve propor comparação histórica e não apenas aumentar recursos.

**Resposta fraca ou incompleta:**  
“Daria mais CPU aos agentes.”  
Isso pode não resolver uma espera externa ou uma regressão de configuração.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como diferenciar fila de execução?
2. Que dados devem ser armazenados para comparação?
3. Como validar que a otimização não quebrou a confiabilidade?

---

## Pergunta 77 — Falhas intermitentes de rede

**Nível:** Pleno  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como tratar uma etapa que falha ocasionalmente ao acessar um serviço externo?

**O que essa pergunta avalia:**  
Avalia resiliência, retries e diagnóstico.

**Resposta esperada:**  
Analisaria taxa e padrão das falhas, códigos retornados, timeout, DNS, limites e dependência externa. Aplicaria timeout explícito, retry com backoff e jitter apenas para erros transitórios e operações seguras, além de cache ou proxy quando apropriado. Não usaria retry para mascarar falhas permanentes.

**Explicação didática:**  
Repetir uma operação pode ajudar em indisponibilidade temporária, mas pode piorar sobrecarga ou duplicar efeitos.

**Exemplo prático:**  
Uma consulta idempotente pode usar poucos retries com backoff; uma operação de publicação precisa de confirmação e deduplicação.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar limites, idempotência, observabilidade e causa raiz.

**Resposta fraca ou incompleta:**  
“Colocaria um loop infinito até funcionar.”  
Isso prende agentes e pode aumentar a indisponibilidade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quando retry é perigoso?
2. O que é jitter?
3. Como confirmar que uma publicação não ocorreu parcialmente?

---

## Pergunta 78 — Artefatos de teste

**Nível:** Pleno  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Que artefatos você preservaria quando um teste falha no CI?

**O que essa pergunta avalia:**  
Avalia capacidade de facilitar diagnóstico.

**Resposta esperada:**  
Preservaria logs completos, relatórios de teste, screenshots ou vídeos quando aplicável, dumps, traces, arquivos de configuração não sensíveis, resultados de cobertura e informações de ambiente. A retenção deve equilibrar custo e privacidade.

**Explicação didática:**  
Sem evidências, uma falha que desaparece na reexecução pode ser impossível de investigar.

**Exemplo prático:**  
Um teste de navegador salva screenshot e console do navegador apenas quando falha.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve incluir segurança e retenção, não apenas “guardar tudo”.

**Resposta fraca ou incompleta:**  
“Salvaria o diretório inteiro do agente.”  
Isso pode conter segredos, arquivos irrelevantes e custos excessivos.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como evitar segredos nos artefatos?
2. Qual política de retenção adotaria?
3. Como correlacionar artefatos à execução?

---

## Pergunta 79 — Quality gate de vulnerabilidades

**Nível:** Pleno  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Uma ferramenta encontra uma vulnerabilidade crítica em uma dependência, mas a aplicação não utiliza o componente vulnerável. O pipeline deve bloquear?

**O que essa pergunta avalia:**  
Avalia análise contextual de risco.

**Resposta esperada:**  
A decisão deve considerar explorabilidade, caminho de execução, exposição, possibilidade de exploração indireta, existência de correção e política organizacional. Pode ser necessário bloquear inicialmente, registrar uma exceção formal ou atualizar a dependência; ignorar silenciosamente não é adequado.

**Explicação didática:**  
Severidade do scanner é um sinal, não uma decisão completa. O contexto técnico pode reduzir ou confirmar o risco, mas precisa ser documentado.

**Exemplo prático:**  
Uma dependência transitiva vulnerável pode ser removida, atualizada ou isolada, enquanto uma exceção temporária é acompanhada.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve evitar tanto bloqueio cego quanto aceitação informal.

**Resposta fraca ou incompleta:**  
“Não bloquearia porque não usamos.”  
Sem confirmar o caminho de execução, essa conclusão é insegura.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como provar que o código vulnerável não é alcançável?
2. Quem aprova uma exceção?
3. Quando a exceção deve expirar?

---

# Roteiro de entrevista técnica — CI/CD

## Pergunta 80 — Assinatura e atestação de artefatos

**Nível:** Pleno  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como assinatura e atestação de artefatos podem aumentar a segurança de uma implantação?

**O que essa pergunta avalia:**  
Avalia conhecimentos de integridade, autenticidade, proveniência e segurança da cadeia de fornecimento de software.

**Resposta esperada:**  
A assinatura permite verificar que o artefato foi produzido por uma identidade confiável e não foi alterado depois de publicado. A atestação registra informações sobre a origem do artefato, como commit, processo de build, dependências, verificações executadas e identidade do pipeline.

A implantação pode aceitar somente artefatos que:

- tenham assinatura válida;
- tenham sido produzidos por um pipeline autorizado;
- estejam relacionados a um commit confiável;
- tenham passado pelos controles obrigatórios;
- não tenham sido alterados após a assinatura.

**Explicação didática:**  
Assinatura não é o mesmo que criptografia. A criptografia protege o conteúdo contra leitura; a assinatura ajuda a verificar autenticidade e integridade.

A atestação responde perguntas como:

- Qual código originou o artefato?
- Qual pipeline o produziu?
- Quais testes foram executados?
- Quais dependências foram utilizadas?
- O artefato foi aprovado para produção?

**Exemplo prático:**  
Um cluster de produção aceita somente imagens de contêiner assinadas pelo pipeline oficial e associadas a uma versão proveniente da branch principal.

**Exemplo de código:**  
Não é necessário código para esta pergunta.

**Como o candidato deve responder:**  
Deve diferenciar assinatura, criptografia e atestação. Também deve mencionar proteção das chaves, rotação, verificação antes da implantação e rastreabilidade do artefato.

**Resposta fraca ou incompleta:**  
“Assinar deixa o arquivo criptografado e mais difícil de baixar.”

Essa resposta confunde assinatura com criptografia e não aborda origem, integridade ou verificação.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Onde as chaves de assinatura deveriam ser protegidas?
2. Como impedir a implantação de um artefato adulterado?
3. Que informações uma atestação deveria conter?

---

## Pergunta 81 — Validação do rollback

**Nível:** Pleno  
**Categoria:** Confiabilidade

**Pergunta do entrevistador:**  
Como você validaria que um plano de rollback realmente funciona?

**O que essa pergunta avalia:**  
Avalia preparação operacional, testes de recuperação e capacidade de reduzir o tempo de indisponibilidade.

**Resposta esperada:**  
O rollback deve ser testado em ambiente controlado, utilizando artefatos e configurações semelhantes aos de produção. A validação deve verificar:

- disponibilidade das versões anteriores;
- compatibilidade com dados existentes;
- restauração da configuração;
- funcionamento dos health checks;
- tempo necessário para recuperação;
- comportamento das integrações;
- comunicação e responsabilidades da equipe.

O procedimento deve ser documentado, automatizado quando possível e praticado periodicamente.

**Explicação didática:**  
Manter a versão anterior armazenada não significa que o rollback está funcionando. A versão pode não ser compatível com o banco, com configurações novas ou com serviços dependentes.

**Exemplo prático:**  
A equipe implanta uma nova versão em homologação, simula aumento de erros, executa o rollback e confirma se o serviço retorna ao estado esperado dentro do objetivo de recuperação.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve mencionar testes periódicos, dependências, dados, tempo de recuperação, critérios de sucesso e comunicação durante o procedimento.

**Resposta fraca ou incompleta:**  
“Basta manter a versão anterior disponível para reimplantação.”

Isso não comprova que a reversão funcionará em uma situação real.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que dependências externas podem impedir o rollback?
2. Como medir o tempo de recuperação?
3. Como atualizar o plano depois de um incidente?

---

## Pergunta 82 — Implantação em múltiplas regiões

**Nível:** Pleno  
**Categoria:** Alta disponibilidade

**Pergunta do entrevistador:**  
Como você estruturaria uma implantação em múltiplas regiões geográficas?

**O que essa pergunta avalia:**  
Avalia coordenação de releases, alta disponibilidade, controle de risco e consistência operacional.

**Resposta esperada:**  
A implantação deveria ocorrer progressivamente, começando por uma região ou por um grupo de menor tráfego. Após validar métricas de erro, latência, saturação e comportamento funcional, a versão poderia ser promovida para as demais regiões.

O processo deve considerar:

- diferenças de configuração;
- disponibilidade de dependências;
- sincronização de dados;
- capacidade de interromper a promoção;
- rollback por região;
- roteamento de tráfego;
- observabilidade regional.

**Explicação didática:**  
Implantar simultaneamente em todas as regiões reduz o tempo total, mas aumenta o raio de impacto de uma falha. A implantação progressiva transforma cada região em uma etapa de validação.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[Artefato aprovado] --> B[Região de menor tráfego]
    B --> C{Métricas dentro do limite?}
    C -- Não --> D[Pausar e reverter]
    C -- Sim --> E[Segunda região]
    E --> F[Demais regiões]
~~~

**Como o candidato deve responder:**  
Deve falar sobre ordem de promoção, critérios objetivos, diferenças regionais, consistência de dados e possibilidade de reverter apenas uma região.

**Resposta fraca ou incompleta:**  
“Executaria o mesmo job em paralelo para todas as regiões.”

Essa estratégia pode ser rápida, mas amplia o impacto de uma falha sistêmica.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como lidar com configurações diferentes entre regiões?
2. Quais métricas determinariam a promoção?
3. Como reverter somente uma região?

---

## Pergunta 83 — Dependências entre serviços

**Nível:** Pleno  
**Categoria:** Integração

**Pergunta do entrevistador:**  
Como coordenar a entrega de serviços que possuem dependências entre si?

**O que essa pergunta avalia:**  
Avalia conhecimento de compatibilidade entre versões, contratos de API e autonomia de serviços.

**Resposta esperada:**  
Os serviços devem utilizar contratos claros, versionamento de APIs e mudanças retrocompatíveis sempre que possível. Durante uma transição, o consumidor deve conseguir trabalhar com a versão antiga e a nova do produtor.

Uma estratégia comum é:

1. adicionar o novo comportamento sem remover o antigo;
2. atualizar os consumidores;
3. validar a adoção da nova versão;
4. remover o comportamento antigo somente quando não houver consumidores dependentes.

**Explicação didática:**  
Em sistemas distribuídos, versões diferentes podem coexistir por algum tempo. Exigir que todos os serviços sejam implantados simultaneamente cria forte acoplamento e aumenta o risco de indisponibilidade.

**Exemplo prático:**  
Uma API começa a retornar um novo campo sem remover os campos antigos. Os consumidores migram gradualmente e, depois, o formato antigo é descontinuado.

**Como o candidato deve responder:**  
Deve mencionar compatibilidade temporária, contratos, testes de integração, versionamento e plano de remoção.

**Resposta fraca ou incompleta:**  
“Pararia todos os serviços e publicaria tudo ao mesmo tempo.”

Essa solução aumenta o acoplamento operacional e dificulta o rollback.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como detectar incompatibilidades antes da produção?
2. Quando uma release coordenada é justificável?
3. Como remover uma versão antiga da API?

---

## Pergunta 84 — Migração de ferramenta de CI/CD

**Nível:** Pleno  
**Categoria:** Migração

**Pergunta do entrevistador:**  
Como você migraria uma organização de uma ferramenta de CI/CD para outra?

**O que essa pergunta avalia:**  
Avalia planejamento, gestão de risco, continuidade operacional e capacidade de preservar controles existentes.

**Resposta esperada:**  
Primeiro seria necessário inventariar:

- pipelines existentes;
- integrações;
- secrets;
- permissões;
- agentes;
- artefatos;
- ambientes;
- gatilhos;
- aprovações;
- dependências externas;
- requisitos de auditoria.

Depois, eu escolheria projetos-piloto, implementaria os pipelines na nova plataforma, executaria os dois processos em paralelo, compararia resultados e migraria gradualmente os demais projetos.

**Explicação didática:**  
Migrar CI/CD não é apenas converter arquivos de configuração. O comportamento operacional, as permissões, os artefatos, os históricos e as integrações também precisam ser preservados.

**Exemplo prático:**  
Projetos simples podem ser migrados primeiro. Sistemas críticos permanecem temporariamente na solução antiga até que a nova plataforma seja validada.

**Como o candidato deve responder:**  
Deve mencionar inventário, pilotos, execução paralela, critérios de equivalência, plano de retorno e comunicação com as equipes.

**Resposta fraca ou incompleta:**  
“Converteria todos os arquivos automaticamente e desligaria a ferramenta antiga.”

Essa abordagem ignora diferenças de comportamento, integrações e riscos de interrupção.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como validaria que as duas plataformas produzem resultados equivalentes?
2. Como migraria secrets com segurança?
3. Qual seria o critério para desativar a ferramenta antiga?

---

# Parte 3 — Nível Sênior

## Pergunta 85 — Arquitetura de uma plataforma CI/CD

**Nível:** Sênior  
**Categoria:** Arquitetura

**Pergunta do entrevistador:**  
Como você projetaria uma plataforma corporativa de CI/CD para centenas de equipes e milhares de serviços?

**O que essa pergunta avalia:**  
Avalia visão sistêmica, arquitetura de plataforma, governança, escalabilidade e experiência de liderança técnica.

**Resposta esperada:**  
A plataforma deveria oferecer componentes padronizados, mas permitir autonomia às equipes. Eu separaria:

- execução de builds;
- armazenamento de artefatos;
- gestão de secrets;
- provisionamento de ambientes;
- observabilidade;
- políticas de segurança;
- catálogo de templates;
- aprovação e governança.

Também definiria níveis de serviço, limites de consumo, isolamento entre equipes, runners escaláveis, templates versionados, suporte a diferentes linguagens e mecanismos de extensão.

O princípio central seria oferecer “paved roads”: caminhos recomendados, simples e seguros, sem impedir casos legítimos de customização.

**Explicação didática:**  
Uma plataforma centralizada demais vira gargalo. Uma plataforma sem padrões cria duplicação, riscos e dificuldade de suporte. O desafio é equilibrar autonomia, consistência e governança.

**Exemplo prático:**  
A organização fornece um template padrão para testes, análise de segurança, criação de artefatos e implantação, permitindo que cada equipe configure parâmetros específicos.

**Como o candidato deve responder:**  
Deve discutir arquitetura, experiência do desenvolvedor, segurança, custos, escalabilidade, governança e modelo operacional. É importante mencionar que a plataforma deve ser tratada como produto interno.

**Resposta fraca ou incompleta:**  
“Criaria um único pipeline padrão obrigatório para todos os projetos.”

Isso ignora diferenças de tecnologia, criticidade, arquitetura e requisitos de negócio.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como evitar que a equipe de plataforma se torne um gargalo?
2. Como versionar mudanças nos templates?
3. Como medir a adoção e a qualidade da plataforma?

---

## Pergunta 86 — Modelo de governança

**Nível:** Sênior  
**Categoria:** Governança

**Pergunta do entrevistador:**  
Como você definiria uma governança de CI/CD que preserve velocidade sem comprometer segurança e conformidade?

**O que essa pergunta avalia:**  
Avalia capacidade estratégica de estabelecer políticas proporcionais ao risco.

**Resposta esperada:**  
A governança deveria ser baseada em risco. Mudanças simples poderiam seguir fluxo automático, enquanto mudanças em autenticação, dados sensíveis ou sistemas críticos exigiriam controles adicionais.

Eu definiria:

- políticas mínimas obrigatórias;
- critérios de aprovação;
- segregação de funções para ambientes críticos;
- rastreabilidade;
- gestão de exceções;
- auditoria;
- retenção de evidências;
- revisão periódica das regras.

Sempre que possível, os controles seriam automatizados para evitar decisões manuais repetitivas.

**Explicação didática:**  
Governança não deve ser sinônimo de burocracia. Seu objetivo é tornar riscos visíveis e garantir que decisões importantes sejam controladas e auditáveis.

**Como o candidato deve responder:**  
Deve apresentar uma abordagem proporcional, com automação, exceções temporárias e evidências objetivas.

**Resposta fraca ou incompleta:**  
“Exigiria aprovação manual de todas as mudanças.”

Isso reduz a velocidade, cria gargalos e não necessariamente melhora a qualidade das decisões.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como classificaria o risco de uma mudança?
2. Que controles nunca deveriam ser ignorados?
3. Como evitar que exceções permanentes se tornem uma brecha?

---

## Pergunta 87 — Supply chain em larga escala

**Nível:** Sênior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como protegeria a cadeia de fornecimento de software de uma organização que possui muitos times e dependências?

**O que essa pergunta avalia:**  
Avalia segurança de supply chain, governança técnica e capacidade de lidar com riscos sistêmicos.

**Resposta esperada:**  
Eu implementaria controles em camadas:

- inventário de dependências;
- SBOM;
- verificação de origem;
- repositórios internos ou proxies confiáveis;
- assinatura de artefatos;
- atestação de builds;
- scanners de dependências e imagens;
- runners isolados;
- controle de plugins;
- proteção de branches;
- credenciais temporárias;
- políticas de proveniência;
- resposta a vulnerabilidades.

Também definiria critérios para bloquear, aceitar temporariamente ou mitigar riscos.

**Explicação didática:**  
A cadeia inclui código próprio, bibliotecas, imagens, ferramentas, agentes, plugins e serviços externos. Um ataque em qualquer desses elementos pode afetar várias aplicações.

**Exemplo prático:**  
A produção aceita somente artefatos com SBOM, assinatura válida e atestação produzida por uma pipeline autorizada.

**Como o candidato deve responder:**  
Deve ir além de “instalar scanners”. Precisa abordar origem, integridade, identidade, isolamento, vulnerabilidades e resposta operacional.

**Resposta fraca ou incompleta:**  
“Manteria todas as bibliotecas atualizadas.”

Atualização é importante, mas não garante integridade, origem ou segurança do processo de build.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como bloquear uma dependência maliciosa antes que ela seja utilizada?
2. Como manter exceções de segurança sob controle?
3. Como responder a um comprometimento do sistema de build?

---

## Pergunta 88 — Comprometimento do pipeline

**Nível:** Sênior  
**Categoria:** Segurança e incidentes

**Pergunta do entrevistador:**  
O que você faria se suspeitasse que o pipeline de CI/CD foi comprometido?

**O que essa pergunta avalia:**  
Avalia resposta a incidentes, priorização, contenção e liderança sob pressão.

**Resposta esperada:**  
Eu trataria o caso como um incidente de segurança. As primeiras ações seriam:

1. interromper implantações potencialmente perigosas;
2. preservar logs e evidências;
3. revogar ou suspender credenciais;
4. isolar runners comprometidos;
5. verificar alterações nos pipelines;
6. identificar artefatos produzidos durante o período suspeito;
7. verificar implantações realizadas;
8. comunicar segurança, operações e responsáveis pelo negócio;
9. reconstruir ambientes confiáveis;
10. rotacionar credenciais e validar a cadeia de confiança.

Depois da contenção, seria necessário determinar o impacto, corrigir a causa e realizar uma análise pós-incidente.

**Explicação didática:**  
O pipeline possui acesso privilegiado a código, artefatos e ambientes. Um comprometimento pode permitir alterar software antes que ele chegue aos usuários.

**Como o candidato deve responder:**  
Deve priorizar contenção e preservação de evidências. Também deve diferenciar resposta imediata, investigação e recuperação.

**Resposta fraca ou incompleta:**  
“Executaria novamente o pipeline para verificar se o problema desapareceu.”

Isso pode destruir evidências e permitir que o atacante continue atuando.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que credenciais seriam revogadas primeiro?
2. Como determinar quais artefatos estão comprometidos?
3. Como preservar evidências sem interromper toda a operação?

---

## Pergunta 89 — Alta disponibilidade do CI/CD

**Nível:** Sênior  
**Categoria:** Alta disponibilidade

**Pergunta do entrevistador:**  
Como garantiria alta disponibilidade para uma plataforma de CI/CD usada por sistemas críticos?

**O que essa pergunta avalia:**  
Avalia arquitetura resiliente, continuidade operacional e análise de dependências.

**Resposta esperada:**  
Eu identificaria componentes críticos e seus objetivos de disponibilidade. A arquitetura poderia incluir:

- múltiplos agentes;
- filas distribuídas;
- armazenamento redundante;
- repositórios de artefatos replicados;
- backups testados;
- plano de recuperação;
- monitoramento da plataforma;
- capacidade de operar em regiões distintas;
- procedimentos para implantação emergencial;
- redução de dependências únicas.

Também separaria a disponibilidade do CI da disponibilidade da aplicação. Uma falha no sistema de CI não deveria necessariamente impedir uma recuperação emergencial já preparada.

**Explicação didática:**  
Alta disponibilidade não significa eliminar qualquer falha. Significa reduzir a probabilidade de indisponibilidade e ter mecanismos para recuperar o serviço rapidamente.

**Como o candidato deve responder:**  
Deve abordar redundância, recuperação, dependências, RTO, RPO, testes de desastre e operação degradada.

**Resposta fraca ou incompleta:**  
“Bastaria colocar dois servidores atrás de um balanceador.”

Isso não cobre armazenamento, artefatos, filas, identidade, dados e recuperação.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. O que aconteceria se o repositório de artefatos ficasse indisponível?
2. Como testaria o plano de recuperação?
3. Como permitir uma implantação emergencial durante uma falha do CI?

---

## Pergunta 90 — Estratégia de disaster recovery

**Nível:** Sênior  
**Categoria:** Continuidade de negócio

**Pergunta do entrevistador:**  
Como desenharia um plano de disaster recovery para a plataforma de entrega?

**O que essa pergunta avalia:**  
Avalia capacidade de planejar recuperação de uma plataforma essencial.

**Resposta esperada:**  
O plano deveria definir:

- serviços críticos;
- dependências;
- RTO e RPO;
- backups;
- local de recuperação;
- ordem de restauração;
- responsáveis;
- credenciais de emergência;
- validações;
- comunicação;
- critérios de retorno à operação normal.

Os backups deveriam ser protegidos, testados e independentes do ambiente principal. O plano também deveria ser exercitado periodicamente.

**Explicação didática:**  
Um backup que nunca foi restaurado não é uma garantia real. O disaster recovery precisa ser validado com simulações.

**Como o candidato deve responder:**  
Deve tratar pessoas, processos, tecnologia, dependências e testes. Também é importante mencionar que a recuperação da aplicação pode depender da recuperação do CI, dos artefatos e da infraestrutura.

**Resposta fraca ou incompleta:**  
“Manteria um backup semanal do servidor.”

Isso pode não atender ao RPO e não comprova que a restauração é possível.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como escolheria o RTO e o RPO?
2. Como protegeria os backups contra ransomware?
3. Como comprovaria que o plano funciona?

---

## Pergunta 91 — Migração de arquitetura

**Nível:** Sênior  
**Categoria:** Migração

**Pergunta do entrevistador:**  
Como conduziria a migração de um processo manual de entregas para CI/CD sem interromper o negócio?

**O que essa pergunta avalia:**  
Avalia estratégia de transformação, gestão de mudança e redução progressiva de riscos.

**Resposta esperada:**  
Eu começaria documentando o processo atual, identificando pontos críticos, dependências, controles e riscos. Depois:

1. automatizaria validações de baixo risco;
2. criaria pipelines para ambientes não produtivos;
3. padronizaria artefatos;
4. automatizaria deploys reversíveis;
5. implantaria observabilidade;
6. executaria fluxos piloto;
7. compararia resultados;
8. ampliaria gradualmente a automação;
9. manteria um processo emergencial controlado.

A mudança deveria incluir treinamento, documentação, métricas e apoio às equipes.

**Explicação didática:**  
Automatizar um processo mal compreendido pode apenas transformar erros manuais em erros automáticos. Primeiro é necessário entender e simplificar o fluxo.

**Como o candidato deve responder:**  
Deve falar sobre evolução incremental, segurança, treinamento, métricas e coexistência temporária entre processos.

**Resposta fraca ou incompleta:**  
“Criaria um pipeline completo e obrigaria todos os times a adotá-lo imediatamente.”

Essa abordagem pode gerar resistência e ampliar o risco operacional.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como escolheria os primeiros projetos-piloto?
2. Que processo manual deveria permanecer como contingência?
3. Como demonstraria o retorno do investimento?

---

## Pergunta 92 — Custo e eficiência

**Nível:** Sênior  
**Categoria:** FinOps e desempenho

**Pergunta do entrevistador:**  
Como reduziria os custos de uma plataforma CI/CD sem comprometer a confiabilidade?

**O que essa pergunta avalia:**  
Avalia otimização de custos, capacidade e impacto operacional.

**Resposta esperada:**  
Eu analisaria custo por pipeline, tempo de execução, uso de agentes, armazenamento, artefatos, caches e filas. Possíveis medidas incluem:

- paralelismo adequado;
- cache controlado;
- agentes sob demanda;
- runners efêmeros;
- dimensionamento automático;
- retenção adequada de artefatos;
- redução de builds redundantes;
- execução seletiva em monorepos;
- reutilização de dependências;
- separação entre testes rápidos e extensos.

A redução não deveria eliminar validações essenciais nem gerar maior custo com incidentes.

**Explicação didática:**  
Um pipeline barato, mas lento e instável, pode custar mais à organização por reduzir a produtividade e aumentar falhas.

**Como o candidato deve responder:**  
Deve equilibrar custo, velocidade, qualidade, segurança e experiência do desenvolvedor. Métricas devem orientar as decisões.

**Resposta fraca ou incompleta:**  
“Reduziria o número de agentes e removeria os testes demorados.”

Isso pode gerar filas, feedback insuficiente e aumento de risco.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como calcularia o custo real de uma execução?
2. Quando o paralelismo pode aumentar o custo sem melhorar o resultado?
3. Como evitar otimizações que prejudiquem a qualidade?

---

## Pergunta 93 — Métricas executivas e técnicas

**Nível:** Sênior  
**Categoria:** Métricas

**Pergunta do entrevistador:**  
Como apresentaria a evolução de CI/CD para uma diretoria sem reduzir a análise a uma única métrica?

**O que essa pergunta avalia:**  
Avalia comunicação executiva, visão de negócio e interpretação de indicadores.

**Resposta esperada:**  
Eu apresentaria um conjunto equilibrado de métricas, incluindo:

- frequência de implantação;
- lead time;
- taxa de falha de mudanças;
- tempo de recuperação;
- disponibilidade;
- duração e confiabilidade dos pipelines;
- vulnerabilidades encontradas;
- tempo de remediação;
- custo por entrega;
- satisfação das equipes.

As métricas deveriam ser apresentadas com contexto, tendência, impacto no negócio e ações de melhoria.

**Explicação didática:**  
Aumentar o número de deploys não representa sucesso se os incidentes também aumentarem. Métricas precisam ser analisadas como um sistema.

**Como o candidato deve responder:**  
Deve traduzir indicadores técnicos para impactos como velocidade, risco, custo, disponibilidade e capacidade de resposta.

**Resposta fraca ou incompleta:**  
“Mostraria apenas que o número de deploys aumentou.”

Isso pode esconder degradação de qualidade e aumento de incidentes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como evitar que as equipes manipulem as métricas?
2. Como relacionar uma melhoria no pipeline a resultados de negócio?
3. Que métrica indicaria aumento de risco?

---

## Pergunta 94 — Feature flags em escala

**Nível:** Sênior  
**Categoria:** Arquitetura de entrega

**Pergunta do entrevistador:**  
Como governar feature flags em uma organização grande?

**O que essa pergunta avalia:**  
Avalia controle de complexidade, segurança, consistência e evolução de funcionalidades.

**Resposta esperada:**  
As flags deveriam possuir:

- proprietário;
- finalidade;
- ambiente de aplicação;
- data de criação;
- prazo de expiração;
- estratégia de ativação;
- regras de autorização;
- auditoria;
- plano de remoção.

Também seria necessário limitar o número de flags ativas, testar combinações relevantes, evitar flags de segurança mal protegidas e acompanhar o impacto da ativação.

**Explicação didática:**  
Feature flags reduzem o risco de implantação, mas podem criar uma segunda camada de complexidade. Muitas flags antigas geram combinações difíceis de testar e compreender.

**Como o candidato deve responder:**  
Deve explicar benefícios, riscos, ciclo de vida, auditoria, testes e remoção.

**Resposta fraca ou incompleta:**  
“Criaria flags para todas as funcionalidades e deixaria a equipe decidir quando remover.”

Sem governança, as flags se tornam dívida técnica e risco operacional.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como testar combinações de flags?
2. Como impedir que uma flag seja alterada sem autorização?
3. Como identificar flags que podem ser removidas?

---

## Pergunta 95 — Migração de banco em larga escala

**Nível:** Sênior  
**Categoria:** Dados e arquitetura

**Pergunta do entrevistador:**  
Como conduziria uma migração de banco de dados de grande volume sem interromper o serviço?

**O que essa pergunta avalia:**  
Avalia planejamento de migração, consistência, compatibilidade e gestão de risco.

**Resposta esperada:**  
Eu utilizaria uma estratégia expand-and-contract, realizando alterações compatíveis e graduais. Dependendo do caso, poderia incluir:

- criação de novas estruturas;
- replicação ou backfill em lotes;
- validação de consistência;
- escrita dupla temporária;
- leitura gradual da nova estrutura;
- comparação de resultados;
- mudança progressiva do tráfego;
- remoção posterior da estrutura antiga.

A migração deveria ter métricas, limites de velocidade, possibilidade de pausa, backups e plano de recuperação.

**Explicação didática:**  
Alterações destrutivas em grandes volumes podem bloquear tabelas, consumir recursos ou impossibilitar o retorno à versão anterior.

**Como o candidato deve responder:**  
Deve discutir compatibilidade entre versões, impacto de carga, consistência, rollback, validação e observabilidade.

**Resposta fraca ou incompleta:**  
“Executaria uma migração durante a madrugada.”

Uma janela de manutenção pode não ser suficiente e não resolve problemas de volume, falha ou reversão.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como validaria a consistência após o backfill?
2. Como interromperia uma migração que está sobrecarregando o banco?
3. Como faria rollback de uma alteração parcialmente concluída?

---

## Pergunta 96 — Observabilidade orientada a SLOs

**Nível:** Sênior  
**Categoria:** Observabilidade

**Pergunta do entrevistador:**  
Como relacionar CI/CD, observabilidade e SLOs para decidir se uma release deve continuar?

**O que essa pergunta avalia:**  
Avalia capacidade de utilizar indicadores de confiabilidade para controlar promoções.

**Resposta esperada:**  
O pipeline deveria acompanhar indicadores como taxa de erro, latência, disponibilidade, saturação e impacto funcional. A promoção poderia ser interrompida quando a nova versão violasse limites definidos ou consumisse excessivamente o error budget.

Os critérios deveriam incluir:

- janela de observação;
- grupo de usuários afetados;
- comparação com baseline;
- limites de promoção;
- ações automáticas;
- capacidade de rollback;
- validação de métricas técnicas e de negócio.

**Explicação didática:**  
SLO é um objetivo de nível de serviço. Error budget representa a margem de falha aceitável. Se uma equipe consome essa margem rapidamente, novas mudanças podem precisar ser reduzidas até que a confiabilidade seja recuperada.

**Como o candidato deve responder:**  
Deve evitar monitorar somente “pipeline verde”. A aplicação pode passar nos testes e ainda apresentar problemas em produção.

**Resposta fraca ou incompleta:**  
“Se os testes passarem, a release deve continuar automaticamente.”

Testes não capturam todos os problemas de capacidade, comportamento ou impacto real.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que métricas usaria para um canary?
2. Como evitar decisões baseadas em dados insuficientes?
3. Quando bloquearia novas implantações por causa do error budget?

---

## Pergunta 97 — Incidente crítico durante implantação

**Nível:** Sênior  
**Categoria:** Incidentes

**Pergunta do entrevistador:**  
Uma implantação progressiva começou a aumentar erros de negócio, mas os indicadores técnicos permanecem normais. Como você agiria?

**O que essa pergunta avalia:**  
Avalia capacidade de correlacionar métricas técnicas e de negócio durante uma crise.

**Resposta esperada:**  
Eu interromperia a expansão da implantação e investigaria o impacto funcional. Métricas de negócio, como conversão, transações concluídas, pagamentos aprovados ou operações rejeitadas, podem detectar problemas que CPU, memória e latência não mostram.

As ações seriam:

- pausar o canary;
- limitar usuários expostos;
- comparar a versão nova com a anterior;
- verificar logs e traces;
- consultar equipes de negócio;
- decidir entre rollback e correção;
- comunicar impacto e próximos passos.

**Explicação didática:**  
Uma aplicação pode responder rapidamente e consumir poucos recursos, mas retornar resultados incorretos. Observabilidade precisa considerar a experiência real do usuário.

**Como o candidato deve responder:**  
Deve priorizar contenção, impacto do negócio, comunicação e decisão baseada em evidências.

**Resposta fraca ou incompleta:**  
“Como os indicadores técnicos estão normais, continuaria a implantação.”

Isso ignora sinais funcionais e pode ampliar o impacto.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Que métricas de negócio você acompanharia?
2. Quando escolheria rollback em vez de correção imediata?
3. Como comunicaria o problema para a liderança?

---

## Pergunta 98 — Liderança técnica em CI/CD

**Nível:** Sênior  
**Categoria:** Liderança técnica

**Pergunta do entrevistador:**  
Como conduziria uma equipe que discorda sobre a estratégia de CI/CD a ser adotada?

**O que essa pergunta avalia:**  
Avalia liderança, facilitação técnica, tomada de decisão e capacidade de construir consenso.

**Resposta esperada:**  
Eu começaria definindo o problema, os objetivos e as restrições. Depois compararia as alternativas com critérios objetivos, como:

- risco;
- custo;
- velocidade;
- capacidade de manutenção;
- segurança;
- experiência da equipe;
- compatibilidade com sistemas existentes;
- esforço de migração.

Quando possível, utilizaria um experimento ou prova de conceito. A decisão deveria ser registrada com suas premissas, trade-offs e critérios para reavaliação.

**Explicação didática:**  
Uma decisão técnica não deve ser vencida apenas pela pessoa mais sênior ou mais convincente. O processo precisa permitir que opiniões sejam avaliadas com base em evidências.

**Como o candidato deve responder:**  
Deve demonstrar escuta, objetividade, documentação, experimentação e capacidade de tomar uma decisão quando não houver consenso completo.

**Resposta fraca ou incompleta:**  
“Escolheria a opção que eu considero melhor porque tenho mais experiência.”

Isso substitui análise técnica por autoridade.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como documentaria a decisão?
2. Como lidaria com uma opinião minoritária tecnicamente válida?
3. Quando encerraria a discussão e escolheria uma alternativa?

---

## Pergunta 99 — Mentoria e adoção

**Nível:** Sênior  
**Categoria:** Liderança técnica

**Pergunta do entrevistador:**  
Como ajudaria equipes com pouca experiência a adotar práticas maduras de CI/CD?

**O que essa pergunta avalia:**  
Avalia mentoria, comunicação, influência e capacidade de promover mudança organizacional.

**Resposta esperada:**  
Eu começaria avaliando o nível atual de maturidade e os principais problemas. Depois proporia uma evolução gradual:

1. versionamento correto;
2. build automatizado;
3. testes básicos;
4. artefatos rastreáveis;
5. deploy em ambientes não produtivos;
6. observabilidade;
7. promoção controlada;
8. automação progressiva em produção.

Forneceria templates, exemplos, documentação, treinamentos e acompanhamento. A equipe deveria entender o motivo de cada prática, não apenas copiar configurações.

**Explicação didática:**  
A adoção sustentável depende de reduzir o esforço inicial e demonstrar valor. Obrigar uma solução complexa sem suporte tende a produzir contornos e baixa qualidade.

**Como o candidato deve responder:**  
Deve mostrar empatia, adaptação ao contexto, comunicação clara, metas progressivas e acompanhamento por métricas.

**Resposta fraca ou incompleta:**  
“Entregaria um template pronto e exigiria que todos o utilizassem.”

Isso pode não resolver as dificuldades reais das equipes.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Como mediria a evolução de maturidade?
2. Como lidaria com uma equipe resistente?
3. Que práticas adotaria primeiro em uma equipe com muitos incidentes?

---

## Pergunta 100 — Visão estratégica de CI/CD

**Nível:** Sênior  
**Categoria:** Estratégia

**Pergunta do entrevistador:**  
Como você avaliaria se a estratégia de CI/CD de uma organização está realmente gerando valor?

**O que essa pergunta avalia:**  
Avalia visão estratégica, pensamento sistêmico, análise de resultados e capacidade de conectar engenharia a negócio.

**Resposta esperada:**  
Eu avaliaria se a estratégia melhora simultaneamente:

- velocidade de entrega;
- confiabilidade;
- segurança;
- capacidade de recuperação;
- previsibilidade;
- produtividade das equipes;
- experiência dos desenvolvedores;
- custo operacional;
- satisfação dos usuários.

Analisaria métricas de entrega, incidentes, tempo de recuperação, falhas de mudança, vulnerabilidades, tempo de pipeline, retrabalho e impacto em objetivos de negócio.

Também verificaria se o processo é sustentável: pipelines devem ser mantíveis, controles não podem ser contornados e as equipes devem conseguir entregar sem depender de poucas pessoas.

**Explicação didática:**  
CI/CD não é apenas automatizar deploys. É criar um sistema de entrega confiável, seguro e capaz de gerar feedback rápido. Uma organização pode fazer muitos deploys e ainda ter baixa maturidade se houver incidentes frequentes, baixa rastreabilidade e processos frágeis.

**Exemplo prático:**  
Uma organização pode reduzir o lead time de dois dias para uma hora, mantendo ou reduzindo a taxa de falhas e diminuindo o tempo de recuperação. Isso indica melhoria mais consistente do que apenas aumentar a frequência de deploys.

**Como o candidato deve responder:**  
Deve conectar métricas técnicas a resultados de negócio e discutir trade-offs entre velocidade, custo, risco e qualidade. Também deve mencionar melhoria contínua e revisão periódica da estratégia.

**Resposta fraca ou incompleta:**  
“Basta verificar se os deploys estão automatizados e são frequentes.”

Automação e frequência são importantes, mas não comprovam confiabilidade, segurança ou geração de valor.

**Critérios de avaliação:**

- 0 — Não sabe responder ou apresenta informações incorretas;
- 1 — Demonstra conhecimento muito superficial;
- 2 — Conhece parte do conceito, mas apresenta lacunas importantes;
- 3 — Responde corretamente aos fundamentos;
- 4 — Demonstra bom domínio prático e apresenta exemplos;
- 5 — Responde com profundidade, apresenta trade-offs, boas práticas e experiência real.

**Perguntas de aprofundamento:**

1. Quais indicadores mostrariam que a velocidade aumentou à custa da qualidade?
2. Como identificar uma falsa sensação de maturidade?
3. Que decisão estratégica você tomaria se a organização tivesse muitos deploys, mas também muitos incidentes?

---

## Encerramento do roteiro

As perguntas 80 a 100 abrangem principalmente:

- Segurança da cadeia de fornecimento;
- Assinatura e proveniência de artefatos;
- Rollback e disaster recovery;
- Alta disponibilidade;
- Migração de ferramentas e arquitetura;
- Governança;
- Escalabilidade da plataforma;
- Custos;
- Métricas;
- Observabilidade;
- Incidentes críticos;
- Liderança técnica;
- Mentoria;
- Estratégia organizacional.

O candidato sênior deve demonstrar não apenas conhecimento de ferramentas, mas também capacidade de tomar decisões considerando:

- risco;
- custo;
- prazo;
- segurança;
- confiabilidade;
- impacto no negócio;
- experiência das equipes;
- capacidade de manutenção;
- evolução futura da plataforma.

**Nível:** Pleno  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como assinatura e atestação de artefatos podem aumentar a segurança de uma implantação?

**O que essa pergunta avalia:**  
Avalia integridade, proveniência e confiança no artefato.

**Resposta esperada:**  
A assinatura permite verificar que o artefato foi produzido por uma identidade confiável e não foi alterado. A atestação pode registrar origem, commit, processo de build, dependências e verificações realizadas. A implantação pode exigir essas evidências antes de aceitar o artefato.

**Explicação didática:**  
O objetivo é responder “o que foi produzido, por quem, a partir de qual código e sob quais controles?”.

**Exemplo prático:**  
Produção aceita somente imagens assinadas por um pipeline autorizado e associadas a um commit da branch principal.

**Exemplo de código:**  
Não é necessário código.

**Como o candidato deve responder:**  
Deve diferenciar integridade de proveniência e mencionar gestão de chaves.

**Resposta fraca ou incompleta:**  
“Assinar deixa o arquivo criptografado.”  
Assinatura compro