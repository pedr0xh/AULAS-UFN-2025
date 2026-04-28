using System;

namespace ListaPOO
{
    public class Contrato : Documento, IAssinavel
    {
        public override void Imprimir()
        {
            Console.WriteLine("Imprimindo contrato");
        }

        public void Assinar()
        {
            Console.WriteLine("Contrato assinado");
        }
    }
}