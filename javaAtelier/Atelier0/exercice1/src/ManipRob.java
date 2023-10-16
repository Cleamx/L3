package Atelier0.exercice1.src;

public class ManipRob {
    public static void main (String [] args){
        Robots r1 = new Robots("Titi", 10, 20, Robots.SUD);
        Robots r2 = new Robots("Toto");
        
        System.out.println(r1); //affiche les caractéristique du robots
        System.out.println(r2);
    }
}
