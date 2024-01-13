package TD2.ex2;

/**
 * La classe `Automobile` est une classe abstraite qui représente une automobile générique et contient
 * des attributs tels que la puissance, l'espace, le modèle et la couleur, ainsi qu'une méthode
 * abstraite `afficherCaracteristique()` qui doit être implémentée dans une sous-classe.
 */
public abstract class Automobile {
    public int puissance, espace;
    public String modele, couleur;
    
    // The code `public Automobile(int puissance, int espace, String modele, String couleur)` is a
    // constructor for the `Automobile` class. It takes four parameters: `puissance`, `espace`,
    // `modele`, and `couleur`.
    public Automobile(int puissance, int espace, String modele, String couleur){
        this.puissance = puissance;
        this.espace = espace;
        this.modele = modele;
        this.couleur = couleur;
    }

    /**
     * La fonction "afficherCaracteristique" est une méthode abstraite qui n'a pas d'implémentation et
     * doit être surchargée dans une sous-classe.
     */
    public abstract void afficherCaracteristique();

}
