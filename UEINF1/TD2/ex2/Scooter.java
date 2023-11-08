package TD2.ex2;

public abstract class Scooter {
    public int puissance;
    public String modele, couleur;
    
    public Scooter(int puissance, String modele, String couleur){
        this.puissance = puissance;
        this.modele = modele;
        this.couleur = couleur;
    }

    public abstract void afficherCaracteristique();
}
