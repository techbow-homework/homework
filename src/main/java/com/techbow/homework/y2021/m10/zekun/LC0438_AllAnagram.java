package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;

public class LC0438_AllAnagram {
    public List<Integer> allAnagram(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        List<Integer> res = new ArrayList<>();
        if(len1 < len2) return res;
        char[] s1Count = new char[26];
        char[] s2Count = new char[26];

    }
}
