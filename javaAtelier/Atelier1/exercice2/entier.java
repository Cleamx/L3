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
        int n = 1;
        if (valeur + n <= borneMax) {
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
    * La fonction vérifie si l'objet actuel est égal à un autre objet de la même classe en comparant
    * leurs valeurs et leurs limites.
    * 
    * @param obj Le paramètre "obj" est un objet de type Objet, ce qui signifie qu'il peut s'agir de
    * n'importe quel type d'objet. Dans cette méthode, on vérifie si le paramètre "obj" est nul et s'il
    * s'agit d'une instance de la classe "Entier". Si les deux conditions sont vraies, la méthode
    * @return La méthode renvoie une valeur booléenne.
    */
    public boolean equals(Object obj) {
        boolean result = false;
        if ((obj != null) && (obj instanceof Entier)) {
            Entier other = (Entier) obj;
            result = (valeur == other.valeur) && (borneMin == other.borneMin) && (borneMax == other.borneMax);
        }   
        return result;
    }    
}
