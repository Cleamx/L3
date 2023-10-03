package Atelier1.exercice2;

public class entier {
    private int valeur;
    private final int borneMin;
    private final int borneMax;

   // The `public entier(int borneMin, int borneMax)` constructor is initializing a new instance of the
   // `entier` class. It takes two parameters, `borneMin` and `borneMax`, which represent the minimum
   // and maximum values that the `valeur` variable can have.
    public entier(int borneMin, int borneMax){
        this.borneMax = borneMax;
        this.borneMin = borneMin;
        this.valeur = 0;
    }

   // The `public entier(int borneMin, int borneMax, int valeur)` constructor is initializing a new
   // instance of the `entier` class. It takes three parameters: `borneMin`, `borneMax`, and `valeur`.
    public entier(int borneMin, int borneMax, int valeur){
        this(borneMin, borneMax);
        this.valeur = valeur;
    }

   /**
    * The function sets the value of a variable if it falls within a specified range.
    * 
    * @param valeur The parameter "valeur" is an integer value that is being passed to the method.
    */
    public void setValeur(int valeur){
        if (valeur >= borneMin && valeur <= borneMax){
            this.valeur = valeur;
        }
    }

   /**
    * The function "incremente" increments the value by 1 if it is less than the maximum bound.
    */
    public void incremente() {
        if (valeur < borneMax) {
            valeur++;
        }
    }

   /**
    * The function increments the value by a given number if the sum is less than or equal to a maximum
    * limit.
    * 
    * @param n The parameter "n" is an integer value that represents the amount by which the "valeur"
    * variable should be incremented.
    */
    public void incremente(int n) {
        if (valeur + n <= borneMax) {
            valeur += n;
        }
    }

    /**
     * The toString() function returns the integer value as a string.
     * 
     * @return The method is returning the value of the variable "valeur" as a string.
     */
    public String toString() {
        return Integer.toString(valeur);
    }
   
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        entier other = (entier) obj;
        return valeur == other.valeur && borneMin == other.borneMin && borneMax == other.borneMax;
    }
    

    
}
