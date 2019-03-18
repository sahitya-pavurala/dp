package gfg.mustdo.arrays;

import java.util.Arrays;

public class ReverseArrayInGroups {

    public static String compute(int[] arr, int k){

        for(int i = 0; i< arr.length; i = i + k){
           int left = i;
           int right = Math.min(i+k-1, arr.length-1);
           while(right > left){
               int temp = arr[right];
               arr[right] = arr[left];
               arr[left] = temp;
               right -= 1;
               left += 1;
           }
        }

        return Arrays.toString(arr);
    }
}
