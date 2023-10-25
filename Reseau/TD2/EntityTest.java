package TD2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class EntityTest {
    public static void main(String [] args) {
        Entity2D ent_1 = new Entity2D("test1", 0.0f, 0.0f);

        ent_1.putItem(5);
        ent_1.putItem(7);
        ent_1.putItem(-1);
        ObjectOutputStream oos = null;

        try{
            FileOutputStream fichier = new FileOutputStream("donnees.Ser");

            oos = new ObjectOutputStream(fichier);
            oos.writeObject(ent_1);
            oos.flush();
            oos.close();
            fichier.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        File saved = new File("donnees.ser");
        System.out.println("Taille du fichier : " + saved.length() + " octets");
        System.out.println(ent_1);

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

            // Sérialisation en utilisant la méthode toBytes
            ent_1.toBytes(dataOutputStream);

            // Afficher la taille du paquet transféré
            int packetSize = byteArrayOutputStream.size();
            System.out.println("Taille du fichier transféré : " + packetSize + " octets");

            // nous pouvons maintenant envoyer byteArrayOutputStream.toByteArray() sur le réseau.

            // Exemple de désérialisation (lecture du paquet)
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            Entity2D deserializedEntity = Entity2D.fromBytes(dataInputStream);

            System.out.println("Entity2D (désérialiser) :  " + deserializedEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   
}
