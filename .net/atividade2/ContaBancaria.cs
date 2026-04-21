abstract class ContaBancaria
{
    public double Saldo { get; set; }

    public abstract void Depositar(double valor);
    public abstract void Sacar(double valor);

    public void ExibirSaldo()
    {
        Console.WriteLine($"Saldo: R$ {Saldo}");
    }
}
