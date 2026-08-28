# Pergunta 28 — Tratamento de Exceções em Métodos Encadeados

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

