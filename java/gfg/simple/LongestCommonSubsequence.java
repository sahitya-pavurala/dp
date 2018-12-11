package gfg.simple;

/**
 * Created by sahityapavurala on 9/29/17.
 */
public class LongestCommonSubsequence {

    public static String compute(String word1, String word2){

       if(word1.length() == 0 || word2.length() ==0)
           return "";



       if(word1.charAt(word1.length() -1) == word2.charAt(word2.length()-1))
                return compute(word1.substring(0,word1.length()-1), word2.substring(0, word2.length()-1)) + word1.charAt(word1.length() -1);
            else
                return max(compute(word1.substring(0,word1.length()-1),word2), compute(word1,word2.substring(0,word2.length()-1)));

        }



    private static String max(String word1, String word2) {

        if(word1.length() > word2.length())
            return word1;
        else return word2;
    }

    public static void main(String[] args){

        System.out.println(compute("abdgca", "agfpcaa"));
    }
}
