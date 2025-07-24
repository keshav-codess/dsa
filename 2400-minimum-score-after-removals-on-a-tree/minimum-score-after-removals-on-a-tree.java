class Solution {
    int[] nums;
    List<Integer>[] tree;
    int[] xor;
    int[] in, out;
    int time = 0;
    int totalXor;

    public int minimumScore(int[] nums, int[][] edges) {
        this.nums = nums;
        int n = nums.length;
        tree = new ArrayList[n];
        xor = new int[n];
        in = new int[n];
        out = new int[n];
        
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        totalXor = dfs(0, -1); 

        List<int[]> directedEdges = new ArrayList<>();
        for (int[] e : edges) {
            if (in[e[0]] > in[e[1]]) directedEdges.add(new int[]{e[1], e[0]});
            else directedEdges.add(new int[]{e[0], e[1]});
        }

        int res = Integer.MAX_VALUE;

        int m = directedEdges.size();
        for (int i = 0; i < m; i++) {
            int[] e1 = directedEdges.get(i);
            int u = e1[1]; // child node of first removed edge
            for (int j = i + 1; j < m; j++) {
                int[] e2 = directedEdges.get(j);
                int v = e2[1]; // child node of second removed edge

                int x1, x2, x3;

                if (isAncestor(u, v)) {
                    x2 = xor[v];
                    x1 = xor[u] ^ xor[v];
                    x3 = totalXor ^ xor[u];
                } else if (isAncestor(v, u)) {
                    x2 = xor[u];
                    x1 = xor[v] ^ xor[u];
                    x3 = totalXor ^ xor[v];
                } else {
                    x1 = xor[u];
                    x2 = xor[v];
                    x3 = totalXor ^ x1 ^ x2;
                }

                int max = Math.max(x1, Math.max(x2, x3));
                int min = Math.min(x1, Math.min(x2, x3));
                res = Math.min(res, max - min);
            }
        }

        return res;
    }

    int dfs(int node, int parent) {
        in[node] = time++;
        int res = nums[node];
        for (int nei : tree[node]) {
            if (nei == parent) continue;
            res ^= dfs(nei, node);
        }
        xor[node] = res;
        out[node] = time++;
        return res;
    }

    boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[v] <= out[u];
    }
}
