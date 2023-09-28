public class Vecteur3d {
    float x,y,z;

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

    public float produitScalaire(Vecteur3d a, Vecteur3d b ){
        float res;
        res = (a.x * b.x) + (a.y * b.y) + (a.z * b.z);
        return res;
        
    }

    public float sommeVecteur(Vecteur3d a, Vecteur3d b){
        float resSomme;
        resSomme = (a.x + b.x) + (a.y + b.y) + (a.z + b.z);
        return resSomme;
    }
}
