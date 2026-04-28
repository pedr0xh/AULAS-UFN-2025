using System;

namespace ListaPOO
{
    class Program
    {
        static void Main()
        {
            Console.WriteLine("Escolha exercício (1-13): ");
            int op = int.Parse(Console.ReadLine());

            switch (op)
            {
                case 1:
                    var cfg = new ConfiguracaoSistema();
                    Console.WriteLine($"{cfg.NomeServidor} | {cfg.Porta} | {cfg.ModoDebug}");
                    break;

                case 2:
                    var p = new Produto();
                    p.QuantidadeEstoque = 10;
                    p.QuantidadeEstoque = -5;
                    Console.WriteLine(p.QuantidadeEstoque);
                    break;

                case 3:
                    var j = new Jogador();
                    j.AdicionarPontos(50);
                    Console.WriteLine(j.Pontuacao);
                    break;

                case 4:
                    var m = new Motocicleta();
                    m.RegistrarChassi("ABC123");
                    m.MostrarChassi();
                    break;

                case 5:
                    var f = new Funcionario("Pedro", 123);
                    Console.WriteLine($"{f.Nome} - {f.Matricula}");
                    break;

                case 7:
                    var c = new Calculadora();
                    Console.WriteLine(c.Somar(2, 3));
                    Console.WriteLine(c.Somar(2, 3, 4));
                    Console.WriteLine(c.Somar(2.5, 3.5));
                    break;

                case 8:
                    Conta conta = new Conta();
                    Conta vip = new ContaVip();
                    conta.Sacar(100);
                    vip.Sacar(100);
                    break;

                case 9:
                    Conta cp = new ContaPoupanca();
                    cp.Sacar(100);
                    break;

                case 10:
                    Contrato ct = new Contrato();
                    ct.Abrir();
                    ct.Imprimir();
                    ct.Assinar();
                    break;

                default:
                    Console.WriteLine("Execute outros exercícios criando objetos diretamente.");
                    break;
            }
        }
    }
}