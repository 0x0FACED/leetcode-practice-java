class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> indexesRows = new ArrayList<>();
        List<Integer> indexesCols = new ArrayList<>();
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    indexesRows.add(i);
                    indexesCols.add(j);
                }
            }
        }

        for(int i = 0; i < indexesRows.size(); ++i){
            fillRow(matrix[indexesRows.get(i)]);
            fillColumn(indexesCols.get(i), matrix);
        }
    }

    public void fillRow(int[] row){
        for(int i = 0; i < row.length; ++i){
            row[i] = 0;
        }
    }

    public void fillColumn(int columnIndex, int[][] matrix){
        for(int i = 0; i < matrix.length; ++i){
            matrix[i][columnIndex] = 0;
        }
    }
}
