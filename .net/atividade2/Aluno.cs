class Aluno : Pessoa
{
    public string Matricula { get; set; }

    public override void Apresentar()
    {
        Console.WriteLine($"Aluno: {Nome}, {Idade}, Matrícula: {Matricula}");
    }

    public override void ExibirTipo()
    {
        Console.WriteLine("Sou um aluno");
    }
}
