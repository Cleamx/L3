package TD4.ex7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Test de tri de la collection de personnes

        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne("Doe", "John", 25));
        personnes.add(new Personne("Smith", "Alice", 30));
        personnes.add(new Personne("Johnson", "Bob", 25));
        personnes.add(new Personne("Brown", "Carol", 30));

        System.out.println("Avant le tri :");
        afficherPersonnes(personnes);

        // Tri de la collection de personnes
        Collections.sort(personnes);

        System.out.println("Après le tri :");
        afficherPersonnes(personnes);
    }

    private static void afficherPersonnes(List<Personne> personnes) {
        for (Personne personne : personnes) {
            System.out.println(personne.getNom() + " " + personne.getPrenom() + ", Age: " + personne.getAge());
        }
        System.out.println();
    }
}

