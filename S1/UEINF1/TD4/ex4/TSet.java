package TD4.ex4;

import java.util.Set;
import java.util.TreeSet;

public class TSet {
    public static void main(String[] args) {
        Set<Integer> ensemble = new TreeSet<Integer>();
        
        for (int i = 0; i < 1000; i++) {

            ensemble.add((int) (Math.random()*10));
        }
        System.out.println(ensemble);
        
    }
}
