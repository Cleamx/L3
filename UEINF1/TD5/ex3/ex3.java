package TD5.ex3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

public class ex3 {
    public static void main(String[] args) throws IOException {

 
        FileInputStream fis = new FileInputStream(new File("TD5/textLong.txt"));
        FileChannel fc = fis.getChannel();
        int size = (int) fc.size();

        ByteBuffer bBuff = ByteBuffer.allocate(size);

        long startTime = System.currentTimeMillis();

        // Lecture du contenu du fichier dans le buffer
        fc.read(bBuff);
        bBuff.flip();
        // Conversion du contenu du buffer en chaîne de caractères

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Le programme a lu le fichier en " + duration + " millisecondes");
        fis.close();
    }
}
