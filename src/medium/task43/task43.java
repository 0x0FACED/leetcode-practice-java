// good solution

class Solution {
    public static String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int fullLength = length1 + length2 - 1;
        int[] res = new int[fullLength];
        int buffer = 0;
        for (int i = length1 - 1; i >= 0; --i){
            for (int j = length2 - 1; j >= 0; --j){
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                res[i + j] += x * y;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = fullLength - 1; i >= 0; --i){
            res[i] += buffer;
            sb.insert(0, res[i] % 10);
            buffer = res[i] / 10;
        }
        if(buffer > 0){
            sb.insert(0, buffer);
        }
        return new String(sb);
    }
}
