package com.techbow.homework.y2021.m10.ryanxu.LC_1178;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0 || puzzles == null || puzzles.length == 0) {
            return res;
        }

        // 将word sort合并重复的字符和相同的word
        HashMap<Integer, Integer> word2Count = new HashMap<>();
        for (String word : words) {
            int mask = bitmask(word);
            word2Count.put(mask, word2Count.getOrDefault(mask, 0) + 1);
        }

        // count the number of valid word for each puzzle
        for (String p : puzzles) {
            int firstChar = 1 << (p.charAt(0) - 'a');
            int count = word2Count.getOrDefault(firstChar, 0);
            int puzzleMask = bitmask(p.substring(1));
            for (int submask = puzzleMask; submask > 0; submask = (submask - 1) & puzzleMask) {
                count += word2Count.getOrDefault(submask | firstChar, 0);
            }
            res.add(count);
        }

        return res;
    }

    private int bitmask(String word) {

        int mask = 0;
        for (char ch : word.toCharArray()) {
            mask |= 1 << (ch - 'a');
        }

        return mask;
    }

    public static void main(String[] args) {
        LC_1178 lc_1178 = new LC_1178();
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(lc_1178.findNumOfValidWords(words, puzzles));
    }
}
