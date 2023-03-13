class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int leftCounter;
        int rightCounter;

        Arrays.sort(nums);

        List<Integer> sums = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; ++i){
            leftCounter = i + 1;
            rightCounter = nums.length - 1;
            while(leftCounter < rightCounter){
                int sum = nums[i] + nums[leftCounter] + nums[rightCounter];
                if(sum == target){
                    return sum;
                }
                sums.add(sum);
                if(sum < target){
                    leftCounter++;
                } else {
                    rightCounter--;
                }
            }
        }
        Collections.sort(sums);
        if(sums.get(0) > target){
            return sums.get(0);
        }
        if(sums.get(0) < target && sums.get(sums.size() - 1) > target){
            for(int i = 0; i < sums.size(); ++i){
                if(sums.get(i) > target){
                    int difference1 = Math.abs(target - sums.get(i));
                    int difference2 = Math.abs(target - sums.get(i - 1));
                    if(difference1 > difference2){
                        return sums.get(i - 1);
                    } else {
                        return sums.get(i);
                    }


                }
            }
        }
        if(sums.get(sums.size() - 1) < target){
            return sums.get(sums.size() - 1);
        }

        return target;
    }
}
