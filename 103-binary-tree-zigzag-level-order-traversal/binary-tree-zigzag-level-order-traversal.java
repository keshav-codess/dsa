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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null){
            return result;
        }
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(leftToRight){
                    level.add(current.val);
                }
                else{
                    level.add(0,current.val);
                }

                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right); 
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }
}