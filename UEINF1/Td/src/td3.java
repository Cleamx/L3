public class td3 {
    public static void main(String[] args) {
        System.out.println("Le perimètre est de :" + perimetre(2));
        System.out.println("L'aire est de : " + aire(2));

    }

    
    /**
     * La fonction calcule le périmètre d'un cercle en fonction de son rayon.
     * 
     * @param r Le paramètre "r" représente le rayon d'un cercle.
     * @return La méthode renvoie la valeur de la variable "resultatPerimeter", qui est le périmètre
     * calculé d'un cercle de rayon "r".
     */
    public static double perimetre(float r) {
        double resultatPerimetre = 2 * Math.PI * r;
        return resultatPerimetre;
    }

    
    /**
     * La fonction calcule l'aire d'un cercle en fonction de son rayon.
     * 
     * @param r Le paramètre "r" représente le rayon d'un cercle.
     * @return La méthode renvoie l'aire d'un cercle de rayon r.
     */
    public static double aire(float r) {
        double puissance = Math.pow(r, 2);
        double resultatAire = Math.PI * puissance;
        return resultatAire;
    }

}
