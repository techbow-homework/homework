package com.techbow.homework.y2021.m10.MelodySong;

import java.util.*;

public class LC_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return -1;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                String cur = queue.poll();
                Set<String> neibors = getNeiborWords(cur, wordSet);
                for (String nei : neibors) {
                    if (nei.equals(endWord)) {
                        return level + 1;
                    }
                    queue.offer(nei);
                    wordSet.remove(nei);
                }
            }
        }
        return 0;
    }

    private Set<String> getNeiborWords(String word, Set<String> wordSet) {
        Set<String> neiborWords = new HashSet<>();
        char[] cc = word.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            char temp = cc[i];
            for (char c = 'a'; c <= 'z'; c++) {
                cc[i] = c;
                String str = String.valueOf(cc);
                if (c!= temp && wordSet.contains(str)) {
                    neiborWords.add(str);
                }
            }
            cc[i] = temp;
        }
        return neiborWords;
    }
}
