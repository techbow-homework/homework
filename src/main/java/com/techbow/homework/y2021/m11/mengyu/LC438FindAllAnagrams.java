package com.techbow.homework.y2021.m11.mengyu;

import java.util.*;

public class LC438FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        List<Character> charsList = new ArrayList<>();
        pToList(p, charsList);
        Set<String> permutationList = new HashSet<>();
        findPermutation(charsList, permutationList, 0);
        lookForTheSame(chars, p, res, permutationList);
        return res;
    }
    private void lookForTheSame (char[] chars, String p, List<Integer> res, Set<String> permutationList) {
        int pLength = p.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int counter = i; counter < pLength - 1; counter++) {

                sb.append(chars[counter]);
                String oneRes = sb.toString();
                if (permutationList.contains(oneRes)) {
                    res.add(i);
                    sb.delete(0, sb.length() - 1);
                }
            }
        }
    }

    private void findPermutation(List<Character> charsList, Set<String> permutationRes, int level) {
        if (level == charsList.size() - 1) {
            StringBuilder sb = new StringBuilder();
            for (char chars : charsList) {
                sb.append(chars);
            }
            permutationRes.add(sb.toString());
        }
        for (int i = level; i < charsList.size(); i++) {
            Collections.swap(charsList, i, level);
            findPermutation(charsList, permutationRes, level + 1);
            Collections.swap(charsList, i, level);
        }
    }
    private List<Character> pToList(String p, List<Character> charsList) {
        char[] chars = p.toCharArray();
        for (char c : chars) {
            charsList.add(c);
        }
        return charsList;
    }
}
