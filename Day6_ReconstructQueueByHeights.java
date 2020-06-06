/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
Note:
The number of people is less than 1,100.
Topic/Genre : Greedy
Example:
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
Arrange all the person based on the heights sorted in decreasing order and if two or more person has same heights then compare their K values in assending order.
Insert one by one based on K value in the queue
Example 1
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Sort based on height and K value.
[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]

Now we construct the queue using the sorted person list .

1. Add [7, 0] at 0 --> [[7,0]]
2. Add [7, 1] at 1 --> [[7,0], [7,1]]
3. Add [6, 1] at 1 --> [[7,0], [6, 1, [7,1]]
4. Add  [5,0] at 0 --> [[5,0], [7,0], [6, 1], [7,1]]
5. Add [5, 2] at 2 --> [[5,0], [7,0], [5, 2], [6, 1], [7,1]]
6. Add [4, 4] at 4 --> [[5,0], [7,0], [5, 2], [6, 1],[4, 4], [7,1]] which is output
Intuition: 
K value, denotes the number of people ahead of that person whose height is greater than him/her. Now, if the K value is same, then the person whose height is smaller should be kept first. Let's take a case [5,0] and [7,0]. If we sort the array in decreasing order of height then [7,0] will be inserted into the output array first. And due to the way insert work, [5,0] will be placed before [7,0] and [7,0] will be shifted to the right. So, we get out desired order of people.
*/
import java.util.*;
public class Day6_ReconstructQueueByHeights {
    public int[][] reconstructQueue(int[][] people) {
        // sort array using Arrays.sort with custom comparator
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]); 
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]); // placing people based on the K value
        }
        return list.toArray(people); // convert list to array
}   
}