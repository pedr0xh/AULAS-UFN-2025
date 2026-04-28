using System;

namespace ListaPOO
{
    public class Motocicleta : Veiculo
    {
        public void RegistrarChassi(string chassi)
        {
            numeroChassi = chassi;
        }

        public void MostrarChassi()
        {
            Console.WriteLine(numeroChassi);
        }
    }
}