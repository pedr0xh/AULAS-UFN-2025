using System;

class Program
{
    static void Main()
    {
        Console.WriteLine("Digite o nome do aluno:");
        string nomeAluno = Console.ReadLine();

        Console.WriteLine("Digite a idade do aluno:");
        int idadeAluno = int.Parse(Console.ReadLine());

        Console.WriteLine("Digite a matricula do aluno:");
        string matricula = Console.ReadLine();

        Aluno a = new Aluno(nomeAluno, idadeAluno, matricula);
        a.Apresentar();

        Console.WriteLine("\nCadastro do primeiro livro");

        Console.WriteLine("Titulo:");
        string t1 = Console.ReadLine();

        Console.WriteLine("Autor:");
        string a1 = Console.ReadLine();

        Console.WriteLine("Numero de paginas:");
        int p1 = int.Parse(Console.ReadLine());

        Console.WriteLine("\nCadastro do segundo livro");

        Console.WriteLine("Titulo:");
        string t2 = Console.ReadLine();

        Console.WriteLine("Autor:");
        string a2 = Console.ReadLine();

        Console.WriteLine("Numero de paginas:");
        int p2 = int.Parse(Console.ReadLine());

        Livro l1 = new Livro(t1, a1, p1);
        Livro l2 = new Livro(t2, a2, p2);

        l1.Emprestar();
        l1.Mostrar();
        l2.Mostrar();

        Console.WriteLine("\nCriacao do personagem");

        Console.WriteLine("Nome:");
        string nome = Console.ReadLine();

        Console.WriteLine("Posicao inicial:");
        string posicao = Console.ReadLine();

        Console.WriteLine("Itens coletados:");
        string itens = Console.ReadLine();

        Personagem p = new Personagem(nome, posicao, itens);

        Console.WriteLine("Digite o dano do ataque (0 a 10):");
        double dano = double.Parse(Console.ReadLine());

        Console.WriteLine("Direcao do movimento (1-frente, 2-tras, 3-direita, 4-esquerda):");
        int direcao = int.Parse(Console.ReadLine());

        p.Atacar(dano);
        p.Movimentar(direcao);
    }
}