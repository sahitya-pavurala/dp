package leetcode.heap;

import java.util.PriorityQueue;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */
public class Problem1046 {

    private static int solution(int[] stones) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a, b) -> (b - a));

        for(int i: stones){
            pQueue.add(i);
        }

        while(pQueue.size() >= 2){
            int x = pQueue.poll();
            int y = pQueue.poll();

            if(x != y) {
                pQueue.add(Math.abs(y-x));
            }
        }

        if(pQueue.isEmpty())
            return 0;

        return pQueue.poll();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,7,4,1,8,1}));
    }

}