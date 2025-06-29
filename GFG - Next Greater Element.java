class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean isFound = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    isFound = true;
                    list.add(arr[j]);
                    break;
                }
            }
            // j loop ends
            if (!isFound) {
                list.add(-1);
            }
        }
        return new ArrayList<>(list);
    }
}
