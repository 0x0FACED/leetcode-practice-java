// Method 1 usung recursion

class Solution {
    public int addDigits(int num) {
        String n = Integer.toString(num);
        if(n.length() == 1) return Integer.parseInt(n);
        
        int sum = 0;
        for(char c : n.toCharArray()){
            sum += Character.getNumericValue(c);
        }
        return addDigits(sum);
    }
}

// Method 2 using while loop

class Solution {
    public int addDigits(int num) {
        while(num > 9){
            char[] nums = Integer.toString(num).toCharArray();
            num = 0;
            for(int i = 0; i < nums.length; ++i){
                num += (nums[i] - '0');
            }

        }
        return num;
    }
}
