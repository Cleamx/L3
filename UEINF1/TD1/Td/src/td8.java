public class td8 {
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++){
            boolean res = verifNbPremier(i);
            if (res == true){
                System.out.println(i+" est premier");
            }
        }
    }

    /**
     * La fonction "verifNbPremier" vérifie si un nombre donné est premier ou non.
     * 
     * @param nb Le paramètre "nb" représente le nombre dont on veut vérifier s'il
     *           est premier ou non.
     * @return La méthode renvoie une valeur booléenne, qui indique si le nombre
     *         donné est un nombre
     *         premier ou non.
     */
    public static boolean verifNbPremier(int nb) {
        int reste;
        boolean flag = true;

        for (int i = 2; i <= nb / 2; i++) {
            reste = nb % i;
            if (reste == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
