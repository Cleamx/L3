package TD10;
public class Figure2D {
    protected int nbCote;
    protected String nomFigure;
    public static int nbFigure = 0;

    public Figure2D(int nbCote, String nomFigure) {
        this.nbCote = nbCote;
        this.nomFigure = nomFigure;
        nbFigure += 1;
    }

    public Figure2D(String nomFigure){
        this.nomFigure = nomFigure;
        nbFigure += 1;
    }

    public static int getNbFigure() {
        return nbFigure;
    }

}
