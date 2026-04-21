class ContaCorrente : ContaBancaria
{
    public override void Depositar(double valor)
    {
        Saldo += valor;
    }

    public override void Sacar(double valor)
    {
        Saldo -= (valor + 2);
    }
}
