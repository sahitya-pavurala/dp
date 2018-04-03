package gfg.simple;


import java.util.Arrays;

class RotateArray {

      public static String rotate(int[] arr, int d){
          int[] temp = new int[d];

          for(int  i = 0; i < d; i++)
              temp[i] = arr[i];

          for(int i = 0; i < arr.length - d; i++)
              arr[i] = arr[i+d];

          for(int i = 0; i < d; i++)
              arr[arr.length - d + i] = temp[i];

          return Arrays.toString(arr);
      }



  public static void main(String[] args){

      int[] ip = {1,2,3,4,5,6,7,8,9,10};
      int d = 4;

      System.out.println(rotate(ip,d));
  }
}
