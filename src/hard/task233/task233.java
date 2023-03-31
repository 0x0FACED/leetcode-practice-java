class Solution {
    public int countDigitOne(int n) {
        if(n == 0){
            return 0;
        }
        int countDigit = 0;
        for (int i = 1; i <= n; i *= 10) {
            int intPart = n / i;
            int remainder = n % i;
            countDigit += (intPart + 8) / 10 * i + (intPart % 10 == 1 ? remainder + 1 : 0);
        }
        return countDigit;
    }
}
