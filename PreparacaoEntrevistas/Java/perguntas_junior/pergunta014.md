
# Pergunta 14 — Sobrecarga (Overloading) vs Sobrescrita (Overriding)

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Você tem uma classe `Calculadora` com dois métodos: `somar(int a, int b)` e `somar(double a, double b)`. Em outra classe, você tem uma classe `CalculadoraCientifica extends Calculadora` que sobrescreve `somar(int a, int b)`. Um desenvolvedor chama `calc.somar(5, 3)` onde `calc` é do tipo `Calculadora` mas aponta para um objeto `CalculadoraCientifica`. Qual método é executado? E se ele chamar `calc.somar(5.0, 3.0)`? Explique a diferença entre sobrecarga e sobrescrita neste contexto.

**O que essa pergunta avalia:**  
Compreensão da diferença entre overloading (compile-time) e overriding (runtime), conhecimento de como o Java resolve qual método executar, e capacidade de raciocinar sobre polimorfismo e resolução de métodos.

**Resposta esperada:**  
- `calc.somar(5, 3)` executa o método **sobrescrito** em `CalculadoraCientifica`, pois os argumentos `5` e `3` são `int`, e o método `somar(int, int)` foi sobrescrito. A resolução acontece em runtime (dynamic dispatch), pois o tipo real do objeto é `CalculadoraCientifica`.
- `calc.somar(5.0, 3.0)` executa o método `somar(double, double)` da classe `Calculadora` (superclasse), pois `5.0` e `3.0` são `double`, e `CalculadoraCientifica` não sobrescreveu esse método. Se tivesse sobrescrito, executaria a versão da subclasse.

A diferença fundamental:
- **Sobrecarga (Overloading):** Mesmo nome de método, assinaturas diferentes (parâmetros). Resolvida em **compile-time** pelo compilador, baseado no tipo declarado dos argumentos.
- **Sobrescrita (Overriding):** Mesma assinatura (nome + parâmetros) na subclasse. Resolvida em **runtime** pela JVM, baseado no tipo real do objeto.

**Explicação didática:**  
A sobrecarga é como ter dois botões com o mesmo rótulo "somar" em painéis diferentes — um para números inteiros e outro para decimais. O compilador decide qual botão apertar baseado no tipo de número que você passa. A sobrescrita é como herdar uma calculadora que já tem o botão "somar", mas você reprograma o botão para fazer algo diferente — quando alguém aperta "somar", a versão reprogramada executa, não a original.

**Exemplo prático:**  
Em um sistema de cálculo de impostos, uma classe `CalculadoraImposto` tem `calcular(double valor)` e `calcular(double valor, double desconto)`. Uma subclasse `CalculadoraImpostoImportacao` sobrescreve `calcular(double valor)` para adicionar taxa de importação. A escolha de qual versão de `calcular` executar depende dos argumentos (sobrecarga) e do tipo real do objeto (sobrescrita).

**Exemplo de código:**  
```java
class Calculadora {
    // Sobrecarga — mesma assinatura de nome, parâmetros diferentes
    public int somar(int a, int b) {
        System.out.println("Calculadora.somar(int, int)");
        return a + b;
    }
    
    public double somar(double a, double b) {
        System.out.println("Calculadora.somar(double, double)");
        return a + b;
    }
}

class CalculadoraCientifica extends Calculadora {
    // Sobrescrita — mesma assinatura da superclasse
    @Override
    public int somar(int a, int b) {
        System.out.println("CalculadoraCientifica.somar(int, int)");
        return a + b + 1; // Comportamento diferente
    }
    // Nota: somar(double, double) NÃO foi sobrescrito
}

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new CalculadoraCientifica();
        
        calc.somar(5, 3);     // Saída: CalculadoraCientifica.somar(int, int)
                              // Sobrescrita — runtime decide pelo tipo real
        
        calc.somar(5.0, 3.0); // Saída: Calculadora.somar(double, double)
                              // Não houve sobrescrita — executa versão da superclasse
        
        // Detalhe: se passar int literais para a versão double,
        // o compilador converte (widening) para double
        calc.somar(5, 3);     // int — sobrescrito (CalculadoraCientifica)
        // Para forçar a versão double: cast ou literais 5.0
    }
}
```

**Como o candidato deve responder:**  
- Explicar que `somar(5, 3)` executa a versão sobrescrita em runtime.
- Explicar que `somar(5.0, 3.0)` executa a versão da superclasse (não foi sobrescrita).
- Diferenciar claramente: sobrecarga = compile-time (argumentos), sobrescrita = runtime (tipo do objeto).
- Mencionar que a anotação `@Override` ajuda a garantir que a sobrescrita está correta.
- Trazer o exemplo prático.
- Evitar confundir os dois conceitos ou dizer que ambos são a mesma coisa.

**Resposta fraca ou incompleta:**  
"Os dois executam o método da `CalculadoraCientifica`." — Incorreto para `somar(5.0, 3.0)`, pois a versão `double` não foi sobrescrita. Demonstra confusão entre sobrecarga e sobrescrita.

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
1. O que acontece se a subclasse tiver um método com o mesmo nome mas parâmetros diferentes — é sobrescrita ou sobrecarga?
2. Pode sobrescrever um método `static`? Por quê?
3. Qual o papel da anotação `@Override` e o que acontece se você usá-la em um método que não é sobrescrita?

