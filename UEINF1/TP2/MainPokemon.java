import java.util.List;

public class MainPokemon {
    public static void main(String[] args) {
        try {
            ReadXLSX reader = new ReadXLSX();
            // Lecture des données du fichier XLSX et stockage dans la liste Pokemon_liste
            List<List<String>> Pokemon_liste = reader.readXLSX();
            Creation_Pokemon.Initialisation_pokemon(Pokemon_liste);

            // affiche tous les pokemons non évoluer
            System.out.println(Creation_Pokemon.getNonEvo());
            // affiche tous les pokemons évoluer 1 fois
            System.out.println(Creation_Pokemon.getEvo1());
            // affiche tous les pokemons évoluer 2 fois
            System.out.println(Creation_Pokemon.getEvo2());

            // random sur Pokemon_non_evoluer pour pouvoir attraper
            // pour futur fonction lootbox

        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }
}