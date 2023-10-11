public class td5 {
    public static void main(String[] args) {
        System.out.println(chaineInv("12345"));
    }

    public static String chaineInv(String maChaine){
        char resChar;
        String resChaine = "";

        for(int i = 0; i < maChaine.length(); i++){
            resChar = maChaine.charAt(i);
            resChaine = resChar +resChaine ;
        }
        return resChaine;
    }
}
