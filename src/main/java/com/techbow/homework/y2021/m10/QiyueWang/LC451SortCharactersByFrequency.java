package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC451SortCharactersByFrequency {
    public static String frequencySort(String s) {
        //System.out.println((char)('a'-4));
        int n = s.length();
        StringBuilder res = new StringBuilder();
        int[] chars = new int[128];
        for(int i = 0; i < n; i++){
            char cur = s.charAt(i);
            chars[(int) cur] ++;
        }
        List<Character>[] freq = new ArrayList[n + 1];
        for(int i = 0; i < 127; i++){
            int f = chars[i];
            if(f != 0){
                if(freq[f] == null){
                    freq[f] = new ArrayList<Character>();
                }
                freq[f].add((char) i);
            }
        }
        for(int i = n; i >= 0; i--){
            if(freq[i] != null){
                //System.out.println(freq[i].toString());
                for(char c : freq[i]){
                    for(int j = 0; j < i; j++){
                        //System.out.println(freq[i].toString()+" : "+ j);
                        res.append(c);
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "tree";
        String s2 = "Aabb";
        System.out.println(frequencySort(s1));
        System.out.println(frequencySort(s2));
    }
}
//time O(N) space O(N)
