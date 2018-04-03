package gfg.simple;

import java.util.HashSet;
import java.util.Map;

/**
 * Created by sahityapavurala on 10/7/17.
 */
public class CoinChange {

    private static int compute(int[] arr, int m, int n) {

        if(n == 0)
           return 1;

        if (n < 0)
            return 0;

        if(m <= 0 && n > 0)
            return 0;

        else return compute(arr, m -1 , n) + compute(arr, m, n - arr[m-1]);

    }


    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;

        System.out.println(compute(arr, m, n));
    }

}
