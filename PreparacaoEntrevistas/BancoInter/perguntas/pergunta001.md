# Pergunta 1 — Princípios fundamentais da orientação a objetos

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Quais são os principais princípios da orientação a objetos e como eles ajudam na construção de aplicações Java?

**O que essa pergunta avalia:**  
Avalia se o candidato compreende os fundamentos usados para organizar responsabilidades, reduzir acoplamento e facilitar a manutenção do código.

**Resposta esperada:**  
Os principais princípios são:

- **Encapsulamento:** protege o estado interno de um objeto e controla como ele pode ser alterado;
- **Abstração:** expõe apenas os detalhes relevantes para o uso de uma funcionalidade;
- **Herança:** permite reutilizar características de uma classe em outra, embora deva ser utilizada com cuidado;
- **Polimorfismo:** permite tratar objetos diferentes por meio de uma abstração comum.

Na prática, esses princípios ajudam a separar responsabilidades e reduzir dependências diretas entre componentes.

Em Java, interfaces e composição são frequentemente preferíveis à herança quando se deseja flexibilidade.

**Explicação didática:**  
Uma classe não deve expor livremente todos os seus dados internos. Ela deve proteger seu estado e oferecer operações coerentes.

Por exemplo, uma conta bancária não deveria permitir que qualquer parte do sistema alterasse diretamente seu saldo. O método de saque poderia validar o valor e impedir operações inválidas.

A composição ocorre quando uma classe utiliza outra como dependência, em vez de herdar seu comportamento. Isso tende a facilitar mudanças futuras.

**Exemplo prático:**

~~~java
public class Conta {

    private BigDecimal saldo = BigDecimal.ZERO;

    public void depositar(BigDecimal valor) {
        if (valor == null || valor.signum() <= 0) {
            throw new IllegalArgumentException("O valor deve ser positivo");
        }

        saldo = saldo.add(valor);
    }

    public BigDecimal consultarSaldo() {
        return saldo;
    }
}
~~~

O campo `saldo` está encapsulado. Alterações ocorrem por meio de uma operação que valida a regra básica.

**Como o candidato deve responder:**

- Explique os quatro princípios com suas próprias palavras;
- Relacione-os à manutenção e à organização do código;
- Apresente um exemplo simples;
- Diferencie herança de composição;
- Evite apenas decorar definições.

**Resposta fraca ou incompleta:**  
“Orientação a objetos usa classes, objetos e herança.”

Essa resposta cita apenas parte do assunto e não explica como os princípios influenciam o design.

**Critérios de avaliação:**

- **0** — Não sabe explicar orientação a objetos.
- **1** — Apresenta definições incorretas ou muito superficiais.
- **2** — Conhece alguns conceitos, mas não os relaciona ao código.
- **3** — Explica corretamente os princípios fundamentais.
- **4** — Apresenta exemplos e relaciona os conceitos à manutenibilidade.
- **5** — Discute coesão, acoplamento, composição, limites da herança e aplicação prática dos princípios.

**Perguntas de aprofundamento:**

1. Quando a composição seria melhor que a herança?
2. Como o encapsulamento reduz erros no sistema?
3. É possível aplicar polimorfismo sem utilizar herança de classes?

