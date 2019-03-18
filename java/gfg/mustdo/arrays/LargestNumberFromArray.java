package gfg.mustdo.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumberFromArray {

    public static String compute(String[] arr){

        Collections.sort(Arrays.asList(arr), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1o2 = o1+o2;
                String o2o1 = o2+o1;
                if (o1o2.compareTo(o2o1) > 0)
                    return -1;
                else return 1;
            }
        });

        StringBuilder res = new StringBuilder();
        for(String s: arr){
            res.append(s);
        }

        return res.toString();

    }
}
