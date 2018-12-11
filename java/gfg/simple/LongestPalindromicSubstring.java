package gfg.simple;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestPalindromicSubstring {

    int defaultVal  = -1;
    int left = defaultVal;
    int right = defaultVal;
    String result = null;



    public  void getLongestPalindromicSubstring(String s, int left, int right, int[][] dp){

        if(dp[left][right] != this.defaultVal)
            return ;
        if(isPalindrome(s.substring(left, right+1))){
            dp[left][right] = 1;
            if ((right - left)   >= (this.right - this.left)){
                this.right = right;
                this.left = left;
                this.result = s.substring(left,right+1);
            }
            return;
        }

        dp[left][right] = 0;

        getLongestPalindromicSubstring(s, left+1, right, dp);
        getLongestPalindromicSubstring(s, left, right-1, dp);


    }

    public static boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0; i < len/2; i++){
            if (s.charAt(i) != s.charAt(len - 1 - i))
                return false;
        }

        return true;
    }


    public static void main(String[] args){

        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();

        String input = "abcda";
        int[][] dp = new int[input.length()][input.length()];

        for(int[] arr: dp){
            Arrays.fill(arr, sol.defaultVal);
        }

        sol.getLongestPalindromicSubstring(input,0, input.length()-1, dp);
        System.out.println(sol.result);

    }
}
