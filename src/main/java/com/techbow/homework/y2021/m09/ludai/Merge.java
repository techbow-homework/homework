package com.techbow.homework.y2021.m09.ludai;

public class Merge {
    List<int[]> diffs = new LinkedList<>();
        for (int[] interval : intervals ) {
        diffs.add(new int[]{interval[0],1});
        diffs.add(new int[]{interval[1],-1});
    }
        Collections.sort(diffs, (o1,o2) -> o1[0] != o2[0]? o1[0]-o2[0] : o2[1] - o1[1]);
    int count = 0, start = -1, end = -1;
    List<int[]> res = new LinkedList<>();
        for (int[] diff: diffs) {
        if (start == -1 && diff[1] > 0) {
            start = diff[0];
        }
        count += diff[1];
        if (count == 0) {
            end = diff[0];
            res.add(new int[]{start,end});
            start=-1;
        }
    }
        return res.toArray(new int[0][0]);
}
