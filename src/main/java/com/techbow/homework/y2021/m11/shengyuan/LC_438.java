package com.techbow.homework.y2021.m11.shengyuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_438 {
    public List<Integer> findAllAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        //cc
        if (s.length() == 0) {
            return res;
        }
        if (p.length() > s.length()) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        //traverse pattern and record in the hashmap
        for (char c : p.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        int match = 0;
        //traverse entire string
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            Integer count = map.get(temp);
            //expand right bound of the sliding windows
            if (count != null) {
                map.put(temp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            //adjust leftmost sliding window
            if (i >= p.length()) {
                temp = s.charAt(i - p.length());
                count = map.get(temp);
                if (count != null) {
                    map.put(temp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            //if match is equal to map.size(), add to the res
            if (match == map.size()) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        LC_438 test = new LC_438();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = test.findAllAnagrams(s, p);
        System.out.println(result);
    }
}
