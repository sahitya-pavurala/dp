package gfg.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumbers {

    final static TreeMap<Integer, String> numMap = new TreeMap<>();
    final static Map<Character, Integer> charMap = new HashMap<>();


    static {
        numMap.put(1000, "M");
        numMap.put(900, "CM");
        numMap.put(500, "D");
        numMap.put(400, "CD");
        numMap.put(100, "C");
        numMap.put(90, "XC");
        numMap.put(50, "L");
        numMap.put(40, "XL");
        numMap.put(10, "X");
        numMap.put(9, "IX");
        numMap.put(5, "V");
        numMap.put(4, "IV");
        numMap.put(1, "I");


        charMap.put('M', 1000);
        //charMap.put(900, "CM");
        charMap.put('D', 500);
        //charMap.put(400, "CD");
        charMap.put('C',100);
        //charMap.put(90, "XC");
        charMap.put('L', 50);
        //charMap.put(40, "XL");
        charMap.put('X', 10);
        //charMap.put(9, "IX");
        charMap.put('V', 5);
        //charMap.put(4, "IV");
        charMap.put('I', 1);

    }

    public String toRoman(int num){

        int l = numMap.floorKey(num);
        if(l == num)
            return numMap.get(l);
        return numMap.get(l) + toRoman(num - l);
    }


    public int toNumber(String roman){
        int prev = 0;
        int num = 0;
        for(int i = roman.length() - 1; i >= 0; i--){
            int val = charMap.getOrDefault(roman.charAt(i), 0);

            if(val >= prev)
                num += val;
            else
                num -= val;

            prev = val;

        }

        return num;
    }

    public static void main(String[] args){
        RomanNumbers obj = new RomanNumbers();
        System.out.println(obj.toRoman(48));
        System.out.println(obj.toNumber(obj.toRoman(48)));

    }
}
