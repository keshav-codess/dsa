class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currentElement = nums[i];
            int tempMax = currentMax;

            currentMax = Math.max(currentElement, Math.max(currentElement * currentMax, currentElement * currentMin));
            currentMin = Math.min(currentElement, Math.min(currentElement * tempMax, currentElement * currentMin));

            max = Math.max(currentMax, max);
        }
        return max;
    }
}
