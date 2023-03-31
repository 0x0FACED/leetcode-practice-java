class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        
        result.add(intervals[0]);
        for (int i = 1, k = 0; i < intervals.length; ++i) {
            if (intervals[i][0] <= result.get(k)[1]) {
                result.get(k)[1] = Math.max(result.get(k)[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
                ++k;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
