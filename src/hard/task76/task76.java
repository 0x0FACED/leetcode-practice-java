class Solution {
    public String minWindow(String s, String t) {
        int[] charCount = new int[128];
        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";
        
        for(int i = 0; i < t.length(); ++i) {
            ++charCount[t.charAt(i)];
        }
        
        for(int i = 0; i < s.length(); ++i) {
            --charCount[s.charAt(i)];
            if(charCount[s.charAt(i)] >= 0) ++count;
            while(count == t.length()) {
                if(minLen > i - left + 1) {
                    minLen = i - left + 1;
                    result = s.substring(left, left+minLen);
                }
                ++charCount[s.charAt(left)];
                if(charCount[s.charAt(left)] > 0) --count;
                ++left;
            }
        }
        return result;
    }
}
