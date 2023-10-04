package Atelier2.exercice1;

public class TestPersonne {
    public static void main(String[] args){
    Personne p1Personne = new Personne("Mm","clem", 16,02,2003, 4, "blabla", "20500","corte");
    Personne p3Personne = new Personne("Mm","cm", 16,02,2004, 4, "blabla", "20500","corte");

    // récupère le nombre de personne créée
    System.out.println(p1Personne.getNombrePersonne()); 
    
    
    // Le code `p1Personne.plusAgee(p3Personne);` appelle la méthode `plusAgee` de la classe `Personne`
    // sur l'objet `p1Personne`, en passant `p3Personne` comme argument. Cette méthode compare les âges
    // de « p1Personne » et de « p3Personne » et met à jour l'attribut « plusAgee » de « p1Personne »
    // pour faire référence à la personne ayant l'âge le plus élevé.
    p1Personne.plusAgee(p3Personne);
    System.out.println(p1Personne.affichagePlusAgee());

    //Test equals
    Personne p2Personne = new Personne("Mm","clem", 16,02,2003, 4, "blabla", "20500","corte");
    Personne p4Personne = new Personne("Mm","clem", 16,02,2003, 4, "blabla", "20500","corte");
    System.out.println(p2Personne.equals(p4Personne));
    }
}
