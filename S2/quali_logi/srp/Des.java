public class Des {

    int valeur;

    public Des(){
        this.valeur = 0;
    }

    public int lancerDe() {
    	this.valeur = (int) (6*Math.random()) + 1;
    	return this.valeur;
    }

    public int jouerUnTour() {
		int total=0;
		for( int i=0;i<2; i++) {
			total+=lancerDe();
		}
		return total;
	}
}
