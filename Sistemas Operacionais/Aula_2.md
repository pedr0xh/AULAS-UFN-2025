# Resumo: Escalonamento de CPU

## **Introdução**
- **Escalonamento** é fundamental em Sistemas Operacionais (SO) multiprogramados, otimizando o uso da CPU.
- Objetivo: Evitar ociosidade da CPU, alternando entre processos para maximizar produtividade.
- Processos alternam entre ciclos de **CPU** e **I/O**:
  - **CPU-bound**: Longos surtos de CPU.
  - **I/O-bound**: Muitos surtos curtos de CPU.

---

## **Escalonador de CPU**
- Gerencia a **fila de processos prontos** (não necessariamente FIFO).
- **Objetivos**:
  - Maximizar *throughput* (processos concluídos/tempo).
  - Minimizar tempo de espera, resposta e *turnaround* (submissão→conclusão).

---

## **Tipos de Escalonamento**
### **1. Não-Preemptivo (Cooperativo)**
- Processo mantém a CPU até liberá-la (término ou espera por I/O).
- **Vantagem**: Simplicidade (sem interrupções).
- **Desvantagem**: Risco de monopolização da CPU.

### **2. Preemptivo**
- CPU pode ser realocada via interrupções.
- **Vantagem**: Justiça e responsividade.
- **Desvantagem**: Overhead por troca de contexto.

---

## **Dispatcher (Executor)**
- Módulo que transfere o controle da CPU para o processo escalonado.
- **Ações**:
  - Troca de contexto (salva/restaura estado do processo).
  - Altera modo de execução (usuário/supervisor).

---

## **Algoritmos de Escalonamento**
### **1. FCFS/FIFO**
- Primeiro a chegar, primeiro a ser executado.
- **Problema**: Tempo de espera longo para processos I/O-bound.

### **2. Shortest Job First (SJF)**
- Executa o processo com **menor surto de CPU** primeiro.
- **Ótimo para minimizar tempo de espera médio**.
- **Desafio**: Prever a duração do próximo surto (usando média exponencial: `τₙ₊₁ = αtₙ + (1-α)τₙ`).

### **3. Escalonamento por Prioridade**
- Prioridades internas (ex.: tempo de CPU) ou externas (ex.: importância do processo).
- **Problema**: *Starvation* (processos de baixa prioridade nunca executam).
- **Solução**: *Aging* (aumentar prioridade com o tempo).

### **4. Round-Robin (RR)**
- **Quantum fixo** de tempo para cada processo (ex.: 10 ms).
- **Vantagem**: Justo e adequado para sistemas interativos.
- **Desafio**: Escolher o quantum ideal (muito curto → overhead; muito longo → FCFS).

### **5. Múltiplas Filas**
- Filas separadas por critérios (prioridade, tipo de processo).
- Ex.: Processos interativos (alta prioridade) vs. *batch* (baixa prioridade).

### **6. Múltiplas Filas com Realimentação**
- Processos mudam de fila conforme comportamento (ex.: surtos longos → fila de menor prioridade).
- Combina **RR** com prioridades dinâmicas e *aging*.

---

## **Critérios de Avaliação**
- **Maximizar**: Utilização da CPU e *throughput*.
- **Minimizar**: Tempo de resposta, espera e *turnaround*.

---

## **Exemplos Práticos**
- **FCFS**: P1 (20ms), P2 (3ms), P3 (3ms) → Tempo médio de espera: **14.33 ms**.
- **SJF**: P4 (3ms), P1 (6ms), P3 (7ms), P2 (8ms) → Tempo médio: **6.5 ms** (preemptivo).

---

## **Conclusão**
O escalonamento de CPU é crucial para balancear eficiência, justiça e responsividade. A escolha do algoritmo depende do contexto:
- **SJF** para *throughput* máximo.
- **RR** para sistemas interativos.
- **Múltiplas Filas** para ambientes heterogêneos.
