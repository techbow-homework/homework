package com.techbow.homework.y2021.m11.dijieshuibuxing.算法冲刺.bfs;


import java.util.LinkedList;
import java.util.Queue;

/*
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.



Example 1:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
Example 2:


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 */

//从每个点出发，去涂色，不能只加入一个点
public class LC785IsGraphBipartite {


    public static boolean isBipartite(int[][] graph) {

        //cc
        int[] visited = new int[graph.length];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if(visited[i]!=0) continue;
            queue.offer(i);
            visited[i] = -1;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                for(int next:graph[cur]){
                    if(visited[next] == 0){//没有涂色
                        visited[next] = - visited[cur];// 下一层是另外一个颜色
                        queue.offer(next);
                    }else{
                        if(visited[next] == visited[cur]){
                            return false;
                        }
                    }
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {

        int[][] array = {{1,3},{0,2},{1,3},{0,2}};
        isBipartite(array);
    }

    int[] parent = null;
    public  boolean isBipartite_unifind(int[][] graph) {
        //cc

         parent = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < graph.length; i++) {
            int k = graph[i][0];//取出这个node邻居中的任意代表值
            for (int x : graph[i]) {
                if (findParent(i) == findParent(x)) return false;
                union(k, x);
            }
        }
        return true;
    }

    private  void union(int k, int x) {
        if(parent[k] < parent[x]){// 大树往小树上拼
            parent[x] = parent[k];
        }else{
            parent[k] = parent[x];
        }
    }

    private  int findParent(int i) {
        if(i != parent[i]){
            parent[i] = findParent(parent[i]); // path compress
        }
        return parent[i];
    }
}
