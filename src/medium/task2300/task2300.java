class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for(int i = 0; i < n; ++i){
            double minPowerPotion = 1.0 * success / spells[i];

            int left = 0;
            int right = m - 1;
            while(left < right){
                int mid = left + (right - left) / 2;

                if(minPowerPotion > potions[mid]) left = mid + 1;
                else right = mid - 1;
            }

            if(minPowerPotion > potions[left]) res[i] = m - left - 1;
            else res[i] = m - left;
        }
        return res;
    }
}
