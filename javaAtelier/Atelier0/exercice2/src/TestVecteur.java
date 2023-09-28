public class TestVecteur {
    public static void main(String[] args) throws Exception {
        Vecteur3d v1 = new Vecteur3d(3, 2, 5);
        Vecteur3d v2 = new Vecteur3d(1, 2, 3);

        v1.affichageVecteur();
        System.out.println("Norme de v1 : "+ v1.normeVecteur());
        v2.affichageVecteur();
        System.out.println("Norme de v2 : "+ v2.normeVecteur());
    }
}
