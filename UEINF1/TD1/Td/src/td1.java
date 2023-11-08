

public class td1 {
    public static void main(String[] args) {
        int resMain = addition(3, 5);
        System.out.println(resMain);

        int test[] = {1,2,4,3};
        resMain = addition2(test);
        System.out.println(resMain);
    }

    
    /**
     * La fonction « addition » prend deux entiers en entrée et renvoie leur somme.
     * 
     * @param a Le paramètre « a » est une valeur entière qui représente le premier nombre à ajouter.
     * @param b Le paramètre "b" est une valeur entière transmise à la méthode "addition".
     * @return La somme des deux entiers d’entrée, a et b, est renvoyée.
     */
    public static int addition(int a, int b) {
        int res = a + b;
        return res;
    }

    
    /**
     * La fonction "addition2" prend un tableau d'entiers en entrée et renvoie la somme de tous les
     * éléments du tableau.
     * 
     * @param array Le paramètre "array" est un tableau d'entiers qui contient les nombres à
     * additionner.
     * @return La méthode renvoie la somme de tous les éléments du tableau d’entrée.
     */
    public static int addition2(int [] array){
        int res2 = 0;

        for(int i = 0; i < array.length; i++){
            res2 += array[i];
        }
        return res2;
    }
}
