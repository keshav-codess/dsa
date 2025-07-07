// User function Template for Java

class Solution {
    // Function to return list of integers that form the boundary
    // traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int mat[][]) {
        
        ArrayList<Integer> result = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;

        // Top row (left to right)
        for (int i = 0; i < n; i++) {
            result.add(mat[0][i]);
        }

        // Right column (top to bottom)
        for (int i = 1; i < m; i++) {
            result.add(mat[i][n - 1]);
        }

        // Bottom row (right to left), only if more than one row
        if (m > 1) {
            for (int i = n - 2; i >= 0; i--) {
                result.add(mat[m - 1][i]);
            }
        }

        // Left column (bottom to top), only if more than one column
        if (n > 1) {
            for (int i = m - 2; i >= 1; i--) {
                result.add(mat[i][0]);
            }
        }

        return result;
        
    }
}
