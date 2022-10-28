import java.io.Serializable;

public class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int MAX_DIM = 3;
    private Book[] books;
    private int dim;

    public Library() {
        books = new Book[MAX_DIM];
        dim = 0;
    }

    public void addBook(Book b) {
        if (dim < MAX_DIM) {
            books[dim++] = b;
        }
    }

    public String toString() {
        String out = "";
        for (Book b : books) {
            if (b != null) {
                out += (b + " | ");
            }
        }
        return out;
    }
}
