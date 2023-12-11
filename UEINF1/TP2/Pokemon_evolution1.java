import java.util.List;

public class Pokemon_evolution1 extends Pokemon {
    public Pokemon_evolution1(String nom, String type, int pv, int pc) {
        super(nom, type, pv, pc);
    }

    public Pokemon_evolution1(String nom, String type, String type2, int pv, int pc) {
        super(nom, type, type2, pv, pc);
    }

    // Méthode pour faire évoluer un Pokémon de la deuxième à la troisième évolution
    public static Pokemon_evolution2 evoluer2(int choixPokemon, List<Pokemon_evolution1> Evo1,
            List<Pokemon_evolution2> Evo2) {
        // Augmente les points de combat (PC) du Pokémon évolué en ajoutant 50 aux PC du
        // Pokémon de deuxième évolution
        Evo2.get(choixPokemon).setPC(Evo1.get(choixPokemon).getPc() + 50);
        // Augmente les points de vie (PV) du Pokémon évolué en ajoutant 50 aux PV du
        // Pokémon de deuxième évolution
        Evo2.get(choixPokemon).setPV(Evo1.get(choixPokemon).getPv() + 50);
        // Retourne le Pokémon évolué
        return Evo2.get(choixPokemon);
    }
}
