package TD2.ex2;
/**
 * La classe ScooterElec est une sous-classe de la classe Scooter qui ajoute une méthode supplémentaire
 * pour afficher la puissance, le modèle et la couleur d'un objet.
 */

public class ScooterElec extends Scooter {
   
    public ScooterElec(int puissance, String modele, String couleur){
        super(puissance, modele, couleur);
    }

    /**
     * La fonction afficherCaracteristique() imprime la puissance, le modèle et la couleur d'un objet.
     */
    @Override
    public void afficherCaracteristique() {
       System.out.println("Puissance : "+ this.puissance +
         "\nModèle : "+ this.modele
        + "\nCouleur : "+ this.couleur
       );
    }
}
