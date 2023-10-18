package TD10;

/**
 * La classe Rectangle est une sous-classe de Figure2D et représente une forme de rectangle
 * bidimensionnel.
 */
public class Rectangle extends Figure2D {
    protected int longeur;
    protected int largeur;
    protected static final int nbCote = 4;

    // Le constructeur `public Rectangle(int longeur, String nomFigure, int largeur)` est utilisé pour
    // créer une nouvelle instance de la classe Rectangle. Il prend trois paramètres : `longeur`
    // (longueur), `nomFigure` (nom de la figure) et `largeur` (largeur).
    public Rectangle(int longeur, String nomFigure, int largeur){
        super(nbCote, nomFigure);
        this.longeur = longeur;
        this.largeur = largeur;
    }

    /**
     * La fonction calcule le périmètre d'un rectangle.
     * 
     * @return La méthode renvoie le périmètre d'un rectangle.
     */
    public int Perimetre(){
        return (this.longeur + this.largeur) * 2;
    }

    /**
     * La fonction calcule l'aire d'un rectangle.
     * 
     * @return La méthode renvoie le produit de la longueur et de la largeur d'un objet.
     */
    public int Aire(){
        return (this.longeur * this.largeur);
    }
    
}
