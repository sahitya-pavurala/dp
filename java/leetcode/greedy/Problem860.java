package leetcode.greedy;

/**
 * At a lemonade stand, each lemonade costs $5.
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 * Note that you don't have any change in hand at first.
 * Return true if and only if you can provide every customer with correct change.
 */
public class Problem860 {

    private static boolean solution(int[] bills) {
        int fives = 0;
        int tens = 0;

        for (int i : bills) {
            if(i == 5){
                fives++;
            } else if(i == 10){
                tens++;
                fives--;
            } else {
                tens--;
                fives--;
            }

            if(tens < 0){
                fives -= 2;
                tens = 0;
            }

            if (fives < 0)
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,5,10}));
        System.out.println(solution(new int[]{5,5,5,10,20}));
        System.out.println(solution(new int[]{10,10}));
        System.out.println(solution(new int[]{5,5,10,5,20,5,5,5,5,5,20,5,10,5,5,5,5,20,20,5}));

    }
}