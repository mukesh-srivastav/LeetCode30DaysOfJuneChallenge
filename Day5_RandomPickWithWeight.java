/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 * 
 * Explanation :
Say we have w[] = {2, 5, 3} then it means that we have to pick an index from {0, 1, 2} based on the w[] array, meaning
probability of picking 0 is 2 / (2 + 5 + 3) = 20 percent,
probability of picking 1 is 5 / (2 + 5 + 3) = 50 percent ,
probability of picking 2 is 3 / (2 + 5 + 3) = 30 percent.
Think about this array [0, 0, 1, 1, 1, 1, 1, 2, 2, 2] -> from this array we have to pick a number randomly.

Algorithm :
In order to do it we can generate an array like w_sum[] = {2, 7, 10}, which consists of the cumulative sum of the w[] array. After this simply generate a random number 10 * Math.random(), which is in the range [0,10).

random number in [0,1] -> 0
random number in [2,6] -> 1
random number in [7,9] -> 2
 */
public class Day5_RandomPickWithWeight {
    /**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
    int cu_sum[];
    
    public Day5_RandomPickWithWeight(int[] w) {
        int sum = 0;
        cu_sum = new int[w.length];
        
        for (int i=0; i<w.length; i++) {
            sum += w[i];
            cu_sum[i] = sum;
        }
    }
    
    public int pickIndex() {
        double target = cu_sum[cu_sum.length - 1] * Math.random();
        int low = 0, high = cu_sum.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (cu_sum[mid] > target) {
                res = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}