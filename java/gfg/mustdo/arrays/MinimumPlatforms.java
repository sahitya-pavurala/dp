package gfg.mustdo.arrays;

import java.util.Arrays;

public class MinimumPlatforms {

    public static int compute(int[] starttimes, int[] endtimes){

        Arrays.sort(starttimes);
        Arrays.sort(endtimes);

        int min_platforms = 1;
        int i = 1;
        int j = 0;
        int current = 1;
        while(i < starttimes.length && j < endtimes.length){
            if(starttimes[i] < endtimes[j]){
                current += 1;
                i += 1;
                min_platforms = Math.max(min_platforms, current);
            }
            else {
                current -= 1;
                j += 1;
            }
        }

        return min_platforms;
    }
}
