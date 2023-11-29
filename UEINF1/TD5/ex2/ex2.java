package TD5.ex2;

import java.io.BufferedReader;
import java.io.FileReader;

public class ex2 {
     public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("TD5/textLong.txt");
            BufferedReader br = new BufferedReader(fr);
            String c;
            long startTime = System.currentTimeMillis();
            while ((c = br.readLine()) != null) {
                System.out.print(c);
            }
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("Le programme a lu le fichier en " + duration + " millisecondes");
            fr.close();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

