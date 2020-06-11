package leetcode.greedy;

import java.util.*;

/**
 * Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence.
 * If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements.
 * A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array.
 * Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.
 * */
public class Problem1403 {

    private static List<Integer> solution(int [] nums) {
        Arrays.sort(nums);
        int totalSum = 0;
        List<Integer> subSeq = new ArrayList<>();

        for(int i: nums)
            totalSum += i;

        int subSum = 0;
        for(int i = nums.length-1; i >=0; i--){
            subSum += nums[i];
            subSeq.add(nums[i]);
            if(subSum > totalSum - subSum){
                break;
            }
        }

        return subSeq;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,3,10,9,8}));
    }
}