import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Open_Save {
    /**
     * Ouvre un fichier de sauvegarde et retourne un objet de type Dresseur.
     * 
     * @param fichier le chemin du fichier de sauvegarde
     * @return un objet de type Dresseur ou null si une erreur s'est produite
     */
    public Dresseur ouvrirSave(String fichier) {
        Dresseur d = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichier))) {
            d = (Dresseur) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return d;
    }
}
