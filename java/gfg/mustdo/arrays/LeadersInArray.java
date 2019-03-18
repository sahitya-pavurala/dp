package gfg.mustdo.arrays;

public class LeadersInArray {

    public static String compute(int[] arr){


        int maxtillnow = arr[arr.length-1];
        String result = "" + maxtillnow;
        for(int i = arr.length - 2; i >= 0; i--){
            if (arr[i] >= maxtillnow) {
                maxtillnow = arr[i];
                result = maxtillnow + " " + result;
            }
        }

        return result;
    }
}
