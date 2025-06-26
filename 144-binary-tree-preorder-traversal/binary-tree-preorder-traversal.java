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
    
    // Approach -2 : Iterative Approach
    // TC - O(N), SC - O(N)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list; // handle null root

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // Pick the last added
            TreeNode currentNode = stack.pop();
            list.add(currentNode.val);

            // Push right first, then left (so left is processed first)
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }

        return list; //  Return the result list
    }









 // - Approach 1- Recursive Approach
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    preOrderHelper(root, list);
    return list;
    }

    // TC - O(N), SC - O(N)
void preOrderHelper(TreeNode root, List<Integer> result) {
    if (root == null) {
        return;
    }
    result.add(root.val);
    preOrderHelper(root.left, result);
    preOrderHelper(root.right, result);
}
}
