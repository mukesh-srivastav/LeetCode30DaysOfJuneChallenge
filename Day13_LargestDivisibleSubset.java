/**
 * Given a set of distinct positive integers, find the largest subset/subsequence such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
 */
import java.util.*;

public class Day13_LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        if (nums.length == 0)
            return list;
        
        /*Sort all array elements in increasing order. The purpose of sorting is to make sure that all divisors of an element appear before it.*/
        Arrays.sort(nums); 
        
        // array that maintains the maximum index  
        // till which the condition is satisfied 
        int divCount[] = new int[nums.length];
        // we will always have atleast one  
        // element divisible by itself
        Arrays.fill(divCount, 1);
        
        // maintain the index of the last increment 
        int prev[] = new int[nums.length];
        Arrays.fill(prev, -1);
        
        // index at which last increment happened 
        int max_index = 0;
        
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                // only increment the maximum index if  
                // this iteration will increase it 
                if (nums[i] % nums[j] == 0 && divCount[i] < divCount[j] + 1) {
                    divCount[i] = divCount[j] + 1;
                    prev[i] = j;
                }
            }
            
            // Update last index of largest subset if size 
            // of current subset is more. 
            if (divCount[i] > divCount[max_index]) {
                max_index = i;
            }
        }
        
        int k = max_index;
        
        while (k >= 0) {
            // Adding in list as same in order as elements are in given input array. 
            list.add(0, nums[k]);
            k = prev[k];
        }
        return list;
    }
}