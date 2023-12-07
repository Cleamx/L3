import java.io.File;
import java.util.List;
import java.util.Scanner;

public class MainPokemon {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // recupère le nom inscrit dans la console
            System.out.println("Veuillez entrer votre nom :");
            String nomDresseur = scanner.nextLine();

            // Crée une référence à un fichier avec le nom du dresseur dans le dossier
            // "saves"
            File file = new File("saves/" + nomDresseur + ".txt");

            // Déclare une variable pour le dresseur
            Dresseur dresseur;

            // Crée une instance de la classe Open_Save pour ouvrir 
            Open_Save openSave = new Open_Save();

            // Vérifie si le fichier du dresseur existe
            if (file.exists()) {
                // Si le fichier existe, affiche un message de bienvenue
                System.out.println("Bienvenue, " + nomDresseur + " !");

                // Ouvre la sauvegarde du dresseur
                dresseur = openSave.ouvrirSave("saves/" + nomDresseur + ".txt");

                // Efface la console
                System.out.print("\033\143");
            } else {
                // Si le fichier n'existe pas, affiche un message indiquant qu'un nouveau
                // dresseur est créé
                System.out.println("Création d'un nouveau dresseur...");

                // Efface la console
                System.out.print("\033\143");

                // Crée un nouveau dresseur avec le nom rentrer dans la console (à la 10lignes)
                dresseur = new Dresseur(nomDresseur, null, null, null);
            }

            ReadXLSX reader = new ReadXLSX();
            // Lecture des données du fichier XLSX et stockage dans la liste Pokemon_liste
            List<List<String>> Pokemon_liste = reader.readXLSX();
            Creation_Pokemon.Initialisation_pokemon(Pokemon_liste);

            String choix;
            do {
                System.out.println("Veuillez choisir une option :");
                System.out.println("1. Consulter les Pokemons attrapés ");
                System.out.println("2. Afficher tous les pokemons évolués une fois");
                System.out.println("3. Afficher tous les pokemons évolués deux fois");
                System.out.println("4. Quitter");

                choix = scanner.nextLine();

                switch (choix) {
                    case "1":
                        System.out.println(dresseur.getPokemonAttrape());
                        break;
                    case "2":
                        System.out.println(Creation_Pokemon.getEvo1());
                        break;
                    case "3":
                        System.out.println(Creation_Pokemon.getEvo2());
                        break;
                    case "4":
                        System.out.println("Au revoir !");
                        Save_dresseur save = new Save_dresseur();
                        save.enregistrerDresseur(dresseur, "saves/" + nomDresseur + ".txt");
                        System.out.print("\033\143");
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