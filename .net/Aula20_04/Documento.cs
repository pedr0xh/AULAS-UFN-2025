using System;

namespace ListaPOO
{
    public abstract class Documento
    {
        public abstract void Imprimir();

        public void Abrir()
        {
            Console.WriteLine("Documento aberto");
        }
    }
}