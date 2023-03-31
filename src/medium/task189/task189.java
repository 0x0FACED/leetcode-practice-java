class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n != 1){
            k %= n;
            int[] rotateNumbers = new int[k];
            System.arraycopy(nums, n - k, rotateNumbers, 0, k);
            System.arraycopy(nums, 0, nums, k, n - k);
            System.arraycopy(rotateNumbers, 0, nums, 0, k);
        }
    }
}
