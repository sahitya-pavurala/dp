package leetcode.greedy;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * */
public class Problem122 {

    private static int solution(int[] prices) {
        int profit = 0;
        int pre = Integer.MAX_VALUE;

        for(int i : prices){
            if (i > pre){
                profit += i - pre;
            }

            pre = i;
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,1,5,3,6,4}));
        System.out.println(solution(new int[]{1,2,3,4,5,6}));
        System.out.println(solution(new int[]{7,6,4,3,1}));
    }
}