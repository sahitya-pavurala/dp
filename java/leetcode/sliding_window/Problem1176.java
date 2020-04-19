package leetcode.sliding_window;

/**
 * A dieter consumes calories[i] calories on the i-th day.
 *
 * Given an integer k, for every consecutive sequence of k days (calories[i], calories[i+1], ..., calories[i+k-1] for all 0 <= i <= n-k), they look at T, the total calories consumed during that sequence of k days (calories[i] + calories[i+1] + ... + calories[i+k-1]):
 *
 * If T < lower, they performed poorly on their diet and lose 1 point;
 * If T > upper, they performed well on their diet and gain 1 point;
 * Otherwise, they performed normally and there is no change in points.
 * Initially, the dieter has zero points. Return the total number of points the dieter has after dieting for calories.length days.
 *
 * Note that the total points can be negative.
 */
public class Problem1176 {

    private static int solution(int[] calories, int k, int lower, int upper) {
        int points = 0;
        int diet = 0;

        for (int i = 0; i < k;  i++){
            diet += calories[i];
        }

        if(diet > upper)
            points++;
        else if (diet < lower)
            points--;

        for(int i = k; i < calories.length; i++){
            diet += calories[i] - calories[i-k];
            if(diet > upper)
                points++;
            else if (diet < lower)
                points--;
        }

        return points;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,5}, 1, 3, 3));
        System.out.println(solution(new int[]{2,3}, 2, 0, 5));
    }

}
