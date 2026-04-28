namespace ListaPOO
{
    public class Produto
    {
        private int quantidadeEstoque;

        public int QuantidadeEstoque
        {
            get { return quantidadeEstoque; }
            set
            {
                if (value >= 0)
                    quantidadeEstoque = value;
            }
        }
    }
}