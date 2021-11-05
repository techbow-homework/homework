package com.techbow.homework.y2021.m09.WooWooLily;
import java.util.*;
public class LC_286 {

    public void wallsAndGates(int[][] rooms) {
        //corner case
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;

        int[][] dirs = {{-1,0},{1,0}, {0,-1},{0,1}};

        //rows and cols
        int rows = rooms.length;
        int cols = rooms[0].length;


        // traverse through matrix from a gate layer by layer/ neighbors, for each neighbor of room, set new distance as 1, and if not, we do nothing to them, add this point to the queue for next processing point, after first added group is processed, finish this loop and add 1 to distance before processing next group

        //add all starting zeros/gates
        Queue<Integer> q = new LinkedList<>();
        //addGates(rooms,q);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(i*cols + j);
                }
            }
        }
        int minLen = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0) {
                int curr = q.poll();

                //find all adjacent neighbors in row, col

                for (int[] dir : dirs) {
                    int r = curr / cols + dir[0];
                    int c = curr % cols + dir[1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols && rooms[r][c] == Integer.MAX_VALUE) {
                        q.offer(r * cols + c);
                        rooms[r][c] = minLen;

                    }

                }


            }

            minLen++;
        }

    }

//time complexity: mxn (has to search all point
    // space complexity: depends on queuesize, we insert atmost mxn points

}
