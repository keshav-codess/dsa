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
    // Approach – 2 Iterative Way
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack  = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);         // push left nodes
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();           // visit root
            list.add(currentNode.val);           // add root value

            currentNode = currentNode.right;     // now move to right subtree
        }
        return list;
    }






    // - Approach 1- Recursive Approach
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
         List<Integer> list = new ArrayList<>();
    inOrderHelper(root, list);
    return list;
       
    }
       // TC - O(N), SC - O(N)
void inOrderHelper(TreeNode root, List<Integer> result) {
    if (root == null) {
        return;
    }
    inOrderHelper(root.left, result);
    result.add(root.val);
    inOrderHelper(root.right, result);
}
}