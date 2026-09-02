# Pergunta 17 — O que é o Spring Boot DevTools e como ele ajuda no desenvolvimento?

**Nível:** Júnior  
**Categoria:** Ferramentas

**Pergunta do entrevistador:**  
"O Spring Boot tem uma dependência chamada DevTools que muitos desenvolvedores adicionam ao projeto. O que é o DevTools, quais funcionalidades ele oferece e por que ele não deve ir para produção?"

**O que essa pergunta avalia:**  
Avalia se o candidato conhece o DevTools como ferramenta de produtividade no desenvolvimento, sabe quais funcionalidades ele oferece (restart automático, live reload) e entende que ele não deve ser incluído em builds de produção.

**Resposta esperada:**  
O **Spring Boot DevTools** é um módulo projetado para melhorar a experiência de desenvolvimento, oferecendo funcionalidades que aceleram o ciclo de codificação e teste.

**Como adicionar:**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>  <!-- importante: não vai para produção -->
    <optional>true</optional>
</dependency>
```

**Principais funcionalidades:**

1. **Restart automático (Automatic Restart):**  
Quando você altera um arquivo de código (Java, configuração, etc.) e salva, o DevTools reinicia automaticamente a aplicação. Ele usa **dois classloaders**:
   - **Base classloader** — carrega dependências de bibliotecas (JARs) que raramente mudam.
   - **Restart classloader** — carrega as classes do seu projeto, que mudam frequentemente.

   No restart, apenas o restart classloader é recarregado, tornando o reinício muito mais rápido que um restart completo.

2. **LiveReload:**  
O DevTools integra com a extensão LiveReload do navegador. Quando um recurso estático (HTML, CSS, JS) é alterado, o navegador recarrega automaticamente a página.

3. **Desativação de caching em desenvolvimento:**  
O DevTools desativa caches que normalmente prejudicam o desenvolvimento, como caching de templates (Thymeleaf) e caching de recursos estáticos.

4. **Configurações de desenvolvimento automáticas:**  
Aplica configurações otimizadas para desenvolvimento, como aumentar o nível de log para DEBUG.

**Por que não usar em produção:**
- O restart automático pode causar reinícios indesejados.
- A desativação de caches prejudica a performance.
- Ferramentas de desenvolvimento não devem estar em ambientes de produção por segurança.
- O `scope=runtime` e `optional=true` garantem que o DevTools não seja empacotado no JAR de produção.

**Explicação didática:**  
O DevTools é como um "assistente de desenvolvimento" que fica observando seu código. Toda vez que você salva uma alteração, ele rapidamente reinicia a aplicação para você ver o resultado — sem precisar parar, recompilar e rodar manualmente. É como ter um autossalvamento que aplica as mudanças em tempo real. Mas, como qualquer ferramenta de desenvolvimento, não faz sentido levá-la para produção — seria como levar seu caderno de rascunho para uma apresentação formal.

**Como o candidato deve responder:**  
- Explicar que é uma ferramenta de produtividade para desenvolvimento.
- Citar restart automático e live reload como principais funcionalidades.
- Mencionar que usa dois classloaders para restart mais rápido.
- Explicar por que não deve ir para produção (caches, security, performance).
- Mencionar o `scope=runtime` e `optional=true`.

**Resposta fraca ou incompleta:**  
"DevTools reinicia a aplicação automaticamente."  
Falta: não menciona live reload, não explica os dois classloaders, não fala por que não vai para produção.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não conhece DevTools |
| 1 | Sabe que "reinicia sozinho" mas nada mais |
| 2 | Menciona restart e live reload mas não explica classloaders |
| 3 | Explica funcionalidades, classloaders e exclusão de produção |
| 4 | Demonstra conhecimento de cache desativado e configurações automáticas |
| 5 | Responde com profundidade, menciona trigger file, remote restart e integração com IDE |

**Perguntas de aprofundamento:**
1. "Como você configuraria o DevTools para só reiniciar quando um arquivo específico for alterado (trigger file)?"
2. "É possível usar o DevTools para restart remoto em um servidor? Como?"
3. "Qual a diferença entre o restart do DevTools e o hot swap da JVM?"

