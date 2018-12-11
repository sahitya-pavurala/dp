package gfg.simple;

import java.util.*;

/**
 *
 /user userRootEndpoint
 /user/friends userFriendsEndpoint
 /user/lists userListsEndpoint
 /user/X userEndpoint
 /user/X/friends userFriendsEndpoint
 /user/X/lists userListsEndpoint
 /user/X/lists/X userListIdEndpoint
 / rootEndpoint
 /X/friends userFriendsEndpoint
 /X/lists userListsEndpoint
 /settings settingsEndpoint
 # end of configuration, request paths to follow
 /user
 /user/friends
 /user/123
 /user/123/friends
 /user/123/friends/zzz
 /user/friends/friends
 /
 /abc/lists
 /settings
 /aaa/bbb
 */

public class PathNormalizer {

    private static HashMap<CustomWordList, String> endPointMap = new HashMap<>();

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner sc = new Scanner(System.in);

        ArrayList<String> patternStrings = new ArrayList<>();
        ArrayList<String> endPtStrings = new ArrayList<>();


        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            //System.out.println(line);
            String[] url_endpt = line.split(" ");
            if (line.startsWith("#"))
                break;
            patternStrings.add(url_endpt[0]);
            endPtStrings.add(url_endpt[1]);
        }

        HashMap<Integer, HashSet<CustomWordList>> patternMap = getInitialiseMaps(patternStrings, endPtStrings);

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            printEndPoint(line, patternMap);
        }



    }

    static class CustomWord{

        private String value;

        public CustomWord(String word){
            this.value = word;
        }

        @Override
        public boolean equals(Object obj){

            if (obj == this)
                return true;
            if (!(obj instanceof CustomWord))
                return false;

            if(this.value.equals(((CustomWord) obj).value) || ((CustomWord)obj).value.equals("X") || this.value.equals("X"))
                return true;

            return false;
        }

        @Override
        public int hashCode(){

            int result=17;
            result= 31*result+ value.hashCode();
            return result;
        }
    }

    static class CustomWordList{

        private ArrayList<CustomWord> values;

        public CustomWordList(ArrayList<CustomWord> lst){
            this.values = lst;
        }

        @Override
        public boolean equals(Object obj){

            if (obj == this)
                return true;
            if (!(obj instanceof CustomWordList))
                return false;
            CustomWordList lst = (CustomWordList) obj;

            if(this.values.size() != lst.values.size())
                return false;

            for(int i = 0; i < this.values.size(); i++){
                if(!(this.values.get(i).equals(lst.values.get(i))))
                    return false;

            }

            return true;
        }

        @Override
        public int hashCode(){

            int result=17;
            for(CustomWord s: this.values)
                result += s.hashCode();
            return result;
        }


    }

    public static HashMap<Integer, HashSet<CustomWordList>> getInitialiseMaps(ArrayList<String> urls, ArrayList<String> endPts){

        HashMap<Integer, HashSet<CustomWordList>> patterns = new HashMap<>();
        for(int i = 0; i  < urls.size(); i++){
            String url = urls.get(i);
            String[] words = url.split("/");
            HashSet<CustomWordList> val;
            CustomWordList lstToAdd = new CustomWordList(getCustomWordList(words));
            if(patterns.containsKey(words.length)) {
                val = patterns.get(words.length);
                val.add(lstToAdd);
            }
            else {
                val = new HashSet<>();
                val.add(lstToAdd);

            }
            patterns.put(words.length, val);
            endPointMap.put(lstToAdd, endPts.get(i));
        }

        return patterns;
    }

    public static ArrayList<CustomWord> getCustomWordList(String[] words){

        ArrayList<CustomWord> customWords = new ArrayList<>();
        for (String word: words){
            customWords.add(new CustomWord(word));
        }

        return customWords;
    }

    public static void printEndPoint(String request, HashMap<Integer, HashSet<CustomWordList>> patternMap){

        String[] words = request.split("/");
        if(patternMap.containsKey(words.length)){
            CustomWordList requestObj = new CustomWordList(getCustomWordList(words));
            HashSet<CustomWordList> val = patternMap.get(words.length);
            if(val.contains(requestObj))
                System.out.println(endPointMap.get(requestObj));
            else {
                boolean flag = false;
                for(CustomWordList clst: val){
                    if(clst.equals(requestObj)) {
                        System.out.println(endPointMap.get(clst));
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    System.out.println("404");
            }
        }
        else System.out.println("404");

    }
}