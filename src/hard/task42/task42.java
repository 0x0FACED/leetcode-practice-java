class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; ++i){
            while (!stack.empty() && height[i] > height[stack.peek()]){
                int j = stack.pop();
                if(!stack.empty()){
                    int minHeight = Math.min(height[i], height[stack.peek()]);
                    res += (minHeight - height[j]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
