class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
        pq.offer(new int[]{grid[0][0], 0, 0}); // {time, x, y}
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int res = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], x = cur[1], y = cur[2];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            res = Math.max(res, t);
            if (x == n - 1 && y == n - 1) return res;
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        return -1;
    }
}
