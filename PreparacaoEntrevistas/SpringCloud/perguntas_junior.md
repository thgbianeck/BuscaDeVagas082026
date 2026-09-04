# Roteiro de Entrevista Técnica — Spring Cloud

> **Observação:** este roteiro contém 100 perguntas para o nível Júnior.  
> Nesta primeira parte são apresentadas as perguntas 1 a 10. As demais devem manter a mesma sequência e estrutura.

## Visão geral do roteiro

- **Tecnologia avaliada:** Spring Cloud
- **Nível:** Júnior
- **Quantidade total:** 100 perguntas
- **Perfil:** Misturado — conceitual, prático e baseado em cenários reais
- **Versão de referência:** Spring Boot 3.x e Spring Cloud compatível com a versão utilizada pelo projeto. Alguns nomes de dependências, configurações e comportamentos podem variar entre versões.

## Fluxo geral avaliado

~~~mermaid
flowchart LR
    A[Cliente] --> B[API Gateway]
    B --> C[Service Discovery]
    C --> D[Serviço de pedidos]
    C --> E[Serviço de pagamentos]
    D --> F[Config Server]
    E --> F
    D --> G[Observabilidade]
    E --> G
~~~

---

# Pergunta 1 — Objetivo do Spring Cloud

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é o Spring Cloud e quais problemas comuns de aplicações distribuídas ele ajuda a resolver?

**O que essa pergunta avalia:**  

- Compreensão do propósito do Spring Cloud;
- Conhecimento básico sobre microsserviços;
- Capacidade de relacionar recursos técnicos a problemas reais;
- Diferenciação entre Spring Boot e Spring Cloud.

**Resposta esperada:**  

Spring Cloud é um conjunto de projetos e bibliotecas que auxilia na construção de aplicações distribuídas, especialmente sistemas baseados em microsserviços.

Ele oferece soluções ou integrações para problemas como:

- Descoberta de serviços;
- Configuração centralizada;
- Roteamento de requisições;
- Balanceamento de carga;
- Tolerância a falhas;
- Comunicação entre serviços;
- Rastreamento distribuído;
- Integração com mecanismos de configuração e infraestrutura.

O Spring Boot facilita a criação e a execução de uma aplicação individual. O Spring Cloud complementa o Spring Boot com recursos necessários para operar várias aplicações independentes em um ambiente distribuído.

A resposta também deve mencionar que o Spring Cloud não elimina a complexidade de microsserviços. Ele fornece abstrações e integrações, mas ainda é necessário cuidar de segurança, observabilidade, desempenho, versionamento e operação.

**Explicação didática:**  

Em uma aplicação monolítica, geralmente existe um único processo e uma configuração central. Em uma arquitetura de microsserviços, vários serviços precisam localizar uns aos outros, compartilhar configurações, lidar com falhas de rede e acompanhar requisições que passam por diferentes aplicações.

O Spring Cloud ajuda a organizar essas preocupações. Por exemplo, um serviço de pedidos pode precisar encontrar o serviço de pagamentos sem conhecer antecipadamente o endereço fixo dele. Um gateway pode receber requisições externas e encaminhá-las para o serviço correto.

O Spring Cloud oferece integração com diferentes ferramentas. Portanto, não é correto afirmar que existe apenas uma implementação obrigatória para cada problema.

**Exemplo prático:**  

Uma empresa possui os seguintes serviços:

- `pedido-service`;
- `pagamento-service`;
- `cliente-service`.

Em vez de configurar manualmente o endereço de cada serviço em vários arquivos, a equipe pode utilizar descoberta de serviços, configuração centralizada e um gateway para simplificar a comunicação e o acesso externo.

**Exemplo de código:**  

Não é necessário código para responder corretamente a esta pergunta. Um candidato pode, entretanto, mencionar uma configuração conceitual:

~~~yaml
spring:
  application:
    name: pedido-service
~~~

Essa propriedade identifica a aplicação e pode ser utilizada por mecanismos de descoberta e observabilidade.

**Como o candidato deve responder:**  

O candidato deve:

- Definir Spring Cloud de forma objetiva;
- Explicar que ele é usado principalmente em sistemas distribuídos;
- Citar pelo menos três problemas que ele ajuda a resolver;
- Diferenciar Spring Boot de Spring Cloud;
- Evitar dizer que Spring Cloud é uma linguagem ou um framework independente do ecossistema Spring;
- Demonstrar que entende que microsserviços também introduzem complexidade.

Para o nível Júnior, não é necessário conhecer profundamente todos os componentes, mas é importante relacionar cada recurso a um problema prático.

**Perguntas de aprofundamento:**  

1. Qual é a diferença entre Spring Boot e Spring Cloud?
2. Por que uma aplicação monolítica talvez não precise de todos esses recursos?
3. Quais problemas podem surgir ao adotar microsserviços sem necessidade?

**Resposta fraca ou incompleta:**  

“Spring Cloud serve para fazer microsserviços e deixa o sistema mais rápido.”

Essa resposta é insuficiente porque:

- Não explica quais problemas são resolvidos;
- Confunde arquitetura com desempenho;
- Não diferencia Spring Boot de Spring Cloud;
- Não menciona descoberta, configuração, roteamento ou tolerância a falhas.

**Critérios de avaliação:**  

- **0:** Não sabe responder ou apresenta informações incorretas.
- **1:** Sabe apenas que Spring Cloud está relacionado a microsserviços.
- **2:** Cita alguns recursos, mas não explica os problemas resolvidos.
- **3:** Explica corretamente o objetivo geral e diferencia Spring Boot de Spring Cloud.
- **4:** Relaciona os componentes a cenários reais e menciona limitações.
- **5:** Demonstra compreensão clara da arquitetura distribuída, alternativas, trade-offs e impactos operacionais.

---

# Pergunta 2 — Spring Boot e Spring Cloud

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Explique a diferença entre uma aplicação criada com Spring Boot e uma aplicação que utiliza recursos do Spring Cloud. Eles são concorrentes ou complementares?

**O que essa pergunta avalia:**  

- Conhecimento do ecossistema Spring;
- Capacidade de distinguir responsabilidades;
- Entendimento sobre configuração e execução de aplicações;
- Clareza na explicação de conceitos básicos.

**Resposta esperada:**  

Spring Boot é utilizado para simplificar a criação, a configuração e a execução de aplicações Spring. Ele oferece configuração automática, dependências organizadas e servidores embutidos, entre outros recursos.

Spring Cloud é complementar ao Spring Boot. Ele fornece abstrações e integrações para aplicações distribuídas, como:

- Descoberta de serviços;
- Gateway;
- Configuração distribuída;
- Circuit breaker;
- Balanceamento de carga;
- Comunicação entre serviços;
- Rastreamento distribuído.

Uma aplicação Spring Cloud normalmente também é uma aplicação Spring Boot. Portanto, os dois não são concorrentes.

**Explicação didática:**  

Pode-se pensar no Spring Boot como a base para criar uma aplicação Spring executável. O Spring Cloud adiciona recursos voltados a cenários em que há múltiplos serviços, comunicação pela rede e infraestrutura distribuída.

Por exemplo, uma API REST simples pode usar apenas Spring Boot. Já uma plataforma com vários serviços pode utilizar Spring Boot em cada serviço e Spring Cloud para cuidar de preocupações compartilhadas entre eles.

**Exemplo prático:**  

Um serviço de cadastro de clientes pode ser implementado apenas com Spring Boot. Se ele fizer parte de uma arquitetura com vários serviços, pode utilizar também:

- Configuração externa;
- Descoberta de serviços;
- Gateway;
- Tolerância a falhas;
- Observabilidade.

**Exemplo de código:**  

Um projeto pode utilizar o Spring Boot para expor uma API:

~~~java
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping("/{id}")
    public String buscar(@PathVariable Long id) {
        return "Cliente " + id;
    }
}
~~~

O código acima representa uma aplicação Spring Boot. A utilização de recursos de Spring Cloud dependeria das necessidades de comunicação e infraestrutura do sistema.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar Spring Boot como base da aplicação;
- Explicar Spring Cloud como um conjunto de soluções para sistemas distribuídos;
- Dizer que são complementares;
- Apresentar pelo menos um exemplo;
- Evitar dizer que Spring Cloud substitui o Spring Boot.

**Perguntas de aprofundamento:**  

1. Uma API REST simples sempre precisa de Spring Cloud?
2. Em que situação você adotaria apenas Spring Boot?
3. Que problemas surgem quando os serviços dependem de configurações fixas?

**Resposta fraca ou incompleta:**  

“Spring Boot é para aplicações pequenas e Spring Cloud é para aplicações grandes.”

Essa afirmação é incompleta porque tamanho não é o único critério. A escolha depende da arquitetura, da necessidade de distribuição, da infraestrutura e dos requisitos operacionais.

**Critérios de avaliação:**  

- **0:** Confunde completamente as tecnologias.
- **1:** Sabe que ambas fazem parte do ecossistema Spring, mas não diferencia suas funções.
- **2:** Diferencia parcialmente, com explicações vagas.
- **3:** Explica corretamente que Spring Boot e Spring Cloud são complementares.
- **4:** Apresenta exemplos adequados e reconhece que nem todo projeto precisa de Spring Cloud.
- **5:** Explica responsabilidades, critérios de adoção e trade-offs arquiteturais com clareza.

---

# Pergunta 3 — Descoberta de serviços

**Nível:** Júnior  
**Categoria:** Service Discovery

**Pergunta do entrevistador:**  
O que é descoberta de serviços e por que ela pode ser útil em uma arquitetura de microsserviços?

**O que essa pergunta avalia:**  

- Entendimento de comunicação entre microsserviços;
- Conhecimento básico sobre endereços dinâmicos;
- Compreensão do papel de um registro de serviços;
- Capacidade de explicar um fluxo de comunicação.

**Resposta esperada:**  

Descoberta de serviços é um mecanismo que permite que uma aplicação encontre outra aplicação sem precisar conhecer previamente seu endereço físico ou uma porta fixa.

Em ambientes distribuídos, instâncias podem ser criadas, removidas ou deslocadas. Um registro de serviços mantém informações sobre quais instâncias estão disponíveis. Quando o `pedido-service` precisa chamar o `pagamento-service`, ele consulta ou utiliza o mecanismo de descoberta para localizar uma instância disponível.

A descoberta pode ser:

- **Client-side:** o cliente consulta o registro e escolhe uma instância;
- **Server-side:** o cliente chama um componente intermediário, como um balanceador ou gateway, que realiza a descoberta.

O Spring Cloud pode integrar-se a diferentes soluções de descoberta. A escolha depende da infraestrutura e da versão utilizada.

**Explicação didática:**  

Sem descoberta de serviços, uma aplicação poderia ter uma configuração como:

~~~yaml
pagamento:
  url: http://10.0.0.25:8080
~~~

Esse modelo é frágil porque o endereço pode mudar. Com descoberta, o serviço utiliza um nome lógico, como `pagamento-service`, e a infraestrutura encontra uma instância disponível.

A descoberta não substitui a necessidade de tratar erros. Mesmo que o serviço esteja registrado, ele pode estar indisponível, lento ou incapaz de processar a requisição.

**Exemplo prático:**  

Durante uma campanha promocional, três instâncias do serviço de pagamentos são iniciadas. O serviço de pedidos não precisa ser reconfigurado para conhecer cada endereço. O mecanismo de descoberta pode disponibilizar as três instâncias para comunicação.

**Exemplo de código:**  

Uma aplicação pode identificar seu nome lógico:

~~~yaml
spring:
  application:
    name: pedido-service
~~~

Em uma configuração compatível com a solução de descoberta adotada, o serviço pode ser registrado automaticamente ou por configuração adicional.

**Como o candidato deve responder:**  

O candidato deve:

- Definir descoberta de serviços;
- Explicar o problema dos endereços fixos;
- Mencionar que instâncias podem mudar;
- Diferenciar nome lógico de endereço físico;
- Citar que existem abordagens client-side e server-side;
- Reconhecer que descoberta não elimina falhas de rede.

**Perguntas de aprofundamento:**  

1. O que pode acontecer se o registro de serviços estiver indisponível?
2. Como você evitaria que uma instância com problemas continuasse recebendo chamadas?
3. Quando uma configuração fixa poderia ser aceitável?

**Resposta fraca ou incompleta:**  

“Discovery serve para registrar os endpoints da aplicação.”

A resposta cita parte da função, mas não explica:

- Por que os endereços são dinâmicos;
- Como os serviços localizam uns aos outros;
- Qual é o benefício em ambientes com várias instâncias;
- Quais são os riscos envolvidos.

**Critérios de avaliação:**  

- **0:** Não sabe explicar ou descreve o recurso de maneira incorreta.
- **1:** Sabe apenas que existe um cadastro de serviços.
- **2:** Entende o cadastro, mas não relaciona o recurso à elasticidade.
- **3:** Explica corretamente a descoberta e o problema dos endereços fixos.
- **4:** Diferencia abordagens, instâncias e tratamento de falhas.
- **5:** Discute descoberta, health checks, consistência, dependências e trade-offs operacionais.

---

# Pergunta 4 — Registro de serviços e health check

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Um serviço aparece registrado no mecanismo de descoberta, mas as chamadas para ele continuam falhando. Quais hipóteses você investigaria?

**O que essa pergunta avalia:**  

- Raciocínio de troubleshooting;
- Conhecimento sobre disponibilidade real versus registro;
- Capacidade de investigar falhas distribuídas;
- Organização para diagnosticar um problema.

**Resposta esperada:**  

O registro de uma instância não garante que ela esteja funcionando corretamente. Eu investigaria, pelo menos:

1. Se a aplicação está realmente em execução;
2. Se a porta registrada é a porta correta;
3. Se o endereço ou hostname é acessível a partir do serviço chamador;
4. Se há regras de firewall, rede ou segurança bloqueando a chamada;
5. Se o health check está configurado corretamente;
6. Se a rota ou o endpoint utilizado existe;
7. Se o método HTTP, os parâmetros e os headers estão corretos;
8. Se há timeout;
9. Se o serviço está registrado com informações antigas;
10. Se a aplicação está reiniciando ou apresentando erros nos logs;
11. Se a autenticação está sendo rejeitada;
12. Se existe incompatibilidade entre versões ou contratos.

Também verificaria métricas, logs correlacionados e, quando disponível, traces distribuídos.

**Explicação didática:**  

Um serviço pode estar registrado, mas:

- Ter encerrado logo depois;
- Estar escutando apenas em `localhost`;
- Ter informado uma porta diferente;
- Estar saudável do ponto de vista do processo, mas incapaz de atender determinada rota;
- Estar aceitando conexões, porém retornando erros internos.

Por isso, é importante separar quatro perguntas:

- O serviço está registrado?
- O endereço é alcançável?
- O endpoint existe?
- A operação foi processada com sucesso?

**Exemplo prático:**  

O `pedido-service` tenta chamar o `pagamento-service`, mas recebe timeout. O diagnóstico pode revelar que o serviço de pagamentos registrou a porta `8080`, enquanto a aplicação realmente está atendendo na porta `8081`.

**Exemplo de código:**  

Uma verificação simples pode expor um endpoint de saúde, dependendo dos recursos habilitados no projeto:

~~~yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info
~~~

A equipe deve avaliar cuidadosamente quais endpoints serão expostos publicamente, especialmente em ambientes produtivos.

**Como o candidato deve responder:**  

O candidato deve organizar a investigação por camadas:

1. Registro;
2. Rede;
3. Aplicação;
4. Endpoint;
5. Autenticação;
6. Dependências;
7. Observabilidade.

Deve evitar concluir imediatamente que o problema está no Spring Cloud. O ideal é explicar como reproduzir, consultar logs e validar o endereço e a porta.

**Perguntas de aprofundamento:**  

1. Como você distinguiria um timeout de um erro HTTP 500?
2. Que informações procuraria nos logs?
3. Como um health check mal configurado pode prejudicar o roteamento?

**Resposta fraca ou incompleta:**  

“Eu reiniciaria o serviço e verificaria se ele está registrado.”

Essa resposta não apresenta uma investigação sistemática e não considera rede, porta, rota, autenticação, timeout ou logs.

**Critérios de avaliação:**  

- **0:** Não apresenta estratégia de investigação.
- **1:** Sugere apenas reiniciar a aplicação.
- **2:** Cita logs ou registro, mas ignora outras camadas.
- **3:** Apresenta uma sequência básica envolvendo registro, rede, porta e endpoint.
- **4:** Inclui autenticação, timeout, health check e observabilidade.
- **5:** Conduz um diagnóstico estruturado, prioriza hipóteses e explica como confirmaria ou descartaria cada uma.

---

# Pergunta 5 — Configuração centralizada

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
Por que uma arquitetura com vários microsserviços pode se beneficiar de um servidor de configuração centralizada?

**O que essa pergunta avalia:**  

- Compreensão do gerenciamento de configurações;
- Conhecimento sobre consistência entre ambientes;
- Noções de segurança e versionamento;
- Capacidade de identificar riscos de configurações duplicadas.

**Resposta esperada:**  

A configuração centralizada permite armazenar e administrar configurações de vários serviços em um local ou mecanismo padronizado.

Ela pode ajudar a:

- Evitar duplicação de configurações;
- Separar código e configuração;
- Padronizar valores por ambiente;
- Versionar alterações;
- Facilitar atualizações;
- Reduzir divergências entre serviços;
- Organizar configurações comuns e específicas.

Exemplos de configurações incluem URLs de dependências, timeouts, nomes de filas e parâmetros operacionais.

Entretanto, informações sensíveis, como senhas e tokens, não devem ser armazenadas de forma exposta. Elas devem utilizar um mecanismo apropriado de segredos ou, no mínimo, criptografia e controle de acesso.

**Explicação didática:**  

Sem centralização, cada serviço pode possuir cópias diferentes de uma mesma configuração. Isso pode gerar problemas como:

- Um ambiente apontando para a base errada;
- Timeouts diferentes sem justificativa;
- Alterações manuais não rastreadas;
- Dificuldade para reproduzir um incidente.

A centralização ajuda no controle, mas cria uma dependência adicional. É necessário pensar em disponibilidade, cache, inicialização da aplicação e comportamento quando o servidor de configuração estiver indisponível.

**Exemplo prático:**  

A URL do serviço de pagamentos muda. Em vez de alterar dezenas de aplicações individualmente, a equipe atualiza a configuração versionada e aplica a mudança conforme a estratégia definida.

**Exemplo de código:**  

Uma configuração externa pode ser representada assim:

~~~yaml
app:
  pagamento:
    timeout-ms: 3000
    url: http://pagamento-service
~~~

A aplicação pode consumir essas propriedades por meio de mecanismos de configuração do Spring. O formato exato depende da versão e da solução utilizada.

**Como o candidato deve responder:**  

O candidato deve mencionar:

- Separação entre código e configuração;
- Redução de duplicidade;
- Configuração por ambiente;
- Versionamento;
- Riscos de centralizar segredos;
- Necessidade de disponibilidade e controle de acesso.

Não é necessário conhecer todos os detalhes de bootstrap ou atualização dinâmica para o nível Júnior, mas o candidato deve entender a finalidade do recurso.

**Perguntas de aprofundamento:**  

1. Você colocaria uma senha de banco em um repositório de configuração?
2. O que deveria acontecer se o servidor de configuração ficar indisponível?
3. Como testaria uma alteração de configuração antes de levá-la à produção?

**Resposta fraca ou incompleta:**  

“Serve para guardar todas as propriedades em um lugar e facilitar a manutenção.”

A resposta é parcialmente correta, mas não menciona versionamento, ambientes, disponibilidade, segurança ou riscos de uma dependência central.

**Critérios de avaliação:**  

- **0:** Não sabe explicar o conceito.
- **1:** Entende apenas que as configurações ficam em outro lugar.
- **2:** Cita centralização, mas ignora versionamento e segurança.
- **3:** Explica os principais benefícios corretamente.
- **4:** Discute ambientes, segredos, disponibilidade e testes.
- **5:** Apresenta uma estratégia segura de configuração, incluindo governança, rollback e comportamento em falhas.

---

# Pergunta 6 — API Gateway

**Nível:** Júnior  
**Categoria:** Gateway e roteamento

**Pergunta do entrevistador:**  
Qual é o papel de um API Gateway em uma arquitetura de microsserviços? Cite benefícios e possíveis riscos de utilizá-lo.

**O que essa pergunta avalia:**  

- Conhecimento sobre entrada de requisições;
- Noções de roteamento;
- Compreensão de responsabilidades de infraestrutura;
- Capacidade de analisar benefícios e riscos.

**Resposta esperada:**  

Um API Gateway é um ponto de entrada para clientes acessarem vários serviços internos. Ele pode:

- Encaminhar requisições para o serviço correto;
- Aplicar autenticação e autorização;
- Controlar acesso;
- Implementar rate limiting;
- Fazer roteamento baseado em caminhos ou headers;
- Reescrever rotas;
- Aplicar políticas comuns;
- Registrar métricas e informações de acesso;
- Integrar-se com descoberta e balanceamento de serviços.

Entre os riscos estão:

- Tornar-se um ponto único de falha;
- Concentrar regras demais;
- Criar gargalo de desempenho;
- Aumentar a complexidade;
- Transformar-se em um “monólito de infraestrutura”;
- Criar forte dependência entre clientes e regras internas.

O gateway deve ser projetado para alta disponibilidade e deve manter responsabilidades bem definidas.

**Explicação didática:**  

Sem gateway, um cliente externo pode precisar conhecer vários endereços internos. Isso aumenta o acoplamento e expõe detalhes da arquitetura.

Com gateway, o cliente pode chamar algo como:

- `/api/pedidos`;
- `/api/pagamentos`;
- `/api/clientes`.

O gateway decide para onde cada chamada deve ser encaminhada.

Isso não significa que toda lógica de negócio deve ficar no gateway. Regras de negócio normalmente pertencem aos serviços responsáveis pelo domínio.

**Exemplo prático:**  

Uma aplicação mobile envia uma requisição para `/api/pedidos/123`. O gateway valida o token, identifica a rota correspondente e encaminha a chamada ao serviço de pedidos.

**Exemplo de código:**  

Um exemplo conceitual de rota pode ser:

~~~yaml
spring:
  cloud:
    gateway:
      routes:
        - id: pedidos
          uri: lb://pedido-service
          predicates:
            - Path=/api/pedidos/**
~~~

O prefixo `lb://` representa uma integração com balanceamento baseado em serviço, quando suportada pela configuração adotada.

**Como o candidato deve responder:**  

O candidato deve:

- Definir o gateway como ponto de entrada;
- Explicar roteamento;
- Citar pelo menos dois benefícios;
- Citar pelo menos um risco;
- Diferenciar responsabilidades técnicas de regras de negócio;
- Mencionar autenticação ou observabilidade como exemplos.

**Perguntas de aprofundamento:**  

1. O que você colocaria no gateway e o que deixaria no serviço?
2. Como evitar que o gateway vire um ponto único de falha?
3. Como investigaria uma requisição que chega ao gateway, mas não ao serviço?

**Resposta fraca ou incompleta:**  

“O gateway serve para esconder os microsserviços do usuário.”

Embora isso seja parcialmente verdadeiro, faltam roteamento, segurança, políticas transversais, observabilidade, disponibilidade e riscos operacionais.

**Critérios de avaliação:**  

- **0:** Não sabe o que é um gateway.
- **1:** Sabe apenas que ele recebe requisições.
- **2:** Cita roteamento, mas não explica benefícios ou riscos.
- **3:** Explica corretamente o papel básico do gateway.
- **4:** Discute segurança, observabilidade, disponibilidade e separação de responsabilidades.
- **5:** Avalia criteriosamente centralização, escalabilidade, acoplamento, custos e alternativas.

---

# Pergunta 7 — Roteamento por caminho

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Como você configuraria conceitualmente um gateway para encaminhar requisições de `/pedidos/**` para um serviço de pedidos e requisições de `/pagamentos/**` para um serviço de pagamentos?

**O que essa pergunta avalia:**  

- Capacidade de compreender regras de roteamento;
- Leitura de configurações;
- Conhecimento sobre nomes lógicos de serviços;
- Noções de validação de rotas.

**Resposta esperada:**  

Eu criaria duas rotas no gateway:

- Uma rota com o predicado `Path=/pedidos/**`, direcionando para o `pedido-service`;
- Outra rota com o predicado `Path=/pagamentos/**`, direcionando para o `pagamento-service`.

Se a infraestrutura de descoberta e balanceamento estivesse habilitada, poderia utilizar nomes lógicos, como `lb://pedido-service` e `lb://pagamento-service`.

Também verificaria:

- Se os serviços estão registrados;
- Se os nomes utilizados correspondem ao `spring.application.name`;
- Se as rotas são específicas o suficiente;
- Se os prefixes precisam ser removidos ou reescritos;
- Se há autenticação aplicada;
- Se os métodos HTTP e os headers são preservados;
- Se há logs e métricas para diagnosticar falhas.

**Explicação didática:**  

Uma rota geralmente possui:

- Um identificador;
- Um destino;
- Um ou mais predicados, que definem quando ela será aplicada;
- Filtros, que podem modificar a requisição ou a resposta.

O gateway compara a requisição recebida com os predicados. Quando o caminho corresponde a `/pedidos/**`, a chamada é encaminhada ao serviço configurado.

É importante validar a ordem e a especificidade das rotas. Regras muito genéricas podem capturar requisições que deveriam pertencer a outra rota.

**Exemplo prático:**  

~~~yaml
spring:
  cloud:
    gateway:
      routes:
        - id: rota-pedidos
          uri: lb://pedido-service
          predicates:
            - Path=/pedidos/**

        - id: rota-pagamentos
          uri: lb://pagamento-service
          predicates:
            - Path=/pagamentos/**
~~~

A propriedade `uri` depende da estratégia de descoberta e balanceamento adotada.

**Exemplo de código:**  

Não é necessário código Java. A configuração acima representa a ideia principal. Em um projeto real, também seriam avaliados:

- Timeout;
- CORS;
- Autenticação;
- Rate limiting;
- Tratamento de erros;
- Observabilidade.

**Como o candidato deve responder:**  

O candidato deve explicar a configuração antes de apresentá-la. Deve mencionar:

- Os dois caminhos;
- Os dois destinos;
- O uso de nomes lógicos;
- A necessidade de validar descoberta e registro;
- Possíveis ajustes de prefixo.

Não é esperado que memorize toda a sintaxe, desde que demonstre entender a estrutura.

**Perguntas de aprofundamento:**  

1. O que aconteceria se você configurasse apenas `/api/**`?
2. Como removeria o prefixo `/pedidos` antes de encaminhar a requisição?
3. Como testaria se cada rota está funcionando?

**Resposta fraca ou incompleta:**  

“Eu criaria duas URLs no gateway.”

Essa resposta não explica predicados, destinos, nomes de serviços nem como as requisições seriam selecionadas.

**Critérios de avaliação:**  

- **0:** Não consegue explicar o roteamento.
- **1:** Entende apenas que existem caminhos diferentes.
- **2:** Descreve parcialmente as rotas.
- **3:** Configura corretamente os dois caminhos e destinos.
- **4:** Considera descoberta, filtros, prefixos e testes.
- **5:** Discute precedência de rotas, segurança, observabilidade, tolerância a falhas e riscos de configuração.

---

# Pergunta 8 — Comunicação síncrona entre serviços

**Nível:** Júnior  
**Categoria:** Comunicação entre serviços

**Pergunta do entrevistador:**  
Um serviço de pedidos precisa consultar o serviço de clientes antes de criar um pedido. Quais aspectos você consideraria ao implementar essa comunicação?

**O que essa pergunta avalia:**  

- Conhecimento sobre chamadas HTTP entre serviços;
- Tratamento de falhas;
- Noções de timeout;
- Capacidade de considerar contratos e consistência.

**Resposta esperada:**  

Eu consideraria:

1. O contrato da API do serviço de clientes;
2. O formato de requisição e resposta;
3. Autenticação e autorização;
4. Timeout;
5. Tratamento de erros HTTP;
6. Retentativas controladas;
7. Idempotência;
8. Circuit breaker, quando apropriado;
9. Logs e correlação de requisições;
10. Métricas de latência e taxa de erro;
11. Compatibilidade e versionamento do contrato;
12. O comportamento quando o serviço de clientes estiver indisponível.

Também avaliaria se a chamada precisa ser síncrona. Dependendo do caso, uma comunicação assíncrona por eventos poderia reduzir o acoplamento, mas adicionaria complexidade de consistência eventual.

**Explicação didática:**  

Uma chamada entre serviços não é como uma chamada de método local. Ela envolve rede, que pode apresentar:

- Atrasos;
- Falhas;
- Perda de conexão;
- Respostas duplicadas;
- Serviços indisponíveis;
- Mudanças de contrato.

Por isso, a aplicação não deve esperar indefinidamente. Um timeout protege recursos do serviço chamador.

Retentativas também precisam de cuidado. Repetir uma operação de leitura pode ser aceitável em algumas situações, mas repetir uma operação de criação sem idempotência pode gerar duplicidade.

**Exemplo prático:**  

Ao criar um pedido, o serviço consulta se o cliente existe. Se o serviço de clientes estiver temporariamente indisponível, o sistema pode retornar uma resposta de indisponibilidade, utilizar uma estratégia de fallback ou processar a operação posteriormente, dependendo da regra de negócio.

**Exemplo de código:**  

Uma chamada pode ser representada conceitualmente com um cliente HTTP declarativo:

~~~java
@FeignClient(name = "cliente-service")
public interface ClienteClient {

    @GetMapping("/clientes/{id}")
    ClienteResponse buscar(@PathVariable Long id);
}
~~~

A configuração e o suporte exatos dependem da versão do Spring Cloud e das dependências utilizadas. Em produção, o cliente deve ser combinado com timeout, autenticação, tratamento de erros e observabilidade.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar o contrato entre os serviços;
- Mencionar timeout;
- Falar sobre erros e indisponibilidade;
- Considerar autenticação;
- Diferenciar chamada local de chamada de rede;
- Apresentar pelo menos um risco de retentativas.

Não é necessário escolher uma biblioteca específica se o candidato explicar que a decisão depende da versão e dos padrões adotados no projeto.

**Perguntas de aprofundamento:**  

1. Por que não é recomendável deixar a chamada sem timeout?
2. Quando uma retentativa pode piorar o problema?
3. Em que situação você escolheria comunicação assíncrona?

**Resposta fraca ou incompleta:**  

“Eu chamaria o endpoint do serviço de clientes e, se der erro, tentaria novamente.”

A resposta ignora contrato, timeout, autenticação, idempotência, observabilidade e os riscos de sobrecarregar o serviço indisponível.

**Critérios de avaliação:**  

- **0:** Não sabe explicar a comunicação entre serviços.
- **1:** Considera apenas chamar uma URL.
- **2:** Menciona erros, mas não apresenta tratamento adequado.
- **3:** Considera contrato, timeout e erros básicos.
- **4:** Discute retentativas, autenticação, logs e circuit breaker.
- **5:** Analisa comunicação síncrona e assíncrona, consistência, idempotência e trade-offs de acoplamento.

---

# Pergunta 9 — Timeout e retentativas

**Nível:** Júnior  
**Categoria:** Resiliência

**Pergunta do entrevistador:**  
Por que timeout e retentativas são importantes em chamadas entre microsserviços? Quais cuidados devem ser tomados?

**O que essa pergunta avalia:**  

- Compreensão de falhas de rede;
- Noções de resiliência;
- Capacidade de identificar efeitos colaterais;
- Conhecimento sobre proteção de recursos.

**Resposta esperada:**  

Timeout define quanto tempo o serviço chamador aguardará uma resposta. Sem timeout, conexões podem ficar ocupadas indefinidamente, causando acúmulo de requisições e degradação do sistema.

Retentativas podem ajudar em falhas temporárias, mas devem ser utilizadas com:

- Limite de tentativas;
- Intervalo entre tentativas;
- Backoff, aumentando gradualmente o intervalo;
- Jitter, adicionando variação para evitar picos sincronizados;
- Critério para diferenciar erros temporários de erros permanentes;
- Controle de idempotência;
- Monitoramento do impacto.

Retentar uma requisição pode piorar uma falha generalizada ao aumentar a carga sobre o serviço já indisponível. Por isso, retentativas devem ser combinadas com circuit breaker ou outra estratégia de proteção quando apropriado.

**Explicação didática:**  

Imagine que um serviço chama outro e espera indefinidamente. Cada requisição pendente consome recursos, como threads, conexões e memória. Com muitas requisições, o próprio serviço chamador pode ficar indisponível.

Uma retentativa faz sentido quando existe uma possibilidade razoável de recuperação, como uma falha temporária de rede. Ela não costuma ajudar em erros permanentes, como:

- `400 Bad Request`;
- Dados inválidos;
- Recurso inexistente;
- Falha de autenticação.

Retentar operações de escrita exige cuidado. Se a primeira chamada for processada, mas a resposta for perdida, uma nova tentativa poderá duplicar a operação.

**Exemplo prático:**  

Uma consulta de saldo sofre uma falha temporária de conexão. Uma retentativa rápida pode funcionar. Já uma solicitação de pagamento precisa de idempotência para evitar que o mesmo pagamento seja processado duas vezes.

**Exemplo de código:**  

Uma configuração conceitual pode ser:

~~~yaml
spring:
  cloud:
    openfeign:
      client:
        config:
          cliente-service:
            connectTimeout: 1000
            readTimeout: 3000
~~~

Os nomes das propriedades podem variar de acordo com a versão utilizada. O candidato deve demonstrar o princípio, não apenas memorizar uma propriedade específica.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar o objetivo do timeout;
- Explicar quando retentativas são úteis;
- Mencionar limite e backoff;
- Falar sobre idempotência;
- Diferenciar falhas temporárias de permanentes;
- Mencionar o risco de tempestade de retentativas.

**Perguntas de aprofundamento:**  

1. Você faria retentativa para um erro HTTP 400? Por quê?
2. Como evitaria duplicidade em uma operação de pagamento?
3. O que é circuit breaker e como ele se relaciona com retentativas?

**Resposta fraca ou incompleta:**  

“Timeout evita demora e retentativa garante que a chamada funcione.”

Essa resposta é superficial porque não trata os riscos de bloqueio, sobrecarga, duplicidade e retentativas inadequadas.

**Critérios de avaliação:**  

- **0:** Apresenta conceitos incorretos.
- **1:** Sabe apenas que timeout limita tempo.
- **2:** Entende retentativas, mas ignora seus riscos.
- **3:** Explica timeout, limite de tentativas e erros temporários.
- **4:** Discute backoff, idempotência e circuit breaker.
- **5:** Analisa cascatas de falha, orçamento de latência, carga, consistência e comportamento sob degradação.

---

# Pergunta 10 — Circuit breaker

**Nível:** Júnior  
**Categoria:** Resiliência

**Pergunta do entrevistador:**  
O que é um circuit breaker e qual problema ele tenta evitar em uma arquitetura de microsserviços?

**O que essa pergunta avalia:**  

- Conhecimento básico de tolerância a falhas;
- Compreensão de falhas em cascata;
- Capacidade de explicar estados de um mecanismo;
- Noções de fallback.

**Resposta esperada:**  

Circuit breaker é um mecanismo que interrompe temporariamente chamadas para um serviço que está apresentando muitas falhas ou demora excessiva.

Ele tenta evitar:

- Falhas em cascata;
- Esgotamento de threads e conexões;
- Retentativas excessivas;
- Sobrecarga de um serviço já degradado;
- Aumento generalizado da latência.

Normalmente, possui estados como:

- **Closed:** as chamadas passam normalmente e as falhas são monitoradas;
- **Open:** as chamadas são bloqueadas temporariamente;
- **Half-open:** algumas chamadas de teste são liberadas para verificar se o serviço se recuperou.

Quando o circuito está aberto, a aplicação pode utilizar um fallback, retornar uma resposta controlada ou informar que a operação está temporariamente indisponível.

**Explicação didática:**  

O nome vem da analogia com um disjuntor elétrico. Quando há muitas falhas, o circuito “desliga” para proteger o restante do sistema.

Sem circuit breaker, um serviço de pedidos pode continuar chamando um serviço de pagamentos indisponível milhares de vezes. Isso consome recursos de ambos e pode fazer a falha se espalhar.

O circuit breaker não corrige o serviço com problema. Ele apenas reduz o impacto enquanto a dependência se recupera ou enquanto a equipe investiga o incidente.

Implementações modernas do ecossistema Spring utilizam bibliotecas como Resilience4j. A disponibilidade e a configuração das integrações dependem da versão do Spring Cloud adotada.

**Exemplo prático:**  

Se o serviço de recomendações estiver indisponível, o serviço de produtos pode:

- Retornar produtos sem recomendações;
- Usar dados previamente armazenados;
- Ocultar temporariamente a seção de recomendações;
- Retornar uma resposta parcial.

Isso só é apropriado se a regra de negócio permitir.

**Exemplo de código:**  

Um exemplo conceitual utilizando uma anotação de circuit breaker é:

~~~java
@CircuitBreaker(name = "recomendacoes", fallbackMethod = "fallback")
public ListaRecomendacoes buscarRecomendacoes(Long produtoId) {
    return recomendacoesClient.buscar(produtoId);
}

private ListaRecomendacoes fallback(Long produtoId, Throwable erro) {
    // Retorna uma resposta degradada ou vazia,
    // conforme a regra de negócio.
    return ListaRecomendacoes.vazia();
}
~~~

O fallback não deve esconder silenciosamente falhas importantes. O erro deve ser registrado e monitorado.

**Como o candidato deve responder:**  

O candidato deve:

- Definir circuit breaker;
- Explicar falhas em cascata;
- Citar os estados principais;
- Explicar o propósito do fallback;
- Destacar que fallback depende da regra de negócio;
- Mencionar monitoramento e configuração adequada.

Para o nível Júnior, não é obrigatório detalhar todos os parâmetros, mas o candidato deve entender o fluxo.

**Perguntas de aprofundamento:**  

1. Em que situação um fallback seria perigoso?
2. Qual é a diferença entre circuit breaker e retry?
3. Como você saberia que o circuito está abrindo com frequência?

**Resposta fraca ou incompleta:**  

“Circuit breaker tenta novamente quando ocorre um erro.”

Essa resposta confunde circuit breaker com retentativa. O circuit breaker normalmente interrompe chamadas para proteger o sistema; ele não tem como objetivo principal repetir chamadas.

**Critérios de avaliação:**  

- **0:** Confunde o conceito com cache ou retentativa.
- **1:** Sabe apenas que está relacionado a erros.
- **2:** Entende que bloqueia chamadas, mas não explica o motivo.
- **3:** Explica o objetivo e os estados básicos.
- **4:** Relaciona circuit breaker a fallback, cascatas e observabilidade.
- **5:** Discute limiares, janela de análise, half-open, idempotência, degradação e riscos de mascarar falhas.

---

## Resumo desta parte

- **Perguntas apresentadas:** 1 a 10
- **Perguntas restantes:** 90
- **Nível abordado:** Júnior
- **Categorias cobertas:**
  - Fundamentos;
  - Service Discovery;
  - Troubleshooting;
  - Configuração;
  - Gateway e roteamento;
  - Comunicação entre serviços;
  - Resiliência.

## Matriz parcial de competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---:|---|
| Compreender o papel do Spring Cloud | Júnior | 1 e 2 | Diferencia Spring Boot de Spring Cloud e relaciona recursos a problemas distribuídos |
| Descoberta de serviços | Júnior | 3 e 4 | Explica nomes lógicos, instâncias dinâmicas e diagnóstico de registros incorretos |
| Configuração centralizada | Júnior | 5 | Entende separação entre código e configuração, versionamento e cuidados com segredos |
| API Gateway | Júnior | 6 e 7 | Compreende entrada única, roteamento, filtros e riscos de centralização |
| Comunicação entre serviços | Júnior | 8 | Considera contratos, timeout, autenticação, erros e observabilidade |
| Timeout e retentativas | Júnior | 9 | Diferencia falhas temporárias e permanentes e reconhece riscos de duplicidade |
| Circuit breaker | Júnior | 10 | Explica estados, falhas em cascata e fallback |

## Recomendações iniciais para o entrevistador

- Peça ao candidato para explicar o problema antes de citar uma solução.
- Não avalie apenas a memorização de propriedades YAML.
- Pergunte como ele investigaria uma falha em produção.
- Diferencie desconhecimento de sintaxe de desconhecimento conceitual.
- Solicite exemplos simples, mesmo que baseados em projetos acadêmicos.
- Observe se o candidato considera timeout, logs, segurança e tratamento de erros.
- Evite exigir uma biblioteca específica quando existirem alternativas compatíveis.
- Confirme a versão do Spring Boot e do Spring Cloud antes de avaliar detalhes de configuração.

## Recomendações iniciais para o candidato

- Explique primeiro o problema que precisa ser resolvido.
- Diferencie chamadas locais de chamadas pela rede.
- Sempre mencione timeout em comunicações entre serviços.
- Ao falar de retentativas, considere idempotência e sobrecarga.
- Não diga que um recurso é obrigatório sem analisar o contexto.
- Quando não souber a sintaxe exata, explique corretamente o conceito.
- Cite riscos e trade-offs, mesmo em soluções aparentemente simples.
- Organize respostas de troubleshooting por camadas: aplicação, rede, configuração, segurança e observabilidade.

---

# Roteiro de Entrevista Técnica — Spring Cloud

## Perguntas 11 a 20

> Continuação do roteiro para avaliação de nível Júnior, com perguntas conceituais, práticas e baseadas em cenários reais.

---

# Pergunta 11 — Balanceamento de carga

**Nível:** Júnior  
**Categoria:** Desempenho e comunicação entre serviços

**Pergunta do entrevistador:**  
O que é balanceamento de carga entre microsserviços e por que ele pode ser necessário em uma aplicação Spring Cloud?

**O que essa pergunta avalia:**  

- Compreensão de múltiplas instâncias de um serviço;
- Noções básicas de distribuição de requisições;
- Relação entre balanceamento, disponibilidade e desempenho;
- Capacidade de identificar problemas causados pela concentração de tráfego.

**Resposta esperada:**  

Balanceamento de carga é a distribuição de requisições entre várias instâncias de um mesmo serviço.

Por exemplo, se existem três instâncias do `pedido-service`, o balanceador pode distribuir as chamadas entre elas, evitando que apenas uma instância receba todo o tráfego.

O balanceamento pode ajudar a:

- Distribuir melhor a carga;
- Aumentar a capacidade de atendimento;
- Melhorar a disponibilidade;
- Evitar sobrecarga de uma única instância;
- Facilitar o uso de escala horizontal.

Em uma arquitetura integrada ao Spring Cloud, o balanceamento pode utilizar nomes lógicos de serviços, como `lb://pedido-service`, em vez de endereços fixos.

A estratégia utilizada pode variar. Alguns exemplos são:

- Round-robin, que alterna as instâncias;
- Menor número de conexões;
- Distribuição baseada em peso;
- Escolha baseada em saúde ou disponibilidade.

**Explicação didática:**  

Imagine que existam três servidores executando o mesmo serviço:

~~~text 
pedido-service-1 pedido-service-2 pedido-service-3
~~~


Se todas as chamadas forem enviadas para o primeiro servidor, ele poderá ficar sobrecarregado enquanto os demais permanecem ociosos.

O balanceador atua como um distribuidor de requisições. Ele precisa saber quais instâncias estão disponíveis e escolher uma delas para cada chamada.

O balanceamento não resolve todos os problemas. Se todas as instâncias compartilham um banco de dados lento, por exemplo, o banco continuará sendo um gargalo.

**Exemplo prático:**  

Durante uma campanha promocional, o serviço de pedidos recebe uma quantidade de requisições cinco vezes maior que o normal. A equipe cria novas instâncias do serviço e utiliza balanceamento para distribuir o tráfego entre elas.

**Exemplo de código:**  

Uma rota de gateway pode utilizar um destino lógico balanceado:

~~~yaml
spring:
  cloud:
    gateway:
      routes:
        - id: pedidos
          uri: lb://pedido-service
          predicates:
            - Path=/pedidos/**
~~~

Nesse exemplo, o gateway encaminha as requisições para uma instância disponível do `pedido-service`, desde que a integração com descoberta e balanceamento esteja corretamente configurada.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar que existem várias instâncias do mesmo serviço;
- Relacionar o balanceamento à distribuição de requisições;
- Mencionar disponibilidade e desempenho;
- Explicar que o balanceador precisa conhecer instâncias disponíveis;
- Evitar afirmar que adicionar instâncias sempre resolve gargalos.

Para o nível Júnior, não é necessário detalhar algoritmos avançados, mas o candidato deve compreender o conceito de escala horizontal.

**Perguntas de aprofundamento:**  

1. O que pode acontecer se o balanceador enviar requisições para uma instância com problemas?
2. Qual é a diferença entre aumentar os recursos de uma máquina e criar novas instâncias?
3. Como você verificaria se as requisições estão sendo distribuídas corretamente?

**Resposta fraca ou incompleta:**  

“Balanceamento serve para deixar o sistema mais rápido.”

A resposta é insuficiente porque não explica a existência de múltiplas instâncias, a distribuição de requisições nem a relação com disponibilidade e sobrecarga.

**Critérios de avaliação:**  

- **0:** Não sabe explicar balanceamento de carga.
- **1:** Sabe apenas que ele distribui requisições.
- **2:** Entende parcialmente a distribuição, mas não relaciona o conceito a instâncias.
- **3:** Explica corretamente o objetivo básico do balanceamento.
- **4:** Relaciona balanceamento à escala horizontal, disponibilidade e health checks.
- **5:** Discute estratégias, falhas, gargalos compartilhados e trade-offs entre balanceamento no cliente, gateway e infraestrutura.

---

# Pergunta 12 — Configuração por ambiente

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
Como você organizaria configurações diferentes para desenvolvimento, homologação e produção em uma aplicação Spring Cloud?

**O que essa pergunta avalia:**  

- Conhecimento sobre separação de ambientes;
- Organização de configurações;
- Noções de profiles;
- Identificação de riscos de misturar configurações.

**Resposta esperada:**  

Eu separaria as configurações por ambiente, evitando colocar valores de desenvolvimento, homologação e produção no mesmo conjunto de propriedades sem distinção.

Podem existir configurações específicas para cada ambiente, como:

- URLs de serviços;
- Credenciais ou referências a segredos;
- Níveis de log;
- Timeouts;
- Nome de filas;
- Endereços de bancos de dados;
- Recursos habilitados ou desabilitados.

O Spring permite utilizar profiles, como:

- `dev`;
- `hom`;
- `prod`.

A configuração ativa deve ser definida pelo ambiente de execução, e não alterada manualmente no código.

Também é importante:

- Versionar configurações não sensíveis;
- Proteger segredos;
- Controlar quem pode alterar configurações;
- Validar alterações antes da produção;
- Registrar histórico e possibilidade de rollback.

**Explicação didática:**  

Uma aplicação pode precisar usar um banco local durante o desenvolvimento e um banco gerenciado em produção. Ela também pode utilizar diferentes níveis de log e diferentes endereços de serviços.

Uma forma de organizar isso é utilizar arquivos ou fontes de configuração específicas para cada profile:

~~~text
application.yml
application-dev.yml
application-hom.yml
application-prod.yml
~~~

A configuração comum pode ficar no arquivo principal, enquanto as diferenças ficam nos arquivos específicos.

O cuidado principal é evitar que a aplicação de produção seja executada acidentalmente com configurações de desenvolvimento.

**Exemplo prático:**  

No ambiente de desenvolvimento:
yaml app: pagamento: url: http://localhost:8082


No ambiente de produção:
yaml app: pagamento: url: http://pagamento-service


A aplicação deve selecionar a configuração correta por meio do ambiente de execução.

**Exemplo de código:**  

Uma configuração de profile pode ser representada assim:

~~~yaml
spring:
  profiles:
    active: dev
~~~

Em ambientes produtivos, é preferível definir o profile por variável de ambiente, configuração de implantação ou mecanismo equivalente, em vez de fixá-lo permanentemente no código.

**Como o candidato deve responder:**  

O candidato deve mencionar:

- Separação por ambiente;
- Uso de profiles ou mecanismo equivalente;
- Configurações comuns e específicas;
- Proteção de informações sensíveis;
- Validação antes da publicação;
- Risco de ativar o ambiente errado.

Não é necessário memorizar o nome exato de cada arquivo, desde que o raciocínio esteja correto.

**Perguntas de aprofundamento:**  

1. Por que não devemos colocar a senha de produção diretamente no repositório?
2. Como evitar que o profile de desenvolvimento seja ativado em produção?
3. O que você faria se uma configuração incorreta fosse publicada?

**Resposta fraca ou incompleta:**  

“Eu criaria um arquivo para cada ambiente e escolheria o arquivo certo.”

A resposta não aborda segurança, seleção automática do ambiente, versionamento, validação nem possibilidade de rollback.

**Critérios de avaliação:**  

- **0:** Não sabe diferenciar ambientes.
- **1:** Cita arquivos diferentes, mas não explica como organizá-los.
- **2:** Entende parcialmente a separação, mas ignora segurança.
- **3:** Explica corretamente a separação por profiles e ambientes.
- **4:** Considera segredos, validação, controle de acesso e rollback.
- **5:** Apresenta uma estratégia consistente de configuração, governança, auditoria e prevenção de erros de implantação.

---

# Pergunta 13 — Atualização de configurações

**Nível:** Júnior  
**Categoria:** Configuração e operação

**Pergunta do entrevistador:**  
Se uma configuração centralizada for alterada, a aplicação Spring Cloud passa a utilizar o novo valor imediatamente? Explique os fatores envolvidos.

**O que essa pergunta avalia:**  

- Entendimento do ciclo de vida de configurações;
- Conhecimento sobre inicialização e atualização;
- Capacidade de distinguir configuração carregada de configuração dinâmica;
- Noções de riscos operacionais.

**Resposta esperada:**  

Não necessariamente. Em muitos cenários, a aplicação lê as configurações durante a inicialização e mantém esses valores em memória.

Para que uma mudança seja aplicada, pode ser necessário:

- Reiniciar a aplicação;
- Acionar um mecanismo de refresh;
- Publicar um evento de atualização;
- Utilizar uma solução de configuração dinâmica;
- Garantir que o componente suporte atualização sem reinicialização.

A disponibilidade desse comportamento depende da versão do Spring Boot, da versão do Spring Cloud, das dependências utilizadas e da forma como a configuração foi implementada.

Mesmo quando o refresh dinâmico é possível, é necessário avaliar os riscos. Uma mudança de timeout, rota ou regra operacional pode afetar o sistema imediatamente.

**Explicação didática:**  

Imagine que uma aplicação leia a propriedade abaixo ao iniciar:

~~~yaml
app:
  pagamento:
    timeout-ms: 3000
~~~

Se o valor for alterado para `5000` no servidor de configuração, isso não significa automaticamente que todos os componentes já estejam usando o novo valor.

Alguns valores podem ser carregados apenas na inicialização. Outros podem ser atualizados dinamicamente, desde que o componente e a estratégia de configuração ofereçam suporte.

A atualização dinâmica é conveniente, mas também exige:

- Controle de permissões;
- Auditoria;
- Validação;
- Monitoramento;
- Possibilidade de reverter alterações.

**Exemplo prático:**  

A equipe reduz o timeout de uma integração de 10 segundos para 2 segundos sem testar. O sistema passa a considerar muitas requisições como falhas, aumentando a taxa de erro.

Uma alteração aparentemente simples de configuração pode ter impacto significativo.

**Exemplo de código:**  

Uma classe pode receber uma propriedade da aplicação:

~~~java
@Component
@ConfigurationProperties(prefix = "app.pagamento")
public class PagamentoProperties {

    private int timeoutMs;

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }
}
~~~

A atualização automática desse valor dependerá da configuração e do mecanismo adotado pelo projeto.

**Como o candidato deve responder:**  

O candidato deve:

- Evitar afirmar que toda alteração é imediata;
- Explicar que muitas configurações são carregadas na inicialização;
- Citar reinicialização ou refresh como possibilidades;
- Reconhecer dependência da versão e da implementação;
- Mencionar validação e rollback.

**Perguntas de aprofundamento:**  

1. Quais configurações você evitaria alterar dinamicamente?
2. Como validaria uma configuração antes de aplicá-la em produção?
3. O que poderia acontecer se metade das instâncias recebesse o novo valor e a outra metade continuasse usando o antigo?

**Resposta fraca ou incompleta:**  

“Sim, o Spring Cloud atualiza tudo automaticamente quando o arquivo muda.”

Essa resposta é incorreta porque ignora o ciclo de vida da configuração, a necessidade de refresh e as diferenças entre componentes e versões.

**Critérios de avaliação:**  

- **0:** Apresenta comportamento completamente incorreto.
- **1:** Sabe apenas que existe um servidor de configuração.
- **2:** Reconhece que pode ser necessário reiniciar, mas não explica o motivo.
- **3:** Explica corretamente que a atualização depende da configuração adotada.
- **4:** Considera refresh, versionamento, validação e rollback.
- **5:** Analisa consistência entre instâncias, risco operacional, compatibilidade e estratégia segura de rollout.

---

# Pergunta 14 — OpenFeign e clientes HTTP

**Nível:** Júnior  
**Categoria:** Comunicação entre serviços

**Pergunta do entrevistador:**  
O que é um cliente HTTP declarativo, como o OpenFeign, e quais cuidados você teria ao utilizá-lo para chamar outro microsserviço?

**O que essa pergunta avalia:**  

- Conhecimento sobre comunicação HTTP;
- Compreensão de clientes declarativos;
- Capacidade de considerar erros e configurações;
- Noções de acoplamento entre serviços.

**Resposta esperada:**  

Um cliente HTTP declarativo permite definir uma interface que representa as operações de outro serviço. A implementação da chamada HTTP é gerada ou configurada pelo framework.

Com isso, o código do serviço chamador pode expressar a intenção de forma mais simples, sem construir manualmente toda a requisição HTTP.

Ao utilizar um cliente como OpenFeign, eu consideraria:

- Contrato da API;
- Método HTTP;
- Caminho da rota;
- Parâmetros;
- Headers;
- Autenticação;
- Timeout;
- Tratamento de erros;
- Retentativas;
- Observabilidade;
- Versionamento;
- Compatibilidade entre os serviços.

Também evitaria tratar a chamada remota como se fosse uma chamada local. A rede pode falhar, ficar lenta ou retornar respostas inesperadas.

**Explicação didática:**  

Sem um cliente declarativo, o código poderia precisar construir manualmente URLs, headers e corpos de requisição.

Com uma interface declarativa, a intenção pode ficar mais clara:

~~~java
@FeignClient(name = "cliente-service")
public interface ClienteClient {

    @GetMapping("/clientes/{id}")
    ClienteResponse buscar(@PathVariable("id") Long id);
}
~~~

A interface representa uma chamada para o `cliente-service`. Porém, ainda existem problemas de rede que precisam ser tratados.

O cliente declarativo simplifica a escrita do código, mas não elimina a necessidade de configuração e resiliência.

**Exemplo prático:**  

O `pedido-service` utiliza `ClienteClient` para consultar os dados de um cliente antes de criar um pedido.

Se o serviço de clientes retornar `404`, isso pode significar que o cliente não existe. Se ocorrer timeout, o problema pode ser indisponibilidade ou lentidão. Esses casos não devem necessariamente receber o mesmo tratamento.

**Exemplo de código:**  

~~~java
@FeignClient(name = "cliente-service")
public interface ClienteClient {

    @GetMapping("/clientes/{id}")
    ClienteResponse buscar(@PathVariable("id") Long id);
}

public record ClienteResponse(Long id, String nome) {
}
~~~

O exemplo demonstra a definição do contrato esperado. A aplicação ainda precisará tratar erros, autenticação, timeout e possíveis mudanças na API.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar o conceito de cliente declarativo;
- Dizer que ele simplifica chamadas HTTP;
- Mencionar contrato e mapeamento da API;
- Considerar timeout e erros;
- Evitar tratar comunicação remota como chamada local;
- Reconhecer que detalhes dependem da versão e das dependências.

**Perguntas de aprofundamento:**  

1. Como você trataria um erro 404 retornado pelo serviço chamado?
2. O que aconteceria se o contrato da API fosse alterado sem atualizar o cliente?
3. Onde configuraria autenticação para essa comunicação?

**Resposta fraca ou incompleta:**  

“OpenFeign cria automaticamente a chamada e não precisamos nos preocupar com HTTP.”

A resposta é incompleta porque ignora contrato, timeout, falhas de rede, autenticação e tratamento de erros.

**Critérios de avaliação:**  

- **0:** Não sabe o que é um cliente HTTP.
- **1:** Sabe apenas que OpenFeign chama outro serviço.
- **2:** Entende a interface, mas ignora falhas remotas.
- **3:** Explica corretamente o cliente declarativo e seus cuidados básicos.
- **4:** Considera contratos, erros, timeout, autenticação e observabilidade.
- **5:** Discute acoplamento, compatibilidade, versionamento, resiliência e alternativas como WebClient ou chamadas assíncronas.

---

# Pergunta 15 — Contrato entre serviços

**Nível:** Júnior  
**Categoria:** Integração

**Pergunta do entrevistador:**  
O que significa manter um contrato entre microsserviços e por que alterações incompatíveis podem causar problemas?

**O que essa pergunta avalia:**  

- Compreensão de APIs;
- Noções de compatibilidade;
- Capacidade de identificar impactos de mudanças;
- Conhecimento básico sobre integração entre equipes.

**Resposta esperada:**  

O contrato entre microsserviços define como um serviço será consumido por outro. Ele pode incluir:

- Endpoints;
- Métodos HTTP;
- Parâmetros;
- Headers;
- Formato das mensagens;
- Códigos de resposta;
- Regras de autenticação;
- Campos obrigatórios e opcionais;
- Regras de versionamento.

Uma alteração incompatível pode quebrar consumidores que ainda esperam o comportamento anterior.

Exemplos de alterações potencialmente incompatíveis:

- Remover um campo obrigatório;
- Alterar o tipo de um campo;
- Mudar o significado de um valor;
- Renomear uma rota;
- Alterar o código HTTP esperado;
- Exigir um header que o consumidor não envia.

Sempre que possível, alterações devem ser compatíveis com versões anteriores, permitindo uma migração gradual.

**Explicação didática:**  

O contrato funciona como um acordo entre o serviço que fornece a API e o serviço que a consome.

Por exemplo, um serviço pode retornar:

~~~json
{
  "id": 10,
  "nome": "Ana"
}
~~~

Se o consumidor espera o campo `nome`, substituir esse campo repentinamente por `descricao` pode causar falhas.

Uma estratégia segura é adicionar o novo campo, manter o campo antigo temporariamente e migrar os consumidores antes de remover o comportamento anterior.

**Exemplo prático:**  

O serviço de clientes deseja trocar o campo `nomeCompleto` por `nome`. Em vez de remover o campo imediatamente, pode:

1. Adicionar `nome`;
2. Manter `nomeCompleto` durante a transição;
3. Atualizar os consumidores;
4. Monitorar o uso do campo antigo;
5. Remover o campo somente depois da migração.

**Exemplo de código:**  

Uma classe de resposta pode representar campos opcionais:

~~~java
public record ClienteResponse(
        Long id,
        String nome,
        String nomeCompleto
) {
}
~~~

Durante uma migração, o consumidor pode aceitar os dois campos, desde que o comportamento esteja claramente definido.

**Como o candidato deve responder:**  

O candidato deve mencionar:

- Que o contrato define como os serviços se comunicam;
- Que mudanças podem quebrar consumidores;
- A importância de compatibilidade;
- Estratégias de migração gradual;
- Testes de integração ou de contrato.

Não é esperado que o candidato conheça ferramentas específicas de contrato, mas ele deve compreender o risco de mudanças não coordenadas.

**Perguntas de aprofundamento:**  

1. Adicionar um novo campo geralmente é compatível?
2. Como você removeria uma rota usada por vários consumidores?
3. Como testaria se uma alteração quebra outro serviço?

**Resposta fraca ou incompleta:**  

“Contrato é a documentação da API, e qualquer mudança deve ser comunicada.”

A documentação é parte importante, mas a resposta não aborda compatibilidade, versionamento, testes ou estratégias de migração.

**Critérios de avaliação:**  

- **0:** Não entende a ideia de contrato.
- **1:** Sabe apenas que existe uma API documentada.
- **2:** Reconhece que mudanças podem causar erros, mas não explica como.
- **3:** Explica contrato, compatibilidade e riscos básicos.
- **4:** Propõe migração gradual, testes e versionamento.
- **5:** Discute compatibilidade retroativa, consumer-driven contracts, depreciação, observabilidade e governança de APIs.

---

# Pergunta 16 — Versionamento de APIs

**Nível:** Júnior  
**Categoria:** Integração e manutenção

**Pergunta do entrevistador:**  
Quando uma API utilizada por outros microsserviços precisa sofrer uma alteração incompatível, como você poderia conduzir o versionamento?

**O que essa pergunta avalia:**  

- Conhecimento sobre evolução de APIs;
- Capacidade de planejar mudanças;
- Noções de compatibilidade retroativa;
- Compreensão de migração gradual.

**Resposta esperada:**  

Quando uma mudança quebra o contrato existente, uma possibilidade é criar uma nova versão da API, mantendo a versão anterior durante o período de migração.

Algumas estratégias comuns são:

- Versionamento no caminho, como `/v1/clientes` e `/v2/clientes`;
- Versionamento por header;
- Versionamento por conteúdo;
- Criação de uma nova operação compatível;
- Migração gradual dos consumidores.

A escolha depende do padrão adotado pela organização e das características da API.

O processo deveria incluir:

1. Identificação dos consumidores atuais;
2. Definição do novo contrato;
3. Implementação da nova versão;
4. Atualização e teste dos consumidores;
5. Monitoramento do uso da versão antiga;
6. Comunicação de depreciação;
7. Remoção planejada da versão antiga.

**Explicação didática:**  

Uma API não deve ser alterada pensando apenas no serviço que a fornece. Outros serviços, aplicações móveis, integrações externas ou clientes antigos podem depender dela.

Se um consumidor espera:

~~~json
{
  "valor": 100.00
}
~~~

e a nova API passa a retornar:

~~~json
{
  "preco": {
    "valor": 100.00,
    "moeda": "BRL"
  }
}
~~~

a alteração pode exigir uma nova versão, pois o formato anterior deixou de existir.

A coexistência temporária das versões permite que os consumidores migrem sem uma mudança coordenada em todos os sistemas ao mesmo tempo.

**Exemplo prático:**  

O serviço de pagamentos possui `/v1/pagamentos`, que recebe apenas o valor. A nova versão `/v2/pagamentos` exige valor, moeda e método de pagamento.

A versão 1 pode continuar funcionando enquanto os consumidores são migrados para a versão 2.

**Exemplo de código:**  

Um controller poderia expor versões distintas:

~~~java
@RestController
@RequestMapping("/v1/pagamentos")
public class PagamentoV1Controller {
    // Contrato legado
}

@RestController
@RequestMapping("/v2/pagamentos")
public class PagamentoV2Controller {
    // Novo contrato
}
~~~

A implementação real deve evitar duplicação desnecessária e manter claramente as diferenças entre os contratos.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar por que uma alteração incompatível precisa ser controlada;
- Citar pelo menos uma estratégia de versionamento;
- Mencionar migração gradual;
- Falar sobre depreciação e monitoramento;
- Evitar remover a versão antiga imediatamente sem conhecer os consumidores.

**Perguntas de aprofundamento:**  

1. Como descobriria quais consumidores ainda utilizam a versão antiga?
2. Qual é o custo de manter duas versões da mesma API?
3. Quando adicionar um campo seria melhor do que criar uma nova versão?

**Resposta fraca ou incompleta:**  

“Eu mudaria a API e avisaria os outros times.”

Essa abordagem pode falhar porque consumidores podem não conseguir atualizar imediatamente. Faltam estratégia de compatibilidade, prazo de migração, monitoramento e plano de remoção.

**Critérios de avaliação:**  

- **0:** Não reconhece o problema de compatibilidade.
- **1:** Sugere apenas avisar os consumidores.
- **2:** Cita versionamento, mas não explica a migração.
- **3:** Propõe manter versões paralelas durante a transição.
- **4:** Considera consumidores, depreciação, testes e monitoramento.
- **5:** Analisa diferentes estratégias, custos operacionais, governança, compatibilidade e plano seguro de descontinuação.

---

# Pergunta 17 — Actuator e endpoints de saúde

**Nível:** Júnior  
**Categoria:** Observabilidade e troubleshooting

**Pergunta do entrevistador:**  
Qual é a utilidade do Spring Boot Actuator em uma aplicação que utiliza Spring Cloud? Quais cuidados você teria ao expor seus endpoints?

**O que essa pergunta avalia:**  

- Conhecimento básico de monitoramento;
- Compreensão de health checks;
- Noções de segurança;
- Capacidade de diferenciar informações internas e públicas.

**Resposta esperada:**  

O Spring Boot Actuator fornece endpoints para observar e administrar aspectos da aplicação.

Dependendo da configuração, ele pode disponibilizar informações sobre:

- Saúde da aplicação;
- Métricas;
- Informações do ambiente;
- Status de componentes;
- Mapeamentos;
- Configurações;
- Logs ou outras informações operacionais.

Em um ambiente Spring Cloud, o endpoint de saúde pode ser utilizado para verificar se uma instância está apta a receber tráfego.

Os principais cuidados são:

- Não expor todos os endpoints publicamente;
- Exigir autenticação e autorização;
- Evitar revelar segredos ou configurações sensíveis;
- Restringir acesso por rede quando possível;
- Separar endpoints internos de endpoints externos;
- Monitorar acessos aos endpoints administrativos.

**Explicação didática:**  

Existem pelo menos duas perguntas diferentes:

- A aplicação está em execução?
- A aplicação está apta a atender requisições?

Uma aplicação pode estar viva, mas sem conexão com o banco de dados ou com uma dependência essencial. O health check deve refletir o comportamento esperado do sistema.

Por outro lado, um endpoint de saúde excessivamente rígido pode retirar a instância do tráfego por causa de uma dependência não crítica. Por isso, é preciso definir quais componentes realmente determinam a disponibilidade.

**Exemplo prático:**  

O gateway verifica a saúde das instâncias do `pedido-service`. Uma instância que não consegue acessar uma dependência obrigatória pode ser retirada temporariamente do balanceamento.

Já uma falha no serviço de recomendações talvez não deva tornar o serviço principal indisponível se as recomendações forem opcionais.

**Exemplo de código:**  

Uma exposição restrita de endpoints pode ser configurada assim:

~~~yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info
~~~

Essa configuração não deve ser usada sem avaliar autenticação, rede e sensibilidade das informações expostas.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar o papel do Actuator;
- Citar health check e métricas;
- Falar sobre uso operacional;
- Destacar autenticação e restrição de exposição;
- Reconhecer que endpoints podem revelar informações sensíveis.

**Perguntas de aprofundamento:**  

1. Qual é a diferença entre uma aplicação viva e uma aplicação pronta para receber tráfego?
2. Você deixaria o endpoint `/actuator/env` exposto publicamente?
3. Como decidiria se uma dependência deve afetar o health check?

**Resposta fraca ou incompleta:**  

“Actuator mostra informações da aplicação e pode ser liberado em produção.”

A resposta é incompleta porque não trata health checks, métricas, autenticação, informações sensíveis nem restrição de acesso.

**Critérios de avaliação:**  

- **0:** Não conhece o objetivo do Actuator.
- **1:** Sabe apenas que ele mostra informações.
- **2:** Cita health check, mas ignora segurança.
- **3:** Explica corretamente o uso básico e os cuidados principais.
- **4:** Relaciona Actuator a observabilidade, descoberta e disponibilidade.
- **5:** Discute indicadores de saúde, dependências críticas, segurança, exposição seletiva e impacto no roteamento.

---

# Pergunta 18 — Logs e correlação de requisições

**Nível:** Júnior  
**Categoria:** Observabilidade

**Pergunta do entrevistador:**  
Uma requisição passa pelo gateway, pelo serviço de pedidos e pelo serviço de pagamentos. Como você facilitaria a investigação dessa requisição nos logs?

**O que essa pergunta avalia:**  

- Conhecimento sobre troubleshooting distribuído;
- Noções de correlação de requisições;
- Capacidade de pensar em observabilidade;
- Organização para investigar fluxos entre serviços.

**Resposta esperada:**  

Eu utilizaria um identificador de correlação, normalmente chamado de correlation ID ou request ID.

Esse identificador deveria:

1. Ser criado no início da requisição, caso ainda não exista;
2. Ser propagado pelo gateway;
3. Ser enviado nos headers das chamadas entre serviços;
4. Ser incluído nos logs de cada componente;
5. Ser utilizado para filtrar os registros relacionados àquela operação.

Também registraria informações úteis, como:

- Nome do serviço;
- Timestamp;
- Endpoint;
- Método HTTP;
- Status da resposta;
- Latência;
- Identificador da requisição;
- Identificador do usuário ou da operação, quando apropriado e permitido.

Não se deve registrar senhas, tokens completos ou dados pessoais desnecessários.

Além de logs, traces distribuídos e métricas podem ajudar a entender o fluxo completo.

**Explicação didática:**  

Sem correlação, uma única requisição pode gerar registros espalhados em vários serviços, tornando difícil saber quais logs pertencem à mesma operação.

Com um identificador como:

text X-Request-Id: 7f3a91


os serviços podem incluir esse valor em seus logs:

text gateway requestId=7f3a91 rota=/pedidos/10 status=200 pedido-service requestId=7f3a91 cliente=42 pagamento=iniciado pagamento-service requestId=7f3a91 status=aprovado


Assim, a equipe consegue reconstruir o fluxo.

O identificador não deve ser utilizado como substituto de autenticação. Ele serve para rastreamento, não para provar a identidade do usuário.

**Exemplo prático:**  

Um usuário informa que o pagamento foi recusado. A equipe solicita o identificador da operação ou localiza o request ID no gateway. Depois, consulta os logs dos serviços envolvidos usando o mesmo valor.

**Exemplo de código:**  

Um filtro simples pode propagar um header de correlação:

~~~java
@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String requestId = request.getHeader("X-Request-Id");

        if (requestId == null || requestId.isBlank()) {
            requestId = UUID.randomUUID().toString();
        }

        response.setHeader("X-Request-Id", requestId);

        // Em um projeto real, o valor também seria colocado
        // no contexto utilizado pelo sistema de logs.
        filterChain.doFilter(request, response);
    }
}
~~~

A implementação completa deve considerar limpeza do contexto e propagação para chamadas de saída.

**Como o candidato deve responder:**  

O candidato deve mencionar:

- Correlation ID ou request ID;
- Propagação entre serviços;
- Inclusão nos logs;
- Uso de filtros para investigação;
- Cuidados com dados sensíveis;
- Métricas e traces como complementos.

**Perguntas de aprofundamento:**  

1. O que aconteceria se cada serviço gerasse um novo identificador?
2. Quais informações você evitaria colocar nos logs?
3. Qual é a diferença entre correlation ID e trace distribuído?

**Resposta fraca ou incompleta:**  

“Eu procuraria nos logs pelo horário em que o erro aconteceu.”

O horário pode ajudar, mas não é suficiente em um sistema com muitas requisições simultâneas. Faltam correlação, propagação e cuidados com informações sensíveis.

**Critérios de avaliação:**  

- **0:** Não apresenta estratégia de investigação.
- **1:** Sugere apenas consultar logs por horário.
- **2:** Cita um identificador, mas não explica a propagação.
- **3:** Explica corretamente o uso de correlation ID.
- **4:** Considera logs estruturados, métricas, traces e segurança.
- **5:** Demonstra visão clara de observabilidade distribuída, contexto, amostragem, privacidade e análise de uma requisição ponta a ponta.

---

# Pergunta 19 — Falha de comunicação com um serviço

**Nível:** Júnior  
**Categoria:** Troubleshooting e resiliência

**Pergunta do entrevistador:**  
O serviço de pedidos começa a apresentar erros porque o serviço de pagamentos está indisponível. Como você investigaria e trataria esse cenário?

**O que essa pergunta avalia:**  

- Raciocínio de troubleshooting;
- Compreensão de dependências entre serviços;
- Capacidade de diferenciar causa e efeito;
- Noções de resiliência e resposta a incidentes.

**Resposta esperada:**  

Eu começaria confirmando o problema e identificando o impacto:

- Qual é a taxa de erro?
- Todas as requisições são afetadas?
- O problema ocorre apenas em uma instância?
- O erro é timeout, conexão recusada ou resposta HTTP?
- Quando o problema começou?

Depois investigaria:

- Saúde do serviço de pagamentos;
- Logs dos dois serviços;
- Métricas de latência e erros;
- Conectividade de rede;
- Configuração da URL e da porta;
- Certificados e autenticação;
- Saturação de recursos;
- Mudanças recentes;
- Estado do circuito de resiliência.

O tratamento dependeria da regra de negócio. Algumas opções são:

- Retornar erro controlado ao cliente;
- Utilizar fallback;
- Processar a operação de forma assíncrona;
- Colocar a operação em uma fila;
- Bloquear temporariamente novas tentativas;
- Ativar circuit breaker;
- Escalar ou recuperar o serviço de pagamentos.

Eu evitaria retentar indefinidamente, pois isso pode aumentar a sobrecarga e gerar falha em cascata.

**Explicação didática:**  

Em uma arquitetura distribuída, o erro observado em um serviço pode ter origem em outro.

Por exemplo:

mermaid sequenceDiagram participant C as Cliente participant G as Gateway participant P as Pedido participant F as Pagamento

C->>G: Criar pedido
G->>P: Encaminhar requisição
P->>F: Autorizar pagamento
F--xP: Timeout
P-->>G: Erro controlado
G-->>C: Resposta de indisponibilidade


O `pedido-service` pode estar funcionando normalmente, mas sua dependência externa está indisponível.

Uma investigação adequada deve separar:

- Sintoma;
- Causa provável;
- Impacto;
- Mitigação;
- Correção definitiva.

**Exemplo prático:**  

Se pagamentos forem obrigatórios para confirmar um pedido, o sistema talvez precise interromper a criação e informar indisponibilidade.

Se o pagamento puder ser processado posteriormente, o pedido pode ser criado com status `PAGAMENTO_PENDENTE`, e um evento pode iniciar o processamento assíncrono.

**Exemplo de código:**  

Um tratamento conceitual pode ser:

~~~java
public Pedido criarPedido(NovoPedido request) {
    try {
        pagamentoClient.autorizar(request.pagamento());
        return pedidoRepository.salvar(Pedido.confirmado(request));
    } catch (TimeoutException erro) {
        // O tratamento real depende da regra de negócio.
        return pedidoRepository.salvar(Pedido.pendente(request));
    }
}
~~~

O código não deve capturar qualquer exceção indiscriminadamente. É necessário diferenciar timeout, erro de validação, falha de autenticação e indisponibilidade.

**Como o candidato deve responder:**  

O candidato deve:

- Iniciar pela identificação do tipo de falha;
- Consultar logs, métricas e saúde dos serviços;
- Verificar configuração e rede;
- Considerar timeout e circuit breaker;
- Relacionar o tratamento à regra de negócio;
- Evitar soluções destrutivas ou retentativas ilimitadas.

**Perguntas de aprofundamento:**  

1. Como diferenciaria um timeout de um erro de autenticação?
2. Quando seria aceitável criar o pedido mesmo sem confirmar o pagamento?
3. Como monitoraria se a solução de fallback está sendo usada em excesso?

**Resposta fraca ou incompleta:**  

“Eu reiniciaria o serviço de pagamentos e tentaria novamente.”

Essa resposta não investiga a causa, não considera o impacto, não diferencia tipos de erro e pode agravar o problema com novas tentativas.

**Critérios de avaliação:**  

- **0:** Não apresenta estratégia de investigação.
- **1:** Sugere apenas reiniciar ou repetir a chamada.
- **2:** Cita logs, mas não propõe tratamento adequado.
- **3:** Investiga disponibilidade, rede, configuração e timeout.
- **4:** Considera circuit breaker, fallback, métricas e regra de negócio.
- **5:** Estrutura claramente diagnóstico, mitigação e correção definitiva, considerando consistência, impacto e riscos operacionais.

---

# Pergunta 20 — Quando não utilizar Spring Cloud

**Nível:** Júnior  
**Categoria:** Arquitetura e tomada de decisão

**Pergunta do entrevistador:**  
Em quais situações você evitaria adotar Spring Cloud em um projeto?

**O que essa pergunta avalia:**  

- Capacidade de analisar necessidade tecnológica;
- Compreensão de trade-offs;
- Conhecimento sobre complexidade operacional;
- Maturidade para não aplicar uma solução por padrão.

**Resposta esperada:**  

Eu evitaria adotar recursos do Spring Cloud quando eles não resolverem problemas reais do projeto.

Alguns exemplos são:

- Aplicação monolítica simples;
- Sistema pequeno com um único serviço;
- Baixa necessidade de escala independente;
- Equipe sem estrutura para operar vários serviços;
- Ausência de necessidade de descoberta, gateway ou configuração distribuída;
- Ambiente em que a própria plataforma já oferece essas capacidades;
- Projeto temporário ou protótipo no qual a complexidade adicional não se justifica.

Spring Cloud pode introduzir:

- Mais componentes;
- Mais configurações;
- Mais pontos de falha;
- Maior necessidade de observabilidade;
- Custo operacional;
- Dependência de compatibilidade entre versões;
- Complexidade para desenvolvimento e troubleshooting.

A decisão deve considerar requisitos de negócio, escala, disponibilidade, equipe, custos e infraestrutura.

**Explicação didática:**  

Tecnologias distribuídas resolvem problemas importantes, mas também criam novos problemas.

Uma aplicação com poucos usuários e uma única unidade de implantação talvez não precise de:

- Service discovery;
- API Gateway;
- Config Server;
- Comunicação entre dezenas de serviços;
- Circuit breakers para várias dependências.

Nesses casos, uma aplicação Spring Boot mais simples pode ser mais fácil de desenvolver, testar, implantar e manter.

O objetivo não deve ser utilizar o maior número possível de componentes, mas escolher uma arquitetura compatível com as necessidades reais.

**Exemplo prático:**  

Uma pequena aplicação interna possui:

- Um único backend;
- Poucos usuários;
- Baixa exigência de disponibilidade;
- Uma equipe pequena;
- Implantação em um único ambiente.

Adicionar gateway, descoberta, configuração distribuída e vários microsserviços pode aumentar a complexidade sem oferecer benefícios proporcionais.

Por outro lado, uma plataforma com muitos serviços, escala independente e múltiplas equipes pode justificar o uso de recursos Spring Cloud ou de soluções equivalentes da infraestrutura.

**Exemplo de código:**  

Neste cenário, uma configuração simples pode ser suficiente:

~~~yaml
spring:
  application:
    name: sistema-interno

server:
  port: 8080
~~~

Não seria necessário adicionar componentes distribuídos apenas porque fazem parte do ecossistema Spring Cloud.

**Como o candidato deve responder:**  

O candidato deve:

- Evitar dizer que Spring Cloud é obrigatório para microsserviços;
- Citar complexidade e custo operacional;
- Avaliar escala, equipe e requisitos;
- Reconhecer que a plataforma pode oferecer recursos equivalentes;
- Explicar que Spring Boot pode ser suficiente em projetos simples;
- Demonstrar preocupação com manutenção e operação.

A resposta deve mostrar que o candidato entende tecnologia como meio para resolver problemas, e não como objetivo isolado.

**Perguntas de aprofundamento:**  

1. Quais sinais indicariam que um monólito está começando a exigir separação?
2. Como você justificaria tecnicamente a adoção de um API Gateway?
3. Que custos adicionais surgem quando uma aplicação é dividida em microsserviços?

**Resposta fraca ou incompleta:**  

“Eu sempre usaria Spring Cloud porque microsserviços precisam dele.”

Essa resposta demonstra uma generalização incorreta e ignora alternativas, contexto, custos e recursos oferecidos pela infraestrutura.

**Critérios de avaliação:**  

- **0:** Afirma que Spring Cloud é sempre obrigatório.
- **1:** Não identifica situações em que a solução seria excessiva.
- **2:** Cita projetos pequenos, mas não explica os trade-offs.
- **3:** Explica corretamente que a adoção depende do contexto.
- **4:** Considera equipe, infraestrutura, custos, escala e manutenção.
- **5:** Demonstra maturidade arquitetural, compara alternativas e justifica a decisão com base em requisitos, riscos e impacto operacional.

---

## Resumo desta parte

- **Perguntas apresentadas:** 11 a 20
- **Perguntas restantes:** 80
- **Nível abordado:** Júnior
- **Categorias cobertas:**
  - Desempenho;
  - Balanceamento de carga;
  - Configuração por ambiente;
  - Atualização de configurações;
  - Comunicação entre serviços;
  - Contratos e versionamento;
  - Observabilidade;
  - Troubleshooting;
  - Resiliência;
  - Arquitetura.

## Matriz parcial de competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---:|---|
| Balanceamento de carga | Júnior | 11 | Entende múltiplas instâncias, distribuição de tráfego e escala horizontal |
| Configuração por ambiente | Júnior | 12 e 13 | Separa ambientes, protege segredos e entende o ciclo de atualização |
| Clientes HTTP declarativos | Júnior | 14 | Compreende interfaces de comunicação e cuidados com chamadas remotas |
| Contratos de integração | Júnior | 15 | Reconhece riscos de alterações incompatíveis |
| Versionamento de APIs | Júnior | 16 | Propõe migração gradual e coexistência de versões |
| Health checks e Actuator | Júnior | 17 | Relaciona saúde da aplicação a roteamento e disponibilidade |
| Observabilidade distribuída | Júnior | 18 | Utiliza IDs de correlação, logs e métricas para rastrear requisições |
| Diagnóstico de falhas | Júnior | 19 | Investiga rede, configuração, dependências e comportamento da aplicação |
| Avaliação arquitetural | Júnior | 20 | Entende que Spring Cloud deve ser adotado somente quando houver necessidade |

## Recomendações específicas para o entrevistador

- Peça ao candidato para desenhar o fluxo de uma requisição entre gateway e serviços.
- Ao avaliar configuração, pergunte sempre como ele protegeria segredos.
- Não considere memorização de propriedades YAML como evidência suficiente de domínio.
- Verifique se o candidato entende que chamadas remotas podem falhar.
- Explore se ele diferencia erro funcional, erro de rede e indisponibilidade.
- Observe se ele propõe reinicializações ou retentativas como resposta automática para qualquer problema.
- Pergunte como ele comprovaria que uma hipótese de troubleshooting está correta.
- Avalie se o candidato consegue explicar os trade-offs de adicionar componentes distribuídos.


---

# Roteiro de Entrevista Técnica — Spring Cloud

## Perguntas 21 a 30

> Continuação do roteiro para avaliação de nível Júnior, com perguntas conceituais, práticas e baseadas em cenários reais.

---

# Pergunta 21 — Service Registry

**Nível:** Júnior  
**Categoria:** Service Discovery

**Pergunta do entrevistador:**  
Qual é a função de um Service Registry em uma arquitetura baseada em Spring Cloud?

**O que essa pergunta avalia:**  

- Compreensão do registro de serviços;
- Conhecimento sobre localização dinâmica de instâncias;
- Entendimento da comunicação entre microsserviços;
- Capacidade de diferenciar registro e descoberta.

**Pergunta de aprofundamento:**  

1. O que pode acontecer se o Service Registry ficar indisponível?
2. Como uma instância informa que deixou de estar saudável?
3. Qual é a diferença entre registrar um serviço e descobrir um serviço?

**Resposta esperada:**  

O Service Registry é um componente que mantém informações sobre os serviços disponíveis e suas instâncias.

Quando uma aplicação é iniciada, ela pode registrar:

- Nome lógico do serviço;
- Hostname ou endereço IP;
- Porta;
- Status;
- Metadados;
- Informações de saúde.

Outros serviços podem consultar o registro para descobrir onde está uma instância disponível, evitando configurações fixas com endereços específicos.

O Registry normalmente é composto por duas operações principais:

- **Registro:** a instância informa que está disponível;
- **Descoberta:** outro serviço consulta quais instâncias podem ser utilizadas.

A solução concreta pode variar. Exemplos comuns incluem Eureka, Consul, Kubernetes Service Discovery ou mecanismos equivalentes da infraestrutura.

**Explicação didática:**  

Sem um registro, o serviço de pedidos poderia precisar conhecer diretamente o endereço de cada instância do serviço de pagamentos.

Com um registro, ele pode utilizar um nome lógico, como:

~~~text
pagamento-service
~~~

O mecanismo de descoberta consulta quais instâncias estão disponíveis e encaminha a chamada para uma delas.

É importante entender que o Registry não garante sozinho que uma chamada será bem-sucedida. Ainda podem ocorrer problemas de rede, autenticação, timeout ou falhas internas no serviço.

**Exemplo prático:**  

Duas instâncias do `pagamento-service` estão executando:

~~~text
pagamento-service -> 10.0.0.20:8080
pagamento-service -> 10.0.0.21:8080
~~~

O `pedido-service` utiliza o nome `pagamento-service`, e o mecanismo de descoberta retorna uma das instâncias disponíveis.

**Exemplo de código:**  

Uma identificação básica do serviço pode ser configurada assim:

~~~yaml
spring:
  application:
    name: pagamento-service
~~~

O registro automático depende do mecanismo de descoberta, das dependências utilizadas e da versão do Spring Cloud.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar que o Registry mantém informações sobre serviços;
- Diferenciar registro de descoberta;
- Mencionar instâncias e endereços dinâmicos;
- Explicar por que nomes lógicos são úteis;
- Reconhecer que o registro não elimina falhas de rede;
- Evitar afirmar que todo projeto precisa utilizar um Registry.

**Resposta fraca ou incompleta:**  

“É um lugar onde ficam salvos os serviços.”

A resposta é superficial porque não explica quais informações são armazenadas, como ocorre a descoberta nem por que isso é útil em ambientes com múltiplas instâncias.

**Critérios de avaliação:**  

- **0:** Não sabe explicar o conceito.
- **1:** Sabe apenas que existe um cadastro de serviços.
- **2:** Entende parcialmente o cadastro, mas não explica a descoberta.
- **3:** Explica corretamente registro, descoberta e nomes lógicos.
- **4:** Relaciona o Registry a múltiplas instâncias, saúde e balanceamento.
- **5:** Discute consistência, disponibilidade, health checks, alternativas de infraestrutura e comportamento durante falhas.

---

# Pergunta 22 — Eureka Client e Eureka Server

**Nível:** Júnior  
**Categoria:** Service Discovery

**Pergunta do entrevistador:**  
Qual é a diferença entre um Eureka Server e um Eureka Client?

**O que essa pergunta avalia:**  

- Conhecimento básico do ecossistema Eureka;
- Compreensão da relação entre servidor e consumidor;
- Capacidade de explicar o fluxo de registro;
- Noções de dependência entre componentes.

**Pergunta de aprofundamento:**  

1. O que acontece quando uma aplicação inicia como Eureka Client?
2. Um serviço pode ser client e server ao mesmo tempo?
3. Que cuidados devem existir em produção ao executar o Eureka Server?

**Resposta esperada:**  

O **Eureka Server** atua como registro de serviços. Ele mantém informações sobre as aplicações que se registraram e permite que clientes consultem as instâncias disponíveis.

O **Eureka Client** é uma aplicação que se registra no Eureka Server e pode consultar outros serviços registrados.

Em uma arquitetura típica:

1. O `pedido-service` inicia como Eureka Client;
2. Ele se registra no Eureka Server;
3. O `pagamento-service` também se registra;
4. O `pedido-service` consulta o registro para localizar o `pagamento-service`;
5. A comunicação ocorre utilizando a instância encontrada.

A configuração exata depende da versão do Spring Boot, do Spring Cloud e das dependências utilizadas.

**Explicação didática:**  

O Eureka Server funciona como uma lista centralizada de serviços. Os clientes informam onde estão e consultam onde estão os demais.

Um serviço pode ser simultaneamente cliente e servidor em determinados cenários, mas isso não é necessariamente recomendado. Em arquiteturas maiores, normalmente o servidor de registro é tratado como um componente próprio, com disponibilidade e operação independentes.

O Eureka Server também precisa ser protegido, monitorado e executado de maneira resiliente.

**Exemplo prático:**  

Um Eureka Server está disponível em:

~~~text
http://discovery-server:8761
~~~

O `pedido-service` e o `pagamento-service` informam que devem utilizar esse servidor para registro e descoberta.

**Exemplo de código:**  

Uma configuração conceitual do endereço do servidor pode ser:

~~~yaml
eureka:
  client:
    service-url:
      defaultZone: http://discovery-server:8761/eureka/
~~~

O nome das propriedades pode variar conforme a versão adotada.

**Como o candidato deve responder:**  

O candidato deve:

- Definir o Eureka Server como registro;
- Definir o Eureka Client como aplicação que se registra e consulta;
- Explicar o fluxo entre os componentes;
- Mencionar que a configuração depende da versão;
- Considerar disponibilidade e segurança do servidor.

**Resposta fraca ou incompleta:**  

“Eureka Server é o servidor e Eureka Client é o cliente que acessa.”

Essa resposta apenas repete os nomes e não explica o papel de registro e descoberta.

**Critérios de avaliação:**  

- **0:** Confunde completamente os componentes.
- **1:** Sabe apenas que um é servidor e o outro é cliente.
- **2:** Entende o registro, mas não explica a descoberta.
- **3:** Explica corretamente a relação entre Server e Client.
- **4:** Inclui inicialização, consulta, disponibilidade e configuração.
- **5:** Discute alternativas, escalabilidade, consistência, segurança e riscos de depender de uma única instância.

---

# Pergunta 23 — Heartbeat e instâncias obsoletas

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Como um mecanismo de descoberta pode identificar que uma instância de serviço deixou de estar disponível?

**O que essa pergunta avalia:**  

- Noções de heartbeat;
- Compreensão de health checks;
- Capacidade de diagnosticar instâncias obsoletas;
- Entendimento das diferenças entre processo ativo e serviço saudável.

**Pergunta de aprofundamento:**  

1. O que pode acontecer se uma instância não enviar mais heartbeats?
2. Por que uma instância pode parecer disponível, mas continuar falhando?
3. Como você investigaria registros obsoletos no Service Registry?

**Resposta esperada:**  

Um mecanismo de descoberta pode utilizar heartbeats, health checks ou ambos.

O heartbeat é uma comunicação periódica usada para indicar que a instância continua ativa. Se o registro deixa de receber esses sinais dentro de determinado período, pode marcar ou remover a instância.

Um health check pode validar se a aplicação está apta a atender requisições. Dependendo da configuração, ele pode verificar:

- Se o processo está vivo;
- Se a aplicação aceita conexões;
- Se dependências essenciais estão disponíveis;
- Se endpoints específicos respondem corretamente.

Uma instância pode continuar registrada mesmo estando com problemas se o mecanismo de saúde estiver mal configurado ou se os tempos de expiração forem inadequados.

**Explicação didática:**  

O heartbeat responde principalmente à pergunta:

> “A instância ainda está comunicando?”

Já o health check pode responder:

> “A instância está apta a atender requisições?”

Essas perguntas não são exatamente iguais.

Uma aplicação pode continuar enviando heartbeat, mas retornar erro em todas as chamadas porque o banco de dados está indisponível.

**Exemplo prático:**  

Uma instância é encerrada abruptamente, mas continua aparecendo no registro por alguns segundos ou minutos. Durante esse período, o balanceador pode encaminhar requisições para ela, causando erros.

A equipe deve avaliar o intervalo de heartbeat, o tempo de expiração e o comportamento do health check.

**Exemplo de código:**  

Uma configuração conceitual de health endpoint pode ser:

~~~yaml
management:
  endpoints:
    web:
      exposure:
        include: health
~~~

A exposição deve ser protegida e restrita conforme o ambiente.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar heartbeat e health check;
- Diferenciar processo ativo de serviço funcional;
- Mencionar expiração ou remoção de instâncias;
- Considerar atrasos e informações desatualizadas;
- Falar sobre investigação por logs e métricas.

**Resposta fraca ou incompleta:**  

“O Registry sabe que a aplicação caiu porque verifica automaticamente.”

A resposta não explica como ocorre a verificação nem considera atrasos, configurações incorretas e diferenças entre estar ativo e estar saudável.

**Critérios de avaliação:**  

- **0:** Não conhece nenhuma forma de verificar disponibilidade.
- **1:** Menciona apenas reinicialização.
- **2:** Cita health check, mas não explica o funcionamento.
- **3:** Explica heartbeat, health check e remoção de instâncias.
- **4:** Diferencia liveness e readiness e relaciona o tema ao balanceamento.
- **5:** Analisa janelas de expiração, falsos positivos, consistência e impactos de registros obsoletos.

---

# Pergunta 24 — Liveness e readiness

**Nível:** Júnior  
**Categoria:** Observabilidade e disponibilidade

**Pergunta do entrevistador:**  
Qual é a diferença entre liveness e readiness em uma aplicação distribuída?

**O que essa pergunta avalia:**  

- Compreensão de saúde de aplicações;
- Noções de disponibilidade;
- Capacidade de definir verificações adequadas;
- Entendimento de impactos no roteamento.

**Pergunta de aprofundamento:**  

1. Uma falha no banco deve sempre tornar a aplicação não viva?
2. Quando uma aplicação pode estar viva, mas não pronta?
3. Como uma configuração incorreta de readiness pode causar indisponibilidade?

**Resposta esperada:**  

**Liveness** indica se o processo está vivo e deve continuar executando. Uma falha de liveness pode indicar que a aplicação travou ou entrou em um estado irrecuperável, justificando reinicialização.

**Readiness** indica se a aplicação está pronta para receber tráfego. Uma aplicação pode estar viva, mas ainda estar inicializando ou sem acesso a uma dependência obrigatória.

Por exemplo:

- Aplicação viva, mas ainda carregando configurações: não está pronta;
- Aplicação viva, mas banco obrigatório indisponível: pode não estar pronta;
- Aplicação viva e com dependências necessárias disponíveis: está pronta.

A decisão sobre quais dependências afetam a readiness depende da regra de negócio.

**Explicação didática:**  

O fluxo pode ser representado assim:

~~~mermaid
flowchart TD
    A[Aplicação inicia] --> B{Processo está funcionando?}
    B -- Não --> C[Liveness falha]
    B -- Sim --> D{Está pronta para receber tráfego?}
    D -- Não --> E[Readiness falha]
    D -- Sim --> F[Recebe requisições]
~~~

Confundir os dois conceitos pode causar problemas. Se uma aplicação não estiver pronta, talvez seja suficiente retirá-la do balanceamento. Se estiver travada, pode ser necessário reiniciá-la.

**Exemplo prático:**  

Durante a inicialização, o serviço de pedidos demora para carregar configurações. Ele está em execução, mas não deve receber chamadas antes de concluir o carregamento.

**Exemplo de código:**  

Uma configuração relacionada a probes pode variar conforme a infraestrutura, mas endpoints de saúde podem ser expostos assim:

~~~yaml
management:
  endpoint:
    health:
      probes:
        enabled: true
~~~

A configuração final deve ser compatível com a versão e com a plataforma de execução.

**Como o candidato deve responder:**  

O candidato deve:

- Definir liveness;
- Definir readiness;
- Apresentar um exemplo;
- Explicar o impacto sobre tráfego e reinicialização;
- Evitar transformar qualquer erro de dependência em falha de liveness automaticamente.

**Resposta fraca ou incompleta:**  

“Liveness e readiness são dois tipos de health check iguais.”

A resposta não diferencia reinicialização de disponibilidade para receber tráfego.

**Critérios de avaliação:**  

- **0:** Não diferencia os conceitos.
- **1:** Reconhece que são verificações, mas não explica seus objetivos.
- **2:** Diferencia parcialmente, com exemplos pouco claros.
- **3:** Explica corretamente liveness e readiness.
- **4:** Relaciona os conceitos a balanceamento, inicialização e dependências.
- **5:** Analisa critérios de saúde, falsos positivos, reinicializações e impactos operacionais.

---

# Pergunta 25 — Configuração de propriedades

**Nível:** Júnior  
**Categoria:** Configuração e prática

**Pergunta do entrevistador:**  
Como você faria uma aplicação Spring Boot consumir uma configuração externa relacionada ao Spring Cloud?

**O que essa pergunta avalia:**  

- Leitura e organização de configurações;
- Conhecimento sobre injeção de propriedades;
- Capacidade de separar configuração e código;
- Noções de validação de valores.

**Pergunta de aprofundamento:**  

1. Como você validaria que uma propriedade obrigatória foi configurada?
2. Qual é a diferença entre `@Value` e `@ConfigurationProperties`?
3. Onde armazenaria valores sensíveis?

**Resposta esperada:**  

A aplicação pode receber propriedades por arquivos de configuração, variáveis de ambiente, argumentos de execução ou um servidor de configuração centralizada.

Para pequenos usos, é possível utilizar `@Value`. Para grupos maiores e relacionados de propriedades, `@ConfigurationProperties` costuma oferecer melhor organização e possibilidade de validação.

Exemplo de configuração:

~~~yaml
app:
  pagamento:
    timeout-ms: 3000
    url: http://pagamento-service
~~~

A aplicação pode mapear essas propriedades para uma classe dedicada.

É importante:

- Validar valores obrigatórios;
- Definir valores padrão quando apropriado;
- Não colocar segredos em código ou repositórios públicos;
- Diferenciar ambientes;
- Documentar o significado das propriedades.

**Explicação didática:**  

A configuração representa valores que podem mudar sem alterar a lógica principal da aplicação.

Uma classe específica para propriedades facilita a manutenção:

~~~java
@ConfigurationProperties(prefix = "app.pagamento")
public class PagamentoProperties {

    private int timeoutMs;
    private String url;

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
~~~

O mecanismo de registro dessa classe depende da configuração do projeto.

**Exemplo prático:**  

Em desenvolvimento, a URL pode apontar para um serviço local. Em produção, pode utilizar um nome de serviço descoberto pela infraestrutura.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar que a configuração pode vir de fontes externas;
- Mostrar como agrupar propriedades;
- Mencionar validação;
- Falar sobre profiles e ambientes;
- Proteger valores sensíveis;
- Evitar deixar URLs e credenciais fixas no código.

**Resposta fraca ou incompleta:**  

“Eu colocaria o valor diretamente na classe para ficar mais fácil.”

Essa abordagem dificulta a alteração por ambiente e mistura configuração com lógica de negócio.

**Critérios de avaliação:**  

- **0:** Não sabe consumir propriedades.
- **1:** Conhece apenas valores fixos no código.
- **2:** Conhece arquivos YAML, mas não organização ou validação.
- **3:** Explica corretamente propriedades externas e injeção.
- **4:** Usa classes de configuração, profiles e validação.
- **5:** Discute governança, segredos, precedência, compatibilidade e alteração segura em produção.

---

# Pergunta 26 — Precedência de configurações

**Nível:** Júnior  
**Categoria:** Configuração e troubleshooting

**Pergunta do entrevistador:**  
Uma propriedade está definida em mais de um lugar e a aplicação apresenta um valor diferente do esperado. Como você investigaria o problema?

**O que essa pergunta avalia:**  

- Conhecimento sobre fontes de configuração;
- Raciocínio de troubleshooting;
- Capacidade de identificar conflitos;
- Noções de precedência e ambiente.

**Pergunta de aprofundamento:**  

1. Quais fontes de configuração você verificaria primeiro?
2. Como evitaria que uma variável de ambiente sobrescrevesse um valor importante sem intenção?
3. Como documentaria a origem de uma configuração?

**Resposta esperada:**  

Eu verificaria todas as fontes que podem fornecer a propriedade, como:

- Arquivos de configuração;
- Arquivos específicos de profile;
- Servidor de configuração;
- Variáveis de ambiente;
- Argumentos de linha de comando;
- Configurações da plataforma de implantação;
- Valores padrão no código.

Depois, verificaria a precedência definida pela versão e pelo mecanismo de configuração adotado. Também confirmaria:

- Qual profile está ativo;
- Qual ambiente está sendo executado;
- Se a propriedade foi escrita com o nome correto;
- Se existe erro de indentação no YAML;
- Se alguma variável está sendo injetada automaticamente;
- Se houve atualização parcial entre instâncias.

A investigação deve ser feita com cuidado para não expor credenciais ou valores sensíveis.

**Explicação didática:**  

É comum uma propriedade existir em mais de uma fonte. Por exemplo:

~~~yaml
app:
  pagamento:
    timeout-ms: 3000
~~~

Mas uma variável de ambiente pode definir outro valor:

~~~text
APP_PAGAMENTO_TIMEOUT_MS=5000
~~~

Dependendo da precedência, o valor da variável de ambiente poderá prevalecer.

O candidato não precisa memorizar toda a ordem de precedência, mas deve saber que ela existe e que a versão utilizada deve ser consultada.

**Exemplo prático:**  

A equipe espera timeout de 3 segundos, mas as métricas mostram 10 segundos. A investigação descobre que a configuração da plataforma está sobrescrevendo o arquivo centralizado.

**Como o candidato deve responder:**  

O candidato deve:

- Listar as possíveis fontes;
- Verificar o profile ativo;
- Considerar variáveis de ambiente e argumentos;
- Consultar a documentação da versão;
- Usar logs ou informações operacionais com cuidado;
- Evitar alterar valores aleatoriamente sem identificar a origem.

**Resposta fraca ou incompleta:**  

“Eu mudaria o valor no arquivo YAML até funcionar.”

Essa abordagem não identifica a fonte real do problema e pode gerar efeitos diferentes em cada ambiente.

**Critérios de avaliação:**  

- **0:** Não sabe investigar configurações conflitantes.
- **1:** Verifica apenas um arquivo.
- **2:** Cita profiles, mas ignora outras fontes.
- **3:** Investiga arquivos, profiles, ambiente e precedência.
- **4:** Considera implantação, múltiplas instâncias e segurança.
- **5:** Conduz uma investigação sistemática e propõe governança para evitar configurações conflitantes.

---

# Pergunta 27 — Spring Cloud Config e segredos

**Nível:** Júnior  
**Categoria:** Segurança e configuração

**Pergunta do entrevistador:**  
Você armazenaria senhas e tokens diretamente em um repositório utilizado pelo Spring Cloud Config? Explique sua decisão.

**O que essa pergunta avalia:**  

- Consciência de segurança;
- Conhecimento sobre gestão de segredos;
- Capacidade de reconhecer riscos de versionamento;
- Compreensão de controle de acesso.

**Pergunta de aprofundamento:**  

1. Quais alternativas você consideraria para armazenar segredos?
2. O que faria se uma senha fosse publicada acidentalmente?
3. Criptografar um arquivo no repositório resolve todos os problemas?

**Resposta esperada:**  

Eu não armazenaria segredos em texto puro em um repositório de configuração.

Senhas, tokens, chaves privadas e credenciais devem ser tratados por mecanismos específicos de gestão de segredos, como:

- Secret manager da plataforma;
- Cofre de segredos;
- Kubernetes Secrets com proteção adequada;
- Variáveis de ambiente gerenciadas de forma segura;
- Solução de criptografia e controle de acesso.

A proteção deve incluir:

- Controle de permissões;
- Rotação de credenciais;
- Auditoria;
- Restrição de acesso;
- Não exposição em logs;
- Revogação em caso de vazamento.

A criptografia de arquivos pode ajudar, mas as chaves de descriptografia também precisam ser protegidas.

**Explicação didática:**  

Um repositório pode ter histórico. Mesmo que uma senha seja removida posteriormente, ela pode continuar disponível em commits antigos, cópias locais ou caches.

Além disso, uma aplicação pode expor acidentalmente configurações por logs, endpoints administrativos ou mensagens de erro.

O ideal é manter no repositório apenas uma referência ao segredo, e não o segredo em si.

**Exemplo prático:**  

Em vez de salvar:

~~~yaml
database:
  password: senha-super-secreta
~~~

a configuração poderia indicar que a senha será fornecida pelo ambiente:

~~~yaml
database:
  password: ${DB_PASSWORD}
~~~

A forma de fornecer `DB_PASSWORD` deve ser controlada pela infraestrutura.

**Como o candidato deve responder:**  

O candidato deve:

- Responder claramente que não deve guardar segredos em texto puro;
- Explicar riscos de repositórios e histórico;
- Citar secret managers ou mecanismos equivalentes;
- Mencionar rotação e revogação;
- Evitar afirmar que apenas esconder o arquivo é suficiente.

**Resposta fraca ou incompleta:**  

“Eu colocaria a senha no arquivo, mas deixaria o repositório privado.”

Um repositório privado reduz exposição, mas não elimina riscos internos, históricos, cópias, permissões excessivas ou vazamentos acidentais.

**Critérios de avaliação:**  

- **0:** Recomenda publicar segredos em texto puro.
- **1:** Reconhece algum risco, mas mantém a prática.
- **2:** Sugere repositório privado sem discutir gestão de segredos.
- **3:** Recomenda não armazenar segredos diretamente.
- **4:** Cita secret manager, controle de acesso, rotação e não exposição em logs.
- **5:** Demonstra visão de segurança completa, incluindo histórico, revogação, auditoria, princípio do menor privilégio e resposta a vazamentos.

---

# Pergunta 28 — Segurança no API Gateway

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Quais responsabilidades de segurança podem ser implementadas em um API Gateway e quais responsabilidades devem permanecer nos microsserviços?

**O que essa pergunta avalia:**  

- Noções de segurança em camadas;
- Compreensão do papel do gateway;
- Capacidade de separar autenticação e autorização;
- Identificação de riscos de confiar apenas na borda.

**Pergunta de aprofundamento:**  

1. Por que os serviços internos não devem confiar cegamente em qualquer header enviado pelo cliente?
2. Onde você validaria a permissão para alterar um pedido?
3. Como protegeria a comunicação entre o gateway e os serviços?

**Resposta esperada:**  

O gateway pode executar responsabilidades transversais, como:

- Autenticação inicial;
- Validação de tokens;
- Rate limiting;
- Bloqueio de padrões suspeitos;
- Controle de tamanho de requisições;
- Aplicação de políticas comuns;
- Registro de acessos;
- CORS, quando aplicável.

Entretanto, os microsserviços também devem validar autorização relacionada ao próprio domínio.

Por exemplo, o gateway pode confirmar que o token é válido, mas o serviço de pedidos deve verificar se o usuário tem permissão para alterar determinado pedido.

A segurança deve ser feita em camadas. Os serviços internos não devem confiar cegamente em headers recebidos, especialmente se puderem ser acessados por outros caminhos.

**Explicação didática:**  

Autenticação responde:

> “Quem é o usuário?”

Autorização responde:

> “Esse usuário pode executar esta ação?”

O gateway pode ajudar na autenticação, mas nem sempre conhece as regras específicas de cada domínio.

Um serviço de pagamentos sabe quais operações um determinado perfil pode executar. Por isso, ele precisa participar da decisão de autorização.

**Exemplo prático:**  

Um usuário autenticado solicita:

~~~text
PUT /pedidos/100
~~~

O gateway valida o token. O `pedido-service` verifica se o pedido 100 pertence ao usuário ou se ele possui uma permissão administrativa.

**Como o candidato deve responder:**  

O candidato deve:

- Diferenciar autenticação e autorização;
- Citar responsabilidades do gateway;
- Explicar que os serviços devem validar regras de domínio;
- Mencionar comunicação segura;
- Alertar sobre confiança indevida em headers;
- Evitar centralizar toda a segurança exclusivamente no gateway.

**Resposta fraca ou incompleta:**  

“O gateway valida o token e os serviços não precisam fazer mais nada.”

Essa abordagem é perigosa porque um serviço pode ser acessado por outro caminho ou receber dados falsificados.

**Critérios de avaliação:**  

- **0:** Recomenda confiar totalmente no gateway sem validação adicional.
- **1:** Sabe apenas que o gateway valida tokens.
- **2:** Cita autenticação, mas não diferencia autorização.
- **3:** Explica segurança básica no gateway e nos serviços.
- **4:** Discute autorização por domínio, headers e comunicação interna.
- **5:** Demonstra compreensão de defesa em profundidade, menor privilégio, identidade de serviço e ameaças internas.

---

# Pergunta 29 — Rate limiting

**Nível:** Júnior  
**Categoria:** Segurança e desempenho

**Pergunta do entrevistador:**  
O que é rate limiting e em que situações ele pode ser útil em um API Gateway?

**O que essa pergunta avalia:**  

- Compreensão de controle de tráfego;
- Noções de proteção contra abuso;
- Relação entre segurança, desempenho e disponibilidade;
- Capacidade de analisar limites.

**Pergunta de aprofundamento:**  

1. Como você escolheria um limite adequado?
2. O rate limiting deve ser aplicado por IP, usuário, token ou rota?
3. O que aconteceria se o limite fosse configurado muito baixo?

**Resposta esperada:**  

Rate limiting é o controle da quantidade de requisições que um cliente pode realizar em determinado período.

Ele pode ser utilizado para:

- Evitar abuso;
- Proteger serviços contra excesso de tráfego;
- Reduzir impacto de ataques automatizados;
- Controlar consumo de APIs públicas;
- Garantir uma distribuição mais justa de recursos;
- Evitar que um cliente monopolize a capacidade do sistema.

O limite pode ser definido por:

- Endereço IP;
- Usuário;
- Token;
- Cliente;
- Rota;
- Organização;
- Combinação desses critérios.

A escolha depende do contexto. Um limite muito baixo pode bloquear usuários legítimos. Um limite muito alto pode não proteger adequadamente o sistema.

**Explicação didática:**  

Um gateway pode permitir, por exemplo, 100 requisições por minuto para determinado cliente. Ao ultrapassar esse limite, pode retornar:

~~~text
HTTP 429 Too Many Requests
~~~

O cliente deve tratar essa resposta adequadamente.

Rate limiting não substitui autenticação, autorização ou proteção contra ataques distribuídos. Ele é uma camada adicional de defesa.

**Exemplo prático:**  

Uma API de consulta pública está sendo utilizada por um robô que faz milhares de chamadas por minuto. O gateway aplica limites por cliente para proteger a aplicação e o banco de dados.

**Como o candidato deve responder:**  

O candidato deve:

- Definir rate limiting;
- Citar proteção contra abuso e sobrecarga;
- Explicar que o limite deve considerar o contexto;
- Mencionar a resposta HTTP 429;
- Considerar usuários legítimos e clientes prioritários;
- Evitar tratar rate limiting como solução completa de segurança.

**Resposta fraca ou incompleta:**  

“Rate limiting bloqueia pessoas que fazem muitas requisições.”

A resposta não explica o objetivo, os critérios, os impactos nem a necessidade de configurar limites adequados.

**Critérios de avaliação:**  

- **0:** Não sabe explicar o conceito.
- **1:** Sabe apenas que limita requisições.
- **2:** Reconhece proteção contra excesso, mas não discute critérios.
- **3:** Explica corretamente rate limiting e seus benefícios.
- **4:** Considera clientes, rotas, resposta 429 e impacto nos usuários.
- **5:** Discute algoritmos, distribuição, clientes prioritários, ataques distribuídos, observabilidade e trade-offs.

---

# Pergunta 30 — CORS no Gateway

**Nível:** Júnior  
**Categoria:** Segurança e integração

**Pergunta do entrevistador:**  
O que é CORS e que cuidados você teria ao configurá-lo em um API Gateway?

**O que essa pergunta avalia:**  

- Conhecimento básico de segurança web;
- Compreensão de integração entre frontend e backend;
- Capacidade de evitar configurações permissivas;
- Noções de preflight e origens.

**Pergunta de aprofundamento:**  

1. Por que permitir qualquer origem pode ser perigoso?
2. O que é uma requisição preflight?
3. CORS substitui autenticação?

**Resposta esperada:**  

CORS, ou Cross-Origin Resource Sharing, é um mecanismo do navegador que controla se uma aplicação web pode realizar requisições para uma origem diferente daquela que serviu a página.

No gateway, a configuração deve considerar:

- Origens permitidas;
- Métodos HTTP permitidos;
- Headers permitidos;
- Headers expostos;
- Uso de credenciais;
- Tempo de cache da resposta preflight;
- Diferenças entre ambientes.

Não é recomendável permitir qualquer origem indiscriminadamente, especialmente quando há credenciais ou dados sensíveis.

CORS é uma política aplicada pelos navegadores. Ele não substitui autenticação, autorização ou controles de acesso no servidor.

**Explicação didática:**  

Considere um frontend hospedado em:

~~~text
https://app.exemplo.com
~~~

que tenta chamar uma API em:

~~~text
https://api.exemplo.com
~~~

Embora pertençam ao mesmo domínio principal, são origens diferentes. O navegador verifica se a API autoriza essa comunicação.

Em alguns casos, antes da requisição principal, o navegador envia uma requisição `OPTIONS`, chamada preflight, para verificar se método e headers são permitidos.

**Exemplo prático:**  

O frontend envia uma requisição com:

~~~http
Authorization: Bearer token
Content-Type: application/json
~~~

O gateway precisa estar configurado para permitir a origem correta e os headers necessários, sem liberar origens desconhecidas de forma ampla.

**Exemplo de código:**  

Uma configuração conceitual pode ser:

~~~yaml
spring:
  cloud:
    gateway:
      globalcors:
        cors-configurations:
          '[/**]':
            allowedOrigins:
              - "https://app.exemplo.com"
            allowedMethods:
              - GET
              - POST
              - PUT
              - DELETE
            allowedHeaders:
              - Authorization
              - Content-Type
~~~

A sintaxe e as propriedades podem variar conforme a versão do Spring Cloud Gateway.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar CORS como controle de origens no navegador;
- Citar origens, métodos e headers;
- Mencionar preflight;
- Alertar contra `*` em cenários sensíveis;
- Explicar que CORS não substitui autenticação;
- Considerar diferenças entre desenvolvimento e produção.

**Resposta fraca ou incompleta:**  

“CORS serve para permitir que qualquer frontend acesse a API.”

Essa resposta é incorreta porque CORS deve restringir origens conforme a necessidade e não representa um mecanismo de autenticação.

**Critérios de avaliação:**  

- **0:** Apresenta uma definição incorreta e recomenda liberar tudo.
- **1:** Sabe apenas que CORS está relacionado ao frontend.
- **2:** Conhece origens, mas ignora métodos, headers e segurança.
- **3:** Explica corretamente o objetivo básico do CORS.
- **4:** Considera preflight, credenciais, origens específicas e ambientes.
- **5:** Discute políticas restritivas, exposição de headers, integração com autenticação, riscos de configuração e diferenças entre navegador e chamadas servidor-servidor.

---

## Resumo desta parte

- **Perguntas apresentadas:** 21 a 30
- **Perguntas restantes:** 70
- **Nível abordado:** Júnior
- **Categorias cobertas:**
  - Service Discovery;
  - Eureka;
  - Heartbeat;
  - Health checks;
  - Liveness e readiness;
  - Configuração;
  - Precedência de propriedades;
  - Segurança;
  - Gestão de segredos;
  - Rate limiting;
  - CORS.

## Matriz parcial de competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---:|---|
| Service Registry | Júnior | 21 e 22 | Diferencia registro, descoberta, client e server |
| Saúde de instâncias | Júnior | 23 e 24 | Compreende heartbeat, health checks, liveness e readiness |
| Configuração externa | Júnior | 25 e 26 | Organiza propriedades e investiga conflitos de configuração |
| Segurança de segredos | Júnior | 27 | Evita credenciais em texto puro e conhece gestão básica de segredos |
| Segurança no gateway | Júnior | 28 | Diferencia autenticação de autorização e entende segurança em camadas |
| Controle de tráfego | Júnior | 29 | Compreende rate limiting, resposta 429 e proteção contra abuso |
| Integração web segura | Júnior | 30 | Explica CORS, origens, headers, métodos e preflight |

## Recomendações específicas para o entrevistador

- Verifique se o candidato diferencia “serviço registrado” de “serviço realmente saudável”.
- Pergunte como ele investigaria uma instância antiga ainda recebendo tráfego.
- Explore se o candidato entende que o gateway não deve concentrar toda a lógica de autorização.
- Em perguntas de segurança, avalie princípios e não apenas nomes de ferramentas.
- Pergunte sempre onde os segredos seriam armazenados.
- Observe se o candidato entende que CORS é uma política do navegador, não um substituto de autenticação.
- Peça exemplos de consequências de configurações permissivas.
- Confirme se o candidato consegue relacionar configurações a ambientes diferentes.

---

# Roteiro de Entrevista Técnica — Spring Cloud

## Perguntas 31 a 40

> Continuação do roteiro para avaliação de nível Júnior, com perguntas conceituais, práticas e baseadas em cenários reais.

---

# Pergunta 31 — Predicados e filtros no Spring Cloud Gateway

**Nível:** Júnior  
**Categoria:** Gateway e roteamento

**Pergunta do entrevistador:**  
Qual é a diferença entre um predicado e um filtro em uma rota do Spring Cloud Gateway?

**O que essa pergunta avalia:**  

- Compreensão da estrutura de uma rota;
- Conhecimento básico sobre roteamento;
- Capacidade de diferenciar condição de processamento;
- Leitura de configurações do Gateway.

**Resposta esperada:**  

Um **predicado** define se uma requisição corresponde a determinada rota. Ele funciona como uma condição de seleção.

Exemplos de predicados:

- Caminho da URL;
- Método HTTP;
- Header;
- Host;
- Query parameter;
- Data ou horário da requisição.

Um **filtro** é aplicado depois que a rota foi selecionada. Ele pode modificar a requisição ou a resposta.

Exemplos de filtros:

- Remover ou adicionar headers;
- Reescrever o caminho;
- Remover prefixos;
- Adicionar autenticação ou informações de correlação;
- Modificar a resposta;
- Aplicar políticas específicas.

Em resumo:

- Predicado: decide **se a rota será utilizada**;
- Filtro: define **o que será feito com a requisição ou resposta**.

**Explicação didática:**  

Considere uma requisição:

text GET /api/pedidos/10


O predicado pode verificar se o caminho começa com `/api/pedidos/**`. Se a condição for verdadeira, a rota será selecionada.

Depois, um filtro pode remover o prefixo `/api` antes de encaminhar a requisição:

text /api/pedidos/10 -> /pedidos/10


O fluxo pode ser representado assim:

~~~mermaid
flowchart LR
    A["Requisição recebida"] --> B{"Predicado corresponde?"}
    B -->|"Não"| C["Tentar outra rota ou retornar erro"]
    B -->|"Sim"| D["Aplicar filtros"]
    D --> E["Encaminhar ao serviço"]
~~~

**Exemplo prático:**  

Uma rota pode aceitar apenas requisições `POST` para `/pedidos/**` e adicionar um header de correlação antes de encaminhá-las ao serviço de pedidos.

**Exemplo de código:**  

~~~yaml
spring:
  cloud:
    gateway:
      routes:
        - id: criar-pedido
          uri: lb://pedido-service
          predicates:
            - Path=/api/pedidos/**
            - Method=POST
          filters:
            - StripPrefix=1
            - AddRequestHeader=X-Gateway, spring-cloud-gateway
~~~

Nesse exemplo:

- `Path` e `Method` são predicados;
- `StripPrefix` e `AddRequestHeader` são filtros.

A sintaxe exata pode variar conforme a versão do Spring Cloud Gateway.

**Como o candidato deve responder:**  

O candidato deve:

- Diferenciar predicado de filtro;
- Apresentar pelo menos um exemplo de cada;
- Explicar que predicados participam da seleção da rota;
- Explicar que filtros alteram ou processam a requisição;
- Evitar dizer que os dois conceitos têm exatamente a mesma função.

**Perguntas de aprofundamento:**  

1. Como você aplicaria um filtro somente a uma rota específica?
2. Qual seria o risco de utilizar um predicado muito genérico?
3. Como testaria se um filtro está alterando corretamente o caminho?

**Resposta fraca ou incompleta:**  

“Predicado e filtro servem para configurar a rota.”

A resposta é insuficiente porque não diferencia condição de seleção e processamento da requisição.

**Critérios de avaliação:**  

- **0:** Confunde completamente predicados e filtros.
- **1:** Sabe apenas que ambos fazem parte do Gateway.
- **2:** Diferencia parcialmente, mas não apresenta exemplos claros.
- **3:** Explica corretamente a função básica de cada um.
- **4:** Apresenta exemplos práticos de roteamento e alteração de requisições.
- **5:** Discute precedência, composição de predicados, segurança, observabilidade e impactos dos filtros no contrato da API.

---

# Pergunta 32 — Reescrita de caminhos

**Nível:** Júnior  
**Categoria:** Gateway e prática

**Pergunta do entrevistador:**  
Um cliente acessa `/api/pedidos/10`, mas o serviço interno espera `/pedidos/10`. Como você resolveria essa diferença no API Gateway?

**O que essa pergunta avalia:**  

- Capacidade de compreender transformação de rotas;
- Conhecimento sobre desacoplamento entre cliente e serviço;
- Leitura de filtros de caminho;
- Atenção ao contrato entre gateway e microsserviço.

**Resposta esperada:**  

Eu utilizaria um filtro de reescrita ou remoção de prefixo no Gateway.

A requisição externa:

text /api/pedidos/10


seria transformada antes do encaminhamento:

text /pedidos/10


Isso permite que o cliente utilize um contrato público diferente do contrato interno do serviço.

Eu também verificaria:

- Se a transformação está correta;
- Se os parâmetros continuam preservados;
- Se a resposta retorna ao cliente adequadamente;
- Se os logs registram o caminho original e o caminho encaminhado;
- Se a regra não interfere em outras rotas;
- Se a alteração está coberta por testes.

**Explicação didática:**  

O gateway pode funcionar como uma camada de adaptação. O cliente não precisa conhecer a estrutura interna de cada serviço.

O fluxo seria:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant G as Gateway
    participant P as Pedido

    C->>G: GET /api/pedidos/10
    G->>G: Remove o prefixo /api
    G->>P: GET /pedidos/10
    P-->>G: Resposta do pedido
    G-->>C: Resposta para o cliente
~~~

Essa transformação deve ser documentada e testada. Alterar caminhos no gateway pode causar confusão se a equipe não souber qual é o endpoint externo e qual é o interno.

**Exemplo prático:**  

O gateway oferece uma API pública padronizada com o prefixo `/api`, enquanto cada microsserviço possui suas próprias rotas internas.

**Exemplo de código:**  

Uma configuração conceitual utilizando `StripPrefix` seria:

~~~yaml
spring:
  cloud:
    gateway:
      routes:
        - id: pedidos
          uri: lb://pedido-service
          predicates:
            - Path=/api/pedidos/**
          filters:
            - StripPrefix=1
~~~

A quantidade `1` indica a remoção do primeiro segmento do caminho, neste caso, `/api`.

Outra alternativa é utilizar um filtro de reescrita explícita:

~~~yaml
filters:
  - RewritePath=/api/pedidos/(?<segment>.*), /pedidos/$\{segment}
~~~

A sintaxe deve ser validada na versão específica utilizada pelo projeto.

**Como o candidato deve responder:**  

O candidato deve:

- Identificar a diferença entre rota externa e interna;
- Citar filtros como `StripPrefix` ou `RewritePath`;
- Explicar o efeito da transformação;
- Considerar testes e observabilidade;
- Evitar alterar o serviço interno sem verificar se o objetivo é realmente adaptar o gateway.

**Perguntas de aprofundamento:**  

1. O que aconteceria com `/api/pedidos/10/itens`?
2. Como você testaria a transformação do caminho?
3. Quando seria melhor alterar o contrato do serviço em vez de usar o gateway?

**Resposta fraca ou incompleta:**  

“Eu mudaria a URL no frontend para chamar diretamente `/pedidos/10`.”

Essa resposta ignora o papel do gateway e pode expor detalhes internos ao cliente.

**Critérios de avaliação:**  

- **0:** Não consegue identificar o problema de rota.
- **1:** Sugere alterar manualmente todas as chamadas.
- **2:** Cita reescrita, mas não explica como preservar o restante do caminho.
- **3:** Propõe corretamente a remoção ou reescrita do prefixo.
- **4:** Considera testes, documentação, observabilidade e compatibilidade.
- **5:** Analisa versionamento, desacoplamento, riscos de regras complexas e limites de responsabilidade do gateway.

---

# Pergunta 33 — Compatibilidade entre Spring Boot e Spring Cloud

**Nível:** Júnior  
**Categoria:** Configuração e manutenção

**Pergunta do entrevistador:**  
Por que é importante verificar a compatibilidade entre as versões do Spring Boot e do Spring Cloud?

**O que essa pergunta avalia:**  

- Conhecimento sobre gerenciamento de dependências;
- Atenção a compatibilidade de versões;
- Capacidade de evitar falhas de inicialização;
- Compreensão de mudanças no ecossistema Spring.

**Resposta esperada:**  

O Spring Cloud possui versões que foram desenvolvidas para trabalhar com determinadas versões do Spring Boot.

Utilizar combinações incompatíveis pode causar:

- Erros durante a inicialização;
- Classes ou métodos inexistentes;
- Mudanças de propriedades;
- Comportamentos inesperados;
- Falhas em integrações como Gateway, Config ou OpenFeign;
- Problemas difíceis de diagnosticar.

Por isso, eu verificaria a matriz de compatibilidade oficial da versão adotada e utilizaria o BOM, ou mecanismo equivalente, recomendado para controlar as versões das dependências.

Também avaliaria as notas de migração ao atualizar o projeto.

**Explicação didática:**  

Uma biblioteca pode depender de APIs internas ou contratos fornecidos por outra versão do framework. Se essas APIs mudarem, uma integração pode deixar de funcionar.

Por exemplo, uma configuração válida em uma versão pode ser alterada ou removida em outra.

A aplicação pode até compilar, mas apresentar falhas em execução. Por isso, a compatibilidade deve ser verificada antes da atualização.

**Exemplo prático:**  

A equipe atualiza o Spring Boot, mas mantém uma versão antiga do Spring Cloud. Depois da implantação, o Gateway não inicia por causa de uma incompatibilidade entre as versões.

Uma abordagem mais segura seria:

1. Consultar a matriz de compatibilidade;
2. Atualizar as versões alinhadas;
3. Executar testes;
4. Validar as configurações;
5. Fazer a implantação gradualmente.

**Exemplo de código:**  

Um projeto Maven pode importar um conjunto de versões compatíveis:

~~~xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
~~~

A versão correta deve ser escolhida conforme a versão do Spring Boot e a documentação oficial correspondente.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar que as versões possuem compatibilidade definida;
- Mencionar a possibilidade de erros de inicialização;
- Falar sobre BOM ou gerenciamento centralizado;
- Recomendar consultar a documentação;
- Evitar escolher versões apenas pelo número mais recente.

**Perguntas de aprofundamento:**  

1. Como você investigaria um erro de classe ausente após uma atualização?
2. Por que atualizar apenas uma dependência pode ser arriscado?
3. Como reduziria o risco de uma atualização em produção?

**Resposta fraca ou incompleta:**  

“É importante usar sempre a versão mais nova de tudo.”

Essa resposta ignora compatibilidade, testes, mudanças de comportamento e riscos de atualização.

**Critérios de avaliação:**  

- **0:** Afirma que qualquer versão pode ser combinada.
- **1:** Sabe apenas que versões diferentes podem causar problemas.
- **2:** Cita compatibilidade, mas não sabe como verificá-la.
- **3:** Explica corretamente a necessidade de alinhar as versões.
- **4:** Considera BOM, testes, notas de migração e implantação gradual.
- **5:** Discute gerenciamento de dependências, compatibilidade transitive, rollback, segurança e estratégia de atualização.

---

# Pergunta 34 — Balanceamento no cliente e no servidor

**Nível:** Júnior  
**Categoria:** Balanceamento de carga

**Pergunta do entrevistador:**  
Qual é a diferença entre balanceamento de carga no cliente e balanceamento de carga no servidor ou gateway?

**O que essa pergunta avalia:**  

- Compreensão de diferentes estratégias de balanceamento;
- Capacidade de comparar alternativas;
- Noções de responsabilidade arquitetural;
- Identificação de trade-offs.

**Resposta esperada:**  

No **balanceamento no cliente**, o próprio serviço chamador obtém uma lista de instâncias disponíveis e escolhe para qual delas enviará a requisição.

No **balanceamento no servidor ou gateway**, o cliente chama um componente intermediário. Esse componente decide qual instância receberá a requisição.

No balanceamento no cliente:

- Pode haver menor quantidade de componentes intermediários;
- O cliente precisa conhecer a lógica de descoberta e seleção;
- A implementação pode variar entre linguagens e equipes.

No balanceamento no gateway ou servidor:

- A lógica pode ser centralizada;
- Os clientes podem ser mais simples;
- O gateway pode se tornar um ponto de concentração;
- É necessário garantir sua escalabilidade e disponibilidade.

A escolha depende da infraestrutura, do tipo de cliente, dos requisitos de latência e do padrão adotado pela organização.

**Explicação didática:**  

No modelo client-side:

~~~mermaid
sequenceDiagram
    participant P as Pedido
    participant R as Registry
    participant F1 as Pagamento 1
    participant F2 as Pagamento 2

    P->>R: Consultar instâncias
    R-->>P: Lista de instâncias
    P->>F1: Enviar requisição
~~~

No modelo server-side:

~~~mermaid
sequenceDiagram
    participant P as Cliente
    participant G as Gateway
    participant R as Registry
    participant F as Instância escolhida

    P->>G: Solicitar pagamento
    G->>R: Consultar instâncias
    R-->>G: Lista de instâncias
    G->>F: Encaminhar chamada
    F-->>G: Resposta
    G-->>P: Resposta
~~~

Os dois modelos podem funcionar corretamente. O ponto importante é entender onde a decisão de seleção acontece.

**Exemplo prático:**  

Um serviço Java pode utilizar um cliente integrado à descoberta para escolher uma instância. Já uma aplicação mobile normalmente não deveria consultar diretamente o registro interno; ela deve acessar um gateway ou endpoint público.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar os dois modelos;
- Indicar quem escolhe a instância;
- Citar pelo menos um benefício e um risco de cada abordagem;
- Relacionar a escolha ao tipo de cliente;
- Evitar afirmar que uma estratégia é sempre superior.

**Perguntas de aprofundamento:**  

1. Por que um aplicativo mobile não deveria acessar diretamente o Service Registry?
2. Qual estratégia pode gerar maior concentração de responsabilidade?
3. Como você verificaria se o balanceamento está funcionando?

**Resposta fraca ou incompleta:**  

“Balanceamento no cliente acontece no cliente e no servidor acontece no servidor.”

A resposta apenas repete os nomes e não explica onde ocorre a descoberta ou a seleção das instâncias.

**Critérios de avaliação:**  

- **0:** Não diferencia as estratégias.
- **1:** Reconhece que existem diferentes locais de balanceamento, mas não explica.
- **2:** Explica parcialmente o fluxo.
- **3:** Diferencia corretamente client-side e server-side.
- **4:** Discute benefícios, riscos e disponibilidade do componente intermediário.
- **5:** Analisa latência, acoplamento, observabilidade, escalabilidade e adequação ao tipo de cliente.

---

# Pergunta 35 — Fallback e degradação controlada

**Nível:** Júnior  
**Categoria:** Resiliência

**Pergunta do entrevistador:**  
O que é um fallback e em quais situações ele pode ser uma boa alternativa quando uma dependência está indisponível?

**O que essa pergunta avalia:**  

- Compreensão de degradação controlada;
- Capacidade de relacionar fallback à regra de negócio;
- Noções de experiência do usuário;
- Identificação de riscos de mascarar falhas.

**Resposta esperada:**  

Fallback é um comportamento alternativo executado quando uma chamada principal falha ou não pode ser concluída.

Ele pode ser adequado quando:

- A funcionalidade não é essencial;
- É possível utilizar dados previamente armazenados;
- É aceitável retornar uma resposta parcial;
- A operação pode ser processada posteriormente;
- Existe uma alternativa segura e conhecida.

Exemplos:

- Mostrar produtos sem recomendações;
- Utilizar dados em cache;
- Retornar uma lista vazia para uma funcionalidade opcional;
- Registrar a operação como pendente;
- Enviar a operação para processamento assíncrono.

Fallback não deve simplesmente esconder uma falha crítica. Em operações financeiras ou de consistência obrigatória, retornar uma resposta falsa pode ser mais perigoso do que informar indisponibilidade.

**Explicação didática:**  

O fallback é uma forma de degradação controlada. O sistema continua oferecendo algum comportamento, mas com capacidade reduzida.

Por exemplo, se o serviço de recomendações falhar, a página de produtos ainda pode ser exibida sem recomendações.

Já em um pagamento, não seria seguro informar “pagamento aprovado” apenas porque o serviço principal está indisponível.

**Exemplo prático:**  

~~~mermaid
flowchart TD
    A["Serviço chama dependência"] --> B{"Dependência respondeu?"}
    B -->|"Sim"| C["Usar resposta principal"]
    B -->|"Não"| D{"Funcionalidade pode degradar?"}
    D -->|"Sim"| E["Executar fallback"]
    D -->|"Não"| F["Retornar indisponibilidade controlada"]
~~~

**Exemplo de código:**  

~~~java
@CircuitBreaker(
        name = "recomendacoes",
        fallbackMethod = "recomendacoesFallback"
)
public ListaRecomendacoes buscar(Long produtoId) {
    return recomendacoesClient.buscar(produtoId);
}

private ListaRecomendacoes recomendacoesFallback(
        Long produtoId,
        Throwable erro) {

    // A aplicação pode retornar uma resposta vazia
    // se recomendações forem opcionais.
    return ListaRecomendacoes.vazia();
}
~~~

A implementação depende da biblioteca e da versão utilizadas. O fallback deve registrar a ocorrência e permitir monitoramento.

**Como o candidato deve responder:**  

O candidato deve:

- Definir fallback;
- Relacioná-lo a uma resposta alternativa;
- Explicar que depende da regra de negócio;
- Diferenciar funcionalidade crítica de opcional;
- Mencionar logs, métricas e riscos de mascaramento;
- Evitar retornar sucesso falso.

**Perguntas de aprofundamento:**  

1. Você utilizaria fallback para aprovar um pagamento?
2. Como saberia se o fallback está sendo usado com frequência?
3. Qual é a diferença entre fallback e retry?

**Resposta fraca ou incompleta:**  

“Fallback é retornar qualquer valor quando ocorrer um erro.”

A resposta é perigosa porque não considera a validade do valor retornado nem a importância da operação.

**Critérios de avaliação:**  

- **0:** Recomenda retornar sucesso mesmo sem confirmação.
- **1:** Sabe apenas que fallback é uma alternativa em caso de erro.
- **2:** Entende o conceito, mas não avalia a regra de negócio.
- **3:** Explica corretamente fallback e degradação controlada.
- **4:** Considera cache, operações pendentes, monitoramento e riscos.
- **5:** Analisa consistência, comunicação com o usuário, impacto operacional e limites para cada tipo de domínio.

---

# Pergunta 36 — Bulkhead

**Nível:** Júnior  
**Categoria:** Resiliência

**Pergunta do entrevistador:**  
O que é o padrão Bulkhead e como ele pode ajudar a evitar que uma dependência lenta derrube toda a aplicação?

**O que essa pergunta avalia:**  

- Noções de isolamento de recursos;
- Compreensão de falhas em cascata;
- Capacidade de relacionar concorrência e disponibilidade;
- Conhecimento básico de resiliência.

**Resposta esperada:**  

O padrão **Bulkhead**, ou anteparas, isola recursos utilizados por diferentes operações ou dependências.

Por exemplo, uma aplicação pode reservar limites separados de concorrência para:

- Chamadas ao serviço de pagamentos;
- Chamadas ao serviço de recomendações;
- Processamento de pedidos;
- Consultas administrativas.

Se o serviço de recomendações ficar lento, ele não deve consumir todas as threads ou conexões disponíveis e impedir o processamento de pedidos.

O Bulkhead pode ser implementado com:

- Limites de concorrência;
- Pools separados;
- Filas com capacidade limitada;
- Isolamento de threads;
- Limites de conexões.

Ele deve ser configurado com cuidado, pois limites muito baixos reduzem a capacidade do sistema, enquanto limites muito altos não oferecem proteção suficiente.

**Explicação didática:**  

Imagine um navio dividido em compartimentos. Se um compartimento for inundado, os demais continuam protegidos.

Em uma aplicação, isso significa impedir que uma única dependência consuma todos os recursos disponíveis.

O fluxo pode ser representado assim:

~~~mermaid
flowchart LR
    A["Aplicação"] --> B["Pool de pagamentos"]
    A --> C["Pool de recomendações"]
    A --> D["Pool de pedidos"]
    B --> E["Serviço de pagamentos"]
    C --> F["Serviço de recomendações"]
    D --> G["Processamento de pedidos"]
~~~

Se o serviço de recomendações ficar lento, apenas o pool associado a ele deve ser afetado.

**Exemplo prático:**  

Uma tela chama simultaneamente três serviços. O serviço de relatórios começa a demorar muito. Sem isolamento, suas requisições podem ocupar todos os recursos e afetar operações críticas.

**Exemplo de código:**  

Uma configuração conceitual pode limitar chamadas concorrentes:

~~~yaml
resilience4j:
  bulkhead:
    instances:
      recomendacoes:
        maxConcurrentCalls: 10
        maxWaitDuration: 100ms
~~~

Os nomes e propriedades podem variar conforme a biblioteca e a versão adotadas.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar a ideia de isolamento;
- Relacionar o padrão ao consumo de threads, conexões ou filas;
- Apresentar um exemplo de dependência lenta;
- Mencionar limites e trade-offs;
- Evitar afirmar que Bulkhead torna a dependência mais rápida.

**Perguntas de aprofundamento:**  

1. O que deveria acontecer quando o limite de concorrência for atingido?
2. Como escolheria um limite inicial?
3. Qual é a diferença entre Bulkhead e circuit breaker?

**Resposta fraca ou incompleta:**  

“Bulkhead aumenta a quantidade de threads para atender mais requisições.”

Essa resposta confunde isolamento com aumento indiscriminado de recursos.

**Critérios de avaliação:**  

- **0:** Não entende o padrão ou recomenda recursos ilimitados.
- **1:** Sabe apenas que está relacionado à resiliência.
- **2:** Entende parcialmente o isolamento, mas não explica o objetivo.
- **3:** Explica corretamente a separação de recursos.
- **4:** Relaciona Bulkhead a pools, limites e falhas em cascata.
- **5:** Discute capacidade, rejeição controlada, métricas, dimensionamento e trade-offs de latência e throughput.

---

# Pergunta 37 — Tracing distribuído

**Nível:** Júnior  
**Categoria:** Observabilidade

**Pergunta do entrevistador:**  
O que é rastreamento distribuído e por que ele pode ser útil em uma arquitetura com Spring Cloud?

**O que essa pergunta avalia:**  

- Conhecimento básico de observabilidade;
- Compreensão de requisições entre serviços;
- Capacidade de diferenciar logs e traces;
- Investigação de latência distribuída.

**Resposta esperada:**  

Rastreamento distribuído é o acompanhamento de uma requisição enquanto ela passa por vários componentes.

Um trace pode conter vários spans. Cada span representa uma etapa, como:

- Requisição no gateway;
- Chamada ao serviço de pedidos;
- Consulta ao banco;
- Chamada ao serviço de pagamentos;
- Publicação de uma mensagem.

Esse recurso ajuda a identificar:

- Qual serviço está lento;
- Onde ocorreu um erro;
- Quanto tempo cada etapa consumiu;
- Se existem chamadas desnecessárias;
- Onde uma requisição foi interrompida.

O tracing complementa logs e métricas:

- Logs registram eventos;
- Métricas mostram tendências e valores agregados;
- Traces mostram o caminho de uma operação específica.

**Explicação didática:**  

Considere o fluxo:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant G as Gateway
    participant P as Pedido
    participant F as Pagamento
    participant B as Banco

    C->>G: Criar pedido
    G->>P: Encaminhar requisição
    P->>F: Autorizar pagamento
    F->>B: Consultar dados
    B-->>F: Resultado
    F-->>P: Pagamento aprovado
    P-->>G: Pedido criado
    G-->>C: Resposta
~~~

Se a resposta demorou 5 segundos, o trace pode mostrar que:

- Gateway consumiu 50 ms;
- Serviço de pedidos consumiu 100 ms;
- Serviço de pagamentos consumiu 4,7 segundos.

Assim, a equipe investiga a área correta.

**Exemplo prático:**  

Usuários relatam lentidão apenas na criação de pedidos. As métricas mostram aumento de latência, e o trace revela que o problema está na chamada ao serviço de pagamentos.

**Exemplo de código:**  

Em aplicações modernas, o rastreamento pode ser integrado por bibliotecas compatíveis com OpenTelemetry e com o ecossistema Spring.

Um exemplo conceitual de configuração seria:

~~~yaml
management:
  tracing:
    sampling:
      probability: 0.1
~~~

O valor de amostragem indica que apenas parte das requisições pode ser rastreada, reduzindo custo. A configuração exata depende da versão e da infraestrutura adotadas.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar que o trace acompanha a requisição entre serviços;
- Mencionar spans;
- Diferenciar logs, métricas e traces;
- Relacionar o recurso a latência e troubleshooting;
- Considerar custo e amostragem;
- Evitar dizer que tracing substitui logs e métricas.

**Perguntas de aprofundamento:**  

1. Qual é a diferença entre um trace e um correlation ID?
2. Por que talvez não seja adequado rastrear 100% das requisições?
3. Que dados sensíveis devem ser evitados em traces?

**Resposta fraca ou incompleta:**  

“Tracing é salvar todos os logs em um único lugar.”

A resposta confunde rastreamento distribuído com centralização de logs.

**Critérios de avaliação:**  

- **0:** Não entende o objetivo do tracing.
- **1:** Sabe apenas que está relacionado a logs.
- **2:** Reconhece o acompanhamento entre serviços, mas não explica spans.
- **3:** Explica corretamente o conceito e sua utilidade.
- **4:** Diferencia tracing, logs e métricas e considera amostragem.
- **5:** Discute propagação de contexto, custo, privacidade, análise de latência e investigação ponta a ponta.

---

# Pergunta 38 — Spring Cloud Stream

**Nível:** Júnior  
**Categoria:** Mensageria e integração

**Pergunta do entrevistador:**  
O que é o Spring Cloud Stream e em que situação você consideraria utilizá-lo?

**O que essa pergunta avalia:**  

- Conhecimento básico sobre comunicação assíncrona;
- Compreensão de eventos;
- Capacidade de diferenciar comunicação síncrona e assíncrona;
- Noções de abstração de mensageria.

**Resposta esperada:**  

Spring Cloud Stream é um framework para criar aplicações orientadas a mensagens e eventos, integrando o código da aplicação a sistemas de mensageria por meio de abstrações.

Ele pode ser utilizado quando:

- Uma operação não precisa de resposta imediata;
- É necessário desacoplar produtores e consumidores;
- Eventos precisam ser processados por diferentes serviços;
- O processamento pode ocorrer posteriormente;
- Existe necessidade de absorver picos por meio de filas;
- A comunicação síncrona criaria dependência excessiva.

Os detalhes dependem do broker utilizado, como Kafka ou RabbitMQ.

Também é necessário considerar:

- Entrega de mensagens;
- Reprocessamento;
- Duplicidade;
- Ordem;
- Idempotência;
- Dead-letter;
- Monitoramento;
- Evolução do formato do evento.

**Explicação didática:**  

Em uma comunicação síncrona, o serviço chamador aguarda uma resposta:

~~~mermaid
sequenceDiagram
    participant P as Pedido
    participant F as Pagamento

    P->>F: Autorizar pagamento
    F-->>P: Resposta
~~~

Em uma comunicação assíncrona, o produtor publica um evento e o consumidor processa depois:

~~~mermaid
sequenceDiagram
    participant P as Pedido
    participant M as Broker
    participant F as Pagamento

    P->>M: Publicar PedidoCriado
    M-->>P: Confirma recebimento
    M->>F: Entregar evento
    F-->>M: Confirmar processamento
~~~

A abordagem assíncrona pode melhorar o desacoplamento, mas torna o fluxo mais complexo.

**Exemplo prático:**  

Depois que um pedido é criado, o serviço publica o evento `PedidoCriado`. Outros serviços podem:

- Reservar estoque;
- Enviar e-mail;
- Gerar nota;
- Atualizar relatórios.

O serviço de pedidos não precisa chamar todos esses serviços diretamente.

**Exemplo de código:**  

Um exemplo conceitual de consumidor pode ser:

~~~java
@Bean
public Consumer<PedidoCriado> processarPedido() {
    return evento -> {
        // Processa o evento recebido do broker.
        System.out.println("Pedido recebido: " + evento.id());
    };
}
~~~

A configuração das ligações, do broker e dos grupos de consumidores depende da versão e da tecnologia de mensageria utilizada.

**Como o candidato deve responder:**  

O candidato deve:

- Definir comunicação baseada em mensagens;
- Explicar a diferença entre síncrona e assíncrona;
- Citar desacoplamento e processamento posterior;
- Mencionar duplicidade e idempotência;
- Reconhecer que o uso de mensageria adiciona complexidade;
- Evitar dizer que mensagens são sempre melhores que chamadas HTTP.

**Perguntas de aprofundamento:**  

1. Como você evitaria processar duas vezes o mesmo evento?
2. O que faria se o consumidor estivesse indisponível?
3. Quando uma chamada síncrona seria mais simples e adequada?

**Resposta fraca ou incompleta:**  

“Spring Cloud Stream serve para trocar mensagens mais rapidamente.”

A resposta não explica eventos, desacoplamento, broker ou as diferenças entre comunicação síncrona e assíncrona.

**Critérios de avaliação:**  

- **0:** Não entende comunicação por mensagens.
- **1:** Sabe apenas que existe um broker.
- **2:** Reconhece mensagens assíncronas, mas ignora riscos.
- **3:** Explica corretamente o propósito básico do Spring Cloud Stream.
- **4:** Discute eventos, grupos, reprocessamento e idempotência.
- **5:** Analisa consistência eventual, ordenação, entrega, evolução de contratos, observabilidade e trade-offs arquiteturais.

---

# Pergunta 39 — Testes de integração entre microsserviços

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Como você testaria uma aplicação que utiliza Spring Cloud para chamar outros microsserviços?

**O que essa pergunta avalia:**  

- Conhecimento sobre estratégias de teste;
- Capacidade de evitar dependência de ambientes externos;
- Compreensão de testes de integração;
- Identificação de falhas em chamadas remotas.

**Resposta esperada:**  

Eu utilizaria diferentes níveis de teste.

### Testes unitários

Validariam a lógica da aplicação isoladamente, simulando o cliente HTTP ou a dependência externa.

### Testes de integração

Validariam a integração real entre partes da aplicação, como:

- Gateway e rotas;
- Cliente HTTP e contrato;
- Configuração;
- Serialização e desserialização;
- Tratamento de erros.

### Testes de contrato

Verificariam se o serviço fornecedor e o consumidor concordam sobre:

- Caminhos;
- Métodos;
- Campos;
- Códigos de resposta;
- Formato das mensagens.

### Testes de ambiente

Quando necessário, poderiam utilizar dependências reais ou simuladas, como um broker, banco ou serviço HTTP controlado.

Eu também testaria cenários de falha:

- Timeout;
- Erro 404;
- Erro 500;
- Resposta inválida;
- Serviço indisponível;
- Falha de autenticação;
- Mensagem duplicada.

**Explicação didática:**  

Não é adequado executar todos os testes contra serviços reais compartilhados. Isso pode tornar os testes:

- Lentos;
- Instáveis;
- Dependentes da disponibilidade de outros times;
- Difíceis de reproduzir;
- Arriscados para dados reais.

Mocks e simuladores ajudam a controlar respostas, mas não substituem completamente testes de integração ou contrato.

**Exemplo prático:**  

Para testar o `pedido-service`, eu poderia simular o `cliente-service` retornando:

- Cliente existente;
- Cliente inexistente;
- Timeout;
- Erro interno;
- Resposta com campo ausente.

Assim, verificaria se o serviço de pedidos toma a decisão correta em cada cenário.

**Exemplo de código:**  

Um teste conceitual poderia utilizar um servidor HTTP simulado:

~~~java
@SpringBootTest
class PedidoClientTest {

    @Test
    void deveTratarClienteNaoEncontrado() {
        // Configura uma resposta HTTP 404 simulada.
        // Executa a chamada do cliente.
        // Verifica se a aplicação traduz o erro
        // para o comportamento esperado.
    }
}
~~~

Em projetos reais, ferramentas como WireMock ou MockWebServer podem ser utilizadas, desde que sejam compatíveis com a stack adotada.

**Como o candidato deve responder:**  

O candidato deve:

- Diferenciar testes unitários, integração e contrato;
- Mencionar cenários de sucesso e falha;
- Explicar por que não depender sempre de serviços reais;
- Considerar timeout e respostas HTTP;
- Falar sobre repetibilidade e isolamento;
- Evitar testar somente o caminho feliz.

**Perguntas de aprofundamento:**  

1. Como testaria um circuit breaker?
2. Qual é o risco de utilizar apenas mocks?
3. Como validaria se uma mudança no contrato quebrou um consumidor?

**Resposta fraca ou incompleta:**  

“Eu faria um teste chamando o serviço real e verificaria se retornou 200.”

A resposta cobre apenas o caminho feliz e cria dependência de outro serviço.

**Critérios de avaliação:**  

- **0:** Não apresenta estratégia de testes.
- **1:** Sugere apenas testar manualmente a API.
- **2:** Fala em mocks, mas ignora integração e falhas.
- **3:** Diferencia testes básicos e cobre cenários de erro.
- **4:** Inclui testes de contrato, timeout, circuit breaker e isolamento.
- **5:** Apresenta uma estratégia equilibrada entre testes unitários, integração, contrato, ambientes efêmeros e validação contínua.

---

# Pergunta 40 — Investigação de erro 503 no Gateway

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
O API Gateway começou a retornar HTTP 503 para as requisições de um serviço. Como você investigaria esse problema?

**O que essa pergunta avalia:**  

- Raciocínio sistemático de troubleshooting;
- Conhecimento sobre indisponibilidade;
- Compreensão da relação entre gateway, descoberta e serviço;
- Capacidade de utilizar evidências técnicas.

**Resposta esperada:**  

HTTP 503 indica que o serviço não está disponível para atender a requisição naquele momento, mas é necessário investigar a causa real.

Eu verificaria:

1. Se o serviço de destino está em execução;
2. Se existem instâncias registradas;
3. Se as instâncias estão prontas para receber tráfego;
4. Se o Gateway consegue resolver o nome do serviço;
5. Se a rota está configurada corretamente;
6. Se a porta e o endereço estão corretos;
7. Se há problemas de rede;
8. Se o health check está falhando;
9. Se o serviço está saturado;
10. Se houve alteração recente de configuração ou versão;
11. Se o circuit breaker está aberto;
12. Se há erros nos logs do Gateway e do serviço.

Também analisaria métricas de:

- Taxa de erro;
- Latência;
- Número de instâncias;
- Estado dos circuit breakers;
- Uso de CPU e memória;
- Conexões e filas.

A investigação deveria começar por evidências, evitando reiniciar componentes sem entender o problema.

**Explicação didática:**  

O fluxo básico é:

~~~mermaid
flowchart TD
    A["Cliente recebe 503"] --> B["Verificar logs do Gateway"]
    B --> C{"Há rota correspondente?"}
    C -->|"Não"| D["Corrigir configuração da rota"]
    C -->|"Sim"| E{"Há instâncias disponíveis?"}
    E -->|"Não"| F["Investigar descoberta e health check"]
    E -->|"Sim"| G{"Gateway alcança a instância?"}
    G -->|"Não"| H["Investigar rede, porta e segurança"]
    G -->|"Sim"| I{"Serviço responde corretamente?"}
    I -->|"Não"| J["Investigar aplicação e dependências"]
    I -->|"Sim"| K["Analisar configuração, timeout e resposta"]
~~~

O código 503 não informa sozinho a causa detalhada. É necessário combinar logs, métricas, health checks e testes controlados.

**Exemplo prático:**  

O Gateway retorna 503 porque todas as instâncias do `pagamento-service` foram consideradas não prontas. A investigação mostra que o health check depende do banco de dados, que está temporariamente indisponível.

Nesse caso, a equipe deve avaliar se o banco é uma dependência obrigatória para a readiness e se o comportamento esperado é retirar todas as instâncias do tráfego.

**Exemplo de código:**  

Um teste de rota pode ser feito conceitualmente com uma requisição HTTP:

~~~bash
curl -i http://localhost:8080/api/pedidos/10
~~~

Além do status, o entrevistado deveria verificar:

- Headers de correlação;
- Corpo da resposta;
- Logs gerados;
- Instância selecionada;
- Tempo de resposta.

**Como o candidato deve responder:**  

O candidato deve organizar o diagnóstico em camadas:

1. Gateway;
2. Rota;
3. Descoberta;
4. Health check;
5. Rede;
6. Serviço de destino;
7. Dependências;
8. Resiliência.

Também deve:

- Diferenciar 503 de 404, 401 e 500;
- Utilizar logs e métricas;
- Considerar mudanças recentes;
- Evitar reinicializações automáticas como primeira resposta;
- Explicar como confirmaria cada hipótese.

**Perguntas de aprofundamento:**  

1. Como diferenciaria uma rota inexistente de uma instância indisponível?
2. O que verificaria se o serviço aparece registrado, mas o Gateway retorna 503?
3. Como evitaria que uma alteração de health check removesse todas as instâncias do tráfego?

**Resposta fraca ou incompleta:**  

“Eu reiniciaria o Gateway e o serviço para ver se volta.”

Essa resposta não identifica a causa e pode ocultar ou agravar o problema.

**Critérios de avaliação:**  

- **0:** Não apresenta uma estratégia de diagnóstico.
- **1:** Sugere apenas reiniciar os componentes.
- **2:** Verifica logs, mas não analisa descoberta, rota ou health check.
- **3:** Investiga Gateway, instâncias, rota e conectividade.
- **4:** Considera métricas, circuit breaker, dependências e mudanças recentes.
- **5:** Apresenta uma investigação estruturada, baseada em evidências, com distinção entre sintoma, causa, mitigação e correção definitiva.

---

## Resumo desta parte

- **Perguntas apresentadas:** 31 a 40
- **Perguntas restantes:** 60
- **Nível abordado:** Júnior
- **Categorias cobertas:**
  - Gateway e roteamento;
  - Predicados e filtros;
  - Reescrita de caminhos;
  - Compatibilidade de versões;
  - Balanceamento;
  - Resiliência;
  - Fallback;
  - Bulkhead;
  - Observabilidade;
  - Mensageria;
  - Testes;
  - Troubleshooting.

## Matriz parcial de competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---:|---|
| Predicados e filtros | Júnior | 31 | Diferencia seleção de rota e transformação da requisição |
| Reescrita de caminhos | Júnior | 32 | Adapta contratos externos e internos de forma controlada |
| Compatibilidade de versões | Júnior | 33 | Consulta versões compatíveis e reconhece riscos de atualização |
| Estratégias de balanceamento | Júnior | 34 | Diferencia balanceamento no cliente e no gateway |
| Fallback | Júnior | 35 | Propõe degradação segura conforme a regra de negócio |
| Bulkhead | Júnior | 36 | Entende isolamento de recursos e proteção contra cascatas |
| Tracing distribuído | Júnior | 37 | Usa traces, spans, logs e métricas para investigar fluxos |
| Comunicação assíncrona | Júnior | 38 | Compreende eventos, brokers, duplicidade e idempotência |
| Testes distribuídos | Júnior | 39 | Combina testes unitários, integração e contrato |
| Troubleshooting de Gateway | Júnior | 40 | Investiga 503 por camadas e com base em evidências |

## Recomendações específicas para o entrevistador

- Peça ao candidato para explicar uma configuração de Gateway em voz alta.
- Verifique se ele diferencia predicado, filtro e destino da rota.
- Pergunte quais testes seriam feitos antes de alterar uma regra de reescrita.
- Avalie se o candidato conhece os riscos de misturar versões incompatíveis.
- Explore se ele compreende que fallback não deve gerar respostas falsas.
- Pergunte como Bulkhead protege recursos compartilhados.
- Diferencie conhecimento sobre logs de entendimento real sobre tracing distribuído.
- Em mensageria, investigue se o candidato considera duplicidade e reprocessamento.
- Durante troubleshooting, peça que o candidato priorize hipóteses e explique como validaria cada uma.

## Recomendações específicas para o candidato

- Explique primeiro o problema que o recurso resolve.
- Ao falar de Gateway, diferencie rota, predicado, filtro e destino.
- Não memorize apenas propriedades; entenda o efeito de cada configuração.
- Ao discutir resiliência, mencione timeout, retry, circuit breaker, fallback e isolamento.
- Em mensageria, sempre considere entrega duplicada e processamento idempotente.
- Diferencie logs, métricas e traces.
- Em testes, cubra sucesso, erro, timeout e indisponibilidade.
- Em troubleshooting, organize o raciocínio por camadas e use evidências antes de propor mudanças.

---

# Roteiro de Entrevista Técnica — Spring Cloud

## Perguntas 41 a 50

> Continuação do roteiro para avaliação de nível Júnior, com perguntas conceituais, práticas e baseadas em cenários reais.

---

# Pergunta 41 — Configuração de rotas no Spring Cloud Gateway

**Nível:** Júnior  
**Categoria:** Gateway e configuração

**Pergunta do entrevistador:**  
Quais elementos normalmente compõem uma rota do Spring Cloud Gateway e qual é a responsabilidade de cada um?

**O que essa pergunta avalia:**  

- Conhecimento da estrutura básica de uma rota;
- Capacidade de interpretar configurações;
- Compreensão de predicados, filtros e destinos;
- Organização do raciocínio técnico.

**Resposta esperada:**  

Uma rota do Spring Cloud Gateway normalmente possui:

- **ID:** identifica a rota;
- **URI:** define o destino para onde a requisição será encaminhada;
- **Predicados:** determinam quando a rota deve ser aplicada;
- **Filtros:** modificam ou processam a requisição e a resposta.

Exemplo:

~~~yaml
spring:
  cloud:
    gateway:
      routes:
        - id: pedidos
          uri: lb://pedido-service
          predicates:
            - Path=/api/pedidos/**
            - Method=GET
          filters:
            - StripPrefix=1
~~~

Nesse exemplo:

- `pedidos` é o identificador da rota;
- `lb://pedido-service` representa o serviço de destino;
- `Path` e `Method` são predicados;
- `StripPrefix` é um filtro.

A configuração exata pode variar conforme a versão do Spring Cloud Gateway e a forma de descoberta utilizada.

**Explicação didática:**  

O Gateway precisa responder a três perguntas:

1. Qual requisição deve ser selecionada?
2. Para onde ela deve ser enviada?
3. Que modificações devem ser feitas antes ou depois do encaminhamento?

Os predicados respondem à primeira pergunta. A URI responde à segunda. Os filtros podem realizar adaptações ou aplicar comportamentos adicionais.

O Gateway não deve concentrar toda a lógica de negócio. Sua função principal é cuidar de roteamento e responsabilidades transversais.

**Exemplo prático:**  

Uma requisição `GET /api/pedidos/15` corresponde à rota de pedidos. O Gateway remove o prefixo `/api` e encaminha a chamada ao `pedido-service`.

**Como o candidato deve responder:**  

O candidato deve:

- Citar ID, URI, predicados e filtros;
- Explicar a função de cada elemento;
- Apresentar um exemplo simples;
- Diferenciar roteamento de lógica de negócio;
- Reconhecer que os detalhes podem depender da versão.

**Perguntas de aprofundamento:**  

1. O que aconteceria se duas rotas correspondessem à mesma requisição?
2. Qual é a diferença entre configurar uma rota com URI fixa e usar `lb://`?
3. Como você testaria uma rota configurada no Gateway?

**Resposta fraca ou incompleta:**  

“Uma rota tem uma URL e encaminha a chamada.”

A resposta não explica condições de seleção, filtros, identificação da rota nem integração com descoberta e balanceamento.

**Critérios de avaliação:**  

- **0:** Não consegue explicar a estrutura de uma rota.
- **1:** Conhece apenas a ideia de encaminhar uma URL.
- **2:** Cita alguns elementos, mas confunde suas responsabilidades.
- **3:** Explica corretamente ID, destino, predicados e filtros.
- **4:** Relaciona a configuração a testes, descoberta e transformação de caminhos.
- **5:** Discute precedência, manutenção, segurança, observabilidade e riscos de rotas sobrepostas.

---

# Pergunta 42 — Filtros globais e filtros de rota

**Nível:** Júnior  
**Categoria:** Gateway e boas práticas

**Pergunta do entrevistador:**  
Qual é a diferença entre um filtro aplicado globalmente e um filtro aplicado somente a uma rota no Spring Cloud Gateway?

**O que essa pergunta avalia:**  

- Compreensão do escopo de filtros;
- Capacidade de escolher o local correto para uma regra;
- Noções de reutilização e impacto de configurações;
- Identificação de riscos de aplicação excessiva.

**Resposta esperada:**  

Um filtro de rota é aplicado somente às requisições que correspondem àquela rota específica.

Um filtro global é aplicado a todas, ou praticamente todas, as requisições processadas pelo Gateway.

Um filtro de rota pode ser adequado para:

- Remover um prefixo específico;
- Adicionar um header necessário a determinado serviço;
- Aplicar uma regra específica de uma API.

Um filtro global pode ser apropriado para:

- Gerar ou propagar um identificador de correlação;
- Registrar informações comuns;
- Aplicar uma política transversal;
- Medir a latência de todas as requisições.

É necessário cuidado com filtros globais, pois uma configuração incorreta pode afetar todas as rotas.

**Explicação didática:**  

Se apenas o serviço de pedidos precisa remover o prefixo `/api`, essa regra deve ficar associada à rota de pedidos.

Já a propagação de um `X-Request-Id` pode fazer sentido para todas as requisições.

O escopo deve ser escolhido de acordo com a abrangência da regra. Quanto mais amplo o filtro, maior o potencial de impacto.

**Exemplo prático:**  

~~~yaml
spring:
  cloud:
    gateway:
      default-filters:
        - AddResponseHeader=X-Platform, gateway

      routes:
        - id: pedidos
          uri: lb://pedido-service
          predicates:
            - Path=/api/pedidos/**
          filters:
            - StripPrefix=1
~~~

O filtro em `default-filters` pode ser aplicado às rotas configuradas, enquanto `StripPrefix` pertence apenas à rota de pedidos.

A aplicação exata depende da configuração adotada e da versão utilizada.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar a diferença de escopo;
- Citar exemplos adequados para cada caso;
- Mencionar o risco de filtros globais;
- Evitar aplicar uma regra específica a todas as rotas sem necessidade;
- Demonstrar preocupação com testes e impacto.

**Perguntas de aprofundamento:**  

1. Quando um filtro global pode ser uma má escolha?
2. Como testaria se um filtro está afetando rotas que não deveria?
3. Onde colocaria a propagação de um identificador de correlação?

**Resposta fraca ou incompleta:**  

“Filtro global é mais importante e filtro de rota é menos importante.”

A diferença principal não é de importância, mas de abrangência e escopo de aplicação.

**Critérios de avaliação:**  

- **0:** Não diferencia os tipos de filtro.
- **1:** Sabe apenas que existem filtros diferentes.
- **2:** Entende parcialmente o escopo, mas não apresenta exemplos.
- **3:** Explica corretamente filtros globais e de rota.
- **4:** Escolhe o escopo adequado para diferentes situações.
- **5:** Discute impacto, composição, ordem de execução, testes e riscos de alterações globais.

---

# Pergunta 43 — Gateway como ponto único de falha

**Nível:** Júnior  
**Categoria:** Arquitetura e disponibilidade

**Pergunta do entrevistador:**  
Quais problemas podem ocorrer se uma única instância do API Gateway receber todo o tráfego da aplicação?

**O que essa pergunta avalia:**  

- Compreensão de disponibilidade;
- Noções de escalabilidade horizontal;
- Identificação de pontos únicos de falha;
- Capacidade de propor uma mitigação básica.

**Resposta esperada:**  

Uma única instância do Gateway pode se tornar:

- Ponto único de falha;
- Gargalo de desempenho;
- Limitação para crescimento do tráfego;
- Componente difícil de atualizar sem interrupção;
- Alvo de sobrecarga ou ataque.

Se essa instância parar, os clientes podem perder acesso a todos os serviços, mesmo que os serviços internos continuem funcionando.

Para reduzir o risco, eu consideraria:

- Executar múltiplas instâncias;
- Utilizar um balanceador na frente do Gateway;
- Configurar health checks;
- Distribuir as instâncias em zonas ou nós diferentes;
- Monitorar latência, erros e utilização de recursos;
- Planejar atualizações graduais.

**Explicação didática:**  

O Gateway concentra o acesso externo. Isso facilita a arquitetura para os clientes, mas aumenta sua importância operacional.

O fluxo pode ser representado assim:

~~~mermaid
flowchart LR
    C["Clientes"] --> L["Balanceador externo"]
    L --> G1["Gateway 1"]
    L --> G2["Gateway 2"]
    L --> G3["Gateway 3"]
    G1 --> S["Microsserviços"]
    G2 --> S
    G3 --> S
~~~

O balanceador distribui as requisições entre as instâncias do Gateway. Se uma instância apresentar falhas, ela pode ser removida temporariamente do tráfego.

**Exemplo prático:**  

Durante um pico de acessos, a única instância do Gateway atinge o limite de conexões e começa a responder lentamente. Criar instâncias adicionais e distribuir o tráfego reduz a concentração de carga.

**Como o candidato deve responder:**  

O candidato deve:

- Definir ponto único de falha;
- Relacionar o problema ao Gateway;
- Mencionar múltiplas instâncias;
- Citar balanceamento e health checks;
- Reconhecer que o Gateway também precisa ser escalável.

**Perguntas de aprofundamento:**  

1. Como você verificaria se o Gateway é o gargalo?
2. O que deveria acontecer quando uma instância do Gateway ficar indisponível?
3. Quais outros componentes da arquitetura poderiam ser pontos únicos de falha?

**Resposta fraca ou incompleta:**  

“Eu aumentaria a memória do Gateway.”

Isso pode ajudar temporariamente, mas não resolve o ponto único de falha nem garante alta disponibilidade.

**Critérios de avaliação:**  

- **0:** Não identifica o risco de uma única instância.
- **1:** Percebe apenas que o Gateway pode ficar lento.
- **2:** Sugere aumentar recursos, mas ignora redundância.
- **3:** Propõe múltiplas instâncias e balanceamento.
- **4:** Inclui health checks, monitoramento e atualizações graduais.
- **5:** Analisa disponibilidade, capacidade, zonas de falha, recuperação e custos operacionais.

---

# Pergunta 44 — Tratamento de erros no Gateway

**Nível:** Júnior  
**Categoria:** Troubleshooting e integração

**Pergunta do entrevistador:**  
Como você trataria erros retornados pelos microsserviços através do API Gateway para evitar respostas confusas aos clientes?

**O que essa pergunta avalia:**  

- Conhecimento sobre tratamento de erros;
- Compreensão de contratos de APIs;
- Capacidade de diferenciar erros técnicos e funcionais;
- Preocupação com experiência do consumidor.

**Resposta esperada:**  

Eu definiria uma estratégia consistente de erros no Gateway e nos serviços.

Essa estratégia poderia incluir:

- Códigos HTTP adequados;
- Corpo de erro padronizado;
- Identificador de correlação;
- Mensagem segura para o cliente;
- Registro detalhado nos logs internos;
- Não exposição de stack traces ou informações sensíveis;
- Tratamento diferente para erros de validação, autenticação, indisponibilidade e falhas internas.

O Gateway pode adaptar alguns erros técnicos, mas não deve esconder o significado funcional da resposta.

Por exemplo:

- `400` para requisição inválida;
- `401` para ausência ou invalidade de autenticação;
- `403` para falta de permissão;
- `404` para recurso não encontrado;
- `429` para excesso de requisições;
- `503` para indisponibilidade temporária;
- `500` para falha interna não tratada.

A utilização desses códigos deve seguir o contrato da API e o contexto da operação.

**Explicação didática:**  

Uma resposta como:

~~~json
{
  "timestamp": "2026-09-03T12:00:00Z",
  "status": 503,
  "code": "PAYMENT_SERVICE_UNAVAILABLE",
  "message": "Pagamento temporariamente indisponível",
  "requestId": "7f3a91"
}
~~~

é mais útil do que retornar uma exceção Java ou uma mensagem interna do banco de dados.

O cliente recebe informações suficientes para entender o resultado, enquanto os detalhes técnicos permanecem nos logs protegidos.

**Exemplo prático:**  

O serviço de pagamentos retorna um timeout. O Gateway pode devolver `503` com uma mensagem controlada, em vez de expor o endereço interno ou o stack trace da aplicação.

**Como o candidato deve responder:**  

O candidato deve:

- Mencionar padronização de erros;
- Diferenciar códigos HTTP;
- Falar sobre request ID;
- Evitar exposição de detalhes internos;
- Considerar que erros funcionais e técnicos podem exigir tratamentos diferentes.

**Perguntas de aprofundamento:**  

1. Você transformaria todo erro em HTTP 500?
2. Que informações não deveriam aparecer na resposta pública?
3. Como o cliente poderia informar o identificador de correlação ao suporte?

**Resposta fraca ou incompleta:**  

“Eu retornaria a mensagem da exceção para o cliente descobrir o problema.”

Essa abordagem pode expor informações sensíveis e tornar o contrato instável.

**Critérios de avaliação:**  

- **0:** Recomenda expor stack traces e detalhes internos.
- **1:** Conhece apenas o status 500.
- **2:** Cita alguns códigos, mas não propõe padronização.
- **3:** Explica tratamento básico e seguro de erros.
- **4:** Considera contratos, correlação, logs e diferentes categorias de falha.
- **5:** Discute consistência entre serviços, segurança, compatibilidade, observabilidade e impacto para consumidores.

---

# Pergunta 45 — Idempotência em chamadas distribuídas

**Nível:** Júnior  
**Categoria:** Resiliência e integração

**Pergunta do entrevistador:**  
O que significa tornar uma operação idempotente e por que isso é importante quando existem retentativas entre microsserviços?

**O que essa pergunta avalia:**  

- Compreensão de chamadas repetidas;
- Conhecimento sobre consistência;
- Capacidade de identificar risco de duplicidade;
- Noções de projeto seguro de APIs.

**Resposta esperada:**  

Uma operação idempotente produz o mesmo efeito final quando executada uma ou várias vezes com os mesmos dados.

Isso é importante porque uma requisição pode ser processada pelo serviço, mas a resposta pode ser perdida. O cliente então faz uma retentativa. Sem idempotência, uma operação como pagamento ou criação de pedido pode ser executada duas vezes.

Uma estratégia comum é utilizar uma chave de idempotência:

~~~http
POST /pagamentos
Idempotency-Key: pagamento-123-abc
~~~

O serviço registra a chave e associa a ela o resultado da primeira execução. Se receber novamente a mesma chave, pode retornar o resultado já processado em vez de executar a operação novamente.

A implementação precisa considerar:

- Escopo da chave;
- Tempo de retenção;
- Concorrência;
- Armazenamento;
- Respostas diferentes para a mesma chave com dados conflitantes;
- Segurança contra reutilização indevida.

**Explicação didática:**  

Uma operação de consulta geralmente não altera dados e tende a ser mais simples de repetir.

Já uma operação de pagamento pode causar um efeito financeiro. Se o primeiro pagamento for aprovado e a resposta se perder, uma nova tentativa precisa ser reconhecida como repetida.

Idempotência não significa que toda operação pode ser repetida sem análise. É necessário definir qual é a identidade da operação e como o sistema reconhecerá duplicidades.

**Exemplo prático:**  

O cliente envia uma solicitação para cobrar R$ 100,00. O serviço processa a cobrança, mas ocorre um timeout antes da resposta chegar. O cliente repete a chamada com a mesma chave de idempotência. O serviço retorna o resultado anterior e não cobra novamente.

**Como o candidato deve responder:**  

O candidato deve:

- Definir idempotência;
- Relacioná-la a retries e timeouts;
- Citar risco de duplicidade;
- Apresentar chave de idempotência como alternativa;
- Diferenciar operações de leitura e escrita;
- Considerar armazenamento e concorrência.

**Perguntas de aprofundamento:**  

1. O que deveria acontecer se a mesma chave vier com valores diferentes?
2. Como você testaria uma operação idempotente?
3. Toda requisição `POST` precisa ser idempotente?

**Resposta fraca ou incompleta:**  

“Idempotente é uma chamada que sempre retorna HTTP 200.”

Idempotência está relacionada ao efeito da operação, não apenas ao código HTTP retornado.

**Critérios de avaliação:**  

- **0:** Não entende o risco de repetição.
- **1:** Sabe apenas que retries podem duplicar operações.
- **2:** Cita uma chave, mas não explica seu funcionamento.
- **3:** Explica corretamente o conceito e sua relação com retries.
- **4:** Considera concorrência, armazenamento e operações financeiras.
- **5:** Discute garantias de processamento, janela de retenção, consistência, segurança e limites da estratégia.

---

# Pergunta 46 — Circuit breaker aberto indevidamente

**Nível:** Júnior  
**Categoria:** Resiliência e troubleshooting

**Pergunta do entrevistador:**  
O circuito de uma dependência permanece aberto mesmo depois que o serviço parece ter se recuperado. O que você investigaria?

**O que essa pergunta avalia:**  

- Capacidade de diagnosticar mecanismos de resiliência;
- Compreensão dos estados do circuit breaker;
- Análise de métricas e configuração;
- Diferenciação entre recuperação aparente e recuperação real.

**Resposta esperada:**  

Eu investigaria:

- Se o serviço realmente está saudável;
- Se os health checks estão corretos;
- Se o circuito possui uma janela de espera adequada;
- Se o estado `half-open` está sendo alcançado;
- Se as chamadas de teste continuam falhando;
- Se o percentual ou número de falhas configurado é muito baixo;
- Se os timeouts continuam ocorrendo;
- Se existe problema de rede entre os serviços;
- Se as métricas do circuito estão atualizadas;
- Se todas as instâncias da dependência foram recuperadas;
- Se alguma configuração foi alterada recentemente.

Também verificaria logs, métricas, traces e o estado do circuit breaker por instância.

O circuito pode estar aberto corretamente se as chamadas de teste ainda falharem, mesmo que a aplicação responda a verificações simples.

**Explicação didática:**  

O circuito normalmente passa por estados:

~~~mermaid
stateDiagram-v2
    [*] --> Closed
    Closed --> Open: Muitas falhas ou timeouts
    Open --> HalfOpen: Tempo de espera concluído
    HalfOpen --> Closed: Chamadas de teste funcionam
    HalfOpen --> Open: Chamadas de teste falham
~~~

O fato de o processo estar ativo não significa que ele consiga processar a operação real. Uma verificação superficial pode responder com sucesso enquanto a dependência crítica continua indisponível.

**Exemplo prático:**  

O serviço de pagamentos voltou a responder ao endpoint de saúde, mas ainda apresenta timeout ao consultar o banco. O circuit breaker continua aberto porque as chamadas reais ainda falham.

**Como o candidato deve responder:**  

O candidato deve:

- Citar os estados do circuito;
- Verificar métricas e logs;
- Considerar timeout e health checks;
- Avaliar a configuração de espera e limiares;
- Evitar simplesmente forçar o circuito para fechado sem investigar.

**Perguntas de aprofundamento:**  

1. Qual é o risco de fechar manualmente o circuito?
2. Como diferenciaria um problema no serviço de um problema na configuração do circuit breaker?
3. Que métricas indicariam recuperação real?

**Resposta fraca ou incompleta:**  

“Eu reiniciaria a aplicação para fechar o circuito.”

Isso pode apagar evidências e não corrige a causa do problema.

**Critérios de avaliação:**  

- **0:** Não entende os estados do circuito.
- **1:** Sugere apenas reiniciar a aplicação.
- **2:** Reconhece que o circuito pode permanecer aberto, mas não apresenta investigação.
- **3:** Verifica estado, falhas, timeout e configuração.
- **4:** Relaciona circuit breaker a health checks, métricas e recuperação parcial.
- **5:** Conduz uma análise baseada em evidências e considera limiares, janelas, instâncias e efeitos da intervenção.

---

# Pergunta 47 — Retry storm

**Nível:** Júnior  
**Categoria:** Resiliência e desempenho

**Pergunta do entrevistador:**  
O que é uma tempestade de retentativas e como ela pode afetar uma arquitetura Spring Cloud?

**O que essa pergunta avalia:**  

- Compreensão de efeitos colaterais de retries;
- Noções de sobrecarga e falhas em cascata;
- Capacidade de propor controles;
- Análise de comportamento em incidentes.

**Resposta esperada:**  

Uma tempestade de retentativas ocorre quando muitos clientes ou serviços repetem chamadas ao mesmo tempo após falhas.

Isso pode:

- Aumentar ainda mais a carga sobre a dependência;
- Consumir threads e conexões;
- Aumentar a latência;
- Produzir mais timeouts;
- Propagar a falha para outros serviços;
- Impedir a recuperação do componente afetado.

Para reduzir o risco, eu consideraria:

- Limite de tentativas;
- Backoff exponencial;
- Jitter;
- Timeout adequado;
- Circuit breaker;
- Bulkhead;
- Diferenciação entre erros temporários e permanentes;
- Idempotência;
- Monitoramento da taxa de retries.

Retries não devem ser aplicados indiscriminadamente.

**Explicação didática:**  

Imagine que um serviço esteja indisponível e mil requisições sejam repetidas imediatamente. Em vez de dar tempo para a recuperação, as novas chamadas podem manter o serviço sobrecarregado.

O fluxo problemático pode ser representado assim:

~~~mermaid
flowchart TD
    A["Dependência falha"] --> B["Muitos clientes detectam erro"]
    B --> C["Todos fazem retry imediatamente"]
    C --> D["Carga da dependência aumenta"]
    D --> E["Mais timeouts e falhas"]
    E --> C
~~~

O backoff aumenta o intervalo entre tentativas. O jitter evita que todos os clientes façam nova tentativa exatamente no mesmo instante.

**Exemplo prático:**  

Um serviço de catálogo apresenta lentidão. O Gateway, três microsserviços e vários clientes repetem chamadas automaticamente. O volume de requisições aumenta e a lentidão se transforma em indisponibilidade total.

**Como o candidato deve responder:**  

O candidato deve:

- Definir retry storm;
- Explicar o ciclo de sobrecarga;
- Citar limite, backoff e jitter;
- Mencionar circuit breaker;
- Considerar idempotência;
- Diferenciar erros temporários de erros permanentes.

**Perguntas de aprofundamento:**  

1. Você faria retry para um erro HTTP 401?
2. Como saberia que os retries estão piorando o incidente?
3. Onde deveria ser aplicada a retentativa: cliente, Gateway ou serviço?

**Resposta fraca ou incompleta:**  

“Eu aumentaria o número de tentativas para garantir que a chamada funcione.”

Essa abordagem pode agravar uma falha generalizada e não considera o tipo de erro.

**Critérios de avaliação:**  

- **0:** Recomenda retentativas ilimitadas.
- **1:** Sabe apenas que muitas tentativas podem gerar lentidão.
- **2:** Cita limitar tentativas, mas não explica o motivo.
- **3:** Explica o conceito e cita controles básicos.
- **4:** Considera backoff, jitter, circuit breaker e métricas.
- **5:** Analisa propagação de falhas, orçamento de latência, camadas de retry e impacto na recuperação.

---

# Pergunta 48 — Configuração de timeouts em cadeia

**Nível:** Júnior  
**Categoria:** Desempenho e resiliência

**Pergunta do entrevistador:**  
Por que a configuração de timeouts precisa ser analisada em conjunto quando uma requisição passa pelo Gateway e por vários microsserviços?

**O que essa pergunta avalia:**  

- Compreensão de latência distribuída;
- Capacidade de analisar timeouts em cadeia;
- Noções de orçamento de tempo;
- Identificação de configurações contraditórias.

**Resposta esperada:**  

Quando uma requisição passa por vários componentes, cada etapa adiciona latência e pode possuir seu próprio timeout.

Os timeouts precisam ser compatíveis. Se o Gateway encerra a requisição em 3 segundos, não faz sentido o serviço interno aguardar 10 segundos para concluir a mesma operação, pois a resposta provavelmente já não poderá ser entregue ao cliente.

Também é necessário considerar:

- Tempo de conexão;
- Tempo de leitura;
- Tempo de processamento;
- Latência entre serviços;
- Retentativas;
- Fallback;
- Tempo de resposta esperado pelo usuário;
- Limites de infraestrutura.

O timeout externo normalmente precisa ser maior que o tempo das operações internas, mas não deve ser tão alto a ponto de manter recursos ocupados indefinidamente.

**Explicação didática:**  

Considere o fluxo:

~~~mermaid
flowchart LR
    C["Cliente: limite de 8s"] --> G["Gateway: timeout de 7s"]
    G --> P["Pedidos: timeout de 5s"]
    P --> F["Pagamentos: timeout de 3s"]
    F --> B["Banco: timeout de 2s"]
~~~

Esses valores ainda precisam considerar overhead, serialização, rede e possíveis tentativas.

Se cada camada executar duas retentativas, o tempo total pode ultrapassar rapidamente o limite esperado.

**Exemplo prático:**  

O serviço de pagamentos possui timeout de 10 segundos, mas o Gateway possui timeout de 5 segundos. O cliente recebe erro após 5 segundos, enquanto o serviço de pedidos continua aguardando e consumindo recursos por mais tempo.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar que os timeouts se acumulam;
- Considerar a relação entre Gateway e serviços;
- Mencionar retentativas;
- Falar sobre consumo de recursos;
- Evitar definir timeouts isoladamente sem analisar o fluxo completo.

**Perguntas de aprofundamento:**  

1. O que acontece se o timeout do serviço interno for maior que o do Gateway?
2. Como retentativas alteram o tempo total da requisição?
3. Como escolheria um timeout inicial para uma chamada?

**Resposta fraca ou incompleta:**  

“Eu colocaria o maior timeout possível para não interromper a operação.”

Isso pode prender recursos por muito tempo e aumentar a propagação de falhas.

**Critérios de avaliação:**  

- **0:** Não reconhece a relação entre timeouts.
- **1:** Sabe apenas que timeout limita espera.
- **2:** Percebe que timeouts podem ser diferentes, mas não analisa a cadeia.
- **3:** Explica corretamente a necessidade de compatibilidade entre camadas.
- **4:** Considera latência, retries, recursos e experiência do usuário.
- **5:** Discute orçamento de latência, percentis, cascatas, operações críticas e critérios de dimensionamento.

---

# Pergunta 49 — Service mesh e Spring Cloud

**Nível:** Júnior  
**Categoria:** Arquitetura e integração

**Pergunta do entrevistador:**  
O que é um service mesh e como ele pode se relacionar com funcionalidades tradicionalmente implementadas com Spring Cloud?

**O que essa pergunta avalia:**  

- Conhecimento sobre responsabilidades de infraestrutura;
- Capacidade de comparar alternativas;
- Compreensão de comunicação entre serviços;
- Noções de trade-offs arquiteturais.

**Resposta esperada:**  

Service mesh é uma camada de infraestrutura dedicada a controlar e observar a comunicação entre serviços.

Dependendo da solução, ele pode oferecer:

- Descoberta de serviços;
- Balanceamento;
- Criptografia entre serviços;
- Controle de tráfego;
- Retentativas;
- Circuit breaking;
- Observabilidade;
- Políticas de segurança.

Algumas dessas responsabilidades também podem ser implementadas no código ou por componentes do Spring Cloud.

A escolha depende de fatores como:

- Plataforma utilizada;
- Linguagens dos serviços;
- Necessidade de padronização;
- Complexidade operacional;
- Experiência da equipe;
- Custo de execução;
- Necessidade de controle específico na aplicação.

Um service mesh não elimina todas as responsabilidades da aplicação. Regras de negócio, contratos e decisões funcionais continuam pertencendo aos serviços.

**Explicação didática:**  

Com uma solução baseada apenas em bibliotecas da aplicação, cada serviço pode carregar lógica de comunicação e resiliência.

Com um service mesh, parte dessa lógica pode ser deslocada para proxies ou componentes da infraestrutura:

~~~mermaid
flowchart LR
    A["Serviço A"] --> P1["Proxy"]
    P1 --> P2["Proxy"]
    P2 --> B["Serviço B"]
    M["Plano de controle"] -.-> P1
    M -.-> P2
~~~

Isso pode padronizar comportamentos entre serviços escritos em linguagens diferentes, mas acrescenta componentes e complexidade operacional.

**Exemplo prático:**  

Uma organização possui serviços Java, Python e Go. Um service mesh pode oferecer políticas comuns de comunicação, enquanto o Spring Cloud continua sendo utilizado para recursos específicos da aplicação.

**Como o candidato deve responder:**  

O candidato deve:

- Definir service mesh;
- Relacioná-lo à comunicação entre serviços;
- Comparar responsabilidades no código e na infraestrutura;
- Citar benefícios e custos;
- Evitar afirmar que uma solução sempre substitui completamente a outra.

**Perguntas de aprofundamento:**  

1. Que responsabilidade continuaria dentro do microsserviço?
2. Qual é o custo de adicionar um service mesh?
3. Em que situação uma solução no código poderia ser mais simples?

**Resposta fraca ou incompleta:**  

“Service mesh é outro tipo de API Gateway.”

Embora ambos possam lidar com tráfego, seus papéis e posições na arquitetura são diferentes.

**Critérios de avaliação:**  

- **0:** Confunde service mesh com banco, Gateway ou Service Registry.
- **1:** Sabe apenas que está relacionado à rede.
- **2:** Cita proxies, mas não explica as responsabilidades.
- **3:** Explica corretamente a finalidade geral.
- **4:** Compara infraestrutura e bibliotecas da aplicação.
- **5:** Discute padronização, linguagens, observabilidade, segurança, complexidade e trade-offs operacionais.

---

# Pergunta 50 — Diagnóstico de lentidão entre microsserviços

**Nível:** Júnior  
**Categoria:** Desempenho e troubleshooting

**Pergunta do entrevistador:**  
O tempo de resposta de uma API aumentou depois que uma chamada para outro microsserviço foi adicionada. Como você investigaria e corrigiria o problema?

**O que essa pergunta avalia:**  

- Raciocínio de análise de desempenho;
- Uso de métricas, logs e tracing;
- Compreensão de latência de rede;
- Capacidade de propor correções sem conclusões precipitadas.

**Resposta esperada:**  

Eu começaria comparando o comportamento antes e depois da mudança e identificaria em qual etapa o tempo está sendo consumido.

Investigaria:

- Latência da chamada entre serviços;
- Percentis de resposta, como p95 e p99;
- Timeouts;
- Retentativas;
- Estado do circuit breaker;
- Tempo de processamento no serviço chamado;
- Consultas ao banco;
- Serialização e tamanho das mensagens;
- Uso de CPU, memória e conexões;
- Problemas de rede;
- Traces distribuídos;
- Logs com correlation ID.

Depois avaliaria possíveis soluções:

- Otimizar a operação lenta;
- Criar ou ajustar índices no banco;
- Reduzir o tamanho da resposta;
- Evitar chamadas desnecessárias;
- Utilizar cache quando apropriado;
- Processar de forma assíncrona;
- Paralelizar chamadas independentes;
- Ajustar timeouts;
- Corrigir retries excessivos;
- Escalar o serviço responsável.

A correção deve ser baseada em evidências. Aumentar o timeout pode apenas esconder o problema.

**Explicação didática:**  

Uma chamada remota adiciona:

- Tempo de conexão;
- Latência de rede;
- Processamento no serviço chamado;
- Acesso a dependências;
- Serialização e desserialização;
- Possíveis retentativas.

O fluxo pode ser analisado com tracing:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant G as Gateway
    participant P as Pedido
    participant F as Dependência

    C->>G: Requisição
    G->>P: Encaminhamento
    P->>F: Chamada remota
    Note over F: Operação leva 4 segundos
    F-->>P: Resposta
    P-->>G: Resposta
    G-->>C: Resposta final
~~~

Se o trace mostrar que a dependência consumiu quase todo o tempo, a investigação deve se concentrar nela e em suas dependências.

**Exemplo prático:**  

A API de pedidos passou de 200 ms para 3 segundos. O tracing mostra que o novo serviço de clientes faz uma consulta sem índice, provocando lentidão no banco.

A correção pode envolver otimização da consulta, criação de índice e validação do ganho por métricas.

**Como o candidato deve responder:**  

O candidato deve:

- Comparar métricas antes e depois;
- Usar tracing, logs e métricas;
- Investigar a cadeia completa;
- Considerar retries e timeouts;
- Diferenciar causa de sintoma;
- Propor correções baseadas em evidências;
- Evitar aumentar timeouts como única solução.

**Perguntas de aprofundamento:**  

1. Como descobriria se a lentidão está no Gateway ou no serviço de destino?
2. Quando cache poderia piorar o problema?
3. Como validaria que a correção não criou inconsistência?

**Resposta fraca ou incompleta:**  

“Eu aumentaria o timeout da requisição para ela não falhar.”

Essa abordagem pode aumentar o tempo de espera e consumir mais recursos sem corrigir a causa.

**Critérios de avaliação:**  

- **0:** Não apresenta método de investigação.
- **1:** Sugere apenas aumentar timeout ou recursos.
- **2:** Consulta logs, mas não avalia a cadeia de dependências.
- **3:** Investiga latência, serviço chamado, banco e rede.
- **4:** Utiliza tracing, percentis, retries, cache e otimização.
- **5:** Conduz análise completa de desempenho, identifica gargalos com evidências e avalia os trade-offs de cada correção.

---

## Resumo desta parte

- **Perguntas apresentadas:** 41 a 50
- **Perguntas restantes:** 50
- **Nível abordado:** Júnior
- **Categorias cobertas:**
  - Gateway e configuração;
  - Filtros globais e de rota;
  - Alta disponibilidade;
  - Tratamento de erros;
  - Idempotência;
  - Circuit breaker;
  - Retry storm;
  - Timeouts;
  - Service mesh;
  - Desempenho;
  - Troubleshooting.

## Matriz parcial de competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---:|---|
| Estrutura de rotas | Júnior | 41 | Compreende ID, URI, predicados e filtros |
| Escopo de filtros | Júnior | 42 | Diferencia filtros globais e específicos |
| Alta disponibilidade do Gateway | Júnior | 43 | Identifica pontos únicos de falha e propõe redundância |
| Tratamento de erros | Júnior | 44 | Padroniza respostas sem expor informações internas |
| Idempotência | Júnior | 45 | Compreende duplicidade e uso de chaves de idempotência |
| Diagnóstico de circuit breaker | Júnior | 46 | Investiga estados, limiares, timeouts e health checks |
| Controle de retries | Júnior | 47 | Reconhece retry storm, backoff, jitter e sobrecarga |
| Configuração de timeouts | Júnior | 48 | Analisa a cadeia de latência entre componentes |
| Service mesh | Júnior | 49 | Compara responsabilidades da aplicação e da infraestrutura |
| Análise de desempenho | Júnior | 50 | Utiliza métricas, logs e tracing para encontrar gargalos |

## Recomendações específicas para o entrevistador

- Peça ao candidato para interpretar uma rota completa do Gateway.
- Avalie se ele sabe distinguir escopo global de escopo específico.
- Explore os riscos de transformar o Gateway em um ponto único de falha.
- Em perguntas de resiliência, verifique se o candidato considera duplicidade e sobrecarga.
- Pergunte como ele comprovaria a existência de um gargalo.
- Observe se ele aumenta timeouts ou retries sem investigar a causa.
- Avalie a capacidade de diferenciar uma solução de aplicação de uma solução de infraestrutura.
- Utilize cenários com falha parcial, pois eles revelam melhor o raciocínio do candidato.
- Não exija conhecimento aprofundado de service mesh para nível Júnior, mas avalie a compreensão conceitual.

## Recomendações específicas para o candidato

- Ao explicar uma rota, descreva o caminho da requisição desde o cliente até o serviço.
- Diferencie claramente predicado, filtro, destino e escopo.
- Ao falar de retries, mencione limite, backoff, jitter e idempotência.
- Ao discutir timeouts, analise todas as camadas da comunicação.
- Não trate o Gateway como responsável por toda a lógica da aplicação.
- Use logs, métricas e traces para justificar conclusões de troubleshooting.
- Evite propor aumento de recursos ou timeout sem evidências.
- Ao falar de segurança e erros, proteja informações internas.
- Em decisões arquiteturais, apresente benefícios, custos e limitações.

---

# Roteiro de Entrevista Técnica — Spring Cloud

## Perguntas 51 a 60

> Continuação do roteiro para avaliação de nível Júnior, com perguntas conceituais, práticas e baseadas em cenários reais.

---

# Pergunta 51 — Configuração de descoberta no Gateway

**Nível:** Júnior  
**Categoria:** Gateway e Service Discovery

**Pergunta do entrevistador:**  
Como o Spring Cloud Gateway pode localizar um microsserviço registrado por nome lógico, sem utilizar diretamente um endereço IP fixo?

**O que essa pergunta avalia:**  

- Compreensão da integração entre Gateway e Service Discovery;
- Conhecimento sobre nomes lógicos de serviços;
- Noções de balanceamento de carga;
- Capacidade de explicar um fluxo de roteamento.

**Resposta esperada:**  

O Gateway pode utilizar um mecanismo de descoberta de serviços para localizar as instâncias disponíveis de um serviço.

Em vez de configurar um endereço fixo, como:

~~~yaml
uri: http://10.0.0.20:8080
~~~

pode-se utilizar um nome lógico com balanceamento:

~~~yaml
uri: lb://pedido-service
~~~

Nesse caso, o Gateway consulta o mecanismo de descoberta, obtém as instâncias disponíveis do `pedido-service` e encaminha a requisição para uma delas.

Para isso, é necessário que:

- O serviço esteja registrado;
- O nome utilizado corresponda ao nome registrado;
- O Gateway tenha integração com descoberta e balanceamento;
- As instâncias estejam saudáveis;
- A configuração de rede esteja correta.

A configuração exata depende da versão do Spring Cloud e da solução de descoberta utilizada.

**Explicação didática:**  

O nome `pedido-service` é um identificador lógico. Ele representa o serviço, mas não informa diretamente qual máquina atenderá a requisição.

O fluxo pode ser representado assim:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant G as Gateway
    participant R as Service Registry
    participant P1 as Pedido 1
    participant P2 as Pedido 2

    C->>G: GET /pedidos/10
    G->>R: Consultar pedido-service
    R-->>G: Instâncias disponíveis
    G->>P1: Encaminhar requisição
    P1-->>G: Resposta
    G-->>C: Resposta
~~~

Essa abordagem facilita a criação e remoção de instâncias sem exigir alteração manual no Gateway.

**Exemplo prático:**  

Durante um aumento de tráfego, duas novas instâncias do `pedido-service` são iniciadas e registradas. O Gateway passa a utilizá-las sem alterar todas as rotas manualmente.

**Exemplo de código:**  

~~~yaml
spring:
  cloud:
    gateway:
      routes:
        - id: pedidos
          uri: lb://pedido-service
          predicates:
            - Path=/pedidos/**
~~~

O prefixo `lb://` indica que o destino deve ser resolvido por um mecanismo de balanceamento compatível.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar nome lógico e endereço físico;
- Mencionar o Service Registry;
- Explicar o uso conceitual de `lb://`;
- Citar múltiplas instâncias;
- Considerar saúde e disponibilidade;
- Evitar afirmar que o Gateway consegue localizar qualquer serviço automaticamente sem configuração.

**Perguntas de aprofundamento:**  

1. O que aconteceria se o nome do serviço estivesse escrito incorretamente?
2. Como você investigaria um erro de serviço não encontrado?
3. Quando uma URI fixa poderia ser aceitável?

**Resposta fraca ou incompleta:**  

“Eu usaria o nome do serviço na URL, e o Spring encontraria automaticamente.”

A resposta não menciona registro, integração com descoberta, balanceamento ou configuração.

**Critérios de avaliação:**  

- **0:** Não entende a resolução por nome lógico.
- **1:** Sabe apenas que existe uma URL diferente.
- **2:** Cita Service Discovery, mas não explica o fluxo.
- **3:** Explica corretamente o uso de nome lógico e balanceamento.
- **4:** Considera instâncias, saúde, configuração e troubleshooting.
- **5:** Discute descoberta, disponibilidade, consistência, observabilidade e alternativas de infraestrutura.

---

# Pergunta 52 — Gateway e autenticação baseada em token

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como um API Gateway pode participar do processo de autenticação de requisições que utilizam tokens?

**O que essa pergunta avalia:**  

- Conhecimento básico sobre autenticação;
- Compreensão do papel do Gateway;
- Noções de tokens e autorização;
- Capacidade de identificar limites de segurança.

**Resposta esperada:**  

O Gateway pode validar a presença, a assinatura, a validade e alguns dados de um token antes de encaminhar a requisição.

Ele pode verificar, por exemplo:

- Se o token foi enviado;
- Se está expirado;
- Se foi assinado por uma autoridade confiável;
- Se o emissor é válido;
- Se os escopos ou roles necessários estão presentes;
- Se a requisição deve ser encaminhada.

Depois da autenticação inicial, os microsserviços ainda devem validar as permissões relacionadas às próprias regras de negócio.

O Gateway não deve confiar cegamente em informações enviadas pelo cliente em headers. A identidade deve ser derivada de um token validado ou de uma comunicação interna confiável.

**Explicação didática:**  

Autenticação confirma a identidade do solicitante. Autorização verifica se essa identidade pode executar determinada ação.

O fluxo pode ser:

~~~mermaid
flowchart LR
    A["Cliente envia token"] --> B["Gateway valida token"]
    B -->|"Inválido"| C["Retorna 401"]
    B -->|"Válido"| D["Encaminha requisição"]
    D --> E["Serviço verifica autorização de domínio"]
    E -->|"Sem permissão"| F["Retorna 403"]
    E -->|"Permitido"| G["Executa operação"]
~~~

Um token válido não significa que o usuário pode acessar todos os recursos. Ele apenas fornece uma identidade e, possivelmente, informações sobre permissões.

**Exemplo prático:**  

Um usuário autenticado possui permissão para consultar pedidos, mas não para cancelar pedidos de outros usuários.

O Gateway valida o token. O `pedido-service` verifica se aquele usuário pode cancelar o pedido específico.

**Exemplo de código:**  

Uma configuração conceitual de um recurso protegido pode ser:

~~~yaml
spring:
  cloud:
    gateway:
      routes:
        - id: pedidos
          uri: lb://pedido-service
          predicates:
            - Path=/pedidos/**
          filters:
            - TokenRelay
~~~

A utilização e a configuração exatas dependem do mecanismo de autenticação e da versão adotada.

**Como o candidato deve responder:**  

O candidato deve:

- Diferenciar autenticação e autorização;
- Explicar a validação inicial do token;
- Informar que os serviços também devem proteger suas regras;
- Mencionar respostas `401` e `403`;
- Evitar confiar apenas em headers enviados pelo cliente;
- Considerar expiração e assinatura do token.

**Perguntas de aprofundamento:**  

1. Qual é a diferença entre HTTP 401 e HTTP 403?
2. Por que o serviço ainda precisa validar autorização?
3. O que você faria se o provedor de identidade estivesse indisponível?

**Resposta fraca ou incompleta:**  

“O Gateway verifica se existe um token no header e libera a requisição.”

Essa resposta não verifica validade, assinatura, expiração ou permissões.

**Critérios de avaliação:**  

- **0:** Recomenda confiar em qualquer token ou header.
- **1:** Sabe apenas que o token fica no header.
- **2:** Reconhece autenticação, mas não diferencia autorização.
- **3:** Explica validação básica e responsabilidades dos serviços.
- **4:** Considera expiração, assinatura, escopos e códigos HTTP.
- **5:** Discute defesa em profundidade, identidade de serviço, menor privilégio e falhas do provedor de identidade.

---

# Pergunta 53 — Propagação de contexto de segurança

**Nível:** Júnior  
**Categoria:** Segurança e comunicação

**Pergunta do entrevistador:**  
Quando o Gateway encaminha uma requisição para um microsserviço, como as informações de identidade e segurança podem ser propagadas com segurança?

**O que essa pergunta avalia:**  

- Compreensão de identidade em chamadas internas;
- Noções de propagação de tokens;
- Capacidade de reconhecer riscos de headers falsificados;
- Conhecimento básico de segurança entre serviços.

**Resposta esperada:**  

As informações de segurança podem ser propagadas por meio de um token validado, de credenciais de serviço ou de um mecanismo de identidade confiável.

Algumas possibilidades são:

- Encaminhar o token original, quando apropriado;
- Emitir um token específico para o serviço de destino;
- Utilizar credenciais de serviço;
- Usar mTLS ou outro mecanismo de autenticação entre serviços;
- Propagar apenas claims necessários.

Os serviços não devem confiar em headers arbitrários enviados diretamente pelo cliente. Se o Gateway adicionar um header com o usuário autenticado, o serviço deve garantir que o cliente não consiga inserir ou substituir esse valor indevidamente.

Também é necessário evitar propagar dados excessivos ou sensíveis.

**Explicação didática:**  

Um header como:

~~~http
X-User-Id: 42
~~~

não é seguro por si só. Um cliente poderia tentar enviá-lo com outro valor.

O serviço precisa confiar apenas em informações:

- Assinadas;
- Validadas;
- Inseridas por um componente confiável;
- Protegidas contra alteração.

A comunicação entre serviços deve considerar tanto a identidade do usuário quanto a identidade do próprio serviço chamador.

**Exemplo prático:**  

O Gateway autentica uma chamada e encaminha ao `pedido-service`. O serviço verifica o token ou uma credencial interna antes de permitir o acesso.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar que headers livres não são suficientes;
- Mencionar tokens ou identidade de serviço;
- Considerar comunicação interna protegida;
- Falar sobre princípio do menor privilégio;
- Evitar encaminhar informações sensíveis sem necessidade.

**Perguntas de aprofundamento:**  

1. Por que não basta enviar o ID do usuário em um header?
2. Você encaminharia sempre o token original?
3. Como protegeria a comunicação entre Gateway e microsserviços?

**Resposta fraca ou incompleta:**  

“Eu adicionaria o usuário em um header e confiaria nele.”

Essa prática permite falsificação de identidade caso o header não seja protegido e validado.

**Critérios de avaliação:**  

- **0:** Recomenda confiar em qualquer informação enviada pelo cliente.
- **1:** Sabe apenas que o token pode ser encaminhado.
- **2:** Reconhece headers, mas não identifica riscos de falsificação.
- **3:** Explica propagação segura de identidade.
- **4:** Considera tokens, credenciais de serviço e menor privilégio.
- **5:** Discute identidade do usuário e do serviço, mTLS, claims mínimos e ameaças internas.

---

# Pergunta 54 — Configuração de TLS

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Por que o uso de HTTPS e TLS é importante na comunicação entre clientes, Gateway e microsserviços?

**O que essa pergunta avalia:**  

- Conhecimento básico sobre criptografia em trânsito;
- Consciência de segurança;
- Compreensão de certificados;
- Capacidade de identificar riscos de comunicação sem proteção.

**Resposta esperada:**  

HTTPS utiliza TLS para proteger os dados durante o transporte.

Ele ajuda a garantir:

- Confidencialidade;
- Integridade;
- Autenticidade do servidor;
- Proteção contra interceptação e alteração das mensagens.

A proteção deve ser considerada tanto na comunicação entre cliente e Gateway quanto, quando necessário, entre Gateway e serviços internos.

Os cuidados incluem:

- Utilizar certificados válidos;
- Verificar a cadeia de confiança;
- Evitar desabilitar a validação em produção;
- Controlar versões e protocolos permitidos;
- Planejar renovação dos certificados;
- Proteger chaves privadas;
- Monitorar falhas de handshake.

Em ambientes internos, o fato de a rede ser privada não elimina automaticamente a necessidade de proteção.

**Explicação didática:**  

Sem TLS, alguém com acesso à rede pode tentar:

- Ler tokens;
- Capturar dados pessoais;
- Alterar requisições;
- Interceptar respostas;
- Personificar um serviço.

Com TLS, o cliente valida se está falando com o servidor esperado, e os dados são criptografados durante o transporte.

**Exemplo prático:**  

O Gateway recebe um token de autenticação e o encaminha ao serviço de pedidos. Se a comunicação interna não estiver protegida, o token poderá ser exposto em caso de interceptação.

**Exemplo de código:**  

Uma configuração conceitual de HTTPS no servidor pode ser:

~~~yaml
server:
  ssl:
    enabled: true
    key-store: classpath:server-keystore.p12
    key-store-password: ${KEYSTORE_PASSWORD}
    key-store-type: PKCS12
~~~

A senha não deve ser armazenada diretamente no arquivo de configuração. Em produção, certificados e chaves devem ser gerenciados de forma segura.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar confidencialidade, integridade e autenticidade;
- Mencionar certificados;
- Falar sobre proteção de chaves;
- Evitar recomendar desabilitar validações;
- Considerar comunicação interna e externa.

**Perguntas de aprofundamento:**  

1. O que pode acontecer se o certificado expirar?
2. Por que não devemos desabilitar a validação TLS em produção?
3. Qual é a diferença entre TLS e autenticação do usuário?

**Resposta fraca ou incompleta:**  

“HTTPS serve apenas para esconder a URL.”

HTTPS protege a comunicação e a identidade do servidor; não tem como finalidade esconder a URL.

**Critérios de avaliação:**  

- **0:** Recomenda comunicação sem criptografia ou desabilitação de validações.
- **1:** Sabe apenas que HTTPS criptografa dados.
- **2:** Cita certificados, mas não explica seus objetivos.
- **3:** Explica corretamente a importância do TLS.
- **4:** Considera chaves, renovação, certificados e comunicação interna.
- **5:** Discute mTLS, cadeia de confiança, rotação, observabilidade e segurança de ponta a ponta.

---

# Pergunta 55 — Spring Cloud Bus

**Nível:** Júnior  
**Categoria:** Configuração distribuída

**Pergunta do entrevistador:**  
Qual é a finalidade do Spring Cloud Bus em uma arquitetura com configuração centralizada?

**O que essa pergunta avalia:**  

- Compreensão de propagação de eventos;
- Conhecimento básico sobre atualização distribuída;
- Relação entre mensageria e configuração;
- Capacidade de identificar limitações operacionais.

**Resposta esperada:**  

O Spring Cloud Bus pode ser utilizado para propagar eventos entre instâncias de aplicações, geralmente por meio de um broker de mensagens.

Em um cenário de configuração centralizada, uma alteração pode gerar um evento para informar várias instâncias de que uma atualização está disponível.

Isso pode evitar a necessidade de atualizar cada instância manualmente, desde que:

- O mecanismo de mensageria esteja configurado;
- As aplicações estejam conectadas ao barramento;
- Os componentes suportem refresh;
- A alteração tenha sido validada;
- Exista controle de segurança e auditoria.

O Bus não significa que qualquer alteração será aplicada automaticamente a todos os componentes. A aplicação precisa estar preparada para atualizar a configuração com segurança.

**Explicação didática:**  

Sem um barramento, uma equipe poderia precisar solicitar refresh individualmente em cada instância.

Com um barramento:

~~~mermaid
flowchart LR
    C["Alteração de configuração"] --> B["Broker ou Bus"]
    B --> A1["Instância 1"]
    B --> A2["Instância 2"]
    B --> A3["Instância 3"]
    A1 --> R["Refresh"]
    A2 --> R
    A3 --> R
~~~

Esse modelo reduz trabalho manual, mas adiciona dependências e pode gerar mudanças simultâneas em muitas instâncias.

**Exemplo prático:**  

A equipe altera uma configuração de timeout e publica um evento. As instâncias recebem o evento e atualizam o valor conforme a estratégia definida.

Antes disso, a mudança deve ser testada e autorizada.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar a propagação de eventos;
- Relacionar o Bus à atualização distribuída;
- Mencionar broker e refresh;
- Considerar segurança e auditoria;
- Reconhecer o risco de alterar muitas instâncias simultaneamente.

**Perguntas de aprofundamento:**  

1. O que acontece se uma instância não receber o evento?
2. Como reverteria uma configuração aplicada incorretamente?
3. Você atualizaria dinamicamente qualquer propriedade?

**Resposta fraca ou incompleta:**  

“Spring Cloud Bus sincroniza automaticamente todos os arquivos.”

A resposta é simplista e não considera eventos, broker, refresh, falhas ou validação.

**Critérios de avaliação:**  

- **0:** Não entende o propósito do Bus.
- **1:** Sabe apenas que está relacionado à configuração.
- **2:** Cita propagação, mas não explica como.
- **3:** Explica corretamente eventos e atualização distribuída.
- **4:** Considera refresh, broker, segurança e rollback.
- **5:** Discute consistência entre instâncias, falhas de entrega, governança e rollout controlado.

---

# Pergunta 56 — Configuração resiliente

**Nível:** Júnior  
**Categoria:** Resiliência e configuração

**Pergunta do entrevistador:**  
O que deve acontecer com uma aplicação quando o servidor de configuração centralizada fica temporariamente indisponível?

**O que essa pergunta avalia:**  

- Capacidade de analisar dependências críticas;
- Conhecimento sobre inicialização e operação;
- Noções de fallback de configuração;
- Raciocínio sobre disponibilidade.

**Resposta esperada:**  

A decisão depende da importância da configuração e da estratégia adotada.

Algumas possibilidades são:

- Utilizar a última configuração válida em cache;
- Iniciar com valores locais seguros;
- Impedir a inicialização se não houver configuração obrigatória;
- Continuar executando com a configuração já carregada;
- Alertar a equipe e registrar o incidente.

Para escolher a abordagem, é necessário separar:

- Configurações obrigatórias;
- Configurações opcionais;
- Valores seguros padrão;
- Configurações sensíveis;
- Alterações que exigem reinicialização.

Não é seguro iniciar uma aplicação com valores desconhecidos ou com configurações potencialmente perigosas apenas para mantê-la “online”.

**Explicação didática:**  

Se a aplicação já iniciou e possui uma configuração válida em memória, ela talvez consiga continuar funcionando temporariamente.

Porém, uma nova instância pode não conseguir iniciar sem o servidor de configuração. Esse comportamento deve ser planejado.

O fluxo pode ser:

~~~mermaid
flowchart TD
    A["Aplicação inicia"] --> B{"Config Server disponível?"}
    B -->|"Sim"| C["Carregar e validar configuração"]
    B -->|"Não"| D{"Existe configuração segura local?"}
    D -->|"Sim"| E["Iniciar com configuração controlada"]
    D -->|"Não"| F["Falhar de forma explícita e gerar alerta"]
~~~

**Exemplo prático:**  

O servidor de configuração fica indisponível durante uma implantação. Instâncias antigas continuam usando a configuração carregada, mas novas instâncias não conseguem iniciar.

A equipe precisa identificar essa diferença e avaliar a capacidade de recuperação.

**Como o candidato deve responder:**  

O candidato deve:

- Evitar assumir que existe uma resposta única;
- Diferenciar aplicação já iniciada de nova instância;
- Considerar cache e valores locais;
- Falar sobre configuração obrigatória;
- Mencionar alerta, logs e segurança.

**Perguntas de aprofundamento:**  

1. Você iniciaria um serviço sem conhecer a URL do banco?
2. Como garantiria que um valor local não está desatualizado?
3. Qual seria o impacto de permitir que cada instância use uma configuração diferente?

**Resposta fraca ou incompleta:**  

“Eu reiniciaria até o servidor voltar.”

A resposta não trata disponibilidade, cache, configuração local nem riscos de inconsistência.

**Critérios de avaliação:**  

- **0:** Recomenda iniciar com qualquer valor ou ignorar a falha.
- **1:** Sabe apenas que a aplicação pode apresentar erro.
- **2:** Cita cache, mas não analisa configurações obrigatórias.
- **3:** Explica alternativas básicas e comportamento esperado.
- **4:** Considera instâncias novas, valores seguros, alertas e consistência.
- **5:** Propõe uma estratégia de resiliência, governança, validação e recuperação operacional.

---

# Pergunta 57 — Eventos duplicados em mensageria

**Nível:** Júnior  
**Categoria:** Mensageria e consistência

**Pergunta do entrevistador:**  
Um consumidor de eventos recebe duas vezes a mensagem `PedidoCriado`. Como você evitaria que o pedido fosse processado indevidamente duas vezes?

**O que essa pergunta avalia:**  

- Conhecimento sobre entrega de mensagens;
- Compreensão de idempotência;
- Capacidade de tratar duplicidade;
- Noções de consistência e persistência.

**Resposta esperada:**  

Eu projetaria o consumidor para ser idempotente.

Algumas estratégias são:

- Utilizar um identificador único do evento;
- Registrar eventos já processados;
- Criar uma restrição única no banco;
- Verificar o estado atual antes de executar a operação;
- Utilizar uma transação adequada;
- Confirmar a mensagem somente após o processamento necessário;
- Reprocessar com segurança em caso de falha.

O consumidor não deve assumir que cada mensagem será entregue exatamente uma vez. Mesmo quando o broker oferece determinadas garantias, duplicidades podem surgir por falhas, retries ou reentrega.

**Explicação didática:**  

Um evento pode ser entregue ao consumidor, mas a aplicação pode falhar antes de confirmar o processamento. O broker então reenvia a mensagem.

O consumidor precisa distinguir:

- Evento ainda não processado;
- Evento já processado;
- Evento em processamento;
- Evento com conteúdo conflitante.

O fluxo pode ser:

~~~mermaid
flowchart TD
    A["Receber evento"] --> B{"Evento já processado?"}
    B -->|"Sim"| C["Ignorar ou retornar resultado anterior"]
    B -->|"Não"| D["Processar em transação"]
    D --> E["Registrar evento processado"]
    E --> F["Confirmar mensagem"]
~~~

O registro da mensagem processada deve ser consistente com a operação realizada.

**Exemplo prático:**  

O evento `PedidoCriado` chega duas vezes. Na primeira entrega, o estoque é reservado. Na segunda, o consumidor identifica o ID já processado e não cria uma nova reserva.

**Como o candidato deve responder:**  

O candidato deve:

- Falar sobre idempotência;
- Utilizar um identificador único;
- Considerar persistência e transação;
- Explicar o risco de confirmar antes de processar;
- Evitar depender apenas de uma variável em memória.

**Perguntas de aprofundamento:**  

1. O que aconteceria se a aplicação caísse depois de salvar a reserva, mas antes de confirmar a mensagem?
2. Como testaria o reprocessamento?
3. Qual é a diferença entre deduplicação em memória e no banco?

**Resposta fraca ou incompleta:**  

“Eu verificaria se a mensagem é igual à anterior usando uma variável local.”

Essa estratégia não funciona adequadamente com múltiplas instâncias ou após reinicializações.

**Critérios de avaliação:**  

- **0:** Processa todas as mensagens sem controle.
- **1:** Percebe que há duplicidade, mas não propõe solução.
- **2:** Sugere guardar IDs, mas apenas em memória.
- **3:** Explica idempotência e registro persistente.
- **4:** Considera transações, retries e confirmação da mensagem.
- **5:** Analisa atomicidade, concorrência, reprocessamento, ordenação e garantias do broker.

---

# Pergunta 58 — Dead-letter queue

**Nível:** Júnior  
**Categoria:** Mensageria e troubleshooting

**Pergunta do entrevistador:**  
O que é uma dead-letter queue e em que situação ela pode ser útil em uma aplicação que utiliza Spring Cloud Stream?

**O que essa pergunta avalia:**  

- Conhecimento sobre tratamento de mensagens com falha;
- Noções de reprocessamento;
- Capacidade de evitar perda de mensagens;
- Compreensão de operação de sistemas assíncronos.

**Resposta esperada:**  

Uma dead-letter queue, ou fila de mensagens não processadas, armazena mensagens que não puderam ser processadas após as tentativas configuradas.

Ela é útil para:

- Evitar descarte silencioso de mensagens;
- Separar mensagens problemáticas;
- Investigar erros;
- Corrigir dados ou código antes de reprocessar;
- Monitorar falhas de consumidores.

Uma mensagem pode ir para a dead-letter queue por motivos como:

- Payload inválido;
- Falha de validação;
- Dependência indisponível;
- Erro inesperado;
- Versão incompatível do evento;
- Excesso de tentativas.

A fila não deve ser tratada como depósito permanente. É necessário definir retenção, monitoramento, análise e procedimento de reprocessamento.

**Explicação didática:**  

O fluxo pode ser:

~~~mermaid
flowchart TD
    A["Consumidor recebe mensagem"] --> B{"Processamento funcionou?"}
    B -->|"Sim"| C["Confirmar mensagem"]
    B -->|"Não"| D{"Ainda há tentativas?"}
    D -->|"Sim"| E["Aguardar e tentar novamente"]
    D -->|"Não"| F["Enviar para dead-letter queue"]
    F --> G["Investigar e reprocessar quando apropriado"]
~~~

A mensagem deve ser analisada antes de ser reenviada. Caso o erro esteja no conteúdo, reprocessar continuamente pode gerar uma nova sequência de falhas.

**Exemplo prático:**  

Um evento chega com um campo obrigatório ausente. Após algumas tentativas, ele é enviado para a dead-letter queue. A equipe corrige a origem do evento ou adapta o consumidor e depois avalia o reprocessamento.

**Como o candidato deve responder:**  

O candidato deve:

- Definir dead-letter queue;
- Explicar sua relação com retries;
- Mencionar investigação e reprocessamento;
- Considerar monitoramento;
- Evitar descartar mensagens sem rastreabilidade.

**Perguntas de aprofundamento:**  

1. Você reprocessaria automaticamente qualquer mensagem da dead-letter queue?
2. Como saberia que a fila está crescendo?
3. Qual é a diferença entre um erro temporário e um payload inválido?

**Resposta fraca ou incompleta:**  

“É uma fila onde colocamos mensagens que deram erro e esquecemos delas.”

A resposta não considera análise, monitoramento, retenção ou reprocessamento controlado.

**Critérios de avaliação:**  

- **0:** Recomenda descartar mensagens com erro.
- **1:** Reconhece que existe uma fila alternativa.
- **2:** Entende o armazenamento, mas não explica o uso operacional.
- **3:** Explica corretamente a finalidade da dead-letter queue.
- **4:** Considera retries, monitoramento e reprocessamento.
- **5:** Discute classificação de falhas, retenção, governança, observabilidade e prevenção de loops.

---

# Pergunta 59 — Ordenação de eventos

**Nível:** Júnior  
**Categoria:** Mensageria e consistência

**Pergunta do entrevistador:**  
Por que a ordem de entrega de eventos pode ser importante em um sistema distribuído?

**O que essa pergunta avalia:**  

- Compreensão de eventos relacionados;
- Noções de consistência;
- Capacidade de identificar dependências temporais;
- Conhecimento básico sobre limitações de mensageria.

**Resposta esperada:**  

A ordem pode ser importante quando eventos representam uma sequência de mudanças que depende do estado anterior.

Por exemplo:

~~~text
PedidoCriado
PagamentoAprovado
PedidoEnviado
~~~

Processar `PedidoEnviado` antes de `PedidoCriado` pode causar inconsistência.

A garantia de ordenação depende do broker, da configuração e da forma como os eventos são distribuídos. Muitas soluções garantem ordem apenas dentro de uma partição, fila ou chave específica, e não globalmente.

Para lidar com problemas de ordem, podem ser utilizadas estratégias como:

- Chavear eventos pela entidade;
- Verificar versão ou número de sequência;
- Rejeitar ou aguardar eventos fora de ordem;
- Tornar o processamento tolerante;
- Reconciliar o estado posteriormente.

Garantir ordem global pode reduzir paralelismo e desempenho.

**Explicação didática:**  

Considere dois eventos do mesmo pedido:

~~~mermaid
sequenceDiagram
    participant B as Broker
    participant C as Consumidor

    B->>C: PedidoCriado, versão 1
    B->>C: PagamentoAprovado, versão 2
    C->>C: Atualiza estado na ordem esperada
~~~

Se eventos de pedidos diferentes puderem ser processados em paralelo, é possível obter bom desempenho sem exigir uma ordem global para todo o sistema.

**Exemplo prático:**  

Para o pedido 100, o consumidor recebe `PedidoEnviado` antes de `PagamentoAprovado`. Ele pode verificar a versão do pedido e aguardar, rejeitar ou armazenar temporariamente o evento, conforme a estratégia definida.

**Como o candidato deve responder:**  

O candidato deve:

- Explicar por que a ordem pode afetar o estado;
- Reconhecer que a garantia depende do broker;
- Mencionar chave, partição ou sequência;
- Considerar paralelismo e custo;
- Evitar afirmar que todos os eventos são sempre ordenados.

**Perguntas de aprofundamento:**  

1. Você exigiria ordenação global para todos os eventos?
2. Como trataria um evento recebido fora de ordem?
3. Qual é o custo de garantir ordenação estrita?

**Resposta fraca ou incompleta:**  

“O broker sempre entrega as mensagens na ordem em que foram publicadas.”

Essa afirmação pode ser incorreta dependendo da tecnologia, particionamento e número de consumidores.

**Critérios de avaliação:**  

- **0:** Não reconhece a possibilidade de eventos fora de ordem.
- **1:** Sabe apenas que eventos possuem uma sequência.
- **2:** Cita ordenação, mas não explica limitações.
- **3:** Explica corretamente a importância e a dependência da configuração.
- **4:** Considera partições, chaves, versões e processamento paralelo.
- **5:** Discute consistência, throughput, reordenação, reconciliação e trade-offs de disponibilidade.

---

# Pergunta 60 — Estratégia de observabilidade para uma requisição

**Nível:** Júnior  
**Categoria:** Observabilidade e troubleshooting

**Pergunta do entrevistador:**  
Como você estruturaria a observabilidade de uma requisição que passa pelo Gateway, por um microsserviço e por um broker de mensagens?

**O que essa pergunta avalia:**  

- Visão integrada de observabilidade;
- Capacidade de combinar logs, métricas e traces;
- Conhecimento sobre correlação;
- Organização para investigar fluxos síncronos e assíncronos.

**Resposta esperada:**  

Eu utilizaria três pilares principais:

- **Logs:** registrariam eventos relevantes, erros, IDs de correlação e contexto;
- **Métricas:** mostrariam volume, latência, taxa de erro, tamanho de filas e tempo de processamento;
- **Traces:** acompanhariam a requisição entre Gateway e serviços, quando a propagação de contexto fosse suportada.

Também utilizaria identificadores consistentes, como:

- Request ID;
- Correlation ID;
- Trace ID;
- ID da operação;
- ID do evento.

No fluxo assíncrono, o contexto deveria ser propagado para que o consumidor pudesse ser relacionado à operação original.

Eu evitaria registrar tokens, senhas e dados pessoais desnecessários.

**Explicação didática:**  

Um fluxo completo pode ser representado assim:

~~~mermaid
flowchart LR
    C["Cliente"] --> G["Gateway"]
    G --> S["Microsserviço"]
    S --> B["Broker"]
    B --> W["Consumidor"]
    G -.-> O["Logs, métricas e traces"]
    S -.-> O
    W -.-> O
~~~

Cada etapa deve registrar informações suficientes para responder:

- A requisição chegou?
- Qual rota foi utilizada?
- Qual serviço processou a operação?
- O evento foi publicado?
- O consumidor recebeu a mensagem?
- Quanto tempo cada etapa levou?
- Onde ocorreu a falha?

Em sistemas assíncronos, a ausência de uma resposta imediata torna métricas de fila e tempo de processamento especialmente importantes.

**Exemplo prático:**  

Um cliente cria um pedido. O Gateway gera o trace ID. O serviço de pedidos publica `PedidoCriado`, incluindo um identificador de correlação. O consumidor processa o evento e registra o mesmo contexto.

Se o estoque não for atualizado, a equipe pode seguir o fluxo desde a requisição original até o consumidor.

**Como o candidato deve responder:**  

O candidato deve:

- Citar logs, métricas e traces;
- Explicar correlação entre etapas;
- Considerar o broker e o consumidor;
- Mencionar latência, erros e tamanho de filas;
- Evitar registrar dados sensíveis;
- Diferenciar fluxo síncrono de assíncrono.

**Perguntas de aprofundamento:**  

1. Como investigaria uma mensagem publicada, mas nunca consumida?
2. Que métricas indicariam atraso no consumidor?
3. Qual é a diferença entre correlation ID e trace ID?

**Resposta fraca ou incompleta:**  

“Eu verificaria os logs do Gateway.”

Essa resposta ignora o serviço, o broker, o consumidor, métricas de fila e rastreamento distribuído.

**Critérios de avaliação:**  

- **0:** Não apresenta estratégia de observabilidade.
- **1:** Sugere apenas consultar logs.
- **2:** Cita logs e métricas, mas não explica correlação.
- **3:** Combina logs, métricas, traces e identificadores.
- **4:** Considera broker, consumidores, filas e dados sensíveis.
- **5:** Demonstra visão ponta a ponta, incluindo propagação de contexto, SLOs, alertas, privacidade e diagnóstico de falhas síncronas e assíncronas.

---

## Resumo desta parte

- **Perguntas apresentadas:** 51 a 60
- **Perguntas restantes:** 40
- **Nível abordado:** Júnior
- **Categorias cobertas:**
  - Gateway;
  - Service Discovery;
  - Segurança;
  - Autenticação;
  - TLS;
  - Configuração distribuída;
  - Mensageria;
  - Idempotência;
  - Dead-letter queue;
  - Ordenação de eventos;
  - Observabilidade.

## Matriz parcial de competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---:|---|
| Descoberta pelo Gateway | Júnior | 51 | Compreende nomes lógicos, `lb://`, registro e instâncias |
| Autenticação no Gateway | Júnior | 52 e 53 | Diferencia autenticação, autorização e propagação segura de identidade |
| TLS e comunicação segura | Júnior | 54 | Entende criptografia, certificados e proteção de chaves |
| Atualização distribuída | Júnior | 55 e 56 | Compreende Bus, refresh, cache e indisponibilidade do Config Server |
| Idempotência de consumidores | Júnior | 57 | Trata eventos duplicados com identificadores e persistência |
| Dead-letter queue | Júnior | 58 | Entende isolamento de mensagens com falha e reprocessamento |
| Ordenação de eventos | Júnior | 59 | Reconhece dependência de sequência e limites do broker |
| Observabilidade ponta a ponta | Júnior | 60 | Combina logs, métricas, traces e correlação entre componentes |

## Recomendações específicas para o entrevistador

- Verifique se o candidato consegue explicar a diferença entre nome lógico e endereço físico.
- Em segurança, observe se ele confia indevidamente em headers enviados pelo cliente.
- Pergunte como ele trataria falhas do provedor de identidade.
- Avalie se conhece os riscos de desabilitar validação TLS.
- Em configuração distribuída, explore diferenças entre refresh, reinicialização e cache.
- Em mensageria, investigue sempre duplicidade, ordenação e reprocessamento.
- Pergunte como o candidato comprovaria que uma mensagem foi publicada, mas não consumida.
- Avalie se ele consegue conectar observabilidade síncrona e assíncrona.
- Não avalie apenas o conhecimento de nomes de componentes; peça que explique o problema resolvido por cada um.

## Recomendações específicas para o candidato

- Explique primeiro o problema e depois o componente escolhido.
- Não confie em headers de identidade sem validação criptográfica ou controle de origem.
- Ao falar de autenticação, diferencie claramente identidade e permissão.
- Considere sempre expiração, renovação e proteção de certificados.
- Em mensageria, assuma que duplicidade e falhas podem ocorrer.
- Use identificadores persistentes para tornar consumidores idempotentes.
- Ao discutir filas, considere retries, dead-letter e reprocessamento.
- Em observabilidade, combine logs, métricas e traces.
- Mencione privacidade e evite registrar credenciais ou dados sensíveis.

---

# Roteiro de Entrevista Técnica — Spring Cloud

## Perguntas 61 a 70

> Continuação do roteiro para avaliação de nível Júnior, com perguntas conceituais, práticas e baseadas em cenários reais.

---

# Pergunta 61 — Configuração dinâmica com `@RefreshScope`

**Nível:** Júnior  
**Categoria:** Configuração e operação

**Pergunta do entrevistador:**  
O que significa atualizar uma configuração dinamicamente em uma aplicação Spring Cloud e quais cuidados devem ser considerados?

**O que essa pergunta avalia:**

- Conhecimento sobre atualização de configurações em tempo de execução;
- Compreensão do ciclo de vida dos componentes;
- Capacidade de identificar riscos de mudanças dinâmicas;
- Noções de consistência entre instâncias.

**Perguntas de aprofundamento:**

1. Toda propriedade pode ser atualizada sem reiniciar a aplicação?
2. O que pode acontecer se apenas algumas instâncias receberem a nova configuração?
3. Como você reverteria uma configuração aplicada incorretamente?

**Resposta esperada:**

Uma configuração dinâmica é aquela que pode ser atualizada enquanto a aplicação está em execução, sem exigir necessariamente uma nova implantação ou reinicialização completa.

Em aplicações Spring Cloud, alguns componentes podem ser atualizados por mecanismos de refresh, como `@RefreshScope`, eventos ou integração com um barramento.

Porém, nem toda configuração deve ser alterada dinamicamente. É necessário verificar:

- Se o componente suporta refresh;
- Se o novo valor é válido;
- Se a atualização é aplicada a todas as instâncias;
- Se existe risco de comportamento inconsistente;
- Se é possível realizar rollback;
- Se a mudança foi auditada;
- Se os valores sensíveis estão protegidos.

Configurações como timeout, limite de requisições e URLs podem ser candidatas a atualização dinâmica, mas devem ser alteradas com controle. Já mudanças estruturais podem exigir reinicialização.

**Explicação didática:**

Normalmente, a aplicação lê propriedades durante a inicialização. Se um valor for alterado no servidor de configuração, a aplicação pode continuar utilizando o valor antigo em memória.

Um mecanismo de refresh pode recriar ou atualizar determinados componentes para que eles utilizem o novo valor.

O fluxo pode ser representado assim:

~~~mermaid
sequenceDiagram
    participant O as Operador
    participant C as Config Server
    participant B as Bus ou mecanismo de refresh
    participant A as Instâncias da aplicação

    O->>C: Altera configuração
    C-->>B: Publica evento de atualização
    B-->>A: Propaga evento
    A->>A: Valida e aplica nova configuração
~~~

O processo precisa evitar que uma configuração inválida seja propagada para todas as instâncias simultaneamente.

**Exemplo prático:**

A equipe altera o timeout do serviço de pagamentos de 3 para 5 segundos. Antes de aplicar a mudança em todas as instâncias, deve validar o impacto nas métricas de latência, consumo de recursos e taxa de erro.

**Exemplo de código:**

~~~java
@Component
@RefreshScope
@ConfigurationProperties(prefix = "app.pagamento")
public class PagamentoProperties {

    private int timeoutMs;

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }
}
~~~

O suporte exato depende da versão do Spring Cloud e do mecanismo de refresh configurado.

**Como o candidato deve responder:**

O candidato deve:

- Explicar que a configuração pode ser alterada sem reinicialização em alguns casos;
- Mencionar refresh ou `@RefreshScope`;
- Destacar que o suporte depende do componente e da versão;
- Considerar validação, consistência e rollback;
- Evitar afirmar que toda propriedade é atualizada automaticamente.

Para o nível Júnior, é mais importante compreender o conceito do que memorizar a configuração completa.

**Resposta fraca ou incompleta:**

“Basta alterar o arquivo do Config Server, porque todas as aplicações atualizam automaticamente.”

Essa resposta ignora refresh, suporte do componente, propagação para todas as instâncias e riscos de inconsistência.

**Critérios de avaliação:**

- **0:** Apresenta comportamento incorreto e afirma que toda alteração é automática.
- **1:** Sabe apenas que configurações podem mudar em tempo de execução.
- **2:** Conhece refresh, mas não considera riscos.
- **3:** Explica corretamente a ideia de configuração dinâmica.
- **4:** Considera validação, múltiplas instâncias e rollback.
- **5:** Discute consistência, rollout gradual, auditoria, compatibilidade e impacto operacional.

---

# Pergunta 62 — Perfil de configuração incorreto

**Nível:** Júnior  
**Categoria:** Troubleshooting e configuração

**Pergunta do entrevistador:**  
Uma aplicação que deveria utilizar a configuração de produção iniciou utilizando valores de desenvolvimento. Como você investigaria o problema?

**O que essa pergunta avalia:**

- Capacidade de investigar profiles;
- Conhecimento sobre fontes de configuração;
- Atenção a riscos de ambiente;
- Organização de troubleshooting.

**Perguntas de aprofundamento:**

1. Onde você verificaria qual profile está ativo?
2. Como evitaria que isso acontecesse novamente?
3. Quais riscos existem ao executar uma aplicação de produção com configuração de desenvolvimento?

**Resposta esperada:**

Eu investigaria:

1. Qual profile está ativo na inicialização;
2. Se existe uma variável de ambiente sobrescrevendo o valor esperado;
3. Se argumentos de execução definem outro profile;
4. Se a configuração de implantação está correta;
5. Se o Config Server retornou o conjunto correto de propriedades;
6. Se o nome da aplicação está correto;
7. Se houve erro de nomenclatura nos arquivos de configuração;
8. Se a aplicação está apontando para o Config Server correto;
9. Se alguma configuração local está prevalecendo sobre a configuração remota.

Também consultaria logs de inicialização, informações não sensíveis do ambiente e os parâmetros efetivamente utilizados pela implantação.

Depois de identificar a causa, corrigiria a configuração e criaria uma proteção, como:

- Validação do ambiente;
- Configuração explícita do profile;
- Verificação automática no pipeline;
- Bloqueio de valores de desenvolvimento em produção;
- Teste de fumaça após a implantação.

**Explicação didática:**

Profiles permitem selecionar configurações adequadas para cada ambiente. O problema ocorre quando a aplicação seleciona o conjunto errado ou quando uma fonte de maior precedência sobrescreve o valor esperado.

O fluxo de investigação pode ser:

~~~mermaid
flowchart TD
    A["Aplicação inicia com valores incorretos"] --> B["Verificar profile ativo"]
    B --> C["Verificar variáveis e argumentos"]
    C --> D["Verificar configuração da implantação"]
    D --> E["Verificar Config Server"]
    E --> F["Comparar configuração esperada e efetiva"]
    F --> G["Corrigir e adicionar validações"]
~~~

**Exemplo prático:**

A aplicação de produção aponta para um banco de desenvolvimento porque a variável `SPRING_PROFILES_ACTIVE` foi configurada como `dev` no ambiente de implantação.

**Como o candidato deve responder:**

O candidato deve:

- Começar verificando o profile ativo;
- Considerar variáveis de ambiente e argumentos;
- Verificar a origem da configuração;
- Avaliar o impacto de segurança e dados;
- Propor prevenção, e não apenas correção manual;
- Evitar alterar arquivos aleatoriamente sem identificar a origem do valor.

**Resposta fraca ou incompleta:**

“Eu abriria o arquivo de produção e mudaria a URL do banco.”

Essa resposta pode não resolver o problema se o valor estiver vindo de outra fonte e não apresenta medidas preventivas.

**Critérios de avaliação:**

- **0:** Não identifica o risco ou sugere usar produção com configuração de desenvolvimento.
- **1:** Verifica apenas um arquivo.
- **2:** Considera o profile, mas ignora sobrescritas.
- **3:** Investiga profile, ambiente e configuração remota.
- **4:** Propõe validações e testes de implantação.
- **5:** Demonstra investigação sistemática, prevenção automatizada, auditoria e análise do impacto.

---

# Pergunta 63 — Health check muito restritivo

**Nível:** Júnior  
**Categoria:** Disponibilidade e troubleshooting

**Pergunta do entrevistador:**  
Todas as instâncias de um serviço foram removidas do tráfego porque o health check falhou. Como você avaliaria se o health check está configurado corretamente?

**O que essa pergunta avalia:**

- Compreensão de health checks;
- Capacidade de diferenciar dependências críticas e opcionais;
- Noções de readiness;
- Raciocínio sobre disponibilidade.

**Perguntas de aprofundamento:**

1. Toda falha de dependência deve retirar a instância do tráfego?
2. Qual é a diferença entre liveness e readiness nesse cenário?
3. Como evitaria que uma falha temporária removesse todas as instâncias?

**Resposta esperada:**

Eu verificaria:

- Qual endpoint está sendo utilizado;
- Quais dependências participam da verificação;
- Se o endpoint diferencia liveness de readiness;
- Se a dependência analisada é realmente obrigatória;
- Se o tempo de resposta do health check é adequado;
- Se há falhas intermitentes;
- Se os limites de falha e recuperação são apropriados;
- Se todas as instâncias falharam pelo mesmo motivo;
- Se o health check está testando uma operação pesada;
- Se o resultado está sendo interpretado corretamente pelo balanceador.

Uma dependência crítica, como o banco principal de uma operação obrigatória, pode afetar a readiness. Porém, uma funcionalidade opcional, como recomendações, não deveria necessariamente retirar a aplicação inteira do tráfego.

Também verificaria se o health check não está gerando carga excessiva ou causando uma reação exagerada a falhas temporárias.

**Explicação didática:**

Um health check deve representar a capacidade real de atender requisições, mas sem ser mais restritivo do que a regra de negócio exige.

O problema pode ser representado assim:

~~~mermaid
flowchart TD
    A["Dependência opcional falha"] --> B["Health check verifica a dependência"]
    B --> C["Readiness falha"]
    C --> D["Instância removida do tráfego"]
    D --> E["Todas as instâncias podem ficar indisponíveis"]
~~~

O health check deve ser cuidadosamente projetado para não transformar uma falha parcial em indisponibilidade total.

**Exemplo prático:**

O serviço de produtos consegue consultar produtos normalmente, mas o serviço de recomendações está indisponível. Se o health check considerar recomendações obrigatórias, todas as instâncias poderão ser retiradas do tráfego sem necessidade.

**Como o candidato deve responder:**

O candidato deve:

- Verificar o conteúdo e o comportamento do health check;
- Diferenciar dependências críticas e opcionais;
- Mencionar readiness;
- Considerar falhas temporárias e intermitentes;
- Avaliar o impacto de retirar todas as instâncias;
- Evitar concluir que qualquer falha significa que a aplicação está indisponível.

**Resposta fraca ou incompleta:**

“Eu reiniciaria as instâncias até o health check voltar a funcionar.”

A resposta não investiga a causa nem questiona se a dependência deveria participar da verificação.

**Critérios de avaliação:**

- **0:** Não identifica o risco de um health check inadequado.
- **1:** Sugere apenas reiniciar as instâncias.
- **2:** Verifica o endpoint, mas não avalia dependências.
- **3:** Analisa readiness, dependências e comportamento do check.
- **4:** Considera falhas intermitentes, limites e disponibilidade.
- **5:** Discute critérios de saúde, dependências opcionais, falsos positivos, capacidade e prevenção de indisponibilidade em massa.

---

# Pergunta 64 — Circuit breaker e respostas de erro

**Nível:** Júnior  
**Categoria:** Resiliência e integração

**Pergunta do entrevistador:**  
Como o circuito breaker deve se comportar quando uma dependência retorna erros funcionais, como HTTP 400 ou HTTP 404?

**O que essa pergunta avalia:**

- Conhecimento sobre circuit breaker;
- Diferenciação entre erros funcionais e indisponibilidade;
- Capacidade de configurar condições de falha;
- Análise de comportamento de resiliência.

**Perguntas de aprofundamento:**

1. Todo erro HTTP deve contar para abrir o circuito?
2. Um HTTP 500 deve sempre abrir o circuito?
3. Como você validaria quais erros devem ser considerados falhas transitórias?

**Resposta esperada:**

O circuit breaker não deve necessariamente tratar todos os erros HTTP da mesma forma.

Erros como:

- `400 Bad Request`;
- `401 Unauthorized`;
- `403 Forbidden`;
- `404 Not Found`;

normalmente representam problemas funcionais ou de entrada, e não indicam que o serviço inteiro está indisponível.

Já erros como:

- Timeout;
- Falha de conexão;
- `502 Bad Gateway`;
- `503 Service Unavailable`;
- `504 Gateway Timeout`;

podem indicar indisponibilidade ou degradação e podem ser candidatos a contar para o circuito.

O tratamento depende do contrato da API e da regra de negócio. Um `500` pode representar uma falha temporária ou um erro específico de uma operação. Portanto, é necessário analisar métricas e comportamento antes de definir a política.

**Explicação didática:**

Se um cliente enviar dados inválidos e receber `400`, abrir o circuito seria inadequado. O serviço pode estar funcionando corretamente; apenas aquela requisição está errada.

O circuito deve proteger contra falhas da dependência, e não esconder erros de validação do consumidor.

O fluxo pode ser:

~~~mermaid
flowchart TD
    A["Resposta da dependência"] --> B{"Tipo de erro"}
    B -->|"Erro funcional"| C["Retornar erro ao consumidor"]
    B -->|"Timeout ou indisponibilidade"| D["Contabilizar falha no circuito"]
    D --> E{"Limite atingido?"}
    E -->|"Não"| F["Continuar monitorando"]
    E -->|"Sim"| G["Abrir circuito"]
~~~

**Exemplo prático:**

O serviço de clientes retorna `404` porque o cliente informado não existe. O `pedido-service` deve tratar isso como regra de negócio, e não como indisponibilidade do serviço de clientes.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar erros funcionais e técnicos;
- Evitar contabilizar todo status diferente de 2xx;
- Citar timeout e falha de conexão;
- Relacionar a decisão ao contrato;
- Mencionar métricas e testes;
- Reconhecer que a configuração depende da biblioteca adotada.

**Resposta fraca ou incompleta:**

“Qualquer resposta diferente de 200 deve abrir o circuit breaker.”

Essa abordagem pode abrir o circuito por causa de requisições inválidas, sem indicar falha real da dependência.

**Critérios de avaliação:**

- **0:** Afirma que todo erro deve abrir o circuito.
- **1:** Reconhece apenas que erros existem.
- **2:** Diferencia parcialmente erros funcionais e técnicos.
- **3:** Explica corretamente que a política deve considerar o tipo de falha.
- **4:** Relaciona a decisão a timeout, códigos HTTP, métricas e contrato.
- **5:** Discute classificação de falhas, falsos positivos, limiares, observabilidade e impacto da configuração.

---

# Pergunta 65 — Fallback com cache

**Nível:** Júnior  
**Categoria:** Resiliência e consistência

**Pergunta do entrevistador:**  
Em que situação um fallback baseado em cache pode ser útil e quais riscos devem ser considerados?

**O que essa pergunta avalia:**

- Conhecimento sobre fallback;
- Compreensão de dados desatualizados;
- Noções de consistência;
- Capacidade de analisar segurança e validade de dados.

**Perguntas de aprofundamento:**

1. Você usaria cache para informações financeiras?
2. Como saberia se o dado armazenado ainda é válido?
3. O que aconteceria se o cache estivesse indisponível?

**Resposta esperada:**

Um fallback baseado em cache pode ser útil quando:

- A informação não precisa ser totalmente atualizada;
- É aceitável apresentar o último valor conhecido;
- A dependência está temporariamente indisponível;
- A funcionalidade é de consulta;
- O dado possui uma validade definida.

Exemplos adequados podem incluir:

- Catálogo de produtos;
- Lista de países;
- Configurações de apresentação;
- Recomendações;
- Dados públicos com atualização periódica.

Os riscos incluem:

- Exibir informações desatualizadas;
- Violar regras de negócio;
- Expor dados de outro usuário;
- Usar dados expirados;
- Criar inconsistência;
- Mascarar falhas da dependência;
- Consumir memória ou armazenamento excessivo.

O cache deve possuir política de expiração, controle de escopo, segurança e monitoramento.

**Explicação didática:**

O cache pode manter uma cópia temporária de uma resposta. Quando a dependência falha, a aplicação utiliza essa cópia.

O fluxo pode ser:

~~~mermaid
flowchart TD
    A["Solicitar informação"] --> B{"Dependência respondeu?"}
    B -->|"Sim"| C["Retornar dado atual e atualizar cache"]
    B -->|"Não"| D{"Existe dado válido no cache?"}
    D -->|"Sim"| E["Retornar dado armazenado"]
    D -->|"Não"| F["Retornar indisponibilidade"]
~~~

O termo “válido” deve considerar o prazo de expiração e a regra de negócio, não apenas a existência física do dado.

**Exemplo prático:**

O serviço de recomendações está indisponível. A aplicação exibe recomendações armazenadas há cinco minutos, pois esse atraso é aceitável.

Já o saldo bancário não deveria ser exibido a partir de um cache antigo sem deixar claro o risco de desatualização.

**Como o candidato deve responder:**

O candidato deve:

- Explicar quando cache pode ser usado como fallback;
- Mencionar expiração e dados desatualizados;
- Considerar segurança e escopo;
- Diferenciar dados críticos de dados opcionais;
- Evitar utilizar cache indiscriminadamente.

**Resposta fraca ou incompleta:**

“Se o serviço falhar, basta retornar qualquer informação salva no cache.”

A resposta não verifica validade, segurança, atualização ou importância do dado.

**Critérios de avaliação:**

- **0:** Recomenda usar cache antigo para qualquer tipo de informação.
- **1:** Sabe apenas que cache pode evitar uma chamada.
- **2:** Reconhece dados desatualizados, mas não propõe controles.
- **3:** Explica o uso básico de cache como fallback.
- **4:** Considera expiração, segurança, consistência e criticidade.
- **5:** Analisa validade, escopo, privacidade, observabilidade, comportamento em falhas e trade-offs de consistência.

---

# Pergunta 66 — Gateway e upload de arquivos

**Nível:** Júnior  
**Categoria:** Gateway e desempenho

**Pergunta do entrevistador:**  
Quais cuidados devem ser considerados ao encaminhar uploads de arquivos por meio de um API Gateway?

**O que essa pergunta avalia:**

- Compreensão dos limites do Gateway;
- Noções de desempenho e segurança;
- Capacidade de considerar tamanho de requisições;
- Análise de alternativas arquiteturais.

**Perguntas de aprofundamento:**

1. Você colocaria arquivos grandes diretamente no Gateway?
2. Como impediria o upload de arquivos perigosos?
3. Que alternativa utilizaria para armazenar arquivos grandes?

**Resposta esperada:**

Ao encaminhar uploads pelo Gateway, eu consideraria:

- Tamanho máximo da requisição;
- Tempo limite de processamento;
- Consumo de memória;
- Uso de streaming;
- Número de uploads simultâneos;
- Validação do tipo e tamanho do arquivo;
- Autenticação e autorização;
- Verificação contra malware;
- Armazenamento temporário;
- Limites de taxa;
- Timeout entre Gateway e serviço de destino.

Arquivos grandes podem transformar o Gateway em um gargalo. Em alguns casos, é melhor utilizar armazenamento de objetos com upload direto ou uma URL pré-assinada, mantendo o Gateway responsável apenas pela autorização e emissão da permissão.

O arquivo não deve ser considerado seguro apenas pela extensão informada pelo cliente.

**Explicação didática:**

O Gateway é uma camada de entrada, mas não deve necessariamente transportar grandes volumes de dados por longos períodos.

Um fluxo alternativo pode ser:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant G as Gateway
    participant S as Serviço de arquivos
    participant O as Armazenamento

    C->>G: Solicitar autorização de upload
    G->>S: Validar usuário e regras
    S-->>G: Gerar URL temporária
    G-->>C: Retornar URL autorizada
    C->>O: Enviar arquivo diretamente
    O-->>C: Confirmar upload
    C->>S: Informar conclusão
~~~

Essa abordagem pode reduzir o tráfego e o consumo de recursos do Gateway.

**Exemplo prático:**

Uma aplicação permite enviar vídeos grandes. Em vez de fazer o upload completo passar pelo Gateway, o serviço gera uma URL temporária para o armazenamento. O cliente envia o arquivo diretamente para esse armazenamento.

**Como o candidato deve responder:**

O candidato deve:

- Considerar tamanho, memória e timeout;
- Mencionar validação e segurança;
- Reconhecer que o Gateway pode ser um gargalo;
- Citar streaming ou upload direto como alternativas;
- Evitar confiar apenas na extensão do arquivo.

**Resposta fraca ou incompleta:**

“Eu aumentaria o limite do Gateway para aceitar arquivos de qualquer tamanho.”

Essa abordagem pode causar consumo excessivo de memória, lentidão e indisponibilidade.

**Critérios de avaliação:**

- **0:** Recomenda aceitar arquivos ilimitados e sem validação.
- **1:** Percebe apenas que arquivos grandes demoram mais.
- **2:** Cita limite de tamanho, mas ignora segurança e recursos.
- **3:** Considera tamanho, timeout, memória e validação.
- **4:** Propõe streaming, rate limiting e alternativas de armazenamento.
- **5:** Analisa segurança, escalabilidade, custo, upload direto, URLs temporárias e proteção do Gateway.

---

# Pergunta 67 — Gateway e WebSocket

**Nível:** Júnior  
**Categoria:** Integração e comunicação

**Pergunta do entrevistador:**  
Quais diferenças devem ser consideradas ao encaminhar uma comunicação WebSocket em comparação com uma requisição HTTP tradicional pelo Gateway?

**O que essa pergunta avalia:**

- Compreensão básica de protocolos;
- Conhecimento sobre conexões persistentes;
- Noções de infraestrutura e escalabilidade;
- Capacidade de identificar limitações do Gateway.

**Perguntas de aprofundamento:**

1. Por que conexões WebSocket consomem recursos de forma diferente?
2. Como você trataria múltiplas instâncias do serviço WebSocket?
3. Que cuidados teria com autenticação e encerramento de conexões?

**Resposta esperada:**

Uma requisição HTTP tradicional normalmente possui um início, uma resposta e um encerramento. WebSocket estabelece uma conexão persistente e permite comunicação bidirecional entre cliente e servidor.

Ao utilizar WebSocket pelo Gateway, eu consideraria:

- Suporte ao protocolo e ao upgrade da conexão;
- Timeouts diferentes;
- Conexões persistentes;
- Consumo de memória e conexões;
- Balanceamento entre instâncias;
- Afinidade de sessão, quando necessária;
- Autenticação durante a conexão;
- Reconexão do cliente;
- Limite de conexões;
- Monitoramento de conexões ativas.

Se várias instâncias participarem do processamento, pode ser necessário um mecanismo compartilhado para distribuir eventos ou manter o estado necessário.

**Explicação didática:**

O fluxo de estabelecimento envolve uma solicitação inicial de upgrade:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant G as Gateway
    participant S as Serviço WebSocket

    C->>G: HTTP Upgrade
    G->>S: Encaminhar Upgrade
    S-->>G: Conexão aceita
    G-->>C: WebSocket estabelecido
    C<<->>S: Troca bidirecional de mensagens
~~~

Uma conexão WebSocket pode permanecer aberta por muito tempo. Por isso, os limites e estratégias de monitoramento são diferentes dos utilizados em chamadas HTTP rápidas.

**Exemplo prático:**

Uma aplicação de atendimento utiliza WebSocket para atualizar mensagens em tempo real. Se o cliente for reconectado a outra instância, o sistema deve conseguir recuperar as mensagens ou encaminhar os eventos corretamente.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar HTTP tradicional de conexão persistente;
- Mencionar upgrade, conexões longas e recursos;
- Considerar autenticação e reconexão;
- Avaliar balanceamento e múltiplas instâncias;
- Evitar tratar WebSocket como uma requisição HTTP comum.

**Resposta fraca ou incompleta:**

“WebSocket é igual a HTTP, mas mais rápido.”

A resposta não explica a conexão persistente, a comunicação bidirecional nem os impactos operacionais.

**Critérios de avaliação:**

- **0:** Não diferencia WebSocket de HTTP.
- **1:** Sabe apenas que WebSocket é usado em tempo real.
- **2:** Reconhece conexão persistente, mas ignora infraestrutura.
- **3:** Explica corretamente as diferenças básicas.
- **4:** Considera autenticação, balanceamento, reconexão e recursos.
- **5:** Discute escala, afinidade, distribuição de eventos, observabilidade e custos operacionais.

---

# Pergunta 68 — Comunicação entre serviços e DNS

**Nível:** Júnior  
**Categoria:** Integração e infraestrutura

**Pergunta do entrevistador:**  
Qual é o papel do DNS na comunicação entre microsserviços e como ele se relaciona com a descoberta de serviços?

**O que essa pergunta avalia:**

- Conhecimento básico de resolução de nomes;
- Compreensão de descoberta baseada em infraestrutura;
- Capacidade de comparar alternativas;
- Noções de cache e disponibilidade.

**Perguntas de aprofundamento:**

1. DNS substitui completamente um Service Registry?
2. O que pode acontecer quando um registro DNS está desatualizado?
3. Como você investigaria uma falha de resolução de nome?

**Resposta esperada:**

DNS traduz nomes, como `pagamento-service`, para endereços de rede. Em algumas plataformas, os serviços podem ser acessados por nomes DNS internos fornecidos pela infraestrutura.

Isso pode funcionar como uma forma de descoberta baseada em plataforma. Entretanto, DNS e Service Registry possuem diferenças.

O DNS normalmente fornece resolução de nomes, enquanto um Registry pode manter informações adicionais, como:

- Instâncias;
- Status;
- Metadados;
- Health checks;
- Localização;
- Informações de versão.

A estratégia escolhida depende da plataforma. Em ambientes que já oferecem descoberta por DNS ou por serviços nativos, talvez não seja necessário adicionar um componente de descoberta na aplicação.

Também é preciso considerar cache DNS, tempo de propagação e registros obsoletos.

**Explicação didática:**

Uma aplicação pode chamar:

~~~text
http://pagamento-service/pagamentos
~~~

Em vez de conhecer um IP específico. A infraestrutura resolve `pagamento-service` para um destino disponível.

O fluxo pode ser representado assim:

~~~mermaid
sequenceDiagram
    participant P as Pedido
    participant D as DNS interno
    participant F as Pagamento

    P->>D: Resolver pagamento-service
    D-->>P: Endereço ou destino
    P->>F: Enviar requisição
    F-->>P: Retornar resposta
~~~

A resolução de nome não garante que a aplicação esteja saudável. Ainda é necessário tratar erros, timeouts e indisponibilidade.

**Exemplo prático:**

Em uma plataforma de contêineres, o serviço de pedidos acessa o serviço de pagamentos por um nome DNS interno. Quando novas instâncias são criadas, a plataforma atualiza o destino correspondente.

**Como o candidato deve responder:**

O candidato deve:

- Explicar resolução de nomes;
- Relacionar DNS à descoberta baseada em infraestrutura;
- Diferenciar DNS de um Registry mais completo;
- Considerar cache e registros desatualizados;
- Mencionar que resolução de nome não garante saúde da aplicação.

**Resposta fraca ou incompleta:**

“DNS é o próprio Service Registry e sempre sabe qual instância está saudável.”

Essa resposta confunde resolução de nomes com descoberta completa e health checks.

**Critérios de avaliação:**

- **0:** Não entende a função do DNS.
- **1:** Sabe apenas que DNS converte nome em IP.
- **2:** Relaciona DNS à comunicação, mas ignora limitações.
- **3:** Explica corretamente a descoberta por nome.
- **4:** Compara DNS, Registry, health checks e cache.
- **5:** Discute responsabilidades da plataforma, consistência, TTL, balanceamento e trade-offs de adicionar componentes à aplicação.

---

# Pergunta 69 — Graceful shutdown

**Nível:** Júnior  
**Categoria:** Disponibilidade e operação

**Pergunta do entrevistador:**  
O que deve acontecer quando uma instância de microsserviço é encerrada durante uma atualização?

**O que essa pergunta avalia:**

- Conhecimento sobre encerramento controlado;
- Compreensão de disponibilidade;
- Noções de requisições em andamento;
- Capacidade de evitar interrupções durante deploys.

**Perguntas de aprofundamento:**

1. Por que uma instância não deve simplesmente ser encerrada imediatamente?
2. Como garantiria que novas requisições não fossem enviadas para ela?
3. Como trataria mensagens que estavam sendo processadas?

**Resposta esperada:**

Durante um encerramento controlado, a instância deve deixar de receber novas requisições, concluir ou interromper adequadamente as operações em andamento e liberar seus recursos.

Uma estratégia comum inclui:

1. Marcar a instância como não pronta;
2. Removê-la do balanceamento ou da descoberta;
3. Aguardar um período para que o tráfego seja drenado;
4. Finalizar requisições em andamento;
5. Encerrar consumidores e conexões;
6. Liberar recursos;
7. Finalizar o processo.

Para consumidores de mensagens, também é necessário tratar mensagens em processamento e confirmar apenas aquelas processadas corretamente.

A aplicação deve possuir um tempo máximo de encerramento para evitar ficar presa indefinidamente.

**Explicação didática:**

O fluxo pode ser:

~~~mermaid
stateDiagram-v2
    [*] --> Ready
    Ready --> Draining: Início do encerramento
    Draining --> NotReady: Remover do tráfego
    NotReady --> Completing: Finalizar requisições ativas
    Completing --> Stopped: Liberar recursos
    Stopped --> [*]
~~~

Se a instância for encerrada sem drenagem, clientes podem receber erros e mensagens podem ser processadas parcialmente.

**Exemplo prático:**

Durante uma implantação, uma instância do `pedido-service` recebe um sinal de encerramento. Ela deixa de receber novos pedidos, termina as requisições atuais e então é substituída por uma nova instância.

**Como o candidato deve responder:**

O candidato deve:

- Explicar remoção do tráfego;
- Mencionar readiness;
- Considerar requisições em andamento;
- Falar sobre mensagens e conexões;
- Evitar encerramento abrupto;
- Reconhecer a necessidade de tempo limite.

**Resposta fraca ou incompleta:**

“Eu encerraria o processo e iniciaria uma nova instância.”

Essa abordagem pode interromper requisições, perder mensagens ou causar erros durante a atualização.

**Critérios de avaliação:**

- **0:** Recomenda encerramento abrupto como prática normal.
- **1:** Reconhece que o processo deve ser parado.
- **2:** Cita aguardar requisições, mas não explica o fluxo.
- **3:** Explica readiness, drenagem e encerramento controlado.
- **4:** Considera mensagens, conexões, limites e disponibilidade.
- **5:** Discute deploy gradual, zero downtime, reprocessamento, observabilidade e comportamento sob falhas.

---

# Pergunta 70 — Deploy gradual de uma mudança no Spring Cloud

**Nível:** Júnior  
**Categoria:** Implantação e manutenção

**Pergunta do entrevistador:**  
Como você reduziria o risco ao publicar uma nova configuração ou versão de um microsserviço em uma arquitetura Spring Cloud?

**O que essa pergunta avalia:**

- Conhecimento básico sobre implantação segura;
- Capacidade de considerar rollback;
- Compreensão de monitoramento;
- Análise de riscos em sistemas distribuídos.

**Perguntas de aprofundamento:**

1. O que você monitoraria depois da implantação?
2. Como faria rollback se os erros aumentassem?
3. Por que atualizar todas as instâncias ao mesmo tempo pode ser arriscado?

**Resposta esperada:**

Eu utilizaria uma estratégia gradual, evitando alterar todas as instâncias ao mesmo tempo.

O processo poderia incluir:

1. Validar a mudança em desenvolvimento e homologação;
2. Executar testes automatizados;
3. Verificar compatibilidade entre serviços;
4. Publicar a mudança em uma pequena parcela das instâncias;
5. Monitorar erros, latência, consumo de recursos e logs;
6. Comparar instâncias novas e antigas;
7. Expandir gradualmente se os indicadores forem positivos;
8. Manter um plano de rollback;
9. Remover a versão antiga somente depois da validação.

Para uma configuração, também avaliaria se o novo valor é compatível com todas as versões em execução. Durante uma implantação gradual, pode haver instâncias antigas e novas simultaneamente.

**Explicação didática:**

Uma mudança gradual reduz o impacto de uma configuração incorreta ou de uma incompatibilidade.

O fluxo pode ser:

~~~mermaid
flowchart LR
    A["Preparar mudança"] --> B["Testar fora da produção"]
    B --> C["Aplicar a uma pequena parcela"]
    C --> D{"Métricas normais?"}
    D -->|"Não"| E["Executar rollback"]
    D -->|"Sim"| F["Expandir gradualmente"]
    F --> G["Concluir implantação"]
~~~

O monitoramento deve incluir indicadores técnicos e funcionais. Uma implantação pode não apresentar erro HTTP, mas aumentar a latência ou produzir resultados incorretos.

**Exemplo prático:**

Uma nova versão do `pagamento-service` altera o contrato de resposta. A equipe direciona uma pequena porcentagem do tráfego para a nova versão e verifica se o `pedido-service` continua interpretando corretamente as respostas.

**Como o candidato deve responder:**

O candidato deve:

- Mencionar testes antes da produção;
- Propor publicação gradual;
- Considerar métricas e logs;
- Falar sobre compatibilidade entre versões;
- Ter um plano de rollback;
- Evitar atualizar tudo simultaneamente sem observação.

**Resposta fraca ou incompleta:**

“Eu publicaria a versão nova e, se desse erro, corrigiria depois.”

Essa abordagem aumenta o risco de indisponibilidade e não demonstra planejamento de rollback ou monitoramento.

**Critérios de avaliação:**

- **0:** Recomenda publicar diretamente em todas as instâncias sem validação.
- **1:** Cita apenas testar antes da publicação.
- **2:** Menciona monitoramento, mas não propõe implantação gradual.
- **3:** Explica testes, rollout gradual e rollback.
- **4:** Considera compatibilidade, métricas, logs e tráfego progressivo.
- **5:** Discute canário, blue-green, contratos compatíveis, indicadores de sucesso, rollback rápido e riscos de coexistência entre versões.

---

## Resumo desta parte

- **Perguntas apresentadas:** 61 a 70
- **Perguntas restantes:** 30
- **Nível abordado:** Júnior
- **Categorias cobertas:**
  - Configuração dinâmica;
  - Profiles;
  - Troubleshooting;
  - Health checks;
  - Circuit breaker;
  - Fallback;
  - Cache;
  - Uploads;
  - WebSocket;
  - DNS;
  - Graceful shutdown;
  - Implantação gradual.

## Matriz parcial de competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---:|---|
| Configuração dinâmica | Júnior | 61 | Entende refresh, consistência e rollback |
| Investigação de profiles | Júnior | 62 | Identifica fontes de configuração e ambiente incorreto |
| Health checks | Júnior | 63 | Diferencia dependências críticas e opcionais |
| Circuit breaker | Júnior | 64 | Distingue erros funcionais de indisponibilidade |
| Fallback com cache | Júnior | 65 | Avalia validade, expiração e consistência dos dados |
| Upload via Gateway | Júnior | 66 | Considera tamanho, segurança, memória e alternativas |
| WebSocket | Júnior | 67 | Compreende conexões persistentes e impactos no Gateway |
| DNS e descoberta | Júnior | 68 | Diferencia resolução de nomes e Service Registry |
| Encerramento controlado | Júnior | 69 | Entende readiness, drenagem e finalização segura |
| Implantação gradual | Júnior | 70 | Propõe testes, monitoramento, rollout e rollback |

## Recomendações específicas para o entrevistador

- Verifique se o candidato diferencia configuração dinâmica de simples alteração em um arquivo.
- Explore os riscos de atualizar apenas parte das instâncias.
- Em troubleshooting, peça que o candidato identifique a origem efetiva de uma configuração.
- Avalie se ele entende que health checks excessivamente restritivos podem causar indisponibilidade em massa.
- Pergunte se todo erro HTTP deve abrir um circuit breaker.
- Em cenários de cache, investigue se o candidato considera validade e criticidade dos dados.
- Avalie se ele reconhece que uploads e WebSockets possuem necessidades diferentes de requisições HTTP comuns.
- Pergunte como o serviço deve se comportar durante uma atualização.
- Em deploys, observe se o candidato propõe rollback e monitoramento, e não apenas publicação direta.

## Recomendações específicas para o candidato

- Não afirme que toda configuração é atualizada automaticamente.
- Ao investigar um profile incorreto, verifique todas as fontes de configuração.
- Diferencie liveness, readiness e saúde das dependências.
- Não trate qualquer erro HTTP como falha de disponibilidade.
- Use cache como fallback somente quando dados desatualizados forem aceitáveis.
- Ao falar de uploads, considere limites, segurança e consumo de recursos.
- Diferencie conexões persistentes de requisições HTTP tradicionais.
- Durante atualizações, remova a instância do tráfego antes de encerrá-la.
- Sempre mencione validação, monitoramento e rollback em mudanças de produção.

---

# Roteiro de Entrevista Técnica — Spring Cloud

## Perguntas 71 a 80

> Continuação do roteiro para avaliação de nível Júnior, com perguntas conceituais, práticas e baseadas em cenários reais.

---

# Pergunta 71 — Compatibilidade entre versões de API

**Nível:** Júnior  
**Categoria:** Integração e evolução de APIs

**Pergunta do entrevistador:**  
Como você evitaria que uma alteração em um microsserviço quebrasse os consumidores que dependem dele?

**O que essa pergunta avalia:**

- Compreensão de contratos entre serviços;
- Noções de compatibilidade retroativa;
- Conhecimento sobre versionamento;
- Capacidade de planejar mudanças com segurança.

**Perguntas de aprofundamento:**

1. O que é uma alteração compatível com versões anteriores?
2. Quando seria necessário criar uma nova versão da API?
3. Como você identificaria os consumidores de um endpoint?

**Resposta esperada:**

Eu evitaria alterações incompatíveis sem avaliar previamente o impacto nos consumidores.

Alterações geralmente compatíveis incluem:

- Adicionar um campo opcional em uma resposta;
- Criar um novo endpoint;
- Aceitar novos valores sem remover os anteriores;
- Adicionar headers opcionais.

Alterações potencialmente incompatíveis incluem:

- Remover ou renomear campos;
- Alterar o tipo de um atributo;
- Remover endpoints;
- Alterar o significado de um campo;
- Modificar códigos HTTP esperados;
- Tornar obrigatório um campo que antes era opcional.

Antes da mudança, eu verificaria os consumidores, criaria testes de contrato e planejaria uma migração gradual. Quando necessário, manteria duas versões da API durante um período de transição.

**Explicação didática:**

Considere a seguinte resposta:

~~~json
{
  "id": 10,
  "status": "CRIADO"
}
~~~

Adicionar um campo opcional tende a ser compatível:

~~~json
{
  "id": 10,
  "status": "CRIADO",
  "descricao": "Pedido criado pelo aplicativo"
}
~~~

Por outro lado, substituir `status` por `situacao` pode quebrar consumidores que ainda esperam o campo antigo.

O fluxo de evolução pode ser:

~~~mermaid
flowchart LR
    A["Identificar consumidores"] --> B["Avaliar compatibilidade"]
    B --> C["Criar testes de contrato"]
    C --> D["Publicar alteração compatível"]
    D --> E["Migrar consumidores"]
    E --> F["Remover versão antiga após prazo"]
~~~

**Exemplo prático:**

O `pedido-service` precisa alterar o formato de uma resposta. A equipe cria uma nova versão do endpoint, mantém a versão antiga temporariamente e migra os consumidores de forma gradual.

**Como o candidato deve responder:**

O candidato deve:

- Falar sobre contratos;
- Diferenciar alterações compatíveis e incompatíveis;
- Mencionar testes de contrato;
- Considerar versionamento e migração gradual;
- Evitar alterar a API sem verificar os consumidores.

**Resposta fraca ou incompleta:**

“Eu alteraria o serviço e avisaria os outros times depois.”

Essa abordagem pode causar falhas em produção e não oferece tempo para os consumidores se adaptarem.

**Critérios de avaliação:**

- **0:** Recomenda alterar contratos sem avaliar impacto.
- **1:** Reconhece que mudanças podem quebrar consumidores.
- **2:** Cita versionamento, mas não explica compatibilidade.
- **3:** Explica a importância de preservar contratos.
- **4:** Considera testes, coexistência de versões e migração gradual.
- **5:** Discute compatibilidade retroativa, consumidores desconhecidos, observabilidade, depreciação e estratégia de remoção.

---

# Pergunta 72 — Versionamento de rotas no Gateway

**Nível:** Júnior  
**Categoria:** Gateway e APIs

**Pergunta do entrevistador:**  
Quais estratégias podem ser utilizadas para disponibilizar diferentes versões de uma API por meio do Spring Cloud Gateway?

**O que essa pergunta avalia:**

- Conhecimento sobre versionamento;
- Capacidade de configurar rotas;
- Compreensão de compatibilidade;
- Noções de migração de consumidores.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre versionar pela URL e pelo header?
2. Como você encaminharia `/api/v1/pedidos` e `/api/v2/pedidos`?
3. Por quanto tempo manteria uma versão antiga?

**Resposta esperada:**

Uma API pode ser versionada de diferentes formas:

- Pela URL;
- Por um header;
- Por negociação de conteúdo;
- Por uma combinação de rota e consumidor.

O versionamento pela URL é simples de entender:

~~~text
/api/v1/pedidos
/api/v2/pedidos
~~~

O Gateway pode encaminhar cada versão para uma rota ou serviço específico.

**Exemplo de configuração:**

~~~yaml
spring:
  cloud:
    gateway:
      routes:
        - id: pedidos-v1
          uri: lb://pedido-service-v1
          predicates:
            - Path=/api/v1/pedidos/**

        - id: pedidos-v2
          uri: lb://pedido-service-v2
          predicates:
            - Path=/api/v2/pedidos/**
~~~

O versionamento deve ser acompanhado de documentação, testes, política de depreciação e prazo de migração.

**Explicação didática:**

Duas versões podem coexistir durante a transição:

~~~mermaid
flowchart LR
    C1["Consumidor v1"] --> G["Gateway"]
    C2["Consumidor v2"] --> G
    G --> S1["Serviço ou rota v1"]
    G --> S2["Serviço ou rota v2"]
~~~

O Gateway pode encaminhar cada versão para destinos diferentes, mas não deve acumular regras de negócio complexas para cada contrato.

**Como o candidato deve responder:**

O candidato deve:

- Citar pelo menos uma estratégia de versionamento;
- Explicar a coexistência de versões;
- Relacionar o Gateway ao encaminhamento;
- Mencionar depreciação e migração;
- Evitar manter versões indefinidamente.

**Resposta fraca ou incompleta:**

“Eu substituiria a rota antiga pela nova imediatamente.”

Essa abordagem pode quebrar todos os consumidores que ainda dependem do contrato anterior.

**Critérios de avaliação:**

- **0:** Não reconhece a necessidade de versionamento.
- **1:** Sabe apenas adicionar um número na URL.
- **2:** Cita versões, mas não explica migração.
- **3:** Explica corretamente rotas para versões diferentes.
- **4:** Considera headers, compatibilidade, depreciação e testes.
- **5:** Discute governança, descoberta de consumidores, coexistência, observabilidade e remoção controlada.

---

# Pergunta 73 — Instâncias desiguais no balanceamento

**Nível:** Júnior  
**Categoria:** Balanceamento de carga

**Pergunta do entrevistador:**  
O que pode acontecer quando o mecanismo de balanceamento continua enviando tráfego para uma instância lenta ou com capacidade inferior às demais?

**O que essa pergunta avalia:**

- Compreensão de balanceamento;
- Noções de saúde e capacidade;
- Capacidade de analisar distribuição desigual;
- Conhecimento sobre métricas operacionais.

**Perguntas de aprofundamento:**

1. Round-robin sempre distribui o tráfego adequadamente?
2. Como identificar uma instância que está recebendo mais carga?
3. Que informações poderiam ser consideradas na escolha da instância?

**Resposta esperada:**

Um algoritmo simples, como round-robin, pode distribuir requisições igualmente, mas isso não significa que a carga real será equilibrada.

Uma instância pode estar:

- Mais lenta;
- Com menos CPU;
- Em uma zona com maior latência;
- Com conexões saturadas;
- Com problemas de rede;
- Executando uma versão diferente;
- Atendendo requisições mais pesadas.

Eu analisaria:

- Latência por instância;
- Taxa de erro;
- Número de requisições;
- Conexões ativas;
- Uso de CPU e memória;
- Estado dos health checks;
- Distribuição por zona;
- Versão da aplicação.

**Explicação didática:**

A quantidade de requisições pode estar equilibrada, mas o tempo de processamento não:

~~~mermaid
flowchart LR
    B["Balanceador"] --> I1["Instância 1<br/>100 requisições<br/>200 ms"]
    B --> I2["Instância 2<br/>100 requisições<br/>3 s"]
    B --> I3["Instância 3<br/>100 requisições<br/>250 ms"]
~~~

A segunda instância pode acumular filas mesmo recebendo a mesma quantidade de chamadas.

**Exemplo prático:**

Três instâncias recebem aproximadamente o mesmo número de requisições, mas uma delas apresenta p95 muito superior. A equipe deve verificar diferenças de recursos, versão, dependências ou estado interno.

**Como o candidato deve responder:**

O candidato deve:

- Explicar que quantidade igual não significa carga igual;
- Mencionar health checks e métricas por instância;
- Considerar capacidade e latência;
- Falar sobre remoção temporária de instâncias problemáticas;
- Evitar assumir que round-robin resolve todos os cenários.

**Resposta fraca ou incompleta:**

“Se o número de requisições for igual, o balanceamento está correto.”

Essa resposta ignora diferenças de capacidade e peso das operações.

**Critérios de avaliação:**

- **0:** Não identifica o problema.
- **1:** Percebe apenas que uma instância pode ficar lenta.
- **2:** Cita health check, mas não considera métricas por instância.
- **3:** Explica distribuição desigual de carga.
- **4:** Considera latência, capacidade, versão e remoção de instâncias.
- **5:** Discute algoritmos ponderados, zonas, aquecimento, métricas individuais e capacidade real.

---

# Pergunta 74 — Cache no Gateway

**Nível:** Júnior  
**Categoria:** Desempenho e consistência

**Pergunta do entrevistador:**  
Em que situação um cache no API Gateway pode melhorar o desempenho e quais cuidados devem ser tomados?

**O que essa pergunta avalia:**

- Compreensão de cache;
- Noções de consistência;
- Capacidade de identificar dados cacheáveis;
- Conhecimento sobre segurança e invalidação.

**Perguntas de aprofundamento:**

1. Você armazenaria em cache uma resposta personalizada por usuário?
2. Como evitaria devolver dados de um usuário para outro?
3. O que significa invalidar um cache?

**Resposta esperada:**

Um cache no Gateway pode reduzir chamadas repetitivas aos serviços internos e melhorar a latência para respostas que:

- São lidas frequentemente;
- Mudam pouco;
- Podem tolerar algum atraso;
- Não dependem de dados privados;
- Possuem uma política clara de expiração.

Exemplos podem incluir catálogos públicos, configurações de apresentação e informações de referência.

Os cuidados incluem:

- Definir tempo de expiração;
- Considerar invalidação;
- Separar dados públicos e privados;
- Incluir parâmetros relevantes na chave;
- Evitar armazenar tokens ou informações sensíveis;
- Monitorar taxa de acerto e tamanho do cache;
- Avaliar consistência com o serviço de origem.

**Explicação didática:**

Sem cache:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant G as Gateway
    participant S as Serviço

    C->>G: Solicitar catálogo
    G->>S: Buscar catálogo
    S-->>G: Retornar catálogo
    G-->>C: Retornar resposta
~~~

Com cache, uma chamada repetida pode ser atendida sem acessar o serviço:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant G as Gateway
    participant K as Cache

    C->>G: Solicitar catálogo
    G->>K: Consultar cache
    K-->>G: Retornar resposta armazenada
    G-->>C: Retornar resposta
~~~

**Exemplo prático:**

O catálogo público é atualizado uma vez por hora. O Gateway mantém a resposta por alguns minutos, reduzindo a carga no serviço de catálogo.

Já uma resposta que depende do usuário autenticado precisa utilizar uma chave adequada ou não deve ser cacheada.

**Como o candidato deve responder:**

O candidato deve:

- Explicar quando o cache é adequado;
- Mencionar expiração e invalidação;
- Considerar dados públicos e personalizados;
- Avaliar risco de dados desatualizados;
- Evitar cachear respostas sensíveis sem controle.

**Resposta fraca ou incompleta:**

“Eu colocaria todas as respostas em cache para acelerar a aplicação.”

Essa abordagem pode expor dados, produzir inconsistência e devolver respostas incorretas.

**Critérios de avaliação:**

- **0:** Recomenda cache indiscriminado.
- **1:** Sabe apenas que cache melhora velocidade.
- **2:** Cita expiração, mas ignora segurança.
- **3:** Explica o uso básico de cache.
- **4:** Considera invalidação, escopo, privacidade e consistência.
- **5:** Discute chaves de cache, cache distribuído, taxa de acerto, invalidação e dados personalizados.

---

# Pergunta 75 — Correlação em chamadas assíncronas

**Nível:** Júnior  
**Categoria:** Observabilidade e mensageria

**Pergunta do entrevistador:**  
Como você relacionaria uma mensagem processada por um consumidor à requisição HTTP que originou esse evento?

**O que essa pergunta avalia:**

- Compreensão de correlação;
- Noções de observabilidade assíncrona;
- Capacidade de rastrear operações;
- Conhecimento sobre metadados de mensagens.

**Perguntas de aprofundamento:**

1. Qual identificador você colocaria nos metadados da mensagem?
2. O que faria se o processamento ocorresse horas depois?
3. Como evitaria colocar dados sensíveis no contexto de correlação?

**Resposta esperada:**

Eu propagaria um identificador de correlação ou contexto de rastreamento da requisição original para os metadados do evento.

Exemplo:

~~~text
requestId: req-789
traceId: trace-456
eventId: evt-123
~~~

Ao publicar a mensagem, esses identificadores seriam enviados nos headers ou metadados suportados pelo broker.

O consumidor utilizaria esses dados nos logs, métricas e traces. Assim, seria possível seguir o fluxo desde o Gateway até o processamento assíncrono.

É importante diferenciar:

- Identificador da requisição;
- Identificador do trace;
- Identificador único do evento;
- Identificador da entidade de negócio.

Também é necessário evitar inserir tokens, senhas ou informações pessoais nos metadados.

**Explicação didática:**

O fluxo pode ser:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant G as Gateway
    participant P as Pedido
    participant B as Broker
    participant E as Estoque

    C->>G: Criar pedido
    G->>P: Propagar contexto
    P->>B: Publicar evento com correlação
    B->>E: Entregar evento
    E->>E: Registrar o mesmo contexto
~~~

Mesmo que o consumidor processe a mensagem posteriormente, os identificadores ajudam a relacionar as etapas.

**Exemplo prático:**

Um pedido foi criado, mas o estoque não foi reservado. Com o `traceId` e o `eventId`, a equipe consegue investigar a publicação, a entrega e o processamento do evento.

**Como o candidato deve responder:**

O candidato deve:

- Falar sobre headers ou metadados;
- Diferenciar IDs de correlação e de evento;
- Considerar processamento posterior;
- Relacionar o tema a logs e traces;
- Evitar propagar dados sensíveis.

**Resposta fraca ou incompleta:**

“Eu procuraria pelo horário aproximado nos logs.”

Essa estratégia é frágil com muitas requisições simultâneas e processamento atrasado.

**Critérios de avaliação:**

- **0:** Não apresenta forma de correlacionar os fluxos.
- **1:** Sugere apenas procurar pelo horário.
- **2:** Cita um identificador, mas não explica a propagação.
- **3:** Explica correlação por metadados da mensagem.
- **4:** Diferencia request ID, trace ID e event ID.
- **5:** Discute propagação de contexto, privacidade, processamento tardio e observabilidade ponta a ponta.

---

# Pergunta 76 — Rate limiting distribuído

**Nível:** Júnior  
**Categoria:** Gateway e escalabilidade

**Pergunta do entrevistador:**  
Por que um rate limiting armazenado apenas na memória de uma instância do Gateway pode falhar quando existem várias instâncias?

**O que essa pergunta avalia:**

- Compreensão de estado distribuído;
- Noções de escalabilidade horizontal;
- Capacidade de analisar limites inconsistentes;
- Conhecimento sobre armazenamento compartilhado.

**Perguntas de aprofundamento:**

1. O que aconteceria se o mesmo cliente alternasse entre três Gateways?
2. Como manteria um contador compartilhado?
3. Qual é o custo de utilizar um armazenamento externo?

**Resposta esperada:**

Se o contador existir apenas na memória local, cada instância do Gateway terá uma visão parcial do consumo.

Por exemplo, um cliente pode realizar 100 requisições em cada uma de três instâncias e ultrapassar o limite global sem que nenhuma instância identifique corretamente o excesso.

Para aplicar um limite compartilhado, pode ser necessário utilizar:

- Armazenamento distribuído;
- Contadores compartilhados;
- Serviço especializado de controle de tráfego;
- Recursos oferecidos pela infraestrutura.

O armazenamento compartilhado precisa considerar latência, disponibilidade, concorrência, expiração dos contadores e comportamento quando estiver indisponível.

**Explicação didática:**

Com contadores locais:

~~~mermaid
flowchart LR
    C["Cliente"] --> G1["Gateway 1<br/>80 requisições"]
    C --> G2["Gateway 2<br/>80 requisições"]
    C --> G3["Gateway 3<br/>80 requisições"]
~~~

Cada Gateway pode acreditar que o cliente está dentro do limite, mesmo que o total seja muito maior.

Com um contador compartilhado:

~~~mermaid
flowchart LR
    C["Cliente"] --> G1["Gateway 1"]
    C --> G2["Gateway 2"]
    C --> G3["Gateway 3"]
    G1 --> R["Contador compartilhado"]
    G2 --> R
    G3 --> R
~~~

**Exemplo prático:**

O limite é de 100 requisições por minuto. Com três instâncias e contadores locais, um cliente consegue realizar aproximadamente 300 requisições antes de ser bloqueado.

**Como o candidato deve responder:**

O candidato deve:

- Explicar o problema de estado local;
- Considerar múltiplas instâncias;
- Citar armazenamento ou contador compartilhado;
- Avaliar disponibilidade e latência;
- Evitar assumir que uma instância local conhece todo o tráfego.

**Resposta fraca ou incompleta:**

“Cada Gateway controla seu próprio limite, então está tudo certo.”

Essa resposta ignora que o limite pode ser global por cliente.

**Critérios de avaliação:**

- **0:** Não identifica o problema de contadores locais.
- **1:** Percebe apenas que existem várias instâncias.
- **2:** Sugere compartilhar dados, mas não explica os desafios.
- **3:** Explica corretamente o rate limiting distribuído.
- **4:** Considera expiração, concorrência, disponibilidade e latência.
- **5:** Discute algoritmos, consistência, falhas do armazenamento, limites por rota e degradação controlada.

---

# Pergunta 77 — Configuração de circuit breaker por dependência

**Nível:** Júnior  
**Categoria:** Resiliência

**Pergunta do entrevistador:**  
Por que pode ser inadequado utilizar exatamente a mesma configuração de circuit breaker para todas as dependências de uma aplicação?

**O que essa pergunta avalia:**

- Compreensão de configuração contextual;
- Capacidade de relacionar resiliência à regra de negócio;
- Noções de latência e criticidade;
- Identificação de configurações genéricas inadequadas.

**Perguntas de aprofundamento:**

1. Uma chamada de catálogo deve ter o mesmo timeout de um pagamento?
2. Como você escolheria os limites de falha?
3. O que monitoraria para ajustar a configuração?

**Resposta esperada:**

Cada dependência pode possuir características diferentes:

- Latência esperada;
- Criticidade;
- Taxa normal de erro;
- Capacidade;
- Tipo de operação;
- Necessidade de consistência;
- Possibilidade de fallback;
- Comportamento durante indisponibilidade.

Uma chamada de recomendações pode aceitar fallback e timeout menor. Já uma operação financeira pode exigir confirmação, idempotência e tratamento mais cuidadoso.

A configuração deve ser baseada em métricas e testes, considerando:

- Timeout;
- Janela de análise;
- Número ou percentual de falhas;
- Tempo em estado aberto;
- Chamadas de teste no estado `half-open`;
- Estratégia de fallback.

**Exemplo de configuração ilustrativa:**

~~~yaml
resilience4j:
  circuitbreaker:
    instances:
      recomendacoes:
        slidingWindowSize: 50
        failureRateThreshold: 60

      pagamentos:
        slidingWindowSize: 100
        failureRateThreshold: 30
~~~

Os valores são apenas ilustrativos e devem ser calibrados de acordo com o comportamento real do sistema.

**Como o candidato deve responder:**

O candidato deve:

- Explicar que dependências possuem características diferentes;
- Relacionar configuração à criticidade;
- Considerar timeout, falhas e fallback;
- Mencionar métricas;
- Evitar copiar a mesma configuração para todos os serviços.

**Resposta fraca ou incompleta:**

“Uma configuração padrão serve para qualquer dependência.”

Essa abordagem pode gerar circuitos abrindo cedo demais ou tarde demais.

**Critérios de avaliação:**

- **0:** Afirma que todas as dependências devem usar os mesmos valores.
- **1:** Reconhece diferenças, mas não explica quais.
- **2:** Cita timeout, mas ignora criticidade e fallback.
- **3:** Explica a necessidade de configuração por dependência.
- **4:** Considera métricas, janelas, limites e criticidade.
- **5:** Discute calibração, falsos positivos, orçamento de latência e comportamento de recuperação.

---

# Pergunta 78 — Falha parcial durante uma operação distribuída

**Nível:** Júnior  
**Categoria:** Consistência e resiliência

**Pergunta do entrevistador:**  
Um pedido foi criado, mas a reserva de estoque falhou. Como você trataria esse cenário em uma arquitetura de microsserviços?

**O que essa pergunta avalia:**

- Compreensão de falhas parciais;
- Noções de consistência eventual;
- Capacidade de propor compensação;
- Diferenciação entre transação local e distribuída.

**Perguntas de aprofundamento:**

1. Você utilizaria uma única transação de banco para todos os serviços?
2. O pedido deveria permanecer criado?
3. O que é uma ação compensatória?

**Resposta esperada:**

Eu começaria definindo o estado permitido pelo domínio. O pedido pode ficar com status `PENDENTE`, `AGUARDANDO_ESTOQUE` ou ser cancelado, dependendo da regra de negócio.

Em uma arquitetura distribuída, normalmente cada serviço possui sua própria transação local. Não se deve assumir que uma única transação de banco abrangerá todos os microsserviços.

Uma abordagem possível é:

1. Criar o pedido;
2. Publicar `PedidoCriado`;
3. Tentar reservar o estoque;
4. Publicar sucesso ou falha;
5. Atualizar o status do pedido;
6. Executar compensação quando necessário.

É importante garantir idempotência, rastreabilidade e reprocessamento.

**Explicação didática:**

O fluxo pode ser:

~~~mermaid
stateDiagram-v2
    [*] --> PedidoCriado
    PedidoCriado --> AguardandoEstoque: Publicar evento
    AguardandoEstoque --> EstoqueReservado: Reserva concluída
    AguardandoEstoque --> FalhaEstoque: Reserva recusada
    FalhaEstoque --> PedidoCancelado: Ação compensatória
    EstoqueReservado --> Confirmado
~~~

Uma compensação não desfaz magicamente todas as operações. Ela executa uma nova ação para levar o sistema a um estado aceitável.

**Exemplo prático:**

O pedido foi registrado, mas não há estoque suficiente. O serviço de pedidos atualiza o status para `CANCELADO` e envia uma notificação ao cliente.

**Como o candidato deve responder:**

O candidato deve:

- Reconhecer a falha parcial;
- Considerar estados intermediários;
- Mencionar eventos e compensação;
- Falar sobre idempotência;
- Evitar assumir que uma transação distribuída é sempre a solução mais simples.

**Resposta fraca ou incompleta:**

“Eu faria rollback do banco do pedido e do estoque ao mesmo tempo.”

Essa resposta ignora que os serviços podem possuir bancos separados e transações independentes.

**Critérios de avaliação:**

- **0:** Não reconhece a possibilidade de falha parcial.
- **1:** Sugere apenas repetir a operação.
- **2:** Percebe que os serviços podem ficar inconsistentes.
- **3:** Explica estados intermediários e compensação.
- **4:** Considera eventos, idempotência, reprocessamento e notificações.
- **5:** Discute consistência eventual, sagas, observabilidade, reconciliação e trade-offs de transações distribuídas.

---

# Pergunta 79 — Timeout durante uma operação de negócio

**Nível:** Júnior  
**Categoria:** Resiliência e consistência

**Pergunta do entrevistador:**  
Uma chamada para criar um pagamento termina com timeout no cliente. Como você descobriria se o pagamento foi processado ou não?

**O que essa pergunta avalia:**

- Compreensão de timeouts ambíguos;
- Conhecimento sobre idempotência;
- Capacidade de evitar duplicidade financeira;
- Raciocínio sobre confirmação de operações.

**Perguntas de aprofundamento:**

1. Você repetiria imediatamente a cobrança?
2. Como consultaria o resultado da operação?
3. Qual é a finalidade de uma chave de idempotência?

**Resposta esperada:**

Um timeout não significa necessariamente que a operação não foi processada. O serviço pode ter concluído o pagamento, mas a resposta pode ter sido perdida durante a comunicação.

Eu verificaria o resultado por meio de:

- Consulta pelo identificador da operação;
- Chave de idempotência;
- Status persistido;
- Evento de confirmação;
- Endpoint específico de consulta;
- Logs e traces correlacionados.

Não repetiria uma cobrança sem controle, pois isso pode gerar duplicidade.

Uma estratégia adequada é enviar uma chave única para a operação. Se a mesma chave for reutilizada, o serviço deve retornar o resultado já registrado ou informar que a operação ainda está em andamento.

**Explicação didática:**

O fluxo pode ser:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant P as Pagamento

    C->>P: Criar pagamento com chave única
    P->>P: Processar pagamento
    P--xC: Resposta perdida ou timeout
    C->>P: Consultar status da operação
    P-->>C: Retornar status já processado
~~~

O cliente precisa distinguir:

- Operação ainda não iniciada;
- Operação em processamento;
- Operação concluída;
- Operação recusada;
- Operação com falha desconhecida.

**Exemplo prático:**

O cliente recebeu timeout após solicitar uma cobrança. Ao consultar o status usando a chave de idempotência, descobre que o pagamento foi aprovado e evita uma nova cobrança.

**Como o candidato deve responder:**

O candidato deve:

- Explicar que timeout gera ambiguidade;
- Mencionar consulta de status;
- Utilizar idempotência;
- Evitar repetir operações financeiras sem confirmação;
- Considerar estados intermediários.

**Resposta fraca ou incompleta:**

“Eu faria a chamada novamente até receber HTTP 200.”

Essa abordagem pode cobrar o cliente várias vezes.

**Critérios de avaliação:**

- **0:** Recomenda repetir cobranças sem controle.
- **1:** Reconhece que o timeout representa um erro.
- **2:** Percebe a possibilidade de processamento, mas não apresenta solução.
- **3:** Explica consulta de status e idempotência.
- **4:** Considera estados intermediários, eventos e rastreabilidade.
- **5:** Discute reconciliação, consistência, segurança e tratamento de respostas ambíguas.

---

# Pergunta 80 — Checklist de produção para uma aplicação Spring Cloud

**Nível:** Júnior  
**Categoria:** Operação e arquitetura

**Pergunta do entrevistador:**  
Quais itens você verificaria antes de colocar uma aplicação baseada em Spring Cloud em produção?

**O que essa pergunta avalia:**

- Visão geral do ecossistema;
- Capacidade de identificar riscos;
- Conhecimento de operação;
- Organização de uma validação pré-produção.

**Perguntas de aprofundamento:**

1. Como você saberia que a aplicação está pronta para receber tráfego?
2. Que configurações não deveriam ser expostas?
3. O que monitoraria imediatamente após a implantação?

**Resposta esperada:**

Eu verificaria pelo menos:

### Configuração

- Profiles corretos;
- Fontes de configuração;
- Valores obrigatórios;
- Ausência de conflitos;
- Compatibilidade entre versões;
- Configurações específicas de produção.

### Segurança

- HTTPS e certificados;
- Autenticação e autorização;
- Segredos fora do código;
- Controle de acesso;
- Proteção de endpoints administrativos;
- CORS restritivo;
- Não exposição de dados sensíveis.

### Descoberta e Gateway

- Registro das instâncias;
- Health checks;
- Rotas;
- Predicados e filtros;
- Balanceamento;
- Alta disponibilidade do Gateway;
- Timeouts e limites.

### Resiliência

- Circuit breakers;
- Retries limitados;
- Backoff;
- Fallbacks seguros;
- Bulkheads;
- Idempotência;
- Tratamento de mensagens duplicadas.

### Observabilidade

- Logs estruturados;
- IDs de correlação;
- Métricas;
- Traces;
- Alertas;
- Dashboards;
- Monitoramento de filas e consumidores.

### Implantação

- Testes automatizados;
- Testes de integração e contrato;
- Readiness e liveness;
- Graceful shutdown;
- Rollback;
- Publicação gradual;
- Verificação pós-deploy.

**Explicação didática:**

Uma aplicação pode estar funcionando localmente e ainda não estar pronta para produção. O checklist deve avaliar o sistema inteiro:

~~~mermaid
flowchart TD
    A["Aplicação pronta para implantação"] --> B["Validar configuração"]
    B --> C["Validar segurança"]
    C --> D["Validar Gateway e descoberta"]
    D --> E["Validar resiliência"]
    E --> F["Validar observabilidade"]
    F --> G["Executar implantação gradual"]
    G --> H["Monitorar e confirmar operação"]
~~~

O objetivo não é apenas verificar se a aplicação inicia, mas se ela pode operar com segurança, disponibilidade e capacidade de diagnóstico.

**Exemplo prático:**

Antes de publicar um novo microsserviço, a equipe confirma que:

- Ele está registrado;
- Está sendo considerado pronto;
- Possui rota protegida;
- Usa configurações de produção;
- Tem métricas e logs;
- Possui limites de timeout;
- Pode ser removido do tráfego durante um rollback.

**Como o candidato deve responder:**

O candidato deve:

- Organizar a resposta por categorias;
- Citar configuração, segurança, resiliência e observabilidade;
- Considerar Gateway e descoberta;
- Mencionar testes e rollback;
- Evitar limitar a validação ao fato de a aplicação iniciar.

**Resposta fraca ou incompleta:**

“Eu verificaria se compila e faria uma chamada para saber se retorna 200.”

Essa resposta cobre apenas uma pequena parte da preparação para produção.

**Critérios de avaliação:**

- **0:** Não apresenta verificações relevantes.
- **1:** Verifica apenas se a aplicação inicia.
- **2:** Cita testes e configuração, mas ignora operação.
- **3:** Considera configuração, Gateway, saúde e segurança básica.
- **4:** Inclui resiliência, observabilidade, testes e rollback.
- **5:** Apresenta uma visão completa de produção, incluindo disponibilidade, segurança, capacidade, diagnóstico, implantação gradual e recuperação de incidentes.

---

## Resumo desta parte

- **Perguntas apresentadas:** 71 a 80
- **Perguntas restantes:** 20
- **Nível abordado:** Júnior
- **Categorias cobertas:**
  - Compatibilidade de APIs;
  - Versionamento;
  - Balanceamento;
  - Cache;
  - Observabilidade assíncrona;
  - Rate limiting distribuído;
  - Circuit breaker;
  - Falhas parciais;
  - Idempotência;
  - Consistência;
  - Operação em produção.

## Matriz parcial de competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---:|---|
| Compatibilidade de contratos | Júnior | 71 e 72 | Identifica mudanças compatíveis e incompatíveis |
| Versionamento de APIs | Júnior | 72 | Planeja coexistência e migração gradual |
| Balanceamento por capacidade | Júnior | 73 | Reconhece que distribuição igual não significa desempenho igual |
| Cache no Gateway | Júnior | 74 | Avalia expiração, escopo, segurança e consistência |
| Correlação assíncrona | Júnior | 75 | Relaciona requisições, eventos, logs e traces |
| Rate limiting distribuído | Júnior | 76 | Entende estado compartilhado entre instâncias |
| Circuit breaker por dependência | Júnior | 77 | Configura resiliência conforme criticidade e comportamento |
| Falhas parciais | Júnior | 78 | Trabalha com estados intermediários e compensação |
| Timeouts ambíguos | Júnior | 79 | Evita duplicidade e utiliza consulta de status |
| Preparação para produção | Júnior | 80 | Avalia configuração, segurança, operação e observabilidade |

## Recomendações específicas para o entrevistador

- Verifique se o candidato entende que nem toda alteração de API é compatível.
- Pergunte como ele conduziria a migração de consumidores antigos.
- Explore os limites de algoritmos simples de balanceamento.
- Avalie se o candidato considera dados personalizados ao falar de cache.
- Em mensageria, peça que explique como relacionaria um evento a uma requisição original.
- Investigue se ele compreende os desafios de rate limiting em múltiplas instâncias.
- Apresente cenários de falha parcial e observe se ele propõe estados intermediários.
- Em operações financeiras, verifique se ele reconhece a ambiguidade causada por timeouts.
- Finalize solicitando um checklist de produção para avaliar a visão integrada do candidato.

## Recomendações específicas para o candidato

- Preserve contratos existentes sempre que possível.
- Ao versionar APIs, planeje coexistência, migração e remoção.
- Não confunda quantidade igual de requisições com carga equilibrada.
- Use cache somente quando a validade e o escopo dos dados forem conhecidos.
- Propague identificadores para facilitar a investigação de fluxos assíncronos.
- Em ambientes com múltiplas instâncias, considere estado compartilhado.
- Configure resiliência conforme a dependência, e não com valores genéricos.
- Trate falhas parciais com estados explícitos e ações compensatórias.
- Nunca repita automaticamente uma operação financeira após timeout sem verificar seu status.
- Antes da produção, avalie segurança, saúde, resiliência, observabilidade e rollback.

---

# Roteiro de Entrevista Técnica — Spring Cloud

## Perguntas 81 a 90

> Continuação do roteiro para avaliação de nível Júnior, com perguntas conceituais, práticas e baseadas em cenários reais.

---

# Pergunta 81 — Retry e risco de sobrecarga

**Nível:** Júnior  
**Categoria:** Resiliência

**Pergunta do entrevistador:**  
Quando uma chamada para outro microsserviço falha, por que não devemos configurar retries ilimitados?

**O que essa pergunta avalia:**

- Compreensão de retries;
- Noções de sobrecarga em cascata;
- Capacidade de diferenciar falhas temporárias e permanentes;
- Conhecimento sobre backoff e limites.

**Perguntas de aprofundamento:**

1. Em quais situações um retry pode ser útil?
2. O que pode acontecer se todos os serviços repetirem chamadas ao mesmo tempo?
3. Como você evitaria repetir uma operação não idempotente?

**Resposta esperada:**

Retries podem ajudar quando a falha é temporária, como uma interrupção breve de rede ou uma indisponibilidade momentânea.

Porém, retries ilimitados podem:

- Aumentar a carga sobre o serviço que já está com problemas;
- Aumentar a latência percebida pelo cliente;
- Criar efeito cascata;
- Consumir threads e conexões;
- Duplicar operações;
- Impedir a recuperação da dependência.

Eu configuraria:

- Número máximo de tentativas;
- Timeout por tentativa;
- Backoff entre tentativas;
- Jitter para evitar chamadas simultâneas;
- Lista de erros que permitem retry;
- Fallback ou resposta de erro após o limite.

Também verificaria se a operação é idempotente antes de repetir automaticamente.

**Explicação didática:**

Sem controle, várias instâncias podem repetir chamadas simultaneamente:

~~~mermaid
flowchart TD
    A["Dependência lenta"] --> B["Chamadas começam a falhar"]
    B --> C["Clientes repetem requisições"]
    C --> D["Mais carga na dependência"]
    D --> E["Latência e erros aumentam"]
    E --> B
~~~

Esse ciclo pode transformar uma falha localizada em uma indisponibilidade generalizada.

**Exemplo prático:**

Uma consulta de catálogo falha por timeout. Duas novas tentativas com intervalo progressivo podem ser aceitáveis. Já uma operação de cobrança não deve ser repetida sem uma chave de idempotência.

**Critérios de avaliação:**

- **0:** Recomenda retries ilimitados.
- **1:** Sabe apenas que retry repete a chamada.
- **2:** Reconhece que muitas tentativas podem gerar problemas.
- **3:** Explica limite, timeout e backoff.
- **4:** Considera idempotência, jitter e efeito cascata.
- **5:** Discute orçamento de latência, classificação de falhas, coordenação entre camadas e proteção contra tempestades de retry.

---

# Pergunta 82 — Timeout entre camadas

**Nível:** Júnior  
**Categoria:** Resiliência e desempenho

**Pergunta do entrevistador:**  
Como você definiria timeouts entre o cliente, o Gateway e os microsserviços?

**O que essa pergunta avalia:**

- Compreensão de timeout;
- Capacidade de analisar uma cadeia de chamadas;
- Noções de orçamento de latência;
- Identificação de configurações inconsistentes.

**Perguntas de aprofundamento:**

1. O timeout do Gateway deveria ser menor ou maior que o timeout do serviço?
2. O que aconteceria se uma camada esperasse mais do que a camada anterior?
3. Como diferenciar lentidão do serviço de lentidão da rede?

**Resposta esperada:**

Os timeouts devem ser definidos considerando o tempo esperado da operação, a latência da rede e o tempo disponível para responder ao cliente.

Em uma cadeia de chamadas, é importante evitar que uma camada espere indefinidamente por outra.

Por exemplo:

- O cliente possui um limite total de 5 segundos;
- O Gateway precisa responder antes desse limite;
- O serviço de pedidos deve possuir um timeout menor que o do Gateway;
- As chamadas internas também devem possuir limites próprios.

O valor exato depende do sistema, mas a configuração deve ser coerente entre as camadas.

Também é necessário monitorar:

- Latência média;
- Percentis, como p95 e p99;
- Tempo de conexão;
- Tempo de leitura;
- Tempo de processamento;
- Número de timeouts.

**Explicação didática:**

Uma configuração incoerente pode produzir este cenário:

~~~mermaid
flowchart LR
    C["Cliente<br/>Timeout: 5 s"] --> G["Gateway<br/>Timeout: 10 s"]
    G --> S["Serviço<br/>Timeout: 15 s"]
~~~

O cliente pode desistir em 5 segundos, enquanto as camadas internas continuam ocupadas por mais tempo.

**Exemplo prático:**

O Gateway possui timeout de 3 segundos, mas o serviço de relatórios demora normalmente 10 segundos. Nesse caso, a operação pode falhar no Gateway mesmo que o serviço esteja funcionando conforme seu comportamento esperado.

**Critérios de avaliação:**

- **0:** Recomenda não utilizar timeouts.
- **1:** Sabe apenas que timeout encerra uma espera.
- **2:** Reconhece que os valores devem ser configurados.
- **3:** Explica timeout por camada e limite de espera.
- **4:** Considera orçamento de latência, percentis e chamadas internas.
- **5:** Discute propagação de deadlines, cancelamento, retries, observabilidade e impacto de timeouts encadeados.

---

# Pergunta 83 — Bulkhead para isolamento de recursos

**Nível:** Júnior  
**Categoria:** Resiliência

**Pergunta do entrevistador:**  
Qual problema o padrão Bulkhead ajuda a resolver em uma aplicação distribuída?

**O que essa pergunta avalia:**

- Conhecimento sobre isolamento de recursos;
- Compreensão de falhas em cascata;
- Noções de concorrência;
- Capacidade de proteger operações críticas.

**Perguntas de aprofundamento:**

1. O que pode acontecer se todas as chamadas compartilharem o mesmo pool de threads?
2. Como isolaria uma dependência lenta?
3. Qual é a diferença entre Bulkhead e circuit breaker?

**Resposta esperada:**

O padrão Bulkhead limita os recursos disponíveis para determinados fluxos ou dependências.

A ideia é impedir que uma operação lenta consuma todos os recursos da aplicação, prejudicando outras operações.

Ele pode limitar:

- Número de chamadas simultâneas;
- Threads;
- Conexões;
- Filas de execução;
- Memória;
- Recursos por dependência.

Por exemplo, chamadas ao serviço de relatórios podem possuir um limite próprio, evitando bloquear chamadas essenciais de pagamento ou autenticação.

O circuit breaker interrompe chamadas quando identifica falhas acima de um limite. O Bulkhead isola recursos para limitar o impacto de uma dependência.

**Explicação didática:**

Sem isolamento:

~~~mermaid
flowchart TD
    A["Serviço"] --> P["Pool compartilhado"]
    P --> B["Chamadas lentas de relatórios"]
    P --> C["Chamadas de pagamentos"]
    B --> D["Pool saturado"]
    D --> C
~~~

Com isolamento:

~~~mermaid
flowchart LR
    A["Serviço"] --> P1["Pool de relatórios"]
    A --> P2["Pool de pagamentos"]
    P1 --> R["Relatórios"]
    P2 --> G["Pagamentos"]
~~~

A lentidão de uma área não deve bloquear completamente as demais.

**Exemplo prático:**

O serviço de relatórios realiza consultas demoradas. A equipe limita a quantidade de execuções simultâneas para preservar os recursos das operações de pedidos.

**Critérios de avaliação:**

- **0:** Não entende o objetivo do Bulkhead.
- **1:** Sabe apenas que está relacionado a resiliência.
- **2:** Reconhece que ele limita chamadas.
- **3:** Explica isolamento de recursos.
- **4:** Diferencia Bulkhead de circuit breaker e considera pools.
- **5:** Discute concorrência, filas, rejeição controlada, capacidade e impacto entre fluxos críticos e não críticos.

---

# Pergunta 84 — Contrato de erro entre microsserviços

**Nível:** Júnior  
**Categoria:** APIs e integração

**Pergunta do entrevistador:**  
Por que é importante padronizar as respostas de erro entre microsserviços?

**O que essa pergunta avalia:**

- Compreensão de contratos de API;
- Conhecimento sobre códigos HTTP;
- Capacidade de facilitar tratamento no cliente;
- Noções de observabilidade e segurança.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre erro funcional e erro técnico?
2. Que informações você colocaria em uma resposta de erro?
3. O que não deveria ser exposto ao cliente?

**Resposta esperada:**

Um contrato de erro padronizado facilita o tratamento pelos consumidores e reduz a necessidade de interpretar mensagens diferentes para cada serviço.

Uma resposta pode conter:

- Código HTTP;
- Código interno do erro;
- Mensagem adequada ao consumidor;
- Identificador de correlação;
- Detalhes de validação, quando aplicável;
- Timestamp ou informações técnicas controladas.

Exemplo:

~~~json
{
  "code": "PEDIDO_NAO_ENCONTRADO",
  "message": "O pedido informado não foi encontrado.",
  "correlationId": "abc-123"
}
~~~

A resposta não deve expor:

- Stack trace;
- Senhas;
- Tokens;
- Nomes internos de bancos;
- Endereços de infraestrutura;
- Informações que facilitem ataques.

Também é importante não utilizar sempre HTTP 500 para qualquer situação. Erros de validação, autenticação, autorização e recurso inexistente possuem tratamentos diferentes.

**Explicação didática:**

Um Gateway pode receber erros de vários serviços. Se cada serviço usar um formato completamente diferente, o cliente terá dificuldade para tratá-los de forma consistente.

**Exemplo prático:**

Uma requisição contém campos inválidos. O serviço retorna `400` com os campos que precisam ser corrigidos. Já uma falha inesperada pode resultar em `500`, sem revelar detalhes internos.

**Critérios de avaliação:**

- **0:** Recomenda devolver stack trace ao cliente.
- **1:** Reconhece que erros devem ser informados.
- **2:** Cita códigos HTTP, mas não propõe padrão.
- **3:** Explica a importância de um contrato de erro.
- **4:** Considera correlação, validação e proteção de informações.
- **5:** Discute taxonomia de erros, compatibilidade, localização de mensagens, observabilidade e tratamento no Gateway.

---

# Pergunta 85 — Configuração de CORS

**Nível:** Júnior  
**Categoria:** Segurança e Gateway

**Pergunta do entrevistador:**  
O que é CORS e quais cuidados devem ser considerados ao configurá-lo em um API Gateway?

**O que essa pergunta avalia:**

- Conhecimento básico sobre segurança de navegadores;
- Compreensão de origens;
- Capacidade de evitar configurações excessivamente permissivas;
- Noções de preflight.

**Perguntas de aprofundamento:**

1. Por que `Access-Control-Allow-Origin: *` pode ser inadequado?
2. O que é uma requisição preflight?
3. CORS substitui autenticação?

**Resposta esperada:**

CORS é um mecanismo que controla quais origens podem realizar requisições a uma aplicação por meio de navegadores.

Ao configurar o Gateway, eu avaliaria:

- Origens permitidas;
- Métodos HTTP;
- Headers permitidos;
- Headers expostos;
- Uso de credenciais;
- Requisições preflight;
- Ambientes diferentes;
- Necessidade de limitar origens por aplicação.

A configuração não deve liberar qualquer origem sem necessidade. O uso de curingas pode ser perigoso principalmente quando há credenciais, cookies ou dados sensíveis.

CORS é uma política aplicada pelo navegador. Ele não substitui autenticação, autorização, TLS ou outras camadas de segurança.

**Explicação didática:**

O navegador pode realizar uma verificação antes da chamada principal:

~~~mermaid
sequenceDiagram
    participant B as Navegador
    participant G as Gateway
    participant S as Serviço

    B->>G: Requisição preflight OPTIONS
    G-->>B: Origens e métodos permitidos
    B->>G: Requisição principal
    G->>S: Encaminhar chamada
    S-->>G: Resposta
    G-->>B: Resposta permitida
~~~

**Exemplo prático:**

A aplicação web oficial está hospedada em `https://app.exemplo.com`. O Gateway permite essa origem, mas bloqueia origens desconhecidas.

**Critérios de avaliação:**

- **0:** Recomenda liberar todas as origens sem avaliação.
- **1:** Sabe apenas que CORS está relacionado ao navegador.
- **2:** Reconhece origens permitidas, mas ignora credenciais.
- **3:** Explica CORS e preflight.
- **4:** Considera métodos, headers, credenciais e segurança.
- **5:** Diferencia CORS de autenticação, discute ambientes, configuração centralizada e riscos de curingas.

---

# Pergunta 86 — Exposição de endpoints administrativos

**Nível:** Júnior  
**Categoria:** Segurança e operação

**Pergunta do entrevistador:**  
Quais cuidados devem ser tomados ao expor endpoints do Spring Boot Actuator em uma aplicação Spring Cloud?

**O que essa pergunta avalia:**

- Conhecimento sobre endpoints operacionais;
- Consciência de segurança;
- Capacidade de proteger informações internas;
- Noções de monitoramento.

**Perguntas de aprofundamento:**

1. Todos os endpoints do Actuator deveriam estar públicos?
2. Que informações podem ser sensíveis?
3. Como disponibilizaria health checks sem expor dados internos?

**Resposta esperada:**

Os endpoints do Actuator fornecem informações importantes para operação, mas não devem ser expostos publicamente sem controle.

Eu avaliaria:

- Quais endpoints realmente precisam ser habilitados;
- Quem pode acessá-los;
- Se estão protegidos por autenticação;
- Se ficam disponíveis apenas em rede interna;
- Se informações sensíveis estão ocultas;
- Se endpoints de alteração são desabilitados ou restritos;
- Como o balanceador acessará o health check.

Endpoints como métricas, ambiente, beans e configuração podem revelar detalhes da aplicação. Endpoints administrativos devem utilizar autenticação, autorização e, quando necessário, uma rede separada.

É possível expor apenas uma verificação de saúde controlada para o balanceador, sem liberar todas as informações operacionais ao público.

**Exemplo de configuração ilustrativa:**

~~~yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info
  endpoint:
    health:
      show-details: never
~~~

A configuração deve ser adaptada ao ambiente e aos requisitos de segurança.

**Critérios de avaliação:**

- **0:** Recomenda expor todos os endpoints publicamente.
- **1:** Sabe apenas que Actuator mostra informações.
- **2:** Reconhece que existe risco, mas não propõe proteção.
- **3:** Explica exposição limitada e autenticação.
- **4:** Considera health checks, métricas e dados sensíveis.
- **5:** Discute redes administrativas, menor privilégio, auditoria, segregação e monitoramento de acessos.

---

# Pergunta 87 — Segredos e configuração sensível

**Nível:** Júnior  
**Categoria:** Segurança e configuração

**Pergunta do entrevistador:**  
Como você armazenaria senhas, tokens e chaves utilizadas por uma aplicação Spring Cloud?

**O que essa pergunta avalia:**

- Conhecimento sobre gestão de segredos;
- Capacidade de proteger credenciais;
- Noções de configuração externa;
- Consciência de riscos em logs e repositórios.

**Perguntas de aprofundamento:**

1. Por que não colocar a senha diretamente no arquivo de configuração?
2. Como evitar que um segredo apareça nos logs?
3. O que fazer se uma chave for acidentalmente publicada?

**Resposta esperada:**

Eu não armazenaria segredos diretamente no código-fonte ou em arquivos versionados sem proteção.

Utilizaria um mecanismo apropriado de gerenciamento de segredos, integrado ao ambiente de execução, como:

- Cofre de segredos;
- Variáveis protegidas;
- Secret store da plataforma;
- Configuração criptografada com controle de acesso;
- Credenciais temporárias, quando disponíveis.

Também garantiria:

- Rotação periódica;
- Princípio do menor privilégio;
- Auditoria de acesso;
- Não exposição em logs;
- Diferenciação entre ambientes;
- Revogação em caso de vazamento.

Se um segredo fosse publicado, eu o consideraria comprometido, revogaria ou substituiria a credencial e investigaria o alcance da exposição.

**Exemplo inadequado:**

~~~yaml
spring:
  datasource:
    password: MinhaSenhaDeProducao
~~~

**Exemplo conceitual mais seguro:**

~~~yaml
spring:
  datasource:
    password: ${DB_PASSWORD}
~~~

A variável também precisa ser protegida. Apenas substituir o valor por uma variável não resolve se o ambiente armazená-la de forma insegura.

**Critérios de avaliação:**

- **0:** Recomenda colocar segredos no código.
- **1:** Sabe apenas que senhas devem ser protegidas.
- **2:** Sugere variáveis de ambiente, mas ignora rotação e acesso.
- **3:** Explica uso de secret store e configuração externa.
- **4:** Considera menor privilégio, logs, rotação e revogação.
- **5:** Discute credenciais temporárias, auditoria, detecção de vazamento e resposta a incidentes.

---

# Pergunta 88 — Compatibilidade entre mensagens

**Nível:** Júnior  
**Categoria:** Mensageria e evolução

**Pergunta do entrevistador:**  
Como evoluir o formato de um evento sem quebrar consumidores que ainda utilizam a versão anterior?

**O que essa pergunta avalia:**

- Compreensão de contratos assíncronos;
- Conhecimento sobre compatibilidade;
- Capacidade de planejar mudanças em eventos;
- Noções de versionamento de mensagens.

**Perguntas de aprofundamento:**

1. O que aconteceria se você removesse um campo utilizado pelo consumidor?
2. Como um consumidor poderia ignorar campos desconhecidos?
3. Quando seria necessário criar um novo tipo de evento?

**Resposta esperada:**

Eu trataria o evento como um contrato entre produtor e consumidores.

Para preservar compatibilidade, eu poderia:

- Adicionar campos opcionais;
- Manter campos antigos durante a transição;
- Evitar alterar o significado de campos existentes;
- Criar uma nova versão do evento;
- Publicar os dois formatos temporariamente;
- Atualizar os consumidores gradualmente;
- Utilizar um schema versionado;
- Testar produtor e consumidores.

Uma mudança incompatível pode exigir um novo tópico, nome de evento ou versão de schema.

Também é importante definir quem pode alterar o contrato e como os consumidores serão comunicados.

**Exemplo compatível:**

~~~json
{
  "eventType": "PedidoCriado",
  "version": 1,
  "pedidoId": 10,
  "clienteId": 50,
  "observacao": "Entrega expressa"
}
~~~

Se `observacao` for opcional e os consumidores souberem ignorar campos desconhecidos, a mudança tende a ser compatível.

**Critérios de avaliação:**

- **0:** Recomenda alterar ou remover campos sem avaliar consumidores.
- **1:** Reconhece que mensagens possuem formato.
- **2:** Cita versionamento, mas não explica coexistência.
- **3:** Explica compatibilidade de eventos.
- **4:** Considera schema, campos opcionais e migração gradual.
- **5:** Discute evolução de contratos, consumidores independentes, compatibilidade de serialização, governança e estratégia de descontinuação.

---

# Pergunta 89 — Ordenação e concorrência no consumidor

**Nível:** Júnior  
**Categoria:** Mensageria e processamento

**Pergunta do entrevistador:**  
O que pode acontecer quando várias instâncias consumidoras processam eventos da mesma entidade simultaneamente?

**O que essa pergunta avalia:**

- Compreensão de concorrência;
- Noções de ordenação;
- Capacidade de identificar condições de corrida;
- Conhecimento sobre consistência.

**Perguntas de aprofundamento:**

1. Como impediria que dois eventos atualizassem a mesma entidade de forma incorreta?
2. Quando utilizaria controle de versão?
3. O processamento paralelo sempre é desejável?

**Resposta esperada:**

Quando várias instâncias processam eventos da mesma entidade simultaneamente, podem ocorrer:

- Atualizações fora de ordem;
- Perda de alterações;
- Condições de corrida;
- Duplicidade;
- Estado final incorreto;
- Conflitos de versão.

Algumas estratégias são:

- Direcionar eventos da mesma entidade para a mesma partição;
- Utilizar uma chave de particionamento;
- Aplicar controle de versão;
- Usar bloqueio ou controle de concorrência otimista;
- Garantir idempotência;
- Reprocessar eventos conflitantes;
- Criar operações comutativas quando possível.

O paralelismo pode ser usado para entidades diferentes, preservando a ordem necessária dentro de cada entidade.

**Explicação didática:**

Eventos de pedidos diferentes podem ser processados em paralelo:

~~~mermaid
flowchart LR
    E1["Pedido 100<br/>Evento 1"] --> P1["Partição 1"]
    E2["Pedido 100<br/>Evento 2"] --> P1
    E3["Pedido 200<br/>Evento 1"] --> P2["Partição 2"]
~~~

A chave do pedido ajuda a manter a ordem do pedido 100, enquanto o pedido 200 pode ser processado independentemente.

**Exemplo prático:**

Dois eventos atualizam o status do pedido 100. O consumidor verifica a versão esperada antes de salvar. Se a versão estiver desatualizada, ele aguarda, rejeita ou reprocessa a mensagem.

**Critérios de avaliação:**

- **0:** Afirma que a concorrência não causa problemas.
- **1:** Reconhece apenas que existem várias instâncias.
- **2:** Identifica parcialmente o risco de ordem.
- **3:** Explica condições de corrida e particionamento.
- **4:** Considera versão, idempotência e concorrência otimista.
- **5:** Discute paralelismo por entidade, ordenação por chave, reprocessamento e consistência do estado final.

---

# Pergunta 90 — Diagnóstico de uma falha ponta a ponta

**Nível:** Júnior  
**Categoria:** Troubleshooting e observabilidade

**Pergunta do entrevistador:**  
Um cliente informa que criou um pedido, mas ele não aparece como processado. Como você investigaria o fluxo completo?

**O que essa pergunta avalia:**

- Capacidade de realizar troubleshooting;
- Visão ponta a ponta;
- Conhecimento sobre Gateway, serviços e mensageria;
- Uso de logs, métricas e traces.

**Perguntas de aprofundamento:**

1. Como saberia se a requisição chegou ao Gateway?
2. Como verificaria se o evento foi publicado?
3. O que analisaria se o evento estivesse na fila, mas não fosse consumido?

**Resposta esperada:**

Eu começaria pelo identificador da operação, do pedido ou da correlação e acompanharia as etapas:

1. Verificar se o Gateway recebeu a requisição;
2. Confirmar a rota e a resposta retornada;
3. Verificar se o serviço de pedidos persistiu o pedido;
4. Confirmar a publicação do evento;
5. Verificar a fila ou tópico;
6. Avaliar se o consumidor recebeu a mensagem;
7. Consultar retries e dead-letter queue;
8. Verificar erros, latência e capacidade;
9. Confirmar o estado final do pedido;
10. Investigar possíveis duplicidades ou falhas parciais.

Eu utilizaria logs estruturados, métricas, traces e identificadores consistentes. Também evitaria alterar ou reprocessar mensagens diretamente sem entender o estado atual.

**Explicação didática:**

O diagnóstico deve percorrer todo o fluxo:

~~~mermaid
flowchart LR
    C["Cliente"] --> G["Gateway"]
    G --> P["Serviço de pedidos"]
    P --> B["Broker"]
    B --> E["Consumidor"]
    E --> D["Estado final"]
    G -.-> O["Observabilidade"]
    P -.-> O
    B -.-> O
    E -.-> O
~~~

Possíveis pontos de falha incluem:

- Rota incorreta no Gateway;
- Erro de autenticação;
- Falha de persistência;
- Evento não publicado;
- Fila indisponível;
- Consumidor parado;
- Mensagem em retry;
- Mensagem em dead-letter;
- Processamento duplicado;
- Falha ao atualizar o estado final.

**Exemplo prático:**

O Gateway retornou `202 Accepted`, mas o pedido ainda está pendente. A investigação confirma que o evento foi publicado, porém está acumulado na fila porque todas as instâncias consumidoras estão com erro de conexão com o banco.

**Critérios de avaliação:**

- **0:** Recomenda apenas reiniciar todos os serviços.
- **1:** Consulta somente os logs do Gateway.
- **2:** Verifica o serviço de pedidos, mas ignora o broker.
- **3:** Investiga Gateway, serviço, evento e consumidor.
- **4:** Utiliza correlação, métricas, traces, retries e dead-letter queue.
- **5:** Demonstra investigação sistemática, preserva evidências, considera falhas parciais, duplicidade, impacto operacional e recuperação segura.

---

## Resumo desta parte

- **Perguntas apresentadas:** 81 a 90
- **Perguntas restantes:** 10
- **Nível abordado:** Júnior
- **Categorias cobertas:**
  - Retry;
  - Timeout;
  - Bulkhead;
  - Contratos de erro;
  - CORS;
  - Actuator;
  - Segredos;
  - Compatibilidade de eventos;
  - Concorrência;
  - Troubleshooting ponta a ponta.

## Matriz parcial de competências

| Competência | Nível esperado | Perguntas relacionadas | Indicadores de domínio |
|---|---|---:|---|
| Retries seguros | Júnior | 81 | Conhece limites, backoff, jitter e idempotência |
| Timeouts distribuídos | Júnior | 82 | Entende limites por camada e orçamento de latência |
| Isolamento de recursos | Júnior | 83 | Diferencia Bulkhead de circuit breaker |
| Contrato de erros | Júnior | 84 | Padroniza respostas sem expor dados internos |
| CORS | Júnior | 85 | Compreende origens, preflight e configuração restritiva |
| Actuator seguro | Júnior | 86 | Protege endpoints administrativos e health checks |
| Gestão de segredos | Júnior | 87 | Evita credenciais no código e considera rotação |
| Evolução de eventos | Júnior | 88 | Mantém compatibilidade entre produtores e consumidores |
| Concorrência em consumidores | Júnior | 89 | Trata ordenação, partições e condições de corrida |
| Troubleshooting ponta a ponta | Júnior | 90 | Investiga Gateway, serviços, broker e consumidor |

## Recomendações específicas para o entrevistador

- Verifique se o candidato entende que retry pode aumentar o problema original.
- Explore a relação entre timeouts de cliente, Gateway e microsserviços.
- Pergunte como ele isolaria uma dependência lenta sem comprometer toda a aplicação.
- Avalie se sabe diferenciar erros funcionais de erros técnicos.
- Em CORS, observe se recomenda liberar todas as origens indiscriminadamente.
- Verifique se reconhece os riscos de expor endpoints administrativos.
- Pergunte como reagiria a um segredo publicado acidentalmente.
- Avalie se entende que eventos também possuem contratos e precisam evoluir com compatibilidade.
- Em concorrência, explore condições de corrida e ordenação por entidade.
- Finalize com um cenário completo de troubleshooting e observe se o candidato investiga evidências antes de reiniciar componentes.

## Recomendações específicas para o candidato

- Configure retries limitados e somente para falhas que possam ser temporárias.
- Considere idempotência antes de repetir operações.
- Defina timeouts coerentes entre todas as camadas.
- Use Bulkhead para impedir que uma dependência consuma todos os recursos.
- Padronize erros sem expor detalhes internos.
- Configure CORS com origens e métodos realmente necessários.
- Proteja endpoints administrativos e informações do Actuator.
- Armazene segredos em mecanismos apropriados e faça rotação.
- Evolua eventos preservando compatibilidade com consumidores antigos.
- Ao investigar incidentes, acompanhe a requisição desde o Gateway até o processamento final.

---

# Roteiro de Entrevista Técnica — Spring Cloud

## Perguntas 91 a 100

> Continuação do roteiro para avaliação de nível Júnior, com perguntas conceituais, práticas e baseadas em cenários reais.

---

# Pergunta 91 — Diferença entre API Gateway e Service Mesh

**Nível:** Júnior  
**Categoria:** Arquitetura e comunicação

**Pergunta do entrevistador:**  
Qual é a diferença entre um API Gateway e um Service Mesh em uma arquitetura de microsserviços?

**O que essa pergunta avalia:**

- Compreensão dos componentes de infraestrutura;
- Capacidade de diferenciar tráfego externo e interno;
- Noções de segurança e observabilidade;
- Visão geral de arquiteturas distribuídas.

**Perguntas de aprofundamento:**

1. O Service Mesh substitui completamente o API Gateway?
2. Quem normalmente utiliza o Gateway?
3. Que responsabilidades podem ser delegadas ao Service Mesh?

**Resposta esperada:**

O API Gateway normalmente controla a entrada de requisições externas para os serviços. Ele pode realizar:

- Roteamento;
- Autenticação;
- Rate limiting;
- CORS;
- Transformação de requisições;
- Aplicação de políticas para clientes externos.

O Service Mesh atua principalmente na comunicação interna entre microsserviços. Ele pode oferecer:

- Criptografia entre serviços;
- Autenticação mútua;
- Observabilidade;
- Retries;
- Circuit breaking;
- Controle de tráfego;
- Descoberta e políticas de comunicação.

Os dois componentes podem coexistir. O Gateway protege e organiza a entrada do sistema, enquanto o Service Mesh trata a comunicação interna.

**Explicação didática:**

~~~mermaid
flowchart LR
    C["Cliente externo"] --> G["API Gateway"]
    G --> A["Serviço A"]
    A --> B["Serviço B"]
    B --> D["Serviço C"]
    A -.-> M["Políticas do Service Mesh"]
    B -.-> M
    D -.-> M
~~~

O Gateway é como uma porta de entrada. O Service Mesh funciona como uma camada de controle das comunicações entre os serviços.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar tráfego externo e interno;
- Explicar que os componentes podem coexistir;
- Citar responsabilidades de cada camada;
- Evitar afirmar que um substitui automaticamente o outro.

**Resposta fraca ou incompleta:**

“O Service Mesh é um Gateway mais completo.”

Essa resposta não diferencia as responsabilidades nem os tipos de tráfego.

**Critérios de avaliação:**

- **0:** Confunde completamente os componentes.
- **1:** Sabe apenas que ambos estão relacionados a microsserviços.
- **2:** Diferencia superficialmente entrada e comunicação interna.
- **3:** Explica corretamente as responsabilidades principais.
- **4:** Considera segurança, observabilidade e políticas de tráfego.
- **5:** Discute coexistência, sidecars, mTLS, governança e trade-offs operacionais.

---

# Pergunta 92 — Registro duplicado de uma instância

**Nível:** Júnior  
**Categoria:** Service Discovery e disponibilidade

**Pergunta do entrevistador:**  
O que pode acontecer quando duas instâncias são registradas no Service Registry com o mesmo identificador?

**O que essa pergunta avalia:**

- Compreensão de identificação de instâncias;
- Noções de descoberta de serviços;
- Capacidade de investigar registros incorretos;
- Conhecimento sobre balanceamento.

**Perguntas de aprofundamento:**

1. Como uma instância é normalmente diferenciada de outra?
2. Que problemas podem surgir com identificadores duplicados?
3. Como você investigaria esse comportamento?

**Resposta esperada:**

O identificador de uma instância deve permitir distingui-la das demais. Dependendo da configuração, registros duplicados podem:

- Sobrescrever informações;
- Ocultar uma instância;
- Gerar distribuição incorreta;
- Dificultar a remoção de instâncias antigas;
- Fazer o Gateway encaminhar tráfego para um destino inesperado;
- Produzir inconsistências no registro.

Eu verificaria:

- Nome lógico do serviço;
- Host e porta;
- Identificador da instância;
- Configuração de hostname;
- Endereço IP anunciado;
- Containers ou processos antigos;
- Logs do cliente e do Registry.

Também avaliaria se a aplicação está usando uma identificação única, especialmente em ambientes com múltiplas instâncias.

**Explicação didática:**

~~~mermaid
flowchart TD
    A["Instância 1 inicia"] --> R["Service Registry"]
    B["Instância 2 inicia"] --> R
    R --> C{"Identificadores são únicos?"}
    C -->|"Sim"| D["Registrar ambas corretamente"]
    C -->|"Não"| E["Risco de conflito ou sobrescrita"]
~~~

O nome do serviço identifica a aplicação, mas o identificador da instância precisa identificar cada execução individual.

**Exemplo prático:**

Duas instâncias do `pedido-service` anunciam o mesmo host e a mesma porta por causa de uma configuração incorreta. O Registry pode considerar uma delas como atualização da outra.

**Como o candidato deve responder:**

O candidato deve:

- Explicar a necessidade de identificadores únicos;
- Diferenciar serviço de instância;
- Considerar host, porta e ambiente;
- Propor investigação por logs e configuração.

**Resposta fraca ou incompleta:**

“Não há problema, pois o Registry sabe que são duas aplicações.”

Essa resposta ignora que o Registry precisa de informações suficientes para diferenciar as instâncias.

**Critérios de avaliação:**

- **0:** Não reconhece qualquer risco.
- **1:** Sabe apenas que existe um nome de serviço.
- **2:** Percebe que pode haver conflito, mas não explica o impacto.
- **3:** Explica a necessidade de identificar cada instância.
- **4:** Considera registro, balanceamento e investigação.
- **5:** Discute identificação em ambientes dinâmicos, metadados, renovação e remoção de registros obsoletos.

---

# Pergunta 93 — Diferença entre evento e comando

**Nível:** Júnior  
**Categoria:** Mensageria e arquitetura

**Pergunta do entrevistador:**  
Qual é a diferença entre um evento e um comando em uma arquitetura orientada a mensagens?

**O que essa pergunta avalia:**

- Compreensão de comunicação assíncrona;
- Noções de modelagem de mensagens;
- Capacidade de diferenciar intenção e fato;
- Conhecimento sobre acoplamento entre serviços.

**Perguntas de aprofundamento:**

1. Quem deve processar um comando?
2. Um evento pode ter vários consumidores?
3. Como escolheria o nome de uma mensagem?

**Resposta esperada:**

Um comando representa uma solicitação ou intenção para que algum componente execute uma ação.

Exemplos:

~~~text
ReservarEstoque
CancelarPedido
EnviarNotificacao
~~~

Um evento representa algo que já aconteceu.

Exemplos:

~~~text
PedidoCriado
PagamentoAprovado
EstoqueReservado
~~~

Um comando normalmente possui um destinatário esperado. Um evento pode ser consumido por vários interessados.

A distinção ajuda a definir responsabilidade, acoplamento e semântica da comunicação.

**Explicação didática:**

~~~mermaid
flowchart LR
    A["Pedido criado"] --> E["Evento: PedidoCriado"]
    E --> B["Consumidor de estoque"]
    E --> C["Consumidor de notificações"]
    D["Comando: ReservarEstoque"] --> S["Serviço de estoque"]
~~~

Um evento informa um fato. Um comando solicita uma ação.

**Exemplo prático:**

O serviço de pedidos publica `PedidoCriado`. O serviço de estoque pode receber esse evento e iniciar uma reserva. Já `ReservarEstoque` pode ser um comando direcionado explicitamente ao serviço de estoque.

**Como o candidato deve responder:**

O candidato deve:

- Diferenciar fato ocorrido de solicitação;
- Explicar que eventos podem ter vários consumidores;
- Considerar nomes no passado para eventos;
- Evitar tratar os dois conceitos como sinônimos.

**Resposta fraca ou incompleta:**

“Evento e comando são apenas mensagens com nomes diferentes.”

Essa resposta não explica a diferença de intenção e responsabilidade.

**Critérios de avaliação:**

- **0:** Não diferencia os conceitos.
- **1:** Reconhece apenas que ambos são mensagens.
- **2:** Identifica parcialmente a ideia de ação e acontecimento.
- **3:** Explica corretamente evento e comando.
- **4:** Considera destinatários, múltiplos consumidores e acoplamento.
- **5:** Discute semântica, contratos, rastreabilidade, versionamento e modelagem orientada ao domínio.

---

# Pergunta 94 — Outbox Pattern

**Nível:** Júnior  
**Categoria:** Consistência e mensageria

**Pergunta do entrevistador:**  
Como evitar o problema de salvar uma alteração no banco, mas falhar antes de publicar o evento correspondente?

**O que essa pergunta avalia:**

- Compreensão de inconsistência entre banco e broker;
- Noções de transação local;
- Conhecimento sobre publicação confiável de eventos;
- Capacidade de propor uma solução arquitetural.

**Perguntas de aprofundamento:**

1. O que aconteceria se o banco fosse atualizado, mas o evento não fosse publicado?
2. Como o evento seria reenviado?
3. O consumidor ainda precisa ser idempotente?

**Resposta esperada:**

Uma alternativa é utilizar o Outbox Pattern.

A aplicação grava, na mesma transação local, a alteração de negócio e um registro do evento em uma tabela de outbox. Depois, um processo separado lê os eventos pendentes e os publica no broker.

Assim, se a transação for confirmada, o evento ficará registrado para publicação posterior.

O processo de publicação deve tratar:

- Tentativas;
- Falhas temporárias;
- Marcação de eventos publicados;
- Duplicidade;
- Reprocessamento;
- Monitoramento;
- Retenção ou limpeza dos registros.

O consumidor ainda deve ser idempotente, pois o publicador pode reenviar uma mensagem após uma falha de confirmação.

**Explicação didática:**

~~~mermaid
flowchart LR
    A["Operação de negócio"] --> T["Transação local"]
    T --> B["Atualizar banco"]
    T --> O["Salvar evento na outbox"]
    O --> P["Publicador"]
    P --> Q["Broker"]
    Q --> C["Consumidor"]
~~~

O Outbox reduz a possibilidade de o banco confirmar uma alteração sem que exista um registro persistente da intenção de publicar o evento.

**Exemplo prático:**

O pedido é salvo e o evento `PedidoCriado` é gravado na outbox. Mesmo que o broker esteja indisponível naquele momento, o publicador poderá tentar novamente mais tarde.

**Como o candidato deve responder:**

O candidato deve:

- Identificar a inconsistência entre banco e broker;
- Explicar o registro local do evento;
- Mencionar publicação posterior e retries;
- Reconhecer a necessidade de idempotência.

**Resposta fraca ou incompleta:**

“Eu salvaria o pedido e publicaria o evento logo depois.”

Essa sequência ainda permite que o banco seja confirmado e a publicação falhe.

**Critérios de avaliação:**

- **0:** Não reconhece o problema.
- **1:** Sugere apenas repetir a publicação.
- **2:** Percebe que o evento pode ser perdido.
- **3:** Explica o Outbox Pattern.
- **4:** Considera transação local, retries e duplicidade.
- **5:** Discute CDC, ordenação, limpeza, observabilidade, idempotência e garantias de entrega.

---

# Pergunta 95 — Bulkhead e pool de conexões

**Nível:** Júnior  
**Categoria:** Resiliência e recursos

**Pergunta do entrevistador:**  
Por que limitar apenas o número de threads pode não ser suficiente para proteger uma aplicação contra uma dependência lenta?

**O que essa pergunta avalia:**

- Compreensão de recursos compartilhados;
- Noções de pools de conexão;
- Capacidade de identificar gargalos;
- Conhecimento sobre isolamento de dependências.

**Perguntas de aprofundamento:**

1. Que outros recursos podem ser consumidos por uma chamada lenta?
2. O que acontece quando o pool de conexões se esgota?
3. Como você monitoraria esse problema?

**Resposta esperada:**

Uma chamada lenta pode consumir mais do que threads. Ela também pode manter ocupados:

- Conexões HTTP;
- Conexões de banco;
- Memória;
- Filas;
- Sockets;
- Buffers;
- Recursos do broker.

Mesmo que exista um limite de threads, um pool de conexões compartilhado pode ficar saturado e afetar outras operações.

Eu avaliaria a possibilidade de separar recursos por dependência, ajustar limites e monitorar:

- Conexões ativas;
- Conexões ociosas;
- Tempo de espera por conexão;
- Threads ocupadas;
- Tamanho das filas;
- Timeout de aquisição;
- Taxa de erros.

**Explicação didática:**

~~~mermaid
flowchart TD
    A["Chamadas lentas"] --> B["Conexões ocupadas"]
    B --> C["Pool compartilhado esgotado"]
    C --> D["Outras operações aguardam"]
    D --> E["Aumento de latência e erros"]
~~~

O isolamento precisa considerar todos os recursos relevantes, e não somente a quantidade de threads.

**Exemplo prático:**

As chamadas ao serviço de relatórios demoram muito e consomem todas as conexões HTTP disponíveis. Mesmo o serviço de pagamentos estando saudável, suas chamadas começam a falhar por falta de conexão.

**Como o candidato deve responder:**

O candidato deve:

- Citar conexões e outros recursos;
- Relacionar o problema ao Bulkhead;
- Considerar pools compartilhados;
- Mencionar métricas e limites.

**Resposta fraca ou incompleta:**

“Se houver threads suficientes, a aplicação sempre estará protegida.”

Essa resposta ignora outros recursos que também podem ser esgotados.

**Critérios de avaliação:**

- **0:** Não reconhece o consumo de outros recursos.
- **1:** Cita apenas threads.
- **2:** Reconhece conexões, mas não explica o impacto.
- **3:** Explica a necessidade de proteger pools e recursos.
- **4:** Considera métricas, filas e isolamento por dependência.
- **5:** Discute orçamento de recursos, concorrência, rejeição controlada e capacidade.

---

# Pergunta 96 — Canary release

**Nível:** Júnior  
**Categoria:** Implantação e observabilidade

**Pergunta do entrevistador:**  
O que é uma implantação canário e como ela pode reduzir riscos em uma nova versão de microsserviço?

**O que essa pergunta avalia:**

- Conhecimento sobre implantação gradual;
- Capacidade de utilizar métricas;
- Compreensão de rollback;
- Noções de controle de tráfego.

**Perguntas de aprofundamento:**

1. Como escolheria a parcela inicial de tráfego?
2. Que indicadores monitoraria?
3. Quando interromperia a expansão da nova versão?

**Resposta esperada:**

Uma implantação canário direciona uma pequena parcela do tráfego para a nova versão antes de disponibilizá-la para todos os consumidores.

Durante o processo, eu compararia a nova versão com a antiga observando:

- Taxa de erro;
- Latência;
- Consumo de CPU e memória;
- Respostas funcionais;
- Falhas de integração;
- Métricas de negócio;
- Logs e traces.

Se os indicadores permanecerem dentro dos limites esperados, o tráfego poderá ser ampliado gradualmente. Caso contrário, a nova versão deve ser isolada ou revertida.

**Explicação didática:**

~~~mermaid
flowchart LR
    C["Tráfego"] --> V1["Versão antiga<br/>95%"]
    C --> V2["Versão canário<br/>5%"]
    V2 --> M["Monitorar indicadores"]
    M --> D{"Resultado aceitável?"}
    D -->|"Sim"| E["Aumentar tráfego"]
    D -->|"Não"| R["Rollback ou interromper"]
~~~

O percentual inicial depende do risco, da capacidade de observação e do impacto da operação.

**Exemplo prático:**

Uma nova versão do Gateway é direcionada a 5% das requisições. Após alguns minutos, a equipe observa aumento de erros `502` e interrompe a expansão.

**Como o candidato deve responder:**

O candidato deve:

- Explicar tráfego parcial;
- Mencionar comparação entre versões;
- Citar monitoramento e rollback;
- Considerar indicadores técnicos e funcionais.

**Resposta fraca ou incompleta:**

“Canário é publicar a nova versão e esperar que os usuários encontrem problemas.”

Essa resposta não apresenta controle de tráfego nem estratégia de observação.

**Critérios de avaliação:**

- **0:** Não entende a implantação canário.
- **1:** Sabe apenas que é uma publicação gradual.
- **2:** Cita pequena parcela de usuários, mas não menciona métricas.
- **3:** Explica tráfego parcial, monitoramento e rollback.
- **4:** Considera indicadores técnicos e de negócio.
- **5:** Discute critérios de promoção, análise estatística, compatibilidade, automação e interrupção segura.

---

# Pergunta 97 — Feature toggle distribuído

**Nível:** Júnior  
**Categoria:** Configuração e implantação

**Pergunta do entrevistador:**  
Como um feature toggle pode ser utilizado para ativar uma funcionalidade gradualmente em uma arquitetura de microsserviços?

**O que essa pergunta avalia:**

- Compreensão de ativação controlada;
- Noções de configuração distribuída;
- Capacidade de reduzir riscos;
- Conhecimento sobre consistência e governança.

**Perguntas de aprofundamento:**

1. Como ativaria a funcionalidade apenas para alguns usuários?
2. O que aconteceria se os serviços utilizassem valores diferentes?
3. Quando um feature toggle deveria ser removido?

**Resposta esperada:**

Um feature toggle permite controlar se uma funcionalidade está ativa sem necessariamente publicar uma nova versão do código.

Ele pode ser usado para:

- Liberar uma funcionalidade para uma pequena parcela;
- Ativar por ambiente;
- Ativar por cliente ou grupo;
- Desabilitar rapidamente uma função problemática;
- Realizar experimentos controlados.

Os cuidados incluem:

- Definir o proprietário do toggle;
- Controlar acesso;
- Auditar alterações;
- Garantir valores consistentes;
- Monitorar o comportamento;
- Evitar acumular toggles antigos;
- Planejar remoção após a estabilização.

Em uma arquitetura distribuída, é importante avaliar o que acontece se apenas alguns serviços receberem a nova configuração.

**Explicação didática:**

~~~mermaid
flowchart TD
    A["Toggle desativado"] --> B["Publicar código"]
    B --> C["Ativar para pequena parcela"]
    C --> D{"Métricas normais?"}
    D -->|"Sim"| E["Expandir ativação"]
    D -->|"Não"| F["Desativar toggle"]
    E --> G["Remover toggle após estabilização"]
~~~

O toggle reduz o risco de liberar uma funcionalidade para todos de uma vez, mas adiciona complexidade temporária.

**Exemplo prático:**

Uma nova regra de cálculo de frete é ativada somente para funcionários internos. Após validação, a funcionalidade é liberada para 10% dos usuários.

**Como o candidato deve responder:**

O candidato deve:

- Explicar ativação independente da implantação;
- Considerar rollout gradual;
- Mencionar consistência, segurança e remoção;
- Evitar manter toggles indefinidamente.

**Critérios de avaliação:**

- **0:** Recomenda ativar a funcionalidade para todos sem controle.
- **1:** Sabe apenas que o toggle liga ou desliga uma função.
- **2:** Reconhece ativação gradual, mas ignora governança.
- **3:** Explica corretamente o uso de feature toggles.
- **4:** Considera usuários, métricas, consistência e rollback.
- **5:** Discute segmentação, auditoria, dependências entre serviços e dívida técnica de toggles antigos.

---

# Pergunta 98 — Compatibilidade entre versões durante o deploy

**Nível:** Júnior  
**Categoria:** Implantação e integração

**Pergunta do entrevistador:**  
Por que uma nova versão de um serviço deve ser compatível com a versão anterior durante uma implantação gradual?

**O que essa pergunta avalia:**

- Compreensão de coexistência de versões;
- Conhecimento sobre contratos;
- Capacidade de identificar problemas de rollout;
- Noções de compatibilidade entre produtores e consumidores.

**Perguntas de aprofundamento:**

1. O que aconteceria se a nova versão alterasse imediatamente o formato das mensagens?
2. Como faria uma migração de banco sem interromper versões antigas?
3. O que significa expandir e contrair uma alteração?

**Resposta esperada:**

Durante uma implantação gradual, versões antigas e novas podem executar ao mesmo tempo. Por isso, elas precisam compartilhar contratos compatíveis.

Uma estratégia comum é:

1. Expandir: adicionar estruturas ou campos compatíveis;
2. Migrar: atualizar consumidores e produtores gradualmente;
3. Contrair: remover estruturas antigas somente quando não forem mais utilizadas.

Essa abordagem pode ser aplicada a:

- APIs;
- Eventos;
- Schemas de banco;
- Campos de configuração;
- Headers;
- Formatos de resposta.

Alterações incompatíveis podem fazer com que uma versão não consiga processar dados produzidos pela outra.

**Explicação didática:**

~~~mermaid
flowchart LR
    A["Versão antiga e nova coexistem"] --> B["Contratos compatíveis"]
    B --> C["Migrar consumidores"]
    C --> D["Remover elementos antigos"]
~~~

O deploy não deve considerar apenas o código da nova versão. É necessário analisar o ambiente durante o período de coexistência.

**Exemplo prático:**

A nova versão precisa adicionar `nomeCompleto`, mas a versão antiga utiliza `nome`. A equipe mantém os dois campos durante a transição, atualiza os consumidores e só depois remove o campo antigo.

**Como o candidato deve responder:**

O candidato deve:

- Reconhecer a coexistência de versões;
- Mencionar compatibilidade de contratos;
- Considerar APIs, eventos e banco;
- Explicar migração gradual.

**Resposta fraca ou incompleta:**

“Quando a nova versão entrar, a antiga será desligada imediatamente.”

Isso nem sempre corresponde ao modo como implantações graduais funcionam.

**Critérios de avaliação:**

- **0:** Não reconhece o problema de coexistência.
- **1:** Sabe apenas que versões podem ser diferentes.
- **2:** Cita compatibilidade, mas não explica como preservá-la.
- **3:** Explica compatibilidade durante o deploy.
- **4:** Considera APIs, mensagens e banco de dados.
- **5:** Discute estratégias expand/contract, migração reversível, rollout e rollback seguro.

---

# Pergunta 99 — SLO, SLA e indicador de disponibilidade

**Nível:** Júnior  
**Categoria:** Operação e observabilidade

**Pergunta do entrevistador:**  
Qual é a importância de definir indicadores e objetivos de disponibilidade para uma aplicação Spring Cloud?

**O que essa pergunta avalia:**

- Compreensão de confiabilidade;
- Conhecimento sobre métricas;
- Capacidade de relacionar operação e negócio;
- Noções de SLI, SLO e SLA.

**Perguntas de aprofundamento:**

1. Qual é a diferença entre SLI, SLO e SLA?
2. Disponibilidade é o único indicador importante?
3. Como uma taxa de erro pode afetar o objetivo definido?

**Resposta esperada:**

Um SLI é um indicador mensurável, como:

- Percentual de requisições bem-sucedidas;
- Latência;
- Tempo de processamento de mensagens;
- Disponibilidade do serviço.

Um SLO é o objetivo definido para esse indicador, como 99,9% de disponibilidade ou determinado percentual de requisições abaixo de um limite de latência.

Um SLA é um acordo formal, geralmente com compromissos entre partes e possíveis consequências.

Esses objetivos ajudam a definir:

- Alertas;
- Prioridade de incidentes;
- Capacidade;
- Investimentos em resiliência;
- Critérios de implantação;
- Limites para rollback.

Também é importante medir indicadores funcionais, como pedidos processados corretamente, e não apenas respostas HTTP.

**Explicação didática:**

~~~mermaid
flowchart TD
    A["Medir comportamento"] --> B["Definir SLI"]
    B --> C["Estabelecer SLO"]
    C --> D["Monitorar resultado"]
    D --> E{"Objetivo atingido?"}
    E -->|"Sim"| F["Continuar e acompanhar"]
    E -->|"Não"| G["Investigar e corrigir"]
~~~

Um serviço pode retornar HTTP 200 e ainda produzir dados incorretos. Por isso, os indicadores devem refletir a experiência e o resultado do negócio.

**Como o candidato deve responder:**

O candidato deve:

- Explicar a importância de medir;
- Diferenciar, ainda que basicamente, SLI, SLO e SLA;
- Considerar latência, erros e processamento assíncrono;
- Relacionar métricas a decisões operacionais.

**Resposta fraca ou incompleta:**

“Basta verificar se a aplicação está respondendo.”

Essa resposta não considera latência, erros funcionais ou objetivos mensuráveis.

**Critérios de avaliação:**

- **0:** Não entende a necessidade de indicadores.
- **1:** Cita apenas disponibilidade.
- **2:** Reconhece métricas, mas não diferencia objetivos e acordos.
- **3:** Explica SLI, SLO e SLA de forma básica.
- **4:** Relaciona métricas a alertas, capacidade e deploys.
- **5:** Discute error budget, indicadores técnicos e funcionais, alertas e priorização.

---

# Pergunta 100 — Projeto de uma arquitetura Spring Cloud

**Nível:** Júnior  
**Categoria:** Arquitetura integrada

**Pergunta do entrevistador:**  
Como você projetaria uma arquitetura Spring Cloud básica para uma aplicação de pedidos, pagamentos e estoque?

**O que essa pergunta avalia:**

- Integração dos conhecimentos estudados;
- Capacidade de selecionar componentes;
- Raciocínio arquitetural;
- Compreensão de segurança, resiliência e observabilidade.

**Perguntas de aprofundamento:**

1. Quais componentes você utilizaria para entrada, descoberta e configuração?
2. Quais comunicações seriam síncronas e quais seriam assíncronas?
3. Como trataria falhas entre pedidos, pagamentos e estoque?

**Resposta esperada:**

Eu começaria separando responsabilidades:

- `pedido-service`: cria e acompanha pedidos;
- `pagamento-service`: processa pagamentos;
- `estoque-service`: reserva e libera estoque;
- API Gateway: entrada das requisições externas;
- Configuração centralizada: propriedades compartilhadas e específicas;
- Service Discovery ou descoberta fornecida pela plataforma;
- Broker: comunicação assíncrona;
- Observabilidade: logs, métricas e traces;
- Mecanismo de segurança: autenticação, autorização e TLS.

Uma possível estratégia seria:

1. O cliente envia a criação do pedido ao Gateway;
2. O `pedido-service` valida e persiste o pedido;
3. O sistema publica `PedidoCriado`;
4. O estoque tenta realizar a reserva;
5. O pagamento é processado conforme a regra de negócio;
6. Os serviços publicam eventos de sucesso ou falha;
7. O pedido muda de estado;
8. Falhas são tratadas com retries limitados, idempotência e compensações.

A escolha entre comunicação síncrona e assíncrona depende da necessidade de resposta imediata, consistência, latência e tolerância a falhas.

**Explicação didática:**

~~~mermaid
flowchart LR
    C["Cliente"] --> G["API Gateway"]
    G --> P["Pedido"]
    P --> B["Broker"]
    B --> E["Estoque"]
    B --> F["Pagamento"]
    E --> B
    F --> B
    B --> P
    P --> O["Estado final do pedido"]
    G -.-> M["Observabilidade"]
    P -.-> M
    E -.-> M
    F -.-> M
~~~

A arquitetura precisa considerar que os serviços podem falhar independentemente. Não se deve assumir que todas as operações serão confirmadas ao mesmo tempo.

**Exemplo prático:**

O pedido é criado, mas o pagamento é recusado. O sistema pode alterar o pedido para `PAGAMENTO_RECUSADO`, liberar uma eventual reserva de estoque e notificar o cliente.

Se ocorrer um timeout no pagamento, o sistema deve consultar o status ou aguardar um evento, evitando uma cobrança duplicada.

**Como o candidato deve responder:**

O candidato deve:

- Separar responsabilidades;
- Explicar o papel do Gateway;
- Considerar descoberta e configuração;
- Utilizar eventos quando fizer sentido;
- Mencionar idempotência, retries e compensação;
- Incluir segurança e observabilidade;
- Reconhecer consistência eventual e falhas parciais.

**Resposta fraca ou incompleta:**

“Eu criaria três aplicações e faria todas chamarem umas às outras diretamente.”

Essa resposta não trata descoberta, segurança, mensageria, resiliência, observabilidade ou consistência.

**Critérios de avaliação:**

- **0:** Não consegue organizar uma arquitetura básica.
- **1:** Apenas lista microsserviços sem explicar a comunicação.
- **2:** Cita Gateway e broker, mas ignora falhas e consistência.
- **3:** Propõe uma arquitetura coerente com Gateway, serviços e mensageria.
- **4:** Inclui segurança, observabilidade, idempotência e compensação.
- **5:** Demonstra visão integrada de contratos, descoberta, configuração, resiliência, consistência eventual, implantação e operação.

---

## Resumo final

- **Perguntas apresentadas:** 91 a 100
- **Roteiro completo:** 100 perguntas
- **Nível principal:** Júnior
- **Temas finais abordados:**
  - API Gateway;
  - Service Mesh;
  - Service Discovery;
  - Mensageria;
  - Eventos e comandos;
  - Outbox Pattern;
  - Bulkhead;
  - Canary release;
  - Feature toggle;
  - Compatibilidade entre versões;
  - SLI, SLO e SLA;
  - Arquitetura integrada.

## Matriz final de competências

| Competência | Perguntas relacionadas | Indicadores de domínio |
|---|---:|---|
| Gateway e Service Mesh | 91 | Diferencia tráfego externo e comunicação interna |
| Identificação de instâncias | 92 | Compreende registro único e balanceamento |
| Eventos e comandos | 93 | Diferencia fatos ocorridos e solicitações |
| Publicação confiável | 94 | Conhece o Outbox Pattern e idempotência |
| Isolamento de recursos | 95 | Considera threads, conexões e pools |
| Implantação canário | 96 | Entende rollout gradual, métricas e rollback |
| Feature toggles | 97 | Controla ativações graduais com governança |
| Compatibilidade de versões | 98 | Preserva contratos durante coexistência |
| Confiabilidade | 99 | Diferencia SLI, SLO e SLA |
| Arquitetura integrada | 100 | Conecta Gateway, serviços, broker, segurança e resiliência |

## Recomendações finais para o entrevistador

- Avalie se o candidato consegue conectar os componentes em vez de apenas memorizar nomes.
- Explore como ele lidaria com falhas parciais e respostas ambíguas.
- Verifique se reconhece a importância da idempotência em operações críticas.
- Pergunte como ele evoluiria APIs, eventos e schemas sem quebrar consumidores.
- Observe se considera segurança, observabilidade e operação desde o início.
- Use a pergunta 100 como exercício final de arquitetura e peça justificativas para cada escolha.

## Recomendações finais para o candidato

- Explique primeiro o problema e depois escolha o componente.
- Diferencie claramente Gateway, Service Discovery e Service Mesh.
- Trate eventos como contratos que precisam evoluir com compatibilidade.
- Use Outbox e consumidores idempotentes quando houver publicação de eventos.
- Considere todos os recursos compartilhados ao aplicar Bulkhead.
- Faça implantações graduais com métricas e rollback.
- Remova feature toggles antigos para evitar complexidade permanente.
- Defina indicadores técnicos e funcionais para avaliar confiabilidade.
- Em qualquer arquitetura distribuída, considere segurança, falhas parciais, observabilidade e consistência eventual.
