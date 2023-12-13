public class CombatDresseur {
    private Dresseur dresseur1;
    private Dresseur dresseur2;

    public CombatDresseur(Dresseur dresseur1, Dresseur dresseur2) {
        this.dresseur1 = dresseur1;
        this.dresseur2 = dresseur2;
    }

    // public void startCombat() {
    //     System.out.println("Combat entre " + dresseur1.getNom() + " et " + dresseur2.getNom());
    
    //     while (dresseur1.getEquipe().size() > 0 && dresseur2.getEquipe().size() > 0) {
    //         int indexPokemonDresseur1 = dresseur1.choisirPokemon();
    //         int indexPokemonDresseur2 = dresseur2.choisirPokemon();
    //         executeCombatTurn(dresseur1, indexPokemonDresseur1);
    //         executeCombatTurn(dresseur2, indexPokemonDresseur2);
    //     }
    
    //     if (dresseur1.getEquipe().size() == 0) {
    //         System.out.println(dresseur2.getNom() + " a gagné !");
    //     } else {
    //         System.out.println(dresseur1.getNom() + " a gagné !");
    //     }
    // }

    void executeCombatTurn(Dresseur attaquant, int indexPokemonAttaquant) {
        Pokemon pokemonAttaquant = (Pokemon) attaquant.getEquipe().get(indexPokemonAttaquant);

        Dresseur adversaire = getAdversaire(attaquant);
        int indexPokemonAdversaire = adversaire.choisirPokemon();
        Pokemon pokemonAdversaire = (Pokemon) adversaire.getEquipe().get(indexPokemonAdversaire);

        System.out.println(pokemonAttaquant.getNom() + " attaque " + pokemonAdversaire.getNom());
        while (pokemonAttaquant.getPv() > 0 && pokemonAdversaire.getPv() > 0) {
            if (Math.random() < 0.1) {
                System.out.println("L'attaque a échoué !");
            } else {
                pokemonAttaquant.attaque(pokemonAdversaire);
                System.out.println(pokemonAdversaire.getNom() + " a " + pokemonAdversaire.getPv() + " PV restants");
            }
        }
    }

    private Dresseur getAdversaire(Dresseur attaquant) {
        if (attaquant == dresseur1) {
            return dresseur2;
        } else {
            return dresseur1;
        }
    }
}