class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }
        int wordLen = words[0].length();
        int targetLen = wordLen * words.length;
        if (s.length() < targetLen) {
            return result;
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - targetLen; ++i) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            for( ; j < words.length; ++j){
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (!counts.containsKey(word)) {
                    break;
                }
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if (seen.get(word) > counts.get(word)) {
                    break;
                }
            }
            if (j == words.length) {
                result.add(i);
            }
        }
        return result;
    }
}
