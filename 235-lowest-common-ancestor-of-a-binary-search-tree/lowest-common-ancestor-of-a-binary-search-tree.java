/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pValue = p.val;
        int qValue = q.val;

        while (root != null) {
            if (pValue < root.val && qValue < root.val) {
                root = root.left;
            } 
            else if (pValue > root.val && qValue > root.val) {
                root = root.right;
            } 
            else {
                return root;
            }
        }

        return null;
    }
}
