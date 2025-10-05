class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);       // Pacific left
            dfs(heights, atlantic, i, n - 1, heights[i][n-1]); // Atlantic right
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);       // Pacific top
            dfs(heights, atlantic, m - 1, j, heights[m-1][j]); // Atlantic bottom
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] h, boolean[][] vis, int i, int j, int prev) {
        int m = h.length, n = h[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || vis[i][j] || h[i][j] < prev) return;
        vis[i][j] = true;
        dfs(h, vis, i+1, j, h[i][j]);
        dfs(h, vis, i-1, j, h[i][j]);
        dfs(h, vis, i, j+1, h[i][j]);
        dfs(h, vis, i, j-1, h[i][j]);
    }
}
