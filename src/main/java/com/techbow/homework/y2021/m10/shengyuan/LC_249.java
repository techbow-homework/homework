package com.techbow.homework.y2021.m10.shengyuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_249 {
    public List<List<String>> groupStrings(String[] Strings) {
        List<List<String>> result = new ArrayList<>();
        if (Strings == null) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : Strings) {
            String base = conversion(str);
            if (!map.containsKey(base)) {
                map.put(base, new ArrayList<>());
            }
            map.get(base).add(str);
        }
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
    private String conversion(String str) {
        char[] array = str.toCharArray();
        int shift = array[0] - 'a';
        for (int i = 0; i < array.length; i++) {
            array[i] = (char)((array[i] - shift) % 26);         //每一次shift是一樣的
        }
        return new String(array);
    }

    public static void main(String[] args) {
        LC_249 test = new LC_249();
        String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z"};
        List<List<String>> result = test.groupStrings(strings);
        System.out.println(result);
    }
}
