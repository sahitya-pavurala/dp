package leetcode.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *  Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class Problem215 {

    private static int solution(int [] nums, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > K)
                pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(solution(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}