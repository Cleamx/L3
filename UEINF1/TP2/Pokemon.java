import java.io.Serializable;
import java.util.List;

public class Pokemon implements Serializable {
    protected String nom;
    protected String type;
    protected String type2;
    protected int pv;
    protected int pc;

    public Pokemon(String nom, String type, int pv, int pc) {
        this.nom = nom;
        this.type = type;
        this.pv = pv;
        this.pc = pc;
    }

    public Pokemon(String nom, String type, String type2, int pv, int pc) {
        this.nom = nom;
        this.type = type;
        this.type2 = type2;
        this.pv = pv;
        this.pc = pc;
    }

    public String getNom() {
        return this.nom;
    }

    public String getType() {
        return this.type;
    }

    public String getType2() {
        return this.type2;
    }

    public int getPv() {
        return this.pv;
    }

    public int getPc() {
        return this.pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    public void setPV(int pv) {
        this.pv = pv;
    }

    @Override
    public String toString() {
        if (type2 != null) {
            return nom + " [type = " + type + ", " + type2 + ", pv = " + pv + ", pc= " + pc + "] \n";
        } else {
            return nom + " [type = " + type + ", pv = " + pv + ", pc= " + pc + "] \n";
        }
    }

    // Méthode pour faire évoluer un Pokémon de la première à la deuxième évolution
    public static Pokemon_evolution1 evoluer1(int choixPokemon, List<Pokemon> nonEvoPokemons,
            List<Pokemon_evolution1> pokemonEvolution1) {
        // Augmente les points de combat (PC) du Pokémon évolué en ajoutant 50 aux PC à
        // ceux deja existant du pokemon non évolué
        // Pokémon non évolué
        pokemonEvolution1.get(choixPokemon).setPC(nonEvoPokemons.get(choixPokemon).getPc() + 50);
        // Augmente les points de vie (PV) du Pokémon évolué en ajoutant 50 aux PV à
        // ceux deja existant du pokemon non évolué
        pokemonEvolution1.get(choixPokemon).setPV(nonEvoPokemons.get(choixPokemon).getPv() + 50);
        // Retourne le Pokémon évolué
        return pokemonEvolution1.get(choixPokemon);
    }

}
