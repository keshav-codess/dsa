class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        for (int x : nums) {
            freq[x]++;
            if (freq[x] > maxFreq) maxFreq = freq[x];
        }
        int ans = 0;
        for (int x : freq) if (x == maxFreq) ans += x;
        return ans;
    }
}
