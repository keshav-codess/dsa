class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Prefix product
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Suffix product
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }

        return result;
    }
}

    // public int[] productExceptSelfOptimized(int[] nums) {
    //     int n = nums.length;
    //     int[] prefixProduct = new int[n];
    //     int[] suffixProduct = new int[n];
    //     int[] result = new int[n];

    //     // Initialize prefixProduct
    //     prefixProduct[0] = 1;
    //     for (int i = 1; i < n; i++) {
    //         prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
    //     }

    //     // Initialize suffixProduct
    //     suffixProduct[n - 1] = 1;
    //     for (int i = n - 2; i >= 0; i--) {
    //         suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
    //     }

    //     // Calculate result
    //     for (int i = 0; i < n; i++) {
    //         result[i] = prefixProduct[i] * suffixProduct[i];
    //     }

    //     return result;
//     }
// }
   







    // public int[] productExceptSelfBruteFore(int[] nums) {
    //     int result[] = new int [nums.length]; 
    //     for ( int i =0; i < nums.length; i++ ){
    //         int product =1;
    //         for ( int j =0; j<nums.length; i++){
    //             if ( i!= j){
    //                 product = product * nums[j];

    //             }
    //         }
    //         result [i] = product;
    //     }
    //     return result;
//     }
// }