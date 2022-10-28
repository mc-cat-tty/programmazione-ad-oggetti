import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private int pages;
    
    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Pages: " + pages; 
    }
}
