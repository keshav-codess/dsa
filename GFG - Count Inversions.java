class Solution {
    static int inversionCount(int arr[]) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    static int mergeSortAndCount(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;

            // Count inversions in left and right subarrays
            count += mergeSortAndCount(arr, low, mid);
            count += mergeSortAndCount(arr, mid + 1, high);

            count += mergeAndCount(arr, low, mid, high);
        }
        return count;
    }

    static int mergeAndCount(int[] arr, int low, int mid, int high) {
        int[] left = java.util.Arrays.copyOfRange(arr, low, mid + 1);
        int[] right = java.util.Arrays.copyOfRange(arr, mid + 1, high + 1);

        int i = 0, j = 0, k = low, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (left.length - i);  
            }
        }

        // Copy remaining elements
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];

        return swaps;
    }
}
