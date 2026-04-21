class Roupa : Produto
{
    public override double CalcularDesconto()
    {
        return Preco > 100 ? Preco * 0.20 : Preco * 0.10;
    }
}
