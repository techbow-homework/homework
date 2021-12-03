package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC797AllPathsFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        dfs(graph, 0, n - 1, cur, res);
        return res;
    }

    private static void dfs(int[][] graph, int index, int target, List<Integer> cur, List<List<Integer>> res){
        if(index == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i : graph[index]){
            cur.add(i);
            dfs(graph, i, target, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph1 = new int[][]{{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph1));//[[0,1,3],[0,2,3]]
        int[][] graph2 = new int[][]{{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(graph2));//[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
    }
}
