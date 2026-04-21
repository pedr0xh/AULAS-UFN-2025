class Professor : Pessoa
{
    public string Disciplina { get; set; }

    public override void Apresentar()
    {
        Console.WriteLine($"Professor: {Nome}, {Idade}, Disciplina: {Disciplina}");
    }

    public override void ExibirTipo()
    {
        Console.WriteLine("Sou um professor");
    }
}
