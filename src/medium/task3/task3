class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")){
            return 0;
        }
        String substring = new String();
        String lastSolution = new String();
        int counter = 0;
    
        for(int i = 1; i < s.length() + 1; ++i){
            if(!substring.contains(String.valueOf(s.charAt(i - 1)))){
                substring += String.valueOf(s.charAt(i - 1));
            } else {
                if(substring.length() > lastSolution.length()){
                    lastSolution = substring;
                }
                substring = new String();
                counter++;
                i = counter;
            }
        }
        
        return Math.max(lastSolution.length(), substring.length());
    }
}
