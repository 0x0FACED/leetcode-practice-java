// bad solution

class Solution {
    public int reverse(int x) {
        StringBuilder sbValue = new StringBuilder();
        {
            String value = String.valueOf(x);
            if(value.charAt(0) == '0'){
                return 0;
            }

            if(value.charAt(0) == '-'){
                sbValue.append(value.charAt(0));
                value = value.substring(1);
            }
            int countZeros = value.length() - 1;
            while(true){
                if(value.charAt(countZeros) == '0'){
                    --countZeros;
                } else {
                    break;
                }
            }

            if(countZeros != value.length() - 1){
                value = value.substring(0, countZeros + 1);
            }

            for(int i = value.length() - 1; i >= 0; --i){
                if(value.charAt(i) != '-'){
                    sbValue.append(value.charAt(i));
                }
            }
        }
        String maxInt = "2147483647";
        String minInt = "-2147483648";
        if(sbValue.charAt(0) != '-' && sbValue.length() == maxInt.length()){
            for(int i = 0; i < sbValue.length(); ++i){
                if(Integer.parseInt(String.valueOf(sbValue.charAt(i))) < Integer.parseInt(String.valueOf(maxInt.charAt(i)))){
                    return Integer.parseInt(String.valueOf(sbValue));
                } else if (Integer.parseInt(String.valueOf(sbValue.charAt(i))) > Integer.parseInt(String.valueOf(maxInt.charAt(i)))){
                    return 0;
                }
            }
        } else if (sbValue.charAt(0) == '-' && sbValue.length() == minInt.length()){
            for(int i = 1; i < sbValue.length(); ++i){
                if(Integer.parseInt(String.valueOf(sbValue.charAt(i))) < Integer.parseInt(String.valueOf(minInt.charAt(i)))){
                    return Integer.parseInt(String.valueOf(sbValue));
                } else if (Integer.parseInt(String.valueOf(sbValue.charAt(i))) > Integer.parseInt(String.valueOf(minInt.charAt(i)))){
                    return 0;
                }
            }
        }
    
        return Integer.parseInt(String.valueOf(sbValue));
    }
}
