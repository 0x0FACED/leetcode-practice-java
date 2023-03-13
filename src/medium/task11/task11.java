class Solution {
    public int maxArea(int[] height) {
        int maxAmount = 0;
        int left = 0; 
        int right = height.length - 1;
        while (left < right) {
            int limit = right - left;
            maxAmount = Math.max(maxAmount, Math.min(height[left], height[right]) * limit);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxAmount;
    }
}
