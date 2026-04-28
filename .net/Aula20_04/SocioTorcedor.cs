using System;

namespace ListaPOO
{
    public class SocioTorcedor
    {
        public string Nome { get; set; }
        public string Categoria { get; set; }

        private double mensalidade;
        public double Mensalidade
        {
            get => mensalidade;
            set
            {
                if (value <= 0)
                    throw new ArgumentException("Mensalidade inválida");
                mensalidade = value;
            }
        }

        public DateTime DataAdesao { get; private set; }

        private int mesesInadimplente;

        public bool StatusAdimplente => mesesInadimplente == 0;

        public SocioTorcedor()
        {
            DataAdesao = DateTime.Now;
        }

        public void RegistrarPagamento()
        {
            mesesInadimplente = 0;
        }

        public void RegistrarAtraso()
        {
            mesesInadimplente++;
        }

        private double CalcularFatorDesconto()
        {
            if (!StatusAdimplente) return 1;

            if (Categoria == "Campeão") return 0.5;
            if (Categoria == "Colorado") return 0.8;

            return 1;
        }

        public double ValorComDescontoIngresso
        {
            get
            {
                return 100 * CalcularFatorDesconto();
            }
        }
    }
}