class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int maxGood = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            if (isValid(statements, mask, n)) {
                maxGood = Math.max(maxGood, Integer.bitCount(mask)); 
            }
        }
        return maxGood;
    }

    private boolean isValid(int[][] statements, int mask, int n) {
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 1) { 
                for (int j = 0; j < n; j++) {
                    if (statements[i][j] == 2) continue;
                    int expected = statements[i][j]; 
                    int actual = (mask >> j) & 1; 
                    if (expected != actual) return false;
                }
            }
        }
        return true;
    }

    public long maxStrength(int[] nums) {
        long product = 1;
        int maxNegative = Integer.MIN_VALUE;
        int negativeCount = 0;
        int zeroCount = 0;

        for (int num : nums) {
            if (num > 0) {
                product *= num;
            }
             else if (num < 0) {
                product *= num;
                negativeCount++;
                maxNegative = Math.max(maxNegative, num);
            } 
            else {
                zeroCount++;
            }
        }

        if (product < 0) { 
            product /= maxNegative; 
        }

        if (product == 1 && negativeCount == 0) { 
            return zeroCount > 0 ? 0 : nums[0]; 
        }

        return product;
    }
}
