import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class MainSerialize {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Missing operand");
        }

        var libs = new Library[2];
        for (int i=0; i<2; i++) {
            libs[i] = new Library();
        }

        libs[0].addBook(new Book("Pinocchio", 10));
        libs[0].addBook(new Book("Kernel Hacking Guide", 100));
        libs[0].addBook(new Book("Design Patterns", 50));
        libs[0].addBook(new Book("Failed", 2));
        
        libs[1].addBook(new Book("Prova1", 1));
        libs[1].addBook(new Book("Prova2", 2));
        
        try (
            var fileStream = new FileOutputStream(args[0]);
            var outStream = new ObjectOutputStream(fileStream);
        ) {
            outStream.writeObject(libs);
        }
        catch (NotSerializableException | InvalidClassException e) {
            System.err.println("Not serializable: " + e.getMessage());
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
            System.exit(2);
        }

        try (
            var fileStream = new FileInputStream(args[0]);
            var inStream = new ObjectInputStream(fileStream);
        ) {
            var loadedLibs = (Library[]) inStream.readObject();
            printLibraries(loadedLibs);
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printLibraries(Library[] libs) {
        for (var l : libs) {
            if (l != null) {
                System.out.println(l);
            }
        }
    }
}
