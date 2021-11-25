package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][] {newInterval};
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        // smaller ones
        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        // intersections
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        // greater ones
        while(i < n && intervals[i][0] > newInterval[1]){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = new int[]{4,8};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval))); //[[1,2],[3,10],[12,16]]
    }
}
// time O(n) space O(1)
