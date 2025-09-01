import java.util.List;
import java.util.Random;

public class Util extends Thread {

    private List<Integer> lista;
    private int tamanho;

    public Util(List<Integer> lista,  int tamanho) {

        this.lista = lista;
        this.tamanho = tamanho;

    }

    @Override
    public void run() {

        Random gerador = new Random();
        for  (int i = 0; i < tamanho; i++) {
            int numeroGerado = gerador.nextInt(0,1000);
            lista.add(numeroGerado);
        }

    }
}
