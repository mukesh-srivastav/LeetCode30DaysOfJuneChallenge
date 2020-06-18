/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3 
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note:

If there are several possible values for h, the maximum one is taken as the h-index.
https://leetcode.com/problems/h-index-ii/discuss/693427/C%2B%2B-or-BOTH-O(logn)-and-O(n)-solution-with-explanation
 */
public class Day18_HIndexII {
    // O(n)
    public int hIndexOn(int[] citations) {
        int n = citations.length;
        if (n==0)
            return 0;
        
        for (int i=0; i<n; i++) {
            if (citations[i] >= n - i)
                return n - i;
        }
        return 0;
    }

    // Logn
    int hIndexLogn(int c[]) {
        int n = c.length;
        if(n==0) return 0;
        int low =0,high=n-1;
        int ans = 0;
        while(low<=high){
            int mid  = low + (high-low)/2;
            if(c[mid] >= n-mid){
                ans = n-mid;
                high = mid - 1;
            }else{
                low  = mid + 1;
            }
        }
        
        return ans;
	}
}