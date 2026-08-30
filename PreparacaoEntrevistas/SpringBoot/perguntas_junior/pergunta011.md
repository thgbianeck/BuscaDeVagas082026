# Pergunta 11 — O que é o arquivo application.properties e como ele funciona?

**Nível:** Júnior  
**Categoria:** Configuração

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, existe um arquivo chamado `application.properties` (ou `application.yml`) que geralmente fica em `src/main/resources`. Qual é a função desse arquivo e que tipo de informações você colocaria nele?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o propósito do arquivo de configuração principal do Spring Boot, sabe que propriedades do framework e da aplicação são definidas ali, e conhece as propriedades mais comuns do dia a dia.

**Resposta esperada:**  
O `application.properties` (ou `application.yml`) é o arquivo de configuração principal do Spring Boot. Ele é automaticamente carregado pelo framework na inicialização e permite definir propriedades que controlam tanto o comportamento do Spring Boot quanto configurações específicas da aplicação.

**Principais usos:**

1. **Configuração do servidor embutido:**
```properties
server.port=8081
server.servlet.context-path=/api
```

2. **Configuração de banco de dados:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/meubanco
spring.datasource.username=postgres
spring.datasource.password=senha123
spring.datasource.driver-class-name=org.postgresql.Driver
```

3. **Configuração do JPA/Hibernate:**
```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

4. **Configurações de logging:**
```properties
logging.level.org.springframework=INFO
logging.level.com.minhaempresa=DEBUG
logging.file.name=logs/app.log
```

5. **Propriedades customizadas da aplicação:**
```properties
app.nome=Minha Aplicação
app.versao=1.0.0
app.featureflags.novo-modulo=true
```

**Explicação didática:**  
Pense no `application.properties` como o "painel de controle" da aplicação. Em vez de espalhar configurações pelo código (hardcoded), você centraliza tudo em um lugar. O Spring Boot lê esse arquivo automaticamente na inicialização e aplica os valores aos componentes correspondentes. As propriedades que começam com `spring.*` são reconhecidas pelo framework; as que começam com prefixos customizados (como `app.*`) são propriedades da sua aplicação, que você lê via `@Value` ou `@ConfigurationProperties`.

**Como o candidato deve responder:**  
- Explicar que é o arquivo principal de configuração, carregado automaticamente.
- Citar pelo menos três categorias de propriedades (servidor, datasource, JPA, logging).
- Mencionar que também pode armazenar propriedades customizadas.
- Citar a alternativa YAML (`application.yml`).

**Resposta fraca ou incompleta:**  
"É onde você configura a porta do servidor."  
Falta: não menciona outras configurações (banco, JPA, logging), não fala sobre propriedades customizadas.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é o arquivo |
| 1 | Sabe que "configura alguma coisa" mas não dá exemplos |
| 2 | Menciona server.port mas não outras categorias |
| 3 | Explica múltiplas categorias com exemplos |
| 4 | Demonstra prática com propriedades customizadas e YAML |
| 5 | Responde com profundidade, menciona precedência de configuração, profiles e externalização |

**Perguntas de aprofundamento:**
1. "É possível sobrescrever uma propriedade do arquivo via linha de comando? Como?"
2. "Qual a diferença entre `ddl-auto=update` e `ddl-auto=validate`? Quando usar cada um?"
3. "Como você externalizaria configurações sensíveis como senhas de banco sem colocá-las no arquivo?"

