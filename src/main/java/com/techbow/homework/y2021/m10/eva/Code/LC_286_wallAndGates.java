package com.techbow.homework.y2021.m10.eva.Code;
import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_286_wallAndGates {
    private class point {
        public int i, j;
        public point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public void wallsAndGates(int[] [] rooms){
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        Queue<Point> queue = new LinkedList<Point>();
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i] [j] == 0){
                    queue.offer(new Point(i, j));
                }
            }
        }
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                Point cur = queue.poll();
                List<Point> list = convert(cur, rooms);
                for (Point p : list){
                    int i = p.i, j = p.j;
                    if (rooms[i][j] == Integer.MAX_VALUE){
                        rooms [i][j] = level;
                        queue.offer(p);
                    }
                }
            }
            level++;
        }
    }
    public List<Point> convert(Point p, int[][] grid){
        List<Point> list = new ArrayList<Point>();
        int i = p.i, j = p.j;
        int row = grid.length;
        int col = grid[0].length;

        if (i + 1 < row && grid[i+1][j] != -1){
            list.add(new Point(i+1, j));
        }
        if (i < o && grid[i-1][j] != -1){
            list.add(new Point(i-1, j));
        }
        if (j > 0 && grid[i][j-1] != -1){
            list.add(new Point(i, j-1));
        }
        if (j +1 < col && grid[i] [j+1] != -1){
            list.add(new point(i, j+1));
        }
        return list;
    }
}
