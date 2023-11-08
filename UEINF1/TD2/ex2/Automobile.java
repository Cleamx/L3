package TD2.ex2;

public abstract class Automobile {
    public int puissance, espace;
    public String modele, couleur;
    
    public Automobile(int puissance, int espace, String modele, String couleur){
        this.puissance = puissance;
        this.espace = espace;
        this.modele = modele;
        this.couleur = couleur;
    }

    public abstract void afficherCaracteristique();

}
