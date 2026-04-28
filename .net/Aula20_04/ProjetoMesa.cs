using System;
using System.Collections.Generic;
using System.Linq;

namespace ListaPOO
{
    public class ProjetoMesa
    {
        private double comprimento;
        private double largura;

        public double ComprimentoTampo
        {
            get => comprimento;
            set
            {
                if (value < 50)
                {
                    Console.ForegroundColor = ConsoleColor.Yellow;
                    Console.WriteLine("Valor inválido!");
                    Console.ResetColor();
                }
                else comprimento = value;
            }
        }

        public double LarguraTampo
        {
            get => largura;
            set
            {
                if (value < 50)
                {
                    Console.ForegroundColor = ConsoleColor.Yellow;
                    Console.WriteLine("Valor inválido!");
                    Console.ResetColor();
                }
                else largura = value;
            }
        }

        private List<double> _cortes = new List<double>();

        public void AdicionarCorte(double t)
        {
            _cortes.Add(t);
        }

        public IReadOnlyCollection<double> Cortes => _cortes.AsReadOnly();

        public int BarrasNecessarias
        {
            get
            {
                double soma = _cortes.Sum();
                return (int)Math.Ceiling(soma / 600);
            }
        }
    }
}