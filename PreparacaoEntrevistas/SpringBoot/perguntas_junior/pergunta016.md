# Pergunta 16 — Como funciona o sistema de logging no Spring Boot?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"O Spring Boot já vem com logging configurado por padrão. Como funciona esse sistema? Qual biblioteca ele usa, como você configura os níveis de log e como você adiciona logs no código?"

**O que essa pergunta avalia:**  
Avalia se o candidato sabe que o Spring Boot usa SLF4J como facade e Logback como implementação padrão, conhece os níveis de log e sabe configurá-los via `application.properties`.

**Resposta esperada:**  
O Spring Boot vem com logging pré-configurado usando:
- **SLF4J** (Simple Logging Facade for Java) como API/facade — é o que você usa no código.
- **Logback** como implementação padrão — é o motor que efetivamente escreve os logs.

**Níveis de log (em ordem de severidade):**
- `TRACE` — informação muito detalhada (raramente usado em produção).
- `DEBUG` — informação de depuração.
- `INFO` — informações gerais sobre o funcionamento.
- `WARN` — avisos de situações potencialmente problemáticas.
- `ERROR` — erros que precisam de atenção.

**Como usar no código:**

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioService {

    // Forma tradicional
    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public Usuario buscarPorId(Long id) {
        logger.info("Buscando usuário com ID: {}", id);

        Usuario usuario = repository.findById(id)
            .orElseThrow(() -> {
                logger.error("Usuário não encontrado: ID {}", id);
                return new UsuarioNaoEncontradoException(id);
            });

        logger.debug("Usuário encontrado: {}", usuario.getNome());
        return usuario;
    }
}
```

Alternativa com Lombok (`@Slf4j`):
```java
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService {

    public Usuario buscarPorId(Long id) {
        log.info("Buscando usuário com ID: {}", id);
        // log é injetado automaticamente pelo Lombok
    }
}
```

**Configuração via `application.properties`:**
```properties
# Nível raiz
logging.level.root=INFO

# Nível específico por pacote
logging.level.com.minhaempresa=DEBUG
logging.level.org.springframework=INFO
logging.level.org.hibernate.SQL=DEBUG

# Arquivo de log
logging.file.name=logs/aplicacao.log

# Padrão do log
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
```

**Explicação didática:**  
O sistema de logging funciona em camadas. O SLF4J é como um "controle remoto universal" — você escreve o código usando a API do SLF4J, e ele repassa para a implementação real (Logback). A vantagem é que se um dia você quiser trocar o Logback por Log4j2, não precisa mudar nenhuma linha de código — só a configuração.

Os níveis de log funcionam como um "filtro de ruído". `INFO` mostra apenas informações importantes; `DEBUG` mostra tudo que `INFO` mostra mais detalhes de depuração; `TRACE` mostra tudo. Em produção, você geralmente usa `INFO` ou `WARN`; em desenvolvimento, `DEBUG`.

**Como o candidato deve responder:**  
- Mencionar SLF4J (API) e Logback (implementação).
- Citar os níveis de log (TRACE, DEBUG, INFO, WARN, ERROR).
- Mostrar como criar um logger e usar `logger.info()`, `logger.error()`.
- Explicar como configurar níveis via `application.properties`.
- Mencionar o uso de `{}` para parametrização (não concatenação).

**Resposta fraca ou incompleta:**  
"Você usa `System.out.println` para logar."  
Falta: não conhece SLF4J/Logback, não sabe configurar níveis, usa prática desaconselhada.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe como logar |
| 1 | Menciona System.out.println |
| 2 | Conhece logger mas não sabe a biblioteca nem configurar níveis |
| 3 | Explica SLF4J/Logback, níveis e configuração |
| 4 | Demonstra prática com Lombok, parametrização e arquivo de log |
| 5 | Responde com profundidade, menciona troca de implementação, log em arquivo e boas práticas |

**Perguntas de aprofundamento:**
1. "Por que você deve usar `logger.info("mensagem {}", variavel)` em vez de `logger.info("mensagem " + variavel)`?"
2. "Como você alteraria o nível de log em runtime sem reiniciar a aplicação?"
3. "Como você configuraria logs para ir para um arquivo com rotação diária?"

