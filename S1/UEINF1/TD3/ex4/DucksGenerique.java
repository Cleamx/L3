package TD3.ex4;

public class DucksGenerique <T> {
    
    public T riri;
    public T fifi;
    public T loulou;

    public DucksGenerique(T riri, T fifi, T loulou){
        this.riri = riri;
        this.fifi = fifi;
        this.loulou = loulou;
    }


    public T getRiri() {
        return riri;
    }
    public T getFifi() {
        return fifi;
    }
    public T getLoulou() {
        return loulou;
    }

    public void affiche() {
        System.out.println("Riri: " + riri);
        System.out.println("Fifi: " + fifi);
        System.out.println("Loulou: " + loulou);
    }
    
}
