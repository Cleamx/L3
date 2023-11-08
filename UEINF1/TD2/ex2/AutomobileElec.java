package TD2.ex2;

/**
 * La classe AutomobileElec est une sous-classe de la classe Automobile et remplace la méthode
 * afficherCaracteristique() pour afficher la puissance, l'espace, le modèle et la couleur d'un objet.
 */
public class AutomobileElec extends Automobile {
    
    public AutomobileElec(int puissance, int espace, String modele, String couleur){
        super(puissance, espace, modele, couleur);
    }

    /**
     * La fonction afficherCaracteristique() affiche la puissance, l'espace, le modèle et la couleur
     * d'un objet.
     */
    @Override
    public void afficherCaracteristique() {
       System.out.println("Puissance : "+ this.puissance +
        "\nEspace : " + this.espace + "\nModèle : "+ this.modele
        + "\nCouleur : "+ this.couleur
       );
    }
}
