package gfg.mustdo.arrays;

public class EquillibriumPoint {

    public static int compute(int[] arr){

        if(arr.length == 1)
            return 1;
        else if (arr.length == 2)
            return -1;

        int prefix_sum = arr[0];
        int equi =1;
        int suffix_sum = 0;
        for(int i = equi+1; i < arr.length;  i++)
            suffix_sum += arr[i];

        while(equi <= arr.length-2){

            if(prefix_sum == suffix_sum)
                return equi;

            else if (prefix_sum < suffix_sum){
                prefix_sum += arr[equi];
                suffix_sum -= arr[equi+1];
                equi += 1;
            }

            else
                return -1;
        }


        return equi;

    }
}
