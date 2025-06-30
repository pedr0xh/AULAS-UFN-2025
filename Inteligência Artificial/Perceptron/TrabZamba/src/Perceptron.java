import java.util.List;
import java.util.Random;

public class Perceptron {

    private List<Ponto> amostras;
    private List<Integer> saidas;

    private double taxaAprendizado;
    private int geracoes;
    private int limiar;
    private int numeroAmostras;
    private int numeroAtributos;

    private double[] pesos;

    public Perceptron(List<Ponto> amostras, List<Integer> saidas, double taxaAprendizado,
                      int geracoes, int limiar) {
        this.amostras = amostras;
        this.saidas = saidas;
        this.taxaAprendizado = taxaAprendizado;
        this.geracoes = geracoes;
        this.limiar = limiar;
        this.numeroAmostras = amostras.size();
        this.pesos = new double[3];
    }

    private int funcaoAtivacaoSignal(double soma){

        return soma >= 0 ? 1 : -1;

    }

    public void treinar(){

        for(Ponto ponto : amostras){
            ponto.setLimiar(this.limiar);
        }

        Random gerador = new Random();

        pesos[0] = limiar;
        pesos[1] = gerador.nextDouble();
        pesos[2] = gerador.nextDouble();

        int conta = 0;
        boolean aprendeu;
        double soma;
        int saidaGerada;

        while(true){
            aprendeu = true;

            for(int i = 0; i < amostras.size();i++){

                Ponto ponto = amostras.get(i);
                soma = (ponto.getLimiar() * pesos[0]) + (ponto.getX() * pesos[1]) + (ponto.getY() * pesos[2]);

                saidaGerada = funcaoAtivacaoSignal(soma);

                if(saidaGerada != saidas.get(i)){
                    aprendeu = false;
                    double erro = saidas.get(i) - saidaGerada;

                    pesos[0] += taxaAprendizado * erro * ponto.getLimiar();
                    pesos[1] += taxaAprendizado * erro * ponto.getX();
                    pesos[2] += taxaAprendizado * erro * ponto.getY();
                }
            }

            conta++;

            if(aprendeu || conta > geracoes){
                System.out.println("Gerações de treinamento: "+conta);
                break;
            }
        }
    }
    public void testar(Ponto amostra){

        amostra.setLimiar(this.limiar);
        double soma = (amostra.getLimiar() * pesos[0]) + (amostra.getX() * pesos[1]) + (amostra.getY() * pesos[2]);
        int saidaGerada = funcaoAtivacaoSignal(soma);

        if (saidaGerada == 1) {
            System.out.println("Classe: " + saidaGerada + " Time Azul");
        } else {
            System.out.println("Classe: " + saidaGerada + " Time Vermelho");
        }
    }
}
