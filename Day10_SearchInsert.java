/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
 */
public class Day10_SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int low = 0, high = nums.length-1;
        
        while (low <= high) {
            int mid = (high + low)/2;
            
            if (nums[mid] == target)
                return mid;
            
            else if ((mid == 0 || nums[mid - 1] < target) && nums[mid] >= target)
                     return mid;
            else if ((mid == nums.length - 1 || nums[mid+1] > target) && nums[mid] <= target)
                    return mid+1;
            
            if (nums[mid] < target)
                     low = mid + 1;
            else
                     high = mid-1;
        }
        
        return index;
    }
}