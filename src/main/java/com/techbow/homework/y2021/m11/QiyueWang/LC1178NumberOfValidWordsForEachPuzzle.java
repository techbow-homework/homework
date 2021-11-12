package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1178NumberOfValidWordsForEachPuzzle {
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordCount = new HashMap<>();
        for(String s : words){
            int smask = bitmask(s);
            int temp = wordCount.getOrDefault(smask, 0);
            wordCount.put(smask, temp + 1);
        }
        List<Integer> res = new ArrayList<>(0);
        for(int i = 0; i < puzzles.length; i++){
            char first = puzzles[i].charAt(0);
            int firstNum =  1 << (first - 'a');
            int count = wordCount.getOrDefault(firstNum, 0); // initialize count of words with first char only
            // from the second char
            int pmask = bitmask(puzzles[i].substring(1));
            for(int submask = pmask; submask > 0; submask = (submask - 1) & pmask ){// (submask - 1) & pmask will eliminate one '1' from submask
                count += wordCount.getOrDefault(firstNum | submask, 0);
            }
            res.add(count);
        }
        return res;
    }
    private static int bitmask(String s){ // turn unique chars into 1 in the bitmask to get a unique number for each word
        int mask = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            mask |= 1 << (c - 'a');
        }
        return mask;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(findNumOfValidWords(words, puzzles));//[1,1,3,2,4,0]
    }
}
// time O(m*|w| + n*2^7) space O(m) for the map
