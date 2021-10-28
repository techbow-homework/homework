package com.techbow.homework.y2021.m10.eva.Code;
import com.techbow.homework.y2021.m10.mengyu;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC127_wordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if (beginWord == null || endWord == null || wordList == null) return - 1;

        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int minDis = 1;

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char cc[] = cur.toCharArray();
                for (int i = 0; i < cc.length; i++){
                    char temp = cc[i];
                    for (char c = 'a'; c <= 'z'; c++){
                        cc[i] = c;
                        String str = String.valueOf(cc);
                        if (c != temp && wordSet.contains(str)){
                            if (str.equals(endWord)) return minDis + 1;

                            queue.offer(str);
                            wordSet.remove(str);
                        }
                    }
                    cc[i] = temp;
                }
            }
            minDis++;
        }
        return 0;
    }
}
