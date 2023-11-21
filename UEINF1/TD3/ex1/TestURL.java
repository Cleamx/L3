package TD3.ex1;

import java.net.URI;
import java.net.URISyntaxException;

public class TestURL {
    public static void main(String[] args) {
        String uriString = "https://www.universita.corsica/";
        
        try {
            // Création de l'instance URI en passant la chaîne en paramètre
            URI uri = new URI(uriString);

            // Affichage en cas de succès
            System.out.println("La création de l'URI s'est bien passée");
        } 
        
        catch (URISyntaxException e) {
            // Affichage en cas d'exception
            System.err.println("Problème lors de la création, il semble que " + uriString + 
            " ne soit pas un URI correct");
            e.printStackTrace(); // Optionnel : affiche la trace de la pile pour débugger
        }
    }

}
