//bottom up approach
class Solution {
       public int fib(int n) {
        if(n<=1){
            return n;
        }
        // table (array), starts with the best case ---> for solving larger problems

        int dp[]=new int[n+1];
        // filling the best case
        dp[0]=0;
        dp[1]=1;
//. to fill the dp array
// 1- fill the best case first
// 2. then fill this by using thr RR
//         int result = fib(n-1) + fib(n-2);
for( int i=2; i<=n;i++){
    dp[i]=dp[i-1]+dp[i-2];

}
return dp[n];
       }
}


// class Solution {

//     HashMap<Integer, Integer> cache  =new HashMap<> ();
//     public int fib(int n) {
//         if (n==0 || n==1){
//             return n;
//         }
//         if(cache.containsKey(n)){
//             return cache.get(n);
//         }
//         int result = fib(n-1) + fib(n-2);
//         cache.put(n, result);
//         return result;
        
//     }
// }