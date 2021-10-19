package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1 <= m,n <= 200
board[i][j] is 'X' or 'O'
*/

public class LC_0130 {
    // S1: DFS
    // time: O(n)
    // space: O(n)
    public void solve(char[][] board) {
        // cc
        int m = board.length;
        int n = board[0].length;

        // step1: construct list of border cells
        // left border, right border
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n- 1);
        }
        // top border, bottom border
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }

        // step3: flip the cells to their correct final states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }
    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length ||
                col >= board[0].length || board[row][col] != 'O') return;
        board[row][col] = 'E';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    // S2: BFS
    // time: O(n)
    // space: O(n)
    public void solve(char[][] board) {
        // cc
        int m = board.length;
        int n = board[0].length;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    queue.offer(i * n + j);
                }
            }
        }

        bfs(board, queue);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void bfs(char[][] board, Queue<Integer> queue) {
        int rows = board.length;
        int cols = board[0].length;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / cols;
            int j = cur % cols;
            board[i][j] = 'E';
            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0], jj = j + dir[1];
                if (ii >= 0 && ii < rows && jj >= 0 && jj < cols && board[ii][jj] == 'O') {
                    queue.offer(ii * cols + jj);
                }
            }
        }
    }

    public static void main(String[] args) {
        LC_0130 sol = new LC_0130();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        sol.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
