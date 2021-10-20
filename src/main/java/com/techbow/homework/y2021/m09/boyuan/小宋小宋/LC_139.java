package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (result[j] && set.contains(s.substring(j, i))) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }
}
