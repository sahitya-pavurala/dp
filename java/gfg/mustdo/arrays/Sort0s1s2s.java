package gfg.mustdo.arrays;

import java.util.Arrays;

public class Sort0s1s2s {

    public static String compute(int[] arr){
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;

        while(mid < end){

            if (arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[start];
                arr[start] = temp;
                start += 1;
                mid += 1;
            }

            else if (arr[mid] == 2){
                int temp = arr[mid];
                arr[mid] = arr[end];
                arr[end] = temp;
                end -= 1;
            }

            else{
                mid += 1;
            }
        }

        return Arrays.toString(arr);
    }

}
