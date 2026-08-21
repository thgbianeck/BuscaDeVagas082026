# Pergunta 11 — Interfaces e Classes Abstratas

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Você está modelando um sistema de pagamentos que precisa suportar múltiplas formas de pagamento: cartão de crédito, PIX e boleto. Todas as formas precisam ter um método `pagar()` e `estornar()`, mas apenas o cartão e o PIX precisam de um método `gerarComprovante()`. O boleto não gera comprovante imediato. Como você estruturaria essa hierarquia usando interfaces e/ou classes abstratas?

**O que essa pergunta avalia:**  
Compreensão da diferença entre interfaces e classes abstratas, capacidade de modelar contratos comuns e opcionais, e conhecimento de default Methods (Java 8+) como alternativa para comportamento opcional.

**Resposta esperada:**  
Existem duas abordagens principais:

**Abordagem 1 — Interface + interface opcional:**  
Criar uma interface `FormaPagamento` com os métodos comuns `pagar()` e `estornar()`. Criar uma segunda interface `Comprovante` com o método `gerarComprovante()`. Classes que suportam comprovante implementam ambas; `Boleto` implementa apenas `FormaPagamento`.

**Abordagem 2 — Interface com Default Method:**  
Criar a interface `FormaPagamento` com `pagar()` e `estornar()` como métodos abstratos, e `gerarComprovante()` como um default method que retorna `null` ou lança `UnsupportedOperationException`. Classes que suportam comprovante sobrescrevem o default method.

A escolha depende do design. A Abordagem 1 é mais limpa do ponto de vista de responsabilidade (Single Responsibility Principle), pois não força `Boleto` a implementar um método que não faz sentido para ele. A Abordagem 2 é mais simples, mas pode violar o LSP se o método lançar exceção.

**Explicação didática:**  
Pense em interfaces como contratos de TV. Uma interface `FormaPagamento` é o contrato básico de qualquer TV: ligar e desligar (`pagar()` e `estornar()`). Já a interface `Comprovante` é como um contrato adicional de Smart TV — nem toda TV precisa ter. Uma TV de tubo (boleto) só implementa o contrato básico. Uma Smart TV (cartão, PIX) implementa ambos. Default Methods seriam como colocar um botão "Smart" em todas as TVs, mas que nas TVs de tubo não faz nada — funciona, mas é confuso para o usuário.

**Exemplo prático:**  
Um sistema de e-commerce onde o cliente escolhe a forma de pagamento no checkout. O sistema precisa processar o pagamento e, se aplicável, gerar um comprovante PDF para download.

**Exemplo de código:**  
```java
// Abordagem 1 — Interfaces separadas (recomendada)

// Contrato comum a todas as formas de pagamento
public interface FormaPagamento {
    boolean pagar(double valor);
    boolean estornar(double valor);
}

// Contrato opcional — apenas para formas que geram comprovante
public interface Comprovante {
    String gerarComprovante();
}

// Cartão implementa ambos os contratos
public class CartaoCredito implements FormaPagamento, Comprovante {
    @Override
    public boolean pagar(double valor) {
        System.out.println("Processando cartão: R$ " + valor);
        return true;
    }
    
    @Override
    public boolean estornar(double valor) {
        System.out.println("Estornando cartão: R$ " + valor);
        return true;
    }
    
    @Override
    public String gerarComprovante() {
        return "COMPROVANTE CARTÃO - " + System.currentTimeMillis();
    }
}

// PIX implementa ambos
public class PIX implements FormaPagamento, Comprovante {
    @Override
    public boolean pagar(double valor) {
        System.out.println("Transferindo PIX: R$ " + valor);
        return true;
    }
    
    @Override
    public boolean estornar(double valor) {
        System.out.println("Devolvendo PIX: R$ " + valor);
        return true;
    }
    
    @Override
    public String gerarComprovante() {
        return "COMPROVANTE PIX - " + System.currentTimeMillis();
    }
}

// Boleto implementa apenas FormaPagamento — sem comprovante imediato
public class Boleto implements FormaPagamento {
    @Override
    public boolean pagar(double valor) {
        System.out.println("Registrando boleto: R$ " + valor);
        return true;
    }
    
    @Override
    public boolean estornar(double valor) {
        System.out.println("Solicitando devolução de boleto: R$ " + valor);
        return true;
    }
    // Não implementa gerarComprovante() — não faz sentido para boleto
}

// Uso polimórfico
public class ProcessadorPagamento {
    public void processar(FormaPagamento forma, double valor) {
        if (forma.pagar(valor)) {
            // Verifica se a forma gera comprovante
            if (forma instanceof Comprovante) {
                Comprovante c = (Comprovante) forma;
                System.out.println("Comprovante: " + c.gerarComprovante());
            } else {
                System.out.println("Pagamento registrado. Comprovante será enviado por e-mail.");
            }
        }
    }
}
```

**Como o candidato deve responder:**  
- Explicar que interfaces definem contratos e classes abstratas fornecem implementação parcial.
- Propor separar comportamentos comuns (`pagar`, `estornar`) de opcionais (`gerarComprovante`).
- Mencionar Default Methods como alternativa, mas identificar o trade-off (pode violar ISP/LSP).
- Mostrar que `instanceof` pode ser usado para verificar suporte opcional, embora não seja a solução mais elegante.
- Evitar forçar todas as classes a implementar todos os métodos.

**Resposta fraca ou incompleta:**  
"Criaria uma classe abstrata com todos os métodos e o boleto deixaria `gerarComprovante()` vazio." — Força uma classe a ter um método que não faz sentido para ela, viola o ISP e polui o código com implementações vazias.

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
1. Quando faria mais sentido usar uma classe abstrata em vez de uma interface?
2. O que é o Interface Segregation Principle (ISP) e como ele se aplica a este cenário?
3. Como os Default Methods (Java 8) mudaram a forma como usamos interfaces?