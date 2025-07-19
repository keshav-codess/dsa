class Solution {
    // Function to find number of strongly connected components
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step 1: Topological sort using DFS
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, visited, stack, adj);
            }
        }

        // Step 2: Reverse the graph
        ArrayList<ArrayList<Integer>> reversedGraph = reverseGraph(V, adj);

        // Step 3: Do DFS using finishing order on reversed graph
        Arrays.fill(visited, false);
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                dfs2(v, visited, reversedGraph);
                sccCount++;
            }
        }

        return sccCount;
    }

    // DFS for original graph (Topological sort)
    private void dfs1(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                dfs1(nbr, visited, stack, adj);
            }
        }
        stack.push(node);
    }

    // DFS on reversed graph
    private void dfs2(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                dfs2(nbr, visited, adj);
            }
        }
    }

    // Function to reverse the graph
    private ArrayList<ArrayList<Integer>> reverseGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            rev.add(new ArrayList<>());
        }
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                rev.get(v).add(u);
            }
        }
        return rev;
    }
}
