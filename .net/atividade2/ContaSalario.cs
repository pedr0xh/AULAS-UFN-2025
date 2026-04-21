class ContaSalario : ContaBancaria
{
    public override void Depositar(double valor)
    {
        Console.WriteLine("Depósito não permitido");
    }

    public override void Sacar(double valor)
    {
        if (valor <= Saldo)
            Saldo -= valor;
    }
}
