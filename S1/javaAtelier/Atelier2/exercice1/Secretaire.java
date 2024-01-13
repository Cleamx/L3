package Atelier2.exercice1;

import java.util.GregorianCalendar;
import java.util.List;

public class Secretaire extends Employe {
    private final static float AUGMENTATION_SECRETAIRE = (0.1f);
    private List<Manager> chefs;

    // Le constructeur `private Secretaire` est utilisé pour créer une nouvelle
    // instance de la classe
    // `Secretaire`. Il prend plusieurs paramètres tels que `leNom` (nom),
    // `lePrenom` (prénom), `j`
    // (jour de naissance), `m` (mois de naissance), `a` (année de naissance), `
    // numero` (numéro de
    // rue), `rue` (nom de la rue), `code_postal` (code postal), `ville` (ville),
    // `salaire` (salaire),
    // `jours` (jour d'embauche), `mois` ( mois d'embauche) et « année » (année
    // d'embauche).
    private Secretaire(String leNom, String lePrenom, int j, int m, int a, int numero, String rue, String code_postal,
            String ville, float salaire, int jours, int mois, int annee) {
        super(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville, salaire, jours, mois, annee);
    }

    /**
     * La fonction crée une nouvelle instance de la classe Secrétaire si l'âge de
     * l'employé est compris
     * entre 16 et 65 ans.
     * 
     * @param leNom       Le nom de famille du secrétaire.
     * @param lePrenom    Le prénom du secrétaire.
     * @param j           Le paramètre « j » représente le jour du mois de la date
     *                    de naissance.
     * @param m           Le paramètre « m » représente le mois de naissance de la
     *                    secrétaire.
     * @param a           Le paramètre « a » représente l'année de naissance du
     *                    secrétaire.
     * @param numero      Le paramètre "numéro" représente le numéro de rue de
     *                    l'adresse du secrétaire.
     * @param rue         Le paramètre "rue" représente l'adresse postale de la
     *                    secrétaire.
     * @param code_postal Le paramètre "code_postal" représente le code postal de
     *                    l'adresse de la
     *                    secrétaire.
     * @param ville       Le paramètre « ville » représente la ville où réside le
     *                    secrétaire.
     * @param salaire     Le salaire du secrétaire.
     * @param jours       Le paramètre « jours » représente le jour du mois
     *                    correspondant à la date de
     *                    naissance du secrétaire.
     * @param mois        Le paramètre « mois » représente le mois de naissance ou
     *                    la date d'embauche de la
     *                    secrétaire.
     * @param annee       L'année de la date d'embauche du secrétaire.
     * @return La méthode renvoie une instance de la classe Secretaire.
     */
    public static Secretaire CreateSecretaire(String leNom, String lePrenom, int j, int m, int a, int numero,
            String rue, String code_postal, String ville, float salaire, int jours, int mois, int annee) {
        GregorianCalendar dateEmbauche = new GregorianCalendar(annee, mois, jours);
        GregorianCalendar dateNaissance = new GregorianCalendar(a, m, j);
        Secretaire nvSecretaire = null;
        if (verifDateEmploye(dateEmbauche, dateNaissance) > 16 && verifDateEmploye(dateEmbauche, dateNaissance) < 65) {
            nvSecretaire = new Secretaire(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville, salaire, jours,
                    mois, annee);
        }
        return nvSecretaire;
    }

    /**
     * La fonction « augmenterSalaire » augmente le salaire d'un salarié d'un
     * montant déterminé, en
     * tenant compte du nombre de chefs.
     * 
     * @param augmentation Le paramètre « augmentation » est une valeur flottante
     *                     représentant le
     *                     montant dont le salaire doit être augmenté.
     */
    public void augmenterSalaire(float augmentation) {
        float resAugmentation = augmentation + (chefs.size() * AUGMENTATION_SECRETAIRE);
        super.augmenterSalaire(resAugmentation);
    }

    /**
     * La fonction ajoute un manager à une liste de managers si la liste n'est pas
     * déjà pleine et que
     * le manager n'est pas déjà dans la liste.
     * 
     * @param manager Le paramètre "manager" est un objet de type "Manager".
     */
    public void ajouterManager(Manager manager) {
        if (chefs.size() < 5 && !chefs.contains(manager)) {
            chefs.add(manager);
        }
    }

    /**
     * La fonction "supprimerManager" supprime un manager d'une liste de chefs s'il
     * est présent.
     * 
     * @param manager Le paramètre "manager" est un objet de type "Manager".
     */
    public void supprimerManager(Manager manager) {
        if (chefs.contains(manager)) {
            chefs.remove(manager);
        }
    }
}
