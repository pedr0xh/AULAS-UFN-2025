using System;

public class Livro
{
    string titulo;
    string autor;
    int paginas;
    bool emprestado;

    public Livro(string titulo, string autor, int paginas)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        emprestado = false;
    }

    public void Emprestar()
    {
        emprestado = true;
    }

    public void Devolver()
    {
        emprestado = false;
    }

    public void Mostrar()
    {
        Console.WriteLine("Titulo: " + titulo);
        Console.WriteLine("Autor: " + autor);
        Console.WriteLine("Paginas: " + paginas);
        Console.WriteLine("Emprestado: " + emprestado);
    }
}