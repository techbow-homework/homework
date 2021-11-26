package com.techbow.homework.y2021.m11.shengyuan;

import java.util.*;

public class LC_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        //cc
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortedKey = sortString(str);
            List<String> list = map.get(sortedKey);
            if (list == null) {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(sortedKey, newList);
            } else {
                list.add(str);
            }
        }
        for (String entry : map.keySet()) {
            res.add(map.get(entry));
        }
        return res;
    }
    private String sortString(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
    public static void main(String[] args) {
        LC_49 test = new LC_49();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = test.groupAnagrams(input);
        System.out.println(res);
    }
}
