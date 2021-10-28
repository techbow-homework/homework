package com.techbow.homework.y2021.m10.QiyueWang;

public class LC329LongestIncreasingPathInAMatrix {
    private static int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] mem = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int l = dfs(matrix, i, j, -1, mem);
                max = Math.max(max, l);
            }
        }
        return max;
    }
    private static int dfs(int[][] matrix, int i, int j, int prevVal, int[][] mem){
        int m = matrix.length;
        int n = matrix[0].length;
        if(i < 0 || j < 0 || i >= m || j >=n || matrix[i][j] <= prevVal) return 0;
        if(mem[i][j] != 0) return mem[i][j];

        int curLen = 0;
        for(int[] d : dirs){
            int newX = i + d[0];
            int newY = j + d[1];
            int tempLen = dfs(matrix, newX, newY, matrix[i][j], mem) + 1;
            curLen = Math.max(curLen, tempLen);
        }
        mem[i][j] = curLen;
        return curLen;
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        int[][] matrix2 = new int[][]{{3,4,5},{3,2,6},{2,2,1}};
        System.out.println(longestIncreasingPath(matrix1));//4
        System.out.println(longestIncreasingPath(matrix2));//4
    }
}
// time O(m*n) space O(m*n)
