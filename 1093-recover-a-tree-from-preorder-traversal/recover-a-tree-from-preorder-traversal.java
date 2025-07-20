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
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int depth = 0;
            // count dashes to determine depth
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // get the value of the node
            int val = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(val);

            // stack size > depth, pop to reach correct parent
            while (stack.size() > depth) {
                stack.pop();
            }

            // attach to parent
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) parent.left = node;
                else parent.right = node;
            }

            stack.push(node);
        }

        // last node in the stack's bottom is the root
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}
