## Dadas as Linguagens Regulares sobre o alfabeto {a,b}, construa as Expressões Regulares correspondentes:

1. (a + b)aaa(a + b)

2. (a + b)*bb

3. (a + b)*bb(a + b)*aaaa

4. (a + b)aaa + bb(a + b) + ε

5. ab(a + b)*ba

# Construção de Autômatos Finitos

Este repositório contém os autômatos finitos que reconhecem as linguagens geradas pelas seguintes expressões regulares.

## Questões

### 2. Expressões Regulares e seus Autômatos

#### i. (b+ab)*
![Autômato 1](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20114151.png)

#### ii. (a+ε)(b+ba)
![Autômato 2](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20115115.png)

#### iii. (ab+ba)*(aa+bb)
![Autômato 3](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20114954.png)

#### iv. ab(abb*+baa*)*ba
![Autômato 4](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20115830.png)

#### v. (aa+b)*(a+bb)
![Autômato 5](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20120118.png)

#### vi. a*(aa+bb)
![Autômato 6](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20120447.png)

#### vii. b*ab*ab*
![Autômato 7](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20120655.png)

#### viii. (b+ab)*(ε+a)
![Autômato 8](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20120836.png)

#### ix. (aa+bb)*(ab)*
![Autômato 9](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20121057.png)

#### x. (ab+ba)*(aa+bb)*
![Autômato 10](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20121335.png)

#### xi. (0+1)* (00+01+10+11) (0+1)*
![Autômato 11](https://github.com/pedr0xh/AULAS-UFN-2025/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/imagens/Captura%20de%20tela%202025-04-04%20121749.png)



## 3. Identificação das Linguagens Denotadas pelas Expressões Regulares

### i. (aa + b)*(a + aa)  
**Denota:** Repete várias vezes "aa" e "b", e termina com "a" ou "aa".

### ii. (b + ab)*(ε + a)  
**Denota:** Repete várias vezes "b" e "ab", e termina com vazio ou "a".

### iii. (ab + ba)(b + a)* ba  
**Denota:** "ab" ou "ba" como prefixos, seguidos por zero ou mais ocorrências de "b" ou "a", terminando com "ba".

### iv. (0 + 1)* 111 (0 + 1)* 111  
**Denota:** A sequência "111" aparece como subpalavra duas vezes dentro de qualquer string binária.

### v. (0 + 1)* (10 + 01)  
**Denota:** Uma string binária que termina com "10" ou "01" como sufixo.

