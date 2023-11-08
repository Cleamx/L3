package TD2.ex1;
/**
 * La classe testClass contient une méthode obsolète appelée oldMethod() qui renvoie une valeur entière
 * de 1.
 */

public class testClass{

    public testClass(){}

   /**
    * La fonction ci-dessus est une méthode obsolète en Java qui renvoie une valeur entière de 1.
    * 
    * @return oldMethod() renvoie une valeur entière de 1.
    */
    @Deprecated
    public static int oldMethod(){
        return 1;
    }

    public static void main(String[] args) {
       
        oldMethod();
    }
}