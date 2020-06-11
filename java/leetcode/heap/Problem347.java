package leetcode.heap;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 */
public class Problem347 {

    private static String solution(int [] nums, int K) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        PriorityQueue<Integer> mostFreq = new PriorityQueue<>((a,b) -> freq.get(b) - freq.get(a));

        int[] result = new int[K];

        for(int i: nums){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        mostFreq.addAll(freq.keySet());

        for(int i=0; i < K; i++){
            result[i] = mostFreq.poll();
        }

        return Arrays.toString(result);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(solution(new int[]{1}, 1));
        System.out.println(solution(new int[]{-1, -1}, 1));
    }
}