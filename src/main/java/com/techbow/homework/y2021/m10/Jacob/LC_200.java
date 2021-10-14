package com.techbow.homework.y2021.m10.Jacob;

public class LC_200 {
    public int numIslands(char[][] grid) {
        int count = 0; //Number of island
        for (int i = 0; i< grid.length; i++) { //traversing the row
            for(int j = 0; j< grid[i].length; j++) {
                if(grid[i][j] == '1') { //traversing the column
                    count +=1; //increasing the island count
                    calldfs(grid, i, j);
                }
            }
        }
        return count; //returning the number of island
    }
    public void calldfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        calldfs(grid, i+1 , j);//up
        calldfs(grid, i-1, j); //down
        calldfs(grid, i , j-1);//left
        calldfs(grid, i , j+1);//right
    }
}
