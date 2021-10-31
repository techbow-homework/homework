package com.techbow.homework.y2021.m10.ryanxu.LC_79;

public class LC_79 {

    private int row;
    private int col;

    public boolean exist(char[][] board, String word) {

        if (board == null || word == null) {
            return false;
        }

        this.row = board.length;
        this.col = board[0].length;

        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idxWord, boolean[][] visited) {


        if (idxWord == word.length() - 1 && board[i][j] == word.charAt(idxWord)) {
            return true;
        }

        if (idxWord == word.length() - 1 || board[i][j] != word.charAt(idxWord)) {
            return false;
        }

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        visited[i][j] = true;
        for (int d = 0; d < directions.length; d++) {
            int nextI = i + directions[d][0];
            int nextJ = j + directions[d][1];
            if (inArea(nextI, nextJ) && !visited[nextI][nextJ]) {
                if (dfs(board, nextI, nextJ, word, idxWord + 1, visited)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;

        return false;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        LC_79 lc_79 = new LC_79();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(lc_79.exist(board, word));
    }
}
