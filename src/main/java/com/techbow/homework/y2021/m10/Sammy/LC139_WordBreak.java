package com.techbow.homework.y2021.m10.Sammy;

import java.util.*;

public class LC139_WordBreak {
    //dp solution
    public boolean wordBreak(String s, List<String> wordDict){
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            dp[i] = false;
            for(int j = 0; j < i; j++){
                String cur = s.substring(j,i);
                if(wordDict.contains(cur) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    //dfs solution
    public boolean wordBreak_(String s, List<String> wordDict){
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        Map<Integer, Boolean> found = new HashMap<>();
        Set<String> dict = new HashSet<>(wordDict);
        boolean ans = dfs(s,found, dict, 0);
        return ans;
    }
    private boolean dfs(String s, Map<Integer, Boolean> found, Set<String> dict, int start){
        if(start == s.length()) return true;
        if(found.containsKey(start)){
            return found.get(start);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(dict.contains(sb.toString())){
                if(dfs(s, found, dict, i + 1)){
                    found.put(start, true);
                    return true;
                }
            }
        }
        found.put(start, false);
        return false;
    }
}
