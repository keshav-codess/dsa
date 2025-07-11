/*class Node

class Node
{
   int data;
   Node right,down;

   Node(int data){
       this.data = data;
       right = null;
       down = null;
   }
}
*/
/*Function should return the head of the 2D LL.*/
class Solution {
    static Node construct(int arr[][]) {
        int n = arr.length;
        if (n == 0) return null;

        // nodes for all elements
        Node[][] nodes = new Node[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = new Node(arr[i][j]);
            }
        }

        // linking right and down pointers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) nodes[i][j].right = nodes[i][j + 1];
                if (i + 1 < n) nodes[i][j].down = nodes[i + 1][j];
            }
        }

        
        return nodes[0][0];
    }
}
