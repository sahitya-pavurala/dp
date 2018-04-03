package peuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sahityapavurala on 11/22/17.
 */
public class Test {
    public static void main(String[] args){
        int begin = 0;
        int end = 4;
        String input = "democracy";
        boolean flag = false;
        ArrayList<String> result = new ArrayList<>();
        HashSet<Character> checker = new HashSet<>();
        while(end < input.length()){
            for(int i = begin; i<= end; i++){
                char val = input.charAt(i);

                if(checker.contains(val)) {
                    if(flag) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }
                else checker.add(val);
            }

            if(flag) {
                result.add(input.substring(begin, end + 1));
                flag = false;
            }

            checker = new HashSet<>();
            begin++;
            end++;

        }

        for (String str: result)
            System.out.println(str);

    }
}
