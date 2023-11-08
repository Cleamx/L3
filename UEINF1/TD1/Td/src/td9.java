public class td9 {
    public static void main(String[] args) {
        System.out.println(verifPalindrome("radar"));
    }

    /**
     * La fonction "verifPalindrome" vérifie si une chaîne donnée est un palindrome
     * ou non.
     * 
     * @param chaine Le paramètre "chaine" est une chaîne qui représente la chaîne
     *               d'entrée dont on
     *               veut vérifier si c'est un palindrome ou non.
     * @return La méthode renvoie une valeur booléenne, qui indique si la chaîne
     *         d'entrée est un
     *         palindrome ou non.
     */
    public static boolean verifPalindrome(String chaine) {
        boolean resPalindrome = false;
        String chaineInv = td5.chaineInv(chaine);

        if (chaine.equals(chaineInv)) {
            resPalindrome = true;
        }
        return resPalindrome;
    }
}
