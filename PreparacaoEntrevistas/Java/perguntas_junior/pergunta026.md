# Pergunta 26 — Imutabilidade de Objetos

**Nível:** Júnior  
**Categoria:** Boas Práticas

**Pergunta do entrevistador:**  
Em uma aplicação multi-thread, vários componentes acessam um objeto `Configuracao` que contém parâmetros do sistema (URL do banco, timeout, etc.). Ocorreram bugs intermitentes onde os valores apareciam "trocados" ou "errados" esporadicamente. Um desenvolvedor sugere tornar a classe imutável. O que isso significa, como implementar e por que resolveria o problema?

**O que essa pergunta avalia:**  
Compreensão do conceito de imutabilidade, capacidade de implementar uma classe imutável em Java, e entendimento dos benefícios (thread-safety, previsibilidade, redução de bugs).

**Resposta esperada:**  
Um objeto imutável é aquele cujo estado não pode ser alterado após a construção. Isso significa:
1. Todos os atributos são `final`.
2. Não há setters.
3. Se houver coleções, elas são defensivamente copiadas (não expostas diretamente).
4. Métodos que "modificam" retornam uma nova instância (ex: `String.substring()`).

**Como resolveria o problema:**
- Em ambiente multi-thread, objetos mutáveis compartilhados podem ser modificados por uma thread enquanto outra está lendo, causando inconsistências.
- Objetos imutáveis são inerentemente **thread-safe** — não há como uma thread altere o estado enquanto outra lê, pois o estado nunca muda.
- Qualquer "alteração" cria um novo objeto, preservando o original.

**Explicação didática:**  
Pense em um objeto imutável como uma pedra esculpida — uma vez pronta, não dá para modificar. Se você quer uma versão diferente, esculpe uma nova pedra. Um objeto mutável é como uma bola de massa: qualquer um pode amassar e mudar o formato a qualquer momento. Se várias pessoas tentam usar a mesma bola de massa ao mesmo tempo, alguém vai deformar o que o outro estava usando. A pedra (imutável) nunca tem esse problema — cada um pega a sua e pode usá-la sem medo de alguém alterá-la.

**Exemplo prático:**  
Em uma aplicação web, múltiplas requisições simultâneas acessam a mesma configuração de timeout do banco de dados. Se uma thread alterar o timeout enquanto outra está lendo, a segunda pode usar um valor parcialmente atualizado. Com imutabilidade, isso é impossível.

**Exemplo de código:**  
```java
import java.util.*;

// ✅ Classe imutável
public final class Configuracao {
    private final String urlBanco;
    private final int timeoutSegundos;
    private final List<String> hostsPermitidos; // Lista mutável!
    
    public Configuracao(String urlBanco, int timeoutSegundos, 
                       List<String> hostsPermitidos) {
        // Validação no construtor — fail-fast
        if (urlBanco == null || urlBanco.isEmpty()) {
            throw new IllegalArgumentException("URL do banco é obrigatória");
        }
        if (timeoutSegundos <= 0) {
            throw new IllegalArgumentException("Timeout deve ser positivo");
        }
        
        this.urlBanco = urlBanco;
        this.timeoutSegundos = timeoutSegundos;
        // Cópia defensiva — protege contra alterações externas
        this.hostsPermitidos = new ArrayList<>(hostsPermitidos);
    }
    
    // Getters — sem setters
    public String getUrlBanco() { return urlBanco; }
    public int getTimeoutSegundos() { return timeoutSegundos; }
    
    // Retorna cópia defensiva — não expõe a lista interna
    public List<String> getHostsPermitidos() {
        return new ArrayList<>(hostsPermitidos); // Cópia a cada chamada
    }
    
    // Ou retorna lista não modificável (mais eficiente)
    public List<String> getHostsPermitidosUnmodifiable() {
        return Collections.unmodifiableList(hostsPermitidos);
    }
    
    // "Modificação" retorna nova instância
    public Configuracao comTimeout(int novoTimeout) {
        return new Configuracao(this.urlBanco, novoTimeout, this.hostsPermitidos);
    }
    
    @Override
    public String toString() {
        return "Configuracao{url=" + urlBanco + ", timeout=" + timeoutSegundos + "s}";
    }
}

// ❌ Classe mutável — causa problemas em multi-thread
public class ConfiguracaoMutavel {
    private String urlBanco;
    private int timeoutSegundos;
    
    public void setUrlBanco(String url) { this.urlBanco = url; }
    public void setTimeoutSegundos(int t) { this.timeoutSegundos = t; }
    // Qualquer thread pode alterar a qualquer momento — race condition
}

// Uso
List<String> hosts = new ArrayList<>(Arrays.asList("host1", "host2"));
Configuracao config = new Configuracao("jdbc:postgresql://localhost/db", 30, hosts);

// Alterar a lista original NÃO afeta o objeto imutável
hosts.add("host3"); 
System.out.println(config.getHostsPermitidos()); // Ainda [host1, host2]

// "Modificar" cria nova instância
Configuracao novaConfig = config.comTimeout(60);
System.out.println(config);          // timeout=30 (inalterado)
System.out.println(novaConfig);      // timeout=60 (nova instância)
```

**Como o candidato deve responder:**  
- Definir imutabilidade: estado não pode mudar após construção.
- Listar as regras: atributos `final`, sem setters, classe `final`, cópia defensiva de coleções.
- Explicar por que resolve o problema multi-thread: não há race condition se o estado nunca muda.
- Mencionar `String` como exemplo de classe imutável nativa do Java.
- Trazer o exemplo de configuração compartilhada.
- Evitar apenas dizer "use `final` nos atributos" sem explicar cópia defensiva.

**Resposta fraca ou incompleta:**  
"Fazer os atributos `final`." — É necessário mas não suficiente. Sem cópia defensiva de coleções, o objeto ainda pode ser alterado indiretamente. Sem tirar os setters, o objeto não é imutável.

**Critérios de avaliação:**

| Nota | Descrição |
|---|---|
| 0 | Não sabe responder ou apresenta informações incorretas |
| 1 | Demonstra conhecimento muito superficial |
| 2 | Conhece parte do conceito, mas apresenta lacunas importantes |
| 3 | Responde corretamente aos fundamentos |
| 4 | Demonstra bom domínio prático e apresenta exemplos |
| 5 | Responde com profundidade, apresenta trade-offs, boas práticas e experiência real |

**Perguntas de aprofundamento:**
1. Por que a classe deve ser `final` para garantir imutabilidade?
2. Como `String` implementa imutabilidade e por que isso é vantajoso para o String Pool?
3. Em quais situações a imutabilidade pode ser um problema (ex: muitos objetos criados)?

