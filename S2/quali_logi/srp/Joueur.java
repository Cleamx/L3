import java.util.ArrayList;

public class Joueur {
    
    private ArrayList<String> lesJoueurs;

    public Joueur(){
        lesJoueurs=new ArrayList<String>();	
    }

    public void ajouterJoueur(String nom) {
		lesJoueurs.add(nom);
	}
    
}
