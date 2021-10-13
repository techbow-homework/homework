package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC140_WordBreak {
    public List<String> wordBreakII(String s, List<String> wordDict) {
        //cc
        if(s.length() == 0 || wordDict == null || wordDict.size() == 0) return new ArrayList<>();
        HashSet<String> dict = new HashSet<>();
        for(String e: wordDict){
            dict.add(e);
        }
        List<String> res = new ArrayList<>();
        dfs(res, s, new StringBuilder(), dict, 0);
        return res;
    }
    private void dfs(List<String> res, String s, StringBuilder sb, HashSet<String> dict, int idx){
        int len = s.length();
        //successful base case
        if(idx == len){
            res.add(sb.toString());
            return;
        }

        for(int i = idx + 1; i <= len; i++){
            String str = s.substring(idx,i);
            if(dict.contains(str)){
                int lenPath = sb.length();
                if(lenPath == 0){
                    sb.append(str);
                } else {
                    sb.append(" " + str);
                }
                dfs(res, s, sb, dict, i);
                sb.setLength(lenPath);
            }
        }
    }
}
