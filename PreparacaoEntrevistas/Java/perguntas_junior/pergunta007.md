# Pergunta 7 — Herança vs Composição

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Você está modelando um sistema de funcionários. Inicialmente, criou uma classe `Funcionario` com atributos como `nome`, `salario` e métodos como `calcularBonus()`. Agora precisa adicionar `Gerente`, `Desenvolvedor` e `Estagiario`. Um colega sugere que todos herdem de `Funcionario`. Você concorda? Existe alguma situação em que composição seria uma alternativa melhor?

**O que essa pergunta avalia:**  
Compreensão de herança e seus limites, conhecimento do princípio "favorecer composição sobre herança", e capacidade de identificar quando a herança cria acoplamento excessivo ou hierarquias rígidas.

**Resposta esperada:**  
A herança faz sentido neste caso, pois `Gerente`, `Desenvolvedor` e `Estagiario` são tipos de `Funcionario` — existe uma relação "é-um" (is-a). Todos compartilham atributos como `nome` e `salario`, e o polimorfismo permite tratar todos como `Funcionario` quando necessário. Cada subclasse pode sobrescrever `calcularBonus()` com regras específicas.

No entanto, a composição deve ser preferida quando:
- Não existe uma relação "é-um", mas sim "tem-um" (has-a).
- A hierarquia ficaria muito profunda e rígida.
- Comportamentos precisam ser reutilizados entre classes que não compartilham hierarquia.
- Há necessidade de trocar comportamentos em tempo de execução.

Um exemplo onde composição seria melhor: se diferentes funcionários têm diferentes formas de pagamento (PIX, boleto, depósito), em vez de criar `FuncionarioPIX`, `FuncionarioBoleto`, é melhor ter uma interface `FormaPagamento` e injetá-la como composição.

**Explicação didática:**  
Pense na herança como uma árvore genealógica — um `Gerente` **é** um `Funcionario`, assim como um filho é uma pessoa. Já a composição é como montar um computador: você não herda de uma placa de vídeo ou um disco rígido, você os **tem** como componentes. Se a placa queima, você troca sem mudar o computador inteiro. A herança é permanente e rígida; a composição é flexível e intercambiável.

**Exemplo prático:**  
Em um sistema de RH, `Gerente` herda de `Funcionario` (herança apropriada). Mas se `Gerente` também precisa enviar notificações, em vez de herdar de uma classe `Notificador`, é melhor ter um objeto `Notificador` como atributo de `Gerente` (composição), pois amanhã pode ser necessário trocar o notificador (e-mail para Slack) sem alterar a hierarquia de classes.

**Exemplo de código:**  
```java
// HERANÇA — relação "é-um" faz sentido
public abstract class Funcionario {
    private String nome;
    private double salario;
    
    public abstract double calcularBonus();
    
    public String getNome() { return nome; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}

public class Gerente extends Funcionario {
    @Override
    public double calcularBonus() {
        return getSalario() * 0.20; // 20% para gerentes
    }
}

public class Desenvolvedor extends Funcionario {
    @Override
    public double calcularBonus() {
        return getSalario() * 0.10; // 10% para devs
    }
}

// COMPOSIÇÃO — comportamento reutilizável e intercambiável
public interface FormaPagamento {
    void pagar(Funcionario funcionario);
}

public class PagamentoPIX implements FormaPagamento {
    @Override
    public void pagar(Funcionario funcionario) {
        System.out.println("Pagando via PIX para " + funcionario.getNome());
    }
}

public class PagamentoBoleto implements FormaPagamento {
    @Override
    public void pagar(Funcionario funcionario) {
        System.out.println("Gerando boleto para " + funcionario.getNome());
    }
}

// Folha de pagamento usa composição — pode trocar a forma de pagamento
public class FolhaPagamento {
    private FormaPagamento formaPagamento; // Composição
    
    public FolhaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public void processarPagamento(Funcionario funcionario) {
        double total = funcionario.getSalario() + funcionario.calcularBonus();
        formaPagamento.pagar(funcionario);
    }
}
```

**Como o candidato deve responder:**  
- Concordar que a herança faz sentido para este caso (relação é-um).
- Explicar o conceito "favorecer composição sobre herança".
- Dar um exemplo de quando composição seria melhor (relação tem-um).
- Mencionar que herança cria acoplamento forte entre classes.
- Trazer um exemplo prático onde a troca de comportamento justifica composição.
- Evitar dizer que "herança é sempre errada" ou "sempre use composição".

**Resposta fraca ou incompleta:**  
"Sim, devem herdar de `Funcionario`." — Correto, mas não explica os critérios para a escolha, não menciona composição como alternativa, nem identifica quando a herança se torna problemática.

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
1. O que é acoplamento e por que herança excessiva é prejudicial?
2. Como o princípio de substituição de Liskov (LSP) se aplica a este cenário?
3. Se amanhã surgir um `EstagiarioRemoto` que também é um `Estudante`, como você modelaria sem herança múltipla?
