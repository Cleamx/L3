package TD4.ex5;

import java.util.HashMap;
import java.util.Map;


public class Hmap {
    public static void main(String[] args) {
        Map<Integer, String> tableauAssociatif = new HashMap<>();
        tableauAssociatif.put(20191218, "BUTEAU   LUCIA");
        tableauAssociatif.put(20190628, "CASTELLI   SERENA ");
        tableauAssociatif.put(20190556, "JOND   JEAN ");
        tableauAssociatif.put(20192688, "LEFEVRE   JULIEN");
        tableauAssociatif.put(20190628, "MARIACCIA   MARIE-DOMINIQUE");
        System.out.println(tableauAssociatif);


    }
}
