class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target){
            return 0;
        } else if(nums.length == 1 && nums[0] != target){
            return -1;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } 
            if(nums[left] == target){
                return left;
            }
            if(nums[right] == target){
                return right;
            }
            if(nums[left] <= nums[mid]){
                if(nums[left] < target && nums[mid] > target){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && nums[right] > target){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
