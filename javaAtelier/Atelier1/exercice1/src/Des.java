import java.util.*;

public class Des {

    private String nom = "Dé";
    private int nbFaces;
    private final static int MAXFACE = 120;
    private final static int MINFACE = 3;
    static int counter;


    public Des(){
        this.nbFaces = 6;
        counter ++;
    }
    
    public Des(int nbFaces){
        setNbFace(nbFaces);
        this.nom += counter;
        counter ++;
    }

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
    
    public void setNbFace(int nbFaces){
        if (nbFaces >= MINFACE && nbFaces <= MAXFACE){
            this.nbFaces = nbFaces;
        }
        else{
            System.err.println("Le nombre de faces n'est pas compris entre 3 et 120. Veuillez recommencer.");
        }
    }    

    public int getNbFace(){
        return this.nbFaces;
    }

    public String getNom(){
        return this.nom;
    }

    public int lancer(){
        Random r = new Random();
        int nbAleatoire = r.nextInt(this.nbFaces)+1;
        return nbAleatoire;
    }

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

    public static int getNbDes(){
        return counter;
    }

    public String toString(){
        return  "Nom : " + nom + "\n" +
                "Nombre de faces :" + nbFaces + " \n" +
                "Nombre de dés : "+ counter;
    }
}
