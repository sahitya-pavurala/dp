package leetcode.sliding_window;

/**
 * Given a binary array data,
 * return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.
 */
public class Problem1151 {

    private static int solution(int[] barray) {

        int num1s = 0;


        for (int i : barray) {
            if (i == 1)
                num1s++;
        }

        if(num1s <= 1)
            return 0;


        int left = 0;
        int right = 0;
        int numsub1s = 0;
        int minSwaps = Integer.MAX_VALUE;
        while (right < barray.length) {

            int curr = barray[right];

            if(curr == 1)
                numsub1s++;

            if (right - left < num1s) {
                right++;
                if (right - left == num1s) {
                    minSwaps = Math.min(minSwaps, num1s - numsub1s);
                    if (barray[left] == 1)
                        numsub1s--;
                    left++;
                }
            }
            else{
                right++;
                left++;
            }
        }

        return minSwaps;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,0,1,0,1}));
        System.out.println(solution(new int[]{1,0,1,0}));
        System.out.println(solution(new int[]{1,0,1,0,1,1}));
        System.out.println(solution(new int[]{1,1,0,1,1}));
        System.out.println(solution(new int[]{1,1,1,1}));
    }

}
