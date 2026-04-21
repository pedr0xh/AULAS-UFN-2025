class Eletronico : Produto
{
    public override double CalcularDesconto()
    {
        return Preco * 0.125;
    }
}
