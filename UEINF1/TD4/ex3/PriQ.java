package TD4.ex3;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriQ {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        int j = 0;
        for (int i = 0; i < 100; i++) {
            queue.add((int) (Math.random()*1000));
        }
        while (j != queue.size()) {
            System.out.println(queue.poll());
            j++;
        }
    
    }
    
}
