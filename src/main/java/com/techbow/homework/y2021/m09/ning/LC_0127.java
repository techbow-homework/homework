package com.techbow.homework.y2021.m09.ning;

public class LC_0127 {
    // S1: one direction
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return -1;

        HashSet<String> wordSet = new HashSet<>();
        for (String word: wordList) {
            wordSet.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordList.remove(beginWord);
        int minLen = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] cc = cur.toCharArray();
                for (int i = 0; i < cc.length; i++) {
                    char temp = cc[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cc[i] = c;
                        String str = String.valueOf(cc);
                        if (c != temp && wordSet.contains(str)) {
                            if (str.equals(endWord)) return minLen + 1;
                            queue.offer(str);
                            wordSet.remove(str);
                        }
                    }
                    cc[i] = temp;
                }
            }
            minLen++;
        }
        return 0;
    }
    // S2: two directions
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (beginWord == null || endWord == null || wordList == null) return -1;
//        // this step is to create a new dict to be able to remove visited ones
//        HashSet<String> wordSet = new HashSet<>();
//        for (String word : wordList) {
//            wordSet.add(word);
//        }
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//
//        // build two buffer sets
//        HashSet<String> beginSet = new HashSet<>();
//        HashSet<String> endSet = new HashSet<>();
//        beginSet.add(beginWord);
//        endSet.add(endWord);
//
//        int minDistance = 1;
//        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
//            if (beginSet.size() > endSet.size()) {
//                HashSet<String> tempQue = beginSet;
//                beginSet = endSet;
//                endSet = tempQue;
//            }
//
//            HashSet<String> nextLevel = new HashSet<String>();
//            for (String cur : beginSet) {
//                char cc[] = cur.toCharArray();
//                for (int i = 0; i < cc.length; i++) {
//                    char temp = cc[i];
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        String str = String.valueOf(cc);
//                        if (endSet.contains(str)) return minDistance + 1;
//                        if (c != temp && wordSet.contains(str)) {
//                            nextLevel.add(str);
//                            wordSet.remove(str);
//                        }
//                    }
//                    cc[i] = temp;
//                }
//            }
//            beginSet = nextLevel;
//            minDistance++;
//        }
//        return 0;
//    }
}
