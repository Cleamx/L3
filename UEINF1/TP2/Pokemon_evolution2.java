public class Pokemon_evolution2 extends Pokemon {
    public Pokemon_evolution2(String nom, String type, int pv, int pc) {
        super(nom, type, pv, pc);
    }

    public Pokemon_evolution2(String nom, String type, String type2, int pv, int pc) {
        super(nom, type,type2, pv, pc);
    }

    // public static Pokemon_evolution2 evoluer2(Pokemon_evolution1 pokemon) {
    //     Pokemon_evolution2 pokemon2 = new Pokemon_evolution2(pokemon.getNom(), pokemon.getType(), pokemon.getType2(), pokemon.getPv(), pokemon.getPc());
    //     return pokemon2;
    // }
}
