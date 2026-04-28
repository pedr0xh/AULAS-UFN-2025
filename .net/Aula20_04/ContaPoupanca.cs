using System;

namespace ListaPOO
{
    public class ContaPoupanca : Conta
    {
        public new void Sacar(decimal valor)
        {
            Console.WriteLine($"Poupança sacando: {valor}");
        }
    }
}