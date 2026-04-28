using System;

namespace ListaPOO
{
    public class Conta
    {
        public virtual void Sacar(decimal valor)
        {
            Console.WriteLine($"Saque com taxa: {valor + 1}");
        }
    }
}