import java.io.*;
import java.lang.*;
import java.util.*;

public class MainBinary {
    private static final System.Logger LOGGER = System.getLogger("MainLogger");

    public static void main(String[] args) {
        if (args.length == 2) {
            esercizio1(args[0], args[1]);
        }
        else if (args.length == 1) {
            esercizio2e3(args[0]);
        }
        else {
            throw new IllegalArgumentException("Missing operands");
        }
    }

    public static void esercizio1(String srcFile, String dstFile) {
        File src = new File(srcFile);
        File dst = new File(dstFile);

        BufferedInputStream srcStream = null;
        BufferedOutputStream dstStream = null;

        int availableBytes = 0;

        try {
            srcStream = new BufferedInputStream(new FileInputStream(src));
            dstStream = new BufferedOutputStream(new FileOutputStream(dst));

            int i = 1;
            while ((availableBytes = srcStream.available()) > 0) {
                byte[] buffer = new byte[availableBytes];
                srcStream.read(buffer, 0, availableBytes);
                dstStream.write(buffer);
                LOGGER.log(System.Logger.Level.INFO, "Iterazione numero " + i++);
            }

            srcStream.close();
            dstStream.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void esercizio2e3(String file) {
        try {
            Scanner scan = new Scanner(System.in);
            DataOutputStream ds = new DataOutputStream(new FileOutputStream(file));

            while (scan.hasNext()) {
                ds.writeInt(scan.nextInt());
            }

            scan.close();
            ds.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
        catch (NoSuchElementException e) {
            System.out.println("Fine lettura da stdin");
        }
        
        try {
            DataInputStream ds = new DataInputStream(new FileInputStream(file));
            while (true) {
                System.out.println(ds.readInt());
            }
        }
        catch (EOFException e) {
            System.out.println("Fine lettura file");
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(3);
        }
        
    }
}