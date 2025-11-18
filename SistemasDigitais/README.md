# Distribuidor Automático de Ração
### Mini Controlador Digital – Sistemas Digitais (UFN – 2025/2)

**Integrantes:**  
- Pedro Henrique de Avila Daroda 
- Romeo Noro Guterres

**Professor:** André Flores dos Santos  
**Ferramenta:** Vivado 2015.1  
**Linguagem:** VHDL  

---

##  Objetivo do Projeto
O objetivo deste trabalho foi desenvolver um **mini controlador digital** no Vivado que simula um **distribuidor automático de ração**, usando os principais conteúdos estudados na disciplina:

- Portas lógicas e circuitos combinacionais  
- Flip-flops e contadores  
- Máquinas de Estados Finitos (FSM)  
- Implementação completa em VHDL  

O sistema criado funciona de forma **totalmente automática**, liberando ração em intervalos regulares através de:

- um **temporizador** (contador)  
- uma **FSM** que controla os estados  
- um módulo de **motor** que representa o acionamento da saída  

---

##  Funcionamento Geral do Sistema

O projeto simula um alimentador automático usado para liberar ração em horários fixos. Ele funciona assim:

1. Um **temporizador** conta um intervalo de tempo configurado.  
2. Quando o contador atinge o valor máximo, cria um pulso chamado `tick`.  
3. A FSM recebe esse pulso e muda do estado **ESPERA** para **DISPENSA**.  
4. No estado DISPENSA:
   - o motor é acionado,
   - o LED de "despensa" acende.
5. Logo em seguida, o sistema retorna ao estado **ESPERA**, e o ciclo começa novamente.

Não existe modo manual — todo o funcionamento é 100% automático.

---

##  Máquina de Estados (FSM)

A FSM possui **dois estados principais**:

###  1) ESPERA
- Indica que o sistema está aguardando o tempo passar.  
- LED de espera aceso (`led_wait = 1`).  
- O motor fica desligado.  
- Quando o `tick` do timer chega → transição para DISPENSA.

###  2) DISPENSA
- Motor é ligado (`motor_out = 1`).  
- LED de dispensação aceso (`led_dispense = 1`).  
- Dura apenas 1 ciclo do clock.  
- Depois retorna automaticamente para ESPERA.

---

##  Diagrama da FSM


---

##  Arquitetura do Projeto (VHDL)

O projeto foi dividido em 4 módulos principais:

###  **1. timer.vhd**  
Responsável por gerar o pulso de tempo (`tick`) que controla quando o sistema libera ração.

###  **2. motor.vhd**  
Representa o motor. Liga quando o sinal `enable` estiver em 1.

###  **3. distribuidor.vhd**  
É o módulo principal:
- Instancia o timer e o motor  
- Implementa a FSM  
- Controla LEDs, estados e acionamento da saída  

###  **4. tb_distribuidor.vhd**  
Testbench usado para simulação do sistema completo.

---

##  Simulações (coloca prints aqui)



###  **1. Diagrama de ondas da FSM**
*(print aqui)*

---

###  **2. Temporizador gerando o pulso `tick`**
*(print aqui)*

---

###  **3. Acionamento do motor e LEDs**
*(print aqui)*

---

##  Explicação do Funcionamento (Passo a Passo)

1. O clock inicia e o sinal de reset zera o contador.  
2. O temporizador começa a contar até o valor configurado em `MAX_COUNT`.  
3. Ao atingir o valor máximo, gera um `tick = 1` durante um ciclo.  
4. A FSM detecta o `tick` e transita para o estado DISPENSA.  
5. Em DISPENSA:
   - `motor_out` é ativado,  
   - `led_dispense = 1`,  
   - `led_wait = 0`.  
6. Após 1 ciclo, a FSM retorna ao estado ESPERA.  
7. O ciclo se repete continuamente.

---

##  Conclusão

O desenvolvimento do distribuidor automático de ração permitiu aplicar vários conceitos fundamentais da disciplina de Sistemas Digitais:

- utilização de contadores (temporizador),  
- criação de uma FSM simples e funcional,  
- modularização com múltiplos arquivos VHDL,  
- simulação completa usando testbench no Vivado.

O projeto demonstra como sistemas reais podem ser controlados usando lógica digital e mostra, na prática, como dividir um problema em blocos menores (timer, motor, controlador).

###  Dificuldades e Aprendizados
- Entender o fluxo entre contador → FSM → saída foi essencial.  
- Ajustar tempos e testar transições na simulação foi uma das partes mais trabalhosas.  

