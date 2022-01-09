package com.techbow.homework.y2021.m12QiyueWang;

import java.util.*;

public class LC310MinimumHeightTrees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n]; // out degrees
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            List<Integer> temp1 = graph.getOrDefault(e[0], new ArrayList<>());
            temp1.add(e[1]);
            graph.put(e[0], temp1);
            degree[e[0]]++;
            List<Integer> temp2 = graph.getOrDefault(e[1], new ArrayList<>());
            temp2.add(e[0]);
            graph.put(e[1], temp2);
            degree[e[1]]++;
        }
        //System.out.println(graph);

        Queue<Integer> queue = new LinkedList<>();
        //put leaves into the queue as first layer
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        //System.out.println(queue);
        //trim the leaves till only one or two left
        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();// each layer
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neighbors = graph.get(cur);
                //System.out.println(neighbors);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(findMinHeightTrees(6,edges));//[3,4]
        int[][] edges2 = {{0,1}};
        System.out.println(findMinHeightTrees(2,edges2));//[0,1]
    }
}
// time O(V) space O(V)
