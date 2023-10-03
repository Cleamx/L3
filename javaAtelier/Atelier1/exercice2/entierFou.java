package Atelier1.exercice2;
import java.util.Random;

public class entierFou extends entier {

    private int niveauFolie;
    private Random random = new Random();

    // Le code définit un constructeur pour la classe `entierFou`.
    public entierFou(int borneMin, int borneMax, int niveauFolie){
        super(borneMin,borneMax);
        this.niveauFolie = niveauFolie;
    }

    // Le code définit un constructeur pour la classe `entierFou`. Ce constructeur prend quatre
    // paramètres : `borneMin`, `borneMax`, `valeur` et `niveauFolie`.
    public entierFou(int borneMin, int borneMax, int valeur, int niveauFolie){
        super(borneMin, borneMax, valeur);
        this.niveauFolie = niveauFolie;
    }
   
    /**
     * La fonction "incremente" incrémente aléatoirement la valeur de "niveauFolie" puis appelle la
     * méthode "incremente" de la superclasse avec la valeur incrémentée.
     */
    public void incremente() {
        int increment = random.nextInt(niveauFolie + 1);
        super.incremente(increment);
    }
}
