# Linguagens Formais e Hierarquia

A hierarquia de linguagens formais é organizada com base na complexidade das gramáticas que as geram e nos tipos de máquinas que podem reconhecê-las. Abaixo, temos a classificação das linguagens formais:

## 1. **Linguagens Enumeráveis Recursivamente** (Tipo 0)

- **Máquinas que reconhecem**: Máquinas de Turing.
- São linguagens que podem ser reconhecidas por uma Máquina de Turing, mas não necessariamente podem ser decididas.
- **Exemplo**: Linguagens gerais de programação.

## 2. **Linguagens Sensíveis ao Contexto** (Tipo 1)

- **Máquinas que reconhecem**: Máquinas de Turing linearmente/fita limitadas (LTMs).
- São linguagens que podem ser reconhecidas por máquinas de Turing com uma restrição adicional no espaço de memória.
- **Exemplo**: Linguagens usadas para descrever transformações em sistemas biológicos e linguagens naturais.

## 3. **Linguagens Livres de Contexto** (Tipo 2)

- **Máquinas que reconhecem**: Autômatos com pilha (PDA - Pushdown Automaton).
- **Grammáticas**: Gramaticais livres de contexto (CFG - Context-Free Grammar).
- São linguagens que podem ser reconhecidas por autômatos com pilha, sendo usadas para descrever muitas linguagens de programação e sintaxes de linguagens formais.
  
  ### Exemplos:
  - **Gramática Livre de Contexto (CFG)**: Representa as regras de sintaxe de muitas linguagens de programação.
  - **Autômato com Pilha (PDA)**: Máquina abstrata que reconhece linguagens livres de contexto.

## 4. **Linguagens Regulares** (Tipo 3)

- **Máquinas que reconhecem**: Autômatos Finitos Determinísticos (AFD), Autômatos Finitos Não Determinísticos (AFND) e Autômatos Finitos com Piles (AF&).
- **Grammáticas**: Gramaticais regulares.
  
  ### Subtipos de Autômatos Finitos:
  
  - **AFD (Autômato Finito Determinístico)**: Um tipo de autômato onde, para cada estado e símbolo de entrada, há uma única transição possível.
  - **AFND (Autômato Finito Não Determinístico)**: Um autômato onde, para um estado e símbolo de entrada, podem existir várias transições possíveis.
  - **AF& (Autômato Finito com Pilha)**: Uma variação que combina o uso de um autômato finito com uma estrutura de pilha, permitindo o reconhecimento de linguagens mais complexas.

  ### Exemplos:
  - **Expressões regulares**: Usadas para descrever padrões simples em textos, como verificar emails ou números de telefone.
  - **Autômatos Finitos**: Utilizados para validação de padrões simples, como na verificação de um número de cartão de crédito.

---
# Autômato Finito Determinístico

## Fita de Entrada

| 1 | 0 | 0 | 1 |
|---|---|---|---|
| ↓ | ↓ | ↓ | ↓ |

(Aceita!)

## Diagrama de Estados

- Estado inicial: q₀  
- Transições:
  - q₀ → q₁ (com entrada 0 ou 1)
  - q₁ → q₁ (com entrada 0 ou 1)
- Estado final: q₁ (estado de aceitação)

## Definição da Linguagem

A linguagem reconhecida pelo autômato é: L = { w ∈ {0,1}+ }
  - Ou seja, qualquer sequência de `0`s e `1`s.
