public class DesMemoire extends Des {
    private int derniereValeur = -1;

    
    // Le code `public DesMemoire(int nbFaces, String nom) { super(nbFaces); }` est un constructeur
    // pour la classe `DesMemoire`.
    public DesMemoire(int nbFaces, String nom) {
        super(nom,nbFaces);
    }

    /**
     * La fonction "lancer" renvoie un nombre aléatoire, garantissant qu'il n'est pas le même que la
     * valeur précédente.
     * 
     * @return La méthode renvoie une valeur entière.
     */
    public int lancer() {
        int resultat;
        do {
            resultat = super.lancer();
        } while (resultat == derniereValeur); 
        derniereValeur = resultat; 
        return resultat;
    }

}