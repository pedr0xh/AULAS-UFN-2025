# Inteligência Artificial

## Técnicas de Resolução de Problemas

### Tipos de Problemas

- **(A) Diagnóstico ou Reconhecimento de Padrões**
  - Área Médica
- **(B) Definição de Passos até o Estado Final**
  - Área de Jogos
  - Linhas de Montagem

## Sistemas de Conhecimento

- **Base de Conhecimento (Gigantesca)**
  - Fatos
  - Raciocínio Automatizado (Dedução e Indução)
- **Aprendizagem**
  - Reconhecimento de Padrões por Treino

## Áreas

- **(B) Métodos de Busca (Solução de Problemas)**
  - Profundidade, Amplitude, Subida de Encosta, Gulosa, A*
  - Algoritmos Genéticos
- **(A)(B) Representação de Conhecimento**
  - Prolog
  - Ontologia
- **(B) Sistemas Multiagentes**
- **(A) Redes Neurais**
- **(A) Processamento de Língua Natural - PLN**

## Modelar a Solução com Alguma Técnica de IA

1. **Mapear os Estados Possíveis do Problema**
   - Definir Classe e Seus Atributos
   - Definir o Estado Inicial e o(s) Estado(s) Final(is)
2. **Mapear os métodos das classes - Regras de Transição**
3. **Mapear as restrições**
4. **Forma de mapear os visitados**
     - Gerar uma string dos atributos daquele estado/objeto
5. **Definir o método meta ou objetivo**

## Observação: 
  **Toda vez que um estado/objeto é gerado é preciso fazer 3 testes**
    1. É valido ?
    2. Já visitei
    3. É a meta ?

Classes
python
Copy
class Pessoa:
    def __init__(self, nome, tempo):
        self.nome = nome
        self.tempo = tempo
        self.lado = "esquerda"  # Inicialmente, todos estão no lado esquerdo

class Ponte:
    def __init__(self):
        self.lanterna = "esquerda"  # A lanterna começa no lado esquerdo
Métodos
Pessoa.cruzar():
Move a pessoa de um lado para o outro da ponte.

Se a pessoa estiver na esquerda, vai para a direita.

Se a pessoa estiver na direita, vai para a esquerda.

Ponte.mover_lanterna():
Move a lanterna para o outro lado da ponte.

Estados
Estado Inicial:
{aluno: "esquerda", professora: "esquerda", zelador: "esquerda", cientista: "esquerda", lanterna: "esquerda"}

Estado Final:
{aluno: "direita", professora: "direita", zelador: "direita", cientista: "direita", lanterna: "direita"}

Restrições
Restrição de Tempo:
O tempo total de travessia não pode exceder 17 minutos.

Restrição de Lanterna:
Apenas duas pessoas podem atravessar por vez, e uma delas deve carregar a lanterna.

Restrição de Movimentação:
A lanterna deve ser movida de um lado para o outro a cada travessia.

Método Meta/Objetivo
Objetivo:
Todas as pessoas devem atravessar para o outro lado da ponte em no máximo 17 minutos, respeitando as restrições.

Solução
Aqui está a sequência de movimentos que resolve o problema:

Aluno e professora atravessam para a direita:

Tempo gasto: 2 minutos (tempo da professora).

Total acumulado: 2 minutos.

Estado: {aluno: "direita", professora: "direita", zelador: "esquerda", cientista: "esquerda", lanterna: "direita"}

Aluno volta com a lanterna:

Tempo gasto: 1 minuto.

Total acumulado: 3 minutos.

Estado: {aluno: "esquerda", professora: "direita", zelador: "esquerda", cientista: "esquerda", lanterna: "esquerda"}

Zelador e cientista atravessam para a direita:

Tempo gasto: 10 minutos (tempo do cientista).

Total acumulado: 13 minutos.

Estado: {aluno: "esquerda", professora: "direita", zelador: "direita", cientista: "direita", lanterna: "direita"}

Professora volta com a lanterna:

Tempo gasto: 2 minutos.

Total acumulado: 15 minutos.

Estado: {aluno: "esquerda", professora: "esquerda", zelador: "direita", cientista: "direita", lanterna: "esquerda"}

Aluno e professora atravessam para a direita novamente:

Tempo gasto: 2 minutos.

Total acumulado: 17 minutos.

Estado: {aluno: "direita", professora: "direita", zelador: "direita", cientista: "direita", lanterna: "direita"}


    
