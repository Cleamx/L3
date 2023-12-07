import java.util.List;

public class MainPokemon {
    public static void main(String[] args) {
        try {
            
            List<Object> res = Creation_Pokemon.Initialisation_pokemon();   
            List<Object> Pokemon_non_evoluer = Creation_Pokemon.Liste_Poke_Pas_evoluer(res);
            System.out.println(Pokemon_non_evoluer);
            // utiliser un random sur instances en ne selectionnant que les objets de type Pokemon
            // pour futur fonction lootbox

        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }
}