// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> result = new ArrayList<>();
        int first = firstOccurrence(arr, x);
        int last = lastOccurrence(arr, x);
        result.add(first);
        result.add(last);
        return result;
    }

 
    private int firstOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, first = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                first = mid;         // store result
                high = mid - 1;      // move left to find earlier occurrence
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    // Method to find the last occurrence of x
    private int lastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                last = mid;         // store result
                low = mid + 1;      // move right to find later occurrence
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
}
