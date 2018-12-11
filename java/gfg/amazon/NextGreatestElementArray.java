package gfg.amazon;

import java.util.Arrays;

public class NextGreatestElementArray {

    public static int[] getResultArray(int[] arr){


        int max_from_right = arr[arr.length -1];

        arr[arr.length-1] = -1;

        for(int i = arr.length -2 ; i >= 0; i--){
            int temp = arr[i] ;

            arr[i] = max_from_right;

            if (max_from_right < temp)
                max_from_right = temp;

        }

        return arr;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(getResultArray(new int[]{16, 17, 4, 3, 5, 2})));
    }
}
