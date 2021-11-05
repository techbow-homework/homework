package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTreasure {
    public static List<int[]> findPath(int[][] board, int[] start, int[] end){
        int m = board.length;
        int n = board[0].length;
        int treasure = 0;
        List<List<int[]>> res = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    treasure ++;
                }
            }
        }
        //System.out.println(treasure);
        dfs(board, start[0], start[1], end, treasure, visited, new ArrayList<>(), res);
        List<int[]> ret = new ArrayList<>();
        System.out.println("All solutions " + res.size());

        if(res.size() != 0) {
            int len = res.get(0).size();
            //System.out.println(len);
            for(List<int[]> l : res){
                if(l.size() <= len){
                    ret = new ArrayList<>(l);
                    len = l.size();

                }
//                for(int[] a : l){
//                    System.out.print(Arrays.toString(a));
//                }
//                System.out.println();
            }
        }
        return ret;
    }
    private static void dfs(int[][] board, int i, int j, int[] end, int remain, boolean[][] visited, List<int[]> path, List<List<int[]>> res){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] == -1){
            return;
        }
// add before return
        visited[i][j] = true;
        if(board[i][j] == 1) remain --;
        path.add(new int[]{i,j});

        if(remain == 0 && i == end[0] && j == end[1]){
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            if(board[i][j] == 1) remain ++;
            visited[i][j] = false;
            return;
        }

        dfs(board, i + 1, j, end, remain, visited, path, res);
        dfs(board, i - 1, j, end, remain, visited, path, res);
        dfs(board, i, j + 1, end, remain, visited, path, res);
        dfs(board, i, j - 1, end, remain, visited, path, res);
        path.remove(path.size() - 1);
        visited[i][j] = false;
        if(board[i][j] == 1) remain ++;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{1,  0,  0, 0, 0 },{ 0, -1, -1, 0, 0 },{0, -1,  0, 1, 0 },{ -1,  0,  0, 0, 0 },{0,  1, -1, 0, 0 },{0,  0,  0, 0, 0 }};
        int[] start = new int[]{0,0};
        int[] end = new  int[]{4,1};
        List<int[]> res = findPath(board, start, end);
        System.out.println("best solution length " + res.size());
        //(List<int[]> l : res){
            for(int[] a : res){
                System.out.print(Arrays.toString(a));
            }
            //System.out.println();
        //}
    }
}
