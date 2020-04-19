package leetcode.sliding_window;

import java.util.HashMap;

/**
 * Given a string S, return the number of substrings of length K with no repeated characters.
 */
public class Problem1100 {

    private static int solution(String S, int k) {

        if(k > S.length())
            return 0;

        HashMap<Character, Integer> checker = new HashMap<>();

        int left = 0;
        int right = 0;
        int result = 0;

        for(int i = 0; i < S.length(); i++){

            if(checker.size() == k) {
                result++;
            }

            char current = S.charAt(i);
            if(checker.containsKey(current)){
                left = checker.get(current) + 1;
                checker.put(current,i);
            }
            else
                checker.put(current, i);
        }

        while(right < S.length()){
            char current = S.charAt(right);

            if (checker.containsKey(current)) {

            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("haveafunonleetcode", 5));
    }
}
