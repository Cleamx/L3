public class DesPipes extends Des {

    private int borneMin;

   // The code is defining a constructor for the `DesPipes` class. It takes three parameters:
   // `nbFaces`, `nom`, and `borneMin`.
    public DesPipes(int nbFaces, String nom, int borneMin){
        
        super(nbFaces);
        setBorneMin(borneMin);

    }

   /**
    * The function "getBorneMin" returns the value of the variable "borneMin".
    * 
    * @return The method is returning the value of the variable "borneMin".
    */
    public int getBorneMin(){
        return borneMin;
    }

    /**
     * The function sets the minimum value for a range, but only if it is within the valid range of 1
     * to the number of faces.
     * 
     * @param borneMin The parameter "borneMin" is an integer value representing the minimum value that
     * can be rolled on a dice.
     */
    private void setBorneMin(int borneMin){
        if(borneMin >= 1 && borneMin <= super.getNbFace()){
            this.borneMin = borneMin;
        }
        else{
            System.err.println("Erreur : la borne minimale doit être compris entre 1 et le nombre de faces");
        }
    }

    /**
     * The function "lancer" generates a random number until it is greater than a specified minimum
     * value.
     * 
     * @return The method is returning the value of the variable "resultat".
     */
    public int lancer(){
        int resultat;

        do{
            resultat = super.lancer();
        }while (resultat <= borneMin);

        return resultat;
    }
}
