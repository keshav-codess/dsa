class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Directions for 8 neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        // First pass: apply the rules and mark transitions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, directions);

                // Rule 1 or 3: live cell dies
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2; // live → dead
                }

                // Rule 4: dead cell becomes live
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = -1; // dead → live
                }
            }
        }

        // Second pass: finalize the update
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // was live, now dead
                } else if (board[i][j] == -1) {
                    board[i][j] = 1; // was dead, now live
                }
            }
        }
    }

    // Helper method to count live neighbors
    private int countLiveNeighbors(int[][] board, int i, int j, int[][] directions) {
        int count = 0;
        int m = board.length, n = board[0].length;

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                if (board[ni][nj] == 1 || board[ni][nj] == 2) {
                    count++;
                }
            }
        }

        return count;
    }
}
