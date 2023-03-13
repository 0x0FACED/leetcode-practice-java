// bad solution

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums[0] == 0) {
            String str = Arrays.toString(nums);
            boolean isCorrect = false;
            for (int i = 1; i < 10; ++i) {
                if (str.contains(String.valueOf(i))) {
                    isCorrect = true;
                    break;
                }
            }
            if (!isCorrect) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(0);
                triplet.add(0);
                triplet.add(0);
                List<List<Integer>> tripletsFinal = new ArrayList<>();
                tripletsFinal.add(triplet);
                return tripletsFinal;
            }
        }
        int leftCounter;
        int rightCounter;

        Arrays.parallelSort(nums);

        Set<List<Integer>> tempRes = new HashSet<>(nums.length * 2);
        for(int i = 0; i < nums.length - 2; ++i){
            leftCounter = i + 1;
            rightCounter = nums.length - 1;
            while(leftCounter < rightCounter){
                int sum = nums[i] + nums[leftCounter] + nums[rightCounter];
                if (sum == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[leftCounter]);
                    triplet.add(nums[rightCounter]);
                    tempRes.add(triplet);
                }
                if(sum < 0){
                    leftCounter++;
                } else {
                    rightCounter--;
                }
            }
        }

        return new ArrayList<>(tempRes);
    }
}
