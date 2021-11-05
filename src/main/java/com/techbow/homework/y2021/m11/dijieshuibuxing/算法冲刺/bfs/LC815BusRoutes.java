package com.techbow.homework.y2021.m11.dijieshuibuxing.算法冲刺.bfs;

import java.util.*;

/*
You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.

Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.



Example 1:

Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Example 2:

Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
Output: -1


Constraints:

1 <= routes.length <= 500.
1 <= routes[i].length <= 105
All the values of routes[i] are unique.
sum(routes[i].length) <= 105
0 <= routes[i][j] < 106
0 <= source, target < 106
 */


// 因为起点和终点有可能在一个route内， 所以设立两个visited，一个是给routes用，一个是给stop用
// 建图，Map<Stop:RouteIndex>, stop number : the index of the routes includes the stop
// 其他的为常规
public class LC815BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //cc
        if(source==target){
            return 0;
        }

        //build graph
        // <Stop:BusRoutes>
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                graph.computeIfAbsent(stop, b -> new HashSet<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStop = new HashSet<>();
        Set<Integer> visitedBusRoute = new HashSet<>();

        queue.offer(source);
        visitedStop.add(source);
        int res = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curStop = queue.poll();
                // if(curStop == target){
//                    return res;
//                }

                Set<Integer> linkedRoutes = graph.get(curStop);
                for (int route : linkedRoutes) {
                    if (visitedBusRoute.add(route)) {
                        for (int stop : routes[route]) {
                            if(stop == target){
                                return res++;
                            }
                            if (visitedStop.add(stop)) {
                                queue.offer(stop);
                            }
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] routes = {{7,12},{4,5,15},{6},{15,19},{9,12,13}};
//        numBusesToDestination(routes,15,12);
    }
}
