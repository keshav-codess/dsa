class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Finding peak index
        int peak = findPeak(mountainArr, 0, n - 1);

        //  Binary search on left part (increasing)
        int left = binarySearch(mountainArr, target, 0, peak, true);
        if (left != -1) return left;

        // Binary search on right part (decreasing)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int findPeak(MountainArray mountainArr, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            int midVal = mountainArr.get(mid);
            int midNext = mountainArr.get(mid + 1);
            if (midVal < midNext) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearch(MountainArray mountainArr, int target, int low, int high, boolean ascending) {
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = mountainArr.get(mid);
            if (val == target) return mid;

            if (ascending) {
                if (val < target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (val < target) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }
}
