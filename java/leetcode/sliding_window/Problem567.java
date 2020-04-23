package leetcode.sliding_window;

import java.util.HashSet;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 */
public class Problem567 {

    private static boolean solution(String S1, String S2) {
        int[] S1letters = new int[26];
        for (int i = 0; i < S1.length(); i++) {
            S1letters[S1.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = S1.length();
        boolean flag = false;
        while (right < S2.length()) {
            char curr = S2.charAt(right++);
            S1letters[curr - 'a']--;

            if(S1letters[curr - 'a'] >= 0) {
                count--;
            }

            if (count == 0)
                return true;

            if (right - left  == S1.length() && S1letters[S2.charAt(left++) - 'a']++ >=0){
                count++;
                //S1letters[S2.charAt(left)]++;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution("ab", "eidbaooo"));
        System.out.println(solution("ab", "eidboaoo"));
    }
}