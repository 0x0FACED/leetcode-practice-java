class NumMatrix {
    private int[][] _sumMatrix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        _sumMatrix = new int[n][m];
        _sumMatrix[0][0] = matrix[0][0];

        for(int i = 1; i < m; ++i){
            _sumMatrix[0][i] = _sumMatrix[0][i - 1] + matrix[0][i];
        }

        for(int i = 1; i < n; ++i){
            _sumMatrix[i][0] = _sumMatrix[i - 1][0] + matrix[i][0];
        }

        for(int i = 1; i < n; ++i){
            for(int j = 1; j < m; ++j){
                _sumMatrix[i][j] = _sumMatrix[i][j - 1];

                for(int k = i; k >= 0; --k){
                    _sumMatrix[i][j] += matrix[k][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int fullSum = _sumMatrix[row2][col2];
        if(col1 == 0 && row1 == 0){
            return fullSum;
        }
        if(col1 != 0 && row1 != 0){
            int subtractUp = _sumMatrix[row1 - 1][col2] - _sumMatrix[row1 - 1][col1 - 1];
            int subtractLeft = _sumMatrix[row2][col1 - 1];
            return fullSum - subtractUp - subtractLeft;
        }
        if(col1 == 0 && row1 != 0){
            int subtractUp = _sumMatrix[row1 - 1][col2];
            return fullSum - subtractUp;
        }
        if(col1 != 0 && row1 == 0){
            int subtractLeft = _sumMatrix[row2][col1 - 1];
            return fullSum - subtractLeft;
        }
        return 0;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
