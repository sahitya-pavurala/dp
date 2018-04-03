package gfg.amazon;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by sahityapavurala on 11/8/17.
 */
public class BinaryString1 {

    public static char compute(String bin_number,int k, int num_iterations){

        int jump_val = 1;
        String res = "";

        HashMap<String,String> checker = new HashMap<String,String>();
        checker.put("0","01");
        checker.put("1","10");
        checker.put("01","0110");
        checker.put("10","1001");
        checker.put("00","0101");
        checker.put("11","1010");


        while(num_iterations > 0){
            String temp_res = "";
            String previous = "";
            String changing_val = "";
            boolean flag = false;
            for(int i = 0; i < bin_number.length()-jump_val+1; i = i+jump_val){

                String current = bin_number.substring(i,i+jump_val);

                if(!checker.containsKey(current)){
                    String temp = "";
                    for(int z = 0; z < current.length()-1; z = z+2)
                        temp += checker.get(current.substring(z,z+2));
                    checker.put(current,temp);
                }

                temp_res += checker.get(current);
                changing_val += checker.get(current);

                if(flag && !checker.containsKey(previous+current)) {
                    checker.put(previous+current,changing_val);
                    changing_val = "";
                }
                flag = !flag;

                previous = current;
            }



            checker.put(bin_number,temp_res);
            res = temp_res;
            bin_number = temp_res;
            jump_val *= 2;
            num_iterations--;

        }

        return res.charAt(k);

    }
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int num_cases = sc.nextInt();

        for(int i = 0; i< num_cases; i++){
            String bin_number = Integer.toBinaryString(sc.nextInt());
            int k = sc.nextInt();
            int num_iterations = sc.nextInt();

            System.out.println(compute(bin_number,k,num_iterations));

        }
    }
}

