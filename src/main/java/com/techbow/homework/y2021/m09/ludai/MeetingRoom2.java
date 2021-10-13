package com.techbow.homework.y2021.m09.ludai;

public class MeetingRoom2 {
    List<int[]> diffs = new LinkedList<>();
    for (int[] interval: intervals) {
        diffs.add(new int[]{interval[0], 1});
        diffs.add(new int[]{interval[1], -1});
    }
        Collections.sort(diffs, (o1, o2) ->  o1[0]!=o2[0]? o1[0]-o2[0] : o1[1]-o2[1] );
    int count = 0;
    int res = 0;
    for (int[] diff : diffs) {
        count += diff[1];
        res = Math.max(res, count);
    }
        return res;
}
