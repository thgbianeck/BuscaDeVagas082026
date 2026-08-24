# Pergunta 18 — Construtores e Inicialização

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você está criando uma classe `Usuario` com os atributos `nome`, `email` e `dataCadastro`. O `dataCadastro` deve sempre ser definido como a data atual no momento da criação. Um desenvolvedor sugere receber `dataCadastro` no construtor para flexibilidade. Outro sugere definir internamente no construtor. Qual abordagem você adotaria e por quê? Como lidar com a validação de `nome` e `email` obrigatórios?

**O que essa pergunta avalia:**  
Compreensão de construtores, inicialização de objetos, validação no momento de criação, e capacidade de tomar decisões de design baseadas em invariantes de classe.

**Resposta esperada:**  
A decisão depende do invariante da classe:
- Se `dataCadastro` deve **sempre** ser a data de criação (regra de negócio), ela deve ser definida **internamente** no construtor, sem expô-la como parâmetro. Isso garante que nenhum código externo possa definir uma data incorreta.
- Se houver necessidade de testes ou importação de dados legados (onde a data pode ser diferente), uma alternativa é ter um construtor privado com todos os parâmetros e um factory method público que define a data atual.

Para `nome` e `email` obrigatórios:
- Receber no construtor e validar imediatamente (fail-fast).
- Se inválidos, lançar exceção (`IllegalArgumentException` ou customizada).
- Não permitir criação de objetos em estado inválido.

**Explicação didática:**  
Pense na classe `Usuario` como um formulário de cadastro impresso. A data de preenchimento é carimbada automaticamente pela máquina — você não pede para o usuário escrever a data (risco de erro ou fraude). Já o nome e e-mail são campos que o usuário preenche, mas a máquina verifica se não estão em branco antes de aceitar o formulário. Se estiverem em branco, o formulário é rejeitado na hora (fail-fast).

**Exemplo prático:**  
Em um sistema de cadastro de usuários, um desenvolvedor acidentalmente passa `null` para o nome, criando um usuário sem nome. Sem validação no construtor, o problema só é descoberto quando o sistema tenta exibir o nome, causando `NullPointerException` em outro lugar do código. Com validação no construtor, o erro é detectado imediatamente na origem.

**Exemplo de código:**  
```java
import java.time.LocalDateTime;
import java.util.Objects;

public class Usuario {
    private final String nome;        // final — imutável após construção
    private final String email;       // final — imutável após construção
    private final LocalDateTime dataCadastro;
    
    // Construtor público — data definida internamente
    public Usuario(String nome, String email) {
        // Validação fail-fast — não permite estado inválido
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        
        this.nome = nome.trim();
        this.email = email.toLowerCase();
        this.dataCadastro = LocalDateTime.now(); // Definido internamente
    }
    
    // Construtor privado para testes/importação de dados legados
    private Usuario(String nome, String email, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }
    
    // Factory method para importação com data específica
    public static Usuario deImportacao(String nome, String email, 
                                        LocalDateTime dataCadastro) {
        // Mesmas validações + validação da data
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (dataCadastro == null) {
            throw new IllegalArgumentException("Data de cadastro é obrigatória");
        }
        return new Usuario(nome, email, dataCadastro);
    }
    
    // Getters — sem setters (imutável)
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }
}

// Uso normal
Usuario u1 = new Usuario("João", "JOAO@email.com");
// nome = "João", email = "joao@email.com", data = agora

// Tentativa de criar usuário inválido — falha imediatamente
// Usuario u2 = new Usuario("", "email"); 
// → IllegalArgumentException: Nome é obrigatório

// Importação de dados legados
Usuario u3 = Usuario.deImportacao("Maria", "maria@test.com", 
    LocalDateTime.of(2020, 1, 15, 10, 0));
```

**Como o candidato deve responder:**  
- Explicar que `dataCadastro` deve ser definido internamente se for um invariante (sempre = data atual).
- Mencionar que validar no construtor evita objetos em estado inválido (fail-fast).
- Propor construtor privado + factory method para flexibilidade (testes, importação).
- Defender imutabilidade quando possível (atributos `final`).
- Trazer exemplo prático.
- Evitar permitir `null` ou valores inválidos sem validação.

**Resposta fraca ou incompleta:**  
"Receber tudo no construtor." — Não distingue entre o que deve ser controlado externamente (nome, email) e internamente (dataCadastro). Não menciona validação.

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
1. O que é o padrão Factory Method e quando ele é preferível a um construtor público?
2. Por que tornar atributos `final` é uma boa prática? O que isso garante?
3. Se você precisasse validar o email com uma regex, colocaria essa validação no construtor ou em um validator separado? Por quê?

