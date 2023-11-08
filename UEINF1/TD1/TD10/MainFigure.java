package TD10;

public class MainFigure {
    public static void main(String[] args) {
        Cercle cercle1 = new Cercle(5, "Cercle1");
        Rectangle rectangle1 = new Rectangle(5, "Rectangle1", 3);
        Carre carre1 = new Carre("Carre1", 5);

        // test Carre
        System.out.println("Nom de la figure : " + carre1.nomFigure);
        System.out.println("Longueur du côté du carré : " + carre1.longeur);

        System.out.println("Périmètre du carré : " + carre1.Perimetre());
        System.out.println("Aire du carré : " + carre1.Aire() + "\n");

        // test de Cercle
        System.out.println("Nom de la figure : " + cercle1.nomFigure);
        System.out.println("Rayon du cercle : " + cercle1.rayon);
        System.out.println("Périmètre du cercle : " + cercle1.Perimetre());
        System.out.println("Aire du cercle : " + cercle1.Aire() + "\n");

        // test de Rectangle
        System.out.println("Nom de la figure : " + rectangle1.nomFigure);
        System.out.println("Longueur du rectangle : " + rectangle1.longeur);
        System.out.println("Largeur du rectangle : " + rectangle1.largeur);

        // Affiche le périmètre et l'aire du rectangle
        System.out.println("Périmètre du rectangle : " + rectangle1.Perimetre());
        System.out.println("Aire du rectangle : " + rectangle1.Aire()+ "\n");

        System.out.println("Il y a " + Rectangle.getNbFigure() + " figure");

    }
}
