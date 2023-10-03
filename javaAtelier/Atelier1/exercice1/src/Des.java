import java.util.*;

public class Des {

    private String nom = "Dé";
    private int nbFaces;
    private final static int MAXFACE = 120;
    private final static int MINFACE = 3;
    static int counter;
    private static Random r = new Random(); 


    // The code `public Des(){ this.nbFaces = 6; counter ++; }` is a constructor for the `Des` class.
    public Des(){
        this.nbFaces = 6;
        counter ++;
    }
    
    // The code `public Des(int nbFaces){ setNbFace(nbFaces); this.nom += counter; counter ++; }` is a
    // constructor for the `Des` class that takes an integer parameter `nbFaces`.
    public Des(int nbFaces){
        setNbFace(nbFaces);
        this.nom += counter;
        counter ++;
    }

    // The code `public Des(String nom){ ... }` is a constructor for the `Des` class that takes a
    // `String` parameter `nom`.
    public Des(String nom){
        if(nom != null && nom != ""){
            this.nom = nom;
        }
        else{
            this.nom += counter;
        }
        this.nbFaces = MINFACE;
        counter ++;
    }
    
   /**
    * The function sets the number of faces for a given object, but only if the number is between 3 and
    * 120.
    * 
    * @param nbFaces The parameter nbFaces represents the number of faces on a dice.
    */
    public void setNbFace(int nbFaces){
        if (nbFaces >= MINFACE && nbFaces <= MAXFACE){
            this.nbFaces = nbFaces;
        }
        else{
            System.err.println("Le nombre de faces n'est pas compris entre 3 et 120. Veuillez recommencer.");
        }
    }    

    /**
     * The function returns the number of faces of an object.
     * 
     * @return The method is returning the value of the variable "nbFaces".
     */
    public int getNbFace(){
        return this.nbFaces;
    }

   /**
    * The function "getNom" returns the value of the "nom" variable.
    * 
    * @return The method is returning the value of the variable "nom".
    */
    public String getNom(){
        return this.nom;
    }

   /**
    * The function "lancer" generates a random number between 1 and the number of faces on a dice.
    * 
    * @return The method is returning a randomly generated integer between 1 and the number of faces on
    * the dice.
    */
    public int lancer(){
        int nbAleatoire = r.nextInt(this.nbFaces)+1;
        return nbAleatoire;
    }

    /**
     * The function "lancer" takes an integer as input and returns the highest value obtained from
     * multiple dice rolls.
     * 
     * @param nombre The parameter "nombre" represents the number of times the method "lancer" will be
     * called.
     * @return The method is returning the highest result obtained from calling the "lancer" method
     * multiple times.
     */
    public int lancer(int nombre){
        int res = 0, resMeilleurLance = 0, i = 0;

        while (i <= nombre){
            res = this.lancer();
            if(res > resMeilleurLance){
                resMeilleurLance = res;
            }
            i++;
        }

        return resMeilleurLance;
    }

    /**
     * The function returns the value of the counter variable.
     * 
     * @return The method is returning the value of the variable "counter".
     */
    public static int getNbDes(){
        return counter;
    }

   /**
    * The toString() function returns a string representation of an object, including the name, number
    * of faces, and number of dice.
    * 
    * @return The method is returning a string representation of an object. The returned string
    * includes the name, number of faces, and number of dice.
    */
    public String toString(){
        return  "Nom : " + nom + "\n" +
                "Nombre de faces :" + nbFaces + " \n" +
                "Nombre de dés : "+ counter+ " \n";
    }

    /**
     * The function checks if two objects are equal based on their number of faces.
     * 
     * @param obj The "obj" parameter is an object of type Object, which is the superclass of all other
     * classes in Java. It represents the object that is being compared for equality with the current
     * object.
     * @return The method is returning a boolean value.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Des other = (Des) obj;
        return nbFaces == other.nbFaces ;
    }


}
