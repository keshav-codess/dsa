import java.util.ArrayList;

class Solution {
 
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        final int V = adj.size(); 
        ArrayList<Integer> dfsResult = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfsHelper(0, adj, visited, dfsResult); 
        return dfsResult;
    }

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
         // mark the first vertex as visited
        visited[node] = true;
        result.add(node);
        
        // explore the neighbour
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfsHelper(neighbour, adj, visited, result); 
            }
        }
    }
}
