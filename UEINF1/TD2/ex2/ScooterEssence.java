package TD2.ex2;

/**
 * La classe ScooterEssence étend la classe Scooter et remplace la méthode afficherCaracteristique pour
 * afficher la puissance, le modèle et la couleur du scooter.
 */
public class ScooterEssence extends Scooter{

    public ScooterEssence(int puissance, String modele, String couleur){
        super(puissance, modele, couleur);
    }

    @Override
    public void afficherCaracteristique() {
       System.out.println("Puissance : "+ this.puissance +
        "\nModèle : "+ this.modele
        + "\nCouleur : "+ this.couleur
       );
    }
    
}
