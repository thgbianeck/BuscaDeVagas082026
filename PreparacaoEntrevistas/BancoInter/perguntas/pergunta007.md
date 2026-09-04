
# Pergunta 7 — Escopos e ciclo de vida de beans

**Nível:** Júnior  
**Categoria:** Spring

**Pergunta do entrevistador:**  
O que é um bean gerenciado pelo Spring e quais cuidados você teria com seu estado interno?

**O que essa pergunta avalia:**  
Avalia se o candidato entende o ciclo de vida básico dos componentes Spring e os riscos de armazenar estado indevido.

**Resposta esperada:**  
Um bean é um objeto cuja criação, configuração e ciclo de vida são gerenciados pelo container do Spring.

O escopo padrão geralmente é singleton, o que significa que uma única instância é compartilhada dentro do contexto da aplicação.

Por isso, serviços normalmente devem ser stateless: não devem guardar dados específicos de uma requisição ou usuário em campos mutáveis.

Outros escopos existem, como:

- Prototype;
- Request;
- Session, em aplicações compatíveis com esse contexto.

A escolha do escopo deve considerar o ciclo de vida e a concorrência.

**Explicação didática:**  
Este código pode causar problemas:

~~~java
@Service
public class RelatorioService {

    private String usuarioAtual;

    public void gerar(String usuario) {
        usuarioAtual = usuario;
        // Processamento
    }
}
~~~

Se várias requisições utilizarem o mesmo singleton simultaneamente, uma requisição pode sobrescrever o estado da outra.

Os dados da requisição devem ficar em variáveis locais ou em objetos próprios daquele fluxo.

**Como o candidato deve responder:**

- Explique o que é um bean;
- Mencione o escopo singleton padrão;
- Relacione o tema à segurança entre requisições;
- Diferencie configuração compartilhada de estado transacional;
- Apresente uma alternativa stateless.

**Resposta fraca ou incompleta:**  
“Bean é qualquer classe que tenha uma anotação do Spring.”

A anotação é apenas uma forma de registro; a resposta deve abordar gerenciamento e ciclo de vida.

**Critérios de avaliação:**

- **0** — Não conhece beans.
- **1** — Confunde bean com qualquer objeto Java.
- **2** — Sabe que o Spring gerencia objetos, mas ignora escopos.
- **3** — Explica singleton e estado compartilhado.
- **4** — Relaciona o tema à concorrência e ao desenho stateless.
- **5** — Discute ciclo de vida, escopos, proxies, custo de criação e impactos em aplicações distribuídas.

**Perguntas de aprofundamento:**

1. Por que serviços Spring geralmente devem ser stateless?
2. Quando um escopo diferente de singleton poderia ser justificável?
3. Como identificaria uma condição de corrida em um bean?

