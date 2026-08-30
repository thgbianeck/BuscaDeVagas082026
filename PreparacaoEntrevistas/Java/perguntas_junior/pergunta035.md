# Pergunta 35 — Hierarquia de Exceções

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

