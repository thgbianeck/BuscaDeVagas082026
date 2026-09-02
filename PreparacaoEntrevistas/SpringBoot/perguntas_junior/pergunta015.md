# Pergunta 15 — O que é o Spring Boot Actuator e para que ele serve?

**Nível:** Júnior  
**Categoria:** Ferramentas

**Pergunta do entrevistador:**  
"O Spring Boot tem um módulo chamado Actuator. O que ele é, quais endpoints ele oferece e por que ele é útil em uma aplicação em produção?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o Actuator como ferramenta de monitoramento, sabe quais endpoints principais ele oferece e entende sua importância para operação de aplicações em produção.

**Resposta esperada:**  
O **Spring Boot Actuator** é um módulo que adiciona endpoints prontos para monitoramento e gerenciamento da aplicação em produção. Ele fornece informações sobre a saúde da aplicação, métricas, configurações, ambiente, threads e mais.

**Como adicionar:**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

**Principais endpoints:**

| Endpoint | Função |
|----------|--------|
| `/actuator/health` | Status de saúde da aplicação (UP/DOWN) |
| `/actuator/info` | Informações gerais da aplicação |
| `/actuator/metrics` | Métricas (memória, threads, requests) |
| `/actuator/env` | Variáveis de ambiente e propriedades |
| `/actuator/loggers` | Configuração e níveis de log em runtime |
| `/actuator/beans` | Lista de todos os beans registrados |
| `/actuator/mappings` | Mapeamentos de URLs (endpoints) |
| `/actuator/threaddump` | Dump de threads da aplicação |

**Por padrão**, apenas `/actuator/health` é exposto via HTTP. Para expor outros endpoints:
```properties
management.endpoints.web.exposure.include=health,info,metrics
# ou todos:
management.endpoints.web.exposure.include=*
```

**Exemplo de resposta do `/actuator/health`:**
```json
{
    "status": "UP",
    "components": {
        "db": {
            "status": "UP",
            "details": {
                "database": "PostgreSQL",
                "validationQuery": "isValid()"
            }
        },
        "diskSpace": {
            "status": "UP",
            "details": {
                "total": 500107862016,
                "free": 314891837440
            }
        }
    }
}
```

**Usos práticos em produção:**
- **Health checks** — orquestradores (Kubernetes, Docker Swarm) usam `/actuator/health` para saber se a aplicação está saudável.
- **Métricas** — integrado com Micrometer, pode exportar para Prometheus, Datadog, etc.
- **Loggers em runtime** — alterar nível de log sem reiniciar a aplicação.
- **Thread dump** — diagnóstico de problemas de concorrência.

**Explicação didática:**  
O Actuator é como o "painel de instrumentos" do carro. Sem ele, você dirige "no escuro" — não sabe a velocidade, o nível de combustível, a temperatura do motor. Com o Actuator, você tem medidores que mostram como a aplicação está funcionando internamente, permitindo detectar problemas antes que virem incidentes.

**Como o candidato deve responder:**  
- Explicar que é um módulo de monitoramento e gerenciamento.
- Citar pelo menos três endpoints (health, metrics, info).
- Mencionar que por padrão apenas health é exposto.
- Explicar a importância em produção (health checks, métricas).
- Mencionar a integração com ferramentas externas (Prometheus, Kubernetes).

**Resposta fraca ou incompleta:**  
"Actuator serve para monitorar a aplicação."  
Falta: não cita endpoints específicos, não explica como habilitar, não fala sobre uso em produção.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece Actuator |
| 1 | Sabe que "monitora" mas não cita endpoints |
| 2 | Cita /health mas não outros endpoints |
| 3 | Explica múltiplos endpoints e como habilitá-los |
| 4 | Demonstra conhecimento de uso em produção (K8s, Prometheus) |
| 5 | Responde com profundidade, menciona Micrometer, security do Actuator e customização de health indicators |

**Perguntas de aprofundamento:**
1. "Como você protegeria os endpoints do Actuator em produção?"
2. "Como você criaria um custom Health Indicator?"
3. "O que é o Micrometer e como ele se relaciona com o Actuator?"

