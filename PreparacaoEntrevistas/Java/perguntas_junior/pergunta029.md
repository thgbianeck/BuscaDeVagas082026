# Pergunta 29 — Equals, HashCode e o Contrato

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Em uma code review, você encontra uma classe `Email` que sobrescreve `equals()` para comparar o endereço de e-mail, mas não sobrescreve `hashCode()`. O desenvolvedor disse que "só usa a classe em `ArrayList`, então não precisa de `hashCode()`". Ele está correto? Em quais situações isso seria um problema? Explique o contrato entre `equals()` e `hashCode()`.

**O que essa pergunta avalia:**  
Compreensão profunda do contrato entre `equals()` e `hashCode()`, conhecimento de quando o `hashCode()` é necessário, e capacidade de identificar bugs sutis em coleções.

**Resposta esperada:**  
O desenvolvedor está **parcialmente correto** no contexto imediato, mas está criando uma **armadilha para o futuro**:

- `ArrayList` usa apenas `equals()` para verificar containment (`contains()`, `indexOf()`, `remove()`) — não usa `hashCode()`. Então, no `ArrayList`, o código funciona.
- Mas se amanhã alguém usar a classe `Email` em um `HashSet`, `HashMap` ou qualquer estrutura baseada em hash, o comportamento será incorreto: dois e-mails iguais por `equals()` podem acabar em buckets diferentes (porque `hashCode()` é o padrão de `Object`), e duplicatas serão inseridas silenciosamente.

**O contrato (da documentação de `Object`):**
1. Se `x.equals(y)` é `true`, então `x.hashCode() == y.hashCode()` deve ser obrigatoriamente `true`.
2. Se `x.equals(y)` é `false`, o `hashCode` pode ser igual ou diferente (não é obrigatório que sejam diferentes).
3. Se `hashCode()` de dois objetos é diferente, eles **obrigatoriamente** não são iguais por `equals()`.

Violar a regra 1 quebra coleções baseadas em hash.

**Explicação didática:**  
Pense no `hashCode()` como o código de barras de um produto e no `equals()` como uma verificação item a item. O `HashSet` primeiro escaneia o código de barras (`hashCode`) para encontrar a prateleira certa, depois verifica item a item (`equals`) na prateleira. Se você sobrescreve `equals()` mas não `hashCode()`, é como ter dois produtos idênticos com códigos de barras diferentes — o sistema os coloca em prateleiras diferentes e nunca percebe que são iguais. No `ArrayList`, não há prateleiras nem códigos de barras — o sistema verifica item a item diretamente, então funciona. Mas é uma bomba relógio.

**Exemplo prático:**  
A classe `Email` funciona em `ArrayList` hoje. Amanhã, um novo desenvolvedor cria um cache de e-mails usando `HashSet<Email>` para evitar duplicatas em um envio de newsletter. Como `hashCode()` não foi sobrescrito, e-mails duplicados são inseridos no `HashSet`, e a newsletter é enviada duas vezes para o mesmo destinatário.

**Exemplo de código:**  
```java
import java.util.*;

// ❌ Classe problemática — equals sem hashCode
class EmailSemHashCode {
    private String endereco;
    
    public EmailSemHashCode(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailSemHashCode)) return false;
        EmailSemHashCode email = (EmailSemHashCode) o;
        return endereco.equals(email.endereco);
    }
    // hashCode() NÃO sobrescrito — usa o de Object (endereço de memória)
}

// Demonstração do problema
public class DemonstracaoProblema {
    public void testar() {
        EmailSemHashCode e1 = new EmailSemHashCode("teste@email.com");
        EmailSemHashCode e2 = new EmailSemHashCode("teste@email.com");
        
        // ArrayList — funciona (usa apenas equals)
        List<EmailSemHashCode> lista = new ArrayList<>();
        lista.add(e1);
        System.out.println(lista.contains(e2)); // true ✅
        
        // HashSet — FALHA (usa hashCode + equals)
        Set<EmailSemHashCode> set = new HashSet<>();
        set.add(e1);
        System.out.println(set.contains(e2)); // false ❌ — buckets diferentes!
        System.out.println(set.size()); // Se adicionar e2: size = 2 (duplicata!)
    }
}

// ✅ Classe correta — equals e hashCode consistentes
class Email {
    private String endereco;
    
    public Email(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return endereco.equals(email.endereco);
    }
    
    @Override
    public int hashCode() {
        return endereco.hashCode(); // Mesmo campo usado em equals
    }
}

// Agora funciona em qualquer coleção
Set<Email> setCorreto = new HashSet<>();
setCorreto.add(new Email("teste@email.com"));
setCorreto.add(new Email("teste@email.com")); // Igual ao anterior
System.out.println(setCorreto.size()); // 1 ✅ — detectou duplicata
```

**Como o candidato deve responder:**  
- Confirmar que o desenvolvedor está correto para `ArrayList`, mas incorreto como prática geral.
- Explicar o contrato: `equals` true → `hashCode` igual é obrigatório.
- Mostrar que estruturas baseadas em hash (`HashSet`, `HashMap`) quebram sem `hashCode`.
- Mencionar que é uma "bomba relógio" — funciona hoje, quebra amanhã.
- Trazer o exemplo do cache de e-mails com `HashSet`.
- Recomendar sempre sobrescrever ambos juntos.
- Evitar dizer que "hashCode é opcional" — é opcional só no sentido de compilação, não de correção.

**Resposta fraca ou incompleta:**  
"Está errado, precisa sobrescrever `hashCode`." — Não explica quando é um problema e quando não é. Não menciona que `ArrayList` funciona, nem o contrato entre `equals` e `hashCode`.

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
1. O que acontece se você sobrescrever `hashCode()` mas não `equals()`?
2. É correto usar `endereco.hashCode()` diretamente, ou deveria usar `Objects.hash(endereco)`?
3. Por que o `hashCode` de dois objetos iguais deve ser igual, mas dois objetos diferentes podem ter o mesmo `hashCode` (colisão)?

