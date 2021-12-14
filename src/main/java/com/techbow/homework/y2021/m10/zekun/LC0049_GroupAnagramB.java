package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0049_GroupAnagramB {
    public class groupAnagram(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(int i = 0; i < str.length(); i++){
                count[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 26; j++){
                if(count[j] != 0){
                    sb.append((char)('a' + j)).append(count[j]);
                }
            }
            String chStr = sb.toString();
            List<String> anagramList = map.getOrDefault(chStr, new ArrayList<String>());
            anagramList.add(str);
            map.put(chStr, anagramList);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
