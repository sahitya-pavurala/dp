package leetcode.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * There are 2N people a company is planning to interview.
 * The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 */
public class Problem1029 {

    private static int solution(int[][] costs) {

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        int total = 0;

        for(int[] cost : costs) {
            int diff = cost[0] - cost[1];
            if (diff > 0) {
                B.add(diff);
                total += cost[1];
            } else {
                A.add(-1 * diff);
                total += cost[0];
            }
        }

            Collections.sort(A);
            Collections.sort(B);

            int check = A.size() - B.size();


            if(check > 0){
                for(int i = 0; i < check/2; i++)
                    total += A.get(i);
            } else if(check < 0){
                check *= -1;
                for(int i = 0; i < check/2; i++)
                    total += B.get(i);
            }

            return total;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{new int[]{10,20}, new int[]{30,200}, new int[]{400,50}, new int[]{30,20}}));
    }
}