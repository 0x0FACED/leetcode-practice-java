class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int[] dp = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; ++i){
            if(nums[i - 1] == 0) {
                dp[i] = dp[i - 1] == 0 ? 1 : dp[i - 1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}
