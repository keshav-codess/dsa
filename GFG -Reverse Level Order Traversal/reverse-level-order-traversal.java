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

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
    ArrayList<Integer> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
        
        if(root == null){
            return result;
        }
        
        queue.offer(root);
        
        while (!queue.isEmpty()){
            Node current = queue.poll();
            stack.push(current.data);
            
              // Enqueue right child first, then left child
              
            if (current.right != null){
                queue.offer(current.right);
            }
            
            if (current.left != null){
                queue.offer(current.left);
            }
        }
        
        // Pop all items from stack into result
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        
        return result;
        
    }
}
