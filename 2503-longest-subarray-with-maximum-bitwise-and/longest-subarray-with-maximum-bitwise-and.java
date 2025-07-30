class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);  
        }
        
        int longest = 0;
        int count = 0;
        
        for (int num : nums) {
            if (num == maxVal) {
                count++;
                longest = Math.max(longest, count); 
            } else {
                count = 0; // reset when value is different
            }
        }
        
        return longest;
    }
}
