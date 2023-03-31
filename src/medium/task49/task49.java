class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Set<String> group = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String origin = new String(chars);
            if (group.add(origin)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(origin, list);
            } else {
                map.get(origin).add(str);
            }
        }
        for (String g : group) {
            result.add(map.get(g));
        }
        return result;
    }
}
