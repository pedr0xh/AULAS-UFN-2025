# Relógio Físico
**O que é?**

    É o relógio real do sistema (hardware), responsável por marcar o tempo em cada máquina. 
        Ele serve para sincronizar tarefas e eventos que dependem da ordem temporal.
**Exemplo:**

    Imagine que cada funcionário de uma empresa usa seu próprio relógio de pulso para registrar quando entregou um relatório.

    O funcionário A entrega às 10:00 no relógio dele.
    O funcionário B entrega às 10:02 no relógio dele.
    Porém, o relógio do funcionário A estava 2 minutos adiantado.

 Isso mostra que, mesmo usando relógios físicos, pode haver diferença entre eles, o que pode gerar confusão em sistemas distribuídos.

# Eleição
**O que é?**

    É um processo usado em sistemas distribuídos para escolher um líder (ou coordenador) entre vários processos. 
        Esse líder será responsável por tomar decisões ou coordenar tarefas.
**Exemplo:**

    Imagine uma sala de aula sem professor, onde os alunos precisam decidir quem vai organizar a atividade.

    Cada aluno (processo) pode propor ser o líder.
    Os colegas “votam” ou comparam quem tem maior prioridade (pode ser a idade, a nota mais alta, etc.).
    O aluno escolhido passa a ser o coordenador da turma até que não possa mais cumprir o papel (ex: sai da sala).

 Assim como no sistema, quando o líder atual falha, é feito um novo processo de eleição para escolher outro.
