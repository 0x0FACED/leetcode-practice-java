class Solution {
    public int fib(int n) {
        if(n == 0){
            return 0;
        } 
        int prevPrev = 0;
        int prev = 1;
        int res = 0;
        for(int i = 2; i <= n; ++i){
            res = prevPrev + prev;
            prevPrev = prev;
            prev = res;
        }
        return prev;
    }
}
