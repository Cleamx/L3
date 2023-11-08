package TD2.ex1;

public class testClass{

    public testClass(){}

    @Deprecated
    public static int oldMethod(){
        return 1;
    }

    public static void main(String[] args) {
       
        oldMethod();
    }
}