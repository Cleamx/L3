package Td1.Td.src;

public class td4 {
    public static void main(String[] args) {
        int tab[] = {1,2,3,4};
        System.out.println("La moyenne est de : " + moyenne(tab));
    }

    public static float moyenne(int array []){
        float resMoyenne = 0;

        for(int i = 0; i < array.length; i++){
            resMoyenne += array[i];
        }
        resMoyenne = resMoyenne / array.length;
        return resMoyenne;
    }
}
