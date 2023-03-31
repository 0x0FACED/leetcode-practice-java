class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] temp1 = s1.toCharArray();
        char[] temp2 = s2.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        if(!Arrays.equals(temp1, temp2)){
            return false;
        } else {
            int counterNonEqual = 0;
            for(int i = 0; i < s1.length(); ++i){
                if(s1.charAt(i) != s2.charAt(i)){
                    ++counterNonEqual;
                }
                if(counterNonEqual > 2){
                    return false;
                }
            }
            if(counterNonEqual == 2 || counterNonEqual == 0){
                return true;
            } else return false;
        }
        
    }
}
