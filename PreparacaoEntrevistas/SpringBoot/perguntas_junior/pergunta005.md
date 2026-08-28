# Pergunta 5 — Como funciona a injeção de dependências no Spring Boot?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"Poderia explicar como funciona a injeção de dependências no Spring Boot? Quais são as formas de aplicá-la e qual é a recomendada?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o conceito de DI (Dependency Injection), conhece as três formas de injeção (construtor, setter e campo) e sabe qual é a recomendada pela comunidade e pela documentação oficial.

**Resposta esperada:**  
A injeção de dependências é um padrão de projeto em que o Spring **fornece as dependências** necessárias para um objeto, em vez de o objeto criá-las manualmente (com `new`). O Spring gerencia um **container** (ApplicationContext) que instancia, configura e conecta os beans automaticamente.

Existem três formas de injeção:

1. **Injeção por construtor (recomendada):**
```java
@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    // O Spring injeta o repository via construtor
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
}
```

2. **Injeção por setter:**
```java
@Service
public class UsuarioService {
    private UsuarioRepository repository;

    @Autowired
    public void setRepository(UsuarioRepository repository) {
        this.repository = repository;
    }
}
```

3. **Injeção por campo:**
```java
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
}
```

A **forma recomendada** é a **injeção por construtor**, porque:
- Permite que as dependências sejam `final` (imutáveis).
- Facilita testes unitários (é possível instanciar a classe com mocks sem precisar de reflection).
- Garante que o objeto está totalmente inicializado após a construção.
- Se uma classe tem muitas dependências no construtor, isso serve como "code smell" indicando que a classe pode estar violando o Single Responsibility Principle.

A partir do Spring 4.3, se uma classe tem apenas um construtor, o `@Autowired` é **implícito** e pode ser omitido.

**Explicação didática:**  
Imagine que você vai cozinhar uma receita. Sem DI, você mesmo teria que ir ao mercado comprar cada ingrediente (criar cada dependência com `new`). Com DI, alguém (o container do Spring) já coloca todos os ingredientes na bancada para você usar. Você só declara o que precisa ("preciso de um Repository"), e o Spring entrega.

**Como o candidato deve responder:**  
- Explicar o conceito de DI: o Spring fornece dependências em vez de o objeto criá-las.
- Citar as três formas: construtor, setter e campo.
- Recomendar a injeção por construtor e justificar.
- Mencionar que `@Autowired` pode ser omitido em construtores únicos.
- Apontar a imutabilidade (`final`) como vantagem do construtor.

**Resposta fraca ou incompleta:**  
"DI é quando você usa `@Autowired` em uma variável."  
Falta: não explica o conceito, não menciona as três formas, não recomenda o construtor, não justifica.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é DI |
| 1 | Sabe que "@Autowired injeta" mas não explica o conceito |
| 2 | Explica o conceito mas só conhece injeção por campo |
| 3 | Explica as três formas e recomenda o construtor |
| 4 | Justifica a recomendação com imutabilidade, testabilidade e SRP |
| 5 | Responde com profundidade, menciona Spring 4.3, falhas circulares e alternativas |

**Perguntas de aprofundamento:**
1. "O que acontece se houver uma dependência circular entre dois beans? Como o Spring trata isso?"
2. "Por que a injeção por campo é considerada uma má prática?"
3. "Como você testaria uma classe que usa injeção por construtor sem subir o contexto do Spring?"

