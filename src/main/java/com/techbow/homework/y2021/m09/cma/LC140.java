package com.techbow.homework.y2021.m09.cma;

public class LC140 {
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> res = new ArrayList<String>();
            dfs(res, new StringBuilder(), s, 0, wordDict);
            return res;
        }
        private void dfs(List<String> res, StringBuilder path, String str, int idx, List<String> wordDict){
            int len = str.length();
            if(idx == len){
                res.add(path.toString());
                return;
            }
            // if(!mem[idx]){
            //     return;
            // }
            int pathLen = path.length();
            for(int i = idx; i <= len; i ++){
                String word = str.substring(idx,i);
                if(wordDict.contains(word)){
                    if (pathLen == 0){
                        path.append(word);
                    } else {
                        path.append(' ' + word);
                    }

                    dfs(res, path, str, i, wordDict);
                    path.setLength(pathLen);
                }
            }
        }
    }
}
