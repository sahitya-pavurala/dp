package gfg.mustdo.arrays;

public class SubArraySum {

    public static String compute(int[] arr, int num){
        int start = 0;
        int end = 0;

        int current_sum = arr[start];

        while(end < arr.length){
            if (current_sum == num)
                return (start + 1) + " " + (end + 1);

            else if(current_sum < num){
                end += 1;
                current_sum += arr[end];
            }

            else {
                current_sum -= arr[start];
                start += 1;
            }

        }

        return "-1";

    }

}
