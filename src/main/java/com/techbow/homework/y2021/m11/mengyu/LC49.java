package com.techbow.homework.y2021.m11.mengyu;

import java.util.*;
public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //find anagram for each word
        Map<String, List> answer = new HashMap<String, List>();
        for (String s : strs) {
            char[] sChar = s.toCharArray();
            Arrays.sort(sChar);
            String key = String.valueOf(sChar);
            if (!answer.containsKey(key)) {
                answer.put(key, new ArrayList());
            }
            answer.get(key).add(s);
        }
        return new ArrayList(answer.values());
    }
}
