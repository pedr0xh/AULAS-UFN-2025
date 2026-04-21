abstract class Pessoa
{
    public string Nome { get; set; }
    public int Idade { get; set; }

    public abstract void Apresentar();

    public virtual void ExibirTipo()
    {
        Console.WriteLine("Sou uma pessoa");
    }
}
