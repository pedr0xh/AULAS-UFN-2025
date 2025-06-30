import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exemplo de RNA Perceptron para classificação de equipes (com CSV)");

        List<Ponto> amostras = new ArrayList<>();
        List<Integer> saidas = new ArrayList<>();

        String caminhoArquivo = "C:\\Users\\podes\\OneDrive - UFN - Universidade Franciscana\\Documents\\amostras\\amostras_saidas_problemaTimes.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    double x = Double.parseDouble(partes[0].trim());
                    double y = Double.parseDouble(partes[1].trim());
                    int saida = Integer.parseInt(partes[2].trim());

                    amostras.add(new Ponto(x, y));
                    saidas.add(saida);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        double taxaAprendizado = 0.1;
        int geracoes = 1000;
        int limiar = 1;

        Perceptron p = new Perceptron(amostras, saidas, taxaAprendizado, geracoes, limiar);
        p.treinar();

        Scanner scanner = new Scanner(System.in);
        String op;
        do {
            System.out.print("\nvalor para x (-1 a 1): ");
            double x = scanner.nextDouble();
            System.out.print("valor para y (-1 a 1): ");
            double y = scanner.nextDouble();

            p.testar(new Ponto(x, y));

            System.out.print("1 - Sair: \n 0 - Inserir outro valor: ");
            op = scanner.next();
        } while (!op.equals("1"));
    }
}
