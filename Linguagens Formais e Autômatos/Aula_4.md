# Propriedades das Linguagens Regulares

## Propriedades das LR

> “Uma das principais características das Linguagens Regulares é o fato de serem representadas por formalismos de pouca complexidade, grande eficiência e fácil implementação. Entretanto, por ser uma classe relativamente simples, é restrita e limitada...”  
> — (MENEZES, 2000, pág. 60)

---

### Questões Importantes:
- Como determinar se uma Linguagem é Regular?
- Como verificar se uma Linguagem Regular é infinita ou finita?
- Como verificar se duas Linguagens Regulares são iguais?

---

## Como determinar se uma Linguagem é Regular?

Para mostrar que uma linguagem é regular, é suficiente representá-la usando um dos formalismos estudados:
- Autômato Finito
- Expressão Regular
- Gramática Regular

---

## Como determinar se uma Linguagem **não** é Regular?

Para mostrar que uma linguagem **não** é regular, utiliza-se o **Lema do Bombeamento**, com a seguinte ideia:

- Se uma linguagem é regular, então é aceita por um AFD (Autômato Finito Determinístico), que possui um número finito de estados;
- Se o AFD reconhece uma entrada `w` com tamanho maior que o número de estados, então há um ciclo na função programa do AFD;
- Assim, `w` pode ser dividida em 3 subpalavras `w = uvz`, tal que:
  - `|uv| ≤ n` (número de estados do AFD)
  - `|v| ≥ 1`
  - `v` é a parte da palavra reconhecida pelo ciclo.
- Portanto, para qualquer `i ≥ 0`, a palavra `u(v^i)z` também pertence à linguagem.

---

## Lema do Bombeamento para Linguagens Regulares

Se `L` é uma Linguagem Regular, então:

- Existe uma constante `n` tal que para qualquer palavra `w` de `L` onde `|w| ≥ n`,  
  `w` pode ser definida como `w = uvz` onde:
  - `|uv| ≤ n`
  - `|v| ≥ 1`
  - Para todo `i ≥ 0`, `u(v^i)z` pertence a `L`.

---

## As Linguagens são Regulares?

- `L1 = {aⁿbⁿcⁿ | n ≥ 1}`  
- `L2 = {aⁿb²ⁿ | n ≥ 0}`

---

## Linguagem Regular: Vazia, Finita ou Infinita?

Se `L` é uma Linguagem Regular aceita por um AFD `M = (Σ, Q, δ, q₀, F)` com `n` estados, então:

- `L` é **vazia** se, e somente se, `M` não aceita qualquer palavra `w` tal que `|w| < n`
- `L` é **finita** se, e somente se, `M` não aceita uma palavra `w` tal que `n ≤ |w| < 2n`
- `L` é **infinita** se, e somente se, `M` aceita uma palavra `w` tal que `n ≤ |w| < 2n`

---

## Linguagem Regular Infinita (exemplo)

**Perguntas:**
- Qual a linguagem aceita?
- Qual a menor palavra aceita cujo tamanho é maior ou igual a 3?

```plaintext
q0 --a--> q1 --a--> q2
           |
           b
