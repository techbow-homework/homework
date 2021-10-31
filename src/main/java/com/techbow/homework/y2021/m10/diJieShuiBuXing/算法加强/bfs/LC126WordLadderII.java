package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;


import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * Example 2:
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= beginWord.length <= 5
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 1000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 */

//TODO

/**
 * word ladder 2
 *
 * 差别主要是：
 *
 * 1.要用一个 map<String，List<String>>来记录边
 *
 * 2.有一个层的visited set，当到这层结束的时候才完全移除这层被visited的。因为同样的点有空能从不同的path被摸到，而这两个path都是有效的最短边。如果一遇到就移除了，就会漏解，因为答案是要all possible short est path
 *
 * 1. covert出来的下一层有三个状态：
 * 1.之前在别的层已经被vistied了，所以没有在dict里；
 * 2.这层被visted过了，所以需要保存边，但是不需要进queue；
 * 3.这层第一次被visit，常规做法+记边
 *
 */
public class LC126WordLadderII {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String, List<String>> graph = new HashMap<>();
        dict.remove(beginWord);
        boolean isOver = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();//为了保留每层被visited过的，在每层遍历完以后再删除，不然会漏解；因为答案要的是shortest所有的comb
//分层，需要保留每层被visited过的
            while (size-- > 0) {

                String cur = queue.poll();
                char[] chars = cur.toCharArray();

// convert
                for (int i = 0; i < chars.length; i++) {
                    char origin = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j != origin) {
                            chars[i] = j;
                            String next = String.valueOf(chars); // neighbor有三种情况，dict里没有，这层visited过，这层还没有visited；
                            if (endWord.equals(next)) {
                                isOver = true;
                            }
                            if (!dict.contains(next)) {//dict里没有
                                continue;
                            }
                            if (levelVisited.add(next)) { // 如果在这一层之前没有遍历过，则入queue；如果这层被遍历过，不能入queue两次，但是需要保留边在图里；
                                queue.offer(next);
                            }
                            // 无论这层又没有遍历过，都需要把边保留在graph里，因为答案需要all shortest paths
                            List<String> neigbors = graph.getOrDefault(cur, new ArrayList<>());
                            neigbors.add(next);
                            graph.put(cur, neigbors);

                        }
                    }
                    chars[i] = origin;
                }
            }
            dict.removeAll(levelVisited);
            if (isOver) {
                List<String> path = new ArrayList<>();
                path.add(beginWord);
                recoverPath(graph,beginWord, endWord,path,res);//dfs还原路径
                return res;
            }
        }
        return res;
    }


    private static void recoverPath(Map<String, List<String>> graph, String beginWord, String endWord, List<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            List<String> list = new ArrayList<>(path);
            res.add(list);
            return;
        }

        List<String> neigbors = graph.get(beginWord);
        if(neigbors!=null) {
            for (String nei : neigbors) {
                path.add(nei);
                recoverPath(graph, nei, endWord, path, res);
                path.remove(nei);
            }
        }
    }

    private static void dfs(List<List<String>> res, String cur, String end, Map<String, HashSet<String>> graph, List<String> path) {

        if (cur.equals(end)) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (graph.get(cur) != null) {
            for (String next : graph.get(cur)) {
                path.add(0, next);
                dfs(res, next, end, graph, path);
                path.remove(0);
            }
        }
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] array = new String[]{"hot","dot","dog","lot","log","cog"};
      System.out.println(  findLadders(begin, end, Arrays.asList(array)));
    }
}
