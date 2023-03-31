class Solution {
    public int arraySign(int[] nums) {
        if(nums.length == 1){
            if(nums[0] == 0){
                return 0;
            } else if(nums[0] > 0){
                return 1;
            } else {
                return -1;
            }
        }

        Arrays.sort(nums);

        if(nums[0] == 0){
            return 0;
        } else if(nums[0] < 0 && nums[1] > 0){
            return -1;
        } else if(nums[0] > 0){
            return 1;
        }

        int minusCounter = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                return 0;
            } else if(nums[i] < 0){
                ++minusCounter;
            }
        }

        return minusCounter % 2 == 1 ? -1 : 1;
    }
}
