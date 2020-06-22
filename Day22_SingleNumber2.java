public class Day22_SingleNumber2 {
    public int singleNumber(int[] nums) {
        int mask, sum = 0; 
        int result = 0; 
        
        for (int i=0; i<32; i++) {
            sum = 0;
            mask = (1<<i);
            
            for (int j=0; j<nums.length; j++) {
                if ((nums[j] & mask) != 0)
                    sum++;
            }
            
            if ((sum % 3)!=0) {
                    result |= (1<<i);
                }
        }
        
        return result;
    }
}