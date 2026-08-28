# Roteiro de Entrevista Técnica — AWS (Amazon Web Services)

## 📋 Visão Geral da Entrevista

| Item | Detalhe |
|---|---|
| **Tecnologia avaliada** | AWS (Amazon Web Services) |
| **Nível abordado** | Júnior |
| **Quantidade total de perguntas** | 100 |
| **Tipo de perguntas** | Misturadas (conceituais, práticas e cenários reais) |

### Distribuição por categoria

| Categoria | Qtd. aprox. |
|---|---|
| Fundamentos de Cloud Computing | 15 |
| EC2 e Computação | 12 |
| S3 e Armazenamento | 12 |
| IAM e Segurança | 12 |
| VPC e Networking | 12 |
| RDS e Bancos de Dados | 10 |
| Lambda e Serverless | 8 |
| CloudWatch e Monitoramento | 7 |
| Billing, Pricing e Support | 6 |
| Cenários práticos e Troubleshooting | 6 |

### Principais competências avaliadas

- Compreensão dos conceitos fundamentais de computação em nuvem
- Conhecimento dos serviços principais da AWS (EC2, S3, RDS, IAM, VPC, Lambda)
- Boas práticas iniciais de segurança e gerenciamento de acesso
- Capacidade de descrever arquiteturas simples
- Resolução de problemas básicos do dia a dia
- Entendimento de modelos de precificação e suporte

---

## 📊 Matriz de Competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---|---|
| Fundamentos de Cloud | Júnior | 1–15 | Define IaaS/PaaS/SaaS, explica benefícios da nuvem, diferencia on-premise de cloud |
| EC2 e Computação | Júnior | 16–27 | Descreve instâncias, AMIs, tipos de instância, entende auto-scaling básico |
| S3 e Armazenamento | Júnior | 28–39 | Explica buckets, classes de armazenamento, permissões, ciclo de vida |
| IAM e Segurança | Júnior | 40–51 | Compreende usuários, grupos, roles, policies, princípio do menor privilégio |
| VPC e Networking | Júnior | 52–63 | Descreve VPC, subnets, route tables, security groups vs NACLs |
| RDS e Bancos de Dados | Júnior | 64–73 | Explica RDS, DynamoDB, diferenças entre SQL e NoSQL na AWS |
| Lambda e Serverless | Júnior | 74–81 | Entende conceito serverless, triggers, cold start básico |
| CloudWatch e Monitoramento | Júnior | 82–88 | Descreve métricas, logs, alarmes, diferença entre monitoring e logging |
| Billing e Pricing | Júnior | 89–94 | Compreende pay-as-you-go, Free Tier, modelos de precificação |
| Troubleshooting e Cenários | Júnior | 95–100 | Identifica problemas comuns, propõe soluções simples |

---

## 🧭 Recomendações para o Entrevistador

### Como conduzir a entrevista
- Comece com perguntas conceituais para aquecer o candidato e reduzir a ansiedade
- Progrida gradualmente para perguntas práticas e de cenário
- Use as perguntas de aprofundamento quando o candidato responder rapidamente ou de forma superficial
- Reserve as perguntas de troubleshooting para o final, pois exigem integração de múltiplos conceitos

### Como diferenciar insegurança de falta de conhecimento
- **Insegurança**: o candidato hesita, mas quando incentivado a pensar em voz alta, começa a conectar conceitos corretamente
- **Falta de conhecimento**: o candidato não consegue nem iniciar o raciocínio, mesmo com dicas e incentivo
- Faça perguntas de aprofundamento: se o candidato justifica sua incerteza com raciocínio válido, é sinal de insegurança; se não consegue desenvolver o tema, é lacuna de conhecimento

### Como avaliar respostas parcialmente corretas
- Identifique se a parte correta demonstra compreensão real ou apenas memorização
- Peça para o candidato explicar o "porquê" de cada afirmação
- Uma resposta parcial com raciocínio sólido vale mais que uma resposta completa decorada sem entendimento

### Como evitar vieses na avaliação
- Use a escala de 0–5 de forma consistente para todos os candidatos
- Anote as respostas literalmente durante a entrevista para revisar depois
- Não deixe que a simpatia ou o estilo de comunicação do candidato influenciem a nota técnica
- Avalie cada pergunta independentemente das anteriores

### Como registrar evidências objetivas
- Para cada pergunta, anote: a nota (0–5), trechos-chave da resposta do candidato, e se solicitou dicas
- Marque se o candidato mencionou trade-offs, boas práticas ou exemplos reais por iniciativa própria
- Registre o tempo de resposta e se pediu esclarecimentos (o que demonstra maturidade)

---

## 🎯 Recomendações para o Candidato

### Como estruturar o raciocínio
- Use a técnica **STAR** quando aplicável: Situação, Tarefa, Ação, Resultado
- Comece definindo os conceitos antes de entrar em detalhes técnicos
- Pense em voz alta: entrevistadores avaliam o processo de raciocínio, não apenas a resposta final

### Como explicar decisões técnicas
- Sempre que possível, mencione **trade-offs**: "Escolhi X porque Y, mas a desvantagem é Z"
- Relacione a decisão ao contexto: "Dependendo do cenário, escolheria A ou B"
- Mostre que entende que não existe solução perfeita, apenas a mais adequada para cada situação

### Como utilizar exemplos reais
- Mesmo como júnior, você pode citar projetos acadêmicos, pessoais ou laboratórios (como AWS Free Tier)
- Descreva o que você fez, qual serviço usou e por quê
- Se não tem experiência prática com um serviço, seja honesto e explique o que estudou sobre ele

### Como admitir que não sabe algo
- Diga: "Não tenho experiência prática com esse serviço, mas pelo que estudou, entendo que..."
- Não tente inventar respostas: entrevistadores experientes percebem e isso prejudica mais do que admitir
- Demonstre curiosidade: "Não conheço essa feature, mas como ela funciona?" — isso mostra vontade de aprender

### Como discutir trade-offs
- Compare custo vs. desempenho, simplicidade vs. flexibilidade, velocidade vs. segurança
- Use exemplos: "O S3 Standard é mais caro que o Glacier, mas oferece acesso imediato aos dados"

### Como responder perguntas práticas e de arquitetura
- Comece identificando os requisitos: "Precisamos de armazenamento durável, acesso frequente e baixa latência"
- Proponha uma solução passo a passo: "Usaria S3 para os arquivos, CloudFront para distribuição..."
- Mencione como testaria e monitoraria a solução

---

## 📝 Perguntas da Entrevista

> **Parte 1 de 10 — Perguntas 1 a 10 (Fundamentos de Cloud Computing)**

---

### Pergunta 1 — O que é computação em nuvem?

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
"O que você entende por 'computação em nuvem'? Como você definiria esse conceito para alguém que nunca ouviu falar?"

**O que essa pergunta avalia:**
Avalia se o candidato possui uma compreensão clara e fundamental do conceito de computação em nuvem — a base sobre a qual todo o conhecimento em AWS é construído. Verifica se consegue explicar o conceito sem jargões e se entende as características essenciais.

**Resposta esperada:**
Computação em nuvem é a entrega de serviços de TI (como servidores, armazenamento, bancos de dados, redes, software) sob demanda pela internet, com pagamento conforme o uso (pay-as-you-go). Em vez de comprar, configurar e manter servidores físicos em um data center próprio (on-premise), você aluga recursos de um provedor como a AWS, que cuida da infraestrutura física. A nuvem oferece elasticidade (escalar recursos para cima ou para baixo conforme a demanda),自助-serviço (provisionar recursos via console ou API sem intervenção humana do provedor) e acesso global a partir de qualquer lugar.

**Explicação didática:**
Pense na nuvem como o serviço de eletricidade: você não constrói sua própria usina elétrica. Em vez disso, você se conecta à rede e paga apenas pelo que consome. Se precisar de mais energia, a rede fornece. Se consumir menos, paga menos. A computação em nuvem funciona da mesma forma com recursos de TI. Na AWS, você usa o console web, a CLI (Command Line Interface) ou APIs para provisionar recursos em segundos, sem precisar aguardar a compra e instalação de hardware físico. O provedor (AWS) cuida da manutenção física dos servidores, energia, refrigeração e segurança do data center.

**Exemplo prático:**
Uma startup que precisa lançar um aplicativo pode provisionar servidores, banco de dados e armazenamento na AWS em minutos, sem investimento inicial em hardware. À medida que o app ganha usuários, a empresa pode escalar os recursos automaticamente. Se o tráfego diminuir, ela reduz os recursos e paga menos.

**Como o candidato deve responder:**
- Definir o conceito de forma simples e direta
- Mencionar pagamento por uso (pay-as-you-go)
- Citar características principais: elasticidade, provisionamento sob demanda, acesso via internet
- Diferenciar brevemente de infraestrutura on-premise
- Evitar apenas decorar a definição — deve demonstrar compreensão real do conceito

**Resposta fraca ou incompleta:**
"É quando você guarda seus dados na internet em vez de no computador." — Esta resposta é muito superficial e confunde computação em nuvem com apenas armazenamento online. Falta mencionar os serviços de computação, o modelo de pagamento, a elasticidade e a diferença em relação ao on-premise.

**Critérios de avaliação:**
- 0 — Não sabe responder ou apresenta informações incorretas
- 1 — Menciona vagamente "servidores na internet"
- 2 — Sabe que é alugar servidores, mas não menciona pay-as-you-go ou elasticidade
- 3 — Define corretamente, menciona pay-as-you-go e diferencia de on-premise
- 4 — Define corretamente, cita características principais e dá um exemplo prático
- 5 — Define com precisão, cita todas as características essenciais, diferencia de on-premise e discute benefícios e limitações

**Perguntas de aprofundamento:**
1. "Quais são as principais diferenças entre usar um servidor físico próprio e um servidor na AWS?"
2. "O que significa dizer que a nuvem é 'elástica'? Dê um exemplo."
3. "Você consegue pensar em uma situação em que a nuvem não seria a melhor escolha?"

---

### Pergunta 2 — Modelos de serviço: IaaS, PaaS e SaaS

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
"Você consegue explicar a diferença entre IaaS, PaaS e SaaS? Como esses modelos se aplicam na AWS?"

**O que essa pergunta avalia:**
Avalia se o candidato conhece os três modelos principais de serviço em nuvem e se consegue mapeá-los para serviços reais da AWS. Isso é fundamental para entender qual nível de responsabilidade e controle se tem em cada serviço.

**Resposta esperada:**
- **IaaS (Infrastructure as a Service)**: O provedor fornece a infraestrutura base (servidores virtuais, rede, armazenamento). Você gerencia o sistema operacional, aplicativos e dados. Exemplo na AWS: **EC2** — você aluga uma máquina virtual e configura tudo a partir do SO.
- **PaaS (Platform as a Service)**: O provedor cuida da infraestrutura e do sistema operacional, e fornece uma plataforma para você executar aplicativos. Você foca apenas no código e nos dados. Exemplo na AWS: **Elastic Beanstalk** ou **RDS** — você não precisa gerenciar o servidor ou o sistema operacional do banco de dados.
- **SaaS (Software as a Service)**: O provedor cuida de tudo, incluindo o aplicativo. Você apenas usa o software pronto. Exemplo: serviços como Amazon Chime, ou aplicativos de terceiros rodando na AWS.

**Explicação didática:**
Imagine cozinhar uma refeição:
- **IaaS** é como alugar uma cozinha equipada: você leva os ingredientes, cozinha do jeito que quiser e limpa depois. Você tem controle total, mas também mais responsabilidade.
- **PaaS** é como pedir uma refeição em um restaurante onde você escolhe os ingredientes e o chef prepara: você não se preocupa com a cozinha, apenas com o que vai no prato.
- **SaaS** é como pedir delivery: a comida cheja pronta, você apenas consome.

**Exemplo prático:**
Se uma empresa precisa de um banco de dados PostgreSQL, pode escolher:
- **IaaS**: Instalar o PostgreSQL em uma instância EC2 (gerencia SO, backups, patches)
- **PaaS**: Usar o Amazon RDS para PostgreSQL (AWS cuida do SO, backups e patches)
- **SaaS**: Usar um aplicativo que já tem banco de dados embutido (não se preocupa com nada)

**Como o candidato deve responder:**
- Definir os três modelos de forma clara
- Dar exemplos de serviços AWS para cada modelo
- Explicar o nível de controle e responsabilidade em cada um
- Mencionar que a escolha depende do trade-off entre controle e conveniência
- Evitar confundir os modelos ou dar exemplos trocados

**Resposta fraca ou incompleta:**
"IaaS é infraestrutura, PaaS é plataforma e SaaS é software." — A resposta apenas traduz as siglas sem explicar o que significam na prática. Falta explicar os níveis de responsabilidade e dar exemplos concretos.

**Critérios de avaliação:**
- 0 — Não sabe responder ou confunde os modelos
- 1 — Sabe o que as siglas significam, mas não explica diferenças
- 2 — Explica um ou dois modelos corretamente
- 3 — Define os três modelos corretamente com exemplos básicos
- 4 — Define os três, dá exemplos da AWS e explica o nível de responsabilidade
- 5 — Define com clareza, mapeia para AWS, explica trade-offs e discute quando escolher cada modelo

**Perguntas de aprofundamento:**
1. "Se você precisasse de controle total sobre a configuração do sistema operacional, qual modelo escolheria?"
2. "Por que uma empresa pode preferir PaaS em vez de IaaS para um banco de dados?"
3. "O modelo SaaS remove completamente a responsabilidade de segurança do cliente?"

---

### Pergunta 3 — Regiões, Zonas de Disponibilidade e Edge Locations

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
"A AWS organiza sua infraestrutura em Regiões, Zonas de Disponibilidade e Edge Locations. Você consegue explicar o que são cada uma e por que isso importa?"

**O que essa pergunta avalia:**
Avalia se o candidato entende a estrutura geográfica da AWS, conceito essencial para arquitetar aplicações resilientes e entender latência, compliance e disponibilidade.

**Resposta esperada:**
- **Região (Region)**: É uma área geográfica do mundo (como "us-east-1" no Norte da Virgínia ou "sa-east-1" em São Paulo). Cada região é completamente independente e contém múltiplas Zonas de Disponibilidade. Os dados não saem de uma região sem o consentimento explícito do cliente.
- **Zona de Disponibilidade (AZ — Availability Zone)**: São data centers físicos distintos dentro de uma região, com energia, refrigeração e rede independentes. Cada região tem ao menos 2 AZs (geralmente 3 ou mais). As AZs são conectadas com rede de baixa latência, mas são isoladas para evitar falhas simultâneas.
- **Edge Location**: São pontos de presença distribuídos globalmente, usados principalmente pelo Amazon CloudFront (CDN) e Route 53 (DNS) para entregar conteúdo com baixa latência aos usuários finais. Existem muito mais Edge Locations do que Regiões.

**Explicação didática:**
Imagine que uma Região é um país, com vários estados. Cada estado é uma Zona de Disponibilidade — eles estão no mesmo país (conectados), mas são geograficamente separados. Se um estado sofre um blecaute, os outros continuam funcionando. As Edge Locations são como correios espalhados por todos os bairros do mundo — elas guardam cópias de conteúdo popular para entregar rápido ao usuário, sem precisar ir até a sede central.

**Exemplo prático:**
Se sua aplicação está na região "sa-east-1" (São Paulo) e você distribui as instâncias entre três AZs, uma queda de energia em um data center não derruba sua aplicação, pois as outras duas AZs continuam funcionando. Já o CloudFront usa Edge Locations para servir conteúdo estático (imagens, vídeos) a partir de um local próximo ao usuário, reduzindo a latência.

**Como o candidato deve responder:**
- Definir os três conceitos com clareza
- Explicar a relação hierárquica: Regiões contêm AZs
- Mencionar isolamento e independência entre AZs
- Explicar o papel das Edge Locations (CDN, DNS)
- Citar o impacto em latência e disponibilidade
- Evitar confundir Edge Locations com Regiões

**Resposta fraca ou incompleta:**
"Regiões são onde ficam os servidores, AZs são data centers e Edge Locations são pontos de acesso." — A resposta não explica a relação entre eles nem por que isso importa para a arquitetura. Falta mencionar isolamento de falhas e latência.

**Critérios de avaliação:**
- 0 — Não sabe responder ou confunde os conceitos
- 1 — Sabe que existem Regiões, mas não explica AZs ou Edge Locations
- 2 — Define dois dos três conceitos corretamente
- 3 — Define os três conceitos corretamente
- 4 — Define os três, explica isolamento de falhas e relação com latência
- 5 — Define com precisão, explica isolamento, latência, compliance e dá exemplos de uso

**Perguntas de aprofundamento:**
1. "Por que a AWS recomenda distribuir aplicação em pelo menos duas AZs?"
2. "Os dados de uma região são automaticamente replicados para outra região?"
3. "Qual é a diferença entre usar o CloudFront e simplesmente escolher a região mais próxima do usuário?"

---

### Pergunta 4 — Modelos de implantação de nuvem

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
"Quais são os modelos de implantação de nuvem? Se uma empresa mantém parte dos sistemas no próprio data center e parte na AWS, qual é esse modelo?"

**O que essa pergunta avalia:**
Avalia se o candidato conhece os três modelos de implantação (público, privado, híbrido) e entende que a realidade da maioria das empresas é híbrida.

**Resposta esperada:**
Existem três modelos principais de implantação de nuvem:
- **Nuvem pública**: Todos os recursos estão com um provedor (como AWS). Vários clientes compartilham a mesma infraestrutura física, mas com isolamento lógico. É o modelo mais comum.
- **Nuvem privada**: Infraestrutura exclusiva para uma organização, pode ser on-premise ou hospedada. Oferece mais controle, mas com custo e complexidade maiores.
- **Nuvem híbrida**: Combina nuvem pública com privada (on-premise), com comunicação entre elas. Exemplo: manter dados sensíveis no data center próprio e usar a AWS para processamento e aplicações.

O cenário descrito na pergunta — parte no data center próprio e parte na AWS — é o modelo **híbrido**.

**Explicação didática:**
Imagine que você tem uma casa (nuvem privada) e também aluga um apartamento (nuvem pública). No modelo híbrido, você mora em ambos e transita entre eles conforme a necessidade: guarda o que é mais valioso na casa própria e usa o apartamento alugado quando precisa de mais espaço temporariamente. O AWS Direct Connect e o AWS VPN facilitam a comunicação segura entre o data center local e a nuvem AWS no modelo híbrido.

**Exemplo prático:**
Um banco pode manter o banco de dados de transações financeiras sensíveis em seu próprio data center (nuvem privada), enquanto usa a AWS para hospedar o aplicativo web de atendimento ao cliente e processamento de dados não sensíveis (nuvem pública), conectando ambos de forma segura via VPN ou Direct Connect.

**Como o candidato deve responder:**
- Listar os três modelos de implantação
- Explicar as características de cada um
- Identificar corretamente o cenário como híbrido
- Mencionar que o modelo híbrido é comum por questões de compliance, segurança ou migração gradual
- Evitar confundir modelos de implantação com modelos de serviço (IaaS/PaaS/SaaS)

**Resposta fraca ou incompleta:**
"Acho que é nuvem mista." — Não explica o que é nuvem mista/híbrida, não menciona os outros modelos e não justifica por que é híbrida.

**Critérios de avaliação:**
- 0 — Não sabe responder
- 1 — Menciona nuvem híbrida, mas não explica
- 2 — Explica um ou dois modelos corretamente
- 3 — Lista os três modelos e identifica o cenário como híbrido
- 4 — Explica os três modelos, identifica o cenário e menciona casos de uso
- 5 — Explica os três, identifica o cenário, discute trade-offs e dá exemplos práticos

**Perguntas de aprofundamento:**
1. "Por que uma empresa escolheria manter parte dos sistemas on-premise em vez de migrar tudo para a nuvem?"
2. "Como a comunicação entre o data center e a AWS pode ser feita de forma segura?"
3. "Qual seria a desvantagem de uma arquitetura totalmente híbrida em relação a uma 100% em nuvem?"

---

### Pergunta 5 — Conceito de Elasticidade

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
"Um dos benefícios mais citados da nuvem é a 'elasticidade'. O que significa dizer que a AWS é elástica? Dê um exemplo prático."

**O que essa pergunta avalia:**
Avalia se o candidato entende um dos conceitos mais centrais da computação em nuvem — a capacidade de ajustar recursos automaticamente conforme a demanda.

**Resposta esperada:**
Elasticidade é a capacidade de aumentar (scale out) ou diminuir (scale in) os recursos automaticamente conforme a demanda. Na AWS, isso é possível porque os recursos são virtualizados e provisionados sob demanda. Por exemplo, com o **Auto Scaling** do EC2, você pode definir que se o uso de CPU ultrapassar 70%, novas instâncias serão automaticamente criadas para dividir a carga. Quando a CPU voltar ao normal, as instâncias extras são removidas. Isso significa que você paga apenas pelo que usa, sem precisar manter servidores ociosos para picos de tráfego.

É importante diferenciar elasticidade de escalabilidade: a escalabilidade é a capacidade de aumentar recursos (como usar uma instância maior), enquanto a elasticidade é a capacidade de ajustar automaticamente, tanto para cima quanto para baixo.

**Explicação didática:**
Imagine um restaurante. Elasticidade é como ter a capacidade de adicionar ou remover mesas automaticamente conforme a fila de clientes cresce ou diminui. Se chega muita gente, mais mesas aparecem; quando a fila acaba, as mesas extras são guardadas. Você não mantém mesas ociosas o dia todo só por causa do horário de pico.

**Exemplo prático:**
Um site de e-commerce recebe muito tráfego durante a Black Friday. Com Auto Scaling, a AWS cria instâncias EC2 adicionais automaticamente para suportar o aumento de acessos. Quando a Black Friday termina e o tráfego normaliza, as instâncias extras são removidas, reduzindo custos.

**Exemplo de código:**
```bash
# Exemplo de configuração de Auto Scaling via AWS CLI
# Criar um grupo de Auto Scaling com mínimo 2 e máximo 10 instâncias
aws autoscaling create-auto-scaling-group \
  --auto-scaling-group-name "meu-asg" \
  --launch-template "LaunchTemplateId=lt-abc123" \
  --min-size 2 \
  --max-size 10 \
  --desired-capacity 2 \
  --vpc-zone-identifier "subnet-abc123,subnet-def456"
```
O `min-size` garante que sempre haverá ao menos 2 instâncias rodando. O `max-size` define o limite máximo para evitar custos inesperados. O `desired-capacity` é o número alvo de instâncias em condições normais.

**Como o candidato deve responder:**
- Definir elasticidade de forma clara: ajustar recursos automaticamente
- Dar um exemplo concreto (como Auto Scaling com EC2)
- Mencionar o benefício financeiro: pagar apenas pelo que usa
- Diferenciar elasticidade de escalabilidade, se possível
- Evitar confundir elasticidade com apenas "aumentar servidores"

**Resposta fraca ou incompleta:**
"É quando a AWS aumenta os servidores quando precisa." — Falta mencionar que a elasticidade também reduz recursos, que é automática e que resulta em economia. É apenas uma parte do conceito.

**Critérios de avaliação:**
- 0 — Não sabe responder
- 1 — Menciona vagamente "aumentar servidores"
- 2 — Sabe que é aumentar e diminuir, mas não explica automação
- 3 — Define corretamente, menciona aumento e diminuição automáticos
- 4 — Define corretamente, dá exemplo prático e menciona economia
- 5 — Define com precisão, dá exemplo, menciona economia, diferencia de escalabilidade e discute limitações

**Perguntas de aprofundamento:**
1. "Qual é a diferença entre escalar verticalmente e escalar horizontalmente?"
2. "Como o Auto Scaling decide quando adicionar ou remover instâncias?"
3. "Existe algum risco em configurar um Auto Scaling muito agressivo?"

---

### Pergunta 6 — Modelo de responsabilidade compartilhada

**Nível:** Júnior
**Categoria:** Fundamentos / Segurança

**Pergunta do entrevistador:**
"A AWS fala sobre um 'modelo de responsabilidade compartilhada'. O que é esse modelo e por que ele é importante?"

**O que essa pergunta avalia:**
Avalia se o candidato entende um dos conceitos de segurança mais fundamentais da AWS: a divisão de responsabilidades entre o provedor e o cliente. Isso é crucial para evitar falsas expectativas de segurança.

**Resposta esperada:**
O modelo de responsabilidade compartilhada define que a AWS é responsável pela segurança **da** nuvem (a infraestrutura física), enquanto o cliente é responsável pela segurança **na** nuvem (como configura seus recursos e dados).

**AWS é responsável por:**
- Segurança física dos data centers (energia, refrigeração, acesso físico)
- Infraestrutura de hardware (servidores, armazenamento, rede)
- Virtualização (hypervisor)
- Software que gerencia os serviços (como o software do RDS)

**Cliente é responsável por:**
- Configuração de segurança de instâncias EC2 (security groups, SO, patches)
- Gerenciamento de acesso (IAM, chaves, senhas)
- Criptografia de dados (em trânsito e em repouso)
- Configuração de firewall e rede (VPC, NACLs)
- Backups e gerenciamento de dados

O nível de responsabilidade do cliente varia conforme o serviço. Por exemplo, no EC2 (IaaS), o cliente é responsável por quase tudo acima do hypervisor. No RDS (PaaS), a AWS cuida do sistema operacional e patches do banco de dados, mas o cliente ainda controla quem acessa e como os dados são protegidos.

**Explicação didática:**
Imagine que você aluga um apartamento. O proprietário (AWS) é responsável pela estrutura do prédio: paredes, encanação, portas de entrada. Você (cliente) é responsável por trancar a porta, guardar seus objetos de valor e decidir quem entra. Se você deixar a porta aberta, o proprietário não é culpado. Mas se o prédio desabar por problema estrutural, a responsabilidade é do proprietário.

**Exemplo prático:**
Se um atacante acessa uma instância EC2 porque o security group estava configurado para permitir acesso SSH de qualquer IP (0.0.0.0/0), a culpa é do cliente — não da AWS. A AWS forneceu as ferramentas (security groups), mas o cliente as configurou incorretamente. Já se houvesse uma violação física do data center, a responsabilidade seria da AWS.

**Como o candidato deve responder:**
- Explicar a divisão: AWS cuida da infraestrutura, cliente cuida da configuração
- Citar exemplos concretos do que cada lado gerencia
- Mencionar que a responsabilidade varia conforme o tipo de serviço (IaaS vs PaaS vs SaaS)
- Dar pelo menos um exemplo de erro do cliente e um de responsabilidade da AWS
- Evitar dizer que a AWS cuida de "tudo" ou que o cliente é responsável por "nada"

**Resposta fraca ou incompleta:**
"A AWS cuida da segurança e eu cuido dos meus dados." — Esta resposta é muito simplista. Falta explicar que a divisão depende do serviço e não menciona configurações de rede, patches de SO, IAM e criptografia.

**Critérios de avaliação:**
- 0 — Não sabe responder ou diz que a AWS cuida de tudo
- 1 — Menciona vagamente uma divisão, mas não explica
- 2 — Sabe que há uma divisão, mas confunde quem é responsável pelo quê
- 3 — Explica corretamente: AWS = infraestrutura, cliente = configuração
- 4 — Explica corretamente, dá exemplos e menciona variação por tipo de serviço
- 5 — Explica com precisão, dá exemplos concretos, menciona variação por serviço e discute implicações práticas

**Perguntas de aprofundamento:**
1. "No caso do RDS, quais responsabilidades a AWS assume que o cliente não precisa se preocupar?"
2. "Se um dado for perdido porque não havia backup, de quem é a responsabilidade?"
3. "Como o modelo muda quando usamos um serviço SaaS em vez de IaaS?"

---

### Pergunta 7 — Pay-as-you-go e benefícios econômicos

**Nível:** Júnior
**Categoria:** Fundamentos / Billing

**Pergunta do entrevistador:**
"Como funciona o modelo de precificação da AWS? Por que ele é diferente de manter servidores próprios?"

**O que essa pergunta avalia:**
Avalia se o candidato entende o modelo financeiro da nuvem, como pay-as-you-go, e se consegue comparar com o modelo tradicional de CAPEX vs OPEX.

**Resposta esperada:**
A AWS funciona com o modelo **pay-as-you-go**: você paga apenas pelos recursos que utiliza, por segundo, minuto ou hora, dependendo do serviço. Não há investimento inicial em hardware (como comprar servidores). Os principais modelos de precificação incluem:

- **On-Demand**: Paga pelo tempo de uso sem compromisso. Mais flexível, mas mais caro por hora.
- **Reserved Instances**: Compromisso de uso por 1 ou 3 anos em troca de desconto significativo (até 72%).
- **Spot Instances**: Aproveita capacidade ociosa da AWS com desconto de até 90%, mas pode ser interrompido com aviso curto.
- **Savings Plans**: Compromisso de gasto por 1 ou 3 anos, com desconto em uso de computação.

A diferença fundamental em relação a servidores próprios é a troca de **CAPEX** (Capital Expenditure — investimento inicial em hardware) por **OPEX** (Operational Expenditure — custo operacional contínuo). Com servidores próprios, você investe grande valor inicial e ainda paga manutenção, energia, espaço e pessoal, independentemente de usar ou não a capacidade total. Na AWS, você paga proporcional ao uso real.

**Explicação didática:**
Comprar um servidor é como comprar um carro: você paga um valor alto inicial, seguro, manutenção e combustível, mesmo nos dias em que não dirige. A AWS é como um serviço de carros por demanda: você paga apenas pelas horas que dirige, sem se preocupar com manutenção ou seguro.

**Exemplo prático:**
Uma empresa que precisa de 10 servidores para um projeto de 3 meses:
- **On-premise**: Compra 10 servidores (R$ 100.000+), paga instalação e ao final do projeto os servidores ficam ociosos.
- **AWS On-Demand**: Provisiona 10 instâncias EC2, paga apenas as horas usadas durante os 3 meses e encerra. Sem investimento inicial.

**Como o candidato deve responder:**
- Explicar o conceito pay-as-you-go
- Mencionar pelo menos 2-3 modelos de precificação
- Diferenciar CAPEX de OPEX
- Citar o benefício de não ter investimento inicial
- Mencionar que o pay-as-you-go exige disciplina para evitar desperdício
- Evitar dizer que a nuvem é sempre mais barata — depende do uso correto

**Resposta fraca ou incompleta:**
"Você paga pelo que usa." — Correto, mas extremamente superficial. Falta explicar os modelos de precificação, a diferença CAPEX vs OPEX e os trade-offs.

**Critérios de avaliação:**
- 0 — Não sabe responder
- 1 — Sabe que "paga pelo que usa", mas nada mais
- 2 — Menciona um modelo de precificação além do On-Demand
- 3 — Explica pay-as-you-go e menciona 2-3 modelos de precificação
- 4 — Explica modelos, diferencia CAPEX/OPEX e dá exemplo prático
- 5 — Explica todos os pontos, discute trade-offs entre modelos e menciona riscos de custo

**Perguntas de aprofundamento:**
1. "Em qual situação você usaria Spot Instances em vez de On-Demand?"
2. "O que aconteceria se uma empresa migrasse tudo para AWS usando apenas On-Demand sem monitorar os custos?"
3. "Como o Reserved Instances pode ser vantajoso e qual é o risco?"

---

### Pergunta 8 — AWS Free Tier

**Nível:** Júnior
**Categoria:** Fundamentos / Billing

**Pergunta do entrevistador:**
"Você já ouviu falar do AWS Free Tier? Como ele funciona e quais cuidados você teria ao usá-lo?"

**O que essa pergunta avalia:**
Avalia se o candidato conhece o programa Free Tier da AWS, importante para iniciantes praticarem, e se entende as limitações e riscos de custos inesperados.

**Resposta esperada:**
O AWS Free Tier permite que novos usuários experimentem serviços da AWS gratuitamente, com limites. Existem três tipos:

1. **Free Trial (12 meses)**: Disponível por 12 meses após a criação da conta. Exemplo: 750 horas/mês de instâncias EC2 t2.micro (ou t3.micro em algumas regiões).
2. **Always Free**: Disponível indefinidamente para todos os clientes. Exemplo: 25 GB de DynamoDB, 1 milhão de requisições/mês no Lambda.
3. **Short-term trial**: Disponível por um curto período. Exemplo: 30 dias de Inspector.

Cuidados importantes:
- O Free Tier tem limites mensais: se exceder, paga o valor normal
- Nem todos os serviços têm Free Tier
- O Free Trial expira após 12 meses — após isso, os recursos passam a ser cobrados
- É fundamental configurar **alertas de billing** no CloudWatch para ser notificado antes de ultrapassar o limite
- Sempre encerrar (terminate) recursos que não estão em uso
- Apagar volumes EBS associados a instâncias EC2 encerradas, pois continuam sendo cobrados

**Explicação didática:**
O Free Tier é como uma amostra grátis em um supermercado: você pode experimentar alguns produtos sem pagar, mas se levar mais do que a amostra permitida, vai pagar pelo extra. E quando o período de promoção acaba, tudo passa a ter custo normal.

**Exemplo prático:**
Um estudante que cria uma conta AWS para aprender pode usar o EC2 t2.micro gratuitamente por 12 meses, com 750 horas por mês (suficiente para rodar uma instância 24/7). Mas se ele criar uma instância t3.large por engano, será cobrado pelo preço real, pois o Free Tier só cobre o t2.micro/t3.micro.

**Como o candidato deve responder:**
- Explicar que o Free Tier é para novos usuários experimentarem serviços
- Mencionar que existem limites e que o uso além disso é cobrado
- Citar os três tipos (12 meses, sempre grátis, trial curto)
- Mencionar a importância de configurar alertas de billing
- Citar o cuidado com recursos esquecidos (EBS, instâncias paradas)
- Evitar dizer que "tudo é grátis" ou que o Free Tier dura para sempre

**Resposta fraca ou incompleta:**
"A AWS dá 12 meses grátis." — Incompleto, pois nem tudo é grátis por 12 meses. Existe o Always Free e o short-term trial. Falta mencionar limites e cuidados com cobrança.

**Critérios de avaliação:**
- 0 — Não sabe responder
- 1 — Menciona que existe algo grátis, mas não explica
- 2 — Sabe que são 12 meses, mas não menciona limites
- 3 — Explica o Free Tier de 12 meses e menciona que há limites
- 4 — Explica os três tipos, menciona limites e alertas de billing
- 5 — Explica os três tipos, limites, cuidados e discute estratégias para evitar custos

**Perguntas de aprofundamento:**
1. "O que acontece se você ultrapassar o limite do Free Tier?"
2. "Como você configuraria um alerta para não ser surpreendido com cobranças?"
3. "Quais recursos podem continuar gerando custos mesmo depois que você 'para' uma instância EC2?"

---

### Pergunta 9 — Maneiras de interagir com a AWS

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
"Quais são as principais formas de interagir com os serviços da AWS? Você já utilizou alguma delas?"

**O que essa pergunta avalia:**
Avalia se o candidato conhece as formas de acesso e gerenciamento da AWS, o que indica familiaridade prática com a plataforma.

**Resposta esperada:**
Existem quatro formas principais de interagir com a AWS:

1. **AWS Management Console**: Interface web gráfica (acessada pelo navegador). É a forma mais fácil para iniciantes e para visualizar recursos, mas não é ideal para automação ou repetição de tarefas.

2. **AWS CLI (Command Line Interface)**: Ferramenta de linha de comando instalada localmente. Permite gerenciar serviços via terminal, scriptar operações e automatizar tarefas. Exemplo: `aws s3 ls` lista buckets do S3.

3. **AWS SDKs (Software Development Kits)**: Bibliotecas para linguagens de programação (Python/boto3, Java, JavaScript, Go, etc.) que permitem interagir com a AWS dentro de aplicações. Exemplo: um script Python que usa boto3 para listar instâncias EC2.

4. **AWS Infrastructure as Code (IaC)**: Ferramentas como **AWS CloudFormation** ou **Terraform** que permitem definir infraestrutura em arquivos de configuração (YAML/JSON ou HCL), garantindo reprodutibilidade e versionamento.

**Explicação didática:**
- O Console é como usar o mouse em uma interface gráfica — intuitivo, mas manual.
- A CLI é como usar atalhos de teclado — mais rápido e pode ser automatizado.
- Os SDKs são como integrar a AWS no código do seu aplicativo — programático.
- IaC é como escrever uma receita que qualquer um pode seguir para recriar a infraestrutura exatamente igual.

**Exemplo prático:**
```bash
# AWS CLI - Listar todos os buckets do S3
aws s3 ls

# AWS CLI - Criar um novo bucket
aws s3 mb s3://meu-novo-bucket-2024

# AWS CLI - Listar instâncias EC2 em execução
aws ec2 describe-instances --filters "Name=instance-state-name,Values=running"
```

```python
# AWS SDK (boto3) - Listar buckets do S3 em Python
import boto3

s3 = boto3.client('s3')
response = s3.list_buckets()

for bucket in response['Buckets']:
    print(f"Bucket: {bucket['Name']}")
```

**Como o candidato deve responder:**
- Listar as principais formas de interação (Console, CLI, SDK, IaC)
- Explicar quando usar cada uma
- Mencionar que o Console é bom para iniciantes, mas a CLI e SDK são melhores para automação
- Se possível, citar experiência prática (mesmo que seja laboratório ou estudo)
- Evitar dizer que só existe o Console

**Resposta fraca ou incompleta:**
"Eu uso o site da AWS para criar coisas." — Conhece apenas o Console. Não menciona CLI, SDK ou IaC, perdendo a visão de automação e programação.

**Critérios de avaliação:**
- 0 — Não sabe responder
- 1 — Menciona apenas o Console web
- 2 — Menciona Console e CLI
- 3 — Explica Console, CLI e SDK com exemplos de uso
- 4 — Explica as quatro formas, com prós e contras de cada uma
- 5 — Explica as quatro, dá exemplos práticos e discute quando usar cada uma

**Perguntas de aprofundamento:**
1. "Por que usar a CLI é melhor do que o Console para tarefas repetitivas?"
2. "O que é Infrastructure as Code e por que é importante?"
3. "Você já ouviu falar do AWS CloudShell? Como ele se compara à CLI instalada?"

---

### Pergunta 10 — Alta disponibilidade e Durabilidade

**Nível:** Júnior
**Categoria:** Fundamentos

**Pergunta do entrevistador:**
"A AWS fala muito sobre 'alta disponibilidade' e 'durabilidade'. Esses conceitos são a mesma coisa? Qual é a diferença?"

**O que essa pergunta avalia:**
Avalia se o candidato distingue dois conceitos fundamentais que frequentemente são confundidos, mas têm significados técnicos muito diferentes na arquitetura de sistemas em nuvem.

**Resposta esperada:**
Não, são conceitos diferentes:

- **Alta disponibilidade (High Availability)**: Refere-se à capacidade de um sistema permanecer acessível e funcional mesmo diante de falhas. Mede-se em "noves" — por exemplo, 99,99% de disponibilidade significa que o sistema fica indisponível por no máximo ~52 minutos por ano. Na AWS, alta disponibilidade é alcançada distribuindo recursos em múltiplas Zonas de Disponibilidade, usando Auto Scaling, Load Balancers e múltiplas instâncias.

- **Durabilidade**: Refere-se à probabilidade de os dados não serem perdidos ao longo do tempo. O Amazon S3, por exemplo, oferece durabilidade de 99,999999999% (onze noves), o que significa que se você armazenar 10 milhões de objetos, pode esperar perder um único objeto a cada 10.000 anos. A durabilidade é alcançada com replicação de dados em múltiplas AZs e verificação de integridade.

Resumindo: **disponibilidade** é sobre o sistema estar acessível; **durabilidade** é sobre os dados não serem perdidos.

**Explicação didática:**
Imagine um cofre em um banco:
- **Durabilidade** é a probabilidade de que o que você colocou no cofre ainda está lá quando voltar — o objeto não someu nem se deteriorou.
- **Disponibilidade** é a probabilidade de que o banco esteja aberto e o cofre acessível quando você precisar.

Um cofre pode ser extremamente durável (seu conteúdo nunca é perdido), mas se o banco estiver fechado no horário que você precisa, não há disponibilidade. Inversamente, um banco pode estar sempre aberto (alta disponibilidade), mas se o cofre for frágil e o conteúdo se deteriorar, não há durabilidade.

**Exemplo prático:**
- O **S3** tem altíssima durabilidade (11 noves) porque replica os dados em múltiplas AZs automaticamente, mas se a aplicação que acessa o S3 estiver em uma única AZ e essa AZ cair, o S3 continua guardando os dados (durabilidade), mas a aplicação não consegue acessá-los naquele momento (disponibilidade).
- Para garantir alta disponibilidade da aplicação, você deve distribuir instâncias EC2 em pelo menos duas AZs com um Load Balancer.

**Como o candidato deve responder:**
- Definir alta disponibilidade como capacidade do sistema permanecer acessível
- Definir durabilidade como capacidade de não perder dados
- Dar exemplos de serviços que oferecem cada um (S3 para durabilidade, Multi-AZ RDS para disponibilidade)
- Mencionar que são conceitos independentes
- Explicar como alcançar cada um na AWS (múltiplas AZs, replicação, Load Balancers)
- Evitar confundir os dois conceitos ou tratá-los como sinônimos

**Resposta fraca ou incompleta:**
"São a mesma coisa, significa que não cai." — Incorreto. São conceitos diferentes. Disponibilidade é sobre o sistema estar acessível; durabilidade é sobre os dados não serem perdidos. Um sistema pode ser durável mas não disponível, e vice-versa.

**Critérios de avaliação:**
- 0 — Não sabe responder ou confunde totalmente os conceitos
- 1 — Sabe que são diferentes, mas não explica corretamente
- 2 — Define um dos dois conceitos corretamente
- 3 — Define ambos corretamente, mas não dá exemplos
- 4 — Define ambos, dá exemplos e explica como alcançar cada um na AWS
- 5 — Define ambos com precisão, dá exemplos, explica trade-offs e relaciona com arquitetura

**Perguntas de aprofundamento:**
1. "Como você garantiria alta disponibilidade para uma aplicação web na AWS?"
2. "O que significa 'onze noves' de durabilidade no S3 e como a AWS alcança isso?"
3. "É possível ter alta durabilidade sem alta disponibilidade? Dê um exemplo."

---

> ✅ **Parte 1 concluída** — Perguntas 1 a 10 apresentadas (Fundamentos de Cloud Computing).
> 
> ⏳ **Próximas partes:**
> - Parte 2: Perguntas 11–15 (Fundamentos) + Perguntas 16–20 (EC2 e Computação)
> - Parte 3: Perguntas 21–27 (EC2 e Computação) + Perguntas 28–32 (S3 e Armazenamento)
> - Parte 4: Perguntas 33–39 (S3 e Armazenamento) + Perguntas 40–42 (IAM e Segurança)
> - Parte 5: Perguntas 43–51 (IAM e Segurança) + Perguntas 52–53 (VPC e Networking)
> - Parte 6: Perguntas 54–63 (VPC e Networking) + Perguntas 64–65 (RDS e Bancos de Dados)
> - Parte 7: Perguntas 66–73 (RDS e Bancos de Dados) + Perguntas 74–76 (Lambda e Serverless)
> - Parte 8: Perguntas 77–81 (Lambda e Serverless) + Perguntas 82–88 (CloudWatch e Monitoramento)
> - Parte 9: Perguntas 89–94 (Billing, Pricing e Support) + Perguntas 95–100 (Troubleshooting e Cenários)
> - Parte 10: Resumo final da entrevista

Diga **"continue"** para receber a próxima parte.