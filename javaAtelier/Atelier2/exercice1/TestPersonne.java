package Atelier2.exercice1;

public class TestPersonne {
    public static void main(String[] args){
    Personne p1Personne = new Personne("Mm","clem", 16,02,2003, 4, "blabla", "20500","corte");
    Personne p3Personne = new Personne("Mm","cm", 16,02,2004, 4, "blabla", "20500","corte");

    // récupère le nombre de personne créée
    System.out.println("Le nombre de personnes est : " + p1Personne.getNombrePersonne()); 
    
    
    // test et affichage de la personne plus agée entre p1 et p3
    p1Personne.plusAgee(p3Personne);
   

    //Test equals
    Personne p2Personne = new Personne("Mm","clem", 16,02,2003, 4, "blabla", "20500","corte");
    Personne p4Personne = new Personne("Mm","clem", 16,02,2003, 4, "blabla", "20500","corte");
    System.out.println(p2Personne.equals(p4Personne));

    Employe testEmploye = Employe.CreateEmploye("Mm","clem", 16,02,2003, 4, "blabla", "20500","corte", 1500, 4, 10, 2020);
    System.out.println(testEmploye);

    testEmploye.augmenterSalaire(20);
    System.out.println("Le salaire de " +testEmploye.getPrenom()+" est de " + testEmploye.salaire);
    System.out.println("Le salarié à passer " + testEmploye.calculAnnuite() + " année dans l'entreprise");
    }
}
