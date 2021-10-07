package com.techbow.homework.y2021.m03.Taiyi;

import java.util.Arrays;

public class LC252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] cur = intervals[i];
            int[] next = intervals[i + 1];
            if (cur[1] > next[0]) return false;
        }
        return true;
    }
}
