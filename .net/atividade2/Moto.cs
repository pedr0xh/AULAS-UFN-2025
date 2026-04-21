class Moto : Veiculo
{
    public int Cilindrada { get; set; }

    public override void Dirigir()
    {
        Console.WriteLine($"Dirigindo a {Marca} {Modelo} com {Cilindrada} cilindradas");
    }

    public override void CalcularConsumo()
    {
        Console.WriteLine($"Consumo: {Cilindrada / 10} km/l");
    }
}
