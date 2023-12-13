import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Cette classe représente un dresseur de Pokémon.
 * Un dresseur possède un nom, une liste de Pokémon attrapés, une équipe de Pokémon et un dictionnaire de bonbons.
 * Le dresseur peut attraper des Pokémon, les ajouter à son équipe, les modifier, les supprimer, les transférer, les faire évoluer, etc.
 */
public class Dresseur implements Serializable {
    private String nom;
    private List<Object> pokemonAttrape = new ArrayList<>();
    private List<Object> equipe = new ArrayList<>();
    private HashMap<String, Integer> dictionnaireBonbon = Bonbons.getDictionnaireBonbons();

    public Dresseur(String nom) {
        this.nom = nom;
    }

    static Socket connectToServer(Dresseur dresseur) { 
        Socket socket = null;
        try {
            socket = new Socket("localhost", AreneServeur.PORT);
            // Envoie l'objet dresseur au serveur
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(dresseur);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return socket;
    }

    /**
     * Renvoie le nom du dresseur
     *
     * @return le nom du dresseur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Renvoie la liste des Pokémon attrapés par le dresseur.
     *
     * @return la liste des Pokémon attrapés
     */
    public List<Object> getPokemonAttrape() {
        return pokemonAttrape;
    }

    /**
     * Renvoie la liste des Pokémon de l'équipe du dresseur.
     *
     * @return la liste des Pokémon de l'équipe
     */
    public List<Object> getEquipe() {
        return equipe;
    }

    /**
     * Ajoute un Pokémon attrapé à la liste des Pokémon du dresseur.
     * 
     * @param pokemonAttrape le Pokémon à ajouter
     */
    public void setPokemonAttrape(Pokemon pokemonAttrape) {
        this.pokemonAttrape.add(pokemonAttrape);
    }


    public void setEquipe(List<Object> equipe) {
        this.equipe = equipe;
    }

    /**
     * Méthode permettant de chasser un Pokémon en faisant un random dans une liste de Pokémons.
     * 
     * @param lootbox la liste de Pokémons dans laquelle chasser
     * @param lire le scanner pour lire la réponse de l'utilisateur
     */
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
                pokemon.setPvSave(nombreAleatoire);

                // Ajoute des bonbons au dictionnaire de bonbons en fonction du type du Pokémon
                // attrapé
                Bonbons.ajouterBonbons(pokemon.getType(), 5);

                // Vérifie si le Pokémon a un deuxième type
                if (pokemon.getType2() != null) {
                    // Si oui, ajoute des bonbons pour le deuxième type
                    Bonbons.ajouterBonbons(pokemon.getType2(), 5);
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

    public void ajouterEquipe(int pokemonChoix) {
        if (equipe.size() < 6) {
            equipe.add(pokemonAttrape.get(pokemonChoix));
        } else {
            System.out.println("Vous avez déjà 6 pokémons dans votre équipe.");
        }
    }

    public void supprimerEquipe(int pokemonChoix) {
        if (equipe.size() < 6) {
            equipe.remove(pokemonChoix);
        } else {
            System.out.println("Vous ne pouvez pas supprimer plus de 6 pokémons dans votre équipe.");
        }
    }

    public void afficherEquipe() {
        for (int i = 0; i < equipe.size(); i++) {
            System.out.println(equipe.get(i));
        }
    }

    /**
     * La fonction "afficherbonbons" vérifie si le dictionnaire des bonbons est vide et imprime un
     * message si c'est le cas, sinon elle imprime le type et la quantité de chaque bonbon dans le
     * dictionnaire.
     */
    public void afficherbonbons() {
        // Vérifie si la taille du dictionnaire de bonbons est égale à 0, c'est-à-dire
        // s'il n'y a pas de bonbons
        if (dictionnaireBonbon.size() == 0) {
            // Si c'est le cas, affiche un message indiquant qu'il n'y a pas encore de
            // bonbons
            System.out.println("Vous n'avez pas encore de bonbons.");
        } else {
            // Sinon, pour chaque entrée dans le dictionnaire de bonbons
            for (Map.Entry<String, Integer> entry : dictionnaireBonbon.entrySet()) {
                // Affiche le type de bonbon (la clé de l'entrée) et le nombre de bonbons de ce
                // type (la valeur de l'entrée)
                System.out.println("Type: " + entry.getKey() + ", Nombre: " + entry.getValue() + "\n");
            }
        }
    }

    /**
     * Affiche les Pokémons attrapés par le dresseur.
     * Si aucun Pokémon n'a été attrapé, affiche un message approprié.
     * Parcourt la liste des Pokémons attrapés et affiche leurs informations.
     * Vérifie si chaque Pokémon peut évoluer en fonction du nombre de bonbons disponibles.
     */
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

                if (dictionnaireBonbon.containsKey(pokemon.getType())) {

                    // Si oui, récupère le nombre de bonbons de ce type
                    int nombreBonbonsType1 = dictionnaireBonbon.get(pokemon.getType());
                    System.out.println("Nombre de bonbons de type " + pokemon.getType() + " : " + nombreBonbonsType1);

                    if (pokemon.getType2() != null && dictionnaireBonbon.containsKey(pokemon.getType2())) {
                        // Si le Pokémon a un deuxième type, récupère le nombre de bonbons de ce type
                        int nombreBonbonsType2 = dictionnaireBonbon.get(pokemon.getType2());
                        System.out.println(
                                "Nombre de bonbons de type " + pokemon.getType2() + " : " + nombreBonbonsType2 + "\n");

                        if (nombreBonbonsType2 >= 5 && nombreBonbonsType1 >= 5) {
                            System.out.println(pokemon.getNom() + " peut évoluer !");
                        }
                    } else if (nombreBonbonsType1 >= 5) {
                        System.out.println(pokemon.getNom() + " peut évoluer !");
                    }
                }

                System.out.println("------------------------------------------------------------");
            }
        }
    }

    /**
     * La fonction "transfererPokemon" supprime un Pokémon spécifique d'une liste de Pokémon capturés.
     * 
     * @param choixPokemon Le paramètre "choixPokemon" représente l'index des Pokémon à transférer
     * depuis la liste "pokemonAttrape".
     */
    public void transfererPokemon(int choixPokemon) {
        pokemonAttrape.remove(pokemonAttrape.get(choixPokemon));
        System.out.println(((Pokemon) pokemonAttrape.get(choixPokemon)).getNom()+" a été transféré avec succès.");
    }

    /**
     * Fait évoluer un Pokémon en fonction des conditions spécifiées.
     * 
     * @param choixPokemon    L'indice du Pokémon choisi dans la liste des Pokémons attrapés.
     * @param nonEvoPokemons  La liste des Pokémons non évolués.
     * @param evo1Pokemons    La liste des Pokémons de première évolution.
     * @param evo2Pokemons    La liste des Pokémons de deuxième évolution.
     */
    public void evoluerPokemon(int choixPokemon, List<Pokemon> nonEvoPokemons, List<Pokemon_evolution1> evo1Pokemons,
            List<Pokemon_evolution2> evo2Pokemons) {

        // Obtient l'index du Pokémon choisi dans la liste des Pokémons non évolués
        // par exemple ratata est à l'index 0 dans la liste des pokemonAttrape je
        // cherche
        // l'index de ratata dans la liste des nonEvoPokemons (qui contient tous les
        // pokemons non évolués)
        // dans la liste evo1Pokemons le ratatac se trouve au même index que ratata dans
        // nonEvoPokemons
        int indexOfpokemon = nonEvoPokemons.indexOf(pokemonAttrape.get(choixPokemon));

        // Vérifie si le dresseur a suffisamment de bonbons pour faire évoluer le
        // Pokémon
        if (Bonbons.getDictionnaireBonbons().get(nonEvoPokemons.get(indexOfpokemon).getType()) >= 5) {
            // Si le Pokémon est de la première évolution
            if (pokemonAttrape.get(choixPokemon) instanceof Pokemon) {
                // Fait évoluer le Pokémon à la deuxième évolution
                Pokemon_evolution1 evolution1 = Pokemon.evoluer1(indexOfpokemon, nonEvoPokemons, evo1Pokemons);
                // Remplace le Pokémon dans la liste des Pokémons attrapés par sa deuxième
                // évolution
                pokemonAttrape.set(choixPokemon, evolution1);
                // Affiche un message indiquant que le Pokémon a évolué
                System.out.println("\nLe Pokémon a évolué en " + evolution1.getNom() + " !");
                System.out.println("------------------------------------------------------------");
                // Si le Pokémon est de la deuxième évolution
            } else if (pokemonAttrape.get(choixPokemon) instanceof Pokemon_evolution1) {
                // Tente de faire évoluer le Pokémon à la troisième évolution
                Pokemon_evolution2 evolution2 = Pokemon_evolution1.evoluer2(indexOfpokemon, evo1Pokemons, evo2Pokemons);
                // Si le Pokémon peut évoluer à la troisième évolution
                if (evolution2 != null) {
                    // Remplace le Pokémon dans la liste des Pokémons attrapés par sa troisième
                    // évolution
                    pokemonAttrape.set(choixPokemon, evolution2);
                    // Affiche un message indiquant que le Pokémon a évolué
                    System.out.println("\nLe Pokémon a évolué en " + evolution2.getNom() + " !");
                    System.out.println("------------------------------------------------------------");
                } else {
                    // Si le Pokémon ne peut pas évoluer à la troisième évolution, augmente ses
                    // statistiques
                    int Pc = ((Pokemon) pokemonAttrape.get(choixPokemon)).getPc();
                    int Pv = ((Pokemon) pokemonAttrape.get(choixPokemon)).getPv();
                    ((Pokemon) pokemonAttrape.get(choixPokemon)).setPC(Pc + 50);
                    ((Pokemon) pokemonAttrape.get(choixPokemon)).setPV(Pv + 50);
                    // Affiche un message indiquant que les statistiques du Pokémon ont augmenté
                    System.out.println("\nLe Pokémon a augmenté ses statistiques !");
                    System.out.println("------------------------------------------------------------");
                }
            }

            // Supprime 5 bonbons du type du Pokémon de la réserve de bonbons
            Bonbons.supprimerBonbons(nonEvoPokemons.get(indexOfpokemon).getType(), 5);
            // Affiche un message indiquant que 5 bonbons du type du Pokémon ont été
            // utilisés
            System.out.println(
                    "5 bonbons de type " + nonEvoPokemons.get(indexOfpokemon).getType() + " ont été utilisés.");

            // Vérifie si le Pokémon a un deuxième type
            if (nonEvoPokemons.get(indexOfpokemon).getType2() != null) {
                // Si oui, supprime 5 bonbons du deuxième type du Pokémon de la réserve de
                // bonbons
                Bonbons.supprimerBonbons(nonEvoPokemons.get(indexOfpokemon).getType2(), 5);
                // Affiche un message indiquant que 5 bonbons du deuxième type du Pokémon ont
                // été utilisés
                System.out.println(
                        "5 bonbons de type " + nonEvoPokemons.get(indexOfpokemon).getType2() + " ont été utilisés.");
            }
            // Si le dresseur n'a pas suffisamment de bonbons pour faire évoluer le Pokémon
            else {
                // Affiche un message indiquant que le dresseur n'a pas assez de bonbons pour
                // faire évoluer le Pokémon
                System.out.println("Vous n'avez pas assez de bonbons pour faire évoluer ce pokémon");
            }
        }
    }

    @Override
    public String toString() {
        return "Dresseur [nom=" + nom + ", pokemonAttrape=" + pokemonAttrape + ", equipe=" + equipe
                + ", dictionnaireBonbon=" + dictionnaireBonbon + "]";
    }

}
