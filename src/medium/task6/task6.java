class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 1) {
            return s;
        }
        if(numRows == 1){
            return s;
        }
        int numCols = calculateNumCols(s.length(), numRows);
        String[][] zigzag = new String[numRows][numCols];
        String res = "";
        int counter = 0;
        int lastRowNumber = 0;
        boolean isZigzag = false;
        int looped = 0;
        for (int i = 0; i < numCols; ++i) {
            if (isZigzag) {
                for (int k = 0; k < numRows - 1; ++k) {
                    if (counter == s.length()){
                        break;
                    }
                    --lastRowNumber;
                    zigzag[lastRowNumber][i] = String.valueOf(s.charAt(counter));
                    ++counter;
                    ++i;
                }
                i -= 1;
                looped = 1;
            }
            for (int j = looped; j < numRows; ) {
                if (counter == s.length()){
                    break;
                }
                zigzag[j][i] = String.valueOf(s.charAt(counter));
                counter++;
                lastRowNumber = j;
                ++j;
            }
            isZigzag = true;
        }

        for (int i = 0; i < numRows; ++i){
            for (int j = 0; j < numCols; ++j){
                if (zigzag[i][j] != null){
                    res += zigzag[i][j];
                }
            }
        }
        return res;
    }

    public int calculateNumCols(int length, int numRows){
        int numCols = 0;
        while (length > 0){
            length -= numRows;
            numCols++;
            if (length > 0) {
                length = (length - numRows) + 2;
                if(length < 0){
                    numCols += numRows - 2 + length;
                } else {
                    numCols += numRows - 2;
                }
            
            }
        }
        return numCols;
    }
}
