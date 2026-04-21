abstract class Veiculo
{
    public string Marca { get; set; }
    public string Modelo { get; set; }

    public abstract void Dirigir();
    public abstract void CalcularConsumo();
}
