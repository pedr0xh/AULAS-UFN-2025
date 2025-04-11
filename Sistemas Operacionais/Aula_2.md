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

## **Políticas de Escalonamento (Algoritmos)**
### **1. FIFO/FCFS (First-Come, First-Served)**
- **Não-preemptivo**: Escalona o primeiro processo que chega na fila de prontos.
- **Problema**: Tempo de espera longo para processos I/O-bound.

### **2. SJF (Shortest Job First)**
- **Não-preemptivo**: Escalona o processo com **menor ciclo de CPU** primeiro.
- **Ótimo para minimizar tempo de espera médio**.
- **Desafio**: Prever a duração do próximo surto (usando média exponencial: `τₙ₊₁ = αtₙ + (1-α)τₙ`).

### **3. Escalonamento por Prioridade**
- **PCB/descritor** armazena a prioridade do processo.
- **Tipos**:
  - **Não-preemptivo**: Processo mantém CPU até liberar, mesmo se chegar outro com prioridade mais alta.
  - **Preemptivo**: Processo com prioridade mais alta interrompe o atual.
- **Problema**: *Starvation* (solução: *aging*).

### **4. Round-Robin (RR)**
- **Preemptivo**: **Quantum fixo** de tempo para cada processo (ex.: 10 ms).
- **Vantagem**: Justo para sistemas interativos.

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
