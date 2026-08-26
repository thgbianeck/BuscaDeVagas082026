# Pergunta 25 — java.time: Manipulação de Datas

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

