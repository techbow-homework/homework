package com.techbow.homework.y2021.m10.zekun;

public class LC0079_DFS_WordSearch {
    public boolean exist(char[][] board, String word) {
        //cc
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return false;
        }

        int nrow = board.length;
        int ncol = board[0].length;

        boolean[][] visited = new boolean[nrow][ncol];
        char[] target = word.toCharArray();
        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(dfs(board, i, j, target, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, int i, int j, char[] target, int index, boolean[][] visited){
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        //base case
        //success
        if(index == target.length){
            return true;
        }
        //fail
        if(i < 0 || i >= nrow || j < 0 || j >= ncol || target[index] != matrix[i][j] || visited[i][j]){
            return false;
        }

        //set visited
        visited[i][j] = true;

        //branches
        boolean ret = dfs(matrix, i + 1, j, target, index + 1, visited) || dfs(matrix, i, j + 1, target, index + 1, visited) || dfs(matrix, i - 1, j, target,index + 1, visited) || dfs(matrix, i, j - 1, target, index + 1, visited);
        //reset visited
        visited[i][j] = false;

        return ret;
    }
}
