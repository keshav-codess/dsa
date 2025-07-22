// --------------------Approach 1 : Recursive-----------------------

// class Solution {
//     public int numDecodings(String s) {
//         if (s == null || s.length() == 0) return 0;
//         return decode(s, 0);
//     }

//     private int decode(String s, int index) {
//         if (index == s.length()) return 1;
//         if (s.charAt(index) == '0') return 0;

//         int count = decode(s, index + 1);

//         if (index + 1 < s.length()) {
//             int twoDigit = Integer.parseInt(s.substring(index, index + 2));
//             if (twoDigit <= 26) {
//                 count += decode(s, index + 2);
//             }
//         }

//         return count;
//     }
// }


// --------------------Approach 2 : Memorization-----------------------

// import java.util.HashMap;

// class Solution {
//     public int numDecodings(String s) {
//         if (s == null || s.length() == 0) return 0;
//         return decode(s, 0, new HashMap<>());
//     }

//     private int decode(String s, int index, HashMap<Integer, Integer> memo) {
//         if (index == s.length()) return 1;
//         if (s.charAt(index) == '0') return 0;

//         if (memo.containsKey(index)) return memo.get(index);

//         int count = decode(s, index + 1, memo);

//         if (index + 1 < s.length()) {
//             int twoDigit = Integer.parseInt(s.substring(index, index + 2));
//             if (twoDigit <= 26) {
//                 count += decode(s, index + 2, memo);
//             }
//         }

//         memo.put(index, count);
//         return count;
//     }
// }



 // --------------------Approach 3 : Tabulation-----------------------

// class Solution {
//     public int numDecodings(String s) {
//         int n = s.length();
//         int[] dp = new int[n + 1];
//         dp[0] = 1;

//         for (int i = 1; i <= n; i++) {
//             // 1-digit check
//             if (s.charAt(i - 1) != '0') {
//                 dp[i] += dp[i - 1];
//             }

//             // 2-digit check
//             if (i >= 2) {
//                 int twoDigit = Integer.parseInt(s.substring(i - 2, i));
//                 if (twoDigit >= 10 && twoDigit <= 26) {
//                     dp[i] += dp[i - 2];
//                 }
//             }
//         }

//         return dp[n];
//     }
// }


// --------------------Approach 4 : Tabulation with space optimization -----------------------

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int prev2 = 1;  
        int prev1 = s.charAt(0) != '0' ? 1 : 0;  
        for (int i = 2; i <= n; i++) {
            int curr = 0;

            // one digit check
            if (s.charAt(i - 1) != '0') {
                curr += prev1;
            }

            // two digit check
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev2;
            }

            // update prev2 and prev1
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}







