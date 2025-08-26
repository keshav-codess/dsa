class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int bestDiag = 0, bestArea = 0;

        for (int[] rect : dimensions) {
            int l = rect[0], w = rect[1];
            int diagSq = l * l + w * w;
            int area = l * w;

            if (diagSq > bestDiag || (diagSq == bestDiag && area > bestArea)) {
                bestDiag = diagSq;
                bestArea = area;
            }
        }

        return bestArea;
    }
}
