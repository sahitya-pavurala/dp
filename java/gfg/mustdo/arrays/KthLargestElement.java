package gfg.mustdo.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static int compute(int[] arr,int k){

        PriorityQueue<Integer> pqueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }
        });

        for(int i : arr){
            pqueue.add(i);
        }


        while(k > 1) {
            pqueue.poll();
            k -= 1;
        }

        return pqueue.peek();
    }
}
