package TD2.ex2;

/**
 * La classe abstraite Scooter représente un scooter générique avec des attributs de puissance, de
 * modèle et de couleur, et inclut une méthode abstraite pour afficher ses caractéristiques.
 */
public abstract class Scooter {
    public int puissance;
    public String modele, couleur;
    
    // Le code `public Scooter(int puissance, String modele, String couleur)` est un constructeur pour
    // la classe Scooter. Il prend trois paramètres : `puissance`, `modele` et `couleur`.
    public Scooter(int puissance, String modele, String couleur){
        this.puissance = puissance;
        this.modele = modele;
        this.couleur = couleur;
    }

    // La ligne `public abstract afficher voidCaracteristique();` déclare une méthode abstraite nommée
    // `afficherCaracteristique()`.
    public abstract void afficherCaracteristique();
}
