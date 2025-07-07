class Solution {
    // Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            // Even rows: left to right
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    result.add(matrix[i][j]);
                }
            } 
            // Odd rows: right to left
            else {
                for (int j = n - 1; j >= 0; j--) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}
