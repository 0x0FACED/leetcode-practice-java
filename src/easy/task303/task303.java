// Method 1 - fast prefixSums

class NumArray {
    private int[] prefixSums;
    public NumArray(int[] nums) {
        prefixSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            prefixSums[i+1] = prefixSums[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSums[right + 1] - prefixSums[left];
    }
}

// Method 2 - slow using int[] to store all values

class NumArray {
    private final int[] values;

    public NumArray(int[] nums) {
        values = Arrays.copyOf(nums, nums.length);
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; ++i){
            sum += values[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
