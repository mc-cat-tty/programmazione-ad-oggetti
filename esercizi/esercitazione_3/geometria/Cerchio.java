package esercizi.esercitazione_3.geometria;

public class Cerchio extends Figura implements Curva {
    private double raggio;

    public Cerchio() {
        trySetRaggio(1);
        update();
    }

    public Cerchio(double raggio) {
        trySetRaggio(raggio);
        update();
    }

    public boolean setRaggio(double raggio) {
        return trySetRaggio(raggio) && update();
    }

    protected double computeArea() {
        return Math.pow(raggio, 2)*Math.PI;
    }

    protected double computePerimetro() {
        return 2.0*raggio*Math.PI;
    }

    private boolean trySetRaggio(double raggio) {
        if (raggio > 0) {
            this.raggio = raggio;
            return true;
        }
        return false;
    }
}
