package leetcode.heap;

import java.util.*;

/**
 * Given an array nums sorted in ascending order,
 * return true if and only if you can split it into 1 or more subsequences
 * such that each subsequence consists of consecutive integers and has length at least 3.
 * */
public class Problem659 {

    private static boolean solution(int [] nums) {

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new CustomComparator());

        HashMap<Integer, Integer> intMap = new HashMap<>();
        for(int i: nums){
            intMap.put(i, intMap.getOrDefault(i, 0)+1);
        }

        maxHeap.addAll(intMap.entrySet());
        int pre = maxHeap.peek().getKey()-1;
        int currCount = 0;
        while (!maxHeap.isEmpty()){

            Map.Entry<Integer, Integer> entry = maxHeap.poll();

            if(entry.getKey() != pre + 1 || entry.getValue() == 0) {
                if(currCount < 3)
                    return false;
                currCount = 0;
            }
            entry.setValue(entry.getValue() -1);
            pre = entry.getKey();
            currCount++;

            if(entry.getValue() > 0)
                maxHeap.add(entry);

        }

        return currCount >= 3;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(solution(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
    }

    private static class CustomComparator implements Comparator<Map.Entry<Integer,Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey() - o2.getKey();
            }

            return o2.getValue() - o1.getValue();
        }
    }
}