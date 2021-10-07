package com.techbow.homework.y2021.m09.cma;

public class LC320 {
    class Solution {
        public List<String> generateAbbreviations(String word) {
            List<String> res = new ArrayList<>();
            dfs(res, new StringBuilder(), word, 0, 0);
            return res;
        }
        private void dfs(List<String> res, StringBuilder path, String word, int idx, int cnt){
            int len = word.length();
            int pathLen = path.length();
            if(idx == len){
                if(cnt > 0){
                    path.append(cnt);
                    res.add(path.toString());
                    path.setLength(pathLen);
                } else{
                    res.add(path.toString());
                }
                return;

            }

            dfs(res, path, word, idx + 1, cnt + 1);

            if(cnt > 0){
                path.append(cnt);
            }
            path.append(word.charAt(idx));
            dfs(res,path, word,idx+1, 0);
            path.setLength(pathLen);
        }
    }
}
