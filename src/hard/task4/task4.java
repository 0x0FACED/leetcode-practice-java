// bad solution - O(max(m, n))

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merged = new ArrayList();
        int length = (nums1.length >= nums2.length) ? nums1.length : nums2.length;
        for(int i = 0; i < length; ++i){
            if(i < nums2.length){
                merged.add(nums2[i]);
            }
            if(i < nums1.length){
                merged.add(nums1[i]);
            }
        }
        merged.sort(Comparator.naturalOrder());
        
        double median = 0;
        if(merged.size() % 2 == 1){
            median = merged.get(merged.size() / 2);
        } else {
            median = (double) (merged.get(merged.size() / 2) + merged.get(merged.size() / 2 - 1)) / 2; 
        }

        return median;
    }
}
