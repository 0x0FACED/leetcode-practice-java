class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        int maxPosition = nums[last];
        while (last >= 0) { 
            if (last + nums[last] >= maxPosition) maxPosition = last;
            --last;
        }
        return maxPosition == 0;
    }
}
