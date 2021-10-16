package com.techbow.homework.y2021.m10.QiyueWang;
import java.util.*;
public class LC1466ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static int minReorder(int n, int[][] connections) {
        Map<Integer,HashSet<int[]>> graph = new HashMap<>();
        for(int[] c : connections){ // add both vertices
            HashSet<int[]> t1 = graph.getOrDefault(c[0], new HashSet<int[]>());
            t1.add(c);
            graph.put(c[0],t1);
            HashSet<int[]> t2 = graph.getOrDefault(c[1], new HashSet<int[]>());
            t2.add(c);
            graph.put(c[1],t2);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int res = 0;
        //System.out.println(graph);
        while(!q.isEmpty()){
            int cur = q.poll();
            HashSet<int[]> adj = graph.get(cur);
            graph.remove(cur);
            for(int[] e : adj){
                if(e[0] != cur && graph.containsKey(e[0])) q.offer(e[0]); // add next
                if(e[1] != cur && graph.containsKey(e[1])){ // if e[1] != cur, then e[0] = cur, need a reverse
                    q.offer(e[1]);
                    res += 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] connections = new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}};
        int[][] connections2 = new int[][]{{1,0},{1,2},{3,2},{3,4}};
        System.out.println(minReorder(6,connections)); // 3
        System.out.println(minReorder(5,connections2)); // 2
    }
}
// time O(N + E) space O(N + E)
