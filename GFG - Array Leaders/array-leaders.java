class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        
        int maxToRight = arr[n-1];
        result.add(maxToRight);
        
        for(int i = n-2; i >= 0; i--){
            if(arr[i] >= maxToRight){
                result.add(arr[i]);
                maxToRight = arr[i];
            }
        }
        Collections.reverse(result);
        return result;
        
    }
}
