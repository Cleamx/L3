package TD5.ex1;

import java.io.FileReader;

public class ex1 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("TD5/testex1.txt");
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}