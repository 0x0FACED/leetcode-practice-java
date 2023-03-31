class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int sign = 1;
        int i = 0;
        int n = s.length();
        long num = 0;

        while (i < n && s.charAt(i) == ' ') {
            ++i;
        }

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            ++i;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            ++i;
            if (num * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (num * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) num * sign;
    }
}
