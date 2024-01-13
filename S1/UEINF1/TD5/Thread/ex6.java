package TD5.Thread;

public class ex6 {
    
    public static void main(String[] args) throws InterruptedException {
        Proc a = new Proc();
        for (int i = 0; i < 10; i++) {
            a.dodo((long) (Math.random() * (10 - 0)) + 0);
        }
    }
}
