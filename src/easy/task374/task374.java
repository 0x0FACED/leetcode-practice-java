/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(guess(n) == 0){
            return n;
        }

        int left = 0;
        int right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            int choose = guess(mid);
            if(choose == 1){
                left = mid;
            } else if(choose == -1){
                right = mid;
            } else {
                return mid;
            }
        }
        return left;
    }
}
