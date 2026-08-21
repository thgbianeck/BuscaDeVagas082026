# Pergunta 5 — Encapsulamento e Modificadores de Acesso

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Você está revisando o código de um colega e encontra uma classe `ContaBancaria` onde todos os atributos estão como `public`: `public double saldo;`. Em um cenário real de uma aplicação bancária, quais problemas isso pode causar e como você orientaria seu colega a corrigir?

**O que essa pergunta avalia:**  
Compreensão do princípio de encapsulamento, conhecimento dos modificadores de acesso (`public`, `private`, `protected`, default), e capacidade de identificar problemas de design orientado a objetos.

**Resposta esperada:**  
Com `saldo` como `public`, qualquer classe pode modificar o valor diretamente, sem validação. Isso permite operações como `conta.saldo = -1000;` ou `conta.saldo = 0;` sem passar por regras de negócio. Em uma aplicação bancária, isso representa uma falha crítica de integridade de dados.

A correção envolve:
1. Tornar o atributo `private`.
2. Expor acesso controlado via getters e setters.
3. Implementar validações nos setters ou em métodos de negócio como `depositar()` e `sacar()`.
4. Garantir que o saldo só seja alterado através de operações válidas.

**Explicação didática:**  
Imagine que o saldo da conta é o cofre de um banco. Se o cofre estiver na rua (`public`), qualquer pessoa pode abrir e mexer no dinheiro. Se estiver dentro do banco com uma porta restrita (`private`), só é possível acessar através do caixa (`getSaldo()`) ou realizar operações pelos procedimentos corretos (`depositar()`, `sacar()`), que verificam regras como saldo suficiente e valores positivos.

**Exemplo prático:**  
Sem encapsulamento, um desenvolvedor desavisado poderia fazer `conta.saldo = 1000000;` em qualquer parte do sistema, criando dinheiro do nada. Com encapsulamento, toda alteração de saldo passa por métodos que aplicam regras de auditoria, log e validação.

**Exemplo de código:**  
```java
public class ContaBancaria {
    private double saldo;       // Acesso restrito
    private String titular;
    
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    // Leitura controlada
    public double getSaldo() {
        return saldo;
    }
    
    // Escrita controlada — apenas por operações de negócio
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo");
        }
        this.saldo += valor;
        // Aqui poderiam ser registrados logs, auditoria, etc.
    }
    
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        this.saldo -= valor;
    }
}
```

**Como o candidato deve responder:**  
- Explicar o conceito de encapsulamento: proteger dados internos da classe.
- Identificar os riscos de `public`: acesso irrestrito, sem validação.
- Propor a solução: `private` + getters/setters com validação ou métodos de negócio.
- Mencionar que nem todo atributo precisa de setter — alguns devem ser apenas leitura.
- Trazer o exemplo do saldo bancário como caso crítico.
- Evitar dizer apenas "use private" sem explicar o porquê.

**Resposta fraca ou incompleta:**  
"Deveria usar `private` em vez de `public`." — Correto, mas não explica o porquê nem menciona validações, métodos de negócio, ou os riscos de dados inconsistentes.

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
1. Um atributo `protected` é acessível por quais classes?
2. Em que situação faria sentido usar o modificador default (package-private)?
3. Como o encapsulamento facilita a manutenção e evolução do código a longo prazo?
