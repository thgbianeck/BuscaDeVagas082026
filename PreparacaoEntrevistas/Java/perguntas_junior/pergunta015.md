# Pergunta 15 — Casting de Tipos e ClassCastException

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Em um sistema deRH, você tem uma `List<Funcionario>` que contém objetos `Gerente`, `Desenvolvedor` e `Estagiario`. Você itera pela lista e, para cada funcionário, tenta fazer um cast para `Gerente` para acessar o método `getEquipe()`. Em produção, você recebe um `ClassCastException`. O que está errado e como você corrigiria essa abordagem?

**O que essa pergunta avalia:**  
Compreensão de casting em Java, identificação de quando o cast é seguro ou não, conhecimento de `instanceof`, e capacidade de propor design alternativo que evite casts inseguros.

**Resposta esperada:**  
O erro é que nem todo `Funcionario` é um `Gerente`. Fazer cast direto `(Gerente) funcionario` quando o objeto é na verdade um `Desenvolvedor` ou `Estagiario` dispara `ClassCastException` em runtime.

Soluções:

**1. Usar `instanceof` antes do cast:**  
```java
if (funcionario instanceof Gerente) {
    Gerente gerente = (Gerente) funcionario;
    gerente.getEquipe();
}
```

**2. Pattern matching (Java 16+):**  
```java
if (funcionario instanceof Gerente gerente) {
    gerente.getEquipe();
}
```

**3. Repensar o design (melhor abordagem):**  
Se o comportamento de "ter equipe" não é exclusivo de `Gerente`, criar uma interface `Lider` com método `getEquipe()` e fazer apenas as classes que lideram equipes implementá-la. Assim, o polimorfismo resolve o problema sem casts.

**Explicação didática:**  
Imagine que você tem uma caixa etiquetada "Funcionário" que pode conter diferentes brinquedos (gerente, dev, estagiário). Se você fechar os olhos e pegar um brinquedo assumindo que é sempre um gerente, às vezes vai pegar um estagiário e quebrar o brinquedo. O `instanceof` é como abrir os olhos e verificar o tipo antes de usar. O design alternativo é etiquetar as caixas corretamente desde o início — se você só precisa de quem tem equipe, não misture todos na mesma caixa.

**Exemplo prático:**  
Um sistema de relatório de RH precisa listar apenas os gerentes e suas equipes. Em vez de iterar sobre todos os funcionários e tentar cast, é melhor filtrar apenas os gerentes ou usar uma estrutura de dados separada.

**Exemplo de código:**  
```java
import java.util.List;

class Funcionario {
    private String nome;
    public String getNome() { return nome; }
}

class Gerente extends Funcionario {
    private List<String> equipe;
    public List<String> getEquipe() { return equipe; }
}

class Desenvolvedor extends Funcionario {
    private String linguagem;
}

// ❌ Cast inseguro — causa ClassCastException
public void listarEquipesErrado(List<Funcionario> funcionarios) {
    for (Funcionario f : funcionarios) {
        Gerente g = (Gerente) f; // CRASH se f for Desenvolvedor
        System.out.println(g.getEquipe());
    }
}

// ✅ Verificação com instanceof
public void listarEquipesSeguro(List<Funcionario> funcionarios) {
    for (Funcionario f : funcionarios) {
        if (f instanceof Gerente) {
            Gerente g = (Gerente) f;
            System.out.println(g.getNome() + " -> " + g.getEquipe());
        }
    }
}

// ✅ Design alternativo — interface evita casts
interface Lider {
    List<String> getEquipe();
}

class Gerente extends Funcionario implements Lider {
    private List<String> equipe;
    @Override
    public List<String> getEquipe() { return equipe; }
}

// Se um Diretor também lidera equipe, basta implementar Lider
class Diretor extends Funcionario implements Lider {
    private List<String> equipe;
    @Override
    public List<String> getEquipe() { return equipe; }
}

// Uso sem casts — polimorfismo resolve
public void listarEquipes(List<Funcionario> funcionarios) {
    for (Funcionario f : funcionarios) {
        if (f instanceof Lider) {
            Lider lider = (Lider) f;
            System.out.println(lider.getEquipe());
        }
    }
}
```

**Como o candidato deve responder:**  
- Identificar que nem todo funcionário é gerente, causando o `ClassCastException`.
- Propor `instanceof` antes do cast como correção imediata.
- Sugerir um design alternativo com interface para evitar casts (polimorfismo).
- Explicar que casts são um sinal de design que pode ser melhorado.
- Trazer o exemplo prático de RH.
- Evitar sugerir `try-catch` para capturar `ClassCastException` — isso mascara o problema de design.

**Resposta fraca ou incompleta:**  
"Colocar um try-catch em volta do cast." — Mascara o problema de design. Não usa `instanceof` nem sugere uma alternativa orientada a objetos. Tratar a exceção não resolve a causa.

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
1. Qual a diferença entre upcast (cast para superclasse) e downcast (cast para subclasse) em termos de segurança?
2. Por que casts frequentemente indicam problemas de design orientado a objetos?
3. Como o pattern matching do Java 16+ simplifica o uso de `instanceof`?

---
