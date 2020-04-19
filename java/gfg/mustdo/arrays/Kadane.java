package gfg.mustdo.arrays;

public class Kadane {

    public static int compute(int[] arr){

        int sofar = arr[0];
        int maxSum = arr[0];


        for(int i = 1; i < arr.length; i++) {

            if (sofar < 0)
                sofar = arr[i];
            else
                sofar += arr[i];

            maxSum = Math.max(sofar, maxSum);

        }
        return maxSum;
    }

}
