package com.techbow.homework.y2021.m09.cma;

public class LC131 {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<List<String>>();
            if(s == null| s.length() == 0){
                return res;
            }
            List<String> path = new ArrayList<String>();

            int len = s.length();
            boolean[] mem = new boolean[len+1];
            for(int i = 0; i < len+1; i ++){
                mem[i] = true;
            }
            boolean[][] isPal = new boolean[len][len];

            for(int i = 0; i < len; i++ ){
                isPal[i][i] = true;
                for(int j = i-1; j>=0; j--){
                    isPal[j][i] = (s.charAt(j) == s.charAt(i)) && (j == i -1 || isPal[j+1][i-1]);
                }
            }
            dfs(res,path,s,0,mem, isPal);
            return res;

        }
        private void dfs(List<List<String>> res, List<String> path, String s, int idx, boolean[] mem, boolean[][] isPal){
            int len = s.length();
            if(idx == len){
                // res.add(path.toString())
                List<String> temp = new ArrayList<String>(path);
                res.add(temp);
                return;
            }
            int curSize = res.size();
            // int pathLen = path.size();
            for(int i = idx; i < len; i ++ ){
                if(isPal[idx][i] && mem[i+1]){
                    String word = s.substring(idx, i+1);
                    path.add(word);
                    dfs(res, path, s, i+1 ,mem, isPal);
                    path.remove(path.size()-1);
                }
            }
            if(curSize == res.size()){
                mem[idx] = false;
            }

        }
    }
}
