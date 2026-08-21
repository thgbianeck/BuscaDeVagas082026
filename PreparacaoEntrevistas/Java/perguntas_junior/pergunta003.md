# Pergunta 3 — Null Pointer Exception em Produção

**Nível:** Júnior  
**Categoria:** Tratamento de Exceções

**Pergunta do entrevistador:**  
Em produção, um usuário relatou que o sistema exibiu uma tela de erro ao tentar visualizar os detalhes de um pedido. Você verificou os logs e encontrou um `NullPointerException`. O erro ocorre na linha `pedido.getCliente().getNome()`. Como você investigaria e resolveria esse problema?

**O que essa pergunta avalia:**  
Capacidade de diagnosticar um `NullPointerException`, identificar encadeamento de chamadas nulas, aplicar tratamentos defensivos e conhecer boas práticas como uso de `Optional`.

**Resposta esperada:**  
O `NullPointerException` provavelmente ocorre porque `pedido.getCliente()` retorna `null` — ou seja, o pedido não tem um cliente associado. A tentativa de chamar `.getNome()` em `null` dispara a exceção.

Para resolver, é necessário:
1. **Investigar a causa raiz:** verificar por que o cliente está `null` — pode ser um dado inconsistente no banco, uma consulta que não carregou a relação, ou um pedido ainda não finalizado.
2. **Tratamento defensivo imediato:** verificar se `getCliente()` retorna `null` antes de acessar `.getNome()`.
3. **Solução com `Optional` (Java 8+):** alterar `getCliente()` para retornar `Optional<Cliente>`, forçando quem chama o método a lidar com a possibilidade de ausência.
4. **Mensagem amigável:** exibir uma mensagem adequada ao usuário em vez de uma tela de erro.

**Explicação didática:**  
Pense no encadeamento `pedido.getCliente().getNome()` como abrir uma matriosca (boneca russa). Você abre a primeira boneca (pedido) e encontra outra dentro (cliente). Mas se a boneca "cliente" não estiver lá — ou seja, for `null` —, não há nada para abrir, e o programa quebra. O tratamento defensivo é como verificar se há uma boneca dentro antes de tentar abri-la.

**Exemplo prático:**  
Um sistema de e-commerce onde um pedido foi criado mas o cliente ainda não foi vinculado (ex: pedido via API de integração). Ao tentar mostrar o nome do cliente na tela, o sistema quebra.

**Exemplo de código:**  
```java
// ❌ Código problemático — sujeito a NPE
String nomeCliente = pedido.getCliente().getNome();

// ✅ Solução 1: Verificação tradicional
String nomeCliente = "Cliente não vinculado";
if (pedido.getCliente() != null) {
    nomeCliente = pedido.getCliente().getNome();
}

// ✅ Solução 2: Usando Optional (recomendado, Java 8+)
public class Pedido {
    private Cliente cliente;
    
    public Optional<Cliente> getCliente() {
        return Optional.ofNullable(cliente);
    }
}

// No chamador:
String nomeCliente = pedido.getCliente()
    .map(Cliente::getNome)
    .orElse("Cliente não vinculado");
```

**Como o candidato deve responder:**  
- Identificar que o NPE ocorre porque `getCliente()` provavelmente retorna `null`.
- Explicar o conceito de encadeamento de chamadas e onde o `null` pode estar.
- Propor tratamento defensivo (verificação com `if` ou uso de `Optional`).
- Mencionar a importância de investigar a causa raiz (por que o cliente é `null`?).
- Sugerir exibir uma mensagem amigável ao usuário.
- Evitar apenas sugerir `try-catch` sem investigar a causa.

**Resposta fraca ou incompleta:**  
"Colocar um try-catch em volta da linha." — Isso mascara o problema sem resolvê-lo. Não investiga a causa raiz, não propõe tratamento defensivo adequado, e o erro pode voltar em outras partes do código.

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
1. Qual a diferença entre tratar o sintoma (try-catch) e resolver a causa raiz?
2. Em quais outros pontos do sistema esse mesmo problema poderia ocorrer?
3. Como você garante que dados obrigatórios não cheguem nulos desde a entrada do sistema?