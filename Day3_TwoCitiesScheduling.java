/**
 * Greedy: 
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
Note:

1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000

EXPLANATION:-
The problem is to send n persons to city A 
and n persons to city B with minimum cost.

The idea is to send each person to city A.
costs = [[10,20],[30,200],[400,50],[30,20]]

So, totalCost = 10 + 30 + 400 + 30 = 470

Now, we need to send n persons to city B.
Which persons do we need to send city B?

Here, we need to minimize the cost.
We have already paid money to go to city A.
So, Send the persons to city B who get more refund
so that our cost will be minimized.

So, maintain refunds of each person
refund[i] = cost[i][1] - cost[i][0]

So, refunds of each person
    refund = [10, 170, -350, -10]

Here, refund +ve means we need to pay
             -ve means we will get refund.

So, sort the refund array.

refund = [-350, -10, 10, 170]

Now, get refund for N persons,
totalCost += 470 + -350 + -10 = 110

So, minimum cost is 110
 */

import java.util.*; 
class Day3_TwoCitiesScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int minCost = 0;
        int n = costs.length/2;
        int refund[] = new int[2*n];
        int j=0;
        for (int i=0; i<costs.length; i++) {
            refund[j++] = costs[i][1] - costs[i][0];
            minCost += costs[i][0];
        }
        
        Arrays.sort(refund);
        
        for (int i=0; i<n; i++) {
            minCost += refund[i];
        }
        
        return minCost;
    }
}