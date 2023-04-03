class NumArray {
    private int[] _original;
    private int[] _fenwickTree;

    public NumArray(int[] nums) {
        _original = nums;
        _fenwickTree = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) _fenwickTree[i] = nums[i - 1];
        for (int i = 1; i <= nums.length; i++) {
            int parentBit = i + (i & (-i));

            if (parentBit <= nums.length) {
                _fenwickTree[parentBit] += _fenwickTree[i];
            }
        }
    }

    public void update(int index, int val) {
        int bit = index + 1;
        int diff = val - _original[index];
        _original[index] = val;

        while (bit < _fenwickTree.length) {
            _fenwickTree[bit] += diff;
            bit = getNext(bit);
        }
    }

    private int getNext(int index){
        return index + (index & (-index));
    }
    private int getParent(int index){
        return index - (index & (-index));
    }
    private int getSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += _fenwickTree[index];
            index = getParent(index);
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        if (left == 0) return getSum(right + 1);
        return getSum(right + 1) - getSum(left);
    }
}
