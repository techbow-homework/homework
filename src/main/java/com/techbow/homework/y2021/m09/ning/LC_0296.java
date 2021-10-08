package com.techbow.homework.y2021.m09.ning;

public class LC_0296 {
    public int minTotalDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        List<Integer> I = new ArrayList<>(rows);
        List<Integer> J = new ArrayList<>(cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                }
            }
        }
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (grid[i][j] == 1) {
                    J.add(j);
                }
            }
        }
        return minTotalDistance(I) + minTotalDistance(J);
    }
    private int minTotalDistance(List<Integer> list) {
        int totalDistance = 0;
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            totalDistance += list.get(j--) - list.get(i++);
        }
        return totalDistance;
    }
}
