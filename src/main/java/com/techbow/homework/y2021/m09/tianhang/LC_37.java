package com.techbow.homework.y2021.m09.tianhang;

import java.util.HashSet;
import java.util.Set;

public class LC_37 {
    Set[] row, col, cell;
    char[][] board;
    public void solveSudoku(char[][] board) {
        row = new Set[9];
        col = new Set[9];
        cell = new Set[9];
        this.board = board;
        for(int i = 0; i < 9; ++i) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            cell[i] = new HashSet<>();
        }

        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j) {
                if(board[i][j] != '.') {
                    int c = board[i][j] - '0';
                    row[i].add(c);
                    col[j].add(c);
                    cell[(i/3) * 3 + j / 3].add(c);
                }
            }
        }
        dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if(j == 9) {
            j = 0;
            ++i;
        }
        if (i == 9) {
            return true;
        }
        if(board[i][j] != '.') {
            return dfs(i, j + 1);
        } else {
            for(int k = 1; k <= 9; ++k) {
                if (!row[i].contains(k) && !col[j].contains(k) && !cell[i / 3 * 3 + j / 3].contains(k)) {
                    row[i].add(k);
                    col[j].add(k);
                    cell[i/3 * 3 + j / 3].add(k);
                    board[i][j] = (char)(k + '0');
                    if(dfs(i, j + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                    row[i].remove(k);
                    col[j].remove(k);
                    cell[(i/3) * 3 + j / 3].remove(k);
                }
            }
            return false;
        }
    }
}
