class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missed = 0;
        int counterK = 0;
        int arrCounter = 0;
        for(int i = 0; arrCounter < arr.length; ++i){
            if(arr[arrCounter] != i + 1){
                missed = i + 1;
                ++counterK;
            } else {
                ++arrCounter;
            }
            if(counterK == k){
                return missed;
            }
        }
        return arr[arr.length - 1] + (k - counterK);
    }
}
