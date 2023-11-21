package TD3.ex2;

public class MainRacine {
    public static void main(String[] args) {
        try {
            double resultat = Racine.calculer(25.0);
            System.out.println("La racine carrée est : " + resultat);
            
            // Tester avec une valeur négative
            double resultatNegatif = Racine.calculer(-25.0); 
        } catch (ValeurNegativeException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
