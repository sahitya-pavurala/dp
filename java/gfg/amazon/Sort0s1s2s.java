package gfg.amazon;

import java.util.Arrays;

public class Sort0s1s2s {

    public static int[] getSortedArray(int[] arr){
        int back = arr.length -1;
        int front = 0;
        int mid  = 0;
        int val = 0;
        while(mid <= back){

            int temp = arr[mid];
            if(temp == 0){
                val = arr[front];
                arr[front] = arr[mid];
                arr[mid] = val;
                front++;
                mid++;
                continue;
            }

            else if(temp == 1){
                mid++;
                continue;
            }

            else if(temp == 2){
                val = arr[mid];
                arr[mid] = arr[back];
                arr[back] = val;
                back--;
                continue;
            }
        }

        return arr;
    }



    public static void main(String[] args){
        System.out.println(Arrays.toString(getSortedArray(new int[]{2,1,2,0,2,0,1,0})));
    }
}
