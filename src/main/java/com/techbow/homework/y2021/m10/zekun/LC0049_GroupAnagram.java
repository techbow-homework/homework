package com.techbow.homework.y2021.m10.zekun;

import java.util.*;

public class LC0049_GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strings){
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            List<String> strList = map.getOrDefault(key, new ArrayList<String>());
            strList.add(str);
            map.put(key, str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}


