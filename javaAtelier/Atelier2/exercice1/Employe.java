package Atelier2.exercice1;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Employe extends Personne {
    float salaire;
    private final GregorianCalendar dateEmbauche;
    
   
   // Le constructeur `private Employe` est utilisé pour créer une nouvelle instance de la classe
   // `Employe`. Il prend plusieurs paramètres tels que `leNom`, `lePrenom`, `j`, `m`, `a`, `numero`,
   // `rue`, `code_postal`, `ville`, `salaire`, `jours`, `mois` et `annee`.
    private Employe(String leNom, String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville, float salaire, int jours, int mois, int annee){
        super(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville);
        this.dateEmbauche = new GregorianCalendar(annee,mois,jours);
        this.salaire = salaire;
    }

    /**
     * La fonction calcule le nombre d'années entre la date d'embauche d'un employé et sa date de
     * naissance.
     * 
     * @param dateEmbauche Le paramètre « dateEmbauche » représente la date d'embauche d'un salarié. Il
     * est de type GregorianCalendar.
     * @param dateNaissGregorianCalendar Le paramètre « dateNaissGregorianCalendar » représente la date
     * de naissance d'un salarié. Il est de type GregorianCalendar.
     * @return La méthode renvoie le nombre d'années entre la date d'emploi (dateEmbauche) et la date
     * de naissance (dateNaissGregorianCalendar) d'un employé.
     */
    private static long verifDateEmploye(GregorianCalendar dateEmbauche, GregorianCalendar dateGregorianCalendar){
        long res;
        long difference =  dateEmbauche.getTimeInMillis() - dateGregorianCalendar.getTimeInMillis();
        res =  (difference / (24 * 60 * 60 * 1000));
        return (res/365);
    }

    /**
     * La fonction "CreateEmploye" crée un nouvel objet employé si son âge est compris entre 16 et 65 ans.
     * 
     * @param leNom Le nom de famille de l'employé.
     * @param lePrenom Le paramètre « lePrenom » représente le prénom du salarié.
     * @param j Le paramètre « j » représente le jours de naissance du salarié.
     * @param m Le paramètre « m » représente le mois de naissance du salarié.
     * @param a Le paramètre « a » représente l'année de naissance du salarié.
     * @param numero Le paramètre « numero » représente le numéro de rue du salarié.
     * @param rue Le paramètre « rue » représente l'adresse postale du salarié.
     * @param code_postal Le paramètre « code_postal » représente le code postal de l'adresse du salarié.
     * @param ville Le paramètre « ville » représente la ville où réside le salarié.
     * @param salaire Le paramètre « salaire » représente le salaire du salarié. Il est de type float,
     * ce qui signifie qu'il peut stocker des valeurs décimales.
     * @param jours Le paramètre « jours » représente le jour du mois de naissance du salarié.
     * @param mois Le paramètre « mois » représente le mois de naissance du salarié.
     * @param annee Le paramètre « année » représente l'année de naissance du salarié.
     * @return La méthode renvoie une instance de la classe Employer.
     */
    public static Employe CreateEmploye(String leNom, String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville, float salaire, int jours, int mois, int annee){
        GregorianCalendar dateEmbauche = new GregorianCalendar(annee,mois,jours);
        GregorianCalendar dateNaissance = new GregorianCalendar(a, m, j);
        Employe nvEmploye;
        if(verifDateEmploye(dateEmbauche, dateNaissance) > 16 && verifDateEmploye(dateEmbauche, dateNaissance) < 65){
            nvEmploye = new Employe(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville, salaire, jours, mois, annee);
        }
        else{
            nvEmploye = null;
        }
        return nvEmploye;
    }

   /**
    * La fonction « augmenterSalaire » augmente le salaire d'un salarié d'un pourcentage donné.
    * 
    * @param augmentation Le paramètre « augmentation » est une valeur flottante représentant le
    * pourcentage d'augmentation du salaire.
    */
    public void augmenterSalaire(float augmentation){
        float tampon;
        if(augmentation > 0){
            tampon = this.salaire * (augmentation/100);
            this.salaire = tampon + this.salaire;
        }
    }

   public long calculAnnuite(){
    GregorianCalendar dateNow = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
    return verifDateEmploye(dateNow, this.dateEmbauche) + 1;
    
   }

}
