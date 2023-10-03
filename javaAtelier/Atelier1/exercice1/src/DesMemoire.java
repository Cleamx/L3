public class DesMemoire extends Des {
    private int derniereValeur = -1;

    public DesMemoire(int nbFaces, String nom) {
        super(nbFaces);
    }


    public int lancer() {
        int resultat;
        do {
            resultat = super.lancer();
        } while (resultat == derniereValeur); 
        derniereValeur = resultat; 
        return resultat;
    }

    public static void main(String[] args) {

        DesMemoire deMemoire = new DesMemoire(6, "Dé à effet mémoire");
        for (int i = 0; i < 10; i++) {
            System.out.println(deMemoire.getNom() + " a été lancé : " + deMemoire.lancer());
        }
    }
}