package gfg.amazon;

import java.util.Arrays;


public class MaxPairProduct {

    public static int getProduct(int[] arr){

        int max_num = Math.max(arr[0], arr[1]);
        int min_num = Math.min(arr[0], arr[1]);

        int max_product = max_num * min_num;

        for (int i = 2; i < arr.length; i++){

            int val = arr[i];
            max_product = Math.max(max_product, Math.max(max_num*val,min_num*val));
            max_num = Math.max(max_num, val);
            min_num = Math.min(min_num, val);
        }

        return max_product;

    }

    public static void main(String[] args){
        System.out.println(getProduct(new int[]{1, -2, 8, 5, -5, -9}));
    }
}
