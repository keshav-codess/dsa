class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        
         int n = mat.length;
        ArrayList<Integer> result = new ArrayList<>();

 
        for (int d = 0; d < 2 * n - 1; d++) {
            
            if (d % 2 == 0) {
                int i = Math.min(d, n - 1);
                int j = d - i;

                while (i >= 0 && j < n) {
                    result.add(mat[i][j]);
                    i--;
                    j++;
                }
            }
            else {
                int j = Math.min(d, n - 1);
                int i = d - j;

                while (j >= 0 && i < n) {
                    result.add(mat[i][j]);
                    i++;
                    j--;
                }
            }
        }

        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
    }
}
