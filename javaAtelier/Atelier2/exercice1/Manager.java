package Atelier2.exercice1;

import java.util.GregorianCalendar;

public class Manager extends Employe {
    public Secretaire sSecretaire;
    private final static float AUGMENTATION_MANAGER = (0.5f);

    // Le code `private Manager(String leNom, String lePrenom, int j, int m, int a,
    // int numero, String
    // rue, String code_postal, String ville, float salaire, int jours, int mois,
    // int annee)` est un
    // constructeur pour la classe `Manager`. Il est utilisé pour créer une nouvelle
    // instance de la
    // classe `Manager` et initialiser ses attributs.
    private Manager(String leNom, String lePrenom, int j, int m, int a, int numero, String rue, String code_postal,
            String ville, float salaire, int jours, int mois, int annee) {
        super(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville, salaire, jours, mois, annee);
    }

    /**
     * La fonction "CreateManager" crée un nouvel objet Manager si l'âge du salarié
     * est compris entre 16
     * et 65 ans.
     * 
     * @param leNom       Le nom de famille du gérant.
     * @param lePrenom    Le prénom du gérant.
     * @param j           Le paramètre « j » représente le jour du mois de la date
     *                    de naissance.
     * @param m           Le paramètre « m » représente le mois de naissance ou la
     *                    date d'embauche.
     * @param a           Le paramètre « a » représente l'année de naissance du
     *                    dirigeant.
     * @param numero      Le paramètre "numero" représente le numéro de rue de
     *                    l'adresse du gestionnaire.
     * @param rue         Le paramètre "rue" représente l'adresse postale du
     *                    gestionnaire.
     * @param code_postal Le paramètre "code_postal" représente le code postal de
     *                    l'adresse du
     *                    gestionnaire.
     * @param ville       Le paramètre « ville » représente la ville où réside ou
     *                    travaille le manager.
     * @param salaire     Le paramètre "salaire" représente le salaire du manager.
     * @param jours       Le paramètre « jours » représente le jour du mois de la
     *                    date de naissance ou de la
     *                    date d'emploi.
     * @param mois        Le paramètre « mois » représente le mois de naissance ou
     *                    la date d'embauche.
     * @param annee       Le paramètre « année » représente l'année de naissance du
     *                    manager.
     * @return La méthode renvoie un objet Manager.
     */
    public static Manager CreateManager(String leNom, String lePrenom, int j, int m, int a, int numero, String rue,
            String code_postal, String ville, float salaire, int jours, int mois, int annee) {
        GregorianCalendar dateEmbauche = new GregorianCalendar(annee, mois, jours);
        GregorianCalendar dateNaissance = new GregorianCalendar(a, m, j);
        Manager nvManager = null;
        if (verifDateEmploye(dateEmbauche, dateNaissance) > 16 && verifDateEmploye(dateEmbauche, dateNaissance) < 65) {
            nvManager = new Manager(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville, salaire, jours, mois,
                    annee);
        }
        return nvManager;
    }

    /**
     * La fonction « augmenterSalaire » augmente le salaire d'un manager d'un
     * certain pourcentage en
     * fonction de ses années de service.
     * 
     * @param augmentation Le paramètre « augmentation » est une valeur flottante
     *                     représentant le
     *                     montant dont le salaire doit être augmenté.
     */
    public void augmenterSalaire(float augmentation) {
        long annuite = this.calculAnnuite();
        float resAugmentation = augmentation + (annuite * AUGMENTATION_MANAGER);
        super.augmenterSalaire(resAugmentation);
    }

    /**
     * La fonction affecte une secrétaire à un manager et ajoute le manager à la
     * liste des managers du
     * secrétaire.
     * 
     * @param sSecretaire Le paramètre "sSecretaire" est de type "Secretaire", qui
     *                    est une classe
     *                    représentant une secrétaire.
     */
    public void assignerSecretaire(Secretaire sSecretaire) {
        this.sSecretaire = sSecretaire;
        sSecretaire.ajouterManager(this);
    }
}
