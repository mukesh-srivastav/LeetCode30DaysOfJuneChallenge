/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

DP Table, for each element we check ways if we include this coin + ways if we do not include this coin

   0, 1, 2, 3, 4, 5
0  1, 0, 0, 0, 0, 0 
1  1, 1, 1, 1, 1, 1
2  1, 1, 2, 2, 3, 3 
3  1, 1, 2, 2, 3, 4 (A[i][j] = a[i-1][j] + (j-coins[i-1]) >= 0) ? a[i][j - coins[i-1]] : 0;
 */
public class Day7_CoinChange {
    public int change(int n, int[] coins) {
        int m = coins.length;
        
        int a[][] = new int[m+1][n+1];
        
        // if amount is zero, then for each coin addition, it will be always be 1 unique way. 
        for (int i=0; i<=m; i++) {
            a[i][0] = 1;
        }
        
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (j - coins[i-1] >=0)
                    a[i][j] = a[i-1][j] + a[i][j - coins[i-1]];
                else
                    a[i][j] = a[i-1][j];
            }
        }
        
        return a[m][n];
    }
}