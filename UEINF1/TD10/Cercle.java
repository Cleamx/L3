package TD10;


/**
 * La classe `Cercle` représente un cercle et fournit des méthodes pour calculer son périmètre et son
 * aire.
 */
public class Cercle extends Figure2D{
    protected int rayon;

    // Le code `public Cercle(int rayon, String nomFigure){ super(nomFigure); this.rayon = rayonne; }`
    // est un constructeur pour la classe `Cercle`.
    public Cercle(int rayon, String nomFigure){
        super(nomFigure);
        this.rayon = rayon;
    }

   /**
    * La fonction calcule et renvoie le périmètre d'un cercle en fonction de son rayon.
    * 
    * @return La méthode renvoie le périmètre d'un cercle.
    */
    public double Perimetre(){
        return this.rayon * Math.PI * 2;
    }

   /**
    * La fonction ci-dessus calcule l'aire d'un cercle en utilisant la formule A = πr^2.
    * 
    * @return La méthode renvoie l'aire d'un cercle, qui est calculée en multipliant pi (π) par le
    * carré du rayon.
    */
    public double Aire(){
        return Math.PI * Math.pow(this.rayon, 2);
    }
    
}
