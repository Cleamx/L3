package Atelier2.exercice1;

public class TestPersonne {
    public static void main(String[] args) {
        // Création Personne
        Personne p1Personne = new Personne("aaaaa", "bbbbb", 16, 02, 2003, 4, "blabla", "20500", "corte");
        Personne p3Personne = new Personne("ccccc", "ddddddd", 16, 02, 2004, 4, "blabla", "20500", "corte");
        // deux personnes identiques pour test equals
        Personne p2Personne = new Personne("Mm", "clem", 16, 02, 2003, 4, "blabla", "20500", "corte");
        Personne p4Personne = new Personne("Mm", "clem", 16, 02, 2003, 4, "blabla", "20500", "corte");

        // Création Employe
        Employe employe1 = Employe.CreateEmploye("Doe", "John", 15, 5, 1980, 123, "Rue de la Paix", "12345", "Ville1",
                50000, 1, 1, 2020);

        // Création Manager
        Manager mManager = Manager.CreateManager("Mm", "clem", 16, 02, 2003, 4, "blabla", "20500", "corte", 1500, 4, 10,
                2020);

        // création Secretaire
        Secretaire s1Secretaire = Secretaire.CreateSecretaire("abc", "def", 1, 2, 1999, 0, "ghi", "20200", "blabla",
                1300, 2, 10, 2018);

        // ----------------------- TEST ---------------------------------

        // récupère le nombre de personne créée
        System.out.println("Le nombre de personnes est : " + p1Personne.getNombrePersonne());

        // test et affichage de la personne plus agée entre p1 et p3
        p1Personne.plusAgee(p3Personne);

        // Test equals
        System.out.println("Les deux personnes sont elles les même ? " + p2Personne.equals(p4Personne));

        // Vérifier si l'employé a été créé avec succès
        if (employe1 != null) {
            System.out.println("Employé créé avec succès !");

            System.out.println("Ancienneté de l'employé : " + employe1.calculAnnuite() + " années");

            System.out.println("Salaire de l'employé : " + employe1.salaire);

            employe1.augmenterSalaire(10);
            System.out.println("Nouveau salaire de l'employé : " + employe1.salaire);
        } else {
            System.out.println("L'employé n'a pas été créé car son âge est en dehors de la plage 16-65 ans.");
        }

        // test Manager

        // mManager.augmenterSalaire(3);
        // System.out.println("Le salaire de " + mManager.getPrenom() + " est de " +
        // mManager.salaire);
        // mManager.assignerSecretaire(s1Secretaire);

    }
}
