class Solution {
    final int MAX = 9;
    char[][] board; // Instance variable

    public void solveSudoku(char[][] board) {
        this.board = board;
        helper(0, 0);
    }

    boolean checkInRowValuePresent(int row, char digit) {
        for (int i = 0; i < MAX; i++) {
            if (board[row][i] == digit) {
                return true;
            }
        }
        return false;
    }

    boolean checkInColValuePresent(int col, char digit) {
        for (int i = 0; i < MAX; i++) {
            if (board[i][col] == digit) {
                return true;
            }
        }
        return false;
    }

    boolean checkInSubGrid(int row, int col, char digit) {
        int startRow = row - row % 3;
        int colStart = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == digit) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean canIPlace(int row, int col, char digit) {
        return !checkInRowValuePresent(row, digit) &&
               !checkInColValuePresent(col, digit) &&
               !checkInSubGrid(row, col, digit);
    }

    boolean helper(int row, int col) {
        // If column reaches the end, move to next row
        if (col == MAX) {
            row = row + 1;
            col = 0;
        }

        // If row reaches the end, Sudoku is solved
        if (row == MAX) {
            return true;
        }

        // If already filled, move to the next cell
        if (board[row][col] != '.') {
            return helper(row, col + 1);
        }

        for (char digit = '1'; digit <= '9'; digit++) {
            if (canIPlace(row, col, digit)) {
                board[row][col] = digit; // place digit
                if (helper(row, col + 1)) {
                    return true;
                }
                // BACKTRACK if not successful
                board[row][col] = '.'; // undo placement
            }
        }

        return false; // No valid placement found
    }
}
