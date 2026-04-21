class Carro : Veiculo
{
    public int Portas { get; set; }

    public override void Dirigir()
    {
        Console.WriteLine($"Dirigindo o {Marca} {Modelo} com {Portas} portas");
    }

    public override void CalcularConsumo()
    {
        Console.WriteLine("Consumo: 12 km/l");
    }
}
