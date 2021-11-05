package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;


import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 */
public class LC127WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue  = new LinkedList<>();
        queue.offer(beginWord);

        int res = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
                String cur = queue.poll();


                List<String> nexts = convert(cur,dict);
                for(String next:nexts){
                    if(endWord.equals(next)){
                        return res +1;
                    }
                    queue.offer(next);
                    dict.remove(next);
                }

            }

            res++;
        }
        return 0;
    }

    private List<String> convert(String cur, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for(int i = 0; i < chars.length; i ++) {
            char o = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if(c != o ){
                    chars[i] = c;
                    String next = String.valueOf(chars);
                    if(dict.contains(next)){
                        res.add(next);
                    }

                }
            }
            chars[i] = o ;
        }
        return res;
    }

    public static int ladderLength_biDirection(String beginWord, String endWord, List<String> wordList) {
        //cc

        Set<String> dict = new HashSet<>(wordList);

        if(!dict.contains(endWord)){
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int res = 1;

        while(!beginSet.isEmpty() && !endSet.isEmpty()){

            if(beginSet.size()>endSet.size()){ //保证每次beginset永远都是size最小的那个
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginSet) {
                char[] cur = word.toCharArray();
                for (int i = 0; i < cur.length; i++) {
                    char origin = cur[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if(j != origin){
                            cur[i] = j;
                            String converted = String.valueOf(cur);
                            if(endSet.contains(converted)){
                                return res +1;
                            }

                            if(dict.contains(converted)){
                                nextLevelSet.add(converted);
                                dict.remove(converted);
                            }
                        }
                    }
                    cur[i] = origin;
                    }
                }
            beginSet = nextLevelSet;
            res++;
        }
        return 0;
    }

    public static void main(String[] args) {
        ladderLength_biDirection("hit","cog",Arrays.asList("hot","dot","dog","lot","log"));
    }
}
