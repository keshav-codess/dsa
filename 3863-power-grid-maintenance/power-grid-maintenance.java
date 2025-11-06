class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        UnionFind uf = new UnionFind(c + 1);
        for (int[] edge : connections) {
            uf.union(edge[0], edge[1]);
        }

        Map<Integer, TreeSet<Integer>> online = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = uf.find(i);
            online.putIfAbsent(root, new TreeSet<>());
            online.get(root).add(i);
        }

        boolean[] isOnline = new boolean[c + 1];
        Arrays.fill(isOnline, true);

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int root = uf.find(x);

            if (type == 1) { 
                if (isOnline[x]) {
                    ans.add(x);
                } else {
                    TreeSet<Integer> set = online.get(root);
                    ans.add((set == null || set.isEmpty()) ? -1 : set.first());
                }
            } else if (type == 2) { 
                if (isOnline[x]) {
                    isOnline[x] = false;
                    TreeSet<Integer> set = online.get(root);
                    if (set != null) set.remove(x);
                }
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) result[i] = ans.get(i);
        return result;
    }

    static class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx == ry) return;
            if (rank[rx] < rank[ry]) parent[rx] = ry;
            else if (rank[rx] > rank[ry]) parent[ry] = rx;
            else {
                parent[ry] = rx;
                rank[rx]++;
            }
        }
    }
}
