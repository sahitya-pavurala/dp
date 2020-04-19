package gfg.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> check = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(check.containsKey(nums[i])){
                result[0] = check.get(nums[i]);
                result[1] = i;
                break;
            }
            check.put(diff,i);
        }

        return result;

    }

    public static void main(String[] args){
        int[] A = {2,5,3,6};
        System.out.println(Arrays.toString(twoSum(A,9)));
    }

}
