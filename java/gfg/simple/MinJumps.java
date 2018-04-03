package gfg.simple;

import java.util.Arrays;

/**
 * Created by sahityapavurala on 10/4/17.
 */
public class MinJumps {


    private static int compute(int[] arr, int n) {

        int[] res = new int[arr.length];
        res[n-1] = 1;
        int reach_max = n-1;
        for(int i = n - 2 ; i >= 0; i--){
            if (arr[i] <= 0)
                res[i] = 0;

            else if(arr[i]+i >= n-1) {
                res[i] = 1;
                reach_max = i;
            }
            else {
                if (arr[i] + i >= reach_max) {
                    res[i] = res[reach_max] + 1;
                }
                else
                    res[i] = res[arr[i] + i] + 1;
            }

        }

        System.out.println(Arrays.toString(res));
        return res[0];

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 6, 1, 0, 9};

        System.out.println("Minimum number of jumps to reach end is : "+
                compute(arr1, arr1.length));

        int[] arr2 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        System.out.println("Minimum number of jumps to reach end is : "+
                compute(arr2, arr2.length));

    }

}
