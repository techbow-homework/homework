package com.techbow.homework.y2021.m10.eva.Code;

public class LC_79_wordSearch {
    private boolean search(char[][] board, char[] word, int curIdx, int i, int j, boolean[][] visited){
        int len = word.length;
        if (curIdx == len) return true;
        int row = board.length, col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >=col || board[i][j] != word[curIdx] || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        curIdx++;
        boolean res = search(board, word, curIdx, i + 1, j, visited)
                || search(board, word, curIdx, i - 1, j, visited)
                || search(board, word, curIdx, i, j + 1, visited)
                || search(board, word, curIdx, i, j - 1, visited);
        visited[i][j] = false;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;

        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (search(board, wordChar, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }
}
