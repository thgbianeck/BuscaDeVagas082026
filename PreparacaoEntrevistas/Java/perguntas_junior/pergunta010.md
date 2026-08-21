# Pergunta 10 — Polimorfismo na Prática

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Você tem uma classe `Animal` com o método `emitirSom()`, e as subclasses `Cachorro`, `Gato` e `Pato`, cada uma sobrescrevendo esse método. Em um sistema de pet shop, você recebe uma lista de animais (sem saber o tipo específico de cada um) e precisa fazer todos emitirem som. Como você implementaria isso e por que o polimorfismo é útil neste caso?

**O que essa pergunta avalia:**  
Compreensão prática de polimorfismo, capacidade de usar referências de superclasse para objetos de subclasses, e entendimento de como o polimorfismo promove extensibilidade e reduz acoplamento.

**Resposta esperada:**  
O polimorfismo permite tratar todos os animais como `Animal`, sem precisar saber o tipo específico. Ao percorrer a lista e chamar `animal.emitirSom()`, o Java resolve em runtime qual implementação executar com base no tipo real do objeto (dynamic dispatch). Isso significa que o código não precisa de `if`s ou `instanceof` para decidir qual som emitir — basta chamar o método e o polimorfismo cuida do resto.

Isso é útil porque:
1. **Extensibilidade:** adicionar um novo animal (ex: `Leao`) não exige alterar o código que faz os animais emitirem som.
2. **Baixo acoplamento:** o código que processa os animais não conhece as subclasses específicas.
3. **Manutenibilidade:** mudanças no comportamento de um animal são isoladas na própria subclasse.

**Explicação didática:**  
Imagine que você é um maestro regendo uma orquestra. Você não precisa saber se cada músico toca violino, flauta ou trompete — você apenas dá o sinal "tocar" e cada um executa seu instrumento. O polimorfismo é exatamente isso: você chama um método genérico (`emitirSom()`) e cada objeto responde à sua maneira, sem que você precise saber quem é quem.

**Exemplo prático:**  
Um pet shop tem um sistema que agenda banhos e consultas. Ao final do dia, o sistema toca um som de notificação para cada animal (um latido para o cachorro, um miau para o gato). Com polimorfismo, o sistema não precisa saber quais animais existem — basta iterar a lista e chamar `emitirSom()`.

**Exemplo de código:**  
```java
import java.util.List;
import java.util.ArrayList;

// Superclasse
public abstract class Animal {
    private String nome;
    
    public Animal(String nome) {
        this.nome = nome;
    }
    
    public String getNome() { return nome; }
    
    // Método a ser sobrescrito pelas subclasses
    public abstract void emitirSom();
}

public class Cachorro extends Animal {
    public Cachorro(String nome) { super(nome); }
    
    @Override
    public void emitirSom() {
        System.out.println(getNome() + ": Au au!");
    }
}

public class Gato extends Animal {
    public Gato(String nome) { super(nome); }
    
    @Override
    public void emitirSom() {
        System.out.println(getNome() + ": Miau!");
    }
}

public class Pato extends Animal {
    public Pato(String nome) { super(nome); }
    
    @Override
    public void emitirSom() {
        System.out.println(getNome() + ": Quack!");
    }
}

// Uso do polimorfismo
public class PetShop {
    public void notificarAnimais(List<Animal> animais) {
        for (Animal animal : animais) {
            // Não importa o tipo real — o polimorfismo resolve
            animal.emitirSom();
        }
    }
}

// Teste
public class Main {
    public static void main(String[] args) {
        List<Animal> animais = new ArrayList<>();
        animais.add(new Cachorro("Rex"));
        animais.add(new Gato("Mimi"));
        animais.add(new Pato("Donald"));
        
        PetShop petShop = new PetShop();
        petShop.notificarAnimais(animais);
        // Saída:
        // Rex: Au au!
        // Mimi: Miau!
        // Donald: Quack!
    }
}
```

**Como o candidato deve responder:**  
- Explicar que o polimorfismo permite tratar objetos de subclasses como o tipo da superclasse.
- Mostrar que ao chamar `emitirSom()`, o Java resolve em runtime qual implementação executar.
- Mencionar que não é necessário usar `instanceof` ou `if-else` para cada tipo.
- Destacar os benefícios: extensibilidade, baixo acoplamento, manutenibilidade.
- Trazer o exemplo do pet shop.
- Evitar sugerir `if (animal instanceof Cachorro)` — isso anula o benefício do polimorfismo.

**Resposta fraca ou incompleta:**  
"Faria um `if` para verificar o tipo de cada animal e chamar o som correto." — Isso demonstra falta de compreensão do polimorfismo. Usar `instanceof` e casts anula o propósito do polimorfismo e torna o código rígido e difícil de estender.

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
1. O que aconteceria se você adicionasse um novo animal `Leao` sem modificar a classe `PetShop`?
2. Qual a diferença entre polimorfismo de sobrecarga (overloading) e sobrescrita (overriding)?
3. O que é "dynamic dispatch" e como ele funciona por baixo dos panos?