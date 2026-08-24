##  26. <a name='Pergunta22OptionalcomoAlternativaanull'></a>Pergunta 22 — Optional como Alternativa a null

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você está desenvolvendo um método `buscarUsuarioPorId(Long id)` que consulta um banco de dados. O usuário pode existir ou não. Historicamente, o método retorna `null` quando não encontra o usuário, e vários pontos do sistema já quebraram com `NullPointerException` por esquecer de verificar o retorno. Como você redesenharia o contrato desse método usando `Optional`? Quais cuidados devem ser tomados ao usar `Optional`?

**O que essa pergunta avalia:**  
Conhecimento prático de `Optional` (Java 8+), compreensão de como ele força o tratamento de ausência, e capacidade de identificar boas práticas e armadilhas do seu uso.

**Resposta esperada:**  
Redesenhar o método para retornar `Optional<Usuario>` em vez de `Usuario`:

```java
public Optional<Usuario> buscarUsuarioPorId(Long id)
```

Isso faz com que o chamador seja **obrigado** a lidar com a possibilidade de ausência — não é possível chamar `.getNome()` diretamente em um `Optional`, é preciso "desembrulhar" o valor com `map()`, `orElse()`, `orElseThrow()`, etc.

**Boas práticas com `Optional`:**
1. **Usar como retorno de método**, nunca como campo de instância (atributo).
2. **Nunca usar `Optional.get()` sem verificar `isPresent()`** — prefira `map`, `orElse`, `orElseThrow`.
3. **Não usar para parâmetros de método** — use sobrecarga ou `@Nullable`.
4. **Usar `Optional.empty()` para ausência** e `Optional.of()` para valor garantido (não-null) ou `Optional.ofNullable()` se o valor pode ser null.

**Explicação didática:**  
Pense no `Optional` como uma caixa de presente. Quando você recebe uma caixa (Optional), precisa abri-la para ver o que tem dentro. Se a caixa estiver vazia, você precisa decidir o que fazer (usar um valor padrão, lançar erro, etc.). O ponto chave é que a caixa **lembra você** de verificar — diferente de um valor solto que pode ser `null` silenciosamente. É como receber um pacote com etiqueta "frágil" — você naturalmente tem mais cuidado.

**Exemplo prático:**  
Em uma API REST, o endpoint `GET /usuarios/{id}` precisa retornar 404 se o usuário não existir. Com `Optional`, o controller pode fazer:

```java
Usuario usuario = service.buscarUsuarioPorId(id)
    .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
```

**Exemplo de código:**  
```java
import java.util.Optional;

public class UsuarioService {
    
    // ✅ Retorna Optional — força o chamador a tratar ausência
    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        if (id == null || id <= 0) {
            return Optional.empty();
        }
        Usuario usuario = repository.findById(id);
        return Optional.ofNullable(usuario); // encapsula null de forma segura
    }
}

// Diferentes formas de consumir o Optional:

// 1. Valor padrão
String nome = service.buscarUsuarioPorId(id)
    .map(Usuario::getNome)
    .orElse("Usuário não encontrado");

// 2. Lançar exceção se ausente
Usuario usuario = service.buscarUsuarioPorId(id)
    .orElseThrow(() -> new NotFoundException("Usuário " + id + " não existe"));

// 3. Ação apenas se presente
service.buscarUsuarioPorId(id)
    .ifPresent(u -> System.out.println("Encontrado: " + u.getNome()));

// 4. Transformação encadeada
String email = service.buscarUsuarioPorId(id)
    .map(Usuario::getEmail)
    .filter(e -> e.endsWith("@empresa.com"))
    .orElse("e-mail corporativo não encontrado");

// ❌ ANTI-PADRÕES:
Optional<Usuario> opt = service.buscarUsuarioPorId(id);
if (opt.isPresent()) {
    Usuario u = opt.get(); // Funciona mas perde o propósito do Optional
}
// Melhor: usar map/orElse/ifPresent como acima

// ❌ Nunca usar como atributo
public class Cliente {
    private Optional<String> nome; // ERRADO! Usar String e tratar null
}
```

**Como o candidato deve responder:**  
- Propor retorno `Optional<Usuario>` para forçar o tratamento de ausência.
- Explicar que `Optional` é um "container" que pode ou não conter um valor.
- Demonstrar uso correto: `map`, `orElse`, `orElseThrow`, `ifPresent`.
- Mencionar as armadilhas: não usar como atributo, não usar `get()` sem `isPresent()`.
- Trazer o exemplo de API REST.
- Evitar sugerir `Optional` para parâmetros de método.

**Resposta fraca ou incompleta:**  
"Retornar `Optional` e usar `isPresent()` antes de `get()`." — Funciona mas não aproveita o estilo funcional do `Optional`. Não menciona `map`, `orElse`, nem as armadilhas de uso.

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
1. Por que `Optional` não deveria ser usado como campo de instância?
2. Qual a diferença entre `Optional.of()` e `Optional.ofNullable()`?
3. Como `Optional` interage com Streams API?

---

##  27. <a name='Pergunta23ComparableeComparator'></a>Pergunta 23 — Comparable e Comparator

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Você tem uma lista de objetos `Pedido` que precisam ser ordenados. Às vezes o usuário quer ordenar por data, outras vezes por valor total, e outras por nome do cliente. Como você implementaria essa ordenação flexível? Qual a diferença entre `Comparable` e `Comparator` e quando usar cada um?

**O que essa pergunta avalia:**  
Conhecimento das interfaces `Comparable` e `Comparator`, compreensão de ordenação natural vs ordenação customizada, e capacidade de implementar múltiplos critérios de ordenação.

**Resposta esperada:**  
- **`Comparable`** define a ordenação **natural** da classe — implementa o método `compareTo(T)` dentro da própria classe. Útil quando há uma ordenação padrão óbvia (ex: `Pedido` por data). Só pode haver uma implementação.
- **`Comparator`** define ordenação **externa** e **alternativa** — implementa o método `compare(T, T)` em uma classe separada ou via lambda. Permite múltiplos critérios de ordenação sem alterar a classe original.

Para o cenário descrito, a melhor abordagem é:
1. Implementar `Comparable<Pedido>` com a ordenação natural (ex: por data).
2. Criar `Comparator<Pedido>` separados para ordenação por valor e por nome do cliente.
3. Usar `Comparator.comparing()` (Java 8+) para criar comparators de forma concisa.

**Explicação didática:**  
`Comparable` é como o RG da pessoa — define uma identidade única de comparação que não muda. Uma pessoa sempre é comparada pelo CPF, por exemplo. `Comparator` é como os diferentes critérios de ordem em uma fila: às vezes você ordena por altura, às vezes por idade, às vezes por ordem alfabética. A pessoa não muda, mas o critério de comparação sim.

**Exemplo prático:**  
Em um painel de pedidos de e-commerce, o usuário pode clicar nas colunas da tabela para ordenar por data, valor ou cliente. Cada clique troca o `Comparator` aplicado à lista.

**Exemplo de código:**  
```java
import java.util.*;
import java.util.Comparator;

class Pedido implements Comparable<Pedido> {
    private Long id;
    private String nomeCliente;
    private double valor;
    private Date data;
    
    // Construtor e getters omitidos para brevidade
    public Long getId() { return id; }
    public String getNomeCliente() { return nomeCliente; }
    public double getValor() { return valor; }
    public Date getData() { return data; }
    
    // Ordenação natural — por data (Comparable)
    @Override
    public int compareTo(Pedido outro) {
        return this.data.compareTo(outro.data);
    }
}

public class ExemploOrdenacao {
    
    public void ordenarPedidos(List<Pedido> pedidos, String criterio) {
        switch (criterio) {
            case "data":
                // Usa ordenação natural (Comparable)
                Collections.sort(pedidos);
                break;
                
            case "valor":
                // Comparator por valor — lambda (Java 8+)
                pedidos.sort(Comparator.comparingDouble(Pedido::getValor));
                break;
                
            case "cliente":
                // Comparator por nome — method reference
                pedidos.sort(Comparator.comparing(Pedido::getNomeCliente));
                break;
                
            case "valorDecrescente":
                // Comparator reverso
                pedidos.sort(Comparator.comparingDouble(Pedido::getValor).reversed());
                break;
                
            case "clienteEValor":
                // Composição — primeiro por cliente, depois por valor
                pedidos.sort(
                    Comparator.comparing(Pedido::getNomeCliente)
                              .thenComparingDouble(Pedido::getValor)
                );
                break;
        }
    }
}

// Comparator como classe separada (útil quando a lógica é complexa)
class PedidoPorValorComparator implements Comparator<Pedido> {
    @Override
    public int compare(Pedido p1, Pedido p2) {
        return Double.compare(p1.getValor(), p2.getValor());
        // Double.compare lida corretamente com NaN e valores especiais
    }
}

// Uso:
List<Pedido> pedidos = new ArrayList<>();
// ... adicionar pedidos ...
pedidos.sort(new PedidoPorValorComparator());
// ou
pedidos.sort(Comparator.comparingDouble(Pedido::getValor));
```

**Como o candidato deve responder:**  
- Explicar que `Comparable` define ordenação natural (uma só, dentro da classe).
- Explicar que `Comparator` permite múltiplos critérios (externos à classe).
- Usar `Comparator.comparing()` para criar comparators de forma concisa.
- Mencionar `reversed()` para ordem decrescente e `thenComparing()` para critérios compostos.
- Trazer o exemplo do painel de pedidos.
- Evitar implementar `Comparable` para cada critério diferente (não é possível).

**Resposta fraca ou incompleta:**  
"Implementar `Comparable` para ordenar." — Só permite uma ordenação. Não diferencia `Comparable` de `Comparator`, nem mostra como ter múltiplos critérios.

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
1. O que acontece se você usar `p1.getValor() - p2.getValor()` em vez de `Double.compare()`?
2. Como criar um `Comparator` que ordena por nulls primeiro ou por nulls último?
3. Qual a diferença entre `Collections.sort()` e `List.sort()`?

---

##  28. <a name='Pergunta24EnumscomAtributoseMtodos'></a>Pergunta 24 — Enums com Atributos e Métodos

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você está modelando os status de um pedido em um e-commerce: `AGUARDANDO_PAGAMENTO`, `PAGAMENTO_CONFIRMADO`, `ENVIADO`, `ENTREGUE`, `CANCELADO`. Cada status precisa ter uma descrição amigável para o usuário (ex: "Aguardando Pagamento") e um método que indica se o pedido pode ser cancelado a partir daquele status. Como você implementaria isso com `enum`?

**O que essa pergunta avalia:**  
Conhecimento de enums em Java, capacidade de adicionar atributos, construtores e métodos em enums, e compreensão de como enums podem encapsular lógica de negócio.

**Resposta esperada:**  
Enums em Java são mais poderosos que em outras linguagens — podem ter atributos, construtores, métodos e até implementar interfaces. Cada constante do enum pode ter seu próprio comportamento sobrescrevendo métodos.

Para o cenário:
1. Criar um `enum StatusPedido` com as constantes.
2. Adicionar um atributo `descricao` (String) e um construtor.
3. Adicionar um método `podeCancelar()` que retorna `true` apenas para os status onde o cancelamento é permitido.
4. Opcionalmente, sobrescrever o método por constante (constant-specific class body) para lógica mais complexa.

**Explicação didática:**  
Pense no enum como um grupo de botões em um painel. Cada botão tem um rótulo (descrição) e um comportamento específico quando pressionado. O botão "Aguardando Pagamento" permite cancelar, mas o botão "Entregue" não. O enum organiza esses botões em um único lugar, garantindo que não existam status inválidos — é como ter um controle remoto com botões fixos, onde ninguém pode inventar um botão novo.

**Exemplo prático:**  
Em um sistema de e-commerce, quando o usuário clica em "Cancelar Pedido", o sistema verifica `pedido.getStatus().podeCancelar()`. Se o pedido já foi entregue, o botão de cancelar pode ser desabilitado na interface com base nesse método.

**Exemplo de código:**  
```java
public enum StatusPedido {
    // Constantes com atributos
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    PAGAMENTO_CONFIRMADO("Pagamento Confirmado"),
    ENVIADO("Enviado"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");
    
    private final String descricao;
    
    // Construtor do enum — sempre private (implícito)
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    // Lógica de negócio encapsulada no enum
    public boolean podeCancelar() {
        // Só pode cancelar antes do envio
        return this == AGUARDANDO_PAGAMENTO || this == PAGAMENTO_CONFIRMADO;
    }
    
    // Lógica: o pedido já foi finalizado?
    public boolean isFinalizado() {
        return this == ENTREGUE || this == CANCELADO;
    }
}

// Uso prático
public class Pedido {
    private StatusPedido status = StatusPedido.AGUARDANDO_PAGAMENTO;
    
    public void cancelar() {
        if (!status.podeCancelar()) {
            throw new IllegalStateException(
                "Não é possível cancelar um pedido com status: " + status.getDescricao()
            );
        }
        this.status = StatusPedido.CANCELADO;
    }
    
    public void confirmarPagamento() {
        if (status != StatusPedido.AGUARDANDO_PAGAMENTO) {
            throw new IllegalStateException(
                "Pagamento só pode ser confirmado se estiver aguardando pagamento"
            );
        }
        this.status = StatusPedido.PAGAMENTO_CONFIRMADO;
    }
    
    public StatusPedido getStatus() { return status; }
}

// Teste
Pedido pedido = new Pedido();
System.out.println(pedido.getStatus().getDescricao()); // "Aguardando Pagamento"
System.out.println(pedido.getStatus().podeCancelar()); // true
pedido.confirmarPagamento();
System.out.println(pedido.getStatus().podeCancelar()); // true (ainda pode)
// Simular envio... status = ENVIADO
// pedido.getStatus().podeCancelar() → false
```

**Abordagem avançada — sobrescrita por constante:**
```java
public enum StatusPedido {
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento") {
        @Override
        public boolean podeCancelar() { return true; }
    },
    ENVIADO("Enviado") {
        @Override
        public boolean podeCancelar() { return false; }
    },
    // ... outras constantes
    ;
    
    private final String descricao;
    
    StatusPedido(String descricao) { this.descricao = descricao; }
    public String getDescricao() { return descricao; }
    
    // Método padrão — pode ser sobrescrito por constante
    public boolean podeCancelar() { return false; }
}
```

**Como o candidato deve responder:**  
- Explicar que enums em Java podem ter atributos, construtores e métodos.
- Implementar `descricao` como atributo com construtor.
- Implementar `podeCancelar()` com lógica baseada no status.
- Mencionar a opção de sobrescrita por constante para lógica mais complexa.
- Trazer o exemplo do botão "Cancelar Pedido" na interface.
- Evitar usar constantes `int` ou `String` mágicas em vez de enum.

**Resposta fraca ou incompleta:**  
"Criar um enum com os status e um `if` para verificar se pode cancelar." — Não menciona atributos, construtores, nem encapsula a lógica dentro do enum. A lógica fica espalhada no código em vez de centralizada.

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
1. Por que o construtor de um enum é sempre private? Pode ser protected?
2. Como iterar sobre todos os valores de um enum?
3. É possível fazer `switch` com enums? Que vantagens isso traz?

---

##  29. <a name='Pergunta25java.time:ManipulaodeDatas'></a>Pergunta 25 — java.time: Manipulação de Datas

**Nível:** Júnior  
**Categoria:** Manipulação de Strings e Datas

**Pergunta do entrevistador:**  
Em um sistema de agendamento de consultas, você precisa: (1) armazenar a data e hora da consulta, (2) calcular a próxima consulta (30 dias depois), (3) verificar se a consulta é hoje e (4) formatar a data para exibição ao usuário no formato "dd/MM/yyyy HH:mm". Um colega usou `java.util.Date` e `java.util.Calendar`, mas o código ficou confuso. Como você implementaria isso com a API `java.time` (Java 8+)?

**O que essa pergunta avalia:**  
Conhecimento prático da API `java.time` (`LocalDateTime`, `LocalDate`, `DateTimeFormatter`), compreensão das limitações da API legada (`Date`/`Calendar`), e capacidade de operações comuns com datas.

**Resposta esperada:**  
A API `java.time` (introduzida no Java 8) é imutável, thread-safe e muito mais intuitiva que `Date`/`Calendar`:

1. **Armazenar data e hora:** usar `LocalDateTime` (sem fuso horário) ou `ZonedDateTime` (com fuso).
2. **Somar 30 dias:** usar `.plusDays(30)` — retorna um novo objeto (imutabilidade).
3. **Verificar se é hoje:** comparar com `LocalDate.now()` usando `.toLocalDate()`.
4. **Formatar:** usar `DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")`.

**Explicação didática:**  
`Date` e `Calendar` são como um relógio antigo que tenta fazer tudo (data, hora, fuso) mas faz tudo mal — mutável, com meses começando em zero (janeiro = 0!), e thread-unsafe. A API `java.time` é como ter ferramentas separadas e especializadas: `LocalDate` só guarda a data, `LocalTime` só a hora, `LocalDateTime` os dois. Cada operação retorna um novo objeto, então nunca há risco de alterar acidentalmente uma data compartilhada — é como trabalhar com cópias, não com o original.

**Exemplo prático:**  
Em um sistema de agendamento médico, a secretária agenda uma consulta para hoje e precisa informar ao paciente quando será a próxima (30 dias depois). O sistema também precisa exibir a data formatada na tela e verificar se a consulta já aconteceu.

**Exemplo de código:**  
```java
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class AgendamentoConsultas {
    
    // Formato para exibição ao usuário
    private static final DateTimeFormatter FORMATO_BRASIL = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    // 1. Armazenar data e hora da consulta
    private LocalDateTime dataConsulta;
    
    public void agendarConsulta(LocalDateTime dataHora) {
        this.dataConsulta = dataHora;
    }
    
    // 2. Calcular próxima consulta (30 dias depois)
    public LocalDateTime calcularProximaConsulta() {
        if (dataConsulta == null) {
            throw new IllegalStateException("Nenhuma consulta agendada");
        }
        // plusDays retorna NOVO objeto — dataConsulta não é alterado
        return dataConsulta.plusDays(30);
    }
    
    // 3. Verificar se a consulta é hoje
    public boolean isConsultaHoje() {
        if (dataConsulta == null) return false;
        LocalDate hoje = LocalDate.now();
        LocalDate dataConsultaLocal = dataConsulta.toLocalDate();
        return hoje.equals(dataConsultaLocal);
    }
    
    // 4. Formatar para exibição
    public String getConsultaFormatada() {
        if (dataConsulta == null) return "Sem consulta agendada";
        return dataConsulta.format(FORMATO_BRASIL);
    }
    
    // Extras úteis:
    // Calcular dias entre hoje e a consulta
    public long diasAteConsulta() {
        return ChronoUnit.DAYS.between(LocalDate.now(), dataConsulta.toLocalDate());
    }
    
    // Verificar se a consulta já passou
    public boolean isConsultaPassada() {
        return dataConsulta.isBefore(LocalDateTime.now());
    }
    
    // Converter string para LocalDateTime
    public static LocalDateTime parseFromString(String dataStr) {
        return LocalDateTime.parse(dataStr, FORMATO_BRASIL);
    }
}

// Uso
AgendamentoConsultas agendamento = new AgendamentoConsultas();
agendamento.agendarConsulta(LocalDateTime.of(2026, 8, 20, 14, 30));

System.out.println("Consulta: " + agendamento.getConsultaFormatada());
// Saída: 20/08/2026 14:30

System.out.println("Próxima: " + agendamento.calcularProximaConsulta().format(FORMATO_BRASIL));
// Saída: 19/09/2026 14:30

System.out.println("É hoje? " + agendamento.isConsultaHoje());
// Saída: true (se executado em 20/08/2026)

System.out.println("Dias até consulta: " + agendamento.diasAteConsulta());
// Saída: 0 (se for hoje)
```

**Como o candidato deve responder:**  
- Identificar as classes corretas: `LocalDateTime` para data+hora, `LocalDate` para só data.
- Usar `.plusDays(30)` para somar dias (imutável).
- Comparar com `LocalDate.now()` para verificar se é hoje.
- Usar `DateTimeFormatter` para formatar e fazer parse.
- Mencionar que `java.time` é imutável e thread-safe.
- Evitar usar `Date` e `Calendar` — são mutáveis e confusos.
- Evitar usar `SimpleDateFormat` — não é thread-safe.

**Resposta fraca ou incompleta:**  
"Usar `Date` e `Calendar` para somar 30 dias com `calendar.add()`." — Usa a API legada que o próprio enunciado diz estar confusa. Não aproveita `java.time`, nem menciona imutabilidade.

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
1. Qual a diferença entre `LocalDateTime`, `ZonedDateTime` e `OffsetDateTime`?
2. Como lidar com fusos horários em um sistema que atende usuários em diferentes regiões?
3. Por que `SimpleDateFormat` não é thread-safe e como `DateTimeFormatter` resolve isso?

---

##  30. <a name='Pergunta26ImutabilidadedeObjetos'></a>Pergunta 26 — Imutabilidade de Objetos

**Nível:** Júnior  
**Categoria:** Boas Práticas

**Pergunta do entrevistador:**  
Em uma aplicação multi-thread, vários componentes acessam um objeto `Configuracao` que contém parâmetros do sistema (URL do banco, timeout, etc.). Ocorreram bugs intermitentes onde os valores apareciam "trocados" ou "errados" esporadicamente. Um desenvolvedor sugere tornar a classe imutável. O que isso significa, como implementar e por que resolveria o problema?

**O que essa pergunta avalia:**  
Compreensão do conceito de imutabilidade, capacidade de implementar uma classe imutável em Java, e entendimento dos benefícios (thread-safety, previsibilidade, redução de bugs).

**Resposta esperada:**  
Um objeto imutável é aquele cujo estado não pode ser alterado após a construção. Isso significa:
1. Todos os atributos são `final`.
2. Não há setters.
3. Se houver coleções, elas são defensivamente copiadas (não expostas diretamente).
4. Métodos que "modificam" retornam uma nova instância (ex: `String.substring()`).

**Como resolveria o problema:**
- Em ambiente multi-thread, objetos mutáveis compartilhados podem ser modificados por uma thread enquanto outra está lendo, causando inconsistências.
- Objetos imutáveis são inerentemente **thread-safe** — não há como uma thread altere o estado enquanto outra lê, pois o estado nunca muda.
- Qualquer "alteração" cria um novo objeto, preservando o original.

**Explicação didática:**  
Pense em um objeto imutável como uma pedra esculpida — uma vez pronta, não dá para modificar. Se você quer uma versão diferente, esculpe uma nova pedra. Um objeto mutável é como uma bola de massa: qualquer um pode amassar e mudar o formato a qualquer momento. Se várias pessoas tentam usar a mesma bola de massa ao mesmo tempo, alguém vai deformar o que o outro estava usando. A pedra (imutável) nunca tem esse problema — cada um pega a sua e pode usá-la sem medo de alguém alterá-la.

**Exemplo prático:**  
Em uma aplicação web, múltiplas requisições simultâneas acessam a mesma configuração de timeout do banco de dados. Se uma thread alterar o timeout enquanto outra está lendo, a segunda pode usar um valor parcialmente atualizado. Com imutabilidade, isso é impossível.

**Exemplo de código:**  
```java
import java.util.*;

// ✅ Classe imutável
public final class Configuracao {
    private final String urlBanco;
    private final int timeoutSegundos;
    private final List<String> hostsPermitidos; // Lista mutável!
    
    public Configuracao(String urlBanco, int timeoutSegundos, 
                       List<String> hostsPermitidos) {
        // Validação no construtor — fail-fast
        if (urlBanco == null || urlBanco.isEmpty()) {
            throw new IllegalArgumentException("URL do banco é obrigatória");
        }
        if (timeoutSegundos <= 0) {
            throw new IllegalArgumentException("Timeout deve ser positivo");
        }
        
        this.urlBanco = urlBanco;
        this.timeoutSegundos = timeoutSegundos;
        // Cópia defensiva — protege contra alterações externas
        this.hostsPermitidos = new ArrayList<>(hostsPermitidos);
    }
    
    // Getters — sem setters
    public String getUrlBanco() { return urlBanco; }
    public int getTimeoutSegundos() { return timeoutSegundos; }
    
    // Retorna cópia defensiva — não expõe a lista interna
    public List<String> getHostsPermitidos() {
        return new ArrayList<>(hostsPermitidos); // Cópia a cada chamada
    }
    
    // Ou retorna lista não modificável (mais eficiente)
    public List<String> getHostsPermitidosUnmodifiable() {
        return Collections.unmodifiableList(hostsPermitidos);
    }
    
    // "Modificação" retorna nova instância
    public Configuracao comTimeout(int novoTimeout) {
        return new Configuracao(this.urlBanco, novoTimeout, this.hostsPermitidos);
    }
    
    @Override
    public String toString() {
        return "Configuracao{url=" + urlBanco + ", timeout=" + timeoutSegundos + "s}";
    }
}

// ❌ Classe mutável — causa problemas em multi-thread
public class ConfiguracaoMutavel {
    private String urlBanco;
    private int timeoutSegundos;
    
    public void setUrlBanco(String url) { this.urlBanco = url; }
    public void setTimeoutSegundos(int t) { this.timeoutSegundos = t; }
    // Qualquer thread pode alterar a qualquer momento — race condition
}

// Uso
List<String> hosts = new ArrayList<>(Arrays.asList("host1", "host2"));
Configuracao config = new Configuracao("jdbc:postgresql://localhost/db", 30, hosts);

// Alterar a lista original NÃO afeta o objeto imutável
hosts.add("host3"); 
System.out.println(config.getHostsPermitidos()); // Ainda [host1, host2]

// "Modificar" cria nova instância
Configuracao novaConfig = config.comTimeout(60);
System.out.println(config);          // timeout=30 (inalterado)
System.out.println(novaConfig);      // timeout=60 (nova instância)
```

**Como o candidato deve responder:**  
- Definir imutabilidade: estado não pode mudar após construção.
- Listar as regras: atributos `final`, sem setters, classe `final`, cópia defensiva de coleções.
- Explicar por que resolve o problema multi-thread: não há race condition se o estado nunca muda.
- Mencionar `String` como exemplo de classe imutável nativa do Java.
- Trazer o exemplo de configuração compartilhada.
- Evitar apenas dizer "use `final` nos atributos" sem explicar cópia defensiva.

**Resposta fraca ou incompleta:**  
"Fazer os atributos `final`." — É necessário mas não suficiente. Sem cópia defensiva de coleções, o objeto ainda pode ser alterado indiretamente. Sem tirar os setters, o objeto não é imutável.

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
1. Por que a classe deve ser `final` para garantir imutabilidade?
2. Como `String` implementa imutabilidade e por que isso é vantajoso para o String Pool?
3. Em quais situações a imutabilidade pode ser um problema (ex: muitos objetos criados)?

---

##  31. <a name='Pergunta27LambdaseFunctionalInterfaces'></a>Pergunta 27 — Lambdas e Functional Interfaces

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você tem uma lista de produtos e precisa filtrar os que custam mais de `R$ 100`. Sem usar Streams, um colega escreveu um método que recebe a lista e um objeto `Predicate<Product>` anônimo. Outro colega sugere usar uma expressão lambda. Explique como os lambdas funcionam, qual é a relação com interfaces funcionais e reescreva o código usando lambda.

**O que essa pergunta avalia:**  
Compreensão do que são expressões lambda em Java, conhecimento de interfaces funcionais, e capacidade de substituir classes anônimas por lambdas.

**Resposta esperada:**  
Uma **interface funcional** é uma interface com exatamente um método abstrato (SAM — Single Abstract Method). Pode ser anotada com `@FunctionalInterface` (opcional, mas recomendada). Exemplos: `Predicate<T>` (`test`), `Consumer<T>` (`accept`), `Function<T,R>` (`apply`), `Supplier<T>` (`get`).

Uma **expressão lambda** é uma forma concisa de implementar uma interface funcional sem criar uma classe anônima. A lambda é basicamente o corpo do método abstrado da interface, com os parâmetros inferidos pelo compilador.

**Sintaxe:** `(parâmetros) -> { corpo }`  
- Sem parâmetros: `() -> System.out.println("hello")`
- Um parâmetro: `p -> p.getPreco() > 100`
- Múltiplos parâmetros: `(a, b) -> a + b`
- Com tipo explícito: `(Product p) -> p.getPreco() > 100`

**Explicação didática:**  
Imagine que uma interface funcional é como uma tomada na parede — tem um formato específico (um único método). A classe anônima é como construir uma caixa inteira para plugar na tomada, com moldura e parafusos. O lambda é como plugar diretamente o fio — sem a caixa, sem parafusos, apenas a conexão necessária. O compilador entende que o lambda deve se encaixar na "tomada" (interface funcional) pelo formato do método.

**Exemplo prático:**  
Em um sistema de catálogo de produtos, o usuário pode aplicar diferentes filtros dinamicamente (por preço, por categoria, por nome). Cada filtro é um `Predicate<Produto>` que pode ser expresso como lambda.

**Exemplo de código:**  
```java
import java.util.*;
import java.util.function.Predicate;

class Product {
    private String nome;
    private double preco;
    
    public Product(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}

public class FiltroProdutos {
    
    // Método que aceita um Predicate — interface funcional
    public List<Product> filtrar(List<Product> produtos, Predicate<Product> criterio) {
        List<Product> resultado = new ArrayList<>();
        for (Product p : produtos) {
            if (criterio.test(p)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    public void demonstrar() {
        List<Product> produtos = Arrays.asList(
            new Product("Mouse", 50.0),
            new Product("Teclado", 150.0),
            new Product("Monitor", 800.0),
            new Product("Cabo", 25.0)
        );
        
        // ❌ Classe anônima — verboso
        List<Product> caros1 = filtrar(produtos, new Predicate<Product>() {
            @Override
            public boolean test(Product p) {
                return p.getPreco() > 100.0;
            }
        });
        
        // ✅ Lambda — conciso e legível
        List<Product> caros2 = filtrar(produtos, 
            p -> p.getPreco() > 100.0);
        
        // ✅ Method reference — ainda mais conciso
        // (quando o lambda apenas chama um método existente)
        
        // Diferentes critérios com lambdas
        List<Product> baratos = filtrar(produtos, 
            p -> p.getPreco() < 100.0);
        
        List<Product> comecaComM = filtrar(produtos, 
            p -> p.getNome().startsWith("M"));
        
        // Compondo predicates
        Predicate<Product> caro = p -> p.getPreco() > 100.0;
        Predicate<Product> comecaM = p -> p.getNome().startsWith("M");
        List<Product> carosEcomecamM = filtrar(produtos, 
            caro.and(comecaM)); // Composição de predicates
    }
}

// Interface funcional customizada
@FunctionalInterface
interface Validador<T> {
    boolean validar(T valor);
    // Pode ter métodos default e static, mas só UM abstrato
    default Validador<T> e(Validador<T> outro) {
        return valor -> this.validar(valor) && outro.validar(valor);
    }
}

// Uso da interface customizada com lambda
Validador<String> naoVazio = s -> s != null && !s.isEmpty();
Validador<String> temArroba = s -> s.contains("@");
Validador<String> emailValido = naoVazio.e(temArroba);
// emailValido.validar("teste@email.com") → true
```

**Como o candidato deve responder:**  
- Explicar que lambda é uma forma concisa de implementar uma interface funcional.
- Definir interface funcional: exatamente um método abstrato.
- Mostrar a evolução: classe anônima → lambda → method reference.
- Demonstrar composição de predicates (`and`, `or`, `negate`).
- Trazer o exemplo do catálogo com filtros.
- Evitar confundir lambda com método anônimo genérico (precisa de uma interface funcional como alvo).

**Resposta fraca ou incompleta:**  
"Usar `p -> p.getPreco() > 100` em vez de classe anônima." — Correto mas não explica o que é uma interface funcional, nem como o compilador sabe qual método implementar. Não mostra composição nem outros tipos de interfaces funcionais.

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
1. O que é a anotação `@FunctionalInterface` e o que acontece se a interface tiver dois métodos abstratos?
2. Qual a diferença entre `Predicate`, `Consumer`, `Function` e `Supplier`?
3. O que são "variable capture" e "effectively final" no contexto de lambdas?

---

##  32. <a name='Pergunta28TratamentodeExceesemMtodosEncadeados'></a>Pergunta 28 — Tratamento de Exceções em Métodos Encadeados

**Nível:** Júnior  
**Categoria:** Tratamento de Exceções

**Pergunta do entrevistador:**  
Você tem um fluxo de processamento de pedido que chama três métodos em sequência: `validarPedido()`, `calcularFrete()` e `processarPagamento()`. Cada método pode lançar um tipo diferente de exceção: `PedidoInvalidoException`, `FreteException` e `PagamentoException`. Como você estruturaria o tratamento para que o usuário receba uma mensagem apropriada para cada erro e o sistema faça log adequado? Como evitar repetição de código no tratamento?

**O que essa pergunta avalia:**  
Capacidade de estruturar tratamento de exceções em fluxos multi-etapa, conhecimento de multi-catch (Java 7+), exceções customizadas, e boas práticas de logging.

**Resposta esperada:**  
A estrutura deve:
1. **Exceções customizadas** com mensagens significativas para cada tipo de erro.
2. **Multi-catch** (`catch (A | B | C e)`) quando o tratamento for o mesmo para múltiplas exceções.
3. **Catch individual** quando o tratamento diferir por tipo de exceção.
4. **Logging** com nível apropriado (WARN para erros de validação, ERROR para falhas de pagamento).
5. **Mensagem ao usuário** amigável, sem expor detalhes técnicos.

Se as três exceções herdam de uma base comum (ex: `ProcessamentoPedidoException`), é possível capturar a base e tratar diferenciando com `instanceof` — embora multi-catch seja mais limpo.

**Explicação didática:**  
Imagine um fluxo de matrícula em uma escola: validação de documentos, cálculo de mensalidade e pagamento da matrícula. Cada etapa pode falhar de um jeito diferente: documentos incompletos, erro no cálculo, cartão recusado. Você precisa de uma "recepção" (try-catch) que saiba dar a mensagem certa para cada tipo de problema — não adianta dizer "erro genérico" para o cliente que teve o cartão recusado. O multi-catch é como ter uma recepcionista que reconhece diferentes tipos de problema e sabe o que dizer para cada um.

**Exemplo prático:**  
Em um e-commerce, durante o checkout, o sistema valida o pedido, calcula o frete e processa o pagamento. Se o CEP for inválido, o usuário vê "CEP inválido". Se o pagamento falhar, vê "Pagamento recusado pelo operador". O log técnico contém stack trace completo para os desenvolvedores.

**Exemplo de código:**  
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Exceções customizadas
class PedidoInvalidoException extends RuntimeException {
    public PedidoInvalidoException(String msg) { super(msg); }
}

class FreteException extends RuntimeException {
    public FreteException(String msg) { super(msg); }
}

class PagamentoException extends RuntimeException {
    public PagamentoException(String msg) { super(msg); }
}

public class ProcessadorPedido {
    
    private static final Logger logger = 
        LoggerFactory.getLogger(ProcessadorPedido.class);
    
    public ResultadoProcessamento processar(Pedido pedido) {
        try {
            // Fluxo sequencial — cada etapa pode falhar
            validarPedido(pedido);
            calcularFrete(pedido);
            processarPagamento(pedido);
            
            return ResultadoProcessamento.sucesso("Pedido processado com sucesso");
            
        } catch (PedidoInvalidoException e) {
            // Tratamento específico — erro de validação
            logger.warn("Pedido inválido: {}", e.getMessage());
            return ResultadoProcessamento.erro("Dados do pedido inválidos: " + e.getMessage());
            
        } catch (FreteException e) {
            // Tratamento específico — erro de frete
            logger.warn("Erro ao calcular frete: {}", e.getMessage());
            return ResultadoProcessamento.erro("Não foi possível calcular o frete. Verifique o CEP.");
            
        } catch (PagamentoException e) {
            // Tratamento específico — erro de pagamento (mais crítico)
            logger.error("Falha no pagamento do pedido {}: {}", 
                pedido.getId(), e.getMessage(), e);
            return ResultadoProcessamento.erro("Pagamento recusado. Tente outra forma de pagamento.");
            
        } catch (Exception e) {
            // Catch-all para erros inesperados
            logger.error("Erro inesperado ao processar pedido", e);
            return ResultadoProcessamento.erro("Erro interno. Tente novamente.");
        }
    }
    
    // Se o tratamento fosse igual para todas:
    public ResultadoProcessamento processarComMultiCatch(Pedido pedido) {
        try {
            validarPedido(pedido);
            calcularFrete(pedido);
            processarPagamento(pedido);
            return ResultadoProcessamento.sucesso("OK");
            
        } catch (PedidoInvalidoException | FreteException | PagamentoException e) {
            // Multi-catch — mesmo tratamento para todas
            logger.error("Erro ao processar pedido", e);
            return ResultadoProcessamento.erro(e.getMessage());
        }
    }
    
    private void validarPedido(Pedido pedido) {
        if (pedido == null || pedido.getItens().isEmpty()) {
            throw new PedidoInvalidoException("Pedido sem itens");
        }
    }
    
    private void calcularFrete(Pedido pedido) {
        if (pedido.getCep() == null) {
            throw new FreteException("CEP não informado");
        }
    }
    
    private void processarPagamento(Pedido pedido) {
        if (pedido.getValorTotal() <= 0) {
            throw new PagamentoException("Valor inválido para pagamento");
        }
    }
}

class ResultadoProcessamento {
    private boolean sucesso;
    private String mensagem;
    
    public static ResultadoProcessamento sucesso(String msg) {
        ResultadoProcessamento r = new ResultadoProcessamento();
        r.sucesso = true;
        r.mensagem = msg;
        return r;
    }
    
    public static ResultadoProcessamento erro(String msg) {
        ResultadoProcessamento r = new ResultadoProcessamento();
        r.sucesso = false;
        r.mensagem = msg;
        return r;
    }
    
    public String getMensagem() { return mensagem; }
    public boolean isSucesso() { return sucesso; }
}
```

**Como o candidato deve responder:**  
- Criar exceções customizadas para cada tipo de erro.
- Usar try-catch individual quando o tratamento difere (mensagem, log level).
- Mencionar multi-catch quando o tratamento é igual.
- Garantir que o usuário receba mensagem amigável (não stack trace).
- Garantir que o log tenha detalhes técnicos para os desenvolvedores.
- Trazer o exemplo de checkout de e-commerce.
- Evitar `catch (Exception e)` genérico como única estratégia.

**Resposta fraca ou incompleta:**  
"Colocar tudo dentro de um `try-catch (Exception e)` e mostrar a mensagem do erro." — Tratamento genérico não diferencia os tipos de erro, não permite mensagens específicas, e o log perde contexto sobre qual etapa falhou.

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
1. Quando fazia sentido criar uma hierarquia de exceções em vez de exceções separadas?
2. Qual a diferença entre `throw e` e `throw new MinhaException(e)` (exception chaining)?
3. Como garantir que recursos sejam liberados mesmo com múltiplos catchs?

---

##  33. <a name='Pergunta29EqualsHashCodeeoContrato'></a>Pergunta 29 — Equals, HashCode e o Contrato

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Em uma code review, você encontra uma classe `Email` que sobrescreve `equals()` para comparar o endereço de e-mail, mas não sobrescreve `hashCode()`. O desenvolvedor disse que "só usa a classe em `ArrayList`, então não precisa de `hashCode()`". Ele está correto? Em quais situações isso seria um problema? Explique o contrato entre `equals()` e `hashCode()`.

**O que essa pergunta avalia:**  
Compreensão profunda do contrato entre `equals()` e `hashCode()`, conhecimento de quando o `hashCode()` é necessário, e capacidade de identificar bugs sutis em coleções.

**Resposta esperada:**  
O desenvolvedor está **parcialmente correto** no contexto imediato, mas está criando uma **armadilha para o futuro**:

- `ArrayList` usa apenas `equals()` para verificar containment (`contains()`, `indexOf()`, `remove()`) — não usa `hashCode()`. Então, no `ArrayList`, o código funciona.
- Mas se amanhã alguém usar a classe `Email` em um `HashSet`, `HashMap` ou qualquer estrutura baseada em hash, o comportamento será incorreto: dois e-mails iguais por `equals()` podem acabar em buckets diferentes (porque `hashCode()` é o padrão de `Object`), e duplicatas serão inseridas silenciosamente.

**O contrato (da documentação de `Object`):**
1. Se `x.equals(y)` é `true`, então `x.hashCode() == y.hashCode()` deve ser obrigatoriamente `true`.
2. Se `x.equals(y)` é `false`, o `hashCode` pode ser igual ou diferente (não é obrigatório que sejam diferentes).
3. Se `hashCode()` de dois objetos é diferente, eles **obrigatoriamente** não são iguais por `equals()`.

Violar a regra 1 quebra coleções baseadas em hash.

**Explicação didática:**  
Pense no `hashCode()` como o código de barras de um produto e no `equals()` como uma verificação item a item. O `HashSet` primeiro escaneia o código de barras (`hashCode`) para encontrar a prateleira certa, depois verifica item a item (`equals`) na prateleira. Se você sobrescreve `equals()` mas não `hashCode()`, é como ter dois produtos idênticos com códigos de barras diferentes — o sistema os coloca em prateleiras diferentes e nunca percebe que são iguais. No `ArrayList`, não há prateleiras nem códigos de barras — o sistema verifica item a item diretamente, então funciona. Mas é uma bomba relógio.

**Exemplo prático:**  
A classe `Email` funciona em `ArrayList` hoje. Amanhã, um novo desenvolvedor cria um cache de e-mails usando `HashSet<Email>` para evitar duplicatas em um envio de newsletter. Como `hashCode()` não foi sobrescrito, e-mails duplicados são inseridos no `HashSet`, e a newsletter é enviada duas vezes para o mesmo destinatário.

**Exemplo de código:**  
```java
import java.util.*;

// ❌ Classe problemática — equals sem hashCode
class EmailSemHashCode {
    private String endereco;
    
    public EmailSemHashCode(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailSemHashCode)) return false;
        EmailSemHashCode email = (EmailSemHashCode) o;
        return endereco.equals(email.endereco);
    }
    // hashCode() NÃO sobrescrito — usa o de Object (endereço de memória)
}

// Demonstração do problema
public class DemonstracaoProblema {
    public void testar() {
        EmailSemHashCode e1 = new EmailSemHashCode("teste@email.com");
        EmailSemHashCode e2 = new EmailSemHashCode("teste@email.com");
        
        // ArrayList — funciona (usa apenas equals)
        List<EmailSemHashCode> lista = new ArrayList<>();
        lista.add(e1);
        System.out.println(lista.contains(e2)); // true ✅
        
        // HashSet — FALHA (usa hashCode + equals)
        Set<EmailSemHashCode> set = new HashSet<>();
        set.add(e1);
        System.out.println(set.contains(e2)); // false ❌ — buckets diferentes!
        System.out.println(set.size()); // Se adicionar e2: size = 2 (duplicata!)
    }
}

// ✅ Classe correta — equals e hashCode consistentes
class Email {
    private String endereco;
    
    public Email(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return endereco.equals(email.endereco);
    }
    
    @Override
    public int hashCode() {
        return endereco.hashCode(); // Mesmo campo usado em equals
    }
}

// Agora funciona em qualquer coleção
Set<Email> setCorreto = new HashSet<>();
setCorreto.add(new Email("teste@email.com"));
setCorreto.add(new Email("teste@email.com")); // Igual ao anterior
System.out.println(setCorreto.size()); // 1 ✅ — detectou duplicata
```

**Como o candidato deve responder:**  
- Confirmar que o desenvolvedor está correto para `ArrayList`, mas incorreto como prática geral.
- Explicar o contrato: `equals` true → `hashCode` igual é obrigatório.
- Mostrar que estruturas baseadas em hash (`HashSet`, `HashMap`) quebram sem `hashCode`.
- Mencionar que é uma "bomba relógio" — funciona hoje, quebra amanhã.
- Trazer o exemplo do cache de e-mails com `HashSet`.
- Recomendar sempre sobrescrever ambos juntos.
- Evitar dizer que "hashCode é opcional" — é opcional só no sentido de compilação, não de correção.

**Resposta fraca ou incompleta:**  
"Está errado, precisa sobrescrever `hashCode`." — Não explica quando é um problema e quando não é. Não menciona que `ArrayList` funciona, nem o contrato entre `equals` e `hashCode`.

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
1. O que acontece se você sobrescrever `hashCode()` mas não `equals()`?
2. É correto usar `endereco.hashCode()` diretamente, ou deveria usar `Objects.hash(endereco)`?
3. Por que o `hashCode` de dois objetos iguais deve ser igual, mas dois objetos diferentes podem ter o mesmo `hashCode` (colisão)?

---

##  34. <a name='Pergunta30ConvenesdeNamingeCleanCode'></a>Pergunta 30 — Convenções de Naming e Clean Code

**Nível:** Júnior  
**Categoria:** Boas Práticas

**Pergunta do entrevistador:**  
Em uma code review, você encontra o seguinte método em uma classe de serviço:

```java
public List<Object> proc(List<Object> d, boolean f) {
    List<Object> r = new ArrayList<>();
    for (Object o : d) {
        if (f) {
            if (o != null) {
                r.add(o);
            }
        } else {
            r.add(o);
        }
    }
    return r;
}
```

Quais problemas de legibilidade e design você identifica? Como você refatoraria esse código seguindo boas práticas de naming, clean code e uso de Generics?

**O que essa pergunta avalia:**  
Capacidade de identificar code smells (nomes ruins, uso de `Object`, lógica confusa), conhecimento de convenções de naming do Java, e habilidade de refatorar código para maior legibilidade e type safety.

**Resposta esperada:**  
**Problemas identificados:**
1. **Nomes não descritivos:** `proc`, `d`, `f`, `r`, `o` — não comunicam intenção.
2. **Uso de `Object`:** sem Generics, perde-se type safety e o chamador precisa fazer cast.
3. **Parâmetro booleano `f`:** não fica claro o que `true` ou `false` significa.
4. **Lógica confusa:** o `if (f)` no loop mistura comportamentos diferentes no mesmo método.
5. **Retorno `List<Object>`:** não diz nada sobre o conteúdo.
6. **Nomes não seguem convenções Java:** variáveis locais devem ser descritivas, não abreviações de uma letra.

**Refatoração:**
1. Renomear o método para comunicar a intenção: `filtrarNaoNulos` ou `removerNulos`.
2. Usar Generics: `List<T>` em vez de `List<Object>`.
3. Renomear parâmetros: `dados`, `ignorarNulos`.
4. Simplificar a lógica: se `ignorarNulos` é true, filtrar nulos; se false, retornar a lista como está.
5. Usar Streams API para maior legibilidade.

**Explicação didática:**  
Imagine que o código é uma receita culinária. A versão original é como uma receita escrita assim: "Pegue D, se F adicione O se O não for nada, senão adicione O. Retorne R." Você não sabe o que é D, F ou R. A versão refatorada é: "Pegue a lista de ingredientes. Se precisar remover os vazios, filtre-os. Caso contrário, retorne a lista completa." A receita se explica sozinha — você não precisa adivinhar nada.

**Exemplo prático:**  
Em um sistema de processamento de dados, um método recebe uma lista de registros e pode opcionalmente filtrar registros nulos (ex: em relatórios, nulos devem aparecer como "sem dado"; em importações, nulos devem ser removidos).

**Exemplo de código:**  
```java
import java.util.*;
import java.util.stream.Collectors;

// ❌ Código original — ilegível e sem type safety
public List<Object> proc(List<Object> d, boolean f) {
    List<Object> r = new ArrayList<>();
    for (Object o : d) {
        if (f) {
            if (o != null) {
                r.add(o);
            }
        } else {
            r.add(o);
        }
    }
    return r;
}

// ✅ Refatoração 1 — nomes descritivos e Generics
public <T> List<T> filtrarRemovendoNulos(List<T> elementos, 
                                           boolean removerNulos) {
    List<T> resultado = new ArrayList<>();
    for (T elemento : elementos) {
        if (!removerNulos || elemento != null) {
            resultado.add(elemento);
        }
    }
    return resultado;
}

// ✅ Refatoração 2 — separar em dois métodos (mais limpo)
public <T> List<T> removerNulos(List<T> elementos) {
    return elementos.stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
}

public <T> List<T> copiarLista(List<T> elementos) {
    return new ArrayList<>(elementos);
}

// ✅ Refatoração 3 — método único, Streams, com Optional no parâmetro
public <T> List<T> processarElementos(List<T> elementos, 
                                       boolean removerNulos) {
    if (elementos == null) {
        return Collections.emptyList();
    }
    
    if (!removerNulos) {
        return new ArrayList<>(elementos);
    }
    
    return elementos.stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
}

// Uso comparativo:
List<String> nomes = Arrays.asList("Ana", null, "Bruno", null, "Carla");

// ❌ Original — precisa de cast, nomes confusos
// List<Object> r = proc(nomes, true); // Quebra type safety

// ✅ Refatorado — type safe e legível
List<String> semNulos = filtrarRemovendoNulos(nomes, true);
// Resultado: ["Ana", "Bruno", "Carla"]

List<String> comNulos = filtrarRemovendoNulos(nomes, false);
// Resultado: ["Ana", null, "Bruno", null, "Carla"]
```

**Como o candidato deve responder:**  
- Listar os problemas: nomes não descritivos, uso de `Object`, parâmetro booleano ambíguo, lógica confusa.
- Propor renomeação: `proc` → `filtrarRemovendoNulos`, `d` → `elementos`, `f` → `removerNulos`.
- Introduzir Generics: `List<T>` em vez de `List<Object>`.
- Simplificar a lógica condicional.
- Mencionar a possibilidade de separar em dois métodos.
- Trazer o exemplo de processamento de registros.
- Evitar apenas dizer "renomear as variáveis" sem explicar por que e como.

**Resposta fraca ou incompleta:**  
"Renomear as variáveis para nomes mais claros." — Não menciona Generics, não identifica o problema do `Object`, não propõe refatoração da lógica, nem usa Streams.

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
1. Por que usar um parâmetro `boolean` é considerado um code smell (flag argument)?
2. O que é o princípio "Tell, Don't Ask" e como ele se aplica aqui?
3. Como o uso de Streams melhora ou piora a legibilidade neste caso?

---

##  35. <a name='ResumodaParte3'></a>📊 Resumo da Parte 3

| Item | Detalhe |
|---|---|
| **Perguntas apresentadas** | 21 a 30 |
| **Categorias cobertas** | Generics (21), Optional (22), Comparable/Comparator (23), Enums (24), java.time (25), Imutabilidade (26), Lambdas (27), Exceções encadeadas (28), equals/hashCode (29), Clean Code (30) |
| **Perguntas restantes** | 31 a 100 (70 perguntas) |

As próximas perguntas abordarão: wrappers e autoboxing, switch expressions, variáveis efetivamente final, métodos default em interfaces, hierarquia de exceções, formato de números e moeda, clonagem de objetos, mutabilidade em coleções, inner classes, e mais cenários de debugging e boas práticas.

Diga **"continuar"** e eu gero a Parte 4 com as perguntas 31 a 40.

---

# PARTE 4 — Perguntas 31 a 40

---

##  36. <a name='Pergunta31AutoboxingeUnboxing'></a>Pergunta 31 — Autoboxing e Unboxing

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Em um sistema de pontuação de clientes, você tem o seguinte código:

```java
Integer pontos = 100;
pontos += 50;
```

Um colega perguntou se esse código funciona corretamente, já que `pontos` é um objeto `Integer` e não um `int`. Outro colega disse ter ouvido falar de um bug estranho ao comparar dois `Integer` com `==`. Explique o que é autoboxing/unboxing, como o código acima funciona internamente e qual é a "armadilha" da comparação com `==` em wrappers.

**O que essa pergunta avalia:**  
Compreensão de autoboxing e unboxing, conhecimento do cache de wrappers Integer (-128 a 127), e capacidade de identificar bugs sutis relacionados à comparação de objetos wrapper.

**Resposta esperada:**  
**Autoboxing** é a conversão automática de um tipo primitivo para seu wrapper correspondente (`int` → `Integer`). **Unboxing** é o inverso (`Integer` → `int`). O compilador insere essas conversões automaticamente.

No código `Integer pontos = 100; pontos += 50;`:
1. `Integer pontos = 100;` → autoboxing: `Integer.valueOf(100)` cria um objeto `Integer`.
2. `pontos += 50;` → unboxing: `pontos.intValue()` extrai o valor `int`, soma 50, e depois autoboxing novamente: `Integer.valueOf(150)`.

**A armadilha do `==`:**
Java mantém um **cache** de objetos `Integer` para valores entre **-128 e 127** (especificado na JLS). Quando você cria um `Integer` dentro desse range usando `Integer.valueOf()`, o Java retorna a **mesma referência** do cache. Isso significa que `==` funciona para valores nesse range, mas **falha** para valores fora dele.

```java
Integer a = 100; // No cache → mesma referência
Integer b = 100;
a == b; // true — funciona por acaso (cache)

Integer c = 200; // Fora do cache → referências diferentes
Integer d = 200;
c == d; // false — armadilha!
```

**Explicação didática:**  
Pense no cache de `Integer` como uma gaveta com números pré-impressos de -128 a 127. Quando você pede o número 100, o atendente pega a cartolina já pronta na gaveta. Se você pedir duas vezes, recebe a **mesma cartolina**. Mas se pedir o número 200, não tem na gaveta — o atendente imprime uma nova cada vez, então duas cópias do 200 são cartões **diferentes**, mesmo com o mesmo número. Comparar com `==` compara o cartão físico (referência), não o número escrito nele.

**Exemplo prático:**  
Em um sistema de fidelidade, dois clientes têm 150 pontos cada um. Se o sistema comparar os pontos com `==` em vez de `.equals()`, o sistema pode dizer que os pontos são diferentes mesmo sendo iguais, causando bugs onde bônus não são aplicados corretamente.

**Exemplo de código:**  
```java
public class AutoboxingDemo {
    public void demonstrar() {
        // Autoboxing: int → Integer automaticamente
        Integer a = 100;      // Equivale a Integer.valueOf(100)
        Integer b = 100;      // Mesmo valor no cache
        
        // Unboxing: Integer → int automaticamente
        int primitivo = a;    // Equivale a a.intValue()
        
        // Operação mista — unboxing + soma + autoboxing
        a += 50;              // a.intValue() + 50 → Integer.valueOf(150)
        
        // ⚠️ Armadilha do ==
        System.out.println(a == b);           // true (ambos 100 no cache)
        
        Integer c = 200;     // Fora do cache (-128 a 127)
        Integer d = 200;
        System.out.println(c == d);           // false! Referências diferentes
        System.out.println(c.equals(d));      // true ✅ — compara conteúdo
        
        // Em coleções — autoboxing implícito
        List<Integer> lista = new ArrayList<>();
        lista.add(10);       // autoboxing: int 10 → Integer.valueOf(10)
        int valor = lista.get(0);  // unboxing: Integer → int
        
        // ⚠️ Armadilha em loop — muitos objetos criados
        Integer soma = 0;
        for (int i = 0; i < 1000; i++) {
            soma += i;       // A cada iteração: unboxing + soma + autoboxing
        }
        // Cria ~1000 objetos Integer desnecessariamente!
        // Melhor: usar int primitivo
        int somaPrimitiva = 0;
        for (int i = 0; i < 1000; i++) {
            somaPrimitiva += i;  // Sem autoboxing — mais eficiente
        }
    }
    
    // ✅ Boa prática: comparar wrappers com .equals()
    public boolean mesmosPontos(Integer p1, Integer p2) {
        if (p1 == null || p2 == null) return false;
        return p1.equals(p2);  // Sempre correto, independente do cache
    }
}
```

**Como o candidato deve responder:**  
- Explicar autoboxing (primitivo → wrapper) e unboxing (wrapper → primitivo) como conversões automáticas.
- Mostrar que `+=` faz unboxing, soma e re-autoboxing.
- Explicar o cache de Integer (-128 a 127) e por que `==` funciona nesse range.
- Mostrar que `==` falha para valores fora do range — sempre usar `.equals()`.
- Mencionar o impacto de performance de autoboxing em loops.
- Trazer o exemplo do sistema de fidelidade.
- Evitar dizer que "Integer é a mesma coisa que int".

**Resposta fraca ou incompleta:**  
"`Integer` é um objeto e `int` é primitivo, o Java converte automaticamente." — Não explica o cache, não menciona a armadilha do `==`, nem o impacto de performance em loops.

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
1. Por que o Java mantém esse cache de Integer — qual é a justificativa de design?
2. Outros wrappers (`Double`, `Float`) têm cache? Por que não?
3. Como o autoboxing pode causar `NullPointerException`?

---

##  37. <a name='Pergunta32For-eachvsForTradicionalcomndice'></a>Pergunta 32 — For-each vs For Tradicional com Índice

**Nível:** Júnior  
**Categoria:** Controle de Fluxo e Lógica

**Pergunta do entrevistador:**  
Em uma code review, você encontra um colega usando `for (int i = 0; i < lista.size(); i++)` para percorrer uma `List<String>`. Ele precisa apenas imprimir cada elemento, sem usar o índice para nada. Você sugere usar `for-each`. Ele pergunta: "Qual a diferença? O for tradicional não funciona?" Como você explicaria as vantagens do for-each e em quais situações o for tradicional ainda é necessário?

**O que essa pergunta avalia:**  
Capacidade de distinguir entre estruturas de iteração apropriadas, conhecimento de quando o for-each é superior e quando o for com índice é necessário, e compreensão de legibilidade de código.

**Resposta esperada:**  
O for tradicional **funciona**, mas o for-each é **preferível** quando não se precisa do índice, porque:

1. **Mais legível:** `for (String s : lista)` é mais claro que `for (int i = 0; i < lista.size(); i++) { String s = lista.get(i); }`.
2. **Menos propenso a erros:** não há risco de erro de off-by-one (`<=` vs `<`), nem de acessar índice errado.
3. **Funciona com qualquer `Iterable`:** o for-each funciona com `List`, `Set`, `Queue` e qualquer coleção que implemente `Iterable`. O for com índice só funciona com coleções que suportam acesso por índice (não funciona com `Set`).
4. **Não chama `size()` a cada iteração:** embora o JIT normalmente otimize isso, o for-each usa o iterator internamente, que é mais eficiente para algumas implementações de `List` (ex: `LinkedList`, onde `get(i)` é O(n)).

**Quando o for tradicional é necessário:**
- Precisa do índice (ex: para modificar o elemento na posição).
- Precisa iterar de trás para frente.
- Precisa pular elementos com base no índice.
- Precisa modificar a lista durante iteração (usando índices com cuidado).

**Explicação didática:**  
Imagine que você está lendo um livro. O for-each é como simplesmente virar as páginas uma a uma — você lê cada página sem se preocupar com o número. O for tradicional é como ler consultando o número de cada página: útil se você precisa saber em que página está ou pular páginas, mas desnecessário se só quer ler o conteúdo.

**Exemplo prático:**  
Em um sistema de listagem de produtos, o for-each é ideal para iterar e exibir cada produto. Mas se você precisa alterar o elemento na posição `i` da lista (ex: `lista.set(i, novoValor)`), o for com índice é necessário.

**Exemplo de código:**  
```java
import java.util.*;

public class IteracaoListas {
    
    // ✅ For-each — ideal quando não precisa do índice
    public void imprimirNomes(List<String> nomes) {
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
    
    // ✅ For-each também funciona com Set (for com índice NÃO funciona)
    public void imprimirSet(Set<String> nomes) {
        for (String nome : nomes) {
            System.out.println(nome);
        }
        // Set não tem get(i) — for tradicional não funciona!
    }
    
    // ⚠️ For tradicional — funciona mas é desnecessário aqui
    public void imprimirComIndiceDesnecessario(List<String> nomes) {
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i)); // get(i) em LinkedList é O(n)!
        }
    }
    
    // ✅ For tradicional — necessário quando se precisa do índice
    public void substituirElementos(List<String> nomes, String novoValor) {
        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i) == null) {
                nomes.set(i, novoValor); // Precisa do índice para set()
            }
        }
    }
    
    // ✅ For tradicional — iterar de trás para frente
    public void imprimirReverso(List<String> nomes) {
        for (int i = nomes.size() - 1; i >= 0; i--) {
            System.out.println(nomes.get(i));
        }
    }
    
    // ⚠️ Armadilha de performance com LinkedList
    public void demonstrarProblemaLinkedList() {
        // LinkedList: get(i) é O(n) — percorre do início a cada chamada
        LinkedList<String> lista = new LinkedList<>();
        lista.add("A"); lista.add("B"); lista.add("C");
        
        // ❌ O(n²) — cada get(i) percorre a lista desde o início
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i)); // O(n) por chamada!
        }
        
        // ✅ O(n) — for-each usa iterator, que caminha elemento a elemento
        for (String s : lista) {
            System.out.println(s); // O(1) por elemento
        }
    }
}
```

**Como o candidato deve responder:**  
- Explicar que o for-each é mais legível e menos propenso a erros.
- Mencionar que funciona com qualquer `Iterable` (incluindo `Set`).
- Explicar o problema de performance com `LinkedList` e `get(i)`.
- Identificar quando o for tradicional é necessário (índice, reverso, modificação).
- Trazer exemplo de quando cada um é adequado.
- Evitar dizer que o for tradicional é "errado" — é desnecessário quando não se precisa do índice.

**Resposta fraca ou incompleta:**  
"O for-each é mais fácil de ler." — Correto, mas não menciona que funciona com `Set`, não explica o problema de performance com `LinkedList`, nem quando o for tradicional é necessário.

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
1. Como o for-each funciona internamente? Qual interface ele usa?
2. Por que `LinkedList.get(i)` é O(n) e `ArrayList.get(i)` é O(1)?
3. É possível usar for-each com um array tradicional `int[]`?

---

##  38. <a name='Pergunta33Set:EliminandoDuplicatas'></a>Pergunta 33 — Set: Eliminando Duplicatas

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Em um sistema de importação de contatos, você recebe uma lista com milhares de e-mails, mas há muitos duplicados. Você precisa gerar uma lista sem duplicatas mantendo a ordem de chegada. Um colega sugere usar `Set`, mas ele usou `HashSet` e os e-mails saíram em ordem aleatória. Qual `Set` você usaria para manter a ordem de inserção? E se a ordem precisasse ser alfabética?

**O que essa pergunta avalia:**  
Conhecimento das diferentes implementações de `Set` (`HashSet`, `LinkedHashSet`, `TreeSet`), compreensão de quando cada uma é adequada, e capacidade de resolver um problema real de eliminação de duplicatas.

**Resposta esperada:**  
- **`HashSet`**: não mantém ordem — mais rápido (O(1) para add/contains), mas iteração em ordem imprevisível.
- **`LinkedHashSet`**: mantém a ordem de inserção — praticamente tão rápido quanto `HashSet`, mas usa uma lista encadeada interna para preservar a ordem.
- **`TreeSet`**: mantém ordem natural (alfabética para `String`) ou ordem definida por `Comparator` — um pouco mais lento (O(log n)) pois usa uma árvore rubro-negra internamente.

Para o cenário:
1. **Manter ordem de chegada:** `LinkedHashSet`.
2. **Ordem alfabética:** `TreeSet` (ou converter para lista e ordenar com `Collections.sort()`).

**Explicação didática:**  
Imagine três formas de organizar cartas de baralho:
- `HashSet`: você joga as cartas em uma mesa sem nenhuma ordem — pega rápido, mas quando olha, estão espalhadas aleatoriamente.
- `LinkedHashSet`: você coloca as cartas em uma fila, na ordem em que chegam — pega rápido e mantém a ordem de chegada.
- `TreeSet`: você coloca as cartas em um fichário alfabético — demora um pouco mais para colocar cada uma, mas sempre estão ordenadas quando você olha.

**Exemplo prático:**  
Um sistema de newsletter importa contatos de múltiplas fontes (CRM, planilha, API). Os e-mails chegam em uma ordem específica por prioridade da fonte. É necessário eliminar duplicatas preservando a prioridade de chegada — o primeiro e-mail duplicado a chegar é o que fica.

**Exemplo de código:**  
```java
import java.util.*;

public class DeduplicadorEmails {
    
    // ✅ Manter ordem de inserção — LinkedHashSet
    public List<String> removerDuplicatasOrdemInsercao(List<String> emails) {
        // LinkedHashSet: remove duplicatas e preserva ordem de chegada
        Set<String> set = new LinkedHashSet<>(emails);
        return new ArrayList<>(set);
    }
    
    // ✅ Ordem alfabética — TreeSet
    public List<String> removerDuplicatasOrdemAlfabetica(List<String> emails) {
        // TreeSet: remove duplicatas e mantém ordem natural (alfabética)
        Set<String> set = new TreeSet<>(emails);
        return new ArrayList<>(set);
    }
    
    // ✅ Ordem alfabética case-insensitive
    public List<String> removerDuplicatasCaseInsensitive(List<String> emails) {
        // TreeSet com comparator customizado
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(emails);
        return new ArrayList<>(set);
    }
    
    // Comparação visual
    public void demonstrar() {
        List<String> emails = Arrays.asList(
            "carlos@email.com",
            "ana@email.com",
            "carlos@email.com",  // duplicata
            "bruno@email.com",
            "ana@email.com"      // duplicata
        );
        
        System.out.println("Original: " + emails);
        // [carlos, ana, carlos, bruno, ana]
        
        System.out.println("HashSet: " + new HashSet<>(emails));
        // Ordem imprevisível, ex: [bruno, ana, carlos]
        
        System.out.println("LinkedHashSet: " + new LinkedHashSet<>(emails));
        // Mantém ordem: [carlos, ana, bruno]
        
        System.out.println("TreeSet: " + new TreeSet<>(emails));
        // Ordem alfabética: [ana, bruno, carlos]
    }
}

// Uso prático
List<String> importados = Arrays.asList(
    "joao@empresa.com",
    "maria@empresa.com",
    "joao@empresa.com",   // duplicata
    "pedro@empresa.com",
    "maria@empresa.com"   // duplicata
);

DeduplicadorEmails deduplicador = new DeduplicadorEmails();
List<String> unicos = deduplicador.removerDuplicatasOrdemInsercao(importados);
// Resultado: [joao, maria, pedro] — ordem de chegada preservada
```

**Como o candidato deve responder:**  
- Identificar que `HashSet` não mantém ordem.
- Propor `LinkedHashSet` para manter ordem de inserção.
- Propor `TreeSet` para ordem alfabética.
- Explicar as diferenças de performance: HashSet/LinkedHashSet O(1), TreeSet O(log n).
- Trazer o exemplo de importação de contatos.
- Mencionar o cuidado com case-insensitive (joao@ e JOAO@ seriam duplicatas?).
- Evitar sugerir verificar duplicatas manualmente com `lista.contains()` — é O(n) por verificação.

**Resposta fraca ou incompleta:**  
"Usar `Set` para remover duplicatas." — Não especifica qual `Set`, não diferencia as implementações, não menciona ordem.

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
1. Qual a estrutura interna do `HashSet`? Como ele usa o `hashCode`?
2. Qual a estrutura interna do `TreeSet`? Por que é O(log n)?
3. Como o `LinkedHashSet` mantém a ordem de inserção sem perder performance?

---

##  39. <a name='Pergunta34toStringeBoasPrticasdeDebug'></a>Pergunta 34 — toString() e Boas Práticas de Debug

**Nível:** Júnior  
**Categoria:** Boas Práticas

**Pergunta do entrevistador:**  
Você está debugando uma aplicação e imprime um objeto `Pedido` com `System.out.println(pedido)`, mas a saída é `Pedido@1b6d3586`. Por que isso acontece? Como você tornaria a saída mais útil para debug? O que aconteceria se essa classe fosse usada em logs de produção?

**O que essa pergunta avalia:**  
Compreensão do método `toString()` padrão de `Object`, conhecimento de como sobrescrevê-lo para debug, e entendimento do impacto em logging.

**Resposta esperada:**  
A saída `Pedido@1b6d3586` é o `toString()` padrão da classe `Object`, que retorna `NomeDaClasse@hashCodeHexadecimal`. Isso é inútil para debug, pois não mostra nenhum atributo do objeto.

A solução é sobrescrever `toString()` para retornar uma representação legível dos atributos principais. Em logs de produção, um `toString()` bem implementado permite identificar o objeto e seu estado sem precisar adicionar logs adicionais.

**Boas práticas:**
1. Incluir os atributos mais relevantes para identificação (ex: `id`, `status`, `valor`).
2. Não incluir dados sensíveis (senhas, tokens, dados pessoais como CPF).
3. Usar um formato consistente e legível.
4. Considerar usar ferramentas como Lombok (`@ToString`) ou o método `Objects.toString()`.

**Explicação didática:**  
Imagine que o `toString()` padrão é como um crachá que só tem o nome da empresa e um número de série — você sabe que é um "Funcionário #1234", mas não sabe o nome, cargo ou departamento. Sobrescrever `toString()` é como imprimir um crachá completo: nome, cargo, departamento e sala. Em uma emergência (debug), você consegue identificar a pessoa imediatamente sem precisar consultar outro sistema.

**Exemplo prático:**  
Em produção, um erro ocorre ao processar um pedido. O log contém `Processando pedido: Pedido@1b6d3586`. O desenvolvedor não sabe qual pedido causou o erro. Se o `toString()` fosse `Pedido{id=1234, status=ENVIADO, valor=250.0}`, o problema seria identificável imediatamente.

**Exemplo de código:**  
```java
import java.util.Objects;

// ❌ Sem toString() — saída inútil para debug
class PedidoSemToString {
    private Long id;
    private String status;
    private double valor;
    
    public PedidoSemToString(Long id, String status, double valor) {
        this.id = id;
        this.status = status;
        this.valor = valor;
    }
    // Saída: PedidoSemToString@1b6d3586 — inútil!
}

// ✅ Com toString() sobrescrito — saída útil
class Pedido {
    private Long id;
    private String cliente;
    private String status;
    private double valor;
    private String senha; // ⚠️ Dado sensível — NÃO incluir no toString
    
    public Pedido(Long id, String cliente, String status, 
                  double valor, String senha) {
        this.id = id;
        this.cliente = cliente;
        this.status = status;
        this.valor = valor;
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        return "Pedido{" +
            "id=" + id +
            ", cliente='" + cliente + '\'' +
            ", status='" + status + '\'' +
            ", valor=" + valor +
            // senha INTENCIONALMENTE omitida — não expor dados sensíveis
            '}';
    }
    // Saída: Pedido{id=1234, cliente='João', status='ENVIADO', valor=250.0}
}

// Uso
Pedido pedido = new Pedido(1234L, "João", "ENVIADO", 250.0, "minhaSenha123");
System.out.println(pedido);
// Saída: Pedido{id=1234, cliente='João', status='ENVIADO', valor=250.0}
// Senha não aparece! ✅

// Alternativa com String.format (mais limpo)
@Override
public String toString() {
    return String.format("Pedido[id=%d, cliente=%s, status=%s, valor=R$ %.2f]",
        id, cliente, status, valor);
}

// Alternativa com Objects.toString() (Java 7+)
@Override
public String toString() {
    return "Pedido{" +
        "id=" + Objects.toString(id, "null") +
        ", status=" + Objects.toString(status, "null") +
        ", valor=" + valor +
        "}";
}
```

**Como o candidato deve responder:**  
- Explicar que o `toString()` padrão retorna `Classe@hashCode`.
- Propor sobrescrita com atributos relevantes.
- Mencionar a importância de **não** incluir dados sensíveis.
- Explicar o impacto em logs de produção — facilita debug.
- Trazer o exemplo do pedido com senha omitida.
- Evitar apenas dizer "sobrescreva toString()" sem explicar o que incluir e o que omitir.

**Resposta fraca ou incompleta:**  
"Sobrescrever o `toString()`." — Não explica o que incluir, não menciona dados sensíveis, nem o impacto em logs.

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
1. Como o Lombok (`@ToString`) gera o `toString()` automaticamente? Que cuidado ele exige?
2. Por que incluir dados sensíveis no `toString()` é um risco de segurança?
3. Como o `toString()` interage com frameworks de logging como SLF4J?

---

##  40. <a name='Pergunta35HierarquiadeExcees'></a>Pergunta 35 — Hierarquia de Exceções

**Nível:** Júnior  
**Categoria:** Tratamento de Exceções

**Pergunta do entrevistador:**  
Em um projeto, você encontra a seguinte hierarquia de exceções customizadas:

```
RuntimeException
  └── BusinessException
        ├── ClienteNaoEncontradoException
        ├── SaldoInsuficienteException
        └── DocumentoInvalidoException
```

Todas herdam de `BusinessException`, que herda de `RuntimeException`. Um desenvolvedor perguntou por que todas são unchecked (`RuntimeException`) e não checked (`Exception`). Como você explicaria essa decisão de design? Quando faria sentido criar uma hierarquia de exceções em vez de exceções isoladas?

**O que essa pergunta avalia:**  
Compreensão da hierarquia de exceções em Java, capacidade de justificar decisões de design (checked vs unchecked em hierarquias), e conhecimento de como capturar exceções em diferentes níveis da hierarquia.

**Resposta esperada:**  
**Por que unchecked (RuntimeException)?**
- Exceções de negócio geralmente não são recuperáveis pelo chamador direto — um "saldo insuficiente" não é algo que o método chamador possa corrigir com try-catch.
- Usar unchecked evita poluir a assinatura de métodos com `throws` em múltiplas camadas.
- Frameworks modernos (Spring, Jakarta EE) tratam exceções unchecked globalmente (ex: `@ControllerAdvice` no Spring).

**Por que hierarquia?**
1. **Captura em diferentes níveis:** é possível capturar `BusinessException` para tratar todas as exceções de negócio de uma vez, ou capturar uma específica como `SaldoInsuficienteException` para tratamento individual.
2. **Organização:** agrupa exceções relacionadas, facilitando navegação e entendimento.
3. **Extensibilidade:** novas exceções de negócio herdam de `BusinessException` sem precisar modificar código que já captura a base.

**Explicação didática:**  
Pense na hierarquia como um organograma de uma empresa. No topo está o diretor (`BusinessException`). Abaixo dele, três gerentes: um de clientes, um de saldo, um de documentos. Se você precisa tratar um problema específico, fala direto com o gerente (`catch SaldoInsuficienteException`). Se quer tratar qualquer problema de negócio, fala com o diretor (`catch BusinessException`). Se fosse checked, seria como exigir que toda reunião tenha um representante presente — na prática, a maioria das pessoas não tem o que dizer sobre o problema, mas ainda assim são obrigadas a comparecer.

**Exemplo prático:**  
Em uma API REST de transferência bancária, o controller pode capturar `SaldoInsuficienteException` e retornar HTTP 422 (Unprocessable Entity), enquanto captura `BusinessException` genérica e retorna HTTP 400 (Bad Request). Se for `DocumentoInvalidoException`, retorna HTTP 422 com mensagem específica de validação.

**Exemplo de código:**  
```java
// Hierarquia de exceções de negócio
public class BusinessException extends RuntimeException {
    public BusinessException(String mensagem) {
        super(mensagem);
    }
    
    public BusinessException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

public class ClienteNaoEncontradoException extends BusinessException {
    public ClienteNaoEncontradoException(Long id) {
        super("Cliente não encontrado: ID=" + id);
    }
}

public class SaldoInsuficienteException extends BusinessException {
    public SaldoInsuficienteException(double saldoAtual, double valorSolicitado) {
        super(String.format("Saldo insuficiente: disponível R$ %.2f, solicitado R$ %.2f",
            saldoAtual, valorSolicitado));
    }
}

public class DocumentoInvalidoException extends BusinessException {
    public DocumentoInvalidoException(String documento, String motivo) {
        super("Documento inválido: " + documento + " — " + motivo);
    }
}

// Serviço que lança exceções específicas
public class TransferenciaService {
    public void transferir(Long origemId, Long destinoId, double valor) {
        Cliente origem = buscarCliente(origemId); // pode lançar ClienteNaoEncontrado
        
        if (origem.getSaldo() < valor) {
            throw new SaldoInsuficienteException(
                origem.getSaldo(), valor);
        }
        // ... processar transferência
    }
    
    private Cliente buscarCliente(Long id) {
        Cliente cliente = repository.findById(id);
        if (cliente == null) {
            throw new ClienteNaoEncontradoException(id);
        }
        return cliente;
    }
}

// Controller — captura em diferentes níveis da hierarquia
public class TransferenciaController {
    
    public Response transferir(TransferenciaDTO dto) {
        try {
            service.transferir(dto.getOrigem(), dto.getDestino(), dto.getValor());
            return Response.ok("Transferência realizada").build();
            
        } catch (SaldoInsuficienteException e) {
            // Tratamento específico — HTTP 422
            return Response.status(422)
                .entity(e.getMessage())
                .build();
                
        } catch (ClienteNaoEncontradoException e) {
            // Tratamento específico — HTTP 404
            return Response.status(404)
                .entity(e.getMessage())
                .build();
                
        } catch (BusinessException e) {
            // Captura genérica — qualquer outra exceção de negócio — HTTP 400
            return Response.status(400)
                .entity(e.getMessage())
                .build();
        }
        // Ordem importa: específicas primeiro, genérica por último!
    }
}
```

**Como o candidato deve responder:**  
- Explicar que exceções de negócio como unchecked evitam poluir assinaturas de métodos.
- Justificar a hierarquia: captura em diferentes níveis, organização, extensibilidade.
- Mostrar a ordem de catch: específicas primeiro, genérica (`BusinessException`) por último.
- Mencionar que a ordem dos catchs importa — se `BusinessException` vier primeiro, as específicas nunca serão alcançadas (código não compila).
- Trazer o exemplo da API REST com códigos HTTP.
- Evitar dizer que checked exceptions são sempre erradas — é uma decisão de design.

**Resposta fraca ou incompleta:**  
"Usar unchecked porque é mais fácil." — Não justifica a decisão, não explica os benefícios da hierarquia, nem mostra captura em diferentes níveis.

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
1. O que acontece se você colocar `catch (BusinessException)` antes de `catch (SaldoInsuficienteException)`?
2. Quando faria sentido criar exceções checked em vez de unchecked?
3. Como o polimorfismo se aplica ao catch de exceções?

---

##  41. <a name='Pergunta36ValidaodeParmetroseFail-Fast'></a>Pergunta 36 — Validação de Parâmetros e Fail-Fast

**Nível:** Júnior  
**Categoria:** Boas Práticas

**Pergunta do entrevistador:**  
Você está revisando um método de cadastro de produto que recebe `nome`, `preco` e `categoria` como parâmetros. O método não valida nenhum dos parâmetros — simplesmente os atribui aos campos. Em produção, já houve bugs com produtos cadastrados com preço negativo e nome vazio. Como você implementaria validação no método? O que é o princípio "fail-fast" e por que ele é importante?

**O que essa pergunta avalia:**  
Conhecimento do princípio fail-fast, capacidade de implementar validação de parâmetros, e compreensão de por que validar na entrada evita bugs em cascata.

**Resposta esperada:**  
O princípio **fail-fast** significa detectar e reportar erros o mais cedo possível — idealmente no momento em que os dados entram no sistema, em vez de deixar o erro propagar e se manifestar em outro lugar (às vezes muito tempo depois).

Para o método de cadastro:
1. Validar **todos** os parâmetros no início do método.
2. Se qualquer parâmetro for inválido, lançar `IllegalArgumentException` imediatamente.
3. Só prosseguir com a lógica do método se **todos** os parâmetros forem válidos.

**Benefícios do fail-fast:**
- O erro é detectado na origem, não em um ponto distante.
- A stack trace aponta exatamente onde o dado inválido entrou.
- Evita estado inconsistente (ex: produto com preço negativo persistido no banco).
- Facilita debugging — o desenvolvedor sabe exatamente qual parâmetro estava errado.

**Explicação didática:**  
Imagine uma fábrica de automóveis. Se um parafuso defeituoso entra na linha de montagem e ninguém verifica, ele vai parar no carro finalizado — e o problema só é descoberto quando o cliente dirige e ouve um barulho estranho. O fail-fast é como ter um inspetor na entrada da fábrica que verifica cada parafuso antes de ele entrar na linha. Se o parafuso está com defeito, a linha para imediatamente, o problema é corrigido na hora, e não chega ao cliente.

**Exemplo prático:**  
Em um sistema de e-commerce, um produto é cadastrado com preço `-50.0`. Sem validação, o produto vai para o banco de dados. Quando o cliente adiciona ao carrinho, o sistema calcula o total como negativo (credito ao cliente). Quando o pagamento é processado, o gateway rejeita o valor negativo. O erro só é descoberto dias depois, com um cliente irritado. Com fail-fast, o cadastro é rejeitado na hora.

**Exemplo de código:**  
```java
import java.util.Objects;

public class CadastroProduto {
    
    // ❌ Sem validação — aceita qualquer coisa
    public Produto cadastrarSemValidacao(String nome, double preco, 
                                         String categoria) {
        Produto p = new Produto();
        p.setNome(nome);       // Pode ser null ou vazio
        p.setPreco(preco);     // Pode ser negativo!
        p.setCategoria(categoria); // Pode ser null
        repository.save(p);
        return p;
    }
    
    // ✅ Com validação fail-fast
    public Produto cadastrar(String nome, double preco, String categoria) {
        // Validação imediata — fail fast na entrada
        Objects.requireNonNull(nome, "Nome não pode ser null");
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        
        if (preco <= 0) {
            throw new IllegalArgumentException(
                "Preço deve ser positivo. Recebido: " + preco);
        }
        
        Objects.requireNonNull(categoria, "Categoria não pode ser null");
        if (categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria não pode ser vazia");
        }
        
        // Só chega aqui se todos os parâmetros são válidos
        Produto produto = new Produto();
        produto.setNome(nome.trim());
        produto.setPreco(preco);
        produto.setCategoria(categoria.trim());
        repository.save(produto);
        return produto;
    }
    
    // ✅ Alternativa: validar no construtor do próprio objeto
    public Produto cadastrarComConstrutor(String nome, double preco, 
                                          String categoria) {
        // O construtor do Produto já valida — fail fast na criação
        return repository.save(new Produto(nome, preco, categoria));
    }
}

// Produto com validação no construtor
class Produto {
    private final String nome;
    private final double preco;
    private final String categoria;
    
    public Produto(String nome, double preco, String categoria) {
        // Todas as validações no construtor — não permite objeto inválido
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser positivo");
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria é obrigatória");
        }
        
        this.nome = nome.trim();
        this.preco = preco;
        this.categoria = categoria.trim();
    }
}
```

**Como o candidato deve responder:**  
- Explicar o princípio fail-fast: detectar erros o mais cedo possível.
- Mostrar validação de cada parâmetro no início do método.
- Usar `IllegalArgumentException` ou `NullPointerException` (via `Objects.requireNonNull`).
- Justificar: evita bugs em cascata, facilita debugging, previne dados inconsistentes.
- Mencionar a alternativa de validar no construtor do próprio objeto.
- Trazer o exemplo do produto com preço negativo.
- Evitar apenas sugerir `if (nome != null)` sem tratar os outros casos.

**Resposta fraca ou incompleta:**  
"Adicionar `if (preco < 0) return null;` no início do método." — Retornar `null` em vez de lançar exceção mascara o erro. O chamador pode ignorar o `null` e o problema se propaga silenciosamente.

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
1. Por que lançar exceção é melhor que retornar `null` ou um código de erro?
2. Qual a diferença entre `Objects.requireNonNull()` e verificar `if (x == null)` manualmente?
3. Como frameworks como Spring Boot validam parâmetros (ex: `@Valid`, Bean Validation)?

---

##  42. <a name='Pergunta37Map:getOrDefaulteputIfAbsent'></a>Pergunta 37 — Map: getOrDefault e putIfAbsent

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Você está implementando um contador de palavras: recebe uma lista de palavras e precisa contar quantas vezes cada palavra aparece. Um colega escreveu o seguinte código:

```java
Map<String, Integer> contagem = new HashMap<>();
for (String palavra : palavras) {
    if (contagem.containsKey(palavra)) {
        contagem.put(palavra, contagem.get(palavra) + 1);
    } else {
        contagem.put(palavra, 1);
    }
}
```

Funciona, mas faz três acessos ao mapa (containsKey, get, put) por iteração. Como você simplificaria esse código usando métodos da API de `Map`?

**O que essa pergunta avalia:**  
Conhecimento dos métodos utilitários do `Map` (`getOrDefault`, `putIfAbsent`, `merge`, `compute`), e capacidade de refatorar código para ser mais conciso e eficiente.

**Resposta esperada:**  
Existem várias formas de simplificar:

**1. Usando `getOrDefault`:**
```java
contagem.put(palavra, contagem.getOrDefault(palavra, 0) + 1);
```
Um acesso ao mapa em vez de três. `getOrDefault` retorna o valor se a chave existe, ou o valor padrão (0) se não existe.

**2. Usando `merge` (mais elegante):**
```java
contagem.merge(palavra, 1, Integer::sum);
```
`merge` verifica se a chave existe: se não, insere com valor 1; se existe, aplica a função (`Integer::sum`) ao valor atual e ao novo valor (1).

**3. Usando `compute`:**
```java
contagem.compute(palavra, (k, v) -> v == null ? 1 : v + 1);
```
`compute` recebe a chave e uma função que recebe a chave e o valor atual (ou `null`), retornando o novo valor.

**Explicação didática:**  
O código original é como ir a um armário, verificar se há uma pasta, voltar para pegar a pasta, contar o que tem dentro, voltar para guardar de novo — três viagens. `getOrDefault` é como ir ao armário uma vez: se a pasta está lá, pega; se não, pega uma folha em branco. `merge` é ainda melhor: você diz "adicione 1 à pasta, ou crie uma nova com 1" — o armário faz tudo sozinho.

**Exemplo prático:**  
Um sistema de análise de logs que conta quantas vezes cada nível de log (INFO, WARN, ERROR) aparece em um arquivo. Cada linha é processada e o contador é incrementado. Com `merge`, o código fica de uma linha e é eficiente.

**Exemplo de código:**  
```java
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class ContadorPalavras {
    
    // ❌ Original — três acessos por iteração
    public Map<String, Integer> contarV1(List<String> palavras) {
        Map<String, Integer> contagem = new HashMap<>();
        for (String palavra : palavras) {
            if (contagem.containsKey(palavra)) {
                contagem.put(palavra, contagem.get(palavra) + 1);
            } else {
                contagem.put(palavra, 1);
            }
        }
        return contagem;
    }
    
    // ✅ getOrDefault — um acesso por iteração
    public Map<String, Integer> contarV2(List<String> palavras) {
        Map<String, Integer> contagem = new HashMap<>();
        for (String palavra : palavras) {
            contagem.put(palavra, contagem.getOrDefault(palavra, 0) + 1);
        }
        return contagem;
    }
    
    // ✅ merge — mais elegante e conciso
    public Map<String, Integer> contarV3(List<String> palavras) {
        Map<String, Integer> contagem = new HashMap<>();
        for (String palavra : palavras) {
            // Se chave não existe: insere (palavra, 1)
            // Se chave existe: aplica Integer::sum(valorAtual, 1)
            contagem.merge(palavra, 1, Integer::sum);
        }
        return contagem;
    }
    
    // ✅ Streams API — funcional e declarativo
    public Map<String, Integer> contarV4(List<String> palavras) {
        return palavras.stream()
            .collect(Collectors.groupingBy(
                Function.identity(),  // chave = a própria palavra
                Collectors.counting() // valor = contagem
            ));
    }
    
    // Demonstração
    public void demonstrar() {
        List<String> palavras = Arrays.asList(
            "java", "python", "java", "rust", "java", "python"
        );
        
        System.out.println(contarV3(palavras));
        // {python=2, java=3, rust=1}
    }
}
```

**Como o candidato deve responder:**  
- Identificar que o código original faz três acessos ao mapa por iteração.
- Propor `getOrDefault` como simplificação (um acesso).
- Propor `merge` como a solução mais elegante.
- Mencionar a alternativa com Streams (`groupingBy` + `counting`).
- Explicar o comportamento de `merge`: se chave não existe, insere; se existe, aplica a função.
- Trazer o exemplo de análise de logs.
- Evitar apenas dizer "use Streams" sem mostrar a alternativa com `Map.merge`.

**Resposta fraca ou incompleta:**  
"Usar Streams para contar." — Funciona, mas não responde à pergunta sobre simplificar o código com métodos de `Map`. Não mostra `getOrDefault` nem `merge`.

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
1. Qual a diferença entre `putIfAbsent` e `computeIfAbsent`?
2. O que `merge` faz quando a função retorna `null`?
3. Como `Collectors.groupingBy` funciona internamente?

---

##  43. <a name='Pergunta38SwitchStatement:BoasPrticaseFall-through'></a>Pergunta 38 — Switch Statement: Boas Práticas e Fall-through

**Nível:** Júnior  
**Categoria:** Controle de Fluxo e Lógica

**Pergunta do entrevistador:**  
Um colega escreveu um método que processa o status de um pedido usando `switch`, mas esqueceu alguns `break` e o código executou casos errados (fall-through). Ele também não incluiu um `default`. Como você explicaria o comportamento de fall-through em `switch`? Como reescreveria o código para ser seguro? O que mudou com o switch expression (Java 14+)?

**O que essa pergunta avalia:**  
Compreensão do comportamento fall-through do `switch` tradicional, conhecimento de boas práticas (sempre usar `break` ou `default`), e familiaridade com switch expression (Java 14+).

**Resposta esperada:**  
**Fall-through:** No `switch` tradicional, se um `case` não tem `break`, a execução "cai" para o próximo `case`, executando seu código mesmo que o valor não corresponda. Isso é um comportamento herdado do C/C++ que é frequente fonte de bugs.

**Boas práticas:**
1. Sempre usar `break` no final de cada `case` (a menos que o fall-through seja intencional e documentado).
2. Sempre incluir `default` para tratar valores inesperados.
3. Considerar usar `if-else` ou polimorfismo (enums com métodos) quando há muitos casos.

**Switch Expression (Java 14+):**
- Sem fall-through — cada `case` é uma expressão que retorna valor.
- Sintaxe mais concisa com `->` em vez de `:`.
- Não precisa de `break`.
- O compilador verifica se todos os casos são cobertos (ex: todos os valores de um enum).

**Explicação didática:**  
O `switch` tradicional é como um edifício com vários andares e escadas abertas entre eles. Se você entra no andar 2 e não fecha a porta (`break`), você desce a escada e acaba entrando no andar 3, 4, etc. O switch expression é como um edifício com portas automáticas: você entra no andar certo, faz o que precisa, e a porta se fecha sozinha — sem risco de cair para outro andar.

**Exemplo prático:**  
Um sistema que aplica descontos baseados no status do cliente: VIP recebe 20%, OURO 15%, PRATA 10%. Com fall-through acidental, um cliente PRATA poderia receber 20% de desconto (executando todos os casos acumulados).

**Exemplo de código:**  
```java
// ❌ Switch tradicional com fall-through acidental
public double calcularDescontoFallThrough(String status, double valor) {
    double desconto = 0;
    switch (status) {
        case "VIP":
            desconto = 0.20;
            // ESQUECEU O break! — cai para o próximo caso
        case "OURO":
            desconto = 0.15;
            // ESQUECEU O break! — cai para o próximo caso
        case "PRATA":
            desconto = 0.10;
            // ESQUECEU O break!
        default:
            desconto = 0.0;
    }
    // Um cliente VIP recebe 0% de desconto! (fall-through até default)
    return valor * desconto;
}

// ✅ Switch tradicional corrigido — com break e default
public double calcularDescontoCorreto(String status, double valor) {
    double desconto;
    switch (status) {
        case "VIP":
            desconto = 0.20;
            break;  // ✅ break evita fall-through
        case "OURO":
            desconto = 0.15;
            break;
        case "PRATA":
            desconto = 0.10;
            break;
        default:
            desconto = 0.0;
            // break opcional no default, mas recomendado por consistência
    }
    return valor * desconto;
}

// ✅ Switch expression (Java 14+) — sem fall-through, retorna valor
public double calcularDescontoExpression(String status, double valor) {
    double desconto = switch (status) {
        case "VIP" -> 0.20;
        case "OURO" -> 0.15;
        case "PRATA" -> 0.10;
        default -> 0.0;
    };
    return valor * desconto;
}

// ✅ Switch expression com enum — compilador verifica exaustividade
public enum StatusCliente {
    VIP, OURO, PRATA
}

public double calcularDescontoEnum(StatusCliente status, double valor) {
    double desconto = switch (status) {
        case VIP -> 0.20;
        case OURO -> 0.15;
        case PRATA -> 0.10;
        // Sem default! Compilador verifica que todos os casos são cobertos
    };
    return valor * desconto;
}

// ✅ Switch expression com bloco (quando precisa de lógica)
public String processarPedido(StatusPedido status) {
    return switch (status) {
        case AGUARDANDO_PAGAMENTO -> "Aguardando confirmação de pagamento";
        case PAGAMENTO_CONFIRMADO -> {
            System.out.println("Notificando cliente...");
            yield "Pedido confirmado e em preparação";
        }
        case ENVIADO -> "Pedido a caminho";
        case ENTREGUE -> "Pedido entregue com sucesso";
        case CANCELADO -> "Pedido cancelado";
    };
}
```

**Como o candidato deve responder:**  
- Explicar o fall-through: sem `break`, a execução continua nos próximos cases.
- Mostrar que esquecer `break` causa bugs difíceis de detectar.
- Sempre incluir `default` para tratar valores inesperados.
- Mencionar switch expression (Java 14+) como alternativa sem fall-through.
- Mostrar que switch expression com enum verifica exaustividade.
- Trazer o exemplo de descontos por status de cliente.
- Evitar dizer que `switch` é sempre ruim — com as práticas corretas é útil.

**Resposta fraca ou incompleta:**  
"Adicionar `break` em cada `case`." — Correto, mas não explica o porquê do fall-through, não menciona `default`, nem o switch expression.

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
1. Em quais situações o fall-through é intencional e útil?
2. Qual a diferença entre `yield` e `return` dentro de um switch expression?
3. Por que usar enums no switch é mais seguro que usar Strings?

---

##  44. <a name='Pergunta39ListvsSet:EscolhendoaEstruturaCorreta'></a>Pergunta 39 — List vs Set: Escolhendo a Estrutura Correta

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Você está desenvolvendo um sistema de gerenciamento de tarefas. Em uma parte do sistema, você precisa armazenar as tags de uma tarefa (ex: "urgente", "frontend", "bug"). Em outra parte, precisa armazenar o histórico de alterações de uma tarefa, onde cada alteração deve ser preservada na ordem em que ocorreu, incluindo repetições (a tarefa pode ser alterada para "urgente" várias vezes ao longo do dia). Qual estrutura de dados você usaria em cada caso e por que?

**O que essa pergunta avalia:**  
Capacidade de escolher entre `List` e `Set` baseando-se nos requisitos do problema, compreensão das características de cada estrutura (ordem, duplicatas, performance), e raciocínio sobre trade-offs.

**Resposta esperada:**  
**Tags da tarefa:** Usar `Set<String>` (preferencialmente `LinkedHashSet` ou `HashSet`).
- Tags não devem ter duplicatas — não faz sentido ter "urgente" duas vezes.
- `Set` garante automaticamente que não há duplicatas.
- Se a ordem de exibição importar, usar `LinkedHashSet`.

**Histórico de alterações:** Usar `List<Alteracao>` (preferencialmente `ArrayList`).
- O histórico deve preservar a ordem cronológica.
- Duplicatas são válidas — a tarefa pode ser marcada como "urgente" várias vezes.
- `List` mantém ordem de inserção e permite elementos repetidos.

**Explicação didática:**  
Pense nas tags como categorias em um sistema de organização de documentos. Não faz sentido colar a etiqueta "urgente" duas vezes no mesmo documento — uma já é suficiente. O `Set` é como um carimbo que só marca uma vez cada categoria. Já o histórico é como um diário de bordo: você registra cada evento na ordem em que acontece, e o mesmo evento pode se repetir (a pessoa entrou, saiu, entrou de novo). O `List` é como um caderno onde cada página é uma entrada, em ordem, com repetições permitidas.

**Exemplo prático:**  
Em um sistema de tickets de suporte (ex: Jira), cada ticket tem tags (`Set`) para categorização, e um histórico de mudanças (`List`) que registra quem alterou, o quê, e quando. Se o ticket é marcado como "urgente", desmarcado, e marcado novamente, o histórico mostra todas as três ações em ordem.

**Exemplo de código:**  
```java
import java.util.*;

// Classe para representar uma alteração no histórico
class Alteracao {
    private String campo;
    private String valorAntigo;
    private String valorNovo;
    private Date timestamp;
    
    public Alteracao(String campo, String valorAntigo, 
                     String valorNovo) {
        this.campo = campo;
        this.valorAntigo = valorAntigo;
        this.valorNovo = valorNovo;
        this.timestamp = new Date();
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s: %s → %s", 
            timestamp, campo, valorAntigo, valorNovo);
    }
}

class Tarefa {
    private String titulo;
    
    // Tags — Set: sem duplicatas, não importa ordem
    private Set<String> tags = new HashSet<>();
    
    // Histórico — List: com ordem, permite repetições
    private List<Alteracao> historico = new ArrayList<>();
    
    public void adicionarTag(String tag) {
        // Set.add retorna false se a tag já existe — não duplica
        if (tags.add(tag)) {
            historico.add(new Alteracao("tag", null, tag));
        }
    }
    
    public void removerTag(String tag) {
        if (tags.remove(tag)) {
            historico.add(new Alteracao("tag", tag, null));
        }
    }
    
    public void alterarTitulo(String novoTitulo) {
        String tituloAntigo = this.titulo;
        this.titulo = novoTitulo;
        // Histórico sempre registra, mesmo se repetido
        historico.add(new Alteracao("titulo", tituloAntigo, novoTitulo));
    }
    
    public void imprimirResumo() {
        System.out.println("Tarefa: " + titulo);
        System.out.println("Tags: " + tags);
        System.out.println("Histórico:");
        for (Alteracao alt : historico) {
            System.out.println("  " + alt);
        }
    }
}

// Uso
Tarefa tarefa = new Tarefa();
tarefa.alterarTitulo("Corrigir bug de login");
tarefa.adicionarTag("urgente");
tarefa.adicionarTag("frontend");
tarefa.adicionarTag("urgente");  // Não duplica — Set ignora
tarefa.removerTag("urgente");
tarefa.adicionarTag("urgente");  // Re-adicionada — novo evento no histórico

tarefa.imprimirResumo();
// Tags: [frontend, urgente] — sem duplicatas
// Histórico: 5 entradas em ordem cronológica, incluindo repetições de "urgente"
```

**Como o candidato deve responder:**  
- Identificar que tags não devem ter duplicatas → `Set`.
- Identificar que histórico precisa de ordem e permite repetições → `List`.
- Justificar cada escolha com base nos requisitos.
- Mencionar que `Set.add()` retorna `boolean` indicando se adicionou.
- Trazer o exemplo de tickets de suporte (Jira).
- Evitar usar `List` para tags (requer verificação manual de duplicatas) ou `Set` para histórico (perde repetições).

**Resposta fraca ou incompleta:**  
"Usar `List` para os dois." — Funciona, mas para tags seria necessário verificar duplicatas manualmente (`if (!tags.contains(tag)) tags.add(tag)`), o que é O(n) por verificação. `Set` faz isso automaticamente em O(1).

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
1. Qual a diferença de performance entre `List.contains()` (O(n)) e `Set.contains()` (O(1))?
2. Quando faria sentido usar `LinkedHashSet` em vez de `HashSet` para as tags?
3. Qual a diferença entre `ArrayList` e `LinkedList` para armazenar o histórico?

---

##  45. <a name='Pergunta40VariveisFinaleEfectivamenteFinal'></a>Pergunta 40 — Variáveis Final e Efectivamente Final

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você tem o seguinte código:

```java
public void processar(List<String> nomes) {
    String prefixo = "Sr. ";
    nomes.forEach(nome -> System.out.println(prefixo + nome));
}
```

O código funciona, mas `prefixo` não está declarado como `final`. Um colega perguntou se deveria adicionar `final`. Outro colega disse que lambdas não podem acessar variáveis não-final. Esclareça: o que é uma variável "efetivamente final"? Por que lambdas exigem essa restrição? O que acontece se você tentar modificar `prefixo` dentro do lambda?

**O que essa pergunta avalia:**  
Compreensão do conceito de "efetivamente final" (effectively final), conhecimento das restrições de captura de variáveis em lambdas, e entendimento de por que essas restrições existem.

**Resposta esperada:**  
Uma variável é **efetivamente final** se seu valor nunca é alterado após a inicialização, mesmo sem a palavra-chave `final`. O compilador trata variáveis efetivamente finais como se fossem `final`, permitindo que sejam usadas em lambdas e classes anônimas.

**Por que lambdas exigem essa restrição?**
- Lambdas capturam o **valor** da variável no momento da criação, não a referência.
- Se a variável pudesse ser modificada depois, o lambda poderia usar um valor desatualizado, causando bugs difíceis de detectar.
- Em ambiente multi-thread, a variável capturada pode ser usada após o método ter terminado — se fosse mutável, não haveria garantia de visibilidade entre threads.

**O que acontece se tentar modificar `prefixo` dentro do lambda?**
- O código não compila. O compilador reporta: "Local variables referenced from a lambda expression must be final or effectively final."

**Por que adicionar `final` explicitamente?**
- Funciona sem `final` se a variável for efetivamente final.
- Mas adicionar `final` explicitamente é uma **boa prática** — documenta a intenção de que a variável não deve mudar, e o compilador detecta imediatamente se alguém tentar modificá-la.

**Explicação didática:**  
Imagine que um lambda é como uma fotografia tirada no momento em que é criado. A variável capturada é como o objeto na foto — o lambda "vê" o valor como era naquele instante. Se você pudesse modificar a variável depois, seria como tentar mudar o objeto depois que a foto foi tirada — a foto não mudaria, mas você teria duas versões diferentes da "verdade", causando confusão. A restrição garante que a foto e a realidade sempre correspondem.

**Exemplo prático:**  
Em um sistema de processamento de pedidos, um loop cria lambdas para processar cada pedido com um ID de lote. Se o ID do lote fosse mutável e modificado dentro do loop, todos os lambdas capturariam o mesmo ID (o último valor), processando todos os pedidos no lote errado.

**Exemplo de código:**  
```java
import java.util.*;

public class ExemploEffectivelyFinal {
    
    // ✅ Variável efetivamente final — funciona em lambda
    public void processarOk(List<String> nomes) {
        String prefixo = "Sr. ";  // Nunca modificada → efetivamente final
        nomes.forEach(nome -> System.out.println(prefixo + nome));
    }
    
    // ✅ Com final explícito — documenta a intenção
    public void processarComFinal(List<String> nomes) {
        final String prefixo = "Sr. ";
        nomes.forEach(nome -> System.out.println(prefixo + nome));
    }
    
    // ❌ NÃO é efetivamente final — não compila!
    public void processarErro(List<String> nomes) {
        String prefixo = "Sr. ";
        prefixo = "Sra. ";  // Modificada → não é efetivamente final
        // Erro de compilação: Local variables referenced from a lambda 
        // expression must be final or effectively final
        nomes.forEach(nome -> System.out.println(prefixo + nome));
    }
    
    // ❌ Tentar modificar dentro do lambda — não compila!
    public void processarModificandoNoLambda(List<String> nomes) {
        String prefixo = "Sr. ";
        nomes.forEach(nome -> {
            // prefixo = "Sra. "; // Erro de compilação!
            System.out.println(prefixo + nome);
        });
    }
    
    // ✅ Alternativa: usar variável effectively final nova
    public void processarComCondicao(List<String> nomes, boolean feminino) {
        // Cria nova variável que é efetivamente final
        String prefixo = feminino ? "Sra. " : "Sr. ";
        // prefixo nunca é modificado depois → efetivamente final
        nomes.forEach(nome -> System.out.println(prefixo + nome));
    }
    
    // ⚠️ Armadilha com loop — variável de iteração NÃO é efetivamente final
    public void armadilhaLoop() {
        for (int i = 0; i < 3; i++) {
            // i é modificada pelo for (i++) — não é efetivamente final!
            // Runnable r = () -> System.out.println(i); // Erro de compilação!
        }
        
        // ✅ Solução: criar cópia efetivamente final
        for (int i = 0; i < 3; i++) {
            final int copia = i;  // Nova variável, nunca modificada
            Runnable r = () -> System.out.println(copia); // Funciona!
            r.run();
        }
    }
    
    // ✅ Campos de instância NÃO precisam ser efetivamente final
    private String saudacao = "Olá";
    
    public void usarCampoInstancia(List<String> nomes) {
        // Campos de instância podem ser acessados e modificados
        // pois o lambda captura a referência ao objeto (this), não o valor
        nomes.forEach(nome -> System.out.println(saudacao + " " + nome));
        saudacao = "Oi"; // Pode modificar depois — campo não é local
    }
}
```

**Como o candidato deve responder:**  
- Definir "efetivamente final": valor nunca alterado após inicialização.
- Explicar que lambdas exigem variáveis final ou efetivamente finais.
- Justificar a restrição: captura por valor, consistência, thread-safety.
- Mostrar que tentar modificar dentro do lambda gera erro de compilação.
- Mencionar que adicionar `final` explicitamente é boa prática.
- Explicar a armadilha do loop com variável de iteração.
- Trazer o exemplo do processamento de pedidos com ID de lote.
- Evitar dizer que "lambdas não podem acessar variáveis externas" — podem, desde que sejam final/efetivamente final.

**Resposta fraca ou incompleta:**  
"Lambdas só acessam variáveis `final`." — Incorreto. Lambdas também acessam variáveis efetivamente finais (sem `final` explícito). Não explica o conceito nem a justificativa.

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
1. Por que campos de instância não precisam ser efetivamente finais?
2. O que acontece com a variável capturada após o método terminar?
3. Como o `var` (Java 10+) interage com o conceito de efetivamente final?

---

##  46. <a name='ResumodaParte4'></a>📊 Resumo da Parte 4

| Item | Detalhe |
|---|---|
| **Perguntas apresentadas** | 31 a 40 |
| **Categorias cobertas** | Fundamentos/Autoboxing (31), Controle de Fluxo/For-each (32), Coleções/Set (33), Boas Práticas/toString (34), Exceções/Hierarquia (35), Boas Práticas/Fail-fast (36), Coleções/Map (37), Controle de Fluxo/Switch (38), Coleções/List vs Set (39), Fundamentos/Efectivamente Final (40) |
| **Perguntas restantes** | 41 a 100 (60 perguntas) |

As próximas perguntas abordarão: clonagem de objetos, inner classes e classes aninhadas, formatação de números e moeda, método `finalize()` e `Cleaner`, `Collections.unmodifiableList`, varargs, var (Java 10+), records (Java 14+), exceptions em construtores, e mais cenários práticos de debugging e boas práticas.

Diga **"continuar"** e eu gero a Parte 5 com as perguntas 41 a 50.

---

# PARTE 5 — Perguntas 41 a 50

---

##  47. <a name='Pergunta41ClonagemdeObjetos:CloneableeCpiaDefensiva'></a>Pergunta 41 — Clonagem de Objetos: Cloneable e Cópia Defensiva

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Em um sistema de pedidos, você tem uma classe `Pedido` que contém uma `List<Item> itens`. O método `getItens()` retorna a lista interna diretamente. Um desenvolvedor recebe essa lista, modifica adicionando um item extra, e percebe que o pedido original foi alterado também — sem chamar nenhum método do `Pedido`. Como isso é possível? Qual a diferença entre cópia rasa (shallow copy) e cópia profunda (deep copy)? Como você corrigiria esse problema?

**O que essa pergunta avalia:**  
Compreensão de referências vs valores em Java, conhecimento de cópia rasa vs profunda, e capacidade de implementar cópia defensiva para proteger o estado interno de objetos.

**Resposta esperada:**  
Em Java, quando `getItens()` retorna a lista interna diretamente, o chamador recebe uma **referência** para a mesma lista na memória — não uma cópia. Qualquer modificação na lista retornada afeta o objeto original.

**Cópia rasa (shallow copy):** cria um novo objeto, mas os atributos referenciam os mesmos objetos internos. Se a lista interna for copiada com `new ArrayList<>(itens)`, a nova lista é independente (adicionar/remover em uma não afeta a outra), mas os **elementos** dentro das listas são os mesmos objetos.

**Cópia profunda (deep copy):** cria novos objetos para todos os atributos, incluindo os elementos dentro da lista. Modificar qualquer nível não afeta o original.

**Solução — Cópia defensiva:**
1. No getter: retornar uma cópia da lista (ou lista não modificável).
2. No setter: receber e armazenar uma cópia da lista recebida.

**Explicação didática:**  
Imagine que a lista interna do `Pedido` é como uma agenda física que fica na gaveta do objeto. Quando o getter retorna a lista diretamente, é como entregar a **mesma agenda** para outra pessoa — qualquer coisa que ela escreva aparece na sua agenda. A cópia defensiva é como fazer uma **xerox** da agenda e entregar a cópia: a pessoa pode escrever o que quiser na cópia, sua original fica intacta. A cópia rasa é uma xerox da capa da agenda (nova lista) mas com as mesmas páginas dentro. A cópia profunda é uma xerox de cada página também.

**Exemplo prático:**  
Em um sistema de pedidos de e-commerce, o método `getItens()` retorna a lista diretamente. O carrinho de compras adiciona um item à lista retornada pensando que está modificando o carrinho, mas na verdade está alterando o pedido original que já estava finalizado — corrompendo o histórico de pedidos.

**Exemplo de código:**  
```java
import java.util.*;

class Item {
    private String nome;
    private double preco;
    
    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    // Cópia profunda
    public Item copia() {
        return new Item(this.nome, this.preco);
    }
    
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}

class Pedido {
    private List<Item> itens;
    private String cliente;
    
    public Pedido(String cliente, List<Item> itens) {
        this.cliente = cliente;
        // Cópia defensiva no construtor — não guarda a referência externa
        this.itens = new ArrayList<>(itens);
    }
    
    // ❌ SEM cópia defensiva — expõe a lista interna
    public List<Item> getItensPerigoso() {
        return itens; // Chamador pode modificar a lista interna!
    }
    
    // ✅ Com cópia defensiva — retorna nova lista
    public List<Item> getItens() {
        return new ArrayList<>(itens); // Cópia a cada chamada
    }
    
    // ✅ Alternativa: lista não modificável (mais eficiente)
    public List<Item> getItensUnmodifiable() {
        return Collections.unmodifiableList(itens);
    }
    
    // ✅ Setter com cópia defensiva
    public void setItens(List<Item> novosItens) {
        this.itens = new ArrayList<>(novosItens); // Cópia defensiva
    }
}

// Demonstração do problema e da solução
public class DemonstracaoCopia {
    public void testar() {
        List<Item> itensOriginais = new ArrayList<>();
        itensOriginais.add(new Item("Mouse", 50.0));
        itensOriginais.add(new Item("Teclado", 150.0));
        
        Pedido pedido = new Pedido("João", itensOriginais);
        
        // ❌ Problema com getter sem cópia defensiva
        List<Item> itensPegos = pedido.getItensPerigoso();
        itensPegos.add(new Item("Monitor", 800.0)); // Modifica o pedido original!
        System.out.println(pedido.getItensPerigoso().size()); // 3 — corrompido!
        
        // ✅ Solução com cópia defensiva
        List<Item> itensSeguros = pedido.getItens(); // Retorna cópia
        itensSeguros.add(new Item("Webcam", 200.0)); // Não afeta o original
        System.out.println(pedido.getItens().size()); // 2 — original intacto
    }
}
```

**Como o candidato deve responder:**  
- Explicar que o getter retorna uma referência para a mesma lista interna.
- Diferenciar cópia rasa (nova lista, mesmos elementos) de cópia profunda (novos elementos também).
- Propor cópia defensiva no getter (retornar `new ArrayList<>(itens)` ou `Collections.unmodifiableList`).
- Mencionar cópia defensiva no setter e construtor também.
- Trazer o exemplo do carrinho de compras corrompendo o pedido.
- Evitar apenas dizer "use `final` na lista" — isso não resolve o problema de referência.

**Resposta fraca ou incompleta:**  
"Fazer a lista ser `final`." — `final` impede reatribuição da variável, mas não impede modificação do conteúdo da lista. O problema persiste.

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
1. Qual a diferença entre `Collections.unmodifiableList()` e criar uma `new ArrayList<>()` no getter? Quando usar cada uma?
2. Por que a interface `Cloneable` é considerada problemática em Java?
3. Como implementar uma cópia profunda de um objeto com vários níveis de aninhamento?

---

##  48. <a name='Pergunta42InnerClasseseClassesAninhadas'></a>Pergunta 42 — Inner Classes e Classes Aninhadas

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Em uma code review, você encontra uma classe `ListaEncadeada` com uma classe interna `No` (node) que representa cada elemento da lista. A classe `No` é declarada como classe interna não-estática (inner class). Outro desenvolvedor sugere transformar em classe aninhada estática (`static class`). Qual a diferença? Quando uma inner class faz sentido e quando é melhor usar uma static nested class?

**O que essa pergunta avalia:**  
Compreensão da diferença entre inner classes (não-estáticas) e static nested classes, conhecimento de quando cada uma é apropriada, e entendimento do acoplamento entre a classe externa e a interna.

**Resposta esperada:**  

**Inner class (não-estática):**
- Tem acesso implícito aos membros (atributos e métodos) da instância da classe externa.
- Precisa de uma instância da classe externa para ser criada.
- Mantém uma referência implícita para a instância externa (`OuterClass.this`).
- Pode causar vazamento de memória se a inner class viver mais que a externa.

**Static nested class:**
- Não tem acesso aos membros de instância da classe externa — só a membros estáticos.
- Pode ser criada sem uma instância da classe externa.
- Não mantém referência para a instância externa.
- É mais eficiente em memória.

Para o caso de `ListaEncadeada` e `No`: **static nested class é mais apropriada**, porque `No` não precisa acessar diretamente os membros de instância da lista — ela apenas guarda valor e referência para o próximo nó. Usar inner class criaria uma referência desnecessária para a lista em cada nó, desperdiçando memória.

**Explicação didática:**  
Pense na inner class como um funcionário que tem acesso à sala do chefe (instância externa) — pode entrar e pegar o que precisar, mas sempre está ligado ao chefe. A static nested class é como um consultor externo que tem o crachá da empresa mas não tem acesso à sala de ninguém — trabalha de forma independente. Para o `No` da lista, ele não precisa acessar a "sala do chefe" (a lista) — só precisa saber seu valor e o próximo nó. Então consultor (static) é suficiente.

**Exemplo prático:**  
Em uma estrutura de dados como `HashMap`, a classe interna `Node` (que representa cada entrada chave-valor) é declarada como `static` — não precisa acessar o `HashMap` diretamente, apenas guarda chave, valor e referência. Se fosse inner class, cada `Node` manteria uma referência desnecessária para o `HashMap`, multiplicando o consumo de memória.

**Exemplo de código:**  
```java
// ❌ Inner class (não-estática) — referência desnecessária
public class ListaEncadeadaRuim<E> {
    private No<E> cabeca;
    
    // Inner class — mantém referência para a ListaEncadeadaRuim
    private class No<E> {
        E valor;
        No<E> proximo;
        
        // Pode acessar ListaEncadeadaRuim.this.cabeca — mas não precisa!
        // Cada No carrega uma referência desnecessária para a lista inteira
    }
    
    public void adicionar(E valor) {
        No<E> novoNo = new No<>(); // Precisa de instância de ListaEncadeadaRuim
        novoNo.valor = valor;
    }
}

// ✅ Static nested class — sem referência desnecessária
public class ListaEncadeada<E> {
    private No<E> cabeca;
    
    // Static nested class — não tem referência para a lista
    private static class No<E> {
        E valor;
        No<E> proximo;
        
        // Não pode acessar ListaEncadeada.this.cabeca
        // Mas isso é OK — não precisa!
    }
    
    public void adicionar(E valor) {
        No<E> novoNo = new No<>(); // Não precisa de instância externa
        novoNo.valor = valor;
    }
}

// ✅ Quando inner class (não-estática) FAZ sentido
public class Cache<K, V> {
    private Map<K, V> dados = new HashMap<>();
    
    // Iterator interno — precisa acessar o mapa da instância
    private class CacheIterator implements Iterator<V> {
        private Iterator<K> chaves = dados.keySet().iterator();
        
        @Override
        public boolean hasNext() {
            return chaves.hasNext(); // Acessa dados da Cache externa
        }
        
        @Override
        public V next() {
            K chave = chaves.next();
            return dados.get(chave); // Acessa dados da Cache externa
        }
    }
    
    public Iterator<V> iterator() {
        return new CacheIterator(); // Precisa da instância de Cache
    }
}
```

**Como o candidato deve responder:**  
- Explicar que inner class mantém referência implícita para a instância externa.
- Explicar que static nested class não mantém essa referência.
- Recomendar static nested class para `No` — não precisa acessar a lista.
- Mencionar o risco de vazamento de memória com inner classes.
- Trazer o exemplo do `HashMap` e seus `Node`s.
- Mostrar quando inner class faz sentido (iterator que acessa dados da instância).
- Evitar dizer que inner classes são sempre erradas — têm casos de uso legítimos.

**Resposta fraca ou incompleta:**  
"Transformar em `static` porque é melhor." — Não explica a diferença entre os dois tipos, não menciona a referência implícita, nem quando cada um é apropriado.

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
1. Como uma inner class pode causar vazamento de memória em Java?
2. O que é a sintaxe `OuterClass.this` e quando é usada?
3. Classes anônimas são inner classes? Qual a diferença?

---

##  49. <a name='Pergunta43FormataodeNmeroseMoeda'></a>Pergunta 43 — Formatação de Números e Moeda

**Nível:** Júnior  
**Categoria:** Manipulação de Strings e Datas

**Pergunta do entrevistador:**  
Em um sistema de e-commerce que atende Brasil e Estados Unidos, você precisa exibir preços no formato correto de cada país: "R$ 1.234,56" para Brasil e "$1,234.56" para EUA. Um desenvolvedor usou concatenação manual de strings com `String.format()`, mas os milhares e decimais saíram errados em alguns locales. Como você implementaria a formatação de moeda corretamente usando a API do Java?

**O que essa pergunta avalia:**  
Conhecimento da API `NumberFormat` e `Currency`, compreensão de formatação sensível a locale, e capacidade de evitar bugs comuns de internacionalização.

**Resposta esperada:**  
Usar `NumberFormat.getCurrencyInstance(Locale)` — formata automaticamente o símbolo da moeda, separador de milhares e separador decimal de acordo com o país.

```java
NumberFormat formatoBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
String valorBR = formatoBR.format(1234.56); // "R$ 1.234,56"

NumberFormat formatoUS = NumberFormat.getCurrencyInstance(Locale.US);
String valorUS = formatoUS.format(1234.56); // "$1,234.56"
```

**Por que não usar `String.format()` manual:**
- `String.format("%.2f", valor)` não respeita locale para separadores.
- Concatenar `"R$ "` manualmente não funciona para outros países (símbolo pode ser prefixo ou sufixo).
- O símbolo, separadores e posições variam por país.

**Explicação didática:**  
Pense em `NumberFormat` como um tradutor de números. Para o Brasil, ele sabe que os milhares usam ponto e os decimais usam vírgula, e que o símbolo é "R$". Para os EUA, sabe que é o contrário: milhares com vírgula, decimais com ponto, e símbolo "$". Fazer isso manualmente é como tentar traduzir um idioma palavra por palavra com um dicionário — sempre algo sai errado. O tradutor (`NumberFormat`) conhece as regras completas.

**Exemplo prático:**  
Em um e-commerce internacional, o mesmo produto custa `R$ 1.234,56` para um cliente brasileiro e `$1,234.56` para um americano. O sistema precisa detectar o locale do usuário e formatar adequadamente. Usar `String.format()` com `"%.2f"` produziria `1234.56` — sem símbolo de moeda, sem separador de milhares, e com ponto decimal mesmo para o Brasil.

**Exemplo de código:**  
```java
import java.text.NumberFormat;
import java.util.Locale;

public class FormatadorMoeda {
    
    // ✅ Usando NumberFormat — correto e sensível a locale
    public String formatarMoeda(double valor, String pais) {
        Locale locale;
        switch (pais) {
            case "BR":
                locale = new Locale("pt", "BR");
                break;
            case "US":
                locale = Locale.US;
                break;
            case "JP":
                locale = Locale.JAPAN;
                break;
            case "DE":
                locale = Locale.GERMANY;
                break;
            default:
                locale = Locale.US;
        }
        
        NumberFormat formatador = NumberFormat.getCurrencyInstance(locale);
        return formatador.format(valor);
    }
    
    // ✅ Formatando percentuais
    public String formatarPercentual(double valor) {
        NumberFormat formato = NumberFormat.getPercentInstance(new Locale("pt", "BR"));
        return formato.format(valor); // 0.15 → "15%"
    }
    
    // ✅ Formatando números (sem símbolo de moeda)
    public String formatarNumero(double valor) {
        NumberFormat formato = NumberFormat.getInstance(new Locale("pt", "BR"));
        formato.setMinimumFractionDigits(2);
        formato.setMaximumFractionDigits(2);
        return formato.format(valor); // 1234.5 → "1.234,50"
    }
    
    // ❌ Abordagem manual — propensa a erros
    public String formatarManual(double valor, String pais) {
        if ("BR".equals(pais)) {
            return "R$ " + String.format("%.2f", valor).replace(".", ",");
            // Problemas: sem separador de milhares, "R$" fixo como prefixo
        }
        return "$" + String.format("%.2f", valor);
        // Problemas: sem separador de milhares, não funciona para todos os países
    }
    
    public void demonstrar() {
        double valor = 1234.56;
        
        System.out.println(formatarMoeda(valor, "BR")); // R$ 1.234,56
        System.out.println(formatarMoeda(valor, "US")); // $1,234.56
        System.out.println(formatarMoeda(valor, "JP")); // ¥1,235 (sem decimais!)
        System.out.println(formatarMoeda(valor, "DE")); // 1.234,56 € (símbolo no fim!)
    }
}
```

**Como o candidato deve responder:**  
- Propor `NumberFormat.getCurrencyInstance(Locale)`.
- Explicar por que `String.format()` manual é insuficiente (separadores, símbolos, posições).
- Mostrar que diferentes países têm regras diferentes (símbolo como prefixo/sufixo, decimais).
- Mencionar `NumberFormat.getPercentInstance()` e `NumberFormat.getInstance()` para outros formatos.
- Trazer o exemplo do e-commerce internacional.
- Evitar apenas sugerir `String.format("%.2f", valor)` — não resolve locale.

**Resposta fraca ou incompleta:**  
"Usar `String.format("R$ %.2f", valor)`." — Não funciona para outros países, não usa separador de milhares correto, e o símbolo é hardcoded.

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
1. Por que `NumberFormat` não é thread-safe? Como resolver em ambiente multi-thread?
2. Como o Japão lida com decimais em moeda (por que ¥1.234 não tem casas decimais)?
3. Qual a diferença entre `Locale` e `Currency` em Java?

---

##  50. <a name='Pergunta44Collections.unmodifiableeImutabilidadedeColees'></a>Pergunta 44 — Collections.unmodifiable e Imutabilidade de Coleções

**Nível:** Júnior  
**Categoria:** Coleções e Estruturas de Dados

**Pergunta do entrevistador:**  
Em uma classe `ConfiguracaoSistema`, você tem uma lista de URLs permitidas que é carregada na inicialização e não deve mudar. Você quer expor essa lista para outras classes consultarem, mas garantir que ninguém possa adicionar ou remover URLs. Um colega sugere usar `Collections.unmodifiableList()`. Isso é suficiente? Quais são as limitações dessa abordagem?

**O que essa pergunta avalia:**  
Conhecimento de `Collections.unmodifiableList()` e `List.of()` (Java 9+), compreensão da diferença entre lista não modificável e imutabilidade profunda, e capacidade de identificar limitações.

**Resposta esperada:**  
`Collections.unmodifiableList()` retorna uma **view** (visão) da lista original que **lança `UnsupportedOperationException`** ao tentar modificar (`add`, `remove`, `set`). No entanto:

1. **A lista original ainda é modificável:** se alguém tem acesso à lista original e a modifica, a view reflete a mudança. A view não é uma cópia, é um wrapper.
2. **Os elementos dentro da lista podem ser mutáveis:** se a lista contém objetos mutáveis, alguém pode modificar os elementos mesmo sem modificar a lista.
3. **Não é thread-safe por si só:** se a lista original é modificada concorrentemente enquanto a view é iterada, pode haver `ConcurrentModificationException`.

**Soluções mais robustas:**
- Fazer uma cópia defensiva antes de envolver: `Collections.unmodifiableList(new ArrayList<>(urls))`.
- Usar `List.of()` (Java 9+) que cria uma lista verdadeiramente imutável.
- Usar `List.copyOf()` (Java 10+) que cria uma cópia imutável.

**Explicação didática:**  
`unmodifiableList` é como colocar uma placa "Não Mexa" em uma estante de livros. As pessoas não podem adicionar ou remover livros, mas a estante é a mesma — se você (o dono) adicionar um livro por trás, todos que olham a estante veem o novo livro. Para truly proteger, você precisa fazer uma **cópia** dos livros para uma estante trancada (`List.of()` ou cópia defensiva).

**Exemplo prático:**  
Em um sistema com lista de IPs permitidos para acesso à API, a lista é carregada na inicialização. Se a lista original é exposta com `unmodifiableList()` mas alguém modifica a lista original em outra parte do código, a "imutabilidade" é quebrada silenciosamente.

**Exemplo de código:**  
```java
import java.util.*;

public class ConfiguracaoSistema {
    
    // Lista original — mutável
    private List<String> urlsPermitidas;
    
    public ConfiguracaoSistema(List<String> urls) {
        // Cópia defensiva no construtor
        this.urlsPermitidas = new ArrayList<>(urls);
    }
    
    // ❌ Apenas unmodifiable — ainda ligado à lista original
    public List<String> getUrlsPermitidasPerigoso() {
        return Collections.unmodifiableList(urlsPermitidas);
        // Se urlsPermitidas for modificada internamente, a view muda!
    }
    
    // ✅ Cópia defensiva + unmodifiable
    public List<String> getUrlsPermitidasSeguro() {
        return Collections.unmodifiableList(new ArrayList<>(urlsPermitidas));
        // Cópia independente + não modificável
    }
    
    // ✅ Java 9+ — List.of() cria lista verdadeiramente imutável
    public List<String> getUrlsPermitidasImutavel() {
        return List.of(urlsPermitidas.toArray(new String[0]));
        // Não permite null, não permite modificação
    }
    
    // ✅ Java 10+ — List.copyOf() (mais conciso)
    public List<String> getUrlsPermitidasCopy() {
        return List.copyOf(urlsPermitidas);
        // Cria cópia imutável em uma linha
    }
    
    // Demonstração das limitações
    public void demonstrarLimitacoes() {
        List<String> original = new ArrayList<>(Arrays.asList("url1", "url2"));
        
        // unmodifiableList — view da original
        List<String> view = Collections.unmodifiableList(original);
        
        // view.add("url3"); // UnsupportedOperationException ✅ bloqueado
        
        // Mas modificar a original afeta a view!
        original.add("url3");
        System.out.println(view); // [url1, url2, url3] — mudou! ❌
        
        // List.copyOf — cópia independente
        List<String> copia = List.copyOf(original);
        original.add("url4");
        System.out.println(copia); // [url1, url2, url3] — não mudou ✅
    }
}

// ⚠️ Outra limitação: elementos mutáveis
class ExemploElementosMutaveis {
    public void demonstrar() {
        List<StringBuilder> builders = new ArrayList<>();
        builders.add(new StringBuilder("Hello"));
        
        List<StringBuilder> imutavel = List.copyOf(builders);
        
        // Não pode modificar a lista
        // imutavel.add(new StringBuilder("World")); // UnsupportedOperationException
        
        // Mas pode modificar o elemento dentro da lista!
        imutavel.get(0).append(" World");
        System.out.println(imutavel.get(0)); // "Hello World" — mutou! ❌
        
        // Para truly imutável, os elementos também precisam ser imutáveis
        // StringBuilder é mutável — usar String (imutável) em vez
    }
}
```

**Como o candidato deve responder:**  
- Explicar que `unmodifiableList` é uma view, não uma cópia.
- Mostrar que modificar a lista original afeta a view.
- Propor cópia defensiva + unmodifiable, ou `List.copyOf()` (Java 10+).
- Mencionar que elementos mutáveis dentro da lista ainda podem ser alterados.
- Trazer o exemplo da lista de IPs permitidos.
- Evitar dizer que `unmodifiableList` torna a lista "imutável" — ela apenas bloqueia modificação direta.

**Resposta fraca ou incompleta:**  
"Usar `Collections.unmodifiableList()`." — Não reconhece a limitação de que a lista original ainda pode ser modificada e afetar a view. Não menciona cópia defensiva.

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
1. Qual a diferença entre `List.of()` e `Collections.unmodifiableList()` em termos de tratamento de `null`?
2. O que acontece se você tentar adicionar `null` a uma lista criada com `List.of()`?
3. Como criar um `Map` imutável em Java 9+?

---

##  51. <a name='Pergunta45Varargs:ArgumentosVariveis'></a>Pergunta 45 — Varargs: Argumentos Variáveis

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Você está criando um método de log que aceita uma quantidade variável de mensagens. Um colega implementou com `String... mensagens` (varargs). Em um cenário onde o método é chamado sem argumentos (`log.debug()`), o array `mensagens` está vazio ou é `null`? Quais cuidados você deve ter ao usar varargs? Existe algum problema de performance?

**O que essa pergunta avalia:**  
Compreensão de como varargs funcionam internamente, conhecimento das armadilhas (null, array vazio, performance), e capacidade de usar varargs corretamente.

**Resposta esperada:**  
Quando o método é chamado sem argumentos, `mensagens` é um **array vazio** (`String[0]`), não `null`. O compilador cria um array automaticamente.

**Cuidados com varargs:**
1. **Verificar se o array não está vazio** antes de acessar elementos.
2. **Verificar elementos null individualmente** — varargs aceita `null` como elemento.
3. **Performance:** cada chamada com varargs cria um novo array. Em loops de alta frequência, isso gera overhead e pressão no GC. Para métodos chamados milhões de vezes, considere sobrecargas com número fixo de parâmetros.
4. **Ambiguidade:** `log.debug(String primeiro, String... resto)` vs `log.debug(String... msgs)` — chamar `log.debug("a")` é ambíguo (não compila).
5. **Heap pollution (Java 5-6):** varargs de tipo genérico podem causar warnings. Usar `@SafeVarargs` (Java 7+) para suprimir quando seguro.

**Explicação didática:**  
Varargs é como um garçom que aceita qualquer número de pedidos. Se você não fizer nenhum pedido, ele chega com uma bandeja vazia (array vazio), não sem bandeja (null). Cada vez que você faz pedidos, ele pega uma bandeja nova do estoque (novo array). Se você fizer milhares de pedidos por minuto, ele gasta muitas bandejas (overhead de memória). Para pedidos frequentes com número fixo, é mais eficiente ter bandejas pré-preparadas (sobrecargas).

**Exemplo prático:**  
Em um sistema de logging de alta performance, o método `log.info(String... mensagens)` é chamado milhares de vezes por segundo. Cada chamada cria um novo array `String[]`, gerando pressão no garbage collector. Frameworks como SLF4J usam sobrecargas com número fixo de parâmetros e marcação `{}` para evitar esse overhead.

**Exemplo de código:**  
```java
import java.util.Arrays;

public class Logger {
    
    // ✅ Varargs — flexível
    public void info(String... mensagens) {
        // mensagens NUNCA é null — é array vazio se sem argumentos
        if (mensagens.length == 0) {
            return; // Nada a logar
        }
        
        for (String msg : mensagens) {
            // Cada elemento pode ser null individualmente
            if (msg != null) {
                System.out.println("[INFO] " + msg);
            }
        }
    }
    
    // Uso:
    // info();              // mensagens = String[0] (vazio, não null)
    // info("Hello");       // mensagens = String[1]{"Hello"}
    // info("A", "B", "C"); // mensagens = String[3]{"A", "B", "C"}
    // info("A", null, "C"); // mensagens = String[3]{"A", null, "C"}
    
    // ⚠️ Chamada ambígua com null
    // info(null); // Ambíguo! É null como String ou como String[]?
    // info((String) null); // OK — explicitamente String null
    // info((String[]) null); // NPE! — passa array null
    
    // ⚠️ Performance — cada chamada cria array
    public void exemploPerformance() {
        // Em loop de alta frequência:
        for (int i = 0; i < 1_000_000; i++) {
            info("Processando item " + i);
            // Cria 1.000.000 de arrays String[] temporariamente!
        }
    }
    
    // ✅ Otimização com sobrecarga para caso comum (1 parâmetro)
    public void info(String mensagem) {
        if (mensagem != null) {
            System.out.println("[INFO] " + mensagem);
        }
    }
    
    // ✅ @SafeVarargs — suprime warning de heap pollution
    @SafeVarargs
    public final <T> void logTodos(T... itens) {
        for (T item : itens) {
            System.out.println(item);
        }
    }
    
    // ⚠️ Ambiguidade de sobrecarga
    // public void info(String primeiro, String... resto) { ... }
    // info("A"); // Ambíguo! Chama info(String) ou info(String, String...)?
    // Não compila — compilador não consegue decidir
}
```

**Como o candidato deve responder:**  
- Explicar que varargs sem argumentos resulta em array vazio, não null.
- Mencionar que elementos individuais podem ser null.
- Explicar o overhead de performance: cria um array a cada chamada.
- Sugerir sobrecargas com número fixo de parâmetros para métodos de alta frequência.
- Mencionar `@SafeVarargs` para varargs genéricos.
- Trazer o exemplo de logging de alta performance.
- Evitar apenas dizer "varargs aceita qualquer quantidade de argumentos" sem mencionar as armadilhas.

**Resposta fraca ou incompleta:**  
"Varargs aceita zero ou mais argumentos." — Correto mas não menciona o array vazio vs null, nem os problemas de performance, ambiguidade, ou `@SafeVarargs`.

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
1. Por que `@SafeVarargs` só pode ser usado em métodos `final`, `static` ou construtores?
2. O que é "heap pollution" e como varargs genéricos podem causá-lo?
3. Como frameworks como SLF4J evitam o overhead de varargs em logging?

---

##  52. <a name='Pergunta46varJava10:InfernciadeTipo'></a>Pergunta 46 — var (Java 10+): Inferência de Tipo

**Nível:** Júnior  
**Categoria:** Fundamentos da linguagem

**Pergunta do entrevistador:**  
Em uma code review, um desenvolvedor usou `var` em todo lugar:

```java
var resultado = service.processar(pedido);
var lista = new ArrayList<String>();
var mapa = buscarConfiguracoes();
```

Outro desenvolvedor diz que isso reduz a legibilidade pois não dá para saber o tipo sem passar o mouse. Você concorda? Quando `var` é benéfico e quando é prejudicial? Qual é a diferença entre `var` em Java e `var` em JavaScript?

**O que essa pergunta avalia:**  
Conhecimento de `var` (Java 10+), compreensão de quando a inferência de tipo melhora ou prejudica a legibilidade, e capacidade de distinguir `var` em Java (statically typed) de `var` em JavaScript (dynamically typed).

**Resposta esperada:**  
Em Java, `var` é **inferência de tipo em compile-time** — o compilador deduz o tipo a partir do lado direito da atribuição. A variável ainda tem um tipo fixo e estático; não é dynamic. Uma vez inferido, o tipo não pode mudar.

**Diferença do JavaScript:**
- Java: `var x = 10;` → `x` é `int` para sempre. `x = "string"` não compila.
- JavaScript: `var x = 10; x = "string";` → permitido, `x` muda de tipo.

**Quando `var` é benéfico:**
1. Tipos óbvios pelo lado direito: `var lista = new ArrayList<String>();` — o tipo já é claro.
2. Tipos muito longos: `var iterator = mapa.entrySet().iterator();` em vez de `Iterator<Map.Entry<String, List<Integer>>> iterator = ...`.
3. Variáveis locais em lambdas e streams onde o tipo é evidente do contexto.

**Quando `var` é prejudicial:**
1. Quando o tipo não é óbvio: `var resultado = service.processar();` — o que é `resultado`? `String`? `List`? `Optional`?
2. Em interfaces (parâmetros de método, retornos) — `var` só funciona em variáveis locais.
3. Quando o tipo é importante para entender o comportamento: `var dados = buscarDados();` — se retorna `List<String>` ou `Map<String, Object>` muda completamente como o código é usado.

**Regra prática:** se o leitor precisa passar o mouse ou consultar a documentação para saber o tipo, não use `var`.

**Explicação didática:**  
Pense em `var` como um atalho de escrita. Se você escreve "comprei um carro Honda Civic", todo mundo sabe o que é — não precisa repetir "um automóvel Honda Civic sedan prata". `var` é o mesmo: se o lado direito já diz o que é, o `var` economiza texto. Mas se você diz "comprei uma coisa", ninguém sabe o que é — precisa perguntar. `var resultado = service.processar()` é como dizer "guardei uma coisa" sem dizer o quê.

**Exemplo prático:**  
Em um sistema de relatórios, `var dados = repository.buscarRelatorio();` não deixa claro se `dados` é um `String` (CSV), `byte[]` (PDF), `List<Relatorio>` ou `Map<String, Object>`. O desenvolvedor que vai usar `dados` não sabe se pode fazer `dados.size()`, `dados.getBytes()`, ou `dados.stream()`. Com o tipo explícito (`List<Relatorio> dados = ...`), a intenção é clara.

**Exemplo de código:**  
```java
import java.util.*;

public class ExemploVar {
    
    public void bonsUsos() {
        // ✅ Tipo óbvio pelo lado direito
        var lista = new ArrayList<String>();      // ArrayList<String>
        var mapa = new HashMap<String, Integer>(); // HashMap<String, Integer>
        var nome = "João";                         // String
        var contador = 0;                          // int
        var ativo = true;                          // boolean
        
        // ✅ Tipos longos e repetitivos
        var entry = mapa.entrySet().iterator();    // Iterator<Map.Entry<String, Integer>>
        // Muito melhor que:
        // Iterator<Map.Entry<String, Integer>> entry = mapa.entrySet().iterator();
        
        // ✅ Em streams
        var filtrados = lista.stream()
            .filter(s -> s.length() > 3)
            .toList();                              // List<String>
    }
    
    public void mausUsos() {
        // ❌ Tipo não é óbvio pelo lado direito
        var resultado = service.processar(pedido);
        // resultado é String? List? Optional? Map? Não dá para saber!
        
        // ❌ Retorno de método com nome ambíguo
        var dados = repository.buscar();
        // Que tipo de dados?
        
        // ❌ Pode confundir com tipos numéricos
        var x = 0;        // int
        var y = 0L;       // long
        var z = 0.0;      // double
        var w = 0.0f;     // float
        // Sem var, o tipo é explícito e não há confusão
        
        // ❌ var não muda de tipo (não é JavaScript)
        var nome = "João";
        // nome = 42; // Erro de compilação! nome é String
    }
    
    // ❌ var NÃO funciona em parâmetros de método
    // public void processar(var pedido) { } // Erro de compilação!
    
    // ❌ var NÃO funciona em atributos de classe
    // private var contador = 0; // Erro de compilação!
    
    // ❌ var NÃO funciona em retornos de método
    // public var buscar() { return "teste"; } // Erro de compilação!
    
    Service service;
    Object repository;
    
    static class Service {
        Object processar(Object pedido) { return pedido; }
    }
}
```

**Como o candidato deve responder:**  
- Explicar que `var` é inferência em compile-time, não tipagem dinâmica.
- Diferenciar do JavaScript: Java `var` tem tipo fixo, JS `var` é dinâmico.
- Mostrar bons usos: tipos óbvios (new ArrayList), tipos longos (generics aninhados).
- Mostrar maus usos: tipo não óbvio pelo lado direito (`service.processar()`).
- Mencionar que `var` só funciona em variáveis locais, não em parâmetros, atributos, ou retornos.
- Trazer o exemplo de `repository.buscar()` onde o tipo é ambíguo.
- Evitar dizer que `var` é sempre bom ou sempre ruim — depende do contexto.

**Resposta fraca ou incompleta:**  
"`var` é a mesma coisa que `var` do JavaScript." — Incorreto. Em Java, `var` é inferência de tipo estático em compile-time. O tipo não pode mudar. Em JavaScript, `var` é tipagem dinâmica.

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
1. Por que `var` não funciona para atributos de instância ou parâmetros de método?
2. O que é "diamond operator" (`<>`) e como ele se relaciona com `var`?
3. Como `var` interage com tipos genéricos com wildcards (`List<?>`)?

---

##  53. <a name='Pergunta47RecordsJava14:ModelagemdeDados'></a>Pergunta 47 — Records (Java 14+): Modelagem de Dados

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Em um sistema de cadastro de clientes, você tem várias classes que servem apenas para transportar dados: `ClienteDTO`, `EnderecoDTO`, `ContatoDTO`. Cada uma tem atributos, construtor, getters, `equals()`, `hashCode()` e `toString()` — muito código repetitivo. Um colega sugere usar `record` (Java 14+). O que é um record, quais vantagens ele traz, e em quais situações não seria adequado?

**O que essa pergunta avalia:**  
Conhecimento de `record` (Java 14+), compreensão de quando usar records vs classes tradicionais, e identificação das vantagens e limitações.

**Resposta esperada:**  
Um `record` é uma forma concisa de declarar uma classe que é essencialmente um **portador de dados imutável**. O compilador gera automaticamente:
- Construtor com todos os campos (canonical constructor).
- Getters (acessores sem prefixo `get`: `cliente.nome()` em vez de `cliente.getNome()`).
- `equals()`, `hashCode()` e `toString()` baseados em todos os campos.

```java
public record ClienteDTO(String nome, String email, int idade) {}
```

Equivalente a dezenas de linhas de uma classe tradicional com construtor, getters, equals, hashCode e toString.

**Vantagens:**
1. **Menos código boilerplate** — não precisa escrever getters, equals, hashCode, toString.
2. **Imutabilidade garantida** — campos são `final` por padrão.
3. **Semântica clara** — quem lê o código sabe que é um portador de dados imutável.
4. **Integra com pattern matching** (Java 21+).

**Quando NÃO usar records:**
1. Quando o objeto precisa ser **mutável** (ex: entidade JPA com setters).
2. Quando há **lógica de negócio significativa** — records são para dados, não comportamento.
3. Quando precisa de **herança** — records não podem herdar de outras classes (só implementar interfaces).
4. Quando precisa de **inicialização lazy** ou validação complexa no construtor (embora records suportem construtores compactos para validação).

**Explicação didática:**  
Pense em um record como um formulário pré-impresso. Ele já vem com campos definidos, espaços para preencher, e uma cópia automática carbono (toString, equals, hashCode). Você só preenche uma vez e não pode alterar. Uma classe tradicional é como uma folha em branco onde você desenha os campos, cria as regras de cópia, e decide se pode apagar e reescrever. Para formulários simples (DTOs), o pré-impresso (record) é muito mais eficiente. Para sistemas complexos com regras de negócio, a folha em branco (classe) é necessária.

**Exemplo prático:**  
Em uma API REST, o endpoint `GET /clientes/{id}` retorna um JSON. O DTO que representa a resposta não tem lógica de negócio — é apenas um contêiner de dados. Usar record reduz o código de 50+ linhas para 1 linha.

**Exemplo de código:**  
```java
// ❌ Classe tradicional — muito boilerplate para só transportar dados
public class ClienteDTO {
    private final String nome;
    private final String email;
    private final int idade;
    
    public ClienteDTO(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }
    
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public int getIdade() { return idade; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteDTO)) return false;
        ClienteDTO that = (ClienteDTO) o;
        return idade == that.idade 
            && Objects.equals(nome, that.nome)
            && Objects.equals(email, that.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nome, email, idade);
    }
    
    @Override
    public String toString() {
        return "ClienteDTO[nome=" + nome + ", email=" + email + ", idade=" + idade + "]";
    }
}

// ✅ Record — equivalente a tudo acima em uma linha
public record ClienteDTO(String nome, String email, int idade) {}

// ✅ Record com validação no construtor compacto
public record EmailDTO(String destinatario, String assunto, String corpo) {
    // Construtor compacto — valida antes de atribuir
    public EmailDTO {
        if (destinatario == null || !destinatario.contains("@")) {
            throw new IllegalArgumentException("Destinatário inválido");
        }
        if (assunto == null || assunto.isBlank()) {
            throw new IllegalArgumentException("Assunto é obrigatório");
        }
    }
}

// ✅ Múltiplos records relacionados
public record EnderecoDTO(String rua, String cidade, String cep) {}
public record ContatoDTO(String telefone, String email) {}

public record ClienteCompletoDTO(
    String nome, 
    int idade, 
    EnderecoDTO endereco,    // Record aninhado
    ContatoDTO contato       // Record aninhado
) {}

// Uso
ClienteDTO cliente = new ClienteDTO("João", "joao@email.com", 30);
System.out.println(cliente.nome());   // "João" — sem get
System.out.println(cliente.email());  // "joao@email.com"
System.out.println(cliente);          // ClienteDTO[nome=João, email=joao@email.com, idade=30]

ClienteDTO cliente2 = new ClienteDTO("João", "joao@email.com", 30);
System.out.println(cliente.equals(cliente2)); // true — gerado automaticamente

// Record com métodos adicionais
public record ProdutoDTO(String nome, double preco) {
    // Método de instância
    public double precoComDesconto(double percentual) {
        return preco * (1 - percentual / 100);
    }
    
    // Método estático (factory)
    public static ProdutoDTO gratuito(String nome) {
        return new ProdutoDTO(nome, 0.0);
    }
}
```

**Como o candidato deve responder:**  
- Explicar que records são portadores de dados imutáveis com código gerado automaticamente.
- Listar o que é gerado: construtor, getters (sem `get`), equals, hashCode, toString.
- Mencionar vantagens: menos boilerplate, imutabilidade garantida, semântica clara.
- Identificar limitações: não mutável, não herda classes, não para lógica complexa.
- Mostrar o construtor compacto para validação.
- Trazer o exemplo de DTOs em API REST.
- Evitar dizer que records substituem classes — são para casos específicos.

**Resposta fraca ou incompleta:**  
"Records são classes mais curtas." — Não explica o que é gerado automaticamente, não menciona imutabilidade, nem quando não usar.

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
1. Por que os accessors de records não usam o prefixo `get` (`nome()` em vez de `getNome()`)?
2. Pode um record implementar interfaces? E herdar de outra classe?
3. Como records funcionam com serialização (ex: JSON, JPA)?

---

##  54. <a name='Pergunta48ExceesemConstrutoreseLiberaodeRecursos'></a>Pergunta 48 — Exceções em Construtores e Liberação de Recursos

**Nível:** Júnior  
**Categoria:** Tratamento de Exceções

**Pergunta do entrevistador:**  
Você está desenvolvendo uma classe `ConexaoBanco` que abre uma conexão de rede no construtor. Se a abertura da conexão falhar e lançar uma exceção, o objeto não é criado. Mas e se o construtor já tiver aberto um arquivo de log antes de tentar a conexão, e a conexão falhar? O arquivo fica aberto? Como garantir que recursos parcialmente inicializados sejam liberados quando o construtor falha?

**O que essa pergunta avalia:**  
Compreensão do comportamento de exceções em construtores, conhecimento de vazamento de recursos em inicialização parcial, e capacidade de propor soluções para garantir limpeza.

**Resposta esperada:**  
Se o construtor lança uma exceção, o objeto **não é criado** — a referência não é atribuída. No entanto, recursos que já foram abertos **antes da exceção** não são liberados automaticamente, pois não há objeto para chamar `close()`.

Isso é um problema de **vazamento de recursos**: o arquivo de log foi aberto, a conexão falhou, a exceção propagou, e ninguém fechou o arquivo.

**Soluções:**

1. **Try-catch no construtor com limpeza manual:** capturar a exceção, fechar os recursos já abertos, e relançar.

2. **Factory method em vez de construtor:** criar um método estático que tenta construir o objeto e, em caso de falha, limpa os recursos.

3. **Builder pattern:** separar a construção em etapas, permitindo limpeza granular.

**Explicação didática:**  
Imagine que você está montando um móvel. O construtor é o processo de montagem. Se você abre uma lata de tinta (arquivo de log) e depois percebe que falta uma peça (conexão falha), a montagem é cancelada — mas a lata de tinta ficou aberta. Ninguém vai fechar porque o móvel não existe. A solução é ter um plano de limpeza: se a montagem falhar, feche a tinta antes de desistir.

**Exemplo prático:**  
Em um sistema de integração, a classe `IntegracaoService` abre um arquivo de log e depois tenta conectar a um servidor remoto. Se o servidor está fora do ar, a exceção é lançada, o objeto não é criado, mas o arquivo de log fica aberto — com o tempo, dezenas de arquivos abertos esgotam os file descriptors do sistema operacional.

**Exemplo de código:**  
```java
import java.io.*;
import java.net.*;

public class ConexaoBanco {
    private final FileWriter logWriter;
    private final Socket conexao;
    
    // ❌ Problema — vazamento de recurso se conexao falhar
    public ConexaoBancoRuim(String host, int porta, String arquivoLog) 
            throws IOException {
        this.logWriter = new FileWriter(arquivoLog, true); // Abre arquivo
        logWriter.write("Iniciando conexão...\n");
        
        // Se isto falhar, logWriter NUNCA é fechado!
        this.conexao = new Socket(host, porta); // Pode lançar IOException
    }
    
    // ✅ Solução 1: try-catch com limpeza no construtor
    public ConexaoBanco(String host, int porta, String arquivoLog) 
            throws IOException {
        FileWriter tempLog = null;
        Socket tempConn = null;
        
        try {
            tempLog = new FileWriter(arquivoLog, true);
            tempLog.write("Iniciando conexão...\n");
            
            tempConn = new Socket(host, porta); // Pode falhar
            
            // Se chegou aqui, tudo OK — atribui aos campos finais
            this.logWriter = tempLog;
            this.conexao = tempConn;
            tempLog = null; // Marca como entregue
            tempConn = null;
            
        } finally {
            // Limpa recursos que não foram entregues
            if (tempLog != null) {
                try { tempLog.close(); } catch (IOException e) { /* log */ }
            }
            if (tempConn != null) {
                try { tempConn.close(); } catch (IOException e) { /* log */ }
            }
        }
    }
    
    // ✅ Solução 2: Factory method — mais limpo
    public static ConexaoBanco criar(String host, int porta, 
                                      String arquivoLog) throws IOException {
        FileWriter log = new FileWriter(arquivoLog, true);
        try {
            log.write("Iniciando conexão...\n");
            Socket conn = new Socket(host, porta);
            try {
                return new ConexaoBanco(log, conn);
            } catch (Exception e) {
                conn.close(); // Fecha socket se construtor falhar
                throw e;
            }
        } catch (Exception e) {
            log.close(); // Fecha log se socket falhar
            throw e;
        }
    }
    
    // Construtor privado — chamado pelo factory
    private ConexaoBanco(FileWriter logWriter, Socket conexao) {
        this.logWriter = logWriter;
        this.conexao = conexao;
    }
    
    // AutoCloseable para uso com try-with-resources
    public void close() throws IOException {
        try {
            conexao.close();
        } finally {
            logWriter.close();
        }
    }
}

// Uso com factory method
try (ConexaoBanco conn = ConexaoBanco.criar("localhost", 5432, "db.log")) {
    // Usar conexão
} // close() chamado automaticamente
```

**Como o candidato deve responder:**  
- Explicar que se o construtor lança exceção, recursos parcialmente abertos ficam vazados.
- Propor try-catch-finally no construtor com limpeza manual.
- Recomendar factory method como alternativa mais limpa.
- Mencionar que o objeto não é criado (referência não atribuída) se o construtor falha.
- Trazer o exemplo de integração com arquivo de log e conexão de rede.
- Evitar apenas dizer "use try-with-resources no construtor" — não funciona pois os campos precisam ser `final`.

**Resposta fraca ou incompleta:**  
"Colocar um try-catch no construtor." — Não especifica que o `finally` deve fechar os recursos já abertos, nem menciona o padrão de variáveis temporárias.

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
1. Por que não dá para usar try-with-resources diretamente no construtor com campos `final`?
2. O que é o padrão "Two-Phase Construction" e quando é útil?
3. Como frameworks de injeção de dependência (Spring, CDI) lidam com exceções em construtores?

---

##  55. <a name='Pergunta49Debugging:ExceptionChainingeCause'></a>Pergunta 49 — Debugging: Exception Chaining e Cause

**Nível:** Júnior  
**Categoria:** Boas Práticas e Debugging

**Pergunta do entrevistador:**  
Em um sistema de cadastro, o método `cadastrar()` captura uma `SQLException` e lança uma `CadastroException` com a mensagem "Erro ao cadastrar usuário". No entanto, ao investigar o problema em produção, você só vê "Erro ao cadastrar usuário" no log — sem detalhes da causa original (qual SQL falhou, qual constraint foi violada). O que está faltando? Como você preservaria a causa original da exceção?

**O que essa pergunta avalia:**  
Conhecimento de exception chaining (encadeamento de exceções), compreensão do construtor com `cause`, e capacidade de diagnosticar perda de contexto em tratamento de exceções.

**Resposta esperada:**  
O problema é que a `SQLException` original foi "engolida" — capturada mas não encadeada na nova exceção. Sem a causa original, é impossível diagnosticar o problema real.

**Exception chaining** é o processo de preservar a exceção original como "causa" de uma nova exceção. Em Java, toda `Throwable` tem um campo `cause` que pode ser passado no construtor:

```java
// ❌ Perde a causa original
throw new CadastroException("Erro ao cadastrar usuário");

// ✅ Preserva a causa original
throw new CadastroException("Erro ao cadastrar usuário", e);
```

A stack trace resultante mostra:
```
CadastroException: Erro ao cadastrar usuário
    at ...
Caused by: java.sql.SQLException: Violation of UNIQUE constraint ...
    at ...
```

A linha "Caused by" preserva o contexto original, permitindo diagnosticar exatamente o que falhou.

**Explicação didática:**  
Imagine que você é um mensageiro que leva uma carta de um rei para outro. No caminho, um ladrão rouba a carta. Você chega ao rei destinatário e diz apenas "houve um problema". O rei não sabe se foi um ladrão, uma tempestade, ou um ataque — você perdeu a história toda. Exception chaining é como entregar a carta original junto com o relatório do problema — o rei vê o que aconteceu e por quê.

**Exemplo prático:**  
Em produção, o cadastro de um usuário falha com "Erro ao cadastrar usuário". Sem a causa, o desenvolvedor não sabe se foi violação de constraint, conexão com banco caiu, timeout, ou erro de SQL. Com a causa preservada, vê "Caused by: SQLException: Violation of UNIQUE constraint UK_email" — imediatamente sabe que o e-mail já existe.

**Exemplo de código:**  
```java
// Classe de exceção customizada com suporte a cause
public class CadastroException extends RuntimeException {
    public CadastroException(String mensagem) {
        super(mensagem);
    }
    
    // ✅ Construtor que aceita a causa original
    public CadastroException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

public class UsuarioService {
    
    // ❌ Engole a causa original — impossível diagnosticar
    public void cadastrarRuim(Usuario usuario) {
        try {
            repository.salvar(usuario);
        } catch (SQLException e) {
            // Cria nova exceção SEM passar a causa
            throw new CadastroException("Erro ao cadastrar usuário");
            // Log mostra apenas: CadastroException: Erro ao cadastrar usuário
            // Nada sobre qual SQL falhou ou qual constraint foi violada
        }
    }
    
    // ✅ Preserva a causa original — diagnosticável
    public void cadastrar(Usuario usuario) {
        try {
            repository.salvar(usuario);
        } catch (SQLException e) {
            // Passa a exceção original como causa
            throw new CadastroException("Erro ao cadastrar usuário", e);
            // Log mostra:
            // CadastroException: Erro ao cadastrar usuário
            //   Caused by: SQLException: Violation of UNIQUE constraint UK_email
            //     at ...
        }
    }
    
    // ✅ Também pode adicionar contexto adicional
    public void cadastrarComContexto(Usuario usuario) {
        try {
            repository.salvar(usuario);
        } catch (SQLException e) {
            throw new CadastroException(
                String.format("Erro ao cadastrar usuário %s (email: %s)", 
                    usuario.getNome(), usuario.getEmail()), 
                e
            );
            // Mensagem com contexto + causa preservada
        }
    }
    
    // ❌ Outro erro comum: logar e engolir
    public void cadastrarEngolindo(Usuario usuario) {
        try {
            repository.salvar(usuario);
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
            // Não relança! O chamador não sabe que falhou.
            // Pior ainda: e.getMessage() pode não ter a stack trace
        }
    }
    
    // ❌ Logar sem stack trace
    public void cadastrarSemStackTrace(Usuario usuario) {
        try {
            repository.salvar(usuario);
        } catch (SQLException e) {
            throw new CadastroException("Erro: " + e.getMessage());
            // getMessage() perde a stack trace! Só a mensagem, sem "Caused by"
        }
    }
}
```

**Como o candidato deve responder:**  
- Identificar que a causa original não está sendo passada para a nova exceção.
- Explicar exception chaining: passar a exceção original como `cause`.
- Mostrar o construtor com `Throwable causa`: `new CadastroException(msg, e)`.
- Explicar que o log deve mostrar "Caused by" com a stack trace original.
- Mencionar que `e.getMessage()` sem relançar perde a stack trace.
- Trazer o exemplo de constraint violation no banco de dados.
- Evitar apenas dizer "fazer log do erro" sem preservar a causa.

**Resposta fraca ou incompleta:**  
"Imprimir o erro com `e.printStackTrace()`." — Pode ajudar no debug local, mas não resolve o problema de preservar a causa na exceção relançada. Em produção, `printStackTrace` pode ir para stderr em vez do sistema de log.

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
1. Qual a diferença entre `throw new Exception(msg, e)` e `throw new Exception(msg).initCause(e)`?
2. Como acessar a causa original de uma exceção em código (`getCause()`)?
3. O que é o padrão "exception translation" e quando aplicá-lo?

---

##  56. <a name='Pergunta50MtodosDefaultemInterfaces'></a>Pergunta 50 — Métodos Default em Interfaces

**Nível:** Júnior  
**Categoria:** Orientação a Objetos

**Pergunta do entrevistador:**  
Você tem uma interface `Repository<T>` com métodos `salvar()` e `buscar()`. A equipe quer adicionar um método `buscarOuSalvar()` que primeiro tenta buscar, e se não encontrar, salva. Mas há dezenas de classes que implementam essa interface, e adicionar um método abstrato quebraria todas. Como os **default methods** (Java 8+) resolvem esse problema? Existe algum risco? O que acontece se uma classe implementa duas interfaces com o mesmo default method?

**O que essa pergunta avalia:**  
Compreensão de default methods em interfaces (Java 8+), conhecimento de como eles resolvem o problema de evolução de interfaces, e capacidade de identificar o conflito de "diamond problem".

**Resposta esperada:**  
**Default methods** permitem adicionar métodos com implementação diretamente na interface. O método tem a palavra-chave `default` e um corpo. Classes que implementam a interface herdam a implementação padrão sem precisar sobrescrevê-lo.

```java
public interface Repository<T> {
    void salvar(T entidade);
    T buscar(Long id);
    
    // Default method — não quebra implementações existentes
    default T buscarOuSalvar(Long id, T entidade) {
        T existente = buscar(id);
        if (existente == null) {
            salvar(entidade);
            return entidade;
        }
        return existente;
    }
}
```

**Vantagens:**
- Evolução de interfaces sem quebrar código existente (ex: `forEach` em `Iterable`).
- Permite reutilização de código sem herança.
- Pode ser sobrescrito por implementações que precisam de comportamento diferente.

**Riscos e limitações:**
1. **Diamond problem:** se uma classe implementa duas interfaces com o mesmo default method, o compilador exige que a classe sobrescreva o método para resolver a ambiguidade.
2. **Não substitui classes abstratas:** default methods não têm estado (atributos) — só comportamento.
3. **Não podem sobrescrever métodos de `Object`** (como `toString`, `equals`, `hashCode`).

**Explicação didática:**  
Pense na interface como um contrato de aluguel de apartamento. Originalmente, o contrato dizia "o inquilino deve pintar as paredes" e "o inquilino deve limpar o carpete" (métodos abstratos). Agora você quer adicionar "o inquilino deve trocar lâmpadas" — mas já há 100 inquilinos com contrato antigo. Se adicionar como obrigação (método abstrato), todos os 100 contratos precisam ser atualizados. O default method é como adicionar uma cláusula "se o inquilino não quiser trocar as lâmpadas, o síndico faz" — quem já tem contrato não precisa mudar nada, mas pode optar por fazer.

**Exemplo prático:**  
Em um sistema com a interface `Repository` implementada por `UsuarioRepository`, `ProdutoRepository`, `PedidoRepository` (e mais 20 classes), adicionar um método `buscarOuSalvar()` como abstrato exigiria implementar em todas as 22 classes. Com default method, todas herdam a implementação automaticamente.

**Exemplo de código:**  
```java
// Interface com default methods
public interface Repository<T> {
    void salvar(T entidade);
    T buscar(Long id);
    
    // ✅ Default method — herança automática
    default T buscarOuSalvar(Long id, T entidade) {
        T existente = buscar(id);
        if (existente == null) {
            salvar(entidade);
            return entidade;
        }
        return existente;
    }
    
    // ✅ Default method que chama métodos abstratos
    default boolean existe(Long id) {
        return buscar(id) != null;
    }
}

// Implementação — não precisa implementar buscarOuSalvar() ou existe()
public class UsuarioRepository implements Repository<Usuario> {
    @Override
    public void salvar(Usuario entidade) {
        // Implementação específica
        System.out.println("Salvando usuário: " + entidade.getNome());
    }
    
    @Override
    public Usuario buscar(Long id) {
        // Implementação específica
        return database.find(Usuario.class, id);
    }
    // buscarOuSalvar() e existe() são herdados da interface!
}

// ⚠️ Diamond problem — duas interfaces com mesmo default method
public interface Loggable {
    default void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}

public interface Traceable {
    default void log(String msg) {
        System.out.println("[TRACE] " + msg);
    }
}

// ❌ Não compila — ambiguidade de default methods
public class Servico implements Loggable, Traceable {
    // Qual log() usar? Loggable ou Traceable?
}

// ✅ Resolução — sobrescrever para desambiguar
public class Servico implements Loggable, Traceable {
    @Override
    public void log(String msg) {
        // Escolher um, combinar, ou implementar do zero
        Loggable.super.log(msg);  // Chama o de Loggable
        Traceable.super.log(msg); // Também chama o de Traceable
    }
}

// ❌ Default method NÃO pode sobrescrever Object.toString()
public interface Printable {
    // default String toString() { return "..."; } // Erro de compilação!
    // Object methods não podem ser default
}
```

**Como o candidato deve responder:**  
- Explicar que default methods permitem adicionar implementação na interface.
- Mostrar que resolve o problema de evolução sem quebrar implementações existentes.
- Mencionar o diamond problem: duas interfaces com mesmo default method exige sobrescrita.
- Explicar a resolução com `InterfaceName.super.method()`.
- Mostrar que não substitui classes abstratas (não há estado).
- Mencionar que não pode sobrescrever métodos de `Object`.
- Trazer o exemplo do `Repository` com dezenas de implementações.
- Evitar dizer que default methods são "herança múltipla" — são limitadas (sem estado).

**Resposta fraca ou incompleta:**  
"Default methods são métodos com implementação na interface." — Correto mas não explica o problema que resolvem (evolução de interfaces), nem os riscos (diamond problem).

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
1. Por que default methods não podem sobrescrever métodos de `Object`?
2. Qual a diferença entre um default method e um método em uma classe abstrata?
3. Como a Collections API do Java usou default methods para adicionar `stream()` em `Collection` sem quebrar implementações existentes?

---

##  57. <a name='ResumodaParte5'></a>📊 Resumo da Parte 5

| Item | Detalhe |
|---|---|
| **Perguntas apresentadas** | 41 a 50 |
| **Categorias cobertas** | Fundamentos/Clonagem (41), OO/Inner Classes (42), Strings/Números e Moeda (43), Coleções/unmodifiable (44), Fundamentos/Varargs (45), Fundamentos/var (46), OO/Records (47), Exceções/Construtores (48), Debugging/Exception Chaining (49), OO/Default Methods (50) |
| **Perguntas restantes** | 51 a 100 (50 perguntas) |

As próximas perguntas abordarão: `String.join()` e `String.format()`, `Map.Entry`, `Iterator` customizado, `Bitwise` vs lógico, `instanceof` vs `getClass()`, sobrecarga de operadores (ausência em Java), `try-catch-finally` com `return`, clousures vs lambdas, `Supplier` e `Consumer`, `Stream.collect()` avançado, e mais cenários de debugging, boas práticas e resolução de problemas reais.

Diga **"continuar"** e eu gero a Parte 6 com as perguntas 51 a 60.

---

Aqui está a Parte 6, com as perguntas 51 a 60 do roteiro de entrevista técnica de Java para nível Júnior, com foco em cenários reais.

---

##  58. <a name='Parte6Perguntas51a60'></a>Parte 6 — Perguntas 51 a 60

---

###  58.1. <a name='Pergunta51Tratamentodeexceoemmtodoquepodefalharpormltiplasrazes'></a>Pergunta 51 — Tratamento de exceção em método que pode falhar por múltiplas razões

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Imagine que você escreveu um método que lê um arquivo de configuração, faz o parse dos valores e os converte para tipos numéricos. Durante os testes, você percebe que o método pode falhar por três motivos: o arquivo não existe, o valor de uma propriedade não é um número válido, ou o valor está nulo. Como você estruturaria o tratamento de exceções nesse método para que o chamador consiga distinguir o que deu errado?

**O que essa pergunta avalia:**  
Conhecimento sobre hierarquia de exceções em Java (checked vs unchecked), capacidade de pensar em mensagens de erro significativas, uso adequado de try-catch e compreensão de como propagar erros de forma útil para quem chama o método.

**Resposta esperada:**  
O candidato deveria identificar que as três situações geram exceções diferentes: `FileNotFoundException` (ou `IOException`) quando o arquivo não existe, `NumberFormatException` quando o valor não é numérico, e `NullPointerException` quando o valor está nulo. A abordagem esperada é capturar cada exceção em blocos `catch` separados ou encapsulá-las em uma exceção personalizada com mensagem descritiva, permitindo que o chamador saiba exatamente qual problema ocorreu. É importante que o candidato mencione que nunca deve deixar um `catch` vazio ou apenas imprimir a stack trace sem tomar nenhuma decisão.

**Explicação didática:**  
Em Java, exceções são objetos que representam condições anormais durante a execução. Elas se dividem em dois grandes grupos:

- **Checked exceptions** (como `IOException`): o compilador obriga você a tratá-las ou declará-las na assinatura do método com `throws`. Representam condições que o programa pode recuperar.
- **Unchecked exceptions** (como `NumberFormatException` e `NullPointerException`): herdam de `RuntimeException` e não são verificadas pelo compilador. Geralmente indicam erros de programação.

Quando um método pode falhar de múltiplas formas, capturar tudo em um único `catch (Exception e)` é uma prática ruim, pois mascara o problema. O ideal é tratar cada exceção individualmente, com mensagens que ajudem no diagnóstico.

**Exemplo prático:**  
Imagine um sistema de configuração de uma aplicação desktop que carrega preferências do usuário (idioma, tema, timeout) de um arquivo `.properties`. Se o arquivo foi deletado, o sistema precisa mostrar "Arquivo de configuração não encontrado, usando valores padrão". Se um valor for inválido, precisa avisar qual propriedade está com problema.

**Exemplo de código:**

```java
public Configuracao carregarConfiguracao(String caminho) throws ConfiguracaoException {
    Properties props = new Properties();
    
    // 1ª possível falha: arquivo não existe
    try (FileInputStream fis = new FileInputStream(caminho)) {
        props.load(fis);
    } catch (FileNotFoundException e) {
        throw new ConfiguracaoException("Arquivo de configuração não encontrado: " + caminho, e);
    } catch (IOException e) {
        throw new ConfiguracaoException("Erro ao ler o arquivo de configuração: " + caminho, e);
    }
    
    // 2ª e 3ª possíveis falhas: valor nulo ou não numérico
    String timeoutStr = props.getProperty("timeout");
    if (timeoutStr == null) {
        throw new ConfiguracaoException("Propriedade 'timeout' não está definida no arquivo");
    }
    
    int timeout;
    try {
        timeout = Integer.parseInt(timeoutStr);
    } catch (NumberFormatException e) {
        throw new ConfiguracaoException(
            "Valor inválido para 'timeout': esperado um número, recebido: " + timeoutStr, e);
    }
    
    return new Configuracao(timeout);
}
```

A exceção personalizada `ConfiguracaoException` encapsula todas as falhas, mas cada uma com uma mensagem diferente, permitindo que o chamador saiba exatamente o que aconteceu.

**Como o candidato deve responder:**  
- Mencione que cada tipo de erro gera uma exceção diferente e que é importante capturá-las separadamente.
- Explique a diferença entre checked e unchecked exceptions.
- Sugira o uso de uma exceção personalizada para encapsular os erros com contexto.
- Comente que o bloco `try-with-resources` é o adequado para fechar o `FileInputStream` automaticamente.
- Mencione que a mensagem de erro deve ser clara e incluir informações que ajudem no diagnóstico.
- Evite sugerir `catch (Exception e)` genérico como única estratégia.

**Resposta fraca ou incompleta:**  
*"Eu colocaria um try-catch em volta de tudo e capturaria Exception, imprimindo a mensagem no console."*  
Faltou: distinguir os tipos de erro, criar mensagens específicas, considerar o uso de exceções personalizadas e fechar o recurso adequadamente.

**Critérios de avaliação:**
- **0** — Não sabe diferenciar tipos de exceção ou propõe capturar tudo genericamente sem distinção.
- **1** — Menciona try-catch mas não diferencia os tipos de erro nem cria mensagens úteis.
- **2** — Diferencia alguns erros, mas mistura conceitos de checked/unchecked ou não menciona exceção personalizada.
- **3** — Identifica corretamente as três exceções e propõe tratamento separado com mensagens adequadas.
- **4** — Propõe exceção personalizada, usa try-with-resources, menciona a importância das mensagens e do contexto.
- **5** — Responde com profundidade, menciona boas práticas de logging, discute quando encapsular vs. propagar a exceção original, e considera o impacto no código que chama o método.

**Perguntas de aprofundamento:**
1. Em quais situações você optaria por propagar a exceção original em vez de encapsulá-la em uma personalizada?
2. Como você testaria esse método para garantir que os três cenários de falha são tratados corretamente?
3. Qual seria o impacto de usar `catch (Exception e)` genérico na manutenibilidade desse código ao longo do tempo?

---

###  58.2. <a name='Pergunta52NullPointerExceptionevitvelemcdigodemanipulaodelistas'></a>Pergunta 52 — NullPointerException evitável em código de manipulação de listas

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Um colega de equipe escreveu o código abaixo para processar uma lista de pedidos e retornar o nome do primeiro cliente. O código está gerando `NullPointerException` em produção de forma intermitente. Analise o código e explique o que pode estar causando o problema e como corrigir.

**O que essa pergunta avalia:**  
Capacidade de ler código, identificar pontos de `NullPointerException`, conhecimento sobre `Optional`, checagem de null, e boas práticas defensivas ao trabalhar com coleções e objetos.

**Resposta esperada:**  
O candidato deve identificar que existem múltiplos pontos de falha: a lista pode ser `null`, a lista pode estar vazia (o que faria `get(0)` lançar `IndexOutOfBoundsException`), o primeiro pedido pode ser `null`, e o método `getCliente()` pode retornar `null`. A correção envolve checar se a lista é não-nula e não-vazia antes de acessar o índice, verificar se o pedido é não-nulo antes de chamar `getCliente()`, e usar `Optional` ou checagem explícita para o nome do cliente.

**Explicação didática:**  
`NullPointerException` (NPE) é a exceção mais comum em Java. Ela ocorre quando você tenta acessar um membro (método ou atributo) de uma referência que é `null`. Pense assim: é como tentar abrir a porta de uma casa que não existe.

Em código que processa coleções, há vários pontos onde o `null` pode aparecer:
- A própria coleção pode ser `null` (alguém passou `null` como argumento).
- Um elemento da coleção pode ser `null`.
- Um atributo de um elemento pode ser `null`.

Desde o Java 8, a classe `Optional` foi introduzida para representar valores que podem ou não estar presentes, evitando o `null` explícito e forçando o chamador a lidar com a ausência.

**Exemplo prático:**  
Um sistema de e-commerce recebe pedidos de múltiplas fontes (API, fila de mensagens, importação de planilha). Algumas fontes podem enviar listas vazias, pedidos incompletos ou clientes sem nome cadastrado.

**Exemplo de código:**

```java
// Código com problema — múltiplos pontos de NPE
public String getNomePrimeiroCliente(List<Pedido> pedidos) {
    Pedido primeiro = pedidos.get(0);     // NPE se pedidos == null
                                          // IndexOutOfBounds se lista vazia
    Cliente cliente = primeiro.getCliente(); // NPE se primeiro == null
    return cliente.getNome();               // NPE se cliente == null
}

// Código corrigido — defensivo e seguro
public String getNomePrimeiroCliente(List<Pedido> pedidos) {
    // Verifica se a lista é nula ou vazia
    if (pedidos == null || pedidos.isEmpty()) {
        return "Cliente não encontrado";
    }
    
    Pedido primeiro = pedidos.get(0);
    if (primeiro == null) {
        return "Pedido inválido";
    }
    
    Cliente cliente = primeiro.getCliente();
    if (cliente == null) {
        return "Cliente não cadastrado";
    }
    
    String nome = cliente.getNome();
    return (nome != null) ? nome : "Sem nome";
}

// Alternativa com Optional (Java 8+)
public Optional<String> getNomePrimeiroClienteOpt(List<Pedido> pedidos) {
    return Optional.ofNullable(pedidos)
        .filter(lista -> !lista.isEmpty())
        .map(lista -> lista.get(0))
        .map(Pedido::getCliente)
        .map(Cliente::getNome);
}
```

**Como o candidato deve responder:**  
- Comece identificando cada ponto do código onde um `NullPointerException` pode ocorrer.
- Mencione também o `IndexOutOfBoundsException` no caso de lista vazia.
- Proponha uma correção com checagens defensivas ou uso de `Optional`.
- Explique por que o `Optional` é uma alternativa mais expressiva.
- Comente que retornar strings de erro misturadas com o nome do cliente não é ideal — o ideal seria lançar uma exceção ou retornar um objeto de resultado.
- Evite sugerir apenas "colocar um try-catch em volta".

**Resposta fraca ou incompleta:**  
*"O problema é que pedidos pode ser null. É só colocar um if antes."*  
Faltou: identificar os outros pontos de NPE (pedido null, cliente null, nome null), mencionar `IndexOutOfBoundsException`, e propor uma solução mais completa.

**Critérios de avaliação:**
- **0** — Não identifica nenhum ponto de falha.
- **1** — Identifica apenas que a lista pode ser null.
- **2** — Identifica dois ou mais pontos de falha, mas a correção é incompleta.
- **3** — Identifica todos os pontos de NPE e propõe checagens adequadas.
- **4** — Propõe correção completa, menciona `Optional` e discute alternativas de design.
- **5** — Responde com profundidade, compara abordagens, menciona o impacto de cada decisão e sugere melhorias de design como retornar um objeto de resultado em vez de strings de erro.

**Perguntas de aprofundamento:**
1. Qual seria a vantagem de usar `Optional` em vez de checagens manuais de null nesse cenário?
2. Se você não pudesse alterar a assinatura do método, como garantiria que o chamador saiba que o resultado pode ser "não encontrado"?
3. Como você documentaria para outros desenvolvedores que esse método pode retornar valores padrão em vez do nome real?

---

###  58.3. <a name='Pergunta53EscolhaentreArrayListeLinkedListemcenrioreal'></a>Pergunta 53 — Escolha entre ArrayList e LinkedList em cenário real

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Você está desenvolvendo um sistema de fila de atendimento de um banco. O sistema precisa adicionar clientes no final da fila e remover do início, um por vez, conforme os caixas ficam disponíveis. Seu colega sugeriu usar `ArrayList` porque "é mais rápido". Você concorda com essa escolha? Qual implementação de `List` você usaria e por quê?

**O que essa pergunta avalia:**  
Conhecimento sobre as diferenças de desempenho entre `ArrayList` e `LinkedList`, compreensão de complexidade de operações (inserção, remoção, acesso), e capacidade de justificar a escolha de uma estrutura de dados com base no cenário.

**Resposta esperada:**  
`ArrayList` não é a melhor escolha para esse cenário. Remover o primeiro elemento de um `ArrayList` exige o deslocamento de todos os elementos restantes para a esquerda, o que tem complexidade O(n). Para uma fila onde a operação de remover do início é frequente, `LinkedList` seria mais eficiente, pois a remoção do início tem complexidade O(1). No entanto, o candidato também pode mencionar que para uma fila de verdade, `ArrayDeque` seria ainda mais adequado que `LinkedList`, pois oferece operações O(1) nos dois extremos com menor overhead de memória.

**Explicação didática:**  
Pense em uma fila de supermercado:

- **ArrayList** é como uma fila onde as pessoas estão em péssimos de um corredor. Quando a primeira pessoa sai, todos precisam dar um passo à frente. Se a fila tem 1000 pessoas, todas precisam se mover — isso é lento.
- **LinkedList** é como uma fila onde cada pessoa segura a mão da próxima. Quando a primeira sai, apenas a segunda pessoa passa a ser a primeira. Ninguém precisa se mover — apenas os "ponteiros" mudam.

Em termos técnicos:
- `ArrayList.remove(0)` → O(n), porque todos os elementos são deslocados.
- `LinkedList.removeFirst()` → O(1), porque apenas as referências são ajustadas.
- `ArrayDeque.pollFirst()` → O(1), e com menor consumo de memória que `LinkedList`.

**Exemplo prático:**  
Um sistema de atendimento bancário com 50 caixas atendendo simultaneamente. A fila pode ter centenas de clientes. A cada 30 segundos, em média, um caixa fica livre e o próximo cliente é chamado. Com `ArrayList`, cada chamada deslocaria toda a fila.

**Exemplo de código:**

```java
// ArrayList — remoção do início é custosa
List<String> filaArray = new ArrayList<>();
filaArray.add("Cliente 1");
filaArray.add("Cliente 2");
filaArray.add("Cliente 3");
filaArray.remove(0); // O(n) — desloca Cliente 2 e Cliente 3

// LinkedList — remoção do início é eficiente
LinkedList<String> filaLinked = new LinkedList<>();
filaLinked.addLast("Cliente 1");
filaLinked.addLast("Cliente 2");
filaLinked.addLast("Cliente 3");
filaLinked.removeFirst(); // O(1) — ajusta apenas as referências

// ArrayDeque — melhor opção para fila
ArrayDeque<String> fila = new ArrayDeque<>();
fila.addLast("Cliente 1");
fila.addLast("Cliente 2");
fila.addLast("Cliente 3");
String proximo = fila.pollFirst(); // O(1) — eficiente e sem overhead de nós
```

**Como o candidato deve responder:**  
- Comece explicando que `ArrayList` não é ideal porque `remove(0)` tem custo O(n).
- Mencione que `LinkedList` resolve o problema com remoção O(1) do início.
- Se possível, sugira `ArrayDeque` como alternativa ainda melhor para filas.
- Justifique a escolha com base na frequência das operações (adição no fim + remoção do início).
- Comente que `ArrayList` seria uma boa escolha se o cenário fosse acesso aleatório frequente (get por índice).
- Evite dizer apenas "LinkedList é melhor" sem explicar o porquê.

**Resposta fraca ou incompleta:**  
*"Eu usaria LinkedList porque é melhor para filas."*  
Faltou: explicar a complexidade das operações, comparar com ArrayList, e idealmente mencionar ArrayDeque como alternativa.

**Critérios de avaliação:**
- **0** — Não sabe diferenciar ArrayList de LinkedList.
- **1** — Sabe que são diferentes, mas não explica por quê.
- **2** — Menciona que LinkedList é melhor para filas, mas não explica a complexidade.
- **3** — Explica corretamente as diferenças de complexidade e justifica a escolha.
- **4** — Compara ArrayList, LinkedList e possivelmente ArrayDeque, com justificativas técnicas.
- **5** — Responde com profundidade, discute trade-offs de memória, menciona que ArrayDeque é superior para filas e explica quando ArrayList seria a escolha certa.

**Perguntas de aprofundamento:**
1. Se você precisasse acessar frequentemente o cliente na posição 500 da fila, qual estrutura usaria?
2. Por que `ArrayDeque` pode ser melhor que `LinkedList` mesmo ambas tendo operações O(1)?
3. Em qual cenário `ArrayList` seria preferível sobre `LinkedList`?

---

###  58.4. <a name='Pergunta54UsocorretodeequalsehashCodeemclassededomnio'></a>Pergunta 54 — Uso correto de equals e hashCode em classe de domínio

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Você tem uma classe `Produto` com os atributos `id` (long), `nome` (String) e `preco` (BigDecimal). Você precisa armazenar produtos em um `HashSet` para evitar duplicatas. Um colega implementou `equals()` comparando apenas o `nome`, mas não implementou `hashCode()`. O que pode dar errado? Como você implementaria esses métodos corretamente?

**O que essa pergunta avalia:**  
Compreensão do contrato entre `equals()` e `hashCode()`, conhecimento sobre o funcionamento de coleções baseadas em hash (`HashSet`, `HashMap`), e capacidade de implementar esses métodos seguindo boas práticas.

**Resposta esperada:**  
O não-implementação de `hashCode()` viola o contrato de `Object.hashCode()`, que diz que se dois objetos são `equals`, eles devem ter o mesmo `hashCode`. Sem `hashCode()` sobrescrito, a classe usa a implementação padrão de `Object`, que retorna um hash baseado no endereço de memória. Isso significa que dois objetos `Produto` com o mesmo `nome` (e portanto `equals` retornando `true`) podem ter `hashCode` diferentes, fazendo com que o `HashSet` os armazene em buckets diferentes e não detecte a duplicata. A implementação correta deve usar os mesmos campos em `equals` e `hashCode` — idealmente `id` e `nome`, ou apenas `id` se for uma chave de negócio.

**Explicação didática:**  
Imagine que o `HashSet` é um armário com várias gavetas. O `hashCode` determina em qual gaveta o objeto vai ficar. O `equals` é usado para verificar se dois objetos na mesma gaveta são realmente iguais.

Se você implementa `equals` mas não `hashCode`, é como dizer "duas pessoas são a mesma se tiverem o mesmo nome", mas mandar cada uma para uma gaveta aleatória. O armário nunca vai conseguir encontrar a duplicata porque nem olha na gaveta certa.

A regra de ouro é: **sempre que sobrescrever `equals`, sobrescreva `hashCode` usando os mesmos campos.**

**Exemplo prático:**  
Um sistema de catálogo de produtos importa dados de duas planilhas diferentes. Produtos duplicados (mesmo nome e mesmo ID) devem ser automaticamente filtrados ao inserir em um `HashSet`.

**Exemplo de código:**

```java
import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
    private long id;
    private String nome;
    private BigDecimal preco;
    
    public Produto(long id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    
    // equals e hashCode usam os MESMOS campos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id 
            && Objects.equals(nome, produto.nome);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
    
    // Getters omitidos para brevidade
}
```

Note que `preco` não participa de `equals` nem de `hashCode` — dois produtos com o mesmo ID e nome são considerados iguais mesmo que o preço tenha mudado, o que faz sentido em um catálogo.

**Como o candidato deve responder:**  
- Explique o contrato entre `equals` e `hashCode`: objetos iguais devem ter o mesmo hashCode.
- Descreva o que acontece quando `hashCode` não é implementado: o `HashSet` não detecta duplicatas.
- Implemente os dois métodos usando os mesmos campos.
- Mencione o uso de `Objects.equals()` e `Objects.hash()` para evitar null checks manuais.
- Discuta quais campos devem participar (id e nome faz sentido; preço provavelmente não).
- Evite implementar `equals` sem `hashCode` ou vice-versa.

**Resposta fraca ou incompleta:**  
*"Sem o hashCode o HashSet não funciona direito, é só usar o Eclipse para gerar os dois."*  
Faltou: explicar por que o contrato é violado, quais campos devem participar, e por que o preço não deve ser incluído.

**Critérios de avaliação:**
- **0** — Não sabe o que equals e hashCode fazem.
- **1** — Sabe que existem mas não explica o contrato.
- **2** — Menciona o contrato mas não implementa corretamente ou usa campos diferentes.
- **3** — Explica o contrato, implementa ambos com os mesmos campos e justifica a escolha dos campos.
- **4** — Usa Objects.equals/hash, discute quais campos incluir, menciona null-safety.
- **5** — Responde com profundidade, discute imutabilidade, mentions quando usar apenas `id`, e o impacto de campos mutáveis no hashCode.

**Perguntas de aprofundamento:**
1. O que aconteceria se você incluísse `preco` (BigDecimal) no `hashCode` e o preço mudasse após o objeto já estar no `HashSet`?
2. Por que `Objects.equals()` é preferível a comparar Strings com `==`?
3. Em qual situação faria sentido implementar `equals` comparando apenas o `id`?

---

###  58.5. <a name='Pergunta55Vazamentoderecursocomconexodebancodedadosnofechada'></a>Pergunta 55 — Vazamento de recurso com conexão de banco de dados não fechada

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Sua aplicação Java começou a apresentar lentidão progressiva após algumas horas de uso. Após investigação, a equipe descobriu que o pool de conexões de banco de dados está atingindo o limite máximo. Analisando o código, encontraram vários métodos que abrem conexões, mas nem todos as fecham adequadamente. Como você corrigiria esse problema e o que faria para evitar que aconteça novamente?

**O que essa pergunta avalia:**  
Conhecimento sobre gerenciamento de recursos em Java (fechar conexões, statements, result sets), uso de `try-with-resources`, compreensão de vazamento de recursos e boas práticas preventivas.

**Resposta esperada:**  
O candidato deve identificar que conexões de banco de dados são recursos limitados que precisam ser fechados após o uso. Se não forem fechadas, o pool se esgota e a aplicação para de funcionar. A correção imediata é usar `try-with-resources` (disponível desde o Java 7), que fecha automaticamente qualquer objeto que implemente `AutoCloseable`. Como prevenção, o candidato deve sugerir revisão de código focada em recursos, uso de ferramentas de análise estática (como SonarQube) e monitoramento do pool de conexões.

**Explicação didática:**  
Pense em conexões de banco de dados como cadeiras em uma sala de espera. Se as pessoas entram, são atendidas, mas não saem da sala, em algum momento não haverá mais cadeiras disponíveis para novos visitantes.

O pool de conexões tem um número fixo de conexões (ex: 20). Cada método que abre uma conexão e não fecha está "ocupando uma cadeira" permanentemente. Quando as 20 estão ocupadas, qualquer nova solicitação fica esperando indefinidamente.

O `try-with-resources` é como uma sala com porteiro automático: ao terminar o uso, a porta se abre sozinha e a cadeira é liberada, mesmo que ocorra uma exceção.

**Exemplo prático:**  
Uma aplicação web que processa pedidos. Cada pedido abre uma conexão para gravar no banco. Em horário de pico, centenas de pedidos são processados por minuto. Se 5% dos métodos não fecham a conexão, em poucas horas o pool se esgota.

**Exemplo de código:**

```java
// Código com problema — conexão não é fechada se ocorrer exceção
public Pedido buscarPedido(int id) throws SQLException {
    Connection conn = dataSource.getConnection();
    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pedidos WHERE id = ?");
    stmt.setInt(1, id);
    ResultSet rs = stmt.executeQuery();
    
    if (rs.next()) {
        // Se ocorrer uma exceção aqui, conn, stmt e rs NUNCA são fechados
        return new Pedido(rs.getInt("id"), rs.getString("cliente"));
    }
    
    rs.close();
    stmt.close();
    conn.close(); // Só chega aqui se nenhuma exceção ocorrer
    return null;
}

// Código corrigido — try-with-resources fecha tudo automaticamente
public Pedido buscarPedido(int id) throws SQLException {
    String sql = "SELECT * FROM pedidos WHERE id = ?";
    
    // Todos os recursos são declarados entre parênteses
    // Connection, PreparedStatement e ResultSet implementam AutoCloseable
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Pedido(rs.getInt("id"), rs.getString("cliente"));
            }
        }
    }
    // Neste ponto, rs, stmt e conn já foram fechados automaticamente,
    // mesmo que uma exceção tenha sido lançada
    return null;
}
```

**Como o candidato deve responder:**  
- Comece explicando o que é vazamento de recurso: conexão aberta e nunca fechada.
- Mencione que o pool de conexões tem limite e que cada conexão não devolvida reduz a capacidade.
- Apresente `try-with-resources` como a solução padrão desde o Java 7.
- Explique que `Connection`, `PreparedStatement` e `ResultSet` implementam `AutoCloseable`.
- Comente sobre prevenção: revisão de código, análise estática, e monitoramento do pool.
- Evite sugerir `finally` com `close()` manual como solução principal — é propenso a erros.

**Resposta fraca ou incompleta:**  
*"É só colocar conn.close() no final do método."*  
Faltou: considerar que exceções podem impedir a execução do `close()`, mencionar `try-with-resources`, e discutir prevenção.

**Critérios de avaliação:**
- **0** — Não entende o conceito de vazamento de recurso.
- **1** — Sabe que conexões devem ser fechadas, mas não sabe como garantir isso.
- **2** — Menciona `finally` ou `try-with-resources`, mas não explica corretamente.
- **3** — Explica o problema e propõe `try-with-resources` corretamente.
- **4** — Demonstra domínio prático, menciona AutoCloseable, múltiplos recursos, e prevenção.
- **5** — Responde com profundidade, discute ordem de fechamento, exceções suprimidas, e estratégias de monitoramento do pool.

**Perguntas de aprofundamento:**
1. O que acontece se ocorrer uma exceção dentro do bloco `try-with-resources` — os recursos ainda são fechados?
2. Qual é a ordem em que múltiplos recursos são fechados quando declarados no `try-with-resources`?
3. Como você monitoraria o pool de conexões para detectar vazamentos antes que a aplicação pare?

---

###  58.6. <a name='Pergunta56ComparaodeStringscomequalsvs'></a>Pergunta 56 — Comparação de Strings com equals vs ==

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Um desenvolvedor júnior da sua equipe escreveu o seguinte código para validar o tipo de usuário em um sistema de login:

```java
if (usuario.getTipo() == "ADMIN") {
    liberarAcessoAdmin();
}
```

Ele afirma que o código "funciona na maioria das vezes", mas ocasionalmente o acesso admin não é liberado mesmo para usuários admin. Como você explicaria para ele o que está acontecendo e qual é a correção?

**O que essa pergunta avalia:**  
Compreensão da diferença entre `==` (comparação de referência) e `.equals()` (comparação de conteúdo) em Java, conhecimento sobre o pool de strings, e capacidade de explicar conceitos fundamentais para outros desenvolvedores.

**Resposta esperada:**  
O operador `==` compara referências de memória, não o conteúdo das strings. Em Java, existe um mecanismo chamado "string pool" que às vezes faz com que duas strings literais apontem para o mesmo objeto, fazendo `==` funcionar aparentemente. Mas quando uma string vem de uma fonte externa (banco de dados, input do usuário, arquivo), ela é um objeto novo e `==` retorna `false` mesmo que o conteúdo seja idêntico. A correção é usar `usuario.getTipo().equals("ADMIN")` ou, melhor ainda, `"ADMIN".equals(usuario.getTipo())` para evitar `NullPointerException`.

**Explicação didática:**  
Imagine duas pessoas com o mesmo nome "João". Se você perguntar "essas duas pessoas são a mesma pessoa?" (==), a resposta é não, mesmo que tenham o mesmo nome. Mas se você perguntar "elas têm o mesmo nome?" (.equals()), a resposta é sim.

O "string pool" é uma otimização da JVM: quando você cria uma string literal como `"ADMIN"`, a JVM guarda essa string em um espaço especial e reutiliza a mesma referência. Por isso `"ADMIN" == "ADMIN"` retorna `true`. Mas se a string vier de um `Scanner`, de um banco de dados, ou de um arquivo, a JVM cria um novo objeto, e a comparação com `==` falha.

**Exemplo prático:**  
Um sistema de login onde o tipo de usuário vem do banco de dados. No cadastro, o tipo foi salvo como "ADMIN". Ao fazer login, `usuario.getTipo()` retorna uma nova String "ADMIN" (criada a partir dos dados do banco). A comparação `== "ADMIN"` falha porque são objetos diferentes na memória, mesmo com conteúdo idêntico.

**Exemplo de código:**

```java
// Problema: == compara referências, não conteúdo
String tipo1 = "ADMIN";        // Vai para o string pool
String tipo2 = "ADMIN";        // Reutiliza a mesma referência do pool
String tipo3 = new String("ADMIN"); // Cria um novo objeto
String tipo4 = usuario.getTipo();   // Vem do banco — novo objeto

System.out.println(tipo1 == tipo2); // true — mesma referência do pool
System.out.println(tipo1 == tipo3); // false — objetos diferentes
System.out.println(tipo1 == tipo4); // false — vem de fonte externa

System.out.println(tipo1.equals(tipo3)); // true — mesmo conteúdo
System.out.println(tipo1.equals(tipo4)); // true — mesmo conteúdo

// Correção do código do colega:
// Forma segura — evita NPE se getTipo() retornar null
if ("ADMIN".equals(usuario.getTipo())) {
    liberarAcessoAdmin();
}

// Alternativa com null-check explícito
if (usuario.getTipo() != null && usuario.getTipo().equals("ADMIN")) {
    liberarAcessoAdmin();
}
```

**Como o candidato deve responder:**  
- Comece explicando a diferença entre `==` (referência) e `.equals()` (conteúdo).
- Mencione o string pool e por que `==` "parece" funcionar às vezes.
- Explique que strings de fontes externas são novos objetos.
- Apresente a correção com `.equals()`.
- Mencione a boa prática de colocar a literal primeiro: `"ADMIN".equals(variavel)` para evitar NPE.
- Evite apenas dizer "use equals" sem explicar o porquê.

**Resposta fraca ou incompleta:**  
*"Tem que usar equals em vez de == porque é String."*  
Faltou: explicar o string pool, o motivo de `==` funcionar às vezes, e a boa prática de colocar a literal primeiro.

**Critérios de avaliação:**
- **0** — Não sabe a diferença entre `==` e `.equals()`.
- **1** — Sabe que existe diferença, mas não explica o porquê.
- **2** — Menciona que `==` compara referência, mas não explica o string pool.
- **3** — Explica corretamente a diferença, o string pool, e propõe `.equals()`.
- **4** — Explica tudo, menciona a boa prática de `"ADMIN".equals(var)` para evitar NPE.
- **5** — Responde com profundidade, explica o pool de strings, discute `intern()`, e sabe explicar o conceito para um desenvolvedor júnior de forma didática.

**Perguntas de aprofundamento:**
1. O que o método `intern()` faz e em qual caso ele poderia fazer `==` funcionar entre strings de fontes diferentes?
2. Por que `"ADMIN".equals(variavel)` é mais seguro que `variavel.equals("ADMIN")`?
3. Em quais situações o uso de `==` para comparar strings é aceitável em Java?

---

###  58.7. <a name='Pergunta57Sobrescritavssobrecargademtodoemclassededomnio'></a>Pergunta 57 — Sobrescrita vs sobrecarga de método em classe de domínio

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Você tem uma classe `Calculadora` com um método `somar(int a, int b)`. Um colega criou também `somar(double a, double b)` e `somar(int a, int b, int c)` na mesma classe. Em outra situação, uma classe `CalculadoraCientifica extends Calculadora` redefine o método `somar(int a, int b)` com uma implementação diferente. Explique a diferença entre o que o colega fez e o que a subclasse fez. Quais regras de compilador se aplicam a cada caso?

**O que essa pergunta avalia:**  
Diferença entre sobrecarga (overloading) e sobrescrita (overriding) de métodos, regras de assinatura de método, uso de `@Override`, e compreensão de polimorfismo em tempo de compilação vs execução.

**Resposta esperada:**  
A criação de múltiplos métodos `somar` com parâmetros diferentes na mesma classe é **sobrecarga (overloading)** — o compilador escolhe qual método chamar com base nos tipos e quantidade de argumentos, em tempo de compilação. A redefinição do método `somar(int a, int b)` na subclasse é **sobrescrita (overriding)** — a JVM decide em tempo de execução qual implementação executar, com base no tipo real do objeto (não na referência). A sobrescrita exige a mesma assinatura (nome + parâmetros), e a anotação `@Override` deve ser usada para que o compilador verifique se a sobrescrita é válida.

**Explicação didática:**  
Pense em um restaurante:

- **Sobrecarga** é como ter três botões de "pedir" diferentes: um para pedir água, outro para pedir refrigerante, outro para pedir suco. O garçom sabe qual você quer pelo que você pede. O nome é o mesmo ("pedir"), mas os parâmetros são diferentes.
- **Sobrescrita** é como o chef de cozinha ter uma receita de "molho" e o chef júnior ter uma versão modificada do mesmo molho. Quando você pede "molho", depende de quem está cozinhando — você recebe a versão do chef que está na cozinha naquele momento.

A diferença técnica fundamental:
- **Sobrecarga:** resolvida em **tempo de compilação** (static binding). Mesma classe. Parâmetros diferentes.
- **Sobrescrita:** resolvida em **tempo de execução** (dynamic binding). Classe pai e filha. Mesma assinatura.

**Exemplo prático:**  
Um sistema de cálculo de impostos onde diferentes regiões têm algoritmos diferentes. A classe base `CalculadoraImposto` tem `calcular(Pedido p)`. A subclasse `CalculadoraImpostoSP` sobrescreve o método para aplicar a regra de São Paulo.

**Exemplo de código:**

```java
// Classe base — sobrecarga (overloading)
public class Calculadora {
    
    public int somar(int a, int b) {
        return a + b;
    }
    
    // Sobrecarga: mesmos nome, parâmetros diferentes
    public double somar(double a, double b) {
        return a + b;
    }
    
    // Sobrecarga: mesmo nome, mais um parâmetro
    public int somar(int a, int b, int c) {
        return a + b + c;
    }
}

// Subclasse — sobrescrita (overriding)
public class CalculadoraCientifica extends Calculadora {
    
    @Override // Anotação que garante que a sobrescrita é válida
    public int somar(int a, int b) {
        // Implementação diferente do método da classe pai
        // Exemplo: soma com log de auditoria
        System.out.println("Somando: " + a + " + " + b);
        return a + b;
    }
}

// Demonstração da diferença
public class Main {
    public static void main(String[] args) {
        // Sobrecarga — decisão em tempo de compilação
        Calculadora calc = new Calculadora();
        calc.somar(1, 2);       // chama somar(int, int)
        calc.somar(1.0, 2.0);   // chama somar(double, double)
        calc.somar(1, 2, 3);    // chama somar(int, int, int)
        
        // Sobrescrita — decisão em tempo de execução
        Calculadora calcCientifica = new CalculadoraCientifica();
        calcCientifica.somar(1, 2); 
        // O tipo da referência é Calculadora, mas o objeto real é
        // CalculadoraCientifica — a JVM chama a versão sobrescrita
    }
}
```

**Como o candidato deve responder:**  
- Diferencie claramente sobrecarga (overloading) de sobrescrita (overriding).
- Explique que sobrecarga acontece na mesma classe com parâmetros diferentes.
- Explique que sobrescrita acontece em subclasse com a mesma assinatura.
- Mencione que a decisão de qual método chamar é: compilação para sobrecarga, execução para sobrescrita.
- Comente sobre o uso da anotação `@Override`.
- Mencione o polimorfismo: uma referência do tipo pai pode apontar para um objeto filho, e a sobrescrita é o que permite isso funcionar.
- Evite confundir os dois conceitos.

**Resposta fraca ou incompleta:**  
*"Sobrecarga é quando você tem métodos com o mesmo nome, e sobrescrita é quando você muda o método na subclasse."*  
Faltou: explicar que a decisão acontece em momentos diferentes (compilação vs execução), mencionar `@Override`, e explicar o polimorfismo.

**Critérios de avaliação:**
- **0** — Não diferencia os dois conceitos.
- **1** — Sabe que são diferentes, mas não explica corretamente as regras.
- **2** — Explica basicamente, mas confunde alguns aspectos (ex: acha que sobrescrita é em tempo de compilação).
- **3** — Diferencia corretamente, explica as regras de assinatura e quando cada decisão acontece.
- **4** — Menciona `@Override`, polimorfismo, e as implicações práticas.
- **5** — Responde com profundidade, discute regras de retorno covariante, exceções declaradas em sobrescrita, e o papel do polimorfismo no design orientado a objetos.

**Perguntas de aprofundamento:**
1. O que acontece se você sobrescrever um método mas esquecer a anotação `@Override`? O código compila?
2. Você pode sobrescrever um método mudando o tipo de retorno? Em quais condições?
3. Em quais situações a sobrecarga pode causar confusão ou bugs difíceis de encontrar?

---

###  58.8. <a name='Pergunta58Loopinfinitoporerrodelgicacomwhile'></a>Pergunta 58 — Loop infinito por erro de lógica com while

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Um estagiário escreveu o código abaixo para processar itens de uma lista até que todos sejam processados. O código entra em loop infinito em alguns casos. Analise o código, identifique o problema e proponha uma correção.

```java
List<String> itens = obterItens();
int i = 0;
while (i < itens.size()) {
    if (itens.get(i).startsWith("SKIP_")) {
        continue; // pula itens marcados com SKIP_
    }
    processar(itens.get(i));
    i++;
}
```

**O que essa pergunta avalia:**  
Capacidade de depurar lógica de loop, entender o fluxo de execução com `continue`, identificar loops infinitos, e propor correções mantendo a intenção do código.

**Resposta esperada:**  
O problema é que quando um item começa com "SKIP_", o `continue` pula diretamente para a próxima iteração do `while` sem incrementar o `i`. Isso faz com que o índice nunca avance quando encontra um item "SKIP_", criando um loop infinito. A correção é mover o `i++` para fora do bloco condicional, ou usar um `for` tradicional, que separa a lógica de incremento da lógica de processamento.

**Explicação didática:**  
Imagine uma esteira de produtos onde você precisa inspecionar cada item. Você pega o item na posição 0. Se ele estiver marcado como "SKIP_", você volta ao início da esteira — mas continua pegando o item da posição 0 novamente, porque nunca avançou a esteira.

O `continue` em um `while` pula tudo o que vem depois dele (incluindo o `i++`) e volta a testar a condição. Como `i` não foi incrementado, a condição continua verdadeira e o mesmo item é verificado novamente — para sempre.

O `for` tradicional resolve isso porque o incremento (`i++`) está na declaração do loop e é executado independentemente de `continue`.

**Exemplo prático:**  
Um sistema de importação de dados que recebe uma lista de registros e precisa processar apenas os válidos, pulando os marcados como "SKIP_" (duplicados ou com erro conhecido).

**Exemplo de código:**

```java
// Código com problema — loop infinito quando encontra "SKIP_"
List<String> itens = obterItens();
int i = 0;
while (i < itens.size()) {
    if (itens.get(i).startsWith("SKIP_")) {
        continue; // PROBLEMA: i++ nunca é executado!
    }
    processar(itens.get(i));
    i++; // Só chega aqui se o item NÃO começa com "SKIP_"
}

// Correção 1: mover o incremento para antes do continue
int i = 0;
while (i < itens.size()) {
    String item = itens.get(i);
    i++; // Incrementa sempre, antes de qualquer condição
    if (item.startsWith("SKIP_")) {
        continue; // Agora é seguro — i já foi incrementado
    }
    processar(item);
}

// Correção 2: usar for tradicional (mais legível e seguro)
for (int i = 0; i < itens.size(); i++) {
    String item = itens.get(i);
    if (item.startsWith("SKIP_")) {
        continue; // O for garante o incremento mesmo com continue
    }
    processar(item);
}

// Correção 3: usar enhanced for (mais idiomático)
for (String item : itens) {
    if (item.startsWith("SKIP_")) {
        continue;
    }
    processar(item);
}
```

**Como o candidato deve responder:**  
- Identifique que o `continue` impede o `i++` de ser executado.
- Explique o fluxo: quando encontra "SKIP_", volta ao início do loop com o mesmo `i`.
- Proponha pelo menos uma correção (idealmente mais de uma).
- Mencione que o `for` tradicional é mais seguro porque separa o incremento da lógica de processamento.
- Considere o enhanced for como alternativa ainda mais limpa quando não se precisa do índice.
- Evite apenas dizer "tem um bug" sem explicar o fluxo exato.

**Resposta fraca ou incompleta:**  
*"O continue está causando o problema. É só tirar o continue."*  
Faltou: explicar exatamente por que o loop é infinito (i não é incrementado), e propor uma correção que mantenha a intenção de pular itens.

**Critérios de avaliação:**
- **0** — Não identifica o problema.
- **1** — Identifica que há um loop, mas não explica a causa.
- **2** — Identifica que o `continue` é o problema, mas a correção é incorreta ou incompleta.
- **3** — Explica corretamente que `i++` não é executado e propõe uma correção funcional.
- **4** — Propõe múltiplas correções, menciona `for` tradicional e enhanced for como alternativas.
- **5** — Responde com profundidade, compara as abordagens, discute legibilidade, e menciona que o enhanced for é preferível quando não se precisa do índice.

**Perguntas de aprofundamento:**
1. Por que o `for` tradicional garante o incremento mesmo com `continue`, mas o `while` não?
2. Qual seria a diferença de comportamento se você usasse `break` em vez de `continue` nesse código?
3. Como você testaria esse código para garantir que o loop infinito não ocorre mais?

---

###  58.9. <a name='Pergunta59Escolhaentrearrayprimitivoecoleoparaarmazenarnotas'></a>Pergunta 59 — Escolha entre array primitivo e coleção para armazenar notas

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Você está desenvolvendo uma classe `Aluno` que precisa armazenar as notas do aluno. O número de notas varia: alguns alunos têm 3 notas, outros têm 5, e o sistema pode adicionar notas ao longo do semestre. Um colega sugeriu usar `double[] notas` com tamanho fixo de 10. Outro sugeriu `List<Double> notas`. Qual abordagem você escolheria e por quê? Há algum problema com `List<Double>`?

**O que essa pergunta avalia:**  
Conhecimento sobre arrays vs coleções em Java, compreensão de autoboxing e suas implicações de desempenho, capacidade de escolher a estrutura de dados adequada para o cenário, e identificação de problemas sutis como o overhead de boxing com `List<Double>`.

**Resposta esperada:**  
`List<Double>` é a melhor escolha para esse cenário porque o número de notas é dinâmico. Um array de tamanho fixo exigiria redimensionamento manual, cópia de dados e gerenciamento de posições vazias. No entanto, `List<Double>` tem um custo: cada `double` primitivo é convertido automaticamente em um objeto `Double` (autoboxing), o que consome mais memória. O candidato deve mencionar esse trade-off. Se o desempenho for crítico e o número de notas for pequeno, um array redimensionado manualmente poderia ser considerado, mas na maioria dos casos práticos a `List<Double>` (especialmente `ArrayList`) é a escolha correta pela simplicidade e flexibilidade.

**Explicação didática:**  
Pense em duas formas de guardar notas em uma caderneta:

- **Array (`double[]`)** é como uma folha com 10 linhas pré-impressas. Se o aluno tem 3 notas, você usa 3 linhas e 7 ficam vazias. Se ele fizer a 11ª nota, você precisa passar tudo a limpo em uma nova folha com mais linhas. É trabalhoso.
- **`ArrayList<Double>`** é como um caderno com folhas destacáveis. Você adiciona folhas conforme precisa, sem se preocupar com o tamanho inicial.

O custo do caderno é que cada folha é um pouco mais "pesada" — no caso do código, cada `double` (8 bytes, tipo primitivo) vira um `Double` (objeto, ~16+ bytes) quando entra na `List`. Para 10 notas, isso é irrelevante. Para milhões de números, faria diferença.

**Exemplo prático:**  
Um sistema acadêmico onde alunos podem ter provas substitutivas adicionadas após o fechamento do semestre. O número de avaliações não é fixo e pode mudar.

**Exemplo de código:**

```java
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    // List<Double> — flexível, cresce automaticamente
    private List<Double> notas;
    
    public Aluno(String nome) {
        this.nome = nome;
        this.notas = new ArrayList<>(); // começa vazia
    }
    
    public void adicionarNota(double nota) {
        // autoboxing: double primitivo -> Double objeto
        notas.add(nota);
    }
    
    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double soma = 0.0;
        for (Double nota : notas) {
            soma += nota; // unboxing: Double -> double
        }
        return soma / notas.size();
    }
    
    // Alternativa com stream (Java 8+)
    public double calcularMediaStream() {
        return notas.stream()
                    .mapToDouble(Double::doubleValue) // evita unboxing implícito
                    .average()
                    .orElse(0.0);
    }
}
```

**Como o candidato deve responder:**  
- Comece dizendo que `List<Double>` é mais adequada porque o tamanho é dinâmico.
- Explique o problema do array fixo: tamanho pré-definido, redimensionamento manual, posições vazias.
- Mencione o autoboxing: `double` (primitivo) vira `Double` (objeto) ao entrar na lista.
- Comente que para o cenário de notas (poucos elementos), o overhead é irrelevante.
- Se possível, mencione que bibliotecas como Eclipse Collections ou Trove oferecem listas primitivas (`DoubleList`) se desempenho for crítico.
- Evite dizer apenas "use List porque é melhor" sem explicar o trade-off.

**Resposta fraca ou incompleta:**  
*"Usaria List porque array é antigo."*  
Faltou: explicar por que array é inadequeado para tamanho dinâmico, mencionar autoboxing, e discutir o trade-off.

**Critérios de avaliação:**
- **0** — Não sabe diferenciar array de List.
- **1** — Escolhe List, mas não justifica adequadamente.
- **2** — Justifica a escolha, mas não menciona autoboxing.
- **3** — Explica corretamente, menciona autoboxing como trade-off.
- **4** — Discute o overhead de memória, compara abordagens, e menciona alternativas para alto desempenho.
- **5** — Responde com profundidade, menciona bibliotecas de coleções primitivas, discute quando array seria aceitável, e considera o impacto em cenários de escala.

**Perguntas de aprofundamento:**
1. Qual é a diferença de memória entre um `double[10]` e um `ArrayList<Double>` com 10 elementos?
2. O que aconteceria se você passasse `null` para `notas.add(null)` e depois chamasse `calcularMedia()`?
3. Em qual cenário de alto desempenho você escolheria um array primitivo em vez de uma coleção?

---

###  58.10. <a name='Pergunta60Usodestaticemexcessoeproblemasdetestabilidade'></a>Pergunta 60 — Uso de static em excesso e problemas de testabilidade

**Nível:** Júnior  
**Categoria:** Boas práticas

**Pergunta do entrevistador:**  
Em uma revisão de código, você encontra uma classe `UtilitarioData` com vários métodos `static` que formatam datas, calculam diferença entre datas e validam feriados. A classe também tem um atributo `static SimpleDateFormat formato` compartilhado entre todos os métodos. Um colega diz que métodos `static` são mais rápidos e que a classe está "otimizada". Você concorda? Que problemas essa abordagem pode causar?

**O que essa pergunta avalia:**  
Compreensão do modificador `static`, problemas de concorrência com atributos estáticos, conhecimento sobre thread-safety de `SimpleDateFormat`, e noções de testabilidade e design orientado a objetos.

**Resposta esperada:**  
A abordagem tem dois problemas principais. Primeiro, `SimpleDateFormat` **não é thread-safe** — se múltiplas threads usam o mesmo formato compartilhado, pode ocorrer corrupção de dados ou resultados incorretos. Segundo, o uso excessivo de métodos `static` dificulta a testabilidade (não é possível usar mocks) e viola princípios de OO, pois cria acoplamento forte. A correção envolve criar instâncias de `SimpleDateFormat` locais a cada método (ou usar `DateTimeFormatter` do `java.time`, que é thread-safe) e converter a classe para uma instanciável quando fizer sentido.

**Explicação didática:**  
Imagine uma calculadora compartilhada por toda uma empresa. Se for `static`, é como se existisse uma única calculadora física no escritório. Se duas pessoas tentarem usá-la ao mesmo tempo, uma pode apertar os botões enquanto a outra está no meio de um cálculo — o resultado sai errado.

`SimpleDateFormat` é exatamente assim: ele mantém estado interno durante a formatação. Se duas threads acessam a mesma instância, uma pode sobrescrever o estado da outra no meio de uma operação, gerando resultados imprevisíveis — sem nem lançar uma exceção.

Métodos `static` não são "mais rápidos" de forma significativa. A diferença de desempenho é negligenciável. O custo de design (acoplamento, dificuldade de teste) é muito maior que qualquer benefício.

**Exemplo prático:**  
Uma aplicação web que atende múltiplas requisições simultaneamente. Cada requisição pode chamar `UtilitarioData.formatar(data)` ao mesmo tempo. Como `SimpleDateFormat` é compartilhado e não é thread-safe, datas podem ser formatadas incorretamente sem nenhum erro visível.

**Exemplo de código:**

```java
// Código com problema — SimpleDateFormat estático e compartilhado
public class UtilitarioData {
    // PROBLEMA 1: SimpleDateFormat não é thread-safe
    private static SimpleDateFormat formato = 
        new SimpleDateFormat("dd/MM/yyyy");
    
    public static String formatar(Date data) {
        // Múltiplas threads chamando isto simultaneamente = bug
        return formato.format(data);
    }
    
    public static long diferencaEmDias(Date d1, Date d2) {
        return (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24);
    }
}

// Correção 1: criar instância local a cada chamada
public class UtilitarioData {
    
    private static final String PADRAO = "dd/MM/yyyy";
    
    public static String formatar(Date data) {
        // Nova instância a cada chamada — thread-safe
        SimpleDateFormat formato = new SimpleDateFormat(PADRAO);
        return formato.format(data);
    }
}

// Correção 2 (Java 8+): usar DateTimeFormatter — thread-safe
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilitarioData {
    // DateTimeFormatter É thread-safe — pode ser estático
    private static final DateTimeFormatter FORMATO = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static String formatar(LocalDate data) {
        return data.format(FORMATO);
    }
}

// Correção 3: classe instanciável para melhor testabilidade
public class FormatadorData {
    private final DateTimeFormatter formato;
    
    public FormatadorData(String padrao) {
        this.formato = DateTimeFormatter.ofPattern(padrao);
    }
    
    public String formatar(LocalDate data) {
        return data.format(formato);
    }
}
// Em testes: new FormatadorData("dd-MM-yyyy").formatar(...)
```

**Como o candidato deve responder:**  
- Comece identificando o problema mais grave: `SimpleDateFormat` não é thread-safe.
- Explique que métodos `static` não são significativamente mais rápidos.
- Mencione que o uso excessivo de `static` prejudica testabilidade (não é possível mockar).
- Sugira `DateTimeFormatter` (Java 8+) como alternativa thread-safe.
- Proponha tornar a classe instanciável quando a testabilidade for importante.
- Evite concordar que `static` é uma otimização válida.

**Resposta fraca ou incompleta:**  
*"Static é ruim porque não é orientado a objetos."*  
Faltou: explicar o problema de thread-safety do `SimpleDateFormat`, mencionar `DateTimeFormatter`, e discutir testabilidade.

**Critérios de avaliação:**
- **0** — Não identifica nenhum problema com o código.
- **1** — Menciona que static é "ruim", mas não explica por quê.
- **2** — Identifica um problema (thread-safety ou testabilidade), mas não os dois.
- **3** — Identifica os dois problemas e propõe correção razoável.
- **4** — Menciona `DateTimeFormatter`, discute testabilidade, e propõe classe instanciável.
- **5** — Responde com profundidade, discute o impacto de static em design, menciona alternativas como `ThreadLocal<SimpleDateFormat>`, e explica quando static é apropriado vs. inapropriado.

**Perguntas de aprofundamento:**
1. Se você não pudesse usar `java.time` (Java 7 ou anterior), como garantiria thread-safety com `SimpleDateFormat`?
2. Por que é difícil escrever testes unitários para classes com muitos métodos `static`?
3. Em quais situações o uso de métodos `static` é apropriado e justificado?

---

**Resumo da Parte 6:**

| Pergunta | Título | Categoria |
|---|---|---|
| 51 | Tratamento de exceção em método que pode falhar por múltiplas razões | Troubleshooting |
| 52 | NullPointerException evitável em código de manipulação de listas | Troubleshooting |
| 53 | Escolha entre ArrayList e LinkedList em cenário real | Fundamentos |
| 54 | Uso correto de equals e hashCode em classe de domínio | Fundamentos |
| 55 | Vazamento de recurso com conexão de banco de dados não fechada | Troubleshooting |
| 56 | Comparação de Strings com equals vs == | Fundamentos |
| 57 | Sobrescrita vs sobrecarga de método em classe de domínio | Fundamentos |
| 58 | Loop infinito por erro de lógica com while | Troubleshooting |
| 59 | Escolha entre array primitivo e coleção para armazenar notas | Prática |
| 60 | Uso de static em excesso e problemas de testabilidade | Boas práticas |

**Perguntas apresentadas até aqui:** 1 a 60  
**Perguntas restantes:** 61 a 100

Quer que eu continue com a Parte 7 (perguntas 61 a 70)?

---

##  59. <a name='Parte7Perguntas61a70'></a>Parte 7 — Perguntas 61 a 70

---

###  59.1. <a name='Pergunta61TratamentodeNullPointerExceptionemcdigolegado'></a>Pergunta 61 — Tratamento de NullPointerException em código legado

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Você está dando manutenção em um código legado Java e recebe um chamado de produção relatando que o sistema lança `NullPointerException` ao tentar processar pedidos de alguns clientes. O erro ocorre na seguinte linha:

```java
String cidade = cliente.getEndereco().getCidade().toUpperCase();
```

O que você faria para corrigir e prevenir esse problema? Explique as abordagens que conhece.

**O que essa pergunta avalia:**  
Capacidade de identificar cadeias de chamadas que podem gerar NPE, conhecimento sobre `Optional`, null checks defensivos, e compreensão de boas práticas para tratamento de null em Java.

**Resposta esperada:**  
O candidato deve reconhecer que a cadeia `cliente.getEndereco().getCidade().toUpperCase()` possui três pontos potenciais de NPE: `cliente` ser null, `getEndereco()` retornar null, ou `getCidade()` retornar null. Deve apresentar soluções como: verificação explícita com `if`, uso de `Optional.ofNullable()` com encadeamento seguro, e discussão sobre a importância de validar dados na entrada (camada de serviço ou DTO). Também deve mencionar que o ideal é tratar a causa raiz — entender por que esses valores chegam null.

**Explicação didática:**  
`NullPointerException` (NPE) é uma das exceções mais comuns em Java. Ela ocorre quando tentamos acessar um membro (método ou atributo) de uma referência que aponta para `null`. No código acima, qualquer um dos três encadeamentos pode ser null.

**Null check tradicional:**
```java
if (cliente != null && cliente.getEndereco() != null 
    && cliente.getEndereco().getCidade() != null) {
    String cidade = cliente.getEndereco().getCidade().toUpperCase();
    // processa cidade
} else {
    // define um valor padrão ou lança exceção de negócio
    throw new IllegalArgumentException("Dados de endereço incompletos para o cliente");
}
```

**Usando Optional (Java 8+):**
```java
String cidade = Optional.ofNullable(cliente)
    .map(Cliente::getEndereco)
    .map(Endereco::getCidade)
    .map(String::toUpperCase)
    .orElse("CIDADE NÃO INFORMADA");
    // ou .orElseThrow(() -> new IllegalArgumentException("Endereço incompleto"));
```

**Exemplo prático:**  
Em um sistema de e-commerce, um cliente pode ter cadastrado apenas o nome e o CPF, sem preencher o endereço. Se o fluxo de cálculo de frete tentar acessar `cliente.getEndereco().getCidade()` sem validação, a aplicação quebrará em produção.

**Como o candidato deve responder:**  
- Identificar todos os pontos de falha na cadeia de chamadas (não apenas um)
- Apresentar pelo menos duas abordagens (null check e Optional)
- Mencionar que tratar a causa raiz é melhor que apenas evitar o NPE
- Comentar sobre a importância de contratos claros entre camadas (um método que pode retornar null deveria documentar isso)
- Evitar sugerir captura genérica de `NullPointerException` com try-catch, pois isso mascara o problema

**Resposta fraca ou incompleta:**  
"Eu colocaria um `if (cliente != null)` antes da linha." — Falta reconhecer que `getEndereco()` e `getCidade()` também podem ser null. O candidato trata apenas o primeiro nível da cadeia.

**Critérios de avaliação:**
- 0 — Não sabe o que é NPE ou como corrigir
- 1 — Menciona verificar null mas não identifica todos os pontos da cadeia
- 2 — Identifica os pontos mas apresenta apenas null check simples sem discutir alternativas
- 3 — Apresenta null check e Optional, identifica todos os pontos de falha
- 4 — Discute causa raiz, contratos, validação na entrada e apresenta boas práticas
- 5 — Compara abordagens, discute trade-offs de legibilidade vs. performance, menciona ferramentas como `@NonNull`/`@Nullable` (Lombok, JSR 305)

**Perguntas de aprofundamento:**
1. Em quais situações você usaria `Optional` como tipo de retorno de método? Há algum cenário em que isso seria inadequado?
2. Como você garantiria que esse tipo de problema não aconteça em outras partes do código?
3. Qual a diferença entre `Optional.of()` e `Optional.ofNullable()`? Quando cada um deve ser usado?

---

###  59.2. <a name='Pergunta62Diferenaentree.equalsaocompararstrings'></a>Pergunta 62 — Diferença entre == e .equals() ao comparar strings

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Imagine que um colega desenvolvedor escreveu o seguinte código para validar o tipo de pagamento de um pedido:

```java
String tipoPagamento = pedido.getTipoPagamento();
if (tipoPagamento == "PIX") {
    processarPix(pedido);
}
```

O código compila sem erros, mas em produção, mesmo quando o tipo de pagamento é "PIX", o bloco `if` não executa. Qual é o problema? Como você corrigiria?

**O que essa pergunta avalia:**  
Compreensão da diferença entre comparação de referências (`==`) e comparação de conteúdo (`.equals()`), conhecimento sobre o pool de strings da JVM, e capacidade de identificar bugs sutis que passam despercebidos em testes.

**Resposta esperada:**  
O operador `==` compara referências de memória, não o conteúdo das strings. Quando `pedido.getTipoPagamento()` retorna uma string criada em runtime (por exemplo, lida de um banco de dados ou construída dinamicamente), ela não está no pool de strings, então sua referência é diferente da string literal `"PIX"`, mesmo que o conteúdo seja idêntico. A correção é usar `.equals()`:

```java
if ("PIX".equals(tipoPagamento)) {
    processarPix(pedido);
}
```

Colocar a literal `"PIX"` à esquerda evita NPE caso `tipoPagamento` seja null.

**Explicação didática:**  
Java mantém um **pool de strings** na memória. String literais com o mesmo conteúdo compartilham a mesma referência. Por isso, `"PIX" == "PIX"` retorna `true` em testes simples. Mas strings criadas em runtime (via `new String("PIX")`, leitura de arquivo, retorno de banco de dados, etc.) criam objetos novos na heap, com referências diferentes. O método `.equals()` compara caractere por caractere, garantindo a comparação correta do conteúdo.

**Exemplo prático:**
```java
String a = "PIX";          // vai para o pool de strings
String b = "PIX";          // reutiliza a mesma referência do pool
String c = new String("PIX"); // cria novo objeto na heap

System.out.println(a == b);      // true (mesma referência do pool)
System.out.println(a == c);      // false (referências diferentes)
System.out.println(a.equals(c)); // true (conteúdo igual)
```

**Como o candidato deve responder:**  
- Explicar claramente a diferença entre `==` (referência) e `.equals()` (conteúdo)
- Mencionar o pool de strings e por que `==` pode funcionar em alguns casos e falhar em outros
- Apresentar a correção usando `"PIX".equals(tipoPagamento)` com a literal à esquerda
- Comentar que o código pode passar em testes unitários simples e falhar em produção (quando os dados vêm de fontes externas)
- Evitar sugerir `compareTo() == 0` para esse caso (é correto mas desnecessariamente complexo para comparação de igualdade)

**Resposta fraca ou incompleta:**  
"Tem que usar `.equals()` em vez de `==`." — Correto, mas não explica o porquê. O candidato deve demonstrar que entende a diferença entre comparação de referência e de conteúdo.

**Critérios de avaliação:**
- 0 — Não sabe a diferença ou acha que o código está correto
- 1 — Sabe que `==` não deve ser usado, mas não explica o porquê
- 2 — Explica a diferença básica mas não menciona o pool de strings
- 3 — Explica corretamente, menciona o pool e apresenta a correção
- 4 — Apresenta a boa prática da literal à esquerda, discute cenários de teste vs. produção
- 5 — Discute `intern()`, performance de `.equals()`, e boas práticas com enums como alternativa a strings para valores fixos

**Perguntas de aprofundamento:**
1. Por que às vezes `==` funciona para comparar strings? O que é o pool de strings?
2. Em vez de comparar strings, como o uso de `enum` poderia melhorar esse código?
3. O que acontece se `tipoPagamento` for `null` e você usar `tipoPagamento.equals("PIX")`? Como evitar isso?

---

###  59.3. <a name='Pergunta63Entendendotry-with-resourcesegerenciamentoderecursos'></a>Pergunta 63 — Entendendo try-with-resources e gerenciamento de recursos

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Você revisou um pull request que contém o seguinte código para leitura de um arquivo de configuração:

```java
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("config.properties"));
    String linha;
    while ((linha = reader.readLine()) != null) {
        processarConfiguracao(linha);
    }
} catch (IOException e) {
    logger.error("Erro ao ler arquivo", e);
} finally {
    reader.close(); // linha sinalizada pela revisão
}
```

Quais problemas você identificaria na revisão? Como reescreveria esse código?

**O que essa pergunta avalia:**  
Conhecimento sobre gerenciamento de recursos em Java, `try-with-resources` (Java 7+), tratamento de exceções no bloco `finally`, e boas práticas de revisão de código.

**Resposta esperada:**  
Há dois problemas principais: (1) Se o construtor `FileReader` lançar uma exceção, `reader` será `null` e `reader.close()` no `finally` lançará `NullPointerException`. (2) `reader.close()` pode lançar `IOException` que não está sendo tratado. A solução é usar `try-with-resources`, que garante o fechamento automático do recurso mesmo em caso de exceção:

```java
try (BufferedReader reader = new BufferedReader(
        new FileReader("config.properties"))) {
    String linha;
    while ((linha = reader.readLine()) != null) {
        processarConfiguracao(linha);
    }
} catch (IOException e) {
    logger.error("Erro ao ler arquivo de configuração", e);
}
```

**Explicação didática:**  
`try-with-resources` foi introduzido no Java 7. Qualquer objeto que implemente a interface `AutoCloseable` (ou `Closeable`) pode ser declarado dentro dos parênteses do `try`. A JVM garante que `.close()` seja chamado automaticamente, mesmo se houver uma exceção. Isso elimina a necessidade do bloco `finally` manual e previne vazamentos de recursos.

No código original, se `FileReader` falhar (arquivo não existe), `reader` permanece `null`. O bloco `finally` sempre executa, chamando `reader.close()` sobre `null` → NPE. Mesmo que o arquivo existisse, `close()` lança `IOException` que não está capturada no `finally`.

**Exemplo prático:**  
Em um sistema que processa múltiplos arquivos de log, esquecer de fechar um `BufferedReader` pode causar "Too many open files" (erro de SO), levando a indisponibilidade da aplicação. O `try-with-resources` previne esse tipo de problema.

**Como o candidato deve responder:**  
- Identificar os dois problemas: NPE se `reader` for null, e `IOException` não tratada no `finally`
- Apresentar o `try-with-resources` como solução preferida
- Explicar que `BufferedReader`, `FileReader` e a maioria dos recursos de I/O implementam `AutoCloseable`
- Mencionar que é possível declarar múltiplos recursos no try-with-resources
- Evitar sugerir apenas adicionar `if (reader != null)` no finally — isso resolve o NPE mas não é a melhor prática

**Resposta fraca ou incompleta:**  
"O `close()` deveria estar dentro de um try-catch." — Resolve parcialmente, mas não elimina o risco de `reader` ser null nem usa o recurso moderno da linguagem.

**Critérios de avaliação:**
- 0 — Não identifica nenhum problema
- 1 — Identifica que algo está errado no `finally` mas não especifica o quê
- 2 — Identifica o risco de NPE mas não conhece `try-with-resources`
- 3 — Identifica ambos os problemas e usa `try-with-resources`
- 4 — Explica `AutoCloseable`, menciona ordem de fechamento com múltiplos recursos, discute supressed exceptions
- 5 — Compara `Closeable` vs `AutoCloseable`, discute impacto de vazamento de recursos em produção, sugere boas práticas de logging no catch

**Perguntas de aprofundamento:**
1. O que acontece se houver uma exceção tanto no bloco `try` quanto no `close()`? Qual exceção prevalece?
2. É possível declarar mais de um recurso no `try-with-resources`? Como funciona a ordem de fechamento?
3. Qual a diferença entre `Closeable` e `AutoCloseable`?

---

###  59.4. <a name='Pergunta64UsocorretodeCollections:ArrayListvsLinkedList'></a>Pergunta 64 — Uso correto de Collections: ArrayList vs LinkedList

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em um sistema de fila de atendimento, um desenvolvedor escolheu `LinkedList` para armazenar os tickets de suporte porque ouviu dizer que "LinkedList é mais rápido para adicionar e remover elementos". O código faz muitas operações de `get(index)` para buscar tickets por posição. O time notou que a aplicação está lenta quando a fila cresce.

Você concorda com a escolha de `LinkedList`? Qual seria a melhor opção e por quê?

**O que essa pergunta avalia:**  
Conhecimento sobre as implementações de `List` em Java, complexidade de tempo das operações, e capacidade de escolher a estrutura de dados adequada para o cenário.

**Resposta esperada:**  
A escolha de `LinkedList` é inadequada para esse cenário. `LinkedList` tem inserção/remoção no início/fim em O(1), mas o acesso por índice (`get(index)`) é O(n), pois precisa percorrer a lista nó por nó. Se o código faz muitas operações `get(index)`, `ArrayList` é muito mais eficiente — acesso por índice é O(1) pois usa um array interno.

A recomendação é trocar por `ArrayList`:
```java
List<Ticket> fila = new ArrayList<>();
```

Se o requisito for realmente uma fila (FIFO), considerar `ArrayDeque` ou `LinkedList` com métodos `addLast()`/`removeFirst()`, mas se há acesso por índice frequente, `ArrayList` é a escolha correta.

**Explicação didática:**  
Pense em uma estante de livros (`ArrayList`) vs. uma corrente de pessoas segurando as mãos (`LinkedList`). Na estante, você vai direto à posição 5 e pega o livro — é instantâneo. Na corrente, para chegar à 5ª pessoa, você precisa passar pela 1ª, depois pela 2ª, e assim por diante — fica mais lento quanto maior a fila.

`ArrayList` internamente usa um array redimensionável. Acessar `get(5)` é ir direto ao índice 5 do array — O(1). `LinkedList` usa nós duplamente encadeados. Acessar `get(5)` exige percorrer do início (ou do fim, o que estiver mais perto) — O(n).

| Operação | ArrayList | LinkedList |
|---|---|---|
| `get(index)` | O(1) | O(n) |
| `add(e)` (fim) | O(1) amortizado | O(1) |
| `add(0, e)` (início) | O(n) | O(1) |
| `remove(index)` | O(n) | O(n) |
| Memória por elemento | Menor | Maior (referências prev/next) |

**Exemplo prático:**  
```java
// Cenário: buscar ticket na posição 1000 de uma lista de 5000 tickets
List<Ticket> fila = new ArrayList<>();     // get(1000) → acesso direto, ~0ms
List<Ticket> filaLenta = new LinkedList<>(); // get(1000) → percorre 1000 nós

// ArrayList é melhor quando há muito acesso por índice
// LinkedList é melhor quando há muitas inserções/remoções nas extremidades
```

**Como o candidato deve responder:**  
- Explicar a estrutura interna de cada implementação (array vs. nós encadeados)
- Relacionar a complexidade das operações com o problema observado
- Recomendar `ArrayList` para acesso por índice frequente
- Mencionar que se o padrão de uso for realmente FIFO (inserção no fim, remoção no início), `ArrayDeque` pode ser melhor que ambos
- Evitar dizer que "LinkedList é sempre mais lento" — depende da operação

**Resposta fraca ou incompleta:**  
"ArrayList é mais rápido que LinkedList." — Muito vago. Não explica quais operações nem o porquê da diferença de performance.

**Critérios de avaliação:**
- 0 — Não sabe a diferença entre as duas
- 1 — Sabe que são diferentes mas não explica as implicações práticas
- 2 — Menciona que ArrayList é melhor para acesso por índice mas não explica complexidade
- 3 — Explica complexidade O(1) vs O(n), recomenda a troca com justificativa
- 4 — Discute cenários onde cada uma é melhor, menciona `ArrayDeque` como alternativa
- 5 — Compara consumo de memória, impacto de cache da CPU, e discute quando o overhead do LinkedList justifica seu uso

**Perguntas de aprofundamento:**
1. Se você precisasse de uma estrutura onde insere e remove frequentemente do início da lista, qual usaria?
2. Por que `ArrayList.add(e)` é descrito como "O(1) amortizado"? O que acontece quando o array interno enche?
3. Qual a diferença de consumo de memória entre as duas implementações para a mesma quantidade de elementos?

---

###  59.5. <a name='Pergunta65Entendendooconceitodeencapsulamentocomexemploprtico'></a>Pergunta 65 — Entendendo o conceito de encapsulamento com exemplo prático

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em uma aplicação de sistema bancário, um desenvolvedor júnior criou a seguinte classe para representar uma conta:

```java
public class ContaBancaria {
    public double saldo;
    public String titular;
    public String numeroConta;

    public void depositar(double valor) {
        saldo += valor;
    }
}
```

O revisor de código pediu que os atributos fossem alterados para `private`. O desenvolvedor questionou: "Mas se eu colocar `private`, como outras classes vão acessar o saldo?".

Como você explicaria a importância do encapsulamento para esse desenvolvedor? Que mudanças você faria na classe?

**O que essa pergunta avalia:**  
Compreensão do conceito de encapsulamento, conhecimento sobre modificadores de acesso, e capacidade de aplicar boas práticas de orientação a objetos em um cenário real.

**Resposta esperada:**  
Encapsulamento é o princípio de proteger os dados internos de uma classe, expondo apenas o necessário através de métodos controlados. Com atributos `public`, qualquer classe pode modificar `saldo` diretamente — por exemplo, `conta.saldo = -1000` — burlando regras de negócio. Tornando os atributos `private` e expondo métodos `get`/`set` (ou apenas `get` quando o dado não deve ser alterado externamente), a classe mantém controle sobre seus próprios dados.

```java
public class ContaBancaria {
    private double saldo;
    private String titular;
    private String numeroConta;

    public ContaBancaria(String titular, String numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        this.saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
```

Note que não há `setSaldo()` — o saldo só pode ser alterado através de `depositar()` e `sacar()`, que aplicam as regras de negócio.

**Explicação didática:**  
Imagine uma conta bancária real. Você não abre a porta do cofre e pega o dinheiro diretamente — você vai ao caixa e faz um pedido estruturado (saque, depósito). O caixa valida: tem saldo? O valor é positivo? Da mesma forma, o encapsulamento força que toda alteração de estado passe por métodos que podem validar regras de negócio.

Os modificadores de acesso em Java:
- `public` — acessível de qualquer classe
- `private` — acessível apenas dentro da própria classe
- `protected` — acessível na mesma classe, mesmo pacote e subclasses
- (default/package-private) — acessível apenas no mesmo pacote

**Exemplo prático:**  
Com atributos públicos, outro desenvolvedor poderia escrever:
```java
conta.saldo = -5000;      // saldo negativo sem validação
conta.saldo -= 100000;    // saque sem verificar limite
conta.numeroConta = null; // corrompendo o dado
```

Com encapsulamento, essas operações são impossíveis — só é possível interagir com a conta através dos métodos que respeitam as regras.

**Como o candidato deve responder:**  
- Explicar encapsulamento como proteção dos dados internos da classe
- Mostrar que `public` permite modificação sem validação, criando riscos
- Demonstrar a refatoração com atributos `private` e métodos de acesso controlados
- Destacar que nem todos os atributos precisam de `set` — o saldo não deveria ter
- Mencionar construtores para inicialização segura
- Evitar simplesmente dizer "é uma boa prática" sem justificar com o cenário

**Resposta fraca ou incompleta:**  
"Encapsulamento é esconder os dados. Basta colocar `private` e gerar getters e setters com o IDE." — Mecanicamente correto, mas não entende o propósito. Gerar setter para `saldo` derrota o objetivo do encapsulamento.

**Critérios de avaliação:**
- 0 — Não sabe o que é encapsulamento
- 1 — Sabe que é "esconder atributos" mas não explica o porquê
- 2 — Explica a teoria mas gera setters para todos os atributos, incluindo saldo
- 3 — Refatora corretamente, não expõe setSaldo, aplica validações nos métodos
- 4 — Discute construtores, imutabilidade parcial, e quando expor ou não setters
- 5 — Menciona princípios SOLID (especialmente SRP), discute `BigDecimal` para valores monetários, e a relação entre encapsulamento e invariantes de classe

**Perguntas de aprofundamento:**
1. Por que usar `double` para saldo é uma má ideia? Qual tipo deveria ser usado?
2. Se o sistema precisasse permitir transferência entre contas, como você modelaria isso mantendo o encapsulamento?
3. O que acontece se dois threads chamarem `sacar()` simultaneamente? Como o encapsulamento ajuda a perceber esse risco?

---

###  59.6. <a name='Pergunta66Debugging:mtodoqueretornaresultadoincorreto'></a>Pergunta 66 — Debugging: método que retorna resultado incorreto

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Um desenvolvedor escreveu o método abaixo para calcular a média de notas de um aluno, mas o resultado está sempre saindo errado. Os testes mostram que para as notas `[7.0, 8.0, 6.0]` o método retorna `7.0`, mas para `[5.0, 6.0, 7.0]` ele retorna `6.0` em vez de `6.0` (que seria correto... mas em outro caso, para `[10.0, 10.0, 10.0, 10.0]` ele retorna `10.0` corretamente).

```java
public static double calcularMedia(List<Double> notas) {
    double soma = 0;
    for (int i = 0; i <= notas.size(); i++) {
        soma += notas.get(i);
    }
    return soma / notas.size();
}
```

Identifique o bug, explique o que está acontecendo e corrija o código.

**O que essa pergunta avalia:**  
Capacidade de leitura e análise de código, identificação de erros off-by-one, conhecimento de exceções em collections, e habilidade de debugging sem ferramentas.

**Resposta esperada:**  
O bug está na condição do `for`: `i <= notas.size()` deveria ser `i < notas.size()`. Com `<=`, o loop executa uma iteração a mais, tentando acessar `notas.get(notas.size())` — um índice que não existe (os índices vão de 0 a `size()-1`). Isso lança `IndexOutOfBoundsException` no último elemento.

Se a exceção não está sendo percebida, provavelmente está sendo capturada e ignorada em algum lugar do código, ou o cenário de teste não está atingindo a última iteração. A correção:

```java
public static double calcularMedia(List<Double> notas) {
    if (notas == null || notas.isEmpty()) {
        throw new IllegalArgumentException("Lista de notas não pode ser vazia ou nula");
    }
    double soma = 0;
    for (int i = 0; i < notas.size(); i++) {
        soma += notas.get(i);
    }
    return soma / notas.size();
}
```

Ou, usando o enhanced for (mais legível e seguro):
```java
public static double calcularMedia(List<Double> notas) {
    if (notas == null || notas.isEmpty()) {
        throw new IllegalArgumentException("Lista de notas não pode ser vazia ou nula");
    }
    double soma = 0;
    for (Double nota : notas) {
        soma += nota;
    }
    return soma / notas.size();
}
```

**Explicação didática:**  
Esse é um clássico erro **off-by-one** — um dos bugs mais comuns em programação. Listas em Java são indexadas a partir de zero. Uma lista com 3 elementos tem índices `0`, `1` e `2`. O método `size()` retorna `3`. Quando o loop usa `i <= size()`, ele tenta acessar o índice `3`, que não existe.

Analogia: Imagine uma prateleira com 3 gavetas numeradas 0, 1 e 2. Você precisa pegar o conteúdo de todas. Se você for da gaveta 0 até a gaveta 3, vai tentar abrir uma gaveta que não existe.

O enhanced for (`for (Double nota : notas)`) elimina a possibilidade desse erro, pois não há manipulação manual de índices.

**Exemplo prático:**
```java
List<Double> notas = Arrays.asList(7.0, 8.0, 6.0);
// size() = 3
// Loop com <= : i=0 ✓, i=1 ✓, i=2 ✓, i=3 → IndexOutOfBoundsException!
// Loop com <  : i=0 ✓, i=1 ✓, i=2 ✓ → termina corretamente
```

**Como o candidato deve responder:**  
- Identificar o erro off-by-one na condição do loop
- Explicar que índices vão de 0 a `size()-1`
- Apresentar a correção com `<` no lugar de `<=`
- Sugerir o enhanced for como alternativa mais segura
- Adicionar validação de entrada (lista null ou vazia)
- Evitar apenas apontar o erro sem explicar o raciocínio

**Resposta fraca ou incompleta:**  
"O loop está errado, troca o `<=` por `<`." — Correto mas superficial. Não explica o conceito de indexação baseada em zero nem sugere alternativas mais seguras.

**Critérios de avaliação:**
- 0 — Não identifica o erro
- 1 — Sabe que algo está errado no loop mas não especifica o quê
- 2 — Identifica o `<=` mas não explica o porquê do problema
- 3 — Identifica o erro, explica a indexação, e corrige
- 4 — Sugere enhanced for, adiciona validação de entrada, menciona `IndexOutOfBoundsException`
- 5 — Discute erros off-by-one como categoria de bug, sugere testes com boundary cases (lista vazia, 1 elemento), e menciona `Stream` como alternativa

**Perguntas de aprofundamento:**
1. Como você escreveria esse método usando a API de Streams do Java 8?
2. Quais casos de teste você criaria para garantir que o método está correto?
3. Se `notas` contiver um elemento `null`, o que acontece? Como tratar?

---

###  59.7. <a name='Pergunta67Compreensodeheranaesobrescritademtodos'></a>Pergunta 67 — Compreensão de herança e sobrescrita de métodos

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em um sistema de RH, existe uma classe `Funcionario` com um método `calcularSalario()`. A equipe criou uma classe `Gerente` que herda de `Funcionario` e sobrescreve `calcularSalario()` para incluir um bônus. No entanto, um desenvolvedor relatou o seguinte comportamento:

```java
Funcionario f = new Gerente();
System.out.println(f.calcularSalario()); // esperava o salário com bônus
```

Às vezes imprime o salário com bônus e às vezes sem, dependendo de como a classe `Gerente` foi escrita. O que pode estar acontecendo? Como garantir que o polimorfismo funcione corretamente?

**O que essa pergunta avalia:**  
Compreensão de herança, sobrescrita de métodos (`@Override`), polimorfismo, e a diferença entre sobrescrita (override) e sobrecarga (overload).

**Resposta esperada:**  
O comportamento inconsistente provavelmente ocorre porque o método em `Gerente` não está sobrescrevendo o método de `Funcionario`, e sim sobrecarregando (criando um método com assinatura diferente). Em Java, a sobrescrita (override) acontece quando o método tem a mesma assinatura (nome, parâmetros e tipo de retorno compatível). Se `Gerente` definir `calcularSalario(double bonus)` em vez de `calcularSalario()`, isso é uma sobrecarga, não uma sobrescrita.

```java
// Classe base
public class Funcionario {
    private double salarioBase;

    public double calcularSalario() {
        return salarioBase;
    }
}

// Sobrescrita correta
public class Gerente extends Funcionario {
    private double bonus;

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonus;
    }
}

// INCORRETO — isso é sobrecarga, não sobrescrita
public class Gerente extends Funcionario {
    private double bonus;

    public double calcularSalario(double bonus) { // assinatura diferente!
        return super.calcularSalario() + bonus;
    }
}
```

No caso incorreto, `f.calcularSalario()` chama o método de `Funcionario` (sem bônus), porque a versão sem parâmetros não foi sobrescrita. O uso da anotação `@Override` obriga o compilador a verificar que a sobrescrita é válida — se não for, dá erro de compilação.

**Explicação didática:**  
Imagine que você pede "o preço" para um vendedor e para um gerente. O vendedor dá o preço de tabela. O gerente pode dar o preço com desconto porque tem autoridade para isso. Você não precisa saber se está falando com vendedor ou gerente — basta dizer "me dê o preço" e cada um responde à sua maneira. Isso é polimorfismo.

Para que isso funcione, ambos precisam responder à mesma pergunta (mesma assinatura). Se o gerente só souber responder "me dê o preço com desconto de X%", a pergunta genérica "me dê o preço" será respondida pelo vendedor.

**Sobrescrita (override)** vs **Sobrecarga (overload):**
- **Sobrescrita:** mesma assinatura, classes diferentes (herança). Resolvida em runtime.
- **Sobrecarga:** assinaturas diferentes, mesma classe. Resolvida em compile time.

**Exemplo prático:**
```java
Funcionario f1 = new Funcionario();
Funcionario f2 = new Gerente(); // upcasting implícito

f1.calcularSalario(); // chama Funcionario.calcularSalario()
f2.calcularSalario(); // chama Gerente.calcularSalario() — polimorfismo!
// A JVM decide em runtime qual método executar, baseado no tipo real do objeto
```

**Como o candidato deve responder:**  
- Diferenciar sobrescrita de sobrecarga claramente
- Explicar que o polimorfismo depende da sobrescrita com a mesma assinatura
- Defender o uso da anotação `@Override` como boa prática
- Explicar que a JVM resolve em runtime qual método executar (dispatch virtual)
- Mencionar que o tipo da referência (`Funcionario f`) não determina qual método é chamado — o tipo do objeto (`new Gerente()`) é que determina
- Evitar confundir override com overload ou dizer que "depende da versão do Java"

**Resposta fraca ou incompleta:**  
"Tem que colocar `@Override`." — Não explica o que `@Override` faz nem qual era o problema real. É uma resposta decorada sem compreensão do mecanismo.

**Critérios de avaliação:**
- 0 — Não sabe a diferença entre override e overload
- 1 — Sabe que existem os dois conceitos mas não os distingue corretamente
- 2 — Explica a diferença mas não conecta com o problema do cenário
- 3 — Identifica o problema, explica a solução e o uso de `@Override`
- 4 — Explica dispatch virtual em runtime, discute regras de sobrescrita (visibilidade, exceções)
- 5 — Discute covariância de retorno, exceções verificadas em sobrescrita, e o princípio de Liskov (LSP)

**Perguntas de aprofundamento:**
1. O que acontece se o método da classe pai for `private`? Pode ser sobrescrito?
2. É possível sobrescrever um método `static`? O que acontece nesse caso?
3. Ao sobrescrever um método, você pode lançar uma exceção verificada que o método pai não lança? Por quê?

---

###  59.8. <a name='Pergunta68CompreensodeStringBuildervsconcatenaodestrings'></a>Pergunta 68 — Compreensão de StringBuilder vs concatenação de strings

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Em um sistema de geração de relatórios, o seguinte código constrói uma string com os itens de um pedido:

```java
String relatorio = "RELATÓRIO DE PEDIDO\n";
relatorio += "Cliente: " + pedido.getCliente() + "\n";
relatorio += "Data: " + pedido.getData() + "\n";
for (Item item : pedido.getItens()) {
    relatorio += "- " + item.getNome() + ": R$ " + item.getPreco() + "\n";
}
relatorio += "Total: R$ " + pedido.getTotal();
```

O relatório funciona corretamente para pedidos pequenos, mas quando há muitos itens (centenas), a aplicação fica lenta. Identifique o problema e proponha uma solução.

**O que essa pergunta avalia:**  
Compreensão da imutabilidade de `String` em Java, impacto na performance da concatenação com `+=`, e conhecimento de `StringBuilder` como alternativa eficiente.

**Resposta esperada:**  
Strings em Java são **imutáveis** — cada operação `+=` não modifica a string original, mas cria um novo objeto `String` em memória, copiando todo o conteúdo anterior e adicionando o novo trecho. Em um loop com centenas de itens, isso significa criar centenas de strings temporárias, cada vez maiores, resultando em complexidade O(n²) — muito ineficiente.

A solução é usar `StringBuilder`, que mantém um buffer interno mutável:

```java
StringBuilder sb = new StringBuilder();
sb.append("RELATÓRIO DE PEDIDO\n");
sb.append("Cliente: ").append(pedido.getCliente()).append("\n");
sb.append("Data: ").append(pedido.getData()).append("\n");
for (Item item : pedido.getItens()) {
    sb.append("- ").append(item.getNome())
      .append(": R$ ").append(item.getPreco()).append("\n");
}
sb.append("Total: R$ ").append(pedido.getTotal());

String relatorio = sb.toString();
```

Isso reduz a complexidade para O(n) — cada `append` adiciona ao buffer existente sem criar objetos novos.

**Explicação didática:**  
Imagine que você está escrevendo uma carta à mão. Toda vez que quer adicionar uma palavra, em vez de continuar escrevendo, você copia toda a carta escrita até agora em uma nova folha e adiciona a palavra no final. Isso é o que `+=` faz com strings imutáveis.

`StringBuilder` é como ter uma folha grande com espaço em branco: você simplesmente continua escrevendo no final, sem precisar recopiar tudo.

**Por que String é imutável?**
- **Segurança:** strings são usadas em classloading, conexões de banco, URLs — se fossem mutáveis, poderiam ser alteradas após validação
- **Thread-safety:** objetos imutáveis são naturalmente seguros para uso entre threads
- **Pool de strings:** permite reutilização de strings literais
- **Cache de hashCode:** calculado uma vez, já que o conteúdo nunca muda

**Exemplo prático:**
```java
// Com += : cria 4 objetos String temporários
String s = "a";    // objeto 1
s += "b";          // objeto 2 ("ab"), objeto 1 descartado
s += "c";          // objeto 3 ("abc"), objeto 2 descartado
s += "d";          // objeto 4 ("abcd"), objeto 3 descartado

// Com StringBuilder: 1 objeto, buffer interno expandido
StringBuilder sb = new StringBuilder();
sb.append("a").append("b").append("c").append("d");
String resultado = sb.toString();
```

**Como o candidato deve responder:**  
- Explicar que strings são imutáveis e que `+=` cria novos objetos a cada operação
- Identificar que dentro de um loop, o impacto é O(n²)
- Apresentar `StringBuilder` como solução com complexidade O(n)
- Mencionar que `StringBuilder` não é thread-safe (adequado para uso local) enquanto `StringBuffer` é thread-safe (mais lento)
- Comentar que o compilador Java otimiza concatenações simples (fora de loops) com `StringBuilder` internamente, mas dentro de loops a otimização não é eficaz
- Evitar dizer que "String é lenta" — String é eficiente para leitura; o problema é a concatenação repetida

**Resposta fraca ou incompleta:**  
"Use StringBuilder porque é mais rápido." — Não explica o porquê. Falta mencionar imutabilidade e a criação de objetos temporários.

**Critérios de avaliação:**
- 0 — Não sabe por que o código é lento
- 1 — Menciona que String é imutável mas não conecta com a performance
- 2 — Explica o problema mas não apresenta `StringBuilder` ou apresenta incorretamente
- 3 — Explica imutabilidade, identifica O(n²), apresenta `StringBuilder` corretamente
- 4 — Diferencia `StringBuilder` vs `StringBuffer`, menciona otimização do compilador
- 5 — Discute capacidade inicial do buffer, impacto no GC, e quando usar `String.join()` ou `String.format()` como alternativas

**Perguntas de aprofundamento:**
1. Qual a diferença entre `StringBuilder` e `StringBuffer`? Quando usar cada um?
2. Se você precisar concatenar strings em múltiplas threads simultaneamente, o que usaria?
3. O compilador Java às vezes converte `+=` em `StringBuilder` automaticamente. Por que isso não resolve o problema dentro de um loop?

---

###  59.9. <a name='Pergunta69Usodeinterfacesvsclassesabstratas'></a>Pergunta 69 — Uso de interfaces vs classes abstratas

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em um sistema de pagamentos, você precisa modelar diferentes formas de pagamento: cartão de crédito, PIX, boleto e transferência bancária. Todas precisam ter um método `processarPagamento()` e algumas compartilham lógica de validação.

Um colega sugere criar uma classe abstrata `Pagamento` com o método `validar()` implementado e `processarPagamento()` abstrato. Outro colega sugere criar uma interface `Pagamento` com ambos os métodos.

Como você decidiria entre as duas abordagens? Quais são os trade-offs?

**O que essa pergunta avalia:**  
Compreensão da diferença entre interfaces e classes abstratas, conhecimento dos modificadores de acesso e herança em Java, e capacidade de tomar decisões de design orientado a objetos.

**Resposta esperada:**  
A escolha depende do contexto:

**Classe abstrata** é mais adequada quando:
- Há código compartilhado entre as implementações (ex.: `validar()` com lógica comum)
- As subclasses têm relacionamento "é-um" (Cartão de Crédito **é um** Pagamento)
- Queremos definir estado (atributos) e construtores

```java
public abstract class Pagamento {
    protected BigDecimal valor;
    protected String codigoPedido;

    public Pagamento(BigDecimal valor, String codigoPedido) {
        this.valor = valor;
        this.codigoPedido = codigoPedido;
    }

    // Método concreto — compartilhado entre todas as subclasses
    public void validar() {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        if (codigoPedido == null || codigoPedido.isBlank()) {
            throw new IllegalArgumentException("Pedido inválido");
        }
    }

    // Método abstrato — cada subclasse implementa
    public abstract void processarPagamento();
}

public class PagamentoCartao extends Pagamento {
    private String numeroCartao;

    public PagamentoCartao(BigDecimal valor, String codigoPedido, String numeroCartao) {
        super(valor, codigoPedido);
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void processarPagamento() {
        validar(); // reutiliza validação da classe pai
        // lógica específica de cartão
    }
}
```

**Interface** é mais adequada quando:
- Queremos definir um contrato sem impor hierarquia de herança
- A classe já herda de outra (Java não permite herança múltipla de classes)
- Há múltiplas implementações sem código compartilhado

```java
public interface Pagamento {
    void processarPagamento();
    default void validar() {
        // lógica padrão opcional (Java 8+)
    }
}
```

Para o cenário descrito (código compartilhado + relacionamento "é-um"), **classe abstrata é a melhor escolha**. A interface seria adequada se os pagamentos já herdassem de outras classes, ou se quisessemos definir apenas um contrato.

**Explicação didática:**  
Pense em uma interface como um **contrato de trabalho**: define o que você deve fazer, mas não como. Uma classe abstrata é como um **modelo de documento**: já vem com parte do conteúdo preenchido e você completa o restante.

**Principais diferenças:**

| Característica | Classe Abstrata | Interface |
|---|---|---|
| Herança múltipla | Não (uma classe só herda de uma) | Sim (uma classe pode implementar várias) |
| Atributos de instância | Sim | Não (apenas constantes `public static final`) |
| Construtores | Sim | Não |
| Métodos concretos | Sim | Sim (desde Java 8 com `default`) |
| Métodos privados | Sim | Sim (desde Java 9) |
| Estado | Sim | Não |

**Como o candidato deve responder:**
- Apresentar ambas as abordagens com código
- Explicar os trade-offs de cada uma
- Justificar a escolha com base no cenário (código compartilhado → classe abstrata)
- Mencionar que interfaces suportam `default` e `static` methods desde Java 8
- Evitar dizer que "interfaces são para herança múltipla" como única justificativa
- Mencionar que é possível combinar as duas: interface para o contrato, classe abstrata para o código compartilhado

**Resposta fraca ou incompleta:**  
"Use interface porque é mais flexível." — Não explica o que torna a interface mais flexível nem quando a classe abstrata seria melhor. Resposta genérica sem análise do cenário.

**Critérios de avaliação:**
- 0 — Não sabe a diferença entre as duas
- 1 — Sabe que existem mas não explica quando usar cada uma
- 2 — Explica diferenças básicas mas não conecta com o cenário
- 3 — Apresenta ambas as soluções, justifica a escolha com base no cenário
- 4 — Discute `default methods`, herança múltipla de interfaces, e combinação de ambas
- 5 — Menciona princípios SOLID (ISP para interfaces, e composição vs. herança), discute evolução de interfaces no Java 8/9/17

**Perguntas de aprofundamento:**
1. O que acontece se uma interface tem dois `default methods` com a mesma assinatura em duas interfaces que uma classe implementa?
2. É possível ter métodos privados em interfaces? Desde qual versão do Java?
3. Se você precisasse que `Pagamento` herde de outra classe (ex.: `Transacao`), como isso afetaria sua decisão?

---

###  59.10. <a name='Pergunta70Tratamentodeexceesverificadasvsnoverificadas'></a>Pergunta 70 — Tratamento de exceções verificadas vs não verificadas

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Você está desenvolvendo um serviço que importa dados de um arquivo CSV. O método precisa ler o arquivo, fazer o parse das linhas e salvar no banco de dados. O desenvolvedor anterior escreveu:

```java
public void importarDados(String caminhoArquivo) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] campos = linha.split(",");
            salvarRegistro(campos);
        }
        reader.close();
    } catch (Exception e) {
        // TODO: tratar depois
    }
}
```

Quais problemas você identifica? Como você reescreveria esse método tratando as exceções de forma adequada, diferenciando exceções verificadas e não verificadas?

**O que essa pergunta avalia:**  
Conhecimento sobre exceções verificadas (checked) e não verificadas (unchecked), boas práticas de tratamento de exceções, e capacidade de diferenciar erros de negócio de erros de infraestrutura.

**Resposta esperada:**  
Há vários problemas: (1) Captura genérica de `Exception` mascara todos os erros, incluindo bugs de programação. (2) O bloco catch está vazio (swallowing exception). (3) `reader.close()` não está no `finally` ou `try-with-resources`. (4) Não há diferenciação entre erro de I/O (arquivo não encontrado), erro de parse (formato inválido) e erro de banco de dados.

Refatoração:

```java
public void importarDados(String caminhoArquivo) throws ImportacaoException {
    try (BufferedReader reader = new BufferedReader(
            new FileReader(caminhoArquivo))) {
        String linha;
        int numeroLinha = 0;
        while ((linha = reader.readLine()) != null) {
            numeroLinha++;
            try {
                String[] campos = linha.split(",");
                validarCampos(campos);
                salvarRegistro(campos);
            } catch (NumberFormatException e) {
                throw new ImportacaoException(
                    "Formato inválido na linha " + numeroLinha, e);
            }
        }
    } catch (FileNotFoundException e) {
        throw new ImportacaoException("Arquivo não encontrado: " + caminhoArquivo, e);
    } catch (IOException e) {
        throw new ImportacaoException("Erro ao ler arquivo: " + caminhoArquivo, e);
    }
}

// Exceção não verificada — erro de programação (dados inválidos)
public class ImportacaoException extends RuntimeException {
    public ImportacaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
```

**Diferença entre verificadas e não verificadas:**

- **Exceções verificadas (checked):** Herdam de `Exception` (mas não de `RuntimeException`). O compilador obriga a tratar (`try-catch`) ou declarar (`throws`). Exemplos: `IOException`, `SQLException`, `ClassNotFoundException`.

- **Exceções não verificadas (unchecked):** Herdam de `RuntimeException` ou `Error`. O compilador não obriga a tratar. Exemplos: `NullPointerException`, `IllegalArgumentException`, `ArrayIndexOutOfBoundsException`.

**Quando usar cada uma:**
- **Checked:** quando o erro é recuperável e o chamador pode tomar uma ação (ex.: arquivo não encontrado → o chamador pode pedir um novo caminho)
- **Unchecked:** quando o erro indica bug de programação ou condição irrecuperável (ex.: `IllegalArgumentException` → o chamador não deveria passar dados inválidos)

**Explicação didática:**  
Exceções verificadas são como uma **sinalização obrigatória**: o compilador força você a reconhecer que algo pode dar errado. É como um contrato que diz "este método pode falhar, você precisa estar preparado". Exceções não verificadas são como um **alarme de incêndio**: ninguém planeja, mas quando dispara, algo está seriamente errado.

Capturar `Exception` genérica é como desligar o alarme de incêndio sem verificar o que pegou fogo — você pode estar ignorando um problema grave.

**Exemplo prático:**
```java
// Checked — o compilador força a tratar
FileReader reader = new FileReader("dados.txt");
// → FileNotFoundException deve ser tratada ou declarada

// Unchecked — o compilador não avisa
int[] array = new int[5];
int valor = array[10]; // ArrayIndexOutOfBoundsException em runtime
// → o programador não deveria acessar índice inválido
```

**Como o candidato deve responder:**
- Identificar pelo menos 3 problemas no código original
- Explicar a diferença entre checked e unchecked com exemplos
- Apresentar a refatoração com try-with-resources
- Criar uma exceção de domínio (ex.: `ImportacaoException`) para encapsular erros de negócio
- Defender que exceções não devem ser "engolidas" (catch vazio)
- Mencionar a importância de preservar a causa original (`throw new X(mensagem, e)`)
- Evitar sugerir `throws Exception` na assinatura do método — isso é anti-pattern

**Resposta fraca ou incompleta:**  
"O catch está vazio, tem que colocar um `e.printStackTrace()`." — Resolve parcialmente o problema do catch vazio, mas não diferencia os tipos de exceção nem usa try-with-resources. `printStackTrace()` não é tratamento adequado — é debug.

**Critérios de avaliação:**
- 0 — Não identifica problemas nem sabe a diferença entre checked e unchecked
- 1 — Identifica o catch vazio mas não conhece os tipos de exceção
- 2 — Sabe a diferença entre checked e unchecked mas não refatora corretamente
- 3 — Identifica os problemas, refatora com try-with-resources e diferencia os tipos
- 4 — Cria exceção de domínio, preserva causa original, discute quando usar checked vs. unchecked
- 5 — Discute o debate sobre checked exceptions (controvérsia na comunidade Java), mencora `ExceptionUtils` de bibliotecas como Apache Commons, e defende uma estratégia consistente de tratamento

**Perguntas de aprofundamento:**
1. Por que alguns frameworks (como Spring) preferem converter exceções checked em unchecked? Qual a vantagem?
2. O que acontece se você capturar uma exceção e não passar a causa original (`e`) para a nova exceção?
3. Em que situação você criaria uma exceção checked em vez de unchecked? Dê um exemplo.

---

###  59.11. <a name='ResumodaParte7'></a>Resumo da Parte 7

| Pergunta | Título | Categoria |
|---|---|---|
| 61 | Tratamento de NullPointerException em código legado | Troubleshooting |
| 62 | Diferença entre == e .equals() ao comparar strings | Fundamentos |
| 63 | Entendendo try-with-resources e gerenciamento de recursos | Prática |
| 64 | Uso correto de Collections: ArrayList vs LinkedList | Fundamentos |
| 65 | Entendendo o conceito de encapsulamento com exemplo prático | Fundamentos |
| 66 | Debugging: método que retorna resultado incorreto | Troubleshooting |
| 67 | Compreensão de herança e sobrescrita de métodos | Fundamentos |
| 68 | Compreensão de StringBuilder vs concatenação de strings | Prática |
| 69 | Uso de interfaces vs classes abstratas | Fundamentos |
| 70 | Tratamento de exceções verificadas vs não verificadas | Prática |

**Perguntas apresentadas até aqui:** 1 a 70  
**Perguntas restantes:** 71 a 100 (Parte 8 — 10 perguntas) e Parte 9 — 20 perguntas finais + seções de fechamento (resumo, matriz de competências, recomendações)

---

##  60. <a name='RoteirodeEntrevistaTcnicaJavaJnior'></a>Roteiro de Entrevista Técnica — Java (Júnior)

###  60.1. <a name='ContinuaoPerguntas71a100'></a>Continuação — Perguntas 71 a 100

---

###  60.2. <a name='Pergunta71TratamentodeNullPointerExceptionemcdigolegado'></a>Pergunta 71 — Tratamento de NullPointerException em código legado

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Você começou a trabalhar em um projeto Java legado e, ao executar uma rotina de processamento de pedidos, recebeu um `NullPointerException`. O stack trace aponta para uma linha onde um objeto `Cliente` é acessado para chamar o método `getEmail()`, mas esse objeto veio de um método `buscarCliente(Long id)` que pode retornar `null` quando o cliente não existe. Como você resolveria esse problema no código?

**O que essa pergunta avalia:**  
Capacidade de diagnosticar e tratar o `NullPointerException`, compreensão de referências nulas em Java, uso de `Optional` ou verificações defensivas, e pensamento crítico sobre código legado.

**Resposta esperada:**  
O candidato deve identificar que o método `buscarCliente` pode retornar `null` e que o código não faz verificação antes de acessar `.getEmail()`. A solução mais simples em Java 8+ é envolver o retorno com `Optional`, ou então fazer uma verificação explícita com `if (cliente != null)` antes de acessar o método. O candidato também deve mencionar que é importante decidir o comportamento adequado quando o cliente não existe: lançar uma exceção de negócio, retornar um valor padrão, ou logar um aviso.

**Explicação didática:**  
O `NullPointerException` (NPE) é uma das exceções mais comuns em Java. Ele ocorre quando tentamos acessar um membro (método ou atributo) de uma referência que aponta para `null` — ou seja, um objeto que "não existe" na memória. Pense como tentar abrir a porta de uma casa que não foi construída: não há porta para abrir.

No cenário descrito, o método `buscarCliente(Long id)` consulta um cliente por ID. Se o ID não existir no banco, ele retorna `null`. Quando o código tenta chamar `cliente.getEmail()` sem verificar se `cliente` é `null`, o NPE é lançado.

A partir do Java 8, a classe `Optional<T>` foi introduzida justamente para expressar explicitamente que um valor pode ou não estar presente, evitando verificações manuais repetitivas e tornando a intenção do código mais clara.

**Exemplo prático:**  

```java
// Código com problema (legado)
Cliente cliente = clienteRepository.buscarCliente(idPedido);
String email = cliente.getEmail(); // NPE se cliente for null
```

```java
// Solução 1: Verificação explícita (compatível com qualquer versão)
Cliente cliente = clienteRepository.buscarCliente(idPedido);
if (cliente == null) {
    throw new ClienteNaoEncontradoException("Cliente não encontrado para o ID: " + idPedido);
}
String email = cliente.getEmail();
```

```java
// Solução 2: Usando Optional (Java 8+)
Optional<Cliente> clienteOpt = clienteRepository.buscarClienteOptional(idPedido);
String email = clienteOpt
    .map(Cliente::getEmail)
    .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));
```

**Como o candidato deve responder:**  
- Identificar imediatamente que o problema é a falta de verificação de nulo antes de acessar o objeto
- Explicar o conceito de `Optional` como abordagem moderna e mais expressiva
- Discutir o que fazer quando o cliente não existe (lançar exceção, valor padrão, etc.)
- Mencionar que em código legado pode ser necessário uma solução intermediária (verificação com `if`) antes de refatorar para `Optional`
- Evitar sugerir soluções que mascarem o problema, como capturar `NullPointerException` com try-catch

**Resposta fraca ou incompleta:**  
"Eu colocaria um try-catch em volta da linha e imprimiria o erro no console." — Falta porque capturar NPE com try-catch não resolve o problema, apenas o oculta. O candidato não demonstra compreensão da causa raiz nem propõe correção preventiva.

**Critérios de avaliação:**  
- 0 — Não sabe o que é NPE ou apresenta soluções incorretas
- 1 — Sabe que é um erro de null, mas não propõe solução adequada
- 2 — Propõe verificação com if, mas não menciona Optional nem discute comportamento alternativo
- 3 — Propõe verificação correta e menciona Optional
- 4 — Demonstra domínio prático, explica trade-offs entre if e Optional, menciona exceções de negócio
- 5 — Responde com profundidade, discute refatoração de código legado, boas práticas e prevenção de NPEs em outros pontos do código

**Perguntas de aprofundamento:**  
1. Se o método `buscarCliente` fosse usado em 20 lugares diferentes, como você abordaria a refatoração para usar `Optional`?
2. Em quais situações usar `Optional` como atributo de classe seria inadequado?
3. Como você diferenciaria um cliente que não existe (null) de um cliente que existe mas não tem e-mail cadastrado?

---

###  60.3. <a name='Pergunta72CompreensodeequalsehashCode'></a>Pergunta 72 — Compreensão de equals() e hashCode()

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em um sistema de cadastro de alunos, você tem uma classe `Aluno` com os atributos `matricula`, `nome` e `idade`. Você notou que ao colocar objetos `Aluno` em um `HashSet`, alunos com a mesma matrícula estão aparecendo duplicados. O que provavelmente está errado e como você corrigiria?

**O que essa pergunta avalia:**  
Compreensão do contrato entre `equals()` e `hashCode()`, conhecimento sobre o funcionamento de coleções baseadas em hash, e capacidade de diagnosticar problemas comuns em collections.

**Resposta esperada:**  
O problema é que a classe `Aluno` provavelmente não sobrescreve os métodos `equals()` e `hashCode()`, ou os sobrescreveu de forma inconsistente. O `HashSet` usa o `hashCode()` para determinar o "bucket" onde o elemento será armazenado e o `equals()` para verificar se dois elementos são iguais. Se esses métodos não estiverem implementados, será usada a implementação padrão de `Object`, que compara referências de memória (identidade) em vez de valores. Para corrigir, deve-se sobrescrever ambos os métodos, usando o atributo `matricula` como critério de igualdade, garantindo que dois objetos `Aluno` com a mesma matrícula sejam considerados iguais.

**Explicação didática:**  
Imagine que o `HashSet` é um arquivo de pastas com várias gavetas. O `hashCode()` diz **em qual gaveta** procurar. O `equals()` confirma **se o documento dentro da gaveta é o mesmo** que você está buscando.

Se você não sobrescreve `hashCode()`, o Java usa o endereço de memória do objeto como hash. Dois objetos `Aluno` com a mesma matrícula terão endereços de memória diferentes, então serão colocados em gavetas diferentes e nunca serão comparados pelo `equals()` — resultando em duplicatas.

A regra de ouro é: **se dois objetos são `equals()`, eles devem ter o mesmo `hashCode()`**. O contrário não é obrigatório, mas afeta a performance.

**Exemplo prático:**  

```java
import java.util.Objects;

public class Aluno {
    private Long matricula;
    private String nome;
    private int idade;

    // Construtor, getters e setters omitidos

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Mesma referência
        if (o == null || getClass() != o.getClass()) return false; // Tipos diferentes
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula); // Compara por matrícula
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula); // Hash baseado apenas na matrícula
    }
}
```

**Como o candidato deve responder:**  
- Explicar que `HashSet` usa `hashCode()` e `equals()` para determinar duplicatas
- Identificar que a ausência desses métodos sobrescritos causa o problema
- Mostrar como implementar ambos de forma consistente
- Mencionar que o mesmo critério usado em `equals()` deve ser usado em `hashCode()`
- Citar ferramentas como `Objects.equals()` e `Objects.hash()` para evitar erros manuais
- Evitar implementar `hashCode()` com atributos diferentes dos usados em `equals()`

**Resposta fraca ou incompleta:**  
"É só sobrescrever o `equals()` comparando a matrícula." — Incompleto porque sobrescrever apenas `equals()` sem `hashCode()` viola o contrato e o `HashSet` continuaria com duplicatas. O candidato precisa mencionar ambos os métodos.

**Critérios de avaliação:**  
- 0 — Não sabe o que é equals/hashCode ou não identifica o problema
- 1 — Menciona equals mas não hashCode
- 2 — Menciona ambos mas não explica a relação entre eles
- 3 — Explica o contrato e como implementar corretamente
- 4 — Demonstra domínio prático, usa Objects.equals/hash, explica o impacto na coleção
- 5 — Responde com profundidade, discute quando usar atributos imutáveis no hashCode, menciona alternativas (records no Java 16+)

**Perguntas de aprofundamento:**  
1. O que aconteceria se você usasse a `idade` no `hashCode()` mas não no `equals()`?
2. Por que é recomendado usar atributos imutáveis (como `matricula` do tipo `Long`) no cálculo do `hashCode()`?
3. Se você colocasse objetos `Aluno` em uma `List` em vez de `Set`, o `equals()` ainda seria relevante?

---

###  60.4. <a name='Pergunta73DiferenaentreeequalscomStrings'></a>Pergunta 73 — Diferença entre == e equals() com Strings

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em uma validação de login, um desenvolvedor escreveu o seguinte código:

```java
String senhaDigitada = request.getParameter("senha");
String senhaCadastrada = usuario.getSenha();
if (senhaDigitada == senhaCadastrada) {
    // libera acesso
}
```

Ele relatou que às vezes o login funciona e às vezes não, mesmo quando a senha está correta. O que está acontecendo e como você corrigiria?

**O que essa pergunta avalia:**  
Compreensão da diferença entre comparação de referência (`==`) e comparação de conteúdo (`equals()`), conhecimento sobre o pool de Strings do Java, e capacidade de diagnosticar bugs sutis.

**Resposta esperada:**  
O operador `==` compara referências de memória, não o conteúdo das Strings. Como as Strings `senhaDigitada` e `senhaCadastrada` vêm de fontes diferentes (uma do request HTTP, outra do banco de dados via objeto), elas são objetos String diferentes na memória, mesmo que tenham o mesmo conteúdo. O `==` retorna `false`. Às vezes funciona porque o Java mantém um "pool de Strings literais" — se ambas as Strings forem literais definidas no código, o Java pode reutilizar a mesma instância (interning), fazendo `==` funcionar por coincidência. A correção é usar `senhaDigitada.equals(senhaCadastrada)` para comparar o conteúdo. Também é importante tratar o caso de `senhaDigitada` ser `null` para evitar NPE, usando `Objects.equals(senhaDigitada, senhaCadastrada)`.

**Explicação didática:**  
Pense em duas cópias do mesmo livro. Elas têm exatamente o mesmo conteúdo (texto igual), mas são objetos físicos diferentes. O operador `==` pergunta: "são o mesmo livro físico?". O método `equals()` pergunta: "têm o mesmo conteúdo?".

O Java tem uma otimização chamada **String Pool**: literais de String definidos no código são armazenados em um pool compartilhado. Se você escreve `String a = "admin"` e `String b = "admin"`, o Java reutiliza a mesma instância, então `a == b` retorna `true`. Mas Strings criadas com `new String("admin")` ou vindas de entrada externa (banco de dados, request HTTP) não estão no pool, então `==` retorna `false`.

**Exemplo prático:**  

```java
// Comportamento do String Pool
String a = "admin";
String b = "admin";
System.out.println(a == b);      // true (mesma instância do pool)
System.out.println(a.equals(b)); // true (mesmo conteúdo)

// Strings de fontes externas
String c = new String("admin");
System.out.println(a == c);      // false (instâncias diferentes)
System.out.println(a.equals(c)); // true (mesmo conteúdo)
```

```java
// Correção do código de login
String senhaDigitada = request.getParameter("senha");
String senhaCadastrada = usuario.getSenha();

// Usando Objects.equals para tratar null com segurança
if (Objects.equals(senhaDigitada, senhaCadastrada)) {
    // libera acesso
} else {
    // nega acesso
}
```

**Como o candidato deve responder:**  
- Explicar claramente a diferença entre `==` (referência) e `.equals()` (conteúdo)
- Mencionar o String Pool como motivo do comportamento intermitente
- Propor a correção usando `.equals()` ou `Objects.equals()`
- Considerar o tratamento de `null` para evitar NPE
- Evitar sugerir `intern()` como solução, pois não resolve o problema de forma segura

**Resposta fraca ou incompleta:**  
"É só trocar `==` por `.equals()`." — Correto, mas muito superficial. Não explica o porquê do comportamento intermitente (String Pool) nem menciona tratamento de null.

**Critérios de avaliação:**  
- 0 — Não sabe a diferença entre == e equals()
- 1 — Sabe que equals compara conteúdo, mas não explica o comportamento intermitente
- 2 — Explica a diferença corretamente, mas não menciona String Pool nem tratamento de null
- 3 — Explica String Pool, propõe equals() e menciona null
- 4 — Demonstra domínio prático, usa Objects.equals(), explica interning
- 5 — Responde com profundidade, discute segurança de senhas (não usar String para senhas, preferir char[]), boas práticas

**Perguntas de aprofundamento:**  
1. Por que é recomendado usar `char[]` em vez de `String` para armazenar senhas?
2. O método `intern()` resolve esse problema de forma segura? Por que sim ou por que não?
3. Se você tivesse que comparar senhas com segurança criptográfica, qual método usaria?

---

###  60.5. <a name='Pergunta74UsocorretodeCollections:ListvsSetvsMap'></a>Pergunta 74 — Uso correto deCollections: List vs Set vs Map

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Você precisa implementar um sistema de controle de biblioteca que deve: (1) manter uma lista de livros na ordem em que foram doados, (2) controlar quais usuários estão atualmente com empréstimos ativos sem duplicatas, e (3) buscar rapidamente um livro pelo seu ISBN. Quais estruturas de dados da Java Collections Framework você usaria para cada caso e por quê?

**O que essa pergunta avalia:**  
Conhecimento sobre as principais interfaces da Collections Framework (List, Set, Map), compreensão das características de cada implementação, e capacidade de escolher a estrutura adequada com base nos requisitos.

**Resposta esperada:**  
1. **Lista de livros na ordem de doação:** Usar `ArrayList< Livro>` — mantém a ordem de inserção, permite duplicatas (pode haver dois livros idênticos doados), e é eficiente para iteração.
2. **Controle de usuários com empréstimos ativos sem duplicatas:** Usar `HashSet<Usuario>` — garante que não haja duplicatas (um usuário não aparece duas vezes como "com empréstimo ativo") e não exige ordem específica.
3. **Buscar livro por ISBN rapidamente:** Usar `HashMap<String, Livro>` — a chave é o ISBN (String) e o valor é o objeto `Livro`. A busca por chave em `HashMap` tem complexidade aproximada de O(1), tornando-a muito eficiente.

**Explicação didática:**  
Pense nas coleções do Java como diferentes tipos de organização:

- **List** é como uma fila do banco: mantém a ordem em que as pessoas chegaram, e pessoas podem aparecer mais de uma vez (em dias diferentes). Boa para quando a ordem importa e duplicatas são aceitáveis.
- **Set** é como um conjunto de chassis de carros em um estacionamento: cada chassis é único, não há duplicatas. Você não se importa com a ordem, apenas com a presença.
- **Map** é como uma agenda telefônica: você busca pelo nome (chave) e encontra o número (valor). Cada nome é único, e a busca é muito rápida.

**Exemplo prático:**  

```java
import java.util.*;

// 1. Lista de livros doados (ordem de doação)
List<Livro> livrosDoados = new ArrayList<>();
livrosDoados.add(new Livro("Dom Casmurro", "Machado de Assis"));
livrosDoados.add(new Livro("1984", "George Orwell"));

// 2. Usuários com empréstimos ativos (sem duplicatas)
Set<Usuario> emprestimosAtivos = new HashSet<>();
emprestimosAtivos.add(usuario1);
emprestimosAtivos.add(usuario1); // Ignorado — já existe no conjunto
// Para que o Set funcione corretamente, Usuario deve ter equals() e hashCode()

// 3. Busca de livro por ISBN
Map<String, Livro> livrosPorISBN = new HashMap<>();
livrosPorISBN.put("9788535913776", new Livro("Dom Casmurro", "Machado de Assis"));
Livro encontrado = livrosPorISBN.get("9788535913776"); // Busca rápida O(1)
```

**Como o candidato deve responder:**  
- Justificar cada escolha com base nas características da estrutura e nos requisitos
- Explicar que `ArrayList` mantém ordem de inserção e permite duplicatas
- Explicar que `HashSet` não permite duplicatas (dependendo de equals/hashCode)
- Explicar que `HashMap` oferece busca eficiente por chave
- Mencionar alternativas quando apropriado (ex: `LinkedHashSet` se fosse necessário manter ordem de inserção no Set)
- Evitar confundir List com Set ou Map

**Resposta fraca ou incompleta:**  
"Usaria List para tudo." — Não reconhece que os requisitos são diferentes e que cada estrutura tem vantagens específicas. Não justifica a escolha.

**Critérios de avaliação:**  
- 0 — Não conhece as diferenças entre List, Set e Map
- 1 — Conhece superficialmente, mas não acerta todas as escolhas
- 2 — Acerta as escolhas, mas não justifica adequadamente
- 3 — Escolhe corretamente e justifica com propriedade
- 4 — Demonstra domínio prático, menciona complexidade e alternativas
- 5 — Responde com profundidade, discute implementações específicas (LinkedList vs ArrayList, TreeSet, TreeMap), trade-offs de performance

**Perguntas de aprofundamento:**  
1. Se você precisasse que a lista de livros doados fosse eficiente para inserção no início da lista, qual implementação usaria?
2. Se fosse necessário listar os usuários com empréstimos na ordem em que pegaram o livro, qual Set usaria?
3. Qual a complexidade de busca em um `HashSet` comparada a um `TreeSet`?

---

###  60.6. <a name='Pergunta75Laofor-eachvsfortradicional:modificaoduranteiterao'></a>Pergunta 75 — Laço for-each vs for tradicional: modificação durante iteração

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Um colega escreveu o código abaixo para remover de uma lista todos os produtos com preço zero:

```java
List<Produto> produtos = carregarProdutos();
for (Produto p : produtos) {
    if (p.getPreco() == 0) {
        produtos.remove(p);
    }
}
```

Ao executar, recebe uma `ConcurrentModificationException`. Explique o que aconteceu e como resolver.

**O que essa pergunta avalia:**  
Compreensão do comportamento de iteradores em Java, conhecimento sobre `ConcurrentModificationException`, e capacidade de resolver problemas de modificação de coleções durante iteração.

**Resposta esperada:**  
O laço for-each usa internamente um `Iterator` para percorrer a lista. O `Iterator` mantém um contador de modificações (modCount) que é verificado a cada iteração. Quando `produtos.remove(p)` é chamado diretamente na lista (não pelo iterador), o modCount da lista muda, mas o iterador não é notificado. Na próxima iteração, o iterador detecta a discrepância e lança `ConcurrentModificationException`. As soluções incluem: usar `Iterator.remove()`, usar o método `removeIf()` (Java 8+), ou criar uma nova lista apenas com os elementos desejados.

**Explicação didática:**  
Imagine que você está contando as páginas de um livro enquanto alguém arranca páginas dele. Você ficaria confuso porque o número de páginas muda no meio da contagem. O `Iterator` faz algo parecido: ele "marca" o estado da lista no início da iteração e verifica se algo mudou a cada passo. Se a lista foi modificada diretamente (não através do próprio iterador), ele lança a exceção como mecanismo de proteção ("fail-fast").

**Exemplo prático:**  

```java
// Solução 1: Usar Iterator.remove()
List<Produto> produtos = carregarProdutos();
Iterator<Produto> it = produtos.iterator();
while (it.hasNext()) {
    Produto p = it.next();
    if (p.getPreco() == 0.0) {
        it.remove(); // Remove através do iterador — seguro
    }
}

// Solução 2: Usar removeIf (Java 8+ — mais limpo)
produtos.removeIf(p -> p.getPreco() == 0.0);

// Solução 3: Criar nova lista com os elementos desejados (imutabilidade)
List<Produto> produtosFiltrados = produtos.stream()
    .filter(p -> p.getPreco() > 0.0)
    .collect(Collectors.toList());
```

**Como o candidato deve responder:**  
- Explicar que o for-each usa Iterator internamente
- Identificar que `List.remove()` não sincroniza com o Iterator
- Propor ao menos uma solução correta (Iterator.remove, removeIf, ou stream filter)
- Mencionar que `removeIf` é a abordagem mais limpa em Java 8+
- Considerar a comparação de `double` com `==` (ponto flutuante pode ter imprecisão)
- Evitar sugerir capturar a exceção com try-catch

**Resposta fraca ou incompleta:**  
"É só colocar um try-catch em volta do for." — Errado. Capturar a exceção não resolve o problema, apenas o oculta. A remoção ainda não funciona corretamente.

**Critérios de avaliação:**  
- 0 — Não sabe o que é ConcurrentModificationException
- 1 — Sabe que não pode remover durante o for-each, mas não sabe por quê
- 2 — Explica o problema do Iterator, mas propõe apenas uma solução básica
- 3 — Explica corretamente e propõe solução adequada (removeIf ou Iterator.remove)
- 4 — Demonstra domínio prático, menciona múltiplas abordagens e trade-offs
- 5 — Responde com profundidade, discute fail-fast vs fail-safe, imutabilidade e comparação de doubles

**Perguntas de aprofundamento:**  
1. Se você usasse uma `CopyOnWriteArrayList` em vez de `ArrayList`, a exceção ocorreria? Por quê?
2. Qual a diferença entre `removeIf` e usar `stream().filter().collect()`? Existe algum impacto em performance?
3. Por que comparar `double` com `==` pode ser problemático? Como resolver isso?

---

###  60.7. <a name='Pergunta76CompreensodeExceesCheckedvsUnchecked'></a>Pergunta 76 — Compreensão de Exceções Checked vs Unchecked

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em um projeto de e-commerce, você tem um método `processarPagamento(Pedido pedido)` que pode falhar por diversos motivos: conexão com o gateway de pagamento indisponível, dados do cartão inválidos, ou saldo insuficiente. Como você decidiria quais exceções criar como checked e quais como unchecked? Justifique sua escolha.

**O que essa pergunta avalia:**  
Compreensão da diferença entre exceções checked e unchecked, conhecimento sobre herança de `Exception` vs `RuntimeException`, e capacidade de tomar decisões de design sobre tratamento de erros.

**Resposta esperada:**  
A decisão entre checked e unchecked depende de quem pode recuperar-se do erro e se o erro é esperado no fluxo normal da aplicação:

- **Checked (estendem `Exception`):** Usadas quando o chamador pode razoavelmente se recuperar do erro. Ex: `DadosCartaoInvalidosException` — o sistema pode pedir ao usuário que corrija os dados. Como é algo esperado no fluxo de pagamento, forçar o tratamento explícito faz sentido.
- **Unchecked (estendem `RuntimeException`):** Usadas para erros que o chamador normalmente não pode tratar ou que indicam bugs no programa. Ex: `GatewayIndisponivelException` — se o gateway caiu, não há muito que o código chamador possa fazer além de logar e propagar. Torná-la unchecked evita poluir a assinatura dos métodos com throws desnecessários.
- **Saldo insuficiente** poderia ser checked, pois o sistema pode orientar o usuário a tentar outro método de pagamento.

No entanto, muitos desenvolvedores modernos preferem usar apenas unchecked exceptions, argumentando que exceções checked poluem o código com try-catch em múltiplas camadas. Essa é uma decisão de design que deve ser alinhada com a equipe.

**Explicação didática:**  
Pense nas exceções como semáforos:

- **Checked** é como um sinal de "PARE" obrigatório: o compilador obriga você a parar e tratar (ou declarar que propaga). É para situações que você **prevê** que podem acontecer e para as quais **pode** ter um plano B.
- **Unchecked** é como um acidente inesperado: você não planeja para ele em cada esquina, pois pode acontecer em qualquer lugar. O código não precisa declarar explicitamente que pode ocorrer.

**Exemplo prático:**  

```java
// Checked — o chamador precisa tratar ou declarar
public class DadosCartaoInvalidosException extends Exception {
    public DadosCartaoInvalidosException(String mensagem) {
        super(mensagem);
    }
}

// Unchecked — erro de infraestrutura, propagar sem obrigar tratamento
public class GatewayIndisponivelException extends RuntimeException {
    public GatewayIndisponivelException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

// Uso no método
public void processarPagamento(Pedido pedido) 
    throws DadosCartaoInvalidosException { // Checked: obriga tratamento
    
    if (!validarCartao(pedido.getCartao())) {
        throw new DadosCartaoInvalidosException("Número do cartão inválido");
    }
    
    try {
        gateway.cobrar(pedido);
    } catch (Exception e) {
        throw new GatewayIndisponivelException("Falha no gateway", e); // Unchecked
    }
}
```

**Como o candidato deve responder:**  
- Explicar a diferença entre checked (compilador obriga tratamento) e unchecked (não obriga)
- Justificar cada escolha com base na capacidade de recuperação do chamador
- Mencionar que não existe resposta única — é uma decisão de design
- Considerar a abordagem moderna de preferir unchecked (alinhada com frameworks como Spring)
- Evitar dizer que toda exceção deve ser checked ou toda unchecked

**Resposta fraca ou incompleta:**  
"Checked são para erros graves e unchecked para erros leves." — Incorreto. A gravidade do erro não define se é checked ou unchecked. O critério é a capacidade de recuperação do chamador.

**Critérios de avaliação:**  
- 0 — Não sabe a diferença entre checked e unchecked
- 1 — Sabe a diferença, mas não consegue justificar as escolhas
- 2 — Classifica corretamente algumas exceções, mas não justifica bem
- 3 — Explica o critério de recuperação e justifica as escolhas
- 4 — Demonstra domínio prático, menciona o debate moderno sobre checked vs unchecked
- 5 — Responde com profundidade, discute hierarquia de exceções, padrões de tratamento, e impacto em arquitetura

**Perguntas de aprofundamento:**  
1. Por que o Spring Framework prefere unchecked exceptions?
2. Se você tivesse que criar uma hierarquia de exceções para o módulo de pagamentos, como organizaria?
3. O que acontece se uma exceção checked não for tratada nem declarada no método chamador?

---

###  60.8. <a name='Pergunta77UsodeStringBuilderemconcatenaodestrings'></a>Pergunta 77 — Uso de StringBuilder em concatenação de strings

**Nível:** Júnior  
**Categoria:** Desempenho

**Pergunta do entrevistador:**  
Em um relatório de vendas, você precisa construir uma string com o resumo de 500 transações, concatenando dados de cada uma. O código atual usa `String resultado = "";` e faz `resultado += transacao.toString();` dentro de um loop. Um colega sugeriu usar `StringBuilder`. Explique por que isso é importante e reescreva o código.

**O que essa pergunta avalia:**  
Compreensão da imutabilidade de Strings em Java, conhecimento sobre o impacto de concatenação com `+=` em loops, e uso correto de `StringBuilder`.

**Resposta esperada:**  
Strings em Java são **imutáveis** — cada operação de concatenação com `+=` cria um novo objeto String, copiando todo o conteúdo anterior para o novo objeto. Em um loop de 500 iterações, isso significa criar 500 objetos String, cada vez copiando uma string cada vez maior. A complexidade é O(n²) em relação ao tamanho final da string. `StringBuilder` é uma classe mutável projetada para construção eficiente de strings, mantendo um buffer interno que cresce conforme necessário, evitando cópias desnecessárias. A complexidade cai para O(n).

**Explicação didática:**  
Imagine que você está escrevendo uma carta à mão. Cada vez que quer adicionar uma palavra, você **reescreve a carta inteira do zero**, do início até a nova palavra. Isso é o que `+=` faz com Strings imutáveis.

Agora imagine que você tem uma folha grande com espaço em branco no final e só vai escrevendo no final, sem precisar recomeçar. Isso é o `StringBuilder`.

**Exemplo prático:**  

```java
// Código com problema — O(n²)
String resultado = "";
for (Transacao t : transacoes) {
    resultado += t.toString(); // Cria nova String a cada iteração
}

// Código otimizado com StringBuilder — O(n)
StringBuilder sb = new StringBuilder();
for (Transacao t : transacoes) {
    sb.append(t.toString()); // Modifica o buffer interno
}
String resultado = sb.toString(); // Converte para String apenas no final

// Alternativa com Java 8+ Streams
String resultado = transacoes.stream()
    .map(Transacao::toString)
    .collect(Collectors.joining("\n"));
```

**Como o candidato deve responder:**  
- Explicar a imutabilidade de String e por que `+=` é ineficiente em loops
- Propor `StringBuilder` como solução
- Mostrar o código reescrito corretamente
- Mencionar que `Collectors.joining()` é uma alternativa elegante com Streams
- Reconhecer que em concatenações simples (fora de loops), o compilador pode otimizar automaticamente
- Evitar usar `StringBuffer` sem motivo (é sincronizada e mais lenta que `StringBuilder`)

**Resposta fraca ou incompleta:**  
"StringBuilder é mais rápido." — Verdadeiro, mas não explica o porquê. Falta explicar a imutabilidade de Strings e o impacto da cópia em cada concatenação.

**Critérios de avaliação:**  
- 0 — Não sabe por que StringBuilder é melhor
- 1 — Sabe que é mais rápido, mas não explica o motivo
- 2 — Explica imutabilidade, mas não menciona complexidade
- 3 — Explica imutabilidade, complexidade O(n²) vs O(n), e propõe solução
- 4 — Demonstra domínio prático, menciona Streams, diferencia StringBuffer de StringBuilder
- 5 — Responde com profundidade, discute otimização do compilador, capacidade inicial do buffer, e quando usar cada abordagem

**Perguntas de aprofundamento:**  
1. Qual a diferença entre `StringBuilder` e `StringBuffer`? Quando usar cada um?
2. Se você soubesse o tamanho aproximado do resultado final, como otimizar ainda mais o `StringBuilder`?
3. Por que `String resultado = "a" + "b" + "c"` não tem problema de performance como o loop com `+=`?

---

###  60.9. <a name='Pergunta78Compreensodeheranaepolimorfismo'></a>Pergunta 78 — Compreensão de herança e polimorfismo

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em um sistema de RH, você tem as classes `Funcionario`, `Gerente` (herda de `Funcionario`) e `Desenvolvedor` (herda de `Funcionario`). Cada uma tem seu próprio método `calcularSalario()`. Um colega escreveu:

```java
Funcionario f = new Gerente();
double salario = f.calcularSalario();
```

Ele perguntou: "Como o Java sabe qual versão de `calcularSalario()` chamar?" Explique o mecanismo envolvido.

**O que essa pergunta avalia:**  
Compreensão de polimorfismo, ligação dinâmica (dynamic dispatch), sobrescrita de métodos (`@Override`), e como o tipo da referência difere do tipo do objeto.

**Resposta esperada:**  
O Java usa **ligação dinâmica** (dynamic dispatch / late binding) para resolver chamadas de métodos de instância. Embora a referência `f` seja do tipo `Funcionario`, o objeto na memória é uma instância de `Gerente`. Em tempo de execução, a JVM olha para o **tipo real do objeto** (não o tipo da referência) para determinar qual implementação de `calcularSalario()` executar. Como `Gerente` sobrescreveu o método, a versão de `Gerente` será chamada. Isso é o polimorfismo em ação: o mesmo código (`f.calcularSalario()`) pode executar comportamentos diferentes dependendo do tipo real do objeto.

**Explicação didática:**  
Imagine que você tem um controle remoto universal (tipo da referência = `Funcionario`). Ele tem um botão "Play" (método `calcularSalario()`). Quando você aperta "Play", o que acontece depende de **qual aparelho está conectado** (tipo do objeto = `Gerente` ou `Desenvolvedor`). O controle não muda, mas o comportamento do botão depende do aparelho real conectado naquele momento.

A anotação `@Override` não é obrigatória para que a sobrescrita funcione, mas é uma boa prática: ela faz o compilador verificar se o método realmente sobrescreve um método da superclasse, evitando erros de digitação na assinatura.

**Exemplo prático:**  

```java
class Funcionario {
    public double calcularSalario() {
        return 3000.0; // Salário base
    }
}

class Gerente extends Funcionario {
    @Override
    public double calcularSalario() {
        return 3000.0 + 2000.0; // Base + bônus de gerência
    }
}

class Desenvolvedor extends Funcionario {
    @Override
    public double calcularSalario() {
        return 3000.0 + 1000.0; // Base + bônus de tecnologia
    }
}

// Polimorfismo em ação
List<Funcionario> funcionarios = Arrays.asList(
    new Gerente(),
    new Desenvolvedor(),
    new Funcionario()
);

for (Funcionario f : funcionarios) {
    // Cada chamada executa a versão correta:
    // Gerente → 5000.0
    // Desenvolvedor → 4000.0
    // Funcionario → 3000.0
    System.out.println(f.calcularSalario());
}
```

**Como o candidato deve responder:**  
- Explicar que a JVM usa o tipo real do objeto, não o tipo da referência
- Mencionar o termo "ligação dinâmica" ou "late binding"
- Explicar o papel do `@Override` como boa prática (verificação do compilador)
- Demonstrar com um exemplo prático de polimorfismo
- Mencionar que métodos `static` e `private` não seguem ligação dinâmica
- Evitar confundir sobrescrita (override) com sobrecarga (overload)

**Resposta fraca ou incompleta:**  
"Porque o Gerente sobrescreveu o método." — Correto, mas não explica o mecanismo. Não menciona que a decisão é feita em runtime baseada no tipo do objeto, nem o papel da ligação dinâmica.

**Critérios de avaliação:**  
- 0 — Não sabe o que é polimorfismo
- 1 — Sabe que a subclasse sobrescreve, mas não explica o mecanismo
- 2 — Explica que o tipo do objeto determina a chamada, mas não menciona ligação dinâmica
- 3 — Explica ligação dinâmica corretamente
- 4 — Demonstra domínio prático, diferencia override de overload, menciona @Override
- 5 — Responde com profundidade, discute métodos estáticos vs instância, acesso a membros, e vantagens do polimorfismo

**Perguntas de aprofundamento:**  
1. O que aconteceria se `calcularSalario()` fosse `static`? O polimorfismo funcionaria?
2. Qual a diferença entre **sobrescrita** (override) e **sobrecarga** (overload)?
3. Se `Gerente` tivesse um método `getBonus()` que não existe em `Funcionario`, como você acessaria esse método usando a referência `f`?

---

###  60.10. <a name='Pergunta79Compreensodemodificadoresdeacesso'></a>Pergunta 79 — Compreensão de modificadores de acesso

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em uma classe `ContaBancaria`, você tem os seguintes modificadores de acesso: um atributo `saldo` como `private`, um método `sacar(double valor)` como `public`, um método `calcularTaxa()` como `protected`, e um método `logarTransacao()` sem modificador (package-private). Explique o que cada modificador significa e por que essa combinação faz sentido em um sistema bancário.

**O que essa pergunta avalia:**  
Conhecimento dos quatro modificadores de acesso de Java (`private`, `protected`, package-private, `public`), compreensão de encapsulamento, e capacidade de justificar escolhas de visibilidade.

**Resposta esperada:**  
- **`private saldo`:** Apenas a própria classe `ContaBancaria` acessa diretamente. O saldo não deve ser alterado livremente — toda modificação passa pelos métodos `sacar()` e `depositar()`, garantindo validação e consistência. Isso é **encapsulamento**.
- **`public sacar()`:** Qualquer classe pode chamar. É uma operação que faz parte da interface pública da conta — clientes externos (como um controller ou service) precisam interagir com ela.
- **`protected calcularTaxa()`:** Acessível pela própria classe, por subclasses (como `ContaPoupanca`, `ContaCorrente`) e por classes do mesmo pacote. Faz sentido se subclasses precisarem sobrescrever ou usar a lógica de taxa, mas classes externas não deveriam chamar diretamente.
- **`logarTransacao()` (package-private):** Acessível apenas por classes do mesmo pacote. Faz sentido se apenas classes internas do pacote (como um `ContaService` ou `AuditoriaHelper`) precisam logar transações, mas classes fora do pacote não deveriam.

**Explicação didática:**  
Pense nos modificadores como níveis de acesso de um edifício:

- **`private`**: o cofre da sua sala — só você tem a chave.
- **package-private** (sem modificador): as áreas do seu andar — quem está no mesmo andar entra, visitantes de outros andares não.
- **`protected`**: as áreas do seu andar **e** seus familiares (subclasses) em qualquer andar.
- **`public`**: a recepção do prédio — qualquer pessoa pode entrar.

**Exemplo prático:**  

```java
public class ContaBancaria {
    private double saldo; // Só a própria classe acessa

    public void sacar(double valor) { // Qualquer um pode chamar
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            logarTransacao("Saque: " + valor);
        } else {
            throw new IllegalArgumentException("Saque inválido");
        }
    }

    protected double calcularTaxa() { // Subclasses e mesmo pacote
        return saldo * 0.01;
    }

    void logarTransacao(String mensagem) { // Apenas mesmo pacote
        System.out.println("[LOG] " + mensagem);
    }
}

class ContaCorrente extends ContaBancaria {
    @Override
    protected double calcularTaxa() {
        return super.calcularTaxa() + 5.0; // Pode acessar protected
    }
}
```

**Como o candidato deve responder:**  
- Explicar corretamente os quatro modificadores
- Justificar cada escolha no contexto bancário
- Mencionar o conceito de encapsulamento para o atributo `saldo`
- Explicar que `protected` é relevante quando há herança
- Reconhecer que package-private é o padrão quando nenhum modificador é especificado
- Evitar confundir `protected` com `public`

**Resposta fraca ou incompleta:**  
"Private é privado, public é público." — Tautológico. Não explica o que cada um realmente significa nem justifica as escolhas no contexto.

**Critérios de avaliação:**  
- 0 — Não conhece os modificadores de acesso
- 1 — Conhece private e public, mas erra protected ou package-private
- 2 — Conhece todos, mas não justifica adequadamente
- 3 — Explica os quatro modificadores corretamente e justifica
- 4 — Demonstra domínio prático, menciona encapsulamento, herança, design de API
- 5 — Responde com profundidade, discute impacto em arquitetura de pacotes, coesão, e princípios de OO

**Perguntas de aprofundamento:**  
1. Um método `protected` em uma classe de um pacote `com.banco.modelo` pode ser acessado por uma classe em `com.banco.service`? Por quê?
2. Qual a diferença prática entre package-private e protected quando não há herança envolvida?
3. Por que expor o `saldo` como `public` seria um problema de segurança?

---

###  60.11. <a name='Pergunta80Usodeinterfacesvsclassesabstratas'></a>Pergunta 80 — Uso de interfaces vs classes abstratas

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em um sistema de notificações, você precisa modelar diferentes tipos de notificador: `NotificadorEmail`, `NotificadorSMS`, e `NotificadorPush`. Todos devem ter um método `enviar(String destinatario, String mensagem)`, mas o `NotificadorEmail` também precisa de métodos específicos como `anexarArquivo(String caminho)`. Você usaria interface, classe abstrata, ou ambos? Justifique.

**O que essa pergunta avalia:**  
Compreensão da diferença entre interfaces e classes abstratas, conhecimento de quando usar cada uma, e capacidade de modelar hierarquias de classes com responsabilidades específicas.

**Resposta esperada:**  
A abordagem mais recomendada é usar uma **interface** `Notificador` com o método `enviar()` que todas as implementações devem ter, e deixar que cada classe concreta implemente sua lógica específica. O método `anexarArquivo()` não deve estar na interface geral, pois não faz sentido para SMS ou Push. Se houver código comum entre os notificadores (ex: validação de destinatário, log), pode-se usar uma **classe abstrata** `AbstractNotificador` que implementa a interface e fornece os métodos comuns, enquanto as classes concretas herdam dela. Isso combina o melhor dos dois mundos: a interface define o contrato, e a classe abstrata fornece reutilização de código.

**Explicação didática:**  
Pense em uma **interface** como um **contrato de trabalho**: diz o que você deve fazer, mas não como. Qualquer classe pode assinar esse contrato, independentemente de sua herança.

Uma **classe abstrata** é como um **manual de procedimentos**: além de dizer o que fazer, fornece partes prontas (métodos concretos) e deixa espaços em branco (métodos abstratos) para você preencher. Mas você só pode seguir um manual de cada vez (Java não permite herança múltipla de classes).

A regra prática: **use interface para definir contratos** e **classe abstrata para compartilhar código**. Se possível, use ambas.

**Exemplo prático:**  

```java
// Interface: contrato comum a todos os notificadores
public interface Notificador {
    boolean enviar(String destinatario, String mensagem);
}

// Classe abstrata: código comum reutilizável
public abstract class AbstractNotificador implements Notificador {
    protected void logarEnvio(String destinatario, String status) {
        System.out.println("Notificação para " + destinatario + ": " + status);
    }

    protected boolean validarDestinatario(String destinatario) {
        return destinatario != null && !destinatario.isEmpty();
    }
}

// Implementação específica de Email com método extra
public class NotificadorEmail extends AbstractNotificador {
    @Override
    public boolean enviar(String destinatario, String mensagem) {
        if (!validarDestinatario(destinatario)) return false;
        // Lógica de envio por email...
        logarEnvio(destinatario, "Email enviado");
        return true;
    }

    // Método específico — não está na interface
    public void anexarArquivo(String caminho) {
        System.out.println("Arquivo anexado: " + caminho);
    }
}

// SMS não precisa de anexarArquivo
public class NotificadorSMS extends AbstractNotificador {
    @Override
    public boolean enviar(String destinatario, String mensagem) {
        if (!validarDestinatario(destinatario)) return false;
        // Lógica de envio por SMS...
        logarEnvio(destinatario, "SMS enviado");
        return true;
    }
}
```

**Como o candidato deve responder:**  
- Explicar que interfaces definem contratos e classes abstratas fornecem código reutilizável
- Propor a combinação de ambos (interface + classe abstrata) como melhor abordagem
- Explicar por que `anexarArquivo()` não deve estar na interface
- Mencionar que Java permite implementar múltiplas interfaces mas herdar de apenas uma classe
- Considerar métodos default em interfaces (Java 8+) como alternativa
- Evitar dizer que só se deve usar um ou outro

**Resposta fraca ou incompleta:**  
"Usaria interface porque é mais flexível." — Não explica por quê nem menciona quando a classe abstrata seria útil. Não aborda a necessidade de código compartilhado.

**Critérios de avaliação:**  
- 0 — Não sabe a diferença entre interface e classe abstrata
- 1 — Sabe a diferença básica, mas não consegue justificar a escolha
- 2 — Propõe interface, mas ignora a necessidade de compartilhar código
- 3 — Propõe interface + classe abstrata e justifica corretamente
- 4 — Demonstra domínio prático, menciona métodos default, herança múltipla, polimorfismo
- 5 — Responde com profundidade, discute design orientado a interfaces, princípio de segregação de interfaces (ISP), e impactos em manutenção

**Perguntas de aprofundamento:**  
1. Com os métodos `default` em interfaces (Java 8+), ainda faz sentido usar classes abstratas?
2. Se no futuro fosse necessário que `NotificadorEmail` também implementasse `Serializable`, como a interface ajuda nesse cenário?
3. Qual princípio SOLID está relacionado à decisão de não colocar `anexarArquivo()` na interface `Notificador`?

---

###  60.12. <a name='Pergunta81CompreensodeCastingeClassCastException'></a>Pergunta 81 — Compreensão de Casting e ClassCastException

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Considere o código:

```java
List<Object> lista = new ArrayList<>();
lista.add("Hello");
lista.add(42);
String s = (String) lista.get(1);
```

O que acontece quando esse código é executado? Por quê? Como você preveniria esse tipo de erro?

**O que essa pergunta avalia:**  
Compreensão de type casting em Java, conhecimento sobre `ClassCastException`, uso de generics para prevenir erros de tipo em tempo de compilação, e capacidade de diagnosticar problemas de tipo.

**Resposta esperada:**  
O código lança uma `ClassCastException` em tempo de execução na linha `String s = (String) lista.get(1)`. O motivo é que `lista.get(1)` retorna o objeto `Integer` 42 (autoboxed de `int` para `Integer`), e tentar converter um `Integer` para `String` é inválido — não há relação de herança entre as duas classes. O cast explícito `(String)` faz o compilador aceitar o código porque a lista é declarada como `List<Object>`, e `Object` pode teoricamente ser qualquer coisa. A forma de prevenir é usar **generics**: declarar a lista como `List<String>` faria o compilador rejeitar `lista.add(42)`, capturando o erro em tempo de compilação antes que se torne um problema em produção.

**Explicação didática:**  
Imagine que você tem uma caixa marcada como "Objetos" (sem tipo específico). Você coloca dentro um livro e depois uma caneta. Quando você tenta pegar o segundo item e tratá-lo como um livro (abrir na página 10), a caneta não pode ser aberta — ela não é um livro.

O cast `(String)` é como dizer "confie em mim, isso é uma String". O compilador aceita porque a lista guarda `Object` (qualquer coisa). Mas em runtime, a JVM descobre que não é uma String e lança `ClassCastException`.

Com generics (`List<String>`), a caixa é marcada como "Apenas Livros". Se você tentar colocar uma caneta, o compilador já barra — você nem consegue compilar o código.

**Exemplo prático:**  

```java
// Com problema — aceita qualquer tipo
List<Object> lista = new ArrayList<>();
lista.add("Hello");
lista.add(42); // Integer é aceito como Object
// String s = (String) lista.get(1); // ClassCastException em runtime!

// Solução com generics — segurança em tempo de compilação
List<String> listaStrings = new ArrayList<>();
listaStrings.add("Hello");
// listaStrings.add(42); // Erro de compilação! Não compila.

// Verificação segura com instanceof antes do cast
Object obj = lista.get(1);
if (obj instanceof String) {
    String s = (String) obj; // Seguro
    System.out.println(s);
} else {
    System.out.println("O objeto não é uma String: " + obj.getClass().getName());
}
```

**Como o candidato deve responder:**  
- Identificar que o erro é `ClassCastException` ao converter `Integer` em `String`
- Explicar que o cast é aceito pelo compilador porque a lista é `List<Object>`
- Propor generics (`List<String>`) como prevenção
- Mencionar `instanceof` como verificação defensiva quando o cast for inevitável
- Reconhecer que usar `List<Object>` ou `List` sem tipo (raw type) é uma má prática
- Evitar sugerir capturar `ClassCastException` com try-catch como solução

**Resposta fraca ou incompleta:**  
"Dá erro porque 42 não é String." — Correto, mas muito superficial. Não explica o mecanismo do cast, nem como prevenir com generics, nem menciona `instanceof`.

**Critérios de avaliação:**  
- 0 — Não sabe o que é ClassCastException
- 1 — Sabe que dá erro, mas não explica por quê
- 2 — Explica o erro, mas não propõe generics como solução
- 3 — Explica o erro e propõe generics, menciona instanceof
- 4 — Demonstra domínio prático, discute raw types, autoboxing, segurança em compilação
- 5 — Responde com profundidade, discute erros em tempo de compilação vs runtime, type erasure, e boas práticas com generics

**Perguntas de aprofundamento:**  
1. O que é **type erasure** em Java e por que `List<String>` e `List<Integer>` são a mesma classe em runtime?
2. Qual a diferença entre `instanceof` e `getClass()` para verificação de tipo?
3. Se você não pudesse usar generics, como tornaria esse código mais seguro?

---

###  60.13. <a name='Pergunta82EntendendoociclodevidadeumobjetocomGarbageCollector'></a>Pergunta 82 — Entendendo o ciclo de vida de um objeto com Garbage Collector

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em um sistema de processamento de imagens, um desenvolvedor criou uma classe `ProcessadorImagem` que, a cada execução, carrega uma imagem de 10MB na memória dentro de um loop de 100 iterações, sem liberar as referências anteriores. O sistema começa a apresentar `OutOfMemoryError`. Explique o que está acontecendo, o papel do Garbage Collector, e como resolver.

**O que essa pergunta avalia:**  
Compreensão do Garbage Collector (GC), gerenciamento de memória em Java, conceito de referências retidas, e capacidade de diagnosticar vazamentos de memória.

**Resposta esperada:**  
O problema é um **vazamento de memória** (memory leak). A cada iteração do loop, um novo objeto representando a imagem de 10MB é criado, mas as referências anteriores não são liberadas (não são setadas como `null` ou removidas de uma coleção). O Garbage Collector (GC) só libera objetos que **não têm mais referências ativas** apontando para eles. Se as referências antigas continuam acessíveis (ex: armazenadas em uma lista ou atributo de classe), o GC não pode coletá-las, e a memória se esgota, resultando em `OutOfMemoryError`.

Para resolver: garantir que as imagens antigas não sejam mais referenciadas quando não forem mais necessárias (remover da coleção ou setar como `null`), processar as imagens em lotes menores, ou usar `try-with-resources` se a classe implementar `AutoCloseable` para liberar recursos explicitamente. Também é importante investigar se é necessário manter todas as imagens na memória simultaneamente.

**Explicação didática:**  
Imagine que o Garbage Collector é o serviço de limpeza de um escritório. Ele passa regularmente e recolhe tudo que está na lixeira (objetos sem referência). Mas se você deixar papéis sobre a mesa (referências ativas), o serviço de limpeza não toca neles — ele assume que você ainda precisa deles.

Se você continua trazendo pilhas de papel (10MB por iteração) e as empilha sobre a mesa sem jogar as antigas na lixeira, eventualmente a mesa (memória) não aguenta mais e tudo desaba (`OutOfMemoryError`).

O GC não é um "mágico" que limpa tudo automaticamente — ele só limpa o que **detecta** que não é mais necessário. Se o código mantém referências desnecessárias, o GC não pode ajudar.

**Exemplo prático:**  

```java
// Com problema — mantém todas as referências
public class ProcessadorImagem {
    private List<byte[]> imagensProcessadas = new ArrayList<>();

    public void processarLote(List<String> caminhos) {
        for (String caminho : caminhos) {
            byte[] imagem = carregarImagem(caminho); // 10MB cada
            imagensProcessadas.add(imagem); // Mantém referência!
            processar(imagem);
        }
        // Após o loop, 100 imagens × 10MB = 1GB retido na memória
    }
}

// Solução — não reter imagens desnecessariamente
public void processarLote(List<String> caminhos) {
    for (String caminho : caminhos) {
        byte[] imagem = carregarImagem(caminho); // 10MB
        processar(imagem);
        // Após processar, a referência 'imagem' sai do escopo
        // na próxima iteração, permitindo que o GC colete a anterior
    }
}

// Se precisar armazenar resultados, guardar apenas metadados
public class ResultadoProcessamento {
    private String caminho;
    private long tamanhoBytes;
    // Não guarda o byte[] inteiro, apenas metadados
}
```

**Como o candidato deve responder:**  
- Explicar que o GC libera apenas objetos sem referências ativas
- Identificar que manter referências em coleções impede a coleta
- Propor soluções: não armazenar dados desnecessários, processar em lotes, setar null
- Mencionar que `OutOfMemoryError` indica esgotamento de memória heap
- Reconhecer que o GC é automático, mas não resolve referências retidas
- Evitar sugerir `System.gc()` como solução (não garante coleta e é má prática)

**Resposta fraca ou incompleta:**  
"O Garbage Collector deveria limpar automaticamente." — Errado. O GC só limpa o que não tem referências. Se as referências estão sendo mantidas, o GC não pode coletar. O candidato não identificou a causa raiz.

**Critérios de avaliação:**  
- 0 — Não sabe o que é Garbage Collector
- 1 — Sabe que existe GC, mas não entende o problema
- 2 — Identifica o vazamento, mas não propõe solução adequada
- 3 — Explica o problema, o GC, e propõe solução correta
- 4 — Demonstra domínio prático, menciona heap, profiling, boas práticas
- 5 — Responde com profundidade, discute tipos de referência (WeakReference, SoftReference), ferramentas de diagnóstico

**Perguntas de aprofundamento:**  
1. Qual a diferença entre `StrongReference`, `SoftReference` e `WeakReference`?
2. Por que chamar `System.gc()` não é uma boa prática?
3. Como você usaria ferramentas como `jmap` ou VisualVM para diagnosticar esse vazamento?

---

###  60.14. <a name='Pergunta83Usodetry-with-resourcesparagerenciamentoderecursos'></a>Pergunta 83 — Uso de try-with-resources para gerenciamento de recursos

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Em um sistema de importação de dados, você precisa ler um arquivo CSV grande usando um `BufferedReader` e também gravar um log das linhas processadas usando um `FileWriter`. Mostre como você garantiria que ambos os recursos sejam fechados corretamente, mesmo se ocorrer uma exceção durante o processamento.

**O que essa pergunta avalia:**  
Conhecimento sobre `try-with-resources` (Java 7+), interface `AutoCloseable`, e boas práticas para gerenciamento de recursos que precisam ser fechados.

**Resposta esperada:**  
A abordagem correta é usar `try-with-resources`, que fecha automaticamente todos os recursos declarados no `try` ao final do bloco, independente de sucesso ou exceção. Os recursos são fechados na **ordem inversa** de declaração. Para que funcione, as classes dos recursos devem implementar `AutoCloseable` (ou `Closeable`). Tanto `BufferedReader` quanto `FileWriter` implementam essa interface.

**Explicação didática:**  
Imagine que você entra em um laboratório com duas portas de segurança. O `try-with-resources` é como ter um sistema que fecha automaticamente as portas quando você sai, na ordem inversa: primeiro fecha a porta interna, depois a externa, mesmo que você tenha tropeçado no meio (exceção). Sem ele, você precisaria lembrar manualmente de fechar cada porta no finally — e é fácil esquecer, especialmente quando há exceções aninhadas.

**Exemplo prático:**  

```java
import java.io.*;

// Usando try-with-resources (Java 7+)
public void importarCSV(String caminhoCSV, String caminhoLog) {
    // Ambos recursos são declarados no try — fechados automaticamente
    try (BufferedReader reader = new BufferedReader(new FileReader(caminhoCSV));
         FileWriter writer = new FileWriter(caminhoLog)) {

        String linha;
        while ((linha = reader.readLine()) != null) {
            processarLinha(linha);
            writer.write("Processado: " + linha + "\n");
        }
    } catch (IOException e) {
        // Exceção é capturada, mas os recursos já foram fechados
        throw new ImportacaoException("Erro ao importar CSV", e);
    }
}

// Comparação com a abordagem antiga (NÃO recomendada)
public void importarCSVAntigo(String caminhoCSV) throws IOException {
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader(caminhoCSV));
        // processar...
    } finally {
        if (reader != null) {
            reader.close(); // Fácil de esquecer ou de dar erro aqui
        }
    }
}
```

**Como o candidato deve responder:**  
- Explicar que `try-with-resources` fecha recursos automaticamente
- Mostrar a sintaxe correta com múltiplos recursos
- Mencionar que os recursos são fechados na ordem inversa da declaração
- Explicar que as classes devem implementar `AutoCloseable`
- Mencionar que exceções suprimidas são preservadas (método `getSuppressed()`)
- Evitar usar o padrão antigo de try-finally manual

**Resposta fraca ou incompleta:**  
"Usaria um finally para fechar os dois." — Funciona, mas é a abordagem antiga e propensa a erros. Não menciona `try-with-resources` que é a prática recomendada desde o Java 7.

**Critérios de avaliação:**  
- 0 — Não sabe como fechar recursos
- 1 — Menciona finally, mas não conhece try-with-resources
- 2 — Conhece try-with-resources, mas erra a sintaxe com múltiplos recursos
- 3 — Usa try-with-resources corretamente e explica AutoCloseable
- 4 — Demonstra domínio prático, menciona ordem de fechamento, exceções suprimidas
- 5 — Responde com profundidade, discute diferença entre Closeable e AutoCloseable, customização de close()

**Perguntas de aprofundamento:**  
1. O que acontece se o método `close()` também lançar uma exceção?
2. Qual a diferença entre `Closeable` e `AutoCloseable`?
3. Se você criasse uma classe que gerencia uma conexão de rede, como a tornaria compatível com `try-with-resources`?

---

###  60.15. <a name='Pergunta84Entendendoautoboxingeunboxing'></a>Pergunta 84 — Entendendo autoboxing e unboxing

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Considere o código:

```java
Integer a = 127;
Integer b = 127;
System.out.println(a == b); // Imprime true

Integer c = 128;
Integer d = 128;
System.out.println(c == d); // Imprime false
```

Explique por que os resultados são diferentes.

**O que essa pergunta avalia:**  
Compreensão de autoboxing, cache de `Integer` (Integer Cache), e a interação entre tipos primitivos e wrappers.

**Resposta esperada:**  
O fenômeno ocorre devido ao **Integer Cache** do Java. Quando o Java faz autoboxing (converter `int` para `Integer`), ele reutiliza instâncias de `Integer` para valores no intervalo de **-128 a 127** (configurável). Assim, `a` e `b` (ambos 127) apontam para a **mesma instância** em cache, então `a == b` é `true`. Para 128, que está fora do cache, o Java cria instâncias separadas para `c` e `d`, então `c == d` compara referências diferentes e resulta em `false`. A lição é: **nunca use `==` para comparar objetos `Integer`** — sempre use `.equals()`.

**Explicação didática:**  
Pense que a Java guarda "números pré-impressos" de -128 a 127 em um arquivo de referências rápidas. Quando você pede o número 127, ele te dá a mesma "cópia impressa" que deu para outra pessoa — ambas apontam para o mesmo papel. Mas 128 não está nesse arquivo, então ele imprime uma nova cópia cada vez que você pede. Duas cópias impressas separadas não são "o mesmo papel físico", mesmo que tenham o mesmo número escrito.

**Exemplo prático:**  

```java
// Autoboxing: int → Integer
Integer x = 100;        // Autoboxing: Integer.valueOf(100)
int y = x;              // Unboxing: x.intValue()

// O cache funciona para o intervalo [-128, 127]
Integer a = 127;        // Retorna instância em cache
Integer b = 127;        // Mesma instância em cache
System.out.println(a == b);   // true — mesma referência

Integer c = 128;        // Nova instância (fora do cache)
Integer d = 128;        // Outra nova instância
System.out.println(c == d);   // false — referências diferentes
System.out.println(c.equals(d)); // true — mesmo valor

// Regra: sempre use equals() para wrappers
Integer valor1 = obterValor();
Integer valor2 = obterOutroValor();
if (valor1 != null && valor1.equals(valor2)) { // Seguro
    // ...
}
```

**Como o candidato deve responder:**  
- Explicar o conceito de autoboxing/unboxing
- Identificar o Integer Cache como causa do comportamento
- Mencionar o intervalo padrão do cache (-128 a 127)
- Concluir que `==` nunca deve ser usado para comparar wrappers
- Propor `.equals()` como alternativa correta
- Mencionar o risco de NPE ao unboxing quando o wrapper é `null`
- Evitar sugerir que o cache é um bug ou que deve ser desativado

**Resposta fraca ou incompleta:**  
"É porque 127 é pequeno e 128 é grande." — Não explica o mecanismo. Não menciona o cache nem o autoboxing.

**Critérios de avaliação:**  
- 0 — Não sabe o que é autoboxing
- 1 — Sabe que Integer é diferente de int, mas não explica o comportamento
- 2 — Menciona cache, mas não explica o intervalo nem a regra de usar equals()
- 3 — Explica o cache, o intervalo, e recomenda equals()
- 4 — Demonstra domínio prático, menciona NPE por unboxing, Objects.equals()
- 5 — Responde com profundidade, discute impacto em performance, configuração do cache, outros wrappers com cache (Boolean, Byte, Character)

**Perguntas de aprofundamento:**  
1. O que acontece se você fizer `Integer x = null; int y = x;`?
2. É possível alterar o intervalo do Integer Cache? Como?
3. `Boolean.TRUE == Boolean.valueOf(true)` sempre retorna `true`? Por quê?

---

###  60.16. <a name='Pergunta85Debugging:NullPointerExceptionsemstacktraceinformativo'></a>Pergunta 85 — Debugging: NullPointerException sem stack trace informativo

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Você recebeu o seguinte erro em produção:

```
Exception in thread "main" java.lang.NullPointerException
    at com.empresa.PedidoService.calcularTotal(PedidoService.java:45)
```

Ao abrir a linha 45 do `PedidoService`, você vê:

```java
double total = pedido.getItens().stream().mapToDouble(Item::getPreco).sum();
```

Como você identificaria qual parte está `null` e como preveniria esse tipo de erro no futuro?

**O que essa pergunta avalia:**  
Capacidade de debugar uma cadeia de chamadas de método (method chaining), identificar pontos de possível NPE, e aplicar boas práticas preventivas.

**Resposta esperada:**  
Na linha `pedido.getItens().stream().mapToDouble(Item::getPreco).sum()`, há três pontos possíveis de NPE:
1. **`pedido`** ser `null` — não dá para chamar `.getItens()`
2. **`pedido.getItens()`** retornar `null` — não dá para chamar `.stream()`
3. Algum **`Item`** na lista ter `getPreco()` retornando `null` — o autoboxing de `null` para `double` causaria NPE

Para identificar, a abordagem mais prática é verificar cada parte isoladamente. Em Java 14+, a mensagem do NPE indica qual variável era null (JEP 358: Helpful NullPointerExceptions). Para prevenir: usar `Optional`, verificar null antes de acessar, garantir que `getItens()` retorne uma lista vazia em vez de null (Null Object Pattern), e usar `Objects.requireNonNull()` para validar parâmetros de entrada.

**Explicação didática:**  
Pense nessa linha como uma corrente: pedido → getItens → stream → mapToDouble → sum. Se qualquer elo da corrente for nulo (não existe), a corrente inteira quebra. O desafio é descobrir **qual elo** quebrou.

**Exemplo prático:**  

```java
// Código original com risco de NPE
double total = pedido.getItens().stream().mapToDouble(Item::getPreco).sum();

// Solução defensiva: verificar cada ponto
public double calcularTotal(Pedido pedido) {
    // 1. Validar entrada
    Objects.requireNonNull(pedido, "Pedido não pode ser null");

    // 2. Garantir que getItens() nunca retorna null
    List<Item> itens = pedido.getItens();
    if (itens == null) {
        itens = Collections.emptyList(); // Null Object Pattern
    }

    // 3. Tratar preços nulos com filtro
    double total = itens.stream()
        .map(Item::getPreco)           // Stream<Double>
        .filter(Objects::nonNull)      // Remove nulls
        .mapToDouble(Double::doubleValue)
        .sum();

    return total;
}

// Melhoria: garantir que getItens() nunca retorna null
public class Pedido {
    private List<Item> itens = new ArrayList<>(); // Inicializada

    public List<Item> getItens() {
        return itens; // Nunca retorna null, pode retornar vazia
    }
}
```

**Como o candidato deve responder:**  
- Identificar os três pontos possíveis de NPE na linha
- Explicar como isolar cada parte para identificar a causa
- Mencionar o JEP 358 (NPE informativo no Java 14+) se souber
- Propor soluções preventivas: Optional, Objects.requireNonNull, Null Object Pattern
- Sugerir que `getItens()` nunca retorne null (retorne lista vazia)
- Evitar sugerir capturar NPE com try-catch

**Resposta fraca ou incompleta:**  
"É porque algo está null, é só colocar um if." — Muito vago. Não identifica quais pontos podem ser null nem propõe soluções estruturadas.

**Critérios de avaliação:**  
- 0 — Não consegue identificar os pontos de NPE
- 1 — Identifica um ponto, mas não os outros
- 2 — Identifica os pontos, mas não propõe prevenção estruturada
- 3 — Identifica todos os pontos e propõe soluções adequadas
- 4 — Demonstra domínio prático, menciona Null Object Pattern, JEP 358
- 5 — Responde com profundidade, discute Optional, imutabilidade, design defensivo

**Perguntas de aprofundamento:**  
1. O que é o **Null Object Pattern** e como ele se aplica a `getItens()`?
2. Como o `Objects.requireNonNull()` ajuda a detectar bugs mais cedo?
3. Se `Item::getPreco` retornasse `Double` (wrapper), o que aconteceria ao usar `mapToDouble`?

---

###  60.17. <a name='Pergunta86Entendendostaticvsinstncia'></a>Pergunta 86 — Entendendo static vs instância

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em um sistema de gerenciamento de contas bancárias, um desenvolvedor criou a seguinte classe:

```java
public class Conta {
    private static double saldo;
    
    public void depositar(double valor) {
        saldo += valor;
    }
    
    public double getSaldo() {
        return saldo;
    }
}
```

O sistema tem múltiplas contas, mas ao testar, o desenvolvedor percebeu que todas as contas mostram o mesmo saldo. Explique o problema.

**O que essa pergunta avalia:**  
Compreensão da diferença entre membros de instância e membros estáticos (`static`), e como o uso incorreto de `static` causa compartilhamento indesejado de estado.

**Resposta esperada:**  
O problema é que o atributo `saldo` foi declarado como `static`. Membros `static` pertencem à **classe**, não a instâncias individuais. Isso significa que existe **uma única cópia** de `saldo` compartilhada por **todas** as instâncias de `Conta`. Quando uma conta chama `depositar()`, o valor é somado ao saldo compartilhado, e todas as outras contas veem o mesmo valor. A correção é remover o modificador `static` do atributo `saldo`, tornando-o um membro de instância — assim, cada objeto `Conta` terá seu próprio saldo independente.

**Explicação didática:**  
Pense que membros `static` são como um **quadro de avisos** na parede da empresa: todos os funcionários (instâncias) veem o **mesmo** quadro. Se alguém escreve algo no quadro, todos veem a mudança.

Membros de instância (não-static) são como **cadernos individuais**: cada funcionário tem o seu, e o que um escreve no seu caderno não afeta o caderno dos outros.

No código, o `saldo` é `static` — é o "quadro de avisos". Todas as contas estão escrevendo no mesmo quadro, por isso veem o mesmo saldo. Remover o `static` dá a cada conta seu próprio "caderno".

**Exemplo prático:**  

```java
// INCORRETO — saldo compartilhado entre todas as contas
public class Conta {
    private static double saldo; // Erro: static = compartilhado!
    
    public void depositar(double valor) { saldo += valor; }
    public double getSaldo() { return saldo; }
}

Conta c1 = new Conta();
Conta c2 = new Conta();
c1.depositar(100.0);
System.out.println(c2.getSaldo()); // 100.0 — compartilharam o mesmo saldo!

// CORRETO — cada conta tem seu próprio saldo
public class Conta {
    private double saldo; // Membro de instância — um por objeto
    
    public void depositar(double valor) { saldo += valor; }
    public double getSaldo() { return saldo; }
}

Conta c1 = new Conta();
Conta c2 = new Conta();
c1.depositar(100.0);
System.out.println(c1.getSaldo()); // 100.0
System.out.println(c2.getSaldo()); // 0.0 — saldos independentes
```

**Como o candidato deve responder:**  
- Explicar que `static` significa que o membro pertence à classe, não à instância
- Identificar que existe apenas uma cópia do atributo compartilhada por todos
- Propor a remoção do `static` como correção
- Mencionar que métodos `static` também são compartilhados e não acessam membros de instância
- Citar exemplos de uso correto de `static` (constantes, utilitários, factories)
- Evitar dizer que `static` é sempre ruim — tem usos legítimos

**Resposta fraca ou incompleta:**  
"O static faz o saldo ser o mesmo." — Verdadeiro, mas não explica o conceito nem a solução. Não menciona o que `static` significa nem como corrigir.

**Critérios de avaliação:**  
- 0 — Não sabe o que `static` faz
- 1 — Sabe que static é compartilhado, mas não explica bem
- 2 — Explica o problema e propõe a correção, mas não menciona usos corretos de static
- 3 — Explica o problema, a correção, e quando static é apropriado
- 4 — Demonstra domínio prático, menciona constantes, utilitários, memória
- 5 — Responde com profundidade, discute problemas de concorrência com static, testabilidade, e alternatives como injeção de dependência

**Perguntas de aprofundamento:**  
1. Por que é difícil testar classes que usam muitos membros `static`?
2. Em quais situações usar `static` é apropriado? Dê exemplos.
3. O que aconteceria se o método `depositar` também fosse `static`?

---

###  60.18. <a name='Pergunta87UsocorretodeGenericscomwildcards'></a>Pergunta 87 — Uso correto de Generics com wildcards

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Você tem as classes `Animal`, `Cachorro extends Animal`, e `Gato extends Animal`. Você também tem um método:

```java
public void imprimirAnimais(List<Animal> animais) {
    for (Animal a : animais) {
        System.out.println(a.getNome());
    }
}
```

Ao tentar chamar `imprimirAnimais(listaDeCachorros)`, o compilador rejeita. Por quê? Como você corrigiria a assinatura do método?

**O que essa pergunta avalia:**  
Compreensão de generics em Java, covariância e contravariância, uso de wildcards (`? extends`, `? super`), e o motivo pelo qual `List<Cachorro>` não é subtipo de `List<Animal>`.

**Resposta esperada:**  
Embora `Cachorro` seja subtipo de `Animal`, `List<Cachorro>` **não** é subtipo de `List<Animal>`. Isso acontece porque, se o Java permitisse, o método poderia adicionar um `Gato` na lista (que é tratada como `List<Animal>`), violando a segurança de tipos. Para corrigir, deve-se usar **wildcard com limite superior**: `List<? extends Animal>`. Isso diz "uma lista de qualquer tipo que seja Animal ou subclasse de Animal". Com `? extends`, o método pode **ler** elementos como `Animal`, mas **não pode adicionar** (exceto `null`), garantindo a segurança do tipo.

**Explicação didática:**  
Imagine que você tem uma cesta de frutas marcada como "Cesta de Maçãs" (`List<Cachorro>`). Se você a tratasse como "Cesta de Frutas" (`List<Animal>`), alguém poderia colocar uma laranja (`Gato`) na cesta de maçãs — isso seria errado!

Para resolver, você diz: "Aceito uma cesta de **qualquer fruta**" (`List<? extends Animal>`). Você pode **olhar** dentro da cesta e ver frutas, mas **não pode colocar** nada novo, porque não sabe com certeza que tipo de fruta a cesta contém.

**Exemplo prático:**  

```java
class Animal { String nome; String getNome() { return nome; } }
class Cachorro extends Animal {}
class Gato extends Animal {}

// Erro: List<Cachorro> não é subtipo de List<Animal>
public void imprimirAnimais(List<Animal> animais) { ... }

// Correção com wildcard (? extends)
public void imprimirAnimais(List<? extends Animal> animais) {
    for (Animal a : animais) { // Pode ler como Animal
        System.out.println(a.getNome());
    }
    // animais.add(new Cachorro()); // Erro! Não pode adicionar com ? extends
}

// Agora funciona:
List<Cachorro> cachorros = new ArrayList<>();
imprimirAnimais(cachorros); // OK!

List<Gato> gatos = new ArrayList<>();
imprimirAnimais(gatos); // OK!

// Wildcard com limite inferior (? super) — para adicionar
public void adicionarAnimal(List<? super Cachorro> lista) {
    lista.add(new Cachorro()); // Pode adicionar Cachorro ou subclasses
}
```

**Como o candidato deve responder:**  
- Explicar que generics são invariantes: `List<Cachorro>` não é subtipo de `List<Animal>`
- Justificar com o exemplo de adicionar `Gato` em uma lista de `Cachorro`
- Propor `List<? extends Animal>` como solução para leitura
- Mencionar que `? extends` permite ler mas não adicionar (exceto null)
- Citar `? super` como complemento para quando se precisa adicionar
- Evitar sugerir usar `List<Object>` ou raw types como solução

**Resposta fraca ou incompleta:**  
"É porque Cachorro não é Animal." — Incorreto. `Cachorro` é `Animal`. O problema é que `List<Cachorro>` não é `List<Animal>` por causa da invariância de generics.

**Critérios de avaliação:**  
- 0 — Não entende o problema
- 1 — Sabe que não compila, mas não explica por quê
- 2 — Explica invariância, mas não propõe wildcard
- 3 — Propõe `? extends` e explica leitura vs escrita
- 4 — Demonstra domínio prático, menciona `? super`, princípio PECS
- 5 — Responde com profundidade, discute type erasure, PECS (Producer Extends, Consumer Super), uso em APIs

**Perguntas de aprofundamento:**  
1. O que significa o princípio **PECS** (Producer Extends, Consumer Super)?
2. Por que `List<? extends Animal>` permite adicionar `null` mas não `new Cachorro()`?
3. Qual a diferença entre `List<?>` e `List<Object>`?

---

###  60.19. <a name='Pergunta88Manipulaodedatascomjava.time'></a>Pergunta 88 — Manipulação de datas com java.time

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Em um sistema de agendamento de consultas, você precisa: (1) obter a data e hora atuais no fuso horário de São Paulo, (2) calcular a data de 30 dias úteis a partir de hoje (desconsiderando sábados e domingos), e (3) formatar a data resultante no padrão `dd/MM/yyyy`. Como você implementaria isso usando a API `java.time`?

**O que essa pergunta avalia:**  
Conhecimento da API `java.time` (Java 8+), manipulação de datas, fuso horário, e formatação.

**Resposta esperada:**  
Usar `ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))` para obter a data/hora atual no fuso correto, iterar adicionando dias com `plusDays(1)` e verificar se é dia útil com `getDayOfWeek()` (pulando `SATURDAY` e `SUNDAY`), e formatar com `DateTimeFormatter.ofPattern("dd/MM/yyyy")`.

**Explicação didática:**  
A API `java.time` (introduzida no Java 8) substituiu as antigas `Date` e `Calendar`, que eram confusas e propensas a erros. As classes principais são:

- **`LocalDate`**: só data (sem hora) — ex: 2024-03-15
- **`LocalTime`**: só hora (sem data) — ex: 14:30
- **`LocalDateTime`**: data e hora (sem fuso) — ex: 2024-03-15T14:30
- **`ZonedDateTime`**: data e hora com fuso — ex: 2024-03-15T14:30-03:00[America/Sao_Paulo]
- **`DateTimeFormatter`**: formatação e parsing

Pense em `ZonedDateTime` como um relógio de parede que sabe em qual cidade do mundo está. `LocalDate` é como anotar apenas a data em uma agenda, sem se preocupar com hora ou cidade.

**Exemplo prático:**  

```java
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

public class AgendamentoService {

    public String calcularDataConsulta() {
        // 1. Data/hora atual no fuso de São Paulo
        ZonedDateTime agora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        LocalDate dataAtual = agora.toLocalDate();

        // 2. Calcular 30 dias úteis
        int diasUteisContados = 0;
        LocalDate dataConsulta = dataAtual;
        while (diasUteisContados < 30) {
            dataConsulta = dataConsulta.plusDays(1); // Avança um dia
            DayOfWeek diaSemana = dataConsulta.getDayOfWeek();
            if (diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY) {
                diasUteisContados++; // Só conta se for dia útil
            }
        }

        // 3. Formatar a data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataConsulta.format(formatter);
    }
}
```

**Como o candidato deve responder:**  
- Mencionar as classes corretas: `ZonedDateTime`, `LocalDate`, `DateTimeFormatter`
- Explicar o uso de `ZoneId` para fuso horário
- Implementar o loop de dias úteis verificando `DayOfWeek`
- Usar `DateTimeFormatter` para formatar
- Mencionar que feriados não são tratados (seria necessário uma API externa ou tabela)
- Evitar usar `Date` e `Calendar` (APIs legadas)

**Resposta fraca ou incompleta:**  
"Usaria Calendar e SimpleDateFormat." — Usa APIs antigas e descontinuadas. Não aproveita os recursos de `java.time` e está sujeito a bugs de fuso horário e thread-safety.

**Critérios de avaliação:**  
- 0 — Não conhece a API java.time
- 1 — Conhece LocalDate mas não ZonedDateTime nem formatter
- 2 — Usa as classes corretas, mas erra a lógica de dias úteis
- 3 — Implementa corretamente com java.time
- 4 — Demonstra domínio prático, menciona feriados, thread-safety do formatter
- 5 — Responde com profundidade, discute imutabilidade, Period vs Duration, TemporalAdjusters

**Perguntas de aprofundamento:**  
1. Por que `DateTimeFormatter` é thread-safe e `SimpleDateFormat` não é?
2. Como você lidaria com feriados nacionais no cálculo de dias úteis?
3. Qual a diferença entre `Period` e `Duration` em java.time?

---

###  60.20. <a name='Pergunta89EntendendoomtodotoString'></a>Pergunta 89 — Entendendo o método toString()

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Em um sistema de e-commerce, ao imprimir um objeto `Pedido` no log, a saída é `Pedido@1b6d3586`. O desenvolvedor esperava ver os detalhes do pedido. Explique o que está acontecendo e como resolver, incluindo boas práticas.

**O que essa pergunta avalia:**  
Compreensão do método `toString()` padrão de `Object`, importância de sobrescrevê-lo, e uso de ferramentas para gerá-lo corretamente.

**Resposta esperada:**  
A saída `Pedido@1b6d3586` é o resultado do método `toString()` padrão da classe `Object`, que retorna o nome da classe seguido de `@` e o hash code em hexadecimal. Isso acontece porque a classe `Pedido` não sobrescreveu o método `toString()`. Para resolver, deve-se sobrescrever `toString()` retornando uma representação textual útil dos atributos do objeto. Pode-se fazer manualmente, usar `StringJoiner` (Java 8+), ou anotações como `@ToString` do Lombok. É importante não incluir dados sensíveis (senhas, tokens) no `toString()`.

**Explicação didática:**  
Toda classe em Java herda de `Object`, que tem um `toString()` padrão que basicamente diz "sou um objeto da classe X no endereço de memória Y". É como uma etiqueta genérica colada em todas as caixas: "Caixa #1234". Não diz nada sobre o que está dentro.

Quando você sobrescreve `toString()`, está criando uma etiqueta personalizada que descreve o conteúdo da caixa: "Pedido #4521, Cliente: João, Total: R$ 150,00".

**Exemplo prático:**  

```java
public class Pedido {
    private Long id;
    private String cliente;
    private double total;

    // Solução 1: toString() manual
    @Override
    public String toString() {
        return "Pedido{id=" + id + ", cliente='" + cliente + "', total=" + total + "}";
    }

    // Solução 2: StringJoiner (Java 8+)
    @Override
    public String toString() {
        return new StringJoiner(", ", "Pedido{", "}")
            .add("id=" + id)
            .add("cliente='" + cliente + "'")
            .add("total=" + total)
            .toString();
    }
}

// Solução 3: Lombok (se o projeto usar)
// @ToString
// public class Pedido { ... }

// Resultado após sobrescrever:
// Pedido{id=4521, cliente='João', total=150.0}
```

**Como o candidato deve responder:**  
- Explicar que `toString()` padrão vem de `Object` e retorna classe@hashCode
- Propor sobrescrita do método retornando os atributos
- Mencionar alternativas: manual, StringJoiner, Lombok
- Alertar sobre dados sensíveis não devem aparecer no toString()
- Reconhecer que `toString()` é essencial para debug e logs
- Evitar toString() excessivamente longos ou com lógica complexa

**Resposta fraca ou incompleta:**  
"É só colocar um System.out.println com os campos." — Não entende que o problema é a falta de `toString()` sobrescrito. Propõe uma solução paliativa que não funciona para logging automático.

**Critérios de avaliação:**  
- 0 — Não sabe o que toString() faz
- 1 — Sabe que falta toString(), mas não sabe como implementar
- 2 — Implementa toString() corretamente
- 3 — Implementa e menciona boas práticas (dados sensíveis, alternativas)
- 4 — Demonstra domínio prático, menciona StringJoiner, Lombok, logging
- 5 — Responde com profundidade, discute impacto em debug, logs, e quando não sobrescrever

**Perguntas de aprofundamento:**  
1. Por que não incluir senhas ou tokens no `toString()`?
2. Em que situação você NÃO sobrescreveria `toString()`?
3. Como o `toString()` interage com logging frameworks como SLF4J?

---

###  60.21. <a name='Pergunta90Entendendovarargs'></a>Pergunta 90 — Entendendo varargs

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em um sistema de relatórios, você precisa criar um método `gerarRelatorio` que aceite um título e uma quantidade variável de seções. Cada seção é uma `String`. Como você implementaria isso em Java? Explique como o varargs funciona internamente.

**O que essa pergunta avalia:**  
Conhecimento sobre varargs (`...`), compreensão de como o Java trata argumentos variáveis internamente como arrays, e capacidade de escolher entre varargs e `List`.

**Resposta esperada:**  
Usar varargs: `public void gerarRelatorio(String titulo, String... secoes)`. Internamente, o Java converte `String... secoes` em um array `String[] secoes`. Dentro do método, pode-se iterar sobre `secoes` como um array normal. Varargs é açúcar sintático (syntactic sugar) para arrays, oferecendo uma forma mais limpa de passar argumentos variáveis sem precisar criar um array explicitamente.

**Explicação didática:**  
Varargs é como pedir para alguém "traga os ingredientes que você tiver". Você pode trazer um, dois, ou nenhum — a pessoa coloca tudo em uma sacola (array) para você.

Anotação técnica: o `...` após o tipo diz ao compilador "aceite zero ou mais argumentos deste tipo e coloque-os em um array". É equivalente a passar `String[]`, mas sem precisar criar o array manualmente na chamada.

**Exemplo prático:**  

```java
public class GeradorRelatorio {

    // Varargs: String... secoes
    public void gerarRelatorio(String titulo, String... secoes) {
        System.out.println("=== " + titulo + " ===");
        // Internamente, 'secoes' é um String[]
        for (int i = 0; i < secoes.length; i++) {
            System.out.println((i + 1) + ". " + secoes[i]);
        }
    }

    // Diferentes formas de chamar:
    public void exemplo() {
        gerarRelatorio("Vendas Mensal"); // 0 seções
        gerarRelatorio("Vendas Mensal", "Resumo"); // 1 seção
        gerarRelatorio("Vendas Mensal", "Resumo", "Gráficos", "Tabela"); // 3 seções

        // Também aceita um array diretamente:
        String[] secoesArray = {"Introdução", "Análise", "Conclusão"};
        gerarRelatorio("Relatório Anual", secoesArray);
    }
}

// Regras do varargs:
// 1. Deve ser o último parâmetro do método
// 2. Só pode haver um vararg por método
// 3. Pode receber zero argumentos
```

**Como o candidato deve responder:**  
- Mostrar a sintaxe correta de varargs (`String... secoes`)
- Explicar que internamente é convertido em array
- Mencionar que varargs deve ser o último parâmetro
- Demonstrar diferentes formas de chamar o método
- Discutir quando usar varargs vs `List<String>` como parâmetro
- Evitar usar varargs quando o tipo do parâmetro é genérico (ex: `T...`) sem entender os riscos

**Resposta fraca ou incompleta:**  
"Usaria uma List<String>." — Funciona, mas não responde à pergunta sobre varargs. Não demonstra conhecimento do recurso.

**Critérios de avaliação:**  
- 0 — Não sabe o que é varargs
- 1 — Conhece a sintaxe, mas não explica como funciona
- 2 — Explica o mecanismo, mas não menciona regras ou alternativas
- 3 — Implementa corretamente, explica regras e funcionamento
- 4 — Demonstra domínio prático, menciona trade-offs varargs vs List, HEAP POLLUTION
- 5 — Responde com profundidade, discute @SafeVarargs, heap pollution com generics, e boas práticas

**Perguntas de aprofundamento:**  
1. O que é **heap pollution** e como varargs com genéricos pode causá-lo?
2. Por que a anotação `@SafeVarargs` existe e quando usá-la?
3. Se você precisa de validação dos argumentos, varargs ou List é melhor?

---

###  60.22. <a name='Pergunta91EntendendoordenaocomComparableeComparator'></a>Pergunta 91 — Entendendo ordenação com Comparable e Comparator

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Em um sistema de fila de atendimento hospitalar, você tem objetos `Paciente` com os atributos `nome`, `idade`, e `gravidade` (int, onde 1 = leve e 5 = crítico). Você precisa ordenar os pacientes por **gravidade decrescente** (mais graves primeiro) e, em caso de empate, por **idade decrescente** (mais idosos primeiro). Como você implementaria essa ordenação?

**O que essa pergunta avalia:**  
Conhecimento sobre `Comparable` vs `Comparator`, método `compareTo()`, ordenação com múltiplos critérios, e uso de `Collections.sort()` ou `List.sort()`.

**Resposta esperada:**  
A melhor abordagem é implementar `Comparator<Paciente>` (ou usar `Comparator.comparing()`) pois a ordenação por gravidade e idade é uma regra específica da fila de atendimento, não necessariamente a ordenação natural do objeto. Deve-se usar `Comparator.comparingInt(Paciente::getGravidade).reversed()` para gravidade decrescente e encadear com `.thenComparingInt(Paciente::getIdade).reversed()` para idade decrescente em caso de empate.

**Explicação didática:**  
- **`Comparable`** define a ordenação "natural" do objeto — é como o objeto "sabe" se comparar com outro do mesmo tipo. É como uma pessoa saber sua altura.
- **`Comparator`** é uma ordenação externa — você define como comparar dois objetos independentemente da ordenação natural. É como um juiz que decide quem é mais alto.

Use `Comparable` quando há uma ordenação óbvia e única (ex: `Integer` ordena por valor). Use `Comparator` quando há múltiplas formas de ordenar (ex: pacientes podem ser ordenados por nome, idade, gravidade...).

**Exemplo prático:**  

```java
import java.util.*;

public class Paciente {
    private String nome;
    private int idade;
    private int gravidade; // 1 = leve, 5 = crítico

    // Construtor, getters...

    // Solução 1: Comparator com método estático (recomendado)
    public static final Comparator<Paciente> ORDEM_ATENDIMENTO =
        Comparator.comparingInt(Paciente::getGravidade).reversed() // Gravidade decrescente
            .thenComparingInt(Paciente::getIdade).reversed();     // Idade decrescente (empate)

    // Solução 2: Comparable (se for a ordenação natural)
    // public class Paciente implements Comparable<Paciente> {
    //     @Override
    //     public int compareTo(Paciente outro) {
    //         int cmp = Integer.compare(outro.gravidade, this.gravidade); // Decrescente
    //         if (cmp != 0) return cmp;
    //         return Integer.compare(outro.idade, this.idade); // Decrescente
    //     }
    // }
}

// Uso:
List<Paciente> fila = new ArrayList<>();
fila.add(new Paciente("Ana", 30, 3));
fila.add(new Paciente("João", 65, 5));
fila.add(new Paciente("Maria", 70, 5));
fila.add(new Paciente("Pedro", 25, 3));

// Ordena usando o comparator
fila.sort(Paciente.ORDEM_ATENDIMENTO);

// Resultado:
// 1. João (grav=5, idade=65)
// 2. Maria (grav=5, idade=70) -- esperado: Maria antes de João?
// Cuidado: reversed() afeta toda a cadeia. Solução correta:
public static final Comparator<Paciente> ORDEM_ATENDIMENTO_CORRETA =
    Comparator.comparingInt((Paciente p) -> p.getGravidade()).reversed()
        .thenComparing(Comparator.comparingInt(Paciente::getIdade).reversed());
```

**Como o candidato deve responder:**  
- Escolher `Comparator` sobre `Comparable` para este cenário
- Explicar que `reversed()` inverte a ordem (decrescente)
- Encadear critérios com `thenComparing` / `thenComparingInt`
- Mencionar que `Comparable` seria para ordenação natural
- Cuidar com a aplicação de `reversed()` que afeta o comparador inteiro
- Evitar implementar a comparação manualmente com if-else quando a API oferece recursos

**Resposta fraca ou incompleta:**  
"Implemento Comparable e uso Collections.sort()." — Não diferencia Comparable de Comparator, não aborda múltiplos critérios, e não menciona ordenação decrescente.

**Critérios de avaliação:**  
- 0 — Não sabe ordenar coleções em Java
- 1 — Sabe que existe sort, mas não conhece Comparator
- 2 — Usa Comparator mas não implementa múltiplos critérios corretamente
- 3 — Implementa corretamente com múltiplos critérios e ordem decrescente
- 4 — Demonstra domínio prático, diferencia Comparable de Comparator, usa comparing()
- 5 — Responde com profundidade, discute estabilidade do sort, nullsFirst/Last, e performance

**Perguntas de aprofundamento:**  
1. Qual a diferença entre `Collections.sort()` e `List.sort()`?
2. O `sort()` do Java é estável? O que isso significa?
3. Como você lidaria com pacientes com `gravidade` ou `idade` null?

---

###  60.23. <a name='Pergunta92Usodeswitchexpressionepatternmatching'></a>Pergunta 92 — Uso de switch expression e pattern matching

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Em um sistema de processamento de pagamentos, você recebe um objeto que pode ser do tipo `PagamentoCartao`, `PagamentoPix`, ou `PagamentoBoleto` (todos herdam de `Pagamento`). Para cada tipo, você precisa aplicar uma taxa diferente: 3% para cartão, 0% para PIX, e 2% para boleto. Como você implementaria essa lógica?

**O que essa pergunta avalia:**  
Conhecimento sobre polimorfismo vs condicionais, uso de `instanceof`, pattern matching (Java 16+), switch expression (Java 14+), e capacidade de escolher entre herança/polimorfismo vs switch.

**Resposta esperada:**  
Existem duas abordagens principais:

1. **Polimorfismo (recomendado na maioria dos casos):** Adicionar um método `calcularTaxa()` em cada subclasse. Cada tipo implementa sua própria taxa. Isso respeita o princípio Open/Closed — adicionar um novo tipo de pagamento não exige mudar código existente.

2. **Switch expression com pattern matching (Java 21+):** Se não for possível adicionar métodos nas classes (ex: classes de domínio de biblioteca externa), usar switch com pattern matching é mais limpo que uma cadeia de if-instanceof.

A escolha depende do contexto. Se os tipos de pagamento são controlados pelo projeto e podem ter comportamento específico, polimorfismo é melhor. Se a lógica de taxa é externa às classes (ex: é uma regra de negócio que muda frequentemente), um switch ou strategy pode ser mais apropriado.

**Explicação didática:**  
Polimorfismo é como pedir para cada funcionário "calcule sua própria taxa" — cada um sabe a sua, e o gerente não precisa saber os detalhes de cada tipo.

Switch é como o gerente ter uma tabela: "se for cartão, 3%; se for PIX, 0%; se for boleto, 2%". Funciona, mas toda vez que um novo tipo de pagamento é adicionado, o gerente precisa atualizar a tabela.

**Exemplo prático:**  

```java
// Abordagem 1: Polimorfismo (preferível quando possível)
public abstract class Pagamento {
    public abstract double calcularTaxa();
}

public class PagamentoCartao extends Pagamento {
    @Override
    public double calcularTaxa() { return 0.03; } // 3%
}

public class PagamentoPix extends Pagamento {
    @Override
    public double calcularTaxa() { return 0.0; } // 0%
}

public class PagamentoBoleto extends Pagamento {
    @Override
    public double calcularTaxa() { return 0.02; } // 2%
}

// Uso: não precisa saber o tipo específico
public double processarPagamento(Pagamento pagamento, double valor) {
    return valor + (valor * pagamento.calcularTaxa());
}

// Abordagem 2: Switch expression (Java 21+ com pattern matching)
public double calcularTaxa(Pagamento pagamento) {
    return switch (pagamento) {
        case PagamentoCartao c -> 0.03;
        case PagamentoPix p -> 0.0;
        case PagamentoBoleto b -> 0.02;
        default -> throw new IllegalArgumentException("Tipo desconhecido");
    };
}

// Abordagem 3: Java 8+ (sem pattern matching) — if-instanceof
public double calcularTaxaJava8(Pagamento pagamento) {
    if (pagamento instanceof PagamentoCartao) {
        return 0.03;
    } else if (pagamento instanceof PagamentoPix) {
        return 0.0;
    } else if (pagamento instanceof PagamentoBoleto) {
        return 0.02;
    }
    throw new IllegalArgumentException("Tipo desconhecido");
}
```

**Como o candidato deve responder:**  
- Mencionar polimorfismo como abordagem preferível (princípio Open/Closed)
- Explicar que switch/if-instanceof exige modificação ao adicionar novos tipos
- Mostrar switch expression se souber (Java 14+/21+)
- Discutir o trade-off entre as abordagens
- Mencionar padrão Strategy como alternativa
- Evitar usar apenas if-else sem mencionar alternativas

**Resposta fraca ou incompleta:**  
"Usaria if-instanceof para cada tipo." — Funciona, mas é a abordagem menos recomendada. Não menciona polimorfismo nem switch expression.

**Critérios de avaliação:**  
- 0 — Não sabe resolver o problema
- 1 — Usa if-instanceof, mas não conhece alternativas
- 2 — Menciona polimorfismo, mas não explica o trade-off
- 3 — Propõe polimorfismo e explica vantagens; menciona switch como alternativa
- 4 — Demonstra domínio prático, menciona Strategy, Open/Closed, pattern matching
- 5 — Responde com profundidade, discute sealed classes (Java 17+), pattern matching exaustivo, e quando cada abordagem é melhor

**Perguntas de aprofundamento:**  
1. O que é o princípio **Open/Closed** e como o polimorfismo o respeita?
2. O que são **sealed classes** (Java 17+) e como elas se relacionam com pattern matching?
3. Quando o padrão **Strategy** seria melhor que polimorfismo puro?

---

###  60.24. <a name='Pergunta93Entendendoimutabilidadedeobjetos'></a>Pergunta 93 — Entendendo imutabilidade de objetos

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Em um sistema de transferência bancária, você precisa representar uma `Transferencia` que contém: conta de origem, conta de destino, valor, e data/hora. O time decidiu que, uma vez criada, uma transferência não deve ser alterada. Como você implementaria essa classe de forma imutável? Quais cuidados especiais você teria?

**O que essa pergunta avalia:**  
Compreensão de imutabilidade em Java, boas práticas para criar classes imutáveis, e cuidados com tipos mutáveis aninhados (como coleções e `Date`).

**Resposta esperada:**  
Para criar uma classe imutável: (1) tornar a classe `final` (ou usar `records` no Java 14+) para impedir herança que poderia quebrar a imutabilidade, (2) tornar todos os atributos `private final`, (3) não fornecer setters, (4) inicializar todos os atributos no construtor, (5) se houver atributos mutáveis (como `List` ou arrays), fazer cópia defensiva no construtor e nos getters, (6) não expor referências internas mutáveis.

**Explicação didática:**  
Pense em uma transferência bancária como um recibo impresso em papel: uma vez impresso, você não pode alterar o valor, a data, ou as contas. Se precisar "alterar", você emite um novo recibo (cria um novo objeto).

Imutabilidade traz benefícios: segurança em ambientes concorrentes (threads não podem modificar o objeto uma da outra), previsibilidade (o estado nunca muda após a criação), e facilidade de debug (o estado é fixo).

**Exemplo prático:**  

```java
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Classe imutável (abordagem clássica)
public final class Transferencia {
    private final String contaOrigem;
    private final String contaDestino;
    private final double valor;
    private final LocalDateTime dataHora;
    private final List<String> comprovantes; // Lista mutável!

    public Transferencia(String origem, String destino, double valor,
                         LocalDateTime dataHora, List<String> comprovantes) {
        this.contaOrigem = origem;
        this.contaDestino = destino;
        this.valor = valor;
        this.dataHora = dataHora; // LocalDateTime é imutável, sem cópia necessária
        // Cópia defensiva: não guarda a referência externa
        this.comprovantes = new ArrayList<>(comprovantes);
    }

    // Sem setters!
    public String getContaOrigem() { return contaOrigem; }
    public String getContaDestino() { return contaDestino; }
    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }

    // Getter retorna cópia imutável, não a lista interna
    public List<String> getComprovantes() {
        return Collections.unmodifiableList(comprovantes);
    }
}

// Alternativa: Record (Java 14+ — imutável por padrão)
public record TransferenciaRecord(
    String contaOrigem,
    String contaDestino,
    double valor,
    LocalDateTime dataHora,
    List<String> comprovantes
) {
    // Record é imutável por natureza, mas o List precisa de cuidado
    public TransferenciaRecord {
        // Compact constructor: cópia defensiva
        comprovantes = List.copyOf(comprovantes); // Lista imutável
    }
}
```

**Como o candidato deve responder:**  
- Listar os princípios da imutabilidade: final class, final fields, sem setters
- Mencionar cópia defensiva para tipos mutáveis (List, array, Date)
- Explicar que `LocalDateTime` é imutável por padrão (não precisa cópia)
- Mencionar `records` como alternativa moderna (Java 14+)
- Discutir os benefícios: thread-safety, previsibilidade, cache
- Evitar esquecer a cópia defensiva em coleções

**Resposta fraca ou incompleta:**  
"Tornar tudo private e não criar setters." — Incompleto. Não menciona `final` nos atributos e na classe, nem cópia defensiva para coleções mutáveis.

**Critérios de avaliação:**  
- 0 — Não sabe o que é imutabilidade
- 1 — Sabe o conceito, mas não implementa corretamente
- 2 — Implementa o básico (final, sem setters), mas esquece cópia defensiva
- 3 — Implementa corretamente, incluindo cópia defensiva
- 4 — Demonstra domínio prático, menciona records, thread-safety, benefícios
- 5 — Responde com profundidade, discute trade-offs de performance, String immutability, e quando NÃO usar imutabilidade

**Perguntas de aprofundamento:**  
1. Por que `String` é imutável em Java? Quais são os benefícios?
2. Se a classe tivesse um atributo `Date` (mutável), qual cuidado você teria?
3. Quando a imutabilidade pode ser uma desvantagem?

---

###  60.25. <a name='Pergunta94UsodeMapparaagrupamentoecontagem'></a>Pergunta 94 — Uso de Map para agrupamento e contagem

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Em um sistema de análise de vendas, você tem uma `List<Venda>` onde cada `Venda` tem um atributo `categoria` (String). Você precisa gerar um relatório que mostre **quantas vendas** ocorreram em cada categoria. Como você implementaria isso em Java 8+?

**O que essa pergunta avalia:**  
Conhecimento de Streams API, uso de `Collectors.groupingBy()` e `Collectors.counting()`, e capacidade de transformar dados em resumos agregados.

**Resposta esperada:**  
A solução mais elegante em Java 8+ é usar a Streams API com `Collectors.groupingBy()` combinado com `Collectors.counting()`, que retorna um `Map<String, Long>` onde a chave é a categoria e o valor é o número de vendas. Também é possível fazer manualmente com um `HashMap` e `merge()` ou `getOrDefault()`.

**Explicação didática:**  
Imagine que você tem uma pilha de recibos de vendas misturados e precisa contar quantas vendas houve em cada categoria. Sem Streams, você pegaria um recibo de cada vez, olharia a categoria, e marcaria em uma planilha (Map) incrementando o contador.

Com Streams, você diz ao Java: "agrupe esses recibos por categoria e conte quantos há em cada grupo". O `groupingBy` é a "agrupação" e o `counting()` é a "contagem".

**Exemplo prático:**  

```java
import java.util.*;
import java.util.stream.*;

public class AnalisadorVendas {

    // Solução 1: Streams API (Java 8+) — mais limpa
    public Map<String, Long> contarVendasPorCategoria(List<Venda> vendas) {
        return vendas.stream()
            .collect(Collectors.groupingBy(
                Venda::getCategoria,   // Agrupar por categoria
                Collectors.counting()  // Contar elementos em cada grupo
            ));
        // Retorna: {"Eletrônicos": 15, "Roupas": 8, "Alimentos": 22}
    }

    // Solução 2: Map manual com getOrDefault
    public Map<String, Long> contarManual(List<Venda> vendas) {
        Map<String, Long> contador = new HashMap<>();
        for (Venda v : vendas) {
            String cat = v.getCategoria();
            contador.put(cat, contador.getOrDefault(cat, 0L) + 1);
        }
        return contador;
    }

    // Solução 3: Map.merge() (alternativa concisa)
    public Map<String, Long> contarComMerge(List<Venda> vendas) {
        Map<String, Long> contador = new HashMap<>();
        for (Venda v : vendas) {
            contador.merge(v.getCategoria(), 1L, Long::sum);
        }
        return contador;
    }
}

class Venda {
    private String categoria;
    public String getCategoria() { return categoria; }
}
```

**Como o candidato deve responder:**  
- Propor a solução com Streams: `groupingBy` + `counting()`
- Explicar que o resultado é um `Map<String, Long>`
- Mencionar alternativa manual com `getOrDefault` ou `merge`
- Explicar o funcionamento de `groupingBy` como classificador
- Considerar o que fazer com vendas sem categoria (null no mapa)
- Evitar implementar com loops aninhados O(n²)

**Resposta fraca ou incompleta:**  
"Faria um for e um if para cada categoria." — Solução ingênua que exige saber as categorias previamente e não escala bem.

**Critérios de avaliação:**  
- 0 — Não sabe usar Map ou Streams para agrupamento
- 1 — Usa Map mas com lógica incorreta ou ineficiente
- 2 — Implementa manualmente com Map e getOrDefault
- 3 — Usa Streams com groupingBy e counting corretamente
- 4 — Demonstra domínio prático, menciona merge, alternativas, tratamento de null
- 5 — Responde com profundidade, discute downstream collectors, TreeMap para ordenação, parallel streams

**Perguntas de aprofundamento:**  
1. Como você faria para que o resultado estivesse ordenado por categoria (alfabética)?
2. Se em vez de contar você quisesse somar o valor das vendas por categoria, qual collector usaria?
3. O que acontece se `getCategoria()` retornar `null`?

---

###  60.26. <a name='Pergunta95Entendendooconceitodethisesuper'></a>Pergunta 95 — Entendendo o conceito de this e super

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em uma classe `Veiculo` com um construtor que recebe `String marca`, e uma subclasse `Carro` que também tem um construtor com `String marca` e `int portas`. Um desenvolvedor escreveu:

```java
public Carro(String marca, int portas) {
    this.portas = portas;
    super(marca); //Erro de compilação
}
```

Explique o erro e como corrigir.

**O que essa pergunta avalia:**  
Compreensão do uso de `this` e `super` em construtores, a regra de que `super()` deve ser a primeira instrução, e o encadeamento de construtores.

**Resposta esperada:**  
O erro ocorre porque a chamada `super(marca)` deve ser a **primeira instrução** do construtor da subclasse. O Java exige que o construtor da superclasse seja executado antes de qualquer outra instrução no construtor da subclasse. Ao colocar `this.portas = portas;` antes de `super(marca)`, o compilador reclama. A correção é inverter a ordem: chamar `super(marca)` primeiro, depois inicializar `this.portas`.

**Explicação didática:**  
Pense que construir um objeto é como montar um carro em uma fábrica. A superclasse `Veiculo` é a "linha de montagem base" — ela instala o motor, as rodas, a marca. A subclasse `Carro` é a "linha de acabamento" — ela adiciona as portas.

O Java exige que a linha de montagem base (superclasse) seja concluída **antes** de qualquer trabalho na linha de acabamento (subclasse). Faz sentido: não dá para instalar portas se o chassi ainda não existe!

A palavra-chave `super` é como dizer "primeiro, construa a parte do Veiculo". A palavra-chave `this` refere-se ao próprio objeto que está sendo construído.

**Exemplo prático:**  

```java
public class Veiculo {
    private String marca;

    public Veiculo(String marca) {
        this.marca = marca;
    }
}

public class Carro extends Veiculo {
    private int portas;

    // Correto: super() deve ser a primeira instrução
    public Carro(String marca, int portas) {
        super(marca);       // Primeiro: inicializa a parte de Veiculo
        this.portas = portas; // Depois: inicializa a parte de Carro
    }

    // Também é possível ter construtores encadeados com this()
    public Carro(String marca) {
        this(marca, 4); // Chama o construtor acima com portas padrão = 4
    }
}

// Regras importantes:
// 1. super() ou this() deve ser a primeira instrução do construtor
// 2. Não pode ter super() E this() no mesmo construtor
// 3. Se nenhum super() for chamado explicitamente, o Java insere super() sem argumentos
// 4. Se a superclasse não tem construtor sem argumentos, é obrigatório chamar super(args)
```

**Como o candidato deve responder:**  
- Explicar que `super()` deve ser a primeira instrução do construtor
- Propor a correção movendo `super(marca)` para antes de `this.portas = portas`
- Mencionar que se `super()` não for chamado, o Java insere `super()` implícito
- Explicar que `this` refere-se ao objeto atual e `super` à superclasse
- Mencionar que `this()` e `super()` não podem coexistir no mesmo construtor
- Evitar confundir `super()` (chamada de construtor) com `super.atributo` (acesso a membro)

**Resposta fraca ou incompleta:**  
"É porque o super tem que vir antes." — Correto, mas não explica o porquê, nem menciona as regras de encadeamento de construtores.

**Critérios de avaliação:**  
- 0 — Não sabe o que this e super fazem
- 1 — Sabe que super chama o construtor pai, mas não explica a regra de ordem
- 2 — Explica a regra de ordem, mas não menciona this() nem super() implícito
- 3 — Explica corretamente a regra, a correção, e menciona regras de encadeamento
- 4 — Demonstra domínio prático, menciona this(), super() implícito, regras combinatórias
- 5 — Responde com profundidade, discute inicialização de campos, ordem de inicialização static/instance, e impacto de herança multi-nível

**Perguntas de aprofundamento:**  
1. O que acontece se a superclasse não tiver um construtor sem argumentos e você não chamar `super(args)` explicitamente?
2. Pode haver `this()` e `super()` no mesmo construtor? Por quê?
3. Qual é a ordem de inicialização quando há blocos `static`, blocos de instância, e construtores?

---

###  60.27. <a name='Pergunta96EntendendoExceptionsemherana'></a>Pergunta 96 — Entendendo Exceptions em herança

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Considere o código:

```java
class Pai {
    public void trabalhar() throws IOException { ... }
}

class Filho extends Pai {
    @Override
    public void trabalhar() throws SQLException { ... }
}
```

Isso compila? Por quê? Explique as regras de exceções ao sobrescrever métodos.

**O que essa pergunta avalia:**  
Conhecimento sobre regras de exceções em sobrescrita de métodos, hierarquia de exceções checked, e o princípio de substituição de Liskov aplicado a exceções.

**Resposta esperada:**  
Isso **não compila**. Ao sobrescrever um método, a subclasse **não pode** declarar exceções checked que sejam mais amplas ou não relacionadas às da superclasse. `SQLException` não é subclasse de `IOException` — são exceções checked irmãs (ambas estendem `Exception`). A regra é: o método sobrescrito pode lançar a mesma exceção, uma subclasse dela, ou nenhuma exceção checked. Não pode lançar exceções checked novas ou mais amplas. Exceções unchecked (RuntimeException) não têm essa restrição.

**Explicação didática:**  
Imagine que o contrato da classe `Pai` diz: "ao trabalhar, posso ter problemas de IO (arquivo)". Se a classe `Filho` diz "ao trabalhar, posso ter problemas de banco de dados (SQLException)", ela está quebrando o contrato — quem usa a classe `Pai` está preparado para tratar `IOException`, mas não `SQLException`.

A regra segue o **Princípio de Substituição de Liskov**: um objeto `Filho` deve poder ser usado onde se espera um `Pai`, sem surpresas. Se `Filho` lança uma exceção que `Pai` não lança, o código que usa `Pai` não estaria preparado.

**Exemplo prático:**  

```java
class Pai {
    public void trabalhar() throws IOException { ... }
}

// CORRETO: mesma exceção
class Filho1 extends Pai {
    @Override
    public void trabalhar() throws IOException { ... }
}

// CORRETO: subclasse da exceção (mais específica)
class Filho2 extends Pai {
    @Override
    public void trabalhar() throws FileNotFoundException { ... } // Estende IOException
}

// CORRETO: nenhuma exceção
class Filho3 extends Pai {
    @Override
    public void trabalhar() { ... } // Não lança checked exception
}

// ERRADO: exceção não relacionada (não compila)
class Filho4 extends Pai {
    @Override
    public void trabalhar() throws SQLException { ... } // Não é subclasse de IOException
}

// CORRETO: unchecked exception sempre é permitida
class Filho5 extends Pai {
    @Override
    public void trabalhar() throws RuntimeException { ... } // Unchecked: OK
}
```

**Como o candidato deve responder:**  
- Identificar que não compila
- Explicar que `SQLException` não é subclasse de `IOException`
- Mencionar a regra: pode lançar mesma exceção, subclasse, ou nenhuma
- Explicar que exceções unchecked não têm restrição
- Mencionar o Princípio de Substituição de Liskov
- Evitar confundir com sobrecarga (overload) que não tem essa restrição

**Resposta fraca ou incompleta:**  
"Não compila porque as exceções são diferentes." — Correto, mas não explica a regra nem por que a restrição existe.

**Critérios de avaliação:**  
- 0 — Não sabe se compila ou não
- 1 — Sabe que não compila, mas não explica a regra
- 2 — Explica a regra, mas não menciona unchecked nem LSP
- 3 — Explica corretamente as regras, checked vs unchecked, e LSP
- 4 — Demonstra domínio prático, mostra exemplos de válido e inválido, menciona interfaces
- 5 — Responde com profundidade, discute impacto em design de APIs, contratos, e programação defensiva

**Perguntas de aprofundamento:**  
1. E se `trabalhar()` na superclasse não declarasse nenhuma exceção? A subclasse poderia declarar checked exceptions?
2. A mesma regra se aplica a métodos de interface? Um método que implementa uma interface pode declarar exceções?
3. Por que exceções unchecked (RuntimeException) não têm essa restrição?

---

###  60.28. <a name='Pergunta97Usodeenumemvezdeconstantes'></a>Pergunta 97 — Uso de enum em vez de constantes

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
Em um sistema de pedidos, o status de um pedido pode ser: PENDENTE, PROCESSANDO, ENVIADO, ENTREGUE, CANCELADO. Um desenvolvedor usou constantes `int` (1, 2, 3, 4, 5) para representar os status. Quais os problemas dessa abordagem e como você melhoraria usando `enum`?

**O que essa pergunta avalia:**  
Compreensão dos benefícios de `enum` sobre constantes inteiras ou Strings, conhecimento de recursos de enums em Java (construtores, métodos, values()), e capacidade de modelar estados de domínio.

**Resposta esperada:**  
Usar constantes `int` traz vários problemas: (1) não há verificação de tipo — qualquer int pode ser passado como status, (2) não há documentação dos valores válidos, (3) ao imprimir, mostra-se o número, não o nome do status, (4) não é possível adicionar comportamento ou metadados a cada status. Usar `enum` resolve todos esses problemas: é type-safe (só aceita valores válidos), tem método `toString()` legível, pode iterar com `values()`, e pode ter construtores, métodos, e campos adicionais. Em Java, enums são classes completas que podem implementar interfaces, ter métodos, e até definir métodos abstratos implementados por cada constante.

**Explicação didática:**  
Com constantes `int`, é como ter um formulário onde você escreve o número do status a mão. Qualquer número pode ser escrito (1, 2, 99, -5, 42...), e ninguém impede erros.

Com `enum`, é como ter um menu de opções com botões: você só pode escolher uma das opções listadas. Não dá para inventar um status que não existe.

**Exemplo prático:**  

```java
// Abordagem problemática com constantes int
public class PedidoRuim {
    public static final int PENDENTE = 1;
    public static final int PROCESSANDO = 2;
    public static final int ENVIADO = 3;
    public static final int ENTREGUE = 4;
    public static final int CANCELADO = 5;

    private int status;

    public void setStatus(int status) {
        // Problema: qualquer int é aceito!
        this.status = status; // status = 99 seria aceito
    }

    public void imprimirStatus() {
        System.out.println("Status: " + status); // Imprime "Status: 3" — sem significado
    }
}

// Abordagem correta com enum
public enum StatusPedido {
    PENDENTE("Aguardando processamento"),
    PROCESSANDO("Em preparação"),
    ENVIADO("A caminho"),
    ENTREGUE("Entregue ao destinatário"),
    CANCELADO("Pedido cancelado");

    private final String descricao;

    // Construtor do enum (private por padrão)
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método utilitário: pode avançar para o próximo status
    public StatusPedido proximo() {
        StatusPedido[] ordem = values();
        int idx = this.ordinal();
        if (this == CANCELADO || this == ENTREGUE) {
            return this; // Estados finais não avançam
        }
        return ordem[idx + 1];
    }
}

// Uso:
public class Pedido {
    private StatusPedido status = StatusPedido.PENDENTE;

    public void setStatus(StatusPedido status) {
        this.status = status; // Type-safe: só aceita valores válidos
    }

    public void imprimirStatus() {
        System.out.println("Status: " + status.getDescricao());
        // Imprime "Status: Aguardando processamento"
    }
}

// Iterar sobre todos os status possíveis:
for (StatusPedido s : StatusPedido.values()) {
    System.out.println(s + " - " + s.getDescricao());
}
```

**Como o candidato deve responder:**  
- Listar problemas de constantes int: sem type safety, sem legibilidade, sem comportamento
- Explicar que enum é type-safe e legível
- Mostrar que enums em Java são classes poderosas (construtores, métodos)
- Demonstrar uso de `values()` e `ordinal()`
- Mencionar que `switch` com enum é mais seguro (compilador pode avisar casos faltantes)
- Evitar usar Strings para representar status (mesmos problemas de constantes)

**Resposta fraca ou incompleta:**  
"Enum é mais organizado." — Muito vago. Não explica os problemas de constantes int nem os recursos de enum.

**Critérios de avaliação:**  
- 0 — Não sabe o que é enum
- 1 — Sabe que enum existe, mas não explica as vantagens
- 2 — Explica type safety, mas não mostra recursos avançados de enum
- 3 — Explica vantagens, mostra enum com construtor e métodos
- 4 — Demonstra domínio prático, menciona values(), switch, EnumSet, EnumMap
- 5 — Responde com profundidade, discute enum como singleton, Serializable, e design de máquinas de estado

**Perguntas de aprofundamento:**  
1. Como funciona `EnumSet` e `EnumMap`? Por que são mais eficientes que HashSet/HashMap para enums?
2. Um enum pode implementar uma interface? Pode ter método abstrato?
3. O que acontece se você usar `switch` com um enum e não cobrir todos os casos?

---

###  60.29. <a name='Pergunta98Entendendopassagemporvalorvsreferncia'></a>Pergunta 98 — Entendendo passagem por valor vs referência

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Considere o código:

```java
public void processar(Cliente c) {
    c.setNome("Novo Nome"); // Altera o objeto original?
    c = new Cliente("Outro"); // Altera a referência original?
}
```

Se você chamar `processar(cliente)`, o objeto `cliente` original terá o nome "Novo Nome"? E a referência `cliente` passará a apontar para o novo objeto? Explique.

**O que essa pergunta avalia:**  
Compreensão de que Java é sempre **pass-by-value** (passagem por valor), inclusive para referências a objetos, e como isso afeta a mutação de objetos vs reatribuição de referências.

**Resposta esperada:**  
Java é **sempre pass-by-value**. Quando você passa um objeto, o que é copiado é a **referência** (o endereço de memória), não o objeto em si. Isso significa:

1. `c.setNome("Novo Nome")` — **Sim, altera o objeto original**. Como `c` é uma cópia da referência que aponta para o mesmo objeto na memória, modificar o objeto através dessa referência afeta o objeto original.

2. `c = new Cliente("Outro")` — **Não, não afeta a referência original**. A variável `c` (parâmetro) passa a apontar para um novo objeto, mas isso não altera a variável `cliente` no chamador, porque `c` é apenas uma cópia da referência original.

**Explicação didática:**  
Imagine que você dá a alguém uma cópia da chave (referência) da sua casa. A pessoa pode entrar na sua casa e rearrumar os móveis (`setNome`) — você verá as mudanças porque é a mesma casa (objeto).

Mas se a pessoa construir uma casa nova e mudar para lá (`c = new Cliente`), a chave que você tem ainda abre a casa antiga. A pessoa tinha uma cópia da chave — ela não pode trocar a sua chave original.

**Exemplo prático:**  

```java
public class Cliente {
    private String nome;
    public Cliente(String nome) { this.nome = nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
}

public class Exemplo {
    public void processar(Cliente c) {
        c.setNome("Novo Nome");  // Modifica o objeto compartilhado
        c = new Cliente("Outro"); // Só afeta a variável local 'c'
    }

    public void testar() {
        Cliente cliente = new Cliente("Original");
        System.out.println(cliente.getNome()); // "Original"

        processar(cliente);

        System.out.println(cliente.getNome()); // "Novo Nome" — objeto modificado
        // cliente NÃO aponta para o novo objeto criado dentro de processar()
    }
}

// Com tipos primitivos: sempre é pass-by-value (cópia do valor)
public void dobrar(int x) {
    x = x * 2; // Não afeta a variável original
}
int n = 5;
dobrar(n);
System.out.println(n); // Ainda é 5
```

**Como o candidato deve responder:**  
- Deixar claro que Java é sempre pass-by-value
- Explicar que para objetos, o valor copiado é a referência
- Diferenciar mutação (altera objeto original) de reatribuição (não altera referência original)
- Explicar que tipos primitivos são copiados por valor diretamente
- Mencionar que Strings são imutáveis, então parecem "pass-by-value" mesmo sendo objetos
- Evitar dizer que Java é "pass-by-reference" (errado)

**Resposta fraca ou incompleta:**  
"Java passa objetos por referência." — Incorreto. Java é sempre pass-by-value. Para objetos, o valor da referência é copiado, mas isso não é o mesmo que pass-by-reference.

**Critérios de avaliação:**  
- 0 — Não sabe a diferença entre pass-by-value e pass-by-reference
- 1 — Sabe que objetos podem ser modificados, mas não explica o mecanismo
- 2 — Explica que a referência é copiada, mas confunde alguns pontos
- 3 — Explica corretamente pass-by-value, mutação vs reatribuição
- 4 — Demonstra domínio prático, diferencia primitivos de objetos, menciona Strings
- 5 — Responde com profundidade, discute imutabilidade como proteção, defensive copies, e impacto em design de API

**Perguntas de aprofundamento:**  
1. Por que Strings parecem ser "pass-by-value" mesmo sendo objetos?
2. Como você protegeria um objeto contra mutação ao passá-lo como parâmetro?
3. O que seria verdadeira "pass-by-reference"? Java tem isso?

---

###  60.30. <a name='Pergunta99Entendendofianlemvariveisparmetroseclasses'></a>Pergunta 99 — Entendendo fianl em variáveis, parâmetros e classes

**Nível:** Júnior  
**Categoria:** Fundamentos

**Pergunta do entrevistador:**  
Em Java, a palavra-chave `final` pode ser aplicada em variáveis locais, parâmetros de método, atributos de classe, métodos, e classes. Explique o que `final` significa em cada um desses contextos e dê um exemplo prático de quando usar em cada caso.

**O que essa pergunta avalia:**  
Conhecimento abrangente do modificador `final` em diferentes contextos, e capacidade de justificar seu uso com boas práticas.

**Resposta esperada:**  
- **Variável local `final`:** Não pode ser reatribuída após inicialização. Útil para garantir que um valor não mude acidentalmente.
- **Parâmetro `final`:** Não pode ser reatribuído dentro do método. Ajuda a evitar bugs de reatribuição acidental de parâmetros.
- **Atributo `final`:** Deve ser inicializado uma única vez (no construtor ou na declaração). É essencial para imutabilidade e thread-safety.
- **Método `final`:** Não pode ser sobrescrito por subclasses. Útil para preservar comportamento crítico.
- **Classe `final`:** Não pode ser estendida. Útil para garantir que a implementação não seja alterada (ex: `String`, `Integer`).

**Explicação didática:**  
`final` significa "isso não muda depois de definido". Mas "não muda" significa coisas diferentes dependendo do contexto:

- Em uma **variável**: o valor não pode ser trocado (como uma caixa selada).
- Em um **atributo**: o campo é constante após a construção do objeto (como gravar na pedra).
- Em um **método**: o comportamento não pode ser alterado por subclasses (como uma regra da casa que não pode ser mudada).
- Em uma **classe**: ninguém pode criar subclasses (como um produto selado que não pode ser modificado).

**Exemplo prático:**  

```java
// Classe final: não pode ser estendida
public final class ConfiguracaoSistema {
    // Atributo final: inicializado uma vez, nunca muda
    private final String ambiente;
    private final int timeoutSegundos;

    public ConfiguracaoSistema(String ambiente, int timeoutSegundos) {
        this.ambiente = ambiente;
        this.timeoutSegundos = timeoutSegundos;
    }

    // Método final: subclasses não poderiam sobrescrever (se a classe fosse extensível)
    public final String getAmbiente() {
        return ambiente;
    }

    // Parâmetro final: não pode ser reatribuído dentro do método
    public String gerarEndpoint(final String baseUrl) {
        // baseUrl = "http://outro"; // Erro de compilação!
        
        // Variável local final: valor fixo após atribuição
        final String separador = "/";
        return baseUrl + separador + "api" + separador + "v1";
    }
}

// Exemplo de método final em classe extensível
public class BaseService {
    // Método final: garante que a validação sempre execute
    public final void executarComValidacao(String input) {
        validar(input);
        executar(input);
    }

    protected void validar(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input inválido");
        }
    }

    // Método NÃO final: pode ser sobrescrito
    protected void executar(String input) {
        // Implementação padrão
    }
}
```

**Como o candidato deve responder:**  
- Explicar `final` em todos os cinco contextos
- Justificar quando usar cada um com exemplos práticos
- Mencionar que `final` em atributos é essencial para imutabilidade
- Explicar que `final` em classes previne herança indesejada
- Mencionar que `final` em parâmetros é opcional mas ajuda a evitar bugs
- Evitar dizer que `final` torna objetos imutáveis (só impede reatribuição, não mutação interna)

**Resposta fraca ou incompleta:**  
"Final significa constante." — Muito simplificado. `final` em uma variável local significa constante, mas em métodos e classes tem significados completamente diferentes. Não distingue os contextos.

**Critérios de avaliação:**  
- 0 — Não sabe o que final faz
- 1 — Sabe que impede mudança, mas não diferencia contextos
- 2 — Explica variáveis e atributos, mas não métodos e classes
- 3 — Explica todos os cinco contextos corretamente
- 4 — Demonstra domínio prático, menciona imutabilidade, thread-safety, boas práticas
- 5 — Responde com profundidade, discute effectively final (lambdas), blank final, e impacto de JIT

**Perguntas de aprofundamento:**  
1. O que é "effectively final" e por que é necessário para variáveis usadas em lambdas?
2. Um atributo `final` com uma `List` torna a lista imutável? Por quê?
3. Por que as classes wrapper (`Integer`, `String`) são `final`?

---

###  60.31. <a name='Pergunta100Debugging:identificarerrolgicoemcdigo'></a>Pergunta 100 — Debugging: identificar erro lógico em código

**Nível:** Júnior  
**Categoria:** Troubleshooting

**Pergunta do entrevistador:**  
Um desenvolvedor implementou um método para verificar se uma lista de números está em ordem crescente:

```java
public static boolean estaCrescente(List<Integer> numeros) {
    for (int i = 0; i < numeros.size(); i++) {
        if (numeros.get(i) > numeros.get(i + 1)) {
            return false;
        }
    }
    return true;
}
```

Ao testar com a lista `[1, 2, 3, 4]`, o método lança uma exceção. Identifique o bug, explique e corrija.

**O que essa pergunta avalia:**  
Capacidade de leitura e análise de código, identificação de bugs de limite (off-by-one), e correção de código.

**Resposta esperada:**  
O bug está na condição do loop: `i < numeros.size()`. Quando `i` chega ao último índice válido (`size() - 1`), o código acessa `numeros.get(i + 1)`, que é `numeros.get(size())` — um índice fora dos limites da lista, lançando `IndexOutOfBoundsException`. A correção é mudar a condição para `i < numeros.size() - 1`, garantindo que sempre haja um próximo elemento para comparar.

**Explicação didática:**  
Imagine que você está comparando cada pessoa em uma fila com a próxima. Se você chegar à **última pessoa** e tentar comparar com "a próxima", não há ninguém — você aponta para o vazio.

O loop percorre de `i = 0` até `i = size() - 1` (último índice). Mas ao acessar `i + 1` quando `i` é o último índice, você tenta acessar um índice que não existe. A correção é parar uma posição antes: ir até `size() - 2`, comparando cada elemento com o próximo, e o último par comparado será `(size()-2, size()-1)`.

**Exemplo prático:**  

```java
// Bug: i < size() acessa i+1 = size() no último ciclo
// Para [1, 2, 3, 4] (size=4):
// i=0: 1 > 2? Não
// i=1: 2 > 3? Não
// i=2: 3 > 4? Não
// i=3: 4 > get(4) → IndexOutOfBoundsException!

// Correção 1: Ajustar o limite do loop
public static boolean estaCrescente(List<Integer> numeros) {
    if (numeros == null || numeros.size() <= 1) {
        return true; // Lista vazia ou com 1 elemento está "crescente"
    }
    for (int i = 0; i < numeros.size() - 1; i++) { // -1 evita acesso fora dos limites
        if (numeros.get(i) > numeros.get(i + 1)) {
            return false;
        }
    }
    return true;
}

// Correção 2: Usar IntStream (Java 8+)
public static boolean estaCrescenteStream(List<Integer> numeros) {
    if (numeros == null || numeros.size() <= 1) return true;
    return IntStream.range(0, numeros.size() - 1)
        .allMatch(i -> numeros.get(i) <= numeros.get(i + 1));
}

// Correção 3: Usar Iterator para comparação adjacente
public static boolean estaCrescenteIterator(List<Integer> numeros) {
    if (numeros == null || numeros.size() <= 1) return true;
    Iterator<Integer> it = numeros.iterator();
    Integer anterior = it.next();
    while (it.hasNext()) {
        Integer atual = it.next();
        if (anterior > atual) return false;
        anterior = atual;
    }
    return true;
}
```

**Como o candidato deve responder:**  
- Identificar o erro off-by-one: condição deveria ser `i < numeros.size() - 1`
- Explicar que o acesso a `i + 1` quando `i` é o último índice causa `IndexOutOfBoundsException`
- Propor a correção
- Mencionar tratamento de casos especiais (lista vazia, lista com 1 elemento)
- Considerar soluções alternativas (Streams, Iterator)
- Evitar apenas "adicionar um -1" sem explicar o raciocínio

**Resposta fraca ou incompleta:**  
"O loop vai longe demais." — Vago. Não identifica especificamente que o problema é o acesso a `i+1` no último índice, nem menciona a exceção específica.

**Critérios de avaliação:**  
- 0 — Não consegue identificar o bug
- 1 — Sabe que há algo errado no limite, mas não identifica o quê
- 2 — Identifica o off-by-one e propõe correção básica
- 3 — Explica corretamente o bug, corrige, e trata casos especiais
- 4 — Demonstra domínio prático, menciona exceção específica, soluções alternativas
- 5 — Responde com profundidade, discute testes unitários para casos limite, boas práticas de defesa

**Perguntas de aprofundamento:**  
1. Que casos de teste você escreveria para validar esse método? Liste os cenários.
2. Se a lista fosse muito grande (1 milhão de elementos), haveria preocupação de performance com `get(i)`?
3. Como você escreveria um teste unitário com JUnit para verificar o comportamento com lista vazia?

---

##  61. <a name='ResumodaEntrevista'></a>Resumo da Entrevista

| Item | Detalhe |
|------|---------|
| **Tecnologia avaliada** | Java |
| **Níveis abordados** | Júnior |
| **Quantidade total de perguntas** | 100 |
| **Tipo predominante** | Baseadas em cenários reais |

###  61.1. <a name='Distribuioporcategoria'></a>Distribuição por categoria

| Categoria | Quantidade aproximada |
|-----------|----------------------|
| Fundamentos | 35 |
| Prática | 25 |
| Troubleshooting | 15 |
| Desempenho | 5 |
| Segurança | 5 |
| Testes | 5 |
| Arquitetura | 5 |
| Boas práticas | 10 |

###  61.2. <a name='Principaiscompetnciasavaliadas'></a>Principais competências avaliadas

- Orientação a objetos (herança, polimorfismo, encapsulamento, interfaces)
- Collections Framework (List, Set, Map, Iterator, Generics)
- Tratamento de exceções (checked vs unchecked, try-with-resources)
- Manipulação de Strings e StringBuilder
- API java.time e formatação
- Gerenciamento de memória e Garbage Collector
- Streams API e expressões lambda
- Debugging e resolução de problemas comuns
- Boas práticas (imutabilidade, equals/hashCode, modificadores de acesso)
- Conceitos de concorrência básica

---

##  62. <a name='MatrizdeCompetnciasRecomendaesparaoEntrevistador'></a>Matriz de Competências## Recomendações para o Entrevistador

###  62.1. <a name='Comoconduziraentrevista'></a>Como conduzir a entrevista

- **Comece com perguntas de fundamentos** (72, 73, 86) para aquecer o candidato e estabelecer uma baseline de conhecimento. Estas perguntas são menos ameaçadoras e ajudam a reduzir a ansiedade.
- **Intercalae perguntas conceituais e práticas** — após uma pergunta teórica (ex: 76 sobre checked vs unchecked), faça uma prática (ex: 83 sobre try-with-resources) para verificar se o conhecimento se traduz em código.
- **Use as perguntas de troubleshooting** (71, 75, 81, 85, 100) para avaliar pensamento analítico. Observe como o candidato se comporta ao encontrar um bug — fica nervoso, pede ajuda, ou segue metodicamente?
- **Não faça todas as 100 perguntas** — selecione 10-15 que cubram as competências essenciais para a vaga específica.

###  62.2. <a name='Comofazerperguntasdeaprofundamento'></a>Como fazer perguntas de aprofundamento

- Use as perguntas de aprofundamento listadas **apenas quando o candidato responder rapidamente ou de forma muito superficial**.
- Se o candidato responder bem, avance para a próxima pergunta — não tente "derrubar" o candidato.
- Se o candidato travar, ofereça uma dica parcial e observe se ele consegue progredir com orientação.

###  62.3. <a name='Comodiferenciarinseguranadefaltadeconhecimento'></a>Como diferenciar insegurança de falta de conhecimento

- **Insegurança:** O candidato hesita, mas quando você pede para "pensar em voz alta", começa a articular conceitos corretos. Dê tempo e encoraje.
- **Falta de conhecimento:** O candidato tenta adivinhar ou apresenta conceitos incorretos com confiança. Diferencie erros de nervosismo de erros conceituais.

###  62.4. <a name='Comoavaliarrespostasparcialmentecorretas'></a>Como avaliar respostas parcialmente corretas

- Use a escala 0-5 de forma justa: nota 2 não é "reprovado", é "conhece parte do conceito".
- Avalie o raciocínio, não apenas a resposta final. Um candidato que erra a sintaxe mas explica corretamente o conceito merece nota 3.
- Considere a capacidade de receber dicas e corrigir o raciocínio — isso é tão importante quanto saber a resposta.

###  62.5. <a name='Comoevitarviesesnaavaliao'></a>Como evitar vieses na avaliação

- Não seja influenciado pela confiança do candidato — confiança verbal não equivale a competência técnica.
- Avalie cada pergunta independentemente — um erro em uma não deve contaminar a avaliação das demais.
- Anote exemplos específicos de respostas para justificar cada nota.

###  62.6. <a name='Comoregistrarevidnciasobjetivas'></a>Como registrar evidências objetivas

- Para cada pergunta, anote: (1) a nota, (2) um trecho da resposta, (3) se precisou de dica, (4) tempo de resposta.
- Use a matriz de competências para identificar gaps: se o candidato errou 72 (equals/hashCode), 81 (casting) e 87 (generics), há um gap em Collections e OO que deve ser documentado.

---

##  63. <a name='RecomendaesparaoCandidato'></a>Recomendações para o Candidato

###  63.1. <a name='Comoestruturaroraciocnio'></a>Como estruturar o raciocínio

- **Pense em voz alta** — o entrevistador avalia seu processo de pensamento, não apenas a resposta final. Diga o que está analisando, quais alternativas considera, e por que descarta cada uma.
- **Comece pelo óbvio e aprofunde** — primeiro dê a resposta direta, depois explique o porquê, depois mencione casos especiais e trade-offs.
- **Use exemplos** — sempre que possível, ilustre sua resposta com um exemplo de código ou situação real que você viveu.

###  63.2. <a name='Comoexplicardecisestcnicas'></a>Como explicar decisões técnicas

- Sempre justifique o **porquê** da escolha, não apenas o **o quê**. "Usaria ArrayList porque preciso de acesso por índice e a ordem de inserção importa" é melhor que "Usaria ArrayList".
- Mencione alternativas e explique por que não as escolheu: "Poderia usar LinkedList, mas como não preciso inserir no início da lista, ArrayList é mais eficiente para iteração."

###  63.3. <a name='Comoutilizarexemplosreais'></a>Como utilizar exemplos reais

- Relacione a pergunta com algo que você já fez: "No projeto X, tivemos um problema parecido de ConcurrentModificationException quando..."
- Seja específico: mencione a tecnologia, o contexto, e a solução aplicada.

###  63.4. <a name='Comoadmitirquenosabealgo'></a>Como admitir que não sabe algo

- Seja honesto: "Não conheço esse conceito em detalhe, mas pelo contexto eu imagino que..." — tentar adivinhar com confiança é pior que admitir desconhecimento.
- Mostre como pesquisaria: "Não sei a resposta exata, mas consultaria a documentação de X ou procuraria no código do projeto."

###  63.5. <a name='Comodiscutirtrade-offs'></a>Como discutir trade-offs

- Toda decisão técnica tem prós e contras. Ao escolher uma abordagem, sempre mencione o que você está sacrificando: "Usar Optional deixa o código mais expressivo, mas adiciona um nível de indireção que pode confundir desenvolvedores juniores."
- Mostre maturidade: não existe solução perfeita, existem soluções adequadas ao contexto.

###  63.6. <a name='Comoresponderperguntasprticasedearquitetura'></a>Como responder perguntas práticas e de arquitetura

- Em perguntas de código, escreva primeiro a solução simples e correta, depois otimize se houver tempo.
- Em perguntas de cenário, considere os requisitos não-funcionais (performance, manutenibilidade, segurança) além dos funcionais.
- Em perguntas de troubleshooting, siga um método: (1) identifique o sintoma, (2) isole a causa, (3) proponha a correção, (4) sugira prevenção futura.

