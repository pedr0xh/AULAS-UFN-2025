import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Util extends Thread {

    static List<Integer> lista = new ArrayList<>();
    private int tamanho;

    public Util(List<Integer> lista, int tamanho) {
        this.lista = lista;
        this.tamanho = tamanho;
    }

    @Override
    public void run() {
        Random gerador = new Random();
        for (int i = 0; i < tamanho; i++) {
            int numeroGerado = gerador.nextInt(0, 1000);
            lista.add(numeroGerado);
        }
    }

    //11
    public static void paresImpares() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Até qual número deseja mostrar os pares e ímpares: ");
        int qntdNumeros = ler.nextInt();

        Thread pares = new Thread(() -> {
            for (int i = 0; i <= qntdNumeros; i += 2) {
                System.out.println("Par: " + i);
            }
        });

        Thread impares = new Thread(() -> {
            for (int i = 1; i <= qntdNumeros; i += 2) {
                System.out.println("Ímpar: " + i);
            }
        });

        pares.start();
        impares.start();
    }

    static void dormir(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static volatile boolean rodando = true;

    //12
    public static void comAtraso() {
        rodando = true;
        Thread t1 = new Thread(() -> {
            while (rodando) {
                System.out.println("Thread 1");
                dormir(1000);
            }
        });

        Thread t2 = new Thread(() -> {
            while (rodando) {
                System.out.println("Thread 2");
                dormir(2000);
            }
        });

        Thread t3 = new Thread(() -> {
            while (rodando) {
                System.out.println("Thread 3");
                dormir(3000);
            }
        });

        t1.start();
        t2.start();
        t3.start();

        dormir(10000);
        rodando = false;
    }

    static int contador = 0;

    //13
    static void semLock() {
        Runnable r = () -> {
            for (int i = 0; i < 100000 && rodando; i++) {
                contador++;
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Valor final do contador: " + contador);
    }

    static int contadorLock = 0;
    static Lock lock = new ReentrantLock();

    //14
    static void comLock() {
        Runnable r = () -> {
            for (int i = 0; i < 100000; i++) {
                lock.lock();
                try {
                    contadorLock++;
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Valor final do contador (com lock): " + contadorLock);
    }
    //15
    static void produtorConsumidor() {
        final List<Integer> fila = new ArrayList<>();
        final int capacidade = 5;

        Thread produtor = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (fila) {
                    while (fila.size() == capacidade) {
                        try {
                            fila.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    fila.add(i);
                    System.out.println("Produziu: " + i);
                    fila.notifyAll();
                }
                dormir(500);
            }
        });

        Thread consumidor = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (fila) {
                    while (fila.isEmpty()) {
                        try {
                            fila.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    int x = fila.remove(0);
                    System.out.println("Consumiu: " + x);
                    fila.notifyAll();
                }
                dormir(1000);
            }
        });

        produtor.start();
        consumidor.start();

        try {
            produtor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Execução do Produtor-Consumidor finalizada!");
    }
    //16
    static void relogioLogico() {
        produtorConsumidor();
    }

    //17
    static void threadParametro() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        final int[] resultado = new int[1];

        Thread t = new Thread(() -> {
            int soma = 0;
            for (int n : numeros) soma += n;
            resultado[0] = soma;
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Q17 - Soma da lista: " + resultado[0]);
    }
    //18
    static void Barrier() {
        final int NUM_THREADS = 4;
        final Object barreira = new Object();
        final boolean[] passou = {false};
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            final int id = i + 1;
            threads[i] = new Thread(() -> {
                System.out.println("Thread " + id + " - fase 1 concluída");
                synchronized (barreira) {
                    passou[0] = true;
                    barreira.notifyAll();
                    try {
                        barreira.wait(500); // espera simples para simular barrier
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Thread " + id + " - fase 2 iniciada");
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // 19
    static void Deadlock() {
        final Object recurso1 = new Object();
        final Object recurso2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (recurso1) {
                System.out.println("Thread 1 pegou recurso1");
                dormir(100);
                synchronized (recurso2) {
                    System.out.println("Thread 1 pegou recurso2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (recurso2) {
                System.out.println("Thread 2 pegou recurso2");
                dormir(100);
                synchronized (recurso1) {
                    System.out.println("Thread 2 pegou recurso1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
