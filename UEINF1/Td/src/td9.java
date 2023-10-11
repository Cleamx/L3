public class td9 {
    public static void main(String[] args) {
        System.out.println(verifPalindrome("radar"));
    }

    public static boolean verifPalindrome(String chaine){
        boolean resPalindrome = false;
        String test = td5.chaineInv(chaine);
        if(chaine.equals(test)){
            resPalindrome = true;
        }
        return resPalindrome;
    }
}
