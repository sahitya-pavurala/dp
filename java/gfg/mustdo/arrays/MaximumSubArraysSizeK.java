package gfg.mustdo.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSubArraysSizeK {

    public static String compute(int[] arr, int k){

        PriorityQueue<Integer> pqueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }
        });
        String result = "";
        int i = 0;
        while(i < k){
            pqueue.add(arr[i]);
            i++;
        }

        for(int j = 0; j< arr.length-k; j++){
            result += pqueue.peek() + " ";
            pqueue.remove(arr[j]);
            pqueue.add(arr[j+k]);
        }

        result += pqueue.peek();

        return result;
    }
}
