package com.techbow.homework.y2021.m10.zekun;

import java.util.*;

public class LC0417_BFS_update {

    public static void main(String[] args){
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        LC0417_BFS_update sol = new LC0417_BFS_update();
        List<List<Integer>> res = sol.pacificAtlantic(heights);
        System.out.println(res);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //cc
        if(heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) return new ArrayList<List<Integer>>();

        int nrow = heights.length;
        int ncol = heights[0].length;
        Queue<List<Integer>> queue = new LinkedList<>();
        boolean[][] pacificVisited = new boolean[nrow][ncol];
        boolean[][] atlanticVisited = new boolean[nrow][ncol];
        List<List<Integer>> result = new ArrayList<>();

        loadPacific(heights, queue, pacificVisited);
        //bfs
        bfs(heights, queue, result, pacificVisited, atlanticVisited);

        loadAtlantic(heights, queue, atlanticVisited);
        //bfs
        bfs(heights, queue, result, atlanticVisited, pacificVisited);

        return result;
    }

    private void bfs(int[][] matrix, Queue<List<Integer>> que, List<List<Integer>> res, boolean[][] self, boolean[][] other){
        int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int nrow = matrix.length, ncol = matrix[0].length;
        while(!que.isEmpty()){
            int size = que.size();
            for(int k = 0; k < size; k++){
                List<Integer> cur = que.poll();
                int i = cur.get(0);
                int j = cur.get(1);
                if(other[i][j]) res.add(Arrays.asList(i,j));
                for(int dir[] : DIRECTIONS){
                    int ii = i + dir[0], jj = j + dir[1];
                    if(ii >= 0 && ii < nrow && jj >= 0 && jj < ncol && !self[ii][jj] && matrix[i][j] <= matrix[ii][jj]){
                        List<Integer> next = new ArrayList<>();
                        next.add(ii);
                        next.add(jj);
                        que.offer(next);
                        self[ii][jj] = true;
                    }
                }
            }
        }
    }

    private void loadPacific(int[][] matrix, Queue<List<Integer>> que, boolean[][] visited){
        int nrow = matrix.length, ncol = matrix[0].length;
        for(int i = 0; i < ncol; i++){
            List<Integer> toadd = new ArrayList<>();
            toadd.add(0);
            toadd.add(i);
            que.offer(toadd);
            visited[0][i] = true;
        }
        for(int j = 1; j < nrow; j++){
            List<Integer> toadd = new ArrayList<>();
            toadd.add(j);
            toadd.add(0);
            que.offer(toadd);
            visited[j][0] = true;
        }
    }

    private void loadAtlantic(int[][] matrix, Queue<List<Integer>> que, boolean[][] visited){
        int nrow = matrix.length, ncol = matrix[0].length;
        for(int i = 0; i < ncol-1; i++){
            List<Integer> toadd = new ArrayList<>();
            toadd.add(nrow - 1);
            toadd.add(i);
            que.offer(toadd);
            visited[nrow - 1][i] = true;
        }
        for(int j = 0; j < nrow; j++){
            List<Integer> toadd = new ArrayList<>();
            toadd.add(j);
            toadd.add(ncol - 1);
            que.offer(toadd);
            visited[j][ncol - 1] = true;
        }
    }

    public static class LC0216_DFS_CombinationSumIII {
        public static void main(String[] args){
            LC0216_DFS_CombinationSumIII obj = new LC0216_DFS_CombinationSumIII();
            int k = 3;
            int n = 7;
            List<List<Integer>> sol = obj.combinationSum3(3,7);
            System.out.println(sol);
        }
        private List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            //cc
            if(n <= 0 || k == 0) return res;

            List<Integer> path = new ArrayList<Integer>();
            dfsHelper(n, k, 0, 0, 1, res, path);
            return res;
        }

        private void dfsHelper(int target, int k, int kIndex, int sum, int curNum, List<List<Integer>> res, List<Integer> path){
            //success + fail base case
            if(sum == target && kIndex == k) {
                List<Integer> copy = new ArrayList<Integer>(path);//deep copy
                res.add(copy);
                return;
            }else if(sum > target || kIndex >= k){
                return;
            }
            //visited? no need
            //fencha
            for(int i = curNum; i <= 9; i++){
                sum += i;
                path.add(i);
                dfsHelper(target, k, kIndex + 1, sum, i + 1, res, path);
                sum -= i;
                path.remove(path.size() - 1);
            }

        }
    }
}
