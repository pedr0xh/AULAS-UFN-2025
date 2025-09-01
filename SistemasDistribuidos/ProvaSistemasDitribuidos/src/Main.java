import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int opcao;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nEscolha a questão para executar:");
            System.out.println("11 - Thread básica (pares e ímpares)");
            System.out.println("12 - Threads com atraso");
            System.out.println("13 - Memória compartilhada sem lock");
            System.out.println("14 - Memória compartilhada com lock");
            System.out.println("15 - Produtor-Consumidor com Queue");
            System.out.println("16 - Relógio lógico (Lamport)");
            System.out.println("17 - Thread com parâmetro (soma lista)");
            System.out.println("18 - Barrier");
            System.out.println("19 - Deadlock");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 11 -> Util.paresImpares();
                case 12 -> Util.comAtraso();
                case 13 -> Util.semLock();
                case 14 -> Util.comLock();
                case 15 -> Util.produtorConsumidor();
                case 16 -> Util.relogioLogico();
                case 17 -> Util.threadParametro();
                case 18 -> Util.Barrier();
                case 19 -> Util.Deadlock();
            }

        }while (opcao != 0);

    }
}