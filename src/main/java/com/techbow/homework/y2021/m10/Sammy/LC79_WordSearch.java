package com.techbow.homework.y2021.m10.Sammy;

public class LC79_WordSearch {
    public boolean exist(char[][] board, String word){
        //cc
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(word, board, visited,i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(String word, char[][] board, boolean[][] visited, int i, int j, int idx){
        if(idx == word.length()) {
            return true;
        }
        //failure
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx) || visited[i][j]) return false;

        visited[i][j] = true;
        idx++;
        boolean temp = dfs(word, board, visited, i + 1, j, idx) ||
                dfs(word, board, visited, i - 1, j, idx) ||
                dfs(word, board, visited, i, j + 1, idx) ||
                dfs(word, board, visited, i, j - 1, idx);
        visited[i][j] = false;
        return temp;
    }
}
