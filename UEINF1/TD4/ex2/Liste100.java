package TD4.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Liste100 {
    public static void main(String[] args) {
        
        List<Integer> liste = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {

            liste.add((int) (Math.random()*1000));
        }

        System.out.println(liste);

        Collections.sort(liste);

        System.out.println(liste);

    }
}
