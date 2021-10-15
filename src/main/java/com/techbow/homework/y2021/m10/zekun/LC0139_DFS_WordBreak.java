package com.techbow.homework.y2021.m10.zekun;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC0139_DFS_WordBreak {
    public static void main(String[] args){
        LC0139_DFS_WordBreak sol = new LC0139_DFS_WordBreak();
        String s = "catsandog";
        List<String> dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean res = sol.wordBreak(s, dict);
        System.out.println(res);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        //cc
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size()==0) return false;
        Set<String> dictionary = new HashSet<>(wordDict);
        Boolean mem[] = new Boolean[s.length() +1];
        return dfs(s, 0, dictionary, mem);
    }
    private boolean dfs(String str, int index, Set<String> dict, Boolean[] mem){
        int strLen = str.length();
        if(index == strLen){
            return true;
        }
        if(mem[index] != null) return mem[index];

        for(int i = index ; i < strLen; i++){
            String curStr = str.substring(index, i + 1);
            if(dict.contains(curStr)){
                if(dfs(str, i+1, dict, mem)){
                    mem[index] = true;
                    return true;
                }
            }
        }
        mem[index] = false;
        return mem[index];
    }
}
