class Livro : Produto
{
    public override double CalcularDesconto()
    {
        return Preco * 0.05;
    }
}
