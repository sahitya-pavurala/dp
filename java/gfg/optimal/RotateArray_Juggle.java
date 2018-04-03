package gfg.optimal;


import java.util.Arrays;

class RotateArray_Juggle{

    private static String rotate(int[] ip, int d) {

        int gcd__of_length_d = gcd(ip.length,d);

        for(int i = 0; i < gcd__of_length_d; i++){

            int current_loop_value = ip[i];


            int j = i;
            int k = 0;

            while(true){
                k = j + d;

                if(k >= ip.length)
                    k = k - ip.length;
                if( k == i)
                    break;
                ip[j] = ip[k];
                j = k;
            }

            ip[j] = current_loop_value;

        }


        return Arrays.toString(ip);

    }

    private static int gcd(int a, int b){

        if(b == 0)
            return a;
        else
            return gcd(b,a%b);

    }





      public static void main(String[] args){
        int[] ip = {1,2,3,4,5,6,7,8,9,10};
        int d = 4;

        System.out.println(rotate(ip,d));
      }

}
