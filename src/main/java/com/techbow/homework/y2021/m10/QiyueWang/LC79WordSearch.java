package com.techbow.homework.y2021.m10.QiyueWang;

import java.awt.*;

public class LC79WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word, 0, i, j, new boolean[m][n])){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        if(index == word.length() - 1){ // && board[i][j] == word.charAt(index)){
            return true;
        }

        visited[i][j] = true;
        boolean res = dfs(board, word, index + 1, i + 1, j, visited) || dfs(board, word, index + 1, i, j + 1, visited) || dfs(board, word, index + 1, i - 1, j, visited) || dfs(board, word, index + 1, i, j - 1, visited);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        char[][] board2 = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word2 = "ABCB";
        System.out.println(exist(board, word)); // true
        System.out.println(exist(board2, word2)); // false
    }
}
