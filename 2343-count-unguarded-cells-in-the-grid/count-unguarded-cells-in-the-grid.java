class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] wall : walls) grid[wall[0]][wall[1]] = 2;
        for (int[] guard : guards) grid[guard[0]][guard[1]] = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 1 && grid[nx][ny] != 2) {
                    grid[nx][ny] = 3; 
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0) count++; 

        return count;
    }
}
