package leetcode.sliding_window;

import java.util.HashSet;

/**
 * Given a string S, return the number of substrings of length K with no repeated characters.
 */
public class Problem1100 {

    private static int solution(String S, int k) {

        if(k > S.length())
            return 0;

        HashSet<Character> checker = new HashSet<>();


        int start = 0;
        int end = 0;
        int result = 0;

       while (end < S.length()){
            char curr = S.charAt(end);
            if(!checker.contains(curr) && checker.size() < k){
                end++;
                checker.add(curr);
                if(checker.size() == k)
                    result += 1;
            } else {
                checker.remove(S.charAt(start));
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("havefunonleetcode", 5));
    }
}
