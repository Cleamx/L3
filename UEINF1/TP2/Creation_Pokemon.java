import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Creation_Pokemon {

    public static List<Object> Initialisation_pokemon() throws Exception {
        // crée une nouvelle instance de la classe ReadXLSX, utilise cette instance pour
        // lire les données d'un fichier XLSX et stocke ces données dans la liste
        // Pokemon_liste
        ReadXLSX reader = new ReadXLSX();
        List<List<String>> Pokemon_liste = reader.readXLSX();
        // liste vide instances pour stocker les instances de Pokemon qui seront créées
        // plus tard
        List<Object> instances = new ArrayList<>();
        // une liste types contenant tous les types de Pokémon possibles pour une
        // vérification ultérieure
        List<String> types = Arrays.asList("Normal", "Feu", "Eau", "Plante", "Électrik", "Glace", "Combat",
                "Poison",
                "Sol", "Vol", "Psy", "Insecte", "Roche", "Spectre", "Dragon", "Ténèbres", "Acier", "Fée");

        // La liste est parcourut de la fin vers le début pour éviter les erreurs (en
        // supprimant les éléments de la liste
        // on change la taille de la liste et donc l'indice des éléments)

        for (int i = Pokemon_liste.size() - 1; i >= 0; i--) {
            List<String> sous_liste = Pokemon_liste.get(i);

            if (!sous_liste.contains(" ") || sous_liste.get(2).equals(" ")) {

                if (sous_liste.size() == 5) {
                    Pokemon p1Pokemon = new Pokemon(sous_liste.get(0), sous_liste.get(3), sous_liste.get(4), 0, 0);
                    instances.add(p1Pokemon);
                    sous_liste.remove(0);
                } else {
                    Pokemon p1Pokemon = new Pokemon(sous_liste.get(0), sous_liste.get(3), 0, 0);
                    instances.add(p1Pokemon);
                    sous_liste.remove(0);
                }


                if (sous_liste.size() == 4) {
                    Pokemon_evolution1 p1Evolution1 = new Pokemon_evolution1(sous_liste.get(0), sous_liste.get(2),
                            sous_liste.get(3), 0, 0);
                    instances.add(p1Evolution1);
                    sous_liste.remove(0);
                } else {
                    Pokemon_evolution1 p1Evolution1 = new Pokemon_evolution1(sous_liste.get(0), sous_liste.get(2), 0,
                            0);
                    instances.add(p1Evolution1);
                    sous_liste.remove(0);
                }
               
            }
            // Si la sous liste est vide ou si le premier élément est un type alors on passe
            // à la suite
            if (sous_liste.isEmpty()) {
                continue;
            } else if (types.contains(sous_liste.get(0))) {
                continue;
            }

            // Si le premier élément de la liste est un espace
            if (sous_liste.get(0).equals(" ")) {
                // Efface tous les éléments de la liste
                sous_liste.clear();
            } else if (sous_liste.size() == 3) {
                // Sinon, crée un nouvel objet Pokemon_evolution2
                Pokemon_evolution2 p1Evolution2 = new Pokemon_evolution2(sous_liste.get(0), sous_liste.get(1), sous_liste.get(2),0,
                        0);
                instances.add(p1Evolution2);
                sous_liste.remove(0);
            }else{
                Pokemon_evolution2 p1Evolution2 = new Pokemon_evolution2(sous_liste.get(0), sous_liste.get(1), 0,
                        0);
                instances.add(p1Evolution2);
                sous_liste.remove(0);
            }
        }

        // Pour chaque objet dans la liste 'instances'

        for (Object instance : instances) {
            // Affiche l'objet à la console
            System.out.println(instance);
        }
        return instances;
    }

    public static List<Object> Liste_Poke_Pas_evoluer(List<Object> instances) {
        List<Object> Pokemon_non_evoluer = new ArrayList<>();
        for (int i = 0; i < instances.size(); i++) {
            if (instances.get(i).getClass().getName().equals("Pokemon")) {
                Pokemon_non_evoluer.add(instances.get(i));
            }
        }
        return Pokemon_non_evoluer;

    }
}