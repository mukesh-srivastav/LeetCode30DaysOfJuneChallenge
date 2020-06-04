/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.
 */
public class Day4_ReverseString {
    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length-1;
        
        while (low <= high) {
            char c = s[low];
            s[low] = s[high];
            s[high]= c;
            low++;
            high--;
        }
        
    }
}