public class testAPI {
    public static void main(String[] args) throws Exception {
        double resPi = Math.PI;
        double resRandom  = Math.random();
        int resRandomV2 = (int) Math.round(Math.random()*2)+1;
        int x1 = 1, x2 = 2;

        String n1 = "Bonjour", n2 = "Courgette";

        int resCompare = n1.compareTo(n2);

        if (resCompare < 0){
            System.out.println("Entre " + n1 + " et " + n2 + ", " + n1 + " est le premier dans l'ordre alphabétique.");
        }
        else if (resCompare > 0){
            System.out.println("Entre " + n1 + " et " + n2 + ", " + n2 + " est le premier dans l'ordre alphabétique.");
        }

        System.out.println("Résultat de PI : " + resPi);
        System.out.println("Résultat aléatoire entre 0 et 1 : " + resRandom);
        System.out.println("Résultat aléatoire entier entre 1 et 3 : " + resRandomV2);
        System.out.println("Résultat du plus grand entre x1 et x2 : "+ Math.max(x1,x2));

    }
}
