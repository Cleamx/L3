package TD10;

public class Rectangle extends Figure2D {
    protected int longeur;
    protected int largeur;
    protected static final int nbCote = 4;

    public Rectangle(int longeur, String nomFigure, int largeur){
        super(nbCote, nomFigure);
        this.longeur = longeur;
        this.largeur = largeur;
    }

    public int Perimetre(){
        return (this.longeur + this.largeur) * 2;
    }

    public int Aire(){
        return (this.longeur * this.largeur);
    }
    
}
