package esercizi.esercitazione_1;

public class Libro {
  private String autore;
  private String titolo;
  private Integer copie;
  private Integer numeroPagine;

  public Libro(String autore, String titolo, Integer copie, Integer numeroPagine) {
    setAutore(autore);
    setTitolo(titolo);
    setCopie(copie);
    setNumeroPagine(numeroPagine);
  }

  private void setAutore(String autore) {
    this.autore = autore;
  }

  private void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public void setCopie(Integer copie) {
    if (copie < 0) {
      this.copie = 0;
      return;
    }
    
    this.copie = copie;
  }

  private void setNumeroPagine(Integer numeroPagine) {
    if (numeroPagine < 1) {
      this.numeroPagine = 1;
    }
    this.numeroPagine = numeroPagine;
  }

  public String getAutore() {
    return autore;
  }

  public String getTitolo() {
    return titolo;
  }

  public Integer getCopie() {
    return copie;
  }

  public Integer getNumeroPagine() {
    return numeroPagine;
  }

  public boolean prestito() {
    if (copie <= 0) {
      return false;
    }

    copie--;
    return true;
  }

  public void restituzione() {
    copie++;
  }

  public String toString() {
    return getTitolo() + ": " + getAutore() + " " + getCopie();
  }  
}