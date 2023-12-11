import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Dresseur implements Serializable {
    private String nom;
    private List<Object> pokemonAttrape = new ArrayList<>();
    private List<Object> equipe = new ArrayList<>();
    private HashMap<String, Integer> dictionnaireBonbon = Bonbons.getDictionnaireBonbons();

    public Dresseur(String nom) {
        this.nom = nom;
    }

    // public Dresseur(String nom, List<Object> pokemonAttrape, List<Object> equipe,
    // List<Object> bonbons) {
    // this.nom = nom;
    // this.pokemonAttrape = pokemonAttrape;
    // this.equipe = equipe;
    // this.bonbons = bonbons;
    // }

    public String getNom() {
        return nom;
    }

    public List<Object> getPokemonAttrape() {
        return pokemonAttrape;
    }

    public List<Object> getEquipe() {
        return equipe;
    }

    // public void setNom(String nom) {
    // this.nom = nom;
    // }

    public void setPokemonAttrape(Pokemon pokemonAttrape) {
        this.pokemonAttrape.add(pokemonAttrape);
    }

    public void setEquipe(List<Object> equipe) {
        this.equipe = equipe;
    }

    public void chassePokemon(List<Pokemon> lootbox, Scanner lire) {
        // Crée un nouvel objet Random
        Random random = new Random();

        // Sélectionne un index aléatoire dans la liste de Pokémons
        int index = random.nextInt(lootbox.size());

        // Récupère le Pokémon à cet index
        Pokemon pokemon = lootbox.get(index);

        // Affiche une question à l'utilisateur
        System.out.println("Voullez vous attraper le pokémon " + pokemon.getNom() + " ?");
        System.out.println("1. Oui");
        System.out.println("2. Non");

        // Lit la réponse de l'utilisateur
        String choix = lire.nextLine();

        // Traite la réponse de l'utilisateur
        switch (choix) {
            case "1":
                // Si l'utilisateur veut attraper le Pokémon
                System.out.println("Vous avez attrapé le pokémon " + pokemon.getNom() + " !");
                pokemonAttrape.add(pokemon);

                // Définit les points de combat (PC) du Pokémon de manière aléatoire
                int nombreAleatoire = random.nextInt(11) + 10;
                pokemon.setPC(nombreAleatoire);

                // Définit les points de vie (PV) du Pokémon de manière aléatoire
                nombreAleatoire = random.nextInt(21) + 10;
                pokemon.setPV(nombreAleatoire);

                // Ajoute des bonbons au dictionnaire de bonbons en fonction du type du Pokémon
                // attrapé
                Bonbons.ajouterBonbons(pokemon.getType(), 2);

                // Vérifie si le Pokémon a un deuxième type
                if (pokemon.getType2() != null) {
                    // Si oui, ajoute des bonbons pour le deuxième type
                    Bonbons.ajouterBonbons(pokemon.getType2(), 2);
                }
                break;
            case "2":
                // Si l'utilisateur ne veut pas attraper le Pokémon
                System.out.println("Vous n'avez pas attrapé le pokémon " + pokemon.getNom() + " !");
                break;
            default:
                // Si l'utilisateur n'a pas choisi une option valide
                System.out.println("Veuillez choisir une option valide.");
                break;
        }
    }

    public void ajouterEquipe(Object pokemon) {
        if (equipe.size() < 6) {
            equipe.add(pokemon);
        } else {
            System.out.println("Vous avez déjà 6 pokémons dans votre équipe.");
        }
    }

    public void modifierEquipe(Object pokemon, int index) {
        if (index < 6) {
            equipe.set(index, pokemon);
        } else {
            System.out.println("Vous ne pouvez pas ajouter plus de 6 pokémons dans votre équipe.");
        }
    }

    public void supprimerEquipe(int index) {
        if (index < 6) {
            equipe.remove(index);
        } else {
            System.out.println("Vous ne pouvez pas supprimer plus de 6 pokémons dans votre équipe.");
        }
    }

    public void afficherEquipe() {
        for (int i = 0; i < equipe.size(); i++) {
            System.out.println(equipe.get(i));
        }
    }

    public void afficherbonbons() {
        if (dictionnaireBonbon.size() == 0) {
            System.out.println("Vous n'avez pas encore de bonbons.");
        } else {
            for (Map.Entry<String, Integer> entry : dictionnaireBonbon.entrySet()) {
                System.out.println("Type: " + entry.getKey() + ", Nombre: " + entry.getValue() + "\n");
            }
        }
    }

    public void afficherPokemonAttrape() {
        // Vérifie si le dresseur a attrapé des Pokémons
        if (pokemonAttrape.size() == 0) {
            // Si le dresseur n'a pas attrapé de Pokémon, affiche un message
            System.out.println("Vous n'avez pas encore attrapé de pokémon.");
        } else {
            // Si le dresseur a attrapé des Pokémons, parcourt la liste des Pokémons
            // attrapés
            for (int i = 0; i < pokemonAttrape.size(); i++) {
                // Récupère le Pokémon à l'index i
                Pokemon pokemon = (Pokemon) pokemonAttrape.get(i);

                // Affiche le Pokémon
                System.out.println(i + ". " + pokemon);

                // Vérifie si le dictionnaire de bonbons contient le type du Pokémon
                if (dictionnaireBonbon.containsKey(pokemon.getType())) {
                    // Si oui, récupère le nombre de bonbons de ce type
                    System.out.println("Nombre de bonbons de type " + pokemon.getType() + " : "
                            + dictionnaireBonbon.get(pokemon.getType()));
                    if (pokemon.getType2() != null) {
                        // Si le Pokémon a un deuxième type, récupère le nombre de bonbons de ce type
                       System.out.println("Nombre de bonbons de type " + pokemon.getType2() + " : "
                                + dictionnaireBonbon.get(pokemon.getType2())+ "\n");
                    }
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    public void utiliserBonbon(Object bonbon, Object pokemon) {
        if (dictionnaireBonbon.containsKey(bonbon)) {
            dictionnaireBonbon.remove(bonbon);
            pokemonAttrape.remove(pokemon);
            pokemonAttrape.add(pokemon);
        } else {
            System.out.println("Vous ne possédez pas ce bonbon.");
        }
    }

    public void transfererPokemon(Object pokemon) {
        if (pokemonAttrape.contains(pokemon)) {
            pokemonAttrape.remove(pokemon);
        } else {
            System.out.println("Vous ne possédez pas ce pokémon.");
        }
    }

}
