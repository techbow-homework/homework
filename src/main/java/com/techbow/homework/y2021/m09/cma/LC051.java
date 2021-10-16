package com.techbow.homework.y2021.m09.cma;
import java.util.*;
public class LC051 {
    class Solution{
        public List<List<String>> solveNQueens(int n){
            List<List<String>> res = new ArrayList<List<String>>();
            List<String> path = new ArrayList<String>();
            dfs(res, path, n, 0);
            return res;
        }

        private void dfs(List<List<String>> res, List<String> path, int n, int level){
            if(path.size() == n) {
                List<String> newPath = new ArrayList<>();
                for(String str : path) {
                    newPath.add(str);
                }
                res.add(newPath);
                return;
            }

            for(int i = 0; i < n; i++){
                char[] chars = new char[n];
                for (int j  = 0; j < n; j++){
                    chars[j] = '.';
                }
                chars[i] = 'Q';
                path.add(new String(chars));

                if(isValid(path, level, i)){
                    dfs(res, path, n, level+1);
                }
                path.remove(path.size() - 1);
            }
        }
        //isValid可以用DP优化
        public boolean isValid(List<String> path, int level, int col){
            if(path == null || path.size() == 1) return true;
            for(int i = 0; i < level; i++){
                if(path.get(i).charAt(col) == 'Q') return false;
            }
            for(int i = 0; i < level; i++){
                int prevQ =path.get(i).indexOf('Q');
                if(Math.abs(prevQ - col) == level - i ) return false;
            }
            return true;
        }
    }

}
