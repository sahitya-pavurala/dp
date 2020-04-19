package leetcode.sliding_window;

/**
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 *
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 */
public class Problem1004 {

    private static int solution(int[] barray, int K) {

        int numZeros = K;
        int result = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;

        while (right < barray.length) {

            int curr = barray[right];
            if (curr == 1) {
                right++;
                result = Math.max(result, right - left);
            } else if (numZeros > 0) {
                right++;
                result = Math.max(result, right - left);
                numZeros--;
            } else {
                if (barray[left] == 0)
                    numZeros++;
                left++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(solution(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 0));
    }
}