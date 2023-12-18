// public class CombatDresseur {
//     private Dresseur dresseur1;
//     private Dresseur dresseur2;

//     // Constructeur
//     public CombatDresseur(Dresseur dresseur1, Dresseur dresseur2) {
//         this.dresseur1 = dresseur1;
//         this.dresseur2 = dresseur2;
//     }

//     // Méthodes de gestion du combat
//     public void executeCombatTurn(Dresseur attaquant, int indexPokemonAttaquant) {
//         Pokemon pokemonAttaquant = (Pokemon) attaquant.getEquipe().get(indexPokemonAttaquant);
//         Dresseur adversaire = getAdversaire(attaquant);
//         Pokemon pokemonAdversaire = getAdversairePokemon(adversaire);

//         System.out.println(pokemonAttaquant.getNom() + " attaque " + pokemonAdversaire.getNom());
//         executeAttack(pokemonAttaquant, pokemonAdversaire);
//     }

//     private void executeAttack(Pokemon pokemonAttaquant, Pokemon pokemonAdversaire) {
//         while (pokemonAttaquant.getPv() > 0 && pokemonAdversaire.getPv() > 0) {
//             if (Math.random() < 0.1) {
//                 System.out.println("L'attaque a échoué !");
//             } else {
//                 pokemonAttaquant.attaque(pokemonAdversaire);
//                 System.out.println(pokemonAdversaire.getNom() + " a " + pokemonAdversaire.getPv() + " PV restants");
//             }
//         }
//     }

//     private Pokemon getAdversairePokemon(Dresseur adversaire) {
//         int indexPokemonAdversaire = adversaire.choisirPokemon();
//         return (Pokemon) adversaire.getEquipe().get(indexPokemonAdversaire);
//     }

//     // Méthodes utilitaires
//     private Dresseur getAdversaire(Dresseur attaquant) {
//         return (attaquant == dresseur1) ? dresseur2 : dresseur1;
//     }
// }