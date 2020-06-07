public class Day7_CoinChange {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        return count (amount, coins, n);
    }
    
    public int count(int amount, int[] coins, int n) {
        //Time complexity of this function: O(mn) 
        //Space Complexity of this function: O(n) 
  
        // table[i] will be storing the number of solutions 
        // for value i. We need n+1 rows as the table is 
        // constructed in bottom up manner using the base 
        // case (n = 0) 
        int[] table = new int[amount+1]; 
  
        // Initialize all table values as 0 
        Arrays.fill(table, 0);   //O(n) 
  
        // Base case (If given value is 0) 
        table[0] = 1; 
  
        // Pick all coins one by one and update the table[] 
        // values after the index greater than or equal to 
        // the value of the picked coin 
        for (int i=0; i<n; i++) 
            for (int j=coins[i]; j<=amount; j++) 
                table[j] += table[j-coins[i]]; 
  
        return table[amount]; 
    }
}