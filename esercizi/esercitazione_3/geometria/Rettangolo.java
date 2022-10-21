package esercizi.esercitazione_3.geometria;

public class Rettangolo extends Figura implements Poligono {
    private double lato1;
    private double lato2;

    public Rettangolo() {
        trySetLato1(1);
        trySetLato2(1);
        update();
    }

    public Rettangolo(double lato1, double lato2) {
        trySetLato1(lato1);
        trySetLato2(lato2);
        update();
    }

    public boolean setLato1(double lato1) {
        return trySetLato1(lato1) && update();
    }

    public boolean setLato2(double lato2) {
        return trySetLato2(lato2) && update();
    }

    protected double computeArea() {
        return lato1*lato2;
    }

    protected double computePerimetro() {
        return 2*lato1+2*lato2;
    }

    private boolean trySetLato1(double lato1) {
        if (lato1 > 0) {
            this.lato1 = lato1;
            return true;
        }
        return false;
    }

    private boolean trySetLato2(double lato2) {
        if (lato2 > 0) {
            this.lato2 = lato2;
            return true;
        }
        return false;
    }
} 