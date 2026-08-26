# Pergunta 1 — O que é o Spring Boot e quais problemas ele resolve?

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
"O que é o Spring Boot e quais principais problemas ele veio resolver em relação ao uso do Spring Framework tradicional?"

**O que essa pergunta avalia:**  
Avalia se o candidato compreende a motivação por trás do Spring Boot, sua relação com o Spring Framework e se consegue distinguir configuração manual de configuração automatizada. É fundamental para verificar se o júnior entende o ecossistema em que está trabalhando, em vez de apenas "apertar botões" sem entender o contexto.

**Resposta esperada:**  
O Spring Boot é um projeto construído sobre o Spring Framework que simplifica a configuração e a inicialização de aplicações Java. Ele resolve três problemas principais do Spring tradicional:

1. **Configuração excessivamente manual** — no Spring tradicional, era necessário configurar manualmente XML ou Java Config para cada componente, datasource, view resolver, etc. O Spring Boot introduz a **autoconfiguração** (*auto-configuration*), que detecta dependências no classpath e configura os beans necessários automaticamente.

2. **Dependências versionadas manualmente** — o Spring Boot oferece **starters**, pacotes de dependências pré-configuradas com versões compatíveis entre si, eliminando conflitos de versão. O `spring-boot-starter-web`, por exemplo, já traz Spring MVC, Jackson, Tomcat embutido e validação.

3. **Necessidade de servidor externo** — o Spring Boot traz um **servidor embutido** (Tomcat por padrão), permitindo rodar a aplicação como um JAR executável (`java -jar`), sem precisar de um servidor de aplicação externo como Tomcat ou JBoss.

**Explicação didática:**  
Pense no Spring Framework como uma caixa de ferramentas muito poderosa, mas que exige que você monte cada ferramenta manualmente antes de usar. O Spring Boot chega e diz: "já montamos as ferramentas mais comuns para você — você só precisa ajustar o que for específico do seu projeto". O termo técnico para isso é *convention over configuration* (convenção sobre configuração): o Spring Boot assume padrões sensatos e só pede que você sobrescreva o que realmente precisa mudar.

**Exemplo prático:**  
Em um projeto Spring tradicional (sem Boot), para criar um endpoint REST, você precisaria de: configurar o `DispatcherServlet` no `web.xml`, configurar `ViewResolver`, adicionar o Jackson manualmente para serialização JSON, configurar o Tomcat, e definir o bean do controller. Com Spring Boot, basta criar uma classe com `@RestController` e um método com `@GetMapping` — todo o resto é configurado automaticamente.

**Exemplo de código:**

```java
// Com Spring Boot — tudo que é preciso para um endpoint REST funcional
@SpringBootApplication
public class MinhaAplicacao {
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }
}

@RestController
@RequestMapping("/api")
public class MeuController {

    @GetMapping("/ola")
    public String saudacao() {
        return "Olá, Spring Boot!";
    }
}
```

A aplicação acima já roda com servidor Tomcat embutido, Jackson para JSON e todas as configurações padrão — sem nenhum XML.

**Como o candidato deve responder:**  
- Começar explicando que o Spring Boot é uma camada sobre o Spring Framework, não uma tecnologia separada.
- Mencionar pelo menos dois dos três pilares: autoconfiguração, starters e servidor embutido.
- Se possível, contrastar brevemente com a configuração manual do Spring tradicional.
- Evitar dizer apenas "é um framework que facilita criar aplicações Java" sem explicar *como*.

**Resposta fraca ou incompleta:**  
"Spring Boot é um framework que deixa mais fácil criar aplicações Java."  
Falta: explicar o que é autoconfiguração, o que são starters, mencionar o servidor embutido e a relação com o Spring Framework original.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe responder ou diz algo incorreto |
| 1 | Sabe apenas que "facilita" mas não explica como |
| 2 | Menciona autoconfiguração ou starters, mas sem detalhar |
| 3 | Explica autoconfiguração, starters e servidor embutido corretamente |
| 4 | Demonstra domínio prático com exemplos e comparação com Spring tradicional |
| 5 | Responde com profundidade, menciona convention over configuration, BOM e dá exemplos reais |

**Perguntas de aprofundamento:**
1. "Você consegue citar pelo menos dois starters que já usou e o que eles trazem?"
2. "O que acontece por baixo dos panos quando você adiciona o `spring-boot-starter-web` no seu `pom.xml`?"
3. "É possível usar Spring Boot sem nenhum starter? Como?"

