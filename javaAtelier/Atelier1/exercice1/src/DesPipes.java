public class DesPipes extends Des {

    private int borneMin;

    public DesPipes(int nbFaces, String nom, int borneMin){
        super(nbFaces);
        setBorneMin(borneMin);

    }

    public int getBorneMin(){
        return borneMin;
    }

    private void setBorneMin(int borneMin){
        if(borneMin >= 1 && borneMin <= super.getNbFace()){
            this.borneMin = borneMin;
        }
        else{
            System.err.println("Erreur : la borne minimale doit être compris entre 1 et le nombre de faces");
        }
    }

    public int lancer(){
        int resultat;

        do{
            resultat = super.lancer();
        }while (resultat <= borneMin);

        return resultat;
    }
}
