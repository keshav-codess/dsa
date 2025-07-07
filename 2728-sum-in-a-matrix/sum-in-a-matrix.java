import java.util.*;

class Solution {
    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        for (int i = 0; i < m; i++) {
            Arrays.sort(nums[i]);
        }

        int score = 0;

      
        for (int col = n - 1; col >= 0; col--) {
            int maxInColumn = 0;
            for (int row = 0; row < m; row++) {
                maxInColumn = Math.max(maxInColumn, nums[row][col]);
            }
            score += maxInColumn;
        }

        return score;
    }
}
