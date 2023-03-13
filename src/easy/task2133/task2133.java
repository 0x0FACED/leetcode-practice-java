class Solution {
    public static boolean checkValid(int[][] matrix) {
        if (!checkRows(matrix)) {
            return false;
        }
        if(!checkColumns(matrix)){
            return false;
        }
        return true;
    }

    public static boolean checkRows(int[][] board) {
        for (int[] row : board) {
            if (isRepeatNumbers(row)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumns(int[][] board){
        int[] column = new int[board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                column[j] = board[j][i];
            }
            if (isRepeatNumbers(column)) {
                return false;
            }
            column = new int[board[0].length];
        }
        return true;
    }

    public static boolean isRepeatNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; ++i) {
            for (int j = numbers.length - 1; j > i; --j) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
