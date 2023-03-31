class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        Arrays.sort(nums);
        int currMax = 1;
        int prevMax = 0;
        int currElement = nums[0];
        int prevMaxElement = 0;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] != currElement){
                if(currMax > prevMax){
                    prevMax = currMax;
                    prevMaxElement = currElement;
                }
                currMax = 1;
                currElement = nums[i];
            } else {
                ++currMax;
            }
        }
        return prevMax > currMax ? prevMaxElement : currElement;
    }
}
