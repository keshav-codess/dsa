class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;  // base case

        int mid = left + (right - left) / 2; 
        TreeNode root = new TreeNode(nums[mid]);  // root from mid

        root.left = buildBST(nums, left, mid - 1);   // left subtree
        root.right = buildBST(nums, mid + 1, right); // right subtree

        return root;
    }
}
