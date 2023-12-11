import java.util.HashMap;

public class Bonbons {
    static HashMap<String, Integer> Bonbon = new HashMap<>();

    public static void ajouterBonbons(String type, int nbrbonbons) {
        if (Bonbon.containsKey(type)) {
            // Si le type est déjà présent, obtenez le nombre actuel de bonbons
            int currentBonbons = Bonbon.get(type);
            // Ajoutez le nouveau nombre de bonbons à ce nombre
            Bonbon.put(type, currentBonbons + nbrbonbons);
        } else {
            // Si le type n'est pas déjà présent, ajoutez le nouveau nombre de bonbons
            Bonbon.put(type, nbrbonbons);
        }
        System.out.println("Vous avez " + Bonbon.get(type) + " bonbons " + type);
    }

    public static void supprimerBonbons(String type, int nbrbonbons) {
        if (Bonbon.containsKey(type)) {
            // Si le type est déjà présent, obtenez le nombre actuel de bonbons
            int currentBonbons = Bonbon.get(type);
            // Ajoutez le nouveau nombre de bonbons à ce nombre
            Bonbon.put(type, currentBonbons - nbrbonbons);
        } 
        System.out.println("\nIl vous reste " + Bonbon.get(type) + " bonbons " + type);
    }

    public static HashMap<String, Integer> getDictionnaireBonbons() {
        return Bonbon;
    }
}
