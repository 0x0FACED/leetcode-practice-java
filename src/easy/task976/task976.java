class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxPerimeter = 0;
        for(int i = n - 1; i >= 2; --i){
            int side1 = nums[i];
            int side2 = nums[i - 1];
            int side3 = nums[i - 2];
            if(side3 + side2 > side1){
                maxPerimeter = Math.max(maxPerimeter, side1 + side2 + side3);
            }
        }
        return maxPerimeter;
    }
}
