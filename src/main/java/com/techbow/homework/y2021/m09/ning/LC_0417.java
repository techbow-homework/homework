package com.techbow.homework.y2021.m09.ning;

public class LC_0417 {
    public static List<List<Integer>> pacificAndAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException("Input is not valid");
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[][] pacific = new boolean[numRows][numCols];
        boolean[][] atlantic = new boolean[numRows][numCols];

        // loadPacific(matrix, queue, pacific);
        for (int i = 0; i < numRows; i++) {
            queue.add(new int[]{i, 0}); // left
            pacific[i][0] = true;
        }
        for (int j = 1; j < numCols; j++) {
            queue.add(new int[]{0, j}); // top
            pacific[0][j] = true;
        }
        bfs(matrix, queue, pacific, atlantic, res);

        // loadAtlantic(matrix, queue, atlantic);
        for (int i = 0; i < numRows; i++) {
            queue.add(new int[]{i, numCols - 1}); // right
            atlantic[i][numCols - 1] = true;
        }
        for (int j = 1; j < numCols; j++) {
            queue.add(new int[]{numRows - 1, j}); // bottom
            atlantic[numRows - 1][j] = true;
        }
        bfs(matrix, queue, atlantic, pacific, res);

        return res;
    }

    private static void bfs(int[][] matrix, Queue<int[]> queue,
                            boolean[][] self, boolean[][] other, List<List<Integer>> res) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[][] DIRECTIONS = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(other[cur[0]][cur[1]]) { // if overlap, add to result
                res.add(Arrays.asList(cur[0], cur[1]));
            }
            for (int[] dir : DIRECTIONS) {
                int ii = cur[0] + dir[0], jj = cur[1] + dir[1];
                if (ii >= 0 && ii < numRows
                        && jj >= 0 && jj < numCols
                        && !self[ii][jj]
                        && matrix[cur[0]][cur[1]] <= matrix[ii][jj]) {
                    queue.add(new int[]{ii, jj});
                    self[ii][jj] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4} };
        System.out.println(pacificAndAtlantic(matrix));
    }
}
