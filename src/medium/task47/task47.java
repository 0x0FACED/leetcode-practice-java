class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> permute = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] usedValues = new boolean[nums.length];
        Arrays.sort(nums);
        findPermutations(nums, usedValues, permute, res);

        return res;
    }

    public void findPermutations(int[] nums, boolean[] usedValues, List<Integer> curr, List<List<Integer>> allPermutations){
        if(curr.size() == nums.length){
            allPermutations.add(new ArrayList<>(curr));
        }
        for(int i = 0; i < nums.length; ++i){
            if(!usedValues[i]){
                if(i > 0 && nums[i - 1] == nums[i] && !usedValues[i-1]){
                    continue;
                }
                curr.add(nums[i]);
                usedValues[i] = true;
                findPermutations(nums, usedValues,  curr, allPermutations);
                usedValues[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}
