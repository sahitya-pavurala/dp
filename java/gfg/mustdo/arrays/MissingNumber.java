package gfg.mustdo.arrays;

public class MissingNumber {



    public static void main(String[] args){

        int[] arr = {1,3,4,5,6};
        System.out.println(compute(arr));

        arr = new int[]{1,2,3,4,6,7};
        System.out.println(compute(arr));

        arr = new int[]{1,2,3,4,5,7};
        System.out.println(compute(arr));

        arr = new int[]{2,3,4,5,6};
        System.out.println(compute(arr));
    }

    private static int compute(int[] arr) {

        int n = arr.length;
        if(arr[0] != 1)
            return 1;

        return recurse(arr, 0, n-1);

    }

    public static int recurse(int[] arr, int start, int end){

        if(arr[start] + 2 == arr[end])
            return arr[start] + 1;


        int mean = (arr[start] + arr[end])/2;
        int mid = (start + end) / 2;

        if(arr[mid] > mean)
            return recurse(arr, start, mid);

        return recurse(arr,mid, end);

    }
}
