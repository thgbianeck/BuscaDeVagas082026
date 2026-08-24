# Pergunta 16 — Static vs Instance

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você está desenvolvendo uma classe `ValidadorCPF` que tem um método `validar(String cpf)`. O método não usa nenhum atributo de instância — apenas recebe o CPF como parâmetro e retorna `true` ou `false`. Um colega sugere tornar o método `static`. Outro diz para manter como método de instância para poder mockar em testes. Qual sua opinião e quais são os trade-offs?

**O que essa pergunta avalia:**  
Compreensão da diferença entre métodos estáticos e de instância, conhecimento de quando usar cada um, e capacidade de avaliar trade-offs entre simplicidade e testabilidade.

**Resposta esperada:**  
Ambas as abordagens têm méritos:

**A favor de `static`:**
- O método não depende de estado de instância — é uma operação pura.
- Mais simples de chamar: `ValidadorCPF.validar(cpf)` sem precisar instanciar.
- Mais eficiente: sem overhead de criação de objeto.
- Faz sentido conceitualmente: a validação de CPF é uma operação que não pertence a uma "instância" — é uma regra universal.

**A favor de instância:**
- Facilita mockar em testes unitários (embora bibliotecas como Mockito possam mockar métodos estáticos com versões mais recentes).
- Permite injeção de dependência — se amanhã a validação precisar de um serviço externo, a instância permite injetar dependências.
- Mais flexível para herança e polimorfismo.

A recomendação depende do contexto:
- Se é uma validação pura e sem dependências externas: **`static` é apropriado**.
- Se há possibilidade de a lógica variar (ex: diferentes regras de validação por região) ou precisar de dependências: **instância é melhor**.

**Explicação didática:**  
Pense em métodos estáticos como ferramentas em uma caixa de ferramentas compartilhada — uma chave de fenda funciona igual para qualquer pessoa que a pegue, não precisa ser "sua". Já métodos de instância são como uma cafeteira pessoal — cada pessoa pode ter a sua, configurada do seu jeito (com café diferente, temperatura diferente). Se a validação de CPF é sempre a mesma regra para todos, é uma chave de felta (static). Se amanhã pode variar, é uma cafeteira (instância).

**Exemplo prático:**  
Em um sistema de cadastro de clientes, o `ValidadorCPF` é usado em múltiplos pontos (controller, service, DTO). Se for `static`, basta chamar `ValidadorCPF.validar(cpf)` em qualquer lugar. Se for instância, precisa passar a instância por injeção de dependência, o que adiciona complexidade sem benefício claro se a lógica é fixa.

**Exemplo de código:**  
```java
// Abordagem static — simples e direta para lógica pura
public class ValidadorCPF {
    
    public static boolean validar(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        // Lógica de validação (simplificada)
        return cpf.chars().allMatch(Character::isDigit);
    }
}

// Uso:
if (ValidadorCPF.validar("12345678901")) {
    System.out.println("CPF válido");
}

// Abordagem instância — flexível para testes e variação
public interface ValidadorDocumento {
    boolean validar(String documento);
}

public class ValidadorCPFImp implements ValidadorDocumento {
    @Override
    public boolean validar(String documento) {
        if (documento == null || documento.length() != 11) {
            return false;
        }
        return documento.chars().allMatch(Character::isDigit);
    }
}

// Em testes — fácil de mockar
// mock(ValidadorDocumento.class) → sempre retorna true para testes

// Em produção — injetar a implementação real
public class CadastroService {
    private final ValidadorDocumento validador;
    
    // Injeção por construtor
    public CadastroService(ValidadorDocumento validador) {
        this.validador = validador;
    }
    
    public void cadastrar(String cpf) {
        if (!validador.validar(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        // Continua cadastro
    }
}
```

**Como o candidato deve responder:**  
- Explicar que `static` é apropriado para operações puras sem estado.
- Mencionar que instância facilita testes (mock) e injeção de dependência.
- Apresentar os trade-offs: simplicidade vs flexibilidade.
- Recomendar `static` se a lógica for fixa e sem dependências externas.
- Recomendar instância (ou interface) se houver possibilidade de variação ou necessidade de mock.
- Evitar dizer que `static` é sempre errado ou sempre certo.

**Resposta fraca ou incompleta:**  
"Usaria `static` porque é mais fácil." — Não reconhece o trade-off de testabilidade, nem menciona o cenário em que instância seria melhor.

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
1. Por que métodos `static` não podem ser sobrescritos (overriding) — apenas ocultados (hiding)?
2. Como testar código que usa métodos `static` sem refactor?
3. O que é o padrão Singleton e como ele se relaciona com membros estáticos?

