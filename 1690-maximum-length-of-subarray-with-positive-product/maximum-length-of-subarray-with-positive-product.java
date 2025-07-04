class Solution {
    public int getMaxLen(int[] nums) {
        int maxLen = 0;
        int positiveLen = 0; 
        int negativeLen = 0;  

        for (int num : nums) {
            if (num == 0) {
                positiveLen = 0;
                negativeLen = 0;
            }
            
             else if (num > 0) {
                // positive number
                positiveLen += 1;
                negativeLen = (negativeLen == 0) ? 0 : negativeLen + 1;
            }
            
             else {
                // negative number s
                int temp = positiveLen;
                positiveLen = (negativeLen == 0) ? 0 : negativeLen + 1;
                negativeLen = temp + 1;
            }
            maxLen = Math.max(maxLen, positiveLen);
        }

        return maxLen;
    }
}
