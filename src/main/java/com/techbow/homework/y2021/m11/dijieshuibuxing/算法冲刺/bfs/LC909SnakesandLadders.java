package com.techbow.homework.y2021.m11.dijieshuibuxing.算法冲刺.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.



Example 1:


Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation:
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
Example 2:

Input: board = [[-1,-1],[-1,3]]
Output: 1


Constraints:

n == board.length == board[i].length
2 <= n <= 20
grid[i][j] is either -1 or in the range [1, n2].
The squares labeled 1 and n2 do not have any ladders or snakes.
 */
public class LC909SnakesandLadders {



    //  因为需要 board上的val来到达下一个值，所以我们直接用每个格子的val来进queue
    // 每次convert neighbor的时候返回next的 x y index，然后再check 值和visited，来进入queue
    public int snakesAndLadders(int[][] board) {
        //cc

        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n*n+1];
        visited[1] = true;
        int res = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0) {
                int cur = queue.poll();
                if(cur == n*n){
                    return res;
                }

                for (int i = 1; i <= Math.min(n * n - cur, 6); i++) {
                    int val = cur + i;
                    int[] next = convert(board,val);
                    int x = next[0], y = next[1];
                    if(board[x][y] != -1){
                        val = board[x][y];
                    }
                    if(visited[val]) continue;
                    queue.offer(val);
                    visited[val] = true;
                }
            }
            res++;

        }
        return -1;
    }

    private int[] convert(int[][] board, int val) {
        int n = board.length;
        int r = (val - 1 ) / n, c = (val-1) %n; // 推回index， 但 x要是反相减掉的，y是要根据r来确认左右起点的
        int x = n - 1 -r, y = r % 2 == 0 ? c : n - c -1; //根据 r 的单双数，来判断 c的左右起点
        return new int[]{x,y};
    }
}
