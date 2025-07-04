import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};

        Solution sol = new Solution();
        int result = sol.numIdenticalPairs(nums);

        System.out.println("Number of good pairs: " + result);
    }
}

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            if (freqMap.containsKey(num)) {
                count += freqMap.get(num);
            }
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
