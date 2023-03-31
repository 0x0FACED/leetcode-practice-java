class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int indexFactor2 = 0;
        int indexFactor3 = 0;
        int indexFactor5 = 0;
        int seqFactor2 = 1;
        int seqFactor3 = 1;
        int seqFactor5 = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = Math.min(Math.min(seqFactor2, seqFactor3), seqFactor5);
            if (seqFactor2 == ugly[i]) seqFactor2 = 2 * ugly[indexFactor2++];
            if (seqFactor3 == ugly[i]) seqFactor3 = 3 * ugly[indexFactor3++];
            if (seqFactor5 == ugly[i]) seqFactor5 = 5 * ugly[indexFactor5++];
        }
        return ugly[n - 1];
    }
}
