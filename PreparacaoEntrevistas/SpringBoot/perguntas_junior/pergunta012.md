# Pergunta 12 — Qual a diferença entre application.properties e application.yml?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"O Spring Boot suporta tanto `application.properties` quanto `application.yml`. Qual é a diferença entre eles? Existe alguma vantagem em usar um ou outro?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece os dois formatos suportados pelo Spring Boot, entende a sintaxe YAML e sabe escolher o formato adequado para cada situação.

**Resposta esperada:**  
Ambos os formatos são suportados pelo Spring Boot e têm a mesma função: configurar a aplicação. A diferença está na sintaxe e na legibilidade.

**`application.properties`** — usa sintaxe de chave-valor com notação plana e ponto como separador hierárquico:

```properties
server.port=8080
server.servlet.context-path=/api
spring.datasource.url=jdbc:postgresql://localhost:5432/db
spring.datasource.username=postgres
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

**`application.yml`** — usa YAML (YAML Ain't Markup Language), que suporta estrutura hierárquica com indentação:

```yaml
server:
  port: 8080
  servlet:
    context-path: /api

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/db
    username: postgres
    password: senha
  jpa:
    hibernate:
      ddl-auto: update
```

**Vantagens do YAML:**
- **Mais legível** para configurações hierárquicas — evita repetição de prefixos.
- **Suporte a multi-document** — permite definir múltiplos profiles em um único arquivo com `---` como separador.
- **Estrutura visual clara** — a indentação mostra a relação entre as propriedades.

**Vantagens do properties:**
- **Sintaxe mais simples** — não há risco de erros de indentação.
- **Compatibilidade ampla** — é o formato tradicional do Java (`.properties`).
- **Ferramentas** — algumas ferramentas e bibliotecas legadas trabalham melhor com `.properties`.

**Pontos de atenção com YAML:**
- A indentação é significativa — espaços (não tabs) definem a hierarquia.
- Não pode haver tabs misturados com espaços.
- Strings com caracteres especiais podem precisar de aspas.

**Explicação didática:**  
Imagine que o `.properties` é como escrever uma lista de compras em uma linha: "leite.verde= integral, leite.quantidade= 2". Funciona, mas para listas grandes fica confuso. O YAML é como organizar essa lista em categorias indentadas: você vê claramente que "leite" tem "verde" e "quantidade" dentro dele. Para configurações simples, ambos servem; para configurações complexas e aninhadas, YAML é mais legível.

**Como o candidato deve responder:**  
- Explicar que ambos têm a mesma função mas usam sintaxes diferentes.
- Mostrar a diferença visual entre os dois formatos.
- Mencionar vantagens do YAML: legibilidade hierárquica, multi-document.
- Mencionar vantagens do properties: simplicidade, sem risco de indentação.
- Não dizer que um é "melhor" que o outro de forma absoluta — depende do contexto.

**Resposta fraca ou incompleta:**  
"YML é mais moderno."  
Falta: não explica a diferença de sintaxe, não mostra exemplos, não menciona vantagens/desvantagens.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe a diferença |
| 1 | Sabe que "são formatos diferentes" mas não explica |
| 2 | Mostra a diferença de sintaxe mas não menciona vantagens |
| 3 | Explica sintaxe, vantagens e desvantagens de ambos |
| 4 | Demonstra conhecimento de multi-document YAML e casos de uso |
| 5 | Responde com profundidade, menciona precedência quando ambos existem, erros comuns de YAML e boas práticas |

**Perguntas de aprofundamento:**
1. "O que acontece se você tiver tanto `application.properties` quanto `application.yml` no projeto?"
2. "Como você define uma lista de valores em YAML vs em properties?"
3. "Quais erros de indentação são mais comuns em YAML e como evitá-los?"

