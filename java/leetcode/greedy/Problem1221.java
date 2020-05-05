package leetcode.greedy;

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings.
 * */
public class Problem1221 {

    private static int solution(String s) {
        int count = 0;
        int result =0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'R')
                count++;
            else if(s.charAt(i) == 'L')
                count--;

            if(count == 0)
                result++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("RLRRLLRLRL"));
        System.out.println(solution("RLLLLRRRLR"));
        System.out.println(solution("LLLLRRRR"));
        System.out.println(solution("RLRRRLLRLL"));
    }
}