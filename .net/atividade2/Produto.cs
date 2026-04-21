abstract class Produto
{
    public string Nome { get; set; }
    public double Preco { get; set; }

    public abstract double CalcularDesconto();

    public void ExibirPrecoFinal()
    {
        double final = Preco - CalcularDesconto();
        Console.WriteLine($"{Nome} - R$ {final}");
    }
}
