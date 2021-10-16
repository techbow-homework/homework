package com.techbow.homework.y2021.m09.cma;
import java.util.*;
public class LC139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0){
                return false;
            }

            int len = s.length();

            Boolean mem[] = new Boolean[len+1];
            return dfs(s, wordDict, 0, mem);
        }

        private boolean dfs(String str, List<String> dict, int idx, Boolean[] mem){
            int len = str.length();
            if(idx == len){
                return true;
            }
            if(mem[idx] != null){
                return mem[idx];
            }

            for(int i = idx ; i <  len; i ++){
                String word = str.substring(idx,i + 1);
                if(dict.contains(word)){
                    if(dfs(str, dict, i+1, mem)){
                        mem[idx] = true;
                        return true;
                    }
                }
            }
            mem[idx] = false;
            return false;
        }
    }
}
