class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // Step 1:calculating prefix sum
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // Step 2: try all subarrays using prefix sums
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum;
                if (i == 0) {
                    sum = prefix[j];
                } else {
                    sum = prefix[j] - prefix[i - 1];
                }

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}



// Approach -2 : Using HashMap

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1); // To count subarrays that start at index 0
        
        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}

