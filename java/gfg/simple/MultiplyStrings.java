package gfg.simple;

class MultiplyStrings {
    public static String multiply(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m+n];

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >=0 ; j--){

                int mul = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                int pos1 = i+j;
                int pos2 = i+j+1;
                int sum = mul + pos[pos2];

                pos[pos1] += sum / 10;
                pos[pos2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p: pos){
            if(!(sb.length() == 0 && p == 0))
                sb.append(p);
        }

        return (sb.length() == 0)? "0":sb.toString();

    }

    public static void main(String[] args){
        System.out.println(multiply("12","10"));

    }
}