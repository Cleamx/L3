package TD2.ex2;

public class ScooterElec extends Scooter {
   
    public ScooterElec(int puissance, String modele, String couleur){
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
