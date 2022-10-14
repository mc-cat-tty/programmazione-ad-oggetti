public class MainTester {
  public static void main(String[] args) {
    Libro libri[] = new Libro[3];

    libri[0] = new Libro("Manzoni", "Promessi Sposi", 3, 20);
    libri[1] = new Libro("Andreolini", "SO handbook", 1, 20);
    libri[2] = new Libro("The gang of four", "Design patterns", 10, 1);

    System.out.println(libri[0]);
    System.out.println(libri[1]);

    System.out.println(libri[1].prestito());
    System.out.println(libri[1].prestito());
    System.out.println(libri[1]);
    libri[1].restituzione();
    libri[1].restituzione();
    System.out.println(libri[1]);
    
  }
}
