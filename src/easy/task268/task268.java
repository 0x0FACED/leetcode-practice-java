class Solution {
    public int missingNumber(int[] nums) {
        int missElement = 0;
        int counter = 0;
        while(counter < nums.length)
            missElement ^= counter ^ nums[counter++]; 
        return missElement ^ counter;
    }
}
