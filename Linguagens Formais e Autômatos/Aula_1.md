# Introdução

# Introdução

## O que é um autômato?

Um **autômato** é uma máquina de estados finitos. Para ilustrar, vamos considerar o exemplo de uma lâmpada. Ela possui dois estados possíveis: **ligado** e **desligado**. Esses estados representam as condições em que a lâmpada pode se encontrar, e o autômato define como as transições entre esses estados ocorrem com base em entradas ou condições específicas.

---

# Teoria das Linguagens Formais

## 📜 Marcos Históricos

- **1936**: *Alan Turing* estabeleceu bases fundamentais para a teoria da computação.
- **Década de 1950**:
  - Desenvolvimento de teorias relacionadas a linguagens naturais, que tiveram grande influência no estudo das linguagens artificiais.
  - **Noam Chomsky** introduziu o conceito de **Gramáticas Formais**, um marco para a teoria das linguagens formais.

---

## 🎯 Principais Aplicações

- **Análise léxica e sintática**:
  - 🖥️ Tradutores de linguagens de programação.
- **Protocolos de comunicação**:
  - 📡 Modelos de sistemas de comunicação.
- **Modelos de sistemas biológicos**:
  - 🧬 Representação de processos biológicos.
- **Procura em texto**:
  - 🔍 Identificação de ocorrências de palavras, frases e padrões.
- **Desenho de hardware**:
  - 🔌 Projeto de circuitos digitais e sistemas embarcados.

---

# 🏷️ Terminologia

## 📖 Léxico
- **Definição**: Conjunto de palavras e símbolos de uma linguagem.
- **Exemplo**: Pode ser comparado a um **dicionário**, que contém todas as palavras válidas de um idioma.

## 📐 Sintaxe
- **Definição**: Refere-se à forma de escrita ou estrutura da linguagem.
- **Exemplo**: É como a **gramática** de uma língua, que define as regras para formar frases corretas.

## 🎭 Semântica
- **Definição**: Relaciona-se ao **sentido** ou **significado** das palavras e frases.
- **Exemplo**: Define o que uma frase ou expressão realmente quer dizer, além de sua estrutura.

---

## 🏗️ Formalismos usados
- **Formalismo Operacional ou Reconhecedor**: Autômato = Máquina abstrata
- **Formalismo Axiomático ou Gerador**: Gramática = regras associadas ao comportamento da linguagem
- **Formalismo Detacional**: Expressão Regular

---

## 🔠 Alfabeto, Palavras, Linguagens

### 🔡 Definição 1: Alfabeto
Σ diferente da matemática onde está relacionado ao somatório, aqui usaremos para se referir ao alfabeto:

```plaintext
Σ¹ = {a,b,c,d}
Σ² = {0,1}
```

### 🔤 Definição 2: Palavras

```plaintext
Σ*² = {ε,00,01,10,11,0,1,000,001...}  # Todas as palavras, incluindo a palavra vazia
Σ+² = {00,01,10,11,0,1,000,001...}  # Todas as palavras, exceto a palavra vazia
```

### 📏 Definição 3: Tamanho ou comprimento
Representado por `|W|`

### 🏷️ Definição 4: Prefixo, Sufixo, Subpalavra
- **Prefixo** de uma palavra é qualquer sequência inicial de símbolos da palavra.
- **Sufixo** de uma palavra é qualquer sequência final de símbolos da palavra.
- **Subpalavra** de uma palavra é qualquer sequência de símbolos contígua da palavra.

### 📝 Definição 5: Linguagem Formal
Uma linguagem formal é um conjunto de palavras sobre um alfabeto.

**Exemplos:**

```plaintext
L¹ = {W ∈ Σ+ | Σ = {0,1} e W tem sufixo 0}  # Representação por compreensão
L¹ = {0,10,000,010,110,...}  # Representação por extensão

L² = {W ∈ {0,1}* | W tem prefixo 11}
```
  
## 📌 Definição 6: Concatenação

A **concatenação** é uma operação binária que associa a cada par de palavras uma terceira palavra formada pela justaposição da primeira com a segunda.  

Essa operação satisfaz as propriedades descritas a seguir, considerando que \( v, w, t \) são palavras:

- **Associatividade**:  
  \[
  v(wt) = (vw)t
  \]

- **Elemento Neutro à Esquerda e à Direita**:  
  \[
  \Ew = w = wE
  \]

📌 **Observação**: A concatenação de duas palavras de uma determinada linguagem não necessariamente resulta em uma palavra desta mesma linguagem (não é uma operação fechada sobre a linguagem).  

---

### 🔁 Definição 7: Concatenação Sucessiva  

A concatenação sucessiva de uma palavra \( w^n \) é definida como:

**a) Se \( w \neq \varepsilon \)**  
\[
w^0 = \varepsilon
\]
\[
w^n = w^{n-1} w, \quad \text{para } n > 0
\]

**b) Se \( w = \varepsilon \)**  
\[
w^0 \text{ é indefinida.}
\]
\[
w^n = \varepsilon, \quad \text{para } n > 0
\]

  
