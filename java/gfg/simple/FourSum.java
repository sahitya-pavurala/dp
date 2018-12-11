package gfg.simple;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target){

        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int max = arr[arr.length-1];
        if(arr[0] * 4 > target || max * 4 < target)
            return result;


        for(int i = 0; i < arr.length; i++){
            int num = arr[i];

            if(i > 0 && num == arr[i-1])
                continue;
            if(num + max * 3 < target)
                continue;
            if(num * 4 > target)
                break;
            if(num * 4 == target){
                if(i + 3 < arr.length && arr[i+3] == num)
                    result.add((ArrayList<Integer>) Arrays.asList(num, num, num, num));
                break;
            }

            threeSum(arr, target-num, i+1, arr.length - 1, result, num);

        }

        return result;
    }

    public static void threeSum(int[] arr, int target,int low, int high, ArrayList<ArrayList<Integer>> fourSumLst, int num1){
        if(low + 1 >= high)
            return;

        int max = arr[high];
        if(arr[low] * 3 > target || max * 3 < target)
            return;

        for(int i = low; i < high; i++){
            int num = arr[low];

            if(i > low && arr[i-1] == num)
                continue;
            if(num + max * 2 < target)
                continue;
            if(num * 3 > target)
                break;
            if(num * 3 == target){
                if(i + 1 < high && arr[i+2] == num)
                    fourSumLst.add((ArrayList<Integer>) Arrays.asList(num1,num,num,num));
                break;
            }

            twoSum(arr,target - num, low+1, high, fourSumLst, num1, num);

        }

    }

    public static void twoSum(int[] arr, int target, int low, int high, ArrayList<ArrayList<Integer>> fourSumLst, int num1,int num2){
        if(low >= high)
            return;

        if(2 * arr[low] > target || 2 * arr[high] < target)
            return;

        int sum = 0;
        int x;
        while(low < high){
            sum = arr[low] + arr[high];
            if(sum == target){
                fourSumLst.add((ArrayList<Integer>) Arrays.asList(num1, num2, arr[low], arr[high]));
            }

            x = arr[low];
            while(++low < high && arr[low] == x)
                ;
            x = arr[high];
            while (low < --high && arr[high] == x)
                ;

            if(sum < target)
                low++;
            if(sum > target)
                high--;
        }
        return;
    }

    public static void main(String[] args){
        int[] arr = {1, 0, -1, 0, -2, 2};

        ArrayList<ArrayList<Integer>> result = fourSum(arr, 0);
        for(ArrayList<Integer> lst: result) {
            System.out.println("hello");
            System.out.println(lst.toArray().toString());
        }

    }
}
