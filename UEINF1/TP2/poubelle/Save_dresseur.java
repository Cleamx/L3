import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Cette classe permet d'enregistrer un objet Dresseur dans un fichier.
 */
public class Save_dresseur {
    /**
     * Enregistre un objet Dresseur dans un fichier.
     * 
     * @param personne l'objet Dresseur à enregistrer
     * @param fichier le chemin du fichier dans lequel enregistrer l'objet
     */
    public void enregistrerDresseur(Dresseur personne, String fichier) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichier))) {
            out.writeObject(personne);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}