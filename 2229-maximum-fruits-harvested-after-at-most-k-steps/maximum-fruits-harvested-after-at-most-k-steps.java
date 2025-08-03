class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int l = 0, curSum = 0, res = 0;
        
        for (int r = 0; r < n; r++) {
            curSum += fruits[r][1];  
            
            while (l <= r && minSteps(fruits[l][0], fruits[r][0], startPos) > k) {
                curSum -= fruits[l][1];
                l++;
            }
            res = Math.max(res, curSum);
        }
        return res;
    }
    
    private int minSteps(int left, int right, int start) {
        if (start <= left) { 
            return right - start;
        }
        if (start >= right) {
            return start - left; 
        }

        return Math.min((start - left) + (right - left), (right - start) + (right - left));
    }
}
