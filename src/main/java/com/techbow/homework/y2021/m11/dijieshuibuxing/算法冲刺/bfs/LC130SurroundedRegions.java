package com.techbow.homework.y2021.m11.dijieshuibuxing.算法冲刺.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * Example 2:
 * <p>
 * Input: board = [["X"]]
 * Output: [["X"]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 */
public class LC130SurroundedRegions {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void solve(char[][] board) {
        //cc
        //find o on 4 sides to do bfs
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                bfs(board, i, col - 1);
            }
        }

        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                bfs(board, row - 1, j);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void bfs(char[][] board, int i, int j) {
        int row = board.length, col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        board[i][j] = 'Y';

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int[] dir : DIRECTIONS) {
                int ii = x + dir[0];
                int jj = y + dir[1];

                if (ii < 0 || ii >= row || jj < 0 || jj >= col) continue;
                if(board[ii][jj]!='O') continue;
                queue.offer(new int[]{ii,jj});
                board[ii][jj] = 'Y';
            }
        }
    }

    public static void main(String[] args) {

            char[][] board = new char[][]{{'O','O'},{'O','O'}};

        solve(board);
    }
}
