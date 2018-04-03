package peuler;

/**
 * Created by sahityapavurala on 11/16/17.
 */
public class Helpers {

    public static boolean isPrime(long num){
        if(num % 2 == 0)
            return false;
        long half = (num/2 % 2==0)?num/2-1:num/2;
        for(int i = 3; i < half; i=i+2){
            if(num%i == 0)
                return false;
        }

        return true;
    }

    public static boolean isPalindrome(long num){
        String number = String.valueOf(num);
        int mid = 0;
        if(number.length() % 2 == 0)
            mid = number.length()/2;
        else
            mid = number.length()/2 - 1;

        for(int i = 0; i <= mid; i++) {
            if (number.charAt(i) != number.charAt(number.length() - i - 1))
                return false;
        }

        return true;
    }

    public static long getLCM(long a, long b){
        return (a*b)/getGCD(a,b);
    }



    public static long getGCD(long a, long b){

        if(a%b == 0)
            return b;
        else
            return getGCD(b,a%b);
    }
}
