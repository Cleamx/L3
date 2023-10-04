package Atelier2.exercice1;

public class TestPersonne {
    public static void main(String[] args){
    Personne p1Personne = new Personne("Mm","clem", 16,02,2003, 4, "blabla", "20500","corte");
    System.out.println(p1Personne.getNombrePersonne());
    Personne p3Personne = new Personne("Mm","cm", 16,02,2004, 4, "blabla", "20500","corte");
    System.out.println(p1Personne.plusAgee(p3Personne));

}
}
