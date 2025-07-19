/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        if (!isLeaf(root))
            result.add(root.data);


        addLeftBoundary(root.left, result);

        addLeaves(root, result);

        addRightBoundary(root.right, result);

        return result;
    }

    // check if node is a leaf
    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    void addLeftBoundary(Node node, ArrayList<Integer> res) {
        while (node != null) {
            if (!isLeaf(node))
                res.add(node.data);

            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    // add leaf nodes
    void addLeaves(Node node, ArrayList<Integer> res) {
        if (node == null)
            return;

        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    // add right boundary in reverse (bottom-up)
    void addRightBoundary(Node node, ArrayList<Integer> res) {
        Stack<Integer> temp = new Stack<>();

        while (node != null) {
            if (!isLeaf(node))
                temp.push(node.data);

            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }

        while (!temp.isEmpty())
            res.add(temp.pop());
    }
}
