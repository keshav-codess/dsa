// --------- Approach 1 : Recursive ---------

// class Solution {
//     public int tribonacci(int n) {
//         if(n == 0){
//             return 0;
//         }
//          if(n == 1 || n == 2){
//             return 1;
//          }

//          return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        
//     }
// }


// --------- Approach 2 : Memorization ---------

// class Solution {
//     public int helper(int n, Integer cache[]) {
//         if (n == 0) {
//             return 0;
//         }
//         if (n == 1 || n == 2) {
//             return 1;
//         }
//         if (cache[n] != null) {
//             return cache[n];
//         }
//         cache[n] = helper(n-1, cache) + helper(n-2, cache) + helper(n-3, cache);
//         return cache[n];
//     }

//     public int tribonacci(int n) {
//         Integer cache[] = new Integer[n + 1];
//         return helper(n, cache);
//     }
// }


// --------- Approach 3 :Tabulation ---------

// class Solution{
//     public int tribonacci(int n) {
//         if(n == 0){
//             return 0;
//         }
//         if(n == 1 || n == 2){
//             return 1;
//         }
//         int dp[] = new int[n + 1];

//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 1;

//         for(int i = 3; i <= n; i++){
//             dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
//         }
//         return dp[n];
//     }
// }



// --------- Approach 4 :Tabulation With Space Optimization---------

class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;

        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }

        return d;
    }
}
 


