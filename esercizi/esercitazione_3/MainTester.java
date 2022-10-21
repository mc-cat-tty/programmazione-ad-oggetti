package esercizi.esercitazione_3;

import esercizi.esercitazione_3.geometria.*;

public class MainTester {
    public static void main(String[] args) {
        final int DIM = 3;
        Figura[] figure = new Figura[DIM];
        Quadrato q = new Quadrato(3);
        q.setLato(10);
        figure[0] = q;
        figure[1] = new Rettangolo();
        figure[2] = new Cerchio(5);


        for (Figura fig : figure) {
            System.out.println(fig.getArea() + " " + fig.getPerimetro());
        }
    }
}
