package com.techbow.homework.y2021.m10.ryanxu.LC_452;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_452 {

    private static class Cell implements Comparable<Cell> {
        private int start;
        private int end;

        public Cell(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(this.end, o.end);
        }
    }

    public int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }

        int len = points.length;
        List<Cell> list = new ArrayList<>();
        for (int[] point : points) {
            list.add(new Cell(point[0], point[1]));
        }
        Collections.sort(list);
        int i = 0;
        int count = 0;
        while (i < len) {
            int j = i + 1;
            while (j < len && list.get(j).start <= list.get(i).end) {
                j++;
            }
            count++;
            i = j;
        }

        return count;
    }

    public static void main(String[] args) {
        LC_452 lc_452 = new LC_452();
        int[][] points = {{Integer.MIN_VALUE + 2, Integer.MIN_VALUE + 1}, {Integer.MAX_VALUE - 1, Integer.MAX_VALUE}};
        System.out.println(lc_452.findMinArrowShots(points));
    }
}
