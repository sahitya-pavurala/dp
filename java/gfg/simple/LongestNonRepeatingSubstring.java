package gfg.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by sahityapavurala on 10/3/17.
 */
public class LongestNonRepeatingSubstring {


    private static int compute(String str) {

        Map<Character,Integer> check = new HashMap<Character, Integer>();

        check.put(str.charAt(0),0);

        int curr_len = 1;
        int max_len = 1;
        int pre_idx = 0;

        for(int i =1; i < str.length(); i++){

            if (!check.containsKey(str.charAt(i)) || i - curr_len > check.get(str.charAt(i))){
                curr_len++;

            }

            else {
                if (curr_len > max_len)
                    max_len = curr_len;

                curr_len = i - check.get(str.charAt(i));

            }

            check.put(str.charAt(i),i);

        }

        if(curr_len > max_len)
            max_len = curr_len;

        return max_len;
    }

    public static void main(String[] args) {
        String str = "ABACDEFGAPQRSTU";
        System.out.println("The input string is "+str);
        int len = compute(str);
        System.out.println("The length of longest non-repeating substring is : "+ len);

    }


}
