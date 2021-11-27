package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Deque;
import java.util.LinkedList;

public class LC85MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] heights = new int[n];// till each row, renew heights
        int res = 0;
        for(int i = 0; i < m; i++){
            updateH(matrix, heights, i);
            res = Math.max(res, getArea(heights));
        }

        return res;
    }

    private static void updateH(char[][] matrix, int[] heights, int row){
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[row][j] == '1'){
                heights[j] += 1;
            }else{
                heights[j] = 0;
            }
        }
    }

    private static int getArea(int[] heights){
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>(); // increasing stack
        int res = 0;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peekLast()]){
                int idx = stack.pollLast();
                int h = heights[idx];
                int width = stack.isEmpty() ? i : i - stack.peekLast() - 1;
                int area = h * width;
                res = Math.max(res, area);
            }
            stack.offerLast(i);
        }
        // pop out all
        while(!stack.isEmpty()){
            int idx = stack.pollLast();
            int h = heights[idx];
            int width = stack.isEmpty() ? n : n - stack.peekLast() - 1;
            int area = h * width;
            res = Math.max(res, area);
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));//6
    }
}
