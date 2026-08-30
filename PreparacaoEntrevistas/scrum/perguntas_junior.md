### Pergunta 5 — Definition of Done (DoD)

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é a Definition of Done (DoD) no Scrum e por que ela é importante? Quem é responsável por defini-la?

**O que essa pergunta avalia:**
Avalia o entendimento do conceito de Definition of Done, sua importância para a qualidade e transparência, e o conhecimento de quem a define e mantém.

**Resposta esperada:**
A **Definition of Done (DoD)** é uma descrição formal do estado do Incremento quando atende aos requisitos de qualidade exigidos para ser considerado "pronto". É um acordo compartilhado que define o que significa "feito" para o time.

A DoD é de responsabilidade dos **Developers** do Scrum Team. Ela deve ser definida colaborativamente e pode evoluir ao longo do tempo.

Importância:
- Garante **transparência**: todos sabem exatamente o que "pronto" significa
- Garante **qualidade**: itens não "prontos" não são apresentados na Sprint Review como parte do Incremento
- Reduz ambiguidade: evita que um item seja considerado "quase pronto" por um e "incompleto" por outro
- Cria base para previsibilidade: com uma DoD consistente, o time pode medir velocidade real

Exemplos de itens em uma DoD:
- Código revisado por outro desenvolvedor
- Testes automatizados passando (unitários e de integração)
- Sem bugs críticos conhecidos
- Documentação atualizada
- Deploy em ambiente de homologação

**Explicação didática:**
Imagine que você pede a três cozinheiros diferentes para fazerem um "bolo pronto". Sem uma definição compartilhada de "pronto", um pode considerar pronto quando o bolo sai do forno, outro quando está decorado, e outro quando está fatiado e servido. A DoD é como a receita que diz exatamente os critérios para o bolo ser considerado "pronto": assado, decorado, provado e servido no prato. Assim, todos têm a mesma expectativa.

**Exemplo prático:**
Um time define a seguinte DoD: "Uma história está 'pronta' quando: o código está implementado, revisado por um par, testes unitários cobrem pelo menos 80%, testes de integração passam, o item foi testado em homologação e a documentação do usuário foi atualizada." Durante a Sprint Review, um item que foi codificado mas não passou por code review não é considerado parte do Incremento — não atende à DoD.

**Como o candidato deve responder:**
- Definir a DoD como um acordo de qualidade do time
- Explicar que os Developers são responsáveis por criá-la
- Citar pelo menos 3-4 critérios comuns de uma DoD
- Explicar por que a DoD é importante (transparência, qualidade, previsibilidade)
- Mencionar que a DoD pode evoluir

**Resposta fraca ou incompleta:**
"A DoD é uma checklist que o Product Owner faz para dizer se a história está pronta ou não." — Incorreta: a DoD não é definida pelo PO, é definida pelos Developers. E não é simplesmente uma "checklist do PO" — é um acordo de qualidade do time inteiro sobre o que significa trabalho completo.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que existe uma "definição de pronto", mas não explica quem define
- **2** — Explica o conceito, mas atribui a responsabilidade ao PO ou SM
- **3** — Define a DoD corretamente e atribui aos Developers
- **4** — Explica com clareza, dá exemplos de critérios e explica a importância
- **5** — Demonstra domínio, explica a relação entre DoD e Incremento, a diferença entre DoD e critérios de aceitação, e como a DoD evolui

**Perguntas de aprofundamento:**
1. Qual é a diferença entre Definition of Done e critérios de aceitação de uma história?
2. O que acontece se um item atende aos critérios de aceitação, mas não atende à DoD?
3. A DoD pode ser diferente para itens diferentes dentro do mesmo time?

---

### Pergunta 6 — Diferença entre Scrum e Kanban

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
Scrum e Kanban são duas das metodologias ágeis mais populares. Quais são as principais diferenças entre elas? Quando você escolheria uma sobre a outra?

**O que essa pergunta avalia:**
Avalia a capacidade de comparar dois frameworks ágeis, entender suas características distintas e tomar uma decisão fundamentada sobre qual aplicar em um contexto.

**Resposta esperada:**

| Característica | Scrum | Kanban |
|---|---|---|
| Iterações | Sprints fixas (1-4 semanas) | Fluxo contínuo, sem iterações fixas |
| Papéis | PO, SM, Developers | Não define papéis obrigatórios |
| Eventos | Sprint Planning, Daily, Review, Retrospective | Não define eventos obrigatórios (mas pode usar cadências) |
| Mudanças na Sprint | Sprint Backlog deve ser estável durante a Sprint | Itens podem entrar a qualquer momento (changeability) |
| Limitação de WIP | Não define WIP limit explicitamente | WIP limit é fundamental — limita trabalho em andamento |
| Métricas | Velocity | Lead time, cycle time, throughput |
| Estrutura | Mais estruturado e prescritivo | Mais flexível e adaptável |

**Quando escolher Scrum:**
- Quando há necessidade de feedback estruturado e regular
- Quando o time se beneficia de uma cadência fixa de planejamento e entrega
- Quando é importante ter eventos formais de inspeção e adaptação
- Projetos com entregas incrementais e revisáveis

**Quando escolher Kanban:**
- Quando o trabalho é predominantemente orientado a fluxo (ex: suporte, manutenção, ops)
- Quando as prioridades mudam frequentemente
- Quando a equipe precisa de flexibilidade máxima para mudança
- Quando o time já tem um processo funcionando e quer evoluir gradualmente

**Explicação didática:**
Pense no Scrum como um **ônibus**: ele para em estações definidas (Sprints), embarca passageiros no início (Sprint Planning) e não para pegar mais gente até a próxima estação. O Kanban é como uma **esteira de produção**: os itens entram de um lado, fluem pelas etapas e saem do outro, sem paradas programadas. O importante é não acumular muitos itens na esteira ao mesmo tempo (WIP limit).

**Exemplo prático:**
Um time de desenvolvimento de produto novo se beneficia do Scrum porque precisa de feedback regular dos usuários a cada Sprint. Já um time de suporte técnico que recebe tickets de problemas urgentes ao longo do dia se beneficia do Kanban, porque não pode esperar o início de uma Sprint para pegar um ticket urgente — o trabalho flui continuamente.

**Como o candidato deve responder:**
- Apresentar pelo menos 4-5 diferenças-chave entre Scrum e Kanban
- Explicar quando cada um é mais adequado
- Mencionar que não é preciso escolher um "de forma exclusiva" — é possível combinar (Scrumban)
- Evitar dizer que Kanban é "Scrum sem reuniões" (é uma simplificação incorreta)
- Evitar dizer que um é "melhor" que o outro — depende do contexto

**Resposta fraca ou incompleta:**
"Scrum tem sprints e Kanban não tem. Kanban é mais simples e melhor para coisas pequenas." — Muito superficial. A diferença vai muito além de "ter ou não sprints". Kanban não é necessariamente "melhor para coisas pequenas" — é sobre fluxo contínuo vs iterações. Não menciona WIP limit, papéis, eventos, nem contexto de aplicação.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que Scrum tem Sprints e Kanban não, mas sem mais detalhes
- **2** — Cita 2-3 diferenças, mas sem explicar contexto de uso
- **3** — Compara 4+ diferenças e explica quando usar cada um
- **4** — Compara com profundidade, menciona WIP limit, métricas e contextos de aplicação
- **5** — Demonstra domínio, compara os dois com nuances, menciona Scrumban e explica que a escolha depende do contexto e do tipo de trabalho

**Perguntas de aprofundamento:**
1. É possível usar Scrum e Kanban ao mesmo tempo? Como isso funcionaria na prática?
2. O que é WIP limit e por que ele é tão central no Kanban?
3. Se um time Scrum está sofrendo porque as prioridades mudam toda hora durante a Sprint, o que você sugeriria?

---

### Pergunta 7 — Manifesto Ágil

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O Manifesto Ágil é a base filosófica de todas as metodologias ágeis. Quais são os quatro valores fundamentais do Manifesto Ágil e o que cada um significa na prática?

**O que essa pergunta avalia:**
Avalia o conhecimento dos quatro valores do Manifesto Ágil, a compreensão de que "valorizar mais" não significa "excluir o outro", e a capacidade de traduzir os valores para situações reais.

**Resposta esperada:**
Os quatro valores do Manifesto Ágil são:

1. **Indivíduos e interações acima de processos e ferramentas** — As pessoas e como elas colaboram importam mais do que seguir um processo rigidamente. Um processo perfeito não salva um time que não se comunica; um time que colabora bem pode adaptar qualquer processo.

2. **Software funcionando acima de documentação abrangente** — Entregar algo que funciona e traz valor importa mais que documentar cada detalhe. Não significa "não documentar", mas sim priorizar o que funciona sobre documentação excessiva.

3. **Colaboração com o cliente acima de negociação de contratos** — Trabalhar junto com o cliente para entender suas necessidades reais é mais valioso do que seguir rigidamente um contrato. Contratos são importantes, mas a colaboração vem primeiro.

4. **Responder a mudanças acima de seguir um plano** — Adaptar-se a mudanças de requisitos, mercado ou tecnologia é mais importante do que seguir um plano fixo. Planos são úteis, mas não podem ser rígidos quando a realidade muda.

**Ponto crucial:** O Manifesto diz "embora haja valor nos itens à direita, valorizamos mais os itens à esquerda." Ou seja, não é uma exclusão — processos, documentação, contratos e planos têm valor, mas são secundários.

**Explicação didática:**
Imagine construir uma casa. O primeiro valor diz que a equipe de obra que se comunica bem importa mais que o software de gestão de obra. O segundo diz que morar na casa (software funcionando) importa mais que o manual de 500 páginas (documentação). O terceiro diz que conversar com o morador sobre o que ele precisa importa mais que o contrato inicial. O quarto diz que, se o morador mudar de ideia sobre o layout, é melhor adaptar do que seguir o plano original mesmo sabendo que não vai atender.

**Exemplo prático:**
Um time descobre, no meio de uma Sprint, que o cliente mudou a prioridade de uma feature. Em vez de dizer "o contrato diz que devemos entregar X", o time conversa com o cliente, entende a nova necessidade e adapta o plano. Isso reflete os valores de "colaboração com o cliente" e "responder a mudanças".

**Como o candidato deve responder:**
- Listar os quatro valores corretamente
- Explicar cada um com palavras próprias
- Mencionar a frase-chave "embora haja valor nos itens à direita"
- Dar pelo menos um exemplo prático
- Evitar interpretar os valores como "abandonar processos/documentação/contratos/planos"

**Resposta fraca ou incompleta:**
"O manifesto ágil diz que processos não importam e que documentação é desperdício." — Incorreto. O manifesto não diz que processos e documentação não importam — diz que as pessoas e o software funcionando importam *mais*. A interpretação de "valorizar mais" como "ignorar completamente" é um erro comum e grave.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Cita 1-2 valores, mas não os explica
- **2** — Cita os quatro valores, mas interpreta "acima de" como exclusão
- **3** — Lista e explica os quatro valores corretamente
- **4** — Explica os quatro valores com exemplos práticos e menciona a não-exclusão
- **5** — Demonstra domínio, explica a não-exclusão, conecta os valores a frameworks e situações reais

**Perguntas de aprofundamento:**
1. Os 12 princípios do Manifesto Ágil complementam esses 4 valores. Você consegue citar alguns?
2. Como o valor "software funcionando acima de documentação abrangente" se aplica em um projeto regulado (ex: área médica ou financeira) onde a documentação é obrigatória?
3. O que acontece quando um time diz ser "ágil" mas ignora completamente processos e planos?

---

### Pergunta 8 — Daily Scrum

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
Você foi designado como Scrum Master de um time que tem o hábito de usar a Daily Scrum como uma reunião de status para o Scrum Master. As pessoas respondem apenas às três perguntas clássicas e ninguém levanta impedimentos. Como você abordaria essa situação?

**O que essa pergunta avalia:**
Avalia a compreensão do verdadeiro propósito da Daily Scrum, a capacidade de identificar anti-patterns e a habilidade de atuar como Scrum Master para corrigir o comportamento do time.

**Resposta esperada:**
A Daily Scrum **não é uma reunião de status**. É um evento de 15 minutos para os **Developers** inspecionarem o progresso em direção à meta da Sprint e adaptarem o Sprint Backlog conforme necessário. O Scrum Master não é o "recebedor" do status — os Developers são donos do evento.

Para abordar a situação:

1. **Educar o time:** Facilitar uma conversa sobre o propósito real da Daily. Explicar que não é para reportar ao SM, mas para o time sincronizar e identificar bloqueios.

2. **Mudar o formato:** Em vez de cada pessoa responder às três perguntas mecanicamente (o que pode virar um ritual sem significado), focar no Sprint Backlog: olhar o quadro e discutir "estamos caminhando para a meta da Sprint? O que está bloqueando? Precisamos ajustar algo?".

3. **Encorajar transparência:** Criar um ambiente onde as pessoas se sintam seguras para levantar impedimentos reais. Se ninguém levanta impedimentos, pode haver um problema de segurança psicológica.

4. **Usar a Retrospective:** Levar a discussão sobre a Daily para a Sprint Retrospective, permitindo que o time identifique o problema e proponha soluções.

5. **Modelar o comportamento:** Como SM, não fazer perguntas individuais tipo "o que você fez ontem?", mas sim perguntas orientadas ao time: "O que precisamos fazer hoje para avançar a meta da Sprint?".

**Explicação didática:**
Imagine a Daily Scrum como a reunião rápida de uma equipe de cirurgia antes de começar uma operação. O objetivo não é cada médico dizer "ontem fiz X procedimentos" — isso não ajuda a cirurgia atual. O objetivo é: "onde estamos, o que falta, quem precisa de ajuda e vamos ajustar o plano." Se cada um só fala de si sem olhar o quadro (a "sala de cirurgia"), a reunião perde o propósito.

**Exemplo prático:**
Em vez de:
- dev1: "Ontem corrigi um bug. Hoje vou trabalhar na feature X. Sem bloqueios."
- dev2: "Ontem escrevi testes. Hoje vou refatorar o módulo Y. Sem bloqueios."

Um formato mais eficaz:
- "Olhando nosso Sprint Backlog, a história de login está quase pronta, mas a de dashboard não começou ainda. Precisamos de mais alguém nela? Algo está bloqueando?"
- "O teste de integração está falhando no CI desde ontem. Isso é um impedimento que precisa ser resolvido hoje."

**Como o candidato deve responder:**
- Identificar que o problema é cultural, não de formato
- Explicar o verdadeiro propósito da Daily (inspeção e adaptação, não status)
- Propor ações concretas (educação, mudança de formato, Retrospective)
- Mencionar a importância da segurança psicológica para levantar impedimentos
- Evitar propor soluções punitivas ou autoritárias

**Resposta fraca ou incompleta:**
"Eu mudaria as três perguntas para perguntas diferentes e exigiria que todo mundo levantasse os impedimentos." — Abordagem autoritária que não resolve o problema de fundo. Trocar as perguntas sem mudar a compreensão do propósito da Daily não resolve o anti-pattern. Exigir impedimentos pode gerar impedimentos artificiais.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica o problema, mas não propõe soluções
- **2** — Propõe soluções superficiais (mudar perguntas, cobrar mais)
- **3** — Explica o propósito correto da Daily e propõe 2-3 ações razoáveis
- **4** — Demonstra boa compreensão, propõe ações concretas e menciona Retrospective e segurança psicológica
- **5** — Demonstra domínio, conecta o problema aos valores do Scrum, propõe abordagem educativa e gradual, menciona auto-organização

**Perguntas de aprofundamento:**
1. As três perguntas clássicas da Daily ("o que fiz ontem, o que vou fazer hoje, há impedimentos?") estão no Guia Scrum? Por que elas existem e por que às vezes são problemáticas?
2. O que fazer se um membro do time consistentemente chega atrasado à Daily?
3. A Daily Scrum pode ser feita de forma assíncrona (ex: por chat) ou precisa ser presencial/em videochamada?

---

### Pergunta 9 — Velocity e estimativas

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
O que é "velocity" no contexto do Scrum e como ela é calculada? Quais são os cuidados que o time deve ter ao usar velocity como métrica?

**O que essa pergunta avalia:**
Avalia o entendimento do conceito de velocity, como é calculada, e a consciência sobre os perigos de usar essa métrica de forma inadequada.

**Resposta esperada:**
**Velocity** é uma métrica que representa a quantidade de trabalho (medida em story points ou horas) que um time completa em uma Sprint. É calculada somando os pontos de todos os itens do Sprint Backlog que atenderam à Definition of Done ao final da Sprint.

Como calcular:
1. Atribuir story points a cada item do Product Backlog durante o refinement
2. Ao final da Sprint, somar os pontos dos itens que atingiram a DoD
3. Acompanhar ao longo de várias Sprints para identificar uma média (velocity do time)

Cuidados importantes:
- **Velocity não é meta de produtividade:** Usar velocity como meta a ser batida incentiva inflar estimativas e comprometer qualidade
- **Velocity não compara times:** Cada time estima de forma diferente — 30 pontos de um time não equivalem a 30 pontos de outro
- **Velocity é relativa:** Serve para prever quantos itens o time consegue entregar em Sprints futuras, não para medir "quem trabalha mais"
- **Variação é normal:** Velocity flutua entre Sprints. Uma variação pequena é esperada; grandes variações merecem investigação
- **Não deve ser usada para avaliação individual:** Velocity é métrica do time, não de pessoas

**Explicação didática:**
Pense em velocity como a média de quilometros por litro de um carro. Não é uma meta ("preciso fazer 12 km/l!"), é uma observação de quanto o carro percorre com um tanque. Se você começa a acelerar mais para "bater a meta de km/l", pode prejudicar o motor. A velocity, como a km/l, é uma **informação de planejamento**: ajuda a prever quanto o time consegue pegar na próxima Sprint, mas não deve ser forçada.

**Exemplo prático:**
Um time tem as seguintes velocities nas últimas 4 Sprints: 34, 38, 32, 36 pontos. A média é 35. No próximo Sprint Planning, o time pode selecionar aproximadamente 35 pontos do Product Backlog, sabendo que é um valor histórico, não uma garantia. Se o PO pressiona para "entregar 50 pontos essa Sprint", o time deve explicar que isso seria inflar artificialmente, não entregar mais valor.

**Como o candidato deve responder:**
- Definir velocity corretamente (soma de pontos dos itens prontos na Sprint)
- Explicar como é calculada
- Mencionar pelo menos 3 cuidados/anti-patterns no uso de velocity
- Esclarecer que velocity é para planejamento, não para avaliação de performance
- Evitar sugerir que velocity é uma métrica de produtividade ou que deve ser comparada entre times

**Resposta fraca ou incompleta:**
"Velocity é a velocidade do time, quantas histórias ele entrega por sprint. Quanto maior a velocity, mais produtivo é o time." — Incorreto em vários pontos: velocity mede pontos, não número de histórias (uma história de 13 pontos não vale o mesmo que 13 histórias de 1 ponto). E velocity não é diretamente proporcional a produtividade — times com velocity menor podem estar entregando mais valor se suas histórias forem mais impactantes.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que velocity é sobre "quantidade entregue", mas não explica como funciona
- **2** — Define velocity corretamente, mas não menciona cuidados no uso
- **3** — Define e calcula velocity, menciona 1-2 cuidados
- **4** — Explica com clareza, menciona 3+ cuidados e explica o uso para planejamento
- **5** — Demonstra domínio, explica a métrica, os anti-patterns, a não-comparabilidade entre times e o uso correto para previsibilidade

**Perguntas de aprofundamento:**
1. Se um time tem uma velocity de 40 pontos e o PO pede para "aumentar para 60", quais seriam os riscos?
2. Como o time deve lidar com uma queda brusca na velocity em uma Sprint específica?
3. Story points são a única unidade possível para calcular velocity? Que alternativas existem?

---

### Pergunta 10 — WIP Limit no Kanban

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é o WIP limit (Work in Progress limit) no Kanban e por que ele é tão importante? O que acontece quando um time Kanban não define WIP limits?

**O que essa pergunta avalia:**
Avalia o entendimento do conceito central do Kanban — o WIP limit —, sua função no sistema e as consequências de não utilizá-lo.

**Resposta esperada:**
O **WIP limit (Work in Progress limit)** é o limite máximo de itens que podem estar em andamento simultaneamente em uma coluna (ou em todo o quadro) do Kanban. É um dos princípios fundamentais do Kanban.

Importância do WIP limit:

1. **Reduz multitarefa:** Quando há limite, o time não pode começar novo trabalho até terminar o que está em andamento. Isso foca o esforço e reduz a perda de tempo com trocas de contexto.

2. **Identifica gargalos:** Se o WIP limit de uma coluna é atingido, o time precisa investigar por que os itens não estão fluindo — isso torna os problemas visíveis.

3. **Melhora o fluxo:** Com menos itens em andamento, cada item é concluído mais rapidamente, reduzindo o lead time.

4. **Previne sobrecarga:** O time não se compromete com mais trabalho do que consegue processar.

5. **Cria pull system:** O Kanban é um sistema pull — novos itens só entram quando há capacidade, não quando são "empurrados" para o time.

**O que acontece sem WIP limit:**
- O time acumula trabalho em andamento sem limite
- Multitarefa aumenta drasticamente
- Lead time cresce (cada item demora mais para ser concluído)
- Gargalos ficam invisíveis
- A equipe parece "ocupada" mas entrega pouco

**Explicação didática:**
Imagine uma cozinha de restaurante com 10 pedidos simultâneos. Se o cozinheiro tenta cozinhar os 10 ao mesmo tempo, nenhum sai bem — ele fica trocando de panela o tempo todo e tudo demora. Se o cozinheiro define um WIP limit de 3 pratos ao mesmo tempo, ele termina um antes de começar o próximo. Parece mais lento, mas na verdade os pratos saem mais rápido e com mais qualidade, porque não há troca de contexto.

**Exemplo prático:**
Um quadro Kanban com as colunas "To Do", "In Progress", "Testing", "Done". O WIP limit de "In Progress" é 3. Se já há 3 itens nessa coluna e alguém quer pegar mais um, o time deve primeiro ajudar a terminar um dos 3 itens ou mover um para "Testing" antes de começar um novo. O WIP limit não é uma barreira rígida — é um sinal de alerta: "precisamos terminar antes de começar mais".

**Como o candidato deve responder:**
- Definir WIP limit corretamente
- Explicar pelo menos 3 razões pelas quais é importante
- Descrever o que acontece sem WIP limit
- Mencionar que o Kanban é um sistema pull
- Diferenciar WIP limit por coluna e WIP limit total
- Evitar dizer que WIP limit é apenas "limitar o número de tarefas"

**Resposta fraca ou incompleta:**
"WIP limit é o máximo de tarefas que pode ter no quadro. Serve para não colocar tarefas demais." — Superficial. O WIP limit não é sobre o quadro inteiro, é sobre colunas específicas (e/ou o sistema todo). E o propósito não é apenas "não colocar demais" — é criar fluxo, expor gargalos e reduzir multitarefa. Não menciona pull system, lead time ou gargalos.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que WIP limit é sobre "limitar tarefas", mas não explica o porquê
- **2** — Define WIP limit, mas menciona apenas 1-2 motivos
- **3** — Define WIP limit e explica 3+ motivos com clareza
- **4** — Explica WIP limit, pull system, gargalos e consequências de não usar
- **5** — Demonstra domínio, conecta WIP limit com Little's Law, explica ajuste de WIP limit e diferença entre WIP por coluna e total

**Perguntas de aprofundamento:**
1. Como um time define o valor do WIP limit? Por qual número começar?
2. O que acontece quando uma coluna atinge o WIP limit e o time precisa pegar mais um item urgente?
3. É possível ter WIP limit em um quadro Scrum? Como isso funcionaria?

---

### Pergunta 11 — Sprint Planning

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
Descreva como uma Sprint Planning bem estruturada deve acontecer. Quais são os tópicos que precisam ser discutidos e quem participa de quais decisões?

**O que essa pergunta avalia:**
Avalia o conhecimento prático de como conduzir um Sprint Planning, a compreensão das decisões que cabem ao PO versus aos Developers, e a estruturação adequada do evento.

**Resposta esperada:**
A Sprint Planning ocorre no início da Sprint e responde a três perguntas fundamentais:

1. **Por que esta Sprint é valiosa? (Meta da Sprint)**
   - O PO propõe como a Sprint pode agregar valor ao produto
   - O time inteiro colabora para definir a **Sprint Goal** (meta da Sprint)
   - A Sprint Goal deve ser um objetivo coerente que guia o trabalho da Sprint

2. **O que pode ser entregue? (Seleção de itens)**
   - O PO apresenta os itens do Product Backlog ordenados por prioridade
   - Os Developers selecionam quais itens podem ser entregues na Sprint, considerando:
     - A Sprint Goal
     - A capacity do time (férias, feriados, disponibilidade)
     - A velocity histórica como referência
     - A Definition of Done
   - O PO esclarece dúvidas sobre os itens

3. **Como o trabalho será realizado? (Plano de execução)**
   - Os Developers decompõem os itens selecionados em tarefas técnicas
   - Criam um plano de como alcançar a Sprint Goal
   - Este plano forma o Sprint Backlog junto com os itens selecionados

Participantes:
- **Product Owner:** Apresenta o Backlog, explica o valor, esclarece dúvidas, colabora na definição da Sprint Goal
- **Developers:** Selecionam os itens, estimam, criam o plano, definem a capacity
- **Scrum Master:** Facilita o evento, garante que o propósito seja entendido, remove impedimentos que surgirem

**Explicação didática:**
Pense na Sprint Planning como planejar uma viagem de fim de semana. Primeiro, você decide **por que** vai viajar (meta: "relaxar na praia"). Depois, decide **o que** levar (itens: roupa de banho, protetor, livros) considerando o espaço da mala (capacity). Por fim, decide **como** organizar tudo na mala e a rota até a praia (plano de execução). Cada decisão envolve pessoas diferentes: o destino é decidido por quem convida (PO), o que levar é decidido por quem vai (Developers), e o roteiro é definido pelos viajantes.

**Exemplo prático:**
Sprint Planning de um time com Sprint de 2 semanas:

- **Primeiros 30 min:** O PO apresenta a meta "Permitir que usuários façam login com Google" e mostra os 3 itens do Backlog relacionados.
- **Próximos 45 min:** Os Developers fazem perguntas ao PO sobre critérios de aceitação, estimam os itens (8, 5 e 3 pontos) e verificam que a capacity da Sprint é de ~21 pontos.
- **Últimos 45 min:** Os Developers detalham as tarefas técnicas: "configurar OAuth no backend", "criar botão de login no frontend", "escrever testes de integração", "atualizar documentação". O Sprint Backlog está pronto.

**Como o candidato deve responder:**
- Mencionar as três questões-chave (Why, What, How)
- Diferenciar quem decide o quê (PO propõe valor, Developers decidem o que podem entregar)
- Explicar o papel da Sprint Goal
- Mencionar que o time considera capacity e velocity
- Evitar dizer que o PO "determina" o que o time deve fazer

**Resposta fraca ou incompleta:**
"O PO chega com a lista do que tem que ser feito, o time estima e pegamos o que cabe na Sprint." — Omite a definição da Sprint Goal, não menciona a colaboração entre PO e time, e trata o planejamento como um processo unilateral do PO. A Sprint Goal é o elemento central que guia toda a Sprint e não foi mencionada.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "planejar a Sprint", mas não detalha
- **2** — Menciona seleção de itens, mas omite Sprint Goal ou plano de execução
- **3** — Explica as três partes (Why, What, How) e quem participa
- **4** — Detalha bem o processo, menciona capacity, velocity e Sprint Goal
- **5** — Demonstra domínio, explica nuances como negociação PO-Developers, flexibilidade do plano e a relação entre Sprint Goal e Product Goal

**Perguntas de aprofundamento:**
1. O que acontece se, durante a Sprint Planning, o time percebe que não há itens suficientes refinados no Product Backlog?
2. A Sprint Goal pode mudar durante a Sprint? Em que circunstâncias?
3. Como lidar com um PO que quer "determinar" exatamente o que o time deve entregar sem deixar os Developers decidirem?

---

### Pergunta 12 — Sprint Retrospective

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
Qual é o objetivo da Sprint Retrospective e como você conduziria uma Retrospective com um time que sempre diz que "tudo está ótimo" e nunca propõe melhorias?

**O que essa pergunta avalia:**
Avalia o entendimento do propósito da Retrospective e a capacidade de atuar como facilitador para superar a resistência do time em identificar pontos de melhoria.

**Resposta esperada:**
A **Sprint Retrospective** é o evento final da Sprint, onde o time reflete sobre:
- Como foi a Sprint em relação a pessoas, relacionamentos, processos e ferramentas
- O que funcionou bem e deve ser mantido
- O que não funcionou e precisa melhorar
- Como melhorar a eficácia e a qualidade do próximo Sprint

O objetivo **não é reclamar**, mas **identificar melhorias acionáveis** que o time pode implementar na próxima Sprint.

Para um time que sempre diz "tudo está ótimo":

1. **Criar segurança psicológica:** O time pode temer que apontar problemas seja visto como incompetência. O SM deve criar um ambiente seguro onde a honestidade é valorizada.

2. **Usar dados e fatos:** Em vez de perguntas abertas, usar métricas: "Nossa velocity caiu 20% essa Sprint. O que isso nos diz?" ou "Tivemos 3 bugs em produção na última Sprint. O que podemos aprender?"

3. **Variar o formato:** Usar formatos diferentes de Retrospective (ex: Start/Stop/Continue, Sailboat, 4Ls) para evitar a repetição que gera respostas automáticas.

4. **Focar em pequenas melhorias:** Nem toda melhoria precisa ser grande. Pequenos ajustes incrementais são mais sustentáveis. "O que podemos melhorar em 1% na próxima Sprint?"

5. **Modelar a vulnerabilidade:** Como SM, ser o primeiro a compartilhar algo que *eu* poderia melhorar, mostrando que ninguém é perfeito.

6. **Evitar a culpa:** Focar no sistema/processo, não em pessoas. "O que no nosso processo permitiu que isso acontecesse?" em vez de "quem cometeu o erro?"

**Explicação didática:**
Imagine um atleta que, após cada treino, só diz "foi ótimo, treinei bem". Sem nunca analisar o que pode melhorar — a respiração, a postura, o ritmo — o atleta melhora muito lentamente. A Retrospective é como a análise pós-treino: não é sobre "foi bom ou ruim?", é sobre "o que aprendi que me ajuda a melhorar o próximo treino?"

**Exemplo prático:**
Formato **Start/Stop/Continue** para uma Retrospective:
- **Start:** "Começar a fazer code review em pares em vez de individual"
- **Stop:** "Parar de adicionar itens à Sprint no meio sem remover outros"
- **Continue:** "Continuar com a prática de testes automatizados que reduziu bugs"

O time seleciona **uma** melhoria para implementar na próxima Sprint — não cinco, para garantir que seja viável.

**Como o candidato deve responder:**
- Explicar o propósito da Retrospective (melhoria contínua, não reclamação)
- Propor pelo menos 3 estratégias para um time "que sempre diz que está tudo bom"
- Mencionar a importância de segurança psicológica
- Sugerir uso de dados para basear a discussão
- Mencionar que as melhorias devem ser acionáveis e específicas
- Evitar propor abordagens autoritárias ("obrigar" o time a falar)

**Resposta fraca ou incompleta:**
"Eu perguntaria diretamente o que deu errado e exigiria que cada um falasse pelo menos um problema." — Abordagem punitiva que provavelmente vai gerar problemas artificiais ou silenciar ainda mais o time. A Retrospective não deve ser um interrogatório. Não aborda a causa raiz: por que o time não se sente à vontade para compartilhar?

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "falar sobre a Sprint", mas não propõe soluções
- **2** — Explica o propósito, mas propõe soluções superficiais
- **3** — Explica o propósito corretamente e propõe 2-3 estratégias razoáveis
- **4** — Propõe estratégias concretas, menciona segurança psicológica, dados e formatos variados
- **5** — Demonstra domínio, conecta com a melhoria contínua, menciona que as ações devem ser acionáveis e que o time é quem decide o que melhorar

**Perguntas de aprofundamento:**
1. O que fazer quando o time identifica uma melhoria na Retrospective mas não a implementa na Sprint seguinte?
2. A Retrospective deve focar apenas no processo técnico ou também em relações e comunicação?
3. Qual é a diferença entre uma Retrospective e uma Sprint Review?

---

### Pergunta 13 — Refinamento do Backlog

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
O que é o refinamento do Product Backlog (Backlog Refinement) e por que ele é necessário? Quem participa e quando deve acontecer?

**O que essa pergunta avalia:**
Avalia o entendimento do refinamento como atividade contínua e essencial, não como um evento formal do Scrum, mas como prática necessária para manter o Backlog saudável.

**Resposta esperada:**
O **refinamento do Product Backlog** é a atividade de adicionar detalhes, estimativas e ordem aos itens do Backlog. Não é um evento formal do Scrum (não tem timebox obrigatório), mas é uma atividade essencial que acontece durante a Sprint para preparar itens para futuras Sprints.

Objetivos do refinamento:
1. **Detalhar itens:** Adicionar descrições claras, critérios de aceitação e contexto
2. **Estimar:** Atribuir story points ou tamanho aos itens
3. **Ordenar:** Garantir que os itens mais prioritários estejam no topo e mais detalhados
4. **Decompor:** Quebrar itens grandes (epics) em histórias menores e gerenciáveis
5. **Eliminar:** Remover itens que não fazem mais sentido

Participantes:
- **Product Owner:** Lidera o refinamento, esclarece o valor e os critérios de aceitação
- **Developers:** Fazem perguntas, estimam, identificam riscos técnicos e sugerir decomposição
- **Scrum Master:** Facilita, garante que o refinamento aconteça e que o time não gaste tempo excessivo

Quando deve acontecer:
- **Durante a Sprint atual**, consumindo cerca de 5-10% da capacity do time
- Não precisa ser uma única reunião — pode ser distribuído em sessões curtas
- Os itens refinados estarão prontos para a próxima Sprint Planning

**Explicação didática:**
Imagine que o Product Backlog é como uma horta. Se você não cuida dela regularmente, as ervas daninhas crescem, as plantas se misturam e você não sabe mais o que está plantando. O refinamento é a manutenção regular da horta: você separa as plantas por tipo, remove as que não servem, prepara o solo para as próximas plantações e garante que tudo está organizado para quando chegar a hora de plantar (Sprint Planning).

**Exemplo prático:**
Durante a Sprint, o time separa 1 hora, 3 vezes por semana, para refinamento. Na primeira sessão, o PO apresenta o epic "Sistema de Relatórios" e o time discute os critérios de aceitação. Na segunda, o time decompõe o epic em 3 histórias: "Relatório de vendas", "Relatório de estoque", "Exportar relatório em PDF". Na terceira, o time estima cada história (5, 3 e 2 pontos). Agora, no próximo Sprint Planning, esses itens já estão prontos para serem selecionados.

**Como o candidato deve responder:**
- Explicar que refinamento não é um evento formal do Scrum
- Mencionar que consome ~5-10% da capacity
- Explicar quem participa e o que cada um faz
- Citar pelo menos 3 objetivos do refinamento
- Explicar que prepara itens para futuras Sprints
- Evitar confundir refinamento com Sprint Planning

**Resposta fraca ou incompleta:**
"Refinamento é a reunião antes da Sprint Planning onde o PO organiza o backlog." — Incorreto em vários pontos: o refinamento não é uma única reunião, é uma atividade contínua. E não é apenas o PO organizando — os Developers participam ativamente, estimam e fazem perguntas. O refinamento acontece *durante* a Sprint, não "antes" da Sprint Planning.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "organizar o backlog", mas sem detalhes
- **2** — Explica o conceito, mas não menciona participantes ou quando acontece
- **3** — Explica corretamente, cita participantes e momento
- **4** — Explica com clareza, menciona objetivos, participantes, timing e % de capacity
- **5** — Demonstra domínio, explica o conceito de "pronto para Sprint Planning" (Definition of Ready), decomposição de epics e como o refinamento evita Sprint Plannings longas

**Perguntas de aafundamento:**
1. O que é "Definition of Ready" e como ela se relaciona com o refinamento?
2. O que acontece quando um time não faz refinamento e chega direto na Sprint Planning?
3. Como lidar com um Backlog que tem 500 itens e a maioria está desatualizada?

---

### Pergunta 14 — Incremento

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é o Incremento no Scrum? Um Incremento precisa ser entregue em produção ao final de cada Sprint? Justifique sua resposta.

**O que essa pergunta avalia:**
Avalia o entendimento do conceito de Incremento e a diferença entre "Incremento" e "deploy em produção", um ponto de confusão muito comum.

**Resposta esperada:**
O **Incremento** é um corpo de trabalho iterativo e incremental que agrega valor ao produto. É a soma de todos os itens do Product Backlog completados durante a Sprint, mais o valor de Incrementos de Sprints anteriores.

Características do Incremento:
- Deve atender à **Definition of Done**
- Deve estar em condição utilizável, independentemente de ser "releasable"
- Cada Incremento é aditivo a todos os Incrementos anteriores
- Deve estar em um estado que permita ser inspecionado na Sprint Review

**Precisa ser entregue em produção?** Não necessariamente. O Guia Scrum diz que o Incremento deve ser "potentially releasable" (potencialmente liberável), mas a **decisão de release** é do Product Owner. O time pode entregar um Incremento que atende à DoD, mas o PO pode decidir acumular vários Incrementos antes de fazer um release em produção.

É importante diferenciar:
- **Incremento:** O trabalho que atende à DoD e agrega valor — concluído ao final de cada Sprint
- **Release:** A disponibilização do Incremento para usuários finais — decisão do PO, pode ocorrer a cada Sprint, a cada várias Sprints, ou continuamente (continuous delivery)

**Explicação didática:**
Imagine que você está construindo uma casa. O Incremento de cada Sprint é como concluir um cômodo: a cozinha está pronta e habitável (atende à DoD), mas você não precisa se mudar imediatamente. Você pode terminar a cozinha (Incremento 1), depois o quarto (Incremento 2), e só então se mudar (Release). Cada cômodo está "potencialmente habitável", mas a decisão de se mudar depende de você (PO).

**Exemplo prático:**
Um time desenvolve uma feature de "carrinho de compras" na Sprint 1 — esse é um Incremento que atende à DoD. Na Sprint 2, desenvolvem "checkout e pagamento" — segundo Incremento. O PO decide não fazer release na Sprint 1 porque a feature de carrinho sozinha não traz valor suficiente sem o checkout. Na Sprint 2, com ambos os Incrementos prontos, o PO decide fazer o release em produção.

**Como o candidato deve responder:**
- Definir o Incremento corretamente (soma dos itens completados + Incrementos anteriores)
- Explicar que deve atender à DoD
- Esclarecer que não precisa ser entregue em produção
- Diferenciar Incremento de Release
- Explicar que a decisão de release é do PO
- Mencionar "potentially releasable" vs "actually released"

**Resposta fraca ou incompleta:**
"O Incremento é o que o time entrega na Sprint Review e tem que ir para produção." — Incorreto: o Incremento não precisa ir para produção. Ele precisa estar pronto e atender à DoD, mas a decisão de release é do PO. Confundir "pronto" com "em produção" é um erro comum.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "o que foi entregue", mas não explica
- **2** — Define Incremento, mas acha que precisa ir para produção
- **3** — Define Incremento corretamente e explica que não precisa ir para produção
- **4** — Explica com clareza, diferencia Incremento de Release e menciona a decisão do PO
- **5** — Demonstra domínio, explica o conceito aditivo do Incremento, a relação com a DoD e o conceito de "potentially releasable"

**Perguntas de aprofundamento:**
1. É possível ter mais de um Incremento em uma única Sprint?
2. O que significa "potentially releasable" na prática? Precisa estar deployado em algum ambiente?
3. Como o conceito de continuous delivery se relaciona com o Incremento do Scrum?

---

### Pergunta 15 — Auto-organização do time

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
Um dos princípios do Scrum é que os times são auto-organizados. O que isso significa na prática? Um time auto-organizado não precisa de nenhum tipo de gerenciamento?

**O que essa pergunta avalia:**
Avalia o entendimento do conceito de auto-organização, diferenciando-o de "ausência total de gestão" ou "cada um faz o que quer".

**Resposta esperada:**
**Auto-organização** significa que o time decide internamente *como* o trabalho será realizado, sem que um gerente externo determine tarefas, atribuições ou métodos. No Scrum, os Developers escolhem:
- Quantos itens pegar na Sprint (negociando com o PO)
- Como decompor os itens em tarefas técnicas
- Quem trabalha em quê dentro do time
- Como garantir que a DoD seja atendida

O que auto-organização **NÃO é**:
- Não é ausência de responsabilidade: o time é responsável por entregar o Incremento
- Não é ausência de liderança: o Scrum Master exerce liderança servindo, não comandando
- Não é "cada um faz o que quer": o time tem compromissos com a Sprint Goal e a DoD
- Não é ausência de coordenação: a Daily Scrum e o Sprint Backlog são mecanismos de coordenação

O que o time auto-organizado **não decide**:
- *O que* entra no Product Backlog (decisão do PO)
- *A prioridade* dos itens (decisão do PO)
- *A meta* da Sprint (negociada entre PO e time)
- *Os critérios* da DoD (definidos pelo time, mas geralmente alinhados com a organização)

**Explicação didática:**
Pense em uma orquestra sem maestro. Os músicos auto-organizados não significam que cada um toca o que quer — eles seguem a partitura (Sprint Goal), combinam quem toca qual parte (atribuição interna) e se sincronizam ouvindo uns aos outros (Daily Scrum). A auto-organização é sobre *quem decide como*, não sobre *ausência de direção*.

**Exemplo prático:**
Em um time Scrum, o PO diz "preciso da feature de exportação de relatórios na próxima Sprint" (o que). O time avalia, estima e decide: "vamos dividir em backend (API de exportação) e frontend (botão e download). João cuida do backend, Maria do frontend, e Carlos dos testes" (como). Ninguém externo ao time atribuiu as tarefas — o time se auto-organizou para entregar a Sprint Goal.

**Como o candidato deve responder:**
- Definir auto-organização corretamente
- Explicar o que o time decide e o que não decide
- Mencionar que auto-organização não é "ausência de gestão"
- Citar exemplos práticos de decisões que o time toma
- Esclarecer o papel do Scrum Master (facilita, não comanda)
- Evitar interpretar auto-organização como "liberdade total sem responsabilidade"

**Resposta fraca ou incompleta:**
"Auto-organização é quando o time não tem gerente e cada um faz o que achar melhor." — Incorreto: auto-organização não significa "sem gerente" nem "cada um faz o que quer". O time tem compromissos (Sprint Goal, DoD) e precisa coordenar o trabalho. O Scrum Master exerce uma forma de liderança, embora não como gerente tradicional.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "o time se organiza", mas não explica limites
- **2** — Explica o conceito, mas não diferencia o que o time decide do que não decide
- **3** — Define corretamente e explica limites da auto-organização
- **4** — Explica com clareza, menciona o que o time decide vs não decide, e o papel do SM
- **5** — Demonstra domínio, conecta auto-organização com os valores do Scrum e explica a relação com a complexidade

**Perguntas de aprofundamento:**
1. Como um Scrum Master pode ajudar um time que está acostumado a receber tarefas de um gerente a se tornar auto-organizado?
2. O que acontece quando um membro do time não cumpre o que o time combinou em auto-organização?
3. Um time pode ser auto-organizado e ainda assim ter um gerente de projetos?

---

### Pergunta 16 — Story Points e Planning Poker

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
O que são story points e como o Planning Poker funciona para estimar itens do Backlog? Por que usar story points em vez de estimar em horas?

**O que essa pergunta avalia:**
Avalia o conhecimento sobre técnicas de estimativa ágil, a compreensão do Planning Poker como processo colaborativo e a justificativa para usar story points.

**Resposta esperada:**
**Story points** são uma unidade de medida relativa para estimar o esforço, complexidade e incerteza de um item do Backlog. Não medem tempo diretamente — medem o "tamanho" do trabalho em relação a outros itens.

A sequência de Fibonacci (1, 2, 3, 5, 8, 13, 21, ...) é frequentemente usada porque a incerteza aumenta com o tamanho: a diferença entre 1 e 2 é clara, mas entre 20 e 21 é insignificante, então os números crescem mais para refletir maior incerteza.

**Planning Poker** funciona assim:
1. O PO apresenta um item do Backlog e esclarece dúvidas
2. Cada membro do time recebe um baralho de cartões com os valores da sequência
3. Cada um escolhe um valor *individualmente e em silêncio* (sem influenciar os outros)
4. Todos revelam as cartas simultaneamente
5. Se há divergência significativa (ex: um disse 2 e outro disse 13), as pessoas com estimativas extremas explicam seu raciocínio
6. O time discute e vota novamente
7. Repete até convergir (ou o facilitador define um valor após 2-3 rodadas)

**Por que story points em vez de horas?**
1. **Relativo, não absoluto:** Estimar em horas assume que todos trabalham na mesma velocidade. Story points são relativos ao próprio time.
2. **Menos pressão de "acerto":** Horas criam a expectativa de precisão ("disse 8 horas, tem que ser 8 horas"). Points aceitam incerteza natural.
3. **Inclui complexidade e risco:** Um item que leva 4 horas mas é tecnicamente arriscado pode ter mais pontos que um item que leva 8 horas mas é rotineiro.
4. **Velocity estável:** Velocity em points tende a se estabilizar ao longo do tempo; em horas, flutua muito com Interrupções e contexto.

**Explicação didática:**
Imagine que você precisa estimar o tempo para chegar a um destino que nunca visitou. Você pode estimar em horas (1h, 2h), mas não conhece o trânsito, as condições da estrada e os imprevistos. Agora imagine estimar em "tamanho de viagem" comparando com viagens que já fez: "essa viagem é como ir à praia (5 pontos), não como ir à esquina (1 ponto)". A estimativa relativa é mais natural e estável porque não depende de prever condições específicas.

**Exemplo prático:**
O time estima três histórias usando Planning Poker:

- **"Criar botão de login"** — Todos votam entre 2 e 3. Convergem em **3 pontos**.
- **"Integrar pagamento com Stripe"** — Votos: 5, 8, 13, 8. O que votou 5 diz "só é uma API". O que votou 13 diz "precisa tratar webhooks, erros, reembolsos". Após discussão, convergem em **8 pontos**.
- **"Refatorar módulo de autenticação"** — Votos: 8, 13, 21. Todos concordam que é complexo e incerto. Convergem em **13 pontos**.

**Como o candidato deve responder:**
- Definir story points como medida relativa de esforço/complexidade/incerteza
- Explicar o processo do Planning Poker passo a passo
- Mencionar a sequência Fibonacci e por que é usada
- Explicar pelo menos 3 razões para usar points em vez de horas
- Mencionar que a votação é individual e simultânea para evitar viés
- Evitar dizer que story points são "horas disfarçadas"

**Resposta fraca ou incompleta:**
"Story points são números que damos para as histórias. Planning Poker é quando o time vota com cartões. Usamos points porque é mais fácil que horas." — Muito superficial: não explica o que os points medem (esforço + complexidade + incerteza), não explica por que a votação é simultânea (evitar viés), e "mais fácil que horas" não é uma justificativa técnica adequada.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que points são "tamanho das histórias", mas não explica
- **2** — Explica points e Planning Poker, mas não justifica por que não usar horas
- **3** — Explica os três conceitos com clareza
- **4** — Explica com profundidade, menciona Fibonacci, viés de ancoragem e velocity estável
- **5** — Demonstra domínio, explica a psicologia por trás do Planning Poker, a diferença entre estimar esforço vs tempo, e como os pontos se relacionam com velocity

**Perguntas de aprofundamento:**
1. O que fazer quando o time não consegue convergir em uma estimativa após várias rodadas de Planning Poker?
2. Story points funcionam quando o time tem pessoas com níveis muito diferentes de senioridade?
3. Como estimar um item que depende de um componente externo que o time não controla?

---

### Pergunta 17 — Cenário: Mudança de prioridade durante a Sprint

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Você está no meio de uma Sprint de 2 semanas e o Product Owner chega ao time dizendo que o cliente mudou de ideia e uma nova feature é urgente. O que deve acontecer? O time deve simplesmente pegar a nova feature e abandonar o que estava fazendo?

**O que essa pergunta avalia:**
Avalia a compreensão de como lidar com mudanças durante a Sprint, o equilíbrio entre flexibilidade e compromisso, e o papel de cada envolvido na decisão.

**Resposta esperada:**
No Scrum, a Sprint deve ser um período de **foco** — o Sprint Backlog é estável durante a Sprint para permitir que o time trabalhe sem interrupções constantes. No entanto, isso não significa que mudanças são impossíveis.

O que deve acontecer:

1. **O PO não pode forçar a mudança sozinho:** Adicionar itens ao Sprint Backlog durante a Sprint é uma decisão do time — especificamente dos Developers, pois eles são donos do Sprint Backlog.

2. **Negociação entre PO e time:** O PO explica a urgência e o valor da nova feature. O time avalia o impacto:
   - Podemos adicionar sem comprometer a Sprint Goal atual?
   - Precisamos trocar itens (remover X para colocar Y)?
   - A nova feature é realmente urgente ou pode esperar a próxima Sprint?

3. **Proteger a Sprint Goal:** Se a nova feature não afeta a Sprint Goal, pode ser adicionada se houver capacity. Se afeta, o time e o PO devem decidir se a Sprint Goal precisa mudar — o que, em última instância, pode levar ao cancelamento da Sprint (decisão do PO).

4. **Cancelar a Sprint (último recurso):** Se a mudança torna a Sprint Goal atual irrelevante, o PO pode cancelar a Sprint. Um novo Sprint Planning é feito com a nova prioridade. Isso é extremo e raro.

5. **Alternativas:** Se a feature pode esperar, o PO a adiciona ao topo do Product Backlog e ela entra na próxima Sprint Planning.

**Explicação didática:**
Imagine que você está cozinhando um jantar (Sprint). No meio do preparo, o convidado liga e diz que quer trocar o prato principal. Você não simplesmente joga fora o que está cozinhando e começa algo novo — você avalia: "dá para terminar o prato atual e fazer o novo também? O prato atual já está quase pronto? Ou o pedido novo é tão urgente que preciso parar tudo?" A decisão é compartilhada: quem cozinha (Developers) decide o que consegue fazer, quem pediu (PO) decide o valor.

**Exemplo prático:**
Sprint atual tem a meta "Implementar busca de produtos". No dia 6, o PO diz que o cliente quer "checkout com PIX" urgentemente. O time avalia: a busca está 70% pronta. Se pararem agora, perdem o progresso. Opções:
- **Opção A:** Terminar a busca (mais 2 dias) e, se sobrar tempo, começar o checkout.
- **Opção B:** Trocar a meta da Sprint para "Checkout com PIX" e adiar a busca.
- **Opção C:** Adicionar o checkout ao Sprint Backlog se o time tiver capacity adicional.

O time e o PO discutem e escolhem a Opção B, já que o checkout é mais urgente para o negócio. O PO ajusta a Sprint Goal e o time replaneja o trabalho.

**Como o candidato deve responder:**
- Explicar que o Sprint Backlog é estável, mas não imutável
- Mencionar que a decisão é compartilhada (PO + Developers)
- Apresentar as opções (adicionar, trocar, cancelar Sprint, esperar próxima)
- Explicar o cancelamento de Sprint como último recurso
- Proteger a Sprint Goal como elemento central
- Evitar dizer que o PO "pode simplesmente adicionar" a feature

**Resposta fraca ou incompleta:**
"O time deve pegar a nova feature imediatamente porque o cliente é a prioridade." — Incorreto: o time não deve simplesmente abandonar o trabalho. Mudanças durante a Sprint devem ser negociadas, não impostas. Ignorar a Sprint Goal e o trabalho em andamento gera caos e reduz previsibilidade.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que há um conflito, mas não propõe solução
- **2** — Propõe uma solução, mas ignora o processo correto
- **3** — Explica as opções corretas e o processo de negociação
- **4** — Apresenta todas as opções, menciona cancelamento de Sprint e proteção da Sprint Goal
- **5** — Demonstra domínio, explica as nuances, o papel de cada um e como proteger a previsibilidade sem ser rígido

**Perguntas de aprofundamento:**
1. O que é o "cancelamento de Sprint" e em que situações reais ele faz sentido?
2. Como evitar que esse tipo de mudança de prioridade se torne recorrente?
3. Se isso acontece toda Sprint, o problema é do Scrum, do PO ou do processo de planejamento?

---

### Pergunta 18 — Lead Time vs Cycle Time

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
No contexto do Kanban, o que são Lead Time e Cycle Time? Qual é a diferença entre eles e por que cada um é útil?

**O que essa pergunta avalia:**
Avalia o conhecimento de duas métricas fundamentais do Kanban e a capacidade de diferenciá-las e explicar seu valor para o time.

**Resposta esperada:**
- **Lead Time:** É o tempo total desde o momento em que um item é **solicitado** (entra no Backlog ou quadro) até o momento em que é **entregue** (chega em Done). Mede a experiência do cliente — quanto tempo ele espera desde que pediu até receber.

- **Cycle Time:** É o tempo desde o momento em que o item **começa a ser trabalhado** (sai de "To Do" e entra em "In Progress") até o momento em que é **entregue** (chega em Done). Mede a eficiência do time — quanto tempo o time leva para processar um item.

**Diferença:** O Lead Time inclui o tempo que o item fica esperando na fila (To Do) antes de alguém começar a trabalhar nele. O Cycle Time só conta o tempo de trabalho ativo.

```
[Pedido] ────── Lead Time ──────────────► [Entrega]
             │                            │
     [espera]  ──── Cycle Time ────────►  │
     (To Do)   (In Progress → Done)
```

**Por que cada um é útil:**
- **Lead Time** é importante para o cliente e o PO: "Quanto tempo o cliente espera para receber a feature?" Ajuda a gerenciar expectativas.
- **Cycle Time** é importante para o time: "Quanto tempo levamos para processar um item?" Ajuda a identificar gargalos e ineficiências no fluxo de trabalho.

Se o Lead Time é muito maior que o Cycle Time, significa que os itens ficam muito tempo parados na fila antes de serem iniciados — um sinal de que o time não está puxando itens com frequência suficiente ou que há muitos itens acumulados.

**Explicação didática:**
Imagine que você pede uma pizza. O **Lead Time** é do momento em que você faz o pedido até a pizza chegar à sua mesa. O **Cycle Time** é do momento em que o pizzaiolo começa a preparar a pizza até ela ficar pronta. Se a pizza fica 20 minutos na fila antes de alguém começar a prepará-la, seu Lead Time será alto mesmo que o Cycle Time (preparo) seja curto. O cliente sente o Lead Time; a cozinha otimiza o Cycle Time.

**Exemplo prático:**
Um ticket de bug entra no quadro Kanban em 01/03. Fica em "To Do" até 04/03, quando um developer começa a trabalhar nele. Em 06/03, o bug está corrigido e movido para "Done".
- **Lead Time:** 5 dias (de 01/03 a 06/03)
- **Cycle Time:** 2 dias (de 04/03 a 06/03)

O time percebe que o Lead Time é 2,5x maior que o Cycle Time — itens estão esperando muito na fila. Solução: reduzir o WIP limit de "In Progress" para forçar o time a puxar itens da fila mais rapidamente.

**Como o candidato deve responder:**
- Definir Lead Time e Cycle Time com precisão
- Explicar claramente a diferença (Lead inclui fila, Cycle não)
- Explicar a utilidade de cada um (Lead para cliente, Cycle para time)
- Mencionar a relação entre os dois (Lead > Cycle indica fila longa)
- Evitar confundir os dois conceitos

**Resposta fraca ou incompleta:**
"Lead time é quanto tempo demora para fazer e cycle time é parecido, só que diferente." — Não explica o que cada um mede nem a diferença. "Parecido, só que diferente" não é uma explicação técnica.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que são "tempos de execução", mas não os diferencia
- **2** — Define um dos dois, mas confunde o outro
- **3** — Define e diferencia os dois corretamente
- **4** — Explica com clareza, menciona utilidade de cada um e a relação entre eles
- **5** — Demonstra domínio, explica a relação com WIP limit, fila e otimização de fluxo

**Perguntas de aprofundamento:**
1. Como reduzir o Lead Time sem reduzir o Cycle Time?
2. O que é Throughput e como ele se diferencia de Lead Time e Cycle Time?
3. Em um time Scrum, faz sentido medir Lead Time e Cycle Time?

---

### Pergunta 19 — Cenário: Time com muitos impedimentos

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Você é Scrum Master de um time que, nas últimas 3 Sprints, tem acumulado cada vez mais impedimentos: ambiente de teste quebrado, dependência de outro time que não responde, requisitos ambíguos do PO. Como você priorizaria e abordaria esses impedimentos?

**O que essa pergunta avalia:**
Avalia a capacidade de atuar como Scrum Master na remoção de impedimentos, priorizar problemas e diferenciar o que é responsabilidade do SM, do time e da organização.

**Resposta esperada:**
Como Scrum Master, a remoção de impedimentos é uma das principais responsabilidades, mas não significa resolver tudo sozinho. A abordagem deve ser:

1. **Visualizar e catalogar:** Manter um quadro de impedimentos visível, com data, impacto e responsável. Sem visibilidade, é fácil esquecer ou ignorar problemas.

2. **Priorizar por impacto:**
   - **Ambiente de teste quebrado:** Alto impacto, bloqueia todo o time. Prioridade máxima.
   - **Dependência de outro time:** Alto impacto, mas resolução depende de negociação externa. Iniciar conversa imediatamente.
   - **Requisitos ambíguos do PO:** Médio impacto, resolúvel internamente com refinement.

3. **Abordar cada um:**
   - **Ambiente quebrado:** Trabalhar com DevOps/infra para resolver. Se está fora do controle do time, escalar para a organização. Paralelamente, o time pode usar um ambiente alternativo temporário.
   - **Dependência de outro time:** Agendar uma conversa com o SM do outro time. Propor um acordo de SLA ou definição de pontos de contato. Escalar se necessário.
   - **Requisitos ambíguos:** Conversar com o PO e propor sessões de refinamento mais estruturadas. Sugerir uma "Definition of Ready" para evitar que itens ambíguos cheguem ao Sprint Planning.

4. **Prevenir recorrência:** Levar os impedimentos para a Sprint Retrospective e discutir causas raiz. "Por que o ambiente quebra toda Sprint?" → talvez falte automação. "Por que dependemos de outro time que não responde?" → talvez falte um acordo formal entre times.

5. **Diferenciar impedimentos de problemas do time:** Nem tudo é impedimento para o SM resolver. Se o time não está codando bem, é um problema de competência, não de impedimento. O SM pode ajudar a identificar treinamento, mas o time precisa assumir a melhoria.

**Explicação didática:**
Imagine que você é o mecânico de um carro de corrida. O piloto (time) está na pista e relata três problemas: pneu furado (ambiente quebrado), outro carro bloqueando a pista (dependência externa) e o volante está solto (requisitos ambíguos). Você não resolve todos ao mesmo tempo. Primeiro, troca o pneu (bloqueia tudo). Depois, fala com a organização da corrida sobre o carro na pista (escalação). Por último, aperta o volante quando o piloto fizer o próximo pit stop (refinamento).

**Exemplo prático:**
Quadro de impedimentos:

| Impedimento | Impacto | Prioridade | Ação | Prazo |
|---|---|---|---|---|
| Ambiente de teste quebrado | Bloqueia testes de toda a equipe | Alta | Abrir ticket com DevOps + escalonar ao gerente técnico | Hoje |
| Time X não responde sobre API | Bloqueia feature de integração | Alta | Conversar com SM do Time X, escalar se necessário | 2 dias |
| Requisitos do PO ambíguos | Causa retrabalho | Média | Propor sessão de refinement com DoR | Próxima Sprint |

**Como o candidato deve responder:**
- Mencionar a importância de visualizar e catalogar impedimentos
- Priorizar por impacto, não por ordem de chegada
- Abordar cada impedimento com estratégia diferente
- Diferenciar o que é do SM, do time e da organização
- Mencionar a Retrospective como espaço para prevenir recorrência
- Evitar dizer que o SM "resolve tudo sozinho"

**Resposta fraca ou incompleta:**
"Eu resolveria todos os impedimentos o mais rápido possível, começando pelo que apareceu primeiro." — Abordagem não-prioritária: a ordem de chegada não é o melhor critério. Resoluir "o mais rápido possível" sem estratégia não é realista. Não diferencia responsabilidades nem previne recorrência.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica os problemas, mas não propõe plano de ação
- **2** — Propõe ações, mas sem priorização ou diferenciação
- **3** — Prioriza corretamente e propõe ações específicas para cada impedimento
- **4** — Demonstra bom planejamento, menciona escalarão, Retrospective e prevenção
- **5** — Demonstra domínio, diferencia impedimentos de problemas de competência, menciona causas raiz e propõe melhorias sistêmicas

**Perguntas de aprofundamento:**
1. Qual é a diferença entre um impedimento e um problema que o time deve resolver sozinho?
2. Como o Scrum Master deve lidar com um impedimento que está fora do controle da organização?
3. Quando o Scrum Master deve escalar um impedimento e para quem?

---

### Pergunta 20 — Os 5 valores do Scrum

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O Guia Scrum define cinco valores que sustentam o funcionamento do Scrum. Quais são eles e como cada valor se manifesta no dia a dia de um time?

**O que essa pergunta avalia:**
Avalia o conhecimento dos cinco valores do Scrum e a capacidade de conectá-los a comportamentos e práticas reais, não apenas memorizá-los.

**Resposta esperada:**
Os cinco valores do Scrum são:

1. **Comprometimento (Commitment):** O time se compromete com a Sprint Goal e com a entrega do Incremento. Não é um compromisso com uma lista de tarefas, mas com um objetivo. Na prática: o time faz o possível para alcançar a Sprint Goal, mesmo que precise adaptar o plano.

2. **Foco (Focus):** O time foca no trabalho da Sprint e na Sprint Goal. Não se distrai com trabalho de outras Sprints ou prioridades paralelas. Na prática: o time não pega itens que não estão no Sprint Backlog, e o SM protege o time de interrupções externas.

3. **Abertura (Openness):** O time está aberto a mudanças, feedback e novas ideias. O trabalho deve ser transparente. Na prática: o time mostra o que está fazendo na Sprint Review sem esconder problemas, e o PO está aberto a mudar o Backlog com base em feedback.

4. **Respeito (Respect):** O time se respeita como pessoas e profissionais. Cada um confia na capacidade dos outros. Na prática: os Developers respeitam a decisão do PO sobre prioridade; o PO respeita a decisão do time sobre quanto trabalho pegar; o SM respeita a auto-organização do time.

5. **Coragem (Courage):** O time tem coragem de fazer a coisa certa e de lidar com problemas difíceis. Na prática: o time tem coragem de dizer "não" ao PO quando ele quer adicionar mais trabalho; o PO tem coragem de mudar prioridades mesmo que isso desagrade stakeholders; o SM tem coragem de escalar impedimentos que a organização precisa resolver.

**Explicação didática:**
Pense nos valores como o "combustível" que faz o Scrum funcionar. Sem comprometimento, ninguém busca a Sprint Goal. Sem foco, o time se distrai. Sem abertura, problemas ficam escondidos. Sem respeito, a colaboração se quebra. Sem coragem, o time aceita trabalho irreal só para agradar. Os três pilares (transparência, inspeção, adaptação) só funcionam quando os cinco valores estão presentes.

**Exemplo prático:**
- **Comprometimento:** O time percebe que a Sprint Goal não será alcançada e, em vez de desistir, reorganiza o plano para entregar o máximo de valor possível.
- **Foco:** Um stakeholder pede ao time para "dar uma olhada rápida" em um bug de outro projeto. O SM diz "isso não está na Sprint Goal" e protege o time.
- **Abertura:** Na Retrospective, um developer admite "não testei bem essa parte" sem medo de ser julgado.
- **Respeito:** O PO quer 8 histórias, o time diz que consegue 5. O PO respeita a decisão e escolhe as 5 mais valiosas.
- **Coragem:** O SM diz ao diretor que o time não consegue entregar a feature no prazo sem comprometer a qualidade.

**Como o candidato deve responder:**
- Listar os cinco valores corretamente
- Explicar cada um com palavras próprias
- Dar pelo menos um exemplo prático de cada
- Mostrar como os valores se conectam aos pilares e eventos
- Evitar apenas listar os nomes sem explicar

**Resposta fraca ou incompleta:**
"Os valores são comprometimento, foco, abertura, respeito e coragem. São importantes porque ajudam o time a funcionar bem." — Cita os nomes, mas não explica nenhum. "Ajudam o time a funcionar bem" é genérico e não demonstra compreensão real.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Cita 1-2 valores, mas sem explicar
- **2** — Cita os cinco valores, mas não os explica nem exemplifica
- **3** — Lista e explica os cinco valores com exemplos básicos
- **4** — Explica os cinco valores com clareza e conecta a práticas do dia a dia
- **5** — Demonstra domínio, conecta os valores aos pilares e eventos e explica o que acontece quando um valor está ausente

**Perguntas de aprofundamento:**
1. O que acontece quando um time tem comprometimento mas não tem coragem?
2. Como o Scrum Master pode cultivar esses valores em um time novo?
3. Os valores do Scrum entram em conflito entre si? Dê um exemplo.

---

### Pergunta 21 — Cenário: Sprint Review sem incremento pronto

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Chegou o final da Sprint e nenhum item do Sprint Backlog atingiu a Definition of Done. Como você conduziria a Sprint Review nesse cenário? O que deve ser discutido com os stakeholders?

**O que essa pergunta avalia:**
Avalia a compreensão do propósito da Sprint Review quando não há Incremento pronto, a honestidade com stakeholders e a postura do time diante de uma situação difícil.

**Resposta esperada:**
A Sprint Review deve acontecer mesmo sem Incremento pronto — ela não é cancelada. O propósito da Review é inspecionar o resultado da Sprint e adaptar o Product Backlog, não apenas "fazer demo".

Como conduzir:

1. **Transparência acima de tudo:** Comunicar aos stakeholders que nenhum item atingiu a DoD. Não fingir que algo está pronto. Não fazer demo de código que não atende à DoD.

2. **Mostrar o progresso:** Mesmo sem Incremento "pronto", o time pode mostrar:
   - O que foi feito até agora (mesmo incompleto)
   - Onde o time chegou e o que falta
   - Aprendizados obtidos durante a Sprint

3. **Discutir as causas:** Conversar com os stakeholders sobre por que nada foi concluído:
   - Estimativas otimistas no Planning?
   - Impedimentos não resolvidos?
   - Escopo mal definido?
   - Dependencies externas?

4. **Adaptar o Backlog:** Com base no que foi aprendido, o PO pode repriorizar o Backlog. Talvez os itens precisem ser decompostos em histórias menores. Talvez algumas features percam prioridade.

5. **Retrospective será crucial:** A Retrospective dessa Sprint deve focar nas causas raiz de não ter entregado nada e definir ações concretas para evitar repetição.

**Explicação didática:**
Imagine que você prometeu cozinhar um jantar para amigos e, na hora, o prato não ficou pronto. Você não convida os amigos, serve o prato cru e finge que está pronto. Você diz a verdade: "o prato não ficou pronto, tive problemas com o forno. Vejam o que eu já fiz e vamos decidir o que fazer." Os amigos podem sugerir "vamos pedir pizza" (adaptar o plano). A honestidade é mais valiosa que uma ilusão.

**Exemplo prático:**
Na Sprint Review:
- **SM/PO abre:** "Esta Sprint não tivemos nenhum item que atingiu a DoD. Queremos ser transparentes sobre isso."
- **Developers mostram:** "Implementamos 80% da feature de busca, mas os testes de integração não passaram e não houve code review."
- **Discussão:** Stakeholders perguntam "o que impediu?". Time responde: "Tivemos um problema com o ambiente de CI que atrasou 3 dias."
- **PO adapta:** "Vou repriorizar o Backlog. O ambiente de CI precisa ser resolvido primeiro. Vou criar um item para isso."

**Como o candidato deve responder:**
- Confirmar que a Sprint Review acontece mesmo sem Incremento
- Priorizar transparência absoluta com stakeholders
- Mostrar o progresso mesmo que incompleto
- Discutir causas e adaptar o Backlog
- Conectar com a Retrospective para prevenir repetição
- Evitar sugerir "fazer demo mesmo assim" ou "cancelar a Review"

**Resposta fraca ou incompleta:**
"Eu cancelaria a Sprint Review porque não tem nada para mostrar e marcaríamos para a próxima Sprint." — Incorreto: a Sprint Review não é apenas para "mostrar". É para inspecionar e adaptar. Cancelar a Review evita a conversa com stakeholders, esconde o problema e perde a oportunidade de adaptar o Backlog com base no feedback.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é ruim, mas não propõe como conduzir
- **2** — Propõe fazer a Review, mas sugere "mostrar o que tem" sem transparência total
- **3** — Explica que a Review acontece com transparência, mostra progresso e discute causas
- **4** — Demonstração completa: transparência, progresso, causas, adaptação do Backlog, Retrospective
- **5** — Domínio: explica o propósito real da Review, como usar o momento para aprender e ajustar, e como transformar o "fracasso" em melhoria

**Perguntas de aprofundamento:**
1. Se isso acontece com frequência (várias Sprints sem Incremento), o que isso indica sobre o time ou a organização?
2. Os stakeholders devem ter acesso ao Sprint Backlog durante a Sprint para acompanhar o progresso?
3. Como evitar que a pressão de "ter algo para mostrar" leve o time a relaxar a DoD?

---

### Pergunta 22 — Product Goal

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é o Product Goal no Scrum e qual é a sua relação com o Product Backlog e as Sprint Goals? Dê um exemplo prático.

**O que essa pergunta avalia:**
Avalia o conhecimento do conceito de Product Goal (introduzido no Guia Scrum 2020), sua relação hierárquica com o Backlog e as metas de Sprint.

**Resposta esperada:**
O **Product Goal** é o objetivo de longo prazo do produto — a meta futura que o Scrum Team trabalha para alcançar. Ele dá direção e propósito ao Product Backlog.

Relação hierárquica:
- **Product Goal:** Visão de longo prazo do produto. Define o "norte" que guia todas as Sprints.
- **Product Backlog:** Todos os itens necessários para alcançar o Product Goal. Cada item contribui de alguma forma para a meta.
- **Sprint Goal:** O objetivo de uma Sprint específica, que é um passo em direção ao Product Goal.

O Product Goal é definido e mantido pelo **Product Owner**. O time trabalha em um Product Goal por vez. Cada Sprint deve gerar um Incremento que seja um passo em direção ao Product Goal. Quando o Product Goal é alcançado, o PO define o próximo.

**Exemplo prático:**
- **Product Goal:** "Transformar o aplicativo na plataforma de e-commerce mais rápida da América Latina."
- **Product Backlog:** Contém itens como "otimizar tempo de carregamento da home", "implementar cache de produtos", "reduzir tamanho de imagens", "criar busca instantânea".
- **Sprint Goal (Sprint 7):** "Reduzir o tempo de carregamento da home de 5s para 2s."
- **Sprint Backlog:** "Implementar cache de produtos", "Otimizar imagens com lazy loading", "Configurar CDN".

Cada Sprint Goal é um passo em direção ao Product Goal. O Product Backlog é ordenado para que os itens mais relevantes para o Product Goal estejam no topo.

**Explicação didática:**
Pense no Product Goal como o destino de uma viagem de carro (ex: "chegar a Florianópolis"). O Product Backlog é o mapa com todas as possíveis rotas e paradas. A Sprint Goal é "hoje, chegar a Curitiba" — um trecho da viagem. Cada Sprint é um dia de viagem em direção ao destino final. Quando você chega a Florianópolis (Product Goal alcançado), escolhe um novo destino.

**Como o candidato deve responder:**
- Definir o Product Goal como meta de longo prazo
- Explicar a relação hierárquica (Product Goal → Sprint Goal → itens)
- Mencionar que o PO é responsável
- Dar um exemplo prático que mostra a conexão entre os três níveis
- Explicar que se trabalha um Product Goal por vez
- Evitar confundir Product Goal com Sprint Goal

**Resposta fraca ou incompleta:**
"Product Goal é a meta do produto, tipo uma visão. A Sprint Goal é a meta da Sprint." — Cita os conceitos, mas não explica a relação hierárquica, não dá exemplo e não explica como o Product Backlog se conecta ao Product Goal. "Tipo uma visão" é vago.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que existe "uma meta do produto", mas não explica
- **2** — Define o Product Goal, mas confunde com Sprint Goal
- **3** — Define corretamente e explica a relação com Sprint Goal
- **4** — Explica a hierarquia completa (Product Goal → Backlog → Sprint Goal) com exemplo
- **5** — Domínio: explica a hierarquia, o papel do PO, a evolução do Product Goal e como cada Sprint contribui

**Perguntas de aprofundamento:**
1. Um produto pode ter mais de um Product Goal ao mesmo tempo?
2. Como o Product Goal se relaciona com a visão de produto (Product Vision)?
3. O que acontece quando o time não entende o Product Goal?

---

### Pergunta 23 — Critérios de Aceitação

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
O que são critérios de aceitação em uma história de usuário? Qual é a diferença entre critérios de aceitação e a Definition of Done? Dê um exemplo.

**O que essa pergunta avalia:**
Avalia o entendimento dos critérios de aceitação como parte de uma história de usuário e a capacidade de diferenciá-los da DoD — uma confusão muito comum.

**Resposta esperada:**
Os **critérios de aceitação** são as condições específicas que uma história de usuário deve satisfazer para ser considerada "aceita" do ponto de vista do negócio. São definidos **por história** e respondem à pergunta: "O que esta história precisa fazer para atender à necessidade do usuário?"

A **Definition of Done** é um acordo do time sobre o que significa "pronto" para **qualquer** item — independente de qual seja. É genérico e se aplica a todas as histórias.

**Diferença:**

| Aspecto | Critérios de Aceitação | Definition of Done |
|---|---|---|
| Escopo | Específico de cada história | Genérico, aplica-se a todas |
| Definido por | PO (com o time) | Developers |
| Foco | Comportamento e valor esperados | Qualidade técnica e processo |
| Quando se aplica | Ao finalizar a história | Para todo item "pronto" |
| Exemplo | "Login com Google funciona e redireciona para o dashboard" | "Código revisado, testes passando, documentado" |

**Exemplo prático:**
História: "Como usuário, quero fazer login com minha conta do Google para acessar o sistema sem criar uma nova senha."

**Critérios de aceitação:**
1. Botão "Entrar com Google" aparece na tela de login
2. Ao clicar, abre o popup de autenticação do Google
3. Após autenticar, o usuário é redirecionado para o dashboard
4. Se o usuário não tem conta, uma nova é criada automaticamente
5. Se a autenticação falha, uma mensagem de erro é exibida

**Definition of Done (aplica-se a esta e a todas as histórias):**
1. Código revisado por um par
2. Testes automatizados escritos e passando
3. Sem bugs críticos conhecidos
4. Documentação atualizada
5. Deploy em homologação

Uma história pode atender a todos os critérios de aceitação (funciona como esperado) mas **não** estar "pronta" se não atende à DoD (ex: não teve code review). E vice-versa: pode ter code review e testes (DoD) mas não funcionar corretamente (critérios de aceitação).

**Explicação didática:**
Imagine que você pediu um bolo de chocolate. Os **critérios de aceitação** são: "tem que ser de chocolate, com cobertura, e servir 10 pessoas." A **Definition of Done** é: "todo bolo da confeitaria deve ser assado a 180°C, usar ingredientes frescos, e ser inspecionado antes de sair." Os critérios de aceitação são específicos do seu bolo; a DoD é o padrão de qualidade que se aplica a todos os bolos da confeitaria.

**Como o candidato deve responder:**
- Definir critérios de aceitação como condições específicas por história
- Explicar que a DoD é genérica e se aplica a todas as histórias
- Dar um exemplo que mostra claramente a diferença
- Explicar quem define cada um (PO para aceitação, Developers para DoD)
- Mencionar que uma história precisa atender a ambos
- Evitar confundir os dois conceitos

**Resposta fraca ou incompleta:**
"Os critérios de aceitação são a mesma coisa que a DoD, só que por história." — Incorreto: não são a mesma coisa. Os critérios de aceitação focam no comportamento e valor esperados (negócio), enquanto a DoD foca em qualidade técnica e processo. Embora relacionados, têm propósitos, escopo e responsáveis diferentes.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que existem critérios de aceitação, mas não os diferencia da DoD
- **2** — Diferencia superficialmente, mas sem exemplo claro
- **3** — Define e diferencia corretamente com exemplo
- **4** — Explica com clareza, menciona quem define cada um e dá exemplo prático
- **5** — Domínio: explica ambos, sua relação (uma história precisa dos dois), e como podem entrar em conflito

**Perguntas de aprofundamento:**
1. Os critérios de aceitação podem mudar durante a Sprint? Quem decide?
2. Como garantir que os critérios de aceitação são testáveis e não ambíguos?
3. O que fazer quando o time termina a história mas o PO não aceita porque "não é o que ele imaginava"?

---

### Pergunta 24 — Histórias de Usuário

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é uma história de usuário e qual é o formato padrão? Por que escrever requisitos como histórias de usuário em vez de uma lista de especificações técnicas?

**O que essa pergunta avalia:**
Avalia o entendimento do formato de histórias de usuário, sua estrutura e a justificativa para usá-las em vez de especificações tradicionais.

**Resposta esperada:**
Uma **história de usuário** é uma descrição curta e simples de uma funcionalidade do produto, escrita do ponto de vista do usuário. O formato padrão é:

**Como [tipo de usuário], quero [ação/funcionalidade] para [valor/benefício]**

Exemplo: "Como comprador, quero filtrar produtos por preço para encontrar produtos que cabem no meu orçamento."

A estrutura tem três partes (3 Cs):
1. **Card:** A descrição escrita (o "Como... quero... para...")
2. **Conversation:** As conversas entre o time e o PO para entender os detalhes
3. **Confirmation:** Os critérios de aceitação que confirmam que a história está pronta

**Por que usar histórias em vez de especificações técnicas:**
1. **Foco no valor:** A história sempre conecta a funcionalidade ao valor para o usuário, não apenas ao que tecnicamente precisa ser feito.
2. **Linguagem acessível:** Qualquer pessoa (PO, stakeholder, developer) entende. Não é preciso ser técnico para ler.
3. **Estimula conversa:** A história não é uma especificação completa — ela é um lembrete para conversar. Os detalhes emergem na conversa entre PO e time.
4. **Flexível:** Pode ser ajustada conforme o entendimento evolui, sem precisar reescrever um documento formal.
5. **Priorizável:** Como está focada em valor, o PO pode priorizar histórias pelo valor que entregam.

**Explicação didática:**
Imagine que você quer descrever um recurso para um aplicativo. Uma **especificação técnica** seria: "Implementar endpoint REST POST /api/products com parâmetros name, price, category, retornando 201 Created." Uma **história de usuário** seria: "Como vendedor, quero cadastrar produtos no sistema para que os clientes possam comprá-los." A especificação foca no *como* técnico; a história foca no *por que* e *para quem*. O *como* técnico emerge da conversa entre o time e o PO.

**Exemplo prático:**
Especificação técnica: "Endpoint GET /api/reports/sales?start_date&end_date, retorna JSON com total_sales, items_sold, avg_order_value."

História de usuário: "Como gerente de vendas, quero ver um relatório de vendas por período para entender como o negócio está performando."

A história leva a uma conversa: "O que você precisa ver no relatório? Precisa de gráficos? Exportar para Excel? Vai acessar pelo celular?" — essas perguntas revelam os detalhes que a especificação técnica não captura.

**Como o candidato deve responder:**
- Apresentar o formato "Como... quero... para..."
- Explicar os 3 Cs (Card, Conversation, Confirmation)
- Citar pelo menos 3 razões para usar histórias em vez de especificações
- Dar um exemplo prático
- Explicar que a história não substitbe a conversa, mas a estimula
- Evitar dizer que histórias são "requisitos disfarçados"

**Resposta fraca ou incompleta:**
"História de usuário é um tipo de requisito no formato 'como usuário quero X'. Serve para o PO escrever o que precisa." — Muito superficial: não menciona a parte do valor ("para..."), não explica os 3 Cs, não justifica por que usar histórias em vez de especificações, e reduz a história a "o PO escreve o que precisa", ignorando o aspecto colaborativo.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe o formato básico, mas não explica o propósito
- **2** — Explica o formato, mas não justifica o uso nem menciona os 3 Cs
- **3** — Explica o formato, os 3 Cs e pelo menos 2 razões para usar
- **4** — Explica com clareza, 3+ razões, exemplo prático e diferenciação de especificação
- **5** — Domínio: explica os 3 Cs, a conversa como elemento central, a relação com critérios de aceitação e o papel da história no refinamento

**Perguntas de aprofundamento:**
1. O que é uma "epic" e como ela se relaciona com histórias de usuário?
2. Uma história de usuário precisa sempre ter o formato "Como... quero... para..."?
3. Como decompor uma história muito grande (epic) em histórias menores?

---

### Pergunta 25 — Princípios do Lean aplicados ao Kanban

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
O Kanban tem raízes no Lean Manufacturing. Quais são os princípios do Kanban como framework e como eles se conectam com a filosofia Lean?

**O que essa pergunta avalia:**
Avalia o conhecimento dos princípios fundamentais do Kanban e sua relação com o pensamento Lean, demonstrando compreensão além do quadro visual.

**Resposta esperada:**
O Kanban como framework tem **seis práticas** (definidas por David Anderson):

1. **Visualizar o fluxo de trabalho:** Tornar o trabalho visível em um quadro, mostrando cada etapa do processo. O que não é visível não pode ser gerenciado.

2. **Limitar o WIP (Work in Progress):** Estabelecer limites máximos de itens em cada etapa. Isso cria um sistema pull e evita sobrecarga.

3. **Gerenciar o fluxo:** Monitorar e otimizar o movimento dos itens pelo fluxo. Buscar um fluxo suave e contínuo, minimizando esperas e gargalos.

4. **Tornar as políticas explícitas:** Definir e documentar as regras de como o trabalho flui (ex: critérios para mover um item de "In Progress" para "Testing"). Todos precisam entender as regras.

5. **Implementar ciclos de feedback:** Estabelecer cadências regulares para revisar o processo, como revisões de fluxo e retrospectivas.

6. **Melhorar colaborativamente, evoluir experimentalmente:** Usar dados e experimentos para melhorar o processo continuamente. Pequenos experimentos controlados (ex: ajustar WIP limit por uma semana e avaliar impacto).

**Conexão com o Lean:**
- **Eliminação de desperdício (muda):** O Kanban busca eliminar filas longas, retrabalho e multitarefa — todas formas de desperdício no Lean.
- **Pull system:** Inspirado no sistema Toyota de produção, onde o trabalho é puxado pela demanda, não empurrado pela capacidade.
- **Fluxo contínuo:** O Lean busca um fluxo suave de produção; o Kanban busca o mesmo para o conhecimento de trabalho.
- **Melhoria contínua (Kaizen):** A prática de "melhorar colaborativamente" é a aplicação do Kaizen no contexto de trabalho de conhecimento.

**Explicação didática:**
Imagine uma linha de montagem de carros. No Lean, a linha é ajustada para que cada carro flua sem parar, sem acumular carros em nenhuma estação. O Kanban faz o mesmo para o trabalho de software: visualiza as "estações" (colunas), limita quantos "carros" (itens) podem estar em cada estação (WIP), e busca um fluxo contínuo. Se uma estação acumula, é um sinal de gargalo que precisa ser resolvido.

**Exemplo prático:**
Um time de suporte implementa Kanban:
- **Visualizar:** Quadro com "Novo", "Em Análise", "Em Desenvolvimento", "Em Teste", "Resolvido"
- **WIP limit:** "Em Desenvolvimento" máximo 3 itens
- **Gerenciar fluxo:** Medir lead time semanalmente — se aumenta, investigar
- **Políticas explícitas:** "Item só vai para 'Em Teste' se tiver descrição do problema e solução proposta"
- **Feedback:** Reunião semanal de 30 min para revisar o fluxo
- **Melhoria:** Experimentar reduzir WIP de 3 para 2 e ver se lead time diminui

**Como o candidato deve responder:**
- Listar as seis práticas do Kanban
- Explicar pelo menos 4 delas com clareza
- Conectar pelo menos 2-3 conceitos Lean (muda, pull, kaizen, fluxo)
- Dar exemplo de aplicação prática
- Evitar reduzir Kanban a "um quadro com colunas"

**Resposta fraca ou incompleta:**
"Kanban é um quadro com colunas e cartões. Veio do Lean que é da Toyota." — Reduz o Kanban ao quadro visual (que é apenas uma das seis práticas) e menciona a origem Toyota sem explicar a conexão filosófica. Omite WIP limit, gestão de fluxo, feedback e melhoria contínua.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que Kanban tem "quadro e WIP", mas não conhece os princípios
- **2** — Cita 2-3 práticas, mas sem conectar ao Lean
- **3** — Cita 4+ práticas e menciona 1-2 conceitos Lean
- **4** — Explica as seis práticas com clareza e conecta 3+ conceitos Lean
- **5** — Domínio: explica as seis práticas, a conexão com Lean, o conceito de sistema pull e como os princípios guiam a melhoria contínua

**Perguntas de aprofundamento:**
1. O que é "muda" (desperdício) no contexto de trabalho de conhecimento? Dê 3 exemplos.
2. Como "tornar as políticas explícitas" ajuda o time a melhorar?
3. Que tipo de experimentos um time Kanban pode fazer para melhorar o fluxo?

---

### Pergunta 26 — Cenário: Time novo em Scrum

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Uma empresa decidiu adotar Scrum e formou um time de 8 desenvolvedores que nunca trabalharam com metodologias ágeis. Você foi contratado como Scrum Master. Como seria seu plano de ação nos primeiros 30 dias para ajudar o time a começar com Scrum?

**O que essa pergunta avalia:**
Avalia a capacidade de planejar a introdução do Scrum em um time inexperiente, combinando conhecimento teórico com aplicação prática e sensibilidade à transição cultural.

**Resposta esperada:**
Plano de ação para os primeiros 30 dias:

**Semana 1 — Educação e Alinhamento:**
- Treinar o time nos fundamentos do Scrum: papéis, eventos, artefatos, valores
- Explicar o *por que* do Scrum, não apenas o *como* — o time precisa entender a filosofia ágil
- Definir quem é o Product Owner e garantir que ele também seja treinado
- Criar o Product Backlog inicial com o PO — mesmo que seja alto nível
- Definir a Definition of Done inicial (mesmo que simples)

**Semana 2 — Primeiro Sprint Planning:**
- Facilitar o primeiro Sprint Planning, guiando o time no processo
- Ajudar o PO a definir a primeira Sprint Goal
- Ensinar o time a estimar com Planning Poker (usar um item de referência)
- Definir a duração da Sprint (sugerir 2 semanas para começar)
- Criar o primeiro Sprint Backlog

**Semana 3 — Primeiro Sprint em andamento:**
- Facilitar as Daily Scrums, modelando o comportamento correto
- Estar disponível para remover impedimentos e responder dúvidas
- Observar como o time se auto-organiza (ou não) e intervir com orientação
- Documentar os impedimentos que surgem

**Semana 4 — Primeira Review e Retrospective:**
- Facilitar a Sprint Review — convidar stakeholders, mostrar o que foi feito
- Facilitar a primeira Sprint Retrospective — focar em 1-2 melhorias simples
- Coletar feedback do time sobre o que achou do Scrum
- Ajustar o processo com base na Retrospective

**Princípios orientadores:**
- **Não forçar:** O time vai cometer erros e isso é esperado. O SM guia, não impõe.
- **Simplificar:** Começar com uma DoD simples, Backlog enxuto, Sprint Goal clara. Evoluir com o tempo.
- **Paciência:** A transição de waterfall/cascata para ágil é cultural, não apenas de processo. Leva meses, não semanas.
- **Modelar:** O SM deve demonstrar os valores do Scrum: respeito, abertura, coragem.

**Explicação didática:**
Imagine que você está ensinando alguém a andar de bicicleta. Você não começa explicando a física do equilíbrio — você coloca a pessoa na bicicleta, segura o selim e deixa ela pedalar. Ela vai cair, e isso é parte do aprendizado. Aos poucos, você solta. Com Scrum é igual: o time precisa *praticar* Scrum para aprender Scrum, não apenas ouvir teoria.

**Exemplo prático:**
Dia 1: Workshop de 4 horas sobre Scrum (papéis, eventos, valores).
Dia 2-3: Sessão de criação do Product Backlog com o PO.
Dia 4: Sprint Planning — o time estima 5 histórias usando Planning Poker.
Dias 5-14: Daily Scrums às 9h. O SM facilita e responde dúvidas.
Dia 15: Sprint Review com 3 stakeholders presentes.
Dia 15: Sprint Retrospective — o time identifica "precisamos estimar melhor" e "as dailies estão longas".

**Como o candidato deve responder:**
- Estruturar o plano em fases (educação → primeiro Sprint → ajuste)
- Mencionar treinamento, criação de artefatos, facilitação de eventos
- Incluir o PO no processo (não apenas os Developers)
- Reconhecer que a transição é cultural e leva tempo
- Mencionar a importância de começar simples e evoluir
- Evitar propor "implementar Scrum perfeito desde o dia 1"

**Resposta fraca ou incompleta:**
"Eu explicaria o Scrum e começaria a fazer as reuniões. Se errarem, eu corrijo." — Muito superficial: não detalha como introduzir cada elemento, não menciona a criação de artefatos, não aborda a transição cultural, e "corrigir" o time não é o papel do SM — o SM facilita e educa, não corrige como um professor.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Menciona "ensinar Scrum", mas sem plano estruturado
- **2** — Estrutura o plano, mas omite elementos importantes (PO, DoD, Retrospective)
- **3** — Apresenta um plano razoável com fases, artefatos e eventos
- **4** — Plano detalhado, menciona aspectos culturais, papel do PO e evolução gradual
- **5** — Domínio: plano completo, reconhece desafios culturais, menciona métricas de sucesso da transição e adaptação ao contexto da empresa

**Perguntas de aprofundamento:**
1. Como lidar com um developer que resiste à adoção do Scrum e prefere "continuar do jeito antigo"?
2. O que fazer se, no primeiro Sprint, o time não entrega nada?
3. Quanto tempo normalmente leva para um time se tornar proficiente em Scrum?

---

### Pergunta 27 — Scrum Board vs Kanban Board

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
Como um quadro Scrum difere de um quadro Kanban? Quais elementos são específicos de cada um e o que acontece com o quadro Scrum ao final de cada Sprint?

**O que essa pergunta avalia:**
Avalia a compreensão prática das diferenças entre quadros Scrum e Kanban, e o comportamento do quadro Scrum ao final de cada Sprint.

**Resposta esperada:**

**Quadro Scrum:**
- Reflete o Sprint Backlog da Sprint atual
- Colunas típicas: "To Do", "In Progress", "Done" (pode ter mais, como "Testing", "Code Review")
- **Reset ao final de cada Sprint:** Itens em "Done" são removidos (fazem parte do Incremento). Itens não "Done" voltam para o Product Backlog para reavaliação. O quadro é "limpo" e preenchido novamente no próximo Sprint Planning.
- Não há WIP limit formal (embora o time possa adotar)
- Os itens são os selecionados no Sprint Planning
- O foco é a Sprint Goal

**Quadro Kanban:**
- Reflete o fluxo contínuo de trabalho, sem Sprints
- Colunas típicas: "Backlog", "To Do", "In Progress", "Testing", "Done"
- **Sem reset:** O quadro é contínuo — não é limpo ao final de um período. Os itens fluem continuamente.
- **WIP limit em cada coluna** (ou no sistema todo) — elemento fundamental
- Itens entram e saem a qualquer momento (sistema pull)
- O foco é o fluxo e a redução do lead time

**Diferenças-chave:**

| Elemento | Quadro Scrum | Quadro Kanban |
|---|---|---|
| Período | Uma Sprint | Contínuo |
| Reset | Sim, ao final da Sprint | Não |
| WIP limit | Não obrigatório | Fundamental |
| Entrada de itens | No Sprint Planning | A qualquer momento (respeitando WIP) |
| Foco | Sprint Goal | Fluxo e lead time |
| "Done" ao final | Vira Incremento | Contínua acumulando |

**Explicação didática:**
O quadro Scrum é como um quadro de avisos da semana: no início da semana você cola as tarefas, durante a semana você as move, e no final você apaga tudo e começa de novo na semana seguinte. O quadro Kanban é como uma esteira de produção: os itens entram de um lado, fluem pelas estações e saem do outro, sem parar para "resetar".

**Exemplo prático:**
**Quadro Scrum (Sprint 5):**
```
To Do          In Progress     Testing        Done
[LOGIN-03]     [SEARCH-02]     [EXPORT-01]    [AUTH-05] ✓
[DASH-01]                                    [PAY-01]  ✓
[NOTIF-02]
```
Ao final da Sprint: AUTH-05 e PAY-01 fazem parte do Incremento. LOGIN-03, DASH-01, NOTIF-02 e SEARCH-02 (não Done) voltam para o Product Backlog. EXPORT-01, se não atingiu a DoD, também volta. O quadro é resetado.

**Quadro Kanban (contínuo):**
```
Backlog     To Do      In Progress (WIP:3)   Testing (WIP:2)   Done
[TICKET-45] [TICKET-41] [TICKET-39]          [TICKET-37]       [TICKET-35]
[TICKET-46] [TICKET-42] [TICKET-40]          [TICKET-38]       [TICKET-36]
            [TICKET-43] [TICKET-44]                            [TICKET-34]
```
Não há reset. Quando TICKET-37 vai para Done, um novo pode entrar em Testing. Quando um item sai de In Progress, um novo sai de To Do.

**Como o candidato deve responder:**
- Explicar que o quadro Scrum reflete a Sprint atual e é resetado
- Explicar que o quadro Kanban é contínuo e tem WIP limit
- Mencionar o que acontece com os itens não "Done" no Scrum (voltam para o Backlog)
- Citar pelo menos 4-5 diferenças entre os quadros
- Evitar dizer que "são a mesma coisa com nomes diferentes"

**Resposta fraca ou incompleta:**
"O quadro Scrum tem colunas e o Kanban também. A diferença é que o Kanban tem WIP limit." — Muito superficial: não menciona o reset do quadro Scrum, não explica o comportamento contínuo do Kanban, e reduz a diferença a apenas o WIP limit. Há muitas outras diferenças (reset, entrada de itens, período, foco).

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que "são parecidos", mas não diferencia
- **2** — Cita 2-3 diferenças, mas não explica o reset do Scrum
- **3** — Explica reset, WIP limit e continuidade do Kanban
- **4** — Explica 5+ diferenças com clareza e exemplos de quadros
- **5** — Domínio: explica todas as diferenças, o que acontece com itens não prontos, e como os quadros refletem a filosofia de cada framework

**Perguntas de aprofundamento:**
1. É possível ter um quadro Scrum com WIP limit? Faz sentido?
2. O que fazer com os itens que estão "In Progress" no quadro Scrum quando a Sprint acaba e eles não estão prontos?
3. Em um quadro Kanban, como decidir qual item do Backlog puxar para "To Do" quando há capacity?

---

### Pergunta 28 — Conceito de Débito Técnico

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
O que é débito técnico (technical debt)? Como ele surge em um time ágil e como o time deve gerenciá-lo ao longo do tempo?

**O que essa pergunta avalia:**
Avalia o entendimento do conceito de débito técnico, suas causas, impactos e formas de gestão dentro de um contexto ágil.

**Resposta esperada:**
O **débito técnico** é uma metáfora que compara a escolha de uma solução rápida e subótima a um empréstimo financeiro: você obtém um benefício imediato (velocidade), mas "paga juros" (manutenção mais difícil) ao longo do tempo, até "quitar a dívida" (refatorar).

**Como surge:**
1. **Intencional:** O time decide deliberadamente fazer um atalho para atender a um prazo. Ex: "vamos hardcodear essa configuração agora e refatorar depois."
2. **Involuntária:** O time não conhece a melhor solução no momento e, ao aprender mais, percebe que o código pode ser melhorado.
3. **Por pressão:** Prazos irreais forçam o time a sacrificar qualidade.
4. **Por negligência:** O time não investe em refatoração contínua, e o código degrada ao longo do tempo.
5. **Por falta de testes:** Sem testes automatizados, mudanças futuras podem introduzir bugs sem que ninguém perceba.

**Impactos:**
- Aumenta o tempo de implementação de novas features (o código fica difícil de mudar)
- Aumenta a frequência de bugs
- Reduz a morale do time (trabalhar com código ruim é desmotivador)
- Pode chegar a um ponto onde o sistema "trava" — cada mudança quebra algo

**Como gerenciar:**
1. **Tornar visível:** Adicionar itens de débito técnico ao Product Backlog, como qualquer outro item. O PO precisa ver e priorizar.
2. **Alocar tempo por Sprint:** Reservar uma porção da capacity (ex: 10-20%) para refatoração e pagamento de débito.
3. **Refatoração contínua:** Praticar a regra "boy scout" — deixar o código um pouco melhor do que você o encontrou.
4. **Definition of Done robusta:** Uma DoD com testes e code review ajuda a prevenir a criação de novo débito.
5. **Negociar com o PO:** O PO precisa entender que ignorar débito técnico hoje torna o time mais lento amanhã. É um trade-off entre velocidade agora e velocidade no futuro.

**Explicação didática:**
Imagine que você está construindo uma casa e, para terminar mais rápido, pula o acabamento de um cômodo. Você ganha tempo agora, mas toda vez que precisar usar aquele cômodo, terá que lidar com o acabamento ruim — rascunhos, fios expostos. Cada nova funcionalidade que toca aquele cômodo fica mais difícil. Eventualmente, o custo de "continuar trabalhando com o cômodo inacabado" ultrapassa o custo de "parar e fazer o acabamento". Esse é o débito técnico: o custo de não ter feito certo na primeira vez.

**Exemplo prático:**
Sprint 1: O time implementa uma feature de relatório fazendo consultas SQL diretas no código (atalho). Tempo: 3 dias.

Sprint 5: O time precisa adicionar filtros ao relatório. Como o código não foi estruturado em camadas, a mudança exige reescrever grande parte do código. Tempo: 5 dias (em vez de 2 dias se o código tivesse sido bem estruturado).

Sprint 8: O time aloca um item de débito técnico no Sprint: "Refatorar módulo de relatórios para usar repositório pattern". Tempo: 3 dias. A partir daqui, novas features no relatório ficam mais fáceis.

Débito técnico "pago": 3 dias (refatoração) vs. débito técnico "acumulado": 3 dias extras a cada nova feature no relatório.

**Como o candidato deve responder:**
- Definir débito técnico como uma metáfora de "empréstimo"
- Explicar que pode ser intencional ou involuntário
- Citar pelo menos 3 impactos do débito não gerenciado
- Propor pelo menos 3 estratégias de gestão
- Mencionar a importância de negociar com o PO
- Evitar dizer que débito técnico é sempre "ruim" (pode ser uma decisão consciente)

**Resposta fraca ou incompleta:**
"Débito técnico é quando o código está ruim. Tem que refatorar." — Muito superficial: não explica a metáfora do "empréstimo", não distingue entre débito intencional e involuntário, não menciona impactos, não propõe estratégias de gestão e não envolve o PO na decisão.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "código ruim", mas não explica
- **2** — Define o conceito, mas não menciona impactos ou gestão
- **3** — Define, cita impactos e propõe 1-2 estratégias
- **4** — Explica com clareza, distingue tipos, cita impactos e 3+ estratégias
- **5** — Domínio: explica a metáfora financeira, os tipos, os impactos, estratégias de gestão e a relação com a DoD e o PO

**Perguntas de aprofundamento:**
1. Como convencer o Product Owner a investir tempo em pagar débito técnico em vez de criar novas features?
2. Existe "bom débito técnico"? Quando faz sentido assumir débito intencionalmente?
3. Como medir o débito técnico de um sistema?

---

### Pergunta 29 — Cenário: PO ausente

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
O Product Owner do seu time está sempre ocupado com outras reuniões e não participa do refinamento, não responde perguntas sobre requisitos durante a Sprint, e não comparece à Sprint Review. Como você lidaria com essa situação como Scrum Master?

**O que essa pergunta avalia:**
Avalia a capacidade de lidar com um problema estrutural comum (PO ausente), a postura do SM na resolução de conflitos e o entendimento de que o PO ausente compromete todo o Scrum.

**Resposta esperada:**
Um PO ausente é um dos problemas mais graves para um time Scrum, pois o PO é fundamental para a eficácia do framework. Sem PO, o time não tem clareza de prioridade, não recebe feedback e não entende o valor do que está construindo.

**Ações como Scrum Master:**

1. **Conversa direta com o PO:** Agendar uma conversa 1:1 e explicar o impacto da ausência no time. Usar fatos: "Nas últimas 3 Sprints, o time esperou 4 dias em média por resposta sobre requisitos. Isso reduziu a velocity em 30%."

2. **Educar sobre o papel:** O PO pode não entender que sua presença é essencial, não opcional. Explicar que o Scrum depende de decisões rápidas e o PO é o único que pode tomá-las.

3. **Deputy PO temporário:** Se o PO realmente não tem disponibilidade, pode haver um "deputy" (representante) que o PO delega para responder a perguntas do dia a dia. Mas o PO continua sendo o responsável final e precisa estar presente em momentos-chave (Planning, Review).

4. **Escalar para a organização:** Se o PO não tem disponibilidade porque está em outros projetos, isso é um problema organizacional. O SM deve escalar para a liderança: "O time não consegue entregar valor sem um PO presente. Precisamos de um PO dedicado ou de uma reavaliação das prioridades do PO atual."

5. **Adaptar o processo temporariamente:** Enquanto se resolve:
   - Reduzir o escopo das Sprints para itens que não dependem de decisão do PO
   - Usar assincronicidade: o PO responde por escrito em horários flexíveis
   - Agendar sessões curtas de refinamento (30 min) em vez de longas

6. **Documentar o impacto:** Manter um registro de decisões pendentes, tempo de espera e features bloqueadas. Usar esses dados na conversa com o PO e com a organização.

**Explicação didática:**
Imagine um time de futebol sem técnico. Os jogadores podem até jogar, mas não sabem a estratégia, não fazem substituições no momento certo e jogam sem direção. O PO é como o técnico — não joga (não programa), mas é essencial para que o time jogue com propósito. Sem o PO, o time "chuta para gol" sem saber se é o gol certo.

**Exemplo prático:**
SM conversa com o PO: "Nos últimos 3 Sprints, tivemos 12 perguntas sobre requisitos sem resposta por mais de 2 dias. Na Sprint Review passada, você não esteve presente e o time não recebeu feedback. Isso está afetando a qualidade das entregas. Precisamos de 1 hora por dia sua para responder perguntas e participação em Planning e Review. Se isso não for possível, precisamos conversar com a liderança sobre a alocação."

Se o PO não pode: "Vou conversar com a diretoria. Enquanto isso, vou pedir que você nomeie um representante que possa responder a perguntas do dia a dia, mas você precisa estar na Planning e na Review."

**Como o candidato deve responder:**
- Reconhecer a gravidade do problema (PO ausente compromete o Scrum)
- Propor conversa direta com o PO, com dados
- Mencionar a opção de deputy PO temporário
- Escalar para a organização se o problema persistir
- Sugerir adaptações temporárias
- Evitar sugerir que o SM "assume o papel do PO"

**Resposta fraca ou incompleta:**
"Eu assumiria o papel do PO temporariamente para não parar o time." — Incorreto: o SM não deve assumir o papel de PO. Isso cria conflito de papéis e compromete a separação de responsabilidades. O SM deve resolver a causa (fazer o PO voltar ou conseguir um novo PO), não "substituir" o PO.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica o problema, mas não propõe solução
- **2** — Propõe soluções superficiais (conversar com o PO)
- **3** — Propõe múltiplas ações: conversa, deputy, escalar
- **4** — Abordagem completa com dados, escalation e adaptações
- **5** — Domínio: explica por que o SM não deve assumir o papel de PO, propõe solução estrutural e usa dados para fundamentar a conversa

**Perguntas de aprofundamento:**
1. O que acontece se o time "se acostuma" com o PO ausente e começa a tomar decisões de produto sozinho?
2. Um PO pode ser compartilhado entre dois times Scrum? Quando isso faz sentido?
3. Como medir o impacto da ausência do PO na entrega de valor?

---

### Pergunta 30 — Cadingência e Cadência no Kanban

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O Kanban não define eventos formais como o Scrum. Como um time Kanban garante que tenha momentos de inspeção e adaptação? O que são "cadências" no Kanban?

**O que essa pergunta avalia:**
Avalia o entendimento de como o Kanban, mesmo sem eventos formais, estabelece ritmos de inspeção e adaptação através de cadências.

**Resposta esperada:**
Embora o Kanban não defina eventos obrigatórios como Sprint Planning ou Sprint Review, a prática de "implementar ciclos de feedback" (uma das seis práticas) recomenda que o time estabeleça **cadências** — ritmos regulares para revisar diferentes aspectos do sistema.

**Cadências comuns no Kanban:**

1. **Replenishment Cadence (reposição):** Frequência com que novos itens são puxados do Backlog para o quadro. Pode ser diária, semanal ou por demanda. Garante que o time sempre tenha trabalho alinhado às prioridades.

2. **Delivery Planning Cadence (planejamento de entrega):** Quando o time planeja quais itens serão entregues e quando. Pode ser semanal ou quinzenal. Equivalente informal ao Sprint Planning.

3. **Service Delivery Review (revisão de entrega):** Reunião periódica (ex: mensal) para revisar métricas de entrega — lead time, throughput, qualidade. O time e os stakeholders inspecionam se o serviço está atendendo às expectativas.

4. **Risk Review (revisão de riscos):** Reunião periódica para identificar e mitigar riscos no fluxo de trabalho ou no produto.

5. **Operations Review (revisão de operações):** Reunião para revisar a eficácia operacional do time — gargalos, políticas, WIP limits.

6. **Strategy Review (revisão de estratégia):** Reunião menos frequente (trimestral) para revisar se o time está alinhado com os objetivos estratégicos da organização.

A diferença fundamental em relação ao Scrum é que as cadências Kanban são **flexíveis e adaptáveis** ao contexto do time, não prescritivas. O time define as cadências que fazem sentido para o seu tipo de trabalho.

**Explicação didática:**
No Scrum, os eventos são como um trem com horário fixo — sai da estação todo dia 1 e 15 do mês. No Kanban, as cadências são como um trem sob demanda — sai quando há passageiros suficientes, mas com um ritmo regular (ex: a cada 3 dias). O importante é que haja *regularidade* para permitir inspeção e adaptação, sem a rigidez de uma Sprint.

**Exemplo prático:**
Um time de operações de TI define as seguintes cadências:
- **Diária:** Standup de 10 min para sincronizar o dia
- **Semanal:** Replenishment — puxar 5-7 novos tickets do Backlog
- **Quinzenal:** Service Delivery Review — revisar lead time e throughput com stakeholders
- **Mensal:** Retrospective — identificar melhorias no processo
- **Trimestral:** Strategy Review — alinhar com objetivos da organização

Essas cadências dão ao time momentos estruturados de inspeção e adaptação, equivalentes em propósito aos eventos do Scrum, mas adaptados ao fluxo contínuo do Kanban.

**Como o candidato deve responder:**
- Explicar que Kanban não tem eventos obrigatórios, mas recomenda cadências
- Citar pelo menos 3-4 tipos de cadência
- Explicar a diferença entre cadências Kanban (flexíveis) e eventos Scrum (prescritivos)
- Mencionar que as cadências garantem inspeção e adaptação
- Dar exemplo de cadências em um time real
- Evitar dizer que "Kanban não tem inspeção"

**Resposta fraca ou incompleta:**
"Kanban não tem reuniões. O time só trabalha com o quadro." — Incorreto: embora o Kanban não defina eventos obrigatórios, a prática de "implementar ciclos de feedback" é uma das seis práticas fundamentais. Times Kanban eficazes têm cadências regulares para inspeção e adaptação.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que Kanban "não tem Sprint", mas não explica como substitui
- **2** — Menciona que o time pode ter reuniões, mas não conhece as cadências
- **3** — Explica o conceito de cadências e cita 3+ tipos
- **4** — Explica as cadências, diferencia de eventos Scrum e dá exemplo prático
- **5** — Domínio: explica as 6+ cadências, como elas se adaptam ao contexto e como garantem o ciclo de inspeção e adaptação

**Perguntas de aprofundamento:**
1. Como decidir a frequência ideal de cada cadência?
2. Um time pode usar cadências Kanban mesmo trabalhando com Scrum?
3. O que acontece se um time Kanban não estabelece nenhuma cadência de feedback?

---

### Pergunta 31 — Burndown e Burnup Charts

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que são Burndown Chart e Burnup Chart? Qual é a diferença entre eles e o que cada um permite visualizar durante uma Sprint?

**O que essa pergunta avalia:**
Avalia o conhecimento de duas das ferramentas visuais mais utilizadas em metodologias ágeis para acompanhar progresso, e a capacidade de diferenciar seus propósitos e aplicações.

**Resposta esperada:**

**Burndown Chart:** É um gráfico que mostra a quantidade de trabalho restante ao longo do tempo. O eixo Y representa o trabalho restante (geralmente em story points) e o eixo X representa o tempo (dias da Sprint). A linha ideal é uma descida linear do total de pontos até zero no final da Sprint. A linha real mostra o que realmente aconteceu.

**Burnup Chart:** É um gráfico que mostra a quantidade de trabalho concluído ao longo do tempo. O eixo Y representa o trabalho completado e o eixo X o tempo. Pode ter uma segunda linha representando o escopo total — se o escopo muda (itens adicionados ou removidos), a linha de escopo se move, e isso fica visível.

**Diferenças principais:**

| Característica | Burndown | Burnup |
|---|---|---|
| O que mostra | Trabalho **restante** | Trabalho **concluído** |
| Direção | Descendente (deve chegar a zero) | Ascendente (deve chegar ao total) |
| Mudanças de escopo | Difícil de perceber | Visíveis (linha de escopo se move) |
| Foco | "Quanto falta?" | "Quanto fizemos e o total mudou?" |
| Interpretação intuitiva | Menos intuitiva (linha desce = bom) | Mais intuitiva (linha sobe = bom) |

**Explicação didática:**
Imagine que você está enchendo uma piscina. O **Burndown** mostra a água que *falta* colocar — a linha desce até chegar a zero (piscina cheia). O **Burnup** mostra a água que *já está* na piscina — a linha sobe até chegar na capacidade total. Se alguém aumenta o tamanho da piscina no meio do processo, o Burndown fica confuso (parece que você perdeu progresso), mas o Burnup mostra claramente que a linha da "capacidade total" subiu — o escopo mudou.

**Exemplo prático:**
Um time inicia uma Sprint com 40 story points. No Burndown, o eixo Y começa em 40 e deve chegar a 0 no dia 10. Se no dia 5 o time já completou 20 pontos, a linha real está em 20 — na metade do caminho. Se o PO adiciona 5 pontos no dia 4, o Burndown "pula" de 22 para 27 (aumenta o restante), o que parece estranho. No Burnup, a linha de concluído continua em 18, mas a linha de escopo total vai de 40 para 45 — a mudança de escopo é visível e compreensível.

**Como o candidato deve responder:**
- Definir ambos os gráficos corretamente
- Explicar a diferença fundamental (restante vs. concluído)
- Mencionar que o Burnup mostra mudanças de escopo melhor que o Burndown
- Citar o eixo Y e X de cada um
- Dar um exemplo de leitura de cada gráfico
- Evitar confundir os dois conceitos

**Resposta fraca ou incompleta:**
"Burndown é um gráfico que mostra se o time está entregando e burnup é parecido só que ao contrário." — Não explica o que cada um mede, não menciona mudanças de escopo, não descreve eixos nem interpretação. "Ao contrário" não é uma explicação técnica adequada.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que são "gráficos de progresso", mas não os diferencia
- **2** — Diferencia superficialmente, mas sem explicar mudança de escopo
- **3** — Define e diferencia os dois com clareza
- **4** — Explica diferenças, eixos, interpretação e mudança de escopo
- **5** — Domínio: explica ambos, mudança de escopo, interpretação de desvios e quando usar cada um

**Perguntas de aprofundamento:**
1. O que significa quando a linha real do Burndown fica acima da linha ideal? E abaixo?
2. Um Burndown pode "subir"? O que isso indica?
3. Qual gráfico é mais útil para comunicar progresso a stakeholders não técnicos?

---

### Pergunta 32 — Throughput no Kanban

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é Throughput no contexto do Kanban e como ele se diferencia de Lead Time e Cycle Time? Como um time pode usar Throughput para planejamento?

**O que essa pergunta avalia:**
Avalia o conhecimento da terceira métrica fundamental do Kanban (além de Lead Time e Cycle Time) e a capacidade de diferenciar as três e explicar suas aplicações práticas.

**Resposta esperada:**
**Throughput** é o número de itens que um time completa em um período de tempo (ex: por dia, por semana). É uma métrica de **cadência** — mede *quantos* itens saem do sistema, não quanto tempo cada um leva.

**Diferença entre as três métricas:**

| Métrica | O que mede | Unidade | Pergunta que responde |
|---|---|---|---|
| Lead Time | Tempo total do pedido à entrega | Tempo (dias, horas) | "Quanto tempo o cliente espera?" |
| Cycle Time | Tempo de trabalho ativo | Tempo (dias, horas) | "Quanto tempo o time processa?" |
| Throughput | Quantidade entregue por período | Itens/unidade de tempo | "Quantos itens entregamos por semana?" |

**Como usar Throughput para planejamento:**
1. **Previsão baseada em dados históricos:** Se o time tem um throughput médio de 10 itens/semana nos últimos 3 meses, pode prever que entregará aproximadamente 10 itens na próxima semana.
2. **Monte Carlo Simulation:** Usar o histórico de throughput para prever probabilidades: "Há 85% de chance de entregar 8-12 itens na próxima semana."
3. **Capacidade de planejamento:** Se o PO quer entregar 50 itens em 5 semanas e o throughput é de 10/semana, o time pode dizer "isso é viável" ou "precisamos de 7 semanas".

**Explicação didática:**
Imagine uma fábrica de carros. O **Lead Time** é quanto tempo leva desde o pedido do cliente até o carro estar pronto (inclui fila de espera). O **Cycle Time** é quanto tempo o carro fica na linha de montagem sendo construído. O **Throughput** é quantos carros saem da fábrica por dia — se saem 10 carros/dia, o throughput é 10. Você pode ter um Cycle Time curto (montagem rápida) mas um throughput baixo (poucos carros por dia) se a fábrica for pequena.

**Exemplo prático:**
Um time de suporte mede o throughput das últimas 4 semanas:
- Semana 1: 12 tickets resolvidos
- Semana 2: 9 tickets resolvidos
- Semana 3: 14 tickets resolvidos
- Semana 4: 11 tickets resolvidos

Throughput médio: 11,5 tickets/semana. O PO quer saber se 50 tickets podem ser resolvidos em 4 semanas. Com base no histórico: 11,5 × 4 = 46 — provavelmente não. Precisaria de ~5 semanas ou aumentar capacity.

**Como o candidato deve responder:**
- Definir Throughput como itens completados por período
- Diferenciar claramente das outras duas métricas
- Explicar pelo menos uma forma de usar para planejamento
- Dar exemplo com números
- Mencionar que é uma métrica baseada em histórico
- Evitar confundir Throughput com velocity

**Resposta fraca ou incompleta:**
"Throughput é a mesma coisa que velocity, mede quantas histórias o time entrega." — Incorreto: Throughput e velocity não são a mesma coisa. Velocity usa story points (medida relativa), Throughput usa contagem de itens (medida absoluta). Além disso, Throughput é mais usado no Kanban e velocity no Scrum, embora ambos possam ser usados em qualquer framework.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "quantidade entregue", mas não diferencia das outras métricas
- **2** — Define Throughput, mas confunde com velocity
- **3** — Define e diferencia das três métricas com clareza
- **4** — Explica as três métricas, diferenças e uso para planejamento
- **5** — Domínio: explica as três, menciona Monte Carlo ou previsão probabilística e a relação entre WIP, Throughput e Lead Time (Little's Law)

**Perguntas de aprofundamento:**
1. O que é a Lei de Little e como ela conecta WIP, Throughput e Lead Time?
2. Throughput é uma métrica melhor que velocity? Em que situações?
3. Como aumentar o Throughput de um time sem sacrificar a qualidade?

---

### Pergunta 33 — Cenário: Estimativas sempre subestimadas

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Você percebe que nas últimas 5 Sprints, o time consistentemente subestima o trabalho — sempre pega mais itens do que consegue entregar. A velocity real é cerca de 60% do que o time planeja. Como você investigaria e resolveria esse problema?

**O que essa pergunta avalia:**
Avalia a capacidade de diagnóstico de um problema recorrente em times ágeis (subestimação sistemática), a análise de causas raiz e a proposição de soluções práticas.

**Resposta esperada:**

**Diagnóstico — investigar causas:**
1. **Pressão do PO ou stakeholders:** O time pode estar pegando mais itens porque sente pressão para "prometer" mais. Verificar se há cobrança por "entregar mais" ou comparação com outros times.
2. **Falta de refinamento:** Se os itens chegam ao Sprint Planning sem detalhamento, o time não consegue estimar corretamente. Verificar se há sessões de refinement regulares.
3. **Definition of Done incompleta:** Se a DoD não inclui testes, code review, documentação, o time estima apenas o "código básico" e esquece do resto.
4. **Excesso de otimismo:** O time pode estimar o "caminho feliz" — sem considerar bugs, impedimentos, dependências externas.
5. **Itens muito grandes:** Se os itens são epics não decompostos, a estimativa é imprecisa. Histórias grandes têm alta incerteza.
6. **Não considerando trabalho não-planejado:** O time não reserva capacity para bugs urgentes, suporte, reuniões imprevistas.

**Soluções:**
1. **Usar a velocity real, não a desejada:** No Sprint Planning, usar a média das últimas 3 Sprints (não a "melhor Sprint") como referência. Se a média é 20 pontos, planejar para 20, não para 35.
2. **Reservar buffer para imprevistos:** Alocar 15-20% da capacity para trabalho não-planejado (bugs, suporte, impedimentos). Planejar apenas 80-85% da capacity.
3. **Melhorar o refinamento:** Garantir que os itens estejam detalhados e decompostos antes do Planning. Introduzir ou fortalecer uma Definition of Ready.
4. **Decompor histórias grandes:** Se uma história tem mais de 8 ou 13 pontos, decompor em histórias menores antes de estimar.
5. **Educar o time sobre viés de otimismo:** Discutir na Retrospective o padrão de subestimação e o impacto. Encorajar estimar considerando "o que pode dar errado".
6. **Acompanhar e ajustar:** Medir a taxa de planejado vs. entregue por Sprint e usar esse dado no próximo Planning.

**Explicação didática:**
Imagine que você planeja uma viagem de carro estimando 4 horas, mas sempre leva 6 porque não considera trânsito, paradas e imprevistos. Se você olhar o histórico e ver que *sempre* leva 6, deve planejar 6 horas da próxima vez — não continuar estimando 4 e chegar atrasado. O time que subestima precisa olhar a realidade (velocity histórica) e planejar com base nela, não com base no que "gostaria" de entregar.

**Exemplo prático:**
Time planeja 35 pontos consistentemente, mas entrega ~20. Na Retrospective, o time identifica: "Não consideramos o tempo de testes nas estimativas" e "Sempre chegam bugs urgentes que consomem 2 dias da Sprint". Ações: (1) A partir da próxima Sprint, planejar 20 pontos + 5 de buffer = 25 pontos totais. (2) Adicionar "testes" à checklist de estimativa. (3) Reservar 20% da capacity para trabalho não-planejado.

Após 3 Sprints: planeja 25, entrega 23-26. Previsibilidade melhorou.

**Como o candidato deve responder:**
- Mencionar pelo menos 4 possíveis causas
- Propor uso da velocity real (não desejada)
- Sugerir reserva de buffer para imprevistos
- Mencionar refinamento e decomposição como soluções
- Conectar com a Retrospective como espaço de análise
- Evitar sugerir "estimar mais alto" sem entender a causa

**Resposta fraca ou incompleta:**
"Eu diria ao time para estimar mais alto na próxima Sprint." — Solução superficial que não investiga a causa. "Estimar mais alto" é um palliative, não uma solução. Se a causa é falta de refinamento, estimar mais alto não resolve — apenas mascara o problema. O time continuará impreciso, só que impreciso para mais em vez de para menos.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica o problema, mas não propõe solução
- **2** — Propõe "estimar mais alto" ou usar velocity passada
- **3** — Investiga causas e propõe 2-3 soluções razoáveis
- **4** — Diagnóstico completo, múltiplas soluções, menciona buffer e refinamento
- **5** — Domínio: diagnóstico de causas raiz, soluções sistêmicas, acompanhamento de previsibilidade e uso da Retrospective

**Perguntas de aprofundamento:**
1. Como distinguir entre "subestimação sistemática" e "velocity que varia naturalmente"?
2. O que é "planning fallacy" (falácia do planejamento) e como ela se manifesta em times ágeis?
3. Se o time começa a entregar *menos* que a velocity histórica após implementar buffer, o que isso indica?

---

### Pergunta 34 — Scrum of Scrums

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é o Scrum of Scrums e em que situações ele é necessário? Como funciona na prática e quem participa?

**O que essa pergunta avalia:**
Avalia o conhecimento de uma técnica de escalação do Scrum para múltiplos times, sua finalidade e funcionamento básico.

**Resposta esperada:**
O **Scrum of Scrums** é uma técnica para coordenar múltiplos times Scrum que trabalham no mesmo produto ou projeto. É essencialmente uma "Daily Scrum de times" — em vez de indivíduos se sincronizarem, times se sincronizam entre si.

**Quando é necessário:**
- Quando há múltiplos times (geralmente 3+) trabalhando no mesmo produto
- Quando há dependências entre times (um time precisa de uma API do outro)
- Quando a integração do trabalho de vários times precisa ser coordenada

**Como funciona:**
- Cada time elege um representante (geralmente um developer ou o Scrum Master)
- Os representantes se encontram regularmente (frequentemente diariamente, mas pode ser menos frequente)
- Cada representante responde a perguntas adaptadas do nível de time:
  1. O que o meu time fez desde a última reunião que afeta outros times?
  2. O que o meu time fará até a próxima reunião que afeta outros times?
  3. Há impedimentos que afetam múltiplos times?
  4. Há dependências que precisam ser resolvidas entre times?

**Participantes:**
- Representantes de cada time Scrum (1 por time)
- O Scrum Master pode facilitar, mas os representantes são quem reportam
- O Product Owner pode participar se houver decisões de prioridade que afetam múltiplos times

**Explicação didática:**
Imagine uma cidade com vários bairros em construção. Cada bairro tem sua própria equipe de obra (time Scrum) que faz sua Daily Scrum. Mas as equipes precisam coordenar: a equipe do bairro A está construindo uma rua que conecta ao bairro B, e a equipe do bairro B precisa saber quando a rua estará pronta. O Scrum of Scrums é como a reunião dos engenheiros-chefe de cada bairro — não para discutir detalhes internos de cada obra, mas para coordenar o que afeta todos.

**Exemplo prático:**
Empresa com 4 times Scrum trabalhando no mesmo produto de e-commerce:
- **Time A:** Frontend (loja)
- **Time B:** Backend (APIs)
- **Time C:** Pagamentos
- **Time D:** Logística

No Scrum of Scrums diário (15 min):
- Time A: "Vamos terminar a tela de checkout amanhã, mas precisamos que o Time C finalize a API de PIX."
- Time C: "A API de PIX está 80% pronta, estará disponível em 2 dias."
- Time B: "Descobrimos que o endpoint de produtos precisa ser ajustado para o checkout. Vamos priorizar isso hoje."
- Impedimento: "Time D depende de uma integração com a transportadora que está atrasada — precisa ser escalado."

**Como o candidato deve responder:**
- Explicar que é uma coordenação entre múltiplos times
- Mencionar quando é necessário (3+ times, dependências)
- Descrever como funciona (representantes, perguntas adaptadas)
- Citar quem participa
- Dar exemplo prático de coordenação entre times
- Evitar confundir com "Daily Scrum ampliada" (não é uma Daily de todos juntos)

**Resposta fraca ou incompleta:**
"Scrum of Scrums é quando vários times fazem a Daily juntos." — Incorreto: não é uma Daily de todos juntos (isso seria impraticável com 30+ pessoas). É uma reunião de *representantes* de cada time, com foco em coordenação e dependências, não em status individual.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "sobre múltiplos times", mas não explica
- **2** — Explica superficialmente, mas confunde com Daily ampliada
- **3** — Explica o conceito, participantes e quando usar
- **4** — Explica com clareza, perguntas adaptadas, exemplo prático
- **5** — Domínio: explica quando usar, limitações, alternativas (Nexus, SAFe) e como escala para muitos times

**Perguntas de aprofundamento:**
1. Quem deve ser o representante de cada time no Scrum of Scrums? O Scrum Master sempre é a melhor escolha?
2. O Scrum of Scrums resolve todos os problemas de coordenação entre times? Quais limitações ele tem?
3. Existem outras abordagens para escalar Scrum? Você conhece Nexus ou SAFe?

---

### Pergunta 35 — Cenário: Stakeholder querendo contornar o PO

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Um stakeholder importante da empresa não concorda com a priorização do Product Owner e vai diretamente aos developers para pedir que implementem uma feature que ele considera urgente. Os developers, com receio de negar, começam a trabalhar nela durante a Sprint. Como você lidaria com essa situação?

**O que essa pergunta avalia:**
Avalia a compreensão do papel do PO como guardião da prioridade, a postura do time diante de pressões externas e a atuação do SM na proteção do time.

**Resposta esperada:**
Essa é uma situação que viola vários princípios do Scrum: o PO é o único que pode ordenar o Product Backlog, e os Developers não deveriam aceitar trabalho de fontes externas durante a Sprint.

**Como lidar:**

1. **Educar o stakeholder:** Conversar com o stakeholder e explicar que o Scrum tem um canal único para solicitações: o Product Owner. Não é proibido ter ideias e necessidades — mas elas devem ser canalizadas pelo PO, que avalia valor, prioridade e impacto.

2. **Educar os developers:** Conversar com o time e explicar que eles não devem aceitar trabalho de fontes externas. Quando um stakeholder pede algo, a resposta correta é: "Entendo que é importante. Por favor, converse com o PO para que ele avalie e priorize. Se for realmente urgente, o PO pode discutir com o time."

3. **Conversar com o PO:** Explicar ao PO o que aconteceu e sugerir que ele converse com o stakeholder para entender a necessidade e decidir se ajusta a priorização do Backlog.

4. **Estabelecer o processo:** Definir claramente que qualquer solicitação de feature passa pelo PO. Documentar e comunicar isso a todos os stakeholders.

5. **Levar para a Retrospective:** Discutir na Retrospective o que permitiu que isso acontecesse e como prevenir. "Por que nos sentimos pressionados a aceitar?" "Como podemos dizer 'não' educadamente?"

6. **Proteger o time (papel do SM):** O Scrum Master deve atuar como escudo, conversando com o stakeholder e redirecionando para o PO, para que os developers não precisem confrontar diretamente.

**Explicação didática:**
Imagine um restaurante onde um cliente vai direto à cozinha e pede ao cozinheiro para fazer um prato especial, contornando o garçom (PO). O cozinheiro (developer) começa a fazer o prato, mas isso atrasa os pedidos que já estavam na fila. O garçom é quem organiza os pedidos e define a ordem — se cada cliente for direto à cozinha, o restaurante entra em caos. O gerente (SM) precisa garantir que os clientes usem o garçom.

**Exemplo prático:**
Stakeholder: "Preciso que vocês adicionem um relatório de vendas urgente, o CEO pediu."
Developer: "Entendo que é importante. Não posso simplesmente começar a trabalhar nisso sem passar pelo nosso Product Owner. Vou pedir que ele entre em contato com você hoje para discutir a prioridade."

SM fala com o PO: "O stakeholder X está pedindo uma feature diretamente aos developers. Precisamos alinhar com ele que as solicitações passam por você. Pode conversar com ele?"

PO fala com o stakeholder: "Entendo a urgência. Vou avaliar o impacto e a prioridade. Pode ser que eu adicione ao Backlog e entre na próxima Sprint, ou pode ser que troquemos por outra feature que estava planejada."

**Como o candidato deve responder:**
- Identificar a violação do papel do PO como guardião da prioridade
- Propor conversas com stakeholder, developers e PO
- Mencionar o papel do SM como protetor do time
- Sugerir educação e estabelecimento de processo
- Levar para a Retrospective
- Evitar sugerir que os developers "simplesmente recusem" sem suporte

**Resposta fraca ou incompleta:**
"Eu diria aos developers para não aceitar mais pedidos do stakeholder." — Abordagem punitiva que não resolve o problema de fundo. Os developers não recusaram por maldade — recusaram por receio. Sem educar o stakeholder, fortalecer o PO e estabelecer o processo, o problema se repetirá. Além disso, não aborda a causa: por que o stakeholder contornou o PO?

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica o problema, mas não propõe solução
- **2** — Propõe "dizer não ao stakeholder", sem abordar causa ou processo
- **3** — Propõe conversas com stakeholder, PO e time
- **4** — Abordagem completa: educação, processo, proteção e Retrospective
- **5** — Domínio: explica a função do PO como guardião, o papel do SM na proteção, e como fortalecer a autoridade do PO na organização

**Perguntas de aprofundamento:**
1. O que fazer se o PO concorda com o stakeholder e quer adicionar a feature no meio da Sprint?
2. Como o Scrum Master deve reagir se o stakeholder for o próprio CEO?
3. Por que os developers sentem medo de dizer "não"? Como criar segurança psicológica?

---

### Pergunta 36 — Conceito de MVP

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
O que é um MVP (Minimum Viable Product) e qual é a sua relação com as metodologias ágeis? Dê um exemplo de como um time ágil utilizaria o conceito de MVP.

**O que essa pergunta avalia:**
Avalia o entendimento do conceito de MVP, a diferença entre "mínimo" e "incompleto", e a relação com a entrega incremental ágil.

**Resposta esperada:**
O **MVP (Minimum Viable Product)** é a versão mais simples de um produto que permite aprender o máximo possível sobre as necessidades dos clientes com o menor esforço. Não é "o produto com menos features" — é "o menor produto que gera aprendizado válido".

O conceito foi popularizado por Eric Ries no contexto de Lean Startup e está profundamente conectado com as metodologias ágeis porque ambos compartilham a filosofia de entrega incremental e feedback rápido.

**Características do MVP:**
1. **Mínimo:** Contém apenas o essencial para validar uma hipótese
2. **Viável:** Funciona e pode ser usado por usuários reais (não é um protótipo)
3. **Produto:** É algo que pode ser entregue e testado no mercado
4. **Gera aprendizado:** O propósito é aprender, não gerar receita

**O que o MVP NÃO é:**
- Não é uma versão "reduzida" com metade das features planejadas
- Não é um protótipo ou demo
- Não é "lançar qualquer coisa para ver o que acontece"
- Não é uma desculpa para lançar produto de baixa qualidade

**Relação com ágil:**
No Scrum, cada Incremento pode ser visto como um passo em direção ao MVP. O time constrói o produto incrementalmente, e o PO decide quando o produto atingiu o estado de MVP para ser lançado. O feedback dos usuários do MVP informa o próximo Product Goal e o refinamento do Backlog.

**Explicação didática:**
Imagine que você quer abrir um restaurante. Em vez de construir um restaurante completo com 50 pratos no cardápio, você monta uma food truck com 3 pratos. A food truck é seu MVP: é mínimo (poucos pratos), é viável (funciona e serve clientes reais), é um produto (pessoas pagam), e gera aprendizado (você descobre quais pratos as pessoas gostam, qual o horário de pico, qual o público). Com esse aprendizado, você decide se abre o restaurante, muda o cardápio ou desiste.

**Exemplo prático:**
Um time vai construir um aplicativo de delivery de comida. Em vez de construir o app completo com pagamentos, avaliações, rastreamento, perfis de restaurantes e notificações, o time constrói um MVP:
- Lista de restaurantes parceiros (5 restaurantes)
- Cardápio simples
- Pedido via WhatsApp
- Pagamento na entrega

Esse MVP permite validar: as pessoas usam? Quais restaurantes são mais pedidos? Qual o ticket médio? Com esse aprendizado, o time prioriza as próximas features no Backlog (ex: se ninguém liga para avaliações, talvez pagamento online seja mais importante).

**Como o candidato deve responder:**
- Definir MVP como versão mínima que gera aprendizado
- Explicar que não é "produto reduzido" nem "protótipo"
- Conectar com a entrega incremental do Scrum
- Dar exemplo prático de MVP
- Mencionar que o propósito é validar hipóteses
- Evitar confundir MVP com "versão 1.0 com menos features"

**Resposta fraca ou incompleta:**
"MVP é a primeira versão do produto com as features mínimas para funcionar." — Parcialmente correto, mas omite o propósito central: aprendizado. MVP não é apenas "funcionar" — é funcionar para validar uma hipótese. Sem o elemento de aprendizado, é apenas uma versão reduzida, não um MVP.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "versão mínima", mas não explica propósito
- **2** — Define MVP, mas confunde com "versão 1.0 reduzida"
- **3** — Define MVP corretamente com exemplo
- **4** — Explica com clareza, conecta com ágil, menciona validação de hipóteses
- **5** — Domínio: explica MVP, tipos de MVP, relação com feedback loop ágil e como o PO usa MVP para priorizar Backlog

**Perguntas de aprofundamento:**
1. Qual é a diferença entre MVP e protótipo?
2. Um Incremento no Scrum é necessariamente um MVP?
3. Como decidir o que entra e o que não entra em um MVP?

---

### Pergunta 37 — Cenário: Daily Scrum que vira reunião de status

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Você observa que a Daily Scrum do seu time dura 40 minutos em vez de 15. As pessoas relatam o que fizeram detalhadamente, discutem problemas técnicos profundos e o Scrum Master fica anotando tudo. O que está errado e como você corrigiria?

**O que essa pergunta avalia:**
Avalia a identificação de um anti-pattern muito comum na Daily Scrum e a capacidade de propor soluções práticas para reconduzir o evento ao seu propósito.

**Resposta esperada:**

**O que está errado:**
1. **Duração excessiva:** A Daily Scrum tem timebox de 15 minutos. 40 minutos é quase 3x o limite.
2. **Formato de status report:** As pessoas estão relatando detalhes para o SM, não sincronizando com o time.
3. **Discussões técnicas profundas:** Problemas complexos devem ser discutidos após a Daily, apenas com as pessoas envolvidas.
4. **SM como receptor:** O SM está anotando tudo como se fosse um gerente recebendo status — isso reforça o anti-pattern.

**Como corrigir:**

1. **Reeducar o time sobre o propósito:** A Daily é para os Developers inspecionarem o progresso em direção à Sprint Goal e adaptarem o plano. Não é status report.

2. **Mudar o formato:** Em vez de "o que eu fiz ontem" (que gera relatos longos), focar no Sprint Backlog:
   - Olhar o quadro/Sprint Backlog
   - "Estamos progredindo em direção à meta?"
   - "Há algo bloqueando?"
   - "Precisamos de ajuda de alguém?"

3. **Estabelecer a regra "Take it offline":** Quando uma discussão técnica começa a se prolongar, qualquer pessoa pode dizer "vamos discutir isso após a Daily" (ou "parking lot"). Criar uma lista de tópicos para discussão após a Daily, apenas com interessados.

4. **SM parar de anotar:** O SM deve deixar de ser o "recebedor" do status. Os Developers são donos da Daily. O SM pode facilitar a mudança de comportamento, mas não deve ser o centro.

5. **Timebox rigoroso:** Usar um timer de 15 minutos. Quando acaba, a Daily termina. Se alguém não falou, na próxima fala primeiro. Isso força concisão.

6. **Modelar o comportamento:** O SM pode começar demonstrando o formato desejado: "Olhando o quadro, a história X está pronta para teste. Preciso de alguém para revisar. Sem bloqueios." — curto e direto.

**Explicação didática:**
Imagine uma equipe de enfermagem fazendo o round matinal. Se cada enfermeiro conta a história completa de cada paciente (40 minutos), o round perde o propósito — que é sincronizar rapidamente e identificar quem precisa de ajuda. O correto é: "Paciente 101 estável, paciente 102 precisa de medicação, paciente 103 tem uma reação — preciso de ajuda." Discussões detalhadas acontecem depois, com quem é relevante.

**Exemplo prático:**
**Antes (40 min):**
- Dev1: "Ontem eu comecei a trabalhar na feature de login. Primeiro fiz a configuração do OAuth, depois criei as rotas no backend, depois configurei o middleware de autenticação. Tive um problema com o token JWT que expirava muito rápido e..." (5 min só para Dev1)

**Depois (15 min total):**
- Dev1: "Login: OAuth configurado, JWT com problema de expiração. Preciso de ajuda do Dev3 hoje."
- Dev2: "Dashboard: 60% pronto, sem bloqueios."
- Dev3: "Posso ajudar o Dev1 com o JWT após a Daily. Minha tarefa de exportação está no caminho."
- Dev4: "Sem bloqueios, testes da feature X passando."
- SM: nada a anotar — apenas observa.

**Como o candidato deve responder:**
- Identificar todos os problemas (duração, formato, papel do SM)
- Propor mudança de formato (foco no Sprint Backlog)
- Mencionar "parking lot" / "take it offline"
- Explicar que o SM deve parar de ser o receptor
- Sugerir timebox rigoroso com timer
- Conectar com a Retrospective como espaço de discussão

**Resposta fraca ou incompleta:**
"Eu colocaria um cronômetro e cortaria as pessoas quando passassem do tempo." — Abordagem autoritária que não resolve a causa. Cortar as pessoas gera frustração e não muda a compreensão do propósito da Daily. O problema não é apenas tempo — é o formato e a mentalidade.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica que "está longa", mas não propõe solução
- **2** — Propõe "cortar o tempo" ou "relembrar as 3 perguntas"
- **3** — Identifica os problemas e propõe 2-3 soluções
- **4** — Abordagem completa: formato, parking lot, papel do SM, timer
- **5** — Domínio: explica o propósito da Daily, como mudar a cultura do time e como o SM deve modelar o novo comportamento

**Perguntas de aprofundamento:**
1. O que é "parking lot" na Daily Scrum e como implementar?
2. A Daily Scrum deve ser obrigatoriamente em pé (standing meeting)?
3. Se o time tem 10 pessoas, 15 minutos são suficientes? Como escalar?

---

### Pergunta 38 — Conceito de Timebox

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é um timebox no contexto ágil e por que o Scrum o utiliza para todos os seus eventos? Quais são as vantagens e desvantagens de trabalhar com timeboxes?

**O que essa pergunta avalia:**
Avalia o entendimento do conceito de timebox como princípio fundamental do Scrum e a capacidade de analisar seus prós e contras.

**Resposta esperada:**
Um **timebox** é um período fixo de tempo alocado para uma atividade, durante o qual ela deve ser concluída. Quando o tempo acaba, a atividade termina — independentemente de estar "pronta" ou não. O Scrum usa timeboxes para todos os seus eventos.

**Timeboxes no Scrum:**
- Sprint: 1-4 semanas
- Sprint Planning: máx. 8 horas (para Sprint de 4 semanas)
- Daily Scrum: 15 minutos
- Sprint Review: máx. 4 horas (para Sprint de 4 semanas)
- Sprint Retrospective: máx. 3 horas (para Sprint de 4 semanas)

**Vantagens:**
1. **Foco:** Com tempo limitado, as pessoas tendem a ser mais concisas e focadas.
2. **Previsibilidade:** Os eventos happen em horários previsíveis, permitindo planejamento.
3. **Evita Parkinson's Law:** A lei diz que "o trabalho se expande para preencher o tempo disponível". Sem timebox, uma reunião de 15 minutos pode virar 1 hora.
4. **Força decisões:** Com tempo limitado, o time é obrigado a decidir em vez de adiar indefinidamente.
5. **Reduz desperdício:** Reuniões longas sem propósito são um dos maiores desperdícios de tempo.

**Desvantagens:**
1. **Decisões precipitadas:** Se o time não se prepara, o timebox pode forçar decisões ruins.
2. **Frustração:** Pessoas que não conseguem terminar no tempo podem se sentir pressionadas.
3. **Inflexibilidade:** Para discussões complexas que precisam de mais tempo, o timebox pode ser restritivo (embora a solução seja agendar uma reunião separada, não estender o evento).
4. **Ritmo artificial:** Nem sempre 15 minutos é o suficiente — mas a ideia é que 15 min é suficiente *para o propósito da Daily*, não para resolver todos os problemas.

**Explicação didática:**
Imagine uma prova de exames com tempo limite de 2 horas. Sem o limite, alguns alunos ficariam revisando infinitamente. O timebox força a decisão: "responda o que sabe, faça o melhor que puder no tempo dado." No Scrum, o timebox da Sprint força o time a entregar algo em vez de "polir para sempre". O timebox da Daily força concisão em vez de reuniões intermináveis.

**Exemplo prático:**
Sprint Planning com timebox de 4 horas (Sprint de 2 semanas): se o time está discutindo a estimativa de uma história há 30 minutos e não converge, o Scrum Master pode dizer: "Estamos em 2 horas de Planning. Temos 6 histórias ainda não estimadas. Precisamos ser mais rápidos ou algumas histórias não entrarão na Sprint." O timebox cria urgência e força priorização.

**Como o candidato deve responder:**
- Definir timebox como período fixo
- Listar os timeboxes dos eventos Scrum
- Citar pelo menos 3 vantagens (foco, Parkinson's Law, previsibilidade)
- Mencionar pelo menos 1-2 desvantagens
- Explicar que o timebox não impede discussões adicionais — apenas em outro momento
- Evitar dizer que timeboxes são "limites rígidos que prejudicam"

**Resposta fraca ou incompleta:**
"Timebox é o tempo máximo de cada reunião do Scrum. Serve para não demorar demais." — Define o conceito superficialmente, mas não explica *por que* é usado (Parkinson's Law, foco, previsibilidade) nem menciona desvantagens. "Não demorar demais" é muito genérico.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "tempo limite", mas não explica propósito
- **2** — Define e cita timeboxes, mas não analisa vantagens/desvantagens
- **3** — Define, cita timeboxes e explica 3+ vantagens
- **4** — Explica vantagens e desvantagens com exemplos
- **5** — Domínio: explica timebox como princípio filosófico do Scrum, Parkinson's Law, e como o timebox da Sprint cria cadência de feedback

**Perguntas de aprofundamento:**
1. O que é a Lei de Parkinson e como o timebox a combate?
2. O timebox da Sprint Planning pode ser estendido se o time precisa de mais tempo?
3. Como um time Kanban lida com a ausência de timeboxes? O que substitui essa disciplina?

---

### Pergunta 39 — Cenário: Cancelamento de Sprint

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Em que circunstâncias uma Sprint pode ser cancelada no Scrum? Quem tem autoridade para cancelar uma Sprint e o que acontece com o trabalho já realizado quando isso ocorre?

**O que essa pergunta avalia:**
Avalia o conhecimento de uma situação extrema mas prevista no Scrum, a autoridade para a decisão e os procedimentos seguintes.

**Resposta esperada:**

**Quem pode cancelar:** Apenas o **Product Owner** pode cancelar uma Sprint. Nenhuma outra pessoa tem essa autoridade.

**Quando faz sentido cancelar:**
1. **A Sprint Goal tornou-se obsoleta:** O cenário de negócio mudou dramaticamente (ex: concorrente lançou um produto que torna a feature irrelevante, mudança de estratégia da empresa).
2. **A prioridade mudou fundamentalmente:** O que era mais importante deixou de ser, e o que é mais importante agora não pode esperar a próxima Sprint.
3. **Circunstâncias externas:** Problemas técnicos graves (ex: infraestrutura caída por tempo indeterminado), mudanças regulatórias, etc.

**O que acontece com o trabalho:**
1. Itens que atingiram a DoD são considerados parte do Incremento e são preservados.
2. Itens que não atingiram a DoD voltam para o Product Backlog e são reavaliados pelo PO.
3. O Sprint Backlog é descartado.
4. Um novo Sprint Planning é realizado imediatamente com as novas prioridades.

**Frequência:**
O cancelamento de Sprint deve ser **raro**. Se acontece com frequência, indica problemas estruturais:
- Sprint Goals mal definidas
- PO mudando de ideia constantemente
- Sprint muito longa (4 semanas) em um ambiente volátil
- Falta de visão de produto

**Explicação didática:**
Imagine que você está pilotando um avião para um destino e, no meio do voo, descobre que o destino foi fechado por uma tempestade. Você não continua voando até o destino fechado — você cancela o voo e redefine a rota. O cancelamento da Sprint é como o piloto (PO) decidindo que o destino atual não faz mais sentido e que é melhor retornar e replanejar.

**Exemplo prático:**
Sprint 7 com a meta "Implementar integração com rede social X". No dia 4 da Sprint, a rede social X anuncia que vai descontinuar sua API pública. O PO percebe que a Sprint Goal se tornou obsoleta — não faz sentido integrar com uma API que vai desaparecer. O PO cancela a Sprint. As histórias que já estão "Done" (ex: refatoração do módulo de autenticação) são preservadas. As que estão em andamento (ex: integração com a API) voltam para o Backlog e provavelmente serão removidas. Um novo Sprint Planning é agendado para definir a nova meta.

**Como o candidato deve responder:**
- Explicar que apenas o PO pode cancelar
- Citar pelo menos 2-3 circunstâncias válidas
- Explicar o que acontece com o trabalho (Done é preservado, não-Done volta ao Backlog)
- Mencionar que o cancelamento deve ser raro
- Explicar que um novo Planning é necessário
- Evitar sugerir que o SM ou os Developers podem cancelar

**Resposta fraca ou incompleta:**
"O Scrum Master pode cancelar a Sprint se o time não está entregando nada." — Incorreto: o SM não tem autoridade para cancelar a Sprint. Apenas o PO. E o critério não é "não está entregando" — é a Sprint Goal se tornar obsoleta. Se o time não está entregando, o problema deve ser investigado na Retrospective, não resolvido com cancelamento.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é possível cancelar, mas não sabe quem ou quando
- **2** — Sabe que o PO cancela, mas não explica o que acontece com o trabalho
- **3** — Explica quem cancela, quando e o que acontece com o trabalho
- **4** — Explica com clareza, menciona que deve ser raro e dá exemplo
- **5** — Domínio: explica autoridade, circunstâncias, procedimento, frequência esperada e sinais de problema estrutural

**Perguntas de aprofundamento:**
1. Se o PO cancela Sprints com frequência, o que isso indica sobre o processo?
2. O que acontece com a Sprint Retrospective quando a Sprint é cancelada?
3. Uma Sprint de 4 semanas tem maior risco de cancelamento que uma de 1 semana? Por quê?

---

### Pergunta 40 — Conceito de DevOps e integração com Ágil

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
Como as práticas de DevOps se relacionam com as metodologias ágeis? O que significa "CI/CD" e como isso apoia a entrega ágil de valor?

**O que essa pergunta avalia:**
Avalia o entendimento da relação entre DevOps e Ágil, o conceito de CI/CD e como práticas técnicas suportam a entrega incremental ágil.

**Resposta esperada:**
**DevOps** é a combinação de desenvolvimento (Dev) e operações (Ops) com o objetivo de encurtar o ciclo de vida de entrega de software através de automação, colaboração e cultura. As metodologias ágeis definem *como* o time trabalha e entrega valor; o DevOps fornece *as ferramentas e práticas técnicas* que tornam a entrega ágil possível em escala.

**CI/CD:**
- **CI (Continuous Integration - Integração Contínua):** Prática de integrar o código de todos os developers em um branch compartilhado frequentemente (várias vezes ao dia). Cada integração é verificada por build automatizada e testes, detectando problemas cedo.
- **CD (Continuous Delivery / Continuous Deployment):**
  - **Continuous Delivery:** Todo código que passa nos testes é *automaticamente preparado* para release. O deploy em produção é manual (um botão).
  - **Continuous Deployment:** Todo código que passa nos testes é *automaticamente deployado* em produção. Sem intervenção manual.

**Como CI/CD apoia o Ágil:**
1. **Feedback rápido:** O time descobre imediatamente se algo quebrou, não espera até o final da Sprint.
2. **Incremento sempre releasable:** Se o time pratica CI/CD, o Incremento está sempre em condições de ser liberado — apoia diretamente o conceito de "potentially releasable".
3. **Reduz risco de integração:** Sem CI, integrar no final da Sprint é arriscado e demorado. Com CI, a integração é contínua e os problemas são pequenos.
4. **Permite releases frequentes:** O PO pode liberar múltiplos releases por Sprint sem depender de um processo manual demorado.
5. **Definition of Done mais robusta:** A DoD pode incluir "código integrado e testado no CI" e "deployado em homologação pelo CD".

**Explicação didática:**
Imagine uma banda compondo uma música. Sem "integração contínua", cada músico escreve sua parte isoladamente e só se juntam no dia da gravação — provavelmente nada combina. Com "integração contínua", a banda toca junta todos os dias, cada um adiciona sua parte e imediatamente ouvem como soa junto. Se algo não combina, corrigem na hora. O "delivery" é quando a música está pronta para ser gravada (continuous delivery) ou automaticamente publicada (continuous deployment).

**Exemplo prático:**
Um time Scrum com CI/CD:
1. Developer faz commit do código → CI roda build e testes automaticamente
2. Se os testes passam → CD deploya em ambiente de homologação
3. Na Sprint Review, o PO e stakeholders veem a feature funcionando em homologação
4. O PO decide "liberar para produção" → um clique (continuous delivery) ou deploy automático (continuous deployment)
5. Se um bug é encontrado, o time corrige, faz commit, e o CI/CD se encarrega de testar e deployar a correção

Sem CI/CD, o time faria o trabalho manualmente: integrar código, rodar testes localmente, criar pacote de deploy, pedir para o time de infra deployar... — processo demorado e propenso a erros.

**Como o candidato deve responder:**
- Explicar a relação entre DevOps e Ágil (ferramenta vs. processo)
- Definir CI e CD com clareza
- Explicar a diferença entre Continuous Delivery e Continuous Deployment
- Citar pelo menos 3 formas como CI/CD apoia a entrega ágil
- Mencionar a relação com "potentially releasable" Increment
- Evitar confundir DevOps com "ferramenta de automação" (é cultura + prática + ferramenta)

**Resposta fraca ou incompleta:**
"DevOps é quando o time de dev e o time de ops trabalham juntos. CI/CD é automatizar o deploy." — Muito superficial: DevOps é mais que "trabalhar junto" — é uma mudança cultural com práticas específicas. E CI/CD não é apenas "automatizar deploy" — CI é integração contínua com testes, e CD pode ser delivery (preparação) ou deployment (liberação automática).

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que DevOps é "dev + ops", mas não explica relação com ágil
- **2** — Define CI/CD superficialmente, mas sem conectar ao ágil
- **3** — Define CI/CD e explica 2+ conexões com ágil
- **4** — Explica com clareza, diferencia Delivery de Deployment, conecta com Incremento releasable
- **5** — Domínio: explica DevOps como cultura, CI/CD como prática, e como isso habilita o time Scrum a entregar valor de forma verdadeiramente incremental

**Perguntas de aprofundamento:**
1. Um time pode ser ágil sem CI/CD? Quais são os desafios?
2. A Definition of Done deve incluir CI/CD? O que acontece se não inclui?
3. O que é "feature flag" e como ela se relaciona com CI/CD e entrega ágil?

---

### Pergunta 41 — Anti-pattern: Scrum Master como gerente de projetos

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
Um erro comum em organizações que adotam Scrum é tratar o Scrum Master como um "gerente de projetos". Qual é a diferença fundamental entre esses dois papéis e por que confundí-los prejudica o time?

**O que essa pergunta avalia:**
Avalia a capacidade de diferenciar o papel do SM do gerente de projetos tradicional, uma confusão que compromete a auto-organização e a filosofia ágil.

**Resposta esperada:**

| Aspecto | Scrum Master | Gerente de Projetos |
|---|---|---|
| Foco | Processo e eficácia do Scrum | Entregar projeto no prazo, escopo e custo |
| Autoridade sobre o trabalho | Nenhuma — o time se auto-organiza | Atribui tarefas, define prazos, controla execução |
| Relação com o time | Facilita, ensina, remove impedimentos | Dirige, cobra, reporta status |
| Métricas | Eficácia do Scrum, melhoria contínua | Cronograma, orçamento, desvio de escopo |
| Responsabilidade pela entrega | O time é responsável; o SM garante o processo | O gerente é responsável pela entrega |
| Decisões técnicas | Não toma — os Developers decidem | Pode tomar, dependendo da organização |

**Por que confundir é prejudicial:**
1. **Destroi a auto-organização:** Se o SM diz quem faz o quê, o time nunca aprende a se organizar.
2. **Cria dependência:** O time espera o SM atribuir tarefas e resolver problemas em vez de tomar iniciativa.
3. **Muda o foco:** O SM começa a focar em "entregar no prazo" em vez de "garantir que o Scrum funciona".
4. **Substitui responsabilidade:** O SM se torna "responsável pela entrega", mas no Scrum a responsabilidade é do time.
5. **Mantém a cultura tradicional:** O time não experimenta a autonomia que o Scrum propõe.

**O que o SM faz em vez de "gerenciar":**
- Facilita eventos Scrum
- Remove impedimentos
- Educa o time e a organização sobre Scrum
- Ajuda o PO a maximizar valor
- Promove a melhoria contínua
- Protege o time de interferências externas
- Serve ao time (servant leadership)

**Explicação didática:**
Imagine um time de futebol. O gerente de projetos é o técnico que decide a escalação, a tática e dá ordens. O Scrum Master é o preparador físico que garante que os jogadores estão saudáveis, que o campo está em boas condições e que o time tem o que precisa para jogar — mas não diz *como* jogar. Os jogadores (Developers) decidem *como* jogam dentro de campo.

**Exemplo prático:**
**Gerente de projetos (anti-pattern):** "João, você vai ficar responsável pela API. Maria, você faz o frontend. O prazo é sexta. Me deem status todo dia."
**Scrum Master (correto):** (Na Sprint Planning) "Qual é a meta dessa Sprint?" (Para o time) "Vocês decidem quem faz o quê. Me digam se há algo que eu possa remover que está bloqueando vocês."

**Como o candidato deve responder:**
- Diferenciar claramente os dois papéis em pelo menos 4 aspectos
- Explicar por que a confusão prejudica o time
- Mencionar auto-organização como elemento central
- Descrever o que o SM *faz* (facilita, remove impedimentos, educa)
- Evitar dizer que o SM "não faz nada" ou "é só um facilitador de reuniões"

**Resposta fraca ou incompleta:**
"O Scrum Master não é gerente porque não manda no time. Ele só facilita as reuniões." — Reduz o SM a "facilitador de reuniões", o que é apenas uma parte do papel. O SM também educa, remove impedimentos, protege o time, ajuda o PO e promove a melhoria contínua. Reduzir a "facilitador de reuniões" subestima o papel.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que "são diferentes", mas não explica
- **2** — Diferencia em 2-3 aspectos, mas não explica o dano
- **3** — Diferencia em 4+ aspectos e explica por que prejudica
- **4** — Diferencia com clareza, explica o dano e o que o SM faz
- **5** — Domínio: compara os papéis, explica o impacto na auto-organização e como a transição de GP para SM deve ser feita

**Perguntas de aprofundamento:**
1. Uma organização pode ter tanto um Scrum Master quanto um gerente de projetos para o mesmo time? Quando isso faz sentido?
2. Como ajudar um gerente de projetos a se tornar Scrum Master? Quais hábitos ele precisa mudar?
3. O Scrum Master pode atribuir tarefas em alguma circunstância?

---

### Pergunta 42 — Cenário: Time com 12 pessoas

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Sua empresa tem um time Scrum com 12 pessoas e as Dailys duram 30+ minutos, o Sprint Planning é caótico e as Retrospectives não produzem ações concretas. O que você sugere e por quê?

**O que essa pergunta avalia:**
Avalia o conhecimento do limite de tamanho do Scrum Team, a compreensão dos problemas causados por times grandes e a capacidade de propor solução estrutural.

**Resposta esperada:**
O Guia Scrum recomenda que o Scrum Team tenha **10 ou menos pessoas** (incluindo PO, SM e Developers). Um time de 12 pessoas está acima do limite e os problemas descritos são sintomas diretos do tamanho excessivo.

**Por que 12 pessoas é um problema:**
1. **Daily longa:** Com 12 pessoas, se cada uma fala 2 minutos, são 24 minutos — já ultrapassou o timebox de 15 minutos.
2. **Planning caótico:** 12 pessoas tentando estimar e planejar juntas gera ruído de comunicação excessivo. A lei de Brookslaw diz que adicionar pessoas a um projeto de software o torna mais lento, porque o canal de comunicação cresce quadraticamente (n(n-1)/2).
3. **Retrospective ineficaz:** Com 12 pessoas, poucos falam e muitos ficam passivos. Não há tempo para ouvir todos.

**Solução:**
Dividir o time em dois Scrum Teams menores (ex: 6 e 6, ou 5 e 7), cada um com seu próprio PO (ou um PO compartilhado se o produto for o mesmo) e seu próprio Scrum Master (ou um SM servindo a ambos se viável).

**Desafios da divisão:**
1. **Product Backlog compartilhado ou dividido:** Se ambos trabalham no mesmo produto, podem compartilhar o Product Backlog com um PO único, ou dividir em áreas (ex: Time A cuida do frontend, Time B do backend).
2. **Coordenação:** Usar Scrum of Scrums para sincronizar dependências.
3. **Sprints alinhadas:** Ambos os times devem ter Sprints sincronizadas (mesma duração, início e fim) para facilitar a integração e a Review conjunta.
4. **Definir o critério de divisão:** Por área técnica (frontend/backend), por feature (checkout/busca), por domínio (pagamentos/logística).

**Explicação didática:**
Imagine uma reunião de 12 pessoas tentando decidir onde almoçar. Cada um tem uma opinião, o debate se fragmenta, alguém domina a conversa e outros desistem. Agora divida em dois grupos de 6: cada grupo decide mais rapidamente e depois os representantes se alinham. A comunicação é mais eficiente em grupos menores porque há menos canais de comunicação simultâneos.

**Exemplo prático:**
Time de 12 dividido em dois:
- **Time Alpha (6 pessoas):** Foca em features de frontend e UX
- **Time Beta (6 pessoas):** Foca em APIs e infraestrutura

Cada time tem sua própria Daily (15 min), seu próprio Planning e sua própria Retrospective. Uma vez por semana, os representantes de cada time se encontram no Scrum of Scrums para alinhar dependências. A Sprint Review pode ser conjunta, com ambos os times mostrando o Incremento integrado.

**Como o candidato deve responder:**
- Identificar que 12 pessoas excede o limite do Scrum
- Explicar os problemas causados pelo tamanho excessivo
- Propor divisão em 2 times
- Mencionar como lidar com Backlog, coordenação e Sprints alinhadas
- Citar a Lei de Brookslaw ou o problema de comunicação em times grandes
- Evitar sugerir "manter o time e só cortar a Daily para 15 min"

**Resposta fraca ou incompleta:**
"Eu reduziria a Daily para 15 minutos e pediria que cada um fale menos." — Não resolve o problema estrutural. O problema não é que as pessoas falam demais — é que 12 pessoas não cabem no formato da Daily de 15 min. Reduzir o tempo de cada um não melhora a sincronização, apenas comprime a comunicação. O time continuará caótico no Planning e na Retrospective.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica que o time é grande, mas não propõe solução
- **2** — Propõe "falar menos" ou "reduzir o tempo", sem divisão
- **3** — Propõe divisão em 2 times, mas não aborda coordenação
- **4** — Propõe divisão, menciona coordenação (Scrum of Scrums) e Backlog
- **5** — Domínio: explica o limite do Scrum, os problemas de comunicação, a divisão, a coordenação e os desafios de integração

**Perguntas de aprofundamento:**
1. O Guia Scrum diz "10 ou menos". Isso é uma regra rígida ou uma recomendação?
2. Como dividir um Backlog único entre dois times sem criar conflitos de prioridade?
3. Um Product Owner pode servir a dois times Scrum simultaneamente?

---

### Pergunta 43 — Conceito de Slice Vertical

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
O que significa entregar uma "fatia vertical" (vertical slice) de funcionalidade em vez de uma "fatia horizontal"? Por que o Scrum prefere fatias verticais?

**O que essa pergunta avalia:**
Avalia o entendimento de um conceito fundamental para entregar valor incremental: a diferença entre estruturar o trabalho por camadas técnicas (horizontal) vs. por funcionalidades completas (vertical).

**Resposta esperada:**

**Fatia Vertical:** É uma entrega que percorre todas as camadas técnicas necessárias para entregar uma funcionalidade completa e utilizável. Do frontend ao backend, ao banco de dados e aos testes — tudo em uma única entrega.

**Fatia Horizontal:** É uma entrega que cobre apenas uma camada técnica. Por exemplo, "fazer todo o backend da feature" ou "criar todo o banco de dados da feature".

```
            Frontend    Backend    Banco de Dados    Testes
Feature A:    [X]         [X]           [X]            [X]    ← Fatia Vertical (funcional)
Feature B:    [ ]         [ ]           [ ]            [ ]

vs.

            Frontend    Backend    Banco de Dados    Testes
Feature A:    [X]         [X]           [X]            [X]
Feature B:    [X]         [X]           [X]            [X]    ← Fatia Horizontal (não funcional)
Feature C:    [X]         [X]           [X]            [X]
Todas testadas ao final: [ ]
```

**Por que o Scrum prefere fatias verticais:**
1. **Entrega valor:** Uma fatia vertical é uma funcionalidade que o usuário pode usar. Uma fatia horizontal (só backend) não gera valor por si só.
2. **Feedback real:** Com uma fatia vertical, o PO e stakeholders podem testar a funcionalidade real. Com uma fatia horizontal, só se vê "funciona tecnicamente".
3. **Reduz risco:** Integrar todas as camadas em uma fatia vertical testa a arquitetura completa. Descobrir problemas cedo é mais barato.
4. **Atende ao conceito de Incremento:** O Incremento do Scrum deve ser "potentially releasable" — uma fatia horizontal não é releasable.

**Explicação didática:**
Imagine construir uma casa. **Fatia horizontal:** fazer todo o piso da casa primeiro, depois todas as paredes, depois todo o teto. Você não pode morar na casa até que tudo esteja completo. **Fatia vertical:** construir um cômodo completo (piso, paredes, teto, porta, janela). Você pode usar esse cômodo imediatamente, mesmo que o resto da casa não esteja pronto. Cada cômodo é um Incremento habitável.

**Exemplo prático:**
Feature: "Sistema de avaliação de produtos"

**Abordagem horizontal (anti-pattern):**
- Sprint 1: Criar tabela de avaliações no banco (sem frontend, sem API)
- Sprint 2: Criar API de avaliações (sem frontend)
- Sprint 3: Criar interface de avaliação (finalmente funcional)
- Sprint 4: Testes de integração

Problema: só na Sprint 3 o usuário pode avaliar. As Sprints 1 e 2 não entregam valor utilizável.

**Abordagem vertical (recomendada):**
- Sprint 1: "Usuário pode dar nota de 1 a 5 estrelas em um produto" — frontend + API + banco + testes, tudo para essa funcionalidade específica.
- Sprint 2: "Usuário pode escrever um comentário na avaliação" — nova fatia vertical que adiciona funcionalidade.
- Sprint 3: "Usuário pode ver a média de avaliações de um produto" — mais uma fatia.

Cada Sprint entrega uma funcionalidade utilizável.

**Como o candidato deve responder:**
- Definir fatia vertical e fatia horizontal
- Explicar a diferença com clareza
- Citar pelo menos 3 razões para preferir fatias verticais
- Dar exemplo prático contrastando as duas abordagens
- Mencionar a relação com o Incremento "potentially releasable"
- Evitar dizer que "fatias horizontais nunca são úteis" (trabalho técnico puro pode ser necessário, mas não deve ser a norma)

**Resposta fraca ou incompleta:**
"Fatia vertical é quando você faz tudo de uma vez em vez de fazer por partes." — Incorreto: a fatia vertical *é* fazer por partes — mas por partes de *funcionalidade*, não por partes de *camada técnica*. A diferença não é "tudo de uma vez vs. por partes", mas "por funcionalidade vs. por camada técnica".

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "fazer a funcionalidade completa", mas não explica
- **2** — Define os dois conceitos, mas não justifica a preferência
- **3** — Define, compara e explica 3+ razões para fatias verticais
- **4** — Explica com clareza, dá exemplo prático e conecta com Incremento
- **5** — Domínio: explica o conceito, a relação com valor incremental, a dificuldade de estimar fatias horizontais e como decompor uma feature em fatias verticais

**Perguntas de aprofundamento:**
1. É possível fazer fatias verticais em todas as situações? Quando o trabalho técnico puro (ex: refatoração) faz sentido como item de Sprint?
2. Como decompor uma feature grande em fatias verticais menores?
3. Fatias verticais são possíveis em arquiteturas de microsserviços com múltiplos times?

---

### Pergunta 44 — Cenário: Resistência à Retrospective

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
O seu time vê a Sprint Retrospective como uma perda de tempo. Eles dizem: "já sabemos o que está errado, não precisa de reunião para isso." Como você responderia e o que faria para mudar essa percepção?

**O que essa pergunta avalia:**
Avalia a capacidade de lidar com resistência cultural a um evento central do Scrum, a empatia com o time e a habilidade de demonstrar valor prático.

**Resposta esperada:**

**Entender antes de responder:**
Primeiro, investigar *por que* o time acha que é perda de tempo:
1. Já tentaram e nada mudou? (Retros sem ações = perda de tempo)
2. O formato é monótono? (Sempre as mesmas perguntas)
3. Não há segurança psicológica? (As pessoas não falam honestamente)
4. As ações identificadas não são implementadas? (Frustração acumulada)

**Como responder:**
"Entendo que vocês sentem que é perda de tempo. Vou ser honesto: se as Retros anteriores não geraram mudanças reais, vocês têm razão em sentir isso. Mas o problema não é a Retrospective — é como ela foi conduzida. Uma Retrospective que não gera ação é, de fato, perda de tempo. Vamos tentar diferente: nas próximas 3 Retros, eu garanto que cada uma vai produzir *uma* ação concreta que será implementada. Se após 3 Retros vocês ainda sentem que é perda de tempo, repensamos juntos."

**O que fazer para mudar a percepção:**
1. **Focar em ações, não em reclamações:** Estruturar a Retros para produzir exatamente 1-2 ações acionáveis, não uma lista de 10 problemas sem solução.
2. **Dar ownership ao time:** Em vez de o SM definir o formato, deixar o time escolher o formato da Retro.
3. **Acompanhar ações:** Criar um quadro de "ações da Retrospective" que é revisado na próxima Retro. "Fizemos o que combinamos?" Se não, por quê?
4. **Variação de formato:** Usar formatos diferentes (Sailboat, 4Ls, Start/Stop/Continue, Mad/Sad/Glad) para evitar repetição.
5. **Manter curta e focada:** Se o time resiste, começar com Retros de 30 min bem focadas.
6. **Usar dados:** Trazar dados da Sprint (velocity, bugs, lead time) e usar como ponto de partida: "Nosso lead time aumentou 40% essa Sprint. O que podemos fazer?"

**Explicação didática:**
Imagine um paciente que foi ao médico três vezes e não melhorou. Ele diz "ir ao médico é perda de tempo." O problema não é a consulta médica — é que as consultas não geraram um tratamento eficaz. A solução não é parar de ir ao médico, mas mudar a abordagem: talvez o diagnóstico estivesse errado, talvez o tratamento não fosse seguido. Com a Retrospective é igual: se não gera mudança, o problema é o *como*, não o *o que*.

**Exemplo prático:**
Retro com formato **Sailboat:**
- **Vento (o que nos impulsiona):** "Nossa comunicação melhorou", "CI/CD está estável"
- **Âncora (o que nos segura):** "Refinamento está fraco", "Dependência do time X"
- **Rocha (risco à frente):** "Release na próxima semana pode ter problemas"
- **Ilha (objetivo):** "Entregar 30 pontos com qualidade"

O time escolhe *uma* âncora para remover: "Vamos dedicar 1 hora de refinement extra por Sprint." Esta ação vai para o quadro de ações e é revisada na próxima Retro.

**Como o candidato deve responder:**
- Não invalidar o sentimento do time
- Investigar a causa da resistência
- Propor mudanças concretas no formato
- Garantir que as ações sejam implementadas e revisadas
- Mencionar variação de formatos
- Usar dados como ponto de partida
- Evitar impor a Retrospective "porque o Scrum exige"

**Resposta fraca ou incompleta:**
"Eu diria que a Retrospective é obrigatória no Scrum e que eles precisam fazer." — Abordagem autoritária que aumenta a resistência. Obrigar pessoas que já resistem não gera engajamento — gera conformidade passiva. A Retrospective precisa ter valor percebido, não ser uma imposição.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Reconhece o problema, mas não propõe solução
- **2** — Propõe "obrigar" ou "explicar que é necessário"
- **3** — Entende a causa, propõe 2-3 mudanças no formato
- **4** — Abordagem empática, propõe ações concretas, variação e acompanhamento
- **5** — Domínio: empatia, diagnóstico de causa, plano de 3 Retros com accountability, uso de dados e formatos variados

**Perguntas de aprofundamento:**
1. O que fazer se, após melhorar a Retrospective, o time *ainda* não implementa as ações?
2. A Retrospective pode ser feita sem o Scrum Master?
3. Como medir se a Retrospective está gerando valor para o time?

---

### Pergunta 45 — Conceito de Batch Size

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
O que é "batch size" (tamanho de lote) no contexto de metodologias ágeis e por que times ágeis preferem lotes menores? Como isso se relaciona com o tamanho das histórias de usuário?

**O que essa pergunta avalia:**
Avalia o entendimento do conceito de batch size e sua relação com a entrega ágil, além de conectar o conceito com a decomposição de histórias.

**Resposta esperada:**
**Batch size** é a quantidade de trabalho que um time pega e tenta completar em um ciclo. No Scrum, o batch size é determinado pelo número e tamanho de itens no Sprint Backlog. No Kanban, é influenciado pelo WIP limit.

**Por que lotes menores são melhores:**

1. **Feedback mais rápido:** Com lotes pequenos, o time completa e inspeciona itens com mais frequência. Com lotes grandes, só descobre problemas no final — quando é caro corrigir.
2. **Menor risco:** Um lote pequeno que falha tem impacto menor. Um lote grande que falha é um desastre.
3. **Maior flexibilidade:** Lotes pequenos permitem mudar de direção com mais frequência. Lotes grandes "travam" o time por mais tempo.
4. **Previsibilidade:** Lotes pequenos têm variabilidade menor. É mais fácil prever quando 5 itens pequenos estarão prontos do que 1 item enorme.
5. **Menor complexidade:** Itens pequenos são mais fáceis de entender, estimar e implementar. Itens grandes escondem complexidade.
6. **Fluxo mais suave:** No Kanban, lotes pequenos fluem mais rápido pelo quadro, reduzindo o lead time.

**Relação com histórias de usuário:**
- Histórias grandes (epics) = lote grande. Alta incerteza, difícil de estimar, risco de não terminar na Sprint.
- Histórias pequenas e bem decompostas = lote pequeno. Baixa incerteza, fácil de estimar, alta previsibilidade.
- A regra prática: se uma história é maior que metade da Sprint, deve ser decomposta.

**Explicação didática:**
Imagine uma lavanderia. Se você acumula roupa de um mês inteiro (lote grande), você passa o dia todo lavando e qualquer problema (máquina quebra, mancha) é um desastre. Se você lava a cada 2 dias (lote pequeno), cada lavada é rápida, problemas são pequenos e você sempre tem roupa limpa. No desenvolvimento de software, "lotes pequenos" significam pegar poucas histórias pequenas por vez, terminá-las e pegar mais — em vez de pegar muitas histórias grandes e descobrir no final que nada está pronto.

**Exemplo prático:**
**Lote grande (anti-pattern):**
Sprint com 1 história de 40 pontos: "Reescrever todo o módulo de pagamentos". Se a Sprint termina e a história não está pronta, *nada* foi entregue. Zero feedback. Velocity = 0.

**Lote pequeno (recomendado):**
Sprint com 8 histórias de 3-5 pontos cada: "Criar endpoint de pagamento", "Adicionar validação de cartão", "Implementar webhook de confirmação", etc. Se 6 terminam e 2 não, o time entregou 6 incrementos de valor. Feedback sobre 6 funcionalidades. Velocity = 24.

**Como o candidato deve responder:**
- Definir batch size como quantidade de trabalho por ciclo
- Citar pelo menos 4 vantagens de lotes menores
- Conectar com a decomposição de histórias
- Mencionar a relação com WIP limit no Kanban
- Dar exemplo prático contrastando lote grande e pequeno
- Evitar dizer que "lotes menores são sempre possíveis" (há limite prático)

**Resposta fraca ou incompleta:**
"Batch size é o tamanho das histórias. Histórias menores são melhores porque são mais fáceis." — Reduz o conceito a "histórias menores são mais fáceis" sem explicar os benefícios de fluxo, feedback, risco e previsibilidade. Batch size não é apenas sobre tamanho de histórias — é sobre a quantidade de trabalho em andamento.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que "lotes menores são melhores", mas não explica
- **2** — Define o conceito, mas cita apenas 1-2 vantagens
- **3** — Define e explica 4+ vantagens com exemplo
- **4** — Explica vantagens, conecta com histórias e WIP limit
- **5** — Domínio: explica o conceito, a economia de lotes, a relação com Lean, e como o batch size afeta lead time, feedback e risco

**Perguntas de aprofundamento:**
1. Qual é o "tamanho ideal" de uma história de usuário? Existe um número máximo de story points?
2. Como o conceito de batch size se aplica no Kanban vs. Scrum?
3. O que é a "Lei de Little" e como ela explica por que lotes menores reduzem o lead time?

---

### Pergunta 46 — Cenário: Dois POs para o mesmo produto

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Sua empresa tem um produto com 3 times Scrum trabalhando simultaneamente. A organização designou dois Product Owners para o produto — cada um responsável por uma "área" do produto. Isso funciona no Scrum? Quais são os problemas e como você lidaria com a situação?

**O que essa pergunta avalia:**
Avalia a compreensão do princípio de "um PO por produto" no Scrum, os problemas de múltiplos POs e a capacidade de propor soluções para produtos grandes.

**Resposta esperada:**
O Guia Scrum é claro: o Product Owner é **uma pessoa**, não um comitê. Para um produto, deve haver um PO que mantém a visão unificada e ordena o Product Backlog. Ter dois POs para o mesmo produto cria problemas estruturais.

**Problemas com dois POs:**
1. **Visão fragmentada:** Cada PO prioriza "sua área", mas ninguém garante que o conjunto agrega valor máximo.
2. **Conflito de prioridade:** Quando os times precisam de algo que está na "área" do outro PO, há dependência e atraso.
3. **Product Backlog dividido:** Tecnicamente há um Backlog, mas na prática cada PO cuida "do seu", criando dois Backlogs virtuais.
4. **Decisões inconsistentes:** Um PO pode priorizar performance enquanto o outro prioriza novas features — sem alinhamento.
5. **Confusão para os times:** Os developers não sabem quem é a autoridade final do produto.

**Como lidar:**

**Opção 1 — Um PO com deputies (recomendado):**
- Um PO é responsável por todo o produto e mantém a visão unificada
- Cada "área" tem um "Product Owner delegate" ou "Area Product Manager" que cuida do refinamento e detalhamento
- O PO final aprova prioridades e resolve conflitos

**Opção 2 — Produto dividido em produtos menores:**
- Se o produto é grande o suficiente, dividir em dois produtos independentes, cada um com seu PO e seu Backlog
- Ex: "Produto Pagamentos" e "Produto Logística" — cada um com seu PO, times e Backlog

**Opção 3 — Chief Product Owner:**
- Um "Chief PO" acima dos dois POs, responsável pela visão do produto completo
- Os dois POs reportam ao Chief PO e alinham prioridades

**Explicação didática:**
Imagine um navio com dois capitães, cada um responsável por "um lado do navio". Quando há uma tempestade, um quer ir para o norte e o outro para o sul. O navio vai em círculos. Um produto precisa de uma visão única — um capitão que olha o mapa inteiro e decide a rota. Se o navio é grande demais para um capitão, divida em dois navios, cada um com seu capitão e sua rota.

**Exemplo prático:**
Empresa com produto de e-commerce, 3 times e 2 POs:
- PO 1: "Área de vendas" (catálogo, busca, carrinho)
- PO 2: "Área de pós-venda" (logística, devoluções, suporte)

**Problema:** O time que trabalha em "checkout" depende do PO 1 (carrinho) e do PO 2 (rastreamento pós-compra). Quando o time precisa de decisão sobre prioridade entre "melhorar checkout" e "melhorar rastreamento", os dois POs discordam.

**Solução:** Nomear um Chief Product Owner que tem a visão do e-commerce completo. Os dois POs viram "Product Managers de área", refinam o Backlog, mas o Chief PO ordena a prioridade final e resolve conflitos.

**Como o candidato deve responder:**
- Explicar que o Scrum define um PO por produto
- Citar pelo menos 3 problemas com múltiplos POs
- Propor soluções (Chief PO, deputies, dividir produto)
- Explicar a diferença entre delegar e ter múltiplos POs
- Dar exemplo prático
- Evitar dizer que "dois POs funciona sem problemas"

**Resposta fraca ou incompleta:**
"Não tem problema, cada PO cuida da sua parte e os times seguem o PO da sua área." — Ignora os problemas de visão fragmentada, conflito de prioridade e dependências entre áreas. "Cada um na sua" não funciona quando o produto é um sistema integrado onde as áreas se conectam.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que "idealmente é um PO", mas não explica problemas
- **2** — Cita 1-2 problemas, mas não propõe solução
- **3** — Explica problemas e propõe pelo menos uma solução
- **4** — Explica problemas, propõe múltiplas soluções com prós e contras
- **5** — Domínio: explica o princípio do Scrum, os problemas, as soluções e como escalonar PO em produtos grandes

**Perguntas de aprofundamento:**
1. Um Product Owner pode ser "compartilhado" entre dois produtos diferentes?
2. O que é um "Product Owner comitê" e por que o Scrum proíbe?
3. Como organizar o Product Backlog quando há múltiplas áreas em um produto?

---

### Pergunta 47 — Conceito de Lead Time vs Throughput na prática

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
Você está gerenciando um time Kanban e percebe que o Throughput está estável (10 itens/semana), mas o Lead Time está aumentando. O que isso indica e o que você faria para investigar?

**O que essa pergunta avalia:**
Avalia a capacidade de analisar métricas Kanban em conjunto, identificar anomalias e propor investigação baseada em dados.

**Resposta esperada:**
Se o Throughput está estável mas o Lead Time está aumentando, significa que os itens estão demorando mais para ser entregues, mesmo que a *quantidade* entregue por semana não mudou. Isso parece contraditório, mas tem explicações:

**Possíveis causas:**

1. **Acúmulo na fila (To Do):** O Lead Time inclui tempo de fila. Se muitos itens entram no Backlog mas o time não os puxa rapidamente, o Lead Time aumenta mesmo com Throughput constante. O time entrega 10/semana, mas os itens ficam 3 semanas esperando na fila antes de começar.

2. **Aumento do WIP (Work in Progress):** Se o time está trabalhando com mais itens simultaneamente (WIP maior), cada item individual demora mais — mas o total entregue por semana não muda. É como ter 10 panelas no fogo: você cozinha a mesma quantidade de pratos por hora, mas cada prato demora mais porque você troca de panela o tempo todo.

3. **Itens mais complexos:** Se o mix de itens mudou (itens maiores e mais complexos), o time continua entregando 10 itens/semana, mas cada item demora mais tempo no fluxo. O Throughput é o mesmo, mas o Lead Time por item aumenta.

4. **Gargalo em uma etapa específica:** Uma coluna do Kanban (ex: "Testing") pode estar acumulando itens. O Throughput total não muda porque o gargalo regula o fluxo, mas cada item espera mais tempo na coluna de teste.

**Como investigar:**

1. **Medir Cycle Time separadamente:** Se o Cycle Time está estável mas o Lead Time aumenta, o problema é na fila (tempo antes de começar o trabalho).
2. **Analisar o Cumulative Flow Diagram (CFD):** O CFD mostra o acúmulo de itens em cada etapa ao longo do tempo. Se uma banda (camada) do CFD está se alargando, indica acúmulo.
3. **Verificar o WIP atual:** O WIP aumentou? Se sim, reduzir o WIP limit pode ajudar.
4. **Analisar o mix de itens:** Os itens ficaram maiores? Comparar o tamanho médio dos itens das últimas semanas.
5. **Olhar coluna por coluna:** Em qual coluna os itens passam mais tempo? Criar um Cycle Time scatter plot para visualizar.

**Explicação didática:**
Imagine uma fila de banco. O throughput é "quantos clientes são atendidos por hora" (ex: 10/hora). O lead time é "quanto tempo o cliente espera desde que entra na fila até ser atendido". Se o banco abre 2 guichês a menos, a fila fica mais longa — o lead time aumenta. Mas o throughput pode permanecer o mesmo se os caixas restantes atendem na mesma velocidade. O problema não é a velocidade do atendimento — é a fila de espera.

**Exemplo prático:**
Time com Throughput de 10 itens/semana:
- Janeiro: Lead Time = 5 dias (2 dias na fila + 3 dias de trabalho)
- Março: Lead Time = 9 dias (6 dias na fila + 3 dias de trabalho)

O Cycle Time permaneceu 3 dias — o trabalho em si não mudou. Mas o tempo de fila triplicou. Causa: o Backlog cresceu de 30 para 80 itens e o time não aumentou a frequência de replenishment. Solução: aumentar frequência de pull (puxar itens do Backlog com mais frequência) ou reduzir o tamanho do Backlog.

**Como o candidato deve responder:**
- Identificar que Lead Time aumentando com Throughput estável indica problema na fila ou WIP
- Citar pelo menos 3 possíveis causas
- Propor investigação com dados (Cycle Time, CFD, WIP)
- Mencionar a distinção entre fila e trabalho ativo
- Explicar a relação com a Lei de Little
- Evitar sugerir "trabalhar mais rápido" (não resolve o problema)

**Resposta fraca ou incompleta:**
"Se o Lead Time está aumentando, o time precisa trabalhar mais rápido para entregar mais itens." — Incorreto: o Throughput já está estável — o time está entregando a mesma quantidade. O problema não é velocidade de entrega, é o tempo que cada item espera. Trabalhar "mais rápido" não reduziria o tempo de fila.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica que algo está errado, mas não sabe o quê
- **2** — Sugere "trabalhar mais rápido" ou "aumentar throughput"
- **3** — Identifica que o problema é na fila ou WIP e propõe investigação
- **4** — Múltiplas causas, investigação com dados (CFD, Cycle Time), solução
- **5** — Domínio: explica a relação matemática entre WIP, Throughput e Lead Time (Lei de Little), propõe análise estruturada

**Perguntas de aprofundamento:**
1. O que é um Cumulative Flow Diagram (CFD) e como ele ajuda a identificar gargalos?
2. Se o time reduz o WIP limit, o que deve acontecer com o Lead Time e o Throughput?
3. Como distinguir entre "fila crescendo" e "trabalho ficando mais complexo"?

---

### Pergunta 48 — Conceito de "Pronto" no Kanban

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
No Scrum, a Definition of Done define o que significa "pronto". No Kanban, como o time define quando um item está realmente "done"? Existe um equivalente à DoD no Kanban?

**O que essa pergunta avalia:**
Avalia a compreensão de como o Kanban lida com a definição de "pronto" sem um artefato formal como a DoD do Scrum, e o conhecimento das "políticas explícitas" do Kanban.

**Resposta esperada:**
O Kanban não define um artefato formal chamado "Definition of Done" como o Scrum, mas a prática de **"Tornar as políticas explícitas"** (uma das seis práticas do Kanban) cumpre função semelhante.

**Como o Kanban define "pronto":**

1. **Políticas explícitas de fluxo:** O time define regras claras para quando um item pode se mover de uma coluna para outra. Por exemplo, um item só pode ir de "In Progress" para "Testing" se: tiver testes unitários passando, code review aprovado e documentação atualizada.

2. **Definition of Done no Kanban:** Muitos times Kanban adotam explicitamente uma DoD, mesmo que o Kanban não a exija formalmente. É uma boa prática. A diferença é que no Kanban, a DoD é parte das "políticas explícitas" do quadro.

3. **Critério de entrada e saída:** Cada coluna do quadro Kanban pode ter critérios de entrada (entry criteria) e critérios de saída (exit criteria). Os critérios de saída da última coluna antes de "Done" são, na prática, a Definition of Done.

**Exemplo de políticas explícitas em um quadro Kanban:**

| Coluna | Critério de Entrada | Critério de Saída |
|---|---|---|
| To Do | Priorizado pelo PO, descrição clara | Developer atribuído |
| In Progress | Descrição aceita, ambiente pronto | Código implementado, testes unitários passando |
| Testing | Testes unitários passando, deploy em homologação | Testes QA passando, sem bugs críticos |
| Done | Testes QA passando, code review aprovado, doc atualizada | — |

Os critérios de saída de "Testing" = critérios de entrada de "Done" = Definition of Done.

**Explicação didática:**
No Scrum, a DoD é um "contrato" separado que se aplica a todas as histórias. No Kanban, a DoD é embutida nas "regras da esteira" — cada estação da esteira tem critérios que definem quando um item pode avançar. É como uma linha de montagem onde cada estação tem um checklist de qualidade antes de passar o produto adiante.

**Exemplo prático:**
Um time Kanban define as seguintes políticas explícitas no quadro:
- "Um item só entra em 'In Progress' se tem critérios de aceitação escritos"
- "Um item só vai para 'Testing' se o desenvolvedor rodou os testes localmente e passaram"
- "Um item só vai para 'Done' se: (1) code review aprovado, (2) testes de integração passando, (3) sem bugs críticos, (4) documentação atualizada"

Esses critérios são escritos no quadro (físico ou digital) e visíveis para todos. Qualquer pessoa pode ver o que é necessário para um item ser considerado "pronto".

**Como o candidato deve responder:**
- Explicar que o Kanban não tem DoD formal, mas a substitui por políticas explícitas
- Mencionar que os critérios de saída/entrada das colunas funcionam como DoD
- Dar exemplo de políticas em um quadro Kanban
- Explicar que muitos times Kanban adotam explicitamente uma DoD
- Mencionar a prática "tornar as políticas explícitas"
- Evitar dizer que "Kanban não se preocupa com pronto"

**Resposta fraca ou incompleta:**
"No Kanban não tem Definition of Done, cada um faz como achar melhor." — Incorreto: embora o Kanban não tenha uma DoD formal como o Scrum, a prática de "tornar as políticas explícitas" garante que o time defina critérios claros. Dizer que "cada um faz como achar melhor" ignora essa prática fundamental.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que Kanban não tem DoD formal, mas não explica a alternativa
- **2** — Menciona "políticas", mas sem detalhar como funcionam
- **3** — Explica políticas explícitas como equivalente à DoD
- **4** — Explica com clareza, dá exemplo de critérios de entrada/saída
- **5** — Domínio: explica as políticas explícitas, conecta com as 6 práticas do Kanban e a diferença cultural com o Scrum

**Perguntas de aprofundamento:**
1. As políticas explícitas do Kanban podem mudar ao longo do tempo? Como?
2. O que acontece quando um time Kanban não tem políticas explícitas?
3. É possível usar DoD do Scrum em um time Kanban? Como adaptar?

---

### Pergunta 49 — Cenário: Sprint Goal não alcançada

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
O time não alcançou a Sprint Goal pela segunda Sprint consecutiva. A maioria das histórias ficou em "In Progress" no final. Como Scrum Master, como você abordaria a situação? Isso é necessariamente um problema?

**O que essa pergunta avalia:**
Avalia a postura diante de Sprints "fracassadas", a análise de causas e a capacidade de distinguir entre um problema sistêmico e uma variação natural.

**Resposta esperada:**

**Isso é necessariamente um problema?**
Não necessariamente. A Sprint Goal é um objetivo ambicioso, não uma garantia. Uma Sprint não alcançada de vez em quando pode ser normal em ambientes complexos. Mas *duas consecutivas* merecem investigação.

**Como abordar:**

1. **Não culpar o time:** A Sprint Goal não alcançada é um sintoma, não um crime. O SM não deve chegar com tom punitivo. O time provavelmente já está frustrado.

2. **Investigar na Retrospective:**
   - A Sprint Goal era realista? Foi definida pelo time ou imposta pelo PO?
   - Os itens foram bem refinados? Tinham critérios de aceitação claros?
   - Houve impedimentos que não foram resolvidos?
   - O time superestimou a capacity?
   - Houveram dependências externas que atrasaram?
   - O trabalho foi iniciado tarde porque o Planning foi ineficaz?

3. **Analisar padrões, não incidentes:**
   - Se foram 2 Sprints de um total de 10, é 20% — pode ser variabilidade natural.
   - Se foram 2 de 3, é 67% — há um problema sistêmico.
   - Olhar não só se a Goal foi alcançada, mas *quão perto* o time chegou.

4. **Ações concretas:**
   - Se a causa foi estimativa: planejar menos itens na próxima Sprint
   - Se a causa foi impedimento: resolver os impedimentos recorrentes primeiro
   - Se a causa foi refinamento: adicionar sessões de refinement e criar Definition of Ready
   - Se a causa foi Sprint Goal ambiciosa demais: negociar com o PO uma Goal mais realista
   - Se a causa foi WIP alto: limitar quantos itens estão em progresso simultaneamente

5. **Evitar "baixar a meta":** O objetivo não é tornar a Sprint Goal tão fácil que sempre seja alcançada. O objetivo é tornar a Sprint Goal *realista e desafiadora*. Uma Goal que sempre é alcançada pode estar baixa demais.

**Explicação didática:**
Imagine um time de futebol que perdeu dois jogos seguidos. O técnico não chega no vestiário gritando "vocês são péssimos". Ele analisa: o time criou chances mas não converteu? A defesa falhou? O time cansou no final? Houve lesões? Com base na análise, ajusta o treino. Perder dois jogos pode ser variabilidade; perder dez seguidos é crise.

**Exemplo prático:**
Retrospective após 2 Sprints sem Goal:
- "O que aconteceu?" → "O item de integração com a API do pagamento era mais complexo que estimamos."
- "Por que foi subestimado?" → "Não fizemos refinement suficiente e não conhecíamos a API."
- "O que faremos diferente?" → "A partir da próxima Sprint, itens que dependem de APIs externas devem ter um spike (investigação) antes de serem estimados."
- "A Sprint Goal era realista?" → "Era, mas baseada em estimativas ruins. A meta não estava errada; a estimativa estava."

**Como o candidato deve responder:**
- Não tratar como crise, mas investigar
- Mencionar a Retrospective como espaço de análise
- Diferenciar entre variabilidade natural e problema sistêmico
- Citar pelo menos 4 possíveis causas
- Propor ações concretas baseadas na causa
- Mencionar que a Sprint Goal deve ser desafiadora mas realista
- Evitar sugerir "baixar a meta" como solução padrão

**Resposta fraca ou incompleta:**
"Eu diria ao time para se esforçar mais na próxima Sprint e pegar menos histórias." — Abordagem punitiva e superficial. "Esforçar mais" não é uma solução técnica. "Pegar menos histórias" sem entender a causa pode não resolver — se a causa foi impedimento externo, pegar menos não ajuda. Não investiga causa raiz.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Vê como problema grave, mas não propõe solução
- **2** — Propõe "pegar menos" ou "esforçar mais", sem investigar
- **3** — Investiga na Retrospective, cita 3+ causas
- **4** — Abordagem completa: investigação, causas, ações, distinção entre normal e sistêmico
- **5** — Domínio: explica que Goal não alcançada não é falha em si, analisa padrão temporal, propõe ações baseadas em causa raiz e mantém a Goal desafiadora

**Perguntas de aprofundamento:**
1. Como diferenciar uma Sprint Goal ambiciosa de uma Sprint Goal irrealista?
2. O que é um "spike" e quando ele deve ser usado?
3. O que fazer se o PO insiste em uma Sprint Goal que o time acha irrealista?

---

### Pergunta 50 — Conceito de "Empirical Process Control"

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
O Scrum é baseado no "empirical process control" (controle empírico de processo). O que isso significa e como ele se diferencia do "defined process control" (controle definido de processo)? Por que isso importa para times ágeis?

**O que essa pergunta avalia:**
Avalia o entendimento da base teórica do Scrum — o controle empírico de processo — e a capacidade de diferenciá-lo do controle definido, explicando por que o Scrum escolheu a abordagem empírica.

**Resposta esperada:**

**Defined Process Control (controle definido):**
- O processo é **totalmente previsível** e **repetível**
- Cada passo é definido e sempre produz o mesmo resultado
- Adequado para problemas **determinísticos** (ex: linha de montagem de carros, receita de bolo)
- Pressupõe que todas as variáveis são conhecidas e controláveis
- Exemplo: linha de montagem industrial onde cada peça encaixa exatamente da mesma forma

**Empirical Process Control (controle empírico):**
- O processo é **imprevisível** e **complexo**
- O resultado não é totalmente determinístico
- Adequado para problemas **complexos** onde nem todas as variáveis são conhecidas
- Baseia-se em **observação frequente** e **adaptação**
- Requer transparência, inspeção e adaptação (os três pilares do Scrum)
- Exemplo: desenvolvimento de software, onde requisitos mudam, tecnologas evoluem, usuários se comportam de formas imprevisíveis

**Por que o Scrum escolheu o controle empírico:**
O desenvolvimento de software é inerentemente complexo e imprevisível:
- Requisitos mudam ao longo do tempo
- Tecnologias evoluem
- Usuários descobrem necessidades que não sabiam que tinham
- Integrações com sistemas externos são incertas
- Estimativas são imprecisas por natureza

Tentar controlar o desenvolvimento de software com um processo definido (como Waterfall, onde tudo é planejado no início e executado sem mudanças) é como tentar prever o clima 6 meses ahead — tecnicamente possível, mas praticamente impreciso.

**A diferença na prática:**

| Aspecto | Defined Process | Empirical Process |
|---|---|---|
| Planejamento | Completo no início | Incremental e adaptativo |
| Mudanças | Evitadas (são desvios) | Esperadas e absorvidas |
| Inspeção | No final | Frequente e contínua |
| Controle | Por processo rígido | Por inspeção e adaptação |
| Exemplo | Linha de montagem | Desenvolvimento de software |

**Explicação didática:**
Imagine cozinhar seguindo uma receita exata (defined process): se você seguir cada passo, o bolo sai como esperado. Agora imagine cozinhar sem receita, provando e ajustando (empirical process): você prova, sente que está sem sal, adiciona, prova de novo. O Scrum é o segundo: você não pode prever tudo, então inspeciona frequentemente e adapta. Tentar aplicar um processo definido ao desenvolvimento de software é como tentar fazer uma receita exata em uma cozinha onde os ingredientes mudam de sabor a cada dia.

**Exemplo prático:**
**Defined process (Waterfall):** Planejar todo o projeto de software em 6 meses de requisitos, depois 3 meses de design, depois 6 meses de programação, depois 2 meses de testes. Se os requisitos mudarem no meio, é "desvio de escopo" e precisa de mudança formal de contrato.

**Empirical process (Scrum):** A cada 2 semanas, o time entrega um Incremento, o PO e stakeholders inspecionam, dão feedback, e o Backlog é ajustado. Se os requisitos mudam, é absorvido na próxima Sprint. A imprevisibilidade é aceita e gerenciada, não negada.

**Como o candidato deve responder:**
- Definir ambos os conceitos com clareza
- Explicar a diferença fundamental (previsível vs. complexo)
- Mencionar por que o desenvolvimento de software é complexo
- Conectar com os três pilares do Scrum (transparência, inspeção, adaptação)
- Dar exemplo de cada abordagem
- Evitar dizer que "defined process é sempre ruim" (é adequado para problemas determinísticos)

**Resposta fraca ou incompleta:**
"Controle empírico é quando você aprende com a experiência em vez de seguir um plano." — Parcialmente correto, mas incompleto. Não explica a diferença com controle definido, não menciona que se baseia em transparência/inspeção/adaptação, e não explica *por que* o software é complexo. "Aprender com a experiência" é muito genérico.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "baseado em experiência", mas não explica
- **2** — Define um dos dois conceitos, mas não diferencia
- **3** — Define e diferencia os dois conceitos
- **4** — Explica com clareza, conecta com os pilares e dá exemplos
- **5** — Domínio: explica a teoria, por que o software é complexo (Cynefin), a conexão com os pilares e por que tentar controle definido no software falha

**Perguntas de aprofundamento:**
1. O que é o framework Cynefin e como ele se relaciona com controle empírico vs. definido?
2. Existem partes do desenvolvimento de software que se beneficiam de controle definido?
3. Como o controle empírico se manifesta nos eventos do Scrum (Planning, Daily, Review, Retrospective)?

---

## PARTE 5 — Perguntas 51 a 70

---

### Pergunta 51 — Anti-pattern: "Fake Scrum"

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
Muitas empresas dizem "fazemos Scrum", mas na prática apenas renomearam reuniões antigas com nomes ágeis: a reunião de status virou "Daily", o gerente de projetos virou "Scrum Master" e o cronograma mensal virou "Sprint". O que distingue um time que realmente pratica Scrum de um time que faz "Fake Scrum"?

**O que essa pergunta avalia:**
Avalia a capacidade de distinguir a adoção real do Scrum de uma adoção superficial de rótulos, identificando os elementos fundamentais que fazem o Scrum funcionar.

**Resposta esperada:**

| Elemento | Fake Scrum (rótulo) | Scrum real |
|---|---|---|
| Daily Scrum | Status report para o SM | Developers inspecionam e adaptam o plano |
| Scrum Master | Gerente de projetos disfarçado | Líder que serve, facilita, remove impedimentos |
| Sprint Planning | Gerente diz o que fazer | PO e Developers negociam Sprint Goal e capacidade |
| Sprint Review | Demo para mostrar "que trabalhamos" | Inspeção do Incremento com stakeholders, adapta Backlog |
| Retrospective | Reclamação sem ações | Identifica 1-2 melhorias acionáveis implementadas |
| Product Owner | "Aprovador" que assina requisitos | Decide prioridade, maximiza valor, mantém visão |
| Sprint Backlog | Lista de tarefas atribuídas pelo gerente | Plano dos Developers, auto-organizado |
| Definition of Done | Inexiste ou é ignorada | Acordo do time, aplicado consistentemente |
| Auto-organização | Inexiste — gerente atribui tarefas | Time decide como executar o trabalho |
| Mudanças na Sprint | Aceitas a qualquer momento sem negociação | Negociadas entre PO e Developers |

**Sinais de Fake Scrum:**
1. O Scrum Master atribui tarefas às pessoas
2. A Daily é um reporte de status para o SM
3. A Retrospective não gera ações implementadas
4. Não há Definition of Done
5. O PO não participa ativamente do refinamento
6. Stakeholders contornam o PO e vão direto ao time
7. O time não entende a Sprint Goal
8. Velocity é usada como meta de produtividade

**Explicação didática:**
Imagine alguém que compra roupas de ginástica, tênis de marca e uma garrafa de água, mas nunca corre. A aparência é de atleta, mas o comportamento não é. O "Fake Scrum" é exatamente isso: a empresa comprou os rótulos (nomes dos eventos, papéis), mas não adotou o comportamento (auto-organização, inspeção, adaptação, transparência).

**Exemplo prático:**
Uma empresa diz "fazemos Scrum com Sprints de 4 semanas". Mas: o "Scrum Master" é o antigo gerente de projetos que continua atribuindo tarefas. A "Daily" é uma reunião de 45 min onde cada um reporta ao gerente. A "Retrospective" existe mas nunca gerou mudança. O "Product Owner" é o gerente de TI que aprova requisitos em vez de priorizar valor. Não há DoD. Não há Sprint Goal. Isso é Fake Scrum — a forma sem a substância.

**Como o candidato deve responder:**
- Citar pelo menos 5-6 diferenças entre Fake Scrum e Scrum real
- Focar em comportamentos, não apenas em nomes
- Mencionar a ausência de auto-organização como sinal principal
- Explicar que a DoD e a Sprint Goal são frequentemente ausentes no Fake Scrum
- Mencionar que a Retrospective sem ações é um sinal forte
- Evitar dizer que "qualquer variação do Scrum é Fake Scrum" (adaptações são válidas desde que os princípios se mantenham)

**Resposta fraca ou incompleta:**
"Fake Scrum é quando o time não segue o Guia Scrum à risca." — Incorreto: o Scrum pode ser adaptado ao contexto. O que distingue Fake Scrum não é a rigidez em seguir o Guia, mas a ausência dos *princípios* — auto-organização, transparência, inspeção e adaptação. Um time que faz Daily de 20 min em vez de 15 não é Fake Scrum; um time que faz "Daily" de 45 min como status report para o gerente é.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que "existem empresas que fingem", mas não explica
- **2** — Cita 2-3 sinais, mas não diferencia comportamento de rótulo
- **3** — Cita 5+ sinais e explica a diferença entre forma e substância
- **4** — Explica com clareza, dá exemplos de cada anti-pattern e contrasta com o correto
- **5** — Domínio: explica os princípios fundamentais que faltam no Fake Scrum, conecta com os valores e pilares, e propõe como diagnosticar e corrigir

**Perguntas de aprofundamento:**
1. Uma empresa pode fazer Scrum "parcialmente" e ainda assim obter benefícios?
2. Como ajudar uma organização que faz Fake Scrum a evoluir para Scrum real?
3. Qual é o primeiro sinal que você procuraria para identificar Fake Scrum em uma empresa?

---

### Pergunta 52 — Conceito de "Done" vs "Done-Done"

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
Em alguns times ágeis, ouve-se a expressão "done-done" ou "pronto de verdade". O que isso significa e por que essa expressão surge? O que ela revela sobre a Definition of Done do time?

**O que essa pergunta avalia:**
Avalia a compreensão de um sintoma comum de DoD fraca ou inconsistente e a capacidade de identificar o problema subjacente.

**Resposta esperada:**
A expressão "done-done" surge quando um item é marcado como "done" mas *na verdade não está completo*. Significa que o time tem duas noções de "pronto":
1. **"Done" (primeiro):** O código foi escrito e "funciona na minha máquina"
2. **"Done-done" (segundo):** O código foi testado, revisado, integrado, documentado e está realmente pronto para ir para produção

**O que isso revela:**
- A Definition of Done **não existe** ou **não é aplicada consistentemente**
- Há critérios de "pronto" implícitos que não foram formalizados
- O time sabe que "done" não significa realmente pronto, mas não tem um acordo formal sobre o que é "pronto de verdade"

**Como resolver:**
1. **Formalizar a DoD:** Discutir e documentar todos os critérios que fazem um item ser realmente "pronto". Se o time sente que precisa de "done-done", os critérios do "done-done" devem ser incorporados à DoD.
2. **Eliminar o termo:** Se a DoD é completa, não há necessidade de "done-done" — há apenas "Done" (atende à DoD) ou "Not Done" (não atende).
3. **Investigar por que o "primeiro done" existe:** Se alguém marca um item como "done" sem ter terminado, por quê? Pressão? Falta de clareza? DoD desconhecida?

**Explicação didática:**
Imagine uma cozinha onde o cozinheiro diz "o prato está pronto" quando o coloca no prato, mas o garçom sabe que precisa perguntar "pronto-pronto?" — porque o cozinheiro às vezes esquece de decorar, de temperar ou de verificar a temperatura. Se a definição de "pronto" fosse clara (assado, temperado, decorado, na temperatura certa), não haveria necessidade de "pronto-pronto".

**Exemplo prático:**
Um developer marca uma história como "Done" no Jira. O PO pergunta: "está Done mesmo?" Developer: "O código está escrito, mas não testei em homologação." PO: "Então não está Done." O problema: a DoD do time inclui "testado em homologação", mas o developer ignorou. Se a DoD fosse visível, clara e acordada, não haveria ambiguidade.

**Como o candidato deve responder:**
- Explicar que "done-done" indica DoD fraca ou inexistente
- Mencionar que há critérios implícitos não formalizados
- Propor formalização e eliminação do termo
- Citar exemplos de critérios que costumam ficar no "done-done" (testes, review, deploy, documentação)
- Explicar que a expressão é um sintoma, não uma solução
- Evitar tratar "done-done" como uma prática aceitável

**Resposta fraca ou incompleta:**
"'Done-done' é quando a história está realmente pronta, não só codificada. É uma prática comum para garantir qualidade." — Normaliza o problema em vez de identificá-lo como sintoma. "Done-done" não é uma prática — é um indicador de que a DoD não funciona. Aceitar "done-done" como normal perpetua a ambiguidade.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que "done-done" existe, mas não explica o porquê
- **2** — Explica que significa "realmente pronto", mas não conecta com DoD
- **3** — Explica que é sintoma de DoD fraca e propõe formalização
- **4** — Explica com clareza, identifica causa, propõe solução e dá exemplo
- **5** — Domínio: explica o sintoma, a causa, a solução e como prevenir recorrência através de DoD visível e acordada

**Perguntas de aprofundamento:**
1. Se o time tem "done-done", a DoD é inútil ou incompleta?
2. Como garantir que todos os membros do time apliquem a DoD consistentemente?
3. A DoD pode incluir critérios que dependem de outros times (ex: deploy pela infra)?

---

### Pergunta 53 — Cenário: Velocity inflada artificialmente

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Você percebe que a velocity do time subiu de 25 para 45 pontos em poucas Sprints, mas a quantidade de funcionalidades entregues não aumentou proporcionalmente. Quais hipóteses você levantaria e como investigaria?

**O que essa pergunta avalia:**
Avalia a capacidade de identificar inflação artificial de estimativas e distinguir entre melhoria real de produtividade e manipulação de métricas.

**Resposta esperada:**

**Hipóteses:**

1. **Inflação de estimativas:** O time pode estar estimando itens com mais pontos do que antes. Se uma história que antes era 5 pontos agora é estimada como 8, a velocity sobe sem que mais trabalho seja feito. Isso pode ser inconsciente (o time aprendeu que estimar maior dá "mais margem") ou consciente (pressão para "aumentar a velocity").

2. **Decomposição excessiva:** O time pode estar decompondo histórias em itens menores do que antes. Se uma história de 8 pontos é dividida em 4 histórias de 3 pontos cada (12 pontos no total), a velocity aparenta aumentar, mas o trabalho é o mesmo.

3. **Pressão por "aumentar a velocity":** Se a liderança ou o PO cobra "mais pontos por Sprint", o time responde inflando estimativas — não entregando mais valor. Isso é um anti-pattern clássico.

4. **Mudança no mix de itens:** O time pode estar pegando histórias tecnicamente mais simples que valem mais pontos relativamente. Ou histórias com alto valor de negócio mas baixa complexidade.

5. **Relaxamento da DoD:** Se a DoD foi relaxada (ex: parou de exigir testes), itens são "completados" mais rápido, aumentando a velocity — mas a qualidade diminui.

**Como investigar:**
1. **Comparar estimativas históricas:** Pegar uma história de 5 pontos de 3 meses atrás e estimá-la novamente hoje. Se o time agora diz 8, há inflação.
2. **Verificar a DoD:** A DoD mudou? Critérios foram removidos?
3. **Contar itens entregues:** Quantas histórias são entregues por Sprint? Se a velocity subiu de 25 para 45 mas o número de histórias permaneceu ~8, há inflação.
4. **Comparar com stakeholders:** Perguntar ao PO "você sente que o time está entregando mais valor?" Se a resposta é não, a velocity não reflete produtividade real.
5. **Verificar se há pressão explícita:** O time foi cobrado para "aumentar a velocity"?

**Explicação didática:**
Imagine um aluno que antes tirava 6 com provas de 10 questões. Agora tira 9 — mas as provas continuam tendo 10 questões. Ou o aluno melhorou, ou as provas ficaram mais fáceis, ou a correção ficou mais branda. Precisamos investigar qual é a causa antes de comemorar. Velocity que sobe sem mais entregas é como notas que sobem sem mais aprendizado — a métrica foi manipulada, não a realidade.

**Exemplo prático:**
Análise das últimas 5 Sprints:
- Sprint 1: 8 histórias, 25 pontos, 8 features em produção
- Sprint 3: 8 histórias, 35 pontos, 8 features em produção
- Sprint 5: 8 histórias, 45 pontos, 8 features em produção

Mesma quantidade de histórias e features, mas pontos quase dobraram. Conclusão: as estimativas foram infladas. O time confirma: "começamos a estimar maior porque o PO cobrava mais pontos." Solução: reestimar histórias de referência e recalibrar a baseline.

**Como o candidato deve responder:**
- Citar pelo menos 4 hipóteses para o aumento
- Propor investigação com dados (contar itens, comparar estimativas, verificar DoD)
- Mencionar que velocity não deve ser usada como meta
- Explicar que inflação de estimativas é um anti-pattern causado por pressão
- Verificar com o PO se o valor entregue aumentou
- Evitar assumir que "mais velocity é sempre bom"

**Resposta fraca ou incompleta:**
"A velocity subiu, o time está mais produtivo. Isso é bom." — Aceita a métrica sem questionar. Se a velocity subiu mas as entregas não aumentaram, algo está errado. Aceitar cegamente uma métrica que pode estar manipulada demonstra falta de senso crítico.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica que algo está estranho, mas não explica
- **2** — Menciona "estimar maior", mas não propõe investigação
- **3** — Cita 3+ hipóteses e propõe formas de investigar
- **4** — Múltiplas hipóteses, investigação com dados, verifica DoD e PO
- **5** — Domínio: explica as causas, a investigação, o perigo de usar velocity como meta e como recalibrar estimativas

**Perguntas de aprofundamento:**
1. Como evitar que a pressão por "mais velocity" leve à inflação de estimativas?
2. Velocity deve ser uma meta ou uma observação? Por quê?
3. Como reestimar um Backlog inteiro se percebe que as estimativas estão infladas?

---

### Pergunta 54 — Conceito de "Pull System" vs "Push System"

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
O Kanban é descrito como um "sistema pull". O que isso significa e como ele se diferencia de um "sistema push"? Dê exemplos de cada um no contexto de desenvolvimento de software.

**O que essa pergunta avalia:**
Avalia o entendimento de um conceito fundamental do Kanban e do Lean — a diferença entre puxar e empurrar trabalho — e a capacidade de aplicá-lo ao contexto de software.

**Resposta esperada:**

**Sistema Push (empurrar):**
O trabalho é *atribuído* ou *empurrado* para o time independentemente de sua capacidade atual. Exemplo: um gerente atribui 10 tarefas a um developer, mesmo que ele já tem 5 em andamento. O trabalho entra no sistema baseado na demanda, não na capacidade.

**Sistema Pull (puxar):**
O time *puxa* novo trabalho apenas quando tem capacidade para fazê-lo. O trabalho entra no sistema baseado na capacidade disponível, não na demanda. O WIP limit garante que o time só puxe um novo item quando termina um que está em andamento.

**Diferenças:**

| Aspecto | Push | Pull |
|---|---|---|
| Gatilho de entrada | Demanda (alguém "empurra") | Capacidade (time "puxa") |
| Controle de WIP | Não há limite explícito | WIP limit explícito |
| Risco de sobrecarga | Alto — trabalho acumula | Baixo — respeito à capacidade |
| Fluxo | Irregular, com picos | Suave e contínuo |
| Visibilidade de gargalo | Gargalos ocultos pelo acúmulo | Gargalos visíveis pelo WIP limit |

**Exemplos no desenvolvimento de software:**

**Push:** Um gerente de projetos cria 20 tickets e os atribui a 3 developers no início da semana. Cada developer tem 6-7 tickets. Se um developer termina mais rápido, não há mecanismo para redistribuir. Se um developer trava, os tickets acumulam.

**Pull (Kanban):** O quadro tem WIP limit de 3 em "In Progress". Um developer termina um item (move para "Testing") e *puxa* o próximo item do "To Do". Se o WIP limit está atingido, ninguém pega mais um item até que um seja concluído. O time respeita sua capacidade real.

**Scrum como pull parcial:** No Scrum, o Sprint Planning funciona como um mecanismo de pull: os Developers *escolhem* quantos itens pegar, baseado em sua capacity. Mas durante a Sprint, o Sprint Backlog é relativamente fixo (não é um pull contínuo como no Kanban).

**Explicação didática:**
Imagine um restaurante self-service (push) onde o cozinheiro coloca comida no seu prato independente de você ter terminado — a comida acumula e esfria. Agora imagine um rodízio (pull) onde o garçom só traz mais carne quando você termina a que está no prato — você come na sua velocidade e a comida está sempre fresca. O sistema pull respeita a capacidade de consumo; o push ignora.

**Exemplo prático:**
**Push:** Stakeholders criam 30 tickets no Jira na segunda-feira. O time "deve" fazer todos na semana. Trabalho acumula, lead time explode, qualidade cai.

**Pull:** O time Kanban tem WIP limit de 4. Há 30 tickets no Backlog, mas o time só puxa 4 para "In Progress". Quando um termina, puxa o próximo prioritário. Se um ticket é urgente, entra no lugar de outro (respeitando o WIP). O fluxo é controlado e previsível.

**Como o candidato deve responder:**
- Definir pull e push com clareza
- Explicar que pull respeita capacidade, push ignora
- Mencionar WIP limit como mecanismo do pull
- Dar exemplo de cada um no contexto de software
- Mencionar que o Scrum tem elementos de pull (Sprint Planning)
- Evitar confundir pull com "fazer menos trabalho"

**Resposta fraca ou incompleta:**
"Pull é quando o time pega o trabalho quando quer. Push é quando alguém manda." — Superficial: não explica que o pull é baseado em *capacidade* (não em "quando quer"), não menciona WIP limit, e não dá exemplos de software.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que "pull é puxar, push é empurrar", mas não explica
- **2** — Define os conceitos, mas sem WIP limit ou exemplos
- **3** — Define, diferencia e dá exemplos de cada
- **4** — Explica com clareza, menciona WIP limit, exemplos de software e elementos de pull no Scrum
- **5** — Domínio: explica pull/push, WIP como mecanismo, a origem Lean (kanban cards da Toyota) e como o pull melhora fluxo e reduz gargalos

**Perguntas de aprofundamento:**
1. O Scrum é totalmente push ou totalmente pull? Em quais momentos ele é cada um?
2. O que acontece quando um sistema pull recebe mais demanda do que consegue processar?
3. Como um time pode migrar de um modelo push para um modelo pull?

---

### Pergunta 55 — Cenário: Time que não melhora apesar das Retrospectives

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Você é Scrum Master de um time que faz Retrospectives há 6 meses. As ações identificadas são sempre as mesmas: "melhorar comunicação", "refinar melhor o backlog", "fazer mais testes". Nada muda de uma Sprint para outra. Como você diagnosticaria e resolveria esse problema?

**O que essa pergunta avalia:**
Avalia a capacidade de identificar por que as Retrospectives não geram melhoria e de propor soluções estruturais para torná-las eficazes.

**Resposta esperada:**

**Diagnóstico — por que nada muda:**

1. **Ações genéricas demais:** "Melhorar comunicação" não é uma ação — é uma aspiração. Uma ação acionável seria "fazer pair programming nas terças e quintas para melhorar comunicação técnica".

2. **Sem dono e sem prazo:** Se uma ação não tem um responsável e um prazo, ela não é implementada. "Vamos melhorar os testes" — quem? Quando? Como?

3. **Sem acompanhamento:** Se as ações da Retrospective anterior não são revisadas no início da próxima, não há accountability. O time esquece o que combinou.

4. **Muitas ações de uma vez:** O time identifica 10 melhorias e tenta fazer todas. Nenhuma é implementada porque o esforço se dilui.

5. **Ações fora do controle do time:** "O PO precisa estar mais disponível" — o time não controla a agenda do PO. A ação deve ser algo que o time pode fazer, não algo que depende de terceiros.

6. **Falta de segurança psicológica:** O time identifica problemas superficiais porque não se sente seguro para falar sobre problemas reais (conflitos interpessoais, falta de competência, pressão da gestão).

**Soluções:**

1. **Ações SMART:** Cada ação deve ser Específica, Mensurável, Alcançável, Relevante e Temporal. "Melhorar testes" → "Atingir 70% de cobertura de testes no módulo X até o final da Sprint 8, com João como responsável".

2. **Máximo 2 ações por Retrospective:** Focar em 1-2 melhorias por Sprint. Melhor implementar 1 mudança real que 10 promessas vazias.

3. **Revisar ações anteriores:** Os primeiros 10 min de cada Retrospective são para revisar: "Implementamos as ações da última Retros? Funcionou? Se não, por quê?"

4. **Dar ownership:** Cada ação tem um dono — não o SM, mas um Developer. O dono é responsável por implementar a ação e reportar na próxima Retros.

5. **Visibilizar as ações:** Criar um quadro de "Ações de Melhoria" que fica visível no ambiente do time (físico ou digital). O que é visível é lembrado.

6. **Variar o formato:** Se as mesmas questões surgem toda Sprint, o formato pode estar estagnado. Usar formatos como Sailboat, 4Ls, Mad/Sad/Glad para gerar novas perspectivas.

**Explicação didática:**
Imagine um paciente que vai ao médico todo mês com os mesmos sintomas. O médico diz "coma melhor, exercite-se, durma mais" — e o paciente nunca segue. O problema não é o diagnóstico — é que a "receita" é genérica demais. "Coma melhor" precisa virar "coma 3 porções de vegetais por dia, começa segunda-feira, anote no diário". Sem especificidade, sem dono e sem acompanhamento, nada muda.

**Exemplo prático:**
**Antes (ação vaga):**
- "Melhorar comunicação" → nunca implementada

**Depois (ação SMART):**
- **Ação:** "Fazer code review em pares por 30 min às terças e quintas"
- **Dono:** Maria
- **Prazo:** Começa na Sprint 8
- **Métrica:** 100% das histórias com code review registrado
- **Revisão:** Na Sprint Retrospective da Sprint 9, verificar se foi implementado

**Como o candidato deve responder:**
- Diagnosticar pelo menos 4 causas de ineficácia
- Propor ações SMART com dono e prazo
- Mencionar revisão de ações anteriores
- Limitar a 1-2 ações por Sprint
- Visibilizar as ações
- Variar formatos
- Evitar sugerir "cobrar mais do time"

**Resposta fraca ou incompleta:**
"Eu cobraria do time que implementem as ações. Se não implementam, é porque não estão levando a sério." — Abordagem punitiva. O problema geralmente não é "falta de seriedade" — é que as ações são vagas demais, não têm dono, não são revisadas. Cobrar resultados sem estruturar o processo gera mais frustração, não mais melhoria.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica o problema, mas não propõe solução
- **2** — Propõe "cobrar mais" ou "ser mais rigoroso"
- **3** — Diagnostica causas e propõe ações SMART
- **4** — Diagnóstico completo, ações SMART, revisão, visibilização, limitação
- **5** — Domínio: diagnóstico de causas, plano estruturado, formato variado, accountability, conexão com melhoria contínua (Kaizen)

**Perguntas de aprofundamento:**
1. O que fazer quando o dono da ação não a implementa?
2. Como medir se as ações da Retrospective estão melhorando o time?
3. A Retrospective deve focar no processo ou também em relações interpessoais?

---

### Pergunta 56 — Conceito de "Spillover" no Scrum

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
O que é "spillover" no contexto do Scrum e por que ele ocorre? Um time deve evitar spillover a todo custo ou é aceitável em algumas situações?

**O que essa pergunta avalia:**
Avalia o entendimento de um fenômeno comum no Scrum — itens não concluídos que "transbordam" para a próxima Sprint — e a postura do time diante disso.

**Resposta esperada:**
**Spillover** é quando um item do Sprint Backlog não é concluído até o final da Sprint e "transborda" para a próxima. O item volta ao Product Backlog e pode ser selecionado novamente na próxima Sprint Planning.

**Por que ocorre:**
1. **Subestimação:** O item era maior do que o time imaginou
2. **Impedimentos:** Algo bloqueou o trabalho durante a Sprint
3. **Dependências externas:** O time dependia de outro time ou serviço que não entregou a tempo
4. **Itens mal refinados:** O item chegou ao Planning sem detalhes suficientes
5. **Escopo da Sprint excessivo:** O time pegou mais trabalho do que a capacity permitia
6. **Complexidade imprevista:** O item revelou-se tecnicamente mais complexo que o esperado

**É aceitável?**
Spillover **ocasional** é normal e esperado — o desenvolvimento de software é complexo e imprevisível. Um item que transborda de vez em quando não é motivo de alarme.

Spillover **frequente e sistemático** é um problema:
- Indica que o time está superestimando consistentemente
- Pode significar que o refinamento é insuficiente
- Pode indicar impedimentos crônicos não resolvidos
- Reduz a previsibilidade das entregas

**Como gerenciar:**
1. **Não contar spillover na velocity:** Se um item de 8 pontos não foi concluído na Sprint 5 e transborda para a Sprint 6, ele conta na velocity da Sprint 6 (quando é concluído), não da Sprint 5. Contar nos dois infla a velocity.
2. **Investigar na Retrospective:** Se o spillover é frequente, discutir causas raiz
3. **Decompor histórias grandes:** Histórias menores têm menos risco de spillover
4. **Melhorar refinamento:** Itens bem detalhados são estimados com mais precisão
5. **Reavaliar items que transbordaram:** O PO deve decidir se o item ainda é prioritário. Pode ser que a prioridade mudou e o item não precisa mais ser feito.

**Explicação didática:**
Imagine que você planeja cozinhar 5 pratos para um jantar. No final da noite, 4 estão prontos e 1 ficou pela metade. Esse prato "transborda" para o dia seguinte. Se isso acontece uma vez, é normal — algo deu errado com aquele prato. Se acontece todo jantar, você está planejando mal: ou pegando pratos demais, ou pratos que não conhece bem.

**Exemplo prático:**
Sprint 5: 8 histórias planejadas (40 pontos). 7 concluídas (32 pontos). 1 história de 8 pontos (integração com API externa) não foi concluída — a API tinha mais complexidade que o esperado.

- A história volta para o Product Backlog
- O PO decide: ainda é prioritária? Sim.
- Na Sprint Planning 6, a história é reestimada (agora 5 pontos, porque parte do trabalho já foi feita) e selecionada novamente
- A velocity da Sprint 5 é 32 (não 40), a velocity da Sprint 6 incluirá os 5 pontos quando a história for concluída

**Como o candidato deve responder:**
- Definir spillover corretamente
- Explicar pelo menos 4 causas
- Diferenciar entre spillover ocasional (normal) e frequente (problema)
- Explicar como tratar na velocity (contar apenas quando concluído)
- Mencionar que o PO reavalia a prioridade do item
- Evitar sugerir que spillover deve ser "evitado a todo custo" (isso pode levar a pegar menos trabalho ou relaxar a DoD)

**Resposta fraca ou incompleta:**
"Spillover é ruim e deve ser evitado. Se o time não terminou, deveria ter planejado melhor." — Abordagem punitiva e irrealista. Spillover ocasional é normal em ambientes complexos. Dizer "deveria ter planejado melhor" ignora a imprevisibilidade inerente ao desenvolvimento de software e não propõe solução.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "quando não termina", mas não explica
- **2** — Define spillover, mas não diferencia ocasional de frequente
- **3** — Define, explica causas e diferencia normal de problemático
- **4** — Explica causas, tratamento na velocity, reavaliação do PO e prevenção
- **5** — Domínio: explica o conceito, as causas, o tratamento, a diferenciação entre variabilidade natural e sistêmica, e como o spillover afeta a previsibilidade

**Perguntas de aprofundamento:**
1. Se um item transborda 3 Sprints seguidas, o que isso indica?
2. O time deve reestimar um item que transbordou ou manter a estimativa original?
3. Como o spillover afeta a confiança dos stakeholders no time?

---

### Pergunta 57 — Conceito de "Work Item Age" no Kanban

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
No Kanban, além do Lead Time e do Cycle Time, existe uma métrica chamada "Work Item Age" (idade do item de trabalho). O que ela mede e por que é útil no dia a dia do time?

**O que essa pergunta avalia:**
Avalia o conhecimento de uma métrica Kanban menos conhecida mas muito prática, que complementa o conjunto de métricas de fluxo.

**Resposta esperada:**
**Work Item Age** mede quanto tempo um item *específico* está em andamento — desde o momento em que entrou no fluxo de trabalho (saiu de "To Do" e entrou em "In Progress") até o momento atual (ainda não está em "Done").

**Diferença das outras métricas:**

| Métrica | Quando mede | Status do item |
|---|---|---|
| Lead Time | Pedido → Entrega | Concluído |
| Cycle Time | Início do trabalho → Entrega | Concluído |
| Work Item Age | Início do trabalho → Agora | Em andamento |

**Por que é útil:**
1. **Identifica itens "presos":** Se um item está em "In Progress" há 12 dias e a média de Cycle Time é 4 dias, algo está errado com aquele item. O Work Item Age chama atenção para itens que estão demorando mais do que o normal.
2. **Prevende atrasos:** Antes que um item atrase o Lead Time, o Work Item Age alerta que o item está demorando mais que a média — permitindo intervenção proativa.
3. **Ajuda na Daily:** Em vez de "o que você está fazendo?", a pergunta pode ser "este item está há 7 dias em In Progress, e nosso Cycle Time médio é 4. O que está acontecendo?"
4. **Prioriza atenção:** O time pode olhar o quadro e identificar os itens mais "velhos" — esses merecem atenção imediata.

**Como usar na prática:**
- Adicionar a data de início do trabalho em cada card do quadro Kanban
- Calcular a idade do item diariamente (data atual - data de início)
- Comparar com o Cycle Time médio: se a idade > 1.5x o Cycle Time médio, investigar
- Na Daily, focar primeiro nos itens com maior Work Item Age

**Explicação didática:**
Imagine um hospital onde cada paciente tem um cartão com a hora de entrada. Se um paciente está na sala de espera há 3 horas e a média de atendimento é 1 hora, o cartão (Work Item Age) alerta a equipe: "este paciente está esperando demais". Sem essa métrica, o paciente pode ser esquecido. Com ela, a equipe prioriza quem está esperando há mais tempo.

**Exemplo prático:**
Quadro Kanban com 4 itens em "In Progress":
- Item A: em andamento há 2 dias (Cycle Time médio é 4 dias) — no prazo
- Item B: em andamento há 5 dias — um pouco acima da média
- Item C: em andamento há 9 dias — bem acima da média, investigar
- Item D: em andamento há 12 dias — criticamente acima, precisa de intervenção

Na Daily, o time foca primeiro no Item D: "o que está bloqueando? Precisamos de ajuda?" antes de discutir o Item A que está no prazo.

**Como o candidato deve responder:**
- Definir Work Item Age como tempo desde o início do trabalho até agora
- Explicar a diferença para Lead Time e Cycle Time (mede itens em andamento, não concluídos)
- Citar pelo menos 3 utilidades práticas
- Dar exemplo de aplicação na Daily
- Mencionar a comparação com o Cycle Time médio
- Evitar confundir com Lead Time ou Cycle Time

**Resposta fraca ou incompleta:**
"Work Item Age é quanto tempo o item está no quadro." — Impreciso: "no quadro" inclui o tempo em "To Do" (Backlog). Work Item Age mede desde que o trabalho *começou* (entrou em In Progress), não desde que o item foi criado no quadro.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "tempo do item", mas não explica
- **2** — Define, mas confunde com Cycle Time ou Lead Time
- **3** — Define corretamente e explica 2+ utilidades
- **4** — Explica com clareza, diferencia das outras métricas e dá exemplo prático
- **5** — Domínio: explica a métrica, a diferença das outras, o uso na Daily e como complementa o conjunto de métricas de fluxo

**Perguntas de aprofundamento:**
1. Como implementar o rastreamento de Work Item Age em uma ferramenta como Jira?
2. Qual é a relação entre Work Item Age e a identificação de gargalos?
3. Work Item Age faz sentido no Scrum ou é exclusivo do Kanban?

---

### Pergunta 58 — Cenário: Product Backlog desorganizado

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Você assume como Scrum Master de um time cujo Product Backlog tem 300 itens, sem ordem clara de prioridade, sem estimativas na maioria dos itens, com descrições vagas e vários itens duplicados ou obsoletos. O PO diz "são todos importantes". Como você ajudaria a organizar esse Backlog?

**O que essa pergunta avalia:**
Avalia a capacidade de diagnóstico e remediação de um Product Backlog caótico e a habilidade de trabalhar com um PO que não prioriza.

**Resposta esperada:**

**Diagnóstico:**
Um Backlog com 300 itens sem prioridade é um Backlog que não funciona. Se "tudo é importante", nada é prioritário. O time não sabe no que trabalhar primeiro e o PO não consegue tomar decisões.

**Plano de remediação:**

1. **Limpeza inicial (1-2 sessões):**
   - **Remover duplicados:** Itens que descrevem a mesma funcionalidade são mesclados
   - **Remover obsoletos:** Itens que não fazem mais sentido (mudança de estratégia, feature cancelada)
   - **Remover "nice to haves":** Itens que há mais de 6 meses não foram priorizados provavelmente nunca serão. Movê-los para um "Backlog parking lot" (não apagar, mas remover do Backlog ativo)

2. **Ajuda o PO a priorizar:**
   - Perguntar: "Se o time só pudesse entregar 1 item, qual seria? E o segundo? E o terceiro?"
   - Usar técnica MoSCoW: Must have, Should have, Could have, Won't have
   - Explicar que "todos são importantes" não é priorização — é falta de priorização
   - Usar a pergunta "o que gera mais valor para o usuário/negócio?"

3. **Categorizar e estimar (3-4 sessões de refinement):**
   - Agrupar itens por tema/área
   - Estimar os top 20-30 itens (os mais prioritários) — não precisa estimar todos os 300
   - Detalhar os top 10-15 com critérios de aceitação

4. **Aplicar a "regra do topo":**
   - Os itens no topo do Backlog (próximas 2-3 Sprints) devem estar detalhados e estimados
   - Itens do meio podem ter descrição média
   - Itens do fundo podem ter apenas um título — serão detalhados quando subirem

5. **Estabelecer rotina de refinement:**
   - Sessões regulares de refinement (5-10% da capacity)
   - A cada refinement, o PO prioriza e o time detalha os itens do topo
   - Backlog é "vivo" — muda a cada Sprint

6. **Reduzir o Backlog:**
   - Um Backlog de 300 itens é difícil de gerenciar. O objetivo é reduzir para ~50-100 itens ativos, com o restante em um "frozen backlog" que pode ser revisitado trimestralmente

**Explicação didática:**
Imagine uma biblioteca onde todos os livros estão jogados no chão, sem ordem, sem catalogação. Se você precisa de um livro específico, demora horas para achar. A solução não é "ler todos os livros" — é organizá-los por categoria, colocar os mais procurados na frente e catalogar o resto. O Backlog caótico é a biblioteca desorganizada; o refinement é o processo de catalogação contínua.

**Exemplo prático:**
**Sessão 1:** Limpeza — dos 300 itens, 40 são duplicados, 60 são obsoletos, 50 são "nice to have" há mais de 6 meses. Backlog reduzido para 150 itens ativos.

**Sessão 2:** Priorização — o PO classifica os 150 em Must (30), Should (50), Could (50), Won't (20). A lista é reordenada: Must no topo, Should no meio, Could abaixo, Won't movido para o parking lot.

**Sessões 3-5:** Refinement dos top 30 (Must) — descrições detalhadas, critérios de aceitação, estimativas com Planning Poker.

Resultado: Backlog de 80 itens ativos, com os top 30 prontos para Sprint Planning. Os 150 restantes estão no parking lot para revisão trimestral.

**Como o candidato deve responder:**
- Diagnosticar o problema (tudo é importante = nada é prioritário)
- Propor limpeza inicial (duplicados, obsoletos)
- Ajudar o PO a priorizar (MoSCoW, pergunta de valor)
- Mencionar a regra do topo (detalhar apenas o que vai entrar em breve)
- Estabelecer rotina de refinement
- Reduzir o tamanho do Backlog ativo
- Evitar sugerir "estimar todos os 300 itens"

**Resposta fraca ou incompleta:**
"Eu pediria ao PO para priorizar os 300 itens do mais importante ao menos importante." — Impraticável: priorizar 300 itens individualmente é exaustivo e ineficiente. A abordagem correta é primeiro limpar (remover o que não serve), depois agrupar por categoria (MoSCoW) e detalhar apenas o topo.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica o problema, mas não propõe plano
- **2** — Propõe "pedir ao PO para priorizar", sem estratégia
- **3** — Propõe limpeza, priorização e refinement com estratégia
- **4** — Plano detalhado com sessões, técnicas (MoSCoW) e redução do Backlog
- **5** — Domínio: diagnóstico, plano estruturado em fases, técnicas de priorização, regra do topo, rotina de refinement e parking lot

**Perguntas de aprofundamento:**
1. Como lidar com um PO que se recusa a priorizar e insiste que "tudo é urgente"?
2. O que é "Backlog grooming" vs "Backlog refinement"? Há diferença?
3. Itens no parking lot devem ser apagados eventualmente?

---

### Pergunta 59 — Conceito de "Cycle Time Scatter Plot"

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é um Cycle Time Scatter Plot no Kanban e que informações ele revela que um simples gráfico de Lead Time médio não mostra? Como um time pode usá-lo para melhorar?

**O que essa pergunta avalia:**
Avalia o conhecimento de uma ferramenta analítica avançada do Kanban e a capacidade de interpretar dispersão de dados em vez de apenas médias.

**Resposta esperada:**
O **Cycle Time Scatter Plot** é um gráfico onde cada ponto representa um item concluído. O eixo X é a data de conclusão e o eixo Y é o Cycle Time (ou Lead Time) daquele item. Cada item é um ponto — você vê a distribuição real dos tempos, não apenas a média.

**O que revela que a média não mostra:**
1. **Variabilidade:** A média pode ser 5 dias, mas alguns itens levam 2 dias e outros 15. A variabilidade é tão importante quanto a média — um time com Cycle Time médio de 5 dias mas com variância de 1-20 é menos previsível que um time com média de 7 e variância de 5-9.
2. **Outliers:** Itens que demoraram muito mais que a média. Esses outliers merecem investigação — o que aconteceu com aquele item específico?
3. **Tendência:** Se os pontos estão subindo ao longo do tempo, o Cycle Time está piorando. Se estão descendo, está melhorando.
4. **Percentis:** Em vez de usar a média, usar percentis (ex: "85% dos itens são concluídos em 8 dias ou menos") — mais útil para previsão que a média, que é distorcida por outliers.

**Como usar para melhorar:**
1. **Investigar outliers:** Pegar os 3-5 itens com maior Cycle Time e perguntar "por que estes demoraram tanto?" — causa raiz pode revelar problemas sistêmicos.
2. **Reduzir variabilidade:** Se a variabilidade é alta, o time não consegue prever entregas. Reduzir WIP ou decompor itens grandes pode ajudar.
3. **Usar percentis para previsão:** "Há 85% de chance de que o próximo item seja concluído em 10 dias ou menos" — mais honesto que "a média é 5 dias".
4. **Identificar padrões:** Itens de um tipo específico (ex: bugs) podem consistentemente demorar mais. Separar por tipo de trabalho e analisar separadamente.

**Explicação didática:**
Imagine que você quer saber quanto tempo leva para chegar ao trabalho. A média é 30 minutos. Mas alguns dias leva 15 (sem trânsito) e outros 60 (acidente na via). Se você diz "30 minutos" para alguém esperando você, na metade dos dias você chega atrasado. O Scatter Plot mostra todos os dias como pontos — você vê que a maioria está entre 20-35, mas há outliers em 50-60. Com isso, você pode dizer "chego em 35 minutos 85% das vezes" — previsão mais honesta.

**Exemplo prático:**
Scatter Plot dos últimos 50 itens:
- Maioria dos pontos entre 3-6 dias (Cycle Time)
- 5 pontos entre 10-15 dias (outliers)
- Tendência: pontos subindo levemente nos últimos 20 itens

Análise:
- "Por que os 5 outliers demoraram 10+ dias?" → Eram itens que dependiam de aprovação externa
- "Por que a tendência está subindo?" → O time aumentou o WIP recentemente
- Previsão: "85% dos itens são concluídos em 7 dias ou menos" (percentil 85)

**Como o candidato deve responder:**
- Explicar que o Scatter Plot mostra cada item individualmente
- Explicar que a média esconde variabilidade e outliers
- Mencionar pelo menos 3 informações que o Scatter Plot revela
- Explicar o uso de percentis para previsão
- Mencionar a investigação de outliers
- Evitar confundir com Burndown ou Cumulative Flow Diagram

**Resposta fraca ou incompleta:**
"É um gráfico que mostra o tempo dos itens. A média já diz tudo o que precisa." — Incorreto: a média não diz tudo. A média esconde variabilidade, outliers e tendências. Um time com média de 5 dias mas com itens que variam de 1 a 20 dias é muito menos previsível que um com média de 7 mas variando entre 5 e 9.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "um gráfico de tempos", mas não explica
- **2** — Define o gráfico, mas não explica vantagens sobre a média
- **3** — Define, explica 3+ vantagens e menciona percentis
- **4** — Explica com clareza, menciona outliers, tendência, percentis e exemplos
- **5** — Domínio: explica o gráfico, a diferença entre média e percentis, a análise de outliers e como o time usa para melhorar previsibilidade

**Perguntas de aprofundamento:**
1. Por que o percentil 85 é mais útil que a média para previsão?
2. Como separar diferentes tipos de trabalho no Scatter Plot (ex: bugs vs features)?
3. O que é "forecasting" baseado em Cycle Time e como ele difere de usar a velocity?

---

### Pergunta 60 — Conceito de "Swarming" no Kanban

**Nível:** Júnior
**Categoria:** Prática

**Pergunta do entrevistador:**
No Kanban, existe uma prática chamada "swarming". O que é, quando é usada e como ela se relaciona com o WIP limit?

**O que essa pergunta avalia:**
Avalia o conhecimento de uma técnica prática de Kanban para resolver gargalos e a compreensão de como o time colabora para manter o fluxo.

**Resposta esperada:**
**Swarming** é a prática onde múltiplos membros do time "convergem" (como um enxame) sobre um único item de trabalho para completá-lo mais rapidamente, em vez de cada um trabalhar em itens separados.

**Quando usar:**
1. **Quando um item está prestes a ultrapassar o WIP limit:** Se a coluna "In Progress" tem WIP limit de 3 e já há 3 itens, o time não pode começar um novo. Em vez disso, todos ajudam a terminar um dos 3.
2. **Quando há um gargalo:** Se "Testing" está acumulando itens, developers ajudam nos testes para descongestionar.
3. **Quando um item está "preso":** Um item que está em andamento há muito tempo (Work Item Age alto) recebe atenção de todo o time.
4. **Quando um item é urgente e crítico:** O time inteiro foca nele para entregar o mais rápido possível.

**Como se relaciona com o WIP limit:**
O WIP limit *força* o swarming. Quando o WIP limit é atingido, o time não pode começar um novo item — a única opção é ajudar a terminar um que está em andamento. Isso é o swarming: o time "converge" sobre o item para liberar espaço no WIP.

**Benefícios:**
1. **Itens terminam mais rápido:** Múltiplas perspectivas aceleram a resolução de problemas.
2. **Reduz Work in Progress:** Em vez de espalhar o esforço, concentra-o.
3. **Compartilhamento de conhecimento:** Developers ajudam em testes, testers ajudam em código — o time aprende junto.
4. **Previne acúmulo:** Evita que itens fiquem "presos" no fluxo.

**Quando NÃO fazer swarming:**
1. **Itens que não se beneficiam de paralelização:** Se a tarefa é estritamente sequencial e não pode ser dividida, adicionar pessoas não ajuda (Lei de Brooks: "adicionar pessoas a um projeto atrasado o torna ainda mais atrasado").
2. **Todos os dias:** Swarming é uma técnica para situações específicas, não o modo padrão de trabalho. Se o time faz swarming todo dia, algo está errado com o WIP limit ou o processo.

**Explicação didática:**
Imagine abelhas em uma colmeia. Quando uma flor é encontrada, não é uma abelha que recolhe o néctar — o enxame inteiro converge para aquela flor para maximizar a coleta. Depois, vão para a próxima. No Kanban, quando um item precisa de atenção, o time "converge" para terminá-lo, em vez de cada um fazer uma tarefa separada. O WIP limit é o que "convoca" o enxame — quando não pode começar mais nada, todos ajudam a terminar.

**Exemplo prático:**
Quadro Kanban com WIP limit de 3 em "In Progress":
- 3 itens em In Progress
- Item A: 90% pronto (falta code review)
- Item B: 50% pronto (em desenvolvimento)
- Item C: 30% pronto (em desenvolvimento)

Um developer tenta pegar um novo item do To Do. Mas o WIP limit está no máximo. Em vez de esperar, o developer vai ajudar no Item A — faz o code review, ajuda nos testes. Item A vai para "Done". Agora há espaço: o developer pode puxar um novo item do To Do.

Sem swarming: o developer ficaria ocioso esperando o Item A ser concluído, ou puxaria um novo item (violando o WIP limit e piorando o fluxo).

**Como o candidato deve responder:**
- Definir swarming como convergência do time em um item
- Explicar que o WIP limit força o swarming
- Citar pelo menos 3 situações de uso
- Mencionar benefícios (reduz WIP, compartilha conhecimento, acelera)
- Mencionar quando não fazer swarming (tarefas sequenciais)
- Evitar confundir com pair programming (é mais amplo)

**Resposta fraca ou incompleta:**
"Swarming é quando todo mundo faz a mesma coisa ao mesmo tempo." — Incorreto: não é "todo mundo fazendo a mesma coisa". É o time convergindo sobre um item específico, cada um contribuindo com sua especialidade (um faz code review, outro escreve testes, outro corrige bugs). E não é "ao mesmo tempo" como modo padrão — é uma técnica para situações específicas.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "todo mundo junta", mas não explica
- **2** — Define o conceito, mas não conecta com WIP limit
- **3** — Define, explica a conexão com WIP limit e cita 3+ situações
- **4** — Explica com clareza, menciona benefícios, quando usar e quando não usar
- **5** — Domínio: explica swarming, WIP limit como gatilho, benefícios, limitações (Lei de Brooks), e como a prática melhora o fluxo

**Perguntas de aprofundamento:**
1. Qual é a diferença entre swarming e pair programming?
2. Como o swarming afeta o Cycle Time e o Lead Time?
3. O swarming funciona em um time Scrum ou é exclusivo do Kanban?

---

### Pergunta 61 — Conceito de "Muda" (Desperdício) no contexto ágil

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
O Lean define "Muda" como desperdício. No contexto do desenvolvimento de software e metodologias ágeis, quais são os tipos mais comuns de muda (desperdício) que um time deve identificar e eliminar?

**O que essa pergunta avalia:**
Avalia o conhecimento dos tipos de desperdício no desenvolvimento de software e a capacidade de conectá-los a situações práticas.

**Resposta esperada:**
O Lean originalmente classifica 7 tipos de Muda (desperdício) na manufatura. Adaptados para desenvolvimento de software:

1. **Trabalho parcialmente concluído:** Código escrito mas não testado, feature a 80% mas não integrada. O trabalho parcial não gera valor e pode ficar obsoleto.
2. **Características extras (overproduction):** Construir features que ninguém usa. O time "acha" que o usuário precisa, mas não valida. É o pior desperdício — você gastou tempo e esforço em algo que não agrega valor.
3. **Retrabalho (defeitos):** Bugs que precisam ser corrigidos, código que precisa ser refatorado, requisitos mal entendidos que geram retrabalho.
4. **Espera:** Aguardar resposta do PO, aguardar deploy, aguardar outro time entregar uma API, aguardar ambiente de teste. Tempo ocioso onde nada é produzido.
5. **Movimentação não essencial:** Trocar de contexto entre 5 tarefas diferentes. Cada troca de contexto custa ~20 minutos de recuperação de foco.
6. **Handoffs:** Passar trabalho de uma pessoa para outra (developer → tester → ops). Cada handoff perde conhecimento tácito e gera mal-entendidos.
7. **Complexidade desnecessária:** Overengineering — construir uma arquitetura complexa para um problema simples, adicionar frameworks que não são necessários, otimizar prematuramente.

8. **Desperdício administrativo (adicionado por alguns autores):** Reuniões desnecessárias, relatórios que ninguém lê, processos burocráticos que não agregam valor.

**Como identificar muda no dia a dia:**
- Na Retrospective: "O que fizemos essa Sprint que não agregou valor direto ao produto?"
- Na Daily: "Estou esperando algo? Por quê?"
- No refinement: "Esta feature é realmente necessária ou é um 'nice to have'?"
- No Planning: "Estamos pegando muitos itens em paralelo? Há troca de contexto excessiva?"

**Explicação didática:**
Imagine uma cozinha de restaurante. Desperdício é: comida jogada fora (retrabalho), pratos que ninguém pediu (características extras), cozinheiro esperando o forno (espera), passando o prato de cozinheiro para ajudante para garçom (handoffs), receita complexa demais para um prato simples (complexidade desnecessária). O Lean busca identificar e eliminar esses desperdícios para que o tempo e o esforço sejam gastos apenas no que agrega valor.

**Exemplo prático:**
Um time analisa sua Sprint e identifica:
- **Espera:** 2 dias esperando o time de infra configurar o ambiente → criar um item no Backlog para automatizar o provisionamento
- **Retrabalho:** 3 bugs em produção por falta de testes → adicionar testes automatizados à DoD
- **Características extras:** Feature de "exportar para Excel" que ninguém usou → validar com o PO antes de implementar próximas features
- **Handoffs:** Developer escreve código, joga "por cima do muro" para o tester → introduzir pair testing ou shift-left testing

**Como o candidato deve responder:**
- Citar pelo menos 5-6 tipos de muda
- Adaptar ao contexto de software (não apenas manufatura)
- Dar exemplos práticos de cada tipo
- Explicar como identificar no dia a dia
- Mencionar que "características extras" é frequentemente o pior desperdício
- Evitar listar apenas nomes sem explicar

**Resposta fraca ou incompleta:**
"Muda é desperdício. No software, desperdício é quando o código tem bugs." — Reduz muda a apenas um tipo (retrabalho/defeitos). Há 7+ tipos de desperdício no software, e bugs são apenas um deles. Não menciona características extras, espera, handoffs, complexidade ou trabalho parcial.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que muda é "desperdício", mas não lista tipos
- **2** — Lista 2-3 tipos, mas sem contexto de software
- **3** — Lista 5+ tipos com exemplos de software
- **4** — Explica 6+ tipos, dá exemplos práticos e como identificar
- **5** — Domínio: explica todos os tipos, a origem Lean, como identificá-los na Retrospective e como eliminá-los

**Perguntas de aprofundamento:**
1. Qual é o tipo de muda mais difícil de identificar e por quê?
2. Como o Kanban ajuda a visualizar e reduzir muda?
3. "Características extras" pode ser evitado totalmente? Como o PO pode minimizar esse desperdício?

---

### Pergunta 62 — Cenário: Transição de Waterfall para Ágil

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Uma empresa que sempre trabalhou com Waterfall (cascata) decidiu migrar para Scrum. O gerente de projetos pergunta: "Mas e o cronograma detalhado de 6 meses que já fizemos? Podemos manter o planejamento e só trocar as reuniões?" Como você explicaria por que isso não funciona?

**O que essa pergunta avalia:**
Avalia a compreensão da diferença fundamental entre os paradigmas Waterfall e Ágil e a capacidade de explicar por que não se pode simplesmente "adaptar" o planejamento Waterfall ao Scrum.

**Resposta esperada:**

**Por que não funciona:**

1. **Planejamento preditivo vs adaptativo:** O Waterfall pressupõe que é possível planejar todo o projeto no início com precisão. O Scrum pressupõe que o planejamento detalhado é feito Sprint a Sprint, pois requisitos mudam. Um cronograma de 6 meses feito no início é, por natureza, uma previsão imprecisa em um ambiente complexo.

2. **Escopo fixo vs flexível:** No Waterfall, escopo é fixo e tempo/custo variam. No Scrum, tempo é fixo (Sprint) e escopo é flexível (o time entrega o que conseguir dentro do timebox). Manter um escopo fixo de 6 meses elimina a capacidade de adaptação.

3. **Entrega no final vs incremental:** O Waterfall entrega o produto completo no final. O Scrum entrega incrementos a cada Sprint. Manter o cronograma Waterfall significa adiar toda a entrega para o final — perdendo o benefício do feedback incremental.

4. **Documentação extensa vs conversa:** O Waterfall produz documentos detalhados de requisitos. O Scrum prioriza conversas e refinamento contínuo. Manter documentos estáticos de requisitos vai contra o princípio de " responder a mudanças acima de seguir um plano".

5. **Papéis diferentes:** O Waterfall tem gerente de projetos, analistas de negócios, arquitetos. O Scrum tem PO, SM e Developers. Manter os papéis antigos com nomes novos é "Fake Scrum".

**Como explicar ao gerente:**
"O cronograma de 6 meses foi feito com base em premissas que provavelmente mudarão. No Scrum, em vez de planejar 6 meses de uma vez, planejamos 2 semanas de cada vez, com base no que aprendemos a cada Sprint. O cronograma de 6 meses pode servir como uma *visão geral* de direção (Product Goal), mas não como um plano de execução detalhado. A cada 2 semanas, revisamos e ajustamos."

**O que aproveitar do Waterfall:**
- A visão geral do produto pode virar o Product Goal
- A lista de requisitos pode virar o Product Backlog inicial (mas será refinada)
- Os marcos importantes (milestones) podem servir como referência, não como compromissos fixos
- O orçamento total pode ser mantido, mas a alocação interna muda

**Explicação didática:**
Imagine planejar uma viagem de 6 meses detalhando cada dia: onde comer, onde dormir, o que visitar. No dia 3, você descobre que um museu está fechado, um festival que você não sabia está acontecendo, e você conheceu um local que sugeriu um lugar incrível. Se você seguir o plano original, perde o festival e a recomendação. Se adaptar, seu planejamento de 6 meses está errado. O Scrum é planejar a próxima semana com base no que você aprendeu na semana anterior — não planejar 6 meses de uma vez.

**Exemplo prático:**
**Waterfall:** Cronograma com 50 tarefas, cada uma com data de início e fim, ao longo de 6 meses. Requisios documentados em 100 páginas.

**Migração para Scrum:**
- Os 50 requisitos viram itens do Product Backlog (ordenados pelo PO)
- O cronograma de 6 meses vira "Product Goal: entregar a versão 2.0 em 6 meses"
- A cada 2 semanas (Sprint), o time planeja 2 semanas baseado no que aprendeu
- Os 100 requisitos são refinados e ajustados a cada Sprint
- O cronograma detalhado é descartado — não serve para um ambiente adaptativo

**Como o candidato deve responder:**
- Explicar a diferença entre planejamento preditivo e adaptativo
- Citar pelo menos 4 diferenças fundamentais entre Waterfall e Scrum
- Explicar que não dá para "manter o planejamento e trocar as reuniões"
- Mencionar o que pode ser aproveitado do Waterfall (visão, backlog inicial)
- Dar analogia ou exemplo prático
- Evitar dizer que "Waterfall é sempre ruim" (é adequado para problemas determinísticos)

**Resposta fraca ou incompleta:**
"O Scrum é melhor que Waterfall porque é mais moderno. O cronograma não serve porque o Scrum não usa cronograma." — Não explica *por que* o cronograma não serve, não explica a diferença entre os paradigmas, e "mais moderno" não é um argumento técnico. O Scrum pode usar marcos temporais — o que ele não usa é um planejamento detalhado de execução meses à frente.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que "são diferentes", mas não explica
- **2** — Explica 1-2 diferenças, mas não responde à pergunta do gerente
- **3** — Explica as diferenças e por que o cronograma não funciona no Scrum
- **4** — Explica com clareza, cita o que aproveitar do Waterfall, dá exemplo
- **5** — Domínio: explica os paradigmas, a incompatibilidade, o que migrar, e os desafios culturais da transição

**Perguntas de aprofundamento:**
1. É possível fazer uma transição gradual de Waterfall para Scrum? Como?
2. O que acontece com o papel de "gerente de projetos" em uma organização que adota Scrum?
3. Em quais situações o Waterfall ainda é mais adequado que o Scrum?

---

### Pergunta 63 — Conceito de "Definition of Ready" (DoR)

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
Alguns times Scrum adotam uma "Definition of Ready" (DoR) além da Definition of Done (DoD). O que é a DoR, qual é a sua relação com o refinamento e por que ela é controversa?

**O que essa pergunta avalia:**
Avalia o conhecimento de uma prática comum mas não oficial no Scrum, sua utilidade e os argumentos contra o seu uso.

**Resposta esperada:**
A **Definition of Ready (DoR)** é um acordo do time sobre os critérios que um item do Product Backlog deve atender antes de poder ser selecionado para uma Sprint. É um checklist de "prontidão" — o item está pronto para ser planejado?

**Critérios comuns de uma DoR:**
- A história tem descrição clara no formato "Como... quero... para..."
- Tem critérios de aceitação testáveis
- Foi estimada pelo time
- Dependências identificadas e resolvidas (ou com plano de mitigação)
- O PO validou e confirmou o valor
- O item cabe em uma Sprint (não é um epic)

**Relação com o refinamento:**
A DoR é o *resultado* esperado do refinement. Durante as sessões de refinement, o time e o PO trabalham nos itens do Backlog para que atinjam a DoR. Quando um item atende à DoR, está "pronto para Planning".

**Por que é controversa:**
1. **Não está no Guia Scrum:** O Guia Scrum não menciona DoR. É uma prática inventada por times, não uma prescrição do framework.
2. **Pode criar "mini Waterfall":** Se o time exige que o item esteja "100% pronto" antes da Sprint, pode criar uma fase de "requisitos completos" que se parece com Waterfall.
3. **Pode ser usada como desculpa:** "Esta história não está 'ready', não vamos trabalhar nela" — pode ser usado para evitar trabalho difícil em vez de lidar com a incerteza.
4. **O Guia Scrum 2020 enfraquece a DoR:** O Guia diz que os Developers são responsáveis por criar um Incremento utilizável a cada Sprint, independentemente de "prontidão" — a responsabilidade é de entregar, não de esperar que tudo esteja perfeito.

**Argumentos a favor:**
- Reduz Sprint Plannings longos (itens já chegam prontos para discussão)
- Reduz spillover (itens bem definidos são estimados com mais precisão)
- Cria accountability compartilhada entre PO e time

**Posição equilibrada:**
A DoR é útil como *guia* de refinement, não como *gate* rígido. Se um item não atende a todos os critérios da DoR mas o time entende o suficiente para trabalhar nele, pode ser selecionado. A DoR deve ajudar, não bloquear.

**Explicação didática:**
Imagine uma checklist de "pronto para decolar" de um avião. O piloto verifica combustível, motor, clima. Se um item da checklist falha, o avião não decola. A DoR é a checklist de "pronto para planejar" — se o item não tem critérios de aceitação claros, não deve entrar na Sprint. Mas, diferentemente de um avião, o software é mais flexível: se 9 de 10 itens da checklist estão OK, o time pode decidir prosseguir com o risco assumido.

**Exemplo prático:**
DoR de um time:
1. História descrita no formato "Como... quero... para..."
2. Pelo menos 3 critérios de aceitação testáveis
3. Estimada pelo time (não maior que 8 pontos)
4. Dependências identificadas
5. Design/UX validado (se aplicável)

Na Sprint Planning, o PO propõe uma história que não tem critérios de aceitação. O time diz: "Esta não atende a DoR. Vamos refiná-la e colocá-la na próxima Sprint." Ou: "Não atende a DoR, mas o time entende o suficiente. Vamos trabalhar nela e detalhar os critérios durante a Sprint."

**Como o candidato deve responder:**
- Definir DoR como critérios de "prontidão" para Planning
- Listar critérios comuns
- Explicar a relação com o refinement
- Mencionar que não está no Guia Scrum
- Explicar pelo menos 2 argumentos contra
- Apresentar uma posição equilibrada (guia, não gate)
- Evitar dizer que DoR é "obrigatória no Scrum"

**Resposta fraca ou incompleta:**
"DoR é como a DoD, mas para o início. Todo time Scrum deve ter uma." — Incorreto: a DoR não é obrigatória no Scrum e não está no Guia. Comparar diretamente com a DoD é enganoso — a DoD está no Guia, a DoR não. E "todo time deve ter" é uma afirmação que não corresponde à realidade do framework.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "pronto para começar", mas não explica
- **2** — Define DoR, mas não menciona controvérsia
- **3** — Define, lista critérios e menciona que não está no Guia
- **4** — Explica com clareza, argumentos pró e contra, posição equilibrada
- **5** — Domínio: explica DoR, DoD, a controvérsia, a relação com refinement e como usar sem criar "mini Waterfall"

**Perguntas de aprofundamento:**
1. Se a DoR não está no Guia Scrum, por que tantos times a adotam?
2. O que acontece quando o time tem DoR mas não tem refinement regular?
3. A DoR e a DoD podem se sobrepor? Há critérios que aparecem em ambas?

---

### Pergunta 64 — Cenário: Developer que não participa da Daily

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Um dos developers do time nunca fala na Daily Scrum. Fica em silêncio, olha para o chão e quando perguntado diz "nada de novo, tudo normal". Mas você percebe que ele é um dos mais produtivos do time. Como você lidaria com essa situação?

**O que essa pergunta avalia:**
Avalia a sensibilidade do SM diante de diferentes perfis de personalidade, a capacidade de distinguir entre "não participa porque não quer" e "não participa por timidez ou neurodivergência", e a postura de não forçar comportamentos.

**Resposta esperada:**

**Diagnóstico — entender antes de agir:**
O silêncio na Daily não é necessariamente um problema. Pode ter várias causas:
1. **Personalidade introvertida:** Pessoas introvertidas podem achar a Daily desconfortável — falar em grupo, rapidamente, sob pressão.
2. **Neurodivergência:** Pessoas no espectro autista ou com ansiedade social podem achar a Daily particularmente desafiadora.
3. **Cultura do time:** Se o time é dominado por pessoas mais extrovertidas que falam muito, o introvertido pode não conseguir "entrar" na conversa.
4. **Falta de clareza sobre o que dizer:** Pode não entender o propósito da Daily e achar que "não tem nada a reportar".
5. **Trabalho solitário:** Se o developer trabalha em tarefas individuais que não afetam os outros, pode achar que não há nada a comunicar.

**Como lidar:**

1. **Conversa 1:1 (não na Daily):** Falar com o developer em privado: "Notei que você não costuma falar na Daily. Como você se sente em relação a essa reunião?" Ouvir antes de propor soluções.

2. **Não forçar a participação:** Se o developer é produtivo e o trabalho flui, a participação verbal na Daily pode não ser essencial. O Scrum valoriza respeito — respeitar o estilo do indivíduo é importante.

3. **Adaptar o formato:** Em vez de round-robin (cada um fala por vez), usar um formato onde o time olha o quadro e discute o progresso. O developer pode contribuir apontando para um item no quadro em vez de falar formalmente.

4. **Daily assíncrona como alternativa:** Alguns times permitam que pessoas escrevam sua atualização no chat antes da Daily. O developer pode escrever e a Daily oral focar apenas nos pontos que precisam de discussão.

5. **Garantir que o trabalho é visível:** Se o developer usa o quadro (Jira, Trello) para mover seus itens, a visibilidade já existe — a Daily oral é redundante para ele. O importante é que o trabalho seja transparente, não que todos falem.

6. **Verificar se há impedimentos não comunicados:** O risco do silêncio é que impedimentos não sejam levantados. Em 1:1, perguntar: "Há algo que está te bloqueando? Você sente que pode pedir ajuda quando precisa?"

**Explicação didática:**
Imagine uma banda de jazz. Alguns músicos tocam solos longos e expressivos; outros tocam a base, essenciais mas discretos. Não exigir que o baixista faça um solo de 5 minutos só porque o saxofonista faz. O importante é que a música saia bem. Na Daily, o importante é que o time se sincronize e identifique bloqueios — não que cada um fale por 2 minutos.

**Exemplo prático:**
SM fala com o developer: "Notei que você é quieto na Daily. Tudo bem?"
Developer: "Eu não gosto de falar em grupo. Meu trabalho está no quadro, todo mundo pode ver."
SM: "Entendo. O quadro está sempre atualizado?"
Developer: "Sim, atualizo todo dia."
SM: "Perfeito. O único que me preocupa é: se algo te bloquear, como vou saber? Quer usar o chat da Daily para escrever se houver bloqueio?"
Developer: "Sim, posso fazer isso."

**Como o candidato deve responder:**
- Não assumir que o silêncio é um problema
- Propor conversa 1:1 para entender
- Não forçar a participação verbal
- Adaptar o formato (quadro, chat, assíncrono)
- Verificar se impedimentos são comunicados
- Respeitar diferenças de personalidade
- Evitar sugerir "obrigar a falar" ou "chamar a atenção na Daily"

**Resposta fraca ou incompleta:**
"Eu diria na Daily que ele precisa participar e que a Daily é obrigatória." — Abordagem autoritária que ignora o motivo do silêncio e desrespeita a individualidade. Obrigar uma pessoa introvertida a falar publicamente pode gerar ansiedade e piorar a situação. A Daily é para inspeção e adaptação, não para "obrigar todos a falar".

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica o "problema", mas propõe "obrigar a falar"
- **2** — Propõe conversa, mas ainda foca em "fazer a pessoa falar"
- **3** — Entende que pode ser personalidade, propõe 1:1 e adaptação
- **4** — Abordagem empática, múltiplas adaptações, foco em transparência do trabalho
- **5** — Domínio: entende neurodiversidade, respeita estilos individuais, garante que o trabalho é visível e que impedimentos são comunicados por canais alternativos

**Perguntas de aprofundamento:**
1. A Daily Scrum pode ser feita de forma assíncrona (chat, e-mail)? Funciona?
2. Como lidar com um time inteiro que é introvertido?
3. A auto-organização significa que todos devem participar igualmente?

---

### Pergunta 65 — Conceito de "Cumulative Flow Diagram" (CFD)

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
O que é um Cumulative Flow Diagram (CFD) no Kanban e o que ele permite visualizar que um quadro Kanban sozinho não mostra? Quais sinais de problema um time pode identificar no CFD?

**O que essa pergunta avalia:**
Avalia o conhecimento de uma das ferramentas analíticas mais importantes do Kanban e a capacidade de interpretar padrões visuais no diagrama.

**Resposta esperada:**
O **Cumulative Flow Diagram (CFD)** é um gráfico de área empilhada que mostra a quantidade de itens em cada estado do fluxo de trabalho ao longo do tempo. O eixo X é o tempo (dias, semanas) e o eixo Y é o número de itens. Cada "banda" colorida representa um estado do quadro (Backlog, In Progress, Testing, Done).

**O que permite visualizar:**

1. **Gargalos (afunilamento):** Se uma banda (ex: "Testing") está ficando mais larga enquanto outras estão estáveis, indica acúmulo naquela etapa — um gargalo.
2. **Lead Time visual:** A distância vertical entre a linha de "Backlog" e a linha de "Done" representa o Lead Time aproximado. Se essa distância aumenta, o Lead Time está crescendo.
3. **Throughput:** A inclinação da linha de "Done" mostra o throughput. Se a linha está plana, o throughput caiu. Se está inclinada, está entregando.
4. **WIP total:** A distância vertical entre "In Progress" e "Done" mostra o WIP atual. Se está crescendo, o time está acumulando trabalho em andamento.
5. **Tendências ao longo do tempo:** Diferente do quadro (que mostra o momento atual), o CFD mostra a *evolução* ao longo de semanas ou meses — permite ver padrões.

**Sinais de problema no CFD:**

| Sinal visual | O que indica |
|---|---|
| Banda de uma etapa se alarga | Gargalo naquela etapa |
| Distância entre Backlog e Done aumenta | Lead Time crescendo |
| Linha de Done fica plana | Throughput caiu — time parou de entregar |
| Banda de In Progress cresce | WIP excessivo |
| Bandas se cruzam ou invertem | Itens voltando (retrabalho, rejeição em teste) |

**Explicação didática:**
Imagine um rio com várias represas em sequência. O CFD é como uma foto aérea tirada todos os dias, que mostra o nível de água em cada represa ao longo do tempo. Se uma represa está transbordando (banda se alarga), há um gargalo nela. Se a vazão de saída diminui (linha de Done plana), algo está reduzindo o fluxo. Sem o CFD, você só vê o rio em um momento; com ele, vê a história inteira.

**Exemplo prático:**
Um time olha o CFD das últimas 8 semanas e nota:
- A banda de "In Progress" está estável
- A banda de "Testing" está se alargando nas últimas 3 semanas
- A linha de "Done" está desacelerando

Interpretação: há um gargalo em "Testing". O time está produzindo código que chega em Testing, mas o Testing não acompanha. Causas possíveis: poucos testadores, testes manuais demorando, bugs sendo encontrados tarde. Solução: investir em automação de testes, fazer swarming na coluna de Testing, ou reduzir WIP de In Progress para desacelerar a entrada de itens em Testing.

**Como o candidato deve responder:**
- Explicar que o CFD é um gráfico de área empilhada ao longo do tempo
- Mencionar que mostra a evolução, não apenas o estado atual
- Citar pelo menos 4 sinais de problema
- Explicar gargalo visual (afunilamento/alargamento de banda)
- Dar exemplo de leitura do CFD
- Evitar confundir com Burndown (este mostra restante, não acúmulo por etapa)

**Resposta fraca ou incompleta:**
"CFD é um gráfico que mostra o fluxo de trabalho no Kanban." — Muito vago: não explica o que é (área empilhada), o que mostra (itens por estado ao longo do tempo), nem que sinais de problema revela. Um gráfico de pizza também "mostra o fluxo de trabalho".

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "um gráfico do Kanban", mas não explica
- **2** — Define o gráfico, mas não menciona sinais de problema
- **3** — Define e cita 3+ sinais de problema
- **4** — Explica com clareza, sinais, leitura e exemplo prático
- **5** — Domínio: explica o CFD, bandas, sinais de gargalo, relação com WIP e Lead Time, e como usar para diagnóstico

**Perguntas de aprofundamento:**
1. Como calcular o Lead Time a partir do CFD?
2. Qual é a diferença entre CFD e Burndown Chart?
3. O CFD pode ser usado em um time Scrum ou é exclusivo do Kanban?

---

### Pergunta 66 — Cenário: Sprint muito longa (4 semanas)

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Sua empresa adotou Sprints de 4 semanas porque "dá tempo de fazer mais coisas". Mas você percebe que as Sprint Reviews têm pouco feedback, as Retrospectives esquecem o início da Sprint e o time perde o senso de urgência. O que você faria?

**O que essa pergunta avalia:**
Avalia a compreensão dos impactos negativos de Sprints longas e a capacidade de justificar e propor a redução da duração.

**Resposta esperada:**

**Problemas com Sprints de 4 semanas:**

1. **Feedback tardio:** Em 4 semanas, o time trabalha "no escuro" — só recebe feedback dos stakeholders na Review, que acontece 4 semanas depois do Planning. Se a direção estava errada, são 4 semanas de desperdício.
2. **Retrospective perde memória:** É difícil lembrar o que aconteceu na semana 1 quando a Retrospective é na semana 4. Eventos recentes dominam a discussão; problemas antigos são esquecidos.
3. **Perda de urgência:** Com 4 semanas, o time "relaxa" no início (ainda tem 3 semanas) e se apavora no final (só faltam 3 dias). A Lei de Parkinson ("o trabalho se expande para preencher o tempo") é especialmente forte em Sprints longas.
4. **Flexibilidade reduzida:** 4 semanas sem mudar o Sprint Backlog significa 4 semanas sem poder responder a mudanças de prioridade — em um ambiente dinâmico, isso é muito tempo.
5. **Risco de cancelamento:** Sprints longas têm maior probabilidade de cancelamento, pois mais coisas podem mudar em 4 semanas que em 2.
6. **Itens grandes e pouco decompostos:** Sprints longas incentivam pegar itens grandes, pois "tem tempo" — mas itens grandes têm mais risco de spillover.

**Como propor a mudança:**

1. **Apresentar os dados:** Mostrar ao time e ao PO os problemas observados: "Nas últimas 3 Sprints de 4 semanas, recebemos feedback relevante apenas na Review, e em 2 das 3 o feedback indicou que precisávamos mudar de direção — mas já tínhamos gasto 4 semanas."

2. **Propor redução gradual:** Em vez de ir direto de 4 para 1 semana, propor 2 semanas como primeiro passo. Avaliar o impacto e ajustar.

3. **Explicar os benefícios:**
   - Feedback a cada 2 semanas em vez de 4
   - Retrospective com memória mais fresca
   - Maior capacidade de adaptação
   - Menos risco de desperdício

4. **Usar a Retrospective para decidir:** Levar a discussão para o time: "Vocês sentem que 4 semanas é muito? O que mudaria com 2 semanas?" Deixar o time decidir (não impor).

5. **Addressar preocupações:** Se o PO teme "perder tempo com Planning a cada 2 semanas", explicar que Planning de 2 semanas é mais curta (4 horas vs 8 horas) e que o ganho de feedback compensa.

**Explicação didática:**
Imagine um curso que só tem provas a cada 2 meses. O aluno estuda "mais ou menos" nas primeiras 6 semanas e entra em desespero nas últimas 2. Quando recebe a nota, já passou 2 meses — e o feedback sobre o que errou na semana 1 é quase inútil. Agora imagine provas a cada 2 semanas: o aluno mantém o ritmo, recebe feedback rápido e corrige a direção. Sprints curtas funcionam igual.

**Exemplo prático:**
Time com Sprint de 4 semanas. Na Sprint 3, a Review revela que a feature de "relatórios em PDF" que o time trabalhou por 3 semanas não é mais prioritária — o cliente mudou para "exportar para Excel". 3 semanas de trabalho em PDF foram parcialmente desperdiçadas. Com Sprints de 2 semanas, o time teria entregue um MVP do PDF na Review da semana 2, recebido o feedback e ajustado — desperdício de no máximo 2 semanas.

**Como o candidato deve responder:**
- Identificar os problemas da Sprint de 4 semanas (pelo menos 4)
- Explicar que feedback tardio é o maior problema
- Propor redução gradual (não extrema)
- Usar a Retrospective como espaço de decisão
- Mencionar a Lei de Parkinson
- Explicar que Planning mais frequente é mais curto
- Evitar impor a mudança sem consultar o time

**Resposta fraca ou incompleta:**
"Eu mudaria para Sprints de 1 semana porque é melhor ter feedback rápido." — Extremo: ir de 4 semanas para 1 semana pode ser muito disruptivo. Sprints de 1 semana exigem Planning, Review e Retrospective toda semana — overhead proporcional maior. A recomendação usual é 2 semanas como ponto de partida.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que "4 semanas é muito", mas não explica
- **2** — Cita 1-2 problemas, mas não propõe solução estruturada
- **3** — Cita 4+ problemas e propõe redução gradual
- **4** — Explica problemas, propõe redução, menciona Parkinson, usa Retrospective
- **5** — Domínio: explica os problemas, a justificativa, a abordagem gradual, addressa preocupações do PO e conecta com feedback loop e inspeção/adaptação

**Perguntas de aprofundamento:**
1. Qual é a duração ideal de uma Sprint? Depende do contexto?
2. Um time pode ter Sprints de 1 semana? Quais são os prós e contras?
3. Como o overhead de eventos (Planning, Review, Retro) muda com a duração da Sprint?

---

### Pergunta 67 — Conceito de "Cycle Time Histogram"

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
Além do Scatter Plot, times Kanban também usam um Cycle Time Histogram. O que ele mostra e como ele complementa o Scatter Plot na análise de fluxo?

**O que essa pergunta avalia:**
Avalia o conhecimento de mais uma ferramenta analítica do Kanban e a capacidade de explicar como diferentes visualizações de dados complementam-se.

**Resposta esperada:**
O **Cycle Time Histogram** é um gráfico de barras que mostra a *frequência* de itens por faixa de Cycle Time. O eixo X representa faixas de tempo (ex: 1-2 dias, 3-4 dias, 5-6 dias) e o eixo Y representa quantos itens caem em cada faixa.

**O que mostra:**
- **Distribuição:** Como os Cycle Times estão distribuídos. A maioria dos itens é rápida (poucos dias) ou a distribuição é uniforme?
- **Moda:** Qual é o Cycle Time mais comum (a barra mais alta)
- **Assimetría:** Se a maioria dos itens está à esquerda (rápidos) com uma cauda longa à direita (alguns muito lentos), a distribuição é assimétrica — comum em software
- **Percentis visualmente:** A linha do percentil 85 mostra que 85% dos itens são concluídos em X dias ou menos

**Como complementa o Scatter Plot:**

| Ferramenta | O que mostra | Melhor para |
|---|---|---|
| Scatter Plot | Cada item como ponto ao longo do tempo | Ver tendência e outliers |
| Histogram | Frequência de itens por faixa de tempo | Ver distribuição e percentis |
| CFD | Acúmulo por estado ao longo do tempo | Ver gargalos e WIP |

O Scatter Plot responde: "Os itens estão ficando mais lentos ao longo do tempo?"
O Histogram responde: "Qual é a distribuição dos tempos? Qual percentil 85?"
O CFD responde: "Onde está o gargalo?"

**Como usar na prática:**
1. **Previsão:** "85% dos nossos itens são concluídos em 7 dias ou menos. Se o cliente precisa de um item em 5 dias, podemos dizer que há ~50% de chance. Se precisa em 10 dias, há 85%+ de chance."
2. **Identificar assimetria:** Se o histograma tem uma cauda longa à direita, alguns itens demoram muito mais que a maioria. Esses outliers devem ser investigados.
3. **Comparar antes/depois:** Se o time fez uma mudança (ex: reduziu WIP), comparar o histograma antes e depois para ver se a distribuição melhorou.

**Explicação didática:**
Imagine um gráfico de "quantos minutos cada cliente esperou no banco". O Scatter Plot mostra cada cliente como um ponto ao longo do tempo (segunda, terça...). O Histogram mostra "quantos clientes esperaram 1-5 min, quantos 6-10 min, quantos 11-15 min" — a distribuição. A maioria pode estar em 1-5 min (barra alta à esquerda), mas há uma cauda de clientes que esperaram 30+ min (barra pequena à direita). Essa cauda são os outliers que precisam de investigação.

**Exemplo prático:**
Histogram dos últimos 50 itens:
- 1-2 dias: 15 itens (30%)
- 3-4 dias: 20 itens (40%)
- 5-6 dias: 8 itens (16%)
- 7-8 dias: 4 itens (8%)
- 9-10 dias: 2 itens (4%)
- 11+ dias: 1 item (2%)

Percentil 85: ~7 dias. A maioria (70%) é concluída em 4 dias ou menos. O item de 11+ dias é um outlier.

O time usa essa informação para dizer ao PO: "Há 85% de chance de que um item seja concluído em 7 dias. Se você precisa de algo garantido em 4 dias, não podemos prometer — só 70% dos itens são concluídos nesse tempo."

**Como o candidato deve responder:**
- Explicar que o Histogram mostra frequência por faixa de tempo
- Mencionar distribuição, moda e percentis
- Explicar como complementa o Scatter Plot
- Dar exemplo de uso para previsão
- Mencionar a cauda longa e os outliers
- Evitar confundir com Scatter Plot ou CFD

**Resposta fraca ou incompleta:**
"É outro gráfico de tempo, parecido com o Scatter Plot." — Incorreto: não é "parecido". O Scatter Plot mostra cada item individualmente ao longo do tempo; o Histogram agrupa por faixa e mostra frequência. Visual e analiticamente são diferentes.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que é "sobre tempos", mas não explica
- **2** — Define o histograma, mas não diferencia do Scatter Plot
- **3** — Define, diferencia e menciona percentis
- **4** — Explica com clareza, complementa com Scatter Plot e CFD, dá exemplo
- **5** — Domínio: explica o histograma, a distribuição, percentis, assimetria, e como usar para previsão probabilística

**Perguntas de aprofundamento:**
1. Por que a média não é uma boa medida de tendência central para Cycle Time?
2. O que é "cauda longa" e o que ela indica sobre o processo?
3. Como usar o histograma para responder a pergunta "quando este item estará pronto?"

---

### Pergunta 68 — Cenário: Time que não escreve testes automatizados

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Seu time não escreve testes automatizados. A DoD não inclui testes e o time diz "não temos tempo para testes, precisamos entregar features". Como Scrum Master, como você abordaria essa situação?

**O que essa pergunta avalia:**
Avalia a capacidade de conectar práticas técnicas essenciais (testes) com o framework Scrum (DoD, qualidade) e a habilidade de influenciar mudança cultural sem impor.

**Resposta esperada:**

**Entender a barreira:**
Primeiro, entender *por que* o time não escreve testes:
1. **Falta de conhecimento:** O time pode não saber *como* escrever testes automatizados
2. **Pressão de prazo:** O PO ou a gestão cobra "entregar rápido" e o time sente que testes atrasam
3. **Código legado:** O código pode ser difícil de testar (alta acoplamento, sem injeção de dependência)
4. **Cultura:** O time nunca trabalhou com testes e não vê o valor
5. **Ferramentas:** O time não tem ferramentas de teste configuradas (framework de testes, CI)

**Como abordar:**

1. **Começar pequeno — não exigir 100% de cobertura:**
   - Adicionar à DoD: "Pelo menos 1 teste automatizado para a funcionalidade principal de cada história"
   - Começar com testes simples (unitários) e evoluir gradualmente
   - Não exigir TDD (Test-Driven Development) no primeiro passo

2. **Educar sobre o custo do "não testar":**
   - Mostrar dados: "Tivemos X bugs em produção nas últimas 3 Sprints. Cada bug custou ~Y horas para corrigir. Se tivéssemos testes automatizados, metade desses bugs teria sido pega antes."
   - Explicar que testes não "atrasam" — eles *previnem* retrabalho que atrasa mais

3. **Conversar com o PO:**
   - "Sem testes automatizados, cada nova feature corre risco de quebrar as existentes. Isso vai ficar pior conforme o sistema cresce. Precisamos investir em testes agora para ir mais rápido no futuro."
   - Negociar: "Vamos dedicar 20% da Sprint a testes nas próximas 3 Sprints. A velocity pode cair temporariamente, mas vai se estabilizar e reduzir bugs."

4. **Usar a Retrospective:**
   - Trazer dados de bugs em produção como item de discussão
   - "Por que temos tantos bugs? O que poderia prevenir?"
   - Deixar o time identificar a falta de testes como causa (mais eficaz que impor)

5. **Investir em capacitação:**
   - Se o problema é conhecimento, propor treinamento em testes automatizados
   - Parear developers que sabem testar com os que não sabem (pair programming)

6. **Adicionar testes à DoD gradualmente:**
   - Sprint 1: "1 teste por história"
   - Sprint 3: "Testes cobrem casos principais e de erro"
   - Sprint 5: "Cobertura de testes > 60% nas novas histórias"

**Explicação didática:**
Imagine uma fábrica que não inspeciona os produtos antes de enviá-los. "Inspecionar toma tempo" — diz o gerente. Mas os produtos chegam com defeito aos clientes, que devolvem, e a fábrica tem que refabricar. O tempo gasto em inspeção (testes) é muito menor que o tempo gasto em retrabalho (corrigir bugs em produção). Testes não são custo — são investimento que reduz custo futuro.

**Exemplo prático:**
SM leva dados à Retrospective:
- "Nas últimas 3 Sprints, tivemos 12 bugs em produção. Cada bug levou ~4 horas para corrigir + deploy. Total: 48 horas de retrabalho."
- "Se tivéssemos testes automatizados que pegassem 60% desses bugs antes, economizaríamos ~28 horas."
- "Em 3 Sprints, gastamos 48 horas corrigindo bugs. Se tivéssemos gasto 20 horas escrevendo testes, teríamos economizado 28 horas líquidas."

O time discute e decide: "Vamos adicionar 'pelo menos 1 teste por história' à DoD a partir da próxima Sprint."

**Como o candidato deve responder:**
- Entender a barreira (não assumir preguiça)
- Propor abordagem gradual (não exigir 100% de cobertura imediatamente)
- Usar dados para educar (bugs em produção, tempo de retrabalho)
- Conversar com o PO sobre o trade-off de curto vs longo prazo
- Adicionar testes à DoD gradualmente
- Mencionar a Retrospective como espaço de discussão
- Evitar impor "TDD obrigatório a partir de amanhã"

**Resposta fraca ou incompleta:**
"Eu obrigaria o time a escrever testes em toda história. Sem testes, a DoD não é atendida." — Abordagem autoritária que não resolve o problema de fundo. Se o time não sabe testar, "obrigar" não funciona. Se o PO cobra velocidade, "obrigar" gera conflito. A solução é educar, provar valor com dados e adotar gradualmente.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica o problema, mas não propõe solução
- **2** — Propõe "obrigar testes" ou "adicionar à DoD" sem estratégia
- **3** — Propõe abordagem gradual com dados e educação
- **4** — Abordagem completa: diagnóstico, gradualismo, dados, PO, Retrospective
- **5** — Domínio: entende a barreira, propõe plano gradual, usa dados, conecta com DoD e qualidade, e addressa o trade-off de curto vs longo prazo

**Perguntas de aprofundamento:**
1. O que é "shift-left testing" e como ele se relaciona com a DoD?
2. Como convencer o PO a investir tempo em testes em vez de novas features?
3. Testes automatizados devem estar na DoD ou nos critérios de aceitação?

---

### Pergunta 69 — Conceito de "Servant Leadership" no Scrum

**Nível:** Júnior
**Categoria:** Conceituais

**Pergunta do entrevistador:**
O Scrum Master é descrito como um "servant leader" (líder que serve). O que isso significa na prática? Como um servant leader difere de um líder tradicional e quais comportamentos demonstram essa postura?

**O que essa pergunta avalia:**
Avalia o entendimento do conceito de liderança servidora como aplicado ao papel do Scrum Master e a capacidade de diferenciá-lo da liderança tradicional.

**Resposta esperada:**
**Servant Leadership** (Liderança Servidora) é um estilo de liderança onde o líder foca em *servir* o time, removendo obstáculos e criando as condições para que o time tenha sucesso — em vez de *comandar* o time dizendo o que fazer.

**Diferenças:**

| Aspecto | Líder Tradicional | Servant Leader (SM) |
|---|---|---|
| Foco | Cumprir metas e prazos | Capacitar o time a cumprir metas |
| Autoridade | Posicional (dita ordens) | Influência (educa e facilita) |
| Decisões | Toma decisões pelo time | Ajuda o time a tomar suas próprias decisões |
| Comunicação | Diz "faça assim" | Pergunta "como vocês resolveriam?" |
| Erros | Punição ou cobrança | Aprendizado e melhoria |
| Impedimentos | Reporta e espera | Resolve ou ajuda a resolver |
| Sucesso | Atribui a si | Atribui ao time |
| Falha | Atribui ao time | Assume responsabilidade do processo |

**Comportamentos que demonstram servant leadership:**

1. **Remove impedimentos:** Não espera o time "se virar" — ativamente trabalha para remover bloqueios.
2. **Facilita, não impõe:** Em vez de dizer "a Retrospective será sobre X", pergunta "Sobre o que vocês querem falar na Retrospective?"
3. **Educa continuamente:** Ensina o time sobre Scrum, ágil, boas práticas — não uma vez, mas continuamente.
4. **Protege o time:** Intermediário entre o time e pressões externas (stakeholders, gerentes que querem "puxar" o time).
5. **Faz perguntas, não dá respostas:** "O que vocês acham que deveríamos fazer?" em vez de "Vocês deveriam fazer X."
6. **Escuta ativamente:** Ouve mais do que fala. Entende as preocupações do time antes de propor soluções.
7. **Promove auto-organização:** Resiste à tentação de "tomar a frente" — deixa o time resolver problemas, intervindo apenas quando necessário.
8. **Serve ao PO e à organização:** Não serve apenas aos Developers — também ajuda o PO a maximizar valor e educa a organização sobre Scrum.

**Explicação didática:**
Imagine um jardineiro. O jardineiro não "faz" a planta crescer — cria as condições para que ela cresca: rega, aduba, remove ervas daninhas, garante luz. A planta cresce por si só. O servant leader é o jardineiro: não faz o trabalho do time, mas cria as condições para que o time tenha sucesso. Se a planta não cresce, o jardineiro não culpa a planta — investiga o solo, a água, a luz.

**Exemplo prático:**
**Líder tradicional:** "O time não está entregando. Vou atribuir tarefas específicas a cada um e cobrar diariamente."

**Servant Leader (SM):** "O time não está entregando. Vou investigar: há impedimentos? O ambiente de teste está funcionando? O refinamento está adequado? Os itens estão bem definidos?" E depois: "Como posso ajudar vocês a remover o que está bloqueando?"

**Como o candidato deve responder:**
- Definir servant leadership como foco em servir, não comandar
- Citar pelo menos 5 comportamentos que demonstram a postura
- Diferenciar de liderança tradicional em pelo menos 4 aspectos
- Dar exemplo prático de cada abordagem
- Mencionar que o SM serve ao PO e à organização, não apenas aos Developers
- Evitar interpretar servant leadership como "submissão" ou "fazer tudo pelo time"

**Resposta fraca ou incompleta:**
"Servant leader é quando o Scrum Master serve o time, tipo buscar café e resolver problemas." — Reduz o conceito a "fazer favores". Servant leadership não é subserviência — é um estilo de liderança baseado em influência, educação e remoção de impedimentos. "Buscar café" não é servant leadership; "criar condições para o time ter sucesso" é.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Sabe que "SM serve o time", mas não explica
- **2** — Define o conceito, mas não diferencia de liderança tradicional
- **3** — Define, diferencia e cita 4+ comportamentos
- **4** — Explica com clareza, comportamentos, exemplos e a quem serve (Developers, PO, organização)
- **5** — Domínio: explica o conceito, a origem (Robert Greenleaf), a diferença da liderança tradicional, e como o SM equilibra servir com liderar

**Perguntas de aprofundamento:**
1. Um servant leader pode ser assertivo? Como equilibrar servir com cobrar responsabilidade?
2. Como o servant leadership se aplica quando o time comete erros graves?
3. O Guia Scrum 2020 mudou "servant leader" para "true leader". O que isso muda?

---

### Pergunta 70 — Cenário: Stakeholder insatisfeito com a velocidade de entrega

**Nível:** Júnior
**Categoria:** Cenários reais

**Pergunta do entrevistador:**
Um stakeholder importante reclama que "o time ágil está lento" e que "antes do Scrum, as coisas eram mais rápidas". Ele compara o time com outro time da empresa que "entrega muito mais". Como você responderia a essa reclamação e que dados usaria para ter uma conversa produtiva?

**O que essa pergunta avalia:**
Avalia a capacidade de gerenciar expectativas de stakeholders, usar dados para fundamentar conversas e evitar a armadilha de comparar times ágeis de forma inadequada.

**Resposta esperada:**

**Entender a reclamação:**
A reclamação pode ter várias causas:
1. **Percepção vs realidade:** O stakeholder pode *perceber* que está lento porque não vê o trabalho acontecendo (no Waterfall, havia um cronograma detalhado que dava "sensação de progresso").
2. **Comparação inválida com outro time:** Comparar velocity entre times é incorreto — cada time estima de forma diferente. 30 pontos de um time não equivalem a 30 de outro.
3. **Expectativa não alinhada:** O stakeholder pode não entender que o Scrum prioriza qualidade e feedback sobre velocidade bruta.
4. **Real lentidão:** Pode ser que o time esteja realmente lento — e isso precisa ser investigado.

**Como responder:**

1. **Ouvir antes de defender:** "Entendo sua preocupação. Pode me dar exemplos de onde sentiu lentidão?" Entender o que especificamente o stakeholder considera "lento".

2. **Não comparar velocity:** Explicar que "o Time B entrega mais pontos" é uma comparação inválida. É como comparar a nota de dois alunos que fizeram provas diferentes — os pontos não são equivalentes.

3. **Trazer dados relevantes:**
   - **Lead Time:** "O tempo médio de uma feature do pedido à entrega é X dias. Antes do Scrum, era Y. Reduzimos/aumentamos Z%."
   - **Throughput:** "Entregamos X features por mês. Aqui está a tendência."
   - **Bugs em produção:** "Tivemos X bugs em produção após a adoção do Scrum, comparado a Y antes — a qualidade melhorou."
   - **Valor entregue:** "Nas últimas 3 Sprints, entregimos as features A, B e C que estão sendo usadas por X usuários."

4. **Explicar a natureza do Scrum:**
   - "O Scrum entrega em incrementos a cada 2 semanas. No Waterfall, você esperava meses para ver algo. Pode *parecer* mais lento porque você vê o processo, mas na verdade entrega valor mais cedo."
   - "O Scrum prioriza entregar o *certo* sobre entregar *rápido*. Se entregamos rápido a feature errada, é desperdício."

5. **Investigar a reclamação legítima:**
   - Se o Lead Time realmente aumentou, investigar por quê
   - Se o Throughput caiu, identificar causas (impedimentos, WIP alto, etc.)
   - Trazer a discussão para a Retrospective se o time precisa melhorar

6. **Evitar defesa automática:** Não dizer "o Scrum é melhor, você não entende". Em vez disso, usar dados e diálogo.

**Explicação didática:**
Imagine duas transportadoras. A Transportadora A faz 10 entregas por dia, mas 3 chegam com a mercadoria danificada. A Transportadora B faz 6 entregas por dia, mas todas chegam intactas. Um cliente diz "a B é mais lenta". Sim, em volume é menor — mas em *valor entregue* (mercadorias intactas), pode ser superior. Precisamos olhar a métrica certa, não apenas "quantas entregas por dia".

**Exemplo prático:**
Conversa com o stakeholder:
- "Entendo que sinta o time lento. Vamos olhar os dados."
- "Nos últimos 3 meses, entregamos 24 features, com Lead Time médio de 12 dias. O time que você comparou tem velocity de 45 pontos, mas seu Lead Time é 18 dias e tem 2x mais bugs em produção."
- "Antes do Scrum, você recebia tudo no final de 6 meses. Agora, recebe incrementos a cada 2 semanas. O que mudou não é a velocidade — é a visibilidade. Você vê o trabalho acontecendo, o que pode dar a impressão de lentidão."
- "Se há uma feature específica que você sente que demorou demais, vamos olhar o Lead Time dela e entender o que aconteceu."

**Como o candidato deve responder:**
- Não defender automaticamente o Scrum
- Ouvir e entender a reclamação específica
- Explicar que comparar velocity entre times é inválido
- Trazer dados relevantes (Lead Time, Throughput, bugs, valor)
- Explicar a diferença entre "parecer lento" e "ser lento"
- Investigar se a reclamação tem fundamento
- Evitar descartar a reclamação como "falta de entendimento"

**Resposta fraca ou incompleta:**
"Eu diria ao stakeholder que o Scrum é melhor e que ele não entende como funciona ágil." — Condescendente e não-produutivo. Descartar a reclamação do stakeholder como "falta de entendimento" gera atrito e não resolve o problema. O stakeholder pode ter uma observação legítima que precisa ser investigada com dados.

**Critérios de avaliação:**
- **0** — Não sabe responder ou apresenta informações incorretas
- **1** — Identifica que precisa responder, mas não propõe abordagem
- **2** — Defende o Scrum sem dados ou investigação
- **3** — Ouvir, trazer dados, explicar comparação inválida
- **4** — Abordagem completa: ouvir, dados relevantes, não-comparação, investigar
- **5** — Domínio: empatia, dados, educação do stakeholder, investigação de causa, e transformação da reclamação em oportunidade de melhoria

**Perguntas de aprofundamento:**
1. Como medir "valor entregue" de forma que o stakeholder entenda?
2. O que fazer se, após a análise, o time realmente está mais lento que antes?
3. Como educar stakeholders sobre as métricas ágeis sem ser condescendente?

---

# Roteiro de Entrevista Técnica — Scrum, Kanban e Metodologias Ágeis

## Nível Júnior | Perguntas Misturadas

### Parte 6 — Perguntas 71 a 90

---

### Pergunta 71 — Como o time Scrum deve lidar com uma história que ficou incompleta ao final da Sprint?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Durante a Sprint Review, você percebe que uma das histórias planejadas não foi concluída — faltam testes e validação. O que deve acontecer com essa história? Ela vai para a próxima Sprint automaticamente?"

**O que essa pergunta avalia:**  
Compreensão do conceito de "Definition of Done" (Definição de Pronto), do fluxo de work items entre Sprints e do princípio de que itens não concluídos não se arrastam automaticamente. Avalia também se o candidato entende que o Product Backlog é dinâmico e que prioridades podem mudar entre Sprints.

**Resposta esperada:**  
A história incompleta deve retornar ao Product Backlog, e não ser automaticamente movida para a próxima Sprint. O Product Owner deve reavaliar sua prioridade junto às demais histórias. Se ainda for prioritária, ela pode ser incluída na próxima Sprint Planning, mas isso é uma decisão do Product Owner, não uma consequência automática. O time também deve discutir na Sprint Retrospective por que a história não foi concluída — houve subestimação de esforço, dependências não mapeadas, ou imprevistos?

**Explicação didática:**  
No Scrum, um item do Product Backlog só é considerado "Done" (pronto) quando atende à Definition of Done acordada pelo time. Se essa definição inclui testes, code review e documentação, uma história com o código escrito mas sem testes não está pronta. Itens não prontos voltam ao Product Backlog porque, entre o fim de uma Sprint e o início da próxima, o contexto pode mudar — novos requisitos podem surgir, prioridades podem ser reajustadas e a história pode deixar de ser a mais importante. Levá-la automaticamente para a próxima Sprint ignora essa dinâmica.

**Exemplo prático:**  
O time planejou uma história de "integrar API de pagamentos" na Sprint 7. Ao final, a integração está codificada, mas faltam testes de edge cases e validação do Product Owner. A história retorna ao Product Backlog. Na Sprint Planning 8, o Product Owner decide que uma nova demanda de correção de bug crítico tem prioridade maior. A história de pagamentos fica para uma Sprint futura.

**Como o candidato deve responder:**  
- Mencionar que a história retorna ao Product Backlog, não à próxima Sprint automaticamente;
- Citar a Definition of Done como critério de conclusão;
- Explicar que o Product Owner reavalia a prioridade;
- Sugerir que a Retrospectiva deve discutir as causas da não conclusão;
- Evitar dizer que "vai direto para a próxima Sprint" ou que "fica em pausa".

**Resposta fraca ou incompleta:**  
"Se não terminou, passa para a próxima Sprint e o time continua trabalhando nela." — Faltam a menção ao Product Backlog, à reavaliação de prioridade pelo Product Owner e à análise de causas na Retrospectiva.

**Critérios de avaliação:**
- 0 — Não sabe o que acontece com a história ou sugere algo incorreto;
- 1 — Sabe que a história não está pronta, mas não explica o fluxo correto;
- 2 — Menciona retorno ao Backlog, mas omite o papel do Product Owner;
- 3 — Explica o retorno ao Product Backlog e a reavaliação de prioridade;
- 4 — Cita Definition of Done, Product Owner, Retrospectiva e justifica a abordagem;
- 5 — Responde com profundidade, discute priorização dinâmica, causa raiz na Retrospectiva e boas práticas de estimativa.

**Perguntas de aprofundamento:**
1. "Por que não simplesmente manter a história na Sprint atual e estender o tempo?"
2. "Como você evita que histórias incompletas se tornem um padrão recorrente?"
3. "Se a história estava 90% pronta, o time deve 'somar' os pontos na próxima Sprint ou recalcular tudo?"

---

### Pergunta 72 — Qual é a diferença entre Product Backlog e Sprint Backlog?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Você pode explicar a diferença entre Product Backlog e Sprint Backlog? Quem é responsável por manter cada um deles?"

**O que essa pergunta avalia:**  
Conhecimento dos artefatos do Scrum, compreensão de suas diferenças de escopo e responsabilidade, e noção de como itens transitam de um backlog para o outro.

**Resposta esperada:**  
O **Product Backlog** é a lista ordenada de tudo que pode ser necessário no produto — funcionalidades, correções, melhorias, requisitos técnicos. É responsabilidade do Product Owner mantê-lo, garantindo que esteja ordenado por valor e claro para o time. Ele é dinâmico e evolui ao longo do projeto.

O **Sprint Backlog** é o subconjunto do Product Backlog selecionado para ser trabalhado em uma Sprint específica, somado ao plano de como entregar esses itens. É de responsabilidade conjunta dos Developers, que o montam durante a Sprint Planning e o atualizam ao longo da Sprint conforme o trabalho progride. Ele representa a meta da Sprint e o trabalho necessário para alcançá-la.

**Explicação didática:**  
Pense no Product Backlog como o cardápio completo de um restaurante — todas as opções que podem ser pedidas, organizadas por popularidade e valor. O Sprint Backlog é o pedido que a mesa fez agora — um subconjunto selecionado para ser entregue nesta refeição. O Product Owner cuida do cardápio (decide o que oferece e a ordem de prioridade); a equipe de cozinha (Developers) cuida do pedido atual (planeja e executa o que foi selecionado).

**Exemplo prático:**  
Product Backlog de um app de e-commerce: login social, carrinho persistente, checkout em uma tela, recomendações personalizadas, modo escuro. Sprint Backlog da Sprint 12: login social (3 pontos) + carrinho persistente (5 pontos) + meta da Sprint: "usuário consegue logar e manter itens no carrinho entre sessões".

**Como o candidato deve responder:**  
- Definir claramente os dois artefatos;
- Apontar o Product Owner como responsável pelo Product Backlog;
- Apontar os Developers como responsáveis pelo Sprint Backlog;
- Mencionar que o Sprint Backlog é um subconjunto do Product Backlog;
- Explicar que o Sprint Backlog inclui não só os itens, mas também o plano de trabalho;
- Evitar confundir os dois ou atribuir responsabilidades incorretamente.

**Resposta fraca ou incompleta:**  
"O Product Backlog é a lista geral e o Sprint Backlog é o que está na Sprint." — Correta, mas superficial. Faltam a menção aos responsáveis, à natureza dinâmica do Product Backlog e ao plano de trabalho no Sprint Backlog.

**Critérios de avaliação:**
- 0 — Não sabe a diferença ou confunde os dois artefatos;
- 1 — Sabe que são listas diferentes, mas não explica corretamente;
- 2 — Define os dois, mas omite responsabilidades ou detalhes do plano de trabalho;
- 3 — Diferencia corretamente, incluindo responsabilidades e relação entre eles;
- 4 — Explica com clareza, cita a dinamicidade do Product Backlog e o plano de entrega no Sprint Backlog;
- 5 — Responde com profundidade, usa analogias, menciona refinamento contínuo e Sprint Goal.

**Perguntas de aprofundamento:**
1. "O Sprint Backlog pode ser alterado durante a Sprint? Em quais condições?"
2. "Quem prioriza os itens do Product Backlog e quem estima os itens do Sprint Backlog?"
3. "O que acontece com o Sprint Backlog ao final da Sprint?"

---

### Pergunta 73 — O que é a Definition of Ready e como ela se relaciona com a Definition of Done?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Você já ouviu falar em Definition of Ready? O que é e como ela se diferencia da Definition of Done?"

**O que essa pergunta avalia:**  
Conhecimento dos dois conceitos de qualidade do Scrum, compreensão de que o "Ready" é um critério de entrada e o "Done" é um critério de saída, e a capacidade de explicar como ambos contribuem para previsibilidade.

**Resposta esperada:**  
A **Definition of Ready (DoR)** é um acordo do time sobre quais critérios uma história do Product Backlog precisa atender antes de ser considerada pronta para ser selecionada em uma Sprint Planning. Critérios comuns incluem: a história está escrita com critérios de aceitação claros, foi estimada, não tem dependências bloqueantes e o time entende o que precisa ser feito.

A **Definition of Done (DoD)** é um acordo sobre quando uma história está realmente concluída — ou seja, quais critérios devem ser atendidos para considerá-la entregue. Inclui coisas como: código testado, revisado, documentado, deployed em ambiente de homologação e validado pelo Product Owner.

A diferença é: o DoR garante que o time não compromete trabalho que ainda não está claro o suficiente; o DoD garante que o trabalho entregue tem qualidade e está realmente pronto para uso.

**Explicação didática:**  
Imagine uma receita de bolo. A Definition of Ready verifica se você tem todos os ingredientes separados, medidos e a receita em mãos antes de começar a cozinhar. A Definition of Done verifica se o bolo está assado, decorado e pronto para servir. O DoR previne que você comece a cozinhar sem ter farinha; o DoD previne que você sirva um bolo cru.

**Exemplo prático:**  
DoR: "A história tem título descritivo, descrição no formato user story, critérios de aceitação testáveis, estimada em pontos, e sem dependências externas não resolvidas."  
DoD: "Código commitado, testes unitários passando com cobertura mínima de 80%, code review aprovado, documentação atualizada, deploy em staging validado pelo Product Owner."

**Como o candidato deve responder:**  
- Definir DoR como critério de entrada e DoD como critério de saída;
- Dar exemplos de critérios para ambos;
- Explicar que DoR melhora a previsibilidade das Sprints;
- Explicar que DoD garante qualidade consistente;
- Mencionar que ambos são acordos do time e podem evoluir;
- Evitar confundir um com o outro ou tratá-os como a mesma coisa.

**Resposta fraca ou incompleta:**  
"A Definition of Ready é quando a história está pronta e a Definition of Done é quando terminou." — Vago demais. Não explica os critérios, a relação entre eles nem o propósito de cada um.

**Critérios de avaliação:**
- 0 — Não conhece os conceitos;
- 1 — Já ouviu falar, mas não sabe diferenciar;
- 2 — Define um dos dois corretamente, mas confunde ou omite o outro;
- 3 — Define e diferencia ambos corretamente;
- 4 — Explica com exemplos, cita o propósito de previsibilidade e qualidade;
- 5 — Responde com profundidade, discute evolução dos critérios, relação com estimativa e impacto no fluxo de trabalho.

**Perguntas de aprofundamento:**
1. "O que pode acontecer se o time não tem uma Definition of Ready?"
2. "A Definition of Done pode variar entre histórias diferentes?"
3. "Como o time decide quais critérios incluir na DoD?"

---

### Pergunta 74 — Como funciona a estimativa por Planning Poker no Scrum?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Explique como funciona o Planning Poker. Por que usamos cartas com a sequência de Fibonacci em vez de números sequenciais como 1, 2, 3, 4, 5?"

**O que essa pergunta avalia:**  
Conhecimento prático de uma técnica de estimativa ágil, compreensão da rationale por trás da escala não linear e entendimento do processo colaborativo de estimativa.

**Resposta esperada:**  
O Planning Poker é uma técnica de estimativa colaborativa usada no Scrum para estimar o esforço das histórias do Product Backlog. O processo funciona assim:

1. O Product Owner lê e explica uma história;
2. O time faz perguntas de esclarecimento;
3. Cada membro escolhe uma carta representando sua estimativa de esforço sem mostrá-la aos demais;
4. Todos revelam as cartas simultaneamente;
5. Se há discrepâncias grandes, os membros com a maior e menor estimativa justificam seu raciocínio;
6. O time discute e revota até chegar a um consenso ou aproximação aceitável.

Usamos a sequência de Fibonacci (1, 2, 3, 5, 8, 13, 21, 34, 55, 89) porque ela é não linear — a distância entre os valores aumenta conforme crescem. Isso reflete a natureza da estimativa de software: histórias pequenas são mais fáceis de estimar com precisão, então os valores próximos (1, 2, 3) fazem sentido. Histórias grandes têm mais incerteza, então forçar uma distinção entre, por exemplo, 21 e 22 seria falso precision. A sequência de Fibonacci força o time a reconhecer que estimativas maiores são inerentemente menos precisas.

**Explicação didática:**  
Imagine que você precisa estimar quanto tempo leva para organizar uma estante. Se é uma estante pequena com poucos livros, você pode estimar com bastante confiança (1, 2 ou 3 pontos). Mas se é uma biblioteca inteira, há tantas variáveis (quantos livros, quais categorias, espaço disponível) que tentar diferenciar entre 50 e 51 minutos seria ilusório. A escala de Fibonacci reflete isso: para tarefas grandes, os "degraus" são mais largos, reconhecendo a incerteza.

**Exemplo prático:**  
História: "Como usuário, quero fazer login com Google para não precisar criar uma nova senha."  
- Desenvolvedor A vota 3 (já fez integração OAuth antes)  
- Desenvolvedor B vota 8 (nunca trabalhou com OAuth e prevê complexidade)  
- Discussão: B aprende que a biblioteca já usada no projeto simplifica muito o trabalho. Revotação: ambos votam 5.

**Como o candidato deve responder:**  
- Explicar o processo passo a passo;
- Mencionar a votação simultânea para evitar viés de ancoragem;
- Explicar a escala de Fibonacci e sua natureza não linear;
- Citar a discussão após discrepâncias como momento de aprendizado;
- Evitar dizer que Fibonacci é "só uma convenção" sem explicar o porquê;
- Evitar confundir pontos de história com horas ou dias.

**Resposta fraca ou incompleta:**  
"É um jogo onde o time vota cartas para estimar histórias. Usa Fibonacci porque é a sequência padrão do Scrum." — Não explica o processo, não justifica a escala não linear e não menciona a dinâmica colaborativa.

**Critérios de avaliação:**
- 0 — Não sabe o que é Planning Poker;
- 1 — Sabe que é uma técnica de votação, mas não explica o processo;
- 2 — Explica o processo básico, mas não justifica a escala de Fibonacci;
- 3 — Explica o processo e a rationale da escala não linear;
- 4 — Adiciona o viés de ancoragem, a dinâmica de discussão e exemplos;
- 5 — Responde com profundidade, discute false precision, relação com velocity e melhoria contínua de estimativas.

**Perguntas de aprofundamento:**
1. "Por que as cartas são reveladas simultaneamente e não uma de cada vez?"
2. "O que fazer se o time não chega a um consenso após várias rodadas?"
3. "Estimativa em pontos de história é absoluta ou relativa?"

---

### Pergunta 75 — O que é velocity e como ele deve (e não deve) ser usado?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"O que é o velocity de um time Scrum? Como ele é calculado e quais são os cuidados ao utilizá-lo?"

**O que essa pergunta avalia:**  
Compreensão de uma métrica fundamental do Scrum, conhecimento de como ela é calculada e consciência dos riscos de seu uso inadequado como meta ou ferramenta de cobrança.

**Resposta esperada:**  
Velocity é a medida da quantidade de trabalho que um time conclui em uma Sprint, expressa em pontos de história (ou story points). Ele é calculado somando-se os pontos de todas as histórias que atingiram a Definition of Done ao final da Sprint.

Usos corretos do velocity:
- Ajudar o time a prever quantos pontos consegue entregar em Sprints futuras, melhorando o planejamento;
- Identificar tendências ao longo do tempo (estabilidade, melhoria ou regressão);
- Fornecer dados para release planning e forecast.

Usos incorretos do velocity:
- Usá-lo como meta ou objetivo a ser batido, o que pode levar o time a inflar estimativas ou sacrificar qualidade;
- Comparar velocity entre times diferentes (cada time estima de forma diferente);
- Usá-lo como métrica de desempenho individual;
- Punir o time por variações naturais no velocity.

**Explicação didática:**  
Pense no velocity como a velocidade média de um carro em uma viagem. Ela te dá uma ideia de quando você vai chegar ao destino, mas não é algo que você "força" — tentar acelerar além do seguro pode causar acidentes. Da mesma forma, o velocity é uma observação de padrões passados, não uma meta a ser perseguida. Se você transforma a observação em cobrança, as pessoas começam a "inflar" as estimativas para parecer que entregam mais — o que destrói a utilidade da métrica.

**Exemplo prático:**  
Sprint 1: 18 pontos | Sprint 2: 22 pontos | Sprint 3: 20 pontos | Sprint 4: 19 pontos. O velocity médio é aproximadamente 20 pontos. Na Sprint Planning 5, o time pode planejar com conforto algo entre 18 e 22 pontos. Se alguém diz "vamos fazer 30 pontos para mostrar produtividade", isso é um uso indevido da métrica.

**Como o candidato deve responder:**  
- Definir velocity como soma de pontos das histórias concluídas;
- Explicar seu uso para previsão e planejamento de release;
- Alertar contra uso como meta ou ferramenta de cobrança;
- Mencionar que não é comparável entre times;
- Citar que variações são normais e esperadas;
- Evitar tratar velocity como medida de qualidade ou produtividade individual.

**Resposta fraca ou incompleta:**  
"Velocity é a velocidade do time. Se o time fez 20 pontos, o velocity é 20." — Superficial. Não explica como é calculado, não menciona usos corretos e incorretos, nem alerta sobre riscos.

**Critérios de avaliação:**
- 0 — Não sabe o que é velocity;
- 1 — Sabe que é uma medida de trabalho, mas não explica cálculo nem usos;
- 2 — Explica o cálculo básico, mas não alerta sobre usos inadequados;
- 3 — Explica cálculo, usos corretos e incorretos;
- 4 — Adiciona exemplos, discute comparação entre times e variações naturais;
- 5 — Responde com profundidade, discute inflação de estimativa, relação com DoD e impacto organizacional da métrica mal utilizada.

**Perguntas de aprofundamento:**
1. "O que acontece com o velocity se o time começar a inflar as estimativas para 'melhorar' o número?"
2. "Velocity pode ser usado para comparar dois times que trabalham no mesmo produto?"
3. "Como o velocity ajuda no release planning?"

---

### Pergunta 76 — O que é um impedimento no Scrum e qual é o papel do Scrum Master em relação a ele?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"No Scrum, falamos muito sobre 'impedimentos'. O que é um impedimento? Qual é a diferença entre um impedimento e um problema comum do dia a dia? E qual é a responsabilidade do Scrum Master em relação a eles?"

**O que essa pergunta avalia:**  
Compreensão do conceito de impedimento, capacidade de diferenciá-lo de problemas rotineiros, e conhecimento do papel do Scrum Master como facilitador que remove bloqueadores.

**Resposta esperada:**  
Um **impedimento** é qualquer obstáculo que reduz ou impede a eficiência do time na entrega de valor durante a Sprint. Exemplos: um ambiente de teste indisponível, dependência de outro time que não responde, falta de acesso a uma ferramenta necessária, ou um conflito interpessoal que prejudica a colaboração.

A diferença entre um impedimento e um problema comum é de **escala e impacto**. Um problema comum é algo que o time resolve no seu dia a dia — uma dúvida técnica, um bug pequeno, uma decisão de implementação. Um impedimento é algo que o time não consegue resolver sozinho ou que está bloqueando o progresso de forma significativa e requer ação externa.

O Scrum Master é responsável por **identificar, registrar e facilitar a remoção de impedimentos**. O Scrum Master mantém um "Impediment Backlog" ou lista de impedimentos, trabalha para resolvê-los diretamente quando possível, ou os escala para quem possa resolvê-los (gestores, outros times, liderança). O Scrum Master não necessariamente resolve o impedimento sozinho, mas garante que ele seja tratado.

**Explicação didática:**  
Imagine uma obra de construção. Um pedreiro precisando de mais tijolos é um problema comum — ele resolve pedindo ao ajudante. Mas se o fornecedor de cimento atrasou a entrega e toda a obra parou, isso é um impedimento — o pedreiro não pode resolver sozinho, alguém precisa intervir externamente. O Scrum Master é como o mestre de obras que identifica que o cimento não veio, liga para o fornecedor e garante que a obra volte a andar.

**Exemplo prático:**  
Durante a Sprint, o time descobre que o servidor de homologação está fora do ar há dois dias. Isso impede testes e validação. O Scrum Master registra o impedimento, comunica ao time de infraestrutura, acompanha a resolução e atualiza o time diariamente no Daily Scrum sobre o progresso.

**Como o candidato deve responder:**  
- Definir impedimento como bloqueador que reduz ou impede a eficiência do time;
- Diferenciar de problemas comuns que o time resolve sozinho;
- Explicar que o Scrum Master identifica, registra e facilita a remoção;
- Mencionar que o Scrum Master pode escalar quando não tem autoridade para resolver;
- Citar que impedimentos devem ser visíveis e acompanhados;
- Evitar confundir impedimento com tarefa técnica ou bug.

**Resposta fraca ou incompleta:**  
"Impedimento é quando algo dá errado e o Scrum Master resolve." — Simplório. Não diferencia impedimento de problema comum, não explica o processo de registro e acompanhamento, e atribui resolução direta ao Scrum Master sem mencionar escalonamento.

**Critérios de avaliação:**
- 0 — Não sabe o que é impedimento;
- 1 — Sabe que é um problema, mas não diferencia de questões rotineiras;
- 2 — Define impedimento, mas não explica bem o papel do Scrum Master;
- 3 — Define, diferencia e explica o papel do Scrum Master;
- 4 — Adiciona exemplos, menciona registro visível e escalonamento;
- 5 — Responde com profundidade, discute impedimentos sistêmicos vs. pontuais e impacto no velocity.

**Perguntas de aprofundamento:**
1. "Como o time deve registrar impedimentos para que não sejam esquecidos?"
2. "O que acontece se o Scrum Master não consegue remover um impedimento?"
3. "Um impedimento pode virar um item do Product Backlog?"

---

### Pergunta 77 — O que é o conceito de "Pull System" no Kanban e como ele se diferencia de um sistema "Push"?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"No Kanban, diz-se que o trabalho é baseado em um sistema 'Pull'. O que isso significa? Como isso difere de um sistema 'Push' e por que o Pull é considerado mais eficiente?"

**O que essa pergunta avalia:**  
Compreensão de um conceito central do Kanban, capacidade de contrastar Push vs. Pull, e entendimento dos benefícios do Pull em termos de fluxo e limitação de WIP.

**Resposta esperada:**  
Em um **sistema Pull**, o trabalho é "puxado" para a próxima etapa apenas quando há capacidade disponível. Ou seja, um membro do time ou coluna do quadro Kanban só pega um novo item quando tem espaço (respeitando o limite de WIP) e quando o item anterior foi finalizado ou movido. O trabalho flui em resposta à demanda real.

Em um **sistema Push**, o trabalho é "empurrado" para a próxima etapa assim que a etapa atual é concluída, independentemente de haver capacidade no destino. Isso pode causar acúmulo de trabalho em etapas que não conseguem processar — criando filas, gargalos e aumento de lead time.

O Pull é mais eficiente porque:
- Limita o trabalho em progresso (WIP), reduzindo multitarefa e melhorando o foco;
- Previne gargalos, já que itens não são empurrados para etapas sem capacidade;
- Reduz o lead time, pois itens não ficam esperando em filas longas;
- Torna os problemas visíveis mais cedo — se uma etapa para de puxar, algo está errado e precisa ser resolvido.

**Explicação didática:**  
Pense em um restaurante. No modelo Push, a cozinha produz pratos e manda para o salão, independentemente de se há garçons disponíveis para entregar — os pratos se acumulam na bancada e esfriam. No modelo Pull, o garçom vai à cozinha e pega um prato somente quando tem uma mesa esperando — nada se acumula, nada esfria, e a cozinha sabe exatamente a demanda real.

**Exemplo prático:**  
Em um time de desenvolvimento com colunas "To Do → Dev → Test → Done" e WIP limit de 3 na coluna Dev: quando um desenvolvedor termina um item e ele vai para Test, o desenvolvedor só puxa um novo item de To Do se a coluna Dev tiver menos de 3 itens. Se já houver 3 itens em Dev, ninguém puxa mais — o time precisa ajudar a desbloquear o fluxo antes de iniciar novo trabalho.

**Como o candidato deve responder:**  
- Definir Pull como puxar trabalho quando há capacidade;
- Definir Push como empurrar trabalho ao concluir uma etapa;
- Explicar a relação com limite de WIP;
- Citar benefícios: menos gargalos, menos filas, lead time menor;
- Mencionar que o Pull torna problemas visíveis;
- Evitar confundir Pull com "não planejar" ou "trabalhar sem ordem".

**Resposta fraca ou incompleta:**  
"Pull é quando o time puxa o trabalho e Push é quando alguém empurra." — Não explica o critério de capacidade, não relaciona com WIP e não cita benefícios.

**Critérios de avaliação:**
- 0 — Não conhece os conceitos;
- 1 — Sabe que Pull é puxar, mas não explica os mecanismos;
- 2 — Diferencia Push e Pull, mas não relaciona com WIP nem benefícios;
- 3 — Explica Pull, Push, WIP e benefícios básicos;
- 4 — Adiciona exemplos práticos e discute visibilidade de problemas;
- 5 — Responde com profundidade, discute Little's Law, fluxo contínuo e impacto no lead time.

**Perguntas de aprofundamento:**
1. "O que acontece se o limite de WIP for muito alto? E se for muito baixo?"
2. "É possível ter um sistema Push dentro de um sistema Pull?"
3. "Como o Pull ajuda a identificar gargalos no processo?"

---

### Pergunta 78 — O que é o Daily Scrum e quais são os erros mais comuns na sua condução?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Descreva o Daily Scrum. Quais são os erros mais comuns que você já viu ou já cometeu ao participar dessa cerimônia?"

**O que essa pergunta avalia:**  
Conhecimento do propósito e formato do Daily Scrum, capacidade de identificar antipadrões, e maturidade para refletir sobre erros — o que indica experiência prática.

**Resposta esperada:**  
O Daily Scrum é um evento de 15 minutos realizado todos os dias da Sprint, onde os Developers sincronizam atividades e criam um plano para as próximas 24 horas. O foco é a meta da Sprint (Sprint Goal). Não é uma reunião de status para o Scrum Master ou Product Owner — é dos Developers, para os Developers.

Erros comuns:
1. **Transformar em reunião de status:** Relatar para o Scrum Master em vez de conversar entre o time;
2. **Seguir as 3 perguntas mecanicamente:** "O que fiz ontem, o que farei hoje, há impedimentos?" sem adaptar ao contexto;
3. **Resolver problemas na reunião:** Começar a discutir soluções técnicas que deveriam ser tratadas depois;
4. **Duração excessiva:** Passar de 15 minutos por falta de foco;
5. **Falta de preparação:** Membros chegam sem saber o que vão falar;
6. **Usar como cobrança:** O Scrum Master ou Product Owner usa para pressionar o time;
7. **Participação passiva:** Membros só falam por obrigação e não colaboram com o plano do dia;
8. **Não atualizar o Sprint Backlog:** O Daily deve resultar em atualização do Sprint Backlog, não só conversa.

**Explicação didática:**  
O Daily Scrum é como o momento em que uma equipe de remo se alinha antes de continuar a remar. Cada remador precisa saber o ritmo, onde estão e para onde vão. Não é o momento de discutir como consertar o remo quebrado — isso fica para depois. É o momento de alinhar: "estamos juntos, sabemos o que cada um faz agora, e sabemos o que nos impede de avançar."

**Exemplo prático:**  
Daily Scrum eficiente (7 minutos):  
- Ana: "Testei a história de login, está bloqueada por uma API que retorna 500. Preciso que o time de backend verifique."  
- Bruno: "Vou pegar a história de carrinho. Ana, posso te ajudar a isolar o problema da API em paralelo."  
- Carla: "Estou finalizando a tela de checkout. Não tenho impedimentos."  
Plano: Bruno e Ana investigam a API; Carla continua checkout; quadro atualizado.

**Como o candidato deve responder:**  
- Definir o Daily como evento dos Developers de 15 minutos;
- Citar o foco na Sprint Goal;
- Listar pelo menos 3 erros comuns com explicação;
- Sugerir como evitar cada erro;
- Mencionar que deve resultar em plano de ação e atualização do Sprint Backlog;
- Evitar descrever o Daily como "reunião de reporte de status" ou "momento de cobrança".

**Resposta fraca ou incompleta:**  
"É a reunião diária onde cada um fala o que fez e o que vai fazer. Às vezes demora mais que 15 minutos." — Não menciona o propósito de sincronização, não lista erros comuns relevantes e não menciona o Sprint Goal.

**Critérios de avaliação:**
- 0 — Não sabe o que é o Daily Scrum;
- 1 — Define superficialmente, mas não identifica erros;
- 2 — Define e cita 1-2 erros, mas superficialmente;
- 3 — Define corretamente e lista 3+ erros com explicação;
- 4 — Adiciona soluções para os erros e exemplos práticos;
- 5 — Responde com profundidade, discute formato alternativo às 3 perguntas, impacto cultural e evolução da cerimônia.

**Perguntas de aprofundamento:**
1. "O que fazer se o time insiste em resolver problemas técnicos durante o Daily?"
2. "É obrigatório responder às três perguntas clássicas?"
3. "Como evitar que o Daily vire uma reunião de status para o Product Owner?"

---

### Pergunta 79 — O que é o "Refinement" ou refinamento do Product Backlog e quando ele deve acontecer?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Fale sobre o refinamento do Product Backlog. O que é essa atividade, quem participa e quando ela deve acontecer na Sprint?"

**O que essa pergunta avalia:**  
Conhecimento de uma atividade contínua essencial do Scrum, compreensão de que ela não é uma cerimônia formal mas uma prática contínua, e entendimento de como ela prepara o time para Sprints futuras.

**Resposta esperada:**  
O **refinamento do Product Backlog** (ou Product Backlog Refinement) é a atividade contínua de adicionar detalhes, estimativas e ordem aos itens do Product Backlog. É o processo de "quebrar" histórias grandes (epics) em histórias menores e acionáveis, esclarecer requisitos com o Product Owner, adicionar ou ajustar critérios de aceitação e estimar itens.

**Quem participa:** O Product Owner (que lidera o refinamento), os Developers (que contribuem com visão técnica e estimativas) e, quando relevante, stakeholders ou especialistas para esclarecer dúvidas.

**Quando acontece:** O refinamento é uma atividade contínua, não uma cerimônia formal. Muitos times dedicam cerca de 5-10% da capacidade da Sprint para refinamento, frequentemente em sessões agendadas (ex: 1-2 horas no meio da Sprint). O objetivo é garantir que, na próxima Sprint Planning, já existam itens suficientemente refinados e prontos (atendendo à Definition of Ready) para serem selecionados.

**Explicação didática:**  
Imagine que o Product Backlog é uma despensa. O refinamento é como verificar o que está na despensa, organizar os ingredientes, verificar o que está faltando e separar o que vai ser usado na próxima receita. Se você chega na Sprint Planning sem itens refinados, é como tentar cozinhar sem ter verificado se tem os ingredientes — você vai perder tempo decidindo o que fazer em vez de simplesmente começar.

**Exemplo prático:**  
Durante a Sprint 10, o time dedica 2 horas na quarta-feira para refinar o Backlog. O Product Owner apresenta um epic: "Como usuário, quero um sistema de avaliações de produtos." O time discute, divide em histórias menores ("exibir avaliações", "adicionar avaliação", "moderar avaliações"), escreve critérios de aceitação e estima as duas primeiras. Na Sprint Planning 11, essas histórias já estão prontas para serem selecionadas.

**Como o candidato deve responder:**  
- Definir refinamento como atividade contínua de detalhar e estimar itens;
- Citar que o Product Owner lidera e os Developers participam;
- Mencionar que não é uma cerimônia formal, mas prática contínua;
- Explicar a relação com a Definition of Ready;
- Citar que prepara itens para a próxima Sprint Planning;
- Evitar confundir refinamento com Sprint Planning ou Sprint Review.

**Resposta fraca ou incompleta:**  
"Refinamento é quando o time detalha as histórias antes da Sprint." — Correto, mas incompleto. Faltam quem participa, a natureza contínua, o percentual de tempo dedicado e a relação com a DoR.

**Critérios de avaliação:**
- 0 — Não conhece o conceito;
- 1 — Sabe que é detalhar histórias, mas não explica processo nem participantes;
- 2 — Define, mas omite a natureza contínua ou a relação com Sprint Planning;
- 3 — Explica processo, participantes, momento e propósito;
- 4 — Adiciona exemplos, cita Definition of Ready e percentual de tempo;
- 5 — Responde com profundidade, discute splitting de histórias, priorização baseada em valor e impacto na previsibilidade.

**Perguntas de aprofundamento:**
1. "O que acontece se o time não refina o Backlog e chega na Sprint Planning sem itens prontos?"
2. "Quem decide quanto tempo o time deve dedicar ao refinamento?"
3. "Uma história pode mudar de prioridade durante o refinamento?"

---

### Pergunta 80 — Explique o conceito de "WIP Limit" no Kanban e o que acontece quando ele é excedido

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"O que é o WIP Limit no Kanban? Por que ele existe e o que deve acontecer quando o time percebe que está prestes a excedê-lo?"

**O que essa pergunta avalia:**  
Conhecimento prático de uma das práticas essenciais do Kanban, compreensão da rationale por trás da limitação de trabalho em progresso, e atitude correta ao lidar com essa situação.

**Resposta esperada:**  
**WIP Limit** (Work In Progress Limit) é o limite máximo de itens que podem estar simultaneamente em uma coluna (ou em todo o quadro) do Kanban. Ele existe para forçar o foco, evitar multitarefa excessiva, reduzir lead time e tornar gargalos visíveis.

Quando o time percebe que está prestes a exceder o WIP Limit, deve:
1. **Não iniciar novo trabalho** — o princípio do "Stop Starting, Start Finishing" (pare de começar, comece a terminar);
2. **Focar em terminar o que está em andamento** — mobilizar o time para ajudar a desbloquear e concluir os itens em progresso;
3. **Investigar a causa** — por que o trabalho está se acumulando? Há um gargalo em uma etapa específica? Há dependências externas?
4. **Ajustar se necessário** — o WIP Limit pode ser revisado, mas isso deve ser uma decisão consciente do time, não uma exceção rotineira.

Exceder o WIP Limit repetidamente é um sinal de problema sistêmico: estimativas incorretas, capacidade superestimada, ou gargalo não resolvido em uma etapa do fluxo.

**Explicação didática:**  
Imagine uma rodovia com 3 faixas. Se cada faixa comporta 50 carros, o limite é 150 carros. Se você permite 200, o trânsito para — ninguém chega ao destino mais rápido. Com o limite respeitado, os carros fluem. O WIP Limit é como um semáforo que só deixa entrar novos carros na rodovia quando há espaço, garantindo que todos se movam.

**Exemplo prático:**  
Quadro Kanban com coluna "Em Desenvolvimento" e WIP Limit = 3. Há 3 itens na coluna. Um desenvolvedor termina um item e ele vai para "Test". Agora há 2 itens em Dev e espaço para 1. O desenvolvedor pode puxar um novo item de "To Do". Se o time tentar puxar um 4º item enquanto os 3 ainda estão em Dev, o limite é violado — o time deve focar em mover itens para frente, não em começar novos.

**Como o candidato deve responder:**  
- Definir WIP Limit como limite máximo de itens em uma coluna/quadro;
- Explicar que evita multitarefa e melhora fluxo;
- Citar o princípio "Stop Starting, Start Finishing";
- Explicar o que fazer ao se aproximar do limite;
- Mencionar que exceder repetidamente indica problema sistêmico;
- Evitar dizer que o WIP Limit é "sugestão" ou que pode ser ignorado sem consequências.

**Resposta fraca ou incompleta:**  
"WIP Limit é o máximo de tarefas que o time pode fazer ao mesmo tempo. Se passar, o time tem que trabalhar mais rápido." — Incorreto na última parte. O WIP Limit não é sobre trabalhar mais rápido, é sobre focar em terminar antes de começar novo trabalho.

**Critérios de avaliação:**
- 0 — Não sabe o que é WIP Limit;
- 1 — Sabe que é um limite, mas não explica porquê nem o que fazer;
- 2 — Define e explica o propósito, mas não descreve ação ao exceder;
- 3 — Define, explica e descreve as ações corretas;
- 4 — Adiciona exemplos, cita "Stop Starting, Start Finishing" e discute gargalos;
- 5 — Responde com profundidade, discute relação com lead time, throughput e ajuste consciente vs. exceção rotineira.

**Perguntas de aprofundamento:**
1. "Como o time decide qual deve ser o valor do WIP Limit?"
2. "É melhor ter WIP Limits por coluna ou por pessoa?"
3. "O que fazer se o time consistentemente não consegue respeitar o WIP Limit?"

---

### Pergunta 81 — O que é a Sprint Goal e por que ela é importante?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Durante a Sprint Planning, o time define uma Sprint Goal. O que é essa meta e por que ela é mais importante do que simplesmente listar as histórias que serão feitas?"

**O que essa pergunta avalia:**  
Compreensão de um conceito central do Scrum que dá propósito à Sprint, capacidade de diferenciar "lista de tarefas" de "objetivo coletivo", e entendimento de como a Sprint Goal guia decisões durante a Sprint.

**Resposta esperada:**  
A **Sprint Goal** é o objetivo único e coeso que o time se compromete a alcançar durante a Sprint. Ela não é uma lista de histórias — é a razão pela qual essas histórias foram selecionadas juntas. Ela dá foco e propósito ao trabalho da Sprint.

A Sprint Goal é importante porque:
1. **Foco:** O time sabe o que precisa entregar como valor, não apenas quais tarefas fazer;
2. **Flexibilidade:** Se surgir trabalho imprevisto, o time pode trocar histórias desde que a Sprint Goal ainda seja alcançada. Não é necessário seguir a lista de histórias rigidamente se o objetivo ainda é atendido;
3. **Coerência:** Ajuda o time a entender por que essas histórias estão juntas na Sprint, criando um sentido de propósito compartilhado;
4. **Critério de sucesso:** Na Sprint Review, o time avalia se a Sprint Goal foi alcançada, não apenas quantas histórias foram concluídas;
5. **Colaboração:** O time trabalha em direção a um objetivo comum, não a um conjunto de tarefas individuais.

**Explicação didática:**  
Imagine que a Sprint é uma viagem de carro. As histórias são os pontos de parada no caminho. A Sprint Goal é o destino final. Se uma estrada está bloqueada, você pode pegar outro caminho (trocar histórias) desde que ainda chegue ao destino. Sem Sprint Goal, o time é como um grupo de carros sem destino — cada um vai para um lado e ninguém sabe se chegou onde deveria.

**Exemplo prático:**  
Sprint Goal: "Usuários podem se cadastrar e fazer login no app usando e-mail ou Google."  
Histórias relacionadas: criar formulário de cadastro, implementar login com e-mail, integrar login com Google, criar tela de recuperação de senha.  
Se durante a Sprint o time percebe que a recuperação de senha é mais complexa que o esperado, eles podem removê-la da Sprint e ainda assim entregar a Sprint Goal (cadastro e login funcionando).

**Como o candidato deve responder:**  
- Definir Sprint Goal como objetivo coeso da Sprint;
- Explicar que ela dá propósito e foco;
- Citar que permite flexibilidade para trocar histórias;
- Mencionar que é definida durante a Sprint Planning;
- Explicar que ela guia a avaliação na Sprint Review;
- Evitar confundir Sprint Goal com lista de histórias ou meta de velocity.

**Resposta fraca ou incompleta:**  
"É a meta da Sprint, o que o time precisa entregar." — Genérico. Não explica a diferença entre Sprint Goal e lista de histórias, nem como ela guia decisões durante a Sprint.

**Critérios de avaliação:**
- 0 — Não sabe o que é Sprint Goal;
- 1 — Sabe que existe, mas não explica propósito;
- 2 — Define, mas não diferencia de lista de histórias;
- 3 — Define, diferencia e explica pelo menos 2 benefícios;
- 4 — Explica foco, flexibilidade e critério de sucesso com exemplos;
- 5 — Responde com profundidade, discute negociação com Product Owner, impacto no Daily Scrum e Sprint Review.

**Perguntas de aprofundamento:**
1. "Quem define a Sprint Goal — o Product Owner, o time ou ambos?"
2. "O que fazer se a Sprint Goal se torna inviável no meio da Sprint?"
3. "Pode haver mais de uma Sprint Goal por Sprint?"

---

### Pergunta 82 — O que é "Lead Time" e "Cycle Time" no Kanban e qual é a diferença entre eles?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"No Kanban, ouvimos falar em Lead Time e Cycle Time. O que cada um mede e qual é a diferença prática entre eles?"

**O que essa pergunta avalia:**  
Conhecimento de duas métricas fundamentais do Kanban, capacidade de diferenciá-las, e entendimento de como cada uma ajuda a entender o fluxo de trabalho.

**Resposta esperada:**  
**Lead Time** é o tempo total desde o momento em que um item é solicitado (entra no backlog ou é comprometido) até o momento em que é entregue (chega em Done). Ele mede a experiência do cliente ou solicitante — quanto tempo eles esperam desde que pediram até receber.

**Cycle Time** é o tempo desde o momento em que o time começa a trabalhar no item (ele entra em uma coluna de "Em Progresso" ou "Work In Progress") até o momento em que é entregue. Ele mede a eficiência do processo de trabalho — quanto tempo o time leva para transformar um item em valor entregue.

A diferença: o Lead Time inclui o tempo que o item ficou esperando no backlog antes de ser iniciado. O Cycle Time só conta a partir do momento em que o trabalho realmente começou.

**Lead Time ≥ Cycle Time**, sempre. O Lead Time pode ser muito maior que o Cycle Time se houver muito tempo de espera no backlog.

**Explicação didática:**  
Imagine que você pede uma pizza. O Lead Time é desde o momento em que você faz o pedido até a pizza chegar na sua porta. O Cycle Time é desde o momento em que o pizzairo começa a preparar até a pizza sair do forno. Se a pizzaria tem muitos pedidos na fila, seu Lead Time aumenta (você espera mais), mas o Cycle Time da sua pizza (tempo de preparo) é o mesmo.

**Exemplo prático:**  
Um bug é reportado em 1º de março e entra no backlog. O time só começa a trabalhar nele em 10 de março. Ele é corrigido e entregue em 13 de março.  
- Lead Time: 1º de março a 13 de março = 12 dias  
- Cycle Time: 10 de março a 13 de março = 3 dias  
A diferença (9 dias) representa o tempo de espera no backlog. Esse tempo de espera é um sinal de que itens estão acumulando antes de serem iniciados.

**Como o candidato deve responder:**  
- Definir Lead Time como tempo do pedido à entrega;
- Definir Cycle Time como tempo do início do trabalho à entrega;
- Explicar a diferença com clareza;
- Citar que Lead Time ≥ Cycle Time;
- Mencionar que o tempo de espera no backlog é a diferença;
- Evitar confundir um com o outro ou tratá-los como sinônimos.

**Resposta fraca ou incompleta:**  
"Lead Time é o tempo total e Cycle Time é o tempo de produção." — Vago. Não define os pontos de início e fim de cada métrica, nem mostra a relação entre elas.

**Critérios de avaliação:**
- 0 — Não conhece as métricas;
- 1 — Já ouviu falar, mas não diferencia;
- 2 — Define uma das duas corretamente;
- 3 — Define e diferencia ambas corretamente;
- 4 — Explica com exemplo e discute impacto do tempo de espera;
- 5 — Responde com profundidade, discute uso para previsibilidade, identificação de gargalos e otimização de fluxo.

**Perguntas de aprofundamento:**
1. "Como reduzir o Lead Time sem necessariamente reduzir o Cycle Time?"
2. "Por que o Cycle Time é mais útil para o time e o Lead Time mais útil para o cliente?"
3. "O que acontece quando o Lead Time é muito maior que o Cycle Time?"

---

### Pergunta 83 — O que é o "Burndown Chart" e como interpretá-lo?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Você já trabalhou com Burndown Chart? O que ele mostra e como você interpreta um gráfico onde a linha real está acima da linha ideal no meio da Sprint?"

**O que essa pergunta avalia:**  
Conhecimento de uma ferramenta visual de acompanhamento de Sprint, capacidade de interpretar desvios, e entendimento de que o gráfico é informativo, não punitivo.

**Resposta esperada:**  
O **Burndown Chart** é um gráfico que mostra a quantidade de trabalho restante (eixo Y) ao longo dos dias da Sprint (eixo X). Ele tem duas linhas principais:
- **Linha ideal:** Uma linha reta do total de pontos no Dia 1 até zero no último dia da Sprint, representando o progresso ideal;
- **Linha real:** O progresso real do time, atualizado diariamente conforme o trabalho é concluído.

Se a linha real está **acima** da linha ideal no meio da Sprint, significa que o time está "atrasado" em relação ao progresso ideal — há mais trabalho restante do que o esperado para aquele ponto da Sprint. Isso pode indicar:
- Histórias que se mostraram mais complexas que o esperado;
- Impedimentos que reduziram a produtividade;
- Estimativas otimistas demais na Planning;
- Itens adicionados à Sprint após o planejamento.

O gráfico não é punitivo — ele é um sinal para o time conversar no Daily Scrum sobre o que está acontecendo e o que pode ser ajustado. O time pode reduzir o escopo da Sprint (renegociar com o Product Owner) ou focar em desbloquear impedimentos.

**Explicação didática:**  
O Burndown é como o medidor de combustível do carro. Se a linha real está acima da ideal, é como se você estivesse consumindo mais combustível que o esperado — não que você está errado, mas é um sinal de que precisa prestar atenção. Talvez o caminho esteja mais longo que o previsto, e você precise decidir se continua ou se ajusta a rota.

**Exemplo prático:**  
Sprint de 10 dias, 30 pontos planejados. No Dia 5, a linha ideal mostra 15 pontos restantes. Mas a linha real mostra 22 pontos restantes. O time está consumindo menos pontos que o esperado. Na próxima Daily, o time discute: uma história de integração de API está mais complexa que o previsto. Decisão: o Scrum Master ajuda a desbloquear a dependência e o time foca em terminar as histórias em andamento antes de iniciar novas.

**Como o candidato deve responder:**  
- Definir o gráfico e seus eixos;
- Explicar as duas linhas (ideal e real);
- Interpretar corretamente a linha real acima da ideal;
- Citar possíveis causas do desvio;
- Explicar que o gráfico é informativo, não punitivo;
- Mencionar ações: desbloquear, reduzir escopo, focar em terminar;
- Evitar dizer que o gráfico serve para "punir" o time ou "cobrar produtividade".

**Resposta fraca ou incompleta:**  
"É um gráfico que mostra se o time está indo bem ou mal. Se a linha está acima, está mal." — Não explica o que é o gráfico (eixos, linhas), não interpreta as causas nem sugere ações.

**Critérios de avaliação:**
- 0 — Não conhece o Burndown Chart;
- 1 — Sabe que é um gráfico de progresso, mas não interpreta;
- 2 — Explica o gráfico, mas não interpreta desvios;
- 3 — Explica e interpreta corretamente os desvios;
- 4 — Adiciona causas possíveis, ações e exemplos práticos;
- 5 — Responde com profundidade, discute Burnup vs. Burndown, limitações e uso para previsibilidade.

**Perguntas de aprofundamento:**
1. "Qual é a diferença entre Burndown e Burnup Chart?"
2. "O que significa se a linha real sobe em vez de descer?"
3. "O Burndown Chart deve usar pontos de história ou número de tarefas?"

---

### Pergunta 84 — O que é um "User Story" e qual é a estrutura recomendada para escrevê-lo?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Explique o que é uma User Story e qual é o formato recomendado para escrevê-la. Por que usamos esse formato?"

**O que essa pergunta avalia:**  
Conhecimento de um dos formatos mais comuns de representar requisitos no Scrum, compreensão da estrutura e rationale, e entendimento de que a User Story não substitui especificação detalhada — ela é um ponto de conversa.

**Resposta esperada:**  
Uma **User Story** (história de usuário) é uma descrição curta e informal de uma funcionalidade do produto, escrita do ponto de vista do usuário ou cliente. O objetivo é capturar o "quem", o "o quê" e o "porquê" de um requisito de forma que facilite a conversa entre o time e o Product Owner.

O formato recomendado é:

> Como [tipo de usuário], quero [ação/funcionalidade] para [valor/benefício]

- **Como [tipo de usuário]:** Define quem precisa da funcionalidade (ex: "como cliente cadastrado");
- **Quero [ação/funcionalidade]:** Define o que o usuário quer fazer (ex: "quero salvar itens no carrinho");
- **Para [valor/benefício]:** Define por que isso é importante (ex: "para não perder meus itens ao fechar o app").

Usamos esse formato porque:
1. **Foco no usuário:** Força pensar no requisito do ponto de vista de quem usa, não de quem desenvolve;
2. **Valor explícito:** O "para" garante que cada requisito tenha um propósito, evitando funcionalidades sem justificativa;
3. **Facilita conversa:** A história é um convite à conversa, não uma especificação fechada — os detalhes são discutidos e refinados em conversas entre time e Product Owner;
4. **Simples e acessível:** Qualquer pessoa, técnica ou não, consegue entender o que está escrito.

Além da User Story, é importante incluir **critérios de aceitação** — condições testáveis que definem quando a história está pronta.

**Explicação didática:**  
Pense na User Story como o título de um filme. "Como um pai, quero encontrar um filme infantil para assistir com meu filho no domingo." Esse título já te diz quem é o usuário, o que ele quer e por quê. Mas o filme em si — os detalhes, cenas, diálogos — é discutido depois. A User Story é o ponto de partida, não o roteiro completo.

**Exemplo prático:**  
**User Story:** "Como administrador do sistema, quero exportar relatórios em PDF para compartilhar resultados com a diretoria."  
**Critérios de aceitação:**  
- Botão "Exportar PDF" visível apenas para administradores;  
- O PDF deve incluir dados filtrados pelos critérios selecionados;  
- O nome do arquivo deve seguir o padrão `relatorio_YYYYMMDD.pdf`;  
- A exportação não deve exceder 10 segundos para relatórios de até 1000 registros.

**Como o candidato deve responder:**  
- Definir User Story como descrição informal do ponto de vista do usuário;
- Apresentar o formato "Como... quero... para...";
- Explicar cada parte do formato;
- Mencionar que a história é um convite à conversa;
- Citar a importância dos critérios de aceitação;
- Evitar confundir User Story com especificação técnica detalhada.

**Resposta fraca ou incompleta:**  
"É uma história do usuário, tipo 'o usuário quer X'." — Omite o formato completo, não menciona o "para" (valor) e não cita critérios de aceitação.

**Critérios de avaliação:**
- 0 — Não sabe o que é User Story;
- 1 — Sabe que descreve requisitos, mas não conhece o formato;
- 2 — Conhece o formato, mas não explica o propósito de cada parte;
- 3 — Explica formato e propósito corretamente;
- 4 — Adiciona critérios de aceitação e o conceito de "convite à conversa";
- 5 — Responde com profundidade, discute INVEST (critérios de qualidade de histórias) e relação com DoR.

**Perguntas de aprofundamento:**
1. "O que são os critérios de aceitação e quem os define?"
2. "Uma User Story pode ser técnica ou deve ser sempre do ponto de vista do usuário?"
3. "O que significa dizer que uma User Story é um 'convite à conversa'?"

---

### Pergunta 85 — O que é a cerimônia de Sprint Retrospective e qual é o seu formato ideal?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Descreva a Sprint Retrospective. Qual é o seu objetivo, quem participa e quais são as etapas típicas dessa cerimônia?"

**O que essa pergunta avalia:**  
Conhecimento da cerimônia de melhoria contínua do Scrum, compreensão de seu propósito e formato, e entendimento de que ela é sobre o processo, não sobre o produto.

**Resposta esperada:**  
A **Sprint Retrospective** é a cerimônia final da Sprint, realizada após a Sprint Review e antes da próxima Sprint Planning. Seu objetivo é **refletir sobre o processo** — o que funcionou, o que não funcionou e o que pode ser melhorado — e definir **ações concretas** para a próxima Sprint.

**Quem participa:** O time Scrum completo (Product Owner, Scrum Master e Developers).

**Formato típico (baseado no modelo de Derby & Larsen):**

1. **Abertura (Set the Stage):** Criar um espaço seguro para a conversa, definir o foco da retrospectiva;
2. **Coleta de dados (Gather Data):** O time coleta informações sobre o que aconteceu durante a Sprint — eventos, sentimentos, dados objetivos (velocity, impedimentos, métricas);
3. **Geração de insights (Generate Insights):** O time analisa os dados e identifica padrões, causas raiz e relações;
4. **Decisão de ações (Decide What to Do):** O time escolhe 1-3 ações concretas e acionáveis para melhorar na próxima Sprint, com responsáveis definidos;
5. **Encerramento (Close):** Agradecimentos, avaliação da própria retrospectiva e fechamento.

O Scrum Master facilita a cerimônia, garantindo que ela não vire sessão de reclamação e que as ações sejam específicas, acionáveis e acompanhadas.

**Explicação didática:**  
A Retrospective é como a revisão após um jogo de futebol. O time não discute se a bola era boa ou se o estádio era bonito — discute como jogaram: "pressionamos bem na defesa, mas os passes longos falharam muito. Na próxima, vamos treinar reposicionamento." É sobre melhorar o jogo, não o placar.

**Exemplo prático:**  
Retrospectiva da Sprint 8:  
- **Dados:** Velocity caiu de 24 para 16; 3 histórias não concluídas; 2 impedimentos duraram mais de 3 dias.  
- **Insights:** O time percebeu que a maior causa de atraso foi a falta de refinamento — histórias entraram na Sprint sem critérios de aceitação claros.  
- **Ação:** "A partir da próxima Sprint, nenhuma história entra na Sprint Planning sem passar pela Definition of Ready. Responsável: Scrum Master, que vai garantir o tempo de refinamento."

**Como o candidato deve responder:**  
- Definir o objetivo como melhoria contínua do processo;
- Citar que o time Scrum completo participa;
- Descrever as etapas (abrir, coletar, analisar, decidir, fechar);
- Enfatizar que ações devem ser concretas e com responsáveis;
- Mencionar que o Scrum Master facilita;
- Evitar descrever como "reunião de reclamação" ou "avaliação de desempenho individual".

**Resposta fraca ou incompleta:**  
"É a reunião onde o time fala o que foi bom e o que foi ruim na Sprint." — Reduz a cerimônia a uma conversa informal. Faltam as etapas, o foco em ações concretas e o papel do Scrum Master como facilitador.

**Critérios de avaliação:**
- 0 — Não sabe o que é a Retrospective;
- 1 — Sabe que é uma reunião de feedback, mas não explica formato;
- 2 — Explica objetivo, mas não descreve etapas nem ações;
- 3 — Explica objetivo, participantes e formato básico;
- 4 — Descreve as etapas, cita ações concretas e papel do Scrum Master;
- 5 — Responde com profundidade, discute dinâmicas variadas, follow-up de ações e cultura de segurança psicológica.

**Perguntas de aprofundamento:**
1. "O que fazer quando as ações da Retrospective não são implementadas?"
2. "A Retrospective deve focar no processo ou também no produto?"
3. "Como garantir que todos participem e não só as pessoas mais extrovertidas?"

---

### Pergunta 86 — Como o Scrum lida com mudanças de requisitos durante a Sprint?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Durante uma Sprint, o Product Owner recebe uma nova demanda urgente do cliente que não estava planejada. Como o Scrum lida com essa situação? O scope da Sprint pode mudar?"

**O que essa pergunta avalia:**  
Conhecimento da regra de estabilidade do scope da Sprint no Scrum, compreensão das exceções e flexibilidades possíveis, e entendimento do papel do Product Owner na negociação.

**Resposta esperada:**  
No Scrum, o **scope da Sprint é protegido** — uma vez definido na Sprint Planning, ele não deve mudar durante a Sprint. Isso garante foco e previsibilidade. No entanto, o Scrum não é rígido ao ponto de ignorar a realidade:

1. **Negociação com o Product Owner:** O Product Owner pode renegociar o scope com o time. Se a nova demanda é realmente urgente, o Product Owner pode **trocar** itens de scope equivalente — removendo uma história planejada para incluir a nova. Não se simplesmente adiciona trabalho sem remover;
2. **Troca, não adição:** O princípio é que o trabalho total da Sprint permaneça aproximadamente o mesmo. Se a nova demanda é pequena, pode-se trocar por uma história menor. Se é grande, pode-se trocar por uma história grande;
3. **Cancelamento da Sprint:** Se a direção do produto muda drasticamente, o Product Owner pode cancelar a Sprint inteira. Isso é raro e sinaliza que o objetivo original perdeu completamente o sentido;
4. **Espera pela próxima Sprint:** Se a demanda não é genuinamente urgente, ela entra no Product Backlog e é priorizada na próxima Sprint Planning.

A chave é que a mudança é **negociada e transparente**, não imposta silenciosamente.

**Explicação didática:**  
Imagine que você está cozinhando um jantar planejado. No meio do preparo, alguém pede para adicionar uma sobremesa. Você não simplesmente adiciona sobremesa ao menu e tenta fazer tudo — você avalia: "Tenho tempo? Posso trocar o prato principal por algo mais rápido para abrir espaço?" Ou "A sobremesa pode esperar para amanhã?" A ideia é proteger a qualidade do que já está em andamento.

**Exemplo prático:**  
Sprint 6, dia 4 de 10. O Product Owner recebe uma demanda: "O cliente precisa de um relatório de vendas exportável urgente para uma reunião de diretoria na sexta."  
O Product Owner conversa com o time: "A história de 'modo escuro' que está planejada pode ir para a próxima Sprint? Essa de relatório é prioridade." O time concorda em trocar. O scope muda, mas o esforço total permanece equilibrado. A troca é registrada no Sprint Backlog.

**Como o candidato deve responder:**  
- Afirmar que o scope da Sprint é protegido por padrão;
- Explicar que o Product Owner pode negociar trocas;
- Citar o princípio de trocar, não apenas adicionar;
- Mencionar o cancelamento da Sprint como opção extrema;
- Explicar que demandas não urgentes vão para o Backlog;
- Evitar dizer que "não pode mudar nada, jamais" (rígido demais) nem que "pode adicionar à vontade" (caótico).

**Resposta fraca ou incompleta:**  
"No Scrum, a Sprint é fechada e não muda. Se vier algo novo, vai para a próxima Sprint." — Rígido demais. Ignora a possibilidade de negociação e troca, que é parte legítima do framework.

**Critérios de avaliação:**
- 0 — Não sabe como o Scrum lida com mudanças;
- 1 — Sabe que a Sprint é protegida, mas não explica exceções;
- 2 — Explica proteção do scope, mas omite negociação ou cancelamento;
- 3 — Explica proteção, negociação e troca de scope;
- 4 — Adiciona exemplos, cancelamento e princípio de transparência;
- 5 — Responde com profundidade, discute impacto na Sprint Goal, comunicação com stakeholders e trade-offs de flexibilidade.

**Perguntas de aprofundamento:**
1. "Quem tem autoridade para cancelar a Sprint e em quais situações?"
2. "Se o time concorda em adicionar a nova demanda sem remover nada, quais são os riscos?"
3. "Como evitar que 'tudo é urgente' se torne o padrão?"

---

### Pergunta 87 — O que é o "Quadro Kanban" e quais são as colunas mais comuns?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Descreva como é um quadro Kanban típico. Quais colunas são mais comuns e como os itens fluem por ele?"

**O que essa pergunta avalia:**  
Conhecimento prático da ferramenta visual central do Kanban, compreensão do fluxo de trabalho e entendimento de como o quadro representa o processo real do time.

**Resposta esperada:**  
O **quadro Kanban** é a representação visual do fluxo de trabalho do time. Ele é dividido em colunas que representam os estágios do processo, e os itens (cartões) fluem da esquerda para a direita conforme progridem.

**Colunas mais comuns:**

1. **Backlog / To Do:** Itens que ainda não foram iniciados, aguardando serem puxados;
2. **Em Desenvolvimento (Dev / In Progress):** Itens que estão sendo ativamente trabalhados;
3. **Em Teste / QA:** Itens que estão sendo testados ou validados;
4. **Done / Concluído:** Itens finalizados e prontos para entrega.

Variações comuns:
- **Ready / Pronto para Iniciar:** Subconjunto do Backlog que atende a critérios de prontidão;
- **Code Review:** Itens aguardando revisão de código antes de ir para teste;
- **Em Deploy / Release:** Itens prontos para serem publicados;
- **Blocked / Bloqueado:** Itens com impedimentos (embora o ideal seja manter o item na coluna e marcá-lo como bloqueado, não movê-lo para uma coluna separada).

O quadro pode ser **físico** (quadro com post-its) ou **digital** (Jira, Trello, Azure DevOps, etc.). Cada coluna pode ter um **WIP Limit** que indica o máximo de itens permitidos simultaneamente.

O fluxo funciona por **Pull**: um item só é movido para a próxima coluna quando a coluna de destino tem capacidade (respeitando o WIP Limit).

**Explicação didática:**  
O quadro Kanban é como o painel de uma fábrica. Cada coluna é uma estação de montagem. Os cartões são as peças que passam de estação em estação. Você não empurra peças para uma estação que já está cheia — você espera até que a estação tenha capacidade. Assim, o fluxo é contínuo e os gargalos ficam visíveis.

**Exemplo prático:**  
Quadro Kanban de um time de desenvolvimento:

| Backlog | Ready | Em Dev (WIP: 3) | Code Review (WIP: 2) | Em Teste (WIP: 2) | Done |
|---------|-------|-----------------|---------------------|-------------------|------|
| 15 itens | 5 itens | 3 itens (cheio) | 1 item | 0 itens | 12 itens |

O time vê que "Em Dev" está no limite. Ninguém puxa novos itens de Ready até que um item saia de Dev. Isso força o foco em terminar, não em começar.

**Como o candidato deve responder:**  
- Descrever o quadro como representação visual do fluxo;
- Listar as colunas mais comuns (Backlog, Dev, Test, Done);
- Citar variações frequentes (Ready, Code Review, Deploy);
- Explicar que os itens fluem por Pull;
- Mencionar WIP Limits nas colunas;
- Evitar tratar o quadro como uma simples lista de tarefas sem fluxo.

**Resposta fraca ou incompleta:**  
"É um quadro com colunas To Do, Doing e Done onde o time coloca post-its." — Reduzido demais. Não explica o fluxo, WIP Limits nem variações de colunas.

**Critérios de avaliação:**
- 0 — Não sabe o que é um quadro Kanban;
- 1 — Sabe que é um quadro com colunas, mas não explica fluxo;
- 2 — Descreve colunas básicas, mas omite WIP e fluxo por Pull;
- 3 — Explica colunas, fluxo e WIP;
- 4 — Adiciona variações, exemplos e discute visibilidade de gargalos;
- 5 — Responde com profundidade, discute swim lanes, colunas de buffers e mapeamento de fluxo de valor.

**Perguntas de aprofundamento:**
1. "O que são 'swim lanes' (raias) e quando usar?"
2. "Faz sentido ter uma coluna 'Blocked' separada ou é melhor marcar o item na coluna atual?"
3. "Como o quadro Kanban ajuda a identificar gargalos?"

---

### Pergunta 88 — O que são os três pilares do empirismo no Scrum?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"O Scrum é baseado no empirismo. Quais são os três pilares que sustentam esse conceito e como eles se aplicam na prática?"

**O que essa pergunta avalia:**  
Conhecimento dos fundamentos filosóficos do Scrum, compreensão de como transparência, inspeção e adaptação se manifestam nas cerimônias e práticas, e capacidade de conectar teoria à prática.

**Resposta esperada:**  
Os três pilares do empirismo no Scrum são:

1. **Transparência (Transparency):** O processo e o trabalho devem ser visíveis para todos os envolvidos. Isso significa que o Product Backlog, o Sprint Backlog, o quadro de trabalho, as métricas e o progresso são acessíveis e compreensíveis. A transparência permite que todos tomem decisões informadas. Exemplos: o quadro Scrum/Kanban é visível para todos; a Definition of Done é acordada e compartilhada; o Product Backlog é acessível a stakeholders.

2. **Inspeção (Inspection):** O time regularmente inspeciona o trabalho e o processo para detectar desvios ou problemas. As cerimônias do Scrum são momentos de inspeção: o Daily Scrum inspeciona o progresso da Sprint; a Sprint Review inspeciona o incremento; a Sprint Retrospective inspeciona o processo. A inspeção não é fiscalização — é verificação contínua para garantir que estamos no caminho certo.

3. **Adaptação (Adaptation):** Quando a inspeção revela que algo está fora do caminho desejado, o time ajusta o processo ou o produto. Adaptação é a resposta à inspeção: se o velocity cai, ajustamos o planejamento; se uma história não está funcionando, reformulamos; se o processo tem gargalos, mudamos a forma de trabalhar.

**Como se aplicam na prática:**
- **Transparência:** Sprint Backlog visível, Daily Scrum compartilha progresso, Sprint Review mostra o incremento;
- **Inspeção:** Daily inspeciona progresso diário, Sprint Review inspeciona o incremento, Retrospective inspeciona o processo;
- **Adaptação:** Retrospective gera ações de melhoria, Sprint Planning ajusta com base no que foi aprendido, Product Backlog é repriorizado.

**Explicação didática:**  
Imagine dirigir em uma estrada. A **transparência** é o para-brisa limpo e os espelhos ajustados — você consegue ver onde está. A **inspeção** é olhar para a estrada e os instrumentos regularmente — verificar se está no caminho certo. A **adaptação** é corrigir o volante quando percebe que está saindo da pista. Sem transparência, você não vê. Sem inspeção, você não percebe o desvio. Sem adaptação, você não corrige. Os três trabalham juntos.

**Exemplo prático:**  
Na Sprint Review, o Product Owner mostra o incremento aos stakeholders (transparência). Stakeholders percebem que a funcionalidade entregue não atende à expectativa de UX (inspeção). O Product Owner ajusta o Product Backlog para priorizar melhorias de UX na próxima Sprint (adaptação).

**Como o candidato deve responder:**  
- Citar os três pilares: transparência, inspeção e adaptação;
- Explicar cada um com definição clara;
- Conectar cada pilar a práticas ou cerimônias do Scrum;
- Mostrar que os três são interdependentes;
- Evitar citar apenas nomes sem explicar ou sem dar exemplos.

**Resposta fraca ou incompleta:**  
"Os pilares são transparência, inspeção e adaptação. É sobre ser transparente, inspecionar e adaptar." — Correto, mas circular. Repete os nomes sem explicar o que cada um significa nem como se aplica.

**Critérios de avaliação:**
- 0 — Não conhece os pilares;
- 1 — Cita um ou dois, mas não explica;
- 2 — Cita os três, mas não os conecta à prática;
- 3 — Explica os três e dá pelo menos um exemplo de aplicação;
- 4 — Conecta cada pilar às cerimônias e práticas específicas;
- 5 — Responde com profundidade, discute interdependência, riscos de omitir um pilar e impacto na cultura ágil.

**Perguntas de aprofundamento:**
1. "O que acontece se há inspeção sem adaptação?"
2. "Como garantir a transparência em times distribuídos?"
3. "A inspeção pode ser prejudicial? Em quais situações?"

---

### Pergunta 89 — O que é um "epic" e como ele se relaciona com User Stories?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Em um Product Backlog, frequentemente encontramos 'epics'. O que é um epic, como ele se relaciona com User Stories e por que não trabalhamos diretamente com epics na Sprint?"

**O que essa pergunta avalia:**  
Conhecimento da hierarquia de itens no Product Backlog, compreensão de decomposição de requisitos e entendimento de por que itens grandes não devem entrar diretamente na Sprint.

**Resposta esperada:**  
Um **epic** é uma grande história de usuário que ainda não foi decomposta em histórias menores e acionáveis. Ele representa uma funcionalidade ampla ou um conjunto de funcionalidades relacionadas que, juntas, entregam valor significativo. Epics são úteis para organização e planejamento de alto nível, mas são grandes demais para serem trabalhados diretamente em uma Sprint.

A relação com User Stories é hierárquica:
- **Epic:** "Como usuário, quero um sistema completo de e-commerce para comprar produtos online."
- **User Story 1:** "Como usuário, quero buscar produtos por categoria para encontrar o que preciso."
- **User Story 2:** "Como usuário, quero adicionar produtos ao carrinho para selecionar minhas compras."
- **User Story 3:** "Como usuário, quero fazer checkout com cartão de crédito para finalizar a compra."

Não trabalhamos diretamente com epics na Sprint porque:
1. **Tamanho:** Um epic geralmente leva mais de uma Sprint para ser concluído, o que viola a ideia de entregar valor incremental em ciclos curtos;
2. **Incerteza:** Epics têm muitos detalhes indefinidos — o time não consegue estimar com precisão;
3. **Foco:** Trabalhar em um epic sem dividi-lo dispersa o esforço e dificulta a medição de progresso;
4. **Definition of Ready:** Epics geralmente não atendem aos critérios de prontidão — não têm critérios de aceitação detalhados nem escopo claro.

O processo de **decomposição** (splitting) de epics em histórias menores acontece durante o refinamento do Product Backlog.

**Explicação didática:**  
Pense no epic como um capítulo de um livro e nas User Stories como os parágrafos. Você não escreve um capítulo inteiro de uma vez — você escreve parágrafo por parágrafo. Cada parágrafo tem sentido por si só, mas juntos formam o capítulo. Na Sprint, você trabalha um parágrafo de cada vez.

**Exemplo prático:**  
Epic: "Como administrador, quero gerenciar usuários do sistema."  
Decomposição:
- "Como administrador, quero listar todos os usuários cadastrados."
- "Como administrador, quero criar um novo usuário com nome, e-mail e perfil."
- "Como administrador, quero editar dados de um usuário existente."
- "Como administrador, quero desativar um usuário sem excluir seus dados."
- "Como administrador, quero redefinir a senha de um usuário."

Cada uma dessas histórias pode ser estimada, testada e entregue em uma Sprint.

**Como o candidato deve responder:**  
- Definir epic como uma história grande que precisa ser decomposta;
- Explicar a relação hierárquica (epic contém múltiplas User Stories);
- Citar por que epics não entram diretamente na Sprint (tamanho, incerteza, foco);
- Mencionar que a decomposição acontece no refinamento;
- Dar um exemplo de decomposição;
- Evitar confundir epic com tema ou com feature (embora esses termos às vezes se usem de forma intercambiável, o conceito de decomposição é o ponto-chave).

**Resposta fraca ou incompleta:**  
"Epic é uma história grande. Aí você divide em histórias menores." — Correto, mas superficial. Não explica por que não trabalhar diretamente com o epic nem dá exemplo de decomposição.

**Critérios de avaliação:**
- 0 — Não sabe o que é epic;
- 1 — Sabe que é algo grande, mas não explica relação com histórias;
- 2 — Define e relaciona, mas não explica por que não usar na Sprint;
- 3 — Explica conceito, relação e razão para decompor;
- 4 — Adiciona exemplo de decomposição e menciona refinamento;
- 5 — Responde com profundidade, discute critérios de decomposição (valor, risco, dependências) e relação com estimativa.

**Perguntas de aprofundamento:**
1. "Quando um epic deve ser dividido e quando pode ser mantido como está?"
2. "Existe um tamanho ideal para uma User Story?"
3. "Um epic pode virar uma feature e uma feature virar uma User Story? Como funciona essa hierarquia?"

---

### Pergunta 90 — O que é o conceito de "Timeboxing" no Scrum e por que ele é importante?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"No Scrum, falamos muito em 'timeboxing'. O que é timeboxing e por que todas as cerimônias têm um tempo máximo definido?"

**O que essa pergunta avalia:**  
Compreensão de um conceito transversal do Scrum, conhecimento dos limites de tempo das cerimônias e entendimento da rationale por trás da restrição temporal.

**Resposta esperada:**  
**Timeboxing** é a prática de alocar uma quantidade fixa e máxima de tempo para uma atividade. Quando o tempo acaba, a atividade termina — independentemente de estar "completa" ou não. No Scrum, todos os eventos têm um timebox definido.

**Timeboxes das cerimônias Scrum (para uma Sprint de 1 mês — proporções menores para Sprints mais curtas):**
- **Sprint:** Até 1 mês (2 semanas é comum);
- **Sprint Planning:** Até 8 horas (proporcionalmente menor para Sprints curtas);
- **Daily Scrum:** 15 minutos;
- **Sprint Review:** Até 4 horas;
- **Sprint Retrospective:** Até 3 horas.

**Por que o timeboxing é importante:**
1. **Foco e eficiência:** Saber que o tempo é limitado força o time a ser objetivo e a priorizar o que importa;
2. **Previsibilidade:** Timeboxes garantem que as cerimônias não consumam tempo desproporcional da Sprint;
3. **Evita "Parkinson's Law":** A lei de Parkinson diz que "o trabalho se expande para preencher o tempo disponível". Sem timebox, reuniões tendem a se prolongar indefinidamente;
4. **Força decisões:** Com tempo limitado, o time é obrigado a tomar decisões em vez de protelá-las;
5. **Respeito ao time:** Limitar o tempo das cerimônias respeita o tempo dos membros, que têm trabalho a fazer além de reuniões;
6. **Ritmo:** Timeboxes criam um ritmo previsível que ajuda o time a se organizar.

**Explicação didática:**  
Pense no timeboxing como o tempo de um jogo de futebol. São 90 minutos, e quando acaba, acabou — mesmo que o jogo esteja empatado. Você não estende o jogo porque "ainda falta um gol". O time limitado força os times a jogarem com intensidade e estratégia, em vez de relaxar. Da mesma forma, o timebox do Daily Scrum (15 minutos) força o time a focar no essencial, em vez de divagar.

**Exemplo prático:**  
Sprint Planning com timebox de 4 horas (para uma Sprint de 2 semanas). O time sabe que tem 4 horas para definir a Sprint Goal e selecionar histórias. Se ao final das 4 horas o time não terminou de estimar todas as histórias, a Planning termina mesmo assim. O time trabalha com o que conseguiu planejar e ajusta durante a Sprint. Isso é preferível a uma Planning de 8 horas que esgota o time antes mesmo de a Sprint começar.

**Como o candidato deve responder:**
- Definir timeboxing como tempo máximo fixo para uma atividade;
- Citar os timeboxes das cerimônias Scrum (pelo menos os mais comuns);
- Explicar pelo menos 3 benefícios do timeboxing;
- Mencionar a Lei de Parkinson;
- Explicar que o time é o limite, não o objetivo — a reunião pode terminar antes;
- Evitar confundir timebox com "tempo exato" (a reunião não precisa durar o tempo todo, apenas não pode ultrapassá-lo).

**Resposta fraca ou incompleta:**  
"Timeboxing é definir um tempo para as reuniões para que não durem demais." — Correto, mas superficial. Não cita os limites específicos, não explica os benefícios nem menciona a Lei de Parkinson.

**Critérios de avaliação:**
- 0 — Não conhece o conceito;
- 1 — Sabe que é sobre limitar tempo, mas não detalha;
- 2 — Define e cita 1-2 benefícios, mas não conhece os timeboxes;
- 3 — Define, explica benefícios e cita timeboxes das cerimônias;
- 4 — Adiciona Lei de Parkinson, exemplos e distinção entre limite e objetivo;
- 5 — Responde com profundidade, discute impacto na produtividade, ajuste de timeboxes para Sprints curtas e trade-offs de flexibilidade vs. disciplina.

**Perguntas de aprofundamento:**
1. "O que fazer se a Sprint Planning precisa de mais tempo que o timebox permite?"
2. "O Daily Scrum pode durar menos de 15 minutos?"
3. "Como o time decide se um timebox precisa ser ajustado para mais ou para menos?"

---

## Parte 7 — Perguntas 91 a 100 (Júnior — Scrum, Kanban e Metodologias Ágeis)

---

### Pergunta 91 — Adaptação do Scrum para projetos pequenos

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Você entrou em uma equipe pequena, com apenas três pessoas, e a empresa quer usar Scrum. O framework prevê no mínimo papéis e eventos. É viável aplicar Scrum com apenas três pessoas? Que adaptações você faria e quais elementos você manteria obrigatoriamente?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende a flexibilidade e os limites do Scrum, se entende o propósito mínimo de cada papel e evento, e se consegue distinguir o que é essencial do que é adaptável sem descaracterizar o framework.

**Resposta esperada:**  
Sim, é viável aplicar Scrum com três pessoas, mas com adaptações. O Scrum Guide não define um número máximo de integrantes do Development Team, mas sugere de 3 a 9 como ideal para comunicação. Com três pessoas, é possível ter um Product Owner, um Scrum Master e um ou dois desenvolvedores — ou, se inviável separar os papéis, acumular funções (com ressalvas). Os elementos que devem ser mantidos são: Sprints curtas, Daily Scrum, Sprint Review, Sprint Retrospective e um Product Backlog priorizado. Adaptações comuns incluem: Sprints mais curtas (1 semana), ceremonies enxutas (15-30 min), e o PO podendo atuar também como desenvolvedor. O que não se deve eliminar é a inspeção e adaptação contínua (Review e Retrospective), nem a transparência do backlog.

**Explicação didática:**  
O Scrum é um framework deliberadamente incompleto — ele define papéis, eventos e artefatos, mas não prescreve como implementar os detalhes. O guia oficial estabelece regras mínimas: existem três papéis (PO, SM, Dev Team), quatro eventos (Sprint, Daily, Review, Retrospective) e três artefatos (Product Backlog, Sprint Backlog, Incremento). Com poucas pessoas, a principal preocupação é garantir que a separação de responsabilidades não se perca a ponto de o PO priorizar de forma enviesada ou o SM não ter tempo de remover impedimentos. Acumular papéis é tolerado em contextos pequenos, mas é importante que a pessoa use "chapéus diferentes" em momentos distintos.

**Exemplo prático:**  
Em uma startup com um desenvolvedor full-stack, um designer e um fundador técnico, o fundador atua como Product Owner, o designer acumula Scrum Master e desenvolvedor, e o full-stack é desenvolvedor. Eles fazem Sprints de uma semana, Daily de 15 minutos, Review com demonstração rápida e Retrospective focada em um item de melhoria por Sprint.

**Como o candidato deve responder:**  
- Confirmar que é viável e que o Scrum é adaptável por natureza
- Identificar quais elementos são essenciais (inspeção, adaptação, backlog, Sprints)
- Sugerir adaptações práticas: Sprints curtas, ceremonies enxutas, possível acúmulo de papéis
- Mencionar os riscos do acúmulo de papéis (conflito de interesse, falta de foco)
- Evitar dizer simplesmente "não dá para usar Scrum" ou "usa Kanban no lugar" sem justificar

**Resposta fraca ou incompleta:**  
"Com três pessoas não dá para fazer Scrum, melhor usar Kanban." — Falta reconhecer que o Scrum é adaptável e que o Guia oficial não proíbe times pequenos. A resposta ignora que Kanban e Scrum não são mutuamente excludentes e não propõe adaptações concretas.

**Critérios de avaliação:**  
- 0 — Afirma que Scrum é inviável sem justificativa ou não sabe responder
- 1 — Sabe que Scrum é adaptável, mas não propõe adaptações
- 2 — Propõe adaptações vagas sem distinguir essenciais de opcionais
- 3 — Identifica elementos essenciais e propõe adaptações razoáveis
- 4 — Justifica adaptações com base no Scrum Guide e menciona riscos
- 5 — Demonstra visão prática completa, com exemplos reais e análise de trade-offs do acúmulo de papéis

---

### Pergunta 92 — Diferença entre Time-box e prazo

**Nível:** Júnior  
**Categoria:** Conceitos

**Pergunta do entrevistador:**  
No Scrum, dizemos que a Sprint tem um "time-box", e no mundo tradicional falamos em "prazo". Qual é a diferença conceitual entre um time-box e um prazo fixo? Por que o Scrum usa time-boxes em vez de prazos?

**O que essa pergunta avalia:**  
Avalia se o candidato entende um conceito fundamental do Scrum: time-boxes não são prazos de entrega, mas janelas de tempo para inspeção e adaptação. Essa distinção é crucial para não distorcer o framework.

**Resposta esperada:**  
Um **time-box** é uma janela de tempo fixa durante a qual se trabalha em algo, sem que o tempo seja estendido. O foco não é entregar tudo o que foi planejado, mas criar uma oportunidade de inspeção e adaptação ao final. Um **prazo fixo** no modelo tradicional é uma data limite para entregar um escopo completo — se o escopo não está pronto, o prazo foi "estourado" e o projeto está atrasado.

No Scrum, o time-box da Sprint protege o time de escopo crescente (scope creep) e garante um ritmo sustentável de inspeção. Se ao final da Sprint nem tudo foi concluído, não se diz que a Sprint "atrasou" — diz-se que o escopo não foi finalizado, e os itens incompletos voltam ao Product Backlog. A diferença central é: no modelo de prazo, o atraso é uma falha; no Scrum, a Sprint termina no tempo previsto e os itens restantes são reavaliados.

**Explicação didática:**  
Pense no time-box como uma sessão de estudos de 50 minutos: você estuda o máximo que consegue nesse período e, ao final, revisa o que aprendeu e planeja a próxima sessão. O objetivo não é "terminar o livro" em 50 minutos, mas criar um ciclo de aprendizado. Já o prazo fixo seria "terminar o livro até sexta" — se não terminou, você falhou. O Scrum usa time-boxes porque valoriza a previsibilidade do ritmo (cadência) e a inspeção frequente, não a previsibilidade do escopo final.

**Exemplo prático:**  
Uma Sprint de 2 semanas: o time compromete com 8 itens do backlog. Ao final, 6 estão prontos e 2 não. A Sprint não "atrasou" — ela terminou normalmente no time-box. Os 2 itens incompletos voltam ao backlog e são reavaliados pelo PO na próxima Sprint Planning.

**Como o candidato deve responder:**  
- Definir time-box como janela fixa, não como prazo de entrega
- Explicar que o foco é inspeção e adaptação, não "bater a meta de escopo"
- Contrastar com o modelo tradicional onde o atraso de prazo é uma falha
- Mencionar que itens não concluídos voltam ao backlog, não "arrastam" para a próxima Sprint
- Evitar confundir time-box com "deadline" ou "entrega no prazo"

**Resposta fraca ou incompleta:**  
"Time-box é a mesma coisa que prazo, só com outro nome." — Isso demonstra desconhecimento do conceito. Time-box e prazo têm propósitos, consequências e filosofias completamente diferentes.

**Critérios de avaliação:**  
- 0 — Não sabe a diferença ou diz que são a mesma coisa
- 1 — Sabe que time-box é um "limite de tempo", mas não explica o propósito
- 2 — Explica superficialmente a diferença, mas confunde escopo com tempo
- 3 — Define corretamente time-box e prazo e explica o propósito da inspeção
- 4 — Explica com clareza, cita o retorno de itens ao backlog e a proteção contra scope creep
- 5 — Demonstra compreensão profunda, contrasta modelos e explica por que a cadência gera previsibilidade

---

### Pergunta 93 — Como lidar com um Product Owner ausente

**Nível:** Júnior  
**Categoria:** Cenários reais

**Pergunta do entrevistador:**  
Imagine que você está em uma Sprint e o Product Owner está quase sempre indisponível — não responde perguntas, não valida incrementos e não participa das ceremonies. O time está perdido sobre prioridades. O que você, como desenvolvedor, faria nessa situação?

**O que essa pergunta avalia:**  
Avalia se o candidato reconhece a criticidade do papel do PO, sabe escalar o problema adequadamente e propõe ações práticas sem assumir responsabilidades que não são suas.

**Resposta esperada:**  
Como desenvolvedor, a primeira ação é **documentar o problema e seus impactos**: decisões pendentes, itens bloqueados, impedimentos decorrentes da ausência. Em seguida, **comunicar formalmente ao Scrum Master** (se houver), que é a pessoa responsável por remover impedimentos e garantir que o Scrum funcione. O SM deve atuar para resolver a indisponibilidade do PO — conversando com ele, com a liderança ou com stakeholders.

Se não houver Scrum Master, o time deve **levar o problema à Sprint Retrospective** de forma objetiva, listando os impactos concretos (itens não validados, Sprint Goal comprometida) e propor ações: definir horários fixos de disponibilidade do PO, criar um proxy temporário, ou escalar para a liderança. O time **não deve simplesmente decidir prioridades no lugar do PO**, pois isso viola a responsabilidade do papel e pode levar a decisões de produto equivocadas.

Se a situação persistir e for crônica, é necessário **escalar para a liderança** — o Scrum não funciona adequadamente sem um PO engajado, e isso é um problema organizacional, não do time de desenvolvimento.

**Explicação didática:**  
O Product Owner é o "dono do valor" — é ele quem maximiza o retorno do trabalho do time e decide o que é mais importante. Sem PO, o time pode até produzir, mas não tem garantia de que está produzindo o que traz mais valor. O papel não é decorativo: a ausência do PO gera desperdício (rework, direções erradas, itens que não atendem às necessidades reais). O Scrum Master existe justamente para garantir que o Scrum funcione — se o PO não cumpre seu papel, esse é um impedimento que o SM deve remover.

**Exemplo prático:**  
Durante a Sprint, três itens do Sprint Backlog dependem de validação do PO para serem considerados "Done". O PO não aparece. O time registra: "Itens X, Y e Z bloqueados há 4 dias por falta de validação do PO." Na Retrospective, o time propõe: "Definir uma janela de 30 minutos diários onde o PO responde dúvidas e valida incrementos." O SM conversa com o PO e com a liderança para garantir essa janela.

**Como o candidato deve responder:**  
- Reconhecer que a ausência do PO é um problema grave e crônico
- Mencionar a via correta: documentar → escalar ao SM → Retrospective → liderança
- Evitar propor que o time assuma o papel do PO sem qualificação
- Suggestionar soluções pragmáticas (janela de disponibilidade, proxy temporário)
- Mencionar que isso é um problema organizacional, não do time de desenvolvimento
- Evitar respostas passivas como "esperar o PO voltar"

**Resposta fraca ou incompleta:**  
"O time pode decidir as prioridades sozinho até o PO voltar." — Isso viola o papel do PO e pode gerar desperdício. A resposta não menciona escalar o problema, não propõe solução estrutural e trata a ausência como normal.

**Critérios de avaliação:**  
- 0 — Não sabe como lidar ou propõe ignorar o problema
- 1 — Sugere que o time decida sozinho sem escalonamento
- 2 — Menciona falar com o PO, mas não propõe estrutura ou escalonamento
- 3 — Propõe escalar ao SM, documentar impactos e levar à Retrospective
- 4 — Demonstra entendimento do impacto no valor e propõe soluções pragmáticas
- 5 — Articula a cadeia completa de escalonamento, riscos de substituir o PO e a natureza organizacional do problema

---

### Pergunta 94 — Definition of Ready vs Definition of Done

**Nível:** Júnior  
**Categoria:** Conceitos

**Pergunta do entrevistador:**  
Você já ouviu falar de Definition of Ready (DoR) e Definition of Done (DoD)? Explique o que cada uma significa, qual é a diferença entre elas e por que um time ágil precisaria de ambas.

**O que essa pergunta avalia:**  
Avalia se o candidato conhece dois conceitos amplamente usados em times ágeis, se entende a diferença de propósito e momento de aplicação de cada um, e se compreende que não são regras obrigatórias do Scrum, mas práticas complementares.

**Resposta esperada:**  
A **Definition of Done (DoD)** é um acordo do time sobre o que significa que um item do backlog está "completo" — ou seja, em condições de ser entregue ou usado. Tipicamente inclui: código testado, revisado, documentado, integrado, sem bugs conhecidos, aceito pelo PO. A DoD é aplicada **ao final** do trabalho, quando o time declara que o item está pronto.

A **Definition of Ready (DoR)** é um acordo sobre o que um item do backlog precisa ter antes de ser considerado "pronto para ser colocado em uma Sprint". Inclui critérios como: descrição clara, critérios de aceitação definidos, estimada, dependências resolvidas, design aprovado. A DoR é aplicada **antes** do trabalho começar.

A diferença é: a **DoR garante que o time não começa trabalho que não está pronto para ser feito**, evitando paradas, retrabalho e ambiguidade. A **DoD garante que o time não declara algo como "feito" que na verdade não está completo**, evitando débito técnico e entregas de baixa qualidade.

Um time precisa de ambas porque a DoR protege a entrada e a DoD protege a saída. Sem DoR, o time começa itens que não tem como terminar. Sem DoD, o time "termina" itens que na verdade estão incompletos.

**Explicação didática:**  
Pense num restaurante. A DoR é a checklist do cozinheiro antes de começar o prato: "Tenho todos os ingredientes? A receita está clara? O fogão está livre?" Se algo não está pronto, ele não começa. A DoD é a checklist antes de o garçom levar o prato à mesa: "O prato está montado? A temperatura está correta? A apresentação está adequada?" Se algo não está conforme, o prato não sai. Uma protege o início, a outra protege a entrega.

**Exemplo prático:**  
**DoR**: "Um item está Ready quando: tem título descritivo, user story no formato 'Como X, quero Y, para Z', pelo menos 3 critérios de aceitação, estimada em Story Points, e sem dependências externas bloqueantes."  
**DoD**: "Um item está Done quando: código commitado, testes unitários passando, code review aprovado, documentação atualizada, testado em ambiente de homologação, e validado pelo PO."

**Como o candidato deve responder:**  
- Definir ambas claramente, com o momento de aplicação (antes/depois)
- Explicar o propósito de cada uma (proteger entrada/saída)
- Citar exemplos de critérios em cada uma
- Mencionar que não são obrigatórias no Scrum Guide, mas são práticas recomendadas
- Evitar confundir uma com a outra ou dizer que são a mesma coisa

**Resposta fraca ou incompleta:**  
"DoR é quando o item está pronto e DoD é quando termina." — Isso é circular e não explica o propósito de nenhuma. A resposta não menciona que cada uma protege uma etapa diferente do fluxo.

**Critérios de avaliação:**  
- 0 — Não conhece os conceitos ou confunde completamente
- 1 — Conhece uma das duas, mas não a outra
- 2 — Define ambas superficialmente, mas não distingue o momento de aplicação
- 3 — Define corretamente ambas e explica a diferença de propósito
- 4 — Explica com exemplos práticos e menciona que não são obrigatórias no Scrum Guide
- 5 — Articula como ambas se complementam, cita exemplos concretos e discute o risco de não ter cada uma

---

### Pergunta 95 — Estimativa por consenso vs estimativa individual

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Durante uma Planning Poker, um dos desenvolvedores dá uma estimativa muito diferente das demais — ele coloca um 13 enquanto todo o resto do time colocou 3. Como o time deve proceder nessa situação? O que essa divergência pode indicar?

**O que essa pergunta avalia:**  
Avalia se o candidato entende que Planning Poker é um processo de discussão e consenso, não de votação majoritária, e se sabe aproveitar divergências como oportunidades de aprendizado.

**Resposta esperada:**  
A divergência é **positiva e esperada** — é exatamente para isso que o Planning Poker existe. O time **não deve simplesmente aceitar a maioria** e ignorar o outlier. O procedimento correto é:

1. **Pedir ao outlier que explique primeiro** o motivo da estimativa alta. Pode ser que ele viu algo que os outros não viram: uma complexidade oculta, uma dependência, um risco técnico, ou um cenário de erro que os demais não consideraram.
2. **Depois, pedir aos que deram a estimativa baixa que expliquem** o motivo. Pode ser que o outlier superestimou por falta de contexto ou por estar pensando em uma abordagem mais complexa que a necessária.
3. **Discutir até chegar a um consenso** — não necessariamente o número da maioria, mas um número que todos compreendam e aceitem. Pode ser 3, 5, 8 ou até 13, desde que o time entenda o porquê.
4. **Se não houver consenso após a discussão**, a recomendação prática é usar a estimativa mais alta (pessimista) para proteger o time, ou dividir o item em partes menores que sejam mais claras.

A divergência pode indicar: (a) entendimento diferente do escopo, (b) experiência diferente com a tecnologia, (c) visão de riscos diferentes, (d) ambiguidade na descrição do item. Em todos os casos, a discussão gera alinhamento e melhora a qualidade das estimativas.

**Explicação didática:**  
O Planning Poker não é uma eleição — não vence quem tem mais votos. É um exercício de **comunicação e descoberta de conhecimento implícito**. Cada pessoa tem uma visão diferente do problema baseada em sua experiência, e a estimativa numérica é só um pretexto para trazer essas visões à tona. Quando alguém "vota" diferente, está sinalizando que enxergou algo que os outros podem ter perdido. Ignorar essa divergência é desperdiçar a principal finalidade da técnica.

**Exemplo prático:**  
Item: "Implementar exportação de relatório em PDF." O time vota 3, mas um desenvolvedor vota 13. Ele explica: "A última vez que fizemos exportação de PDF, o layout quebrou em navegadores diferentes e demoramos uma semana só no ajuste de formatação." O time discute e concorda que o risco é real — ajustam a estimativa para 8 ou criam uma spike para investigar a complexidade da exportação antes de estimar.

**Como o candidato deve responder:**  
- Enfatizar que a divergência é positiva e deve ser explorada
- Descrever o fluxo: ouvir o outlier primeiro, depois a maioria, discutir, consensar
- Mencionar que o consenso não é o número da maioria, mas um número aceito por todos
- Suggestionar dividir o item se não houver consenso
- Evitar dizer "vale a maioria" ou "ignora o cara que votou diferente"
- Mencionar que o SM deve facilitar a discussão, não decidir

**Resposta fraca ou incompleta:**  
"Se a maioria votou 3, a estimativa é 3." — Isso anula o propósito do Planning Poker. A estimativa por maioria ignora conhecimento individual valioso e desencoraja a expressão de preocupações legítimas.

**Critérios de avaliação:**  
- 0 — Não sabe como proceder ou diz para seguir a maioria
- 1 — Menciona discutir, mas não sabe como estruturar a conversa
- 2 — Propõe discutir, mas não prioriza ouvir o outlier primeiro
- 3 — Descreve o fluxo correto: ouvir outlier, ouvir maioria, discutir, consensar
- 4 — Explica o propósito do Planning Poker como descoberta de conhecimento e menciona dividir o item
- 5 — Articula os motivos da divergência, o valor da discussão e estratégias alternativas (spike, divisão)

---

### Pergunta 96 — Quando o Daily Scrum vira apenas status report

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Você percebe que o Daily Scrum da sua equipe se transformou em uma reunião onde cada pessoa simplesmente responde "ontem fiz X, hoje vou fazer Y" e ninguém menciona impedimentos nem ajusta o plano. É um Scrum válido? O que está faltando e o que você faria para melhorar?

**O que essa pergunta avalia:**  
Avalia se o candidato reconhece que o Daily Scrum não é apenas um reporte de status, mas um momento de inspeção e adaptação do Sprint Backlog, e se sabe propor melhorias concretas.

**Resposta esperada:**  
Não é um Scrum inválido formalmente — as três perguntas (o que fiz, o que farei, impedimentos) fazem parte da prática comum. Mas é um Daily **ineficaz**. O propósito do Daily Scrum é **inspecionar o progresso em direção à Sprint Goal e adaptar o plano do dia** — não é um reporte para o Scrum Master ou para o PO.

O que está faltando:
- **Foco na Sprint Goal**: as pessoas devem conectar suas atividades com o objetivo da Sprint, não apenas listar tarefas
- **Identificação de impedimentos**: se ninguém nunca tem impedimentos, provavelmente não estão sendo reportados — o que é diferente de não existirem
- **Adaptação do plano**: se alguém terminou algo mais rápido ou encontrou um bloqueio, o plano do dia deve mudar, e o Daily é o momento para isso
- **Colaboração**: o Daily deve gerar conversas ("posso ajudar com isso", "precisamos parear nesse item"), não apenas monólogos

Para melhorar:
1. O Scrum Master pode **reframar o Daily**: em vez de "o que você fez", perguntar "estamos mais pertos da Sprint Goal? O que está nos atrapalhando?"
2. **Usar o Sprint Backlog visualmente** (quadro físico ou digital) durante o Daily — apontar para o quadro, não para o ar
3. **Mover cartões durante a Daily** — se o quadro não muda durante a Daily, é sinal de que ela não está sendo útil
4. **Limitar o tempo** a 15 minutos e evitar discussões longas (que devem ser levadas para depois)

**Explicação didática:**  
O Daily Scrum é um evento **do time para o time** — não é um reporte para um chefe ou para o PO. As três perguntas clássicas ("o que fiz", "o que farei", "impedimentos") são um guia, não um roteiro obrigatório. O que importa é que, ao final dos 15 minutos, o time saiba coletivamente: onde está em relação à Sprint Goal, o que precisa ser feito hoje, e o que está bloqueando. Se a Daily não gera nenhuma mudança de plano, ela é uma reunião morta.

**Exemplo prático:**  
Em vez de: "Ontem refatorei o módulo de login. Hoje vou trabalhar na API de autenticação. Sem impedimentos."  
Melhor: "O módulo de login está pronto e testado. Isso nos deixa a 3 itens da Sprint Goal de ter a autenticação completa. Hoje vou começar a API de autenticação, mas preciso que o time defina o formato do token JWT — posso pegar 5 minutos com vocês depois?"  
Nesse formato, a pessoa conecta seu trabalho com a Sprint Goal, menciona uma dependência concreta e propõe uma ação colaborativa.

**Como o candidato deve responder:**  
- Reconhecer que o formato de "status report" é uma disfunção comum
- Explicar que o propósito é inspeção e adaptação, não reporte
- Propor melhorias concretas: reframe, uso do quadro, foco na Sprint Goal
- Mencionar que o SM deve atuar como facilitador, não como recebedor de status
- Evitar dizer "o Daily é inútil então" ou "deveríamos cancelar o Daily"
- Mencionar que discussões longas devem ser levadas para depois da Daily

**Resposta fraca ou incompleta:**  
"O Daily está funcionando, as pessoas estão respondendo as três perguntas." — Cumprir o formato não significa cumprir o propósito. A resposta não identifica a disfunção nem propõe melhoria.

**Critérios de avaliação:**  
- 0 — Não identifica o problema ou acha que está correto
- 1 — Identifica que algo está faltando, mas não sabe o quê
- 2 — Menciona impedimentos, mas não propõe ações concretas
- 3 — Explica o propósito real do Daily e propõe melhorias razoáveis
- 4 — Propõe melhorias concretas (reframe, quadro visual, foco na Sprint Goal) com exemplos
- 5 — Articula a disfunção, propõe múltiplas melhorias e demonstra visão de facilitação do SM

---

### Pergunta 97 — Identificando Waste em um fluxo de trabalho Kanban

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Você está olhando um quadro Kanban e percebe que há um grande acúmulo de cartões na coluna "Em Revisão" — 12 cartões parados há dias, enquanto as outras colunas têm 2 ou 3. O que esse acúmulo indica? Que ações o time deveria tomar?

**O que essa pergunta avalia:**  
Avalia se o candidato sabe interpretar um quadro Kanban visualmente, identificar gargalos (bottlenecks) e propor ações concretas baseadas nos princípios do Kanban.

**Resposta esperada:**  
Esse acúmulo na coluna "Em Revisão" indica um **gargalo** (bottleneck) — a etapa de revisão está processando trabalho mais lentamente do que as etapas anteriores estão enviando. Isso é um sinal clássico de que a capacidade do sistema está desbalanceada.

Ações que o time deveria tomar:
1. **Investigar a causa raiz**: por que os cartões estão parados? É falta de pessoas para revisar? É um processo de revisão burocrático? As revisões geram muito retrabalho?
2. **Aplicar WIP Limit na coluna "Em Revisão"**: definir um limite (ex.: 4 cartões) para forçar o time a parar de puxar novos itens e focar em escoar a coluna de revisão.
3. **Realocar pessoas temporariamente**: se houver desenvolvedores disponíveis, designá-los para ajudar na revisão até o gargalo ser resolvido.
4. **Analisar o tipo de retrabalho**: se os cartões voltam frequentemente de "Em Revisão" para "A Fazer", pode indicar que a qualidade na fase de desenvolvimento está baixa — o problema não está na revisão, mas na entrada.
5. **Reduzir o lote de entrada**: se a coluna "Em Progresso" envia mais trabalho do que "Em Revisão" consegue absorber, é preciso reduzir o WIP da coluna anterior para equilibrar o fluxo.

O princípio do Kanban aqui é: **identificar o gargalo, proteger o gargalo e resolver o gargalo** — não adianta empurrar mais trabalho para um funil que não consegue escoar.

**Explicação didática:**  
Imagine uma esteira de montagem onde 10 peças chegam por hora na etapa de inspeção, mas a inspeção só consegue processar 4 por hora. Não importa o quão rápido as etapas anteriores trabalharem — o sistema inteiro só entrega 4 peças por hora. O gargalo dita a velocidade do sistema inteiro. No Kanban, o acúmulo de cartões em uma coluna é o sintoma visual mais importante de que algo precisa de atenção imediata.

**Exemplo prático:**  
O time define WIP Limit de 4 para "Em Revisão". Quando a coluna atinge 4 cartões, ninguém pode mover novos cartões de "Em Progresso" para "Em Revisão" até que um saia. Isso força o time a se concentrar em revisar e escoar, em vez de produzir mais trabalho que vai se acumular. Após 2 Sprints, o time identifica que a revisão demora porque os critérios de aceitação não estão claros, e ajusta a Definition of Ready.

**Como o candidato deve responder:**  
- Identificar o acúmulo como um bottleneck
- Explicar o conceito de gargalo determinando a velocidade do sistema
- Propor ações concretas: WIP Limit, realocação, investigação de causa raiz
- Mencionar que adianta empurrar mais trabalho não resolve, agrava
- Evitar propor apenas "colocar mais gente" sem investigar a causa
- Mencionar o princípio de proteger o gargalo

**Resposta fraca ou incompleta:**  
"É só colocar mais pessoas para revisar." — Isso trata o sintoma sem investigar a causa. Pode ser que a revisão demore por problemas de qualidade na entrada, e adicionar revisores só mascara o problema.

**Critérios de avaliação:**  
- 0 — Não identifica o gargalo ou não sabe o que fazer
- 1 — Identifica o acúmulo, mas propõe "colocar mais gente" sem investigar
- 2 — Menciona WIP Limit, mas não explica o propósito
- 3 — Identifica o gargalo, propõe WIP Limit e investigação de causa
- 4 — Explica o princípio de gargalo, propõe múltiplas ações e menciona causa raiz
- 5 — Articula o conceito de throughput, WIP Limit, causa raiz e realocação estratégica

---

### Pergunta 98 — Como explicar o valor do Agile para uma área não técnica

**Nível:** Júnior  
**Categoria:** Cenários reais

**Pergunta do entrevistador:**  
Suponha que o time de marketing da sua empresa quer entender o que é "Agile" e por que o time de desenvolvimento trabalha assim. Como você explicaria, em termos simples e sem jargões técnicos, o que é Agile e qual é o benefício dele para a empresa?

**O que essa pergunta avalia:**  
Avalia se o candidato tem compreensão profunda o suficiente para traduzir conceitos ágeis em linguagem acessível — um indicador de que realmente entendeu, em vez de memorizar termos.

**Resposta esperada:**  
Uma boa explicação para uma área não técnica seria algo como:

"Agile é uma forma de trabalhar que prioriza entregar valor em pequenos pedaços, com frequência, em vez de planejar tudo no início e só mostrar resultado no final. Imagine que você está organizando um evento. No modelo tradicional, você planeja tudo — agenda, palestrantes, buffet, local — por meses e só descobre se funcionou no dia do evento. No modelo ágil, você organizaria primeiro uma versão pequena do evento — um workshop de 1 hora — com poucos participantes, coletaria feedback, ajustaria e faria um evento um pouco maior na próxima iteração. A vantagem é que você descobre rapidamente o que funciona e o que não funciona, sem investir meses em algo que talvez ninguém queira.

Para a empresa, o benefício é: **menos desperdício** (porque não gastamos meses em algo que pode estar errado), **mais adaptação** (porque ajustamos a direção a cada poucas semanas), e **transparência** (porque mostramos o progresso continuamente, não apenas no final)."

**Explicação didática:**  
A capacidade de explicar um conceito técnico em linguagem leiga é um dos melhores testes de compreensão real. Se o candidato só sabe falar de "sprints", "backlog" e "velocity", ele memorizou o vocabulário mas não internalizou o conceito. A essência do Agile é: **entregar valor cedo, inspecionar e adaptar** — e isso pode ser explicado com analogias do cotidiano sem mencionar um único termo técnico.

**Exemplo prático:**  
"É como cozinhar uma receita nova. No modelo tradicional, você segue a receita inteira sem provar, serve o prato e só descobre que está salgado quando o convidado reclama. No modelo ágil, você vai provando durante o cozimento, ajusta o tempero e serve um prato que já está validado. Demora o mesmo tempo, mas o resultado é muito mais previsível."

**Como o candidato deve responder:**  
- Usar analogias do cotidiano (evento, restaurante, receita, viagem)
- Focar no benefício: menos desperdício, mais adaptação, mais transparência
- Evitar jargões (Sprint, backlog, velocity, Scrum, Kanban) ou explicá-los imediatamente
- Conectar o conceito com o dia a dia da área que está perguntando
- Evitar explicações longas e teóricas — ser direto e relacional
- Mencionar que Agile é uma filosofia, não um processo rígido

**Resposta fraca ou incompleta:**  
"Agile é um framework onde a gente faz Sprints de 2 semanas, usa Planning Poker para estimar e tem um Product Owner que prioriza o backlog." — Isso usa jargões sem explicar o benefício. A pessoa de marketing não vai entender nada e vai achar que é só "coisa de TI".

**Critérios de avaliação:**  
- 0 — Não consegue explicar sem jargões
- 1 — Usa analogias vagas, mas não transmite o benefício
- 2 — Explica conceitualmente, mas depende de jargões técnicos
- 3 — Usa analogias claras e explica o benefício principal (adaptação)
- 4 — Conecta com o contexto da área e menciona múltiplos benefícios (adaptação, transparência, menos desperdício)
- 5 — Traduz o conceito com naturalidade, usa analogias fortes e demonstra que internalizou a filosofia ágil

---

### Pergunta 99 — O que muda ao trocar de Kanban para Scrum

**Nível:** Júnior  
**Categoria:** Conceitos

**Pergunta do entrevistador:**  
Uma equipe que usava Kanban decide migrar para Scrum. Quais são as principais mudanças que ela precisará fazer na rotina, nos artefatos e na forma de trabalhar? Que aspectos do Kanban podem ser mantidos mesmo dentro do Scrum?

**O que essa pergunta avalia:**  
Avalia se o candidato entende as diferenças estruturais entre Kanban e Scrum e se sabe o que é preservável vs o que precisa ser adaptado na transição.

**Resposta esperada:**  
**Mudanças principais na rotina:**
- **Adoção de Sprints**: o time passa a trabalhar em iterações fixas (1-4 semanas), em vez de fluxo contínuo
- **Sprint Planning e Sprint Review**: novos eventos obrigatórios para planejar o escopo da Sprint e demonstrar o resultado
- **Sprint Retrospective**: passa a ser um evento formal, em vez de uma melhoria eventual
- **Compromisso com Sprint Goal**: o time define um objetivo para a Sprint, não apenas puxa cartões do topo do backlog
- **Daily Scrum**: já pode existir em Kanban (Daily Standup), mas no Scrum ganha formato e propósito mais estruturados

**Mudanças nos artefatos:**
- **Product Backlog e Sprint Backlog**: Scrum separa o backlog geral (Product Backlog) do backlog da Sprint (Sprint Backlog). No Kanban, geralmente há um único backlog visual no quadro
- **Incremento**: Scrum espera um incremento utilizável ao final de cada Sprint; Kanban não exige entregas atreladas a iterações

**Papéis:**
- Scrum exige três papéis formais (PO, SM, Dev Team). Kanban não define papéis obrigatórios — o time pode já ter essas figuras informalmente ou precisará designá-las

**Aspectos do Kanban que podem ser mantidos:**
- **Quadro visual** (físico ou digital): o quadro Kanban pode ser usado dentro do Scrum para visualizar o Sprint Backlog
- **WIP Limits**: podem ser aplicados dentro da Sprint para limitar o trabalho em paralelo e focar em completar itens
- **Métricas de fluxo** (Lead Time, Cycle Time): continuam sendo úteis para prever entregas dentro da Sprint
- **Políticas explícitas**: a ideia de deixar as regras do processo explícitas no quadro pode ser mantida

Isso se chama **Scrumban** — uma combinação de Scrum e Kanban que mantém a estrutura de Sprints do Scrum com a visualização e WIP Limits do Kanban.

**Explicação didática:**  
A transição de Kanban para Scrum não é trocar uma ferramenta por outra — é adicionar estrutura. O Kanban é minimalista: um quadro, WIP Limits, fluxo contínuo. O Scrum é mais estruturado: papéis, eventos, iterações. Migrar de Kanban para Scrum significa ganhar cadência (iterações fixas) e papéis claros, mas perdendo a flexibilidade de mudar prioridades a qualquer momento. O Kanban permite repriorizar o backlog a qualquer hora; no Scrum, o escopo da Sprint é fixo durante a Sprint (embora possa ser renegociado com o PO).

**Exemplo prático:**  
Um time que usava Kanban com um quadro de 5 colunas e WIP Limit de 3 por coluna decide migrar para Scrum. Mantém o quadro visual e os WIP Limits, mas agora o quadro representa o Sprint Backlog (não o fluxo contínuo). A cada 2 semanas, faz Planning, Review e Retrospective. O Product Backlog fica separado do quadro e é priorizado pelo PO.

**Como o candidato deve responder:**  
- Listar mudanças concretas: Sprints, ceremonies, papéis, Sprint Goal
- Mencionar que Kanban e Scrum não são mutuamente excludentes (Scrumban)
- Citar aspectos preserváveis: quadro visual, WIP Limits, métricas de fluxo
- Explicar a diferença fundamental: iterações fixas vs fluxo contínuo
- Evitar dizer que "Scrum é melhor que Kanban" ou vice-versa
- Mencionar que o Kanban permite repriorizar a qualquer momento, o Scrum fixa o escopo durante a Sprint

**Resposta fraca ou incompleta:**  
"No Scrum a gente faz Sprints e no Kanban não." — Verdade, mas incompleto. Não menciona papéis, ceremonies, artefatos, nem o que pode ser mantido. Ignora a possibilidade de combinação.

**Critérios de avaliação:**  
- 0 — Não sabe as diferenças ou confunde os dois frameworks
- 1 — Menciona Sprints, mas não detalha o resto
- 2 — Lista algumas mudanças, mas não menciona aspectos preserváveis
- 3 — Descreve mudanças de rotina, artefatos e papéis e menciona Scrumban
- 4 — Articula diferenças estruturais, cita aspectos preserváveis e explica a diferença de filosofia
- 5 — Demonstra visão completa da transição, incluindo trade-offs de flexibilidade e estrutura, com exemplo de Scrumban

---

### Pergunta 100 — Reflexão: quando Agile não é a escolha certa

**Nível:** Júnior  
**Categoria:** Conceitos

**Pergunta do entrevistador:**  
Nós falamos muito sobre os benefícios do Agile, mas é importante ter visão crítica: em que tipo de projeto ou situação você acha que uma abordagem ágil poderia NÃO ser a melhor escolha? Dê um exemplo e justifique.

**O que essa pergunta avalia:**  
Avalia se o candidato tem maturidade para reconhecer os limites do Agile, se entende que não existe bala de prata e se consegue pensar criticamente sobre a adequação de metodologias a contextos diferentes.

**Resposta esperada:**  
Existem situações em que o Agile não é a melhor escolha:

1. **Projetos com requisitos fixos e imutáveis por contrato**: quando o cliente exige um escopo exato, um prazo exato e um custo exato (modelo "fixed price, fixed scope, fixed time"), o Agile entra em conflito — o Agile presume que o escopo é flexível e que o tempo/custo podem ser ajustados. Exemplo: uma licitação pública onde o edital define exatamente o que deve ser entregue, quando e por quanto custo. Nesse caso, uma abordagem mais preditiva (Waterfall ou modelo em cascata) pode se adequar melhor à realidade contratual.

2. **Projetos com dependências rígidas e sequenciais**: quando cada etapa depende estritamente da anterior e não há como entregar valor parcial. Exemplo: construção civil — não dá para inspecionar e adaptar o aliceração depois que o prédio já está no terceiro andar.

3. **Projetos de segurança crítica com certificação**: sistemas que exigem certificação formal antes do uso (ex.: software de aviação, dispositivos médicos Classe III) podem requerer documentação completa e testes formais antes de qualquer iteração — o que dificulta a entrega incremental.

4. **Projetos muito curtos e simples**: se o projeto dura 2 semanas e tem escopo claro, o overhead de ceremonies do Scrum (Planning, Review, Retrospective) pode ser mais custoso que o benefício. Uma abordagem direta (ou Kanban simples) pode ser mais eficiente.

O ponto-chave é: **Agile brilha quando há incerteza e necessidade de adaptação**. Quando o problema é bem conhecido, o escopo é fixo e não há necessidade de adaptação, a sobrecarga do Agile pode não trazer valor.

**Explicação didática:**  
A metodologia é uma ferramenta, não um dogma. Usar Agile num projeto de requisitos fixos e imutáveis é como usar uma chave inglesa para apertar um parafuso — funciona, mas não é a ferramenta certa. O Agile foi criado para resolver um problema específico: **incerteza e mudança frequente de requisitos**. Quando esse problema não existe, a solução pode ser excessiva. A maturidade de um profissional ágil inclui saber reconhecer quando Agile não é a melhor resposta.

**Exemplo prático:**  
Uma empresa de software que desenvolve um sistema de controle de tráfego aéreo. O sistema precisa passar por certificações rigorosas, cada componente deve ser documentado e testado formalmente, e o escopo é definido por regulamentações internacionais. Entregar "incrementos" a cada 2 semanas não agrega valor se o sistema não pode ser usado até ser completamente certificado. Nesse caso, uma abordagem mais preditiva, com documentação completa e testes formais, é mais adequada.

**Como o candidato deve responder:**  
- Reconhecer que Agile não é uma bala de prata
- Citar pelo menos um contexto onde Agile não é ideal (contratos fixos, dependências rígidas, segurança crítica)
- Justificar com o princípio: Agile brilha com incerteza, não com previsibilidade total
- Mencionar que Agile não é "errado" nesses casos, mas pode ser ineficiente
- Evitar dizer que "Agile serve para tudo" (dogmatismo)
- Evitar dizer que "Agile não serve para nada" (ceticismo extremo)
- Manter visão equilibrada e baseada em contexto

**Resposta fraca ou incompleta:**  
"Agile serve para qualquer projeto." — Isso demonstra dogmatismo e falta de visão crítica. O Agile tem limites e contextos onde sua sobrecarga não agrega valor. A resposta ideal demonstra maturidade técnica, não fé cega na metodologia.

**Critérios de avaliação:**  
- 0 — Não sabe ou diz que Agile serve para tudo
- 1 — Menciona Waterfall como alternativa, mas sem justificativa
- 2 — Cita um exemplo, mas não explica o motivo
- 3 — Cita contexto válido e justifica com o princípio de incerteza
- 4 — Múltiplos contextos bem justificados, com exemplos concretos
- 5 — Visão crítica completa, com trade-offs, exemplos e reconhecimento dos limites sem dogmatismo

---

## Resumo Geral da Entrevista

### Tecnologia avaliada
**Scrum, Kanban e Metodologias Ágeis**

### Nível abordado
**Júnior** — 100 perguntas (Perguntas 1 a 100)

### Distribuição por categoria

| Categoria | Quantidade aproximada | Percentual |
|---|---|---|
| Conceitos fundamentais | 28 | 28% |
| Prática e aplicação | 24 | 24% |
| Cenários reais | 20 | 20% |
| Arquitetura e estrutura | 12 | 12% |
| Troubleshooting e disfunções | 10 | 10% |
| Testes e qualidade | 6 | 6% |

### Principais competências avaliadas

1. **Compreensão dos fundamentos do Scrum** — papéis, eventos, artefatos e regras do framework
2. **Compreensão dos fundamentos do Kanban** — princípios, práticas, métricas e visualização
3. **Diferenciação entre modelos ágeis e tradicionais** — quando usar cada um, vantagens e limites
4. **Aplicação prática em cenários reais** — lidar com impedimentos, PO ausente, estimativas divergentes, mudança de prioridade
5. **Interpretação de métricas ágeis** — Velocity, Burndown, Lead Time, Cycle Time, CFD
6. **Identificação de disfunções ágeis** — Daily como status report, Anti-Patterns, acúmulo de dívida técnica
7. **Comunicação e colaboração** — explicar Agile para não técnicos, facilitar ceremonies, dar e receber feedback
8. **Visão crítica e maturidade** — reconhecer limites do Agile, propor adaptações, evitar dogmatismo

---

## Matriz de Competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---|---|
| Fundamentos do Scrum (papéis, eventos, artefatos) | Júnior | 1, 2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 17, 20, 22, 23, 24, 25, 26, 27, 28, 30, 31, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 50, 53, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 94, 99, 100 | Define corretamente cada papel, evento e artefato; explica o propósito, não apenas a definição |
| Fundamentos do Kanban (princípios, práticas, métricas) | Júnior | 4, 9, 16, 18, 19, 21, 29, 32, 33, 49, 51, 52, 54, 93, 97, 99 | Explica os 6 regras/princípios, sabe aplicar WIP Limits, interpreta métricas de fluxo |
| Diferença entre Agile e modelos tradicionais | Júnior | 2, 3, 7, 20, 98, 100 | Compara filosofias, não apenas processos; reconhece limites de cada abordagem |
| Aplicação prática e tomada de decisão | Júnior | 5, 8, 11, 14, 15, 18, 22, 25, 26, 30, 31, 35, 37, 40, 43, 46, 49, 53, 55, 57, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 91, 95, 97 | Propõe soluções concretas em cenários reais; justifica com princípios ágeis |
| Identificação e resolução de disfunções | Júnior | 12, 17, 24, 28, 34, 38, 42, 45, 48, 52, 56, 59, 63, 67, 71, 75, 79, 83, 87, 93, 96, 97 | Reconhece anti-patterns; propõe melhorias estruturais; não confunde formato com propósito |
| Métricas e medição | Júnior | 9, 16, 21, 29, 33, 51, 54, 58, 62, 66, 70, 74, 78, 82, 86, 90, 97 | Sabe interpretar Velocity, Burndown, Lead/Cycle Time, CFD; entende limitações de cada métrica |
| Estimativas e planejamento | Júnior | 6, 13, 20, 27, 34, 41, 48, 55, 62, 69, 76, 83, 95 | Compreende Planning Poker, Story Points, velocity; sabe lidar com divergências e incerteza |
| Comunicação e facilitação | Júnior | 10, 17, 23, 30, 37, 44, 51, 58, 65, 72, 79, 86, 93, 98 | Traduz conceitos técnicos em linguagem acessível; facilita discussões sem impor respostas |
| Visão crítica e maturidade ágil | Júnior | 3, 7, 20, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 100 | Reconhece limites do Agile; propõe adaptações; evita dogmatismo; pensa em contexto |
| Qualidade, testes e Definition of Done | Júnior | 8, 15, 22, 29, 36, 43, 50, 57, 64, 71, 78, 85, 94 | Compreende DoD, DoR, relação entre qualidade e agilidade; sabe integrar testes no fluxo ágil |

---

## Recomendações para o Entrevistador

### Como conduzir a entrevista

1. **Comece com perguntas conceituais leves** (ex.: "O que é Scrum?") para aquecer o candidato e reduzir a ansiedade. Avance gradualmente para cenários mais complexos.
2. **Use as perguntas de cenário como ponto de partida**, não como roteiro fixo. Aproveite a resposta do candidato para fazer perguntas de aprofundamento e explorar o real entendimento.
3. **Mantenha o tom de conversa técnica**, não de interrogatório. O objetivo é entender como o candidato pensa, não decorar respostas.
4. **Agrupe perguntas por tema** quando fizer sentido — se o candidato respondeu bem sobre Daily Scrum, faça 2-3 perguntas relacionadas antes de mudar de tema.
5. **Selecione 10-15 perguntas por entrevista** em vez de tentar cobrir todas as 100. Escolha uma mix de conceituais, práticas e cenários.

### Como fazer perguntas de aprofundamento

- Sempre que o candidato responder de forma rápida ou superficial, use as **perguntas de aprofundamento** fornecidas em cada questão
- Varie o tipo: "Por quê?", "Em quais situações isso não funcionaria?", "Como você faria em produção?", "Quais os riscos?"
- Use aprofundamento para distinguir quem **decorou** de quem **compreendeu**: peça exemplos da própria experiência
- Se o candidato não souber, ofereça uma dica e veja se ele consegue construir a resposta — isso avalia capacidade de raciocínio, não apenas memória

### Como diferenciar insegurança de falta de conhecimento

- **Insegurança**: o candidato hesita, mas quando você reformula a pergunta ou dá uma dica, ele constrói a resposta corretamente. Isso indica que sabe, mas precisa confiança.
- **Falta de conhecimento**: mesmo com dicas e reformulação, o candidato não consegue articular o conceito. Isso indica que realmente não sabe.
- **Conhecimento decorado**: o candidato repete definições corretas, mas não consegue aplicar em cenários ou explicar trade-offs. Use perguntas de cenário para testar isso.
- **Conhecimento aplicado**: o candidato conecta o conceito com experiência prática, menciona exemplos reais e discute o que deu errado ou o que aprendeu.

### Como avaliar respostas parcialmente corretas

- Use a **escala 0-5** de cada pergunta como referência, mas pondere pelo contexto da entrevista inteira
- Uma resposta nível 3 em uma pergunta difícil pode ser mais valiosa que nível 4 em uma pergunta fácil
- Avalie se o candidato **sabe o que não sabe** — admitir "não sei, mas acho que seria assim..." e raciocinar é melhor que inventar uma resposta incorreta com confiança
- Considere a **trajetória de aprendizado**: se o candidato melhora ao longo da entrevista (aprende com as dicas e aplica nos próximos temas), isso é um sinal positivo

### Como evitar vieses na avaliação

- **Viés de confirmação**: não decida o veredito nas primeiras 3 perguntas. Mantenha a mente aberta até o final.
- **Viés de similaridade**: não favoreça candidatos que usam os mesmos termos ou ferramentas que você. Avalie a compreensão, não o vocabulário.
- **Viés de confiança**: um candidato seguro não é necessariamente competente. Avalie o conteúdo, não a performance.
- **Viés de recência**: não dê peso excessivo à última pergunta. Considere a entrevista inteira.
- **Use a matriz de competências** para registrar evidências objetivas por categoria, em vez de uma impressão geral.

### Como registrar evidências objetivas

- Anote **citações diretas** do candidato em vez de paráfrases ("disse que Velocity é 'a média de pontos que o time entrega'")
- Registre **o que o candidato disse** e **o que não mencionou** (ex.: "explicou Daily corretamente, mas não mencionou o foco na Sprint Goal")
- Use a **escala 0-5** por pergunta e calcule a média por categoria
- Documente **perguntas de aprofundamento feitas** e como o candidato respondeu a elas
- Anote **exemplos citados** pelo candidato (próprios ou teóricos) — isso ajuda a distinguir experiência real de conhecimento teórico

---

## Recomendações para o Candidato

### Como estruturar o raciocínio

1. **Ouça a pergunta completa** antes de começar a responder. Se necessário, peça para repetir — isso não é sinal de fraqueza.
2. **Comece pela definição** do conceito, depois **aplique ao cenário**. Estrutura: "O conceito X é... No cenário que você descreveu, isso se aplica assim..."
3. **Use a estrutura "O que é → Por que existe → Como funciona → Quando não usar"** para respostas conceituais. Isso demonstra profundidade sem ser excessivamente longo.
4. **Pense em voz alta** — o entrevistador quer ver seu raciocínio, não apenas a resposta final. Dizer "estou pensando em..." é melhor que ficar em silêncio por 30 segundos.

### Como explicar decisões técnicas

1. **Sempre justifique com princípios**, não com preferências pessoais. "Eu usaria X porque o princípio do Scrum diz..." é melhor que "Eu prefiro X".
2. **Mencione trade-offs** mesmo quando não forem perguntados diretamente. "Essa abordagem tem a vantagem de... mas o risco é..."
3. **Conecte com experiência prática** quando possível: "No meu último projeto, enfrentamos algo parecido e resolvemos assim..."
4. **Evite absolutismos**: raramente existe uma única resposta correta em Agile. Use "depende do contexto" e explique quais fatores influenciam.

### Como utilizar exemplos reais

1. **Cite projetos específicos** em que você aplicou o conceito, mesmo que seja um projeto acadêmico ou pessoal
2. **Inclua o que deu errado**, não apenas o que funcionou — maturidade se demonstra com erros e aprendizados
3. **Seja honesto sobre seu papel**: se você não era o Scrum Master, diga "participei como dev" em vez de implicar que liderou a adoção
4. **Use exemplos que mostrem adaptação**, não apenas execução mecânica: "Seguíamos o Scrum formalmente, mas adaptamos a Retrospective para..."

### Como admitir que não sabe algo

1. **Diga "não sei" diretamente**, sem rodeios. Tentar disfarçar é pior que admitir.
2. **Ofereça um raciocínio**: "Não conheço esse conceito especificamente, mas pelo que você descreveu, imagino que..."
3. **Mostre curiosidade**: "Não sabia disso, mas me interessa. Como funciona?" — isso demonstra mentalidade de aprendizado
4. **Não tente mudar de assunto** para esconder a lacuna. O entrevistador vai notar.
5. **Lembre-se**: ninguém sabe tudo, especialmente em nível Júnior. Admitir que não sabe e raciocinar é muito melhor que inventar.

### Como discutir trade-offs

1. **Identifique as dimensões em conflito**: velocidade vs qualidade, flexibilidade vs previsibilidade, autonomia vs alinhamento
2. **Apresente ambos os lados**: "A vantagem dessa abordagem é... mas a desvantagem é..."
3. **Indique o contexto que favorece cada lado**: "Em um time maduro, faz sentido... Em um time novo, eu priorizaria..."
4. **Tome uma posição**: não fique em cima do muro. Escolha um lado e justifique — depois mencione quando o outro lado seria melhor

### Como responder perguntas práticas e de arquitetura

1. **Descreva o cenário antes de propor a solução**: "Nessa situação, o problema principal é... então eu começaria por..."
2. **Proponha passos concretos**, não abstrações: "Primeiro, documentaria os impactos. Depois, escalaria ao SM..."
3. **Mencione o que você monitoraria** para validar se a solução funcionou
4. **Considere o impacto no time**, não apenas no processo: "Isso pode gerar resistência, então eu comunicaria antes..."
5. **Pergunte sobre restrições** se o cenário for aberto: "Posso assumir que o time tem experiência com Scrum?" — isso demonstra pensamento contextual

