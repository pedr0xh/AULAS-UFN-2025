import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner ler = new Scanner(System.in);

        System.out.println("quantidade de listas que deseja que sejam geradas: ");
        final int qntdLista = ler.nextInt();
        System.out.println("quantidade de numeros que deseja em cada lista: ");
        final int qntdNumeros = ler.nextInt();
        final int totalNumeros = qntdNumeros * qntdLista;

        List<List<Integer>> listaDeListas = estruturaListas(qntdLista);
        List<Thread> threadsAtivas = popularParalelo(listaDeListas, qntdNumeros);
        esperaTerminar(threadsAtivas);

        double somaTotal = calcularSoma(listaDeListas);
        double mediaFinal = somaTotal / totalNumeros;

        System.out.println("Soma Total: " + somaTotal);
        System.out.println("Media Final: " + mediaFinal);
    }

    private static List<List<Integer>> estruturaListas(int qntdLista) {
        List<List<Integer>> listaDeListas = new ArrayList<>();
        for (int i = 0; i < qntdLista; i++) {
            listaDeListas.add(new ArrayList<>());
        }
        return listaDeListas;
    }

    private static List<Thread> popularParalelo(List<List<Integer>> listaDeListas, int qntdNumeros) {
        List<Thread> threadsAtivas = new ArrayList<>();
        for (List<Integer> lista : listaDeListas) {
            Thread novaThread = new Util(lista, qntdNumeros);
            threadsAtivas.add(novaThread);
            novaThread.start();
        }
        return threadsAtivas;
    }

    private static void esperaTerminar(List<Thread> listaDeThreads) throws InterruptedException {
        for (Thread t : listaDeThreads) {
            t.join();
        }
    }

    private static double calcularSoma(List<List<Integer>> listaDeListas) {
        double somaTotal = 0;
        for (List<Integer> lista : listaDeListas) {
            for (int numero : lista) {
                somaTotal += numero;
            }
        }
        return somaTotal;
    }
}
