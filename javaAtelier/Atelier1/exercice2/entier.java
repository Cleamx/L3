package Atelier1.exercice2;

public class Entier {
    private int valeur;
    private final int borneMin;
    private final int borneMax;

  
    // Le constructeur `public entier(int borneMin, int borneMax)` initialise une nouvelle instance de
    // la classe `entier`. Il prend deux paramètres : `borneMin` et `borneMax`. À l'intérieur du
    // constructeur, les valeurs « borneMax » et « borneMin » sont affectées aux variables d'instance
    // correspondantes à l'aide du mot-clé « this ». De plus, la variable « valeur » est définie sur 0.
    public Entier(int borneMin, int borneMax){
        this.borneMax = borneMax;
        this.borneMin = borneMin;
        this.valeur = 0;
    }

   
    // Le constructeur `public entier(int borneMin, int borneMax, int valeur)` crée une nouvelle
    // instance de la classe `entier` avec trois paramètres : `borneMin`, `borneMax` et `valeur`.
    public Entier(int borneMin, int borneMax, int valeur){
        this(borneMin, borneMax);
        setValeur(valeur);
    }

   
    /**
     * La fonction définit la valeur d'une variable si elle se situe dans une plage spécifiée.
     * 
     * @param valeur Le paramètre « valeur » est une valeur entière transmise à la méthode.
     */
    public void setValeur(int valeur){
        if (valeur >= borneMin && valeur <= borneMax){
            this.valeur = valeur;
        }
    }

  
    /**
     * La fonction "incremente" incrémente la valeur de 1 si elle est inférieure à la limite maximale.
     */
    public void incremente() {
        if (valeur < borneMax) {
            valeur++;
        }
    }

   
    /**
     * La fonction incrémente la valeur d'un nombre donné si la valeur résultante se situe dans une
     * limite maximale spécifiée.
     * 
     * @param n Le paramètre "n" est une valeur entière qui représente le montant dont la variable
     * "valeur" sera incrémentée.
     */
    public void incremente(int n) {
        if (valeur + n <= borneMax) {
            valeur += n;
        }
    }

   
    /**
     * La fonction toString() renvoie la valeur entière sous forme de chaîne.
     * 
     * @return La méthode renvoie la valeur de la variable "valeur" sous forme de chaîne.
     */
    public String toString() {
        return Integer.toString(valeur);
    }
   
    
    /**
     * La fonction vérifie si deux objets sont égaux en fonction de leurs valeurs et limites.
     * 
     * @param obj Le paramètre "obj" est un objet de type Object, qui est la superclasse de toutes les
     * autres classes Java. Dans cette méthode equals(), elle est utilisée pour comparer l'objet actuel
     * (this) avec un autre objet pour vérifier s'ils sont égaux.
     * @return La méthode renvoie une valeur booléenne.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Entier other = (Entier) obj;
        return valeur == other.valeur && borneMin == other.borneMin && borneMax == other.borneMax;
    }
    

    
}
