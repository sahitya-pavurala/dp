package leetcode.greedy;

/**
 There are some chips, and the i-th chip is at position chips[i].
 You can perform any of the two following types of moves any number of times (possibly zero) on any chip:
 Move the i-th chip by 2 units to the left or to the right with a cost of 0.
 Move the i-th chip by 1 unit to the left or to the right with a cost of 1.
 There can be two or more chips at the same position initially.
 Return the minimum cost needed to move all the chips to the same position (any position).
 */
public class Problem1217 {

    private static int solution(int[] chips) {
        int even = 0;

        for(int i: chips) {
            if(i % 2 == 0)
                even++;
        }

        return Math.min(even, chips.length - even);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{2,2,2,3,3}));

    }
}