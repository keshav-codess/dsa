import java.util.*;

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        final int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);          
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int neighbour : adj.get(current)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return result;
    }
}
