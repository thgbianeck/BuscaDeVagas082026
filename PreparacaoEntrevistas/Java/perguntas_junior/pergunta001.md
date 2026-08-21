# Pergunta 1 — Variáveis e Tipos Primitivos vs Wrappers

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você está trabalhando em um sistema de cadastro de clientes e precisa armazenar a idade de um usuário. Um colega de equipe sugere usar `int` para a idade, mas você vê que em outro módulo o sistema usa `Integer`. Em um cenário onde a idade pode não ter sido informada pelo usuário (valor nulo), qual tipo você escolheria e por quê? Explique a diferença entre os dois.

**O que essa pergunta avalia:**  
Conhecimento sobre a diferença entre tipos primitivos e wrappers (classes encapsuladoras), compreensão de quando valores nulos são possíveis, e capacidade de tomar uma decisão técnica simples baseada em um requisito de negócio.

**Resposta esperada:**  
Deve-se usar `Integer` quando a idade pode ser nula, pois tipos primitivos como `int` não podem assumir valor `null` — seu valor padrão é `0`. `Integer` é uma classe wrapper que encapsula um valor `int` em um objeto, permitindo representar a ausência de valor com `null`. Se a idade não foi informada pelo usuário, usar `int` mascara o problema, pois `0` é um valor válido (um bebê recém-nascido tem 0 anos), tornando impossível distinguir entre "idade não informada" e "idade zero".

**Explicação didática:**  
Pense em `int` como uma caixa física que sempre tem algo dentro — se você não colocar nada, ela vem com `0` de fábrica. Já `Integer` é como um envelope: pode conter um número dentro ou estar vazio (`null`). Quando o usuário não preenche a idade no formulário, o envelope chega vazio, e você consegue identificar isso. Com a caixa `int`, você nunca saberia se o `0` significa "não preenchido" ou "zero anos".

**Exemplo prático:**  
Em uma API REST que recebe o JSON `{"nome": "João", "idade": null}`, se o campo `idade` for mapeado como `int`, o valor chegará como `0`, perdendo a informação de que o usuário não informou a idade. Com `Integer`, o valor chegará como `null`, permitindo validar e solicitar o preenchimento.

**Exemplo de código:**  
```java
public class Cliente {
    private String nome;
    private Integer idade; // Permite null quando não informado
    
    public Integer getIdade() {
        return idade;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    // Método utilitário para verificar se a idade foi informada
    public boolean hasIdadeInformada() {
        return idade != null;
    }
}

// Cenário de uso
Cliente cliente = new Cliente();
cliente.setNome("João");
// Idade não informada — getIdade() retorna null, não 0
if (!cliente.hasIdadeInformada()) {
    System.out.println("Por favor, informe a idade do cliente.");
}
```

**Como o candidato deve responder:**  
- Começar identificando que o requisito "idade pode ser nula" é o ponto-chave da decisão.
- Explicar a diferença entre `int` (primitivo, valor padrão `0`, não aceita `null`) e `Integer` (wrapper, objeto, aceita `null`).
- Mencionar o risco de confundir `0` com "não informado".
- Trazer um exemplo concreto (como o de uma API REST ou formulário).
- Evitar responder apenas "usaria Integer porque aceita null" sem justificar o porquê.

**Resposta fraca ou incompleta:**  
"Usaria `Integer` porque é melhor que `int`." — Não explica a diferença entre os dois, não menciona o cenário de valor nulo, nem o risco de confundir `0` com ausência de valor.

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
1. O que acontece se você tentar chamar um método em uma variável `Integer` que está com valor `null`?
2. Em quais situações o uso de wrappers pode impactar o desempenho da aplicação?
3. Como o autoboxing e unboxing funcionam na prática com esses tipos?
