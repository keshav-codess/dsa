class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int i = 0, n = colors.length();

        while (i < n) {
            char currentColor = colors.charAt(i);
            int maxTime = 0, sumTime = 0;

            while (i < n && colors.charAt(i) == currentColor) {
                sumTime += neededTime[i];
                maxTime = Math.max(maxTime, neededTime[i]);
                i++;
            }

            totalTime += sumTime - maxTime; 
        }

        return totalTime;
    }
}
