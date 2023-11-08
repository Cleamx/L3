package TD2.ex2;

public class AutomobileEssence extends Automobile{
    
    public AutomobileEssence(int puissance, int espace, String modele, String couleur){
        super(puissance, espace, modele, couleur);
    }

    @Override
    public void afficherCaracteristique() {
       System.out.println("Puissance : "+ this.puissance +
        "\nEspace : " + this.espace + "\nModèle : "+ this.modele
        + "\nCouleur : "+ this.couleur
       );
    }
}
