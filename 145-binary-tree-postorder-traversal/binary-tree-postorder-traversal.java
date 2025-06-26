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

    // Approach -2 : Iterative Approach using two stacks
    // TC - O(N), SC - O(N)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list; // handle null root

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            // Pick the last added
            TreeNode currentNode = stack1.pop();
            stack2.push(currentNode);

            // Push left first, then right (so right is processed first in reverse)
            if (currentNode.left != null) {
                stack1.push(currentNode.left);
            }

            if (currentNode.right != null) {
                stack1.push(currentNode.right);
            }
        }

        // Stack2 now has nodes in reverse postorder → reverse it
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }

        return list; // Return the result list
    }






    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        // Approach 1 – Recursive Postorder Traversal
        List<Integer> list = new ArrayList<>();
        postorderHelper(root, list);
        return list;
    }

    void postorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderHelper(root.left, result);   // Visit left subtree
        postorderHelper(root.right, result);  // Visit right subtree
        result.add(root.val);                 // Visit root
    }
}

