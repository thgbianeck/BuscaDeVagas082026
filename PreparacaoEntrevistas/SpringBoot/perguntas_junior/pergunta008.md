# Pergunta 8 — O que é e como funciona o Spring Data JPA?

**Nível:** Júnior  
**Categoria:** Prática

**Pergunta do entrevistador:**  
"Em um projeto Spring Boot, você provavelmente usa o Spring Data JPA para acessar o banco de dados. O que é o Spring Data JPA e como ele facilita o acesso a dados?"

**O que essa pergunta avalia:**  
Avalia se o candidato entende o que é o Spring Data JPA, conhece o padrão Repository, sabe como o Spring implementa os métodos automaticamente e compreende a relação entre JPA, Hibernate e Spring Data.

**Resposta esperada:**  
O **Spring Data JPA** é um módulo do Spring Data que simplifica a implementação de camadas de acesso a dados baseadas em JPA (Java Persistence API). Ele elimina a necessidade de escrever implementações boilerplate de DAOs/Repositories, gerando as implementações automaticamente em tempo de execução.

Os principais recursos são:

1. **Interfaces Repository** — você define apenas uma interface, e o Spring Data JPA gera a implementação em tempo de execução:

```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos herdados: save(), findById(), findAll(), deleteById(), etc.
}
```

2. **Métodos de consulta derivados (query methods)** — o Spring Data JPA interpreta o nome do método e gera a query SQL correspondente:

```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Gera: SELECT * FROM usuario WHERE email = ?
    Optional<Usuario> findByEmail(String email);

    // Gera: SELECT * FROM usuario WHERE nome LIKE ? AND ativo = ?
    List<Usuario> findByNomeContainingAndAtivoTrue(String nome);

    // Gera: SELECT * FROM usuario WHERE idade > ? ORDER BY nome
    List<Usuario> findByIdadeGreaterThanOrderByIdade(int idade);
}
```

3. **`@Query` para consultas customizadas** — quando o nome do método fica muito complexo, usa-se JPQL ou SQL nativo:

```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.ativo = true")
    Optional<Usuario> buscarEmailAtivo(@Param("email") String email);

    @Query(value = "SELECT * FROM usuario WHERE DATE(criado_em) = CURRENT_DATE", nativeQuery = true)
    List<Usuario> buscarCriadosHoje();
}
```

4. **Paginação e ordenação** — suporte nativo a `Pageable`:

```java
Page<Usuario> findAll(Pageable pageable);

// Uso:
Pageable pageable = PageRequest.of(0, 10, Sort.by("nome").ascending());
Page<Usuario> pagina = repository.findAll(pageable);
```

**Explicação didática:**  
O Spring Data JPA é como ter um assistente que escreve o SQL para você. Em vez de escrever "SELECT * FROM usuario WHERE email = ?", você diz ao assistente "encontre por email" (`findByEmail`), e ele entende o que você quer e gera a query. A "mágica" acontece porque o Spring analisa o nome do método, identifica padrões (findBy, By, And, Or, Containing, etc.) e constrói a consulta JPA correspondente.

A pilha de tecnologias é: **Spring Data JPA** (camada de abstração) → **JPA** (especificação) → **Hibernate** (implementação JPA) → **JDBC** (driver do banco).

**Como o candidato deve responder:**  
- Explicar que o Spring Data JPA abstrai a implementação de DAOs/Repositories.
- Mencionar que você define apenas a interface e o Spring gera a implementação.
- Citar métodos derivados (query methods) com exemplos.
- Mencionar `@Query` para consultas customizadas.
- Explicar a relação: Spring Data JPA → JPA → Hibernate.

**Resposta fraca ou incompleta:**  
"É uma biblioteca para acessar o banco de dados."  
Falta: não explica o padrão Repository, não menciona query methods, não cita a relação com JPA/Hibernate.

**Critérios de avaliação:**

| Nota | Descrição |
|------|-----------|
| 0 | Não sabe o que é |
| 1 | Sabe que "acessa o banco" mas não explica como |
| 2 | Menciona Repository mas não explica query methods |
| 3 | Explica Repository, query methods e @Query com exemplos |
| 4 | Demonstra prática com paginação, ordenação e relação com JPA |
| 5 | Responde com profundidade, menciona proxy dinâmico, entidades, @Entity e boas práticas |

**Perguntas de aprofundamento:**
1. "Como o Spring Data JPA gera a implementação da interface em tempo de execução?"
2. "Quando você usaria `nativeQuery = true` em vez de JPQL?"
3. "Como você lidaria com consultas muito complexas que não cabem em um nome de método?"

