class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> smallList= new ArrayList<>();
        List<List<Integer>> bigList =  new ArrayList<>();
        helpers(nums, smallList, bigList);
        return bigList;
    }
    void helpers( int []nums, List<Integer> smallList, List <List <Integer>> bigList){

        if(smallList.size()==nums.length){
            bigList.add(new ArrayList<>(smallList));
        }
        for(int i=0; i<nums.length; i++){
            if(!smallList.contains(nums[i])){
                smallList.add(nums[i]);
            helpers(nums, smallList, bigList);
            smallList.remove(smallList.size()-1);
            }
        }

    }
}