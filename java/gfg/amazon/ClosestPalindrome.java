package gfg.amazon;

import java.util.Arrays;

/*
Given a number N.
our task is to find the closest Palindrome number whose absolute difference with given number is minimum.
 */
public class ClosestPalindrome {

    public static int getClosestPalindromeNumber(int num){
        if (num/10 == 0)
            return num;

        String numStr = String.valueOf(num);
        String mid = "";
        String prefix = numStr.substring(0,numStr.length() / 2);

        if(numStr.length() % 2 != 0)
            mid = numStr.substring(numStr.length() / 2, numStr.length() / 2 + 1);

        StringBuilder sb = new StringBuilder();
        sb.append(prefix+mid);

        StringBuilder suffix = new StringBuilder();
        for(int i = 0; i < prefix.length(); i++){
            if(prefix.charAt(i) == numStr.charAt(numStr.length()-1-i))
                suffix.append(prefix.charAt(i));
            else
                suffix.append(prefix.charAt(i));
        }

        sb.append(suffix.reverse().toString());


        int num2 = Integer.parseInt(sb.toString());

        return num2;

    }

    public static boolean isPalindrome(String word){
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    public static void main(String[] args){
        System.out.println(getClosestPalindromeNumber(9));
        System.out.println(getClosestPalindromeNumber(489));
        System.out.println(getClosestPalindromeNumber(1123343));
        System.out.println(getClosestPalindromeNumber(31231));
    }
}
