class Solution {
    public int numberOfBeams(String[] bank) {
        int prevCount = 0, totalBeams = 0;
        
        for (String row : bank) {
            int currCount = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') currCount++;
            }
            
            if (currCount > 0) {
                totalBeams += prevCount * currCount;
                prevCount = currCount;
            }
        }
        
        return totalBeams;
    }
}
