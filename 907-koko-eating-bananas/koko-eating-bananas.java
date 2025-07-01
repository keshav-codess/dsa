class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles);
        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, mid, h)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        long totalHours = 0;
        for (int pile : piles) {
            
            totalHours += (pile + (long)k - 1) / k;
        }
        return totalHours <= h;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
