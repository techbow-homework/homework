package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationPalindromes {
    //private static List<String> res = new ArrayList<>();
    public static String[] generatePalindromes(String charactersSet) {
        int n = charactersSet.length();
//        Map<Character, Integer> m = new HashMap<>();
//        for(int i = 0; i < n; i++){
//            char cur = charactersSet.charAt(i);
//            int temp = m.getOrDefault(cur, 0);
//            m.put(cur, temp +1);
//        }
//        if(m.keySet().size() == 1) return new String[]{charactersSet};
        List<String> res = new ArrayList<>();
        findAll(charactersSet, "", res);
        List<String> ret = new ArrayList<>();
        for(String s : res){
            if (isPal(s)) {
                ret.add(s);
            }
        }
        System.out.println(ret);
        return ret.toArray(new String[ret.size()]);
    }

     private static void findAll(String characterSet, String cur, List<String> res){ // choose or not char at i to add to cur as current result, until all chars used up.
        if(characterSet.length() == 0){
            res.add(cur);
            return;
        }
         Set<Character> curChars = new HashSet<>();
        for(int i = 0; i < characterSet.length(); i++){
            char c = characterSet.charAt(i);
            if(curChars.contains(c)){
                continue;
            }
            curChars.add(c);
            String next = characterSet.substring(0, i) + characterSet.substring(i + 1);
            findAll(next, cur +  c,  res);
        }
    }

    private static boolean isPal(String s){
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcba";
        String s2 = "aaabb";
        String s3 = "aaaaaaaaaabb";
        generatePalindromes(s);
        generatePalindromes(s2);
        generatePalindromes(s3);
    }
}
// time O(n!/(\pi_i n_i!)   i stands for distinct chars, n_i stands for number of i chars.
// space O(n), depth of n