package gfg.mustdo.arrays;

public class MaxSumIncreasingSubSequence {

    public static int compute(int[] arr) {

        int[] lis = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            lis[i] = arr[i];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + arr[i])
                    lis[i] = lis[j] + arr[i];
            }
        }

        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < lis.length; i++)
                max_sum = Math.max(max_sum, lis[i]);

        return max_sum;
    }
}
