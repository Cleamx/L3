import java.util.ArrayList;

class Jeu
{
	

	public Jeu() {
		lesJoueurs=new ArrayList<String>();	
	}
	
	

	
	public void bataille() {
		int nbGagnants=0,score,max=0;
		String nomsGagnants="";
		String res;
		for (String nom:lesJoueurs) {
			score=jouerUnTour();
			if (score>max) {
				max=score;
				nbGagnants=1;
				nomsGagnants=nom;
			}
			else if (score==max) {
				nbGagnants+=1;
				nomsGagnants+="-"+nom;
			}
			System.out.println( nom+ " : "+score);
		}
		if (nbGagnants==1)
			res="Le gagnant est ";
		else
			res= "Il y a " + nbGagnants + " exaequo :";
		res+=nomsGagnants;
		System.out.println(res);
	}
    
}
