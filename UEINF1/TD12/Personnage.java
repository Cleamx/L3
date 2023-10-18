package TD12;

public class Personnage {
    protected String nomPerso;
    int x, y, orientation;
    public final static int NORD = 1;
    public final static int SUD = 2;
    public final static int EST = 3;
    public final static int OUEST = 4;
    protected int pv = 100;
    protected int pforce;

    public Personnage(String nomPerso,int x, int y, int orientation, int pforce){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.nomPerso = nomPerso;
        this.pforce = pforce;
    }
    
    public int getPv() {
        return pv;
    }
    
    public void modificationOrientation(int modOrientation){
        this.orientation = modOrientation;
    }
    
    public void deplacer(){

        if (orientation == NORD && y > 0){
            y += 1;
        }
        else if (orientation == SUD && y > 0){
            y -= 1;
        }
        else if (orientation == EST && x > 0){
            x += 1;
        }
        else if (orientation == OUEST && x > 0){
            x -= 1;
        }
    }

    // public int attaquer String nomEnnemi){
            //int degatAttaque;
            //degatAttaque = nomEnnemi.getpvEnnemi() - (degat arme + pforce)
            //return degatAttaque;

    // }

    // public void defendre(){
        // deplacer autour pourcentage
    // }

    public String toString(){
        return "Nom : " + nomPerso + "\n" +
                "Coordonnées : (" + x + ", " + y + ")\n" +
                "Orientation : " + orientation;
    }


}
