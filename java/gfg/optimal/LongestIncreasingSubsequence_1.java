package gfg.optimal;



/**
 * Created by sahityapavurala on 9/29/17.
 */
public class LongestIncreasingSubsequence_1 {

    public static int getCeilIndex(int[] arr, int a, int z, int val){

        while(z - a > 1){

            int m = a + (z - a) /2;

            if(arr[m] < arr[0])
                a = m;
            else if (arr[m] >= arr[z])
                z = m;
        }

        return z;
    }

    public static int compute(int[] arr){
        int[] res = new int[arr.length];
        res[0] = arr[0];

        int len =1;

        for(int i = 1; i < arr.length; i++){

            if (arr[i] < res[0])
                res[0] = arr[i];
            else if(arr[i] > res[len-1])
                res[len++] = arr[i];
            else
                res[getCeilIndex(res, -1, arr.length-1, arr[i])] = arr[i];

        }

        return len;
    }

    public static int compute_2(int[] arr){

        int[] lis = new int[arr.length];

        for(int i=0; i < lis.length;i++)
            lis[i] = 1;

        for (int i = 1; i< arr.length; i++){
            for(int j =0; j < arr.length; j++){

                if (arr[i] > arr[j] && lis[i] < lis[j]+1)
                    lis[i] = lis[j] + 1;
            }
        }

        int result = 0;
        for(int num : lis)
            result = Math.max(result, num);

        return result;

    }




    public static void main(String[] args){

        int[] input = {8, 9, 11, 6, 12, 14};
        System.out.println(compute(input));
        System.out.println(compute_2(input));
    }
}
