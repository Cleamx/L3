package Atelier1.exercice2;

public class testEntier {
    /**
     * La fonction principale crée des instances des classes Entier et EntierFou, effectue diverses
     * opérations sur celles-ci et imprime les résultats.
     */
    public static void main(String[] args){
        Entier entier1 = new Entier(0, 10);
        Entier entier2 = new Entier(0, 10, 8);
        EntierFou entierFou1 = new EntierFou(0, 20, 3);

        System.out.println("Entier1: " + entier1);

        entier1.incremente();
        System.out.println("Entier1 après incrémentation: " + entier1); 

        entier1.setValeur(5);
        System.out.println("Entier1 après setValeur(5): " + entier1); 

       
        System.out.println("Entier2: " + entier2); 

        entier2.incremente(5);
        System.out.println("Entier2 après incrémentation de 5: " + entier2); 

        // Test de la classe EntierFou
        System.out.println("EntierFou1: " + entierFou1);

        for (int i = 0; i < 5; i++) {
            entierFou1.incremente();
            System.out.println("EntierFou1 après incrémentation aléatoire: " + entierFou1);
        }
    }
}

