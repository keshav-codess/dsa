/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */

class Solution {

    private static void markParents(Node root, Map<Node, Node> parentMap, Node[] targetNode, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == target) {
                targetNode[0] = curr;
            }
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    private static int burnTree(Node targetNode, Map<Node, Node> parentMap) {
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.add(targetNode);
        visited.add(targetNode);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                
                // spread to left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    flag = true;
                    visited.add(curr.left);
                    q.add(curr.left);
                }

                // spread to right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    flag = true;
                    visited.add(curr.right);
                    q.add(curr.right);
                }

                // spread to parent
                if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) {
                    flag = true;
                    visited.add(parentMap.get(curr));
                    q.add(parentMap.get(curr));
                }
            }
            if (flag) time++;
        }

        return time;
    }

    public static int minTime(Node root, int target) {
        Map<Node, Node> parentMap = new HashMap<>();
        Node[] targetNode = new Node[1]; 
        markParents(root, parentMap, targetNode, target);
        return burnTree(targetNode[0], parentMap);
    }
}
