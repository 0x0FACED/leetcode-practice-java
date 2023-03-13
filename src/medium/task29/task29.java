class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MAX_VALUE && divisor == -1){
            return Integer.MIN_VALUE + 1;
        } else if(dividend == Integer.MAX_VALUE && divisor == 1){
            return dividend;
        } else if(dividend == 0){
            return 0;
        } else if(dividend == Integer.MIN_VALUE && divisor == 1){
            return dividend;
        } else if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long dividend1 = Math.abs(dividend);
        long divisor1 = Math.abs(divisor);

        long res = 0;
        long temp = 0;
        for(int i = 31; i >= 0; --i){
            if (temp + (divisor1 << i) <= dividend1){
                temp += divisor1 << i;
                res |= 1L << i;
            }
        }
        if(sign == -1){
            res = -res;
        }
        return (int)res;
    }
}
