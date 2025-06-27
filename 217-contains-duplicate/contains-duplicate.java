class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums){
            if(set.contains(num)){
                return true;
            }

            else{
                set.add(num);
            }
        }
        return  false;
    }

   // approach - sorting

    public boolean containsDuplicateSorting(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i =1; i<n ; i++){
            if (nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
}

