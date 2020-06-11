package leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *  Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *  If possible, output any possible result.  If not possible, return the empty string.
 */
public class Problem767 {

    private static String solution(String S) {

        HashMap<Character, Integer> charMap = new HashMap<>();

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b)-> (charMap.get(b)- charMap.get(a)));

        for(int i =0 ; i < S.length(); i++){
            char c = S.charAt(i);
            charMap.put(c, charMap.getOrDefault(c,0)+1);
        }

        pq.addAll(charMap.keySet());

        StringBuilder stringBuilder = new StringBuilder();

        while (pq.size() > 1){
            char first = pq.poll();
            char second = pq.poll();

            stringBuilder.append(first).append(second);

            charMap.put(first, charMap.get(first)-1);
            charMap.put(second, charMap.get(second)-1);

            if(charMap.get(first) > 0)
                pq.add(first);

            if(charMap.get(second) > 0)
                pq.add(second);

        }

        if (pq.size() > 0 )

            if(charMap.get(pq.peek()) == 1)
                stringBuilder.append(pq.peek());
            else
                return "";

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(solution("aab"));
    }
}