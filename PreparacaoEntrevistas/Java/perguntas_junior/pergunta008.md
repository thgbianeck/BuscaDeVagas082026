# Pergunta 8 — Checked vs Unchecked Exceptions

**Nível:** Júnior  
**Categoria:** Tratamento de Exceções

**Pergunta do entrevistador:**  
Você está desenvolvendo um método que lê um arquivo de configuração do sistema. O método pode encontrar situações como "arquivo não encontrado" ou "formato inválido". Um colega diz para usar `RuntimeException` para tudo, pois é mais simples. Outro diz para usar exceptions checked. Como você decidiria entre checked e unchecked exceptions nesse cenário?

**O que essa pergunta avalia:**  
Compreensão da diferença entre checked e unchecked exceptions, conhecimento de quando cada tipo é apropriado, e capacidade de tomar decisões de design baseadas em recuperação de erros.

**Resposta esperada:**  
A distinção principal é:
- **Checked exceptions** (`IOException`, `SQLException`): o compilador força o tratamento (try-catch ou declaração `throws`). Usadas quando o erro é recuperável e o chamador tem condições razoáveis de se recuperar.
- **Unchecked exceptions** (`RuntimeException` e subclasses como `NullPointerException`, `IllegalArgumentException`): o compilador não força o tratamento. Usadas para erros de programação (bugs) ou situações que geralmente não podem ser recuperadas em runtime.

Para o cenário de leitura de arquivo:
- "Arquivo não encontrado" é uma `FileNotFoundException` (checked) — faz sentido, pois o chamador pode tentar outro caminho, criar o arquivo, ou usar valores padrão.
- "Formato inválido" pode ser uma `IllegalConfigurationException` (unchecked, se for um erro de configuração do ambiente) ou checked, se for uma condição esperada que o chamador deve tratar.

Usar `RuntimeException` para tudo é uma má prática pois remove a obrigatoriedade de tratamento, fazendo com que erros recuperáveis passem despercebidos.

**Explicação didática:**  
Checked exceptions são como uma portaria que exige crachá: você é obrigado a mostrar que está lidando com a situação antes de entrar. Unchecked exceptions são como alarmes de incêndio: não dá para prever, não dá para "tratar no momento", e geralmente indicam que algo está errado que precisa ser corrigido no código, não tratado em runtime.

**Exemplo prático:**  
Um sistema que lê um arquivo `config.properties` na inicialização. Se o arquivo não existir, o sistema pode usar configurações padrão (recuperável — checked). Mas se o arquivo existir com um JSON malformado onde se esperava properties, isso é um erro de deployment que provavelmente deve abortar a inicialização (unchecked).

**Exemplo de código:**  
```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configurador {
    
    // Checked:FileNotFoundException — o chamador DEVE tratar
    public Properties carregarConfiguracoes(String caminho) 
            throws IOException {
        Properties props = new Properties();
        
        try (FileInputStream fis = new FileInputStream(caminho)) {
            props.load(fis);
        } catch (FileNotFoundException e) {
            // Arquivo não encontrado — pode ser recuperável
            // Relança como checked para o chamador decidir
            throw e;
        } catch (IOException e) {
            throw new IOException("Erro ao ler arquivo de configuração: " 
                + caminho, e);
        }
        
        // Validação — erro de programação/configuração (unchecked)
        String portaStr = props.getProperty("server.port");
        if (portaStr == null) {
            throw new IllegalArgumentException(
                "Propriedade obrigatória 'server.port' não encontrada em " + caminho
            );
        }
        
        return props;
    }
}

// No chamador — o compilador FORÇA o tratamento da checked exception
public class Aplicacao {
    public void iniciar() {
        Configurador config = new Configurador();
        try {
            Properties props = config.carregarConfiguracoes("/app/config.properties");
            System.out.println("Configurações carregadas com sucesso");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Usando configurações padrão.");
            // Pode usar defaults — recuperável
        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
            // Pode logar e tentar novamente, ou abortar
        }
    }
}
```

**Como o candidato deve responder:**  
- Explicar a diferença entre checked (compilador força tratamento) e unchecked (não força).
- Definir o critério: erros recuperáveis → checked; erros de programação → unchecked.
- Aplicar ao cenário: arquivo não encontrado → checked (recuperável); formato inválido → depende do contexto.
- Mencionar que usar `RuntimeException` para tudo é uma má prática.
- Trazer exemplo prático de código.
- Evitar dizer que "checked são melhores" ou "unchecked são melhores" sem contexto.

**Resposta fraca ou incompleta:**  
"Usaria try-catch para tratar tudo." — Não diferencia checked de unchecked, não justifica a escolha, e não explica o critério de recuperação.

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
1. Por que muitas bibliotecas modernas preferem unchecked exceptions?
2. O que é o padrão "fail fast" e como ele se relaciona com exceções?
3. Como você criaria uma exception customizada? Quais informações ela deveria conter?
