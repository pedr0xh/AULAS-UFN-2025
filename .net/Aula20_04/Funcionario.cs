namespace ListaPOO
{
    public class Funcionario : Pessoa
    {
        public int Matricula;

        public Funcionario(string nome, int matricula) : base(nome)
        {
            Matricula = matricula;
        }
    }
}