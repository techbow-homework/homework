package com.techbow.homework.y2021.m10.ryanxu.LC_51;

import java.util.ArrayList;
import java.util.List;

public class LC_51 {
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        dfs(res, board, 0, n);
        return res;
    }

    private void dfs(List<List<String>> res, char[][] board, int idx, int n) {

        if (idx == n) {
            res.add(getAnswer(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(board, idx, i, n)) {
                board[idx][i] = 'Q';
                dfs(res, board, idx + 1, n);
                board[idx][i] = '.';
            }
        }
    }

    private List<String> getAnswer(char[][] board) {

        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(String.valueOf(row));
        }
        return res;
    }

    private boolean valid(char[][] board, int row, int col, int n) {

        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        int k = 1;
        while (row - k >= 0 && col - k >= 0) {
            if (board[row - k][col - k] == 'Q') {
                return false;
            }
            k++;
        }
        k = 1;
        while (row - k >= 0 && col + k < n) {
            if (board[row - k][col + k] == 'Q') {
                return false;
            }
            k++;
        }
        return true;
    }

    public static void main(String[] args) {
        LC_51 lc_51 = new LC_51();
        System.out.println(lc_51.solveNQueens(4));
    }
}
