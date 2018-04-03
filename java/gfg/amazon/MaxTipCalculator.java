package gfg.amazon;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by sahityapavurala on 11/7/17.
 */
public class MaxTipCalculator {


    public static int compute(int[] arrx, int[] arry, int x, int y, int n){

        int res = 0;
        //Arrays.sort(arrx);
        //Arrays.sort(arry);
        int[] diff_array = new int[n];
        //int pos = 0;
        for(int i = 0; i < n; i++){
            int val = arrx[i] - arry[i];
            diff_array[i] = val;
        }

        //int neg = n - pos;

        int i = 0;
        while(x > 0 && y > 0 && i < n){
            if(diff_array[i] > 0) {
                res += arrx[i];
                x-- ;
            }
                else {
                res += arry[i];
                y-- ;
            }

            i++;
        }

        if(i == n)
            return res;

        if (x == 0)
        {
            while(i < n)
            {
                res+= arry[i];
                i++;
            }

            return res;
        }

        while(i < n){
            res += arrx[i];
            i++;
        }


    return res;

    }


    public static int max(int a, int b){
        if(a >= b)
            return a;
        return b;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int num_cases = sc.nextInt();

        for(int i = 0; i < num_cases; i++){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int[] arrx = new int[n];
            int[] arry = new int[n];
            for(int j = 0; j < n; j++)
                arrx[j] = sc.nextInt();
            for(int j = 0; j < n; j++)
                arry[j] = sc.nextInt();

            System.out.println(compute(arrx, arry, x, y, n));
        }
        //code
    }
}
