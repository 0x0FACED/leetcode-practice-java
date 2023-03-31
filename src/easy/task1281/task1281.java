class Solution {
    public int subtractProductAndSum(int n) {
        String strValue = Integer.toString(n);
        int product = strValue.charAt(0) - '0';
        int sum = strValue.charAt(0) - '0';
        for(int i = 1; i < strValue.length(); ++i){
            product = product * (strValue.charAt(i) - '0');
            sum = sum + (strValue.charAt(i) - '0');
        }

        return product - sum;
    }
}
