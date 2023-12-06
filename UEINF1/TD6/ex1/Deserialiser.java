package TD6.ex1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialiser {
    
    public Personne lirePersonne(String fichier) {
        Personne p = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichier))) {
            p = (Personne) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }
}
