class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, res, "");
        return res;
    }

    public void dfs(int left, int right, List<String> res, String str){
        if(left == 0 && right == 0) res.add(str);
        if(left > 0) dfs(left - 1, right, res, str + "(");
        if(right > left) dfs(left, right - 1, res, str + ")");
    }
}
