// bad solution

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }

        if(s.length() == 2 && (s.charAt(0) == s.charAt(1))){
            return s;
        } else if(s.length() == 2 && (s.charAt(0) != s.charAt(1))){
            return s.substring(0, 1);
        }

        int count = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == s.charAt(s.length() - 1 - i)){
                ++count;
            }
        }
        if(count == s.length()){
            return s;
        }

        String currentSolution = "";
        String prevSolution = "";
        String tempSubstr = "";
        String mainSubstr = "";
        boolean isError = false;
        char currentChar;
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i){
            currentChar = s.charAt(i);
            mainSubstr = s.substring(i);
            indexes = findIndexesSameLetter(mainSubstr, currentChar);
            if(indexes.size() != 0){
                for(int k = 0; k < indexes.size(); ++k){
                    tempSubstr = mainSubstr.substring(0, indexes.get(k) + 1);
                    currentSolution = "";
                    isError = false;
                    for(int j = 0; j < tempSubstr.length(); ++j){
                        if(tempSubstr.charAt(j) != tempSubstr.charAt(tempSubstr.length() - j - 1)){
                            isError = true;
                        }
                    }
                    if (!isError){
                        currentSolution = tempSubstr;
                    }
                    if(currentSolution.length() > prevSolution.length()){
                        prevSolution = "";
                        prevSolution = currentSolution;
                    }
                }
            }

        }
        if (currentSolution.length() == 0 && prevSolution.length() == 0){
            return String.valueOf(s.charAt(0));
        }
        return (currentSolution.length() > prevSolution.length()) ? currentSolution : prevSolution;
    }

    public List<Integer> findIndexesSameLetter(String s, char ch){
        List<Integer> indexes = new ArrayList<>();
        for(int i = 1; i < s.length(); ++i){
            if(ch == s.charAt(i)){
                indexes.add(i);
            }
        }
        return indexes;
    }
}
