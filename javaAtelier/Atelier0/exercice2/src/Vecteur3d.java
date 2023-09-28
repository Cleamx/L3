public class Vecteur3d {
    float x,y,z;
    private static float resProduit, resSomme;

    public Vecteur3d(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vecteur3d(){
        this(0, 0, 0);
    }

    public void affichageVecteur(){
        System.out.println("< "+ x + ", " + y + ", " + z + " >");
    }

    public double normeVecteur(){
        double norme;
        norme = (x*x) + (y*y) + (z*z);
        norme = Math.sqrt(norme);
        return norme;
    }
    public void setProduitScalaire(Vecteur3d v1, Vecteur3d v2){
        produitScalaire(v1, v2);
    }

    public static void produitScalaire(Vecteur3d a, Vecteur3d b ){
        resProduit = (a.x * b.x) + (a.y * b.y) + (a.z * b.z);
    }

    public float getProduitSclaire(){
        return resProduit;
    }

    public void setSommeVecteur(Vecteur3d v1, Vecteur3d v2){
        sommeVecteur(v1, v2);
    }

    public static void sommeVecteur(Vecteur3d a, Vecteur3d b){
        resSomme = (a.x + b.x) + (a.y + b.y) + (a.z + b.z);
    }

    public float getSomme(){
        return resSomme;
    }

    public float produitScalaireV2(Vecteur3d a){
        return(this.x * a.x) + (this.y * a.y) + (this.z * a.z);
    }

    public float sommeVecteurV2(Vecteur3d a){
        return(this.x + a.x) + (this.y + a.y) + (this.z + a.z);
    }
}
