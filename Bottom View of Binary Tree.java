/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
     ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> topNodeMap = new TreeMap<>();
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;
           
                topNodeMap.put(hd, node.data);
            

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        for (int val : topNodeMap.values()) {
            result.add(val);
        }

        return result;
    }

    // Pair class to store node and horizontal distance
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
