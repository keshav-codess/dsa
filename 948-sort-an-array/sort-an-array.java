import java.util.*;

class Solution {
    public int[] sortArray(int[] nums) {
        // Fix: Typo in method name "mergerSort" → "mergeSort"
        // Fix: Array range should be from 0 to nums.length - 1
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int low, int high) {
        // Base condition to stop recursion
        if (low >= high) return;

        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);       // left leg
        mergeSort(nums, mid + 1, high);  // right leg 

        // above divide, now merging
        merge(nums, low, mid, high);
    }

    void merge(int[] nums, int low, int mid, int high) {
        // Fix: Parameter order corrected to (nums, low, mid, high)
        int left = low;
        int right = mid + 1;
        List<Integer> list = new ArrayList<>();

        while (left <= mid && right <= high) {
            // Fix: spacing issue in "< ="
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(nums[left]);
            left++;
        }

        while (right <= high) {
            list.add(nums[right]);
            right++;
        }

        for (int i = 0; i < list.size(); i++) {
            nums[low + i] = list.get(i);
        }





















    //     if (nums.length <= 1) return nums;

    //     mergeSort(nums, 0, nums.length - 1);
    //     return nums;
    // }

    // private void mergeSort(int[] nums, int left, int right) {
    //     if (left >= right) return;

    //     int mid = left + (right - left) / 2;

    //     mergeSort(nums, left, mid);
    //     mergeSort(nums, mid + 1, right);

    //     merge(nums, left, mid, right);
    // }

    // private void merge(int[] nums, int left, int mid, int right) {
    //     int[] temp = new int[right - left + 1];
    //     int i = left, j = mid + 1, k = 0;

    //     while (i <= mid && j <= right) {
    //         if (nums[i] <= nums[j]) {
    //             temp[k++] = nums[i++];
    //         } else {
    //             temp[k++] = nums[j++];
    //         }
    //     }

    //     while (i <= mid) {
    //         temp[k++] = nums[i++];
    //     }

    //     while (j <= right) {
    //         temp[k++] = nums[j++];
    //     }

    //     for (int l = 0; l < temp.length; l++) {
    //         nums[left + l] = temp[l];
    //     }
    }
}
