package esercizi.esercitazione_3.geometria;

public abstract class Figura {
    private double area;
    private double perimetro;

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    protected abstract double computeArea();
    protected abstract double computePerimetro();

    protected boolean update() {
        return setPerimetro(computePerimetro()) && setArea(computeArea());
    }

    private boolean setArea(double area) {
        boolean isPlausible = area > 0;
        if (isPlausible) {
            this.area = area;
            return true;
        }
        return false;
    }

    private boolean setPerimetro(double perimetro) {
        boolean isPlausible = perimetro > 0;
        if (isPlausible) {
            this.perimetro = perimetro;
            return true;
        }
        return false;
    }
}