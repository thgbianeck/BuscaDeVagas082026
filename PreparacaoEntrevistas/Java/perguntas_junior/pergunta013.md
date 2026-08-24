# Pergunta 13 — Try-with-resources e Fechamento de Recursos

**Nível:** Júnior  
**Categoria:** Tratamento de Exceções

**Pergunta do entrevistador:**  
Em um sistema de log, você tem um método que abre um arquivo, escreve uma mensagem e precisa garantir que o arquivo seja fechado mesmo se ocorrer um erro durante a escrita. Um colega implementou com `try-catch-finally` manual, fechando o arquivo no `finally`. Existe uma forma mais segura e concisa de fazer isso? O que muda?

**O que essa pergunta avalia:**  
Conhecimento do try-with-resources (Java 7+), compreensão da interface `AutoCloseable`, e capacidade de identificar code smells relacionados ao gerenciamento manual de recursos.

**Resposta esperada:**  
O try-with-resources é a forma mais segura e concisa. Ele fecha automaticamente os recursos declarados no bloco `try`, mesmo se ocorrer uma exceção. O recurso deve implementar a interface `AutoCloseable` (ou `Closeable`).

Vantagens sobre o `try-catch-finally` manual:
1. **Menos código:** não precisa do bloco `finally` nem de chamadas explícitas a `close()`.
2. **Menos erros:** esquecer de fechar no `finally` é um erro comum.
3. **Suppressed exceptions:** se ocorrer exceção no `try` e no `close()`, ambas são preservadas — a do `try` é a principal e a do `close()` fica como "suppressed".
4. **Múltiplos recursos:** podem ser declarados na mesma instrução, sendo fechados na ordem inversa de declaração.

**Explicação didática:**  
Imagine que você entra em um quarto de hotel (abre o arquivo). Com `try-catch-finally` manual, você precisa lembrar de trancar a porta ao sair (close()), mesmo se algo der errado dentro do quarto. Se você esquecer, qualquer um pode entrar (vazamento de recurso). Com try-with-resources, é como ter uma porta que tranca sozinha quando você sai — você não precisa se preocupar, ela sempre tranca, não importa o que aconteça.

**Exemplo prático:**  
Um sistema de auditoria que escreve logs em arquivo. Se a escrita falhar (ex: disco cheio), o arquivo ainda precisa ser fechado para não corromper o sistema de arquivos. Com `finally` manual, um `close()` esquecido ou uma exceção aninhada pode deixar o arquivo aberto.

**Exemplo de código:**  
```java
import java.io.FileWriter;
import java.io.IOException;

// ❌ Abordagem manual — propensa a erros
public void escreverLogManual(String mensagem) {
    FileWriter writer = null;
    try {
        writer = new FileWriter("log.txt", true);
        writer.write(mensagem + "\n");
    } catch (IOException e) {
        System.err.println("Erro ao escrever: " + e.getMessage());
    } finally {
        // Se writer for null (erro na criação), close() lança NPE
        if (writer != null) {
            try {
                writer.close(); // Pode lançar IOException, esquecido frequentemente
            } catch (IOException e) {
                System.err.println("Erro ao fechar: " + e.getMessage());
            }
        }
    }
}

// ✅ Try-with-resources — seguro e conciso
public void escreverLogAutomatico(String mensagem) {
    // O recurso é declarado entre parênteses — fechado automaticamente
    try (FileWriter writer = new FileWriter("log.txt", true)) {
        writer.write(mensagem + "\n");
    } catch (IOException e) {
        System.err.println("Erro: " + e.getMessage());
        // writer já foi fechado automaticamente neste ponto
    }
}

// ✅ Múltiplos recursos — fechados na ordem inversa
public void copiarArquivo(String origem, String destino) {
    try (FileReader reader = new FileReader(origem);
         FileWriter writer = new FileWriter(destino)) {
        // reader é aberto primeiro, writer segundo
        // writer é fechado primeiro, reader segundo (ordem inversa)
        int caractere;
        while ((caractere = reader.read()) != -1) {
            writer.write(caractere);
        }
    } catch (IOException e) {
        System.err.println("Erro na cópia: " + e.getMessage());
    }
}
```

**Como o candidato deve responder:**  
- Identificar o try-with-resources como a solução recomendada.
- Explicar que o recurso precisa implementar `AutoCloseable`.
- Mencionar vantagens: menos código, menos erros, suppressed exceptions.
- Mostrar que múltiplos recursos podem ser declarados juntos.
- Trazer exemplo comparando as duas abordagens.
- Evitar dizer que `finally` é errado — às vezes é necessário, mas para fechar recursos, try-with-resources é superior.

**Resposta fraca ou incompleta:**  
"Usaria `finally` para fechar o arquivo." — É funcional, mas não reconhece o try-with-resources como alternativa superior e mais segura. Não menciona os riscos do gerenciamento manual.

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
1. O que são "suppressed exceptions" e como acessá-las?
2. Qual a diferença entre `AutoCloseable` e `Closeable`?
3. Se você criasse uma classe que gerencia uma conexão de banco de dados, como ela implementaria `AutoCloseable`?

