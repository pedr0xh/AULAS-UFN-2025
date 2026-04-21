class Funcionario : Pessoa
{
    public string Cargo { get; set; }

    public override void Apresentar()
    {
        Console.WriteLine($"Funcionário: {Nome}, {Idade}, Cargo: {Cargo}");
    }
}
