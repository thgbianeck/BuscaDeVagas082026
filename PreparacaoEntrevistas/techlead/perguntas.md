# Roteiro Completo de Entrevista — Tech Lead de um Time Java

## Preparação para liderança técnica, entrega de produto e engenharia de software

**Contexto tecnológico:** Java, Spring Boot, Git, CI/CD, testes, observabilidade, arquitetura, metodologias ágeis e operação de produtos digitais.

**Níveis abordados:** Júnior, Pleno e Sênior  
**Quantidade total planejada:** 100 perguntas  
**Perfil:** Misturado — conceitual, prático e baseado em cenários reais

> O objetivo deste roteiro não é avaliar apenas fundamentos da linguagem Java. O foco principal é preparar o candidato para atuar como Tech Lead de um time responsável por construir, entregar, operar e evoluir produtos utilizando Java e Spring Boot.

> As perguntas foram organizadas em partes para preservar a profundidade das respostas. O material completo possui 100 perguntas. Nesta parte são apresentadas as perguntas 1 a 10.

---

## Distribuição das perguntas

| Nível | Quantidade |
|---|---:|
| Júnior | 20 |
| Pleno | 35 |
| Sênior | 45 |
| **Total** | **100** |

## Distribuição temática planejada

| Tema | Quantidade aproximada |
|---|---:|
| Papel e responsabilidades do Tech Lead | 8 |
| Gestão técnica de produto e requisitos | 10 |
| Liderança, comunicação e desenvolvimento do time | 12 |
| Metodologias ágeis e planejamento | 10 |
| Java e Spring Boot aplicados ao produto | 12 |
| Arquitetura e decisões técnicas | 12 |
| Git, code review e colaboração | 8 |
| CI/CD e estratégia de entrega | 10 |
| Qualidade, testes e segurança | 8 |
| Operação, observabilidade e incidentes | 10 |
| **Total** | **100** |

## Fluxo de atuação do Tech Lead

~~~mermaid
flowchart TD
    A[Objetivos do produto] --> B[Descoberta e refinamento]
    B --> C[Priorização técnica]
    C --> D[Planejamento da entrega]
    D --> E[Desenvolvimento Java e Spring Boot]
    E --> F[Code review e testes]
    F --> G[CI/CD]
    G --> H[Implantação]
    H --> I[Observabilidade]
    I --> J[Feedback do produto]
    J --> B

    K[Liderança técnica] --> B
    K --> D
    K --> E
    K --> F
    K --> G
    K --> H
    K --> I
~~~

---

# Parte 1 de 10 — Perguntas 1 a 10

## Pergunta 1 — Definição do papel de Tech Lead

**Nível:** Júnior  
**Categoria:** Liderança técnica

**Pergunta do entrevistador:**  

Como você define o papel de um Tech Lead em um time que desenvolve produtos utilizando Java e Spring Boot? Quais responsabilidades considera essenciais e quais responsabilidades não deveriam ficar concentradas exclusivamente nessa pessoa?

**O que essa pergunta avalia:**  

Avalia se o candidato entende que o Tech Lead não é apenas o desenvolvedor mais experiente ou a pessoa responsável por aprovar todos os pull requests. Também verifica a compreensão sobre liderança técnica, entrega de produto, autonomia do time e distribuição de responsabilidades.

**Resposta esperada:**  

O Tech Lead é responsável por orientar tecnicamente o time e ajudar a garantir que o produto seja desenvolvido e entregue com qualidade, segurança, manutenibilidade e alinhamento aos objetivos do negócio.

Entre suas responsabilidades estão:

- Participar da definição e evolução da arquitetura;
- Apoiar o refinamento de requisitos;
- Identificar riscos técnicos e dependências;
- Orientar boas práticas de desenvolvimento;
- Estabelecer padrões para APIs, integrações, testes e observabilidade;
- Apoiar decisões envolvendo Java, Spring Boot, bancos de dados e infraestrutura;
- Promover revisão colaborativa de código;
- Ajudar o time a planejar e entregar incrementos;
- Apoiar a investigação de incidentes;
- Melhorar o processo de desenvolvimento;
- Desenvolver tecnicamente os integrantes do time;
- Comunicar riscos, alternativas e impactos para produto e liderança.

O Tech Lead não deve centralizar todo o conhecimento, revisar absolutamente todo o código ou tomar todas as decisões sozinho. Uma de suas principais responsabilidades é tornar o time mais autônomo e capaz de tomar boas decisões técnicas.

**Explicação didática:**  

Liderança técnica é uma função de influência, direção e facilitação. Embora o Tech Lead possa continuar escrevendo código, seu impacto não deve ser medido apenas pela quantidade de linhas implementadas.

Em um time Java com Spring Boot, por exemplo, o Tech Lead pode ajudar a definir:

- Padrões para criação de APIs;
- Estratégia de tratamento de erros;
- Forma de escrever testes;
- Regras de observabilidade;
- Critérios de segurança;
- Estratégia de implantação;
- Convenções de integração entre serviços.

Porém, essas decisões devem ser compartilhadas sempre que possível. O Tech Lead deve criar contexto, explicar os motivos das decisões e permitir que outras pessoas assumam responsabilidades.

Um Tech Lead que concentra todas as decisões pode parecer eficiente no início, mas tende a se tornar um gargalo e um ponto único de falha para o time.

**Exemplo prático:**  

Durante a criação de uma nova funcionalidade de pedidos, o Tech Lead pode conduzir uma discussão sobre:

- Contrato da API;
- Regras de autorização;
- Persistência dos dados;
- Integrações necessárias;
- Tratamento de indisponibilidade;
- Testes automatizados;
- Métricas e logs;
- Estratégia de implantação.

Após a decisão, a implementação pode ser distribuída entre diferentes integrantes do time.

**Exemplo de código:**  

Não se aplica diretamente. A pergunta avalia visão de responsabilidade e liderança, não implementação de código.

**Como o candidato deve responder:**  

O candidato deve:

- Definir o Tech Lead como uma liderança técnica, não apenas como um programador sênior;
- Relacionar tecnologia, negócio, qualidade e operação;
- Explicar que o Tech Lead participa da entrega completa;
- Demonstrar preocupação com autonomia do time;
- Explicar como evitar a concentração de conhecimento;
- Apresentar um exemplo de decisão técnica conduzida de forma colaborativa.

Deve evitar respostas como:

- “O Tech Lead é quem sabe mais Java”;
- “O Tech Lead aprova tudo”;
- “O Tech Lead resolve todos os problemas”;
- “O Tech Lead é o chefe dos desenvolvedores”.

**Resposta fraca ou incompleta:**  

“O Tech Lead é o desenvolvedor mais experiente. Ele define a arquitetura, revisa o código e ajuda os outros desenvolvedores quando eles têm dúvidas.”

Essa resposta reconhece algumas atividades, mas ignora aspectos importantes como produto, riscos, operação, comunicação, desenvolvimento do time e distribuição de responsabilidades.

**Critérios de avaliação:**  

- **0** — Não consegue explicar o papel de um Tech Lead.
- **1** — Define o Tech Lead apenas como o programador mais experiente.
- **2** — Menciona arquitetura e revisão de código, mas não aborda entrega ou autonomia.
- **3** — Explica corretamente as responsabilidades básicas.
- **4** — Relaciona liderança, produto, qualidade, operação e desenvolvimento do time.
- **5** — Demonstra visão sistêmica, apresenta exemplos e explica como evitar gargalos e centralização de conhecimento.

**Perguntas de aprofundamento:**  

1. Como você evitaria se tornar um gargalo para todas as decisões técnicas?
2. Em quais situações você tomaria uma decisão diretamente em vez de buscar consenso?
3. Como avaliaria se o time está se tornando mais autônomo?

---

## Pergunta 2 — Responsabilidade sobre a entrega do produto

**Nível:** Júnior  
**Categoria:** Entrega de produto

**Pergunta do entrevistador:**  

O que significa, na prática, dizer que um Tech Lead deve se preocupar com a entrega completa de uma funcionalidade, e não apenas com a implementação do código?

**O que essa pergunta avalia:**  

Avalia se o candidato compreende que uma funcionalidade só está realmente entregue quando pode ser utilizada pelos usuários com segurança, qualidade e capacidade de operação.

**Resposta esperada:**  

A entrega completa envolve mais do que escrever e revisar o código. O Tech Lead deve ajudar o time a considerar todo o ciclo de vida da funcionalidade:

- Entendimento do problema do usuário;
- Critérios de aceite;
- Impactos arquiteturais;
- Alterações no banco de dados;
- Integrações com outros sistemas;
- Testes automatizados;
- Segurança;
- Logs e métricas;
- Documentação;
- Configuração dos ambientes;
- Pipeline de CI/CD;
- Estratégia de implantação;
- Rollback;
- Monitoramento após a publicação;
- Validação do resultado do ponto de vista do negócio.

Uma funcionalidade não deveria ser considerada concluída apenas porque o código foi integrado à branch principal.

**Explicação didática:**  

Em produtos digitais, existe uma diferença entre “código implementado” e “valor entregue”.

Por exemplo, uma nova API de consulta de pedidos pode estar tecnicamente pronta, mas ainda não estar entregue se:

- O endpoint não estiver protegido;
- O banco não possuir o índice necessário;
- O pipeline não executar os testes;
- O ambiente de homologação estiver configurado incorretamente;
- Não houver logs para investigar falhas;
- O consumidor não conhecer o contrato;
- O recurso não puder ser desativado em caso de problema.

O Tech Lead deve ajudar o time a enxergar o caminho completo entre a necessidade do usuário e o uso real da solução em produção.

**Exemplo prático:**  

Para entregar uma funcionalidade de cancelamento de pedido, o time pode precisar:

1. Validar as regras com produto;
2. Definir quais pedidos podem ser cancelados;
3. Alterar o domínio da aplicação;
4. Criar ou adaptar endpoints;
5. Atualizar o banco;
6. Integrar com pagamento ou logística;
7. Criar testes;
8. Adicionar métricas;
9. Configurar alertas;
10. Implantar gradualmente;
11. Validar o comportamento após o deploy.

**Exemplo de código:**  

Uma configuração de feature flag pode ser utilizada para liberar o recurso gradualmente:

~~~java
@Component
public class CancelamentoPedidoService {

    private final boolean cancelamentoHabilitado;

    public CancelamentoPedidoService(
            @Value("${features.cancelamento-pedido:false}")
            boolean cancelamentoHabilitado) {
        this.cancelamentoHabilitado = cancelamentoHabilitado;
    }

    public void cancelar(Pedido pedido) {
        if (!cancelamentoHabilitado) {
            throw new FuncionalidadeIndisponivelException(
                    "Cancelamento temporariamente indisponível");
        }

        // Aplicação das regras de cancelamento.
        pedido.cancelar();
    }
}
~~~

Esse recurso pode reduzir o risco de uma implantação, mas uma feature flag também precisa ser monitorada, documentada e removida quando deixar de ser necessária.

**Como o candidato deve responder:**  

O candidato deve:

- Diferenciar implementação de entrega;
- Mencionar testes, segurança e operação;
- Falar sobre configuração de ambientes;
- Explicar a importância de observabilidade;
- Considerar rollback ou desativação;
- Relacionar a entrega com o resultado esperado pelo usuário.

Deve evitar responder apenas:

> “Depois que o código passa na revisão, fazemos o deploy.”

**Resposta fraca ou incompleta:**  

“Significa garantir que o código esteja correto e fazer o deploy no ambiente de produção.”

Essa resposta não considera requisitos, testes, segurança, monitoramento, documentação ou validação do resultado.

**Critérios de avaliação:**  

- **0** — Entende entrega apenas como escrever código.
- **1** — Menciona somente revisão e deploy.
- **2** — Reconhece a necessidade de testes, mas ignora operação.
- **3** — Explica que a entrega inclui código, testes e implantação.
- **4** — Considera segurança, observabilidade, configuração e rollback.
- **5** — Demonstra visão completa do ciclo de vida e conecta entrega técnica a valor de produto.

**Perguntas de aprofundamento:**  

1. Como você saberia que a funcionalidade foi bem-sucedida após o deploy?
2. Que informações deveriam estar disponíveis para operar a funcionalidade?
3. Como faria uma liberação gradual para reduzir riscos?

---

## Pergunta 3 — Transformação de requisito em solução técnica

**Nível:** Júnior  
**Categoria:** Análise e refinamento

**Pergunta do entrevistador:**  

Você recebe a seguinte demanda: “Permitir que o cliente acompanhe o status do pedido”. Como você ajudaria o time a transformar essa descrição em uma solução técnica implementável?

**O que essa pergunta avalia:**  

Avalia a capacidade de compreender o problema antes de propor código, identificar dúvidas, decompor uma demanda e colaborar com produto e negócio.

**Resposta esperada:**  

Eu não começaria imediatamente criando um controller em Spring Boot. Primeiro buscaria entender o objetivo e as regras do produto.

Algumas perguntas importantes seriam:

- Quais status existem?
- Quem pode consultar o pedido?
- O cliente pode consultar qualquer pedido?
- Qual é a fonte oficial do status?
- O status é atualizado em tempo real?
- Existe atraso aceitável?
- A informação vem do banco local ou de outro sistema?
- O histórico de status também será exibido?
- O que acontece se o pedido não existir?
- Como tratar uma integração indisponível?
- Quais canais utilizarão essa informação?
- Existem requisitos de desempenho?
- Como o resultado será medido?

Depois, eu ajudaria a decompor a demanda em partes menores:

1. Definição das regras de negócio;
2. Modelo de status;
3. Consulta do pedido;
4. Autorização;
5. API;
6. Integração com sistemas externos;
7. Testes;
8. Observabilidade;
9. Documentação;
10. Implantação.

**Explicação didática:**  

Uma frase de negócio não é necessariamente uma especificação técnica. A mesma demanda pode gerar soluções muito diferentes.

“Acompanhar o status” pode significar:

- Uma consulta manual;
- Atualização automática na tela;
- Notificação por evento;
- Consulta a um sistema externo;
- Atualização a cada poucos minutos;
- Histórico completo das transições.

Cada alternativa possui custos, riscos e requisitos diferentes.

O papel do Tech Lead é ajudar o time a descobrir essas decisões antes que elas apareçam como problemas durante a implementação.

**Exemplo prático:**  

Uma primeira versão poderia disponibilizar:

~~~text
GET /pedidos/{pedidoId}/status
~~~

Entretanto, ainda seria necessário decidir:

- Como autenticar o consumidor;
- Como verificar se ele tem acesso ao pedido;
- Se a resposta conterá apenas o status atual;
- Como representar status desconhecido;
- Como tratar falhas da fonte de dados;
- Se haverá cache;
- Qual será o tempo máximo de resposta.

**Exemplo de código:**  

Um possível contrato de resposta poderia ser:

~~~java
public record StatusPedidoResponse(
        String pedidoId,
        String status,
        Instant atualizadoEm
) {
}
~~~

Esse código representa somente o contrato de saída. Ele não resolve autorização, consistência, integração ou disponibilidade.

**Como o candidato deve responder:**  

O candidato deve:

- Demonstrar que não começaria pela implementação;
- Fazer perguntas de negócio e técnicas;
- Explicar como decomporia a demanda;
- Considerar segurança, integração, desempenho e testes;
- Validar o entendimento com produto;
- Diferenciar requisito de decisão de implementação.

Deve evitar assumir detalhes não informados, como:

- Uso obrigatório de REST;
- Atualização em tempo real;
- Banco relacional;
- Arquitetura de microsserviços;
- Existência de um único sistema responsável pelo status.

**Resposta fraca ou incompleta:**  

“Eu criaria um endpoint GET em Spring Boot, buscaria o pedido no banco e retornaria o status.”

A resposta pula a análise das regras, autorização, origem dos dados, integração, erros, desempenho e critérios de sucesso.

**Critérios de avaliação:**  

- **0** — Não sabe analisar uma demanda.
- **1** — Parte diretamente para escrever código.
- **2** — Identifica poucas dúvidas, mas não estrutura a solução.
- **3** — Demonstra abordagem básica de refinamento.
- **4** — Considera requisitos, riscos, segurança, testes e operação.
- **5** — Conecta o problema do usuário a uma solução incremental, mensurável e tecnicamente sustentável.

**Perguntas de aprofundamento:**  

1. Como decidiria entre consulta sob demanda, polling e eventos?
2. Como trataria a indisponibilidade do sistema que fornece o status?
3. Como verificaria se a solução realmente resolveu o problema do usuário?

---

## Pergunta 4 — Refinamento técnico em uma metodologia ágil

**Nível:** Júnior  
**Categoria:** Métodos ágeis e planejamento

**Pergunta do entrevistador:**  

Como você participaria de uma sessão de refinamento técnico sem transformar a reunião em uma especificação excessivamente detalhada ou em uma discussão interminável?

**O que essa pergunta avalia:**  

Avalia compreensão sobre refinamento ágil, identificação de riscos, comunicação com produto e equilíbrio entre preparação e agilidade.

**Resposta esperada:**  

O refinamento deve gerar entendimento suficiente para que o time consiga estimar, implementar e validar a demanda com um nível aceitável de segurança.

Eu concentraria a discussão em:

- Objetivo da história;
- Critérios de aceite;
- Escopo;
- Fora do escopo;
- Dependências;
- Riscos relevantes;
- Impactos técnicos;
- Necessidade de alterações em APIs ou banco;
- Integrações;
- Segurança;
- Testes;
- Observabilidade;
- Estratégia de entrega.

Nem toda incerteza precisa ser resolvida durante a reunião. Quando uma dúvida for relevante, mas não houver informação suficiente, eu proporia uma ação objetiva, como:

- Criar um spike técnico;
- Fazer uma investigação com prazo limitado;
- Consultar outro time;
- Validar a regra com o negócio;
- Testar uma integração;
- Registrar a decisão pendente.

O objetivo é reduzir riscos e preparar o próximo incremento, não tentar prever todos os detalhes futuros.

**Explicação didática:**  

Em uma abordagem ágil, o time aprende ao longo da execução. Portanto, o planejamento precisa ser suficiente para orientar a próxima decisão, mas não precisa produzir uma especificação definitiva para todas as situações futuras.

Por exemplo, antes de criar uma API Spring Boot, pode ser necessário definir:

- Contrato principal;
- Dados obrigatórios;
- Códigos de erro;
- Regras de autorização;
- Critérios de aceite.

Talvez não seja necessário definir naquele momento todos os detalhes de uma arquitetura que ainda não será implementada.

**Exemplo prático:**  

Se uma história depende de uma API de pagamento desconhecida, o time pode registrar:

- Dados já confirmados;
- Informações ainda desconhecidas;
- Possíveis erros;
- Timeout esperado;
- Necessidade de idempotência;
- Responsável pela validação;
- Prazo do spike técnico.

Em vez de discutir indefinidamente, o time transforma a incerteza em uma atividade concreta.

**Exemplo de código:**  

Não é necessário código. O principal resultado esperado é um entendimento comum sobre o problema, os riscos e os próximos passos.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar o objetivo do refinamento;
- Mostrar que nem todos os detalhes precisam ser definidos;
- Mencionar critérios de aceite e riscos;
- Diferenciar investigação de implementação;
- Mostrar preocupação com o tempo do time;
- Explicar como registraria dúvidas e decisões.

Deve evitar afirmar que uma história só pode começar quando nenhuma dúvida existir.

**Resposta fraca ou incompleta:**  

“No refinamento precisamos detalhar toda a implementação, dividir todas as tarefas e eliminar todas as dúvidas antes de iniciar o desenvolvimento.”

Essa resposta transforma o refinamento em uma especificação completa e não considera a natureza incremental do desenvolvimento ágil.

**Critérios de avaliação:**  

- **0** — Não demonstra entendimento do refinamento.
- **1** — Confunde refinamento com documentação completa.
- **2** — Menciona estimativas, mas não considera riscos.
- **3** — Explica o objetivo básico do refinamento.
- **4** — Equilibra preparação, riscos, escopo e agilidade.
- **5** — Propõe mecanismos objetivos para tratar incertezas sem criar burocracia.

**Perguntas de aprofundamento:**  

1. Quando você criaria um spike técnico?
2. Como saberia que uma história está pronta para desenvolvimento?
3. O que faria se produto e engenharia tivessem interpretações diferentes sobre o critério de aceite?

---

## Pergunta 5 — Priorização de dívida técnica

**Nível:** Júnior  
**Categoria:** Priorização e qualidade

**Pergunta do entrevistador:**  

O time possui novas funcionalidades solicitadas pelo negócio, mas também acumulou problemas técnicos em uma aplicação Spring Boot, como testes frágeis, logs insuficientes, dependências desatualizadas e consultas lentas. Como você argumentaria pela priorização desses problemas?

**O que essa pergunta avalia:**  

Avalia se o candidato consegue explicar dívida técnica em termos de risco e impacto para o produto, sem defender refatorações de maneira abstrata.

**Resposta esperada:**  

Eu não apresentaria a dívida técnica apenas como “código ruim” ou “necessidade de refatoração”. Relacionaria cada problema a impactos concretos:

- Aumento de incidentes;
- Maior tempo para corrigir problemas;
- Dificuldade de diagnóstico;
- Risco de vulnerabilidades;
- Lentidão percebida pelo cliente;
- Aumento do custo de infraestrutura;
- Maior chance de regressões;
- Redução da velocidade de entrega;
- Dependência excessiva de poucas pessoas.

Em seguida, classificaria os itens considerando:

- Impacto;
- Urgência;
- Probabilidade;
- Esforço;
- Dependências;
- Risco para o negócio.

Uma dependência com vulnerabilidade crítica pode ter prioridade imediata. Uma consulta lenta que afeta uma operação importante também pode ser tratada como problema de produto ou operação.

Já melhorias menos urgentes poderiam ser incorporadas gradualmente às histórias que alteram as áreas afetadas.

**Explicação didática:**  

Dívida técnica é uma decisão ou consequência que torna mudanças futuras mais caras, lentas ou arriscadas. Ela não precisa ser eliminada toda de uma vez, mas deve ser conhecida e administrada.

O Tech Lead deve evitar dois extremos:

- Ignorar problemas técnicos até ocorrer um incidente;
- Paralisar o produto para reescrever todo o sistema.

A abordagem mais saudável costuma ser baseada em risco, evidências e melhoria incremental.

**Exemplo prático:**  

Em vez de apresentar a demanda assim:

> “Precisamos refatorar a camada de pedidos.”

Seria mais útil apresentar:

> “A API de pedidos apresenta alta taxa de regressão e demora para diagnóstico. Propomos adicionar testes dos fluxos críticos, logs estruturados e métricas de erro nas áreas que serão alteradas nesta entrega.”

Essa formulação conecta a melhoria técnica ao resultado do produto.

**Exemplo de código:**  

Um log estruturado pode auxiliar na investigação:

~~~java
log.warn(
        "Falha ao processar pedido. pedidoId={}, provedor={}, codigoErro={}",
        pedidoId,
        provedor,
        codigoErro
);
~~~

O log não deve conter dados sensíveis, como senha, token, cartão, documento completo ou informações pessoais desnecessárias.

**Como o candidato deve responder:**  

O candidato deve:

- Relacionar dívida técnica a impacto;
- Usar dados e evidências;
- Falar sobre risco e priorização;
- Evitar defender uma reescrita indiscriminada;
- Considerar segurança, observabilidade e desempenho;
- Explicar como reduzir dívida dentro do trabalho normal do time.

Deve evitar afirmar que toda dívida técnica deve ser resolvida imediatamente ou que qualidade sempre deve suspender novas funcionalidades.

**Resposta fraca ou incompleta:**  

“Eu explicaria que precisamos parar todas as entregas e refatorar o projeto inteiro.”

Essa abordagem ignora custo, prazo, risco de reescrita e necessidade de priorização.

**Critérios de avaliação:**  

- **0** — Não reconhece a importância da dívida técnica.
- **1** — Ignora o problema ou defende apenas uma reescrita total.
- **2** — Reconhece a dívida, mas não sabe priorizá-la.
- **3** — Relaciona dívida técnica a manutenção e qualidade.
- **4** — Usa impacto, risco e evidências para priorizar.
- **5** — Propõe uma estratégia incremental, mensurável e equilibrada com a entrega de produto.

**Perguntas de aprofundamento:**  

1. Como convenceria o negócio a priorizar uma melhoria técnica?
2. Quais métricas mostrariam que a dívida está prejudicando o time?
3. Em que situação uma reescrita seria justificável?

---

## Pergunta 6 — Estratégia de branches e integração com Git

**Nível:** Pleno  
**Categoria:** Git e colaboração

**Pergunta do entrevistador:**  

Você assumiu um time Java que utiliza branches longas, possui muitos conflitos de merge e só integra as mudanças no final da sprint. Como avaliaria o problema e que estratégia proporia?

**O que essa pergunta avalia:**  

Avalia domínio prático de Git, integração contínua, revisão de código e capacidade de evoluir o processo de colaboração do time.

**Resposta esperada:**  

Eu começaria entendendo o fluxo atual e seus efeitos:

- Tempo médio de vida das branches;
- Frequência dos conflitos;
- Tamanho dos pull requests;
- Tempo de revisão;
- Frequência de falhas após merge;
- Tempo entre implementação e integração;
- Cobertura e confiabilidade dos testes;
- Dependências entre histórias;
- Uso de feature flags;
- Capacidade do pipeline.

Em muitos contextos, proporia branches curtas integradas frequentemente à branch principal. Também adotaria:

- Pull requests pequenos;
- Revisões com objetivo claro;
- Pipeline obrigatório antes do merge;
- Testes automatizados;
- Commits coerentes;
- Resolução rápida de conflitos;
- Regras de proteção da branch principal;
- Estratégia de rollback;
- Feature flags para funcionalidades incompletas.

Trunk-based development pode ser uma boa alternativa, mas não deve ser adotado apenas como uma regra. Ele exige testes confiáveis, automação e disciplina de integração.

O objetivo principal é reduzir o tamanho dos lotes, diminuir divergências e tornar as mudanças mais fáceis de revisar, testar e reverter.

**Explicação didática:**  

Branches longas permitem que diferentes versões do código se afastem por muito tempo. Quando ocorre a integração, os conflitos podem ser difíceis de resolver e os testes podem não cobrir corretamente a combinação final.

Branches curtas reduzem esse risco. Uma funcionalidade que ainda não pode ser exibida ao usuário pode ser integrada atrás de uma feature flag.

A estratégia escolhida deve levar em conta a maturidade do time, a qualidade do pipeline, o modelo de release e os riscos do produto.

**Exemplo prático:**  

Um fluxo possível seria:

1. Criar uma branch curta;
2. Implementar uma mudança pequena;
3. Executar validações locais;
4. Abrir um pull request;
5. Executar o pipeline;
6. Realizar revisão;
7. Integrar na branch principal;
8. Implantar em ambiente controlado;
9. Monitorar;
10. Liberar gradualmente, se necessário.

**Exemplo de código:**  

Uma implementação simples de feature flag poderia ser:

~~~java
@Service
public class PedidoService {

    private final boolean novoFluxoAtivo;

    public PedidoService(
            @Value("${features.novo-fluxo-pedido:false}")
            boolean novoFluxoAtivo) {
        this.novoFluxoAtivo = novoFluxoAtivo;
    }

    public Resultado processar(Pedido pedido) {
        if (novoFluxoAtivo) {
            return processarComNovoFluxo(pedido);
        }

        return processarComFluxoAtual(pedido);
    }

    private Resultado processarComNovoFluxo(Pedido pedido) {
        // Novo comportamento.
        return Resultado.sucesso();
    }

    private Resultado processarComFluxoAtual(Pedido pedido) {
        // Comportamento existente.
        return Resultado.sucesso();
    }
}
~~~

Em uma solução real, a feature flag deve ter responsável, auditoria, controle de acesso, monitoramento e data prevista para remoção.

**Como o candidato deve responder:**  

O candidato deve:

- Investigar o fluxo atual antes de impor uma mudança;
- Relacionar branches curtas a integração contínua;
- Explicar o papel de testes e automação;
- Mencionar pull requests pequenos;
- Considerar feature flags;
- Falar sobre métricas de melhoria;
- Demonstrar que Git Flow e trunk-based development não são soluções universais.

**Resposta fraca ou incompleta:**  

“Eu proibiria branches longas e obrigaria todo mundo a usar trunk-based development.”

Essa resposta é prescritiva e não considera causas, maturidade, cobertura de testes ou riscos do produto.

**Critérios de avaliação:**  

- **0** — Não conhece práticas básicas de colaboração com Git.
- **1** — Sugere apenas criar ou excluir branches.
- **2** — Conhece pull requests, mas não relaciona o fluxo à integração contínua.
- **3** — Propõe branches menores, revisão e validação automatizada.
- **4** — Considera contexto, métricas, feature flags e rollback.
- **5** — Demonstra capacidade de evoluir o fluxo de forma incremental, reduzindo o tamanho dos lotes e os riscos de integração.

**Perguntas de aprofundamento:**  

1. Em quais situações uma branch longa ainda poderia ser aceitável?
2. Como lidaria com uma funcionalidade que precisa de várias semanas de desenvolvimento?
3. Quais indicadores mostrariam que o novo fluxo de Git está funcionando?

---

## Pergunta 7 — Qualidade de um pull request

**Nível:** Pleno  
**Categoria:** Code review e qualidade

**Pergunta do entrevistador:**  

Quais aspectos você avaliaria ao revisar um pull request de uma nova funcionalidade em Spring Boot, além de verificar se o código compila?

**O que essa pergunta avalia:**  

Avalia a capacidade de realizar revisão de código com foco em comportamento, manutenção, segurança, testes e impacto operacional.

**Resposta esperada:**  

Eu avaliaria o pull request considerando o objetivo da mudança e seus possíveis impactos.

Os principais pontos seriam:

- Se a implementação atende aos critérios de aceite;
- Se o desenho está coerente com o domínio;
- Se as responsabilidades estão bem distribuídas;
- Se os nomes são claros;
- Se o código é simples e legível;
- Se há duplicação desnecessária;
- Se o tratamento de erros é adequado;
- Se há riscos de vazamento de dados;
- Se a autorização está correta;
- Se os testes cobrem cenários relevantes;
- Se há alterações de banco;
- Se as migrações são seguras;
- Se há impactos de desempenho;
- Se logs e métricas são suficientes;
- Se a compatibilidade com consumidores foi preservada;
- Se a alteração pode ser implantada e revertida com segurança.

Também verificaria se o tamanho do pull request permite uma revisão efetiva. Pull requests muito grandes aumentam a chance de problemas passarem despercebidos.

**Explicação didática:**  

Code review não deve ser uma disputa de estilo ou uma busca por preferências pessoais. O objetivo é aumentar a qualidade da mudança e compartilhar conhecimento.

Uma boa revisão combina:

- Automatização para formatação e regras simples;
- Revisão humana para comportamento, design, riscos e contexto;
- Discussões respeitosas;
- Critérios claros para bloquear ou aprovar uma alteração.

O Tech Lead deve diferenciar problemas críticos de sugestões de melhoria. Nem toda preferência pessoal deve impedir a entrega.

**Exemplo prático:**  

Ao revisar um endpoint de atualização de pedido, eu verificaria:

- Se o usuário autenticado pode alterar aquele pedido;
- Se a operação é idempotente quando necessário;
- Se o estado atual permite a alteração;
- Se erros possuem respostas consistentes;
- Se há testes para concorrência;
- Se a alteração é auditável;
- Se não há exposição de informações internas;
- Se existe métrica para falhas da operação.

**Exemplo de código:**  

Um controller deve delegar regras de negócio para uma camada apropriada:

~~~java
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PutMapping("/{id}/cancelamento")
    public ResponseEntity<Void> cancelar(
            @PathVariable Long id,
            Authentication authentication) {

        pedidoService.cancelar(id, authentication.getName());

        return ResponseEntity.noContent().build();
    }
}
~~~

O controller não deveria conter toda a regra de cancelamento, autorização, persistência e integração externa.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar que revisão não é apenas verificar compilação;
- Considerar comportamento e critérios de aceite;
- Falar sobre testes;
- Incluir segurança e autorização;
- Considerar banco, desempenho e operação;
- Diferenciar bloqueios reais de sugestões;
- Mostrar postura respeitosa e colaborativa.

Deve evitar transformar a revisão em:

- Debate de gosto pessoal;
- Aprovação automática;
- Busca por perfeição fora do escopo;
- Forma de controle centralizado.

**Resposta fraca ou incompleta:**  

“Eu verificaria se o código segue o padrão do projeto, se compila e se os nomes das variáveis estão corretos.”

Essa resposta é limitada e não aborda comportamento, segurança, testes, banco ou operação.

**Critérios de avaliação:**  

- **0** — Não sabe explicar como revisar código.
- **1** — Foca apenas em estilo ou compilação.
- **2** — Menciona legibilidade e testes, mas ignora riscos importantes.
- **3** — Avalia comportamento, estrutura e testes básicos.
- **4** — Considera segurança, desempenho, banco, operação e manutenção.
- **5** — Demonstra processo maduro, automatiza verificações simples e usa revisão humana para decisões de maior impacto.

**Perguntas de aprofundamento:**  

1. O que faria se o pull request tivesse mais de mil linhas?
2. Quando uma sugestão de melhoria deveria bloquear o merge?
3. Como lidaria com uma discordância técnica durante a revisão?

---

## Pergunta 8 — Desenho de um pipeline de CI/CD

**Nível:** Pleno  
**Categoria:** CI/CD e entrega

**Pergunta do entrevistador:**  

Como você desenharia um pipeline de CI/CD para uma aplicação Spring Boot que precisa ser entregue com frequência e segurança?

**O que essa pergunta avalia:**  

Avalia compreensão sobre integração contínua, entrega contínua, qualidade automatizada, segurança da cadeia de entrega e estratégias de promoção entre ambientes.

**Resposta esperada:**  

Um pipeline poderia conter as seguintes etapas:

1. Validação do código;
2. Compilação;
3. Testes unitários;
4. Análise estática;
5. Verificação de dependências;
6. Verificação de vulnerabilidades;
7. Testes de integração;
8. Testes de contrato, quando aplicável;
9. Empacotamento;
10. Geração de um artefato imutável;
11. Publicação do artefato;
12. Implantação em ambiente de validação;
13. Smoke tests;
14. Testes de segurança complementares;
15. Promoção para produção;
16. Verificações pós-deploy;
17. Monitoramento;
18. Rollback ou desativação controlada.

As validações rápidas devem fornecer feedback cedo. Os testes mais demorados podem ocorrer em etapas posteriores, sem deixar de proteger os pontos críticos.

O mesmo artefato validado deve ser promovido entre os ambientes. Não é recomendável recompilar um artefato diferente para produção, pois isso pode gerar divergência entre o que foi testado e o que foi implantado.

Também devem ser protegidos:

- Segredos;
- Credenciais;
- Permissões;
- Acesso à produção;
- Imagens;
- Dependências;
- Logs;
- Artefatos;
- Configurações do pipeline.

**Explicação didática:**  

CI significa integrar alterações frequentemente e validá-las automaticamente.

CD pode representar:

- **Entrega contínua:** o sistema está sempre pronto para ser implantado;
- **Implantação contínua:** alterações aprovadas são implantadas automaticamente sob condições definidas.

O pipeline deve reduzir riscos, não apenas automatizar comandos.

Uma aplicação pode compilar corretamente e ainda falhar por:

- Configuração incorreta;
- Variável de ambiente ausente;
- Migração de banco incompatível;
- Dependência indisponível;
- Timeout;
- Problemas de permissão;
- Diferença entre ambientes;
- Falha em integração externa.

**Exemplo prático:**  

~~~mermaid
flowchart LR
    A[Pull request] --> B[Build]
    B --> C[Testes unitários]
    C --> D[Análise estática]
    D --> E[Segurança]
    E --> F[Testes de integração]
    F --> G[Gerar artefato]
    G --> H[Ambiente de validação]
    H --> I[Smoke tests]
    I --> J[Produção]
    J --> K[Monitoramento]
    K --> L[Rollback se necessário]
~~~

**Exemplo de código:**  

Uma definição conceitual poderia ser:

~~~yaml
stages:
  - validate
  - test
  - security
  - package
  - deploy

validate:
  script:
    - ./mvnw verify -DskipTests

test:
  script:
    - ./mvnw test

security:
  script:
    - ./mvnw dependency-check:check

package:
  script:
    - ./mvnw package

deploy:
  script:
    - ./deploy.sh
  when: manual
~~~

O formato real depende da plataforma utilizada. Em uma implementação de produção, ainda seriam necessários controles de ambientes, artefatos, credenciais, aprovações, auditoria e rollback.

**Como o candidato deve responder:**  

O candidato deve:

- Organizar o pipeline por etapas;
- Diferenciar feedback rápido de validações mais lentas;
- Explicar o uso do mesmo artefato entre ambientes;
- Mencionar testes, segurança e observabilidade;
- Abordar secrets e permissões;
- Explicar estratégias de rollback;
- Considerar o nível de risco do produto.

Deve evitar reduzir CI/CD a:

> “Rodar os testes, gerar o JAR e fazer deploy.”

**Resposta fraca ou incompleta:**  

“O pipeline deve compilar o projeto, rodar os testes, gerar o JAR e publicar no servidor.”

Essa resposta não trata segurança, testes de integração, artefatos imutáveis, ambientes, validação pós-deploy ou recuperação de falhas.

**Critérios de avaliação:**  

- **0** — Não conhece o propósito de CI/CD.
- **1** — Limita CI/CD a compilação e deploy.
- **2** — Menciona testes, mas não organiza os controles.
- **3** — Descreve pipeline básico com build, testes e publicação.
- **4** — Inclui segurança, integração, artefatos, ambientes e rollback.
- **5** — Demonstra visão de entrega contínua, governança, automação e redução de risco operacional.

**Perguntas de aprofundamento:**  

1. Como impediria que um artefato diferente fosse implantado em produção?
2. Como trataria uma migração de banco que não pode ser revertida facilmente?
3. Em quais condições um deploy automático para produção seria adequado?

---

## Pergunta 9 — Testes automatizados e responsabilidade do Tech Lead

**Nível:** Pleno  
**Categoria:** Testes e qualidade

**Pergunta do entrevistador:**  

Como você definiria uma estratégia de testes para um produto desenvolvido com Java e Spring Boot? Como evitaria tanto a falta de testes quanto uma pirâmide de testes desequilibrada?

**O que essa pergunta avalia:**  

Avalia conhecimento aplicado sobre testes unitários, testes de integração, testes de contrato, testes ponta a ponta e equilíbrio entre confiança, velocidade e custo de manutenção.

**Resposta esperada:**  

Eu começaria identificando os riscos e os comportamentos mais importantes do produto. A estratégia poderia combinar:

- Testes unitários para regras de negócio isoladas;
- Testes de integração para componentes que dependem de banco, mensageria ou framework;
- Testes de contrato para validar a comunicação entre consumidores e provedores;
- Testes ponta a ponta para fluxos críticos;
- Testes de segurança;
- Testes de desempenho quando houver requisitos relevantes;
- Testes de regressão para incidentes já ocorridos.

A maior parte da suíte deve ser composta por testes rápidos e focados. Testes mais amplos são importantes, mas devem ser usados nos fluxos em que agregam valor real.

Também avaliaria:

- Estabilidade;
- Tempo de execução;
- Facilidade de diagnóstico;
- Isolamento;
- Dados de teste;
- Cobertura de cenários de erro;
- Possibilidade de execução no pipeline.

Cobertura percentual, isoladamente, não garante qualidade. É necessário avaliar se os riscos e comportamentos relevantes estão protegidos.

**Explicação didática:**  

A pirâmide de testes representa uma estratégia em que:

- A base contém muitos testes unitários rápidos;
- O meio contém testes de integração;
- O topo contém poucos testes ponta a ponta, mais lentos e frágeis.

Uma suíte composta quase exclusivamente por testes ponta a ponta pode ser lenta e difícil de diagnosticar. Por outro lado, apenas testes unitários podem não detectar erros de configuração, persistência ou integração.

O equilíbrio depende do produto, mas os testes devem oferecer confiança sem impedir a evolução do time.

**Exemplo prático:**  

Para um serviço que calcula o valor final de um pedido:

- Testes unitários validam descontos e regras;
- Testes de integração verificam persistência;
- Testes de contrato verificam o formato da API;
- Testes ponta a ponta validam o fluxo de compra;
- Testes de desempenho verificam comportamento sob carga.

**Exemplo de código:**  

Um teste unitário poderia ser:

~~~java
class CalculadoraPedidoTest {

    private final CalculadoraPedido calculadora =
            new CalculadoraPedido();

    @Test
    void deveAplicarDescontoParaPedidoAcimaDoValorMinimo() {
        Pedido pedido = new Pedido(
                new BigDecimal("120.00"));

        BigDecimal total = calculadora.calcularTotal(pedido);

        assertThat(total)
                .isEqualByComparingTo("108.00");
    }
}
~~~

O teste deve possuir nome claro e validar um comportamento observável. O percentual de cobertura é apenas um indicador auxiliar.

**Como o candidato deve responder:**  

O candidato deve:

- Falar sobre diferentes níveis de teste;
- Relacionar testes aos riscos do produto;
- Explicar a pirâmide de testes;
- Considerar velocidade e manutenção;
- Mencionar cenários de erro;
- Evitar tratar cobertura percentual como único indicador;
- Explicar o papel dos testes no pipeline.

**Resposta fraca ou incompleta:**  

“Eu colocaria testes unitários em todas as classes e buscaria 100% de cobertura.”

Essa resposta não discute integração, comportamento, qualidade dos testes, custo de manutenção ou relevância dos cenários.

**Critérios de avaliação:**  

- **0** — Não conhece a importância dos testes.
- **1** — Menciona apenas testes unitários sem explicar sua finalidade.
- **2** — Conhece alguns tipos de teste, mas não sabe equilibrá-los.
- **3** — Propõe uma estratégia básica com testes unitários e de integração.
- **4** — Relaciona testes a riscos, pipeline, manutenção e diagnóstico.
- **5** — Demonstra visão madura sobre estratégia de testes, trade-offs, contratos, desempenho e valor de negócio.

**Perguntas de aprofundamento:**  

1. Como testaria uma integração com um serviço externo instável?
2. Quando um teste de integração é preferível a um mock?
3. Como trataria uma suíte de testes lenta e instável no pipeline?

---

## Pergunta 10 — Falha no pipeline próxima de uma entrega importante

**Nível:** Pleno  
**Categoria:** Troubleshooting e CI/CD

**Pergunta do entrevistador:**  

Uma entrega importante falha no pipeline apenas nos testes de integração. Localmente, os testes funcionam. A área de negócio está pressionando pela liberação. Como você conduziria a investigação sem simplesmente desabilitar os testes?

**O que essa pergunta avalia:**  

Avalia capacidade de investigação sistemática, postura diante de pressão, entendimento sobre diferenças entre ambientes e compromisso com qualidade.

**Resposta esperada:**  

Eu começaria preservando as evidências da falha:

- Mensagem completa do erro;
- Logs;
- Relatórios de teste;
- Commit exato;
- Versão do Java;
- Versões das dependências;
- Configurações;
- Imagem utilizada no pipeline;
- Dados de teste;
- Ordem de execução;
- Recursos disponíveis.

Depois investigaria as diferenças entre a execução local e o pipeline:

- Versão do Java;
- Sistema operacional;
- Banco de dados;
- Variáveis de ambiente;
- Fuso horário;
- Locale;
- Configuração do Spring Boot;
- Ordem e isolamento dos testes;
- Estado residual do banco;
- Serviços externos;
- Rede;
- Containers;
- Limites de memória e CPU.

Eu tentaria reproduzir a falha no mesmo ambiente do pipeline. Também verificaria se o teste é realmente determinístico ou se há problemas de concorrência, dados compartilhados ou dependência de horário.

Não desabilitaria o teste sem entender o risco. Caso uma liberação emergencial fosse necessária, a exceção deveria ser:

- Explicitamente aprovada;
- Registrada;
- Limitada no tempo;
- Associada a uma tarefa de correção;
- Acompanhada por validações adicionais;
- Monitorada após o deploy.

**Explicação didática:**  

Um teste que passa localmente e falha no pipeline pode revelar:

- Diferença de configuração;
- Dependência implícita de ambiente;
- Teste não isolado;
- Dados inconsistentes;
- Problema de concorrência;
- Dependência externa;
- Falta de recursos;
- Erro real introduzido pela alteração.

Desabilitar o teste pode apenas esconder o problema e transferir o risco para produção.

O Tech Lead deve ajudar o time a equilibrar urgência e segurança, evitando decisões impulsivas.

**Exemplo prático:**  

Um teste pode falhar no pipeline porque utiliza o horário real:

~~~java
@Test
void deveConsiderarPedidoExpirado() {
    Pedido pedido = Pedido.criadoEm(Instant.now().minus(2, ChronoUnit.HOURS));

    assertThat(pedido.estaExpirado()).isTrue();
}
~~~

Esse teste pode ser instável dependendo do tempo de execução. Uma alternativa mais previsível é injetar um relógio controlado:

~~~java
class PedidoService {

    private final Clock clock;

    PedidoService(Clock clock) {
        this.clock = clock;
    }

    boolean estaExpirado(Pedido pedido) {
        Instant agora = Instant.now(clock);

        return pedido.getCriadoEm()
                .plus(1, ChronoUnit.HOURS)
                .isBefore(agora);
    }
}
~~~

O teste pode usar um `Clock.fixed`, tornando o resultado determinístico.

**Exemplo de código:**  

Uma configuração de teste poderia ser:

~~~java
@Test
void deveIdentificarPedidoExpiradoComRelogioControlado() {
    Instant instanteFixo =
            Instant.parse("2026-01-01T12:00:00Z");

    Clock clock = Clock.fixed(
            instanteFixo,
            ZoneOffset.UTC);

    PedidoService service = new PedidoService(clock);

    Pedido pedido = Pedido.criadoEm(
            Instant.parse("2026-01-01T10:00:00Z"));

    assertThat(service.estaExpirado(pedido))
            .isTrue();
}
~~~

O uso de dependências controláveis facilita a reprodução e reduz testes instáveis.

**Como o candidato deve responder:**  

O candidato deve:

- Preservar evidências antes de alterar o pipeline;
- Comparar ambientes;
- Verificar dados, configuração e dependências;
- Investigar testes instáveis;
- Tentar reproduzir a falha;
- Evitar desabilitar a proteção automaticamente;
- Explicar como lidaria com uma exceção emergencial;
- Considerar monitoramento e plano de correção.

Deve evitar:

- Ignorar o erro;
- Reexecutar o pipeline indefinidamente sem investigar;
- Desabilitar todos os testes;
- Culpar imediatamente o ambiente;
- Liberar sem registrar o risco.

**Resposta fraca ou incompleta:**  

“Eu rodaria o pipeline novamente e, se continuasse falhando, desabilitaria o teste para não atrasar a entrega.”

Essa resposta não investiga a causa e transforma o pipeline em um obstáculo a ser contornado.

**Critérios de avaliação:**  

- **0** — Desabilita os testes ou ignora a falha.
- **1** — Apenas reexecuta o pipeline sem investigar.
- **2** — Investiga superficialmente configurações e logs.
- **3** — Compara ambientes e tenta reproduzir o problema.
- **4** — Investiga determinismo, dados, dependências e estratégia de exceção.
- **5** — Demonstra maturidade sob pressão, preserva evidências, avalia risco e conduz uma decisão segura e rastreável.

**Perguntas de aprofundamento:**  

1. Como identificaria se o teste é flaky?
2. Quais diferenças entre ambiente local e pipeline você verificaria primeiro?
3. Em que situação uma exceção temporária poderia ser aceita?
4. Como garantiria que o teste não fosse simplesmente esquecido depois da entrega?

---

## Resumo desta parte

| Item | Resultado |
|---|---|
| Perguntas apresentadas | 1 a 10 |
| Níveis abordados | Júnior e Pleno |
| Temas principais | Papel do Tech Lead, entrega de produto, refinamento, dívida técnica, Git, code review, CI/CD, testes e troubleshooting |
| Perguntas restantes | 90 |

## Próximas partes

- **Parte 2:** Perguntas 11 a 20 — liderança do time, comunicação, planejamento e gestão de conflitos;
- **Parte 3:** Perguntas 21 a 30 — Java e Spring Boot aplicados à entrega;
- **Parte 4:** Perguntas 31 a 40 — arquitetura, integração e decisões técnicas;
- **Parte 5:** Perguntas 41 a 50 — CI/CD, releases e estratégias de implantação;
- **Parte 6:** Perguntas 51 a 60 — qualidade, segurança e confiabilidade;
- **Parte 7:** Perguntas 61 a 70 — observabilidade, incidentes e produção;
- **Parte 8:** Perguntas 71 a 80 — liderança técnica sênior e evolução arquitetural;
- **Parte 9:** Perguntas 81 a 90 — estratégia, governança e escala;
- **Parte 10:** Perguntas 91 a 100 — cenários completos de Tech Lead, matriz de competências e recomendações finais.

---

# Roteiro Completo de Entrevista — Tech Lead de um Time Java

## Parte 2 de 10 — Perguntas 11 a 20

**Foco desta parte:** liderança do time, comunicação, planejamento e gestão de conflitos.

> As perguntas consideram um Tech Lead de um time que desenvolve produtos com Java e Spring Boot, utiliza Git e CI/CD, trabalha com metodologias ágeis e participa da entrega completa do produto.

## Fluxo de liderança e entrega

~~~mermaid
flowchart TD
    A[Objetivo do produto] --> B[Alinhamento com as partes interessadas]
    B --> C[Planejamento técnico]
    C --> D[Distribuição do trabalho]
    D --> E[Acompanhamento da execução]
    E --> F[Remoção de impedimentos]
    F --> G[Entrega e validação]
    G --> H[Feedback e melhoria contínua]
    H --> C

    I[Comunicação transparente] --> B
    I --> E
    I --> F
    I --> G

    J[Conflitos técnicos] --> K[Escuta e investigação]
    K --> L[Critérios objetivos]
    L --> M[Decisão documentada]
    M --> E
~~~

---

## Pergunta 11 — Construção de confiança e autonomia no time

**Nível:** Júnior  
**Categoria:** Liderança de pessoas

**Pergunta do entrevistador:**  

Como você construiria confiança com um time Java que ainda não conhece seu estilo de liderança e possui diferentes níveis de experiência?

**O que essa pergunta avalia:**  

Avalia a capacidade de iniciar uma atuação de liderança sem impor mudanças precipitadas, compreender o contexto do time e criar um ambiente de colaboração, segurança e autonomia.

**Resposta esperada:**  

Eu começaria conhecendo as pessoas, o produto, o processo de trabalho e os principais problemas enfrentados pelo time. Antes de propor mudanças, buscaria entender:

- Como as decisões técnicas são tomadas;
- Quais são os principais impedimentos;
- Quais responsabilidades cada pessoa exerce;
- Onde existem lacunas de conhecimento;
- Como o time recebe feedback;
- Quais são os objetivos do produto;
- Quais práticas já funcionam bem;
- Quais problemas são recorrentes.

Também faria conversas individuais para compreender expectativas, dificuldades e interesses de desenvolvimento. É importante cumprir os compromissos assumidos, dar visibilidade aos riscos e tratar as pessoas com respeito.

Para construir autonomia, eu evitaria centralizar decisões. Em vez disso, explicaria o contexto, definiria critérios e permitiria que os integrantes propusessem soluções. Quando necessário, ofereceria orientação, revisão e feedback.

A confiança é construída por meio de consistência, transparência, escuta e capacidade de apoiar o time nos momentos difíceis.

**Explicação didática:**  

Confiança não significa concordar com todas as decisões do time ou evitar conversas difíceis. Significa criar um ambiente em que as pessoas possam apresentar dúvidas, discordar tecnicamente e comunicar problemas sem medo de punição injusta.

Um Tech Lead que chega impondo novas ferramentas, padrões e processos pode gerar resistência, mesmo quando as mudanças são tecnicamente boas. O primeiro passo deve ser compreender o contexto e explicar os motivos das decisões.

Autonomia também não significa abandonar o time. Ela exige:

- Objetivos claros;
- Limites bem definidos;
- Acesso às informações;
- Feedback frequente;
- Apoio para decisões complexas;
- Responsabilidade compartilhada pelos resultados.

**Exemplo prático:**  

Ao perceber que apenas uma pessoa conhece profundamente o pipeline de CI/CD, eu não retiraria essa responsabilidade de forma abrupta. Poderia criar sessões de compartilhamento, documentar o processo e envolver outros integrantes em alterações futuras do pipeline.

Assim, o risco de dependência é reduzido sem desvalorizar quem já possui o conhecimento.

**Exemplo de código:**  

Não se aplica diretamente. O foco está na construção de confiança, colaboração e autonomia.

**Como o candidato deve responder:**  

O candidato deve:

- Falar sobre escuta antes de mudança;
- Demonstrar interesse pelas pessoas e pelo contexto;
- Mencionar conversas individuais e feedback;
- Explicar como promoveria compartilhamento de conhecimento;
- Diferenciar autonomia de abandono;
- Mostrar que confiança depende de consistência e transparência.

Deve evitar respostas como:

- “Eu mostraria desde o primeiro dia quem manda”;
- “Eu mudaria tudo para estabelecer meu padrão”;
- “Eu deixaria o time trabalhar sozinho para testar sua autonomia”.

**Resposta fraca ou incompleta:**  

“Eu faria uma reunião para apresentar minhas expectativas e definir novas regras de desenvolvimento.”

Essa resposta enfatiza imposição de regras e não demonstra preocupação em compreender o time, seus problemas ou sua maturidade.

**Critérios de avaliação:**  

- **0** — Não demonstra compreensão sobre liderança de pessoas.
- **1** — Associa confiança a autoridade ou controle.
- **2** — Fala sobre comunicação, mas não apresenta ações concretas.
- **3** — Propõe conhecer o time e estabelecer uma relação colaborativa.
- **4** — Relaciona confiança, feedback, autonomia e compartilhamento de conhecimento.
- **5** — Demonstra liderança situacional, segurança psicológica e capacidade de desenvolver um time sustentável.

**Perguntas de aprofundamento:**  

1. Como você agiria se o time demonstrasse resistência às suas propostas?
2. Como identificaria que uma pessoa está precisando de mais apoio?
3. Como equilibraria autonomia e acompanhamento?

---

## Pergunta 12 — Distribuição de tarefas e desenvolvimento das pessoas

**Nível:** Júnior  
**Categoria:** Planejamento e desenvolvimento do time

**Pergunta do entrevistador:**  

Como você distribuiria o trabalho de uma sprint entre integrantes com diferentes níveis de experiência, evitando tanto a sobrecarga dos mais experientes quanto a falta de oportunidades para quem está evoluindo?

**O que essa pergunta avalia:**  

Avalia a capacidade de planejar o trabalho considerando capacidade, riscos, aprendizado, colaboração e desenvolvimento das pessoas.

**Resposta esperada:**  

Eu começaria considerando:

- Capacidade real de cada pessoa;
- Complexidade das demandas;
- Dependências;
- Riscos técnicos;
- Prazos;
- Necessidade de conhecimento específico;
- Oportunidades de desenvolvimento;
- Ausências ou compromissos já conhecidos.

Não distribuiria o trabalho apenas com base na velocidade histórica ou em uma associação fixa entre pessoa e tipo de tarefa.

Para evitar concentração de conhecimento, utilizaria práticas como:

- Pareamento;
- Mob programming em problemas complexos;
- Code review entre diferentes níveis;
- Rotação de responsabilidades;
- Documentação;
- Participação de pessoas menos experientes em tarefas relevantes, com suporte;
- Planejamento de tempo para investigação e aprendizado.

Demandas críticas podem ser inicialmente conduzidas por alguém mais experiente, mas com participação de outras pessoas para reduzir dependências futuras.

**Explicação didática:**  

Distribuir trabalho não é apenas dividir cartões entre membros do time. É necessário equilibrar entrega e desenvolvimento.

Se todas as tarefas complexas forem atribuídas às mesmas pessoas, o time pode entregar no curto prazo, mas ficará dependente de poucos integrantes. Se tarefas muito complexas forem atribuídas sem apoio a quem ainda não possui experiência suficiente, o risco de atraso e frustração aumenta.

O Tech Lead deve ajustar o nível de suporte ao contexto. Uma tarefa pode ser delegada com:

- Objetivo claro;
- Critérios de aceite;
- Contexto técnico;
- Pessoa de apoio;
- Pontos de acompanhamento;
- Limite de tempo para investigação.

**Exemplo prático:**  

Uma alteração em uma integração de pagamentos pode ser conduzida por uma pessoa experiente em conjunto com outra que ainda não conhece o fluxo. A pessoa mais experiente orienta as decisões críticas, enquanto a outra participa da implementação, dos testes e da documentação.

Na próxima alteração, a segunda pessoa poderá assumir uma parte maior da responsabilidade.

**Exemplo de código:**  

Não é necessário código. A situação pode envolver Java e Spring Boot, mas o objetivo é avaliar planejamento de pessoas e distribuição de conhecimento.

**Como o candidato deve responder:**  

O candidato deve:

- Considerar capacidade e complexidade;
- Evitar associar pessoas permanentemente a determinados tipos de tarefa;
- Falar sobre pareamento e revisão;
- Explicar como desenvolveria pessoas;
- Mencionar riscos de concentração de conhecimento;
- Demonstrar equilíbrio entre entrega e aprendizado.

Deve evitar dizer que:

- “Os melhores devem ficar com as tarefas mais importantes”;
- “Cada pessoa deve trabalhar somente no que já domina”;
- “Quem tem menos experiência deve receber apenas tarefas simples”.

**Resposta fraca ou incompleta:**  

“Eu entregaria as tarefas mais complexas aos desenvolvedores seniores e as tarefas simples aos juniores.”

Essa resposta pode parecer eficiente, mas perpetua silos de conhecimento e não cria oportunidades de evolução.

**Critérios de avaliação:**  

- **0** — Não sabe explicar como distribuir o trabalho.
- **1** — Baseia a distribuição apenas em senioridade.
- **2** — Considera capacidade, mas não desenvolvimento.
- **3** — Distribui tarefas de acordo com complexidade e experiência.
- **4** — Inclui pareamento, rotação, revisão e redução de dependências.
- **5** — Demonstra estratégia equilibrada de entrega, desenvolvimento individual e resiliência do time.

**Perguntas de aprofundamento:**  

1. Como você agiria se a pessoa mais experiente estivesse sobrecarregada?
2. Como acompanharia uma tarefa complexa delegada a alguém em desenvolvimento?
3. Como mediria a redução da dependência de uma única pessoa?

---

## Pergunta 13 — Comunicação de riscos técnicos

**Nível:** Júnior  
**Categoria:** Comunicação e gestão de riscos

**Pergunta do entrevistador:**  

Como você comunicaria ao Product Manager e às demais partes interessadas que uma entrega está sob risco por causa de uma dependência técnica ou de uma limitação do sistema atual?

**O que essa pergunta avalia:**  

Avalia clareza de comunicação, transparência, capacidade de traduzir problemas técnicos para impactos de produto e habilidade de apresentar alternativas.

**Resposta esperada:**  

Eu comunicaria o risco assim que tivesse evidências suficientes, sem esperar o prazo estourar. A comunicação deveria explicar:

- Qual é o problema;
- Qual funcionalidade ou objetivo é afetado;
- Qual é a probabilidade de impacto;
- Qual é a possível consequência;
- O que já foi investigado;
- Quais alternativas existem;
- Qual esforço adicional é necessário;
- Quais decisões precisam ser tomadas;
- Qual recomendação técnica eu faria.

Em vez de dizer apenas “o sistema é legado” ou “a integração é complicada”, eu explicaria o efeito concreto:

> “A integração atual não suporta reprocessamento seguro. Se continuarmos com o desenho atual, uma falha de rede poderá gerar cobrança duplicada. Podemos reduzir o escopo, implementar idempotência antes da entrega ou aceitar o risco com monitoramento e procedimento manual.”

A decisão deve ser compartilhada com as pessoas responsáveis pelo produto e pelo negócio. O Tech Lead recomenda e explica; não deve esconder riscos nem tomar decisões de negócio isoladamente.

**Explicação didática:**  

Comunicação técnica eficaz conecta causa e consequência. Pessoas não técnicas não precisam conhecer todos os detalhes de uma implementação em Spring Boot, mas precisam entender:

- O que está em risco;
- Qual é o impacto;
- Quais opções existem;
- Qual é o custo de cada alternativa;
- Qual prazo é realista.

A comunicação deve evitar tanto o excesso de jargão quanto a simplificação que esconde riscos.

**Exemplo prático:**  

Em uma nova funcionalidade de pedidos, o time descobre que o sistema externo não garante prazo de resposta. Uma comunicação adequada poderia ser:

> “A funcionalidade pode ser entregue com consulta síncrona, mas o tempo de resposta do parceiro varia bastante. Recomendamos processar a solicitação de forma assíncrona e informar ao usuário que o status será atualizado posteriormente. Isso aumenta a resiliência, mas exige uma alteração no fluxo da interface.”

**Exemplo de código:**  

Não é necessário código. O foco está na comunicação do impacto e das alternativas.

**Como o candidato deve responder:**  

O candidato deve:

- Comunicar riscos antecipadamente;
- Explicar impacto em linguagem compreensível;
- Apresentar alternativas;
- Explicitar trade-offs;
- Fazer uma recomendação;
- Registrar a decisão;
- Diferenciar risco técnico de decisão de negócio.

Deve evitar:

- Esconder o problema;
- Usar apenas jargões;
- Informar o risco sem propor alternativas;
- Prometer uma data sem evidências;
- Culpar outro time.

**Resposta fraca ou incompleta:**  

“Eu avisaria que a integração está atrasada e pediria mais prazo.”

Essa resposta não explica a causa, o impacto, as alternativas nem o processo de decisão.

**Critérios de avaliação:**  

- **0** — Não comunicaria o risco adequadamente.
- **1** — Apenas informaria atraso ou dificuldade.
- **2** — Explicaria o problema, mas sem relacioná-lo ao impacto.
- **3** — Comunica o risco e solicita decisão ou prazo adicional.
- **4** — Apresenta impacto, alternativas e trade-offs.
- **5** — Demonstra comunicação executiva, transparência, recomendação objetiva e gestão responsável de riscos.

**Perguntas de aprofundamento:**  

1. Como explicaria uma dívida técnica para uma pessoa não técnica?
2. O que faria se o Product Manager escolhesse uma alternativa que você considera arriscada?
3. Como registraria a decisão e os riscos aceitos?

---

## Pergunta 14 — Planejamento de uma entrega com dependências

**Nível:** Pleno  
**Categoria:** Planejamento e coordenação

**Pergunta do entrevistador:**  

O time precisa entregar uma nova funcionalidade que depende de alterações no backend Java, de uma API de outro time, de uma mudança no banco de dados e de uma atualização no pipeline de CI/CD. Como você organizaria o planejamento?

**O que essa pergunta avalia:**  

Avalia planejamento técnico, identificação de dependências, decomposição de trabalho, coordenação entre times e capacidade de reduzir riscos antes da execução.

**Resposta esperada:**  

Eu começaria entendendo o objetivo da funcionalidade e separando o trabalho em resultados verificáveis. Em seguida, identificaria:

- Dependências externas;
- Contratos entre sistemas;
- Responsáveis;
- Sequência necessária;
- Caminho crítico;
- Riscos;
- Ambientes disponíveis;
- Necessidade de dados de teste;
- Compatibilidade retroativa;
- Estratégia de implantação;
- Plano de rollback.

A decomposição poderia incluir:

1. Validar o contrato da API externa;
2. Criar ou atualizar o modelo de dados;
3. Preparar migração compatível;
4. Implementar o domínio e os endpoints;
5. Criar testes;
6. Configurar o pipeline;
7. Disponibilizar ambiente integrado;
8. Executar testes de contrato;
9. Fazer implantação controlada;
10. Monitorar a funcionalidade.

Eu não esperaria o desenvolvimento terminar para começar a tratar dependências. O contato com o outro time, a validação do contrato e o teste de integração deveriam ocorrer cedo.

Também utilizaria técnicas como:

- Stubs;
- Mocks em pontos apropriados;
- Testes de contrato;
- Feature flags;
- Compatibilidade entre versões;
- Spikes técnicos;
- Marcos de integração.

**Explicação didática:**  

Uma dependência é um trabalho, sistema ou decisão que precisa estar disponível para outra parte avançar. Se ela não for identificada cedo, pode bloquear o time perto do prazo final.

O planejamento deve mostrar o caminho crítico, mas não precisa criar uma estrutura burocrática. O objetivo é tornar visíveis as dependências e criar ações para reduzir o risco.

A compatibilidade retroativa é importante quando diferentes componentes são liberados em momentos distintos. Por exemplo, uma API pode precisar aceitar tanto o formato antigo quanto o novo durante um período de transição.

**Exemplo prático:**  

Se o novo backend depende de um campo que ainda não existe no banco, uma estratégia segura poderia ser:

1. Adicionar o campo de forma compatível;
2. Publicar o código que sabe lidar com ausência do valor;
3. Atualizar o produtor ou consumidor;
4. Migrar os dados gradualmente;
5. Ativar a funcionalidade;
6. Remover compatibilidade antiga somente depois da estabilização.

**Exemplo de código:**  

Não é necessário código específico. A decisão principal envolve sequência, compatibilidade e coordenação entre entregas.

**Como o candidato deve responder:**  

O candidato deve:

- Começar pelo objetivo e pelo escopo;
- Mapear dependências e responsáveis;
- Identificar o caminho crítico;
- Planejar integração antecipada;
- Mencionar contratos, testes e compatibilidade;
- Incluir pipeline, banco e rollout;
- Explicar como reduzir riscos com entregas incrementais.

Deve evitar criar um plano baseado apenas em uma lista de tarefas internas, ignorando os outros times e sistemas.

**Resposta fraca ou incompleta:**  

“Eu dividiria as tarefas entre os desenvolvedores e acompanharia o andamento na daily.”

Essa resposta não trata dependências externas, contratos, sequência, riscos ou estratégia de integração.

**Critérios de avaliação:**  

- **0** — Não identifica as dependências.
- **1** — Trata o trabalho como tarefas isoladas.
- **2** — Lista dependências, mas não apresenta ações.
- **3** — Organiza as tarefas e responsáveis.
- **4** — Inclui integração antecipada, contratos, riscos e compatibilidade.
- **5** — Demonstra planejamento incremental, visão sistêmica e capacidade de coordenar uma entrega complexa.

**Perguntas de aprofundamento:**  

1. O que faria se o outro time atrasasse a API?
2. Como entregaria valor sem esperar todas as dependências?
3. Como identificaria o caminho crítico da entrega?

---

## Pergunta 15 — Daily, acompanhamento e microgerenciamento

**Nível:** Pleno  
**Categoria:** Gestão do fluxo de trabalho

**Pergunta do entrevistador:**  

Como você utilizaria a daily e outros mecanismos de acompanhamento para identificar riscos e impedimentos sem transformar o processo em microgerenciamento?

**O que essa pergunta avalia:**  

Avalia compreensão sobre acompanhamento ágil, foco em fluxo de valor, remoção de impedimentos e preservação da autonomia do time.

**Resposta esperada:**  

A daily deve ajudar o time a sincronizar o trabalho e identificar obstáculos que possam comprometer o objetivo do ciclo. Ela não deveria ser uma prestação de contas individual ao Tech Lead.

Eu observaria:

- O objetivo do ciclo;
- Itens bloqueados;
- Trabalho em andamento em excesso;
- Dependências;
- Riscos de prazo;
- Falhas recorrentes;
- Necessidade de colaboração;
- Diferença entre progresso aparente e resultado entregue.

Quando um problema surgir, eu aprofundaria a conversa fora da daily com as pessoas envolvidas, evitando ocupar o tempo de todo o time.

Além da daily, utilizaria outros sinais:

- Fluxo do quadro;
- Idade dos itens em andamento;
- Tempo de ciclo;
- Falhas do pipeline;
- Pull requests aguardando revisão;
- Incidentes;
- Feedback de produto;
- Cumprimento do objetivo do ciclo.

Meu papel seria remover impedimentos, facilitar decisões e ajustar o plano, não exigir atualizações constantes de cada pessoa.

**Explicação didática:**  

Microgerenciamento ocorre quando a liderança controla excessivamente como e quando cada pessoa executa o trabalho, reduzindo autonomia e aumentando o custo de coordenação.

Acompanhamento saudável observa resultados, riscos e bloqueios. Não significa ignorar o trabalho; significa criar visibilidade sem controlar cada detalhe.

Uma daily que percorre cada pessoa perguntando “o que você fez ontem?” pode não revelar que o item mais importante está bloqueado. Uma conversa orientada ao objetivo do time tende a produzir informações mais úteis.

**Exemplo prático:**  

Se três pessoas estão trabalhando em tarefas diferentes, mas todas dependem de um contrato de API ainda indefinido, o problema não será resolvido com mais atualizações individuais. O Tech Lead deve facilitar a decisão sobre o contrato e alinhar os responsáveis.

**Exemplo de código:**  

Não se aplica diretamente. O tema envolve fluxo de trabalho e liderança.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar a finalidade da daily;
- Focar em objetivo, riscos e impedimentos;
- Diferenciar acompanhamento de fiscalização;
- Mencionar métricas de fluxo;
- Evitar transformar a reunião em relatório ao Tech Lead;
- Explicar quando levar uma discussão para fora da reunião.

Deve evitar dizer que acompanha o time verificando cada commit ou perguntando continuamente sobre o andamento.

**Resposta fraca ou incompleta:**  

“Eu pediria que cada desenvolvedor explicasse detalhadamente tudo o que fez e tudo o que fará.”

Essa abordagem pode gerar controle excessivo e ainda não mostrar os bloqueios mais relevantes para o resultado do time.

**Critérios de avaliação:**  

- **0** — Confunde acompanhamento com fiscalização.
- **1** — Defende controle detalhado de cada pessoa.
- **2** — Conhece a daily, mas não sabe utilizá-la para remover impedimentos.
- **3** — Foca em alinhamento e identificação de bloqueios.
- **4** — Usa sinais de fluxo e preserva a autonomia do time.
- **5** — Demonstra capacidade de conduzir acompanhamento orientado a resultados, riscos e melhoria contínua.

**Perguntas de aprofundamento:**  

1. O que você faria se as dailies se tornassem longas e improdutivas?
2. Quais sinais indicariam que um item está parado, mesmo sem estar marcado como bloqueado?
3. Como agiria se uma pessoa não comunicasse um risco até o último momento?

---

## Pergunta 16 — Discordância técnica entre integrantes do time

**Nível:** Pleno  
**Categoria:** Gestão de conflitos técnicos

**Pergunta do entrevistador:**  

Dois desenvolvedores discordam sobre a implementação de uma funcionalidade em Spring Boot. Uma pessoa defende uma solução síncrona e simples; a outra defende processamento assíncrono com mensageria. Como você conduziria a decisão?

**O que essa pergunta avalia:**  

Avalia a capacidade de mediar conflitos técnicos, separar preferências de requisitos, estabelecer critérios objetivos e tomar decisões proporcionais ao problema.

**Resposta esperada:**  

Eu começaria garantindo que ambas as pessoas expliquem suas propostas, premissas e preocupações. Depois, definiria critérios de comparação relacionados ao problema:

- Requisito de tempo de resposta;
- Necessidade de consistência imediata;
- Volume esperado;
- Tolerância a falhas;
- Complexidade operacional;
- Observabilidade;
- Custo;
- Experiência do time;
- Necessidade de reprocessamento;
- Impacto no usuário;
- Prazo de entrega;
- Evolução futura.

A solução síncrona pode ser adequada quando o volume é baixo, a resposta precisa ser imediata e a dependência possui boa disponibilidade. A solução assíncrona pode ser melhor quando há picos de carga, necessidade de desacoplamento, processamento demorado ou tolerância a resposta posterior.

Eu evitaria escolher com base em autoridade, preferência pessoal ou tendência arquitetural. Se a decisão ainda não estiver clara, proporia um experimento pequeno, um spike ou uma implementação incremental.

Depois da decisão, registraria:

- Contexto;
- Opções consideradas;
- Critérios;
- Decisão;
- Riscos;
- Condições para revisitar a escolha.

**Explicação didática:**  

Muitos conflitos técnicos parecem discordâncias sobre tecnologia, mas na verdade são discordâncias sobre premissas não explicitadas.

Uma pessoa pode estar otimizando simplicidade e prazo, enquanto outra está protegendo escalabilidade e resiliência. Ambas podem estar corretas em contextos diferentes.

O Tech Lead deve transformar a discussão de “qual abordagem é melhor?” para:

> “Qual abordagem atende melhor aos requisitos e restrições deste produto?”

Também deve considerar o custo total. Mensageria não é apenas adicionar uma fila: exige tratamento de duplicidade, observabilidade, reprocessamento, ordenação quando necessário, dead-letter queue e operação.

**Exemplo prático:**  

Para enviar uma confirmação de pedido, uma abordagem assíncrona pode evitar que a indisponibilidade do provedor de e-mail bloqueie a compra. Porém, para validar imediatamente o limite de crédito, a comunicação síncrona pode ser mais apropriada.

A decisão pode combinar os dois estilos em partes diferentes do fluxo.

**Exemplo de código:**  

Não é necessário código. O foco é avaliar critérios de decisão e mediação técnica.

**Como o candidato deve responder:**  

O candidato deve:

- Ouvir as duas propostas;
- Tornar as premissas explícitas;
- Comparar as alternativas por critérios;
- Mencionar trade-offs;
- Considerar operação e observabilidade;
- Evitar decidir apenas por senioridade;
- Documentar a decisão;
- Propor experimento quando houver incerteza relevante.

Deve evitar afirmações absolutas como:

- “Mensageria é sempre mais escalável”;
- “Síncrono é sempre mais simples”;
- “A decisão é do Tech Lead porque ele é o responsável”.

**Resposta fraca ou incompleta:**  

“Eu escolheria a solução assíncrona porque é mais moderna e escalável.”

A resposta não considera requisitos, custo, complexidade operacional ou necessidade de resposta imediata.

**Critérios de avaliação:**  

- **0** — Escolhe uma solução arbitrariamente.
- **1** — Decide com base em preferência ou autoridade.
- **2** — Ouve as propostas, mas não utiliza critérios objetivos.
- **3** — Compara simplicidade, desempenho e requisitos básicos.
- **4** — Considera operação, custo, resiliência e trade-offs.
- **5** — Conduz uma decisão estruturada, colaborativa, documentada e proporcional ao contexto.

**Perguntas de aprofundamento:**  

1. Em quais situações a mensageria aumentaria o risco em vez de reduzi-lo?
2. Como testaria uma solução assíncrona?
3. Como monitoraria mensagens acumuladas ou falhas no processamento?

---

## Pergunta 17 — Feedback sobre desempenho técnico

**Nível:** Pleno  
**Categoria:** Feedback e desenvolvimento

**Pergunta do entrevistador:**  

Um integrante do time entrega código funcional, mas seus pull requests são grandes, suas decisões não são documentadas e ele costuma ignorar feedback de revisão. Como você conduziria essa situação?

**O que essa pergunta avalia:**  

Avalia maturidade para dar feedback, capacidade de diferenciar comportamento de pessoa, habilidade de estabelecer expectativas e disposição para acompanhar evolução.

**Resposta esperada:**  

Eu trataria a situação em uma conversa individual, com exemplos concretos e foco no impacto do comportamento.

Em vez de dizer “você não trabalha bem”, eu explicaria:

> “Nos últimos pull requests, as alterações tinham muitas partes diferentes e as decisões principais não estavam registradas. Isso aumentou o tempo de revisão e dificultou entender os riscos da mudança. Também observamos que alguns feedbacks importantes foram repetidos sem serem tratados.”

Eu buscaria entender a causa. Pode haver:

- Falta de clareza sobre o padrão esperado;
- Pressão por prazo;
- Dificuldade de dividir o trabalho;
- Insegurança;
- Discordância legítima sobre o feedback;
- Falta de conhecimento sobre o domínio;
- Problemas de comunicação.

Depois, combinaria ações observáveis, como:

- Dividir mudanças em pull requests menores;
- Adicionar descrição com contexto e riscos;
- Registrar decisões arquiteturais relevantes;
- Fazer uma sessão de pareamento;
- Definir quais comentários são bloqueadores;
- Rever a evolução em algumas semanas.

Se a pessoa discordar de um feedback, eu incentivaria uma discussão técnica baseada em critérios. Feedback não deve significar obediência cega; o importante é resolver a divergência e tornar a decisão explícita.

**Explicação didática:**  

Feedback eficaz descreve comportamento, impacto e expectativa. Ele não rotula a pessoa.

Uma conversa madura deve responder:

- O que aconteceu?
- Qual foi o impacto?
- O que era esperado?
- O que pode ser feito de forma diferente?
- Que apoio será oferecido?
- Como saberemos se houve evolução?

O Tech Lead também deve verificar se o processo favorece o comportamento desejado. Se o time exige pull requests pequenos, mas entrega tudo em lotes enormes por pressão de prazo, o problema não é apenas individual.

**Exemplo prático:**  

Um pull request que mistura alteração de banco, novo endpoint, mudança no pipeline e refatoração de dezenas de classes pode ser dividido em mudanças independentes. Isso torna a revisão mais segura e facilita o rollback.

**Exemplo de código:**  

Não é necessário código. O exemplo pode ser discutido a partir do fluxo de pull requests e decisões técnicas.

**Como o candidato deve responder:**  

O candidato deve:

- Dar feedback em particular;
- Usar fatos e exemplos;
- Explicar o impacto;
- Ouvir a perspectiva da pessoa;
- Definir ações concretas;
- Oferecer suporte;
- Acompanhar a evolução;
- Considerar problemas sistêmicos.

Deve evitar:

- Corrigir a pessoa publicamente;
- Usar rótulos;
- Fazer ameaças imediatas;
- Interpretar discordância como insubordinação;
- Dar feedback genérico sem exemplos.

**Resposta fraca ou incompleta:**  

“Eu falaria que ela precisa melhorar e passaria a revisar tudo com mais rigor.”

Essa resposta não explica o comportamento esperado, não investiga a causa e pode aumentar o controle sem resolver o problema.

**Critérios de avaliação:**  

- **0** — Não sabe conduzir feedback.
- **1** — Defende exposição pública ou punição imediata.
- **2** — Dá feedback, mas de forma genérica.
- **3** — Usa exemplos e orienta melhorias.
- **4** — Combina escuta, ações observáveis, suporte e acompanhamento.
- **5** — Demonstra capacidade de desenvolver a pessoa e também identificar problemas no processo do time.

**Perguntas de aprofundamento:**  

1. O que faria se a pessoa discordasse continuamente dos feedbacks?
2. Como diferenciar uma discordância legítima de resistência improdutiva?
3. Como evitar que o foco em pull requests pequenos prejudique a velocidade?

---

## Pergunta 18 — Conflito entre velocidade de entrega e qualidade

**Nível:** Sênior  
**Categoria:** Gestão de trade-offs

**Pergunta do entrevistador:**  

O Product Manager solicita a liberação de uma funcionalidade em poucos dias. O time identificou que seria necessário reduzir a cobertura de testes, adiar uma melhoria de observabilidade e aceitar uma limitação conhecida. Como você conduziria essa decisão?

**O que essa pergunta avalia:**  

Avalia tomada de decisão sob pressão, gestão de riscos, negociação com produto, comunicação executiva e capacidade de distinguir redução de escopo de redução irresponsável de qualidade.

**Resposta esperada:**  

Eu começaria esclarecendo o objetivo de negócio, a data realmente necessária e o impacto de não entregar. Depois, classificaria os pontos identificados por risco:

- O que é obrigatório para segurança;
- O que é necessário para funcionamento correto;
- O que pode ser simplificado;
- O que pode ser adiado;
- O que exige plano de mitigação;
- O que não deveria ser aceito.

Eu tentaria reduzir o escopo da funcionalidade antes de reduzir controles essenciais. Por exemplo, poderia entregar apenas um fluxo principal, atrás de uma feature flag, com testes dos cenários críticos e monitoramento mínimo adequado.

Não aceitaria reduzir testes ou observabilidade de forma genérica. Seria necessário explicar o risco e estabelecer compensações, como:

- Testes manuais direcionados;
- Implantação gradual;
- Limite de usuários;
- Monitoramento específico;
- Plano de rollback;
- Responsável pela correção posterior;
- Prazo explícito para eliminar a limitação.

Riscos relacionados a segurança, integridade de dados ou possibilidade de dano significativo devem ser tratados como bloqueadores ou escalados para decisão formal.

A decisão final precisa ser transparente, com registro do que foi aceito, por quem e sob quais condições.

**Explicação didática:**  

Entregar mais rápido não significa simplesmente remover etapas de qualidade. Muitas vezes, a melhor maneira de reduzir prazo é reduzir escopo e complexidade.

Há diferença entre:

- Entregar menos funcionalidades;
- Adiar uma melhoria não crítica;
- Reduzir testes críticos;
- Liberar sem possibilidade de diagnosticar problemas;
- Aceitar risco de inconsistência ou perda de dados.

As três primeiras podem ser negociáveis dependendo do contexto. As últimas podem gerar incidentes graves.

Um Tech Lead sênior deve proteger o produto sem assumir sozinho decisões que pertencem ao negócio. Ele apresenta opções, riscos e recomendações de forma clara.

**Exemplo prático:**  

Em vez de entregar uma nova jornada de pedidos para todos os clientes, o time pode:

1. Liberar apenas para funcionários internos;
2. Ativar para uma pequena porcentagem de usuários;
3. Monitorar erros e tempo de resposta;
4. Validar os indicadores;
5. Ampliar gradualmente;
6. Reverter se os limites forem ultrapassados.

**Exemplo de código:**  

Uma política de liberação gradual poderia ser implementada por uma feature flag controlada externamente:

~~~java
@Service
public class CheckoutService {

    private final FeatureToggle featureToggle;

    public CheckoutService(FeatureToggle featureToggle) {
        this.featureToggle = featureToggle;
    }

    public Resultado finalizar(Pedido pedido, Usuario usuario) {
        if (featureToggle.estaAtiva(
                "novo-checkout",
                usuario.getId())) {
            return finalizarNoNovoFluxo(pedido);
        }

        return finalizarNoFluxoAtual(pedido);
    }

    private Resultado finalizarNoNovoFluxo(Pedido pedido) {
        // Novo fluxo protegido por liberação gradual.
        return Resultado.sucesso();
    }

    private Resultado finalizarNoFluxoAtual(Pedido pedido) {
        return Resultado.sucesso();
    }
}
~~~

A feature flag não substitui testes, monitoramento ou plano de rollback. Ela apenas reduz o raio inicial de exposição.

**Como o candidato deve responder:**  

O candidato deve:

- Entender a urgência de negócio;
- Separar escopo de qualidade essencial;
- Classificar os riscos;
- Propor alternativas incrementais;
- Proteger segurança, integridade e operação;
- Definir mitigação e prazo para pendências;
- Registrar quem aceitou os riscos.

Deve evitar tanto “sempre entregar a qualquer custo” quanto “nunca negociar prazo ou escopo”.

**Resposta fraca ou incompleta:**  

“Eu diria que não é possível entregar sem completar todos os testes e a observabilidade.”

Essa resposta pode proteger a qualidade, mas não explora redução de escopo, liberação gradual ou alternativas para atender parcialmente ao objetivo.

**Critérios de avaliação:**  

- **0** — Aceita qualquer risco ou bloqueia sem analisar alternativas.
- **1** — Reduz testes e controles sem avaliar consequências.
- **2** — Reconhece riscos, mas não estrutura uma decisão.
- **3** — Propõe negociar escopo e priorizar controles essenciais.
- **4** — Inclui mitigação, rollout gradual, observabilidade e rollback.
- **5** — Demonstra visão estratégica, comunicação executiva e capacidade de equilibrar prazo, custo, qualidade e risco.

**Perguntas de aprofundamento:**  

1. Quais riscos nunca deveriam ser aceitos sem escalonamento?
2. Como decidiria quais testes são essenciais para a primeira versão?
3. Como impediria que uma exceção temporária se tornasse permanente?

---

## Pergunta 19 — Alinhamento entre Tech Lead, Product Manager e liderança

**Nível:** Sênior  
**Categoria:** Comunicação estratégica

**Pergunta do entrevistador:**  

Como você lidaria com uma situação em que o Product Manager prioriza uma funcionalidade importante para o negócio, enquanto a liderança técnica da organização defende primeiro uma iniciativa de modernização da plataforma?

**O que essa pergunta avalia:**  

Avalia capacidade de alinhar interesses diferentes, construir uma decisão baseada em valor e risco e evitar que a discussão se transforme em disputa de autoridade.

**Resposta esperada:**  

Eu começaria entendendo os objetivos de cada iniciativa e tornando explícitos os critérios de decisão:

- Valor esperado para o negócio;
- Urgência;
- Risco operacional;
- Impacto em clientes;
- Custo de atraso;
- Esforço;
- Dependências;
- Redução de risco futuro;
- Capacidade do time;
- Reversibilidade das decisões;
- Prazo para obter valor.

A modernização não deveria ser apresentada apenas como “precisamos atualizar a tecnologia”. Seria necessário explicar que problema ela resolve, como afeta a entrega, quais riscos reduz e qual seria o custo de não realizá-la.

Da mesma forma, a funcionalidade de negócio deveria ser analisada considerando se a plataforma atual consegue suportá-la com segurança e qual dívida adicional seria criada.

Eu proporia cenários, por exemplo:

1. Entregar a funcionalidade imediatamente com uma solução temporária;
2. Fazer uma etapa mínima de modernização antes;
3. Executar as duas iniciativas em fases;
4. Reduzir o escopo da funcionalidade;
5. Realizar um experimento para validar o risco.

A decisão deve ser tomada com os responsáveis pelo produto e pela estratégia técnica. Meu papel seria oferecer dados, recomendações e consequências, não transformar a discussão em uma disputa entre áreas.

**Explicação didática:**  

Conflitos entre produto e plataforma frequentemente surgem porque cada área otimiza uma dimensão diferente:

- Produto busca valor e prazo;
- Plataforma busca confiabilidade, sustentabilidade e redução de risco;
- Engenharia busca qualidade e capacidade de evolução.

A solução não é declarar automaticamente um lado vencedor. É construir uma visão comum de custo, valor e risco.

Modernização também precisa ser tratada como investimento com resultado esperado. Pode reduzir tempo de entrega, incidentes, custo de infraestrutura ou risco de segurança, mas deve haver uma hipótese verificável.

**Exemplo prático:**  

Se o time precisa criar uma nova funcionalidade em uma aplicação Spring Boot antiga, pode ser melhor evitar uma migração completa antes da entrega. Uma alternativa seria isolar a nova capacidade, criar testes de caracterização no fluxo afetado e modernizar apenas o componente necessário.

Isso pode gerar valor sem assumir o risco de reescrever todo o sistema.

**Exemplo de código:**  

Não é necessário código. A questão avalia alinhamento estratégico e tomada de decisão.

**Como o candidato deve responder:**  

O candidato deve:

- Entender os objetivos de todas as partes;
- Transformar modernização em resultado mensurável;
- Comparar custo de fazer e não fazer;
- Apresentar cenários;
- Propor fases ou escopo incremental;
- Explicitar riscos e dependências;
- Apoiar uma decisão compartilhada.

Deve evitar:

- Escolher automaticamente produto ou plataforma;
- Defender modernização apenas por preferência tecnológica;
- Tratar a liderança técnica como autoridade absoluta;
- Aceitar dívida sem comunicar consequências.

**Resposta fraca ou incompleta:**  

“Eu seguiria a decisão da liderança técnica, porque modernização é mais importante para o futuro.”

Essa resposta não avalia valor de negócio, urgência, alternativas ou impacto do atraso.

**Critérios de avaliação:**  

- **0** — Não consegue mediar interesses conflitantes.
- **1** — Escolhe um lado com base em autoridade.
- **2** — Reconhece o conflito, mas não propõe critérios.
- **3** — Compara valor, esforço e risco.
- **4** — Propõe cenários, fases e métricas.
- **5** — Demonstra visão estratégica, capacidade de alinhamento e decisões baseadas em evidências e consequências.

**Perguntas de aprofundamento:**  

1. Como demonstraria o retorno de uma iniciativa de modernização?
2. Como evitaria que uma solução temporária se tornasse permanente?
3. O que faria se as partes interessadas não chegassem a um acordo?

---

## Pergunta 20 — Gestão de conflito grave dentro do time

**Nível:** Sênior  
**Categoria:** Liderança e resolução de conflitos

**Pergunta do entrevistador:**  

Dois integrantes experientes do time entraram em conflito recorrente. As discussões sobre arquitetura e revisão de código se tornaram pessoais, o restante do time evita participar e as entregas começaram a atrasar. Como você atuaria?

**O que essa pergunta avalia:**  

Avalia liderança em situações difíceis, capacidade de proteger o ambiente do time, mediação, definição de limites e tratamento de conflitos persistentes.

**Resposta esperada:**  

Eu não ignoraria o problema nem tentaria resolvê-lo apenas com uma regra genérica de “mais colaboração”. Primeiro, buscaria compreender os fatos e os comportamentos observáveis.

Conversaria individualmente com cada pessoa para:

- Ouvir sua percepção;
- Identificar episódios concretos;
- Entender as causas;
- Separar discordância técnica de comportamento inadequado;
- Avaliar impactos no trabalho;
- Verificar se existem problemas de processo, responsabilidade ou comunicação.

Depois, conduziria uma conversa estruturada entre as partes, com regras claras:

- Foco no problema e não em ataques pessoais;
- Uso de evidências;
- Escuta sem interrupções;
- Busca por critérios técnicos comuns;
- Definição de comportamentos esperados;
- Acordo sobre próximos passos.

Também ajustaria mecanismos do processo, como:

- Critérios objetivos para decisões arquiteturais;
- ADRs ou registros de decisão;
- Limite para discussões em pull requests;
- Reuniões técnicas específicas;
- Revisão por mais de uma pessoa;
- Rotação de ownership;
- Prazo para encerrar uma discussão;
- Escalonamento quando não houver consenso.

Se houver comportamento desrespeitoso, assédio, discriminação ou repetição de condutas prejudiciais, eu trataria o caso com seriedade e envolveria a liderança de pessoas ou a área responsável, conforme as políticas da organização.

O objetivo não é obrigar as pessoas a concordarem em tudo. É garantir que discordâncias sejam tratadas de forma profissional e não prejudiquem o time ou o produto.

**Explicação didática:**  

Conflito técnico saudável pode melhorar decisões. Conflito destrutivo ocorre quando a discussão deixa de tratar ideias e passa a atacar pessoas, bloquear trabalho ou criar medo de participação.

O Tech Lead deve evitar dois extremos:

- Impor uma decisão rapidamente sem entender o problema;
- Permitir que a discussão continue indefinidamente em nome do consenso.

Nem toda decisão precisa de unanimidade. O time pode utilizar um processo em que:

1. As opções são apresentadas;
2. Os critérios são definidos;
3. As evidências são analisadas;
4. Uma decisão é tomada;
5. Os riscos são registrados;
6. A decisão pode ser revisitada se novas evidências surgirem.

**Exemplo prático:**  

Se uma discussão sobre arquitetura permanece aberta por semanas, o Tech Lead pode organizar uma sessão com:

- Problema a ser resolvido;
- Requisitos;
- Restrições;
- Alternativas;
- Critérios de avaliação;
- Decisão recomendada;
- Responsável;
- Data de revisão.

A partir desse momento, novas objeções devem trazer evidências ou informações relevantes, não apenas repetir preferências.

**Exemplo de código:**  

Não é necessário código. O conflito pode envolver Java ou Spring Boot, mas a competência avaliada é liderança e resolução de conflitos.

**Como o candidato deve responder:**  

O candidato deve:

- Agir rapidamente, sem tirar conclusões precipitadas;
- Ouvir as partes individualmente;
- Separar fatos, interpretações e comportamentos;
- Proteger a segurança psicológica do time;
- Definir critérios objetivos;
- Estabelecer limites para comportamentos inadequados;
- Documentar decisões;
- Envolver a liderança apropriada quando necessário;
- Acompanhar se o conflito realmente foi resolvido.

Deve evitar:

- Ignorar o problema;
- Expor ou constranger os envolvidos;
- Escolher um lado por senioridade;
- Forçar consenso infinito;
- Tratar comportamento desrespeitoso como simples “diferença de estilo”.

**Resposta fraca ou incompleta:**  

“Eu reuniria os dois e diria que eles precisam agir profissionalmente. Se continuassem, escolheria a solução do Tech Lead.”

Essa resposta não investiga causas, não define critérios e pode apenas mascarar o problema.

**Critérios de avaliação:**  

- **0** — Ignora o conflito ou reage de forma autoritária.
- **1** — Reduz o problema a uma conversa superficial.
- **2** — Ouve os envolvidos, mas não define ações.
- **3** — Medeia a discussão e estabelece critérios técnicos.
- **4** — Combina mediação, melhoria de processo, documentação e acompanhamento.
- **5** — Demonstra liderança madura, protege o time, diferencia conflito saudável de comportamento inadequado e resolve o problema de forma sustentável.

**Perguntas de aprofundamento:**  

1. Como você agiria se uma das pessoas fosse uma referência indispensável para o produto?
2. O que faria se o conflito envolvesse uma acusação de comportamento inadequado?
3. Como evitaria que decisões técnicas continuassem sendo discutidas indefinidamente?
4. Como verificaria se o restante do time voltou a participar das discussões?

---

# Resumo desta parte

| Item | Resultado |
|---|---|
| Perguntas apresentadas | 11 a 20 |
| Níveis abordados | Júnior, Pleno e Sênior |
| Temas principais | Confiança, autonomia, distribuição de trabalho, comunicação de riscos, planejamento, daily, feedback, conflitos técnicos e alinhamento estratégico |
| Perguntas restantes | 80 |

## Competências exploradas

- Construção de confiança;
- Liderança sem centralização;
- Desenvolvimento de pessoas;
- Distribuição de responsabilidades;
- Comunicação com produto e liderança;
- Gestão de riscos;
- Planejamento de entregas complexas;
- Identificação e remoção de impedimentos;
- Feedback;
- Tomada de decisão sob pressão;
- Mediação de conflitos;
- Negociação de trade-offs;
- Segurança psicológica;
- Documentação de decisões técnicas.

---

# Roteiro Completo de Entrevista — Tech Lead de um Time Java

## Parte 3 de 10 — Perguntas 21 a 30

**Foco desta parte:** Java e Spring Boot aplicados à entrega de produtos, decisões técnicas, manutenção, integração, desempenho e confiabilidade.

> O objetivo destas perguntas não é avaliar apenas sintaxe ou fundamentos isolados de Java. O foco é entender como o candidato utiliza Java e Spring Boot para construir soluções sustentáveis, entregáveis, observáveis e alinhadas às necessidades do produto.

## Fluxo técnico de uma entrega Spring Boot

~~~mermaid
flowchart LR
    A[Requisito do produto] --> B[Modelagem da solução]
    B --> C[Contrato da API]
    C --> D[Implementação Spring Boot]
    D --> E[Testes automatizados]
    E --> F[Code review]
    F --> G[CI/CD]
    G --> H[Deploy controlado]
    H --> I[Observabilidade]
    I --> J[Feedback e evolução]
~~~

---

## Pergunta 21 — Estrutura de uma aplicação Spring Boot

**Nível:** Júnior  
**Categoria:** Java e Spring Boot aplicados

**Pergunta do entrevistador:**  

Como você estruturaria uma aplicação Spring Boot para evitar que controllers concentrem regras de negócio, acesso ao banco e integrações externas?

**O que essa pergunta avalia:**  

Avalia a compreensão de separação de responsabilidades, organização de código, manutenibilidade e capacidade de criar uma estrutura que facilite testes e evolução do produto.

**Resposta esperada:**  

Eu separaria as responsabilidades em camadas ou componentes com papéis claros. Uma estrutura possível seria:

- **Controller:** recebe requisições, valida entradas básicas e retorna respostas HTTP;
- **Service ou caso de uso:** coordena o fluxo da operação e aplica regras de negócio;
- **Domínio:** concentra comportamentos e regras próprias do negócio, quando aplicável;
- **Repository:** abstrai o acesso a dados;
- **Client ou adapter:** encapsula integrações externas;
- **Mapper:** converte entidades, objetos de domínio e DTOs;
- **Tratamento de exceções:** centraliza a conversão de erros para respostas HTTP;
- **Configuração:** concentra configurações técnicas da aplicação.

O objetivo não é criar camadas apenas por convenção, mas manter responsabilidades coesas e reduzir o acoplamento.

O controller não deveria decidir regras complexas, executar várias consultas, chamar diretamente serviços externos e montar toda a resposta manualmente. Ele deve funcionar como uma porta de entrada da aplicação.

**Explicação didática:**  

Separação de responsabilidades significa que cada componente deve ter uma responsabilidade principal. Isso facilita:

- Testar regras sem subir o servidor;
- Alterar a persistência sem modificar toda a aplicação;
- Substituir uma integração externa;
- Entender o impacto de uma mudança;
- Evitar duplicação de regras;
- Reduzir o tamanho dos controllers.

Uma aplicação pode utilizar arquitetura em camadas, arquitetura hexagonal, clean architecture ou outra abordagem. O mais importante é que a estrutura seja proporcional ao problema e que as dependências estejam bem definidas.

**Exemplo prático:**  

Uma operação de cancelamento de pedido poderia seguir este fluxo:

1. O controller recebe o identificador;
2. O service busca o pedido;
3. O domínio verifica se o cancelamento é permitido;
4. O service atualiza o pedido;
5. Um componente publica ou agenda uma integração;
6. O controller retorna a resposta adequada.

**Exemplo de código:**  

~~~java
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final CancelarPedidoUseCase cancelarPedidoUseCase;

    public PedidoController(CancelarPedidoUseCase cancelarPedidoUseCase) {
        this.cancelarPedidoUseCase = cancelarPedidoUseCase;
    }

    @PostMapping("/{id}/cancelamento")
    public ResponseEntity<Void> cancelar(
            @PathVariable Long id,
            Authentication authentication) {

        cancelarPedidoUseCase.executar(
                id,
                authentication.getName());

        return ResponseEntity.noContent().build();
    }
}
~~~

O controller apenas recebe os dados da requisição e delega a operação. A regra de cancelamento deve estar no caso de uso ou no domínio, e não no controller.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar a finalidade da separação de responsabilidades;
- Diferenciar controller, service, repository e integrações;
- Mostrar preocupação com testes e manutenção;
- Evitar criar camadas sem justificativa;
- Explicar que a arquitetura deve ser proporcional ao contexto;
- Apresentar um exemplo relacionado ao produto.

Deve evitar dizer que existe uma única estrutura obrigatória para todo projeto Spring Boot.

**Resposta fraca ou incompleta:**  

“Eu criaria as pastas controller, service e repository, seguindo o padrão do Spring.”

Essa resposta menciona uma estrutura comum, mas não explica responsabilidades, regras de negócio, testes ou integrações.

**Critérios de avaliação:**  

- **0** — Não compreende separação de responsabilidades.
- **1** — Coloca toda a lógica no controller.
- **2** — Conhece as camadas, mas não explica suas responsabilidades.
- **3** — Propõe uma separação básica e coerente.
- **4** — Relaciona a estrutura a testes, manutenção e evolução.
- **5** — Demonstra capacidade de escolher uma arquitetura proporcional, controlar acoplamento e preservar o foco no domínio e na entrega do produto.

**Perguntas de aprofundamento:**  

1. Em que situação uma arquitetura em camadas simples seria suficiente?
2. Como você testaria o caso de uso sem iniciar todo o contexto do Spring?
3. Como evitaria que a camada de service se transformasse em uma classe enorme?

---

## Pergunta 22 — Contrato e evolução de APIs REST

**Nível:** Júnior  
**Categoria:** APIs e integração

**Pergunta do entrevistador:**  

Quais decisões você considera importantes ao criar ou alterar uma API REST em Spring Boot que será consumida por outros sistemas?

**O que essa pergunta avalia:**  

Avalia a capacidade de tratar uma API como contrato, considerando compatibilidade, erros, validação, segurança, documentação e evolução.

**Resposta esperada:**  

Eu consideraria:

- Objetivo e consumidores da API;
- Recursos e operações disponíveis;
- Nomenclatura dos endpoints;
- Métodos HTTP;
- Códigos de status;
- Formato das requisições e respostas;
- Campos obrigatórios e opcionais;
- Validação;
- Paginação;
- Ordenação;
- Filtros;
- Autenticação e autorização;
- Tratamento de erros;
- Idempotência;
- Compatibilidade com versões anteriores;
- Documentação;
- Limites de uso;
- Logs e métricas.

Alterações incompatíveis devem ser evitadas sempre que possível. Adicionar um campo opcional normalmente é menos arriscado do que remover ou alterar o significado de um campo existente.

A API deve ser documentada e validada com testes, especialmente quando houver consumidores externos ou integração entre times.

**Explicação didática:**  

Uma API é um contrato entre sistemas. Quando um consumidor depende dela, uma alteração aparentemente pequena pode quebrar telas, integrações ou processos de negócio.

Por exemplo, alterar o tipo de um campo de número para texto ou mudar o significado de um código de status pode causar falhas mesmo que a aplicação continue compilando.

A evolução deve considerar compatibilidade, comunicação e estratégia de transição.

**Exemplo prático:**  

Uma resposta de erro consistente pode ser:

~~~json
{
  "timestamp": "2026-09-01T10:30:00Z",
  "status": 422,
  "code": "PEDIDO_NAO_CANCELAVEL",
  "message": "O pedido não pode ser cancelado no estado atual.",
  "traceId": "abc-123"
}
~~~

O consumidor consegue tratar o erro por meio de um código estável, enquanto a mensagem pode ser apresentada ao usuário ou registrada para diagnóstico.

**Exemplo de código:**  

~~~java
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(PedidoNaoCancelavelException.class)
    public ResponseEntity<ApiError> tratarPedidoNaoCancelavel(
            PedidoNaoCancelavelException exception,
            HttpServletRequest request) {

        ApiError error = new ApiError(
                422,
                "PEDIDO_NAO_CANCELAVEL",
                exception.getMessage(),
                request.getHeader("X-Trace-Id"));

        return ResponseEntity
                .unprocessableEntity()
                .body(error);
    }
}
~~~

O tratamento centralizado evita que cada controller produza respostas de erro diferentes para situações semelhantes.

**Como o candidato deve responder:**  

O candidato deve:

- Tratar a API como contrato;
- Falar sobre compatibilidade;
- Mencionar códigos HTTP e erros consistentes;
- Considerar validação, segurança e documentação;
- Explicar o impacto nos consumidores;
- Apresentar uma estratégia para mudanças incompatíveis.

Deve evitar responder apenas com a lista de métodos HTTP.

**Resposta fraca ou incompleta:**  

“Eu criaria um endpoint GET ou POST, definiria o JSON e colocaria uma documentação no Swagger.”

A resposta não aborda compatibilidade, erros, segurança, versionamento ou impacto nos consumidores.

**Critérios de avaliação:**  

- **0** — Não compreende o conceito de contrato de API.
- **1** — Foca apenas na criação do endpoint.
- **2** — Menciona métodos e respostas, mas ignora compatibilidade.
- **3** — Define uma API básica e documentada.
- **4** — Considera erros, segurança, validação e evolução.
- **5** — Demonstra visão de contrato, governança, compatibilidade e integração sustentável entre sistemas.

**Perguntas de aprofundamento:**  

1. Como faria uma alteração incompatível sem quebrar consumidores existentes?
2. Quando você criaria uma nova versão da API?
3. Como testaria o contrato entre dois serviços?

---

## Pergunta 23 — Tratamento de erros em aplicações Spring Boot

**Nível:** Pleno  
**Categoria:** Confiabilidade e troubleshooting

**Pergunta do entrevistador:**  

Como você definiria uma estratégia de tratamento de erros para uma aplicação Spring Boot que possui APIs, integrações externas e processamento assíncrono?

**O que essa pergunta avalia:**  

Avalia maturidade para tratar erros de forma consistente, distinguindo erros esperados, falhas técnicas, problemas temporários e situações que exigem ação operacional.

**Resposta esperada:**  

Eu começaria classificando os erros:

- Erros de validação de entrada;
- Falhas de autenticação ou autorização;
- Recursos inexistentes;
- Conflitos de estado;
- Erros de regra de negócio;
- Falhas temporárias de rede;
- Timeout;
- Indisponibilidade de dependências;
- Erros inesperados;
- Falhas de processamento assíncrono.

Para APIs síncronas, usaria respostas consistentes, códigos HTTP adequados, códigos internos estáveis e um identificador de correlação.

Para integrações externas, definiria:

- Timeout;
- Retry somente quando seguro;
- Backoff;
- Limite de tentativas;
- Circuit breaker quando apropriado;
- Fallback, se existir comportamento aceitável;
- Tratamento de duplicidade;
- Observabilidade;
- Estratégia de reprocessamento.

Para processamento assíncrono, consideraria:

- Dead-letter queue;
- Retentativas;
- Idempotência;
- Registro do erro;
- Alertas;
- Reprocessamento controlado;
- Limites para evitar loops infinitos.

Erros inesperados devem ser registrados com contexto suficiente, sem expor dados sensíveis ao consumidor.

**Explicação didática:**  

Nem todo erro deve ser tratado da mesma forma. Um campo inválido enviado pelo consumidor não é igual a uma indisponibilidade do banco ou a um timeout de um parceiro.

Também é perigoso aplicar retry indiscriminadamente. Repetir uma operação de cobrança sem garantir idempotência pode gerar duplicidade.

O tratamento correto depende do tipo de operação, da possibilidade de repetição, do impacto para o negócio e da capacidade de recuperação.

**Exemplo prático:**  

Em uma chamada para um provedor de pagamento:

- Timeout pode permitir uma nova tentativa apenas se houver uma chave idempotente;
- Erro de cartão recusado não deve ser repetido automaticamente;
- Indisponibilidade do provedor pode levar a processamento posterior;
- Resposta desconhecida pode exigir reconciliação.

**Exemplo de código:**  

~~~java
@Retry(name = "pagamento")
@CircuitBreaker(
        name = "pagamento",
        fallbackMethod = "processarIndisponibilidade")
public ResultadoPagamento autorizar(Pagamento pagamento) {
    return clientePagamento.autorizar(
            pagamento.idempotencyKey(),
            pagamento.valor());
}

private ResultadoPagamento processarIndisponibilidade(
        Pagamento pagamento,
        Exception exception) {

    // O fallback deve representar um comportamento de negócio válido.
    return ResultadoPagamento.emProcessamento(
            pagamento.getId());
}
~~~

A configuração de retry e circuit breaker deve considerar limites, métricas, tipos de exceção e impacto do fallback. Não basta adicionar anotações sem entender o comportamento da integração.

**Como o candidato deve responder:**  

O candidato deve:

- Classificar diferentes tipos de erro;
- Falar sobre respostas consistentes;
- Considerar timeout, retry e idempotência;
- Explicar o tratamento de mensagens com falha;
- Mencionar logs, métricas e correlação;
- Alertar que fallback não pode mascarar falhas;
- Relacionar a estratégia ao impacto do negócio.

Deve evitar afirmar que todo erro deve gerar HTTP 500 ou que todo erro de integração deve ser repetido automaticamente.

**Resposta fraca ou incompleta:**  

“Eu usaria try/catch e retornaria uma mensagem amigável. Para erros externos, tentaria novamente.”

Essa resposta não diferencia tipos de erro, não trata idempotência, observabilidade ou reprocessamento.

**Critérios de avaliação:**  

- **0** — Não apresenta estratégia de tratamento.
- **1** — Usa apenas try/catch de forma genérica.
- **2** — Menciona tratamento centralizado, mas ignora integração.
- **3** — Define respostas consistentes e diferencia erros básicos.
- **4** — Inclui timeout, retry, idempotência, métricas e reprocessamento.
- **5** — Demonstra uma estratégia completa, segura e alinhada ao impacto operacional e de negócio.

**Perguntas de aprofundamento:**  

1. Em quais situações um retry pode piorar o problema?
2. Como garantiria que uma operação de pagamento pudesse ser repetida com segurança?
3. Como monitoraria mensagens enviadas para uma fila de erro?

---

## Pergunta 24 — Transações e consistência no produto

**Nível:** Pleno  
**Categoria:** Persistência e consistência

**Pergunta do entrevistador:**  

Uma operação em Spring Boot atualiza o pedido no banco e depois chama um serviço externo. Como você avaliaria o uso de uma transação nesse fluxo?

**O que essa pergunta avalia:**  

Avalia compreensão sobre limites de transações, consistência, integração externa, falhas parciais e estratégias como outbox e processamento assíncrono.

**Resposta esperada:**  

Uma transação de banco não deve ser tratada como se pudesse incluir automaticamente uma chamada externa. A transação pode garantir atomicidade das alterações no banco, mas não consegue desfazer uma operação já realizada no serviço externo, a menos que exista um protocolo distribuído específico, que normalmente adiciona complexidade significativa.

Eu avaliaria o fluxo e perguntaria:

- O que precisa ser consistente imediatamente;
- Se a chamada externa é obrigatória para concluir a operação;
- Se o parceiro suporta idempotência;
- Se a operação externa pode ser repetida;
- O que ocorre se o banco confirmar e a chamada falhar;
- O que ocorre se a chamada confirmar e o banco falhar;
- Se o usuário pode receber um estado “em processamento”;
- Se há necessidade de reconciliação.

Uma abordagem comum é persistir a mudança local e registrar um evento ou intenção de publicação na mesma transação. Depois, um processo publica ou executa a integração. O padrão outbox é uma possibilidade para reduzir a chance de perder o evento.

Também podem ser usadas ações compensatórias, desde que o domínio permita desfazer a operação.

**Explicação didática:**  

Uma transação local pode proteger várias alterações dentro do mesmo banco. Porém, ela não torna automaticamente atômica uma chamada HTTP para outro sistema.

Exemplo:

1. O pedido é marcado como pago;
2. A chamada ao parceiro falha;
3. A transação local é revertida.

Nesse caso, o pedido pode continuar como não pago, mas o parceiro pode ter processado a cobrança se a falha ocorreu apenas na resposta. O sistema precisa lidar com esse tipo de incerteza.

**Exemplo prático:**  

Em uma compra, pode ser melhor:

1. Criar o pedido como “aguardando pagamento”;
2. Registrar o evento de pagamento;
3. Processar a autorização;
4. Atualizar o pedido conforme o retorno;
5. Reprocessar falhas temporárias;
6. Executar reconciliação para casos ambíguos.

**Exemplo de código:**  

~~~java
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final OutboxRepository outboxRepository;

    @Transactional
    public void criarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);

        OutboxEvent evento = OutboxEvent.criar(
                "PagamentoSolicitado",
                pedido.getId());

        // Pedido e evento são persistidos na mesma transação.
        outboxRepository.save(evento);
    }
}
~~~

Um publicador posterior lê os eventos pendentes e chama o serviço de pagamento. Esse publicador deve tratar duplicidade, falhas e reprocessamento.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar o limite da transação local;
- Identificar falhas parciais;
- Mencionar idempotência;
- Considerar outbox, eventos ou compensação;
- Diferenciar consistência imediata de eventual;
- Relacionar a solução ao impacto do produto.

Deve evitar afirmar que colocar `@Transactional` em um método resolve automaticamente toda a consistência entre banco e serviços externos.

**Resposta fraca ou incompleta:**  

“Eu colocaria `@Transactional` no método. Se a chamada externa falhar, tudo seria desfeito.”

Essa resposta ignora que a transação do banco não desfaz automaticamente uma operação externa.

**Critérios de avaliação:**  

- **0** — Não compreende o limite das transações.
- **1** — Acredita que `@Transactional` resolve todos os sistemas envolvidos.
- **2** — Reconhece falhas, mas não propõe estratégia.
- **3** — Diferencia transação local e integração externa.
- **4** — Considera idempotência, eventos, outbox e compensação.
- **5** — Demonstra visão madura sobre consistência, falhas parciais, reconciliação e experiência do usuário.

**Perguntas de aprofundamento:**  

1. Como trataria o caso em que o pagamento foi aprovado, mas a resposta não chegou?
2. Quando a consistência eventual seria aceitável?
3. Como evitaria que o mesmo evento fosse processado duas vezes?

---

## Pergunta 25 — Migrações de banco em aplicações Java

**Nível:** Pleno  
**Categoria:** Banco de dados e entrega

**Pergunta do entrevistador:**  

Como você conduziria uma alteração de banco de dados em uma aplicação Spring Boot que precisa continuar disponível durante o deploy?

**O que essa pergunta avalia:**  

Avalia capacidade de planejar mudanças compatíveis, reduzir risco de indisponibilidade e coordenar aplicação, banco e pipeline.

**Resposta esperada:**  

Eu preferiria uma estratégia expand-and-contract:

1. Adicionar a nova estrutura de forma compatível;
2. Publicar uma versão da aplicação que continue funcionando com o formato antigo;
3. Começar a escrever ou preencher os novos campos;
4. Migrar os dados gradualmente;
5. Validar a consistência;
6. Alterar a aplicação para utilizar a nova estrutura;
7. Remover a estrutura antiga apenas quando nenhum consumidor depender dela.

Eu também consideraria:

- Tempo da migração;
- Volume de dados;
- Locks;
- Índices;
- Espaço em disco;
- Impacto em consultas;
- Rollback;
- Compatibilidade entre versões;
- Execução em múltiplas instâncias;
- Monitoramento;
- Teste em uma cópia representativa dos dados.

As migrações deveriam ser versionadas, revisadas e executadas de forma controlada pelo pipeline ou por um processo operacional definido.

**Explicação didática:**  

Alterações destrutivas durante um deploy podem quebrar instâncias antigas que ainda estão rodando. Por isso, é importante que a aplicação nova e a antiga consigam coexistir durante a transição.

Por exemplo, remover imediatamente uma coluna utilizada pela versão anterior pode causar erro enquanto existem instâncias antigas ativas.

O rollback da aplicação também precisa ser considerado. Uma migração que remove dados ou colunas pode impedir o retorno simples à versão anterior.

**Exemplo prático:**  

Para renomear uma coluna:

1. Criar a nova coluna;
2. Manter a antiga temporariamente;
3. Fazer a aplicação escrever nas duas;
4. Migrar os registros antigos;
5. Fazer a aplicação ler da nova;
6. Monitorar;
7. Remover a antiga posteriormente.

**Exemplo de código:**  

~~~sql
-- Etapa 1: alteração compatível
ALTER TABLE pedido
ADD COLUMN status_detalhado VARCHAR(40);

-- Etapa posterior:
-- preencher status_detalhado gradualmente
-- alterar a aplicação para utilizá-lo
-- remover a coluna antiga somente após a transição
~~~

A sintaxe e o mecanismo exatos dependem do banco de dados e da ferramenta de migração adotada.

**Como o candidato deve responder:**  

O candidato deve:

- Falar sobre compatibilidade entre versões;
- Mencionar migrações incrementais;
- Considerar volume, lock e impacto;
- Incluir rollback ou plano de recuperação;
- Relacionar a mudança ao pipeline;
- Explicar que alterações destrutivas devem ser adiadas.

Deve evitar executar alterações manuais diretamente em produção sem controle, versionamento ou validação.

**Resposta fraca ou incompleta:**  

“Eu alteraria o banco antes do deploy e depois subiria a nova versão.”

Essa resposta não trata compatibilidade, indisponibilidade, rollback ou comportamento de instâncias antigas.

**Critérios de avaliação:**  

- **0** — Não considera risco de migração.
- **1** — Propõe alterações destrutivas imediatas.
- **2** — Menciona versionamento, mas não trata compatibilidade.
- **3** — Propõe uma migração controlada.
- **4** — Considera expansão, transição, rollback e impacto operacional.
- **5** — Demonstra domínio de evolução segura de banco, compatibilidade entre versões e implantação sem indisponibilidade desnecessária.

**Perguntas de aprofundamento:**  

1. Como faria uma migração de milhões de registros?
2. O que faria se a migração demorasse mais que a janela de deploy?
3. Como verificaria se a aplicação antiga continua compatível?

---

## Pergunta 26 — Desempenho de uma API Spring Boot

**Nível:** Pleno  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  

Uma API Spring Boot passou a apresentar aumento no tempo de resposta após o crescimento do volume de dados. Como você investigaria o problema antes de propor mudanças?

**O que essa pergunta avalia:**  

Avalia investigação orientada por evidências, compreensão de gargalos e capacidade de evitar otimizações baseadas apenas em suposições.

**Resposta esperada:**  

Eu começaria definindo o problema com métricas:

- Percentis de latência, especialmente p95 e p99;
- Taxa de erro;
- Volume de requisições;
- Consumo de CPU e memória;
- Tempo de consultas;
- Número de chamadas externas;
- Uso de conexões;
- Filas e threads;
- Comportamento por endpoint;
- Momento em que a degradação começou.

Depois, utilizaria logs estruturados, traces distribuídos, métricas da aplicação e análise do banco para identificar o gargalo.

Eu investigaria hipóteses como:

- Consulta sem índice;
- N+1 queries;
- Paginação inadequada;
- Payload excessivo;
- Processamento síncrono demorado;
- Pool de conexões insuficiente;
- Dependência externa lenta;
- Serialização custosa;
- Falta de cache;
- Contenção de recursos;
- Alteração recente no código.

Somente depois escolheria uma solução. Cache, por exemplo, pode reduzir latência, mas também introduz invalidação, consumo de memória e risco de dados desatualizados.

**Explicação didática:**  

O tempo de resposta percebido pelo cliente é composto por várias partes:

- Entrada na aplicação;
- Autenticação;
- Processamento;
- Banco;
- Integrações;
- Serialização;
- Rede.

O gargalo precisa ser medido. Otimizar uma parte que não representa a maior parcela do tempo pode não trazer benefício relevante.

Percentis são importantes porque a média pode esconder uma parcela de requisições muito lentas.

**Exemplo prático:**  

Uma consulta que retorna 20 itens pode executar centenas de consultas adicionais por causa de carregamento inadequado de relacionamentos. A solução pode envolver:

- Ajuste da consulta;
- Projeção específica;
- Paginação;
- Revisão do mapeamento;
- Índices;
- Redução dos dados retornados.

**Exemplo de código:**  

~~~java
public Page<PedidoResumo> buscarPedidos(
        Pageable pageable) {

    return pedidoRepository.buscarResumo(pageable);
}
~~~

Uma projeção pode evitar carregar uma entidade completa quando a API precisa apenas de alguns campos:

~~~java
public interface PedidoResumo {
    Long getId();
    String getStatus();
    BigDecimal getValor();
}
~~~

A decisão deve ser validada com métricas e testes de desempenho. A implementação exata depende do banco, do ORM e do padrão de consulta.

**Como o candidato deve responder:**  

O candidato deve:

- Começar por métricas e evidências;
- Considerar aplicação, banco e dependências;
- Mencionar percentis e traces;
- Falar sobre N+1, índices e paginação;
- Avaliar trade-offs de cache;
- Validar a solução após a mudança.

Deve evitar dizer imediatamente que usaria cache ou aumentaria a infraestrutura sem identificar o gargalo.

**Resposta fraca ou incompleta:**  

“Eu aumentaria a memória da aplicação e colocaria cache para responder mais rápido.”

Essa resposta pode mascarar o problema e não comprova que o gargalo está na memória ou na ausência de cache.

**Critérios de avaliação:**  

- **0** — Não apresenta método de investigação.
- **1** — Sugere apenas aumentar infraestrutura.
- **2** — Menciona logs, mas não identifica métricas relevantes.
- **3** — Investiga consultas, latência e consumo de recursos.
- **4** — Utiliza métricas, traces, análise de banco e testes de desempenho.
- **5** — Demonstra abordagem orientada a evidências, entende trade-offs e valida o impacto da otimização.

**Perguntas de aprofundamento:**  

1. Como identificaria um problema de N+1 queries?
2. Quando o cache poderia piorar o sistema?
3. Como provaria que a alteração melhorou a API?

---

## Pergunta 27 — Injeção de dependências e testabilidade

**Nível:** Júnior  
**Categoria:** Boas práticas e testes

**Pergunta do entrevistador:**  

Por que a injeção de dependências é importante em uma aplicação Spring Boot? Como ela influencia a testabilidade e a manutenção do sistema?

**O que essa pergunta avalia:**  

Avalia compreensão sobre baixo acoplamento, inversão de dependência, substituição de implementações e facilidade de testes.

**Resposta esperada:**  

A injeção de dependências permite que uma classe receba os componentes de que precisa, em vez de criá-los diretamente. Isso reduz acoplamento e facilita substituir uma implementação por outra.

A injeção pelo construtor geralmente é preferível porque:

- Torna as dependências explícitas;
- Permite declarar atributos como imutáveis;
- Facilita testes unitários;
- Evita objetos parcialmente inicializados;
- Ajuda a identificar classes com responsabilidades excessivas.

Durante um teste, uma dependência real pode ser substituída por um stub, fake ou mock, dependendo do objetivo.

**Explicação didática:**  

Uma classe que cria diretamente um cliente HTTP, um repository e um relógio fica difícil de testar e modificar.

Com injeção de dependências, a classe depende de abstrações ou componentes fornecidos externamente. Isso permite controlar o cenário de teste e trocar detalhes técnicos sem alterar a regra de negócio.

A injeção de dependências não resolve automaticamente todos os problemas de design. Se uma classe recebe muitas dependências, isso pode indicar responsabilidades demais.

**Exemplo prático:**  

Um serviço de pedidos pode receber:

- Repositório de pedidos;
- Relógio;
- Cliente de pagamento;
- Publicador de eventos.

Nos testes, cada dependência pode ser controlada de acordo com o cenário.

**Exemplo de código:**  

~~~java
@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final Clock clock;

    public PedidoService(
            PedidoRepository repository,
            Clock clock) {
        this.repository = repository;
        this.clock = clock;
    }

    public Pedido criar(NovoPedidoCommand command) {
        Instant criadoEm = Instant.now(clock);

        Pedido pedido = Pedido.criar(
                command.itens(),
                criadoEm);

        return repository.save(pedido);
    }
}
~~~

O serviço não cria seu próprio `Clock`, o que permite utilizar um horário controlado nos testes.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar baixo acoplamento;
- Defender a injeção pelo construtor;
- Relacionar a prática à testabilidade;
- Explicar a diferença entre criar uma dependência e recebê-la;
- Reconhecer que muitas dependências podem indicar um problema de design.

Deve evitar dizer que a injeção de dependências serve apenas para “o Spring encontrar os beans”.

**Resposta fraca ou incompleta:**  

“Usamos injeção de dependências porque é o padrão do Spring e facilita a configuração.”

A resposta não explica acoplamento, testes ou manutenção.

**Critérios de avaliação:**  

- **0** — Não compreende o conceito.
- **1** — Apenas repete que o Spring injeta objetos.
- **2** — Reconhece o benefício, mas não explica testabilidade.
- **3** — Explica corretamente a injeção pelo construtor.
- **4** — Relaciona a prática a baixo acoplamento e testes.
- **5** — Demonstra entendimento de design, composição, abstrações e sinais de responsabilidades excessivas.

**Perguntas de aprofundamento:**  

1. Por que a injeção pelo construtor costuma ser preferível à injeção em atributos?
2. Quando você usaria um fake em vez de um mock?
3. O que indicaria que uma classe possui dependências demais?

---

## Pergunta 28 — Configuração e ambientes

**Nível:** Pleno  
**Categoria:** Configuração e entrega

**Pergunta do entrevistador:**  

Como você organizaria as configurações de uma aplicação Spring Boot para que ela funcione em desenvolvimento, teste, homologação e produção sem duplicar código ou expor segredos?

**O que essa pergunta avalia:**  

Avalia práticas de configuração, separação entre código e ambiente, segurança de segredos e confiabilidade da implantação.

**Resposta esperada:**  

Eu separaria configuração de código e evitaria valores específicos de ambiente embutidos na aplicação.

Consideraria:

- Arquivos de configuração por perfil quando apropriado;
- Variáveis de ambiente;
- Configuração externa;
- Secret managers;
- Valores padrão seguros;
- Validação de propriedades obrigatórias;
- Separação entre configuração funcional e segredo;
- Controle de acesso;
- Auditoria;
- Rotação de credenciais;
- Máscara de valores sensíveis nos logs;
- Paridade entre ambientes.

Senhas, tokens, certificados e chaves não devem ser versionados no repositório nem impressos no pipeline.

Também evitaria excesso de diferenças entre ambientes. Quanto mais a produção divergir dos ambientes de validação, maior o risco de falhas inesperadas.

**Explicação didática:**  

O mesmo artefato da aplicação deve poder ser promovido entre ambientes, recebendo configurações diferentes conforme o destino.

O código define o comportamento. O ambiente fornece informações como:

- URL de banco;
- Nome de fila;
- Limites;
- Ativação de funcionalidades;
- Credenciais;
- Endpoints externos.

É importante validar configurações durante a inicialização para falhar de forma clara quando algo essencial estiver ausente ou inválido.

**Exemplo prático:**  

Uma configuração pode indicar a URL de um serviço externo:

~~~yaml
pagamento:
  base-url: ${PAGAMENTO_BASE_URL}
  timeout: ${PAGAMENTO_TIMEOUT:2s}
~~~

A credencial correspondente deveria ser fornecida por um mecanismo seguro de secrets, não armazenada nesse arquivo.

**Exemplo de código:**  

~~~java
@ConfigurationProperties(prefix = "pagamento")
@Validated
public record PagamentoProperties(
        @NotBlank String baseUrl,
        @NotNull Duration timeout
) {
}
~~~

A validação ajuda a impedir que a aplicação suba com uma configuração essencial ausente.

**Como o candidato deve responder:**  

O candidato deve:

- Separar código de configuração;
- Mencionar variáveis de ambiente ou configuração externa;
- Proteger secrets;
- Falar sobre validação;
- Considerar diferenças entre ambientes;
- Relacionar configuração ao pipeline e ao deploy.

Deve evitar colocar senhas em arquivos versionados, imagens ou logs.

**Resposta fraca ou incompleta:**  

“Eu criaria um arquivo `application-prod.yml` com todas as configurações de produção, incluindo as senhas.”

Essa abordagem expõe segredos e cria risco de vazamento no repositório ou no artefato.

**Critérios de avaliação:**  

- **0** — Não reconhece o risco de configuração inadequada.
- **1** — Versiona segredos junto com o código.
- **2** — Usa perfis, mas não protege credenciais.
- **3** — Separa configurações por ambiente.
- **4** — Inclui secrets, validação e configuração externa.
- **5** — Demonstra maturidade em segurança, governança, paridade entre ambientes e entrega confiável.

**Perguntas de aprofundamento:**  

1. Como impediria que um segredo aparecesse nos logs do pipeline?
2. O que faria se a aplicação subisse com uma configuração incorreta?
3. Como testaria a configuração antes de chegar à produção?

---

## Pergunta 29 — Atualização de versão do Spring Boot

**Nível:** Sênior  
**Categoria:** Evolução tecnológica

**Pergunta do entrevistador:**  

Você precisa atualizar uma aplicação de uma versão antiga do Spring Boot para uma versão mais recente. Como planejaria a evolução sem transformar a atualização em uma grande mudança sem controle?

**O que essa pergunta avalia:**  

Avalia planejamento de modernização, gestão de compatibilidade, análise de riscos, estratégia incremental e capacidade de coordenar uma mudança relevante.

**Resposta esperada:**  

Eu começaria levantando o estado atual:

- Versão do Java;
- Versão do Spring Boot;
- Dependências diretas e transitivas;
- Bibliotecas abandonadas;
- Uso de APIs depreciadas;
- Integrações externas;
- Cobertura e estabilidade dos testes;
- Configurações específicas;
- Forma de empacotamento e deploy;
- Métricas e incidentes atuais.

Depois, analisaria o guia de migração da versão-alvo e os pontos que podem exigir alterações, como:

- Mudanças de APIs;
- Alterações no namespace;
- Compatibilidade com bibliotecas;
- Segurança;
- Configuração;
- Observabilidade;
- Comportamento de persistência;
- Requisitos mínimos de Java.

Eu criaria uma estratégia em etapas:

1. Definir versão-alvo e critérios de sucesso;
2. Criar testes de caracterização dos fluxos críticos;
3. Atualizar dependências em uma branch controlada;
4. Corrigir incompatibilidades pequenas;
5. Executar testes e análise estática;
6. Validar integrações;
7. Implantar em ambiente controlado;
8. Fazer rollout gradual;
9. Monitorar;
10. Remover compatibilidades temporárias.

Se a atualização for muito grande, avaliaria etapas intermediárias ou isolamento de partes do sistema. A decisão deve considerar suporte, risco de segurança, custo de manutenção e benefício esperado.

**Explicação didática:**  

Atualizar uma dependência central pode afetar várias partes do sistema. O risco não está apenas na compilação: mudanças podem aparecer em runtime, na configuração, na serialização, no acesso a dados ou no comportamento de segurança.

Uma atualização bem conduzida deve permitir identificar rapidamente:

- O que mudou;
- Qual comportamento foi afetado;
- Como reverter;
- Se o ganho justifica o custo;
- Quais riscos permanecem.

A existência de testes confiáveis, observabilidade e implantação gradual reduz significativamente o risco.

**Exemplo prático:**  

Se a migração envolve mudança de APIs Java EE para APIs Jakarta, o time deve avaliar imports, dependências, servidores, bibliotecas de persistência, validação, segurança e integrações que dependam desses tipos.

A migração não deve ser tratada apenas como uma substituição automática de textos.

**Exemplo de código:**  

Uma validação de compatibilidade pode ser incluída no pipeline:

~~~yaml
stages:
  - compile
  - test
  - compatibility
  - package

compatibility:
  script:
    - ./mvnw verify
    - ./mvnw dependency:tree
    - ./mvnw enforcer:enforce
~~~

A configuração exata dependerá do pipeline e das ferramentas adotadas. O importante é tornar incompatibilidades detectáveis antes da implantação.

**Como o candidato deve responder:**  

O candidato deve:

- Começar pelo inventário e pelos riscos;
- Consultar documentação oficial da versão-alvo;
- Considerar Java, dependências e integrações;
- Criar testes de caracterização;
- Propor evolução incremental;
- Planejar rollout e rollback;
- Relacionar a atualização a segurança, suporte e custo.

Deve evitar propor uma atualização ampla sem testes, métricas ou estratégia de recuperação.

**Resposta fraca ou incompleta:**  

“Eu atualizaria a versão no arquivo de dependências, corrigiria os erros de compilação e faria o deploy.”

Essa resposta ignora mudanças de comportamento, testes, integrações e riscos operacionais.

**Critérios de avaliação:**  

- **0** — Não apresenta estratégia de atualização.
- **1** — Trata a mudança como alteração simples de versão.
- **2** — Considera compilação e testes básicos, mas ignora runtime.
- **3** — Planeja atualização com validações e correções.
- **4** — Inclui inventário, compatibilidade, rollout e rollback.
- **5** — Demonstra visão estratégica, evolução incremental, gestão de risco e capacidade de justificar o investimento tecnológico.

**Perguntas de aprofundamento:**  

1. Como decidiria se a atualização vale o investimento?
2. O que faria se os testes atuais fossem insuficientes?
3. Como reduziria o risco caso a versão atual estivesse sem suporte de segurança?

---

## Pergunta 30 — Decisão entre solução simples e arquitetura mais sofisticada

**Nível:** Sênior  
**Categoria:** Arquitetura e tomada de decisão

**Pergunta do entrevistador:**  

O time precisa implementar uma nova funcionalidade em uma aplicação Spring Boot. Uma proposta utiliza uma solução síncrona simples em um único serviço; outra propõe separar componentes, usar mensageria e adotar processamento assíncrono. Como você decidiria entre as alternativas?

**O que essa pergunta avalia:**  

Avalia visão arquitetural, análise de trade-offs, capacidade de evitar complexidade desnecessária e alinhamento entre arquitetura e necessidades reais do produto.

**Resposta esperada:**  

Eu começaria pelos requisitos e restrições:

- Volume atual e crescimento esperado;
- Tempo de resposta necessário;
- Necessidade de resposta imediata;
- Tolerância a processamento posterior;
- Impacto de falhas;
- Necessidade de reprocessamento;
- Requisitos de disponibilidade;
- Consistência esperada;
- Capacidade operacional do time;
- Custo;
- Prazo;
- Conhecimento existente;
- Necessidade de escalar partes de forma independente.

A solução síncrona e simples pode ser preferível quando o fluxo é pequeno, o processamento é rápido, a consistência imediata é importante e a operação precisa ser simples.

A solução assíncrona e distribuída pode fazer sentido quando:

- O processamento é demorado;
- Há picos de volume;
- É necessário desacoplar componentes;
- O consumidor pode receber o resultado depois;
- Falhas temporárias precisam ser reprocessadas;
- Partes do sistema possuem escalabilidade diferente.

Por outro lado, mensageria aumenta a complexidade. É necessário tratar:

- Duplicidade;
- Ordenação;
- Retentativas;
- Mensagens inválidas;
- Dead-letter queue;
- Observabilidade;
- Rastreamento;
- Consistência eventual;
- Operação da infraestrutura;
- Evolução dos contratos.

Eu escolheria a solução mais simples que atenda aos requisitos atuais e futuros razoavelmente previsíveis. Se houver incerteza, faria um experimento ou adotaria uma evolução em fases.

**Explicação didática:**  

Arquiteturas distribuídas podem resolver problemas importantes, mas não são gratuitas. Elas aumentam a quantidade de estados, falhas possíveis e componentes que o time precisa operar.

Uma solução simples não é necessariamente inferior. Se atende ao volume, ao prazo, à confiabilidade necessária e à capacidade do time, pode ser a melhor decisão.

A arquitetura deve ser guiada pelo problema, não pela preferência por uma tecnologia específica.

**Exemplo prático:**  

Para registrar uma alteração simples de cadastro, uma operação síncrona pode ser suficiente.

Para processar documentos, enviar notificações em grande volume ou integrar com parceiros instáveis, o processamento assíncrono pode reduzir o acoplamento e permitir retentativas.

Também é possível combinar as abordagens:

1. A API registra a solicitação rapidamente;
2. O usuário recebe um identificador;
3. O processamento ocorre em segundo plano;
4. O status pode ser consultado;
5. O sistema publica o resultado quando concluído.

**Exemplo de código:**  

Um contrato assíncrono poderia ser representado assim:

~~~java
public record ProcessamentoResponse(
        UUID processamentoId,
        String status
) {
}
~~~

A API pode responder com o status `RECEBIDO`, enquanto o processamento continua. Entretanto, o desenho completo precisará definir persistência do estado, retentativas, idempotência e observabilidade.

**Como o candidato deve responder:**  

O candidato deve:

- Começar pelos requisitos;
- Comparar simplicidade e escalabilidade;
- Considerar custo operacional;
- Falar sobre consistência e experiência do usuário;
- Mencionar falhas, reprocessamento e observabilidade;
- Evitar soluções sofisticadas sem necessidade;
- Explicar como evoluiria a solução posteriormente.

Deve evitar responder que microsserviços ou mensageria são sempre mais escaláveis ou modernos e, por isso, obrigatoriamente melhores.

**Resposta fraca ou incompleta:**  

“Eu escolheria mensageria porque é mais escalável e desacopla os serviços.”

A resposta não considera volume, necessidade de resposta imediata, custo, consistência, operação ou maturidade do time.

**Critérios de avaliação:**  

- **0** — Escolhe uma solução sem critérios.
- **1** — Decide por moda ou preferência tecnológica.
- **2** — Compara apenas desempenho e escalabilidade.
- **3** — Considera requisitos básicos, prazo e complexidade.
- **4** — Analisa operação, falhas, consistência, custo e evolução.
- **5** — Demonstra visão sistêmica, escolhe a menor complexidade adequada e explicita claramente os trade-offs e condições para revisar a decisão.

**Perguntas de aprofundamento:**  

1. Em que situação uma solução assíncrona prejudicaria a experiência do usuário?
2. Como garantiria idempotência no processamento de mensagens?
3. Que métricas indicariam que a arquitetura escolhida não está mais adequada?
4. Como apresentaria essa decisão para pessoas não técnicas?

---

# Resumo desta parte

| Item | Resultado |
|---|---|
| Perguntas apresentadas | 21 a 30 |
| Níveis abordados | Júnior, Pleno e Sênior |
| Temas principais | Estrutura Spring Boot, APIs, tratamento de erros, transações, banco, desempenho, configuração, migração e decisões arquiteturais |
| Perguntas restantes | 70 |

## Competências exploradas

- Estruturação de aplicações Spring Boot;
- Separação de responsabilidades;
- Evolução de contratos de API;
- Tratamento de falhas;
- Integração com sistemas externos;
- Consistência e transações;
- Migração segura de banco;
- Investigação de desempenho;
- Configuração por ambiente;
- Proteção de segredos;
- Atualização tecnológica;
- Escolha entre soluções simples e distribuídas;
- Análise de trade-offs;
- Capacidade de conectar decisões técnicas à entrega do produto.

---

# Roteiro Completo de Entrevista — Tech Lead de um Time Java

## Parte 4 de 10 — Perguntas 31 a 40

**Foco desta parte:** arquitetura, integração entre sistemas, escalabilidade, resiliência, segurança arquitetural e tomada de decisões técnicas.

> As perguntas consideram um Tech Lead responsável por orientar um time Java com Spring Boot, participar das decisões arquiteturais e garantir a entrega, operação e evolução do produto.

## Fluxo de decisão arquitetural

~~~mermaid
flowchart TD
    A[Problema do produto] --> B[Requisitos funcionais]
    A --> C[Requisitos não funcionais]
    B --> D[Alternativas técnicas]
    C --> D
    D --> E[Análise de custos e riscos]
    E --> F[Decisão arquitetural]
    F --> G[Implementação incremental]
    G --> H[Observabilidade e validação]
    H --> I{Resultado adequado?}
    I -->|Sim| J[Documentar e padronizar]
    I -->|Não| K[Revisar decisão]
    K --> D
~~~

---

## Pergunta 31 — Documentação de decisões arquiteturais

**Nível:** Pleno  
**Categoria:** Arquitetura e governança técnica

**Pergunta do entrevistador:**  

Como você documentaria uma decisão arquitetural importante tomada pelo time, como a escolha entre comunicação síncrona via HTTP e comunicação assíncrona por eventos?

**O que essa pergunta avalia:**  

Avalia a capacidade de registrar decisões técnicas de forma objetiva, compartilhar contexto e evitar que o time precise rediscutir continuamente as mesmas alternativas.

**Resposta esperada:**  

Eu utilizaria um registro de decisão arquitetural, frequentemente chamado de ADR, contendo pelo menos:

- Título da decisão;
- Data;
- Status;
- Contexto;
- Problema que precisa ser resolvido;
- Requisitos e restrições;
- Alternativas consideradas;
- Critérios de avaliação;
- Decisão escolhida;
- Consequências positivas;
- Consequências negativas;
- Riscos;
- Premissas;
- Condições para revisar a decisão;
- Pessoas envolvidas.

Por exemplo, se o time escolheu eventos assíncronos, eu registraria por que a resposta imediata não era necessária, qual volume era esperado, quais falhas precisavam ser reprocessadas e qual custo operacional seria aceito.

O documento não precisa prever todas as situações futuras. Ele deve registrar o raciocínio disponível no momento da decisão.

**Explicação didática:**  

Uma decisão arquitetural sem contexto pode parecer arbitrária no futuro. Pessoas que não participaram da discussão podem questionar a escolha sem saber quais restrições existiam.

Documentar não significa criar documentação burocrática para cada detalhe. A documentação deve ser proporcional ao impacto e à durabilidade da decisão.

Um registro simples pode responder:

> “Por que escolhemos esta solução, quais alternativas foram rejeitadas e em que condições deveríamos reconsiderá-la?”

Também é importante atualizar o status quando a decisão deixar de ser válida.

**Exemplo prático:**  

Uma decisão poderia ser:

> “Utilizar comunicação assíncrona para envio de notificações porque o usuário não precisa receber a confirmação imediatamente e o provedor externo apresenta instabilidade. A solução exige idempotência, monitoramento da fila e processo de reprocessamento.”

**Exemplo de código:**  

Um registro simplificado poderia ser escrito em Markdown:

~~~markdown
# ADR-012 — Processamento assíncrono de notificações

## Status
Aceita

## Contexto
O envio de notificações depende de um provedor externo instável.
A indisponibilidade do provedor não deve bloquear a criação do pedido.

## Decisão
Publicar um evento após a criação do pedido e processar a notificação
de forma assíncrona.

## Consequências
- O pedido não fica bloqueado pela notificação.
- O usuário pode receber a notificação posteriormente.
- Será necessário monitorar filas e falhas.
- O consumidor deverá ser idempotente.
~~~

**Como o candidato deve responder:**  

O candidato deve:

- Explicar o propósito de registrar decisões;
- Apresentar uma estrutura objetiva;
- Mencionar contexto, alternativas e consequências;
- Demonstrar que a decisão pode ser revisitada;
- Evitar transformar o documento em uma especificação completa da aplicação;
- Relacionar a documentação à comunicação e à governança técnica.

Deve evitar registrar apenas:

> “Escolhemos Kafka porque é mais escalável.”

Essa justificativa é insuficiente e não explica o problema, os critérios ou os custos da escolha.

**Resposta fraca ou incompleta:**  

“Eu documentaria a arquitetura em um diagrama e colocaria no repositório.”

O diagrama pode ser útil, mas não registra necessariamente o contexto, as alternativas e os trade-offs.

**Critérios de avaliação:**  

- **0** — Não vê valor na documentação de decisões.
- **1** — Registra apenas a tecnologia escolhida.
- **2** — Cria diagramas, mas não documenta contexto ou consequências.
- **3** — Registra problema, decisão e justificativa.
- **4** — Inclui alternativas, riscos, consequências e condições de revisão.
- **5** — Demonstra governança leve, comunicação clara e preocupação com a evolução da arquitetura.

**Perguntas de aprofundamento:**  

1. Quando uma decisão deveria ser revisitada?
2. Como evitar que ADRs se tornem documentação desatualizada?
3. Como comunicaria uma decisão arquitetural para pessoas não técnicas?

---

## Pergunta 32 — Integração síncrona com serviço externo

**Nível:** Pleno  
**Categoria:** Integração e resiliência

**Pergunta do entrevistador:**  

Uma aplicação Spring Boot precisa consultar um serviço externo para concluir uma operação do usuário. Como você desenharia essa integração para reduzir o impacto de falhas e lentidão do parceiro?

**O que essa pergunta avalia:**  

Avalia compreensão sobre integração resiliente, timeouts, retries, circuit breakers, idempotência, observabilidade e experiência do usuário.

**Resposta esperada:**  

Eu começaria entendendo o comportamento esperado da integração:

- A resposta externa é obrigatória?
- Qual tempo de resposta é aceitável?
- O usuário pode continuar sem a resposta?
- O parceiro garante idempotência?
- Quais erros são temporários?
- Quais erros são definitivos?
- Existe limite de requisições?
- O serviço possui contrato de disponibilidade?
- Como será feita a reconciliação?

A integração deveria definir explicitamente:

- Timeout de conexão;
- Timeout de leitura;
- Limite de conexões;
- Retry apenas para erros seguros e temporários;
- Backoff entre tentativas;
- Circuit breaker;
- Controle de concorrência;
- Fallback válido para o negócio;
- Idempotency key quando necessário;
- Logs, métricas e traces;
- Tratamento de respostas inesperadas.

Eu evitaria manter transações de banco abertas durante chamadas externas demoradas. Também avaliaria se o processo deveria ser assíncrono.

**Explicação didática:**  

Uma dependência externa deve ser tratada como potencialmente lenta, indisponível ou inconsistente. Se a aplicação esperar indefinidamente por ela, pode consumir threads, conexões e memória até afetar todo o sistema.

O timeout limita o tempo de espera. O retry pode ajudar em falhas transitórias, mas pode piorar o problema se for aplicado sem limite.

O circuit breaker interrompe temporariamente chamadas para uma dependência que está falhando, dando tempo para sua recuperação e protegendo a aplicação chamadora.

**Exemplo prático:**  

Em uma integração de consulta de crédito:

- Erro de validação não deve gerar retry;
- Timeout pode ser repetido uma vez, se a operação for segura;
- Indisponibilidade prolongada pode gerar status “em análise”;
- O usuário deve receber uma mensagem clara;
- O sistema precisa permitir consulta posterior do resultado.

**Exemplo de código:**  

~~~java
@Service
public class ConsultaCreditoService {

    private final ClienteCredito clienteCredito;

    public ConsultaCreditoService(ClienteCredito clienteCredito) {
        this.clienteCredito = clienteCredito;
    }

    @Retry(name = "credito")
    @CircuitBreaker(
            name = "credito",
            fallbackMethod = "fallback")
    public ResultadoCredito consultar(
            Cliente cliente) {

        return clienteCredito.consultar(cliente.documento());
    }

    private ResultadoCredito fallback(
            Cliente cliente,
            Exception exception) {

        // O fallback precisa representar uma decisão válida
        // para o negócio. Não deve ocultar a falha.
        return ResultadoCredito.emAnalise();
    }
}
~~~

As configurações reais de timeout, tentativas e circuit breaker precisam ser definidas com base no comportamento do parceiro e no risco da operação.

**Como o candidato deve responder:**  

O candidato deve:

- Começar pelos requisitos do negócio;
- Definir timeouts;
- Diferenciar erros temporários e permanentes;
- Falar sobre retry com limites e backoff;
- Considerar idempotência;
- Mencionar circuit breaker e fallback;
- Explicar como monitoraria a integração;
- Avaliar se o fluxo deveria ser assíncrono.

Deve evitar afirmar que basta utilizar retry para tornar a integração resiliente.

**Resposta fraca ou incompleta:**  

“Eu faria uma chamada HTTP e, se desse erro, tentaria novamente algumas vezes.”

Essa resposta não considera timeout, duplicidade, classificação de erros, impacto no usuário ou proteção da aplicação.

**Critérios de avaliação:**  

- **0** — Não reconhece os riscos de integrações externas.
- **1** — Faz chamada sem timeout ou controle.
- **2** — Menciona retry, mas sem critérios.
- **3** — Define timeout, tratamento de erros e logs básicos.
- **4** — Inclui circuit breaker, idempotência, observabilidade e fallback.
- **5** — Demonstra visão completa de resiliência, experiência do usuário e operação da integração.

**Perguntas de aprofundamento:**  

1. Quando o retry poderia causar duplicidade?
2. Como definiria um timeout adequado?
3. Como diferenciaria uma falha do parceiro de uma falha da própria aplicação?

---

## Pergunta 33 — Comunicação assíncrona e processamento de eventos

**Nível:** Pleno  
**Categoria:** Arquitetura orientada a eventos

**Pergunta do entrevistador:**  

Em quais situações você recomendaria utilizar eventos assíncronos em um produto Java e Spring Boot? Quais problemas adicionais essa decisão introduz?

**O que essa pergunta avalia:**  

Avalia compreensão sobre comunicação assíncrona, desacoplamento, consistência eventual, processamento de mensagens e complexidade operacional.

**Resposta esperada:**  

Eu consideraria eventos assíncronos quando:

- O processamento puder ocorrer posteriormente;
- O fluxo for demorado;
- Houver necessidade de desacoplar produtores e consumidores;
- Existirem picos de carga;
- O consumidor puder processar em ritmo próprio;
- Falhas temporárias precisarem de reprocessamento;
- Vários consumidores precisarem reagir ao mesmo fato;
- A disponibilidade de uma dependência não puder bloquear o fluxo principal.

Porém, eventos assíncronos introduzem desafios:

- Consistência eventual;
- Duplicidade;
- Ordenação;
- Mensagens fora de sequência;
- Reprocessamento;
- Eventos inválidos;
- Dead-letter queue;
- Evolução do contrato;
- Observabilidade distribuída;
- Rastreamento;
- Controle de backlog;
- Operação da infraestrutura.

O consumidor deve ser idempotente sempre que o sistema puder entregar uma mensagem mais de uma vez. Também é necessário definir o que acontece quando o processamento falha permanentemente.

**Explicação didática:**  

Em um fluxo síncrono, quem faz a requisição normalmente espera a resposta. Em um fluxo assíncrono, o produtor registra ou publica uma solicitação e o processamento ocorre depois.

Isso melhora o desacoplamento, mas muda a experiência do usuário. O sistema pode precisar informar:

- Solicitação recebida;
- Processamento em andamento;
- Processamento concluído;
- Falha que exige ação.

A comunicação assíncrona não elimina a necessidade de confiabilidade. Ela apenas desloca parte da complexidade para filas, consumidores, reprocessamento e monitoramento.

**Exemplo prático:**  

Após criar um pedido, o sistema pode publicar um evento:

~~~text
PedidoCriado
  ├── Serviço de estoque reserva os itens
  ├── Serviço de notificação envia uma mensagem
  └── Serviço de análise registra o comportamento
~~~

O pedido pode ser criado sem esperar que todos os consumidores concluam seu trabalho.

**Exemplo de código:**  

~~~java
public record PedidoCriadoEvent(
        UUID eventoId,
        Long pedidoId,
        Instant criadoEm
) {
}

@Component
public class NotificacaoPedidoListener {

    @EventListener
    public void processar(PedidoCriadoEvent evento) {
        // O consumidor deve verificar duplicidade quando necessário.
        // Também deve registrar falhas e permitir reprocessamento.
        enviarNotificacao(evento.pedidoId());
    }

    private void enviarNotificacao(Long pedidoId) {
        // Integração com o serviço de notificações.
    }
}
~~~

Em sistemas distribuídos, um mecanismo de mensageria apropriado pode ser necessário. O exemplo acima ilustra o conceito, mas não representa sozinho uma solução distribuída completa.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar quando o assíncrono agrega valor;
- Mencionar consistência eventual;
- Abordar duplicidade e idempotência;
- Considerar ordenação e reprocessamento;
- Falar sobre observabilidade e backlog;
- Explicar impacto na experiência do usuário;
- Demonstrar que mensageria aumenta a complexidade.

Deve evitar dizer que eventos são sempre melhores por desacoplarem os sistemas.

**Resposta fraca ou incompleta:**  

“Eu usaria eventos porque são mais escaláveis e evitam que os serviços fiquem dependentes.”

A resposta ignora consistência, operação, duplicidade, observabilidade e impacto no usuário.

**Critérios de avaliação:**  

- **0** — Não compreende comunicação assíncrona.
- **1** — Escolhe eventos apenas por preferência tecnológica.
- **2** — Conhece o desacoplamento, mas ignora os problemas operacionais.
- **3** — Explica benefícios e limitações básicas.
- **4** — Considera idempotência, reprocessamento, consistência e observabilidade.
- **5** — Demonstra visão sistêmica sobre eventos, operação, contratos e experiência do usuário.

**Perguntas de aprofundamento:**  

1. Como garantiria que um consumidor pudesse processar a mesma mensagem duas vezes?
2. Como trataria mensagens que falham continuamente?
3. Como saberia que uma fila está acumulando mensagens demais?

---

## Pergunta 34 — Idempotência em operações de negócio

**Nível:** Pleno  
**Categoria:** Confiabilidade e integração

**Pergunta do entrevistador:**  

O que significa tornar uma operação idempotente e por que isso é importante em APIs, filas e processos de integração?

**O que essa pergunta avalia:**  

Avalia compreensão sobre reexecução segura, duplicidade, processamento distribuído e proteção de operações críticas.

**Resposta esperada:**  

Uma operação é idempotente quando executar a mesma solicitação uma ou várias vezes produz o mesmo efeito final esperado.

Isso não significa necessariamente que todas as respostas sejam idênticas ou que a operação não faça nenhum processamento interno. Significa que a repetição não deve gerar efeitos duplicados indevidos.

A idempotência é importante porque requisições e mensagens podem ser repetidas por causa de:

- Timeout;
- Retry;
- Falha de rede;
- Reentrega de mensagens;
- Reinício do consumidor;
- Falha após o processamento, mas antes da confirmação;
- Usuário clicando várias vezes.

Para implementar idempotência, eu poderia utilizar:

- Chave idempotente fornecida pelo consumidor;
- Registro de operações processadas;
- Restrição única no banco;
- Verificação do estado atual;
- Atualizações condicionais;
- Identificador único do evento;
- Processamento transacional;
- Reconciliação.

A estratégia depende da operação. Para pagamentos, reservas e criação de pedidos, o cuidado deve ser maior.

**Explicação didática:**  

Considere uma requisição para autorizar um pagamento. O sistema chama o provedor, mas perde a resposta. Se repetir a chamada sem controle, pode gerar duas cobranças.

Com uma chave idempotente, o provedor ou a aplicação consegue reconhecer que aquela operação já foi processada.

A idempotência também é importante em consumidores de mensagens. Um consumidor pode concluir a operação e falhar antes de confirmar o recebimento. A mensagem será entregue novamente.

**Exemplo prático:**  

Uma API poderia receber:

~~~http
POST /pagamentos
Idempotency-Key: pedido-123-tentativa-1
~~~

O servidor registra a chave associada ao resultado. Se a mesma chave for recebida novamente, retorna o resultado já conhecido em vez de criar uma nova operação.

**Exemplo de código:**  

~~~java
@Service
public class PagamentoService {

    private final OperacaoRepository operacaoRepository;

    @Transactional
    public ResultadoPagamento processar(
            String idempotencyKey,
            BigDecimal valor) {

        return operacaoRepository
                .buscarPorChave(idempotencyKey)
                .map(Operacao::resultado)
                .orElseGet(() -> criarOperacao(
                        idempotencyKey,
                        valor));
    }

    private ResultadoPagamento criarOperacao(
            String idempotencyKey,
            BigDecimal valor) {

        // Em produção, a chave deve possuir uma restrição
        // única para evitar condições de corrida.
        Operacao operacao = Operacao.criar(
                idempotencyKey,
                valor);

        operacaoRepository.salvar(operacao);

        return operacao.resultado();
    }
}
~~~

O exemplo conceitual ainda precisa tratar concorrência, restrição única, expiração da chave e falhas durante a operação externa.

**Como o candidato deve responder:**  

O candidato deve:

- Definir idempotência com clareza;
- Apresentar um cenário de duplicidade;
- Mencionar retries e reentrega de mensagens;
- Falar sobre chaves idempotentes;
- Considerar concorrência;
- Explicar a importância de restrições no banco;
- Diferenciar operações naturalmente idempotentes de operações que precisam de controle adicional.

Deve evitar dizer que basta verificar a chave em memória ou utilizar um `if` sem proteção contra concorrência.

**Resposta fraca ou incompleta:**  

“Idempotência significa não executar a operação novamente se ela já tiver sido executada.”

A ideia é parcialmente correta, mas não explica como identificar a operação, lidar com concorrência ou persistir o resultado.

**Critérios de avaliação:**  

- **0** — Não compreende o conceito.
- **1** — Confunde idempotência com impedir qualquer repetição.
- **2** — Entende a duplicidade, mas não propõe mecanismo confiável.
- **3** — Explica chaves idempotentes e reprocessamento.
- **4** — Considera concorrência, banco, retries e mensagens.
- **5** — Demonstra visão profunda sobre operações distribuídas, estados intermediários, consistência e reconciliação.

**Perguntas de aprofundamento:**  

1. Como trataria duas requisições simultâneas com a mesma chave?
2. Por quanto tempo manteria uma chave idempotente?
3. Uma operação `PUT` é sempre idempotente na prática? Explique.

---

## Pergunta 35 — Arquitetura modular versus microsserviços

**Nível:** Sênior  
**Categoria:** Arquitetura e estratégia tecnológica

**Pergunta do entrevistador:**  

Um time deseja dividir uma aplicação Spring Boot monolítica em vários microsserviços porque acredita que isso resolverá problemas de escalabilidade e organização. Como você avaliaria essa proposta?

**O que essa pergunta avalia:**  

Avalia maturidade arquitetural, capacidade de questionar premissas, análise de custos e escolha proporcional da arquitetura.

**Resposta esperada:**  

Eu não começaria pela decisão de dividir o sistema. Primeiro investigaria quais problemas estão sendo observados:

- O sistema não escala por inteiro?
- Existem módulos com necessidades de escala diferentes?
- O deploy de uma parte bloqueia todas as outras?
- O código possui limites de domínio claros?
- O time tem autonomia suficiente?
- Existem gargalos de organização ou apenas problemas de design?
- A operação atual é confiável?
- Há necessidade real de releases independentes?
- O volume justifica a complexidade distribuída?
- A organização consegue operar múltiplos serviços?

Antes de criar microsserviços, avaliaria um monólito modular, com limites claros entre componentes, contratos internos e dependências controladas.

Microsserviços podem oferecer:

- Escala independente;
- Deploy independente;
- Isolamento de falhas em alguns cenários;
- Autonomia organizacional;
- Tecnologias diferentes quando realmente necessário.

Mas também introduzem:

- Complexidade de rede;
- Falhas parciais;
- Consistência distribuída;
- Observabilidade mais difícil;
- Mais pipelines;
- Mais infraestrutura;
- Governança de contratos;
- Maior custo operacional;
- Necessidade de maturidade em deploy e suporte.

A decisão deveria ser baseada em problemas comprovados, não em moda arquitetural.

**Explicação didática:**  

Um monólito não é necessariamente mal projetado. Ele pode ser modular, testável e escalável vertical ou horizontalmente.

Da mesma forma, microsserviços não garantem boa arquitetura. É possível criar vários serviços fortemente acoplados, com deploys coordenados e contratos instáveis.

A arquitetura deve acompanhar:

- Domínio;
- Estrutura organizacional;
- Requisitos de escala;
- Capacidade operacional;
- Necessidades de evolução;
- Custo aceitável.

Uma migração pode ocorrer gradualmente, extraindo primeiro um módulo com fronteira clara e benefício mensurável.

**Exemplo prático:**  

Antes de separar o módulo de notificações, eu verificaria:

- Se ele possui regras próprias;
- Se pode ter ciclo de vida independente;
- Se seus dados podem ser isolados;
- Se o contrato com o restante do sistema é claro;
- Se o ganho esperado compensa a operação de mais um serviço.

Se a separação não trouxer benefício claro, um módulo interno bem definido pode ser uma solução melhor.

**Exemplo de código:**  

Uma organização modular poderia ser representada assim:

~~~text
com.exemplo.pedido
├── application
├── domain
├── infrastructure
└── api

com.exemplo.pagamento
├── application
├── domain
├── infrastructure
└── api
~~~

O objetivo é controlar dependências entre módulos. A estrutura exata depende da arquitetura escolhida e das regras do produto.

**Como o candidato deve responder:**  

O candidato deve:

- Investigar o problema original;
- Comparar monólito modular e microsserviços;
- Considerar escala, deploy, domínio e organização;
- Falar sobre custo operacional;
- Mencionar falhas distribuídas e consistência;
- Propor evolução incremental;
- Evitar decisões baseadas apenas em tendência tecnológica.

Deve evitar responder:

> “Microsserviços são melhores porque permitem escalar cada serviço.”

A escalabilidade independente é apenas um dos possíveis benefícios e não justifica qualquer decomposição.

**Resposta fraca ou incompleta:**  

“Eu dividiria a aplicação por funcionalidade em microsserviços e colocaria cada um em um repositório.”

Essa resposta trata a separação física como solução automática e não analisa limites de domínio ou custo operacional.

**Critérios de avaliação:**  

- **0** — Aceita microsserviços sem análise.
- **1** — Escolhe pela moda ou por preferência.
- **2** — Considera apenas escalabilidade.
- **3** — Compara benefícios e custos básicos.
- **4** — Avalia domínio, operação, organização, consistência e evolução.
- **5** — Demonstra visão estratégica, propõe modularização quando adequada e define critérios objetivos para uma eventual extração.

**Perguntas de aprofundamento:**  

1. Quando um monólito modular seria melhor que microsserviços?
2. Como escolheria o primeiro módulo a ser extraído?
3. Quais métricas demonstrariam que a migração trouxe benefício?

---

## Pergunta 36 — Estratégia de escalabilidade de uma aplicação Spring Boot

**Nível:** Sênior  
**Categoria:** Escalabilidade e desempenho

**Pergunta do entrevistador:**  

Uma aplicação Spring Boot precisa suportar um crescimento de dez vezes no volume de requisições. Como você conduziria a análise e definiria uma estratégia de escalabilidade?

**O que essa pergunta avalia:**  

Avalia visão sistêmica, capacidade de analisar gargalos, planejamento de capacidade e priorização de investimentos técnicos.

**Resposta esperada:**  

Eu não presumiria que adicionar mais instâncias resolveria o problema. Primeiro levantaria:

- Volume atual;
- Crescimento esperado;
- Perfil das requisições;
- Percentis de latência;
- Taxa de erro;
- Capacidade do banco;
- Uso de CPU e memória;
- Pool de conexões;
- Dependências externas;
- Volume de dados;
- Padrões de pico;
- Limites de filas;
- Requisitos de disponibilidade;
- Orçamento.

Depois, realizaria testes de carga representativos e identificaria gargalos.

A estratégia poderia envolver:

- Escalabilidade horizontal;
- Balanceamento;
- Aplicações stateless;
- Cache;
- Paginação;
- Otimização de consultas;
- Índices;
- Separação de workloads;
- Processamento assíncrono;
- Controle de concorrência;
- Rate limiting;
- Dimensionamento do banco;
- Réplicas de leitura;
- Particionamento, se necessário;
- Ajustes de infraestrutura.

Cada mudança deveria ser validada por métricas. Também consideraria o custo e a complexidade operacional.

**Explicação didática:**  

Escalabilidade é a capacidade de lidar com crescimento mantendo os requisitos de desempenho e disponibilidade.

Uma aplicação pode ser escalada horizontalmente adicionando instâncias. Para isso, normalmente precisa evitar estado local ou externalizar sessões e arquivos.

Porém, o banco, uma integração externa ou um pool de conexões pode se tornar o verdadeiro gargalo. Escalar apenas a aplicação pode aumentar a pressão sobre esses componentes.

**Exemplo prático:**  

Se o tempo de resposta aumenta por causa de consultas pesadas, adicionar instâncias pode piorar o banco. A solução pode exigir:

- Consulta otimizada;
- Índice;
- Paginação;
- Redução do payload;
- Cache;
- Separação entre leitura e escrita.

**Exemplo de código:**  

Uma API paginada evita retornar grandes volumes de dados:

~~~java
@GetMapping("/pedidos")
public Page<PedidoResumoResponse> listar(
        @PageableDefault(size = 50)
        Pageable pageable) {

    return pedidoService.listar(pageable);
}
~~~

Ainda seria necessário impor limites máximos de página, validar ordenação e verificar o impacto da consulta no banco.

**Como o candidato deve responder:**  

O candidato deve:

- Começar por métricas e testes de carga;
- Avaliar a cadeia completa;
- Considerar aplicação, banco e dependências;
- Falar sobre escalabilidade horizontal;
- Mencionar gargalos de conexão;
- Avaliar cache, paginação e processamento assíncrono;
- Considerar custo e operação;
- Definir critérios de sucesso.

Deve evitar dizer que basta aumentar CPU, memória ou quantidade de instâncias.

**Resposta fraca ou incompleta:**  

“Eu colocaria a aplicação em mais servidores e aumentaria os recursos da infraestrutura.”

Essa resposta não investiga o gargalo nem considera banco, integrações, dados ou custo.

**Critérios de avaliação:**  

- **0** — Não apresenta estratégia de análise.
- **1** — Sugere apenas aumentar infraestrutura.
- **2** — Menciona escalabilidade horizontal, mas ignora dependências.
- **3** — Analisa métricas, consultas e capacidade básica.
- **4** — Considera toda a cadeia, testes de carga, cache e banco.
- **5** — Demonstra planejamento de capacidade, priorização baseada em evidências e equilíbrio entre desempenho, custo e complexidade.

**Perguntas de aprofundamento:**  

1. Como identificaria se o banco é o gargalo?
2. Quando o cache não seria uma boa solução?
3. Como definiria o cenário de um teste de carga realista?

---

## Pergunta 37 — Segurança arquitetural de uma API

**Nível:** Sênior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  

Como você avaliaria a segurança arquitetural de uma API Spring Boot antes de disponibilizá-la para consumidores externos?

**O que essa pergunta avalia:**  

Avalia visão de segurança aplicada à arquitetura, proteção de dados, autenticação, autorização, abuso da API e segurança operacional.

**Resposta esperada:**  

Eu avaliaria a API desde o desenho, considerando:

- Identidade dos consumidores;
- Autenticação;
- Autorização;
- Escopos e permissões;
- Controle de acesso por recurso;
- Validação de entrada;
- Proteção contra injeção;
- Exposição de dados;
- Códigos de erro;
- Rate limiting;
- Limites de payload;
- Proteção contra abuso;
- Gestão de segredos;
- Criptografia em trânsito;
- Auditoria;
- Logs sem dados sensíveis;
- Versionamento;
- Dependências;
- Configuração de CORS quando aplicável;
- Monitoramento de comportamento anormal.

Também verificaria cenários como:

- Um usuário acessar o recurso de outro usuário;
- Alteração de identificadores na URL;
- Requisições repetidas;
- Payloads excessivamente grandes;
- Vazamento de informações em mensagens de erro;
- Token com escopo maior que o necessário;
- Endpoint administrativo exposto indevidamente.

A segurança deve ser validada por testes automatizados, revisão e, quando necessário, análise especializada.

**Explicação didática:**  

Autenticar significa verificar quem é o consumidor. Autorizar significa verificar o que ele pode fazer.

Uma API pode autenticar corretamente um usuário e ainda permitir que ele consulte ou altere recursos que pertencem a outra pessoa. Esse tipo de falha é frequentemente causado por ausência de verificação de autorização no nível do recurso.

Também é importante aplicar o princípio do menor privilégio: cada usuário, serviço ou pipeline deve possuir apenas as permissões necessárias.

**Exemplo prático:**  

Em um endpoint:

~~~text
GET /clientes/{clienteId}/pedidos
~~~

Não basta verificar se o usuário está autenticado. É preciso confirmar se ele tem autorização para consultar aquele `clienteId`.

**Exemplo de código:**  

~~~java
@GetMapping("/clientes/{clienteId}/pedidos")
public List<PedidoResponse> listarPedidos(
        @PathVariable Long clienteId,
        Authentication authentication) {

    autorizacaoService.validarAcessoAoCliente(
            authentication,
            clienteId);

    return pedidoService.listarPorCliente(clienteId);
}
~~~

A validação não deve depender apenas de dados enviados pelo cliente. Ela deve utilizar a identidade autenticada e regras de autorização confiáveis.

**Como o candidato deve responder:**  

O candidato deve:

- Diferenciar autenticação e autorização;
- Considerar acesso por recurso;
- Falar sobre validação de entrada;
- Mencionar dados sensíveis e logs;
- Considerar rate limiting e abuso;
- Abordar segredos e menor privilégio;
- Relacionar segurança a testes e observabilidade;
- Demonstrar preocupação com ameaças reais.

Deve evitar reduzir segurança à presença de HTTPS ou JWT.

**Resposta fraca ou incompleta:**  

“Eu colocaria OAuth e JWT, habilitaria HTTPS e a API estaria segura.”

Esses mecanismos são importantes, mas não garantem autorização correta, proteção contra abuso ou ausência de vazamento de dados.

**Critérios de avaliação:**  

- **0** — Não identifica riscos básicos de segurança.
- **1** — Reduz segurança a autenticação.
- **2** — Menciona HTTPS e tokens, mas ignora autorização.
- **3** — Considera autenticação, autorização e validação.
- **4** — Inclui abuso, dados sensíveis, menor privilégio e auditoria.
- **5** — Demonstra visão de segurança desde o desenho, threat modeling, testes e operação contínua.

**Perguntas de aprofundamento:**  

1. Como identificaria uma falha de autorização por objeto?
2. Que informações nunca colocaria em logs?
3. Como trataria uma suspeita de abuso de um endpoint público?

---

## Pergunta 38 — Compatibilidade entre serviços durante uma mudança

**Nível:** Sênior  
**Categoria:** Integração e evolução de contratos

**Pergunta do entrevistador:**  

Um serviço produtor precisa alterar o contrato de uma API utilizada por vários consumidores. Como você conduziria essa mudança sem interromper os consumidores existentes?

**O que essa pergunta avalia:**  

Avalia capacidade de evoluir contratos, planejar compatibilidade, coordenar times e realizar migrações graduais.

**Resposta esperada:**  

Eu começaria identificando todos os consumidores e entendendo como cada um utiliza o contrato. Depois, classificaria a mudança como:

- Compatível;
- Potencialmente incompatível;
- Definitivamente incompatível.

Quando possível, preferiria mudanças compatíveis, como:

- Adicionar campos opcionais;
- Aceitar formatos antigos e novos durante a transição;
- Introduzir um novo endpoint;
- Adicionar uma nova versão;
- Manter o campo antigo temporariamente;
- Fazer rollout gradual.

Eu definiria:

- Prazo de transição;
- Responsáveis;
- Métricas de uso do formato antigo;
- Testes de contrato;
- Comunicação;
- Plano de remoção;
- Estratégia de rollback.

Não removeria um campo apenas porque o novo consumidor já está pronto. Todos os consumidores precisam ser avaliados.

**Explicação didática:**  

Em sistemas distribuídos, produtores e consumidores nem sempre são implantados simultaneamente. Portanto, deve existir um período em que versões antigas e novas convivem.

Uma estratégia segura costuma seguir o padrão:

1. Expandir o contrato;
2. Atualizar consumidores;
3. Migrar o uso;
4. Monitorar;
5. Remover o comportamento antigo.

A compatibilidade precisa ser avaliada não apenas pela estrutura do JSON, mas também pelo significado dos dados e pelo comportamento dos códigos de erro.

**Exemplo prático:**  

Se um serviço atualmente retorna:

~~~json
{
  "status": "APPROVED"
}
~~~

Uma mudança compatível poderia adicionar:

~~~json
{
  "status": "APPROVED",
  "statusDescription": "Pagamento aprovado"
}
~~~

Já remover `status` ou alterar seus valores pode quebrar consumidores.

**Exemplo de código:**  

Uma resposta poderia manter os dois campos durante a transição:

~~~java
public record PagamentoResponse(
        String status,
        String statusCode,
        String statusDescription
) {
}
~~~

O produtor pode preencher o novo campo enquanto mantém o antigo até que todos os consumidores sejam migrados.

**Como o candidato deve responder:**  

O candidato deve:

- Mapear consumidores;
- Identificar mudanças incompatíveis;
- Preferir evolução gradual;
- Mencionar testes de contrato;
- Considerar métricas de uso;
- Definir prazo para remoção;
- Comunicar os times envolvidos;
- Planejar rollback.

Deve evitar assumir que todos os consumidores podem ser atualizados simultaneamente.

**Resposta fraca ou incompleta:**  

“Eu criaria uma nova versão da API e avisaria os consumidores.”

Essa pode ser uma alternativa, mas não explica coexistência, migração, prazo, testes ou remoção da versão antiga.

**Critérios de avaliação:**  

- **0** — Não reconhece o risco de quebrar consumidores.
- **1** — Altera o contrato diretamente.
- **2** — Cria nova versão, mas não planeja a transição.
- **3** — Considera compatibilidade e comunicação.
- **4** — Inclui testes de contrato, métricas, coexistência e rollout.
- **5** — Demonstra domínio de evolução distribuída, governança de contratos e migração segura.

**Perguntas de aprofundamento:**  

1. Quando uma nova versão da API seria necessária?
2. Como saberia quando remover o contrato antigo?
3. Como faria a migração se um consumidor pertencesse a outra organização?

---

## Pergunta 39 — Resiliência e isolamento de falhas

**Nível:** Sênior  
**Categoria:** Resiliência e alta disponibilidade

**Pergunta do entrevistador:**  

Uma aplicação Java depende de cinco serviços externos. Quando um deles apresenta lentidão, a aplicação inteira começa a consumir muitos recursos e fica indisponível. Como você investigaria e corrigiria esse problema?

**O que essa pergunta avalia:**  

Avalia compreensão sobre efeito cascata, isolamento de falhas, limites de recursos, timeouts, circuit breakers e desenho resiliente.

**Resposta esperada:**  

Eu começaria analisando:

- Quais chamadas dependem do serviço lento;
- Quantidade de requisições concorrentes;
- Tempo de espera;
- Threads ocupadas;
- Conexões consumidas;
- Filas;
- Retries;
- Circuit breakers;
- Taxa de erro;
- Impacto por endpoint;
- Dependências críticas;
- Existência de fallback.

O problema pode ser causado por chamadas sem timeout, pools ilimitados, retries agressivos ou falta de isolamento entre tipos de operação.

As correções poderiam incluir:

- Timeouts explícitos;
- Limites de concorrência;
- Bulkheads;
- Circuit breakers;
- Retries com backoff e limite;
- Fallbacks válidos;
- Filas para processamento posterior;
- Separação de pools;
- Rate limiting;
- Cache de dados adequados;
- Degradação controlada;
- Monitoramento e alertas.

Eu também verificaria se todos os endpoints realmente precisam daquela dependência. Talvez a aplicação possa retornar dados parciais ou um status posterior.

**Explicação didática:**  

O efeito cascata ocorre quando uma falha em uma dependência se propaga para outros componentes.

Por exemplo:

1. O parceiro fica lento;
2. As requisições da aplicação ficam aguardando;
3. As threads são ocupadas;
4. As conexões se esgotam;
5. Novas requisições entram em fila;
6. A aplicação fica indisponível mesmo para funções que não dependem do parceiro.

O isolamento de falhas busca impedir que um componente consuma todos os recursos disponíveis.

**Exemplo prático:**  

O serviço de consulta de recomendações pode ser desativado temporariamente sem impedir a finalização de uma compra. Nesse caso, o sistema pode entregar a compra sem recomendações e registrar a degradação.

**Exemplo de código:**  

~~~java
@Service
public class RecomendacaoService {

    private final ClienteRecomendacao cliente;

    public RecomendacaoService(ClienteRecomendacao cliente) {
        this.cliente = cliente;
    }

    @TimeLimiter(name = "recomendacoes")
    @CircuitBreaker(
            name = "recomendacoes",
            fallbackMethod = "semRecomendacoes")
    public CompletionStage<List<Recomendacao>> buscar(
            Cliente clienteAtual) {

        return cliente.buscar(clienteAtual.id());
    }

    private CompletionStage<List<Recomendacao>> semRecomendacoes(
            Cliente clienteAtual,
            Exception exception) {

        return CompletableFuture.completedFuture(
                List.of());
    }
}
~~~

O fallback vazio só é adequado se o produto aceitar a ausência de recomendações. Para uma operação crítica, seria necessário outro comportamento.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar o efeito cascata;
- Investigar threads, conexões e filas;
- Falar sobre timeouts;
- Considerar circuit breaker e bulkhead;
- Avaliar retries;
- Propor degradação controlada;
- Diferenciar dependências críticas e opcionais;
- Incluir métricas e alertas.

Deve evitar apenas aumentar a capacidade da aplicação sem corrigir a causa do bloqueio.

**Resposta fraca ou incompleta:**  

“Eu aumentaria o número de threads e colocaria retry nas chamadas.”

Isso pode aumentar o consumo e piorar a indisponibilidade.

**Critérios de avaliação:**  

- **0** — Não identifica o efeito cascata.
- **1** — Propõe apenas mais recursos.
- **2** — Menciona timeout, mas não isola recursos.
- **3** — Identifica retries, timeouts e circuit breaker.
- **4** — Inclui bulkhead, degradação controlada e observabilidade.
- **5** — Demonstra visão sistêmica de resiliência, capacidade de diagnosticar saturação e desenho orientado à continuidade do serviço.

**Perguntas de aprofundamento:**  

1. Como escolheria quais funcionalidades podem ser degradadas?
2. Como evitaria que retries aumentassem a sobrecarga?
3. Quais métricas indicariam que o isolamento está funcionando?

---

## Pergunta 40 — Evolução arquitetural baseada em evidências

**Nível:** Sênior  
**Categoria:** Estratégia e tomada de decisão

**Pergunta do entrevistador:**  

Como você decidiria se uma arquitetura existente precisa ser refatorada, modularizada, migrada ou substituída? Que evidências utilizaria para evitar decisões baseadas apenas em preferências técnicas?

**O que essa pergunta avalia:**  

Avalia capacidade de diagnosticar problemas arquiteturais, conectar tecnologia a resultados de negócio e planejar evolução com base em evidências.

**Resposta esperada:**  

Eu começaria definindo quais problemas a arquitetura atual está causando:

- Entregas lentas;
- Alto número de incidentes;
- Falhas difíceis de diagnosticar;
- Escalabilidade insuficiente;
- Custos elevados;
- Vulnerabilidades;
- Baixa disponibilidade;
- Dependência de poucas pessoas;
- Dificuldade de testar;
- Mudanças simples exigindo alterações em muitas áreas;
- Falta de autonomia entre times;
- Impossibilidade de atender requisitos do produto.

Usaria evidências como:

- Tempo de ciclo;
- Frequência de deploy;
- Taxa de falhas após mudança;
- Tempo de recuperação;
- Latência;
- Custo de infraestrutura;
- Incidentes;
- Volume de retrabalho;
- Tempo de onboarding;
- Complexidade das mudanças;
- Feedback de desenvolvedores e operadores;
- Métricas de negócio.

Depois, compararia alternativas:

- Melhorar a estrutura atual;
- Criar módulos claros;
- Extrair um componente;
- Substituir uma dependência;
- Migrar gradualmente;
- Reescrever uma parte;
- Manter a solução e aceitar seus limites.

A escolha deveria considerar benefício, custo, risco, prazo, reversibilidade e capacidade do time.

Eu evitaria reescritas totais sem uma estratégia incremental. Quando possível, começaria por uma área de alto impacto e fronteira bem definida, medindo o resultado.

**Explicação didática:**  

Arquitetura não deve ser avaliada apenas por beleza ou modernidade. Uma solução arquitetural é adequada quando ajuda o produto a cumprir seus objetivos dentro das restrições existentes.

Uma arquitetura pode ser tecnicamente antiga, mas ainda atender bem ao negócio. Outra pode utilizar tecnologias modernas, mas causar lentidão, instabilidade ou alto custo.

A decisão deve responder:

- Qual problema estamos tentando resolver?
- Qual é o impacto atual?
- O que acontecerá se nada for feito?
- Quais alternativas existem?
- Como saberemos se a mudança funcionou?
- Como limitaremos o risco?

**Exemplo prático:**  

Se o tempo de entrega aumentou porque qualquer alteração exige modificar um módulo central, o time pode começar por:

1. Mapear dependências;
2. Criar testes de caracterização;
3. Definir uma fronteira modular;
4. Reduzir acesso direto a estruturas internas;
5. Migrar uma funcionalidade;
6. Medir tempo de mudança e regressões;
7. Expandir a abordagem se os resultados forem positivos.

**Exemplo de código:**  

Uma regra de arquitetura pode impedir dependências indevidas entre pacotes:

~~~java
// Exemplo conceitual:
//
// O módulo de pedidos pode depender de interfaces públicas
// do módulo de pagamento, mas não deve acessar diretamente
// classes internas de infraestrutura.
public interface PagamentoGateway {

    ResultadoPagamento autorizar(
            PedidoId pedidoId,
            BigDecimal valor);
}
~~~

O objetivo é criar um limite claro. A ferramenta utilizada para verificar essa regra pode variar conforme o projeto.

**Como o candidato deve responder:**  

O candidato deve:

- Começar pelo problema e pelo impacto;
- Usar métricas e evidências;
- Comparar alternativas;
- Considerar custo, prazo e risco;
- Propor mudanças incrementais;
- Definir critérios de sucesso;
- Evitar reescritas por preferência pessoal;
- Relacionar arquitetura à capacidade de entrega.

Deve evitar dizer que uma tecnologia precisa ser substituída apenas porque está desatualizada ou porque outra solução é mais moderna.

**Resposta fraca ou incompleta:**  

“Eu analisaria o código e substituiria a arquitetura antiga por microsserviços.”

Essa resposta não identifica o problema, não apresenta evidências nem avalia o custo da mudança.

**Critérios de avaliação:**  

- **0** — Decide sem critérios ou evidências.
- **1** — Baseia-se em moda ou preferência tecnológica.
- **2** — Identifica problemas, mas não compara alternativas.
- **3** — Avalia impacto e propõe uma melhoria.
- **4** — Considera métricas, risco, custo, prazo e evolução incremental.
- **5** — Demonstra visão estratégica, capacidade de justificar investimentos e foco em resultados mensuráveis para o produto e o time.

**Perguntas de aprofundamento:**  

1. Como convenceria a organização a investir em uma evolução arquitetural?
2. Quando uma reescrita completa poderia ser justificável?
3. Como mediria se a nova arquitetura realmente melhorou a capacidade de entrega?

---

# Resumo desta parte

| Item | Resultado |
|---|---|
| Perguntas apresentadas | 31 a 40 |
| Níveis abordados | Pleno e Sênior |
| Temas principais | ADRs, integrações externas, eventos, idempotência, microsserviços, escalabilidade, segurança, compatibilidade, resiliência e evolução arquitetural |
| Perguntas restantes | 60 |

## Competências exploradas

- Registro e comunicação de decisões arquiteturais;
- Análise de alternativas técnicas;
- Integração resiliente com serviços externos;
- Uso consciente de processamento assíncrono;
- Idempotência em APIs e mensagens;
- Avaliação de monólitos e microsserviços;
- Planejamento de escalabilidade;
- Segurança de APIs;
- Evolução compatível de contratos;
- Isolamento de falhas;
- Prevenção de efeito cascata;
- Gestão de riscos arquiteturais;
- Tomada de decisões baseada em evidências;
- Planejamento incremental de modernização.

---

# Roteiro Completo de Entrevista — Tech Lead de um Time Java

## Parte 5 de 10 — Perguntas 41 a 50

**Foco desta parte:** CI/CD, releases, estratégias de implantação, qualidade da entrega, rollback, segurança do pipeline e métricas de engenharia.

> As perguntas consideram um Tech Lead responsável por um time que desenvolve produtos com Java e Spring Boot, utiliza Git e CI/CD, trabalha com metodologias ágeis e participa da entrega completa até a operação em produção.

## Fluxo de entrega contínua

~~~mermaid
flowchart LR
    A[Alteração no Git] --> B[Pull request]
    B --> C[Build e testes]
    C --> D[Análise de qualidade e segurança]
    D --> E[Artefato imutável]
    E --> F[Ambiente de validação]
    F --> G[Testes de aceitação]
    G --> H[Deploy controlado]
    H --> I[Monitoramento]
    I --> J{Indicadores adequados?}
    J -->|Sim| K[Expandir liberação]
    J -->|Não| L[Rollback ou desativação]
    L --> M[Análise e melhoria]
~~~

---

## Pergunta 41 — Critérios de qualidade no pipeline

**Nível:** Pleno  
**Categoria:** CI/CD e qualidade

**Pergunta do entrevistador:**

Quais critérios deveriam ser atendidos antes que uma alteração em uma aplicação Spring Boot pudesse ser integrada à branch principal?

**O que essa pergunta avalia:**

Avalia a capacidade de definir controles de qualidade automatizados, equilibrar velocidade e segurança e estabelecer critérios objetivos para integração de código.

**Resposta esperada:**

Eu definiria critérios proporcionais ao risco da alteração. De forma geral, o pipeline deveria verificar:

- Compilação;
- Testes unitários;
- Testes de integração relevantes;
- Análise estática;
- Formatação e padrões mínimos;
- Vulnerabilidades em dependências;
- Qualidade das migrações de banco;
- Testes de contrato, quando existirem integrações;
- Verificação de cobertura em áreas críticas;
- Empacotamento do artefato;
- Validações de configuração;
- Aprovação de revisão de código.

Além das verificações automatizadas, o pull request deveria apresentar:

- Objetivo da mudança;
- Escopo;
- Riscos;
- Estratégia de teste;
- Impactos em banco ou integrações;
- Estratégia de implantação;
- Necessidade de feature flag;
- Plano de rollback, quando aplicável.

Nem todos os critérios precisam bloquear toda alteração da mesma forma. Uma mudança documental pode ter controles diferentes de uma alteração em pagamento ou autenticação.

O Tech Lead deve evitar tanto um pipeline sem proteção quanto uma quantidade excessiva de verificações que gere lentidão e incentive o time a contornar o processo.

**Explicação didática:**

Um pipeline deve funcionar como uma rede de segurança. Ele não substitui a responsabilidade das pessoas, mas reduz a possibilidade de erros conhecidos chegarem a ambientes posteriores.

É importante diferenciar:

- **Falhas bloqueadoras:** compilação, testes críticos, vulnerabilidade grave ou erro de segurança;
- **Alertas:** dívida técnica, cobertura abaixo do objetivo ou melhoria de estilo;
- **Informações:** métricas, relatórios e recomendações.

Se tudo for tratado como bloqueador, o time pode perder velocidade e começar a ignorar os resultados. Se nada bloquear a integração, o pipeline deixa de proteger o produto.

**Exemplo prático:**

Uma alteração em um endpoint de consulta pode exigir:

1. Build;
2. Testes unitários;
3. Testes de integração com banco;
4. Verificação de autorização;
5. Análise de vulnerabilidades;
6. Teste do contrato da API;
7. Revisão de código;
8. Publicação do artefato.

Uma mudança em uma regra crítica de pagamento pode exigir validações adicionais de idempotência, concorrência e auditoria.

**Exemplo de código:**

Uma política conceitual de qualidade poderia ser representada assim:

~~~yaml
quality-gates:
  build: required
  unit-tests: required
  integration-tests: required
  dependency-scan: required
  static-analysis: required
  code-review: required
  security-critical-findings: zero
~~~

A configuração real dependerá da plataforma de CI/CD e dos critérios definidos pela organização.

**Como o candidato deve responder:**

O candidato deve:

- Falar sobre build, testes e segurança;
- Diferenciar critérios obrigatórios de alertas;
- Considerar o risco da mudança;
- Mencionar revisão de código;
- Relacionar o pipeline à qualidade do produto;
- Evitar exigir o mesmo nível de validação para qualquer alteração;
- Explicar como evitar lentidão excessiva no pipeline.

**Resposta fraca ou incompleta:**

“Eu exigiria que o projeto compilasse e que os testes passassem antes do merge.”

A resposta é válida como ponto inicial, mas não considera segurança, contratos, migrações, revisão, configuração ou diferentes níveis de risco.

**Critérios de avaliação:**

- **0** — Não define critérios para integração.
- **1** — Considera apenas compilação.
- **2** — Inclui testes, mas ignora segurança e revisão.
- **3** — Define build, testes e revisão como controles básicos.
- **4** — Inclui segurança, contratos, banco e critérios proporcionais ao risco.
- **5** — Demonstra capacidade de criar quality gates efetivos, rápidos, mensuráveis e alinhados ao produto.

**Perguntas de aprofundamento:**

1. Quais falhas deveriam bloquear obrigatoriamente o merge?
2. Como evitaria que o pipeline se tornasse lento demais?
3. Como trataria uma regra de qualidade que o legado atual ainda não consegue cumprir?

---

## Pergunta 42 — Mesmo artefato entre ambientes

**Nível:** Pleno  
**Categoria:** Entrega e governança

**Pergunta do entrevistador:**

Por que é importante promover o mesmo artefato entre desenvolvimento, homologação e produção, em vez de recompilar a aplicação para cada ambiente?

**O que essa pergunta avalia:**

Avalia compreensão sobre reprodutibilidade, rastreabilidade, confiabilidade da entrega e separação entre artefato e configuração.

**Resposta esperada:**

O mesmo artefato deve ser promovido entre ambientes para garantir que aquilo que foi validado seja exatamente o que chegará à produção.

Se a aplicação for recompilada para cada ambiente, podem ocorrer diferenças causadas por:

- Dependências distintas;
- Alterações no código;
- Versões diferentes do Java;
- Configurações de build;
- Dados gerados;
- Imagens diferentes;
- Alterações transitivas;
- Falhas não reproduzidas no ambiente anterior.

Eu criaria um artefato versionado e identificável, como uma imagem de contêiner ou pacote da aplicação, e o promoveria entre os ambientes.

As diferenças entre os ambientes deveriam ser fornecidas por configuração externa, como:

- URLs;
- Credenciais;
- Nome de filas;
- Limites;
- Feature flags;
- Configurações de observabilidade.

Também registraria qual versão foi implantada, quando, por quem e com qual resultado.

**Explicação didática:**

O princípio é:

> Construir uma vez, validar e promover o mesmo resultado.

O código deve permanecer igual. O que muda entre ambientes são configurações e recursos externos.

Essa prática facilita:

- Auditoria;
- Reprodução de problemas;
- Rollback;
- Investigação;
- Comparação entre ambientes;
- Controle de versões;
- Identificação do commit implantado.

Ela não elimina todos os riscos. Ainda é necessário verificar diferenças de banco, permissões, infraestrutura e dados.

**Exemplo prático:**

O pipeline poderia gerar:

~~~text
pedido-service:2026.09.01-abc123
~~~

Essa mesma versão seria implantada primeiro em homologação e depois em produção. A configuração de produção seria fornecida no momento do deploy, sem gerar uma nova compilação.

**Exemplo de código:**

Uma etapa conceitual poderia ser:

~~~yaml
package:
  image: pedido-service:${COMMIT_SHA}
  publish: true

deploy-homolog:
  image: pedido-service:${COMMIT_SHA}

deploy-production:
  image: pedido-service:${COMMIT_SHA}
~~~

O identificador da versão deve ser imutável ou protegido contra sobrescrita.

**Como o candidato deve responder:**

O candidato deve:

- Explicar o risco de recompilar;
- Falar sobre rastreabilidade;
- Separar configuração de artefato;
- Mencionar versionamento;
- Relacionar o princípio ao rollback;
- Considerar diferenças de infraestrutura;
- Demonstrar preocupação com auditoria.

Deve evitar afirmar que basta usar o mesmo código-fonte, pois o resultado compilado pode ser diferente.

**Resposta fraca ou incompleta:**

“É melhor usar o mesmo artefato para não perder tempo compilando de novo.”

A resposta menciona eficiência, mas não explica reprodutibilidade, rastreabilidade ou redução de risco.

**Critérios de avaliação:**

- **0** — Não compreende o problema.
- **1** — Considera apenas economia de tempo.
- **2** — Reconhece a importância da versão, mas não explica o motivo.
- **3** — Explica que o mesmo artefato reduz diferenças entre ambientes.
- **4** — Relaciona artefato, configuração, rastreabilidade e rollback.
- **5** — Demonstra domínio de entrega reprodutível, imutabilidade, auditoria e governança.

**Perguntas de aprofundamento:**

1. Como garantiria que o artefato não fosse sobrescrito?
2. O que deve ser diferente entre homologação e produção?
3. Como identificaria exatamente qual commit está rodando em produção?

---

## Pergunta 43 — Estratégias de implantação

**Nível:** Sênior  
**Categoria:** Release e disponibilidade

**Pergunta do entrevistador:**

Compare as estratégias rolling deployment, blue-green e canary. Como decidiria qual utilizar para uma aplicação Spring Boot?

**O que essa pergunta avalia:**

Avalia conhecimento sobre estratégias de implantação, disponibilidade, exposição gradual, rollback e análise de risco.

**Resposta esperada:**

As estratégias possuem características diferentes.

### Rolling deployment

Substitui gradualmente as instâncias antigas por novas. Pode reduzir o custo de infraestrutura, mas exige compatibilidade entre versões e atenção à capacidade durante a transição.

### Blue-green

Mantém dois ambientes semelhantes. O tráfego é direcionado para o ambiente novo depois da validação. Facilita rollback rápido, mas pode exigir infraestrutura duplicada e cuidado com banco e sessões.

### Canary

Libera a nova versão para uma pequena parcela do tráfego. Permite observar erros, latência e comportamento antes de expandir. Reduz o raio inicial do problema, mas exige roteamento, métricas e critérios objetivos de promoção.

Eu escolheria considerando:

- Criticidade do produto;
- Capacidade de rollback;
- Compatibilidade entre versões;
- Custo de infraestrutura;
- Estado e migração do banco;
- Necessidade de validação com usuários;
- Capacidade de observabilidade;
- Perfil do tráfego;
- Complexidade operacional;
- Impacto de uma falha.

A estratégia não deve ser escolhida apenas por ser mais moderna. Uma aplicação sem observabilidade adequada não se beneficia plenamente de um canary.

**Explicação didática:**

A estratégia de implantação define como uma nova versão chega aos usuários e como o sistema reage quando algo dá errado.

O rollback da aplicação pode não ser suficiente quando a mudança envolve:

- Banco de dados;
- Mensagens;
- Contratos;
- Dados persistidos;
- Integrações externas.

Por isso, a estratégia de release precisa ser compatível com toda a arquitetura.

**Exemplo prático:**

Uma alteração de baixo risco em uma API interna pode utilizar rolling deployment.

Uma mudança crítica no checkout pode ser liberada com canary:

1. Implantar a nova versão;
2. Direcionar 1% do tráfego;
3. Monitorar erros e latência;
4. Comparar com a versão anterior;
5. Expandir progressivamente;
6. Interromper ou reverter se os indicadores ultrapassarem os limites.

**Exemplo de código:**

Uma regra conceitual de promoção poderia ser:

~~~yaml
canary:
  initial-traffic: 5%
  promotion-conditions:
    error-rate: "< 1%"
    p95-latency: "< 500ms"
    payment-failures: "no significant increase"
  promotion-steps:
    - 10%
    - 25%
    - 50%
    - 100%
~~~

Os valores devem ser definidos com base no comportamento normal do produto e em seus requisitos.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar rolling, blue-green e canary;
- Falar sobre rollback;
- Considerar compatibilidade com banco;
- Mencionar observabilidade;
- Relacionar a escolha ao risco;
- Considerar custo de infraestrutura;
- Explicar promoção gradual.

Deve evitar dizer que uma estratégia é universalmente superior.

**Resposta fraca ou incompleta:**

“Eu escolheria canary porque libera aos poucos e é mais seguro.”

A resposta ignora requisitos de observabilidade, roteamento, custo, banco e capacidade operacional.

**Critérios de avaliação:**

- **0** — Não conhece estratégias de implantação.
- **1** — Confunde os modelos.
- **2** — Conhece os nomes, mas não explica os trade-offs.
- **3** — Diferencia as estratégias principais.
- **4** — Relaciona cada estratégia a risco, custo, rollback e disponibilidade.
- **5** — Demonstra capacidade de escolher e operar uma estratégia baseada em contexto, métricas e compatibilidade arquitetural.

**Perguntas de aprofundamento:**

1. Em que situação blue-green não resolveria o problema de rollback?
2. Que métricas utilizaria durante um canary?
3. Como trataria uma alteração de banco durante um rolling deployment?

---

## Pergunta 44 — Rollback de uma versão problemática

**Nível:** Sênior  
**Categoria:** Incidentes e recuperação

**Pergunta do entrevistador:**

Após um deploy, a taxa de erro da API aumentou significativamente. Como você decidiria entre fazer rollback, desativar uma feature flag, corrigir de forma emergencial ou manter a versão sob observação?

**O que essa pergunta avalia:**

Avalia tomada de decisão em incidentes, análise de impacto, velocidade de resposta e capacidade de escolher ações reversíveis e seguras.

**Resposta esperada:**

Eu começaria confirmando a alteração e o impacto:

- Quando o problema começou;
- Quais endpoints foram afetados;
- Qual percentual de usuários;
- Qual tipo de erro ocorreu;
- Se há perda ou corrupção de dados;
- Se o problema está aumentando;
- Se existe impacto financeiro ou regulatório;
- Se a funcionalidade possui feature flag;
- Se a versão anterior está disponível;
- Se o rollback é seguro.

Se houver impacto grave e a versão anterior for compatível, eu priorizaria interromper a propagação do problema, normalmente por meio de rollback ou desativação da funcionalidade.

A decisão precisa considerar se o rollback pode causar outro problema, especialmente quando houve:

- Migração destrutiva;
- Alteração de contrato;
- Escrita de novos dados;
- Mudança em mensagens;
- Alteração irreversível.

Uma correção emergencial pode ser adequada quando:

- O rollback não é seguro;
- A causa é conhecida;
- A correção pode ser validada rapidamente;
- O impacto de aguardar é maior;
- Existe capacidade de monitoramento.

Eu comunicaria o incidente, registraria a decisão e definiria critérios de encerramento. Depois, faria análise da causa e ações preventivas.

**Explicação didática:**

Rollback significa retornar a uma versão anterior, mas isso não é automaticamente seguro.

Se a nova versão gravou dados em um formato que a antiga não entende, retornar o código pode gerar novos erros. Por isso, mudanças precisam ser planejadas para compatibilidade e reversibilidade sempre que possível.

Uma feature flag pode ser mais rápida que um rollback, mas apenas se o problema estiver isolado atrás dela.

**Exemplo prático:**

Uma nova tela de consulta causa aumento de latência, mas não altera dados. O time pode:

1. Desativar a funcionalidade;
2. Reduzir o tráfego;
3. Investigar o gargalo;
4. Corrigir;
5. Reimplantar;
6. Liberar gradualmente.

Já uma falha que gera cobranças duplicadas exige interromper imediatamente o fluxo e iniciar reconciliação dos dados.

**Exemplo de código:**

Uma configuração de emergência poderia ser:

~~~yaml
features:
  novo-checkout:
    enabled: false
~~~

Essa alternativa só é segura se o fluxo antigo continuar disponível e se a alteração da configuração for auditada e monitorada.

**Como o candidato deve responder:**

O candidato deve:

- Priorizar contenção do impacto;
- Avaliar gravidade e reversibilidade;
- Considerar rollback e feature flag;
- Analisar banco e contratos;
- Comunicar as partes envolvidas;
- Evitar decisões baseadas apenas em pressão;
- Definir critérios objetivos;
- Planejar ações posteriores.

Deve evitar manter uma versão claramente problemática em produção apenas para “observar mais”, sem limite de tempo ou critério.

**Resposta fraca ou incompleta:**

“Eu faria rollback imediatamente.”

A ação pode ser correta em alguns casos, mas a resposta não considera migrações, dados, contratos ou possibilidade de o rollback causar um problema maior.

**Critérios de avaliação:**

- **0** — Ignora o incidente ou toma decisão sem avaliar impacto.
- **1** — Faz rollback automaticamente em qualquer situação.
- **2** — Considera rollback, mas não verifica compatibilidade.
- **3** — Analisa impacto, causa e possibilidade de reversão.
- **4** — Considera feature flags, dados, comunicação e mitigação.
- **5** — Demonstra liderança em incidentes, decisão rápida baseada em risco e preocupação com recuperação segura.

**Perguntas de aprofundamento:**

1. Quando um rollback poderia ser mais perigoso que manter a versão atual?
2. Como trataria dados gravados pela versão problemática?
3. Que informações comunicaria aos stakeholders durante o incidente?

---

## Pergunta 45 — Segurança da cadeia de CI/CD

**Nível:** Sênior  
**Categoria:** Segurança e governança

**Pergunta do entrevistador:**

Quais riscos de segurança você avaliaria na cadeia de CI/CD de um time Java e Spring Boot?

**O que essa pergunta avalia:**

Avalia compreensão sobre segurança da cadeia de software, proteção de credenciais, dependências, permissões e integridade dos artefatos.

**Resposta esperada:**

Eu avaliaria riscos em todo o ciclo:

- Segredos expostos em repositórios;
- Tokens presentes em logs;
- Permissões excessivas do pipeline;
- Credenciais compartilhadas;
- Dependências vulneráveis;
- Imagens de contêiner comprometidas;
- Pacotes de origem não confiável;
- Scripts executados sem revisão;
- Artefatos sobrescritos;
- Branches sem proteção;
- Ações de terceiros não verificadas;
- Acesso direto e amplo à produção;
- Falta de auditoria;
- Falta de assinatura ou verificação de artefatos;
- Ausência de rotação de credenciais;
- Dependências transitivas desconhecidas.

Eu aplicaria:

- Menor privilégio;
- Segregação de funções;
- Secret manager;
- Rotação de credenciais;
- Proteção de branches;
- Revisão obrigatória;
- Análise de dependências;
- Verificação de imagens;
- Artefatos imutáveis;
- Auditoria;
- Aprovações para ambientes críticos;
- Monitoramento de alterações;
- Atualização controlada de ferramentas do pipeline.

A segurança deve ser incorporada ao fluxo de desenvolvimento, sem depender apenas de uma revisão manual no final.

**Explicação didática:**

O pipeline possui acesso privilegiado e pode se tornar um alvo importante. Se alguém conseguir alterar uma etapa do processo ou obter uma credencial de produção, poderá inserir código malicioso ou acessar dados sensíveis.

A segurança deve proteger:

1. O código;
2. As dependências;
3. O processo de build;
4. Os artefatos;
5. Os ambientes;
6. As credenciais;
7. A implantação.

Não basta verificar vulnerabilidades no código da aplicação. A própria cadeia de entrega também precisa ser confiável.

**Exemplo prático:**

Um pipeline que possui uma credencial com acesso total à produção representa um risco elevado. Uma abordagem melhor é fornecer permissões limitadas, temporárias e específicas para o ambiente e para a ação executada.

**Exemplo de código:**

Uma configuração conceitual de permissões poderia ser:

~~~yaml
pipeline-permissions:
  read-source: true
  publish-artifact: true
  deploy-production: restricted
  read-production-secrets: false
  delete-artifacts: false
~~~

A configuração real depende da plataforma utilizada, mas o princípio é conceder somente as permissões necessárias.

**Como o candidato deve responder:**

O candidato deve:

- Falar sobre secrets;
- Mencionar menor privilégio;
- Considerar dependências e imagens;
- Abordar integridade dos artefatos;
- Incluir branches protegidas e revisão;
- Considerar acesso à produção;
- Falar sobre auditoria e rotação;
- Demonstrar visão de segurança contínua.

Deve evitar limitar segurança a executar um scanner de vulnerabilidades.

**Resposta fraca ou incompleta:**

“Eu colocaria um scanner de segurança no pipeline e bloquearia vulnerabilidades.”

A prática é útil, mas não cobre credenciais, permissões, artefatos, scripts, imagens ou acesso à produção.

**Critérios de avaliação:**

- **0** — Não identifica riscos relevantes.
- **1** — Considera apenas vulnerabilidades no código.
- **2** — Menciona secrets e scanners, mas não trata permissões.
- **3** — Apresenta controles básicos de segurança no pipeline.
- **4** — Inclui dependências, artefatos, acesso, auditoria e menor privilégio.
- **5** — Demonstra visão completa de segurança da cadeia de software e governança operacional.

**Perguntas de aprofundamento:**

1. Como impediria que uma senha aparecesse nos logs?
2. Como trataria uma vulnerabilidade crítica encontrada em uma dependência?
3. Quem deveria ter permissão para implantar em produção?

---

## Pergunta 46 — Ambientes de desenvolvimento, teste e produção

**Nível:** Pleno  
**Categoria:** Ambientes e configuração

**Pergunta do entrevistador:**

Como você organizaria os ambientes de desenvolvimento, teste, homologação e produção para aumentar a confiança nas entregas sem criar ambientes excessivamente complexos?

**O que essa pergunta avalia:**

Avalia capacidade de definir ambientes adequados, reduzir divergências, proteger dados e equilibrar custo operacional com qualidade.

**Resposta esperada:**

Eu definiria o propósito de cada ambiente e evitaria criar ambientes sem uma necessidade clara.

### Desenvolvimento

Deve permitir feedback rápido, execução local e experimentação controlada.

### Teste automatizado

Deve ser previsível, reproduzível e adequado para testes unitários, integração e contrato.

### Homologação ou validação

Deve representar de forma razoável as integrações e configurações relevantes para produção.

### Produção

Deve possuir controles de acesso, observabilidade, backups, procedimentos operacionais e proteção de dados.

Eu avaliaria:

- Similaridade de versões;
- Banco e dependências;
- Configuração;
- Dados sintéticos ou anonimizados;
- Acesso;
- Custo;
- Tempo de provisionamento;
- Isolamento;
- Automação;
- Capacidade de reproduzir problemas.

Não tentaria criar uma cópia perfeita de produção em todos os ambientes se o custo fosse inviável. Porém, as diferenças importantes deveriam ser conhecidas e tratadas.

**Explicação didática:**

Ambientes muito diferentes podem dar uma falsa sensação de segurança. Uma aplicação pode funcionar em homologação e falhar em produção porque:

- O banco possui volume muito maior;
- Há regras diferentes de rede;
- A configuração não é equivalente;
- A versão de uma dependência mudou;
- Os dados possuem formatos diferentes;
- Os limites de recursos são distintos.

O objetivo não é eliminar todas as diferenças, mas garantir que as diferenças relevantes sejam visíveis.

**Exemplo prático:**

Um teste de desempenho não deveria utilizar apenas um banco vazio se o problema aparece depois que a base cresce. O time poderia utilizar dados sintéticos representativos, protegendo informações reais.

**Exemplo de código:**

Uma configuração externa poderia ser organizada assim:

~~~yaml
spring:
  application:
    name: pedidos

observability:
  environment: ${APP_ENVIRONMENT}
  log-level: ${LOG_LEVEL:INFO}

integrations:
  pagamento-url: ${PAGAMENTO_URL}
~~~

O código permanece igual; as configurações são fornecidas pelo ambiente.

**Como o candidato deve responder:**

O candidato deve:

- Definir propósito para cada ambiente;
- Considerar paridade;
- Proteger dados;
- Mencionar automação;
- Falar sobre custo e complexidade;
- Considerar diferenças de volume e infraestrutura;
- Relacionar ambientes ao pipeline.

Deve evitar defender uma quantidade fixa de ambientes sem analisar o contexto do produto.

**Resposta fraca ou incompleta:**

“Eu criaria desenvolvimento, homologação e produção e faria testes manuais em homologação.”

A resposta não aborda automação, segurança de dados, paridade ou propósito dos ambientes.

**Critérios de avaliação:**

- **0** — Não diferencia os ambientes.
- **1** — Cria ambientes sem propósito definido.
- **2** — Conhece desenvolvimento, homologação e produção, mas não trata diferenças.
- **3** — Define objetivos básicos para cada ambiente.
- **4** — Considera automação, dados, segurança, paridade e custo.
- **5** — Demonstra estratégia pragmática, reproduzível e orientada à confiança da entrega.

**Perguntas de aprofundamento:**

1. Como testaria uma aplicação que depende de dados semelhantes aos de produção?
2. Quais diferenças entre homologação e produção você consideraria mais perigosas?
3. Como reduziria o tempo necessário para criar um ambiente de teste?

---

## Pergunta 47 — Deploy de uma funcionalidade que depende de banco

**Nível:** Sênior  
**Categoria:** Release e banco de dados

**Pergunta do entrevistador:**

Como você planejaría o deploy de uma funcionalidade que exige alteração no banco de dados, mudança no código Java e atualização de uma integração externa?

**O que essa pergunta avalia:**

Avalia coordenação de mudanças dependentes, compatibilidade entre versões, planejamento de release e redução de risco em produção.

**Resposta esperada:**

Eu dividiria a entrega em etapas compatíveis e verificáveis.

Uma sequência possível seria:

1. Adicionar a estrutura nova no banco sem remover a antiga;
2. Publicar o código capaz de funcionar com as duas estruturas;
3. Validar a integração externa;
4. Introduzir o novo contrato de forma compatível;
5. Ativar a escrita ou publicação dos novos dados;
6. Migrar os dados existentes gradualmente;
7. Implantar a nova lógica;
8. Ativar a funcionalidade por feature flag;
9. Monitorar;
10. Remover componentes antigos somente após estabilização.

Eu avaliaria:

- Dependências entre versões;
- Compatibilidade de leitura e escrita;
- Tempo de migração;
- Locks;
- Volume de dados;
- Falhas de integração;
- Idempotência;
- Rollback;
- Reprocessamento;
- Observabilidade;
- Comunicação com outros times.

Também definiria uma ordem segura entre produtores e consumidores. Uma API nova não deve ser exigida antes que todos os consumidores estejam preparados.

**Explicação didática:**

Quando banco, aplicação e integração mudam ao mesmo tempo, o risco de falha parcial aumenta.

A estratégia expand-and-contract reduz esse risco:

- **Expand:** adicionar estruturas e capacidades compatíveis;
- **Migrate:** mover dados e consumidores gradualmente;
- **Contract:** remover o que ficou obsoleto depois da transição.

Essa estratégia permite que versões antigas e novas coexistam durante o deploy.

**Exemplo prático:**

Para trocar um campo `status` por uma estrutura mais detalhada:

1. Criar `status_detalhado`;
2. Manter `status`;
3. Escrever nos dois campos;
4. Atualizar consumidores;
5. Validar consistência;
6. Ler da nova estrutura;
7. Remover o campo antigo depois.

**Exemplo de código:**

Um modelo de transição poderia ser:

~~~java
public class Pedido {

    private Status status;
    private StatusDetalhado statusDetalhado;

    public void atualizarStatus(Status novoStatus) {
        this.status = novoStatus;

        // Mantém compatibilidade durante a transição.
        this.statusDetalhado =
                StatusDetalhado.aPartirDe(novoStatus);
    }
}
~~~

O código é apenas ilustrativo. Em uma aplicação real, seria necessário avaliar persistência, concorrência e compatibilidade com consumidores.

**Como o candidato deve responder:**

O candidato deve:

- Planejar a mudança em fases;
- Falar sobre compatibilidade;
- Considerar banco, código e integração;
- Mencionar rollback;
- Abordar migração gradual;
- Incluir feature flags;
- Considerar consumidores antigos;
- Explicar como monitoraria a transição.

Deve evitar fazer uma alteração destrutiva e implantar todas as partes simultaneamente sem plano de recuperação.

**Resposta fraca ou incompleta:**

“Eu faria a migração do banco, subiria o novo código e depois atualizaria a integração.”

Essa sequência pode quebrar versões antigas e não considera falhas parciais ou compatibilidade.

**Critérios de avaliação:**

- **0** — Não reconhece os riscos da mudança conjunta.
- **1** — Propõe deploy simultâneo e destrutivo.
- **2** — Considera etapas, mas não trata compatibilidade.
- **3** — Planeja uma implantação controlada.
- **4** — Inclui expand-and-contract, feature flags, rollback e monitoramento.
- **5** — Demonstra domínio de releases complexos, coexistência de versões e recuperação de falhas parciais.

**Perguntas de aprofundamento:**

1. O que faria se a migração de dados falhasse no meio?
2. Como garantiria que consumidores antigos continuassem funcionando?
3. Como definiria o momento correto de remover a estrutura antiga?

---

## Pergunta 48 — Métricas de desempenho da entrega

**Nível:** Sênior  
**Categoria:** Métricas e melhoria contínua

**Pergunta do entrevistador:**

Quais métricas você acompanharia para avaliar a eficiência e a confiabilidade da entrega de software de um time Java?

**O que essa pergunta avalia:**

Avalia compreensão sobre métricas de engenharia, capacidade de interpretar dados e cuidado para não transformar indicadores em metas que incentivem comportamentos inadequados.

**Resposta esperada:**

Eu acompanharia métricas relacionadas a fluxo, qualidade e estabilidade.

Algumas métricas importantes são:

- Frequência de deploy;
- Lead time da alteração;
- Tempo entre aprovação e produção;
- Taxa de falhas após mudança;
- Tempo médio de recuperação;
- Tempo de ciclo;
- Tempo de espera para revisão;
- Tempo de execução do pipeline;
- Taxa de falha do pipeline;
- Quantidade de rollback;
- Defeitos encontrados após a entrega;
- Incidentes;
- Disponibilidade;
- Latência;
- Satisfação do time;
- Retrabalho.

Também analisaria métricas de produto, como:

- Conversão;
- Abandono;
- Erros por jornada;
- Tempo de conclusão;
- Reclamações;
- Uso da funcionalidade.

Eu evitaria usar uma métrica isolada como objetivo absoluto. Aumentar a frequência de deploy, por exemplo, não é positivo se vier acompanhado de aumento de incidentes.

O ideal é observar tendências, segmentar por tipo de mudança e usar os dados para melhorar o sistema de trabalho, não para punir pessoas.

**Explicação didática:**

Métricas de entrega devem responder perguntas como:

- O time consegue entregar com frequência?
- As mudanças chegam com segurança?
- Quando algo dá errado, a recuperação é rápida?
- Onde existe espera ou retrabalho?
- A entrega gera valor para o usuário?

É importante distinguir métricas de resultado de métricas de atividade. O número de commits, linhas de código ou horas trabalhadas geralmente não indica qualidade ou valor.

Métricas mal utilizadas podem gerar comportamentos artificiais, como dividir mudanças apenas para aumentar contagens ou evitar alterações difíceis.

**Exemplo prático:**

Se o lead time aumentou, eu investigaria:

- Filas de revisão;
- Branches longas;
- Pipeline lento;
- Dependências entre times;
- Testes instáveis;
- Aprovações manuais;
- Falta de clareza nos requisitos.

A métrica indica que há um problema, mas não explica sozinha a causa.

**Exemplo de código:**

Não se aplica diretamente. O tema envolve indicadores do processo e da operação.

**Como o candidato deve responder:**

O candidato deve:

- Mencionar frequência de deploy;
- Falar sobre lead time;
- Incluir falhas após mudanças e recuperação;
- Considerar pipeline e revisão;
- Relacionar métricas técnicas a produto;
- Alertar contra métricas de vaidade;
- Explicar que indicadores devem apoiar melhorias, não punições.

Deve evitar usar apenas quantidade de commits, horas ou linhas de código como medida de produtividade.

**Resposta fraca ou incompleta:**

“Eu mediria quantas tarefas o time entrega por sprint e quantos commits cada pessoa faz.”

Essa resposta mede atividade, mas não confiabilidade, tempo de fluxo, valor ou impacto da entrega.

**Critérios de avaliação:**

- **0** — Não propõe métricas úteis.
- **1** — Usa apenas quantidade de tarefas ou commits.
- **2** — Menciona velocidade, mas ignora qualidade e estabilidade.
- **3** — Considera tempo de entrega e falhas.
- **4** — Inclui fluxo, recuperação, pipeline, qualidade e produto.
- **5** — Demonstra uso responsável de métricas, análise de tendências e melhoria sistêmica sem incentivar comportamentos disfuncionais.

**Perguntas de aprofundamento:**

1. Como evitaria que uma métrica fosse usada para punir o time?
2. O que faria se a frequência de deploy aumentasse, mas os incidentes também?
3. Como diferenciaria um problema de processo de um problema de capacidade?

---

## Pergunta 49 — Planejamento de uma release de alto risco

**Nível:** Sênior  
**Categoria:** Planejamento de release

**Pergunta do entrevistador:**

Como você organizaria uma release que envolve uma alteração crítica em pagamentos, atualização de dependências, migração de banco e mudanças coordenadas com outros times?

**O que essa pergunta avalia:**

Avalia planejamento de releases complexos, coordenação, gestão de riscos, comunicação e capacidade de criar critérios objetivos para avançar ou interromper a implantação.

**Resposta esperada:**

Eu começaria dividindo a release em mudanças menores e identificando o caminho crítico.

Mapearia:

- Escopo;
- Objetivo;
- Times envolvidos;
- Dependências;
- Contratos;
- Alterações de banco;
- Riscos de segurança;
- Impacto financeiro;
- Requisitos de disponibilidade;
- Estratégia de testes;
- Plano de implantação;
- Plano de rollback;
- Responsáveis;
- Janela de mudança;
- Critérios de sucesso;
- Critérios de interrupção.

Antes da produção, buscaria:

- Testes unitários e de integração;
- Testes de contrato;
- Testes de desempenho;
- Testes de segurança;
- Testes de idempotência;
- Testes de migração;
- Validação de reconciliação;
- Simulação de rollback;
- Confirmação das dependências;
- Verificação de alertas e dashboards.

Durante a implantação, utilizaria liberação gradual quando possível. Também estabeleceria uma sala ou canal de acompanhamento, responsáveis por cada área e um plano claro de comunicação.

A promoção para a próxima etapa deveria depender de evidências, não apenas de uma decisão baseada em horário.

**Explicação didática:**

Releases de alto risco precisam de preparação técnica e coordenação operacional.

Um plano de release deve responder:

- O que será alterado?
- Em qual ordem?
- Quem decide avançar?
- O que será monitorado?
- Quando interromper?
- Como recuperar?
- Como tratar dados já processados?
- Quem comunica o status?

Mesmo com planejamento, imprevistos podem ocorrer. Por isso, a preparação deve incluir mecanismos para detectar e limitar o impacto.

**Exemplo prático:**

Para uma nova autorização de pagamento:

1. Implantar mudanças compatíveis;
2. Habilitar para usuários internos;
3. Processar uma pequena parcela;
4. Comparar taxa de aprovação e falha;
5. Verificar duplicidades;
6. Expandir gradualmente;
7. Executar reconciliação;
8. Manter o plano de desativação disponível.

**Exemplo de código:**

Um critério de interrupção poderia ser documentado assim:

~~~yaml
release-criteria:
  continue-if:
    payment-error-rate: "< 0.5%"
    duplicate-charge-count: 0
    p95-latency: "< 800ms"

  stop-if:
    payment-error-rate: "> 1%"
    duplicate-charge-count: "> 0"
    reconciliation-failure: true
~~~

Os limites reais devem ser definidos a partir do comportamento normal do produto e da criticidade da operação.

**Como o candidato deve responder:**

O candidato deve:

- Dividir a release em etapas;
- Mapear dependências;
- Considerar pagamentos, banco e segurança;
- Definir testes e critérios de promoção;
- Incluir monitoramento;
- Preparar rollback e reconciliação;
- Definir responsáveis e comunicação;
- Propor liberação gradual.

Deve evitar confiar apenas em uma checklist ou em uma janela de deploy sem critérios objetivos.

**Resposta fraca ou incompleta:**

“Eu marcaria uma janela de mudança, avisaria os times e faria todos os deploys juntos.”

Essa abordagem aumenta o risco e não trata compatibilidade, validação gradual ou recuperação.

**Critérios de avaliação:**

- **0** — Não estrutura uma release complexa.
- **1** — Faz deploy simultâneo sem plano de recuperação.
- **2** — Lista tarefas, mas não define critérios ou responsáveis.
- **3** — Planeja testes, sequência e comunicação.
- **4** — Inclui riscos, métricas, rollback, reconciliação e rollout gradual.
- **5** — Demonstra liderança completa de releases críticas, com governança proporcional e foco em segurança operacional.

**Perguntas de aprofundamento:**

1. Quais critérios fariam você interromper a release?
2. Como coordenaria times com calendários diferentes?
3. Como trataria uma cobrança processada durante uma falha parcial?

---

## Pergunta 50 — Cultura de responsabilidade pela entrega

**Nível:** Sênior  
**Categoria:** Liderança técnica e DevOps

**Pergunta do entrevistador:**

Como você criaria uma cultura em que o time Java se responsabiliza não apenas pelo código, mas também pela qualidade da entrega, operação e resultado do produto?

**O que essa pergunta avalia:**

Avalia maturidade de liderança, cultura de ownership, colaboração entre desenvolvimento e operação, autonomia e responsabilidade compartilhada.

**Resposta esperada:**

Eu começaria deixando claro que a responsabilidade pelo produto é compartilhada pelo time. Isso não significa que todos precisam dominar todas as áreas imediatamente, mas que o time deve participar do ciclo completo.

Eu promoveria:

- Participação de desenvolvimento em decisões de produto;
- Critérios de pronto que incluam testes, observabilidade e documentação;
- Acompanhamento após o deploy;
- Rodízio de suporte e conhecimento;
- Runbooks;
- Dashboards acessíveis;
- Alertas acionáveis;
- Revisões pós-incidente sem culpabilização;
- Pareamento;
- Compartilhamento de conhecimento;
- Participação em refinamentos;
- Revisão de riscos;
- Melhoria contínua do pipeline;
- Objetivos técnicos conectados ao produto.

Também removeria obstáculos organizacionais. Não é coerente exigir ownership do time e, ao mesmo tempo, impedir que ele acesse logs, acompanhe métricas ou participe de decisões de implantação.

O Tech Lead deve modelar o comportamento esperado, mas não se tornar o único responsável por produção. A responsabilidade deve ser distribuída de forma progressiva, considerando a maturidade e o suporte disponível.

**Explicação didática:**

Ownership não é culpar o time quando algo falha. É dar às pessoas:

- Contexto;
- Autonomia;
- Ferramentas;
- Acesso;
- Responsabilidade;
- Feedback;
- Apoio.

Se o time só entrega código e outra área realiza todo o deploy e diagnóstico, os desenvolvedores podem não compreender o impacto real de suas decisões.

Por outro lado, não é adequado transferir responsabilidade operacional sem treinamento, documentação ou capacidade de resposta.

**Exemplo prático:**

Depois de implantar uma nova API, o time poderia acompanhar:

- Taxa de erro;
- Latência;
- Volume;
- Uso da funcionalidade;
- Falhas de integração;
- Alertas;
- Feedback dos usuários.

Se algo der errado, o time participa da investigação e da correção, com apoio de plataforma, segurança ou operações quando necessário.

**Exemplo de código:**

Uma definição conceitual de prontidão poderia ser:

~~~text
Pronto para entrega quando:
- critérios de aceite foram atendidos;
- testes relevantes foram executados;
- riscos conhecidos foram registrados;
- logs e métricas estão disponíveis;
- configuração está documentada;
- estratégia de implantação foi definida;
- rollback ou desativação foi avaliado;
- responsáveis pelo acompanhamento estão identificados.
~~~

Essa lista deve ser adaptada ao contexto e não utilizada como burocracia indiscriminada.

**Como o candidato deve responder:**

O candidato deve:

- Falar sobre responsabilidade compartilhada;
- Relacionar desenvolvimento, entrega e operação;
- Mencionar observabilidade;
- Incluir aprendizado após incidentes;
- Evitar culpabilização;
- Considerar autonomia com suporte;
- Falar sobre documentação e rodízio;
- Conectar qualidade técnica a resultado do produto.

Deve evitar afirmar que o time deve assumir toda a operação sem acesso, treinamento ou apoio adequado.

**Resposta fraca ou incompleta:**

“Eu faria os desenvolvedores acompanharem a produção e resolverem todos os incidentes.”

Essa resposta transfere responsabilidade sem explicar capacitação, processos, limites, suporte ou cultura de aprendizado.

**Critérios de avaliação:**

- **0** — Não compreende responsabilidade pelo ciclo completo.
- **1** — Confunde ownership com cobrança ou culpa.
- **2** — Menciona acompanhamento da produção, mas não cria mecanismos sustentáveis.
- **3** — Propõe participação do time em deploy e incidentes.
- **4** — Inclui observabilidade, documentação, aprendizado e autonomia progressiva.
- **5** — Demonstra visão madura de cultura DevOps, responsabilidade compartilhada, segurança psicológica e melhoria contínua orientada ao produto.

**Perguntas de aprofundamento:**

1. Como desenvolveria a autonomia operacional de um time inexperiente?
2. O que faria se o time resistisse a participar de incidentes?
3. Como evitaria que ownership se transformasse em sobrecarga ou plantão permanente?
4. Como saberia que a cultura de responsabilidade está funcionando?

---

# Resumo desta parte

| Item | Resultado |
|---|---|
| Perguntas apresentadas | 41 a 50 |
| Níveis abordados | Pleno e Sênior |
| Temas principais | Quality gates, artefatos imutáveis, estratégias de deploy, rollback, segurança do CI/CD, ambientes, releases complexas, métricas e ownership |
| Perguntas restantes | 50 |

## Competências exploradas

- Definição de critérios de qualidade;
- Automação de validações;
- Rastreabilidade de artefatos;
- Separação entre código e configuração;
- Estratégias rolling, blue-green e canary;
- Planejamento de rollback;
- Gestão de incidentes de deploy;
- Segurança da cadeia de software;
- Proteção de credenciais;
- Organização de ambientes;
- Migrações coordenadas;
- Planejamento de releases críticas;
- Métricas de entrega;
- Melhoria contínua;
- Cultura de ownership;
- Integração entre desenvolvimento, produto e operação.

---

# Roteiro Completo de Entrevista — Tech Lead de um Time Java

## Parte 6 de 10 — Perguntas 51 a 60

**Foco desta parte:** qualidade, segurança, testes, confiabilidade, proteção de dados e gestão de riscos em produtos Java e Spring Boot.

> As perguntas consideram um Tech Lead responsável por orientar decisões técnicas, proteger a qualidade da entrega e garantir que o produto seja seguro, testável, confiável e sustentável.

## Fluxo de qualidade e segurança

~~~mermaid
flowchart TD
    A[Requisito do produto] --> B[Análise de riscos]
    B --> C[Desenho da solução]
    C --> D[Implementação]
    D --> E[Testes automatizados]
    E --> F[Validação de segurança]
    F --> G[Code review]
    G --> H[CI/CD]
    H --> I[Deploy controlado]
    I --> J[Monitoramento]
    J --> K[Incidentes e feedback]
    K --> B

    L[Privacidade e proteção de dados] --> B
    L --> D
    L --> F
    L --> J
~~~

---

## Pergunta 51 — Definição de qualidade para o produto

**Nível:** Pleno  
**Categoria:** Qualidade e entrega

**Pergunta do entrevistador:**

Como você definiria qualidade para um produto desenvolvido com Java e Spring Boot? Quais dimensões deveriam ser consideradas além do código funcionar?

**O que essa pergunta avalia:**

Avalia se o candidato possui uma visão ampla de qualidade, considerando comportamento, segurança, desempenho, manutenção, operação e valor entregue ao usuário.

**Resposta esperada:**

Qualidade não significa apenas ausência de erros de compilação. Eu consideraria diferentes dimensões:

- Atendimento aos requisitos;
- Experiência do usuário;
- Correção das regras de negócio;
- Segurança;
- Disponibilidade;
- Desempenho;
- Escalabilidade;
- Observabilidade;
- Manutenibilidade;
- Testabilidade;
- Compatibilidade;
- Acessibilidade, quando aplicável;
- Facilidade de operação;
- Capacidade de recuperação;
- Custo sustentável;
- Conformidade com requisitos legais e organizacionais.

Também avaliaria a qualidade do processo de entrega:

- Clareza dos critérios de aceite;
- Testes adequados;
- Revisão de código;
- Pipeline confiável;
- Deploy reproduzível;
- Monitoramento;
- Plano de rollback;
- Aprendizado após incidentes.

Uma funcionalidade pode funcionar no cenário feliz e ainda possuir baixa qualidade se expuser dados, falhar sob carga, não puder ser monitorada ou criar riscos excessivos para a operação.

**Explicação didática:**

Qualidade é uma propriedade do produto como um todo, não apenas da implementação. Uma API pode retornar a resposta correta e, mesmo assim:

- Permitir acesso indevido;
- Demorar vários segundos;
- Falhar quando um parceiro estiver indisponível;
- Não registrar informações suficientes para diagnóstico;
- Ser impossível de alterar com segurança.

O Tech Lead deve ajudar o time a explicitar quais dimensões são mais importantes para cada contexto.

Uma funcionalidade de consulta pública pode priorizar desempenho e disponibilidade. Uma operação financeira deve dar mais peso a integridade, segurança, auditoria e idempotência.

**Exemplo prático:**

Para uma funcionalidade de alteração de endereço, a definição de qualidade poderia incluir:

- Usuário autorizado consegue alterar seu próprio endereço;
- Usuário não acessa dados de outra pessoa;
- Dados obrigatórios são validados;
- Alterações são auditáveis;
- Testes cobrem erros e concorrência;
- A API responde dentro do limite esperado;
- Dados sensíveis não aparecem nos logs;
- A operação pode ser monitorada em produção.

**Exemplo de código:**

Uma validação de entrada pode ser feita no contrato da API:

~~~java
public record AtualizarEnderecoRequest(
        @NotBlank String logradouro,
        @NotBlank String cidade,
        @NotBlank String estado,
        @Pattern(regexp = "\\d{5}-?\\d{3}")
        String cep
) {
}
~~~

Essa validação é apenas uma parte da qualidade. Ainda seria necessário verificar autorização, persistência, auditoria, testes, observabilidade e comportamento em caso de falha.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar qualidade de simples compilação;
- Mencionar segurança;
- Considerar desempenho e disponibilidade;
- Falar sobre testes;
- Incluir observabilidade e operação;
- Relacionar qualidade ao contexto do produto;
- Demonstrar que qualidade deve ser construída durante todo o ciclo de entrega.

Deve evitar afirmar que qualidade é responsabilidade exclusiva do time de testes.

**Resposta fraca ou incompleta:**

“Qualidade significa o código funcionar, passar nos testes e não apresentar bugs.”

Essa resposta é limitada e não considera segurança, desempenho, manutenção, operação ou experiência do usuário.

**Critérios de avaliação:**

- **0** — Não consegue definir qualidade.
- **1** — Reduz qualidade a compilação ou ausência de bugs.
- **2** — Menciona testes e funcionamento básico.
- **3** — Inclui testes, manutenção e desempenho.
- **4** — Considera segurança, operação, observabilidade e experiência do usuário.
- **5** — Demonstra visão sistêmica, contextual e orientada ao valor do produto.

**Perguntas de aprofundamento:**

1. Como decidiria quais atributos de qualidade são prioritários?
2. Como mediria qualidade após a entrega?
3. Como equilibraria qualidade, prazo e custo?

---

## Pergunta 52 — Testes de segurança em uma API

**Nível:** Pleno  
**Categoria:** Segurança e testes

**Pergunta do entrevistador:**

Como você testaria a segurança de uma API Spring Boot que possui autenticação, autorização e acesso a dados de clientes?

**O que essa pergunta avalia:**

Avalia a capacidade de testar controles de segurança, incluindo identidade, permissões, acesso por recurso e proteção contra exposição indevida de dados.

**Resposta esperada:**

Eu criaria testes para diferentes dimensões de segurança:

- Requisição sem autenticação;
- Token inválido;
- Token expirado;
- Usuário sem a permissão necessária;
- Usuário com permissão parcial;
- Usuário tentando acessar recurso de outra pessoa;
- Acesso administrativo indevido;
- Alteração de identificadores na URL;
- Dados obrigatórios inválidos;
- Payloads inesperados;
- Tentativas de manipulação de filtros;
- Exposição de informações em mensagens de erro;
- Dados sensíveis retornados indevidamente.

Também verificaria:

- Escopos e roles;
- Regras por endpoint;
- Regras por recurso;
- Controle de acesso em serviços internos;
- Configuração de CORS;
- Rate limiting;
- Auditoria;
- Mascaramento de informações;
- Segurança dos headers;
- Gestão de segredos.

Os testes deveriam existir em diferentes níveis:

- Testes unitários para regras de autorização;
- Testes de integração para o contexto de segurança;
- Testes de contrato para garantir respostas seguras;
- Testes automatizados especializados;
- Testes manuais ou de análise técnica quando necessário.

**Explicação didática:**

Uma aplicação pode ter autenticação funcionando e ainda possuir falhas graves de autorização.

Por exemplo, o usuário acessa corretamente com seu token, mas consegue alterar o identificador da URL e visualizar o pedido de outra pessoa. O problema não está na autenticação, e sim na autorização do recurso.

Os testes devem validar tanto o caminho permitido quanto os caminhos proibidos.

**Exemplo prático:**

Para o endpoint:

~~~text
GET /clientes/{clienteId}/pedidos
~~~

Os cenários poderiam incluir:

1. Cliente autenticado consultando seus próprios pedidos;
2. Cliente autenticado tentando consultar pedidos de outro cliente;
3. Usuário interno com acesso autorizado;
4. Usuário interno sem a permissão necessária;
5. Requisição sem token;
6. Token expirado;
7. Cliente inexistente;
8. Resposta sem dados sensíveis.

**Exemplo de código:**

Um teste de autorização poderia ser:

~~~java
@WebMvcTest(PedidoController.class)
class PedidoControllerSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "cliente-1")
    void deveNegarAcessoAoPedidoDeOutroCliente()
            throws Exception {

        mockMvc.perform(
                get("/clientes/cliente-2/pedidos"))
                .andExpect(status().isForbidden());
    }
}
~~~

Esse teste precisa estar alinhado com a forma como a aplicação implementa a autorização. Também seria necessário testar o serviço e a integração real com as regras de segurança.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar autenticação e autorização;
- Testar acesso permitido e negado;
- Considerar segurança no nível do recurso;
- Mencionar tokens inválidos e expirados;
- Avaliar exposição de dados;
- Incluir testes de integração;
- Considerar permissões administrativas;
- Falar sobre logs e auditoria.

Deve evitar testar apenas se um usuário consegue acessar um endpoint com um token válido.

**Resposta fraca ou incompleta:**

“Eu testaria se o JWT é válido e se a API retorna 401 quando não há login.”

Essa resposta não cobre autorização, acesso indevido a recursos ou vazamento de informações.

**Critérios de avaliação:**

- **0** — Não sabe como testar segurança.
- **1** — Testa apenas presença ou ausência do token.
- **2** — Inclui usuários não autenticados, mas ignora permissões.
- **3** — Testa autenticação e autorização básicas.
- **4** — Considera acesso por recurso, dados sensíveis e diferentes níveis de teste.
- **5** — Demonstra estratégia completa de testes de segurança, incluindo abuso, auditoria e cenários negativos.

**Perguntas de aprofundamento:**

1. Como testaria uma falha de autorização por objeto?
2. Qual é a diferença entre HTTP 401 e HTTP 403?
3. Como impediria que dados sensíveis aparecessem nas respostas de erro?

---

## Pergunta 53 — Gestão de vulnerabilidade em dependências

**Nível:** Pleno  
**Categoria:** Segurança da cadeia de software

**Pergunta do entrevistador:**

O pipeline identificou uma vulnerabilidade crítica em uma dependência utilizada por várias aplicações Java. Como você avaliaria e conduziria a correção?

**O que essa pergunta avalia:**

Avalia capacidade de interpretar vulnerabilidades, priorizar riscos, coordenar correções e evitar respostas automáticas sem análise do contexto.

**Resposta esperada:**

Eu começaria confirmando:

- Qual dependência está vulnerável;
- Qual versão está instalada;
- Se a vulnerabilidade é realmente explorável no contexto da aplicação;
- Qual componente ou funcionalidade é afetado;
- Se a aplicação está exposta;
- Qual versão corrigida está disponível;
- Se há impacto de compatibilidade;
- Se a dependência é direta ou transitiva;
- Se outras aplicações também utilizam a mesma biblioteca;
- Qual é o prazo de exposição aceitável.

Em seguida, definiria a ação:

- Atualizar para versão corrigida;
- Aplicar uma correção temporária;
- Remover ou substituir a dependência;
- Desativar uma funcionalidade afetada;
- Restringir o acesso;
- Criar uma mitigação temporária;
- Aceitar formalmente o risco apenas se houver justificativa e prazo.

A correção deveria ser testada em ambiente controlado, verificando:

- Compilação;
- Testes automatizados;
- Integrações;
- Compatibilidade;
- Desempenho;
- Segurança;
- Deploy;
- Comportamento em produção.

Eu também verificaria se a vulnerabilidade já foi explorada, se existe necessidade de rotação de segredos e se a correção deve ser tratada como incidente.

**Explicação didática:**

Nem toda vulnerabilidade possui o mesmo risco em todos os contextos. Uma biblioteca vulnerável pode estar presente, mas a funcionalidade afetada pode não ser utilizada. Ainda assim, uma vulnerabilidade crítica deve ser investigada rapidamente.

A classificação técnica precisa ser combinada com:

- Exposição da aplicação;
- Facilidade de exploração;
- Sensibilidade dos dados;
- Impacto operacional;
- Disponibilidade de correção;
- Existência de mitigação.

O Tech Lead não deve ignorar o alerta nem atualizar dependências em produção sem validação.

**Exemplo prático:**

Se uma biblioteca de processamento de arquivos possui uma vulnerabilidade explorável por uploads públicos, a prioridade é maior do que se a mesma biblioteca estiver presente em um módulo não exposto e sem uso. Mesmo assim, o caso deve ser documentado e acompanhado.

**Exemplo de código:**

Uma dependência poderia ser atualizada de forma controlada:

~~~xml
<dependency>
    <groupId>org.exemplo</groupId>
    <artifactId>biblioteca-segura</artifactId>
    <version>3.4.2</version>
</dependency>
~~~

Após a atualização, seria necessário executar testes, verificar dependências transitivas e validar o comportamento da aplicação.

**Como o candidato deve responder:**

O candidato deve:

- Investigar severidade e explorabilidade;
- Verificar se a dependência é usada;
- Identificar versão corrigida;
- Considerar impacto de compatibilidade;
- Priorizar correção;
- Avaliar mitigação;
- Testar antes da produção;
- Considerar rotação de segredos e investigação de exploração.

Deve evitar afirmar que todo alerta pode ser ignorado por ser “apenas uma dependência transitiva” ou atualizar sem executar validações.

**Resposta fraca ou incompleta:**

“Eu atualizaria a dependência para a última versão e rodaria o pipeline.”

Essa pode ser uma ação necessária, mas não trata impacto, compatibilidade, exploração ou comunicação do risco.

**Critérios de avaliação:**

- **0** — Ignora ou minimiza a vulnerabilidade.
- **1** — Atualiza sem análise ou validação.
- **2** — Atualiza a dependência, mas não avalia o contexto.
- **3** — Investiga a vulnerabilidade e testa a correção.
- **4** — Considera exploração, mitigação, compatibilidade e prazo.
- **5** — Demonstra gestão completa de vulnerabilidades, com priorização baseada em risco e coordenação entre times.

**Perguntas de aprofundamento:**

1. Como lidaria se a versão corrigida quebrasse uma integração?
2. O que faria se não existisse correção disponível?
3. Como saberia se uma vulnerabilidade transitiva realmente afeta a aplicação?

---

## Pergunta 54 — Proteção de dados sensíveis

**Nível:** Pleno  
**Categoria:** Segurança e privacidade

**Pergunta do entrevistador:**

Como você identificaria e protegeria dados sensíveis em uma aplicação Java que processa informações de clientes, pagamentos e documentos?

**O que essa pergunta avalia:**

Avalia compreensão sobre classificação, minimização, armazenamento, transmissão, logs, acesso e descarte de dados sensíveis.

**Resposta esperada:**

Eu começaria identificando quais dados são processados e classificando-os segundo sua sensibilidade e criticidade. Poderiam existir:

- Dados pessoais;
- Dados financeiros;
- Credenciais;
- Tokens;
- Documentos;
- Informações de autenticação;
- Dados de auditoria;
- Informações de saúde ou outras categorias especiais, quando aplicável.

Depois, avaliaria o ciclo completo:

- Coleta;
- Transporte;
- Processamento;
- Armazenamento;
- Consulta;
- Compartilhamento;
- Logs;
- Backups;
- Retenção;
- Exclusão.

Aplicaria princípios como:

- Minimização;
- Menor privilégio;
- Criptografia em trânsito;
- Criptografia em repouso quando necessária;
- Mascaramento;
- Tokenização;
- Controle de acesso;
- Auditoria;
- Retenção limitada;
- Remoção segura;
- Proteção de backups.

Eu impediria que senhas, tokens, dados completos de cartão e documentos desnecessários aparecessem em logs, mensagens de erro ou ferramentas de monitoramento.

Também envolveria segurança, privacidade e jurídico quando a classificação ou a obrigação regulatória exigisse.

**Explicação didática:**

Proteger dados não significa apenas criptografar o banco. Um dado pode vazar por:

- Log da aplicação;
- Mensagem de erro;
- Trace distribuído;
- Arquivo temporário;
- Backup;
- Ambiente de teste;
- Exportação manual;
- Dashboard;
- Ferramenta de suporte;
- Repositório de código.

Por isso, é importante mapear onde o dado passa e quem precisa acessá-lo.

**Exemplo prático:**

Em vez de registrar:

~~~text
Pagamento recebido: cartão=4111111111111111, cvv=123
~~~

O sistema deveria registrar apenas informações necessárias para diagnóstico:

~~~text
Pagamento recebido: pagamentoId=abc-123, provedor=xyz, status=APROVADO
~~~

Mesmo identificadores devem ser avaliados para verificar se podem ser associados a uma pessoa.

**Exemplo de código:**

Um DTO de resposta deve retornar apenas os campos necessários:

~~~java
public record ClienteResponse(
        Long id,
        String nome,
        String emailMascarado
) {
}
~~~

O código não deve expor automaticamente todos os campos da entidade persistida.

**Como o candidato deve responder:**

O candidato deve:

- Falar sobre classificação de dados;
- Considerar logs, backups e ambientes de teste;
- Mencionar minimização;
- Abordar criptografia e controle de acesso;
- Evitar exposição em DTOs;
- Considerar retenção e descarte;
- Demonstrar preocupação com privacidade e auditoria.

Deve evitar afirmar que basta ocultar o dado na tela para protegê-lo.

**Resposta fraca ou incompleta:**

“Eu criptografaria as informações no banco e restringiria o acesso.”

Essas medidas são importantes, mas não cobrem logs, backups, testes, transmissão, DTOs ou descarte.

**Critérios de avaliação:**

- **0** — Não reconhece dados sensíveis.
- **1** — Considera apenas senha ou cartão.
- **2** — Menciona criptografia, mas ignora o ciclo de vida.
- **3** — Considera armazenamento, acesso e logs.
- **4** — Inclui minimização, mascaramento, backups, ambientes e auditoria.
- **5** — Demonstra visão completa de privacidade e proteção de dados desde o desenho até a operação.

**Perguntas de aprofundamento:**

1. Quais dados você nunca colocaria em logs?
2. Como utilizaria dados de produção em testes?
3. Como trataria um pedido de exclusão de dados?

---

## Pergunta 55 — Testes de contrato entre serviços

**Nível:** Pleno  
**Categoria:** Integração e qualidade

**Pergunta do entrevistador:**

Como você utilizaria testes de contrato para reduzir falhas entre uma aplicação Spring Boot e seus consumidores ou provedores externos?

**O que essa pergunta avalia:**

Avalia compreensão sobre contratos de integração, responsabilidade de consumidores e provedores e prevenção de incompatibilidades.

**Resposta esperada:**

Testes de contrato verificam se as expectativas entre sistemas continuam válidas.

Eu utilizaria contratos para validar:

- Estrutura das requisições;
- Campos obrigatórios;
- Tipos de dados;
- Campos opcionais;
- Códigos HTTP;
- Formato dos erros;
- Regras de autenticação;
- Compatibilidade;
- Comportamento esperado;
- Eventos publicados;
- Mensagens consumidas.

O consumidor pode definir expectativas sobre o que precisa, enquanto o provedor verifica se consegue atendê-las. O contrato deve ser executado no pipeline antes da publicação de uma alteração incompatível.

Também consideraria:

- Versionamento;
- Compatibilidade retroativa;
- Eventos;
- Dados de exemplo;
- Mudanças de significado;
- Remoção de campos;
- Diferenças entre ambientes.

Testes de contrato não substituem testes unitários, de integração ou ponta a ponta. Eles protegem especificamente a fronteira entre sistemas.

**Explicação didática:**

Uma aplicação pode passar em todos os seus testes internos e ainda quebrar porque um serviço externo alterou o contrato.

Por exemplo, o consumidor espera o campo:

~~~json
{
  "status": "APPROVED"
}
~~~

Se o provedor alterar o valor para `AUTHORIZED`, a estrutura pode continuar válida, mas o comportamento do consumidor pode quebrar.

O contrato deve verificar tanto a forma quanto as expectativas relevantes.

**Exemplo prático:**

Um consumidor pode exigir que:

- O endpoint retorne HTTP 200 para uma consulta válida;
- O campo `pedidoId` esteja presente;
- O campo `status` aceite determinados valores;
- Erros de autorização retornem HTTP 403;
- O campo `valor` seja numérico;
- Campos opcionais possam ser ignorados quando ausentes.

**Exemplo de código:**

Um contrato conceitual poderia ser:

~~~json
{
  "request": {
    "method": "GET",
    "path": "/pedidos/123"
  },
  "response": {
    "status": 200,
    "body": {
      "pedidoId": "123",
      "status": "CRIADO"
    }
  }
}
~~~

A ferramenta utilizada para executar contratos pode variar, mas o princípio é validar a comunicação de forma automatizada.

**Como o candidato deve responder:**

O candidato deve:

- Explicar o objetivo do teste de contrato;
- Diferenciar contrato de teste ponta a ponta;
- Considerar consumidores e provedores;
- Mencionar compatibilidade;
- Incluir eventos e erros;
- Relacionar contrato ao pipeline;
- Considerar mudanças semânticas, não apenas estruturais.

Deve evitar dizer que o Swagger, sozinho, garante compatibilidade.

**Resposta fraca ou incompleta:**

“Eu documentaria a API e pediria para os consumidores testarem manualmente.”

Essa abordagem depende de comunicação manual e pode detectar incompatibilidades tarde demais.

**Critérios de avaliação:**

- **0** — Não compreende testes de contrato.
- **1** — Confunde contrato com documentação.
- **2** — Verifica apenas campos básicos.
- **3** — Explica contratos entre consumidor e provedor.
- **4** — Inclui erros, compatibilidade, eventos e pipeline.
- **5** — Demonstra estratégia madura para evolução distribuída e prevenção automatizada de quebras.

**Perguntas de aprofundamento:**

1. Quem deveria ser responsável por manter o contrato?
2. Como trataria uma alteração incompatível necessária?
3. Testes de contrato eliminam a necessidade de testes ponta a ponta?

---

## Pergunta 56 — Testes de desempenho e capacidade

**Nível:** Sênior  
**Categoria:** Desempenho e confiabilidade

**Pergunta do entrevistador:**

Como você planejaria testes de desempenho para uma API Java que será utilizada em uma operação crítica do produto?

**O que essa pergunta avalia:**

Avalia capacidade de definir cenários realistas, interpretar resultados e relacionar desempenho a requisitos de negócio.

**Resposta esperada:**

Eu começaria definindo os requisitos de desempenho:

- Volume esperado;
- Taxa de requisições;
- Picos;
- Concorrência;
- Tempo de resposta esperado;
- Percentis aceitáveis;
- Taxa de erro;
- Duração do teste;
- Crescimento previsto;
- Disponibilidade;
- Comportamento das dependências.

Depois, criaria cenários representativos, considerando:

- Distribuição real dos endpoints;
- Tamanho dos payloads;
- Perfil dos usuários;
- Dados semelhantes aos de produção;
- Consultas comuns e pesadas;
- Integrações externas;
- Cache;
- Concorrência;
- Processos assíncronos;
- Limites de infraestrutura.

Eu faria diferentes tipos de teste:

- Teste de carga;
- Teste de estresse;
- Teste de pico;
- Teste de duração;
- Teste de capacidade;
- Teste de recuperação.

Durante o teste, acompanharia:

- Latência média e percentis;
- Taxa de erro;
- CPU;
- Memória;
- Garbage collection;
- Threads;
- Pool de conexões;
- Banco;
- Filas;
- Dependências externas;
- Saturação de recursos.

O resultado deveria indicar se o sistema atende aos requisitos e onde estão os gargalos.

**Explicação didática:**

Um teste de desempenho não deve medir apenas quantas requisições a API consegue processar em um cenário artificial.

É necessário entender:

- Qual volume representa o uso real;
- Quais respostas são aceitáveis;
- O que ocorre sob picos;
- Como o sistema se recupera;
- Qual componente satura primeiro.

A média pode esconder problemas. Uma API com média de 200 ms pode possuir p99 de 5 segundos, afetando uma parcela importante dos usuários.

**Exemplo prático:**

Para uma API de finalização de compra, o teste poderia verificar:

- 500 requisições por segundo;
- p95 abaixo de 800 ms;
- taxa de erro inferior a 0,5%;
- comportamento durante indisponibilidade parcial do pagamento;
- recuperação após redução da carga;
- ausência de cobranças duplicadas.

**Exemplo de código:**

Um requisito de desempenho poderia ser registrado assim:

~~~yaml
performance-requirements:
  endpoint: POST /pedidos
  target-throughput: 500 req/s
  p95-latency: "< 800ms"
  p99-latency: "< 1500ms"
  error-rate: "< 0.5%"
  duplicate-operations: 0
~~~

Os valores devem ser definidos com base em dados do produto e não escolhidos arbitrariamente.

**Como o candidato deve responder:**

O candidato deve:

- Começar pelos requisitos;
- Criar cenários realistas;
- Diferenciar tipos de teste;
- Considerar dados e dependências;
- Avaliar percentis;
- Monitorar infraestrutura e banco;
- Relacionar desempenho à experiência do usuário;
- Definir critérios de aprovação.

Deve evitar testar apenas o endpoint com uma requisição isolada.

**Resposta fraca ou incompleta:**

“Eu enviaria muitas requisições e verificaria se a aplicação continuaria funcionando.”

Essa resposta não define volume, metas, cenários, métricas ou critérios objetivos.

**Critérios de avaliação:**

- **0** — Não sabe planejar um teste de desempenho.
- **1** — Faz apenas um teste de volume sem critérios.
- **2** — Considera latência, mas ignora dependências.
- **3** — Define carga, métricas e cenários básicos.
- **4** — Inclui percentis, saturação, dados realistas e recuperação.
- **5** — Demonstra planejamento de capacidade completo, orientado a requisitos e análise sistêmica.

**Perguntas de aprofundamento:**

1. Por que p95 e p99 são importantes?
2. Como testaria o sistema quando um serviço externo estivesse lento?
3. Como diferenciar um gargalo de aplicação de um gargalo do banco?

---

## Pergunta 57 — Testes de resiliência e falhas controladas

**Nível:** Sênior  
**Categoria:** Confiabilidade

**Pergunta do entrevistador:**

Como você verificaria se uma aplicação Spring Boot continua funcionando adequadamente quando suas dependências apresentam timeout, erro, lentidão ou indisponibilidade?

**O que essa pergunta avalia:**

Avalia capacidade de testar resiliência, degradação controlada, isolamento de falhas e recuperação.

**Resposta esperada:**

Eu identificaria as dependências críticas e opcionais e criaria cenários controlados de falha:

- Timeout;
- Erro HTTP 500;
- Resposta inválida;
- Conexão recusada;
- Latência elevada;
- Mensagem duplicada;
- Fila indisponível;
- Banco temporariamente inacessível;
- Falha durante uma operação;
- Reinício de uma instância.

Verificaria:

- Se existem timeouts;
- Se retries possuem limite;
- Se há backoff;
- Se o circuit breaker funciona;
- Se o fallback é válido;
- Se recursos são isolados;
- Se a aplicação continua atendendo funções não afetadas;
- Se os erros são observáveis;
- Se há recuperação após o retorno da dependência;
- Se não ocorrem duplicidades ou perda de dados.

Também avaliaria a experiência do usuário. Um fallback que apenas retorna sucesso quando a operação não foi concluída pode mascarar uma falha grave.

Os testes deveriam ocorrer em ambiente seguro, com impacto controlado e critérios claros de interrupção.

**Explicação didática:**

Sistemas distribuídos falham de maneiras diferentes. Uma dependência pode:

- Falhar imediatamente;
- Responder lentamente;
- Retornar respostas inconsistentes;
- Processar a solicitação e perder a resposta;
- Aceitar mensagens duplicadas;
- Recuperar gradualmente.

Testar apenas o cenário de serviço totalmente indisponível não é suficiente.

O objetivo não é provocar caos sem controle, mas descobrir se o sistema possui comportamento definido diante de falhas previsíveis.

**Exemplo prático:**

Se o serviço de recomendações estiver indisponível, a compra pode continuar sem recomendações.

Se o serviço de autorização de pagamento estiver indisponível, o sistema provavelmente não deve confirmar a compra como paga. O comportamento pode ser “em processamento” ou “não foi possível concluir”.

**Exemplo de código:**

Um teste conceitual de fallback poderia ser:

~~~java
@Test
void deveRetornarProcessamentoPendenteQuandoPagamentoEstiverIndisponivel() {
    when(clientePagamento.autorizar(any()))
            .thenThrow(new TimeoutException());

    ResultadoPagamento resultado =
            service.autorizar(pagamento);

    assertThat(resultado.status())
            .isEqualTo(StatusPagamento.EM_PROCESSAMENTO);
}
~~~

Além do resultado, seria necessário verificar métricas, logs, reprocessamento e ausência de efeitos duplicados.

**Como o candidato deve responder:**

O candidato deve:

- Testar diferentes tipos de falha;
- Considerar timeouts e lentidão;
- Validar retries e circuit breakers;
- Falar sobre fallback;
- Diferenciar dependências críticas e opcionais;
- Verificar idempotência;
- Considerar observabilidade e recuperação;
- Relacionar o comportamento ao negócio.

Deve evitar testar apenas se a aplicação retorna uma mensagem genérica de erro.

**Resposta fraca ou incompleta:**

“Eu desligaria o serviço externo e verificaria se a aplicação não cairia.”

Essa é uma forma inicial de teste, mas não abrange lentidão, duplicidade, recuperação, isolamento ou comportamento específico de cada operação.

**Critérios de avaliação:**

- **0** — Não considera falhas de dependências.
- **1** — Testa apenas indisponibilidade total.
- **2** — Menciona timeout, mas não verifica recuperação.
- **3** — Testa falhas e fallback básicos.
- **4** — Inclui resiliência, idempotência, observabilidade e isolamento.
- **5** — Demonstra estratégia completa de testes de falha controlada, orientada à continuidade e à integridade do produto.

**Perguntas de aprofundamento:**

1. Como testaria uma falha que ocorre depois que o parceiro processou a operação?
2. Como verificaria se o circuit breaker realmente protege a aplicação?
3. Que fallback seria inadequado para uma operação financeira?

---

## Pergunta 58 — Gestão de dados de teste

**Nível:** Pleno  
**Categoria:** Qualidade e segurança

**Pergunta do entrevistador:**

Como você organizaria dados de teste para uma aplicação Java que possui muitos cenários de negócio, sem depender de dados reais ou de bases compartilhadas instáveis?

**O que essa pergunta avalia:**

Avalia capacidade de criar testes previsíveis, seguros, isolados e representativos.

**Resposta esperada:**

Eu buscaria utilizar dados controlados, reproduzíveis e adequados ao objetivo de cada teste.

Consideraria:

- Builders ou factories de objetos;
- Fixtures versionadas;
- Dados sintéticos;
- Seeds controlados;
- Isolamento por teste;
- Limpeza após execução;
- Transações de teste;
- Containers descartáveis;
- Identificadores únicos;
- Dados representativos sem informações reais;
- Cenários de estados válidos e inválidos.

Evitaria depender de uma base compartilhada modificada manualmente por várias pessoas, pois isso gera:

- Testes instáveis;
- Dependências ocultas;
- Dificuldade de reprodução;
- Conflitos;
- Vazamento de dados;
- Resultados diferentes conforme a ordem de execução.

Para dados semelhantes aos de produção, eu utilizaria dados sintéticos ou anonimizados, respeitando políticas de segurança e privacidade.

Também garantiria que os testes validassem cenários relevantes, como:

- Pedido sem itens;
- Pedido com alto valor;
- Cliente sem permissão;
- Registro inexistente;
- Dados duplicados;
- Estados incompatíveis;
- Datas limite;
- Concorrência.

**Explicação didática:**

Um teste confiável deve controlar suas pré-condições. Se ele depende de um registro criado por outra pessoa ou de uma ordem específica de execução, pode passar em um momento e falhar em outro.

Dados de teste também precisam ser seguros. Copiar uma base real para um ambiente de desenvolvimento pode expor informações pessoais, financeiras ou credenciais.

**Exemplo prático:**

Em vez de buscar um cliente fixo no banco:

~~~java
Cliente cliente = clienteRepository
        .findById(1L)
        .orElseThrow();
~~~

O teste poderia criar explicitamente o cliente necessário:

~~~java
Cliente cliente = ClienteTestData.umCliente()
        .comNome("Cliente de Teste")
        .comEmail("teste@example.com")
        .build();

clienteRepository.save(cliente);
~~~

O nome dos métodos e a implementação exata dependem dos padrões adotados pelo projeto.

**Como o candidato deve responder:**

O candidato deve:

- Defender dados isolados e reproduzíveis;
- Evitar uso de dados reais;
- Mencionar factories, fixtures ou builders;
- Considerar limpeza e independência;
- Falar sobre dados sintéticos e anonimização;
- Incluir cenários negativos;
- Relacionar dados de teste à estabilidade do pipeline.

Deve evitar depender de uma base compartilhada sem controle ou copiar dados de produção sem proteção.

**Resposta fraca ou incompleta:**

“Eu manteria uma base de testes com dados prontos e pediria para o time não alterar esses dados.”

Essa abordagem é frágil e não garante isolamento, segurança ou reprodução.

**Critérios de avaliação:**

- **0** — Não reconhece os problemas de dados de teste.
- **1** — Depende de registros fixos ou de uma base compartilhada.
- **2** — Cria dados, mas não trata isolamento ou privacidade.
- **3** — Usa fixtures e dados controlados.
- **4** — Inclui isolamento, dados sintéticos, anonimização e cenários negativos.
- **5** — Demonstra estratégia completa para dados seguros, reproduzíveis e representativos em diferentes tipos de teste.

**Perguntas de aprofundamento:**

1. Como testaria um cenário com milhões de registros?
2. Como anonimizar dados utilizados em um ambiente de validação?
3. Como evitaria que testes dependessem da ordem de execução?

---

## Pergunta 59 — Qualidade de código legado

**Nível:** Sênior  
**Categoria:** Manutenção e evolução

**Pergunta do entrevistador:**

Você assumiu uma aplicação Java legada com baixa cobertura de testes, classes extensas e regras de negócio espalhadas. Como melhoraria a qualidade sem interromper completamente a entrega de novas funcionalidades?

**O que essa pergunta avalia:**

Avalia capacidade de evoluir sistemas legados de forma incremental, reduzir risco e equilibrar manutenção com entrega de valor.

**Resposta esperada:**

Eu começaria entendendo os fluxos mais críticos e os pontos de maior risco. Avaliaria:

- Incidentes recorrentes;
- Funcionalidades mais utilizadas;
- Áreas que sofrem mais alterações;
- Classes com maior complexidade;
- Dependências frágeis;
- Falta de observabilidade;
- Pontos de integração;
- Dados e operações críticas.

Antes de grandes refatorações, criaria testes de caracterização para registrar o comportamento atual dos fluxos importantes. Esses testes não precisam afirmar que o comportamento atual é ideal, mas ajudam a detectar mudanças acidentais.

Depois, adotaria uma estratégia incremental:

- Melhorar a área que será alterada;
- Extrair regras pequenas;
- Reduzir duplicação;
- Criar interfaces nos pontos de integração;
- Adicionar logs e métricas;
- Introduzir testes unitários e de integração;
- Documentar regras desconhecidas;
- Dividir classes muito grandes;
- Remover código morto com segurança;
- Atualizar dependências gradualmente.

Eu evitaria prometer uma reescrita completa sem entender o domínio, os riscos e o custo de migração.

**Explicação didática:**

Código legado não é apenas código antigo. É código cujo comportamento, contexto ou dependências são difíceis de alterar com segurança.

Uma refatoração pode ser necessária, mas deve ser conduzida com proteção. Alterar uma classe grande sem testes pode gerar regressões difíceis de identificar.

Uma abordagem útil é melhorar o sistema enquanto novas mudanças são realizadas:

> “Deixar a área um pouco melhor do que foi encontrada.”

Essa prática evita acumular mais dívida e permite evoluir por fatias.

**Exemplo prático:**

Se uma nova regra de cancelamento precisa ser adicionada a uma classe de 2.000 linhas, eu poderia:

1. Criar testes para o fluxo atual;
2. Identificar as regras de cancelamento;
3. Extrair um componente específico;
4. Adicionar testes para os novos cenários;
5. Integrar o componente ao fluxo existente;
6. Monitorar;
7. Continuar a extração em mudanças futuras.

**Exemplo de código:**

Uma extração incremental poderia criar uma abstração:

~~~java
public interface RegraCancelamento {

    boolean podeAplicar(Pedido pedido);

    void aplicar(Pedido pedido);
}
~~~

O código antigo pode continuar existindo durante a transição, enquanto novas regras são adicionadas de forma mais isolada.

**Como o candidato deve responder:**

O candidato deve:

- Começar pelos fluxos críticos;
- Criar testes de caracterização;
- Propor mudanças incrementais;
- Melhorar o código durante as entregas;
- Considerar observabilidade;
- Evitar reescrita total automática;
- Relacionar qualidade a risco e valor;
- Definir critérios para medir evolução.

Deve evitar afirmar que a única solução é parar o desenvolvimento e reescrever tudo.

**Resposta fraca ou incompleta:**

“Eu separaria as classes, criaria testes e depois reescreveria o sistema.”

Essa resposta não define prioridade, proteção, estratégia incremental ou critérios de sucesso.

**Critérios de avaliação:**

- **0** — Não sabe trabalhar com legado.
- **1** — Propõe reescrita total sem análise.
- **2** — Reconhece a necessidade de testes, mas não estrutura a evolução.
- **3** — Propõe testes e refatoração gradual.
- **4** — Considera riscos, observabilidade, fluxo crítico e entrega incremental.
- **5** — Demonstra estratégia madura de modernização, com proteção do comportamento e melhoria contínua orientada a evidências.

**Perguntas de aprofundamento:**

1. Como escolheria a primeira área a ser melhorada?
2. O que faria se não houvesse testes nem documentação?
3. Como convenceria o negócio a investir em melhorias no legado?

---

## Pergunta 60 — Definição de critérios de aceitação e pronto

**Nível:** Sênior  
**Categoria:** Qualidade e colaboração com produto

**Pergunta do entrevistador:**

Como você ajudaria o time e o Product Manager a definir critérios de aceitação e critérios de pronto que protejam a qualidade sem criar burocracia excessiva?

**O que essa pergunta avalia:**

Avalia capacidade de alinhar produto e engenharia, tornar expectativas verificáveis e estabelecer um padrão de entrega proporcional ao risco.

**Resposta esperada:**

Eu ajudaria a transformar a necessidade do usuário em comportamentos observáveis e verificáveis.

Os critérios de aceitação deveriam esclarecer:

- Quem realiza a ação;
- Qual problema está sendo resolvido;
- Quais condições precisam ser atendidas;
- Quais são os cenários de sucesso;
- Quais são os cenários de erro;
- Quais regras de negócio existem;
- Quais permissões são necessárias;
- O que está fora do escopo;
- Como o resultado será validado.

Já os critérios de pronto poderiam incluir, quando aplicável:

- Código implementado;
- Revisão concluída;
- Testes relevantes passando;
- Segurança avaliada;
- Migração validada;
- Documentação atualizada;
- Logs e métricas disponíveis;
- Configurações definidas;
- Pipeline aprovado;
- Estratégia de deploy definida;
- Rollback ou desativação avaliado;
- Validação de produto realizada.

Os critérios devem ser adaptados ao risco. Uma alteração visual simples não precisa ter o mesmo processo de uma mudança em pagamentos, autenticação ou dados pessoais.

Eu evitaria transformar o critério de pronto em uma checklist que ninguém entende ou aplica. O time deve compreender o motivo de cada item.

**Explicação didática:**

Critérios de aceitação definem quando a funcionalidade atende à necessidade do usuário.

Critérios de pronto definem quando o trabalho está suficientemente completo para ser considerado entregue.

Exemplo:

- **Aceitação:** o cliente consegue cancelar um pedido elegível e recebe confirmação;
- **Pronto:** a regra foi testada, a autorização foi validada, os logs estão disponíveis e a funcionalidade pode ser implantada com segurança.

Sem critérios claros, o time pode interpretar “pronto” de maneiras diferentes, causando retrabalho e conflitos.

**Exemplo prático:**

Para uma API de cancelamento de pedidos:

~~~text
Critérios de aceitação:
- Cliente pode cancelar pedido com status permitido.
- Pedido já enviado não pode ser cancelado.
- Usuário não pode cancelar pedido de outro cliente.
- O cancelamento retorna uma confirmação.
- Falhas de integração não confirmam o cancelamento indevidamente.

Critérios de pronto:
- Regras de negócio testadas.
- Autorização validada.
- Integrações simuladas e testadas.
- Logs e métricas disponíveis.
- Pipeline aprovado.
- Rollback ou desativação avaliado.
~~~

**Exemplo de código:**

Um teste pode expressar um critério de aceitação:

~~~java
@Test
void naoDevePermitirCancelamentoDePedidoEnviado() {
    Pedido pedido = PedidoTestData.umPedido()
            .comStatus(StatusPedido.ENVIADO)
            .build();

    assertThatThrownBy(() ->
            pedido.cancelar())
            .isInstanceOf(PedidoNaoCancelavelException.class);
}
~~~

O teste não substitui a validação com produto, mas ajuda a tornar o comportamento executável e verificável.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar critérios de aceitação e pronto;
- Falar sobre cenários de sucesso e erro;
- Considerar segurança e operação;
- Adaptar os critérios ao risco;
- Promover alinhamento entre produto e engenharia;
- Evitar burocracia;
- Explicar como os critérios reduzem retrabalho.

Deve evitar definir uma checklist fixa e igual para todas as alterações.

**Resposta fraca ou incompleta:**

“Eu colocaria como pronto quando o código estivesse desenvolvido, testado e aprovado pelo Product Manager.”

Essa resposta é genérica e não define comportamento, segurança, operação ou critérios verificáveis.

**Critérios de avaliação:**

- **0** — Não compreende critérios de aceitação ou pronto.
- **1** — Usa apenas aprovação ou conclusão do código.
- **2** — Menciona testes, mas não define comportamentos verificáveis.
- **3** — Diferencia os dois conceitos e cria critérios básicos.
- **4** — Inclui cenários de erro, segurança, operação e risco.
- **5** — Demonstra capacidade de criar critérios claros, colaborativos, executáveis e proporcionais à criticidade do produto.

**Perguntas de aprofundamento:**

1. Quem deve participar da definição dos critérios de aceitação?
2. Como trataria critérios ambíguos durante o desenvolvimento?
3. O que faria se o Product Manager quisesse considerar a história pronta sem atender aos critérios técnicos essenciais?

---

# Resumo desta parte

| Item | Resultado |
|---|---|
| Perguntas apresentadas | 51 a 60 |
| Níveis abordados | Pleno e Sênior |
| Temas principais | Qualidade, testes de segurança, vulnerabilidades, proteção de dados, contratos, desempenho, resiliência, dados de teste, legado e critérios de pronto |
| Perguntas restantes | 40 |

## Competências exploradas

- Definição ampla de qualidade;
- Testes de autenticação e autorização;
- Segurança no nível do recurso;
- Gestão de vulnerabilidades;
- Proteção de dados sensíveis;
- Minimização e mascaramento;
- Testes de contrato;
- Compatibilidade entre serviços;
- Testes de carga e capacidade;
- Testes de resiliência;
- Fallbacks e degradação controlada;
- Organização de dados de teste;
- Evolução de código legado;
- Refatoração incremental;
- Critérios de aceitação;
- Critérios de pronto;
- Alinhamento entre produto, engenharia e segurança.

---

# Roteiro Completo de Entrevista — Tech Lead de um Time Java

## Parte 7 de 10 — Perguntas 61 a 70

**Foco desta parte:** observabilidade, produção, incidentes, monitoramento, troubleshooting, continuidade operacional e aprendizado pós-incidente.

> As perguntas consideram um Tech Lead responsável por orientar um time Java e Spring Boot que desenvolve, entrega, monitora e mantém um produto em produção.

## Fluxo de operação e resposta a incidentes

~~~mermaid
flowchart TD
    A[Aplicação em produção] --> B[Métricas, logs e traces]
    B --> C[Detecção de anomalia]
    C --> D[Classificação do incidente]
    D --> E[Contenção do impacto]
    E --> F[Investigação]
    F --> G[Mitigação ou correção]
    G --> H[Validação da recuperação]
    H --> I[Comunicação do encerramento]
    I --> J[Post-mortem e ações preventivas]
    J --> K[Melhoria do produto e da operação]
    K --> B
~~~

---

## Pergunta 61 — O que observar em uma aplicação Spring Boot

**Nível:** Júnior  
**Categoria:** Observabilidade

**Pergunta do entrevistador:**

Quais informações você considera essenciais para acompanhar a saúde de uma aplicação Java e Spring Boot em produção?

**O que essa pergunta avalia:**

Avalia a compreensão dos fundamentos de observabilidade e a capacidade de identificar sinais importantes sobre funcionamento, desempenho e falhas da aplicação.

**Resposta esperada:**

Eu acompanharia três sinais principais:

- **Métricas:** valores agregados sobre comportamento e desempenho;
- **Logs:** registros detalhados de eventos;
- **Traces:** acompanhamento de uma requisição entre diferentes componentes.

Também observaria indicadores como:

- Taxa de requisições;
- Taxa de erros;
- Latência média e percentis;
- Uso de CPU;
- Uso de memória;
- Garbage collection;
- Quantidade de threads;
- Pool de conexões;
- Conexões com o banco;
- Tamanho de filas;
- Status de integrações externas;
- Reinícios da aplicação;
- Disponibilidade;
- Saturação de recursos.

As métricas deveriam estar relacionadas ao comportamento do produto. Por exemplo, não basta saber que a aplicação está ativa; é importante saber se os usuários conseguem concluir uma compra ou consultar um pedido.

Os logs devem possuir contexto suficiente para investigação, e os traces devem permitir acompanhar uma operação entre API, banco, mensageria e serviços externos.

**Explicação didática:**

Observabilidade é a capacidade de entender o estado interno de um sistema a partir dos sinais que ele produz.

Uma aplicação pode estar “no ar” e ainda assim apresentar problemas, como:

- Erros em apenas um endpoint;
- Lentidão para determinados usuários;
- Falhas em uma integração;
- Mensagens acumuladas;
- Alta taxa de respostas inválidas;
- Problemas em uma região específica.

Por isso, é necessário combinar sinais técnicos e indicadores de negócio.

**Exemplo prático:**

Para uma API de criação de pedidos, eu acompanharia:

- Quantidade de pedidos recebidos;
- Percentual de pedidos processados com sucesso;
- Tempo de resposta;
- Erros por tipo;
- Falhas no pagamento;
- Pedidos em processamento;
- Pedidos sem atualização;
- Mensagens pendentes;
- Taxa de abandono da jornada.

**Exemplo de código:**

Uma métrica de negócio poderia ser registrada assim:

~~~java
@Component
public class PedidoMetrics {

    private final Counter pedidosCriados;

    public PedidoMetrics(MeterRegistry registry) {
        this.pedidosCriados = Counter.builder("pedidos.criados")
                .description("Quantidade de pedidos criados")
                .register(registry);
    }

    public void registrarPedidoCriado() {
        pedidosCriados.increment();
    }
}
~~~

As métricas devem possuir nomes, tags e cardinalidade controlados. Não é recomendável criar uma série diferente para cada usuário ou identificador único.

**Como o candidato deve responder:**

O candidato deve:

- Mencionar métricas, logs e traces;
- Falar sobre latência e erros;
- Considerar recursos da aplicação;
- Incluir integrações e banco;
- Relacionar observabilidade ao negócio;
- Demonstrar preocupação com dados sensíveis;
- Explicar que uma aplicação ativa não necessariamente está saudável.

Deve evitar limitar monitoramento a:

- CPU;
- Memória;
- Verificação de que a aplicação responde ao health check.

**Resposta fraca ou incompleta:**

“Eu monitoraria CPU, memória e se a aplicação está funcionando.”

Essa resposta cobre apenas parte da infraestrutura e não permite entender o comportamento das requisições ou dos usuários.

**Critérios de avaliação:**

- **0** — Não conhece conceitos básicos de observabilidade.
- **1** — Considera apenas se a aplicação está ligada.
- **2** — Menciona CPU, memória e logs.
- **3** — Inclui métricas, logs e latência.
- **4** — Considera traces, banco, integrações e indicadores de negócio.
- **5** — Demonstra visão completa de observabilidade, incluindo sinais técnicos, contexto de negócio e proteção de dados.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre monitoramento e observabilidade?
2. Por que uma métrica de taxa de erro pode ser mais útil que um health check?
3. Que informações você não colocaria em logs?

---

## Pergunta 62 — Health checks e prontidão da aplicação

**Nível:** Júnior  
**Categoria:** Operação e disponibilidade

**Pergunta do entrevistador:**

Qual é a diferença entre verificar se uma aplicação está viva e verificar se ela está pronta para receber tráfego?

**O que essa pergunta avalia:**

Avalia a compreensão sobre liveness, readiness e o uso correto de verificações de saúde em ambientes de execução distribuídos.

**Resposta esperada:**

A verificação de **liveness** indica se o processo está vivo e respondendo de forma mínima. Se falhar, pode ser necessário reiniciar a instância.

A verificação de **readiness** indica se a aplicação está pronta para receber tráfego. Ela pode falhar quando:

- Uma dependência essencial ainda não está disponível;
- A aplicação está iniciando;
- Existe uma operação de manutenção;
- A instância está sendo retirada;
- O sistema está temporariamente incapaz de atender requisições.

Essas verificações não devem ser confundidas.

Uma aplicação pode continuar viva, mas não estar pronta para receber requisições. Por outro lado, incluir todas as dependências externas no liveness pode causar reinícios em cascata quando um parceiro estiver indisponível.

Eu definiria os checks conforme o comportamento esperado do produto e da plataforma de execução.

**Explicação didática:**

Se um serviço externo de recomendações estiver indisponível, isso talvez não impeça a aplicação de atender pedidos. Nesse caso, a falha dessa dependência não deveria necessariamente fazer a instância parecer morta.

Já se a aplicação não consegue acessar um banco essencial para qualquer operação, pode ser necessário retirá-la do tráfego, dependendo da arquitetura e do comportamento desejado.

O health check deve refletir a capacidade real de atender solicitações, sem produzir ações automáticas perigosas.

**Exemplo prático:**

- **Liveness:** a aplicação responde e o processo não está travado;
- **Readiness:** a aplicação consegue receber requisições de negócio;
- **Startup:** a aplicação ainda está carregando configurações ou inicializando componentes.

**Exemplo de código:**

Uma configuração conceitual poderia ser:

~~~yaml
management:
  endpoint:
    health:
      probes:
        enabled: true
  health:
    livenessstate:
      enabled: true
    readinessstate:
      enabled: true
~~~

A configuração precisa ser alinhada à plataforma e às dependências realmente essenciais para o funcionamento.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar liveness e readiness;
- Explicar o impacto no balanceador ou orquestrador;
- Considerar dependências críticas e opcionais;
- Alertar contra reinícios em cascata;
- Mencionar inicialização e retirada de tráfego;
- Demonstrar preocupação com disponibilidade.

Deve evitar incluir indiscriminadamente todos os serviços externos no liveness.

**Resposta fraca ou incompleta:**

“Os dois checks servem para saber se a aplicação está funcionando.”

Essa resposta não diferencia processo vivo de capacidade de receber tráfego.

**Critérios de avaliação:**

- **0** — Não diferencia os conceitos.
- **1** — Trata ambos como a mesma verificação.
- **2** — Reconhece que readiness está relacionada ao tráfego.
- **3** — Explica liveness e readiness corretamente.
- **4** — Considera dependências, inicialização e retirada de tráfego.
- **5** — Demonstra visão operacional madura e preocupação com falhas em cascata e disponibilidade.

**Perguntas de aprofundamento:**

1. O que aconteceria se uma dependência opcional fosse incluída no liveness?
2. Quando uma aplicação deveria falhar no readiness?
3. Como evitaria que um health check sobrecarregasse o banco?

---

## Pergunta 63 — Investigação de aumento de erros em produção

**Nível:** Pleno  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**

A taxa de erros de uma API Spring Boot aumentou repentinamente em produção. Como você conduziria a investigação?

**O que essa pergunta avalia:**

Avalia a capacidade de investigar incidentes de forma estruturada, preservando evidências, correlacionando sinais e evitando alterações impulsivas.

**Resposta esperada:**

Eu começaria confirmando o incidente e delimitando o impacto:

- Quando começou;
- Quais endpoints foram afetados;
- Qual percentual de requisições falha;
- Quais códigos de erro aparecem;
- Quais usuários ou regiões são afetados;
- Se houve alteração recente;
- Se o problema está crescendo;
- Se há impacto financeiro ou de dados.

Depois, correlacionaria:

- Métricas;
- Logs;
- Traces;
- Deploys;
- Mudanças de configuração;
- Eventos de infraestrutura;
- Dependências externas;
- Banco;
- Filas;
- Capacidade dos recursos.

Verificaria se existe relação temporal com:

- Novo deploy;
- Migração;
- Atualização de dependência;
- Alteração de feature flag;
- Mudança em parceiro;
- Aumento de tráfego;
- Expiração de certificado;
- Falha de infraestrutura.

Enquanto investigo, priorizaria conter o impacto. Dependendo do caso, poderia:

- Desativar uma funcionalidade;
- Reduzir o tráfego;
- Fazer rollback;
- Bloquear uma operação perigosa;
- Ativar um fallback;
- Isolar uma dependência.

Eu evitaria modificar várias coisas ao mesmo tempo sem registrar as ações, pois isso dificultaria identificar a causa.

**Explicação didática:**

Investigação de produção deve responder duas perguntas diferentes:

1. Como reduzir o impacto agora?
2. Qual foi a causa do problema?

Não é necessário descobrir a causa definitiva antes de tomar uma ação de contenção. Porém, a contenção deve ser registrada e acompanhada.

Também é importante evitar conclusões precipitadas. Um aumento de erros após um deploy pode ser coincidência; o problema pode estar em um serviço externo ou em uma alteração de tráfego.

**Exemplo prático:**

Se os erros começaram imediatamente após uma nova versão e estão concentrados em um endpoint alterado, eu avaliaria rollback ou desativação da funcionalidade. Se os erros estiverem distribuídos em todos os endpoints, investigaria infraestrutura, banco, rede ou dependências compartilhadas.

**Exemplo de código:**

Um identificador de correlação pode ser adicionado aos logs:

~~~java
log.error(
        "Falha ao criar pedido. traceId={}, pedidoId={}, causa={}",
        traceId,
        pedidoId,
        exception.getClass().getSimpleName(),
        exception
);
~~~

O log deve conter contexto suficiente para investigação, sem incluir dados sensíveis desnecessários.

**Como o candidato deve responder:**

O candidato deve:

- Delimitar impacto e início do problema;
- Correlacionar logs, métricas e traces;
- Verificar alterações recentes;
- Considerar dependências;
- Priorizar contenção;
- Preservar evidências;
- Evitar mudanças aleatórias;
- Comunicar o status do incidente.

Deve evitar reiniciar as instâncias imediatamente sem entender o impacto ou apagar evidências importantes.

**Resposta fraca ou incompleta:**

“Eu verificaria os logs e reiniciaria a aplicação.”

Essa resposta pode eliminar temporariamente o sintoma, mas não investiga causa, impacto ou recorrência.

**Critérios de avaliação:**

- **0** — Não apresenta método de investigação.
- **1** — Reinicia a aplicação sem analisar evidências.
- **2** — Consulta logs, mas não correlaciona sinais.
- **3** — Investiga logs, métricas e mudanças recentes.
- **4** — Inclui contenção, impacto, dependências e comunicação.
- **5** — Demonstra condução estruturada, rápida e baseada em evidências, equilibrando mitigação e investigação.

**Perguntas de aprofundamento:**

1. O que faria se não houvesse logs suficientes?
2. Como diferenciaria uma falha causada pelo deploy de uma falha externa?
3. Quando priorizaria rollback em vez de investigação prolongada?

---

## Pergunta 64 — Logs úteis e seguros

**Nível:** Júnior  
**Categoria:** Logs e segurança

**Pergunta do entrevistador:**

Como você definiria o que deve e o que não deve ser registrado nos logs de uma aplicação Java?

**O que essa pergunta avalia:**

Avalia a capacidade de produzir logs úteis para diagnóstico sem expor dados pessoais, credenciais ou informações desnecessárias.

**Resposta esperada:**

Eu registraria informações que ajudem a entender o fluxo e investigar falhas, como:

- Identificador da requisição;
- Identificador da operação;
- Nome da funcionalidade;
- Resultado;
- Tipo de erro;
- Dependência envolvida;
- Tempo de processamento;
- Quantidade de tentativas;
- Estado relevante do processamento;
- Ambiente;
- Versão da aplicação.

Evitaria registrar:

- Senhas;
- Tokens;
- Chaves privadas;
- CVV;
- Número completo de cartão;
- Documentos completos;
- Dados pessoais sem necessidade;
- Payloads inteiros;
- Informações de autenticação;
- Segredos de configuração.

Também definiria:

- Níveis de log;
- Retenção;
- Acesso;
- Mascaramento;
- Alertas;
- Correlação;
- Formato estruturado;
- Limites de volume.

Logs de produção devem ser úteis, pesquisáveis e seguros. Registrar tudo indiscriminadamente pode aumentar custo, ruído e risco de exposição.

**Explicação didática:**

O log deve permitir responder:

- O que aconteceu?
- Quando aconteceu?
- Em qual operação?
- Qual componente falhou?
- Qual era o resultado?
- Como localizar o trace relacionado?

Não é necessário registrar todos os dados da requisição para responder essas perguntas.

Também é importante diferenciar níveis:

- `DEBUG`: detalhes para investigação controlada;
- `INFO`: eventos relevantes do funcionamento normal;
- `WARN`: situações anormais que não interromperam o fluxo;
- `ERROR`: falhas que exigem análise ou ação.

**Exemplo prático:**

Em vez de registrar:

~~~text
Requisição recebida com senha=123456 e token=abc...
~~~

Seria melhor registrar:

~~~text
Autenticação rejeitada. clienteId=interno-123, motivo=token_expirado, traceId=xyz-789
~~~

Mesmo o identificador utilizado deve ser avaliado conforme a política de privacidade.

**Exemplo de código:**

Um log estruturado poderia ser:

~~~java
log.info(
        "Pedido processado. pedidoId={}, status={}, duracaoMs={}, traceId={}",
        pedidoId,
        status,
        duracao.toMillis(),
        traceId
);
~~~

O ideal é que o sistema tenha mecanismos automáticos para mascarar campos sensíveis.

**Como o candidato deve responder:**

O candidato deve:

- Falar sobre contexto e correlação;
- Diferenciar níveis de log;
- Mencionar dados sensíveis;
- Considerar mascaramento;
- Evitar registrar payloads completos;
- Considerar retenção e acesso;
- Relacionar logs à investigação.

Deve evitar responder que a melhor prática é registrar tudo para não perder informações.

**Resposta fraca ou incompleta:**

“Eu registraria as requisições e as exceções completas para facilitar o diagnóstico.”

Essa prática pode expor dados sensíveis e aumentar o ruído operacional.

**Critérios de avaliação:**

- **0** — Não reconhece riscos em logs.
- **1** — Defende registrar todos os dados.
- **2** — Menciona não registrar senhas, mas não trata outros dados.
- **3** — Define logs com contexto e níveis.
- **4** — Inclui mascaramento, acesso, retenção e correlação.
- **5** — Demonstra visão madura de logs como ferramenta de operação e possível fonte de risco de privacidade.

**Perguntas de aprofundamento:**

1. Como investigaria um incidente sem acesso ao payload completo?
2. Como impediria que uma exceção imprimisse credenciais?
3. Quando um log deveria gerar um alerta?

---

## Pergunta 65 — Alertas acionáveis

**Nível:** Pleno  
**Categoria:** Monitoramento e operação

**Pergunta do entrevistador:**

Como você definiria alertas para uma aplicação em produção sem gerar excesso de notificações ou fadiga de alerta?

**O que essa pergunta avalia:**

Avalia capacidade de criar alertas úteis, relacionados a impacto e com ações claras para quem recebe a notificação.

**Resposta esperada:**

Eu criaria alertas baseados em sintomas relevantes e impacto, não apenas em qualquer alteração técnica.

Um alerta deveria responder:

- Qual problema está acontecendo;
- Qual é o impacto;
- Qual é a gravidade;
- Quem deve agir;
- Qual é a ação inicial;
- Onde estão os dashboards;
- Qual é o procedimento de resposta;
- Quando escalar.

Exemplos de alertas úteis:

- Taxa de erro acima do limite;
- p95 ou p99 de latência elevado;
- Falha em operação financeira;
- Acúmulo de mensagens;
- Expiração próxima de certificado;
- Falha de processamento sem reprocessamento;
- Indisponibilidade de uma dependência crítica;
- Falta de espaço em disco;
- Erro de autenticação em massa.

Eu evitaria alertas que:

- Não exigem ação;
- São frequentes demais;
- Possuem limiares muito sensíveis;
- Não têm responsável;
- Não distinguem manutenção conhecida de incidente;
- Notificam apenas uma causa interna sem impacto real.

Também revisaria os alertas após incidentes e analisaria quantos foram ignorados, resolvidos automaticamente ou classificados como falso positivo.

**Explicação didática:**

Um alerta não é apenas uma métrica que ultrapassou um número. Ele é uma solicitação de atenção.

Se um time recebe dezenas de alertas irrelevantes, pode deixar de reagir ao alerta importante. Isso é chamado de fadiga de alerta.

Alertas devem possuir severidade e resposta esperada, por exemplo:

- Informativo;
- Atenção;
- Incidente crítico.

Os limites devem ser baseados no comportamento normal e nos requisitos do produto.

**Exemplo prático:**

Um alerta de CPU acima de 80% pode não ser suficiente. Se a aplicação continua atendendo requisições normalmente, talvez seja apenas uma informação.

Já uma taxa de erro de pagamento acima do normal, mesmo com CPU baixa, pode exigir ação imediata.

**Exemplo de código:**

Uma regra conceitual poderia ser:

~~~yaml
alerts:
  - name: alta-taxa-de-erros-pagamento
    condition: payment_error_rate > 1%
    duration: 5m
    severity: critical
    action: acionar-time-de-pedidos
    runbook: procedimento-pagamentos
~~~

A regra deve ser acompanhada por um procedimento que explique como investigar e conter o problema.

**Como o candidato deve responder:**

O candidato deve:

- Falar sobre impacto;
- Definir limiares;
- Mencionar severidade;
- Incluir responsáveis e runbooks;
- Evitar alertas excessivos;
- Considerar falsos positivos;
- Revisar alertas após incidentes.

Deve evitar criar alertas para cada métrica sem definir uma ação.

**Resposta fraca ou incompleta:**

“Eu alertaria sempre que CPU, memória ou erros aumentassem.”

Essa resposta não define limiares, impacto, severidade ou ação esperada.

**Critérios de avaliação:**

- **0** — Não sabe definir alertas.
- **1** — Alerta qualquer variação.
- **2** — Considera métricas, mas não define ação.
- **3** — Cria alertas por impacto e severidade.
- **4** — Inclui responsáveis, runbooks e controle de ruído.
- **5** — Demonstra estratégia madura de alertas acionáveis, com revisão contínua e foco na experiência operacional.

**Perguntas de aprofundamento:**

1. Como reduziria falsos positivos?
2. Que diferença existe entre métrica, alerta e dashboard?
3. Como saberia se um alerta está sendo útil?

---

## Pergunta 66 — Incidente com impacto financeiro

**Nível:** Sênior  
**Categoria:** Gestão de incidentes

**Pergunta do entrevistador:**

Uma aplicação começou a processar pagamentos duplicados. O problema ainda está ocorrendo, mas a causa não foi identificada. Como você conduziria a resposta?

**O que essa pergunta avalia:**

Avalia liderança em incidente crítico, capacidade de priorizar contenção, proteção do cliente, coordenação técnica e comunicação.

**Resposta esperada:**

Eu priorizaria interromper a geração de novos danos antes de buscar a causa definitiva.

As primeiras ações poderiam incluir:

- Desativar a funcionalidade afetada;
- Interromper o consumidor ou fluxo responsável;
- Bloquear temporariamente novas tentativas;
- Acionar o provedor de pagamento;
- Isolar a integração;
- Ativar um fluxo seguro de contingência;
- Preservar logs, eventos e evidências;
- Identificar o período afetado;
- Criar uma lista de transações potencialmente duplicadas.

Depois, organizaria a investigação com papéis claros:

- Responsável por coordenar o incidente;
- Pessoas investigando a causa;
- Pessoa responsável pela comunicação;
- Pessoa analisando dados e reconciliação;
- Representantes de produto, segurança, financeiro e suporte.

Eu comunicaria o impacto de forma transparente, sem especular sobre a causa. Também avaliaria:

- Clientes afetados;
- Valores envolvidos;
- Estornos;
- Reconciliação;
- Obrigações legais;
- Comunicação externa;
- Registro de auditoria.

Após conter o problema, investigaria hipóteses como:

- Retry sem idempotência;
- Falha após o provedor processar a cobrança;
- Reentrega de mensagens;
- Concorrência;
- Duplicidade no consumidor;
- Ausência de restrição no banco;
- Falha na confirmação da operação.

**Explicação didática:**

Em um incidente financeiro, o objetivo inicial não é encontrar imediatamente o culpado ou a explicação perfeita. É reduzir o dano.

A sequência costuma ser:

1. Conter;
2. Preservar evidências;
3. Entender o alcance;
4. Recuperar o serviço com segurança;
5. Corrigir a causa;
6. Reconciliar dados;
7. Aprender e prevenir recorrência.

A comunicação precisa ser frequente e factual. É melhor dizer “o impacto está sendo investigado e novas transações foram temporariamente bloqueadas” do que oferecer uma causa não confirmada.

**Exemplo prático:**

Se o processamento assíncrono estiver duplicando mensagens, pode ser necessário pausar o consumidor, impedir novas cobranças e armazenar as mensagens pendentes para reprocessamento após a correção.

**Exemplo de código:**

Uma restrição de unicidade pode ajudar a impedir a criação de duas operações com a mesma chave:

~~~sql
ALTER TABLE pagamento
ADD CONSTRAINT uk_pagamento_idempotencia
UNIQUE (idempotency_key);
~~~

Essa proteção deve ser combinada com tratamento adequado de concorrência, estados intermediários e reconciliação com o provedor.

**Como o candidato deve responder:**

O candidato deve:

- Priorizar contenção;
- Proteger clientes e dados;
- Interromper o fluxo perigoso;
- Preservar evidências;
- Coordenar equipes;
- Considerar reconciliação e estornos;
- Comunicar fatos sem especulação;
- Investigar idempotência, retries e concorrência;
- Envolver áreas responsáveis.

Deve evitar continuar processando pagamentos enquanto investiga ou atribuir culpa antes de entender o problema.

**Resposta fraca ou incompleta:**

“Eu verificaria os logs e corrigiria o código responsável pela duplicidade.”

Essa resposta ignora a necessidade de interromper o dano, comunicar o incidente e reconciliar as transações.

**Critérios de avaliação:**

- **0** — Mantém o fluxo ativo ou ignora o impacto financeiro.
- **1** — Busca apenas a causa técnica.
- **2** — Investiga e propõe correção, mas não contém o problema.
- **3** — Interrompe o fluxo e inicia a investigação.
- **4** — Inclui coordenação, comunicação, reconciliação e preservação de evidências.
- **5** — Demonstra liderança completa de incidente crítico, priorizando clientes, integridade financeira, comunicação e prevenção de recorrência.

**Perguntas de aprofundamento:**

1. Como identificaria todas as transações afetadas?
2. O que faria se o provedor confirmasse que algumas cobranças foram processadas?
3. Como comunicaria o incidente para clientes e áreas internas?

---

## Pergunta 67 — Tracing distribuído

**Nível:** Pleno  
**Categoria:** Observabilidade distribuída

**Pergunta do entrevistador:**

Como o tracing distribuído ajudaria a investigar uma requisição que passa por uma API Spring Boot, um banco, uma fila e dois serviços externos?

**O que essa pergunta avalia:**

Avalia a compreensão de correlação entre componentes e a capacidade de utilizar traces para identificar latência, falhas e dependências em sistemas distribuídos.

**Resposta esperada:**

O tracing distribuído permite acompanhar uma operação completa por meio de um identificador de trace compartilhado entre os componentes.

Eu verificaria:

- Tempo total da requisição;
- Tempo gasto em cada serviço;
- Consultas ao banco;
- Chamadas externas;
- Publicação e consumo de mensagens;
- Retries;
- Spans com erro;
- Tempo de espera;
- Falhas parciais;
- Relação entre a requisição original e processos assíncronos.

Isso ajuda a responder perguntas como:

- O tempo foi gasto na API, no banco ou no parceiro?
- Qual dependência falhou?
- Houve retry?
- A mensagem foi publicada?
- O consumidor processou?
- Onde a operação ficou parada?

Em fluxos assíncronos, a correlação deve ser preservada entre a publicação e o consumo do evento, respeitando os limites e padrões adotados pela plataforma.

Também cuidaria para não registrar dados sensíveis nos atributos dos traces.

**Explicação didática:**

Logs isolados de cada serviço podem ser difíceis de relacionar. O trace cria uma visão da jornada completa.

Por exemplo:

~~~text
Trace: abc-123
  API de pedidos: 1200 ms
    Banco: 80 ms
    Serviço de pagamento: 900 ms
      Retry: 1
    Publicação do evento: 20 ms
  Consumidor de notificação: processando posteriormente
~~~

Esse contexto ajuda a distinguir o tempo da operação principal do processamento posterior.

**Exemplo prático:**

Se a API responde lentamente, o trace pode mostrar que:

- O banco está rápido;
- O serviço de pagamento está demorando;
- O retry ocorre duas vezes;
- O timeout está próximo;
- A publicação do evento está normal.

Assim, a investigação fica mais direcionada.

**Exemplo de código:**

Um contexto de correlação pode ser utilizado em logs:

~~~java
public Resultado processar(Pedido pedido) {
    String traceId = tracer.currentSpan()
            .context()
            .traceId();

    log.info(
            "Iniciando processamento. pedidoId={}, traceId={}",
            pedido.getId(),
            traceId);

    return executarFluxo(pedido);
}
~~~

A implementação exata depende da solução de tracing adotada. O importante é preservar a correlação sem criar dependência excessiva de código específico.

**Como o candidato deve responder:**

O candidato deve:

- Explicar trace e span;
- Falar sobre correlação;
- Considerar chamadas síncronas e assíncronas;
- Identificar latência e falhas por componente;
- Mencionar retries;
- Considerar dados sensíveis;
- Relacionar tracing à investigação.

Deve evitar tratar tracing apenas como uma versão mais detalhada de logs.

**Resposta fraca ou incompleta:**

“Eu usaria um ID para procurar a requisição nos logs.”

Essa prática ajuda, mas não explica a visão hierárquica dos spans nem o acompanhamento entre serviços.

**Critérios de avaliação:**

- **0** — Não compreende tracing.
- **1** — Confunde trace com log comum.
- **2** — Reconhece correlação, mas não identifica seus benefícios.
- **3** — Explica trace, spans e latência.
- **4** — Considera filas, retries, banco, integrações e segurança.
- **5** — Demonstra domínio de observabilidade distribuída e capacidade de utilizá-la em investigações complexas.

**Perguntas de aprofundamento:**

1. Como correlacionaria uma mensagem assíncrona ao pedido original?
2. Que riscos existem ao colocar informações de negócio nos traces?
3. Como identificaria o componente responsável pela maior parte da latência?

---

## Pergunta 68 — SLOs, SLIs e error budget

**Nível:** Sênior  
**Categoria:** Confiabilidade e produto

**Pergunta do entrevistador:**

Como você utilizaria SLIs, SLOs e error budgets para orientar decisões de engenharia e entrega de um produto Java?

**O que essa pergunta avalia:**

Avalia maturidade em confiabilidade, capacidade de transformar expectativas de serviço em objetivos mensuráveis e equilíbrio entre velocidade e estabilidade.

**Resposta esperada:**

Um **SLI** é um indicador medido sobre o comportamento do serviço, como:

- Disponibilidade;
- Latência;
- Taxa de erros;
- Tempo de processamento;
- Sucesso de uma operação de negócio.

Um **SLO** define o objetivo esperado para aquele indicador em um período. Por exemplo:

- 99,9% das consultas disponíveis;
- 95% das requisições abaixo de determinado tempo;
- Menos de 0,5% de falhas em pagamentos.

O **error budget** representa o nível de falha aceitável implícito no SLO. Se o produto possui um SLO de disponibilidade de 99,9%, existe uma margem de indisponibilidade permitida no período.

Eu utilizaria esses conceitos para orientar decisões:

- Se o orçamento está sendo consumido rapidamente, priorizar confiabilidade;
- Se o serviço está estável e há orçamento disponível, permitir mudanças com maior velocidade;
- Definir critérios para releases;
- Priorizar dívida técnica;
- Justificar investimentos em observabilidade e resiliência;
- Alinhar expectativas entre produto e engenharia.

Os objetivos devem ser relevantes para o usuário. Não adianta definir métricas fáceis de medir que não representem a experiência real.

**Explicação didática:**

SLOs ajudam a substituir discussões abstratas como “o sistema precisa ser muito confiável” por objetivos verificáveis.

O error budget não significa aceitar falhas sem controle. Ele cria uma forma explícita de equilibrar inovação e confiabilidade.

Por exemplo, se uma sequência de releases consumiu quase todo o orçamento por causa de incidentes, o time pode recomendar reduzir mudanças de alto risco e investir em testes, rollback e observabilidade.

**Exemplo prático:**

Para a jornada de checkout:

~~~text
SLI: percentual de checkouts concluídos sem erro.
SLO: pelo menos 99,5% dos checkouts concluídos corretamente.
Error budget: margem restante de falhas aceitáveis no período.
Ação: reduzir releases arriscadas se o orçamento estiver sendo consumido.
~~~

O SLO deve considerar o impacto financeiro e a expectativa dos usuários.

**Exemplo de código:**

Uma regra conceitual poderia ser:

~~~yaml
slo:
  name: checkout-com-sucesso
  indicator: successful_checkouts / total_checkouts
  target: 99.5%
  window: 30d
  alert:
    burn-rate: high
    action: review-release-plan
~~~

Os limites precisam ser definidos com dados históricos, expectativas de negócio e capacidade real do sistema.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar SLI, SLO e error budget;
- Relacionar indicadores à experiência do usuário;
- Explicar como orientar releases e prioridades;
- Considerar confiabilidade e velocidade;
- Mencionar burn rate ou consumo acelerado do orçamento;
- Evitar metas desconectadas do produto.

Deve evitar transformar SLO em uma meta abstrata de infraestrutura sem relação com o usuário.

**Resposta fraca ou incompleta:**

“Eu colocaria uma meta de 99,9% de disponibilidade e acompanharia se o sistema ficou fora do ar.”

Essa resposta não trata latência, sucesso da jornada, orçamento ou tomada de decisão.

**Critérios de avaliação:**

- **0** — Não conhece os conceitos.
- **1** — Confunde SLI e SLO.
- **2** — Define disponibilidade, mas não relaciona a decisões.
- **3** — Explica SLI, SLO e error budget de forma básica.
- **4** — Relaciona os conceitos a releases, riscos e prioridades.
- **5** — Demonstra visão madura de engenharia de confiabilidade, alinhamento com produto e gestão consciente de trade-offs.

**Perguntas de aprofundamento:**

1. Como escolheria um SLI para uma operação financeira?
2. O que faria se o time consumisse o error budget antes do fim do período?
3. Como evitaria definir um SLO impossível de sustentar?

---

## Pergunta 69 — Post-mortem sem culpabilização

**Nível:** Pleno  
**Categoria:** Aprendizado organizacional

**Pergunta do entrevistador:**

Como você conduziria um post-mortem após um incidente causado por uma alteração em uma aplicação Spring Boot?

**O que essa pergunta avalia:**

Avalia a capacidade de transformar incidentes em aprendizado, identificar fatores sistêmicos e criar ações preventivas sem buscar culpados individuais.

**Resposta esperada:**

Eu conduziria uma análise baseada em fatos, considerando:

- Linha do tempo;
- Sintomas observados;
- Impacto;
- Como o incidente foi detectado;
- Ações tomadas;
- Momento da contenção;
- Dependências envolvidas;
- Decisões tomadas;
- O que funcionou;
- O que não funcionou;
- Lacunas de testes, observabilidade ou processo;
- Condições que permitiram o incidente.

Evitaria perguntas como “quem causou o problema?”. Em vez disso, investigaria:

- Por que a alteração pôde ser implantada;
- Por que os testes não detectaram o comportamento;
- Por que o alerta não foi acionado;
- Por que o rollback demorou;
- Por que a recuperação não era simples;
- Que informações estavam ausentes;
- Quais pressões ou incentivos influenciaram a decisão.

O post-mortem deveria gerar poucas ações claras, com responsáveis e prazo. Exemplos:

- Adicionar teste de regressão;
- Criar métrica;
- Ajustar alerta;
- Melhorar feature flag;
- Atualizar runbook;
- Corrigir o pipeline;
- Reduzir permissões;
- Treinar o time;
- Alterar o processo de revisão.

Também verificaria se as ações foram concluídas e se reduziram o risco.

**Explicação didática:**

Incidentes geralmente possuem várias causas contribuintes, não apenas uma linha de código.

Um ambiente que permite uma mudança perigosa sem testes, alertas ou rollback fácil também participa do problema. Culpar uma pessoa pode gerar medo e reduzir a transparência, sem impedir que o mesmo tipo de falha aconteça novamente.

Uma análise sem culpabilização não significa ausência de responsabilidade. Significa concentrar a investigação na melhoria do sistema e dos processos.

**Exemplo prático:**

Se um endpoint expôs dados por falha de autorização, as ações podem incluir:

- Testes automatizados de acesso por recurso;
- Revisão de contratos de segurança;
- Auditoria de endpoints;
- Alertas de acesso anômalo;
- Atualização dos padrões de implementação;
- Revisão de permissões.

Punir a pessoa que escreveu o código não resolve essas lacunas.

**Exemplo de código:**

Uma ação preventiva poderia resultar em um teste:

~~~java
@Test
void naoDevePermitirAcessoAoRecursoDeOutroCliente() {
    Usuario usuario = usuario("cliente-1");
    Pedido pedido = pedidoDoCliente("cliente-2");

    assertThatThrownBy(() ->
            autorizacao.validar(usuario, pedido))
            .isInstanceOf(AcessoNegadoException.class);
}
~~~

O teste deve ser acompanhado por revisão da regra, da integração e da cobertura dos demais endpoints.

**Como o candidato deve responder:**

O candidato deve:

- Reconstruir a linha do tempo;
- Quantificar impacto;
- Evitar culpabilização;
- Identificar causas sistêmicas;
- Criar ações concretas;
- Definir responsáveis e prazos;
- Acompanhar a conclusão;
- Compartilhar aprendizados com o time.

Deve evitar produzir um documento que apenas registre o erro de uma pessoa.

**Resposta fraca ou incompleta:**

“Eu identificaria quem cometeu o erro e reforçaria a revisão dos pull requests.”

Essa resposta pode criar controle adicional, mas não investiga testes, alertas, processo, rollback ou condições sistêmicas.

**Critérios de avaliação:**

- **0** — Procura apenas culpados.
- **1** — Registra o incidente sem buscar prevenção.
- **2** — Identifica a causa técnica, mas ignora fatores sistêmicos.
- **3** — Conduz análise de causa e cria ações corretivas.
- **4** — Inclui linha do tempo, aprendizado, responsáveis e acompanhamento.
- **5** — Demonstra cultura de segurança psicológica, melhoria sistêmica e transformação do incidente em evolução mensurável.

**Perguntas de aprofundamento:**

1. Como diferenciar uma falha individual de uma falha de processo?
2. Como evitar que as ações do post-mortem virem apenas uma lista esquecida?
3. Quando um incidente deveria ser compartilhado com outros times?

---

## Pergunta 70 — Runbooks e autonomia operacional

**Nível:** Sênior  
**Categoria:** Operação e continuidade

**Pergunta do entrevistador:**

Como você criaria runbooks para que o time consiga responder a incidentes comuns sem depender exclusivamente do Tech Lead?

**O que essa pergunta avalia:**

Avalia a capacidade de transformar conhecimento operacional em procedimentos acessíveis, reduzir dependências individuais e aumentar a autonomia do time.

**Resposta esperada:**

Eu começaria pelos incidentes mais frequentes, críticos ou difíceis de investigar. Cada runbook deveria conter:

- Nome do problema;
- Sintomas;
- Impacto esperado;
- Como confirmar o incidente;
- Dashboards e métricas relevantes;
- Consultas ou verificações permitidas;
- Passos de contenção;
- Critérios para escalar;
- Como executar rollback ou desativação;
- Como validar a recuperação;
- Riscos da ação;
- Como comunicar;
- Referências;
- Data da última revisão.

Os procedimentos devem ser claros e seguros. Não deveriam conter senhas, tokens ou instruções que permitam ações perigosas sem controle.

Eu validaria os runbooks por meio de:

- Simulações;
- Game days;
- Revisões;
- Exercícios de rollback;
- Rodízio de responsabilidades;
- Atualização após incidentes;
- Participação de pessoas com diferentes níveis de experiência.

O Tech Lead deve evitar ser o único guardião do conhecimento operacional. A documentação deve permitir que o time responda progressivamente a situações conhecidas.

**Explicação didática:**

Um runbook não é apenas uma lista de comandos. Ele deve ajudar a decidir:

- O problema realmente está acontecendo?
- Qual é o risco de cada ação?
- O que deve ser feito primeiro?
- Quando parar?
- Quem deve ser acionado?
- Como saber se a recuperação funcionou?

Um procedimento desatualizado pode ser pior que não ter documentação, pois transmite falsa segurança.

**Exemplo prático:**

Um runbook para fila acumulada poderia conter:

1. Verificar taxa de produção e consumo;
2. Confirmar se os consumidores estão ativos;
3. Verificar erros e mensagens inválidas;
4. Avaliar capacidade;
5. Pausar a origem, se necessário;
6. Corrigir ou isolar mensagens problemáticas;
7. Aumentar consumidores somente se for seguro;
8. Monitorar o backlog;
9. Validar a recuperação;
10. Registrar o incidente.

**Exemplo de código:**

Um runbook pode ser estruturado assim:

~~~markdown
# Runbook — Aumento de erros na API de pedidos

## Sintomas
- Taxa de erro acima de 1%.
- Alerta de falhas no endpoint de criação.

## Verificações
- Conferir dashboard de pedidos.
- Verificar traces com erro.
- Comparar horário com último deploy.
- Validar saúde do banco e do pagamento.

## Contenção
- Desativar a feature flag do novo fluxo.
- Se necessário, interromper novas tentativas.
- Comunicar produto e operações.

## Recuperação
- Confirmar redução dos erros.
- Validar pedidos processados.
- Verificar possíveis duplicidades.

## Escalonamento
- Acionar o responsável por pagamentos se houver impacto financeiro.
~~~

O runbook deve ser revisado depois de cada incidente relevante ou mudança importante na arquitetura.

**Como o candidato deve responder:**

O candidato deve:

- Priorizar incidentes recorrentes e críticos;
- Estruturar sintomas, diagnóstico, contenção e recuperação;
- Mencionar critérios de escalonamento;
- Evitar segredos na documentação;
- Validar os procedimentos com simulações;
- Promover rodízio e compartilhamento de conhecimento;
- Manter os runbooks atualizados.

Deve evitar criar documentos genéricos como “verifique os logs e reinicie a aplicação”.

**Resposta fraca ou incompleta:**

“Eu documentaria os passos para reiniciar o serviço e deixaria o material no repositório.”

Essa resposta não orienta diagnóstico, contenção segura, validação, comunicação ou escalonamento.

**Critérios de avaliação:**

- **0** — Não reconhece a importância de runbooks.
- **1** — Centraliza o conhecimento no Tech Lead.
- **2** — Documenta apenas comandos ou reinício.
- **3** — Cria procedimentos básicos para diagnóstico e recuperação.
- **4** — Inclui impacto, contenção, escalonamento, validação e simulações.
- **5** — Demonstra estratégia madura de autonomia operacional, documentação viva e redução de dependências individuais.

**Perguntas de aprofundamento:**

1. Como saberia quais runbooks criar primeiro?
2. Como validaria se um runbook está realmente útil?
3. O que faria se o procedimento documentado não funcionasse durante um incidente?
4. Como desenvolveria a autonomia operacional de pessoas juniores?

---

# Resumo desta parte

| Item | Resultado |
|---|---|
| Perguntas apresentadas | 61 a 70 |
| Níveis abordados | Júnior, Pleno e Sênior |
| Temas principais | Observabilidade, health checks, troubleshooting, logs, alertas, incidentes financeiros, tracing, SLOs, post-mortem e runbooks |
| Perguntas restantes | 30 |

## Competências exploradas

- Fundamentos de observabilidade;
- Métricas, logs e traces;
- Monitoramento de aplicações Spring Boot;
- Diferença entre liveness e readiness;
- Investigação estruturada em produção;
- Preservação de evidências;
- Logs úteis e seguros;
- Proteção de dados em observabilidade;
- Alertas acionáveis;
- Redução de fadiga de alerta;
- Gestão de incidentes críticos;
- Contenção de danos financeiros;
- Idempotência e reconciliação;
- Tracing distribuído;
- SLIs, SLOs e error budgets;
- Post-mortems sem culpabilização;
- Runbooks;
- Autonomia operacional;
- Compartilhamento de conhecimento;
- Melhoria contínua da operação.

---

# Roteiro Completo de Entrevista — Tech Lead de um Time Java

## Parte 8 de 10 — Perguntas 71 a 80

**Foco desta parte:** liderança técnica sênior, evolução arquitetural, governança, escala organizacional, alinhamento estratégico e influência sem autoridade formal.

> As perguntas consideram um Tech Lead responsável por orientar decisões técnicas, influenciar outros times, evoluir a arquitetura e conectar a estratégia de engenharia aos objetivos do produto.

## Fluxo de liderança técnica em escala

~~~mermaid
flowchart TD
    A[Objetivos estratégicos] --> B[Princípios técnicos]
    B --> C[Roadmap de engenharia]
    C --> D[Coordenação entre times]
    D --> E[Execução incremental]
    E --> F[Métricas técnicas e de produto]
    F --> G[Revisão de resultados]
    G --> C

    H[Governança leve] --> B
    H --> C
    H --> D

    I[Desenvolvimento de pessoas] --> D
    I --> E
    I --> G
~~~

---

## Pergunta 71 — Influência sem autoridade formal

**Nível:** Sênior  
**Categoria:** Liderança e influência

**Pergunta do entrevistador:**

Como você influenciaria decisões técnicas de outros times quando não possui autoridade hierárquica sobre seus integrantes?

**O que essa pergunta avalia:**

Avalia capacidade de liderar por influência, construir confiança, utilizar argumentos técnicos e negociar decisões entre equipes.

**Resposta esperada:**

Eu começaria buscando compreender os objetivos, restrições e problemas do outro time. Antes de propor uma solução, tentaria construir uma visão comum sobre:

- O problema que precisa ser resolvido;
- Os impactos para cada equipe;
- As restrições existentes;
- Os riscos;
- Os critérios de sucesso;
- As alternativas possíveis.

Apresentaria recomendações baseadas em evidências, como:

- Incidentes;
- Métricas;
- Tempo de entrega;
- Custos;
- Falhas de integração;
- Necessidades dos consumidores;
- Requisitos de segurança;
- Impactos operacionais.

Também procuraria envolver as pessoas certas desde o início, em vez de anunciar uma decisão pronta.

Quando houvesse discordância, documentaria as alternativas e os trade-offs. Se não fosse possível chegar a um acordo, utilizaria o processo de escalonamento definido pela organização, sem transformar a discussão em uma disputa pessoal.

Influência sustentável depende de:

- Consistência;
- Clareza;
- Escuta;
- Credibilidade;
- Disposição para ajudar;
- Transparência;
- Cumprimento de compromissos.

**Explicação didática:**

Um Tech Lead frequentemente precisa influenciar decisões fora do próprio time. Isso pode acontecer em:

- Contratos de APIs;
- Padrões de segurança;
- Estratégias de observabilidade;
- Bibliotecas compartilhadas;
- Pipelines;
- Modelos de integração;
- Práticas de incidentes.

A autoridade formal pode impor uma decisão, mas não garante adesão ou qualidade na execução. A influência funciona melhor quando as pessoas compreendem o problema e participam da construção da solução.

**Exemplo prático:**

Se outro time deseja alterar um contrato utilizado pela aplicação de pedidos, eu não apenas exigiria que mantivessem o formato antigo. Mostraria:

- Quais consumidores existem;
- Qual parte seria quebrada;
- Qual o custo de migração;
- Quais alternativas são compatíveis;
- Qual cronograma seria viável.

Também ofereceria apoio para criar testes de contrato e fazer a transição.

**Exemplo de código:**

Não é necessário código. A competência avaliada está relacionada à colaboração e à influência entre times.

**Como o candidato deve responder:**

O candidato deve:

- Falar sobre confiança e colaboração;
- Utilizar evidências;
- Compreender as restrições do outro time;
- Apresentar alternativas;
- Evitar impor decisões;
- Documentar trade-offs;
- Saber quando escalar;
- Demonstrar influência sem depender de autoridade.

Deve evitar respostas como:

- “Eu exigiria que o outro time seguisse o padrão”;
- “Se eu estiver tecnicamente certo, eles terão que aceitar”;
- “Escalaria imediatamente para a diretoria”.

**Resposta fraca ou incompleta:**

“Eu explicaria a solução e, se o outro time não concordasse, pediria que a liderança deles decidisse.”

Essa resposta transfere o conflito para a hierarquia e não demonstra capacidade de construir alinhamento.

**Critérios de avaliação:**

- **0** — Depende exclusivamente de autoridade.
- **1** — Impõe decisões ou escala qualquer discordância.
- **2** — Explica sua proposta, mas não considera o contexto do outro time.
- **3** — Busca consenso e apresenta argumentos técnicos.
- **4** — Utiliza evidências, trade-offs, documentação e negociação.
- **5** — Demonstra influência madura, capacidade de construir alinhamento e habilidade para resolver conflitos entre equipes.

**Perguntas de aprofundamento:**

1. Como agiria se o outro time tivesse mais poder de decisão?
2. O que faria se a decisão consensual ainda apresentasse riscos?
3. Como construiria credibilidade com uma equipe que não conhece seu trabalho?

---

## Pergunta 72 — Definição de princípios técnicos

**Nível:** Sênior  
**Categoria:** Governança técnica

**Pergunta do entrevistador:**

Quais princípios técnicos você estabeleceria para orientar vários times Java sem transformar a organização em um ambiente excessivamente burocrático?

**O que essa pergunta avalia:**

Avalia capacidade de criar padrões úteis, preservar autonomia e estabelecer governança proporcional ao risco.

**Resposta esperada:**

Eu evitaria começar por uma lista extensa de regras. Primeiro identificaria problemas recorrentes que justificam um princípio, como:

- Falhas de segurança;
- APIs incompatíveis;
- Falta de observabilidade;
- Dependências duplicadas;
- Deploys não rastreáveis;
- Ausência de testes críticos;
- Uso inconsistente de bibliotecas;
- Dificuldade de suporte.

Os princípios deveriam ser poucos, claros e orientados a resultados. Exemplos:

- Serviços devem possuir logs, métricas e health checks adequados;
- Segredos não devem ser armazenados no código;
- Mudanças incompatíveis precisam de estratégia de transição;
- Artefatos implantados devem ser rastreáveis;
- Operações financeiras devem possuir proteção contra duplicidade;
- Alterações de banco devem ser compatíveis durante o deploy;
- Vulnerabilidades críticas devem possuir tratamento prioritário.

Eu diferenciaria:

- Princípios obrigatórios;
- Recomendações;
- Exemplos;
- Exceções justificadas.

Também criaria um processo simples para revisar os princípios, registrar exceções e medir se eles estão produzindo os resultados esperados.

**Explicação didática:**

Governança técnica deve reduzir riscos e facilitar decisões, não controlar cada detalhe de implementação.

Um princípio como “toda aplicação deve utilizar exatamente a mesma biblioteca” pode ser excessivamente rígido. Um princípio como “dependências devem possuir manutenção, licença compatível e análise de vulnerabilidades” é mais sustentável.

A governança deve estabelecer o resultado esperado sem impedir que os times escolham a implementação adequada ao seu contexto.

**Exemplo prático:**

Em vez de obrigar todos os times a utilizar a mesma solução de mensageria, a organização poderia exigir:

- Contratos versionados;
- Idempotência;
- Monitoramento de backlog;
- Tratamento de mensagens inválidas;
- Processo de reprocessamento;
- Responsável operacional.

Assim, o princípio protege o resultado sem prescrever uma ferramenta única.

**Exemplo de código:**

Um princípio de arquitetura poderia ser representado assim:

~~~text
Princípio:
Toda integração externa deve possuir timeout explícito,
tratamento de falhas e métricas de sucesso, erro e latência.

Exceção:
Uma integração legada sem suporte a timeout poderá utilizar
um adaptador controlado, desde que exista plano de substituição
e monitoramento adicional.
~~~

**Como o candidato deve responder:**

O candidato deve:

- Criar poucos princípios;
- Relacionar padrões a riscos reais;
- Diferenciar obrigatoriedade de recomendação;
- Preservar autonomia dos times;
- Definir exceções;
- Criar mecanismos de revisão;
- Evitar padronização por preferência pessoal.

Deve evitar afirmar que governança significa obrigar todos os times a utilizar a mesma arquitetura ou biblioteca.

**Resposta fraca ou incompleta:**

“Eu criaria um padrão único para todos os projetos e exigiria aprovação da arquitetura para qualquer alteração.”

Essa abordagem pode criar gargalos e não considera diferentes contextos de produto.

**Critérios de avaliação:**

- **0** — Não compreende governança.
- **1** — Defende controle centralizado de todos os detalhes.
- **2** — Cria padrões, mas não explica sua finalidade.
- **3** — Define princípios básicos para segurança e qualidade.
- **4** — Considera autonomia, risco, exceções e revisão.
- **5** — Demonstra governança leve, orientada a resultados e capaz de escalar sem criar burocracia desnecessária.

**Perguntas de aprofundamento:**

1. Quando um padrão deveria ser obrigatório?
2. Como trataria um time que precisa de uma exceção?
3. Como saberia se uma governança está gerando valor?

---

## Pergunta 73 — Roadmap técnico conectado ao produto

**Nível:** Sênior  
**Categoria:** Estratégia e planejamento

**Pergunta do entrevistador:**

Como você construiria um roadmap técnico para um time Java sem transformá-lo em uma lista isolada de atualizações, refatorações e novas ferramentas?

**O que essa pergunta avalia:**

Avalia capacidade de conectar iniciativas técnicas a resultados de produto, riscos, eficiência e sustentabilidade.

**Resposta esperada:**

Eu começaria pelos objetivos do produto e pelos problemas que limitam a capacidade de entrega. Em seguida, identificaria iniciativas técnicas relacionadas a resultados, como:

- Reduzir incidentes;
- Diminuir tempo de entrega;
- Melhorar desempenho;
- Reduzir custo;
- Aumentar segurança;
- Permitir uma nova funcionalidade;
- Melhorar disponibilidade;
- Reduzir dependência de conhecimento concentrado;
- Aumentar capacidade de experimentação.

Cada iniciativa deveria possuir:

- Problema;
- Objetivo;
- Benefício esperado;
- Riscos;
- Esforço aproximado;
- Dependências;
- Métricas;
- Horizonte;
- Responsável;
- Critério de conclusão.

Por exemplo, em vez de registrar “migrar para uma nova versão do Spring Boot”, eu descreveria:

> “Atualizar a plataforma para reduzir exposição a vulnerabilidades, facilitar suporte e diminuir o tempo de manutenção das dependências.”

O roadmap deve ser revisado conforme novas evidências surgirem. Não deve ser tratado como um compromisso imutável.

**Explicação didática:**

Um roadmap técnico não deve competir com o roadmap de produto. Ele deve explicar como a engenharia permitirá entregar o produto com mais segurança, velocidade e sustentabilidade.

Uma iniciativa técnica pode ser necessária mesmo sem uma funcionalidade visível para o usuário, mas precisa possuir um problema ou resultado claro.

**Exemplo prático:**

Uma iniciativa para melhorar testes de contrato pode permitir que times liberem alterações com menos coordenação manual. O benefício não é apenas “ter mais testes”, mas reduzir falhas de integração e tempo de validação.

**Exemplo de código:**

Não é necessário código. O tema envolve planejamento e alinhamento estratégico.

**Como o candidato deve responder:**

O candidato deve:

- Começar pelos problemas e objetivos;
- Conectar tecnologia a resultados;
- Definir métricas;
- Considerar esforço e risco;
- Priorizar iniciativas;
- Revisar o roadmap;
- Evitar uma lista de tecnologias da moda.

Deve evitar apresentar um roadmap composto apenas por:

- Atualização de frameworks;
- Troca de banco;
- Adoção de microsserviços;
- Compra de ferramentas;
- Refatorações sem objetivo mensurável.

**Resposta fraca ou incompleta:**

“Eu listaria todas as tecnologias desatualizadas e criaria um plano para atualizá-las.”

Essa abordagem não demonstra valor, prioridade ou relação com o produto.

**Critérios de avaliação:**

- **0** — Não sabe construir um roadmap técnico.
- **1** — Cria apenas uma lista de tecnologias.
- **2** — Identifica iniciativas, mas não as relaciona a resultados.
- **3** — Conecta melhorias técnicas a riscos e entrega.
- **4** — Inclui métricas, prioridades, dependências e revisão.
- **5** — Demonstra visão estratégica e capacidade de transformar necessidades técnicas em investimentos compreensíveis e justificáveis.

**Perguntas de aprofundamento:**

1. Como priorizaria uma iniciativa técnica sem benefício visível imediato?
2. Como apresentaria o roadmap para a liderança de produto?
3. O que faria se uma prioridade de negócio alterasse o roadmap?

---

## Pergunta 74 — Gestão de arquitetura em múltiplos times

**Nível:** Sênior  
**Categoria:** Arquitetura organizacional

**Pergunta do entrevistador:**

Como você evitaria que vários times Java criassem soluções incompatíveis para problemas semelhantes?

**O que essa pergunta avalia:**

Avalia capacidade de promover alinhamento técnico, reutilização consciente e autonomia organizacional.

**Resposta esperada:**

Eu começaria identificando os pontos em que a falta de alinhamento gera impacto:

- Contratos incompatíveis;
- Bibliotecas duplicadas;
- Diferentes padrões de segurança;
- Formatos de logs inconsistentes;
- Estratégias divergentes de observabilidade;
- Regras de autenticação incompatíveis;
- Componentes compartilhados difíceis de manter.

Para reduzir esses problemas, utilizaria:

- Princípios técnicos claros;
- Documentação acessível;
- Fóruns de arquitetura;
- ADRs;
- Catálogos de padrões;
- Exemplos reutilizáveis;
- Bibliotecas compartilhadas somente quando fizerem sentido;
- Testes de contrato;
- Revisões entre pares;
- Comunidades de prática;
- Reuniões temporárias para decisões específicas.

Eu evitaria centralizar todas as decisões em um comitê. Os times devem manter autonomia para decisões locais, enquanto decisões com impacto transversal precisam de alinhamento.

Também verificaria se a padronização realmente reduz custo. Uma biblioteca compartilhada pode facilitar o uso inicial, mas criar acoplamento e dificultar atualizações.

**Explicação didática:**

Alinhamento não significa que todos os times devem ter exatamente o mesmo código. Significa que as fronteiras e os comportamentos que precisam ser compatíveis são conhecidos.

Por exemplo, todos os serviços podem adotar padrões comuns de:

- Correlação;
- Erros;
- Autenticação;
- Métricas;
- Contratos.

Mas cada time pode escolher a estrutura interna mais adequada ao seu domínio.

**Exemplo prático:**

Se três times implementam integração com pagamentos de formas diferentes, eu promoveria uma discussão sobre:

- Idempotência;
- Timeouts;
- Auditoria;
- Estados da transação;
- Reconciliação;
- Tratamento de falhas.

O objetivo seria alinhar princípios essenciais, não necessariamente obrigar todos a usar a mesma classe ou biblioteca.

**Exemplo de código:**

Um contrato comum de erro poderia ser:

~~~json
{
  "code": "RECURSO_INDISPONIVEL",
  "message": "Não foi possível concluir a operação.",
  "traceId": "abc-123"
}
~~~

Cada serviço pode implementar internamente o tratamento de forma diferente, desde que respeite o contrato compartilhado quando necessário.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar alinhamento de centralização;
- Identificar decisões transversais;
- Usar padrões, ADRs e fóruns;
- Considerar comunidades de prática;
- Avaliar o custo de bibliotecas compartilhadas;
- Preservar autonomia local;
- Definir critérios para decisões que exigem coordenação.

Deve evitar criar um processo em que toda decisão precise da aprovação de um grupo central.

**Resposta fraca ou incompleta:**

“Eu criaria uma arquitetura central e obrigaria todos os times a segui-la.”

Essa resposta pode reduzir divergências, mas cria dependência, lentidão e risco de decisões distantes do contexto real.

**Critérios de avaliação:**

- **0** — Não identifica o problema de inconsistência entre times.
- **1** — Defende apenas imposição central.
- **2** — Cria padrões, mas não diferencia decisões locais e transversais.
- **3** — Promove documentação e alinhamento.
- **4** — Considera autonomia, contratos, comunidades e custo de reutilização.
- **5** — Demonstra capacidade de escalar arquitetura por influência, padrões leves e decisões distribuídas com responsabilidade.

**Perguntas de aprofundamento:**

1. Quais decisões deveriam ser compartilhadas entre todos os times?
2. Quando uma biblioteca comum criaria mais problemas que benefícios?
3. Como resolveria divergências entre padrões adotados por times diferentes?

---

## Pergunta 75 — Estratégia de plataforma interna

**Nível:** Sênior  
**Categoria:** Engenharia de plataforma

**Pergunta do entrevistador:**

Quando faria sentido criar uma plataforma interna para apoiar times Java e Spring Boot? Como evitaria que ela se transformasse em uma área que apenas cria ferramentas sem adoção?

**O que essa pergunta avalia:**

Avalia compreensão sobre plataformas internas, experiência do desenvolvedor, autosserviço, adoção e valor organizacional.

**Resposta esperada:**

Eu consideraria uma plataforma interna quando existissem necessidades recorrentes que pudessem ser oferecidas como capacidades reutilizáveis, como:

- Criação de serviços;
- Pipelines;
- Observabilidade;
- Gestão de ambientes;
- Segurança;
- Provisionamento;
- Registro de artefatos;
- Configuração;
- Deploy;
- Templates de aplicações.

Antes de criar a plataforma, investigaria:

- Quais problemas os times enfrentam;
- Quanto tempo é gasto em tarefas repetitivas;
- Quais capacidades são críticas;
- Qual nível de autonomia é desejado;
- Quais integrações já existem;
- Quem manterá a plataforma;
- Como será medida a adoção.

A plataforma deveria oferecer uma experiência de produto para os times consumidores, com:

- Documentação;
- Autosserviço;
- Feedback;
- Suporte;
- Evolução incremental;
- Indicadores de uso;
- Satisfação;
- Tempo economizado;
- Redução de falhas.

Eu evitaria obrigar a adoção antes de provar valor. Também evitaria criar abstrações tão rígidas que impeçam os times de tratar necessidades específicas.

**Explicação didática:**

Uma plataforma interna não deve ser apenas um conjunto de ferramentas. Ela deve reduzir a carga cognitiva e permitir que os times entreguem produtos com mais segurança.

Por exemplo, um template para uma aplicação Spring Boot pode incluir:

- Pipeline;
- Health checks;
- Logs estruturados;
- Métricas;
- Segurança básica;
- Documentação;
- Deploy;
- Testes.

Mas o template precisa ser mantido, atualizado e adaptável.

**Exemplo prático:**

Se cada time gasta vários dias configurando manualmente pipelines e observabilidade, uma plataforma pode fornecer um caminho padrão para criar um serviço.

O sucesso poderia ser medido por:

- Tempo para criar um novo serviço;
- Tempo até o primeiro deploy;
- Redução de erros de configuração;
- Adoção voluntária;
- Satisfação dos desenvolvedores;
- Tempo de manutenção.

**Exemplo de código:**

Um template conceitual poderia definir capacidades mínimas:

~~~text
Serviço Spring Boot padrão:
- build automatizado;
- testes unitários;
- análise de dependências;
- health checks;
- logs estruturados;
- métricas;
- documentação da API;
- ambiente de validação;
- deploy rastreável.
~~~

**Como o candidato deve responder:**

O candidato deve:

- Começar por problemas reais dos times;
- Tratar a plataforma como produto interno;
- Considerar adoção e experiência;
- Oferecer autosserviço;
- Medir resultados;
- Evitar imposição sem valor;
- Planejar manutenção e suporte;
- Preservar extensibilidade.

Deve evitar construir uma plataforma baseada apenas em preferências da equipe de infraestrutura.

**Resposta fraca ou incompleta:**

“Eu criaria templates padronizados e obrigaria todos os times a utilizá-los.”

Essa abordagem não avalia necessidades, adoção, experiência ou custo de manutenção.

**Critérios de avaliação:**

- **0** — Não compreende o propósito de uma plataforma interna.
- **1** — Foca apenas em ferramentas.
- **2** — Cria templates, mas não considera adoção ou manutenção.
- **3** — Relaciona a plataforma à padronização e produtividade.
- **4** — Considera experiência, autosserviço, métricas e evolução.
- **5** — Demonstra visão de produto interno, foco no usuário desenvolvedor e capacidade de gerar valor sustentável.

**Perguntas de aprofundamento:**

1. Como mediria se a plataforma está sendo útil?
2. O que faria se os times evitassem utilizar a plataforma?
3. Como equilibraria padrão e flexibilidade?

---

## Pergunta 76 — Escala de contratação e desenvolvimento técnico

**Nível:** Sênior  
**Categoria:** Pessoas e capacidade organizacional

**Pergunta do entrevistador:**

Como você identificaria as competências técnicas necessárias para que um time Java cresça sem depender indefinidamente de poucas pessoas experientes?

**O que essa pergunta avalia:**

Avalia capacidade de desenvolver pessoas, mapear riscos de conhecimento e estruturar crescimento técnico sustentável.

**Resposta esperada:**

Eu começaria mapeando as capacidades necessárias para operar e evoluir o produto:

- Java e Spring Boot;
- Domínio de negócio;
- Banco de dados;
- APIs e integrações;
- Testes;
- CI/CD;
- Observabilidade;
- Segurança;
- Gestão de incidentes;
- Arquitetura;
- Comunicação;
- Planejamento;
- Conhecimento operacional.

Depois, identificaria:

- Conhecimentos concentrados em poucas pessoas;
- Lacunas críticas;
- Dependências de especialistas;
- Áreas sem documentação;
- Competências que podem ser desenvolvidas internamente;
- Habilidades que exigem contratação.

Criaria planos de desenvolvimento por meio de:

- Pareamento;
- Mentoria;
- Rotação;
- Ownership progressivo;
- Apresentações técnicas;
- Participação em incidentes;
- Revisões;
- Spikes;
- Documentação;
- Objetivos individuais.

Contratação e desenvolvimento devem ser complementares. Contratar pessoas seniores não resolve automaticamente a concentração de conhecimento se o sistema e o processo continuarem dependentes de indivíduos.

**Explicação didática:**

Um time sustentável não é aquele em que poucas pessoas resolvem tudo. É aquele em que o conhecimento crítico está distribuído e as pessoas conseguem assumir responsabilidades progressivamente.

Também é importante evitar usar uma matriz de competências como instrumento punitivo. Ela deve ajudar a identificar oportunidades de desenvolvimento e riscos operacionais.

**Exemplo prático:**

Se apenas uma pessoa sabe executar uma migração de banco, eu criaria uma oportunidade para outra pessoa participar da próxima alteração, com revisão e supervisão. Depois, registraria o procedimento e exercitaria a execução.

**Exemplo de código:**

Não é necessário código. A situação pode envolver componentes Java, mas a competência avaliada está relacionada à evolução das pessoas e à sustentabilidade do time.

**Como o candidato deve responder:**

O candidato deve:

- Mapear competências;
- Identificar concentração de conhecimento;
- Promover desenvolvimento progressivo;
- Utilizar mentoria e pareamento;
- Combinar formação interna e contratação;
- Evitar dependências individuais;
- Considerar domínio e operação, não apenas tecnologia.

Deve evitar afirmar que a solução para qualquer lacuna é contratar um desenvolvedor sênior.

**Resposta fraca ou incompleta:**

“Eu contrataria mais pessoas experientes para distribuir o conhecimento.”

Essa resposta pode ajudar, mas não apresenta estratégia de desenvolvimento, documentação ou transferência de conhecimento.

**Critérios de avaliação:**

- **0** — Não identifica riscos de concentração.
- **1** — Depende apenas de novas contratações.
- **2** — Reconhece lacunas, mas não cria plano de desenvolvimento.
- **3** — Propõe mentoria, pareamento e treinamento.
- **4** — Considera competências técnicas, domínio, operação e distribuição de ownership.
- **5** — Demonstra estratégia completa de capacidade organizacional, desenvolvimento e redução de dependências individuais.

**Perguntas de aprofundamento:**

1. Como agiria se uma pessoa-chave deixasse a empresa?
2. Como avaliaria o progresso de uma pessoa em desenvolvimento?
3. Como evitaria sobrecarregar os especialistas com mentoria?

---

## Pergunta 77 — Gestão de dependências entre times

**Nível:** Sênior  
**Categoria:** Coordenação e planejamento

**Pergunta do entrevistador:**

Como você reduziria o impacto de dependências entre vários times que precisam entregar uma funcionalidade conjunta?

**O que essa pergunta avalia:**

Avalia capacidade de coordenar equipes, reduzir acoplamento organizacional e planejar entregas integradas.

**Resposta esperada:**

Eu começaria identificando todas as dependências e classificando-as:

- Dependências técnicas;
- Dependências de decisão;
- Dependências de ambiente;
- Dependências de dados;
- Dependências de contrato;
- Dependências de calendário;
- Dependências de aprovação.

Depois, verificaria se a funcionalidade pode ser decomposta em fatias menores e entregáveis independentes.

Para reduzir o risco, utilizaria:

- Contratos definidos cedo;
- Mocks e stubs;
- Testes de contrato;
- Feature flags;
- Compatibilidade entre versões;
- Integração antecipada;
- Ownership claro;
- Datas de alinhamento;
- Canal de comunicação;
- Registro de decisões;
- Limites de trabalho em andamento.

Também avaliaria se a dependência existe por necessidade real ou por uma estrutura organizacional inadequada. Às vezes, uma API interna complexa poderia ser substituída por um evento ou por uma mudança de ownership.

Eu evitaria resolver dependências apenas com reuniões adicionais. O objetivo é reduzir o acoplamento e tornar o fluxo verificável.

**Explicação didática:**

Dependências entre times podem aumentar o tempo de espera e criar incerteza. Uma equipe pode concluir seu trabalho, mas permanecer bloqueada aguardando uma alteração externa.

A melhor estratégia é antecipar a integração e permitir que as equipes avancem com contratos e componentes simulados.

**Exemplo prático:**

Se o time de pedidos depende de uma API de pagamento, os dois times podem definir o contrato antes da implementação e utilizar um stub para validar o fluxo. Assim, a equipe de pedidos pode desenvolver e testar sem esperar o serviço completo.

**Exemplo de código:**

Um contrato mínimo poderia ser:

~~~json
{
  "request": {
    "pedidoId": "123",
    "valor": 150.00,
    "idempotencyKey": "pedido-123-pagamento"
  },
  "response": {
    "status": "EM_PROCESSAMENTO",
    "transacaoId": "tx-456"
  }
}
~~~

O contrato deve esclarecer estados, erros, idempotência e compatibilidade, não apenas o formato do JSON.

**Como o candidato deve responder:**

O candidato deve:

- Mapear dependências;
- Definir contratos cedo;
- Propor integração antecipada;
- Usar stubs e testes de contrato;
- Reduzir acoplamento;
- Criar ownership claro;
- Evitar depender apenas de reuniões;
- Considerar decomposição e entrega incremental.

Deve evitar aceitar dependências indefinidas até o final do desenvolvimento.

**Resposta fraca ou incompleta:**

“Eu acompanharia as dependências nas reuniões de status e cobraria os outros times.”

Essa abordagem monitora o problema, mas não o reduz.

**Critérios de avaliação:**

- **0** — Não identifica ou gerencia dependências.
- **1** — Apenas cobra prazos de outros times.
- **2** — Lista dependências, mas não propõe redução de acoplamento.
- **3** — Define responsáveis, contratos e acompanhamento.
- **4** — Inclui integração antecipada, stubs, flags e testes de contrato.
- **5** — Demonstra capacidade de redesenhar o fluxo para reduzir dependências e acelerar entregas conjuntas.

**Perguntas de aprofundamento:**

1. O que faria se a dependência fosse atrasada repetidamente?
2. Como entregaria uma funcionalidade sem esperar todos os times?
3. Quando uma dependência deveria ser eliminada por mudança arquitetural?

---

## Pergunta 78 — Avaliação de uma proposta técnica controversa

**Nível:** Sênior  
**Categoria:** Tomada de decisão

**Pergunta do entrevistador:**

Um desenvolvedor propõe uma solução tecnicamente sofisticada que resolve um problema futuro, mas aumenta muito a complexidade da entrega atual. Como você avaliaria a proposta sem desmotivar a pessoa?

**O que essa pergunta avalia:**

Avalia capacidade de analisar ideias, preservar a colaboração e tomar decisões proporcionais ao problema.

**Resposta esperada:**

Eu começaria reconhecendo a preocupação e pedindo que a pessoa explicasse:

- Qual problema a solução resolve;
- Quais premissas foram consideradas;
- Qual é o benefício esperado;
- Quando esse benefício será necessário;
- Quais riscos existem hoje;
- Qual custo de implementação;
- Qual custo de operação;
- Quais alternativas mais simples foram avaliadas;
- Como a solução poderia evoluir posteriormente.

Depois, compararia as alternativas por critérios objetivos:

- Requisitos atuais;
- Crescimento esperado;
- Risco;
- Prazo;
- Complexidade;
- Custo;
- Reversibilidade;
- Capacidade do time;
- Impacto operacional.

Se a solução sofisticada não for necessária agora, eu poderia registrar a necessidade futura e escolher uma abordagem mais simples, definindo sinais que indicariam quando revisitar a decisão.

Se o problema futuro for suficientemente provável e caro de resolver depois, a solução mais elaborada pode ser justificável. O importante é evitar tanto o excesso de antecipação quanto o pensamento de curto prazo.

**Explicação didática:**

Uma arquitetura pode ser tecnicamente excelente e ainda inadequada para o momento. A decisão deve considerar o custo da complexidade e o valor que ela entrega.

Também é importante não rejeitar uma proposta de forma pessoal. Ideias devem ser avaliadas; pessoas devem ser respeitadas.

**Exemplo prático:**

Um time pode propor processamento distribuído para suportar milhões de eventos, mas o produto atualmente processa poucos milhares por dia. Talvez seja melhor criar uma estrutura modular, adicionar métricas e definir limites que permitam migrar depois.

**Exemplo de código:**

Não é necessário código. A questão avalia análise de alternativas e comunicação.

**Como o candidato deve responder:**

O candidato deve:

- Ouvir a proposta;
- Explicitar premissas;
- Comparar custo e benefício;
- Considerar futuro e presente;
- Avaliar reversibilidade;
- Registrar sinais para revisitar;
- Preservar a colaboração;
- Evitar decisões baseadas em ego ou autoridade.

Deve evitar rejeitar a ideia apenas por parecer complexa ou aceitá-la apenas por ser tecnicamente avançada.

**Resposta fraca ou incompleta:**

“Eu escolheria a solução simples, porque devemos evitar complexidade.”

A simplicidade é importante, mas não deve ignorar riscos reais ou necessidades futuras relevantes.

**Critérios de avaliação:**

- **0** — Decide por preferência pessoal.
- **1** — Rejeita ou aceita sem análise.
- **2** — Compara apenas esforço e prazo.
- **3** — Avalia benefícios e custos básicos.
- **4** — Considera risco, operação, reversibilidade e evolução.
- **5** — Demonstra julgamento técnico, comunicação respeitosa e capacidade de escolher a complexidade adequada ao contexto.

**Perguntas de aprofundamento:**

1. Como saberia se o futuro risco é real ou apenas especulativo?
2. Como documentaria uma decisão de adiar a solução sofisticada?
3. Como reagiria se a pessoa insistisse publicamente na proposta?

---

## Pergunta 79 — Gestão de mudanças organizacionais

**Nível:** Sênior  
**Categoria:** Transformação e liderança

**Pergunta do entrevistador:**

A organização decidiu adotar uma nova forma de trabalho, com deploys mais frequentes, maior responsabilidade dos times sobre produção e revisão de arquitetura. Como você conduziria essa mudança?

**O que essa pergunta avalia:**

Avalia liderança em transformação organizacional, gestão de adoção, comunicação e capacidade de identificar obstáculos sistêmicos.

**Resposta esperada:**

Eu começaria esclarecendo o objetivo da mudança e os problemas que ela pretende resolver. Depois, avaliaria a situação atual:

- Maturidade dos times;
- Capacidade dos pipelines;
- Qualidade dos testes;
- Observabilidade;
- Acesso à produção;
- Processos de incidentes;
- Conhecimento operacional;
- Resistências;
- Incentivos existentes;
- Limitações de segurança ou compliance.

Não trataria a mudança como uma simples comunicação de novas regras. Criaria um caminho incremental, com:

- Piloto em um ou poucos times;
- Objetivos claros;
- Suporte;
- Treinamento;
- Templates;
- Runbooks;
- Métricas;
- Espaços para feedback;
- Revisão dos resultados;
- Expansão gradual.

Se a organização exigir responsabilidade sobre produção sem fornecer acesso, automação ou suporte, eu destacaria essa contradição.

Também comunicaria tanto os benefícios quanto os custos. Mudanças sustentáveis exigem ajustes em processos, responsabilidades, ferramentas e expectativas de liderança.

**Explicação didática:**

Transformações falham quando se alteram apenas as responsabilidades formais, sem mudar as condições necessárias para que as pessoas tenham sucesso.

Por exemplo, exigir deploy frequente sem melhorar o pipeline pode aumentar falhas. Exigir ownership operacional sem observabilidade pode aumentar estresse e tempo de recuperação.

O Tech Lead deve ajudar a remover impedimentos e tornar a mudança praticável.

**Exemplo prático:**

Para aumentar a frequência de deploy, o time poderia começar por:

1. Reduzir o tamanho dos pull requests;
2. Automatizar testes essenciais;
3. Criar feature flags;
4. Melhorar o pipeline;
5. Adicionar métricas de deploy;
6. Fazer releases graduais;
7. Revisar resultados.

**Exemplo de código:**

Não é necessário código. O foco está na condução da mudança e nos mecanismos de adoção.

**Como o candidato deve responder:**

O candidato deve:

- Explicar o propósito da mudança;
- Avaliar a maturidade atual;
- Propor adoção incremental;
- Criar pilotos e métricas;
- Oferecer suporte;
- Identificar contradições organizacionais;
- Ouvir resistências;
- Ajustar o processo com base em evidências.

Deve evitar simplesmente comunicar novas regras e responsabilizar os times pelo resultado.

**Resposta fraca ou incompleta:**

“Eu explicaria a nova política e cobraria que todos os times a adotassem.”

Essa resposta não considera capacidade, obstáculos, treinamento, métricas ou adaptação.

**Critérios de avaliação:**

- **0** — Impõe mudanças sem preparar a organização.
- **1** — Comunica regras e cobra adesão.
- **2** — Reconhece resistência, mas não cria estratégia.
- **3** — Propõe treinamento, suporte e acompanhamento.
- **4** — Inclui pilotos, métricas, feedback e remoção de impedimentos.
- **5** — Demonstra liderança de transformação, pensamento sistêmico e capacidade de alinhar processos, pessoas e tecnologia.

**Perguntas de aprofundamento:**

1. Como agiria se um time se recusasse a participar do piloto?
2. Que métricas mostrariam que a mudança está funcionando?
3. Como evitaria aumentar a carga operacional sobre os desenvolvedores?

---

## Pergunta 80 — Visão de longo prazo para a engenharia

**Nível:** Sênior  
**Categoria:** Estratégia técnica

**Pergunta do entrevistador:**

Como você definiria uma visão de longo prazo para a engenharia de um produto Java sem perder a capacidade de entregar valor no curto prazo?

**O que essa pergunta avalia:**

Avalia visão estratégica, equilíbrio entre curto e longo prazo, gestão de riscos e capacidade de transformar ambições técnicas em evolução incremental.

**Resposta esperada:**

Eu começaria entendendo a direção do produto:

- Quais usuários serão atendidos;
- Quais capacidades precisam ser construídas;
- Qual crescimento é esperado;
- Quais riscos podem limitar a estratégia;
- Quais requisitos de disponibilidade, segurança e desempenho existem;
- Quais restrições financeiras e organizacionais estão presentes.

A visão técnica deveria descrever capacidades, não apenas tecnologias. Por exemplo:

- Entregar com segurança várias vezes ao dia;
- Escalar operações críticas;
- Detectar e recuperar falhas rapidamente;
- Evoluir contratos sem quebrar consumidores;
- Reduzir dependência de conhecimento concentrado;
- Proteger dados sensíveis;
- Permitir autonomia responsável dos times.

Depois, transformaria a visão em uma sequência de melhorias incrementais, com:

- Princípios;
- Roadmap;
- Métricas;
- Marcos;
- Riscos;
- Dependências;
- Critérios de revisão.

Eu reservaria capacidade para:

- Funcionalidades de produto;
- Dívida técnica prioritária;
- Segurança;
- Confiabilidade;
- Evolução arquitetural;
- Desenvolvimento das pessoas.

A visão deve ser revisada conforme o produto, o mercado, a organização e os dados mudarem.

**Explicação didática:**

Uma visão de longo prazo não é uma promessa de que a arquitetura permanecerá igual por anos. É uma direção que ajuda a tomar decisões coerentes no presente.

Uma boa visão técnica responde:

- Que tipo de sistema queremos operar?
- Que capacidade o time precisa ter?
- Quais riscos não podemos aceitar?
- Como saberemos que estamos evoluindo?
- Quais decisões são reversíveis?
- O que precisa ser feito agora?

O risco de planejar apenas o curto prazo é acumular fragilidade. O risco de planejar apenas o longo prazo é atrasar valor e criar soluções prematuras.

**Exemplo prático:**

Se o produto pretende crescer para novos mercados, a engenharia pode precisar evoluir:

- Internacionalização;
- Observabilidade;
- Segurança;
- Escalabilidade;
- Contratos;
- Dados;
- Processos de deploy.

Isso não significa implementar tudo imediatamente. O time deve identificar quais capacidades serão necessárias primeiro e criar fundações graduais.

**Exemplo de código:**

Uma visão técnica poderia ser expressa assim:

~~~text
Visão de engenharia:
O produto deverá permitir entregas frequentes e reversíveis,
operar fluxos críticos com observabilidade adequada,
evoluir integrações sem quebra de consumidores e suportar
crescimento previsível sem aumento desproporcional de custo.

Indicadores:
- frequência de deploy;
- lead time;
- taxa de falha após mudança;
- tempo de recuperação;
- latência dos fluxos críticos;
- incidentes de segurança;
- dependências de conhecimento.
~~~

**Como o candidato deve responder:**

O candidato deve:

- Conectar visão técnica à estratégia do produto;
- Falar sobre capacidades e resultados;
- Balancear curto e longo prazo;
- Incluir segurança, confiabilidade e pessoas;
- Transformar a visão em etapas incrementais;
- Definir métricas;
- Revisar decisões conforme novas evidências;
- Evitar uma visão composta apenas por tecnologias.

Deve evitar apresentar como visão de longo prazo apenas:

- Migrar tudo para microsserviços;
- Adotar uma nova linguagem;
- Substituir todo o banco;
- Atualizar todos os frameworks;
- Reescrever a aplicação.

**Resposta fraca ou incompleta:**

“Eu definiria uma arquitetura moderna e prepararia o sistema para qualquer crescimento futuro.”

Essa resposta é genérica e não define capacidades, prioridades, métricas ou relação com o produto.

**Critérios de avaliação:**

- **0** — Não apresenta visão de longo prazo.
- **1** — Define apenas tecnologias futuras.
- **2** — Menciona escalabilidade, mas não conecta ao produto.
- **3** — Cria uma direção técnica alinhada a necessidades conhecidas.
- **4** — Inclui roadmap incremental, métricas, pessoas, segurança e confiabilidade.
- **5** — Demonstra visão estratégica, pragmatismo e capacidade de transformar objetivos de longo prazo em decisões concretas no presente.

**Perguntas de aprofundamento:**

1. Como evitaria que a visão técnica se tornasse uma reescrita interminável?
2. Quais capacidades técnicas deveriam ser priorizadas primeiro?
3. Como comunicaria essa visão para a liderança de negócio?
4. Como revisaria a visão se o produto mudasse de direção?

---

# Resumo desta parte

| Item | Resultado |
|---|---|
| Perguntas apresentadas | 71 a 80 |
| Níveis abordados | Sênior |
| Temas principais | Influência sem autoridade, governança, roadmap técnico, arquitetura entre times, plataforma interna, desenvolvimento de pessoas, dependências, mudanças organizacionais e visão de longo prazo |
| Perguntas restantes | 20 |

## Competências exploradas

- Liderança por influência;
- Construção de confiança entre equipes;
- Governança técnica leve;
- Definição de princípios arquiteturais;
- Criação de roadmap técnico;
- Alinhamento entre engenharia e produto;
- Coordenação entre múltiplos times;
- Redução de dependências organizacionais;
- Uso consciente de padrões compartilhados;
- Estratégia de plataforma interna;
- Experiência do desenvolvedor;
- Desenvolvimento e distribuição de conhecimento;
- Gestão de mudanças;
- Adoção incremental de novas práticas;
- Visão estratégica de engenharia;
- Equilíbrio entre curto e longo prazo;
- Métricas de evolução técnica;
- Tomada de decisão proporcional ao contexto.

---

# Roteiro Completo de Entrevista — Tech Lead de um Time Java

## Parte 9 de 10 — Perguntas 81 a 90

**Foco desta parte:** liderança de pessoas, comunicação, conflitos, tomada de decisão, mentoring, ética profissional e evolução da maturidade do time.

> As perguntas consideram um Tech Lead responsável por orientar tecnicamente o time, desenvolver pessoas, facilitar decisões e manter um ambiente de colaboração, autonomia e responsabilidade.

## Fluxo de desenvolvimento de pessoas e decisões

~~~mermaid
flowchart TD
    A[Objetivos do produto] --> B[Capacidades necessárias]
    B --> C[Mapeamento do time]
    C --> D[Delegação e desenvolvimento]
    D --> E[Execução colaborativa]
    E --> F[Feedback e acompanhamento]
    F --> G[Aprendizados]
    G --> H[Ajuste de responsabilidades]
    H --> D

    I[Conflitos] --> J[Escuta e entendimento]
    J --> K[Critérios objetivos]
    K --> L[Decisão ou acordo]
    L --> E

    M[Risco ético ou técnico] --> N[Transparência]
    N --> O[Escalonamento responsável]
    O --> E
~~~

---

## Pergunta 81 — Delegação de decisões técnicas

**Nível:** Pleno  
**Categoria:** Liderança e autonomia

**Pergunta do entrevistador:**

Como você decidiria quais decisões técnicas deve tomar diretamente e quais deveria delegar ao time?

**O que essa pergunta avalia:**

Avalia a capacidade de equilibrar liderança, autonomia, velocidade de decisão e desenvolvimento das pessoas.

**Resposta esperada:**

Eu classificaria as decisões considerando:

- Impacto;
- Reversibilidade;
- Urgência;
- Número de times afetados;
- Risco de segurança;
- Risco financeiro;
- Conhecimento disponível;
- Necessidade de alinhamento organizacional;
- Capacidade do time para assumir a decisão.

Eu tomaria diretamente ou envolveria poucas pessoas em decisões:

- Críticas para segurança;
- Relacionadas a incidentes em andamento;
- Muito urgentes;
- Com alto impacto financeiro;
- Que exigem responsabilidade formal;
- Que tenham grande impacto transversal e nenhum contexto suficiente para delegação imediata.

Delegaria decisões locais, reversíveis ou relacionadas à implementação, desde que os limites fossem claros.

Também evitaria delegar apenas tarefas. O ideal é delegar contexto e responsabilidade, permitindo que a pessoa participe da análise e da decisão.

Após a decisão, acompanharia o resultado sem microgerenciar. O objetivo da delegação é aumentar a capacidade do time, não apenas transferir trabalho.

**Explicação didática:**

Um Tech Lead que decide tudo se torna um gargalo. Um Tech Lead que delega tudo sem contexto deixa o time exposto a riscos desnecessários.

Uma boa delegação define:

- Qual problema precisa ser resolvido;
- Quais restrições existem;
- Qual autonomia foi concedida;
- Quando a decisão precisa acontecer;
- Quando buscar ajuda;
- Como o resultado será avaliado.

**Exemplo prático:**

A escolha de uma estrutura interna para uma nova funcionalidade pode ser delegada a uma pessoa mais júnior, com revisão de alguém experiente.

Já a decisão de alterar o modelo de autenticação de vários serviços pode exigir coordenação entre times, segurança e arquitetura.

**Exemplo de código:**

Não é necessário código. A questão avalia critérios de delegação e desenvolvimento de autonomia.

**Como o candidato deve responder:**

O candidato deve:

- Considerar impacto e reversibilidade;
- Diferenciar decisão estratégica e implementação local;
- Delegar com contexto;
- Evitar microgerenciamento;
- Manter responsabilidade sobre decisões críticas;
- Usar a delegação para desenvolver pessoas;
- Definir limites e momentos de acompanhamento.

Deve evitar afirmar que o Tech Lead precisa aprovar toda decisão técnica.

**Resposta fraca ou incompleta:**

“Eu delegaria as tarefas mais simples e ficaria responsável pelas decisões importantes.”

A resposta não define o que é importante nem explica como desenvolver a autonomia do time.

**Critérios de avaliação:**

- **0** — Centraliza todas as decisões.
- **1** — Delega sem critérios ou acompanhamento.
- **2** — Considera apenas a experiência da pessoa.
- **3** — Avalia impacto, urgência e complexidade.
- **4** — Delega com contexto, limites e feedback.
- **5** — Demonstra liderança situacional, desenvolvimento de autonomia e gestão consciente de riscos.

**Perguntas de aprofundamento:**

1. Como delegaria uma decisão para uma pessoa júnior?
2. O que faria se a decisão delegada gerasse um problema?
3. Como evitaria que a delegação se transformasse em abandono?

---

## Pergunta 82 — Mentoria de uma pessoa júnior

**Nível:** Pleno  
**Categoria:** Desenvolvimento de pessoas

**Pergunta do entrevistador:**

Como você ajudaria uma pessoa júnior a evoluir tecnicamente sem fazer o trabalho por ela?

**O que essa pergunta avalia:**

Avalia capacidade de ensinar, fornecer contexto, criar desafios progressivos e oferecer feedback construtivo.

**Resposta esperada:**

Eu começaria entendendo:

- O conhecimento atual da pessoa;
- Seus objetivos;
- Suas dificuldades;
- O tipo de suporte necessário;
- Quais responsabilidades já consegue assumir;
- Quais situações geram insegurança.

Depois, criaria oportunidades de desenvolvimento progressivo, como:

- Tarefas com escopo claro;
- Pair programming;
- Revisões explicativas;
- Leitura conjunta de código;
- Participação em refinamentos;
- Investigação de problemas;
- Apresentações curtas;
- Ownership de pequenas melhorias;
- Acompanhamento de testes e deploys.

Durante a revisão, eu explicaria o motivo da recomendação, não apenas indicaria uma alteração. Também faria perguntas para estimular o raciocínio:

- Quais cenários podem falhar?
- Como saberíamos que essa operação é segura?
- Como testar esse comportamento?
- O que aconteceria se a dependência estivesse indisponível?

Eu evitaria assumir toda tarefa difícil ou transformar a mentoria em uma sequência de respostas prontas.

**Explicação didática:**

Ensinar não é apenas corrigir o código. É ajudar a pessoa a desenvolver critérios para tomar decisões.

Uma pessoa júnior pode começar implementando uma alteração pequena, depois escrever testes, acompanhar uma análise de produção e, mais adiante, conduzir uma mudança com supervisão.

O nível de suporte deve diminuir gradualmente conforme a autonomia aumenta.

**Exemplo prático:**

Em uma alteração de endpoint:

1. Explicar o contexto do negócio;
2. Pedir que a pessoa proponha a solução;
3. Revisar riscos e cenários;
4. Implementar em conjunto apenas se necessário;
5. Solicitar testes;
6. Revisar o resultado;
7. Acompanhar o deploy;
8. Conversar sobre o aprendizado.

**Exemplo de código:**

Uma revisão orientadora poderia ser:

~~~java
// Em vez de apenas sugerir uma alteração:
//
// "Extraia esse método."
//
// O mentor pode questionar:
//
// "Quais regras de negócio este método concentra?"
// "Como você testaria cada cenário?"
// "Essa dependência pode falhar?"
// "Que nome tornaria a intenção mais clara?"
~~~

**Como o candidato deve responder:**

O candidato deve:

- Adaptar o suporte ao nível da pessoa;
- Ensinar contexto e raciocínio;
- Usar pareamento e feedback;
- Criar desafios progressivos;
- Evitar fazer tudo pela pessoa;
- Acompanhar a aplicação prática do aprendizado;
- Reconhecer evolução e pontos a melhorar.

Deve evitar apenas enviar cursos ou assumir todas as tarefas complexas.

**Resposta fraca ou incompleta:**

“Eu revisaria o código e explicaria os erros.”

A revisão é importante, mas não constitui sozinha um plano de desenvolvimento.

**Critérios de avaliação:**

- **0** — Não demonstra interesse em desenvolver pessoas.
- **1** — Faz o trabalho pela pessoa.
- **2** — Corrige o resultado sem ensinar o raciocínio.
- **3** — Usa revisão, pareamento e tarefas progressivas.
- **4** — Adapta o suporte, oferece contexto e acompanha a evolução.
- **5** — Demonstra mentoria estruturada, autonomia progressiva e feedback de qualidade.

**Perguntas de aprofundamento:**

1. Como ajudaria uma pessoa que tem medo de perguntar?
2. Como avaliaria se a mentoria está funcionando?
3. Como evitaria sobrecarregar a pessoa com tarefas acima da sua maturidade?

---

## Pergunta 83 — Feedback difícil para uma pessoa experiente

**Nível:** Sênior  
**Categoria:** Feedback e liderança

**Pergunta do entrevistador:**

Como você daria um feedback difícil a uma pessoa tecnicamente experiente que apresenta comportamento prejudicial à colaboração do time?

**O que essa pergunta avalia:**

Avalia maturidade para tratar comportamentos difíceis, preservar respeito e proteger a saúde do time.

**Resposta esperada:**

Eu trataria o assunto de forma privada, direta e baseada em comportamentos observáveis.

A conversa deveria explicar:

- O que aconteceu;
- Em qual contexto;
- Qual impacto foi percebido;
- Como isso afetou o time ou o produto;
- Qual comportamento esperado;
- Como podemos melhorar;
- Quando faremos acompanhamento.

Eu evitaria rótulos como “você é arrogante” ou “você não sabe trabalhar em equipe”. Em vez disso, descreveria uma situação concreta:

> “Durante a revisão, você interrompeu a apresentação três vezes e encerrou a discussão sem permitir que a outra pessoa concluísse. Isso fez com que a decisão fosse tomada sem considerar os riscos levantados.”

Também ouviria a perspectiva da pessoa. Escutar não significa invalidar o impacto observado, mas pode revelar contexto, pressão ou uma interpretação diferente.

Se o comportamento persistisse, registraria os acordos e envolveria a liderança de pessoas apropriada. Experiência técnica não deve ser utilizada como justificativa para desrespeito ou comportamento que reduza a segurança psicológica.

**Explicação didática:**

Feedback eficaz trata de comportamento e impacto, não da identidade da pessoa.

O objetivo não é vencer uma discussão, mas tornar o comportamento esperado claro e criar oportunidade de mudança.

Um feedback difícil não deve ser adiado indefinidamente. Quanto mais tempo um problema permanece sem tratamento, maior tende a ser o impacto sobre o time.

**Exemplo prático:**

Se uma pessoa experiente sempre rejeita ideias de colegas sem explicação, eu poderia combinar:

- Fazer perguntas antes de concluir;
- Explicar critérios técnicos;
- Separar discordância da pessoa;
- Permitir que propostas sejam discutidas;
- Revisar o comportamento após algumas reuniões.

**Exemplo de código:**

Não é necessário código. O tema envolve comunicação, comportamento e liderança.

**Como o candidato deve responder:**

O candidato deve:

- Dar feedback em particular;
- Utilizar fatos concretos;
- Explicar impacto;
- Ouvir a pessoa;
- Definir expectativas;
- Fazer acompanhamento;
- Escalar quando necessário;
- Proteger o ambiente do time.

Deve evitar humilhar a pessoa em público ou ignorar o problema por ela ser tecnicamente importante.

**Resposta fraca ou incompleta:**

“Eu conversaria com a pessoa e pediria para ela ser mais colaborativa.”

Essa orientação é vaga e não explica qual comportamento deve mudar nem como acompanhar a evolução.

**Critérios de avaliação:**

- **0** — Ignora o comportamento.
- **1** — Confronta ou expõe a pessoa publicamente.
- **2** — Dá feedback genérico e sem acompanhamento.
- **3** — Trata o assunto em particular e usa exemplos concretos.
- **4** — Explica impacto, ouve, define expectativas e acompanha.
- **5** — Demonstra firmeza, respeito, segurança psicológica e capacidade de proteger o time sem evitar conversas difíceis.

**Perguntas de aprofundamento:**

1. O que faria se a pessoa negasse o comportamento?
2. Como agiria se o comportamento continuasse?
3. Como diferenciaria uma discordância técnica saudável de um comportamento prejudicial?

---

## Pergunta 84 — Conflito técnico entre pessoas do time

**Nível:** Pleno  
**Categoria:** Colaboração e decisão

**Pergunta do entrevistador:**

Duas pessoas do time discordam fortemente sobre uma decisão de arquitetura e a discussão está afetando a entrega. Como você interviria?

**O que essa pergunta avalia:**

Avalia capacidade de transformar conflito pessoal ou técnico em uma decisão objetiva e saudável.

**Resposta esperada:**

Eu começaria entendendo se o conflito é realmente técnico ou se envolve:

- Falta de contexto;
- Objetivos diferentes;
- Histórico de relacionamento;
- Pressão de prazo;
- Divergência de responsabilidades;
- Critérios de decisão não definidos.

Depois, ajudaria a estruturar a discussão:

1. Definir o problema;
2. Registrar requisitos;
3. Identificar restrições;
4. Listar alternativas;
5. Comparar riscos, custos e benefícios;
6. Definir critérios de sucesso;
7. Estabelecer prazo para decidir;
8. Registrar a decisão.

Se necessário, proporia um experimento ou protótipo para reduzir a discussão baseada em hipóteses.

Também reforçaria regras de colaboração:

- Criticar ideias, não pessoas;
- Dar espaço para o outro falar;
- Explicitar evidências;
- Reconhecer incertezas;
- Aceitar a decisão depois que ela for tomada.

O consenso é desejável, mas nem sempre necessário. Em determinado momento, alguém precisa decidir com base nos critérios definidos.

**Explicação didática:**

Conflitos técnicos podem ser produtivos quando revelam riscos e alternativas. Tornam-se prejudiciais quando não possuem critérios, prazo ou espaço seguro para discussão.

Uma decisão não precisa provar que uma pessoa estava completamente certa e a outra errada. Pode apenas representar a melhor alternativa para o contexto atual.

**Exemplo prático:**

Se o conflito for entre uma solução síncrona e outra assíncrona, eu compararia:

- Necessidade de resposta imediata;
- Volume;
- Tolerância a atrasos;
- Complexidade;
- Reprocessamento;
- Observabilidade;
- Custo operacional;
- Impacto no usuário.

**Exemplo de código:**

Um registro simples poderia ser:

~~~markdown
## Decisão

Escolher comunicação síncrona para esta etapa porque
o usuário precisa da resposta imediatamente e o volume atual
é moderado.

## Condição de revisão

Reavaliar se o volume crescer significativamente ou se a
operação passar a exigir processamento desacoplado.
~~~

**Como o candidato deve responder:**

O candidato deve:

- Separar pessoas de ideias;
- Definir critérios;
- Ouvir os envolvidos;
- Considerar experimentos;
- Controlar o tempo da discussão;
- Registrar a decisão;
- Saber decidir quando não houver consenso;
- Preservar o respeito.

Deve evitar escolher a proposta da pessoa mais sênior automaticamente.

**Resposta fraca ou incompleta:**

“Eu escolheria a solução que considero melhor e encerraria a discussão.”

Essa postura pode ser rápida, mas não desenvolve o time nem garante que os riscos tenham sido avaliados.

**Critérios de avaliação:**

- **0** — Permite que o conflito continue sem intervenção.
- **1** — Decide por autoridade ou preferência pessoal.
- **2** — Ouve as pessoas, mas não define critérios.
- **3** — Estrutura a análise e busca uma decisão.
- **4** — Usa evidências, experimentos, documentação e prazo.
- **5** — Transforma conflitos em decisões produtivas e mantém a colaboração do time.

**Perguntas de aprofundamento:**

1. Como agiria se as duas propostas fossem tecnicamente válidas?
2. O que faria se uma das pessoas se recusasse a aceitar a decisão?
3. Como evitaria que o conflito se tornasse pessoal?

---

## Pergunta 85 — Comunicação técnica para públicos diferentes

**Nível:** Pleno  
**Categoria:** Comunicação

**Pergunta do entrevistador:**

Como você explicaria uma decisão técnica complexa para uma pessoa de produto, uma liderança executiva e uma pessoa desenvolvedora?

**O que essa pergunta avalia:**

Avalia capacidade de adaptar a comunicação sem distorcer o conteúdo e sem utilizar complexidade técnica para impedir o entendimento.

**Resposta esperada:**

Eu adaptaria a comunicação ao interesse e ao nível de decisão de cada público.

### Para produto

Eu destacaria:

- Impacto na experiência do usuário;
- Benefícios;
- Riscos;
- Prazo;
- Dependências;
- Limitações;
- Efeito sobre o roadmap.

### Para liderança executiva

Eu resumiria:

- Problema;
- Impacto no negócio;
- Opções;
- Custo;
- Risco;
- Decisão recomendada;
- Resultado esperado;
- Consequências de não agir.

### Para pessoas desenvolvedoras

Eu detalharia:

- Contexto técnico;
- Contratos;
- Trade-offs;
- Operação;
- Testes;
- Observabilidade;
- Estratégia de migração;
- Limites da decisão.

A mensagem central deve permanecer consistente, mas o nível de detalhe deve mudar.

**Explicação didática:**

Comunicação técnica eficiente não significa remover toda a complexidade. Significa apresentar a complexidade relevante para a decisão daquele público.

Uma liderança não precisa conhecer todos os detalhes de uma classe, mas precisa saber o risco, o investimento e o resultado esperado.

Uma pessoa desenvolvedora precisa de detalhes suficientes para implementar e operar a solução corretamente.

**Exemplo prático:**

Para explicar uma migração de banco:

- Para produto: “A mudança reduz o risco de indisponibilidade e prepara o crescimento da funcionalidade.”
- Para liderança: “O investimento de duas semanas reduz um risco operacional alto e evita interrupções futuras.”
- Para engenharia: “A migração será feita em etapas compatíveis, com escrita dupla temporária e validação de consistência.”

**Exemplo de código:**

Não é necessário código. O foco está na adaptação da comunicação.

**Como o candidato deve responder:**

O candidato deve:

- Conhecer o público;
- Começar pelo problema;
- Explicar impacto e trade-offs;
- Adaptar o nível de detalhe;
- Evitar jargão desnecessário;
- Ser transparente sobre incertezas;
- Manter consistência entre as mensagens.

Deve evitar utilizar termos técnicos para parecer mais autoridade ou esconder riscos.

**Resposta fraca ou incompleta:**

“Eu explicaria da mesma forma para todos, porque a decisão é a mesma.”

A decisão pode ser a mesma, mas cada público precisa compreender aspectos diferentes.

**Critérios de avaliação:**

- **0** — Não adapta a comunicação.
- **1** — Usa apenas jargão técnico.
- **2** — Simplifica excessivamente e omite riscos.
- **3** — Ajusta o nível de detalhe ao público.
- **4** — Relaciona problema, impacto, riscos e decisão.
- **5** — Demonstra comunicação clara, estratégica, transparente e eficaz para diferentes interlocutores.

**Perguntas de aprofundamento:**

1. Como explicaria uma dívida técnica sem parecer que o time está apenas reclamando?
2. Como comunicaria uma incerteza importante?
3. Como saberia se a outra pessoa realmente entendeu a decisão?

---

## Pergunta 86 — Pressão por prazo e risco técnico

**Nível:** Sênior  
**Categoria:** Gestão de risco

**Pergunta do entrevistador:**

O negócio precisa lançar uma funcionalidade rapidamente, mas o time identificou riscos técnicos importantes. Como você conduziria a decisão?

**O que essa pergunta avalia:**

Avalia capacidade de equilibrar prazo, escopo, risco e transparência sem bloquear automaticamente o negócio nem aceitar riscos ocultos.

**Resposta esperada:**

Eu tornaria o risco explícito e avaliaria:

- Qual é o impacto potencial;
- Qual é a probabilidade;
- Quais usuários serão afetados;
- Se há risco financeiro, legal ou de segurança;
- Se existe uma versão reduzida da funcionalidade;
- Se o lançamento pode ser gradual;
- Se há feature flag;
- Se existe rollback;
- Quais controles reduzem o risco;
- O que acontecerá se nada for feito.

Depois, apresentaria alternativas, por exemplo:

- Reduzir o escopo;
- Liberar para um grupo pequeno;
- Adiar uma parte não essencial;
- Criar uma mitigação temporária;
- Executar manualmente uma etapa;
- Adicionar monitoramento;
- Criar um limite de uso;
- Lançar depois de uma validação adicional.

Se o risco fosse inaceitável, especialmente em segurança, privacidade ou integridade financeira, eu recomendaria não liberar naquela condição.

A decisão deve ser tomada pelas pessoas responsáveis pelo risco, com informações claras. O Tech Lead não deve esconder o risco nem assumir sozinho uma decisão que pertence ao negócio.

**Explicação didática:**

Velocidade não significa ignorar riscos. Muitas vezes é possível entregar valor mais rapidamente reduzindo escopo e mantendo controles importantes.

A pergunta correta não é apenas:

> “Podemos entregar até sexta-feira?”

Também é:

> “Qual versão podemos entregar com segurança até sexta-feira?”

**Exemplo prático:**

Em vez de lançar uma nova modalidade de pagamento para todos os usuários, o time pode:

1. Liberar para funcionários;
2. Limitar o valor das transações;
3. Monitorar falhas;
4. Manter o fluxo anterior;
5. Expandir gradualmente.

**Exemplo de código:**

Uma feature flag pode controlar uma liberação gradual:

~~~java
if (featureFlagService.estaAtiva(
        "novo-pagamento", usuario.id())) {

    return novoFluxoPagamento.processar(pedido);
}

return fluxoPagamentoAtual.processar(pedido);
~~~

A flag não substitui testes, monitoramento ou plano de desativação.

**Como o candidato deve responder:**

O candidato deve:

- Tornar os riscos explícitos;
- Diferenciar risco aceitável e inaceitável;
- Propor redução de escopo;
- Utilizar rollout gradual;
- Considerar rollback e observabilidade;
- Envolver os responsáveis pela decisão;
- Evitar prometer velocidade sem transparência.

Deve evitar tanto bloquear qualquer entrega quanto aceitar riscos críticos para cumprir uma data.

**Resposta fraca ou incompleta:**

“Eu explicaria o risco e deixaria o Product Manager decidir.”

A transparência é necessária, mas o Tech Lead também deve apresentar alternativas e recomendações técnicas.

**Critérios de avaliação:**

- **0** — Oculta ou ignora os riscos.
- **1** — Bloqueia a entrega sem analisar alternativas.
- **2** — Comunica o risco, mas não propõe mitigação.
- **3** — Avalia impacto e apresenta opções.
- **4** — Inclui escopo reduzido, flags, rollout e critérios de segurança.
- **5** — Demonstra julgamento equilibrado, transparência e capacidade de proteger o produto sem impedir valor desnecessariamente.

**Perguntas de aprofundamento:**

1. Que tipos de risco você consideraria inaceitáveis?
2. Como comunicaria um risco para uma liderança não técnica?
3. O que faria se a liderança decidisse aceitar o risco?

---

## Pergunta 87 — Decisão ética envolvendo dados ou segurança

**Nível:** Sênior  
**Categoria:** Ética e responsabilidade profissional

**Pergunta do entrevistador:**

O que você faria se percebesse que uma decisão técnica poderia expor dados de clientes, mas a organização quisesse seguir rapidamente para cumprir uma meta?

**O que essa pergunta avalia:**

Avalia responsabilidade profissional, capacidade de escalar riscos e disposição para proteger usuários mesmo sob pressão.

**Resposta esperada:**

Eu confirmaria os fatos e documentaria:

- Quais dados podem ser expostos;
- Quem poderia acessá-los;
- Qual é a probabilidade;
- Qual é o impacto;
- Qual é a causa;
- Quais controles estão ausentes;
- Quais alternativas existem;
- Qual é o custo de corrigir;
- Qual é o custo de seguir sem correção.

Comunicaria o risco de forma clara às pessoas responsáveis por segurança, privacidade, produto e liderança. Não apresentaria o problema como uma preferência técnica, mas como um risco concreto para clientes e para a organização.

Proporia alternativas, como:

- Reduzir os dados coletados;
- Mascarar informações;
- Restringir o acesso;
- Adiar a parte perigosa;
- Criar uma mitigação;
- Liberar apenas para um grupo controlado;
- Corrigir antes do lançamento.

Se a exposição fosse grave e não houvesse mitigação aceitável, eu recomendaria não liberar a funcionalidade. Também seguiria os canais formais de escalonamento e as políticas internas.

Não esconderia o problema, não alteraria evidências e não compartilharia dados sensíveis fora dos canais apropriados.

**Explicação didática:**

Riscos de segurança e privacidade não devem ser tratados como uma simples dívida técnica. Uma decisão errada pode afetar pessoas reais, gerar prejuízo financeiro e causar consequências legais ou reputacionais.

O papel técnico inclui comunicar riscos, mas a responsabilidade não termina quando o alerta é feito. É necessário buscar uma decisão consciente e documentada.

**Exemplo prático:**

Se uma nova API retorna informações completas de clientes para facilitar o desenvolvimento, eu recomendaria:

- Retornar apenas os campos necessários;
- Aplicar autorização por recurso;
- Mascarar dados;
- Remover informações de ambientes de teste;
- Adicionar testes de exposição indevida;
- Auditar acessos.

**Exemplo de código:**

Uma resposta limitada reduz exposição desnecessária:

~~~java
public record ClienteResumoResponse(
        Long id,
        String nome,
        String emailMascarado
) {
}
~~~

O DTO não deve retornar automaticamente todos os campos armazenados na entidade.

**Como o candidato deve responder:**

O candidato deve:

- Confirmar e documentar o risco;
- Comunicar às áreas responsáveis;
- Propor mitigação;
- Considerar impacto para usuários;
- Escalar quando necessário;
- Recusar uma liberação claramente insegura;
- Seguir políticas e canais formais.

Deve evitar aceitar exposição de dados apenas porque o prazo é curto.

**Resposta fraca ou incompleta:**

“Eu avisaria que existe um risco, mas seguiria a decisão da empresa.”

Essa resposta não demonstra responsabilidade suficiente diante de um risco grave para usuários.

**Critérios de avaliação:**

- **0** — Ignora ou esconde o risco.
- **1** — Aceita a exposição para cumprir o prazo.
- **2** — Comunica o problema, mas não propõe proteção.
- **3** — Documenta, comunica e busca mitigação.
- **4** — Envolve segurança e privacidade e define critérios de liberação.
- **5** — Demonstra postura ética, responsabilidade profissional e disposição para escalar riscos críticos de forma adequada.

**Perguntas de aprofundamento:**

1. Como diferenciaria um risco aceitável de uma violação grave?
2. O que faria se sua liderança pedisse para não registrar o risco?
3. Como protegeria as pessoas que reportaram o problema?

---

## Pergunta 88 — Construção de segurança psicológica

**Nível:** Sênior  
**Categoria:** Cultura de equipe

**Pergunta do entrevistador:**

Como você criaria um ambiente em que as pessoas se sintam seguras para levantar riscos, admitir erros e discordar tecnicamente?

**O que essa pergunta avalia:**

Avalia liderança, maturidade emocional, capacidade de criar confiança e qualidade do ambiente de trabalho.

**Resposta esperada:**

Eu procuraria criar segurança psicológica por meio de comportamentos consistentes:

- Ouvir sem interromper;
- Agradecer quem aponta riscos;
- Separar erro de negligência intencional;
- Evitar humilhação pública;
- Fazer perguntas antes de julgar;
- Admitir minhas próprias incertezas;
- Incentivar opiniões divergentes;
- Registrar decisões e seus contextos;
- Conduzir post-mortems sem culpabilização;
- Garantir que pessoas menos experientes tenham espaço;
- Agir quando houver comportamentos desrespeitosos.

Também verificaria se a cultura declarada corresponde à prática. Não adianta dizer que erros são oportunidades de aprendizado e punir a primeira pessoa que reporta um problema.

Segurança psicológica não significa ausência de cobrança. O time ainda precisa cumprir compromissos, corrigir falhas e assumir responsabilidades. A diferença é que os problemas são tratados com transparência e foco em melhoria.

**Explicação didática:**

Quando as pessoas têm medo de falar, os riscos não desaparecem. Eles apenas aparecem mais tarde, normalmente quando o custo de correção é maior.

Um time saudável permite frases como:

- “Não entendi essa decisão.”
- “Acho que existe um risco.”
- “Cometi um erro.”
- “Preciso de ajuda.”
- “Discordo por causa destes dados.”
- “Não temos evidência suficiente.”

**Exemplo prático:**

Durante uma revisão, uma pessoa júnior aponta que um fluxo pode permitir acesso indevido. O Tech Lead deve explorar a observação, mesmo que ela interrompa o cronograma, porque o risco pode ser relevante.

**Exemplo de código:**

Não é necessário código. O foco está na cultura e nos comportamentos de liderança.

**Como o candidato deve responder:**

O candidato deve:

- Incentivar transparência;
- Valorizar a comunicação de riscos;
- Evitar culpabilização;
- Admitir vulnerabilidade;
- Proteger a participação de pessoas menos experientes;
- Diferenciar responsabilidade de punição;
- Agir contra desrespeito;
- Promover discordância baseada em evidências.

Deve evitar confundir segurança psicológica com permitir baixo desempenho ou ausência de responsabilidade.

**Resposta fraca ou incompleta:**

“Eu diria ao time que todos podem falar e faria reuniões de feedback.”

A declaração é positiva, mas não descreve comportamentos concretos nem como reagir quando alguém realmente apontar um problema.

**Critérios de avaliação:**

- **0** — Incentiva medo ou culpabilização.
- **1** — Pede transparência, mas pune erros abertamente.
- **2** — Cria espaços de conversa, mas não muda comportamentos.
- **3** — Promove escuta, respeito e post-mortems.
- **4** — Valoriza riscos, diversidade de opiniões e aprendizado.
- **5** — Demonstra liderança consistente, responsabilidade sem culpa e capacidade de criar um ambiente realmente seguro para colaboração.

**Perguntas de aprofundamento:**

1. Como reagiria se alguém reportasse um erro grave?
2. Como lidaria com uma pessoa que ridiculariza perguntas?
3. Como mediria a segurança psicológica do time?

---

## Pergunta 89 — Evolução da maturidade do time

**Nível:** Sênior  
**Categoria:** Desenvolvimento organizacional

**Pergunta do entrevistador:**

Como você avaliaria a maturidade de um time técnico e definiria quais práticas deveriam ser desenvolvidas primeiro?

**O que essa pergunta avalia:**

Avalia capacidade de diagnosticar a situação do time, priorizar melhorias e evitar aplicar práticas sem considerar o contexto.

**Resposta esperada:**

Eu avaliaria diferentes dimensões:

- Clareza de objetivos;
- Capacidade de planejar;
- Qualidade dos requisitos;
- Autonomia;
- Distribuição de conhecimento;
- Qualidade dos testes;
- Frequência e segurança dos deploys;
- Observabilidade;
- Resposta a incidentes;
- Comunicação;
- Colaboração;
- Capacidade de aprendizado;
- Relação com produto;
- Gestão de riscos.

Não utilizaria uma avaliação apenas para classificar pessoas. O objetivo seria identificar obstáculos do sistema de trabalho.

Depois, priorizaria poucas melhorias de alto impacto. Por exemplo:

- Se o time sofre com incidentes, começar por observabilidade e rollback;
- Se fica bloqueado por dependências, trabalhar contratos e planejamento;
- Se tem medo de alterar o código, criar testes de caracterização;
- Se há concentração de conhecimento, promover pareamento e ownership distribuído;
- Se entrega sem clareza, melhorar critérios de aceitação.

A evolução deveria possuir metas observáveis e ser revisada periodicamente.

**Explicação didática:**

Maturidade não é utilizar o maior número de ferramentas ou cerimônias. É conseguir entregar com clareza, qualidade, autonomia e capacidade de aprender.

Um time pode ser muito bom tecnicamente e ainda precisar melhorar comunicação. Outro pode ter processos bem definidos, mas baixa capacidade de diagnosticar problemas em produção.

A evolução deve partir dos problemas reais.

**Exemplo prático:**

Se o time possui muitos incidentes após deploy, eu não começaria obrigatoriamente por uma nova arquitetura. Poderia priorizar:

1. Métricas de falha após mudança;
2. Testes nos fluxos críticos;
3. Feature flags;
4. Rollback documentado;
5. Liberação gradual;
6. Revisão dos incidentes.

**Exemplo de código:**

Uma matriz simples de evolução poderia ser:

~~~yaml
capacidades:
  observabilidade:
    situacao_atual: "logs básicos"
    próximo_objetivo: "métricas de erro e latência"
    indicador: "dashboards dos fluxos críticos"

  entrega:
    situacao_atual: "deploy manual"
    próximo_objetivo: "deploy rastreável"
    indicador: "percentual de releases automatizadas"

  conhecimento:
    situacao_atual: "concentrado em duas pessoas"
    próximo_objetivo: "ownership distribuído"
    indicador: "quantidade de áreas com mais de uma pessoa habilitada"
~~~

**Como o candidato deve responder:**

O candidato deve:

- Avaliar o sistema de trabalho;
- Considerar pessoas, processo e tecnologia;
- Priorizar poucas melhorias;
- Basear-se em evidências;
- Definir indicadores;
- Adaptar a abordagem ao contexto;
- Evitar aplicar modelos prontos indiscriminadamente.

Deve evitar medir maturidade apenas pela quantidade de ferramentas, cerimônias ou documentos.

**Resposta fraca ou incompleta:**

“Eu verificaria se o time utiliza boas práticas como Scrum, testes e CI/CD.”

A resposta lista práticas, mas não explica como identificar necessidades ou priorizar melhorias.

**Critérios de avaliação:**

- **0** — Não sabe avaliar maturidade.
- **1** — Usa apenas uma lista fixa de práticas.
- **2** — Avalia ferramentas, mas ignora pessoas e resultados.
- **3** — Considera qualidade, entrega e colaboração.
- **4** — Prioriza com base em problemas, evidências e indicadores.
- **5** — Demonstra visão sistêmica de evolução organizacional e capacidade de melhorar o time sem impor burocracia.

**Perguntas de aprofundamento:**

1. Como evitaria comparar times de contextos diferentes?
2. Como escolheria a primeira melhoria?
3. O que faria se uma prática adotada não trouxesse resultado?

---

## Pergunta 90 — O papel do Tech Lead em uma decisão difícil

**Nível:** Sênior  
**Categoria:** Liderança e julgamento

**Pergunta do entrevistador:**

Conte como você agiria em uma situação em que nenhuma alternativa técnica fosse ideal e todas apresentassem riscos relevantes.

**O que essa pergunta avalia:**

Avalia julgamento, responsabilidade, transparência, capacidade de decidir sob incerteza e maturidade para lidar com trade-offs.

**Resposta esperada:**

Eu começaria evitando a falsa expectativa de encontrar uma alternativa sem riscos. Estruturaria a decisão com:

- Problema;
- Objetivo;
- Restrições;
- Alternativas;
- Riscos;
- Probabilidade;
- Impacto;
- Custo;
- Prazo;
- Reversibilidade;
- Dependências;
- Critérios de sucesso;
- Plano de mitigação.

Também verificaria se o problema pode ser reduzido por uma entrega menor ou por uma mudança incremental.

A decisão deveria ser tomada pelas pessoas responsáveis pelo risco, com participação técnica adequada. Eu registraria:

- O que foi decidido;
- Por que foi decidido;
- Quais riscos foram aceitos;
- Quais controles existem;
- Quando revisar;
- Quem acompanhará os indicadores.

Depois da decisão, eu ajudaria a executar, monitorar e revisar a escolha. Se os sinais mostrassem que o risco está se materializando, recomendaria mudar de direção.

O papel do Tech Lead não é garantir que todas as decisões sejam perfeitas. É melhorar a qualidade da decisão, tornar os riscos visíveis e criar mecanismos de aprendizado e recuperação.

**Explicação didática:**

Decisões reais frequentemente envolvem informação incompleta. O problema não é existir risco; o problema é assumir risco sem conhecê-lo ou sem preparar uma resposta.

Uma decisão madura pode dizer:

> “Esta opção possui o menor risco considerando o prazo atual, será liberada gradualmente, terá monitoramento específico e será revisada quando determinados indicadores mudarem.”

**Exemplo prático:**

Se uma integração antiga é instável, mas uma migração completa demoraria meses, o time pode:

1. Criar um adaptador;
2. Adicionar timeout e métricas;
3. Implementar retry controlado;
4. Isolar a dependência;
5. Criar uma nova integração em paralelo;
6. Migrar gradualmente;
7. Remover o legado depois.

**Exemplo de código:**

Uma decisão com revisão definida poderia ser registrada assim:

~~~markdown
# Decisão — Manter integração atual durante a transição

## Motivo
A substituição completa não é viável no prazo do produto.

## Mitigações
- Timeout explícito;
- Circuit breaker;
- Monitoramento de erros;
- Reconciliação diária;
- Limite de volume;
- Processo de reprocessamento.

## Condição de revisão
Iniciar a migração definitiva quando a taxa de falha
ultrapassar o limite acordado ou quando o novo contrato
estiver disponível.

## Responsável pelo acompanhamento
Time de pedidos.
~~~

**Como o candidato deve responder:**

O candidato deve:

- Reconhecer a incerteza;
- Estruturar riscos;
- Comparar alternativas;
- Propor mitigação;
- Considerar reversibilidade;
- Envolver os responsáveis pela decisão;
- Documentar o contexto;
- Definir critérios de revisão;
- Acompanhar os resultados.

Deve evitar afirmar que sempre existe uma solução tecnicamente perfeita ou tomar uma decisão irreversível sem análise.

**Resposta fraca ou incompleta:**

“Eu escolheria a alternativa mais segura e seguiria em frente.”

A resposta não define como medir segurança, tratar riscos residuais ou revisar a decisão.

**Critérios de avaliação:**

- **0** — Decide sem analisar riscos.
- **1** — Procura uma solução perfeita inexistente.
- **2** — Compara alternativas, mas não define mitigação.
- **3** — Estrutura riscos e recomenda uma decisão.
- **4** — Inclui mitigação, monitoramento, documentação e revisão.
- **5** — Demonstra julgamento técnico e organizacional, transparência, responsabilidade e capacidade de decidir sob incerteza.

**Perguntas de aprofundamento:**

1. Como comunicaria que não existe uma alternativa sem risco?
2. Como saberia que a decisão precisa ser revertida?
3. Como evitaria que uma decisão temporária se tornasse permanente?

---

# Resumo desta parte

| Item | Resultado |
|---|---|
| Perguntas apresentadas | 81 a 90 |
| Níveis abordados | Pleno e Sênior |
| Temas principais | Delegação, mentoria, feedback, conflitos, comunicação, pressão por prazo, ética, segurança psicológica, maturidade do time e decisão sob incerteza |
| Perguntas restantes | 10 |

## Competências exploradas

- Delegação de responsabilidades;
- Desenvolvimento de autonomia;
- Mentoria de pessoas juniores;
- Feedback construtivo;
- Tratamento de comportamentos prejudiciais;
- Mediação de conflitos técnicos;
- Comunicação adaptada ao público;
- Gestão de prazo e risco;
- Transparência em decisões;
- Ética profissional;
- Proteção de dados e segurança;
- Segurança psicológica;
- Evolução da maturidade do time;
- Priorização de melhorias;
- Julgamento técnico;
- Decisão com informação incompleta;
- Mitigação e reversibilidade;
- Liderança responsável.

---

# Roteiro Completo de Entrevista — Tech Lead de um Time Java

## Parte 10 de 10 — Perguntas 91 a 100

**Foco desta parte:** visão sistêmica, cenários reais de liderança, estratégia, priorização, governança, evolução profissional e avaliação final para a posição de Tech Lead.

> As perguntas consideram um Tech Lead responsável por conectar produto, engenharia, pessoas, arquitetura, operação e resultados do negócio.

## Fluxo de atuação do Tech Lead

~~~mermaid
flowchart TD
    A[Objetivo do produto] --> B[Entendimento do problema]
    B --> C[Análise técnica e de negócio]
    C --> D[Alinhamento com as pessoas]
    D --> E[Decisão e planejamento]
    E --> F[Execução incremental]
    F --> G[Entrega e operação]
    G --> H[Medição dos resultados]
    H --> I[Aprendizado]
    I --> B

    J[Conflitos] --> D
    K[Riscos] --> C
    L[Desenvolvimento do time] --> D
    M[Melhoria contínua] --> I
~~~

---

## Pergunta 91 — Primeiros 90 dias como Tech Lead

**Nível:** Sênior  
**Categoria:** Liderança e diagnóstico

**Pergunta do entrevistador:**

Você assumiu a posição de Tech Lead em um time novo. O que faria nos primeiros 90 dias?

**O que essa pergunta avalia:**

Avalia capacidade de observar antes de alterar, construir relacionamentos, entender o produto e identificar prioridades de forma estruturada.

**Resposta esperada:**

Eu dividiria os primeiros meses em três objetivos: entender, alinhar e agir.

### Primeiro período: entender

Eu buscaria compreender:

- Objetivos do produto;
- Usuários;
- Principais fluxos de negócio;
- Arquitetura;
- Processo de entrega;
- Incidentes;
- Qualidade dos testes;
- Observabilidade;
- Dependências;
- Distribuição de conhecimento;
- Dificuldades do time;
- Expectativas da liderança.

Também conversaria individualmente com as pessoas do time, Product Manager, operações, segurança e outros parceiros importantes.

### Segundo período: alinhar

Eu ajudaria a tornar claros:

- Objetivos do time;
- Responsabilidades;
- Critérios de decisão;
- Riscos prioritários;
- Forma de comunicação;
- Expectativas sobre qualidade;
- Necessidades de desenvolvimento das pessoas.

Evitaria chegar impondo uma arquitetura ou processo antes de entender o contexto.

### Terceiro período: agir

Escolheria poucas melhorias de alto impacto, como:

- Corrigir um risco crítico;
- Melhorar a observabilidade de um fluxo importante;
- Reduzir um gargalo do pipeline;
- Distribuir conhecimento;
- Estabelecer uma prática de decisão;
- Melhorar a previsibilidade de uma entrega.

Definiria indicadores para verificar se as ações produziram resultado.

**Explicação didática:**

Um novo Tech Lead precisa conquistar confiança e contexto. Alterações rápidas podem parecer iniciativa, mas também podem criar resistência ou resolver problemas que não eram prioritários.

Os primeiros 90 dias não devem ser um período de inatividade. O objetivo é equilibrar escuta, diagnóstico e melhorias concretas.

**Exemplo prático:**

Se o time possui muitos incidentes após deploy, eu poderia priorizar:

1. Identificar os fluxos mais críticos;
2. Criar métricas de erro;
3. Melhorar o processo de rollback;
4. Adicionar testes de regressão;
5. Distribuir o conhecimento sobre incidentes;
6. Medir a redução de falhas.

**Exemplo de código:**

Não é necessário código. A questão avalia diagnóstico, liderança e priorização.

**Como o candidato deve responder:**

O candidato deve:

- Começar entendendo o contexto;
- Conversar com o time e parceiros;
- Avaliar produto, arquitetura e operação;
- Identificar riscos;
- Escolher poucas prioridades;
- Definir métricas;
- Evitar mudanças baseadas em preferências pessoais.

**Resposta fraca ou incompleta:**

“Eu revisaria todo o código, proporia uma nova arquitetura e estabeleceria um novo processo de desenvolvimento.”

Essa resposta age antes de entender o problema e pode gerar mudanças de alto custo sem benefício comprovado.

**Critérios de avaliação:**

- **0** — Não apresenta estratégia.
- **1** — Impõe mudanças imediatamente.
- **2** — Observa o time, mas não define ações.
- **3** — Faz diagnóstico e escolhe melhorias iniciais.
- **4** — Considera produto, pessoas, tecnologia, operação e métricas.
- **5** — Demonstra entrada estruturada, construção de confiança e capacidade de gerar valor sem precipitação.

**Perguntas de aprofundamento:**

1. Como escolheria a primeira melhoria?
2. O que faria se a liderança esperasse mudanças imediatas?
3. Como avaliaria se ganhou a confiança do time?

---

## Pergunta 92 — Priorização entre funcionalidade e dívida técnica

**Nível:** Sênior  
**Categoria:** Priorização e estratégia

**Pergunta do entrevistador:**

Como você decidiria quanto tempo o time deve dedicar a novas funcionalidades, dívida técnica, segurança e confiabilidade?

**O que essa pergunta avalia:**

Avalia capacidade de priorizar investimentos técnicos sem tratar todas as demandas como igualmente urgentes.

**Resposta esperada:**

Eu evitaria definir uma divisão fixa sem considerar o contexto. Primeiro avaliaria:

- Impacto no cliente;
- Risco operacional;
- Risco de segurança;
- Custo de manutenção;
- Frequência de alteração;
- Incidentes;
- Bloqueios para o roadmap;
- Custo de não agir;
- Esforço;
- Reversibilidade;
- Dependências;
- Obrigações legais ou regulatórias.

Dívida técnica não deve ser tratada apenas como uma tarefa de melhoria estética. Ela merece prioridade quando:

- Aumenta incidentes;
- Impede novas funcionalidades;
- Reduz a velocidade de entrega;
- Cria risco de segurança;
- Aumenta custos;
- Concentra conhecimento;
- Dificulta recuperação;
- Pode causar perda ou corrupção de dados.

Eu buscaria incorporar melhorias técnicas às entregas de produto sempre que possível e reservaria capacidade explícita para riscos estruturais.

A decisão deveria ser discutida com produto e liderança, apresentando consequências claras de adiar cada item.

**Explicação didática:**

A pergunta não é simplesmente “quanto tempo para dívida técnica?”. A questão principal é:

> “Quais riscos técnicos estão limitando o produto e qual é o custo de não corrigi-los?”

Uma melhoria técnica pode ser priorizada porque permite lançar uma funcionalidade importante, reduz incidentes ou protege dados.

**Exemplo prático:**

Se uma nova funcionalidade exige alterar um módulo instável, o time pode incluir:

- Testes de caracterização;
- Melhor isolamento;
- Métricas;
- Refatoração localizada;
- Tratamento de falhas.

Assim, parte da dívida é reduzida enquanto o valor do produto é entregue.

**Exemplo de código:**

Não é necessário código. O tema envolve priorização e comunicação de riscos.

**Como o candidato deve responder:**

O candidato deve:

- Relacionar dívida técnica a impacto;
- Considerar segurança e confiabilidade;
- Comparar custo de agir e não agir;
- Envolver produto;
- Evitar percentuais arbitrários;
- Integrar melhorias às entregas;
- Definir prioridades e métricas.

**Resposta fraca ou incompleta:**

“Eu reservaria 20% de cada sprint para dívida técnica.”

Uma proporção pode ser útil como ponto de partida, mas não substitui a avaliação de risco e impacto.

**Critérios de avaliação:**

- **0** — Ignora dívida técnica ou prioriza tudo igualmente.
- **1** — Usa apenas uma divisão fixa de tempo.
- **2** — Considera esforço, mas não impacto.
- **3** — Avalia risco e relação com o produto.
- **4** — Considera segurança, incidentes, dependências e custo de não agir.
- **5** — Demonstra priorização baseada em evidências e capacidade de conectar investimentos técnicos aos objetivos do negócio.

**Perguntas de aprofundamento:**

1. Como explicaria o impacto da dívida técnica para o negócio?
2. O que faria se o time quisesse corrigir tudo ao mesmo tempo?
3. Quando uma dívida técnica poderia ser aceita?

---

## Pergunta 93 — Falha de comunicação em uma entrega crítica

**Nível:** Sênior  
**Categoria:** Comunicação e responsabilidade

**Pergunta do entrevistador:**

Uma entrega crítica atrasou porque informações importantes não foram comunicadas entre produto, engenharia e operações. Como você analisaria e corrigiria o problema?

**O que essa pergunta avalia:**

Avalia capacidade de identificar falhas de comunicação como problemas sistêmicos, sem reduzir a análise à culpa individual.

**Resposta esperada:**

Eu começaria reconstruindo a linha do tempo:

- Qual informação existia;
- Quem precisava recebê-la;
- Quando ela foi produzida;
- Em qual canal foi comunicada;
- Se foi compreendida;
- Qual decisão dependia dela;
- Em que momento o atraso foi percebido.

Depois, verificaria se o problema foi causado por:

- Responsabilidades indefinidas;
- Canais inadequados;
- Informações espalhadas;
- Requisitos ambíguos;
- Dependências não registradas;
- Falta de cerimônia adequada;
- Ausência de critérios de escalonamento;
- Excesso de reuniões sem registro;
- Falta de visibilidade do risco.

As correções poderiam incluir:

- Definir responsáveis;
- Registrar decisões;
- Criar um plano de comunicação;
- Utilizar um documento único para a release;
- Estabelecer pontos de sincronização;
- Criar critérios de escalonamento;
- Antecipar a validação com operações;
- Tornar dependências visíveis;
- Revisar o processo após a entrega.

Eu evitaria simplesmente aumentar a quantidade de reuniões. O objetivo é melhorar a qualidade, o momento e a responsabilidade pela comunicação.

**Explicação didática:**

Comunicação não significa apenas enviar mensagens. É necessário garantir que a informação:

- Chegue às pessoas certas;
- Seja compreendida;
- Gere uma decisão;
- Fique registrada;
- Seja atualizada quando o contexto mudar.

**Exemplo prático:**

Para uma release crítica, eu registraria:

~~~text
Objetivo da release:
Alterações:
Riscos:
Dependências:
Responsáveis:
Critérios de promoção:
Critérios de interrupção:
Plano de rollback:
Canal de acompanhamento:
Periodicidade de atualização:
~~~

**Exemplo de código:**

Não é necessário código. A questão avalia colaboração e gestão de informação.

**Como o candidato deve responder:**

O candidato deve:

- Reconstruir os fatos;
- Identificar falhas no fluxo de informação;
- Definir responsáveis;
- Melhorar registros e critérios;
- Evitar culpabilização;
- Reduzir dependências implícitas;
- Evitar resolver tudo com mais reuniões.

**Resposta fraca ou incompleta:**

“Eu reforçaria que as pessoas precisam se comunicar melhor.”

Essa orientação é genérica e não cria mecanismos para melhorar a comunicação.

**Critérios de avaliação:**

- **0** — Culpa pessoas sem investigar.
- **1** — Apenas pede mais comunicação.
- **2** — Identifica o atraso, mas não a causa sistêmica.
- **3** — Define responsáveis e registros.
- **4** — Inclui fluxo de comunicação, riscos, dependências e critérios.
- **5** — Demonstra capacidade de melhorar a comunicação organizacional de forma prática e mensurável.

**Perguntas de aprofundamento:**

1. Como saberia se uma comunicação foi realmente compreendida?
2. Que informações deveriam ser registradas em uma release?
3. O que faria se as pessoas não atualizassem os registros?

---

## Pergunta 94 — Reorganização de um time com baixo desempenho

**Nível:** Sênior  
**Categoria:** Liderança e desempenho

**Pergunta do entrevistador:**

Você assumiu um time que entrega pouco, possui muitos conflitos e apresenta baixa previsibilidade. Como investigaria a situação e iniciaria a recuperação?

**O que essa pergunta avalia:**

Avalia capacidade de diferenciar problemas de pessoas, processo, contexto, produto e estrutura organizacional.

**Resposta esperada:**

Eu evitaria concluir imediatamente que o problema é falta de esforço. Investigaria:

- Clareza dos objetivos;
- Qualidade dos requisitos;
- Volume de trabalho;
- Interrupções;
- Dependências externas;
- Distribuição de conhecimento;
- Conflitos;
- Segurança psicológica;
- Qualidade técnica;
- Incidentes;
- Falta de acesso ou ferramentas;
- Expectativas incompatíveis;
- Capacidade real do time.

Conversaria individualmente com as pessoas e analisaria dados do fluxo, sem usar métricas para punir.

Depois, escolheria poucas ações, como:

- Reduzir trabalho em andamento;
- Tornar prioridades explícitas;
- Remover dependências;
- Melhorar critérios de aceite;
- Definir ownership;
- Mediar conflitos;
- Criar apoio técnico;
- Investir em testes;
- Melhorar o planejamento;
- Ajustar expectativas com a liderança.

Se existissem problemas persistentes de comportamento ou desempenho individual, trataria-os de forma específica, privada e com acompanhamento. Não atribuiria todo o problema ao indivíduo antes de corrigir obstáculos sistêmicos.

**Explicação didática:**

Baixo desempenho pode ser resultado de:

- Prioridades conflitantes;
- Escopo instável;
- Dependências;
- Falta de contexto;
- Excesso de interrupções;
- Medo de errar;
- Arquitetura difícil de alterar;
- Falta de competências;
- Conflitos não tratados;
- Objetivos irreais.

A liderança deve criar condições para que as pessoas tenham sucesso, além de tratar responsabilidades individuais quando necessário.

**Exemplo prático:**

Se o time inicia muitas tarefas e termina poucas, eu poderia:

1. Limitar o trabalho em andamento;
2. Identificar bloqueios;
3. Priorizar a conclusão;
4. Reduzir interrupções;
5. Acompanhar o tempo de ciclo;
6. Revisar a melhora após algumas semanas.

**Exemplo de código:**

Não é necessário código. A situação envolve liderança e diagnóstico organizacional.

**Como o candidato deve responder:**

O candidato deve:

- Investigar antes de julgar;
- Conversar com as pessoas;
- Analisar o sistema de trabalho;
- Usar dados com responsabilidade;
- Tratar conflitos;
- Corrigir obstáculos;
- Definir ações pequenas e mensuráveis;
- Diferenciar problemas sistêmicos e individuais.

**Resposta fraca ou incompleta:**

“Eu substituiria as pessoas que não estão entregando.”

Essa resposta não investiga contexto, liderança, prioridades, dependências ou capacidade.

**Critérios de avaliação:**

- **0** — Culpa o time imediatamente.
- **1** — Propõe substituir pessoas sem diagnóstico.
- **2** — Analisa apenas produtividade.
- **3** — Investiga processo, prioridades e conflitos.
- **4** — Considera contexto, métricas, segurança psicológica e desenvolvimento.
- **5** — Demonstra capacidade de recuperar um time com equilíbrio entre responsabilidade, suporte e melhoria sistêmica.

**Perguntas de aprofundamento:**

1. Como agiria se uma pessoa apresentasse baixo desempenho persistente?
2. Como diferenciaria falta de capacidade de falta de clareza?
3. Como demonstraria à liderança que o problema possui causas sistêmicas?

---

## Pergunta 95 — Decisão sobre uma tecnologia nova

**Nível:** Sênior  
**Categoria:** Estratégia tecnológica

**Pergunta do entrevistador:**

Como você avaliaria a adoção de uma nova tecnologia, framework ou ferramenta para um produto Java?

**O que essa pergunta avalia:**

Avalia capacidade de evitar adoção por moda e analisar valor, risco, custo e capacidade de sustentação.

**Resposta esperada:**

Eu começaria pelo problema que a tecnologia pretende resolver. Avaliaria:

- Benefício esperado;
- Alternativas existentes;
- Compatibilidade com a arquitetura;
- Maturidade;
- Comunidade;
- Segurança;
- Licenciamento;
- Suporte;
- Custo de operação;
- Curva de aprendizado;
- Capacidade do time;
- Integração com ferramentas existentes;
- Estratégia de migração;
- Facilidade de rollback;
- Impacto no roadmap.

Quando a incerteza fosse alta, faria um experimento limitado, com critérios claros de sucesso e de abandono.

Também verificaria se a tecnologia adiciona uma dependência difícil de substituir. Uma solução pode parecer simples no início e gerar alto custo de manutenção depois.

Eu registraria a decisão e evitaria que um experimento fosse confundido com um padrão obrigatório.

**Explicação didática:**

A pergunta correta não é:

> “Essa tecnologia é moderna?”

É:

> “Ela resolve um problema relevante melhor do que as alternativas, considerando nosso contexto?”

A adoção deve considerar o ciclo completo: desenvolvimento, testes, deploy, observabilidade, segurança, manutenção e suporte.

**Exemplo prático:**

Antes de adotar uma nova ferramenta de mensageria, eu avaliaria:

- Volume;
- Garantias de entrega;
- Reprocessamento;
- Observabilidade;
- Operação;
- Custos;
- Conhecimento do time;
- Integração com sistemas existentes;
- Estratégia em caso de indisponibilidade.

**Exemplo de código:**

Um experimento poderia possuir critérios assim:

~~~yaml
technology-evaluation:
  problem: "reduzir o tempo de processamento assíncrono"
  hypothesis: "a nova solução suportará o volume com menor custo operacional"
  success-criteria:
    - "processar 10000 eventos por minuto"
    - "manter taxa de erro abaixo de 0.5%"
    - "permitir reprocessamento"
    - "possuir métricas operacionais"
  abandonment-criteria:
    - "custo acima do limite"
    - "falhas sem recuperação"
    - "complexidade incompatível com o time"
~~~

**Como o candidato deve responder:**

O candidato deve:

- Começar pelo problema;
- Comparar alternativas;
- Considerar custo total;
- Avaliar maturidade e segurança;
- Propor experimento;
- Definir critérios;
- Considerar operação e manutenção;
- Evitar adotar tecnologia por tendência.

**Resposta fraca ou incompleta:**

“Eu testaria a tecnologia em um projeto pequeno e, se gostasse, adotaria.”

A resposta não define problema, critérios de sucesso, custo ou risco.

**Critérios de avaliação:**

- **0** — Escolhe por moda ou preferência.
- **1** — Considera apenas desempenho.
- **2** — Faz um teste sem critérios objetivos.
- **3** — Compara benefícios e custos básicos.
- **4** — Considera operação, segurança, equipe e reversibilidade.
- **5** — Demonstra avaliação tecnológica completa e orientada a evidências.

**Perguntas de aprofundamento:**

1. Como evitaria que um experimento virasse uma dependência permanente?
2. Quando uma tecnologia madura seria preferível a uma mais nova?
3. Como apresentaria o custo de adoção para a liderança?

---

## Pergunta 96 — Responsabilidade por uma decisão equivocada

**Nível:** Sênior  
**Categoria:** Responsabilidade e aprendizado

**Pergunta do entrevistador:**

Conte como você reagiria ao perceber que uma decisão técnica defendida por você foi equivocada e causou impacto no produto.

**O que essa pergunta avalia:**

Avalia humildade, responsabilidade, transparência e capacidade de transformar erros em aprendizado.

**Resposta esperada:**

Eu assumiria a responsabilidade pela decisão, comunicaria o impacto e ajudaria a corrigir o problema. Não tentaria esconder o erro nem transferir a culpa para quem executou a decisão.

Eu avaliaria:

- Qual foi o impacto;
- Quais usuários foram afetados;
- Como conter o problema;
- Se é possível reverter;
- Quais dados precisam ser reconciliados;
- Quais decisões dependem de novas informações;
- Quais controles falharam.

Depois, investigaria por que a decisão pareceu adequada no momento:

- Quais premissas estavam erradas;
- Quais dados faltaram;
- Quais riscos não foram considerados;
- Se houve pressão de prazo;
- Se opiniões divergentes foram ignoradas;
- Se não havia critérios de revisão;
- Se faltava observabilidade.

Eu compartilharia o aprendizado sem transformar a situação em uma exposição pessoal. Também criaria ações preventivas, como:

- Testes;
- Métricas;
- Revisão de decisão;
- Experimento;
- Feature flag;
- Rollback;
- Documentação;
- Melhor análise de risco.

**Explicação didática:**

Assumir responsabilidade não significa afirmar que uma pessoa é a única causa de um problema. Significa não se esconder quando a decisão esteve sob sua liderança e participar ativamente da recuperação.

Um Tech Lead precisa demonstrar que decisões podem ser revistas quando novas evidências aparecem.

**Exemplo prático:**

Se uma escolha de arquitetura causar aumento de latência, eu poderia:

1. Comunicar o problema;
2. Mitigar o impacto;
3. Comparar alternativas;
4. Revisar a decisão;
5. Corrigir ou substituir a solução;
6. Registrar o aprendizado;
7. Criar critérios melhores para decisões futuras.

**Exemplo de código:**

Não é necessário código. A questão avalia responsabilidade e comportamento de liderança.

**Como o candidato deve responder:**

O candidato deve:

- Assumir responsabilidade;
- Priorizar a recuperação;
- Comunicar o impacto;
- Analisar premissas;
- Evitar culpabilização;
- Criar ações preventivas;
- Demonstrar abertura para mudar de opinião.

**Resposta fraca ou incompleta:**

“Eu explicaria que a decisão foi executada incorretamente pelo time.”

Essa resposta evita responsabilidade e não contribui para a solução.

**Critérios de avaliação:**

- **0** — Nega ou esconde o erro.
- **1** — Culpa outras pessoas.
- **2** — Reconhece o problema, mas não propõe aprendizado.
- **3** — Assume responsabilidade e participa da correção.
- **4** — Analisa premissas, impacto e ações preventivas.
- **5** — Demonstra maturidade, transparência, humildade e capacidade de criar uma cultura de aprendizado.

**Perguntas de aprofundamento:**

1. Como comunicaria o erro para a liderança?
2. Como diferenciaria erro de negligência?
3. Que tipo de decisão deveria sempre possuir um plano de reversão?

---

## Pergunta 97 — Sucessão e continuidade da liderança técnica

**Nível:** Sênior  
**Categoria:** Sustentabilidade organizacional

**Pergunta do entrevistador:**

Como você prepararia outras pessoas para assumir responsabilidades de liderança técnica quando você não estivesse disponível?

**O que essa pergunta avalia:**

Avalia capacidade de distribuir conhecimento, formar novas lideranças e evitar dependência pessoal.

**Resposta esperada:**

Eu começaria identificando responsabilidades que hoje dependem excessivamente de mim, como:

- Decisões arquiteturais;
- Releases;
- Incidentes;
- Comunicação com produto;
- Revisões críticas;
- Planejamento técnico;
- Gestão de riscos;
- Coordenação com outros times.

Depois, distribuiria essas responsabilidades progressivamente:

- Delegar decisões reversíveis;
- Convidar pessoas para liderar discussões;
- Fazer rodízio em releases;
- Permitir que outras pessoas conduzam incidentes com apoio;
- Criar mentoria;
- Documentar decisões;
- Desenvolver runbooks;
- Compartilhar contexto;
- Dar feedback após cada experiência.

Eu não escolheria necessariamente uma única pessoa como substituta. O ideal é criar uma rede de pessoas capazes de assumir diferentes responsabilidades.

Também observaria se a delegação gera autonomia real ou apenas tarefas adicionais sem poder de decisão.

**Explicação didática:**

Uma liderança saudável aumenta a capacidade do sistema. Se tudo depende do Tech Lead, o time possui um risco operacional e organizacional.

Sucessão não significa preparar alguém para copiar o estilo do líder atual. Significa desenvolver julgamento, contexto e capacidade de decisão em outras pessoas.

**Exemplo prático:**

Uma pessoa pode começar acompanhando uma reunião de arquitetura, depois apresentar uma proposta, posteriormente conduzir a decisão e, por fim, orientar outra pessoa.

**Exemplo de código:**

Não é necessário código. A questão avalia desenvolvimento de liderança e distribuição de conhecimento.

**Como o candidato deve responder:**

O candidato deve:

- Identificar dependências pessoais;
- Delegar progressivamente;
- Distribuir decisões;
- Utilizar mentoria e rodízio;
- Criar documentação;
- Dar feedback;
- Preservar autonomia;
- Evitar centralizar conhecimento.

**Resposta fraca ou incompleta:**

“Eu escolheria um substituto e ensinaria tudo para ele.”

Essa abordagem mantém a dependência em uma única pessoa e não cria uma capacidade distribuída.

**Critérios de avaliação:**

- **0** — Centraliza responsabilidades.
- **1** — Não considera sucessão.
- **2** — Escolhe um substituto, mas não cria plano.
- **3** — Utiliza delegação e mentoria.
- **4** — Distribui responsabilidades, documentação e decisões.
- **5** — Demonstra visão sustentável de liderança, autonomia e continuidade operacional.

**Perguntas de aprofundamento:**

1. Como saberia se uma pessoa está pronta para assumir uma responsabilidade?
2. Como evitaria sobrecarregar as pessoas em desenvolvimento?
3. O que faria se ninguém quisesse assumir uma responsabilidade crítica?

---

## Pergunta 98 — Como medir o sucesso de um Tech Lead

**Nível:** Sênior  
**Categoria:** Resultados e liderança

**Pergunta do entrevistador:**

Como você saberia se está sendo bem-sucedido como Tech Lead?

**O que essa pergunta avalia:**

Avalia autoconhecimento, visão de resultados, capacidade de medir liderança e compreensão de que o sucesso não se resume à qualidade do código produzido pessoalmente.

**Resposta esperada:**

Eu avaliaria resultados em várias dimensões:

### Produto e entrega

- O time entrega valor com previsibilidade;
- As prioridades estão claras;
- O tempo de ciclo melhora;
- As dependências são reduzidas;
- Os riscos são identificados cedo.

### Qualidade e operação

- Incidentes diminuem;
- Recuperações são mais rápidas;
- Releases são mais seguras;
- A observabilidade melhora;
- O produto atende aos requisitos de desempenho e disponibilidade.

### Pessoas

- O conhecimento está distribuído;
- Pessoas evoluem;
- As decisões não dependem de uma única pessoa;
- O time consegue discordar de forma saudável;
- Existe autonomia;
- O ambiente é seguro para levantar riscos.

### Estratégia técnica

- As decisões possuem contexto;
- A arquitetura evolui de forma sustentável;
- A dívida técnica é priorizada;
- A engenharia está alinhada ao produto;
- Os investimentos técnicos produzem resultados observáveis.

Eu também buscaria feedback de:

- Pessoas do time;
- Product Manager;
- Liderança;
- Times parceiros;
- Operações;
- Pessoas mentoradas.

Não usaria apenas métricas de velocidade. Um time pode entregar muitas tarefas e ainda possuir baixa qualidade ou alto risco.

**Explicação didática:**

O Tech Lead não é bem-sucedido porque resolve pessoalmente todos os problemas difíceis. Ele é bem-sucedido quando aumenta a capacidade do time e melhora os resultados do produto.

Sinais positivos incluem:

- Mais pessoas tomando boas decisões;
- Menos dependência de especialistas;
- Incidentes mais controlados;
- Melhor comunicação;
- Entregas mais previsíveis;
- Riscos visíveis;
- Evolução técnica conectada ao negócio.

**Exemplo prático:**

Se antes apenas o Tech Lead conduzia releases e, depois de alguns meses, outras pessoas conseguem planejar, executar e monitorar releases com segurança, houve evolução de capacidade.

**Exemplo de código:**

Não é necessário código. A questão avalia resultados de liderança.

**Como o candidato deve responder:**

O candidato deve:

- Considerar produto, entrega, qualidade, operação e pessoas;
- Utilizar métricas;
- Buscar feedback;
- Evitar medir apenas velocidade;
- Falar sobre autonomia e distribuição de conhecimento;
- Relacionar liderança a resultados do time.

**Resposta fraca ou incompleta:**

“Eu saberia que estou indo bem se o time seguisse minhas decisões e entregasse muitas tarefas.”

Essa resposta confunde liderança com obediência e atividade.

**Critérios de avaliação:**

- **0** — Não define sucesso.
- **1** — Mede apenas quantidade de tarefas ou obediência.
- **2** — Considera entrega, mas ignora qualidade e pessoas.
- **3** — Avalia entrega, qualidade e colaboração.
- **4** — Inclui operação, autonomia, métricas e feedback.
- **5** — Demonstra visão ampla, madura e orientada ao desenvolvimento do time e aos resultados do produto.

**Perguntas de aprofundamento:**

1. Qual métrica de liderança você considera perigosa?
2. Como saberia se o time está autônomo?
3. Como lidaria com feedback de que está centralizando decisões?

---

## Pergunta 99 — Cenário completo de decisão como Tech Lead

**Nível:** Sênior  
**Categoria:** Simulação de liderança

**Pergunta do entrevistador:**

O produto precisa lançar uma funcionalidade em duas semanas. A arquitetura atual possui limitações, o time está parcialmente ocupado com incidentes e existe uma dependência externa instável. Como você conduziria a situação?

**O que essa pergunta avalia:**

Avalia capacidade de integrar produto, planejamento, arquitetura, riscos, operação e liderança em um cenário realista.

**Resposta esperada:**

Eu começaria esclarecendo o objetivo e o menor escopo necessário para entregar valor. Depois, avaliaria:

- Critérios de sucesso;
- Usuários afetados;
- Impacto financeiro;
- Dependência externa;
- Capacidade real do time;
- Incidentes em andamento;
- Riscos técnicos;
- Possibilidade de rollout gradual;
- Necessidade de feature flag;
- Plano de rollback;
- Requisitos de observabilidade;
- Dependências entre equipes.

Apresentaria alternativas:

1. Entregar uma versão reduzida;
2. Liberar apenas para um grupo controlado;
3. Usar o fluxo atual como fallback;
4. Criar um adaptador temporário;
5. Adiar partes não essenciais;
6. Tratar a dependência de forma assíncrona;
7. Postergar a entrega se o risco for inaceitável.

Eu alinharia a recomendação com produto e liderança, deixando explícitos os riscos e as consequências de cada opção.

Durante as duas semanas, organizaria:

- Responsáveis;
- Marcos de validação;
- Testes;
- Integração antecipada;
- Critérios de interrupção;
- Acompanhamento da dependência;
- Comunicação frequente;
- Preparação operacional.

Não prometeria a entrega completa sem considerar a capacidade do time e os incidentes existentes.

**Explicação didática:**

Um Tech Lead precisa tomar decisões com restrições reais. A resposta não deve ser simplesmente “trabalhar mais” ou “reescrever a arquitetura”.

O caminho mais seguro costuma ser reduzir escopo, limitar exposição e criar mecanismos de recuperação.

**Exemplo prático:**

A entrega poderia ser organizada assim:

~~~text
Dia 1:
- Alinhar escopo e riscos.
- Definir contrato com a dependência.
- Confirmar critérios de aceitação.

Dias 2 a 5:
- Implementar fluxo principal.
- Criar testes.
- Preparar feature flag.
- Criar métricas e logs.

Dias 6 a 8:
- Testar integração.
- Simular falhas.
- Validar fallback.
- Executar testes de carga necessários.

Dias 9 a 10:
- Liberar para grupo controlado.
- Monitorar.
- Corrigir problemas.
- Decidir expansão ou interrupção.
~~~

**Exemplo de código:**

Um fallback explícito poderia ser representado assim:

~~~java
public Resultado processar(Operacao operacao) {
    if (!dependenciaExterna.estaDisponivel()) {
        return Resultado.emProcessamento(
                "A operação será concluída posteriormente");
    }

    return dependenciaExterna.processar(operacao);
}
~~~

O comportamento real deve refletir as regras do produto. Nunca se deve retornar sucesso quando a operação não foi concluída.

**Como o candidato deve responder:**

O candidato deve:

- Reduzir escopo quando necessário;
- Avaliar capacidade e incidentes;
- Tornar riscos visíveis;
- Propor rollout controlado;
- Considerar dependências externas;
- Definir fallback;
- Preparar testes e observabilidade;
- Alinhar a decisão com produto;
- Saber recomendar adiamento quando o risco for inaceitável.

**Resposta fraca ou incompleta:**

“Eu dividiria as tarefas, faria horas extras e tentaria cumprir o prazo.”

Essa resposta não trata escopo, risco, dependência, operação ou sustentabilidade do time.

**Critérios de avaliação:**

- **0** — Ignora riscos e capacidade.
- **1** — Propõe apenas aumentar esforço.
- **2** — Planeja tarefas, mas não considera operação.
- **3** — Define escopo, responsáveis e testes.
- **4** — Inclui rollout, fallback, observabilidade e comunicação.
- **5** — Demonstra julgamento completo, equilíbrio entre velocidade e segurança e capacidade de liderar sob restrições.

**Perguntas de aprofundamento:**

1. Em que situação você recomendaria não lançar?
2. Como reduziria o escopo sem comprometer o valor principal?
3. O que faria se a dependência externa falhasse no dia do lançamento?

---

## Pergunta 100 — Por que você deve ser Tech Lead?

**Nível:** Sênior  
**Categoria:** Visão pessoal e adequação ao papel

**Pergunta do entrevistador:**

Por que você quer ser Tech Lead e que tipo de impacto pretende gerar no time e no produto?

**O que essa pergunta avalia:**

Avalia motivação, maturidade, autoconhecimento, compreensão do papel e alinhamento entre ambição pessoal e responsabilidade de liderança.

**Resposta esperada:**

Uma boa resposta deve explicar que o interesse não está apenas em tomar decisões técnicas ou ocupar uma posição de maior visibilidade.

O candidato pode destacar que deseja:

- Aumentar a capacidade do time;
- Ajudar pessoas a evoluir;
- Melhorar a qualidade das decisões;
- Conectar engenharia e produto;
- Reduzir riscos;
- Tornar entregas mais previsíveis;
- Evoluir a arquitetura de forma sustentável;
- Melhorar a operação;
- Promover colaboração;
- Desenvolver novas lideranças;
- Resolver problemas complexos com responsabilidade.

Também deveria demonstrar compreensão de que o papel envolve:

- Influenciar sem autoridade formal;
- Comunicar riscos;
- Tomar decisões difíceis;
- Dar feedback;
- Delegar;
- Lidar com conflitos;
- Assumir responsabilidade;
- Trabalhar com incerteza;
- Priorizar;
- Proteger o time de riscos desnecessários;
- Manter foco no usuário e no negócio.

Uma resposta madura reconhece que o Tech Lead não precisa ser a pessoa que mais codifica nem quem sempre possui a resposta. O papel é criar as condições para que boas decisões sejam tomadas e para que o time entregue valor com qualidade.

**Explicação didática:**

Tech Lead é uma função de liderança técnica, não apenas uma promoção baseada em conhecimento individual.

A pessoa pode ser excelente desenvolvedora e ainda precisar desenvolver:

- Comunicação;
- Delegação;
- Escuta;
- Negociação;
- Gestão de conflitos;
- Visão de produto;
- Mentoria;
- Tomada de decisão organizacional.

A pergunta busca identificar se o candidato deseja aumentar seu impacto por meio do time ou apenas concentrar mais decisões em si mesmo.

**Exemplo prático:**

Uma resposta consistente poderia mencionar:

> “Quero atuar como Tech Lead porque gosto de resolver problemas técnicos, mas também porque quero ajudar o time a tomar decisões melhores, distribuir conhecimento e conectar as escolhas de engenharia aos resultados do produto. Meu objetivo não é ser o único ponto de decisão, e sim aumentar a autonomia e a capacidade coletiva.”

**Exemplo de código:**

Não é necessário código. A questão avalia motivação e compreensão do papel.

**Como o candidato deve responder:**

O candidato deve:

- Demonstrar motivação além de status;
- Falar sobre impacto coletivo;
- Reconhecer responsabilidades de liderança;
- Mencionar pessoas, produto e operação;
- Demonstrar disposição para aprender;
- Explicar como pretende gerar valor;
- Evitar centralização.

**Resposta fraca ou incompleta:**

“Quero ser Tech Lead porque sou a pessoa que mais conhece Java e quero participar das decisões importantes.”

Conhecimento técnico é importante, mas não é suficiente para exercer a função.

**Critérios de avaliação:**

- **0** — Busca apenas status ou autoridade.
- **1** — Foca exclusivamente em tecnologia.
- **2** — Menciona liderança, mas não demonstra visão do papel.
- **3** — Entende que deve orientar decisões e apoiar o time.
- **4** — Conecta liderança, produto, operação e desenvolvimento de pessoas.
- **5** — Demonstra motivação madura, visão sistêmica, responsabilidade e desejo de aumentar a capacidade coletiva.

**Perguntas de aprofundamento:**

1. Que comportamento você precisaria desenvolver para atuar como Tech Lead?
2. O que faria se percebesse que outra pessoa possui uma solução melhor?
3. Como equilibraria liderança técnica e contribuição individual?
4. Que legado gostaria de deixar no time?

---

# Conclusão do roteiro completo

Com as perguntas 91 a 100, o roteiro chega às **100 perguntas para entrevista de Tech Lead**.

| Dimensão | Total |
|---|---:|
| Perguntas Júnior | 20 |
| Perguntas Pleno | 35 |
| Perguntas Sênior | 45 |
| Total geral | 100 |

## Competências avaliadas ao longo do roteiro

- Papel e responsabilidades do Tech Lead;
- Entrega de produto;
- Levantamento e transformação de requisitos;
- Planejamento;
- Gestão de riscos;
- Liderança técnica;
- Comunicação;
- Delegação;
- Mentoria;
- Feedback;
- Conflitos;
- Arquitetura;
- Integrações;
- APIs;
- Eventos;
- Idempotência;
- Escalabilidade;
- Segurança;
- Qualidade;
- Testes;
- CI/CD;
- Releases;
- Rollback;
- Observabilidade;
- Incidentes;
- SLOs;
- Post-mortems;
- Runbooks;
- Governança;
- Roadmap técnico;
- Coordenação entre times;
- Plataforma interna;
- Desenvolvimento de pessoas;
- Ética profissional;
- Segurança psicológica;
- Estratégia tecnológica;
- Priorização;
- Tomada de decisão sob incerteza;
- Visão de longo prazo;
- Sucessão e continuidade;
- Avaliação de resultados.

## Critério geral para avaliação

Um candidato forte para Tech Lead não precisa responder que conhece todas as tecnologias ou apresentar uma solução pronta para cada cenário.

O mais importante é demonstrar capacidade de:

1. Entender o problema antes de propor a solução;
2. Fazer perguntas relevantes;
3. Considerar produto, pessoas, tecnologia e operação;
4. Explicitar riscos e trade-offs;
5. Tomar decisões proporcionais ao contexto;
6. Comunicar-se com públicos diferentes;
7. Desenvolver outras pessoas;
8. Distribuir conhecimento;
9. Aprender com falhas;
10. Entregar valor com responsabilidade.