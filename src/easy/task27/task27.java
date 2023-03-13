class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 1 && nums[0] == val){
            nums = new int[1];
            return 0;
        }

        int index = 0;
        return backtrack(nums, val, 0, index);
    }

    public int backtrack(int[] nums, int val, int counter, int index){
        if(counter == nums.length - 1){
            return index;
        }
        for(int i = counter; i < nums.length; ++i){
            if(nums[i] == val){
                index = backtrack(nums, val, i + 1, index);
            } else{
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
