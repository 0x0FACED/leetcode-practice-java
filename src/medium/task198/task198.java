class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0){ 
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int prevStep = nums[0];
        int currStep = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = currStep;
            currStep = Math.max(currStep, prevStep + nums[i]);
            prevStep = temp;
        }
        return currStep;
    }

}
