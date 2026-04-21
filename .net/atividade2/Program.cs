using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        int opcao;

        do
        {
            Console.WriteLine("\n===== MENU =====");
            Console.WriteLine("1 - Sistema Escolar");
            Console.WriteLine("2 - Veículos");
            Console.WriteLine("3 - Contas Bancárias");
            Console.WriteLine("4 - Produtos");
            Console.WriteLine("0 - Sair");
            Console.Write("Escolha: ");
            int.TryParse(Console.ReadLine(), out opcao);

            switch (opcao)
            {
                case 1: SistemaEscolar(); break;
                case 2: Veiculos(); break;
                case 3: Contas(); break;
                case 4: Produtos(); break;
            }

        } while (opcao != 0);
    }

    static void SistemaEscolar()
    {
        List<Pessoa> pessoas = new List<Pessoa>()
        {
            new Aluno { Nome = "Pedro", Idade = 20, Matricula = "A123" },
            new Professor { Nome = "Carlos", Idade = 45, Disciplina = "Matemática" },
            new Funcionario { Nome = "Ana", Idade = 30, Cargo = "Secretária" }
        };

        foreach (var p in pessoas)
        {
            p.Apresentar();
            p.ExibirTipo();
            Console.WriteLine();
        }
    }

    static void Veiculos()
    {
        List<Veiculo> lista = new List<Veiculo>()
        {
            new Carro { Marca = "Ford", Modelo = "Ka", Portas = 4 },
            new Moto { Marca = "Honda", Modelo = "CG", Cilindrada = 160 }
        };

        foreach (var v in lista)
        {
            v.Dirigir();
            v.CalcularConsumo();
            Console.WriteLine();
        }
    }

    static void Contas()
    {
        List<ContaBancaria> contas = new List<ContaBancaria>()
        {
            new ContaCorrente { Saldo = 100 },
            new ContaPoupanca { Saldo = 200 },
            new ContaSalario { Saldo = 300 }
        };

        foreach (var c in contas)
        {
            c.Depositar(50);
            c.Sacar(30);
            c.ExibirSaldo();
            Console.WriteLine();
        }
    }

    static void Produtos()
    {
        List<Produto> lista = new List<Produto>()
        {
            new Livro { Nome = "Livro A", Preco = 50 },
            new Eletronico { Nome = "Celular", Preco = 1000 },
            new Roupa { Nome = "Camiseta", Preco = 120 }
        };

        foreach (var p in lista)
        {
            p.ExibirPrecoFinal();
        }
    }
}
