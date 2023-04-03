class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        if(n == 1){
            return 1;
        }
        Arrays.sort(people);
        int left = 0;
        int right = n - 1;
        while(left <= right){
            if(people[left] + people[right] <= limit) ++left;
            --right;
        }
        
        return n - right - 1;
    }
}
