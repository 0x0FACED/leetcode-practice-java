class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		back(target, 0, candidates, list, res);
		return res;
	}

	public void back(int remainVal, int start, int[] arr, List<Integer> curSum, List<List<Integer>> res) {
		if (remainVal < 0) return;
		else if (remainVal == 0) res.add(new ArrayList<>(curSum));
		else {
			for (int i = start; i < arr.length; i++) {
				if (arr[i] <= remainVal) {
					curSum.add(arr[i]);
					back(remainVal - arr[i], i, arr, curSum, res);
					curSum.remove(curSum.size() - 1);
				}
			}
		}
	}
}
