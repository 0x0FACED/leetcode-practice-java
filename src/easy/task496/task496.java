// Method 1 - slow

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        boolean isFound = false;
        for(int i = 0; i < ans.length; ++i){
            isFound = false;
            for(int j = 0; j < nums2.length; ++j){
                if(nums1[i] == nums2[j] && !isFound){
                    isFound = true;
                } else if(nums2[j] > nums1[i] && isFound){
                    ans[i] = nums2[j];
                    break;
                }
                if(j == nums2.length - 1){
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
}

// Method 2 - fast using ArrayDeque & HashMap

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n1Len];
        
        for (int i = 0; i < n2Len; ++i) {
            int curr = nums2[i];
            while ( ! stack.isEmpty() && nums2[stack.peek()] < curr) {
                int prevPos = stack.pop();
                map.put(nums2[prevPos], curr);
            }
            stack.push(i);
            map.put(curr, -1);
        }
        
        for (int i = 0; i < n1Len; ++i) {
            res[i] = map.get(nums1[i]);
        }
        
        return res;
    }
}
