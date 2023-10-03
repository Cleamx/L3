public class DesPipes extends Des {

    private int borneMin;

   
    // un constructeur pour la classe `DesPipes`.
    public DesPipes(int nbFaces, String nom, int borneMin){
        
        super(nbFaces);
        setBorneMin(borneMin);

    }

   
    /**
     * La fonction "getBorneMin" renvoie la valeur de la variable "borneMin".
     * 
     * @return La méthode renvoie la valeur de la variable "borneMin".
     */
    public int getBorneMin(){
        return borneMin;
    }

    /**
     * La fonction définit la valeur minimale d'une plage, mais uniquement si elle se situe dans la
     * plage valide de 1 au nombre de faces.
     * 
     * @param borneMin Le paramètre « borneMin » est une valeur entière représentant la valeur minimale
     * pouvant être lancée sur un dé.
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
     * La fonction "lancer" génère un nombre aléatoire jusqu'à ce qu'il soit supérieur à une valeur
     * minimale spécifiée.
     * 
     * @return La méthode renvoie la valeur de la variable "resultat".
     */
    public int lancer(){
        int resultat;

        do{
            resultat = super.lancer();
        }while (resultat <= borneMin);

        return resultat;
    }
}
