package gfg.simple;

/**
 * Created by sahityapavurala on 9/29/17.
 */
public class LongestCommonSubsequence {

    public static String compute(String word1, String word2, String res){

        for(int i = word1.length()-1; i >= 0; i--){
            for(int j = word2.length()-1; j >= 0; j--){

                if(word1.charAt(i) == word2.charAt(j))
                    res += word1.charAt(i);
                else
                    return max(compute(word1.substring(0,i),word2,res), compute(word1,word2.substring(0,j),res));
            }
        }

        return new StringBuilder(res).reverse().toString();
    }


    private static String max(String word1, String word2) {

        if(word1.length() > word2.length())
            return word1;
        else return word2;
    }

    public static void main(String[] args){

        System.out.println(compute("abdgc", "agfpc", ""));
    }
}
