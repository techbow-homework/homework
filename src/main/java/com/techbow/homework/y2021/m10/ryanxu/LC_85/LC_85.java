package com.techbow.homework.y2021.m10.ryanxu.LC_85;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_85 {
    public int maximalRectangle(char[][] matrix) {

        if (matrix == null) {
            return 0;
        }
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        if (matrix[0].length == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int res = 0;

        for (int i = 0; i < row; i++) {
            int[] arr = new int[col];
            for (int k = i; k < row; k++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[k][j] == '1') {
                        arr[j] += 1;
                    } else {
                        arr[j] = 0;
                    }
                }
                res = Math.max(res, getMaxArea(arr));
            }
        }
        return res;
    }

    private int getMaxArea(int[] arr) {

        int len = arr.length;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < len; i++) {
            list.add(arr[i]);
        }
        list.add(0);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(stack.peek())) {
                stack.push(i);
            } else {
                while (list.get(stack.peek()) > list.get(i)) {
                    int height = list.get(stack.peek());
                    stack.pop();
                    int width = i - stack.peek() - 1;
                    res = Math.max(res, height * width);
                }
                stack.push(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC_85 lc_85 = new LC_85();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(lc_85.maximalRectangle(matrix));
    }
}
