package TD5.Thread;


public class Proc extends Thread {
    int compteur = 0;
    public Proc(){
       
    }

    public void dodo(long temps) throws InterruptedException{
        sleep(temps * 1000);
        compteur += 1;
        System.out.println(("Le thread " + compteur + " a attentdu " + temps + " secondes"));

    }

}
