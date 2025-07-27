class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> compressed = new ArrayList<>();
        compressed.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                compressed.add(nums[i]);
            }
        }

        int count = 0;
        for (int i = 1; i < compressed.size() - 1; i++) {
            int prev = compressed.get(i - 1);
            int curr = compressed.get(i);
            int next = compressed.get(i + 1);
            
            if (prev < curr && curr > next) {
                count++; 
            } else if (prev > curr && curr < next) {
                count++; 
            }
        }

        return count;
    }
}
