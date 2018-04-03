package peuler;

import java.util.Arrays;

/**
 * Created by sahityapavurala on 11/16/17.
 */
public class Problem1_to_10 {

    public static int problem1(){

        int result = 0;
        for(int i = 0 ; i < 1000; i++){
            if(i % 3 == 0 || i % 5 == 0)
                result += i;
        }

        return result;
    }

    public static long problem2(){


        long a = 1;
        long b = 1;
        long c = 0;

        long result = 0;

        while(c < 4000000){
            c = a + b;

            if(c % 2 == 0)
                result += c;

            a = b;
            b = c;
        }

        return result;
    }

    public static long problem3(){

        long n = 600851475143L;
        long d = 2;
        long result = 1;

        while(n/d >= 3){
            long factor = n / d;
            if(n % factor == 0 && Helpers.isPrime(factor)) {
                result = factor;
                break;
            }
            d++;
        }

        return result;

    }

    public static long problem4(){

        long max =0;

        for(long i = 999; i >= 100; i--){
            for(long j = 999; j >= 100; j--){

                if (Helpers.isPalindrome(i*j) && i*j > max)
                    max = i*j;
            }


        }

        return max;
    }

    public static long problem5(){

        long ans = 1;

        for(int i = 2; i<= 20; i++)
            ans = Helpers.getLCM(ans,i);

        return ans;

    }


    public static long problem6(){

        long sum_of_100 = 100*101/2;
        long sum_of_100_squares = 100*101*201/6;

    return Math.abs(sum_of_100_squares-(sum_of_100*sum_of_100));

    }

    public static int problem7(){
        int max = 1000000;
        boolean[] checker = new boolean[max];
        Arrays.fill(checker, true);

        int count = 0;
        int idx = 2;
        while(count != 10001) {

            if (checker[idx])
                count++;
            for (int i = 2; idx * i < max; i++)
                checker[idx * i] = false;
            idx++;

        }
         return idx-1;
    }

    public static long problem8(){

        String number =     "73167176531330624919225119674426574742355349194934" +
                            "96983520312774506326239578318016984801869478851843" +
                            "85861560789112949495459501737958331952853208805511" +
                            "12540698747158523863050715693290963295227443043557" +
                            "66896648950445244523161731856403098711121722383113" +
                            "62229893423380308135336276614282806444486645238749" +
                            "30358907296290491560440772390713810515859307960866" +
                            "70172427121883998797908792274921901699720888093776" +
                            "65727333001053367881220235421809751254540594752243" +
                            "52584907711670556013604839586446706324415722155397" +
                            "53697817977846174064955149290862569321978468622482" +
                            "83972241375657056057490261407972968652414535100474" +
                            "82166370484403199890008895243450658541227588666881" +
                            "16427171479924442928230863465674813919123162824586" +
                            "17866458359124566529476545682848912883142607690042" +
                            "24219022671055626321111109370544217506941658960408" +
                            "07198403850962455444362981230987879927244284909188" +
                            "84580156166097919133875499200524063689912560717606" +
                            "05886116467109405077541002256983155200055935729725" +
                            "71636269561882670428252483600823257530420752963450";

        long max_result = 1;
        int cnt =0;
        int idx = 0;
        while(cnt != 13){
            int value = Character.getNumericValue(number.charAt(idx));
            if(value == 0) {
                max_result = 1;
                cnt = 0;
            }
            else {
                cnt++;
                max_result *= value;
            }
            idx++;
        }

        long current_product = max_result;

        while(idx < number.length() - 13){
            int value = Character.getNumericValue(number.charAt(idx));
            if(value == 0) {
                long temp_result = 1;
                cnt = 0;
                while(cnt != 13 && idx < number.length()){
                    int sub_value = Character.getNumericValue(number.charAt(idx));
                    if(sub_value == 0) {
                        temp_result =1;
                        cnt = 0;
                    }
                    else {
                        cnt++;
                        temp_result *= sub_value;
                    }
                    idx++;
                }
                current_product = temp_result;
            }
            else {

                current_product = (current_product * value)/Character.getNumericValue(number.charAt(idx-13));
                idx++;
            }

            max_result = Math.max(current_product,max_result);

        }

        return max_result;
    }

    public static int problem9(){

        for(int i = 1000; i > 0; i--)
            for(int j = 1000; j > 0; j--)
            {
                int k = 1000 - (i+j);
                if(k*k == i*i + j*j)
                    return i*j*k;
            }

        return 0;
    }

    public static long problem10(){
        int MAX = 2000000;

        boolean[] checker = new boolean[MAX];
        Arrays.fill(checker, true);
        int index = 2;
        long result = 0;

        while(index < MAX){
            if(checker[index]){
                result += index;
                for(int i = 2; index * i < MAX; i++)
                    checker[i*index] = false;
            }
            index += 1;
        }

        return result;
    }



    public static void main(String[] args){
        /*System.out.println(problem1());
        System.out.println(problem2());
        System.out.println(problem3());
        System.out.println(problem4());
        System.out.println(problem5());
        System.out.println(problem6());
        System.out.println(problem7());*/
        System.out.println(problem10());
    }
}
