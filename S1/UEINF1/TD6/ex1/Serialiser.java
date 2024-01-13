package TD6.ex1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialiser {
    public void enregistrerPersonne(Personne personne, String fichier) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichier))) {
            out.writeObject(personne);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}