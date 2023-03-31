class Solution {
    public boolean isUgly(int n) {
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        int[] factors = new int[]{2,3,5,7};
        int counter = 0;
        while(true){
            if(n % factors[counter] != 0){
                ++counter;
            } else {
                n /= factors[counter];
            }
            if(factors[counter] == 7){
                return false;
            }
            if(n == 1){
                return true;
            }

        }
    }
}
