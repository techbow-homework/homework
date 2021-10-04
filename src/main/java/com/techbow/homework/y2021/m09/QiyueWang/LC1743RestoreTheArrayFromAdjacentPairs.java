package com.techbow.homework.y2021.m09.QiyueWang;

import java.lang.reflect.Array;
import java.util.*;

public class LC1743RestoreTheArrayFromAdjacentPairs {
    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<Integer>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<Integer>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }

        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1) {
                res[0] = e;
                break;
            }
        }

        res[1] = map.get(res[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = map.get(res[i - 1]);
            res[i] = res[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{2,1},{3,4},{3,2}};
        System.out.println(Arrays.toString(restoreArray(input))); // [1,2,3,4]
    }
}
