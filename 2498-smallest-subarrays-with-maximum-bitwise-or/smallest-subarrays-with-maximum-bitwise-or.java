class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] last = new int[32]; 

        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    last[b] = i;
                }
            }

            int farthest = i;
            for (int b = 0; b < 32; b++) {
                farthest = Math.max(farthest, last[b]);
            }

            answer[i] = farthest - i + 1;
        }
        return answer;
    }
}
