public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String value = Integer.toBinaryString(n);
 
        int counter = 0;
        for (char ch : value.toCharArray()){
            if(ch == '1'){
                ++counter;
            }
        }

        return counter;
    }
}
