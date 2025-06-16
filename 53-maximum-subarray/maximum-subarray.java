class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;

        for ( int i=1; i<nums.length;i++){
            sum = sum + nums[i];
            sum = Math.max(sum, nums[i]);
            max = Math.max(max, sum);
        }
        return max;

        //SOLUTION BRUTRE FORCE
        //  int max = Integer.MIN_VALUE;
        //     for ( int i=0; i<nums.length;i++){
        //         int sum = 0;
        //                 for ( int j=i; i<nums.length;j++){
        //                     sum = sum + nums[j];
        //                     max = Math.max ( sum, max);
        //                 }
        //     }
        //     return max;  

    }
}