package com.techbow.homework.y2021.m10.Sammy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//shortest transformation sequence from beginWord to endWord
public class LC127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if(beginWord == null || endWord == null ||beginWord.length() != endWord.length() || wordList == null || wordList.size() == 0){
            return 0;
        }
        HashSet<String> dict = new HashSet<>();
        for(String a: wordList){
            dict.add(a);
        }

        Queue<String> queue = new LinkedList<>();
        //guarantee beginWord is in the wordList
        queue.offer(beginWord);
        dict.remove(beginWord);
        int len = 1;//check later
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String cur = queue.poll();
                char[] convert = cur.toCharArray();
                for(int i = 0; i < convert.length; i++){
                    char temp = convert[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == temp) continue;
                        convert[i] = c;
                        String next = String.valueOf(convert);
                        if(dict.contains(next)) {
                            if (next.equals(endWord)) {
                                return len + 1;
                            }
                            queue.offer(next);
                            dict.remove(next);
                        }
                    }
                    convert[i] = temp;
                }
            }
            len++;
        }
        return 0;
    }
}
