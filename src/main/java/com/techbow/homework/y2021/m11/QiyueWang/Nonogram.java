package com.techbow.homework.y2021.m11.QiyueWang;
//Example instructions #1
//
//        matrix1 = [[1,1,1,1],
//        [0,1,1,1],
//        [0,1,0,0],
//        [1,1,0,1],
//        [0,0,1,1]]
//        rows1_1    =  [], [1], [1,2], [1], [2]
//        columns1_1 =  [2,1], [1], [2], [1]
//        validateNonogram(matrix1, rows1_1, columns1_1) => True
//
//        Example solution matrix:
//        matrix1 ->
//        row
//        +------------+     instructions
//        | 1  1  1  1 | <-- []
//        | 0  1  1  1 | <-- [1]
//        | 0  1  0  0 | <-- [1,2]
//        | 1  1  0  1 | <-- [1]
//        | 0  0  1  1 | <-- [2]
//        +------------+
//        ^  ^  ^  ^
//        |  |  |  |
//        column       [2,1] | [2] |
//        instructions      [1]   [1]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nonogram {
    public static boolean isValid(int[][] matrix, List<List<Integer>> rows, List<List<Integer>> cols){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            if(!rows.get(i).equals(parseRow(matrix, i))){
                return false;
            }
        }
        for(int i = 0; i < n; i++){
            if(!cols.get(i).equals(parseCol(matrix, i))){
                return false;
            }
        }
        return true;
    }
    private static List<Integer> parseRow(int[][] matrix, int i){
        List<Integer> res = new ArrayList<>();
        int n = matrix[0].length;

        for(int j = 0; j < n; j++){
            int count = 0;
            while(j < n && matrix[i][j] == 0){
                count++;
                j++;
            }
            if(count != 0){
                res.add(count);
            }
        }
        return res;
    }
    private static List<Integer> parseCol(int[][] matrix, int j){
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;

        for(int i = 0; i < m; i++){
            int count = 0;
            while(i < m && matrix[i][j] == 0){
                count++;
                i++;
            }
            if(count != 0){
                res.add(count);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1,1},{0,1,1,1},{0,1,0,0},{1,1,0,1},{0,0,1,1}};
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(new ArrayList<>());
        rows.add(Arrays.asList(1));
        rows.add(Arrays.asList(1,2));
        rows.add(Arrays.asList(1));
        rows.add(Arrays.asList(2));
//        for(int i = 0; i < 5; i++){
//            System.out.println(rows.get(i));
//        }
        List<List<Integer>> cols = new ArrayList<>();
        cols.add(Arrays.asList(2,1));
        cols.add(Arrays.asList(1));
        cols.add(Arrays.asList(2));
        cols.add(Arrays.asList(1));

        System.out.println(isValid(matrix, rows,cols));// true
    }
}
