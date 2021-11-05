package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid rooms initialized with these three possible values.
 *
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 * Example 2:
 *
 * Input: rooms = [[-1]]
 * Output: [[-1]]
 * Example 3:
 *
 * Input: rooms = [[2147483647]]
 * Output: [[2147483647]]
 * Example 4:
 *
 * Input: rooms = [[0]]
 * Output: [[0]]
 */

// 将门都加进queue，暂定minDIs然后后面check看到底是什么
// 只要不越界，不是门，不是墙的 都加进queue 然后标记为当前最短minDis
// 这层做完的时候要更新minDis
public class LC286WallsAndGates {

    private static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void wallsAndGates(int[][] rooms) {
        if( rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0){
            return;//throw exception
        }

        int row = rooms.length, col = rooms[0].length;
        int minDis = 1; //check
        Queue<Integer> queue = new LinkedList<>();
        loadGates(queue,rooms);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Integer cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                //covert
                for(int[] dir:DIRECTIONS){
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    // convert 的条件
                    if( ii >= 0 && ii < row && jj >= 0 && jj < col){
                        if(rooms[ii][jj] != -1 && rooms[ii][jj] != 0 && rooms[ii][jj] == Integer.MAX_VALUE){
                            rooms[ii][jj] = minDis;
                            queue.offer(ii * col + jj);
                        }
                    }
                }
            }
            minDis++;
        }
    }

    private static void loadGates(Queue<Integer> queue, int[][] rooms) {
        int col = rooms[0].length;
        for(int i = 0 ; i < rooms.length; i++){
            for(int j = 0 ; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    queue.offer(i * col + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        wallsAndGates(rooms);
    }
}
