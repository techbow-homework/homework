package com.techbow.homework.y2021.m10.thomasxu;

public class L32 {
    //DFS:
    int top, bottom, left, right;
    public int minArea(char[][] image, int x, int y) {
        if(image==null|| image.length==0|| image[0].length == 0) return 0;
        top=bottom =  x;
        left=right=y;
        dfs(image, x,y);
        return (right-left)*(bottom-top);
    }
    private void dfs(char[][] image, int x, int y){
        if(x<0 || y <0 || x>=image.length || y >= image[0].length || image[x][y] == '0'){
            return;
        }
        image[x][y]='0';
        top = Math.min(top, x);
        bottom = Math.max(bottom, x+1);
        left = Math.min(y,  left);
        right = Math.max(y+1, right);
        dfs(image, x+1, y);
        dfs(image, x, y+1);
        dfs(image, x, y-1);
        dfs(image, x-1, y);

    }
    //binary search

}
