public class TestVecteur {
    public static void main(String[] args) throws Exception {
        Vecteur3d v1 = new Vecteur3d(3, 2, 5);
        Vecteur3d v2 = new Vecteur3d(1, 2, 3);

        v1.affichageVecteur();
        System.out.println("Norme de v1 : "+ v1.normeVecteur());
        v2.affichageVecteur();
        System.out.println("Norme de v2 : "+ v2.normeVecteur());
        v1.setProduitScalaire(v1, v2);
        v1.setSommeVecteur(v1, v2);

        float resultatSomme = v1.getSomme();
        System.out.println("v1 + v2 = " + resultatSomme);
        float resultatProduitScalaire = v1.getProduitSclaire();
        System.out.println("v1.v2 = " + resultatProduitScalaire);
    }
}

