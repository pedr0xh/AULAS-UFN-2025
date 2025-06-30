public class Ponto {
    private double x;
    private double y;
    private int limiar;

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getLimiar() {
        return limiar;
    }

    public void setLimiar(int limiar) {
        this.limiar = limiar;
    }
}
