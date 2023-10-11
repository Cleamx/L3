package Td1.Td.src;

public class td3 {
    public static void main(String[] args) {
        System.out.println("Le perimètre est de :" + perimetre(2));
        System.out.println("L'aire est de : " + aire(2));

    }

    /**
     * The function calculates the perimeter of a circle given its radius.
     * 
     * @param r The parameter "r" represents the radius of a circle.
     * @return The method is returning the value of the variable
     *         "resultatPerimetre", which is the
     *         calculated perimeter of a circle with radius "r".
     */
    public static double perimetre(float r) {
        double resultatPerimetre = 2 * Math.PI * r;
        return resultatPerimetre;
    }

    /**
     * The above function calculates the area of a circle given its radius.
     * 
     * @param r The parameter "r" represents the radius of a circle.
     * @return The method is returning the area of a circle with radius r.
     */
    public static double aire(float r) {
        double puissance = Math.pow(r, 2);
        double resultatAire = Math.PI * puissance;
        return resultatAire;
    }

}
