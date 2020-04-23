package leetcode.sliding_window;

/**
 * Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.

 On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.

 The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.

 Return the maximum number of customers that can be satisfied throughout the day.
 */
public class Problem1052 {

    private static int solution(int[] customers, int[] grumpy, int X) {
        int maxSatisfied = 0;


        for(int i = 0; i < grumpy.length; i++){
            if(grumpy[i] == 0)
                maxSatisfied += customers[i];
        }
        int end = 0;
        int start = 0;
        int maxWindow = 0;
        int currentWindow = 0;
        while(end < customers.length){
            int curr = customers[end];

            if(end - start < X){
                currentWindow += grumpy[end] * curr;
                end++;
                if(end - start == X){
                    maxWindow = Math.max(currentWindow, maxWindow);
                }
            } else {
                    currentWindow -= grumpy[start] * customers[start];
                    start++;
                }
            }
        return maxWindow + maxSatisfied;

        }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1},3));
    }
}
