package TD10;

/**
 * La classe Carré est une sous-classe de Rectangle et représente un carré d'une longueur donnée.
 */
public class Carre extends Rectangle{
    protected int longeur;
    
    // Le code `super(longeur, nomFigure, longeur);` appelle le constructeur de la superclasse
    // (Rectangle) avec les paramètres `longeur`, `nomFigure` et `longeur`. Ceci permet d'initialiser
    // les attributs de la superclasse avec les valeurs passées au constructeur de la classe Carré.
    public Carre(String nomFigure, int longeur){
        super(longeur, nomFigure, longeur);
    }

}
