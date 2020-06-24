/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

   Idea :
Let us consider an example for n = 4. Here we have 4 choices for the root.

If root is 1, then left subtree will be empty and right subtree will have 3 nodes.
If root is 2, then left subtree will have 1 nodes and right subtree will have 2 nodes.
If root is 3, then left subtree will have 2 nodes and right subtree will have 1 nodes.
If root is 4, then left subtree will have 3 nodes and right subtree will be empty.
So, if f[4] is the solution to the problem for n = 4, then we will have
f[n] = f[0] * f[3] + f[1] * f[2] + f[2] * f[1] + f[3] * f[0]

In general we will have for n
f[n] = f[0] * f[n - 1] + f[1] * f[n - 2] + ... upto so on... + f[n - 2] * f[1] + f[n - 1] * f[0]

This recurrence relation can be easily solved by using dynamic programming.
Base cases :
n = 0, f[0] = 1, empty subtree
n = 1, f[1] = 1, one subtree with 1 as the root. Below is the code.
 */
public class Day24_CountPossibleUniqueBSTs {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i<=n; i++) {
            for (int j= 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]); 
            }
        }
        
        return dp[n];
    }
}