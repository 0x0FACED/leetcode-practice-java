class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        String prefix = "";
        int minLengthIndex = 0;
        int minLength = 100000000;
        for(int i = 0; i < strs.length; ++i){
            if(strs[i].length() < minLength){
                minLengthIndex = i;
                minLength = strs[i].length();
            }
            if(strs[i].equals("")){
                return "";
            }
        }
        for(int charIndex = 0; charIndex < minLength; ++charIndex){
            char currentChar = strs[minLengthIndex].charAt(charIndex);
            for(int wordIndex = 0; wordIndex < strs.length; ++wordIndex){
                if(minLengthIndex != wordIndex){
                    if(strs[wordIndex].charAt(charIndex) != currentChar){
                        return prefix;
                    }
                }
            }
            prefix += currentChar;
        }
        return prefix;
    }
}
