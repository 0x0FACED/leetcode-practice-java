// wrong solution - DO NOT allocate another matrix

class Solution {
    public void rotate(int[][] matrix) {
        int[][] srcMatrix = copyMatrix(matrix);
        int rowRotate = 0;
        int colRotate = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                matrix[rowRotate][colRotate] = srcMatrix[i][j];
                ++rowRotate;
            }
            rowRotate = 0;
            --colRotate;
        }
    }

    public int[][] copyMatrix(int[][] matrix){
        int[][] res = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < res.length; ++i){
            for(int j = 0; j < res[0].length; ++j){
                res[i][j] = matrix[i][j];
            }
        }
        return res;
    }
}
