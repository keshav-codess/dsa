class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Build the graph as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }

        return dfs(0, -1, graph, hasApple);
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> graph, List<Boolean> hasApple) {
        int totalTime = 0;

        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (child == parent) continue;

            int timeFromChild = dfs(child, node, graph, hasApple);
            if (timeFromChild > 0 || hasApple.get(child)) {
                totalTime += timeFromChild + 2;
            }
        }

        return totalTime;
    }
}
