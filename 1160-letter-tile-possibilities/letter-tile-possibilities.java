class Solution {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr); 
        boolean[] used = new boolean[arr.length];
        return backtrack(arr, used);
    }
    
    private int backtrack(char[] arr, boolean[] used) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue; 
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue; // skip duplicates
            
            used[i] = true;
            count += 1 + backtrack(arr, used); 
            used[i] = false; 
        }
        return count;
    }
}
