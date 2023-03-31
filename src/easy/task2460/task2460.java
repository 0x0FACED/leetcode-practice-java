class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        for(int i = 1; i < n; ++i){
            if(nums[i] == nums[i - 1]){
                nums[i - 1] *= 2;
                nums[i] = 0; 
            }
        }

        int[] res;
        res = Arrays.copyOf(nums, n);

        int index = 0;
        for(int i = 0; i < n; ++i){
            if(res[i] != 0){
                res[index++] = res[i];
            }
        }
        for(int i = index; i < n; ++i){
            res[i] = 0;
        }
        return res;
    }
}
