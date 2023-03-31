class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int len = 0;
        int counterS = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') {
                stack.push(counterS);
            } else {
                stack.pop();
                if(stack.empty()){
                    stack.push(counterS);
                } else {
                    len = Math.max(len, counterS - stack.peek());
                }
            }
            ++counterS;
        }
        return len;
    }
}
