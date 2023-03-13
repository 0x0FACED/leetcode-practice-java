class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            if(num >= 1000){
                num -= 1000;
                sb.append("M");
            }
            if(num >= 500 && num < 1000){
                if(num >= 900){
                    num -= 900;
                    sb.append("CM");
                } else {
                    num -= 500;
                    sb.append("D");
                }
            }
            if(num >= 100 && num < 500){
                if(num >= 400){
                    num -= 400;
                    sb.append("CD");
                } else {
                    num -= 100;
                    sb.append("C");
                }
            }
            if(num >= 50 && num < 100){
                if(num >= 90){
                    num -= 90;
                    sb.append("XC");
                } else {
                    num -= 50;
                    sb.append("L");
                }
            }
            if(num >= 10 && num < 50){
                if(num >= 40){
                    num -= 40;
                    sb.append("XL");
                } else {
                    num -= 10;
                    sb.append("X");
                }
            }
            if(num >= 5 && num < 10){
                if(num >= 9){
                    num -= 9;
                    sb.append("IX");
                } else {
                    num -= 5;
                    sb.append("V");
                }
            }
            if(num >= 1 && num < 5){
                if(num >= 4){
                    num -= 4;
                    sb.append("IV");
                } else {
                    num -= 1;
                    sb.append("I");
                }
            }
        }
        return String.valueOf(sb);
    }
}
