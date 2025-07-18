/*
Structure of Node class is:

class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/

class Solution {
    private static int ans = -1;

    public int kthAncestor(Node root, int k, int node) {
        ans = -1; 
        dfs(root, k, node);
        return ans;
    }

    private int dfs(Node root, int k, int node) {
        if (root == null) return -1;

        // if target node found
        if (root.data == node) return 0;

        int left = dfs(root.left, k, node);
        int right = dfs(root.right, k, node);

        if (left != -1 || right != -1) {
            int dist = Math.max(left, right) + 1;

            if (dist == k) {
                ans = root.data;
            }

            return dist;
        }

        return -1; // node not found 
    }
}
