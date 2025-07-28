/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private String smallest = "~"; 
    
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }
    
    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        
        sb.insert(0, (char)('a' + node.val));  // prepend current char
        
        if (node.left == null && node.right == null) {
            String curr = sb.toString();
            if (curr.compareTo(smallest) < 0){
                smallest = curr;
            } 
        } 
        else {
            dfs(node.left, sb);
            dfs(node.right, sb);
        }
        
        sb.deleteCharAt(0);  // backtrack
    }
}