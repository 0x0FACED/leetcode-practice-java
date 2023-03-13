class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permute = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        findPermutations(nums, permute, res);

        return res;
    }

    public void findPermutations(int[] nums, List<Integer> curr, List<List<Integer>> allPermutations){
        if(curr.size() == nums.length){
            allPermutations.add(new ArrayList<>(curr));
        }
        for(int i = 0; i < nums.length; ++i){
            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                findPermutations(nums, curr, allPermutations);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
