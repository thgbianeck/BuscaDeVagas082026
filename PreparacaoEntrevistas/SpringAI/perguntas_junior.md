# Roteiro de Entrevista Técnica — Spring AI

> **Parte 1 de 10**  
> Esta parte contém as perguntas **1 a 10 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

> **Observação sobre versões:** o Spring AI evolui rapidamente. Classes, métodos, módulos, starters e comportamentos podem variar conforme a versão utilizada. Durante a entrevista, solicite ao candidato que informe a versão do Spring AI e do provedor de modelos considerada.

## Fluxo geral de uma aplicação Spring AI

~~~mermaid
flowchart LR
    A[Aplicação Spring Boot] --> B[ChatClient]
    B --> C[Prompt]
    C --> D[Modelo de linguagem]
    D --> E[Resposta]
    E --> F[Aplicação]
    F --> G[Logs e métricas]
~~~

---

## Pergunta 1 — Objetivo do Spring AI

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que é o Spring AI e qual problema ele procura resolver em uma aplicação baseada em Spring Boot?

**O que essa pergunta avalia:**  
Avalia se o candidato entende a finalidade do Spring AI, sua relação com o ecossistema Spring e o papel dos modelos de inteligência artificial generativa.

**Resposta esperada:**  
O Spring AI é um projeto do ecossistema Spring que fornece abstrações e integrações para incorporar recursos de inteligência artificial em aplicações Java e Spring Boot.

Ele permite trabalhar com modelos de linguagem, embeddings, bancos vetoriais, recuperação de documentos, geração aumentada por recuperação — RAG — e ferramentas que podem ser acionadas pelo modelo.

Seu objetivo não é criar um modelo de inteligência artificial do zero. Ele facilita o uso de modelos disponibilizados por provedores, como OpenAI, Azure OpenAI, Google, Anthropic, Ollama ou outros provedores compatíveis com a versão utilizada.

Uma das principais vantagens é reduzir o acoplamento direto entre a aplicação e a API específica de um provedor.

**Explicação didática:**  
Uma aplicação Java poderia chamar diretamente a API HTTP de um provedor de inteligência artificial. Nesse caso, o desenvolvedor precisaria controlar manualmente:

- Autenticação;
- Estrutura das requisições;
- Formato das mensagens;
- Serialização e desserialização;
- Tratamento de erros;
- Limites de uso;
- Diferenças entre provedores.

O Spring AI fornece componentes integrados ao Spring Boot, com configuração por propriedades, injeção de dependências e abstrações reutilizáveis.

Isso não significa que todos os provedores funcionem exatamente da mesma forma. Modelos diferentes podem ter capacidades, limites, custos, latência e formatos de resposta distintos.

**Exemplo prático:**  
Uma aplicação de atendimento pode receber uma pergunta de um usuário, encaminhá-la para um modelo de linguagem por meio do Spring AI e devolver a resposta ao cliente.

**Exemplo de código:**

~~~java
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping
    public String chat(@RequestParam String question) {
        return chatClient
                .prompt()
                .user(question)
                .call()
                .content();
    }
}
~~~

Nesse exemplo, o controlador recebe uma pergunta, cria uma solicitação e chama o modelo por meio do `ChatClient`. A configuração exata do cliente depende da versão do Spring AI e do provedor utilizado.

**Como o candidato deve responder:**  

- Definir o Spring AI como uma integração entre aplicações Spring e recursos de inteligência artificial;
- Explicar que ele utiliza modelos existentes;
- Mencionar que oferece abstrações para reduzir o acoplamento ao provedor;
- Citar pelo menos um recurso, como chat, embeddings, RAG ou ferramentas;
- Explicar que a configuração pode variar conforme a versão.

O candidato não precisa explicar detalhes matemáticos de redes neurais nesse nível.

**Resposta fraca ou incompleta:**  
“Spring AI é uma biblioteca para fazer perguntas ao ChatGPT.”

Essa resposta demonstra uma noção muito superficial. Ela não menciona a integração com Spring Boot, a existência de diferentes provedores, as abstrações disponíveis nem as limitações relacionadas a versões e modelos.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou apresenta informações incorretas.
- **1** — Sabe apenas que o Spring AI se relaciona com inteligência artificial.
- **2** — Explica que ele integra modelos a aplicações Java, mas não detalha seu propósito.
- **3** — Explica corretamente a integração com Spring Boot e modelos de linguagem.
- **4** — Menciona abstrações, provedores e recursos como embeddings ou RAG.
- **5** — Explica com clareza os benefícios, limites, diferenças entre provedores e impactos de versão.

**Perguntas de aprofundamento:**  

1. Por que uma aplicação poderia evitar chamar diretamente a API de um provedor?
2. Quais diferenças entre provedores ainda precisam ser consideradas mesmo usando o Spring AI?
3. Em quais situações o uso do Spring AI poderia ser desnecessário?

---

## Pergunta 2 — ChatClient

**Nível:** Júnior  
**Categoria:** Fundamentos e prática

**Pergunta do entrevistador:**  
Qual é o papel do `ChatClient` em uma aplicação Spring AI e como você o utilizaria para enviar uma pergunta a um modelo de linguagem?

**O que essa pergunta avalia:**  
Avalia o conhecimento do candidato sobre o componente usado para iniciar interações com modelos de chat e sua capacidade de construir uma chamada básica.

**Resposta esperada:**  
O `ChatClient` é uma API de alto nível usada para construir e executar solicitações destinadas a um modelo de chat.

Ele permite configurar diferentes partes da interação, como:

- Instruções do sistema;
- Mensagem do usuário;
- Parâmetros da chamada;
- Resposta esperada;
- Conversão para um tipo Java;
- Uso de ferramentas ou advisors, quando aplicável.

Uma chamada básica pode seguir esta estrutura:

~~~java
String response = chatClient
        .prompt()
        .user("Explique o que é injeção de dependências.")
        .call()
        .content();
~~~

O método `prompt()` inicia a construção da solicitação. O método `user()` define a mensagem do usuário. O método `call()` executa a chamada e `content()` obtém o conteúdo textual da resposta.

Os métodos disponíveis e a forma de configurar o cliente podem mudar entre versões.

**Explicação didática:**  
O `ChatClient` funciona como uma interface de comunicação entre a aplicação e o modelo.

Em vez de montar manualmente uma requisição HTTP, a aplicação utiliza uma API fluente. Uma API fluente permite encadear chamadas de forma legível, como:

~~~java
chatClient
    .prompt()
    .system("Você é um assistente de suporte.")
    .user("Como redefino minha senha?")
    .call()
    .content();
~~~

A mensagem do sistema define regras ou contexto geral. A mensagem do usuário contém a solicitação específica.

**Exemplo prático:**  
Um endpoint pode receber uma pergunta e enviá-la ao modelo:

~~~java
@GetMapping("/responder")
public ResponseEntity<String> responder(
        @RequestParam String pergunta) {

    String resposta = chatClient
            .prompt()
            .system("Responda de forma clara e objetiva.")
            .user(pergunta)
            .call()
            .content();

    return ResponseEntity.ok(resposta);
}
~~~

Em uma aplicação real, seria importante validar a entrada, tratar falhas externas, controlar tempo limite e evitar expor informações sensíveis.

**Como o candidato deve responder:**  

- Explicar que o `ChatClient` encapsula a interação com o modelo;
- Descrever a finalidade de `prompt()`, `user()`, `call()` e `content()`;
- Apresentar um exemplo simples;
- Mencionar que o método pode variar conforme a versão;
- Citar validação e tratamento de erros em um endpoint real.

**Resposta fraca ou incompleta:**  
“Eu uso o `ChatClient` para chamar o ChatGPT e pegar uma string.”

A resposta está parcialmente correta, mas não explica como o prompt é construído, quais mensagens podem ser definidas ou quais cuidados são necessários em produção.

**Critérios de avaliação:**  

- **0** — Não reconhece o `ChatClient` ou descreve seu funcionamento de forma incorreta.
- **1** — Sabe apenas que ele se relaciona a chamadas de IA.
- **2** — Entende que ele envia mensagens, mas não explica a cadeia de chamada.
- **3** — Explica corretamente uma chamada básica.
- **4** — Demonstra domínio de mensagens, validação e tratamento de falhas.
- **5** — Explica a API, as responsabilidades do cliente, limitações e cuidados de produção.

**Perguntas de aprofundamento:**  

1. Qual é a diferença entre uma mensagem `system` e uma mensagem `user`?
2. Como você trataria uma falha do provedor durante o método `call()`?
3. Como testaria um serviço que utiliza `ChatClient`?

---

## Pergunta 3 — Prompt, mensagem de sistema e mensagem de usuário

**Nível:** Júnior  
**Categoria:** Prompts e fundamentos

**Pergunta do entrevistador:**  
Qual é a diferença entre uma mensagem de sistema e uma mensagem de usuário em uma conversa com um modelo de linguagem?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende a organização básica de uma conversa e sabe separar instruções da aplicação da entrada fornecida pelo usuário.

**Resposta esperada:**  
A mensagem de sistema contém instruções gerais definidas pela aplicação. Ela pode estabelecer o comportamento esperado do assistente, o tom da resposta, as restrições e o contexto operacional.

A mensagem de usuário representa a solicitação ou pergunta enviada pelo usuário final.

Por exemplo:

~~~java
String resposta = chatClient
        .prompt()
        .system("""
                Você é um assistente de suporte técnico.
                Não invente informações.
                Se não souber a resposta, informe a limitação.
                """)
        .user("Minha aplicação está retornando erro 500.")
        .call()
        .content();
~~~

A mensagem de sistema não deve ser tratada como uma garantia absoluta de segurança. O modelo pode interpretar instruções de maneira imperfeita, e a aplicação deve implementar validações adicionais.

**Explicação didática:**  
A mensagem de sistema funciona como uma orientação inicial para o comportamento do modelo. A mensagem de usuário contém a tarefa atual.

Uma separação adequada ajuda a manter o código organizado:

- **Sistema:** regras e contexto controlados pela aplicação;
- **Usuário:** informação fornecida pelo usuário;
- **Assistente:** resposta produzida pelo modelo.

Mesmo assim, não se deve confiar somente no prompt para controlar autorização, segurança ou acesso a dados. Regras críticas devem ser verificadas pela aplicação.

**Exemplo prático:**  
Uma aplicação de recursos humanos pode instruir o modelo a resumir currículos, mas deve impedir que usuários não autorizados acessem currículos de outras pessoas.

**Como o candidato deve responder:**  

- Definir a função de cada tipo de mensagem;
- Diferenciar instruções permanentes de perguntas específicas;
- Demonstrar um exemplo;
- Explicar que prompts não substituem autenticação e autorização;
- Mencionar que dados do usuário precisam ser tratados com cuidado.

**Resposta fraca ou incompleta:**  
“A mensagem de sistema é a pergunta mais importante e a mensagem de usuário é a resposta.”

Essa resposta confunde os papéis das mensagens e demonstra que o candidato não compreende a estrutura de uma conversa.

**Critérios de avaliação:**  

- **0** — Confunde completamente os papéis.
- **1** — Demonstra apenas uma noção vaga de prompt.
- **2** — Identifica os dois tipos, mas não explica suas responsabilidades.
- **3** — Diferencia corretamente sistema e usuário.
- **4** — Apresenta exemplos e menciona validações adicionais.
- **5** — Explica a separação, seus limites, riscos de instruções maliciosas e controles necessários na aplicação.

**Perguntas de aprofundamento:**  

1. Por que autorização não deve ser implementada apenas no prompt?
2. Como você evitaria que uma entrada do usuário alterasse regras importantes da aplicação?
3. Que dados você não enviaria ao modelo sem anonimização ou autorização?

---

## Pergunta 4 — Configuração de um provedor de modelo

**Nível:** Júnior  
**Categoria:** Configuração e integração

**Pergunta do entrevistador:**  
Quais informações normalmente são necessárias para configurar um provedor de modelo em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia a capacidade do candidato de configurar uma integração externa e reconhecer requisitos básicos de segurança e operação.

**Resposta esperada:**  
Normalmente são necessárias informações como:

- Chave ou credencial de acesso;
- Identificador do modelo;
- URL do serviço, quando configurável;
- Parâmetros específicos do provedor;
- Limites de tempo;
- Configurações de temperatura ou quantidade máxima de tokens, quando suportadas;
- Dependências ou starters compatíveis com o provedor.

As credenciais não devem ser gravadas diretamente no código-fonte. Devem ser fornecidas por variáveis de ambiente, gerenciadores de segredos ou mecanismos equivalentes.

Um exemplo conceitual de configuração seria:

~~~yaml
spring:
  ai:
    provider:
      api-key: ${AI_API_KEY}
      chat:
        options:
          model: modelo-escolhido
          temperature: 0.2
~~~

O nome exato das propriedades depende do provedor e da versão do Spring AI.

**Explicação didática:**  
O Spring AI precisa saber para qual serviço enviar a solicitação e como autenticar a aplicação.

A chave de API identifica ou autoriza o cliente. O modelo determina qual recurso será utilizado. Parâmetros como temperatura podem influenciar a variabilidade das respostas.

Uma temperatura mais baixa geralmente favorece respostas mais previsíveis. Uma temperatura mais alta pode gerar respostas mais variadas, mas não garante maior qualidade.

**Exemplo prático:**  
Em desenvolvimento, a credencial pode vir de uma variável de ambiente. Em produção, pode ser disponibilizada por um serviço de gerenciamento de segredos.

Também é importante separar configurações por ambiente e evitar registrar a chave nos logs.

**Como o candidato deve responder:**  

- Citar credencial e modelo;
- Explicar que a configuração depende do provedor;
- Mostrar que sabe utilizar variáveis de ambiente;
- Mencionar que a chave não deve ser versionada;
- Reconhecer que propriedades podem mudar conforme a versão.

**Resposta fraca ou incompleta:**  
“Basta colocar a chave da API no arquivo `application.properties`.”

A resposta não considera o nome do modelo, o provedor, a segurança das credenciais nem a diferença entre ambientes.

**Critérios de avaliação:**  

- **0** — Não sabe como uma integração externa é configurada.
- **1** — Menciona apenas uma chave sem explicar sua finalidade.
- **2** — Cita chave e modelo, mas ignora segurança.
- **3** — Explica corretamente os elementos básicos.
- **4** — Demonstra preocupação com ambientes, segredos e parâmetros.
- **5** — Apresenta uma visão completa de configuração, segurança, versionamento e operação.

**Perguntas de aprofundamento:**  

1. Onde você armazenaria a chave em produção?
2. O que aconteceria se a chave fosse publicada acidentalmente em um repositório?
3. Como você configuraria provedores diferentes para desenvolvimento e produção?

---

## Pergunta 5 — Tratamento de erros em chamadas de IA

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Uma chamada ao modelo começa a retornar erros intermitentes. Como você investigaria e trataria esse problema?

**O que essa pergunta avalia:**  
Avalia raciocínio de diagnóstico, conhecimento de integrações externas e capacidade de propor medidas básicas de confiabilidade.

**Resposta esperada:**  
O candidato deve investigar inicialmente:

1. Mensagem e código do erro;
2. Logs da aplicação;
3. Tempo de resposta;
4. Disponibilidade do provedor;
5. Validade da credencial;
6. Limites de requisição;
7. Tamanho do prompt;
8. Modelo configurado;
9. Tempo limite da chamada;
10. Frequência e padrão das falhas.

Erros temporários, como indisponibilidade momentânea ou limite de requisições, podem permitir uma nova tentativa com atraso progressivo.

Porém, não se deve repetir indiscriminadamente uma requisição. É necessário limitar o número de tentativas, evitar sobrecarregar o provedor e diferenciar erros recuperáveis de erros permanentes.

**Explicação didática:**  
Uma integração externa pode falhar por diversos motivos. Um erro de autenticação não será resolvido simplesmente repetindo a chamada. Já uma falha temporária de rede pode desaparecer após alguns segundos.

Também é importante evitar que uma nova tentativa cause efeitos duplicados quando a operação não for idempotente. Idempotência significa que repetir uma operação não produz efeitos indevidos adicionais.

**Exemplo prático:**

~~~java
public String gerarResposta(String pergunta) {
    try {
        return chatClient
                .prompt()
                .user(pergunta)
                .call()
                .content();
    } catch (Exception exception) {
        log.error("Falha ao consultar o modelo", exception);
        throw new IllegalStateException(
                "Não foi possível obter uma resposta no momento.",
                exception
        );
    }
}
~~~

Em produção, o tratamento deve ser mais específico, utilizando exceções adequadas, limite de tempo, métricas, correlação de requisições e, quando apropriado, retentativas controladas.

**Como o candidato deve responder:**  

- Começar pela análise dos logs e códigos de erro;
- Verificar credencial, modelo, limites e disponibilidade;
- Diferenciar falhas temporárias de falhas permanentes;
- Propor retentativas com limite e atraso;
- Explicar que o usuário não deve receber detalhes sensíveis da exceção;
- Mencionar monitoramento.

**Resposta fraca ou incompleta:**  
“Eu colocaria um `try-catch` e tentaria novamente até funcionar.”

Essa solução pode gerar tempestade de requisições, aumentar custos, esconder a causa do problema e piorar uma indisponibilidade.

**Critérios de avaliação:**  

- **0** — Não apresenta estratégia de investigação.
- **1** — Sugere apenas reiniciar a aplicação.
- **2** — Menciona `try-catch`, mas não diferencia os tipos de falha.
- **3** — Propõe análise de logs e tratamento básico.
- **4** — Inclui retentativas controladas, limites e observabilidade.
- **5** — Demonstra compreensão de confiabilidade, idempotência, degradação e impacto operacional.

**Perguntas de aprofundamento:**  

1. Quais erros você considera recuperáveis?
2. Como impediria que muitas retentativas aumentassem o problema?
3. Que métricas você acompanharia para confirmar a causa?

---

## Pergunta 6 — Tokens e tamanho do contexto

**Nível:** Júnior  
**Categoria:** Fundamentos e desempenho

**Pergunta do entrevistador:**  
O que são tokens em um modelo de linguagem e por que o tamanho do contexto é importante em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia o entendimento básico sobre limites de entrada e saída e sua relação com custo, desempenho e funcionamento da aplicação.

**Resposta esperada:**  
Tokens são unidades usadas pelo modelo para processar texto. Um token pode representar uma palavra inteira, parte de uma palavra, pontuação ou outro fragmento.

O modelo possui um limite de contexto, que representa a quantidade máxima de tokens que pode considerar em uma solicitação, incluindo mensagens anteriores, instruções, documentos enviados e a resposta produzida.

Quando o contexto é grande demais, a chamada pode falhar, ficar mais lenta ou aumentar o custo. Por isso, a aplicação pode precisar:

- Resumir conversas antigas;
- Limitar o histórico;
- Dividir documentos;
- Recuperar apenas trechos relevantes;
- Reduzir instruções repetitivas;
- Definir um limite para a resposta.

**Explicação didática:**  
O modelo não recebe necessariamente um texto como uma pessoa leria. Ele transforma o texto em unidades internas chamadas tokens.

Por exemplo, uma conversa longa pode consumir muitos tokens mesmo que pareça apenas um conjunto de mensagens. Em aplicações com histórico, cada nova mensagem pode incluir parte do conteúdo anterior.

O tamanho do contexto precisa ser controlado para evitar custos e falhas inesperadas.

**Exemplo prático:**  
Em um chatbot, em vez de enviar toda a conversa desde o primeiro contato, a aplicação pode manter um resumo das mensagens antigas e preservar apenas as interações mais recentes.

**Como o candidato deve responder:**  

- Explicar tokens como unidades de processamento;
- Relacioná-los ao limite de contexto;
- Mencionar impacto em custo, latência e erros;
- Sugerir resumo, truncamento ou recuperação seletiva;
- Evitar afirmar que um token é sempre exatamente uma palavra.

**Resposta fraca ou incompleta:**  
“Token é cada palavra enviada ao modelo.”

Essa definição é imprecisa. Tokens podem ser partes de palavras, pontuação ou outros fragmentos, e o consumo depende do modelo e da forma como o texto é tokenizado.

**Critérios de avaliação:**  

- **0** — Não sabe explicar ou apresenta definição incorreta.
- **1** — Confunde tokens com caracteres ou mensagens.
- **2** — Entende que existe um limite, mas não explica seus impactos.
- **3** — Explica tokens e contexto de forma correta.
- **4** — Relaciona o tema a custos, latência e estratégias de redução.
- **5** — Demonstra visão aplicada sobre histórico, documentos, limites e experiência do usuário.

**Perguntas de aprofundamento:**  

1. Como você controlaria o histórico de uma conversa longa?
2. O que faria se documentos grandes precisassem ser consultados?
3. Como verificaria se uma falha está relacionada ao tamanho do contexto?

---

## Pergunta 7 — Respostas estruturadas

**Nível:** Júnior  
**Categoria:** Integração e boas práticas

**Pergunta do entrevistador:**  
Quando seria melhor solicitar ao modelo uma resposta estruturada em vez de receber apenas texto livre?

**O que essa pergunta avalia:**  
Avalia se o candidato sabe distinguir texto destinado à leitura humana de dados que serão processados pela aplicação.

**Resposta esperada:**  
Uma resposta estruturada é adequada quando a aplicação precisa utilizar os dados programaticamente.

Exemplos:

- Classificar uma solicitação;
- Extrair campos de uma nota fiscal;
- Identificar sentimento;
- Produzir uma lista de itens;
- Retornar dados para uma tela;
- Encaminhar uma solicitação para um fluxo específico.

Em vez de depender da interpretação de um texto livre, a aplicação pode solicitar uma estrutura compatível com um objeto Java ou um formato como JSON, quando suportado pelo provedor e pela versão utilizada.

Mesmo assim, a aplicação deve validar a resposta. O modelo pode produzir dados incompletos, inválidos ou inconsistentes.

**Explicação didática:**  
Texto livre é útil quando o resultado será lido diretamente por uma pessoa. Porém, se o sistema precisa extrair dados, é melhor trabalhar com uma estrutura previsível.

Por exemplo, uma aplicação pode desejar:

~~~json
{
  "categoria": "SUPORTE",
  "prioridade": "ALTA",
  "resumo": "Usuário não consegue acessar a conta"
}
~~~

Esse formato facilita o processamento, mas não elimina a necessidade de validação. A aplicação deve verificar campos obrigatórios, valores permitidos e tamanho dos textos.

**Exemplo prático:**

~~~java
public record Classificacao(
        String categoria,
        String prioridade,
        String resumo
) {}
~~~

A aplicação pode solicitar que a resposta seja convertida para essa estrutura, desde que o recurso esteja disponível e configurado corretamente na versão utilizada.

**Como o candidato deve responder:**  

- Explicar que respostas estruturadas são úteis para processamento automático;
- Dar um exemplo de classificação ou extração;
- Mencionar validação do resultado;
- Reconhecer que o suporte depende do modelo e do provedor;
- Explicar que JSON gerado pelo modelo não deve ser considerado automaticamente confiável.

**Resposta fraca ou incompleta:**  
“Eu sempre pediria JSON porque é mais profissional.”

A estrutura pode ser útil, mas não é adequada para todos os casos. Também é necessário validar o conteúdo e considerar o suporte real do provedor.

**Critérios de avaliação:**  

- **0** — Não diferencia texto livre de resposta estruturada.
- **1** — Acredita que JSON sempre é necessário.
- **2** — Entende a ideia, mas não menciona validação.
- **3** — Explica corretamente quando usar estrutura.
- **4** — Relaciona estrutura a objetos, validação e integração.
- **5** — Discute confiabilidade, compatibilidade, tratamento de respostas inválidas e trade-offs.

**Perguntas de aprofundamento:**  

1. O que faria se o modelo retornasse JSON inválido?
2. Como validaria os campos recebidos?
3. Quando uma resposta textual seria mais adequada que uma resposta estruturada?

---

## Pergunta 8 — Embeddings

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
O que são embeddings e em que tipo de problema eles podem ser utilizados com Spring AI?

**O que essa pergunta avalia:**  
Avalia a compreensão inicial de representações vetoriais e sua aplicação em busca semântica e recuperação de informações.

**Resposta esperada:**  
Embeddings são representações numéricas de textos, imagens ou outros dados. Eles transformam o conteúdo em vetores que procuram preservar relações de significado.

Textos com significado semelhante tendem a produzir vetores próximos em um espaço matemático, de acordo com o modelo utilizado.

No Spring AI, embeddings podem ser usados para:

- Busca semântica;
- Recuperação de documentos;
- Sistemas RAG;
- Recomendação;
- Agrupamento de conteúdos;
- Identificação de informações semelhantes.

Em uma aplicação RAG, os documentos são divididos em trechos, transformados em embeddings e armazenados em um banco vetorial. Quando o usuário faz uma pergunta, ela também é transformada em embedding, e o sistema busca trechos semanticamente próximos.

**Explicação didática:**  
Uma busca tradicional procura correspondência de palavras. Uma busca semântica procura proximidade de significado.

Por exemplo, uma pergunta contendo “não consigo entrar na minha conta” pode encontrar um documento que utiliza a expressão “problemas de autenticação”, mesmo sem repetir exatamente as mesmas palavras.

Os embeddings não são respostas prontas. Eles são representações usadas para encontrar informações relacionadas.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Documento] --> B[Dividir em trechos]
    B --> C[Gerar embeddings]
    C --> D[Armazenar no banco vetorial]

    E[Pergunta do usuário] --> F[Gerar embedding da pergunta]
    F --> G[Buscar trechos semelhantes]
    D --> G
    G --> H[Montar contexto]
    H --> I[Enviar ao modelo]
    I --> J[Gerar resposta]
~~~

**Como o candidato deve responder:**  

- Definir embeddings como vetores que representam significado;
- Diferenciar embedding de resposta gerada;
- Citar busca semântica ou RAG;
- Explicar que documentos e perguntas podem ser comparados;
- Mencionar que a qualidade depende do modelo, dos dados e da divisão dos documentos.

**Resposta fraca ou incompleta:**  
“Embedding é a resposta que a inteligência artificial dá para o usuário.”

Essa resposta confunde representação vetorial com geração de texto.

**Critérios de avaliação:**  

- **0** — Não sabe responder ou confunde embeddings com prompts.
- **1** — Reconhece apenas que o tema está relacionado a vetores.
- **2** — Explica parcialmente a ideia, mas não apresenta aplicação.
- **3** — Define embeddings e relaciona-os à busca semântica.
- **4** — Explica o uso em RAG e bancos vetoriais.
- **5** — Discute similaridade, chunking, qualidade dos dados, modelo de embedding e limitações práticas.

**Perguntas de aprofundamento:**  

1. Qual é a diferença entre uma busca por palavra-chave e uma busca semântica?
2. Por que um documento costuma ser dividido em trechos antes de gerar embeddings?
3. Que problemas podem ocorrer se o modelo de embedding for trocado depois da indexação?

---

## Pergunta 9 — RAG

**Nível:** Júnior  
**Categoria:** Arquitetura e prática

**Pergunta do entrevistador:**  
O que é RAG e por que ele pode ser útil em uma aplicação Spring AI que precisa responder com base em documentos internos?

**O que essa pergunta avalia:**  
Avalia o entendimento de um fluxo comum de aplicações com modelos de linguagem e a capacidade de explicar recuperação de dados externos ao modelo.

**Resposta esperada:**  
RAG significa Retrieval-Augmented Generation, ou geração aumentada por recuperação.

Nesse padrão, a aplicação:

1. Recebe a pergunta do usuário;
2. Procura informações relevantes em uma fonte de dados;
3. Inclui os trechos encontrados no contexto da solicitação;
4. Envia a pergunta e o contexto ao modelo;
5. Gera uma resposta baseada nas informações recuperadas.

O RAG é útil quando o modelo precisa responder com base em documentos internos, dados recentes ou informações específicas da organização que não fazem parte do treinamento geral do modelo.

Ele pode reduzir respostas sem fundamento, mas não elimina completamente o risco de erro. A aplicação deve controlar a qualidade da recuperação, o acesso aos documentos e a forma como o modelo utiliza o contexto.

**Explicação didática:**  
Um modelo de linguagem pode não conhecer a política interna de uma empresa ou pode estar desatualizado sobre determinado conteúdo.

Com RAG, os documentos relevantes são recuperados no momento da pergunta. O modelo recebe esses trechos como contexto e gera uma resposta apoiada nessas informações.

O RAG não é o mesmo que treinar novamente o modelo. Ele adiciona informações à solicitação sem alterar os parâmetros internos do modelo.

**Exemplo prático:**  
Em um sistema de suporte interno, documentos sobre férias, benefícios e políticas corporativas podem ser indexados. Quando um colaborador pergunta sobre férias, o sistema recupera os trechos relacionados antes de gerar a resposta.

**Como o candidato deve responder:**  

- Expandir a sigla RAG;
- Explicar recuperação, montagem de contexto e geração;
- Citar documentos internos ou dados atualizados;
- Diferenciar RAG de treinamento do modelo;
- Mencionar riscos de documentos irrelevantes, acesso indevido e respostas incorretas.

**Resposta fraca ou incompleta:**  
“RAG é treinar o modelo com os documentos da empresa.”

Essa resposta confunde recuperação de conteúdo com treinamento ou ajuste do modelo.

**Critérios de avaliação:**  

- **0** — Não sabe explicar RAG.
- **1** — Sabe apenas que RAG se relaciona a documentos.
- **2** — Entende que documentos são enviados ao modelo, mas não explica recuperação.
- **3** — Explica corretamente o fluxo básico.
- **4** — Relaciona RAG a embeddings, banco vetorial e dados internos.
- **5** — Discute qualidade da recuperação, segurança, rastreabilidade, limites de contexto e riscos de respostas incorretas.

**Perguntas de aprofundamento:**  

1. Como você avaliaria se os trechos recuperados são relevantes?
2. Como evitaria que um usuário acessasse documentos sem autorização?
3. O que faria se a busca não encontrasse nenhum trecho relevante?

---

## Pergunta 10 — Segurança e dados sensíveis

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Quais cuidados de segurança você teria ao enviar dados de usuários para um modelo de linguagem por meio do Spring AI?

**O que essa pergunta avalia:**  
Avalia a consciência do candidato sobre privacidade, exposição de informações, controle de acesso e riscos específicos de integrações com modelos.

**Resposta esperada:**  
O candidato deve considerar:

- Não enviar dados sensíveis sem necessidade;
- Remover ou mascarar informações pessoais;
- Validar autorização antes de recuperar documentos;
- Proteger chaves de API;
- Evitar registrar prompts e respostas sensíveis nos logs;
- Definir políticas de retenção;
- Verificar os termos e as políticas do provedor;
- Validar entradas e saídas;
- Limitar o conteúdo que pode ser enviado;
- Monitorar usos abusivos.

Também é importante lembrar que instruções fornecidas pelo usuário podem tentar manipular o comportamento do sistema. Esse tipo de ataque é frequentemente chamado de prompt injection.

Controles de segurança não devem depender somente do prompt. A aplicação deve implementar autenticação, autorização, filtragem e validações independentemente do modelo.

**Explicação didática:**  
Um prompt pode conter CPF, dados médicos, informações financeiras, credenciais ou documentos internos. Se esses dados forem enviados sem controle, podem ocorrer violações de privacidade ou exposição indevida.

Além disso, um modelo pode reproduzir informações confidenciais na resposta. Por isso, a aplicação deve controlar:

- O que entra no prompt;
- Quais documentos podem ser recuperados;
- Quem pode fazer cada pergunta;
- O que pode sair na resposta;
- O que será armazenado em logs.

**Exemplo prático:**  
Antes de enviar uma mensagem ao modelo, a aplicação pode substituir um CPF por um identificador interno:

~~~java
public String mascararCpf(String texto) {
    return texto.replaceAll(
            "\\b\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}\\b",
            "[CPF_REDACTED]"
    );
}
~~~

Esse exemplo é apenas uma proteção inicial. Em uma aplicação real, a solução deve considerar diferentes formatos, validação, falsos positivos e outros tipos de informação sensível.

**Como o candidato deve responder:**  

- Falar sobre proteção de credenciais;
- Mencionar dados pessoais e informações confidenciais;
- Explicar mascaramento ou minimização de dados;
- Ressaltar autenticação e autorização;
- Mencionar logs, retenção e políticas do provedor;
- Explicar que o prompt sozinho não é um mecanismo de segurança.

**Resposta fraca ou incompleta:**  
“Eu colocaria no prompt que o modelo não pode divulgar informações.”

Essa medida pode fazer parte da estratégia, mas não substitui controles técnicos na aplicação.

**Critérios de avaliação:**  

- **0** — Não identifica riscos de segurança.
- **1** — Menciona apenas esconder a chave da API.
- **2** — Reconhece dados sensíveis, mas não propõe controles.
- **3** — Apresenta cuidados básicos de privacidade e credenciais.
- **4** — Inclui autorização, mascaramento, logs e validação.
- **5** — Demonstra visão completa sobre minimização, prompt injection, governança, auditoria, retenção e defesa em camadas.

**Perguntas de aprofundamento:**  

1. Como impediria que um usuário consultasse documentos de outro departamento?
2. Que informações você evitaria registrar nos logs?
3. Como trataria uma entrada tentando ignorar as regras do sistema?

---

## Resumo desta parte

- **Perguntas apresentadas:** 1 a 10
- **Perguntas restantes:** 11 a 100
- **Categorias abordadas:** fundamentos, prática, configuração, troubleshooting, prompts, desempenho, embeddings, arquitetura e segurança
- **Competências avaliadas:** compreensão do Spring AI, uso básico do `ChatClient`, integração com provedores, tratamento inicial de falhas, uso de embeddings e RAG, controle de contexto e cuidados de segurança

A próxima parte deve continuar com as perguntas **11 a 20**, mantendo a mesma estrutura e a numeração sequencial.

---

# Roteiro de Entrevista Técnica — Spring AI

> **Parte 2 de 10**  
> Esta parte contém as perguntas **11 a 20 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

---

## Pergunta 11 — Mensagens e histórico de conversa

**Nível:** Júnior  
**Categoria:** Fundamentos e prática

**Pergunta do entrevistador:**  
Como você representaria uma conversa com várias mensagens em uma aplicação Spring AI e por que o histórico é importante?

**O que essa pergunta avalia:**  
Avalia se o candidato entende que uma conversa com um modelo de linguagem pode conter diferentes papéis e que o modelo, em geral, não mantém automaticamente o histórico entre requisições independentes.

**Resposta esperada:**  
Uma conversa pode ser representada por uma sequência de mensagens, normalmente associadas a papéis como:

- **System:** define instruções gerais da aplicação;
- **User:** representa uma solicitação feita pelo usuário;
- **Assistant:** representa uma resposta produzida pelo modelo.

O histórico é importante porque uma chamada isolada normalmente não conhece as mensagens enviadas em chamadas anteriores. Para manter continuidade, a aplicação precisa armazenar e reenviar parte do histórico, ou utilizar mecanismos de memória e gerenciamento de contexto disponíveis na versão adotada.

A aplicação também precisa limitar o tamanho do histórico para evitar excesso de tokens, aumento de custo, maior latência e estouro do limite de contexto.

**Explicação didática:**  
Se o usuário perguntar:

1. “Qual é a política de férias?”
2. “E para estagiários?”

A segunda pergunta pode depender da primeira. Sem histórico, o modelo talvez não saiba a que o termo “estagiários” se refere.

Um fluxo simplificado seria:

~~~mermaid
sequenceDiagram
    participant U as Usuário
    participant A as Aplicação
    participant M as Modelo

    U->>A: Envia pergunta
    A->>A: Recupera histórico
    A->>M: Envia histórico + nova pergunta
    M-->>A: Retorna resposta
    A->>A: Armazena interação
    A-->>U: Exibe resposta
~~~

O histórico pode ser armazenado em memória, banco de dados, cache ou outro mecanismo adequado. A escolha depende da necessidade de persistência, escalabilidade e privacidade.

**Exemplo prático:**  
Uma aplicação de suporte pode guardar as últimas mensagens de cada conversa identificada por um `conversationId`.

O sistema não precisa reenviar necessariamente toda a conversa. Pode manter as mensagens recentes e um resumo das mensagens antigas.

**Exemplo de código:**

~~~java
public record ChatMessage(
        String role,
        String content
) {}
~~~

Uma aplicação pode recuperar essas mensagens e utilizá-las na construção do prompt. A forma exata de converter objetos para mensagens do Spring AI depende da versão utilizada.

**Como o candidato deve responder:**  

- Explicar os papéis das mensagens;
- Informar que o histórico precisa ser gerenciado pela aplicação;
- Mencionar armazenamento e identificação da conversa;
- Explicar o problema do crescimento ilimitado do histórico;
- Citar resumo ou limitação de mensagens como alternativas;
- Demonstrar preocupação com privacidade e custo.

**Resposta fraca ou incompleta:**  
“O modelo lembra automaticamente tudo que o usuário falou.”

Essa resposta ignora que a aplicação precisa enviar o contexto necessário e que o histórico pode exigir armazenamento e gerenciamento.

**Critérios de avaliação:**  

- **0** — Não entende o conceito de histórico.
- **1** — Acredita que o modelo sempre mantém a conversa automaticamente.
- **2** — Sabe que mensagens anteriores podem ser necessárias, mas não explica como gerenciá-las.
- **3** — Explica corretamente o uso do histórico.
- **4** — Considera persistência, limite de contexto e resumo.
- **5** — Discute histórico, privacidade, escalabilidade, custo, consistência e estratégias de memória.

**Perguntas de aprofundamento:**  

1. Como você evitaria que o histórico crescesse indefinidamente?
2. Onde armazenaria o histórico em uma aplicação com várias instâncias?
3. Que cuidados teria para impedir que um usuário acessasse a conversa de outra pessoa?

---

## Pergunta 12 — Diferença entre modelo de chat e modelo de embedding

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Qual é a diferença entre um modelo de chat e um modelo de embedding, e quando você usaria cada um em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato consegue diferenciar geração de texto de representação vetorial e escolher o componente adequado para cada tipo de problema.

**Resposta esperada:**  
Um modelo de chat é utilizado para interagir com mensagens e gerar respostas, resumos, explicações, classificações ou outros conteúdos.

Um modelo de embedding transforma um conteúdo, como um texto, em um vetor numérico. Esse vetor pode ser utilizado para calcular similaridade e realizar busca semântica.

Exemplos:

- **Modelo de chat:** responder a uma dúvida de um cliente;
- **Modelo de embedding:** encontrar documentos relacionados à dúvida do cliente;
- **Uso combinado:** recuperar documentos com embeddings e gerar uma resposta com um modelo de chat.

**Explicação didática:**  
Os dois modelos têm finalidades diferentes.

O modelo de chat recebe instruções e produz uma saída geralmente textual. Já o modelo de embedding não tem como finalidade responder ao usuário. Ele gera uma representação numérica do significado do conteúdo.

Um fluxo de RAG pode combinar os dois:

~~~mermaid
flowchart LR
    A[Pergunta do usuário] --> B[Modelo de embedding]
    B --> C[Busca por similaridade]
    C --> D[Trechos relevantes]
    D --> E[Modelo de chat]
    A --> E
    E --> F[Resposta final]
~~~

É importante verificar se o modelo e o banco vetorial são compatíveis com a dimensão dos vetores produzidos.

**Exemplo prático:**  
Para responder perguntas sobre manuais internos:

1. Os documentos são convertidos em embeddings;
2. Os vetores são armazenados;
3. A pergunta do usuário também é convertida em embedding;
4. Os documentos mais próximos são recuperados;
5. O modelo de chat utiliza os trechos como contexto.

**Como o candidato deve responder:**  

- Definir corretamente os dois tipos de modelo;
- Explicar que chat gera conteúdo e embedding representa conteúdo;
- Apresentar um caso de uso para cada um;
- Mostrar como ambos podem trabalhar juntos em RAG;
- Mencionar compatibilidade entre embeddings e banco vetorial.

**Resposta fraca ou incompleta:**  
“Os dois modelos fazem a mesma coisa, mas um é mais rápido.”

Essa resposta não diferencia geração de texto e representação vetorial.

**Critérios de avaliação:**  

- **0** — Confunde completamente os dois conceitos.
- **1** — Reconhece que existem modelos diferentes, mas não explica suas funções.
- **2** — Explica parcialmente um dos modelos.
- **3** — Diferencia corretamente chat e embedding.
- **4** — Demonstra como utilizá-los em um fluxo RAG.
- **5** — Explica compatibilidade, similaridade, custos, qualidade e limitações de cada abordagem.

**Perguntas de aprofundamento:**  

1. Você usaria um modelo de chat para realizar busca semântica? Por quê?
2. O que aconteceria se os documentos fossem indexados com um modelo de embedding e as consultas com outro incompatível?
3. Como avaliaria a qualidade dos resultados recuperados?

---

## Pergunta 13 — Temperatura e parâmetros do modelo

**Nível:** Júnior  
**Categoria:** Configuração e fundamentos

**Pergunta do entrevistador:**  
O que é a temperatura de um modelo de linguagem e como você escolheria esse parâmetro para diferentes tipos de aplicação?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende que parâmetros de geração influenciam o comportamento do modelo e sabe relacioná-los ao objetivo da aplicação.

**Resposta esperada:**  
A temperatura é um parâmetro que influencia a aleatoriedade ou variabilidade da geração do modelo.

Em termos gerais:

- Temperatura mais baixa tende a produzir respostas mais previsíveis e consistentes;
- Temperatura mais alta tende a produzir respostas mais variadas e criativas.

Para uma aplicação de classificação, extração de dados ou resposta baseada em regras, uma temperatura mais baixa pode ser adequada.

Para brainstorming, criação de ideias ou geração de textos criativos, uma temperatura mais alta pode ser considerada.

A temperatura não garante que uma resposta seja correta. Uma temperatura baixa pode produzir uma resposta incorreta, apenas de maneira mais previsível.

**Explicação didática:**  
O parâmetro não controla diretamente o conhecimento do modelo. Ele influencia como o modelo escolhe entre possibilidades de continuação.

Por exemplo:

- Um classificador de chamados pode precisar de respostas estáveis;
- Um assistente de criação de slogans pode se beneficiar de maior variedade;
- Um sistema jurídico ou financeiro deve priorizar validação, fontes e controles adicionais, independentemente da temperatura.

Outros parâmetros também podem existir, como limite de tokens de saída, penalidades e configurações específicas do provedor. Os nomes e comportamentos dependem da versão e do modelo.

**Exemplo prático:**  
Uma aplicação poderia utilizar configurações diferentes:

~~~java
// Exemplo conceitual: os nomes das opções dependem do provedor.
ChatOptions options = ChatOptions.builder()
        .temperature(0.2)
        .build();
~~~

O valor escolhido deve ser validado por testes e observação do comportamento real, não apenas por uma regra fixa.

**Como o candidato deve responder:**  

- Definir temperatura como parâmetro relacionado à variabilidade;
- Explicar a diferença entre valores baixos e altos;
- Dar exemplos de aplicações determinísticas e criativas;
- Ressaltar que temperatura não garante precisão;
- Mencionar que outros parâmetros e comportamentos dependem do provedor.

**Resposta fraca ou incompleta:**  
“Temperatura alta deixa o modelo mais inteligente.”

Essa afirmação é incorreta. A temperatura altera a variabilidade da geração, não aumenta automaticamente a inteligência ou a veracidade da resposta.

**Critérios de avaliação:**  

- **0** — Não sabe explicar o parâmetro.
- **1** — Apresenta uma definição incorreta.
- **2** — Entende que a temperatura altera a resposta, mas não explica como.
- **3** — Diferencia adequadamente temperaturas baixas e altas.
- **4** — Relaciona o parâmetro a casos de uso e testes.
- **5** — Discute previsibilidade, qualidade, limites, validação e diferenças entre provedores.

**Perguntas de aprofundamento:**  

1. Que temperatura escolheria para classificar chamados de suporte?
2. Por que temperatura baixa não garante uma resposta verdadeira?
3. Como você testaria se uma configuração de temperatura é adequada?

---

## Pergunta 14 — Streaming de respostas

**Nível:** Júnior  
**Categoria:** Prática e integração

**Pergunta do entrevistador:**  
Qual é a diferença entre retornar uma resposta completa e utilizar streaming em uma aplicação que conversa com um modelo de linguagem?

**O que essa pergunta avalia:**  
Avalia se o candidato entende diferentes formas de entrega da resposta e os impactos na experiência do usuário e na implementação.

**Resposta esperada:**  
Em uma resposta completa, a aplicação espera o modelo terminar a geração e só então devolve todo o conteúdo ao cliente.

No streaming, a aplicação recebe partes da resposta à medida que são geradas e pode encaminhá-las progressivamente ao usuário.

O streaming pode melhorar a percepção de velocidade, pois o usuário começa a visualizar a resposta antes de ela estar totalmente pronta. Porém, ele exige cuidados adicionais:

- Gerenciamento de conexões abertas;
- Cancelamento;
- Tratamento de falhas durante a transmissão;
- Controle de buffers;
- Compatibilidade com o cliente;
- Monitoramento de respostas incompletas;
- Segurança para não transmitir dados indevidos.

**Explicação didática:**  
Sem streaming:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant A as Aplicação
    participant M as Modelo

    C->>A: Envia pergunta
    A->>M: Solicita resposta
    M-->>A: Resposta completa
    A-->>C: Exibe resposta
~~~

Com streaming:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant A as Aplicação
    participant M as Modelo

    C->>A: Envia pergunta
    A->>M: Solicita resposta
    M-->>A: Primeiro trecho
    A-->>C: Envia trecho
    M-->>A: Próximo trecho
    A-->>C: Envia trecho
    M-->>A: Finalização
    A-->>C: Encerra transmissão
~~~

O streaming não significa necessariamente que a resposta será mais rápida para ser totalmente concluída. Ele apenas permite que partes sejam exibidas antes.

**Exemplo prático:**  
Um chatbot pode mostrar a resposta gradualmente, enquanto um serviço de integração com outro sistema pode preferir receber o conteúdo completo para validar o resultado antes de processá-lo.

**Como o candidato deve responder:**  

- Explicar a diferença entre resposta completa e incremental;
- Citar o benefício de melhorar a percepção de latência;
- Mencionar conexão, cancelamento e falhas;
- Explicar que streaming não elimina o tempo total de geração;
- Relacionar a escolha ao tipo de cliente e ao caso de uso.

**Resposta fraca ou incompleta:**  
“Streaming faz o modelo responder instantaneamente.”

Essa resposta exagera o benefício e ignora que a geração ainda possui tempo total, além de exigir cuidados de transmissão.

**Critérios de avaliação:**  

- **0** — Não sabe diferenciar as abordagens.
- **1** — Acredita que streaming elimina a latência.
- **2** — Entende que a resposta chega em partes, mas ignora impactos.
- **3** — Explica corretamente a diferença.
- **4** — Considera experiência do usuário, conexões e falhas.
- **5** — Discute cancelamento, backpressure, observabilidade, segurança e adequação ao caso de uso.

**Perguntas de aprofundamento:**  

1. Em que situação você preferiria uma resposta completa?
2. Como trataria uma falha ocorrida no meio do streaming?
3. Como permitiria que o usuário cancelasse uma geração longa?

---

## Pergunta 15 — Injeção de dependências e configuração do ChatClient

**Nível:** Júnior  
**Categoria:** Spring e prática

**Pergunta do entrevistador:**  
Como você disponibilizaria um `ChatClient` em um serviço Spring e por que a injeção de dependências é útil nesse caso?

**O que essa pergunta avalia:**  
Avalia a compreensão básica dos princípios do Spring e a capacidade de separar a lógica de negócio da criação e configuração de dependências externas.

**Resposta esperada:**  
O `ChatClient` pode ser disponibilizado como um bean gerenciado pelo Spring e injetado em uma classe de serviço por meio do construtor.

A injeção por construtor é útil porque:

- Deixa as dependências explícitas;
- Facilita testes;
- Evita criação manual dentro dos métodos;
- Permite centralizar configurações;
- Reduz o acoplamento entre a lógica de negócio e a infraestrutura.

Um exemplo conceitual seria:

~~~java
@Service
public class AssistenteService {

    private final ChatClient chatClient;

    public AssistenteService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String responder(String pergunta) {
        return chatClient
                .prompt()
                .user(pergunta)
                .call()
                .content();
    }
}
~~~

A forma de criação do bean pode variar conforme o starter, o provedor e a versão do Spring AI.

**Explicação didática:**  
Sem injeção de dependências, a classe poderia criar o cliente manualmente em cada chamada. Isso dificultaria trocar o provedor, alterar configurações ou substituir o cliente por um mock durante os testes.

Com o Spring, a infraestrutura pode ser configurada em um local apropriado, enquanto o serviço se concentra na regra de negócio.

Também pode ser necessário criar diferentes clientes com configurações distintas, por exemplo, um para respostas rápidas e outro para geração mais elaborada. Nesse caso, qualificadores e configuração explícita podem ser necessários.

**Exemplo prático:**  
Em um teste unitário, o `ChatClient` poderia ser substituído por um dublê que retorna uma resposta conhecida. Assim, o teste não dependeria de uma chamada real a um provedor externo.

**Como o candidato deve responder:**  

- Explicar o conceito de bean;
- Mostrar preferência por injeção via construtor;
- Separar configuração e lógica de negócio;
- Mencionar testabilidade;
- Reconhecer que a configuração depende da versão;
- Evitar criar clientes diretamente dentro de cada método.

**Resposta fraca ou incompleta:**  
“Eu criaria um novo `ChatClient` dentro do controller sempre que precisasse.”

Essa abordagem mistura responsabilidades, dificulta testes e pode criar configurações duplicadas ou clientes desnecessários.

**Critérios de avaliação:**  

- **0** — Não entende injeção de dependências.
- **1** — Conhece apenas a anotação `@Autowired`, sem compreender o propósito.
- **2** — Sabe injetar uma dependência, mas não explica as vantagens.
- **3** — Usa injeção por construtor corretamente.
- **4** — Relaciona o padrão à testabilidade e à separação de responsabilidades.
- **5** — Discute múltiplos clientes, configuração, ciclo de vida, acoplamento e testes isolados.

**Perguntas de aprofundamento:**  

1. Como testaria o serviço sem chamar o provedor real?
2. Por que o construtor costuma ser preferível à injeção diretamente em atributos?
3. Como configuraria dois clientes com modelos diferentes?

---

## Pergunta 16 — Testes de uma integração com modelo

**Nível:** Júnior  
**Categoria:** Testes

**Pergunta do entrevistador:**  
Como você testaria um serviço que utiliza Spring AI sem depender de uma chamada real ao provedor em todos os testes?

**O que essa pergunta avalia:**  
Avalia conhecimento de testes unitários, isolamento de dependências externas e compreensão dos diferentes níveis de teste.

**Resposta esperada:**  
Em testes unitários, o candidato pode substituir o cliente ou serviço responsável pela chamada ao modelo por um mock, stub ou outro dublê de teste.

O teste deve verificar o comportamento da aplicação, por exemplo:

- Se o prompt foi construído corretamente;
- Se a entrada foi validada;
- Se a resposta foi convertida;
- Se erros foram tratados;
- Se o serviço reage adequadamente a uma resposta vazia ou inválida.

Também podem existir testes de integração que utilizam um provedor real ou um ambiente controlado. Esses testes devem ser menos frequentes, possuir credenciais seguras e controlar custo e instabilidade.

**Explicação didática:**  
Um teste unitário deve ser rápido e previsível. Fazer uma chamada externa em todos os testes pode gerar:

- Lentidão;
- Custos;
- Falhas por rede;
- Dependência da disponibilidade do provedor;
- Resultados variáveis do modelo.

Por isso, o comportamento externo normalmente é simulado nos testes unitários.

Uma estratégia possível é separar a aplicação em camadas:

~~~mermaid
flowchart LR
    A[Serviço da aplicação] --> B[Porta de geração de resposta]
    B --> C[Implementação Spring AI]
    B --> D[Implementação falsa para testes]
~~~

A implementação falsa permite testar o serviço sem acessar a rede.

**Exemplo prático:**

~~~java
public interface GeradorDeResposta {
    String gerar(String pergunta);
}

@Service
public class AssistenteService {

    private final GeradorDeResposta gerador;

    public AssistenteService(GeradorDeResposta gerador) {
        this.gerador = gerador;
    }

    public String responder(String pergunta) {
        if (pergunta == null || pergunta.isBlank()) {
            throw new IllegalArgumentException("Pergunta obrigatória");
        }

        return gerador.gerar(pergunta);
    }
}
~~~

Em um teste, `GeradorDeResposta` pode ser substituído por uma implementação controlada.

**Como o candidato deve responder:**  

- Diferenciar testes unitários de testes de integração;
- Explicar o uso de mocks ou stubs;
- Mencionar validação de entradas e tratamento de erros;
- Evitar chamadas reais em todos os testes;
- Reconhecer que alguns testes reais ainda podem ser necessários;
- Considerar custo e instabilidade do provedor.

**Resposta fraca ou incompleta:**  
“Eu chamaria o modelo em todos os testes para garantir que está funcionando.”

Essa estratégia torna os testes lentos, caros e instáveis. Além disso, a resposta de um modelo pode variar.

**Critérios de avaliação:**  

- **0** — Não apresenta uma estratégia de testes.
- **1** — Sugere apenas testar manualmente.
- **2** — Conhece mocks, mas não diferencia tipos de teste.
- **3** — Propõe testes unitários isolados e alguns testes de integração.
- **4** — Considera erros, respostas inválidas, custo e previsibilidade.
- **5** — Apresenta uma estratégia em camadas com contratos, testes de integração controlados e avaliação da qualidade da saída.

**Perguntas de aprofundamento:**  

1. O que você verificaria além de comparar exatamente o texto retornado?
2. Como testaria uma falha de timeout do provedor?
3. Quando um teste com o provedor real seria justificável?

---

## Pergunta 17 — Validação de entradas e respostas

**Nível:** Júnior  
**Categoria:** Boas práticas e segurança

**Pergunta do entrevistador:**  
Por que uma aplicação não deve confiar cegamente na pergunta do usuário nem na resposta produzida pelo modelo?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende que o modelo é um componente probabilístico e que a aplicação continua responsável por validar dados, permissões e regras de negócio.

**Resposta esperada:**  
A entrada do usuário pode conter dados inválidos, conteúdo malicioso, informações sensíveis ou instruções destinadas a manipular o comportamento do modelo.

A resposta do modelo também pode:

- Estar incompleta;
- Conter informações incorretas;
- Não seguir o formato esperado;
- Incluir conteúdo inadequado;
- Exceder limites;
- Tentar acionar uma ação não autorizada.

Por isso, a aplicação deve validar a entrada antes do envio e a resposta antes de utilizá-la em outras partes do sistema.

Regras críticas, como autorização, valores financeiros e permissões, devem ser verificadas por código determinístico, não apenas por instruções no prompt.

**Explicação didática:**  
Um modelo de linguagem não deve ser tratado como uma fonte infalível. Ele pode produzir uma resposta plausível, mas incorreta.

Em uma aplicação que extrai dados estruturados, por exemplo, o sistema deve verificar:

- Se o formato é válido;
- Se todos os campos obrigatórios estão presentes;
- Se os valores pertencem às opções permitidas;
- Se os tamanhos respeitam os limites;
- Se a operação solicitada é autorizada.

**Exemplo prático:**  
Se o modelo classificar um chamado como `URGENTE`, a aplicação pode validar se esse é um valor permitido. Mesmo que a classificação seja válida, uma regra separada deve definir quem pode alterar a prioridade ou acionar uma equipe.

**Exemplo de código:**

~~~java
public enum Prioridade {
    BAIXA,
    MEDIA,
    ALTA
}

public record Classificacao(
        Prioridade prioridade,
        String resumo
) {
    public Classificacao {
        if (resumo == null || resumo.isBlank()) {
            throw new IllegalArgumentException(
                    "O resumo não pode ser vazio"
            );
        }
    }
}
~~~

A validação deve ocorrer antes de persistir ou executar ações baseadas na resposta.

**Como o candidato deve responder:**  

- Explicar que modelos podem errar;
- Mencionar validação de entrada e saída;
- Diferenciar regras do prompt de regras da aplicação;
- Citar autorização e dados sensíveis;
- Apresentar um exemplo de validação estruturada;
- Demonstrar cautela antes de executar ações automáticas.

**Resposta fraca ou incompleta:**  
“Se o modelo retornou a resposta, significa que ela está correta.”

Essa resposta demonstra confiança excessiva em uma saída probabilística e ignora riscos de segurança e integridade.

**Critérios de avaliação:**  

- **0** — Não identifica necessidade de validação.
- **1** — Acredita que o modelo sempre está correto.
- **2** — Reconhece erros, mas não propõe controles.
- **3** — Explica validações básicas.
- **4** — Relaciona validação a segurança, formato e regras de negócio.
- **5** — Demonstra defesa em profundidade, autorização, auditoria e controle de ações automatizadas.

**Perguntas de aprofundamento:**  

1. O que faria se o modelo retornasse uma prioridade que não existe no sistema?
2. Como evitaria que uma resposta do modelo executasse uma ação perigosa sem confirmação?
3. Quais respostas deveriam sempre passar por revisão humana?

---

## Pergunta 18 — Controle de custo e limites de uso

**Nível:** Júnior  
**Categoria:** Operação e desempenho

**Pergunta do entrevistador:**  
Quais medidas você adotaria para evitar custos inesperados em uma aplicação que utiliza um provedor de modelos por meio do Spring AI?

**O que essa pergunta avalia:**  
Avalia consciência sobre custos de chamadas, consumo de tokens, limites operacionais e necessidade de monitoramento.

**Resposta esperada:**  
O candidato pode propor medidas como:

- Limitar o tamanho das entradas;
- Limitar o tamanho das respostas;
- Controlar o histórico das conversas;
- Aplicar limites por usuário;
- Utilizar cache quando a repetição for aceitável;
- Evitar chamadas duplicadas;
- Definir timeouts;
- Monitorar tokens e quantidade de requisições;
- Escolher modelos compatíveis com o caso de uso;
- Criar alertas de consumo;
- Aplicar cotas e rate limiting.

Também é importante diferenciar o custo financeiro do custo computacional e da latência. Um modelo mais barato pode não atender à qualidade necessária, enquanto um modelo mais poderoso pode aumentar custo e tempo de resposta.

**Explicação didática:**  
Cada chamada pode consumir recursos. O custo pode depender do tamanho da entrada, do tamanho da saída, do modelo e das regras do provedor.

Um usuário que envia um documento enorme repetidamente pode gerar consumo elevado. Uma aplicação sem limite pode ser explorada por abuso ou sofrer aumento de custos por erro de implementação.

**Exemplo prático:**  
Um endpoint de geração de resumo pode estabelecer:

- Tamanho máximo do texto;
- Número máximo de solicitações por minuto;
- Tamanho máximo da resposta;
- Limite diário por usuário;
- Registro do consumo para acompanhamento.

Um fluxo de controle pode ser representado assim:

~~~mermaid
flowchart TD
    A[Receber solicitação] --> B{Usuário autorizado?}
    B -- Não --> C[Rejeitar]
    B -- Sim --> D{Limite de uso atingido?}
    D -- Sim --> E[Informar limite]
    D -- Não --> F[Validar tamanho]
    F --> G[Consultar modelo]
    G --> H[Registrar consumo]
    H --> I[Retornar resposta]
~~~

**Como o candidato deve responder:**  

- Relacionar custo a tokens e quantidade de chamadas;
- Mencionar limites de entrada e saída;
- Propor rate limiting ou cotas;
- Falar sobre monitoramento e alertas;
- Considerar cache e escolha do modelo;
- Explicar que não se deve confiar apenas no controle do provedor.

**Resposta fraca ou incompleta:**  
“Eu usaria um modelo mais barato.”

Essa pode ser uma medida, mas não controla chamadas excessivas, entradas muito grandes, abuso ou falta de monitoramento.

**Critérios de avaliação:**  

- **0** — Não reconhece riscos de custo.
- **1** — Sugere apenas trocar o modelo.
- **2** — Menciona tokens, mas não propõe limites.
- **3** — Apresenta controles básicos de tamanho e chamadas.
- **4** — Inclui monitoramento, cotas, rate limiting e escolha adequada do modelo.
- **5** — Discute otimização, cache, orçamento, alertas, degradação e trade-offs entre custo, qualidade e latência.

**Perguntas de aprofundamento:**  

1. Como impediria que um usuário gerasse milhares de solicitações?
2. Em que situação um cache poderia ser inadequado?
3. Que métricas acompanharia para detectar aumento anormal de consumo?

---

## Pergunta 19 — Logs, métricas e observabilidade

**Nível:** Júnior  
**Categoria:** Troubleshooting e observabilidade

**Pergunta do entrevistador:**  
Quais informações você registraria para investigar problemas em uma integração Spring AI sem expor dados sensíveis?

**O que essa pergunta avalia:**  
Avalia conhecimento inicial de observabilidade, diagnóstico de integrações externas e cuidados de privacidade.

**Resposta esperada:**  
A aplicação pode registrar informações como:

- Identificador de correlação da requisição;
- Data e duração da chamada;
- Provedor e modelo utilizados;
- Status da operação;
- Tipo de erro;
- Código de resposta, quando disponível;
- Quantidade de tokens, se fornecida;
- Número de tentativas;
- Indicadores de timeout;
- Resultado de validações;
- Identificador da conversa, sem conteúdo sensível.

Deve-se evitar registrar diretamente:

- Chaves de API;
- Senhas;
- Tokens de autenticação;
- Dados pessoais desnecessários;
- Documentos confidenciais;
- Prompts e respostas completos sem política de proteção.

Quando for necessário registrar parte do conteúdo para diagnóstico, a aplicação deve aplicar mascaramento, controle de acesso, retenção limitada e proteção adequada.

**Explicação didática:**  
Observabilidade é a capacidade de entender o comportamento do sistema por meio de logs, métricas e, quando aplicável, traces.

Uma boa observabilidade ajuda a responder perguntas como:

- A falha ocorreu no cliente, na rede ou no provedor?
- O tempo de resposta aumentou?
- O problema afeta todos os usuários?
- O erro acontece apenas com determinado modelo?
- O consumo de tokens aumentou?
- As retentativas estão sendo acionadas?

Os dados registrados precisam ser úteis sem violar privacidade ou segurança.

**Exemplo prático:**  
Um log seguro poderia conter:

~~~text
requestId=abc123 provider=provedor-x model=modelo-y
durationMs=1480 attempts=1 status=SUCCESS
~~~

Em vez de registrar:

~~~text
prompt=texto completo contendo dados pessoais
apiKey=chave-secreta
~~~

**Como o candidato deve responder:**  

- Citar duração, modelo, provedor e status;
- Mencionar identificador de correlação;
- Diferenciar informações úteis de dados sensíveis;
- Falar sobre métricas e alertas;
- Explicar mascaramento e controle de retenção;
- Evitar recomendar o registro indiscriminado de prompts e respostas.

**Resposta fraca ou incompleta:**  
“Eu salvaria todas as requisições e respostas para poder investigar depois.”

Essa abordagem pode causar exposição de dados pessoais, credenciais e informações confidenciais.

**Critérios de avaliação:**  

- **0** — Não sabe como investigar uma falha.
- **1** — Sugere apenas imprimir a exceção.
- **2** — Menciona logs, mas ignora privacidade.
- **3** — Lista informações básicas de diagnóstico.
- **4** — Considera correlação, métricas, mascaramento e retenção.
- **5** — Demonstra visão de observabilidade segura, incluindo alertas, tracing, auditoria e redução de dados sensíveis.

**Perguntas de aprofundamento:**  

1. Como correlacionaria uma falha do usuário com a chamada ao provedor?
2. Quais métricas indicariam aumento de latência?
3. Quando seria aceitável armazenar uma parte do prompt?

---

## Pergunta 20 — Escolha entre usar IA e uma regra tradicional

**Nível:** Júnior  
**Categoria:** Tomada de decisão técnica

**Pergunta do entrevistador:**  
Em quais situações você escolheria uma regra tradicional ou um algoritmo determinístico em vez de utilizar um modelo de linguagem com Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato consegue escolher a tecnologia de maneira racional, considerando precisão, custo, previsibilidade, segurança e complexidade.

**Resposta esperada:**  
Uma regra tradicional ou algoritmo determinístico pode ser melhor quando:

- O problema possui regras claras;
- A resposta precisa ser sempre previsível;
- Existe uma fórmula simples;
- O resultado envolve autorização;
- A operação exige precisão absoluta;
- A latência precisa ser mínima;
- Não há necessidade de interpretar linguagem natural;
- O custo de uma chamada externa não é justificável.

Exemplos:

- Validar se um usuário tem permissão;
- Calcular um imposto com fórmula definida;
- Verificar se um campo está preenchido;
- Aplicar uma política fixa;
- Determinar se uma data está em um intervalo;
- Impedir uma operação financeira não autorizada.

O Spring AI pode ser apropriado quando existe linguagem natural, conteúdo não estruturado, necessidade de resumo, classificação flexível ou interação conversacional.

**Explicação didática:**  
A inteligência artificial não deve ser usada apenas porque está disponível. É necessário avaliar o problema.

Uma regra determinística normalmente oferece:

- Maior previsibilidade;
- Menor custo;
- Menor latência;
- Maior facilidade de auditoria;
- Comportamento mais simples de testar.

Um modelo de linguagem pode ser útil para interpretar texto, mas pode apresentar variação, erros ou respostas inesperadas.

Uma arquitetura pode combinar os dois:

~~~mermaid
flowchart TD
    A[Solicitação do usuário] --> B[Validação determinística]
    B -- Inválida --> C[Rejeitar]
    B -- Válida --> D[Interpretar linguagem natural]
    D --> E[Aplicar regras de negócio]
    E --> F[Gerar resposta]
~~~

Nesse exemplo, o modelo auxilia na interpretação, mas não substitui as regras críticas.

**Exemplo prático:**  
Um chatbot pode interpretar “quero cancelar meu plano”, mas a aplicação deve verificar por código:

- Se o usuário está autenticado;
- Se o plano pode ser cancelado;
- Se existe multa;
- Se há período de carência;
- Se o usuário confirmou a operação.

O modelo não deveria cancelar o plano apenas porque recebeu uma instrução textual.

**Como o candidato deve responder:**  

- Explicar que IA não é adequada para todos os problemas;
- Citar previsibilidade, custo, latência e auditoria;
- Dar exemplos de regras determinísticas;
- Explicar que autorização e regras críticas devem permanecer no código;
- Mostrar como combinar modelo e lógica tradicional;
- Discutir trade-offs de forma objetiva.

**Resposta fraca ou incompleta:**  
“Eu usaria Spring AI sempre que fosse possível, porque IA é mais moderna.”

Essa resposta demonstra falta de análise técnica e ignora custo, riscos, previsibilidade e simplicidade.

**Critérios de avaliação:**  

- **0** — Não consegue justificar a escolha tecnológica.
- **1** — Assume que IA é sempre a melhor solução.
- **2** — Reconhece algumas limitações, mas não apresenta critérios.
- **3** — Diferencia corretamente regras fixas e problemas de linguagem natural.
- **4** — Considera custo, latência, testes, segurança e manutenção.
- **5** — Propõe uma arquitetura híbrida e explica claramente os trade-offs entre determinismo, flexibilidade, risco e valor de negócio.

**Perguntas de aprofundamento:**  

1. Você permitiria que o modelo alterasse diretamente dados financeiros? Por quê?
2. Como combinaria a interpretação do modelo com regras determinísticas?
3. Quais critérios usaria para decidir se uma funcionalidade realmente precisa de IA?

---

## Resumo desta parte

- **Perguntas apresentadas:** 11 a 20
- **Perguntas restantes:** 21 a 100
- **Categorias abordadas:** fundamentos, prática, configuração, testes, segurança, desempenho, observabilidade e tomada de decisão técnica
- **Competências avaliadas:** gerenciamento de histórico, diferença entre modelos de chat e embeddings, configuração de parâmetros, streaming, injeção de dependências, testes isolados, validação, controle de custos, observabilidade e escolha adequada do uso de IA

A próxima parte deve continuar com as perguntas **21 a 30**, mantendo a mesma estrutura e a numeração sequencial.

---

# Roteiro de Entrevista Técnica — Spring AI

> **Parte 3 de 10**  
> Esta parte contém as perguntas **21 a 30 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

---

## Pergunta 21 — Diferença entre prompt e contexto

**Nível:** Júnior  
**Categoria:** Prompts e fundamentos

**Pergunta do entrevistador:**  
Qual é a diferença entre o prompt e o contexto fornecido a um modelo de linguagem em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende os elementos que compõem uma solicitação ao modelo e consegue diferenciar instruções, pergunta e informações auxiliares.

**Resposta esperada:**  
O prompt é a solicitação enviada ao modelo. Ele pode conter instruções, perguntas, exemplos e informações de contexto.

O contexto é o conjunto de informações adicionais fornecidas para ajudar o modelo a responder, como:

- Histórico da conversa;
- Documentos recuperados;
- Dados de uma consulta;
- Regras específicas da aplicação;
- Informações sobre o usuário, quando permitido.

Por exemplo, em um sistema RAG, a pergunta do usuário faz parte do prompt, enquanto os trechos recuperados dos documentos compõem o contexto utilizado para gerar a resposta.

**Explicação didática:**  
Considere a solicitação:

> “Qual é o prazo para solicitar férias?”

Essa é a pergunta do usuário. Se a aplicação recuperar um documento interno com a política de férias e incluí-lo na solicitação, esse documento será o contexto.

Um prompt pode conter:

1. Instruções do sistema;
2. Contexto recuperado;
3. Pergunta do usuário;
4. Formato esperado da resposta.

O contexto deve ser relevante e confiável. Enviar informações desnecessárias pode aumentar o consumo de tokens e confundir o modelo.

**Exemplo prático:**

~~~text
Instrução: responda usando apenas o conteúdo fornecido.
Contexto: funcionários devem solicitar férias com 30 dias de antecedência.
Pergunta: com quanto tempo devo solicitar minhas férias?
~~~

A resposta esperada deve considerar o contexto apresentado, sem inventar regras adicionais.

**Como o candidato deve responder:**  

- Explicar que o prompt é a solicitação completa;
- Definir contexto como informação auxiliar;
- Dar um exemplo com documentos ou histórico;
- Mencionar relevância e limite de tokens;
- Explicar que o modelo pode errar mesmo recebendo contexto.

**Resposta fraca ou incompleta:**  
“Prompt e contexto são exatamente a mesma coisa.”

Essa resposta não diferencia a solicitação completa das informações utilizadas para orientar a resposta.

**Critérios de avaliação:**  

- **0** — Não compreende os conceitos.
- **1** — Confunde contexto com resposta do modelo.
- **2** — Reconhece que existem informações adicionais, mas não explica sua função.
- **3** — Diferencia prompt e contexto corretamente.
- **4** — Relaciona o contexto a histórico, documentos e RAG.
- **5** — Discute relevância, limites, confiança, organização do prompt e riscos de contexto incorreto.

**Perguntas de aprofundamento:**  

1. O que pode acontecer quando o contexto contém informações contraditórias?
2. Como você escolheria quais documentos incluir?
3. Como evitaria ultrapassar o limite de contexto?

---

## Pergunta 22 — Templates de prompt

**Nível:** Júnior  
**Categoria:** Prática e manutenção

**Pergunta do entrevistador:**  
Por que utilizar templates de prompt em vez de concatenar strings diretamente no código?

**O que essa pergunta avalia:**  
Avalia organização de código, reutilização, manutenção e separação entre instruções fixas e dados variáveis.

**Resposta esperada:**  
Templates de prompt permitem definir uma estrutura reutilizável com variáveis que serão preenchidas em tempo de execução.

Eles são úteis porque:

- Melhoram a legibilidade;
- Evitam concatenações extensas;
- Facilitam alterações nas instruções;
- Permitem reutilizar o mesmo formato;
- Reduzem erros de montagem;
- Separam o conteúdo do prompt da lógica de negócio.

Um template pode conter uma instrução fixa e variáveis, como idioma, contexto e pergunta do usuário.

**Explicação didática:**  
Uma concatenação difícil de manter poderia ser:

~~~java
String prompt = "Você é um assistente. Responda em " 
        + idioma 
        + " usando este contexto: " 
        + contexto 
        + ". Pergunta: " 
        + pergunta;
~~~

Um template torna a intenção mais clara:

~~~text
Você é um assistente de suporte.
Responda em {idioma}.
Use o seguinte contexto:
{contexto}

Pergunta:
{pergunta}
~~~

A forma exata de criar e preencher templates depende da versão do Spring AI. O candidato deve evitar afirmar uma classe ou método sem considerar essa variação.

**Exemplo prático:**  
Uma aplicação pode utilizar o mesmo template para responder perguntas sobre diferentes produtos, substituindo apenas o nome do produto, o contexto recuperado e a pergunta do usuário.

**Como o candidato deve responder:**  

- Explicar o benefício da reutilização;
- Mencionar legibilidade e manutenção;
- Diferenciar variáveis do template de instruções fixas;
- Alertar para validação dos valores inseridos;
- Evitar inserir dados sensíveis sem controle.

**Resposta fraca ou incompleta:**  
“Templates servem apenas para deixar o código mais bonito.”

Embora melhorem a organização, eles também favorecem reutilização, testes, consistência e manutenção.

**Critérios de avaliação:**  

- **0** — Não sabe explicar a finalidade.
- **1** — Trata o template apenas como uma string diferente.
- **2** — Reconhece reutilização, mas não explica outros benefícios.
- **3** — Explica corretamente a separação entre estrutura e valores.
- **4** — Relaciona templates a manutenção, testes e consistência.
- **5** — Discute versionamento, validação, segurança, testes de prompts e governança do conteúdo.

**Perguntas de aprofundamento:**  

1. Que cuidados teria ao inserir texto fornecido pelo usuário em um template?
2. Como testaria se um template produz o contexto esperado?
3. Como organizaria vários templates em uma aplicação?

---

## Pergunta 23 — Alucinações em modelos de linguagem

**Nível:** Júnior  
**Categoria:** Fundamentos e confiabilidade

**Pergunta do entrevistador:**  
O que significa dizer que um modelo de linguagem pode “alucinar” e como uma aplicação Spring AI pode reduzir esse risco?

**O que essa pergunta avalia:**  
Avalia a compreensão das limitações dos modelos e a capacidade de propor controles para respostas incorretas ou não fundamentadas.

**Resposta esperada:**  
Uma alucinação ocorre quando o modelo produz uma informação incorreta, inventada ou não sustentada pelas fontes disponíveis, apresentando-a de maneira aparentemente convincente.

A aplicação pode reduzir o risco por meio de:

- Prompts claros;
- Uso de fontes confiáveis;
- RAG com documentos relevantes;
- Instruções para declarar incerteza;
- Respostas estruturadas;
- Validação por código;
- Exibição das fontes utilizadas;
- Revisão humana em casos críticos;
- Limitação das ações automáticas.

Essas medidas reduzem o risco, mas não garantem que o modelo sempre responderá corretamente.

**Explicação didática:**  
O modelo gera respostas com base em padrões aprendidos. Ele não verifica automaticamente se cada afirmação é verdadeira.

Por isso, uma resposta bem escrita não é necessariamente uma resposta correta.

Em um sistema interno, uma instrução como:

~~~text
Use apenas as informações presentes no contexto.
Se não houver dados suficientes, informe que não é possível responder.
~~~

pode ajudar, mas não substitui a validação da aplicação.

**Exemplo prático:**  
Em um chatbot de suporte, a aplicação pode mostrar os documentos utilizados na resposta. Se nenhum documento relevante for encontrado, pode informar ao usuário que a pergunta será encaminhada para atendimento humano.

**Como o candidato deve responder:**  

- Definir alucinação como resposta incorreta ou inventada;
- Explicar que o modelo pode parecer confiante mesmo estando errado;
- Citar RAG, fontes, validação e revisão humana;
- Ressaltar que prompt não é garantia;
- Relacionar o nível de controle ao risco do domínio.

**Resposta fraca ou incompleta:**  
“Basta configurar temperatura zero para eliminar alucinações.”

A temperatura pode tornar a saída mais previsível, mas não garante veracidade nem elimina informações inventadas.

**Critérios de avaliação:**  

- **0** — Não reconhece o problema.
- **1** — Acredita que alucinação significa erro de conexão.
- **2** — Reconhece respostas incorretas, mas não propõe controles.
- **3** — Explica o conceito e cita fontes ou validação.
- **4** — Apresenta RAG, revisão e tratamento de incerteza.
- **5** — Relaciona o risco ao domínio, à rastreabilidade, às ações automatizadas e à necessidade de avaliação contínua.

**Perguntas de aprofundamento:**  

1. Como trataria uma pergunta sem informação suficiente nos documentos?
2. Em quais domínios a revisão humana seria obrigatória?
3. Como mediria a frequência de respostas incorretas?

---

## Pergunta 24 — Chunking de documentos

**Nível:** Júnior  
**Categoria:** RAG e processamento de dados

**Pergunta do entrevistador:**  
Por que documentos costumam ser divididos em partes menores antes de serem utilizados em um fluxo RAG?

**O que essa pergunta avalia:**  
Avalia o entendimento básico de preparação de documentos para busca semântica e controle de contexto.

**Resposta esperada:**  
Dividir documentos em partes menores, processo conhecido como chunking, facilita:

- Recuperar apenas os trechos relevantes;
- Reduzir o tamanho do contexto enviado ao modelo;
- Melhorar o uso do limite de tokens;
- Aumentar a precisão da busca;
- Evitar enviar documentos inteiros desnecessariamente.

Os trechos não devem ser pequenos demais a ponto de perder o significado, nem grandes demais a ponto de incluir muito conteúdo irrelevante.

É comum utilizar alguma sobreposição entre trechos para evitar que uma informação dividida entre dois segmentos seja perdida.

**Explicação didática:**  
Imagine um manual com 200 páginas. Enviar o manual inteiro em toda pergunta seria caro e poderia ultrapassar o limite de contexto.

A aplicação pode dividi-lo em trechos relacionados. Quando o usuário fizer uma pergunta, o sistema buscará somente os trechos mais semelhantes.

A estratégia ideal depende da estrutura do documento. Um texto corrido, uma tabela e um contrato podem exigir métodos diferentes.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[Documento completo] --> B[Divisão em trechos]
    B --> C[Adicionar metadados]
    C --> D[Gerar embeddings]
    D --> E[Armazenar]
    F[Pergunta] --> G[Buscar trechos relevantes]
    E --> G
    G --> H[Montar contexto]
~~~

Metadados como título, seção, departamento e data de atualização podem ajudar na filtragem e na interpretação.

**Como o candidato deve responder:**  

- Definir chunking;
- Explicar a relação com relevância e limite de contexto;
- Mencionar tamanho e sobreposição;
- Citar a importância de preservar o significado;
- Reconhecer que a estratégia depende do tipo de documento.

**Resposta fraca ou incompleta:**  
“Os documentos são divididos apenas para ocupar menos espaço.”

A divisão também afeta a qualidade da recuperação e a quantidade de informação enviada ao modelo.

**Critérios de avaliação:**  

- **0** — Não sabe explicar a divisão de documentos.
- **1** — Relaciona apenas ao armazenamento físico.
- **2** — Entende que o documento fica menor, mas não explica relevância.
- **3** — Explica corretamente o objetivo do chunking.
- **4** — Considera sobreposição, metadados e limite de contexto.
- **5** — Discute estratégias por tipo de conteúdo, avaliação de recuperação e impacto na qualidade do RAG.

**Perguntas de aprofundamento:**  

1. O que pode acontecer se os trechos forem pequenos demais?
2. Por que a sobreposição pode ser útil?
3. Como avaliaria se o tamanho dos trechos está adequado?

---

## Pergunta 25 — Metadados em documentos

**Nível:** Júnior  
**Categoria:** RAG e segurança

**Pergunta do entrevistador:**  
Como os metadados podem melhorar uma busca de documentos em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende como informações auxiliares podem melhorar a recuperação, a filtragem e o controle de acesso.

**Resposta esperada:**  
Metadados são informações associadas ao conteúdo, como:

- Título;
- Autor;
- Data de atualização;
- Departamento;
- Tipo de documento;
- Idioma;
- Identificador da fonte;
- Nível de acesso;
- Categoria.

Eles podem ser usados para filtrar documentos antes ou depois da busca semântica. Por exemplo, uma pergunta sobre benefícios pode ser limitada a documentos do departamento de Recursos Humanos.

Metadados também ajudam a apresentar fontes, auditar respostas e impedir que documentos fora do escopo sejam considerados.

**Explicação didática:**  
A similaridade semântica sozinha pode retornar documentos parecidos, mas que não deveriam ser acessados ou utilizados.

Por exemplo, dois documentos podem tratar de “contratos”, mas um pertence ao departamento jurídico e o outro a uma filial diferente. Os metadados ajudam a restringir o conjunto de busca.

O controle de acesso deve ser aplicado pela aplicação ou pelo mecanismo de dados de forma confiável. Não se deve depender apenas da instrução enviada ao modelo.

**Exemplo prático:**

~~~json
{
  "titulo": "Política de férias",
  "departamento": "RH",
  "idioma": "pt-BR",
  "nivelAcesso": "colaborador",
  "atualizadoEm": "2026-08-15"
}
~~~

A aplicação pode recuperar apenas documentos cujo nível de acesso seja compatível com o usuário autenticado.

**Como o candidato deve responder:**  

- Definir metadados;
- Dar exemplos relevantes;
- Explicar filtragem e melhoria da busca;
- Relacionar metadados a autorização;
- Mencionar fontes e auditoria;
- Deixar claro que o modelo não deve decidir sozinho sobre permissões.

**Resposta fraca ou incompleta:**  
“Metadados servem apenas para exibir o nome do arquivo.”

Eles também podem influenciar a recuperação, a segurança, a rastreabilidade e a qualidade da resposta.

**Critérios de avaliação:**  

- **0** — Não sabe explicar metadados.
- **1** — Dá exemplos irrelevantes ou confunde metadados com conteúdo.
- **2** — Reconhece que são informações auxiliares, mas não explica seu uso.
- **3** — Explica corretamente filtragem e organização.
- **4** — Relaciona metadados a busca, fontes e controle de acesso.
- **5** — Discute segurança por documento, auditoria, atualização, consistência e riscos de filtros incorretos.

**Perguntas de aprofundamento:**  

1. Como impediria a recuperação de um documento não autorizado?
2. O que faria com documentos desatualizados?
3. Como verificaria se os metadados estão corretos?

---

## Pergunta 26 — Banco vetorial

**Nível:** Júnior  
**Categoria:** Armazenamento e arquitetura

**Pergunta do entrevistador:**  
Qual é a finalidade de um banco vetorial em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia o entendimento do papel do armazenamento vetorial em buscas semânticas e fluxos RAG.

**Resposta esperada:**  
Um banco vetorial armazena vetores, normalmente embeddings, e permite buscar vetores semelhantes.

Em uma aplicação Spring AI, ele pode armazenar:

- Trechos de documentos;
- Embeddings dos trechos;
- Metadados;
- Identificadores das fontes.

Quando o usuário faz uma pergunta, a aplicação gera o embedding da pergunta e realiza uma busca por similaridade para encontrar conteúdos relacionados.

O banco vetorial não substitui necessariamente um banco relacional. Ele é otimizado para um tipo diferente de consulta.

**Explicação didática:**  
Um banco relacional pode responder bem a perguntas como:

> “Encontre o documento com o identificador 123.”

Um banco vetorial é útil para perguntas como:

> “Encontre documentos semanticamente semelhantes a problemas de autenticação.”

A busca vetorial geralmente considera uma medida de similaridade, como distância ou similaridade de cosseno, conforme a tecnologia utilizada.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Documento] --> B[Embedding]
    B --> C[Banco vetorial]
    A --> D[Metadados]
    D --> C

    E[Pergunta] --> F[Embedding da pergunta]
    F --> G[Busca por similaridade]
    C --> G
    G --> H[Trechos recuperados]
~~~

A aplicação pode combinar busca semântica com filtros por categoria, idioma ou permissão.

**Como o candidato deve responder:**  

- Definir o banco vetorial;
- Explicar que ele armazena embeddings e metadados;
- Relacionar seu uso a busca semântica e RAG;
- Diferenciar busca vetorial de consulta relacional tradicional;
- Mencionar compatibilidade entre dimensões e modelos de embedding.

**Resposta fraca ou incompleta:**  
“Banco vetorial é um banco que armazena respostas prontas do chatbot.”

Ele pode armazenar trechos e representações vetoriais, mas sua finalidade principal é permitir busca por similaridade.

**Critérios de avaliação:**  

- **0** — Não entende a finalidade.
- **1** — Confunde vetores com respostas textuais.
- **2** — Sabe que há relação com documentos, mas não explica a busca.
- **3** — Explica corretamente embeddings e similaridade.
- **4** — Relaciona o banco vetorial a RAG e metadados.
- **5** — Discute indexação, compatibilidade, filtros, atualização e limitações operacionais.

**Perguntas de aprofundamento:**  

1. O que aconteceria se a dimensão dos embeddings não fosse compatível?
2. Como atualizaria um documento já indexado?
3. Por que poderia combinar busca vetorial com filtros tradicionais?

---

## Pergunta 27 — Controle de acesso em RAG

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
Como você garantiria que um usuário só pudesse receber respostas baseadas em documentos aos quais ele tem acesso?

**O que essa pergunta avalia:**  
Avalia noções de autenticação, autorização, isolamento de dados e segurança em aplicações com recuperação de documentos.

**Resposta esperada:**  
A aplicação deve identificar e autenticar o usuário antes de executar a busca.

Depois, deve aplicar autorização com base em informações como:

- Usuário;
- Perfil;
- Departamento;
- Organização;
- Tenant;
- Nível de classificação;
- Permissões específicas.

A busca deve filtrar os documentos autorizados antes que eles sejam incluídos no contexto enviado ao modelo.

Não é suficiente instruir o modelo a ignorar documentos confidenciais. O controle precisa ocorrer na camada da aplicação ou do armazenamento.

**Explicação didática:**  
Um fluxo seguro pode ser:

1. Autenticar o usuário;
2. Identificar suas permissões;
3. Aplicar filtros na busca;
4. Recuperar somente trechos permitidos;
5. Montar o contexto;
6. Gerar a resposta;
7. Validar o resultado antes de exibi-lo.

O modelo nunca deve receber conteúdo que o usuário não poderia acessar, pois uma instrução no prompt não garante que o conteúdo será ocultado.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Usuário autenticado] --> B[Consultar permissões]
    B --> C[Aplicar filtros de acesso]
    C --> D[Buscar documentos autorizados]
    D --> E[Montar contexto]
    E --> F[Consultar modelo]
    F --> G[Validar resposta]
    G --> H[Exibir ao usuário]
~~~

Em uma aplicação multiempresa, o filtro de tenant deve ser aplicado em todas as etapas relevantes.

**Como o candidato deve responder:**  

- Diferenciar autenticação de autorização;
- Explicar filtragem antes da recuperação;
- Mencionar perfis, departamentos ou tenants;
- Reforçar que o prompt não substitui controle de acesso;
- Considerar logs e auditoria;
- Citar testes para verificar isolamento entre usuários.

**Resposta fraca ou incompleta:**  
“Eu colocaria no prompt que o modelo não deve mostrar documentos privados.”

Essa abordagem deixa a segurança dependente do comportamento probabilístico do modelo.

**Critérios de avaliação:**  

- **0** — Não identifica o risco.
- **1** — Confia apenas em instruções no prompt.
- **2** — Menciona login, mas não explica autorização.
- **3** — Propõe filtrar documentos conforme as permissões.
- **4** — Considera tenants, auditoria e testes de isolamento.
- **5** — Demonstra defesa em profundidade, controle na recuperação, prevenção de vazamentos e validação ponta a ponta.

**Perguntas de aprofundamento:**  

1. Como testaria se um usuário não consegue consultar documentos de outro departamento?
2. Onde aplicaria o filtro de tenant?
3. O que faria se um documento tivesse metadados de acesso incorretos?

---

## Pergunta 28 — Timeout e latência

**Nível:** Júnior  
**Categoria:** Desempenho e troubleshooting

**Pergunta do entrevistador:**  
Uma chamada ao modelo está demorando muito e causando timeout no endpoint. Como você investigaria e trataria essa situação?

**O que essa pergunta avalia:**  
Avalia raciocínio de diagnóstico, compreensão de latência e capacidade de aplicar controles básicos de confiabilidade.

**Resposta esperada:**  
O candidato deve investigar:

- Tempo gasto na busca de documentos;
- Tempo de geração de embeddings;
- Tempo de resposta do modelo;
- Tamanho do prompt;
- Quantidade de documentos recuperados;
- Configuração de timeout;
- Disponibilidade do provedor;
- Número de retentativas;
- Saturação de threads ou conexões.

As medidas possíveis incluem:

- Definir timeouts adequados;
- Reduzir o contexto;
- Limitar o tamanho da resposta;
- Evitar chamadas duplicadas;
- Usar streaming quando fizer sentido;
- Processar tarefas longas de forma assíncrona;
- Aplicar circuit breaker ou degradação controlada;
- Informar o usuário de maneira clara.

**Explicação didática:**  
Um timeout é o limite de tempo que a aplicação aceita esperar por uma operação.

Aumentar o timeout pode esconder o problema e manter conexões ocupadas por muito tempo. Reduzi-lo demais pode gerar falhas mesmo quando o provedor responderia normalmente.

A solução deve considerar o tipo de operação. Uma resposta interativa pode ter um limite menor que uma tarefa assíncrona de geração de relatórios.

**Exemplo prático:**  
Para um endpoint interativo, a aplicação pode retornar uma mensagem de indisponibilidade temporária quando o modelo exceder o limite. Para um relatório longo, pode criar uma tarefa e permitir que o usuário consulte o resultado posteriormente.

**Como o candidato deve responder:**  

- Separar as etapas do fluxo para localizar a latência;
- Mencionar tamanho do contexto e quantidade de documentos;
- Explicar timeouts e retentativas;
- Considerar streaming ou processamento assíncrono;
- Evitar simplesmente aumentar o timeout;
- Falar sobre métricas.

**Resposta fraca ou incompleta:**  
“Eu aumentaria o timeout para esperar mais.”

Essa ação pode piorar o consumo de recursos e não resolve a causa da lentidão.

**Critérios de avaliação:**  

- **0** — Não apresenta estratégia.
- **1** — Sugere apenas reiniciar a aplicação.
- **2** — Menciona timeout, mas não investiga as etapas.
- **3** — Propõe medir o fluxo e ajustar limites.
- **4** — Considera contexto, streaming, tarefas assíncronas e monitoramento.
- **5** — Discute latência ponta a ponta, degradação, circuit breaker, concorrência e experiência do usuário.

**Perguntas de aprofundamento:**  

1. Como descobriria se a lentidão está no banco vetorial ou no provedor?
2. Quando usaria processamento assíncrono?
3. Que resposta apresentaria ao usuário após um timeout?

---

## Pergunta 29 — Retentativas e idempotência

**Nível:** Júnior  
**Categoria:** Confiabilidade e integração

**Pergunta do entrevistador:**  
Quando uma aplicação Spring AI deve repetir automaticamente uma chamada que falhou e quais riscos precisam ser considerados?

**O que essa pergunta avalia:**  
Avalia a compreensão de falhas temporárias, retentativas controladas e efeitos duplicados.

**Resposta esperada:**  
Retentativas podem ser adequadas para falhas temporárias, como:

- Timeout transitório;
- Erro temporário de rede;
- Indisponibilidade momentânea;
- Limite de requisições que permita aguardar e tentar novamente.

Não devem ser aplicadas indiscriminadamente a erros permanentes, como:

- Credencial inválida;
- Modelo inexistente;
- Requisição malformada;
- Entrada acima do limite;
- Falta de autorização.

É necessário limitar o número de tentativas e utilizar atraso, frequentemente com backoff. Também se deve considerar o impacto financeiro e o risco de duplicar ações.

**Explicação didática:**  
Backoff é o aumento progressivo do tempo entre as tentativas. Ele evita que várias instâncias repitam chamadas simultaneamente e agravem uma indisponibilidade.

Idempotência significa que repetir a operação não causa efeitos indevidos. Consultar um modelo para gerar uma resposta normalmente não altera dados externos, mas uma resposta que aciona cancelamento, pagamento ou envio de mensagem pode produzir efeitos duplicados.

**Exemplo prático:**  
Se o modelo gerar uma classificação de chamado, uma nova tentativa pode ser aceitável. Se a resposta acionar o envio de um e-mail, a aplicação deve utilizar identificadores, confirmação ou controle de duplicidade.

**Como o candidato deve responder:**  

- Diferenciar erros temporários e permanentes;
- Mencionar limite de tentativas e backoff;
- Explicar custo e sobrecarga;
- Definir idempotência;
- Considerar ações externas;
- Citar logs e métricas para acompanhar retentativas.

**Resposta fraca ou incompleta:**  
“Eu repetiria sempre que desse erro até funcionar.”

Essa estratégia pode gerar loop, aumento de custos, sobrecarga e ações duplicadas.

**Critérios de avaliação:**  

- **0** — Não entende retentativas.
- **1** — Sugere repetir indefinidamente.
- **2** — Reconhece erros temporários, mas não define limites.
- **3** — Propõe tentativas controladas para falhas recuperáveis.
- **4** — Inclui backoff, classificação de erros e observabilidade.
- **5** — Discute idempotência, efeitos externos, circuit breaker, custos e comportamento sob falhas em produção.

**Perguntas de aprofundamento:**  

1. Como diferenciaria um erro recuperável de um erro permanente?
2. O que poderia acontecer com três instâncias repetindo chamadas ao mesmo tempo?
3. Como evitaria duplicidade em uma ação acionada pela resposta?

---

## Pergunta 30 — Ferramentas acionadas pelo modelo

**Nível:** Júnior  
**Categoria:** Integração e segurança

**Pergunta do entrevistador:**  
O que significa permitir que um modelo utilize uma ferramenta ou função da aplicação e quais cuidados devem ser tomados?

**O que essa pergunta avalia:**  
Avalia a compreensão inicial de tool calling ou function calling e dos riscos de permitir que uma saída do modelo desencadeie operações reais.

**Resposta esperada:**  
Permitir que o modelo utilize uma ferramenta significa disponibilizar uma operação que a aplicação pode executar quando o modelo identificar que ela é necessária.

Exemplos:

- Consultar o status de um pedido;
- Buscar dados em um sistema;
- Consultar a previsão do tempo;
- Calcular um valor;
- Recuperar informações de uma base interna.

O modelo não deveria receber acesso irrestrito ao sistema. A aplicação deve:

- Definir ferramentas específicas;
- Validar os argumentos;
- Verificar autorização;
- Limitar os dados retornados;
- Registrar a execução;
- Tratar erros;
- Solicitar confirmação para ações sensíveis;
- Impedir operações perigosas ou irreversíveis.

**Explicação didática:**  
O modelo pode interpretar a pergunta:

> “Onde está meu pedido?”

e sugerir a utilização de uma ferramenta como `consultarStatusPedido`.

A aplicação recebe essa intenção, valida se o usuário tem acesso ao pedido informado e só então executa a operação.

O modelo pode ajudar a decidir qual ferramenta usar, mas a aplicação continua responsável por permissões, validações e efeitos colaterais.

**Exemplo prático:**

~~~mermaid
sequenceDiagram
    participant U as Usuário
    participant A as Aplicação
    participant M as Modelo
    participant F as Ferramenta

    U->>A: Pergunta sobre pedido
    A->>M: Envia pergunta e ferramentas disponíveis
    M-->>A: Solicita consultarStatusPedido
    A->>A: Valida argumentos e autorização
    A->>F: Executa consulta autorizada
    F-->>A: Retorna dados limitados
    A->>M: Envia resultado da ferramenta
    M-->>A: Gera resposta
    A-->>U: Exibe resposta
~~~

Uma ferramenta que cancela um pedido ou realiza um pagamento deve exigir controles mais rigorosos que uma ferramenta de consulta.

**Como o candidato deve responder:**  

- Explicar que ferramentas permitem conectar o modelo a funções da aplicação;
- Dar um exemplo de consulta;
- Diferenciar consulta de ação com efeito colateral;
- Mencionar validação, autorização e confirmação;
- Explicar que o modelo não deve ter acesso direto e irrestrito ao banco;
- Citar auditoria e tratamento de erros.

**Resposta fraca ou incompleta:**  
“Eu deixaria o modelo chamar qualquer método necessário para resolver a solicitação.”

Essa abordagem cria riscos graves de segurança, acesso indevido e execução de operações perigosas.

**Critérios de avaliação:**  

- **0** — Não compreende a finalidade das ferramentas.
- **1** — Propõe acesso irrestrito ao sistema.
- **2** — Entende que uma função pode ser chamada, mas ignora segurança.
- **3** — Explica o uso controlado de ferramentas de consulta.
- **4** — Considera validação, autorização, logs e confirmação.
- **5** — Diferencia claramente leitura e escrita, discute efeitos colaterais, escopo mínimo, auditoria, falhas e segurança em profundidade.

**Perguntas de aprofundamento:**  

1. Você permitiria que uma ferramenta realizasse um pagamento automaticamente? Por quê?
2. Como validaria os argumentos fornecidos pelo modelo?
3. Como impediria que o modelo acessasse dados de outro usuário?

---

## Resumo desta parte

- **Perguntas apresentadas:** 21 a 30
- **Perguntas restantes:** 31 a 100
- **Categorias abordadas:** prompts, RAG, segurança, armazenamento vetorial, desempenho, confiabilidade e integração
- **Competências avaliadas:** diferenciação entre prompt e contexto, uso de templates, identificação de alucinações, preparação de documentos, metadados, bancos vetoriais, controle de acesso, tratamento de timeout, retentativas e uso seguro de ferramentas

A próxima parte deve continuar com as perguntas **31 a 40**, mantendo a mesma estrutura e a numeração sequencial.

---

# Roteiro de Entrevista Técnica — Spring AI

> **Parte 4 de 10**  
> Esta parte contém as perguntas **31 a 40 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

---

## Pergunta 31 — Diferença entre chamada síncrona e assíncrona

**Nível:** Júnior  
**Categoria:** Integração e desempenho

**Pergunta do entrevistador:**  
Qual é a diferença entre realizar uma chamada síncrona ou assíncrona a um modelo de linguagem em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende diferentes formas de execução de chamadas externas e sabe relacioná-las à experiência do usuário e ao uso de recursos da aplicação.

**Resposta esperada:**  
Em uma chamada síncrona, a execução aguarda a resposta do modelo antes de continuar. O método que iniciou a operação permanece aguardando durante esse período.

Em uma chamada assíncrona, a aplicação inicia a operação e pode continuar executando outras tarefas enquanto aguarda o resultado. Quando a resposta estiver disponível, ela será processada por meio de um mecanismo apropriado.

A chamada síncrona é simples e pode ser suficiente para operações rápidas. A assíncrona é mais adequada para tarefas demoradas, processamento em lote ou situações em que não é necessário bloquear uma requisição HTTP.

A escolha deve considerar:

- Tempo esperado de resposta;
- Experiência do usuário;
- Capacidade da aplicação;
- Necessidade de acompanhamento do processamento;
- Tratamento de erros;
- Cancelamento e retentativas.

**Explicação didática:**  
Em uma chamada síncrona:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant A as Aplicação
    participant M as Modelo

    C->>A: Solicita resumo
    A->>M: Envia conteúdo
    M-->>A: Retorna resposta
    A-->>C: Entrega resultado
~~~

O cliente espera até a conclusão.

Em uma chamada assíncrona:

~~~mermaid
sequenceDiagram
    participant C as Cliente
    participant A as Aplicação
    participant M as Modelo

    C->>A: Solicita relatório
    A-->>C: Retorna identificador da tarefa
    A->>M: Processa solicitação
    M-->>A: Retorna resultado
    C->>A: Consulta status
    A-->>C: Entrega resultado
~~~

A operação assíncrona normalmente exige persistir o status da tarefa e oferecer uma forma de consulta ou notificação.

**Exemplo prático:**  
Uma resposta curta para um chatbot pode ser síncrona. Já a análise de milhares de documentos pode ser executada de forma assíncrona.

**Como o candidato deve responder:**  

- Diferenciar bloqueio e execução em segundo plano;
- Citar uma situação adequada para cada abordagem;
- Mencionar timeout e experiência do usuário;
- Explicar que tarefas longas podem usar fila ou processamento posterior;
- Considerar tratamento de falhas.

**Resposta fraca ou incompleta:**  
“Assíncrono é sempre melhor porque é mais rápido.”

A execução assíncrona não torna necessariamente o modelo mais rápido. Ela apenas evita que a aplicação ou o cliente fique bloqueado aguardando a conclusão.

**Critérios de avaliação:**  

- **0** — Não diferencia as abordagens.
- **1** — Confunde processamento assíncrono com maior velocidade do modelo.
- **2** — Entende parcialmente o conceito, mas não relaciona ao caso de uso.
- **3** — Explica corretamente chamadas síncronas e assíncronas.
- **4** — Considera timeout, filas, acompanhamento e experiência do usuário.
- **5** — Analisa concorrência, capacidade, cancelamento, persistência e trade-offs operacionais.

**Perguntas de aprofundamento:**  

1. Quando uma chamada síncrona seria mais simples e adequada?
2. Como o usuário consultaria o resultado de uma tarefa assíncrona?
3. Como trataria uma falha ocorrida após a tarefa ser criada?

---

## Pergunta 32 — Validação de entrada no endpoint

**Nível:** Júnior  
**Categoria:** Boas práticas e segurança

**Pergunta do entrevistador:**  
Como você validaria os dados recebidos por um endpoint que envia perguntas ao modelo por meio do Spring AI?

**O que essa pergunta avalia:**  
Avalia conhecimentos básicos de validação de dados, segurança de endpoints e prevenção de uso indevido da integração.

**Resposta esperada:**  
A aplicação deve validar a entrada antes de encaminhá-la ao modelo.

Entre as validações possíveis estão:

- Campo obrigatório;
- Tamanho mínimo e máximo;
- Formato esperado;
- Limite de documentos ou caracteres;
- Usuário autenticado;
- Permissão para executar a operação;
- Conteúdo permitido para o caso de uso;
- Limite de requisições.

Também é importante remover ou tratar informações sensíveis quando necessário. A validação não precisa impedir todo conteúdo desconhecido, mas deve evitar entradas claramente inválidas, excessivas ou incompatíveis com a finalidade do endpoint.

**Exemplo de código:**

~~~java
public record PerguntaRequest(
        @NotBlank(message = "A pergunta é obrigatória")
        @Size(max = 4000, message = "A pergunta excede o limite")
        String pergunta
) {}
~~~

O controlador pode receber esse objeto e delegar a operação para um serviço. A configuração exata das validações depende do projeto Spring utilizado.

**Explicação didática:**  
Sem validação, um usuário poderia enviar:

- Uma entrada vazia;
- Um texto extremamente grande;
- Um conteúdo repetido para aumentar custos;
- Informações que não deveriam ser processadas;
- Uma solicitação de operação sem autorização.

A validação reduz falhas, custos e riscos, mas não substitui outras proteções, como autenticação, autorização e limitação de uso.

**Como o candidato deve responder:**  

- Citar campos obrigatórios e limites de tamanho;
- Mencionar autenticação e autorização;
- Relacionar a validação ao custo e ao limite de contexto;
- Explicar que a entrada deve ser tratada antes da chamada;
- Dar preferência a validações declarativas quando adequadas.

**Resposta fraca ou incompleta:**  
“Eu verificaria apenas se a pergunta não está vazia.”

Essa é uma validação inicial, mas não trata tamanho excessivo, autorização, abuso ou dados sensíveis.

**Critérios de avaliação:**  

- **0** — Não identifica a necessidade de validação.
- **1** — Considera somente verificar se existe algum texto.
- **2** — Cita tamanho, mas ignora segurança e autorização.
- **3** — Propõe validações básicas adequadas.
- **4** — Relaciona validação a custo, segurança e limites operacionais.
- **5** — Demonstra visão de defesa em profundidade, incluindo abuso, privacidade, rate limiting e rastreabilidade.

**Perguntas de aprofundamento:**  

1. Qual limite de tamanho você escolheria e como o validaria?
2. Como trataria uma pergunta contendo dados pessoais?
3. A validação da entrada elimina o risco de prompt injection? Por quê?

---

## Pergunta 33 — Resposta vazia ou incompleta

**Nível:** Júnior  
**Categoria:** Tratamento de erros

**Pergunta do entrevistador:**  
Como sua aplicação deveria reagir se o modelo retornasse uma resposta vazia, incompleta ou em formato inesperado?

**O que essa pergunta avalia:**  
Avalia se o candidato entende que a resposta do modelo precisa ser validada antes de ser exibida ou utilizada por outra parte do sistema.

**Resposta esperada:**  
A aplicação deve verificar a resposta recebida antes de utilizá-la.

Dependendo do caso, ela pode:

- Rejeitar a resposta;
- Solicitar uma nova tentativa controlada;
- Retornar uma mensagem de indisponibilidade;
- Encaminhar o caso para revisão humana;
- Registrar o problema;
- Usar uma resposta alternativa previamente definida.

Se a resposta deveria seguir um formato estruturado, a aplicação precisa validar a estrutura, os campos obrigatórios e os valores permitidos.

Não é adequado exibir silenciosamente uma resposta vazia ou persistir dados inválidos.

**Exemplo prático:**  
Se o modelo deveria classificar um chamado, a aplicação pode verificar se a categoria retornada existe no sistema. Caso contrário, o chamado pode ser encaminhado para análise manual.

**Exemplo de código:**

~~~java
public String validarResposta(String resposta) {
    if (resposta == null || resposta.isBlank()) {
        throw new IllegalStateException(
                "O modelo retornou uma resposta vazia"
        );
    }

    return resposta.trim();
}
~~~

Em uma aplicação real, o tratamento pode utilizar exceções específicas, métricas e uma resposta adequada ao cliente.

**Explicação didática:**  
Uma chamada bem-sucedida tecnicamente não garante uma resposta útil. O provedor pode retornar uma mensagem vazia, truncada ou incompatível com o esperado.

A aplicação deve diferenciar:

- Falha de comunicação;
- Resposta vazia;
- Conteúdo inválido;
- Conteúdo semanticamente inadequado.

Cada situação pode exigir uma ação diferente.

**Como o candidato deve responder:**  

- Falar sobre validação da resposta;
- Mencionar formato, campos e valores permitidos;
- Sugerir fallback ou revisão humana;
- Explicar que não se deve confiar cegamente na saída;
- Considerar logs e métricas.

**Resposta fraca ou incompleta:**  
“Eu retornaria a resposta como veio.”

Essa abordagem pode enviar conteúdo inválido ao usuário ou provocar falhas em etapas posteriores.

**Critérios de avaliação:**  

- **0** — Não considera a possibilidade de resposta inválida.
- **1** — Exibe qualquer resultado sem validação.
- **2** — Reconhece respostas vazias, mas não propõe tratamento.
- **3** — Valida respostas básicas.
- **4** — Considera fallback, formato estruturado e registro do problema.
- **5** — Diferencia tipos de falha e propõe estratégias seguras de recuperação e revisão.

**Perguntas de aprofundamento:**  

1. Quando você tentaria novamente a chamada?
2. Como trataria uma resposta JSON com campos desconhecidos?
3. Em que situação encaminharia a resposta para uma pessoa?

---

## Pergunta 34 — Separação entre controller e serviço

**Nível:** Júnior  
**Categoria:** Design de código

**Pergunta do entrevistador:**  
Por que a chamada ao modelo não deveria ficar diretamente dentro do controlador HTTP?

**O que essa pergunta avalia:**  
Avalia princípios básicos de organização de código, separação de responsabilidades e testabilidade.

**Resposta esperada:**  
O controlador deve ser responsável principalmente por receber a requisição, validar os dados básicos e devolver uma resposta HTTP.

A lógica de interação com o modelo deve ficar em um serviço ou componente próprio. Essa separação facilita:

- Testes unitários;
- Reutilização da lógica;
- Tratamento centralizado de erros;
- Troca do provedor;
- Manutenção;
- Evolução para processamento assíncrono;
- Organização das regras de negócio.

**Exemplo de código:**

~~~java
@Service
public class AssistenteService {

    private final ChatClient chatClient;

    public AssistenteService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String responder(String pergunta) {
        return chatClient
                .prompt()
                .user(pergunta)
                .call()
                .content();
    }
}

@RestController
@RequestMapping("/assistente")
public class AssistenteController {

    private final AssistenteService service;

    public AssistenteController(AssistenteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> responder(
            @RequestBody PerguntaRequest request) {
        return ResponseEntity.ok(
                service.responder(request.pergunta())
        );
    }
}
~~~

O exemplo é simplificado. Uma aplicação real também deve tratar validação, exceções e autenticação.

**Explicação didática:**  
Quando o controlador concentra todas as responsabilidades, ele pode ficar difícil de testar e modificar.

Ao separar as camadas:

- O controlador cuida do protocolo HTTP;
- O serviço coordena a operação;
- O cliente de IA cuida da integração;
- Componentes específicos podem cuidar de validação, persistência ou recuperação de documentos.

Essa divisão não precisa ser excessivamente complexa. O objetivo é manter responsabilidades claras.

**Como o candidato deve responder:**  

- Explicar separação de responsabilidades;
- Diferenciar controller e serviço;
- Mencionar testabilidade e reutilização;
- Mostrar que a integração externa pode ser isolada;
- Evitar criar um excesso desnecessário de camadas.

**Resposta fraca ou incompleta:**  
“Porque essa é a forma padrão do Spring.”

A resposta precisa explicar os benefícios práticos da separação.

**Critérios de avaliação:**  

- **0** — Não entende a separação.
- **1** — Apenas repete que controller e service são diferentes.
- **2** — Reconhece organização, mas não explica os benefícios.
- **3** — Separa corretamente responsabilidades.
- **4** — Relaciona a separação a testes, manutenção e reutilização.
- **5** — Apresenta uma estrutura equilibrada, com baixo acoplamento e responsabilidades bem definidas.

**Perguntas de aprofundamento:**  

1. O que você colocaria no controller?
2. Como testaria o serviço isoladamente?
3. Quando separar a integração do `ChatClient` em outro componente?

---

## Pergunta 35 — Configuração por ambiente

**Nível:** Júnior  
**Categoria:** Configuração e operação

**Pergunta do entrevistador:**  
Como você configuraria comportamentos diferentes para o Spring AI nos ambientes de desenvolvimento, teste e produção?

**O que essa pergunta avalia:**  
Avalia conhecimento básico de configuração por ambiente, segurança de credenciais e controle de dependências externas.

**Resposta esperada:**  
A aplicação deve separar configurações por ambiente, evitando colocar valores sensíveis ou específicos diretamente no código.

Podem variar entre ambientes:

- Provedor;
- Modelo;
- URL do serviço;
- Chave de acesso;
- Temperatura;
- Limites de resposta;
- Timeouts;
- Estratégia de logs;
- Uso de implementação simulada nos testes.

As credenciais devem ser fornecidas por variáveis de ambiente ou um gerenciador de segredos. Em testes unitários, o provedor real normalmente deve ser substituído por um mock ou implementação falsa.

**Exemplo conceitual:**

~~~yaml
spring:
  config:
    activate:
      on-profile: desenvolvimento

app:
  ai:
    modelo: modelo-local
    registrar-conteudo: false
~~~

O formato e os nomes das propriedades podem variar conforme a organização do projeto e a versão utilizada.

**Explicação didática:**  
O ambiente de desenvolvimento pode utilizar um modelo local ou um provedor de menor custo. O ambiente de produção exige credenciais protegidas, observabilidade e limites mais rigorosos.

Os testes devem ser previsíveis. Depender de um modelo externo em todos os testes pode gerar custos, lentidão e resultados variáveis.

**Como o candidato deve responder:**  

- Mencionar perfis ou configurações por ambiente;
- Proteger credenciais;
- Diferenciar testes unitários e integração;
- Considerar modelos locais ou simulados em desenvolvimento;
- Evitar versionar chaves.

**Resposta fraca ou incompleta:**  
“Eu usaria a mesma chave e o mesmo modelo em todos os ambientes.”

Essa prática aumenta riscos de segurança, custos e dificuldade de diagnóstico.

**Critérios de avaliação:**  

- **0** — Não sabe separar ambientes.
- **1** — Coloca credenciais diretamente no código.
- **2** — Conhece configurações diferentes, mas ignora segurança.
- **3** — Explica perfis, variáveis de ambiente e testes isolados.
- **4** — Considera custos, modelos locais e observabilidade.
- **5** — Discute governança de configuração, rotação de segredos, promoção controlada e diferenças operacionais.

**Perguntas de aprofundamento:**  

1. Onde armazenaria as credenciais de produção?
2. Por que um modelo real não deve ser usado em todos os testes?
3. Como impediria que uma configuração de desenvolvimento fosse usada em produção?

---

## Pergunta 36 — Limites de concorrência

**Nível:** Júnior  
**Categoria:** Desempenho e operação

**Pergunta do entrevistador:**  
O que pode acontecer se muitos usuários fizerem chamadas ao modelo simultaneamente e como você controlaria essa situação?

**O que essa pergunta avalia:**  
Avalia noções de concorrência, limites de provedores, proteção de recursos e estabilidade da aplicação.

**Resposta esperada:**  
Muitas chamadas simultâneas podem causar:

- Esgotamento de threads;
- Saturação de conexões;
- Aumento de latência;
- Erros de limite do provedor;
- Crescimento de custos;
- Timeouts;
- Indisponibilidade da aplicação;
- Respostas degradadas.

A aplicação pode utilizar:

- Rate limiting;
- Limites de concorrência;
- Filas;
- Controle de tamanho das solicitações;
- Timeouts;
- Circuit breaker;
- Cotas por usuário;
- Cache quando adequado;
- Processamento assíncrono.

A estratégia depende do tipo de aplicação e da capacidade do provedor.

**Explicação didática:**  
Uma aplicação pode funcionar bem com dez requisições simultâneas, mas falhar com milhares.

Controlar concorrência significa limitar quantas operações podem estar em andamento ao mesmo tempo. As solicitações excedentes podem ser rejeitadas, colocadas em fila ou processadas posteriormente.

O controle deve ser acompanhado por métricas para verificar se a aplicação está recusando operações demais ou mantendo uma fila muito longa.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Nova solicitação] --> B{Limite de concorrência atingido?}
    B -- Não --> C[Executar chamada ao modelo]
    B -- Sim --> D{Fila disponível?}
    D -- Sim --> E[Adicionar à fila]
    D -- Não --> F[Retornar indisponibilidade]
    C --> G[Registrar resultado]
    E --> G
~~~

**Como o candidato deve responder:**  

- Citar saturação, latência e limites do provedor;
- Mencionar rate limiting e filas;
- Explicar diferença entre rejeitar e enfileirar;
- Considerar custo e experiência do usuário;
- Relacionar a estratégia ao volume esperado.

**Resposta fraca ou incompleta:**  
“Eu deixaria o servidor processar todas as chamadas.”

Essa abordagem pode derrubar a aplicação ou ultrapassar os limites do provedor.

**Critérios de avaliação:**  

- **0** — Não identifica riscos de concorrência.
- **1** — Acredita que o provedor sempre suportará qualquer volume.
- **2** — Reconhece lentidão, mas não propõe controles.
- **3** — Cita limites e rate limiting.
- **4** — Considera filas, cotas, timeouts e métricas.
- **5** — Analisa capacidade, backpressure, degradação, prioridades e comportamento em picos.

**Perguntas de aprofundamento:**  

1. Quando você rejeitaria uma solicitação em vez de colocá-la em fila?
2. Como definiria uma cota por usuário?
3. Que métricas indicariam saturação?

---

## Pergunta 37 — Fallback para indisponibilidade

**Nível:** Júnior  
**Categoria:** Confiabilidade

**Pergunta do entrevistador:**  
Como você projetaria um comportamento de fallback quando o provedor principal de modelos estivesse indisponível?

**O que essa pergunta avalia:**  
Avalia a capacidade do candidato de pensar em continuidade de serviço e degradação controlada.

**Resposta esperada:**  
Um fallback é uma alternativa utilizada quando a operação principal não está disponível.

Possibilidades incluem:

- Usar um segundo provedor;
- Usar um modelo menor;
- Utilizar um modelo local;
- Retornar uma resposta previamente definida;
- Encaminhar a solicitação para atendimento humano;
- Colocar a tarefa em fila;
- Informar claramente a indisponibilidade.

O fallback deve ser utilizado somente quando a alternativa tiver qualidade, segurança e permissões compatíveis. Não basta trocar automaticamente para qualquer modelo.

Também é importante evitar alternância contínua entre provedores e registrar qual alternativa foi utilizada.

**Explicação didática:**  
Um sistema de suporte pode tentar primeiro um modelo principal. Se ele estiver indisponível, pode utilizar um modelo secundário para perguntas simples.

Entretanto, um modelo secundário pode:

- Ter limite menor;
- Ser menos preciso;
- Não suportar ferramentas;
- Possuir custo diferente;
- Estar hospedado em outro ambiente;
- Ter políticas de privacidade distintas.

A aplicação deve conhecer essas diferenças.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Receber pergunta] --> B[Provedor principal]
    B -- Sucesso --> C[Retornar resposta]
    B -- Falha recuperável --> D[Verificar fallback]
    D -- Disponível --> E[Provedor secundário]
    D -- Indisponível --> F[Resposta alternativa ou atendimento humano]
    E --> G[Validar resposta]
    G --> C
~~~

**Como o candidato deve responder:**  

- Definir fallback;
- Citar provedor alternativo ou degradação;
- Considerar diferença de qualidade e capacidade;
- Mencionar logs, métricas e limites;
- Explicar que ações críticas podem precisar ser bloqueadas durante a degradação.

**Resposta fraca ou incompleta:**  
“Eu chamaria outro modelo sem nenhuma validação.”

Essa solução pode introduzir problemas de segurança, formato, custo ou qualidade.

**Critérios de avaliação:**  

- **0** — Não propõe alternativa.
- **1** — Sugere apenas reiniciar a aplicação.
- **2** — Cita outro provedor, mas ignora diferenças.
- **3** — Explica um fallback básico.
- **4** — Considera qualidade, segurança, observabilidade e degradação.
- **5** — Discute critérios de acionamento, compatibilidade, circuit breaker e comunicação ao usuário.

**Perguntas de aprofundamento:**  

1. Em que situação você não usaria um modelo secundário?
2. Como saberia que o provedor principal voltou a funcionar?
3. Como informaria ao usuário que a resposta foi gerada em modo degradado?

---

## Pergunta 38 — Cache de respostas

**Nível:** Júnior  
**Categoria:** Desempenho e custo

**Pergunta do entrevistador:**  
Quando o uso de cache pode ser útil em uma aplicação que utiliza Spring AI e quais cuidados devem ser tomados?

**O que essa pergunta avalia:**  
Avalia compreensão de otimização, consistência e riscos de reutilizar respostas geradas anteriormente.

**Resposta esperada:**  
O cache pode ser útil quando perguntas iguais ou equivalentes podem receber a mesma resposta durante determinado período.

Ele pode reduzir:

- Número de chamadas ao modelo;
- Custo;
- Latência;
- Carga sobre o provedor.

Porém, não deve ser aplicado sem avaliar:

- Atualização dos dados;
- Identidade e permissões do usuário;
- Informações sensíveis;
- Validade da resposta;
- Tamanho do cache;
- Tempo de expiração;
- Possibilidade de respostas personalizadas.

Uma resposta baseada em documentos atualizados pode ficar incorreta se permanecer no cache por muito tempo.

**Exemplo prático:**  
Uma resposta genérica sobre o horário de atendimento pode ser armazenada por alguns minutos. Já uma resposta baseada em dados privados de um cliente deve ser isolada por usuário e permissões, ou talvez não deva ser armazenada.

**Explicação didática:**  
O cache devolve uma resposta anterior sem executar uma nova chamada.

Isso é vantajoso quando a resposta é estável. Porém, duas perguntas textualmente iguais podem exigir respostas diferentes se o contexto, o usuário ou os dados disponíveis forem diferentes.

A chave do cache precisa considerar os elementos que influenciam o resultado, como:

- Pergunta;
- Idioma;
- Versão do contexto;
- Identidade autorizada;
- Modelo;
- Parâmetros relevantes.

**Como o candidato deve responder:**  

- Relacionar cache a custo e latência;
- Citar tempo de expiração;
- Considerar dados atualizados e permissões;
- Explicar riscos de armazenar informações sensíveis;
- Dar um exemplo de cache adequado e inadequado.

**Resposta fraca ou incompleta:**  
“Eu armazenaria todas as respostas para nunca chamar o modelo novamente.”

Essa estratégia pode retornar informações antigas, expor dados privados e impedir que mudanças sejam refletidas.

**Critérios de avaliação:**  

- **0** — Não entende a finalidade do cache.
- **1** — Acredita que toda resposta pode ser armazenada indefinidamente.
- **2** — Reconhece redução de chamadas, mas ignora consistência.
- **3** — Explica o uso básico e a expiração.
- **4** — Considera contexto, permissões e dados sensíveis.
- **5** — Discute invalidação, versionamento do contexto, escopo da chave e trade-offs de consistência.

**Perguntas de aprofundamento:**  

1. Como evitaria devolver uma resposta privada para outro usuário?
2. Quando uma alteração documental deveria invalidar o cache?
3. Que dados você não colocaria no cache?

---

## Pergunta 39 — Resumo de conversas

**Nível:** Júnior  
**Categoria:** Contexto e desempenho

**Pergunta do entrevistador:**  
Como você reduziria o tamanho de uma conversa longa antes de enviá-la novamente ao modelo?

**O que essa pergunta avalia:**  
Avalia a capacidade de gerenciar contexto, controlar custos e preservar informações importantes.

**Resposta esperada:**  
A aplicação pode:

- Manter apenas as mensagens mais recentes;
- Criar um resumo das mensagens antigas;
- Remover mensagens irrelevantes;
- Armazenar fatos importantes separadamente;
- Recuperar somente o histórico relacionado à pergunta;
- Definir um limite de tokens;
- Dividir conversas em sessões.

O resumo deve preservar informações relevantes, mas também precisa ser tratado como conteúdo gerado pelo modelo e pode conter erros. Informações críticas devem ser verificadas ou armazenadas em fontes estruturadas.

**Explicação didática:**  
Enviar toda a conversa sempre aumenta o contexto, o custo e a latência.

Uma estratégia comum é manter:

- Um resumo da conversa;
- As últimas mensagens;
- Dados importantes recuperados de uma fonte confiável.

O resumo não deve substituir dados transacionais. Por exemplo, o saldo de uma conta deve ser consultado no sistema oficial, não obtido apenas de um resumo antigo.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Histórico completo] --> B{Excede limite?}
    B -- Não --> C[Enviar histórico necessário]
    B -- Sim --> D[Resumir mensagens antigas]
    D --> E[Manter mensagens recentes]
    E --> F[Combinar resumo + mensagens recentes]
    F --> C
~~~

**Como o candidato deve responder:**  

- Mencionar limite de contexto;
- Citar resumo e mensagens recentes;
- Explicar que fatos críticos devem vir de fontes confiáveis;
- Considerar custo e latência;
- Falar sobre privacidade e armazenamento.

**Resposta fraca ou incompleta:**  
“Eu enviaria a conversa inteira, pois o modelo precisa lembrar tudo.”

Essa abordagem pode ultrapassar limites, aumentar custos e enviar informações desnecessárias.

**Critérios de avaliação:**  

- **0** — Não reconhece o problema de conversas longas.
- **1** — Sempre envia todo o histórico.
- **2** — Sabe que precisa reduzir, mas não sugere como.
- **3** — Propõe limitar histórico e utilizar resumo.
- **4** — Considera fatos críticos, custos e privacidade.
- **5** — Apresenta estratégia híbrida com resumo controlado, memória estruturada e recuperação seletiva.

**Perguntas de aprofundamento:**  

1. Como verificaria se um resumo preservou as informações importantes?
2. Que tipo de informação não deveria depender de um resumo gerado?
3. Como controlaria o tamanho do resumo?

---

## Pergunta 40 — Documentação e versionamento de prompts

**Nível:** Júnior  
**Categoria:** Manutenção e boas práticas

**Pergunta do entrevistador:**  
Como você documentaria e controlaria mudanças nos prompts utilizados por uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia maturidade básica de manutenção, rastreabilidade e tratamento de prompts como parte do comportamento da aplicação.

**Resposta esperada:**  
Os prompts devem ser tratados como parte importante da aplicação, principalmente quando influenciam respostas ou decisões de negócio.

A equipe pode:

- Armazenar templates em local versionado;
- Documentar objetivo e entradas esperadas;
- Registrar o modelo e os parâmetros utilizados;
- Criar testes para exemplos conhecidos;
- Registrar alterações relevantes;
- Avaliar o impacto antes da publicação;
- Manter versões compatíveis com diferentes modelos;
- Definir responsáveis pela revisão.

Também é importante não colocar dados reais e sensíveis nos exemplos de teste.

**Explicação didática:**  
Uma pequena mudança no prompt pode alterar significativamente a resposta do modelo.

Por isso, é útil saber:

- Qual versão do prompt gerou determinado resultado;
- Qual modelo estava sendo utilizado;
- Quais parâmetros estavam configurados;
- Quais exemplos foram testados;
- Se houve alteração no contexto ou nos documentos.

Esse controle facilita a investigação de regressões, isto é, comportamentos que pioraram depois de uma mudança.

**Exemplo prático:**

~~~text
Prompt: classificacao-chamados
Versão: 3
Modelo: modelo-exemplo
Objetivo: classificar prioridade e categoria
Alteração: adicionada regra para respostas incertas
Data: 2026-09-03
~~~

A equipe pode comparar resultados de versões diferentes antes de liberar uma alteração para todos os usuários.

**Como o candidato deve responder:**  

- Explicar que prompts devem ser versionados;
- Mencionar testes e exemplos controlados;
- Registrar modelo, parâmetros e objetivo;
- Evitar dados sensíveis;
- Citar avaliação antes da publicação;
- Demonstrar preocupação com rastreabilidade.

**Resposta fraca ou incompleta:**  
“Eu alteraria o prompt diretamente em produção até ficar bom.”

Essa prática dificulta auditoria, testes, reversão e identificação da causa de mudanças no comportamento.

**Critérios de avaliação:**  

- **0** — Não considera necessário documentar prompts.
- **1** — Altera prompts manualmente sem registro.
- **2** — Reconhece documentação, mas não fala sobre testes.
- **3** — Propõe versionamento e registro básico.
- **4** — Inclui avaliação, parâmetros, modelos e dados de teste controlados.
- **5** — Demonstra visão de governança, experimentação, reversão, métricas de qualidade e controle de regressões.

**Perguntas de aprofundamento:**  

1. Como descobriria qual versão do prompt gerou uma resposta problemática?
2. Que testes criaria antes de publicar uma mudança?
3. Como compararia duas versões de um prompt?

---

## Resumo desta parte

- **Perguntas apresentadas:** 31 a 40
- **Perguntas restantes:** 41 a 100
- **Categorias abordadas:** integração, desempenho, segurança, configuração, confiabilidade, manutenção e controle de contexto
- **Competências avaliadas:** chamadas síncronas e assíncronas, validação de endpoints, tratamento de respostas inválidas, separação de responsabilidades, configuração por ambiente, controle de concorrência, fallback, cache, resumo de conversas e versionamento de prompts

A próxima parte deve continuar com as perguntas **41 a 50**, mantendo a mesma estrutura e a numeração sequencial.

---

# Roteiro de Entrevista Técnica — Spring AI

> **Parte 5 de 10**  
> Esta parte contém as perguntas **41 a 50 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

---

## Pergunta 41 — Divisão de responsabilidades em uma aplicação com IA

**Nível:** Júnior  
**Categoria:** Arquitetura e boas práticas

**Pergunta do entrevistador:**  
Como você organizaria uma aplicação Spring Boot que utiliza Spring AI para responder perguntas com base em documentos internos?

**O que essa pergunta avalia:**  
Avalia se o candidato consegue separar responsabilidades entre entrada HTTP, regras de negócio, recuperação de documentos, integração com o modelo e persistência.

**Resposta esperada:**  
Uma organização básica poderia conter:

- **Controller:** recebe a requisição e devolve a resposta HTTP;
- **Service:** coordena o fluxo da aplicação;
- **Componente de recuperação:** busca documentos relevantes;
- **Componente de IA:** monta o prompt e consulta o modelo;
- **Repositório:** acessa documentos, histórico ou banco vetorial;
- **Validador:** verifica entradas e respostas;
- **Componente de observabilidade:** registra métricas e falhas sem expor dados sensíveis.

O controlador não deveria concentrar toda a lógica. A integração com o Spring AI pode ficar isolada em uma classe ou interface própria, facilitando testes e futuras alterações de provedor.

**Explicação didática:**  
Separar responsabilidades significa evitar que uma única classe faça tudo.

Um fluxo possível seria:

~~~mermaid
flowchart LR
    A[Controller] --> B[Service]
    B --> C[Validação]
    B --> D[Recuperação de documentos]
    D --> E[Contexto]
    E --> F[Cliente Spring AI]
    F --> G[Validação da resposta]
    G --> H[Resposta HTTP]
~~~

Essa divisão facilita descobrir onde está um problema. Se nenhum documento for encontrado, a falha provavelmente está na recuperação. Se o modelo retornar erro, a investigação pode se concentrar na integração externa.

**Exemplo prático:**  
O endpoint recebe uma pergunta. O serviço valida o usuário, busca documentos autorizados, monta o contexto, consulta o modelo e valida a resposta antes de devolvê-la.

**Como o candidato deve responder:**  

- Explicar as responsabilidades principais;
- Separar controller, serviço e integração;
- Mencionar validação e segurança;
- Mostrar preocupação com testes e manutenção;
- Evitar criar uma arquitetura excessivamente complexa para um problema simples.

**Resposta fraca ou incompleta:**  
“Eu colocaria tudo no controller para ser mais rápido de desenvolver.”

Essa abordagem pode funcionar em um protótipo muito pequeno, mas dificulta testes, manutenção e evolução.

**Critérios de avaliação:**  

- **0** — Não consegue propor uma organização.
- **1** — Coloca toda a lógica em uma única classe.
- **2** — Menciona controller e service, mas não explica suas responsabilidades.
- **3** — Separa adequadamente as principais camadas.
- **4** — Considera testes, segurança, recuperação e validação.
- **5** — Propõe uma estrutura simples, coesa, testável e adequada ao crescimento da aplicação.

**Perguntas de aprofundamento:**  

1. O que você colocaria no componente responsável pela integração com o modelo?
2. Como testaria o serviço sem acessar o banco vetorial?
3. Quando uma separação adicional de componentes seria realmente necessária?

---

## Pergunta 42 — Uso de uma interface para abstrair o provedor

**Nível:** Júnior  
**Categoria:** Design e manutenção

**Pergunta do entrevistador:**  
Por que pode ser útil criar uma interface própria para encapsular o uso do Spring AI?

**O que essa pergunta avalia:**  
Avalia compreensão de baixo acoplamento, testabilidade e separação entre regra de negócio e infraestrutura.

**Resposta esperada:**  
Uma interface própria pode impedir que toda a aplicação dependa diretamente de detalhes do `ChatClient` ou de classes específicas do provedor.

Por exemplo:

~~~java
public interface GeradorDeTexto {
    String gerar(String instrucao, String pergunta);
}
~~~

A aplicação pode possuir uma implementação baseada no Spring AI:

~~~java
@Service
public class GeradorDeTextoSpringAi implements GeradorDeTexto {

    private final ChatClient chatClient;

    public GeradorDeTextoSpringAi(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String gerar(String instrucao, String pergunta) {
        return chatClient
                .prompt()
                .system(instrucao)
                .user(pergunta)
                .call()
                .content();
    }
}
~~~

Essa abordagem facilita substituir o provedor, criar uma implementação falsa para testes e concentrar configurações.

**Explicação didática:**  
A interface representa o que a aplicação precisa fazer, não como isso será feito.

O serviço de negócio pode depender de `GeradorDeTexto`, sem conhecer os detalhes do Spring AI. Isso reduz o acoplamento, que é a dependência excessiva entre componentes.

Por outro lado, uma interface adicional não deve ser criada apenas por hábito. Em aplicações muito pequenas, ela pode adicionar complexidade sem benefício imediato.

**Como o candidato deve responder:**  

- Explicar abstração e baixo acoplamento;
- Relacionar a interface à testabilidade;
- Mencionar troca de provedor ou implementação;
- Reconhecer que a abstração deve trazer benefício real;
- Evitar afirmar que toda aplicação obrigatoriamente precisa dessa interface.

**Resposta fraca ou incompleta:**  
“Eu criaria uma interface porque toda classe deve ter uma interface.”

A decisão deve considerar necessidade de substituição, testes, evolução e complexidade do projeto.

**Critérios de avaliação:**  

- **0** — Não entende a finalidade da interface.
- **1** — Apresenta justificativas incorretas.
- **2** — Reconhece reutilização, mas não explica o benefício.
- **3** — Relaciona a interface ao desacoplamento e aos testes.
- **4** — Considera troca de provedor e implementação falsa.
- **5** — Avalia corretamente os benefícios e também o custo de abstrações desnecessárias.

**Perguntas de aprofundamento:**  

1. Como você criaria uma implementação falsa para os testes?
2. Em que situação essa interface poderia ser excesso de engenharia?
3. Que responsabilidades não colocaria nessa interface?

---

## Pergunta 43 — Sanitização de documentos

**Nível:** Júnior  
**Categoria:** Segurança e preparação de dados

**Pergunta do entrevistador:**  
Quais cuidados você teria ao preparar documentos antes de indexá-los para uso em uma aplicação RAG?

**O que essa pergunta avalia:**  
Avalia conhecimento básico de qualidade de dados, privacidade, segurança e preparação de conteúdo.

**Resposta esperada:**  
Antes da indexação, a aplicação deve considerar:

- Remoção de conteúdo desnecessário;
- Identificação de dados pessoais;
- Verificação de permissões;
- Tratamento de documentos duplicados;
- Extração correta do texto;
- Preservação de títulos e seções;
- Inclusão de metadados;
- Identificação da versão e data de atualização;
- Divisão adequada em trechos;
- Validação do conteúdo extraído.

Documentos não autorizados ou desatualizados não devem ser indexados simplesmente porque estão disponíveis em uma pasta.

**Explicação didática:**  
A qualidade da resposta depende, em grande parte, da qualidade dos documentos recuperados.

Um arquivo pode conter:

- Texto oculto;
- Informações antigas;
- Dados pessoais;
- Cabeçalhos repetidos;
- Páginas duplicadas;
- Tabelas extraídas incorretamente;
- Informações contraditórias.

Se esses problemas não forem tratados, o modelo poderá receber um contexto incorreto ou confuso.

**Exemplo prático:**  
Antes de indexar uma política interna, a aplicação pode:

1. Confirmar que o documento foi aprovado;
2. Remover informações temporárias;
3. Registrar o departamento responsável;
4. Associar a data de vigência;
5. Dividir o conteúdo em trechos;
6. Armazenar os metadados de acesso.

**Como o candidato deve responder:**  

- Mencionar qualidade e atualização dos documentos;
- Citar dados sensíveis e controle de acesso;
- Explicar a importância de metadados;
- Relacionar o processo ao chunking;
- Demonstrar que indexar não significa confiar automaticamente no conteúdo.

**Resposta fraca ou incompleta:**  
“Eu indexaria todos os arquivos da pasta para garantir que nada fosse perdido.”

Essa prática pode incluir documentos privados, duplicados, inválidos ou desatualizados.

**Critérios de avaliação:**  

- **0** — Não identifica riscos no processo.
- **1** — Apenas converte os arquivos para texto.
- **2** — Menciona divisão dos documentos, mas ignora segurança.
- **3** — Considera limpeza, atualização e metadados.
- **4** — Inclui privacidade, permissões e qualidade da extração.
- **5** — Apresenta um processo controlado de ingestão, versionamento, auditoria e validação.

**Perguntas de aprofundamento:**  

1. Como trataria documentos com versões conflitantes?
2. O que faria com um documento que contém dados pessoais desnecessários?
3. Como impediria a indexação de arquivos sem autorização?

---

## Pergunta 44 — Similaridade e relevância dos documentos

**Nível:** Júnior  
**Categoria:** RAG e troubleshooting

**Pergunta do entrevistador:**  
O que você faria se uma aplicação RAG estivesse recuperando documentos que parecem relacionados, mas não respondem à pergunta do usuário?

**O que essa pergunta avalia:**  
Avalia capacidade de investigar a qualidade da recuperação e compreender que similaridade semântica não garante relevância suficiente.

**Resposta esperada:**  
O candidato deveria investigar:

- A pergunta utilizada na busca;
- O modelo de embedding;
- O tamanho dos trechos;
- A quantidade de resultados recuperados;
- Os metadados e filtros;
- A qualidade dos documentos;
- A medida de similaridade;
- O limite mínimo de relevância;
- A existência de informações contraditórias.

Possíveis ajustes incluem:

- Melhorar o processo de chunking;
- Alterar a quantidade de resultados;
- Adicionar filtros por metadados;
- Reformular a consulta;
- Usar uma etapa adicional de reranking, quando disponível;
- Remover documentos ruins;
- Exibir ou registrar as fontes recuperadas para análise.

**Explicação didática:**  
A busca semântica encontra conteúdos próximos em significado, mas “parecido” não significa necessariamente “útil”.

Por exemplo, uma pergunta sobre reembolso pode recuperar documentos sobre pagamentos, mas não sobre o prazo específico de reembolso.

Um fluxo de investigação pode ser representado assim:

~~~mermaid
flowchart TD
    A[Pergunta] --> B[Gerar embedding]
    B --> C[Buscar candidatos]
    C --> D{Resultados relevantes?}
    D -- Sim --> E[Montar contexto]
    D -- Não --> F[Revisar consulta, trechos e filtros]
    F --> C
~~~

Também é importante medir a qualidade com exemplos reais, e não apenas observar uma única pergunta.

**Como o candidato deve responder:**  

- Verificar documentos recuperados e respectivas fontes;
- Considerar embeddings, chunking e metadados;
- Explicar que aumentar a quantidade de documentos nem sempre resolve;
- Mencionar testes com perguntas reais;
- Diferenciar recuperação de geração da resposta.

**Resposta fraca ou incompleta:**  
“Eu enviaria mais documentos para o modelo.”

Isso pode aumentar o ruído, o custo e a confusão do modelo.

**Critérios de avaliação:**  

- **0** — Não apresenta estratégia de investigação.
- **1** — Culpa apenas o modelo de linguagem.
- **2** — Sugere aumentar resultados sem analisar a recuperação.
- **3** — Investiga embeddings, trechos e filtros.
- **4** — Considera métricas, fontes e qualidade dos documentos.
- **5** — Propõe uma análise sistemática de recuperação, com avaliação, ajustes e controle de ruído.

**Perguntas de aprofundamento:**  

1. Como saberia se o problema está na busca ou na geração?
2. Por que recuperar documentos demais pode piorar a resposta?
3. Como criaria um conjunto de perguntas para avaliar a recuperação?

---

## Pergunta 45 — Filtros por metadados

**Nível:** Júnior  
**Categoria:** RAG e segurança

**Pergunta do entrevistador:**  
Em que situação você utilizaria filtros por metadados antes de realizar uma busca semântica?

**O que essa pergunta avalia:**  
Avalia entendimento de filtragem, eficiência da busca e controle de escopo dos documentos.

**Resposta esperada:**  
Filtros por metadados são úteis quando a aplicação já conhece restrições que devem ser aplicadas antes da busca, como:

- Departamento;
- Tenant;
- Idioma;
- Tipo de documento;
- Data de vigência;
- Categoria;
- Nível de acesso;
- Identificador do cliente.

Por exemplo, uma pergunta de um usuário do departamento financeiro pode ser limitada aos documentos que ele tem permissão para consultar.

A filtragem reduz o conjunto de candidatos e pode melhorar segurança, desempenho e relevância.

**Explicação didática:**  
Sem filtro, a busca semântica pode encontrar um documento muito parecido, mas pertencente a outra organização ou com acesso restrito.

O filtro deve ser definido com base em dados confiáveis da sessão autenticada, e não em um valor fornecido livremente pelo usuário.

Um fluxo simplificado seria:

~~~mermaid
flowchart LR
    A[Usuário autenticado] --> B[Obter permissões]
    B --> C[Construir filtros confiáveis]
    C --> D[Buscar documentos permitidos]
    D --> E[Aplicar similaridade]
    E --> F[Montar contexto]
~~~

Em alguns casos, filtros podem ser combinados com busca vetorial. A forma exata depende do banco vetorial e da integração disponível.

**Como o candidato deve responder:**  

- Citar segurança e relevância;
- Dar exemplos de metadados;
- Explicar que filtros devem vir da identidade autorizada;
- Diferenciar filtro conhecido de busca semântica;
- Mencionar testes de isolamento.

**Resposta fraca ou incompleta:**  
“Eu deixaria o usuário informar o departamento que deseja consultar.”

Isso poderia permitir que ele alterasse o escopo de acesso sem autorização.

**Critérios de avaliação:**  

- **0** — Não entende o uso de filtros.
- **1** — Utiliza filtros apenas por conveniência visual.
- **2** — Cita categorias, mas ignora a origem confiável dos filtros.
- **3** — Explica corretamente filtragem por metadados.
- **4** — Relaciona filtros à segurança, desempenho e relevância.
- **5** — Discute autorização, multi-tenancy, consistência dos metadados e testes de isolamento.

**Perguntas de aprofundamento:**  

1. De onde deveriam vir os filtros de permissão?
2. O que aconteceria se um documento tivesse metadados incorretos?
3. Como testaria a filtragem em uma aplicação multiempresa?

---

## Pergunta 46 — Conteúdo fora do contexto

**Nível:** Júnior  
**Categoria:** Prompts e confiabilidade

**Pergunta do entrevistador:**  
Como você orientaria o modelo a responder quando os documentos recuperados não contêm informação suficiente para responder à pergunta?

**O que essa pergunta avalia:**  
Avalia a capacidade de lidar com ausência de informação e reduzir respostas inventadas.

**Resposta esperada:**  
O prompt pode instruir o modelo a:

- Utilizar somente o contexto fornecido;
- Não inventar informações;
- Informar quando os dados forem insuficientes;
- Diferenciar fato encontrado de inferência;
- Solicitar esclarecimentos quando necessário;
- Encaminhar o usuário para atendimento humano em situações específicas.

A aplicação também pode verificar se nenhum documento foi recuperado e decidir retornar uma resposta alternativa antes de consultar o modelo.

**Exemplo de instrução:**

~~~text
Responda somente com base no contexto fornecido.
Se o contexto não contiver informação suficiente,
informe que não foi possível encontrar uma resposta confiável.
Não invente políticas, prazos ou valores.
~~~

Essa instrução ajuda, mas não garante comportamento perfeito. A aplicação deve continuar validando a resposta.

**Explicação didática:**  
Um modelo pode tentar ser útil mesmo quando não possui informação suficiente. Isso pode resultar em uma resposta plausível, porém incorreta.

Uma estratégia segura combina:

1. Busca de documentos;
2. Avaliação mínima da relevância;
3. Prompt com instruções claras;
4. Validação da resposta;
5. Possibilidade de revisão humana.

**Como o candidato deve responder:**  

- Explicar o comportamento esperado diante da ausência de contexto;
- Mencionar instruções contra invenção;
- Considerar resposta alternativa ou atendimento humano;
- Reforçar que o prompt não oferece garantia absoluta;
- Evitar afirmar que basta usar uma frase específica.

**Resposta fraca ou incompleta:**  
“Eu pediria para o modelo responder mesmo assim usando o conhecimento geral.”

Essa abordagem pode gerar informações não autorizadas, antigas ou incorretas.

**Critérios de avaliação:**  

- **0** — Não reconhece o risco.
- **1** — Aceita qualquer resposta do modelo.
- **2** — Menciona “não inventar”, mas não propõe controles.
- **3** — Define comportamento para ausência de informação.
- **4** — Combina instruções, filtros, validação e fallback.
- **5** — Discute limiar de relevância, rastreabilidade, revisão humana e impacto do domínio.

**Perguntas de aprofundamento:**  

1. Como decidiria que os documentos recuperados são insuficientes?
2. O que exibiria ao usuário nessa situação?
3. Como evitaria que uma resposta de fallback também transmitisse informação incorreta?

---

## Pergunta 47 — Proteção contra prompt injection

**Nível:** Júnior  
**Categoria:** Segurança

**Pergunta do entrevistador:**  
O que é prompt injection e quais medidas básicas você adotaria para reduzir esse risco em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia conscientização sobre manipulação de instruções, separação entre dados e comandos e defesa em profundidade.

**Resposta esperada:**  
Prompt injection ocorre quando uma entrada tenta manipular o modelo para ignorar instruções, revelar informações ou realizar ações não previstas.

Exemplos incluem solicitações para:

- Ignorar regras do sistema;
- Revelar o prompt interno;
- Exibir documentos confidenciais;
- Executar ferramentas sem autorização;
- Tratar um documento malicioso como instrução prioritária.

Medidas básicas incluem:

- Não confiar somente no prompt;
- Validar autenticação e autorização no código;
- Separar dados recuperados de instruções da aplicação;
- Limitar ferramentas disponíveis;
- Validar argumentos;
- Restringir documentos recuperados;
- Não enviar segredos ao modelo;
- Validar respostas antes de executar ações;
- Solicitar confirmação para operações sensíveis.

**Explicação didática:**  
O modelo processa texto. Se um documento recuperado contém frases como “ignore todas as regras anteriores”, ele pode tentar interpretá-las como instruções.

Por isso, documentos devem ser tratados como dados, e não como autoridade para alterar as regras da aplicação.

A aplicação não deve permitir que uma mensagem determine diretamente permissões ou operações críticas.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Entrada do usuário] --> B[Autenticação]
    B --> C[Validação e limites]
    C --> D[Recuperar dados autorizados]
    D --> E[Consultar modelo]
    E --> F[Validar saída]
    F --> G{Ação sensível?}
    G -- Sim --> H[Solicitar confirmação]
    G -- Não --> I[Retornar resposta]
~~~

**Como o candidato deve responder:**  

- Definir prompt injection;
- Dar um exemplo de tentativa de manipulação;
- Explicar que prompts não substituem controles;
- Mencionar autorização, validação e limitação de ferramentas;
- Diferenciar resposta textual de ação com efeito colateral.

**Resposta fraca ou incompleta:**  
“Eu escreveria no prompt para o modelo ignorar qualquer tentativa de ataque.”

Essa instrução pode ajudar, mas não é suficiente como controle de segurança.

**Critérios de avaliação:**  

- **0** — Não reconhece o risco.
- **1** — Confunde o ataque com erro de rede.
- **2** — Identifica manipulação, mas depende apenas do prompt.
- **3** — Explica o risco e cita controles básicos.
- **4** — Considera autorização, ferramentas, dados e validação.
- **5** — Apresenta defesa em profundidade, confirmação humana, auditoria e limitação de efeitos colaterais.

**Perguntas de aprofundamento:**  

1. Como impediria que um documento recuperado alterasse as regras do sistema?
2. Que ferramentas não deveriam ser expostas diretamente ao modelo?
3. Como testaria a aplicação contra tentativas de prompt injection?

---

## Pergunta 48 — Resposta em formato JSON

**Nível:** Júnior  
**Categoria:** Integração e validação

**Pergunta do entrevistador:**  
Como você trataria uma resposta esperada em JSON quando o modelo retorna texto adicional ou um formato inválido?

**O que essa pergunta avalia:**  
Avalia conhecimento de validação de saída, conversão de dados e tratamento de respostas probabilísticas.

**Resposta esperada:**  
A aplicação deve:

1. Receber a resposta;
2. Validar se o conteúdo existe;
3. Interpretar o formato;
4. Verificar os campos obrigatórios;
5. Validar tipos e valores;
6. Rejeitar ou tratar respostas inválidas;
7. Registrar o problema sem expor dados sensíveis.

Não se deve assumir que uma resposta visualmente parecida com JSON é válida.

Se o modelo retornar texto antes ou depois do JSON, a aplicação pode tentar utilizar um formato estruturado suportado pelo provedor ou aplicar um tratamento cuidadosamente validado. Porém, remover texto de maneira ingênua pode ocultar erros ou aceitar conteúdo malformado.

**Exemplo de código:**

~~~java
public record RespostaClassificacao(
        String categoria,
        String prioridade
) {}

public RespostaClassificacao interpretar(String conteudo) {
    if (conteudo == null || conteudo.isBlank()) {
        throw new IllegalArgumentException("Resposta vazia");
    }

    // A desserialização real deve utilizar um conversor JSON apropriado.
    // Depois da conversão, os campos também devem ser validados.
    return desserializarJson(conteudo);
}

private RespostaClassificacao desserializarJson(String conteudo) {
    throw new UnsupportedOperationException("Exemplo ilustrativo");
}
~~~

O tratamento exato depende da biblioteca e da versão utilizadas.

**Como o candidato deve responder:**  

- Explicar que JSON precisa ser validado;
- Mencionar campos obrigatórios e tipos;
- Considerar texto adicional e conteúdo inválido;
- Propor fallback ou revisão;
- Evitar confiar apenas no prompt.

**Resposta fraca ou incompleta:**  
“Eu faria um `substring` para pegar o que estiver entre chaves.”

Essa abordagem pode falhar com conteúdo aninhado, texto inválido, chaves dentro de strings ou respostas malformadas.

**Critérios de avaliação:**  

- **0** — Não valida a resposta.
- **1** — Usa o conteúdo como se fosse sempre válido.
- **2** — Reconhece JSON inválido, mas não explica o tratamento.
- **3** — Propõe desserialização e validação básicas.
- **4** — Considera campos, tipos, erros e fallback.
- **5** — Discute contratos de saída, compatibilidade, observabilidade, segurança e revisão de respostas inválidas.

**Perguntas de aprofundamento:**  

1. O que faria se faltasse um campo obrigatório?
2. Como impediria valores inesperados em um campo de enumeração?
3. Quando faria uma nova tentativa de geração?

---

## Pergunta 49 — Dados históricos e informação atualizada

**Nível:** Júnior  
**Categoria:** RAG e integração com sistemas

**Pergunta do entrevistador:**  
Por que uma aplicação Spring AI pode precisar consultar uma fonte externa em vez de depender apenas do conhecimento do modelo?

**O que essa pergunta avalia:**  
Avalia se o candidato entende limitações de atualização, dados transacionais e necessidade de fontes confiáveis.

**Resposta esperada:**  
O conhecimento do modelo pode:

- Não incluir informações recentes;
- Não conter dados privados da organização;
- Não refletir o estado atual de um sistema;
- Apresentar limites de data;
- Não ser adequado para dados transacionais.

Por isso, a aplicação pode consultar bancos de dados, APIs internas, documentos atualizados ou ferramentas antes de gerar a resposta.

Exemplos de dados que devem vir de uma fonte oficial:

- Saldo de uma conta;
- Status de um pedido;
- Disponibilidade de estoque;
- Preço atual;
- Situação de um contrato;
- Permissão de um usuário.

O modelo pode ajudar a interpretar ou apresentar o resultado, mas não deve ser a fonte oficial desses dados.

**Explicação didática:**  
Existe uma diferença entre conhecimento geral e estado atual.

Perguntar “o que é uma transação?” pode ser respondido com conhecimento geral. Já perguntar “qual é o saldo da conta de Bianeck?” exige consultar um sistema autorizado e atualizado.

Um fluxo possível seria:

~~~mermaid
sequenceDiagram
    participant U as Usuário
    participant A as Aplicação
    participant S as Sistema oficial
    participant M as Modelo

    U->>A: Solicita status do pedido
    A->>A: Valida identidade e permissão
    A->>S: Consulta status atual
    S-->>A: Retorna dados
    A->>M: Solicita explicação dos dados
    M-->>A: Gera texto
    A-->>U: Exibe resposta
~~~

A aplicação deve impedir que o modelo invente ou substitua os dados retornados pelo sistema oficial.

**Como o candidato deve responder:**  

- Diferenciar conhecimento geral de informação atual;
- Citar sistemas oficiais e dados transacionais;
- Mencionar autorização;
- Explicar o uso de ferramentas, APIs ou RAG;
- Reforçar que o modelo não deve ser a fonte de verdade para dados críticos.

**Resposta fraca ou incompleta:**  
“Se o modelo foi treinado com muitos dados, ele saberá o valor atual.”

Essa afirmação é insegura e ignora atualização, privacidade e acesso a dados internos.

**Critérios de avaliação:**  

- **0** — Não reconhece a limitação.
- **1** — Confia integralmente no conhecimento do modelo.
- **2** — Reconhece dados recentes, mas não propõe integração.
- **3** — Explica a necessidade de fontes externas.
- **4** — Considera APIs, ferramentas, autorização e dados transacionais.
- **5** — Propõe claramente uma arquitetura em que o modelo interpreta informações, mas a aplicação mantém a fonte oficial e os controles.

**Perguntas de aprofundamento:**  

1. Você permitiria que o modelo informasse diretamente o saldo de uma conta?
2. Como garantiria que a consulta fosse feita para o usuário correto?
3. O que faria se o sistema oficial estivesse indisponível?

---

## Pergunta 50 — Checklist antes de colocar uma funcionalidade de IA em produção

**Nível:** Júnior  
**Categoria:** Operação, segurança e qualidade

**Pergunta do entrevistador:**  
Quais verificações você faria antes de disponibilizar em produção uma funcionalidade Spring AI que responde perguntas de usuários?

**O que essa pergunta avalia:**  
Avalia a capacidade do candidato de reunir conhecimentos de segurança, testes, desempenho, custos, observabilidade e experiência do usuário.

**Resposta esperada:**  
Um checklist básico deveria incluir:

- Entradas validadas;
- Autenticação e autorização funcionando;
- Chaves protegidas;
- Dados sensíveis tratados;
- Prompts versionados;
- Respostas validadas;
- Erros e timeouts tratados;
- Limites de uso configurados;
- Custos monitorados;
- Logs sem segredos ou dados desnecessários;
- Testes unitários e de integração realizados;
- Casos de respostas incorretas avaliados;
- Fallback ou comportamento de indisponibilidade definido;
- Documentos e fontes atualizados;
- Métricas e alertas configurados;
- Comunicação clara ao usuário sobre limitações.

A profundidade da avaliação deve ser proporcional ao risco da funcionalidade.

**Explicação didática:**  
Uma demonstração que funciona localmente não está necessariamente pronta para produção.

Em produção, a aplicação precisa lidar com:

- Muitos usuários;
- Falhas de rede;
- Provedores indisponíveis;
- Entradas maliciosas;
- Custos inesperados;
- Dados privados;
- Respostas incorretas;
- Mudanças de modelo;
- Necessidade de auditoria.

Um fluxo de liberação pode ser representado assim:

~~~mermaid
flowchart TD
    A[Desenvolvimento] --> B[Testes unitários]
    B --> C[Testes de integração]
    C --> D[Avaliação de segurança]
    D --> E[Avaliação de custo e desempenho]
    E --> F[Observabilidade configurada]
    F --> G[Liberação gradual]
    G --> H[Monitoramento em produção]
    H --> I{Problema relevante?}
    I -- Sim --> J[Reverter ou ajustar]
    I -- Não --> K[Manter acompanhamento]
~~~

A liberação gradual permite observar o comportamento com um grupo limitado de usuários antes de ampliar o uso.

**Como o candidato deve responder:**  

- Organizar a resposta por temas;
- Citar segurança, testes, custos e observabilidade;
- Mencionar respostas incorretas e indisponibilidade;
- Considerar limites e experiência do usuário;
- Mostrar que produção exige acompanhamento contínuo;
- Evitar dizer apenas que “basta testar o endpoint”.

**Resposta fraca ou incompleta:**  
“Eu verificaria se o endpoint responde corretamente e faria o deploy.”

Essa resposta ignora riscos de segurança, custo, escala, qualidade e operação.

**Critérios de avaliação:**  

- **0** — Não apresenta verificações relevantes.
- **1** — Considera apenas se o código compila.
- **2** — Menciona testes, mas ignora operação e segurança.
- **3** — Cobre validação, testes e tratamento de erros.
- **4** — Inclui custos, observabilidade, limites e proteção de dados.
- **5** — Apresenta um checklist equilibrado de qualidade, segurança, confiabilidade, desempenho e governança.

**Perguntas de aprofundamento:**  

1. Quais métricas acompanharia após a liberação?
2. Como reagiria a um aumento repentino de custo?
3. Que condições justificariam reverter a funcionalidade?

---

## Resumo desta parte

- **Perguntas apresentadas:** 41 a 50
- **Perguntas restantes:** 51 a 100
- **Categorias abordadas:** arquitetura, design, segurança, RAG, troubleshooting, integração, validação, operação e qualidade
- **Competências avaliadas:** organização de aplicações Spring AI, abstração de provedores, preparação de documentos, relevância de busca, filtros por metadados, ausência de contexto, prompt injection, validação de JSON, uso de fontes atualizadas e preparação para produção

A próxima parte deve continuar com as perguntas **51 a 60**, mantendo a mesma estrutura e a numeração sequencial.

---

# Roteiro de Entrevista Técnica — Spring AI

> **Parte 6 de 10**  
> Esta parte contém as perguntas **51 a 60 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

---

## Pergunta 51 — Diferença entre IA generativa e automação tradicional

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Qual é a diferença entre utilizar IA generativa com Spring AI e implementar uma automação baseada apenas em regras fixas?

**O que essa pergunta avalia:**  
Avalia se o candidato entende as características da IA generativa e consegue escolher uma abordagem adequada ao problema.

**Resposta esperada:**  
Uma automação baseada em regras utiliza condições previamente definidas e normalmente apresenta comportamento previsível. Por exemplo, se um campo estiver vazio, o sistema rejeita a requisição.

A IA generativa utiliza modelos capazes de interpretar e produzir linguagem natural, sendo útil para tarefas como:

- Resumo de textos;
- Geração de respostas;
- Classificação flexível;
- Extração de informações;
- Conversas;
- Reformulação de conteúdo.

A IA generativa pode lidar melhor com dados não estruturados, mas também pode apresentar respostas variadas ou incorretas.

Regras fixas são mais adequadas quando o comportamento precisa ser determinístico, auditável e previsível. A IA é mais útil quando existe ambiguidade ou necessidade de interpretação de linguagem natural.

**Explicação didática:**  
Considere uma validação de idade:

- Regra tradicional: verificar se `idade >= 18`;
- IA generativa: interpretar uma mensagem como “sou maior de idade e quero criar minha conta”.

A regra tradicional é mais simples, barata e confiável para a decisão final. A IA poderia ajudar a interpretar a mensagem, mas a autorização deveria continuar sendo feita por código.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Solicitação] --> B{Problema possui regra clara?}
    B -- Sim --> C[Usar lógica determinística]
    B -- Não --> D{Envolve linguagem natural?}
    D -- Sim --> E[Considerar IA generativa]
    D -- Não --> F[Analisar outra solução]
    E --> G[Validar resultado]
    G --> H[Aplicar regras de negócio]
~~~

**Como o candidato deve responder:**  

- Diferenciar comportamento determinístico e probabilístico;
- Dar exemplos de uso para cada abordagem;
- Mencionar previsibilidade, custo e auditabilidade;
- Explicar que IA não deve substituir regras críticas;
- Mostrar como as duas abordagens podem ser combinadas.

**Resposta fraca ou incompleta:**  
“IA é melhor porque consegue resolver problemas mais complexos.”

A resposta é genérica e ignora custo, previsibilidade, segurança e adequação ao problema.

**Critérios de avaliação:**  

- **0** — Não diferencia as abordagens.
- **1** — Acredita que IA sempre é superior.
- **2** — Reconhece regras fixas, mas não explica suas vantagens.
- **3** — Diferencia corretamente automação tradicional e IA generativa.
- **4** — Considera custo, confiabilidade e casos de uso.
- **5** — Propõe uma abordagem híbrida e explica os trade-offs com clareza.

**Perguntas de aprofundamento:**  

1. Em que situação uma regra fixa seria preferível à IA?
2. Como combinaria IA generativa com validações determinísticas?
3. Quais riscos existem ao usar IA para decisões críticas?

---

## Pergunta 52 — Contextualização de uma resposta

**Nível:** Júnior  
**Categoria:** Prompts e prática

**Pergunta do entrevistador:**  
Como você forneceria contexto adicional ao modelo para melhorar a qualidade de uma resposta em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia a capacidade de montar uma solicitação com instruções, dados relevantes e pergunta do usuário.

**Resposta esperada:**  
O contexto pode ser fornecido por meio de:

- Informações recuperadas de documentos;
- Histórico da conversa;
- Dados de uma API;
- Metadados;
- Regras de negócio;
- Exemplos de entrada e saída;
- Informações fornecidas pelo usuário.

A aplicação deve incluir somente informações relevantes e autorizadas. Contexto excessivo pode aumentar custos, latência e confusão.

Um fluxo comum é:

1. Receber a pergunta;
2. Buscar dados relacionados;
3. Validar se o usuário tem acesso;
4. Montar o prompt;
5. Enviar o contexto e a pergunta ao modelo;
6. Validar a resposta.

**Explicação didática:**  
O modelo não conhece automaticamente os dados internos da aplicação. Se ele precisa responder com base em uma política corporativa, essa política deve ser recuperada e incluída no contexto.

O contexto precisa ser:

- Relevante;
- Atualizado;
- Autorizado;
- Suficientemente completo;
- Pequeno o bastante para respeitar o limite do modelo.

**Exemplo prático:**

~~~text
Instrução:
Responda apenas com base no contexto.

Contexto:
A empresa permite o parcelamento em até seis vezes.

Pergunta:
Em quantas vezes posso parcelar?
~~~

O contexto orienta a resposta, mas a aplicação ainda deve tratar casos de ausência ou contradição de informações.

**Como o candidato deve responder:**  

- Explicar o que é contexto;
- Citar fontes internas, histórico ou APIs;
- Mencionar autorização e relevância;
- Relacionar o contexto ao RAG;
- Ressaltar que mais contexto nem sempre significa melhor resposta.

**Resposta fraca ou incompleta:**  
“Eu enviaria todos os dados disponíveis para o modelo.”

Isso pode causar aumento de custo, exposição de dados e respostas confusas.

**Critérios de avaliação:**  

- **0** — Não sabe explicar como fornecer contexto.
- **1** — Acredita que o modelo conhece automaticamente os dados internos.
- **2** — Menciona adicionar texto, mas ignora relevância e segurança.
- **3** — Explica corretamente a inclusão de contexto.
- **4** — Considera fontes, permissões, tamanho e atualização.
- **5** — Estrutura um fluxo completo de recuperação, autorização, montagem e validação.

**Perguntas de aprofundamento:**  

1. Como escolheria quais informações incluir?
2. O que faria se duas fontes apresentassem informações diferentes?
3. Como evitaria incluir dados de outro usuário no contexto?

---

## Pergunta 53 — Histórico por identificador de conversa

**Nível:** Júnior  
**Categoria:** Estado e persistência

**Pergunta do entrevistador:**  
Como você garantiria que as mensagens enviadas ao modelo pertencessem à conversa correta?

**O que essa pergunta avalia:**  
Avalia compreensão de gerenciamento de estado, identificação de conversas e isolamento entre usuários.

**Resposta esperada:**  
A aplicação deve associar cada conversa a um identificador único e verificar se o usuário autenticado tem permissão para acessá-la.

Um fluxo possível seria:

1. Receber o identificador da conversa;
2. Validar o usuário autenticado;
3. Consultar a conversa;
4. Verificar a propriedade ou permissão;
5. Recuperar o histórico correspondente;
6. Adicionar a nova mensagem;
7. Enviar somente o histórico autorizado ao modelo;
8. Persistir a interação.

O identificador sozinho não deve ser considerado uma autorização. Um usuário mal-intencionado poderia tentar adivinhar o identificador de outra conversa.

**Explicação didática:**  
Imagine duas pessoas utilizando o mesmo chatbot. O histórico de uma não pode ser enviado junto com a pergunta da outra.

A aplicação precisa controlar tanto:

- **Identidade:** quem está fazendo a solicitação;
- **Conversa:** qual histórico está sendo acessado;
- **Permissão:** se aquela pessoa pode visualizar ou modificar o histórico.

**Exemplo prático:**

~~~mermaid
sequenceDiagram
    participant U as Usuário
    participant A as Aplicação
    participant B as Banco de histórico
    participant M as Modelo

    U->>A: Envia conversationId e pergunta
    A->>A: Autentica usuário
    A->>B: Busca conversa
    B-->>A: Retorna histórico
    A->>A: Verifica permissão
    A->>M: Envia histórico autorizado
    M-->>A: Retorna resposta
    A->>B: Salva nova interação
    A-->>U: Exibe resposta
~~~

**Como o candidato deve responder:**  

- Mencionar identificador único;
- Explicar que o identificador não substitui autorização;
- Considerar persistência;
- Falar sobre isolamento entre usuários;
- Citar testes para impedir acesso indevido.

**Resposta fraca ou incompleta:**  
“Eu buscaria o histórico usando o `conversationId` informado.”

A resposta não verifica se o usuário tem permissão para acessar aquela conversa.

**Critérios de avaliação:**  

- **0** — Não identifica o problema de isolamento.
- **1** — Confia apenas no identificador enviado.
- **2** — Menciona autenticação, mas não relaciona ao histórico.
- **3** — Associa conversa, usuário e histórico corretamente.
- **4** — Considera persistência, autorização e testes.
- **5** — Demonstra compreensão de isolamento, multiusuário, auditoria e prevenção de enumeração de identificadores.

**Perguntas de aprofundamento:**  

1. Por que o `conversationId` não deve ser tratado como segredo?
2. Onde armazenaria o histórico em uma aplicação com várias instâncias?
3. Como testaria o acesso entre conversas diferentes?

---

## Pergunta 54 — Uso de memória em conversas

**Nível:** Júnior  
**Categoria:** Conversação e desempenho

**Pergunta do entrevistador:**  
O que significa utilizar memória em uma aplicação conversacional com Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende que a aplicação precisa preservar informações relevantes para manter continuidade entre interações.

**Resposta esperada:**  
Memória representa o mecanismo utilizado para manter informações de interações anteriores e fornecê-las novamente quando necessário.

Ela pode incluir:

- Mensagens recentes;
- Resumos;
- Preferências do usuário;
- Fatos importantes;
- Histórico persistido;
- Informações recuperadas de uma fonte externa.

A memória não precisa conter toda a conversa. A aplicação pode selecionar o que é relevante para controlar custo, privacidade e limite de contexto.

Também é necessário distinguir memória conversacional de dados oficiais. Informações como saldo, preço ou status de pedido devem ser consultadas na fonte correta.

**Explicação didática:**  
Uma memória simples pode manter as últimas mensagens. Uma memória mais elaborada pode manter um resumo ou buscar informações antigas quando necessário.

Exemplo:

- Mensagens recentes: últimos cinco turnos;
- Resumo: objetivo da conversa;
- Fonte oficial: dados atuais do cliente.

Essa combinação pode preservar continuidade sem enviar toda a conversa a cada chamada.

**Exemplo prático:**  
Um assistente pode lembrar que o usuário prefere respostas em português, mas deve consultar novamente o sistema oficial para verificar o status atual de uma entrega.

**Como o candidato deve responder:**  

- Definir memória como contexto persistido ou recuperado;
- Citar mensagens recentes, resumo e fatos;
- Relacionar memória a custo e limite de contexto;
- Diferenciar memória de fonte oficial;
- Considerar privacidade e autorização.

**Resposta fraca ou incompleta:**  
“Memória significa que o modelo aprende permanentemente tudo que o usuário fala.”

Isso confunde o histórico da aplicação com treinamento ou alteração permanente do modelo.

**Critérios de avaliação:**  

- **0** — Não entende o conceito.
- **1** — Confunde memória com treinamento automático.
- **2** — Reconhece histórico, mas não explica gerenciamento.
- **3** — Explica corretamente memória conversacional.
- **4** — Considera resumo, persistência, custo e privacidade.
- **5** — Diferencia memória, contexto e fonte oficial, propondo uma estratégia adequada ao caso de uso.

**Perguntas de aprofundamento:**  

1. Que informações você não armazenaria como memória?
2. Como reduziria o tamanho da memória?
3. Como permitiria que o usuário apagasse seu histórico?

---

## Pergunta 55 — Moderação de conteúdo

**Nível:** Júnior  
**Categoria:** Segurança e qualidade

**Pergunta do entrevistador:**  
Que cuidados você teria para evitar que uma aplicação Spring AI gerasse ou processasse conteúdo inadequado?

**O que essa pergunta avalia:**  
Avalia consciência sobre políticas de uso, validação de entrada e saída e necessidade de controles além do prompt.

**Resposta esperada:**  
A aplicação pode utilizar uma combinação de:

- Validação das entradas;
- Classificação de conteúdo;
- Filtros de termos ou padrões;
- Políticas específicas do provedor;
- Validação da resposta;
- Limitação de funcionalidades;
- Revisão humana;
- Registro de eventos relevantes;
- Bloqueio de ações perigosas.

Os controles devem ser proporcionais ao risco da aplicação. Um chatbot interno de baixo risco pode exigir controles diferentes de uma aplicação voltada a crianças, saúde, finanças ou suporte jurídico.

Não se deve confiar apenas em uma instrução no prompt para impedir conteúdo inadequado.

**Explicação didática:**  
A entrada pode tentar solicitar conteúdo proibido ou induzir a aplicação a executar uma ação perigosa. A saída também pode conter informações ofensivas, discriminatórias ou inadequadas.

Por isso, é importante analisar:

- O conteúdo recebido;
- O objetivo da solicitação;
- A resposta gerada;
- A ação que será executada depois da resposta.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Entrada do usuário] --> B[Validar e classificar conteúdo]
    B -- Bloqueada --> C[Retornar mensagem segura]
    B -- Permitida --> D[Consultar modelo]
    D --> E[Validar resposta]
    E -- Inadequada --> F[Aplicar fallback ou revisão]
    E -- Adequada --> G[Entregar resposta]
~~~

**Como o candidato deve responder:**  

- Falar sobre entrada e saída;
- Mencionar políticas do provedor;
- Explicar que o prompt não é suficiente;
- Considerar revisão humana e fallback;
- Relacionar o controle ao domínio e ao risco.

**Resposta fraca ou incompleta:**  
“Eu escreveria no prompt para o modelo não gerar conteúdo proibido.”

Essa instrução pode ajudar, mas não oferece uma barreira suficiente.

**Critérios de avaliação:**  

- **0** — Não identifica riscos de conteúdo.
- **1** — Confia exclusivamente no modelo.
- **2** — Menciona filtros, mas não explica suas limitações.
- **3** — Propõe validação básica de entrada e saída.
- **4** — Considera políticas, fallback e revisão.
- **5** — Apresenta defesa em profundidade, classificação, auditoria e controles proporcionais ao risco.

**Perguntas de aprofundamento:**  

1. Você bloquearia apenas palavras específicas? Quais limitações existem?
2. Como trataria um caso ambíguo?
3. Quando uma revisão humana seria necessária?

---

## Pergunta 56 — Conteúdo gerado e responsabilidade da aplicação

**Nível:** Júnior  
**Categoria:** Confiabilidade e produto

**Pergunta do entrevistador:**  
Quem é responsável por validar uma resposta gerada pelo modelo antes que ela seja apresentada ao usuário?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende que o modelo é um componente da solução, mas não substitui a responsabilidade técnica e de negócio da aplicação.

**Resposta esperada:**  
A aplicação e a equipe responsável pelo produto devem definir os controles necessários sobre a resposta.

O modelo fornece uma saída probabilística, mas a aplicação deve decidir:

- Se a resposta possui formato válido;
- Se contém informações permitidas;
- Se está dentro do escopo;
- Se possui fonte suficiente;
- Se pode ser exibida automaticamente;
- Se exige revisão humana;
- Se pode acionar alguma ação.

Em domínios críticos, pode ser necessário apresentar fontes, solicitar confirmação ou impedir a automação completa.

**Explicação didática:**  
O modelo não conhece necessariamente todas as regras da organização nem possui autoridade para tomar decisões em nome do sistema.

Por exemplo, um modelo pode sugerir que um pedido seja cancelado, mas a aplicação precisa verificar regras, autorização, prazo e confirmação do usuário.

**Exemplo prático:**  
Uma aplicação de suporte pode mostrar uma resposta gerada acompanhada das fontes utilizadas e de uma opção para solicitar atendimento humano.

**Como o candidato deve responder:**  

- Explicar que o modelo não é autoridade final;
- Mencionar validação pela aplicação;
- Citar fontes, permissões e revisão;
- Diferenciar respostas informativas de ações automáticas;
- Relacionar o controle ao risco do domínio.

**Resposta fraca ou incompleta:**  
“A responsabilidade é do modelo, pois foi ele que gerou a resposta.”

Essa resposta ignora o papel da aplicação, dos desenvolvedores e dos responsáveis pelo produto.

**Critérios de avaliação:**  

- **0** — Não entende a responsabilidade da aplicação.
- **1** — Confia integralmente no modelo.
- **2** — Reconhece que pode haver erro, mas não propõe controle.
- **3** — Explica a necessidade de validar a saída.
- **4** — Considera fontes, permissões e revisão humana.
- **5** — Relaciona responsabilidade, risco, auditoria, governança e controles de automação.

**Perguntas de aprofundamento:**  

1. Que tipos de resposta você não exibiria automaticamente?
2. Como mostraria ao usuário que a resposta pode estar incorreta?
3. Como registraria decisões tomadas com auxílio do modelo?

---

## Pergunta 57 — Integração com API interna

**Nível:** Júnior  
**Categoria:** Integração e ferramentas

**Pergunta do entrevistador:**  
Como você permitiria que uma aplicação Spring AI utilizasse dados de uma API interna para responder a uma pergunta do usuário?

**O que essa pergunta avalia:**  
Avalia compreensão de integração entre o modelo, a aplicação e fontes externas de dados.

**Resposta esperada:**  
A aplicação pode consultar a API interna diretamente ou disponibilizar uma ferramenta controlada para que o modelo solicite a consulta.

O fluxo deve incluir:

1. Autenticar o usuário;
2. Interpretar a intenção;
3. Validar os argumentos;
4. Verificar autorização;
5. Consultar a API interna;
6. Limitar os dados retornados;
7. Fornecer o resultado ao modelo ou formatá-lo diretamente;
8. Validar a resposta final.

A API interna deve continuar protegida. O modelo não deve receber credenciais nem acesso irrestrito.

**Explicação didática:**  
Suponha que o usuário pergunte:

> “Qual é o status do meu pedido?”

O modelo pode identificar que precisa de uma consulta, mas a aplicação deve confirmar qual pedido pertence ao usuário e acessar a API com credenciais apropriadas.

Para dados estruturados e críticos, pode ser mais seguro consultar a API no código e usar o modelo apenas para explicar o resultado.

**Exemplo prático:**

~~~mermaid
flowchart LR
    A[Pergunta] --> B[Interpretar intenção]
    B --> C[Validar usuário e parâmetros]
    C --> D[Consultar API interna]
    D --> E[Receber dados autorizados]
    E --> F[Gerar explicação]
    F --> G[Validar resposta]
    G --> H[Exibir resultado]
~~~

**Como o candidato deve responder:**  

- Explicar a integração com API;
- Mencionar autenticação e autorização;
- Validar argumentos;
- Evitar enviar segredos ao modelo;
- Diferenciar dados críticos de explicações textuais;
- Considerar tratamento de falhas.

**Resposta fraca ou incompleta:**  
“Eu colocaria a URL e a chave da API no prompt.”

Essa abordagem expõe credenciais e não cria controle adequado de acesso.

**Critérios de avaliação:**  

- **0** — Não sabe como integrar uma API.
- **1** — Propõe expor credenciais ao modelo.
- **2** — Entende que a aplicação deve chamar a API, mas ignora autorização.
- **3** — Descreve um fluxo básico de integração segura.
- **4** — Considera validação, escopo dos dados e falhas.
- **5** — Avalia corretamente quando consultar a API diretamente e quando utilizar ferramentas controladas.

**Perguntas de aprofundamento:**  

1. Quem deve fornecer as credenciais da API?
2. Como impediria a consulta de dados de outro cliente?
3. O que faria se a API interna estivesse indisponível?

---

## Pergunta 58 — Ações com efeito colateral

**Nível:** Júnior  
**Categoria:** Segurança e integração

**Pergunta do entrevistador:**  
Quais cuidados são necessários quando uma resposta do modelo pode resultar em uma alteração no sistema?

**O que essa pergunta avalia:**  
Avalia se o candidato diferencia geração de texto de execução de operações e reconhece riscos de ações automatizadas.

**Resposta esperada:**  
Ações com efeito colateral podem alterar dados, enviar mensagens, cancelar pedidos ou movimentar valores. Por isso, devem possuir controles adicionais.

A aplicação deve:

- Confirmar a intenção;
- Validar os parâmetros;
- Verificar autorização;
- Exigir confirmação para ações sensíveis;
- Controlar duplicidade;
- Registrar auditoria;
- Limitar permissões;
- Tratar falhas parcialmente concluídas;
- Permitir reversão quando possível;
- Evitar que o modelo execute a operação diretamente.

O modelo pode auxiliar na interpretação, mas a decisão final e a execução devem permanecer sob controle da aplicação.

**Explicação didática:**  
Existe diferença entre:

- “Explique como cancelar um pedido”;
- “Cancele meu pedido agora”.

A primeira solicitação gera informação. A segunda pode alterar o estado do sistema e exige autenticação, validação e, dependendo do risco, confirmação explícita.

**Exemplo prático:**

~~~mermaid
sequenceDiagram
    participant U as Usuário
    participant A as Aplicação
    participant M as Modelo
    participant S as Sistema

    U->>A: Solicita cancelamento
    A->>M: Interpreta intenção
    M-->>A: Sugere ação e parâmetros
    A->>A: Valida autorização e regras
    A-->>U: Solicita confirmação
    U->>A: Confirma
    A->>S: Executa cancelamento
    S-->>A: Retorna resultado
    A-->>U: Informa conclusão
~~~

**Como o candidato deve responder:**  

- Diferenciar consulta e alteração;
- Mencionar confirmação e autorização;
- Falar sobre idempotência e auditoria;
- Explicar validação dos parâmetros;
- Reforçar que o modelo não deve executar livremente qualquer método.

**Resposta fraca ou incompleta:**  
“Se o usuário pediu, o modelo pode executar a ação.”

A solicitação textual não substitui autenticação, autorização, confirmação e regras de negócio.

**Critérios de avaliação:**  

- **0** — Não identifica o risco de efeitos colaterais.
- **1** — Permite execução automática sem controles.
- **2** — Menciona confirmação, mas ignora autorização e auditoria.
- **3** — Propõe controles básicos para ações sensíveis.
- **4** — Considera idempotência, validação, registros e falhas.
- **5** — Demonstra defesa em profundidade e separa claramente interpretação, autorização e execução.

**Perguntas de aprofundamento:**  

1. Que ações sempre exigiriam confirmação explícita?
2. Como evitaria executar a mesma operação duas vezes?
3. Como trataria uma falha depois que parte da operação foi realizada?

---

## Pergunta 59 — Configuração de limites de resposta

**Nível:** Júnior  
**Categoria:** Desempenho e custo

**Pergunta do entrevistador:**  
Por que pode ser importante limitar o tamanho da resposta gerada pelo modelo?

**O que essa pergunta avalia:**  
Avalia compreensão de custos, latência, experiência do usuário e proteção de recursos.

**Resposta esperada:**  
Limitar o tamanho da resposta pode:

- Reduzir custos;
- Diminuir latência;
- Evitar respostas excessivamente longas;
- Impedir consumo excessivo de recursos;
- Melhorar a experiência do usuário;
- Reduzir risco de ultrapassar limites do contexto.

O limite deve ser adequado à finalidade. Uma resposta curta de classificação não precisa do mesmo limite de um resumo detalhado.

O limite pode ser definido por parâmetros do provedor ou também aplicado pela própria aplicação após receber a resposta. A aplicação deve tomar cuidado para não cortar o texto de forma que altere seu significado.

**Explicação didática:**  
Uma resposta longa pode ser desnecessária e cara. Porém, limitar demais pode causar truncamento e perda de informações importantes.

Além do limite técnico, a aplicação pode instruir o modelo sobre o formato desejado:

- Responder em até três tópicos;
- Produzir um resumo de até determinado tamanho;
- Retornar apenas os campos necessários.

Ainda assim, a saída deve ser validada.

**Exemplo prático:**  
Para classificar chamados, a aplicação pode solicitar apenas:

- Categoria;
- Prioridade;
- Resumo curto.

Não é necessário gerar vários parágrafos para uma operação simples.

**Como o candidato deve responder:**  

- Relacionar tamanho à quantidade de tokens;
- Mencionar custo e latência;
- Explicar que o limite depende do caso de uso;
- Considerar truncamento;
- Citar instruções de formato e validação.

**Resposta fraca ou incompleta:**  
“Quanto maior a resposta, melhor, porque contém mais detalhes.”

Uma resposta maior pode ser mais cara, lenta, confusa ou ainda assim estar incorreta.

**Critérios de avaliação:**  

- **0** — Não identifica a importância do limite.
- **1** — Acredita que respostas longas são sempre melhores.
- **2** — Menciona custo, mas não considera qualidade.
- **3** — Explica a necessidade de limitar a saída.
- **4** — Relaciona limite a formato, latência e caso de uso.
- **5** — Discute equilíbrio entre completude, custo, truncamento, validação e experiência do usuário.

**Perguntas de aprofundamento:**  

1. Como definiria um limite para uma classificação?
2. O que faria se a resposta fosse cortada no meio?
3. Como diferenciaria limite de tokens e limite de caracteres?

---

## Pergunta 60 — Avaliação de qualidade de respostas

**Nível:** Júnior  
**Categoria:** Testes e qualidade

**Pergunta do entrevistador:**  
Como você avaliaria se as respostas geradas por uma aplicação Spring AI estão atendendo ao objetivo esperado?

**O que essa pergunta avalia:**  
Avalia se o candidato entende que testar uma aplicação com IA exige verificar mais do que apenas se a chamada foi concluída.

**Resposta esperada:**  
A avaliação pode combinar:

- Casos de teste representativos;
- Respostas esperadas ou critérios de aceitação;
- Verificação de formato;
- Precisão factual;
- Relevância;
- Clareza;
- Segurança;
- Taxa de respostas sem fundamento;
- Tempo de resposta;
- Custo;
- Avaliação por pessoas;
- Comparação entre versões de prompts ou modelos.

Para respostas determinísticas, pode ser possível comparar campos exatos. Para respostas textuais abertas, é melhor definir critérios de qualidade e utilizar exemplos avaliados por pessoas ou mecanismos apropriados.

As respostas podem variar, portanto, o teste não deve depender sempre de uma única frase exata.

**Explicação didática:**  
Um teste de conectividade verifica se o provedor respondeu. Isso não garante que a resposta seja útil.

Por exemplo, uma resposta pode:

- Usar o formato correto;
- Ser gramaticalmente boa;
- Mas conter informação incorreta.

A avaliação precisa considerar o objetivo da funcionalidade.

**Exemplo prático:**

~~~mermaid
flowchart TD
    A[Conjunto de perguntas reais] --> B[Executar aplicação]
    B --> C[Verificar formato]
    C --> D[Verificar relevância]
    D --> E[Verificar segurança]
    E --> F[Medir latência e custo]
    F --> G[Analisar resultados]
    G --> H{Qualidade adequada?}
    H -- Não --> I[Ajustar prompt, dados ou modelo]
    H -- Sim --> J[Prosseguir com liberação]
~~~

Em um sistema RAG, também é necessário avaliar se os documentos recuperados são realmente relevantes.

**Como o candidato deve responder:**  

- Diferenciar teste técnico de avaliação de qualidade;
- Citar casos reais e critérios objetivos;
- Considerar formato, relevância e precisão;
- Mencionar custo e latência;
- Explicar que respostas abertas não devem ser avaliadas apenas por igualdade textual;
- Considerar revisão humana.

**Resposta fraca ou incompleta:**  
“Eu verificaria se a resposta não está vazia.”

Essa é apenas uma validação mínima e não mede qualidade, segurança ou utilidade.

**Critérios de avaliação:**  

- **0** — Não sabe como avaliar respostas.
- **1** — Verifica apenas se houve retorno.
- **2** — Compara textos, mas ignora variação e qualidade.
- **3** — Define casos e critérios básicos.
- **4** — Considera relevância, formato, segurança, latência e custo.
- **5** — Propõe avaliação contínua com dados reais, revisão humana, comparação de versões e métricas de qualidade.

**Perguntas de aprofundamento:**  

1. Como avaliaria uma resposta que pode variar, mas continua correta?
2. Como mediria a qualidade de documentos recuperados em um RAG?
3. Que sinais indicariam que uma mudança no prompt piorou o sistema?

---

## Resumo desta parte

- **Perguntas apresentadas:** 51 a 60
- **Perguntas restantes:** 61 a 100
- **Categorias abordadas:** fundamentos, prompts, estado, persistência, conversação, segurança, integração, desempenho, testes e qualidade
- **Competências avaliadas:** escolha entre regras e IA generativa, contextualização, isolamento de conversas, memória, moderação, responsabilidade sobre respostas, integração com APIs internas, ações com efeitos colaterais, limites de resposta e avaliação de qualidade

A próxima parte deve continuar com as perguntas **61 a 70**, mantendo a mesma estrutura e a numeração sequencial.

---

# Roteiro de Entrevista Técnica — Spring AI

> **Parte 7 de 10**  
> Esta parte contém as perguntas **61 a 70 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

---

## Pergunta 61 — Diferença entre RAG e fine-tuning

**Nível:** Júnior  
**Categoria:** Arquitetura e fundamentos

**Pergunta do entrevistador:**  
Qual é a diferença entre utilizar RAG e realizar fine-tuning em um modelo de linguagem?

**O que essa pergunta avalia:**  
Avalia se o candidato consegue diferenciar recuperação de informações externas de adaptação do comportamento do modelo.

**Resposta esperada:**  
RAG, ou geração aumentada por recuperação, consiste em buscar informações relevantes em documentos ou fontes externas e enviá-las ao modelo como contexto no momento da consulta.

Fine-tuning consiste em treinar ou adaptar o modelo com exemplos específicos para modificar seu comportamento, estilo ou capacidade em determinado tipo de tarefa.

Em geral:

- **RAG:** adiciona conhecimento externo durante a execução;
- **Fine-tuning:** altera o comportamento aprendido pelo modelo;
- **RAG:** facilita atualizar documentos sem treinar novamente o modelo;
- **Fine-tuning:** pode ser útil para padrões de resposta, classificação ou estilo específicos.

RAG não modifica o modelo. Ele apenas fornece contexto adicional para uma chamada.

**Explicação didática:**  
Suponha que uma empresa queira responder perguntas sobre uma política interna que muda frequentemente.

Nesse caso, RAG pode ser mais apropriado:

1. Os documentos são atualizados;
2. Os trechos relevantes são indexados;
3. A pergunta é comparada com esses trechos;
4. O conteúdo recuperado é enviado ao modelo;
5. O modelo gera a resposta com base no contexto.

Já o fine-tuning pode ser considerado quando a empresa deseja que o modelo siga um padrão específico de classificação ou responda com determinado estilo.

**Exemplo comparativo:**

~~~mermaid
flowchart LR
    A[Pergunta] --> B[RAG]
    B --> C[Buscar documentos atualizados]
    C --> D[Enviar contexto ao modelo]
    D --> E[Resposta]

    F[Exemplos de treinamento] --> G[Fine-tuning]
    G --> H[Modelo adaptado]
    H --> I[Gerar resposta]
~~~

A escolha depende do problema, da frequência de atualização dos dados, dos custos, da infraestrutura e do nível de controle desejado.

**Como o candidato deve responder:**

- Definir RAG e fine-tuning;
- Explicar que RAG utiliza contexto externo;
- Explicar que fine-tuning adapta o comportamento do modelo;
- Mencionar atualização dos dados;
- Dar um exemplo de uso para cada abordagem;
- Evitar afirmar que fine-tuning é sempre melhor.

**Resposta fraca ou incompleta:**  
“RAG e fine-tuning são a mesma coisa, mas RAG é mais simples.”

Essa resposta não explica a diferença entre recuperar informações e adaptar o modelo.

**Critérios de avaliação:**

- **0** — Não diferencia as abordagens.
- **1** — Confunde documentos recuperados com treinamento do modelo.
- **2** — Reconhece que são técnicas diferentes, mas não explica como.
- **3** — Diferencia corretamente RAG e fine-tuning.
- **4** — Relaciona as técnicas a casos de uso e atualização dos dados.
- **5** — Discute custos, manutenção, qualidade, privacidade, atualização e combinação das abordagens.

**Perguntas de aprofundamento:**

1. Qual abordagem escolheria para documentos que mudam diariamente?
2. Fine-tuning faz o modelo consultar automaticamente o banco de dados?
3. É possível combinar RAG e fine-tuning?

---

## Pergunta 62 — Ingestão de documentos

**Nível:** Júnior  
**Categoria:** RAG e processamento

**Pergunta do entrevistador:**  
Como você projetaria um processo de ingestão de documentos para uma aplicação que utiliza Spring AI e busca vetorial?

**O que essa pergunta avalia:**  
Avalia o entendimento das etapas necessárias para transformar documentos em conteúdo pesquisável.

**Resposta esperada:**  
Um processo básico de ingestão pode incluir:

1. Localizar os documentos autorizados;
2. Ler e extrair o conteúdo;
3. Limpar informações desnecessárias;
4. Dividir o conteúdo em trechos;
5. Adicionar metadados;
6. Gerar embeddings;
7. Armazenar os vetores e os trechos;
8. Registrar a versão e a origem;
9. Detectar alterações ou duplicidades;
10. Monitorar falhas do processo.

A ingestão deve ser executada de maneira controlada. Documentos inválidos, duplicados ou sem autorização não devem ser indexados automaticamente.

**Explicação didática:**  
O processo de ingestão prepara o conteúdo antes de ele ser utilizado em uma pergunta.

Se um manual for alterado, a aplicação precisa decidir se deve:

- Atualizar apenas os trechos modificados;
- Remover a versão antiga;
- Manter versões históricas;
- Reprocessar o documento inteiro;
- Registrar a data da alteração.

Também é importante manter uma relação entre o vetor armazenado e a fonte original, para que a aplicação consiga apresentar a origem da informação.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Documento autorizado] --> B[Extrair texto]
    B --> C[Limpar conteúdo]
    C --> D[Dividir em trechos]
    D --> E[Adicionar metadados]
    E --> F[Gerar embeddings]
    F --> G[Armazenar no banco vetorial]
    G --> H[Registrar versão e origem]
~~~

**Como o candidato deve responder:**

- Listar as principais etapas;
- Mencionar limpeza e divisão em trechos;
- Citar embeddings e metadados;
- Considerar documentos atualizados;
- Falar sobre duplicidade e autorização;
- Relacionar o processo à rastreabilidade.

**Resposta fraca ou incompleta:**  
“Eu colocaria os arquivos diretamente no banco vetorial.”

Essa resposta ignora extração, chunking, embeddings, metadados, versões e segurança.

**Critérios de avaliação:**

- **0** — Não sabe explicar a ingestão.
- **1** — Apenas armazena os arquivos sem processamento.
- **2** — Menciona embeddings, mas ignora preparação dos dados.
- **3** — Explica as etapas básicas de ingestão.
- **4** — Considera metadados, versões, duplicidade e autorização.
- **5** — Propõe um processo idempotente, monitorado, auditável e capaz de atualizar documentos com segurança.

**Perguntas de aprofundamento:**

1. Como evitaria indexar o mesmo documento várias vezes?
2. O que faria se a extração de texto falhasse?
3. Como removeria uma versão antiga do banco vetorial?

---

## Pergunta 63 — Atualização e remoção de documentos

**Nível:** Júnior  
**Categoria:** RAG e consistência

**Pergunta do entrevistador:**  
Como você trataria a atualização ou remoção de um documento que já foi indexado em um banco vetorial?

**O que essa pergunta avalia:**  
Avalia se o candidato entende que documentos indexados precisam acompanhar o estado atual das fontes originais.

**Resposta esperada:**  
A aplicação deve identificar o documento por um identificador estável e controlar sua versão.

Quando um documento for atualizado, ela pode:

- Remover os trechos antigos;
- Processar a nova versão;
- Gerar novos embeddings;
- Armazenar os novos trechos;
- Atualizar os metadados;
- Marcar a versão anterior como inativa.

Quando um documento for removido ou deixar de ser autorizado, seus trechos também devem deixar de aparecer nas buscas.

É importante evitar que versões antigas e novas sejam recuperadas simultaneamente sem uma regra clara.

**Explicação didática:**  
Se uma política de reembolso mudou, o sistema não deve responder utilizando a regra antiga apenas porque ela ainda está armazenada no banco vetorial.

Uma estratégia pode utilizar:

- Identificador do documento;
- Número da versão;
- Data de vigência;
- Status ativo ou inativo;
- Data de remoção;
- Controle de atualização.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Documento alterado] --> B[Identificar versão anterior]
    B --> C[Desativar ou remover trechos antigos]
    C --> D[Processar nova versão]
    D --> E[Gerar novos embeddings]
    E --> F[Armazenar trechos atualizados]
    F --> G[Validar busca]
~~~

A operação deve ser consistente. Uma falha durante a atualização não deve deixar o sistema sem controle sobre qual versão é válida.

**Como o candidato deve responder:**

- Mencionar identificador e versionamento;
- Explicar a remoção ou desativação dos trechos antigos;
- Considerar data de vigência;
- Falar sobre documentos removidos;
- Relacionar a atualização à qualidade das respostas.

**Resposta fraca ou incompleta:**  
“Eu adicionaria a nova versão e deixaria a antiga no banco.”

Isso pode fazer a busca recuperar informações conflitantes ou desatualizadas.

**Critérios de avaliação:**

- **0** — Não considera atualização dos documentos.
- **1** — Mantém todas as versões sem controle.
- **2** — Reconhece a necessidade de reprocessar, mas não explica como.
- **3** — Propõe substituir ou desativar a versão antiga.
- **4** — Considera versões, datas, remoção e consistência.
- **5** — Discute atualização idempotente, atomicidade, reprocessamento, auditoria e validação pós-atualização.

**Perguntas de aprofundamento:**

1. O que faria se o processamento da nova versão falhasse?
2. Como impediria a recuperação de documentos expirados?
3. Como verificaria se a nova versão foi indexada corretamente?

---

## Pergunta 64 — Citação das fontes utilizadas

**Nível:** Júnior  
**Categoria:** RAG e confiabilidade

**Pergunta do entrevistador:**  
Por que pode ser importante apresentar ao usuário as fontes utilizadas para gerar uma resposta?

**O que essa pergunta avalia:**  
Avalia compreensão de transparência, rastreabilidade e confiança em aplicações baseadas em documentos.

**Resposta esperada:**  
Apresentar as fontes pode ajudar o usuário a:

- Verificar a informação;
- Entender de onde veio a resposta;
- Identificar a versão do documento;
- Avaliar a confiabilidade;
- Encontrar mais detalhes;
- Reportar uma fonte incorreta ou desatualizada.

As fontes também facilitam auditoria e investigação de respostas incorretas.

A aplicação deve garantir que as referências exibidas correspondam realmente aos documentos recuperados e que o usuário tenha permissão para visualizá-las.

**Explicação didática:**  
Uma resposta como:

> “O prazo é de 30 dias.”

é mais confiável quando informa que essa regra veio da política oficial, incluindo título, seção e data de atualização.

Entretanto, a aplicação não deve expor o nome ou o conteúdo de um documento confidencial para alguém que não possui autorização.

**Exemplo de resposta estruturada:**

~~~json
{
  "resposta": "A solicitação deve ser feita com 30 dias de antecedência.",
  "fontes": [
    {
      "titulo": "Política de férias",
      "secao": "Solicitação",
      "versao": "4",
      "atualizadoEm": "2026-08-15"
    }
  ]
}
~~~

As fontes não garantem que a resposta esteja correta, mas melhoram a possibilidade de conferência.

**Como o candidato deve responder:**

- Relacionar fontes à transparência;
- Mencionar rastreabilidade e auditoria;
- Considerar versões e datas;
- Falar sobre permissões;
- Explicar que citar fontes não substitui a validação da resposta.

**Resposta fraca ou incompleta:**  
“Não é necessário mostrar fontes, porque o modelo já verificou os documentos.”

O modelo não é necessariamente capaz de garantir que uma resposta está correta ou devidamente fundamentada.

**Critérios de avaliação:**

- **0** — Não reconhece o valor das fontes.
- **1** — Acredita que o modelo sempre identifica a origem correta.
- **2** — Menciona transparência, mas ignora autorização.
- **3** — Explica a importância de apresentar referências.
- **4** — Considera versões, auditoria e controle de acesso.
- **5** — Discute rastreabilidade ponta a ponta, fontes conflitantes, atualização e experiência do usuário.

**Perguntas de aprofundamento:**

1. Como impediria que uma fonte confidencial fosse exibida?
2. O que faria se a resposta não tivesse uma fonte suficiente?
3. Como trataria fontes contraditórias?

---

## Pergunta 65 — Tratamento de documentos conflitantes

**Nível:** Júnior  
**Categoria:** RAG e qualidade

**Pergunta do entrevistador:**  
O que você faria se a busca recuperasse dois documentos com informações diferentes sobre a mesma regra?

**O que essa pergunta avalia:**  
Avalia o entendimento de qualidade das fontes, versionamento e necessidade de regras determinísticas para resolver conflitos.

**Resposta esperada:**  
A aplicação não deve simplesmente enviar os dois documentos ao modelo e esperar que ele escolha corretamente.

Ela deve investigar:

- Data de atualização;
- Versão;
- Status de vigência;
- Autoridade da fonte;
- Departamento responsável;
- Escopo do documento;
- Possibilidade de erro na indexação;
- Diferenças entre regiões ou perfis de usuário.

Quando possível, deve aplicar filtros e regras para selecionar a fonte válida antes de montar o contexto.

Se o conflito não puder ser resolvido automaticamente, a aplicação deve:

- Informar a incerteza;
- Solicitar esclarecimento;
- Encaminhar para revisão humana;
- Evitar executar ações baseadas na informação conflitante.

**Explicação didática:**  
Dois documentos podem parecer contraditórios, mas tratar de períodos diferentes. Um pode ser a política atual e outro uma versão antiga.

Metadados como `vigenteDesde`, `vigenteAte` e `versao` podem ajudar a selecionar o conteúdo apropriado.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Documentos recuperados] --> B[Comparar versões e datas]
    B --> C{Existe fonte vigente?}
    C -- Sim --> D[Usar fonte válida]
    C -- Não --> E[Marcar conflito]
    E --> F[Informar incerteza ou solicitar revisão]
~~~

O modelo pode ajudar a resumir as diferenças, mas não deve ser o responsável exclusivo por determinar qual regra possui autoridade.

**Como o candidato deve responder:**

- Mencionar versões e datas;
- Considerar autoridade da fonte;
- Usar metadados e filtros;
- Explicar que o modelo não deve decidir sozinho;
- Propor revisão humana em caso de dúvida.

**Resposta fraca ou incompleta:**  
“Eu enviaria os dois documentos e deixaria o modelo escolher o mais correto.”

Isso pode resultar em uma escolha arbitrária ou incorreta.

**Critérios de avaliação:**

- **0** — Não reconhece o risco de conflito.
- **1** — Confia totalmente no modelo.
- **2** — Menciona datas, mas não propõe tratamento.
- **3** — Investiga versões e vigência.
- **4** — Considera autoridade, filtros e revisão humana.
- **5** — Propõe governança de fontes, resolução determinística, auditoria e comportamento seguro diante da incerteza.

**Perguntas de aprofundamento:**

1. Como identificaria a fonte oficial?
2. O que deveria acontecer quando nenhuma versão puder ser considerada válida?
3. Como exibiria o conflito ao usuário?

---

## Pergunta 66 — Diferença entre busca semântica e busca por palavras-chave

**Nível:** Júnior  
**Categoria:** Recuperação de informação

**Pergunta do entrevistador:**  
Qual é a diferença entre uma busca por palavras-chave e uma busca semântica em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende diferentes estratégias de recuperação de conteúdo.

**Resposta esperada:**  
A busca por palavras-chave procura correspondências literais entre os termos da consulta e os termos armazenados.

A busca semântica utiliza embeddings para comparar o significado aproximado da pergunta com o significado dos documentos.

Exemplo:

- Busca por palavras-chave: procura exatamente o termo “reembolso”;
- Busca semântica: pode encontrar um documento que use “devolução de valores”, mesmo sem utilizar a palavra “reembolso”.

A busca por palavras-chave pode ser mais adequada para identificadores, nomes exatos, códigos e termos específicos. A busca semântica é útil quando o usuário utiliza palavras diferentes para expressar a mesma ideia.

As duas abordagens podem ser combinadas.

**Explicação didática:**  
Uma pergunta como:

> “Como receber meu dinheiro de volta?”

pode não conter a palavra “reembolso”. A busca semântica pode encontrar documentos que tratam desse assunto mesmo com vocabulário diferente.

Por outro lado, para pesquisar o código exato de um produto, a busca por palavras-chave pode ser mais precisa.

**Exemplo comparativo:**

~~~mermaid
flowchart LR
    A[Consulta do usuário] --> B[Busca por palavras-chave]
    A --> C[Busca semântica]
    B --> D[Resultados literais]
    C --> E[Resultados por significado]
    D --> F[Combinar e ranquear]
    E --> F
    F --> G[Contexto final]
~~~

**Como o candidato deve responder:**

- Diferenciar correspondência literal e similaridade semântica;
- Dar exemplos;
- Explicar pontos fortes de cada abordagem;
- Mencionar combinação das técnicas;
- Relacionar a escolha ao tipo de consulta.

**Resposta fraca ou incompleta:**  
“Busca semântica procura palavras mais rapidamente.”

Ela não se baseia apenas em velocidade, mas na representação vetorial e na proximidade de significado.

**Critérios de avaliação:**

- **0** — Não diferencia as buscas.
- **1** — Confunde embeddings com indexação textual simples.
- **2** — Reconhece que uma busca entende significado, mas não explica como.
- **3** — Diferencia corretamente as abordagens.
- **4** — Apresenta exemplos e defende uma abordagem híbrida.
- **5** — Discute precisão, recall, identificadores, filtros, ranqueamento e avaliação dos resultados.

**Perguntas de aprofundamento:**

1. Para que tipo de consulta a busca por palavras-chave seria melhor?
2. Por que a busca semântica pode retornar um resultado conceitualmente próximo, mas incorreto?
3. Como combinaria as duas abordagens?

---

## Pergunta 67 — Top K e quantidade de documentos recuperados

**Nível:** Júnior  
**Categoria:** RAG e desempenho

**Pergunta do entrevistador:**  
O que significa definir a quantidade de documentos ou trechos recuperados em uma busca vetorial?

**O que essa pergunta avalia:**  
Avalia a compreensão do equilíbrio entre cobertura, ruído, custo e limite de contexto.

**Resposta esperada:**  
A quantidade de resultados recuperados, frequentemente chamada de `top K`, define quantos documentos ou trechos candidatos serão retornados pela busca.

Um valor pequeno pode:

- Reduzir ruído;
- Diminuir custo;
- Reduzir o tamanho do contexto;
- Mas deixar de fora uma informação importante.

Um valor grande pode:

- Aumentar a cobertura;
- Incluir informações complementares;
- Aumentar custo e latência;
- Inserir conteúdo irrelevante ou contraditório.

O valor adequado deve ser definido por meio de testes com perguntas reais.

**Explicação didática:**  
Se a aplicação sempre recuperar apenas um trecho, pode perder uma informação importante que esteja em outro trecho.

Se recuperar cinquenta trechos, o modelo pode receber muito conteúdo desnecessário e ter mais dificuldade para identificar o que é importante.

A quantidade ideal depende de:

- Tamanho dos trechos;
- Complexidade das perguntas;
- Qualidade dos documentos;
- Limite do modelo;
- Uso de filtros;
- Necessidade de múltiplas fontes.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Definir quantidade de resultados] --> B[Executar testes]
    B --> C{Informações suficientes?}
    C -- Não --> D[Aumentar K ou melhorar recuperação]
    C -- Sim, com ruído --> E[Reduzir K ou aplicar reranking]
    C -- Sim --> F[Validar custo e latência]
~~~

**Como o candidato deve responder:**

- Definir `top K`;
- Explicar o impacto de valores baixos e altos;
- Relacionar à qualidade da resposta;
- Mencionar custos e limite de contexto;
- Defender testes com dados reais.

**Resposta fraca ou incompleta:**  
“Quanto maior o número de documentos, melhor será a resposta.”

Mais documentos podem aumentar ruído, contradições, custo e dificuldade de processamento.

**Critérios de avaliação:**

- **0** — Não entende a quantidade de resultados.
- **1** — Assume que mais resultados sempre são melhores.
- **2** — Reconhece impacto no contexto, mas não explica o equilíbrio.
- **3** — Explica corretamente os efeitos de `top K`.
- **4** — Relaciona a quantidade a testes, custo e relevância.
- **5** — Discute recuperação, reranking, filtros, cobertura, ruído e avaliação sistemática.

**Perguntas de aprofundamento:**

1. O que faria se um único trecho não fosse suficiente?
2. Como saberia que está recuperando documentos demais?
3. Que outros fatores influenciam a escolha do `top K`?

---

## Pergunta 68 — Reranking de resultados

**Nível:** Júnior  
**Categoria:** RAG e qualidade

**Pergunta do entrevistador:**  
O que é reranking e por que ele pode melhorar os resultados de uma busca em um sistema RAG?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende que a primeira busca pode gerar candidatos, mas não necessariamente a melhor ordem de relevância.

**Resposta esperada:**  
Reranking é uma etapa adicional que reorganiza os resultados recuperados para colocar os trechos mais relevantes no topo.

Um fluxo comum é:

1. Recuperar uma quantidade maior de candidatos;
2. Avaliar a relação entre pergunta e cada trecho;
3. Reordenar os resultados;
4. Enviar apenas os melhores ao modelo.

Isso pode melhorar a precisão quando a busca inicial retorna documentos semanticamente parecidos, mas com diferentes níveis de utilidade.

O reranking, porém, pode aumentar latência e custo. Deve ser utilizado quando o ganho de qualidade justificar a complexidade adicional.

**Explicação didática:**  
A busca inicial pode recuperar dez trechos relacionados ao tema. O reranking ajuda a identificar quais três realmente respondem à pergunta.

Isso é especialmente útil quando:

- Existem muitos documentos semelhantes;
- Os trechos possuem informações genéricas;
- A pergunta é específica;
- Os resultados iniciais têm qualidade variável.

**Exemplo de fluxo:**

~~~mermaid
flowchart LR
    A[Pergunta] --> B[Busca inicial]
    B --> C[Lista de candidatos]
    C --> D[Reranking]
    D --> E[Melhores trechos]
    E --> F[Contexto do modelo]
~~~

A aplicação deve avaliar os resultados para verificar se o reranking realmente melhora a resposta.

**Como o candidato deve responder:**

- Definir reranking;
- Explicar que ele reorganiza candidatos;
- Relacionar à relevância;
- Mencionar impacto em custo e latência;
- Diferenciar busca inicial de ordenação refinada.

**Resposta fraca ou incompleta:**  
“Reranking significa buscar os documentos novamente.”

Ele pode utilizar uma etapa adicional de avaliação e ordenação, não necessariamente repetir a mesma busca.

**Critérios de avaliação:**

- **0** — Não entende o conceito.
- **1** — Confunde reranking com nova indexação.
- **2** — Sabe que os resultados são reorganizados, mas não explica por quê.
- **3** — Explica corretamente a finalidade.
- **4** — Relaciona reranking à qualidade, custo e latência.
- **5** — Discute recuperação em duas etapas, avaliação, filtros, precisão e trade-offs operacionais.

**Perguntas de aprofundamento:**

1. Quando o reranking poderia ser desnecessário?
2. Por que recuperar muitos candidatos antes do reranking pode ajudar?
3. Como mediria se o reranking trouxe melhoria?

---

## Pergunta 69 — Proteção de chaves e credenciais

**Nível:** Júnior  
**Categoria:** Segurança e configuração

**Pergunta do entrevistador:**  
Como você protegeria as credenciais utilizadas para acessar um provedor de modelos em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia conhecimentos básicos de segurança de segredos e configuração de aplicações.

**Resposta esperada:**  
As credenciais não devem ser colocadas diretamente no código-fonte, em prompts, em logs ou em arquivos públicos.

A aplicação pode utilizar:

- Variáveis de ambiente;
- Gerenciadores de segredos;
- Cofres de credenciais;
- Configurações protegidas do ambiente de execução;
- Rotação periódica;
- Permissões mínimas;
- Monitoramento de uso.

Também é importante evitar incluir chaves em repositórios, imagens públicas, mensagens de erro ou arquivos compartilhados.

Se uma chave for exposta, ela deve ser revogada ou substituída imediatamente.

**Explicação didática:**  
Uma chave de acesso permite que alguém utilize recursos do provedor em nome da organização. Se ela for exposta, pode provocar:

- Custos inesperados;
- Acesso indevido;
- Vazamento de dados;
- Uso abusivo;
- Interrupção do serviço.

A aplicação deve carregar a credencial de uma fonte segura durante a execução, sem torná-la parte do código.

**Exemplo conceitual:**

~~~yaml
spring:
  ai:
    provider:
      api-key: ${AI_PROVIDER_API_KEY}
~~~

O valor real deve ser fornecido pelo ambiente de execução ou por um gerenciador apropriado.

**Como o candidato deve responder:**

- Evitar credenciais no código;
- Mencionar variáveis de ambiente ou gerenciadores de segredos;
- Falar sobre rotação e revogação;
- Evitar logs de chaves;
- Considerar permissões mínimas e monitoramento.

**Resposta fraca ou incompleta:**  
“Eu colocaria a chave em uma classe de configuração privada.”

Se essa classe for versionada, compartilhada ou exposta, a credencial continuará vulnerável.

**Critérios de avaliação:**

- **0** — Não reconhece o risco.
- **1** — Coloca a chave diretamente no código.
- **2** — Menciona variável de ambiente, mas não considera rotação ou vazamento.
- **3** — Propõe armazenamento externo e proteção básica.
- **4** — Considera logs, permissões, rotação e revogação.
- **5** — Demonstra uma estratégia completa de gestão de segredos, incluindo auditoria, acesso mínimo e resposta a incidentes.

**Perguntas de aprofundamento:**

1. O que faria se uma chave fosse publicada acidentalmente em um repositório?
2. Por que não se deve registrar a chave nos logs?
3. Como diferenciaria credenciais de desenvolvimento e produção?

---

## Pergunta 70 — Privacidade e minimização de dados

**Nível:** Júnior  
**Categoria:** Segurança e proteção de dados

**Pergunta do entrevistador:**  
Quais cuidados você teria ao enviar dados de usuários para um modelo por meio do Spring AI?

**O que essa pergunta avalia:**  
Avalia consciência sobre privacidade, minimização de dados e uso responsável de informações pessoais.

**Resposta esperada:**  
A aplicação deve enviar somente os dados necessários para realizar a tarefa.

Os cuidados podem incluir:

- Identificar dados pessoais e confidenciais;
- Remover informações desnecessárias;
- Anonimizar ou mascarar dados;
- Obter base legal ou autorização adequada, quando aplicável;
- Verificar as políticas do provedor;
- Definir retenção e descarte;
- Restringir o acesso aos logs;
- Evitar armazenar prompts completos sem necessidade;
- Controlar quem pode consultar o histórico;
- Informar o usuário sobre o uso dos dados quando necessário.

Dados sensíveis não devem ser enviados ao modelo apenas por conveniência.

**Explicação didática:**  
Para resumir um chamado, talvez seja necessário enviar o texto do problema, mas não o CPF, o número completo do cartão ou a senha do cliente.

A aplicação pode substituir dados sensíveis por marcadores:

~~~text
Nome: [CLIENTE]
Documento: [REMOVIDO]
Número do pedido: 12345
Problema: pedido entregue com item incorreto
~~~

Mesmo após mascarar informações, a aplicação deve avaliar se o conteúdo ainda pode identificar a pessoa.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Receber dados] --> B[Identificar informações sensíveis]
    B --> C[Remover ou mascarar dados desnecessários]
    C --> D[Verificar autorização e finalidade]
    D --> E[Enviar apenas o necessário]
    E --> F[Controlar armazenamento e logs]
~~~

A proteção deve considerar todo o ciclo de vida: entrada, processamento, envio, resposta, armazenamento, logs e descarte.

**Como o candidato deve responder:**

- Falar sobre minimização de dados;
- Citar anonimização ou mascaramento;
- Considerar políticas do provedor;
- Evitar dados sensíveis em prompts e logs;
- Mencionar acesso, retenção e descarte;
- Relacionar o tratamento ao objetivo da funcionalidade.

**Resposta fraca ou incompleta:**  
“Eu enviaria todos os dados para o modelo, porque quanto mais contexto melhor.”

Essa prática aumenta riscos de vazamento, uso indevido e exposição desnecessária de informações pessoais.

**Critérios de avaliação:**

- **0** — Não reconhece riscos de privacidade.
- **1** — Envia todos os dados sem restrição.
- **2** — Menciona dados sensíveis, mas não propõe controles.
- **3** — Explica minimização e mascaramento básicos.
- **4** — Considera provedor, logs, retenção e autorização.
- **5** — Demonstra visão completa de privacidade, incluindo finalidade, acesso mínimo, anonimização, auditoria e descarte seguro.

**Perguntas de aprofundamento:**

1. Quais dados você jamais enviaria ao modelo?
2. Como trataria documentos que contêm informações pessoais?
3. O que faria se um usuário solicitasse acesso ao histórico de outra pessoa?

---

## Resumo desta parte

- **Perguntas apresentadas:** 61 a 70
- **Perguntas restantes:** 71 a 100
- **Categorias abordadas:** arquitetura, RAG, processamento de documentos, recuperação, segurança, privacidade e qualidade
- **Competências avaliadas:** diferença entre RAG e fine-tuning, ingestão e atualização de documentos, citação de fontes, tratamento de conflitos, busca semântica, definição de `top K`, reranking, proteção de credenciais e minimização de dados

A próxima parte deve continuar com as perguntas **71 a 80**, mantendo a mesma estrutura e a numeração sequencial.

---

# Roteiro de Entrevista Técnica — Spring AI

> **Parte 8 de 10**  
> Esta parte contém as perguntas **71 a 80 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

---

## Pergunta 71 — Diferença entre `ChatClient` e `ChatModel`

**Nível:** Júnior  
**Categoria:** Spring AI e arquitetura

**Pergunta do entrevistador:**  
Qual é a diferença entre `ChatClient` e `ChatModel` no Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende a separação entre a abstração de baixo nível que representa o modelo e a API mais conveniente utilizada pela aplicação.

**Resposta esperada:**  
O `ChatModel` representa a integração com um modelo de conversa. Ele é responsável por realizar a chamada ao modelo e retornar uma resposta.

O `ChatClient` oferece uma API mais fluida e conveniente para construir solicitações. Ele permite organizar elementos como:

- Mensagem do sistema;
- Mensagem do usuário;
- Contexto;
- Opções de geração;
- Conversão da resposta;
- Uso de advisors ou componentes auxiliares.

Em uma aplicação Spring AI, o `ChatClient` normalmente é utilizado pela camada de serviço, enquanto o `ChatModel` fica mais próximo da configuração e da integração com o provedor.

A nomenclatura e alguns métodos podem variar conforme a versão do Spring AI.

**Explicação didática:**  
O `ChatModel` pode ser entendido como o componente que sabe conversar com o provedor.

O `ChatClient` funciona como uma interface de mais alto nível para montar a solicitação de maneira organizada:

~~~java
String resposta = chatClient
        .prompt()
        .system("Responda em português.")
        .user("Explique o que é uma API.")
        .call()
        .content();
~~~

A aplicação geralmente não precisa conhecer todos os detalhes internos da chamada HTTP ao provedor.

**Como o candidato deve responder:**

- Explicar que ambos estão relacionados à interação com modelos;
- Diferenciar a abstração do modelo da API de construção da solicitação;
- Citar a facilidade de uso do `ChatClient`;
- Reconhecer que os detalhes dependem da versão;
- Relacionar a escolha à separação de responsabilidades.

**Resposta fraca ou incompleta:**  
“`ChatClient` e `ChatModel` são exatamente a mesma classe.”

Essa resposta não demonstra compreensão das diferentes camadas de abstração.

**Critérios de avaliação:**

- **0** — Não sabe explicar nenhum dos conceitos.
- **1** — Confunde os componentes.
- **2** — Reconhece que são componentes relacionados, mas não diferencia suas funções.
- **3** — Explica corretamente a diferença geral.
- **4** — Relaciona `ChatClient` à construção de prompts e à organização da aplicação.
- **5** — Discute abstração, configuração, testabilidade, versões e separação entre infraestrutura e negócio.

**Perguntas de aprofundamento:**

1. Em que camada da aplicação você utilizaria o `ChatClient`?
2. Por que não seria ideal montar chamadas HTTP diretamente no controller?
3. Como testaria um serviço que utiliza `ChatClient`?

---

## Pergunta 72 — Mensagens de sistema, usuário e assistente

**Nível:** Júnior  
**Categoria:** Fundamentos de conversação

**Pergunta do entrevistador:**  
Qual é a finalidade das mensagens de sistema, usuário e assistente em uma conversa com um modelo?

**O que essa pergunta avalia:**  
Avalia o entendimento dos diferentes papéis utilizados na construção de uma conversa.

**Resposta esperada:**  
As mensagens possuem funções diferentes:

- **Sistema:** define instruções gerais, comportamento e limites do assistente;
- **Usuário:** contém a solicitação ou pergunta feita à aplicação;
- **Assistente:** representa respostas anteriores produzidas pelo modelo.

As mensagens são organizadas em uma sequência que fornece contexto para a próxima resposta.

A mensagem de sistema pode orientar o modelo a responder em determinado idioma ou formato, mas não substitui as validações e as regras de segurança da aplicação.

**Explicação didática:**  
Uma conversa poderia ser representada assim:

~~~text
Sistema: responda de forma objetiva e use apenas o contexto fornecido.
Usuário: qual é o prazo para solicitar férias?
Assistente: a solicitação deve ser feita com 30 dias de antecedência.
Usuário: esse prazo também vale para estagiários?
~~~

A última pergunta pode depender da mensagem anterior. Por isso, o histórico precisa ser enviado novamente quando for necessário.

**Exemplo de fluxo:**

~~~mermaid
sequenceDiagram
    participant A as Aplicação
    participant M as Modelo

    A->>M: Mensagem de sistema
    A->>M: Histórico da conversa
    A->>M: Nova mensagem do usuário
    M-->>A: Mensagem do assistente
~~~

**Como o candidato deve responder:**

- Definir os três papéis;
- Explicar a função da mensagem de sistema;
- Relacionar o histórico às mensagens anteriores;
- Mencionar que o papel não é uma barreira de segurança absoluta;
- Demonstrar como as mensagens ajudam a manter o contexto.

**Resposta fraca ou incompleta:**  
“A mensagem de sistema é apenas a primeira pergunta do usuário.”

Ela possui finalidade diferente e normalmente define instruções gerais para o comportamento do modelo.

**Critérios de avaliação:**

- **0** — Não conhece os papéis.
- **1** — Confunde usuário e assistente.
- **2** — Reconhece alguns papéis, mas não explica suas funções.
- **3** — Diferencia corretamente as mensagens.
- **4** — Relaciona os papéis ao histórico e ao comportamento do modelo.
- **5** — Discute prioridade das instruções, limitações de segurança e gerenciamento de contexto.

**Perguntas de aprofundamento:**

1. O que aconteceria se o histórico não fosse enviado?
2. A mensagem de sistema pode substituir autorização?
3. Como armazenaria as mensagens de uma conversa?

---

## Pergunta 73 — Uso de advisors

**Nível:** Júnior  
**Categoria:** Spring AI e extensibilidade

**Pergunta do entrevistador:**  
O que são advisors em uma aplicação Spring AI e que tipo de responsabilidade eles podem ajudar a organizar?

**O que essa pergunta avalia:**  
Avalia se o candidato conhece mecanismos de extensão utilizados para adicionar comportamentos ao fluxo de uma chamada.

**Resposta esperada:**  
Advisors são componentes que podem participar do processamento de uma solicitação ou resposta, ajudando a adicionar comportamentos reutilizáveis ao fluxo do `ChatClient`.

Eles podem ser usados para organizar funcionalidades como:

- Recuperação de contexto;
- Memória de conversação;
- Modificação de prompts;
- Observabilidade;
- Controle de determinados aspectos da chamada;
- Integração com fluxos de RAG.

A utilização exata depende da versão e da configuração da aplicação. O candidato deve compreender o conceito sem depender apenas da memorização de nomes de classes.

**Explicação didática:**  
Em vez de colocar toda a lógica de histórico ou recuperação de documentos diretamente no serviço, um advisor pode ajudar a executar essa etapa de maneira reutilizável.

Um fluxo conceitual seria:

~~~mermaid
flowchart LR
    A[Solicitação] --> B[Advisor de memória]
    B --> C[Advisor de recuperação]
    C --> D[ChatClient]
    D --> E[Modelo]
    E --> F[Resposta]
~~~

Isso pode reduzir duplicação, mas não elimina a necessidade de compreender o que acontece com os dados.

**Como o candidato deve responder:**

- Explicar advisors como componentes de extensão;
- Citar memória, recuperação ou observabilidade;
- Relacionar o recurso à reutilização;
- Reconhecer diferenças entre versões;
- Evitar colocar responsabilidades críticas apenas em componentes automáticos sem monitoramento.

**Resposta fraca ou incompleta:**  
“Advisor é um modelo menor usado para responder mais rápido.”

Essa definição não corresponde ao papel geral de um advisor.

**Critérios de avaliação:**

- **0** — Não entende o conceito.
- **1** — Confunde advisor com modelo.
- **2** — Sabe que é um componente auxiliar, mas não identifica seus usos.
- **3** — Explica corretamente a finalidade geral.
- **4** — Relaciona advisors a memória, RAG e reutilização.
- **5** — Discute ordem de execução, observabilidade, efeitos no prompt e cuidados de configuração.

**Perguntas de aprofundamento:**

1. Que responsabilidade você colocaria em um advisor de recuperação?
2. Como verificaria se um advisor está adicionando o contexto correto?
3. Quais riscos podem surgir ao adicionar vários advisors?

---

## Pergunta 74 — Uso de `PromptTemplate`

**Nível:** Júnior  
**Categoria:** Prompts e manutenção

**Pergunta do entrevistador:**  
Como um `PromptTemplate` pode ajudar na construção de solicitações para um modelo?

**O que essa pergunta avalia:**  
Avalia se o candidato entende a separação entre instruções fixas e valores dinâmicos.

**Resposta esperada:**  
Um `PromptTemplate` permite definir uma estrutura de prompt com variáveis que serão preenchidas durante a execução.

Ele pode ajudar a:

- Reutilizar instruções;
- Melhorar a legibilidade;
- Evitar concatenações extensas;
- Padronizar respostas;
- Facilitar alterações;
- Separar conteúdo do prompt da lógica de negócio.

As variáveis precisam ser validadas antes de serem inseridas. Não se deve assumir que todo conteúdo fornecido pelo usuário é confiável.

**Exemplo conceitual:**

~~~java
String template = """
        Responda em {idioma}.
        Utilize somente o contexto abaixo:

        {contexto}

        Pergunta:
        {pergunta}
        """;
~~~

A forma exata de criar e preencher o template varia conforme a versão adotada.

**Explicação didática:**  
Sem um template, o código pode ficar espalhado entre várias concatenações.

Com um template, a estrutura da solicitação fica mais clara e pode ser revisada separadamente.

Também é possível manter templates diferentes para tarefas como:

- Classificação;
- Resumo;
- Perguntas e respostas;
- Extração estruturada;
- Reformulação de texto.

**Como o candidato deve responder:**

- Definir o papel do template;
- Mencionar variáveis e instruções fixas;
- Relacionar o recurso à manutenção;
- Citar validação e segurança;
- Explicar que templates podem ser versionados.

**Resposta fraca ou incompleta:**  
“Template serve apenas para substituir palavras dentro de uma frase.”

Embora faça substituições, seu benefício principal inclui organização, reutilização e padronização de prompts.

**Critérios de avaliação:**

- **0** — Não entende templates.
- **1** — Confunde template com resposta do modelo.
- **2** — Reconhece variáveis, mas não explica sua utilidade.
- **3** — Explica corretamente a construção parametrizada.
- **4** — Considera manutenção, validação e versionamento.
- **5** — Discute testes de prompts, segurança, governança e compatibilidade entre modelos.

**Perguntas de aprofundamento:**

1. Como validaria uma variável inserida no template?
2. Onde armazenaria templates em um projeto?
3. Como testaria duas versões do mesmo template?

---

## Pergunta 75 — Tratamento de exceções do provedor

**Nível:** Júnior  
**Categoria:** Confiabilidade e erros

**Pergunta do entrevistador:**  
Como você trataria exceções ocorridas durante uma chamada ao provedor de modelos?

**O que essa pergunta avalia:**  
Avalia se o candidato consegue diferenciar falhas de entrada, indisponibilidade externa e erros internos da aplicação.

**Resposta esperada:**  
A aplicação deve capturar e classificar os erros de forma adequada.

Algumas categorias possíveis são:

- Entrada inválida;
- Falha de autenticação;
- Limite de requisições;
- Timeout;
- Indisponibilidade temporária;
- Modelo inexistente;
- Resposta inválida;
- Erro inesperado da aplicação.

Para cada situação, a aplicação pode:

- Retornar um status apropriado;
- Solicitar uma nova tentativa controlada;
- Acionar um fallback;
- Informar uma mensagem segura ao usuário;
- Registrar detalhes técnicos sem expor credenciais;
- Acionar alertas em problemas recorrentes.

Não se deve apresentar ao usuário uma mensagem contendo stack trace, chave de API ou detalhes internos.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Chamada ao modelo] --> B{Ocorreu erro?}
    B -- Não --> C[Validar resposta]
    B -- Sim --> D[Classificar exceção]
    D --> E{Erro recuperável?}
    E -- Sim --> F[Retentar ou usar fallback]
    E -- Não --> G[Retornar erro controlado]
    F --> H[Registrar métrica]
    G --> H
~~~

**Como o candidato deve responder:**

- Diferenciar erros recuperáveis e permanentes;
- Mencionar mensagens amigáveis ao usuário;
- Considerar logs e métricas;
- Evitar expor detalhes internos;
- Relacionar retentativas ao tipo de erro;
- Citar fallback quando apropriado.

**Resposta fraca ou incompleta:**  
“Eu capturaria qualquer exceção e retornaria o texto dela para o usuário.”

Essa prática pode expor informações sensíveis e não diferencia as causas do problema.

**Critérios de avaliação:**

- **0** — Não propõe tratamento de erros.
- **1** — Exibe a exceção diretamente.
- **2** — Captura erros, mas não os classifica.
- **3** — Define tratamento básico e mensagem segura.
- **4** — Considera timeout, retentativas, fallback e monitoramento.
- **5** — Propõe uma estratégia consistente de mapeamento, observabilidade, segurança e degradação.

**Perguntas de aprofundamento:**

1. Quais erros deveriam gerar uma nova tentativa?
2. Que informações poderiam ser registradas internamente?
3. Qual mensagem apresentaria ao usuário em caso de indisponibilidade?

---

## Pergunta 76 — Rate limiting para usuários

**Nível:** Júnior  
**Categoria:** Segurança e operação

**Pergunta do entrevistador:**  
Por que uma aplicação que utiliza Spring AI pode precisar limitar a quantidade de chamadas por usuário?

**O que essa pergunta avalia:**  
Avalia consciência sobre abuso, custos, disponibilidade e justiça no uso compartilhado de recursos.

**Resposta esperada:**  
O rate limiting limita a quantidade de requisições que um usuário pode realizar em determinado intervalo.

Ele pode ajudar a:

- Evitar abuso;
- Controlar custos;
- Proteger o provedor;
- Evitar que um usuário consuma toda a capacidade;
- Reduzir risco de ataques automatizados;
- Manter uma experiência equilibrada entre usuários.

O limite pode variar de acordo com:

- Perfil do usuário;
- Tipo de operação;
- Custo da chamada;
- Plano ou contrato da aplicação;
- Capacidade disponível;
- Risco da funcionalidade.

O controle deve ocorrer no servidor e não apenas na interface do cliente.

**Explicação didática:**  
Um botão desabilitado no frontend não impede que alguém envie requisições diretamente ao endpoint.

Por isso, a aplicação deve identificar o usuário e controlar as chamadas no backend.

Um fluxo simples seria:

~~~mermaid
flowchart TD
    A[Receber requisição] --> B[Identificar usuário]
    B --> C[Consultar limite]
    C --> D{Limite disponível?}
    D -- Sim --> E[Processar chamada]
    D -- Não --> F[Retornar limite excedido]
    E --> G[Registrar consumo]
~~~

**Como o candidato deve responder:**

- Definir rate limiting;
- Relacionar o controle a custo e disponibilidade;
- Mencionar aplicação no backend;
- Considerar diferentes perfis e tipos de operação;
- Explicar a necessidade de informar o usuário adequadamente.

**Resposta fraca ou incompleta:**  
“Eu limitaria apenas o número de cliques no botão.”

Isso não protege o endpoint contra chamadas diretas, automação ou abuso.

**Critérios de avaliação:**

- **0** — Não identifica a necessidade de limites.
- **1** — Confia somente no frontend.
- **2** — Reconhece excesso de chamadas, mas não propõe controle.
- **3** — Explica rate limiting no servidor.
- **4** — Relaciona o recurso a custos, perfis e disponibilidade.
- **5** — Discute janelas de tempo, cotas, priorização, respostas de limite e métricas de abuso.

**Perguntas de aprofundamento:**

1. Como diferenciaria limites para perguntas simples e análises longas?
2. O que retornaria quando o limite fosse excedido?
3. Como evitaria que várias contas fossem usadas para contornar o limite?

---

## Pergunta 77 — Processamento em lote

**Nível:** Júnior  
**Categoria:** Desempenho e integração

**Pergunta do entrevistador:**  
Como você processaria muitos documentos ou solicitações usando Spring AI sem sobrecarregar a aplicação ou o provedor?

**O que essa pergunta avalia:**  
Avalia noções de processamento em lote, filas, limites de concorrência e recuperação de falhas.

**Resposta esperada:**  
O candidato pode propor:

- Divisão do trabalho em lotes;
- Fila de processamento;
- Limite de concorrência;
- Processamento assíncrono;
- Controle de retentativas;
- Registro do progresso;
- Persistência do estado;
- Tratamento de documentos que falharam;
- Pausas entre lotes quando necessário;
- Monitoramento de custo e tempo.

Não é adequado iniciar milhares de chamadas simultâneas sem verificar a capacidade da aplicação e os limites do provedor.

**Explicação didática:**  
Em uma ingestão de documentos, a aplicação pode processar uma quantidade limitada por vez.

Se um lote falhar, deve ser possível identificar quais itens foram processados e quais precisam ser repetidos. O processo também deve evitar duplicidade.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Lista de documentos] --> B[Dividir em lotes]
    B --> C[Adicionar à fila]
    C --> D[Processar com concorrência limitada]
    D --> E{Processamento concluído?}
    E -- Sim --> F[Registrar sucesso]
    E -- Não --> G[Registrar falha]
    G --> H[Retentar ou encaminhar para análise]
~~~

**Como o candidato deve responder:**

- Mencionar lotes e filas;
- Considerar limite de concorrência;
- Falar sobre progresso e falhas;
- Explicar como evitar duplicidade;
- Relacionar o processo a custo e limites do provedor.

**Resposta fraca ou incompleta:**  
“Eu iniciaria uma thread para cada documento.”

Essa abordagem pode esgotar recursos, provocar erros do provedor e tornar o processamento difícil de controlar.

**Critérios de avaliação:**

- **0** — Não apresenta estratégia para volume alto.
- **1** — Propõe chamadas ilimitadas.
- **2** — Menciona processamento paralelo, mas ignora limites.
- **3** — Propõe lotes ou fila com concorrência controlada.
- **4** — Considera estado, falhas, retentativas e monitoramento.
- **5** — Discute idempotência, retomada, priorização, backpressure e controle de custos.

**Perguntas de aprofundamento:**

1. Como retomaria o processamento após uma interrupção?
2. Como saberia quais documentos já foram processados?
3. Quando reduziria a concorrência?

---

## Pergunta 78 — Streaming e cancelamento

**Nível:** Júnior  
**Categoria:** Experiência do usuário

**Pergunta do entrevistador:**  
Como você permitiria que um usuário cancelasse uma resposta que está sendo transmitida gradualmente?

**O que essa pergunta avalia:**  
Avalia a compreensão de streaming, cancelamento de operações e liberação de recursos.

**Resposta esperada:**  
A aplicação deve associar a geração a um identificador de requisição ou tarefa e manter uma forma de sinalizar o cancelamento.

Quando o usuário cancelar, o sistema deve tentar:

- Interromper a solicitação ao modelo;
- Fechar a conexão de transmissão;
- Liberar recursos;
- Interromper o processamento posterior;
- Registrar o motivo do cancelamento;
- Evitar persistir uma resposta incompleta como se estivesse concluída.

O cancelamento pode não ser instantâneo, pois depende do cliente, da aplicação e do provedor.

**Explicação didática:**  
Um usuário pode iniciar uma resposta longa e perceber que fez a pergunta errada.

O frontend pode enviar uma solicitação de cancelamento. A aplicação identifica a operação correspondente e interrompe o fluxo quando possível.

~~~mermaid
sequenceDiagram
    participant U as Usuário
    participant C as Cliente
    participant A as Aplicação
    participant M as Modelo

    U->>C: Solicita geração
    C->>A: Inicia streaming
    A->>M: Solicita resposta
    M-->>A: Envia trechos
    A-->>C: Encaminha trechos
    U->>C: Cancela geração
    C->>A: Solicita cancelamento
    A->>M: Tenta interromper
    A-->>C: Encerra transmissão
~~~

**Como o candidato deve responder:**

- Explicar a necessidade de identificar a geração;
- Mencionar interrupção e fechamento da conexão;
- Considerar liberação de recursos;
- Diferenciar resposta cancelada de resposta concluída;
- Reconhecer que o cancelamento depende da infraestrutura.

**Resposta fraca ou incompleta:**  
“Eu esconderia o texto no frontend, mas deixaria o modelo continuar.”

Isso pode continuar consumindo recursos e gerar custos desnecessários.

**Critérios de avaliação:**

- **0** — Não entende o cancelamento.
- **1** — Atua apenas na interface.
- **2** — Reconhece que a conexão precisa ser encerrada, mas ignora o processamento.
- **3** — Explica um fluxo básico de cancelamento.
- **4** — Considera recursos, persistência e estado da tarefa.
- **5** — Discute cancelamento ponta a ponta, concorrência, consistência e limitações do provedor.

**Perguntas de aprofundamento:**

1. Como diferenciaria uma resposta cancelada de uma resposta com erro?
2. O que faria com os trechos já transmitidos?
3. Como impediria que a geração continuasse consumindo recursos?

---

## Pergunta 79 — Configuração de parâmetros específicos do provedor

**Nível:** Júnior  
**Categoria:** Configuração e portabilidade

**Pergunta do entrevistador:**  
Como você lidaria com parâmetros que existem em um provedor de modelos, mas não estão disponíveis em outro?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende diferenças entre provedores e os limites da portabilidade de uma abstração.

**Resposta esperada:**  
A aplicação deve diferenciar:

- Configurações comuns, como modelo, temperatura ou limite de saída;
- Configurações específicas de determinado provedor;
- Recursos que não possuem equivalente em outra integração.

Ao trocar de provedor, é necessário validar:

- Compatibilidade dos parâmetros;
- Formato das mensagens;
- Suporte a ferramentas;
- Limites de contexto;
- Formato estruturado;
- Streaming;
- Modelo de cobrança;
- Políticas de privacidade.

O Spring AI pode oferecer abstrações comuns, mas não elimina todas as diferenças entre provedores.

**Explicação didática:**  
Uma configuração usada em um provedor pode ser ignorada, rejeitada ou apresentar comportamento diferente em outro.

Por isso, não é seguro assumir que bastará trocar uma dependência e manter exatamente o mesmo resultado.

Uma arquitetura pode separar configurações comuns das específicas:

~~~mermaid
flowchart LR
    A[Configuração comum] --> B[Camada de integração]
    C[Configuração específica do provedor] --> B
    B --> D[Modelo selecionado]
~~~

**Como o candidato deve responder:**

- Reconhecer diferenças entre provedores;
- Separar configurações comuns e específicas;
- Mencionar testes de compatibilidade;
- Considerar recursos não suportados;
- Evitar prometer portabilidade total.

**Resposta fraca ou incompleta:**  
“Como o Spring AI abstrai os provedores, todos os parâmetros funcionam da mesma forma.”

A abstração facilita a integração, mas não elimina as diferenças específicas.

**Critérios de avaliação:**

- **0** — Não reconhece diferenças entre provedores.
- **1** — Assume compatibilidade total.
- **2** — Sabe que alguns parâmetros mudam, mas não identifica impactos.
- **3** — Explica a separação entre configurações comuns e específicas.
- **4** — Considera testes, recursos e limites distintos.
- **5** — Discute portabilidade realista, adaptadores, contratos, fallback e comportamento funcional entre provedores.

**Perguntas de aprofundamento:**

1. O que você testaria antes de trocar de provedor?
2. Como trataria uma funcionalidade sem equivalente?
3. Como documentaria configurações específicas?

---

## Pergunta 80 — Versionamento do Spring AI

**Nível:** Júnior  
**Categoria:** Manutenção e dependências

**Pergunta do entrevistador:**  
Quais cuidados você teria ao atualizar a versão do Spring AI em uma aplicação existente?

**O que essa pergunta avalia:**  
Avalia maturidade básica para atualização de dependências e prevenção de regressões.

**Resposta esperada:**  
Antes de atualizar, a equipe deve verificar:

- Mudanças incompatíveis;
- Alterações na configuração;
- Classes ou métodos descontinuados;
- Mudanças no comportamento dos advisors;
- Compatibilidade com a versão do Spring Boot;
- Alterações nos starters;
- Mudanças nos provedores;
- Atualizações de segurança;
- Impacto nos prompts e respostas;
- Alterações de custo ou desempenho.

A atualização deve ser realizada em ambiente controlado, com testes automatizados e avaliação das respostas geradas.

Como os modelos e integrações podem mudar de comportamento, não basta verificar se o projeto continua compilando.

**Explicação didática:**  
Uma atualização pode alterar:

- A forma de construir uma solicitação;
- O tratamento de mensagens;
- O formato da resposta;
- O funcionamento da memória;
- A integração com o banco vetorial;
- O suporte a ferramentas;
- O comportamento dos testes.

Por isso, é importante comparar o comportamento antes e depois da atualização.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Planejar atualização] --> B[Consultar mudanças da versão]
    B --> C[Atualizar em ambiente de teste]
    C --> D[Executar testes automatizados]
    D --> E[Avaliar respostas e desempenho]
    E --> F{Resultados adequados?}
    F -- Sim --> G[Publicar gradualmente]
    F -- Não --> H[Corrigir ou reverter]
~~~

**Como o candidato deve responder:**

- Mencionar compatibilidade entre versões;
- Citar mudanças incompatíveis;
- Falar sobre testes automatizados;
- Considerar qualidade das respostas;
- Explicar a necessidade de atualização gradual;
- Incluir possibilidade de reversão.

**Resposta fraca ou incompleta:**  
“Eu atualizaria a dependência e verificaria se o projeto compila.”

A compilação não garante que os prompts, integrações, respostas e fluxos de negócio continuem funcionando corretamente.

**Critérios de avaliação:**

- **0** — Não identifica riscos de atualização.
- **1** — Atualiza diretamente em produção.
- **2** — Menciona testes, mas ignora mudanças comportamentais.
- **3** — Considera compatibilidade e validação básica.
- **4** — Inclui testes, desempenho, prompts e reversão.
- **5** — Propõe atualização controlada, avaliação funcional, observabilidade e estratégia segura de rollout.

**Perguntas de aprofundamento:**

1. Que tipos de teste executaria após a atualização?
2. Como identificaria uma regressão na qualidade das respostas?
3. Quando faria rollback da versão atualizada?

---

## Resumo desta parte

- **Perguntas apresentadas:** 71 a 80
- **Perguntas restantes:** 81 a 100
- **Categorias abordadas:** Spring AI, conversação, prompts, advisors, confiabilidade, segurança, desempenho, streaming, portabilidade e manutenção
- **Competências avaliadas:** diferença entre `ChatClient` e `ChatModel`, papéis das mensagens, uso de advisors e templates, tratamento de exceções, rate limiting, processamento em lote, cancelamento de streaming, diferenças entre provedores e atualização segura de dependências

A próxima parte deve continuar com as perguntas **81 a 90**, mantendo a mesma estrutura e a numeração sequencial.

---

# Roteiro de Entrevista Técnica — Spring AI

> **Parte 9 de 10**  
> Esta parte contém as perguntas **81 a 90 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

---

## Pergunta 81 — `ChatMemory` e gerenciamento de contexto

**Nível:** Júnior  
**Categoria:** Conversação e estado

**Pergunta do entrevistador:**  
Qual é a finalidade do `ChatMemory` em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende como manter informações relevantes de uma conversa entre diferentes interações.

**Resposta esperada:**  
O `ChatMemory` auxilia no armazenamento e na recuperação de mensagens anteriores de uma conversa.

Ele pode ser utilizado para:

- Manter continuidade entre perguntas;
- Recuperar mensagens recentes;
- Associar mensagens a uma conversa;
- Reduzir a necessidade de implementar manualmente todo o gerenciamento do histórico;
- Integrar o histórico ao fluxo de um `ChatClient`.

A memória não significa que o modelo aprendeu permanentemente os dados. Ela representa um mecanismo da aplicação para recuperar contexto e enviá-lo novamente ao modelo.

A aplicação ainda precisa controlar:

- Identificação da conversa;
- Usuário proprietário;
- Tamanho do histórico;
- Persistência;
- Privacidade;
- Expiração;
- Estratégia de resumo.

**Explicação didática:**  
Sem memória:

~~~mermaid
sequenceDiagram
    participant U as Usuário
    participant A as Aplicação
    participant M as Modelo

    U->>A: Primeira pergunta
    A->>M: Envia pergunta
    M-->>A: Resposta
    U->>A: Pergunta complementar
    A->>M: Envia somente nova pergunta
    M-->>A: Pode não entender o contexto
~~~

Com memória, a aplicação recupera mensagens anteriores e as inclui na próxima chamada.

A configuração exata do `ChatMemory` pode variar conforme a versão do Spring AI. O candidato deve compreender o conceito sem depender somente de nomes específicos de classes.

**Como o candidato deve responder:**

- Definir memória conversacional;
- Diferenciar memória de treinamento do modelo;
- Mencionar armazenamento e recuperação;
- Considerar limite de contexto e privacidade;
- Explicar que a memória deve ser vinculada ao usuário e à conversa correta.

**Resposta fraca ou incompleta:**  
“`ChatMemory` faz o modelo aprender permanentemente tudo que o usuário disse.”

Essa resposta confunde histórico de conversa com treinamento ou atualização permanente do modelo.

**Critérios de avaliação:**

- **0** — Não entende o conceito de memória.
- **1** — Confunde memória com treinamento.
- **2** — Reconhece histórico, mas não explica seu gerenciamento.
- **3** — Explica corretamente o uso da memória.
- **4** — Considera persistência, privacidade e limite de contexto.
- **5** — Propõe uma estratégia completa de memória, resumo, expiração e isolamento por usuário.

**Perguntas de aprofundamento:**

1. Onde você armazenaria a memória em uma aplicação distribuída?
2. Como evitaria que o histórico crescesse indefinidamente?
3. Como permitiria que o usuário apagasse a própria conversa?

---

## Pergunta 82 — Advisors de memória e recuperação

**Nível:** Júnior  
**Categoria:** Spring AI e RAG

**Pergunta do entrevistador:**  
Como um advisor pode ajudar a adicionar memória ou contexto recuperado a uma chamada do `ChatClient`?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende como comportamentos reutilizáveis podem ser incorporados ao fluxo de interação com o modelo.

**Resposta esperada:**  
Um advisor pode interceptar ou participar do fluxo de uma chamada, adicionando informações antes da consulta ao modelo ou processando a resposta depois.

Um advisor de memória pode:

- Identificar a conversa;
- Recuperar mensagens anteriores;
- Adicionar o histórico ao contexto;
- Salvar a nova interação após a resposta.

Um advisor de recuperação pode:

- Receber a pergunta;
- Consultar um banco vetorial;
- Recuperar documentos relevantes;
- Adicionar os trechos ao prompt;
- Permitir que o modelo responda com base no contexto.

O uso de advisors reduz duplicação, mas a aplicação ainda precisa compreender e monitorar o comportamento deles.

**Fluxo conceitual:**

~~~mermaid
flowchart LR
    A[Pergunta do usuário] --> B[Advisor de memória]
    B --> C[Advisor de recuperação]
    C --> D[ChatClient]
    D --> E[Modelo]
    E --> F[Resposta]
    F --> G[Salvar interação]
~~~

Os nomes, construtores e configurações podem mudar entre versões do Spring AI.

**Como o candidato deve responder:**

- Explicar o advisor como componente de extensão;
- Relacionar memória e recuperação ao fluxo;
- Mencionar ordem de execução;
- Considerar autorização dos dados recuperados;
- Evitar tratar advisors como uma solução automática para todos os problemas.

**Resposta fraca ou incompleta:**  
“Advisor é um tipo de modelo que gera uma segunda resposta.”

Essa definição não corresponde ao papel de extensão e composição do fluxo.

**Critérios de avaliação:**

- **0** — Não entende advisors.
- **1** — Confunde advisor com modelo.
- **2** — Sabe que é um componente auxiliar, mas não explica sua função.
- **3** — Explica o uso geral em memória ou RAG.
- **4** — Considera ordem, contexto, autorização e monitoramento.
- **5** — Analisa composição de advisors, efeitos no prompt, custo, depuração e diferenças entre versões.

**Perguntas de aprofundamento:**

1. O que poderia acontecer se dois advisors adicionassem informações conflitantes?
2. Como verificaria qual contexto foi adicionado ao prompt?
3. Como evitaria que um advisor recuperasse dados não autorizados?

---

## Pergunta 83 — `VectorStore` e persistência de embeddings

**Nível:** Júnior  
**Categoria:** Armazenamento e RAG

**Pergunta do entrevistador:**  
Qual é a função de um `VectorStore` em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende o papel da abstração de armazenamento vetorial no processo de recuperação semântica.

**Resposta esperada:**  
O `VectorStore` é utilizado para armazenar documentos, trechos de conteúdo, embeddings e metadados, além de realizar buscas por similaridade.

Um fluxo típico é:

1. Dividir documentos em trechos;
2. Gerar embeddings;
3. Armazenar os trechos e os vetores;
4. Gerar o embedding da pergunta;
5. Buscar conteúdos semanticamente semelhantes;
6. Utilizar os resultados como contexto para o modelo.

A abstração facilita a integração com diferentes tecnologias de armazenamento, mas cada implementação pode possuir recursos e limitações próprios.

**Exemplo conceitual:**

~~~java
List<Document> documentos = vectorStore.similaritySearch(
        SearchRequest.builder()
                .query(pergunta)
                .topK(5)
                .build()
);
~~~

O exemplo é ilustrativo. Métodos e tipos podem variar conforme a versão utilizada.

**Explicação didática:**  
Um banco vetorial não precisa armazenar apenas o vetor. Para que o sistema seja útil, também é importante manter:

- Texto original ou trecho;
- Identificador da fonte;
- Título;
- Data de atualização;
- Permissões;
- Categoria;
- Versão do documento.

A dimensão do vetor precisa ser compatível com o modelo de embedding utilizado.

**Como o candidato deve responder:**

- Definir o papel do `VectorStore`;
- Relacionar embeddings à busca semântica;
- Mencionar documentos e metadados;
- Explicar o uso em RAG;
- Considerar atualização e compatibilidade dos embeddings.

**Resposta fraca ou incompleta:**  
“`VectorStore` é usado para armazenar as respostas prontas do chatbot.”

Ele normalmente armazena conteúdo indexado e representações vetoriais para permitir recuperação por similaridade.

**Critérios de avaliação:**

- **0** — Não entende o componente.
- **1** — Confunde vetores com respostas finais.
- **2** — Relaciona a documentos, mas não explica a busca.
- **3** — Explica corretamente o uso em RAG.
- **4** — Considera metadados, dimensões e atualização.
- **5** — Discute indexação, filtros, versionamento, avaliação da recuperação e limitações do armazenamento.

**Perguntas de aprofundamento:**

1. O que aconteceria se o modelo de embedding fosse trocado?
2. Por que os metadados são importantes?
3. Como removeria os trechos de um documento excluído?

---

## Pergunta 84 — `DocumentReader` e carregamento de conteúdo

**Nível:** Júnior  
**Categoria:** Ingestão de dados

**Pergunta do entrevistador:**  
Qual é a finalidade de um componente de leitura de documentos em um fluxo de ingestão do Spring AI?

**O que essa pergunta avalia:**  
Avalia o entendimento das etapas de carregamento e transformação de arquivos antes da indexação.

**Resposta esperada:**  
Um leitor de documentos é responsável por carregar conteúdo de uma fonte, como:

- Arquivo de texto;
- PDF;
- Página web;
- Diretório;
- Banco de dados;
- Outro repositório de informações.

Depois da leitura, o conteúdo pode ser transformado em objetos de documento, divididos em trechos, enriquecido com metadados e enviado para geração de embeddings.

A leitura não garante que o conteúdo foi extraído corretamente. Arquivos com tabelas, imagens, colunas ou texto digitalizado podem exigir tratamento adicional.

**Fluxo conceitual:**

~~~mermaid
flowchart LR
    A[Fonte original] --> B[Leitor de documentos]
    B --> C[Documentos]
    C --> D[Limpeza]
    D --> E[Divisão em trechos]
    E --> F[Embeddings]
    F --> G[VectorStore]
~~~

**Exemplo prático:**  
Uma aplicação pode ler um manual em PDF, preservar o título e a seção, dividir o conteúdo em trechos e armazená-los com os metadados da versão do documento.

**Como o candidato deve responder:**

- Explicar a função do leitor;
- Diferenciar leitura de indexação;
- Mencionar extração de texto;
- Considerar erros em PDFs e documentos complexos;
- Relacionar o resultado ao chunking e aos embeddings.

**Resposta fraca ou incompleta:**  
“Basta enviar qualquer arquivo diretamente para o modelo.”

A aplicação precisa preparar, validar e, em muitos casos, indexar o conteúdo de maneira controlada.

**Critérios de avaliação:**

- **0** — Não entende a etapa de leitura.
- **1** — Confunde arquivo com embedding.
- **2** — Reconhece o carregamento, mas não explica o processamento posterior.
- **3** — Descreve corretamente a ingestão básica.
- **4** — Considera metadados, qualidade da extração e documentos complexos.
- **5** — Propõe um processo completo, monitorado, versionado e capaz de tratar falhas de extração.

**Perguntas de aprofundamento:**

1. Como trataria um PDF formado apenas por imagens?
2. O que faria se a extração produzisse texto fora de ordem?
3. Como identificaria que um documento foi alterado?

---

## Pergunta 85 — `DocumentTransformer` e divisão de documentos

**Nível:** Júnior  
**Categoria:** RAG e preparação de conteúdo

**Pergunta do entrevistador:**  
Qual é o papel de um transformador de documentos em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende que o conteúdo lido precisa ser preparado antes de gerar embeddings e realizar buscas.

**Resposta esperada:**  
Um transformador modifica ou prepara documentos para uma etapa posterior.

Ele pode ser utilizado para:

- Dividir documentos em trechos;
- Limpar conteúdo;
- Adicionar ou ajustar metadados;
- Remover informações desnecessárias;
- Normalizar texto;
- Preparar dados para embeddings;
- Adaptar conteúdos diferentes para um formato comum.

No caso de divisão de documentos, é importante equilibrar tamanho do trecho e preservação do contexto.

**Explicação didática:**  
Se um trecho for pequeno demais, pode perder o significado da informação. Se for grande demais, pode incluir ruído e ultrapassar o limite de contexto.

A sobreposição entre trechos pode ajudar quando uma frase ou explicação continua de uma parte para outra.

**Exemplo conceitual:**

~~~java
List<Document> partes = textSplitter.apply(documentos);
~~~

A API exata depende do transformador e da versão do Spring AI.

**Como o candidato deve responder:**

- Explicar transformação como preparação;
- Mencionar chunking e metadados;
- Considerar tamanho e sobreposição;
- Relacionar a qualidade da busca;
- Reconhecer que diferentes documentos podem exigir estratégias diferentes.

**Resposta fraca ou incompleta:**  
“Transformador serve apenas para converter PDF em TXT.”

A transformação pode incluir limpeza, divisão, enriquecimento e normalização de diferentes fontes.

**Critérios de avaliação:**

- **0** — Não compreende o conceito.
- **1** — Confunde transformação com geração de resposta.
- **2** — Reconhece alteração do documento, mas não explica o objetivo.
- **3** — Explica corretamente o uso na preparação do RAG.
- **4** — Considera chunking, metadados e preservação de contexto.
- **5** — Discute estratégias específicas por tipo de documento e avaliação da recuperação.

**Perguntas de aprofundamento:**

1. Como escolheria o tamanho dos trechos?
2. Quando a sobreposição poderia aumentar o custo sem trazer benefício?
3. Como preservaria a relação entre um trecho e sua fonte original?

---

## Pergunta 86 — Saídas estruturadas e conversão para objetos

**Nível:** Júnior  
**Categoria:** Integração e validação

**Pergunta do entrevistador:**  
Como você faria para transformar a resposta do modelo em um objeto Java utilizando Spring AI?

**O que essa pergunta avalia:**  
Avalia o entendimento de respostas estruturadas, conversão de dados e validação de saída.

**Resposta esperada:**  
A aplicação pode solicitar que o modelo responda em um formato estruturado e utilizar um conversor para transformar o resultado em um objeto Java.

O fluxo deve incluir:

1. Definir o formato esperado;
2. Informar os campos necessários;
3. Realizar a chamada ao modelo;
4. Converter a saída;
5. Validar os campos;
6. Tratar respostas inválidas ou incompletas.

Mesmo utilizando um conversor, a aplicação não deve assumir que o conteúdo está correto do ponto de vista da regra de negócio.

**Exemplo conceitual:**

~~~java
public record Analise(
        String categoria,
        String resumo
) {}

Analise resultado = chatClient
        .prompt()
        .user(pergunta)
        .call()
        .entity(Analise.class);
~~~

A disponibilidade e o comportamento de métodos como `entity` dependem da versão e da configuração do Spring AI.

**Como o candidato deve responder:**

- Explicar a conversão para objeto;
- Mencionar formato estruturado;
- Validar campos obrigatórios;
- Tratar erro de conversão;
- Diferenciar conversão sintática de validação de negócio.

**Resposta fraca ou incompleta:**  
“Eu faria um cast da resposta textual para a classe Java.”

Uma string não pode ser convertida automaticamente em objeto sem uma estratégia de desserialização e validação.

**Critérios de avaliação:**

- **0** — Não sabe como trabalhar com respostas estruturadas.
- **1** — Propõe apenas um cast.
- **2** — Reconhece JSON, mas ignora validações.
- **3** — Explica conversão e validação básica.
- **4** — Considera campos ausentes, tipos inválidos e fallback.
- **5** — Discute contratos de saída, validação semântica, versões, observabilidade e tratamento seguro de respostas inválidas.

**Perguntas de aprofundamento:**

1. O que faria se faltasse um campo obrigatório?
2. Como validaria um valor de enumeração?
3. Em que situação retornaria erro em vez de tentar corrigir a resposta?

---

## Pergunta 87 — `OutputParser` e interpretação da resposta

**Nível:** Júnior  
**Categoria:** Processamento de saída

**Pergunta do entrevistador:**  
Qual é a finalidade de um parser de saída em uma aplicação que utiliza Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende como orientar e interpretar respostas que precisam seguir determinado formato.

**Resposta esperada:**  
Um parser de saída ajuda a definir ou interpretar o formato esperado da resposta do modelo.

Ele pode:

- Informar ao modelo quais campos deve retornar;
- Auxiliar na construção das instruções;
- Converter texto estruturado para objetos;
- Detectar respostas incompatíveis;
- Padronizar o resultado consumido pela aplicação.

O parser não transforma uma resposta incorreta em verdadeira. Depois da interpretação, a aplicação ainda deve validar regras, permissões, limites e consistência.

**Exemplo prático:**  
Uma classificação de chamado pode esperar:

~~~json
{
  "categoria": "ACESSO",
  "prioridade": "ALTA",
  "resumo": "Usuário não consegue acessar o sistema"
}
~~~

A aplicação deve verificar se `ACESSO` e `ALTA` são valores permitidos e se o resumo foi preenchido.

**Como o candidato deve responder:**

- Explicar o papel do parser;
- Relacionar o parser ao formato esperado;
- Mencionar conversão e validação;
- Diferenciar sintaxe válida de conteúdo correto;
- Considerar fallback para respostas inválidas.

**Resposta fraca ou incompleta:**  
“Parser garante que o modelo sempre responderá corretamente.”

Ele pode auxiliar na estrutura, mas não garante precisão factual ou adequação à regra de negócio.

**Critérios de avaliação:**

- **0** — Não conhece o conceito.
- **1** — Confunde parser com modelo.
- **2** — Relaciona a JSON, mas não explica sua função.
- **3** — Explica interpretação e validação estrutural.
- **4** — Considera erros, campos e valores permitidos.
- **5** — Discute contratos, compatibilidade, observabilidade e tratamento de respostas semanticamente incorretas.

**Perguntas de aprofundamento:**

1. Como trataria uma saída que contém texto antes do JSON?
2. O que faria se o formato mudasse entre versões do prompt?
3. Por que uma resposta JSON válida ainda pode ser perigosa?

---

## Pergunta 88 — Observabilidade com Micrometer

**Nível:** Júnior  
**Categoria:** Monitoramento

**Pergunta do entrevistador:**  
Como você utilizaria observabilidade para acompanhar uma integração Spring AI em produção?

**O que essa pergunta avalia:**  
Avalia a capacidade de monitorar chamadas externas, identificar problemas e acompanhar custos e desempenho.

**Resposta esperada:**  
A aplicação pode utilizar recursos de observabilidade para acompanhar:

- Quantidade de chamadas;
- Tempo de resposta;
- Erros;
- Timeouts;
- Provedor;
- Modelo;
- Tokens consumidos, quando disponíveis;
- Taxa de respostas vazias;
- Número de retentativas;
- Uso de cache;
- Quantidade de documentos recuperados.

O Spring Boot e o ecossistema Micrometer podem ajudar a publicar métricas para sistemas de monitoramento. A configuração exata depende das versões e dos componentes adotados.

Também é importante evitar registrar prompts, respostas ou dados pessoais completos sem necessidade.

**Exemplo de métricas úteis:**

~~~text
ai.requests.total
ai.requests.duration
ai.requests.errors
ai.tokens.input
ai.tokens.output
ai.retrieval.documents
ai.retries.total
~~~

Os nomes são apenas ilustrativos e podem ser definidos conforme o padrão do projeto.

**Como o candidato deve responder:**

- Citar métricas e logs;
- Mencionar tempo de resposta e erros;
- Considerar tokens e custos;
- Relacionar observabilidade a troubleshooting;
- Proteger dados sensíveis.

**Resposta fraca ou incompleta:**  
“Eu salvaria o prompt e a resposta completa em todos os logs.”

Essa prática pode expor dados pessoais, informações confidenciais e credenciais.

**Critérios de avaliação:**

- **0** — Não propõe observabilidade.
- **1** — Sugere apenas imprimir mensagens no console.
- **2** — Menciona logs, mas ignora privacidade.
- **3** — Lista métricas básicas de chamadas e erros.
- **4** — Considera tokens, latência, retentativas e alertas.
- **5** — Propõe observabilidade segura, com correlação, métricas de qualidade, controle de retenção e análise de custos.

**Perguntas de aprofundamento:**

1. Como identificaria se o problema está no modelo ou no banco vetorial?
2. Que métrica indicaria aumento de custo?
3. Como investigaria uma falha sem armazenar o prompt completo?

---

## Pergunta 89 — Teste de integração com provedor externo

**Nível:** Júnior  
**Categoria:** Testes e confiabilidade

**Pergunta do entrevistador:**  
Quando um teste de integração com um provedor real de modelos pode ser útil e quais cuidados você teria?

**O que essa pergunta avalia:**  
Avalia se o candidato consegue diferenciar testes unitários, testes de integração e avaliações de comportamento do modelo.

**Resposta esperada:**  
Um teste de integração pode verificar se:

- As credenciais estão configuradas;
- A comunicação com o provedor funciona;
- O modelo selecionado está disponível;
- O formato da requisição é aceito;
- O streaming ou a conversão funcionam;
- O tratamento de erros está adequado.

Porém, esse tipo de teste pode ser:

- Mais lento;
- Mais caro;
- Instável por causa da rede;
- Variável por causa da saída do modelo;
- Dependente de limites externos.

Por isso, deve ser executado de forma controlada, com dados não sensíveis, limites de custo e expectativas flexíveis sobre respostas textuais.

**Estratégia em camadas:**

~~~mermaid
flowchart TD
    A[Testes unitários] --> B[Testes com dublês]
    B --> C[Testes de integração controlados]
    C --> D[Avaliação de qualidade]
    D --> E[Monitoramento em produção]
~~~

Testes unitários devem verificar regras da aplicação sem depender do provedor. Testes de integração verificam a conexão real. Avaliações de qualidade verificam se o resultado atende ao objetivo.

**Como o candidato deve responder:**

- Diferenciar tipos de teste;
- Citar custo, latência e variabilidade;
- Utilizar mocks ou stubs nos testes unitários;
- Proteger credenciais;
- Considerar critérios de qualidade e não apenas status HTTP.

**Resposta fraca ou incompleta:**  
“Todos os testes deveriam chamar o provedor real para serem confiáveis.”

Isso torna a suíte lenta, cara e instável.

**Critérios de avaliação:**

- **0** — Não apresenta estratégia de testes.
- **1** — Depende exclusivamente de chamadas reais.
- **2** — Conhece mocks, mas não diferencia os níveis de teste.
- **3** — Propõe testes unitários isolados e integração controlada.
- **4** — Considera custos, variabilidade, erros e segurança.
- **5** — Organiza uma estratégia completa com contratos, integração, avaliação de qualidade e monitoramento contínuo.

**Perguntas de aprofundamento:**

1. Como testaria uma resposta que pode variar, mas continua correta?
2. Como simularia um timeout do provedor?
3. Como evitaria que dados reais fossem enviados durante os testes?

---

## Pergunta 90 — Migração entre versões do Spring AI

**Nível:** Júnior  
**Categoria:** Manutenção e compatibilidade

**Pergunta do entrevistador:**  
Quais cuidados você teria ao atualizar o Spring AI para uma nova versão?

**O que essa pergunta avalia:**  
Avalia a capacidade do candidato de lidar com mudanças de dependências, APIs e comportamento.

**Resposta esperada:**  
Antes de atualizar, a equipe deve verificar:

- Compatibilidade com a versão do Spring Boot;
- Mudanças incompatíveis;
- Classes e métodos descontinuados;
- Alterações nos starters;
- Alterações nos nomes das propriedades;
- Mudanças em advisors;
- Modificações no `ChatClient`;
- Compatibilidade com o provedor;
- Mudanças no banco vetorial;
- Alterações na conversão de respostas;
- Atualizações de segurança.

A atualização deve ser feita em ambiente controlado, utilizando testes automatizados e avaliação de comportamento.

Não basta verificar se o projeto continua compilando. Uma aplicação pode compilar e ainda apresentar:

- Respostas diferentes;
- Prompts modificados;
- Falhas de configuração;
- Alterações de custo;
- Diferenças no histórico;
- Mudança na qualidade do RAG.

**Fluxo recomendado:**

~~~mermaid
flowchart TD
    A[Identificar versão atual] --> B[Consultar notas da atualização]
    B --> C[Atualizar em ambiente de teste]
    C --> D[Corrigir incompatibilidades]
    D --> E[Executar testes]
    E --> F[Avaliar respostas e desempenho]
    F --> G{Resultado adequado?}
    G -- Sim --> H[Publicar gradualmente]
    G -- Não --> I[Corrigir ou reverter]
~~~

A forma exata de migração depende da versão de origem, da versão de destino e dos módulos utilizados.

**Como o candidato deve responder:**

- Verificar compatibilidade de versões;
- Consultar documentação e notas de alteração;
- Executar testes;
- Avaliar comportamento funcional e qualidade das respostas;
- Planejar rollback;
- Considerar propriedades e integrações externas.

**Resposta fraca ou incompleta:**  
“Eu alteraria a versão no gerenciador de dependências e executaria o build.”

Isso verifica apenas parte da compatibilidade e não garante que o comportamento da aplicação permaneceu correto.

**Critérios de avaliação:**

- **0** — Não identifica riscos de atualização.
- **1** — Atualiza diretamente em produção.
- **2** — Considera apenas compilação.
- **3** — Propõe testes e verificação de compatibilidade.
- **4** — Inclui prompts, RAG, configuração, custo e desempenho.
- **5** — Apresenta uma estratégia controlada com testes, observabilidade, liberação gradual e possibilidade de reversão.

**Perguntas de aprofundamento:**

1. Como identificaria uma regressão na qualidade das respostas?
2. Que configurações deveriam ser revisadas após a atualização?
3. Quando seria necessário adiar a atualização?

---

## Resumo desta parte

- **Perguntas apresentadas:** 81 a 90
- **Perguntas restantes:** 91 a 100
- **Categorias abordadas:** memória, advisors, RAG, ingestão, transformação de documentos, respostas estruturadas, observabilidade, testes e manutenção
- **Competências avaliadas:** uso de `ChatMemory`, composição de advisors, persistência de embeddings, leitura e transformação de documentos, conversão de respostas, criação de métricas, testes de integração e atualização segura do Spring AI

A próxima parte deve concluir o roteiro com as perguntas **91 a 100**, mantendo a mesma estrutura e a numeração sequencial.

---

# Roteiro de Entrevista Técnica — Spring AI

> **Parte 9 de 10**  
> Esta parte contém as perguntas **81 a 90 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

---

## Pergunta 81 — `ChatMemory` e gerenciamento de contexto

**Nível:** Júnior  
**Categoria:** Conversação e estado

**Pergunta do entrevistador:**  
Qual é a finalidade do `ChatMemory` em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende como manter informações relevantes de uma conversa entre diferentes interações.

**Resposta esperada:**  
O `ChatMemory` auxilia no armazenamento e na recuperação de mensagens anteriores de uma conversa.

Ele pode ser utilizado para:

- Manter continuidade entre perguntas;
- Recuperar mensagens recentes;
- Associar mensagens a uma conversa;
- Reduzir a necessidade de implementar manualmente todo o gerenciamento do histórico;
- Integrar o histórico ao fluxo de um `ChatClient`.

A memória não significa que o modelo aprendeu permanentemente os dados. Ela representa um mecanismo da aplicação para recuperar contexto e enviá-lo novamente ao modelo.

A aplicação ainda precisa controlar:

- Identificação da conversa;
- Usuário proprietário;
- Tamanho do histórico;
- Persistência;
- Privacidade;
- Expiração;
- Estratégia de resumo.

**Explicação didática:**  
Sem memória:

~~~mermaid
sequenceDiagram
    participant U as Usuário
    participant A as Aplicação
    participant M as Modelo

    U->>A: Primeira pergunta
    A->>M: Envia pergunta
    M-->>A: Resposta
    U->>A: Pergunta complementar
    A->>M: Envia somente nova pergunta
    M-->>A: Pode não entender o contexto
~~~

Com memória, a aplicação recupera mensagens anteriores e as inclui na próxima chamada.

A configuração exata do `ChatMemory` pode variar conforme a versão do Spring AI. O candidato deve compreender o conceito sem depender somente de nomes específicos de classes.

**Como o candidato deve responder:**

- Definir memória conversacional;
- Diferenciar memória de treinamento do modelo;
- Mencionar armazenamento e recuperação;
- Considerar limite de contexto e privacidade;
- Explicar que a memória deve ser vinculada ao usuário e à conversa correta.

**Resposta fraca ou incompleta:**  
“`ChatMemory` faz o modelo aprender permanentemente tudo que o usuário disse.”

Essa resposta confunde histórico de conversa com treinamento ou atualização permanente do modelo.

**Critérios de avaliação:**

- **0** — Não entende o conceito de memória.
- **1** — Confunde memória com treinamento.
- **2** — Reconhece histórico, mas não explica seu gerenciamento.
- **3** — Explica corretamente o uso da memória.
- **4** — Considera persistência, privacidade e limite de contexto.
- **5** — Propõe uma estratégia completa de memória, resumo, expiração e isolamento por usuário.

**Perguntas de aprofundamento:**

1. Onde você armazenaria a memória em uma aplicação distribuída?
2. Como evitaria que o histórico crescesse indefinidamente?
3. Como permitiria que o usuário apagasse a própria conversa?

---

## Pergunta 82 — Advisors de memória e recuperação

**Nível:** Júnior  
**Categoria:** Spring AI e RAG

**Pergunta do entrevistador:**  
Como um advisor pode ajudar a adicionar memória ou contexto recuperado a uma chamada do `ChatClient`?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende como comportamentos reutilizáveis podem ser incorporados ao fluxo de interação com o modelo.

**Resposta esperada:**  
Um advisor pode interceptar ou participar do fluxo de uma chamada, adicionando informações antes da consulta ao modelo ou processando a resposta depois.

Um advisor de memória pode:

- Identificar a conversa;
- Recuperar mensagens anteriores;
- Adicionar o histórico ao contexto;
- Salvar a nova interação após a resposta.

Um advisor de recuperação pode:

- Receber a pergunta;
- Consultar um banco vetorial;
- Recuperar documentos relevantes;
- Adicionar os trechos ao prompt;
- Permitir que o modelo responda com base no contexto.

O uso de advisors reduz duplicação, mas a aplicação ainda precisa compreender e monitorar o comportamento deles.

**Fluxo conceitual:**

~~~mermaid
flowchart LR
    A[Pergunta do usuário] --> B[Advisor de memória]
    B --> C[Advisor de recuperação]
    C --> D[ChatClient]
    D --> E[Modelo]
    E --> F[Resposta]
    F --> G[Salvar interação]
~~~

Os nomes, construtores e configurações podem mudar entre versões do Spring AI.

**Como o candidato deve responder:**

- Explicar o advisor como componente de extensão;
- Relacionar memória e recuperação ao fluxo;
- Mencionar ordem de execução;
- Considerar autorização dos dados recuperados;
- Evitar tratar advisors como uma solução automática para todos os problemas.

**Resposta fraca ou incompleta:**  
“Advisor é um tipo de modelo que gera uma segunda resposta.”

Essa definição não corresponde ao papel de extensão e composição do fluxo.

**Critérios de avaliação:**

- **0** — Não entende advisors.
- **1** — Confunde advisor com modelo.
- **2** — Sabe que é um componente auxiliar, mas não explica sua função.
- **3** — Explica o uso geral em memória ou RAG.
- **4** — Considera ordem, contexto, autorização e monitoramento.
- **5** — Analisa composição de advisors, efeitos no prompt, custo, depuração e diferenças entre versões.

**Perguntas de aprofundamento:**

1. O que poderia acontecer se dois advisors adicionassem informações conflitantes?
2. Como verificaria qual contexto foi adicionado ao prompt?
3. Como evitaria que um advisor recuperasse dados não autorizados?

---

## Pergunta 83 — `VectorStore` e persistência de embeddings

**Nível:** Júnior  
**Categoria:** Armazenamento e RAG

**Pergunta do entrevistador:**  
Qual é a função de um `VectorStore` em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende o papel da abstração de armazenamento vetorial no processo de recuperação semântica.

**Resposta esperada:**  
O `VectorStore` é utilizado para armazenar documentos, trechos de conteúdo, embeddings e metadados, além de realizar buscas por similaridade.

Um fluxo típico é:

1. Dividir documentos em trechos;
2. Gerar embeddings;
3. Armazenar os trechos e os vetores;
4. Gerar o embedding da pergunta;
5. Buscar conteúdos semanticamente semelhantes;
6. Utilizar os resultados como contexto para o modelo.

A abstração facilita a integração com diferentes tecnologias de armazenamento, mas cada implementação pode possuir recursos e limitações próprios.

**Exemplo conceitual:**

~~~java
List<Document> documentos = vectorStore.similaritySearch(
        SearchRequest.builder()
                .query(pergunta)
                .topK(5)
                .build()
);
~~~

O exemplo é ilustrativo. Métodos e tipos podem variar conforme a versão utilizada.

**Explicação didática:**  
Um banco vetorial não precisa armazenar apenas o vetor. Para que o sistema seja útil, também é importante manter:

- Texto original ou trecho;
- Identificador da fonte;
- Título;
- Data de atualização;
- Permissões;
- Categoria;
- Versão do documento.

A dimensão do vetor precisa ser compatível com o modelo de embedding utilizado.

**Como o candidato deve responder:**

- Definir o papel do `VectorStore`;
- Relacionar embeddings à busca semântica;
- Mencionar documentos e metadados;
- Explicar o uso em RAG;
- Considerar atualização e compatibilidade dos embeddings.

**Resposta fraca ou incompleta:**  
“`VectorStore` é usado para armazenar as respostas prontas do chatbot.”

Ele normalmente armazena conteúdo indexado e representações vetoriais para permitir recuperação por similaridade.

**Critérios de avaliação:**

- **0** — Não entende o componente.
- **1** — Confunde vetores com respostas finais.
- **2** — Relaciona a documentos, mas não explica a busca.
- **3** — Explica corretamente o uso em RAG.
- **4** — Considera metadados, dimensões e atualização.
- **5** — Discute indexação, filtros, versionamento, avaliação da recuperação e limitações do armazenamento.

**Perguntas de aprofundamento:**

1. O que aconteceria se o modelo de embedding fosse trocado?
2. Por que os metadados são importantes?
3. Como removeria os trechos de um documento excluído?

---

## Pergunta 84 — `DocumentReader` e carregamento de conteúdo

**Nível:** Júnior  
**Categoria:** Ingestão de dados

**Pergunta do entrevistador:**  
Qual é a finalidade de um componente de leitura de documentos em um fluxo de ingestão do Spring AI?

**O que essa pergunta avalia:**  
Avalia o entendimento das etapas de carregamento e transformação de arquivos antes da indexação.

**Resposta esperada:**  
Um leitor de documentos é responsável por carregar conteúdo de uma fonte, como:

- Arquivo de texto;
- PDF;
- Página web;
- Diretório;
- Banco de dados;
- Outro repositório de informações.

Depois da leitura, o conteúdo pode ser transformado em objetos de documento, divididos em trechos, enriquecido com metadados e enviado para geração de embeddings.

A leitura não garante que o conteúdo foi extraído corretamente. Arquivos com tabelas, imagens, colunas ou texto digitalizado podem exigir tratamento adicional.

**Fluxo conceitual:**

~~~mermaid
flowchart LR
    A[Fonte original] --> B[Leitor de documentos]
    B --> C[Documentos]
    C --> D[Limpeza]
    D --> E[Divisão em trechos]
    E --> F[Embeddings]
    F --> G[VectorStore]
~~~

**Exemplo prático:**  
Uma aplicação pode ler um manual em PDF, preservar o título e a seção, dividir o conteúdo em trechos e armazená-los com os metadados da versão do documento.

**Como o candidato deve responder:**

- Explicar a função do leitor;
- Diferenciar leitura de indexação;
- Mencionar extração de texto;
- Considerar erros em PDFs e documentos complexos;
- Relacionar o resultado ao chunking e aos embeddings.

**Resposta fraca ou incompleta:**  
“Basta enviar qualquer arquivo diretamente para o modelo.”

A aplicação precisa preparar, validar e, em muitos casos, indexar o conteúdo de maneira controlada.

**Critérios de avaliação:**

- **0** — Não entende a etapa de leitura.
- **1** — Confunde arquivo com embedding.
- **2** — Reconhece o carregamento, mas não explica o processamento posterior.
- **3** — Descreve corretamente a ingestão básica.
- **4** — Considera metadados, qualidade da extração e documentos complexos.
- **5** — Propõe um processo completo, monitorado, versionado e capaz de tratar falhas de extração.

**Perguntas de aprofundamento:**

1. Como trataria um PDF formado apenas por imagens?
2. O que faria se a extração produzisse texto fora de ordem?
3. Como identificaria que um documento foi alterado?

---

## Pergunta 85 — `DocumentTransformer` e divisão de documentos

**Nível:** Júnior  
**Categoria:** RAG e preparação de conteúdo

**Pergunta do entrevistador:**  
Qual é o papel de um transformador de documentos em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende que o conteúdo lido precisa ser preparado antes de gerar embeddings e realizar buscas.

**Resposta esperada:**  
Um transformador modifica ou prepara documentos para uma etapa posterior.

Ele pode ser utilizado para:

- Dividir documentos em trechos;
- Limpar conteúdo;
- Adicionar ou ajustar metadados;
- Remover informações desnecessárias;
- Normalizar texto;
- Preparar dados para embeddings;
- Adaptar conteúdos diferentes para um formato comum.

No caso de divisão de documentos, é importante equilibrar tamanho do trecho e preservação do contexto.

**Explicação didática:**  
Se um trecho for pequeno demais, pode perder o significado da informação. Se for grande demais, pode incluir ruído e ultrapassar o limite de contexto.

A sobreposição entre trechos pode ajudar quando uma frase ou explicação continua de uma parte para outra.

**Exemplo conceitual:**

~~~java
List<Document> partes = textSplitter.apply(documentos);
~~~

A API exata depende do transformador e da versão do Spring AI.

**Como o candidato deve responder:**

- Explicar transformação como preparação;
- Mencionar chunking e metadados;
- Considerar tamanho e sobreposição;
- Relacionar a qualidade da busca;
- Reconhecer que diferentes documentos podem exigir estratégias diferentes.

**Resposta fraca ou incompleta:**  
“Transformador serve apenas para converter PDF em TXT.”

A transformação pode incluir limpeza, divisão, enriquecimento e normalização de diferentes fontes.

**Critérios de avaliação:**

- **0** — Não compreende o conceito.
- **1** — Confunde transformação com geração de resposta.
- **2** — Reconhece alteração do documento, mas não explica o objetivo.
- **3** — Explica corretamente o uso na preparação do RAG.
- **4** — Considera chunking, metadados e preservação de contexto.
- **5** — Discute estratégias específicas por tipo de documento e avaliação da recuperação.

**Perguntas de aprofundamento:**

1. Como escolheria o tamanho dos trechos?
2. Quando a sobreposição poderia aumentar o custo sem trazer benefício?
3. Como preservaria a relação entre um trecho e sua fonte original?

---

## Pergunta 86 — Saídas estruturadas e conversão para objetos

**Nível:** Júnior  
**Categoria:** Integração e validação

**Pergunta do entrevistador:**  
Como você faria para transformar a resposta do modelo em um objeto Java utilizando Spring AI?

**O que essa pergunta avalia:**  
Avalia o entendimento de respostas estruturadas, conversão de dados e validação de saída.

**Resposta esperada:**  
A aplicação pode solicitar que o modelo responda em um formato estruturado e utilizar um conversor para transformar o resultado em um objeto Java.

O fluxo deve incluir:

1. Definir o formato esperado;
2. Informar os campos necessários;
3. Realizar a chamada ao modelo;
4. Converter a saída;
5. Validar os campos;
6. Tratar respostas inválidas ou incompletas.

Mesmo utilizando um conversor, a aplicação não deve assumir que o conteúdo está correto do ponto de vista da regra de negócio.

**Exemplo conceitual:**

~~~java
public record Analise(
        String categoria,
        String resumo
) {}

Analise resultado = chatClient
        .prompt()
        .user(pergunta)
        .call()
        .entity(Analise.class);
~~~

A disponibilidade e o comportamento de métodos como `entity` dependem da versão e da configuração do Spring AI.

**Como o candidato deve responder:**

- Explicar a conversão para objeto;
- Mencionar formato estruturado;
- Validar campos obrigatórios;
- Tratar erro de conversão;
- Diferenciar conversão sintática de validação de negócio.

**Resposta fraca ou incompleta:**  
“Eu faria um cast da resposta textual para a classe Java.”

Uma string não pode ser convertida automaticamente em objeto sem uma estratégia de desserialização e validação.

**Critérios de avaliação:**

- **0** — Não sabe como trabalhar com respostas estruturadas.
- **1** — Propõe apenas um cast.
- **2** — Reconhece JSON, mas ignora validações.
- **3** — Explica conversão e validação básica.
- **4** — Considera campos ausentes, tipos inválidos e fallback.
- **5** — Discute contratos de saída, validação semântica, versões, observabilidade e tratamento seguro de respostas inválidas.

**Perguntas de aprofundamento:**

1. O que faria se faltasse um campo obrigatório?
2. Como validaria um valor de enumeração?
3. Em que situação retornaria erro em vez de tentar corrigir a resposta?

---

## Pergunta 87 — `OutputParser` e interpretação da resposta

**Nível:** Júnior  
**Categoria:** Processamento de saída

**Pergunta do entrevistador:**  
Qual é a finalidade de um parser de saída em uma aplicação que utiliza Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende como orientar e interpretar respostas que precisam seguir determinado formato.

**Resposta esperada:**  
Um parser de saída ajuda a definir ou interpretar o formato esperado da resposta do modelo.

Ele pode:

- Informar ao modelo quais campos deve retornar;
- Auxiliar na construção das instruções;
- Converter texto estruturado para objetos;
- Detectar respostas incompatíveis;
- Padronizar o resultado consumido pela aplicação.

O parser não transforma uma resposta incorreta em verdadeira. Depois da interpretação, a aplicação ainda deve validar regras, permissões, limites e consistência.

**Exemplo prático:**  
Uma classificação de chamado pode esperar:

~~~json
{
  "categoria": "ACESSO",
  "prioridade": "ALTA",
  "resumo": "Usuário não consegue acessar o sistema"
}
~~~

A aplicação deve verificar se `ACESSO` e `ALTA` são valores permitidos e se o resumo foi preenchido.

**Como o candidato deve responder:**

- Explicar o papel do parser;
- Relacionar o parser ao formato esperado;
- Mencionar conversão e validação;
- Diferenciar sintaxe válida de conteúdo correto;
- Considerar fallback para respostas inválidas.

**Resposta fraca ou incompleta:**  
“Parser garante que o modelo sempre responderá corretamente.”

Ele pode auxiliar na estrutura, mas não garante precisão factual ou adequação à regra de negócio.

**Critérios de avaliação:**

- **0** — Não conhece o conceito.
- **1** — Confunde parser com modelo.
- **2** — Relaciona a JSON, mas não explica sua função.
- **3** — Explica interpretação e validação estrutural.
- **4** — Considera erros, campos e valores permitidos.
- **5** — Discute contratos, compatibilidade, observabilidade e tratamento de respostas semanticamente incorretas.

**Perguntas de aprofundamento:**

1. Como trataria uma saída que contém texto antes do JSON?
2. O que faria se o formato mudasse entre versões do prompt?
3. Por que uma resposta JSON válida ainda pode ser perigosa?

---

## Pergunta 88 — Observabilidade com Micrometer

**Nível:** Júnior  
**Categoria:** Monitoramento

**Pergunta do entrevistador:**  
Como você utilizaria observabilidade para acompanhar uma integração Spring AI em produção?

**O que essa pergunta avalia:**  
Avalia a capacidade de monitorar chamadas externas, identificar problemas e acompanhar custos e desempenho.

**Resposta esperada:**  
A aplicação pode utilizar recursos de observabilidade para acompanhar:

- Quantidade de chamadas;
- Tempo de resposta;
- Erros;
- Timeouts;
- Provedor;
- Modelo;
- Tokens consumidos, quando disponíveis;
- Taxa de respostas vazias;
- Número de retentativas;
- Uso de cache;
- Quantidade de documentos recuperados.

O Spring Boot e o ecossistema Micrometer podem ajudar a publicar métricas para sistemas de monitoramento. A configuração exata depende das versões e dos componentes adotados.

Também é importante evitar registrar prompts, respostas ou dados pessoais completos sem necessidade.

**Exemplo de métricas úteis:**

~~~text
ai.requests.total
ai.requests.duration
ai.requests.errors
ai.tokens.input
ai.tokens.output
ai.retrieval.documents
ai.retries.total
~~~

Os nomes são apenas ilustrativos e podem ser definidos conforme o padrão do projeto.

**Como o candidato deve responder:**

- Citar métricas e logs;
- Mencionar tempo de resposta e erros;
- Considerar tokens e custos;
- Relacionar observabilidade a troubleshooting;
- Proteger dados sensíveis.

**Resposta fraca ou incompleta:**  
“Eu salvaria o prompt e a resposta completa em todos os logs.”

Essa prática pode expor dados pessoais, informações confidenciais e credenciais.

**Critérios de avaliação:**

- **0** — Não propõe observabilidade.
- **1** — Sugere apenas imprimir mensagens no console.
- **2** — Menciona logs, mas ignora privacidade.
- **3** — Lista métricas básicas de chamadas e erros.
- **4** — Considera tokens, latência, retentativas e alertas.
- **5** — Propõe observabilidade segura, com correlação, métricas de qualidade, controle de retenção e análise de custos.

**Perguntas de aprofundamento:**

1. Como identificaria se o problema está no modelo ou no banco vetorial?
2. Que métrica indicaria aumento de custo?
3. Como investigaria uma falha sem armazenar o prompt completo?

---

## Pergunta 89 — Teste de integração com provedor externo

**Nível:** Júnior  
**Categoria:** Testes e confiabilidade

**Pergunta do entrevistador:**  
Quando um teste de integração com um provedor real de modelos pode ser útil e quais cuidados você teria?

**O que essa pergunta avalia:**  
Avalia se o candidato consegue diferenciar testes unitários, testes de integração e avaliações de comportamento do modelo.

**Resposta esperada:**  
Um teste de integração pode verificar se:

- As credenciais estão configuradas;
- A comunicação com o provedor funciona;
- O modelo selecionado está disponível;
- O formato da requisição é aceito;
- O streaming ou a conversão funcionam;
- O tratamento de erros está adequado.

Porém, esse tipo de teste pode ser:

- Mais lento;
- Mais caro;
- Instável por causa da rede;
- Variável por causa da saída do modelo;
- Dependente de limites externos.

Por isso, deve ser executado de forma controlada, com dados não sensíveis, limites de custo e expectativas flexíveis sobre respostas textuais.

**Estratégia em camadas:**

~~~mermaid
flowchart TD
    A[Testes unitários] --> B[Testes com dublês]
    B --> C[Testes de integração controlados]
    C --> D[Avaliação de qualidade]
    D --> E[Monitoramento em produção]
~~~

Testes unitários devem verificar regras da aplicação sem depender do provedor. Testes de integração verificam a conexão real. Avaliações de qualidade verificam se o resultado atende ao objetivo.

**Como o candidato deve responder:**

- Diferenciar tipos de teste;
- Citar custo, latência e variabilidade;
- Utilizar mocks ou stubs nos testes unitários;
- Proteger credenciais;
- Considerar critérios de qualidade e não apenas status HTTP.

**Resposta fraca ou incompleta:**  
“Todos os testes deveriam chamar o provedor real para serem confiáveis.”

Isso torna a suíte lenta, cara e instável.

**Critérios de avaliação:**

- **0** — Não apresenta estratégia de testes.
- **1** — Depende exclusivamente de chamadas reais.
- **2** — Conhece mocks, mas não diferencia os níveis de teste.
- **3** — Propõe testes unitários isolados e integração controlada.
- **4** — Considera custos, variabilidade, erros e segurança.
- **5** — Organiza uma estratégia completa com contratos, integração, avaliação de qualidade e monitoramento contínuo.

**Perguntas de aprofundamento:**

1. Como testaria uma resposta que pode variar, mas continua correta?
2. Como simularia um timeout do provedor?
3. Como evitaria que dados reais fossem enviados durante os testes?

---

## Pergunta 90 — Migração entre versões do Spring AI

**Nível:** Júnior  
**Categoria:** Manutenção e compatibilidade

**Pergunta do entrevistador:**  
Quais cuidados você teria ao atualizar o Spring AI para uma nova versão?

**O que essa pergunta avalia:**  
Avalia a capacidade do candidato de lidar com mudanças de dependências, APIs e comportamento.

**Resposta esperada:**  
Antes de atualizar, a equipe deve verificar:

- Compatibilidade com a versão do Spring Boot;
- Mudanças incompatíveis;
- Classes e métodos descontinuados;
- Alterações nos starters;
- Alterações nos nomes das propriedades;
- Mudanças em advisors;
- Modificações no `ChatClient`;
- Compatibilidade com o provedor;
- Mudanças no banco vetorial;
- Alterações na conversão de respostas;
- Atualizações de segurança.

A atualização deve ser feita em ambiente controlado, utilizando testes automatizados e avaliação de comportamento.

Não basta verificar se o projeto continua compilando. Uma aplicação pode compilar e ainda apresentar:

- Respostas diferentes;
- Prompts modificados;
- Falhas de configuração;
- Alterações de custo;
- Diferenças no histórico;
- Mudança na qualidade do RAG.

**Fluxo recomendado:**

~~~mermaid
flowchart TD
    A[Identificar versão atual] --> B[Consultar notas da atualização]
    B --> C[Atualizar em ambiente de teste]
    C --> D[Corrigir incompatibilidades]
    D --> E[Executar testes]
    E --> F[Avaliar respostas e desempenho]
    F --> G{Resultado adequado?}
    G -- Sim --> H[Publicar gradualmente]
    G -- Não --> I[Corrigir ou reverter]
~~~

A forma exata de migração depende da versão de origem, da versão de destino e dos módulos utilizados.

**Como o candidato deve responder:**

- Verificar compatibilidade de versões;
- Consultar documentação e notas de alteração;
- Executar testes;
- Avaliar comportamento funcional e qualidade das respostas;
- Planejar rollback;
- Considerar propriedades e integrações externas.

**Resposta fraca ou incompleta:**  
“Eu alteraria a versão no gerenciador de dependências e executaria o build.”

Isso verifica apenas parte da compatibilidade e não garante que o comportamento da aplicação permaneceu correto.

**Critérios de avaliação:**

- **0** — Não identifica riscos de atualização.
- **1** — Atualiza diretamente em produção.
- **2** — Considera apenas compilação.
- **3** — Propõe testes e verificação de compatibilidade.
- **4** — Inclui prompts, RAG, configuração, custo e desempenho.
- **5** — Apresenta uma estratégia controlada com testes, observabilidade, liberação gradual e possibilidade de reversão.

**Perguntas de aprofundamento:**

1. Como identificaria uma regressão na qualidade das respostas?
2. Que configurações deveriam ser revisadas após a atualização?
3. Quando seria necessário adiar a atualização?

---

## Resumo desta parte

- **Perguntas apresentadas:** 81 a 90
- **Perguntas restantes:** 91 a 100
- **Categorias abordadas:** memória, advisors, RAG, ingestão, transformação de documentos, respostas estruturadas, observabilidade, testes e manutenção
- **Competências avaliadas:** uso de `ChatMemory`, composição de advisors, persistência de embeddings, leitura e transformação de documentos, conversão de respostas, criação de métricas, testes de integração e atualização segura do Spring AI

A próxima parte deve concluir o roteiro com as perguntas **91 a 100**, mantendo a mesma estrutura e a numeração sequencial.

---

# Roteiro de Entrevista Técnica — Spring AI

> **Parte 10 de 10**  
> Esta parte contém as perguntas **91 a 100 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Quantidade:** 100 perguntas no total  
**Perfil:** Perguntas misturadas — conceituais, práticas e baseadas em cenários reais

---

## Pergunta 91 — Cache de respostas

**Nível:** Júnior  
**Categoria:** Desempenho e custos

**Pergunta do entrevistador:**  
Em que situação um cache poderia ser utilizado em uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende como reduzir chamadas repetidas ao modelo e melhorar desempenho.

**Resposta esperada:**  
Um cache pode ser utilizado quando perguntas iguais ou muito semelhantes produzem respostas que podem ser reutilizadas com segurança.

Ele pode ajudar a:

- Reduzir custos;
- Diminuir a latência;
- Evitar chamadas repetidas;
- Reduzir a carga sobre o provedor;
- Melhorar a disponibilidade em alguns cenários.

Entretanto, nem toda resposta deve ser armazenada. O cache precisa considerar:

- Validade dos dados;
- Usuário e permissões;
- Versão dos documentos;
- Modelo utilizado;
- Versão do prompt;
- Informações pessoais;
- Prazo de expiração.

Uma resposta baseada em dados atuais, como saldo ou status de pedido, normalmente não deve ser reutilizada sem uma validação de atualização.

**Explicação didática:**  
Perguntas gerais, como “O que é Spring Boot?”, podem ser candidatas a cache.

Já uma pergunta como “Qual é o status atual do meu pedido?” exige dados atualizados e associados ao usuário correto.

Um fluxo possível seria:

~~~mermaid
flowchart TD
    A[Receber pergunta] --> B[Verificar possibilidade de cache]
    B --> C{Resposta válida no cache?}
    C -- Sim --> D[Retornar resposta armazenada]
    C -- Não --> E[Consultar modelo ou fonte oficial]
    E --> F[Validar resposta]
    F --> G[Armazenar se for seguro]
    G --> H[Retornar resposta]
~~~

**Como o candidato deve responder:**

- Relacionar cache a custo e desempenho;
- Citar validade e expiração;
- Considerar dados personalizados;
- Mencionar usuário, permissões e versão do prompt;
- Explicar que cache não serve para qualquer resposta.

**Resposta fraca ou incompleta:**  
“Eu armazenaria todas as respostas para nunca chamar o modelo novamente.”

Isso pode retornar informações desatualizadas ou de outro usuário.

**Critérios de avaliação:**

- **0** — Não entende a finalidade do cache.
- **1** — Armazena qualquer resposta sem critérios.
- **2** — Cita desempenho, mas ignora atualização e privacidade.
- **3** — Explica o uso básico do cache.
- **4** — Considera expiração, permissões e custo.
- **5** — Define uma estratégia segura considerando chave de cache, invalidação, versionamento e dados personalizados.

**Perguntas de aprofundamento:**

1. Que informações deveriam fazer parte da chave do cache?
2. Quando uma resposta não deveria ser armazenada?
3. Como invalidaria o cache depois que um documento fosse atualizado?

---

## Pergunta 92 — Controle de concorrência

**Nível:** Júnior  
**Categoria:** Desempenho e confiabilidade

**Pergunta do entrevistador:**  
Quais cuidados você teria ao permitir várias chamadas simultâneas ao modelo?

**O que essa pergunta avalia:**  
Avalia conhecimentos básicos sobre concorrência, limites de recursos e proteção da aplicação.

**Resposta esperada:**  
Chamadas simultâneas podem melhorar o processamento, mas também podem causar:

- Excesso de consumo de memória;
- Saturação de conexões;
- Limite de requisições do provedor;
- Aumento inesperado de custos;
- Mais timeouts;
- Concorrência sobre o histórico da conversa;
- Respostas fora de ordem.

A aplicação deve controlar a quantidade de operações concorrentes e utilizar filas ou mecanismos de limitação quando necessário.

Também deve definir o comportamento para duas mensagens enviadas simultaneamente na mesma conversa.

**Explicação didática:**  
Se cem usuários enviarem perguntas ao mesmo tempo, não é adequado criar cem chamadas sem nenhum controle.

A aplicação pode limitar a concorrência:

~~~mermaid
flowchart TD
    A[Requisições recebidas] --> B[Fila]
    B --> C[Limite de chamadas simultâneas]
    C --> D[Consultar modelo]
    D --> E[Retornar resultado]
    C --> F[Controlar excesso]
~~~

Para uma mesma conversa, pode ser necessário processar as mensagens em sequência, evitando que o histórico seja salvo fora de ordem.

**Como o candidato deve responder:**

- Mencionar limites de concorrência;
- Relacionar o tema a custos e disponibilidade;
- Considerar filas e backpressure;
- Falar sobre histórico fora de ordem;
- Explicar o tratamento de excesso de requisições.

**Resposta fraca ou incompleta:**  
“Eu deixaria o servidor criar uma chamada para cada requisição.”

Isso pode sobrecarregar a aplicação e ultrapassar os limites do provedor.

**Critérios de avaliação:**

- **0** — Não identifica riscos de concorrência.
- **1** — Permite chamadas ilimitadas.
- **2** — Menciona paralelismo, mas ignora recursos.
- **3** — Propõe controle básico de concorrência.
- **4** — Considera filas, limites, custos e ordem das mensagens.
- **5** — Discute isolamento por conversa, backpressure, prioridades, retentativas e consistência do histórico.

**Perguntas de aprofundamento:**

1. Como evitaria duas mensagens simultâneas alterarem o histórico fora de ordem?
2. O que faria quando a fila atingisse sua capacidade?
3. Como escolheria o limite de concorrência?

---

## Pergunta 93 — Idempotência em operações com IA

**Nível:** Júnior  
**Categoria:** Confiabilidade e integração

**Pergunta do entrevistador:**  
Por que a idempotência é importante ao integrar uma aplicação Spring AI com operações externas?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende os riscos de repetir chamadas ou ações após falhas.

**Resposta esperada:**  
Uma operação idempotente produz o mesmo efeito quando executada mais de uma vez.

Isso é importante porque uma chamada pode:

- Ser processada pelo sistema externo;
- Mas falhar antes de a aplicação receber a resposta;
- Ser repetida automaticamente;
- Produzir uma ação duplicada.

O risco é maior em operações como:

- Enviar e-mails;
- Criar pedidos;
- Cancelar reservas;
- Registrar pagamentos;
- Atualizar cadastros;
- Executar comandos administrativos.

A aplicação pode utilizar uma chave de idempotência, identificador da operação, verificação de estado e confirmação antes de repetir uma ação.

**Explicação didática:**  
Imagine que o modelo interprete uma solicitação para enviar um e-mail. A aplicação envia o e-mail, mas perde a conexão antes de receber a confirmação. Se repetir a operação sem controle, o destinatário poderá receber duas mensagens.

Um fluxo seguro poderia ser:

~~~mermaid
sequenceDiagram
    participant A as Aplicação
    participant S as Sistema externo

    A->>S: Envia operação com idempotencyKey
    S-->>A: Processa ou informa operação já realizada
    A->>A: Registra resultado
~~~

O modelo não deve decidir sozinho se uma operação pode ser repetida.

**Como o candidato deve responder:**

- Definir idempotência;
- Relacionar o conceito a retentativas;
- Citar efeitos duplicados;
- Mencionar identificadores de operação;
- Diferenciar consultas de operações que alteram dados.

**Resposta fraca ou incompleta:**  
“Basta repetir a chamada até funcionar.”

Isso pode duplicar ações e causar efeitos financeiros ou operacionais indevidos.

**Critérios de avaliação:**

- **0** — Não entende o risco de repetição.
- **1** — Propõe retentativas ilimitadas.
- **2** — Reconhece duplicidade, mas não sugere controle.
- **3** — Explica idempotência de forma básica.
- **4** — Relaciona o conceito a chaves, estado e retentativas.
- **5** — Propõe uma estratégia completa para operações externas, incluindo auditoria, confirmação e recuperação de falhas.

**Perguntas de aprofundamento:**

1. Toda chamada ao modelo precisa ser idempotente?
2. Como evitaria o envio duplicado de uma mensagem?
3. O que faria quando não soubesse se a operação foi concluída?

---

## Pergunta 94 — Fallback quando o provedor está indisponível

**Nível:** Júnior  
**Categoria:** Resiliência

**Pergunta do entrevistador:**  
Como você projetaria o comportamento da aplicação quando o provedor de modelos estivesse indisponível?

**O que essa pergunta avalia:**  
Avalia noções de tolerância a falhas e degradação controlada.

**Resposta esperada:**  
A aplicação deve detectar a indisponibilidade e apresentar um comportamento seguro.

Algumas alternativas são:

- Retornar uma mensagem clara ao usuário;
- Utilizar outro provedor compatível;
- Utilizar uma resposta previamente armazenada;
- Encaminhar para atendimento humano;
- Oferecer apenas funcionalidades determinísticas;
- Colocar a solicitação em uma fila;
- Aplicar retentativas limitadas;
- Interromper temporariamente novas chamadas.

O fallback não deve inventar uma resposta apenas para esconder a falha.

A troca automática de provedor também precisa considerar compatibilidade, privacidade, custo e qualidade.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Solicitação] --> B[Provedor principal]
    B --> C{Disponível?}
    C -- Sim --> D[Gerar resposta]
    C -- Não --> E{Existe fallback seguro?}
    E -- Sim --> F[Usar fallback]
    E -- Não --> G[Informar indisponibilidade]
    D --> H[Validar saída]
    F --> H
~~~

**Como o candidato deve responder:**

- Mencionar retentativas limitadas;
- Explicar fallback e mensagem segura;
- Considerar outro provedor ou atendimento humano;
- Evitar respostas inventadas;
- Relacionar a estratégia ao risco da funcionalidade.

**Resposta fraca ou incompleta:**  
“Eu retornaria qualquer resposta genérica para o usuário não perceber o problema.”

Isso pode transmitir informação incorreta e dificultar a identificação da falha.

**Critérios de avaliação:**

- **0** — Não apresenta estratégia.
- **1** — Oculta a falha com uma resposta inventada.
- **2** — Menciona retentativa sem controle.
- **3** — Define mensagem segura e tratamento básico.
- **4** — Considera fallback, fila, provedor alternativo e monitoramento.
- **5** — Propõe degradação controlada, circuit breaker, limites, auditoria e validação da alternativa.

**Perguntas de aprofundamento:**

1. Quando um provedor alternativo não seria apropriado?
2. Como informaria o usuário sobre a indisponibilidade?
3. O que faria com solicitações que ficaram pendentes?

---

## Pergunta 95 — Controle de custo

**Nível:** Júnior  
**Categoria:** Operação e governança

**Pergunta do entrevistador:**  
Como você controlaria os custos de uma aplicação que utiliza modelos de linguagem?

**O que essa pergunta avalia:**  
Avalia se o candidato reconhece que chamadas ao modelo podem gerar custos variáveis.

**Resposta esperada:**  
O controle de custos pode incluir:

- Limites por usuário;
- Limites por aplicação;
- Monitoramento de tokens;
- Escolha adequada do modelo;
- Limitação do tamanho dos prompts;
- Controle do tamanho das respostas;
- Cache;
- Processamento em lote;
- Redução de contexto desnecessário;
- Alertas de consumo;
- Separação entre ambientes;
- Rate limiting;
- Avaliação periódica de custo-benefício.

Também é importante identificar quais funcionalidades realmente precisam de um modelo mais poderoso.

**Explicação didática:**  
Uma aplicação pode ficar cara não apenas pelo número de chamadas, mas também pela quantidade de dados enviada e gerada.

Um prompt com histórico completo, muitos documentos e uma resposta longa pode consumir mais recursos do que uma chamada curta.

**Exemplo de indicadores:**

~~~text
- Custo estimado por usuário
- Tokens de entrada e saída
- Chamadas por funcionalidade
- Custo médio por solicitação
- Percentual de retentativas
- Custo por ambiente
~~~

**Como o candidato deve responder:**

- Relacionar custo a chamadas e tokens;
- Mencionar limites e alertas;
- Considerar cache e seleção de modelos;
- Falar sobre prompts e contexto;
- Propor acompanhamento contínuo.

**Resposta fraca ou incompleta:**  
“Eu verificaria os custos somente no fim do mês.”

Esse acompanhamento pode ser tardio para evitar consumo excessivo.

**Critérios de avaliação:**

- **0** — Não identifica o risco de custo.
- **1** — Ignora o consumo variável.
- **2** — Menciona limites, mas sem monitoramento.
- **3** — Propõe controle básico de chamadas e tamanho.
- **4** — Considera tokens, cache, modelos, alertas e usuários.
- **5** — Define governança contínua de custos, orçamento, alertas, otimização e análise por funcionalidade.

**Perguntas de aprofundamento:**

1. Que métricas utilizaria para acompanhar custos?
2. Como reduziria o custo de uma funcionalidade RAG?
3. O que faria ao atingir o orçamento definido?

---

## Pergunta 96 — Segurança no uso de ferramentas

**Nível:** Júnior  
**Categoria:** Segurança e integração

**Pergunta do entrevistador:**  
Quais cuidados você teria ao permitir que o modelo utilize ferramentas ou funções da aplicação?

**O que essa pergunta avalia:**  
Avalia se o candidato entende que ferramentas podem transformar uma resposta textual em uma ação real.

**Resposta esperada:**  
As ferramentas devem possuir:

- Escopo limitado;
- Parâmetros validados;
- Autorização no código;
- Controle de acesso;
- Registro de auditoria;
- Limites de uso;
- Tratamento de erros;
- Proteção contra duplicidade;
- Confirmação para ações sensíveis.

O modelo pode sugerir a chamada de uma ferramenta, mas a aplicação deve decidir se ela pode ser executada.

Não se deve permitir que o modelo escolha livremente qualquer método interno ou envie argumentos diretamente para sistemas críticos.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Modelo sugere ferramenta] --> B[Validar nome da ferramenta]
    B --> C[Validar argumentos]
    C --> D[Verificar autenticação e autorização]
    D --> E{Ação sensível?}
    E -- Sim --> F[Solicitar confirmação]
    E -- Não --> G[Executar com limites]
    F --> H[Registrar auditoria]
    G --> H
~~~

**Como o candidato deve responder:**

- Diferenciar sugestão do modelo e execução real;
- Mencionar validação e autorização;
- Citar confirmação e auditoria;
- Considerar idempotência;
- Explicar que ferramentas devem ser limitadas.

**Resposta fraca ou incompleta:**  
“Eu disponibilizaria todos os métodos da aplicação para o modelo escolher.”

Isso aumenta muito o risco de acesso indevido e efeitos colaterais.

**Critérios de avaliação:**

- **0** — Não identifica o risco.
- **1** — Permite acesso irrestrito.
- **2** — Menciona ferramentas, mas ignora autorização.
- **3** — Propõe ferramentas limitadas e parâmetros validados.
- **4** — Considera confirmação, auditoria e idempotência.
- **5** — Apresenta uma arquitetura segura de ferramentas com menor privilégio, políticas, observabilidade e controle de efeitos colaterais.

**Perguntas de aprofundamento:**

1. Que tipos de ferramenta não deveriam ser executados automaticamente?
2. Como validaria os argumentos gerados pelo modelo?
3. Como impediria uma ferramenta de acessar dados de outro usuário?

---

## Pergunta 97 — Limites de contexto

**Nível:** Júnior  
**Categoria:** Desempenho e qualidade

**Pergunta do entrevistador:**  
O que pode acontecer quando o histórico e os documentos enviados ao modelo ultrapassam o limite de contexto?

**O que essa pergunta avalia:**  
Avalia se o candidato entende os limites de entrada dos modelos e seus efeitos na aplicação.

**Resposta esperada:**  
Quando o contexto é muito grande, a aplicação pode enfrentar:

- Erro na requisição;
- Truncamento de mensagens;
- Aumento de custo;
- Maior latência;
- Perda de informações importantes;
- Respostas menos precisas;
- Dificuldade do modelo em localizar o dado relevante.

Para reduzir o problema, a aplicação pode:

- Limitar o histórico;
- Resumir conversas antigas;
- Recuperar apenas documentos relevantes;
- Reduzir o tamanho dos trechos;
- Remover duplicidades;
- Controlar o tamanho da resposta;
- Utilizar modelos com maior capacidade quando justificável.

**Explicação didática:**  
Enviar todo o histórico de uma conversa longa não é necessariamente melhor. Mensagens antigas podem ser resumidas ou removidas quando não forem mais relevantes.

Um fluxo possível seria:

~~~mermaid
flowchart TD
    A[Histórico e documentos] --> B[Medir tamanho do contexto]
    B --> C{Dentro do limite?}
    C -- Sim --> D[Enviar ao modelo]
    C -- Não --> E[Resumir e selecionar informações]
    E --> F[Montar contexto reduzido]
    F --> D
~~~

**Como o candidato deve responder:**

- Definir limite de contexto;
- Relacionar o problema a histórico e RAG;
- Mencionar resumo e seleção de documentos;
- Considerar custo e latência;
- Explicar que mais contexto pode piorar a resposta.

**Resposta fraca ou incompleta:**  
“Eu enviaria tudo e deixaria o modelo decidir o que usar.”

Isso pode ultrapassar limites e aumentar ruído.

**Critérios de avaliação:**

- **0** — Não entende o problema.
- **1** — Assume que o contexto é ilimitado.
- **2** — Reconhece o limite, mas não sugere solução.
- **3** — Propõe limitar histórico e documentos.
- **4** — Considera resumo, relevância, custo e latência.
- **5** — Define uma estratégia de gerenciamento de contexto com prioridades, medição, compressão e validação.

**Perguntas de aprofundamento:**

1. Como decidiria quais mensagens remover?
2. Quando utilizaria um resumo da conversa?
3. Como saberia se o resumo perdeu uma informação importante?

---

## Pergunta 98 — Auditoria e rastreabilidade

**Nível:** Júnior  
**Categoria:** Governança e segurança

**Pergunta do entrevistador:**  
Quais informações você registraria para investigar uma resposta incorreta gerada por uma aplicação Spring AI?

**O que essa pergunta avalia:**  
Avalia se o candidato entende a importância de rastrear as etapas da solicitação sem violar a privacidade.

**Resposta esperada:**  
A aplicação pode registrar informações como:

- Identificador da requisição;
- Usuário ou serviço responsável, de forma protegida;
- Data e hora;
- Modelo e provedor;
- Versão do prompt;
- Identificadores dos documentos recuperados;
- Parâmetros relevantes;
- Latência;
- Tokens ou custo estimado;
- Resultado da validação;
- Erros e retentativas;
- Ferramentas utilizadas;
- Decisões de fallback.

O registro deve evitar armazenar dados pessoais, segredos ou prompts completos quando não forem necessários.

Também é importante definir retenção, controle de acesso e proteção dos registros.

**Exemplo de rastreabilidade:**

~~~mermaid
flowchart LR
    A[Requisição] --> B[ID de correlação]
    B --> C[Busca de documentos]
    C --> D[Chamada ao modelo]
    D --> E[Validação da resposta]
    E --> F[Resposta ao usuário]
    B --> G[Registros protegidos]
~~~

**Como o candidato deve responder:**

- Mencionar identificadores de correlação;
- Citar modelo, prompt, fontes e erros;
- Considerar privacidade;
- Falar sobre retenção e acesso;
- Explicar a utilidade para auditoria e troubleshooting.

**Resposta fraca ou incompleta:**  
“Eu salvaria tudo, incluindo o prompt completo e todos os dados do usuário.”

Isso pode gerar riscos de privacidade e exposição de informações confidenciais.

**Critérios de avaliação:**

- **0** — Não reconhece a necessidade de auditoria.
- **1** — Não registra nenhuma informação.
- **2** — Registra o texto completo sem considerar privacidade.
- **3** — Propõe registros básicos de requisição e erro.
- **4** — Considera fontes, versões, custo, latência e proteção dos dados.
- **5** — Define rastreabilidade segura, com correlação, retenção, acesso mínimo e capacidade de reconstruir o fluxo.

**Perguntas de aprofundamento:**

1. Como investigaria uma falha sem armazenar dados pessoais completos?
2. Que informações não deveriam aparecer nos logs?
3. Por quanto tempo manteria registros de uma conversa?

---

## Pergunta 99 — Estratégia de evolução de uma aplicação Spring AI

**Nível:** Júnior  
**Categoria:** Arquitetura e manutenção

**Pergunta do entrevistador:**  
Como você evoluiria uma aplicação Spring AI que começou como um protótipo simples e passou a ser utilizada por muitos usuários?

**O que essa pergunta avalia:**  
Avalia a capacidade de identificar necessidades de crescimento sem adicionar complexidade desnecessária desde o início.

**Resposta esperada:**  
A evolução deve ser guiada pelos problemas observados.

Algumas melhorias possíveis são:

- Separar responsabilidades;
- Externalizar configurações;
- Proteger credenciais;
- Adicionar testes;
- Implementar observabilidade;
- Controlar custos;
- Persistir histórico de forma adequada;
- Adicionar rate limiting;
- Utilizar filas;
- Melhorar controle de acesso;
- Versionar prompts;
- Monitorar qualidade;
- Utilizar cache quando apropriado;
- Criar fallback;
- Separar ingestão de documentos do atendimento online.

Não é necessário implementar todos esses recursos antes de existir uma necessidade real, mas os riscos devem ser avaliados conforme o uso cresce.

**Exemplo de evolução:**

~~~mermaid
flowchart LR
    A[Protótipo] --> B[Separar camadas]
    B --> C[Adicionar testes e configuração segura]
    C --> D[Monitorar qualidade e custos]
    D --> E[Controlar volume e acesso]
    E --> F[Escalar processamento]
    F --> G[Governança contínua]
~~~

**Como o candidato deve responder:**

- Evitar excesso de engenharia no protótipo;
- Identificar riscos do crescimento;
- Mencionar segurança, testes e observabilidade;
- Considerar volume, custos e histórico;
- Explicar que a evolução deve ser incremental.

**Resposta fraca ou incompleta:**  
“Eu reescreveria toda a aplicação usando uma arquitetura complexa.”

A reescrita completa pode aumentar riscos e não resolver os problemas reais.

**Critérios de avaliação:**

- **0** — Não apresenta estratégia de evolução.
- **1** — Propõe apenas aumentar servidores.
- **2** — Menciona separação de camadas, mas ignora operação.
- **3** — Identifica melhorias básicas de segurança e testes.
- **4** — Considera escala, custos, filas, observabilidade e qualidade.
- **5** — Propõe evolução incremental, orientada por métricas, risco, uso real e prioridades do produto.

**Perguntas de aprofundamento:**

1. Que sinais indicariam a necessidade de utilizar filas?
2. Que parte você separaria primeiro?
3. Como evitaria aumentar a complexidade sem benefício?

---

## Pergunta 100 — Projeto completo de uma solução Spring AI

**Nível:** Júnior  
**Categoria:** Integração de conhecimentos

**Pergunta do entrevistador:**  
Como você projetaria uma aplicação Spring AI que responde perguntas sobre documentos internos, mantém o histórico da conversa e permite consultar dados atuais de uma API?

**O que essa pergunta avalia:**  
Avalia se o candidato consegue integrar os principais conceitos estudados em uma solução coerente.

**Resposta esperada:**  
Uma solução básica poderia conter:

- Endpoint para receber perguntas;
- Autenticação e autorização;
- Identificador de conversa;
- Armazenamento do histórico;
- Processo de ingestão de documentos;
- Divisão dos documentos em trechos;
- Geração de embeddings;
- Banco vetorial;
- Busca filtrada por permissões;
- Consulta a APIs internas;
- `ChatClient` para interação com o modelo;
- Prompts versionados;
- Validação das respostas;
- Tratamento de erros e timeouts;
- Controle de custos;
- Rate limiting;
- Observabilidade;
- Auditoria;
- Fallback;
- Possibilidade de revisão humana em ações sensíveis.

O modelo deve auxiliar na interpretação e na geração da resposta, mas a aplicação deve permanecer responsável por autorização, regras de negócio, acesso a dados e execução de ações.

**Arquitetura conceitual:**

~~~mermaid
flowchart TD
    A[Usuário autenticado] --> B[Controller]
    B --> C[Serviço de conversa]
    C --> D[Validar permissões]
    D --> E[Recuperar histórico]
    D --> F[Buscar documentos autorizados]
    D --> G[Consultar API atual]
    E --> H[Montar contexto]
    F --> H
    G --> H
    H --> I[ChatClient]
    I --> J[Modelo]
    J --> K[Validar resposta]
    K --> L[Salvar histórico e auditoria]
    L --> M[Retornar resposta]
~~~

Uma separação possível seria:

- **Controller:** entrada e saída HTTP;
- **Serviço de conversa:** coordenação do fluxo;
- **Serviço de memória:** histórico;
- **Serviço de recuperação:** documentos e embeddings;
- **Serviço de integração:** APIs internas;
- **Serviço de IA:** interação com o modelo;
- **Camada de segurança:** autenticação e autorização;
- **Observabilidade:** métricas, logs protegidos e rastreabilidade.

**Como o candidato deve responder:**

- Organizar o fluxo de ponta a ponta;
- Diferenciar histórico, documentos e dados atuais;
- Mencionar autorização em todas as fontes;
- Considerar validação e segurança;
- Explicar o papel do `ChatClient`;
- Incluir custos, erros, observabilidade e auditoria;
- Demonstrar que o modelo não substitui as regras da aplicação.

**Resposta fraca ou incompleta:**  
“Eu criaria um endpoint, enviaria a pergunta ao modelo e retornaria a resposta.”

Essa solução ignora histórico, documentos, dados atuais, autorização, custos, falhas e validação.

**Critérios de avaliação:**

- **0** — Não consegue estruturar uma solução.
- **1** — Apenas envia perguntas ao modelo.
- **2** — Cita RAG, mas ignora segurança e APIs atuais.
- **3** — Propõe uma arquitetura básica com histórico e documentos.
- **4** — Inclui autorização, APIs, validação, observabilidade e tratamento de erros.
- **5** — Integra os componentes de forma coerente, segura, testável, observável e adequada ao crescimento.

**Perguntas de aprofundamento:**

1. Como garantiria que o usuário não acessasse documentos de outra empresa?
2. Como diferenciaria uma informação recuperada de um documento de um dado atual da API?
3. Que ações exigiriam confirmação humana?
4. Como avaliaria a qualidade dessa solução antes de colocá-la em produção?

---

## Resumo final do roteiro

- **Perguntas apresentadas nesta parte:** 91 a 100
- **Total concluído:** 100 perguntas
- **Nível:** Júnior
- **Tecnologia:** Spring AI
- **Categorias abordadas:** fundamentos, arquitetura, prompts, RAG, memória, segurança, privacidade, integração, testes, desempenho, custos, observabilidade e operação

O roteiro completo cobre desde os conceitos básicos do Spring AI até a construção e operação de uma aplicação com conversas, documentos internos, busca vetorial, APIs externas e controles de produção.

---

`markdown
# Roteiro de Entrevista Técnica — Spring AI

> **Parte 10 de 10**  
> Esta parte contém as perguntas **91 a 100 de 100**.

**Tecnologia avaliada:** Spring AI  
**Nível:** Júnior  
**Perfil:** Perguntas conceituais, práticas e baseadas em cenários reais

---

## Pergunta 91 — Cache de respostas

**Categoria:** Desempenho e custos

**Pergunta do entrevistador:**  
Em que situação um cache poderia ser utilizado em uma aplicação Spring AI?

**Resposta esperada:**  
Um cache pode ser utilizado quando perguntas iguais ou semelhantes produzem respostas que podem ser reutilizadas com segurança.

Ele pode ajudar a:

- Reduzir custos;
- Diminuir a latência;
- Evitar chamadas repetidas ao provedor;
- Reduzir o consumo de recursos;
- Melhorar a experiência do usuário.

O cache deve considerar:

- Prazo de validade;
- Usuário e permissões;
- Versão do prompt;
- Modelo utilizado;
- Versão dos documentos;
- Dados personalizados;
- Necessidade de atualização.

Uma pergunta geral, como “O que é Spring Boot?”, pode ser armazenada. Já o status de um pedido deve ser consultado novamente em uma fonte oficial.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Receber pergunta] --> B[Verificar cache]
    B --> C{Resposta válida?}
    C -- Sim --> D[Retornar resposta armazenada]
    C -- Não --> E[Consultar modelo ou fonte oficial]
    E --> F[Validar resposta]
    F --> G{Pode armazenar?}
    G -- Sim --> H[Salvar no cache]
    G -- Não --> I[Retornar sem armazenar]
~~~

**Resposta fraca ou incompleta:**  
“Eu armazenaria todas as respostas para evitar chamadas ao modelo.”

Essa abordagem pode devolver dados desatualizados ou informações de outro usuário.

---

## Pergunta 92 — Controle de concorrência

**Categoria:** Desempenho e confiabilidade

**Pergunta do entrevistador:**  
Quais cuidados você teria ao permitir várias chamadas simultâneas ao modelo?

**Resposta esperada:**  
Chamadas simultâneas podem melhorar o processamento, mas também podem causar:

- Saturação de conexões;
- Excesso de memória;
- Mais timeouts;
- Aumento de custos;
- Ultrapassagem dos limites do provedor;
- Respostas fora de ordem;
- Conflitos no histórico de uma conversa.

A aplicação deve controlar a quantidade de chamadas simultâneas usando filas, limites de concorrência ou mecanismos de backpressure.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Requisições recebidas] --> B[Fila]
    B --> C[Limite de chamadas simultâneas]
    C --> D[Consultar modelo]
    D --> E[Retornar resultado]
    C --> F{Capacidade excedida?}
    F -- Sim --> G[Informar ou enfileirar]
~~~

**Resposta fraca ou incompleta:**  
“Eu criaria uma chamada para cada requisição recebida.”

Isso pode sobrecarregar a aplicação e o provedor.

---

## Pergunta 93 — Idempotência em operações com IA

**Categoria:** Confiabilidade e integração

**Pergunta do entrevistador:**  
Por que a idempotência é importante ao integrar uma aplicação Spring AI com operações externas?

**Resposta esperada:**  
Uma operação idempotente produz o mesmo efeito quando executada mais de uma vez.

Isso é importante porque uma operação pode ter sido concluída no sistema externo, mas a aplicação pode não ter recebido a resposta. Se ela tentar novamente sem controle, poderá duplicar a ação.

A aplicação pode utilizar:

- Chave de idempotência;
- Identificador único da operação;
- Verificação de estado;
- Registro de auditoria;
- Confirmação antes de repetir.

**Exemplo:**

~~~mermaid
sequenceDiagram
    participant A as Aplicação
    participant S as Sistema externo

    A->>S: Envia operação com chave única
    S-->>A: Processa operação
    A->>S: Repete chamada após timeout
    S-->>A: Informa que a operação já foi processada
~~~

**Resposta fraca ou incompleta:**  
“Basta repetir a chamada até funcionar.”

Isso pode executar a mesma ação várias vezes.

---

## Pergunta 94 — Fallback quando o provedor está indisponível

**Categoria:** Resiliência

**Pergunta do entrevistador:**  
Como você projetaria o comportamento da aplicação quando o provedor de modelos estivesse indisponível?

**Resposta esperada:**  
A aplicação deve detectar a indisponibilidade e oferecer um comportamento seguro.

Alternativas possíveis:

- Retornar uma mensagem clara;
- Usar outro provedor compatível;
- Encaminhar para atendimento humano;
- Utilizar respostas previamente armazenadas;
- Disponibilizar funcionalidades determinísticas;
- Colocar a solicitação em uma fila;
- Fazer retentativas limitadas;
- Interromper temporariamente novas chamadas.

O fallback não deve inventar uma resposta apenas para esconder a falha.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Solicitação] --> B[Provedor principal]
    B --> C{Disponível?}
    C -- Sim --> D[Gerar resposta]
    C -- Não --> E{Existe fallback seguro?}
    E -- Sim --> F[Usar fallback]
    E -- Não --> G[Informar indisponibilidade]
    D --> H[Validar saída]
    F --> H
~~~

**Resposta fraca ou incompleta:**  
“Eu retornaria uma resposta genérica para o usuário não perceber a falha.”

Isso pode transmitir informação incorreta.

---

## Pergunta 95 — Controle de custos

**Categoria:** Operação e governança

**Pergunta do entrevistador:**  
Como você controlaria os custos de uma aplicação que utiliza modelos de linguagem?

**Resposta esperada:**  
O controle pode incluir:

- Limites por usuário;
- Rate limiting;
- Monitoramento de tokens;
- Escolha adequada do modelo;
- Limitação do tamanho dos prompts;
- Redução de contexto desnecessário;
- Limitação das respostas;
- Cache;
- Processamento em lote;
- Alertas de consumo;
- Separação entre ambientes;
- Avaliação de custo por funcionalidade.

**Exemplo de indicadores:**

~~~text
- Chamadas por usuário
- Tokens de entrada e saída
- Custo médio por solicitação
- Custo por funcionalidade
- Percentual de retentativas
- Uso por ambiente
- Custo diário e mensal
~~~

**Resposta fraca ou incompleta:**  
“Eu verificaria o custo somente no final do mês.”

Esse acompanhamento pode ser tardio para evitar consumo excessivo.

---

## Pergunta 96 — Segurança no uso de ferramentas

**Categoria:** Segurança e integração

**Pergunta do entrevistador:**  
Quais cuidados você teria ao permitir que o modelo utilize ferramentas ou funções da aplicação?

**Resposta esperada:**  
As ferramentas devem possuir:

- Escopo limitado;
- Parâmetros validados;
- Autorização no código;
- Controle de acesso;
- Registro de auditoria;
- Limites de uso;
- Tratamento de erros;
- Proteção contra duplicidade;
- Confirmação para ações sensíveis.

O modelo pode sugerir a chamada de uma ferramenta, mas a aplicação deve decidir se ela pode ser executada.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Modelo sugere ferramenta] --> B[Validar ferramenta]
    B --> C[Validar argumentos]
    C --> D[Verificar autorização]
    D --> E{Ação sensível?}
    E -- Sim --> F[Solicitar confirmação]
    E -- Não --> G[Executar com limites]
    F --> H[Registrar auditoria]
    G --> H
~~~

**Resposta fraca ou incompleta:**  
“Eu disponibilizaria todos os métodos da aplicação para o modelo escolher.”

Isso aumenta o risco de acesso indevido e de efeitos colaterais.

---

## Pergunta 97 — Limites de contexto

**Categoria:** Desempenho e qualidade

**Pergunta do entrevistador:**  
O que pode acontecer quando o histórico e os documentos enviados ao modelo ultrapassam o limite de contexto?

**Resposta esperada:**  
A aplicação pode enfrentar:

- Erro na requisição;
- Truncamento de mensagens;
- Aumento de custo;
- Maior latência;
- Perda de informações importantes;
- Respostas menos precisas;
- Dificuldade para localizar informações relevantes.

Para reduzir o problema, a aplicação pode:

- Limitar o histórico;
- Resumir conversas antigas;
- Recuperar apenas documentos relevantes;
- Reduzir o tamanho dos trechos;
- Remover duplicidades;
- Controlar o tamanho da resposta.

**Exemplo de fluxo:**

~~~mermaid
flowchart TD
    A[Histórico e documentos] --> B[Medir tamanho do contexto]
    B --> C{Dentro do limite?}
    C -- Sim --> D[Enviar ao modelo]
    C -- Não --> E[Resumir e selecionar informações]
    E --> F[Montar contexto reduzido]
    F --> D
~~~

**Resposta fraca ou incompleta:**  
“Eu enviaria tudo e deixaria o modelo decidir o que usar.”

Isso pode ultrapassar limites e aumentar o ruído.

---

## Pergunta 98 — Auditoria e rastreabilidade

**Categoria:** Governança e segurança

**Pergunta do entrevistador:**  
Quais informações você registraria para investigar uma resposta incorreta gerada por uma aplicação Spring AI?

**Resposta esperada:**  
A aplicação pode registrar:

- Identificador da requisição;
- Data e hora;
- Modelo e provedor;
- Versão do prompt;
- Identificadores dos documentos recuperados;
- Latência;
- Tokens ou custo estimado;
- Resultado da validação;
- Erros e retentativas;
- Ferramentas utilizadas;
- Decisões de fallback.

O registro deve evitar armazenar dados pessoais, segredos ou prompts completos quando não forem necessários.

**Exemplo de rastreabilidade:**

~~~mermaid
flowchart LR
    A[Requisição] --> B[ID de correlação]
    B --> C[Busca de documentos]
    C --> D[Chamada ao modelo]
    D --> E[Validação da resposta]
    E --> F[Resposta ao usuário]
    B --> G[Registros protegidos]
~~~

**Resposta fraca ou incompleta:**  
“Eu salvaria tudo, incluindo o prompt completo e todos os dados do usuário.”

Isso pode gerar riscos de privacidade e exposição de informações confidenciais.

---

## Pergunta 99 — Estratégia de evolução

**Categoria:** Arquitetura e manutenção

**Pergunta do entrevistador:**  
Como você evoluiria uma aplicação Spring AI que começou como um protótipo simples e passou a ser utilizada por muitos usuários?

**Resposta esperada:**  
A evolução deve ser orientada pelos problemas observados.

Algumas melhorias possíveis são:

- Separar responsabilidades;
- Externalizar configurações;
- Proteger credenciais;
- Adicionar testes;
- Implementar observabilidade;
- Controlar custos;
- Persistir o histórico adequadamente;
- Adicionar rate limiting;
- Utilizar filas;
- Melhorar o controle de acesso;
- Versionar prompts;
- Monitorar a qualidade;
- Criar fallback;
- Separar a ingestão de documentos do atendimento online.

**Exemplo de evolução:**

~~~mermaid
flowchart LR
    A[Protótipo] --> B[Separar camadas]
    B --> C[Adicionar testes e configuração segura]
    C --> D[Monitorar qualidade e custos]
    D --> E[Controlar volume e acesso]
    E --> F[Escalar processamento]
    F --> G[Governança contínua]
~~~

**Resposta fraca ou incompleta:**  
“Eu reescreveria toda a aplicação usando uma arquitetura complexa.”

A reescrita completa pode aumentar riscos e não resolver os problemas reais.

---

## Pergunta 100 — Projeto completo de uma solução Spring AI

**Categoria:** Integração de conhecimentos

**Pergunta do entrevistador:**  
Como você projetaria uma aplicação Spring AI que responde perguntas sobre documentos internos, mantém o histórico da conversa e permite consultar dados atuais de uma API?

**Resposta esperada:**  
Uma solução básica poderia conter:

- Endpoint para receber perguntas;
- Autenticação e autorização;
- Identificador de conversa;
- Armazenamento do histórico;
- Processo de ingestão de documentos;
- Divisão dos documentos em trechos;
- Geração de embeddings;
- Banco vetorial;
- Busca filtrada por permissões;
- Consulta a APIs internas;
- `ChatClient` para interação com o modelo;
- Prompts versionados;
- Validação das respostas;
- Tratamento de erros e timeouts;
- Controle de custos;
- Rate limiting;
- Observabilidade;
- Auditoria;
- Fallback;
- Revisão humana para ações sensíveis.

O modelo deve auxiliar na interpretação e na geração da resposta, mas a aplicação deve permanecer responsável por autorização, regras de negócio, acesso a dados e execução de ações.

**Arquitetura conceitual:**

~~~mermaid
flowchart TD
    A[Usuário autenticado] --> B[Controller]
    B --> C[Serviço de conversa]
    C --> D[Validar permissões]
    D --> E[Recuperar histórico]
    D --> F[Buscar documentos autorizados]
    D --> G[Consultar API atual]
    E --> H[Montar contexto]
    F --> H
    G --> H
    H --> I[ChatClient]
    I --> J[Modelo]
    J --> K[Validar resposta]
    K --> L[Salvar histórico e auditoria]
    L --> M[Retornar resposta]
~~~

**Resposta fraca ou incompleta:**  
“Eu criaria um endpoint, enviaria a pergunta ao modelo e retornaria a resposta.”

Essa solução ignora histórico, documentos, dados atuais, autorização, custos, falhas e validação.

---

## Resumo final do roteiro

- **Perguntas apresentadas nesta parte:** 91 a 100
- **Total concluído:** 100 perguntas
- **Nível:** Júnior
- **Tecnologia:** Spring AI
- **Categorias abordadas:** fundamentos, arquitetura, prompts, RAG, memória, segurança, privacidade, integração, testes, desempenho, custos, observabilidade e operação
