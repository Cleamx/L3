public class td4 {
    public static void main(String[] args) {
        int tab[] = {1,2,3,4};
        System.out.println("La moyenne est de : " + moyenne(tab));
    }

   /**
    * La fonction calcule la moyenne d'un tableau d'entiers.
    * 
    * @param array Le paramètre "array" est un tableau d'entiers qui contient les nombres dont vous
    * souhaitez calculer la moyenne.
    * @return La méthode renvoie la moyenne (moyenne) des éléments du tableau d'entrée sous forme de
    * valeur flottante.
    */
    public static float moyenne(int array []){
        float resMoyenne = 0;

        for(int i = 0; i < array.length; i++){
            resMoyenne += array[i];
        }
        resMoyenne = resMoyenne / array.length;
        return resMoyenne;
    }
}
