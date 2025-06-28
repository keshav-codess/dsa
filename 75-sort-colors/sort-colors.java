class Solution {
    public void sortColors(int[] nums) {
        int low =0;
        int mid =0;
        int high =nums.length -1;

        while(mid <= high){
            //swaps 0 to front
            if(nums[mid] == 0){  
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++; 
            }

            else if(nums[mid]==1){
                mid++; //already in the middle
            }

            else{
                //swaps 2 to the end
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
        
    }
}