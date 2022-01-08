package com.techbow.homework.y2021.m10.ryanxu.LC_1306;

public class LC_1306 {

    private int len;

    public boolean canReach(int[] arr, int start) {

        if (arr == null || arr.length == 0) {
            return true;
        }

        this.len = arr.length;
        if (start >= len) {
            return false;
        }

        boolean[] visited = new boolean[len];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int idx, boolean[] visited) {

        if (arr[idx] == 0) {
            return true;
        }

        int next1 = idx + arr[idx];
        int next2 = idx - arr[idx];
        if (inArea(next1) && inArea(next2) && !visited[next1] && !visited[next2]) {
            visited[next1] = true;
            visited[next2] = true;
            boolean res = dfs(arr, next1, visited) | dfs(arr, next2, visited);
            visited[next1] = false;
            visited[next2] = false;
            return res;
        }
        if (inArea(next1) && !visited[next1]) {
            visited[next1] = true;
            boolean res = dfs(arr, next1, visited);
            visited[next1] = false;
            return res;
        }
        if (inArea(next2) && !visited[next2]) {
            visited[next2] = true;
            boolean res = dfs(arr, next2, visited);
            visited[next2]  = false;
            return res;
        }

        return false;
    }

    private boolean inArea(int next) {
        return next >= 0 && next < len;
    }
}
