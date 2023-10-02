public class TestDes {
    public static void main(String[] args){
        Des d = new Des(6);
        Des d1 = new Des("Dédé");
        Des d2 = new Des();

        System.out.println(d);
        System.out.println(d1);
        System.out.println(d2);
        
        System.out.println(d2.lancer());

        System.out.println(d.lancer(5));
        
    }
   
}
