class Solution {
    public int maxLen(int n, int[][] edges, String label) {
        int[][][] dp = new int[1 << n][n][n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            if (label.charAt(u) == label.charAt(v)) {
                int mask = (1 << u) | (1 << v);
                dp[mask][u][v] = 2;
                dp[mask][v][u] = 2;
                queue.offer(new int[]{mask, u, v});
            }
        }

        // Initialize dp for single nodes
        for (int i = 0; i < n; i++) {
            dp[1 << i][i][i] = 1;
            queue.offer(new int[]{1 << i, i, i});
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int mask = state[0], u = state[1], v = state[2];
            ans = Math.max(ans, dp[mask][u][v]);

            for (int i : graph.get(u)) {
                if ((mask & (1 << i)) != 0) continue;
                for (int j : graph.get(v)) {
                    if (j == i || (mask & (1 << j)) != 0) continue;
                    if (label.charAt(i) == label.charAt(j)) {
                        int newMask = mask | (1 << i) | (1 << j);
                        if (dp[newMask][i][j] < dp[mask][u][v] + 2) {
                            dp[newMask][i][j] = dp[newMask][j][i] = dp[mask][u][v] + 2;
                            queue.offer(new int[]{newMask, i, j});
                        }
                    }
                }
            }
        }

        return ans;
    }
}
