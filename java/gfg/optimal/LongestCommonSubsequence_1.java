package gfg.optimal;

import static java.lang.Math.max;

/**
 * Created by sahityapavurala on 9/29/17.
 */
public class LongestCommonSubsequence_1 {


    public static String compute(String word1, String word2){

        String res = "";
        int m = word1.length();
        int n = word2.length();

        int[][] check = new int[m+1][n+1];

        for(int i=0; i <= m; i++){
            for(int j=0; j <= n; j++ ){

                if( i == 0 || j ==0)
                    check[i][j] = 0;

                else if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    res += word1.charAt(i-1);
                    check[i][j] = check[i - 1][j - 1] + 1;
                }
                else
                    check[i][j] = max(check[i][j-1], check[i-1][j]);

            }
        }

        return res;

    }
    public static void main(String[] args){

        System.out.println(compute("abdgc", "agfpc"));
    }
}
