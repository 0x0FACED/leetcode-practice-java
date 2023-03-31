class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        int length = flowerbed.length;
        if(length == 1){
            if(flowerbed[0] == 0 && n < 2){
                return true;
            }
            if(flowerbed[0] == 1){
                return false;
            }
        }

        for(int i = 0; i < length - 1; ++i){
            if(flowerbed[i] == 0 && flowerbed[i + 1] == 0){
                if(i == 0){
                    --n;
                    flowerbed[i] = 1;
                } else if (i > 0 && i + 1 != length - 1){
                    if(flowerbed[i - 1] == 0){
                        --n;
                        flowerbed[i] = 1;
                    }
                } else if(i + 1 == length - 1){
                    --n;
                }
                
            }
            if(n <= 0){
                return true;
            }
        }
        return false;
    }
}
