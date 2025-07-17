// class Solution {
//     public int rob(int[] money) {
//         return rob(money, 0);
//     }

//     public int rob(int[] money, int houseNo) {
//                // base case: no more houses left
//         if (houseNo >= money.length) {
//             return 0;
//         }

//                // choice 1: rob this house and move to houseNo + 2
//         int choice1 = money[houseNo] + rob(money, houseNo + 2);

//                // choice 2: skip this house and move to houseNo + 1
//         int choice2 = rob(money, houseNo + 1);

//                // return the maximum of both choices
//         return Math.max(choice1, choice2);
//     }
// }



//Approach 2: Memorization (Top Down)
// class Solution {
//     public int rob(int[] money) {
//         int[] cache = new int[money.length];
//         Arrays.fill(cache, -1);
//         return rob(money, 0, cache);
//     }

//     public int rob(int[] money, int houseNo, int[] cache) {
//         if (houseNo >= money.length) return 0;
//         if (cache[houseNo] != -1) return cache[houseNo];

//         int choice1 = money[houseNo] + rob(money, houseNo + 2, cache);
//         int choice2 = rob(money, houseNo + 1, cache);

//         int result = Math.max(choice1, choice2);
//         cache[houseNo] = result;
//         return result;
//     }
// }


//Approach 3: Tabulation (Bottom Up)
class Solution {
    public int rob(int[] money) {
        if (money.length == 0) { 
            return 0;
        }
        if (money.length == 1) {
            return money[0];
        }

        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < dp.length; i++) {

            int choice1 = dp[i - 2] + money[i];
            int choice2 = dp[i - 1];
            
            int result = Math.max(choice1, choice2);
            dp[i] = result;
        }
        return dp[dp.length - 1];
    }
}


