package TD10;

/**
 * La classe Figure2D représente une figure bidimensionnelle.
 */
public class Figure2D {
    protected int nbCote;
    protected String nomFigure;
    public static int nbFigure = 0;

    // Le code `public Figure2D(int nbCote, String nomFigure)` est un constructeur pour la classe
    // `Figure2D` qui prend deux paramètres : `nbCote` et `nomFigure`.
    public Figure2D(int nbCote, String nomFigure) {
        this.nbCote = nbCote;
        this.nomFigure = nomFigure;
        nbFigure += 1;
    }
    

    // Le code « public Figure2D(String nomFigure) » est un constructeur pour la
    // classe Figure2D qui
    // prend un paramètre String appelé « nomFigure ».
    public Figure2D(String nomFigure) {
        this.nomFigure = nomFigure;
        nbFigure += 1;
    }

    /**
     * La fonction "getNbFigure" renvoie la valeur de la variable "nbFigure".
     * 
     * @return La méthode renvoie la valeur de la variable "nbFigure".
     */
    public static int getNbFigure() {
        return nbFigure;
    }

}
