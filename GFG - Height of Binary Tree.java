/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if(node == null){
            return -1;
        }
        
        int left = height(node.left);
        int right = height(node.right);
        
        int maxHeight = Math.max(left,right);
        
        return maxHeight +1;
    }
}
