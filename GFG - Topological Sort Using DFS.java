class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // DFS for every unvisited node
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        //  result from stack
        ArrayList<Integer> topoOrder = new ArrayList<>();
        while(!stack.isEmpty()) {
            topoOrder.add(stack.pop());
        }

        return topoOrder;
    }

    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[node] = true;

        for(int neighbor : adj.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor, visited, stack, adj);
            }
        }

        stack.push(node);
    }
}
