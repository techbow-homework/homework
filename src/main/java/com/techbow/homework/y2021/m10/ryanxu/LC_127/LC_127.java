package com.techbow.homework.y2021.m10.ryanxu.LC_127;

import java.util.*;

public class LC_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord == null || endWord == null) {
            return 0;
        }

        // list -> hashset
        HashSet<String> dictionary = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        int distance = 1;
        int len = beginWord.length();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] curWord = cur.toCharArray();
                for (int i = 0; i < len; i++) {
                    char curLetter = curWord[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (curLetter != c) {
                            curWord[i] = c;
                            String nextWord = String.valueOf(curWord);
                            if (dictionary.contains(nextWord)) {
                                if (nextWord.equals(endWord)) {
                                    return distance + 1;
                                }
                                queue.add(nextWord);
                                dictionary.remove(nextWord);
                            }
                        }
                        curWord[i] = curLetter;
                    }
                }
            }
            distance++;
        }

        return 0;
    }

    public static void main(String[] args) {
        LC_127 lc_127 = new LC_127();
        String begin = "hit";
        String end = "cog";
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(lc_127.ladderLength(begin, end, list));
    }
}
