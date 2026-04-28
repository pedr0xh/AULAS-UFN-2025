namespace ListaPOO
{
    public class Jogador
    {
        public int Pontuacao { get; private set; }

        public void AdicionarPontos(int pontos)
        {
            Pontuacao += pontos;
        }
    }
}