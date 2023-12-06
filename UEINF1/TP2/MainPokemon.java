import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainPokemon {
    public static void main(String[] args) {
        try {
            ReadXLSX reader = new ReadXLSX();
            List<List<String>> Pokemon_liste = reader.readXLSX();

            System.out.println(Pokemon_liste);

            // Liste des types possibles
            List<String> types = Arrays.asList("Electrique", "Poison", "Vol", "Normal", "Insecte", "Eau", "Feu",
                    "Plante");

            for (int i = Pokemon_liste.size() - 1; i >= 0; i--) {
                List<String> sous_liste = Pokemon_liste.get(i);

                if (!sous_liste.contains(" ") || sous_liste.get(2).equals(" ")) {
                    Pokemon p1Pokemon = new Pokemon(sous_liste.get(0), sous_liste.get(3), 0, 0);
                    sous_liste.remove(0);
                    Pokemon_evolution1 p1Evolution1 = new Pokemon_evolution1(sous_liste.get(0), sous_liste.get(2), 0,
                            0);
                    sous_liste.remove(0);
                    Pokemon_evolution2 p1Evolution2 = new Pokemon_evolution2(sous_liste.get(0), sous_liste.get(1), 0,
                            0);
                    System.out.println(p1Evolution2);
                } else if (sous_liste.get(3).equals(" ")) {
                    Pokemon p2Pokemon = new Pokemon(sous_liste.get(0), sous_liste.get(4), 0, 0);
                    sous_liste.remove(0);
                    Pokemon_evolution1 p2Evolution1 = new Pokemon_evolution1(sous_liste.get(0), sous_liste.get(3), 0,
                            0);
                    sous_liste.remove(0);
                    Pokemon_evolution2 p2Evolution2 = new Pokemon_evolution2(sous_liste.get(0), sous_liste.get(2), 0,
                            0);
                    System.out.println(p2Evolution2);
                    sous_liste.remove(0);

                }
                if (types.contains(sous_liste.get(0))) {
                    Pokemon_liste.remove(i);
                    continue;
                }
            }

            System.out.println(Pokemon_liste);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}