package TD10;


public class Cercle extends Figure2D{
    protected int rayon;

    public Cercle(int rayon, String nomFigure){
        super(nomFigure);
        this.rayon = rayon;
    }

    public double Perimetre(){
        return this.rayon * Math.PI * 2;
    }

    public double Aire(){
        return Math.PI * Math.pow(this.rayon, 2);
    }
    
}
