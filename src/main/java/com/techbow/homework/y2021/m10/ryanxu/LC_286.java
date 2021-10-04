package com.techbow.homework.y2021.m10.ryanxu;

import java.util.LinkedList;
import java.util.Queue;

public class LC_286 {

    private int row;
    private int col;
    private int[][] directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {

        if (rooms == null) {
            throw new IllegalArgumentException("Input is null");
        }
        this.row = rooms.length;
        if (this.row == 0) {
            return;
        }
        this.col = rooms[0].length;
        if (this.col == 0) {
            return;
        }

        // find all gates
        Queue<Integer> gates = getAllGates(rooms);
        if (gates == null || gates.size() == 0) {
            return;
        }
        int dis = 1;

        while (!gates.isEmpty()) {
            int size = gates.size();
            while (size-- > 0) {
                int cur = gates.poll();
                int curX = cur / this.col;
                int curY = cur % this.col;
                for (int d = 0 ; d < this.directions.length; d++) {
                    int nextX = curX + this.directions[d][0];
                    int nextY = curY + this.directions[d][1];
                    if (inArea(nextX, nextY) && rooms[nextX][nextY] - Integer.MAX_VALUE == 0) {
                        rooms[nextX][nextY] = dis;
                        gates.add(nextX * this.col + nextY);
                    }
                }
            }
            dis++;
        }
    }

    private boolean inArea(int x, int y) {

        return x >=0 && x < this.row && y >= 0 && y < this.col;
    }

    private Queue<Integer> getAllGates(int[][] rooms) {

        Queue<Integer> res = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    int target = i * this.col + j;
                    res.add(target);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC_286 lc_286 = new LC_286();
        int[][] rooms = new int[][] {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        lc_286.wallsAndGates(rooms);
        System.out.println();
    }
}
