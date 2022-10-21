package esercizi.esercitazione_3.geometria;

public class Quadrato extends Rettangolo {
    public Quadrato() {
        super();
    }

    public Quadrato(double lato) {
        super(lato, lato);
    }

    public boolean setLato(double lato) {
        return super.setLato1(lato) && super.setLato2(lato);
    }

    @Override
    public boolean setLato1(double lato1) {
        return setLato(lato1);
    }

    @Override
    public boolean setLato2(double lato2) {
        return setLato(lato2);
    }
}
