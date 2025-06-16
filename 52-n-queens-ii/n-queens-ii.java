class Solution {
    boolean board[][];

    public int totalNQueens(int n) {
        board = new boolean[n][n];
        int count = helper(0, n);
        return count;
    }

    boolean checkInAboveRow(int row, int col) {
        for (int i = row; i >= 0; i--) {
            if (board[i][col]) {
                return false; // queen already present
            }
        }
        return true;
    }

    boolean checkInLD(int row, int col) {
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false; // queen already present
            }
        }
        return true;
    }

    boolean checkInRD(int row, int col) {
        for (int i = row, j = col; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j]) {
                return false; // queen already present
            }
        }
        return true;
    }

    boolean canIPlaceAQueen(int row, int col) {
        return checkInAboveRow(row, col) &&
               checkInLD(row, col) &&
               checkInRD(row, col);
    }

    int helper(int row, int n) {
        // base case
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (canIPlaceAQueen(row, col)) {
                board[row][col] = true; // place queen
                count += helper(row + 1, n); // recursive call
                board[row][col] = false; // backtrack
            }
        }
        return count;
    }
}
