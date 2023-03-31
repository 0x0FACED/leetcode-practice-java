// Method 1

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return ((n ^ (n - 1)) == n + (n - 1));
    }
}

// Method 2

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return ((n & (n - 1)) == 0);
    }
}
