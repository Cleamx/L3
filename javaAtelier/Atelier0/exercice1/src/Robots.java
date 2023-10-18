package Atelier0.exercice1.src;

public class Robots {
    String refRobot= "ROB", nomRobot;
    int x, y, orientation;
    public final static int NORD = 1;
    public final static int SUD = 2;
    public final static int EST = 3;
    public final static int OUEST = 4;
    static int nombreRobot;

    public Robots(String nomRobot, int x, int y, int orientation){

        this.nomRobot = nomRobot;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        nombreRobot += 1;
        refRobot += nombreRobot;
    }

    public Robots(String nomRobot){
        this.nomRobot = nomRobot;
        this.x = 0;
        this.y = 0;
        nombreRobot += 1;
        refRobot += nombreRobot;
        this.orientation = NORD;

    }

    public void modificationOrientation(int modOrientation){
        this.orientation = modOrientation;
    }

    public void deplacer(){
        
       
        if (orientation == NORD){
            y += 1;
        }
        else if (orientation == SUD && y > 0){
            y -= 1;
        }
        else if (orientation == EST){
            x += 1;
        }
        else if (orientation == OUEST && x > 0){
            x -= 1;
        }
    }

    public void afficheToi(){
        System.out.println("Le nom du robot est : " + nomRobot);
        System.out.println("La référence est : " + refRobot);
        System.out.println("Les coordonées sont : (" + x + ", " + y+")");
        System.out.println("La direction est : " + orientation);
    }

    public String toString(){
        return "Référence : " + refRobot + "\n" +
                "Nom : " + nomRobot + "\n" +
                "Coordonnées : (" + x + ", " + y + ")\n" +
                "Orientation : " + orientation;
    }
}

