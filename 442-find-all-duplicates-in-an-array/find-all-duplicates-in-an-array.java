import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                // already negative means second time seeing this number
                result.add(Math.abs(nums[i]));
            } else {
                // seeing first time, so make it negative
                nums[index] = -nums[index];
            }
        }

        return result;
    }
}
