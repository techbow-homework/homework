package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.*;
//  {{1,4}, {1,5}, {2,5}, {3,6}, {6,7}, {5,8}}
//            1    2    3
//          /  \  /      \
//          4    5        6
//               |         \
//               8          7

public class CommonAncestors {
    public static boolean hasCommonAncestor(int[][] edges, int a, int b){
        int n = edges.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> graphInv = new HashMap<>();
        Set<Integer> allNums = new HashSet<>();
        Set<Integer> notRoots = new HashSet<>();

        for (int i = 0; i < n; i++){
            int[] cur = edges[i];
            List<Integer> temp = graph.getOrDefault(cur[0], new ArrayList<>());
            temp.add(cur[1]);
            graph.put(cur[0], temp);
            List<Integer> temp2 = graphInv.getOrDefault(cur[1], new ArrayList<>());
            temp2.add(cur[0]);
            graphInv.put(cur[1], temp2);
            allNums.add(cur[0]);
            allNums.add(cur[1]);
            notRoots.add(cur[1]);
        }
        allNums.removeAll(notRoots);
        List<Integer> roots = new ArrayList<>(allNums);
        List<List<Integer>> resA = new ArrayList<>();
        List<List<Integer>> resB = new ArrayList<>();
        findAncestors(a, graphInv, new ArrayList<>(), resA);
        findAncestors(b, graphInv, new ArrayList<>(), resB);
        Set<Integer> AncestorA = new HashSet<>();
        for(List<Integer> l : resA){
            AncestorA.addAll(l);
            //System.out.println(l);
        }
        for(List<Integer> l : resB){
            //System.out.println(l);
            for (int i : l) {
                if (AncestorA.contains(i)) return true;
            }
        }
        return false;
    }
    private static void findAncestors(int a, Map<Integer, List<Integer>> graphInv, List<Integer> path, List<List<Integer>> res) {
        if(!graphInv.containsKey(a)){
            res.add(new ArrayList<>(path));
            return;
        }
        List<Integer> cur = graphInv.get(a);
        for (int b : cur){
            path.add(b);
            findAncestors(b, graphInv, path,res);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,4}, {1,5}, {2,5}, {3,6}, {6,7}, {5, 8}};
        System.out.println(hasCommonAncestor(edges,5,8));
    }
}
