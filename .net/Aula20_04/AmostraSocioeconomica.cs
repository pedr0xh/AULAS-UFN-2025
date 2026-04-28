using System;
using System.Collections.Generic;
using System.Linq;

namespace ListaPOO
{
    public class AmostraSocioeconomica
    {
        private double nivel;

        public double NivelConfiancaEstatisica
        {
            get => nivel;
            set
            {
                if (value < 0 || value > 100)
                {
                    Console.WriteLine("Valor inválido");
                }
                else
                {
                    if (value > 1)
                        nivel = value / 100;
                    else
                        nivel = value;
                }
            }
        }

        private List<double> dados = new List<double>();
        private double? mediaCache = null;
        private double? medianaCache = null;

        public void AdicionarDado(double valor)
        {
            dados.Add(valor);
            mediaCache = null;
            medianaCache = null;
        }

        public double MediaRenda
        {
            get
            {
                if (mediaCache == null)
                    mediaCache = dados.Average();
                return mediaCache.Value;
            }
        }

        public double MedianaRenda
        {
            get
            {
                if (medianaCache == null)
                {
                    var ordenado = dados.OrderBy(x => x).ToList();
                    int meio = ordenado.Count / 2;
                    medianaCache = ordenado[meio];
                }
                return medianaCache.Value;
            }
        }
    }
}