import java.util.*;
/**
 * Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */

public class Day12_DesignInsertDeleteGetRandomInConstantTime {
    class RandomizedSet {
        HashMap<Integer, Integer> hs;
        ArrayList<Integer> list;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            hs = new HashMap<Integer, Integer>();
            list = new ArrayList<Integer>();
        }
        
        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (hs.containsKey(val))
                return false;
            list.add(val);
            hs.put(val, list.size() - 1);
            return true;
        }
        
        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (hs.containsKey(val) == false)
                return false;
            
            int index = hs.get(val);
            int swappedElement = (int)list.get(list.size() -1);
            
            Collections.swap(list, index, list.size() - 1);
            list.remove(list.size() - 1);
            
            hs.put(swappedElement, index);
            hs.remove(val);
            return true;
        }
        
        /** Get a random element from the set. */
        public int getRandom() {
            Random rn = new Random();
            
            int random = rn.nextInt(list.size());
            return list.get(random);
        }
    }
    
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}