import java.util.Scanner;

public class CombatDresseur {
    protected static Dresseur dresseur1;
    protected static Dresseur dresseur2;

    public static void AddDresseur(Dresseur dresseur) {
        if(dresseur1 == null){
             dresseur1 = dresseur;
        }
        else{
            dresseur2 = dresseur;
        }
        System.out.println(dresseur1);
        System.out.println(dresseur2);
    }
    //combat de dresseurs lorsque deux dresseurs sont connecter au serveur
    public static void Combat(){
        Scanner scan  = new Scanner(System.in);
        if(dresseur1 != null && dresseur2 != null){
            System.out.println("Combat entre " + dresseur1.getNom() + " et " + dresseur2.getNom());

            while(dresseur1.getEquipe().size() > 0 && dresseur2.getEquipe().size() > 0){
                dresseur1.afficherEquipe();
                
                
                System.out.println("Choisissez un pokemon pour " + dresseur1.getNom());
                int choixPokemon1 = scan.nextInt();

                dresseur2.afficherEquipe();
                System.out.println("Choisissez un pokemon pour " + dresseur2.getNom());
                int choixPokemon2 = scan.nextInt();

                Pokemon pokemon1 = (Pokemon) dresseur1.getEquipe().get(choixPokemon1);
                Pokemon pokemon2 = (Pokemon) dresseur2.getEquipe().get(choixPokemon2);

                while(pokemon1.getPv() > 0 && pokemon2.getPv() > 0){

                    System.out.println(pokemon1.getNom() + " attaque " + pokemon2.getNom());
                    pokemon1.attaque(pokemon2);
                    System.out.println(pokemon2.getNom() + " a " + pokemon2.getPv() + " PV");

                    System.out.println(pokemon2.getNom() + " attaque " + pokemon1.getNom());
                    pokemon2.attaque(pokemon1);
                    System.out.println(pokemon1.getNom() + " a " + pokemon1.getPv() + " PV");

                }

                if(pokemon1.getPv() <= 0){
                    System.out.println(pokemon1.getNom() + " est KO !");
                    dresseur1.getEquipe().remove(pokemon1);
                }
                else{
                    System.out.println(pokemon2.getNom() + " est KO !");
                    dresseur2.getEquipe().remove(pokemon2);
                }
            }
            if(dresseur1.getEquipe().size() == 0){
                System.out.println(dresseur2.getNom() + " a gagné !");
            }
            else{
                System.out.println(dresseur1.getNom() + " a gagné !");
            }
        }
        else{
            System.out.println("Il n'y a pas assez de dresseurs connectés !");
        }
        scan.close();
    }

}
