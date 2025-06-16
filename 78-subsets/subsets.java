class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> smallList= new ArrayList<>();
        List<List<Integer>> bigList =  new ArrayList<>();
        helpers(nums, 0, smallList, bigList);
        return bigList;
    }
    void helpers( int []nums, int index, List<Integer> smallList, List <List <Integer>> bigList){

            bigList.add(new ArrayList<>(smallList));
        
        for(int i=index; i<nums.length; i++){
        
                smallList.add(nums[i]);
            helpers(nums, i+1, smallList, bigList);
            smallList.remove(smallList.size()-1);
            
        }
    }
}