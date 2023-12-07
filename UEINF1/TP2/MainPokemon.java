import java.util.List;
import java.util.Scanner;

public class MainPokemon {
    public static void main(String[] args) {
        try {
            ReadXLSX reader = new ReadXLSX();
            // Lecture des données du fichier XLSX et stockage dans la liste Pokemon_liste
            List<List<String>> Pokemon_liste = reader.readXLSX();
            Creation_Pokemon.Initialisation_pokemon(Pokemon_liste);

            Scanner scanner = new Scanner(System.in);
            String choix;
            do {
                System.out.println("Veuillez choisir une option :");
                System.out.println("1. Afficher tous les pokemons non évolués");
                System.out.println("2. Afficher tous les pokemons évolués une fois");
                System.out.println("3. Afficher tous les pokemons évolués deux fois");
                System.out.println("4. Quitter");

                choix = scanner.nextLine();

                switch (choix) {
                    case "1":
                        System.out.println(Creation_Pokemon.getNonEvo());
                        break;
                    case "2":
                        System.out.println(Creation_Pokemon.getEvo1());
                        break;
                    case "3":
                        System.out.println(Creation_Pokemon.getEvo2());
                        break;
                    case "4":
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                        break;
                }
            } while (!choix.equals("4"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}