package leetcode.greedy;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.
 * (We may choose the same index i multiple times.)Return the largest possible sum of the array after modifying it in this way.
 */
public class Problem1005 {

    private static int solution(int[] A, int K) {
       int maxSum = 0;

       Arrays.sort(A);

       int i = 0;
       while (i < A.length && A[i] < 0 && K > 0) {
           A[i] = --A[i++];
           K--;
       }

       for(int num : A)
           maxSum += num;





       return maxSum;


    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,2,3}, 1));
        System.out.println(solution(new int[]{3,-1,0,2}, 3));
        System.out.println(solution(new int[]{-8,3,-5,-3,-5,-2}, 6));
    }
}