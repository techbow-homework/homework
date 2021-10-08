package com.techbow.homework.y2021.m09.cma;

public class LC301 {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            int[] rm = checkMinRemovePara(s);
            HashSet<String> res = new HashSet<>();
            dfs(res, new StringBuilder(), s, 0, rm[0], rm[1], 0);
            return new ArrayList<String>(res);
        }
        private void dfs(Set<String> res, StringBuilder path, String str, int idx, int rmL, int rmR, int delta){
            int strLen = str.length();
            if(idx == strLen && delta == 0 && rmL == 0 && rmR == 0){
                res.add(path.toString());
                return;
            }
            if(idx >= strLen || delta < 0 || rmL <0 || rmR < 0){
                return;
            }

            char ch = str.charAt(idx);
            int pathLen = path.length();
            if(ch == '('){
                dfs(res, path, str, idx+1, rmL - 1, rmR, delta);
                dfs(res, path.append('('), str, idx+1, rmL, rmR, delta + 1);
                path.setLength(pathLen);
            } else if (ch == ')'){
                dfs(res, path, str, idx+1, rmL, rmR - 1, delta);
                dfs(res, path.append(')'), str, idx+1, rmL, rmR, delta - 1);
                path.setLength(pathLen);
            } else{
                dfs(res, path.append(ch), str, idx+1, rmL, rmR, delta);
                path.setLength(pathLen);
            }
        }
        private int[] checkMinRemovePara(String str){
            int rmL = 0, rmR = 0;
            for(char ch: str.toCharArray()){
                if(ch == '('){
                    rmL ++;
                } else if (ch == ')'){
                    if(rmL > 0){
                        rmL--;
                    } else{
                        rmR ++;
                    }
                }
            }
            return new int[]{rmL, rmR};
        }
    }
}
