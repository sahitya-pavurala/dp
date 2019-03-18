package gfg.mustdo.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class ParenthesisChecker {

    final static  Map<Character, Character> bracketMap = new HashMap<>();

    static {
        bracketMap.put('(',')');
        bracketMap.put('[',']');
        bracketMap.put('{','}');
    }

    public static String compute(String brackets){

        Stack<Character> st = new Stack<>();
        for(int i = 0; i< brackets.length(); i++){
            if(!bracketMap.containsKey(brackets.charAt(i)) && !st.empty()) {
                char val = st.pop();
                if(bracketMap.get(val) != brackets.charAt(i))
                    return "not balanced";
            }
            else
                st.push(brackets.charAt(i));
        }

        if(!st.empty())
            return "not balanced";

        return "balanced";
    }
}
