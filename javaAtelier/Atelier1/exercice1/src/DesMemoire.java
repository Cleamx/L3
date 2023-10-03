public class DesMemoire extends Des {
    private int derniereValeur = -1;

    // The code `public DesMemoire(int nbFaces, String nom) { super(nbFaces); }` is a constructor for
    // the `DesMemoire` class.
    public DesMemoire(int nbFaces, String nom) {
        super(nbFaces);
    }


 /**
  * La fonction "lancer" retourne un nombre aléatoire, en regardant que le resultat ne soit pas le même que 
  * le dernier lancer.
  * @return La méthode renvoie un entier, c'est le resultat du lancer de dés.
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