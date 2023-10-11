public class td2 {
    public static void main(String[] args) {
        multiplication(5);
    }

    
    /**
     * La fonction "multiplication" prend un entier en entrée et imprime la table de multiplication de
     * ce nombre de 0 à 10.
     * 
     * @param a Le paramètre "a" représente le nombre que vous souhaitez multiplier.
     * @return La méthode renvoie la valeur du paramètre « a », qui est un entier.
     */
    public static int multiplication(int a) {
        int resMultipication = 0;
        for (int i = 0; i <= 10; i++) {
            resMultipication = a * i;
            System.out.println(a + " x " + i + " = " + resMultipication);
        }
        return a;
    }
}
