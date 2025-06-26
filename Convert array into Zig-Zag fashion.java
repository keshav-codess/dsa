
class Solution {
    public static void zigZag(int[] arr) {
        // code here
        boolean less = true;
        for ( int i = 0; i < arr.length-1; i++){
            if (less){
                if (arr[i] > arr [i + 1]){
                    int temp = arr[i];
                    arr[i] = arr [i+1];
                    arr[i+ 1] = temp;
                }
            }
            else {
                if (arr[i] < arr [i + 1]){
                   int  temp = arr[i];
                    arr[i] = arr [i+1];
                    arr[i+ 1] = temp;
                }
            }
            less = ! less;
        }
    }
}
