/**
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 */
import java.util.*;
public class Day14_CheapestFlightWithinKStops {
    // Used for building the graph
    class Pair {
        int city, cost;
        
        Pair (int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
    
    // Used in heap
    class City {
        int city, distFromSrc, costFromSrc;
        
        City (int city, int distFromSrc, int costFromSrc)
        {
            this.city = city;
            this.distFromSrc = distFromSrc;
            this.costFromSrc = costFromSrc;
        }
        
    }
    
    private void buildGraph(List<List<Pair>> graph, int [][]flights, int n)
    {
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0; i<flights.length; i++) {
            graph.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        if (n<=0 || flights == null || K < 0 || flights.length == 0) {
            return -1;
        }
        
        List<List<Pair>> graph = new ArrayList<>();
        
        this.buildGraph(graph, flights, n);
        
        Queue<City> pq = new PriorityQueue<>((City c1, City c2) -> c1.costFromSrc - c2.costFromSrc);
        pq.add(new City(src, 0, 0));
        
        while (pq.isEmpty() == false) {
            
            City cheap = pq.poll();

            if (cheap.city == dst) {
                return cheap.costFromSrc;
            }
            
            if (cheap.distFromSrc > K) {
                continue;
            }

            for (int i=0; i<graph.get(cheap.city).size(); i++) {
                Pair adjCity = graph.get(cheap.city).get(i);
                pq.add(new City(adjCity.city, cheap.distFromSrc + 1, cheap.costFromSrc + adjCity.cost));
            }
        }
        
        return -1;
    }
}