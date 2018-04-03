package gfg.simple;


class LongestIncreasingSubsequence{

    public static int compute(int[] arr){
        if(arr.length == 1)
            return 1;

        int max = 1;
        int[] res = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
            res[i] = 1;


        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j< arr.length; j++){

                if(arr[j] < arr[i] && res[j] + 1 > res[i])
                    res[i] = res[j] + 1;
            }
        }

        for(int i : res){
            if(i > max)
                max = i;
        }


        return max;
    }


    public static void main(String[] args){

        int[] input = {8, 9, 11, 6, 12, 14};

        System.out.println(compute(input));

    }


}