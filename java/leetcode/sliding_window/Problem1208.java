package leetcode.sliding_window;

/**
 * You are given two strings s and t of the same length. You want to change s to t.
 * Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.
 * You are also given an integer maxCost.

 Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost.

 If there is no substring from s that can be changed to its corresponding substring from t, return 0.

 */
public class Problem1208 {

    private static int solution(String s, String t, int maxCost) {

        int maxSubStrLen = 0;

        int left = 0;
        int right = 0;

        int currentCost = 0;
        while(right < s.length()){

            int schar = s.charAt(right);
            int tchar= t.charAt(right);
            currentCost += Math.abs(schar - tchar);
            right++;
            if(currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            if(currentCost <= maxCost){
                maxSubStrLen = Math.max(maxSubStrLen, right - left);
            }

        }

        return maxSubStrLen;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcd", "bcdf",  3));
        System.out.println(solution("abcd", "cdef",  3));
        System.out.println(solution("abcd", "acde",  0));
    }
}