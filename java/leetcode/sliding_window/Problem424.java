package leetcode.sliding_window;

/**
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 */
public class Problem424 {

    private static int solution(String S, int K) {

        if(S == null || S.length() == 0)
            return 0;


        int left = 0;
        int right= 0;
        int mostFreqLetter = 0;

        int result = 0;
        int[] letterFreq = new int[26];

        while (right < S.length()) {
            int curr = S.charAt(right);

            letterFreq[curr - 'A']++;
            mostFreqLetter = Math.max(mostFreqLetter, letterFreq[curr - 'A']);

            if((right - left + 1) - mostFreqLetter > K){
                letterFreq[S.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABAB", 2));
        System.out.println(solution("AABABBA", 1));
    }
}