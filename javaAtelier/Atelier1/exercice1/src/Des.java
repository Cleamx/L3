import java.util.*;

public class Des {

    private String nom = "Dé";
    private int nbFaces;
    private final static int MAXFACE = 120;
    private final static int MINFACE = 3;
    static int counter;
    private static Random r = new Random(); 



    // Le code `public Des(){ this.nbFaces = 6; compteur ++ ; }` est un constructeur pour la classe
    // `Des` qui ne prend aucun paramètre. Il initialise la variable `nbFaces` à 6 et incrémente la
    // variable `counter` de 1. Ce constructeur est utilisé pour créer un objet `Des` par défaut avec 6
    // faces.
    public Des(){
        this.nbFaces = 6;
        counter ++;
    }
    
    
   // Le code `public Des(int nbFaces){ setNbFace(nbFaces); this.nom += compteur ; compteur ++ ; }` est
   // un constructeur pour la classe `Des` qui prend un paramètre entier `nbFaces`.
    public Des(int nbFaces){
        setNbFace(nbFaces);
        this.nom += counter;
        counter ++;
    }

    
    // Le code `public Des(String nom){ ... }` est un constructeur pour la classe `Des` qui prend un
    // paramètre de type String `nom`.
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
     * La fonction définit le nombre de faces d'un objet, mais uniquement si le nombre est compris
     * entre 3 et 120.
     * 
     * @param nbFaces Le paramètre nbFaces représente le nombre de faces d'un dé.
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
     * La fonction renvoie le nombre de faces d'un objet.
     * 
     * @return La méthode renvoie la valeur de la variable "nbFaces".
     */
    public int getNbFace(){
        return this.nbFaces;
    }

  
   /**
    * La fonction "getNom" renvoie la valeur de la variable "nom".
    * 
    * @return La méthode renvoie la valeur de la variable "nom".
    */
    public String getNom(){
        return this.nom;
    }

   
    /**
     * La fonction "lancer" génère un nombre aléatoire compris entre 1 et le nombre de faces d'un dé.
     * 
     * @return La méthode renvoie un entier généré aléatoirement entre 1 et le nombre de faces sur les
     * dés.
     */
    public int lancer(){
        int nbAleatoire = r.nextInt(this.nbFaces)+1;
        return nbAleatoire;
    }

    
    /**
     * La fonction "lancer" prend un entier en entrée et renvoie la valeur la plus élevée obtenue à
     * partir de plusieurs lancers de dés.
     * 
     * @param nombre Le paramètre "nombre" représente le nombre de fois que la méthode "lancer" sera
     * appelée.
     * @return La méthode renvoie le résultat le plus élevé obtenu à partir d’une série de lancers de
     * dés.
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
     * La fonction renvoie la valeur de la variable compteur.
     * 
     * @return La méthode renvoie la valeur de la variable "counter".
     */
    public static int getNbDes(){
        return counter;
    }

   
    /**
     * La fonction toString() renvoie une représentation sous forme de chaîne d'un objet, comprenant le
     * nom, le nombre de faces et le nombre de dés.
     * 
     * @return La méthode renvoie une représentation sous forme de chaîne d'un objet. La chaîne
     * renvoyée inclut le nom, le nombre de faces et le nombre de dés.
     */
    public String toString(){
        return  "Nom : " + nom + "\n" +
                "Nombre de faces :" + nbFaces + " \n" +
                "Nombre de dés : "+ counter+ " \n";
    }

    
    /**
     * La fonction vérifie si deux objets sont égaux en fonction de leur nombre de faces.
     * 
     * @param obj Le paramètre "obj" est un objet de type Object, qui est la superclasse de toutes les
     * autres classes Java. Il représente l'objet dont l'égalité est comparée à l'objet actuel.
     * @return La méthode renvoie une valeur booléenne.
     */
    public boolean equals(Object obj) {
        boolean result = false;
        if ((obj == null) && (obj instanceof Des)) {
            Des other = (Des) obj;
            result = (this.nbFaces == other.nbFaces) && (this.nom.equals(other.nom)) ;
        }
        return result;
    }


}
