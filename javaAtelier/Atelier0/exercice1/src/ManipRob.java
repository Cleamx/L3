public class ManipRob {
    public static void main (String [] args){
        Robots r1 = new Robots("Titi", 10, 20, Robots.SUD);
        Robots r2 = new Robots("Toto");
        System.out.println(r1.nomRobot);
        System.out.println(r2);
        r1.afficheToi();
        r2.afficheToi();
    }
}
