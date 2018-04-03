package gfg.optimal;

/**
 * Created by sahityapavurala on 10/3/17.
 */
public class LongestNonRepeatingSubstring_1 {


    private static int compute(String str) {
        int[] check = new int[256];

        for(int i = 0; i < check.length; i++)
            check[i] = -1;

        check[str.charAt(0)] = 0;
        int pre_idx = 0;
        int curr_len = 1;
        int max_len = 1;

        for(int i = 1; i < str.length(); i++) {

            pre_idx = check[str.charAt(i)];

            if (pre_idx == -1 || i - curr_len > pre_idx)
                curr_len += 1;
            else {
                if (curr_len > max_len)
                    max_len = curr_len;

                curr_len = i - pre_idx;

            }
            check[str.charAt(i)] = i;
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
