using System;

namespace ListaPOO
{
    public class ContaVip : Conta
    {
        public override void Sacar(decimal valor)
        {
            Console.WriteLine($"Saque sem taxa: {valor}");
        }
    }
}