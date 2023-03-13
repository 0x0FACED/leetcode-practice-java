class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        int leftCounter;
        int rightCounter;

        Arrays.parallelSort(nums);

        Set<List<Integer>> tempRes = new HashSet<>();
        for(int i = 0; i < nums.length - 3; ++i){
            for(int j = i + 1; j < nums.length - 2; ++j){
                leftCounter = j + 1;
                rightCounter = nums.length - 1;
                while(leftCounter < rightCounter){
                    long sum = (long) nums[i] + nums[leftCounter] + nums[rightCounter] + nums[j];
                    if (sum == target){
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[leftCounter]);
                        quadruplet.add(nums[rightCounter]);
                        quadruplet.add(nums[j]);
                        tempRes.add(quadruplet);
                    }
                    if(sum < target){
                        leftCounter++;
                    } else {
                        rightCounter--;
                    }
                }
            }
        
        }

        return new ArrayList<>(tempRes);
    }
}
