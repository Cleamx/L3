package TD4.ex1;

import java.util.ArrayList;
import java.util.List;

public class MainPokemon {
    public static void main(String[] args) {
        List<String> Pokemon = new ArrayList<String>();
        Pokemon.add("Pikachu");
        Pokemon.add("Salamèche");
        Pokemon.add("Bulbizarre");

        for(int i = 0; i < Pokemon.size(); i++){
            System.out.println(Pokemon.get(i));
        }
        
        Pokemon.add(0, "Magicarpe");

        System.out.println(Pokemon);

        Pokemon.remove(1);
        System.out.println(Pokemon);

    }

}
