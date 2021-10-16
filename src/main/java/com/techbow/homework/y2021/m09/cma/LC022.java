package com.techbow.homework.y2021.m09.cma;
import java.util.*;
public class LC022 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            int delta = 0;
            dfs(res, new StringBuilder(), n, delta);
            return res;
        }
        private void dfs(List<String> res, StringBuilder path, int n, int delta){
            if (path.length() == 2*n){
                if(delta == 0){
                    res.add(path.toString());
                }
                return;
            }
            if (delta < 0){
                return;
            }
            int len = path.length();
            path.append("(");
            dfs(res, path, n , delta + 1);
            path.setLength(len);

            path.append(")");
            dfs(res, path, n , delta - 1);
            path.setLength(len);

        }
    }
}
