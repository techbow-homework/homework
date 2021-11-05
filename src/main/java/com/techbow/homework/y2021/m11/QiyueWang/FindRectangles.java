package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// find all rectangles of 0s, in the form of top left corner (i, j, width, height). All rectangles are separated by 1s
public class FindRectangles {
    public static List<int[]> find(int[][] board){
        // CC
        int m = board.length;
        int n = board[0].length;
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    int[] cur = new int[4];
                    cur[0] = i;
                    cur[1] = j;
                    int width = 1;
                    while(j + width < n && board[i][j + width] == 0){
                        width++;
                    }
                    int length = 1;
                    while (i + length < m && board[i + length][j] == 0){
                        length++;
                    }
                    cur[2] = width;
                    cur[3] = length;
                    for(int r = i; r < i + length; r++){
                        for (int c = j; c < j + width; c++){
                            board[r][c] = -1;
                        }
                    }
                    res.add(cur);
                }
            }
        }
        for(int[] r : res){
            System.out.println(Arrays.toString(r));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{1,0,0,0},{1,0,0,0},{0,1,1,1}};
        find(board);
    }
}
