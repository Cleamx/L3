import java.util.List;

public class MainPokemon {
    public static void main(String[] args) {
        try {
            
            List<Object> Liste_Tous_Les_Pokemons = Creation_Pokemon.Initialisation_pokemon();   
            List<Object> Pokemon_non_evoluer = Creation_Pokemon.Liste_Poke_Pas_evoluer(Liste_Tous_Les_Pokemons);
            //System.out.println(Pokemon_non_evoluer);

            // random sur Pokemon_non_evoluer pour pouvoir attraper
            // pour futur fonction lootbox

        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }
}